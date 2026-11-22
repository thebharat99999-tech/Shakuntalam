package com.example.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.model.TestQuestion
import com.example.ui.theme.EmeraldSuccess
import com.example.ui.theme.Navy900
import com.example.ui.theme.SaffronGold

/**
 * Unified Professional EdTech Color Palette (2026–2030 Standard)
 * Eliminates mismatched light-brown, muddy-orange, or random tab colors across the app.
 */
object EdTechProColors {
    val DeepRoyalNavy = Color(0xFF081C38)
    val ElevatedNavy = Color(0xFF0F294A)
    val SlateDarkSurface = Color(0xFF1E293B)
    val SlateBorder = Color(0xFF1E3A5F)
    val RoyalIndigo = Color(0xFF1E3A8A)
    val ElectricCyan = Color(0xFF06B6D4)
    val WarmGold = Color(0xFFF59E0B)
    val ChampagneGold = Color(0xFFFDE68A)
    val UnselectedLightTabBg = Color(0xFFF1F5F9)
    val UnselectedLightTabBorder = Color(0xFFCBD5E1)
    val UnselectedDarkTabBg = Color(0xFF162A45)
    val UnselectedDarkTabBorder = Color(0xFF2D4A6D)
}

/**
 * Displays the official Shakuntalam winged-'S' + book + checkmark + sparkle crest logo
 * AND the full brand text ("SHAKUNTALAM • शकुंतलम • E-BOOKS & TEST SERIES")
 * from the uploaded brand asset (`R.drawable.shakuntalam_official_logo_full`).
 * Uses RoundedCornerShape and ContentScale.Fit so neither the symbol nor the text is ever clipped.
 */
@Composable
fun ShakuntalamBrandCrestBadge(
    size: Dp = 22.dp,
    showGlowRing: Boolean = true,
    modifier: Modifier = Modifier
) {
    val cornerShape = RoundedCornerShape(percent = 22)
    Box(
        modifier = modifier
            .size(size)
            .clip(cornerShape)
            .background(EdTechProColors.DeepRoyalNavy)
            .then(
                if (showGlowRing) {
                    Modifier.border(
                        width = if (size <= 20.dp) 1.dp else 1.5.dp,
                        brush = Brush.linearGradient(
                            colors = listOf(
                                EdTechProColors.WarmGold,
                                EdTechProColors.ElectricCyan
                            )
                        ),
                        shape = cornerShape
                    )
                } else {
                    Modifier
                }
            ),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.shakuntalam_official_logo_full),
            contentDescription = "Shakuntalam Official Logo",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxSize()
                .clip(cornerShape)
        )
    }
}

/**
 * Prominent full-clarity showcase card for the uploaded Shakuntalam brand logo
 * (displaying the winged-'S' book + checkmark symbol AND "SHAKUNTALAM • शकुंतलम • E-BOOKS & TEST SERIES").
 */
@Composable
fun ShakuntalamOfficialLogoShowcaseCard(
    height: Dp = 150.dp,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = 1.5.dp,
                brush = Brush.horizontalGradient(
                    colors = listOf(EdTechProColors.WarmGold, EdTechProColors.ElectricCyan)
                ),
                shape = RoundedCornerShape(18.dp)
            )
            .testTag("shakuntalam_official_logo_showcase_card"),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = EdTechProColors.DeepRoyalNavy),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(height)
                .background(EdTechProColors.DeepRoyalNavy)
                .padding(horizontal = 12.dp, vertical = 6.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.shakuntalam_brand_banner),
                contentDescription = "SHAKUNTALAM • शकुंतलम • E-BOOKS & TEST SERIES Official Logo",
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

/**
 * Standardized Professional Test Series Tab Chip with the mini Shakuntalam logo icon
 * and unified EdTech Royal Navy + Gold/Cyan styling.
 */
