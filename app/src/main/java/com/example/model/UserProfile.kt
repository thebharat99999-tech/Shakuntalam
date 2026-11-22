package com.example.model

enum class AuthProviderType(val displayNameEn: String, val displayNameHi: String) {
    GOOGLE("Google Account", "गूगल खाता"),
    PHONE_OTP("Mobile Number OTP", "मोबाइल नंबर ओटीपी"),
    EMAIL_OTP("Email ID OTP", "ईमेल आईडी ओटीपी")
}

data class UserProfile(
    val id: String = "user_shak_${System.currentTimeMillis() % 100000}",
    val name: String = "Bharat Kumar",
    val email: String? = "thebharat99999@gmail.com",
    val phoneNumber: String? = "+91 9876543210",
    val provider: AuthProviderType = AuthProviderType.GOOGLE,
    val avatarLetter: String = "B",
    val targetExam: String = "UPSC Civil Services",
    val isVerified: Boolean = true,
    val isAccountSetupCompleted: Boolean = true,
    val joinedDate: String = "November 2026",
    val purchasedItemsCount: Int = 1,
    val testAttemptsCount: Int = 1
)

enum class AuthTab {
    PHONE_OTP,
    EMAIL_OTP,
    GOOGLE_SIGN_IN
}

data class PhoneOtpState(
    val phoneNumber: String = "",
    val emailAddress: String = "",
    val isOtpSent: Boolean = false,
    val otpCode: String = "",
    val generatedOtp: String = "123456",
    val timerSecondsRemaining: Int = 30,
    val isVerifying: Boolean = false,
    val errorMessage: String? = null,
    val firebaseVerificationId: String? = null,
    val isFirebaseOtpInFlight: Boolean = false,
    val firebaseAuthStatusMessage: String? = null
)

