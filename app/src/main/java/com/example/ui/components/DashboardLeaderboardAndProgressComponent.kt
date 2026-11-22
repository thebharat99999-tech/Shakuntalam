package com.example.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Leaderboard
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PhoneAndroid
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material.icons.filled.WorkspacePremium
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.AuthTab
import com.example.ui.theme.AmberGold
import com.example.ui.theme.EmeraldSuccess
import com.example.ui.theme.Navy800
import com.example.ui.theme.Navy900
import com.example.ui.theme.SaffronGold
import com.example.viewmodel.DashboardLeaderboardEntry
import com.example.viewmodel.ExamProgressBreakdownItem
import com.example.viewmodel.ShakuntalamUiState

val ALL_TARGET_EXAMS_LIST = listOf(
    "UPSC Civil Services",
    "CTET / UPTET / UTET",
    "UGC NET (Paper 1 & 2)",
    "IIT JEE (Main & Advanced)",
    "NEET (UG) Medical",
    "SSC CGL / CHSL / CPO",
    "UPPCS (State PSC)",
    "UKPSC (Uttarakhand PSC)",
    "BPSC (Bihar PSC)",
    "UPSSSC (PET / VDO)",
    "UKSSSC (Group C)",
    "Banking PO / Clerk",
    "Railway RRB NTPC"
)

/**
 * Post-Login 2-Field Account Setup Modal shown on the Dashboard immediately after OTP login.
 * Asks ONLY 2 things as requested:
 * 1. Student's Name (स्टूडेंट का नाम)
 * 2. Which Exam they are preparing for (किस एग्जाम की प्रिपरेशन कर रहा है)
 */
