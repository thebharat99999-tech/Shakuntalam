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
import com.example.model.StudyItem
import com.example.ui.theme.EmeraldSuccess
import com.example.ui.theme.Navy900
import com.example.ui.theme.SaffronGold
import com.example.viewmodel.ShakuntalamUiState

data class SscExamTabSpec(
    val code: String,
    val titleEn: String,
    val titleHi: String,
    val subtitleEn: String,
    val subtitleHi: String,
    val patternBannerEn: String,
    val patternBannerHi: String
)

data class SscSubjectQuizCardSpec(
    val orderNumber: Int,
    val id: String,
    val sectionId: String,
    val pillarGroup: String, // "GS", "REASONING", "MATH", "ENGLISH"
    val isGsSection: Boolean,
    val shortBadgeEn: String,
    val shortBadgeHi: String,
    val titleEn: String,
    val titleHi: String,
    val subtitleEn: String,
    val subtitleHi: String,
    val questionCount: Int = 100
)

object SscExamSectionCatalog {
    val examTabs: List<SscExamTabSpec> = listOf(
        SscExamTabSpec(
            code = "CGL",
            titleEn = "SSC CGL",
            titleHi = "SSC CGL",
            subtitleEn = "Tier-I & II Graduate",
            subtitleHi = "टियर-I एवं II स्नातक",
            patternBannerEn = "SSC CGL (Combined Graduate Level) • Last 5 Years TCS PYQ Pattern • +2.0 / -0.50 Marks",
            patternBannerHi = "SSC CGL (संयुक्त स्नातक स्तर) • पिछले 5 वर्षों के TCS PYQ प्रश्न • +2.0 / -0.50 अंक"
        ),
        SscExamTabSpec(
            code = "CHSL",
            titleEn = "SSC CHSL",
            titleHi = "SSC CHSL",
            subtitleEn = "10+2 LDC / DEO CBT",
            subtitleHi = "10+2 एलडीसी / डीईओ",
            patternBannerEn = "SSC CHSL (Combined Higher Secondary 10+2) • Last 5 Years TCS PYQ Pattern • +2.0 / -0.50 Marks",
            patternBannerHi = "SSC CHSL (10+2 उच्चतर माध्यमिक स्तर) • पिछले 5 वर्षों के TCS PYQ प्रश्न • +2.0 / -0.50 अंक"
        ),
        SscExamTabSpec(
            code = "CPO",
            titleEn = "SSC CPO",
            titleHi = "SSC CPO",
            subtitleEn = "SI Delhi Police & CAPF",
            subtitleHi = "SI दिल्ली पुलिस व CAPF",
            patternBannerEn = "SSC CPO (Sub-Inspector in Delhi Police & CAPFs) • Last 5 Years TCS PYQ Pattern • +2.0 / -0.50 Marks",
            patternBannerHi = "SSC CPO (दिल्ली पुलिस एवं CAPF सब-इंस्पेक्टर) • पिछले 5 वर्षों के TCS PYQ प्रश्न • +2.0 / -0.50 अंक"
        )
    )