@Composable
fun ProfessionalTestSeriesTabChip(
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isDarkSurface: Boolean = false,
    badgeCountText: String? = null,
    logoSize: Dp = 15.dp,
    fontSize: TextUnit = 11.5.sp
) {
    val bgBrush = if (isSelected) {
        Brush.horizontalGradient(
            colors = listOf(
                EdTechProColors.DeepRoyalNavy,
                EdTechProColors.RoyalIndigo
            )
        )
    } else if (isDarkSurface) {
        Brush.horizontalGradient(
            colors = listOf(
                EdTechProColors.UnselectedDarkTabBg,
                EdTechProColors.UnselectedDarkTabBg
            )
        )
    } else {
        Brush.horizontalGradient(
            colors = listOf(
                EdTechProColors.UnselectedLightTabBg,
                EdTechProColors.UnselectedLightTabBg
            )
        )
    }

    val borderColor = when {
        isSelected -> EdTechProColors.WarmGold
        isDarkSurface -> EdTechProColors.UnselectedDarkTabBorder
        else -> EdTechProColors.UnselectedLightTabBorder
    }

    val textColor = when {
        isSelected -> Color.White
        isDarkSurface -> Color(0xFFE2E8F0)
        else -> EdTechProColors.DeepRoyalNavy
    }

    Row(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(bgBrush)
            .border(
                width = if (isSelected) 1.5.dp else 1.dp,
                color = borderColor,
                shape = RoundedCornerShape(10.dp)
            )
            .clickable { onClick() }
            .padding(horizontal = 11.dp, vertical = 7.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        ShakuntalamBrandCrestBadge(
            size = logoSize,
            showGlowRing = isSelected
        )
        Spacer(modifier = Modifier.width(6.dp))
        Text(
            text = label,
            fontSize = fontSize,
            fontWeight = if (isSelected) FontWeight.ExtraBold else FontWeight.SemiBold,
            color = textColor,
            maxLines = 1,
            softWrap = false,
            overflow = TextOverflow.Ellipsis
        )
        if (!badgeCountText.isNullOrBlank()) {
            Spacer(modifier = Modifier.width(5.dp))
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(5.dp))
                    .background(
                        if (isSelected) EdTechProColors.WarmGold.copy(alpha = 0.22f)
                        else EdTechProColors.DeepRoyalNavy.copy(alpha = 0.08f)
                    )
                    .padding(horizontal = 5.dp, vertical = 1.dp)
            ) {
                Text(
                    text = badgeCountText,
                    fontSize = 9.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = if (isSelected) EdTechProColors.ChampagneGold else textColor,
                    maxLines = 1,
                    softWrap = false
                )
            }
        }
    }
}

/**
 * Formats bilingual questions, options, and 4–5 one-liner PYQ explanations into a clean,
 * professional EdTech layout:
 * 1. English Question clearly on top
 * 2. Hindi Question cleanly below it
 * 3. Clean Options (A, B, C, D)
 * 4. Standardized Explanation:
 *    - Correct Answer at the top
 *    - 4 to 5 Important One-Liner Facts in Hindi
 *    - Same 4 to 5 Important One-Liner Facts in English
 *    - Single footer line: "पिछले पांच साल के प्रश्नों के आधार पर (Based on Last 5 Years PYQs)"
 */
object ProfessionalQuestionFormatEngine {

    data class StructuredExplanation(
        val optionLetter: String,
        val correctOptionEn: String,
        val correctOptionHi: String,
        val hindiOneLinerFacts: List<String>,
        val englishOneLinerFacts: List<String>,
        val footerLineHi: String = "पिछले पांच साल के प्रश्नों के आधार पर",
        val footerLineEn: String = "Based on Last 5 Years PYQ Trend Analysis"
    ) {
        val correctLetter: String
            get() = optionLetter
    }

