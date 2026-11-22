package com.example.ui.components

import androidx.compose.foundation.Canvas
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Leaderboard
import androidx.compose.material.icons.filled.Speed
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material.icons.filled.WorkspacePremium
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.MockTest
import com.example.model.TestQuestion
import com.example.model.UserTestAttempt
import com.example.ui.theme.EmeraldSuccess
import com.example.ui.theme.Navy800
import com.example.ui.theme.Navy900
import com.example.ui.theme.SaffronGold
import kotlin.math.roundToInt

/**
 * Normalized question difficulty bucket: EASY, MODERATE, or HARD.
 */
enum class QuestionDifficultyBucket(
    val labelEn: String,
    val labelHi: String,
    val colorHex: Long
) {
    EASY("Easy", "सरल (Easy)", 0xFF10B981),
    MODERATE("Moderate", "मध्यम (Moderate)", 0xFFF59E0B),
    HARD("Hard", "कठिन (Hard)", 0xFFEF4444)
}

data class StudentRankInfo(
    val allIndiaRank: Int,
    val totalCandidates: Int,
    val percentile: Double,
    val scorePercentage: Double,
    val cutoffMarks: Double,
    val isCutoffCleared: Boolean,
    val rankTierTitleEn: String,
    val rankTierTitleHi: String,
    val rankBadgeCode: String // "TOPPER", "MERIT", "QUALIFIED", "ASPIRANT"
)

data class SubjectWiseAnalysisItem(
    val subjectName: String,
    val totalQuestions: Int,
    val correctCount: Int,
    val wrongCount: Int,
    val skippedCount: Int,
    val accuracyPercent: Int,
    val marksObtained: Double,
    val maxMarks: Double
)

data class DifficultyAnalysisItem(
    val bucket: QuestionDifficultyBucket,
    val totalQuestions: Int,
    val correctCount: Int,
    val wrongCount: Int,
    val skippedCount: Int,
    val accuracyPercent: Int
)

data class TimeAnalysisReport(
    val totalDurationSeconds: Int,
    val timeSpentSeconds: Int,
    val timeRemainingSeconds: Int,
    val timeUsedPercent: Int,
    val avgSecondsPerAttemptedQuestion: Double,
    val avgSecondsPerTotalQuestion: Double,
    val idealSecondsPerQuestion: Double,
    val speedVerdictEn: String,
    val speedVerdictHi: String
)

data class LeaderboardScorerEntry(
    val rank: Int,
    val studentName: String,
    val stateOrCenter: String,
    val score: Double,
    val totalMarks: Int,
    val accuracyPercent: Int,
    val timeTakenSeconds: Int,
    val badgeLabel: String,
    val isCurrentUser: Boolean = false
)

data class CompleteTestAnalyticsReport(
    val rankInfo: StudentRankInfo,
    val correctCount: Int,
    val wrongCount: Int,
    val skippedCount: Int,
    val totalQuestions: Int,
    val positiveMarksEarned: Double,
    val negativeMarksDeducted: Double,
    val netScore: Double,
    val totalMarks: Int,
    val accuracyPercent: Int,
    val attemptRatePercent: Int,
    val subjectBreakdown: List<SubjectWiseAnalysisItem>,
    val difficultyBreakdown: List<DifficultyAnalysisItem>,
    val timeReport: TimeAnalysisReport,
    val leaderboard: List<LeaderboardScorerEntry>
)

object TestAnalyticsEngine {

    /**
     * Classifies any [TestQuestion] into EASY, MODERATE, or HARD based on explicit difficulty tags,
     * statement/pair complexity in the stem, or deterministic index distribution.
     */
    fun classifyQuestionDifficulty(question: TestQuestion, indexInTest: Int = 0): QuestionDifficultyBucket {
        val raw = question.difficultyLevel.trim().lowercase()
        val stem = question.questionEn.lowercase()

        // 1. Check explicit single-tier difficulty strings
        if (raw == "easy") return QuestionDifficultyBucket.EASY
        if (raw == "easy-moderate") {
            return if ((question.id + indexInTest) % 2 == 0) QuestionDifficultyBucket.EASY else QuestionDifficultyBucket.MODERATE
        }
        if (raw == "moderate" || raw == "moderate (high speed)") return QuestionDifficultyBucket.MODERATE
        if (raw.startsWith("high") || raw == "hard" || raw.contains("pair pattern") || raw.contains("statement pattern")) {
            return QuestionDifficultyBucket.HARD
        }

        // 2. Check question stem complexity (Statement-I/II, "Consider the following", "How many of the above")
        if (stem.contains("statement-i") ||
            stem.contains("consider the following") ||
            stem.contains("how many of the") ||
            stem.contains("assertion (a)") ||
            stem.contains("match list")
        ) {
            return if ((question.id + indexInTest) % 3 == 0) QuestionDifficultyBucket.MODERATE else QuestionDifficultyBucket.HARD
        }

        // 3. Deterministic balanced distribution for exam-standard tags (30% Easy, 45% Moderate, 25% Hard)
        return when ((indexInTest + question.id.coerceAtLeast(0)) % 10) {
            0, 3, 7 -> QuestionDifficultyBucket.EASY
            1, 2, 5, 6, 8 -> QuestionDifficultyBucket.MODERATE
            else -> QuestionDifficultyBucket.HARD
        }
    }

