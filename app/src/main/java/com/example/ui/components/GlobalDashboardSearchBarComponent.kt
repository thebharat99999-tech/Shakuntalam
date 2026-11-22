package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import com.example.data.ExamCatalogData
import com.example.data.local.entity.EbookDocumentEntity
import com.example.model.ContentType
import com.example.model.ExamCategory
import com.example.model.MockTest
import com.example.model.StudyItem
import com.example.ui.theme.EmeraldSuccess
import com.example.ui.theme.Navy800
import com.example.ui.theme.Navy900
import com.example.ui.theme.SaffronGold
import com.example.viewmodel.ShakuntalamUiState

/**
 * Lightweight searchable descriptor for any subject-wise or exam-specific Test Series across the app
 * so global search can find any test series by Title, Subject, or Exam Category instantaneously.
 */
data class SearchableTestSeriesEntry(
    val id: String,
    val testId: String,
    val examCategoryKey: String, // "upsc", "uppcs", "ukpsc", "bpsc", "upsssc", "uksssc", "ssc", "banking", "railways"
    val examDisplayEn: String,
    val examDisplayHi: String,
    val subjectNameEn: String,
    val subjectNameHi: String,
    val titleEn: String,
    val titleHi: String,
    val questionCount: Int,
    val keywords: String
)

