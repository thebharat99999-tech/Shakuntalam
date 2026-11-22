package com.example.data.remote

import com.example.base.FirestoreEmulatorTestBase
import com.google.firebase.firestore.FirebaseFirestoreException
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Assert.fail
import org.junit.Test

class StudentAuthAndProfileRepositoryRuleTest : FirestoreEmulatorTestBase() {

    @Test
    fun saveAndGetStudentProfile_authenticatedOwner_succeeds() = runBlocking {
        val aliceUid = signInTestUser(ALICE_EMAIL)
        val repository = StudentAuthAndProfileRepository(firestore, auth)

        val saveResult = withTimeout(DEFAULT_TIMEOUT_MS) {
            repository.saveOrUpdateStudentProfile(
                studentName = "Aarav Sharma",
                targetExam = "IIT JEE (Main & Advanced)",
                authMethod = "GOOGLE",
                totalPoints = 320L,
                testsAttempted = 4L,
                averageAccuracy = 84L,
                streakDays = 6L,
                accountSetupCompleted = true
            )
        }
        assertTrue(saveResult.isSuccess)
        assertEquals(aliceUid, saveResult.getOrThrow())

        val fetchResult = withTimeout(DEFAULT_TIMEOUT_MS) {
            repository.getStudentProfile(aliceUid)
        }
        assertTrue(fetchResult.isSuccess)
        val profile = fetchResult.getOrThrow()
        assertNotNull(profile)
        assertEquals("Aarav Sharma", profile?.studentName)
        assertEquals("IIT JEE (Main & Advanced)", profile?.targetExam)
        assertEquals(320L, profile?.totalPoints)
        assertTrue(profile?.accountSetupCompleted == true)
    }

    @Test
    fun recordAndObserveTestAttempts_authenticatedOwner_emitsRealtimeUpdates() = runBlocking {
        val aliceUid = signInTestUser(ALICE_EMAIL)
        val repository = StudentAuthAndProfileRepository(firestore, auth)

        val attemptId = withTimeout(DEFAULT_TIMEOUT_MS) {
            repository.recordTestAttempt(
                testId = "jee_main_physics_01",
                testTitle = "IIT JEE Main Physics Mock 1",
                examCategory = "IIT JEE",
                score = 88L,
                totalQuestions = 100L,
                accuracyPercent = 88L
            ).getOrThrow()
        }

        val emittedAttempts = withTimeout(FLOW_TIMEOUT_MS) {
            repository.observeTestAttempts(aliceUid).first { list ->
                list.any { it.id == attemptId }
            }
        }
        assertTrue(emittedAttempts.any { it.id == attemptId && it.score == 88L })
    }

    @Test
    fun getStudentProfile_crossUserAccess_failsWithPermissionDenied() = runBlocking {
        val aliceUid = signInTestUser(ALICE_EMAIL)
        val aliceRepo = StudentAuthAndProfileRepository(firestore, auth)
        withTimeout(DEFAULT_TIMEOUT_MS) {
            aliceRepo.saveOrUpdateStudentProfile(
                studentName = "Alice Verma",
                targetExam = "NEET UG",
                authMethod = "PHONE_OTP",
                totalPoints = 150L,
                testsAttempted = 2L,
                averageAccuracy = 78L,
                streakDays = 3L,
                accountSetupCompleted = true
            ).getOrThrow()
        }

        signInTestUser(BOB_EMAIL)
        val bobRepo = StudentAuthAndProfileRepository(firestore, auth)
        val crossReadResult = withTimeout(DEFAULT_TIMEOUT_MS) {
            bobRepo.getStudentProfile(aliceUid)
        }
        assertTrue(crossReadResult.isFailure)
        val exception = crossReadResult.exceptionOrNull()?.unwrapFirestoreException()
        assertNotNull("Expected FirebaseFirestoreException", exception)
        assertEquals(FirebaseFirestoreException.Code.PERMISSION_DENIED, exception?.code)
    }

    @Test
    fun observeTestAttempts_unauthenticatedUser_failsWithPermissionDenied() = runBlocking {
        val aliceUid = signInTestUser(ALICE_EMAIL)
        auth.signOut()
        val repository = StudentAuthAndProfileRepository(firestore, auth)

        try {
            withTimeout(FLOW_TIMEOUT_MS) {
                repository.observeTestAttempts(aliceUid).first()
            }
            fail("Expected exception for unauthenticated user observing test attempts")
        } catch (e: Exception) {
            val firestoreException = checkNotNull(e.unwrapFirestoreException()) {
                "Expected nested FirebaseFirestoreException, got $e"
            }
            assertEquals(FirebaseFirestoreException.Code.PERMISSION_DENIED, firestoreException.code)
        }
    }

    private companion object {
        const val ALICE_EMAIL = "alice_shakuntalam@test.com"
        const val BOB_EMAIL = "bob_shakuntalam@test.com"
        const val DEFAULT_TIMEOUT_MS = 5000L
        const val FLOW_TIMEOUT_MS = 3000L
    }
}
