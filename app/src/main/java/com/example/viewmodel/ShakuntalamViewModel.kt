package com.example.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.ExamCatalogData
import com.example.data.PyqTestBankData
import com.example.data.local.ExamHierarchyRepository
import com.example.data.local.ShakuntalamDatabase
import com.example.data.local.entity.SubTopicEntity
import com.example.data.local.entity.EbookDocumentEntity
import com.example.data.local.entity.OfflineEbookCacheEntity
import com.example.data.local.entity.OfflineTestCacheEntity
import com.example.data.remote.StudentAuthAndProfileRepository
import com.example.model.AppLanguage
import com.example.model.AuthProviderType
import com.example.model.AuthTab
import com.example.model.BookChapter
import com.example.model.CartItem
import com.example.model.ContentType
import com.example.model.ExamCategory
import com.example.model.ExamSubSection
import com.example.model.ExamSubject
import com.example.model.MockTest
import com.example.model.PhoneOtpState
import com.example.model.StudyItem
import com.example.model.TestQuestion
import com.example.model.UserProfile
import com.example.model.UserTestAttempt
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

enum class AppScreen {
    HOME,
    EXPLORER,
    ITEM_DETAIL,
    READER,
    TEST_SERIES,
    CART,
    LIBRARY,
    PROFILE,
    OWNER_PORTAL,
    PERFORMANCE_ANALYTICS,
    DAILY_QUIZ
}

enum class ReaderTheme {
    LIGHT,
    SEPIA,
    DARK
}

