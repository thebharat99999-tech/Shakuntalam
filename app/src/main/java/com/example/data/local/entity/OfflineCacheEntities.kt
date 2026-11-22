package com.example.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.model.BookChapter
import com.example.model.ContentType
import com.example.model.MockTest
import com.example.model.StudyItem
import com.example.model.TestQuestion
import org.json.JSONArray
import org.json.JSONObject

/**
 * Room Entity storing a complete E-Book (including all chapters and content) locally
 * so students can read downloaded E-Books offline when internet is unavailable.
 */
@Entity(tableName = "offline_cached_ebooks")
data class OfflineEbookCacheEntity(
    @PrimaryKey val itemId: String,
    val title: String,
    val hindiTitle: String,
    val seriesName: String,
    val categoryId: String,
    val subSectionId: String,
    val subjectId: String,
    val medium: String,
    val edition: String,
    val totalPagesOrTests: String,
    val description: String,
    val originalPrice: Int,
    val discountedPrice: Int,
    val rating: Float,
    val reviewCount: Int,
    val chaptersPayloadJson: String,
    val cacheSizeKb: Int,
    val cachedAtTimestamp: Long = System.currentTimeMillis()
) {
    fun toStudyItem(): StudyItem {
        val chaptersList = parseChaptersJson(chaptersPayloadJson)
        return StudyItem(
            id = itemId,
            title = title,
            hindiTitle = hindiTitle,
            seriesName = seriesName,
            categoryId = categoryId,
            subSectionId = subSectionId,
            subjectId = subjectId,
            type = ContentType.EBOOK,
            medium = medium,
            originalPrice = originalPrice,
            discountedPrice = discountedPrice,
            rating = rating,
            reviewCount = reviewCount,
            edition = edition,
            totalPagesOrTests = totalPagesOrTests,
            description = description,
            chapters = chaptersList
        )
    }

    companion object {
        fun fromStudyItem(item: StudyItem): OfflineEbookCacheEntity {
            val json = serializeChaptersToJson(item.chapters)
            val estimatedSizeKb = ((json.length + item.description.length) / 1024).coerceAtLeast(48)
            return OfflineEbookCacheEntity(
                itemId = item.id,
                title = item.title,
                hindiTitle = item.hindiTitle,
                seriesName = item.seriesName,
                categoryId = item.categoryId,
                subSectionId = item.subSectionId,
                subjectId = item.subjectId,
                medium = item.medium,
                edition = item.edition,
                totalPagesOrTests = item.totalPagesOrTests,
                description = item.description,
                originalPrice = item.originalPrice,
                discountedPrice = item.discountedPrice,
                rating = item.rating,
                reviewCount = item.reviewCount,
                chaptersPayloadJson = json,
                cacheSizeKb = estimatedSizeKb
            )
        }

        fun serializeChaptersToJson(chapters: List<BookChapter>): String {
            val arr = JSONArray()
            chapters.forEach { ch ->
                val obj = JSONObject()
                obj.put("chapterNumber", ch.chapterNumber)
                obj.put("title", ch.title)
                obj.put("hindiTitle", ch.hindiTitle)
                obj.put("pageCount", ch.pageCount)
                obj.put("content", ch.content)
                arr.put(obj)
            }
            return arr.toString()
        }

        fun parseChaptersJson(json: String): List<BookChapter> {
            if (json.isBlank()) return emptyList()
            return runCatching {
                val arr = JSONArray(json)
                val list = ArrayList<BookChapter>(arr.length())
                for (i in 0 until arr.length()) {
                    val obj = arr.getJSONObject(i)
                    list.add(
                        BookChapter(
                            chapterNumber = obj.optInt("chapterNumber", i + 1),
                            title = obj.optString("title", "Chapter ${i + 1}"),
                            hindiTitle = obj.optString("hindiTitle", "अध्याय ${i + 1}"),
                            pageCount = obj.optInt("pageCount", 12),
                            content = obj.optString("content", "")
                        )
                    )
                }
                list
            }.getOrDefault(emptyList())
        }
    }
}

/**
 * Room Entity storing a complete Mock Test / PYQ Test Series (including all bilingual questions,
 * options, answer keys, and explanations) locally for offline test-taking without internet.
 */