    /**
     * Calculates the student's All-India Rank (AIR), Percentile, Cutoff status, and Merit Tier
     * on the basis of score out of totalMarks.
     */
    fun calculateStudentRank(
        score: Double,
        totalMarks: Int,
        correctCount: Int,
        wrongCount: Int,
        timeSpentSeconds: Int,
        totalDurationSeconds: Int,
        totalCandidates: Int = 12500
    ): StudentRankInfo {
        val safeTotalMarks = totalMarks.coerceAtLeast(1).toDouble()
        val clampedScore = score.coerceIn(0.0, safeTotalMarks)
        val scorePct = ((clampedScore / safeTotalMarks) * 100.0).coerceIn(0.0, 100.0)
        val cutoffMarks = ((safeTotalMarks * 0.62) * 10.0).roundToInt() / 10.0
        val isCutoffCleared = clampedScore >= cutoffMarks

        // Calculate All-India Rank deterministically from score percentage + accuracy + speed tie-breaker
        val accuracyRatio = if (correctCount + wrongCount > 0) {
            correctCount.toDouble() / (correctCount + wrongCount).toDouble()
        } else {
            0.0
        }
        val speedBonus = if (totalDurationSeconds > 0 && clampedScore > 0) {
            ((totalDurationSeconds - timeSpentSeconds).coerceAtLeast(0).toDouble() / totalDurationSeconds.toDouble()) * 0.02
        } else {
            0.0
        }
        val effectivePerformanceRatio = ((clampedScore / safeTotalMarks) + (accuracyRatio * 0.03) + speedBonus).coerceIn(0.0, 1.0)

        val computedRank = when {
            clampedScore >= safeTotalMarks * 0.96 -> 1
            clampedScore >= safeTotalMarks * 0.92 -> 2 + ((1.0 - effectivePerformanceRatio) * 15).roundToInt().coerceAtLeast(0)
            clampedScore >= safeTotalMarks * 0.85 -> 8 + ((0.92 - (clampedScore / safeTotalMarks)) * 180).roundToInt().coerceAtLeast(0)
            clampedScore >= safeTotalMarks * 0.75 -> 25 + ((0.85 - (clampedScore / safeTotalMarks)) * 650).roundToInt().coerceAtLeast(0)
            clampedScore >= safeTotalMarks * 0.62 -> 95 + ((0.75 - (clampedScore / safeTotalMarks)) * 1800).roundToInt().coerceAtLeast(0)
            clampedScore >= safeTotalMarks * 0.40 -> 450 + ((0.62 - (clampedScore / safeTotalMarks)) * 8500).roundToInt().coerceAtLeast(0)
            clampedScore > 0.0 -> 2400 + ((0.40 - (clampedScore / safeTotalMarks)) * 18000).roundToInt().coerceAtLeast(0)
            else -> totalCandidates
        }.coerceIn(1, totalCandidates)

        val percentile = if (totalCandidates > 1) {
            (((totalCandidates - computedRank).toDouble() / (totalCandidates - 1).toDouble()) * 100.0)
                .let { (it * 100.0).roundToInt() / 100.0 }
                .coerceIn(0.0, 100.0)
        } else {
            100.0
        }

        val (tierEn, tierHi, badgeCode) = when {
            scorePct >= 85.0 -> Triple("All-India Topper • Star Merit List", "अखिल भारतीय टॉपर • स्टार मेरिट लिस्ट", "TOPPER")
            scorePct >= 72.0 -> Triple("Distinction • Rank Holder Zone", "डिस्टिंक्शन • रैंक होल्डर ज़ोन", "MERIT")
            scorePct >= 62.0 -> Triple("Cutoff Cleared • Selection Zone", "कटऑफ उत्तीर्ण • चयन ज़ोन", "QUALIFIED")
            scorePct >= 40.0 -> Triple("Borderline • Needs Revision", "सीमांत स्कोर • रिवीजन आवश्यक", "ASPIRANT")
            else -> Triple("Foundation Stage • Practice PYQs", "फाउंडेशन स्तर • अधिक अभ्यास करें", "ASPIRANT")
        }

        return StudentRankInfo(
            allIndiaRank = computedRank,
            totalCandidates = totalCandidates,
            percentile = percentile,
            scorePercentage = (scorePct * 10.0).roundToInt() / 10.0,
            cutoffMarks = cutoffMarks,
            isCutoffCleared = isCutoffCleared,
            rankTierTitleEn = tierEn,
            rankTierTitleHi = tierHi,
            rankBadgeCode = badgeCode
        )
    }

