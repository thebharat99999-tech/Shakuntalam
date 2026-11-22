package com.example.data.remote

import android.content.Context
import android.util.Log
import androidx.annotation.Keep
import com.example.R
import com.google.firebase.Firebase
import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.auth
import com.google.firebase.firestore.DocumentId
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.Exclude
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.IgnoreExtraProperties
import com.google.firebase.firestore.ServerTimestamp
import com.google.firebase.firestore.snapshots
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.tasks.await
import java.util.UUID

/**
 * Supported subscription plan tiers stored in Firestore (`/subscriptions/{userId}`)
 * for gating access to the Paid Test Series features (20 FLT + 20 Sectional + 10 PYQ per exam).
 */
enum class SubscriptionPlanTier(
    val planCode: String,
    val priceInr: Long,
    val durationDays: Int,
    val planNameEn: String,
    val planNameHi: String
) {
    NONE(
        planCode = "NONE",
        priceInr = 0L,
        durationDays = 0,
        planNameEn = "Free Tier",
        planNameHi = "फ्री प्लान"
    ),
    MONTHLY_9(
        planCode = "MONTHLY_9",
        priceInr = 9L,
        durationDays = 30,
        planNameEn = "Shakuntalam Monthly All-Access Pass (₹9/Month)",
        planNameHi = "शकुंतलम मासिक पास (₹9/माह • 30 दिन)"
    ),
    YEARLY_99(
        planCode = "YEARLY_99",
        priceInr = 99L,
        durationDays = 365,
        planNameEn = "Shakuntalam Yearly All-Access Pass (₹99/Year)",
        planNameHi = "शकुंतलम वार्षिक पास (₹99/वर्ष • 365 दिन)"
    ),
    LIFETIME_399(
        planCode = "LIFETIME_399",
        priceInr = 399L,
        durationDays = 3650,
        planNameEn = "Shakuntalam Lifetime All-Access Pass (₹399)",
        planNameHi = "शकुंतलम लाइफटाइम पास (₹399 • आजीवन)"
    );

    val durationMillis: Long
        get() = durationDays.toLong() * 24L * 60L * 60L * 1000L

    companion object {
        fun fromCodeOrPrice(raw: String): SubscriptionPlanTier {
            return when (raw.trim().uppercase()) {
                "LIFETIME_399", "LIFETIME", "399", "₹399" -> LIFETIME_399
                "YEARLY_99", "YEARLY", "ANNUAL", "99", "₹99" -> YEARLY_99
                "MONTHLY_9", "MONTHLY", "9", "₹9" -> MONTHLY_9
                "NONE", "FREE", "0", "" -> NONE
                else -> MONTHLY_9
            }
        }

        fun fromPriceInr(amountInr: Int): SubscriptionPlanTier {
            return when (amountInr) {
                399 -> LIFETIME_399
                99 -> YEARLY_99
                9 -> MONTHLY_9
                else -> NONE
            }
        }
    }
}

@Keep
@IgnoreExtraProperties
data class FirestoreUserSubscription(
    @DocumentId @get:DocumentId val id: String = "",
    val userId: String = "",
    val planCode: String = "NONE",
    val planName: String = "Free Plan",
    val priceInr: Long = 0L,
    val status: String = "EXPIRED",
    val active: Boolean = false,
    val startEpochMillis: Long = 0L,
    val expiryEpochMillis: Long = 0L,
    val receiptNumber: String = "",
    @ServerTimestamp @get:ServerTimestamp val createdAt: Timestamp? = null,
    @ServerTimestamp @get:ServerTimestamp val updatedAt: Timestamp? = null
) {
    @Exclude
    fun resolvedPlanTier(): SubscriptionPlanTier = SubscriptionPlanTier.fromCodeOrPrice(planCode)

    @Exclude
    fun isCurrentlyActive(nowMillis: Long = System.currentTimeMillis()): Boolean {
        return active &&
                status == "ACTIVE" &&
                planCode in setOf("MONTHLY_9", "YEARLY_99", "LIFETIME_399") &&
                expiryEpochMillis > nowMillis
    }

    @Exclude
    fun remainingDays(nowMillis: Long = System.currentTimeMillis()): Int {
        if (!isCurrentlyActive(nowMillis)) return 0
        val diffMillis = (expiryEpochMillis - nowMillis).coerceAtLeast(0L)
        val dayMillis = 24L * 60L * 60L * 1000L
        return ((diffMillis + dayMillis - 1L) / dayMillis).toInt().coerceAtLeast(1)
    }
}

