package com.example

import com.example.data.ExamCatalogData
import com.example.data.local.ExamHierarchyPrepopulateData
import com.example.data.local.entity.EbookDocumentEntity
import com.example.model.AppLanguage
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

class ExampleUnitTest {

    @Test
    fun testAllExamCategoriesPresent() {
        val categories = ExamCatalogData.categories
        assertTrue("Should have more than 10 categories", categories.size >= 10)

        val upscCat = categories.find { it.id == "upsc" }
        assertNotNull("UPSC category must exist", upscCat)

        val prelimsSub = upscCat!!.subSections.find { it.id == "upsc_prelims" }
        assertNotNull("UPSC Prelims must exist", prelimsSub)

        val subjectIds = prelimsSub!!.subjects.map { it.id }
        assertTrue("Should contain History", subjectIds.contains("upsc_pre_history"))
        assertTrue("Should contain Polity", subjectIds.contains("upsc_pre_polity"))
        assertTrue("Should contain Economy", subjectIds.contains("upsc_pre_economy"))
        assertTrue("Should contain Geography", subjectIds.contains("upsc_pre_geography"))
        assertTrue("Should contain Environment", subjectIds.contains("upsc_pre_env"))
        assertTrue("Should contain CSAT", subjectIds.contains("upsc_pre_csat"))

        // Check other requested exams
        val statePsc = categories.find { it.id == "state_psc" }
        assertNotNull("State PSC must exist", statePsc)

        val ssc = categories.find { it.id == "ssc" }
        assertNotNull("SSC must exist", ssc)

        val railway = categories.find { it.id == "railway" }
        assertNotNull("Railway must exist", railway)

        val computerCert = categories.find { it.id == "computer_cert" }
        assertNotNull("Computer CCC/O-Level must exist", computerCert)

        val aiMl = categories.find { it.id == "ai_ml" }
        assertNotNull("AI & Machine Learning must exist", aiMl)
    }

    @Test
    fun testStudyItemsAndPricing() {
        val items = ExamCatalogData.studyItems
        assertTrue("Catalog study items should not be empty", items.isNotEmpty())

        val firstItem = items.first()
        assertTrue("Discount price should be less than or equal to original price", firstItem.discountedPrice <= firstItem.originalPrice)
        assertTrue("Rating should be between 1.0 and 5.0", firstItem.rating in 1.0..5.0)
        assertNotNull("English title must not be blank", firstItem.title)
        assertNotNull("Hindi title must not be blank", firstItem.hindiTitle)
    }

    @Test
    fun testMockTestQuestionIntegrity() {
        val mockTest = ExamCatalogData.sampleMockTest
        assertTrue("Mock test must contain questions", mockTest.questions.isNotEmpty())
        assertEquals(10, mockTest.questions.size)

        mockTest.questions.forEach { q ->
            assertTrue("Options count must be 4", q.optionsEn.size == 4)
            assertTrue("Options count Hindi must be 4", q.optionsHi.size == 4)
            assertTrue("Correct option index must be valid", q.correctIndex in 0..3)
            assertTrue("Hindi explanation must be present", q.explanationHi.isNotBlank())
            assertTrue("English explanation must be present", q.explanationEn.isNotBlank())
        }
    }

    @Test
    fun testRoomDatabaseHierarchySeedData() {
        val exams = ExamHierarchyPrepopulateData.defaultExams
        val subjects = ExamHierarchyPrepopulateData.defaultSubjects
        val subTopics = ExamHierarchyPrepopulateData.defaultSubTopics

        assertTrue("Exams count should be greater than 0", exams.isNotEmpty())
        assertTrue("Subjects count should be greater than 0", subjects.isNotEmpty())
        assertTrue("Subtopics count should be greater than 0", subTopics.isNotEmpty())

        val examIds = exams.map { it.id }.toSet()
        val subjectIds = subjects.map { it.id }.toSet()

        // Verify foreign key integrity in seed data
        subjects.forEach { subject ->
            assertTrue(
                "Subject ${subject.id} references invalid examId ${subject.examId}",
                examIds.contains(subject.examId)
            )
        }

        subTopics.forEach { subTopic ->
            assertTrue(
                "Subtopic ${subTopic.id} references invalid subjectId ${subTopic.subjectId}",
                subjectIds.contains(subTopic.subjectId)
            )
        }
    }

