package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.StudyItem
import com.example.ui.theme.EmeraldSuccess
import com.example.ui.theme.Navy900
import com.example.ui.theme.SaffronGold
import com.example.viewmodel.SectionProgressInfo
import com.example.viewmodel.ShakuntalamUiState

data class DashboardCategoryFilterItem(
    val key: String,
    val seriesKey: String,
    val labelEn: String,
    val labelHi: String,
    val seriesBadgeEn: String,
    val seriesBadgeHi: String,
    val accentColor: Color
)

object DashboardCategoryFilterCatalog {
    val filters: List<DashboardCategoryFilterItem> = listOf(
        DashboardCategoryFilterItem(
            key = "ALL",
            seriesKey = "all",
            labelEn = "All Exams",
            labelHi = "सभी परीक्षाएं",
            seriesBadgeEn = "14 Test Series",
            seriesBadgeHi = "14 टेस्ट सीरीज़",
            accentColor = SaffronGold
        ),
        DashboardCategoryFilterItem(
            key = "UP_POLICE",
            seriesKey = "up_police",
            labelEn = "UP Police / Constable",
            labelHi = "यूपी पुलिस • कांस्टेबल",
            seriesBadgeEn = "50 Paid • 150 Qs",
            seriesBadgeHi = "50 पेड टेस्ट • 150 Q",
            accentColor = Color(0xFFF59E0B)
        ),
        DashboardCategoryFilterItem(
            key = "TET",
            seriesKey = "tet",
            labelEn = "CTET / UPTET / UTET",
            labelHi = "सीटेट • यूपीटेट • यूटेट",
            seriesBadgeEn = "7 Subjects • 700 Qs",
            seriesBadgeHi = "7 विषय • 700 Q",
            accentColor = Color(0xFF14B8A6)
        ),
        DashboardCategoryFilterItem(
            key = "IIT_JEE",
            seriesKey = "iit_jee",
            labelEn = "IIT JEE",
            labelHi = "आईआईटी जेईई (IIT JEE)",
            seriesBadgeEn = "Main & Adv • 1,000 Qs",
            seriesBadgeHi = "Main & Adv • 1,000 Q",
            accentColor = Color(0xFF3B82F6)
        ),
        DashboardCategoryFilterItem(
            key = "NEET",
            seriesKey = "neet",
            labelEn = "NEET (UG)",
            labelHi = "नीट यूजी (NEET)",
            seriesBadgeEn = "6 Subjects • 600 Qs",
            seriesBadgeHi = "6 विषय • 600 Q",
            accentColor = Color(0xFF10B981)
        ),
        DashboardCategoryFilterItem(
            key = "UGC_NET",
            seriesKey = "ugc_net",
            labelEn = "UGC NET",
            labelHi = "यूजीसी नेट (UGC NET)",
            seriesBadgeEn = "Paper 1 & 2 • 2,200 Qs",
            seriesBadgeHi = "पेपर 1 व 2 • 2,200 Q",
            accentColor = Color(0xFF818CF8)
        ),
        DashboardCategoryFilterItem(
            key = "UPSC",
            seriesKey = "upsc",
            labelEn = "UPSC",
            labelHi = "यूपीएससी (UPSC)",
            seriesBadgeEn = "7 Sections • 350 Qs",
            seriesBadgeHi = "7 सेक्शन • 350 Q",
            accentColor = Color(0xFF38BDF8)
        ),
        DashboardCategoryFilterItem(
            key = "SSC",
            seriesKey = "ssc",
            labelEn = "SSC",
            labelHi = "एसएससी (SSC)",
            seriesBadgeEn = "CGL/CHSL/CPO • 800 Qs",
            seriesBadgeHi = "CGL/CHSL/CPO • 800 Q",
            accentColor = Color(0xFFF59E0B)
        ),
        DashboardCategoryFilterItem(
            key = "BANKING",
            seriesKey = "banking",
            labelEn = "Banking",
            labelHi = "बैंकिंग (Banking)",
            seriesBadgeEn = "IBPS/SBI/RBI PYQs",
            seriesBadgeHi = "IBPS/SBI/RBI PYQ",
            accentColor = Color(0xFF10B981)
        ),
        DashboardCategoryFilterItem(
            key = "STATE_PSC",
            seriesKey = "state_psc",
            labelEn = "State PSC",
            labelHi = "राज्य पीसीएस (PSC)",
            seriesBadgeEn = "UPPCS • UKPSC • BPSC",
            seriesBadgeHi = "UPPCS • UKPSC • BPSC",
            accentColor = Color(0xFFA855F7)
        ),
        DashboardCategoryFilterItem(
            key = "UPPCS",
            seriesKey = "uppcs",
            labelEn = "UPPCS",
            labelHi = "यूपीपीसीएस (UPPCS)",
            seriesBadgeEn = "7 Sections • 350 Qs",
            seriesBadgeHi = "7 सेक्शन • 350 Q",
            accentColor = Color(0xFF60A5FA)
        ),
        DashboardCategoryFilterItem(
            key = "UKPSC",
            seriesKey = "ukpsc",
            labelEn = "UKPSC",
            labelHi = "यूकेपीसीएस (UKPSC)",
            seriesBadgeEn = "8 Sections • 450 Qs",
            seriesBadgeHi = "8 सेक्शन • 450 Q",
            accentColor = Color(0xFF34D399)
        ),
        DashboardCategoryFilterItem(
            key = "BPSC",
            seriesKey = "bpsc",
            labelEn = "BPSC",
            labelHi = "बीपीएससी (BPSC)",
            seriesBadgeEn = "7 Sections • 700 Qs",
            seriesBadgeHi = "7 सेक्शन • 700 Q",
            accentColor = Color(0xFFFB923C)
        ),
        DashboardCategoryFilterItem(
            key = "UPSSSC",
            seriesKey = "upsssc",
            labelEn = "UPSSSC",
            labelHi = "UPSSSC (PET/VDO)",
            seriesBadgeEn = "9 Sections • 1,050 Qs",
            seriesBadgeHi = "9 सेक्शन • 1,050 Q",
            accentColor = Color(0xFF818CF8)
        ),
        DashboardCategoryFilterItem(
            key = "UKSSSC",
            seriesKey = "uksssc",
            labelEn = "UKSSSC",
            labelHi = "UKSSSC (Group C/D)",
            seriesBadgeEn = "10 Sections • 1,150 Qs",
            seriesBadgeHi = "10 सेक्शन • 1,150 Q",
            accentColor = Color(0xFF2DD4BF)
        ),
        DashboardCategoryFilterItem(
            key = "RAILWAYS",
            seriesKey = "railways",
            labelEn = "Railways",
            labelHi = "रेलवे (RRB)",
            seriesBadgeEn = "NTPC & Group D PYQs",
            seriesBadgeHi = "NTPC एवं ग्रुप D",
            accentColor = Color(0xFFF43F5E)
        )
    )