object GlobalSearchIndexCatalog {
    val allSubjectTestSeries: List<SearchableTestSeriesEntry> = listOf(
        // SSC CGL / CHSL / CPO (8 Sections × 100 Qs)
        SearchableTestSeriesEntry(
            id = "ssc_gs_history",
            testId = "ssc_sec_history_100",
            examCategoryKey = "ssc",
            examDisplayEn = "SSC CGL / CHSL / CPO",
            examDisplayHi = "SSC CGL / CHSL / CPO",
            subjectNameEn = "GS: History & Culture",
            subjectNameHi = "जीएस: इतिहास एवं संस्कृति",
            titleEn = "SSC CGL/CHSL/CPO — GS: History & Culture (100 PYQs)",
            titleHi = "SSC CGL/CHSL/CPO — जीएस: इतिहास एवं कला-संस्कृति (100 प्रश्न)",
            questionCount = 100,
            keywords = "ssc cgl chsl cpo gs general studies history ancient medieval modern culture इतिहास"
        ),
        SearchableTestSeriesEntry(
            id = "ssc_gs_polity",
            testId = "ssc_sec_polity_100",
            examCategoryKey = "ssc",
            examDisplayEn = "SSC CGL / CHSL / CPO",
            examDisplayHi = "SSC CGL / CHSL / CPO",
            subjectNameEn = "GS: Polity & Constitution",
            subjectNameHi = "जीएस: राजव्यवस्था एवं संविधान",
            titleEn = "SSC CGL/CHSL/CPO — GS: Polity & Constitution (100 PYQs)",
            titleHi = "SSC CGL/CHSL/CPO — जीएस: राजव्यवस्था एवं संविधान (100 प्रश्न)",
            questionCount = 100,
            keywords = "ssc cgl chsl cpo gs general studies polity constitution articles amendments पॉलिटी संविधान राजव्यवस्था"
        ),
        SearchableTestSeriesEntry(
            id = "ssc_gs_geography",
            testId = "ssc_sec_geography_100",
            examCategoryKey = "ssc",
            examDisplayEn = "SSC CGL / CHSL / CPO",
            examDisplayHi = "SSC CGL / CHSL / CPO",
            subjectNameEn = "GS: Geography",
            subjectNameHi = "जीएस: भूगोल",
            titleEn = "SSC CGL/CHSL/CPO — GS: Indian & World Geography (100 PYQs)",
            titleHi = "SSC CGL/CHSL/CPO — जीएस: भारत एवं विश्व का भूगोल (100 प्रश्न)",
            questionCount = 100,
            keywords = "ssc cgl chsl cpo gs general studies geography rivers passes dams census भूगोल ज्योग्राफी"
        ),
        SearchableTestSeriesEntry(
            id = "ssc_gs_environment",
            testId = "ssc_sec_environment_100",
            examCategoryKey = "ssc",
            examDisplayEn = "SSC CGL / CHSL / CPO",
            examDisplayHi = "SSC CGL / CHSL / CPO",
            subjectNameEn = "GS: Environment & Ecology",
            subjectNameHi = "जीएस: पर्यावरण एवं पारिस्थितिकी",
            titleEn = "SSC CGL/CHSL/CPO — GS: Environment & Ecology (100 PYQs)",
            titleHi = "SSC CGL/CHSL/CPO — जीएस: पर्यावरण एवं पारिस्थितिकी (100 प्रश्न)",
            questionCount = 100,
            keywords = "ssc cgl chsl cpo gs general studies environment ecology biodiversity ramsar national parks पर्यावरण"
        ),
        SearchableTestSeriesEntry(
            id = "ssc_gs_economics",
            testId = "ssc_sec_economics_100",
            examCategoryKey = "ssc",
            examDisplayEn = "SSC CGL / CHSL / CPO",
            examDisplayHi = "SSC CGL / CHSL / CPO",
            subjectNameEn = "GS: Economics",
            subjectNameHi = "जीएस: अर्थव्यवस्था",
            titleEn = "SSC CGL/CHSL/CPO — GS: Economics & Five-Year Plans (100 PYQs)",
            titleHi = "SSC CGL/CHSL/CPO — जीएस: अर्थव्यवस्था एवं पंचवर्षीय योजनाएं (100 प्रश्न)",
            questionCount = 100,
            keywords = "ssc cgl chsl cpo gs general studies economics economy gdp rbi budget five year plans अर्थशास्त्र इकोनॉमिक्स"
        ),
        SearchableTestSeriesEntry(
            id = "ssc_reasoning",
            testId = "ssc_sec_reasoning_100",
            examCategoryKey = "ssc",
            examDisplayEn = "SSC CGL / CHSL / CPO",
            examDisplayHi = "SSC CGL / CHSL / CPO",
            subjectNameEn = "Reasoning Ability",
            subjectNameHi = "रीजनिंग (तर्कशक्ति)",
            titleEn = "SSC CGL/CHSL/CPO — General Intelligence & Reasoning (100 PYQs)",
            titleHi = "SSC CGL/CHSL/CPO — रीजनिंग / तर्कशक्ति (100 प्रश्न)",
            questionCount = 100,
            keywords = "ssc cgl chsl cpo reasoning general intelligence series coding decoding syllogism रीजनिंग तर्कशक्ति"
        ),
        SearchableTestSeriesEntry(
            id = "ssc_mathematics",
            testId = "ssc_sec_mathematics_100",
            examCategoryKey = "ssc",
            examDisplayEn = "SSC CGL / CHSL / CPO",
            examDisplayHi = "SSC CGL / CHSL / CPO",
            subjectNameEn = "Mathematics / Quantitative Aptitude",
            subjectNameHi = "मैथमेटिक्स / गणित",
            titleEn = "SSC CGL/CHSL/CPO — Mathematics / Quantitative Aptitude (100 PYQs)",
            titleHi = "SSC CGL/CHSL/CPO — मैथमेटिक्स / संख्यात्मक अभियोग्यता (100 प्रश्न)",
            questionCount = 100,
            keywords = "ssc cgl chsl cpo math maths mathematics quant quantitative aptitude algebra geometry trigonometry मैथ गणित"
        ),
        SearchableTestSeriesEntry(
            id = "ssc_english",
            testId = "ssc_sec_english_100",
            examCategoryKey = "ssc",
            examDisplayEn = "SSC CGL / CHSL / CPO",
            examDisplayHi = "SSC CGL / CHSL / CPO",
            subjectNameEn = "English Language & Comprehension",
            subjectNameHi = "इंग्लिश लैंग्वेज",
            titleEn = "SSC CGL/CHSL/CPO — English Language & Comprehension (100 PYQs)",
            titleHi = "SSC CGL/CHSL/CPO — इंग्लिश लैंग्वेज एवं कॉम्प्रिहेंशन (100 प्रश्न)",
            questionCount = 100,
            keywords = "ssc cgl chsl cpo english language comprehension grammar vocabulary idioms synonyms इंग्लिश अंग्रेज़ी"
        ),
        // UPSC CSE Prelims (7 Sections × 50 Qs)
        SearchableTestSeriesEntry(
            id = "upsc_history",
            testId = "upsc_sec_history_50",
            examCategoryKey = "upsc",
            examDisplayEn = "UPSC CSE Prelims",
            examDisplayHi = "UPSC सिविल सेवा",
            subjectNameEn = "History & Art-Culture",
            subjectNameHi = "इतिहास एवं कला-संस्कृति",
            titleEn = "UPSC CSE Prelims — History & Indian National Movement (50 PYQs)",
            titleHi = "UPSC प्रारंभिक परीक्षा — इतिहास एवं राष्ट्रीय आंदोलन (50 प्रश्न)",
            questionCount = 50,
            keywords = "upsc cse ias ips history ancient medieval modern art culture इतिहास यूपीएससी"
        ),
        SearchableTestSeriesEntry(
            id = "upsc_polity",
            testId = "upsc_sec_polity_50",
            examCategoryKey = "upsc",
            examDisplayEn = "UPSC CSE Prelims",
            examDisplayHi = "UPSC सिविल सेवा",
            subjectNameEn = "Indian Polity & Governance",
            subjectNameHi = "भारतीय राजव्यवस्था",
            titleEn = "UPSC CSE Prelims — Indian Polity & Constitution (50 PYQs)",
            titleHi = "UPSC प्रारंभिक परीक्षा — भारतीय राजव्यवस्था एवं संविधान (50 प्रश्न)",
            questionCount = 50,
            keywords = "upsc cse ias polity constitution governance parliament supreme court पॉलिटी राजव्यवस्था"
        ),
        SearchableTestSeriesEntry(
            id = "upsc_geography",
            testId = "upsc_sec_geography_50",
            examCategoryKey = "upsc",
            examDisplayEn = "UPSC CSE Prelims",
            examDisplayHi = "UPSC सिविल सेवा",
            subjectNameEn = "Indian & World Geography",
            subjectNameHi = "भारत एवं विश्व का भूगोल",
            titleEn = "UPSC CSE Prelims — Physical, Indian & World Geography (50 PYQs)",
            titleHi = "UPSC प्रारंभिक परीक्षा — भौतिक, भारत एवं विश्व भूगोल (50 प्रश्न)",
            questionCount = 50,
            keywords = "upsc cse ias geography physical indian world monsoon rivers भूगोल ज्योग्राफी"
        ),
        SearchableTestSeriesEntry(
            id = "upsc_economics",
            testId = "upsc_sec_economics_50",
            examCategoryKey = "upsc",
            examDisplayEn = "UPSC CSE Prelims",
            examDisplayHi = "UPSC सिविल सेवा",
            subjectNameEn = "Indian Economy",
            subjectNameHi = "भारतीय अर्थव्यवस्था",
            titleEn = "UPSC CSE Prelims — Indian Economy, Banking & Budget (50 PYQs)",
            titleHi = "UPSC प्रारंभिक परीक्षा — भारतीय अर्थव्यवस्था, बैंकिंग एवं बजट (50 प्रश्न)",
            questionCount = 50,
            keywords = "upsc cse ias economics economy rbi monetary fiscal budget इकोनॉमिक्स अर्थव्यवस्था"
        ),
        SearchableTestSeriesEntry(
            id = "upsc_environment",
            testId = "upsc_sec_environment_50",
            examCategoryKey = "upsc",
            examDisplayEn = "UPSC CSE Prelims",
            examDisplayHi = "UPSC सिविल सेवा",
            subjectNameEn = "Environment & Ecology",
            subjectNameHi = "पर्यावरण एवं पारिस्थितिकी",
            titleEn = "UPSC CSE Prelims — Environment, Ecology & Climate Change (50 PYQs)",
            titleHi = "UPSC प्रारंभिक परीक्षा — पर्यावरण, पारिस्थितिकी एवं जलवायु परिवर्तन (50 प्रश्न)",
            questionCount = 50,
            keywords = "upsc cse ias environment ecology biodiversity climate change ramsar पर्यावरण"
        ),
        SearchableTestSeriesEntry(
            id = "upsc_scitech",
            testId = "upsc_sec_scitech_50",
            examCategoryKey = "upsc",
            examDisplayEn = "UPSC CSE Prelims",
            examDisplayHi = "UPSC सिविल सेवा",
            subjectNameEn = "Science & Technology",
            subjectNameHi = "विज्ञान एवं प्रौद्योगिकी",
            titleEn = "UPSC CSE Prelims — Science & Technology (ISRO, Biotech, AI) (50 PYQs)",
            titleHi = "UPSC प्रारंभिक परीक्षा — विज्ञान एवं प्रौद्योगिकी (50 प्रश्न)",
            questionCount = 50,
            keywords = "upsc cse ias science technology scitech space isro biotech विज्ञान साइंस"
        ),
        SearchableTestSeriesEntry(
            id = "upsc_ir_ca",
            testId = "upsc_sec_ir_ca_50",
            examCategoryKey = "upsc",
            examDisplayEn = "UPSC CSE Prelims",
            examDisplayHi = "UPSC सिविल सेवा",
            subjectNameEn = "Current Affairs & International Relations",
            subjectNameHi = "समसामयिकी एवं अंतर्राष्ट्रीय संबंध",
            titleEn = "UPSC CSE Prelims — Current Affairs & IR (50 PYQs)",
            titleHi = "UPSC प्रारंभिक परीक्षा — समसामयिकी एवं अंतर्राष्ट्रीय संबंध (50 प्रश्न)",
            questionCount = 50,
            keywords = "upsc cse ias current affairs international relations ir करंट अफेयर्स समसामयिकी"
        ),
        // Banking, UPPCS, UKPSC, BPSC, UPSSSC, UKSSSC, Railways Flagship Entries
        SearchableTestSeriesEntry(
            id = "banking_po_pyq",
            testId = "pyq_banking_po_2025",
            examCategoryKey = "banking",
            examDisplayEn = "Banking (IBPS / SBI / RBI)",
            examDisplayHi = "बैंकिंग (IBPS / SBI / RBI)",
            subjectNameEn = "Quant, Reasoning Puzzles, English & Banking Awareness",
            subjectNameHi = "क्वांट, रीजनिंग पज़ल्स, इंग्लिश एवं बैंकिंग अवेयरनेस",
            titleEn = "Banking IBPS PO / SBI PO / RBI Grade B — Prelims & Mains PYQ Test Series",
            titleHi = "बैंकिंग IBPS PO / SBI PO / RBI Grade B — प्रीलिम्स एवं मेन्स टेस्ट सीरीज़",
            questionCount = 10,
            keywords = "banking bank ibps po clerk sbi po rbi grade b nabard quant di puzzles reasoning english बैंकिंग"
        ),
        SearchableTestSeriesEntry(
            id = "uppcs_up_ca",
            testId = "uppcs_sec_up_ca_50",
            examCategoryKey = "uppcs",
            examDisplayEn = "UPPCS Prelims",
            examDisplayHi = "UPPCS प्रारंभिक परीक्षा",
            subjectNameEn = "UP Special & Current Affairs",
            subjectNameHi = "यूपी विशेष एवं करंट अफेयर्स",
            titleEn = "UPPCS Prelims — UP Special GK, Budget & Current Affairs (50 PYQs)",
            titleHi = "UPPCS प्रारंभिक परीक्षा — उत्तर प्रदेश विशेष एवं करंट अफेयर्स (50 प्रश्न)",
            questionCount = 50,
            keywords = "uppcs uppsc state psc up special uttar pradesh gk current affairs यूपीपीसीएस"
        ),
        SearchableTestSeriesEntry(
            id = "ukpsc_special_100",
            testId = "ukpsc_sec_uttarakhand_special_100",
            examCategoryKey = "ukpsc",
            examDisplayEn = "UKPSC Prelims",
            examDisplayHi = "UKPSC (उत्तराखंड पीसीएस)",
            subjectNameEn = "Uttarakhand Special GK",
            subjectNameHi = "उत्तराखंड विशेष सामान्य ज्ञान",
            titleEn = "UKPSC Prelims — ★ Uttarakhand Special Top 100 PYQs",
            titleHi = "UKPSC प्रारंभिक परीक्षा — ★ उत्तराखंड विशेष टॉप 100 प्रश्न",
            questionCount = 100,
            keywords = "ukpsc state psc uttarakhand special gk history geography उत्तराखंड पीसीएस"
        ),
        SearchableTestSeriesEntry(
            id = "bpsc_bihar_special",
            testId = "bpsc_sec_bihar_special_100",
            examCategoryKey = "bpsc",
            examDisplayEn = "BPSC CCE Prelims",
            examDisplayHi = "BPSC (बिहार पीसीएस)",
            subjectNameEn = "Bihar Special GK & History",
            subjectNameHi = "बिहार विशेष सामान्य ज्ञान",
            titleEn = "BPSC 70th/71st Prelims — ★ Bihar Special Top 100 PYQs",
            titleHi = "BPSC प्रारंभिक परीक्षा — ★ बिहार विशेष टॉप 100 प्रश्न",
            questionCount = 100,
            keywords = "bpsc state psc bihar special gk history rivers budget बिहार पीसीएस"
        ),
        SearchableTestSeriesEntry(
            id = "upsssc_up_special_250",
            testId = "upsssc_sec_up_special_250",
            examCategoryKey = "upsssc",
            examDisplayEn = "UPSSSC (PET / VDO / Lekhpal)",
            examDisplayHi = "UPSSSC (PET / VDO / लेखपाल)",
            subjectNameEn = "UP Special Best 250 Qs",
            subjectNameHi = "यूपी स्पेशल सर्वश्रेष्ठ 250 प्रश्न",
            titleEn = "UPSSSC PET/VDO/Lekhpal — ★ UP Special Best 250 PYQs",
            titleHi = "UPSSSC PET/VDO/लेखपाल — ★ यूपी स्पेशल सर्वश्रेष्ठ 250 प्रश्न",
            questionCount = 250,
            keywords = "upsssc pet vdo lekhpal up special computer di यूपी ट्रिपल एससी"
        ),
        SearchableTestSeriesEntry(
            id = "uksssc_uk_special_250",
            testId = "uksssc_sec_uttarakhand_special_250",
            examCategoryKey = "uksssc",
            examDisplayEn = "UKSSSC (Group C & D)",
            examDisplayHi = "UKSSSC (समूह 'ग' एवं 'घ')",
            subjectNameEn = "Uttarakhand Special Best 250 Qs",
            subjectNameHi = "उत्तराखंड स्पेशल सर्वश्रेष्ठ 250 प्रश्न",
            titleEn = "UKSSSC Group C/D — ★ Uttarakhand Special Best 250 PYQs",
            titleHi = "UKSSSC समूह ग/घ — ★ उत्तराखंड स्पेशल सर्वश्रेष्ठ 250 प्रश्न",
            questionCount = 250,
            keywords = "uksssc ukssc group c vdo patwari uttarakhand special hindi computer reasoning"
        ),
        SearchableTestSeriesEntry(
            id = "railways_ntpc_pyq",
            testId = "pyq_railway_ntpc_2025",
            examCategoryKey = "railways",
            examDisplayEn = "Railways (RRB NTPC & Group D)",
            examDisplayHi = "रेलवे (RRB NTPC एवं ग्रुप D)",
            subjectNameEn = "General Science, Math & Reasoning",
            subjectNameHi = "सामान्य विज्ञान, गणित एवं रीजनिंग",
            titleEn = "Railways RRB NTPC, Group D & ALP — CBT PYQ Test Series",
            titleHi = "रेलवे RRB NTPC, Group D एवं ALP — CBT टेस्ट सीरीज़",
            questionCount = 10,
            keywords = "railways railway rrb ntpc group d alp science physics chemistry math reasoning रेलवे"
        ),
        // IIT JEE Main (5 Subjects × 100 Qs) & IIT JEE Advanced (5 Subjects × 100 Qs)
        SearchableTestSeriesEntry(
            id = "jee_main_physics",
            testId = "jee_main_sec_physics_100",
            examCategoryKey = "iit_jee",
            examDisplayEn = "IIT JEE Main",
            examDisplayHi = "IIT JEE Main",
            subjectNameEn = "Physics (भौतिकी)",
            subjectNameHi = "भौतिक विज्ञान (Physics)",
            titleEn = "IIT JEE Main — Section 1: Physics (100 5-Yr PYQs)",
            titleHi = "IIT JEE Main — खंड 1: भौतिक विज्ञान (100 प्रश्न)",
            questionCount = 100,
            keywords = "iit jee main physics mechanics electrostatics optics modern physics आईआईटी जेईई मेन भौतिकी"
        ),
        SearchableTestSeriesEntry(
            id = "jee_main_physical_chem",
            testId = "jee_main_sec_physical_chem_100",
            examCategoryKey = "iit_jee",
            examDisplayEn = "IIT JEE Main",
            examDisplayHi = "IIT JEE Main",
            subjectNameEn = "Physical Chemistry",
            subjectNameHi = "भौतिक रसायन",
            titleEn = "IIT JEE Main — Section 2: Physical Chemistry (100 5-Yr PYQs)",
            titleHi = "IIT JEE Main — खंड 2: भौतिक रसायन (100 प्रश्न)",
            questionCount = 100,
            keywords = "iit jee main physical chemistry thermodynamics kinetics electrochemistry भौतिक रसायन"
        ),
        SearchableTestSeriesEntry(
            id = "jee_main_organic_chem",
            testId = "jee_main_sec_organic_chem_100",
            examCategoryKey = "iit_jee",
            examDisplayEn = "IIT JEE Main",
            examDisplayHi = "IIT JEE Main",
            subjectNameEn = "Organic Chemistry",
            subjectNameHi = "कार्बनिक रसायन",
            titleEn = "IIT JEE Main — Section 3: Organic Chemistry (100 5-Yr PYQs)",
            titleHi = "IIT JEE Main — खंड 3: कार्बनिक रसायन (100 प्रश्न)",
            questionCount = 100,
            keywords = "iit jee main organic chemistry goc hydrocarbons aldehydes amines कार्बनिक रसायन"
        ),
        SearchableTestSeriesEntry(
            id = "jee_main_inorganic_chem",
            testId = "jee_main_sec_inorganic_chem_100",
            examCategoryKey = "iit_jee",
            examDisplayEn = "IIT JEE Main",
            examDisplayHi = "IIT JEE Main",
            subjectNameEn = "Inorganic Chemistry",
            subjectNameHi = "अकार्बनिक रसायन",
            titleEn = "IIT JEE Main — Section 4: Inorganic Chemistry (100 5-Yr PYQs)",
            titleHi = "IIT JEE Main — खंड 4: अकार्बनिक रसायन (100 प्रश्न)",
            questionCount = 100,
            keywords = "iit jee main inorganic chemistry chemical bonding coordination p block d block अकार्बनिक रसायन"
        ),
        SearchableTestSeriesEntry(
            id = "jee_main_mathematics",
            testId = "jee_main_sec_mathematics_100",
            examCategoryKey = "iit_jee",
            examDisplayEn = "IIT JEE Main",
            examDisplayHi = "IIT JEE Main",
            subjectNameEn = "Mathematics (गणित)",
            subjectNameHi = "गणित (Mathematics)",
            titleEn = "IIT JEE Main — Section 5: Mathematics (100 5-Yr PYQs)",
            titleHi = "IIT JEE Main — खंड 5: गणित (100 प्रश्न)",
            questionCount = 100,
            keywords = "iit jee main mathematics math calculus algebra matrices vectors probability जेईई गणित"
        ),
        SearchableTestSeriesEntry(
            id = "jee_adv_physics",
            testId = "jee_adv_sec_physics_100",
            examCategoryKey = "iit_jee",
            examDisplayEn = "IIT JEE Advanced",
            examDisplayHi = "IIT JEE Advanced",
            subjectNameEn = "Advanced Physics",
            subjectNameHi = "एडवांस्ड भौतिक विज्ञान",
            titleEn = "IIT JEE Advanced — Section 1: Physics (100 5-Yr PYQs)",
            titleHi = "IIT JEE Advanced — खंड 1: भौतिक विज्ञान (100 प्रश्न)",
            questionCount = 100,
            keywords = "iit jee advanced physics rotational mechanics electrodynamics optics एडवांस्ड भौतिकी"
        ),
        SearchableTestSeriesEntry(
            id = "jee_adv_physical_chem",
            testId = "jee_adv_sec_physical_chem_100",
            examCategoryKey = "iit_jee",
            examDisplayEn = "IIT JEE Advanced",
            examDisplayHi = "IIT JEE Advanced",
            subjectNameEn = "Advanced Physical Chemistry",
            subjectNameHi = "एडवांस्ड भौतिक रसायन",
            titleEn = "IIT JEE Advanced — Section 2: Physical Chemistry (100 5-Yr PYQs)",
            titleHi = "IIT JEE Advanced — खंड 2: भौतिक रसायन (100 प्रश्न)",
            questionCount = 100,
            keywords = "iit jee advanced physical chemistry real gases crystallography electrochemistry"
        ),
        SearchableTestSeriesEntry(
            id = "jee_adv_organic_chem",
            testId = "jee_adv_sec_organic_chem_100",
            examCategoryKey = "iit_jee",
            examDisplayEn = "IIT JEE Advanced",
            examDisplayHi = "IIT JEE Advanced",
            subjectNameEn = "Advanced Organic Chemistry",
            subjectNameHi = "एडवांस्ड कार्बनिक रसायन",
            titleEn = "IIT JEE Advanced — Section 3: Organic Chemistry (100 5-Yr PYQs)",
            titleHi = "IIT JEE Advanced — खंड 3: कार्बनिक रसायन (100 प्रश्न)",
            questionCount = 100,
            keywords = "iit jee advanced organic chemistry stereochemistry rearrangements reaction mechanism"
        ),
        SearchableTestSeriesEntry(
            id = "jee_adv_inorganic_chem",
            testId = "jee_adv_sec_inorganic_chem_100",
            examCategoryKey = "iit_jee",
            examDisplayEn = "IIT JEE Advanced",
            examDisplayHi = "IIT JEE Advanced",
            subjectNameEn = "Advanced Inorganic Chemistry",
            subjectNameHi = "एडवांस्ड अकार्बनिक रसायन",
            titleEn = "IIT JEE Advanced — Section 4: Inorganic Chemistry (100 5-Yr PYQs)",
            titleHi = "IIT JEE Advanced — खंड 4: अकार्बनिक रसायन (100 प्रश्न)",
            questionCount = 100,
            keywords = "iit jee advanced inorganic chemistry qualitative analysis coordination metallurgy"
        ),
        SearchableTestSeriesEntry(
            id = "jee_adv_mathematics",
            testId = "jee_adv_sec_mathematics_100",
            examCategoryKey = "iit_jee",
            examDisplayEn = "IIT JEE Advanced",
            examDisplayHi = "IIT JEE Advanced",
            subjectNameEn = "Advanced Mathematics",
            subjectNameHi = "एडवांस्ड गणित",
            titleEn = "IIT JEE Advanced — Section 5: Mathematics (100 5-Yr PYQs)",
            titleHi = "IIT JEE Advanced — खंड 5: गणित (100 प्रश्न)",
            questionCount = 100,
            keywords = "iit jee advanced mathematics calculus leibniz complex numbers vectors probability"
        ),
        // NEET (UG) Medical Entrance (6 Subjects × 100 Qs = 600 PYQs)
        SearchableTestSeriesEntry(
            id = "neet_physics",
            testId = "neet_sec_physics_100",
            examCategoryKey = "neet",
            examDisplayEn = "NEET (UG) Medical",
            examDisplayHi = "नीट यूजी (NEET)",
            subjectNameEn = "NEET Physics",
            subjectNameHi = "नीट भौतिक विज्ञान",
            titleEn = "NEET (UG) — Section 1: Physics (100 5-Yr NCERT PYQs)",
            titleHi = "NEET (UG) — खंड 1: भौतिक विज्ञान (100 NCERT PYQ प्रश्न)",
            questionCount = 100,
            keywords = "neet ug medical physics mechanics optics electrostatics modern physics logic gates भौतिकी नीट"
        ),
        SearchableTestSeriesEntry(
            id = "neet_physical_chem",
            testId = "neet_sec_physical_chem_100",
            examCategoryKey = "neet",
            examDisplayEn = "NEET (UG) Medical",
            examDisplayHi = "नीट यूजी (NEET)",
            subjectNameEn = "NEET Physical Chemistry",
            subjectNameHi = "नीट भौतिक रसायन",
            titleEn = "NEET (UG) — Section 2: Physical Chemistry (100 5-Yr NCERT PYQs)",
            titleHi = "NEET (UG) — खंड 2: भौतिक रसायन (100 NCERT PYQ प्रश्न)",
            questionCount = 100,
            keywords = "neet ug medical physical chemistry mole concept equilibrium thermodynamics electrochemistry kinetics नीट भौतिक रसायन"
        ),
        SearchableTestSeriesEntry(
            id = "neet_organic_chem",
            testId = "neet_sec_organic_chem_100",
            examCategoryKey = "neet",
            examDisplayEn = "NEET (UG) Medical",
            examDisplayHi = "नीट यूजी (NEET)",
            subjectNameEn = "NEET Organic Chemistry",
            subjectNameHi = "नीट कार्बनिक रसायन",
            titleEn = "NEET (UG) — Section 3: Organic Chemistry (100 5-Yr NCERT PYQs)",
            titleHi = "NEET (UG) — खंड 3: कार्बनिक रसायन (100 NCERT PYQ प्रश्न)",
            questionCount = 100,
            keywords = "neet ug medical organic chemistry goc hydrocarbons haloalkanes phenols carbonyls amines biomolecules नीट कार्बनिक रसायन"
        ),
        SearchableTestSeriesEntry(
            id = "neet_inorganic_chem",
            testId = "neet_sec_inorganic_chem_100",
            examCategoryKey = "neet",
            examDisplayEn = "NEET (UG) Medical",
            examDisplayHi = "नीट यूजी (NEET)",
            subjectNameEn = "NEET Inorganic Chemistry",
            subjectNameHi = "नीट अकार्बनिक रसायन",
            titleEn = "NEET (UG) — Section 4: Inorganic Chemistry (100 5-Yr NCERT PYQs)",
            titleHi = "NEET (UG) — खंड 4: अकार्बनिक रसायन (100 NCERT PYQ प्रश्न)",
            questionCount = 100,
            keywords = "neet ug medical inorganic chemistry periodic table chemical bonding vsepr mot coordination d block p block नीट अकार्बनिक रसायन"
        ),
        SearchableTestSeriesEntry(
            id = "neet_botany",
            testId = "neet_sec_botany_100",
            examCategoryKey = "neet",
            examDisplayEn = "NEET (UG) Medical",
            examDisplayHi = "नीट यूजी (NEET)",
            subjectNameEn = "NEET Biology: Botany",
            subjectNameHi = "नीट जीव विज्ञान: वनस्पति विज्ञान",
            titleEn = "NEET (UG) — Section 5: Biology — Botany (100 5-Yr NCERT PYQs)",
            titleHi = "NEET (UG) — खंड 5: जीव विज्ञान — वनस्पति विज्ञान (100 NCERT PYQ प्रश्न)",
            questionCount = 100,
            keywords = "neet ug medical biology botany plant kingdom morphology cell division photosynthesis genetics lac operon ecology नीट वनस्पति विज्ञान बॉटनी"
        ),
        SearchableTestSeriesEntry(
            id = "neet_zoology",
            testId = "neet_sec_zoology_100",
            examCategoryKey = "neet",
            examDisplayEn = "NEET (UG) Medical",
            examDisplayHi = "नीट यूजी (NEET)",
            subjectNameEn = "NEET Biology: Zoology",
            subjectNameHi = "नीट जीव विज्ञान: जन्तु विज्ञान",
            titleEn = "NEET (UG) — Section 6: Biology — Zoology (100 5-Yr NCERT PYQs)",
            titleHi = "NEET (UG) — खंड 6: जीव विज्ञान — जन्तु विज्ञान (100 NCERT PYQ प्रश्न)",
            questionCount = 100,
            keywords = "neet ug medical biology zoology animal kingdom human physiology ecg reproduction evolution biotechnology नीट जन्तु विज्ञान जूलॉजी"
        ),
        // UGC NET Paper 1 (10 Units × 100 MCQs) & Paper 2 (12 Subjects × 100 MCQs)
        SearchableTestSeriesEntry(
            id = "ugc_p1_unit1_teaching",
            testId = "ugc_p1_sec_unit1_100",
            examCategoryKey = "ugc_net",
            examDisplayEn = "UGC NET Paper 1",
            examDisplayHi = "UGC NET पेपर 1",
            subjectNameEn = "Paper 1 Unit I: Teaching Aptitude",
            subjectNameHi = "पेपर 1 इकाई I: शिक्षण अभिक्षमता",
            titleEn = "UGC NET Paper 1 — Unit I: Teaching Aptitude (100 PYQ MCQs)",
            titleHi = "UGC NET पेपर 1 — इकाई I: शिक्षण अभिक्षमता (100 PYQ प्रश्न)",
            questionCount = 100,
            keywords = "ugc net jrf paper 1 unit 1 teaching aptitude swayam swayamprabha moocs यूजीसी नेट शिक्षण अभिक्षमता"
        ),
        SearchableTestSeriesEntry(
            id = "ugc_p1_unit2_research",
            testId = "ugc_p1_sec_unit2_100",
            examCategoryKey = "ugc_net",
            examDisplayEn = "UGC NET Paper 1",
            examDisplayHi = "UGC NET पेपर 1",
            subjectNameEn = "Paper 1 Unit II: Research Aptitude",
            subjectNameHi = "पेपर 1 इकाई II: शोध अभिक्षमता",
            titleEn = "UGC NET Paper 1 — Unit II: Research Aptitude (100 PYQ MCQs)",
            titleHi = "UGC NET पेपर 1 — इकाई II: शोध अभिक्षमता (100 PYQ प्रश्न)",
            questionCount = 100,
            keywords = "ugc net jrf paper 1 unit 2 research aptitude positivism sampling hypothesis plagiarism यूजीसी नेट शोध अभिक्षमता"
        ),
        SearchableTestSeriesEntry(
            id = "ugc_p1_unit6_logical_reasoning",
            testId = "ugc_p1_sec_unit6_100",
            examCategoryKey = "ugc_net",
            examDisplayEn = "UGC NET Paper 1",
            examDisplayHi = "UGC NET पेपर 1",
            subjectNameEn = "Paper 1 Unit VI: Logical Reasoning & Pramanas",
            subjectNameHi = "पेपर 1 इकाई VI: भारतीय तर्कशास्त्र एवं प्रमाण",
            titleEn = "UGC NET Paper 1 — Unit VI: Logical Reasoning & Indian Logic (100 PYQ MCQs)",
            titleHi = "UGC NET पेपर 1 — इकाई VI: युक्तियुक्त तर्क एवं प्रमाण (100 PYQ प्रश्न)",
            questionCount = 100,
            keywords = "ugc net jrf paper 1 unit 6 logical reasoning indian logic pramana hetvabhasa अनुपलब्धि अर्थापत्ति"
        ),
        SearchableTestSeriesEntry(
            id = "ugc_p2_history",
            testId = "ugc_p2_sec_history_100",
            examCategoryKey = "ugc_net",
            examDisplayEn = "UGC NET Paper 2",
            examDisplayHi = "UGC NET पेपर 2",
            subjectNameEn = "Paper 2: History (Code 006)",
            subjectNameHi = "पेपर 2: इतिहास (कोड 006)",
            titleEn = "UGC NET Paper 2 — History (Code 006) — 100 PYQ MCQs",
            titleHi = "UGC NET पेपर 2 — इतिहास (कोड 006) — 100 PYQ प्रश्न",
            questionCount = 100,
            keywords = "ugc net jrf paper 2 history ancient medieval modern historiography यूजीसी नेट इतिहास"
        ),
        SearchableTestSeriesEntry(
            id = "ugc_p2_pol_science",
            testId = "ugc_p2_sec_pol_science_100",
            examCategoryKey = "ugc_net",
            examDisplayEn = "UGC NET Paper 2",
            examDisplayHi = "UGC NET पेपर 2",
            subjectNameEn = "Paper 2: Political Science (Code 002)",
            subjectNameHi = "पेपर 2: राजनीति विज्ञान (कोड 002)",
            titleEn = "UGC NET Paper 2 — Political Science (Code 002) — 100 PYQ MCQs",
            titleHi = "UGC NET पेपर 2 — राजनीति विज्ञान (कोड 002) — 100 PYQ प्रश्न",
            questionCount = 100,
            keywords = "ugc net jrf paper 2 political science polity international relations public administration यूजीसी नेट राजनीति विज्ञान"
        ),
        SearchableTestSeriesEntry(
            id = "ugc_p2_hindi",
            testId = "ugc_p2_sec_hindi_100",
            examCategoryKey = "ugc_net",
            examDisplayEn = "UGC NET Paper 2",
            examDisplayHi = "UGC NET पेपर 2",
            subjectNameEn = "Paper 2: Hindi Literature (Code 020)",
            subjectNameHi = "पेपर 2: हिंदी साहित्य (कोड 020)",
            titleEn = "UGC NET Paper 2 — Hindi Literature (Code 020) — 100 PYQ MCQs",
            titleHi = "UGC NET पेपर 2 — हिंदी साहित्य (कोड 020) — 100 PYQ प्रश्न",
            questionCount = 100,
            keywords = "ugc net jrf paper 2 hindi sahitya literature यूजीसी नेट हिंदी साहित्य"
        ),
        SearchableTestSeriesEntry(
            id = "ugc_p2_commerce",
            testId = "ugc_p2_sec_commerce_100",
            examCategoryKey = "ugc_net",
            examDisplayEn = "UGC NET Paper 2",
            examDisplayHi = "UGC NET पेपर 2",
            subjectNameEn = "Paper 2: Commerce (Code 008)",
            subjectNameHi = "पेपर 2: वाणिज्य (कोड 008)",
            titleEn = "UGC NET Paper 2 — Commerce (Code 008) — 100 PYQ MCQs",
            titleHi = "UGC NET पेपर 2 — वाणिज्य (कोड 008) — 100 PYQ प्रश्न",
            questionCount = 100,
            keywords = "ugc net jrf paper 2 commerce accounting finance banking income tax यूजीसी नेट वाणिज्य कॉमर्स"
        ),
        SearchableTestSeriesEntry(
            id = "ugc_p2_computer_sci",
            testId = "ugc_p2_sec_computer_sci_100",
            examCategoryKey = "ugc_net",
            examDisplayEn = "UGC NET Paper 2",
            examDisplayHi = "UGC NET पेपर 2",
            subjectNameEn = "Paper 2: Computer Science (Code 087)",
            subjectNameHi = "पेपर 2: कंप्यूटर विज्ञान (कोड 087)",
            titleEn = "UGC NET Paper 2 — Computer Science & Applications (Code 087) — 100 PYQ MCQs",
            titleHi = "UGC NET पेपर 2 — कंप्यूटर विज्ञान और अनुप्रयोग (कोड 087) — 100 PYQ प्रश्न",
            questionCount = 100,
            keywords = "ugc net jrf paper 2 computer science dbms operating system algorithms toc networks यूजीसी नेट कंप्यूटर विज्ञान"
        ),
        // Teaching Eligibility Test (CTET / UPTET / UTET & Others — 7 Subjects × 100 Qs)
        SearchableTestSeriesEntry(
            id = "tet_cdp",
            testId = "tet_sec_cdp_100",
            examCategoryKey = "tet",
            examDisplayEn = "CTET / UPTET / UTET",
            examDisplayHi = "सीटेट • यूपीटेट • यूटेट",
            subjectNameEn = "CDP: Child Development & Pedagogy",
            subjectNameHi = "सीडीपी: बाल विकास एवं शिक्षाशास्त्र",
            titleEn = "CTET / UPTET / UTET — CDP: Child Development & Pedagogy (100 PYQs)",
            titleHi = "सीटेट / यूपीटेट / यूटेट — सीडीपी: बाल विकास एवं शिक्षाशास्त्र (100 PYQ प्रश्न)",
            questionCount = 100,
            keywords = "tet ctet uptet utet reet teaching eligibility cdp child development pedagogy piaget vygotsky kohlberg nep 2020 सीडीपी बाल विकास सीटेट यूपीटेट यूटेट"
        ),
        SearchableTestSeriesEntry(
            id = "tet_evs",
            testId = "tet_sec_evs_100",
            examCategoryKey = "tet",
            examDisplayEn = "CTET / UPTET / UTET",
            examDisplayHi = "सीटेट • यूपीटेट • यूटेट",
            subjectNameEn = "EVS: Environmental Studies & Pedagogy",
            subjectNameHi = "ईवीएस: पर्यावरण अध्ययन एवं पेडागोजी",
            titleEn = "CTET / UPTET / UTET — EVS: Environmental Studies & Pedagogy (100 PYQs)",
            titleHi = "सीटेट / यूपीटेट / यूटेट — ईवीएस: पर्यावरण अध्ययन एवं पेडागोजी (100 PYQ प्रश्न)",
            questionCount = 100,
            keywords = "tet ctet uptet utet reet evs environmental studies pedagogy ncert themes ईवीएस पर्यावरण अध्ययन सीटेट यूपीटेट यूटेट"
        ),
        SearchableTestSeriesEntry(
            id = "tet_maths",
            testId = "tet_sec_maths_100",
            examCategoryKey = "tet",
            examDisplayEn = "CTET / UPTET / UTET",
            examDisplayHi = "सीटेट • यूपीटेट • यूटेट",
            subjectNameEn = "Mathematics & Pedagogy",
            subjectNameHi = "मैथ्स: गणित एवं शिक्षण शास्त्र",
            titleEn = "CTET / UPTET / UTET — Mathematics & Pedagogy (100 PYQs)",
            titleHi = "सीटेट / यूपीटेट / यूटेट — मैथ्स: गणित एवं शिक्षण शास्त्र (100 PYQ प्रश्न)",
            questionCount = 100,
            keywords = "tet ctet uptet utet maths mathematics pedagogy van hiele mensuration number system मैथ्स गणित सीटेट यूपीटेट यूटेट"
        ),
        SearchableTestSeriesEntry(
            id = "tet_science",
            testId = "tet_sec_science_100",
            examCategoryKey = "tet",
            examDisplayEn = "CTET / UPTET / UTET",
            examDisplayHi = "सीटेट • यूपीटेट • यूटेट",
            subjectNameEn = "Science & Pedagogy (Paper 2)",
            subjectNameHi = "साइंस: विज्ञान एवं शिक्षण शास्त्र",
            titleEn = "CTET / UPTET / UTET — Science & Pedagogy Paper 2 (100 PYQs)",
            titleHi = "सीटेट / यूपीटेट / यूटेट — साइंस: विज्ञान एवं शिक्षण शास्त्र (100 PYQ प्रश्न)",
            questionCount = 100,
            keywords = "tet ctet uptet utet science pedagogy paper 2 ncert physics chemistry biology साइंस विज्ञान सीटेट यूपीटेट यूटेट"
        ),
        SearchableTestSeriesEntry(
            id = "tet_social_science",
            testId = "tet_sec_social_science_100",
            examCategoryKey = "tet",
            examDisplayEn = "CTET / UPTET / UTET",
            examDisplayHi = "सीटेट • यूपीटेट • यूटेट",
            subjectNameEn = "Social Science (SST) & Pedagogy (Paper 2)",
            subjectNameHi = "सोशल साइंस: सामाजिक अध्ययन एवं पेडागोजी",
            titleEn = "CTET / UPTET / UTET — Social Science (SST) & Pedagogy Paper 2 (100 PYQs)",
            titleHi = "सीटेट / यूपीटेट / यूटेट — सोशल साइंस: सामाजिक अध्ययन एवं पेडागोजी (100 PYQ प्रश्न)",
            questionCount = 100,
            keywords = "tet ctet uptet utet social science sst studies history geography civics pedagogy सोशल साइंस सामाजिक अध्ययन सीटेट यूपीटेट यूटेट"
        ),
        SearchableTestSeriesEntry(
            id = "tet_hindi",
            testId = "tet_sec_hindi_100",
            examCategoryKey = "tet",
            examDisplayEn = "CTET / UPTET / UTET",
            examDisplayHi = "सीटेट • यूपीटेट • यूटेट",
            subjectNameEn = "Language I: Hindi & Pedagogy",
            subjectNameHi = "भाषा-I: हिंदी एवं शिक्षण शास्त्र",
            titleEn = "CTET / UPTET / UTET — Language I: Hindi & Pedagogy (100 PYQs)",
            titleHi = "सीटेट / यूपीटेट / यूटेट — भाषा-I: हिंदी भाषा एवं शिक्षण शास्त्र (100 PYQ प्रश्न)",
            questionCount = 100,
            keywords = "tet ctet uptet utet hindi language pedagogy grammar bhasha हिंदी पेडागोजी सीटेट यूपीटेट यूटेट"
        ),
        SearchableTestSeriesEntry(
            id = "tet_english_sanskrit",
            testId = "tet_sec_english_sanskrit_100",
            examCategoryKey = "tet",
            examDisplayEn = "CTET / UPTET / UTET",
            examDisplayHi = "सीटेट • यूपीटेट • यूटेट",
            subjectNameEn = "Language II: English / Sanskrit & Pedagogy",
            subjectNameHi = "भाषा-II: अंग्रेज़ी / संस्कृत एवं पेडागोजी",
            titleEn = "CTET / UPTET / UTET — Language II: English / Sanskrit & Pedagogy (100 PYQs)",
            titleHi = "सीटेट / यूपीटेट / यूटेट — भाषा-II: अंग्रेज़ी / संस्कृत एवं पेडागोजी (100 PYQ प्रश्न)",
            questionCount = 100,
            keywords = "tet ctet uptet utet english sanskrit language 2 pedagogy bics calp krashen अंग्रेज़ी संस्कृत सीटेट यूपीटेट यूटेट"
        )
    )