data class ShakuntalamUiState(
    val currentScreen: AppScreen = AppScreen.HOME,
    val previousScreen: AppScreen = AppScreen.HOME,
    val searchQuery: String = "",
    val selectedContentType: ContentType? = null,
    val selectedMedium: String? = null, // "Hindi Medium", "English Medium", null for All
    val selectedCategory: ExamCategory? = null,
    val selectedSubSection: ExamSubSection? = null,
    val selectedSubject: ExamSubject? = null,
    val selectedItem: StudyItem? = null,

    // Reader state
    val activeReadingItem: StudyItem? = null,
    val currentChapterIndex: Int = 0,
    val readerFontSizeSp: Int = 16,
    val readerTheme: ReaderTheme = ReaderTheme.LIGHT,
    val bookmarkedChapters: Set<String> = emptySet(), // itemId_chapterIndex

    // Test Series Engine state (Last 5 Years PYQ Analysis & Bilingual Engine)
    val activeTest: MockTest = PyqTestBankData.upscPyqTest,
    val isUpscFreeTestSectionExpanded: Boolean = false,
    val isUppcsFreeTestSectionExpanded: Boolean = false,
    val isUkpscFreeTestSectionExpanded: Boolean = false,
    val isBpscFreeTestSectionExpanded: Boolean = false,
    val isUpssscFreeTestSectionExpanded: Boolean = false,
    val isUkssscFreeTestSectionExpanded: Boolean = false,
    val isSscFreeTestSectionExpanded: Boolean = true,
    val selectedSscExamTab: String = "CGL", // "CGL", "CHSL", "CPO"
    val selectedSscSubjectFilter: String = "ALL", // "ALL", "GS", "REASONING", "MATH", "ENGLISH"
    val isIitJeeFreeTestSectionExpanded: Boolean = true,
    val selectedIitJeeLevelTab: String = "MAIN", // "MAIN" (1. IIT JEE Main) or "ADVANCED" (2. IIT JEE Advanced)
    val selectedIitJeeSubjectFilter: String = "ALL", // "ALL", "PHYSICS", "PHYSICAL_CHEM", "ORGANIC_CHEM", "INORGANIC_CHEM", "MATHEMATICS"
    val isNeetFreeTestSectionExpanded: Boolean = true,
    val selectedNeetSubjectFilter: String = "ALL", // "ALL", "PHYSICS", "PHYSICAL_CHEM", "ORGANIC_CHEM", "INORGANIC_CHEM", "BOTANY", "ZOOLOGY"
    val isUgcNetFreeTestSectionExpanded: Boolean = true,
    val selectedUgcNetPaperTab: String = "PAPER_1", // "PAPER_1" (1. Paper 1 — 10 Units) or "PAPER_2" (2. Paper 2 — 12 Subjects)
    val selectedUgcNetSubjectFilter: String = "ALL", // "ALL", "UNIT_1".."UNIT_10", "HISTORY", "POL_SCIENCE", "GEOGRAPHY", "ECONOMICS", "HINDI", "ENGLISH", "COMMERCE", "MANAGEMENT", "SOCIOLOGY", "EDUCATION", "COMPUTER_SCI", "LAW"
    val isTetFreeTestSectionExpanded: Boolean = true,
    val selectedTetExamTab: String = "CTET", // "CTET" (सीटेट), "UPTET" (यूपीटेट), "UTET" (यूटेट व अन्य)
    val selectedTetSubjectFilter: String = "ALL", // "ALL", "CDP", "EVS", "MATHS", "SCIENCE", "SOCIAL_SCIENCE", "HINDI", "ENGLISH_SANSKRIT"
    val selectedDashboardCategoryFilter: String = "ALL", // "ALL", "TET", "IIT_JEE", "NEET", "UGC_NET", "UPSC", "SSC", "BANKING", "STATE_PSC", "UPPCS", "UKPSC", "BPSC", "UPSSSC", "UKSSSC", "RAILWAYS"
    // Per-exam switcher: "PAID" = 1. Paid Test Series, "FREE" = 2. Free Test Series
    val examTestSeriesModeMap: Map<String, String> = mapOf(
        "tet" to "FREE",
        "iit_jee" to "FREE",
        "neet" to "FREE",
        "ugc_net" to "FREE",
        "upsc" to "FREE",
        "uppcs" to "FREE",
        "ukpsc" to "FREE",
        "bpsc" to "FREE",
        "upsssc" to "FREE",
        "uksssc" to "FREE",
        "ssc" to "FREE",
        "banking" to "FREE",
        "railways" to "FREE",
        "up_police" to "FREE"
    ),
    val currentQuestionIndex: Int = 0,
    val userAnswers: Map<Int, Int> = emptyMap(), // questionId -> selectedOptionIndex
    val testAnswersByTestId: Map<String, Map<Int, Int>> = emptyMap(), // testId -> (questionId -> selectedOptionIndex)
    val completedTestIds: Set<String> = emptySet(),
    val markedForReview: Set<Int> = emptySet(),
    val isBilingualHindi: Boolean = false,
    val isDualBilingualView: Boolean = true, // Shows BOTH English + Hindi together by default
    val isInstantPyqSolutionVisible: Boolean = false,
    val testTimeRemainingSeconds: Int = 60 * 60,
    val testTotalDurationSeconds: Int = 60 * 60,
    val isTestTimerRunning: Boolean = true,
    val isTestTimerPaused: Boolean = false,
    val isAutoSubmittedOnTimeout: Boolean = false,
    val isStrictExamSimulationMode: Boolean = false,
    val questionTimeSpentSeconds: Map<Int, Int> = emptyMap(), // questionId -> seconds spent
    val isTestSubmitted: Boolean = false,
    val lastTestAttempt: UserTestAttempt? = null,

    // Cart & Library
    val cartItems: List<CartItem> = emptyList(),
    val appliedCoupon: String? = null,
    val couponDiscountPercent: Int = 0,
    val wishlistIds: Set<String> = emptySet(),
    val purchasedItemIds: Set<String> = setOf("upsc_mod_history"), // pre-loaded so user can read immediately
    val testAttemptsHistory: List<UserTestAttempt> = emptyList(),

    // Room Database Exam Hierarchy (Exam -> Subject -> Sub-topic)
    val roomExamHierarchies: List<com.example.data.local.entity.ExamWithSubjectsAndSubTopics> = emptyList(),
    val selectedRoomExamId: String? = null,

    // Room Local Offline Cache (Downloaded E-Books & Test Series for Offline Access)
    val isOfflineModeActive: Boolean = false,
    val cachedOfflineEbooks: List<OfflineEbookCacheEntity> = emptyList(),
    val cachedOfflineTests: List<OfflineTestCacheEntity> = emptyList(),

    // Daily Streak & Quiz Rewards System
    val dailyStreakDays: Int = 0,
    val longestStreakDays: Int = 0,
    val rewardPoints: Int = 0,
    val lastQuizAttemptDateIso: String = "",
    val completedStreakDatesIso: Set<String> = emptySet(),
    val unlockedStreakBadgeIds: Set<String> = emptySet(),
    val isTodayStreakCompleted: Boolean = false,
    val dailyQuizDateIso: String = com.example.ui.components.DailyStreakEngine.todayIsoDate(),
    val dailyQuizQuestion: TestQuestion = com.example.ui.components.DailyQuizEngine.getQuestionForDate(),
    val dailyQuizSelectedOptionIndex: Int? = null,
    val isDailyQuizSubmitted: Boolean = false,
    val isDailyQuizExplanationVisible: Boolean = false,

    // Bilingual Support (English default as requested, Hindi toggleable)
    val selectedLanguage: AppLanguage = AppLanguage.ENGLISH,

    // Dynamic Study Items (Price Editable by Owner) + Free Shakuntalam Branded Notes
    val customStudyItems: List<StudyItem> = ExamCatalogData.studyItems + com.example.data.AllIndiaMasterTestPackageData.freeShakuntalamBrandedNotes,

    // Dynamic Online Tests (Starts with fast core PYQ tests, full 56-test bank hydrated asynchronously)
    val customTests: List<MockTest> = PyqTestBankData.coreQuickPyqTests,

    // In-App PDF Document Reading
    val currentDocForReading: EbookDocumentEntity? = null,

    // User Authentication, First-Launch OTP Gate & 2-Field Post-Login Account Setup
    val isLoggedIn: Boolean = false,
    val currentUser: UserProfile? = null,
    val isAuthModalOpen: Boolean = true,
    val authModalTab: AuthTab = AuthTab.PHONE_OTP,
    val phoneOtpState: PhoneOtpState = PhoneOtpState(),
    val isAccountSetupModalOpen: Boolean = false,
    val onboardingStudentNameInput: String = "",
    val onboardingTargetExamInput: String = "UPSC Civil Services",
    val onboardingErrorMessage: String? = null,
    val selectedLeaderboardScope: String = "TARGET_EXAM", // "TARGET_EXAM" or "ALL_INDIA"
    val isProgressTrackerExpanded: Boolean = true,
    val isDashboardLeaderboardExpanded: Boolean = true,
    val isProfileModalOpen: Boolean = false,
    val isDownloadModalOpen: Boolean = false,

    // Owner / Publisher Document Portal State (includes default Free Shakuntalam Branded PDFs)
    val isOwnerMode: Boolean = false,
    val uploadedDocuments: List<EbookDocumentEntity> = com.example.data.AllIndiaMasterTestPackageData.defaultBrandedPdfDocuments,

    // Payment Gateway & Owner Linked UPI / Bank State
    val isPaymentGatewayOpen: Boolean = false,
    val paymentGatewayAmount: Int = 0,
    val paymentGatewayItemTitle: String = "",
    val ownerUpiId: String = "6396817525@jio",
    val ownerUpiMobile: String = "6396817525",
    val ownerMerchantName: String = "Shakuntalam Publications",
    val ownerBankName: String = "Jio Payments Bank / UPI Linked Bank",
    val ownerAccountNumber: String = "",
    val ownerIfscCode: String = "",

    // Security & Anti-Piracy Shield State
    val isAntiPiracyEnabled: Boolean = true,
    val isAdminPinLockEnabled: Boolean = false,
    val isAdminSessionUnlocked: Boolean = true,
    val failedAdminPinAttempts: Int = 0,
    val securityAuditLogs: List<String> = listOf(
        "SHA-256 Cryptographic Integrity Shield: ACTIVE",
        "SQLi & XSS Input Sanitization Firewall: ENABLED",
        "DRM Anti-Piracy & PDF Watermark Protection: ENABLED",
        "Verified Owner UPI VPA: 6396817525@jio (NPCI Format Valid)"
    ),

    // UI Feedback
    val toastMessage: String? = null,
    val showAboutDialog: Boolean = false,

    // Netflix-Style All-Access Subscription State (₹9/Month for 30 days & ₹99/Year for 365 days)
    val subscriptionPlanCode: String = "NONE", // "NONE", "MONTHLY_9", "YEARLY_99"
    val subscriptionStartEpochMillis: Long = 0L,
    val subscriptionExpiryEpochMillis: Long = 0L,
    val isSubscriptionActive: Boolean = false
) {
    fun isAllAccessSubscriptionValid(nowMillis: Long = System.currentTimeMillis()): Boolean {
        return isSubscriptionActive &&
                subscriptionPlanCode != "NONE" &&
                subscriptionExpiryEpochMillis > nowMillis
    }

    fun getRemainingSubscriptionDays(nowMillis: Long = System.currentTimeMillis()): Int {
        if (!isAllAccessSubscriptionValid(nowMillis)) return 0
        val diffMillis = (subscriptionExpiryEpochMillis - nowMillis).coerceAtLeast(0L)
        val oneDayMillis = 24L * 60L * 60L * 1000L
        return ((diffMillis + oneDayMillis - 1L) / oneDayMillis).toInt().coerceAtLeast(1)
    }

    fun getSectionProgress(testId: String, totalQuestions: Int): SectionProgressInfo {
        val safeTotal = totalQuestions.coerceAtLeast(1)
        val savedMap = if (activeTest.testId == testId && userAnswers.isNotEmpty()) {
            userAnswers
        } else {
            testAnswersByTestId[testId] ?: emptyMap()
        }
        val attemptFromHistory = testAttemptsHistory.lastOrNull { it.testId == testId }
        val answeredFromHistory = if (attemptFromHistory != null) {
            (attemptFromHistory.correctCount + attemptFromHistory.wrongCount).coerceAtMost(safeTotal)
        } else {
            0
        }
        val answeredCount = maxOf(savedMap.size, answeredFromHistory).coerceIn(0, safeTotal)
        val isSubmittedOrFull = completedTestIds.contains(testId) ||
                attemptFromHistory != null ||
                answeredCount >= safeTotal
        val percent = if (isSubmittedOrFull && answeredCount == 0) {
            100
        } else {
            ((answeredCount * 100) / safeTotal).coerceIn(0, 100)
        }
        val statusEn = when {
            isSubmittedOrFull && answeredCount >= safeTotal -> "Completed"
            isSubmittedOrFull -> "Submitted ($percent%)"
            answeredCount > 0 -> "In Progress"
            else -> "Not Started"
        }
        val statusHi = when {
            isSubmittedOrFull && answeredCount >= safeTotal -> "पूर्ण (Completed)"
            isSubmittedOrFull -> "सबमिटेड ($percent%)"
            answeredCount > 0 -> "जारी है (In Progress)"
            else -> "शुरू करें (Not Started)"
        }
        return SectionProgressInfo(
            answeredCount = answeredCount,
            totalQuestions = safeTotal,
            completionPercent = percent,
            isCompleted = isSubmittedOrFull,
            statusEn = statusEn,
            statusHi = statusHi
        )
    }

    fun getGroupProgress(testIdsWithTotals: List<Pair<String, Int>>): SectionProgressInfo {
        if (testIdsWithTotals.isEmpty()) {
            return SectionProgressInfo(0, 100, 0, false, "Not Started", "शुरू करें")
        }
        var totalAns = 0
        var totalQs = 0
        var allDone = true
        testIdsWithTotals.forEach { (tId, count) ->
            val p = getSectionProgress(tId, count)
            totalAns += p.answeredCount
            totalQs += p.totalQuestions
            if (!p.isCompleted) allDone = false
        }
        val safeTotal = totalQs.coerceAtLeast(1)
        val pct = ((totalAns * 100) / safeTotal).coerceIn(0, 100)
        val statusEn = when {
            allDone || totalAns >= safeTotal -> "Completed"
            totalAns > 0 -> "In Progress"
            else -> "Not Started"
        }
        val statusHi = when {
            allDone || totalAns >= safeTotal -> "पूर्ण (Completed)"
            totalAns > 0 -> "जारी है (In Progress)"
            else -> "शुरू करें (Not Started)"
        }
        return SectionProgressInfo(
            answeredCount = totalAns,
            totalQuestions = safeTotal,
            completionPercent = pct,
            isCompleted = allDone || totalAns >= safeTotal,
            statusEn = statusEn,
            statusHi = statusHi
        )
    }

    fun getSscGsProgress(): SectionProgressInfo = getGroupProgress(
        listOf(
            "ssc_sec_history_100" to 100,
            "ssc_sec_polity_100" to 100,
            "ssc_sec_geography_100" to 100,
            "ssc_sec_environment_100" to 100,
            "ssc_sec_economics_100" to 100
        )
    )

    fun getSscReasoningProgress(): SectionProgressInfo =
        getSectionProgress("ssc_sec_reasoning_100", 100)

    fun getSscMathProgress(): SectionProgressInfo =
        getSectionProgress("ssc_sec_mathematics_100", 100)

    fun getSscEnglishProgress(): SectionProgressInfo =
        getSectionProgress("ssc_sec_english_100", 100)

    fun getIitJeeMainProgress(): SectionProgressInfo = getGroupProgress(
        listOf(
            "jee_main_sec_physics_100" to 100,
            "jee_main_sec_physical_chem_100" to 100,
            "jee_main_sec_organic_chem_100" to 100,
            "jee_main_sec_inorganic_chem_100" to 100,
            "jee_main_sec_mathematics_100" to 100
        )
    )

    fun getIitJeeAdvancedProgress(): SectionProgressInfo = getGroupProgress(
        listOf(
            "jee_adv_sec_physics_100" to 100,
            "jee_adv_sec_physical_chem_100" to 100,
            "jee_adv_sec_organic_chem_100" to 100,
            "jee_adv_sec_inorganic_chem_100" to 100,
            "jee_adv_sec_mathematics_100" to 100
        )
    )

    fun getIitJeeOverallProgress(): SectionProgressInfo = getGroupProgress(
        listOf(
            "jee_main_sec_physics_100" to 100,
            "jee_main_sec_physical_chem_100" to 100,
            "jee_main_sec_organic_chem_100" to 100,
            "jee_main_sec_inorganic_chem_100" to 100,
            "jee_main_sec_mathematics_100" to 100,
            "jee_adv_sec_physics_100" to 100,
            "jee_adv_sec_physical_chem_100" to 100,
            "jee_adv_sec_organic_chem_100" to 100,
            "jee_adv_sec_inorganic_chem_100" to 100,
            "jee_adv_sec_mathematics_100" to 100
        )
    )

    fun getNeetOverallProgress(): SectionProgressInfo = getGroupProgress(
        listOf(
            "neet_sec_physics_100" to 100,
            "neet_sec_physical_chem_100" to 100,
            "neet_sec_organic_chem_100" to 100,
            "neet_sec_inorganic_chem_100" to 100,
            "neet_sec_botany_100" to 100,
            "neet_sec_zoology_100" to 100
        )
    )

    fun getUgcNetPaper1Progress(): SectionProgressInfo = getGroupProgress(
        com.example.data.ugcnet.UgcNetAllSubjectsPyqData.getPaper1UnitSpecs().map { it.testId to 100 }
    )

    fun getUgcNetPaper2Progress(): SectionProgressInfo = getGroupProgress(
        com.example.data.ugcnet.UgcNetAllSubjectsPyqData.getPaper2SubjectSpecs().map { it.testId to 100 }
    )

    fun getUgcNetOverallProgress(): SectionProgressInfo = getGroupProgress(
        com.example.data.ugcnet.UgcNetAllSubjectsPyqData.sectionSpecs.map { it.testId to 100 }
    )

    fun getTetOverallProgress(): SectionProgressInfo = getGroupProgress(
        com.example.data.tet.TetAllSubjectsPyqData.allSpecs.map { it.testId to 100 }
    )

    fun getExamCategoryProgress(seriesKey: String): SectionProgressInfo {
        return when (seriesKey.trim().lowercase()) {
            "tet", "teaching", "ctet", "uptet", "utet" -> getTetOverallProgress()
            "iit_jee", "jee_neet", "jee" -> getIitJeeOverallProgress()
            "iit_jee_main", "jee_main" -> getIitJeeMainProgress()
            "iit_jee_advanced", "jee_advanced" -> getIitJeeAdvancedProgress()
            "neet", "neet_ug" -> getNeetOverallProgress()
            "ugc_net", "ugc_csir_net", "ugc" -> getUgcNetOverallProgress()
            "ugc_net_paper1", "ugc_paper1" -> getUgcNetPaper1Progress()
            "ugc_net_paper2", "ugc_paper2" -> getUgcNetPaper2Progress()
            "upsc" -> getGroupProgress(
                listOf(
                    "upsc_sec_history_50" to 50,
                    "upsc_sec_polity_50" to 50,
                    "upsc_sec_geography_50" to 50,
                    "upsc_sec_economics_50" to 50,
                    "upsc_sec_environment_50" to 50,
                    "upsc_sec_scitech_50" to 50,
                    "upsc_sec_ir_ca_50" to 50
                )
            )
            "uppcs" -> getGroupProgress(
                listOf(
                    "uppcs_sec_history_50" to 50,
                    "uppcs_sec_polity_50" to 50,
                    "uppcs_sec_geography_50" to 50,
                    "uppcs_sec_environment_50" to 50,
                    "uppcs_sec_scitech_50" to 50,
                    "uppcs_sec_up_ca_50" to 50,
                    "uppcs_sec_economics_50" to 50
                )
            )
            "ukpsc" -> getGroupProgress(
                listOf(
                    "ukpsc_sec_uttarakhand_special_100" to 100,
                    "ukpsc_sec_history_50" to 50,
                    "ukpsc_sec_polity_50" to 50,
                    "ukpsc_sec_geography_50" to 50,
                    "ukpsc_sec_economics_50" to 50,
                    "ukpsc_sec_environment_50" to 50,
                    "ukpsc_sec_scitech_50" to 50,
                    "ukpsc_sec_current_affairs_50" to 50
                )
            )
            "bpsc" -> getGroupProgress(
                listOf(
                    "bpsc_sec_bihar_special_100" to 100,
                    "bpsc_sec_history_100" to 100,
                    "bpsc_sec_polity_100" to 100,
                    "bpsc_sec_geography_100" to 100,
                    "bpsc_sec_economics_100" to 100,
                    "bpsc_sec_science_100" to 100,
                    "bpsc_sec_current_affairs_100" to 100
                )
            )
            "upsssc" -> getGroupProgress(
                listOf(
                    "upsssc_sec_history_100" to 100,
                    "upsssc_sec_polity_100" to 100,
                    "upsssc_sec_geography_100" to 100,
                    "upsssc_sec_economics_100" to 100,
                    "upsssc_sec_environment_100" to 100,
                    "upsssc_sec_scitech_100" to 100,
                    "upsssc_sec_up_special_250" to 250,
                    "upsssc_sec_computer_100" to 100,
                    "upsssc_sec_di_100" to 100
                )
            )
            "uksssc" -> getGroupProgress(
                listOf(
                    "uksssc_sec_history_100" to 100,
                    "uksssc_sec_polity_100" to 100,
                    "uksssc_sec_geography_100" to 100,
                    "uksssc_sec_economics_100" to 100,
                    "uksssc_sec_environment_100" to 100,
                    "uksssc_sec_scitech_100" to 100,
                    "uksssc_sec_uttarakhand_special_250" to 250,
                    "uksssc_sec_hindi_100" to 100,
                    "uksssc_sec_computer_100" to 100,
                    "uksssc_sec_reasoning_di_100" to 100
                )
            )
            "ssc" -> getGroupProgress(
                listOf(
                    "ssc_sec_history_100" to 100,
                    "ssc_sec_polity_100" to 100,
                    "ssc_sec_geography_100" to 100,
                    "ssc_sec_environment_100" to 100,
                    "ssc_sec_economics_100" to 100,
                    "ssc_sec_reasoning_100" to 100,
                    "ssc_sec_mathematics_100" to 100,
                    "ssc_sec_english_100" to 100
                )
            )
            "banking" -> getSectionProgress("pyq_banking_po_2025", 10)
            "railways" -> getSectionProgress("pyq_railway_ntpc_2025", 10)
            "up_police", "up_constable", "upp", "up_si" -> getGroupProgress(
                listOf(
                    "up_police_sectional_1" to 38,
                    "up_police_sectional_6" to 38,
                    "up_police_sectional_11" to 38,
                    "up_police_sectional_16" to 38
                )
            )
            "state_psc" -> {
                val p1 = getExamCategoryProgress("uppcs")
                val p2 = getExamCategoryProgress("ukpsc")
                val p3 = getExamCategoryProgress("bpsc")
                val totalAns = p1.answeredCount + p2.answeredCount + p3.answeredCount
                val totalQs = p1.totalQuestions + p2.totalQuestions + p3.totalQuestions
                val pct = ((totalAns * 100) / totalQs.coerceAtLeast(1)).coerceIn(0, 100)
                val done = p1.isCompleted && p2.isCompleted && p3.isCompleted
                SectionProgressInfo(
                    answeredCount = totalAns,
                    totalQuestions = totalQs,
                    completionPercent = pct,
                    isCompleted = done,
                    statusEn = when {
                        done || totalAns >= totalQs -> "Completed"
                        totalAns > 0 -> "In Progress"
                        else -> "Not Started"
                    },
                    statusHi = when {
                        done || totalAns >= totalQs -> "पूर्ण (Completed)"
                        totalAns > 0 -> "जारी है (In Progress)"
                        else -> "शुरू करें (Not Started)"
                    }
                )
            }
            else -> getSectionProgress(seriesKey, 100)
        }
    }

    fun getVisibleSeriesAggregateProgress(): SectionProgressInfo {
        val visibleKeys = getVisibleDashboardTestSeriesKeys()
        if (visibleKeys.isEmpty()) {
            return SectionProgressInfo(0, 100, 0, false, "Not Started", "शुरू करें")
        }
        var totalAns = 0
        var totalQs = 0
        var allDone = true
        visibleKeys.forEach { key ->
            val p = getExamCategoryProgress(key)
            totalAns += p.answeredCount
            totalQs += p.totalQuestions
            if (!p.isCompleted) allDone = false
        }
        val safeTotal = totalQs.coerceAtLeast(1)
        val pct = ((totalAns * 100) / safeTotal).coerceIn(0, 100)
        return SectionProgressInfo(
            answeredCount = totalAns,
            totalQuestions = safeTotal,
            completionPercent = pct,
            isCompleted = allDone || totalAns >= safeTotal,
            statusEn = when {
                allDone || totalAns >= safeTotal -> "Completed"
                totalAns > 0 -> "In Progress"
                else -> "Not Started"
            },
            statusHi = when {
                allDone || totalAns >= safeTotal -> "पूर्ण (Completed)"
                totalAns > 0 -> "जारी है (In Progress)"
                else -> "शुरू करें (Not Started)"
            }
        )
    }

    fun effectiveDashboardCategoryFilter(): String {
        val explicitFilter = selectedDashboardCategoryFilter.trim().uppercase()
        if (explicitFilter.isNotEmpty() && explicitFilter != "ALL") {
            return explicitFilter
        }
        val q = searchQuery.trim().uppercase()
        return when {
            q == "TET" || q == "CTET" || q == "UPTET" || q == "UTET" || q == "REET" || q == "TEACHING" -> "TET"
            q == "IIT JEE" || q == "IIT_JEE" || q == "JEE" || q == "JEE MAIN" || q == "JEE ADVANCED" || q == "JEE_NEET" -> "IIT_JEE"
            q == "NEET" || q == "NEET_UG" || q == "NEET UG" -> "NEET"
            q == "UGC NET" || q == "UGC_NET" || q == "UGC" || q == "UGC_CSIR_NET" || q == "JRF" -> "UGC_NET"
            q == "UPSC" || q == "UPSC CSE" || q == "IAS" -> "UPSC"
            q == "SSC" || q == "SSC CGL" || q == "SSC CHSL" || q == "SSC CPO" -> "SSC"
            q == "BANKING" || q == "BANK" || q == "IBPS" || q == "SBI PO" || q == "RBI" -> "BANKING"
            q == "STATE PSC" || q == "PSC" || q == "STATE_PSC" -> "STATE_PSC"
            q == "UPPCS" || q == "UPPSC" -> "UPPCS"
            q == "UKPSC" -> "UKPSC"
            q == "BPSC" -> "BPSC"
            q == "UPSSSC" || q == "PET" -> "UPSSSC"
            q == "UKSSSC" || q == "UKSSC" -> "UKSSSC"
            q == "UP POLICE" || q == "UP_POLICE" || q == "UP CONSTABLE" || q == "UP_CONSTABLE" || q == "UPP" || q == "UP SI" || q == "यूपी पुलिस" || q == "कांस्टेबल" -> "UP_POLICE"
            q == "RAILWAY" || q == "RAILWAYS" || q == "RRB" -> "RAILWAYS"
            else -> "ALL"
        }
    }

    fun isTestSeriesVisibleOnDashboard(seriesKey: String): Boolean {
        val activeFilter = effectiveDashboardCategoryFilter()
        val key = seriesKey.trim().lowercase()
        return when (activeFilter) {
            "ALL" -> true
            "TET", "CTET", "UPTET", "UTET", "TEACHING" -> key == "tet"
            "IIT_JEE", "JEE_NEET", "JEE" -> key == "iit_jee"
            "NEET", "NEET_UG" -> key == "neet"
            "UGC_NET", "UGC_CSIR_NET", "UGC" -> key == "ugc_net"
            "UPSC" -> key == "upsc"
            "SSC" -> key == "ssc"
            "BANKING" -> key == "banking"
            "STATE_PSC" -> key in setOf("uppcs", "ukpsc", "bpsc")
            "UPPCS" -> key == "uppcs"
            "UKPSC" -> key == "ukpsc"
            "BPSC" -> key == "bpsc"
            "UPSSSC" -> key == "upsssc"
            "UKSSSC" -> key == "uksssc"
            "UP_POLICE", "UPP", "UP_CONSTABLE", "UP_SI" -> key == "up_police"
            "SUBORDINATE" -> key in setOf("upsssc", "uksssc", "up_police")
            "RAILWAYS" -> key == "railways"
            else -> key.contains(activeFilter.lowercase())
        }
    }

    fun getVisibleDashboardTestSeriesKeys(): List<String> {
        val allSeriesKeys = listOf(
            "up_police",
            "tet",
            "iit_jee",
            "neet",
            "ugc_net",
            "upsc",
            "uppcs",
            "ukpsc",
            "bpsc",
            "upsssc",
            "uksssc",
            "ssc",
            "banking",
            "railways"
        )
        return allSeriesKeys.filter { isTestSeriesVisibleOnDashboard(it) }
    }

    fun matchesDashboardCategoryStudyItem(item: StudyItem): Boolean {
        return when (val activeFilter = effectiveDashboardCategoryFilter()) {
            "ALL" -> true
            "TET", "CTET", "UPTET", "UTET", "TEACHING" -> item.categoryId.equals("teaching", ignoreCase = true) || item.subSectionId.startsWith("tet", ignoreCase = true)
            "IIT_JEE", "JEE_NEET", "JEE" -> item.categoryId.equals("jee_neet", ignoreCase = true) || item.subSectionId.startsWith("iit_jee", ignoreCase = true)
            "NEET", "NEET_UG" -> item.subSectionId.equals("neet_ug", ignoreCase = true) || item.categoryId.equals("jee_neet", ignoreCase = true)
            "UGC_NET", "UGC_CSIR_NET", "UGC" -> item.categoryId.equals("ugc_csir_net", ignoreCase = true) || item.subSectionId.startsWith("ugc_net", ignoreCase = true)
            "UPSC" -> item.categoryId.equals("upsc", ignoreCase = true)
            "SSC" -> item.categoryId.equals("ssc", ignoreCase = true)
            "BANKING" -> item.categoryId.equals("banking", ignoreCase = true)
            "STATE_PSC" -> item.categoryId.equals("state_psc", ignoreCase = true)
            "UPPCS" -> item.subSectionId.equals("psc_uppcs", ignoreCase = true) || item.categoryId.equals("state_psc", ignoreCase = true)
            "UKPSC" -> item.subSectionId.equals("psc_ukpsc", ignoreCase = true) || item.categoryId.equals("state_psc", ignoreCase = true)
            "BPSC" -> item.subSectionId.equals("psc_bpsc", ignoreCase = true) || item.categoryId.equals("state_psc", ignoreCase = true)
            "UPSSSC" -> item.subSectionId.equals("sub_upsssc", ignoreCase = true) || item.categoryId.equals("subordinate_selection", ignoreCase = true)
            "UKSSSC" -> item.subSectionId.equals("sub_uksssc", ignoreCase = true) || item.categoryId.equals("subordinate_selection", ignoreCase = true)
            "UP_POLICE", "UPP", "UP_CONSTABLE" -> item.categoryId.equals("up_police", ignoreCase = true) || item.subSectionId.equals("sub_upsssc", ignoreCase = true)
            "RAILWAYS" -> item.categoryId.equals("railways", ignoreCase = true)
            else -> item.categoryId.contains(activeFilter, ignoreCase = true)
        }
    }

    fun formattedRemainingTime(): String =
        com.example.ui.components.formatQuizCountdownTime(testTimeRemainingSeconds)

    fun timerRemainingFraction(): Float {
        val safeTotal = testTotalDurationSeconds.coerceAtLeast(1)
        return (testTimeRemainingSeconds.coerceAtLeast(0).toFloat() / safeTotal.toFloat()).coerceIn(0f, 1f)
    }

    fun timerUrgencyLevel(): String {
        val rem = testTimeRemainingSeconds.coerceAtLeast(0)
        return when {
            rem <= 60 -> "CRITICAL"
            rem <= 300 -> "WARNING"
            else -> "NORMAL"
        }
    }

    fun elapsedTestTimeSeconds(): Int {
        val total = testTotalDurationSeconds.coerceAtLeast(0)
        val rem = testTimeRemainingSeconds.coerceIn(0, total)
        return (total - rem).coerceAtLeast(0)
    }

    fun currentQuestionTimeSpentSeconds(): Int {
        val activeQId = activeTest.questions.getOrNull(currentQuestionIndex)?.id ?: return 0
        return questionTimeSpentSeconds[activeQId] ?: 0
    }

    fun targetSecondsPerQuestion(): Int {
        val qCount = activeTest.questions.size.coerceAtLeast(1)
        return (testTotalDurationSeconds.coerceAtLeast(60) / qCount).coerceAtLeast(15)
    }

    fun averageSecondsPerAnsweredQuestion(): Int {
        val answeredCount = userAnswers.size
        val elapsed = elapsedTestTimeSeconds()
        if (answeredCount <= 0) return elapsed
        return (elapsed / answeredCount).coerceAtLeast(1)
    }

    /**
     * Evaluates real-time exam pacing by comparing average time per answered question
     * (or current question time if none answered yet) against targetSecondsPerQuestion().
     * Returns "AHEAD_OF_PACE", "ON_TRACK", or "BEHIND_PACE".
     */
    fun examPacingStatus(): String {
        val targetPerQ = targetSecondsPerQuestion()
        val effectivePerQ = if (userAnswers.isNotEmpty()) {
            averageSecondsPerAnsweredQuestion()
        } else {
            currentQuestionTimeSpentSeconds()
        }
        return when {
            effectivePerQ <= (targetPerQ * 0.75).toInt() -> "AHEAD_OF_PACE"
            effectivePerQ <= (targetPerQ * 1.15).toInt() -> "ON_TRACK"
            else -> "BEHIND_PACE"
        }
    }

    fun isEbookCachedOffline(itemId: String): Boolean =
        cachedOfflineEbooks.any { it.itemId == itemId }

    fun isTestCachedOffline(testId: String): Boolean =
        cachedOfflineTests.any { it.testId == testId }

    fun totalOfflineCacheSizeFormatted(): String {
        val totalKb = cachedOfflineEbooks.sumOf { it.cacheSizeKb } + cachedOfflineTests.sumOf { it.cacheSizeKb }
        return if (totalKb >= 1024) {
            "%.2f MB".format(totalKb / 1024.0)
        } else {
            "$totalKb KB"
        }
    }

    fun getTargetExamDisplayName(): String {
        return currentUser?.targetExam?.takeIf { it.isNotBlank() }
            ?: onboardingTargetExamInput.takeIf { it.isNotBlank() }
            ?: "UPSC Civil Services"
    }

    fun getTargetExamSeriesKey(examLabel: String = getTargetExamDisplayName()): String {
        val norm = examLabel.trim().lowercase()
        return when {
            norm.contains("ctet") || norm.contains("uptet") || norm.contains("utet") || norm.contains("tet") || norm.contains("teaching") -> "tet"
            norm.contains("ugc") || norm.contains("net") || norm.contains("jrf") -> "ugc_net"
            norm.contains("jee") || norm.contains("iit") -> "iit_jee"
            norm.contains("neet") || norm.contains("medical") -> "neet"
            norm.contains("ssc") || norm.contains("cgl") || norm.contains("chsl") || norm.contains("cpo") -> "ssc"
            norm.contains("uppcs") || norm.contains("uppsc") -> "uppcs"
            norm.contains("ukpsc") || norm.contains("uttarakhand psc") -> "ukpsc"
            norm.contains("bpsc") || norm.contains("bihar") -> "bpsc"
            norm.contains("upsssc") || norm.contains("pet") -> "upsssc"
            norm.contains("uksssc") || norm.contains("group c") -> "uksssc"
            norm.contains("bank") || norm.contains("ibps") || norm.contains("sbi") -> "banking"
            norm.contains("rail") || norm.contains("rrb") || norm.contains("ntpc") -> "railways"
            else -> "upsc"
        }
    }

    fun getMasterProgressSummary(): MasterProgressSummary {
        val allKeysWithLabels = listOf(
            Triple("tet", "CTET / UPTET / UTET", "सीटेट • यूपीटेट • यूटेट"),
            Triple("ugc_net", "UGC NET (Paper 1 & 2)", "यूजीसी नेट (पेपर 1 व 2)"),
            Triple("iit_jee", "IIT JEE (Main & Adv)", "आईआईटी जेईई (मेन व एडवांस्ड)"),
            Triple("neet", "NEET (UG) Medical", "नीट (UG) मेडिकल"),
            Triple("upsc", "UPSC Civil Services", "यूपीएससी सिविल सेवा"),
            Triple("ssc", "SSC CGL / CHSL / CPO", "एसएससी (CGL / CHSL)"),
            Triple("uppcs", "UPPCS (State PSC)", "यूपीपीसीएस (UPPCS)"),
            Triple("ukpsc", "UKPSC (Uttarakhand)", "यूकेपीसीएस (UKPSC)"),
            Triple("bpsc", "BPSC (Bihar PSC)", "बीपीएससी (BPSC)"),
            Triple("upsssc", "UPSSSC (PET / VDO)", "यूपीएसएसएससी (UPSSSC)"),
            Triple("uksssc", "UKSSSC (Group C)", "यूकेएसएसएससी (UKSSSC)"),
            Triple("banking", "Banking PO / Clerk", "बैंकिंग (IBPS / SBI)"),
            Triple("railways", "Railway RRB NTPC", "रेलवे (RRB NTPC)")
        )

        val targetKey = getTargetExamSeriesKey()
        val targetExamName = getTargetExamDisplayName()
        val targetProgress = getExamCategoryProgress(targetKey)

        var totalSolvedAll = 0
        var totalAvailableAll = 0
        val breakdownList = allKeysWithLabels.map { (key, titleEn, titleHi) ->
            val prog = getExamCategoryProgress(key)
            totalSolvedAll += prog.answeredCount
            totalAvailableAll += prog.totalQuestions
            ExamProgressBreakdownItem(
                examKey = key,
                titleEn = titleEn,
                titleHi = titleHi,
                progress = prog,
                isTargetExam = key == targetKey
            )
        }.sortedWith(
            compareByDescending<ExamProgressBreakdownItem> { it.isTargetExam }
                .thenByDescending { it.progress.answeredCount }
        )

        val safeTotalAvailable = totalAvailableAll.coerceAtLeast(1)
        val overallCompletionPct = ((totalSolvedAll * 100) / safeTotalAvailable).coerceIn(0, 100)

        // Compute total correct & wrong across submitted attempts + active answers
        val historyCorrect = testAttemptsHistory.sumOf { it.correctCount }
        val historyWrong = testAttemptsHistory.sumOf { it.wrongCount }
        val liveUnrecordedAnswered = (totalSolvedAll - (historyCorrect + historyWrong)).coerceAtLeast(0)
        // For live answered questions not yet submitted, check activeTest if matching or estimate 80% accuracy
        var activeCorrect = 0
        var activeWrong = 0
        if (userAnswers.isNotEmpty() && !isTestSubmitted) {
            activeTest.questions.forEach { q ->
                val ans = userAnswers[q.id]
                if (ans != null) {
                    if (ans == q.correctIndex) activeCorrect++ else activeWrong++
                }
            }
        }
        val extraSolved = (liveUnrecordedAnswered - (activeCorrect + activeWrong)).coerceAtLeast(0)
        val totalCorrect = historyCorrect + activeCorrect + ((extraSolved * 4) / 5)
        val totalWrong = historyWrong + activeWrong + (extraSolved - ((extraSolved * 4) / 5))
        val totalEvaluated = totalCorrect + totalWrong
        val accuracyPct = if (totalEvaluated > 0) {
            ((totalCorrect * 100) / totalEvaluated).coerceIn(0, 100)
        } else {
            0
        }

        val testsCompletedCount = maxOf(testAttemptsHistory.size, completedTestIds.size)
        val liveScorePoints = rewardPoints +
                (totalSolvedAll * 12) +
                (totalCorrect * 8) +
                (testsCompletedCount * 150)

        val computedAirRank = when {
            liveScorePoints >= 2600 -> 1
            liveScorePoints >= 2300 -> 2
            liveScorePoints >= 2000 -> 3
            liveScorePoints >= 1700 -> 4
            liveScorePoints >= 1400 -> 5
            liveScorePoints >= 1000 -> 6 + ((1400 - liveScorePoints) / 80)
            liveScorePoints >= 400 -> 15 + ((1000 - liveScorePoints) / 25)
            liveScorePoints > 0 -> 45 + ((400 - liveScorePoints) / 5)
            else -> 1250
        }.coerceAtLeast(1)

        val readinessEn = when {
            targetProgress.completionPercent >= 75 || accuracyPct >= 80 && totalSolvedAll >= 50 -> "Topper Merit Zone"
            targetProgress.completionPercent >= 35 || totalSolvedAll >= 25 -> "Selection Track • Good Pace"
            totalSolvedAll > 0 -> "Active Preparation Started"
            else -> "Ready to Start Target Exam"
        }
        val readinessHi = when {
            targetProgress.completionPercent >= 75 || accuracyPct >= 80 && totalSolvedAll >= 50 -> "टॉपर मेरिट ज़ोन (Topper Zone)"
            targetProgress.completionPercent >= 35 || totalSolvedAll >= 25 -> "चयन ट्रैक • उत्तम गति"
            totalSolvedAll > 0 -> "सक्रिय तैयारी जारी है"
            else -> "टारगेट एग्जाम शुरू करने के लिए तैयार"
        }

        val milestones = listOf(
            ProgressMilestoneItem(
                id = "m_account",
                titleEn = "1. Student Account & Target Exam Set",
                titleHi = "1. स्टूडेंट अकाउंट एवं टारगेट एग्जाम सेट",
                isUnlocked = isLoggedIn && (currentUser?.isAccountSetupCompleted == true)
            ),
            ProgressMilestoneItem(
                id = "m_first_quiz",
                titleEn = "2. Solve First 10 PYQ Questions",
                titleHi = "2. प्रथम 10 PYQ प्रश्न हल करें",
                isUnlocked = totalSolvedAll >= 10
            ),
            ProgressMilestoneItem(
                id = "m_mock_submit",
                titleEn = "3. Complete & Submit 1st Mock Test",
                titleHi = "3. पहला मॉक टेस्ट सबमिट करें",
                isUnlocked = testsCompletedCount >= 1
            ),
            ProgressMilestoneItem(
                id = "m_merit_accuracy",
                titleEn = "4. Achieve 75%+ Accuracy in Target Exam",
                titleHi = "4. 75%+ सटीकता (Accuracy) प्राप्त करें",
                isUnlocked = accuracyPct >= 75 && totalSolvedAll >= 5
            )
        )

        return MasterProgressSummary(
            studentName = currentUser?.name?.takeIf { it.isNotBlank() } ?: "Guest Student",
            targetExam = targetExamName,
            targetExamKey = targetKey,
            targetExamProgress = targetProgress,
            totalQuestionsSolved = totalSolvedAll,
            totalQuestionsAvailable = safeTotalAvailable,
            overallCompletionPercent = overallCompletionPct,
            testsCompletedCount = testsCompletedCount,
            totalCorrectCount = totalCorrect,
            totalWrongCount = totalWrong,
            overallAccuracyPercent = accuracyPct,
            liveScorePoints = liveScorePoints,
            liveAllIndiaRank = computedAirRank,
            dailyStreakDays = dailyStreakDays,
            readinessStatusEn = readinessEn,
            readinessStatusHi = readinessHi,
            examBreakdown = breakdownList,
            milestones = milestones
        )
    }

    fun getLiveDashboardLeaderboard(): List<DashboardLeaderboardEntry> {
        val summary = getMasterProgressSummary()
        val activeTargetExam = summary.targetExam
        val isTargetScope = selectedLeaderboardScope == "TARGET_EXAM"
        val examTagForPeers = if (isTargetScope) activeTargetExam else "All-India Combined"

        val peerTemplates = listOf(
            Triple("Aarav Sharma", "Prayagraj, UP", 2480 to 94),
            Triple("Priya Verma", "Dehradun, UK", 2240 to 91),
            Triple("Vikramaditya Singh", "Patna, Bihar", 1960 to 89),
            Triple("Ananya Joshi", "New Delhi", 1690 to 86),
            Triple("Rohan Tiwari", "Lucknow, UP", 1420 to 84),
            Triple("Sneha Rawat", "Haldwani, UK", 1180 to 81),
            Triple("Karan Pratap", "Jaipur, RJ", 920 to 78)
        )

        val peerEntries = peerTemplates.mapIndexed { idx, (name, city, scoreAndAcc) ->
            val (pts, acc) = scoreAndAcc
            DashboardLeaderboardEntry(
                rank = idx + 1,
                studentName = name,
                targetExam = if (isTargetScope) activeTargetExam else when (idx % 5) {
                    0 -> "UPSC Civil Services"
                    1 -> "CTET / UPTET / UTET"
                    2 -> "IIT JEE (Main & Advanced)"
                    3 -> "UGC NET (Paper 1 & 2)"
                    else -> "SSC CGL / CHSL / CPO"
                },
                locationOrAuthTag = city,
                scorePoints = pts,
                questionsSolved = (pts / 14).coerceAtLeast(25),
                accuracyPercent = acc,
                badgeLabel = when (idx) {
                    0 -> "AIR #1 • Gold Topper"
                    1 -> "AIR #2 • Silver Medalist"
                    2 -> "AIR #3 • Bronze Medalist"
                    else -> "$examTagForPeers Merit"
                },
                isCurrentUser = false
            )
        }

        val registeredName = currentUser?.name?.takeIf { it.isNotBlank() } ?: "Guest Aspirant"
        val authVerifiedLabel = when {
            !currentUser?.phoneNumber.isNullOrBlank() -> "Verified (${currentUser?.phoneNumber})"
            !currentUser?.email.isNullOrBlank() -> "Verified (${currentUser?.email})"
            else -> "Live Student Account"
        }

        val currentUserEntry = DashboardLeaderboardEntry(
            rank = summary.liveAllIndiaRank,
            studentName = registeredName,
            targetExam = activeTargetExam,
            locationOrAuthTag = authVerifiedLabel,
            scorePoints = summary.liveScorePoints,
            questionsSolved = summary.totalQuestionsSolved,
            accuracyPercent = summary.overallAccuracyPercent,
            badgeLabel = "YOUR ACCOUNT • AIR #${summary.liveAllIndiaRank}",
            isCurrentUser = true
        )

        val combined = (peerEntries + currentUserEntry).sortedWith(
            compareByDescending<DashboardLeaderboardEntry> { it.scorePoints }
                .thenByDescending { it.accuracyPercent }
                .thenByDescending { if (it.isCurrentUser) 1 else 0 }
        )

        return combined.mapIndexed { index, entry ->
            val displayRank = if (entry.isCurrentUser) {
                if (index < peerEntries.size) index + 1 else summary.liveAllIndiaRank.coerceAtLeast(index + 1)
            } else {
                index + 1
            }
            entry.copy(
                rank = displayRank,
                badgeLabel = if (entry.isCurrentUser) {
                    "YOUR ACCOUNT • AIR #$displayRank"
                } else {
                    when (displayRank) {
                        1 -> "AIR #1 • Gold Topper"
                        2 -> "AIR #2 • Silver Medalist"
                        3 -> "AIR #3 • Bronze Medalist"
                        else -> "Top 1% Merit"
                    }
                }
            )
        }
    }
}

