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
import androidx.compose.material.icons.filled.Biotech
import androidx.compose.material.icons.filled.Quiz
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
import com.example.data.neet.NeetAllSubjectsPyqData
import com.example.data.neet.NeetSectionTestSpec
import com.example.model.StudyItem
import com.example.ui.theme.EmeraldSuccess
import com.example.ui.theme.Navy900
import com.example.ui.theme.SaffronGold
import com.example.viewmodel.SectionProgressInfo
import com.example.viewmodel.ShakuntalamUiState

private val NeetDeepBg = EdTechProColors.DeepRoyalNavy
private val NeetCardRowBg = EdTechProColors.ElevatedNavy
private val NeetAccentTeal = EdTechProColors.RoyalIndigo

/**
 * Dedicated 'NEET (UG) Test Series' Component structured on the same pattern as IIT JEE:
 * 1. Top Header with NEET Icon & Title ("NEET (UG) Medical Entrance — 600 PYQs").
 * 2. Directly underneath: Two primary mode tabs via ExamPaidFreeDualTabs:
 *      - 1. Paid Test Series
 *      - 2. Free Test Series / Free Mock (6 Subjects × 100 Qs = 600 PYQs)
 * 3. Syllabus-wise breakdown into all 6 NEET subjects with 100 PYQ questions per subject:
 *      1. Physics (भौतिक विज्ञान — 100 PYQs)
 *      2. Physical Chemistry (भौतिक रसायन — 100 PYQs)
 *      3. Organic Chemistry (कार्बनिक रसायन — 100 PYQs)
 *      4. Inorganic Chemistry (अकार्बनिक रसायन — 100 PYQs)
 *      5. Biology: Botany (वनस्पति विज्ञान — 100 PYQs)
 *      6. Biology: Zoology (जन्तु विज्ञान — 100 PYQs)
 */
