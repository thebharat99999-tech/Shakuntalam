package com.example.ui.screens

import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Assignment
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.Biotech
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.CloudUpload
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Gavel
import androidx.compose.material.icons.filled.LaptopMac
import androidx.compose.material.icons.filled.Payments
import androidx.compose.material.icons.filled.Psychology
import androidx.compose.material.icons.filled.Quiz
import com.example.model.AppLanguage
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.SmartToy
import androidx.compose.material.icons.filled.Train
import androidx.compose.material.icons.filled.WorkspacePremium
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.data.ExamCatalogData
import com.example.model.ContentType
import com.example.model.ExamCategory
import com.example.model.StudyItem
import com.example.ui.components.StudyItemCard
import com.example.ui.theme.AmberGold
import com.example.ui.theme.AmberLight
import com.example.ui.theme.EmeraldLight
import com.example.ui.theme.EmeraldSuccess
import com.example.ui.theme.Navy100
import com.example.ui.theme.Navy700
import com.example.ui.theme.Navy800
import com.example.ui.theme.Navy900
import com.example.ui.theme.SaffronGold
import com.example.ui.theme.SaffronLight
import com.example.viewmodel.AppScreen
import com.example.viewmodel.ShakuntalamUiState
import com.example.viewmodel.ShakuntalamViewModel

