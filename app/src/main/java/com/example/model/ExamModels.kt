package com.example.model

enum class ContentType(val label: String, val hindiLabel: String) {
    EBOOK("E-Book", "ई-बुक"),
    TEST_SERIES("Test Series", "टेस्ट सीरीज़"),
    COMBO("Combo Pack", "कॉम्बो पैक")
}

data class ExamSubject(
    val id: String,
    val name: String,
    val hindiName: String,
    val topics: List<String> = emptyList()
)

data class ExamSubSection(
    val id: String,
    val name: String,
    val hindiName: String,
    val subjects: List<ExamSubject>
)

data class ExamCategory(
    val id: String,
    val name: String,
    val hindiName: String,
    val iconKey: String,
    val badge: String = "",
    val subSections: List<ExamSubSection>
)

data class BookChapter(
    val chapterNumber: Int,
    val title: String,
    val hindiTitle: String,
    val pageCount: Int,
    val content: String
)

data class StudyItem(
    val id: String,
    val title: String,
    val hindiTitle: String,
    val seriesName: String = "Shakuntalam E-Book Series",
    val categoryId: String,
    val subSectionId: String,
    val subjectId: String,
    val type: ContentType,
    val medium: String, // "Hindi Medium", "English Medium", "Bilingual"
    val originalPrice: Int,
    val discountedPrice: Int,
    val rating: Float,
    val reviewCount: Int,
    val edition: String = "2025-26 Edition",
    val totalPagesOrTests: String, // e.g., "520 Pages" or "25 Mock Tests"
    val features: List<String> = emptyList(),
    val description: String = "",
    val chapters: List<BookChapter> = emptyList(),
    val isBestseller: Boolean = false,
    val isTrending: Boolean = false,
    val hasSample: Boolean = true,
    val accentColorHex: Long = 0xFF0D254CL
)

data class TestQuestion(
    val id: Int,
    val questionEn: String,
    val questionHi: String,
    val optionsEn: List<String>,
    val optionsHi: List<String>,
    val correctIndex: Int,
    val explanationEn: String,
    val explanationHi: String,
    val subject: String,
    val pyqYearTag: String = "PYQ 2020-2024 Trend",
    val pyqFrequency: String = "High Yield (Last 5 Yrs)",
    val difficultyLevel: String = "Moderate-High",
    val pyqTrendNoteEn: String = "Based on official last 5 years exam pattern & topic weightage analysis.",
    val pyqTrendNoteHi: String = "विगत 5 वर्षों के आधिकारिक परीक्षा पैटर्न एवं टॉपिक वेटेज विश्लेषण पर आधारित।"
)

data class MockTest(
    val testId: String,
    val title: String,
    val hindiTitle: String,
    val examName: String,
    val durationMinutes: Int,
    val totalMarks: Int,
    val positiveMarks: Double = 2.0,
    val negativeMarks: Double = 0.66,
    val questions: List<TestQuestion>,
    val categoryId: String = "upsc",
    val pyqAnalysisEn: String = "Last 5 Years (2020–2025) PYQ Trend Analysis: High-yield conceptual & statement-based questions.",
    val pyqAnalysisHi: String = "विगत 5 वर्षों (2020–2025) का PYQ ट्रेंड विश्लेषण: उच्च-वेटेज वैचारिक एवं कथन-आधारित प्रश्न।",
    val topicWeightage: List<String> = listOf("Polity (22%)", "History (18%)", "Economy (20%)", "Geo & Env (24%)", "Sci & Tech (16%)")
)

data class CartItem(
    val studyItem: StudyItem,
    val addedTimestamp: Long = System.currentTimeMillis()
)

data class UserTestAttempt(
    val testId: String,
    val testTitle: String,
    val score: Double,
    val totalMarks: Int,
    val correctCount: Int,
    val wrongCount: Int,
    val unattemptedCount: Int,
    val timeSpentSeconds: Int,
    val timestamp: Long = System.currentTimeMillis()
)