@Composable
fun StudentAccountSetupDialog(
    uiState: ShakuntalamUiState,
    isHi: Boolean,
    onStudentNameChanged: (String) -> Unit,
    onTargetExamChanged: (String) -> Unit,
    onCompleteAccountSetup: (studentName: String, targetExam: String) -> Unit,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    if (!uiState.isAccountSetupModalOpen) return

    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {},
        modifier = modifier.testTag("student_account_setup_dialog"),
        shape = RoundedCornerShape(20.dp),
        containerColor = Color.White,
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(Navy900),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.School,
                        contentDescription = null,
                        tint = SaffronGold,
                        modifier = Modifier.size(22.dp)
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = if (isHi)
                            "स्टूडेंट अकाउंट बनाएं (केवल 2 जानकारी)"
                        else
                            "Create Student Account (Only 2 Details)",
                        fontSize = 15.5.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Navy900
                    )
                    Text(
                        text = if (isHi)
                            "OTP वेरिफाइड ✓ • अपना नाम और टारगेट एग्जाम चुनें"
                        else
                            "OTP Verified ✓ • Enter your Name & Target Exam",
                        fontSize = 11.sp,
                        color = EmeraldSuccess,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        },
        text = {
            Column(modifier = Modifier.fillMaxWidth()) {
                // Verified phone/email badge
                val verifiedContact = uiState.currentUser?.phoneNumber
                    ?: uiState.currentUser?.email
                    ?: "+91 Verified OTP"
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFFECFDF5))
                        .border(1.dp, EmeraldSuccess.copy(alpha = 0.4f), RoundedCornerShape(8.dp))
                        .padding(horizontal = 10.dp, vertical = 6.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = null,
                            tint = EmeraldSuccess,
                            modifier = Modifier.size(15.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = if (isHi)
                                "OTP सत्यापित लॉगिन: $verifiedContact"
                            else
                                "OTP Verified Login: $verifiedContact",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF065F46)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))

                // FIELD 1: Student Name
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null,
                        tint = Navy900,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = if (isHi)
                            "1. स्टूडेंट का नाम (Student Name):"
                        else
                            "1. Enter Student Name:",
                        fontSize = 12.5.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Navy900
                    )
                }
                Spacer(modifier = Modifier.height(6.dp))

                OutlinedTextField(
                    value = uiState.onboardingStudentNameInput,
                    onValueChange = onStudentNameChanged,
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("input_onboarding_student_name"),
                    placeholder = {
                        Text(
                            text = if (isHi) "उदा. राहुल शर्मा (Enter your full name)" else "e.g. Rahul Sharma",
                            fontSize = 13.sp
                        )
                    },
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = SaffronGold,
                        unfocusedBorderColor = Color(0xFFCBD5E1)
                    ),
                    shape = RoundedCornerShape(10.dp)
                )

                Spacer(modifier = Modifier.height(14.dp))

                // FIELD 2: Which Exam are you preparing for?
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.School,
                        contentDescription = null,
                        tint = Navy900,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = if (isHi)
                            "2. किस एग्जाम की प्रिपरेशन कर रहे हैं? (Target Exam):"
                        else
                            "2. Which Exam are you preparing for?",
                        fontSize = 12.5.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Navy900
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(ALL_TARGET_EXAMS_LIST) { exam ->
                        val isSelected = uiState.onboardingTargetExamInput == exam
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .background(if (isSelected) Navy900 else Color(0xFFF1F5F9))
                                .border(
                                    width = 1.dp,
                                    color = if (isSelected) SaffronGold else Color(0xFFCBD5E1),
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .clickable { onTargetExamChanged(exam) }
                                .padding(horizontal = 12.dp, vertical = 8.dp)
                                .testTag("chip_onboarding_exam_${exam.take(8).lowercase().replace(" ", "_")}")
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                if (isSelected) {
                                    Icon(
                                        imageVector = Icons.Default.Check,
                                        contentDescription = null,
                                        tint = SaffronGold,
                                        modifier = Modifier.size(14.dp)
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                }
                                Text(
                                    text = exam,
                                    fontSize = 11.5.sp,
                                    fontWeight = if (isSelected) FontWeight.ExtraBold else FontWeight.SemiBold,
                                    color = if (isSelected) Color.White else Navy900
                                )
                            }
                        }
                    }
                }

                if (uiState.onboardingErrorMessage != null) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = uiState.onboardingErrorMessage,
                        color = Color(0xFFDC2626),
                        fontSize = 11.5.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(14.dp))

                Text(
                    text = if (isHi)
                        "★ यही नाम और एग्जाम आपके डैशबोर्ड और ऑल-इंडिया लीडरबोर्ड में प्रदर्शित होगा।"
                    else
                        "★ This Name & Target Exam will appear on your Dashboard and in the All-India Leaderboard.",
                    fontSize = 10.5.sp,
                    color = Color(0xFF475569)
                )

                Spacer(modifier = Modifier.height(12.dp))

                Button(
                    onClick = {
                        onCompleteAccountSetup(
                            uiState.onboardingStudentNameInput,
                            uiState.onboardingTargetExamInput
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .testTag("btn_complete_account_setup"),
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
                            "अकाउंट बनाएं एवं डैशबोर्ड पर जाएं"
                        else
                            "Create Account & Continue to Dashboard",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Navy900
                    )
                }
            }
        }
    )
}

/**
 * Dashboard Student Account & Onboarding Card rendered prominently on the Main Dashboard:
 * - State 1 (Not logged in): Shows First-Launch OTP Login options (Phone + OTP OR Email + OTP)
 * - State 2 (Logged in, 2-field setup pending): Shows inline 2-Field Setup (Student Name + Target Exam)
 * - State 3 (Account complete): Shows Student's Registered Name, Target Exam, Verified status & Live Rank
 */