    val seriesDisplayItems: List<DashboardCategoryFilterItem> = filters.filter {
        it.key != "ALL" && it.key != "STATE_PSC"
    }
}

/**
 * Reusable Circular Progress Indicator badge for any Exam Category or Test Series.
 * Renders a Material 3 CircularProgressIndicator with the completion percentage in the center.
 */
@Composable
fun TestSeriesCircularProgressRing(
    progress: SectionProgressInfo,
    seriesKey: String,
    size: Dp = 50.dp,
    strokeWidth: Dp = 5.dp,
    accentColor: Color = SaffronGold,
    trackColor: Color = Color(0xFF334155),
    modifier: Modifier = Modifier
) {
    val progressFraction = (progress.completionPercent / 100f).coerceIn(0f, 1f)
    val ringColor = when {
        progress.isCompleted -> EmeraldSuccess
        progress.answeredCount > 0 -> accentColor
        else -> accentColor.copy(alpha = 0.55f)
    }

    Box(
        modifier = modifier
            .size(size)
            .testTag("circular_progress_ring_$seriesKey"),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            progress = { progressFraction },
            modifier = Modifier.size(size),
            color = ringColor,
            strokeWidth = strokeWidth,
            trackColor = trackColor,
            strokeCap = StrokeCap.Round
        )
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "${progress.completionPercent}%",
                fontSize = if (size >= 48.dp) 10.5.sp else 9.sp,
                fontWeight = FontWeight.ExtraBold,
                color = if (progress.isCompleted) Color(0xFF86EFAC) else Color.White,
                maxLines = 1,
                softWrap = false
            )
        }
    }
}

/**
 * Main Dashboard Category Filter System & Visual Circular Progress Tracker.
 * Updates the main dashboard UI to show only relevant test series based on the selected exam
 * category (e.g., UPSC, SSC, Banking) and displays completion percentages using a
 * CircularProgressIndicator for each selected test series.
 */