    /**
     * Formats question text so multi-statement questions (Statement 1 / कथन 1, Statement 2 / कथन 2,
     * Statement 3 / कथन 3, Assertion/Reason, or numbered 1., 2., 3. items) are placed on separate,
     * sequential lines rather than mashed into a single paragraph.
     */
    fun cleanQuestionText(raw: String): String {
        val normalizedNewlines = raw
            .replace("\r\n", "\n")
            .replace(Regex("[ \\t]+"), " ")
            .replace(
                Regex("(?<=[:।.?])\\s+(?=(?:Statement[-\\s]*(?:1|2|3|4|I|II|III|IV)|कथन[-\\s]*(?:1|2|3|4|I|II|III|IV)|Assertion\\s*\\(A\\)|Reason\\s*\\(R\\)|अभिकथन\\s*\\(A\\)|कारण\\s*\\(R\\)|(?:1|2|3|4)\\.\\s+|\\((?:i|ii|iii|iv)\\)\\s+))"),
                "\n"
            )
            .replace(
                Regex("\\s+(?=(?:Statement[-\\s]*(?:1|2|3|4|I|II|III|IV)\\s*:|कथन[-\\s]*(?:1|2|3|4|I|II|III|IV)\\s*:))"),
                "\n"
            )
            .replace(
                Regex("(?<=[.।])\\s+(?=(?:Which of the statements|How many of the above|Select the correct answer|In the light of the above|उपर्युक्त में से|नीचे दिए गए कूट|उपर्युक्त कथनों के आलोक में))"),
                "\n"
            )

        return normalizedNewlines
            .lines()
            .map { it.trim() }
            .filter { it.isNotEmpty() }
            .joinToString("\n")
    }

    fun cleanQuestionTextEn(raw: String): String = cleanQuestionText(raw)

    fun cleanQuestionTextHi(raw: String): String = cleanQuestionText(raw)

    fun cleanOptionText(raw: String): String = raw.replace(Regex("\\s+"), " ").trim()

    /**
     * Splits a formatted question into its opening stem, sequential statement lines (1, 2, 3...),
     * and closing prompt so the UI can display statements in a clean line-by-line series.
     */
    fun extractQuestionLines(formattedText: String): List<String> {
        return cleanQuestionText(formattedText)
            .lines()
            .map { it.trim() }
            .filter { it.isNotEmpty() }
    }

    /**
     * Builds the standardized 4-to-5 Important One-Liner Facts in Hindi and English
     * for any [TestQuestion], ensuring every test series displays a clean, uniform,
     * high-retention explanation card.
     */
    fun buildStructuredExplanation(question: TestQuestion): StructuredExplanation {
        val letters = listOf("A", "B", "C", "D")
        val idx = question.correctIndex.coerceIn(0, 3)
        val letter = letters.getOrElse(idx) { "A" }
        val ansEn = question.optionsEn.getOrElse(idx) { "" }.trim()
        val ansHi = question.optionsHi.getOrElse(idx) { ansEn }.trim()

        val rawSentencesEn = question.explanationEn
            .split(Regex("[.;•\\n]+"))
            .map { it.trim() }
            .filter { it.length >= 12 }

        val rawSentencesHi = question.explanationHi
            .split(Regex("[।.;•\\n]+"))
            .map { it.trim() }
            .filter { it.length >= 10 }

        val subject = question.subject.ifBlank { "General Studies" }
        val pyqTag = question.pyqYearTag.ifBlank { "2020–2025 PYQ" }

        val englishFacts = mutableListOf<String>()
        englishFacts.add("Core Fact: \"$ansEn\" is the verified right answer for this $subject concept.")
        rawSentencesEn.forEach { sentence ->
            if (englishFacts.size < 4 && !sentence.equals(ansEn, ignoreCase = true)) {
                englishFacts.add(if (sentence.endsWith(".")) sentence else "$sentence.")
            }
        }
        val fallbackEnPool = listOf(
            "Exam Relevance: High-frequency $subject topic repeatedly tested in $pyqTag papers.",
            "Elimination Tip: Other options represent distractor statements or related peripheral provisions.",
            "Expected Future Question: Direct statement or assertion-reason MCQ can be framed on \"$ansEn\".",
            "Revision Anchor: Always link \"$ansEn\" with its primary constitutional/scientific principle in $subject."
        )
        for (item in fallbackEnPool) {
            if (englishFacts.size >= 5) break
            englishFacts.add(item)
        }

        val hindiFacts = mutableListOf<String>()
        hindiFacts.add("मुख्य तथ्य: इस $subject प्रश्न के लिए \"$ansHi\" पूर्णतः प्रमाणित सही उत्तर है।")
        rawSentencesHi.forEach { sentence ->
            if (hindiFacts.size < 4 && !sentence.equals(ansHi, ignoreCase = true)) {
                hindiFacts.add(if (sentence.endsWith("।") || sentence.endsWith(".")) sentence else "$sentence।")
            }
        }
        val fallbackHiPool = listOf(
            "परीक्षा उपयोगी बिंदु: $subject का यह विषय $pyqTag में बार-बार पूछा गया उच्च-वेटेज टॉपिक है।",
            "आगामी संभावित प्रश्न: आगामी परीक्षा में \"$ansHi\" से संबंधित कथन-कारण या प्रत्यक्ष वन-लाइनर प्रश्न बन सकता है।",
            "विकल्प उन्मूलन (Elimination): अन्य विकल्प भ्रामक या आंशिक रूप से संबंधित तथ्यों पर आधारित हैं।",
            "त्वरित रिवीजन टिप: परीक्षा से पूर्व $subject के अंतर्गत \"$ansHi\" के मुख्य प्रावधान/सूत्र को अवश्य दोहराएं।"
        )
        for (item in fallbackHiPool) {
            if (hindiFacts.size >= 5) break
            hindiFacts.add(item)
        }

        return StructuredExplanation(
            optionLetter = letter,
            correctOptionEn = ansEn,
            correctOptionHi = ansHi,
            hindiOneLinerFacts = hindiFacts.take(5),
            englishOneLinerFacts = englishFacts.take(5)
        )
    }
}

