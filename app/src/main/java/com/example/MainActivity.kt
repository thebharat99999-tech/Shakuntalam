package com.example

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ui.components.AboutShakuntalamDialog
import com.example.ui.components.DailyQuizScreen
import com.example.ui.components.DownloadAndUploadModal
import com.example.ui.components.PaymentGatewayModal
import com.example.ui.components.ShakuntalamBottomNav
import com.example.ui.components.ShakuntalamTopBar
import com.example.ui.components.UserProfileModal
import com.example.ui.screens.CartScreen
import com.example.ui.screens.ExplorerScreen
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.ItemDetailScreen
import com.example.ui.screens.LibraryScreen
import com.example.ui.screens.LoginScreen
import com.example.ui.screens.OwnerAdminPortalScreen
import com.example.ui.screens.PerformanceAnalyticsScreen
import com.example.ui.screens.ProfileScreen
import com.example.ui.screens.ReaderScreen
import com.example.ui.screens.StudentProfileSetupScreen
import com.example.ui.screens.TestSeriesScreen
import com.example.ui.theme.MyApplicationTheme
import com.example.viewmodel.AppScreen
import com.example.viewmodel.QuizViewModel
import com.example.viewmodel.ShakuntalamViewModel
import com.example.viewmodel.SubscriptionCloudState
import com.example.viewmodel.SubscriptionViewModel
import com.example.viewmodel.UserProfileViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                val context = LocalContext.current
                val quizViewModel: QuizViewModel = viewModel(
                    factory = QuizViewModel.provideFactory(context)
                )
                ShakuntalamApp(quizViewModel = quizViewModel)
            }
        }
    }
}

