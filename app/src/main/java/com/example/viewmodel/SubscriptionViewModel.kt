package com.example.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.R
import com.example.data.AllIndiaMasterTestPackageData
import com.example.data.remote.FirestoreUserSubscription
import com.example.data.remote.StudentAuthAndProfileRepository
import com.example.data.remote.SubscriptionPlanTier
import com.example.ui.components.SubscriptionPassStateBridge
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

sealed interface SubscriptionCloudState {
    data object Idle : SubscriptionCloudState
    data object Loading : SubscriptionCloudState
    data class Success(val subscription: FirestoreUserSubscription?) : SubscriptionCloudState
    data class Error(val message: String) : SubscriptionCloudState
}

/**
 * UI & Gating state for the student's subscription pass (Monthly ₹9, Yearly ₹99, or Lifetime ₹399)
 * synchronized with Cloud Firestore (`/subscriptions/{userId}`).
 */
data class SubscriptionUiState(
    val userId: String? = null,
    val planCode: String = "NONE",
    val planName: String = "Free Tier",
    val priceInr: Int = 0,
    val status: String = "EXPIRED",
    val isSubscriptionActive: Boolean = false,
    val startEpochMillis: Long = 0L,
    val expiryEpochMillis: Long = 0L,
    val remainingDays: Int = 0,
    val receiptNumber: String = "",
    val isSyncedWithFirestore: Boolean = false,
    val isLoading: Boolean = false,
    val isPaidAccessBlockedModalVisible: Boolean = false,
    val blockedExamKey: String? = null,
    val blockedTestId: String? = null,
    val gatePromptEn: String? = null,
    val gatePromptHi: String? = null,
    val errorMessage: String? = null,
    val statusMessage: String? = null
) {
    /**
     * Returns true ONLY if the user has an active Monthly (₹9), Yearly (₹99), or Lifetime (₹399)
     * subscription that has not expired at [nowMillis].
     */
    fun hasActivePaidSubscription(nowMillis: Long = System.currentTimeMillis()): Boolean {
        return isSubscriptionActive &&
                status == "ACTIVE" &&
                planCode in setOf("MONTHLY_9", "YEARLY_99", "LIFETIME_399") &&
                expiryEpochMillis > nowMillis
    }

    fun resolvedPlanTier(): SubscriptionPlanTier = SubscriptionPlanTier.fromCodeOrPrice(planCode)
}

/**
 * ViewModel that checks whether a user has an active subscription status
 * (Monthly for ₹9, Yearly for ₹99, or Lifetime for ₹399) stored in Cloud Firestore (`/subscriptions/{userId}`)
 * and gates access to the 'Paid Test Series' features (20 Full-Length Tests + 20 Sectional Tests + 10 PYQs per exam).
 */
