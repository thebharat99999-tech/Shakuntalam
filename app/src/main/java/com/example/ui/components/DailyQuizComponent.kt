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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.model.AppLanguage
import com.example.model.TestQuestion
import com.example.ui.theme.EmeraldSuccess
import com.example.ui.theme.Navy900
import com.example.ui.theme.SaffronGold
import com.example.viewmodel.ShakuntalamUiState
import com.example.viewmodel.ShakuntalamViewModel
import kotlin.math.abs
import kotlin.random.Random

/**
 * Engine that provides a single high-yield practice question from a random subject each day
 * (or on-demand shuffle across diverse subjects) to drive daily student engagement.
 */
object DailyQuizEngine {

    val highYieldDailyQuestionPool: List<TestQuestion> = listOf(
        TestQuestion(
            id = 91001,
            subject = "Indian Polity & Constitution",
            pyqYearTag = "UPSC CSE / State PSC High-Yield PYQ",
            questionEn = "Which Constitutional Amendment Act added the Fundamental Duty requiring parents or guardians to provide opportunities for education to their child between the age of 6 and 14 years (Article 51A(k))?",
            questionHi = "किस संविधान संशोधन अधिनियम ने माता-पिता या अभिभावकों द्वारा 6 से 14 वर्ष की आयु के बीच के अपने बच्चे को शिक्षा के अवसर प्रदान करने का मौलिक कर्तव्य (अनुच्छेद 51A(k)) जोड़ा?",
            optionsEn = listOf(
                "42nd Constitutional Amendment Act, 1976",
                "44th Constitutional Amendment Act, 1978",
                "86th Constitutional Amendment Act, 2002",
                "91st Constitutional Amendment Act, 2003"
            ),
            optionsHi = listOf(
                "42वाँ संविधान संशोधन अधिनियम, 1976",
                "44वाँ संविधान संशोधन अधिनियम, 1978",
                "86वाँ संविधान संशोधन अधिनियम, 2002",
                "91वाँ संविधान संशोधन अधिनियम, 2003"
            ),
            correctIndex = 2,
            explanationEn = "The 86th Constitutional Amendment Act, 2002 inserted Article 21A (Right to Education as a Fundamental Right), modified Article 45 (DPSP for early childhood care), and added the 11th Fundamental Duty under Article 51A(k).",
            explanationHi = "86वें संविधान संशोधन अधिनियम, 2002 ने अनुच्छेद 21A (शिक्षा का अधिकार मौलिक अधिकार के रूप में) जोड़ा, अनुच्छेद 45 में संशोधन किया और अनुच्छेद 51A(k) के तहत 11वाँ मौलिक कर्तव्य जोड़ा।"
        ),
        TestQuestion(
            id = 91002,
            subject = "Modern Indian History",
            pyqYearTag = "UPSC / UPPCS / SSC CGL High-Yield PYQ",
            questionEn = "Who among the following presided over the historic Karachi Session of the Indian National Congress in March 1931, which adopted resolutions on Fundamental Rights and the National Economic Programme?",
            questionHi = "मार्च 1931 में भारतीय राष्ट्रीय कांग्रेस के ऐतिहासिक कराची अधिवेशन की अध्यक्षता किसने की थी, जिसमें मौलिक अधिकारों और राष्ट्रीय आर्थिक कार्यक्रम पर प्रस्ताव पारित किए गए थे?",
            optionsEn = listOf(
                "Jawaharlal Nehru",
                "Sardar Vallabhbhai Patel",
                "Subhas Chandra Bose",
                "Maulana Abul Kalam Azad"
            ),
            optionsHi = listOf(
                "जवाहरलाल नेहरू",
                "सरदार वल्लभभाई पटेल",
                "सुभाष चंद्र बोस",
                "मौलाना अबुल कलाम आज़ाद"
            ),
            correctIndex = 1,
            explanationEn = "Sardar Vallabhbhai Patel presided over the Karachi Session (March 1931) held shortly after the Gandhi-Irwin Pact. The resolution on Fundamental Rights and National Economic Programme was drafted by Jawaharlal Nehru.",
            explanationHi = "गांधी-इरविन समझौते के तुरंत बाद आयोजित कराची अधिवेशन (मार्च 1931) की अध्यक्षता सरदार वल्लभभाई पटेल ने की थी। मौलिक अधिकारों और राष्ट्रीय आर्थिक कार्यक्रम के प्रस्ताव का प्रारूप जवाहरलाल नेहरू ने तैयार किया था।"
        ),
        TestQuestion(
            id = 91003,
            subject = "Geography & Environment",
            pyqYearTag = "UPSC / State PSC / UGC NET High-Yield PYQ",
            questionEn = "Which of the following National Parks in India is the only floating National Park in the world, famous for 'Phumdis' (floating biomass) and the endangered Sangai deer?",
            questionHi = "भारत का निम्नलिखित में से कौन-सा राष्ट्रीय उद्यान विश्व का एकमात्र तैरता हुआ राष्ट्रीय उद्यान है, जो 'फुमदी' (तैरते हुए बायोमास) और लुप्तप्राय संगाई हिरण के लिए प्रसिद्ध है?",
            optionsEn = listOf(
                "Namdapha National Park (Arunachal Pradesh)",
                "Keibul Lamjao National Park (Manipur)",
                "Kaziranga National Park (Assam)",
                "Bhitarkanika National Park (Odisha)"
            ),
            optionsHi = listOf(
                "नामदफा राष्ट्रीय उद्यान (अरुणाचल प्रदेश)",
                "केइबुल लामजाओ राष्ट्रीय उद्यान (मणिपुर)",
                "काजीरंगा राष्ट्रीय उद्यान (असम)",
                "भितरकनिका राष्ट्रीय उद्यान (ओडिशा)"
            ),
            correctIndex = 1,
            explanationEn = "Keibul Lamjao National Park, located on Loktak Lake in Manipur, is the world's only floating national park. It is characterized by floating decomposed plant mats called 'Phumdis' and is the natural habitat of the brow-antlered Sangai deer.",
            explanationHi = "मणिपुर की लोकटक झील में स्थित केइबुल लामजाओ राष्ट्रीय उद्यान विश्व का एकमात्र तैरता हुआ राष्ट्रीय उद्यान है। यह 'फुमदी' नामक तैरती वनस्पति परतों और मणिपुर के राज्य पशु 'संगाई हिरण' का प्राकृतिक आवास है।"
        ),
        TestQuestion(
            id = 91004,
            subject = "Indian Economy & Banking",
            pyqYearTag = "UPSC / RBI / SSC CGL High-Yield PYQ",
            questionEn = "When the Reserve Bank of India (RBI) conducts an Open Market Operation (OMO) by purchasing Government Securities from the market, what is its immediate impact on systemic liquidity?",
            questionHi = "जब भारतीय रिज़र्व बैंक (RBI) बाज़ार से सरकारी प्रतिभूतियों (G-Secs) की खरीद करके ओपन मार्केट ऑपरेशन (OMO) करता है, तो बैंकिंग प्रणाली की तरलता (Liquidity) पर इसका तत्काल प्रभाव क्या होता है?",
            optionsEn = listOf(
                "It absorbs (reduces) rupee liquidity from the banking system",
                "It injects (increases) rupee liquidity into the banking system",
                "It directly increases the Statutory Liquidity Ratio (SLR)",
                "It leaves systemic money supply completely unchanged"
            ),
            optionsHi = listOf(
                "यह बैंकिंग प्रणाली से तरलता को सोखता (कम करता) है",
                "यह बैंकिंग प्रणाली में रुपये की तरलता को बढ़ाता (Inject करता) है",
                "यह सीधे वैधानिक तरलता अनुपात (SLR) को बढ़ाता है",
                "इससे मुद्रा आपूर्ति में कोई परिवर्तन नहीं होता"
            ),
            correctIndex = 1,
            explanationEn = "When the RBI buys Government Securities in Open Market Operations (OMO), it pays money to commercial banks/financial institutions, thereby injecting fresh rupee liquidity into the economy and easing short-term interest rates.",
            explanationHi = "जब RBI खुले बाजार की क्रियाओं (OMO) के तहत सरकारी प्रतिभूतियां खरीदता है, तो वह वाणिज्यिक बैंकों को भुगतान करता है, जिससे बैंकिंग प्रणाली में मुद्रा की तरलता (Liquidity) बढ़ती है।"
        ),
        TestQuestion(
            id = 91005,
            subject = "Physics (Mechanics & Modern Physics)",
            pyqYearTag = "IIT JEE / NEET (UG) High-Yield PYQ",
            questionEn = "In photoelectric effect experiments, if the frequency of incident radiation (above threshold frequency) is doubled while keeping intensity constant, how does the maximum kinetic energy of emitted photoelectrons change?",
            questionHi = "प्रकाश-विद्युत प्रभाव (Photoelectric Effect) में, यदि आपतित विकिरण की तीव्रता स्थिर रखते हुए उसकी आवृत्ति (देहली आवृत्ति से अधिक) को दोगुना कर दिया जाए, तो उत्सर्जित फोटोइलेक्ट्रॉनों की अधिकतम गतिज ऊर्जा में क्या परिवर्तन होगा?",
            optionsEn = listOf(
                "It remains exactly the same",
                "It becomes exactly double",
                "It becomes more than double of its initial value",
                "It becomes half of its initial value"
            ),
            optionsHi = listOf(
                "यह अपरिवर्तित रहती है",
                "यह ठीक दोगुनी हो जाती है",
                "यह अपने प्रारंभिक मान के दोगुने से भी अधिक हो जाती है",
                "यह आधी रह जाती है"
            ),
            correctIndex = 2,
            explanationEn = "By Einstein's photoelectric equation: K_max = hν - Φ. When frequency becomes 2ν, K'_max = 2hν - Φ = 2(hν - Φ) + Φ = 2K_max + Φ. Since work function Φ > 0, the new maximum kinetic energy is strictly greater than 2K_max (more than double).",
            explanationHi = "आइंस्टीन के प्रकाश-विद्युत समीकरण K_max = hν - Φ के अनुसार, आवृत्ति 2ν करने पर K'_max = 2hν - Φ = 2(hν - Φ) + Φ = 2K_max + Φ होता है। चूंकि कार्य फलन Φ > 0 है, इसलिए नई अधिकतम गतिज ऊर्जा प्रारंभिक मान के दोगुने से अधिक हो जाती है।"
        ),
        TestQuestion(
            id = 91006,
            subject = "Biology (Botany & Genetics)",
            pyqYearTag = "NEET (UG) / General Science High-Yield PYQ",
            questionEn = "Which cellular organelle possesses its own circular double-stranded DNA and 70S ribosomes, enabling it to synthesize some of its own proteins semi-autonomously in animal cells?",
            questionHi = "जंतु कोशिकाओं में किस कोशिकांग (Organelle) के पास अपना स्वयं का वृत्ताकार द्विरज्जुकी DNA और 70S राइबोसोम होता है, जिससे वह अपने कुछ प्रोटीनों का अर्ध-स्वायत्त रूप से संश्लेषण कर सकता है?",
            optionsEn = listOf(
                "Golgi Apparatus",
                "Lysosome",
                "Mitochondria",
                "Endoplasmic Reticulum"
            ),
            optionsHi = listOf(
                "गॉल्जी उपकरण (Golgi Apparatus)",
                "लाइसोसोम (Lysosome)",
                "माइटोकॉन्ड्रिया (Mitochondria)",
                "अंतर्द्रव्यी जालिका (Endoplasmic Reticulum)"
            ),
            correctIndex = 2,
            explanationEn = "Mitochondria (and plastids in plant cells) are semi-autonomous organelles containing their own circular dsDNA, RNA, and 70S prokaryotic-type ribosomes, allowing them to synthesize a subset of their own enzymes and structural proteins.",
            explanationHi = "माइटोकॉन्ड्रिया एक अर्ध-स्वायत्त (Semi-autonomous) कोशिकांग है जिसमें स्वयं का वृत्ताकार dsDNA और 70S राइबोसोम पाया जाता है, जो इसे अपने कुछ आवश्यक प्रोटीन स्वयं बनाने में सक्षम बनाता है।"
        ),
        TestQuestion(
            id = 91007,
            subject = "Child Development & Pedagogy (CDP)",
            pyqYearTag = "CTET / UPTET / UTET High-Yield PYQ",
            questionEn = "According to Lev Vygotsky's Socio-Cultural Theory of Cognitive Development, what is the 'Zone of Proximal Development' (ZPD)?",
            questionHi = "लेव वायगोत्स्की के संज्ञानात्मक विकास के सामाजिक-सांस्कृतिक सिद्धांत के अनुसार, 'समीपस्थ विकास का क्षेत्र' (Zone of Proximal Development - ZPD) क्या है?",
            optionsEn = listOf(
                "Tasks a child can already perform independently without any help",
                "The gap between what a learner can do independently and what they can achieve with guidance (scaffolding) from a More Knowledgeable Other",
                "Biological maturation stages fixed strictly by chronological age",
                "Rote memorization capacity tested through standardized summative exams"
            ),
            optionsHi = listOf(
                "वे कार्य जिन्हें बच्चा बिना किसी सहायता के स्वतंत्र रूप से कर सकता है",
                "बच्चे द्वारा स्वतंत्र रूप से किए जा सकने वाले कार्य और किसी अधिक जानकार व्यक्ति के मार्गदर्शन (Scaffolding) से किए जा सकने वाले कार्य के बीच का अंतर",
                "आयु के अनुसार निर्धारित जैविक परिपक्वता के चरण",
                "मानकीकृत परीक्षाओं द्वारा मापी गई रटने की क्षमता"
            ),
            correctIndex = 1,
            explanationEn = "Vygotsky defined the Zone of Proximal Development (ZPD) as the distance between a child's actual developmental level (independent problem-solving) and their potential developmental level achieved through temporary support ('Scaffolding') from an adult or capable peer.",
            explanationHi = "वायगोत्स्की के अनुसार ZPD बच्चे के वास्तविक विकास स्तर (स्वतंत्र समस्या समाधान) और किसी वयस्क या अधिक कुशल साथी के अस्थायी सहयोग (Scaffolding / मचान) से प्राप्त संभावित विकास स्तर के बीच का क्षेत्र है।"
        ),
        TestQuestion(
            id = 91008,
            subject = "UGC NET Paper 1 (Teaching & Research Aptitude)",
            pyqYearTag = "UGC NET JRF High-Yield PYQ",
            questionEn = "In educational assessment, which type of evaluation is conducted continuously DURING the instructional process to monitor student learning and provide immediate corrective feedback?",
            questionHi = "शैक्षिक मूल्यांकन में, शिक्षण प्रक्रिया के दौरान छात्रों के सीखने की निरंतर निगरानी करने और तत्काल सुधारात्मक फीडबैक प्रदान करने के लिए किस प्रकार का मूल्यांकन किया जाता है?",
            optionsEn = listOf(
                "Summative Evaluation",
                "Formative Evaluation",
                "Placement Evaluation",
                "Norm-Referenced Certification"
            ),
            optionsHi = listOf(
                "योगात्मक मूल्यांकन (Summative Evaluation)",
                "रचनात्मक / निर्माणात्मक मूल्यांकन (Formative Evaluation)",
                "स्थानन मूल्यांकन (Placement Evaluation)",
                "मानक-संदर्भित प्रमाणीकरण"
            ),
            correctIndex = 1,
            explanationEn = "Formative Evaluation ('Assessment FOR Learning') takes place continuously during instruction through quizzes, discussions, and feedback loops to identify learning gaps early, whereas Summative Evaluation occurs at the end of a course.",
            explanationHi = "रचनात्मक मूल्यांकन (Formative Evaluation) शिक्षण के दौरान निरंतर किया जाता है ताकि सीखने की कमियों को तुरंत पहचाना जा सके और सुधारात्मक फीडबैक दिया जा सके।"
        ),
        TestQuestion(
            id = 91009,
            subject = "Chemistry (Chemical Bonding & Coordination)",
            pyqYearTag = "IIT JEE / NEET High-Yield PYQ",
            questionEn = "According to VSEPR theory and hybridization analysis, what is the hybridization and molecular geometry of Xenon Tetrafluoride (XeF4)?",
            questionHi = "VSEPR सिद्धांत और संकरण विश्लेषण के अनुसार, ज़ेनॉन टेट्राफ्लोराइड (XeF4) का संकरण (Hybridization) और आणविक ज्यामिति (Molecular Geometry) क्या है?",
            optionsEn = listOf(
                "sp3 — Tetrahedral",
                "sp3d2 — Square Planar",
                "sp3d — Trigonal Bipyramidal",
                "dsp2 — Octahedral"
            ),
            optionsHi = listOf(
                "sp3 — चतुष्फलकीय (Tetrahedral)",
                "sp3d2 — वर्ग समतलीय (Square Planar)",
                "sp3d — त्रिकोणीय द्विपिरामिडीय",
                "dsp2 — अष्टफलकीय"
            ),
            correctIndex = 1,
            explanationEn = "In XeF4, central Xe has 8 valence electrons and forms 4 sigma bonds with F atoms, leaving 2 lone pairs (steric number = 4 + 2 = 6 -> sp3d2 hybridization). The 2 lone pairs occupy axial positions to minimize repulsion, resulting in a Square Planar molecular geometry.",
            explanationHi = "XeF4 में केंद्रीय Xe परमाणु पर 4 आबंध युग्म (Bond pairs) और 2 एकाकी इलेक्ट्रॉन युग्म (Lone pairs) होते हैं (स्टेरिक संख्या = 6, संकरण = sp3d2)। दोनों एकाकी युग्म अक्षीय स्थिति में रहते हैं, जिससे अणु की ज्यामिति वर्ग समतलीय (Square Planar) होती है।"
        ),
        TestQuestion(
            id = 91010,
            subject = "Quantitative Aptitude & Reasoning",
            pyqYearTag = "SSC CGL / CSAT / Banking High-Yield PYQ",
            questionEn = "If the compound interest on a certain sum at 10% per annum for 2 years is ₹1,050, what is the simple interest on the same sum at the same rate for the same period?",
            questionHi = "यदि किसी निश्चित धनराशि पर 10% वार्षिक ब्याज दर से 2 वर्ष का चक्रवृद्धि ब्याज (Compound Interest) ₹1,050 है, तो उसी धनराशि पर समान दर और समान अवधि के लिए साधारण ब्याज (Simple Interest) कितना होगा?",
            optionsEn = listOf(
                "₹950",
                "₹1,000",
                "₹1,020",
                "₹1,025"
            ),
            optionsHi = listOf(
                "₹950",
                "₹1,000",
                "₹1,020",
                "₹1,025"
            ),
            correctIndex = 1,
            explanationEn = "Effective 2-year Compound Interest rate at 10% p.a. = 10 + 10 + (10×10)/100 = 21%. Effective 2-year Simple Interest rate = 10 × 2 = 20%. Since 21% of Principal = ₹1,050, 1% = ₹50, so 20% Simple Interest = 20 × 50 = ₹1,000.",
            explanationHi = "10% वार्षिक दर से 2 वर्ष की प्रभावी चक्रवृद्धि ब्याज दर = 10 + 10 + (10×10)/100 = 21% और साधारण ब्याज दर = 20%। चूंकि मूलधन का 21% = ₹1,050 है (अर्थात 1% = ₹50), अतः 20% साधारण ब्याज = 20 × ₹50 = ₹1,000 होगा।"
        )
    )