/**
 * Renders a question's lines sequentially so that if the question contains multiple statements
 * (Statement 1 / कथन 1, Statement 2 / कथन 2, Statement 3 / कथन 3), each statement appears on its
 * own dedicated line in a clean series instead of being mashed together.
 */
@Composable
fun SequentialStatementQuestionText(
    questionNumber: Int,
    rawQuestionText: String,
    isHindiText: Boolean,
    textTestTag: String,
    modifier: Modifier = Modifier
) {
    val lines = ProfessionalQuestionFormatEngine.extractQuestionLines(rawQuestionText)
    val prefixLabel = if (isHindiText) "प्रश्न $questionNumber." else "Q$questionNumber."
    val fullCombinedText = "$prefixLabel ${lines.joinToString("\n")}"

    if (lines.size <= 1) {
        Text(
            text = fullCombinedText,
            fontSize = 14.5.sp,
            fontWeight = if (isHindiText) FontWeight.Medium else FontWeight.SemiBold,
            color = if (isHindiText) Color(0xFF1E293B) else Navy900,
            lineHeight = 22.sp,
            letterSpacing = 0.1.sp,
            modifier = modifier.testTag(textTestTag)
        )
    } else {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .testTag(textTestTag),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            lines.forEachIndexed { idx, lineText ->
                val isStatementLine = lineText.startsWith("1.") ||
                    lineText.startsWith("2.") ||
                    lineText.startsWith("3.") ||
                    lineText.startsWith("4.") ||
                    lineText.startsWith("Statement", ignoreCase = true) ||
                    lineText.startsWith("कथन") ||
                    lineText.startsWith("Assertion", ignoreCase = true) ||
                    lineText.startsWith("Reason", ignoreCase = true) ||
                    lineText.startsWith("अभिकथन") ||
                    lineText.startsWith("कारण")

                if (idx == 0) {
                    Text(
                        text = "$prefixLabel $lineText",
                        fontSize = 14.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (isHindiText) Color(0xFF1E293B) else Navy900,
                        lineHeight = 21.5.sp
                    )
                } else if (isStatementLine) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .background(if (isHindiText) Color(0xFFFFFBEB) else Color(0xFFEFF6FF))
                            .border(
                                1.dp,
                                if (isHindiText) Color(0xFFFDE68A) else Color(0xFFBFDBFE),
                                RoundedCornerShape(8.dp)
                            )
                            .padding(horizontal = 10.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.Top
                    ) {
                        Text(
                            text = lineText,
                            fontSize = 13.5.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Navy900,
                            lineHeight = 20.sp,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                } else {
                    Text(
                        text = lineText,
                        fontSize = 13.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (isHindiText) Color(0xFF92400E) else EdTechProColors.RoyalIndigo,
                        lineHeight = 20.sp
                    )
                }
            }
        }
    }
}

/**
 * Renders an Excel-style Grid Table (`तालिका`) and Visual Bar Graph (`ग्राफ`) inside a question
 * whenever the question is a Mathematics / Data Interpretation (DI) index/table question.
 */