    @Test
    fun testEbookDocumentEntityModel() {
        val doc = EbookDocumentEntity(
            id = "doc_test_1",
            title = "Modern Indian History Notes",
            hindiTitle = "आधुनिक भारतीय इतिहास",
            examId = "upsc_cse",
            subjectId = "upsc_history",
            fileName = "modern_history_upsc.pdf",
            fileUri = "content://com.android.providers.media.documents/document/101",
            fileSizeFormatted = "4.5 MB",
            pageCount = 142,
            originalPrice = 299,
            discountedPrice = 49
        )
        assertEquals("modern_history_upsc.pdf", doc.fileName)
        assertEquals(49, doc.discountedPrice)
        assertEquals(142, doc.pageCount)
        assertEquals("upsc_cse", doc.examId)
    }

    @Test
    fun testBilingualLanguageEnum() {
        assertEquals("हिंदी", AppLanguage.HINDI.nativeName)
        assertEquals("English", AppLanguage.ENGLISH.nativeName)
    }

    @Test
    fun testUserProfileAndAuthModels() {
        val googleUser = com.example.model.UserProfile(
            name = "Bharat Kumar",
            email = "thebharat99999@gmail.com",
            provider = com.example.model.AuthProviderType.GOOGLE,
            targetExam = "UPSC Civil Services"
        )
        assertEquals("Bharat Kumar", googleUser.name)
        assertEquals("thebharat99999@gmail.com", googleUser.email)
        assertEquals(com.example.model.AuthProviderType.GOOGLE, googleUser.provider)
        assertTrue(googleUser.isVerified)

        val phoneOtp = com.example.model.PhoneOtpState(
            phoneNumber = "9876543210",
            isOtpSent = true,
            otpCode = "123456",
            generatedOtp = "123456"
        )
        assertEquals("123456", phoneOtp.otpCode)
        assertTrue(phoneOtp.isOtpSent)
        assertEquals(phoneOtp.generatedOtp, phoneOtp.otpCode)
    }

    @Test
    fun testLivePriceEditLogic() {
        val originalItem = ExamCatalogData.studyItems.first()
        val newOriginalPrice = 599
        val newDiscountedPrice = 149

        val updatedItem = originalItem.copy(
            originalPrice = newOriginalPrice,
            discountedPrice = newDiscountedPrice
        )

        assertEquals(599, updatedItem.originalPrice)
        assertEquals(149, updatedItem.discountedPrice)
        val discountPercent = ((updatedItem.originalPrice - updatedItem.discountedPrice).toFloat() / updatedItem.originalPrice * 100).toInt()
        assertEquals(75, discountPercent)
    }

    @Test
    fun testQuestionFormatAndSolutionCreation() {
        val newQuestion = com.example.model.TestQuestion(
            id = 101,
            questionEn = "Which article of the Indian Constitution deals with the Election Commission?",
            questionHi = "भारतीय संविधान का कौन सा अनुच्छेद चुनाव आयोग से संबंधित है?",
            optionsEn = listOf("Article 324", "Article 356", "Article 370", "Article 352"),
            optionsHi = listOf("अनुच्छेद 324", "अनुच्छेद 356", "अनुच्छेद 370", "अनुच्छेद 352"),
            correctIndex = 0,
            explanationEn = "Article 324 of the Constitution provides for the Election Commission of India.",
            explanationHi = "संविधान का अनुच्छेद 324 भारत के चुनाव आयोग का प्रावधान करता है।",
            subject = "Indian Polity"
        )

        assertEquals(101, newQuestion.id)
        assertEquals(0, newQuestion.correctIndex)
        assertEquals("Article 324", newQuestion.optionsEn[newQuestion.correctIndex])
        assertEquals("अनुच्छेद 324", newQuestion.optionsHi[newQuestion.correctIndex])
        assertTrue(newQuestion.explanationEn.contains("Article 324"))
        assertEquals("Indian Polity", newQuestion.subject)
    }
}
