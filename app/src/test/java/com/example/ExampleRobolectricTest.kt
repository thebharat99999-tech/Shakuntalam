package com.example

import android.app.Application
import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.data.ExamCatalogData
import com.example.model.AppLanguage
import com.example.security.SecurityManager
import com.example.viewmodel.ShakuntalamViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [34])
class ExampleRobolectricTest {

    @Test
    fun testAppNameString() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val appName = context.getString(R.string.app_name)
        assertEquals("Shakuntalam", appName)
    }

    @Test
    fun testDefaultEnglishLanguageAndOwnerUpiDetails() {
        val app = ApplicationProvider.getApplicationContext<Application>()
        val viewModel = ShakuntalamViewModel(app)
        val state = viewModel.uiState.value

        // Default language must be English
        assertEquals(AppLanguage.ENGLISH, state.selectedLanguage)
        assertFalse(state.isBilingualHindi)

        // Default linked UPI and mobile must be 6396817525@jio and 6396817525
        assertEquals("6396817525@jio", state.ownerUpiId)
        assertEquals("6396817525", state.ownerUpiMobile)
        assertTrue(state.isAntiPiracyEnabled)
    }

    @Test
    fun testSecurityManagerAntiHackerSanitizationAndPinVerification() {
        val maliciousInput = "<script>alert('hack')</script>UPSC Notes; DROP TABLE exams; --"
        val sanitized = SecurityManager.sanitizeInput(maliciousInput)
        assertFalse(sanitized.contains("<script>"))
        assertFalse(sanitized.lowercase().contains("drop table"))

        // UPI validation
        assertTrue(SecurityManager.isValidUpiId("6396817525@jio"))
        assertFalse(SecurityManager.isValidUpiId("invalid_upi_without_at"))

        // Admin PIN verification
        val app = ApplicationProvider.getApplicationContext<Application>()
        val viewModel = ShakuntalamViewModel(app)
        assertTrue(viewModel.verifyAdminPin("2525"))
        assertFalse(viewModel.verifyAdminPin("0000"))
    }

    @Test
    fun testExamCategoriesAreInEnglish() {
        val categories = ExamCatalogData.categories
        assertTrue(categories.isNotEmpty())
        assertTrue(categories.first().name.contains("UPSC"))
    }

    @Test
    fun testLast5YearsPyqBilingualTestBank() {
        val allTests = com.example.data.PyqTestBankData.allPyqTests
        assertTrue(allTests.size >= 6)

        allTests.forEach { test ->
            assertTrue("Test ${test.testId} must have questions", test.questions.isNotEmpty())
            assertTrue("Test ${test.testId} must have PYQ analysis EN", test.pyqAnalysisEn.isNotBlank())
            assertTrue("Test ${test.testId} must have PYQ analysis HI", test.pyqAnalysisHi.isNotBlank())

            test.questions.forEach { q ->
                assertTrue(q.questionEn.isNotBlank())
                assertTrue(q.questionHi.isNotBlank())
                assertEquals(4, q.optionsEn.size)
                assertEquals(4, q.optionsHi.size)
                assertTrue(q.correctIndex in 0..3)
                assertTrue(q.explanationEn.isNotBlank())
                assertTrue(q.explanationHi.isNotBlank())
                assertTrue(q.pyqYearTag.isNotBlank())
            }
        }

        // Verify ViewModel category-based PYQ test switching
        val app = ApplicationProvider.getApplicationContext<Application>()
        val viewModel = ShakuntalamViewModel(app)
        assertTrue(viewModel.uiState.value.isDualBilingualView)

        viewModel.selectPyqTestByCategory("ssc")
        assertEquals("ssc", viewModel.uiState.value.activeTest.categoryId)
        assertEquals(0.50, viewModel.uiState.value.activeTest.negativeMarks, 0.01)

        viewModel.selectPyqTestByCategory("banking")
        assertEquals("banking", viewModel.uiState.value.activeTest.categoryId)
        assertEquals(0.25, viewModel.uiState.value.activeTest.negativeMarks, 0.01)
    }

    @Test
    fun testUppcsSevenSections50QuestionsEachAndInstantAnswerExplanation() {
        val uppcsSections = com.example.data.uppcs.UppcsUpCaEcoPyqData.all7UppcsSectionTests
        assertEquals(7, uppcsSections.size)

        val expectedIds = listOf(
            "history",
            "polity",
            "geography",
            "environment",
            "scitech",
            "up_ca",
            "economics"
        )
        assertEquals(expectedIds, uppcsSections.map { it.sectionId })

        uppcsSections.forEach { section ->
            val test = section.mockTest
            assertEquals("Section ${section.sectionId} must have 50 questions", 50, test.questions.size)
            test.questions.forEach { q ->
                assertTrue(q.questionEn.isNotBlank())
                assertTrue(q.questionHi.isNotBlank())
                assertEquals(4, q.optionsEn.size)
                assertEquals(4, q.optionsHi.size)
                assertTrue(q.correctIndex in 0..3)
                assertTrue(q.explanationEn.isNotBlank())
                assertTrue(q.explanationHi.isNotBlank())
            }
        }

        // Verify ViewModel UPPCS Free Test flow & instant answer/explanation reveal
        val app = ApplicationProvider.getApplicationContext<Application>()
        val viewModel = ShakuntalamViewModel(app)

        assertFalse(viewModel.uiState.value.isUppcsFreeTestSectionExpanded)
        viewModel.toggleUppcsFreeTestSections()
        assertTrue(viewModel.uiState.value.isUppcsFreeTestSectionExpanded)

        viewModel.startUppcsSectionTest("uppcs_polity")
        assertEquals("uppcs_sec_polity_50", viewModel.uiState.value.activeTest.testId)
        assertEquals(50, viewModel.uiState.value.activeTest.questions.size)

        val firstQ = viewModel.uiState.value.activeTest.questions.first()
        assertFalse(viewModel.uiState.value.isInstantPyqSolutionVisible)
        viewModel.answerQuestion(firstQ.id, firstQ.correctIndex)
        assertTrue(viewModel.uiState.value.isInstantPyqSolutionVisible)
    }

    @Test
    fun testUpscCseSevenSections50QuestionsEachBilingualPyq() {
        val upscSections = com.example.data.upsc.UpscSciTechIrCaPyqData.all7UpscSectionTests
        assertEquals(7, upscSections.size)

        val expectedUpscIds = listOf(
            "upsc_history",
            "upsc_polity",
            "upsc_geography",
            "upsc_economics",
            "upsc_environment",
            "upsc_scitech",
            "upsc_ir_ca"
        )
        assertEquals(expectedUpscIds, upscSections.map { it.sectionId })

        upscSections.forEach { section ->
            val test = section.mockTest
            assertEquals("UPSC Section ${section.sectionId} must have 50 questions", 50, test.questions.size)
            assertEquals(2.0, test.positiveMarks, 0.01)
            assertEquals(0.66, test.negativeMarks, 0.01)
            test.questions.forEach { q ->
                assertTrue(q.questionEn.isNotBlank())
                assertTrue(q.questionHi.isNotBlank())
                assertEquals(4, q.optionsEn.size)
                assertEquals(4, q.optionsHi.size)
                assertTrue(q.correctIndex in 0..3)
                assertTrue(q.explanationEn.isNotBlank())
                assertTrue(q.explanationHi.isNotBlank())

                // Verify that no option stands out with parenthetical spoilers/giveaways
                q.optionsEn.forEach { optEn ->
                    assertFalse("Option EN should not contain parenthetical spoiler hint: $optEn", optEn.contains("("))
                    if (!optEn.startsWith("Both Statement-I and Statement-II")) {
                        assertFalse("Option EN should not contain spoiler 'are correct': $optEn", optEn.lowercase().contains("are correct"))
                    }
                }
                q.optionsHi.forEach { optHi ->
                    assertFalse("Option HI should not contain parenthetical spoiler hint: $optHi", optHi.contains("("))
                    if (!optHi.startsWith("कथन-I और कथन-II")) {
                        assertFalse("Option HI should not contain spoiler 'सही हैं': $optHi", optHi.contains("सही हैं"))
                    }
                }

                // Verify Statement-I / Statement-II questions never use raw option text as Statement-I
                assertFalse(
                    "Question EN must not have 'Statement-I: Only' or 'Statement-I: All': ${q.questionEn}",
                    q.questionEn.contains("Statement-I: Only") || q.questionEn.contains("Statement-I: All")
                )

                // Verify canonical UPSC ordering for 3-statement 'How many' questions
                if (q.optionsEn.contains("Only one") && q.optionsEn.contains("All three")) {
                    assertEquals(listOf("Only one", "Only two", "All three", "None"), q.optionsEn)
                    assertEquals(listOf("केवल एक", "केवल दो", "सभी तीन", "कोई भी नहीं"), q.optionsHi)
                }
            }
        }

        val app = ApplicationProvider.getApplicationContext<Application>()
        val viewModel = ShakuntalamViewModel(app)
        viewModel.toggleUpscFreeTestSections()
        assertTrue(viewModel.uiState.value.isUpscFreeTestSectionExpanded)

        viewModel.startUpscSectionTest("upsc_economics")
        assertEquals("upsc_sec_economics_50", viewModel.uiState.value.activeTest.testId)
        assertEquals(50, viewModel.uiState.value.activeTest.questions.size)
    }

    @Test
    fun testUkpscEightSectionsIncludingUttarakhandSpecial100Pyqs() {
        val ukpscSections = com.example.data.ukpsc.UkpscAllSubjectsPyqData.all8UkpscSectionTests
        assertEquals(8, ukpscSections.size)

        val expectedUkpscIds = listOf(
            "ukpsc_special_100",
            "ukpsc_history",
            "ukpsc_polity",
            "ukpsc_geography",
            "ukpsc_economics",
            "ukpsc_environment",
            "ukpsc_scitech",
            "ukpsc_current_affairs"
        )
        assertEquals(expectedUkpscIds, ukpscSections.map { it.sectionId })

        // Verify Flagship Uttarakhand Special 100 PYQ Section
        val specialSection = ukpscSections.first()
        assertTrue(specialSection.isSpecial100)
        assertEquals(100, specialSection.mockTest.questions.size)
        assertEquals(1.0, specialSection.mockTest.positiveMarks, 0.01)
        assertEquals(0.25, specialSection.mockTest.negativeMarks, 0.01)

        // Verify all 8 sections have bilingual questions, 4 options, and explanations
        ukpscSections.forEach { section ->
            val test = section.mockTest
            val expectedCount = if (section.isSpecial100) 100 else 50
            assertEquals("UKPSC Section ${section.sectionId} must have $expectedCount questions", expectedCount, test.questions.size)
            assertEquals(1.0, test.positiveMarks, 0.01)
            assertEquals(0.25, test.negativeMarks, 0.01)

            test.questions.forEach { q ->
                assertTrue(q.questionEn.isNotBlank())
                assertTrue(q.questionHi.isNotBlank())
                assertEquals(4, q.optionsEn.size)
                assertEquals(4, q.optionsHi.size)
                assertTrue(q.correctIndex in 0..3)
                assertTrue(q.explanationEn.isNotBlank())
                assertTrue(q.explanationHi.isNotBlank())
                assertTrue(q.pyqYearTag.isNotBlank())
            }
        }

        val app = ApplicationProvider.getApplicationContext<Application>()
        val viewModel = ShakuntalamViewModel(app)
        assertFalse(viewModel.uiState.value.isUkpscFreeTestSectionExpanded)
        viewModel.toggleUkpscFreeTestSections()
        assertTrue(viewModel.uiState.value.isUkpscFreeTestSectionExpanded)

        viewModel.startUkpscSectionTest("ukpsc_special_100")
        assertEquals("ukpsc_sec_uttarakhand_special_100", viewModel.uiState.value.activeTest.testId)
        assertEquals(100, viewModel.uiState.value.activeTest.questions.size)

        viewModel.startUkpscSectionTest("ukpsc_geography")
        assertEquals("ukpsc_sec_geography_50", viewModel.uiState.value.activeTest.testId)
        assertEquals(50, viewModel.uiState.value.activeTest.questions.size)
    }

    @Test
    fun testBpscSevenSections100QuestionsEachAndPaidFreeTestSeriesSwitcher() {
        val bpscSections = com.example.data.bpsc.BpscAllSubjects100PyqData.all7BpscSectionTests
        assertEquals(7, bpscSections.size)

        val expectedBpscIds = listOf(
            "bpsc_bihar_special",
            "bpsc_history",
            "bpsc_polity",
            "bpsc_geography",
            "bpsc_economics",
            "bpsc_science",
            "bpsc_current_affairs"
        )
        assertEquals(expectedBpscIds, bpscSections.map { it.sectionId })

        // Verify all 7 BPSC sections have 100 bilingual questions each (700 total)
        bpscSections.forEach { section ->
            val test = section.mockTest
            assertEquals("BPSC Section ${section.sectionId} must have 100 questions", 100, test.questions.size)
            assertEquals(1.0, test.positiveMarks, 0.01)
            assertEquals(0.33, test.negativeMarks, 0.01)

            test.questions.forEach { q ->
                assertTrue(q.questionEn.isNotBlank())
                assertTrue(q.questionHi.isNotBlank())
                assertEquals(4, q.optionsEn.size)
                assertEquals(4, q.optionsHi.size)
                assertTrue(q.correctIndex in 0..3)
                assertTrue(q.explanationEn.isNotBlank())
                assertTrue(q.explanationHi.isNotBlank())
                assertTrue(q.pyqYearTag.isNotBlank())
            }
        }

        // Verify ViewModel BPSC test start & Paid vs Free Test Series switcher
        val app = ApplicationProvider.getApplicationContext<Application>()
        val viewModel = ShakuntalamViewModel(app)
        assertEquals("FREE", viewModel.uiState.value.examTestSeriesModeMap["bpsc"])

        viewModel.selectExamTestSeriesMode("bpsc", "PAID")
        assertEquals("PAID", viewModel.uiState.value.examTestSeriesModeMap["bpsc"])
        assertTrue(viewModel.uiState.value.isBpscFreeTestSectionExpanded)

        viewModel.selectExamTestSeriesMode("bpsc", "FREE")
        assertEquals("FREE", viewModel.uiState.value.examTestSeriesModeMap["bpsc"])

        viewModel.startBpscSectionTest("bpsc_history")
        assertEquals("bpsc_sec_history_100", viewModel.uiState.value.activeTest.testId)
        assertEquals(100, viewModel.uiState.value.activeTest.questions.size)
    }

    @Test
    fun testUpssscNineSectionsIncludingUpSpecial250AndComputerAndDi() {
        val upssscSections = com.example.data.upsssc.UpssscAllSubjectsPyqData.all9UpssscSectionTests
        assertEquals(9, upssscSections.size)

        val expectedUpssscIds = listOf(
            "upsssc_history",
            "upsssc_polity",
            "upsssc_geography",
            "upsssc_economics",
            "upsssc_environment",
            "upsssc_scitech",
            "upsssc_up_special_250",
            "upsssc_computer",
            "upsssc_di"
        )
        assertEquals(expectedUpssscIds, upssscSections.map { it.sectionId })

        // Verify total questions across all 9 UPSSSC sections = 1,050 (6×100 + 250 + 100 + 100)
        val totalQuestions = upssscSections.sumOf { it.mockTest.questions.size }
        assertEquals(1050, totalQuestions)

        upssscSections.forEach { section ->
            val test = section.mockTest
            val expectedSize = if (section.isUpSpecial250) 250 else 100
            assertEquals("UPSSSC Section ${section.sectionId} must have $expectedSize questions", expectedSize, test.questions.size)
            assertEquals(1.0, test.positiveMarks, 0.01)
            assertEquals(0.25, test.negativeMarks, 0.01)

            test.questions.forEach { q ->
                assertTrue(q.questionEn.isNotBlank())
                assertTrue(q.questionHi.isNotBlank())
                assertEquals(4, q.optionsEn.size)
                assertEquals(4, q.optionsHi.size)
                assertTrue(q.correctIndex in 0..3)
                assertTrue(q.explanationEn.isNotBlank())
                assertTrue(q.explanationHi.isNotBlank())
                assertTrue(q.pyqYearTag.isNotBlank())
            }
        }

        // Verify ViewModel UPSSSC Paid/Free switcher & section test launching
        val app = ApplicationProvider.getApplicationContext<Application>()
        val viewModel = ShakuntalamViewModel(app)
        assertEquals("FREE", viewModel.uiState.value.examTestSeriesModeMap["upsssc"])

        viewModel.selectExamTestSeriesMode("upsssc", "PAID")
        assertEquals("PAID", viewModel.uiState.value.examTestSeriesModeMap["upsssc"])
        assertTrue(viewModel.uiState.value.isUpssscFreeTestSectionExpanded)

        viewModel.selectExamTestSeriesMode("upsssc", "FREE")
        assertEquals("FREE", viewModel.uiState.value.examTestSeriesModeMap["upsssc"])

        viewModel.startUpssscSectionTest("upsssc_up_special_250")
        assertEquals("upsssc_sec_up_special_250", viewModel.uiState.value.activeTest.testId)
        assertEquals(250, viewModel.uiState.value.activeTest.questions.size)

        viewModel.startUpssscSectionTest("upsssc_computer")
        assertEquals("upsssc_sec_computer_100", viewModel.uiState.value.activeTest.testId)
        assertEquals(100, viewModel.uiState.value.activeTest.questions.size)

        viewModel.startUpssscSectionTest("upsssc_di")
        assertEquals("upsssc_sec_di_100", viewModel.uiState.value.activeTest.testId)
        assertEquals(100, viewModel.uiState.value.activeTest.questions.size)
    }

    @Test
    fun testUkssscTenSectionsIncludingUttarakhandSpecial250AndHindiComputerReasoningDi() {
        val ukssscSections = com.example.data.uksssc.UkssscAllSubjectsPyqData.all10UkssscSectionTests
        assertEquals(10, ukssscSections.size)

        val expectedUkssscIds = listOf(
            "uksssc_history",
            "uksssc_polity",
            "uksssc_geography",
            "uksssc_economics",
            "uksssc_environment",
            "uksssc_scitech",
            "uksssc_uk_special_250",
            "uksssc_hindi",
            "uksssc_computer",
            "uksssc_reasoning_di"
        )
        assertEquals(expectedUkssscIds, ukssscSections.map { it.sectionId })

        // Verify total questions across all 10 UKSSSC sections = 1,150 (9×100 + 250)
        val totalQuestions = ukssscSections.sumOf { it.mockTest.questions.size }
        assertEquals(1150, totalQuestions)

        ukssscSections.forEach { section ->
            val test = section.mockTest
            val expectedSize = if (section.isUkSpecial250) 250 else 100
            assertEquals("UKSSSC Section ${section.sectionId} must have $expectedSize questions", expectedSize, test.questions.size)
            assertEquals(1.0, test.positiveMarks, 0.01)
            assertEquals(0.25, test.negativeMarks, 0.01)

            test.questions.forEach { q ->
                assertTrue(q.questionEn.isNotBlank())
                assertTrue(q.questionHi.isNotBlank())
                assertEquals(4, q.optionsEn.size)
                assertEquals(4, q.optionsHi.size)
                assertTrue(q.correctIndex in 0..3)
                assertTrue(q.explanationEn.isNotBlank())
                assertTrue(q.explanationHi.isNotBlank())
                assertTrue(q.pyqYearTag.isNotBlank())
            }
        }

        // Verify ViewModel UKSSSC Paid/Free switcher & section test launching
        val app = ApplicationProvider.getApplicationContext<Application>()
        val viewModel = ShakuntalamViewModel(app)
        assertEquals("FREE", viewModel.uiState.value.examTestSeriesModeMap["uksssc"])

        viewModel.selectExamTestSeriesMode("uksssc", "PAID")
        assertEquals("PAID", viewModel.uiState.value.examTestSeriesModeMap["uksssc"])
        assertTrue(viewModel.uiState.value.isUkssscFreeTestSectionExpanded)

        viewModel.selectExamTestSeriesMode("uksssc", "FREE")
        assertEquals("FREE", viewModel.uiState.value.examTestSeriesModeMap["uksssc"])

        viewModel.startUkssscSectionTest("uksssc_uk_special_250")
        assertEquals("uksssc_sec_uttarakhand_special_250", viewModel.uiState.value.activeTest.testId)
        assertEquals(250, viewModel.uiState.value.activeTest.questions.size)

        viewModel.startUkssscSectionTest("uksssc_hindi")
        assertEquals("uksssc_sec_hindi_100", viewModel.uiState.value.activeTest.testId)
        assertEquals(100, viewModel.uiState.value.activeTest.questions.size)

        viewModel.startUkssscSectionTest("uksssc_computer")
        assertEquals("uksssc_sec_computer_100", viewModel.uiState.value.activeTest.testId)
        assertEquals(100, viewModel.uiState.value.activeTest.questions.size)

        viewModel.startUkssscSectionTest("uksssc_reasoning_di")
        assertEquals("uksssc_sec_reasoning_di_100", viewModel.uiState.value.activeTest.testId)
        assertEquals(100, viewModel.uiState.value.activeTest.questions.size)
    }

    @Test
    fun testSscCglChslCpoEightSections100QuestionsEachAndPaidFreeSwitcher() {
        val sscSections = com.example.data.ssc.SscAllSubjectsPyqData.all8SscSectionTests
        assertEquals(8, sscSections.size)

        val expectedSscIds = listOf(
            "ssc_sec_history_100",
            "ssc_sec_polity_100",
            "ssc_sec_geography_100",
            "ssc_sec_environment_100",
            "ssc_sec_economics_100",
            "ssc_sec_reasoning_100",
            "ssc_sec_mathematics_100",
            "ssc_sec_english_100"
        )
        assertEquals(expectedSscIds, sscSections.map { it.sectionId })

        // Verify total questions across all 8 SSC sections = 800 (8 × 100)
        val totalQuestions = sscSections.sumOf { it.mockTest.questions.size }
        assertEquals(800, totalQuestions)

        sscSections.forEach { section ->
            val test = section.mockTest
            assertEquals("SSC Section ${section.sectionId} must have 100 questions", 100, test.questions.size)
            assertEquals(2.0, test.positiveMarks, 0.01)
            assertEquals(0.50, test.negativeMarks, 0.01)

            test.questions.forEach { q ->
                assertTrue(q.questionEn.isNotBlank())
                assertTrue(q.questionHi.isNotBlank())
                assertEquals(4, q.optionsEn.size)
                assertEquals(4, q.optionsHi.size)
                assertTrue(q.correctIndex in 0..3)
                assertTrue(q.explanationEn.isNotBlank())
                assertTrue(q.explanationHi.isNotBlank())
                assertTrue(q.pyqYearTag.isNotBlank())
            }
        }

        // Verify ViewModel SSC Paid/Free switcher & section test launching
        val app = ApplicationProvider.getApplicationContext<Application>()
        val viewModel = ShakuntalamViewModel(app)
        assertEquals("FREE", viewModel.uiState.value.examTestSeriesModeMap["ssc"])

        viewModel.selectExamTestSeriesMode("ssc", "PAID")
        assertEquals("PAID", viewModel.uiState.value.examTestSeriesModeMap["ssc"])
        assertTrue(viewModel.uiState.value.isSscFreeTestSectionExpanded)

        viewModel.selectExamTestSeriesMode("ssc", "FREE")
        assertEquals("FREE", viewModel.uiState.value.examTestSeriesModeMap["ssc"])

        viewModel.startSscSectionTest("ssc_gs_history")
        assertEquals("ssc_sec_history_100", viewModel.uiState.value.activeTest.testId)
        assertEquals(100, viewModel.uiState.value.activeTest.questions.size)

        viewModel.startSscSectionTest("ssc_reasoning")
        assertEquals("ssc_sec_reasoning_100", viewModel.uiState.value.activeTest.testId)
        assertEquals(100, viewModel.uiState.value.activeTest.questions.size)

        viewModel.startSscSectionTest("ssc_mathematics")
        assertEquals("ssc_sec_mathematics_100", viewModel.uiState.value.activeTest.testId)
        assertEquals(100, viewModel.uiState.value.activeTest.questions.size)

        viewModel.startSscSectionTest("ssc_english")
        assertEquals("ssc_sec_english_100", viewModel.uiState.value.activeTest.testId)
        assertEquals(100, viewModel.uiState.value.activeTest.questions.size)

        // Verify SSC Exam Section Component tabs (CGL, CHSL, CPO) and subject filter tabs
        assertEquals(3, com.example.ui.components.SscExamSectionCatalog.examTabs.size)
        assertEquals(listOf("CGL", "CHSL", "CPO"), com.example.ui.components.SscExamSectionCatalog.examTabs.map { it.code })
        assertEquals(8, com.example.ui.components.SscExamSectionCatalog.subjectQuizSpecs.size)

        assertEquals("CGL", viewModel.uiState.value.selectedSscExamTab)
        viewModel.selectSscExamTab("CHSL")
        assertEquals("CHSL", viewModel.uiState.value.selectedSscExamTab)
        viewModel.selectSscExamTab("CPO")
        assertEquals("CPO", viewModel.uiState.value.selectedSscExamTab)

        viewModel.selectSscSubjectFilter("GS")
        assertEquals("GS", viewModel.uiState.value.selectedSscSubjectFilter)
        viewModel.selectSscSubjectFilter("REASONING")
        assertEquals("REASONING", viewModel.uiState.value.selectedSscSubjectFilter)
        viewModel.selectSscSubjectFilter("MATH")
        assertEquals("MATH", viewModel.uiState.value.selectedSscSubjectFilter)
        viewModel.selectSscSubjectFilter("ENGLISH")
        assertEquals("ENGLISH", viewModel.uiState.value.selectedSscSubjectFilter)
        viewModel.selectSscSubjectFilter("ALL")
        assertEquals("ALL", viewModel.uiState.value.selectedSscSubjectFilter)
    }

    @Test
    fun testGlobalSearchForExamCategoriesUpscSscBanking() {
        val app = ApplicationProvider.getApplicationContext<Application>()
        val viewModel = ShakuntalamViewModel(app)

        // 1. Search for UPSC
        viewModel.setSearchQuery("UPSC")
        assertEquals("UPSC", viewModel.uiState.value.searchQuery)
        val upscMatches = ExamCatalogData.categories.filter { cat ->
            cat.id.contains("UPSC", ignoreCase = true) ||
                    cat.name.contains("UPSC", ignoreCase = true)
        }
        assertTrue(upscMatches.isNotEmpty())
        assertEquals("upsc", upscMatches.first().id)

        // 2. Search for SSC
        viewModel.setSearchQuery("SSC")
        assertEquals("SSC", viewModel.uiState.value.searchQuery)
        val sscMatches = ExamCatalogData.categories.filter { cat ->
            cat.id.equals("ssc", ignoreCase = true) ||
                    cat.name.contains("SSC CGL", ignoreCase = true)
        }
        assertTrue(sscMatches.isNotEmpty())
        assertEquals("ssc", sscMatches.first().id)

        // 3. Search for Banking
        viewModel.setSearchQuery("Banking")
        assertEquals("Banking", viewModel.uiState.value.searchQuery)
        val bankingMatches = ExamCatalogData.categories.filter { cat ->
            cat.id.contains("banking", ignoreCase = true) ||
                    cat.name.contains("Banking", ignoreCase = true)
        }
        assertTrue(bankingMatches.isNotEmpty())
        assertEquals("banking", bankingMatches.first().id)

        // Clear search
        viewModel.setSearchQuery("")
        assertEquals("", viewModel.uiState.value.searchQuery)
    }

    @Test
    fun testSectionTestProgressForGsReasoningMathAndEnglish() {
        val app = ApplicationProvider.getApplicationContext<Application>()
        val viewModel = ShakuntalamViewModel(app)

        // Initially all 4 pillars are at 0% (Not Started)
        assertEquals(0, viewModel.uiState.value.getSscGsProgress().completionPercent)
        assertEquals("Not Started", viewModel.uiState.value.getSscGsProgress().statusEn)
        assertEquals(0, viewModel.uiState.value.getSscReasoningProgress().completionPercent)
        assertEquals(0, viewModel.uiState.value.getSscMathProgress().completionPercent)
        assertEquals(0, viewModel.uiState.value.getSscEnglishProgress().completionPercent)

        // 1. Answer 25 questions in GS (History)
        viewModel.startSscSectionTest("ssc_gs_history")
        viewModel.uiState.value.activeTest.questions.take(25).forEach { q ->
            viewModel.answerQuestion(q.id, q.correctIndex)
        }
        val histProg = viewModel.uiState.value.getSectionProgress("ssc_sec_history_100", 100)
        assertEquals(25, histProg.answeredCount)
        assertEquals(25, histProg.completionPercent)
        assertEquals("In Progress", histProg.statusEn)
        // Overall GS is 25 / 500 = 5%
        assertEquals(25, viewModel.uiState.value.getSscGsProgress().answeredCount)
        assertEquals(5, viewModel.uiState.value.getSscGsProgress().completionPercent)

        // 2. Switch to Reasoning and answer 40 questions (verify History progress is preserved)
        viewModel.startSscSectionTest("ssc_reasoning")
        viewModel.uiState.value.activeTest.questions.take(40).forEach { q ->
            viewModel.answerQuestion(q.id, q.correctIndex)
        }
        assertEquals(40, viewModel.uiState.value.getSscReasoningProgress().answeredCount)
        assertEquals(40, viewModel.uiState.value.getSscReasoningProgress().completionPercent)
        assertEquals("In Progress", viewModel.uiState.value.getSscReasoningProgress().statusEn)
        assertEquals(25, viewModel.uiState.value.getSectionProgress("ssc_sec_history_100", 100).answeredCount)

        // 3. Switch to Math and answer 60 questions
        viewModel.startSscSectionTest("ssc_mathematics")
        viewModel.uiState.value.activeTest.questions.take(60).forEach { q ->
            viewModel.answerQuestion(q.id, q.correctIndex)
        }
        assertEquals(60, viewModel.uiState.value.getSscMathProgress().answeredCount)
        assertEquals(60, viewModel.uiState.value.getSscMathProgress().completionPercent)
        assertEquals("In Progress", viewModel.uiState.value.getSscMathProgress().statusEn)

        // 4. Switch to English and answer all 100 questions -> 100% Completed
        viewModel.startSscSectionTest("ssc_english")
        viewModel.uiState.value.activeTest.questions.forEach { q ->
            viewModel.answerQuestion(q.id, q.correctIndex)
        }
        val engProg = viewModel.uiState.value.getSscEnglishProgress()
        assertEquals(100, engProg.answeredCount)
        assertEquals(100, engProg.completionPercent)
        assertTrue(engProg.isCompleted)
        assertEquals("Completed", engProg.statusEn)
    }

    @Test
    fun testMainActivityLaunchesAndRendersHomeScreenSmoothly() {
        org.robolectric.Robolectric.buildActivity(MainActivity::class.java).use { controller ->
            controller.setup()
            val activity = controller.get()
            org.junit.Assert.assertNotNull(activity)
            assertFalse(activity.isFinishing)
        }
    }

    @Test
    fun testDashboardCategoryFilterSystemForUpscSscBankingAndStatePsc() {
        val app = ApplicationProvider.getApplicationContext<Application>()
        val viewModel = ShakuntalamViewModel(app)

        // Default is ALL (13 test series visible including TET, IIT JEE, NEET, and UGC NET)
        assertEquals("ALL", viewModel.uiState.value.selectedDashboardCategoryFilter)
        assertEquals(13, viewModel.uiState.value.getVisibleDashboardTestSeriesKeys().size)

        // 1. Filter by UPSC -> only UPSC test series visible
        viewModel.selectDashboardCategoryFilter("UPSC")
        assertEquals("UPSC", viewModel.uiState.value.effectiveDashboardCategoryFilter())
        assertEquals(listOf("upsc"), viewModel.uiState.value.getVisibleDashboardTestSeriesKeys())
        assertTrue(viewModel.uiState.value.isTestSeriesVisibleOnDashboard("upsc"))
        assertFalse(viewModel.uiState.value.isTestSeriesVisibleOnDashboard("ssc"))
        assertFalse(viewModel.uiState.value.isTestSeriesVisibleOnDashboard("banking"))

        // 2. Filter by SSC -> only SSC test series visible
        viewModel.selectDashboardCategoryFilter("SSC")
        assertEquals("SSC", viewModel.uiState.value.effectiveDashboardCategoryFilter())
        assertEquals(listOf("ssc"), viewModel.uiState.value.getVisibleDashboardTestSeriesKeys())
        assertTrue(viewModel.uiState.value.isTestSeriesVisibleOnDashboard("ssc"))
        assertFalse(viewModel.uiState.value.isTestSeriesVisibleOnDashboard("upsc"))

        // 3. Filter by Banking -> only Banking test series visible
        viewModel.selectDashboardCategoryFilter("BANKING")
        assertEquals("BANKING", viewModel.uiState.value.effectiveDashboardCategoryFilter())
        assertEquals(listOf("banking"), viewModel.uiState.value.getVisibleDashboardTestSeriesKeys())
        assertTrue(viewModel.uiState.value.isTestSeriesVisibleOnDashboard("banking"))
        assertFalse(viewModel.uiState.value.isTestSeriesVisibleOnDashboard("ssc"))

        // 4. Filter by State PSC -> UPPCS, UKPSC, and BPSC visible
        viewModel.selectDashboardCategoryFilter("STATE_PSC")
        assertEquals(listOf("uppcs", "ukpsc", "bpsc"), viewModel.uiState.value.getVisibleDashboardTestSeriesKeys())

        // 5. Clear filter -> all 13 test series visible again
        viewModel.clearDashboardCategoryFilter()
        assertEquals("ALL", viewModel.uiState.value.effectiveDashboardCategoryFilter())
        assertEquals(13, viewModel.uiState.value.getVisibleDashboardTestSeriesKeys().size)

        // 6. Verify per-category completion percentage tracking for circular progress indicators
        assertEquals(0, viewModel.uiState.value.getExamCategoryProgress("ssc").completionPercent)
        assertEquals(800, viewModel.uiState.value.getExamCategoryProgress("ssc").totalQuestions)
        assertEquals(350, viewModel.uiState.value.getExamCategoryProgress("upsc").totalQuestions)

        viewModel.selectDashboardCategoryFilter("SSC")
        viewModel.startSscSectionTest("ssc_gs_history")
        viewModel.uiState.value.activeTest.questions.take(80).forEach { q ->
            viewModel.answerQuestion(q.id, q.correctIndex)
        }
        // 80 out of 800 total SSC questions = 10%
        val sscCategoryProg = viewModel.uiState.value.getExamCategoryProgress("ssc")
        assertEquals(80, sscCategoryProg.answeredCount)
        assertEquals(800, sscCategoryProg.totalQuestions)
        assertEquals(10, sscCategoryProg.completionPercent)
        assertEquals("In Progress", sscCategoryProg.statusEn)
        assertEquals(10, viewModel.uiState.value.getVisibleSeriesAggregateProgress().completionPercent)
    }

    @Test
    fun testGlobalSearchByTitleSubjectAndExamCategory() {
        val catalog = com.example.ui.components.GlobalSearchIndexCatalog

        // 1. Search by Subject ("History", "Polity", "Math", "Reasoning", "English")
        val historySeries = catalog.searchSubjectTestSeries("History")
        assertTrue(historySeries.isNotEmpty())
        assertTrue(historySeries.any { it.testId == "ssc_sec_history_100" })
        assertTrue(historySeries.any { it.testId == "upsc_sec_history_50" })

        val mathSeries = catalog.searchSubjectTestSeries("Math")
        assertTrue(mathSeries.isNotEmpty())
        assertTrue(mathSeries.any { it.testId == "ssc_sec_mathematics_100" })

        val reasoningSeries = catalog.searchSubjectTestSeries("Reasoning")
        assertTrue(reasoningSeries.isNotEmpty())
        assertTrue(reasoningSeries.any { it.testId == "ssc_sec_reasoning_100" })

        // 2. Search by combined Exam Category + Subject ("SSC Polity", "UPSC Economy")
        val sscPolitySeries = catalog.searchSubjectTestSeries("SSC Polity")
        assertEquals(1, sscPolitySeries.size)
        assertEquals("ssc_sec_polity_100", sscPolitySeries.first().testId)

        val upscEconomySeries = catalog.searchSubjectTestSeries("UPSC Economy")
        assertEquals(1, upscEconomySeries.size)
        assertEquals("upsc_sec_economics_50", upscEconomySeries.first().testId)

        // 3. Search E-Books & Paid Test Series StudyItems by Title, Subject, or Category
        val app = ApplicationProvider.getApplicationContext<Application>()
        val viewModel = ShakuntalamViewModel(app)
        val studyItems = viewModel.uiState.value.customStudyItems

        val polityStudyMatches = studyItems.filter { catalog.matchesStudyItem(it, "Polity") }
        assertTrue("Should find E-Books/Test Series matching Polity subject", polityStudyMatches.isNotEmpty())

        val upscStudyMatches = studyItems.filter { catalog.matchesStudyItem(it, "UPSC") }
        assertTrue("Should find E-Books/Test Series matching UPSC exam category", upscStudyMatches.isNotEmpty())

        val sscStudyMatches = studyItems.filter { catalog.matchesStudyItem(it, "SSC") }
        assertTrue("Should find E-Books/Test Series matching SSC exam category", sscStudyMatches.isNotEmpty())
    }

    @Test
    fun testQuizRealTimeCountdownTimerAndAutoSubmitOnTimeExpiry() {
        val app = ApplicationProvider.getApplicationContext<Application>()
        val viewModel = ShakuntalamViewModel(app)

        // 1. Start SSC History test -> verify timer initializes to durationMinutes * 60
        viewModel.startSscSectionTest("ssc_gs_history")
        val initialDurationSecs = viewModel.uiState.value.activeTest.durationMinutes * 60
        assertEquals(initialDurationSecs, viewModel.uiState.value.testTotalDurationSeconds)
        assertEquals(initialDurationSecs, viewModel.uiState.value.testTimeRemainingSeconds)
        assertTrue(viewModel.uiState.value.isTestTimerRunning)
        assertFalse(viewModel.uiState.value.isTestTimerPaused)
        assertFalse(viewModel.uiState.value.isTestSubmitted)
        assertFalse(viewModel.uiState.value.isAutoSubmittedOnTimeout)
        assertEquals("NORMAL", viewModel.uiState.value.timerUrgencyLevel())

        // 2. Answer 3 questions correctly
        val firstThree = viewModel.uiState.value.activeTest.questions.take(3)
        firstThree.forEach { q ->
            viewModel.answerQuestion(q.id, q.correctIndex)
        }

        // 3. Tick timer by 1 second and verify countdown + formatting
        viewModel.tickTestTimer(1)
        assertEquals(initialDurationSecs - 1, viewModel.uiState.value.testTimeRemainingSeconds)

        // 4. Pause timer -> verify ticks are ignored while paused, then resume
        viewModel.togglePauseTestTimer()
        assertTrue(viewModel.uiState.value.isTestTimerPaused)
        val pausedRemaining = viewModel.uiState.value.testTimeRemainingSeconds
        viewModel.tickTestTimer(10)
        assertEquals(pausedRemaining, viewModel.uiState.value.testTimeRemainingSeconds)
        viewModel.togglePauseTestTimer()
        assertFalse(viewModel.uiState.value.isTestTimerPaused)

        // 5. Verify WARNING (<= 300s) and CRITICAL (<= 60s) urgency thresholds & MM:SS formatting
        viewModel.setTestTimeRemainingSeconds(240)
        assertEquals("04:00", viewModel.uiState.value.formattedRemainingTime())
        assertEquals("WARNING", viewModel.uiState.value.timerUrgencyLevel())

        viewModel.setTestTimeRemainingSeconds(3)
        assertEquals("00:03", viewModel.uiState.value.formattedRemainingTime())
        assertEquals("CRITICAL", viewModel.uiState.value.timerUrgencyLevel())
        assertFalse(viewModel.uiState.value.isTestSubmitted)

        // 6. Tick 3 seconds to 00:00 -> verify automatic submission on time expiry
        viewModel.tickTestTimer(1)
        assertEquals(2, viewModel.uiState.value.testTimeRemainingSeconds)
        assertFalse(viewModel.uiState.value.isTestSubmitted)

        viewModel.tickTestTimer(1)
        assertEquals(1, viewModel.uiState.value.testTimeRemainingSeconds)
        assertFalse(viewModel.uiState.value.isTestSubmitted)

        viewModel.tickTestTimer(1)
        assertEquals(0, viewModel.uiState.value.testTimeRemainingSeconds)
        assertEquals("00:00", viewModel.uiState.value.formattedRemainingTime())
        assertTrue("Test must auto-submit when countdown reaches 0", viewModel.uiState.value.isTestSubmitted)
        assertTrue("isAutoSubmittedOnTimeout must be true", viewModel.uiState.value.isAutoSubmittedOnTimeout)
        assertFalse("Timer must stop after auto-submission", viewModel.uiState.value.isTestTimerRunning)

        val attempt = viewModel.uiState.value.lastTestAttempt
        org.junit.Assert.assertNotNull(attempt)
        assertEquals(3, attempt!!.correctCount)
        assertEquals(initialDurationSecs, attempt.timeSpentSeconds)
    }

    @Test
    fun testStudentRankSystemAnalyticsChartsAndTopScorerLeaderboard() {
        val app = ApplicationProvider.getApplicationContext<Application>()
        val viewModel = ShakuntalamViewModel(app)

        // Start UPSC Combined PYQ test (10 questions, 20 marks)
        viewModel.selectPyqTestByCategory("upsc")
        val test = viewModel.uiState.value.activeTest
        val questions = test.questions
        assertTrue(questions.size >= 5)

        // Answer first 4 correctly, 1st wrong on 5th question, leave remaining skipped
        questions.take(4).forEach { q ->
            viewModel.answerQuestion(q.id, q.correctIndex)
        }
        val fifthQ = questions[4]
        val wrongOption = (fifthQ.correctIndex + 1) % 4
        viewModel.answerQuestion(fifthQ.id, wrongOption)

        // Simulate 420 seconds spent (7 minutes)
        val totalSecs = test.durationMinutes * 60
        viewModel.setTestTimeRemainingSeconds(totalSecs - 420)
        viewModel.submitTest()

        val attempt = viewModel.uiState.value.lastTestAttempt!!
        assertEquals(4, attempt.correctCount)
        assertEquals(1, attempt.wrongCount)
        assertEquals(questions.size - 5, attempt.unattemptedCount)
        assertEquals(420, attempt.timeSpentSeconds)

        // Generate Complete Test Analytics Report
        val report = com.example.ui.components.TestAnalyticsEngine.generateAnalyticsReport(
            test = test,
            attempt = attempt,
            userAnswers = viewModel.uiState.value.userAnswers,
            studentName = "Bharat Kumar"
        )

        // 1. Verify Rank System on basis of score
        assertTrue(report.rankInfo.allIndiaRank >= 1)
        assertTrue(report.rankInfo.percentile in 0.0..100.0)

        // Verify higher score produces a better (smaller number) All-India Rank
        val highRank = com.example.ui.components.TestAnalyticsEngine.calculateStudentRank(
            score = test.totalMarks * 0.97,
            totalMarks = test.totalMarks,
            correctCount = questions.size,
            wrongCount = 0,
            timeSpentSeconds = 300,
            totalDurationSeconds = totalSecs
        )
        assertEquals(1, highRank.allIndiaRank)
        assertTrue(highRank.isCutoffCleared)
        assertEquals("TOPPER", highRank.rankBadgeCode)

        // 2. Verify Correct, Wrong & Skipped Analysis
        assertEquals(4, report.correctCount)
        assertEquals(1, report.wrongCount)
        assertEquals(questions.size - 5, report.skippedCount)
        assertEquals(80, report.accuracyPercent) // 4 / 5 attempted = 80%

        // 3. Verify Subject-Wise Question Breakdown
        assertTrue(report.subjectBreakdown.isNotEmpty())
        assertEquals(questions.size, report.subjectBreakdown.sumOf { it.totalQuestions })
        assertEquals(4, report.subjectBreakdown.sumOf { it.correctCount })
        assertEquals(1, report.subjectBreakdown.sumOf { it.wrongCount })

        // 4. Verify Difficulty Level Breakdown (Easy, Moderate, Hard)
        assertEquals(3, report.difficultyBreakdown.size)
        assertEquals(questions.size, report.difficultyBreakdown.sumOf { it.totalQuestions })

        // 5. Verify Time Taken Report
        assertEquals(420, report.timeReport.timeSpentSeconds)
        assertEquals(84.0, report.timeReport.avgSecondsPerAttemptedQuestion, 0.1) // 420s / 5 attempted = 84.0s

        // 6. Verify Top Scorer Leaderboard includes current user and is sorted by score descending
        assertTrue(report.leaderboard.isNotEmpty())
        assertTrue(report.leaderboard.any { it.isCurrentUser })
        for (i in 0 until report.leaderboard.size - 1) {
            assertTrue(report.leaderboard[i].score >= report.leaderboard[i + 1].score)
        }
    }

    @Test
    fun testRoomOfflineCachingForEbooksAndTestMaterials() {
        val app = ApplicationProvider.getApplicationContext<Application>()
        val viewModel = ShakuntalamViewModel(app)

        // 1. Verify Entity serialization/deserialization for E-Books (including full chapters)
        val sampleEbook = ExamCatalogData.studyItems.first { it.type == com.example.model.ContentType.EBOOK && it.chapters.isNotEmpty() }
        val ebookEntity = com.example.data.local.entity.OfflineEbookCacheEntity.fromStudyItem(sampleEbook)
        val reconstructedEbook = ebookEntity.toStudyItem()

        assertEquals(sampleEbook.id, reconstructedEbook.id)
        assertEquals(sampleEbook.title, reconstructedEbook.title)
        assertEquals(sampleEbook.hindiTitle, reconstructedEbook.hindiTitle)
        assertEquals(sampleEbook.chapters.size, reconstructedEbook.chapters.size)
        assertEquals(sampleEbook.chapters.first().title, reconstructedEbook.chapters.first().title)
        assertEquals(sampleEbook.chapters.first().content, reconstructedEbook.chapters.first().content)

        // 2. Verify Entity serialization/deserialization for Mock Tests (including bilingual questions & explanations)
        val sampleMockTest = com.example.data.ssc.SscAllSubjectsPyqData.all8SscSectionTests.first().mockTest
        val testEntity = com.example.data.local.entity.OfflineTestCacheEntity.fromMockTest(sampleMockTest)
        val reconstructedTest = testEntity.toMockTest()

        assertEquals(sampleMockTest.testId, reconstructedTest.testId)
        assertEquals(sampleMockTest.title, reconstructedTest.title)
        assertEquals(sampleMockTest.questions.size, reconstructedTest.questions.size)
        assertEquals(sampleMockTest.questions.first().questionEn, reconstructedTest.questions.first().questionEn)
        assertEquals(sampleMockTest.questions.first().questionHi, reconstructedTest.questions.first().questionHi)
        assertEquals(sampleMockTest.questions.first().optionsEn, reconstructedTest.questions.first().optionsEn)
        assertEquals(sampleMockTest.questions.first().explanationEn, reconstructedTest.questions.first().explanationEn)

        // 3. Test ViewModel Room Offline Cache download, removal, and Offline Mode toggle
        viewModel.cacheStudyItemForOffline(sampleEbook)
        assertTrue(viewModel.uiState.value.isEbookCachedOffline(sampleEbook.id))

        viewModel.cacheMockTestForOffline(sampleMockTest)
        assertTrue(viewModel.uiState.value.isTestCachedOffline(sampleMockTest.testId))

        // Toggle Offline Mode ON
        assertFalse(viewModel.uiState.value.isOfflineModeActive)
        viewModel.toggleOfflineMode(true)
        assertTrue(viewModel.uiState.value.isOfflineModeActive)

        // Open cached E-Book offline -> navigates to READER with full chapters intact
        val cachedBookEntity = viewModel.uiState.value.cachedOfflineEbooks.first { it.itemId == sampleEbook.id }
        viewModel.openOfflineCachedEbook(cachedBookEntity)
        assertEquals(com.example.viewmodel.AppScreen.READER, viewModel.uiState.value.currentScreen)
        assertEquals(sampleEbook.id, viewModel.uiState.value.activeReadingItem?.id)
        assertEquals(sampleEbook.id, viewModel.uiState.value.selectedItem?.id)
        assertEquals(sampleEbook.chapters.size, viewModel.uiState.value.activeReadingItem?.chapters?.size)

        // Start cached Test offline -> navigates to TEST_SERIES with full 100 questions intact
        val cachedTestEntity = viewModel.uiState.value.cachedOfflineTests.first { it.testId == sampleMockTest.testId }
        viewModel.startOfflineCachedTest(cachedTestEntity)
        assertEquals(com.example.viewmodel.AppScreen.TEST_SERIES, viewModel.uiState.value.currentScreen)
        assertEquals(sampleMockTest.testId, viewModel.uiState.value.activeTest.testId)
        assertEquals(100, viewModel.uiState.value.activeTest.questions.size)

        // Remove single cached E-Book and Test
        viewModel.removeOfflineCachedEbook(sampleEbook.id)
        assertFalse(viewModel.uiState.value.isEbookCachedOffline(sampleEbook.id))

        viewModel.removeOfflineCachedTest(sampleMockTest.testId)
        assertFalse(viewModel.uiState.value.isTestCachedOffline(sampleMockTest.testId))
    }

    @Test
    fun testDailyStreakTrackingPointsAndBadgesForDailyQuizzes() {
        val app = ApplicationProvider.getApplicationContext<Application>()
        val viewModel = ShakuntalamViewModel(app)
        viewModel.resetDailyStreakState()

        assertEquals(0, viewModel.uiState.value.dailyStreakDays)
        assertEquals(0, viewModel.uiState.value.longestStreakDays)
        assertEquals(0, viewModel.uiState.value.rewardPoints)
        assertTrue(viewModel.uiState.value.unlockedStreakBadgeIds.isEmpty())

        // 1. Day 1 quiz attempt -> 1-day streak & unlocks "badge_first_spark"
        viewModel.recordDailyQuizActivity(dateIso = "2026-11-10", activityPoints = 20)
        assertEquals(1, viewModel.uiState.value.dailyStreakDays)
        assertEquals(1, viewModel.uiState.value.longestStreakDays)
        assertTrue(viewModel.uiState.value.unlockedStreakBadgeIds.contains("badge_first_spark"))
        val day1Points = viewModel.uiState.value.rewardPoints
        assertTrue(day1Points >= 130) // 60 daily streak bonus + 20 activity + 50 badge bonus

        // 2. Second quiz on the same day -> streak remains 1, points increase
        viewModel.recordDailyQuizActivity(dateIso = "2026-11-10", activityPoints = 30)
        assertEquals(1, viewModel.uiState.value.dailyStreakDays)
        assertEquals(day1Points + 30, viewModel.uiState.value.rewardPoints)

        // 3. Consecutive Day 2 & Day 3 quiz attempts -> 3-day streak & unlocks "badge_3_day_warrior"
        viewModel.recordDailyQuizActivity(dateIso = "2026-11-11", activityPoints = 20)
        assertEquals(2, viewModel.uiState.value.dailyStreakDays)
        assertEquals(2, viewModel.uiState.value.longestStreakDays)

        viewModel.recordDailyQuizActivity(dateIso = "2026-11-12", activityPoints = 20)
        assertEquals(3, viewModel.uiState.value.dailyStreakDays)
        assertEquals(3, viewModel.uiState.value.longestStreakDays)
        assertTrue(viewModel.uiState.value.unlockedStreakBadgeIds.contains("badge_3_day_warrior"))

        // 4. Missed a day (jump to 2026-11-14) -> current streak resets to 1, longest streak stays 3
        viewModel.recordDailyQuizActivity(dateIso = "2026-11-14", activityPoints = 20)
        assertEquals(1, viewModel.uiState.value.dailyStreakDays)
        assertEquals(3, viewModel.uiState.value.longestStreakDays)
        assertTrue(viewModel.uiState.value.unlockedStreakBadgeIds.contains("badge_3_day_warrior"))

        // 5. Answering a question in an active quiz automatically records today's streak & points
        val pointsBeforeQuestion = viewModel.uiState.value.rewardPoints
        viewModel.startSscSectionTest("ssc_gs_history")
        val firstQuestion = viewModel.uiState.value.activeTest.questions.first()
        viewModel.answerQuestion(firstQuestion.id, firstQuestion.correctIndex)
        assertTrue(viewModel.uiState.value.isTodayStreakCompleted)
        assertTrue(viewModel.uiState.value.rewardPoints > pointsBeforeQuestion)
    }

    @Test
    fun testIitJeeMainAndAdvancedTenSections100QuestionsEachAndTabStructure() {
        val app = ApplicationProvider.getApplicationContext<Application>()
        val viewModel = ShakuntalamViewModel(app)

        // 1. Verify 10 total IIT JEE subject tests (5 JEE Main + 5 JEE Advanced)
        val allJeeTests = com.example.data.iitjee.IitJeeAllSubjectsPyqData.allIitJeeSectionTests
        val mainSpecs = com.example.data.iitjee.IitJeeAllSubjectsPyqData.getMainSectionSpecs()
        val advSpecs = com.example.data.iitjee.IitJeeAllSubjectsPyqData.getAdvancedSectionSpecs()

        assertEquals(10, allJeeTests.size)
        assertEquals(5, mainSpecs.size)
        assertEquals(5, advSpecs.size)

        // 2. Verify all 5 subjects exist in both JEE Main and JEE Advanced
        val expectedSubjects = setOf("PHYSICS", "PHYSICAL_CHEM", "ORGANIC_CHEM", "INORGANIC_CHEM", "MATHEMATICS")
        assertEquals(expectedSubjects, mainSpecs.map { it.subjectCode }.toSet())
        assertEquals(expectedSubjects, advSpecs.map { it.subjectCode }.toSet())

        // 3. Verify every subject test has 100 bilingual PYQ questions (+4.0 / -1.0 marks)
        allJeeTests.forEach { mock ->
            assertEquals("Test ${mock.testId} must have 100 questions", 100, mock.questions.size)
            assertEquals("Test ${mock.testId} total marks must be 400", 400, mock.totalMarks)
            assertEquals(4.0, mock.positiveMarks, 0.01)
            assertEquals(1.0, mock.negativeMarks, 0.01)

            mock.questions.forEach { q ->
                assertTrue(q.questionEn.isNotBlank())
                assertTrue(q.questionHi.isNotBlank())
                assertEquals(4, q.optionsEn.size)
                assertEquals(4, q.optionsHi.size)
                assertTrue(q.correctIndex in 0..3)
                assertTrue(q.explanationEn.isNotBlank())
                assertTrue(q.explanationHi.isNotBlank())
            }
        }

        // 4. Verify Paid vs Free Test Series mode tabs and JEE Main vs JEE Advanced level tabs
        assertEquals("FREE", viewModel.uiState.value.examTestSeriesModeMap["iit_jee"])
        viewModel.selectExamTestSeriesMode("iit_jee", "PAID")
        assertEquals("PAID", viewModel.uiState.value.examTestSeriesModeMap["iit_jee"])
        viewModel.selectExamTestSeriesMode("iit_jee", "FREE")
        assertEquals("FREE", viewModel.uiState.value.examTestSeriesModeMap["iit_jee"])

        assertEquals("MAIN", viewModel.uiState.value.selectedIitJeeLevelTab)
        viewModel.selectIitJeeLevelTab("ADVANCED")
        assertEquals("ADVANCED", viewModel.uiState.value.selectedIitJeeLevelTab)
        viewModel.selectIitJeeLevelTab("MAIN")
        assertEquals("MAIN", viewModel.uiState.value.selectedIitJeeLevelTab)

        // 5. Verify subject filter switching and starting both JEE Main and JEE Advanced subject tests
        viewModel.selectIitJeeSubjectFilter("PHYSICS")
        assertEquals("PHYSICS", viewModel.uiState.value.selectedIitJeeSubjectFilter)

        viewModel.startIitJeeSectionTest("jee_main_physics")
        assertEquals(com.example.viewmodel.AppScreen.TEST_SERIES, viewModel.uiState.value.currentScreen)
        assertEquals("jee_main_sec_physics_100", viewModel.uiState.value.activeTest.testId)
        assertEquals(100, viewModel.uiState.value.activeTest.questions.size)

        viewModel.startIitJeeSectionTest("jee_adv_organic_chem")
        assertEquals("jee_adv_sec_organic_chem_100", viewModel.uiState.value.activeTest.testId)
        assertEquals(100, viewModel.uiState.value.activeTest.questions.size)

        // 6. Verify dashboard category filter for IIT_JEE
        viewModel.selectDashboardCategoryFilter("IIT_JEE")
        assertEquals(listOf("iit_jee"), viewModel.uiState.value.getVisibleDashboardTestSeriesKeys())
        assertEquals(1000, viewModel.uiState.value.getExamCategoryProgress("iit_jee").totalQuestions)
    }

    @Test
    fun testNeetUgSixSubjects100QuestionsEachAndTabStructure() {
        val app = ApplicationProvider.getApplicationContext<Application>()
        val viewModel = ShakuntalamViewModel(app)

        // 1. Verify 6 total NEET (UG) subject tests (Physics, Physical Chem, Organic Chem, Inorganic Chem, Botany, Zoology)
        val allNeetTests = com.example.data.neet.NeetAllSubjectsPyqData.allNeetSectionTests
        val neetSpecs = com.example.data.neet.NeetAllSubjectsPyqData.sectionSpecs

        assertEquals(6, allNeetTests.size)
        assertEquals(6, neetSpecs.size)

        val expectedSubjects = setOf("PHYSICS", "PHYSICAL_CHEM", "ORGANIC_CHEM", "INORGANIC_CHEM", "BOTANY", "ZOOLOGY")
        assertEquals(expectedSubjects, neetSpecs.map { it.subjectCode }.toSet())

        // 2. Verify every NEET subject test has 100 bilingual PYQ questions (+4.0 / -1.0 marks, 400 total marks)
        allNeetTests.forEach { mock ->
            assertEquals("Test ${mock.testId} must have 100 questions", 100, mock.questions.size)
            assertEquals("Test ${mock.testId} total marks must be 400", 400, mock.totalMarks)
            assertEquals(4.0, mock.positiveMarks, 0.01)
            assertEquals(1.0, mock.negativeMarks, 0.01)

            mock.questions.forEach { q ->
                assertTrue(q.questionEn.isNotBlank())
                assertTrue(q.questionHi.isNotBlank())
                assertEquals(4, q.optionsEn.size)
                assertEquals(4, q.optionsHi.size)
                assertTrue(q.correctIndex in 0..3)
                assertTrue(q.explanationEn.isNotBlank())
                assertTrue(q.explanationHi.isNotBlank())
            }
        }

        // 3. Verify Paid vs Free Test Series mode tabs for NEET
        assertEquals("FREE", viewModel.uiState.value.examTestSeriesModeMap["neet"])
        viewModel.selectExamTestSeriesMode("neet", "PAID")
        assertEquals("PAID", viewModel.uiState.value.examTestSeriesModeMap["neet"])
        viewModel.selectExamTestSeriesMode("neet", "FREE")
        assertEquals("FREE", viewModel.uiState.value.examTestSeriesModeMap["neet"])

        // 4. Verify NEET subject filter switching and starting subject tests
        viewModel.selectNeetSubjectFilter("BOTANY")
        assertEquals("BOTANY", viewModel.uiState.value.selectedNeetSubjectFilter)

        viewModel.startNeetSectionTest("neet_botany")
        assertEquals(com.example.viewmodel.AppScreen.TEST_SERIES, viewModel.uiState.value.currentScreen)
        assertEquals("neet_sec_botany_100", viewModel.uiState.value.activeTest.testId)
        assertEquals(100, viewModel.uiState.value.activeTest.questions.size)

        viewModel.startNeetSectionTest("neet_zoology")
        assertEquals("neet_sec_zoology_100", viewModel.uiState.value.activeTest.testId)
        assertEquals(100, viewModel.uiState.value.activeTest.questions.size)

        // 5. Verify dashboard category filter for NEET (600 total questions)
        viewModel.selectDashboardCategoryFilter("NEET")
        assertEquals(listOf("neet"), viewModel.uiState.value.getVisibleDashboardTestSeriesKeys())
        assertEquals(600, viewModel.uiState.value.getExamCategoryProgress("neet").totalQuestions)
    }

    @Test
    fun testUgcNetPaper1TenUnitsAndPaper2TwelveSubjects100McqsEach() {
        val app = ApplicationProvider.getApplicationContext<Application>()
        val viewModel = ShakuntalamViewModel(app)

        // 1. Verify 22 total UGC NET 100-MCQ tests (10 Paper 1 Units + 12 Paper 2 Subjects = 2,200 PYQ MCQs)
        val allUgcTests = com.example.data.ugcnet.UgcNetAllSubjectsPyqData.allUgcNetSectionTests
        val paper1Specs = com.example.data.ugcnet.UgcNetAllSubjectsPyqData.getPaper1UnitSpecs()
        val paper2Specs = com.example.data.ugcnet.UgcNetAllSubjectsPyqData.getPaper2SubjectSpecs()

        assertEquals(22, allUgcTests.size)
        assertEquals(10, paper1Specs.size)
        assertEquals(12, paper2Specs.size)

        // 2. Verify all 10 Paper 1 Units and all 12 Paper 2 Subjects
        val expectedPaper1Units = (1..10).map { "UNIT_$it" }.toSet()
        assertEquals(expectedPaper1Units, paper1Specs.map { it.unitOrSubjectCode }.toSet())

        val expectedPaper2Subjects = setOf(
            "HISTORY",
            "POL_SCIENCE",
            "GEOGRAPHY",
            "ECONOMICS",
            "HINDI",
            "ENGLISH",
            "COMMERCE",
            "MANAGEMENT",
            "SOCIOLOGY",
            "EDUCATION",
            "COMPUTER_SCI",
            "LAW"
        )
        assertEquals(expectedPaper2Subjects, paper2Specs.map { it.unitOrSubjectCode }.toSet())

        // 3. Verify every UGC NET test has 100 bilingual PYQ questions (+2.0 marks, 0.0 negative, 200 total marks)
        allUgcTests.forEach { mock ->
            assertEquals("Test ${mock.testId} must have 100 questions", 100, mock.questions.size)
            assertEquals("Test ${mock.testId} total marks must be 200", 200, mock.totalMarks)
            assertEquals(2.0, mock.positiveMarks, 0.01)
            assertEquals(0.0, mock.negativeMarks, 0.01)

            mock.questions.forEach { q ->
                assertTrue(q.questionEn.isNotBlank())
                assertTrue(q.questionHi.isNotBlank())
                assertEquals(4, q.optionsEn.size)
                assertEquals(4, q.optionsHi.size)
                assertTrue(q.correctIndex in 0..3)
                assertTrue(q.explanationEn.isNotBlank())
                assertTrue(q.explanationHi.isNotBlank())
            }
        }

        // 4. Verify Paid vs Free Test Series mode tabs and Paper 1 vs Paper 2 tabs
        assertEquals("FREE", viewModel.uiState.value.examTestSeriesModeMap["ugc_net"])
        viewModel.selectExamTestSeriesMode("ugc_net", "PAID")
        assertEquals("PAID", viewModel.uiState.value.examTestSeriesModeMap["ugc_net"])
        viewModel.selectExamTestSeriesMode("ugc_net", "FREE")
        assertEquals("FREE", viewModel.uiState.value.examTestSeriesModeMap["ugc_net"])

        assertEquals("PAPER_1", viewModel.uiState.value.selectedUgcNetPaperTab)
        viewModel.selectUgcNetPaperTab("PAPER_2")
        assertEquals("PAPER_2", viewModel.uiState.value.selectedUgcNetPaperTab)
        viewModel.selectUgcNetPaperTab("PAPER_1")
        assertEquals("PAPER_1", viewModel.uiState.value.selectedUgcNetPaperTab)

        // 5. Verify starting Paper 1 Unit test and Paper 2 Subject test
        viewModel.startUgcNetSectionTest("ugc_p1_unit1_teaching")
        assertEquals(com.example.viewmodel.AppScreen.TEST_SERIES, viewModel.uiState.value.currentScreen)
        assertEquals("ugc_p1_sec_unit1_100", viewModel.uiState.value.activeTest.testId)
        assertEquals(100, viewModel.uiState.value.activeTest.questions.size)

        viewModel.startUgcNetSectionTest("ugc_p2_history")
        assertEquals("ugc_p2_sec_history_100", viewModel.uiState.value.activeTest.testId)
        assertEquals(100, viewModel.uiState.value.activeTest.questions.size)

        // 6. Verify dashboard category filter for UGC_NET (2,200 total questions)
        viewModel.selectDashboardCategoryFilter("UGC_NET")
        assertEquals(listOf("ugc_net"), viewModel.uiState.value.getVisibleDashboardTestSeriesKeys())
        assertEquals(2200, viewModel.uiState.value.getExamCategoryProgress("ugc_net").totalQuestions)
    }

    @Test
    fun testTetCtetUptetUtetSevenSubjects100QuestionsEachAndTabStructure() {
        val app = ApplicationProvider.getApplicationContext<Application>()
        val viewModel = ShakuntalamViewModel(app)

        // 1. Verify 7 total TET 100-MCQ subject tests (CDP, EVS, Maths, Science, Social Science, Hindi, English/Sanskrit = 700 PYQ MCQs)
        val allTetTests = com.example.data.tet.TetAllSubjectsPyqData.allTetSectionTests
        val tetSpecs = com.example.data.tet.TetAllSubjectsPyqData.allSpecs

        assertEquals(7, allTetTests.size)
        assertEquals(7, tetSpecs.size)

        val expectedSubjects = setOf("CDP", "EVS", "MATHS", "SCIENCE", "SOCIAL_SCIENCE", "HINDI", "ENGLISH_SANSKRIT")
        assertEquals(expectedSubjects, tetSpecs.map { it.subjectCode }.toSet())

        // 2. Verify every TET subject test has 100 bilingual PYQ questions (+1.0 mark, 0.0 negative, 100 total marks)
        allTetTests.forEach { mock ->
            assertEquals("Test ${mock.testId} must have 100 questions", 100, mock.questions.size)
            assertEquals("Test ${mock.testId} total marks must be 100", 100, mock.totalMarks)
            assertEquals(1.0, mock.positiveMarks, 0.01)
            assertEquals(0.0, mock.negativeMarks, 0.01)

            mock.questions.forEach { q ->
                assertTrue(q.questionEn.isNotBlank())
                assertTrue(q.questionHi.isNotBlank())
                assertEquals(4, q.optionsEn.size)
                assertEquals(4, q.optionsHi.size)
                assertTrue(q.correctIndex in 0..3)
                assertTrue(q.explanationEn.isNotBlank())
                assertTrue(q.explanationHi.isNotBlank())
            }
        }

        // 3. Verify Paid vs Free Test Series mode tabs and CTET / UPTET / UTET exam tabs
        assertEquals("FREE", viewModel.uiState.value.examTestSeriesModeMap["tet"])
        viewModel.selectExamTestSeriesMode("tet", "PAID")
        assertEquals("PAID", viewModel.uiState.value.examTestSeriesModeMap["tet"])
        viewModel.selectExamTestSeriesMode("tet", "FREE")
        assertEquals("FREE", viewModel.uiState.value.examTestSeriesModeMap["tet"])

        assertEquals("CTET", viewModel.uiState.value.selectedTetExamTab)
        viewModel.selectTetExamTab("UPTET")
        assertEquals("UPTET", viewModel.uiState.value.selectedTetExamTab)
        viewModel.selectTetExamTab("UTET")
        assertEquals("UTET", viewModel.uiState.value.selectedTetExamTab)
        viewModel.selectTetExamTab("CTET")
        assertEquals("CTET", viewModel.uiState.value.selectedTetExamTab)

        // 4. Verify TET subject filter switching and starting subject tests
        viewModel.selectTetSubjectFilter("CDP")
        assertEquals("CDP", viewModel.uiState.value.selectedTetSubjectFilter)
        viewModel.selectTetSubjectFilter("EVS")
        assertEquals("EVS", viewModel.uiState.value.selectedTetSubjectFilter)

        viewModel.startTetSectionTest("tet_cdp")
        assertEquals(com.example.viewmodel.AppScreen.TEST_SERIES, viewModel.uiState.value.currentScreen)
        assertEquals("tet_sec_cdp_100", viewModel.uiState.value.activeTest.testId)
        assertEquals(100, viewModel.uiState.value.activeTest.questions.size)

        viewModel.startTetSectionTest("tet_social_science")
        assertEquals("tet_sec_social_science_100", viewModel.uiState.value.activeTest.testId)
        assertEquals(100, viewModel.uiState.value.activeTest.questions.size)

        // 5. Verify dashboard category filter for TET / CTET (700 total questions)
        viewModel.selectDashboardCategoryFilter("TET")
        assertEquals(listOf("tet"), viewModel.uiState.value.getVisibleDashboardTestSeriesKeys())
        assertEquals(700, viewModel.uiState.value.getExamCategoryProgress("tet").totalQuestions)
    }

    @Test
    fun testFirstLaunchOtpLoginTwoFieldAccountSetupLeaderboardAndProgressTracker() {
        val app = ApplicationProvider.getApplicationContext<Application>()
        val viewModel = ShakuntalamViewModel(app)
        viewModel.logout()

        // 1. Verify First-Launch Login Gate opens automatically when not logged in
        assertFalse(viewModel.uiState.value.isLoggedIn)
        assertTrue(viewModel.uiState.value.isAuthModalOpen)

        // 2. Test Phone Number + OTP Authentication
        viewModel.switchAuthTab(com.example.model.AuthTab.PHONE_OTP)
        viewModel.updatePhoneNumber("9876543210")
        viewModel.sendPhoneOtp()
        assertTrue(viewModel.uiState.value.phoneOtpState.isOtpSent)
        viewModel.updateOtpCode("123456")
        viewModel.verifyPhoneOtp()

        // Immediately after OTP verification, user is logged in and prompted on Dashboard for 2 fields
        assertTrue(viewModel.uiState.value.isLoggedIn)
        assertFalse(viewModel.uiState.value.isAuthModalOpen)
        assertTrue(viewModel.uiState.value.isAccountSetupModalOpen)
        assertEquals("+91 9876543210", viewModel.uiState.value.currentUser?.phoneNumber)

        // 3. Test Email ID + OTP Authentication as well
        viewModel.logout()
        assertFalse(viewModel.uiState.value.isLoggedIn)
        assertTrue(viewModel.uiState.value.isAuthModalOpen)

        viewModel.switchAuthTab(com.example.model.AuthTab.EMAIL_OTP)
        viewModel.updateEmailForOtp("rahul.aspirant@gmail.com")
        viewModel.sendEmailOtp()
        assertTrue(viewModel.uiState.value.phoneOtpState.isOtpSent)
        viewModel.updateOtpCode("123456")
        viewModel.verifyEmailOtp()

        assertTrue(viewModel.uiState.value.isLoggedIn)
        assertFalse(viewModel.uiState.value.isAuthModalOpen)
        assertTrue(viewModel.uiState.value.isAccountSetupModalOpen)
        assertEquals("rahul.aspirant@gmail.com", viewModel.uiState.value.currentUser?.email)
        assertEquals(com.example.model.AuthProviderType.EMAIL_OTP, viewModel.uiState.value.currentUser?.provider)

        // 4. Complete Post-Login 2-Field Account Setup on Dashboard (1. Student Name + 2. Target Exam)
        viewModel.completeStudentAccountSetup(
            studentName = "Rahul Verma",
            targetExam = "CTET / UPTET / UTET"
        )
        assertFalse(viewModel.uiState.value.isAccountSetupModalOpen)
        assertEquals("Rahul Verma", viewModel.uiState.value.currentUser?.name)
        assertEquals("R", viewModel.uiState.value.currentUser?.avatarLetter)
        assertEquals("CTET / UPTET / UTET", viewModel.uiState.value.currentUser?.targetExam)
        assertTrue(viewModel.uiState.value.currentUser?.isAccountSetupCompleted == true)

        // 5. Verify Student's Created Account appears in the Dashboard Live Leaderboard
        val initialLeaderboard = viewModel.uiState.value.getLiveDashboardLeaderboard()
        val userLeaderboardEntry = initialLeaderboard.firstOrNull { it.isCurrentUser }
        org.junit.Assert.assertNotNull(userLeaderboardEntry)
        assertEquals("Rahul Verma", userLeaderboardEntry!!.studentName)
        assertEquals("CTET / UPTET / UTET", userLeaderboardEntry.targetExam)

        // 6. Verify Strengthened Progress Tracker tracks Target Exam ("tet") & updates as questions are solved
        val initialProgress = viewModel.uiState.value.getMasterProgressSummary()
        assertEquals("Rahul Verma", initialProgress.studentName)
        assertEquals("CTET / UPTET / UTET", initialProgress.targetExam)
        assertEquals("tet", initialProgress.targetExamKey)
        assertTrue(initialProgress.examBreakdown.first().isTargetExam)
        assertEquals("tet", initialProgress.examBreakdown.first().examKey)

        // Solve 30 questions in TET CDP and submit test -> verify Progress Tracker & Leaderboard Rank improve
        viewModel.startTetSectionTest("tet_cdp")
        viewModel.uiState.value.activeTest.questions.take(30).forEach { q ->
            viewModel.answerQuestion(q.id, q.correctIndex)
        }
        viewModel.submitTest()

        val updatedProgress = viewModel.uiState.value.getMasterProgressSummary()
        assertTrue(updatedProgress.totalQuestionsSolved >= 30)
        assertEquals(30, updatedProgress.targetExamProgress.answeredCount)
        assertTrue(updatedProgress.testsCompletedCount >= 1)
        assertEquals(100, updatedProgress.overallAccuracyPercent)
        assertTrue(updatedProgress.liveScorePoints > initialProgress.liveScorePoints)
        assertTrue(updatedProgress.liveAllIndiaRank < initialProgress.liveAllIndiaRank)

        // Verify Post-Test Scorecard Leaderboard also displays the exact created Account Name & Target Exam
        val postTestReport = com.example.ui.components.TestAnalyticsEngine.generateAnalyticsReport(
            test = viewModel.uiState.value.activeTest,
            attempt = viewModel.uiState.value.lastTestAttempt!!,
            userAnswers = viewModel.uiState.value.userAnswers,
            studentName = viewModel.uiState.value.currentUser!!.name,
            studentTargetExam = viewModel.uiState.value.currentUser!!.targetExam
        )
        val postTestUserRow = postTestReport.leaderboard.first { it.isCurrentUser }
        assertTrue(postTestUserRow.studentName.contains("Rahul Verma"))
        assertTrue(postTestUserRow.stateOrCenter.contains("CTET / UPTET / UTET"))

        // 7. Verify unified Firebase Auth OTP initiation (initiateFirebaseOtp) for both Phone and Email
        viewModel.logout()
        viewModel.updatePhoneNumber("9123456789")
        viewModel.initiateFirebaseOtp()
        assertTrue(viewModel.uiState.value.phoneOtpState.isOtpSent)
        assertTrue(
            viewModel.uiState.value.phoneOtpState.firebaseAuthStatusMessage
                ?.contains("Firebase Auth Phone OTP initiated") == true
        )
        viewModel.onFirebasePhoneVerificationIdReceived("verif_id_test_001")
        assertEquals("verif_id_test_001", viewModel.uiState.value.phoneOtpState.firebaseVerificationId)

        viewModel.logout()
        viewModel.switchAuthTab(com.example.model.AuthTab.EMAIL_OTP)
        viewModel.updateEmailForOtp("firebase.student@gmail.com")
        viewModel.initiateFirebaseOtp()
        assertTrue(viewModel.uiState.value.phoneOtpState.isOtpSent)
        assertTrue(
            viewModel.uiState.value.phoneOtpState.firebaseAuthStatusMessage
                ?.contains("Firebase Auth Email OTP initiated") == true
        )

        // 8. Verify Preferred Exam Options catalog for StudentProfileSetupScreen
        val preferredSpecs = com.example.ui.screens.PREFERRED_EXAM_SPECS
        assertTrue(preferredSpecs.size >= 13)
        assertTrue(preferredSpecs.any { it.examName == "IIT JEE (Main & Advanced)" })
        assertTrue(preferredSpecs.any { it.examName == "NEET (UG) Medical" })
        assertTrue(preferredSpecs.any { it.examName == "UGC NET (Paper 1 & 2)" })
        assertTrue(preferredSpecs.any { it.examName == "CTET / UPTET / UTET" })
    }

    @Test
    fun testCountdownTimerRealExamConditionsAndPerformancePacingTelemetry() {
        val app = ApplicationProvider.getApplicationContext<Application>()
        val viewModel = ShakuntalamViewModel(app)

        // 1. Start a 100-question SSC test and verify initial countdown state
        viewModel.startSscSectionTest("ssc_gs_polity")
        val initialState = viewModel.uiState.value
        val firstQ = initialState.activeTest.questions[0]
        val secondQ = initialState.activeTest.questions[1]
        assertTrue(initialState.isTestTimerRunning)
        assertFalse(initialState.isTestTimerPaused)
        assertFalse(initialState.isStrictExamSimulationMode)
        assertEquals(0, initialState.elapsedTestTimeSeconds())
        assertEquals(0, initialState.currentQuestionTimeSpentSeconds())

        // 2. Tick 15 seconds on Question 1 and answer it -> verify per-question time & pacing telemetry
        viewModel.tickTestTimer(15)
        assertEquals(15, viewModel.uiState.value.currentQuestionTimeSpentSeconds())
        assertEquals(15, viewModel.uiState.value.questionTimeSpentSeconds[firstQ.id])
        viewModel.answerQuestion(firstQ.id, firstQ.correctIndex)
        assertEquals(15, viewModel.uiState.value.averageSecondsPerAnsweredQuestion())
        assertEquals("AHEAD_OF_PACE", viewModel.uiState.value.examPacingStatus())

        // 3. Move to Question 2 and tick 90 seconds -> verify per-question stopwatch isolates Q2
        viewModel.setQuestionIndex(1)
        viewModel.tickTestTimer(90)
        assertEquals(15, viewModel.uiState.value.questionTimeSpentSeconds[firstQ.id])
        assertEquals(90, viewModel.uiState.value.questionTimeSpentSeconds[secondQ.id])
        assertEquals(90, viewModel.uiState.value.currentQuestionTimeSpentSeconds())
        assertEquals(105, viewModel.uiState.value.elapsedTestTimeSeconds())

        // 4. Test Custom Exam Duration Preset (30 minutes = 1800 seconds) and Reset Timer
        viewModel.setCustomExamDurationMinutes(30)
        assertEquals(1800, viewModel.uiState.value.testTotalDurationSeconds)
        assertEquals(1800, viewModel.uiState.value.testTimeRemainingSeconds)
        assertEquals("30:00", viewModel.uiState.value.formattedRemainingTime())

        viewModel.tickTestTimer(40)
        assertEquals(1760, viewModel.uiState.value.testTimeRemainingSeconds)
        viewModel.resetActiveTestTimer()
        assertEquals(1800, viewModel.uiState.value.testTimeRemainingSeconds)
        assertTrue(viewModel.uiState.value.questionTimeSpentSeconds.isEmpty())

        // 5. Verify Strict CBT Exam Mode locks pausing the countdown timer
        viewModel.toggleStrictExamSimulationMode()
        assertTrue(viewModel.uiState.value.isStrictExamSimulationMode)
        viewModel.togglePauseTestTimer()
        assertFalse("Strict CBT mode must prevent pausing timer", viewModel.uiState.value.isTestTimerPaused)

        // Switch back to Practice Mode -> pausing works again
        viewModel.toggleStrictExamSimulationMode()
        assertFalse(viewModel.uiState.value.isStrictExamSimulationMode)
        viewModel.togglePauseTestTimer()
        assertTrue(viewModel.uiState.value.isTestTimerPaused)
        viewModel.togglePauseTestTimer()
        assertFalse(viewModel.uiState.value.isTestTimerPaused)

        // 6. Verify urgency levels (WARNING <= 300s, CRITICAL <= 60s) and Auto-Submit at 00:00
        viewModel.setTestTimeRemainingSeconds(240)
        assertEquals("WARNING", viewModel.uiState.value.timerUrgencyLevel())
        viewModel.setTestTimeRemainingSeconds(45)
        assertEquals("CRITICAL", viewModel.uiState.value.timerUrgencyLevel())
        viewModel.tickTestTimer(45)
        assertTrue(viewModel.uiState.value.isTestSubmitted)
        assertTrue(viewModel.uiState.value.isAutoSubmittedOnTimeout)
        assertEquals(0, viewModel.uiState.value.testTimeRemainingSeconds)
        assertEquals(1800, viewModel.uiState.value.lastTestAttempt?.timeSpentSeconds)
    }

    @Test
    fun testPerformanceAnalyticsScreenHistoricalScoresAccuracyAndTimePerQuestion() {
        val app = ApplicationProvider.getApplicationContext<Application>()
        val viewModel = ShakuntalamViewModel(app)

        // 1. Navigate to Performance Analytics screen and verify navigation state
        viewModel.openPerformanceAnalytics()
        assertEquals(com.example.viewmodel.AppScreen.PERFORMANCE_ANALYTICS, viewModel.uiState.value.currentScreen)

        // 2. Verify initial multi-point historical timeline & improvement telemetry
        val initialSummary = com.example.ui.screens.PerformanceAnalyticsEngine.buildAnalyticsSummary(
            viewModel.uiState.value
        )
        assertTrue(initialSummary.timelinePoints.size >= 4)
        assertTrue(initialSummary.averageScorePercent > 0f)
        assertTrue(initialSummary.averageAccuracyPercent > 0f)
        assertTrue(initialSummary.averageTimePerQuestionSeconds > 0f)
        assertTrue(initialSummary.scoreImprovementDeltaPercent > 0f)
        assertTrue(initialSummary.accuracyImprovementDeltaPercent > 0f)
        assertTrue(initialSummary.timePerQuestionReductionSeconds > 0f)

        // 3. Log sample improvement attempts and verify timeline & metrics improve over time
        viewModel.recordSampleImprovementAttempt()
        viewModel.recordSampleImprovementAttempt()
        val updatedSummary = com.example.ui.screens.PerformanceAnalyticsEngine.buildAnalyticsSummary(
            viewModel.uiState.value
        )
        assertEquals(2, viewModel.uiState.value.testAttemptsHistory.size)
        assertTrue(updatedSummary.timelinePoints.any { it.isLiveUserAttempt })
        assertTrue(updatedSummary.latestScorePercent > initialSummary.timelinePoints.first().scorePercent)
        assertTrue(updatedSummary.latestAccuracyPercent > initialSummary.timelinePoints.first().accuracyPercent)
        assertTrue(updatedSummary.latestTimePerQuestionSeconds < initialSummary.timelinePoints.first().timeSpentPerQuestionSeconds)

        // 4. Verify back navigation returns from PERFORMANCE_ANALYTICS to HOME
        assertTrue(viewModel.navigateBack())
        assertEquals(com.example.viewmodel.AppScreen.HOME, viewModel.uiState.value.currentScreen)
    }

    @Test
    fun testDailyQuizSingleHighYieldQuestionRandomSubjectAndImmediateExplanation() {
        val app = ApplicationProvider.getApplicationContext<Application>()
        val viewModel = ShakuntalamViewModel(app)
        viewModel.resetDailyStreakState()

        // 1. Verify initial Daily Quiz high-yield question is loaded and unsubmitted
        val initialQ = viewModel.uiState.value.dailyQuizQuestion
        assertTrue(initialQ.questionEn.isNotBlank())
        assertTrue(initialQ.questionHi.isNotBlank())
        assertTrue(initialQ.explanationEn.isNotBlank())
        assertTrue(initialQ.explanationHi.isNotBlank())
        assertEquals(4, initialQ.optionsEn.size)
        assertFalse(viewModel.uiState.value.isDailyQuizSubmitted)
        assertFalse(viewModel.uiState.value.isDailyQuizExplanationVisible)

        // 2. Select the correct option and submit -> verify immediate detailed explanation & daily streak reward
        viewModel.selectDailyQuizOption(initialQ.correctIndex)
        assertEquals(initialQ.correctIndex, viewModel.uiState.value.dailyQuizSelectedOptionIndex)

        val pointsBefore = viewModel.uiState.value.rewardPoints
        viewModel.submitDailyQuizAnswer(dateIso = "2026-11-17")
        assertTrue(viewModel.uiState.value.isDailyQuizSubmitted)
        assertTrue(viewModel.uiState.value.isDailyQuizExplanationVisible)
        assertTrue(viewModel.uiState.value.rewardPoints >= pointsBefore + 50)
        assertEquals(1, viewModel.uiState.value.dailyStreakDays)

        // 3. Toggle detailed explanation visibility ON/OFF after submission
        viewModel.toggleDailyQuizExplanation()
        assertFalse(viewModel.uiState.value.isDailyQuizExplanationVisible)
        viewModel.toggleDailyQuizExplanation()
        assertTrue(viewModel.uiState.value.isDailyQuizExplanationVisible)

        // 4. Shuffle to another random subject -> verify subject changes and state resets for fresh practice
        viewModel.shuffleDailyQuizQuestion()
        val nextQ = viewModel.uiState.value.dailyQuizQuestion
        org.junit.Assert.assertNotEquals(initialQ.id, nextQ.id)
        org.junit.Assert.assertNotEquals(initialQ.subject, nextQ.subject)
        assertFalse(viewModel.uiState.value.isDailyQuizSubmitted)
        assertFalse(viewModel.uiState.value.isDailyQuizExplanationVisible)
        org.junit.Assert.assertNull(viewModel.uiState.value.dailyQuizSelectedOptionIndex)

        // 5. Verify full-screen Daily Quiz navigation
        viewModel.openDailyQuiz()
        assertEquals(com.example.viewmodel.AppScreen.DAILY_QUIZ, viewModel.uiState.value.currentScreen)
        assertTrue(viewModel.navigateBack())
        assertEquals(com.example.viewmodel.AppScreen.HOME, viewModel.uiState.value.currentScreen)
    }

    @Test
    fun testSubscription9Monthly99YearlyAutoExpiryAndStructuredOneLinerExplanation() {
        val app = ApplicationProvider.getApplicationContext<Application>()
        val viewModel = ShakuntalamViewModel(app)
        val nowMillis = 1_800_000_000_000L

        // 1. Subscribe to ₹9/Month (30 days) Netflix-style All-Access Pass
        viewModel.subscribeToPlan("MONTHLY_9", nowMillis)
        assertTrue(viewModel.uiState.value.isSubscriptionActive)
        assertEquals("MONTHLY_9", viewModel.uiState.value.subscriptionPlanCode)
        assertTrue(viewModel.uiState.value.isAllAccessSubscriptionValid(nowMillis))
        assertEquals(30, viewModel.uiState.value.getRemainingSubscriptionDays(nowMillis))

        // Switch exam tabs to PAID mode while subscribed
        viewModel.selectExamTestSeriesMode("upsc", "PAID")
        viewModel.selectExamTestSeriesMode("ssc", "PAID")
        assertEquals("PAID", viewModel.uiState.value.examTestSeriesModeMap["upsc"])
        assertEquals("PAID", viewModel.uiState.value.examTestSeriesModeMap["ssc"])

        // 2. Advance past 30 days -> verify automatic expiry & Paid section re-locking
        val after30DaysMillis = nowMillis + (30L * 24L * 60L * 60L * 1000L) + 1000L
        assertTrue(viewModel.checkAndExpireSubscription(after30DaysMillis))
        assertFalse(viewModel.uiState.value.isSubscriptionActive)
        assertEquals("NONE", viewModel.uiState.value.subscriptionPlanCode)
        assertEquals(0, viewModel.uiState.value.getRemainingSubscriptionDays(after30DaysMillis))
        assertEquals("FREE", viewModel.uiState.value.examTestSeriesModeMap["upsc"])
        assertEquals("FREE", viewModel.uiState.value.examTestSeriesModeMap["ssc"])

        // 3. Subscribe to ₹99/Year (365 days) All-Access Pass & verify 365-day expiry
        viewModel.subscribeToPlan("YEARLY_99", nowMillis)
        assertTrue(viewModel.uiState.value.isSubscriptionActive)
        assertEquals("YEARLY_99", viewModel.uiState.value.subscriptionPlanCode)
        assertEquals(365, viewModel.uiState.value.getRemainingSubscriptionDays(nowMillis))

        viewModel.selectExamTestSeriesMode("iit_jee", "PAID")
        val after365DaysMillis = nowMillis + (365L * 24L * 60L * 60L * 1000L) + 1000L
        assertTrue(viewModel.checkAndExpireSubscription(after365DaysMillis))
        assertFalse(viewModel.uiState.value.isSubscriptionActive)
        assertEquals("FREE", viewModel.uiState.value.examTestSeriesModeMap["iit_jee"])

        // 4. Verify Standardized 4-to-5 One-Liner Facts Explanation & Single PYQ Footer across Test Series
        val sampleQuestion = viewModel.uiState.value.activeTest.questions.first()
        val structured = com.example.ui.components.ProfessionalQuestionFormatEngine
            .buildStructuredExplanation(sampleQuestion)

        assertTrue(structured.correctLetter in listOf("A", "B", "C", "D"))
        assertTrue(structured.correctOptionEn.isNotBlank())
        assertTrue(structured.correctOptionHi.isNotBlank())
        assertTrue("Hindi facts must have 4 to 5 one-liners", structured.hindiOneLinerFacts.size in 4..5)
        assertTrue("English facts must have 4 to 5 one-liners", structured.englishOneLinerFacts.size in 4..5)
        assertEquals("पिछले पांच साल के प्रश्नों के आधार पर", structured.footerLineHi)
    }

    @Test
    fun testMainScreenBottomNavigationLibraryTestSeriesAndProfileTabs() {
        val app = ApplicationProvider.getApplicationContext<Application>()
        val viewModel = ShakuntalamViewModel(app)

        // 1. Default screen is HOME
        assertEquals(com.example.viewmodel.AppScreen.HOME, viewModel.uiState.value.currentScreen)

        // 2. Toggle to Library tab via bottom navigation
        viewModel.navigateTo(com.example.viewmodel.AppScreen.LIBRARY)
        assertEquals(com.example.viewmodel.AppScreen.LIBRARY, viewModel.uiState.value.currentScreen)
        assertEquals(com.example.viewmodel.AppScreen.HOME, viewModel.uiState.value.previousScreen)

        // 3. Toggle from Library to Test Series tab via bottom navigation
        viewModel.navigateTo(com.example.viewmodel.AppScreen.TEST_SERIES)
        assertEquals(com.example.viewmodel.AppScreen.TEST_SERIES, viewModel.uiState.value.currentScreen)
        assertEquals(com.example.viewmodel.AppScreen.LIBRARY, viewModel.uiState.value.previousScreen)

        // 4. Toggle from Test Series to Profile tab via bottom navigation
        viewModel.openProfileTab()
        assertEquals(com.example.viewmodel.AppScreen.PROFILE, viewModel.uiState.value.currentScreen)
        assertEquals(com.example.viewmodel.AppScreen.TEST_SERIES, viewModel.uiState.value.previousScreen)

        // 5. Update Student Name & Preferred Exam from the Profile tab and verify back navigation
        viewModel.completeStudentAccountSetup("Ananya Sharma", "UPSC Civil Services")
        assertEquals("Ananya Sharma", viewModel.uiState.value.currentUser?.name)
        assertEquals("UPSC Civil Services", viewModel.uiState.value.currentUser?.targetExam)

        assertTrue(viewModel.navigateBack())
        assertEquals(com.example.viewmodel.AppScreen.TEST_SERIES, viewModel.uiState.value.currentScreen)
    }

    @Test
    fun testAllIndiaTestbookPackageTopicWisePyq5YearSequentialStatementsExcelDiAndFreeNotes() {
        val app = ApplicationProvider.getApplicationContext<Application>()
        val viewModel = ShakuntalamViewModel(app)

        // 1. Verify all 14 exams (including UP Police Constable & SI) have 50 Paid Tests (20 FLT + 20 Sectional + 10 PYQ)
        //    plus Free Topic-Wise & Daily Practice Quizzes, with exact official exam question counts
        val examKeys = listOf(
            "upsc", "up_police", "uppcs", "ukpsc", "bpsc", "upsssc", "uksssc",
            "ssc", "banking", "railways", "iit_jee", "neet", "ugc_net", "tet"
        )
        for (examKey in examKeys) {
            val blueprint = com.example.data.AllIndiaMasterTestPackageData.getExamBlueprint(examKey)
            val entries = com.example.data.AllIndiaMasterTestPackageData.getExamPackageEntries(examKey)
            val paid50 = com.example.data.AllIndiaMasterTestPackageData.getPaid50TestsForExam(examKey)

            assertEquals("Every exam must have exactly 50 Paid Tests ($examKey)", 50, paid50.size)

            val fltTests = entries.filter { it.packageCategory == com.example.data.ExamPackageCategory.FULL_LENGTH }
            val sectionalTests = entries.filter { it.packageCategory == com.example.data.ExamPackageCategory.SECTIONAL }
            val pyqPapers = entries.filter { it.packageCategory == com.example.data.ExamPackageCategory.PYQ_5_YEAR }
            val topicQuizzes = entries.filter { it.packageCategory == com.example.data.ExamPackageCategory.TOPIC_WISE }
            val dailyQuizzes = entries.filter { it.packageCategory == com.example.data.ExamPackageCategory.DAILY_PRACTICE }

            assertEquals("Must have 20 Full-Length Tests for $examKey", 20, fltTests.size)
            assertEquals("Must have 20 Sectional Subject Tests for $examKey", 20, sectionalTests.size)
            assertEquals("Must have 10 Previous Year Papers for $examKey", 10, pyqPapers.size)
            assertTrue("Must have granular Topic-Wise quizzes for $examKey", topicQuizzes.size >= 12)
            assertEquals("Must have 4 Daily & Practice quizzes for $examKey", 4, dailyQuizzes.size)

            // Verify exact official exam question count in Full-Length, Sectional & PYQ tests
            assertEquals(blueprint.fltQuestionCount, fltTests.first().mockTest.questions.size)
            assertEquals(blueprint.sectionalQuestionCount, sectionalTests.first().mockTest.questions.size)
            assertEquals(blueprint.fltQuestionCount, pyqPapers.first().mockTest.questions.size)

            // Verify granular Topic-Wise quizzes (Indus Valley, Maurya, Gupta, etc.)
            assertTrue(topicQuizzes.any { it.mockTest.title.contains("Indus Valley", ignoreCase = true) || it.topicTagEn.contains("Indus Valley", ignoreCase = true) })
            assertTrue(topicQuizzes.any { it.mockTest.title.contains("Mauryan Empire", ignoreCase = true) || it.topicTagEn.contains("Mauryan", ignoreCase = true) })
            assertTrue(topicQuizzes.any { it.mockTest.title.contains("Gupta Empire", ignoreCase = true) || it.topicTagEn.contains("Gupta", ignoreCase = true) })
        }

        // 1B. Verify dedicated UP Police Constable & SI (up_police) tab filter & official 150-Q / 38-Q structure
        viewModel.selectDashboardCategoryFilter("UP_POLICE")
        assertTrue(viewModel.uiState.value.isTestSeriesVisibleOnDashboard("up_police"))
        assertFalse(viewModel.uiState.value.isTestSeriesVisibleOnDashboard("upsc"))
        viewModel.startUpPoliceTest("up_police_flt_mock_1")
        assertEquals(150, viewModel.uiState.value.activeTest.questions.size)
        assertEquals(300, viewModel.uiState.value.activeTest.totalMarks)
        viewModel.startUpPoliceTest("up_police_sectional_1")
        assertEquals(38, viewModel.uiState.value.activeTest.questions.size)
        viewModel.clearDashboardCategoryFilter()

        // 2. Verify Payment Gate on Paid Tests vs Free Tests + 3-Tier Subscription (₹9/Month, ₹99/Year, ₹399/Lifetime)
        val upscEntries = com.example.data.AllIndiaMasterTestPackageData.getExamPackageEntries("upsc")
        val paidFlt = upscEntries.first { it.isPaidOnly }
        val freeQuiz = upscEntries.first { !it.isPaidOnly }

        // While unsubscribed, clicking a Paid FLT opens the Payment Gateway and does not start the test
        assertFalse(viewModel.uiState.value.isAllAccessSubscriptionValid())
        assertFalse(viewModel.startExamPackageTest("upsc", paidFlt.id))
        assertTrue(viewModel.uiState.value.isPaymentGatewayOpen)
        assertEquals(9, viewModel.uiState.value.paymentGatewayAmount)

        // Free test starts immediately even without subscription
        viewModel.closePaymentGateway()
        assertTrue(viewModel.startExamPackageTest("upsc", freeQuiz.id))
        assertEquals(com.example.viewmodel.AppScreen.TEST_SERIES, viewModel.uiState.value.currentScreen)

        // Checkout ₹399 Lifetime Pass and complete payment -> Paid FLT now unlocks and starts
        viewModel.initiateSubscriptionCheckout("LIFETIME_399")
        assertTrue(viewModel.uiState.value.isPaymentGatewayOpen)
        assertEquals(399, viewModel.uiState.value.paymentGatewayAmount)
        viewModel.onPaymentSuccess("TXN399LIFETIME")
        assertTrue(viewModel.uiState.value.isAllAccessSubscriptionValid())
        assertEquals("LIFETIME_399", viewModel.uiState.value.subscriptionPlanCode)
        assertEquals(3650, viewModel.uiState.value.getRemainingSubscriptionDays())
        assertTrue(viewModel.startExamPackageTest("upsc", paidFlt.id))
        assertEquals(100, viewModel.uiState.value.activeTest.questions.size)

        // 3. Verify Line-by-Line Sequential Statement formatting (Statement 1 on line 1, Statement 2 on line 2, Statement 3 on line 3)
        val rawMultiStatement = "Consider the following statements regarding Indus Valley Civilization: Statement 1: Harappa is located on the Ravi river. Statement 2: Lothal had an artificial brick dockyard. Statement 3: Dholavira had a three-part city division. Which of the statements given above are correct?"
        val lines = com.example.ui.components.ProfessionalQuestionFormatEngine.extractQuestionLines(rawMultiStatement)
        assertTrue("Multi-statement question must be split into sequential lines", lines.size >= 4)
        assertTrue(lines.any { it.startsWith("Statement 1:") })
        assertTrue(lines.any { it.startsWith("Statement 2:") })
        assertTrue(lines.any { it.startsWith("Statement 3:") })

        // 4. Verify Excel-Style Table & Graph detection for Maths / DI / Index questions
        val diQuiz = upscEntries.first { it.id.contains("maths_di") || it.topicTagEn.contains("Table", ignoreCase = true) }
        val diQuestion = diQuiz.mockTest.questions.first()
        val tableSpec = com.example.data.AllIndiaMasterTestPackageData.getDataTableForQuestion(diQuestion)
        org.junit.Assert.assertNotNull(tableSpec)
        assertEquals(5, tableSpec!!.headersEn.size)
        assertEquals(5, tableSpec.rows.size)
        assertEquals(5, tableSpec.barGraphLabels.size)

        // 5. Verify Free Shakuntalam Branded Notes & PDFs exist and are free (₹0)
        val freeNotes = com.example.data.AllIndiaMasterTestPackageData.freeShakuntalamBrandedNotes
        assertEquals(4, freeNotes.size)
        assertTrue(freeNotes.all { it.discountedPrice == 0 })
        assertTrue(viewModel.uiState.value.uploadedDocuments.isNotEmpty())
    }

    @Test
    fun testSubscriptionViewModelFirestoreStatusAndPaidTestSeriesGating() {
        com.example.ui.components.SubscriptionPassStateBridge.isSubscriptionActive = false
        com.example.ui.components.SubscriptionPassStateBridge.activePlanCode = "NONE"
        com.example.ui.components.SubscriptionPassStateBridge.expiryEpochMillis = 0L
        com.example.ui.components.SubscriptionPassStateBridge.remainingDays = 0

        val subscriptionViewModel = com.example.viewmodel.SubscriptionViewModel()
        val nowMs = 1_750_000_000_000L

        // 1. Initially unsubscribed: Free tests allowed, Paid Test Series (FLT, Sectional, PYQ) gated
        assertFalse(subscriptionViewModel.uiState.value.hasActivePaidSubscription(nowMs))
        assertTrue(subscriptionViewModel.canAccessPaidTestSeries(isPaidOnly = false, nowMillis = nowMs))
        assertFalse(subscriptionViewModel.canAccessPaidTestSeries(isPaidOnly = true, nowMillis = nowMs))

        var deniedPlanRecommended = ""
        val blockedResult = subscriptionViewModel.gatePaidTestSeriesAccess(
            examKey = "up_police",
            testId = "up_police_flt_mock_1",
            nowMillis = nowMs,
            onAccessDenied = { plan -> deniedPlanRecommended = plan }
        )
        assertFalse(blockedResult)
        assertEquals("MONTHLY_9", deniedPlanRecommended)
        assertTrue(subscriptionViewModel.uiState.value.isPaidAccessBlockedModalVisible)

        // 2. Apply active Monthly (₹9) Firestore subscription snapshot -> Paid Test Series unlocked
        val monthlySub = com.example.data.remote.FirestoreUserSubscription(
            id = "student_101",
            userId = "student_101",
            planCode = "MONTHLY_9",
            planName = "Shakuntalam Monthly All-Access Pass (₹9/Month)",
            priceInr = 9L,
            status = "ACTIVE",
            active = true,
            startEpochMillis = nowMs,
            expiryEpochMillis = nowMs + 30L * 24L * 60L * 60L * 1000L,
            receiptNumber = "RCPT-M9"
        )
        subscriptionViewModel.applyFirestoreSubscriptionSnapshot(monthlySub, nowMs)
        assertTrue(subscriptionViewModel.uiState.value.hasActivePaidSubscription(nowMs))
        assertEquals("MONTHLY_9", subscriptionViewModel.uiState.value.planCode)
        assertEquals(9, subscriptionViewModel.uiState.value.priceInr)
        assertEquals(30, subscriptionViewModel.uiState.value.remainingDays)
        assertTrue(subscriptionViewModel.canAccessPaidTestSeries(isPaidOnly = true, nowMillis = nowMs))
        assertTrue(
            subscriptionViewModel.gatePaidTestSeriesAccess(
                examKey = "up_police",
                testId = "up_police_flt_mock_1",
                nowMillis = nowMs
            )
        )

        // 3. Apply Yearly (₹99) and Lifetime (₹399) plans
        subscriptionViewModel.activateSubscription("YEARLY_99", "RCPT-Y99", nowMs)
        assertEquals("YEARLY_99", subscriptionViewModel.uiState.value.planCode)
        assertEquals(99, subscriptionViewModel.uiState.value.priceInr)
        assertEquals(365, subscriptionViewModel.uiState.value.remainingDays)
        assertTrue(subscriptionViewModel.canAccessPaidTestSeries(isPaidOnly = true, nowMillis = nowMs))

        subscriptionViewModel.activateSubscription("LIFETIME_399", "RCPT-L399", nowMs)
        assertEquals("LIFETIME_399", subscriptionViewModel.uiState.value.planCode)
        assertEquals(399, subscriptionViewModel.uiState.value.priceInr)
        assertEquals(3650, subscriptionViewModel.uiState.value.remainingDays)
        assertTrue(subscriptionViewModel.canAccessPaidTestSeries(isPaidOnly = true, nowMillis = nowMs))

        // 4. Advance time past expiry -> automatically expires and re-locks Paid Test Series
        val afterExpiryMs = nowMs + 3651L * 24L * 60L * 60L * 1000L
        assertTrue(subscriptionViewModel.checkAndExpireIfNeeded(afterExpiryMs))
        assertFalse(subscriptionViewModel.uiState.value.hasActivePaidSubscription(afterExpiryMs))
        assertEquals("NONE", subscriptionViewModel.uiState.value.planCode)
        assertFalse(subscriptionViewModel.canAccessPaidTestSeries(isPaidOnly = true, nowMillis = afterExpiryMs))
    }

    @Test
    fun testQuizViewModelMultiStatementLineByLineAndMathGridChart() {
        val quizViewModel = com.example.viewmodel.QuizViewModel()

        // 1. Verify FirestoreQuizTestDocument snapshot application & state sync
        val firestoreQuizDoc = com.example.data.remote.FirestoreQuizTestDocument(
            id = "upsc_flt_mock_1",
            userId = "student_101",
            testId = "upsc_flt_mock_1",
            examKey = "upsc",
            titleEn = "UPSC CSE Prelims Full-Length Test 1",
            titleHi = "UPSC सिविल सेवा प्रारंभिक फुल-लेंथ टेस्ट 1",
            durationMinutes = 120L,
            totalMarks = 200L,
            questionCount = 100L,
            paidOnly = true
        )
        quizViewModel.applyFirestoreQuizTestDocument(firestoreQuizDoc)
        assertTrue(quizViewModel.uiState.value.isSyncedWithFirestore)
        assertEquals("FIRESTORE_SYNCED", quizViewModel.uiState.value.firestoreSyncStatus)
        assertEquals("upsc", quizViewModel.uiState.value.examKey)
        assertEquals("upsc_flt_mock_1", quizViewModel.uiState.value.testId)
        assertEquals(100, quizViewModel.uiState.value.totalQuestions)
        assertEquals(7200, quizViewModel.uiState.value.remainingSeconds)

        // 2. Verify Line-by-Line Multi-Statement Parsing (English + Hindi + Assertion/Reason)
        val multiStmtEn = "Consider the following statements regarding Indus Valley Civilization: Statement 1: Harappa is situated on the bank of River Ravi. Statement 2: Lothal had an artificial brick dockyard. Statement 3: Dholavira had a unique three-part city division. Which of the statements given above are correct?"
        val parsedLinesEn = quizViewModel.parseLineByLineStatements(multiStmtEn, isHindi = false)
        assertEquals(5, parsedLinesEn.size)
        assertEquals(com.example.viewmodel.StatementLineType.OPENING_STEM, parsedLinesEn[0].lineType)
        assertEquals(com.example.viewmodel.StatementLineType.STATEMENT_ITEM, parsedLinesEn[1].lineType)
        assertEquals("Statement 1", parsedLinesEn[1].badgeLabel)
        assertTrue(parsedLinesEn[1].bodyText.contains("Harappa"))
        assertEquals(com.example.viewmodel.StatementLineType.STATEMENT_ITEM, parsedLinesEn[2].lineType)
        assertEquals("Statement 2", parsedLinesEn[2].badgeLabel)
        assertTrue(parsedLinesEn[2].bodyText.contains("Lothal"))
        assertEquals(com.example.viewmodel.StatementLineType.STATEMENT_ITEM, parsedLinesEn[3].lineType)
        assertEquals("Statement 3", parsedLinesEn[3].badgeLabel)
        assertTrue(parsedLinesEn[3].bodyText.contains("Dholavira"))
        assertEquals(com.example.viewmodel.StatementLineType.CLOSING_PROMPT, parsedLinesEn[4].lineType)

        val multiStmtHi = "सिंधु घाटी सभ्यता के संदर्भ में निम्नलिखित कथनों पर विचार कीजिए: कथन 1: हड़प्पा रावी नदी के तट पर स्थित है। कथन 2: लोथल में ईंटों का कृत्रिम गोदीबाड़ा मिला है। कथन 3: धोलावीरा नगर तीन भागों में विभाजित था। उपर्युक्त में से कौन-से कथन सही हैं?"
        val parsedLinesHi = quizViewModel.parseLineByLineStatements(multiStmtHi, isHindi = true)
        assertEquals(5, parsedLinesHi.size)
        assertEquals("कथन 1", parsedLinesHi[1].badgeLabel)
        assertEquals("कथन 2", parsedLinesHi[2].badgeLabel)
        assertEquals("कथन 3", parsedLinesHi[3].badgeLabel)
        assertEquals(com.example.viewmodel.StatementLineType.CLOSING_PROMPT, parsedLinesHi[4].lineType)

        // 3. Verify Math / Data Interpretation (DI) Grid & Visual Chart Data Extraction
        val upscEntries = com.example.data.AllIndiaMasterTestPackageData.getExamPackageEntries("upsc")
        val diQuizEntry = upscEntries.first { it.id.contains("maths_di") || it.topicTagEn.contains("Table", ignoreCase = true) }
        quizViewModel.loadQuizFromFirestoreOrCatalog("upsc", diQuizEntry.id)
        assertTrue(quizViewModel.uiState.value.hasCurrentQuestionMathVisualData)
        val mathData = quizViewModel.uiState.value.currentMathVisualData
        org.junit.Assert.assertNotNull(mathData)
        assertEquals(5, mathData!!.headersEn.size)
        assertEquals(5, mathData.gridRows.size)
        assertEquals(5, mathData.chartPoints.size)
        assertTrue(mathData.chartPoints.any { it.isPeakValue })
        assertTrue(mathData.averageValue > 0f)

        // 4. Verify Multi-Choice Option Selection, Mark for Review, Navigation & Scorecard Submission
        val q0 = quizViewModel.uiState.value.currentQuestion!!
        quizViewModel.selectOption(q0.id, q0.correctIndex)
        assertEquals(1, quizViewModel.uiState.value.answeredCount)
        assertTrue(quizViewModel.uiState.value.isInstantSolutionVisible)

        quizViewModel.toggleMarkForReview(q0.id)
        assertTrue(q0.id in quizViewModel.uiState.value.markedForReviewIds)

        quizViewModel.nextQuestion()
        assertEquals(1, quizViewModel.uiState.value.currentQuestionIndex)
        val q1 = quizViewModel.uiState.value.currentQuestion!!
        val wrongIndex = (q1.correctIndex + 1) % 4
        quizViewModel.selectOption(q1.id, wrongIndex)
        assertEquals(2, quizViewModel.uiState.value.answeredCount)

        quizViewModel.tickTimer(120)
        val scorecard = quizViewModel.submitQuiz()
        assertTrue(quizViewModel.uiState.value.isSubmitted)
        assertEquals(2, scorecard.attemptedCount)
        assertEquals(1, scorecard.correctCount)
        assertEquals(1, scorecard.wrongCount)
        assertEquals(50, scorecard.accuracyPercent)
        assertEquals(120, scorecard.timeSpentSeconds)
    }
}



