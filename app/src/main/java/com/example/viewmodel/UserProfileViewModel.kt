package com.example.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.R
import com.example.data.remote.FirestoreStudentProfile
import com.example.data.remote.StudentAuthAndProfileRepository
import com.example.security.SecurityManager
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

sealed interface UserProfileCloudState {
    data object Idle : UserProfileCloudState
    data object Loading : UserProfileCloudState
    data class Success(val profile: FirestoreStudentProfile?) : UserProfileCloudState
    data class Error(val message: String) : UserProfileCloudState
}

data class UserProfileUiState(
    val studentName: String = "",
    val preferredExam: String = "UPSC Civil Services",
    val authMethod: String = "PHONE_OTP",
    val isSaving: Boolean = false,
    val isSavedToFirestore: Boolean = false,
    val savedFirestoreProfile: FirestoreStudentProfile? = null,
    val errorMessage: String? = null,
    val statusMessage: String? = null
)

/**
 * ViewModel managing the Student Profile setup (Student Name + Preferred Exam selection)
 * and persisting/observing the profile in Cloud Firestore (`/students/{userId}`) once authenticated.
 */
class UserProfileViewModel(
    private val repository: StudentAuthAndProfileRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(UserProfileUiState())
    val uiState: StateFlow<UserProfileUiState> = _uiState.asStateFlow()

    private val _activeUidFlow = MutableStateFlow(repository.currentUserId())

    @OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
    val cloudProfileState: StateFlow<UserProfileCloudState> = _activeUidFlow
        .flatMapLatest { uid ->
            if (uid.isNullOrBlank()) {
                emptyFlow()
            } else {
                repository.observeStudentProfile(uid)
                    .map<FirestoreStudentProfile?, UserProfileCloudState> { profile ->
                        if (profile != null) {
                            _uiState.update { current ->
                                current.copy(
                                    studentName = current.studentName.ifBlank { profile.studentName },
                                    preferredExam = profile.targetExam.ifBlank { current.preferredExam },
                                    authMethod = profile.authMethod.ifBlank { current.authMethod },
                                    isSavedToFirestore = profile.accountSetupCompleted,
                                    savedFirestoreProfile = profile
                                )
                            }
                        }
                        UserProfileCloudState.Success(profile)
                    }
                    .catch { error ->
                        val firestoreError = generateSequence(error) { it.cause }
                            .filterIsInstance<FirebaseFirestoreException>()
                            .firstOrNull()
                        if (firestoreError == null && error is CancellationException) throw error
                        val rootError = firestoreError ?: error
                        Log.w(TAG, "Error observing student profile from Firestore", rootError)
                        emit(UserProfileCloudState.Error(rootError.message ?: "Failed to observe student profile"))
                    }
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(STOP_TIMEOUT_MILLIS),
            initialValue = UserProfileCloudState.Idle
        )

    fun refreshAuthenticatedUser() {
        _activeUidFlow.value = repository.currentUserId()
    }

    fun syncInitialValues(
        studentName: String,
        preferredExam: String,
        authMethod: String = "PHONE_OTP"
    ) {
        _uiState.update { current ->
            current.copy(
                studentName = if (current.studentName.isBlank()) studentName else current.studentName,
                preferredExam = preferredExam.ifBlank { current.preferredExam },
                authMethod = authMethod.ifBlank { current.authMethod },
                errorMessage = null
            )
        }
        refreshAuthenticatedUser()
    }

    fun updateStudentName(name: String) {
        _uiState.update {
            it.copy(
                studentName = name,
                errorMessage = null
            )
        }
    }

    fun updatePreferredExam(exam: String) {
        val cleanExam = exam.trim().ifBlank { "UPSC Civil Services" }
        _uiState.update {
            it.copy(
                preferredExam = cleanExam,
                errorMessage = null
            )
        }
    }

    /**
     * Suspending function to validate and store the student's name and preferred exam in Firestore
     * once the user is authenticated.
     */
    suspend fun saveProfileToFirestoreSuspend(
        studentName: String = _uiState.value.studentName,
        preferredExam: String = _uiState.value.preferredExam,
        authMethod: String = _uiState.value.authMethod,
        totalPoints: Long = 0L,
        testsAttempted: Long = 0L,
        averageAccuracy: Long = 0L,
        streakDays: Long = 0L
    ): Result<FirestoreStudentProfile> {
        val cleanName = SecurityManager.sanitizeInput(studentName.trim())
        val cleanExam = preferredExam.trim().ifBlank { "UPSC Civil Services" }

        if (cleanName.isBlank()) {
            val msg = "कृपया अपना नाम दर्ज करें (Please enter Student Name)"
            _uiState.update { it.copy(errorMessage = msg, isSaving = false) }
            return Result.failure(IllegalArgumentException(msg))
        }

        _uiState.update {
            it.copy(
                studentName = cleanName,
                preferredExam = cleanExam,
                authMethod = authMethod,
                isSaving = true,
                errorMessage = null
            )
        }

        val uid = repository.currentUserId()
        if (uid == null) {
            val localProfile = FirestoreStudentProfile(
                id = "local_student",
                userId = "local_student",
                studentName = cleanName,
                targetExam = cleanExam,
                authMethod = authMethod,
                totalPoints = totalPoints,
                testsAttempted = testsAttempted,
                averageAccuracy = averageAccuracy,
                streakDays = streakDays,
                accountSetupCompleted = true
            )
            _uiState.update {
                it.copy(
                    isSaving = false,
                    isSavedToFirestore = false,
                    savedFirestoreProfile = localProfile,
                    statusMessage = "Profile saved ($cleanName • $cleanExam)"
                )
            }
            return Result.success(localProfile)
        }

        val existingCreatedAt = _uiState.value.savedFirestoreProfile?.createdAt
        val writeResult = repository.saveOrUpdateStudentProfile(
            studentName = cleanName,
            targetExam = cleanExam,
            authMethod = authMethod,
            totalPoints = totalPoints,
            testsAttempted = testsAttempted,
            averageAccuracy = averageAccuracy,
            streakDays = streakDays,
            accountSetupCompleted = true,
            existingCreatedAt = existingCreatedAt
        )

        return writeResult.fold(
            onSuccess = { savedUid ->
                val savedProfile = FirestoreStudentProfile(
                    id = savedUid,
                    userId = savedUid,
                    studentName = cleanName,
                    targetExam = cleanExam,
                    authMethod = authMethod,
                    totalPoints = totalPoints,
                    testsAttempted = testsAttempted,
                    averageAccuracy = averageAccuracy,
                    streakDays = streakDays,
                    accountSetupCompleted = true
                )
                _uiState.update {
                    it.copy(
                        isSaving = false,
                        isSavedToFirestore = true,
                        savedFirestoreProfile = savedProfile,
                        errorMessage = null,
                        statusMessage = "Saved to Cloud Firestore ($cleanName • $cleanExam)"
                    )
                }
                Result.success(savedProfile)
            },
            onFailure = { error ->
                _uiState.update {
                    it.copy(
                        isSaving = false,
                        errorMessage = error.localizedMessage ?: "Failed to store profile in Firestore"
                    )
                }
                Result.failure(error)
            }
        )
    }

    /**
     * UI action that validates the student's name and preferred exam selection, stores the profile
     * in Firestore if authenticated, and invokes [onSuccess] with the sanitized name and exam.
     */
    fun saveStudentProfile(
        studentName: String = _uiState.value.studentName,
        preferredExam: String = _uiState.value.preferredExam,
        authMethod: String = _uiState.value.authMethod,
        totalPoints: Long = 0L,
        testsAttempted: Long = 0L,
        averageAccuracy: Long = 0L,
        streakDays: Long = 0L,
        onSuccess: (cleanName: String, cleanExam: String) -> Unit = { _, _ -> }
    ) {
        val cleanName = SecurityManager.sanitizeInput(studentName.trim())
        val cleanExam = preferredExam.trim().ifBlank { "UPSC Civil Services" }

        if (cleanName.isBlank()) {
            _uiState.update {
                it.copy(errorMessage = "कृपया अपना नाम दर्ज करें (Please enter Student Name)")
            }
            return
        }

        // Complete UI transition immediately while persisting to Firestore in viewModelScope
        onSuccess(cleanName, cleanExam)

        viewModelScope.launch {
            saveProfileToFirestoreSuspend(
                studentName = cleanName,
                preferredExam = cleanExam,
                authMethod = authMethod,
                totalPoints = totalPoints,
                testsAttempted = testsAttempted,
                averageAccuracy = averageAccuracy,
                streakDays = streakDays
            )
        }
    }

    suspend fun fetchProfileFromFirestore(): Result<FirestoreStudentProfile?> {
        val uid = repository.currentUserId()
            ?: return Result.failure(IllegalStateException("User is not authenticated"))
        val result = repository.getStudentProfile(uid)
        result.onSuccess { profile ->
            if (profile != null) {
                _uiState.update {
                    it.copy(
                        studentName = profile.studentName,
                        preferredExam = profile.targetExam,
                        authMethod = profile.authMethod,
                        isSavedToFirestore = profile.accountSetupCompleted,
                        savedFirestoreProfile = profile
                    )
                }
            }
        }
        return result
    }

    companion object {
        private const val TAG = "UserProfileViewModel"
        private const val STOP_TIMEOUT_MILLIS = 5000L

        fun provideFactory(): ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val app = checkNotNull(this[APPLICATION_KEY]) {
                    "APPLICATION_KEY missing from CreationExtras"
                }
                val databaseId = app.getString(R.string.firestore_database_id)
                val db = FirebaseFirestore.getInstance(databaseId)
                UserProfileViewModel(StudentAuthAndProfileRepository(db))
            }
        }
    }
}