    /**
     * Generates the Top Scorer Leaderboard for the given [MockTest] and dynamically inserts
     * the current student at their score-based rank position.
     */
    fun buildTopScorerLeaderboard(
        test: MockTest,
        attempt: UserTestAttempt,
        studentName: String,
        rankInfo: StudentRankInfo,
        studentTargetExam: String = ""
    ): List<LeaderboardScorerEntry> {
        val maxMarks = test.totalMarks.coerceAtLeast(1)
        val totalDurationSecs = (test.durationMinutes.coerceAtLeast(1) * 60)

        // Benchmark Top Scorers scaled to this test's totalMarks and duration
        val benchmarkTemplates = listOf(
            Triple("Aarav Sharma", "Prayagraj, UP", 0.94),
            Triple("Priya Verma", "Dehradun, UK", 0.91),
            Triple("Vikramaditya Singh", "Patna, Bihar", 0.88),
            Triple("Ananya Joshi", "New Delhi", 0.85),
            Triple("Rohan तिवारी (Tiwari)", "Lucknow, UP", 0.82),
            Triple("Sneha Rawat", "Haldwani, UK", 0.79),
            Triple("Karan प्रताप (Pratap)", "Jaipur, RJ", 0.76)
        )

        val peerEntries = benchmarkTemplates.mapIndexed { idx, (name, city, ratio) ->
            val rawScore = ((maxMarks * ratio) * 100.0).roundToInt() / 100.0
            val acc = (95 - idx * 2).coerceIn(75, 98)
            val timeSecs = (totalDurationSecs * (0.64 + idx * 0.03)).roundToInt().coerceIn(60, totalDurationSecs)
            LeaderboardScorerEntry(
                rank = idx + 1,
                studentName = name,
                stateOrCenter = city,
                score = rawScore,
                totalMarks = maxMarks,
                accuracyPercent = acc,
                timeTakenSeconds = timeSecs,
                badgeLabel = when (idx) {
                    0 -> "AIR #1 • Gold Topper"
                    1 -> "AIR #2 • Silver Medalist"
                    2 -> "AIR #3 • Bronze Medalist"
                    else -> "Top 1% Merit"
                },
                isCurrentUser = false
            )
        }

        val studentAccuracy = if (attempt.correctCount + attempt.wrongCount > 0) {
            ((attempt.correctCount.toDouble() / (attempt.correctCount + attempt.wrongCount).toDouble()) * 100.0).roundToInt()
        } else {
            0
        }

        val cleanStudentName = studentName.ifBlank { "You (Aspirant)" }
        val targetExamSubLabel = if (studentTargetExam.isNotBlank()) {
            "$studentTargetExam • All-India Live Rank"
        } else {
            "All-India Live Rank"
        }
        val userEntry = LeaderboardScorerEntry(
            rank = rankInfo.allIndiaRank,
            studentName = "$cleanStudentName (You)",
            stateOrCenter = targetExamSubLabel,
            score = (attempt.score * 100.0).roundToInt() / 100.0,
            totalMarks = maxMarks,
            accuracyPercent = studentAccuracy,
            timeTakenSeconds = attempt.timeSpentSeconds.coerceAtLeast(1),
            badgeLabel = "AIR #${rankInfo.allIndiaRank} • ${rankInfo.percentile}%ile",
            isCurrentUser = true
        )

        val combined = (peerEntries + userEntry)
            .sortedWith(
                compareByDescending<LeaderboardScorerEntry> { it.score }
                    .thenByDescending { it.accuracyPercent }
                    .thenBy { it.timeTakenSeconds }
            )

        // Assign sequential leaderboard display ranks if the user beat any top scorers
        val rankedList = combined.mapIndexed { idx, entry ->
            val effectiveRank = if (entry.isCurrentUser) {
                if (idx < peerEntries.size) idx + 1 else rankInfo.allIndiaRank.coerceAtLeast(idx + 1)
            } else {
                idx + 1
            }
            entry.copy(
                rank = effectiveRank,
                badgeLabel = if (entry.isCurrentUser) {
                    "AIR #$effectiveRank • ${rankInfo.percentile}%ile"
                } else {
                    when (effectiveRank) {
                        1 -> "AIR #1 • Gold Topper"
                        2 -> "AIR #2 • Silver Medalist"
                        3 -> "AIR #3 • Bronze Medalist"
                        else -> "Top 1% Merit"
                    }
                }
            )
        }

        // Keep Top 6 + ensure the current user is always visible in the list
        val topSix = rankedList.take(6)
        return if (topSix.any { it.isCurrentUser }) {
            topSix
        } else {
            topSix + rankedList.first { it.isCurrentUser }
        }
    }

