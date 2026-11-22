package com.example.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.R
import com.example.data.AllIndiaMasterTestPackageData
import com.example.data.QuestionDataTableSpec
import com.example.data.remote.FirestoreQuizTestDocument
import com.example.data.remote.StudentAuthAndProfileRepository
import com.example.model.MockTest
import com.example.model.TestQuestion
import com.example.ui.components.ProfessionalQuestionFormatEngine
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.math.max
import kotlin.math.roundToInt

/**
 * Classifies each line in a multi-statement question so the UI renders
 * Statement 1, Statement 2, Statement 3, Assertion (A), Reason (R),
 * opening stems, and closing prompts on distinct sequential lines.
 */
enum class StatementLineType {
    OPENING_STEM,
    STATEMENT_ITEM,
    ASSERTION_REASON,
    CLOSING_PROMPT
}

/**
 * Represents a single structured line in a multi-statement question.
 */
data class StatementLineItem(
    val lineIndex: Int,
    val badgeLabel: String,
    val bodyText: String,
    val fullLineText: String,
    val lineType: StatementLineType
)

/**
 * Represents a single bar/point in a math/DI visual chart component.
 */
data class MathChartPoint(
    val label: String,
    val value: Float,
    val normalizedFraction: Float,
    val formattedValue: String,
    val isPeakValue: Boolean
)

/**
 * Holds the structured grid and chart data for math/data-interpretation (DI) questions.
 */
data class MathVisualGridChartData(
    val titleEn: String,
    val titleHi: String,
    val headersEn: List<String>,
    val headersHi: List<String>,
    val gridRows: List<List<String>>,
    val chartPoints: List<MathChartPoint>,
    val unitSuffix: String,
    val maxValue: Float,
    val averageValue: Float,
    val peakCategoryLabel: String
)

/**
 * Scorecard summary generated when the user submits a multi-choice quiz.
 */
data class QuizScorecardSummary(
    val testId: String,
    val examKey: String,
    val totalQuestions: Int,
    val attemptedCount: Int,
    val correctCount: Int,
    val wrongCount: Int,
    val unattemptedCount: Int,
    val markedForReviewCount: Int,
    val positiveMarksAwarded: Double,
    val negativeMarksDeducted: Double,
    val finalScore: Double,
    val totalMaxMarks: Int,
    val accuracyPercent: Int,
    val timeSpentSeconds: Int
)

/**
 * Complete UI state managed by [QuizViewModel] for the Firestore-backed multi-choice quiz interface.
 */
data class QuizUiState(
    val examKey: String = "upsc",
    val testId: String = "upsc_flt_mock_1",
    val packageCategory: String = "FULL_LENGTH",
    val subjectTag: String = "General Studies",
    val topicTag: String = "Full-Length Prelim Paper-I",
    val isPaidOnly: Boolean = true,
    val activeTest: MockTest = AllIndiaMasterTestPackageData.getExamPackageEntries("upsc").first().mockTest,
    val currentQuestionIndex: Int = 0,
    val selectedAnswers: Map<Int, Int> = emptyMap(),
    val markedForReviewIds: Set<Int> = emptySet(),
    val visitedQuestionIds: Set<Int> = emptySet(),
    val totalDurationSeconds: Int = 7200,
    val remainingSeconds: Int = 7200,
    val isTimerRunning: Boolean = true,
    val isTimerPaused: Boolean = false,
    val isSubmitted: Boolean = false,
    val isAutoSubmittedOnTimeout: Boolean = false,
    val isDualBilingualView: Boolean = true,
    val isHindiPrimary: Boolean = false,
    val isInstantSolutionVisible: Boolean = false,
    val currentQuestionLinesEn: List<StatementLineItem> = emptyList(),
    val currentQuestionLinesHi: List<StatementLineItem> = emptyList(),
    val currentMathVisualData: MathVisualGridChartData? = null,
    val scorecard: QuizScorecardSummary? = null,
    val isLoadingFromFirestore: Boolean = false,
    val isSyncedWithFirestore: Boolean = false,
    val firestoreSyncStatus: String = "LOCAL_READY",
    val errorMessage: String? = null
) {
    val currentQuestion: TestQuestion?
        get() = activeTest.questions.getOrNull(currentQuestionIndex)

    val totalQuestions: Int
        get() = activeTest.questions.size

    val answeredCount: Int
        get() = selectedAnswers.size

    val unansweredCount: Int
        get() = max(0, totalQuestions - selectedAnswers.size)

    val isCurrentQuestionMultiStatement: Boolean
        get() = currentQuestionLinesEn.count {
            it.lineType == StatementLineType.STATEMENT_ITEM ||
                it.lineType == StatementLineType.ASSERTION_REASON
        } >= 2 || currentQuestionLinesEn.size >= 3

    val hasCurrentQuestionMathVisualData: Boolean
        get() = currentMathVisualData != null

    fun formattedRemainingTime(): String {
        val clamped = remainingSeconds.coerceAtLeast(0)
        val hours = clamped / 3600
        val minutes = (clamped % 3600) / 60
        val seconds = clamped % 60
        return if (hours > 0) {
            String.format("%02d:%02d:%02d", hours, minutes, seconds)
        } else {
            String.format("%02d:%02d", minutes, seconds)
        }
    }
}