@Composable
fun DashboardStudentAccountAndOnboardingCard(
    uiState: ShakuntalamUiState,
    isHi: Boolean,
    onOpenPhoneOtpLogin: () -> Unit,
    onOpenEmailOtpLogin: () -> Unit,
    onStudentNameChanged: (String) -> Unit,
    onTargetExamChanged: (String) -> Unit,
    onCompleteAccountSetup: (studentName: String, targetExam: String) -> Unit,
    onOpenEditAccountModal: () -> Unit,
    onPracticeTargetExam: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val summary = uiState.getMasterProgressSummary()

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp)
            .border(1.5.dp, SaffronGold.copy(alpha = 0.75f), RoundedCornerShape(16.dp))
            .testTag("dashboard_student_account_card"),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            if (!uiState.isLoggedIn) {
                // STATE 1: Not Logged In -> First-Launch OTP Login Gate Banner
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(SaffronGold.copy(alpha = 0.2f))
                            .border(1.dp, SaffronGold, CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = null,
                            tint = SaffronGold,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = if (isHi)
                                "स्टूडेंट लॉगिन (फ़ोन नंबर या ईमेल OTP)"
                            else
                                "STUDENT LOGIN (PHONE OR EMAIL OTP)",
                            fontSize = 12.5.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = SaffronGold
                        )
                        Text(
                            text = if (isHi)
                                "मोबाइल नंबर या ईमेल आईडी से OTP लॉगिन करें, फिर अपना नाम व एग्जाम चुनकर अकाउंट बनाएं"
                            else
                                "Login via Mobile Number or Email ID with OTP, then set your Name & Target Exam",
                            fontSize = 10.5.sp,
                            color = Color(0xFFCBD5E1),
                            lineHeight = 14.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = onOpenPhoneOtpLogin,
                        modifier = Modifier
                            .weight(1f)
                            .height(40.dp)
                            .testTag("dashboard_btn_phone_otp_login"),
                        colors = ButtonDefaults.buttonColors(containerColor = SaffronGold),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.PhoneAndroid,
                            contentDescription = null,
                            tint = Navy900,
                            modifier = Modifier.size(15.dp)
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = if (isHi) "फ़ोन + OTP लॉगिन" else "Phone + OTP",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Navy900,
                            maxLines = 1
                        )
                    }

                    Button(
                        onClick = onOpenEmailOtpLogin,
                        modifier = Modifier
                            .weight(1f)
                            .height(40.dp)
                            .testTag("dashboard_btn_email_otp_login"),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E293B)),
                        border = androidx.compose.foundation.BorderStroke(1.dp, SaffronGold),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = null,
                            tint = SaffronGold,
                            modifier = Modifier.size(15.dp)
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = if (isHi) "ईमेल + OTP लॉगिन" else "Email + OTP",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White,
                            maxLines = 1
                        )
                    }
                }
            } else if (uiState.currentUser?.isAccountSetupCompleted != true) {
                // STATE 2: OTP Logged In -> Inline 2-Field Account Setup on Dashboard
                Text(
                    text = if (isHi)
                        "✓ OTP लॉगिन सफल! अपना अकाउंट पूरा करने के लिए केवल 2 जानकारी भरें:"
                    else
                        "✓ OTP Login Verified! Fill just 2 details to create your Student Account:",
                    fontSize = 11.5.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = SaffronGold
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = uiState.onboardingStudentNameInput,
                    onValueChange = onStudentNameChanged,
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("dashboard_inline_student_name_input"),
                    placeholder = {
                        Text(
                            text = if (isHi) "1. स्टूडेंट का नाम लिखें (Student Name)" else "1. Enter Student Name",
                            fontSize = 12.sp,
                            color = Color(0xFF94A3B8)
                        )
                    },
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White,
                        focusedBorderColor = SaffronGold,
                        unfocusedBorderColor = Color(0xFF475569)
                    ),
                    shape = RoundedCornerShape(8.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = if (isHi)
                        "2. किस एग्जाम की प्रिपरेशन कर रहे हैं? (Target Exam चुनें):"
                    else
                        "2. Select Target Exam you are preparing for:",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFE2E8F0)
                )

                Spacer(modifier = Modifier.height(6.dp))

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(ALL_TARGET_EXAMS_LIST) { exam ->
                        val isSelected = uiState.onboardingTargetExamInput == exam
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(6.dp))
                                .background(if (isSelected) SaffronGold else Color(0xFF1E293B))
                                .border(
                                    width = 1.dp,
                                    color = if (isSelected) SaffronGold else Color(0xFF475569),
                                    shape = RoundedCornerShape(6.dp)
                                )
                                .clickable { onTargetExamChanged(exam) }
                                .padding(horizontal = 10.dp, vertical = 6.dp)
                        ) {
                            Text(
                                text = exam,
                                fontSize = 10.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (isSelected) Navy900 else Color.White
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                Button(
                    onClick = {
                        onCompleteAccountSetup(
                            uiState.onboardingStudentNameInput,
                            uiState.onboardingTargetExamInput
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(42.dp)
                        .testTag("dashboard_inline_create_account_btn"),
                    colors = ButtonDefaults.buttonColors(containerColor = EmeraldSuccess),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Icon(Icons.Default.CheckCircle, contentDescription = null, tint = Color.White, modifier = Modifier.size(16.dp))
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = if (isHi) "अकाउंट बनाएं (Create Account)" else "Create Student Account",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White
                    )
                }
            } else {
                // STATE 3: Verified Student Account Active on Dashboard
                val user = uiState.currentUser!!
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
                                .size(44.dp)
                                .clip(CircleShape)
                                .background(
                                    Brush.linearGradient(listOf(SaffronGold, AmberGold))
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = user.avatarLetter,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Navy900
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Column {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = user.name,
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color.White,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                    modifier = Modifier.testTag("dashboard_account_student_name")
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Icon(
                                    imageVector = Icons.Default.Verified,
                                    contentDescription = "Verified Account",
                                    tint = EmeraldSuccess,
                                    modifier = Modifier.size(15.dp)
                                )
                            }
                            Text(
                                text = if (isHi)
                                    "लक्ष्य परीक्षा: ${user.targetExam}"
                                else
                                    "Preparing For: ${user.targetExam}",
                                fontSize = 11.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = SaffronGold,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.testTag("dashboard_account_target_exam")
                            )
                            Text(
                                text = (user.phoneNumber ?: user.email ?: "OTP Verified") +
                                        " • लीडरबोर्ड सिंक्ड (Leaderboard Active)",
                                fontSize = 10.sp,
                                color = Color(0xFF94A3B8),
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }

                    // Live AIR Rank Pill
                    Column(horizontalAlignment = Alignment.End) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .background(SaffronGold)
                                .padding(horizontal = 10.dp, vertical = 4.dp)
                                .testTag("dashboard_account_air_badge")
                        ) {
                            Text(
                                text = "AIR #${summary.liveAllIndiaRank}",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Navy900
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "${summary.liveScorePoints} XP Pts",
                            fontSize = 10.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF38BDF8)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = { onPracticeTargetExam(summary.targetExamKey) },
                        modifier = Modifier
                            .weight(1f)
                            .height(38.dp)
                            .testTag("dashboard_practice_target_exam_btn"),
                        colors = ButtonDefaults.buttonColors(containerColor = EmeraldSuccess),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.PlayArrow,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(15.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = if (isHi) "टारगेट एग्जाम मॉक दें" else "Practice Target Exam",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White,
                            maxLines = 1
                        )
                    }

                    OutlinedButton(
                        onClick = onOpenEditAccountModal,
                        modifier = Modifier
                            .height(38.dp)
                            .testTag("dashboard_edit_account_btn"),
                        border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFF475569)),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = null,
                            tint = SaffronGold,
                            modifier = Modifier.size(14.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = if (isHi) "नाम/एग्जाम बदलें" else "Edit Account",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            maxLines = 1
                        )
                    }
                }
            }
        }
    }
}