    /**
     * Builds the full [CompleteTestAnalyticsReport] for any [MockTest] and [UserTestAttempt].
     */
    fun generateAnalyticsReport(
        test: MockTest,
        attempt: UserTestAttempt,
        userAnswers: Map<Int, Int>,
        studentName: String = "You (Student)",
        studentTargetExam: String = ""
    ): CompleteTestAnalyticsReport {
        val questions = test.questions
        val totalQ = questions.size.coerceAtLeast(1)
        val totalDurationSecs = (test.durationMinutes.coerceAtLeast(1) * 60)
        val timeSpent = attempt.timeSpentSeconds.coerceIn(0, totalDurationSecs)
        val timeRemaining = (totalDurationSecs - timeSpent).coerceAtLeast(0)

        val positiveEarned = ((attempt.correctCount * test.positiveMarks) * 100.0).roundToInt() / 100.0
        val negativeDeducted = ((attempt.wrongCount * test.negativeMarks) * 100.0).roundToInt() / 100.0
        val attemptedCount = attempt.correctCount + attempt.wrongCount
        val accuracyPct = if (attemptedCount > 0) {
            ((attempt.correctCount.toDouble() / attemptedCount.toDouble()) * 100.0).roundToInt()
        } else {
            0
        }
        val attemptRatePct = ((attemptedCount.toDouble() / totalQ.toDouble()) * 100.0).roundToInt().coerceIn(0, 100)

        // 1. Subject-Wise Breakdown
        val groupedBySubject = questions.groupBy { q ->
            q.subject.trim().ifBlank { test.examName }
        }
        val subjectBreakdown = groupedBySubject.map { (subjectName, subjQuestions) ->
            var sCorrect = 0
            var sWrong = 0
            var sSkipped = 0
            subjQuestions.forEach { q ->
                val ans = userAnswers[q.id]
                when {
                    ans == null -> sSkipped++
                    ans == q.correctIndex -> sCorrect++
                    else -> sWrong++
                }
            }
            val sAttempted = sCorrect + sWrong
            val sAcc = if (sAttempted > 0) ((sCorrect.toDouble() / sAttempted.toDouble()) * 100.0).roundToInt() else 0
            val sMarks = ((sCorrect * test.positiveMarks) - (sWrong * test.negativeMarks)).coerceAtLeast(0.0)
            val sMaxMarks = subjQuestions.size * test.positiveMarks
            SubjectWiseAnalysisItem(
                subjectName = subjectName,
                totalQuestions = subjQuestions.size,
                correctCount = sCorrect,
                wrongCount = sWrong,
                skippedCount = sSkipped,
                accuracyPercent = sAcc,
                marksObtained = (sMarks * 100.0).roundToInt() / 100.0,
                maxMarks = (sMaxMarks * 100.0).roundToInt() / 100.0
            )
        }.sortedByDescending { it.totalQuestions }

        // 2. Difficulty Level Breakdown (Easy, Moderate, Hard)
        val diffMap = mutableMapOf(
            QuestionDifficultyBucket.EASY to Triple(0, 0, 0),     // correct, wrong, skipped
            QuestionDifficultyBucket.MODERATE to Triple(0, 0, 0),
            QuestionDifficultyBucket.HARD to Triple(0, 0, 0)
        )
        questions.forEachIndexed { idx, q ->
            val bucket = classifyQuestionDifficulty(q, idx)
            val currentTriple = diffMap[bucket] ?: Triple(0, 0, 0)
            val ans = userAnswers[q.id]
            val updated = when {
                ans == null -> Triple(currentTriple.first, currentTriple.second, currentTriple.third + 1)
                ans == q.correctIndex -> Triple(currentTriple.first + 1, currentTriple.second, currentTriple.third)
                else -> Triple(currentTriple.first, currentTriple.second + 1, currentTriple.third)
            }
            diffMap[bucket] = updated
        }

        val difficultyBreakdown = QuestionDifficultyBucket.entries.map { bucket ->
            val (c, w, s) = diffMap[bucket] ?: Triple(0, 0, 0)
            val bTotal = c + w + s
            val bAttempted = c + w
            val bAcc = if (bAttempted > 0) ((c.toDouble() / bAttempted.toDouble()) * 100.0).roundToInt() else 0
            DifficultyAnalysisItem(
                bucket = bucket,
                totalQuestions = bTotal,
                correctCount = c,
                wrongCount = w,
                skippedCount = s,
                accuracyPercent = bAcc
            )
        }

        // 3. Time Taken Analysis
        val timeUsedPct = ((timeSpent.toDouble() / totalDurationSecs.toDouble()) * 100.0).roundToInt().coerceIn(0, 100)
        val avgPerAttempted = if (attemptedCount > 0) {
            ((timeSpent.toDouble() / attemptedCount.toDouble()) * 10.0).roundToInt() / 10.0
        } else {
            0.0
        }
        val avgPerTotal = ((timeSpent.toDouble() / totalQ.toDouble()) * 10.0).roundToInt() / 10.0
        val idealPerQuestion = ((totalDurationSecs.toDouble() / totalQ.toDouble()) * 10.0).roundToInt() / 10.0

        val (speedEn, speedHi) = when {
            attemptedCount == 0 -> "No Questions Attempted" to "कोई प्रश्न हल नहीं किया गया"
            avgPerAttempted <= idealPerQuestion * 0.75 && accuracyPct >= 75 ->
                "Topper Speed & High Accuracy" to "टॉपर गति एवं उच्च सटीकता"
            avgPerAttempted <= idealPerQuestion && accuracyPct >= 60 ->
                "Optimal Exam Pace" to "संतुलित एवं आदर्श परीक्षा गति"
            avgPerAttempted > idealPerQuestion ->
                "Slow Pace — Practice Time Management" to "धीमी गति — समय प्रबंधन का अभ्यास करें"
            else ->
                "Fast Pace — Avoid Negative Marking" to "तेज़ गति — नेगेटिव मार्किंग से बचें"
        }

        val timeReport = TimeAnalysisReport(
            totalDurationSeconds = totalDurationSecs,
            timeSpentSeconds = timeSpent,
            timeRemainingSeconds = timeRemaining,
            timeUsedPercent = timeUsedPct,
            avgSecondsPerAttemptedQuestion = avgPerAttempted,
            avgSecondsPerTotalQuestion = avgPerTotal,
            idealSecondsPerQuestion = idealPerQuestion,
            speedVerdictEn = speedEn,
            speedVerdictHi = speedHi
        )

        // 4. Rank & Leaderboard
        val baseRankInfo = calculateStudentRank(
            score = attempt.score,
            totalMarks = test.totalMarks,
            correctCount = attempt.correctCount,
            wrongCount = attempt.wrongCount,
            timeSpentSeconds = timeSpent,
            totalDurationSeconds = totalDurationSecs
        )

        val leaderboard = buildTopScorerLeaderboard(
            test = test,
            attempt = attempt,
            studentName = studentName,
            rankInfo = baseRankInfo,
            studentTargetExam = studentTargetExam
        )

        val userLeaderboardEntry = leaderboard.firstOrNull { it.isCurrentUser }
        val finalRankInfo = if (userLeaderboardEntry != null && userLeaderboardEntry.rank < baseRankInfo.allIndiaRank) {
            baseRankInfo.copy(allIndiaRank = userLeaderboardEntry.rank)
        } else {
            baseRankInfo
        }

        return CompleteTestAnalyticsReport(
            rankInfo = finalRankInfo,
            correctCount = attempt.correctCount,
            wrongCount = attempt.wrongCount,
            skippedCount = attempt.unattemptedCount,
            totalQuestions = totalQ,
            positiveMarksEarned = positiveEarned,
            negativeMarksDeducted = negativeDeducted,
            netScore = (attempt.score * 100.0).roundToInt() / 100.0,
            totalMarks = test.totalMarks,
            accuracyPercent = accuracyPct,
            attemptRatePercent = attemptRatePct,
            subjectBreakdown = subjectBreakdown,
            difficultyBreakdown = difficultyBreakdown,
            timeReport = timeReport,
            leaderboard = leaderboard
        )
    }
}

/**
 * 1. Student Rank & Cutoff Qualification Card
 */
