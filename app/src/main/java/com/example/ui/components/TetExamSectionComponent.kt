package com.example.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material3.*
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
import com.example.data.tet.TetAllSubjectsPyqData
import com.example.data.tet.TetSectionTestSpec
import com.example.model.StudyItem
import com.example.ui.theme.EmeraldSuccess
import com.example.ui.theme.Navy900
import com.example.ui.theme.SaffronGold
import com.example.viewmodel.ShakuntalamUiState

private val TetDeepBg = EdTechProColors.DeepRoyalNavy
private val TetAccentTeal = EdTechProColors.RoyalIndigo

/**
 * Dedicated 'Teaching Eligibility Test (TET) — सीटेट (CTET), यूपीटेट (UPTET), यूटेट व अन्य (UTET & Others)' Component:
 * 1. Top Header with TET Icon explicitly displaying:
 *      - सीटेट (CTET)
 *      - यूपीटेट (UPTET)
 *      - यूटेट व अन्य (UTET & Others)
 * 2. Directly underneath: Two primary mode tabs via ExamPaidFreeDualTabs:
 *      - 1. पेड टेस्ट सीरीज़ (Paid Test Series)
 *      - 2. फ्री टेस्ट सीरीज़ (Free Test Series / Free Mock • 700 PYQs)
 * 3. Inside Free Test Series:
 *      - Exam Tabs: 1. सीटेट (CTET) | 2. यूपीटेट (UPTET) | 3. यूटेट व अन्य (UTET & Others)
 *      - All 7 Core TET Subjects with 100-100 PYQ MCQs each:
 *        (1) CDP (सीडीपी), (2) EVS (ईवीएस), (3) Maths (मैथ्स), (4) Science (साइंस),
 *        (5) Social Science (सोशल साइंस), (6) Hindi (हिंदी), (7) English / Sanskrit (अंग्रेज़ी / संस्कृत)
 */
