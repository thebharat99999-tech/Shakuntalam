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
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.Science
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material.icons.filled.WorkspacePremium
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
import com.example.data.iitjee.IitJeeAllSubjectsPyqData
import com.example.data.iitjee.IitJeeSectionTestSpec
import com.example.model.StudyItem
import com.example.ui.theme.EmeraldSuccess
import com.example.ui.theme.Navy900
import com.example.ui.theme.SaffronGold
import com.example.viewmodel.SectionProgressInfo
import com.example.viewmodel.ShakuntalamUiState

private val IitJeeDeepBg = EdTechProColors.DeepRoyalNavy
private val IitJeeMainBlue = EdTechProColors.RoyalIndigo
private val IitJeeAdvCrimson = EdTechProColors.RoyalIndigo

/**
 * Dedicated 'IIT JEE Test Series' Component structured per user requirements:
 * 1. Top Header with IIT JEE Icon & Title ("IIT JEE (Main & Advanced)").
 * 2. Directly underneath: Two primary mode tabs via ExamPaidFreeDualTabs:
 *      - 1. Paid Test Series
 *      - 2. Free Test Series / Free Mock (1000 PYQs)
 * 3. When Free Test Series / Free Mock is clicked:
 *      - Opens two Exam Level tabs:
 *          Tab 1: IIT JEE Main (JEE Main level 5-year PYQ mocks, 5 subjects × 100 Qs = 500 Qs)
 *          Tab 2: IIT JEE Advanced (JEE Advanced level 5-year PYQ mocks, 5 subjects × 100 Qs = 500 Qs)
 *      - Syllabus-wise breakdown into 5 separate subjects (Physics, Physical Chemistry,
 *        Organic Chemistry, Inorganic Chemistry, Mathematics) with 100 questions in each subject.
 */