@Composable
fun StudentRankSummaryCard(
    report: CompleteTestAnalyticsReport,
    isHi: Boolean,
    modifier: Modifier = Modifier
) {
    val rank = report.rankInfo
    val badgeColor = when (rank.rankBadgeCode) {
        "TOPPER" -> SaffronGold
        "MERIT" -> Color(0xFF38BDF8)
        "QUALIFIED" -> EmeraldSuccess
        else -> Color(0xFFF59E0B)
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 12.dp)
            .border(1.5.dp, badgeColor.copy(alpha = 0.7f), RoundedCornerShape(16.dp))
            .testTag("student_rank_summary_card"),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    Box(
                        modifier = Modifier
                            .size(38.dp)
                            .clip(CircleShape)
                            .background(badgeColor.copy(alpha = 0.2f))
                            .border(1.dp, badgeColor, CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.EmojiEvents,
                            contentDescription = "Student Rank",
                            tint = badgeColor,
                            modifier = Modifier.size(22.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        Text(
                            text = if (isHi) "ऑल इंडिया रैंक एवं मेरिट विश्लेषण" else "ALL-INDIA STUDENT RANK SYSTEM",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = SaffronGold,
                            letterSpacing = 0.6.sp
                        )
                        Text(
                            text = if (isHi) rank.rankTierTitleHi else rank.rankTierTitleEn,
                            fontSize = 13.5.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }

                // Prominent Rank Pill
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .background(badgeColor)
                        .padding(horizontal = 12.dp, vertical = 6.dp)
                        .testTag("student_air_rank_badge"),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "AIR #${rank.allIndiaRank}",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Navy900,
                        maxLines = 1,
                        softWrap = false
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // 3-Column Rank Metrics Strip: All-India Rank, Percentile, Cutoff Status
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFF1E293B))
                    .padding(vertical = 10.dp, horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "#${rank.allIndiaRank} / ${rank.totalCandidates}",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = SaffronGold,
                        modifier = Modifier.testTag("student_rank_fraction_text")
                    )
                    Text(
                        text = if (isHi) "अखिल भारतीय रैंक" else "All-India Rank",
                        fontSize = 10.sp,
                        color = Color(0xFF94A3B8)
                    )
                }

                Box(
                    modifier = Modifier
                        .width(1.dp)
                        .height(28.dp)
                        .background(Color(0xFF334155))
                )

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "${rank.percentile}%ile",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF38BDF8),
                        modifier = Modifier.testTag("student_percentile_text")
                    )
                    Text(
                        text = if (isHi) "परसेंटाइल स्कोर" else "Percentile",
                        fontSize = 10.sp,
                        color = Color(0xFF94A3B8)
                    )
                }

                Box(
                    modifier = Modifier
                        .width(1.dp)
                        .height(28.dp)
                        .background(Color(0xFF334155))
                )

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = if (rank.isCutoffCleared) {
                            if (isHi) "उत्तीर्ण (Cleared)" else "CLEARED ✓"
                        } else {
                            "${rank.cutoffMarks} Marks"
                        },
                        fontSize = 13.5.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = if (rank.isCutoffCleared) EmeraldSuccess else Color(0xFFF59E0B),
                        modifier = Modifier.testTag("student_cutoff_status_text")
                    )
                    Text(
                        text = if (isHi) "अनुमानित कटऑफ (${rank.cutoffMarks})" else "Est. Cutoff (${rank.cutoffMarks})",
                        fontSize = 10.sp,
                        color = Color(0xFF94A3B8)
                    )
                }
            }
        }
    }
}

/**
 * 2. Visual Analysis Chart of Test: Correct, Wrong & Skipped Questions Donut + Marks Breakdown
 */
