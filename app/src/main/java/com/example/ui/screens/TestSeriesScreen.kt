package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.GridOn
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.AppLanguage
import com.example.model.MockTest
import com.example.ui.theme.EmeraldLight
import com.example.ui.theme.EmeraldSuccess
import com.example.ui.theme.Navy100
import com.example.ui.theme.Navy800
import com.example.ui.theme.Navy900
import com.example.ui.theme.SaffronGold
import com.example.viewmodel.ShakuntalamUiState
import com.example.viewmodel.ShakuntalamViewModel

@Composable
fun TestSeriesScreen(
    uiState: ShakuntalamUiState,
    viewModel: ShakuntalamViewModel,
    modifier: Modifier = Modifier
) {
    val isHi = uiState.selectedLanguage == AppLanguage.HINDI
    val isDual = uiState.isDualBilingualView
    val showHindiOnly = !isDual && uiState.isBilingualHindi
    val test = uiState.activeTest
    val questions = test.questions
    val currentIndex = uiState.currentQuestionIndex.coerceIn(0, (questions.size - 1).coerceAtLeast(0))
    val currentQuestion = questions.getOrNull(currentIndex) ?: return

    var showSubmitConfirmation by remember { mutableStateOf(false) }
    var showPyqAnalysisBanner by remember { mutableStateOf(true) }

    if (uiState.isTestSubmitted) {
        TestScorecardView(
            test = test,
            uiState = uiState,
            viewModel = viewModel
        )
        return
    }

    val modeLabel = when {
        isDual -> "EN + हिंदी (Bilingual)"
        showHindiOnly -> "हिंदी (HI)"
        else -> "English (EN)"
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = Navy900,
                shadowElevation = 4.dp
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 8.dp)
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
                            IconButton(
                                onClick = { viewModel.navigateBack() },
                                modifier = Modifier.testTag("test_back_btn")
                            ) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = "Back",
                                    tint = Color.White
                                )
                            }
                            Column {
                                Text(
                                    text = "LAST 5 YEARS PYQ CBT ENGINE (2020–2025)",
                                    fontSize = 9.5.sp,
                                    color = SaffronGold,
                                    fontWeight = FontWeight.ExtraBold,
                                    letterSpacing = 0.5.sp,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                                Text(
                                    text = "${test.examName} • Q${currentIndex + 1}/${questions.size}",
                                    fontSize = 12.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            // Room Offline Cache Quick Save Button
                            val isActiveTestOfflineCached = uiState.isTestCachedOffline(test.testId)
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(6.dp))
                                    .background(
                                        if (isActiveTestOfflineCached) EmeraldSuccess.copy(alpha = 0.25f) else Color(0x33FFFFFF)
                                    )
                                    .clickable { viewModel.cacheMockTestForOffline(test) }
                                    .padding(horizontal = 7.dp, vertical = 5.dp)
                                    .testTag("test_save_offline_btn"),
                                contentAlignment = Alignment.Center
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(
                                        imageVector = Icons.Default.CheckCircle,
                                        contentDescription = "Offline Cache",
                                        tint = if (isActiveTestOfflineCached) EmeraldSuccess else SaffronGold,
                                        modifier = Modifier.size(12.dp)
                                    )
                                    Spacer(modifier = Modifier.width(3.dp))
                                    Text(
                                        text = if (isActiveTestOfflineCached) {
                                            if (isHi) "✓ ऑफलाइन" else "✓ Offline"
                                        } else {
                                            if (isHi) "ऑफलाइन सेव" else "Save Offline"
                                        },
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White,
                                        maxLines = 1,
                                        softWrap = false
                                    )
                                }
                            }

                            // Bilingual Mode Cycle Button (EN+HI / EN / HI)
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(6.dp))
                                    .background(Color(0x33FFFFFF))
                                    .clickable { viewModel.toggleBilingual() }
                                    .padding(horizontal = 8.dp, vertical = 5.dp)
                                    .testTag("toggle_language"),
                                contentAlignment = Alignment.Center
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(
                                        imageVector = Icons.Default.Translate,
                                        contentDescription = "Translate",
                                        tint = SaffronGold,
                                        modifier = Modifier.size(13.dp)
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(
                                        text = modeLabel,
                                        fontSize = 10.5.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White,
                                        maxLines = 1,
                                        softWrap = false,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }
                            }

                            // Submit Button
                            Button(
                                onClick = { showSubmitConfirmation = true },
                                colors = ButtonDefaults.buttonColors(containerColor = EmeraldSuccess),
                                shape = RoundedCornerShape(8.dp),
                                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp),
                                modifier = Modifier
                                    .height(34.dp)
                                    .testTag("submit_test_btn")
                            ) {
                                Text(
                                    text = if (isHi) "जमा करें" else "Submit",
                                    fontSize = 11.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,
                                    maxLines = 1,
                                    softWrap = false
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    // Real-Time Countdown Timer Bar (displays remaining time, pacing telemetry & auto-submits when time expires)
                    com.example.ui.components.QuizRealTimeCountdownBar(
                        uiState = uiState,
                        isHi = isHi,
                        onTickSecond = { viewModel.tickTestTimer(1) },
                        onTogglePauseResume = { viewModel.togglePauseTestTimer() },
                        onToggleStrictExamMode = { viewModel.toggleStrictExamSimulationMode() },
                        onSelectCustomDurationMinutes = { mins -> viewModel.setCustomExamDurationMinutes(mins) },
                        onResetTimer = { viewModel.resetActiveTestTimer() }
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    // Exam-Wise & UPPCS 7-Subject (50-Question) Last 5 Years PYQ Test Switcher Bar
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("pyq_exam_selector_row")
                    ) {
                        items(uiState.customTests) { examTest ->
                            val isSelectedExam = examTest.testId == test.testId
                            val shortBadge = when (examTest.testId) {
                                "ssc_sec_history_100" -> "SSC GS: History (इतिहास • 100Q)"
                                "ssc_sec_polity_100" -> "SSC GS: Polity (राजव्यवस्था • 100Q)"
                                "ssc_sec_geography_100" -> "SSC GS: Geography (भूगोल • 100Q)"
                                "ssc_sec_environment_100" -> "SSC GS: Environment (पर्यावरण • 100Q)"
                                "ssc_sec_economics_100" -> "SSC GS: Economics (अर्थव्यवस्था • 100Q)"
                                "ssc_sec_reasoning_100" -> "SSC: Reasoning (रीजनिंग • 100Q)"
                                "ssc_sec_mathematics_100" -> "SSC: Mathematics (मैथमेटिक्स • 100Q)"
                                "ssc_sec_english_100" -> "SSC: English (इंग्लिश • 100Q)"
                                "uksssc_sec_uttarakhand_special_250" -> "UKSSSC ★ उत्तराखंड स्पेशल (Best 250 PYQs)"
                                "uksssc_sec_history_100" -> "UKSSSC: History (इतिहास • 100Q)"
                                "uksssc_sec_polity_100" -> "UKSSSC: Polity (राजव्यवस्था • 100Q)"
                                "uksssc_sec_geography_100" -> "UKSSSC: Geography (भूगोल • 100Q)"
                                "uksssc_sec_economics_100" -> "UKSSSC: Economics (अर्थव्यवस्था • 100Q)"
                                "uksssc_sec_environment_100" -> "UKSSSC: Environment & Forest (100Q)"
                                "uksssc_sec_scitech_100" -> "UKSSSC: Sci & Tech (विज्ञान • 100Q)"
                                "uksssc_sec_hindi_100" -> "UKSSSC: General Hindi (सामान्य हिंदी • 100Q)"
                                "uksssc_sec_computer_100" -> "UKSSSC: Computer & IT (कंप्यूटर • 100Q)"
                                "uksssc_sec_reasoning_di_100" -> "UKSSSC: Reasoning & DI (रीजनिंग/डीआई • 100Q)"
                                "upsssc_sec_up_special_250" -> "UPSSSC ★ यूपी स्पेशल (Best 250 PYQs)"
                                "upsssc_sec_history_100" -> "UPSSSC: History (इतिहास • 100Q)"
                                "upsssc_sec_polity_100" -> "UPSSSC: Polity (संविधान • 100Q)"
                                "upsssc_sec_geography_100" -> "UPSSSC: Geography (भूगोल • 100Q)"
                                "upsssc_sec_economics_100" -> "UPSSSC: Economics (अर्थव्यवस्था • 100Q)"
                                "upsssc_sec_environment_100" -> "UPSSSC: Environment (पर्यावरण • 100Q)"
                                "upsssc_sec_scitech_100" -> "UPSSSC: Sci & Tech (विज्ञान • 100Q)"
                                "upsssc_sec_computer_100" -> "UPSSSC: Computer & IT (कंप्यूटर • 100Q)"
                                "upsssc_sec_di_100" -> "UPSSSC: DI Graph & Table (डीआई • 100Q)"
                                "bpsc_sec_bihar_special_100" -> "BPSC ★ बिहार विशेष (Top 100 PYQs)"
                                "bpsc_sec_history_100" -> "BPSC: History (इतिहास • 100Q)"
                                "bpsc_sec_polity_100" -> "BPSC: Polity (राजव्यवस्था • 100Q)"
                                "bpsc_sec_geography_100" -> "BPSC: Geography (भूगोल • 100Q)"
                                "bpsc_sec_economics_100" -> "BPSC: Economy & Budget (100Q)"
                                "bpsc_sec_science_100" -> "BPSC: General Science (100Q)"
                                "bpsc_sec_ca_100" -> "BPSC: Current Affairs (100Q)"
                                "ukpsc_sec_uttarakhand_special_100" -> "UKPSC ★ उत्तराखंड विशेष (Top 100 PYQs)"
                                "ukpsc_sec_history_50" -> "UKPSC: History (इतिहास • 50Q)"
                                "ukpsc_sec_polity_50" -> "UKPSC: Polity (राजव्यवस्था • 50Q)"
                                "ukpsc_sec_geography_50" -> "UKPSC: Geography (भूगोल • 50Q)"
                                "ukpsc_sec_economics_50" -> "UKPSC: Economics (अर्थव्यवस्था • 50Q)"
                                "ukpsc_sec_environment_50" -> "UKPSC: Environment (पर्यावरण • 50Q)"
                                "ukpsc_sec_scitech_50" -> "UKPSC: Sci & Computer (50Q)"
                                "ukpsc_sec_ca_50" -> "UKPSC: Current Affairs (50Q)"
                                "upsc_sec_history_50" -> "UPSC: History & Culture (50Q)"
                                "upsc_sec_polity_50" -> "UPSC: Polity & Governance (50Q)"
                                "upsc_sec_geography_50" -> "UPSC: Geography (भूगोल • 50Q)"
                                "upsc_sec_economics_50" -> "UPSC: Economy (अर्थव्यवस्था • 50Q)"
                                "upsc_sec_environment_50" -> "UPSC: Environment (पर्यावरण • 50Q)"
                                "upsc_sec_scitech_50" -> "UPSC: Sci & Tech (विज्ञान • 50Q)"
                                "upsc_sec_ir_ca_50" -> "UPSC: Current Affairs & IR (50Q)"
                                "uppcs_sec_history_50" -> "UPPCS: History (हिस्ट्री • 50Q)"
                                "uppcs_sec_polity_50" -> "UPPCS: Polity (पॉलिटी • 50Q)"
                                "uppcs_sec_geography_50" -> "UPPCS: Geography (ज्योग्राफी • 50Q)"
                                "uppcs_sec_environment_50" -> "UPPCS: Environment (एनवायरनमेंट • 50Q)"
                                "uppcs_sec_scitech_50" -> "UPPCS: Sci & Tech (साइंस एंड टेक • 50Q)"
                                "uppcs_sec_up_ca_50" -> "UPPCS: UP Current Affairs (50Q)"
                                "uppcs_sec_economics_50" -> "UPPCS: Economics (इकोनॉमिक्स • 50Q)"
                                else -> when (examTest.categoryId) {
                                    "upsc" -> "UPSC CSE Combined"
                                    "state_psc" -> "State PSC Combined"
                                    "ssc" -> "SSC CGL / CHSL"
                                    "banking" -> "Banking / RBI PO"
                                    "railway" -> "Railways & UPSSSC"
                                    "neet_jee" -> "NEET / JEE / NET"
                                    else -> examTest.examName.take(20)
                                }
                            }
                            val itemProgress = uiState.getSectionProgress(examTest.testId, examTest.questions.size)
                            val progressSuffix = when {
                                itemProgress.isCompleted -> " ✓ 100%"
                                itemProgress.answeredCount > 0 -> " • ${itemProgress.completionPercent}%"
                                else -> ""
                            }
                            Box(
                                modifier = Modifier
                                    .height(32.dp)
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(
                                        if (isSelectedExam) com.example.ui.components.EdTechProColors.RoyalIndigo else if (itemProgress.isCompleted) EmeraldSuccess.copy(alpha = 0.35f) else com.example.ui.components.EdTechProColors.UnselectedDarkTabBg
                                    )
                                    .border(
                                        width = if (isSelectedExam) 1.5.dp else 1.dp,
                                        color = if (isSelectedExam) SaffronGold else if (itemProgress.isCompleted) EmeraldSuccess else com.example.ui.components.EdTechProColors.UnselectedDarkTabBorder,
                                        shape = RoundedCornerShape(10.dp)
                                    )
                                    .clickable { viewModel.startTest(examTest) }
                                    .padding(horizontal = 10.dp)
                                    .testTag("select_pyq_${examTest.testId}"),
                                contentAlignment = Alignment.Center
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    com.example.ui.components.ShakuntalamBrandCrestBadge(
                                        size = 15.dp,
                                        showGlowRing = isSelectedExam
                                    )
                                    Spacer(modifier = Modifier.width(5.dp))
                                    Text(
                                        text = "$shortBadge$progressSuffix",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = if (isSelectedExam) com.example.ui.components.EdTechProColors.ChampagneGold else Color.White,
                                        maxLines = 1,
                                        softWrap = false,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    // Live Active Section Progress Bar + GS, Reasoning, Math & English Completion Status Strip
                    val activeProgress = uiState.getSectionProgress(test.testId, questions.size)
                    val gsProg = uiState.getSscGsProgress()
                    val reasProg = uiState.getSscReasoningProgress()
                    val mathProg = uiState.getSscMathProgress()
                    val engProg = uiState.getSscEnglishProgress()

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color(0xFF0F172A))
                            .border(1.dp, Color(0xFF334155), RoundedCornerShape(8.dp))
                            .padding(horizontal = 10.dp, vertical = 6.dp)
                            .testTag("test_series_live_progress_bar")
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = if (isHi)
                                    "सेक्शन प्रोग्रेस: ${activeProgress.answeredCount}/${activeProgress.totalQuestions} हल (${activeProgress.completionPercent}%)"
                                else
                                    "Test Progress: ${activeProgress.answeredCount}/${activeProgress.totalQuestions} Answered (${activeProgress.completionPercent}%)",
                                fontSize = 10.5.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color(0xFFFDE68A),
                                maxLines = 1,
                                softWrap = false,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.weight(1f)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = if (isHi) activeProgress.statusHi else activeProgress.statusEn,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = if (activeProgress.isCompleted) EmeraldSuccess else SaffronGold,
                                maxLines = 1,
                                softWrap = false
                            )
                        }

                        Spacer(modifier = Modifier.height(4.dp))

                        // Progress Bar Track
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(5.dp)
                                .clip(RoundedCornerShape(3.dp))
                                .background(Color(0xFF1E293B))
                        ) {
                            val activeFraction = (activeProgress.completionPercent / 100f).coerceIn(0f, 1f)
                            if (activeFraction > 0f) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth(activeFraction)
                                        .height(5.dp)
                                        .clip(RoundedCornerShape(3.dp))
                                        .background(if (activeProgress.isCompleted) EmeraldSuccess else SaffronGold)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(5.dp))

                        // Quick 4-Pillar Status Row: GS • Reasoning • Math • English
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(6.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            val pillars = listOf(
                                Triple("GS", gsProg, "ssc_gs_history"),
                                Triple("Reasoning", reasProg, "ssc_reasoning"),
                                Triple("Math", mathProg, "ssc_mathematics"),
                                Triple("English", engProg, "ssc_english")
                            )
                            pillars.forEach { (label, prog, targetKey) ->
                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .clip(RoundedCornerShape(5.dp))
                                        .background(
                                            if (prog.isCompleted) EmeraldSuccess.copy(alpha = 0.25f) else Color(0xFF1E293B)
                                        )
                                        .border(
                                            width = 0.8.dp,
                                            color = if (prog.isCompleted) EmeraldSuccess else if (prog.answeredCount > 0) SaffronGold else Color(0xFF475569),
                                            shape = RoundedCornerShape(5.dp)
                                        )
                                        .clickable { viewModel.startSscSectionTest(targetKey) }
                                        .padding(horizontal = 4.dp, vertical = 3.dp)
                                        .testTag("cbt_pillar_progress_${label.lowercase()}"),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "$label: ${prog.completionPercent}%",
                                        fontSize = 9.5.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = if (prog.isCompleted) Color(0xFF86EFAC) else if (prog.answeredCount > 0) Color(0xFFFDE68A) else Color(0xFFCBD5E1),
                                        maxLines = 1,
                                        softWrap = false,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }
                            }
                        }
                    }
                }
            }
        },
        bottomBar = {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = Color.White,
                shadowElevation = 8.dp
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 14.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    OutlinedButton(
                        onClick = { viewModel.setQuestionIndex(currentIndex - 1) },
                        enabled = currentIndex > 0,
                        shape = RoundedCornerShape(8.dp),
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 0.dp),
                        modifier = Modifier
                            .weight(1f)
                            .height(42.dp)
                    ) {
                        Text(
                            text = if (isHi) "पिछला (Prev)" else "Previous",
                            fontSize = 11.5.sp,
                            fontWeight = FontWeight.SemiBold,
                            maxLines = 1,
                            softWrap = false,
                            overflow = TextOverflow.Ellipsis
                        )
                    }

                    val isMarked = uiState.markedForReview.contains(currentQuestion.id)
                    Button(
                        onClick = { viewModel.toggleMarkForReview(currentQuestion.id) },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (isMarked) Color(0xFF7C3AED) else Color(0xFFEDE9FE)
                        ),
                        shape = RoundedCornerShape(8.dp),
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 0.dp),
                        modifier = Modifier
                            .weight(1f)
                            .height(42.dp)
                    ) {
                        Text(
                            text = if (isMarked) (if (isHi) "रिव्यू चिह्नित" else "Marked") else (if (isHi) "रिव्यू रखें" else "Review"),
                            fontSize = 11.5.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = if (isMarked) Color.White else Color(0xFF5B21B6),
                            maxLines = 1,
                            softWrap = false,
                            overflow = TextOverflow.Ellipsis
                        )
                    }

                    Button(
                        onClick = {
                            if (currentIndex < questions.size - 1) {
                                viewModel.setQuestionIndex(currentIndex + 1)
                            } else {
                                showSubmitConfirmation = true
                            }
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Navy900),
                        shape = RoundedCornerShape(8.dp),
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 0.dp),
                        modifier = Modifier
                            .weight(1.2f)
                            .height(42.dp)
                            .testTag("next_question_btn")
                    ) {
                        Text(
                            text = if (currentIndex < questions.size - 1) (if (isHi) "अगला (Next)" else "Save & Next") else (if (isHi) "सबमिट करें" else "Submit Test"),
                            fontSize = 11.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            maxLines = 1,
                            softWrap = false,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF8FAFC))
                .padding(innerPadding)
                .padding(horizontal = 14.dp, vertical = 12.dp),
            contentPadding = PaddingValues(bottom = 24.dp)
        ) {
            // 0. Individual Test Series Cards Section (Title, Number of Questions, and 'Start Test' Button)
            item {
                com.example.ui.components.TestSeriesTabCardsSection(
                    activeTest = test,
                    allTests = uiState.customTests,
                    getAnsweredCount = { tid ->
                        uiState.getSectionProgress(tid, 100).answeredCount
                    },
                    isTestCompleted = { tid ->
                        uiState.completedTestIds.contains(tid)
                    },
                    isHi = isHi,
                    onStartTest = { selectedMock ->
                        viewModel.startTest(selectedMock)
                    }
                )
                Spacer(modifier = Modifier.height(10.dp))
            }

            // 0B. Testbook-Style 14-Exam Master Package Browser (50 Paid Tests: 20 FLT + 20 Sectional + 10 PYQ & Free Topic/Daily Quizzes)
            item {
                var selectedHubExamKey by remember(test.categoryId) {
                    val cat = test.categoryId.lowercase()
                    val initial = when {
                        cat.contains("up_police") || test.testId.startsWith("up_police") -> "up_police"
                        cat.contains("uppcs") || test.testId.startsWith("uppcs") -> "uppcs"
                        cat.contains("ukpsc") || test.testId.startsWith("ukpsc") -> "ukpsc"
                        cat.contains("bpsc") || test.testId.startsWith("bpsc") -> "bpsc"
                        cat.contains("upsssc") || test.testId.startsWith("upsssc") -> "upsssc"
                        cat.contains("uksssc") || test.testId.startsWith("uksssc") -> "uksssc"
                        cat.contains("ssc") || test.testId.startsWith("ssc") -> "ssc"
                        cat.contains("bank") || test.testId.startsWith("banking") -> "banking"
                        cat.contains("rail") || test.testId.startsWith("railways") -> "railways"
                        cat.contains("jee") || test.testId.startsWith("iit_jee") -> "iit_jee"
                        cat.contains("neet") || test.testId.startsWith("neet") -> "neet"
                        cat.contains("ugc") || test.testId.startsWith("ugc_net") -> "ugc_net"
                        cat.contains("tet") || test.testId.startsWith("tet") -> "tet"
                        else -> "upsc"
                    }
                    mutableStateOf(initial)
                }
                var isMasterHubExpanded by remember { mutableStateOf(false) }

                Column(modifier = Modifier.fillMaxWidth()) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(12.dp))
                            .background(com.example.ui.components.EdTechProColors.DeepRoyalNavy)
                            .border(
                                1.5.dp,
                                com.example.ui.components.EdTechProColors.WarmGold,
                                RoundedCornerShape(12.dp)
                            )
                            .clickable { isMasterHubExpanded = !isMasterHubExpanded }
                            .padding(horizontal = 12.dp, vertical = 10.dp)
                            .testTag("test_series_all_exam_package_toggle"),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.weight(1f)
                        ) {
                            com.example.ui.components.ShakuntalamBrandCrestBadge(size = 22.dp, showGlowRing = true)
                            Spacer(modifier = Modifier.width(8.dp))
                            Column {
                                Text(
                                    text = if (isHi)
                                        "सभी 14 परीक्षाओं का फुल पैकेज (50 पेड टेस्ट: 20 FLT + 20 सेक्शनल + 10 PYQ व फ्री टॉपिक क्विज़)"
                                    else
                                        "ALL 14 EXAMS FULL PACKAGE (50 PAID: 20 FLT + 20 SECTIONAL + 10 PYQ & FREE QUIZZES)",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = com.example.ui.components.EdTechProColors.ChampagneGold,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                                Text(
                                    text = if (isHi)
                                        "UPSC • UP पुलिस • PCS • UPSSSC • UKSSSC • SSC • RRB • Banking • JE • NEET • UGC NET • TET"
                                    else
                                        "UPSC • UP Police • PCS • UPSSSC • UKSSSC • SSC • RRB • Banking • JE • NEET • UGC NET • TET",
                                    fontSize = 9.5.sp,
                                    color = Color(0xFF67E8F9),
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = if (isMasterHubExpanded) (if (isHi) "बंद करें ▲" else "Hide ▲") else (if (isHi) "खोलें (50 Tests) ▼" else "Browse 50 Tests ▼"),
                            fontSize = 10.5.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = com.example.ui.components.EdTechProColors.WarmGold
                        )
                    }

                    if (isMasterHubExpanded) {
                        Spacer(modifier = Modifier.height(6.dp))
                        com.example.ui.components.AllIndiaTestbookSuperHubAndFreeNotesSection(
                            selectedExamKey = selectedHubExamKey,
                            isHi = isHi,
                            onSelectExamKey = { key -> selectedHubExamKey = key },
                            onStartMockTest = { mock ->
                                viewModel.startTest(mock)
                                isMasterHubExpanded = false
                            },
                            onReadFreeNoteInApp = { noteItem ->
                                viewModel.openReader(noteItem, 0)
                            },
                            onDownloadFreePdfNote = { noteItem ->
                                viewModel.cacheStudyItemForOffline(noteItem)
                            },
                            modifier = Modifier.padding(horizontal = 0.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
            }

            // 1. Last 5 Years (2020-2025) PYQ Trend & Exam Requirement Analysis Card
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("pyq_trend_analysis_card"),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A))
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { showPyqAnalysisBanner = !showPyqAnalysisBanner },
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.weight(1f)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Analytics,
                                    contentDescription = "PYQ Analysis",
                                    tint = SaffronGold,
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = "5-YEAR PYQ ANALYSIS (2020–2025) • ${test.examName}",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = SaffronGold,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                            Text(
                                text = if (showPyqAnalysisBanner) "Hide ▲" else "Details ▼",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF94A3B8)
                            )
                        }

                        if (showPyqAnalysisBanner) {
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(
                                text = test.pyqAnalysisEn,
                                fontSize = 11.sp,
                                color = Color.White,
                                lineHeight = 15.5.sp
                            )
                            if (isDual || showHindiOnly) {
                                Spacer(modifier = Modifier.height(3.dp))
                                Text(
                                    text = test.pyqAnalysisHi,
                                    fontSize = 11.sp,
                                    color = Color(0xFFCBD5E1),
                                    lineHeight = 15.5.sp
                                )
                            }
                            if (test.topicWeightage.isNotEmpty()) {
                                Spacer(modifier = Modifier.height(8.dp))
                                LazyRow(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                                    items(test.topicWeightage) { weightChip ->
                                        Box(
                                            modifier = Modifier
                                                .clip(RoundedCornerShape(6.dp))
                                                .background(Color(0xFF1E293B))
                                                .border(1.dp, Color(0xFF334155), RoundedCornerShape(6.dp))
                                                .padding(horizontal = 8.dp, vertical = 3.dp)
                                        ) {
                                            Text(
                                                text = weightChip,
                                                fontSize = 9.5.sp,
                                                fontWeight = FontWeight.SemiBold,
                                                color = SaffronGold
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
            }

            // 2. Bilingual Mode Selector Strip + Question Palette Strip
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Question Palette (${questions.size} PYQs):",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF475569)
                    )

                    // Direct 3-mode language pill switcher
                    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                        listOf(
                            Triple("EN + हिं", true, false),
                            Triple("EN", false, false),
                            Triple("हिंदी", false, true)
                        ).forEach { (label, dual, hiOnly) ->
                            val active = (isDual == dual) && (showHindiOnly == hiOnly)
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(6.dp))
                                    .background(if (active) Navy900 else Color(0xFFE2E8F0))
                                    .clickable { viewModel.setTestLanguageMode(dual, hiOnly) }
                                    .padding(horizontal = 8.dp, vertical = 3.dp)
                            ) {
                                Text(
                                    text = label,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (active) SaffronGold else Navy900
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(6.dp))

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    itemsIndexed(questions) { idx, q ->
                        val isAnswered = uiState.userAnswers.containsKey(q.id)
                        val isMarked = uiState.markedForReview.contains(q.id)
                        val isCurrent = idx == currentIndex

                        val bg = when {
                            isCurrent -> SaffronGold
                            isMarked -> Color(0xFF8B5CF6)
                            isAnswered -> EmeraldSuccess
                            else -> Color(0xFFE2E8F0)
                        }

                        val textColor = when {
                            isCurrent || isMarked || isAnswered -> Color.White
                            else -> Navy900
                        }

                        Box(
                            modifier = Modifier
                                .size(34.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(bg)
                                .clickable { viewModel.setQuestionIndex(idx) },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "${idx + 1}",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = textColor
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(12.dp))
            }

            // 3. Question Card Header: Subject, 5-Year PYQ Tag, Frequency & Exam Marking Scheme
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        // Top Row: Subject & Official Marking Scheme (+Positive / -Negative)
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Box(
                                modifier = Modifier
                                    .weight(1f, fill = false)
                                    .clip(RoundedCornerShape(6.dp))
                                    .background(Navy100)
                                    .padding(horizontal = 8.dp, vertical = 4.dp)
                            ) {
                                Text(
                                    text = currentQuestion.subject,
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Navy900,
                                    maxLines = 1,
                                    softWrap = false,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }

                            Spacer(modifier = Modifier.width(8.dp))

                            Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(4.dp))
                                        .background(EmeraldLight)
                                        .padding(horizontal = 6.dp, vertical = 3.dp)
                                ) {
                                    Text(
                                        text = "+${test.positiveMarks} Marks",
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = EmeraldSuccess,
                                        maxLines = 1,
                                        softWrap = false
                                    )
                                }
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(4.dp))
                                        .background(Color(0xFFFFE4E6))
                                        .padding(horizontal = 6.dp, vertical = 3.dp)
                                ) {
                                    Text(
                                        text = "-${test.negativeMarks} Neg",
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFFE11D48),
                                        maxLines = 1,
                                        softWrap = false
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        // Second Row: PYQ Year Tag, 5-Year Frequency & Difficulty Badges
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(6.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(5.dp))
                                    .background(Color(0xFFFFFBEB))
                                    .border(1.dp, SaffronGold, RoundedCornerShape(5.dp))
                                    .padding(horizontal = 7.dp, vertical = 2.dp)
                            ) {
                                Text(
                                    text = currentQuestion.pyqYearTag,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color(0xFFB45309),
                                    maxLines = 1,
                                    softWrap = false,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }

                            Box(
                                modifier = Modifier
                                    .weight(1f, fill = false)
                                    .clip(RoundedCornerShape(5.dp))
                                    .background(Color(0xFFF0FDF4))
                                    .padding(horizontal = 7.dp, vertical = 2.dp)
                            ) {
                                Text(
                                    text = "★ ${currentQuestion.pyqFrequency}",
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = EmeraldSuccess,
                                    maxLines = 1,
                                    softWrap = false,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }

                            val qDiffBucket = com.example.ui.components.TestAnalyticsEngine.classifyQuestionDifficulty(
                                currentQuestion,
                                currentIndex
                            )
                            val qDiffColor = Color(qDiffBucket.colorHex)
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(5.dp))
                                    .background(qDiffColor.copy(alpha = 0.14f))
                                    .border(1.dp, qDiffColor.copy(alpha = 0.5f), RoundedCornerShape(5.dp))
                                    .padding(horizontal = 7.dp, vertical = 2.dp)
                                    .testTag("question_difficulty_badge")
                            ) {
                                Text(
                                    text = if (isHi) qDiffBucket.labelHi else qDiffBucket.labelEn,
                                    fontSize = 9.5.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = qDiffColor,
                                    maxLines = 1,
                                    softWrap = false
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        // Professional Bilingual Question Text (Line-by-Line Sequential Statements & Excel DI Table/Graph)
                        val cleanQEn = com.example.ui.components.ProfessionalQuestionFormatEngine.cleanQuestionTextEn(
                            currentQuestion.questionEn
                        )
                        val cleanQHi = com.example.ui.components.ProfessionalQuestionFormatEngine.cleanQuestionTextHi(
                            currentQuestion.questionHi
                        )

                        if (isDual) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(Color(0xFFF8FAFC))
                                    .border(1.dp, Color(0xFFE2E8F0), RoundedCornerShape(10.dp))
                                    .padding(12.dp)
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Box(
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(4.dp))
                                            .background(com.example.ui.components.EdTechProColors.RoyalIndigo)
                                            .padding(horizontal = 6.dp, vertical = 2.dp)
                                    ) {
                                        Text(
                                            text = "QUESTION ${currentIndex + 1} • ENGLISH",
                                            fontSize = 9.5.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            color = Color.White,
                                            letterSpacing = 0.4.sp
                                        )
                                    }
                                }
                                Spacer(modifier = Modifier.height(6.dp))
                                com.example.ui.components.SequentialStatementQuestionText(
                                    questionNumber = currentIndex + 1,
                                    rawQuestionText = cleanQEn,
                                    isHindiText = false,
                                    textTestTag = "test_question_english_text"
                                )

                                Spacer(modifier = Modifier.height(10.dp))
                                HorizontalDivider(color = Color(0xFFCBD5E1))
                                Spacer(modifier = Modifier.height(10.dp))

                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Box(
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(4.dp))
                                            .background(Color(0xFFB45309))
                                            .padding(horizontal = 6.dp, vertical = 2.dp)
                                    ) {
                                        Text(
                                            text = "प्रश्न ${currentIndex + 1} • हिंदी",
                                            fontSize = 9.5.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            color = Color.White,
                                            letterSpacing = 0.3.sp
                                        )
                                    }
                                }
                                Spacer(modifier = Modifier.height(6.dp))
                                com.example.ui.components.SequentialStatementQuestionText(
                                    questionNumber = currentIndex + 1,
                                    rawQuestionText = cleanQHi,
                                    isHindiText = true,
                                    textTestTag = "test_question_hindi_text"
                                )
                            }
                        } else {
                            val qText = if (showHindiOnly) cleanQHi else cleanQEn
                            com.example.ui.components.SequentialStatementQuestionText(
                                questionNumber = currentIndex + 1,
                                rawQuestionText = qText,
                                isHindiText = showHindiOnly,
                                textTestTag = if (showHindiOnly) "test_question_hindi_text" else "test_question_english_text"
                            )
                        }

                        // Excel-Style Structured Table (तालिका) & Visual Bar Graph (ग्राफ) for Maths / DI / Index Questions
                        val diTableSpec = com.example.data.AllIndiaMasterTestPackageData.getDataTableForQuestion(currentQuestion)
                        if (diTableSpec != null) {
                            Spacer(modifier = Modifier.height(8.dp))
                            com.example.ui.components.ExcelStyleDiTableAndGraphCard(
                                tableSpec = diTableSpec,
                                isHi = isHi || showHindiOnly
                            )
                        }
                    }
                }
            }

            // 4. Four Bilingual MCQ Options (A, B, C, D) — Cleanly formatted below the question
            item {
                Spacer(modifier = Modifier.height(12.dp))
                val selectedOption = uiState.userAnswers[currentQuestion.id]
                val optionCount = currentQuestion.optionsEn.size

                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    for (optIdx in 0 until optionCount) {
                        val rawOptEn = currentQuestion.optionsEn.getOrElse(optIdx) { "" }
                        val rawOptHi = currentQuestion.optionsHi.getOrElse(optIdx) { rawOptEn }
                        val optEn = com.example.ui.components.ProfessionalQuestionFormatEngine.cleanOptionText(rawOptEn)
                        val optHi = com.example.ui.components.ProfessionalQuestionFormatEngine.cleanOptionText(rawOptHi)
                        val isSelected = selectedOption == optIdx
                        val isCorrectOption = optIdx == currentQuestion.correctIndex
                        val showInstant = uiState.isInstantPyqSolutionVisible
                        val optLetter = ('A' + optIdx).toString()

                        val borderColor = when {
                            showInstant && isCorrectOption -> EmeraldSuccess
                            showInstant && isSelected && !isCorrectOption -> Color(0xFFEF4444)
                            isSelected -> com.example.ui.components.EdTechProColors.RoyalIndigo
                            else -> Color(0xFFCBD5E1)
                        }

                        val cardBg = when {
                            showInstant && isCorrectOption -> Color(0xFFF0FDF4)
                            showInstant && isSelected && !isCorrectOption -> Color(0xFFFEF2F2)
                            isSelected -> Color(0xFFEFF6FF)
                            else -> Color.White
                        }

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(12.dp))
                                .border(
                                    width = if (isSelected || (showInstant && isCorrectOption)) 2.dp else 1.dp,
                                    color = borderColor,
                                    shape = RoundedCornerShape(12.dp)
                                )
                                .clickable { viewModel.answerQuestion(currentQuestion.id, optIdx) }
                                .testTag("option_${currentQuestion.id}_$optIdx"),
                            colors = CardDefaults.cardColors(containerColor = cardBg),
                            elevation = CardDefaults.cardElevation(defaultElevation = if (isSelected) 2.dp else 0.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 14.dp, vertical = 12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(30.dp)
                                        .clip(CircleShape)
                                        .background(
                                            when {
                                                showInstant && isCorrectOption -> EmeraldSuccess
                                                isSelected -> com.example.ui.components.EdTechProColors.RoyalIndigo
                                                else -> Navy100
                                            }
                                        ),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = optLetter,
                                        fontSize = 12.5.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = if (isSelected || (showInstant && isCorrectOption)) Color.White else Navy900
                                    )
                                }

                                Spacer(modifier = Modifier.width(12.dp))

                                Column(modifier = Modifier.weight(1f)) {
                                    if (isDual) {
                                        Text(
                                            text = optEn,
                                            fontSize = 13.5.sp,
                                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.SemiBold,
                                            color = Navy900,
                                            lineHeight = 19.sp,
                                            letterSpacing = 0.1.sp
                                        )
                                        if (optHi.isNotBlank() && optHi != optEn) {
                                            Spacer(modifier = Modifier.height(3.dp))
                                            Text(
                                                text = optHi,
                                                fontSize = 12.5.sp,
                                                fontWeight = FontWeight.Medium,
                                                color = Color(0xFF334155),
                                                lineHeight = 18.sp,
                                                letterSpacing = 0.1.sp
                                            )
                                        }
                                    } else {
                                        Text(
                                            text = if (showHindiOnly) optHi else optEn,
                                            fontSize = 13.5.sp,
                                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.SemiBold,
                                            color = if (isSelected) Navy900 else Color(0xFF1E293B),
                                            lineHeight = 19.sp,
                                            letterSpacing = 0.1.sp
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // 5. Instant PYQ Answer Key, Bilingual Explanation & 5-Year Trend Toggle
            item {
                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedButton(
                        onClick = { viewModel.toggleInstantPyqSolution() },
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .weight(1f, fill = false)
                            .height(40.dp)
                            .testTag("toggle_instant_pyq_solution_btn")
                    ) {
                        Icon(
                            imageVector = Icons.Default.Lightbulb,
                            contentDescription = "PYQ Solution",
                            tint = SaffronGold,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = if (uiState.isInstantPyqSolutionVisible)
                                "Hide Answer & PYQ Explanation ▲"
                            else
                                "Check 5-Yr PYQ Answer & Explanation (उत्तर व व्याख्या) ▼",
                            fontSize = 11.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = Navy900,
                            maxLines = 1,
                            softWrap = false,
                            overflow = TextOverflow.Ellipsis
                        )
                    }

                    if (uiState.userAnswers.containsKey(currentQuestion.id)) {
                        TextButton(onClick = { viewModel.clearAnswer(currentQuestion.id) }) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = null,
                                tint = Color(0xFFDC2626),
                                modifier = Modifier.size(15.dp)
                            )
                            Spacer(modifier = Modifier.width(3.dp))
                            Text(
                                text = "Clear",
                                fontSize = 11.5.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color(0xFFDC2626),
                                maxLines = 1,
                                softWrap = false
                            )
                        }
                    }
                }

                val userSelectedIdx = uiState.userAnswers[currentQuestion.id]
                if (uiState.isInstantPyqSolutionVisible || userSelectedIdx != null) {
                    Spacer(modifier = Modifier.height(10.dp))
                    com.example.ui.components.ProfessionalStructuredExplanationCard(
                        question = currentQuestion,
                        userSelectedIdx = userSelectedIdx,
                        cardTestTag = "instant_pyq_solution_card"
                    )
                }
            }
        }
    }

    // Submit Confirmation Dialog
    if (showSubmitConfirmation) {
        val total = questions.size
        val answered = uiState.userAnswers.size
        val marked = uiState.markedForReview.size
        val unattempted = total - answered

        AlertDialog(
            onDismissRequest = { showSubmitConfirmation = false },
            title = {
                Text(
                    text = if (isHi) "क्या आप टेस्ट जमा करना चाहते हैं?" else "Submit 5-Year PYQ Mock Test?",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            },
            text = {
                Column {
                    Text(
                        text = "${test.examName} (+${test.positiveMarks} / -${test.negativeMarks})",
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.5.sp,
                        color = Navy900
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = if (isHi) "• शेष समय: ${uiState.formattedRemainingTime()}" else "• Time Remaining: ${uiState.formattedRemainingTime()}",
                        fontSize = 12.5.sp,
                        color = Navy800,
                        fontWeight = FontWeight.Bold
                    )
                    Text(if (isHi) "• कुल प्रश्न: $total" else "• Total PYQ Questions: $total", fontSize = 12.5.sp)
                    Text(if (isHi) "• हल किए गए: $answered" else "• Answered: $answered", fontSize = 12.5.sp, color = EmeraldSuccess, fontWeight = FontWeight.Bold)
                    Text(if (isHi) "• अनुत्तरित: $unattempted" else "• Unattempted: $unattempted", fontSize = 12.5.sp, color = Color(0xFFDC2626))
                    Text(if (isHi) "• रिव्यू हेतु चिह्नित: $marked" else "• Marked for Review: $marked", fontSize = 12.5.sp, color = Color(0xFF7C3AED))
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = if (isHi) "सबमिट करने के पश्चात आपको विस्तृत द्विभाषी (English + Hindi) स्कोरकार्ड एवं 5-वर्षीय PYQ व्याख्या प्राप्त होगी।" else "After submitting, you will receive your full scorecard with bilingual (English + Hindi) solutions and 5-year PYQ trend notes.",
                        fontSize = 11.5.sp,
                        color = Color(0xFF64748B)
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        showSubmitConfirmation = false
                        viewModel.submitTest()
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = EmeraldSuccess)
                ) {
                    Text(if (isHi) "हाँ, जमा करें" else "Yes, Submit", fontWeight = FontWeight.Bold)
                }
            },
            dismissButton = {
                TextButton(onClick = { showSubmitConfirmation = false }) {
                    Text(if (isHi) "रद्द करें" else "Cancel")
                }
            }
        )
    }
}