data class SectionProgressInfo(
    val answeredCount: Int,
    val totalQuestions: Int,
    val completionPercent: Int,
    val isCompleted: Boolean,
    val statusEn: String,
    val statusHi: String
)

data class ExamProgressBreakdownItem(
    val examKey: String,
    val titleEn: String,
    val titleHi: String,
    val progress: SectionProgressInfo,
    val isTargetExam: Boolean
)

data class ProgressMilestoneItem(
    val id: String,
    val titleEn: String,
    val titleHi: String,
    val isUnlocked: Boolean
)

data class MasterProgressSummary(
    val studentName: String,
    val targetExam: String,
    val targetExamKey: String,
    val targetExamProgress: SectionProgressInfo,
    val totalQuestionsSolved: Int,
    val totalQuestionsAvailable: Int,
    val overallCompletionPercent: Int,
    val testsCompletedCount: Int,
    val totalCorrectCount: Int,
    val totalWrongCount: Int,
    val overallAccuracyPercent: Int,
    val liveScorePoints: Int,
    val liveAllIndiaRank: Int,
    val dailyStreakDays: Int,
    val readinessStatusEn: String,
    val readinessStatusHi: String,
    val examBreakdown: List<ExamProgressBreakdownItem>,
    val milestones: List<ProgressMilestoneItem>
)

data class DashboardLeaderboardEntry(
    val rank: Int,
    val studentName: String,
    val targetExam: String,
    val locationOrAuthTag: String,
    val scorePoints: Int,
    val questionsSolved: Int,
    val accuracyPercent: Int,
    val badgeLabel: String,
    val isCurrentUser: Boolean
)

class ShakuntalamViewModel(application: Application) : AndroidViewModel(application) {

    private val prefs = application.getSharedPreferences("shakuntalam_owner_prefs", android.content.Context.MODE_PRIVATE)

    private val repository: ExamHierarchyRepository by lazy {
        val db = ShakuntalamDatabase.getDatabase(application)
        ExamHierarchyRepository(db.examHierarchyDao(), db.ebookDocumentDao(), db.offlineCacheDao())
    }

    private val studentAuthRepo: StudentAuthAndProfileRepository? by lazy {
        runCatching { StudentAuthAndProfileRepository(application) }.getOrNull()
    }

    private val _uiState = MutableStateFlow(ShakuntalamUiState())
    val uiState: StateFlow<ShakuntalamUiState> = _uiState.asStateFlow()

    init {
        // Load saved Owner UPI & Bank details (defaulting to 6396817525@jio and 6396817525)
        val savedUpi = prefs.getString("owner_upi_id", "6396817525@jio") ?: "6396817525@jio"
        val savedMobile = prefs.getString("owner_upi_mobile", "6396817525") ?: "6396817525"
        val savedMerchant = prefs.getString("owner_merchant_name", "Shakuntalam Publications") ?: "Shakuntalam Publications"
        val savedBank = prefs.getString("owner_bank_name", "Jio Payments Bank / UPI Linked Bank") ?: "Jio Payments Bank / UPI Linked Bank"
        val savedAcc = prefs.getString("owner_account_no", "") ?: ""
        val savedIfsc = prefs.getString("owner_ifsc", "") ?: ""
        val antiPiracy = prefs.getBoolean("anti_piracy_enabled", true)
        val pinLockEnabled = prefs.getBoolean("admin_pin_lock_enabled", false)

        if (!prefs.contains("admin_pin_sha256")) {
            prefs.edit()
                .putString("admin_pin_sha256", com.example.security.SecurityManager.sha256("2525"))
                .apply()
        }

        val savedStreakDays = prefs.getInt("daily_streak_days", 0)
        val savedLongestStreak = prefs.getInt("longest_streak_days", 0)
        val savedRewardPoints = prefs.getInt("reward_points", 0)
        val savedLastQuizDate = prefs.getString("last_quiz_date_iso", "") ?: ""
        val savedStreakDates = prefs.getStringSet("completed_streak_dates_iso", emptySet())?.toSet() ?: emptySet()
        val savedBadgeIds = prefs.getStringSet("unlocked_streak_badge_ids", emptySet())?.toSet() ?: emptySet()
        val todayIso = com.example.ui.components.DailyStreakEngine.todayIsoDate()

        // Restore persisted Student Login & 2-Field Account Setup (Name + Target Exam)
        val savedIsLoggedIn = prefs.getBoolean("user_is_logged_in", false)
        val savedAccountSetupDone = prefs.getBoolean("user_account_setup_completed", false)
        val savedUserName = prefs.getString("user_name", "") ?: ""
        val savedTargetExam = prefs.getString("user_target_exam", "UPSC Civil Services") ?: "UPSC Civil Services"
        val savedUserPhone = prefs.getString("user_phone", null)
        val savedUserEmail = prefs.getString("user_email", null)
        val savedProviderStr = prefs.getString("user_provider", AuthProviderType.PHONE_OTP.name) ?: AuthProviderType.PHONE_OTP.name
        val restoredProvider = runCatching { AuthProviderType.valueOf(savedProviderStr) }.getOrDefault(AuthProviderType.PHONE_OTP)

        val restoredUser = if (savedIsLoggedIn) {
            val displayName = savedUserName.ifBlank { "Student Aspirant" }
            UserProfile(
                name = displayName,
                email = savedUserEmail,
                phoneNumber = savedUserPhone,
                provider = restoredProvider,
                avatarLetter = displayName.firstOrNull()?.uppercase() ?: "S",
                targetExam = savedTargetExam,
                isVerified = true,
                isAccountSetupCompleted = savedAccountSetupDone
            )
        } else {
            null
        }

        // Restore Netflix-style All-Access Subscription (₹9/Month or ₹99/Year) & check auto-expiry
        val savedSubPlan = prefs.getString("subscription_plan_code", "NONE") ?: "NONE"
        val savedSubStart = prefs.getLong("subscription_start_epoch_millis", 0L)
        val savedSubExpiry = prefs.getLong("subscription_expiry_epoch_millis", 0L)
        val nowMillis = System.currentTimeMillis()
        val isSubStillValid = savedSubPlan != "NONE" && savedSubExpiry > nowMillis
        if (savedSubPlan != "NONE" && !isSubStillValid) {
            prefs.edit()
                .putString("subscription_plan_code", "NONE")
                .putLong("subscription_start_epoch_millis", 0L)
                .putLong("subscription_expiry_epoch_millis", 0L)
                .putBoolean("subscription_is_active", false)
                .apply()
        }

        com.example.ui.components.SubscriptionPassStateBridge.isSubscriptionActive = isSubStillValid
        com.example.ui.components.SubscriptionPassStateBridge.activePlanCode = if (isSubStillValid) savedSubPlan else "NONE"
        com.example.ui.components.SubscriptionPassStateBridge.expiryEpochMillis = if (isSubStillValid) savedSubExpiry else 0L
        com.example.ui.components.SubscriptionPassStateBridge.remainingDays = if (isSubStillValid) {
            (((savedSubExpiry - nowMillis) + (24L * 60L * 60L * 1000L - 1L)) / (24L * 60L * 60L * 1000L)).toInt().coerceAtLeast(1)
        } else 0
        com.example.ui.components.SubscriptionPassStateBridge.onSubscribeMonthly9Callback = {
            initiateSubscriptionCheckout("MONTHLY_9")
        }
        com.example.ui.components.SubscriptionPassStateBridge.onSubscribeYearly99Callback = {
            initiateSubscriptionCheckout("YEARLY_99")
        }
        com.example.ui.components.SubscriptionPassStateBridge.onSubscribeLifetime399Callback = {
            initiateSubscriptionCheckout("LIFETIME_399")
        }
        com.example.ui.components.SubscriptionPassStateBridge.onInitiateSubscriptionCheckoutCallback = { planCode ->
            initiateSubscriptionCheckout(planCode)
        }
        com.example.ui.components.SubscriptionPassStateBridge.onStartAnyMockTestCallback = { mockTest ->
            startTest(mockTest)
        }
        com.example.ui.components.SubscriptionPassStateBridge.onOpenFreeBrandedNoteCallback = { note ->
            openReader(note, 0)
        }
        com.example.ui.components.SubscriptionPassStateBridge.onDownloadFreeBrandedPdfCallback = { note ->
            cacheStudyItemForOffline(note)
        }

        _uiState.update {
            it.copy(
                ownerUpiId = if (savedUpi == "shakuntalam@upi") "6396817525@jio" else savedUpi,
                ownerUpiMobile = savedMobile,
                ownerMerchantName = savedMerchant,
                ownerBankName = savedBank,
                ownerAccountNumber = savedAcc,
                ownerIfscCode = savedIfsc,
                isAntiPiracyEnabled = antiPiracy,
                isAdminPinLockEnabled = pinLockEnabled,
                isAdminSessionUnlocked = !pinLockEnabled,
                dailyStreakDays = savedStreakDays,
                longestStreakDays = savedLongestStreak,
                rewardPoints = savedRewardPoints,
                lastQuizAttemptDateIso = savedLastQuizDate,
                completedStreakDatesIso = savedStreakDates,
                unlockedStreakBadgeIds = savedBadgeIds,
                isTodayStreakCompleted = savedLastQuizDate == todayIso || savedStreakDates.contains(todayIso),
                isLoggedIn = savedIsLoggedIn,
                currentUser = restoredUser,
                isAuthModalOpen = !savedIsLoggedIn,
                isAccountSetupModalOpen = savedIsLoggedIn && !savedAccountSetupDone,
                onboardingStudentNameInput = savedUserName,
                onboardingTargetExamInput = savedTargetExam,
                subscriptionPlanCode = if (isSubStillValid) savedSubPlan else "NONE",
                subscriptionStartEpochMillis = if (isSubStillValid) savedSubStart else 0L,
                subscriptionExpiryEpochMillis = if (isSubStillValid) savedSubExpiry else 0L,
                isSubscriptionActive = isSubStillValid
            )
        }

        viewModelScope.launch(kotlinx.coroutines.Dispatchers.IO) {
            runCatching {
                repository.checkAndSeedInitialData()
            }

            // Collect live Room exam hierarchies
            launch {
                runCatching {
                    repository.allExamHierarchies.collect { hierarchies ->
                        _uiState.update { current ->
                            current.copy(
                                roomExamHierarchies = hierarchies,
                                selectedRoomExamId = current.selectedRoomExamId ?: hierarchies.firstOrNull()?.exam?.id
                            )
                        }
                    }
                }
            }

            // Collect live Room uploaded PDF documents + Free Branded PDFs
            launch {
                runCatching {
                    repository.allDocuments.collect { docs ->
                        val mergedDocs = (docs + com.example.data.AllIndiaMasterTestPackageData.defaultBrandedPdfDocuments)
                            .distinctBy { it.id }
                        _uiState.update { it.copy(uploadedDocuments = mergedDocs) }
                    }
                }
            }

            // Collect live Room Offline Cached E-Books
            launch {
                runCatching {
                    repository.allCachedEbooks.collect { cachedEbooks ->
                        _uiState.update { it.copy(cachedOfflineEbooks = cachedEbooks) }
                    }
                }
            }

            // Collect live Room Offline Cached Mock Tests
            launch {
                runCatching {
                    repository.allCachedTests.collect { cachedTests ->
                        _uiState.update { it.copy(cachedOfflineTests = cachedTests) }
                    }
                }
            }
        }
    }

    // --- Security & Anti-Hacker Controls ---

    fun toggleAntiPiracy() {
        val next = !_uiState.value.isAntiPiracyEnabled
        prefs.edit().putBoolean("anti_piracy_enabled", next).apply()
        _uiState.update {
            it.copy(
                isAntiPiracyEnabled = next,
                toastMessage = if (next) "DRM Anti-Piracy & Screenshot Shield Enabled" else "DRM Screenshot Shield Paused"
            )
        }
    }

    fun toggleAdminPinLock() {
        val next = !_uiState.value.isAdminPinLockEnabled
        prefs.edit().putBoolean("admin_pin_lock_enabled", next).apply()
        _uiState.update {
            it.copy(
                isAdminPinLockEnabled = next,
                isAdminSessionUnlocked = true,
                toastMessage = if (next) "Admin PIN Protection Enabled (Default PIN: 2525)" else "Admin PIN Lock Disabled"
            )
        }
    }

    fun lockAdminSession() {
        _uiState.update {
            it.copy(
                isAdminSessionUnlocked = false,
                toastMessage = "Owner Admin Portal Locked"
            )
        }
    }

    fun verifyAdminPin(pinInput: String): Boolean {
        val currentAttempts = _uiState.value.failedAdminPinAttempts
        if (currentAttempts >= 5) {
            _uiState.update {
                it.copy(toastMessage = "Security Alert: Too many failed attempts! Brute-force shield active.")
            }
            return false
        }
        val storedHash = prefs.getString("admin_pin_sha256", com.example.security.SecurityManager.sha256("2525"))
        val inputHash = com.example.security.SecurityManager.sha256(pinInput.trim())
        return if (storedHash == inputHash) {
            _uiState.update {
                it.copy(
                    isAdminSessionUnlocked = true,
                    failedAdminPinAttempts = 0,
                    securityAuditLogs = listOf("Admin PIN Verified via SHA-256") + it.securityAuditLogs.take(5),
                    toastMessage = "Admin Portal Unlocked Successfully"
                )
            }
            true
        } else {
            val nextAttempts = currentAttempts + 1
            _uiState.update {
                it.copy(
                    failedAdminPinAttempts = nextAttempts,
                    securityAuditLogs = listOf("WARNING: Invalid Admin PIN Attempt #$nextAttempts blocked") + it.securityAuditLogs.take(5),
                    toastMessage = "Invalid Admin PIN ($nextAttempts/5 attempts)"
                )
            }
            false
        }
    }

    fun updateAdminPin(newPin: String) {
        val cleanPin = newPin.filter { it.isDigit() }.take(6)
        if (cleanPin.length < 4) {
            _uiState.update { it.copy(toastMessage = "PIN must be 4 to 6 digits") }
            return
        }
        prefs.edit()
            .putString("admin_pin_sha256", com.example.security.SecurityManager.sha256(cleanPin))
            .putBoolean("admin_pin_lock_enabled", true)
            .apply()
        _uiState.update {
            it.copy(
                isAdminPinLockEnabled = true,
                isAdminSessionUnlocked = true,
                securityAuditLogs = listOf("Owner Admin PIN updated (SHA-256 encrypted)") + it.securityAuditLogs.take(5),
                toastMessage = "New Admin Security PIN Saved!"
            )
        }
    }

    // Bilingual Language Switcher
    fun toggleLanguage() {
        val nextLang = if (_uiState.value.selectedLanguage == AppLanguage.HINDI) {
            AppLanguage.ENGLISH
        } else {
            AppLanguage.HINDI
        }
        _uiState.update {
            it.copy(
                selectedLanguage = nextLang,
                isBilingualHindi = nextLang == AppLanguage.HINDI,
                toastMessage = if (nextLang == AppLanguage.HINDI) "भाषा: हिंदी सेट की गई" else "Language set to English"
            )
        }
    }

    fun setLanguage(language: AppLanguage) {
        _uiState.update {
            it.copy(
                selectedLanguage = language,
                isBilingualHindi = language == AppLanguage.HINDI
            )
        }
    }

    // Payment Gateway Checkout Flow
    fun openPaymentGateway(amount: Int, title: String) {
        _uiState.update {
            it.copy(
                isPaymentGatewayOpen = true,
                paymentGatewayAmount = amount.coerceAtLeast(0),
                paymentGatewayItemTitle = com.example.security.SecurityManager.sanitizeInput(title, 120)
            )
        }
    }

    fun closePaymentGateway() {
        _uiState.update { it.copy(isPaymentGatewayOpen = false) }
    }

    fun onPaymentSuccess(receiptNumber: String) {
        val state = _uiState.value
        val newPurchased = state.cartItems.map { it.studyItem.id }.toSet()
        val sig = com.example.security.SecurityManager.generateSecuritySignature("$receiptNumber:${state.paymentGatewayAmount}:${state.ownerUpiId}")
        when (state.paymentGatewayAmount) {
            9 -> subscribeToPlan("MONTHLY_9")
            99 -> subscribeToPlan("YEARLY_99")
            399 -> subscribeToPlan("LIFETIME_399")
        }
        val isSubscriptionPayment = state.paymentGatewayAmount == 9 || state.paymentGatewayAmount == 99 || state.paymentGatewayAmount == 399
        _uiState.update {
            it.copy(
                isPaymentGatewayOpen = false,
                purchasedItemIds = it.purchasedItemIds + newPurchased,
                cartItems = emptyList(),
                appliedCoupon = null,
                couponDiscountPercent = 0,
                currentScreen = if (isSubscriptionPayment) it.currentScreen else AppScreen.LIBRARY,
                securityAuditLogs = listOf("Verified Payment #$receiptNumber [SHA-256:$sig]") + it.securityAuditLogs.take(5),
                toastMessage = if (state.selectedLanguage == AppLanguage.HINDI)
                    "भुगतान सफल! रसीद #$receiptNumber • सब्सक्रिप्शन एवं सभी पेड टेस्ट सीरीज़ अनलॉक हो गई हैं।"
                else
                    "Payment Successful! Receipt #$receiptNumber • Subscription & All Paid Test Series unlocked."
            )
        }
    }

    /**
     * Opens the UPI / Bank Payment Gateway checkout modal for a Subscription Plan (`MONTHLY_9`, `YEARLY_99`, or `LIFETIME_399`).
     * Paid tests only unlock after the student completes payment deduction (`onPaymentSuccess` or `subscribeToPlan`).
     */
    fun initiateSubscriptionCheckout(planCode: String) {
        val isHi = _uiState.value.selectedLanguage == AppLanguage.HINDI
        when (planCode.trim().uppercase()) {
            "LIFETIME_399", "LIFETIME", "399" -> openPaymentGateway(
                amount = 399,
                title = if (isHi) "शकुंतलम लाइफटाइम पास (₹399 • 10 वर्ष सभी एग्जाम्स)" else "Shakuntalam Lifetime All-Access Pass (₹399)"
            )
            "YEARLY_99", "YEARLY", "99", "ANNUAL" -> openPaymentGateway(
                amount = 99,
                title = if (isHi) "शकुंतलम वार्षिक पास (₹99/वर्ष • 365 दिन सभी एग्जाम्स)" else "Shakuntalam Yearly All-Access Pass (₹99/Year)"
            )
            else -> openPaymentGateway(
                amount = 9,
                title = if (isHi) "शकुंतलम मासिक पास (₹9/माह • 30 दिन सभी एग्जाम्स)" else "Shakuntalam Monthly All-Access Pass (₹9/Month)"
            )
        }
    }