@Composable
fun NeetExamSectionComponent(
    uiState: ShakuntalamUiState,
    isHi: Boolean,
    cardTestTag: String,
    attemptButtonTestTag: String,
    sectionRowTagPrefix: String,
    showHubButton: Boolean,
    onSelectTestSeriesMode: (String) -> Unit,
    onSelectSubjectFilter: (String) -> Unit,
    onToggleExpandFreeTests: () -> Unit,
    onOpenNeetHub: () -> Unit,
    onStartSectionTest: (String) -> Unit,
    onBuyOrOpenPaidItem: (StudyItem) -> Unit,
    onAddPaidItemToCart: (StudyItem) -> Unit,
    modifier: Modifier = Modifier
) {
    val neetMode = uiState.examTestSeriesModeMap["neet"] ?: "FREE"
    val selectedSubjectFilter = uiState.selectedNeetSubjectFilter
    val allSpecs = NeetAllSubjectsPyqData.sectionSpecs

    val filteredSubjectSpecs = when (selectedSubjectFilter.uppercase()) {
        "PHYSICS" -> allSpecs.filter { it.subjectCode == "PHYSICS" }
        "PHYSICAL_CHEM" -> allSpecs.filter { it.subjectCode == "PHYSICAL_CHEM" }
        "ORGANIC_CHEM" -> allSpecs.filter { it.subjectCode == "ORGANIC_CHEM" }
        "INORGANIC_CHEM" -> allSpecs.filter { it.subjectCode == "INORGANIC_CHEM" }
        "BOTANY" -> allSpecs.filter { it.subjectCode == "BOTANY" }
        "ZOOLOGY" -> allSpecs.filter { it.subjectCode == "ZOOLOGY" }
        "BIOLOGY" -> allSpecs.filter { it.subjectGroup == "BIOLOGY" }
        "CHEMISTRY" -> allSpecs.filter { it.subjectGroup == "CHEMISTRY" }
        else -> allSpecs
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .border(2.dp, SaffronGold, RoundedCornerShape(16.dp))
            .testTag(cardTestTag),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = NeetDeepBg),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // ==================== 1. TOP HEADER WITH PROMINENT NEET ICON ====================
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    // Top NEET Icon Badge
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                            .background(Color(0xFF022C22))
                            .border(2.dp, SaffronGold, CircleShape)
                            .testTag("neet_top_icon_badge"),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                imageVector = Icons.Default.Biotech,
                                contentDescription = "NEET Icon",
                                tint = SaffronGold,
                                modifier = Modifier.size(22.dp)
                            )
                            Text(
                                text = "NEET UG",
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
                                    text = "NEET UG • 600 PYQs",
                                    fontSize = 9.5.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Navy900,
                                    maxLines = 1,
                                    softWrap = false
                                )
                            }
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "★ 5-Year NCERT PYQ (2020–2025)",
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
                                "NEET (UG) मेडिकल — सभी 6 विषयों के 100-100 PYQ टेस्ट"
                            else
                                "NEET (UG) Medical — 6 Subjects × 100 PYQ Test Series",
                            fontSize = 14.5.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = if (isHi)
                                "फिजिक्स (100 Q) • फिजिकल/ऑर्गेनिक/इनऑर्गेनिक केमिस्ट्री (3×100 Q) • बॉटनी (100 Q) • जूलॉजी (100 Q)"
                            else
                                "Physics (100 Q) • Physical/Organic/Inorganic Chem (3×100 Q) • Botany (100 Q) • Zoology (100 Q)",
                            fontSize = 11.sp,
                            color = Color(0xFFA7F3D0),
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }

                Spacer(modifier = Modifier.width(10.dp))

                TestSeriesCircularProgressRing(
                    progress = uiState.getExamCategoryProgress("neet"),
                    seriesKey = "card_neet",
                    size = 48.dp,
                    strokeWidth = 4.5.dp,
                    accentColor = SaffronGold
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            // ==================== 2. BELOW ICON: PAID TEST SERIES vs FREE TEST SERIES / FREE MOCK ====================
            ExamPaidFreeDualTabs(
                examKey = "neet",
                examLabelEn = "NEET (UG) Medical Entrance",
                examLabelHi = "NEET (UG) मेडिकल प्रवेश परीक्षा",
                selectedMode = neetMode,
                freeCountBadge = if (isHi) "फ्री मॉक: 6 विषय × 100 Q = 600 PYQs" else "Free Mock: 6 Subjects × 100 Q = 600 PYQs",
                paidCountBadge = if (isHi) "पेड टेस्ट सीरीज़ (NEET NCERT Pro)" else "Paid Test Series (NEET NCERT Pro)",
                isHi = isHi,
                onSelectMode = { mode ->
                    onSelectTestSeriesMode(mode)
                    if (mode == "FREE" && !uiState.isNeetFreeTestSectionExpanded) {
                        onToggleExpandFreeTests()
                    }
                }
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Overall NEET Progress Strip (600 Qs across all 6 subjects)
            ExamOverallProgressStrip(
                examKey = "neet",
                progress = uiState.getNeetOverallProgress(),
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
                        text = if (uiState.isNeetFreeTestSectionExpanded) {
                            if (isHi) "NEET फ्री मॉक टेस्ट (6×100 Q) ▲" else "NEET Free Mock (6×100 Qs) ▲"
                        } else {
                            if (isHi) "NEET फ्री मॉक खोलें (6×100 Q) ▼" else "Open NEET Free Mock (6×100 Qs) ▼"
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
                        onClick = onOpenNeetHub,
                        colors = ButtonDefaults.buttonColors(containerColor = Navy900),
                        shape = RoundedCornerShape(10.dp),
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 0.dp),
                        modifier = Modifier
                            .height(44.dp)
                            .testTag("home_neet_hub_btn")
                    ) {
                        Text(
                            text = if (isHi) "NEET सेक्शन >" else "NEET Hub >",
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
            if (neetMode == "PAID") {
                val neetPaidItems = uiState.customStudyItems.filter {
                    (it.subSectionId == "neet_ug" || it.categoryId == "jee_neet") && it.discountedPrice > 0
                }
                ExamPaidTestSeriesPanel(
                    examKey = "neet",
                    examTitleEn = "NEET (UG) NCERT Line-by-Line & 5-Year PYQ Pro Series",
                    examTitleHi = "NEET (UG) NCERT लाइन-बाय-लाइन एवं 5-वर्षीय PYQ प्रो सीरीज़",
                    paidItems = neetPaidItems,
                    purchasedItemIds = uiState.purchasedItemIds,
                    isHi = isHi,
                    onBuyOrOpenItem = onBuyOrOpenPaidItem,
                    onAddToCart = onAddPaidItemToCart,
                    onStartPaidMockTest = { onStartSectionTest("neet_sec_botany_100") },
                    onSwitchToFreeTests = { onSelectTestSeriesMode("FREE") }
                )
            } else if (uiState.isNeetFreeTestSectionExpanded) {
                Spacer(modifier = Modifier.height(12.dp))

                // 5-Year NEET UG PYQ Pattern Strip
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFF022C22))
                        .border(1.dp, NeetAccentTeal, RoundedCornerShape(8.dp))
                        .padding(horizontal = 10.dp, vertical = 6.dp)
                        .testTag("neet_active_pattern_banner"),
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
                        text = if (isHi)
                            "NTA NEET (UG) स्तर • विगत 5 वर्षों के NCERT PYQ आधारित (6 विषय × 100 प्रश्न = 600 PYQs) • +4.0 / -1.0 अंक"
                        else
                            "NTA NEET (UG) Level • Last 5 Years NCERT PYQ Pattern (6 Subjects × 100 Qs = 600 PYQs) • +4.0 / -1.0 Marks",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFFDE68A),
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                // Syllabus Subject Filter Chips: All (600 Q) | Physics | Physical Chem | Organic Chem | Inorganic Chem | Botany | Zoology
                val subjectFilterTabs = listOf(
                    Triple("ALL", "All 6 Subjects (600 Q)", "सभी 6 विषय (600 Q)"),
                    Triple("PHYSICS", "1. Physics (100 Q)", "1. भौतिक विज्ञान (100 Q)"),
                    Triple("PHYSICAL_CHEM", "2. Physical Chem (100 Q)", "2. भौतिक रसायन (100 Q)"),
                    Triple("ORGANIC_CHEM", "3. Organic Chem (100 Q)", "3. कार्बनिक रसायन (100 Q)"),
                    Triple("INORGANIC_CHEM", "4. Inorganic Chem (100 Q)", "4. अकार्बनिक रसायन (100 Q)"),
                    Triple("BOTANY", "5. Botany (100 Q)", "5. वनस्पति विज्ञान (100 Q)"),
                    Triple("ZOOLOGY", "6. Zoology (100 Q)", "6. जन्तु विज्ञान (100 Q)")
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
                                .testTag("neet_subject_tab_$code")
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

                // Subject-Specific 100-Q Cards for all 6 NEET Subjects
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    filteredSubjectSpecs.forEach { spec ->
                        NeetSubjectQuizRowCard(
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
private fun NeetSubjectQuizRowCard(
    spec: NeetSectionTestSpec,
    progress: SectionProgressInfo,
    isHi: Boolean,
    rowTestTag: String,
    onClickStart: () -> Unit
) {
    val isBiology = spec.subjectGroup == "BIOLOGY"
    val borderColor = if (isBiology) SaffronGold else Color(0xFF34D399)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(NeetCardRowBg)
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
                            .background(Color(0xFF022C22))
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
                        text = "5-Yr NEET NCERT PYQ",
                        fontSize = 8.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFA7F3D0),
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
                    text = "100 PYQ Questions • 90 Mins • 400 Marks (+4.0/-1.0)",
                    fontSize = 9.5.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFFFDE68A),
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
                .background(if (isBiology) SaffronGold else EmeraldSuccess)
                .padding(horizontal = 10.dp, vertical = 6.dp)
                .testTag("start_${spec.testId}")
        ) {
            Text(
                text = if (isHi) "अटेम्प्ट (100 Q)" else "Start 100-Q",
                fontSize = 10.5.sp,
                fontWeight = FontWeight.ExtraBold,
                color = if (isBiology) Navy900 else Color.White,
                maxLines = 1,
                softWrap = false
            )
        }
    }
}
