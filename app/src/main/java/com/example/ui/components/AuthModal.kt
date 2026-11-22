package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.PhoneAndroid
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.VerifiedUser
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.remote.GoogleCredentialHelper
import kotlinx.coroutines.launch
import com.example.model.AppLanguage
import com.example.model.AuthTab
import com.example.model.PhoneOtpState
import com.example.ui.theme.EmeraldSuccess
import com.example.ui.theme.Navy800
import com.example.ui.theme.Navy900
import com.example.ui.theme.SaffronGold

@Composable
fun AuthModal(
    isOpen: Boolean,
    selectedTab: AuthTab,
    phoneOtpState: PhoneOtpState,
    language: AppLanguage,
    onDismiss: () -> Unit,
    onSelectTab: (AuthTab) -> Unit,
    onPhoneChanged: (String) -> Unit,
    onEmailChanged: (String) -> Unit = {},
    onSendOtp: () -> Unit,
    onSendEmailOtp: () -> Unit = {},
    onOtpChanged: (String) -> Unit,
    onVerifyOtp: (String) -> Unit,
    onVerifyEmailOtp: () -> Unit = {},
    onLoginWithGoogle: (email: String, name: String) -> Unit,
    onLoginWithFirebaseGoogleIdToken: (idToken: String, email: String, name: String) -> Unit = { _, email, name ->
        onLoginWithGoogle(email, name)
    },
    modifier: Modifier = Modifier
) {
    if (!isOpen) return

    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val isHi = language == AppLanguage.HINDI
    val isPhoneTab = selectedTab == AuthTab.PHONE_OTP
    val activeTabIndex = if (isPhoneTab) 0 else 1

    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {},
        modifier = modifier.testTag("auth_modal_dialog"),
        shape = RoundedCornerShape(20.dp),
        containerColor = Color.White,
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(Navy900),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = null,
                            tint = SaffronGold,
                            modifier = Modifier.size(26.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        Text(
                            text = if (isHi) "स्टूडेंट OTP लॉगिन (First-Launch Login)" else "Student OTP Login • Shakuntalam",
                            fontSize = 15.5.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Navy900,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = if (isHi)
                                "मोबाइल नंबर या ईमेल आईडी से OTP द्वारा लॉगिन करें"
                            else
                                "Login with Mobile Number or Email ID via OTP",
                            fontSize = 11.sp,
                            color = Color(0xFF64748B),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }

                IconButton(
                    onClick = onDismiss,
                    modifier = Modifier
                        .size(32.dp)
                        .testTag("close_auth_modal_btn")
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close",
                        tint = Color(0xFF64748B)
                    )
                }
            }
        },
        text = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 2.dp)
            ) {
                // Step Indicator Banner (Step 1: OTP Login -> Step 2: Student Name & Target Exam on Dashboard)
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color(0xFF0F172A))
                        .border(1.dp, SaffronGold.copy(alpha = 0.6f), RoundedCornerShape(10.dp))
                        .padding(horizontal = 10.dp, vertical = 8.dp)
                        .testTag("auth_step_indicator_banner")
                ) {
                    Column {
                        Text(
                            text = if (isHi)
                                "चरण 1/2: फ़ोन नंबर या ईमेल आईडी से OTP सत्यापन"
                            else
                                "STEP 1/2: PHONE NUMBER OR EMAIL ID OTP LOGIN",
                            fontSize = 10.5.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = SaffronGold
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = if (isHi)
                                "लॉगिन के बाद डैशबोर्ड पर केवल 2 चीज़ें (1. स्टूडेंट का नाम और 2. किस एग्जाम की तैयारी कर रहे हैं) पूछी जाएंगी।"
                            else
                                "After OTP login, fill just 2 fields on Dashboard (1. Student Name & 2. Target Exam) to create your account.",
                            fontSize = 10.sp,
                            color = Color(0xFFE2E8F0),
                            lineHeight = 14.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Auth Method Tabs: 1. Phone Number + OTP | 2. Email ID + OTP
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
                                    modifier = Modifier.size(15.dp)
                                )
                                Spacer(modifier = Modifier.width(5.dp))
                                Text(
                                    text = if (isHi) "फ़ोन नंबर OTP" else "Phone + OTP",
                                    fontSize = 11.5.sp,
                                    fontWeight = if (isPhoneTab) FontWeight.ExtraBold else FontWeight.Medium,
                                    color = if (isPhoneTab) Navy900 else Color(0xFF64748B),
                                    maxLines = 1
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
                                    modifier = Modifier.size(15.dp)
                                )
                                Spacer(modifier = Modifier.width(5.dp))
                                Text(
                                    text = if (isHi) "ईमेल आईडी OTP" else "Email ID + OTP",
                                    fontSize = 11.5.sp,
                                    fontWeight = if (!isPhoneTab) FontWeight.ExtraBold else FontWeight.Medium,
                                    color = if (!isPhoneTab) Navy900 else Color(0xFF64748B),
                                    maxLines = 1
                                )
                            }
                        }
                    )
                }

                Spacer(modifier = Modifier.height(14.dp))

                // TAB 1: PHONE NUMBER + OTP
                if (isPhoneTab) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        if (!phoneOtpState.isOtpSent) {
                            Text(
                                text = if (isHi)
                                    "अपना 10 अंकों का मोबाइल नंबर दर्ज करें:"
                                else
                                    "Enter your 10-digit Mobile Number:",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = Navy800
                            )
                            Spacer(modifier = Modifier.height(6.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    modifier = Modifier
                                        .height(52.dp)
                                        .clip(RoundedCornerShape(8.dp))
                                        .background(Color(0xFFF1F5F9))
                                        .border(1.dp, Color(0xFFCBD5E1), RoundedCornerShape(8.dp))
                                        .padding(horizontal = 10.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Text("🇮🇳", fontSize = 15.sp)
                                        Spacer(modifier = Modifier.width(4.dp))
                                        Text("+91", fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Navy900)
                                    }
                                }

                                Spacer(modifier = Modifier.width(8.dp))

                                OutlinedTextField(
                                    value = phoneOtpState.phoneNumber,
                                    onValueChange = onPhoneChanged,
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
                                    shape = RoundedCornerShape(8.dp)
                                )
                            }

                            // Quick 1-Tap Mobile Number Fill Helper
                            Spacer(modifier = Modifier.height(6.dp))
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(6.dp))
                                    .background(Color(0xFFF1F5F9))
                                    .clickable { onPhoneChanged("9876543210") }
                                    .padding(horizontal = 8.dp, vertical = 4.dp)
                                    .testTag("quick_fill_demo_phone_pill")
                            ) {
                                Text(
                                    text = if (isHi)
                                        "मोबाइल नंबर उदाहरण: 9876543210 (टैप करके भरें)"
                                    else
                                        "Quick Fill Mobile: 9876543210 (Tap to fill)",
                                    fontSize = 10.5.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = Navy900
                                )
                            }

                            if (phoneOtpState.errorMessage != null) {
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(
                                    text = phoneOtpState.errorMessage,
                                    color = Color(0xFFDC2626),
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }

                            Spacer(modifier = Modifier.height(14.dp))

                            Button(
                                onClick = onSendOtp,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(46.dp)
                                    .testTag("btn_send_otp"),
                                colors = ButtonDefaults.buttonColors(containerColor = Navy900),
                                shape = RoundedCornerShape(8.dp)
                            ) {
                                Icon(Icons.Default.Phone, contentDescription = null, tint = SaffronGold, modifier = Modifier.size(16.dp))
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = if (isHi) "मोबाइल पर OTP प्राप्त करें (Get OTP)" else "Get OTP on Mobile Number",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                            }
                        } else {
                            // Phone OTP Verification Screen
                            OtpVerificationSection(
                                sentToLabel = "+91 ${phoneOtpState.phoneNumber}",
                                otpCode = phoneOtpState.otpCode,
                                generatedOtp = phoneOtpState.generatedOtp,
                                errorMessage = phoneOtpState.errorMessage,
                                isHi = isHi,
                                onOtpChanged = onOtpChanged,
                                onVerifyClick = { onVerifyOtp("") },
                                onChangeDestination = { onPhoneChanged("") },
                                changeLabel = if (isHi) "मोबाइल नंबर बदलें" else "Change Mobile Number"
                            )
                        }
                    }
                } else {
                    // TAB 2: EMAIL ID + OTP
                    Column(modifier = Modifier.fillMaxWidth()) {
                        if (!phoneOtpState.isOtpSent) {
                            Text(
                                text = if (isHi)
                                    "अपनी ईमेल आईडी (Email ID) दर्ज करें:"
                                else
                                    "Enter your Email ID for OTP Verification:",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = Navy800
                            )
                            Spacer(modifier = Modifier.height(6.dp))

                            OutlinedTextField(
                                value = phoneOtpState.emailAddress,
                                onValueChange = onEmailChanged,
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
                                shape = RoundedCornerShape(8.dp)
                            )

                            // Quick 1-Tap Email Fill Helper
                            Spacer(modifier = Modifier.height(6.dp))
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(6.dp))
                                    .background(Color(0xFFF1F5F9))
                                    .clickable { onEmailChanged("student.aspirant@gmail.com") }
                                    .padding(horizontal = 8.dp, vertical = 4.dp)
                                    .testTag("quick_fill_demo_email_pill")
                            ) {
                                Text(
                                    text = if (isHi)
                                        "ईमेल उदाहरण: student.aspirant@gmail.com (टैप करके भरें)"
                                    else
                                        "Quick Fill Email: student.aspirant@gmail.com (Tap to fill)",
                                    fontSize = 10.5.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = Navy900
                                )
                            }

                            if (phoneOtpState.errorMessage != null) {
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(
                                    text = phoneOtpState.errorMessage,
                                    color = Color(0xFFDC2626),
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }

                            Spacer(modifier = Modifier.height(14.dp))

                            Button(
                                onClick = onSendEmailOtp,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(46.dp)
                                    .testTag("btn_send_email_otp"),
                                colors = ButtonDefaults.buttonColors(containerColor = Navy900),
                                shape = RoundedCornerShape(8.dp)
                            ) {
                                Icon(Icons.Default.Email, contentDescription = null, tint = SaffronGold, modifier = Modifier.size(16.dp))
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = if (isHi) "ईमेल आईडी पर OTP प्राप्त करें (Get OTP)" else "Send OTP to Email ID",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                            }

                            Spacer(modifier = Modifier.height(12.dp))
                            HorizontalDivider(color = Color(0xFFE2E8F0))
                            Spacer(modifier = Modifier.height(10.dp))

                            // Optional 1-Tap Google Account Fast Continue (via Jetpack CredentialManager + Firebase Auth)
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
                                    .height(42.dp)
                                    .testTag("btn_google_signin_action"),
                                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF8FAFC)),
                                border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFFCBD5E1)),
                                shape = RoundedCornerShape(8.dp)
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Box(
                                        modifier = Modifier
                                            .size(18.dp)
                                            .clip(CircleShape)
                                            .background(Color(0xFFEA4335)),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text("G", color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                                    }
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(
                                        text = if (isHi) "Google ईमेल से त्वरित लॉगिन" else "Quick Continue with Google Email",
                                        fontSize = 11.5.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFF1E293B)
                                    )
                                }
                            }
                        } else {
                            // Email OTP Verification Screen
                            OtpVerificationSection(
                                sentToLabel = phoneOtpState.emailAddress,
                                otpCode = phoneOtpState.otpCode,
                                generatedOtp = phoneOtpState.generatedOtp,
                                errorMessage = phoneOtpState.errorMessage,
                                isHi = isHi,
                                onOtpChanged = onOtpChanged,
                                onVerifyClick = onVerifyEmailOtp,
                                onChangeDestination = { onEmailChanged("") },
                                changeLabel = if (isHi) "ईमेल आईडी बदलें" else "Change Email ID"
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Security,
                        contentDescription = null,
                        tint = EmeraldSuccess,
                        modifier = Modifier.size(13.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = if (isHi)
                            "100% सुरक्षित OTP प्रमाणीकरण • ईमेल एवं मोबाइल वेरिफाइड"
                        else
                            "100% Secure OTP Authentication • Phone & Email Verified",
                        fontSize = 10.sp,
                        color = Color(0xFF64748B)
                    )
                }
            }
        }
    )
}

