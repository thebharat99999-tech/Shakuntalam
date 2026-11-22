package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.CloudDone
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.VerifiedUser
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
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
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ui.components.ALL_TARGET_EXAMS_LIST
import com.example.ui.theme.EmeraldSuccess
import com.example.ui.theme.Navy800
import com.example.ui.theme.Navy900
import com.example.ui.theme.SaffronGold
import com.example.viewmodel.ShakuntalamUiState
import com.example.viewmodel.UserProfileViewModel

data class PreferredExamOptionSpec(
    val examName: String,
    val badgeEn: String,
    val badgeHi: String
)

val PREFERRED_EXAM_SPECS = listOf(
    PreferredExamOptionSpec("UPSC Civil Services", "IAS / IPS Prelims & Mains", "सिविल सेवा परीक्षा"),
    PreferredExamOptionSpec("CTET / UPTET / UTET", "7 Subjects • 700 PYQ MCQs", "सीटेट • यूपीटेट • यूटेट"),
    PreferredExamOptionSpec("UGC NET (Paper 1 & 2)", "10 Units + 12 Subjects • 2,200 MCQs", "यूजीसी नेट पेपर 1 व 2"),
    PreferredExamOptionSpec("IIT JEE (Main & Advanced)", "Main + Advanced • 1,000 PYQ MCQs", "आईआईटी जेईई मेन व एडवांस्ड"),
    PreferredExamOptionSpec("NEET (UG) Medical", "Physics, Chem, Bio • 600 PYQ MCQs", "नीट (UG) मेडिकल"),
    PreferredExamOptionSpec("SSC CGL / CHSL / CPO", "8 Sections • 800 PYQ MCQs", "एसएससी CGL / CHSL / CPO"),
    PreferredExamOptionSpec("UPPCS (State PSC)", "UPPSC Prelims GS & CSAT", "यूपीपीसीएस राज्य सेवा"),
    PreferredExamOptionSpec("UKPSC (Uttarakhand PSC)", "Uttarakhand PCS Exam", "उत्तराखंड पीसीएस"),
    PreferredExamOptionSpec("BPSC (Bihar PSC)", "Bihar Combined Competitive", "बिहार पीसीएस"),
    PreferredExamOptionSpec("UPSSSC (PET / VDO)", "UP Subordinate Services", "यूपीएसएसएससी PET"),
    PreferredExamOptionSpec("UKSSSC (Group C)", "Uttarakhand Subordinate", "यूकेएसएसएससी समूह ग"),
    PreferredExamOptionSpec("Banking PO / Clerk", "IBPS / SBI PO & Clerk", "बैंकिंग पीओ / क्लर्क"),
    PreferredExamOptionSpec("Railway RRB NTPC", "RRB NTPC & Group D", "रेलवे भर्ती बोर्ड")
)

