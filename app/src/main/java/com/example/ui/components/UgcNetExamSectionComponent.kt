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
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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
import com.example.data.ugcnet.UgcNetAllSubjectsPyqData
import com.example.data.ugcnet.UgcNetSectionTestSpec
import com.example.model.StudyItem
import com.example.ui.theme.EmeraldSuccess
import com.example.ui.theme.Navy900
import com.example.ui.theme.SaffronGold
import com.example.viewmodel.SectionProgressInfo
import com.example.viewmodel.ShakuntalamUiState

private val UgcNetDeepBg = EdTechProColors.DeepRoyalNavy
private val UgcNetPaper1Indigo = EdTechProColors.RoyalIndigo
private val UgcNetPaper2Purple = EdTechProColors.RoyalIndigo

/**
 * Dedicated 'UGC NET Test Series' Component structured per user requirements:
 * 1. Top Header with UGC NET Icon & Title ("UGC NET (Paper 1 & Paper 2)").
 * 2. Directly underneath: Two primary mode tabs via ExamPaidFreeDualTabs:
 *      - 1. Paid Test Series (पेड टेस्ट सीरीज़)
 *      - 2. Free Test Series / Free Mock (फ्री टेस्ट सीरीज़ • 2,200 PYQs)
 * 3. When Free Test Series is clicked:
 *      - Opens two Paper tabs:
 *          Tab 1: पेपर 1 / Paper 1 (Teaching & Research Aptitude — All 10 Syllabus Units × 100 MCQs = 1,000 Qs)
 *          Tab 2: पेपर 2 / Paper 2 (All 12 UGC NET Subjects with Subject Name & 100-100 PYQ MCQs = 1,200 Qs)
 */