    fun searchSubjectTestSeries(query: String): List<SearchableTestSeriesEntry> {
        val q = query.trim().lowercase()
        if (q.isBlank()) return emptyList()
        val tokens = q.split(Regex("\\s+")).filter { it.isNotBlank() }
        return allSubjectTestSeries.filter { entry ->
            val searchableBlob = "${entry.titleEn} ${entry.titleHi} ${entry.subjectNameEn} ${entry.subjectNameHi} ${entry.examDisplayEn} ${entry.examCategoryKey} ${entry.keywords}".lowercase()
            searchableBlob.contains(q) || tokens.all { token -> searchableBlob.contains(token) }
        }
    }

    fun matchesStudyItem(item: StudyItem, query: String): Boolean {
        val q = query.trim().lowercase()
        if (q.isBlank()) return true
        val tokens = q.split(Regex("\\s+")).filter { it.isNotBlank() }
        val categoryInfo = ExamCatalogData.categories.firstOrNull { it.id.equals(item.categoryId, ignoreCase = true) }
        val subjectKeywords = buildString {
            append(item.title).append(" ")
            append(item.hindiTitle).append(" ")
            append(item.description).append(" ")
            append(item.seriesName).append(" ")
            append(item.categoryId).append(" ")
            append(item.subSectionId).append(" ")
            append(item.subjectId).append(" ")
            append(item.type.label).append(" ")
            append(item.medium).append(" ")
            if (categoryInfo != null) {
                append(categoryInfo.name).append(" ")
                append(categoryInfo.hindiName).append(" ")
                categoryInfo.subSections.forEach { sub ->
                    if (sub.id.equals(item.subSectionId, ignoreCase = true) || item.subSectionId.isBlank()) {
                        append(sub.name).append(" ").append(sub.hindiName).append(" ")
                    }
                    sub.subjects.forEach { subj ->
                        if (subj.id.equals(item.subjectId, ignoreCase = true)) {
                            append(subj.name).append(" ").append(subj.hindiName).append(" ")
                        }
                    }
                }
            }
        }.lowercase()
        return subjectKeywords.contains(q) || tokens.all { token -> subjectKeywords.contains(token) }
    }
}