/**
 * Dedicated Jetpack Compose screen that captures the authenticated student's Name and Preferred
 * Exam selection, storing this data in Cloud Firestore via [UserProfileViewModel] and syncing with
 * the Dashboard Leaderboard and Progress Tracker.
 */
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun StudentProfileSetupScreen(
    uiState: ShakuntalamUiState,
    userProfileViewModel: UserProfileViewModel,
    isHi: Boolean,
    onStudentNameChanged: (String) -> Unit,
    onTargetExamChanged: (String) -> Unit,
    onCompleteAccountSetup: (studentName: String, targetExam: String) -> Unit,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    if (!uiState.isAccountSetupModalOpen) return

    val profileUiState by userProfileViewModel.uiState.collectAsStateWithLifecycle()
    val cloudState by userProfileViewModel.cloudProfileState.collectAsStateWithLifecycle()

    LaunchedEffect(
        uiState.onboardingStudentNameInput,
        uiState.onboardingTargetExamInput,
        uiState.currentUser?.provider
    ) {
        userProfileViewModel.syncInitialValues(
            studentName = uiState.onboardingStudentNameInput,
            preferredExam = uiState.onboardingTargetExamInput,
            authMethod = uiState.currentUser?.provider?.name ?: "PHONE_OTP"
        )
    }

    val effectiveName = uiState.onboardingStudentNameInput
    val effectiveExam = uiState.onboardingTargetExamInput.ifBlank { profileUiState.preferredExam }
    val activeError = uiState.onboardingErrorMessage ?: profileUiState.errorMessage

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Navy900.copy(alpha = 0.96f),
                        Color(0xFF0F2442).copy(alpha = 0.96f),
                        Color(0xFF1E293B).copy(alpha = 0.96f)
                    )
                )
            )
            .windowInsetsPadding(WindowInsets.safeDrawing)
            .testTag("student_account_setup_dialog"),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .widthIn(max = 580.dp)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp, vertical = 14.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Header Banner
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    com.example.ui.components.ShakuntalamBrandCrestBadge(
                        size = 46.dp,
                        showGlowRing = true
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        Text(
                            text = if (isHi)
                                "चरण 2/2: स्टूडेंट प्रोफाइल सेटअप"
                            else
                                "STEP 2/2: STUDENT PROFILE SETUP",
                            fontSize = 15.5.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White
                        )
                        Text(
                            text = if (isHi)
                                "अपना नाम और टारगेट एग्जाम चुनें • Cloud Firestore में सुरक्षित"
                            else
                                "Enter your Name & Preferred Exam • Stored in Cloud Firestore",
                            fontSize = 11.sp,
                            color = SaffronGold,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }

                IconButton(
                    onClick = onDismiss,
                    modifier = Modifier
                        .size(36.dp)
                        .testTag("close_profile_setup_screen_btn")
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close Profile Setup",
                        tint = Color.White.copy(alpha = 0.85f)
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            com.example.ui.components.ShakuntalamOfficialLogoShowcaseCard(
                height = 126.dp
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Main Setup Card
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("student_profile_setup_card"),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(18.dp)
                ) {
                    // Verified Auth Status Pill + Cloud Firestore Sync Indicator
                    val verifiedContact = uiState.currentUser?.phoneNumber
                        ?: uiState.currentUser?.email
                        ?: "OTP Verified Account"

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color(0xFFECFDF5))
                            .border(1.dp, EmeraldSuccess.copy(alpha = 0.4f), RoundedCornerShape(10.dp))
                            .padding(horizontal = 12.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.weight(1f)
                        ) {
                            Icon(
                                imageVector = Icons.Default.VerifiedUser,
                                contentDescription = null,
                                tint = EmeraldSuccess,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = if (isHi)
                                    "सत्यापित लॉगिन: $verifiedContact"
                                else
                                    "Authenticated: $verifiedContact",
                                fontSize = 11.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF065F46),
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.CloudDone,
                                contentDescription = null,
                                tint = Navy900,
                                modifier = Modifier.size(14.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = if (cloudState is com.example.viewmodel.UserProfileCloudState.Success)
                                    "Firestore Ready"
                                else
                                    "Firestore Sync",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Navy900
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // FIELD 1: Student's Name
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = null,
                                tint = Navy900,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = if (isHi)
                                    "1. स्टूडेंट का नाम (Student's Full Name):"
                                else
                                    "1. Enter Student's Full Name:",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Navy900
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    OutlinedTextField(
                        value = effectiveName,
                        onValueChange = { newName ->
                            userProfileViewModel.updateStudentName(newName)
                            onStudentNameChanged(newName)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("input_onboarding_student_name"),
                        placeholder = {
                            Text(
                                text = if (isHi)
                                    "उदा. राहुल वर्मा (Enter your full name)"
                                else
                                    "e.g. Rahul Verma",
                                fontSize = 13.sp
                            )
                        },
                        singleLine = true,
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Person,
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

                    // Quick Fill Name Suggestions for rapid testing / 1-tap convenience
                    Spacer(modifier = Modifier.height(6.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = if (isHi) "त्वरित नाम:" else "Quick Fill:",
                            fontSize = 10.5.sp,
                            color = Color(0xFF64748B),
                            fontWeight = FontWeight.SemiBold
                        )
                        listOf("Rahul Verma", "Aarav Sharma", "Priya Joshi").forEach { sampleName ->
                            Surface(
                                color = Color(0xFFF1F5F9),
                                shape = RoundedCornerShape(6.dp),
                                modifier = Modifier.clickable {
                                    userProfileViewModel.updateStudentName(sampleName)
                                    onStudentNameChanged(sampleName)
                                }
                            ) {
                                Text(
                                    text = sampleName,
                                    fontSize = 10.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Navy900,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                    HorizontalDivider(color = Color(0xFFE2E8F0))
                    Spacer(modifier = Modifier.height(14.dp))

                    // FIELD 2: Preferred Exam Selection
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.School,
                            contentDescription = null,
                            tint = Navy900,
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Column {
                            Text(
                                text = if (isHi)
                                    "2. किस एग्जाम की प्रिपरेशन कर रहे हैं? (Preferred Exam):"
                                else
                                    "2. Select Your Preferred Target Exam:",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Navy900
                            )
                            Text(
                                text = if (isHi)
                                    "आपका चुना गया एग्जाम डैशबोर्ड, प्रोग्रेस ट्रैकर और लीडरबोर्ड को कस्टमाइज़ करेगा"
                                else
                                    "Personalizes your Dashboard, Progress Tracker, and All-India Leaderboard",
                                fontSize = 10.5.sp,
                                color = Color(0xFF64748B)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    // Horizontal Quick-Select Row (preserving exact chip_onboarding_exam_* testTags)
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("preferred_exam_horizontal_row")
                    ) {
                        items(ALL_TARGET_EXAMS_LIST) { exam ->
                            val isSelected = effectiveExam == exam
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(if (isSelected) Navy900 else Color(0xFFF1F5F9))
                                    .border(
                                        width = if (isSelected) 1.5.dp else 1.dp,
                                        color = if (isSelected) SaffronGold else Color(0xFFCBD5E1),
                                        shape = RoundedCornerShape(10.dp)
                                    )
                                    .clickable {
                                        userProfileViewModel.updatePreferredExam(exam)
                                        onTargetExamChanged(exam)
                                    }
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

                    Spacer(modifier = Modifier.height(12.dp))

                    // Visual Grid of Featured Competitive Exam Cards
                    FlowRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        maxItemsInEachRow = 2
                    ) {
                        PREFERRED_EXAM_SPECS.take(6).forEach { spec ->
                            val isSelected = effectiveExam == spec.examName
                            Card(
                                modifier = Modifier
                                    .weight(1f)
                                    .clickable {
                                        userProfileViewModel.updatePreferredExam(spec.examName)
                                        onTargetExamChanged(spec.examName)
                                    },
                                shape = RoundedCornerShape(10.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = if (isSelected) Color(0xFFFEF3C7) else Color(0xFFF8FAFC)
                                ),
                                border = BorderStroke(
                                    width = if (isSelected) 1.5.dp else 1.dp,
                                    color = if (isSelected) SaffronGold else Color(0xFFE2E8F0)
                                )
                            ) {
                                Column(modifier = Modifier.padding(10.dp)) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Text(
                                            text = spec.examName,
                                            fontSize = 11.5.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            color = Navy900,
                                            maxLines = 1,
                                            overflow = TextOverflow.Ellipsis,
                                            modifier = Modifier.weight(1f)
                                        )
                                        if (isSelected) {
                                            Icon(
                                                imageVector = Icons.Default.CheckCircle,
                                                contentDescription = null,
                                                tint = EmeraldSuccess,
                                                modifier = Modifier.size(15.dp)
                                            )
                                        }
                                    }
                                    Spacer(modifier = Modifier.height(2.dp))
                                    Text(
                                        text = if (isHi) spec.badgeHi else spec.badgeEn,
                                        fontSize = 10.sp,
                                        color = Color(0xFF475569),
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }
                            }
                        }
                    }

                    // Error Message Display
                    AnimatedVisibility(visible = activeError != null) {
                        activeError?.let { err ->
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = err,
                                color = Color(0xFFDC2626),
                                fontSize = 11.5.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 6.dp)
                                    .testTag("profile_setup_error_text")
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    // Live Preview Summary Strip
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color(0xFFF8FAFC))
                            .border(1.dp, Color(0xFFE2E8F0), RoundedCornerShape(10.dp))
                            .padding(horizontal = 12.dp, vertical = 9.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.EmojiEvents,
                                contentDescription = null,
                                tint = SaffronGold,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = if (isHi)
                                    "लीडरबोर्ड और डैशबोर्ड प्रीव्यू: ${effectiveName.ifBlank { "आपका नाम" }} • $effectiveExam"
                                else
                                    "Leaderboard & Firestore Preview: ${effectiveName.ifBlank { "Your Name" }} • $effectiveExam",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Navy800
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    // Primary Save & Continue Button
                    val summary = uiState.getMasterProgressSummary()
                    Button(
                        onClick = {
                            userProfileViewModel.saveStudentProfile(
                                studentName = effectiveName,
                                preferredExam = effectiveExam,
                                authMethod = uiState.currentUser?.provider?.name ?: "PHONE_OTP",
                                totalPoints = summary.liveScorePoints.toLong(),
                                testsAttempted = summary.testsCompletedCount.toLong(),
                                averageAccuracy = summary.overallAccuracyPercent.toLong(),
                                streakDays = uiState.dailyStreakDays.toLong(),
                                onSuccess = { cleanName, cleanExam ->
                                    onCompleteAccountSetup(cleanName, cleanExam)
                                }
                            )
                        },
                        enabled = !profileUiState.isSaving,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .testTag("btn_complete_account_setup"),
                        colors = ButtonDefaults.buttonColors(containerColor = SaffronGold),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        if (profileUiState.isSaving) {
                            CircularProgressIndicator(
                                color = Navy900,
                                strokeWidth = 2.dp,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                        } else {
                            Icon(
                                imageVector = Icons.Default.CheckCircle,
                                contentDescription = null,
                                tint = Navy900,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                        }
                        Text(
                            text = if (isHi)
                                "अकाउंट सेव करें एवं डैशबोर्ड पर जाएं (Save to Firestore)"
                            else
                                "Save Profile to Firestore & Continue to Dashboard",
                            fontSize = 13.5.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Navy900
                        )
                    }
                }
            }
        }
    }
}