    val subjectQuizSpecs: List<SscSubjectQuizCardSpec> = listOf(
        SscSubjectQuizCardSpec(
            orderNumber = 1,
            id = "ssc_gs_history",
            sectionId = "ssc_sec_history_100",
            pillarGroup = "GS",
            isGsSection = true,
            shortBadgeEn = "GS • History",
            shortBadgeHi = "जीएस • इतिहास",
            titleEn = "1. GS: History & Culture (100 Qs)",
            titleHi = "1. जीएस: इतिहास एवं कला-संस्कृति (100 प्रश्न)",
            subtitleEn = "IVC, Buddhism, Maurya, Gupta, Sultanate, Mughal, 1857, INC & Classical Dances • 100 PYQs",
            subtitleHi = "सिंधु सभ्यता, मौर्य, गुप्त, सल्तनत, मुगल, 1857, कांग्रेस एवं शास्त्रीय नृत्य • 100 PYQ प्रश्न",
            questionCount = 100
        ),
        SscSubjectQuizCardSpec(
            orderNumber = 2,
            id = "ssc_gs_polity",
            sectionId = "ssc_sec_polity_100",
            pillarGroup = "GS",
            isGsSection = true,
            shortBadgeEn = "GS • Polity",
            shortBadgeHi = "जीएस • पॉलिटी",
            titleEn = "2. GS: Polity & Constitution (100 Qs)",
            titleHi = "2. जीएस: राजव्यवस्था एवं संविधान (100 प्रश्न)",
            subtitleEn = "Sources, Schedules, FRs, DPSP, Duties, President, Parliament, SC & Amendments • 100 PYQs",
            subtitleHi = "संविधान के स्रोत, अनुसूचियाँ, मूल अधिकार, नीति निदेशक तत्व, राष्ट्रपति, संसद एवं संशोधन • 100 प्रश्न",
            questionCount = 100
        ),
        SscSubjectQuizCardSpec(
            orderNumber = 3,
            id = "ssc_gs_geography",
            sectionId = "ssc_sec_geography_100",
            pillarGroup = "GS",
            isGsSection = true,
            shortBadgeEn = "GS • Geography",
            shortBadgeHi = "जीएस • भूगोल",
            titleEn = "3. GS: Indian & World Geography (100 Qs)",
            titleHi = "3. जीएस: भारत एवं विश्व का भूगोल (100 प्रश्न)",
            subtitleEn = "Himalayan Passes, Rivers, Dams, Soils, Monsoon, Atmosphere & Census 2011 • 100 PYQs",
            subtitleHi = "हिमालयी दर्रे, नदियाँ, बहुउद्देशीय बांध, मृदा, मानसून, वायुमंडल एवं जनगणना 2011 • 100 प्रश्न",
            questionCount = 100
        ),
        SscSubjectQuizCardSpec(
            orderNumber = 4,
            id = "ssc_gs_environment",
            sectionId = "ssc_sec_environment_100",
            pillarGroup = "GS",
            isGsSection = true,
            shortBadgeEn = "GS • Environment",
            shortBadgeHi = "जीएस • पर्यावरण",
            titleEn = "4. GS: Environment & Ecology (100 Qs)",
            titleHi = "4. जीएस: पर्यावरण एवं पारिस्थितिकी (100 प्रश्न)",
            subtitleEn = "Ecosystem, 10% Law, National Parks, Biosphere, Ramsar Sites, Protocols & Pollution • 100 PYQs",
            subtitleHi = "पारिस्थितिकी तंत्र, 10% नियम, राष्ट्रीय उद्यान, रामसर स्थल, प्रोटोकॉल एवं प्रदूषण • 100 प्रश्न",
            questionCount = 100
        ),
        SscSubjectQuizCardSpec(
            orderNumber = 5,
            id = "ssc_gs_economics",
            sectionId = "ssc_sec_economics_100",
            pillarGroup = "GS",
            isGsSection = true,
            shortBadgeEn = "GS • Economics",
            shortBadgeHi = "जीएस • इकोनॉमिक्स",
            titleEn = "5. GS: Economics & 5-Year Plans (100 Qs)",
            titleHi = "5. जीएस: अर्थव्यवस्था एवं पंचवर्षीय योजनाएं (100 प्रश्न)",
            subtitleEn = "Five-Year Plans (1st–12th), GDP/GNP/NNP, RBI Monetary Policy, Curves, Budget & GST • 100 PYQs",
            subtitleHi = "पंचवर्षीय योजनाएँ (1–12वीं), राष्ट्रीय आय, RBI मौद्रिक नीति, आर्थिक वक्र, बजट एवं GST • 100 प्रश्न",
            questionCount = 100
        ),
        SscSubjectQuizCardSpec(
            orderNumber = 6,
            id = "ssc_reasoning",
            sectionId = "ssc_sec_reasoning_100",
            pillarGroup = "REASONING",
            isGsSection = false,
            shortBadgeEn = "Reasoning • 100 Qs",
            shortBadgeHi = "रीजनिंग • 100 प्रश्न",
            titleEn = "6. General Intelligence & Reasoning (100 Qs)",
            titleHi = "6. रीजनिंग / तर्कशक्ति (Reasoning • 100 प्रश्न)",
            subtitleEn = "Number Series, Coding-Decoding, Syllogism, Blood Relations, Dice, BODMAS & Figure Counting • 100 PYQs",
            subtitleHi = "श्रृंखला, कोडिंग-डिकोडिंग, न्याय निगमन, रक्त संबंध, पासा, BODMAS एवं आकृति गणना • 100 प्रश्न",
            questionCount = 100
        ),
        SscSubjectQuizCardSpec(
            orderNumber = 7,
            id = "ssc_mathematics",
            sectionId = "ssc_sec_mathematics_100",
            pillarGroup = "MATH",
            isGsSection = false,
            shortBadgeEn = "Math • 100 Qs",
            shortBadgeHi = "मैथमेटिक्स • 100 प्रश्न",
            titleEn = "7. Quantitative Aptitude / Mathematics (100 Qs)",
            titleHi = "7. मैथमेटिक्स / संख्यात्मक अभियोग्यता (Mathematics • 100 प्रश्न)",
            subtitleEn = "Percentage, Profit-Loss, SI/CI, Time & Work, Algebra, Geometry, Trigonometry, Mensuration & DI • 100 PYQs",
            subtitleHi = "प्रतिशत, लाभ-हानि, ब्याज, समय-कार्य, बीजगणित, ज्यामिति, त्रिकोणमिति, क्षेत्रमिति एवं DI • 100 प्रश्न",
            questionCount = 100
        ),
        SscSubjectQuizCardSpec(
            orderNumber = 8,
            id = "ssc_english",
            sectionId = "ssc_sec_english_100",
            pillarGroup = "ENGLISH",
            isGsSection = false,
            shortBadgeEn = "English • 100 Qs",
            shortBadgeHi = "इंग्लिश • 100 प्रश्न",
            titleEn = "8. English Language & Comprehension (100 Qs)",
            titleHi = "8. इंग्लिश लैंग्वेज एवं कॉम्प्रिहेंशन (English • 100 प्रश्न)",
            subtitleEn = "Error Spotting, Voice & Narration, One-Word Substitution, Idioms, Synonyms/Antonyms & Cloze • 100 PYQs",
            subtitleHi = "एरर स्पॉटिंग, एक्टिव-पैसिव, नरेशन, वन-वर्ड सब्स्टीट्यूशन, मुहावरे, पर्यायवाची एवं विलोम • 100 प्रश्न",
            questionCount = 100
        )
    )
}