@Composable
fun DashboardCategoryFilterBar(
    uiState: ShakuntalamUiState,
    isHi: Boolean,
    onSelectCategoryFilter: (String) -> Unit,
    onClearFilter: () -> Unit,
    modifier: Modifier = Modifier
) {
    val activeFilterKey = uiState.effectiveDashboardCategoryFilter()
    val visibleSeriesKeys = uiState.getVisibleDashboardTestSeriesKeys()
    val visibleSeriesCount = visibleSeriesKeys.size
    val aggregateProgress = uiState.getVisibleSeriesAggregateProgress()

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .border(1.5.dp, SaffronGold, RoundedCornerShape(16.dp))
            .testTag("dashboard_category_filter_bar"),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 14.dp, vertical = 12.dp)
        ) {
            // Top Row: Title + Active Count / Reset
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        imageVector = Icons.Default.FilterList,
                        contentDescription = null,
                        tint = SaffronGold,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = if (isHi)
                            "परीक्षा वर्ग फ़िल्टर एवं प्रोग्रेस ट्रैकर"
                        else
                            "Filter by Exam Category & Progress Tracker",
                        fontSize = 12.5.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                if (activeFilterKey != "ALL") {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(6.dp))
                            .background(Color(0xFFDC2626))
                            .clickable { onClearFilter() }
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                            .testTag("dashboard_category_reset_btn")
                    ) {
                        Text(
                            text = if (isHi) "सभी दिखाएं ✕" else "Show All ✕",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White,
                            maxLines = 1,
                            softWrap = false
                        )
                    }
                } else {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(6.dp))
                            .background(EmeraldSuccess)
                            .padding(horizontal = 8.dp, vertical = 3.dp)
                    ) {
                        Text(
                            text = if (isHi) "$visibleSeriesCount सीरीज़ सक्रिय" else "$visibleSeriesCount Series Active",
                            fontSize = 9.5.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White,
                            maxLines = 1,
                            softWrap = false
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Category Filter Chips Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                DashboardCategoryFilterCatalog.filters.forEach { item ->
                    val isSelected = activeFilterKey.equals(item.key, ignoreCase = true)
                    val itemProgress = if (item.key == "ALL") {
                        uiState.getVisibleSeriesAggregateProgress()
                    } else {
                        uiState.getExamCategoryProgress(item.seriesKey)
                    }
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .background(
                                if (isSelected) EdTechProColors.RoyalIndigo else EdTechProColors.UnselectedDarkTabBg
                            )
                            .border(
                                width = if (isSelected) 1.5.dp else 1.dp,
                                color = if (isSelected) EdTechProColors.WarmGold else EdTechProColors.UnselectedDarkTabBorder,
                                shape = RoundedCornerShape(10.dp)
                            )
                            .clickable {
                                if (isSelected && item.key != "ALL") {
                                    onClearFilter()
                                } else {
                                    onSelectCategoryFilter(item.key)
                                }
                            }
                            .padding(horizontal = 10.dp, vertical = 7.dp)
                            .testTag("dashboard_category_chip_${item.key}")
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            ShakuntalamBrandCrestBadge(
                                size = 18.dp,
                                showGlowRing = isSelected
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Column(horizontalAlignment = Alignment.Start) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text(
                                        text = if (isHi) item.labelHi else item.labelEn,
                                        fontSize = 11.5.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = if (isSelected) EdTechProColors.ChampagneGold else Color.White,
                                        maxLines = 1,
                                        softWrap = false
                                    )
                                    Spacer(modifier = Modifier.width(5.dp))
                                    Text(
                                        text = "${itemProgress.completionPercent}%",
                                        fontSize = 9.5.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = if (isSelected) Color(0xFF6EE7B7) else EdTechProColors.WarmGold,
                                        maxLines = 1,
                                        softWrap = false
                                    )
                                }
                                Text(
                                    text = if (isHi) item.seriesBadgeHi else item.seriesBadgeEn,
                                    fontSize = 8.5.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = if (isSelected) Color.White else Color(0xFFCBD5E1),
                                    maxLines = 1,
                                    softWrap = false
                                )
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Visual Progress Tracking Section with CircularProgressIndicator for each selected test series
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFF1E293B))
                    .border(1.dp, Color(0xFF334155), RoundedCornerShape(12.dp))
                    .padding(12.dp)
                    .testTag("dashboard_circular_progress_tracker_card")
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.weight(1f)
                    ) {
                        TestSeriesCircularProgressRing(
                            progress = aggregateProgress,
                            seriesKey = "aggregate",
                            size = 44.dp,
                            strokeWidth = 4.5.dp,
                            accentColor = SaffronGold,
                            trackColor = Color(0xFF0F172A)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = if (isHi)
                                    "चयनित टेस्ट सीरीज़ सर्कुलर प्रोग्रेस ट्रैकर"
                                else
                                    "Selected Test Series Circular Progress Tracker",
                                fontSize = 11.5.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = SaffronGold,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Text(
                                text = if (isHi)
                                    "कुल पूर्णता: ${aggregateProgress.completionPercent}% (${aggregateProgress.answeredCount}/${aggregateProgress.totalQuestions} प्रश्न हल)"
                                else
                                    "Completion: ${aggregateProgress.completionPercent}% (${aggregateProgress.answeredCount}/${aggregateProgress.totalQuestions} Qs Answered)",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color(0xFFE2E8F0),
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }

                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(6.dp))
                            .background(if (aggregateProgress.isCompleted) EmeraldSuccess else Color(0xFF0F172A))
                            .border(1.dp, SaffronGold, RoundedCornerShape(6.dp))
                            .padding(horizontal = 7.dp, vertical = 3.dp)
                            .testTag("dashboard_circular_tracker_status_badge")
                    ) {
                        Text(
                            text = if (isHi) aggregateProgress.statusHi else aggregateProgress.statusEn,
                            fontSize = 9.5.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White,
                            maxLines = 1,
                            softWrap = false
                        )
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                // Horizontal Row of Circular Progress Indicators for each visible/selected Test Series
                val visibleSeriesSpecs = DashboardCategoryFilterCatalog.seriesDisplayItems.filter {
                    visibleSeriesKeys.contains(it.seriesKey)
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState())
                        .testTag("dashboard_circular_progress_tracker_row"),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    visibleSeriesSpecs.forEach { seriesItem ->
                        val seriesProgress = uiState.getExamCategoryProgress(seriesItem.seriesKey)
                        val isSpecificallySelected = activeFilterKey.equals(seriesItem.key, ignoreCase = true)

                        Column(
                            modifier = Modifier
                                .width(114.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(
                                    if (isSpecificallySelected) Color(0xFF172554) else Color(0xFF0F172A)
                                )
                                .border(
                                    width = if (isSpecificallySelected) 1.5.dp else 1.dp,
                                    color = if (seriesProgress.isCompleted) {
                                        EmeraldSuccess
                                    } else if (isSpecificallySelected) {
                                        SaffronGold
                                    } else {
                                        seriesItem.accentColor.copy(alpha = 0.6f)
                                    },
                                    shape = RoundedCornerShape(12.dp)
                                )
                                .clickable {
                                    onSelectCategoryFilter(seriesItem.key)
                                }
                                .padding(horizontal = 8.dp, vertical = 10.dp)
                                .testTag("dashboard_series_circular_card_${seriesItem.seriesKey}"),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            TestSeriesCircularProgressRing(
                                progress = seriesProgress,
                                seriesKey = seriesItem.seriesKey,
                                size = 52.dp,
                                strokeWidth = 5.dp,
                                accentColor = seriesItem.accentColor,
                                trackColor = Color(0xFF1E293B)
                            )

                            Spacer(modifier = Modifier.height(6.dp))

                            Text(
                                text = if (isHi) seriesItem.labelHi else seriesItem.labelEn,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.White,
                                maxLines = 1,
                                softWrap = false,
                                overflow = TextOverflow.Ellipsis
                            )

                            Text(
                                text = "${seriesProgress.answeredCount}/${seriesProgress.totalQuestions} Qs",
                                fontSize = 9.5.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color(0xFFCBD5E1),
                                maxLines = 1,
                                softWrap = false
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(4.dp))
                                    .background(
                                        when {
                                            seriesProgress.isCompleted -> EmeraldSuccess
                                            seriesProgress.answeredCount > 0 -> SaffronGold
                                            else -> Color(0xFF334155)
                                        }
                                    )
                                    .padding(horizontal = 6.dp, vertical = 2.dp)
                            ) {
                                Text(
                                    text = if (isHi) seriesProgress.statusHi else seriesProgress.statusEn,
                                    fontSize = 8.5.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = if (seriesProgress.answeredCount > 0 && !seriesProgress.isCompleted) {
                                        Navy900
                                    } else {
                                        Color.White
                                    },
                                    maxLines = 1,
                                    softWrap = false
                                )
                            }
                        }
                    }
                }
            }

            if (activeFilterKey != "ALL") {
                Spacer(modifier = Modifier.height(8.dp))
                val activeItem = DashboardCategoryFilterCatalog.filters.firstOrNull {
                    it.key.equals(activeFilterKey, ignoreCase = true)
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFF1E293B))
                        .border(1.dp, EmeraldSuccess, RoundedCornerShape(8.dp))
                        .padding(horizontal = 10.dp, vertical = 6.dp)
                        .testTag("dashboard_active_category_banner"),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Verified,
                            contentDescription = null,
                            tint = EmeraldSuccess,
                            modifier = Modifier.size(14.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = if (isHi) {
                                "सक्रिय फ़िल्टर: ${activeItem?.labelHi ?: activeFilterKey} • $visibleSeriesCount संबंधित टेस्ट सीरीज़ प्रदर्शित (${aggregateProgress.completionPercent}% पूर्ण)"
                            } else {
                                "Showing relevant test series for: ${activeItem?.labelEn ?: activeFilterKey} ($visibleSeriesCount Test Series • ${aggregateProgress.completionPercent}% Complete)"
                            },
                            fontSize = 10.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFA7F3D0),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }
        }
    }
}

