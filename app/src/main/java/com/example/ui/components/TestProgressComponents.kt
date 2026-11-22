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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.EmeraldSuccess
import com.example.ui.theme.Navy900
import com.example.ui.theme.SaffronGold
import com.example.viewmodel.SectionProgressInfo
import com.example.viewmodel.ShakuntalamUiState

/**
 * Displays a 4-pillar 'Test Progress' dashboard for GS, Reasoning, Math, and English test series
 * so students can immediately see their completion status for each core pillar.
 */
@Composable
fun CoreFourPillarsProgressDashboard(
    uiState: ShakuntalamUiState,
    isHi: Boolean,
    onSelectPillar: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val gsProgress = uiState.getSscGsProgress()
    val reasoningProgress = uiState.getSscReasoningProgress()
    val mathProgress = uiState.getSscMathProgress()
    val englishProgress = uiState.getSscEnglishProgress()

    val totalAnswered = gsProgress.answeredCount +
            reasoningProgress.answeredCount +
            mathProgress.answeredCount +
            englishProgress.answeredCount
    val totalQuestions = gsProgress.totalQuestions +
            reasoningProgress.totalQuestions +
            mathProgress.totalQuestions +
            englishProgress.totalQuestions
    val overallPercent = ((totalAnswered * 100) / totalQuestions.coerceAtLeast(1)).coerceIn(0, 100)

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFF0F172A))
            .border(1.dp, Color(0xFF4F46E5), RoundedCornerShape(12.dp))
            .padding(12.dp)
            .testTag("four_pillars_test_progress_card")
    ) {
        // Header Row with overall completion badge
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = if (isHi)
                    "टेस्ट प्रोग्रेस: GS • रीजनिंग • मैथ • इंग्लिश"
                else
                    "Test Progress: GS • Reasoning • Math • English",
                fontSize = 11.5.sp,
                fontWeight = FontWeight.ExtraBold,
                color = SaffronGold,
                maxLines = 1,
                softWrap = false,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .background(if (overallPercent == 100) EmeraldSuccess else Color(0xFF1E293B))
                    .border(1.dp, SaffronGold, RoundedCornerShape(6.dp))
                    .padding(horizontal = 8.dp, vertical = 3.dp)
                    .testTag("four_pillars_overall_badge")
            ) {
                Text(
                    text = "$totalAnswered/$totalQuestions Qs ($overallPercent%)",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White,
                    maxLines = 1,
                    softWrap = false
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Row 1: GS (500 Qs) & Reasoning (100 Qs)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            PillarProgressMiniCard(
                pillarKey = "gs",
                titleEn = "1. GS (General Studies)",
                titleHi = "1. जीएस (GS • 5 सेक्शन)",
                progress = gsProgress,
                accentColor = Color(0xFF38BDF8),
                isHi = isHi,
                onClick = { onSelectPillar("ssc_gs_history") },
                modifier = Modifier.weight(1f)
            )
            PillarProgressMiniCard(
                pillarKey = "reasoning",
                titleEn = "2. Reasoning",
                titleHi = "2. रीजनिंग (Reasoning)",
                progress = reasoningProgress,
                accentColor = Color(0xFFF59E0B),
                isHi = isHi,
                onClick = { onSelectPillar("ssc_reasoning") },
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Row 2: Math (100 Qs) & English (100 Qs)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            PillarProgressMiniCard(
                pillarKey = "math",
                titleEn = "3. Math (Quant)",
                titleHi = "3. मैथमेटिक्स (Math)",
                progress = mathProgress,
                accentColor = Color(0xFF10B981),
                isHi = isHi,
                onClick = { onSelectPillar("ssc_mathematics") },
                modifier = Modifier.weight(1f)
            )
            PillarProgressMiniCard(
                pillarKey = "english",
                titleEn = "4. English",
                titleHi = "4. इंग्लिश (English)",
                progress = englishProgress,
                accentColor = Color(0xFFA855F7),
                isHi = isHi,
                onClick = { onSelectPillar("ssc_english") },
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
private fun PillarProgressMiniCard(
    pillarKey: String,
    titleEn: String,
    titleHi: String,
    progress: SectionProgressInfo,
    accentColor: Color,
    isHi: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val barFillFraction = (progress.completionPercent / 100f).coerceIn(0f, 1f)
    val statusBadgeColor = when {
        progress.isCompleted -> EmeraldSuccess
        progress.answeredCount > 0 -> SaffronGold
        else -> Color(0xFF475569)
    }

    Column(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xFF1E293B))
            .border(
                width = 1.dp,
                color = if (progress.isCompleted) EmeraldSuccess else accentColor.copy(alpha = 0.65f),
                shape = RoundedCornerShape(10.dp)
            )
            .clickable { onClick() }
            .padding(horizontal = 10.dp, vertical = 8.dp)
            .testTag("pillar_progress_card_$pillarKey")
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = if (isHi) titleHi else titleEn,
                fontSize = 11.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                maxLines = 1,
                softWrap = false,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "${progress.completionPercent}%",
                fontSize = 10.5.sp,
                fontWeight = FontWeight.ExtraBold,
                color = if (progress.isCompleted) EmeraldSuccess else accentColor,
                maxLines = 1,
                softWrap = false
            )
        }

        Spacer(modifier = Modifier.height(5.dp))

        // Visual progress bar track
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(6.dp)
                .clip(RoundedCornerShape(3.dp))
                .background(Color(0xFF0F172A))
        ) {
            if (barFillFraction > 0f) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(barFillFraction)
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(3.dp))
                        .background(if (progress.isCompleted) EmeraldSuccess else accentColor)
                )
            }
        }

        Spacer(modifier = Modifier.height(5.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "${progress.answeredCount}/${progress.totalQuestions} Qs",
                fontSize = 9.5.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFFCBD5E1),
                maxLines = 1,
                softWrap = false
            )
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .background(statusBadgeColor)
                    .padding(horizontal = 5.dp, vertical = 1.5.dp)
            ) {
                Text(
                    text = if (isHi) progress.statusHi else progress.statusEn,
                    fontSize = 8.5.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = if (progress.answeredCount > 0 && !progress.isCompleted) Navy900 else Color.White,
                    maxLines = 1,
                    softWrap = false
                )
            }
        }
    }
}