/**
 * Strengthened Progress Tracker Section on the Main Dashboard:
 * Tracks Target Exam Readiness, Overall Questions Solved, Tests Completed, Accuracy %,
 * Correct vs Wrong Ratio, Exam-Wise Progress Bars, and 4 Preparation Milestones.
 */
@Composable
fun StrengthenedProgressTrackerSection(
    uiState: ShakuntalamUiState,
    isHi: Boolean,
    onToggleExpanded: () -> Unit,
    onSelectExamForPractice: (String) -> Unit,
    onOpenPerformanceAnalytics: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    val summary = uiState.getMasterProgressSummary()
    val targetFraction = (summary.targetExamProgress.completionPercent / 100f).coerceIn(0f, 1f)

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .border(1.5.dp, Color(0xFF38BDF8).copy(alpha = 0.6f), RoundedCornerShape(16.dp))
            .testTag("dashboard_master_progress_tracker_card"),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            // Header Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onToggleExpanded() },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    Box(
                        modifier = Modifier
                            .size(36.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color(0xFF0284C7)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.TrendingUp,
                            contentDescription = "Progress Tracker",
                            tint = Color.White,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        Text(
                            text = if (isHi)
                                "स्मार्ट प्रोग्रेस ट्रैकर (Master Progress Tracker)"
                            else
                                "STRENGTHENED EXAM PROGRESS TRACKER",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = SaffronGold
                        )
                        Text(
                            text = "${summary.studentName} • ${summary.targetExam}",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF38BDF8),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(6.dp))
                            .background(EmeraldSuccess.copy(alpha = 0.2f))
                            .border(1.dp, EmeraldSuccess, RoundedCornerShape(6.dp))
                            .padding(horizontal = 8.dp, vertical = 3.dp)
                            .testTag("progress_tracker_solved_badge")
                    ) {
                        Text(
                            text = "${summary.totalQuestionsSolved} Qs Solved",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color(0xFF86EFAC)
                        )
                    }
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(
                        imageVector = if (uiState.isProgressTrackerExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                        contentDescription = "Expand Progress Tracker",
                        tint = Color.White
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Target Exam Goal Progress Box
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFF1E293B))
                    .border(1.dp, SaffronGold.copy(alpha = 0.5f), RoundedCornerShape(12.dp))
                    .clickable { onSelectExamForPractice(summary.targetExamKey) }
                    .padding(12.dp)
                    .testTag("progress_tracker_target_exam_box")
            ) {
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = if (isHi)
                                    "★ आपका टारगेट एग्जाम: ${summary.targetExam}"
                                else
                                    "★ YOUR TARGET EXAM: ${summary.targetExam}",
                                fontSize = 11.5.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = SaffronGold,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Text(
                                text = if (isHi) summary.readinessStatusHi else summary.readinessStatusEn,
                                fontSize = 10.sp,
                                color = Color(0xFFCBD5E1)
                            )
                        }
                        Text(
                            text = "${summary.targetExamProgress.answeredCount}/${summary.targetExamProgress.totalQuestions} Qs (${summary.targetExamProgress.completionPercent}%)",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = EmeraldSuccess
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(8.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .background(Color(0xFF0F172A))
                    ) {
                        if (targetFraction > 0f) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth(targetFraction)
                                    .fillMaxHeight()
                                    .clip(RoundedCornerShape(4.dp))
                                    .background(
                                        Brush.horizontalGradient(listOf(SaffronGold, EmeraldSuccess))
                                    )
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // 4-Metric Quick Strip (Accuracy, Tests Completed, Correct/Wrong, Live Rank)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                ProgressStatMiniTile(
                    label = if (isHi) "सटीकता" else "Accuracy",
                    value = "${summary.overallAccuracyPercent}%",
                    accentColor = EmeraldSuccess,
                    tag = "progress_stat_accuracy",
                    modifier = Modifier.weight(1f)
                )
                ProgressStatMiniTile(
                    label = if (isHi) "मॉक पूर्ण" else "Tests Done",
                    value = "${summary.testsCompletedCount}",
                    accentColor = Color(0xFF38BDF8),
                    tag = "progress_stat_tests_done",
                    modifier = Modifier.weight(1f)
                )
                ProgressStatMiniTile(
                    label = if (isHi) "सही / गलत" else "Right/Wrong",
                    value = "${summary.totalCorrectCount}/${summary.totalWrongCount}",
                    accentColor = SaffronGold,
                    tag = "progress_stat_right_wrong",
                    modifier = Modifier.weight(1f)
                )
                ProgressStatMiniTile(
                    label = if (isHi) "ऑल इंडिया रैंक" else "Live AIR",
                    value = "#${summary.liveAllIndiaRank}",
                    accentColor = Color(0xFFA855F7),
                    tag = "progress_stat_live_air",
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Open Performance Analytics (Historical Scores, Avg Accuracy & Time/Question Charts) Button
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        Brush.horizontalGradient(
                            listOf(Color(0xFF1D4ED8), Color(0xFF0284C7))
                        )
                    )
                    .border(1.dp, SaffronGold.copy(alpha = 0.7f), RoundedCornerShape(10.dp))
                    .clickable { onOpenPerformanceAnalytics() }
                    .padding(horizontal = 12.dp, vertical = 9.dp)
                    .testTag("open_performance_analytics_btn")
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.TrendingUp,
                            contentDescription = "Performance Analytics",
                            tint = SaffronGold,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = if (isHi)
                                "प्रदर्शन विश्लेषण चार्ट (Scores, Accuracy & Time/Q)"
                            else
                                "Performance Analytics Charts (Scores, Accuracy & Time/Q)",
                            fontSize = 11.5.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                    Text(
                        text = if (isHi) "ग्राफ देखें →" else "View →",
                        fontSize = 10.5.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = SaffronGold
                    )
                }
            }

            AnimatedVisibility(visible = uiState.isProgressTrackerExpanded) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Spacer(modifier = Modifier.height(12.dp))
                    HorizontalDivider(color = Color(0xFF1E293B))
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = if (isHi)
                            "परीक्षा-वार प्रोग्रेस ट्रैकर (टैप करके टेस्ट शुरू करें):"
                        else
                            "Exam-Wise Progress Breakdown (Tap any exam to practice):",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFFE2E8F0)
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    // Top 6 Exam Progress Bars (Target Exam pinned at top)
                    summary.examBreakdown.take(6).forEach { item ->
                        ExamProgressBreakdownRow(
                            item = item,
                            isHi = isHi,
                            onClick = { onSelectExamForPractice(item.examKey) }
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    // Study Milestones Row
                    Text(
                        text = if (isHi)
                            "तैयारी के माइलस्टोन (Study Milestones):"
                        else
                            "Preparation Milestones:",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = SaffronGold
                    )
                    Spacer(modifier = Modifier.height(6.dp))

                    Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
                        summary.milestones.forEach { milestone ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(
                                        if (milestone.isUnlocked) Color(0xFF064E3B).copy(alpha = 0.5f)
                                        else Color(0xFF1E293B)
                                    )
                                    .padding(horizontal = 10.dp, vertical = 6.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(
                                        imageVector = if (milestone.isUnlocked) Icons.Default.CheckCircle else Icons.Default.Analytics,
                                        contentDescription = null,
                                        tint = if (milestone.isUnlocked) EmeraldSuccess else Color(0xFF64748B),
                                        modifier = Modifier.size(14.dp)
                                    )
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text(
                                        text = if (isHi) milestone.titleHi else milestone.titleEn,
                                        fontSize = 10.5.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = if (milestone.isUnlocked) Color.White else Color(0xFF94A3B8)
                                    )
                                }
                                Text(
                                    text = if (milestone.isUnlocked) {
                                        if (isHi) "पूर्ण ✓" else "DONE ✓"
                                    } else {
                                        if (isHi) "लंबित" else "Pending"
                                    },
                                    fontSize = 9.5.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = if (milestone.isUnlocked) EmeraldSuccess else SaffronGold
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun ProgressStatMiniTile(
    label: String,
    value: String,
    accentColor: Color,
    tag: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xFF1E293B))
            .border(1.dp, accentColor.copy(alpha = 0.45f), RoundedCornerShape(10.dp))
            .padding(vertical = 8.dp, horizontal = 6.dp)
            .testTag(tag),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = value,
            fontSize = 13.sp,
            fontWeight = FontWeight.ExtraBold,
            color = accentColor,
            maxLines = 1
        )
        Text(
            text = label,
            fontSize = 9.5.sp,
            color = Color(0xFFCBD5E1),
            maxLines = 1
        )
    }
}