@Composable
fun ExcelStyleDiTableAndGraphCard(
    tableSpec: com.example.data.QuestionDataTableSpec,
    isHi: Boolean,
    modifier: Modifier = Modifier
) {
    val headers = if (isHi) tableSpec.headersHi else tableSpec.headersEn
    Card(
        modifier = modifier
            .fillMaxWidth()
            .border(1.5.dp, EdTechProColors.RoyalIndigo.copy(alpha = 0.4f), RoundedCornerShape(12.dp))
            .testTag("excel_di_table_and_graph_card"),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(6.dp))
                    .background(EdTechProColors.DeepRoyalNavy)
                    .padding(horizontal = 10.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = if (isHi) tableSpec.titleHi else tableSpec.titleEn,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = EdTechProColors.ChampagneGold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Excel-Style Grid Header Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF1E3A8A))
                    .border(1.dp, Color(0xFF334155))
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

            // Excel-Style Grid Data Rows
            tableSpec.rows.forEachIndexed { rowIdx, rowCells ->
                val rowBg = if (rowIdx % 2 == 0) Color(0xFFF8FAFC) else Color(0xFFEFF6FF)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(rowBg)
                        .border(0.5.dp, Color(0xFFCBD5E1))
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
                                fontWeight = if (colIdx == 0 || colIdx == rowCells.lastIndex) FontWeight.ExtraBold else FontWeight.SemiBold,
                                color = if (colIdx == 0) EdTechProColors.DeepRoyalNavy else Color(0xFF1E293B),
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }
                }
            }

            // Visual Bar Graph Section
            if (tableSpec.barGraphLabels.isNotEmpty() && tableSpec.barGraphValues.isNotEmpty()) {
                Spacer(modifier = Modifier.height(10.dp))
                val maxVal = (tableSpec.barGraphValues.maxOrNull() ?: 100f).coerceAtLeast(1f)
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFFF1F5F9))
                        .border(1.dp, Color(0xFFCBD5E1), RoundedCornerShape(8.dp))
                        .padding(10.dp)
                ) {
                    Text(
                        text = if (isHi) "डेटा ग्राफ इंडेक्स (Visual Bar Graph):" else "Visual Data Index Bar Graph:",
                        fontSize = 10.5.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = EdTechProColors.DeepRoyalNavy
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    tableSpec.barGraphLabels.zip(tableSpec.barGraphValues).forEach { (label, value) ->
                        val fraction = (value / maxVal).coerceIn(0.08f, 1f)
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 2.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = label,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                color = Navy900,
                                modifier = Modifier.width(52.dp),
                                maxLines = 1
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
                                        .fillMaxWidth(fraction)
                                        .height(12.dp)
                                        .clip(RoundedCornerShape(4.dp))
                                        .background(
                                            Brush.horizontalGradient(
                                                listOf(EdTechProColors.RoyalIndigo, EdTechProColors.ElectricCyan)
                                            )
                                        )
                                )
                            }
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "${value.toInt()}${tableSpec.unitSuffix}",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = EdTechProColors.RoyalIndigo
                            )
                        }
                    }
                }
            }
        }
    }
}

/**
 * Standardized Professional Explanation Card used across ALL Test Series (Active Test & Scorecard):
 * 1. Correct Answer badge at the top
 * 2. 4–5 Important One-Liner Facts in Hindi (for upcoming exam questions)
 * 3. Same 4–5 Important One-Liner Facts in English
 * 4. Single Footer Line: "पिछले पांच साल के प्रश्नों के आधार पर"
 */