/**
 * Top-of-Dashboard Global Search Bar Component.
 * Allows users to quickly find specific E-Books or Test Series by Title, Subject, or Exam Category,
 * with instant categorized search results and one-tap actions.
 */
@Composable
fun GlobalDashboardSearchBarComponent(
    uiState: ShakuntalamUiState,
    isHi: Boolean,
    matchingCategories: List<ExamCategory>,
    matchingMockTests: List<MockTest>,
    filteredItems: List<StudyItem>,
    onSearchQueryChange: (String) -> Unit,
    onClearSearchAndFilter: () -> Unit,
    onSelectQuickChip: (String, Boolean) -> Unit,
    onSelectContentType: (ContentType?) -> Unit,
    onSelectMedium: (String?) -> Unit,
    onExploreCategory: (ExamCategory) -> Unit,
    onFilterDashboardByCategory: (String) -> Unit,
    onStartMockTest: (MockTest) -> Unit,
    onStartSubjectTestSeries: (SearchableTestSeriesEntry) -> Unit,
    onOpenStudyItem: (StudyItem) -> Unit,
    onOpenUploadedPdf: (EbookDocumentEntity) -> Unit,
    modifier: Modifier = Modifier
) {
    val q = uiState.searchQuery.trim()
    var resultScopeTab by remember { mutableStateOf("ALL") } // "ALL", "TEST_SERIES", "EBOOKS", "CATEGORIES"

    val quickExamAndSubjectChips = listOf(
        Triple("CTET / TET", "CTET", "सीटेट / टेट (CTET/TET)"),
        Triple("IIT JEE", "IIT JEE", "आईआईटी जेईई (IIT JEE)"),
        Triple("NEET", "NEET", "नीट यूजी (NEET)"),
        Triple("UGC NET", "UGC NET", "यूजीसी नेट (UGC NET)"),
        Triple("UPSC", "UPSC", "यूपीएससी (UPSC)"),
        Triple("SSC", "SSC", "एसएससी (SSC)"),
        Triple("Banking", "Banking", "बैंकिंग (Banking)"),
        Triple("History", "History", "इतिहास (History)"),
        Triple("Polity", "Polity", "पॉलिटी (Polity)"),
        Triple("Reasoning", "Reasoning", "रीजनिंग (Reasoning)"),
        Triple("Math", "Math", "गणित (Math)"),
        Triple("English", "English", "इंग्लिश (English)"),
        Triple("State PSC", "PSC", "राज्य पीसीएस (PSC)"),
        Triple("UPSSSC", "UPSSSC", "UPSSSC"),
        Triple("UKSSSC", "UKSSSC", "UKSSSC"),
        Triple("Railways", "Railway", "रेलवे (Railways)")
    )

    val matchingSubjectSeries = remember(q) {
        GlobalSearchIndexCatalog.searchSubjectTestSeries(q)
    }

    val matchingUploadedDocs = remember(q, uiState.uploadedDocuments) {
        if (q.isBlank()) {
            emptyList()
        } else {
            uiState.uploadedDocuments.filter { doc ->
                doc.title.contains(q, ignoreCase = true) ||
                        doc.hindiTitle.contains(q, ignoreCase = true) ||
                        doc.examId.contains(q, ignoreCase = true) ||
                        doc.subjectId.contains(q, ignoreCase = true)
            }
        }
    }

    val matchingEbooks = remember(filteredItems) {
        filteredItems.filter { it.type == ContentType.EBOOK }
    }
    val matchingPaidTestPackages = remember(filteredItems) {
        filteredItems.filter { it.type == ContentType.TEST_SERIES }
    }

    Column(modifier = modifier.fillMaxWidth()) {
        // Global Search Bar Container at Top of Main Dashboard
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.verticalGradient(
                        listOf(Navy900, Color(0xFF172554))
                    )
                )
                .padding(horizontal = 16.dp, vertical = 14.dp)
                .testTag("global_search_bar_container")
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = if (isHi)
                        "ग्लोबल सर्च: शीर्षक, विषय या परीक्षा वर्ग से ई-बुक्स व टेस्ट खोजें"
                    else
                        "Global Search: Find E-Books & Test Series by Title, Subject or Exam",
                    color = SaffronGold,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.ExtraBold,
                    maxLines = 1,
                    softWrap = false,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f)
                )
                if (q.isNotBlank() || uiState.selectedDashboardCategoryFilter != "ALL") {
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = if (isHi) "रीसेट करें ✕" else "Reset Search ✕",
                        color = Color.White,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .clip(RoundedCornerShape(6.dp))
                            .background(Color(0x33FFFFFF))
                            .clickable { onClearSearchAndFilter() }
                            .padding(horizontal = 8.dp, vertical = 3.dp)
                            .testTag("global_search_reset_chip")
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = uiState.searchQuery,
                onValueChange = onSearchQueryChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("home_search_input"),
                placeholder = {
                    Text(
                        text = if (isHi)
                            "शीर्षक, विषय (History, Polity, Math) या परीक्षा (UPSC, SSC, Banking) खोजें..."
                        else
                            "Search by title, subject (History, Polity, Math) or exam (UPSC, SSC, Banking)...",
                        fontSize = 12.5.sp,
                        color = Color(0xFF64748B),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search E-Books and Test Series",
                        tint = Navy900
                    )
                },
                trailingIcon = {
                    if (uiState.searchQuery.isNotEmpty()) {
                        IconButton(
                            onClick = onClearSearchAndFilter,
                            modifier = Modifier.testTag("global_search_clear_button")
                        ) {
                            Icon(
                                imageVector = Icons.Default.Clear,
                                contentDescription = "Clear search",
                                tint = Color(0xFF475569)
                            )
                        }
                    }
                },
                singleLine = true,
                shape = RoundedCornerShape(14.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedBorderColor = SaffronGold,
                    unfocusedBorderColor = Color(0xFFCBD5E1),
                    focusedTextColor = Navy900,
                    unfocusedTextColor = Navy900
                )
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Quick Search Pills for Exam Categories & Core Subjects (UPSC, SSC, Banking, History, Polity, Math, etc.)
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(quickExamAndSubjectChips) { (labelEn, queryVal, labelHi) ->
                    val isSelected = q.equals(queryVal, ignoreCase = true)
                    val tagKey = labelEn.lowercase().replace(" ", "_").replace("/", "")
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                            .background(
                                if (isSelected) SaffronGold else Color(0x26FFFFFF)
                            )
                            .border(
                                width = 1.dp,
                                color = if (isSelected) Color.White else Color(0x4DFFFFFF),
                                shape = RoundedCornerShape(20.dp)
                            )
                            .clickable {
                                onSelectQuickChip(queryVal, isSelected)
                            }
                            .padding(horizontal = 12.dp, vertical = 6.dp)
                            .testTag("quick_search_chip_$tagKey"),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = if (isHi) labelHi else labelEn,
                            color = if (isSelected) Navy900 else Color.White,
                            fontSize = 11.5.sp,
                            fontWeight = if (isSelected) FontWeight.ExtraBold else FontWeight.SemiBold,
                            maxLines = 1,
                            softWrap = false
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Content Type & Medium Filter Chips
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                item {
                    FilterChip(
                        selected = uiState.selectedContentType == null && uiState.selectedMedium == null,
                        onClick = {
                            onSelectContentType(null)
                            onSelectMedium(null)
                        },
                        label = {
                            Text(
                                if (isHi) "सभी (All)" else "All",
                                fontSize = 11.sp,
                                maxLines = 1,
                                softWrap = false
                            )
                        },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = SaffronGold,
                            selectedLabelColor = Color.White,
                            containerColor = Color(0xFF1E293B),
                            labelColor = Color(0xFFE2E8F0)
                        )
                    )
                }
                item {
                    FilterChip(
                        selected = uiState.selectedContentType == ContentType.EBOOK,
                        onClick = {
                            onSelectContentType(
                                if (uiState.selectedContentType == ContentType.EBOOK) null else ContentType.EBOOK
                            )
                        },
                        label = {
                            Text(
                                if (isHi) "ई-बुक्स (E-Books)" else "E-Books",
                                fontSize = 11.sp,
                                maxLines = 1,
                                softWrap = false
                            )
                        },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = SaffronGold,
                            selectedLabelColor = Color.White,
                            containerColor = Color(0xFF1E293B),
                            labelColor = Color(0xFFE2E8F0)
                        )
                    )
                }
                item {
                    FilterChip(
                        selected = uiState.selectedContentType == ContentType.TEST_SERIES,
                        onClick = {
                            onSelectContentType(
                                if (uiState.selectedContentType == ContentType.TEST_SERIES) null else ContentType.TEST_SERIES
                            )
                        },
                        label = {
                            Text(
                                if (isHi) "टेस्ट सीरीज़ (Tests)" else "Mock Tests",
                                fontSize = 11.sp,
                                maxLines = 1,
                                softWrap = false
                            )
                        },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = SaffronGold,
                            selectedLabelColor = Color.White,
                            containerColor = Color(0xFF1E293B),
                            labelColor = Color(0xFFE2E8F0)
                        )
                    )
                }
                item {
                    FilterChip(
                        selected = uiState.selectedMedium == "Hindi",
                        onClick = {
                            onSelectMedium(
                                if (uiState.selectedMedium == "Hindi") null else "Hindi"
                            )
                        },
                        label = {
                            Text(
                                if (isHi) "हिंदी माध्यम" else "Hindi Medium",
                                fontSize = 11.sp,
                                maxLines = 1,
                                softWrap = false
                            )
                        },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = SaffronGold,
                            selectedLabelColor = Color.White,
                            containerColor = Color(0xFF1E293B),
                            labelColor = Color(0xFFE2E8F0)
                        )
                    )
                }
                item {
                    FilterChip(
                        selected = uiState.selectedMedium == "English",
                        onClick = {
                            onSelectMedium(
                                if (uiState.selectedMedium == "English") null else "English"
                            )
                        },
                        label = {
                            Text(
                                if (isHi) "अंग्रेज़ी माध्यम" else "English Medium",
                                fontSize = 11.sp,
                                maxLines = 1,
                                softWrap = false
                            )
                        },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = SaffronGold,
                            selectedLabelColor = Color.White,
                            containerColor = Color(0xFF1E293B),
                            labelColor = Color(0xFFE2E8F0)
                        )
                    )
                }
            }
        }

        // Instant Global Search Results Panel when user searches by Title, Subject, or Exam Category
        if (q.isNotBlank()) {
            val totalTestsFound = matchingSubjectSeries.size + matchingMockTests.size + matchingPaidTestPackages.size
            val totalEbooksFound = matchingEbooks.size + matchingUploadedDocs.size

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 10.dp)
                    .border(1.5.dp, SaffronGold, RoundedCornerShape(16.dp))
                    .testTag("global_search_results_panel"),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = if (isHi) {
                                "\"$q\" के परिणाम ($totalTestsFound टेस्ट सीरीज़ • $totalEbooksFound ई-बुक्स • ${matchingCategories.size} परीक्षा वर्ग)"
                            } else {
                                "Results for \"$q\" ($totalTestsFound Test Series • $totalEbooksFound E-Books • ${matchingCategories.size} Categories)"
                            },
                            fontSize = 12.5.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Navy900,
                            modifier = Modifier.weight(1f)
                        )
                    }

                    // Result Scope Filter Tabs: All | Test Series | E-Books | Exam Categories
                    val scopeTabs = listOf(
                        Triple("ALL", "All", "सभी"),
                        Triple("TEST_SERIES", "Test Series ($totalTestsFound)", "टेस्ट सीरीज़ ($totalTestsFound)"),
                        Triple("EBOOKS", "E-Books ($totalEbooksFound)", "ई-बुक्स ($totalEbooksFound)"),
                        Triple("CATEGORIES", "Categories (${matchingCategories.size})", "परीक्षा वर्ग (${matchingCategories.size})")
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState()),
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        scopeTabs.forEach { (scopeCode, labelEn, labelHi) ->
                            val isSelected = resultScopeTab == scopeCode
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(if (isSelected) Navy900 else Color(0xFFF1F5F9))
                                    .border(
                                        width = 1.dp,
                                        color = if (isSelected) SaffronGold else Color(0xFFCBD5E1),
                                        shape = RoundedCornerShape(8.dp)
                                    )
                                    .clickable { resultScopeTab = scopeCode }
                                    .padding(horizontal = 10.dp, vertical = 5.dp)
                                    .testTag("global_search_scope_tab_$scopeCode")
                            ) {
                                Text(
                                    text = if (isHi) labelHi else labelEn,
                                    fontSize = 10.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (isSelected) Color.White else Navy900,
                                    maxLines = 1,
                                    softWrap = false
                                )
                            }
                        }
                    }

                    if (matchingCategories.isEmpty() && totalTestsFound == 0 && totalEbooksFound == 0) {
                        Text(
                            text = if (isHi) {
                                "कोई ई-बुक या टेस्ट सीरीज़ नहीं मिली। कृपया 'History', 'Polity', 'Math', 'UPSC', 'SSC', या 'Banking' खोजें।"
                            } else {
                                "No matching E-Books or Test Series found. Try searching 'History', 'Polity', 'Math', 'UPSC', 'SSC', or 'Banking'."
                            },
                            fontSize = 12.5.sp,
                            color = Color(0xFF64748B)
                        )
                    } else {
                        // 1. Matching Exam Categories
                        if ((resultScopeTab == "ALL" || resultScopeTab == "CATEGORIES") && matchingCategories.isNotEmpty()) {
                            Text(
                                text = if (isHi) "चयनित परीक्षा वर्ग (Exam Categories)" else "Matching Exam Categories",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = SaffronGold
                            )
                            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                matchingCategories.forEach { category ->
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .clip(RoundedCornerShape(12.dp))
                                            .background(Color(0xFFF8FAFC))
                                            .border(1.dp, Color(0xFFE2E8F0), RoundedCornerShape(12.dp))
                                            .clickable { onExploreCategory(category) }
                                            .padding(12.dp)
                                            .testTag("search_result_category_${category.id}"),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Column(modifier = Modifier.weight(1f)) {
                                            Text(
                                                text = if (isHi) category.hindiName else category.name,
                                                fontSize = 13.5.sp,
                                                fontWeight = FontWeight.ExtraBold,
                                                color = Navy900
                                            )
                                            Text(
                                                text = category.subSections.joinToString(" • ") {
                                                    if (isHi) it.hindiName else it.name
                                                },
                                                fontSize = 11.sp,
                                                color = Color(0xFF475569),
                                                maxLines = 1,
                                                overflow = TextOverflow.Ellipsis
                                            )
                                        }
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                                            Box(
                                                modifier = Modifier
                                                    .clip(RoundedCornerShape(8.dp))
                                                    .background(Navy900)
                                                    .clickable { onExploreCategory(category) }
                                                    .padding(horizontal = 10.dp, vertical = 6.dp)
                                            ) {
                                                Text(
                                                    text = if (isHi) "एक्सप्लोर" else "Explore",
                                                    color = Color.White,
                                                    fontSize = 11.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    maxLines = 1,
                                                    softWrap = false
                                                )
                                            }
                                            Box(
                                                modifier = Modifier
                                                    .clip(RoundedCornerShape(8.dp))
                                                    .background(EmeraldSuccess)
                                                    .clickable { onFilterDashboardByCategory(category.id) }
                                                    .padding(horizontal = 10.dp, vertical = 6.dp)
                                            ) {
                                                Text(
                                                    text = if (isHi) "डैशबोर्ड फ़िल्टर" else "Filter Series",
                                                    color = Color.White,
                                                    fontSize = 11.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    maxLines = 1,
                                                    softWrap = false
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        // 2. Matching Subject-Wise & Exam PYQ Test Series
                        if ((resultScopeTab == "ALL" || resultScopeTab == "TEST_SERIES") &&
                            (matchingSubjectSeries.isNotEmpty() || matchingMockTests.isNotEmpty() || matchingPaidTestPackages.isNotEmpty())
                        ) {
                            Text(
                                text = if (isHi)
                                    "विषयवार एवं परीक्षा टेस्ट सीरीज़ ($totalTestsFound)"
                                else
                                    "Matching Subject & Exam Test Series ($totalTestsFound)",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = EmeraldSuccess
                            )
                            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                                matchingSubjectSeries.take(6).forEach { entry ->
                                    val prog = uiState.getSectionProgress(entry.testId, entry.questionCount)
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .clip(RoundedCornerShape(10.dp))
                                            .background(Color(0xFFF0FDF4))
                                            .border(1.dp, Color(0xFFBBF7D0), RoundedCornerShape(10.dp))
                                            .clickable { onStartSubjectTestSeries(entry) }
                                            .padding(horizontal = 12.dp, vertical = 8.dp)
                                            .testTag("search_result_subject_series_${entry.id}"),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Row(
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier.weight(1f)
                                        ) {
                                            Icon(
                                                imageVector = Icons.Default.Quiz,
                                                contentDescription = null,
                                                tint = EmeraldSuccess,
                                                modifier = Modifier.size(18.dp)
                                            )
                                            Spacer(modifier = Modifier.width(8.dp))
                                            Column(modifier = Modifier.weight(1f)) {
                                                Text(
                                                    text = if (isHi) entry.titleHi else entry.titleEn,
                                                    fontSize = 12.5.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    color = Navy900,
                                                    maxLines = 1,
                                                    overflow = TextOverflow.Ellipsis
                                                )
                                                Text(
                                                    text = "${if (isHi) entry.examDisplayHi else entry.examDisplayEn} • ${if (isHi) entry.subjectNameHi else entry.subjectNameEn} • ${entry.questionCount} Qs (${prog.completionPercent}% Done)",
                                                    fontSize = 10.5.sp,
                                                    color = Color(0xFF15803D),
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
                                                .padding(horizontal = 8.dp, vertical = 4.dp)
                                        ) {
                                            Text(
                                                text = if (isHi) "अटेम्प्ट करें" else "Start Test",
                                                color = Color.White,
                                                fontSize = 10.5.sp,
                                                fontWeight = FontWeight.Bold,
                                                maxLines = 1,
                                                softWrap = false
                                            )
                                        }
                                    }
                                }

                                matchingMockTests.take(4).forEach { test ->
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .clip(RoundedCornerShape(10.dp))
                                            .background(Color(0xFFF0FDF4))
                                            .border(1.dp, Color(0xFFBBF7D0), RoundedCornerShape(10.dp))
                                            .clickable { onStartMockTest(test) }
                                            .padding(horizontal = 12.dp, vertical = 8.dp),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Column(modifier = Modifier.weight(1f)) {
                                            Text(
                                                text = if (isHi) test.hindiTitle else test.title,
                                                fontSize = 12.5.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Navy900,
                                                maxLines = 1,
                                                overflow = TextOverflow.Ellipsis
                                            )
                                            Text(
                                                text = "${test.questions.size} PYQs • ${test.durationMinutes} Mins • ${test.totalMarks} Marks",
                                                fontSize = 10.5.sp,
                                                color = Color(0xFF15803D),
                                                maxLines = 1,
                                                softWrap = false
                                            )
                                        }
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Box(
                                            modifier = Modifier
                                                .clip(RoundedCornerShape(6.dp))
                                                .background(EmeraldSuccess)
                                                .padding(horizontal = 8.dp, vertical = 4.dp)
                                        ) {
                                            Text(
                                                text = if (isHi) "अटेम्प्ट करें" else "Start Free",
                                                color = Color.White,
                                                fontSize = 10.5.sp,
                                                fontWeight = FontWeight.Bold,
                                                maxLines = 1,
                                                softWrap = false
                                            )
                                        }
                                    }
                                }
                            }
                        }

                        // 3. Matching E-Books & Study Materials (by Title, Subject, or Exam Category)
                        val itemsToDisplay = when (resultScopeTab) {
                            "EBOOKS" -> matchingEbooks
                            "TEST_SERIES" -> matchingPaidTestPackages
                            else -> filteredItems
                        }
                        if ((resultScopeTab == "ALL" || resultScopeTab == "EBOOKS" || resultScopeTab == "TEST_SERIES") &&
                            (itemsToDisplay.isNotEmpty() || matchingUploadedDocs.isNotEmpty())
                        ) {
                            Text(
                                text = if (isHi)
                                    "ई-बुक्स एवं अध्ययन सामग्री (${itemsToDisplay.size + matchingUploadedDocs.size})"
                                else
                                    "Matching E-Books & Study Series (${itemsToDisplay.size + matchingUploadedDocs.size})",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = Navy800
                            )
                            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                                itemsToDisplay.take(5).forEach { studyItem ->
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .clip(RoundedCornerShape(10.dp))
                                            .background(Color(0xFFF8FAFC))
                                            .border(1.dp, Color(0xFFE2E8F0), RoundedCornerShape(10.dp))
                                            .clickable { onOpenStudyItem(studyItem) }
                                            .padding(horizontal = 12.dp, vertical = 8.dp)
                                            .testTag("search_result_item_${studyItem.id}"),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Row(
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier.weight(1f)
                                        ) {
                                            Icon(
                                                imageVector = if (studyItem.type == ContentType.EBOOK) Icons.Default.MenuBook else Icons.Default.Quiz,
                                                contentDescription = null,
                                                tint = Navy900,
                                                modifier = Modifier.size(18.dp)
                                            )
                                            Spacer(modifier = Modifier.width(8.dp))
                                            Column(modifier = Modifier.weight(1f)) {
                                                Text(
                                                    text = if (isHi) studyItem.hindiTitle else studyItem.title,
                                                    fontSize = 12.5.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    color = Navy900,
                                                    maxLines = 1,
                                                    overflow = TextOverflow.Ellipsis
                                                )
                                                Text(
                                                    text = "${studyItem.type.label} • ${studyItem.categoryId.uppercase()} • ${studyItem.totalPagesOrTests} • ₹${studyItem.discountedPrice}",
                                                    fontSize = 10.5.sp,
                                                    color = Color(0xFF475569),
                                                    maxLines = 1,
                                                    softWrap = false,
                                                    overflow = TextOverflow.Ellipsis
                                                )
                                            }
                                        }
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Box(
                                            modifier = Modifier
                                                .clip(RoundedCornerShape(6.dp))
                                                .background(SaffronGold)
                                                .padding(horizontal = 8.dp, vertical = 4.dp)
                                        ) {
                                            Text(
                                                text = if (isHi) "विवरण देखें" else "View",
                                                color = Color.White,
                                                fontSize = 10.5.sp,
                                                fontWeight = FontWeight.Bold,
                                                maxLines = 1,
                                                softWrap = false
                                            )
                                        }
                                    }
                                }

                                matchingUploadedDocs.take(3).forEach { doc ->
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .clip(RoundedCornerShape(10.dp))
                                            .background(Color(0xFFFFFBEB))
                                            .border(1.dp, Color(0xFFFDE68A), RoundedCornerShape(10.dp))
                                            .clickable { onOpenUploadedPdf(doc) }
                                            .padding(horizontal = 12.dp, vertical = 8.dp)
                                            .testTag("search_result_pdf_${doc.id}"),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Column(modifier = Modifier.weight(1f)) {
                                            Text(
                                                text = if (isHi) doc.hindiTitle else doc.title,
                                                fontSize = 12.5.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Navy900,
                                                maxLines = 1,
                                                overflow = TextOverflow.Ellipsis
                                            )
                                            Text(
                                                text = "PDF E-Book • ${doc.examId.uppercase()} • ${doc.subjectId.replace('_', ' ')} • ${doc.pageCount} Pages",
                                                fontSize = 10.5.sp,
                                                color = Color(0xFF92400E),
                                                maxLines = 1,
                                                overflow = TextOverflow.Ellipsis
                                            )
                                        }
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Box(
                                            modifier = Modifier
                                                .clip(RoundedCornerShape(6.dp))
                                                .background(Navy900)
                                                .padding(horizontal = 8.dp, vertical = 4.dp)
                                        ) {
                                            Text(
                                                text = if (isHi) "PDF पढ़ें" else "Read PDF",
                                                color = Color.White,
                                                fontSize = 10.5.sp,
                                                fontWeight = FontWeight.Bold,
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
        }
    }
}