@Composable
fun HomeScreen(
    uiState: ShakuntalamUiState,
    viewModel: ShakuntalamViewModel,
    modifier: Modifier = Modifier
) {
    val isHi = uiState.selectedLanguage == AppLanguage.HINDI

    // Filter items based on active search & filters (using dynamic customStudyItems)
    val q = uiState.searchQuery.trim()
    val filteredItems = uiState.customStudyItems.filter { item ->
        val matchesSearch = com.example.ui.components.GlobalSearchIndexCatalog.matchesStudyItem(item, q)
        val matchesType = uiState.selectedContentType == null || item.type == uiState.selectedContentType
        val matchesMedium = uiState.selectedMedium == null || item.medium.contains(uiState.selectedMedium ?: "", ignoreCase = true)
        val matchesDashboardCategory = uiState.matchesDashboardCategoryStudyItem(item)

        matchesSearch && matchesType && matchesMedium && matchesDashboardCategory
    }

    // Filter exam categories globally (UPSC, SSC, Banking, State PSC, etc.)
    val matchingCategories = ExamCatalogData.categories.filter { category ->
        q.isBlank() ||
                category.id.contains(q, ignoreCase = true) ||
                category.name.contains(q, ignoreCase = true) ||
                category.hindiName.contains(q, ignoreCase = true) ||
                category.subSections.any { sub ->
                    sub.id.contains(q, ignoreCase = true) ||
                            sub.name.contains(q, ignoreCase = true) ||
                            sub.hindiName.contains(q, ignoreCase = true) ||
                            sub.subjects.any { subj ->
                                subj.id.contains(q, ignoreCase = true) ||
                                        subj.name.contains(q, ignoreCase = true) ||
                                        subj.hindiName.contains(q, ignoreCase = true)
                            }
                }
    }

    // Filter free mock tests globally
    val matchingMockTests = if (q.isBlank()) {
        emptyList()
    } else {
        uiState.customTests.filter { test ->
            val tokens = q.lowercase().split(Regex("\\s+")).filter { it.isNotBlank() }
            val testBlob = "${test.title} ${test.hindiTitle} ${test.examName} ${test.categoryId} ${test.testId}".lowercase()
            testBlob.contains(q.lowercase()) || tokens.all { token -> testBlob.contains(token) }
        }
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF8FAFC)),
        contentPadding = PaddingValues(bottom = 24.dp)
    ) {
        // Global Search Bar at the Top of the Main Dashboard (search E-Books & Test Series by Title, Subject, or Exam Category)
        item {
            com.example.ui.components.GlobalDashboardSearchBarComponent(
                uiState = uiState,
                isHi = isHi,
                matchingCategories = matchingCategories,
                matchingMockTests = matchingMockTests,
                filteredItems = filteredItems,
                onSearchQueryChange = { query -> viewModel.setSearchQuery(query) },
                onClearSearchAndFilter = {
                    viewModel.setSearchQuery("")
                },
                onSelectQuickChip = { queryVal, isSelected ->
                    if (isSelected) {
                        viewModel.setSearchQuery("")
                        viewModel.clearDashboardCategoryFilter()
                    } else {
                        viewModel.setSearchQuery(queryVal)
                        val upper = queryVal.uppercase()
                        if (upper in listOf("TET", "CTET", "UPTET", "UTET", "CTET / TET", "IIT JEE", "IIT_JEE", "JEE", "NEET", "NEET_UG", "UGC NET", "UGC_NET", "UGC", "UPSC", "SSC", "BANKING", "PSC", "UPSSSC", "UKSSSC", "RAILWAY", "RAILWAYS")) {
                            viewModel.selectDashboardCategoryFilter(queryVal)
                        }
                    }
                },
                onSelectContentType = { type -> viewModel.setContentTypeFilter(type) },
                onSelectMedium = { medium -> viewModel.setMediumFilter(medium) },
                onExploreCategory = { category ->
                    viewModel.selectCategory(category)
                    viewModel.navigateTo(AppScreen.EXPLORER)
                },
                onFilterDashboardByCategory = { catKey ->
                    viewModel.selectDashboardCategoryFilter(catKey)
                },
                onStartMockTest = { test -> viewModel.startTest(test) },
                onStartSubjectTestSeries = { entry ->
                    when (entry.examCategoryKey.lowercase()) {
                        "tet", "teaching", "ctet", "uptet", "utet" -> viewModel.startTetSectionTest(entry.testId)
                        "iit_jee", "jee_neet" -> viewModel.startIitJeeSectionTest(entry.testId)
                        "neet", "neet_ug" -> viewModel.startNeetSectionTest(entry.testId)
                        "ugc_net", "ugc_csir_net" -> viewModel.startUgcNetSectionTest(entry.testId)
                        "ssc" -> viewModel.startSscSectionTest(entry.id)
                        "upsc" -> viewModel.startUpscSectionTest(entry.id)
                        "uppcs" -> viewModel.startUppcsSectionTest(entry.id)
                        "ukpsc" -> viewModel.startUkpscSectionTest(entry.id)
                        "bpsc" -> viewModel.startBpscSectionTest(entry.id)
                        "upsssc" -> viewModel.startUpssscSectionTest(entry.id)
                        "uksssc" -> viewModel.startUkssscSectionTest(entry.id)
                        "banking" -> {
                            viewModel.selectPyqTestByCategory("banking")
                            viewModel.navigateTo(AppScreen.TEST_SERIES)
                        }
                        "railways" -> {
                            viewModel.selectPyqTestByCategory("railways")
                            viewModel.navigateTo(AppScreen.TEST_SERIES)
                        }
                        else -> {
                            viewModel.selectPyqTestByCategory(entry.examCategoryKey)
                            viewModel.navigateTo(AppScreen.TEST_SERIES)
                        }
                    }
                },
                onOpenStudyItem = { item -> viewModel.openItemDetail(item) },
                onOpenUploadedPdf = { doc -> viewModel.openPdfForReading(doc) }
            )
        }

        // Student Account & 2-Field Onboarding Card (Phone/Email OTP Login -> Student Name + Target Exam)
        item {
            com.example.ui.components.DashboardStudentAccountAndOnboardingCard(
                uiState = uiState,
                isHi = isHi,
                onOpenPhoneOtpLogin = { viewModel.openAuthModal(com.example.model.AuthTab.PHONE_OTP) },
                onOpenEmailOtpLogin = { viewModel.openAuthModal(com.example.model.AuthTab.EMAIL_OTP) },
                onStudentNameChanged = { name -> viewModel.updateOnboardingStudentName(name) },
                onTargetExamChanged = { exam -> viewModel.updateOnboardingTargetExam(exam) },
                onCompleteAccountSetup = { name, exam -> viewModel.completeStudentAccountSetup(name, exam) },
                onOpenEditAccountModal = { viewModel.openAccountSetupModal() },
                onPracticeTargetExam = { examKey ->
                    when (examKey.lowercase()) {
                        "tet", "teaching", "ctet", "uptet", "utet" -> viewModel.startTetSectionTest("tet_sec_cdp_100")
                        "iit_jee", "jee_neet", "jee" -> viewModel.startIitJeeSectionTest("jee_main_sec_physics_100")
                        "neet", "neet_ug" -> viewModel.startNeetSectionTest("neet_sec_botany_100")
                        "ugc_net", "ugc_csir_net", "ugc" -> viewModel.startUgcNetSectionTest("ugc_p1_sec_unit1_100")
                        "ssc" -> viewModel.startSscSectionTest("ssc_gs_history")
                        "upsc" -> viewModel.startUpscSectionTest("upsc_history")
                        "uppcs" -> viewModel.startUppcsSectionTest("uppcs_history")
                        "ukpsc" -> viewModel.startUkpscSectionTest("ukpsc_special_100")
                        "bpsc" -> viewModel.startBpscSectionTest("bpsc_bihar_special")
                        "upsssc" -> viewModel.startUpssscSectionTest("upsssc_up_special_250")
                        "uksssc" -> viewModel.startUkssscSectionTest("uksssc_uk_special_250")
                        "banking" -> {
                            viewModel.selectPyqTestByCategory("banking")
                            viewModel.navigateTo(AppScreen.TEST_SERIES)
                        }
                        "railways" -> {
                            viewModel.selectPyqTestByCategory("railways")
                            viewModel.navigateTo(AppScreen.TEST_SERIES)
                        }
                        else -> viewModel.startTest()
                    }
                }
            )
        }

        // Strengthened Master Progress Tracker (Target Exam Readiness, 6-Metric Grid, Exam-Wise Bars & Milestones)
        item {
            com.example.ui.components.StrengthenedProgressTrackerSection(
                uiState = uiState,
                isHi = isHi,
                onToggleExpanded = { viewModel.toggleProgressTrackerExpanded() },
                onSelectExamForPractice = { examKey ->
                    when (examKey.lowercase()) {
                        "tet", "teaching", "ctet", "uptet", "utet" -> viewModel.startTetSectionTest("tet_sec_cdp_100")
                        "iit_jee", "jee_neet", "jee" -> viewModel.startIitJeeSectionTest("jee_main_sec_physics_100")
                        "neet", "neet_ug" -> viewModel.startNeetSectionTest("neet_sec_botany_100")
                        "ugc_net", "ugc_csir_net", "ugc" -> viewModel.startUgcNetSectionTest("ugc_p1_sec_unit1_100")
                        "ssc" -> viewModel.startSscSectionTest("ssc_gs_history")
                        "upsc" -> viewModel.startUpscSectionTest("upsc_history")
                        "uppcs" -> viewModel.startUppcsSectionTest("uppcs_history")
                        "ukpsc" -> viewModel.startUkpscSectionTest("ukpsc_special_100")
                        "bpsc" -> viewModel.startBpscSectionTest("bpsc_bihar_special")
                        "upsssc" -> viewModel.startUpssscSectionTest("upsssc_up_special_250")
                        "uksssc" -> viewModel.startUkssscSectionTest("uksssc_uk_special_250")
                        "banking" -> {
                            viewModel.selectPyqTestByCategory("banking")
                            viewModel.navigateTo(AppScreen.TEST_SERIES)
                        }
                        "railways" -> {
                            viewModel.selectPyqTestByCategory("railways")
                            viewModel.navigateTo(AppScreen.TEST_SERIES)
                        }
                        else -> viewModel.startTest()
                    }
                },
                onOpenPerformanceAnalytics = { viewModel.openPerformanceAnalytics() }
            )
        }

        // Dedicated All-India & Target Exam Live Leaderboard (showing the student's created account Name & Target Exam)
        item {
            com.example.ui.components.DashboardLiveLeaderboardSection(
                uiState = uiState,
                isHi = isHi,
                onSelectScope = { scope -> viewModel.selectLeaderboardScope(scope) },
                onToggleExpanded = { viewModel.toggleDashboardLeaderboardExpanded() },
                onOpenEditAccount = { viewModel.openAccountSetupModal() }
            )
        }

        // Daily Streak & Quiz Rewards Tracking Banner prominently displayed on the Main Dashboard
        item {
            com.example.ui.components.DailyStreakDashboardBanner(
                uiState = uiState,
                isHi = isHi,
                onStartDailyStreakQuiz = {
                    val activeFilter = uiState.effectiveDashboardCategoryFilter().lowercase()
                    when (activeFilter) {
                        "tet", "teaching", "ctet", "uptet", "utet" -> viewModel.startTetSectionTest("tet_sec_cdp_100")
                        "iit_jee", "jee_neet", "jee" -> viewModel.startIitJeeSectionTest("jee_main_sec_physics_100")
                        "neet", "neet_ug" -> viewModel.startNeetSectionTest("neet_sec_botany_100")
                        "ugc_net", "ugc_csir_net", "ugc" -> viewModel.startUgcNetSectionTest("ugc_p1_sec_unit1_100")
                        "ssc" -> viewModel.startSscSectionTest("ssc_gs_history")
                        "upsc" -> viewModel.startUpscSectionTest("upsc_history")
                        "uppcs" -> viewModel.startUppcsSectionTest("uppcs_history")
                        "ukpsc" -> viewModel.startUkpscSectionTest("ukpsc_special_100")
                        "bpsc" -> viewModel.startBpscSectionTest("bpsc_bihar_special")
                        "upsssc" -> viewModel.startUpssscSectionTest("upsssc_up_special_250")
                        "uksssc" -> viewModel.startUkssscSectionTest("uksssc_uk_special_250")
                        "banking" -> {
                            viewModel.selectPyqTestByCategory("banking")
                            viewModel.navigateTo(AppScreen.TEST_SERIES)
                        }
                        "railways" -> {
                            viewModel.selectPyqTestByCategory("railways")
                            viewModel.navigateTo(AppScreen.TEST_SERIES)
                        }
                        else -> viewModel.startTest()
                    }
                }
            )
        }

        // Daily Quiz Feature: Single High-Yield Practice Question from a Random Subject Every Day
        // with immediate detailed explanation after submission to encourage daily app engagement
        item {
            com.example.ui.components.DailyQuizDashboardCard(
                uiState = uiState,
                isHi = isHi,
                onSelectOption = { optIdx -> viewModel.selectDailyQuizOption(optIdx) },
                onSubmitAnswer = { viewModel.submitDailyQuizAnswer() },
                onToggleExplanation = { viewModel.toggleDailyQuizExplanation() },
                onShuffleRandomSubject = { viewModel.shuffleDailyQuizQuestion() },
                onOpenFullScreen = { viewModel.openDailyQuiz() }
            )
        }

        // Hero Promotion Banner with Full-Clarity Uploaded Shakuntalam Logo (Symbol + Text)
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(
                        Brush.verticalGradient(
                            listOf(
                                com.example.ui.components.EdTechProColors.DeepRoyalNavy,
                                com.example.ui.components.EdTechProColors.ElevatedNavy
                            )
                        )
                    )
                    .border(
                        width = 1.5.dp,
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                com.example.ui.components.EdTechProColors.WarmGold,
                                com.example.ui.components.EdTechProColors.ElectricCyan
                            )
                        ),
                        shape = RoundedCornerShape(20.dp)
                    )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(18.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Full-Clarity Official Uploaded Logo (Winged 'S' + Book + Checkmark + SHAKUNTALAM • शकुंतलम • E-BOOKS & TEST SERIES)
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(175.dp)
                            .clip(RoundedCornerShape(14.dp))
                            .background(com.example.ui.components.EdTechProColors.DeepRoyalNavy)
                            .border(
                                1.dp,
                                com.example.ui.components.EdTechProColors.WarmGold.copy(alpha = 0.45f),
                                RoundedCornerShape(14.dp)
                            )
                            .padding(vertical = 6.dp, horizontal = 10.dp)
                            .testTag("home_hero_official_logo_image"),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.shakuntalam_brand_banner),
                            contentDescription = "SHAKUNTALAM • शकुंतलम • E-BOOKS & TEST SERIES Official Logo",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Fit
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = if (isHi) "भारत की सभी प्रतियोगी परीक्षाओं की संपूर्ण तैयारी" else "India's Premier Exam Prep Portal & E-Book Library",
                        color = Color.White,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.ExtraBold,
                        lineHeight = 23.sp
                    )
                    Text(
                        text = "UPSC • State PSCs • SSC • Railway • Banking • Teaching • NEET • JEE • UGC NET",
                        color = Color(0xFFE2E8F0),
                        fontSize = 11.5.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(top = 4.dp)
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Button(
                            onClick = { viewModel.navigateTo(AppScreen.EXPLORER) },
                            colors = ButtonDefaults.buttonColors(containerColor = SaffronGold),
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier.testTag("hero_explore_button")
                        ) {
                            Text(
                                text = if (isHi) "परीक्षा वर्ग देखें" else "Explore Exams",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Icon(
                                imageVector = Icons.Default.ArrowForward,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(16.dp)
                            )
                        }

                        Button(
                            onClick = { viewModel.startTest() },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0x33FFFFFF)),
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier.testTag("hero_free_test_button")
                        ) {
                            Icon(
                                imageVector = Icons.Default.Quiz,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = if (isHi) "मुफ्त टेस्ट दें" else "Free Mock Test",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }

        // Owner / Publisher Portal Access Banner
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(Color(0xFFEFF6FF))
                    .border(1.dp, Color(0xFFBFDBFE), RoundedCornerShape(14.dp))
                    .clickable { viewModel.openOwnerPortal() }
                    .padding(14.dp)
                    .testTag("home_owner_portal_banner")
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        modifier = Modifier.weight(1f),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(38.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(Navy900),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.CloudUpload,
                                contentDescription = "Owner Portal",
                                tint = SaffronGold,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Column {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = if (isHi) "प्रकाशक पोर्टल (Owner Portal)" else "Owner / Publisher Portal",
                                    fontSize = 12.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Navy900
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(4.dp))
                                        .background(EmeraldLight)
                                        .padding(horizontal = 5.dp, vertical = 2.dp)
                                ) {
                                    Text(
                                        text = "PDF Upload",
                                        fontSize = 9.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = EmeraldSuccess
                                    )
                                }
                            }
                            Text(
                                text = if (isHi) "आसानी से नई PDF ई-बुक्स अपलोड एवं डिलीट करें।" else "Easily upload and manage PDF study materials & e-books.",
                                fontSize = 11.sp,
                                color = Color(0xFF475569)
                            )
                        }
                    }

                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = null,
                        tint = Navy900,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
        }

        // Live Website & Download Links Banner
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(Color(0xFFFEF3C7))
                    .border(1.dp, Color(0xFFFDE68A), RoundedCornerShape(14.dp))
                    .clickable { viewModel.openDownloadModal() }
                    .padding(14.dp)
                    .testTag("home_download_links_banner")
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        modifier = Modifier.weight(1f),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(38.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(Navy900),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Download,
                                contentDescription = "Download Center",
                                tint = SaffronGold,
                                modifier = Modifier.size(20.dp)
                            )
                        }

                        Spacer(modifier = Modifier.width(12.dp))

                        Column {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = if (isHi) "वेबसाइट व ऐप डाउनलोड लिंक" else "Live Website & App Downloads",
                                    fontSize = 13.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Navy900
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(4.dp))
                                        .background(Navy900)
                                        .padding(horizontal = 5.dp, vertical = 2.dp)
                                ) {
                                    Text(
                                        text = "Google Ready",
                                        fontSize = 9.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = SaffronGold
                                    )
                                }
                            }
                            Text(
                                text = if (isHi) "लाइव वेब लिंक कॉपी करें एवं गूगल प्ले स्टोर पर अपलोड करने के चरण देखें।" else "Copy live website link & view steps to upload on Google Play Console.",
                                fontSize = 11.sp,
                                color = Color(0xFF78350F)
                            )
                        }
                    }

                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = null,
                        tint = Navy900,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
        }

        // Section 1: All Competitive Exam Categories (Horizontal Grid / Chips)
        item {
            val displayedCategories = matchingCategories.ifEmpty { ExamCatalogData.categories }
            Column(modifier = Modifier.padding(top = 20.dp)) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = if (isHi) "परीक्षा वर्ग (Competitive Exam Categories)" else "Exam Categories (All India)",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Navy900
                        )
                        Text(
                            text = if (isHi) "विस्तृत सब-सेक्शन एवं विषयवार विभाजन" else "Detailed sub-sections & subject-wise hierarchy",
                            fontSize = 11.5.sp,
                            color = Color(0xFF64748B)
                        )
                    }
                    Text(
                        text = if (isHi) "सभी देखें >" else "View All >",
                        fontSize = 12.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = SaffronGold,
                        modifier = Modifier
                            .clickable { viewModel.navigateTo(AppScreen.EXPLORER) }
                            .padding(4.dp)
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(displayedCategories) { category ->
                        ExamCategoryQuickCard(
                            category = category,
                            isHi = isHi,
                            onClick = {
                                viewModel.selectCategory(category)
                                viewModel.navigateTo(AppScreen.EXPLORER)
                            }
                        )
                    }
                }
            }
        }

        // Netflix-Style All-Access Subscription Banner (₹9 / Month, ₹99 / Year & ₹399 / Lifetime)
        item {
            com.example.ui.components.NetflixStyleSubscriptionBanner(
                isSubscriptionActive = uiState.isAllAccessSubscriptionValid(),
                activePlanCode = uiState.subscriptionPlanCode,
                expiryEpochMillis = uiState.subscriptionExpiryEpochMillis,
                isHi = isHi,
                onSubscribeMonthly9 = { viewModel.initiateSubscriptionCheckout("MONTHLY_9") },
                onSubscribeYearly99 = { viewModel.initiateSubscriptionCheckout("YEARLY_99") },
                onSubscribeLifetime399 = { viewModel.initiateSubscriptionCheckout("LIFETIME_399") }
            )
        }

        // Dashboard Exam Category Filter Bar (UPSC, SSC, Banking, State PSC, UPSSSC, UKSSSC, Railways)
        item {
            com.example.ui.components.DashboardCategoryFilterBar(
                uiState = uiState,
                isHi = isHi,
                onSelectCategoryFilter = { categoryKey ->
                    viewModel.selectDashboardCategoryFilter(categoryKey)
                },
                onClearFilter = {
                    viewModel.clearDashboardCategoryFilter()
                }
            )
        }

        // All-India Exam Practice Hub (Topic-Wise, Sectional, FLT, 5-Yr PYQ, Daily/Practice Quiz) & Free Branded Notes PDF Vault
        item {
            val activeHubExamState = androidx.compose.runtime.remember { androidx.compose.runtime.mutableStateOf("upsc") }
            com.example.ui.components.AllIndiaTestbookSuperHubAndFreeNotesSection(
                selectedExamKey = activeHubExamState.value,
                isHi = isHi,
                onSelectExamKey = { nextKey -> activeHubExamState.value = nextKey },
                onStartMockTest = { mockTest -> viewModel.startTest(mockTest) },
                onReadFreeNoteInApp = { noteItem -> viewModel.openReader(noteItem, 0) },
                onDownloadFreePdfNote = { noteItem -> viewModel.cacheStudyItemForOffline(noteItem) }
            )
        }

        // Dedicated E-Books & Downloaded Vault Section (Direct 1-Tap Access to All Downloaded E-Books & Free PDFs)
        item {
            com.example.ui.components.DedicatedEbooksAndDownloadedVaultSection(
                uiState = uiState,
                isHi = isHi,
                onReadEbook = { ebookItem -> viewModel.openReader(ebookItem, 0) },
                onDownloadEbookOffline = { ebookItem -> viewModel.cacheStudyItemForOffline(ebookItem) },
                onOpenFullEbookLibraryTab = { viewModel.navigateTo(AppScreen.LIBRARY) }
            )
        }

        // Section 1.35: Dedicated UP Police Constable & Sub-Inspector (UPP / UP SI — 150 Qs • 300 Marks • 50 Paid Tests) Card
        if (uiState.isTestSeriesVisibleOnDashboard("up_police")) {
        item {
            com.example.ui.components.UpPoliceDashboardTestSeriesCard(
                uiState = uiState,
                isHi = isHi,
                onSelectTestSeriesMode = { mode -> viewModel.selectExamTestSeriesMode("up_police", mode) },
                onStartUpPoliceTest = { testId -> viewModel.startUpPoliceTest(testId) },
                onOpenUpPoliceHub = {
                    val subCat = ExamCatalogData.categories.firstOrNull { it.id == "subordinate_selection" }
                    viewModel.selectCategory(subCat)
                    viewModel.navigateTo(AppScreen.EXPLORER)
                },
                onBuyOrOpenPaidItem = { item -> viewModel.openItemDetail(item) },
                onAddPaidItemToCart = { item -> viewModel.addToCart(item) }
            )
        }
        }

        // Section 1.4: UPSC CSE Prelims Special — "Attempt Free Test (अटेम्प्ट फ्री टेस्ट)" with 7 Subject Sections (50 PYQs Each)
        if (uiState.isTestSeriesVisibleOnDashboard("upsc")) {
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 10.dp)
                    .border(2.dp, SaffronGold, RoundedCornerShape(16.dp))
                    .testTag("home_upsc_free_test_card"),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = com.example.ui.components.EdTechProColors.DeepRoyalNavy),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(4.dp))
                                        .background(EmeraldSuccess)
                                        .padding(horizontal = 6.dp, vertical = 2.dp)
                                ) {
                                    Text(
                                        text = "UPSC CSE • 350 PYQs",
                                        fontSize = 9.5.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = Color.White,
                                        maxLines = 1,
                                        softWrap = false
                                    )
                                }
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = "Last 5 Years PYQ (2020–2025)",
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = SaffronGold,
                                    maxLines = 1,
                                    softWrap = false,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = if (isHi)
                                    "UPSC सिविल सेवा प्रारंभिक — 7 विषय (50-50 प्रश्न)"
                                else
                                    "UPSC CSE Prelims — 7 Subject Sections (50 Qs Each)",
                                fontSize = 14.5.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.White,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Text(
                                text = if (isHi)
                                    "हिस्ट्री • पॉलिटी • ज्योग्राफी • इकोनॉमिक्स • एनवायरनमेंट • साइंस • करंट अफेयर्स (Bilingual)"
                                else
                                    "History • Polity • Geography • Economy • Environment • Sci-Tech • Current Affairs (Bilingual)",
                                fontSize = 11.sp,
                                color = Color(0xFFCBD5E1),
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        com.example.ui.components.TestSeriesCircularProgressRing(
                            progress = uiState.getExamCategoryProgress("upsc"),
                            seriesKey = "card_upsc",
                            size = 48.dp,
                            strokeWidth = 4.5.dp,
                            accentColor = Color(0xFF38BDF8)
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    val upscMode = uiState.examTestSeriesModeMap["upsc"] ?: "FREE"
                    com.example.ui.components.ExamPaidFreeDualTabs(
                        examKey = "upsc",
                        examLabelEn = "UPSC CSE (IAS/IPS)",
                        examLabelHi = "UPSC सिविल सेवा (IAS/IPS)",
                        selectedMode = upscMode,
                        freeCountBadge = if (isHi) "7 विषय • 350 फ्री PYQs" else "7 Subjects • 350 Free PYQs",
                        paidCountBadge = if (isHi) "40 फुल-लेंथ प्रो मॉक टेस्ट" else "40 Full-Length Pro Mocks",
                        isHi = isHi,
                        onSelectMode = { mode -> viewModel.selectExamTestSeriesMode("upsc", mode) }
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Button(
                            onClick = { viewModel.toggleUpscFreeTestSections() },
                            colors = ButtonDefaults.buttonColors(containerColor = SaffronGold),
                            shape = RoundedCornerShape(10.dp),
                            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 0.dp),
                            modifier = Modifier
                                .weight(1f)
                                .height(44.dp)
                                .testTag("home_upsc_attempt_free_test_btn")
                        ) {
                            Text(
                                text = if (uiState.isUpscFreeTestSectionExpanded) {
                                    if (isHi) "UPSC फ्री टेस्ट (7 सेक्शन) ▲" else "UPSC Free Test (7 Sections) ▲"
                                } else {
                                    if (isHi) "UPSC अटेम्प्ट फ्री टेस्ट ▼" else "UPSC Attempt Free Test ▼"
                                },
                                fontSize = 12.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Navy900,
                                maxLines = 1,
                                softWrap = false,
                                overflow = TextOverflow.Ellipsis
                            )
                        }

                        Button(
                            onClick = { viewModel.openUpscSectionAndExpandFreeTests() },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E293B)),
                            shape = RoundedCornerShape(10.dp),
                            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 0.dp),
                            modifier = Modifier.height(44.dp)
                        ) {
                            Text(
                                text = if (isHi) "UPSC सेक्शन >" else "UPSC Hub >",
                                fontSize = 11.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = SaffronGold,
                                maxLines = 1,
                                softWrap = false
                            )
                        }
                    }

                    if (upscMode == "PAID") {
                        val upscPaidItems = uiState.customStudyItems.filter {
                            it.categoryId == "upsc" && it.discountedPrice > 0
                        }
                        com.example.ui.components.ExamPaidTestSeriesPanel(
                            examKey = "upsc",
                            examTitleEn = "UPSC CSE Prelims & Mains",
                            examTitleHi = "UPSC सिविल सेवा प्रारंभिक एवं मुख्य परीक्षा",
                            paidItems = upscPaidItems,
                            purchasedItemIds = uiState.purchasedItemIds,
                            isHi = isHi,
                            onBuyOrOpenItem = { viewModel.openItemDetail(it) },
                            onAddToCart = { viewModel.addToCart(it) },
                            onStartPaidMockTest = { viewModel.startUpscSectionTest("upsc_history") },
                            onSwitchToFreeTests = { viewModel.selectExamTestSeriesMode("upsc", "FREE") }
                        )
                    } else if (uiState.isUpscFreeTestSectionExpanded) {
                        val upscSections = com.example.data.upsc.UpscSciTechIrCaPyqData.all7UpscSectionTests
                        Spacer(modifier = Modifier.height(12.dp))
                        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                            upscSections.forEachIndexed { idx, section ->
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(10.dp))
                                        .background(Color(0xFF1E293B))
                                        .clickable { viewModel.startUpscSectionTest(section.sectionId) }
                                        .padding(horizontal = 12.dp, vertical = 9.dp)
                                        .testTag("home_upsc_section_${section.sectionId}"),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.weight(1f)
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .size(28.dp)
                                                .clip(CircleShape)
                                                .background(SaffronGold),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text(
                                                text = "${idx + 1}",
                                                fontSize = 11.5.sp,
                                                fontWeight = FontWeight.ExtraBold,
                                                color = Navy900
                                            )
                                        }
                                        Spacer(modifier = Modifier.width(10.dp))
                                        Column(modifier = Modifier.weight(1f)) {
                                            Text(
                                                text = section.titleEn,
                                                fontSize = 12.5.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Color.White
                                            )
                                            Text(
                                                text = "50 UPSC PYQ Questions • +2.0/-0.66 • Answer & Bilingual Explanation",
                                                fontSize = 10.sp,
                                                color = EmeraldLight
                                            )
                                            com.example.ui.components.SectionTestProgressBar(
                                                progress = uiState.getSectionProgress(section.mockTest.testId, 50),
                                                sectionKey = section.sectionId,
                                                isHi = isHi
                                            )
                                        }
                                    }
                                    Box(
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(6.dp))
                                            .background(EmeraldSuccess)
                                            .padding(horizontal = 10.dp, vertical = 5.dp)
                                    ) {
                                        Text(
                                            text = if (isHi) "अटेम्प्ट (50 Q)" else "Start 50-Q",
                                            fontSize = 10.5.sp,
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
        }

        // Section 1.5: UPPCS Special — "Attempt Free Test (अटेम्प्ट फ्री टेस्ट)" with 7 Subject Sections (50 PYQs Each)
        if (uiState.isTestSeriesVisibleOnDashboard("uppcs")) {
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 14.dp)
                    .border(2.dp, SaffronGold, RoundedCornerShape(16.dp))
                    .testTag("home_uppcs_free_test_card"),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = com.example.ui.components.EdTechProColors.DeepRoyalNavy),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(4.dp))
                                        .background(EmeraldSuccess)
                                        .padding(horizontal = 6.dp, vertical = 2.dp)
                                ) {
                                    Text(
                                        text = "UPPCS • 350 PYQs",
                                        fontSize = 9.5.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = Color.White,
                                        maxLines = 1,
                                        softWrap = false
                                    )
                                }
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = "Last 5 Years PYQ (2020–2025)",
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = SaffronGold,
                                    maxLines = 1,
                                    softWrap = false,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = if (isHi)
                                    "UPPCS प्रारंभिक परीक्षा — 7 विषय (50-50 प्रश्न)"
                                else
                                    "UPPCS Prelims — 7 Subject Sections (50 Qs Each)",
                                fontSize = 14.5.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.White,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Text(
                                text = if (isHi)
                                    "हिस्ट्री • पॉलिटी • ज्योग्राफी • एनवायरनमेंट • साइंस एंड टेक • यूपी करंट अफेयर्स • इकोनॉमिक्स (Bilingual)"
                                else
                                    "History • Polity • Geography • Environment • Science & Tech • UP Current Affairs • Economics (Bilingual)",
                                fontSize = 11.sp,
                                color = Color(0xFFCBD5E1),
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        com.example.ui.components.TestSeriesCircularProgressRing(
                            progress = uiState.getExamCategoryProgress("uppcs"),
                            seriesKey = "card_uppcs",
                            size = 48.dp,
                            strokeWidth = 4.5.dp,
                            accentColor = Color(0xFF60A5FA)
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    val uppcsMode = uiState.examTestSeriesModeMap["uppcs"] ?: "FREE"
                    com.example.ui.components.ExamPaidFreeDualTabs(
                        examKey = "uppcs",
                        examLabelEn = "UPPCS (Uttar Pradesh PCS)",
                        examLabelHi = "UPPCS (उत्तर प्रदेश पीसीएस)",
                        selectedMode = uppcsMode,
                        freeCountBadge = if (isHi) "7 विषय • 350 फ्री PYQs" else "7 Subjects • 350 Free PYQs",
                        paidCountBadge = if (isHi) "35 फुल-लेंथ प्रो मॉक टेस्ट" else "35 Full-Length Pro Mocks",
                        isHi = isHi,
                        onSelectMode = { mode -> viewModel.selectExamTestSeriesMode("uppcs", mode) }
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Button(
                            onClick = { viewModel.toggleUppcsFreeTestSections() },
                            colors = ButtonDefaults.buttonColors(containerColor = SaffronGold),
                            shape = RoundedCornerShape(10.dp),
                            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 0.dp),
                            modifier = Modifier
                                .weight(1f)
                                .height(44.dp)
                                .testTag("home_uppcs_attempt_free_test_btn")
                        ) {
                            Text(
                                text = if (uiState.isUppcsFreeTestSectionExpanded) {
                                    if (isHi) "UPPCS फ्री टेस्ट (7 सेक्शन) ▲" else "UPPCS Free Test (7 Sections) ▲"
                                } else {
                                    if (isHi) "UPPCS अटेम्प्ट फ्री टेस्ट ▼" else "UPPCS Attempt Free Test ▼"
                                },
                                fontSize = 12.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Navy900,
                                maxLines = 1,
                                softWrap = false,
                                overflow = TextOverflow.Ellipsis
                            )
                        }

                        Button(
                            onClick = { viewModel.openUppcsSectionAndExpandFreeTests() },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E293B)),
                            shape = RoundedCornerShape(10.dp),
                            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 0.dp),
                            modifier = Modifier.height(44.dp)
                        ) {
                            Text(
                                text = if (isHi) "UPPCS सेक्शन >" else "UPPCS Hub >",
                                fontSize = 11.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = SaffronGold,
                                maxLines = 1,
                                softWrap = false
                            )
                        }
                    }

                    if (uppcsMode == "PAID") {
                        val uppcsPaidItems = uiState.customStudyItems.filter {
                            it.subSectionId == "psc_uppcs" && it.discountedPrice > 0
                        }
                        com.example.ui.components.ExamPaidTestSeriesPanel(
                            examKey = "uppcs",
                            examTitleEn = "UPPCS Upper & RO/ARO",
                            examTitleHi = "UPPCS प्रवर एवं RO/ARO परीक्षा",
                            paidItems = uppcsPaidItems,
                            purchasedItemIds = uiState.purchasedItemIds,
                            isHi = isHi,
                            onBuyOrOpenItem = { viewModel.openItemDetail(it) },
                            onAddToCart = { viewModel.addToCart(it) },
                            onStartPaidMockTest = { viewModel.startUppcsSectionTest("uppcs_history") },
                            onSwitchToFreeTests = { viewModel.selectExamTestSeriesMode("uppcs", "FREE") }
                        )
                    } else if (uiState.isUppcsFreeTestSectionExpanded) {
                        val uppcsSections = com.example.data.uppcs.UppcsUpCaEcoPyqData.all7UppcsSectionTests
                        Spacer(modifier = Modifier.height(12.dp))
                        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                            uppcsSections.forEachIndexed { idx, section ->
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(10.dp))
                                        .background(Color(0xFF1E293B))
                                        .clickable { viewModel.startUppcsSectionTest(section.sectionId) }
                                        .padding(horizontal = 12.dp, vertical = 9.dp)
                                        .testTag("home_uppcs_section_${section.sectionId}"),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.weight(1f)
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .size(28.dp)
                                                .clip(CircleShape)
                                                .background(SaffronGold),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text(
                                                text = "${idx + 1}",
                                                fontSize = 11.5.sp,
                                                fontWeight = FontWeight.ExtraBold,
                                                color = Navy900
                                            )
                                        }
                                        Spacer(modifier = Modifier.width(10.dp))
                                        Column(modifier = Modifier.weight(1f)) {
                                            Text(
                                                text = "${section.titleEn} (${section.titleHi})",
                                                fontSize = 12.5.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Color.White
                                            )
                                            Text(
                                                text = "50 PYQ Questions • 4 Options • Answer & Bilingual Explanation",
                                                fontSize = 10.sp,
                                                color = EmeraldLight
                                            )
                                            com.example.ui.components.SectionTestProgressBar(
                                                progress = uiState.getSectionProgress(section.mockTest.testId, 50),
                                                sectionKey = section.sectionId,
                                                isHi = isHi
                                            )
                                        }
                                    }
                                    Box(
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(6.dp))
                                            .background(EmeraldSuccess)
                                            .padding(horizontal = 10.dp, vertical = 5.dp)
                                    ) {
                                        Text(
                                            text = if (isHi) "अटेम्प्ट (50 Q)" else "Start 50-Q",
                                            fontSize = 10.5.sp,
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
        }

        // Section 1.6: UKPSC (Uttarakhand PCS) Special — "Attempt Free Test (अटेम्प्ट फ्री टेस्ट)" with ★ Uttarakhand Special (100 PYQs) + 7 Subject Sections (50 PYQs Each)
        if (uiState.isTestSeriesVisibleOnDashboard("ukpsc")) {
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 10.dp)
                    .border(2.dp, SaffronGold, RoundedCornerShape(16.dp))
                    .testTag("home_ukpsc_free_test_card"),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = com.example.ui.components.EdTechProColors.DeepRoyalNavy),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(4.dp))
                                        .background(SaffronGold)
                                        .padding(horizontal = 6.dp, vertical = 2.dp)
                                ) {
                                    Text(
                                        text = "UKPSC • 450 PYQs",
                                        fontSize = 9.5.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = Navy900,
                                        maxLines = 1,
                                        softWrap = false
                                    )
                                }
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = "★ Uttarakhand Special Top 100 PYQs",
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFFFDE68A),
                                    maxLines = 1,
                                    softWrap = false,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = if (isHi)
                                    "UKPSC (उत्तराखंड पीसीएस) — उत्तराखंड विशेष 100 Q + 7 विषय"
                                else
                                    "UKPSC (Uttarakhand PCS) — UK Special 100 Qs + 7 Subjects",
                                fontSize = 14.5.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.White,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Text(
                                text = if (isHi)
                                    "★ उत्तराखंड विशेष (100 Q) • हिस्ट्री • पॉलिटी • ज्योग्राफी • इकोनॉमिक्स • एनवायरनमेंट • साइंस • करंट अफेयर्स"
                                else
                                    "★ Uttarakhand Special (100 Qs) • History • Polity • Geography • Economics • Environment • Sci-Tech • Current Affairs",
                                fontSize = 11.sp,
                                color = Color(0xFFD1FAE5),
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        com.example.ui.components.TestSeriesCircularProgressRing(
                            progress = uiState.getExamCategoryProgress("ukpsc"),
                            seriesKey = "card_ukpsc",
                            size = 48.dp,
                            strokeWidth = 4.5.dp,
                            accentColor = Color(0xFF34D399)
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    val ukpscMode = uiState.examTestSeriesModeMap["ukpsc"] ?: "FREE"
                    com.example.ui.components.ExamPaidFreeDualTabs(
                        examKey = "ukpsc",
                        examLabelEn = "UKPSC (Uttarakhand PCS)",
                        examLabelHi = "UKPSC (उत्तराखंड पीसीएस)",
                        selectedMode = ukpscMode,
                        freeCountBadge = if (isHi) "8 सेक्शन • 450 फ्री PYQs" else "8 Sections • 450 Free PYQs",
                        paidCountBadge = if (isHi) "35 फुल-लेंथ प्रो मॉक टेस्ट" else "35 Full-Length Pro Mocks",
                        isHi = isHi,
                        onSelectMode = { mode -> viewModel.selectExamTestSeriesMode("ukpsc", mode) }
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    // Direct One-Tap Banner for "★ उत्तराखंड विशेष (Uttarakhand Special — Top 100 Last 5 Years PYQs)"
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(com.example.ui.components.EdTechProColors.RoyalIndigo)
                            .border(1.5.dp, SaffronGold, RoundedCornerShape(10.dp))
                            .clickable { viewModel.startUkpscSectionTest("ukpsc_special_100") }
                            .padding(horizontal = 12.dp, vertical = 10.dp)
                            .testTag("home_ukpsc_special_100_direct_btn")
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = if (isHi)
                                        "★ उत्तराखंड विशेष (Uttarakhand Special) — टॉप 100 PYQs"
                                    else
                                        "★ Uttarakhand Special (उत्तराखंड विशेष) — Top 100 PYQs",
                                    fontSize = 12.5.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color(0xFFFDE68A),
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                                Text(
                                    text = if (isHi)
                                        "विगत 5 वर्षों के संपूर्ण उत्तराखंड पीसीएस प्रीलिम्स PYQs • 100 प्रश्न • +1.0 / -0.25"
                                    else
                                        "All Last 5 Years UKPSC Prelims PYQs • 100 Bilingual Questions • +1.0 / -0.25",
                                    fontSize = 10.5.sp,
                                    color = Color.White,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(SaffronGold)
                                    .padding(horizontal = 10.dp, vertical = 6.dp)
                            ) {
                                Text(
                                    text = if (isHi) "अटेम्प्ट (100 Q)" else "Start 100-Q",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Navy900,
                                    maxLines = 1,
                                    softWrap = false
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Button(
                            onClick = { viewModel.toggleUkpscFreeTestSections() },
                            colors = ButtonDefaults.buttonColors(containerColor = SaffronGold),
                            shape = RoundedCornerShape(10.dp),
                            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 0.dp),
                            modifier = Modifier
                                .weight(1f)
                                .height(44.dp)
                                .testTag("home_ukpsc_attempt_free_test_btn")
                        ) {
                            Text(
                                text = if (uiState.isUkpscFreeTestSectionExpanded) {
                                    if (isHi) "UKPSC फ्री टेस्ट (8 सेक्शन) ▲" else "UKPSC Free Test (8 Sections) ▲"
                                } else {
                                    if (isHi) "UKPSC अटेम्प्ट फ्री टेस्ट ▼" else "UKPSC Attempt Free Test ▼"
                                },
                                fontSize = 12.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Navy900,
                                maxLines = 1,
                                softWrap = false,
                                overflow = TextOverflow.Ellipsis
                            )
                        }

                        Button(
                            onClick = { viewModel.openUkpscSectionAndExpandFreeTests() },
                            colors = ButtonDefaults.buttonColors(containerColor = Navy900),
                            shape = RoundedCornerShape(10.dp),
                            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 0.dp),
                            modifier = Modifier
                                .height(44.dp)
                                .testTag("home_ukpsc_hub_btn")
                        ) {
                            Text(
                                text = if (isHi) "UKPSC सेक्शन >" else "UKPSC Hub >",
                                fontSize = 11.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = SaffronGold,
                                maxLines = 1,
                                softWrap = false
                            )
                        }
                    }

                    if (ukpscMode == "PAID") {
                        val ukpscPaidItems = uiState.customStudyItems.filter {
                            it.subSectionId == "psc_ukpsc" && it.discountedPrice > 0
                        }
                        com.example.ui.components.ExamPaidTestSeriesPanel(
                            examKey = "ukpsc",
                            examTitleEn = "UKPSC Upper PCS & RO/ARO",
                            examTitleHi = "उत्तराखंड पीसीएस (प्रवर एवं RO/ARO)",
                            paidItems = ukpscPaidItems,
                            purchasedItemIds = uiState.purchasedItemIds,
                            isHi = isHi,
                            onBuyOrOpenItem = { viewModel.openItemDetail(it) },
                            onAddToCart = { viewModel.addToCart(it) },
                            onStartPaidMockTest = { viewModel.startUkpscSectionTest("ukpsc_special_100") },
                            onSwitchToFreeTests = { viewModel.selectExamTestSeriesMode("ukpsc", "FREE") }
                        )
                    } else if (uiState.isUkpscFreeTestSectionExpanded) {
                        val ukpscSections = com.example.data.ukpsc.UkpscAllSubjectsPyqData.all8UkpscSectionTests
                        Spacer(modifier = Modifier.height(12.dp))
                        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                            ukpscSections.forEachIndexed { idx, section ->
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(10.dp))
                                        .background(if (section.isSpecial100) Color(0xFF0F172A) else com.example.ui.components.EdTechProColors.ElevatedNavy)
                                        .border(
                                            width = if (section.isSpecial100) 1.5.dp else 1.dp,
                                            color = if (section.isSpecial100) SaffronGold else com.example.ui.components.EdTechProColors.SlateBorder,
                                            shape = RoundedCornerShape(10.dp)
                                        )
                                        .clickable { viewModel.startUkpscSectionTest(section.sectionId) }
                                        .padding(horizontal = 12.dp, vertical = 9.dp)
                                        .testTag("home_ukpsc_section_${section.sectionId}"),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.weight(1f)
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .size(28.dp)
                                                .clip(CircleShape)
                                                .background(SaffronGold),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text(
                                                text = if (section.isSpecial100) "★" else "${idx + 1}",
                                                fontSize = 11.5.sp,
                                                fontWeight = FontWeight.ExtraBold,
                                                color = Navy900
                                            )
                                        }
                                        Spacer(modifier = Modifier.width(10.dp))
                                        Column(modifier = Modifier.weight(1f)) {
                                            Text(
                                                text = if (isHi) section.titleHi else section.titleEn,
                                                fontSize = 12.5.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = if (section.isSpecial100) Color(0xFFFDE68A) else Color.White
                                            )
                                            Text(
                                                text = "${section.questionCount} UKPSC PYQ Questions • +1.0/-0.25 • Bilingual Answer & Explanation",
                                                fontSize = 10.sp,
                                                color = Color(0xFFD1FAE5)
                                            )
                                            com.example.ui.components.SectionTestProgressBar(
                                                progress = uiState.getSectionProgress(section.mockTest.testId, section.questionCount),
                                                sectionKey = section.sectionId,
                                                isHi = isHi
                                            )
                                        }
                                    }
                                    Box(
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(6.dp))
                                            .background(if (section.isSpecial100) SaffronGold else EmeraldSuccess)
                                            .padding(horizontal = 10.dp, vertical = 5.dp)
                                    ) {
                                        Text(
                                            text = if (isHi) "अटेम्प्ट (${section.questionCount} Q)" else "Start ${section.questionCount}-Q",
                                            fontSize = 10.5.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            color = if (section.isSpecial100) Navy900 else Color.White
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        }

        // Section 1.7: BPSC (Bihar PCS — 70th/71st CCE) — 1. Paid Test Series & 2. Free Test Series (7 Sections × 100 Questions = 700 PYQs)
        if (uiState.isTestSeriesVisibleOnDashboard("bpsc")) {
        item {
            val bpscMode = uiState.examTestSeriesModeMap["bpsc"] ?: "FREE"
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 10.dp)
                    .border(2.dp, SaffronGold, RoundedCornerShape(16.dp))
                    .testTag("home_bpsc_free_test_card"),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = com.example.ui.components.EdTechProColors.DeepRoyalNavy),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(4.dp))
                                        .background(SaffronGold)
                                        .padding(horizontal = 6.dp, vertical = 2.dp)
                                ) {
                                    Text(
                                        text = "BPSC 7×100 PYQs • 700 Qs",
                                        fontSize = 9.5.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = Navy900,
                                        maxLines = 1,
                                        softWrap = false
                                    )
                                }
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = "★ 100-100 Qs Per Subject",
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFFFDE68A),
                                    maxLines = 1,
                                    softWrap = false,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = if (isHi)
                                    "BPSC (बिहार पीसीएस) — 100-100 प्रश्नों की विषयवार टेस्ट सीरीज़"
                                else
                                    "BPSC (Bihar PCS Prelims) — 100-100 Qs Subject-Wise Test Series",
                                fontSize = 14.5.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.White,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Text(
                                text = if (isHi)
                                    "★ बिहार विशेष (100 Q) • हिस्ट्री • पॉलिटी • ज्योग्राफी • इकोनॉमी • साइंस • करंट अफेयर्स (100-100 प्रश्न)"
                                else
                                    "★ Bihar Special (100 Q) • History • Polity • Geography • Economy • Science • Current Affairs (100 Qs Each)",
                                fontSize = 11.sp,
                                color = Color(0xFFFED7AA),
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        com.example.ui.components.TestSeriesCircularProgressRing(
                            progress = uiState.getExamCategoryProgress("bpsc"),
                            seriesKey = "card_bpsc",
                            size = 48.dp,
                            strokeWidth = 4.5.dp,
                            accentColor = Color(0xFFFB923C)
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    com.example.ui.components.ExamPaidFreeDualTabs(
                        examKey = "bpsc",
                        examLabelEn = "BPSC (Bihar PCS)",
                        examLabelHi = "BPSC (बिहार पीसीएस)",
                        selectedMode = bpscMode,
                        freeCountBadge = if (isHi) "7 सेक्शन × 100 Q = 700 फ्री PYQs" else "7 Sections × 100 Q = 700 Free PYQs",
                        paidCountBadge = if (isHi) "40 फुल-लेंथ प्रो मॉक टेस्ट" else "40 Full-Length Pro Mocks",
                        isHi = isHi,
                        onSelectMode = { mode -> viewModel.selectExamTestSeriesMode("bpsc", mode) }
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    // Direct One-Tap Banner for "★ बिहार विशेष (Bihar Special — 100 PYQs)"
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(com.example.ui.components.EdTechProColors.RoyalIndigo)
                            .border(1.5.dp, SaffronGold, RoundedCornerShape(10.dp))
                            .clickable { viewModel.startBpscSectionTest("bpsc_bihar_special") }
                            .padding(horizontal = 12.dp, vertical = 10.dp)
                            .testTag("home_bpsc_special_100_direct_btn")
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = if (isHi)
                                        "★ बिहार विशेष (Bihar Special) — टॉप 100 PYQ सेट"
                                    else
                                        "★ Bihar Special (बिहार विशेष) — Top 100 PYQ Set",
                                    fontSize = 12.5.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color(0xFFFDE68A),
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                                Text(
                                    text = if (isHi)
                                        "66वीं से 70वीं BPSC के बिहार विशेष, हिस्ट्री, नदियाँ एवं बजट के 100 प्रश्न • +1.0 / -0.33"
                                    else
                                        "66th–70th BPSC Bihar History, Rivers, Minerals, Census & Survey • 100 Qs • +1.0 / -0.33",
                                    fontSize = 10.5.sp,
                                    color = Color.White,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(SaffronGold)
                                    .padding(horizontal = 10.dp, vertical = 6.dp)
                            ) {
                                Text(
                                    text = if (isHi) "अटेम्प्ट (100 Q)" else "Start 100-Q",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Navy900,
                                    maxLines = 1,
                                    softWrap = false
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Button(
                            onClick = { viewModel.toggleBpscFreeTestSections() },
                            colors = ButtonDefaults.buttonColors(containerColor = SaffronGold),
                            shape = RoundedCornerShape(10.dp),
                            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 0.dp),
                            modifier = Modifier
                                .weight(1f)
                                .height(44.dp)
                                .testTag("home_bpsc_attempt_free_test_btn")
                        ) {
                            Text(
                                text = if (uiState.isBpscFreeTestSectionExpanded) {
                                    if (isHi) "BPSC फ्री टेस्ट (7×100 Q) ▲" else "BPSC Free Test (7×100 Qs) ▲"
                                } else {
                                    if (isHi) "BPSC अटेम्प्ट फ्री टेस्ट (7×100 Q) ▼" else "BPSC Attempt Free Test ▼"
                                },
                                fontSize = 12.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Navy900,
                                maxLines = 1,
                                softWrap = false,
                                overflow = TextOverflow.Ellipsis
                            )
                        }

                        Button(
                            onClick = { viewModel.openBpscSectionAndExpandFreeTests() },
                            colors = ButtonDefaults.buttonColors(containerColor = Navy900),
                            shape = RoundedCornerShape(10.dp),
                            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 0.dp),
                            modifier = Modifier
                                .height(44.dp)
                                .testTag("home_bpsc_hub_btn")
                        ) {
                            Text(
                                text = if (isHi) "BPSC सेक्शन >" else "BPSC Hub >",
                                fontSize = 11.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = SaffronGold,
                                maxLines = 1,
                                softWrap = false
                            )
                        }
                    }

                    if (bpscMode == "PAID") {
                        val bpscPaidItems = uiState.customStudyItems.filter {
                            it.subSectionId == "psc_bpsc" && it.discountedPrice > 0
                        }
                        com.example.ui.components.ExamPaidTestSeriesPanel(
                            examKey = "bpsc",
                            examTitleEn = "70th/71st BPSC Combined Prelims & Mains",
                            examTitleHi = "70वीं/71वीं बीपीएससी (BPSC) प्रारंभिक एवं मुख्य परीक्षा",
                            paidItems = bpscPaidItems,
                            purchasedItemIds = uiState.purchasedItemIds,
                            isHi = isHi,
                            onBuyOrOpenItem = { viewModel.openItemDetail(it) },
                            onAddToCart = { viewModel.addToCart(it) },
                            onStartPaidMockTest = { viewModel.startBpscSectionTest("bpsc_bihar_special") },
                            onSwitchToFreeTests = { viewModel.selectExamTestSeriesMode("bpsc", "FREE") }
                        )
                    } else if (uiState.isBpscFreeTestSectionExpanded) {
                        val bpscSections = com.example.data.bpsc.BpscAllSubjects100PyqData.all7BpscSectionTests
                        Spacer(modifier = Modifier.height(12.dp))
                        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                            bpscSections.forEachIndexed { idx, section ->
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(10.dp))
                                        .background(if (section.isBiharSpecial) Color(0xFF0F172A) else com.example.ui.components.EdTechProColors.ElevatedNavy)
                                        .border(
                                            width = if (section.isBiharSpecial) 1.5.dp else 1.dp,
                                            color = if (section.isBiharSpecial) SaffronGold else com.example.ui.components.EdTechProColors.SlateBorder,
                                            shape = RoundedCornerShape(10.dp)
                                        )
                                        .clickable { viewModel.startBpscSectionTest(section.sectionId) }
                                        .padding(horizontal = 12.dp, vertical = 9.dp)
                                        .testTag("home_bpsc_section_${section.sectionId}"),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.weight(1f)
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .size(28.dp)
                                                .clip(CircleShape)
                                                .background(SaffronGold),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text(
                                                text = if (section.isBiharSpecial) "★" else "${idx + 1}",
                                                fontSize = 11.5.sp,
                                                fontWeight = FontWeight.ExtraBold,
                                                color = Navy900
                                            )
                                        }
                                        Spacer(modifier = Modifier.width(10.dp))
                                        Column(modifier = Modifier.weight(1f)) {
                                            Text(
                                                text = if (isHi) section.titleHi else section.titleEn,
                                                fontSize = 12.5.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = if (section.isBiharSpecial) Color(0xFFFDE68A) else Color.White
                                            )
                                            Text(
                                                text = "100 BPSC PYQ Questions • +1.0/-0.33 • Classroom Bilingual Explanation",
                                                fontSize = 10.sp,
                                                color = Color(0xFFFED7AA)
                                            )
                                            com.example.ui.components.SectionTestProgressBar(
                                                progress = uiState.getSectionProgress(section.mockTest.testId, 100),
                                                sectionKey = section.sectionId,
                                                isHi = isHi
                                            )
                                        }
                                    }
                                    Box(
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(6.dp))
                                            .background(if (section.isBiharSpecial) SaffronGold else EmeraldSuccess)
                                            .padding(horizontal = 10.dp, vertical = 5.dp)
                                    ) {
                                        Text(
                                            text = if (isHi) "अटेम्प्ट (100 Q)" else "Start 100-Q",
                                            fontSize = 10.5.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            color = if (section.isBiharSpecial) Navy900 else Color.White
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        }

        // Section 1.8: UPSSSC (PET, VDO, Lekhpal, Junior Assistant, Lower PCS) — 1. Paid Test Series & 2. Free Test Series (9 Sections • 1,050 PYQs)
        if (uiState.isTestSeriesVisibleOnDashboard("upsssc")) {
        item {
            val upssscMode = uiState.examTestSeriesModeMap["upsssc"] ?: "FREE"
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 10.dp)
                    .border(2.dp, SaffronGold, RoundedCornerShape(16.dp))
                    .testTag("home_upsssc_free_test_card"),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = com.example.ui.components.EdTechProColors.DeepRoyalNavy),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(4.dp))
                                        .background(SaffronGold)
                                        .padding(horizontal = 6.dp, vertical = 2.dp)
                                ) {
                                    Text(
                                        text = "UPSSSC • 1,050 PYQs",
                                        fontSize = 9.5.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = Navy900,
                                        maxLines = 1,
                                        softWrap = false
                                    )
                                }
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = "★ UP Special 250 Qs + Computer + DI",
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFFFDE68A),
                                    maxLines = 1,
                                    softWrap = false,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = if (isHi)
                                    "UPSSSC (PET, VDO, लेखपाल) — 9 सेक्शन (1,050 प्रश्न)"
                                else
                                    "UPSSSC (PET, VDO, Lekhpal) — 9 Sections (1,050 PYQs)",
                                fontSize = 14.5.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.White,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Text(
                                text = if (isHi)
                                    "GK (6 विषय × 100 Q) • ★ यूपी स्पेशल (Best 250 Q) • कंप्यूटर (100 Q) • डीआई / DI (100 Q)"
                                else
                                    "GK (6 Subjects × 100 Q) • ★ UP Special (Best 250 Qs) • Computer (100 Qs) • DI (100 Qs)",
                                fontSize = 11.sp,
                                color = Color(0xFFE0E7FF),
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        com.example.ui.components.TestSeriesCircularProgressRing(
                            progress = uiState.getExamCategoryProgress("upsssc"),
                            seriesKey = "card_upsssc",
                            size = 48.dp,
                            strokeWidth = 4.5.dp,
                            accentColor = Color(0xFF818CF8)
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    com.example.ui.components.ExamPaidFreeDualTabs(
                        examKey = "upsssc",
                        examLabelEn = "UPSSSC (PET / VDO / Lekhpal)",
                        examLabelHi = "UPSSSC (यूपी ट्रिपल एससी)",
                        selectedMode = upssscMode,
                        freeCountBadge = if (isHi) "9 सेक्शन • 1,050 फ्री PYQs" else "9 Sections • 1,050 Free PYQs",
                        paidCountBadge = if (isHi) "45 फुल-लेंथ प्रो मॉक टेस्ट" else "45 Full-Length Pro Mocks",
                        isHi = isHi,
                        onSelectMode = { mode -> viewModel.selectExamTestSeriesMode("upsssc", mode) }
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    // Direct One-Tap Banner for "★ यूपी स्पेशल (UP Special — Best 250 UPSSSC PYQs)"
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color(0xFF312E81))
                            .border(1.5.dp, SaffronGold, RoundedCornerShape(10.dp))
                            .clickable { viewModel.startUpssscSectionTest("upsssc_up_special_250") }
                            .padding(horizontal = 12.dp, vertical = 10.dp)
                            .testTag("home_upsssc_up_special_250_direct_btn")
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = if (isHi)
                                        "★ यूपी स्पेशल (UP Special) — सर्वश्रेष्ठ 250 UPSSSC प्रश्न"
                                    else
                                        "★ UP Special (यूपी स्पेशल) — Best 250 UPSSSC PYQs",
                                    fontSize = 12.5.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color(0xFFFDE68A),
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                                Text(
                                    text = if (isHi)
                                        "यूपी इतिहास, ODOP, नदियाँ, जनगणना, लोक नृत्य व बजट के टॉप 250 प्रश्न • +1.0 / -0.25"
                                    else
                                        "Complete UP GK, ODOP, Folk Culture, Rivers, Census & UP Budget • Best 250 Qs • +1.0 / -0.25",
                                    fontSize = 10.5.sp,
                                    color = Color.White,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(SaffronGold)
                                    .padding(horizontal = 10.dp, vertical = 6.dp)
                            ) {
                                Text(
                                    text = if (isHi) "अटेम्प्ट (250 Q)" else "Start 250-Q",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Navy900,
                                    maxLines = 1,
                                    softWrap = false
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Button(
                            onClick = { viewModel.toggleUpssscFreeTestSections() },
                            colors = ButtonDefaults.buttonColors(containerColor = SaffronGold),
                            shape = RoundedCornerShape(10.dp),
                            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 0.dp),
                            modifier = Modifier
                                .weight(1f)
                                .height(44.dp)
                                .testTag("home_upsssc_attempt_free_test_btn")
                        ) {
                            Text(
                                text = if (uiState.isUpssscFreeTestSectionExpanded) {
                                    if (isHi) "UPSSSC फ्री टेस्ट (9 सेक्शन) ▲" else "UPSSSC Free Test (9 Sections) ▲"
                                } else {
                                    if (isHi) "UPSSSC अटेम्प्ट फ्री टेस्ट ▼" else "UPSSSC Attempt Free Test ▼"
                                },
                                fontSize = 12.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Navy900,
                                maxLines = 1,
                                softWrap = false,
                                overflow = TextOverflow.Ellipsis
                            )
                        }

                        Button(
                            onClick = { viewModel.openUpssscSectionAndExpandFreeTests() },
                            colors = ButtonDefaults.buttonColors(containerColor = Navy900),
                            shape = RoundedCornerShape(10.dp),
                            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 0.dp),
                            modifier = Modifier
                                .height(44.dp)
                                .testTag("home_upsssc_hub_btn")
                        ) {
                            Text(
                                text = if (isHi) "UPSSSC सेक्शन >" else "UPSSSC Hub >",
                                fontSize = 11.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = SaffronGold,
                                maxLines = 1,
                                softWrap = false
                            )
                        }
                    }

                    if (upssscMode == "PAID") {
                        val upssscPaidItems = uiState.customStudyItems.filter {
                            it.subSectionId == "sub_upsssc" && it.discountedPrice > 0
                        }
                        com.example.ui.components.ExamPaidTestSeriesPanel(
                            examKey = "upsssc",
                            examTitleEn = "UPSSSC PET, VDO, Lekhpal & Jr. Assistant",
                            examTitleHi = "UPSSSC (PET, VDO, लेखपाल, कनिष्ठ सहायक)",
                            paidItems = upssscPaidItems,
                            purchasedItemIds = uiState.purchasedItemIds,
                            isHi = isHi,
                            onBuyOrOpenItem = { viewModel.openItemDetail(it) },
                            onAddToCart = { viewModel.addToCart(it) },
                            onStartPaidMockTest = { viewModel.startUpssscSectionTest("upsssc_up_special_250") },
                            onSwitchToFreeTests = { viewModel.selectExamTestSeriesMode("upsssc", "FREE") }
                        )
                    } else if (uiState.isUpssscFreeTestSectionExpanded) {
                        val upssscSections = com.example.data.upsssc.UpssscAllSubjectsPyqData.all9UpssscSectionTests
                        Spacer(modifier = Modifier.height(12.dp))
                        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                            upssscSections.forEachIndexed { idx, section ->
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(10.dp))
                                        .background(if (section.isUpSpecial250) Color(0xFF0F172A) else Color(0xFF312E81))
                                        .border(
                                            width = if (section.isUpSpecial250) 1.5.dp else 1.dp,
                                            color = if (section.isUpSpecial250) SaffronGold else Color(0xFF818CF8),
                                            shape = RoundedCornerShape(10.dp)
                                        )
                                        .clickable { viewModel.startUpssscSectionTest(section.sectionId) }
                                        .padding(horizontal = 12.dp, vertical = 9.dp)
                                        .testTag("home_upsssc_section_${section.sectionId}"),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.weight(1f)
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .size(28.dp)
                                                .clip(CircleShape)
                                                .background(SaffronGold),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text(
                                                text = if (section.isUpSpecial250) "★" else "${idx + 1}",
                                                fontSize = 11.5.sp,
                                                fontWeight = FontWeight.ExtraBold,
                                                color = Navy900
                                            )
                                        }
                                        Spacer(modifier = Modifier.width(10.dp))
                                        Column(modifier = Modifier.weight(1f)) {
                                            Text(
                                                text = if (isHi) section.titleHi else section.titleEn,
                                                fontSize = 12.5.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = if (section.isUpSpecial250) Color(0xFFFDE68A) else Color.White,
                                                maxLines = 1,
                                                overflow = TextOverflow.Ellipsis
                                            )
                                            Text(
                                                text = "${section.questionCount} UPSSSC PYQ Questions • +1.0/-0.25 • Bilingual Explanation",
                                                fontSize = 10.sp,
                                                color = Color(0xFFE0E7FF),
                                                maxLines = 1,
                                                overflow = TextOverflow.Ellipsis
                                            )
                                            com.example.ui.components.SectionTestProgressBar(
                                                progress = uiState.getSectionProgress(section.mockTest.testId, section.questionCount),
                                                sectionKey = section.sectionId,
                                                isHi = isHi
                                            )
                                        }
                                    }
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Box(
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(6.dp))
                                            .background(if (section.isUpSpecial250) SaffronGold else EmeraldSuccess)
                                            .padding(horizontal = 10.dp, vertical = 5.dp)
                                    ) {
                                        Text(
                                            text = if (isHi) "अटेम्प्ट (${section.questionCount} Q)" else "Start ${section.questionCount}-Q",
                                            fontSize = 10.5.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            color = if (section.isUpSpecial250) Navy900 else Color.White,
                                            maxLines = 1,
                                            softWrap = false
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        }

        // Section 1.9: UKSSSC (Uttarakhand Group C & Group D — VDO, Patwari, Kanishth Sahayak, Forest Guard, Police) — 1. Paid Test Series & 2. Free Test Series (10 Sections • 1,150 PYQs)
        if (uiState.isTestSeriesVisibleOnDashboard("uksssc")) {
        item {
            val ukssscMode = uiState.examTestSeriesModeMap["uksssc"] ?: "FREE"
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 10.dp)
                    .border(2.dp, SaffronGold, RoundedCornerShape(16.dp))
                    .testTag("home_uksssc_free_test_card"),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = com.example.ui.components.EdTechProColors.DeepRoyalNavy),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(4.dp))
                                        .background(SaffronGold)
                                        .padding(horizontal = 6.dp, vertical = 2.dp)
                                ) {
                                    Text(
                                        text = "UKSSSC • 1,150 PYQs",
                                        fontSize = 9.5.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = Navy900,
                                        maxLines = 1,
                                        softWrap = false
                                    )
                                }
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = "★ उत्तराखंड स्पेशल 250 Qs + 9 विषय",
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFFFDE68A),
                                    maxLines = 1,
                                    softWrap = false,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = if (isHi)
                                    "UKSSSC (उत्तराखंड समूह 'ग' एवं 'घ') — 10 सेक्शन टेस्ट सीरीज़"
                                else
                                    "UKSSSC (Uttarakhand Group C & D) — 10 Sections Test Series",
                                fontSize = 14.5.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.White,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Text(
                                text = if (isHi)
                                    "★ उत्तराखंड स्पेशल (250 Q) • GK 6 विषय (100-100 Q) • सामान्य हिंदी (100 Q) • कंप्यूटर (100 Q) • रीजनिंग व DI (100 Q)"
                                else
                                    "★ Uttarakhand Special (250 Qs) • GK 6 Subjects (100 Qs Each) • Hindi (100 Qs) • Computer (100 Qs) • Reasoning & DI (100 Qs)",
                                fontSize = 11.sp,
                                color = Color(0xFFCCFBF1),
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        com.example.ui.components.TestSeriesCircularProgressRing(
                            progress = uiState.getExamCategoryProgress("uksssc"),
                            seriesKey = "card_uksssc",
                            size = 48.dp,
                            strokeWidth = 4.5.dp,
                            accentColor = Color(0xFF2DD4BF)
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    com.example.ui.components.ExamPaidFreeDualTabs(
                        examKey = "uksssc",
                        examLabelEn = "UKSSSC (Uttarakhand Group C & D)",
                        examLabelHi = "UKSSSC (उत्तराखंड समूह 'ग' एवं 'घ')",
                        selectedMode = ukssscMode,
                        freeCountBadge = if (isHi) "10 सेक्शन • 1,150 फ्री PYQs" else "10 Sections • 1,150 Free PYQs",
                        paidCountBadge = if (isHi) "40 फुल-लेंथ प्रो मॉक टेस्ट" else "40 Full-Length Pro Mocks",
                        isHi = isHi,
                        onSelectMode = { mode -> viewModel.selectExamTestSeriesMode("uksssc", mode) }
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    // Direct One-Tap Banner for "★ उत्तराखंड स्पेशल (Uttarakhand Special — Best 250 UKSSSC PYQs)"
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color(0xFF0F766E))
                            .border(1.5.dp, SaffronGold, RoundedCornerShape(10.dp))
                            .clickable { viewModel.startUkssscSectionTest("uksssc_uk_special_250") }
                            .padding(horizontal = 12.dp, vertical = 10.dp)
                            .testTag("home_uksssc_uk_special_250_direct_btn")
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = if (isHi)
                                        "★ उत्तराखंड स्पेशल (Uttarakhand Special) — टॉप 250 PYQs"
                                    else
                                        "★ Uttarakhand Special (उत्तराखंड स्पेशल) — Best 250 PYQs",
                                    fontSize = 12.5.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color(0xFFFDE68A),
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                                Text(
                                    text = if (isHi)
                                        "UKSSSC समूह 'ग'/'घ' (40% भार) — कत्यूरी, चंद, परमार वंश, 13 जिले, पंच प्रयाग व बुग्याल के 250 प्रश्न • +1.0 / -0.25"
                                    else
                                        "UKSSSC Group C/D (40% Weightage) — Katyuri, Chand, Parmar, 13 Districts, Prayag & Bugyals • 250 Qs • +1.0 / -0.25",
                                    fontSize = 10.5.sp,
                                    color = Color.White,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(SaffronGold)
                                    .padding(horizontal = 10.dp, vertical = 6.dp)
                            ) {
                                Text(
                                    text = if (isHi) "अटेम्प्ट (250 Q)" else "Start 250-Q",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Navy900,
                                    maxLines = 1,
                                    softWrap = false
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Button(
                            onClick = { viewModel.toggleUkssscFreeTestSections() },
                            colors = ButtonDefaults.buttonColors(containerColor = SaffronGold),
                            shape = RoundedCornerShape(10.dp),
                            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 0.dp),
                            modifier = Modifier
                                .weight(1f)
                                .height(44.dp)
                                .testTag("home_uksssc_attempt_free_test_btn")
                        ) {
                            Text(
                                text = if (uiState.isUkssscFreeTestSectionExpanded) {
                                    if (isHi) "UKSSSC फ्री टेस्ट (10 सेक्शन) ▲" else "UKSSSC Free Test (10 Sections) ▲"
                                } else {
                                    if (isHi) "UKSSSC अटेम्प्ट फ्री टेस्ट ▼" else "UKSSSC Attempt Free Test ▼"
                                },
                                fontSize = 12.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Navy900,
                                maxLines = 1,
                                softWrap = false,
                                overflow = TextOverflow.Ellipsis
                            )
                        }

                        Button(
                            onClick = { viewModel.openUkssscSectionAndExpandFreeTests() },
                            colors = ButtonDefaults.buttonColors(containerColor = Navy900),
                            shape = RoundedCornerShape(10.dp),
                            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 0.dp),
                            modifier = Modifier
                                .height(44.dp)
                                .testTag("home_uksssc_hub_btn")
                        ) {
                            Text(
                                text = if (isHi) "UKSSSC सेक्शन >" else "UKSSSC Hub >",
                                fontSize = 11.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = SaffronGold,
                                maxLines = 1,
                                softWrap = false
                            )
                        }
                    }

                    if (ukssscMode == "PAID") {
                        val ukssscPaidItems = uiState.customStudyItems.filter {
                            it.subSectionId == "sub_uksssc" && it.discountedPrice > 0
                        }
                        com.example.ui.components.ExamPaidTestSeriesPanel(
                            examKey = "uksssc",
                            examTitleEn = "UKSSSC Group C & D (VDO, Patwari, Kanishth Sahayak, Forest Guard)",
                            examTitleHi = "UKSSSC समूह 'ग' एवं 'घ' (VDO, पटवारी, कनिष्ठ सहायक, वन आरक्षी)",
                            paidItems = ukssscPaidItems,
                            purchasedItemIds = uiState.purchasedItemIds,
                            isHi = isHi,
                            onBuyOrOpenItem = { viewModel.openItemDetail(it) },
                            onAddToCart = { viewModel.addToCart(it) },
                            onStartPaidMockTest = { viewModel.startUkssscSectionTest("uksssc_uk_special_250") },
                            onSwitchToFreeTests = { viewModel.selectExamTestSeriesMode("uksssc", "FREE") }
                        )
                    } else if (uiState.isUkssscFreeTestSectionExpanded) {
                        val ukssscSections = com.example.data.uksssc.UkssscAllSubjectsPyqData.all10UkssscSectionTests
                        Spacer(modifier = Modifier.height(12.dp))
                        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                            ukssscSections.forEachIndexed { idx, section ->
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(10.dp))
                                        .background(if (section.isUkSpecial250) Color(0xFF0F172A) else Color(0xFF115E59))
                                        .border(
                                            width = if (section.isUkSpecial250) 1.5.dp else 1.dp,
                                            color = if (section.isUkSpecial250) SaffronGold else Color(0xFF2DD4BF),
                                            shape = RoundedCornerShape(10.dp)
                                        )
                                        .clickable { viewModel.startUkssscSectionTest(section.sectionId) }
                                        .padding(horizontal = 12.dp, vertical = 9.dp)
                                        .testTag("home_uksssc_section_${section.sectionId}"),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.weight(1f)
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .size(28.dp)
                                                .clip(CircleShape)
                                                .background(SaffronGold),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text(
                                                text = if (section.isUkSpecial250) "★" else "${idx + 1}",
                                                fontSize = 11.5.sp,
                                                fontWeight = FontWeight.ExtraBold,
                                                color = Navy900
                                            )
                                        }
                                        Spacer(modifier = Modifier.width(10.dp))
                                        Column(modifier = Modifier.weight(1f)) {
                                            Text(
                                                text = if (isHi) section.titleHi else section.titleEn,
                                                fontSize = 12.5.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = if (section.isUkSpecial250) Color(0xFFFDE68A) else Color.White,
                                                maxLines = 1,
                                                overflow = TextOverflow.Ellipsis
                                            )
                                            Text(
                                                text = "${section.questionCount} UKSSSC PYQ Questions • +1.0/-0.25 • Bilingual Explanation",
                                                fontSize = 10.sp,
                                                color = Color(0xFFCCFBF1),
                                                maxLines = 1,
                                                overflow = TextOverflow.Ellipsis
                                            )
                                            com.example.ui.components.SectionTestProgressBar(
                                                progress = uiState.getSectionProgress(section.mockTest.testId, section.questionCount),
                                                sectionKey = section.sectionId,
                                                isHi = isHi
                                            )
                                        }
                                    }
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Box(
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(6.dp))
                                            .background(if (section.isUkSpecial250) SaffronGold else EmeraldSuccess)
                                            .padding(horizontal = 10.dp, vertical = 5.dp)
                                    ) {
                                        Text(
                                            text = if (isHi) "अटेम्प्ट (${section.questionCount} Q)" else "Start ${section.questionCount}-Q",
                                            fontSize = 10.5.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            color = if (section.isUkSpecial250) Navy900 else Color.White,
                                            maxLines = 1,
                                            softWrap = false
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        }

        // Section 1.10: SSC Exam Section Component (SSC CGL / CHSL / CPO Tabs • Free & Paid Toggles • 8 Sections × 100 PYQs)
        if (uiState.isTestSeriesVisibleOnDashboard("ssc")) {
        item {
            com.example.ui.components.SscExamSectionComponent(
                uiState = uiState,
                isHi = isHi,
                cardTestTag = "home_ssc_free_test_card",
                attemptButtonTestTag = "home_ssc_attempt_free_test_btn",
                sectionRowTagPrefix = "home_ssc_section_",
                showHubButton = true,
                onSelectExamTab = { tabCode -> viewModel.selectSscExamTab(tabCode) },
                onSelectTestSeriesMode = { mode -> viewModel.selectExamTestSeriesMode("ssc", mode) },
                onSelectSubjectFilter = { filter -> viewModel.selectSscSubjectFilter(filter) },
                onToggleExpandFreeTests = { viewModel.toggleSscFreeTestSections() },
                onOpenSscHub = { viewModel.openSscSectionAndExpandFreeTests() },
                onStartSectionTest = { sectionId -> viewModel.startSscSectionTest(sectionId) },
                onBuyOrOpenPaidItem = { item -> viewModel.openItemDetail(item) },
                onAddPaidItemToCart = { item -> viewModel.addToCart(item) }
            )
        }
        }

        // Section 1.105: IIT JEE Exam Section Component (Top IIT JEE Icon • Paid vs Free Test Series • 1. IIT JEE Main & 2. IIT JEE Advanced • 5 Subjects × 100 PYQs Each)
        if (uiState.isTestSeriesVisibleOnDashboard("iit_jee")) {
        item {
            com.example.ui.components.IitJeeExamSectionComponent(
                uiState = uiState,
                isHi = isHi,
                cardTestTag = "home_iit_jee_free_test_card",
                attemptButtonTestTag = "home_iit_jee_attempt_free_test_btn",
                sectionRowTagPrefix = "home_iit_jee_section_",
                showHubButton = true,
                onSelectLevelTab = { levelTab -> viewModel.selectIitJeeLevelTab(levelTab) },
                onSelectTestSeriesMode = { mode -> viewModel.selectExamTestSeriesMode("iit_jee", mode) },
                onSelectSubjectFilter = { filter -> viewModel.selectIitJeeSubjectFilter(filter) },
                onToggleExpandFreeTests = { viewModel.toggleIitJeeFreeTestSections() },
                onOpenIitJeeHub = { viewModel.openIitJeeSectionAndExpandFreeTests() },
                onStartSectionTest = { sectionId -> viewModel.startIitJeeSectionTest(sectionId) },
                onBuyOrOpenPaidItem = { item -> viewModel.openItemDetail(item) },
                onAddPaidItemToCart = { item -> viewModel.addToCart(item) }
            )
        }
        }

        // Section 1.106: NEET (UG) Exam Section Component (Top NEET Icon • Paid vs Free Test Series • 6 Subjects × 100 PYQs Each = 600 Qs)
        if (uiState.isTestSeriesVisibleOnDashboard("neet")) {
        item {
            com.example.ui.components.NeetExamSectionComponent(
                uiState = uiState,
                isHi = isHi,
                cardTestTag = "home_neet_free_test_card",
                attemptButtonTestTag = "home_neet_attempt_free_test_btn",
                sectionRowTagPrefix = "home_neet_section_",
                showHubButton = true,
                onSelectTestSeriesMode = { mode -> viewModel.selectExamTestSeriesMode("neet", mode) },
                onSelectSubjectFilter = { filter -> viewModel.selectNeetSubjectFilter(filter) },
                onToggleExpandFreeTests = { viewModel.toggleNeetFreeTestSections() },
                onOpenNeetHub = { viewModel.openNeetSectionAndExpandFreeTests() },
                onStartSectionTest = { sectionId -> viewModel.startNeetSectionTest(sectionId) },
                onBuyOrOpenPaidItem = { item -> viewModel.openItemDetail(item) },
                onAddPaidItemToCart = { item -> viewModel.addToCart(item) }
            )
        }
        }

        // Section 1.107: UGC NET Exam Section Component (Top UGC NET Icon • Paid vs Free Test Series • 1. Paper 1 [10 Units × 100 MCQs] & 2. Paper 2 [12 Subjects × 100 MCQs] = 2,200 PYQs)
        if (uiState.isTestSeriesVisibleOnDashboard("ugc_net")) {
        item {
            com.example.ui.components.UgcNetExamSectionComponent(
                uiState = uiState,
                isHi = isHi,
                cardTestTag = "home_ugc_net_free_test_card",
                attemptButtonTestTag = "home_ugc_net_attempt_free_test_btn",
                sectionRowTagPrefix = "home_ugc_net_section_",
                showHubButton = true,
                onSelectPaperTab = { paperTab -> viewModel.selectUgcNetPaperTab(paperTab) },
                onSelectTestSeriesMode = { mode -> viewModel.selectExamTestSeriesMode("ugc_net", mode) },
                onSelectSubjectFilter = { filter -> viewModel.selectUgcNetSubjectFilter(filter) },
                onToggleExpandFreeTests = { viewModel.toggleUgcNetFreeTestSections() },
                onOpenUgcNetHub = { viewModel.openUgcNetSectionAndExpandFreeTests() },
                onStartSectionTest = { sectionId -> viewModel.startUgcNetSectionTest(sectionId) },
                onBuyOrOpenPaidItem = { item -> viewModel.openItemDetail(item) },
                onAddPaidItemToCart = { item -> viewModel.addToCart(item) }
            )
        }
        }

        // Section 1.108: Teaching Eligibility Test (TET — सीटेट CTET • यूपीटेट UPTET • यूटेट व अन्य) Exam Section Component (7 Subjects × 100 PYQs = 700 Qs)
        if (uiState.isTestSeriesVisibleOnDashboard("tet")) {
        item {
            com.example.ui.components.TetExamSectionComponent(
                uiState = uiState,
                isHi = isHi,
                cardTestTag = "home_tet_free_test_card",
                attemptButtonTestTag = "home_tet_attempt_free_test_btn",
                sectionRowTagPrefix = "home_tet_section",
                showHubButton = true,
                onSelectExamTab = { examTab -> viewModel.selectTetExamTab(examTab) },
                onSelectTestSeriesMode = { mode -> viewModel.selectExamTestSeriesMode("tet", mode) },
                onSelectSubjectFilter = { filter -> viewModel.selectTetSubjectFilter(filter) },
                onToggleExpandFreeTests = { viewModel.toggleTetFreeTestSections() },
                onOpenTetHub = { viewModel.openTetSectionAndExpandFreeTests() },
                onStartSectionTest = { sectionId -> viewModel.startTetSectionTest(sectionId) },
                onBuyOrOpenPaidItem = { item -> viewModel.openItemDetail(item) },
                onAddPaidItemToCart = { item -> viewModel.addToCart(item) }
            )
        }
        }

        // Section 1.11: Banking (IBPS PO / Clerk, SBI PO / Clerk & RBI Grade B) Test Series Card
        if (uiState.isTestSeriesVisibleOnDashboard("banking")) {
        item {
            com.example.ui.components.BankingDashboardTestSeriesCard(
                uiState = uiState,
                isHi = isHi,
                onSelectTestSeriesMode = { mode -> viewModel.selectExamTestSeriesMode("banking", mode) },
                onStartBankingTest = { viewModel.selectPyqTestByCategory("banking") },
                onOpenBankingHub = {
                    val bankCat = ExamCatalogData.categories.firstOrNull { it.id == "banking" }
                    viewModel.selectCategory(bankCat)
                    viewModel.navigateTo(AppScreen.EXPLORER)
                },
                onBuyOrOpenPaidItem = { item -> viewModel.openItemDetail(item) },
                onAddPaidItemToCart = { item -> viewModel.addToCart(item) }
            )
        }
        }

        // Section 1.12: Railways (RRB NTPC, Group D & ALP) Test Series Card
        if (uiState.isTestSeriesVisibleOnDashboard("railways")) {
        item {
            com.example.ui.components.RailwaysDashboardTestSeriesCard(
                uiState = uiState,
                isHi = isHi,
                onSelectTestSeriesMode = { mode -> viewModel.selectExamTestSeriesMode("railways", mode) },
                onStartRailwaysTest = { viewModel.selectPyqTestByCategory("railways") },
                onOpenRailwaysHub = {
                    val railCat = ExamCatalogData.categories.firstOrNull { it.id == "railways" }
                    viewModel.selectCategory(railCat)
                    viewModel.navigateTo(AppScreen.EXPLORER)
                },
                onBuyOrOpenPaidItem = { item -> viewModel.openItemDetail(item) },
                onAddPaidItemToCart = { item -> viewModel.addToCart(item) }
            )
        }
        }

        // Section 2: Special 50% Discount Coupon Card
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 18.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(
                        Brush.horizontalGradient(
                            listOf(Color(0xFFFFF7ED), Color(0xFFFEF3C7))
                        )
                    )
                    .border(1.dp, Color(0xFFFDE68A), RoundedCornerShape(16.dp))
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = if (isHi) "विशेष ऑफर" else "SPECIAL OFFER",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = SaffronGold
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(4.dp))
                                    .background(SaffronGold)
                                    .padding(horizontal = 6.dp, vertical = 2.dp)
                            ) {
                                Text(
                                    text = "FLAT 50% OFF",
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color.White
                                )
                            }
                        }
                        Text(
                            text = if (isHi) "कूपन कोड: SHAKUNTALAM50" else "Coupon Code: SHAKUNTALAM50",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Navy900,
                            modifier = Modifier.padding(top = 2.dp)
                        )
                        Text(
                            text = if (isHi) "सभी ई-बुक्स एवं टेस्ट सीरीज़ पर तुरंत 50% छूट प्राप्त करें।" else "Get instant 50% discount on all E-Books & Test Series.",
                            fontSize = 11.sp,
                            color = Color(0xFF78350F)
                        )
                    }
                    Button(
                        onClick = {
                            viewModel.applyCoupon("SHAKUNTALAM50")
                            viewModel.navigateTo(AppScreen.CART)
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Navy900),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text(
                            text = if (isHi) "लागू करें" else "Apply",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }
        }

        // Section 2.5: Official PDF Corner (E-Books & Notes for smooth reading & downloading)
        item {
            Column(modifier = Modifier.padding(top = 8.dp, bottom = 14.dp)) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(6.dp))
                                    .background(Color(0xFFDC2626))
                                    .padding(horizontal = 6.dp, vertical = 2.dp)
                            ) {
                                Text(
                                    text = "PDF CORNER",
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color.White
                                )
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = if (isHi) "ई-बुक्स एवं नोट्स कॉर्नर" else "Free PDFs & E-Book Corner",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = Navy900
                            )
                        }
                        Text(
                            text = if (isHi) "एप्लिकेशन में सीधे पढ़ें या पीडीएफ ऑफलाइन डाउनलोड करें" else "Read directly in-app or download offline to your device",
                            fontSize = 11.5.sp,
                            color = Color(0xFF64748B),
                            modifier = Modifier.padding(top = 2.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    // Uploaded documents from Owner / Room DB
                    if (uiState.uploadedDocuments.isNotEmpty()) {
                        items(uiState.uploadedDocuments) { doc ->
                            Card(
                                modifier = Modifier
                                    .width(260.dp)
                                    .testTag("pdf_card_${doc.id}"),
                                shape = RoundedCornerShape(14.dp),
                                colors = CardDefaults.cardColors(containerColor = Color.White),
                                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                            ) {
                                Column(modifier = Modifier.padding(14.dp)) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .clip(RoundedCornerShape(6.dp))
                                                .background(Color(0xFFFEE2E2))
                                                .padding(horizontal = 8.dp, vertical = 3.dp)
                                        ) {
                                            Text(
                                                text = "PDF • ${doc.examId.uppercase()}",
                                                fontSize = 10.5.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Color(0xFFB91C1C)
                                            )
                                        }

                                        Text(
                                            text = if (doc.discountedPrice == 0) (if (isHi) "निःशुल्क" else "FREE") else "₹${doc.discountedPrice}",
                                            fontSize = 13.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            color = if (doc.discountedPrice == 0) EmeraldSuccess else Navy900
                                        )
                                    }

                                    Spacer(modifier = Modifier.height(8.dp))

                                    Text(
                                        text = if (isHi) doc.hindiTitle else doc.title,
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Navy900,
                                        maxLines = 2
                                    )

                                    Text(
                                        text = "${doc.subjectId.replace('_', ' ').uppercase()} • ${doc.pageCount} ${if (isHi) "पृष्ठ" else "Pages"} • ${doc.fileSizeFormatted}",
                                        fontSize = 11.5.sp,
                                        color = Color(0xFF64748B),
                                        modifier = Modifier.padding(top = 4.dp)
                                    )

                                    Spacer(modifier = Modifier.height(12.dp))

                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                                    ) {
                                        Button(
                                            onClick = { viewModel.openPdfForReading(doc) },
                                            modifier = Modifier
                                                .weight(1f)
                                                .height(36.dp)
                                                .testTag("pdf_read_btn_${doc.id}"),
                                            colors = ButtonDefaults.buttonColors(containerColor = Navy900),
                                            shape = RoundedCornerShape(8.dp),
                                            contentPadding = PaddingValues(horizontal = 6.dp)
                                        ) {
                                            Text(
                                                text = if (isHi) "पढ़ें" else "Read PDF",
                                                fontSize = 11.5.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Color.White
                                            )
                                        }

                                        Button(
                                            onClick = { viewModel.downloadPdf(doc.title, doc.fileName) },
                                            modifier = Modifier
                                                .weight(1f)
                                                .height(36.dp)
                                                .testTag("pdf_dl_btn_${doc.id}"),
                                            colors = ButtonDefaults.buttonColors(containerColor = SaffronGold),
                                            shape = RoundedCornerShape(8.dp),
                                            contentPadding = PaddingValues(horizontal = 6.dp)
                                        ) {
                                            Icon(
                                                imageVector = Icons.Default.Download,
                                                contentDescription = null,
                                                tint = Color.White,
                                                modifier = Modifier.size(14.dp)
                                            )
                                            Spacer(modifier = Modifier.width(4.dp))
                                            Text(
                                                text = if (isHi) "डाउनलोड" else "Download",
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

                    // Default Sample PDF Notes Cards for instant access
                    item {
                        Card(
                            modifier = Modifier
                                .width(260.dp)
                                .testTag("pdf_card_default_sample"),
                            shape = RoundedCornerShape(14.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                        ) {
                            Column(modifier = Modifier.padding(14.dp)) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(6.dp))
                                            .background(EmeraldLight)
                                            .padding(horizontal = 8.dp, vertical = 3.dp)
                                    ) {
                                        Text(
                                            text = "PDF • UPSC GS",
                                            fontSize = 10.5.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = EmeraldSuccess
                                        )
                                    }

                                    Text(
                                        text = if (isHi) "निःशुल्क" else "FREE",
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = EmeraldSuccess
                                    )
                                }

                                Spacer(modifier = Modifier.height(8.dp))

                                Text(
                                    text = if (isHi) "UPSC प्रारंभिक परीक्षा इतिहास सार संग्रह" else "UPSC Prelims Ancient & Modern History Summary",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Navy900,
                                    maxLines = 2
                                )

                                Text(
                                    text = "General Studies • 120 ${if (isHi) "पृष्ठ" else "Pages"} • 14.2 MB",
                                    fontSize = 11.5.sp,
                                    color = Color(0xFF64748B),
                                    modifier = Modifier.padding(top = 4.dp)
                                )

                                Spacer(modifier = Modifier.height(12.dp))

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    Button(
                                        onClick = {
                                            val firstBook = uiState.customStudyItems.firstOrNull { it.type == ContentType.EBOOK }
                                            if (firstBook != null) viewModel.openReader(firstBook)
                                        },
                                        modifier = Modifier
                                            .weight(1f)
                                            .height(36.dp),
                                        colors = ButtonDefaults.buttonColors(containerColor = Navy900),
                                        shape = RoundedCornerShape(8.dp),
                                        contentPadding = PaddingValues(horizontal = 6.dp)
                                    ) {
                                        Text(
                                            text = if (isHi) "पढ़ें" else "Read PDF",
                                            fontSize = 11.5.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color.White
                                        )
                                    }

                                    Button(
                                        onClick = {
                                            viewModel.downloadPdf(
                                                "UPSC Prelims History Summary Notes",
                                                "upsc_history_summary_notes.pdf"
                                            )
                                        },
                                        modifier = Modifier
                                            .weight(1f)
                                            .height(36.dp),
                                        colors = ButtonDefaults.buttonColors(containerColor = SaffronGold),
                                        shape = RoundedCornerShape(8.dp),
                                        contentPadding = PaddingValues(horizontal = 6.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Download,
                                            contentDescription = null,
                                            tint = Color.White,
                                            modifier = Modifier.size(14.dp)
                                        )
                                        Spacer(modifier = Modifier.width(4.dp))
                                        Text(
                                            text = if (isHi) "डाउनलोड" else "Download",
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

        // Section 3: Study Items (E-books & Test Series)
        item {
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = if (uiState.searchQuery.isNotEmpty()) {
                                if (isHi) "खोज परिणाम (${filteredItems.size})" else "Search Results (${filteredItems.size})"
                            } else {
                                if (isHi) "लोकप्रिय ई-बुक्स एवं टेस्ट सीरीज़" else "Popular E-Books & Test Series"
                            },
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Navy900
                        )
                        Text(
                            text = if (isHi) "शकुंतलम संपादकीय बोर्ड द्वारा नवीनतम पाठ्यक्रम आधारित" else "Latest syllabus-aligned material by Shakuntalam Editorial Board",
                            fontSize = 11.5.sp,
                            color = Color(0xFF64748B)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(12.dp))
            }
        }

        // List of Study Items
        if (filteredItems.isEmpty()) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(40.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = null,
                            tint = Color(0xFF94A3B8),
                            modifier = Modifier.size(48.dp)
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = if (isHi) "कोई सामग्री नहीं मिली" else "No study material found",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = Navy900
                        )
                        Text(
                            text = if (isHi) "कृपया अन्य विषय या कीवर्ड से खोजें" else "Please try searching with a different subject or keyword",
                            fontSize = 12.sp,
                            color = Color(0xFF64748B)
                        )
                    }
                }
            }
        } else {
            items(filteredItems) { item ->
                StudyItemCard(
                    item = item,
                    isWishlisted = uiState.wishlistIds.contains(item.id),
                    isPurchased = uiState.purchasedItemIds.contains(item.id),
                    isInCart = uiState.cartItems.any { it.studyItem.id == item.id },
                    onItemClick = { viewModel.openItemDetail(item) },
                    onReadSample = {
                        if (item.type == ContentType.EBOOK) {
                            viewModel.openReader(item)
                        } else {
                            viewModel.startTest()
                        }
                    },
                    onAddToCart = { viewModel.addToCart(item) },
                    onToggleWishlist = { viewModel.toggleWishlist(item.id) },
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp),
                    isHi = isHi
                )
            }
        }

        // Section 4: Cross-Platform Compatibility & Cyber Security Shield Banner
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 14.dp)
                    .testTag("home_security_platform_banner"),
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(containerColor = Navy900)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.WorkspacePremium,
                                contentDescription = null,
                                tint = EmeraldSuccess,
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = if (isHi) "क्रॉस-प्लेटफ़ॉर्म एवं 256-बिट सुरक्षा प्रमाणित" else "Cross-Platform & 256-Bit SHA-256 Secured",
                                fontSize = 13.5.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.White
                            )
                        }
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(6.dp))
                                .background(SaffronGold)
                                .padding(horizontal = 8.dp, vertical = 3.dp)
                        ) {
                            Text(
                                text = "PROTECTED",
                                fontSize = 9.5.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Navy900
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = if (isHi) {
                            "• Android मोबाइल, टैबलेट, डेस्कटॉप एवं वेब पोर्टल के साथ 100% संगत।\n• हैकर-रोधी SQLi/XSS फ़ायरवॉल एवं DRM स्क्रीनशॉट लॉक सक्रिय।\n• आधिकारिक लिंक्ड UPI: ${uiState.ownerUpiId} (${uiState.ownerUpiMobile})"
                        } else {
                            "• Seamless compatibility across Android, Tablets, Chromebooks & Web Portals.\n• Anti-Hacker SQLi/XSS Input Firewall & DRM PDF Anti-Piracy Shield active.\n• Official Verified UPI: ${uiState.ownerUpiId} (${uiState.ownerUpiMobile})"
                        },
                        fontSize = 11.sp,
                        color = Color(0xFFCBD5E1),
                        lineHeight = 16.sp
                    )
                }
            }
        }
    }
}