/**
 * Dedicated 'SSC Exam Section' Component featuring:
 *  1. Tabbed interface for SSC CGL, SSC CHSL, and SSC CPO.
 *  2. 'Free' and 'Paid' test series toggles.
 *  3. 4-Pillar Test Progress Indicator (GS, Reasoning, Math, English).
 *  4. Subject-specific quiz structure for GS (History, Polity, Geography, Environment, Economics),
 *     Reasoning, Math, and English, each with 100 previous-year pattern questions.
 */
@Composable
fun SscExamSectionComponent(
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
    onOpenSscHub: () -> Unit,
    onStartSectionTest: (String) -> Unit,
    onBuyOrOpenPaidItem: (StudyItem) -> Unit,
    onAddPaidItemToCart: (StudyItem) -> Unit,
    modifier: Modifier = Modifier
) {
    val sscMode = uiState.examTestSeriesModeMap["ssc"] ?: "FREE"
    val selectedExamTabCode = uiState.selectedSscExamTab
    val activeExamSpec = SscExamSectionCatalog.examTabs.firstOrNull {
        it.code.equals(selectedExamTabCode, ignoreCase = true)
    } ?: SscExamSectionCatalog.examTabs.first()

    val selectedSubjectFilter = uiState.selectedSscSubjectFilter
    val allSubjectSpecs = SscExamSectionCatalog.subjectQuizSpecs
    val filteredSubjectSpecs = when (selectedSubjectFilter.uppercase()) {
        "GS" -> allSubjectSpecs.filter { it.pillarGroup == "GS" }
        "REASONING" -> allSubjectSpecs.filter { it.pillarGroup == "REASONING" }
        "MATH" -> allSubjectSpecs.filter { it.pillarGroup == "MATH" }
        "ENGLISH" -> allSubjectSpecs.filter { it.pillarGroup == "ENGLISH" }
        else -> allSubjectSpecs
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .border(2.dp, SaffronGold, RoundedCornerShape(16.dp))
            .testTag(cardTestTag),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = EdTechProColors.DeepRoyalNavy),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Top Header Badge & Title
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
                                text = "SSC CGL / CHSL / CPO • 800 PYQs",
                                fontSize = 9.5.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Navy900,
                                maxLines = 1,
                                softWrap = false
                            )
                        }
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "★ GS (5×100 Q) + Reasoning + Math + English",
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
                            "SSC CGL / CHSL / CPO — 100-100 प्रश्नों की टेस्ट सीरीज़"
                        else
                            "SSC CGL / CHSL / CPO — 8 Sections × 100 PYQs Test Series",
                        fontSize = 14.5.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = if (isHi)
                            "जीएस (इतिहास, पॉलिटी, भूगोल, पर्यावरण, इकोनॉमिक्स: 100-100 Q) • रीजनिंग (100 Q) • मैथमेटिक्स (100 Q) • इंग्लिश (100 Q)"
                        else
                            "GS (History, Polity, Geography, Environment, Economics: 100 Qs Each) • Reasoning (100 Q) • Math (100 Q) • English (100 Q)",
                        fontSize = 11.sp,
                        color = Color(0xFFC7D2FE),
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Spacer(modifier = Modifier.width(10.dp))

                TestSeriesCircularProgressRing(
                    progress = uiState.getExamCategoryProgress("ssc"),
                    seriesKey = "card_ssc",
                    size = 48.dp,
                    strokeWidth = 4.5.dp,
                    accentColor = SaffronGold
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            // 1. Tabbed Interface for SSC CGL, SSC CHSL, and SSC CPO
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFF0F172A))
                    .border(1.dp, Color(0xFF3730A3), RoundedCornerShape(12.dp))
                    .padding(4.dp)
                    .testTag("ssc_exam_tabs_row"),
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                SscExamSectionCatalog.examTabs.forEach { tabSpec ->
                    val isSelected = tabSpec.code.equals(activeExamSpec.code, ignoreCase = true)
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(9.dp))
                            .background(if (isSelected) EdTechProColors.RoyalIndigo else EdTechProColors.UnselectedDarkTabBg)
                            .border(
                                width = if (isSelected) 1.5.dp else 1.dp,
                                color = if (isSelected) EdTechProColors.WarmGold else EdTechProColors.UnselectedDarkTabBorder,
                                shape = RoundedCornerShape(9.dp)
                            )
                            .clickable { onSelectExamTab(tabSpec.code) }
                            .padding(horizontal = 6.dp, vertical = 7.dp)
                            .testTag("ssc_exam_tab_${tabSpec.code}"),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                ShakuntalamBrandCrestBadge(
                                    size = 15.dp,
                                    showGlowRing = isSelected
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = if (isHi) tabSpec.titleHi else tabSpec.titleEn,
                                    fontSize = 11.5.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = if (isSelected) EdTechProColors.ChampagneGold else Color.White,
                                    maxLines = 1,
                                    softWrap = false,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                            Text(
                                text = if (isHi) tabSpec.subtitleHi else tabSpec.subtitleEn,
                                fontSize = 8.5.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = if (isSelected) Color.White else Color(0xFFCBD5E1),
                                maxLines = 1,
                                softWrap = false,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(6.dp))

            // Active Exam Tier Pattern Strip
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFF312E81))
                    .border(1.dp, Color(0xFF6366F1), RoundedCornerShape(8.dp))
                    .padding(horizontal = 10.dp, vertical = 5.dp)
                    .testTag("ssc_active_exam_pattern_banner"),
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
                    text = if (isHi) activeExamSpec.patternBannerHi else activeExamSpec.patternBannerEn,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFFDE68A),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            // 2. 'Free' and 'Paid' Test Toggles
            ExamPaidFreeDualTabs(
                examKey = "ssc",
                examLabelEn = "${activeExamSpec.titleEn} (CGL / CHSL / CPO)",
                examLabelHi = "${activeExamSpec.titleHi} (CGL / CHSL / CPO)",
                selectedMode = sscMode,
                freeCountBadge = if (isHi) "8 सेक्शन × 100 Q = 800 फ्री PYQs" else "8 Sections × 100 Q = 800 Free PYQs",
                paidCountBadge = if (isHi) "50 फुल-लेंथ TCS मॉक टेस्ट" else "50 Full-Length TCS Mocks",
                isHi = isHi,
                onSelectMode = onSelectTestSeriesMode
            )

            Spacer(modifier = Modifier.height(10.dp))

            // 3. 4-Pillar Test Progress Dashboard: GS • Reasoning • Math • English
            CoreFourPillarsProgressDashboard(
                uiState = uiState,
                isHi = isHi,
                onSelectPillar = { sectionKey -> onStartSectionTest(sectionKey) }
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Expand / Collapse Free Test Series & Hub Actions
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
                        text = if (uiState.isSscFreeTestSectionExpanded) {
                            if (isHi) "${activeExamSpec.titleHi} फ्री टेस्ट (8×100 Q) ▲" else "${activeExamSpec.titleEn} Free Test (8×100 Qs) ▲"
                        } else {
                            if (isHi) "${activeExamSpec.titleHi} अटेम्प्ट फ्री टेस्ट (8×100 Q) ▼" else "${activeExamSpec.titleEn} Attempt Free Test ▼"
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
                        onClick = onOpenSscHub,
                        colors = ButtonDefaults.buttonColors(containerColor = Navy900),
                        shape = RoundedCornerShape(10.dp),
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 0.dp),
                        modifier = Modifier
                            .height(44.dp)
                            .testTag("home_ssc_hub_btn")
                    ) {
                        Text(
                            text = if (isHi) "SSC सेक्शन >" else "SSC Hub >",
                            fontSize = 11.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = SaffronGold,
                            maxLines = 1,
                            softWrap = false
                        )
                    }
                }
            }

            // 4. Paid vs Free Test Series Content Area
            if (sscMode == "PAID") {
                val sscPaidItems = uiState.customStudyItems.filter {
                    it.categoryId == "ssc" && it.discountedPrice > 0
                }
                ExamPaidTestSeriesPanel(
                    examKey = "ssc",
                    examTitleEn = "${activeExamSpec.titleEn} (Tier-I & Tier-II TCS Pattern)",
                    examTitleHi = "${activeExamSpec.titleHi} (टियर-I एवं टियर-II TCS पैटर्न)",
                    paidItems = sscPaidItems,
                    purchasedItemIds = uiState.purchasedItemIds,
                    isHi = isHi,
                    onBuyOrOpenItem = onBuyOrOpenPaidItem,
                    onAddToCart = onAddPaidItemToCart,
                    onStartPaidMockTest = { onStartSectionTest("ssc_gs_history") },
                    onSwitchToFreeTests = { onSelectTestSeriesMode("FREE") }
                )
            } else if (uiState.isSscFreeTestSectionExpanded) {
                Spacer(modifier = Modifier.height(12.dp))

                // Subject Pillar Filter Chips: All (800 Q) | GS (5×100 Q) | Reasoning (100 Q) | Math (100 Q) | English (100 Q)
                val subjectFilterTabs = listOf(
                    Triple("ALL", "All Subjects (800 Q)", "सभी विषय (800 Q)"),
                    Triple("GS", "1. GS (5×100 Q)", "1. जीएस (5×100 Q)"),
                    Triple("REASONING", "2. Reasoning (100 Q)", "2. रीजनिंग (100 Q)"),
                    Triple("MATH", "3. Math (100 Q)", "3. मैथमेटिक्स (100 Q)"),
                    Triple("ENGLISH", "4. English (100 Q)", "4. इंग्लिश (100 Q)")
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
                                .testTag("ssc_subject_tab_$code")
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

                // Subject-Specific Quiz Cards
                val gsSpecs = filteredSubjectSpecs.filter { it.isGsSection }
                val nonGsSpecs = filteredSubjectSpecs.filter { !it.isGsSection }

                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    if (gsSpecs.isNotEmpty()) {
                        Text(
                            text = if (isHi)
                                "भाग A: ${activeExamSpec.titleHi} जीएस (General Studies) — इतिहास, पॉलिटी, भूगोल, पर्यावरण, इकोनॉमिक्स (100-100 प्रश्न)"
                            else
                                "Part A: ${activeExamSpec.titleEn} General Studies (GS) — History, Polity, Geography, Environment, Economics (100 Qs Each)",
                            fontSize = 11.5.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color(0xFFFDE68A),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.padding(bottom = 2.dp)
                        )

                        gsSpecs.forEach { section ->
                            SscSubjectQuizRowCard(
                                section = section,
                                activeExamLabel = if (isHi) activeExamSpec.titleHi else activeExamSpec.titleEn,
                                progress = uiState.getSectionProgress(section.sectionId, section.questionCount),
                                isHi = isHi,
                                rowTestTag = "${sectionRowTagPrefix}${section.sectionId}",
                                onClickStart = { onStartSectionTest(section.sectionId) }
                            )
                        }
                    }

                    if (nonGsSpecs.isNotEmpty()) {
                        if (gsSpecs.isNotEmpty()) {
                            Spacer(modifier = Modifier.height(4.dp))
                        }
                        Text(
                            text = if (isHi)
                                "भाग B: ${activeExamSpec.titleHi} रीजनिंग, मैथमेटिक्स एवं इंग्लिश — 100-100 प्रश्न (TCS PYQs)"
                            else
                                "Part B: ${activeExamSpec.titleEn} Reasoning, Math & English — 100 Questions Each (TCS PYQs)",
                            fontSize = 11.5.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color(0xFFFDE68A),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.padding(bottom = 2.dp)
                        )

                        nonGsSpecs.forEach { section ->
                            SscSubjectQuizRowCard(
                                section = section,
                                activeExamLabel = if (isHi) activeExamSpec.titleHi else activeExamSpec.titleEn,
                                progress = uiState.getSectionProgress(section.sectionId, section.questionCount),
                                isHi = isHi,
                                rowTestTag = "${sectionRowTagPrefix}${section.sectionId}",
                                onClickStart = { onStartSectionTest(section.sectionId) }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun SscSubjectQuizRowCard(
    section: SscSubjectQuizCardSpec,
    activeExamLabel: String,
    progress: com.example.viewmodel.SectionProgressInfo,
    isHi: Boolean,
    rowTestTag: String,
    onClickStart: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(if (section.isGsSection) Color(0xFF312E81) else Color(0xFF0F172A))
            .border(
                width = if (!section.isGsSection) 1.5.dp else 1.dp,
                color = if (!section.isGsSection) SaffronGold else Color(0xFF818CF8),
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
                    text = "${section.orderNumber}",
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
                            .background(Color(0xFF1E293B))
                            .border(0.8.dp, SaffronGold, RoundedCornerShape(4.dp))
                            .padding(horizontal = 5.dp, vertical = 1.dp)
                    ) {
                        Text(
                            text = "$activeExamLabel • ${if (isHi) section.shortBadgeHi else section.shortBadgeEn}",
                            fontSize = 8.5.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color(0xFFFDE68A),
                            maxLines = 1,
                            softWrap = false
                        )
                    }
                }
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = if (isHi) section.titleHi else section.titleEn,
                    fontSize = 12.5.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (!section.isGsSection) Color(0xFFFDE68A) else Color.White,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = if (isHi) section.subtitleHi else section.subtitleEn,
                    fontSize = 10.sp,
                    color = Color(0xFFE2E8F0),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "${section.questionCount} $activeExamLabel PYQ Questions • +2.0/-0.50 • Bilingual Explanation",
                    fontSize = 9.5.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFFC7D2FE),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                SectionTestProgressBar(
                    progress = progress,
                    sectionKey = section.sectionId,
                    isHi = isHi
                )
            }
        }
        Spacer(modifier = Modifier.width(8.dp))
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(6.dp))
                .background(if (!section.isGsSection) SaffronGold else EmeraldSuccess)
                .padding(horizontal = 10.dp, vertical = 6.dp)
                .testTag("start_${section.sectionId}")
        ) {
            Text(
                text = if (isHi) "अटेम्प्ट (${section.questionCount} Q)" else "Start ${section.questionCount}-Q",
                fontSize = 10.5.sp,
                fontWeight = FontWeight.ExtraBold,
                color = if (!section.isGsSection) Navy900 else Color.White,
                maxLines = 1,
                softWrap = false
            )
        }
    }
}