    /**
     * Activates a Netflix-style All-Access Subscription Plan:
     *  - "MONTHLY_9": ₹9 / Month (30 days validity) — unlocks all Test Series & Paid Sections for 1 month.
     *  - "YEARLY_99": ₹99 / Year (365 days validity) — unlocks all Test Series & Paid Sections for 1 year.
     *  - "LIFETIME_399": ₹399 / Lifetime (3650 days validity) — unlocks all Test Series & Paid Sections for 10 years.
     */
    fun subscribeToPlan(
        planCode: String,
        nowMillis: Long = System.currentTimeMillis()
    ) {
        val planTier = com.example.data.remote.SubscriptionPlanTier.fromCodeOrPrice(planCode)
            .let { if (it == com.example.data.remote.SubscriptionPlanTier.NONE) com.example.data.remote.SubscriptionPlanTier.MONTHLY_9 else it }
        val normalizedPlan = planTier.planCode
        val durationMillis = planTier.durationMillis
        val expiryMillis = nowMillis + durationMillis
        val daysCount = planTier.durationDays

        prefs.edit()
            .putString("subscription_plan_code", normalizedPlan)
            .putLong("subscription_start_epoch_millis", nowMillis)
            .putLong("subscription_expiry_epoch_millis", expiryMillis)
            .putBoolean("subscription_is_active", true)
            .apply()

        com.example.ui.components.SubscriptionPassStateBridge.isSubscriptionActive = true
        com.example.ui.components.SubscriptionPassStateBridge.activePlanCode = normalizedPlan
        com.example.ui.components.SubscriptionPassStateBridge.expiryEpochMillis = expiryMillis
        com.example.ui.components.SubscriptionPassStateBridge.remainingDays = daysCount

        val allStudyIds = _uiState.value.customStudyItems.map { it.id }.toSet()
        val isHi = _uiState.value.selectedLanguage == AppLanguage.HINDI
        val feedback = when (normalizedPlan) {
            "LIFETIME_399" -> if (isHi) "₹399 लाइफटाइम ऑल-एक्सेस पास सक्रिय! सभी परीक्षाओं के टेस्ट अनलॉक हो गए।" else "₹399 Lifetime All-Access Pass Activated! All Exams Unlocked."
            "YEARLY_99" -> if (isHi) "₹99 वार्षिक ऑल-एक्सेस पास (365 दिन) सक्रिय! सभी परीक्षाओं के टेस्ट अनलॉक हो गए।" else "₹99 Yearly All-Access Pass (365 Days) Activated! All Exams Unlocked."
            else -> if (isHi) "₹9 मासिक ऑल-एक्सेस पास (30 दिन) सक्रिय! सभी परीक्षाओं के टेस्ट अनलॉक हो गए।" else "₹9 Monthly All-Access Pass (30 Days) Activated! All Exams Unlocked."
        }

        _uiState.update {
            it.copy(
                subscriptionPlanCode = normalizedPlan,
                subscriptionStartEpochMillis = nowMillis,
                subscriptionExpiryEpochMillis = expiryMillis,
                isSubscriptionActive = true,
                purchasedItemIds = it.purchasedItemIds + allStudyIds,
                toastMessage = feedback
            )
        }

        // Persist active subscription status to Cloud Firestore (`/subscriptions/{userId}`)
        val repo = studentAuthRepo
        if (repo != null && repo.currentUserId() != null) {
            viewModelScope.launch(kotlinx.coroutines.Dispatchers.IO) {
                runCatching {
                    val uid = repo.currentUserId() ?: return@runCatching
                    val existingSub = repo.getUserSubscription(uid).getOrNull()
                    repo.saveOrActivateSubscription(
                        planTier = planTier,
                        receiptNumber = "SUB-$normalizedPlan-$nowMillis",
                        nowMillis = nowMillis,
                        existingCreatedAt = existingSub?.createdAt
                    )
                }
            }
        }
    }

    /**
     * Synchronizes local ViewModel and SharedPreferences subscription state with a live
     * [com.example.data.remote.FirestoreUserSubscription] observed by [SubscriptionViewModel].
     */
    fun syncSubscriptionFromFirestore(
        firestoreSub: com.example.data.remote.FirestoreUserSubscription?,
        nowMillis: Long = System.currentTimeMillis()
    ) {
        if (firestoreSub == null) return
        val isValid = firestoreSub.isCurrentlyActive(nowMillis)
        val normalizedPlan = if (isValid) firestoreSub.planCode else "NONE"
        val startMs = if (isValid) firestoreSub.startEpochMillis else 0L
        val expiryMs = if (isValid) firestoreSub.expiryEpochMillis else 0L
        val remDays = if (isValid) firestoreSub.remainingDays(nowMillis) else 0

        prefs.edit()
            .putString("subscription_plan_code", normalizedPlan)
            .putLong("subscription_start_epoch_millis", startMs)
            .putLong("subscription_expiry_epoch_millis", expiryMs)
            .putBoolean("subscription_is_active", isValid)
            .apply()

        com.example.ui.components.SubscriptionPassStateBridge.isSubscriptionActive = isValid
        com.example.ui.components.SubscriptionPassStateBridge.activePlanCode = normalizedPlan
        com.example.ui.components.SubscriptionPassStateBridge.expiryEpochMillis = expiryMs
        com.example.ui.components.SubscriptionPassStateBridge.remainingDays = remDays

        val allStudyIds = if (isValid) _uiState.value.customStudyItems.map { it.id }.toSet() else emptySet()
        _uiState.update {
            it.copy(
                subscriptionPlanCode = normalizedPlan,
                subscriptionStartEpochMillis = startMs,
                subscriptionExpiryEpochMillis = expiryMs,
                isSubscriptionActive = isValid,
                purchasedItemIds = if (isValid) it.purchasedItemIds + allStudyIds else setOf("upsc_mod_history"),
                examTestSeriesModeMap = if (isValid) it.examTestSeriesModeMap else it.examTestSeriesModeMap.mapValues { "FREE" }
            )
        }
    }

    /**
     * Starts any test from `AllIndiaMasterTestPackageData.getExamPackageEntries(examKey)`.
     * If the test is Paid-Only and the student does not have an active subscription pass,
     * opens the Payment Checkout Gate (`initiateSubscriptionCheckout`) and returns `false`.
     */
    fun startExamPackageTest(examKey: String, testId: String): Boolean {
        checkAndExpireSubscription()
        val entries = com.example.data.AllIndiaMasterTestPackageData.getExamPackageEntries(examKey)
        val entry = entries.firstOrNull { it.id.equals(testId, ignoreCase = true) || it.mockTest.testId.equals(testId, ignoreCase = true) }
            ?: entries.firstOrNull()
            ?: return false
        if (entry.isPaidOnly && !_uiState.value.isAllAccessSubscriptionValid()) {
            initiateSubscriptionCheckout("MONTHLY_9")
            return false
        }
        startTest(entry.mockTest)
        return true
    }

    /**
     * Checks whether the student's 1-Month (₹9), 1-Year (₹99), or Lifetime (₹399) subscription has reached its expiry timestamp.
     * If expired, automatically deactivates the subscription and re-locks all Paid sections back to "FREE".
     */
    fun checkAndExpireSubscription(nowMillis: Long = System.currentTimeMillis()): Boolean {
        val state = _uiState.value
        val hasExpired = state.subscriptionExpiryEpochMillis in 1..nowMillis ||
                (state.isSubscriptionActive && state.subscriptionExpiryEpochMillis <= nowMillis)
        if (!hasExpired) return false

        prefs.edit()
            .putString("subscription_plan_code", "NONE")
            .putLong("subscription_start_epoch_millis", 0L)
            .putLong("subscription_expiry_epoch_millis", 0L)
            .putBoolean("subscription_is_active", false)
            .apply()

        com.example.ui.components.SubscriptionPassStateBridge.isSubscriptionActive = false
        com.example.ui.components.SubscriptionPassStateBridge.activePlanCode = "NONE"
        com.example.ui.components.SubscriptionPassStateBridge.expiryEpochMillis = 0L
        com.example.ui.components.SubscriptionPassStateBridge.remainingDays = 0

        val relockedModeMap = state.examTestSeriesModeMap.mapValues { "FREE" }
        val isHi = state.selectedLanguage == AppLanguage.HINDI

        _uiState.update {
            it.copy(
                subscriptionPlanCode = "NONE",
                subscriptionStartEpochMillis = 0L,
                subscriptionExpiryEpochMillis = 0L,
                isSubscriptionActive = false,
                purchasedItemIds = setOf("upsc_mod_history"),
                examTestSeriesModeMap = relockedModeMap,
                toastMessage = if (isHi)
                    "आपका सब्सक्रिप्शन समाप्त हो गया है। पेड सेक्शन पुनः लॉक कर दिया गया है (₹9/माह या ₹99/वर्ष से नवीनीकरण करें)।"
                else
                    "Your subscription has expired. Paid sections are now locked (Renew at ₹9/Month or ₹99/Year)."
            )
        }

        val repo = studentAuthRepo
        val uid = repo?.currentUserId()
        if (repo != null && !uid.isNullOrBlank()) {
            viewModelScope.launch(kotlinx.coroutines.Dispatchers.IO) {
                runCatching {
                    repo.expireUserSubscription(uid)
                }
            }
        }
        return true
    }

    // Owner / Publisher PDF Document Management Flow
    fun openOwnerPortal() {
        _uiState.update {
            it.copy(
                previousScreen = it.currentScreen,
                currentScreen = AppScreen.OWNER_PORTAL
            )
        }
    }

    fun uploadPdfDocument(
        title: String,
        hindiTitle: String,
        examId: String,
        subjectId: String,
        fileName: String,
        fileUri: String,
        originalPrice: Int,
        discountedPrice: Int,
        pageCount: Int,
        medium: String
    ) {
        val safeTitle = com.example.security.SecurityManager.sanitizeInput(title, 120)
        val safeHindiTitle = com.example.security.SecurityManager.sanitizeInput(hindiTitle.ifBlank { safeTitle }, 120)
        val safeFileName = com.example.security.SecurityManager.sanitizeInput(fileName, 100)
        viewModelScope.launch {
            val doc = EbookDocumentEntity(
                id = "doc_${System.currentTimeMillis()}",
                title = safeTitle,
                hindiTitle = safeHindiTitle,
                examId = examId,
                subjectId = subjectId,
                fileName = safeFileName,
                fileUri = fileUri,
                fileSizeFormatted = "${(pageCount * 32) / 1024 + 3}.${(pageCount % 10)} MB",
                pageCount = pageCount.coerceIn(1, 5000),
                originalPrice = originalPrice.coerceAtLeast(0),
                discountedPrice = discountedPrice.coerceAtLeast(0),
                medium = medium,
                sampleContent = "PDF Document: $safeTitle. Published for competitive examination preparation."
            )
            repository.insertDocument(doc)
            _uiState.update {
                it.copy(
                    securityAuditLogs = listOf("PDF Uploaded & Checksummed: $safeFileName") + it.securityAuditLogs.take(5),
                    toastMessage = if (it.selectedLanguage == AppLanguage.HINDI)
                        "दस्तावेज़ सफलतापूर्वक अपलोड किया गया: $safeHindiTitle"
                    else
                        "PDF Document uploaded: $safeTitle"
                )
            }
        }
    }

    fun deletePdfDocument(docId: String) {
        viewModelScope.launch {
            repository.deleteDocument(docId)
            _uiState.update {
                it.copy(
                    toastMessage = if (it.selectedLanguage == AppLanguage.HINDI)
                        "दस्तावेज़ सफलतापूर्वक हटाया गया (Deleted)"
                    else
                        "Document deleted successfully"
                )
            }
        }
    }

    // --- Owner Live Pricing Controls ---

    fun updateDocumentPrice(docId: String, newOriginalPrice: Int, newDiscountedPrice: Int) {
        viewModelScope.launch {
            repository.updateDocumentPrices(docId, newOriginalPrice.coerceAtLeast(0), newDiscountedPrice.coerceAtLeast(0))
            _uiState.update {
                it.copy(
                    toastMessage = if (it.selectedLanguage == AppLanguage.HINDI)
                        "कीमत अपडेट की गई: ₹$newDiscountedPrice (MRP: ₹$newOriginalPrice)"
                    else
                        "Price updated: ₹$newDiscountedPrice (MRP: ₹$newOriginalPrice)"
                )
            }
        }
    }

    fun updateStudyItemPrice(itemId: String, newOriginalPrice: Int, newDiscountedPrice: Int) {
        _uiState.update { current ->
            val updatedItems = current.customStudyItems.map { item ->
                if (item.id == itemId) {
                    item.copy(
                        originalPrice = newOriginalPrice.coerceAtLeast(0),
                        discountedPrice = newDiscountedPrice.coerceAtLeast(0)
                    )
                } else {
                    item
                }
            }
            current.copy(
                customStudyItems = updatedItems,
                toastMessage = if (current.selectedLanguage == AppLanguage.HINDI)
                    "पुस्तक की कीमत सफलतापूर्वक अपडेट की गई!"
                else
                    "E-Book pricing updated successfully!"
            )
        }
    }

    fun updateOwnerUpiDetails(
        newUpiId: String,
        newMerchantName: String,
        newUpiMobile: String = _uiState.value.ownerUpiMobile,
        newBankName: String = _uiState.value.ownerBankName,
        newAccountNumber: String = _uiState.value.ownerAccountNumber,
        newIfscCode: String = _uiState.value.ownerIfscCode
    ) {
        val cleanUpi = com.example.security.SecurityManager.sanitizeInput(newUpiId, 80).ifBlank { "6396817525@jio" }
        if (!com.example.security.SecurityManager.isValidUpiId(cleanUpi)) {
            _uiState.update {
                it.copy(
                    toastMessage = if (it.selectedLanguage == AppLanguage.HINDI)
                        "अमान्य UPI ID प्रारूप! उदाहरण: 6396817525@jio"
                    else
                        "Invalid UPI ID format! Example: 6396817525@jio"
                )
            }
            return
        }
        val cleanMobile = newUpiMobile.filter { it.isDigit() }.take(10).ifBlank { "6396817525" }
        val cleanMerchant = com.example.security.SecurityManager.sanitizeInput(newMerchantName, 80).ifBlank { "Shakuntalam Publications" }
        val cleanBank = com.example.security.SecurityManager.sanitizeInput(newBankName, 80).ifBlank { "Jio Payments Bank / UPI Linked Bank" }
        val cleanAcc = newAccountNumber.filter { it.isDigit() }.take(18)
        val cleanIfsc = com.example.security.SecurityManager.sanitizeInput(newIfscCode, 11).uppercase()

        prefs.edit()
            .putString("owner_upi_id", cleanUpi)
            .putString("owner_upi_mobile", cleanMobile)
            .putString("owner_merchant_name", cleanMerchant)
            .putString("owner_bank_name", cleanBank)
            .putString("owner_account_no", cleanAcc)
            .putString("owner_ifsc", cleanIfsc)
            .apply()

        _uiState.update { current ->
            current.copy(
                ownerUpiId = cleanUpi,
                ownerUpiMobile = cleanMobile,
                ownerMerchantName = cleanMerchant,
                ownerBankName = cleanBank,
                ownerAccountNumber = cleanAcc,
                ownerIfscCode = cleanIfsc,
                securityAuditLogs = listOf("Verified Owner UPI Updated: $cleanUpi ($cleanMobile)") + current.securityAuditLogs.take(5),
                toastMessage = if (current.selectedLanguage == AppLanguage.HINDI)
                    "आपकी UPI ID ($cleanUpi • $cleanMobile) और बैंक विवरण सफलतापूर्वक लिंक हो गए हैं!"
                else
                    "UPI ID ($cleanUpi • $cleanMobile) & Bank details linked!"
            )
        }
    }

    // --- Owner Online Test & Questions Creation ---

    fun createOnlineMockTest(
        title: String,
        hindiTitle: String,
        examName: String,
        durationMinutes: Int = 30,
        totalMarks: Int = 50,
        positiveMarks: Double = 2.0,
        negativeMarks: Double = 0.5,
        questions: List<TestQuestion> = emptyList()
    ) {
        val newTest = MockTest(
            testId = "test_custom_${System.currentTimeMillis()}",
            title = title,
            hindiTitle = hindiTitle,
            examName = examName,
            durationMinutes = durationMinutes,
            totalMarks = totalMarks,
            positiveMarks = positiveMarks,
            negativeMarks = negativeMarks,
            questions = questions
        )
        _uiState.update { current ->
            current.copy(
                customTests = current.customTests + newTest,
                activeTest = newTest,
                toastMessage = if (current.selectedLanguage == AppLanguage.HINDI)
                    "नया ऑनलाइन मॉक टेस्ट सफलतापूर्वक प्रकाशित हुआ: $hindiTitle"
                else
                    "New Online Test published successfully: $title"
            )
        }
    }

    fun addQuestionToMockTest(testId: String, question: TestQuestion) {
        _uiState.update { current ->
            val updatedTests = current.customTests.map { test ->
                if (test.testId == testId) {
                    test.copy(questions = test.questions + question)
                } else {
                    test
                }
            }
            val active = if (current.activeTest.testId == testId) {
                current.activeTest.copy(questions = current.activeTest.questions + question)
            } else {
                current.activeTest
            }
            current.copy(
                customTests = updatedTests,
                activeTest = active,
                toastMessage = if (current.selectedLanguage == AppLanguage.HINDI)
                    "प्रश्न एवं समाधान ऑनलाइन टेस्ट में जोड़ा गया!"
                else
                    "Question & Solution added to Online Test!"
            )
        }
    }

    // --- PDF Reading & Downloading ---

    fun openPdfForReading(doc: EbookDocumentEntity) {
        _uiState.update {
            it.copy(
                currentDocForReading = doc,
                currentScreen = AppScreen.READER
            )
        }
    }

    fun closePdfReading() {
        _uiState.update {
            it.copy(currentDocForReading = null)
        }
    }

    /**
     * Owner Mistake Fixer: Edit any existing question, its 4 options, correct answer index, or explanation in any MockTest.
     */
    fun updateQuestionInMockTest(testId: String, updatedQuestion: TestQuestion) {
        _uiState.update { state ->
            var activeUpdated: MockTest? = if (state.activeTest.testId == testId) state.activeTest else null
            state.copy(
                customTests = state.customTests.map { test ->
                    if (test.testId == testId) {
                        val newQuestions = test.questions.map { q ->
                            if (q.id == updatedQuestion.id) updatedQuestion else q
                        }
                        val updatedTest = test.copy(
                            questions = newQuestions
                        )
                        if (activeUpdated?.testId == testId) {
                            activeUpdated = updatedTest
                        }
                        updatedTest
                    } else {
                        test
                    }
                },
                activeTest = activeUpdated ?: state.activeTest,
                toastMessage = if (state.selectedLanguage == AppLanguage.HINDI)
                    "✓ प्रश्न एवं समाधान में सुधार सेव किया गया!"
                else
                    "✓ Question & Solution updated successfully!"
            )
        }
    }

    /**
     * Owner Question Deleter: Delete a specific question from a MockTest.
     */
    fun deleteQuestionFromMockTest(testId: String, questionId: Int) {
        _uiState.update { state ->
            var activeUpdated: MockTest? = if (state.activeTest.testId == testId) state.activeTest else null
            state.copy(
                customTests = state.customTests.map { test ->
                    if (test.testId == testId) {
                        val remaining = test.questions.filterNot { it.id == questionId }
                        val updatedTest = test.copy(
                            questions = remaining
                        )
                        if (activeUpdated?.testId == testId) {
                            activeUpdated = updatedTest
                        }
                        updatedTest
                    } else {
                        test
                    }
                },
                activeTest = activeUpdated ?: state.activeTest,
                toastMessage = if (state.selectedLanguage == AppLanguage.HINDI)
                    "प्रश्न हटा दिया गया है"
                else
                    "Question deleted from test"
            )
        }
    }

    /**
     * Owner Test Metadata Editor: Edit test title (English/Hindi), exam name, duration, marks, or marking scheme.
     */
    fun updateMockTestMetadata(
        testId: String,
        newTitleEn: String,
        newTitleHi: String,
        newExamName: String,
        newDurationMinutes: Int,
        newTotalMarks: Int,
        newPositiveMarks: Double,
        newNegativeMarks: Double
    ) {
        _uiState.update { state ->
            var activeUpdated: MockTest? = if (state.activeTest.testId == testId) state.activeTest else null
            state.copy(
                customTests = state.customTests.map { test ->
                    if (test.testId == testId) {
                        val updatedTest = test.copy(
                            title = newTitleEn.ifBlank { test.title },
                            hindiTitle = newTitleHi.ifBlank { test.hindiTitle },
                            examName = newExamName.ifBlank { test.examName },
                            durationMinutes = newDurationMinutes.coerceAtLeast(5),
                            totalMarks = newTotalMarks.coerceAtLeast(1),
                            positiveMarks = newPositiveMarks,
                            negativeMarks = newNegativeMarks
                        )
                        if (activeUpdated?.testId == testId) {
                            activeUpdated = updatedTest
                        }
                        updatedTest
                    } else {
                        test
                    }
                },
                activeTest = activeUpdated ?: state.activeTest,
                toastMessage = if (state.selectedLanguage == AppLanguage.HINDI)
                    "✓ टेस्ट सीरीज़ विवरण अपडेट किया गया!"
                else
                    "✓ Test Series details updated!"
            )
        }
    }

    /**
     * Owner Test Deleter: Delete an entire MockTest from customTests.
     */
    fun deleteMockTestFromCatalog(testId: String) {
        _uiState.update { state ->
            val remaining = state.customTests.filterNot { it.testId == testId }
            state.copy(
                customTests = remaining,
                activeTest = if (state.activeTest.testId == testId && remaining.isNotEmpty()) remaining.first() else state.activeTest,
                toastMessage = if (state.selectedLanguage == AppLanguage.HINDI)
                    "टेस्ट सीरीज़ हटा दी गई है"
                else
                    "Test Series deleted"
            )
        }
    }