    /**
     * Picks the question of the day deterministically for [dateIso] (YYYY-MM-DD),
     * or selects a question from a different random subject when [currentQuestionId] is excluded.
     */
    fun getQuestionForDate(dateIso: String = DailyStreakEngine.todayIsoDate()): TestQuestion {
        val cleanDate = dateIso.trim().ifBlank { DailyStreakEngine.todayIsoDate() }
        val hash = abs(cleanDate.hashCode())
        return highYieldDailyQuestionPool[hash % highYieldDailyQuestionPool.size]
    }

    /**
     * Returns a high-yield question from a different subject than [excludeQuestionId]
     * so tapping "New Random Subject Question" always rotates to a fresh subject.
     */
    fun getNextRandomSubjectQuestion(excludeQuestionId: Int, currentSubject: String = ""): TestQuestion {
        val differentSubjectCandidates = highYieldDailyQuestionPool.filter {
            it.id != excludeQuestionId && !it.subject.equals(currentSubject, ignoreCase = true)
        }
        val pool = if (differentSubjectCandidates.isNotEmpty()) {
            differentSubjectCandidates
        } else {
            highYieldDailyQuestionPool.filter { it.id != excludeQuestionId }
        }
        return if (pool.isNotEmpty()) {
            pool[Random.nextInt(pool.size)]
        } else {
            highYieldDailyQuestionPool.first()
        }
    }
}

