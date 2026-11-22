package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Verified
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.model.AppLanguage
import com.example.model.ContentType
import com.example.ui.components.EdTechProColors
import com.example.ui.components.NetflixStyleSubscriptionBanner
import com.example.ui.components.ShakuntalamBrandCrestBadge
import com.example.ui.theme.EmeraldSuccess
import com.example.ui.theme.Navy900
import com.example.ui.theme.SaffronGold
import com.example.viewmodel.AppScreen
import com.example.viewmodel.ShakuntalamUiState
import com.example.viewmodel.ShakuntalamViewModel
import com.example.viewmodel.UserProfileViewModel

@Composable
fun ProfileScreen(
    uiState: ShakuntalamUiState,
    viewModel: ShakuntalamViewModel,
    userProfileViewModel: UserProfileViewModel? = null,
    modifier: Modifier = Modifier
) {
    val isHi = uiState.selectedLanguage == AppLanguage.HINDI
    val user = uiState.currentUser
    val progressSummary = uiState.getMasterProgressSummary()

    var editedName by remember(user?.name) {
        mutableStateOf(user?.name ?: uiState.onboardingStudentNameInput.ifBlank { "Bharat Kumar" })
    }
    var editedExam by remember(user?.targetExam) {
        mutableStateOf(user?.targetExam ?: uiState.onboardingTargetExamInput.ifBlank { "UPSC Civil Services" })
    }

    val popularExams = listOf(
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

    val purchasedBooksCount = uiState.customStudyItems.count {
        uiState.purchasedItemIds.contains(it.id) && it.type == ContentType.EBOOK
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF8FAFC))
            .testTag("profile_screen_root"),
        contentPadding = PaddingValues(bottom = 28.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // 1. Hero Student Identity & Account Banner
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .border(
                        width = 1.5.dp,
                        brush = Brush.horizontalGradient(
                            colors = listOf(EdTechProColors.WarmGold, EdTechProColors.ElectricCyan)
                        ),
                        shape = RoundedCornerShape(20.dp)
                    )
                    .testTag("profile_identity_card"),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = EdTechProColors.DeepRoyalNavy),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    EdTechProColors.DeepRoyalNavy,
                                    EdTechProColors.ElevatedNavy
                                )
                            )
                        )
                        .padding(18.dp)
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
                                    .size(58.dp)
                                    .clip(CircleShape)
                                    .background(
                                        Brush.linearGradient(
                                            colors = listOf(
                                                EdTechProColors.WarmGold,
                                                EdTechProColors.ElectricCyan
                                            )
                                        )
                                    )
                                    .border(2.dp, Color.White, CircleShape),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = (user?.avatarLetter ?: editedName.take(1).uppercase()).ifBlank { "S" },
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = EdTechProColors.DeepRoyalNavy
                                )
                            }

                            Spacer(modifier = Modifier.width(14.dp))

                            Column(modifier = Modifier.weight(1f)) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text(
                                        text = user?.name ?: editedName,
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = Color.White,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis,
                                        modifier = Modifier.testTag("profile_student_name_text")
                                    )
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Icon(
                                        imageVector = Icons.Default.Verified,
                                        contentDescription = "Verified Student",
                                        tint = EmeraldSuccess,
                                        modifier = Modifier.size(18.dp)
                                    )
                                }

                                Spacer(modifier = Modifier.height(2.dp))

                                Text(
                                    text = user?.phoneNumber
                                        ?: user?.email
                                        ?: if (isHi) "वेरिफाइड स्टूडेंट अकाउंट" else "Verified Student Account",
                                    fontSize = 12.sp,
                                    color = Color(0xFFCBD5E1),
                                    modifier = Modifier.testTag("profile_contact_text")
                                )

                                Spacer(modifier = Modifier.height(6.dp))

                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(6.dp))
                                            .background(EdTechProColors.WarmGold.copy(alpha = 0.2f))
                                            .border(
                                                1.dp,
                                                EdTechProColors.WarmGold,
                                                RoundedCornerShape(6.dp)
                                            )
                                            .padding(horizontal = 8.dp, vertical = 3.dp)
                                            .testTag("profile_target_exam_badge")
                                    ) {
                                        Text(
                                            text = user?.targetExam ?: editedExam,
                                            fontSize = 10.5.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            color = EdTechProColors.ChampagneGold
                                        )
                                    }

                                    Box(
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(6.dp))
                                            .background(EdTechProColors.ElectricCyan.copy(alpha = 0.18f))
                                            .padding(horizontal = 8.dp, vertical = 3.dp)
                                    ) {
                                        Text(
                                            text = "AIR #${progressSummary.liveAllIndiaRank}",
                                            fontSize = 10.5.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            color = Color(0xFF67E8F9)
                                        )
                                    }
                                }
                            }
                        }

                        ShakuntalamBrandCrestBadge(size = 42.dp, showGlowRing = true)
                    }

                    Spacer(modifier = Modifier.height(14.dp))
                    HorizontalDivider(color = EdTechProColors.SlateBorder)
                    Spacer(modifier = Modifier.height(12.dp))

                    // Quick Tab Navigation Strip inside Profile (Library • Test Series • Analytics)
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Button(
                            onClick = { viewModel.navigateTo(AppScreen.LIBRARY) },
                            modifier = Modifier
                                .weight(1f)
                                .height(40.dp)
                                .testTag("profile_go_to_library_btn"),
                            colors = ButtonDefaults.buttonColors(containerColor = EdTechProColors.RoyalIndigo),
                            shape = RoundedCornerShape(10.dp),
                            contentPadding = PaddingValues(horizontal = 8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Bookmark,
                                contentDescription = null,
                                tint = EdTechProColors.WarmGold,
                                modifier = Modifier.size(15.dp)
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(
                                text = if (isHi) "लाइब्रेरी" else "Library",
                                fontSize = 11.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                maxLines = 1
                            )
                        }

                        Button(
                            onClick = { viewModel.navigateTo(AppScreen.TEST_SERIES) },
                            modifier = Modifier
                                .weight(1f)
                                .height(40.dp)
                                .testTag("profile_go_to_tests_btn"),
                            colors = ButtonDefaults.buttonColors(containerColor = EmeraldSuccess),
                            shape = RoundedCornerShape(10.dp),
                            contentPadding = PaddingValues(horizontal = 8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Quiz,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(15.dp)
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(
                                text = if (isHi) "टेस्ट सीरीज़" else "Test Series",
                                fontSize = 11.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                maxLines = 1
                            )
                        }

                        Button(
                            onClick = { viewModel.openPerformanceAnalytics() },
                            modifier = Modifier
                                .weight(1f)
                                .height(40.dp)
                                .testTag("profile_open_analytics_btn"),
                            colors = ButtonDefaults.buttonColors(containerColor = EdTechProColors.WarmGold),
                            shape = RoundedCornerShape(10.dp),
                            contentPadding = PaddingValues(horizontal = 8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Analytics,
                                contentDescription = null,
                                tint = EdTechProColors.DeepRoyalNavy,
                                modifier = Modifier.size(15.dp)
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(
                                text = if (isHi) "एनालिटिक्स" else "Analytics",
                                fontSize = 11.5.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = EdTechProColors.DeepRoyalNavy,
                                maxLines = 1
                            )
                        }
                    }
                }
            }
        }

        // 2. Key Student Performance & Streak Metrics Grid
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .testTag("profile_stats_grid"),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                ProfileMetricTile(
                    title = if (isHi) "हल किए प्रश्न" else "Solved MCQs",
                    value = "${progressSummary.totalQuestionsSolved}",
                    subtitle = "${progressSummary.overallAccuracyPercent}% ${if (isHi) "सटीकता" else "Accuracy"}",
                    accentColor = EmeraldSuccess,
                    icon = Icons.Default.Quiz,
                    modifier = Modifier.weight(1f)
                )
                ProfileMetricTile(
                    title = if (isHi) "डेली स्ट्रीक" else "Daily Streak",
                    value = "${uiState.dailyStreakDays} ${if (isHi) "दिन" else "Days"}",
                    subtitle = "${uiState.rewardPoints} XP Points",
                    accentColor = EdTechProColors.WarmGold,
                    icon = Icons.Default.LocalFireDepartment,
                    modifier = Modifier.weight(1f)
                )
                ProfileMetricTile(
                    title = if (isHi) "ई-बुक्स व टेस्ट" else "Saved Vault",
                    value = "${purchasedBooksCount + uiState.cachedOfflineEbooks.size}",
                    subtitle = "${uiState.completedTestIds.size} ${if (isHi) "टेस्ट पूर्ण" else "Tests Done"}",
                    accentColor = EdTechProColors.ElectricCyan,
                    icon = Icons.Default.EmojiEvents,
                    modifier = Modifier.weight(1f)
                )
            }
        }

        // 3. Netflix-Style ₹9/Month & ₹99/Year All-Access Subscription Pass
        item {
            NetflixStyleSubscriptionBanner(
                isSubscriptionActive = uiState.isSubscriptionActive,
                activePlanCode = uiState.subscriptionPlanCode,
                expiryEpochMillis = uiState.subscriptionExpiryEpochMillis,
                remainingDays = uiState.getRemainingSubscriptionDays(),
                isLoggedIn = uiState.isLoggedIn,
                isHi = isHi,
                onSubscribeMonthly9 = { viewModel.subscribeToPlan("MONTHLY_9") },
                onSubscribeYearly99 = { viewModel.subscribeToPlan("YEARLY_99") }
            )
        }

        // 4. Edit Student Name & Preferred Target Exam Card (Synced with Leaderboard & Firestore)
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .border(1.dp, Color(0xFFE2E8F0), RoundedCornerShape(16.dp))
                    .testTag("profile_edit_section_card"),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        ShakuntalamBrandCrestBadge(size = 22.dp)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = if (isHi)
                                "प्रोफाइल एवं टारगेट एग्ज़ाम सेटिंग्स (Account & Exam Goal)"
                            else
                                "Student Profile & Target Exam Settings",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = EdTechProColors.DeepRoyalNavy
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = null,
                            tint = EdTechProColors.RoyalIndigo,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = if (isHi) "1. स्टूडेंट का नाम (Student Name):" else "1. Student Name:",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = Navy900
                        )
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    OutlinedTextField(
                        value = editedName,
                        onValueChange = { editedName = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("profile_screen_name_input"),
                        singleLine = true,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = EdTechProColors.RoyalIndigo,
                            unfocusedBorderColor = Color(0xFFCBD5E1)
                        ),
                        shape = RoundedCornerShape(10.dp)
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.School,
                            contentDescription = null,
                            tint = EdTechProColors.WarmGold,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = if (isHi)
                                "2. किस एग्जाम की तैयारी कर रहे हैं (Target Exam):"
                            else
                                "2. Preparing For Exam (Target Exam):",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = Navy900
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        items(popularExams) { exam ->
                            val isSelected = editedExam == exam
                            Row(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(
                                        if (isSelected) EdTechProColors.DeepRoyalNavy
                                        else Color(0xFFF1F5F9)
                                    )
                                    .border(
                                        width = if (isSelected) 1.5.dp else 1.dp,
                                        color = if (isSelected) EdTechProColors.WarmGold else Color(0xFFCBD5E1),
                                        shape = RoundedCornerShape(10.dp)
                                    )
                                    .clickable {
                                        editedExam = exam
                                        viewModel.updateTargetExam(exam)
                                    }
                                    .padding(horizontal = 12.dp, vertical = 8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                ShakuntalamBrandCrestBadge(size = 14.dp, showGlowRing = isSelected)
                                Spacer(modifier = Modifier.width(6.dp))
                                if (isSelected) {
                                    Icon(
                                        imageVector = Icons.Default.Check,
                                        contentDescription = null,
                                        tint = EdTechProColors.WarmGold,
                                        modifier = Modifier.size(13.dp)
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                }
                                Text(
                                    text = exam,
                                    fontSize = 11.5.sp,
                                    fontWeight = if (isSelected) FontWeight.ExtraBold else FontWeight.SemiBold,
                                    color = if (isSelected) Color.White else EdTechProColors.DeepRoyalNavy
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    Button(
                        onClick = {
                            val cleanName = editedName.trim().ifBlank { user?.name ?: "Bharat Kumar" }
                            viewModel.completeStudentAccountSetup(cleanName, editedExam)
                            userProfileViewModel?.let { vm ->
                                vm.updateStudentName(cleanName)
                                vm.updatePreferredExam(editedExam)
                                vm.saveStudentProfile(
                                    studentName = cleanName,
                                    preferredExam = editedExam
                                )
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(46.dp)
                            .testTag("profile_screen_save_btn"),
                        colors = ButtonDefaults.buttonColors(containerColor = EdTechProColors.DeepRoyalNavy),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = null,
                            tint = EdTechProColors.WarmGold,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = if (isHi)
                                "प्रोफाइल एवं लीडरबोर्ड अकाउंट सेव करें"
                            else
                                "Save Profile & Update Leaderboard",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White
                        )
                    }
                }
            }
        }

        // 5. Account Preferences, Downloads, Admin Portal & Logout
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .border(1.dp, Color(0xFFE2E8F0), RoundedCornerShape(16.dp)),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        text = if (isHi) "अकाउंट सुविधाएं एवं नियंत्रण" else "Account Controls & Utilities",
                        fontSize = 13.5.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = EdTechProColors.DeepRoyalNavy
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        OutlinedButton(
                            onClick = { viewModel.toggleLanguage() },
                            modifier = Modifier
                                .weight(1f)
                                .height(42.dp)
                                .testTag("profile_toggle_language_btn"),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Language,
                                contentDescription = null,
                                tint = EdTechProColors.DeepRoyalNavy,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = if (isHi) "English / हिंदी" else "हिंदी / English",
                                fontSize = 11.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = EdTechProColors.DeepRoyalNavy
                            )
                        }

                        OutlinedButton(
                            onClick = { viewModel.openDownloadModal() },
                            modifier = Modifier
                                .weight(1f)
                                .height(42.dp)
                                .testTag("profile_open_downloads_btn"),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Download,
                                contentDescription = null,
                                tint = EdTechProColors.RoyalIndigo,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = if (isHi) "ऐप लिंक / शेयर" else "Share & Links",
                                fontSize = 11.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = EdTechProColors.DeepRoyalNavy
                            )
                        }
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        OutlinedButton(
                            onClick = { viewModel.openOwnerPortal() },
                            modifier = Modifier
                                .weight(1f)
                                .height(42.dp)
                                .testTag("profile_open_owner_portal_btn"),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Security,
                                contentDescription = null,
                                tint = SaffronGold,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = if (isHi) "एडमिन पोर्टल" else "Owner Portal",
                                fontSize = 11.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = EdTechProColors.DeepRoyalNavy
                            )
                        }

                        if (uiState.isLoggedIn) {
                            OutlinedButton(
                                onClick = { viewModel.logout() },
                                modifier = Modifier
                                    .weight(1f)
                                    .height(42.dp)
                                    .testTag("profile_logout_btn"),
                                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFFDC2626)),
                                shape = RoundedCornerShape(10.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ExitToApp,
                                    contentDescription = null,
                                    tint = Color(0xFFDC2626),
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = if (isHi) "लॉगआउट (Logout)" else "Logout",
                                    fontSize = 11.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFFDC2626)
                                )
                            }
                        } else {
                            Button(
                                onClick = { viewModel.openAuthModal() },
                                modifier = Modifier
                                    .weight(1f)
                                    .height(42.dp)
                                    .testTag("profile_login_btn"),
                                colors = ButtonDefaults.buttonColors(containerColor = EmeraldSuccess),
                                shape = RoundedCornerShape(10.dp)
                            ) {
                                Text(
                                    text = if (isHi) "OTP लॉगिन करें" else "Login with OTP",
                                    fontSize = 11.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
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
private fun ProfileMetricTile(
    title: String,
    value: String,
    subtitle: String,
    accentColor: Color,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.border(
            1.dp,
            EdTechProColors.SlateBorder,
            RoundedCornerShape(14.dp)
        ),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = EdTechProColors.DeepRoyalNavy),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = accentColor,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = title,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFCBD5E1),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = value,
                fontSize = 16.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                maxLines = 1
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = subtitle,
                fontSize = 9.5.sp,
                fontWeight = FontWeight.SemiBold,
                color = accentColor,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}