@Composable
fun IitJeeExamSectionComponent(
    uiState: ShakuntalamUiState,
    isHi: Boolean,
    cardTestTag: String,
    attemptButtonTestTag: String,
    sectionRowTagPrefix: String,
    showHubButton: Boolean,
    onSelectLevelTab: (String) -> Unit,
    onSelectTestSeriesMode: (String) -> Unit,
    onSelectSubjectFilter: (String) -> Unit,
    onToggleExpandFreeTests: () -> Unit,
    onOpenIitJeeHub: () -> Unit,
    onStartSectionTest: (String) -> Unit,
    onBuyOrOpenPaidItem: (StudyItem) -> Unit,
    onAddPaidItemToCart: (StudyItem) -> Unit,
    modifier: Modifier = Modifier
) {
    val iitJeeMode = uiState.examTestSeriesModeMap["iit_jee"] ?: "FREE"
    val selectedLevelTab = uiState.selectedIitJeeLevelTab // "MAIN" or "ADVANCED"
    val isAdvancedLevel = selectedLevelTab.equals("ADVANCED", ignoreCase = true)
    val selectedSubjectFilter = uiState.selectedIitJeeSubjectFilter

    val activeLevelSpecs = if (isAdvancedLevel) {
        IitJeeAllSubjectsPyqData.getAdvancedSectionSpecs()
    } else {
        IitJeeAllSubjectsPyqData.getMainSectionSpecs()
    }

    val filteredSubjectSpecs = when (selectedSubjectFilter.uppercase()) {
        "PHYSICS" -> activeLevelSpecs.filter { it.subjectCode == "PHYSICS" }
        "PHYSICAL_CHEM" -> activeLevelSpecs.filter { it.subjectCode == "PHYSICAL_CHEM" }
        "ORGANIC_CHEM" -> activeLevelSpecs.filter { it.subjectCode == "ORGANIC_CHEM" }
        "INORGANIC_CHEM" -> activeLevelSpecs.filter { it.subjectCode == "INORGANIC_CHEM" }
        "MATHEMATICS" -> activeLevelSpecs.filter { it.subjectCode == "MATHEMATICS" }
        else -> activeLevelSpecs
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .border(2.dp, SaffronGold, RoundedCornerShape(16.dp))
            .testTag(cardTestTag),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = IitJeeDeepBg),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // ==================== 1. TOP HEADER WITH PROMINENT IIT JEE ICON ====================
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    // Top IIT JEE Icon Badge
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                            .background(Color(0xFF1E293B))
                            .border(2.dp, SaffronGold, CircleShape)
                            .testTag("iit_jee_top_icon_badge"),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                imageVector = Icons.Default.Science,
                                contentDescription = "IIT JEE Icon",
                                tint = SaffronGold,
                                modifier = Modifier.size(22.dp)
                            )
                            Text(
                                text = "IIT JEE",
                                fontSize = 7.5.sp,
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
                                    text = "IIT JEE • 1000 PYQs",
                                    fontSize = 9.5.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Navy900,
                                    maxLines = 1,
                                    softWrap = false
                                )
                            }
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "★ 5-Year PYQ Mock (2020–2025)",
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
                                "IIT JEE (Main & Advanced) — 100-100 प्रश्नों की टेस्ट सीरीज़"
                            else
                                "IIT JEE (Main & Advanced) — 5-Yr PYQ Test Series",
                            fontSize = 14.5.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = if (isHi)
                                "1. IIT JEE Main (5×100 Q) • 2. IIT JEE Advanced (5×100 Q) • फिजिक्स, फिजिकल/ऑर्गेनिक/इनऑर्गेनिक केमिस्ट्री एवं मैथमेटिक्स"
                            else
                                "1. IIT JEE Main (5×100 Q) • 2. IIT JEE Advanced (5×100 Q) • Physics, Physical/Organic/Inorganic Chem & Math",
                            fontSize = 11.sp,
                            color = Color(0xFFBAE6FD),
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }

                Spacer(modifier = Modifier.width(10.dp))

                TestSeriesCircularProgressRing(
                    progress = uiState.getExamCategoryProgress("iit_jee"),
                    seriesKey = "card_iit_jee",
                    size = 48.dp,
                    strokeWidth = 4.5.dp,
                    accentColor = SaffronGold
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            // ==================== 2. BELOW ICON: PAID TEST SERIES vs FREE TEST SERIES / FREE MOCK ====================
            ExamPaidFreeDualTabs(
                examKey = "iit_jee",
                examLabelEn = "IIT JEE (Main & Advanced)",
                examLabelHi = "IIT JEE (मेन एवं एडवांस्ड)",
                selectedMode = iitJeeMode,
                freeCountBadge = if (isHi) "फ्री मॉक: Main (500 Q) + Adv (500 Q)" else "Free Mock: Main (500 Q) + Adv (500 Q)",
                paidCountBadge = if (isHi) "पेड टेस्ट सीरीज़ (JEE Main + Adv)" else "Paid Test Series (JEE Main + Adv)",
                isHi = isHi,
                onSelectMode = { mode ->
                    onSelectTestSeriesMode(mode)
                    if (mode == "FREE" && !uiState.isIitJeeFreeTestSectionExpanded) {
                        onToggleExpandFreeTests()
                    }
                }
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Overall IIT JEE Progress Strip (1000 Qs across Main & Advanced)
            ExamOverallProgressStrip(
                examKey = "iit_jee",
                progress = uiState.getIitJeeOverallProgress(),
                isHi = isHi
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Expand / Collapse Free Test Series / Free Mock Button & Hub Button
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
                        text = if (uiState.isIitJeeFreeTestSectionExpanded) {
                            if (isHi) "IIT JEE फ्री मॉक टेस्ट (Main & Adv) ▲" else "IIT JEE Free Mock (Main & Adv) ▲"
                        } else {
                            if (isHi) "IIT JEE फ्री मॉक खोलें (Main & Adv) ▼" else "Open IIT JEE Free Mock (Main & Adv) ▼"
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
                        onClick = onOpenIitJeeHub,
                        colors = ButtonDefaults.buttonColors(containerColor = Navy900),
                        shape = RoundedCornerShape(10.dp),
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 0.dp),
                        modifier = Modifier
                            .height(44.dp)
                            .testTag("home_iit_jee_hub_btn")
                    ) {
                        Text(
                            text = if (isHi) "IIT JEE सेक्शन >" else "IIT JEE Hub >",
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
            if (iitJeeMode == "PAID") {
                val jeePaidItems = uiState.customStudyItems.filter {
                    (it.categoryId == "jee_neet" || it.subSectionId == "iit_jee") && it.discountedPrice > 0
                }
                ExamPaidTestSeriesPanel(
                    examKey = "iit_jee",
                    examTitleEn = "IIT JEE (Main & Advanced 5-Year PYQ Pro Series)",
                    examTitleHi = "IIT JEE (मेन एवं एडवांस्ड 5-वर्षीय PYQ प्रो सीरीज़)",
                    paidItems = jeePaidItems,
                    purchasedItemIds = uiState.purchasedItemIds,
                    isHi = isHi,
                    onBuyOrOpenItem = onBuyOrOpenPaidItem,
                    onAddToCart = onAddPaidItemToCart,
                    onStartPaidMockTest = { onStartSectionTest("jee_main_sec_physics_100") },
                    onSwitchToFreeTests = { onSelectTestSeriesMode("FREE") }
                )
            } else if (uiState.isIitJeeFreeTestSectionExpanded) {
                Spacer(modifier = Modifier.height(12.dp))

                // ==================== WHEN FREE IS CLICKED: TWO EXAM TABS OPEN ====================
                // Option 1: IIT JEE Main | Option 2: IIT JEE Advanced
                Text(
                    text = if (isHi)
                        "फ्री मॉक परीक्षा स्तर चुनें (1. IIT JEE Main • 2. IIT JEE Advanced):"
                    else
                        "Select Free Mock Exam Level (1. IIT JEE Main • 2. IIT JEE Advanced):",
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
                        .background(Color(0xFF0A1120))
                        .border(1.dp, Color(0xFF334155), RoundedCornerShape(12.dp))
                        .padding(4.dp)
                        .testTag("iit_jee_level_tabs_row"),
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val isMainSelected = !isAdvancedLevel
                    val isAdvSelected = isAdvancedLevel

                    // Tab 1: IIT JEE Main
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(9.dp))
                            .background(if (isMainSelected) EdTechProColors.RoyalIndigo else EdTechProColors.UnselectedDarkTabBg)
                            .border(
                                width = if (isMainSelected) 1.5.dp else 1.dp,
                                color = if (isMainSelected) SaffronGold else EdTechProColors.UnselectedDarkTabBorder,
                                shape = RoundedCornerShape(9.dp)
                            )
                            .clickable { onSelectLevelTab("MAIN") }
                            .padding(horizontal = 8.dp, vertical = 8.dp)
                            .testTag("iit_jee_tab_MAIN"),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                ShakuntalamBrandCrestBadge(size = 15.dp, showGlowRing = isMainSelected)
                                Spacer(modifier = Modifier.width(5.dp))
                                Text(
                                    text = "1. IIT JEE Main",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = if (isMainSelected) EdTechProColors.ChampagneGold else Color.White,
                                    maxLines = 1,
                                    softWrap = false
                                )
                            }
                            Text(
                                text = if (isHi) "JEE Main स्तर • 5×100 PYQs" else "JEE Main Level • 5×100 PYQs",
                                fontSize = 9.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = if (isMainSelected) Color.White else Color(0xFFCBD5E1),
                                maxLines = 1,
                                softWrap = false
                            )
                        }
                    }

                    // Tab 2: IIT JEE Advanced
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(9.dp))
                            .background(if (isAdvSelected) EdTechProColors.RoyalIndigo else EdTechProColors.UnselectedDarkTabBg)
                            .border(
                                width = if (isAdvSelected) 1.5.dp else 1.dp,
                                color = if (isAdvSelected) SaffronGold else EdTechProColors.UnselectedDarkTabBorder,
                                shape = RoundedCornerShape(9.dp)
                            )
                            .clickable { onSelectLevelTab("ADVANCED") }
                            .padding(horizontal = 8.dp, vertical = 8.dp)
                            .testTag("iit_jee_tab_ADVANCED"),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                ShakuntalamBrandCrestBadge(size = 15.dp, showGlowRing = isAdvSelected)
                                Spacer(modifier = Modifier.width(5.dp))
                                Text(
                                    text = "2. IIT JEE Advanced",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = if (isAdvSelected) EdTechProColors.ChampagneGold else Color.White,
                                    maxLines = 1,
                                    softWrap = false
                                )
                            }
                            Text(
                                text = if (isHi) "JEE Adv स्तर • 5×100 PYQs" else "JEE Adv Level • 5×100 PYQs",
                                fontSize = 9.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = if (isAdvSelected) Color.White else Color(0xFFCBD5E1),
                                maxLines = 1,
                                softWrap = false
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Active Level 5-Year PYQ Pattern Strip
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                        .background(if (isAdvancedLevel) Color(0xFF450A0A) else Color(0xFF1E3A8A))
                        .border(
                            1.dp,
                            if (isAdvancedLevel) Color(0xFFF87171) else Color(0xFF60A5FA),
                            RoundedCornerShape(8.dp)
                        )
                        .padding(horizontal = 10.dp, vertical = 6.dp)
                        .testTag("iit_jee_active_level_pattern_banner"),
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
                        text = if (isAdvancedLevel) {
                            if (isHi)
                                "IIT JEE Advanced स्तर • विगत 5 वर्षों के PYQ आधारित (5 विषय × 100 प्रश्न = 500 Adv PYQs) • +4.0 / -1.0 अंक"
                            else
                                "IIT JEE Advanced Level • Last 5 Years PYQ Pattern (5 Subjects × 100 Qs = 500 Adv PYQs) • +4.0 / -1.0 Marks"
                        } else {
                            if (isHi)
                                "IIT JEE Main स्तर • विगत 5 वर्षों के NTA PYQ आधारित (5 विषय × 100 प्रश्न = 500 Main PYQs) • +4.0 / -1.0 अंक"
                            else
                                "IIT JEE Main Level • Last 5 Years NTA PYQ Pattern (5 Subjects × 100 Qs = 500 Main PYQs) • +4.0 / -1.0 Marks"
                        },
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFFDE68A),
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                // Syllabus Subject Filter Chips: All (500 Q) | Physics | Physical Chem | Organic Chem | Inorganic Chem | Mathematics
                val subjectFilterTabs = listOf(
                    Triple("ALL", "All 5 Subjects (500 Q)", "सभी 5 विषय (500 Q)"),
                    Triple("PHYSICS", "1. Physics (100 Q)", "1. भौतिकी (100 Q)"),
                    Triple("PHYSICAL_CHEM", "2. Physical Chem (100 Q)", "2. भौतिक रसायन (100 Q)"),
                    Triple("ORGANIC_CHEM", "3. Organic Chem (100 Q)", "3. कार्बनिक रसायन (100 Q)"),
                    Triple("INORGANIC_CHEM", "4. Inorganic Chem (100 Q)", "4. अकार्बनिक रसायन (100 Q)"),
                    Triple("MATHEMATICS", "5. Mathematics (100 Q)", "5. गणित (100 Q)")
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    subjectFilterTabs.forEach { (code, labelEn, labelHi) ->
                        val isFilterSelected = selectedSubjectFilter.equals(code, ignoreCase = true)
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .background(
                                    if (isFilterSelected) EdTechProColors.RoyalIndigo else EdTechProColors.UnselectedDarkTabBg
                                )
                                .border(
                                    width = if (isFilterSelected) 1.5.dp else 1.dp,
                                    color = if (isFilterSelected) EdTechProColors.WarmGold else EdTechProColors.UnselectedDarkTabBorder,
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .clickable { onSelectSubjectFilter(code) }
                                .padding(horizontal = 10.dp, vertical = 6.dp)
                                .testTag("iit_jee_subject_tab_$code")
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                ShakuntalamBrandCrestBadge(size = 14.dp, showGlowRing = isFilterSelected)
                                Spacer(modifier = Modifier.width(5.dp))
                                Text(
                                    text = if (isHi) labelHi else labelEn,
                                    fontSize = 10.5.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = if (isFilterSelected) EdTechProColors.ChampagneGold else Color.White,
                                    maxLines = 1,
                                    softWrap = false
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                // Subject-Specific 100-Q Cards for the Active Level (IIT JEE Main or IIT JEE Advanced)
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    filteredSubjectSpecs.forEach { spec ->
                        IitJeeSubjectQuizRowCard(
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
private fun IitJeeSubjectQuizRowCard(
    spec: IitJeeSectionTestSpec,
    progress: SectionProgressInfo,
    isHi: Boolean,
    rowTestTag: String,
    onClickStart: () -> Unit
) {
    val isAdvanced = spec.examLevel == "ADVANCED"
    val durationMins = if (isAdvanced) 120 else 90
    val cardBgColor = if (isAdvanced) Color(0xFF2A1215) else Color(0xFF172554)
    val borderColor = if (isAdvanced) Color(0xFFF87171) else Color(0xFF60A5FA)

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
                    .background(SaffronGold),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "${spec.sectionNumber}",
                    fontSize = 11.5.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Navy900
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
                        text = if (isAdvanced) "5-Yr JEE Adv PYQ" else "5-Yr JEE Main PYQ",
                        fontSize = 8.5.sp,
                        fontWeight = FontWeight.Bold,
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
                    text = "100 PYQ Questions • $durationMins Mins • 400 Marks (+4.0/-1.0)",
                    fontSize = 9.5.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFFBAE6FD),
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
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(6.dp))
                .background(if (isAdvanced) SaffronGold else EmeraldSuccess)
                .padding(horizontal = 10.dp, vertical = 6.dp)
                .testTag("start_${spec.testId}")
        ) {
            Text(
                text = if (isHi) "अटेम्प्ट (100 Q)" else "Start 100-Q",
                fontSize = 10.5.sp,
                fontWeight = FontWeight.ExtraBold,
                color = if (isAdvanced) Navy900 else Color.White,
                maxLines = 1,
                softWrap = false
            )
        }
    }
}
