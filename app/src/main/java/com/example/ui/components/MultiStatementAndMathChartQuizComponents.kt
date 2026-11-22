package com.example.ui.components

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
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.CloudDone
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.ui.theme.EmeraldSuccess
import com.example.ui.theme.Navy900
import com.example.viewmodel.MathVisualGridChartData
import com.example.viewmodel.QuizUiState
import com.example.viewmodel.StatementLineItem
import com.example.viewmodel.StatementLineType

/**
 * Renders multi-statement questions line-by-line using the structured [StatementLineItem] list
 * produced by [com.example.viewmodel.QuizViewModel.parseLineByLineStatements].
 */
@Composable
fun MultiStatementLineByLineQuestionView(
    questionNumber: Int,
    statementLines: List<StatementLineItem>,
    isHindi: Boolean,
    testTagPrefix: String = "quiz_line_by_line",
    modifier: Modifier = Modifier
) {
    val prefixLabel = if (isHindi) "प्रश्न $questionNumber." else "Q$questionNumber."
    Column(
        modifier = modifier
            .fillMaxWidth()
            .testTag("${testTagPrefix}_container"),
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        statementLines.forEachIndexed { idx, item ->
            when (item.lineType) {
                StatementLineType.OPENING_STEM -> {
                    val displayLine = if (idx == 0) "$prefixLabel ${item.bodyText}" else item.bodyText
                    Text(
                        text = displayLine,
                        fontSize = 14.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (isHindi) Color(0xFF1E293B) else Navy900,
                        lineHeight = 21.5.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("${testTagPrefix}_stem_$idx")
                    )
                }

                StatementLineType.STATEMENT_ITEM,
                StatementLineType.ASSERTION_REASON -> {
                    val isAssertionOrReason = item.lineType == StatementLineType.ASSERTION_REASON
                    val containerBg = when {
                        isAssertionOrReason -> Color(0xFFF5F3FF)
                        isHindi -> Color(0xFFFFFBEB)
                        else -> Color(0xFFEFF6FF)
                    }
                    val borderColor = when {
                        isAssertionOrReason -> Color(0xFFC4B5FD)
                        isHindi -> Color(0xFFFDE68A)
                        else -> Color(0xFFBFDBFE)
                    }
                    val badgeBg = when {
                        isAssertionOrReason -> Color(0xFF6D28D9)
                        isHindi -> EdTechProColors.WarmGold
                        else -> EdTechProColors.RoyalIndigo
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .background(containerBg)
                            .border(1.dp, borderColor, RoundedCornerShape(8.dp))
                            .padding(horizontal = 10.dp, vertical = 7.dp)
                            .testTag("${testTagPrefix}_statement_$idx"),
                        verticalAlignment = Alignment.Top
                    ) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(5.dp))
                                .background(badgeBg)
                                .padding(horizontal = 7.dp, vertical = 2.dp)
                        ) {
                            Text(
                                text = item.badgeLabel,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.White,
                                maxLines = 1
                            )
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = item.bodyText,
                            fontSize = 13.5.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Navy900,
                            lineHeight = 20.sp,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }

                StatementLineType.CLOSING_PROMPT -> {
                    Text(
                        text = item.bodyText,
                        fontSize = 13.5.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = if (isHindi) Color(0xFF92400E) else EdTechProColors.RoyalIndigo,
                        lineHeight = 20.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 2.dp)
                            .testTag("${testTagPrefix}_prompt_$idx")
                    )
                }
            }
        }
    }
}

/**
 * Renders the Excel-style data grid table and visual bar/trend chart for math & Data Interpretation (DI)
 * questions using [MathVisualGridChartData] from [com.example.viewmodel.QuizViewModel].
 */