/**
 * Dedicated Banking Test Series Card on the Main Dashboard for IBPS PO/Clerk, SBI PO/Clerk & RBI Grade B.
 */
@Composable
fun BankingDashboardTestSeriesCard(
    uiState: ShakuntalamUiState,
    isHi: Boolean,
    onSelectTestSeriesMode: (String) -> Unit,
    onStartBankingTest: () -> Unit,
    onOpenBankingHub: () -> Unit,
    onBuyOrOpenPaidItem: (StudyItem) -> Unit,
    onAddPaidItemToCart: (StudyItem) -> Unit,
    modifier: Modifier = Modifier
) {
    val bankingMode = uiState.examTestSeriesModeMap["banking"] ?: "FREE"
    val bankingProgress = uiState.getExamCategoryProgress("banking")

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .border(2.dp, SaffronGold, RoundedCornerShape(16.dp))
            .testTag("home_banking_free_test_card"),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF0F2942)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(4.dp))
                                .background(SaffronGold)
                                .padding(horizontal = 6.dp, vertical = 2.dp)
                        ) {
                            Text(
                                text = "BANKING • IBPS / SBI / RBI",
                                fontSize = 9.5.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Navy900,
                                maxLines = 1,
                                softWrap = false
                            )
                        }
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "★ Prelims & Mains PYQ Series (+1.0 / -0.25)",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFFDE68A),
                            maxLines = 1,
                            softWrap = false,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = if (isHi)
                            "बैंकिंग (IBPS PO/Clerk, SBI PO एवं RBI Grade B) टेस्ट सीरीज़"
                        else
                            "Banking (IBPS PO/Clerk, SBI PO & RBI Grade B) Test Series",
                        fontSize = 14.5.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = if (isHi)
                            "क्वांटिटेटिव एप्टीट्यूड एवं DI • रीजनिंग पज़ल्स • इंग्लिश लैंग्वेज • बैंकिंग एवं फाइनेंशियल अवेयरनेस"
                        else
                            "Quantitative Aptitude & DI • Reasoning & Seating Puzzles • English Language • Banking & RBI Awareness",
                        fontSize = 11.sp,
                        color = Color(0xFFBAE6FD),
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Spacer(modifier = Modifier.width(10.dp))

                TestSeriesCircularProgressRing(
                    progress = bankingProgress,
                    seriesKey = "card_banking",
                    size = 48.dp,
                    strokeWidth = 4.5.dp,
                    accentColor = Color(0xFF10B981)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            ExamPaidFreeDualTabs(
                examKey = "banking",
                examLabelEn = "Banking (IBPS / SBI / RBI)",
                examLabelHi = "बैंकिंग (IBPS / SBI / RBI)",
                selectedMode = bankingMode,
                freeCountBadge = if (isHi) "4 मुख्य विषय • फ्री PYQ टेस्ट" else "4 Core Sections • Free PYQ Tests",
                paidCountBadge = if (isHi) "45 फुल-लेंथ IBPS/SBI मॉक" else "45 Full-Length IBPS/SBI Mocks",
                isHi = isHi,
                onSelectMode = onSelectTestSeriesMode
            )

            Spacer(modifier = Modifier.height(8.dp))

            ExamOverallProgressStrip(
                examKey = "banking",
                progress = bankingProgress,
                isHi = isHi
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = onStartBankingTest,
                    colors = ButtonDefaults.buttonColors(containerColor = SaffronGold),
                    shape = RoundedCornerShape(10.dp),
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 0.dp),
                    modifier = Modifier
                        .weight(1f)
                        .height(44.dp)
                        .testTag("home_banking_attempt_free_test_btn")
                ) {
                    Icon(
                        imageVector = Icons.Default.Quiz,
                        contentDescription = null,
                        tint = Navy900,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = if (isHi) "बैंकिंग फ्री PYQ टेस्ट शुरू करें ▶" else "Start Banking Free PYQ Test ▶",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Navy900,
                        maxLines = 1,
                        softWrap = false,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Button(
                    onClick = onOpenBankingHub,
                    colors = ButtonDefaults.buttonColors(containerColor = Navy900),
                    shape = RoundedCornerShape(10.dp),
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 0.dp),
                    modifier = Modifier
                        .height(44.dp)
                        .testTag("home_banking_hub_btn")
                ) {
                    Text(
                        text = if (isHi) "बैंकिंग हब >" else "Banking Hub >",
                        fontSize = 11.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = SaffronGold,
                        maxLines = 1,
                        softWrap = false
                    )
                }
            }

            if (bankingMode == "PAID") {
                val bankingPaidItems = uiState.customStudyItems.filter {
                    it.categoryId == "banking" && it.discountedPrice > 0
                }
                ExamPaidTestSeriesPanel(
                    examKey = "banking",
                    examTitleEn = "Banking (IBPS PO / SBI PO / RBI Grade B)",
                    examTitleHi = "बैंकिंग (IBPS PO / SBI PO / RBI ग्रेड B)",
                    paidItems = bankingPaidItems,
                    purchasedItemIds = uiState.purchasedItemIds,
                    isHi = isHi,
                    onBuyOrOpenItem = onBuyOrOpenPaidItem,
                    onAddToCart = onAddPaidItemToCart,
                    onStartPaidMockTest = onStartBankingTest,
                    onSwitchToFreeTests = { onSelectTestSeriesMode("FREE") }
                )
            } else {
                Spacer(modifier = Modifier.height(10.dp))
                val bankingPillars = listOf(
                    Triple(
                        "1",
                        if (isHi) "1. क्वांटिटेटिव एप्टीट्यूड एवं डेटा इंटरप्रिटेशन (DI)" else "1. Quantitative Aptitude & Data Interpretation (DI)",
                        if (isHi) "Number Series, Quadratic, Arithmetic & Caselet DI • IBPS/SBI PYQs" else "Number Series, Quadratic, Arithmetic & Caselet DI • IBPS/SBI PYQs"
                    ),
                    Triple(
                        "2",
                        if (isHi) "2. रीजनिंग एबिलिटी एवं सीटिंग पज़ल्स (Puzzles)" else "2. Reasoning Ability & High-Level Seating Puzzles",
                        if (isHi) "Floor/Box Puzzles, Syllogism, Inequality & Input-Output • PYQs" else "Floor/Box Puzzles, Syllogism, Inequality & Input-Output • PYQs"
                    ),
                    Triple(
                        "3",
                        if (isHi) "3. इंग्लिश लैंग्वेज एवं रीडिंग कॉम्प्रिहेंशन" else "3. English Language & Financial Reading Comprehension",
                        if (isHi) "RC, Para Jumbles, Cloze Test, Error Detection & Connectors • PYQs" else "RC, Para Jumbles, Cloze Test, Error Detection & Connectors • PYQs"
                    ),
                    Triple(
                        "4",
                        if (isHi) "4. बैंकिंग, RBI मौद्रिक नीति एवं फाइनेंशियल अवेयरनेस" else "4. Banking, RBI Monetary Policy & Financial Awareness",
                        if (isHi) "Basel-III, NPA, Repo/CRR, UPI/NPCI & Union Budget • PYQs" else "Basel-III, NPA, Repo/CRR, UPI/NPCI & Union Budget • PYQs"
                    )
                )

                Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    bankingPillars.forEach { (num, title, subtitle) ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color(0xFF1E3A5F))
                                .border(1.dp, Color(0xFF38BDF8), RoundedCornerShape(10.dp))
                                .clickable { onStartBankingTest() }
                                .padding(horizontal = 12.dp, vertical = 8.dp)
                                .testTag("home_banking_section_$num"),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.weight(1f)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(26.dp)
                                        .clip(CircleShape)
                                        .background(SaffronGold),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = num,
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = Navy900
                                    )
                                }
                                Spacer(modifier = Modifier.width(10.dp))
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(
                                        text = title,
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                    Text(
                                        text = subtitle,
                                        fontSize = 10.sp,
                                        color = Color(0xFFBAE6FD),
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(6.dp))
                                    .background(EmeraldSuccess)
                                    .padding(horizontal = 10.dp, vertical = 5.dp)
                            ) {
                                Text(
                                    text = if (isHi) "अटेम्प्ट" else "Start",
                                    fontSize = 10.5.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color.White,
                                    maxLines = 1,
                                    softWrap = false
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

/**
 * Dedicated Railways (RRB NTPC, Group D & ALP) Test Series Card on the Main Dashboard.
 */
@Composable
fun RailwaysDashboardTestSeriesCard(
    uiState: ShakuntalamUiState,
    isHi: Boolean,
    onSelectTestSeriesMode: (String) -> Unit,
    onStartRailwaysTest: () -> Unit,
    onOpenRailwaysHub: () -> Unit,
    onBuyOrOpenPaidItem: (StudyItem) -> Unit,
    onAddPaidItemToCart: (StudyItem) -> Unit,
    modifier: Modifier = Modifier
) {
    val railwaysMode = uiState.examTestSeriesModeMap["railways"] ?: "FREE"
    val railwaysProgress = uiState.getExamCategoryProgress("railways")

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .border(2.dp, SaffronGold, RoundedCornerShape(16.dp))
            .testTag("home_railways_free_test_card"),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF1E293B)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(4.dp))
                                .background(SaffronGold)
                                .padding(horizontal = 6.dp, vertical = 2.dp)
                        ) {
                            Text(
                                text = "RAILWAYS • RRB NTPC / GROUP D / ALP",
                                fontSize = 9.5.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Navy900,
                                maxLines = 1,
                                softWrap = false
                            )
                        }
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "★ CBT-1 & CBT-2 PYQ Pattern (+1.0 / -0.33)",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFFDE68A),
                            maxLines = 1,
                            softWrap = false,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = if (isHi)
                            "रेलवे भर्ती बोर्ड (RRB NTPC, Group D एवं ALP) टेस्ट सीरीज़"
                        else
                            "Indian Railways (RRB NTPC, Group D & ALP) PYQ Test Series",
                        fontSize = 14.5.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = if (isHi)
                            "सामान्य विज्ञान (Physics/Chemistry/Bio) • गणित • रीजनिंग • जनरल अवेयरनेस"
                        else
                            "General Science (Physics/Chemistry/Bio) • Mathematics • Reasoning • General Awareness",
                        fontSize = 11.sp,
                        color = Color(0xFFCBD5E1),
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Spacer(modifier = Modifier.width(10.dp))

                TestSeriesCircularProgressRing(
                    progress = railwaysProgress,
                    seriesKey = "card_railways",
                    size = 48.dp,
                    strokeWidth = 4.5.dp,
                    accentColor = Color(0xFFF43F5E)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            ExamPaidFreeDualTabs(
                examKey = "railways",
                examLabelEn = "RRB NTPC & Group D",
                examLabelHi = "रेलवे RRB NTPC एवं ग्रुप D",
                selectedMode = railwaysMode,
                freeCountBadge = if (isHi) "CBT फ्री PYQ प्रैक्टिस सेट" else "CBT Free PYQ Practice Set",
                paidCountBadge = if (isHi) "30 फुल-लेंथ रेलवे CBT मॉक" else "30 Full-Length RRB CBT Mocks",
                isHi = isHi,
                onSelectMode = onSelectTestSeriesMode
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = onStartRailwaysTest,
                    colors = ButtonDefaults.buttonColors(containerColor = SaffronGold),
                    shape = RoundedCornerShape(10.dp),
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 0.dp),
                    modifier = Modifier
                        .weight(1f)
                        .height(44.dp)
                        .testTag("home_railways_attempt_free_test_btn")
                ) {
                    Icon(
                        imageVector = Icons.Default.Quiz,
                        contentDescription = null,
                        tint = Navy900,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = if (isHi) "रेलवे फ्री PYQ टेस्ट शुरू करें ▶" else "Start Railways Free PYQ Test ▶",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Navy900,
                        maxLines = 1,
                        softWrap = false,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Button(
                    onClick = onOpenRailwaysHub,
                    colors = ButtonDefaults.buttonColors(containerColor = Navy900),
                    shape = RoundedCornerShape(10.dp),
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 0.dp),
                    modifier = Modifier
                        .height(44.dp)
                        .testTag("home_railways_hub_btn")
                ) {
                    Text(
                        text = if (isHi) "रेलवे हब >" else "Railways Hub >",
                        fontSize = 11.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = SaffronGold,
                        maxLines = 1,
                        softWrap = false
                    )
                }
            }

            if (railwaysMode == "PAID") {
                val railPaidItems = uiState.customStudyItems.filter {
                    it.categoryId == "railways" && it.discountedPrice > 0
                }
                ExamPaidTestSeriesPanel(
                    examKey = "railways",
                    examTitleEn = "Railways RRB NTPC & Group D",
                    examTitleHi = "रेलवे RRB NTPC एवं ग्रुप D",
                    paidItems = railPaidItems,
                    purchasedItemIds = uiState.purchasedItemIds,
                    isHi = isHi,
                    onBuyOrOpenItem = onBuyOrOpenPaidItem,
                    onAddToCart = onAddPaidItemToCart,
                    onStartPaidMockTest = onStartRailwaysTest,
                    onSwitchToFreeTests = { onSelectTestSeriesMode("FREE") }
                )
            }
        }
    }
}