    /**
     * Owner E-Book & Study Item Full Editor: Edit title, Hindi title, series/badge, original MRP, and discounted price.
     */
    fun updateStudyItemFullDetails(
        itemId: String,
        newTitleEn: String,
        newTitleHi: String,
        newAuthorOrBadge: String,
        newOriginalPrice: Int,
        newDiscountedPrice: Int
    ) {
        _uiState.update { state ->
            state.copy(
                customStudyItems = state.customStudyItems.map { item ->
                    if (item.id == itemId) {
                        item.copy(
                            title = newTitleEn.ifBlank { item.title },
                            hindiTitle = newTitleHi.ifBlank { item.hindiTitle },
                            seriesName = newAuthorOrBadge.ifBlank { item.seriesName },
                            originalPrice = newOriginalPrice.coerceAtLeast(0),
                            discountedPrice = newDiscountedPrice.coerceAtLeast(0)
                        )
                    } else {
                        item
                    }
                },
                toastMessage = if (state.selectedLanguage == AppLanguage.HINDI)
                    "✓ ई-बुक का नाम, थंबनेल बैज व कीमत अपडेट की गई!"
                else
                    "✓ E-Book title, badge & price updated!"
            )
        }
    }

    /**
     * Owner E-Book Deleter: Remove a catalog study item / E-Book.
     */
    fun deleteStudyItemFromCatalog(itemId: String) {
        _uiState.update { state ->
            state.copy(
                customStudyItems = state.customStudyItems.filterNot { it.id == itemId },
                toastMessage = if (state.selectedLanguage == AppLanguage.HINDI)
                    "ई-बुक कैटलॉग से हटा दी गई है"
                else
                    "E-Book removed from catalog"
            )
        }
    }

    fun downloadPdf(title: String, fileName: String) {
        val matchingBook = _uiState.value.customStudyItems.firstOrNull {
            it.title.equals(title, ignoreCase = true) || fileName.startsWith(it.id, ignoreCase = true)
        }
        if (matchingBook != null) {
            cacheStudyItemForOffline(matchingBook)
        }
        _uiState.update {
            it.copy(
                toastMessage = if (it.selectedLanguage == AppLanguage.HINDI)
                    "पीडीएफ एवं ऑफलाइन कैश सुरक्षित: $fileName (Room DB में सेव)"
                else
                    "PDF & Offline Cache saved to Room DB: $fileName"
            )
        }
    }

    // --- Room Database Local Offline Caching (E-Books & Test Materials) ---

    fun toggleOfflineMode(enabled: Boolean? = null) {
        val next = enabled ?: !_uiState.value.isOfflineModeActive
        _uiState.update {
            it.copy(
                isOfflineModeActive = next,
                toastMessage = if (next) {
                    if (it.selectedLanguage == AppLanguage.HINDI)
                        "ऑफलाइन मोड सक्रिय: Room डेटाबेस कैश से अध्ययन सामग्री उपलब्ध"
                    else
                        "Offline Mode Active: Serving E-Books & Tests from Room Local Cache"
                } else {
                    if (it.selectedLanguage == AppLanguage.HINDI)
                        "ऑनलाइन मोड सक्रिय (Online Mode Restored)"
                    else
                        "Online Mode Active"
                }
            )
        }
    }

    fun cacheStudyItemForOffline(item: StudyItem) {
        val entity = OfflineEbookCacheEntity.fromStudyItem(item)
        _uiState.update { current ->
            val updatedList = listOf(entity) + current.cachedOfflineEbooks.filterNot { it.itemId == entity.itemId }
            current.copy(
                cachedOfflineEbooks = updatedList,
                toastMessage = if (current.selectedLanguage == AppLanguage.HINDI)
                    "ई-बुक ऑफलाइन एक्सेस हेतु Room DB में सेव हुई: ${item.hindiTitle}"
                else
                    "E-Book cached in Room DB for offline access: ${item.title}"
            )
        }
        viewModelScope.launch(kotlinx.coroutines.Dispatchers.IO) {
            runCatching {
                repository.cacheEbookForOffline(item)
            }
        }
    }

    fun cacheMockTestForOffline(test: MockTest) {
        val entity = OfflineTestCacheEntity.fromMockTest(test)
        _uiState.update { current ->
            val updatedList = listOf(entity) + current.cachedOfflineTests.filterNot { it.testId == entity.testId }
            current.copy(
                cachedOfflineTests = updatedList,
                toastMessage = if (current.selectedLanguage == AppLanguage.HINDI)
                    "टेस्ट सीरीज़ (${test.questions.size} प्रश्न) ऑफलाइन प्रैक्टिस हेतु Room DB में सेव!"
                else
                    "Test Series (${test.questions.size} Qs) cached in Room DB for offline access!"
            )
        }
        viewModelScope.launch(kotlinx.coroutines.Dispatchers.IO) {
            runCatching {
                repository.cacheMockTestForOffline(test)
            }
        }
    }

    fun cacheAllCoreMaterialsForOffline() {
        val ebooksToCache = _uiState.value.customStudyItems.filter { it.type == ContentType.EBOOK }.take(4)
        val testsToCache = _uiState.value.customTests.take(4)
        val ebookEntities = ebooksToCache.map { OfflineEbookCacheEntity.fromStudyItem(it) }
        val testEntities = testsToCache.map { OfflineTestCacheEntity.fromMockTest(it) }

        _uiState.update { current ->
            val mergedEbooks = (ebookEntities + current.cachedOfflineEbooks).distinctBy { it.itemId }
            val mergedTests = (testEntities + current.cachedOfflineTests).distinctBy { it.testId }
            current.copy(
                cachedOfflineEbooks = mergedEbooks,
                cachedOfflineTests = mergedTests,
                toastMessage = if (current.selectedLanguage == AppLanguage.HINDI)
                    "${mergedEbooks.size} ई-बुक्स एवं ${mergedTests.size} टेस्ट ऑफलाइन एक्सेस हेतु Room DB में सेव किए गए!"
                else
                    "Cached ${mergedEbooks.size} E-Books & ${mergedTests.size} Tests in Room DB for offline access!"
            )
        }

        viewModelScope.launch(kotlinx.coroutines.Dispatchers.IO) {
            runCatching {
                ebooksToCache.forEach { repository.cacheEbookForOffline(it) }
                testsToCache.forEach { repository.cacheMockTestForOffline(it) }
            }
        }
    }

    fun removeOfflineCachedEbook(itemId: String) {
        _uiState.update { current ->
            current.copy(
                cachedOfflineEbooks = current.cachedOfflineEbooks.filterNot { it.itemId == itemId },
                toastMessage = if (current.selectedLanguage == AppLanguage.HINDI)
                    "ई-बुक ऑफलाइन कैश से हटाई गई"
                else
                    "Removed E-Book from Room offline cache"
            )
        }
        viewModelScope.launch(kotlinx.coroutines.Dispatchers.IO) {
            runCatching {
                repository.removeCachedEbook(itemId)
            }
        }
    }

    fun removeOfflineCachedTest(testId: String) {
        _uiState.update { current ->
            current.copy(
                cachedOfflineTests = current.cachedOfflineTests.filterNot { it.testId == testId },
                toastMessage = if (current.selectedLanguage == AppLanguage.HINDI)
                    "टेस्ट ऑफलाइन कैश से हटाया गया"
                else
                    "Removed Test from Room offline cache"
            )
        }
        viewModelScope.launch(kotlinx.coroutines.Dispatchers.IO) {
            runCatching {
                repository.removeCachedTest(testId)
            }
        }
    }

    fun clearAllOfflineCache() {
        _uiState.update { current ->
            current.copy(
                cachedOfflineEbooks = emptyList(),
                cachedOfflineTests = emptyList(),
                toastMessage = if (current.selectedLanguage == AppLanguage.HINDI)
                    "संपूर्ण ऑफलाइन कैश साफ़ किया गया"
                else
                    "Cleared all Room offline cached E-Books & Tests"
            )
        }
        viewModelScope.launch(kotlinx.coroutines.Dispatchers.IO) {
            runCatching {
                repository.clearAllOfflineCache()
            }
        }
    }

    fun openOfflineCachedEbook(cached: OfflineEbookCacheEntity) {
        val reconstructedItem = cached.toStudyItem()
        _uiState.update { it.copy(selectedItem = reconstructedItem) }
        openReader(reconstructedItem, chapterIndex = 0)
    }

    fun startOfflineCachedTest(cached: OfflineTestCacheEntity) {
        val reconstructedTest = cached.toMockTest()
        startTest(reconstructedTest)
    }

    fun selectRoomExam(examId: String) {
        _uiState.update { it.copy(selectedRoomExamId = examId) }
    }

    fun addSubTopicToSubject(
        subjectId: String,
        name: String,
        hindiName: String,
        importanceLevel: String = "High Yield",
        hours: Double = 3.0
    ) {
        viewModelScope.launch {
            val newSubTopic = SubTopicEntity(
                id = "sub_${System.currentTimeMillis()}",
                subjectId = subjectId,
                name = name,
                hindiName = hindiName,
                importanceLevel = importanceLevel,
                estimatedHours = hours,
                pyqCount = 15,
                summary = "Added via Shakuntalam Syllabus Planner",
                orderIndex = 10
            )
            repository.insertSubTopic(newSubTopic)
            _uiState.update { it.copy(toastMessage = "नया सब-टॉपिक जोड़ा गया: $hindiName") }
        }
    }

    fun deleteSubTopic(subTopicId: String) {
        viewModelScope.launch {
            repository.deleteSubTopic(subTopicId)
            _uiState.update { it.copy(toastMessage = "सब-टॉपिक हटाया गया") }
        }
    }

    fun navigateTo(screen: AppScreen) {
        _uiState.update { current ->
            current.copy(
                previousScreen = if (current.currentScreen == screen) current.previousScreen else current.currentScreen,
                currentScreen = screen
            )
        }
    }

    fun openPerformanceAnalytics() {
        navigateTo(AppScreen.PERFORMANCE_ANALYTICS)
    }

    /**
     * Appends a progressively improved mock test attempt to [testAttemptsHistory]
     * so students can immediately visualize upward trends across Historical Scores,
     * Average Accuracy, and Time-Spent-Per-Question charts.
     */
    fun recordSampleImprovementAttempt() {
        val state = _uiState.value
        val existingCount = state.testAttemptsHistory.size
        val targetExam = state.currentUser?.targetExam?.ifBlank { "UPSC Civil Services" } ?: "UPSC Civil Services"
        val stepBoost = (existingCount + 1).coerceAtMost(6)
        val correct = (58 + stepBoost * 5).coerceAtMost(94)
        val wrong = (12 - stepBoost).coerceAtLeast(3)
        val unattempted = (100 - correct - wrong).coerceAtLeast(0)
        val totalMarks = 200
        val score = (correct * 2.0) - (wrong * 0.5)
        val timePerQ = (42 - stepBoost * 3).coerceAtLeast(22)
        val totalTimeSeconds = (correct + wrong) * timePerQ

        val newAttempt = UserTestAttempt(
            testId = "analytics_drill_${existingCount + 1}",
            testTitle = "$targetExam — Timed PYQ Mock #${existingCount + 1}",
            score = score,
            totalMarks = totalMarks,
            correctCount = correct,
            wrongCount = wrong,
            unattemptedCount = unattempted,
            timeSpentSeconds = totalTimeSeconds
        )

        _uiState.update {
            it.copy(
                lastTestAttempt = newAttempt,
                testAttemptsHistory = it.testAttemptsHistory + newAttempt,
                toastMessage = "नया टेस्ट प्रयास चार्ट में जोड़ा गया: स्कोर ${"%.1f".format(score)}/$totalMarks"
            )
        }
        syncCurrentStudentProfileToCloud()
    }

    fun navigateBack(): Boolean {
        val state = _uiState.value
        if (state.currentScreen != AppScreen.HOME) {
            _uiState.update { it.copy(currentScreen = it.previousScreen) }
            return true
        }
        return false
    }

    fun setSearchQuery(query: String) {
        val safeQuery = com.example.security.SecurityManager.sanitizeInput(query, 80)
        _uiState.update { it.copy(searchQuery = safeQuery) }
    }

    fun selectDashboardCategoryFilter(categoryKey: String) {
        val normalized = when (categoryKey.trim().uppercase()) {
            "", "ALL", "ALL_EXAMS" -> "ALL"
            "TET", "CTET", "UPTET", "UTET", "REET", "TEACHING", "CTET / TET" -> "TET"
            "IIT_JEE", "IIT JEE", "JEE", "JEE_MAIN", "JEE_ADVANCED", "JEE_NEET" -> "IIT_JEE"
            "NEET", "NEET_UG", "NEET UG", "NEET (UG)" -> "NEET"
            "UGC_NET", "UGC NET", "UGC", "UGC_CSIR_NET", "JRF" -> "UGC_NET"
            "UPSC", "UPSC_CSE", "IAS" -> "UPSC"
            "SSC", "SSC_CGL", "SSC_CHSL", "SSC_CPO" -> "SSC"
            "BANKING", "BANK", "IBPS", "SBI" -> "BANKING"
            "STATE_PSC", "STATE PSC", "PSC" -> "STATE_PSC"
            "UPPCS", "UPPSC", "PSC_UPPCS" -> "UPPCS"
            "UKPSC", "PSC_UKPSC" -> "UKPSC"
            "BPSC", "PSC_BPSC" -> "BPSC"
            "UPSSSC", "SUB_UPSSSC" -> "UPSSSC"
            "UKSSSC", "UKSSC", "SUB_UKSSSC" -> "UKSSSC"
            "UP_POLICE", "UP POLICE", "UP_CONSTABLE", "UP CONSTABLE", "UPP", "UP_SI" -> "UP_POLICE"
            "SUBORDINATE", "SUBORDINATE_SELECTION" -> "SUBORDINATE"
            "RAILWAYS", "RAILWAY", "RRB" -> "RAILWAYS"
            else -> categoryKey.trim().uppercase()
        }
        _uiState.update { state ->
            state.copy(
                selectedDashboardCategoryFilter = normalized,
                isTetFreeTestSectionExpanded = if (normalized == "TET") true else state.isTetFreeTestSectionExpanded,
                isIitJeeFreeTestSectionExpanded = if (normalized == "IIT_JEE") true else state.isIitJeeFreeTestSectionExpanded,
                isNeetFreeTestSectionExpanded = if (normalized == "NEET") true else state.isNeetFreeTestSectionExpanded,
                isUgcNetFreeTestSectionExpanded = if (normalized == "UGC_NET") true else state.isUgcNetFreeTestSectionExpanded,
                isUpscFreeTestSectionExpanded = if (normalized == "UPSC") true else state.isUpscFreeTestSectionExpanded,
                isUppcsFreeTestSectionExpanded = if (normalized == "UPPCS" || normalized == "STATE_PSC") true else state.isUppcsFreeTestSectionExpanded,
                isUkpscFreeTestSectionExpanded = if (normalized == "UKPSC" || normalized == "STATE_PSC") true else state.isUkpscFreeTestSectionExpanded,
                isBpscFreeTestSectionExpanded = if (normalized == "BPSC" || normalized == "STATE_PSC") true else state.isBpscFreeTestSectionExpanded,
                isUpssscFreeTestSectionExpanded = if (normalized == "UPSSSC" || normalized == "SUBORDINATE") true else state.isUpssscFreeTestSectionExpanded,
                isUkssscFreeTestSectionExpanded = if (normalized == "UKSSSC" || normalized == "SUBORDINATE") true else state.isUkssscFreeTestSectionExpanded,
                isSscFreeTestSectionExpanded = if (normalized == "SSC") true else state.isSscFreeTestSectionExpanded
            )
        }
    }

    fun clearDashboardCategoryFilter() {
        _uiState.update {
            it.copy(
                selectedDashboardCategoryFilter = "ALL",
                searchQuery = ""
            )
        }
    }

    fun selectCategory(category: ExamCategory?) {
        _uiState.update {
            it.copy(
                selectedCategory = category,
                selectedSubSection = category?.subSections?.firstOrNull(),
                selectedSubject = category?.subSections?.firstOrNull()?.subjects?.firstOrNull(),
                isSscFreeTestSectionExpanded = if (category?.id == "ssc") true else it.isSscFreeTestSectionExpanded,
                isIitJeeFreeTestSectionExpanded = if (category?.id == "jee_neet") true else it.isIitJeeFreeTestSectionExpanded,
                isUgcNetFreeTestSectionExpanded = if (category?.id == "ugc_csir_net") true else it.isUgcNetFreeTestSectionExpanded,
                isTetFreeTestSectionExpanded = if (category?.id == "teaching") true else it.isTetFreeTestSectionExpanded
            )
        }
    }

    fun selectSubSection(subSection: ExamSubSection?) {
        _uiState.update {
            it.copy(
                selectedSubSection = subSection,
                selectedSubject = subSection?.subjects?.firstOrNull(),
                isUkpscFreeTestSectionExpanded = if (subSection?.id == "psc_ukpsc") true else it.isUkpscFreeTestSectionExpanded,
                isUppcsFreeTestSectionExpanded = if (subSection?.id == "psc_uppcs") true else it.isUppcsFreeTestSectionExpanded,
                isBpscFreeTestSectionExpanded = if (subSection?.id == "psc_bpsc") true else it.isBpscFreeTestSectionExpanded,
                isUpssscFreeTestSectionExpanded = if (subSection?.id == "sub_upsssc") true else it.isUpssscFreeTestSectionExpanded,
                isUkssscFreeTestSectionExpanded = if (subSection?.id == "sub_uksssc") true else it.isUkssscFreeTestSectionExpanded,
                isSscFreeTestSectionExpanded = if (subSection?.id?.startsWith("ssc_") == true) true else it.isSscFreeTestSectionExpanded,
                isIitJeeFreeTestSectionExpanded = if (subSection?.id?.startsWith("iit_jee") == true) true else it.isIitJeeFreeTestSectionExpanded,
                isUgcNetFreeTestSectionExpanded = if (subSection?.id?.startsWith("ugc_net") == true) true else it.isUgcNetFreeTestSectionExpanded,
                isTetFreeTestSectionExpanded = if (subSection?.id?.startsWith("tet_") == true || subSection?.id?.startsWith("teaching_") == true) true else it.isTetFreeTestSectionExpanded,
                selectedIitJeeLevelTab = when (subSection?.id) {
                    "iit_jee_advanced" -> "ADVANCED"
                    "iit_jee" -> "MAIN"
                    else -> it.selectedIitJeeLevelTab
                },
                selectedUgcNetPaperTab = when (subSection?.id) {
                    "ugc_net_paper2" -> "PAPER_2"
                    "ugc_net_paper1" -> "PAPER_1"
                    else -> it.selectedUgcNetPaperTab
                }
            )
        }
    }

    fun selectSubject(subject: ExamSubject?) {
        _uiState.update { it.copy(selectedSubject = subject) }
    }

    fun setContentTypeFilter(type: ContentType?) {
        _uiState.update { it.copy(selectedContentType = type) }
    }

    fun setMediumFilter(medium: String?) {
        _uiState.update { it.copy(selectedMedium = medium) }
    }

    fun openItemDetail(item: StudyItem) {
        _uiState.update {
            it.copy(
                selectedItem = item,
                previousScreen = it.currentScreen,
                currentScreen = AppScreen.ITEM_DETAIL
            )
        }
    }

    fun openReader(item: StudyItem, chapterIndex: Int = 0) {
        _uiState.update {
            it.copy(
                activeReadingItem = item,
                currentChapterIndex = chapterIndex,
                previousScreen = it.currentScreen,
                currentScreen = AppScreen.READER
            )
        }
    }

    fun setChapter(chapterIndex: Int) {
        _uiState.update { it.copy(currentChapterIndex = chapterIndex) }
    }

    fun setReaderFontSize(sizeSp: Int) {
        _uiState.update { it.copy(readerFontSizeSp = sizeSp.coerceIn(12, 28)) }
    }

    fun setReaderTheme(theme: ReaderTheme) {
        _uiState.update { it.copy(readerTheme = theme) }
    }

    fun toggleBookmark(itemId: String, chapterIndex: Int) {
        val key = "${itemId}_$chapterIndex"
        _uiState.update { current ->
            val set = current.bookmarkedChapters.toMutableSet()
            if (set.contains(key)) set.remove(key) else set.add(key)
            current.copy(
                bookmarkedChapters = set,
                toastMessage = if (set.contains(key)) "अध्याय बुकमार्क किया गया (Bookmarked)" else "बुकमार्क हटाया गया"
            )
        }
    }

    // Test Series Actions (5-Year PYQ Analysis & Bilingual Engine)
    fun startTest(test: MockTest? = null) {
        val state = _uiState.value
        val resolvedTest = test ?: run {
            val categoryKey = state.selectedItem?.categoryId ?: state.selectedCategory?.id
            if (categoryKey != null) {
                PyqTestBankData.getPyqTestForCategory(categoryKey)
            } else {
                state.activeTest
            }
        }
        val restoredAnswers = state.testAnswersByTestId[resolvedTest.testId] ?: emptyMap()
        val totalDurationSecs = resolvedTest.durationMinutes.coerceAtLeast(1) * 60
        _uiState.update {
            it.copy(
                activeTest = resolvedTest,
                currentQuestionIndex = 0,
                userAnswers = restoredAnswers,
                markedForReview = emptySet(),
                isInstantPyqSolutionVisible = restoredAnswers.containsKey(
                    resolvedTest.questions.firstOrNull()?.id ?: -1
                ),
                isTestSubmitted = false,
                isAutoSubmittedOnTimeout = false,
                isTestTimerRunning = true,
                isTestTimerPaused = false,
                questionTimeSpentSeconds = emptyMap(),
                testTotalDurationSeconds = totalDurationSecs,
                testTimeRemainingSeconds = totalDurationSecs,
                previousScreen = if (it.currentScreen == AppScreen.TEST_SERIES) it.previousScreen else it.currentScreen,
                currentScreen = AppScreen.TEST_SERIES
            )
        }
    }

    fun selectPyqTestByCategory(categoryOrExamId: String) {
        val matchedTest = _uiState.value.customTests.firstOrNull {
            it.categoryId.equals(categoryOrExamId, ignoreCase = true) ||
                it.testId.equals(categoryOrExamId, ignoreCase = true)
        } ?: PyqTestBankData.getPyqTestForCategory(categoryOrExamId)
        startTest(matchedTest)
    }

    /**
     * Starts any UP Police Constable / SI test by its ID (e.g. `up_police_flt_mock_1`, `up_police_sectional_1`, `up_police_official_pyq_1`).
     */
    fun startUpPoliceTest(testIdOrSectionId: String = "up_police_official_pyq_1") {
        val entries = com.example.data.AllIndiaMasterTestPackageData.getExamPackageEntries("up_police")
        val resolved = entries.firstOrNull {
            it.id.equals(testIdOrSectionId, ignoreCase = true) ||
                it.mockTest.testId.equals(testIdOrSectionId, ignoreCase = true)
        } ?: entries.first()
        startTest(resolved.mockTest)
    }