@Composable
fun MathVisualDataGridAndChartComponent(
    visualData: MathVisualGridChartData,
    isHindi: Boolean,
    modifier: Modifier = Modifier
) {
    val headers = if (isHindi) visualData.headersHi else visualData.headersEn
    Card(
        modifier = modifier
            .fillMaxWidth()
            .border(1.5.dp, EdTechProColors.RoyalIndigo.copy(alpha = 0.45f), RoundedCornerShape(12.dp))
            .testTag("math_visual_grid_and_chart_card"),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            // Header Banner with Peak & Average Summary Badges
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(EdTechProColors.DeepRoyalNavy)
                    .padding(horizontal = 10.dp, vertical = 7.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = if (isHindi) visualData.titleHi else visualData.titleEn,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = EdTechProColors.ChampagneGold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(5.dp))
                        .background(EdTechProColors.ElectricCyan.copy(alpha = 0.2f))
                        .padding(horizontal = 6.dp, vertical = 2.dp)
                        .testTag("math_visual_summary_badge")
                ) {
                    Text(
                        text = "Avg: ${visualData.averageValue}${visualData.unitSuffix} • Peak: ${visualData.peakCategoryLabel}",
                        fontSize = 9.5.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF67E8F9),
                        maxLines = 1
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // 1. Excel-Style Data Grid Header Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(EdTechProColors.RoyalIndigo)
                    .border(1.dp, Color(0xFF334155))
                    .testTag("math_visual_grid_header")
            ) {
                headers.forEach { headerText ->
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .border(0.5.dp, Color(0xFF475569))
                            .padding(horizontal = 4.dp, vertical = 6.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = headerText,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }

            // 2. Excel-Style Data Grid Rows
            visualData.gridRows.forEachIndexed { rowIdx, rowCells ->
                val rowBg = if (rowIdx % 2 == 0) Color(0xFFF8FAFC) else Color(0xFFEFF6FF)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(rowBg)
                        .border(0.5.dp, Color(0xFFCBD5E1))
                        .testTag("math_visual_grid_row_$rowIdx")
                ) {
                    rowCells.forEachIndexed { colIdx, cellValue ->
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .border(0.5.dp, Color(0xFFCBD5E1))
                                .padding(horizontal = 4.dp, vertical = 5.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = cellValue,
                                fontSize = 10.5.sp,
                                fontWeight = if (colIdx == 0 || colIdx == rowCells.lastIndex) {
                                    FontWeight.ExtraBold
                                } else {
                                    FontWeight.SemiBold
                                },
                                color = if (colIdx == 0) EdTechProColors.DeepRoyalNavy else Color(0xFF1E293B),
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }
                }
            }

            // 3. Visual Bar & Trend Chart Section
            if (visualData.chartPoints.isNotEmpty()) {
                Spacer(modifier = Modifier.height(10.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFFF1F5F9))
                        .border(1.dp, Color(0xFFCBD5E1), RoundedCornerShape(8.dp))
                        .padding(10.dp)
                        .testTag("math_visual_bar_chart_section")
                ) {
                    Text(
                        text = if (isHindi) {
                            "गणितीय डेटा ग्राफ एवं सूचकांक विश्लेषण (Math Visual Chart):"
                        } else {
                            "Quantitative Data Bar Chart & Index Trend:"
                        },
                        fontSize = 10.5.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = EdTechProColors.DeepRoyalNavy
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    visualData.chartPoints.forEachIndexed { idx, point ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 2.5.dp)
                                .testTag("math_visual_chart_bar_$idx"),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = point.label,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                color = Navy900,
                                modifier = Modifier.width(54.dp),
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Box(
                                modifier = Modifier
                                    .weight(1f)
                                    .height(12.dp)
                                    .clip(RoundedCornerShape(4.dp))
                                    .background(Color(0xFFCBD5E1))
                            ) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth(point.normalizedFraction)
                                        .fillMaxHeight()
                                        .clip(RoundedCornerShape(4.dp))
                                        .background(
                                            if (point.isPeakValue) {
                                                Brush.horizontalGradient(
                                                    listOf(EdTechProColors.WarmGold, EmeraldSuccess)
                                                )
                                            } else {
                                                Brush.horizontalGradient(
                                                    listOf(EdTechProColors.RoyalIndigo, EdTechProColors.ElectricCyan)
                                                )
                                            }
                                        )
                                )
                            }
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = point.formattedValue,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = if (point.isPeakValue) Color(0xFF047857) else EdTechProColors.RoyalIndigo
                            )
                        }
                    }
                }
            }
        }
    }
}