@Composable
fun ExamCategoryQuickCard(
    category: ExamCategory,
    isHi: Boolean = false,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .width(160.dp)
            .clickable(onClick = onClick)
            .testTag("category_card_${category.id}"),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Navy100),
                    contentAlignment = Alignment.Center
                ) {
                    val icon = getCategoryIcon(category.iconKey)
                    Icon(
                        imageVector = icon,
                        contentDescription = category.name,
                        tint = Navy900,
                        modifier = Modifier.size(20.dp)
                    )
                }

                if (category.badge.isNotEmpty()) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(4.dp))
                            .background(AmberLight)
                            .padding(horizontal = 6.dp, vertical = 2.dp)
                    ) {
                        Text(
                            text = category.badge,
                            fontSize = 9.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF92400E)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Exam Category Name in English (as requested)
            Text(
                text = category.name,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = Navy900,
                maxLines = 1
            )
            Text(
                text = if (isHi) "${category.subSections.size} सब-सेक्शन उपलब्ध" else "${category.subSections.size} Sub-sections",
                fontSize = 11.sp,
                color = SaffronGold,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

fun getCategoryIcon(key: String): ImageVector {
    return when (key) {
        "AccountBalance" -> Icons.Default.AccountBalance
        "Gavel" -> Icons.Default.Gavel
        "Assignment" -> Icons.Default.Assignment
        "Badge" -> Icons.Default.Badge
        "Train" -> Icons.Default.Train
        "Payments" -> Icons.Default.Payments
        "Biotech" -> Icons.Default.Biotech
        "School" -> Icons.Default.School
        "Psychology" -> Icons.Default.Psychology
        "LaptopMac" -> Icons.Default.LaptopMac
        "SmartToy" -> Icons.Default.SmartToy
        "WorkspacePremium" -> Icons.Default.WorkspacePremium
        else -> Icons.Default.AccountBalance
    }
}