class SubscriptionViewModel(
    private val repository: StudentAuthAndProfileRepository? = null
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        SubscriptionUiState(
            userId = runCatching { repository?.currentUserId() }.getOrNull(),
            planCode = SubscriptionPassStateBridge.activePlanCode,
            planName = SubscriptionPlanTier.fromCodeOrPrice(SubscriptionPassStateBridge.activePlanCode).planNameEn,
            priceInr = SubscriptionPlanTier.fromCodeOrPrice(SubscriptionPassStateBridge.activePlanCode).priceInr.toInt(),
            status = if (SubscriptionPassStateBridge.isSubscriptionActive) "ACTIVE" else "EXPIRED",
            isSubscriptionActive = SubscriptionPassStateBridge.isSubscriptionActive,
            expiryEpochMillis = SubscriptionPassStateBridge.expiryEpochMillis,
            remainingDays = SubscriptionPassStateBridge.remainingDays
        )
    )
    val uiState: StateFlow<SubscriptionUiState> = _uiState.asStateFlow()

    private val _activeUidFlow = MutableStateFlow(runCatching { repository?.currentUserId() }.getOrNull())

    @OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
    val cloudSubscriptionState: StateFlow<SubscriptionCloudState> = _activeUidFlow
        .flatMapLatest { uid ->
            val repo = repository
            if (repo == null || uid.isNullOrBlank()) {
                emptyFlow()
            } else {
                repo.observeUserSubscription(uid)
                    .map<FirestoreUserSubscription?, SubscriptionCloudState> { firestoreSub ->
                        applyFirestoreSubscriptionSnapshot(firestoreSub)
                        SubscriptionCloudState.Success(firestoreSub)
                    }
                    .catch { error ->
                        val firestoreError = generateSequence(error) { it.cause }
                            .filterIsInstance<FirebaseFirestoreException>()
                            .firstOrNull()
                        if (firestoreError == null && error is CancellationException) throw error
                        val rootError = firestoreError ?: error
                        Log.w(TAG, "Error observing subscription from Firestore", rootError)
                        emit(SubscriptionCloudState.Error(rootError.message ?: "Failed to observe subscription status"))
                    }
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(STOP_TIMEOUT_MILLIS),
            initialValue = SubscriptionCloudState.Idle
        )

    /**
     * Refreshes the active authenticated user ID and triggers Firestore subscription observation.
     */
    fun refreshAuthenticatedUser() {
        val uid = runCatching { repository?.currentUserId() }.getOrNull()
        _activeUidFlow.value = uid
        _uiState.update { it.copy(userId = uid) }
    }

    /**
     * Applies a Firestore subscription document snapshot to [uiState] and [SubscriptionPassStateBridge],
     * automatically expiring the subscription if `expiryEpochMillis <= nowMillis`.
     */
    fun applyFirestoreSubscriptionSnapshot(
        firestoreSub: FirestoreUserSubscription?,
        nowMillis: Long = System.currentTimeMillis()
    ) {
        if (firestoreSub == null) {
            return
        }

        val isCurrentlyValid = firestoreSub.isCurrentlyActive(nowMillis)
        val hasJustExpired = firestoreSub.active && firestoreSub.expiryEpochMillis in 1..nowMillis

        if (hasJustExpired && !firestoreSub.userId.isBlank()) {
            viewModelScope.launch {
                repository?.expireUserSubscription(firestoreSub.userId)
            }
        }

        val effectivePlan = if (isCurrentlyValid) firestoreSub.resolvedPlanTier() else SubscriptionPlanTier.NONE
        val remainingDays = if (isCurrentlyValid) firestoreSub.remainingDays(nowMillis) else 0

        SubscriptionPassStateBridge.isSubscriptionActive = isCurrentlyValid
        SubscriptionPassStateBridge.activePlanCode = effectivePlan.planCode
        SubscriptionPassStateBridge.expiryEpochMillis = if (isCurrentlyValid) firestoreSub.expiryEpochMillis else 0L
        SubscriptionPassStateBridge.remainingDays = remainingDays

        _uiState.update { current ->
            current.copy(
                userId = firestoreSub.userId.ifBlank { current.userId },
                planCode = effectivePlan.planCode,
                planName = if (isCurrentlyValid) firestoreSub.planName.ifBlank { effectivePlan.planNameEn } else "Free Tier",
                priceInr = effectivePlan.priceInr.toInt(),
                status = if (isCurrentlyValid) "ACTIVE" else "EXPIRED",
                isSubscriptionActive = isCurrentlyValid,
                startEpochMillis = if (isCurrentlyValid) firestoreSub.startEpochMillis else 0L,
                expiryEpochMillis = if (isCurrentlyValid) firestoreSub.expiryEpochMillis else 0L,
                remainingDays = remainingDays,
                receiptNumber = if (isCurrentlyValid) firestoreSub.receiptNumber else "",
                isSyncedWithFirestore = true,
                isPaidAccessBlockedModalVisible = if (isCurrentlyValid) false else current.isPaidAccessBlockedModalVisible,
                errorMessage = null
            )
        }
    }

    /**
     * Fetches the user's current subscription status directly from Firestore (`/subscriptions/{userId}`)
     * and returns `Result<Boolean>` indicating whether the user has an active Paid Test Series pass.
     */
    suspend fun checkFirestoreSubscriptionStatusSuspend(
        nowMillis: Long = System.currentTimeMillis()
    ): Result<Boolean> {
        val repo = repository
        val uid = runCatching { repo?.currentUserId() }.getOrNull()
        if (repo == null || uid.isNullOrBlank()) {
            val localValid = _uiState.value.hasActivePaidSubscription(nowMillis)
            return Result.success(localValid)
        }

        _uiState.update { it.copy(isLoading = true, errorMessage = null) }
        val result = repo.getUserSubscription(uid)
        return result.fold(
            onSuccess = { firestoreSub ->
                if (firestoreSub != null) {
                    applyFirestoreSubscriptionSnapshot(firestoreSub, nowMillis)
                    _uiState.update { it.copy(isLoading = false) }
                    Result.success(firestoreSub.isCurrentlyActive(nowMillis))
                } else {
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            isSyncedWithFirestore = true
                        )
                    }
                    Result.success(_uiState.value.hasActivePaidSubscription(nowMillis))
                }
            },
            onFailure = { error ->
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = error.localizedMessage ?: "Failed to check Firestore subscription"
                    )
                }
                Result.failure(error)
            }
        )
    }

    /**
     * Activates a subscription plan (`MONTHLY_9` for ₹9, `YEARLY_99` for ₹99, or `LIFETIME_399` for ₹399),
     * persists it to Cloud Firestore (`/subscriptions/{userId}`) when authenticated,
     * and unlocks all 'Paid Test Series' features across all 14 exams.
     */
    suspend fun activateSubscriptionSuspend(
        planCodeOrPrice: String,
        receiptNumber: String = "SUB-${System.currentTimeMillis()}",
        nowMillis: Long = System.currentTimeMillis()
    ): Result<FirestoreUserSubscription> {
        val planTier = SubscriptionPlanTier.fromCodeOrPrice(planCodeOrPrice)
        if (planTier == SubscriptionPlanTier.NONE) {
            val msg = "Invalid subscription plan: $planCodeOrPrice. Choose Monthly (₹9), Yearly (₹99), or Lifetime (₹399)."
            _uiState.update { it.copy(errorMessage = msg, isLoading = false) }
            return Result.failure(IllegalArgumentException(msg))
        }

        val startMs = nowMillis
        val expiryMs = startMs + planTier.durationMillis
        val daysCount = planTier.durationDays
        val cleanReceipt = receiptNumber.trim().ifBlank { "SUB-$startMs" }

        // Update local UI & bridge state immediately for responsive gating
        SubscriptionPassStateBridge.isSubscriptionActive = true
        SubscriptionPassStateBridge.activePlanCode = planTier.planCode
        SubscriptionPassStateBridge.expiryEpochMillis = expiryMs
        SubscriptionPassStateBridge.remainingDays = daysCount

        val repo = repository
        val uid = runCatching { repo?.currentUserId() }.getOrNull()
        val optimisticModel = FirestoreUserSubscription(
            id = uid ?: "local_subscriber",
            userId = uid ?: "local_subscriber",
            planCode = planTier.planCode,
            planName = planTier.planNameEn,
            priceInr = planTier.priceInr,
            status = "ACTIVE",
            active = true,
            startEpochMillis = startMs,
            expiryEpochMillis = expiryMs,
            receiptNumber = cleanReceipt
        )

        _uiState.update {
            it.copy(
                userId = uid ?: it.userId,
                planCode = planTier.planCode,
                planName = planTier.planNameEn,
                priceInr = planTier.priceInr.toInt(),
                status = "ACTIVE",
                isSubscriptionActive = true,
                startEpochMillis = startMs,
                expiryEpochMillis = expiryMs,
                remainingDays = daysCount,
                receiptNumber = cleanReceipt,
                isPaidAccessBlockedModalVisible = false,
                blockedExamKey = null,
                blockedTestId = null,
                gatePromptEn = null,
                gatePromptHi = null,
                isLoading = uid != null,
                errorMessage = null,
                statusMessage = "${planTier.planNameEn} Activated"
            )
        }

        if (repo == null || uid.isNullOrBlank()) {
            return Result.success(optimisticModel)
        }

        // Check if document already exists in Firestore to preserve immutable createdAt
        val existingDoc = repo.getUserSubscription(uid).getOrNull()
        val writeResult = repo.saveOrActivateSubscription(
            planTier = planTier,
            receiptNumber = cleanReceipt,
            nowMillis = nowMillis,
            existingCreatedAt = existingDoc?.createdAt
        )

        return writeResult.fold(
            onSuccess = { savedSub ->
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        isSyncedWithFirestore = true,
                        statusMessage = "Saved to Firestore: ${savedSub.planName}"
                    )
                }
                Result.success(savedSub)
            },
            onFailure = { error ->
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = error.localizedMessage ?: "Failed to sync subscription to Firestore"
                    )
                }
                Result.failure(error)
            }
        )
    }

    /**
     * Non-suspending helper to activate a subscription plan and persist it to Firestore.
     */
    fun activateSubscription(
        planCodeOrPrice: String,
        receiptNumber: String = "SUB-${System.currentTimeMillis()}",
        nowMillis: Long = System.currentTimeMillis(),
        onComplete: (Result<FirestoreUserSubscription>) -> Unit = {}
    ) {
        val planTier = SubscriptionPlanTier.fromCodeOrPrice(planCodeOrPrice)
        if (planTier != SubscriptionPlanTier.NONE) {
            val expiryMs = nowMillis + planTier.durationMillis
            SubscriptionPassStateBridge.isSubscriptionActive = true
            SubscriptionPassStateBridge.activePlanCode = planTier.planCode
            SubscriptionPassStateBridge.expiryEpochMillis = expiryMs
            SubscriptionPassStateBridge.remainingDays = planTier.durationDays
            _uiState.update {
                it.copy(
                    planCode = planTier.planCode,
                    planName = planTier.planNameEn,
                    priceInr = planTier.priceInr.toInt(),
                    status = "ACTIVE",
                    isSubscriptionActive = true,
                    startEpochMillis = nowMillis,
                    expiryEpochMillis = expiryMs,
                    remainingDays = planTier.durationDays,
                    receiptNumber = receiptNumber,
                    isPaidAccessBlockedModalVisible = false,
                    gatePromptEn = null,
                    gatePromptHi = null,
                    errorMessage = null
                )
            }
        }
        viewModelScope.launch {
            val res = activateSubscriptionSuspend(planCodeOrPrice, receiptNumber, nowMillis)
            onComplete(res)
        }
    }

    /**
     * Synchronizes local subscription state (e.g. from SharedPreferences or ShakuntalamViewModel)
     * into [SubscriptionViewModel].
     */
    fun syncFromLocalState(
        planCode: String,
        startEpochMillis: Long,
        expiryEpochMillis: Long,
        isActive: Boolean,
        nowMillis: Long = System.currentTimeMillis()
    ) {
        val tier = SubscriptionPlanTier.fromCodeOrPrice(planCode)
        val isStillValid = isActive && tier != SubscriptionPlanTier.NONE && expiryEpochMillis > nowMillis
        val remDays = if (isStillValid) {
            val dayMs = 24L * 60L * 60L * 1000L
            (((expiryEpochMillis - nowMillis) + (dayMs - 1L)) / dayMs).toInt().coerceAtLeast(1)
        } else 0

        SubscriptionPassStateBridge.isSubscriptionActive = isStillValid
        SubscriptionPassStateBridge.activePlanCode = if (isStillValid) tier.planCode else "NONE"
        SubscriptionPassStateBridge.expiryEpochMillis = if (isStillValid) expiryEpochMillis else 0L
        SubscriptionPassStateBridge.remainingDays = remDays

        _uiState.update {
            it.copy(
                planCode = if (isStillValid) tier.planCode else "NONE",
                planName = if (isStillValid) tier.planNameEn else "Free Tier",
                priceInr = if (isStillValid) tier.priceInr.toInt() else 0,
                status = if (isStillValid) "ACTIVE" else "EXPIRED",
                isSubscriptionActive = isStillValid,
                startEpochMillis = if (isStillValid) startEpochMillis else 0L,
                expiryEpochMillis = if (isStillValid) expiryEpochMillis else 0L,
                remainingDays = remDays
            )
        }
    }

    /**
     * Checks whether the current subscription has expired at [nowMillis]; if expired,
     * deactivates it locally and in Firestore (`/subscriptions/{userId}`) and re-locks Paid Test Series.
     */
    fun checkAndExpireIfNeeded(nowMillis: Long = System.currentTimeMillis()): Boolean {
        val current = _uiState.value
        val hasExpired = current.expiryEpochMillis in 1..nowMillis ||
                (current.isSubscriptionActive && current.expiryEpochMillis <= nowMillis)
        if (!hasExpired) return false

        SubscriptionPassStateBridge.isSubscriptionActive = false
        SubscriptionPassStateBridge.activePlanCode = "NONE"
        SubscriptionPassStateBridge.expiryEpochMillis = 0L
        SubscriptionPassStateBridge.remainingDays = 0

        _uiState.update {
            it.copy(
                planCode = "NONE",
                planName = "Free Tier",
                priceInr = 0,
                status = "EXPIRED",
                isSubscriptionActive = false,
                startEpochMillis = 0L,
                expiryEpochMillis = 0L,
                remainingDays = 0,
                statusMessage = "Subscription expired. Paid Test Series locked."
            )
        }

        val repo = repository
        val uid = runCatching { repo?.currentUserId() }.getOrNull()
        if (repo != null && !uid.isNullOrBlank()) {
            viewModelScope.launch {
                repo.expireUserSubscription(uid)
            }
        }
        return true
    }

    /**
     * Checks if the user is allowed to access a Paid Test Series feature.
     * - Free tests (`isPaidOnly == false`) are always accessible.
     * - Paid tests (`isPaidOnly == true`, including the 20 Full-Length Tests, 20 Sectional Tests,
     *   and 10 Previous Year Papers in every exam's Paid section) require an active
     *   Monthly (₹9), Yearly (₹99), or Lifetime (₹399) subscription.
     */
    fun canAccessPaidTestSeries(
        isPaidOnly: Boolean = true,
        nowMillis: Long = System.currentTimeMillis()
    ): Boolean {
        checkAndExpireIfNeeded(nowMillis)
        if (!isPaidOnly) return true
        return _uiState.value.hasActivePaidSubscription(nowMillis)
    }

    /**
     * Gates access to a specific exam's Paid Test Series item (`examKey`, `testId`).
     * - Looks up the test entry in `AllIndiaMasterTestPackageData.getExamPackageEntries(examKey)`.
     * - If the test is in the Paid section (`isPaidOnly == true`) and the user does NOT have an active
     *   subscription (`MONTHLY_9`, `YEARLY_99`, or `LIFETIME_399`), blocks access, updates the gate state,
     *   invokes [onAccessDenied], and returns `false`.
     * - Otherwise invokes [onAccessGranted] and returns `true`.
     */
    fun gatePaidTestSeriesAccess(
        examKey: String,
        testId: String = "",
        nowMillis: Long = System.currentTimeMillis(),
        onAccessGranted: () -> Unit = {},
        onAccessDenied: (recommendedPlanCode: String) -> Unit = {}
    ): Boolean {
        checkAndExpireIfNeeded(nowMillis)
        val entries = AllIndiaMasterTestPackageData.getExamPackageEntries(examKey)
        val matchedEntry = if (testId.isNotBlank()) {
            entries.firstOrNull {
                it.id.equals(testId, ignoreCase = true) ||
                        it.mockTest.testId.equals(testId, ignoreCase = true)
            }
        } else {
            null
        }
        val requiresSubscription = matchedEntry?.isPaidOnly ?: true

        if (requiresSubscription && !_uiState.value.hasActivePaidSubscription(nowMillis)) {
            val promptEn = "Paid Test Series Locked: Subscribe to Monthly (₹9), Yearly (₹99), or Lifetime (₹399) Pass to unlock all 50 Paid Tests (20 FLT + 20 Sectional + 10 PYQ)."
            val promptHi = "पेड टेस्ट सीरीज़ लॉक है: सभी 50 पेड टेस्ट (20 फुल लेंथ + 20 सेक्शनल + 10 PYQ) अनलॉक करने के लिए ₹9 मासिक, ₹99 वार्षिक या ₹399 लाइफटाइम पास चुनें।"
            _uiState.update {
                it.copy(
                    isPaidAccessBlockedModalVisible = true,
                    blockedExamKey = examKey,
                    blockedTestId = testId,
                    gatePromptEn = promptEn,
                    gatePromptHi = promptHi
                )
            }
            onAccessDenied("MONTHLY_9")
            return false
        }

        _uiState.update {
            it.copy(
                isPaidAccessBlockedModalVisible = false,
                blockedExamKey = null,
                blockedTestId = null,
                gatePromptEn = null,
                gatePromptHi = null
            )
        }
        onAccessGranted()
        return true
    }

    fun dismissPaidAccessBlockedModal() {
        _uiState.update {
            it.copy(
                isPaidAccessBlockedModalVisible = false,
                blockedExamKey = null,
                blockedTestId = null
            )
        }
    }

    companion object {
        private const val TAG = "SubscriptionViewModel"
        private const val STOP_TIMEOUT_MILLIS = 5000L

        fun provideFactory(): ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val app = checkNotNull(this[APPLICATION_KEY]) {
                    "APPLICATION_KEY missing from CreationExtras"
                }
                val databaseId = app.getString(R.string.firestore_database_id)
                val db = FirebaseFirestore.getInstance(databaseId)
                SubscriptionViewModel(StudentAuthAndProfileRepository(db))
            }
        }
    }
}