@Composable
fun TetExamSectionComponent(
    uiState: ShakuntalamUiState,
    isHi: Boolean,
    cardTestTag: String,
    attemptButtonTestTag: String,
    sectionRowTagPrefix: String,
    showHubButton: Boolean,
    onSelectExamTab: (String) -> Unit,
    onSelectTestSeriesMode: (String) -> Unit,
    onSelectSubjectFilter: (String) -> Unit,
    onToggleExpandFreeTests: () -> Unit,
    onOpenTetHub: () -> Unit,
    onStartSectionTest: (String) -> Unit,
    onBuyOrOpenPaidItem: (StudyItem) -> Unit,
    onAddPaidItemToCart: (StudyItem) -> Unit,
    modifier: Modifier = Modifier
) {
    val tetMode = uiState.examTestSeriesModeMap["tet"] ?: "FREE"
    val selectedExamTab = uiState.selectedTetExamTab // "CTET", "UPTET", "UTET"
    val selectedSubjectFilter = uiState.selectedTetSubjectFilter

    val filteredSpecs = TetAllSubjectsPyqData.allSpecs.filter { spec ->
        selectedSubjectFilter.equals("ALL", ignoreCase = true) ||
            spec.subjectCode.equals(selectedSubjectFilter, ignoreCase = true)
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .border(2.dp, SaffronGold, RoundedCornerShape(16.dp))
            .testTag(cardTestTag),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = TetDeepBg),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // ==================== 1. TOP HEADER WITH ICON SHOWING सीटेट, यूपीटेट, यूटेट व अन्य ====================
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    // Top Icon Badge with सीटेट • यूपीटेट • यूटेट व अन्य
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = Color(0xFFFFD54F),
                        border = BorderStroke(1.5.dp, Color.White),
                        modifier = Modifier
                            .width(92.dp)
                            .testTag("tet_top_icon_badge")
                    ) {
                        Column(
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 6.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.School,
                                contentDescription = "TET Icon",
                                tint = Color(0xFF042F2E),
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = "• सीटेट (CTET)",
                                fontSize = 8.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color(0xFF042F2E),
                                maxLines = 1,
                                softWrap = false
                            )
                            Text(
                                text = "• यूपीटेट (UPTET)",
                                fontSize = 8.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color(0xFF9A3412),
                                maxLines = 1,
                                softWrap = false
                            )
                            Text(
                                text = "• यूटेट व अन्य",
                                fontSize = 8.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color(0xFF1E3A8A),
                                maxLines = 1,
                                softWrap = false
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(10.dp))

                    Column(modifier = Modifier.weight(1f)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(4.dp))
                                    .background(SaffronGold)
                                    .padding(horizontal = 6.dp, vertical = 2.dp)
                            ) {
                                Text(
                                    text = "TET • 700 PYQs",
                                    fontSize = 9.5.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Navy900,
                                    maxLines = 1,
                                    softWrap = false
                                )
                            }
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "★ 7 Subjects × 100-100 MCQs",
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
                                "शिक्षक पात्रता परीक्षा: सीटेट • यूपीटेट • यूटेट व अन्य"
                            else
                                "Teaching Eligibility Test: सीटेट (CTET) • यूपीटेट (UPTET) • यूटेट व अन्य",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = if (isHi)
                                "सीडीपी (CDP) • ईवीएस (EVS) • मैथ्स • साइंस • सोशल साइंस • हिंदी • अंग्रेज़ी/संस्कृत (100-100 प्रश्न)"
                            else
                                "CDP • EVS • Maths • Science • Social Science • Hindi • English/Sanskrit (100-100 PYQs)",
                            fontSize = 11.sp,
                            color = Color(0xFF99F6E4),
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }

                Spacer(modifier = Modifier.width(10.dp))

                TestSeriesCircularProgressRing(
                    progress = uiState.getExamCategoryProgress("tet"),
                    seriesKey = "card_tet",
                    size = 48.dp,
                    strokeWidth = 4.5.dp,
                    accentColor = SaffronGold
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            // ==================== 2. BELOW ICON: PAID TEST SERIES vs FREE TEST SERIES ====================
            ExamPaidFreeDualTabs(
                examKey = "tet",
                examLabelEn = "TET (CTET • UPTET • UTET & Others)",
                examLabelHi = "शिक्षक पात्रता परीक्षा (सीटेट • यूपीटेट • यूटेट व अन्य)",
                selectedMode = tetMode,
                freeCountBadge = if (isHi) "फ्री टेस्ट सीरीज़ (7 विषय × 100 = 700 Q)" else "Free Test Series (7 Subjects × 100 = 700 Qs)",
                paidCountBadge = if (isHi) "पेड टेस्ट सीरीज़ (CTET/UPTET/UTET)" else "Paid Test Series (CTET/UPTET/UTET)",
                isHi = isHi,
                onSelectMode = { mode ->
                    onSelectTestSeriesMode(mode)
                    if (mode == "FREE" && !uiState.isTetFreeTestSectionExpanded) {
                        onToggleExpandFreeTests()
                    }
                }
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Overall TET Progress Strip (700 Qs across 7 subjects)
            ExamOverallProgressStrip(
                examKey = "tet",
                progress = uiState.getTetOverallProgress(),
                isHi = isHi
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Expand / Collapse Free Test Series Button & Hub Button
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = onToggleExpandFreeTests,
                    colors = ButtonDefaults.buttonColors(containerColor = SaffronGold),
                    shape = RoundedCornerShape(10.dp),
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 0.dp),
                    modifier = Modifier
                        .weight(1f)
                        .height(44.dp)
                        .testTag(attemptButtonTestTag)
                ) {
                    Icon(
                        imageVector = Icons.Default.Quiz,
                        contentDescription = null,
                        tint = Navy900,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = if (uiState.isTetFreeTestSectionExpanded) {
                            if (isHi) "सीटेट / यूपीटेट / यूटेट फ्री टेस्ट (7 विषय) ▲" else "CTET / UPTET / UTET Free Tests (7 Subjects) ▲"
                        } else {
                            if (isHi) "सीटेट / यूपीटेट / यूटेट फ्री टेस्ट खोलें ▼" else "Open CTET / UPTET / UTET Free Tests ▼"
                        },
                        fontSize = 12.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Navy900,
                        maxLines = 1,
                        softWrap = false,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                if (showHubButton) {
                    Button(
                        onClick = onOpenTetHub,
                        colors = ButtonDefaults.buttonColors(containerColor = Navy900),
                        shape = RoundedCornerShape(10.dp),
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 0.dp),
                        modifier = Modifier
                            .height(44.dp)
                            .testTag("home_tet_hub_btn")
                    ) {
                        Text(
                            text = if (isHi) "TET सेक्शन >" else "TET Hub >",
                            fontSize = 11.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = SaffronGold,
                            maxLines = 1,
                            softWrap = false
                        )
                    }
                }
            }

            // ==================== 3. PAID vs FREE TEST SERIES CONTENT AREA ====================
            if (tetMode == "PAID") {
                val tetPaidItems = uiState.customStudyItems.filter {
                    (it.categoryId == "teaching" || it.subSectionId.startsWith("tet")) && it.discountedPrice > 0
                }
                ExamPaidTestSeriesPanel(
                    examKey = "tet",
                    examTitleEn = "CTET, UPTET & UTET (Paper 1 & Paper 2 Complete Pro Test Series)",
                    examTitleHi = "सीटेट (CTET), यूपीटेट (UPTET) व यूटेट (UTET) पेड टेस्ट सीरीज़",
                    paidItems = tetPaidItems,
                    purchasedItemIds = uiState.purchasedItemIds,
                    isHi = isHi,
                    onBuyOrOpenItem = onBuyOrOpenPaidItem,
                    onAddToCart = onAddPaidItemToCart,
                    onStartPaidMockTest = { onStartSectionTest("tet_sec_cdp_100") },
                    onSwitchToFreeTests = { onSelectTestSeriesMode("FREE") }
                )
            } else if (uiState.isTetFreeTestSectionExpanded) {
                Spacer(modifier = Modifier.height(12.dp))

                // Exam Sub-Tabs: सीटेट (CTET) | यूपीटेट (UPTET) | यूटेट व अन्य (UTET & Others)
                Text(
                    text = if (isHi)
                        "परीक्षा चुनें (1. सीटेट • 2. यूपीटेट • 3. यूटेट व अन्य):"
                    else
                        "Select Exam (1. सीटेट CTET • 2. यूपीटेट UPTET • 3. यूटेट व अन्य UTET & Others):",
                    fontSize = 11.5.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFFFDE68A),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(6.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color(0xFF0F172A))
                        .border(1.dp, TetAccentTeal, RoundedCornerShape(12.dp))
                        .padding(4.dp)
                        .testTag("tet_exam_tabs_row"),
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val examTabs = listOf(
                        Triple("CTET", "1. सीटेट (CTET)", "Paper 1 & 2"),
                        Triple("UPTET", "2. यूपीटेट (UPTET)", "Primary & Jr."),
                        Triple("UTET", "3. यूटेट व अन्य", "UTET / REET / HTET")
                    )

                    examTabs.forEach { (tabKey, titleLabel, subLabel) ->
                        val isActive = selectedExamTab.equals(tabKey, ignoreCase = true)
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .clip(RoundedCornerShape(9.dp))
                                .background(if (isActive) EdTechProColors.RoyalIndigo else EdTechProColors.UnselectedDarkTabBg)
                                .border(
                                    width = if (isActive) 1.5.dp else 1.dp,
                                    color = if (isActive) SaffronGold else EdTechProColors.UnselectedDarkTabBorder,
                                    shape = RoundedCornerShape(9.dp)
                                )
                                .clickable { onSelectExamTab(tabKey) }
                                .padding(horizontal = 6.dp, vertical = 8.dp)
                                .testTag("tet_tab_$tabKey"),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    ShakuntalamBrandCrestBadge(size = 15.dp, showGlowRing = isActive)
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(
                                        text = titleLabel,
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = if (isActive) EdTechProColors.ChampagneGold else Color.White,
                                        maxLines = 1,
                                        softWrap = false,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }
                                Text(
                                    text = subLabel,
                                    fontSize = 9.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = if (isActive) Color.White else Color(0xFFCBD5E1),
                                    maxLines = 1,
                                    softWrap = false
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                // Subject Filter Chips (All 7 Subjects: CDP, EVS, Maths, Science, Social Science, Hindi, English/Sanskrit)
                val subjectChips = listOf(
                    "ALL" to (if (isHi) "सभी 7 विषय (700 Q)" else "All 7 Subjects (700 Qs)"),
                    "CDP" to "1. सीडीपी / CDP (100 Q)",
                    "EVS" to "2. ईवीएस / EVS (100 Q)",
                    "MATHS" to "3. मैथ्स / Maths (100 Q)",
                    "SCIENCE" to "4. साइंस / Science (100 Q)",
                    "SOCIAL_SCIENCE" to "5. सोशल साइंस / SST (100 Q)",
                    "HINDI" to "6. हिंदी / Hindi (100 Q)",
                    "ENGLISH_SANSKRIT" to "7. अंग्रेज़ी / संस्कृत (100 Q)"
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    subjectChips.forEach { (code, label) ->
                        val isChipSelected = selectedSubjectFilter.equals(code, ignoreCase = true)
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .background(if (isChipSelected) EdTechProColors.RoyalIndigo else EdTechProColors.UnselectedDarkTabBg)
                                .border(
                                    width = if (isChipSelected) 1.5.dp else 1.dp,
                                    color = if (isChipSelected) EdTechProColors.WarmGold else EdTechProColors.UnselectedDarkTabBorder,
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .clickable { onSelectSubjectFilter(code) }
                                .padding(horizontal = 10.dp, vertical = 6.dp)
                                .testTag("tet_subject_chip_$code")
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                ShakuntalamBrandCrestBadge(size = 14.dp, showGlowRing = isChipSelected)
                                Spacer(modifier = Modifier.width(5.dp))
                                Text(
                                    text = label,
                                    fontSize = 10.5.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = if (isChipSelected) EdTechProColors.ChampagneGold else Color.White,
                                    maxLines = 1,
                                    softWrap = false
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                // Active Exam Info Strip
                val activeExamBanner = when (selectedExamTab.uppercase()) {
                    "UPTET" -> if (isHi)
                        "यूपीटेट (UPTET Paper 1 & 2): सभी 7 विषयों के 100-100 PYQ प्रश्न (+1.0 अंक, 0 नेगेटिव मार्किंग)"
                    else
                        "UPTET (Paper 1 & 2): All 7 Subjects × 100 PYQ MCQs (+1.0 Mark, 0.0 Negative Marking)"
                    "UTET" -> if (isHi)
                        "यूटेट व अन्य (UTET / REET / HTET / MPTET): सभी 7 विषयों के 100-100 PYQ प्रश्न (+1.0 अंक, 0 नेगेटिव)"
                    else
                        "UTET & Other State TETs: All 7 Subjects × 100 PYQ MCQs (+1.0 Mark, 0.0 Negative Marking)"
                    else -> if (isHi)
                        "सीटेट (CTET Paper 1 & 2): सभी 7 विषयों के 100-100 PYQ प्रश्न (+1.0 अंक, 0 नेगेटिव मार्किंग)"
                    else
                        "CTET (Paper 1 & 2): All 7 Subjects × 100 PYQ MCQs (+1.0 Mark, 0.0 Negative Marking)"
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFF0F172A))
                        .border(1.dp, EmeraldSuccess, RoundedCornerShape(8.dp))
                        .padding(horizontal = 10.dp, vertical = 7.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Verified,
                        contentDescription = null,
                        tint = EmeraldSuccess,
                        modifier = Modifier.size(15.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = activeExamBanner,
                        fontSize = 10.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFA7F3D0),
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                // 7 Subject Cards with 100-100 PYQ Questions each
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    filteredSpecs.forEach { spec ->
                        val sectionProgress = uiState.getSectionProgress(spec.testId, 100)
                        TetSubjectQuizRowCard(
                            spec = spec,
                            selectedExamTab = selectedExamTab,
                            isHi = isHi,
                            progress = sectionProgress,
                            rowTestTag = "${sectionRowTagPrefix}_${spec.id}",
                            onStartTest = { onStartSectionTest(spec.testId) }
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun TetSubjectQuizRowCard(
    spec: TetSectionTestSpec,
    selectedExamTab: String,
    isHi: Boolean,
    progress: com.example.viewmodel.SectionProgressInfo,
    rowTestTag: String,
    onStartTest: () -> Unit
) {
    val accentColor = Color(spec.badgeColorHex)
    val examPrefix = when (selectedExamTab.uppercase()) {
        "UPTET" -> "यूपीटेट (UPTET)"
        "UTET" -> "यूटेट व अन्य (UTET)"
        else -> "सीटेट (CTET)"
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFF0F172A))
            .border(1.dp, accentColor.copy(alpha = 0.7f), RoundedCornerShape(12.dp))
            .clickable { onStartTest() }
            .padding(12.dp)
            .testTag(rowTestTag)
    ) {
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
                        .size(34.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(accentColor),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "${spec.sectionNumber}",
                        color = Color.White,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 13.sp
                    )
                }

                Spacer(modifier = Modifier.width(10.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(4.dp))
                                .background( Color(0xFF1E293B))
                                .padding(horizontal = 6.dp, vertical = 2.dp)
                        ) {
                            Text(
                                text = "$examPrefix • ${if (isHi) spec.paperBadgeHi else spec.paperBadgeEn}",
                                fontSize = 9.sp,
                                fontWeight = FontWeight.Bold,
                                color = SaffronGold,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = if (isHi) spec.titleHi else spec.titleEn,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = if (isHi) spec.syllabusSummaryHi else spec.syllabusSummaryEn,
                        fontSize = 10.5.sp,
                        color = Color(0xFFCBD5E1),
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            Column(horizontalAlignment = Alignment.End) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(SaffronGold)
                        .padding(horizontal = 7.dp, vertical = 3.dp)
                ) {
                    Text(
                        text = if (isHi) "100 प्रश्न (PYQ)" else "100 PYQ MCQs",
                        fontSize = 9.5.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Navy900,
                        maxLines = 1,
                        softWrap = false
                    )
                }

                Spacer(modifier = Modifier.height(6.dp))

                Button(
                    onClick = onStartTest,
                    colors = ButtonDefaults.buttonColors(containerColor = EmeraldSuccess),
                    shape = RoundedCornerShape(8.dp),
                    contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp),
                    modifier = Modifier
                        .height(32.dp)
                        .testTag("tet_start_btn_${spec.id}")
                ) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(modifier = Modifier.width(3.dp))
                    Text(
                        text = if (isHi) "टेस्ट दें (100 Q)" else "Start (100 Q)",
                        fontSize = 10.5.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White,
                        maxLines = 1,
                        softWrap = false
                    )
                }
            }
        }

        if (progress.answeredCount > 0) {
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = if (isHi)
                    "प्रगति: ${progress.answeredCount}/100 प्रश्न हल (${progress.completionPercent}%)"
                else
                    "Progress: ${progress.answeredCount}/100 Answered (${progress.completionPercent}%)",
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF86EFAC)
            )
        }
    }
}