@Composable
fun TestResponseAnalysisChartCard(
    report: CompleteTestAnalyticsReport,
    isHi: Boolean,
    selectedQuestionFilter: String,
    onSelectQuestionFilter: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val total = report.totalQuestions.coerceAtLeast(1)
    val correctFraction = report.correctCount.toFloat() / total.toFloat()
    val wrongFraction = report.wrongCount.toFloat() / total.toFloat()
    val skippedFraction = report.skippedCount.toFloat() / total.toFloat()

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 12.dp)
            .testTag("test_analysis_chart_card"),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Analytics,
                        contentDescription = "Test Analysis Chart",
                        tint = Navy900,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = if (isHi)
                            "टेस्ट विश्लेषण चार्ट (सही, गलत एवं छोड़े गए प्रश्न)"
                        else
                            "Test Performance Chart (Correct, Wrong & Skipped)",
                        fontSize = 13.5.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Navy900
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Donut Chart + Detailed Legend Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Multi-Segment Donut Chart
                Box(
                    modifier = Modifier
                        .size(116.dp)
                        .testTag("test_analysis_donut_chart"),
                    contentAlignment = Alignment.Center
                ) {
                    Canvas(modifier = Modifier.size(104.dp)) {
                        val strokeWidth = 14.dp.toPx()
                        val diameter = size.minDimension - strokeWidth
                        val topLeft = Offset(strokeWidth / 2f, strokeWidth / 2f)
                        val arcSize = Size(diameter, diameter)

                        // Background Track
                        drawArc(
                            color = Color(0xFFE2E8F0),
                            startAngle = 0f,
                            sweepAngle = 360f,
                            useCenter = false,
                            topLeft = topLeft,
                            size = arcSize,
                            style = Stroke(width = strokeWidth)
                        )

                        var currentStartAngle = -90f
                        val cSweep = correctFraction * 360f
                        val wSweep = wrongFraction * 360f
                        val sSweep = skippedFraction * 360f

                        if (sSweep > 0f) {
                            drawArc(
                                color = Color(0xFF94A3B8),
                                startAngle = currentStartAngle,
                                sweepAngle = sSweep,
                                useCenter = false,
                                topLeft = topLeft,
                                size = arcSize,
                                style = Stroke(width = strokeWidth, cap = StrokeCap.Butt)
                            )
                            currentStartAngle += sSweep
                        }
                        if (wSweep > 0f) {
                            drawArc(
                                color = Color(0xFFEF4444),
                                startAngle = currentStartAngle,
                                sweepAngle = wSweep,
                                useCenter = false,
                                topLeft = topLeft,
                                size = arcSize,
                                style = Stroke(width = strokeWidth, cap = StrokeCap.Butt)
                            )
                            currentStartAngle += wSweep
                        }
                        if (cSweep > 0f) {
                            drawArc(
                                color = EmeraldSuccess,
                                startAngle = currentStartAngle,
                                sweepAngle = cSweep,
                                useCenter = false,
                                topLeft = topLeft,
                                size = arcSize,
                                style = Stroke(width = strokeWidth, cap = StrokeCap.Butt)
                            )
                        }
                    }

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "${report.accuracyPercent}%",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Navy900
                        )
                        Text(
                            text = if (isHi) "सटीकता" else "Accuracy",
                            fontSize = 9.5.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF64748B)
                        )
                    }
                }

                // Right Column: Correct, Wrong, Skipped Breakdown with Marks Impact
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    // Correct Row
                    AnalysisMetricRow(
                        dotColor = EmeraldSuccess,
                        label = if (isHi) "सही प्रश्न (Correct)" else "Correct Questions",
                        countText = "${report.correctCount}/$total (${(correctFraction * 100).roundToInt()}%)",
                        marksImpact = "+${"%.2f".format(report.positiveMarksEarned)}",
                        marksColor = EmeraldSuccess,
                        tag = "analysis_correct_row"
                    )
                    // Wrong Row
                    AnalysisMetricRow(
                        dotColor = Color(0xFFEF4444),
                        label = if (isHi) "गलत प्रश्न (Wrong)" else "Wrong Questions",
                        countText = "${report.wrongCount}/$total (${(wrongFraction * 100).roundToInt()}%)",
                        marksImpact = "-${"%.2f".format(report.negativeMarksDeducted)}",
                        marksColor = Color(0xFFDC2626),
                        tag = "analysis_wrong_row"
                    )
                    // Skipped Row
                    AnalysisMetricRow(
                        dotColor = Color(0xFF94A3B8),
                        label = if (isHi) "छोड़े गए (Skipped)" else "Skipped Questions",
                        countText = "${report.skippedCount}/$total (${(skippedFraction * 100).roundToInt()}%)",
                        marksImpact = "0.00",
                        marksColor = Color(0xFF64748B),
                        tag = "analysis_skipped_row"
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Stacked Horizontal Proportion Bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .background(Color(0xFFE2E8F0))
            ) {
                if (report.correctCount > 0) {
                    Box(
                        modifier = Modifier
                            .weight(report.correctCount.toFloat())
                            .fillMaxHeight()
                            .background(EmeraldSuccess)
                    )
                }
                if (report.wrongCount > 0) {
                    Box(
                        modifier = Modifier
                            .weight(report.wrongCount.toFloat())
                            .fillMaxHeight()
                            .background(Color(0xFFEF4444))
                    )
                }
                if (report.skippedCount > 0) {
                    Box(
                        modifier = Modifier
                            .weight(report.skippedCount.toFloat())
                            .fillMaxHeight()
                            .background(Color(0xFFCBD5E1))
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Quick Filter Chips to Filter Scorecard Solutions by Correct / Wrong / Skipped
            Text(
                text = if (isHi)
                    "नीचे दिए गए प्रश्नों को फ़िल्टर करें (Tap to filter solutions):"
                else
                    "Filter Question Solutions Below:",
                fontSize = 10.5.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF64748B)
            )
            Spacer(modifier = Modifier.height(6.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                val filterTabs = listOf(
                    Triple("ALL", if (isHi) "सभी ($total)" else "All ($total)", Navy900),
                    Triple("CORRECT", if (isHi) "सही (${report.correctCount})" else "Correct (${report.correctCount})", EmeraldSuccess),
                    Triple("WRONG", if (isHi) "गलत (${report.wrongCount})" else "Wrong (${report.wrongCount})", Color(0xFFDC2626)),
                    Triple("SKIPPED", if (isHi) "छोड़े (${report.skippedCount})" else "Skipped (${report.skippedCount})", Color(0xFF475569))
                )
                filterTabs.forEach { (code, label, tint) ->
                    val isSelected = selectedQuestionFilter == code
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(8.dp))
                            .background(if (isSelected) tint else Color(0xFFF1F5F9))
                            .border(
                                width = 1.dp,
                                color = if (isSelected) tint else Color(0xFFE2E8F0),
                                shape = RoundedCornerShape(8.dp)
                            )
                            .clickable { onSelectQuestionFilter(code) }
                            .padding(vertical = 6.dp, horizontal = 4.dp)
                            .testTag("scorecard_filter_chip_${code.lowercase()}"),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = label,
                            fontSize = 10.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (isSelected) Color.White else tint,
                            maxLines = 1,
                            softWrap = false,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun AnalysisMetricRow(
    dotColor: Color,
    label: String,
    countText: String,
    marksImpact: String,
    marksColor: Color,
    tag: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFFF8FAFC))
            .padding(horizontal = 8.dp, vertical = 5.dp)
            .testTag(tag),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .size(9.dp)
                    .clip(CircleShape)
                    .background(dotColor)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Column {
                Text(
                    text = label,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = Navy900,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = countText,
                    fontSize = 10.sp,
                    color = Color(0xFF64748B)
                )
            }
        }
        Text(
            text = marksImpact,
            fontSize = 11.5.sp,
            fontWeight = FontWeight.ExtraBold,
            color = marksColor
        )
    }
}

/**
 * 3. Subject-Wise Question Analysis Card
 */
@Composable
fun SubjectWiseAnalysisCard(
    subjectBreakdown: List<SubjectWiseAnalysisItem>,
    isHi: Boolean,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 12.dp)
            .testTag("subject_wise_analysis_card"),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.TrendingUp,
                        contentDescription = "Subject-Wise Analysis",
                        tint = Navy900,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = if (isHi)
                            "विषयवार प्रश्न विश्लेषण (Subject-Wise Breakdown)"
                        else
                            "Subject-Wise Question Analysis",
                        fontSize = 13.5.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Navy900
                    )
                }
                Text(
                    text = "${subjectBreakdown.size} Subjects",
                    fontSize = 10.5.sp,
                    fontWeight = FontWeight.Bold,
                    color = SaffronGold
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                subjectBreakdown.forEachIndexed { idx, item ->
                    val safeTotal = item.totalQuestions.coerceAtLeast(1)
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color(0xFFF8FAFC))
                            .border(1.dp, Color(0xFFE2E8F0), RoundedCornerShape(10.dp))
                            .padding(10.dp)
                            .testTag("subject_analysis_row_$idx")
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = item.subjectName,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Navy900,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.weight(1f)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Marks: ${"%.2f".format(item.marksObtained)}/${"%.0f".format(item.maxMarks)} • Acc: ${item.accuracyPercent}%",
                                fontSize = 10.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (item.accuracyPercent >= 70) EmeraldSuccess else if (item.accuracyPercent >= 45) Color(0xFFD97706) else Color(0xFFDC2626)
                            )
                        }

                        Spacer(modifier = Modifier.height(6.dp))

                        // Subject Horizontal Stacked Bar
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(7.dp)
                                .clip(RoundedCornerShape(4.dp))
                                .background(Color(0xFFE2E8F0))
                        ) {
                            if (item.correctCount > 0) {
                                Box(
                                    modifier = Modifier
                                        .weight(item.correctCount.toFloat() / safeTotal)
                                        .fillMaxHeight()
                                        .background(EmeraldSuccess)
                                )
                            }
                            if (item.wrongCount > 0) {
                                Box(
                                    modifier = Modifier
                                        .weight(item.wrongCount.toFloat() / safeTotal)
                                        .fillMaxHeight()
                                        .background(Color(0xFFEF4444))
                                )
                            }
                            if (item.skippedCount > 0) {
                                Box(
                                    modifier = Modifier
                                        .weight(item.skippedCount.toFloat() / safeTotal)
                                        .fillMaxHeight()
                                        .background(Color(0xFFCBD5E1))
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(5.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Total: ${item.totalQuestions} Qs",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color(0xFF475569)
                            )
                            Text(
                                text = "✓ ${item.correctCount} Correct",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                color = EmeraldSuccess
                            )
                            Text(
                                text = "✗ ${item.wrongCount} Wrong",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFFEF4444)
                            )
                            Text(
                                text = "○ ${item.skippedCount} Skipped",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color(0xFF64748B)
                            )
                        }
                    }
                }
            }
        }
    }
}