@Composable
fun ShakuntalamApp(
    viewModel: ShakuntalamViewModel = viewModel(),
    userProfileViewModel: UserProfileViewModel = viewModel(factory = UserProfileViewModel.provideFactory()),
    subscriptionViewModel: SubscriptionViewModel = viewModel(factory = SubscriptionViewModel.provideFactory()),
    quizViewModel: QuizViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val cloudSubscriptionState by subscriptionViewModel.cloudSubscriptionState.collectAsStateWithLifecycle()
    val subscriptionUiState by subscriptionViewModel.uiState.collectAsStateWithLifecycle()
    val snackbarHostState = remember { SnackbarHostState() }
    val context = LocalContext.current

    // Synchronize active test with QuizViewModel & Firestore /students/{userId}/quiz_tests/{testId}
    LaunchedEffect(uiState.activeTest.testId, uiState.isLoggedIn) {
        quizViewModel.loadQuizFromFirestoreOrCatalog(
            examKey = uiState.activeTest.categoryId.ifBlank { "upsc" },
            testId = uiState.activeTest.testId
        )
    }

    // Refresh Firestore subscription listener when login state changes
    LaunchedEffect(uiState.isLoggedIn, uiState.currentUser?.id) {
        subscriptionViewModel.refreshAuthenticatedUser()
    }

    // Propagate Firestore /subscriptions/{userId} updates to ShakuntalamViewModel and Paid Test Series gates
    LaunchedEffect(cloudSubscriptionState) {
        val state = cloudSubscriptionState
        if (state is SubscriptionCloudState.Success && state.subscription != null) {
            viewModel.syncSubscriptionFromFirestore(state.subscription)
        }
    }

    // Keep SubscriptionViewModel synchronized with local subscription activations or expirations
    LaunchedEffect(
        uiState.subscriptionPlanCode,
        uiState.subscriptionStartEpochMillis,
        uiState.subscriptionExpiryEpochMillis,
        uiState.isSubscriptionActive
    ) {
        if (subscriptionUiState.planCode != uiState.subscriptionPlanCode ||
            subscriptionUiState.isSubscriptionActive != uiState.isSubscriptionActive
        ) {
            subscriptionViewModel.syncFromLocalState(
                planCode = uiState.subscriptionPlanCode,
                startEpochMillis = uiState.subscriptionStartEpochMillis,
                expiryEpochMillis = uiState.subscriptionExpiryEpochMillis,
                isActive = uiState.isSubscriptionActive
            )
        }
    }

    // Ensure FLAG_SECURE is always cleared so the Web Browser & Streaming Android Emulator
    // never blacks out the screen on TEST_SERIES, READER, or OWNER_PORTAL.
    // (DRM protection is handled via in-app dynamic watermarks instead of OS screen-capture blackout).
    LaunchedEffect(uiState.isAntiPiracyEnabled, uiState.currentScreen) {
        val activity = context as? android.app.Activity
        activity?.window?.clearFlags(android.view.WindowManager.LayoutParams.FLAG_SECURE)
    }

    // Handle Toast / Notification messages
    LaunchedEffect(uiState.toastMessage) {
        uiState.toastMessage?.let { msg ->
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
            viewModel.clearToast()
        }
    }

    // Android Hardware / Gesture Back Navigation Handler
    BackHandler(enabled = uiState.currentScreen != AppScreen.HOME) {
        viewModel.navigateBack()
    }

    val isFullScreen = uiState.currentScreen == AppScreen.READER ||
            uiState.currentScreen == AppScreen.ITEM_DETAIL ||
            uiState.currentScreen == AppScreen.OWNER_PORTAL ||
            uiState.currentScreen == AppScreen.PERFORMANCE_ANALYTICS ||
            uiState.currentScreen == AppScreen.DAILY_QUIZ

    val showMainTopBar = !isFullScreen &&
            uiState.currentScreen != AppScreen.CART &&
            uiState.currentScreen != AppScreen.LIBRARY &&
            uiState.currentScreen != AppScreen.TEST_SERIES

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = {
            if (showMainTopBar) {
                ShakuntalamTopBar(
                    cartCount = uiState.cartItems.size,
                    language = uiState.selectedLanguage,
                    isLoggedIn = uiState.isLoggedIn,
                    userName = uiState.currentUser?.name,
                    userAvatarLetter = uiState.currentUser?.avatarLetter,
                    onNavigate = { screen -> viewModel.navigateTo(screen) },
                    onOpenSearch = {
                        viewModel.navigateTo(AppScreen.HOME)
                    },
                    onToggleLanguage = { viewModel.toggleLanguage() },
                    onOpenOwnerPortal = {
                        if (com.example.ui.components.HeaderLogoSuperMenuState.isOwnerUnlocked) {
                            viewModel.openOwnerPortal()
                        } else {
                            com.example.ui.components.HeaderLogoSuperMenuState.openDrawerToSection("OWNER_SECTION")
                        }
                    },
                    onOpenAbout = { viewModel.toggleAboutDialog(true) },
                    onOpenAuth = { viewModel.openAuthModal() },
                    onOpenProfile = { viewModel.navigateTo(AppScreen.PROFILE) },
                    onOpenDownloads = { viewModel.openDownloadModal() }
                )
            }
        },
        bottomBar = {
            if (!isFullScreen) {
                ShakuntalamBottomNav(
                    currentScreen = uiState.currentScreen,
                    cartCount = uiState.cartItems.size,
                    onNavigate = { screen -> viewModel.navigateTo(screen) },
                    language = uiState.selectedLanguage
                )
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when (uiState.currentScreen) {
                AppScreen.HOME -> {
                    HomeScreen(
                        uiState = uiState,
                        viewModel = viewModel
                    )
                }
                AppScreen.EXPLORER -> {
                    ExplorerScreen(
                        uiState = uiState,
                        viewModel = viewModel
                    )
                }
                AppScreen.ITEM_DETAIL -> {
                    ItemDetailScreen(
                        uiState = uiState,
                        viewModel = viewModel
                    )
                }
                AppScreen.READER -> {
                    ReaderScreen(
                        uiState = uiState,
                        viewModel = viewModel
                    )
                }
                AppScreen.TEST_SERIES -> {
                    TestSeriesScreen(
                        uiState = uiState,
                        viewModel = viewModel
                    )
                }
                AppScreen.CART -> {
                    CartScreen(
                        uiState = uiState,
                        viewModel = viewModel
                    )
                }
                AppScreen.LIBRARY -> {
                    LibraryScreen(
                        uiState = uiState,
                        viewModel = viewModel
                    )
                }
                AppScreen.PROFILE -> {
                    ProfileScreen(
                        uiState = uiState,
                        viewModel = viewModel,
                        userProfileViewModel = userProfileViewModel
                    )
                }
                AppScreen.OWNER_PORTAL -> {
                    OwnerAdminPortalScreen(
                        uiState = uiState,
                        viewModel = viewModel
                    )
                }
                AppScreen.PERFORMANCE_ANALYTICS -> {
                    PerformanceAnalyticsScreen(
                        uiState = uiState,
                        viewModel = viewModel
                    )
                }
                AppScreen.DAILY_QUIZ -> {
                    DailyQuizScreen(
                        uiState = uiState,
                        viewModel = viewModel
                    )
                }
            }

            // Header Logo Super Menu Drawer Modal (Test Series, Subscription, Offers, Margdarshan Video Lectures, Contact Info, About & Locked Owner Section)
            if (com.example.ui.components.HeaderLogoSuperMenuState.isDrawerOpen) {
                com.example.ui.components.ShakuntalamHeaderLogoSuperMenuModal(
                    uiState = uiState,
                    viewModel = viewModel,
                    onDismiss = {
                        com.example.ui.components.HeaderLogoSuperMenuState.isDrawerOpen = false
                    }
                )
            }

            // About Dialog
            if (uiState.showAboutDialog) {
                AboutShakuntalamDialog(
                    language = uiState.selectedLanguage,
                    onDismiss = { viewModel.toggleAboutDialog(false) }
                )
            }

            // Jetpack Compose Login Screen (First-Launch Phone Number or Email OTP via Firebase Auth)
            if (uiState.isAuthModalOpen) {
                LoginScreen(
                    selectedTab = uiState.authModalTab,
                    phoneOtpState = uiState.phoneOtpState,
                    language = uiState.selectedLanguage,
                    onSelectTab = { tab -> viewModel.switchAuthTab(tab) },
                    onPhoneChanged = { phone -> viewModel.updatePhoneNumber(phone) },
                    onEmailChanged = { email -> viewModel.updateEmailForOtp(email) },
                    onSendPhoneOtp = { viewModel.sendPhoneOtp() },
                    onSendEmailOtp = { viewModel.sendEmailOtp() },
                    onInitiateFirebaseOtp = { viewModel.initiateFirebaseOtp() },
                    onFirebaseVerificationIdReceived = { verificationId ->
                        viewModel.onFirebasePhoneVerificationIdReceived(verificationId)
                    },
                    onOtpChanged = { otp -> viewModel.updateOtpCode(otp) },
                    onVerifyPhoneOtp = { viewModel.verifyPhoneOtp("") },
                    onVerifyEmailOtp = { viewModel.verifyEmailOtp("") },
                    onLoginWithGoogle = { email, name -> viewModel.loginWithGoogle(email, name) },
                    onLoginWithFirebaseGoogleIdToken = { idToken, email, name ->
                        viewModel.signInWithFirebaseGoogleToken(idToken, email, name)
                    },
                    onToggleLanguage = { viewModel.toggleLanguage() },
                    onDismissToGuestPreview = { viewModel.closeAuthModal() }
                )
            }

            // Post-Login 2-Field Student Profile Setup Screen (1. Student Name + 2. Preferred Exam -> Firestore)
            if (uiState.isAccountSetupModalOpen) {
                StudentProfileSetupScreen(
                    uiState = uiState,
                    userProfileViewModel = userProfileViewModel,
                    isHi = uiState.selectedLanguage == com.example.model.AppLanguage.HINDI,
                    onStudentNameChanged = { name -> viewModel.updateOnboardingStudentName(name) },
                    onTargetExamChanged = { exam -> viewModel.updateOnboardingTargetExam(exam) },
                    onCompleteAccountSetup = { name, exam -> viewModel.completeStudentAccountSetup(name, exam) },
                    onDismiss = { viewModel.closeAccountSetupModal() }
                )
            }

            // User Profile & Account Modal
            if (uiState.isProfileModalOpen && uiState.currentUser != null) {
                UserProfileModal(
                    isOpen = true,
                    user = uiState.currentUser,
                    language = uiState.selectedLanguage,
                    onDismiss = { viewModel.closeProfileModal() },
                    onLogout = { viewModel.logout() },
                    onOpenDownloads = { viewModel.openDownloadModal() },
                    onNavigateLibrary = { viewModel.navigateTo(AppScreen.LIBRARY) },
                    onNavigateTests = { viewModel.navigateTo(AppScreen.TEST_SERIES) },
                    onUpdateTargetExam = { exam -> viewModel.updateTargetExam(exam) },
                    onUpdateAccountProfile = { name, exam -> viewModel.completeStudentAccountSetup(name, exam) }
                )
            }

            // Download & Upload to Google Modal
            if (uiState.isDownloadModalOpen) {
                DownloadAndUploadModal(
                    isOpen = true,
                    language = uiState.selectedLanguage,
                    onDismiss = { viewModel.closeDownloadModal() }
                )
            }

            // Interactive Payment Gateway Modal
            if (uiState.isPaymentGatewayOpen) {
                PaymentGatewayModal(
                    amount = uiState.paymentGatewayAmount,
                    itemsTitle = uiState.paymentGatewayItemTitle,
                    language = uiState.selectedLanguage,
                    ownerUpiId = uiState.ownerUpiId,
                    ownerUpiMobile = uiState.ownerUpiMobile,
                    ownerMerchantName = uiState.ownerMerchantName,
                    ownerBankName = uiState.ownerBankName,
                    ownerAccountNumber = uiState.ownerAccountNumber,
                    ownerIfscCode = uiState.ownerIfscCode,
                    onDismiss = { viewModel.closePaymentGateway() },
                    onPaymentSuccess = { receipt -> viewModel.onPaymentSuccess(receipt) }
                )
            }
        }
    }
}