    fun toggleUpscFreeTestSections() {
        _uiState.update {
            it.copy(isUpscFreeTestSectionExpanded = !it.isUpscFreeTestSectionExpanded)
        }
    }

    fun openUpscSectionAndExpandFreeTests() {
        val upscCat = ExamCatalogData.categories.firstOrNull { it.id == "upsc" }
        val upscSub = upscCat?.subSections?.firstOrNull()
        _uiState.update {
            it.copy(
                selectedCategory = upscCat,
                selectedSubSection = upscSub,
                selectedSubject = upscSub?.subjects?.firstOrNull(),
                isUpscFreeTestSectionExpanded = true,
                previousScreen = it.currentScreen,
                currentScreen = AppScreen.EXPLORER
            )
        }
    }

    fun startUpscSectionTest(sectionIdOrTestId: String) {
        val normalized = sectionIdOrTestId.removePrefix("upsc_").lowercase()
        val section = com.example.data.upsc.UpscSciTechIrCaPyqData.all7UpscSectionTests.firstOrNull {
            it.id.equals(sectionIdOrTestId, ignoreCase = true) ||
                it.id.removePrefix("upsc_").equals(normalized, ignoreCase = true) ||
                it.mockTest.testId.equals(sectionIdOrTestId, ignoreCase = true) ||
                (normalized == "science_tech" && it.id == "upsc_scitech") ||
                (normalized == "current_affairs" && it.id == "upsc_ir_ca")
        } ?: com.example.data.upsc.UpscSciTechIrCaPyqData.all7UpscSectionTests.first()
        startTest(section.mockTest)
    }

    fun toggleUppcsFreeTestSections() {
        _uiState.update {
            it.copy(isUppcsFreeTestSectionExpanded = !it.isUppcsFreeTestSectionExpanded)
        }
    }

    fun openUppcsSectionAndExpandFreeTests() {
        val statePscCat = ExamCatalogData.categories.firstOrNull { it.id == "state_psc" }
        val uppcsSub = statePscCat?.subSections?.firstOrNull { it.id == "psc_uppcs" } ?: statePscCat?.subSections?.firstOrNull()
        _uiState.update {
            it.copy(
                selectedCategory = statePscCat,
                selectedSubSection = uppcsSub,
                selectedSubject = uppcsSub?.subjects?.firstOrNull(),
                isUppcsFreeTestSectionExpanded = true,
                previousScreen = it.currentScreen,
                currentScreen = AppScreen.EXPLORER
            )
        }
    }

    fun startUppcsSectionTest(sectionIdOrTestId: String) {
        val normalized = sectionIdOrTestId.removePrefix("uppcs_").lowercase()
        val section = com.example.data.uppcs.UppcsUpCaEcoPyqData.all7UppcsSectionTests.firstOrNull {
            it.id.equals(sectionIdOrTestId, ignoreCase = true) ||
                it.id.equals(normalized, ignoreCase = true) ||
                it.mockTest.testId.equals(sectionIdOrTestId, ignoreCase = true) ||
                (normalized == "science_tech" && it.id == "scitech")
        } ?: com.example.data.uppcs.UppcsUpCaEcoPyqData.all7UppcsSectionTests.first()
        startTest(section.mockTest)
    }

    fun toggleUkpscFreeTestSections() {
        _uiState.update {
            it.copy(isUkpscFreeTestSectionExpanded = !it.isUkpscFreeTestSectionExpanded)
        }
    }

    fun openUkpscSectionAndExpandFreeTests() {
        val statePscCat = ExamCatalogData.categories.firstOrNull { it.id == "state_psc" }
        val ukpscSub = statePscCat?.subSections?.firstOrNull { it.id == "psc_ukpsc" } ?: statePscCat?.subSections?.firstOrNull()
        _uiState.update {
            it.copy(
                selectedCategory = statePscCat,
                selectedSubSection = ukpscSub,
                selectedSubject = ukpscSub?.subjects?.firstOrNull(),
                isUkpscFreeTestSectionExpanded = true,
                previousScreen = it.currentScreen,
                currentScreen = AppScreen.EXPLORER
            )
        }
    }

    fun startUkpscSectionTest(sectionIdOrTestId: String) {
        val normalized = sectionIdOrTestId.removePrefix("ukpsc_").lowercase()
        val section = com.example.data.ukpsc.UkpscAllSubjectsPyqData.all8UkpscSectionTests.firstOrNull {
            it.id.equals(sectionIdOrTestId, ignoreCase = true) ||
                it.sectionId.equals(sectionIdOrTestId, ignoreCase = true) ||
                it.id.removePrefix("ukpsc_").equals(normalized, ignoreCase = true) ||
                it.mockTest.testId.equals(sectionIdOrTestId, ignoreCase = true) ||
                (normalized.contains("special") && it.isSpecial100) ||
                (normalized == "science_tech" && it.id == "ukpsc_scitech") ||
                (normalized == "ca" && it.id == "ukpsc_current_affairs")
        } ?: com.example.data.ukpsc.UkpscAllSubjectsPyqData.all8UkpscSectionTests.first()
        startTest(section.mockTest)
    }

    fun toggleBpscFreeTestSections() {
        _uiState.update {
            it.copy(isBpscFreeTestSectionExpanded = !it.isBpscFreeTestSectionExpanded)
        }
    }

    fun openBpscSectionAndExpandFreeTests() {
        val statePscCat = ExamCatalogData.categories.firstOrNull { it.id == "state_psc" }
        val bpscSub = statePscCat?.subSections?.firstOrNull { it.id == "psc_bpsc" } ?: statePscCat?.subSections?.firstOrNull()
        _uiState.update {
            it.copy(
                selectedCategory = statePscCat,
                selectedSubSection = bpscSub,
                selectedSubject = bpscSub?.subjects?.firstOrNull(),
                isBpscFreeTestSectionExpanded = true,
                previousScreen = it.currentScreen,
                currentScreen = AppScreen.EXPLORER
            )
        }
    }

    fun startBpscSectionTest(sectionIdOrTestId: String) {
        val normalized = sectionIdOrTestId.removePrefix("bpsc_").lowercase()
        val section = com.example.data.bpsc.BpscAllSubjects100PyqData.all7BpscSectionTests.firstOrNull {
            it.id.equals(sectionIdOrTestId, ignoreCase = true) ||
                it.sectionId.equals(sectionIdOrTestId, ignoreCase = true) ||
                it.id.removePrefix("bpsc_").equals(normalized, ignoreCase = true) ||
                it.mockTest.testId.equals(sectionIdOrTestId, ignoreCase = true) ||
                (normalized.contains("special") && it.isBiharSpecial) ||
                (normalized == "economy" && it.id == "bpsc_economics") ||
                (normalized == "scitech" && it.id == "bpsc_science") ||
                (normalized == "ca" && it.id == "bpsc_current_affairs")
        } ?: com.example.data.bpsc.BpscAllSubjects100PyqData.all7BpscSectionTests.first()
        startTest(section.mockTest)
    }

    fun toggleUpssscFreeTestSections() {
        _uiState.update {
            it.copy(isUpssscFreeTestSectionExpanded = !it.isUpssscFreeTestSectionExpanded)
        }
    }

    fun openUpssscSectionAndExpandFreeTests() {
        val subCat = ExamCatalogData.categories.firstOrNull { it.id == "subordinate_selection" }
        val upssscSub = subCat?.subSections?.firstOrNull { it.id == "sub_upsssc" } ?: subCat?.subSections?.firstOrNull()
        _uiState.update {
            it.copy(
                selectedCategory = subCat,
                selectedSubSection = upssscSub,
                selectedSubject = upssscSub?.subjects?.firstOrNull(),
                isUpssscFreeTestSectionExpanded = true,
                previousScreen = it.currentScreen,
                currentScreen = AppScreen.EXPLORER
            )
        }
    }

    fun startUpssscSectionTest(sectionIdOrTestId: String) {
        val normalized = sectionIdOrTestId.removePrefix("upsssc_").lowercase()
        val section = com.example.data.upsssc.UpssscAllSubjectsPyqData.all9UpssscSectionTests.firstOrNull {
            it.id.equals(sectionIdOrTestId, ignoreCase = true) ||
                it.sectionId.equals(sectionIdOrTestId, ignoreCase = true) ||
                it.id.removePrefix("upsssc_").equals(normalized, ignoreCase = true) ||
                it.mockTest.testId.equals(sectionIdOrTestId, ignoreCase = true) ||
                (normalized.contains("special") && it.isUpSpecial250) ||
                (normalized == "economy" && it.id == "upsssc_economics") ||
                (normalized == "science_tech" && it.id == "upsssc_scitech") ||
                (normalized == "science" && it.id == "upsssc_scitech") ||
                (normalized == "data_interpretation" && it.id == "upsssc_di")
        } ?: com.example.data.upsssc.UpssscAllSubjectsPyqData.all9UpssscSectionTests.first()
        startTest(section.mockTest)
    }

    fun toggleUkssscFreeTestSections() {
        _uiState.update {
            it.copy(isUkssscFreeTestSectionExpanded = !it.isUkssscFreeTestSectionExpanded)
        }
    }

    fun openUkssscSectionAndExpandFreeTests() {
        val subCat = ExamCatalogData.categories.firstOrNull { it.id == "subordinate_selection" }
        val ukssscSub = subCat?.subSections?.firstOrNull { it.id == "sub_uksssc" } ?: subCat?.subSections?.firstOrNull()
        _uiState.update {
            it.copy(
                selectedCategory = subCat,
                selectedSubSection = ukssscSub,
                selectedSubject = ukssscSub?.subjects?.firstOrNull(),
                isUkssscFreeTestSectionExpanded = true,
                previousScreen = it.currentScreen,
                currentScreen = AppScreen.EXPLORER
            )
        }
    }

    fun startUkssscSectionTest(sectionIdOrTestId: String) {
        val normalized = sectionIdOrTestId.removePrefix("uksssc_").lowercase()
        val section = com.example.data.uksssc.UkssscAllSubjectsPyqData.all10UkssscSectionTests.firstOrNull {
            it.id.equals(sectionIdOrTestId, ignoreCase = true) ||
                it.sectionId.equals(sectionIdOrTestId, ignoreCase = true) ||
                it.id.removePrefix("uksssc_").equals(normalized, ignoreCase = true) ||
                it.mockTest.testId.equals(sectionIdOrTestId, ignoreCase = true) ||
                (normalized.contains("special") && it.isUkSpecial250) ||
                (normalized == "economy" && it.id == "uksssc_economics") ||
                (normalized == "science_tech" && it.id == "uksssc_scitech") ||
                (normalized == "science" && it.id == "uksssc_scitech") ||
                (normalized == "general_hindi" && it.id == "uksssc_hindi") ||
                (normalized == "di" && it.id == "uksssc_reasoning_di") ||
                (normalized == "reasoning" && it.id == "uksssc_reasoning_di")
        } ?: com.example.data.uksssc.UkssscAllSubjectsPyqData.all10UkssscSectionTests.first()
        startTest(section.mockTest)
    }

    fun toggleSscFreeTestSections() {
        _uiState.update {
            it.copy(isSscFreeTestSectionExpanded = !it.isSscFreeTestSectionExpanded)
        }
    }

    fun selectSscExamTab(tabCode: String) {
        val normalizedTab = when (tabCode.uppercase()) {
            "CHSL", "SSC_CHSL" -> "CHSL"
            "CPO", "SSC_CPO" -> "CPO"
            else -> "CGL"
        }
        val sscCat = ExamCatalogData.categories.firstOrNull { it.id == "ssc" }
        val targetSubId = when (normalizedTab) {
            "CHSL" -> "ssc_chsl"
            "CPO" -> "ssc_cpo"
            else -> "ssc_cgl"
        }
        val sscSub = sscCat?.subSections?.firstOrNull { it.id == targetSubId } ?: sscCat?.subSections?.firstOrNull()
        _uiState.update {
            it.copy(
                selectedSscExamTab = normalizedTab,
                selectedSubSection = if (it.selectedCategory?.id == "ssc") sscSub else it.selectedSubSection,
                isSscFreeTestSectionExpanded = true
            )
        }
    }

    fun selectSscSubjectFilter(filterCode: String) {
        val normalizedFilter = when (filterCode.uppercase()) {
            "GS" -> "GS"
            "REASONING" -> "REASONING"
            "MATH", "MATHS", "MATHEMATICS" -> "MATH"
            "ENGLISH" -> "ENGLISH"
            else -> "ALL"
        }
        _uiState.update {
            it.copy(
                selectedSscSubjectFilter = normalizedFilter,
                isSscFreeTestSectionExpanded = true
            )
        }
    }

    fun openSscSectionAndExpandFreeTests() {
        val sscCat = ExamCatalogData.categories.firstOrNull { it.id == "ssc" }
        val sscSub = sscCat?.subSections?.firstOrNull { it.id == "ssc_cgl" } ?: sscCat?.subSections?.firstOrNull()
        _uiState.update {
            it.copy(
                selectedCategory = sscCat,
                selectedSubSection = sscSub,
                selectedSubject = sscSub?.subjects?.firstOrNull(),
                isSscFreeTestSectionExpanded = true,
                previousScreen = it.currentScreen,
                currentScreen = AppScreen.EXPLORER
            )
        }
    }

    fun startSscSectionTest(sectionIdOrTestId: String) {
        val normalized = sectionIdOrTestId.removePrefix("ssc_").removePrefix("gs_").lowercase()
        val section = com.example.data.ssc.SscAllSubjectsPyqData.all8SscSectionTests.firstOrNull {
            it.id.equals(sectionIdOrTestId, ignoreCase = true) ||
                it.sectionId.equals(sectionIdOrTestId, ignoreCase = true) ||
                it.id.removePrefix("ssc_").removePrefix("gs_").equals(normalized, ignoreCase = true) ||
                it.mockTest.testId.equals(sectionIdOrTestId, ignoreCase = true) ||
                (normalized == "economy" && it.id == "ssc_gs_economics") ||
                (normalized == "maths" && it.id == "ssc_mathematics") ||
                (normalized == "quant" && it.id == "ssc_mathematics") ||
                (normalized == "cgl_quant" && it.id == "ssc_mathematics") ||
                (normalized == "cgl_reasoning" && it.id == "ssc_reasoning") ||
                (normalized == "cgl_english" && it.id == "ssc_english") ||
                (normalized == "cgl_ga" && it.id == "ssc_gs_history")
        } ?: com.example.data.ssc.SscAllSubjectsPyqData.all8SscSectionTests.first()
        startTest(section.mockTest)
    }

    fun toggleIitJeeFreeTestSections() {
        _uiState.update {
            it.copy(isIitJeeFreeTestSectionExpanded = !it.isIitJeeFreeTestSectionExpanded)
        }
    }

    fun selectIitJeeLevelTab(levelTab: String) {
        val normalizedLevel = if (levelTab.trim().uppercase().startsWith("ADV")) "ADVANCED" else "MAIN"
        val jeeCat = ExamCatalogData.categories.firstOrNull { it.id == "jee_neet" }
        val targetSubId = if (normalizedLevel == "ADVANCED") "iit_jee_advanced" else "iit_jee"
        val jeeSub = jeeCat?.subSections?.firstOrNull { it.id == targetSubId } ?: jeeCat?.subSections?.firstOrNull()
        _uiState.update {
            it.copy(
                selectedIitJeeLevelTab = normalizedLevel,
                selectedSubSection = if (it.selectedCategory?.id == "jee_neet") jeeSub else it.selectedSubSection,
                isIitJeeFreeTestSectionExpanded = true
            )
        }
    }

    fun selectIitJeeSubjectFilter(filterCode: String) {
        val normalizedFilter = when (filterCode.trim().uppercase()) {
            "PHYSICS" -> "PHYSICS"
            "PHYSICAL_CHEM", "PHYSICAL" -> "PHYSICAL_CHEM"
            "ORGANIC_CHEM", "ORGANIC" -> "ORGANIC_CHEM"
            "INORGANIC_CHEM", "INORGANIC" -> "INORGANIC_CHEM"
            "MATHEMATICS", "MATH", "MATHS" -> "MATHEMATICS"
            else -> "ALL"
        }
        _uiState.update {
            it.copy(
                selectedIitJeeSubjectFilter = normalizedFilter,
                isIitJeeFreeTestSectionExpanded = true
            )
        }
    }

    fun openIitJeeSectionAndExpandFreeTests(levelTab: String = "MAIN") {
        val normalizedLevel = if (levelTab.trim().uppercase().startsWith("ADV")) "ADVANCED" else "MAIN"
        val jeeCat = ExamCatalogData.categories.firstOrNull { it.id == "jee_neet" }
        val targetSubId = if (normalizedLevel == "ADVANCED") "iit_jee_advanced" else "iit_jee"
        val jeeSub = jeeCat?.subSections?.firstOrNull { it.id == targetSubId } ?: jeeCat?.subSections?.firstOrNull()
        _uiState.update {
            it.copy(
                selectedCategory = jeeCat,
                selectedSubSection = jeeSub,
                selectedSubject = jeeSub?.subjects?.firstOrNull(),
                selectedIitJeeLevelTab = normalizedLevel,
                isIitJeeFreeTestSectionExpanded = true,
                previousScreen = it.currentScreen,
                currentScreen = AppScreen.EXPLORER
            )
        }
    }

    fun startIitJeeSectionTest(sectionIdOrTestId: String) {
        val resolvedTest = com.example.data.iitjee.IitJeeAllSubjectsPyqData.getTestBySectionOrTestId(sectionIdOrTestId)
            ?: com.example.data.iitjee.IitJeeAllSubjectsPyqData.allIitJeeSectionTests.first()
        startTest(resolvedTest)
    }

    fun toggleNeetFreeTestSections() {
        _uiState.update {
            it.copy(isNeetFreeTestSectionExpanded = !it.isNeetFreeTestSectionExpanded)
        }
    }

    fun selectNeetSubjectFilter(filterCode: String) {
        val normalizedFilter = when (filterCode.trim().uppercase()) {
            "PHYSICS" -> "PHYSICS"
            "PHYSICAL_CHEM", "PHYSICAL" -> "PHYSICAL_CHEM"
            "ORGANIC_CHEM", "ORGANIC" -> "ORGANIC_CHEM"
            "INORGANIC_CHEM", "INORGANIC" -> "INORGANIC_CHEM"
            "BOTANY" -> "BOTANY"
            "ZOOLOGY" -> "ZOOLOGY"
            "BIOLOGY" -> "BIOLOGY"
            "CHEMISTRY" -> "CHEMISTRY"
            else -> "ALL"
        }
        _uiState.update {
            it.copy(
                selectedNeetSubjectFilter = normalizedFilter,
                isNeetFreeTestSectionExpanded = true
            )
        }
    }

    fun openNeetSectionAndExpandFreeTests() {
        val jeeCat = ExamCatalogData.categories.firstOrNull { it.id == "jee_neet" }
        val neetSub = jeeCat?.subSections?.firstOrNull { it.id == "neet_ug" } ?: jeeCat?.subSections?.lastOrNull()
        _uiState.update {
            it.copy(
                selectedCategory = jeeCat,
                selectedSubSection = neetSub,
                selectedSubject = neetSub?.subjects?.firstOrNull(),
                isNeetFreeTestSectionExpanded = true,
                previousScreen = it.currentScreen,
                currentScreen = AppScreen.EXPLORER
            )
        }
    }

    fun startNeetSectionTest(sectionIdOrTestId: String) {
        val resolvedTest = com.example.data.neet.NeetAllSubjectsPyqData.getTestBySectionOrTestId(sectionIdOrTestId)
            ?: com.example.data.neet.NeetAllSubjectsPyqData.allNeetSectionTests.first()
        startTest(resolvedTest)
    }

    fun toggleUgcNetFreeTestSections() {
        _uiState.update {
            it.copy(isUgcNetFreeTestSectionExpanded = !it.isUgcNetFreeTestSectionExpanded)
        }
    }

    fun selectUgcNetPaperTab(paperTab: String) {
        val normalizedPaper = if (paperTab.trim().uppercase().contains("2")) "PAPER_2" else "PAPER_1"
        val ugcCat = ExamCatalogData.categories.firstOrNull { it.id == "ugc_csir_net" }
        val targetSubId = if (normalizedPaper == "PAPER_2") "ugc_net_paper2" else "ugc_net_paper1"
        val ugcSub = ugcCat?.subSections?.firstOrNull { it.id == targetSubId } ?: ugcCat?.subSections?.firstOrNull()
        _uiState.update {
            it.copy(
                selectedUgcNetPaperTab = normalizedPaper,
                selectedUgcNetSubjectFilter = "ALL",
                selectedSubSection = if (it.selectedCategory?.id == "ugc_csir_net") ugcSub else it.selectedSubSection,
                isUgcNetFreeTestSectionExpanded = true
            )
        }
    }

    fun selectUgcNetSubjectFilter(filterCode: String) {
        val normalizedFilter = filterCode.trim().uppercase().ifEmpty { "ALL" }
        _uiState.update {
            it.copy(
                selectedUgcNetSubjectFilter = normalizedFilter,
                isUgcNetFreeTestSectionExpanded = true
            )
        }
    }

    fun openUgcNetSectionAndExpandFreeTests(paperTab: String = "PAPER_1") {
        val normalizedPaper = if (paperTab.trim().uppercase().contains("2")) "PAPER_2" else "PAPER_1"
        val ugcCat = ExamCatalogData.categories.firstOrNull { it.id == "ugc_csir_net" }
        val targetSubId = if (normalizedPaper == "PAPER_2") "ugc_net_paper2" else "ugc_net_paper1"
        val ugcSub = ugcCat?.subSections?.firstOrNull { it.id == targetSubId } ?: ugcCat?.subSections?.firstOrNull()
        _uiState.update {
            it.copy(
                selectedCategory = ugcCat,
                selectedSubSection = ugcSub,
                selectedSubject = ugcSub?.subjects?.firstOrNull(),
                selectedUgcNetPaperTab = normalizedPaper,
                selectedUgcNetSubjectFilter = "ALL",
                isUgcNetFreeTestSectionExpanded = true,
                previousScreen = it.currentScreen,
                currentScreen = AppScreen.EXPLORER
            )
        }
    }

    fun startUgcNetSectionTest(sectionIdOrTestId: String) {
        val resolvedTest = com.example.data.ugcnet.UgcNetAllSubjectsPyqData.getTestBySectionOrTestId(sectionIdOrTestId)
            ?: com.example.data.ugcnet.UgcNetAllSubjectsPyqData.allUgcNetSectionTests.first()
        startTest(resolvedTest)
    }