/**
 * Self-contained multi-choice quiz card driven by [QuizUiState] from [com.example.viewmodel.QuizViewModel].
 */
@Composable
fun FirestoreMultiChoiceQuizCard(
    quizState: QuizUiState,
    onSelectOption: (Int, Int) -> Unit,
    onPreviousQuestion: () -> Unit,
    onNextQuestion: () -> Unit,
    onToggleMarkForReview: () -> Unit,
    onSubmitQuiz: () -> Unit,
    modifier: Modifier = Modifier
) {
    val currentQ = quizState.currentQuestion ?: return
    val qNum = quizState.currentQuestionIndex + 1
    val selectedOptionIdx = quizState.selectedAnswers[currentQ.id]
    val isMarkedReview = currentQ.id in quizState.markedForReviewIds

    Card(
        modifier = modifier
            .fillMaxWidth()
            .border(1.5.dp, EdTechProColors.SlateBorder, RoundedCornerShape(16.dp))
            .testTag("firestore_multi_choice_quiz_card"),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            // Top Quiz Status Bar: Firestore Sync Status + Question Counter + Countdown Timer
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(EdTechProColors.DeepRoyalNavy)
                    .padding(horizontal = 12.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.CloudDone,
                        contentDescription = "Firestore Sync Status",
                        tint = EdTechProColors.ElectricCyan,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "Q $qNum / ${quizState.totalQuestions} • ${quizState.subjectTag}",
                        fontSize = 11.5.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White
                    )
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Timer,
                        contentDescription = "Remaining Time",
                        tint = EdTechProColors.WarmGold,
                        modifier = Modifier.size(15.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = quizState.formattedRemainingTime(),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = EdTechProColors.ChampagneGold,
                        modifier = Modifier.testTag("quiz_vm_timer_text")
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // 1. Line-by-Line Multi-Statement Rendering (English + Bilingual Hindi)
            if (quizState.isDualBilingualView || !quizState.isHindiPrimary) {
                MultiStatementLineByLineQuestionView(
                    questionNumber = qNum,
                    statementLines = quizState.currentQuestionLinesEn,
                    isHindi = false,
                    testTagPrefix = "quiz_vm_en"
                )
            }

            if (quizState.isDualBilingualView) {
                Spacer(modifier = Modifier.height(8.dp))
                HorizontalDivider(color = Color(0xFFE2E8F0))
                Spacer(modifier = Modifier.height(8.dp))
            }

            if (quizState.isDualBilingualView || quizState.isHindiPrimary) {
                MultiStatementLineByLineQuestionView(
                    questionNumber = qNum,
                    statementLines = quizState.currentQuestionLinesHi,
                    isHindi = true,
                    testTagPrefix = "quiz_vm_hi"
                )
            }

            // 2. Math / Data Interpretation (DI) Grid & Visual Bar Chart Component
            val mathVisual = quizState.currentMathVisualData
            if (mathVisual != null) {
                Spacer(modifier = Modifier.height(12.dp))
                MathVisualDataGridAndChartComponent(
                    visualData = mathVisual,
                    isHindi = quizState.isHindiPrimary
                )
            }

            Spacer(modifier = Modifier.height(14.dp))

            // 3. Multi-Choice Options (A, B, C, D)
            val optionLetters = listOf("A", "B", "C", "D")
            currentQ.optionsEn.forEachIndexed { optIdx, optEn ->
                val optHi = currentQ.optionsHi.getOrElse(optIdx) { optEn }
                val isSelected = selectedOptionIdx == optIdx
                val isCorrectOption = optIdx == currentQ.correctIndex
                val showSolutionState = quizState.isInstantSolutionVisible || quizState.isSubmitted

                val borderColor = when {
                    showSolutionState && isCorrectOption -> EmeraldSuccess
                    showSolutionState && isSelected && !isCorrectOption -> Color(0xFFEF4444)
                    isSelected -> EdTechProColors.RoyalIndigo
                    else -> Color(0xFFCBD5E1)
                }
                val bgColor = when {
                    showSolutionState && isCorrectOption -> Color(0xFFECFDF5)
                    showSolutionState && isSelected && !isCorrectOption -> Color(0xFFFEF2F2)
                    isSelected -> Color(0xFFEFF6FF)
                    else -> Color(0xFFF8FAFC)
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(bgColor)
                        .border(1.5.dp, borderColor, RoundedCornerShape(10.dp))
                        .clickable(enabled = !quizState.isSubmitted) {
                            onSelectOption(currentQ.id, optIdx)
                        }
                        .padding(horizontal = 12.dp, vertical = 10.dp)
                        .testTag("quiz_vm_option_$optIdx"),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(28.dp)
                            .clip(CircleShape)
                            .background(if (isSelected) borderColor else Color(0xFFE2E8F0)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = optionLetters.getOrElse(optIdx) { "${optIdx + 1}" },
                            fontSize = 12.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = if (isSelected) Color.White else Navy900
                        )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = optEn,
                            fontSize = 13.5.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Navy900
                        )
                        if (quizState.isDualBilingualView && !optHi.equals(optEn, ignoreCase = true)) {
                            Text(
                                text = optHi,
                                fontSize = 12.5.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color(0xFF475569)
                            )
                        }
                    }
                    if (showSolutionState && isCorrectOption) {
                        Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = "Correct Option",
                            tint = EmeraldSuccess,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }

            // 4. Instant Structured Bilingual Explanation Card
            if (quizState.isInstantSolutionVisible || quizState.isSubmitted) {
                Spacer(modifier = Modifier.height(12.dp))
                ProfessionalStructuredExplanationCard(
                    question = currentQ,
                    userSelectedIdx = selectedOptionIdx,
                    cardTestTag = "quiz_vm_explanation_card"
                )
            }

            Spacer(modifier = Modifier.height(14.dp))

            // 5. Quiz Navigation & Submit Controls
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedButton(
                    onClick = onPreviousQuestion,
                    enabled = quizState.currentQuestionIndex > 0,
                    modifier = Modifier
                        .weight(1f)
                        .testTag("quiz_vm_prev_btn")
                ) {
                    Text(text = "Prev", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                }

                OutlinedButton(
                    onClick = onToggleMarkForReview,
                    modifier = Modifier
                        .weight(1f)
                        .testTag("quiz_vm_review_btn")
                ) {
                    Icon(
                        imageVector = Icons.Default.Flag,
                        contentDescription = "Mark for Review",
                        tint = if (isMarkedReview) EdTechProColors.WarmGold else Navy900,
                        modifier = Modifier.size(15.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = if (isMarkedReview) "Reviewed" else "Review",
                        fontSize = 11.5.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                if (quizState.currentQuestionIndex < quizState.totalQuestions - 1) {
                    Button(
                        onClick = onNextQuestion,
                        colors = ButtonDefaults.buttonColors(containerColor = EdTechProColors.DeepRoyalNavy),
                        modifier = Modifier
                            .weight(1f)
                            .testTag("quiz_vm_next_btn")
                    ) {
                        Text(text = "Next", fontSize = 12.sp, fontWeight = FontWeight.ExtraBold)
                    }
                } else {
                    Button(
                        onClick = onSubmitQuiz,
                        colors = ButtonDefaults.buttonColors(containerColor = EmeraldSuccess),
                        modifier = Modifier
                            .weight(1f)
                            .testTag("quiz_vm_submit_btn")
                    ) {
                        Text(text = "Submit", fontSize = 12.sp, fontWeight = FontWeight.ExtraBold)
                    }
                }
            }
        }
    }
}