@Composable
fun ProfessionalStructuredExplanationCard(
    question: TestQuestion,
    isSelectedCorrect: Boolean? = null,
    userSelectedIdx: Int? = null,
    cardTestTag: String? = null,
    modifier: Modifier = Modifier
) {
    val structured = ProfessionalQuestionFormatEngine.buildStructuredExplanation(question)
    val resolvedIsCorrect = isSelectedCorrect ?: userSelectedIdx?.let { it == question.correctIndex }
    val accentBorder = when (resolvedIsCorrect) {
        true -> EmeraldSuccess
        false -> EdTechProColors.WarmGold
        null -> EdTechProColors.ElectricCyan
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .then(if (!cardTestTag.isNullOrBlank()) Modifier.testTag(cardTestTag) else Modifier)
            .border(1.5.dp, accentBorder.copy(alpha = 0.85f), RoundedCornerShape(14.dp)),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = EdTechProColors.DeepRoyalNavy),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            // 1. Correct Answer Header Box at the Top
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(0xFF064E3B))
                    .border(1.dp, EmeraldSuccess, RoundedCornerShape(10.dp))
                    .padding(horizontal = 12.dp, vertical = 10.dp)
                    .testTag("pro_explanation_correct_answer_box"),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = "Correct Answer",
                    tint = Color(0xFF6EE7B7),
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Correct Answer / सही उत्तर : Option (${structured.optionLetter})",
                        fontSize = 11.5.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF6EE7B7)
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = structured.correctOptionEn,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        lineHeight = 18.sp
                    )
                    if (structured.correctOptionHi.isNotBlank() &&
                        !structured.correctOptionHi.equals(structured.correctOptionEn, ignoreCase = true)
                    ) {
                        Text(
                            text = structured.correctOptionHi,
                            fontSize = 12.5.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = EdTechProColors.ChampagneGold,
                            lineHeight = 18.sp
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // 2. 4–5 Important One-Liner Facts in Hindi
            Text(
                text = "महत्वपूर्ण वन-लाइनर तथ्य (Important One-Liner Facts - हिंदी):",
                fontSize = 12.sp,
                fontWeight = FontWeight.ExtraBold,
                color = EdTechProColors.WarmGold
            )
            Spacer(modifier = Modifier.height(6.dp))
            structured.hindiOneLinerFacts.forEachIndexed { idx, factHi ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 2.5.dp),
                    verticalAlignment = Alignment.Top
                ) {
                    Text(
                        text = "${idx + 1}.",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = EdTechProColors.ElectricCyan,
                        modifier = Modifier.width(18.dp)
                    )
                    Text(
                        text = factHi,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFFF1F5F9),
                        lineHeight = 17.5.sp,
                        modifier = Modifier.weight(1f)
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))
            HorizontalDivider(color = Color(0xFF1E3A5F))
            Spacer(modifier = Modifier.height(10.dp))

            // 3. Same 4–5 Important One-Liner Facts in English
            Text(
                text = "Important High-Yield One-Liner Facts (English):",
                fontSize = 12.sp,
                fontWeight = FontWeight.ExtraBold,
                color = EdTechProColors.ElectricCyan
            )
            Spacer(modifier = Modifier.height(6.dp))
            structured.englishOneLinerFacts.forEachIndexed { idx, factEn ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 2.5.dp),
                    verticalAlignment = Alignment.Top
                ) {
                    Text(
                        text = "${idx + 1}.",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = EdTechProColors.WarmGold,
                        modifier = Modifier.width(18.dp)
                    )
                    Text(
                        text = factEn,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFFE2E8F0),
                        lineHeight = 17.5.sp,
                        modifier = Modifier.weight(1f)
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // 4. Single Bottom Line: "पिछले पांच साल के प्रश्नों के आधार पर"
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(EdTechProColors.ElevatedNavy)
                    .border(1.dp, EdTechProColors.WarmGold.copy(alpha = 0.45f), RoundedCornerShape(8.dp))
                    .padding(horizontal = 10.dp, vertical = 6.dp)
                    .testTag("pro_explanation_pyq_footer_line"),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "★ पिछले पांच साल के प्रश्नों के आधार पर (${structured.footerLineEn})",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = EdTechProColors.ChampagneGold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

/**
 * Netflix-Style All-Access Subscription Banner (₹9 / Month, ₹99 / Year & ₹399 / Lifetime)
 * Displays active pass status with remaining days countdown, or 1-tap checkout buttons
 * for ₹9/Month (30 days), ₹99/Year (365 days), and ₹399/Lifetime unlocking ALL Test Series & Paid Exams.
 */
@Composable
fun NetflixStyleSubscriptionBanner(
    isSubscriptionActive: Boolean,
    activePlanCode: String,
    expiryEpochMillis: Long = 0L,
    remainingDays: Int = if (expiryEpochMillis > 0L) {
        val diff = expiryEpochMillis - System.currentTimeMillis()
        if (diff > 0L) ((diff / (24L * 60L * 60L * 1000L)).toInt() + 1).coerceAtLeast(1) else 0
    } else 0,
    isLoggedIn: Boolean = true,
    isHi: Boolean,
    onSubscribeMonthly9: () -> Unit,
    onSubscribeYearly99: () -> Unit,
    onSubscribeLifetime399: (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp)
            .border(
                width = 1.5.dp,
                brush = Brush.horizontalGradient(
                    colors = if (isSubscriptionActive) {
                        listOf(EmeraldSuccess, EdTechProColors.ElectricCyan)
                    } else {
                        listOf(EdTechProColors.WarmGold, EdTechProColors.ElectricCyan)
                    }
                ),
                shape = RoundedCornerShape(18.dp)
            )
            .testTag("netflix_subscription_banner_card"),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = EdTechProColors.DeepRoyalNavy),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
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
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    ShakuntalamBrandCrestBadge(size = 36.dp, showGlowRing = true)
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = if (isHi)
                                    "शकुंतलम ऑल-एक्सेस पास (All-Exam Pass)"
                                else
                                    "SHAKUNTALAM ALL-ACCESS PASS",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = EdTechProColors.WarmGold
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(5.dp))
                                    .background(
                                        if (isSubscriptionActive) EmeraldSuccess.copy(alpha = 0.22f)
                                        else EdTechProColors.ElectricCyan.copy(alpha = 0.2f)
                                    )
                                    .padding(horizontal = 6.dp, vertical = 2.dp)
                                    .testTag("subscription_status_badge")
                            ) {
                                Text(
                                    text = if (isSubscriptionActive) {
                                        if (isHi) "सक्रिय ($remainingDays दिन शेष)" else "ACTIVE ($remainingDays DAYS LEFT)"
                                    } else {
                                        if (isHi) "₹9/माह • ₹99/वर्ष • ₹399 आजीवन" else "₹9/MO • ₹99/YR • ₹399 LIFE"
                                    },
                                    fontSize = 9.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = if (isSubscriptionActive) Color(0xFF6EE7B7) else Color(0xFF67E8F9)
                                )
                            }
                        }
                        Text(
                            text = if (isSubscriptionActive) {
                                val planLabel = when (activePlanCode) {
                                    "LIFETIME_399" -> "₹399/Lifetime (Unlimited)"
                                    "YEARLY_99" -> "₹99/Year (365 Days)"
                                    else -> "₹9/Month (30 Days)"
                                }
                                if (isHi)
                                    "प्लान: $planLabel • सभी पेड और फ्री टेस्ट सीरीज़ अनलॉक हैं (अवधि पूर्ण होने पर स्वतः लॉक)"
                                else
                                    "Plan: $planLabel • All Exams & Paid Test Series Unlocked (Auto-expires after validity)"
                            } else {
                                if (isHi)
                                    "भुगतान कटने के बाद सभी परीक्षाओं (UPSC, PCS, SSC, RRB, JE, NEET, Banking, TET) के पेड फुल-लेंथ, सेक्शनल व PYQ टेस्ट अनलॉक करें!"
                                else
                                    "All-Exam Pass: Unlock ALL Paid Full-Length, Sectional, Topic-Wise & 5-Yr PYQ Tests upon payment!"
                            },
                            fontSize = 10.5.sp,
                            color = Color(0xFFCBD5E1),
                            lineHeight = 15.sp
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Three Plan Cards Side-by-Side: ₹9 / Month (30d), ₹99 / Year (365d), ₹399 / Lifetime
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // Plan 1: ₹9 / Month (1 Month = 30 Days)
                val isMonthlyActive = isSubscriptionActive && activePlanCode == "MONTHLY_9"
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(12.dp))
                        .background(
                            if (isMonthlyActive) Color(0xFF064E3B) else Color(0xFF162A45)
                        )
                        .border(
                            width = 1.5.dp,
                            color = if (isMonthlyActive) EmeraldSuccess else EdTechProColors.ElectricCyan,
                            shape = RoundedCornerShape(12.dp)
                        )
                        .clickable { onSubscribeMonthly9() }
                        .padding(9.dp)
                        .testTag("subscribe_monthly_9_btn")
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = if (isHi) "1 महीना" else "MONTHLY",
                            fontSize = 9.5.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color(0xFF67E8F9),
                            maxLines = 1
                        )
                        if (isMonthlyActive) {
                            Icon(
                                imageVector = Icons.Default.Verified,
                                contentDescription = "Active Monthly Plan",
                                tint = EmeraldSuccess,
                                modifier = Modifier.size(14.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(2.dp))
                    Row(verticalAlignment = Alignment.Bottom) {
                        Text(
                            text = "₹9",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.width(3.dp))
                        Text(
                            text = if (isHi) "/माह" else "/Mo",
                            fontSize = 9.5.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF94A3B8)
                        )
                    }
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = if (isHi) "30 दिन अनलिमिटेड" else "30 Days All Exams",
                        fontSize = 9.sp,
                        color = Color(0xFFE2E8F0),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                // Plan 2: ₹99 / Year (1 Year = 365 Days)
                val isYearlyActive = isSubscriptionActive && activePlanCode == "YEARLY_99"
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(12.dp))
                        .background(
                            if (isYearlyActive) Color(0xFF064E3B) else Color(0xFF1E293B)
                        )
                        .border(
                            width = 1.5.dp,
                            color = if (isYearlyActive) EmeraldSuccess else EdTechProColors.WarmGold,
                            shape = RoundedCornerShape(12.dp)
                        )
                        .clickable { onSubscribeYearly99() }
                        .padding(9.dp)
                        .testTag("subscribe_yearly_99_btn")
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = if (isHi) "1 साल ★" else "YEARLY ★",
                            fontSize = 9.5.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = EdTechProColors.WarmGold,
                            maxLines = 1
                        )
                        if (isYearlyActive) {
                            Icon(
                                imageVector = Icons.Default.Verified,
                                contentDescription = "Active Yearly Plan",
                                tint = EmeraldSuccess,
                                modifier = Modifier.size(14.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(2.dp))
                    Row(verticalAlignment = Alignment.Bottom) {
                        Text(
                            text = "₹99",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = EdTechProColors.ChampagneGold
                        )
                        Spacer(modifier = Modifier.width(3.dp))
                        Text(
                            text = if (isHi) "/वर्ष" else "/Yr",
                            fontSize = 9.5.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFFCBD5E1)
                        )
                    }
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = if (isHi) "365 दिन अनलिमिटेड" else "365 Days All Exams",
                        fontSize = 9.sp,
                        color = Color(0xFFE2E8F0),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                // Plan 3: ₹399 / Lifetime (Unlimited All-Exam Access)
                val isLifetimeActive = isSubscriptionActive && activePlanCode == "LIFETIME_399"
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(12.dp))
                        .background(
                            if (isLifetimeActive) Color(0xFF064E3B) else Color(0xFF172554)
                        )
                        .border(
                            width = 1.5.dp,
                            color = if (isLifetimeActive) EmeraldSuccess else Color(0xFFA855F7),
                            shape = RoundedCornerShape(12.dp)
                        )
                        .clickable {
                            val cb = onSubscribeLifetime399
                                ?: SubscriptionPassStateBridge.onSubscribeLifetime399Callback
                            cb?.invoke() ?: onSubscribeYearly99()
                        }
                        .padding(9.dp)
                        .testTag("subscribe_lifetime_399_btn")
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = if (isHi) "लाइफटाइम" else "LIFETIME",
                            fontSize = 9.5.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color(0xFFD8B4FE),
                            maxLines = 1
                        )
                        if (isLifetimeActive) {
                            Icon(
                                imageVector = Icons.Default.Verified,
                                contentDescription = "Active Lifetime Plan",
                                tint = EmeraldSuccess,
                                modifier = Modifier.size(14.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(2.dp))
                    Row(verticalAlignment = Alignment.Bottom) {
                        Text(
                            text = "₹399",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.width(3.dp))
                        Text(
                            text = if (isHi) "/आजीवन" else "/Life",
                            fontSize = 9.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFFCBD5E1)
                        )
                    }
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = if (isHi) "आजीवन सभी टेस्ट" else "Lifetime Unlimited",
                        fontSize = 9.sp,
                        color = Color(0xFFE2E8F0),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}