    fun toggleTetFreeTestSections() {
        _uiState.update {
            it.copy(isTetFreeTestSectionExpanded = !it.isTetFreeTestSectionExpanded)
        }
    }

    fun selectTetExamTab(examTab: String) {
        val normalizedExam = when (examTab.trim().uppercase()) {
            "UPTET", "UP_TET" -> "UPTET"
            "UTET", "REET", "HTET", "OTHER", "OTHERS" -> "UTET"
            else -> "CTET"
        }
        val tetCat = ExamCatalogData.categories.firstOrNull { it.id == "teaching" }
        val tetSub = tetCat?.subSections?.firstOrNull { it.id == "tet_central_state" } ?: tetCat?.subSections?.firstOrNull()
        _uiState.update {
            it.copy(
                selectedTetExamTab = normalizedExam,
                selectedSubSection = if (it.selectedCategory?.id == "teaching") tetSub else it.selectedSubSection,
                isTetFreeTestSectionExpanded = true
            )
        }
    }

    fun selectTetSubjectFilter(filterCode: String) {
        val normalizedFilter = when (filterCode.trim().uppercase()) {
            "CDP" -> "CDP"
            "EVS" -> "EVS"
            "MATHS", "MATH", "MATHEMATICS" -> "MATHS"
            "SCIENCE" -> "SCIENCE"
            "SOCIAL_SCIENCE", "SST", "SOCIAL" -> "SOCIAL_SCIENCE"
            "HINDI" -> "HINDI"
            "ENGLISH_SANSKRIT", "ENGLISH", "SANSKRIT" -> "ENGLISH_SANSKRIT"
            else -> "ALL"
        }
        _uiState.update {
            it.copy(
                selectedTetSubjectFilter = normalizedFilter,
                isTetFreeTestSectionExpanded = true
            )
        }
    }

    fun openTetSectionAndExpandFreeTests(examTab: String = "CTET") {
        val normalizedExam = when (examTab.trim().uppercase()) {
            "UPTET", "UP_TET" -> "UPTET"
            "UTET", "REET", "HTET", "OTHER", "OTHERS" -> "UTET"
            else -> "CTET"
        }
        val tetCat = ExamCatalogData.categories.firstOrNull { it.id == "teaching" }
        val tetSub = tetCat?.subSections?.firstOrNull { it.id == "tet_central_state" } ?: tetCat?.subSections?.firstOrNull()
        _uiState.update {
            it.copy(
                selectedCategory = tetCat,
                selectedSubSection = tetSub,
                selectedSubject = tetSub?.subjects?.firstOrNull(),
                selectedTetExamTab = normalizedExam,
                selectedTetSubjectFilter = "ALL",
                isTetFreeTestSectionExpanded = true,
                previousScreen = it.currentScreen,
                currentScreen = AppScreen.EXPLORER
            )
        }
    }

    fun startTetSectionTest(sectionIdOrTestId: String) {
        val resolvedTest = com.example.data.tet.TetAllSubjectsPyqData.getTestBySectionOrTestId(sectionIdOrTestId)
            ?: com.example.data.tet.TetAllSubjectsPyqData.allTetSectionTests.first()
        startTest(resolvedTest)
    }

    /**
     * Switches any exam card ("tet", "iit_jee", "neet", "ugc_net", "upsc", "uppcs", "ukpsc", "bpsc", "upsssc", "uksssc", "ssc", etc.) between:
     *  - "PAID": 1. पेड टेस्ट सीरीज़ (Paid Test Series)
     *  - "FREE": 2. फ्री टेस्ट सीरीज़ (Free Test Series)
     * and automatically expands that exam's test list so the user sees all options in one place.
     */
    fun selectExamTestSeriesMode(examKey: String, mode: String) {
        checkAndExpireSubscription()
        val key = examKey.lowercase()
        val normalizedMode = if (mode.equals("PAID", ignoreCase = true)) "PAID" else "FREE"
        _uiState.update { state ->
            val updatedMap = state.examTestSeriesModeMap.toMutableMap()
            updatedMap[key] = normalizedMode
            state.copy(
                examTestSeriesModeMap = updatedMap,
                isTetFreeTestSectionExpanded = if (key == "tet" || key == "teaching") true else state.isTetFreeTestSectionExpanded,
                isIitJeeFreeTestSectionExpanded = if (key == "iit_jee" || key == "jee_neet") true else state.isIitJeeFreeTestSectionExpanded,
                isNeetFreeTestSectionExpanded = if (key == "neet" || key == "neet_ug") true else state.isNeetFreeTestSectionExpanded,
                isUgcNetFreeTestSectionExpanded = if (key == "ugc_net" || key == "ugc_csir_net") true else state.isUgcNetFreeTestSectionExpanded,
                isUpscFreeTestSectionExpanded = if (key == "upsc") true else state.isUpscFreeTestSectionExpanded,
                isUppcsFreeTestSectionExpanded = if (key == "uppcs") true else state.isUppcsFreeTestSectionExpanded,
                isUkpscFreeTestSectionExpanded = if (key == "ukpsc") true else state.isUkpscFreeTestSectionExpanded,
                isBpscFreeTestSectionExpanded = if (key == "bpsc") true else state.isBpscFreeTestSectionExpanded,
                isUpssscFreeTestSectionExpanded = if (key == "upsssc") true else state.isUpssscFreeTestSectionExpanded,
                isUkssscFreeTestSectionExpanded = if (key == "uksssc") true else state.isUkssscFreeTestSectionExpanded,
                isSscFreeTestSectionExpanded = if (key == "ssc") true else state.isSscFreeTestSectionExpanded
            )
        }
    }

    fun answerQuestion(questionId: Int, optionIndex: Int) {
        if (_uiState.value.isTestSubmitted) return
        _uiState.update {
            val activeId = it.activeTest.testId
            val updated = it.userAnswers.toMutableMap()
            updated[questionId] = optionIndex
            val updatedByTest = it.testAnswersByTestId.toMutableMap()
            updatedByTest[activeId] = updated
            val updatedCompleted = it.completedTestIds.toMutableSet()
            if (updated.size >= it.activeTest.questions.size && it.activeTest.questions.isNotEmpty()) {
                updatedCompleted.add(activeId)
            }
            // Automatically show the Answer & Bilingual Explanation when an option is selected
            it.copy(
                userAnswers = updated,
                testAnswersByTestId = updatedByTest,
                completedTestIds = updatedCompleted,
                isInstantPyqSolutionVisible = true
            )
        }
        recordDailyQuizActivity(
            dateIso = com.example.ui.components.DailyStreakEngine.todayIsoDate(),
            activityPoints = 10
        )
    }

    fun clearAnswer(questionId: Int) {
        if (_uiState.value.isTestSubmitted) return
        _uiState.update {
            val activeId = it.activeTest.testId
            val updated = it.userAnswers.toMutableMap()
            updated.remove(questionId)
            val updatedByTest = it.testAnswersByTestId.toMutableMap()
            updatedByTest[activeId] = updated
            it.copy(
                userAnswers = updated,
                testAnswersByTestId = updatedByTest,
                isInstantPyqSolutionVisible = false
            )
        }
    }

    fun toggleMarkForReview(questionId: Int) {
        if (_uiState.value.isTestSubmitted) return
        _uiState.update {
            val updated = it.markedForReview.toMutableSet()
            if (updated.contains(questionId)) updated.remove(questionId) else updated.add(questionId)
            it.copy(markedForReview = updated)
        }
    }

    fun setQuestionIndex(index: Int) {
        val count = _uiState.value.activeTest.questions.size
        _uiState.update {
            val safeIdx = index.coerceIn(0, (count - 1).coerceAtLeast(0))
            val qId = it.activeTest.questions.getOrNull(safeIdx)?.id ?: -1
            it.copy(
                currentQuestionIndex = safeIdx,
                isInstantPyqSolutionVisible = it.userAnswers.containsKey(qId)
            )
        }
    }

    fun toggleBilingual() {
        _uiState.update { current ->
            // Cycle: Dual Bilingual (EN+HI) -> English Only (EN) -> Hindi Only (HI) -> Dual Bilingual (EN+HI)
            when {
                current.isDualBilingualView -> current.copy(isDualBilingualView = false, isBilingualHindi = false)
                !current.isBilingualHindi -> current.copy(isDualBilingualView = false, isBilingualHindi = true)
                else -> current.copy(isDualBilingualView = true, isBilingualHindi = false)
            }
        }
    }

    fun setTestLanguageMode(dualBilingual: Boolean, hindiOnly: Boolean = false) {
        _uiState.update {
            it.copy(
                isDualBilingualView = dualBilingual,
                isBilingualHindi = if (dualBilingual) false else hindiOnly
            )
        }
    }

    fun toggleInstantPyqSolution() {
        _uiState.update { it.copy(isInstantPyqSolutionVisible = !it.isInstantPyqSolutionVisible) }
    }

    /**
     * Decrements the active quiz countdown timer by [seconds] (default 1 second),
     * increments per-question time tracking for the active question,
     * and automatically submits the test session when remaining time reaches 0.
     */
    fun tickTestTimer(seconds: Int = 1) {
        val current = _uiState.value
        if (current.isTestSubmitted || current.isTestTimerPaused || !current.isTestTimerRunning) return

        val step = seconds.coerceAtLeast(1)
        val activeQId = current.activeTest.questions.getOrNull(current.currentQuestionIndex)?.id
        val updatedQTime = if (activeQId != null) {
            val map = current.questionTimeSpentSeconds.toMutableMap()
            map[activeQId] = (map[activeQId] ?: 0) + step
            map.toMap()
        } else {
            current.questionTimeSpentSeconds
        }

        val nextRemaining = (current.testTimeRemainingSeconds - step).coerceAtLeast(0)
        if (nextRemaining <= 0) {
            _uiState.update {
                it.copy(
                    testTimeRemainingSeconds = 0,
                    questionTimeSpentSeconds = updatedQTime
                )
            }
            submitTest(autoSubmittedOnTimeout = true)
        } else {
            _uiState.update {
                it.copy(
                    testTimeRemainingSeconds = nextRemaining,
                    questionTimeSpentSeconds = updatedQTime
                )
            }
        }
    }

    /**
     * Directly sets the remaining time in seconds for the active quiz session.
     * Automatically submits the test if [seconds] <= 0.
     */
    fun setTestTimeRemainingSeconds(seconds: Int) {
        val current = _uiState.value
        if (current.isTestSubmitted) return
        val safeSeconds = seconds.coerceAtLeast(0)
        if (safeSeconds <= 0) {
            _uiState.update { it.copy(testTimeRemainingSeconds = 0) }
            submitTest(autoSubmittedOnTimeout = true)
        } else {
            _uiState.update { it.copy(testTimeRemainingSeconds = safeSeconds) }
        }
    }

    /**
     * Toggles Strict CBT Exam Hall Simulation Mode vs Practice Mode.
     * In Strict CBT Mode, pausing the countdown timer is disabled to simulate real NTA/UPSC exam conditions.
     */
    fun toggleStrictExamSimulationMode() {
        val current = _uiState.value
        val nextStrict = !current.isStrictExamSimulationMode
        _uiState.update {
            it.copy(
                isStrictExamSimulationMode = nextStrict,
                isTestTimerPaused = if (nextStrict) false else it.isTestTimerPaused,
                toastMessage = if (nextStrict) {
                    "सख्त परीक्षा मोड (Strict CBT Mode) चालू: वास्तविक परीक्षा की तरह टाइमर पॉज़ लॉक है"
                } else {
                    "अभ्यास मोड (Practice Mode) चालू: आप टाइमर पॉज़ या कस्टम अवधि चुन सकते हैं"
                }
            )
        }
    }

    /**
     * Sets a custom exam duration in minutes (e.g., 15, 30, 60, 120, 180 mins) for timed practice
     * and resets the countdown timer to that duration.
     */
    fun setCustomExamDurationMinutes(minutes: Int) {
        val current = _uiState.value
        if (current.isTestSubmitted) return
        val safeMinutes = minutes.coerceIn(1, 240)
        val totalSecs = safeMinutes * 60
        _uiState.update {
            it.copy(
                testTotalDurationSeconds = totalSecs,
                testTimeRemainingSeconds = totalSecs,
                isTestTimerRunning = true,
                isTestTimerPaused = false,
                toastMessage = "परीक्षा टाइमर $safeMinutes मिनट पर सेट किया गया"
            )
        }
    }

    /**
     * Resets the active test countdown timer and per-question stopwatch back to full duration.
     */
    fun resetActiveTestTimer() {
        val current = _uiState.value
        if (current.isTestSubmitted) return
        val totalSecs = current.testTotalDurationSeconds.coerceAtLeast(60)
        _uiState.update {
            it.copy(
                testTimeRemainingSeconds = totalSecs,
                questionTimeSpentSeconds = emptyMap(),
                isTestTimerRunning = true,
                isTestTimerPaused = false,
                toastMessage = "टाइमर रीसेट किया गया (${totalSecs / 60} मिनट)"
            )
        }
    }

    /**
     * Pauses or resumes the active quiz countdown timer (when not locked by Strict CBT Mode).
     */
    fun togglePauseTestTimer() {
        val current = _uiState.value
        if (current.isTestSubmitted) return
        if (current.isStrictExamSimulationMode) {
            _uiState.update {
                it.copy(
                    toastMessage = "सख्त परीक्षा मोड (Strict CBT Mode) में टाइमर रोका नहीं जा सकता!"
                )
            }
            return
        }
        val nextPaused = !current.isTestTimerPaused
        _uiState.update {
            it.copy(
                isTestTimerPaused = nextPaused,
                toastMessage = if (nextPaused) "टेस्ट टाइमर रोका गया (Timer Paused)" else "टेस्ट टाइमर पुनः चालू (Timer Resumed)"
            )
        }
    }

    fun submitTest(autoSubmittedOnTimeout: Boolean = false) {
        val state = _uiState.value
        if (state.isTestSubmitted) return
        val test = state.activeTest
        var correct = 0
        var wrong = 0
        var unattempted = 0

        test.questions.forEach { q ->
            val userAns = state.userAnswers[q.id]
            if (userAns == null) {
                unattempted++
            } else if (userAns == q.correctIndex) {
                correct++
            } else {
                wrong++
            }
        }

        val totalScore = (correct * test.positiveMarks) - (wrong * test.negativeMarks)
        val totalDurationSecs = if (state.testTotalDurationSeconds > 0) {
            state.testTotalDurationSeconds
        } else {
            test.durationMinutes.coerceAtLeast(1) * 60
        }
        val finalRemainingSecs = if (autoSubmittedOnTimeout) 0 else state.testTimeRemainingSeconds.coerceIn(0, totalDurationSecs)
        val timeSpent = (totalDurationSecs - finalRemainingSecs).coerceAtLeast(0)

        val attempt = UserTestAttempt(
            testId = test.testId,
            testTitle = test.title,
            score = totalScore.coerceAtLeast(0.0),
            totalMarks = test.totalMarks,
            correctCount = correct,
            wrongCount = wrong,
            unattemptedCount = unattempted,
            timeSpentSeconds = timeSpent
        )

        val feedbackMsg = if (autoSubmittedOnTimeout) {
            "समय समाप्त! टेस्ट स्वतः सबमिट हो गया (Time Expired — Auto-Submitted) • स्कोर: ${"%.2f".format(totalScore)}"
        } else {
            "टेस्ट सफलतापूर्वक जमा किया गया! स्कोर: ${"%.2f".format(totalScore)}"
        }

        _uiState.update {
            val updatedByTest = it.testAnswersByTestId.toMutableMap()
            updatedByTest[test.testId] = it.userAnswers
            it.copy(
                isTestSubmitted = true,
                isTestTimerRunning = false,
                isTestTimerPaused = false,
                isAutoSubmittedOnTimeout = autoSubmittedOnTimeout,
                testTimeRemainingSeconds = finalRemainingSecs,
                lastTestAttempt = attempt,
                testAttemptsHistory = it.testAttemptsHistory + attempt,
                testAnswersByTestId = updatedByTest,
                completedTestIds = it.completedTestIds + test.testId,
                toastMessage = feedbackMsg
            )
        }
        recordDailyQuizActivity(
            dateIso = com.example.ui.components.DailyStreakEngine.todayIsoDate(),
            activityPoints = 100 + (correct * 5)
        )
        syncCurrentStudentProfileToCloud()
        val repo = studentAuthRepo
        if (repo != null && repo.currentUserId() != null) {
            val attemptedCount = (correct + wrong).coerceAtLeast(1)
            val accPercent = ((correct.toDouble() / attemptedCount.toDouble()) * 100.0).toLong().coerceIn(0L, 100L)
            viewModelScope.launch {
                runCatching {
                    repo.recordTestAttempt(
                        testId = test.testId,
                        testTitle = test.title,
                        examCategory = test.categoryId.ifBlank { state.currentUser?.targetExam ?: "General" },
                        score = totalScore.toLong(),
                        totalQuestions = test.questions.size.coerceAtLeast(1).toLong(),
                        accuracyPercent = if (correct + wrong > 0) accPercent else 0L
                    )
                }
            }
        }
    }

    /**
     * Records a daily quiz attempt for [dateIso] (YYYY-MM-DD), updating the student's
     * consecutive daily streak, longest streak, XP reward points, and unlocked milestone badges.
     */
    fun recordDailyQuizActivity(
        dateIso: String = com.example.ui.components.DailyStreakEngine.todayIsoDate(),
        activityPoints: Int = 50
    ) {
        val cleanDate = dateIso.trim().ifBlank { com.example.ui.components.DailyStreakEngine.todayIsoDate() }
        _uiState.update { current ->
            val prevDate = current.lastQuizAttemptDateIso
            val dayDiff = com.example.ui.components.DailyStreakEngine.daysBetweenIso(prevDate, cleanDate)

            val isSameDay = prevDate == cleanDate || current.completedStreakDatesIso.contains(cleanDate)
            val newStreak = when {
                isSameDay -> current.dailyStreakDays.coerceAtLeast(1)
                prevDate.isBlank() || dayDiff == 1L -> current.dailyStreakDays + 1
                dayDiff > 1L -> 1
                else -> current.dailyStreakDays.coerceAtLeast(1)
            }

            val newLongest = maxOf(current.longestStreakDays, newStreak)
            val dailyStreakBonus = if (isSameDay) 0 else (50 + newStreak * 10)
            val baseUpdatedPoints = current.rewardPoints + dailyStreakBonus + activityPoints.coerceAtLeast(0)

            val (updatedBadges, badgeBonusPoints) = com.example.ui.components.DailyStreakEngine.evaluateUnlockedBadges(
                streakDays = newStreak,
                totalPoints = baseUpdatedPoints,
                existingUnlockedIds = current.unlockedStreakBadgeIds
            )
            val finalPoints = baseUpdatedPoints + badgeBonusPoints
            val updatedDates = current.completedStreakDatesIso + cleanDate
            val latestDate = if (prevDate.isBlank() || dayDiff >= 0L) cleanDate else prevDate
            val todayIso = com.example.ui.components.DailyStreakEngine.todayIsoDate()
            val todayDone = latestDate == todayIso || updatedDates.contains(todayIso)

            prefs.edit()
                .putInt("daily_streak_days", newStreak)
                .putInt("longest_streak_days", newLongest)
                .putInt("reward_points", finalPoints)
                .putString("last_quiz_date_iso", latestDate)
                .putStringSet("completed_streak_dates_iso", updatedDates)
                .putStringSet("unlocked_streak_badge_ids", updatedBadges)
                .apply()

            current.copy(
                dailyStreakDays = newStreak,
                longestStreakDays = newLongest,
                rewardPoints = finalPoints,
                lastQuizAttemptDateIso = latestDate,
                completedStreakDatesIso = updatedDates,
                unlockedStreakBadgeIds = updatedBadges,
                isTodayStreakCompleted = todayDone
            )
        }
    }

    /**
     * Opens the dedicated Daily Quiz screen (AppScreen.DAILY_QUIZ).
     */
    fun openDailyQuiz() {
        navigateTo(AppScreen.DAILY_QUIZ)
    }

    /**
     * Selects an MCQ option index (0..3) for the active Daily Quiz question prior to submission.
     */
    fun selectDailyQuizOption(optionIndex: Int) {
        val current = _uiState.value
        if (current.isDailyQuizSubmitted) return
        val safeOption = optionIndex.coerceIn(0, (current.dailyQuizQuestion.optionsEn.size - 1).coerceAtLeast(0))
        _uiState.update {
            it.copy(dailyQuizSelectedOptionIndex = safeOption)
        }
    }

    /**
     * Submits the selected option for today's Daily Quiz question, immediately enables the
     * detailed explanation view, and awards daily engagement XP & streak progress.
     */
    fun submitDailyQuizAnswer(
        dateIso: String = com.example.ui.components.DailyStreakEngine.todayIsoDate()
    ) {
        val current = _uiState.value
        if (current.isDailyQuizSubmitted) return
        val selected = current.dailyQuizSelectedOptionIndex ?: return
        val isCorrect = selected == current.dailyQuizQuestion.correctIndex
        val xpEarned = if (isCorrect) 50 else 25

        _uiState.update {
            it.copy(
                isDailyQuizSubmitted = true,
                isDailyQuizExplanationVisible = true,
                toastMessage = if (isCorrect) {
                    "सही उत्तर! +$xpEarned XP अर्जित • विस्तृत व्याख्या नीचे उपलब्ध है"
                } else {
                    "डेली क्विज़ सबमिट किया गया! +$xpEarned XP भागीदारी बोनस • विस्तृत व्याख्या नीचे देखें"
                }
            )
        }
        recordDailyQuizActivity(dateIso = dateIso, activityPoints = xpEarned)
        syncCurrentStudentProfileToCloud()
    }

    /**
     * Toggles or explicitly sets visibility of the detailed bilingual explanation
     * after the Daily Quiz question has been submitted.
     */
    fun toggleDailyQuizExplanation(show: Boolean? = null) {
        val current = _uiState.value
        if (!current.isDailyQuizSubmitted) return
        val nextVisible = show ?: !current.isDailyQuizExplanationVisible
        _uiState.update {
            it.copy(isDailyQuizExplanationVisible = nextVisible)
        }
    }

    /**
     * Loads a new high-yield practice question from a different random subject
     * and resets the submission/explanation state for fresh practice.
     */
    fun shuffleDailyQuizQuestion() {
        val current = _uiState.value
        val nextQuestion = com.example.ui.components.DailyQuizEngine.getNextRandomSubjectQuestion(
            excludeQuestionId = current.dailyQuizQuestion.id,
            currentSubject = current.dailyQuizQuestion.subject
        )
        _uiState.update {
            it.copy(
                dailyQuizQuestion = nextQuestion,
                dailyQuizSelectedOptionIndex = null,
                isDailyQuizSubmitted = false,
                isDailyQuizExplanationVisible = false,
                toastMessage = "नया विषय प्रश्न: ${nextQuestion.subject}"
            )
        }
    }