@Composable
private fun ExamProgressBreakdownRow(
    item: ExamProgressBreakdownItem,
    isHi: Boolean,
    onClick: () -> Unit
) {
    val fraction = (item.progress.completionPercent / 100f).coerceIn(0f, 1f)
    val barColor = when {
        item.progress.isCompleted -> EmeraldSuccess
        item.isTargetExam -> SaffronGold
        item.progress.answeredCount > 0 -> Color(0xFF38BDF8)
        else -> Color(0xFF475569)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(if (item.isTargetExam) Color(0xFF1E293B) else Color(0xFF152033))
            .border(
                width = 1.dp,
                color = if (item.isTargetExam) SaffronGold.copy(alpha = 0.7f) else Color(0xFF334155),
                shape = RoundedCornerShape(8.dp)
            )
            .clickable { onClick() }
            .padding(horizontal = 10.dp, vertical = 7.dp)
            .testTag("exam_breakdown_row_${item.examKey}")
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = if (isHi) item.titleHi else item.titleEn,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                if (item.isTargetExam) {
                    Spacer(modifier = Modifier.width(6.dp))
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(4.dp))
                            .background(SaffronGold)
                            .padding(horizontal = 5.dp, vertical = 1.dp)
                    ) {
                        Text(
                            text = if (isHi) "आपका लक्ष्य" else "TARGET",
                            fontSize = 8.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Navy900
                        )
                    }
                }
            }
            Text(
                text = "${item.progress.answeredCount}/${item.progress.totalQuestions} Qs (${item.progress.completionPercent}%)",
                fontSize = 10.sp,
                fontWeight = FontWeight.ExtraBold,
                color = barColor
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(5.dp)
                .clip(RoundedCornerShape(3.dp))
                .background(Color(0xFF0F172A))
        ) {
            if (fraction > 0f) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(fraction)
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(3.dp))
                        .background(barColor)
                )
            }
        }
    }
}