/**
 * Interactive 'Daily Quiz' card displayed prominently on the Home Dashboard.
 * Presents a single high-yield practice question from a random subject each day,
 * allows selecting an option & submitting, and provides an immediate option to view
 * the detailed bilingual PYQ explanation after submission.
 */
@Composable
fun DailyQuizDashboardCard(
    uiState: ShakuntalamUiState,
    isHi: Boolean,
    onSelectOption: (Int) -> Unit,
    onSubmitAnswer: () -> Unit,
    onToggleExplanation: () -> Unit,
    onShuffleRandomSubject: () -> Unit,
    onOpenFullScreen: () -> Unit,
    modifier: Modifier = Modifier
) {
    val question = uiState.dailyQuizQuestion
    val selectedOption = uiState.dailyQuizSelectedOptionIndex
    val isSubmitted = uiState.isDailyQuizSubmitted
    val isExplanationVisible = uiState.isDailyQuizExplanationVisible
    val isCorrect = isSubmitted && selectedOption == question.correctIndex

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp)
            .border(
                width = 1.5.dp,
                color = when {
                    !isSubmitted -> SaffronGold.copy(alpha = 0.75f)
                    isCorrect -> EmeraldSuccess.copy(alpha = 0.85f)
                    else -> Color(0xFFF59E0B).copy(alpha = 0.85f)
                },
                shape = RoundedCornerShape(18.dp)
            )
            .testTag("daily_quiz_dashboard_card"),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            // Top Dark Navy Header Strip with Subject Badge + Shuffle + FullScreen
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Brush.horizontalGradient(
                            listOf(Navy900, Color(0xFF1E293B))
                        )
                    )
                    .padding(horizontal = 14.dp, vertical = 11.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    Box(
                        modifier = Modifier
                            .size(34.dp)
                            .clip(CircleShape)
                            .background(SaffronGold.copy(alpha = 0.2f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.AutoAwesome,
                            contentDescription = "Daily Quiz",
                            tint = SaffronGold,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Text(
                                text = if (isHi) "डेली क्विज़ (Daily High-Yield Quiz)" else "DAILY HIGH-YIELD QUIZ",
                                fontSize = 12.5.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = SaffronGold
                            )
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(4.dp))
                                    .background(EmeraldSuccess.copy(alpha = 0.22f))
                                    .padding(horizontal = 6.dp, vertical = 1.5.dp)
                            ) {
                                Text(
                                    text = "+50 XP",
                                    fontSize = 9.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color(0xFF6EE7B7)
                                )
                            }
                        }
                        Text(
                            text = "${question.subject} • ${question.pyqYearTag}",
                            fontSize = 10.5.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF38BDF8),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.testTag("daily_quiz_subject_badge")
                        )
                    }
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    // Shuffle Random Subject Button
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(7.dp))
                            .background(Color(0xFF334155))
                            .clickable { onShuffleRandomSubject() }
                            .padding(horizontal = 8.dp, vertical = 5.dp)
                            .testTag("daily_quiz_shuffle_subject_btn")
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Refresh,
                                contentDescription = "Shuffle Random Subject",
                                tint = SaffronGold,
                                modifier = Modifier.size(13.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = if (isHi) "नया विषय" else "New Subject",
                                fontSize = 9.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }
                    }

                    // Full-Screen Button
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(7.dp))
                            .background(SaffronGold)
                            .clickable { onOpenFullScreen() }
                            .padding(horizontal = 8.dp, vertical = 5.dp)
                            .testTag("daily_quiz_open_fullscreen_btn")
                    ) {
                        Text(
                            text = if (isHi) "विस्तार" else "Expand",
                            fontSize = 9.5.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Navy900
                        )
                    }
                }
            }

            // Question Body & Options
            Column(modifier = Modifier.padding(14.dp)) {
                Text(
                    text = question.questionEn,
                    fontSize = 13.5.sp,
                    fontWeight = FontWeight.Bold,
                    color = Navy900,
                    lineHeight = 19.sp,
                    modifier = Modifier.testTag("daily_quiz_question_text_en")
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = question.questionHi,
                    fontSize = 12.5.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF334155),
                    lineHeight = 18.sp,
                    modifier = Modifier.testTag("daily_quiz_question_text_hi")
                )

                Spacer(modifier = Modifier.height(12.dp))

                // 4 Interactive Options
                val optionLabels = listOf("A", "B", "C", "D")
                question.optionsEn.forEachIndexed { idx, optEn ->
                    val optHi = question.optionsHi.getOrNull(idx) ?: ""
                    val isSelected = selectedOption == idx
                    val isOptionCorrect = idx == question.correctIndex

                    val bgColor = when {
                        isSubmitted && isOptionCorrect -> Color(0xFFDCFCE7)
                        isSubmitted && isSelected && !isOptionCorrect -> Color(0xFFFEE2E2)
                        isSelected -> Color(0xFFEFF6FF)
                        else -> Color(0xFFF8FAFC)
                    }
                    val borderColor = when {
                        isSubmitted && isOptionCorrect -> EmeraldSuccess
                        isSubmitted && isSelected && !isOptionCorrect -> Color(0xFFEF4444)
                        isSelected -> Color(0xFF2563EB)
                        else -> Color(0xFFE2E8F0)
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(bgColor)
                            .border(
                                width = if (isSelected || (isSubmitted && isOptionCorrect)) 1.5.dp else 1.dp,
                                color = borderColor,
                                shape = RoundedCornerShape(10.dp)
                            )
                            .clickable(enabled = !isSubmitted) { onSelectOption(idx) }
                            .padding(horizontal = 12.dp, vertical = 9.dp)
                            .testTag("daily_quiz_option_$idx"),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(26.dp)
                                .clip(CircleShape)
                                .background(
                                    when {
                                        isSubmitted && isOptionCorrect -> EmeraldSuccess
                                        isSubmitted && isSelected && !isOptionCorrect -> Color(0xFFEF4444)
                                        isSelected -> Color(0xFF2563EB)
                                        else -> Color(0xFFE2E8F0)
                                    }
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = optionLabels.getOrElse(idx) { "${idx + 1}" },
                                fontSize = 11.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = if (isSelected || (isSubmitted && isOptionCorrect)) Color.White else Navy900
                            )
                        }

                        Spacer(modifier = Modifier.width(10.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = optEn,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Navy900
                            )
                            if (optHi.isNotBlank() && optHi != optEn) {
                                Text(
                                    text = optHi,
                                    fontSize = 11.sp,
                                    color = Color(0xFF475569)
                                )
                            }
                        }

                        if (isSubmitted && isOptionCorrect) {
                            Spacer(modifier = Modifier.width(6.dp))
                            Icon(
                                imageVector = Icons.Default.CheckCircle,
                                contentDescription = "Correct Option",
                                tint = EmeraldSuccess,
                                modifier = Modifier.size(18.dp)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                // Action Bar: Submit Button (before submission) OR Result Status + Show Detailed Explanation Toggle (after submission)
                if (!isSubmitted) {
                    Button(
                        onClick = onSubmitAnswer,
                        enabled = selectedOption != null,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Navy900,
                            disabledContainerColor = Color(0xFFCBD5E1)
                        ),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(44.dp)
                            .testTag("daily_quiz_submit_btn")
                    ) {
                        Text(
                            text = if (selectedOption == null) {
                                if (isHi) "उत्तर चुनें और सबमिट करें (Select an Option to Submit)" else "Select an Option to Submit Answer"
                            } else {
                                if (isHi) "उत्तर सबमिट करें (Submit Daily Quiz)" else "Submit Daily Quiz Answer"
                            },
                            fontSize = 12.5.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = if (selectedOption != null) SaffronGold else Color(0xFF64748B)
                        )
                    }
                } else {
                    // Post-Submission Result Banner + Immediate "Show Detailed Explanation" Option
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(if (isCorrect) Color(0xFFDCFCE7) else Color(0xFFFEF3C7))
                            .border(
                                width = 1.dp,
                                color = if (isCorrect) EmeraldSuccess else Color(0xFFF59E0B),
                                shape = RoundedCornerShape(10.dp)
                            )
                            .padding(horizontal = 12.dp, vertical = 9.dp)
                            .testTag("daily_quiz_submission_result_banner"),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.weight(1f)
                        ) {
                            Icon(
                                imageVector = if (isCorrect) Icons.Default.EmojiEvents else Icons.Default.LocalFireDepartment,
                                contentDescription = null,
                                tint = if (isCorrect) Color(0xFF15803D) else Color(0xFFB45309),
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Column {
                                Text(
                                    text = if (isCorrect) {
                                        if (isHi) "बिल्कुल सही उत्तर! (+50 XP व स्ट्रीक अपडेटेड)" else "Correct Answer! (+50 XP & Daily Streak Updated)"
                                    } else {
                                        val rightLetter = listOf("A", "B", "C", "D").getOrElse(question.correctIndex) { "A" }
                                        if (isHi) "सही विकल्प $rightLetter है (+25 XP भागीदारी बोनस)" else "Correct Option is $rightLetter (+25 XP Participation Bonus)"
                                    },
                                    fontSize = 11.5.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = if (isCorrect) Color(0xFF14532D) else Color(0xFF78350F)
                                )
                            }
                        }

                        // Option to see or hide the detailed explanation immediately after submission
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .background(Navy900)
                                .clickable { onToggleExplanation() }
                                .padding(horizontal = 10.dp, vertical = 6.dp)
                                .testTag("daily_quiz_explanation_toggle_btn")
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.Lightbulb,
                                    contentDescription = "Detailed Explanation",
                                    tint = SaffronGold,
                                    modifier = Modifier.size(13.dp)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = if (isExplanationVisible) {
                                        if (isHi) "व्याख्या छुपाएं ▲" else "Hide Explanation ▲"
                                    } else {
                                        if (isHi) "विस्तृत व्याख्या देखें ▼" else "See Explanation ▼"
                                    },
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = SaffronGold
                                )
                            }
                        }
                    }

                    // Expandable Detailed Bilingual PYQ Explanation Card (Correct Answer -> 4-5 Hindi One-Liner Facts -> 4-5 English One-Liner Facts -> पिछले पांच साल के प्रश्नों के आधार पर)
                    AnimatedVisibility(visible = isExplanationVisible) {
                        val structured = ProfessionalQuestionFormatEngine.buildStructuredExplanation(question)
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 10.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(EdTechProColors.DeepRoyalNavy)
                                .border(1.dp, SaffronGold.copy(alpha = 0.7f), RoundedCornerShape(12.dp))
                                .padding(12.dp)
                                .testTag("daily_quiz_explanation_box")
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.Lightbulb,
                                    contentDescription = null,
                                    tint = SaffronGold,
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = "Correct Answer / सही उत्तर: Option (${structured.correctLetter}) — ${structured.correctOptionEn} / ${structured.correctOptionHi}",
                                    fontSize = 11.5.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color(0xFF6EE7B7)
                                )
                            }
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "महत्वपूर्ण वन-लाइनर तथ्य (4–5 परीक्षा-उन्मुख बिंदु):\n" +
                                    structured.hindiOneLinerFacts.mapIndexed { i, f -> "${i + 1}. $f" }.joinToString("\n"),
                                fontSize = 11.5.sp,
                                color = Color(0xFFFEF3C7),
                                lineHeight = 17.5.sp,
                                modifier = Modifier.testTag("daily_quiz_explanation_text_hi")
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "Important High-Yield One-Liner Facts (4–5 Exam Points):\n" +
                                    structured.englishOneLinerFacts.mapIndexed { i, f -> "${i + 1}. $f" }.joinToString("\n"),
                                fontSize = 11.5.sp,
                                color = Color.White,
                                lineHeight = 17.5.sp,
                                modifier = Modifier.testTag("daily_quiz_explanation_text_en")
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(6.dp))
                                    .background(EdTechProColors.ElevatedNavy)
                                    .border(1.dp, SaffronGold, RoundedCornerShape(6.dp))
                                    .padding(horizontal = 10.dp, vertical = 6.dp)
                            ) {
                                Text(
                                    text = "★ ${structured.footerLineHi} (${structured.footerLineEn})",
                                    fontSize = 10.5.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = SaffronGold
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
 * Full-Screen 'Daily Quiz' Experience (AppScreen.DAILY_QUIZ) allowing focused daily practice,
 * immediate explanation review, streak status tracking, and random-subject rotation.
 */
@Composable
fun DailyQuizScreen(
    uiState: ShakuntalamUiState,
    viewModel: ShakuntalamViewModel
) {
    val isHi = uiState.selectedLanguage == AppLanguage.HINDI

    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Navy900)
                    .padding(horizontal = 14.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    IconButton(
                        onClick = { viewModel.navigateBack() },
                        modifier = Modifier
                            .size(36.dp)
                            .testTag("daily_quiz_screen_back_btn")
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                    Spacer(modifier = Modifier.width(6.dp))
                    Column {
                        Text(
                            text = if (isHi)
                                "डेली हाई-यील्ड क्विज़ (Daily Quiz Challenge)"
                            else
                                "Daily High-Yield Quiz Challenge",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White
                        )
                        Text(
                            text = if (isHi)
                                "प्रतिदिन एक यादृच्छिक विषय का उच्च-स्तरीय PYQ प्रश्न और तत्काल व्याख्या"
                            else
                                "1 High-Yield Question from a Random Subject Every Day",
                            fontSize = 11.sp,
                            color = SaffronGold
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFF1E293B))
                        .border(1.dp, SaffronGold.copy(alpha = 0.6f), RoundedCornerShape(8.dp))
                        .padding(horizontal = 10.dp, vertical = 5.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.LocalFireDepartment,
                            contentDescription = null,
                            tint = SaffronGold,
                            modifier = Modifier.size(14.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "${uiState.dailyStreakDays}d Streak • ${uiState.rewardPoints} XP",
                            fontSize = 10.5.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White
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
                .padding(innerPadding),
            contentPadding = PaddingValues(vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                DailyQuizDashboardCard(
                    uiState = uiState,
                    isHi = isHi,
                    onSelectOption = { opt -> viewModel.selectDailyQuizOption(opt) },
                    onSubmitAnswer = { viewModel.submitDailyQuizAnswer() },
                    onToggleExplanation = { viewModel.toggleDailyQuizExplanation() },
                    onShuffleRandomSubject = { viewModel.shuffleDailyQuizQuestion() },
                    onOpenFullScreen = {}
                )
            }

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    OutlinedButton(
                        onClick = { viewModel.shuffleDailyQuizQuestion() },
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .weight(1f)
                            .height(44.dp)
                            .testTag("daily_quiz_screen_next_random_btn")
                    ) {
                        Icon(
                            imageVector = Icons.Default.Refresh,
                            contentDescription = null,
                            tint = Navy900,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = if (isHi) "अगला रैंडम विषय प्रश्न" else "Next Random Subject Q",
                            fontSize = 11.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = Navy900
                        )
                    }

                    Button(
                        onClick = { viewModel.openPerformanceAnalytics() },
                        colors = ButtonDefaults.buttonColors(containerColor = Navy900),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .weight(1f)
                            .height(44.dp)
                    ) {
                        Text(
                            text = if (isHi) "प्रदर्शन ग्राफ देखें" else "Performance Charts",
                            fontSize = 11.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = SaffronGold
                        )
                    }
                }
            }
        }
    }
}