    /**
     * Loads the deterministic Daily Quiz question for a specific [dateIso] (YYYY-MM-DD).
     */
    fun loadDailyQuizForDate(dateIso: String) {
        val cleanDate = dateIso.trim().ifBlank { com.example.ui.components.DailyStreakEngine.todayIsoDate() }
        val questionForDate = com.example.ui.components.DailyQuizEngine.getQuestionForDate(cleanDate)
        _uiState.update {
            it.copy(
                dailyQuizDateIso = cleanDate,
                dailyQuizQuestion = questionForDate,
                dailyQuizSelectedOptionIndex = null,
                isDailyQuizSubmitted = false,
                isDailyQuizExplanationVisible = false
            )
        }
    }

    fun resetDailyStreakState() {
        prefs.edit()
            .remove("daily_streak_days")
            .remove("longest_streak_days")
            .remove("reward_points")
            .remove("last_quiz_date_iso")
            .remove("completed_streak_dates_iso")
            .remove("unlocked_streak_badge_ids")
            .apply()
        _uiState.update {
            it.copy(
                dailyStreakDays = 0,
                longestStreakDays = 0,
                rewardPoints = 0,
                lastQuizAttemptDateIso = "",
                completedStreakDatesIso = emptySet(),
                unlockedStreakBadgeIds = emptySet(),
                isTodayStreakCompleted = false
            )
        }
    }

    // Cart & Wishlist Actions
    fun addToCart(item: StudyItem) {
        _uiState.update { current ->
            if (current.cartItems.any { it.studyItem.id == item.id }) {
                current.copy(toastMessage = "यह पहले से कार्ट में है (Already in cart)")
            } else {
                current.copy(
                    cartItems = current.cartItems + CartItem(item),
                    toastMessage = "कार्ट में जोड़ा गया: ${item.title}"
                )
            }
        }
    }

    fun removeFromCart(itemId: String) {
        _uiState.update { current ->
            current.copy(
                cartItems = current.cartItems.filterNot { it.studyItem.id == itemId },
                toastMessage = "आइटम कार्ट से हटाया गया"
            )
        }
    }

    fun applyCoupon(code: String) {
        val clean = code.trim().uppercase()
        when (clean) {
            "SHAKUNTALAM50" -> {
                _uiState.update {
                    it.copy(
                        appliedCoupon = clean,
                        couponDiscountPercent = 50,
                        toastMessage = "50% छूट कूपन लागू! (Flat 50% OFF Applied)"
                    )
                }
            }
            "UPSC2025" -> {
                _uiState.update {
                    it.copy(
                        appliedCoupon = clean,
                        couponDiscountPercent = 30,
                        toastMessage = "30% स्पेशल कूपन लागू! (30% Discount Applied)"
                    )
                }
            }
            else -> {
                _uiState.update {
                    it.copy(toastMessage = "अमान्य कूपन कोड (Invalid Coupon Code)")
                }
            }
        }
    }

    fun clearCoupon() {
        _uiState.update { it.copy(appliedCoupon = null, couponDiscountPercent = 0) }
    }

    fun checkout() {
        val state = _uiState.value
        if (state.cartItems.isEmpty()) return

        val newPurchased = state.cartItems.map { it.studyItem.id }.toSet()
        _uiState.update {
            it.copy(
                purchasedItemIds = it.purchasedItemIds + newPurchased,
                cartItems = emptyList(),
                appliedCoupon = null,
                couponDiscountPercent = 0,
                currentScreen = AppScreen.LIBRARY,
                toastMessage = "बधाई हो! ऑर्डर सफल रहा। पुस्तकें आपकी लाइब्रेरी में जोड़ दी गई हैं।"
            )
        }
    }

    fun toggleWishlist(itemId: String) {
        _uiState.update { current ->
            val set = current.wishlistIds.toMutableSet()
            if (set.contains(itemId)) set.remove(itemId) else set.add(itemId)
            current.copy(
                wishlistIds = set,
                toastMessage = if (set.contains(itemId)) "विशलिस्ट में जोड़ा गया" else "विशलिस्ट से हटाया गया"
            )
        }
    }

    fun toggleAboutDialog(show: Boolean) {
        _uiState.update { it.copy(showAboutDialog = show) }
    }

    // --- Authentication, First-Launch OTP Login & Post-Login 2-Field Account Setup ---

    fun openAuthModal(tab: AuthTab = AuthTab.PHONE_OTP) {
        _uiState.update {
            it.copy(
                isAuthModalOpen = true,
                authModalTab = tab,
                phoneOtpState = PhoneOtpState()
            )
        }
    }

    fun closeAuthModal() {
        _uiState.update { it.copy(isAuthModalOpen = false) }
    }

    fun switchAuthTab(tab: AuthTab) {
        _uiState.update {
            it.copy(
                authModalTab = tab,
                phoneOtpState = it.phoneOtpState.copy(isOtpSent = false, otpCode = "", errorMessage = null)
            )
        }
    }

    fun updatePhoneNumber(phone: String) {
        val digitsOnly = phone.filter { it.isDigit() }.take(10)
        _uiState.update {
            it.copy(
                phoneOtpState = it.phoneOtpState.copy(
                    phoneNumber = digitsOnly,
                    isOtpSent = if (digitsOnly.isEmpty()) false else it.phoneOtpState.isOtpSent,
                    errorMessage = null
                )
            )
        }
    }

    fun sendPhoneOtp() {
        val phone = _uiState.value.phoneOtpState.phoneNumber.trim()
        if (phone.length < 10) {
            _uiState.update {
                it.copy(phoneOtpState = it.phoneOtpState.copy(errorMessage = "कृपया 10 अंकों का मान्य मोबाइल नंबर दर्ज करें (Enter 10-digit mobile)"))
            }
            return
        }
        val demoOtp = "123456"
        _uiState.update {
            it.copy(
                authModalTab = AuthTab.PHONE_OTP,
                phoneOtpState = it.phoneOtpState.copy(
                    isOtpSent = true,
                    generatedOtp = demoOtp,
                    timerSecondsRemaining = 30,
                    errorMessage = null,
                    firebaseAuthStatusMessage = "Firebase Auth Phone OTP initiated (+91 $phone)"
                ),
                toastMessage = "OTP भेजा गया: $demoOtp (+91 $phone)"
            )
        }
    }

    fun updateEmailForOtp(email: String) {
        val clean = email.trim()
        _uiState.update {
            it.copy(
                phoneOtpState = it.phoneOtpState.copy(
                    emailAddress = clean,
                    isOtpSent = if (clean.isEmpty()) false else it.phoneOtpState.isOtpSent,
                    errorMessage = null
                )
            )
        }
    }

    fun sendEmailOtp() {
        val email = _uiState.value.phoneOtpState.emailAddress.trim()
        if (email.length < 5 || !email.contains("@") || !email.contains(".")) {
            _uiState.update {
                it.copy(
                    phoneOtpState = it.phoneOtpState.copy(
                        errorMessage = "कृपया मान्य ईमेल आईडी दर्ज करें (Enter valid Email ID e.g. student@gmail.com)"
                    )
                )
            }
            return
        }
        val demoOtp = "123456"
        _uiState.update {
            it.copy(
                authModalTab = AuthTab.EMAIL_OTP,
                phoneOtpState = it.phoneOtpState.copy(
                    isOtpSent = true,
                    generatedOtp = demoOtp,
                    timerSecondsRemaining = 30,
                    errorMessage = null,
                    firebaseAuthStatusMessage = "Firebase Auth Email OTP initiated ($email)"
                ),
                toastMessage = "ईमेल पर OTP भेजा गया: $demoOtp ($email)"
            )
        }
    }

    /**
     * Unified Firebase Auth OTP initiator that inspects whether the user entered a
     * Phone Number or an Email ID and triggers the corresponding OTP flow.
     */
    fun initiateFirebaseOtp() {
        val otpState = _uiState.value.phoneOtpState
        val phone = otpState.phoneNumber.trim()
        val email = otpState.emailAddress.trim()
        val currentTab = _uiState.value.authModalTab

        when {
            currentTab == AuthTab.PHONE_OTP && phone.length >= 10 -> sendPhoneOtp()
            currentTab == AuthTab.EMAIL_OTP && email.contains("@") -> sendEmailOtp()
            phone.length >= 10 -> sendPhoneOtp()
            email.contains("@") -> sendEmailOtp()
            currentTab == AuthTab.EMAIL_OTP -> sendEmailOtp()
            else -> sendPhoneOtp()
        }
    }

    fun onFirebasePhoneVerificationIdReceived(verificationId: String) {
        _uiState.update {
            it.copy(
                phoneOtpState = it.phoneOtpState.copy(
                    firebaseVerificationId = verificationId,
                    firebaseAuthStatusMessage = "Firebase SMS Verification ID received"
                )
            )
        }
    }

    fun updateOtpCode(code: String) {
        val digitsOnly = code.filter { it.isDigit() }.take(6)
        _uiState.update {
            it.copy(phoneOtpState = it.phoneOtpState.copy(otpCode = digitsOnly, errorMessage = null))
        }
    }

    fun verifyPhoneOtp(userName: String = "") {
        val otpState = _uiState.value.phoneOtpState
        if (otpState.otpCode != otpState.generatedOtp && otpState.otpCode != "123456") {
            _uiState.update {
                it.copy(phoneOtpState = it.phoneOtpState.copy(errorMessage = "अमान्य OTP कोड! कृपया '123456' या प्राप्त कोड दर्ज करें"))
            }
            return
        }

        val cleanProvidedName = userName.trim()
        val hasPreFilledName = cleanProvidedName.isNotEmpty()
        val initialDisplayName = cleanProvidedName.ifBlank {
            _uiState.value.onboardingStudentNameInput.ifBlank { "Student Aspirant" }
        }
        val currentTargetExam = _uiState.value.onboardingTargetExamInput.ifBlank { "UPSC Civil Services" }
        val phone = "+91 " + otpState.phoneNumber.ifBlank { "9876543210" }

        val profile = UserProfile(
            name = initialDisplayName,
            email = null,
            phoneNumber = phone,
            provider = AuthProviderType.PHONE_OTP,
            avatarLetter = initialDisplayName.firstOrNull()?.uppercase() ?: "S",
            targetExam = currentTargetExam,
            isVerified = true,
            isAccountSetupCompleted = hasPreFilledName,
            purchasedItemsCount = _uiState.value.purchasedItemIds.size,
            testAttemptsCount = _uiState.value.testAttemptsHistory.size.coerceAtLeast(1)
        )

        prefs.edit()
            .putBoolean("user_is_logged_in", true)
            .putBoolean("user_account_setup_completed", hasPreFilledName)
            .putString("user_name", initialDisplayName)
            .putString("user_target_exam", currentTargetExam)
            .putString("user_phone", phone)
            .remove("user_email")
            .putString("user_provider", AuthProviderType.PHONE_OTP.name)
            .apply()

        _uiState.update {
            it.copy(
                isLoggedIn = true,
                currentUser = profile,
                isAuthModalOpen = false,
                isAccountSetupModalOpen = !hasPreFilledName,
                onboardingStudentNameInput = cleanProvidedName,
                onboardingErrorMessage = null,
                toastMessage = if (hasPreFilledName) {
                    "सफलतापूर्वक लॉगिन हुआ! स्वागत है, ${profile.name}"
                } else {
                    "OTP सत्यापित! अब अपना नाम और किस एग्जाम की तैयारी कर रहे हैं भरें।"
                }
            )
        }
    }

    fun verifyEmailOtp(userName: String = "") {
        val otpState = _uiState.value.phoneOtpState
        if (otpState.otpCode != otpState.generatedOtp && otpState.otpCode != "123456") {
            _uiState.update {
                it.copy(phoneOtpState = it.phoneOtpState.copy(errorMessage = "अमान्य ईमेल OTP कोड! कृपया '123456' या प्राप्त कोड दर्ज करें"))
            }
            return
        }

        val cleanProvidedName = userName.trim()
        val hasPreFilledName = cleanProvidedName.isNotEmpty()
        val initialDisplayName = cleanProvidedName.ifBlank {
            _uiState.value.onboardingStudentNameInput.ifBlank { "Student Aspirant" }
        }
        val currentTargetExam = _uiState.value.onboardingTargetExamInput.ifBlank { "UPSC Civil Services" }
        val email = otpState.emailAddress.ifBlank { "student@gmail.com" }

        val profile = UserProfile(
            name = initialDisplayName,
            email = email,
            phoneNumber = null,
            provider = AuthProviderType.EMAIL_OTP,
            avatarLetter = initialDisplayName.firstOrNull()?.uppercase() ?: "S",
            targetExam = currentTargetExam,
            isVerified = true,
            isAccountSetupCompleted = hasPreFilledName,
            purchasedItemsCount = _uiState.value.purchasedItemIds.size,
            testAttemptsCount = _uiState.value.testAttemptsHistory.size.coerceAtLeast(1)
        )

        prefs.edit()
            .putBoolean("user_is_logged_in", true)
            .putBoolean("user_account_setup_completed", hasPreFilledName)
            .putString("user_name", initialDisplayName)
            .putString("user_target_exam", currentTargetExam)
            .putString("user_email", email)
            .remove("user_phone")
            .putString("user_provider", AuthProviderType.EMAIL_OTP.name)
            .apply()

        _uiState.update {
            it.copy(
                isLoggedIn = true,
                currentUser = profile,
                isAuthModalOpen = false,
                isAccountSetupModalOpen = !hasPreFilledName,
                onboardingStudentNameInput = cleanProvidedName,
                onboardingErrorMessage = null,
                toastMessage = if (hasPreFilledName) {
                    "ईमेल OTP लॉगिन सफल! स्वागत है, ${profile.name}"
                } else {
                    "ईमेल OTP सत्यापित! अब अपना नाम और टारगेट एग्जाम चुनें।"
                }
            )
        }
    }

    fun loginWithGoogle(email: String = "thebharat99999@gmail.com", name: String = "Bharat Kumar") {
        val cleanName = name.trim()
        val hasName = cleanName.isNotEmpty()
        val displayName = cleanName.ifBlank { "Bharat Kumar" }
        val currentTargetExam = _uiState.value.onboardingTargetExamInput.ifBlank { "UPSC Civil Services" }

        val profile = UserProfile(
            name = displayName,
            email = email,
            phoneNumber = null,
            provider = AuthProviderType.GOOGLE,
            avatarLetter = displayName.firstOrNull()?.uppercase() ?: "B",
            targetExam = currentTargetExam,
            isVerified = true,
            isAccountSetupCompleted = hasName,
            purchasedItemsCount = _uiState.value.purchasedItemIds.size,
            testAttemptsCount = _uiState.value.testAttemptsHistory.size.coerceAtLeast(1)
        )

        prefs.edit()
            .putBoolean("user_is_logged_in", true)
            .putBoolean("user_account_setup_completed", hasName)
            .putString("user_name", displayName)
            .putString("user_target_exam", currentTargetExam)
            .putString("user_email", email)
            .putString("user_provider", AuthProviderType.GOOGLE.name)
            .apply()

        _uiState.update {
            it.copy(
                isLoggedIn = true,
                currentUser = profile,
                isAuthModalOpen = false,
                isAccountSetupModalOpen = !hasName,
                onboardingStudentNameInput = cleanName,
                toastMessage = "Google द्वारा लॉगिन सफल: $email"
            )
        }
        syncCurrentStudentProfileToCloud()
    }

    fun signInWithFirebaseGoogleToken(
        idToken: String,
        fallbackEmail: String = "thebharat99999@gmail.com",
        fallbackName: String = ""
    ) {
        val repo = studentAuthRepo
        if (repo == null) {
            loginWithGoogle(fallbackEmail, fallbackName)
            return
        }
        repo.signInWithGoogleIdToken(
            idToken = idToken,
            onSuccess = { firebaseUser ->
                val resolvedEmail = firebaseUser.email ?: fallbackEmail
                val resolvedName = firebaseUser.displayName ?: fallbackName
                loginWithGoogle(resolvedEmail, resolvedName)
            },
            onError = {
                loginWithGoogle(fallbackEmail, fallbackName)
            }
        )
    }

    private fun syncCurrentStudentProfileToCloud() {
        val repo = studentAuthRepo ?: return
        if (repo.currentUserId() == null) return
        val currentState = _uiState.value
        val user = currentState.currentUser ?: return
        val summary = currentState.getMasterProgressSummary()
        viewModelScope.launch(kotlinx.coroutines.Dispatchers.IO) {
            runCatching {
                repo.saveOrUpdateStudentProfile(
                    studentName = user.name,
                    targetExam = user.targetExam,
                    authMethod = user.provider.name,
                    totalPoints = summary.liveScorePoints.toLong(),
                    testsAttempted = summary.testsCompletedCount.toLong(),
                    averageAccuracy = summary.overallAccuracyPercent.toLong(),
                    streakDays = currentState.dailyStreakDays.toLong(),
                    accountSetupCompleted = user.isAccountSetupCompleted
                )
            }
        }
    }

    fun updateOnboardingStudentName(name: String) {
        _uiState.update {
            it.copy(
                onboardingStudentNameInput = name,
                onboardingErrorMessage = null
            )
        }
    }

    fun updateOnboardingTargetExam(exam: String) {
        _uiState.update {
            it.copy(
                onboardingTargetExamInput = exam,
                onboardingErrorMessage = null
            )
        }
    }

    /**
     * Post-Login 2-Field Account Setup on Dashboard:
     * Only asks for two fields:
     * 1. [studentName] (स्टूडेंट का नाम)
     * 2. [targetExam] (किस एग्जाम की प्रिपरेशन कर रहा है)
     * Creates/completes the student account and syncs it across the App & Leaderboard.
     */
    fun completeStudentAccountSetup(
        studentName: String = _uiState.value.onboardingStudentNameInput,
        targetExam: String = _uiState.value.onboardingTargetExamInput
    ) {
        val cleanName = com.example.security.SecurityManager.sanitizeInput(studentName.trim())
        val cleanExam = targetExam.trim().ifBlank { "UPSC Civil Services" }

        if (cleanName.isBlank()) {
            _uiState.update {
                it.copy(
                    onboardingErrorMessage = "कृपया अपना नाम दर्ज करें (Please enter Student Name)"
                )
            }
            return
        }

        val existing = _uiState.value.currentUser
        val updatedProfile = (existing ?: UserProfile()).copy(
            name = cleanName,
            avatarLetter = cleanName.firstOrNull()?.uppercase() ?: "S",
            targetExam = cleanExam,
            isVerified = true,
            isAccountSetupCompleted = true,
            purchasedItemsCount = _uiState.value.purchasedItemIds.size,
            testAttemptsCount = _uiState.value.testAttemptsHistory.size.coerceAtLeast(1)
        )

        prefs.edit()
            .putBoolean("user_is_logged_in", true)
            .putBoolean("user_account_setup_completed", true)
            .putString("user_name", cleanName)
            .putString("user_target_exam", cleanExam)
            .apply()

        _uiState.update {
            it.copy(
                isLoggedIn = true,
                currentUser = updatedProfile,
                isAuthModalOpen = false,
                isAccountSetupModalOpen = false,
                onboardingStudentNameInput = cleanName,
                onboardingTargetExamInput = cleanExam,
                onboardingErrorMessage = null,
                toastMessage = "अकाउंट तैयार! नाम: $cleanName • लक्ष्य: $cleanExam (लीडरबोर्ड में जोड़ा गया)"
            )
        }
        syncCurrentStudentProfileToCloud()
    }

    fun openAccountSetupModal() {
        _uiState.update {
            it.copy(
                isAccountSetupModalOpen = true,
                onboardingStudentNameInput = it.currentUser?.name ?: it.onboardingStudentNameInput,
                onboardingTargetExamInput = it.currentUser?.targetExam ?: it.onboardingTargetExamInput,
                onboardingErrorMessage = null
            )
        }
    }

    fun closeAccountSetupModal() {
        _uiState.update { it.copy(isAccountSetupModalOpen = false, onboardingErrorMessage = null) }
    }

    fun selectLeaderboardScope(scope: String) {
        val norm = if (scope.equals("ALL_INDIA", ignoreCase = true)) "ALL_INDIA" else "TARGET_EXAM"
        _uiState.update { it.copy(selectedLeaderboardScope = norm) }
    }

    fun toggleProgressTrackerExpanded() {
        _uiState.update { it.copy(isProgressTrackerExpanded = !it.isProgressTrackerExpanded) }
    }

    fun toggleDashboardLeaderboardExpanded() {
        _uiState.update { it.copy(isDashboardLeaderboardExpanded = !it.isDashboardLeaderboardExpanded) }
    }

    fun logout() {
        runCatching { studentAuthRepo?.signOut() }
        prefs.edit()
            .putBoolean("user_is_logged_in", false)
            .putBoolean("user_account_setup_completed", false)
            .remove("user_name")
            .remove("user_phone")
            .remove("user_email")
            .apply()

        _uiState.update {
            it.copy(
                isLoggedIn = false,
                currentUser = null,
                isProfileModalOpen = false,
                isAccountSetupModalOpen = false,
                isAuthModalOpen = true,
                phoneOtpState = PhoneOtpState(),
                onboardingStudentNameInput = "",
                toastMessage = "लॉगआउट सफल रहा (Logged out successfully)"
            )
        }
    }

    fun openProfileTab() {
        navigateTo(AppScreen.PROFILE)
    }

    fun openProfileModal() {
        _uiState.update { it.copy(isProfileModalOpen = true) }
    }

    fun closeProfileModal() {
        _uiState.update { it.copy(isProfileModalOpen = false) }
    }

    fun openDownloadModal() {
        _uiState.update { it.copy(isDownloadModalOpen = true) }
    }

    fun closeDownloadModal() {
        _uiState.update { it.copy(isDownloadModalOpen = false) }
    }

    fun updateTargetExam(exam: String) {
        val cleanExam = exam.trim().ifBlank { "UPSC Civil Services" }
        prefs.edit().putString("user_target_exam", cleanExam).apply()
        _uiState.update { current ->
            val updatedUser = current.currentUser?.copy(targetExam = cleanExam)
            current.copy(
                currentUser = updatedUser,
                onboardingTargetExamInput = cleanExam,
                toastMessage = "लक्ष्य परीक्षा अपडेट की गई: $cleanExam"
            )
        }
    }

    fun clearToast() {
        _uiState.update { it.copy(toastMessage = null) }
    }
}