/**
 * Manages the multi-choice quiz interface backed by Firestore (`/students/{userId}/quiz_tests/{testId}`),
 * including:
 * 1. Fetching and syncing test metadata & progress with Firestore.
 * 2. Line-by-line sequential statement parsing and rendering state (`Statement 1`, `Statement 2`, `Statement 3`, `Assertion`, `Reason`).
 * 3. Excel-style data grid and visual chart state for mathematics & data interpretation (DI) questions.
 */
class QuizViewModel(
    private val repository: StudentAuthAndProfileRepository? = null
) : ViewModel() {

    private val _uiState = MutableStateFlow(buildInitialState())
    val uiState: StateFlow<QuizUiState> = _uiState.asStateFlow()

    private var activeTestListenerJob: Job? = null

    private fun buildInitialState(): QuizUiState {
        val defaultEntry = AllIndiaMasterTestPackageData.getExamPackageEntries("upsc").first()
        val firstQuestion = defaultEntry.mockTest.questions.firstOrNull()
        val linesEn = firstQuestion?.let { parseLineByLineStatements(it.questionEn, isHindi = false) }.orEmpty()
        val linesHi = firstQuestion?.let { parseLineByLineStatements(it.questionHi, isHindi = true) }.orEmpty()
        val mathData = firstQuestion?.let { extractMathVisualGridAndChart(it) }
        val durationSecs = defaultEntry.mockTest.durationMinutes * 60
        return QuizUiState(
            examKey = defaultEntry.examKey,
            testId = defaultEntry.mockTest.testId,
            packageCategory = defaultEntry.packageCategory.code,
            subjectTag = defaultEntry.subjectGroupEn,
            topicTag = defaultEntry.topicTagEn,
            isPaidOnly = defaultEntry.isPaidOnly,
            activeTest = defaultEntry.mockTest,
            currentQuestionIndex = 0,
            visitedQuestionIds = firstQuestion?.let { setOf(it.id) }.orEmpty(),
            totalDurationSeconds = durationSecs,
            remainingSeconds = durationSecs,
            currentQuestionLinesEn = linesEn,
            currentQuestionLinesHi = linesHi,
            currentMathVisualData = mathData
        )
    }

    /**
     * Loads a test by [examKey] and [testId], fetches/observes its Firestore document at
     * `/students/{userId}/quiz_tests/{testId}` when a repository is configured, and initializes
     * line-by-line statement rendering + math visual chart state for the first question.
     */
    fun loadQuizFromFirestoreOrCatalog(examKey: String, testId: String) {
        val normalizedExam = examKey.trim().lowercase().ifBlank { "upsc" }
        val entries = AllIndiaMasterTestPackageData.getExamPackageEntries(normalizedExam)
        val matchedEntry = entries.firstOrNull {
            it.id.equals(testId, ignoreCase = true) ||
                it.mockTest.testId.equals(testId, ignoreCase = true)
        } ?: entries.first()

        val mockTest = matchedEntry.mockTest
        val firstQ = mockTest.questions.firstOrNull()
        val durationSecs = mockTest.durationMinutes * 60

        _uiState.update {
            it.copy(
                examKey = normalizedExam,
                testId = mockTest.testId,
                packageCategory = matchedEntry.packageCategory.code,
                subjectTag = matchedEntry.subjectGroupEn,
                topicTag = matchedEntry.topicTagEn,
                isPaidOnly = matchedEntry.isPaidOnly,
                activeTest = mockTest,
                currentQuestionIndex = 0,
                selectedAnswers = emptyMap(),
                markedForReviewIds = emptySet(),
                visitedQuestionIds = firstQ?.let { q -> setOf(q.id) }.orEmpty(),
                totalDurationSeconds = durationSecs,
                remainingSeconds = durationSecs,
                isTimerRunning = true,
                isTimerPaused = false,
                isSubmitted = false,
                isAutoSubmittedOnTimeout = false,
                isInstantSolutionVisible = false,
                scorecard = null,
                currentQuestionLinesEn = firstQ?.let { q -> parseLineByLineStatements(q.questionEn, isHindi = false) }.orEmpty(),
                currentQuestionLinesHi = firstQ?.let { q -> parseLineByLineStatements(q.questionHi, isHindi = true) }.orEmpty(),
                currentMathVisualData = firstQ?.let { q -> extractMathVisualGridAndChart(q) },
                isLoadingFromFirestore = repository != null,
                firestoreSyncStatus = if (repository != null) "SYNCING_FIRESTORE" else "LOCAL_READY",
                errorMessage = null
            )
        }

        val repo = repository ?: return
        val uid = repo.currentUserId()
        if (uid.isNullOrBlank()) {
            _uiState.update {
                it.copy(
                    isLoadingFromFirestore = false,
                    firestoreSyncStatus = "GUEST_LOCAL_MODE"
                )
            }
            return
        }

        activeTestListenerJob?.cancel()
        activeTestListenerJob = viewModelScope.launch {
            repo.saveOrSyncQuizTestDocument(
                testId = mockTest.testId,
                examKey = normalizedExam,
                titleEn = mockTest.title,
                titleHi = matchedEntry.topicTagHi.ifBlank { mockTest.title },
                durationMinutes = mockTest.durationMinutes.toLong(),
                totalMarks = mockTest.totalMarks.toLong(),
                questionCount = mockTest.questions.size.toLong(),
                paidOnly = matchedEntry.isPaidOnly
            )

            repo.observeQuizTestDocument(uid, mockTest.testId)
                .catch { e ->
                    Log.e("QuizViewModel", "Failed observing Firestore quiz test document: ${e.message}", e)
                    _uiState.update { state ->
                        state.copy(
                            isLoadingFromFirestore = false,
                            firestoreSyncStatus = "FIRESTORE_ERROR",
                            errorMessage = e.localizedMessage
                        )
                    }
                }
                .collect { firestoreDoc ->
                    if (firestoreDoc != null) {
                        applyFirestoreQuizTestDocument(firestoreDoc)
                    } else {
                        _uiState.update { state ->
                            state.copy(
                                isLoadingFromFirestore = false,
                                firestoreSyncStatus = "LOCAL_CATALOG_FALLBACK"
                            )
                        }
                    }
                }
        }
    }

    /**
     * Applies a [FirestoreQuizTestDocument] snapshot from Firestore to update the active quiz state,
     * resolving the question bank and refreshing the line-by-line statement and math visual data.
     */
    fun applyFirestoreQuizTestDocument(doc: FirestoreQuizTestDocument) {
        val resolvedExamKey = doc.examKey.trim().lowercase().ifBlank { _uiState.value.examKey }
        val entries = AllIndiaMasterTestPackageData.getExamPackageEntries(resolvedExamKey)
        val matchedEntry = entries.firstOrNull {
            it.id.equals(doc.testId, ignoreCase = true) ||
                it.mockTest.testId.equals(doc.testId, ignoreCase = true)
        } ?: entries.first()

        val baseMockTest = matchedEntry.mockTest
        val mergedTest = baseMockTest.copy(
            testId = doc.testId.ifBlank { baseMockTest.testId },
            title = doc.titleEn.ifBlank { baseMockTest.title },
            durationMinutes = if (doc.durationMinutes > 0L) doc.durationMinutes.toInt() else baseMockTest.durationMinutes,
            totalMarks = if (doc.totalMarks > 0L) doc.totalMarks.toInt() else baseMockTest.totalMarks
        )

        val currentIdx = _uiState.value.currentQuestionIndex.coerceIn(0, max(0, mergedTest.questions.lastIndex))
        val currentQ = mergedTest.questions.getOrNull(currentIdx)
        val totalSecs = mergedTest.durationMinutes * 60

        _uiState.update { state ->
            state.copy(
                examKey = resolvedExamKey,
                testId = mergedTest.testId,
                packageCategory = matchedEntry.packageCategory.code,
                subjectTag = matchedEntry.subjectGroupEn,
                topicTag = matchedEntry.topicTagEn,
                isPaidOnly = doc.paidOnly,
                activeTest = mergedTest,
                currentQuestionIndex = currentIdx,
                visitedQuestionIds = currentQ?.let { state.visitedQuestionIds + it.id } ?: state.visitedQuestionIds,
                totalDurationSeconds = totalSecs,
                remainingSeconds = if (state.selectedAnswers.isEmpty() && !state.isSubmitted) totalSecs else state.remainingSeconds,
                currentQuestionLinesEn = currentQ?.let { parseLineByLineStatements(it.questionEn, isHindi = false) }.orEmpty(),
                currentQuestionLinesHi = currentQ?.let { parseLineByLineStatements(it.questionHi, isHindi = true) }.orEmpty(),
                currentMathVisualData = currentQ?.let { extractMathVisualGridAndChart(it) },
                isLoadingFromFirestore = false,
                isSyncedWithFirestore = true,
                firestoreSyncStatus = "FIRESTORE_SYNCED",
                errorMessage = null
            )
        }
    }

    /**
     * Loads any custom [MockTest] directly into [QuizViewModel] and computes the line-by-line
     * multi-statement items and math visual grid/chart data for the initial question.
     */
    fun setCustomMockTest(mockTest: MockTest, examKey: String = mockTest.categoryId.ifBlank { "upsc" }) {
        val firstQ = mockTest.questions.firstOrNull()
        val durationSecs = mockTest.durationMinutes * 60
        _uiState.update {
            it.copy(
                examKey = examKey,
                testId = mockTest.testId,
                activeTest = mockTest,
                currentQuestionIndex = 0,
                selectedAnswers = emptyMap(),
                markedForReviewIds = emptySet(),
                visitedQuestionIds = firstQ?.let { q -> setOf(q.id) }.orEmpty(),
                totalDurationSeconds = durationSecs,
                remainingSeconds = durationSecs,
                isTimerRunning = true,
                isTimerPaused = false,
                isSubmitted = false,
                isAutoSubmittedOnTimeout = false,
                isInstantSolutionVisible = false,
                scorecard = null,
                currentQuestionLinesEn = firstQ?.let { q -> parseLineByLineStatements(q.questionEn, isHindi = false) }.orEmpty(),
                currentQuestionLinesHi = firstQ?.let { q -> parseLineByLineStatements(q.questionHi, isHindi = true) }.orEmpty(),
                currentMathVisualData = firstQ?.let { q -> extractMathVisualGridAndChart(q) }
            )
        }
    }

    /**
     * Selects an option (0..3) for the given [questionId] in the multi-choice quiz.
     */
    fun selectOption(questionId: Int, optionIndex: Int) {
        if (_uiState.value.isSubmitted) return
        val coercedOption = optionIndex.coerceIn(0, 3)
        _uiState.update { state ->
            state.copy(
                selectedAnswers = state.selectedAnswers + (questionId to coercedOption),
                visitedQuestionIds = state.visitedQuestionIds + questionId,
                isInstantSolutionVisible = true
            )
        }
    }

    /**
     * Clears the selected answer for the current question.
     */
    fun clearCurrentResponse() {
        val currentQ = _uiState.value.currentQuestion ?: return
        if (_uiState.value.isSubmitted) return
        _uiState.update { state ->
            state.copy(
                selectedAnswers = state.selectedAnswers - currentQ.id,
                isInstantSolutionVisible = false
            )
        }
    }

    /**
     * Toggles the "Mark for Review" flag on the current question.
     */
    fun toggleMarkForReview(questionId: Int = _uiState.value.currentQuestion?.id ?: -1) {
        if (questionId < 0 || _uiState.value.isSubmitted) return
        _uiState.update { state ->
            val updatedReviewSet = if (questionId in state.markedForReviewIds) {
                state.markedForReviewIds - questionId
            } else {
                state.markedForReviewIds + questionId
            }
            state.copy(markedForReviewIds = updatedReviewSet)
        }
    }

    /**
     * Navigates to a specific question index and refreshes the line-by-line multi-statement state
     * and math visual grid/chart data for that question.
     */
    fun goToQuestion(index: Int) {
        val questions = _uiState.value.activeTest.questions
        if (questions.isEmpty()) return
        val targetIdx = index.coerceIn(0, questions.lastIndex)
        val targetQ = questions[targetIdx]
        _uiState.update { state ->
            state.copy(
                currentQuestionIndex = targetIdx,
                visitedQuestionIds = state.visitedQuestionIds + targetQ.id,
                isInstantSolutionVisible = state.selectedAnswers.containsKey(targetQ.id) || state.isSubmitted,
                currentQuestionLinesEn = parseLineByLineStatements(targetQ.questionEn, isHindi = false),
                currentQuestionLinesHi = parseLineByLineStatements(targetQ.questionHi, isHindi = true),
                currentMathVisualData = extractMathVisualGridAndChart(targetQ)
            )
        }
    }

    fun nextQuestion() {
        val nextIdx = _uiState.value.currentQuestionIndex + 1
        if (nextIdx < _uiState.value.totalQuestions) {
            goToQuestion(nextIdx)
        }
    }

    fun previousQuestion() {
        val prevIdx = _uiState.value.currentQuestionIndex - 1
        if (prevIdx >= 0) {
            goToQuestion(prevIdx)
        }
    }

    /**
     * Toggles bilingual dual display (English + Hindi together) vs single primary language.
     */
    fun toggleBilingualMode() {
        _uiState.update { it.copy(isDualBilingualView = !it.isDualBilingualView) }
    }

    /**
     * Switches the primary language between English and Hindi.
     */
    fun setHindiPrimary(isHindi: Boolean) {
        _uiState.update { it.copy(isHindiPrimary = isHindi) }
    }

    /**
     * Ticks the quiz countdown timer and auto-submits when time reaches 0.
     */
    fun tickTimer(seconds: Int = 1) {
        val state = _uiState.value
        if (!state.isTimerRunning || state.isTimerPaused || state.isSubmitted) return
        val nextRemaining = (state.remainingSeconds - seconds).coerceAtLeast(0)
        if (nextRemaining == 0) {
            _uiState.update { it.copy(remainingSeconds = 0) }
            submitQuiz(autoSubmitted = true)
        } else {
            _uiState.update { it.copy(remainingSeconds = nextRemaining) }
        }
    }

    fun togglePauseTimer() {
        _uiState.update { it.copy(isTimerPaused = !it.isTimerPaused) }
    }

    /**
     * Submits the multi-choice quiz, computes the scorecard with negative marking,
     * and persists the attempt record to Firestore (`/students/{userId}/test_attempts/{attemptId}`)
     * if the user is authenticated.
     */
    fun submitQuiz(autoSubmitted: Boolean = false): QuizScorecardSummary {
        val state = _uiState.value
        val test = state.activeTest
        val questions = test.questions

        var correct = 0
        var wrong = 0
        questions.forEach { q ->
            val chosen = state.selectedAnswers[q.id]
            if (chosen != null) {
                if (chosen == q.correctIndex) {
                    correct++
                } else {
                    wrong++
                }
            }
        }
        val attempted = correct + wrong
        val unattempted = max(0, questions.size - attempted)
        val positiveAwarded = correct * test.positiveMarks
        val negativeDeducted = wrong * test.negativeMarks
        val rawScore = positiveAwarded - negativeDeducted
        val roundedScore = (rawScore * 100.0).roundToInt() / 100.0
        val accuracy = if (attempted > 0) ((correct * 100.0) / attempted).roundToInt() else 0
        val timeSpent = (state.totalDurationSeconds - state.remainingSeconds).coerceAtLeast(1)

        val summary = QuizScorecardSummary(
            testId = test.testId,
            examKey = state.examKey,
            totalQuestions = questions.size,
            attemptedCount = attempted,
            correctCount = correct,
            wrongCount = wrong,
            unattemptedCount = unattempted,
            markedForReviewCount = state.markedForReviewIds.size,
            positiveMarksAwarded = positiveAwarded,
            negativeMarksDeducted = negativeDeducted,
            finalScore = roundedScore,
            totalMaxMarks = test.totalMarks,
            accuracyPercent = accuracy,
            timeSpentSeconds = timeSpent
        )

        _uiState.update {
            it.copy(
                isSubmitted = true,
                isAutoSubmittedOnTimeout = autoSubmitted,
                isTimerRunning = false,
                isInstantSolutionVisible = true,
                scorecard = summary
            )
        }

        val repo = repository
        val uid = repo?.currentUserId()
        if (repo != null && !uid.isNullOrBlank()) {
            viewModelScope.launch {
                repo.recordTestAttempt(
                    testId = test.testId,
                    testTitle = test.title,
                    examCategory = state.examKey,
                    score = roundedScore.roundToInt().toLong(),
                    totalQuestions = questions.size.toLong().coerceAtLeast(1L),
                    accuracyPercent = accuracy.toLong()
                )
            }
        }

        return summary
    }

    /**
     * Parses a raw question string into sequential [StatementLineItem] records so multi-statement
     * questions (`Statement 1`, `Statement 2`, `Statement 3`, `कथन 1`, `कथन 2`, `कथन 3`,
     * `Assertion (A)`, `Reason (R)`, or numbered `1.`, `2.`, `3.`) are rendered line-by-line
     * with structured badges.
     */
    fun parseLineByLineStatements(rawText: String, isHindi: Boolean = false): List<StatementLineItem> {
        val rawLines = ProfessionalQuestionFormatEngine.extractQuestionLines(rawText)
        if (rawLines.isEmpty()) return emptyList()

        val statementRegex = Regex(
            pattern = "^(Statement[-\\s]*(?:1|2|3|4|I|II|III|IV)|कथन[-\\s]*(?:1|2|3|4|I|II|III|IV)|(?:1|2|3|4)\\.|\\((?:i|ii|iii|iv)\\))\\s*:?\\s*(.*)$",
            option = RegexOption.IGNORE_CASE
        )
        val assertionReasonRegex = Regex(
            pattern = "^(Assertion\\s*\\(A\\)|Reason\\s*\\(R\\)|अभिकथन\\s*\\(A\\)|कारण\\s*\\(R\\))\\s*:?\\s*(.*)$",
            option = RegexOption.IGNORE_CASE
        )
        val closingPromptRegex = Regex(
            pattern = "^(Which of the statements|How many of the above|Select the correct answer|In the light of the above|उपर्युक्त में से|नीचे दिए गए कूट|उपर्युक्त कथनों के आलोक में).*$",
            option = RegexOption.IGNORE_CASE
        )

        return rawLines.mapIndexed { idx, line ->
            val stmtMatch = statementRegex.find(line)
            val arMatch = assertionReasonRegex.find(line)
            when {
                stmtMatch != null -> {
                    val rawBadge = stmtMatch.groupValues[1].trim().removeSuffix(":")
                    val body = stmtMatch.groupValues[2].trim().ifBlank { line }
                    StatementLineItem(
                        lineIndex = idx,
                        badgeLabel = rawBadge,
                        bodyText = body,
                        fullLineText = line,
                        lineType = StatementLineType.STATEMENT_ITEM
                    )
                }
                arMatch != null -> {
                    val rawBadge = arMatch.groupValues[1].trim().removeSuffix(":")
                    val body = arMatch.groupValues[2].trim().ifBlank { line }
                    StatementLineItem(
                        lineIndex = idx,
                        badgeLabel = rawBadge,
                        bodyText = body,
                        fullLineText = line,
                        lineType = StatementLineType.ASSERTION_REASON
                    )
                }
                closingPromptRegex.matches(line) || (idx == rawLines.lastIndex && rawLines.size >= 3) -> {
                    StatementLineItem(
                        lineIndex = idx,
                        badgeLabel = if (isHindi) "निर्देश" else "Prompt",
                        bodyText = line,
                        fullLineText = line,
                        lineType = StatementLineType.CLOSING_PROMPT
                    )
                }
                else -> {
                    StatementLineItem(
                        lineIndex = idx,
                        badgeLabel = if (isHindi) "प्रश्न" else "Stem",
                        bodyText = line,
                        fullLineText = line,
                        lineType = StatementLineType.OPENING_STEM
                    )
                }
            }
        }
    }

    /**
     * Builds the structured [MathVisualGridChartData] (Excel-style data grid + normalized bar/trend
     * chart points + summary metrics) for any math/DI question.
     */
    fun extractMathVisualGridAndChart(question: TestQuestion): MathVisualGridChartData? {
        val spec: QuestionDataTableSpec = AllIndiaMasterTestPackageData.getDataTableForQuestion(question)
            ?: return null

        val maxVal = (spec.barGraphValues.maxOrNull() ?: 100f).coerceAtLeast(1f)
        val avgVal = if (spec.barGraphValues.isNotEmpty()) {
            spec.barGraphValues.average().toFloat()
        } else {
            0f
        }

        val peakIdx = spec.barGraphValues.indices.maxByOrNull { spec.barGraphValues[it] } ?: 0
        val peakLabel = spec.barGraphLabels.getOrElse(peakIdx) { "N/A" }

        val points = spec.barGraphLabels.zip(spec.barGraphValues).mapIndexed { idx, (label, value) ->
            val fraction = (value / maxVal).coerceIn(0.08f, 1.0f)
            MathChartPoint(
                label = label,
                value = value,
                normalizedFraction = fraction,
                formattedValue = "${value.roundToInt()}${spec.unitSuffix}",
                isPeakValue = idx == peakIdx
            )
        }

        return MathVisualGridChartData(
            titleEn = spec.titleEn,
            titleHi = spec.titleHi,
            headersEn = spec.headersEn,
            headersHi = spec.headersHi,
            gridRows = spec.rows,
            chartPoints = points,
            unitSuffix = spec.unitSuffix,
            maxValue = maxVal,
            averageValue = (avgVal * 10f).roundToInt() / 10f,
            peakCategoryLabel = peakLabel
        )
    }

    companion object {
        fun provideFactory(context: Context): ViewModelProvider.Factory =
            object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    val databaseId = context.getString(R.string.firestore_database_id)
                    val firestore = FirebaseFirestore.getInstance(databaseId)
                    val auth = FirebaseAuth.getInstance()
                    val repo = StudentAuthAndProfileRepository(firestore, auth)
                    return QuizViewModel(repo) as T
                }
            }
    }
}