/**
 * Dedicated UP Police Constable & Sub-Inspector (UPP / UP SI — 60,244+ Recruitment Pattern)
 * Test Series Card on the Main Dashboard with Paid (50 Tests: 20 FLT + 20 Sectional + 10 PYQ)
 * and Free (4 Subject Sections + Topic/PYQ) tabs.
 */
@Composable
fun UpPoliceDashboardTestSeriesCard(
    uiState: ShakuntalamUiState,
    isHi: Boolean,
    onSelectTestSeriesMode: (String) -> Unit,
    onStartUpPoliceTest: (String) -> Unit,
    onOpenUpPoliceHub: () -> Unit,
    onBuyOrOpenPaidItem: (StudyItem) -> Unit,
    onAddPaidItemToCart: (StudyItem) -> Unit,
    modifier: Modifier = Modifier
) {
    val upPoliceMode = uiState.examTestSeriesModeMap["up_police"] ?: "FREE"
    val upPoliceProgress = uiState.getExamCategoryProgress("up_police")

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .border(2.dp, SaffronGold, RoundedCornerShape(16.dp))
            .testTag("home_up_police_free_test_card"),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = EdTechProColors.DeepRoyalNavy
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        ShakuntalamBrandCrestBadge(size = 18.dp, showGlowRing = true)
                        Spacer(modifier = Modifier.width(6.dp))
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(4.dp))
                                .background(SaffronGold)
                                .padding(horizontal = 6.dp, vertical = 2.dp)
                        ) {
                            Text(
                                text = "UPPRPB • UP POLICE CONSTABLE & SI",
                                fontSize = 9.5.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Navy900,
                                maxLines = 1,
                                softWrap = false
                            )
                        }
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "★ 150 Qs • 300 Marks (+2.0 / -0.50)",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFFDE68A),
                            maxLines = 1,
                            softWrap = false,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = if (isHi)
                            "उत्तर प्रदेश पुलिस कांस्टेबल एवं दरोगा (UP Police Constable & SI) टेस्ट सीरीज़"
                        else
                            "UP Police Constable & Sub-Inspector (UPPRPB) Complete Test Series",
                        fontSize = 14.5.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = if (isHi)
                            "सामान्य हिंदी (37 Q) • सामान्य ज्ञान व यूपी जीके (38 Q) • संख्यात्मक योग्यता (38 Q) • मानसिक अभिरुचि व रीजनिंग (37 Q)"
                        else
                            "General Hindi (37 Qs) • UP GK & GS (38 Qs) • Numerical Ability (38 Qs) • Mental Aptitude & Reasoning (37 Qs)",
                        fontSize = 11.sp,
                        color = Color(0xFFCBD5E1),
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Spacer(modifier = Modifier.width(10.dp))

                TestSeriesCircularProgressRing(
                    progress = upPoliceProgress,
                    seriesKey = "card_up_police",
                    size = 48.dp,
                    strokeWidth = 4.5.dp,
                    accentColor = Color(0xFFF59E0B)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            ExamPaidFreeDualTabs(
                examKey = "up_police",
                examLabelEn = "UP Police Constable & SI",
                examLabelHi = "यूपी पुलिस कांस्टेबल एवं SI",
                selectedMode = upPoliceMode,
                freeCountBadge = if (isHi) "4 विषय सेक्शन • फ्री PYQ व टॉपिक टेस्ट" else "4 Subject Sections • Free PYQ & Topic Tests",
                paidCountBadge = if (isHi) "50 पेड टेस्ट (20 FLT + 20 सेक्शनल + 10 PYQ)" else "50 Paid Tests (20 FLT + 20 Sec + 10 PYQ)",
                isHi = isHi,
                onSelectMode = onSelectTestSeriesMode
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = { onStartUpPoliceTest("up_police_official_pyq_1") },
                    colors = ButtonDefaults.buttonColors(containerColor = SaffronGold),
                    shape = RoundedCornerShape(10.dp),
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 0.dp),
                    modifier = Modifier
                        .weight(1f)
                        .height(44.dp)
                        .testTag("home_up_police_attempt_free_test_btn")
                ) {
                    Icon(
                        imageVector = Icons.Default.Quiz,
                        contentDescription = null,
                        tint = Navy900,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = if (isHi) "यूपी पुलिस फ्री टेस्ट शुरू करें (150 Q) ▶" else "Start UP Police Free Test (150 Qs) ▶",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Navy900,
                        maxLines = 1,
                        softWrap = false,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Button(
                    onClick = onOpenUpPoliceHub,
                    colors = ButtonDefaults.buttonColors(containerColor = Navy900),
                    shape = RoundedCornerShape(10.dp),
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 0.dp),
                    modifier = Modifier
                        .height(44.dp)
                        .testTag("home_up_police_hub_btn")
                ) {
                    Text(
                        text = if (isHi) "यूपी पुलिस हब >" else "UP Police Hub >",
                        fontSize = 11.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = SaffronGold,
                        maxLines = 1,
                        softWrap = false
                    )
                }
            }

            if (upPoliceMode == "PAID") {
                val uppPaidItems = uiState.customStudyItems.filter {
                    (it.categoryId == "up_police" || it.subSectionId == "sub_upsssc") && it.discountedPrice > 0
                }
                ExamPaidTestSeriesPanel(
                    examKey = "up_police",
                    examTitleEn = "UP Police Constable & Sub-Inspector (150 Qs • 300 Marks)",
                    examTitleHi = "यूपी पुलिस कांस्टेबल एवं दरोगा भर्ती (150 प्रश्न • 300 अंक)",
                    paidItems = uppPaidItems,
                    purchasedItemIds = uiState.purchasedItemIds,
                    isHi = isHi,
                    onBuyOrOpenItem = onBuyOrOpenPaidItem,
                    onAddToCart = onAddPaidItemToCart,
                    onStartPaidMockTest = { onStartUpPoliceTest("up_police_flt_mock_1") },
                    onSwitchToFreeTests = { onSelectTestSeriesMode("FREE") }
                )
            } else {
                Spacer(modifier = Modifier.height(10.dp))
                val upPolicePillars = listOf(
                    Quintuple(
                        "1",
                        "up_police_sectional_1",
                        if (isHi) "1. सामान्य हिंदी (General Hindi — 38 प्रश्न)" else "1. General Hindi (व्याकरण एवं साहित्य — 38 Qs)",
                        if (isHi) "वर्णमाला, संधि, समास, रस-छंद-अलंकार, मुहावरे एवं प्रसिद्ध कवि/रचनाएँ • +2.0/-0.50" else "Varnamala, Sandhi, Samas, Ras-Chhand-Alankar, Idioms & Hindi Literature • +2.0/-0.50",
                        "38 Qs"
                    ),
                    Quintuple(
                        "2",
                        "up_police_sectional_6",
                        if (isHi) "2. सामान्य ज्ञान, यूपी जीके एवं पुलिस प्रशासन (38 प्रश्न)" else "2. General Knowledge, UP GK & Police System (38 Qs)",
                        if (isHi) "उ.प्र. का इतिहास/भूगोल/ODOP, भारतीय संविधान, BNS, मानवाधिकार, साइबर क्राइम व जीएसटी • +2.0/-0.50" else "UP History/Geo/ODOP, Indian Constitution, BNS, Human Rights, Cyber Crime & GST • +2.0/-0.50",
                        "38 Qs"
                    ),
                    Quintuple(
                        "3",
                        "up_police_sectional_11",
                        if (isHi) "3. संख्यात्मक एवं मानसिक योग्यता (Numerical Ability — 38 प्रश्न)" else "3. Numerical & Mental Ability (Maths & DI — 38 Qs)",
                        if (isHi) "संख्या पद्धति, प्रतिशत, लाभ-हानि, अनुपात, समय-कार्य, क्षेत्रमिति एवं एक्सेल DI तालिका • +2.0/-0.50" else "Number System, Percentage, Profit-Loss, Ratio, Time-Work, Mensuration & Excel DI Table • +2.0/-0.50",
                        "38 Qs"
                    ),
                    Quintuple(
                        "4",
                        "up_police_sectional_16",
                        if (isHi) "4. मानसिक अभिरुचि, बुद्धिलब्धि एवं तार्किक क्षमता (38 प्रश्न)" else "4. Mental Aptitude, IQ & Reasoning Ability (38 Qs)",
                        if (isHi) "कानून एवं शांति व्यवस्था, अपराध नियंत्रण, कोडिंग-डिकोडिंग, रक्त संबंध, दिशा व आकृति गणना • +2.0/-0.50" else "Law & Order, Crime Control, Coding-Decoding, Blood Relations, Direction & Figure Counting • +2.0/-0.50",
                        "38 Qs"
                    )
                )

                Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    upPolicePillars.forEach { (num, testId, title, subtitle, badge) ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp))
                                .background(EdTechProColors.ElevatedNavy)
                                .border(1.dp, Color(0xFFF59E0B), RoundedCornerShape(10.dp))
                                .clickable { onStartUpPoliceTest(testId) }
                                .padding(horizontal = 12.dp, vertical = 9.dp)
                                .testTag("home_up_police_section_$num"),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.weight(1f)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(26.dp)
                                        .clip(CircleShape)
                                        .background(SaffronGold),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = num,
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = Navy900
                                    )
                                }
                                Spacer(modifier = Modifier.width(10.dp))
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(
                                        text = title,
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                    Text(
                                        text = subtitle,
                                        fontSize = 10.sp,
                                        color = Color(0xFFFDE68A),
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(6.dp))
                                    .background(EmeraldSuccess)
                                    .padding(horizontal = 10.dp, vertical = 5.dp)
                            ) {
                                Text(
                                    text = if (isHi) "अटेम्प्ट ($badge)" else "Start $badge",
                                    fontSize = 10.5.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color.White,
                                    maxLines = 1,
                                    softWrap = false
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

private data class Quintuple<A, B, C, D, E>(
    val first: A,
    val second: B,
    val third: C,
    val fourth: D,
    val fifth: E
)

