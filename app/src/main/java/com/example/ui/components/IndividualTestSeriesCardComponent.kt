package com.example.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.model.MockTest
import com.example.ui.theme.EmeraldSuccess
import com.example.ui.theme.SaffronGold

/**
 * UI Card Component for an individual test series within the Test Series tab.
 * Displays:
 *  1. Test Series Title (English + Hindi subtitle)
 *  2. Number of Questions (plus duration in minutes & total marks)
 *  3. 'Start Test' action button
 */
@Composable
fun IndividualTestSeriesCard(
    mockTest: MockTest,
    isActiveTest: Boolean,
    answeredCount: Int,
    isCompleted: Boolean,
    isHi: Boolean,
    onStartTest: (MockTest) -> Unit,
    modifier: Modifier = Modifier
) {
    val questionCount = mockTest.questions.size
    val borderColor = when {
        isActiveTest -> EdTechProColors.WarmGold
        isCompleted -> EmeraldSuccess
        else -> EdTechProColors.SlateBorder
    }

    Card(
        modifier = modifier
            .border(
                width = if (isActiveTest) 1.5.dp else 1.dp,
                color = borderColor,
                shape = RoundedCornerShape(16.dp)
            )
            .testTag("individual_test_series_card_${mockTest.testId}"),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = EdTechProColors.DeepRoyalNavy),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            EdTechProColors.DeepRoyalNavy,
                            EdTechProColors.ElevatedNavy
                        )
                    )
                )
                .padding(14.dp)
        ) {
            // Top Row: Shakuntalam Logo Badge + Exam Name Pill + Status Badge
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    ShakuntalamBrandCrestBadge(
                        size = 22.dp,
                        showGlowRing = isActiveTest
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(6.dp))
                            .background(EdTechProColors.RoyalIndigo)
                            .border(
                                1.dp,
                                EdTechProColors.ElectricCyan.copy(alpha = 0.5f),
                                RoundedCornerShape(6.dp)
                            )
                            .padding(horizontal = 8.dp, vertical = 3.dp)
                    ) {
                        Text(
                            text = mockTest.examName,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color(0xFF67E8F9),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }

                if (isActiveTest || isCompleted) {
                    Spacer(modifier = Modifier.width(6.dp))
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(6.dp))
                            .background(
                                if (isCompleted) EmeraldSuccess.copy(alpha = 0.22f)
                                else EdTechProColors.WarmGold.copy(alpha = 0.22f)
                            )
                            .padding(horizontal = 7.dp, vertical = 3.dp)
                    ) {
                        Text(
                            text = when {
                                isCompleted -> if (isHi) "✓ पूर्ण" else "✓ Completed"
                                else -> if (isHi) "सक्रिय टेस्ट" else "Active Test"
                            },
                            fontSize = 9.5.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = if (isCompleted) Color(0xFF6EE7B7) else EdTechProColors.ChampagneGold
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // 1. Test Series Title
            Text(
                text = mockTest.title,
                fontSize = 14.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                maxLines = 2,
                lineHeight = 19.sp,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.testTag("individual_test_card_title_${mockTest.testId}")
            )

            if (mockTest.hindiTitle.isNotBlank() && !mockTest.hindiTitle.equals(mockTest.title, ignoreCase = true)) {
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                    text = mockTest.hindiTitle,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = EdTechProColors.ChampagneGold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Spacer(modifier = Modifier.height(10.dp))
            HorizontalDivider(color = EdTechProColors.SlateBorder)
            Spacer(modifier = Modifier.height(10.dp))

            // Testbook-Style Sub-Row: Bilingual Tag + Aspirants Count + Pass Pro Badge
            val aspirantsCount = remember(mockTest.testId) {
                val seed = mockTest.testId.hashCode().let { if (it < 0) -it else it }
                val thousands = 12 + (seed % 35)
                val tenths = (seed / 7) % 9
                "${thousands}.${tenths}k+ Aspirants"
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(5.dp))
                            .background(Color(0xFF0F172A))
                            .border(1.dp, EdTechProColors.ElectricCyan.copy(alpha = 0.45f), RoundedCornerShape(5.dp))
                            .padding(horizontal = 6.dp, vertical = 2.dp)
                    ) {
                        Text(
                            text = "EN + हिंदी (Bilingual)",
                            fontSize = 9.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF67E8F9)
                        )
                    }
                    Text(
                        text = "• $aspirantsCount",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF94A3B8)
                    )
                }

                Text(
                    text = "+${mockTest.positiveMarks} / -${mockTest.negativeMarks}",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = EdTechProColors.ChampagneGold
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // 2. Number of Questions, Duration & Total Marks Chips
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Number of Questions Badge
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFF162A45))
                        .border(1.dp, EdTechProColors.WarmGold.copy(alpha = 0.5f), RoundedCornerShape(8.dp))
                        .padding(horizontal = 9.dp, vertical = 5.dp)
                        .testTag("individual_test_card_question_count_${mockTest.testId}"),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Quiz,
                        contentDescription = "Number of Questions",
                        tint = EdTechProColors.WarmGold,
                        modifier = Modifier.size(13.dp)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = if (isHi) "$questionCount प्रश्न ($questionCount Questions)" else "$questionCount Questions",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White,
                        maxLines = 1
                    )
                }

                // Duration Badge
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFF162A45))
                        .padding(horizontal = 8.dp, vertical = 5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Schedule,
                        contentDescription = "Duration",
                        tint = EdTechProColors.ElectricCyan,
                        modifier = Modifier.size(13.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "${mockTest.durationMinutes} Mins",
                        fontSize = 10.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFCBD5E1),
                        maxLines = 1
                    )
                }

                // Total Marks Badge
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFF162A45))
                        .padding(horizontal = 8.dp, vertical = 5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Total Marks",
                        tint = SaffronGold,
                        modifier = Modifier.size(13.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "${mockTest.totalMarks} Marks",
                        fontSize = 10.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFCBD5E1),
                        maxLines = 1
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // 3. 'Start Test' Action Button
            Button(
                onClick = { onStartTest(mockTest) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(42.dp)
                    .testTag("start_test_card_btn_${mockTest.testId}"),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isActiveTest) EmeraldSuccess else EdTechProColors.WarmGold
                ),
                shape = RoundedCornerShape(10.dp),
                contentPadding = PaddingValues(horizontal = 14.dp, vertical = 6.dp)
            ) {
                Icon(
                    imageVector = if (isCompleted) Icons.Default.CheckCircle else Icons.Default.PlayArrow,
                    contentDescription = "Start Test",
                    tint = if (isActiveTest) Color.White else EdTechProColors.DeepRoyalNavy,
                    modifier = Modifier.size(17.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = when {
                        isActiveTest && answeredCount > 0 ->
                            if (isHi) "Start Test • जारी रखें ($answeredCount/$questionCount)" else "Start Test • Resume ($answeredCount/$questionCount)"
                        else ->
                            if (isHi) "Start Test (टेस्ट शुरू करें)" else "Start Test"
                    },
                    fontSize = 12.5.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = if (isActiveTest) Color.White else EdTechProColors.DeepRoyalNavy,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

/**
 * Showcase section within the Test Series tab displaying Individual Test Series UI Cards
 * (with Title, Number of Questions, and 'Start Test' button) for the currently selected test
 * and all available exam test series.
 */
@Composable
fun TestSeriesTabCardsSection(
    activeTest: MockTest,
    allTests: List<MockTest>,
    getAnsweredCount: (testId: String) -> Int,
    isTestCompleted: (testId: String) -> Boolean,
    isHi: Boolean,
    onStartTest: (MockTest) -> Unit,
    modifier: Modifier = Modifier
) {
    var isCatalogExpanded by remember { mutableStateOf(true) }

    // Put activeTest first, followed by featured tests so users can browse or start any test immediately
    val orderedTests = remember(activeTest.testId, allTests) {
        val others = allTests.filter { it.testId != activeTest.testId }.take(12)
        listOf(activeTest) + others
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .testTag("test_series_tab_cards_section")
    ) {
        // Section Header with Expand/Collapse Toggle
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .background(EdTechProColors.DeepRoyalNavy)
                .border(1.dp, EdTechProColors.SlateBorder, RoundedCornerShape(12.dp))
                .clickable { isCatalogExpanded = !isCatalogExpanded }
                .padding(horizontal = 12.dp, vertical = 9.dp)
                .testTag("test_series_cards_section_toggle"),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
            ) {
                ShakuntalamBrandCrestBadge(size = 20.dp, showGlowRing = true)
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text(
                        text = if (isHi)
                            "टेस्ट सीरीज़ कार्ड्स (Test Series Cards • ${allTests.size} Tests)"
                        else
                            "INDIVIDUAL TEST SERIES CARDS (${allTests.size} TESTS)",
                        fontSize = 11.5.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = EdTechProColors.WarmGold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = if (isHi)
                            "शीर्षक, प्रश्नों की संख्या देखें और 'Start Test' पर क्लिक करें"
                        else
                            "View title, number of questions, and tap 'Start Test'",
                        fontSize = 10.sp,
                        color = Color(0xFFCBD5E1),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            Text(
                text = if (isCatalogExpanded) {
                    if (isHi) "छुपाएं ▲" else "Hide Cards ▲"
                } else {
                    if (isHi) "कार्ड्स देखें ▼" else "Show Cards ▼"
                },
                fontSize = 10.5.sp,
                fontWeight = FontWeight.ExtraBold,
                color = EdTechProColors.ElectricCyan
            )
        }

        AnimatedVisibility(visible = isCatalogExpanded) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Spacer(modifier = Modifier.height(8.dp))

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    contentPadding = PaddingValues(horizontal = 2.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("individual_test_series_cards_row")
                ) {
                    items(orderedTests, key = { it.testId }) { mockTest ->
                        IndividualTestSeriesCard(
                            mockTest = mockTest,
                            isActiveTest = mockTest.testId == activeTest.testId,
                            answeredCount = getAnsweredCount(mockTest.testId),
                            isCompleted = isTestCompleted(mockTest.testId),
                            isHi = isHi,
                            onStartTest = onStartTest,
                            modifier = Modifier.width(305.dp)
                        )
                    }
                }
            }
        }
    }
}