@Entity(tableName = "offline_cached_tests")
data class OfflineTestCacheEntity(
    @PrimaryKey val testId: String,
    val title: String,
    val hindiTitle: String,
    val examName: String,
    val categoryId: String,
    val durationMinutes: Int,
    val totalMarks: Int,
    val positiveMarks: Double,
    val negativeMarks: Double,
    val questionCount: Int,
    val pyqAnalysisEn: String,
    val pyqAnalysisHi: String,
    val questionsPayloadJson: String,
    val cacheSizeKb: Int,
    val cachedAtTimestamp: Long = System.currentTimeMillis()
) {
    fun toMockTest(): MockTest {
        val parsedQuestions = parseQuestionsJson(questionsPayloadJson)
        return MockTest(
            testId = testId,
            title = title,
            hindiTitle = hindiTitle,
            examName = examName,
            durationMinutes = durationMinutes,
            totalMarks = totalMarks,
            positiveMarks = positiveMarks,
            negativeMarks = negativeMarks,
            questions = parsedQuestions,
            categoryId = categoryId,
            pyqAnalysisEn = pyqAnalysisEn,
            pyqAnalysisHi = pyqAnalysisHi
        )
    }

    companion object {
        fun fromMockTest(test: MockTest): OfflineTestCacheEntity {
            val json = serializeQuestionsToJson(test.questions)
            val estimatedSizeKb = (json.length / 1024).coerceAtLeast(32)
            return OfflineTestCacheEntity(
                testId = test.testId,
                title = test.title,
                hindiTitle = test.hindiTitle,
                examName = test.examName,
                categoryId = test.categoryId,
                durationMinutes = test.durationMinutes,
                totalMarks = test.totalMarks,
                positiveMarks = test.positiveMarks,
                negativeMarks = test.negativeMarks,
                questionCount = test.questions.size,
                pyqAnalysisEn = test.pyqAnalysisEn,
                pyqAnalysisHi = test.pyqAnalysisHi,
                questionsPayloadJson = json,
                cacheSizeKb = estimatedSizeKb
            )
        }

        fun serializeQuestionsToJson(questions: List<TestQuestion>): String {
            val arr = JSONArray()
            questions.forEach { q ->
                val obj = JSONObject()
                obj.put("id", q.id)
                obj.put("questionEn", q.questionEn)
                obj.put("questionHi", q.questionHi)
                obj.put("optionsEn", JSONArray(q.optionsEn))
                obj.put("optionsHi", JSONArray(q.optionsHi))
                obj.put("correctIndex", q.correctIndex)
                obj.put("explanationEn", q.explanationEn)
                obj.put("explanationHi", q.explanationHi)
                obj.put("subject", q.subject)
                obj.put("pyqYearTag", q.pyqYearTag)
                obj.put("pyqFrequency", q.pyqFrequency)
                obj.put("difficultyLevel", q.difficultyLevel)
                obj.put("pyqTrendNoteEn", q.pyqTrendNoteEn)
                obj.put("pyqTrendNoteHi", q.pyqTrendNoteHi)
                arr.put(obj)
            }
            return arr.toString()
        }

        fun parseQuestionsJson(json: String): List<TestQuestion> {
            if (json.isBlank()) return emptyList()
            return runCatching {
                val arr = JSONArray(json)
                val list = ArrayList<TestQuestion>(arr.length())
                for (i in 0 until arr.length()) {
                    val obj = arr.getJSONObject(i)
                    val optEnArr = obj.optJSONArray("optionsEn") ?: JSONArray()
                    val optHiArr = obj.optJSONArray("optionsHi") ?: JSONArray()
                    val optionsEn = (0 until optEnArr.length()).map { optEnArr.optString(it, "") }
                    val optionsHi = (0 until optHiArr.length()).map { optHiArr.optString(it, "") }
                    list.add(
                        TestQuestion(
                            id = obj.optInt("id", i + 1),
                            questionEn = obj.optString("questionEn", ""),
                            questionHi = obj.optString("questionHi", ""),
                            optionsEn = if (optionsEn.size == 4) optionsEn else listOf("Option A", "Option B", "Option C", "Option D"),
                            optionsHi = if (optionsHi.size == 4) optionsHi else listOf("विकल्प A", "विकल्प B", "विकल्प C", "विकल्प D"),
                            correctIndex = obj.optInt("correctIndex", 0).coerceIn(0, 3),
                            explanationEn = obj.optString("explanationEn", ""),
                            explanationHi = obj.optString("explanationHi", ""),
                            subject = obj.optString("subject", "General Studies"),
                            pyqYearTag = obj.optString("pyqYearTag", "PYQ 2020-2025"),
                            pyqFrequency = obj.optString("pyqFrequency", "High Yield"),
                            difficultyLevel = obj.optString("difficultyLevel", "Moderate"),
                            pyqTrendNoteEn = obj.optString("pyqTrendNoteEn", ""),
                            pyqTrendNoteHi = obj.optString("pyqTrendNoteHi", "")
                        )
                    )
                }
                list
            }.getOrDefault(emptyList())
        }
    }
}