@Composable
fun UgcNetExamSectionComponent(
    uiState: ShakuntalamUiState,
    isHi: Boolean,
    cardTestTag: String,
    attemptButtonTestTag: String,
    sectionRowTagPrefix: String,
    showHubButton: Boolean,
    onSelectPaperTab: (String) -> Unit,
    onSelectTestSeriesMode: (String) -> Unit,
    onSelectSubjectFilter: (String) -> Unit,
    onToggleExpandFreeTests: () -> Unit,
    onOpenUgcNetHub: () -> Unit,
    onStartSectionTest: (String) -> Unit,
    onBuyOrOpenPaidItem: (StudyItem) -> Unit,
    onAddPaidItemToCart: (StudyItem) -> Unit,
    modifier: Modifier = Modifier
) {
    val ugcNetMode = uiState.examTestSeriesModeMap["ugc_net"] ?: "FREE"
    val selectedPaperTab = uiState.selectedUgcNetPaperTab // "PAPER_1" or "PAPER_2"
    val isPaper2Selected = selectedPaperTab.equals("PAPER_2", ignoreCase = true)
    val selectedSubjectFilter = uiState.selectedUgcNetSubjectFilter

    val activePaperSpecs = if (isPaper2Selected) {
        UgcNetAllSubjectsPyqData.getPaper2SubjectSpecs()
    } else {
        UgcNetAllSubjectsPyqData.getPaper1UnitSpecs()
    }

    val filteredSpecs = if (selectedSubjectFilter.equals("ALL", ignoreCase = true)) {
        activePaperSpecs
    } else {
        val matched = activePaperSpecs.filter {
            it.unitOrSubjectCode.equals(selectedSubjectFilter, ignoreCase = true)
        }
        if (matched.isNotEmpty()) matched else activePaperSpecs
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .border(2.dp, SaffronGold, RoundedCornerShape(16.dp))
            .testTag(cardTestTag),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = UgcNetDeepBg),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // ==================== 1. TOP HEADER WITH PROMINENT UGC NET ICON ====================
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    // Top UGC NET Icon Badge
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                            .background(Color(0xFF312E81))
                            .border(2.dp, SaffronGold, CircleShape)
                            .testTag("ugc_net_top_icon_badge"),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                imageVector = Icons.Default.School,
                                contentDescription = "UGC NET Icon",
                                tint = SaffronGold,
                                modifier = Modifier.size(22.dp)
                            )
                            Text(
                                text = "UGC NET",
                                fontSize = 7.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.White,
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
                                    text = "UGC NET • 2,200 PYQs",
                                    fontSize = 9.5.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Navy900,
                                    maxLines = 1,
                                    softWrap = false
                                )
                            }
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "★ NTA Paper 1 & Paper 2 (100-100 MCQs)",
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
                                "UGC NET (पेपर 1 एवं पेपर 2) — 100-100 प्रश्नों की टेस्ट सीरीज़"
                            else
                                "UGC NET (Paper 1 & Paper 2) — 100-100 MCQ PYQ Series",
                            fontSize = 14.5.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = if (isHi)
                                "1. पेपर 1 (10 यूनिट्स × 100 प्रश्न = 1,000 Q) • 2. पेपर 2 (सभी 12 विषय × 100 प्रश्न = 1,200 Q)"
                            else
                                "1. Paper 1 (10 Units × 100 Qs = 1,000 Q) • 2. Paper 2 (All 12 Subjects × 100 Qs = 1,200 Q)",
                            fontSize = 11.sp,
                            color = Color(0xFFC7D2FE),
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }

                Spacer(modifier = Modifier.width(10.dp))

                TestSeriesCircularProgressRing(
                    progress = uiState.getExamCategoryProgress("ugc_net"),
                    seriesKey = "card_ugc_net",
                    size = 48.dp,
                    strokeWidth = 4.5.dp,
                    accentColor = SaffronGold
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            // ==================== 2. BELOW ICON: PAID TEST SERIES vs FREE TEST SERIES ====================
            ExamPaidFreeDualTabs(
                examKey = "ugc_net",
                examLabelEn = "UGC NET (Paper 1 & Paper 2)",
                examLabelHi = "UGC NET (पेपर 1 एवं पेपर 2)",
                selectedMode = ugcNetMode,
                freeCountBadge = if (isHi) "फ्री टेस्ट: पेपर-1 (1000 Q) + पेपर-2 (1200 Q)" else "Free Tests: Paper-1 (1000 Q) + Paper-2 (1200 Q)",
                paidCountBadge = if (isHi) "पेड टेस्ट सीरीज़ (UGC NET JRF)" else "Paid Test Series (UGC NET JRF)",
                isHi = isHi,
                onSelectMode = { mode ->
                    onSelectTestSeriesMode(mode)
                    if (mode == "FREE" && !uiState.isUgcNetFreeTestSectionExpanded) {
                        onToggleExpandFreeTests()
                    }
                }
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Overall UGC NET Progress Strip (2,200 Qs across Paper 1 & Paper 2)
            ExamOverallProgressStrip(
                examKey = "ugc_net",
                progress = uiState.getUgcNetOverallProgress(),
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
                        text = if (uiState.isUgcNetFreeTestSectionExpanded) {
                            if (isHi) "UGC NET फ्री टेस्ट (पेपर 1 व पेपर 2) ▲" else "UGC NET Free Tests (Paper 1 & 2) ▲"
                        } else {
                            if (isHi) "UGC NET फ्री टेस्ट खोलें (पेपर 1 व 2) ▼" else "Open UGC NET Free Tests (Paper 1 & 2) ▼"
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
                        onClick = onOpenUgcNetHub,
                        colors = ButtonDefaults.buttonColors(containerColor = Navy900),
                        shape = RoundedCornerShape(10.dp),
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 0.dp),
                        modifier = Modifier
                            .height(44.dp)
                            .testTag("home_ugc_net_hub_btn")
                    ) {
                        Text(
                            text = if (isHi) "UGC NET सेक्शन >" else "UGC NET Hub >",
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
            if (ugcNetMode == "PAID") {
                val ugcPaidItems = uiState.customStudyItems.filter {
                    (it.categoryId == "ugc_csir_net" || it.subSectionId.startsWith("ugc_net")) && it.discountedPrice > 0
                }
                ExamPaidTestSeriesPanel(
                    examKey = "ugc_net",
                    examTitleEn = "UGC NET / JRF (Paper 1 & Paper 2 Complete Pro Test Series)",
                    examTitleHi = "UGC NET / JRF (पेपर 1 एवं पेपर 2 संपूर्ण पेड टेस्ट सीरीज़)",
                    paidItems = ugcPaidItems,
                    purchasedItemIds = uiState.purchasedItemIds,
                    isHi = isHi,
                    onBuyOrOpenItem = onBuyOrOpenPaidItem,
                    onAddToCart = onAddPaidItemToCart,
                    onStartPaidMockTest = { onStartSectionTest("ugc_p1_sec_unit1_100") },
                    onSwitchToFreeTests = { onSelectTestSeriesMode("FREE") }
                )
            } else if (uiState.isUgcNetFreeTestSectionExpanded) {
                Spacer(modifier = Modifier.height(12.dp))

                // ==================== WHEN FREE TEST SERIES IS CLICKED: TWO OPTIONS OPEN ====================
                // Option 1: Paper 1 (पेपर वन - 10 Units × 100 Qs) | Option 2: Paper 2 (पेपर टू - 12 Subjects × 100 Qs)
                Text(
                    text = if (isHi)
                        "फ्री टेस्ट सीरीज़ विकल्प चुनें (1. पेपर वन — 10 यूनिट्स • 2. पेपर टू — सभी विषय):"
                    else
                        "Select Free Test Series Option (1. Paper 1 — 10 Units • 2. Paper 2 — All Subjects):",
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
                        .border(1.dp, Color(0xFF4338CA), RoundedCornerShape(12.dp))
                        .padding(4.dp)
                        .testTag("ugc_net_paper_tabs_row"),
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val isPaper1Active = !isPaper2Selected
                    val isPaper2Active = isPaper2Selected

                    // Tab 1: Paper 1 (पेपर वन — 10 Units × 100 MCQs)
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(9.dp))
                            .background(if (isPaper1Active) EdTechProColors.RoyalIndigo else EdTechProColors.UnselectedDarkTabBg)
                            .border(
                                width = if (isPaper1Active) 1.5.dp else 1.dp,
                                color = if (isPaper1Active) SaffronGold else EdTechProColors.UnselectedDarkTabBorder,
                                shape = RoundedCornerShape(9.dp)
                            )
                            .clickable { onSelectPaperTab("PAPER_1") }
                            .padding(horizontal = 8.dp, vertical = 8.dp)
                            .testTag("ugc_net_tab_PAPER_1"),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                ShakuntalamBrandCrestBadge(size = 15.dp, showGlowRing = isPaper1Active)
                                Spacer(modifier = Modifier.width(5.dp))
                                Text(
                                    text = if (isHi) "1. पेपर वन (Paper 1)" else "1. Paper 1 (पेपर वन)",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = if (isPaper1Active) EdTechProColors.ChampagneGold else Color.White,
                                    maxLines = 1,
                                    softWrap = false
                                )
                            }
                            Text(
                                text = if (isHi) "10 यूनिट्स × 100 प्रश्न = 1,000 Q" else "10 Units × 100 MCQs = 1,000 Q",
                                fontSize = 9.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = if (isPaper1Active) Color.White else Color(0xFFCBD5E1),
                                maxLines = 1,
                                softWrap = false
                            )
                        }
                    }

                    // Tab 2: Paper 2 (पेपर टू — All 12 Subjects × 100 MCQs)
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(9.dp))
                            .background(if (isPaper2Active) EdTechProColors.RoyalIndigo else EdTechProColors.UnselectedDarkTabBg)
                            .border(
                                width = if (isPaper2Active) 1.5.dp else 1.dp,
                                color = if (isPaper2Active) SaffronGold else EdTechProColors.UnselectedDarkTabBorder,
                                shape = RoundedCornerShape(9.dp)
                            )
                            .clickable { onSelectPaperTab("PAPER_2") }
                            .padding(horizontal = 8.dp, vertical = 8.dp)
                            .testTag("ugc_net_tab_PAPER_2"),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                ShakuntalamBrandCrestBadge(size = 15.dp, showGlowRing = isPaper2Active)
                                Spacer(modifier = Modifier.width(5.dp))
                                Text(
                                    text = if (isHi) "2. पेपर टू (Paper 2)" else "2. Paper 2 (पेपर टू)",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = if (isPaper2Active) EdTechProColors.ChampagneGold else Color.White,
                                    maxLines = 1,
                                    softWrap = false
                                )
                            }
                            Text(
                                text = if (isHi) "सभी 12 विषय × 100 प्रश्न = 1,200 Q" else "All 12 Subjects × 100 MCQs = 1,200 Q",
                                fontSize = 9.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = if (isPaper2Active) Color.White else Color(0xFFCBD5E1),
                                maxLines = 1,
                                softWrap = false
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Active Paper Syllabus & Marking Banner
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                        .background(if (isPaper2Selected) Color(0xFF3B0764) else Color(0xFF1E1B4B))
                        .border(
                            1.dp,
                            if (isPaper2Selected) Color(0xFFC084FC) else Color(0xFF818CF8),
                            RoundedCornerShape(8.dp)
                        )
                        .padding(horizontal = 10.dp, vertical = 6.dp)
                        .testTag("ugc_net_active_paper_pattern_banner"),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Verified,
                        contentDescription = null,
                        tint = SaffronGold,
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = if (isPaper2Selected) {
                            if (isHi)
                                "UGC NET पेपर 2 (विषय-विशेष) • सभी 12 विषयों के नाम एवं उनके आगे 100-100 PYQ प्रश्न (1,200 MCQs) • +2.0 अंक, 0 नेगेटिव"
                            else
                                "UGC NET Paper 2 (Subject-Specific) • All 12 Subjects with 100-100 PYQ MCQs each (1,200 MCQs) • +2.0 Marks, 0 Negative"
                        } else {
                            if (isHi)
                                "UGC NET पेपर 1 (शिक्षण एवं शोध अभिक्षमता) • सभी 10 यूनिट्स के 100-100 मूल्यवान PYQ प्रश्न (1,000 MCQs) • +2.0 अंक, 0 नेगेटिव"
                            else
                                "UGC NET Paper 1 (Teaching & Research Aptitude) • All 10 Syllabus Units × 100 Valuable PYQ MCQs (1,000 MCQs) • +2.0 Marks, 0 Negative"
                        },
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFFDE68A),
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                // Filter Chips for Active Paper (10 Units for Paper 1 OR 12 Subjects for Paper 2)
                val filterChips = if (isPaper2Selected) {
                    listOf(
                        Triple("ALL", "All 12 Subjects (1,200 Q)", "सभी 12 विषय (1,200 Q)"),
                        Triple("HISTORY", "1. History (100 Q)", "1. इतिहास (100 Q)"),
                        Triple("POL_SCIENCE", "2. Political Sci (100 Q)", "2. राजनीति विज्ञान (100 Q)"),
                        Triple("GEOGRAPHY", "3. Geography (100 Q)", "3. भूगोल (100 Q)"),
                        Triple("ECONOMICS", "4. Economics (100 Q)", "4. अर्थशास्त्र (100 Q)"),
                        Triple("HINDI", "5. Hindi Lit (100 Q)", "5. हिंदी साहित्य (100 Q)"),
                        Triple("ENGLISH", "6. English Lit (100 Q)", "6. अंग्रेज़ी साहित्य (100 Q)"),
                        Triple("COMMERCE", "7. Commerce (100 Q)", "7. वाणिज्य (100 Q)"),
                        Triple("MANAGEMENT", "8. Management (100 Q)", "8. प्रबंधन (100 Q)"),
                        Triple("SOCIOLOGY", "9. Sociology (100 Q)", "9. समाजशास्त्र (100 Q)"),
                        Triple("EDUCATION", "10. Education (100 Q)", "10. शिक्षाशास्त्र (100 Q)"),
                        Triple("COMPUTER_SCI", "11. Computer Sci (100 Q)", "11. कंप्यूटर विज्ञान (100 Q)"),
                        Triple("LAW", "12. Law (100 Q)", "12. विधि / Law (100 Q)")
                    )
                } else {
                    listOf(
                        Triple("ALL", "All 10 Units (1,000 Q)", "सभी 10 यूनिट्स (1,000 Q)"),
                        Triple("UNIT_1", "Unit I: Teaching (100 Q)", "इकाई I: शिक्षण (100 Q)"),
                        Triple("UNIT_2", "Unit II: Research (100 Q)", "इकाई II: शोध (100 Q)"),
                        Triple("UNIT_3", "Unit III: Comprehension (100 Q)", "इकाई III: बोधगम्यता (100 Q)"),
                        Triple("UNIT_4", "Unit IV: Communication (100 Q)", "इकाई IV: संप्रेषण (100 Q)"),
                        Triple("UNIT_5", "Unit V: Math Reasoning (100 Q)", "इकाई V: गणितीय तर्क (100 Q)"),
                        Triple("UNIT_6", "Unit VI: Logical & Pramana (100 Q)", "इकाई VI: तर्क एवं प्रमाण (100 Q)"),
                        Triple("UNIT_7", "Unit VII: Data Interp. (100 Q)", "इकाई VII: आंकड़ा व्याख्या (100 Q)"),
                        Triple("UNIT_8", "Unit VIII: ICT (100 Q)", "इकाई VIII: आईसीटी (100 Q)"),
                        Triple("UNIT_9", "Unit IX: Environment (100 Q)", "इकाई IX: पर्यावरण (100 Q)"),
                        Triple("UNIT_10", "Unit X: Higher Ed (100 Q)", "इकाई X: उच्च शिक्षा (100 Q)")
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    filterChips.forEach { (code, labelEn, labelHi) ->
                        val isChipSelected = selectedSubjectFilter.equals(code, ignoreCase = true)
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .background(
                                    if (isChipSelected) EdTechProColors.RoyalIndigo else EdTechProColors.UnselectedDarkTabBg
                                )
                                .border(
                                    width = if (isChipSelected) 1.5.dp else 1.dp,
                                    color = if (isChipSelected) EdTechProColors.WarmGold else EdTechProColors.UnselectedDarkTabBorder,
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .clickable { onSelectSubjectFilter(code) }
                                .padding(horizontal = 10.dp, vertical = 6.dp)
                                .testTag("ugc_net_subject_tab_$code")
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                ShakuntalamBrandCrestBadge(size = 14.dp, showGlowRing = isChipSelected)
                                Spacer(modifier = Modifier.width(5.dp))
                                Text(
                                    text = if (isHi) labelHi else labelEn,
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

                // Unit / Subject 100-MCQ Row Cards
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    filteredSpecs.forEach { spec ->
                        UgcNetSubjectQuizRowCard(
                            spec = spec,
                            progress = uiState.getSectionProgress(spec.testId, 100),
                            isHi = isHi,
                            rowTestTag = "${sectionRowTagPrefix}${spec.testId}",
                            onClickStart = { onStartSectionTest(spec.testId) }
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun UgcNetSubjectQuizRowCard(
    spec: UgcNetSectionTestSpec,
    progress: SectionProgressInfo,
    isHi: Boolean,
    rowTestTag: String,
    onClickStart: () -> Unit
) {
    val isPaper2 = spec.paperLevel == "PAPER_2"
    val cardBgColor = if (isPaper2) EdTechProColors.ElevatedNavy else Color(0xFF1E293B)
    val borderColor = if (isPaper2) EdTechProColors.ElectricCyan else EdTechProColors.SlateBorder

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(cardBgColor)
            .border(
                width = 1.2.dp,
                color = borderColor,
                shape = RoundedCornerShape(10.dp)
            )
            .clickable { onClickStart() }
            .padding(horizontal = 12.dp, vertical = 9.dp)
            .testTag(rowTestTag),
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
                    .background(Color(spec.badgeColorHex))
                    .border(1.dp, SaffronGold, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "${spec.sectionNumber}",
                    fontSize = 11.5.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Column(modifier = Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(4.dp))
                            .background(Color(0xFF0F172A))
                            .border(0.8.dp, SaffronGold, RoundedCornerShape(4.dp))
                            .padding(horizontal = 5.dp, vertical = 1.dp)
                    ) {
                        Text(
                            text = if (isHi) spec.shortBadgeHi else spec.shortBadgeEn,
                            fontSize = 8.5.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color(0xFFFDE68A),
                            maxLines = 1,
                            softWrap = false
                        )
                    }
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = if (isHi) "100-100 प्रश्न (PYQ)" else "100 PYQ MCQs",
                        fontSize = 8.5.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF86EFAC),
                        maxLines = 1,
                        softWrap = false
                    )
                }
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = if (isHi) spec.titleHi else spec.titleEn,
                    fontSize = 12.5.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = if (isHi) spec.syllabusSummaryHi else spec.syllabusSummaryEn,
                    fontSize = 10.sp,
                    color = Color(0xFFE2E8F0),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "100 PYQ MCQs • 90 Mins • 200 Marks (+2.0 / 0 Negative)",
                    fontSize = 9.5.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFFC7D2FE),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                SectionTestProgressBar(
                    progress = progress,
                    sectionKey = spec.testId,
                    isHi = isHi
                )
            }
        }
        Spacer(modifier = Modifier.width(8.dp))
        Column(horizontalAlignment = Alignment.End) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .background(Color(0xFF0F172A))
                    .border(0.8.dp, Color(0xFF86EFAC), RoundedCornerShape(4.dp))
                    .padding(horizontal = 6.dp, vertical = 1.dp)
            ) {
                Text(
                    text = if (isHi) "100 प्रश्न" else "100 MCQs",
                    fontSize = 8.5.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFF86EFAC),
                    maxLines = 1,
                    softWrap = false
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .background(if (isPaper2) SaffronGold else EmeraldSuccess)
                    .padding(horizontal = 10.dp, vertical = 6.dp)
                    .testTag("start_${spec.testId}")
            ) {
                Text(
                    text = if (isHi) "अटेम्प्ट (100 Q)" else "Start 100-Q",
                    fontSize = 10.5.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = if (isPaper2) Navy900 else Color.White,
                    maxLines = 1,
                    softWrap = false
                )
            }
        }
    }
}