/**
 * 4. Difficulty Level of Questions Analysis Card (Easy, Moderate, Hard)
 */
@Composable
fun DifficultyLevelAnalysisCard(
    difficultyBreakdown: List<DifficultyAnalysisItem>,
    isHi: Boolean,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 12.dp)
            .testTag("difficulty_level_analysis_card"),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
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
                        contentDescription = "Difficulty Level Analysis",
                        tint = Navy900,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = if (isHi)
                            "कठिनाई स्तर विश्लेषण (Difficulty Level of Questions)"
                        else
                            "Question Difficulty Level Analysis",
                        fontSize = 13.5.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Navy900
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                difficultyBreakdown.forEach { item ->
                    val tierColor = Color(item.bucket.colorHex)
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(12.dp))
                            .background(tierColor.copy(alpha = 0.08f))
                            .border(1.dp, tierColor.copy(alpha = 0.4f), RoundedCornerShape(12.dp))
                            .padding(10.dp)
                            .testTag("difficulty_tier_${item.bucket.name.lowercase()}"),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(6.dp))
                                .background(tierColor)
                                .padding(horizontal = 8.dp, vertical = 2.dp)
                        ) {
                            Text(
                                text = if (isHi) item.bucket.labelHi else item.bucket.labelEn,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.White,
                                maxLines = 1,
                                softWrap = false
                            )
                        }

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = "${item.totalQuestions} Qs",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Navy900
                        )
                        Text(
                            text = "Acc: ${item.accuracyPercent}%",
                            fontSize = 10.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = tierColor
                        )

                        Spacer(modifier = Modifier.height(6.dp))
                        HorizontalDivider(color = tierColor.copy(alpha = 0.25f))
                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = "✓ ${item.correctCount}  •  ✗ ${item.wrongCount}",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = Navy800
                        )
                        Text(
                            text = "Skipped: ${item.skippedCount}",
                            fontSize = 9.5.sp,
                            color = Color(0xFF64748B)
                        )
                    }
                }
            }
        }
    }
}

/**
 * 5. Time Taken & Speed Management Analysis Card
 */
@Composable
fun TimeTakenAnalysisCard(
    timeReport: TimeAnalysisReport,
    isHi: Boolean,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 12.dp)
            .testTag("time_taken_analysis_card"),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Speed,
                        contentDescription = "Time Taken Analysis",
                        tint = Navy900,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = if (isHi)
                            "समय प्रबंधन एवं गति विश्लेषण (Time Taken Analysis)"
                        else
                            "Time Taken & Speed Analysis",
                        fontSize = 13.5.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Navy900
                    )
                }
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(Color(0xFFEFF6FF))
                        .border(1.dp, Color(0xFFBFDBFE), RoundedCornerShape(6.dp))
                        .padding(horizontal = 8.dp, vertical = 3.dp)
                ) {
                    Text(
                        text = "${timeReport.timeUsedPercent}% Time Used",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF1D4ED8)
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                TimeMetricBox(
                    title = if (isHi) "कुल लगा समय" else "Time Taken",
                    value = formatElapsedDuration(timeReport.timeSpentSeconds),
                    subLabel = "of ${formatElapsedDuration(timeReport.totalDurationSeconds)}",
                    accentColor = Navy900,
                    modifier = Modifier.weight(1f)
                )
                TimeMetricBox(
                    title = if (isHi) "समय/हल प्रश्न" else "Avg / Attempted Q",
                    value = "${timeReport.avgSecondsPerAttemptedQuestion}s",
                    subLabel = "Ideal: ${timeReport.idealSecondsPerQuestion}s/Q",
                    accentColor = EmeraldSuccess,
                    modifier = Modifier.weight(1f)
                )
                TimeMetricBox(
                    title = if (isHi) "शेष बचा समय" else "Time Saved",
                    value = formatElapsedDuration(timeReport.timeRemainingSeconds),
                    subLabel = if (isHi) "बचा हुआ समय" else "Remaining",
                    accentColor = Color(0xFF0284C7),
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Time Utilization Bar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(Color(0xFFE2E8F0))
            ) {
                val fraction = (timeReport.timeUsedPercent / 100f).coerceIn(0f, 1f)
                if (fraction > 0f) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(fraction)
                            .height(8.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .background(
                                Brush.horizontalGradient(
                                    listOf(EmeraldSuccess, SaffronGold)
                                )
                            )
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = if (isHi)
                    "गति निष्कर्ष: ${timeReport.speedVerdictHi}"
                else
                    "Speed Verdict: ${timeReport.speedVerdictEn}",
                fontSize = 11.5.sp,
                fontWeight = FontWeight.Bold,
                color = Navy800
            )
        }
    }
}