@Composable
fun TestScorecardView(
    test: MockTest,
    uiState: ShakuntalamUiState,
    viewModel: ShakuntalamViewModel
) {
    val isHi = uiState.selectedLanguage == AppLanguage.HINDI
    val isDual = uiState.isDualBilingualView
    val showHindiOnly = !isDual && uiState.isBilingualHindi
    val attempt = uiState.lastTestAttempt ?: return
    val accuracy = if (attempt.correctCount + attempt.wrongCount > 0) {
        ((attempt.correctCount.toDouble() / (attempt.correctCount + attempt.wrongCount)) * 100).toInt()
    } else {
        0
    }
    var selectedQuestionFilter by remember { mutableStateOf("ALL") } // "ALL", "CORRECT", "WRONG", "SKIPPED"

    val analyticsReport = remember(test, attempt, uiState.userAnswers, uiState.currentUser) {
        com.example.ui.components.TestAnalyticsEngine.generateAnalyticsReport(
            test = test,
            attempt = attempt,
            userAnswers = uiState.userAnswers,
            studentName = uiState.currentUser?.name ?: "Bharat Kumar",
            studentTargetExam = uiState.currentUser?.targetExam ?: "UPSC Civil Services"
        )
    }

    val filteredIndexedQuestions = remember(test.questions, uiState.userAnswers, selectedQuestionFilter) {
        test.questions.mapIndexed { idx, q -> idx to q }.filter { (_, q) ->
            val ans = uiState.userAnswers[q.id]
            when (selectedQuestionFilter) {
                "CORRECT" -> ans != null && ans == q.correctIndex
                "WRONG" -> ans != null && ans != q.correctIndex
                "SKIPPED" -> ans == null
                else -> true
            }
        }
    }

    Scaffold(
        topBar = {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = Navy900,
                shadowElevation = 4.dp
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .statusBarsPadding()
                        .padding(horizontal = 14.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(onClick = { viewModel.navigateBack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }

                    Text(
                        text = if (isHi) "रैंक, विश्लेषण चार्ट एवं लीडरबोर्ड" else "Rank, Test Analytics & Leaderboard",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    IconButton(onClick = { viewModel.startTest(test) }) {
                        Icon(
                            imageVector = Icons.Default.Refresh,
                            contentDescription = "Retake",
                            tint = SaffronGold
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF8FAFC))
                .padding(innerPadding)
                .padding(horizontal = 16.dp, vertical = 14.dp),
            contentPadding = PaddingValues(bottom = 24.dp)
        ) {
            // Auto-Submit Timeout Alert Banner (shown when timer reached 00:00)
            if (uiState.isAutoSubmittedOnTimeout) {
                item {
                    com.example.ui.components.AutoSubmitTimeoutBanner(
                        isHi = isHi,
                        totalDurationMinutes = test.durationMinutes
                    )
                }
            }

            // Scorecard Header Card
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Navy900)
                ) {
                    Column(
                        modifier = Modifier.padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "SHAKUNTALAM 5-YEAR PYQ SCORECARD • ${test.examName.uppercase()}",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = SaffronGold,
                            letterSpacing = 0.8.sp
                        )
                        Text(
                            text = if (isHi) test.hindiTitle else test.title,
                            fontSize = 13.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(top = 4.dp)
                        )

                        Spacer(modifier = Modifier.height(14.dp))

                        Text(
                            text = "%.2f".format(attempt.score),
                            fontSize = 38.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = SaffronGold
                        )
                        Text(
                            text = "Out of ${attempt.totalMarks} Marks (+${test.positiveMarks} / -${test.negativeMarks} Marking)",
                            fontSize = 11.5.sp,
                            color = Color(0xFFCBD5E1)
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    text = "${attempt.correctCount}",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = EmeraldSuccess
                                )
                                Text(if (isHi) "सही" else "Correct", fontSize = 10.5.sp, color = Color(0xFF94A3B8))
                            }
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    text = "${attempt.wrongCount}",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFFEF4444)
                                )
                                Text(if (isHi) "गलत" else "Wrong", fontSize = 10.5.sp, color = Color(0xFF94A3B8))
                            }
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    text = "${attempt.unattemptedCount}",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFFF59E0B)
                                )
                                Text(if (isHi) "छोड़े गए" else "Skipped", fontSize = 10.5.sp, color = Color(0xFF94A3B8))
                            }
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    text = "$accuracy%",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF38BDF8)
                                )
                                Text(if (isHi) "सटीकता" else "Accuracy", fontSize = 10.5.sp, color = Color(0xFF94A3B8))
                            }
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    text = com.example.ui.components.formatElapsedDuration(attempt.timeSpentSeconds),
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = SaffronGold,
                                    modifier = Modifier.testTag("scorecard_time_spent_value")
                                )
                                Text(if (isHi) "समय लगा" else "Time Used", fontSize = 10.5.sp, color = Color(0xFF94A3B8))
                            }
                        }
                    }
                }
            }

            // 1. All-India Student Rank System Card (Based on Score, Accuracy & Speed)
            item {
                com.example.ui.components.StudentRankSummaryCard(
                    report = analyticsReport,
                    isHi = isHi
                )
            }

            // 2. Test Analysis Chart: Correct, Wrong & Skipped Questions Donut + Bar + Filter
            item {
                com.example.ui.components.TestResponseAnalysisChartCard(
                    report = analyticsReport,
                    isHi = isHi,
                    selectedQuestionFilter = selectedQuestionFilter,
                    onSelectQuestionFilter = { filterCode -> selectedQuestionFilter = filterCode }
                )
            }

            // 3. Subject-Wise Question Analysis Breakdown
            item {
                com.example.ui.components.SubjectWiseAnalysisCard(
                    subjectBreakdown = analyticsReport.subjectBreakdown,
                    isHi = isHi
                )
            }

            // 4. Difficulty Level of Questions Analysis (Easy, Moderate, Hard)
            item {
                com.example.ui.components.DifficultyLevelAnalysisCard(
                    difficultyBreakdown = analyticsReport.difficultyBreakdown,
                    isHi = isHi
                )
            }

            // 5. Time Taken & Speed Management Analysis
            item {
                com.example.ui.components.TimeTakenAnalysisCard(
                    timeReport = analyticsReport.timeReport,
                    isHi = isHi
                )
                Spacer(modifier = Modifier.height(10.dp))
                Button(
                    onClick = { viewModel.openPerformanceAnalytics() },
                    colors = ButtonDefaults.buttonColors(containerColor = Navy900),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .testTag("scorecard_open_performance_analytics_btn")
                ) {
                    Icon(
                        imageVector = Icons.Default.Analytics,
                        contentDescription = null,
                        tint = SaffronGold,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = if (isHi)
                            "ऐतिहासिक प्रदर्शन विश्लेषण ग्राफ देखें (Scores, Accuracy & Time/Q)"
                        else
                            "View Historical Performance Analytics (Scores, Accuracy & Time/Q)",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            // 6. Top Scorer Leaderboard (Podium + Ranked List + Live Student Rank)
            item {
                com.example.ui.components.TopScorerLeaderboardCard(
                    leaderboard = analyticsReport.leaderboard,
                    examName = test.examName,
                    isHi = isHi
                )
            }

            // Solution Header
            item {
                Spacer(modifier = Modifier.height(18.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Bilingual PYQ Solutions (${filteredIndexedQuestions.size}/${test.questions.size}):",
                        fontSize = 14.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = Navy900
                    )
                    TextButton(onClick = { viewModel.toggleBilingual() }) {
                        Text(
                            text = when {
                                isDual -> "Mode: EN + हिंदी"
                                showHindiOnly -> "Mode: हिंदी"
                                else -> "Mode: English"
                            },
                            fontSize = 11.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = SaffronGold
                        )
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
            }

            // Question by Question Bilingual Solutions
            items(filteredIndexedQuestions) { (index, question) ->
                val userChoice = uiState.userAnswers[question.id]
                val isCorrect = userChoice == question.correctIndex
                val isUnattempted = userChoice == null
                val diffBucket = com.example.ui.components.TestAnalyticsEngine.classifyQuestionDifficulty(question, index)
                val diffColor = Color(diffBucket.colorHex)

                val statusColor = when {
                    isUnattempted -> Color(0xFFF59E0B)
                    isCorrect -> EmeraldSuccess
                    else -> Color(0xFFEF4444)
                }

                val statusText = when {
                    isUnattempted -> if (isHi) "छोड़ा गया (0)" else "Skipped (0.0)"
                    isCorrect -> "+${test.positiveMarks} Marks"
                    else -> "-${test.negativeMarks} Marks"
                }

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp),
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                val qSpentSecs = uiState.questionTimeSpentSeconds[question.id] ?: 0
                                val qTimeSuffix = if (qSpentSecs > 0) " • ⏱ ${qSpentSecs}s" else ""
                                Text(
                                    text = "Q${index + 1} • ${question.subject}$qTimeSuffix",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Navy900
                                )
                                Text(
                                    text = "${question.pyqYearTag} • ${diffBucket.labelEn} Level",
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = diffColor
                                )
                            }
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(4.dp))
                                    .background(statusColor.copy(alpha = 0.15f))
                                    .padding(horizontal = 6.dp, vertical = 2.dp)
                            ) {
                                Text(
                                    text = statusText,
                                    fontSize = 10.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = statusColor
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        val cleanScoreQEn = com.example.ui.components.ProfessionalQuestionFormatEngine.cleanQuestionTextEn(question.questionEn)
                        val cleanScoreQHi = com.example.ui.components.ProfessionalQuestionFormatEngine.cleanQuestionTextHi(question.questionHi)

                        Text(
                            text = "Q${index + 1} [EN]. $cleanScoreQEn",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Navy900,
                            lineHeight = 18.5.sp
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "प्रश्न ${index + 1} [हिंदी]. $cleanScoreQHi",
                            fontSize = 12.5.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF334155),
                            lineHeight = 18.sp
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        com.example.ui.components.ProfessionalStructuredExplanationCard(
                            question = question,
                            userSelectedIdx = userChoice,
                            cardTestTag = "scorecard_solution_card_${question.id}"
                        )
                    }
                }
            }
        }
    }
}

private fun formatStructuredExplanation(raw: String): List<String> {
    val lines = raw
        .replace("✅", "")
        .replace("📖", "")
        .replace("🎯", "")
        .replace("💡", "")
        .lines()
        .map { it.trim().removePrefix("•").trim() }
        .filter { line ->
            line.isNotBlank() &&
                !line.startsWith("Correct Option:", ignoreCase = true) &&
                !line.startsWith("सही विकल्प:") &&
                !line.equals("Complete Solution & Concept:", ignoreCase = true) &&
                !line.equals("संपूर्ण हल एवं स्पष्टीकरण:", ignoreCase = true) &&
                !line.equals("Why Other Options Are Incorrect:", ignoreCase = true) &&
                !line.equals("अन्य विकल्प गलत क्यों हैं:", ignoreCase = true)
        }

    val bullets = ArrayList<String>()
    for (line in lines) {
        val parts = line.split(Regex("(?<=\\.|।)\\s+(?=[A-Z0-9अ-ह])"))
        for (p in parts) {
            val cleaned = p.trim().removePrefix("•").trim()
            if (cleaned.isNotBlank()) {
                bullets.add(cleaned)
            }
        }
    }
    return if (bullets.isEmpty()) listOf(raw.trim()) else bullets
}