/**
 * Compact per-section progress bar & completion status indicator rendered inside each exam section card.
 */
@Composable
fun SectionTestProgressBar(
    progress: SectionProgressInfo,
    sectionKey: String,
    isHi: Boolean,
    modifier: Modifier = Modifier
) {
    val fraction = (progress.completionPercent / 100f).coerceIn(0f, 1f)
    val fillColor = when {
        progress.isCompleted -> EmeraldSuccess
        progress.answeredCount > 0 -> SaffronGold
        else -> Color(0xFF64748B)
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 5.dp)
            .testTag("section_progress_$sectionKey")
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = if (isHi)
                    "प्रोग्रेस: ${progress.answeredCount}/${progress.totalQuestions} प्रश्न (${progress.completionPercent}%)"
                else
                    "Test Progress: ${progress.answeredCount}/${progress.totalQuestions} Qs (${progress.completionPercent}%)",
                fontSize = 9.5.sp,
                fontWeight = FontWeight.Bold,
                color = if (progress.isCompleted) Color(0xFF86EFAC) else Color(0xFFFDE68A),
                maxLines = 1,
                softWrap = false,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = if (isHi) progress.statusHi else progress.statusEn,
                fontSize = 9.sp,
                fontWeight = FontWeight.ExtraBold,
                color = when {
                    progress.isCompleted -> Color(0xFF86EFAC)
                    progress.answeredCount > 0 -> SaffronGold
                    else -> Color(0xFFCBD5E1)
                },
                maxLines = 1,
                softWrap = false
            )
        }

        Spacer(modifier = Modifier.height(3.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(5.dp)
                .clip(RoundedCornerShape(3.dp))
                .background(Color(0x4D000000))
        ) {
            if (fraction > 0f) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(fraction)
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(3.dp))
                        .background(fillColor)
                )
            }
        }
    }
}

/**
 * Overall exam progress summary strip for multi-section exams (UPSC, UPPCS, UKPSC, BPSC, UPSSSC, UKSSSC).
 */
@Composable
fun ExamOverallProgressStrip(
    examKey: String,
    progress: SectionProgressInfo,
    isHi: Boolean,
    modifier: Modifier = Modifier
) {
    val fraction = (progress.completionPercent / 100f).coerceIn(0f, 1f)
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0x33000000))
            .border(1.dp, Color(0x40FFFFFF), RoundedCornerShape(8.dp))
            .padding(horizontal = 10.dp, vertical = 6.dp)
            .testTag("exam_overall_progress_$examKey")
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = if (isHi)
                    "कुल टेस्ट प्रोग्रेस: ${progress.answeredCount}/${progress.totalQuestions} प्रश्न हल किए"
                else
                    "Overall Section Progress: ${progress.answeredCount}/${progress.totalQuestions} Qs Completed",
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                maxLines = 1,
                softWrap = false,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = "${progress.completionPercent}% • ${if (isHi) progress.statusHi else progress.statusEn}",
                fontSize = 10.sp,
                fontWeight = FontWeight.ExtraBold,
                color = if (progress.isCompleted) EmeraldSuccess else SaffronGold,
                maxLines = 1,
                softWrap = false
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(5.dp)
                .clip(RoundedCornerShape(3.dp))
                .background(Color(0x4D000000))
        ) {
            if (fraction > 0f) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(fraction)
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(3.dp))
                        .background(if (progress.isCompleted) EmeraldSuccess else SaffronGold)
                )
            }
        }
    }
}