/**
 * Dedicated Live All-India & Target Exam Leaderboard on the Main Dashboard.
 * Displays the exact Student Name & Target Exam from the student's created account!
 */
@Composable
fun DashboardLiveLeaderboardSection(
    uiState: ShakuntalamUiState,
    isHi: Boolean,
    onSelectScope: (String) -> Unit,
    onToggleExpanded: () -> Unit,
    onOpenEditAccount: () -> Unit,
    modifier: Modifier = Modifier
) {
    val entries = uiState.getLiveDashboardLeaderboard()
    val currentUserEntry = entries.firstOrNull { it.isCurrentUser }
    val targetExamName = uiState.getTargetExamDisplayName()
    val isTargetScope = uiState.selectedLeaderboardScope == "TARGET_EXAM"

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .border(1.5.dp, SaffronGold.copy(alpha = 0.75f), RoundedCornerShape(16.dp))
            .testTag("dashboard_live_leaderboard_card"),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            // Header
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onToggleExpanded() },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    Box(
                        modifier = Modifier
                            .size(38.dp)
                            .clip(CircleShape)
                            .background(Navy900),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Leaderboard,
                            contentDescription = "Leaderboard",
                            tint = SaffronGold,
                            modifier = Modifier.size(21.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        Text(
                            text = if (isHi)
                                "ऑल-इंडिया लाइव लीडरबोर्ड (Top Scorers)"
                            else
                                "ALL-INDIA LIVE STUDENT LEADERBOARD",
                            fontSize = 13.5.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Navy900
                        )
                        Text(
                            text = if (isHi)
                                "आपका अकाउंट: ${currentUserEntry?.studentName ?: ""} • ${currentUserEntry?.targetExam ?: targetExamName}"
                            else
                                "Your Account: ${currentUserEntry?.studentName ?: ""} • ${currentUserEntry?.targetExam ?: targetExamName}",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFB45309),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }

                Icon(
                    imageVector = if (uiState.isDashboardLeaderboardExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                    contentDescription = "Toggle Leaderboard",
                    tint = Navy900
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Scope Tabs: 1. Target Exam Leaderboard | 2. All-India Combined Leaderboard
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(8.dp))
                        .background(if (isTargetScope) Navy900 else Color(0xFFF1F5F9))
                        .border(
                            width = 1.dp,
                            color = if (isTargetScope) SaffronGold else Color(0xFFCBD5E1),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .clickable { onSelectScope("TARGET_EXAM") }
                        .padding(vertical = 7.dp, horizontal = 8.dp)
                        .testTag("leaderboard_tab_target_exam"),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = if (isHi) "1. टारगेट एग्जाम ($targetExamName)" else "1. $targetExamName",
                        fontSize = 10.5.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = if (isTargetScope) SaffronGold else Navy900,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(8.dp))
                        .background(if (!isTargetScope) Navy900 else Color(0xFFF1F5F9))
                        .border(
                            width = 1.dp,
                            color = if (!isTargetScope) SaffronGold else Color(0xFFCBD5E1),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .clickable { onSelectScope("ALL_INDIA") }
                        .padding(vertical = 7.dp, horizontal = 8.dp)
                        .testTag("leaderboard_tab_all_india"),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = if (isHi) "2. ऑल-इंडिया ओवरऑल रैंक" else "2. All-India Overall",
                        fontSize = 10.5.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = if (!isTargetScope) SaffronGold else Navy900,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            // Highlighted Card for the Student's Own Created Account in the Leaderboard
            if (currentUserEntry != null) {
                Spacer(modifier = Modifier.height(10.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color(0xFF0F172A))
                        .border(1.5.dp, SaffronGold, RoundedCornerShape(12.dp))
                        .clickable { onOpenEditAccount() }
                        .padding(12.dp)
                        .testTag("leaderboard_current_user_highlight_card")
                ) {
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
                                    .size(36.dp)
                                    .clip(CircleShape)
                                    .background(SaffronGold),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "#${currentUserEntry.rank}",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Navy900
                                )
                            }
                            Spacer(modifier = Modifier.width(10.dp))
                            Column {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text(
                                        text = currentUserEntry.studentName,
                                        fontSize = 13.5.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = Color.White,
                                        modifier = Modifier.testTag("leaderboard_user_account_name")
                                    )
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Box(
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(4.dp))
                                            .background(EmeraldSuccess)
                                            .padding(horizontal = 5.dp, vertical = 1.dp)
                                    ) {
                                        Text(
                                            text = if (isHi) "आपका अकाउंट" else "YOUR ACCOUNT",
                                            fontSize = 8.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            color = Color.White
                                        )
                                    }
                                }
                                Text(
                                    text = "${currentUserEntry.targetExam} • ${currentUserEntry.locationOrAuthTag}",
                                    fontSize = 10.5.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = SaffronGold,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                    modifier = Modifier.testTag("leaderboard_user_account_exam")
                                )
                            }
                        }

                        Column(horizontalAlignment = Alignment.End) {
                            Text(
                                text = "${currentUserEntry.scorePoints} Pts",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = SaffronGold
                            )
                            Text(
                                text = "${currentUserEntry.questionsSolved} Qs • ${currentUserEntry.accuracyPercent}% Acc",
                                fontSize = 9.5.sp,
                                color = Color(0xFFCBD5E1)
                            )
                        }
                    }
                }
            }

            AnimatedVisibility(visible = uiState.isDashboardLeaderboardExpanded) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Spacer(modifier = Modifier.height(10.dp))

                    // Ranked Leaderboard Rows
                    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        entries.forEach { entry ->
                            DashboardLeaderboardRowItem(
                                entry = entry,
                                isHi = isHi
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun DashboardLeaderboardRowItem(
    entry: DashboardLeaderboardEntry,
    isHi: Boolean
) {
    val isTop3 = entry.rank in 1..3
    val medalColor = when (entry.rank) {
        1 -> Color(0xFFF59E0B)
        2 -> Color(0xFF64748B)
        3 -> Color(0xFFB45309)
        else -> Navy800
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(
                if (entry.isCurrentUser) Color(0xFFFFFBEB)
                else Color(0xFFF8FAFC)
            )
            .border(
                width = if (entry.isCurrentUser) 1.5.dp else 1.dp,
                color = if (entry.isCurrentUser) SaffronGold else Color(0xFFE2E8F0),
                shape = RoundedCornerShape(10.dp)
            )
            .padding(horizontal = 10.dp, vertical = 8.dp)
            .testTag(if (entry.isCurrentUser) "dashboard_leaderboard_row_current_user" else "dashboard_leaderboard_row_${entry.rank}"),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape)
                    .background(if (entry.isCurrentUser) SaffronGold else medalColor.copy(alpha = 0.15f))
                    .border(1.dp, if (entry.isCurrentUser) Navy900 else medalColor, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                if (isTop3 && !entry.isCurrentUser) {
                    Icon(
                        imageVector = Icons.Default.EmojiEvents,
                        contentDescription = null,
                        tint = medalColor,
                        modifier = Modifier.size(16.dp)
                    )
                } else {
                    Text(
                        text = "#${entry.rank}",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = if (entry.isCurrentUser) Navy900 else medalColor
                    )
                }
            }

            Spacer(modifier = Modifier.width(10.dp))

            Column(modifier = Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = entry.studentName,
                        fontSize = 12.5.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Navy900,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    if (entry.isCurrentUser) {
                        Spacer(modifier = Modifier.width(6.dp))
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(4.dp))
                                .background(Navy900)
                                .padding(horizontal = 5.dp, vertical = 1.dp)
                        ) {
                            Text(
                                text = if (isHi) "आप (YOU)" else "YOU",
                                fontSize = 8.5.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = SaffronGold
                            )
                        }
                    }
                }
                Text(
                    text = "${entry.targetExam} • ${entry.locationOrAuthTag}",
                    fontSize = 10.sp,
                    color = Color(0xFF475569),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }

        Column(horizontalAlignment = Alignment.End) {
            Text(
                text = "${entry.scorePoints} Pts",
                fontSize = 12.sp,
                fontWeight = FontWeight.ExtraBold,
                color = if (entry.isCurrentUser) Color(0xFFB45309) else EmeraldSuccess
            )
            Text(
                text = "${entry.accuracyPercent}% Acc • ${entry.questionsSolved} Qs",
                fontSize = 9.5.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF64748B)
            )
        }
    }
}