@Composable
private fun TimeMetricBox(
    title: String,
    value: String,
    subLabel: String,
    accentColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xFFF8FAFC))
            .border(1.dp, Color(0xFFE2E8F0), RoundedCornerShape(10.dp))
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontSize = 10.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF64748B),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.height(3.dp))
        Text(
            text = value,
            fontSize = 14.sp,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.Monospace,
            color = accentColor,
            maxLines = 1,
            softWrap = false
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = subLabel,
            fontSize = 9.5.sp,
            color = Color(0xFF94A3B8),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

/**
 * 6. Top Scorer Leaderboard Card (Top 3 Podium + Ranked Table + Live Student Position)
 */
@Composable
fun TopScorerLeaderboardCard(
    leaderboard: List<LeaderboardScorerEntry>,
    examName: String,
    isHi: Boolean,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 12.dp)
            .border(1.5.dp, SaffronGold.copy(alpha = 0.7f), RoundedCornerShape(16.dp))
            .testTag("top_scorer_leaderboard_card"),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Header
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
                            .size(32.dp)
                            .clip(CircleShape)
                            .background(Color(0xFFFEF3C7)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Leaderboard,
                            contentDescription = "Top Scorer Leaderboard",
                            tint = Color(0xFFD97706),
                            modifier = Modifier.size(18.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(
                            text = if (isHi)
                                "टॉप स्कोरर लीडरबोर्ड (Top Scorer Leaderboard)"
                            else
                                "Top Scorer Leaderboard • $examName",
                            fontSize = 13.5.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Navy900,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = if (isHi)
                                "अंक, सटीकता एवं समय के आधार पर ऑल-इंडिया मेरिट रैंक"
                            else
                                "Ranked by Score, Accuracy % & Completion Speed",
                            fontSize = 10.5.sp,
                            color = Color(0xFF64748B)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Top 3 Podium Row
            val topThree = leaderboard.take(3)
            if (topThree.isNotEmpty()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color(0xFF0F172A))
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    topThree.forEachIndexed { idx, entry ->
                        val medalColor = when (idx) {
                            0 -> Color(0xFFFACC15) // Gold
                            1 -> Color(0xFFE2E8F0) // Silver
                            else -> Color(0xFFF59E0B) // Bronze
                        }
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .clip(RoundedCornerShape(10.dp))
                                .background(
                                    if (entry.isCurrentUser) Color(0xFF1E3A8A) else Color(0xFF1E293B)
                                )
                                .border(
                                    width = if (entry.isCurrentUser) 1.5.dp else 1.dp,
                                    color = if (entry.isCurrentUser) SaffronGold else medalColor.copy(alpha = 0.5f),
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .padding(8.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(24.dp)
                                    .clip(CircleShape)
                                    .background(medalColor),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "#${entry.rank}",
                                    fontSize = 10.5.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Navy900
                                )
                            }
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = entry.studentName,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                textAlign = TextAlign.Center
                            )
                            Text(
                                text = "${"%.2f".format(entry.score)}/${entry.totalMarks}",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = medalColor
                            )
                            Text(
                                text = "Acc: ${entry.accuracyPercent}%",
                                fontSize = 9.5.sp,
                                color = Color(0xFF94A3B8)
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(12.dp))
            }

            // Full Leaderboard Table Rows
            Column(verticalArrangement = Arrangement.spacedBy(7.dp)) {
                leaderboard.forEachIndexed { index, scorer ->
                    val isUser = scorer.isCurrentUser
                    val rowBg = if (isUser) Color(0xFFFEFCE8) else Color(0xFFF8FAFC)
                    val rowBorder = if (isUser) SaffronGold else Color(0xFFE2E8F0)

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(rowBg)
                            .border(if (isUser) 1.5.dp else 1.dp, rowBorder, RoundedCornerShape(10.dp))
                            .padding(horizontal = 10.dp, vertical = 8.dp)
                            .testTag(if (isUser) "leaderboard_current_user_row" else "leaderboard_row_$index"),
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
                                    .background(
                                        when {
                                            isUser -> SaffronGold
                                            scorer.rank == 1 -> Color(0xFFFEF08A)
                                            scorer.rank == 2 -> Color(0xFFE2E8F0)
                                            scorer.rank == 3 -> Color(0xFFFDE68A)
                                            else -> Color(0xFFE2E8F0)
                                        }
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "#${scorer.rank}",
                                    fontSize = 10.5.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Navy900
                                )
                            }
                            Spacer(modifier = Modifier.width(9.dp))
                            Column(modifier = Modifier.weight(1f)) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text(
                                        text = scorer.studentName,
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = Navy900,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                    if (isUser) {
                                        Spacer(modifier = Modifier.width(6.dp))
                                        Box(
                                            modifier = Modifier
                                                .clip(RoundedCornerShape(4.dp))
                                                .background(EmeraldSuccess)
                                                .padding(horizontal = 5.dp, vertical = 1.dp)
                                        ) {
                                            Text(
                                                text = if (isHi) "आपकी रैंक" else "YOUR RANK",
                                                fontSize = 8.5.sp,
                                                fontWeight = FontWeight.ExtraBold,
                                                color = Color.White
                                            )
                                        }
                                    }
                                }
                                Text(
                                    text = "${scorer.stateOrCenter} • ${scorer.badgeLabel} • Time: ${formatElapsedDuration(scorer.timeTakenSeconds)}",
                                    fontSize = 10.sp,
                                    color = Color(0xFF64748B),
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }

                        Spacer(modifier = Modifier.width(8.dp))

                        Column(horizontalAlignment = Alignment.End) {
                            Text(
                                text = "${"%.2f".format(scorer.score)} / ${scorer.totalMarks}",
                                fontSize = 12.5.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = if (isUser) Color(0xFFB45309) else Navy900
                            )
                            Text(
                                text = "${scorer.accuracyPercent}% Accuracy",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                color = EmeraldSuccess
                            )
                        }
                    }
                }
            }
        }
    }
}
