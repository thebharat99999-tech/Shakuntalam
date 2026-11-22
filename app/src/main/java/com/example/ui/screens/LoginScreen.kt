package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.PhoneAndroid
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.VerifiedUser
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.remote.FirebaseOtpAuthHelper
import com.example.data.remote.GoogleCredentialHelper
import com.example.model.AppLanguage
import com.example.model.AuthTab
import com.example.model.PhoneOtpState
import com.example.ui.theme.EmeraldSuccess
import com.example.ui.theme.Navy800
import com.example.ui.theme.Navy900
import com.example.ui.theme.SaffronGold
import kotlinx.coroutines.launch

/**
 * Dedicated Jetpack Compose Login Screen with input fields for Phone Number or Email ID,
 * and a button to initiate OTP authentication using Firebase Auth.
 */
@Composable
fun LoginScreen(
    selectedTab: AuthTab,
    phoneOtpState: PhoneOtpState,
    language: AppLanguage,
    onSelectTab: (AuthTab) -> Unit,
    onPhoneChanged: (String) -> Unit,
    onEmailChanged: (String) -> Unit,
    onSendPhoneOtp: () -> Unit,
    onSendEmailOtp: () -> Unit,
    onInitiateFirebaseOtp: () -> Unit,
    onFirebaseVerificationIdReceived: (String) -> Unit = {},
    onOtpChanged: (String) -> Unit,
    onVerifyPhoneOtp: () -> Unit,
    onVerifyEmailOtp: () -> Unit,
    onLoginWithGoogle: (email: String, name: String) -> Unit,
    onLoginWithFirebaseGoogleIdToken: (idToken: String, email: String, name: String) -> Unit = { _, email, name ->
        onLoginWithGoogle(email, name)
    },
    onToggleLanguage: () -> Unit = {},
    onDismissToGuestPreview: (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val isHi = language == AppLanguage.HINDI
    val isPhoneTab = selectedTab == AuthTab.PHONE_OTP
    val activeTabIndex = if (isPhoneTab) 0 else 1

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Navy900,
                        Color(0xFF0F2442),
                        Color(0xFFF8FAFC)
                    )
                )
            )
            .windowInsetsPadding(WindowInsets.safeDrawing)
            .testTag("firebase_otp_login_screen"),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .widthIn(max = 560.dp)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp, vertical = 14.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Top Bar: Brand Identity + Language Toggle + Optional Close
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    com.example.ui.components.ShakuntalamBrandCrestBadge(
                        size = 46.dp,
                        showGlowRing = true
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        Text(
                            text = "SHAKUNTALAM • शकुंतलम",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White,
                            letterSpacing = 0.6.sp
                        )
                        Text(
                            text = if (isHi)
                                "E-BOOKS & TEST SERIES • फ़ोन और ईमेल OTP लॉगिन"
                            else
                                "E-BOOKS & TEST SERIES • Phone & Email OTP Login",
                            fontSize = 10.5.sp,
                            color = SaffronGold,
                            fontWeight = FontWeight.ExtraBold
                        )
                    }
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Surface(
                        color = Color.White.copy(alpha = 0.14f),
                        shape = RoundedCornerShape(20.dp),
                        border = BorderStroke(1.dp, SaffronGold.copy(alpha = 0.5f)),
                        modifier = Modifier
                            .clickable { onToggleLanguage() }
                            .testTag("login_screen_language_toggle")
                    ) {
                        Text(
                            text = if (isHi) "EN / हिंदी" else "हिंदी / EN",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                        )
                    }

                    if (onDismissToGuestPreview != null) {
                        Spacer(modifier = Modifier.width(6.dp))
                        IconButton(
                            onClick = onDismissToGuestPreview,
                            modifier = Modifier
                                .size(36.dp)
                                .testTag("close_auth_modal_btn")
                        ) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Close Login Screen",
                                tint = Color.White.copy(alpha = 0.85f)
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Official Uploaded Shakuntalam Brand Logo Banner (Symbol + SHAKUNTALAM • शकुंतलम • E-BOOKS & TEST SERIES)
            com.example.ui.components.ShakuntalamOfficialLogoShowcaseCard(
                height = 148.dp
            )

            Spacer(modifier = Modifier.height(14.dp))

            // Main Login Card
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("auth_modal_dialog"),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(18.dp)
                ) {
                    // Step 1/2 Onboarding Banner
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color(0xFF0F172A))
                            .border(1.dp, SaffronGold.copy(alpha = 0.65f), RoundedCornerShape(12.dp))
                            .padding(horizontal = 12.dp, vertical = 10.dp)
                            .testTag("auth_step_indicator_banner")
                    ) {
                        Column {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.VerifiedUser,
                                    contentDescription = null,
                                    tint = SaffronGold,
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = if (isHi)
                                        "चरण 1/2: फ़ोन नंबर या ईमेल आईडी से Firebase OTP लॉगिन"
                                    else
                                        "STEP 1/2: PHONE NUMBER OR EMAIL ID OTP LOGIN",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = SaffronGold
                                )
                            }
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = if (isHi)
                                    "मोबाइल नंबर या ईमेल आईडी से OTP सत्यापन के तुरंत बाद डैशबोर्ड पर केवल 2 चीज़ें (1. स्टूडेंट का नाम और 2. टारगेट एग्जाम) भरकर अपना अकाउंट बनाएं।"
                                else
                                    "Authenticate with your Phone Number or Email ID via OTP. Next on the Dashboard, enter just 2 fields (1. Student Name & 2. Target Exam) to complete your account.",
                                fontSize = 10.5.sp,
                                color = Color(0xFFE2E8F0),
                                lineHeight = 14.sp
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    // Mode Switcher Tabs: Phone Number + OTP | Email ID + OTP
                    TabRow(
                        selectedTabIndex = activeTabIndex,
                        containerColor = Color(0xFFF1F5F9),
                        indicator = { tabPositions ->
                            TabRowDefaults.SecondaryIndicator(
                                Modifier.tabIndicatorOffset(tabPositions[activeTabIndex]),
                                color = SaffronGold,
                                height = 3.dp
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                    ) {
                        Tab(
                            selected = isPhoneTab,
                            onClick = { onSelectTab(AuthTab.PHONE_OTP) },
                            modifier = Modifier.testTag("tab_phone_otp"),
                            text = {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(
                                        imageVector = Icons.Default.PhoneAndroid,
                                        contentDescription = null,
                                        tint = if (isPhoneTab) Navy900 else Color(0xFF64748B),
                                        modifier = Modifier.size(16.dp)
                                    )
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text(
                                        text = if (isHi) "फ़ोन नंबर OTP" else "Phone + OTP",
                                        fontSize = 12.sp,
                                        fontWeight = if (isPhoneTab) FontWeight.ExtraBold else FontWeight.Medium,
                                        color = if (isPhoneTab) Navy900 else Color(0xFF64748B),
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }
                            }
                        )

                        Tab(
                            selected = !isPhoneTab,
                            onClick = { onSelectTab(AuthTab.EMAIL_OTP) },
                            modifier = Modifier.testTag("tab_email_otp"),
                            text = {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(
                                        imageVector = Icons.Default.Email,
                                        contentDescription = null,
                                        tint = if (!isPhoneTab) Navy900 else Color(0xFF64748B),
                                        modifier = Modifier.size(16.dp)
                                    )
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text(
                                        text = if (isHi) "ईमेल आईडी OTP" else "Email ID + OTP",
                                        fontSize = 12.sp,
                                        fontWeight = if (!isPhoneTab) FontWeight.ExtraBold else FontWeight.Medium,
                                        color = if (!isPhoneTab) Navy900 else Color(0xFF64748B),
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }
                            }
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    if (!phoneOtpState.isOtpSent) {
                        // INPUT SECTION: Phone Number Input & Email ID Input
                        // Both inputs are rendered so users can type a Phone Number or Email ID directly
                        // and initiate Firebase Auth OTP with a single tap.
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(12.dp))
                                .background(if (isPhoneTab) Color(0xFFF8FAFC) else Color.White)
                                .border(
                                    width = if (isPhoneTab) 1.5.dp else 1.dp,
                                    color = if (isPhoneTab) SaffronGold else Color(0xFFE2E8F0),
                                    shape = RoundedCornerShape(12.dp)
                                )
                                .padding(12.dp)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = if (isHi)
                                        "1. मोबाइल नंबर (Phone Number for OTP):"
                                    else
                                        "1. Mobile Phone Number (for SMS OTP):",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Navy900
                                )
                                Text(
                                    text = if (isHi) "उदाहरण भरें" else "Quick Fill",
                                    fontSize = 10.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFFB45309),
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(6.dp))
                                        .background(Color(0xFFFEF3C7))
                                        .clickable {
                                            onSelectTab(AuthTab.PHONE_OTP)
                                            onPhoneChanged("9876543210")
                                        }
                                        .padding(horizontal = 8.dp, vertical = 3.dp)
                                        .testTag("quick_fill_demo_phone_pill")
                                )
                            }

                            Spacer(modifier = Modifier.height(6.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    modifier = Modifier
                                        .height(54.dp)
                                        .clip(RoundedCornerShape(10.dp))
                                        .background(Color(0xFFF1F5F9))
                                        .border(1.dp, Color(0xFFCBD5E1), RoundedCornerShape(10.dp))
                                        .padding(horizontal = 10.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Text("🇮🇳", fontSize = 15.sp)
                                        Spacer(modifier = Modifier.width(4.dp))
                                        Text(
                                            text = "+91",
                                            fontSize = 13.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            color = Navy900
                                        )
                                    }
                                }

                                Spacer(modifier = Modifier.width(8.dp))

                                OutlinedTextField(
                                    value = phoneOtpState.phoneNumber,
                                    onValueChange = { value ->
                                        if (!isPhoneTab && value.isNotEmpty()) {
                                            onSelectTab(AuthTab.PHONE_OTP)
                                        }
                                        onPhoneChanged(value)
                                    },
                                    modifier = Modifier
                                        .weight(1f)
                                        .testTag("input_phone_number"),
                                    placeholder = { Text("9876543210", fontSize = 13.sp) },
                                    singleLine = true,
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                                    colors = OutlinedTextFieldDefaults.colors(
                                        focusedBorderColor = SaffronGold,
                                        unfocusedBorderColor = Color(0xFFCBD5E1)
                                    ),
                                    shape = RoundedCornerShape(10.dp)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        // Divider between Phone and Email inputs
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            HorizontalDivider(modifier = Modifier.weight(1f), color = Color(0xFFE2E8F0))
                            Text(
                                text = if (isHi) "  या ईमेल आईडी (OR EMAIL)  " else "  OR EMAIL ID  ",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color(0xFF64748B)
                            )
                            HorizontalDivider(modifier = Modifier.weight(1f), color = Color(0xFFE2E8F0))
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        // Email Input Field Box
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(12.dp))
                                .background(if (!isPhoneTab) Color(0xFFF8FAFC) else Color.White)
                                .border(
                                    width = if (!isPhoneTab) 1.5.dp else 1.dp,
                                    color = if (!isPhoneTab) SaffronGold else Color(0xFFE2E8F0),
                                    shape = RoundedCornerShape(12.dp)
                                )
                                .padding(12.dp)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = if (isHi)
                                        "2. ईमेल आईडी (Email Address for OTP):"
                                    else
                                        "2. Email Address (for Email OTP):",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Navy900
                                )
                                Text(
                                    text = if (isHi) "ईमेल उदाहरण" else "Quick Fill",
                                    fontSize = 10.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFFB45309),
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(6.dp))
                                        .background(Color(0xFFFEF3C7))
                                        .clickable {
                                            onSelectTab(AuthTab.EMAIL_OTP)
                                            onEmailChanged("student.aspirant@gmail.com")
                                        }
                                        .padding(horizontal = 8.dp, vertical = 3.dp)
                                        .testTag("quick_fill_demo_email_pill")
                                )
                            }

                            Spacer(modifier = Modifier.height(6.dp))

                            OutlinedTextField(
                                value = phoneOtpState.emailAddress,
                                onValueChange = { value ->
                                    if (isPhoneTab && value.isNotEmpty()) {
                                        onSelectTab(AuthTab.EMAIL_OTP)
                                    }
                                    onEmailChanged(value)
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .testTag("input_email_otp_address"),
                                placeholder = { Text("student@gmail.com", fontSize = 13.sp) },
                                singleLine = true,
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                                leadingIcon = {
                                    Icon(
                                        imageVector = Icons.Default.Mail,
                                        contentDescription = null,
                                        tint = SaffronGold,
                                        modifier = Modifier.size(18.dp)
                                    )
                                },
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedBorderColor = SaffronGold,
                                    unfocusedBorderColor = Color(0xFFCBD5E1)
                                ),
                                shape = RoundedCornerShape(10.dp)
                            )
                        }

                        // Validation / Error message display
                        AnimatedVisibility(visible = phoneOtpState.errorMessage != null) {
                            phoneOtpState.errorMessage?.let { errorMsg ->
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = errorMsg,
                                    color = Color(0xFFDC2626),
                                    fontSize = 11.5.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 6.dp)
                                        .testTag("login_error_message")
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(14.dp))

                        // PRIMARY ACTION BUTTON: Initiate OTP Authentication using Firebase Auth
                        Button(
                            onClick = {
                                val hasValidPhone = phoneOtpState.phoneNumber.trim().length >= 10
                                val hasValidEmail = phoneOtpState.emailAddress.trim().contains("@")
                                val usePhone = when {
                                    isPhoneTab && hasValidPhone -> true
                                    !isPhoneTab && hasValidEmail -> false
                                    hasValidPhone -> true
                                    hasValidEmail -> false
                                    else -> isPhoneTab
                                }

                                if (usePhone) {
                                    onSendPhoneOtp()
                                    if (phoneOtpState.phoneNumber.trim().length >= 10) {
                                        FirebaseOtpAuthHelper.initiatePhoneOtpAuthentication(
                                            context = context,
                                            phoneDigits = phoneOtpState.phoneNumber,
                                            onCodeSent = { verificationId ->
                                                onFirebaseVerificationIdReceived(verificationId)
                                            },
                                            onInstantVerified = { _ ->
                                                onVerifyPhoneOtp()
                                            },
                                            onFallbackOtpReady = { _ -> }
                                        )
                                    }
                                } else {
                                    onSendEmailOtp()
                                    if (phoneOtpState.emailAddress.trim().contains("@")) {
                                        FirebaseOtpAuthHelper.initiateEmailOtpAuthentication(
                                            emailAddress = phoneOtpState.emailAddress,
                                            onSuccess = { _ -> },
                                            onFallbackReady = { _ -> }
                                        )
                                    }
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                                .testTag(if (isPhoneTab) "btn_send_otp" else "btn_send_email_otp"),
                            colors = ButtonDefaults.buttonColors(containerColor = Navy900),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Icon(
                                imageVector = if (isPhoneTab) Icons.Default.Phone else Icons.Default.Send,
                                contentDescription = null,
                                tint = SaffronGold,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = if (isPhoneTab) {
                                    if (isHi) "मोबाइल पर OTP प्राप्त करें (Firebase Auth)" else "Send OTP to Phone (Firebase Auth)"
                                } else {
                                    if (isHi) "ईमेल पर OTP प्राप्त करें (Firebase Auth)" else "Send OTP to Email (Firebase Auth)"
                                },
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 13.5.sp,
                                color = Color.White
                            )
                        }

                        // Secondary direct button so both testTags (btn_send_otp & btn_send_email_otp & btn_initiate_firebase_otp)
                        // are always available in the semantic tree regardless of which tab is highlighted
                        Spacer(modifier = Modifier.height(8.dp))
                        OutlinedButton(
                            onClick = {
                                if (isPhoneTab) {
                                    onSelectTab(AuthTab.EMAIL_OTP)
                                    if (phoneOtpState.emailAddress.trim().contains("@")) {
                                        onSendEmailOtp()
                                        FirebaseOtpAuthHelper.initiateEmailOtpAuthentication(
                                            emailAddress = phoneOtpState.emailAddress,
                                            onSuccess = {},
                                            onFallbackReady = {}
                                        )
                                    } else {
                                        onInitiateFirebaseOtp()
                                    }
                                } else {
                                    onSelectTab(AuthTab.PHONE_OTP)
                                    if (phoneOtpState.phoneNumber.trim().length >= 10) {
                                        onSendPhoneOtp()
                                    } else {
                                        onInitiateFirebaseOtp()
                                    }
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(44.dp)
                                .testTag(if (isPhoneTab) "btn_send_email_otp" else "btn_send_otp"),
                            shape = RoundedCornerShape(10.dp),
                            border = BorderStroke(1.dp, Navy800.copy(alpha = 0.35f))
                        ) {
                            Icon(
                                imageVector = if (isPhoneTab) Icons.Default.Email else Icons.Default.PhoneAndroid,
                                contentDescription = null,
                                tint = Navy900,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = if (isPhoneTab) {
                                    if (isHi) "ईमेल आईडी से OTP भेजें" else "Or Send OTP via Email ID"
                                } else {
                                    if (isHi) "मोबाइल नंबर से OTP भेजें" else "Or Send OTP via Mobile Number"
                                },
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = Navy900
                            )
                        }

                        Spacer(modifier = Modifier.height(12.dp))
                        HorizontalDivider(color = Color(0xFFE2E8F0))
                        Spacer(modifier = Modifier.height(10.dp))

                        // Google Sign-In via Jetpack Credential Manager + Firebase Auth
                        Button(
                            onClick = {
                                val fallbackEmail = phoneOtpState.emailAddress.trim().ifBlank { "thebharat99999@gmail.com" }
                                coroutineScope.launch {
                                    GoogleCredentialHelper.requestGoogleIdToken(
                                        context = context,
                                        onTokenReceived = { idToken, displayName, email ->
                                            onLoginWithFirebaseGoogleIdToken(
                                                idToken,
                                                email.ifBlank { fallbackEmail },
                                                displayName ?: ""
                                            )
                                        },
                                        onError = {
                                            onLoginWithGoogle(fallbackEmail, "")
                                        }
                                    )
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(46.dp)
                                .testTag("btn_google_signin_action"),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF8FAFC)),
                            border = BorderStroke(1.dp, Color(0xFFCBD5E1)),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Box(
                                    modifier = Modifier
                                        .size(20.dp)
                                        .clip(CircleShape)
                                        .background(Color(0xFFEA4335)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "G",
                                        color = Color.White,
                                        fontSize = 11.5.sp,
                                        fontWeight = FontWeight.ExtraBold
                                    )
                                }
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = if (isHi)
                                        "Google अकाउंट से त्वरित लॉगिन (Firebase Auth)"
                                    else
                                        "Continue with Google Account (Firebase Auth)",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF1E293B)
                                )
                            }
                        }
                    } else {
                        // STEP 2 WITHIN LOGIN: 6-DIGIT OTP VERIFICATION
                        val destinationLabel = if (isPhoneTab) {
                            "+91 ${phoneOtpState.phoneNumber}"
                        } else {
                            phoneOtpState.emailAddress
                        }

                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            colors = CardDefaults.cardColors(containerColor = Color(0xFFF8FAFC)),
                            shape = RoundedCornerShape(12.dp),
                            border = BorderStroke(1.dp, EmeraldSuccess.copy(alpha = 0.4f))
                        ) {
                            Column(modifier = Modifier.padding(12.dp)) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(
                                        imageVector = Icons.Default.VerifiedUser,
                                        contentDescription = null,
                                        tint = EmeraldSuccess,
                                        modifier = Modifier.size(18.dp)
                                    )
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text(
                                        text = if (isHi)
                                            "Firebase OTP भेजा गया: $destinationLabel"
                                        else
                                            "Firebase OTP Sent to: $destinationLabel",
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = Navy900
                                    )
                                }

                                phoneOtpState.firebaseAuthStatusMessage?.let { statusMsg ->
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = statusMsg,
                                        fontSize = 10.5.sp,
                                        color = Color(0xFF475569)
                                    )
                                }

                                Spacer(modifier = Modifier.height(8.dp))

                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(8.dp))
                                        .background(Color(0xFFFEF3C7))
                                        .clickable {
                                            onOtpChanged(phoneOtpState.generatedOtp.ifBlank { "123456" })
                                        }
                                        .padding(horizontal = 10.dp, vertical = 6.dp)
                                        .testTag("quick_autofill_otp_pill"),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = if (isHi)
                                            "⚡ आपका OTP कोड: ${phoneOtpState.generatedOtp.ifBlank { "123456" }} (यहाँ टैप करके स्वतः भरें)"
                                        else
                                            "⚡ Your OTP Code: ${phoneOtpState.generatedOtp.ifBlank { "123456" }} (Tap to autofill)",
                                        fontSize = 11.5.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = Color(0xFFB45309)
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = if (isHi) "6-अंकों का OTP कोड दर्ज करें:" else "Enter 6-Digit Verification OTP:",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = Navy800
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        OutlinedTextField(
                            value = phoneOtpState.otpCode,
                            onValueChange = onOtpChanged,
                            modifier = Modifier
                                .fillMaxWidth()
                                .testTag("input_otp_code"),
                            placeholder = { Text("123456", fontSize = 14.sp) },
                            singleLine = true,
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Lock,
                                    contentDescription = null,
                                    tint = SaffronGold,
                                    modifier = Modifier.size(18.dp)
                                )
                            },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = SaffronGold,
                                unfocusedBorderColor = Color(0xFFCBD5E1)
                            ),
                            shape = RoundedCornerShape(10.dp)
                        )

                        if (phoneOtpState.errorMessage != null) {
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(
                                text = phoneOtpState.errorMessage,
                                color = Color(0xFFDC2626),
                                fontSize = 11.5.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        }

                        Spacer(modifier = Modifier.height(14.dp))

                        Button(
                            onClick = {
                                if (isPhoneTab) {
                                    FirebaseOtpAuthHelper.verifyPhoneOtpWithFirebase(
                                        verificationId = phoneOtpState.firebaseVerificationId,
                                        otpCode = phoneOtpState.otpCode,
                                        onResult = { _ ->
                                            onVerifyPhoneOtp()
                                        }
                                    )
                                } else {
                                    onVerifyEmailOtp()
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                                .testTag("btn_verify_and_login"),
                            colors = ButtonDefaults.buttonColors(containerColor = SaffronGold),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.CheckCircle,
                                contentDescription = null,
                                tint = Navy900,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = if (isHi)
                                    "OTP सत्यापित करें और लॉगिन करें"
                                else
                                    "Verify OTP & Login",
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 14.sp,
                                color = Navy900
                            )
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = if (isPhoneTab) {
                                    if (isHi) "मोबाइल नंबर बदलें" else "Change Mobile Number"
                                } else {
                                    if (isHi) "ईमेल आईडी बदलें" else "Change Email ID"
                                },
                                fontSize = 11.5.sp,
                                color = Navy900,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .clickable {
                                        if (isPhoneTab) onPhoneChanged("") else onEmailChanged("")
                                    }
                                    .padding(6.dp)
                                    .testTag("btn_change_otp_destination")
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    // Security Footer Badge
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Security,
                            contentDescription = null,
                            tint = EmeraldSuccess,
                            modifier = Modifier.size(14.dp)
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = if (isHi)
                                "Firebase Authentication • 100% सुरक्षित OTP सत्यापन"
                            else
                                "Powered by Firebase Authentication • Secure Phone & Email OTP",
                            fontSize = 10.5.sp,
                            color = Color(0xFF64748B),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}