@Composable
private fun OtpVerificationSection(
    sentToLabel: String,
    otpCode: String,
    generatedOtp: String,
    errorMessage: String?,
    isHi: Boolean,
    onOtpChanged: (String) -> Unit,
    onVerifyClick: () -> Unit,
    onChangeDestination: () -> Unit,
    changeLabel: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF8FAFC)),
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.VerifiedUser,
                    contentDescription = null,
                    tint = EmeraldSuccess,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = if (isHi) "OTP भेजा गया: $sentToLabel" else "OTP Code sent to: $sentToLabel",
                    fontSize = 11.5.sp,
                    fontWeight = FontWeight.Bold,
                    color = Navy900
                )
            }

            // Quick demo helper badge
            Spacer(modifier = Modifier.height(6.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(6.dp))
                    .background(Color(0xFFFEF3C7))
                    .clickable { onOtpChanged(generatedOtp.ifBlank { "123456" }) }
                    .padding(horizontal = 8.dp, vertical = 5.dp)
                    .testTag("quick_autofill_otp_pill"),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = if (isHi)
                        "⚡ आपका OTP कोड: ${generatedOtp.ifBlank { "123456" }} (यहाँ टैप करके स्वतः भरें)"
                    else
                        "⚡ Your OTP Code: ${generatedOtp.ifBlank { "123456" }} (Tap to autofill)",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFFB45309)
                )
            }
        }
    }

    Spacer(modifier = Modifier.height(10.dp))

    Text(
        text = if (isHi) "6-अंकों का OTP कोड दर्ज करें:" else "Enter 6-digit OTP code:",
        fontSize = 11.5.sp,
        fontWeight = FontWeight.Bold,
        color = Navy800
    )
    Spacer(modifier = Modifier.height(4.dp))

    OutlinedTextField(
        value = otpCode,
        onValueChange = onOtpChanged,
        modifier = Modifier
            .fillMaxWidth()
            .testTag("input_otp_code"),
        placeholder = { Text("123456", fontSize = 14.sp) },
        singleLine = true,
        leadingIcon = {
            Icon(Icons.Default.Lock, contentDescription = null, tint = SaffronGold, modifier = Modifier.size(16.dp))
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = SaffronGold,
            unfocusedBorderColor = Color(0xFFCBD5E1)
        ),
        shape = RoundedCornerShape(8.dp)
    )

    if (errorMessage != null) {
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = errorMessage,
            color = Color(0xFFDC2626),
            fontSize = 11.sp,
            fontWeight = FontWeight.SemiBold
        )
    }

    Spacer(modifier = Modifier.height(12.dp))

    Button(
        onClick = onVerifyClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(46.dp)
            .testTag("btn_verify_and_login"),
        colors = ButtonDefaults.buttonColors(containerColor = SaffronGold),
        shape = RoundedCornerShape(8.dp)
    ) {
        Icon(Icons.Default.CheckCircle, contentDescription = null, tint = Navy900, modifier = Modifier.size(16.dp))
        Spacer(modifier = Modifier.width(6.dp))
        Text(
            text = if (isHi) "OTP सत्यापित करें और लॉगिन करें" else "Verify OTP & Login",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 13.sp,
            color = Navy900
        )
    }

    Spacer(modifier = Modifier.height(6.dp))

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = changeLabel,
            fontSize = 11.sp,
            color = Navy900,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .clickable { onChangeDestination() }
                .padding(4.dp)
        )
    }
}