@Keep
@IgnoreExtraProperties
data class FirestoreStudentProfile(
    @DocumentId @get:DocumentId val id: String = "",
    val userId: String = "",
    val studentName: String = "",
    val targetExam: String = "",
    val authMethod: String = "GOOGLE",
    val totalPoints: Long = 0L,
    val testsAttempted: Long = 0L,
    val averageAccuracy: Long = 0L,
    val streakDays: Long = 0L,
    val accountSetupCompleted: Boolean = false,
    @ServerTimestamp @get:ServerTimestamp val createdAt: Timestamp? = null,
    @ServerTimestamp @get:ServerTimestamp val updatedAt: Timestamp? = null
)

@Keep
@IgnoreExtraProperties
data class FirestoreTestAttempt(
    @DocumentId @get:DocumentId val id: String = "",
    val userId: String = "",
    val testId: String = "",
    val testTitle: String = "",
    val examCategory: String = "",
    val score: Long = 0L,
    val totalQuestions: Long = 1L,
    val accuracyPercent: Long = 0L,
    @ServerTimestamp @get:ServerTimestamp val createdAt: Timestamp? = null,
    @ServerTimestamp @get:ServerTimestamp val updatedAt: Timestamp? = null
)

class StudentAuthAndProfileRepository(
    private val db: FirebaseFirestore,
    private val auth: FirebaseAuth = Firebase.auth
) {
    constructor(context: Context) : this(
        FirebaseFirestore.getInstance(
            context.applicationContext.getString(R.string.firestore_database_id)
        ),
        Firebase.auth
    )

    fun currentUser(): FirebaseUser? = auth.currentUser

    fun currentUserId(): String? = auth.currentUser?.uid

    fun signInWithGoogleIdToken(
        idToken: String,
        onSuccess: (FirebaseUser) -> Unit,
        onError: (String) -> Unit
    ) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnSuccessListener { authResult ->
                val user = authResult.user
                if (user != null) {
                    onSuccess(user)
                } else {
                    onError("Google Sign-In succeeded but returned no Firebase user.")
                }
            }
            .addOnFailureListener { exception ->
                Log.e(TAG, "Firebase Google credential sign-in failed", exception)
                onError(exception.localizedMessage ?: "Firebase Google Sign-In failed")
            }
    }

    fun signOut() {
        auth.signOut()
    }

    suspend fun saveOrUpdateStudentProfile(
        studentName: String,
        targetExam: String,
        authMethod: String = "GOOGLE",
        totalPoints: Long = 0L,
        testsAttempted: Long = 0L,
        averageAccuracy: Long = 0L,
        streakDays: Long = 0L,
        accountSetupCompleted: Boolean = true,
        existingCreatedAt: Timestamp? = null
    ): Result<String> = runCatching {
        val uid = checkNotNull(auth.currentUser?.uid) { "User must be authenticated to save student profile" }
        val sanitizedName = studentName.trim().ifBlank { "Shakuntalam Student" }.take(80)
        val sanitizedExam = targetExam.trim().ifBlank { "IIT JEE (Main & Advanced)" }.take(80)
        val validAuthMethod = if (authMethod in setOf("GOOGLE", "PHONE_OTP", "EMAIL_OTP")) authMethod else "GOOGLE"
        val docRef = db.collection(COLLECTION_STUDENTS).document(uid)

        try {
            val payload = FirestoreStudentProfile(
                userId = uid,
                studentName = sanitizedName,
                targetExam = sanitizedExam,
                authMethod = validAuthMethod,
                totalPoints = totalPoints.coerceIn(0L, 1_000_000L),
                testsAttempted = testsAttempted.coerceIn(0L, 100_000L),
                averageAccuracy = averageAccuracy.coerceIn(0L, 100L),
                streakDays = streakDays.coerceIn(0L, 10_000L),
                accountSetupCompleted = accountSetupCompleted,
                createdAt = existingCreatedAt,
                updatedAt = null
            )
            docRef.set(payload).await()
            uid
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            handleFirestoreError(e, OperationType.WRITE, docRef.path)
            throw e
        }
    }

    suspend fun getStudentProfile(
        userId: String = checkNotNull(auth.currentUser?.uid) { "User must be authenticated" }
    ): Result<FirestoreStudentProfile?> = runCatching {
        val docRef = db.collection(COLLECTION_STUDENTS).document(userId)
        try {
            val snapshot = docRef.get().await()
            if (snapshot.exists()) {
                snapshot.toObject(
                    FirestoreStudentProfile::class.java,
                    DocumentSnapshot.ServerTimestampBehavior.ESTIMATE
                )
            } else {
                null
            }
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            handleFirestoreError(e, OperationType.GET, docRef.path)
            throw e
        }
    }

    fun observeStudentProfile(
        userId: String = checkNotNull(auth.currentUser?.uid) { "User must be authenticated" }
    ): Flow<FirestoreStudentProfile?> {
        return db.collection(COLLECTION_STUDENTS).document(userId)
            .snapshots()
            .map { snapshot ->
                if (snapshot.exists()) {
                    snapshot.toObject(
                        FirestoreStudentProfile::class.java,
                        DocumentSnapshot.ServerTimestampBehavior.ESTIMATE
                    )
                } else {
                    null
                }
            }
    }

    suspend fun recordTestAttempt(
        testId: String,
        testTitle: String,
        examCategory: String,
        score: Long,
        totalQuestions: Long,
        accuracyPercent: Long
    ): Result<String> = runCatching {
        val uid = checkNotNull(auth.currentUser?.uid) { "User must be authenticated to record test attempt" }
        val attemptId = "attempt_${UUID.randomUUID().toString().replace("-", "").take(20)}"
        val docRef = db.collection(COLLECTION_STUDENTS)
            .document(uid)
            .collection(SUBCOLLECTION_TEST_ATTEMPTS)
            .document(attemptId)

        val record = FirestoreTestAttempt(
            userId = uid,
            testId = testId.trim().ifBlank { "mock_test" }.take(120),
            testTitle = testTitle.trim().ifBlank { "Mock Test" }.take(200),
            examCategory = examCategory.trim().ifBlank { "General" }.take(80),
            score = score.coerceIn(-1000L, 10000L),
            totalQuestions = totalQuestions.coerceIn(1L, 500L),
            accuracyPercent = accuracyPercent.coerceIn(0L, 100L),
            createdAt = null,
            updatedAt = null
        )

        try {
            docRef.set(record).await()
            attemptId
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            handleFirestoreError(e, OperationType.CREATE, docRef.path)
            throw e
        }
    }

    suspend fun getTestAttempts(
        userId: String = checkNotNull(auth.currentUser?.uid) { "User must be authenticated" }
    ): Result<List<FirestoreTestAttempt>> = runCatching {
        val colRef = db.collection(COLLECTION_STUDENTS)
            .document(userId)
            .collection(SUBCOLLECTION_TEST_ATTEMPTS)
        try {
            val querySnap = colRef.get().await()
            querySnap.toObjects(
                FirestoreTestAttempt::class.java,
                DocumentSnapshot.ServerTimestampBehavior.ESTIMATE
            )
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            handleFirestoreError(e, OperationType.LIST, colRef.path)
            throw e
        }
    }

    fun observeTestAttempts(
        userId: String = checkNotNull(auth.currentUser?.uid) { "User must be authenticated" }
    ): Flow<List<FirestoreTestAttempt>> {
        return db.collection(COLLECTION_STUDENTS)
            .document(userId)
            .collection(SUBCOLLECTION_TEST_ATTEMPTS)
            .snapshots()
            .map { querySnapshot ->
                querySnapshot.toObjects(
                    FirestoreTestAttempt::class.java,
                    DocumentSnapshot.ServerTimestampBehavior.ESTIMATE
                )
            }
    }

    // --- Firestore Subscription Management (`/subscriptions/{userId}`) ---

    fun observeUserSubscription(
        userId: String = checkNotNull(auth.currentUser?.uid) { "User must be authenticated" }
    ): Flow<FirestoreUserSubscription?> {
        return db.collection(COLLECTION_SUBSCRIPTIONS).document(userId)
            .snapshots()
            .map { snapshot ->
                if (snapshot.exists()) {
                    snapshot.toObject(
                        FirestoreUserSubscription::class.java,
                        DocumentSnapshot.ServerTimestampBehavior.ESTIMATE
                    )
                } else {
                    null
                }
            }
    }

    suspend fun getUserSubscription(
        userId: String = checkNotNull(auth.currentUser?.uid) { "User must be authenticated" }
    ): Result<FirestoreUserSubscription?> = runCatching {
        val docRef = db.collection(COLLECTION_SUBSCRIPTIONS).document(userId)
        try {
            val snapshot = docRef.get().await()
            if (snapshot.exists()) {
                snapshot.toObject(
                    FirestoreUserSubscription::class.java,
                    DocumentSnapshot.ServerTimestampBehavior.ESTIMATE
                )
            } else {
                null
            }
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            handleFirestoreError(e, OperationType.GET, docRef.path)
            throw e
        }
    }

    suspend fun saveOrActivateSubscription(
        planTier: SubscriptionPlanTier,
        receiptNumber: String = "SUB-${System.currentTimeMillis()}",
        nowMillis: Long = System.currentTimeMillis(),
        existingCreatedAt: Timestamp? = null
    ): Result<FirestoreUserSubscription> = runCatching {
        val uid = checkNotNull(auth.currentUser?.uid) { "User must be authenticated to save subscription in Firestore" }
        require(planTier != SubscriptionPlanTier.NONE) { "Cannot activate NONE subscription tier" }

        val startMs = nowMillis.coerceIn(0L, 9_999_999_999_999L)
        val expiryMs = (startMs + planTier.durationMillis).coerceIn(0L, 9_999_999_999_999L)
        val cleanReceipt = receiptNumber.trim().ifBlank { "SUB-$startMs" }.take(120)
        val cleanPlanName = planTier.planNameEn.take(120)
        val docRef = db.collection(COLLECTION_SUBSCRIPTIONS).document(uid)

        val subscription = FirestoreUserSubscription(
            id = uid,
            userId = uid,
            planCode = planTier.planCode,
            planName = cleanPlanName,
            priceInr = planTier.priceInr,
            status = "ACTIVE",
            active = true,
            startEpochMillis = startMs,
            expiryEpochMillis = expiryMs,
            receiptNumber = cleanReceipt,
            createdAt = existingCreatedAt,
            updatedAt = null
        )

        try {
            if (existingCreatedAt != null) {
                docRef.update(
                    mapOf(
                        "planCode" to subscription.planCode,
                        "planName" to subscription.planName,
                        "priceInr" to subscription.priceInr,
                        "status" to subscription.status,
                        "active" to subscription.active,
                        "startEpochMillis" to subscription.startEpochMillis,
                        "expiryEpochMillis" to subscription.expiryEpochMillis,
                        "receiptNumber" to subscription.receiptNumber,
                        "updatedAt" to FieldValue.serverTimestamp()
                    )
                ).await()
            } else {
                val payload = mapOf(
                    "userId" to uid,
                    "planCode" to subscription.planCode,
                    "planName" to subscription.planName,
                    "priceInr" to subscription.priceInr,
                    "status" to subscription.status,
                    "active" to subscription.active,
                    "startEpochMillis" to subscription.startEpochMillis,
                    "expiryEpochMillis" to subscription.expiryEpochMillis,
                    "receiptNumber" to subscription.receiptNumber,
                    "createdAt" to FieldValue.serverTimestamp(),
                    "updatedAt" to FieldValue.serverTimestamp()
                )
                docRef.set(payload).await()
            }
            subscription
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            handleFirestoreError(e, OperationType.WRITE, docRef.path)
            throw e
        }
    }

    suspend fun expireUserSubscription(
        userId: String = checkNotNull(auth.currentUser?.uid) { "User must be authenticated" }
    ): Result<Unit> = runCatching {
        val uid = checkNotNull(auth.currentUser?.uid) { "User must be authenticated" }
        check(uid == userId) { "Signed-in user does not match subscription owner" }
        val docRef = db.collection(COLLECTION_SUBSCRIPTIONS).document(uid)

        try {
            docRef.update(
                mapOf(
                    "planCode" to "NONE",
                    "planName" to "Free Plan",
                    "priceInr" to 0L,
                    "status" to "EXPIRED",
                    "active" to false,
                    "startEpochMillis" to 0L,
                    "expiryEpochMillis" to 0L,
                    "updatedAt" to FieldValue.serverTimestamp()
                )
            ).await()
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            handleFirestoreError(e, OperationType.UPDATE, docRef.path)
            throw e
        }
    }

    // --- Firestore Quiz Test Data Management (`/students/{userId}/quiz_tests/{testId}`) ---

    fun observeQuizTestDocument(
        userId: String = checkNotNull(auth.currentUser?.uid) { "User must be authenticated" },
        testId: String
    ): Flow<FirestoreQuizTestDocument?> {
        val cleanTestId = testId.trim().replace(Regex("[^a-zA-Z0-9_\\-]"), "_").ifBlank { "default_quiz" }.take(120)
        return db.collection(COLLECTION_STUDENTS)
            .document(userId)
            .collection(SUBCOLLECTION_QUIZ_TESTS)
            .document(cleanTestId)
            .snapshots()
            .map { snapshot ->
                if (snapshot.exists()) {
                    snapshot.toObject(
                        FirestoreQuizTestDocument::class.java,
                        DocumentSnapshot.ServerTimestampBehavior.ESTIMATE
                    )
                } else {
                    null
                }
            }
    }

    fun observeUserQuizTests(
        userId: String = checkNotNull(auth.currentUser?.uid) { "User must be authenticated" }
    ): Flow<List<FirestoreQuizTestDocument>> {
        return db.collection(COLLECTION_STUDENTS)
            .document(userId)
            .collection(SUBCOLLECTION_QUIZ_TESTS)
            .snapshots()
            .map { querySnap ->
                querySnap.toObjects(
                    FirestoreQuizTestDocument::class.java,
                    DocumentSnapshot.ServerTimestampBehavior.ESTIMATE
                )
            }
    }

    suspend fun getQuizTestDocument(
        userId: String = checkNotNull(auth.currentUser?.uid) { "User must be authenticated" },
        testId: String
    ): Result<FirestoreQuizTestDocument?> = runCatching {
        val cleanTestId = testId.trim().replace(Regex("[^a-zA-Z0-9_\\-]"), "_").ifBlank { "default_quiz" }.take(120)
        val docRef = db.collection(COLLECTION_STUDENTS)
            .document(userId)
            .collection(SUBCOLLECTION_QUIZ_TESTS)
            .document(cleanTestId)
        try {
            val snapshot = docRef.get().await()
            if (snapshot.exists()) {
                snapshot.toObject(
                    FirestoreQuizTestDocument::class.java,
                    DocumentSnapshot.ServerTimestampBehavior.ESTIMATE
                )
            } else {
                null
            }
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            handleFirestoreError(e, OperationType.GET, docRef.path)
            throw e
        }
    }

    suspend fun saveOrSyncQuizTestDocument(
        testId: String,
        examKey: String,
        titleEn: String,
        titleHi: String,
        durationMinutes: Long,
        totalMarks: Long,
        questionCount: Long,
        paidOnly: Boolean,
        existingCreatedAt: Timestamp? = null
    ): Result<FirestoreQuizTestDocument> = runCatching {
        val uid = checkNotNull(auth.currentUser?.uid) { "User must be authenticated to sync quiz test document" }
        val cleanTestId = testId.trim().replace(Regex("[^a-zA-Z0-9_\\-]"), "_").ifBlank { "default_quiz" }.take(120)
        val cleanExamKey = examKey.trim().ifBlank { "upsc" }.take(60)
        val cleanTitleEn = titleEn.trim().ifBlank { "Mock Test" }.take(200)
        val cleanTitleHi = titleHi.trim().ifBlank { cleanTitleEn }.take(200)
        val safeDuration = durationMinutes.coerceIn(1L, 360L)
        val safeMarks = totalMarks.coerceIn(1L, 2000L)
        val safeQuestionCount = questionCount.coerceIn(1L, 500L)

        val docRef = db.collection(COLLECTION_STUDENTS)
            .document(uid)
            .collection(SUBCOLLECTION_QUIZ_TESTS)
            .document(cleanTestId)

        val model = FirestoreQuizTestDocument(
            id = cleanTestId,
            userId = uid,
            testId = cleanTestId,
            examKey = cleanExamKey,
            titleEn = cleanTitleEn,
            titleHi = cleanTitleHi,
            durationMinutes = safeDuration,
            totalMarks = safeMarks,
            questionCount = safeQuestionCount,
            paidOnly = paidOnly,
            createdAt = existingCreatedAt,
            updatedAt = null
        )

        try {
            if (existingCreatedAt != null) {
                docRef.update(
                    mapOf(
                        "examKey" to model.examKey,
                        "titleEn" to model.titleEn,
                        "titleHi" to model.titleHi,
                        "durationMinutes" to model.durationMinutes,
                        "totalMarks" to model.totalMarks,
                        "questionCount" to model.questionCount,
                        "paidOnly" to model.paidOnly,
                        "updatedAt" to FieldValue.serverTimestamp()
                    )
                ).await()
            } else {
                val payload = mapOf(
                    "userId" to uid,
                    "testId" to model.testId,
                    "examKey" to model.examKey,
                    "titleEn" to model.titleEn,
                    "titleHi" to model.titleHi,
                    "durationMinutes" to model.durationMinutes,
                    "totalMarks" to model.totalMarks,
                    "questionCount" to model.questionCount,
                    "paidOnly" to model.paidOnly,
                    "createdAt" to FieldValue.serverTimestamp(),
                    "updatedAt" to FieldValue.serverTimestamp()
                )
                docRef.set(payload).await()
            }
            model
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            handleFirestoreError(e, OperationType.WRITE, docRef.path)
            throw e
        }
    }

    companion object {
        private const val TAG = "StudentAuthRepo"
        const val COLLECTION_STUDENTS = "students"
        const val SUBCOLLECTION_TEST_ATTEMPTS = "test_attempts"
        const val SUBCOLLECTION_QUIZ_TESTS = "quiz_tests"
        const val COLLECTION_SUBSCRIPTIONS = "subscriptions"
    }
}

@Keep
@IgnoreExtraProperties
data class FirestoreQuizTestDocument(
    @DocumentId @get:DocumentId val id: String = "",
    val userId: String = "",
    val testId: String = "",
    val examKey: String = "upsc",
    val titleEn: String = "",
    val titleHi: String = "",
    val durationMinutes: Long = 120L,
    val totalMarks: Long = 200L,
    val questionCount: Long = 100L,
    val paidOnly: Boolean = false,
    @ServerTimestamp @get:ServerTimestamp val createdAt: Timestamp? = null,
    @ServerTimestamp @get:ServerTimestamp val updatedAt: Timestamp? = null
)
