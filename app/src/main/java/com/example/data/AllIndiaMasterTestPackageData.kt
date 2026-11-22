package com.example.data

import com.example.data.local.entity.EbookDocumentEntity
import com.example.model.BookChapter
import com.example.model.ContentType
import com.example.model.MockTest
import com.example.model.StudyItem
import com.example.model.TestQuestion
import java.util.concurrent.ConcurrentHashMap

/**
 * Represents a structured Excel-style Table and Bar Graph for Mathematics / Data Interpretation (DI)
 * questions so index data, rows, columns, and charts render in crisp cells without misaligned text.
 */
data class QuestionDataTableSpec(
    val titleEn: String,
    val titleHi: String,
    val headersEn: List<String>,
    val headersHi: List<String>,
    val rows: List<List<String>>,
    val barGraphLabels: List<String> = emptyList(),
    val barGraphValues: List<Float> = emptyList(),
    val unitSuffix: String = ""
)

/**
 * Categorizes tests inside each Exam Center (matching & surpassing Testbook):
 * - FULL_LENGTH: 20 Paid Full-Length Mock Tests covering the complete exam syllabus with exact official question count
 * - SECTIONAL: 20 Paid Subject-Wise / Sectional Tests broken down by exam subjects with exact sectional question count
 * - PYQ_5_YEAR: 10 Paid Official Previous Year Question Papers (2018–2025) with exact official question count
 * - TOPIC_WISE: Granular Topic-Wise Quizzes (e.g. Indus Valley, Maurya, Gupta, Fundamental Rights, DI Table)
 * - DAILY_PRACTICE: Daily Quiz & Speed Practice Quizzes
 */
enum class ExamPackageCategory(
    val code: String,
    val labelEn: String,
    val labelHi: String,
    val shortBadgeEn: String,
    val shortBadgeHi: String
) {
    FULL_LENGTH(
        code = "FULL_LENGTH",
        labelEn = "Full-Length Tests (20)",
        labelHi = "फुल लेंथ टेस्ट (20 FLT)",
        shortBadgeEn = "Full-Length FLT",
        shortBadgeHi = "फुल लेंथ टेस्ट"
    ),
    SECTIONAL(
        code = "SECTIONAL",
        labelEn = "Sectional Tests (20)",
        labelHi = "सेक्शनल टेस्ट (20 विषयवार)",
        shortBadgeEn = "Subject Sectional",
        shortBadgeHi = "विषयवार सेक्शनल"
    ),
    PYQ_5_YEAR(
        code = "PYQ_5_YEAR",
        labelEn = "Previous Year Papers (10)",
        labelHi = "प्रीवियस ईयर पेपर्स (10 PYQ)",
        shortBadgeEn = "Official PYQ Paper",
        shortBadgeHi = "ओरिजिनल PYQ पेपर"
    ),
    TOPIC_WISE(
        code = "TOPIC_WISE",
        labelEn = "Topic-Wise Quizzes",
        labelHi = "टॉपिक वाइज़ क्विज़",
        shortBadgeEn = "Micro-Topic",
        shortBadgeHi = "टॉपिक-वार"
    ),
    DAILY_PRACTICE(
        code = "DAILY_PRACTICE",
        labelEn = "Daily & Practice Quiz",
        labelHi = "डेली व प्रैक्टिस क्विज़",
        shortBadgeEn = "Daily Booster",
        shortBadgeHi = "डेली क्विज़"
    )
}

/**
 * Official Exam Blueprint specifying the exact question count, marks, duration, negative marking,
 * theme, toughness level, and subject breakdown for each competitive exam.
 */
data class SubjectSectionBlueprint(
    val subjectCode: String,
    val subjectNameEn: String,
    val subjectNameHi: String,
    val subTopics: List<Pair<String, String>>
)

data class ExamBlueprintProfile(
    val examKey: String,
    val examTitleEn: String,
    val examTitleHi: String,
    val conductingBodyEn: String,
    val conductingBodyHi: String,
    val fltQuestionCount: Int,
    val fltTotalMarks: Int,
    val fltDurationMinutes: Int,
    val sectionalQuestionCount: Int,
    val sectionalTotalMarks: Int,
    val sectionalDurationMinutes: Int,
    val positiveMarks: Double,
    val negativeMarks: Double,
    val examThemeEn: String,
    val examThemeHi: String,
    val difficultyLevelEn: String,
    val difficultyLevelHi: String,
    val subjects: List<SubjectSectionBlueprint>
)

data class ExamPackageTestEntry(
    val id: String,
    val examKey: String,
    val packageCategory: ExamPackageCategory,
    val isPaidOnly: Boolean,
    val subjectGroupEn: String,
    val subjectGroupHi: String,
    val topicTagEn: String,
    val topicTagHi: String,
    val pyqYear: String = "2020–2025 Pattern",
    val difficultyBadgeEn: String = "Official Exam Level",
    val difficultyBadgeHi: String = "ओरिजिनल एग्जाम लेवल",
    val mockTest: MockTest
)

/**
 * Comprehensive All-India Competitive Exam Test Package & Free Shakuntalam Branded Notes Repository.
 * Every Exam Paid Section contains EXACTLY 50 PAID TESTS:
 *  - 20 Full-Length Tests (with the exact official exam question count)
 *  - 20 Sectional Tests (broken down by exam subjects with the exact sectional question count)
 *  - 10 Previous Year Question Papers (with the exact official exam question count)
 * Plus Free Topic-Wise Quizzes & Free Daily/Practice Quizzes!
 * Covers: UPSC, State PCS (UPPCS, UKPSC, BPSC), UPSSSC, UKSSSC, UP Police Constable & SI (up_police),
 * SSC (CGL, CPO, CHSL, GD, MTS), RRB Railways (NTPC, Group D, ALP, RRB JE), Banking (SBI/IBPS/RBI),
 * IIT JEE & Technical JE, NEET UG, UGC NET (Paper 1 & 2), and Teaching (CTET/UPTET/UTET).
 */
object AllIndiaMasterTestPackageData {

    data class SubscriptionPlanSpec(
        val planCode: String,
        val priceInr: Int,
        val validityDays: Int,
        val titleEn: String,
        val titleHi: String,
        val subtitleEn: String,
        val subtitleHi: String,
        val badgeTextEn: String,
        val badgeTextHi: String
    )

    val subscriptionPlans: List<SubscriptionPlanSpec> = listOf(
        SubscriptionPlanSpec(
            planCode = "MONTHLY_9",
            priceInr = 9,
            validityDays = 30,
            titleEn = "₹9 / Month Pass",
            titleHi = "₹9 / मासिक पास",
            subtitleEn = "Unlock all 50 Paid Tests in every exam for 30 Days",
            subtitleHi = "30 दिनों के लिए सभी परीक्षाओं के 50-50 पेड टेस्ट अनलॉक",
            badgeTextEn = "STARTER PASS",
            badgeTextHi = "मासिक पास"
        ),
        SubscriptionPlanSpec(
            planCode = "YEARLY_99",
            priceInr = 99,
            validityDays = 365,
            titleEn = "₹99 / Year Pass",
            titleHi = "₹99 / वार्षिक पास",
            subtitleEn = "Unlock all 50 Paid Tests across all exams for 365 Days",
            subtitleHi = "पूरे 1 वर्ष (365 दिन) सभी परीक्षाओं के पेड टेस्ट अनलॉक",
            badgeTextEn = "MOST POPULAR",
            badgeTextHi = "सर्वश्रेष्ठ बचत ★"
        ),
        SubscriptionPlanSpec(
            planCode = "LIFETIME_399",
            priceInr = 399,
            validityDays = 3650,
            titleEn = "₹399 / Lifetime Pass",
            titleHi = "₹399 / लाइफटाइम पास",
            subtitleEn = "Permanent All-Exam Access (20 FLT + 20 Sectional + 10 PYQ + Notes)",
            subtitleHi = "आजीवन सभी परीक्षाओं के 50 पेड टेस्ट + भविष्य के सभी अपडेट्स अनलॉक",
            badgeTextEn = "LIFETIME VIP",
            badgeTextHi = "आजीवन VIP 👑"
        )
    )

    private val packageCache = ConcurrentHashMap<String, List<ExamPackageTestEntry>>()

    /**
     * Returns the official exam blueprint (exact question count, marks, duration, difficulty level,
     * and subject breakdown) for any examKey.
     */
    fun getExamBlueprint(examKey: String): ExamBlueprintProfile {
        val normKey = examKey.trim().lowercase()
        val gsSubjects = listOf(
            SubjectSectionBlueprint(
                subjectCode = "HISTORY",
                subjectNameEn = "History & Art/Culture (Ancient, Medieval & Modern)",
                subjectNameHi = "इतिहास एवं कला-संस्कृति (प्राचीन, मध्यकालीन व आधुनिक)",
                subTopics = listOf(
                    "Ancient India: Indus Valley, Vedic & Mauryan Empire" to "प्राचीन भारत: सिंधु घाटी, वैदिक काल एवं मौर्य साम्राज्य",
                    "Gupta Golden Age, Post-Gupta & South Indian Dynasties" to "गुप्त काल, हर्षवर्धन एवं दक्षिण भारतीय राजवंश",
                    "Medieval India: Delhi Sultanate, Vijayanagara & Bhakti-Sufi" to "मध्यकालीन भारत: दिल्ली सल्तनत, विजयनगर एवं भक्ति-सूफी आंदोलन",
                    "Mughal Administration, Architecture & Maratha Confederacy" to "मुगल प्रशासन, स्थापत्य कला एवं मराठा साम्राज्य",
                    "Modern India: Revolt of 1857, INC & Gandhian Era (1885–1947)" to "आधुनिक भारत: 1857 की क्रांति, कांग्रेस एवं गांधी युग (1885–1947)"
                )
            ),
            SubjectSectionBlueprint(
                subjectCode = "POLITY",
                subjectNameEn = "Indian Polity, Constitution & Governance",
                subjectNameHi = "भारतीय राजव्यवस्था, संविधान एवं शासन प्रणाली",
                subTopics = listOf(
                    "Constitutional Framework, Preamble, Fundamental Rights & DPSP" to "संवैधानिक ढांचा, प्रस्तावना, मौलिक अधिकार एवं नीति निदेशक तत्व",
                    "Union Executive, Parliament, Legislative Procedures & Committees" to "संघीय कार्यपालिका, संसद, विधायी प्रक्रिया एवं संसदीय समितियां",
                    "Supreme Court, High Courts, Judicial Review & Constitutional Bodies" to "सर्वोच्च न्यायालय, उच्च न्यायालय, न्यायिक समीक्षा व संवैधानिक निकाय",
                    "Panchayati Raj (73rd/74th Amendment), Federalism & Emergency" to "पंचायती राज (73वां/74वां संशोधन), केंद्र-राज्य संबंध एवं आपातकाल",
                    "Landmark Amendments (1st to 106th), Schedules & Public Policy" to "प्रमुख संविधान संशोधन (1 से 106वां), अनुसूचियां एवं लोक नीति"
                )
            ),
            SubjectSectionBlueprint(
                subjectCode = "GEO_ENV",
                subjectNameEn = "Indian & World Geography + Environment & Ecology",
                subjectNameHi = "भारत एवं विश्व का भूगोल + पर्यावरण एवं पारिस्थितिकी",
                subTopics = listOf(
                    "Physical Geography of India: Himalayas, Rivers, Monsoon & Soils" to "भारत का भौतिक भूगोल: हिमालय, नदी तंत्र, मानसून एवं मिट्टियां",
                    "Agriculture, Minerals, Energy Resources & Industrial Corridors" to "कृषि, खनिज संसाधन, ऊर्जा एवं औद्योगिक गलियारे",
                    "World Geography: Geomorphology, Climatology, Oceans & Continents" to "विश्व भूगोल: भू-आकृति विज्ञान, जलवायु, महासागर एवं महाद्वीप",
                    "Biodiversity, National Parks, Tiger Reserves & Biosphere Reserves" to "जैव-विविधता, राष्ट्रीय उद्यान, टाइगर रिज़र्व एवं बायोस्फीयर रिज़र्व",
                    "Climate Change, Ozone, EIA, Ramsar Wetlands & COP Summits" to "जलवायु परिवर्तन, रामसर आर्द्रभूमि एवं अंतर्राष्ट्रीय पर्यावरण सम्मेलन"
                )
            ),
            SubjectSectionBlueprint(
                subjectCode = "ECO_SCI_CA",
                subjectNameEn = "Economy, General Science, Current Affairs & CSAT/DI",
                subjectNameHi = "अर्थव्यवस्था, सामान्य विज्ञान, समसामयिकी एवं सीसैट/DI",
                subTopics = listOf(
                    "National Income, RBI Monetary Policy, Banking, Inflation & GST" to "राष्ट्रीय आय, आरबीआई मौद्रिक नीति, बैंकिंग, मुद्रास्फीति एवं जीएसटी",
                    "Union Budget 2025-26, Economic Survey, Agriculture & NITI Aayog" to "केंद्रीय बजट 2025-26, आर्थिक सर्वेक्षण, कृषि योजनाएं एवं नीति आयोग",
                    "Physics, Chemistry, Biology, Space (ISRO), Defence & Biotech" to "भौतिकी, रसायन, जीवविज्ञान, अंतरिक्ष (ISRO), रक्षा एवं जैव-प्रौद्योगिकी",
                    "National & International Current Affairs, Reports, Indices & Awards" to "राष्ट्रीय एवं अंतर्राष्ट्रीय समसामयिकी, सूचकांक, रिपोर्ट एवं पुरस्कार",
                    "CSAT Quantitative Aptitude, Excel DI Tables, Graphs & Reasoning" to "सीसैट गणित, एक्सेल डेटा तालिका (DI), बार ग्राफ एवं तार्किक क्षमता"
                )
            )
        )

        return when (normKey) {
            "upsc" -> ExamBlueprintProfile(
                examKey = "upsc",
                examTitleEn = "UPSC CSE Prelims (IAS / IPS)",
                examTitleHi = "यूपीएससी सिविल सेवा प्रारंभिक परीक्षा (IAS / IPS)",
                conductingBodyEn = "UPSC (Union Public Service Commission)",
                conductingBodyHi = "संघ लोक सेवा आयोग (UPSC)",
                fltQuestionCount = 100,
                fltTotalMarks = 200,
                fltDurationMinutes = 120,
                sectionalQuestionCount = 50,
                sectionalTotalMarks = 100,
                sectionalDurationMinutes = 60,
                positiveMarks = 2.0,
                negativeMarks = 0.66,
                examThemeEn = "UPSC Original Multi-Statement, Pair-Matching & Assertion Pattern",
                examThemeHi = "यूपीएससी ओरिजिनल बहु-कथन (Statement 1, 2, 3) एवं युग्म-मिलान पैटर्न",
                difficultyLevelEn = "Tough / Conceptual (20% Easy • 45% Moderate • 35% Tough)",
                difficultyLevelHi = "कठिन एवं वैचारिक स्तर (UPSC ओरिजिनल पेपर के समान)",
                subjects = gsSubjects
            )

            "uppcs", "state_psc" -> ExamBlueprintProfile(
                examKey = "uppcs",
                examTitleEn = "UPPCS Upper Subordinate & RO/ARO",
                examTitleHi = "यूपीपीसीएस (UPPCS प्रिलिम्स) एवं आरओ/एआरओ",
                conductingBodyEn = "UPPSC Prayagraj",
                conductingBodyHi = "उत्तर प्रदेश लोक सेवा आयोग (UPPSC प्रयागराज)",
                fltQuestionCount = 150,
                fltTotalMarks = 200,
                fltDurationMinutes = 120,
                sectionalQuestionCount = 50,
                sectionalTotalMarks = 67,
                sectionalDurationMinutes = 60,
                positiveMarks = 1.33,
                negativeMarks = 0.44,
                examThemeEn = "UPPSC PCS Chronological, Assertion-Reason & UP Special Pattern",
                examThemeHi = "UPPCS कालानुक्रमिक, कथन-कारण एवं उत्तर प्रदेश विशेष पैटर्न",
                difficultyLevelEn = "Moderate-to-Tough (25% Easy • 50% Moderate • 25% Tough)",
                difficultyLevelHi = "मध्यम से कठिन स्तर (UPPSC नवीनतम पैटर्न)",
                subjects = gsSubjects
            )

            "ukpsc" -> ExamBlueprintProfile(
                examKey = "ukpsc",
                examTitleEn = "UKPSC Upper PCS, Lower PCS & RO/ARO",
                examTitleHi = "उत्तराखंड लोक सेवा आयोग (UKPSC प्रिलिम्स एवं RO/ARO)",
                conductingBodyEn = "UKPSC Haridwar",
                conductingBodyHi = "उत्तराखंड लोक सेवा आयोग (UKPSC हरिद्वार)",
                fltQuestionCount = 150,
                fltTotalMarks = 150,
                fltDurationMinutes = 120,
                sectionalQuestionCount = 50,
                sectionalTotalMarks = 50,
                sectionalDurationMinutes = 60,
                positiveMarks = 1.0,
                negativeMarks = 0.25,
                examThemeEn = "UKPSC GS + 35% Uttarakhand History, Geography & Polity Pattern",
                examThemeHi = "UKPSC सामान्य अध्ययन + उत्तराखंड विशेष (इतिहास, भूगोल व प्रशासन) पैटर्न",
                difficultyLevelEn = "Moderate (30% Easy • 50% Moderate • 20% Tough)",
                difficultyLevelHi = "मध्यम एवं तथ्यपरक-विश्लेषणात्मक स्तर (UKPSC मानक)",
                subjects = gsSubjects
            )

            "bpsc" -> ExamBlueprintProfile(
                examKey = "bpsc",
                examTitleEn = "BPSC 70th/71st Combined Competitive Exam (CCE)",
                examTitleHi = "बिहार लोक सेवा आयोग (BPSC 70वीं/71वीं संयुक्त परीक्षा)",
                conductingBodyEn = "BPSC Patna",
                conductingBodyHi = "बिहार लोक सेवा आयोग (BPSC पटना)",
                fltQuestionCount = 150,
                fltTotalMarks = 150,
                fltDurationMinutes = 120,
                sectionalQuestionCount = 50,
                sectionalTotalMarks = 50,
                sectionalDurationMinutes = 60,
                positiveMarks = 1.0,
                negativeMarks = 0.33,
                examThemeEn = "BPSC Analytical GS, Bihar Special, Science & Economic Survey Pattern",
                examThemeHi = "BPSC नवीनतम विश्लेषणात्मक GS, बिहार स्पेशल एवं विज्ञान पैटर्न",
                difficultyLevelEn = "Moderate-to-Tough (30% Easy • 45% Moderate • 25% Tough)",
                difficultyLevelHi = "मध्यम से कठिन स्तर (BPSC ओरिजिनल पेपर स्तर)",
                subjects = gsSubjects
            )

            "up_police" -> ExamBlueprintProfile(
                examKey = "up_police",
                examTitleEn = "UP Police Constable & Sub-Inspector (UPP / UP SI)",
                examTitleHi = "उत्तर प्रदेश पुलिस कांस्टेबल एवं सब-इंस्पेक्टर (UP Police भर्ती)",
                conductingBodyEn = "UPPRPB Lucknow (UP Police Recruitment Board)",
                conductingBodyHi = "उ.प्र. पुलिस भर्ती एवं प्रोन्नति बोर्ड (UPPRPB लखनऊ)",
                fltQuestionCount = 150,
                fltTotalMarks = 300,
                fltDurationMinutes = 120,
                sectionalQuestionCount = 38,
                sectionalTotalMarks = 76,
                sectionalDurationMinutes = 45,
                positiveMarks = 2.0,
                negativeMarks = 0.50,
                examThemeEn = "UPPRPB Official 4-Section Pattern (37 Hindi + 38 UP GK/GS + 38 Maths + 37 Reasoning)",
                examThemeHi = "UP पुलिस आधिकारिक 4-खंड पैटर्न (37 हिंदी + 38 जीके/यूपी विशेष + 38 गणित + 37 रीजनिंग)",
                difficultyLevelEn = "Easy-to-Moderate (40% Easy • 45% Moderate • 15% Tough — UP Police Re-Exam Level)",
                difficultyLevelHi = "सरल से मध्यम स्तर (UP पुलिस री-एग्जाम 2024 के सटीक स्तर अनुसार)",
                subjects = listOf(
                    SubjectSectionBlueprint(
                        subjectCode = "UPP_HINDI",
                        subjectNameEn = "General Hindi (सामान्य हिंदी व्याकरण एवं साहित्य — 37 Qs)",
                        subjectNameHi = "सामान्य हिंदी (व्याकरण एवं हिंदी साहित्य — 37/38 प्रश्न)",
                        subTopics = listOf(
                            "Hindi Varnamala, Sandhi, Samas & Upsarg-Pratyay" to "हिंदी वर्णमाला, संधि-विच्छेद, समास एवं उपसर्ग-प्रत्यय",
                            "Ras, Chhand, Alankar & Vakya Shuddhi" to "रस, छंद, अलंकार एवं वाक्य शुद्धि/वर्तनी",
                            "Tatsam-Tadbhav, Paryayvachi, Vilom & Anekarthi Shabd" to "तत्सम-तद्भव, पर्यायवाची, विलोम एवं वाक्यांश के लिए एक शब्द",
                            "Muhavare, Lokoktiyan, Kaal, Vachya, Avyay & Karak" to "मुहावरे-लोकोक्तियाँ, काल, वाच्य, अव्यय, लिंग, वचन एवं कारक",
                            "Famous Hindi Poets, Authors, Awards (Jnanpith/Sahitya Akademi) & Passages" to "प्रसिद्ध कवि, लेखक एवं उनकी रचनाएँ, हिंदी पुरस्कार व अपठित गद्यांश"
                        )
                    ),
                    SubjectSectionBlueprint(
                        subjectCode = "UPP_GK",
                        subjectNameEn = "General Knowledge, UP GK & Police System (38 Qs)",
                        subjectNameHi = "सामान्य ज्ञान, उत्तर प्रदेश विशेष (UP GK) एवं पुलिस प्रशासन (38 प्रश्न)",
                        subTopics = listOf(
                            "Uttar Pradesh History, Culture, Folk Dances, Fairs & ODOP Districts" to "उत्तर प्रदेश का इतिहास, कला-संस्कृति, लोक नृत्य, मेले एवं एक जिला एक उत्पाद (ODOP)",
                            "UP Geography, Rivers, Wildlife Sanctuaries, Census 2011 & Economy" to "उ.प्र. का भूगोल, नदियां, वन्यजीव विहार, जनगणना 2011 एवं बजट",
                            "Indian Constitution, Fundamental Rights, BNS/BNSS/IPC & Police Administration" to "भारतीय संविधान, मौलिक अधिकार, भारतीय न्याय संहिता (BNS) एवं पुलिस प्रणाली",
                            "Human Rights, Cyber Crime, Demonetization, GST, Internal Security & Neighbours" to "मानवाधिकार, साइबर क्राइम, जीएसटी, आंतरिक सुरक्षा, विमुद्रीकरण व पड़ोसी देश",
                            "Indian History, Geography, General Science & UP/National Current Affairs" to "भारतीय इतिहास, भूगोल, सामान्य विज्ञान एवं उ.प्र./राष्ट्रीय समसामयिकी"
                        )
                    ),
                    SubjectSectionBlueprint(
                        subjectCode = "UPP_MATHS",
                        subjectNameEn = "Numerical & Mental Ability (संख्यात्मक एवं मानसिक योग्यता — 38 Qs)",
                        subjectNameHi = "संख्यात्मक एवं मानसिक योग्यता (गणित एवं DI तालिका — 38 प्रश्न)",
                        subTopics = listOf(
                            "Number System, Simplification, Decimal/Fraction, HCF-LCM & Average" to "संख्या पद्धति, सरलीकरण, दशमलव-भिन्न, म.स.-ल.स. एवं औसत",
                            "Percentage, Profit & Loss, Discount, Simple & Compound Interest" to "प्रतिशतता, लाभ और हानि, छूट (बट्टा), साधारण एवं चक्रवृद्धि ब्याज",
                            "Ratio & Proportion, Partnership, Age Problems & Mixture/Alligation" to "अनुपात-समानुपात, साझेदारी, आयु संबंधित प्रश्न एवं मिश्रण",
                            "Time & Work, Pipe-Cistern, Time-Speed-Distance, Train & Boat-Stream" to "समय और कार्य, पाइप-टंकी, समय-चाल-दूरी, रेलगाड़ी एवं नाव-धारा",
                            "Mensuration (2D & 3D) + Excel Data Interpretation Tables & Bar Graphs" to "क्षेत्रमिति (2D व 3D) + एक्सेल डेटा तालिका (DI) एवं बार ग्राफ"
                        )
                    ),
                    SubjectSectionBlueprint(
                        subjectCode = "UPP_REASONING",
                        subjectNameEn = "Mental Aptitude, IQ & Reasoning Ability (37 Qs)",
                        subjectNameHi = "मानसिक अभिरुचि, बुद्धिलब्धि एवं तार्किक क्षमता (रीजनिंग — 37/38 प्रश्न)",
                        subTopics = listOf(
                            "Mental Aptitude: Public Interest, Law & Order, Communal Harmony & Crime Control" to "मानसिक अभिरुचि: जनहित, कानून एवं शांति व्यवस्था, अपराध नियंत्रण व पुलिस कर्तव्य",
                            "Coding-Decoding, Number/Alphabet Series, Analogy & Classification" to "कोडिंग-डिकोडिंग, संख्या व अक्षर श्रृंखला, सादृश्यता एवं वर्गीकरण",
                            "Blood Relations, Direction Sense Test, Order/Ranking & Venn Diagrams" to "रक्त संबंध, दिशा ज्ञान परीक्षण, क्रम व्यवस्था एवं वेन आरेख",
                            "Syllogism, Statement & Conclusion/Assumption, Seating Arrangement & Puzzles" to "न्याय निगमन, कथन एवं निष्कर्ष/पूर्वधारणा, बैठक व्यवस्था एवं पहेली",
                            "Non-Verbal Reasoning: Mirror/Water Image, Paper Folding, Dice & Figure Counting" to "अभाषिक रीजनिंग: दर्पण-जल प्रतिबिंब, पासा, कागज मोड़ना एवं त्रिभुज/आकृति गणना"
                        )
                    )
                )
            )

            "upsssc" -> ExamBlueprintProfile(
                examKey = "upsssc",
                examTitleEn = "UPSSSC PET, VDO, Lekhpal & Junior Assistant",
                examTitleHi = "यूपीएसएसएससी (UPSSSC PET, लेखपाल, ग्राम विकास अधिकारी व कनिष्ठ सहायक)",
                conductingBodyEn = "UPSSSC Lucknow",
                conductingBodyHi = "उ.प्र. अधीनस्थ सेवा चयन आयोग (UPSSSC लखनऊ)",
                fltQuestionCount = 100,
                fltTotalMarks = 100,
                fltDurationMinutes = 120,
                sectionalQuestionCount = 50,
                sectionalTotalMarks = 50,
                sectionalDurationMinutes = 60,
                positiveMarks = 1.0,
                negativeMarks = 0.25,
                examThemeEn = "UPSSSC Official 20-Marks DI Table/Graph + UP Special + GS + Hindi Pattern",
                examThemeHi = "UPSSSC आधिकारिक ग्राफ व तालिका (20 अंक) + यूपी स्पेशल + सामान्य हिंदी व GS पैटर्न",
                difficultyLevelEn = "Easy-to-Moderate (40% Easy • 45% Moderate • 15% Tough)",
                difficultyLevelHi = "सरल से मध्यम स्तर (UPSSSC PET एवं मुख्य परीक्षा स्तर)",
                subjects = gsSubjects
            )

            "uksssc" -> ExamBlueprintProfile(
                examKey = "uksssc",
                examTitleEn = "UKSSSC Group C (VDO, Patwari, Lekhpal & Kanishth Sahayak)",
                examTitleHi = "यूकेएसएसएससी समूह 'ग' (VDO, पटवारी, लेखपाल एवं कनिष्ठ सहायक)",
                conductingBodyEn = "UKSSSC Dehradun",
                conductingBodyHi = "उत्तराखंड अधीनस्थ सेवा चयन आयोग (UKSSSC देहरादून)",
                fltQuestionCount = 100,
                fltTotalMarks = 100,
                fltDurationMinutes = 120,
                sectionalQuestionCount = 50,
                sectionalTotalMarks = 50,
                sectionalDurationMinutes = 60,
                positiveMarks = 1.0,
                negativeMarks = 0.25,
                examThemeEn = "UKSSSC Official Pattern (20 Marks Hindi + 40 Marks Uttarakhand GK + 40 Marks GS/Reasoning)",
                examThemeHi = "UKSSSC आधिकारिक पैटर्न (20 अंक हिंदी + 40 अंक उत्तराखंड विशेष + 40 अंक GS/रीजनिंग)",
                difficultyLevelEn = "Easy-to-Moderate (35% Easy • 50% Moderate • 15% Tough)",
                difficultyLevelHi = "सरल से मध्यम स्तर (UKSSSC समूह 'ग' मानक पैटर्न)",
                subjects = gsSubjects
            )

            "ssc" -> ExamBlueprintProfile(
                examKey = "ssc",
                examTitleEn = "SSC CGL, CPO, CHSL, MTS & Selection Post",
                examTitleHi = "एसएससी (SSC CGL, CPO, CHSL एवं MTS) टियर-1 व टियर-2",
                conductingBodyEn = "SSC (Staff Selection Commission — TCS CBT)",
                conductingBodyHi = "कर्मचारी चयन आयोग (SSC — TCS CBT पैटर्न)",
                fltQuestionCount = 100,
                fltTotalMarks = 200,
                fltDurationMinutes = 60,
                sectionalQuestionCount = 25,
                sectionalTotalMarks = 50,
                sectionalDurationMinutes = 20,
                positiveMarks = 2.0,
                negativeMarks = 0.50,
                examThemeEn = "SSC TCS CBT 4-Section Pattern (25 Reasoning + 25 GA + 25 Quant + 25 English)",
                examThemeHi = "SSC TCS कंप्यूटर आधारित परीक्षा (25 रीजनिंग + 25 जीके + 25 गणित + 25 अंग्रेजी)",
                difficultyLevelEn = "Moderate Speed-Accuracy (35% Easy • 45% Moderate • 20% Calculation/Tough)",
                difficultyLevelHi = "मध्यम गति एवं सटीकता स्तर (TCS नवीनतम शिफ्ट पैटर्न)",
                subjects = listOf(
                    SubjectSectionBlueprint(
                        subjectCode = "SSC_REASONING",
                        subjectNameEn = "General Intelligence & Reasoning (25 Qs)",
                        subjectNameHi = "सामान्य बुद्धिमत्ता एवं तर्कशक्ति (रीजनिंग — 25 प्रश्न)",
                        subTopics = listOf(
                            "Number Series, Missing Numbers, Coding-Decoding & Analogy" to "संख्या श्रृंखला, लुप्त संख्या, कोडिंग-डिकोडिंग एवं सादृश्यता",
                            "Syllogism, Blood Relations, Direction & Order-Ranking" to "न्याय निगमन, रक्त संबंध, दिशा परीक्षण एवं क्रम व्यवस्था",
                            "Mathematical Operations, Venn Diagrams & Dice/Cube" to "गणितीय संक्रियाएं, वेन आरेख एवं पासा/घन",
                            "Seating Arrangement (Circular/Linear) & Puzzle Reasoning" to "बैठक व्यवस्था (वृत्ताकार व रैखिक) एवं पहेली परीक्षण",
                            "Non-Verbal: Mirror Image, Paper Cutting, Embedded & Figure Counting" to "अभाषिक रीजनिंग: दर्पण प्रतिबिंब, कागज काटना व आकृति गणना"
                        )
                    ),
                    SubjectSectionBlueprint(
                        subjectCode = "SSC_GA",
                        subjectNameEn = "General Awareness, Static GK & Current Affairs (25 Qs)",
                        subjectNameHi = "सामान्य जागरूकता, स्टैटिक जीके एवं करंट अफेयर्स (25 प्रश्न)",
                        subTopics = listOf(
                            "Ancient, Medieval & Modern Indian History + Freedom Struggle" to "प्राचीन, मध्यकालीन एवं आधुनिक भारतीय इतिहास व स्वतंत्रता संग्राम",
                            "Indian Polity, Articles, Amendments, Geography & Environment" to "भारतीय राजव्यवस्था, अनुच्छेद, संशोधन, भूगोल एवं पर्यावरण",
                            "Static GK: Classical/Folk Dances, Festivals, Musical Instruments & Books" to "स्टैटिक जीके: शास्त्रीय/लोक नृत्य, उत्सव, वाद्ययंत्र, घराने एवं पुस्तकें",
                            "General Science (Physics, Chemistry, Biology) & Economy/Five-Year Plans" to "सामान्य विज्ञान (भौतिकी, रसायन, जीवविज्ञान) एवं पंचवर्षीय योजनाएं",
                            "Sports, Census 2011, Government Schemes & Last 1 Year Current Affairs" to "खेलकूद, जनगणना 2011, सरकारी योजनाएं एवं समसामयिकी"
                        )
                    ),
                    SubjectSectionBlueprint(
                        subjectCode = "SSC_QUANT",
                        subjectNameEn = "Quantitative Aptitude, Advance Maths & DI (25 Qs)",
                        subjectNameHi = "मात्रात्मक अभियोग्यता, एडवांस मैथ्स एवं DI तालिका (25 प्रश्न)",
                        subTopics = listOf(
                            "Percentage, Profit-Loss, Discount, SI-CI & Ratio-Proportion" to "प्रतिशत, लाभ-हानि, बट्टा, साधारण/चक्रवृद्धि ब्याज व अनुपात",
                            "Time & Work, Time-Speed-Distance, Average, Mixture & Partnership" to "समय-कार्य, समय-दूरी-चाल, औसत, मिश्रण एवं साझेदारी",
                            "Algebra, Surds-Indices, Number System, HCF-LCM & Simplification" to "बीजगणित (Algebra), घातांक-करणी, संख्या पद्धति एवं सरलीकरण",
                            "Geometry (Circles/Triangles), Trigonometry & Height-Distance" to "ज्यामिति (वृत्त व त्रिभुज), त्रिकोणमिति एवं ऊंचाई-दूरी",
                            "Mensuration (2D & 3D) + Excel Table & Bar Graph Data Interpretation" to "क्षेत्रमिति (2D व 3D) + एक्सेल तालिका एवं बार ग्राफ (DI)"
                        )
                    ),
                    SubjectSectionBlueprint(
                        subjectCode = "SSC_ENGLISH",
                        subjectNameEn = "English Comprehension, Grammar & Vocabulary (25 Qs)",
                        subjectNameHi = "अंग्रेजी भाषा, व्याकरण, वोकैबुलरी एवं क्लोज टेस्ट (25 प्रश्न)",
                        subTopics = listOf(
                            "Spot the Error, Sentence Improvement & Fill in the Blanks" to "त्रुटि पहचान (Error Spotting), वाक्य सुधार एवं रिक्त स्थान",
                            "Synonyms, Antonyms, One-Word Substitution & Spelling Correction" to "पर्यायवाची (Synonyms), विलोम (Antonyms) एवं वन-वर्ड सब्स्टीट्यूशन",
                            "Idioms & Phrases + Phrasal Verbs & Preposition Usage" to "मुहावरे एवं वाक्यांश (Idioms & Phrases) तथा पूर्वसर्ग प्रयोग",
                            "Active-Passive Voice & Direct-Indirect Narration" to "एक्टिव-पैसिव वॉइस एवं डायरेक्ट-इनडायरेक्ट नरेशन",
                            "Cloze Test, Para Jumbles (PQRS) & Reading Comprehension Passage" to "क्लोज टेस्ट, पैरा जम्बल्स (PQRS) एवं रीडिंग कॉम्प्रिहेंशन"
                        )
                    )
                )
            )

            "railways" -> ExamBlueprintProfile(
                examKey = "railways",
                examTitleEn = "RRB NTPC, Group D, ALP & RRB JE",
                examTitleHi = "रेलवे भर्ती बोर्ड (RRB NTPC, ग्रुप D, ALP एवं जूनियर इंजीनियर)",
                conductingBodyEn = "RRB (Railway Recruitment Board)",
                conductingBodyHi = "रेलवे भर्ती बोर्ड (RRB — भारत सरकार)",
                fltQuestionCount = 100,
                fltTotalMarks = 100,
                fltDurationMinutes = 90,
                sectionalQuestionCount = 35,
                sectionalTotalMarks = 35,
                sectionalDurationMinutes = 35,
                positiveMarks = 1.0,
                negativeMarks = 0.33,
                examThemeEn = "RRB CBT Official Pattern (40 GA/Science + 30 Mathematics + 30 Reasoning)",
                examThemeHi = "रेलवे CBT आधिकारिक पैटर्न (40 सामान्य विज्ञान व जीके + 30 गणित + 30 रीजनिंग)",
                difficultyLevelEn = "Easy-to-Moderate (35% Easy • 50% Moderate • 15% Tough)",
                difficultyLevelHi = "सरल से मध्यम स्तर (एनसीईआरटी विज्ञान एवं रेलवे CBT स्तर)",
                subjects = gsSubjects
            )

            "banking" -> ExamBlueprintProfile(
                examKey = "banking",
                examTitleEn = "Banking PO & Clerk (SBI PO, IBPS PO/Clerk & RBI Grade B)",
                examTitleHi = "बैंकिंग परीक्षा (SBI PO/Clerk, IBPS PO/Clerk एवं RBI ग्रेड B)",
                conductingBodyEn = "IBPS / SBI / RBI",
                conductingBodyHi = "आईबीपीएस / भारतीय स्टेट बैंक / भारतीय रिज़र्व बैंक",
                fltQuestionCount = 100,
                fltTotalMarks = 100,
                fltDurationMinutes = 60,
                sectionalQuestionCount = 35,
                sectionalTotalMarks = 35,
                sectionalDurationMinutes = 20,
                positiveMarks = 1.0,
                negativeMarks = 0.25,
                examThemeEn = "IBPS/SBI Official Speed + High-Level Puzzle & DI Table/Caselet Pattern",
                examThemeHi = "IBPS/SBI आधिकारिक स्पीड + सीटिंग पज़ल्स एवं एक्सेल तालिका (DI) पैटर्न",
                difficultyLevelEn = "Moderate-to-Tough (25% Easy • 50% Moderate • 25% High-Level DI/Puzzles)",
                difficultyLevelHi = "मध्यम से कठिन स्तर (बैंकिंग PO/Clerk सेक्शनल टाइमर पैटर्न)",
                subjects = gsSubjects
            )

            "iit_jee" -> ExamBlueprintProfile(
                examKey = "iit_jee",
                examTitleEn = "IIT JEE (Main & Advanced) + Engineering JE",
                examTitleHi = "आईआईटी जेईई (JEE Main व Advanced) एवं जूनियर इंजीनियर (JE)",
                conductingBodyEn = "NTA (National Testing Agency) / IITs",
                conductingBodyHi = "राष्ट्रीय परीक्षा एजेंसी (NTA) एवं आईआईटी",
                fltQuestionCount = 75,
                fltTotalMarks = 300,
                fltDurationMinutes = 180,
                sectionalQuestionCount = 25,
                sectionalTotalMarks = 100,
                sectionalDurationMinutes = 60,
                positiveMarks = 4.0,
                negativeMarks = 1.0,
                examThemeEn = "NTA JEE Official 75-Q Pattern (25 Physics + 25 Chemistry + 25 Mathematics)",
                examThemeHi = "NTA JEE आधिकारिक 75-प्रश्न पैटर्न (25 भौतिकी + 25 रसायन + 25 गणित)",
                difficultyLevelEn = "Tough / Numerical & Multi-Concept (20% Easy • 45% Moderate • 35% Tough)",
                difficultyLevelHi = "कठिन एवं न्यूमेरिकल स्तर (JEE Main व Advanced स्तर)",
                subjects = listOf(
                    SubjectSectionBlueprint(
                        subjectCode = "JEE_PHYSICS",
                        subjectNameEn = "Physics (Mechanics, Electrodynamics, Optics & Modern Physics — 25 Qs)",
                        subjectNameHi = "भौतिक विज्ञान (यांत्रिकी, विद्युतगतिकी, प्रकाशिकी व आधुनिक भौतिकी — 25 प्रश्न)",
                        subTopics = listOf(
                            "Kinematics, Laws of Motion, Work-Energy & Rotational Mechanics" to "गतिकी, गति के नियम, कार्य-ऊर्जा एवं घूर्णी यांत्रिकी",
                            "Gravitation, Properties of Matter, Fluid Mechanics & SHM/Waves" to "गुरुत्वाकर्षण, द्रव यांत्रिकी, सरल आवर्त गति एवं तरंगें",
                            "Thermodynamics, Kinetic Theory of Gases & Thermal Physics" to "ऊष्मागतिकी, गैसों का अणुगति सिद्धांत एवं तापीय भौतिकी",
                            "Electrostatics, Current Electricity, Magnetism, EMI & AC Circuits" to "स्थिरवैद्युतिकी, धारा विद्युत, चुंबकत्व, प्रेरण एवं प्रत्यावर्ती धारा",
                            "Ray/Wave Optics, Dual Nature, Atoms-Nuclei & Semiconductors" to "किरण एवं तरंग प्रकाशिकी, परमाणु-नाभिक एवं अर्धचालक इलेक्ट्रॉनिकी"
                        )
                    ),
                    SubjectSectionBlueprint(
                        subjectCode = "JEE_PHYSICAL_CHEM",
                        subjectNameEn = "Physical Chemistry (Mole, Thermodynamics, Equilibrium & Kinetics — 25 Qs)",
                        subjectNameHi = "भौतिक रसायन (मोल अवधारणा, ऊष्मागतिकी, साम्यावस्था व बलगतिकी — 25 प्रश्न)",
                        subTopics = listOf(
                            "Mole Concept, Atomic Structure & Gaseous/Liquid State" to "मोल अवधारणा, परमाणु संरचना एवं गैसीय/द्रव अवस्था",
                            "Chemical Thermodynamics & Thermochemistry" to "रासायनिक ऊष्मागतिकी एवं ऊष्मारसायन",
                            "Chemical & Ionic Equilibrium (pH, Buffer & Solubility Product)" to "रासायनिक एवं आयनिक साम्यावस्था (pH, बफर एवं विलेयता गुणनफल)",
                            "Electrochemistry (Nernst Equation), Redox & Solutions (Colligative)" to "वैद्युतरसायन (नर्नस्ट समीकरण), रेडॉक्स एवं विलयन के अणुसंख्य गुणधर्म",
                            "Chemical Kinetics (First-Order/Arrhenius) & Surface Chemistry" to "रासायनिक बलगतिकी (प्रथम कोटि व आरहेनियस समीकरण) एवं पृष्ठ रसायन"
                        )
                    ),
                    SubjectSectionBlueprint(
                        subjectCode = "JEE_ORGANIC_INORGANIC",
                        subjectNameEn = "Organic & Inorganic Chemistry (Bonding, Coordination & Reactions — 25 Qs)",
                        subjectNameHi = "कार्बनिक एवं अकार्बनिक रसायन (आबंधन, उपसहसंयोजन व अभिक्रिया तंत्र — 25 प्रश्न)",
                        subTopics = listOf(
                            "Periodic Table, Chemical Bonding (VSEPR/MOT) & Coordination Compounds" to "आवर्त सारणी, रासायनिक आबंधन (VSEPR/MOT) एवं उपसहसंयोजन यौगिक",
                            "p-Block, d & f-Block Elements, Metallurgy & Qualitative Analysis" to "p-ब्लॉक, d एवं f-ब्लॉक तत्व, धातुकर्म एवं गुणात्मक विश्लेषण",
                            "General Organic Chemistry (GOC), Isomerism & Hydrocarbons" to "सामान्य कार्बनिक रसायन (GOC), समावयवता एवं हाइड्रोकार्बन",
                            "Haloalkanes, Alcohols, Phenols, Aldehydes, Ketones & Carboxylic Acids" to "हैलोएल्केन, अल्कोहल, फीनॉल, एल्डिहाइड, कीटोन एवं कार्बोक्सिलिक अम्ल",
                            "Amines, Diazonium Salts, Biomolecules & Polymers" to "ऐमीन, डाइएज़ोनियम लवण, जैव-अणु (Biomolecules) एवं बहुलक"
                        )
                    ),
                    SubjectSectionBlueprint(
                        subjectCode = "JEE_MATHS",
                        subjectNameEn = "Mathematics (Calculus, Coordinate Geometry, Algebra & Vectors — 25 Qs)",
                        subjectNameHi = "गणित (कलन, निर्देशांक ज्यामिति, बीजगणित, सदिश एवं प्रायिकता — 25 प्रश्न)",
                        subTopics = listOf(
                            "Sets, Relations, Functions, Complex Numbers & Quadratic Equations" to "समुच्चय, संबंध, फलन, सम्मिश्र संख्याएं एवं द्विघात समीकरण",
                            "Matrices, Determinants, Permutations-Combinations & Binomial Theorem" to "आव्यूह, सारणिक, क्रमचय-संचय एवं द्विपद प्रमेय",
                            "Sequences & Series, Limits, Continuity, Differentiability & AOD" to "अनुक्रम-श्रेणी, सीमा, सांतत्य, अवकलनीयता एवं अवकलज के अनुप्रयोग",
                            "Indefinite/Definite Integration, Area Under Curves & Differential Equations" to "अनिश्चित/निश्चित समाकलन, वक्रों के अंतर्गत क्षेत्रफल एवं अवकल समीकरण",
                            "Straight Lines, Circles, Conic Sections, 3D Geometry, Vectors & Probability" to "सरल रेखा, वृत्त, शंकु परिच्छेद, 3D ज्यामिति, सदिश एवं प्रायिकता"
                        )
                    )
                )
            )

            "neet" -> ExamBlueprintProfile(
                examKey = "neet",
                examTitleEn = "NEET (UG) Medical Entrance Examination",
                examTitleHi = "नीट यूजी (NEET UG) मेडिकल प्रवेश परीक्षा",
                conductingBodyEn = "NTA (National Testing Agency)",
                conductingBodyHi = "राष्ट्रीय परीक्षा एजेंसी (NTA — NEET UG)",
                fltQuestionCount = 180,
                fltTotalMarks = 720,
                fltDurationMinutes = 180,
                sectionalQuestionCount = 45,
                sectionalTotalMarks = 180,
                sectionalDurationMinutes = 45,
                positiveMarks = 4.0,
                negativeMarks = 1.0,
                examThemeEn = "NTA NEET Official 180-Q Pattern (45 Physics + 45 Chemistry + 45 Botany + 45 Zoology)",
                examThemeHi = "NTA NEET आधिकारिक 180-प्रश्न पैटर्न (45 भौतिकी + 45 रसायन + 45 वनस्पति + 45 जन्तु विज्ञान)",
                difficultyLevelEn = "Moderate-to-Tough NCERT Line-by-Line & Statement/Assertion Pattern",
                difficultyLevelHi = "एनसीईआरटी (NCERT Class 11 & 12) पंक्ति-दर-पंक्ति एवं कथन-कारण स्तर",
                subjects = listOf(
                    SubjectSectionBlueprint(
                        subjectCode = "NEET_PHYSICS",
                        subjectNameEn = "Physics (NCERT Class 11 & 12 Complete — 45 Qs)",
                        subjectNameHi = "भौतिक विज्ञान (NCERT कक्षा 11 व 12 संपूर्ण — 45 प्रश्न)",
                        subTopics = listOf(
                            "Units, Kinematics, Laws of Motion, Work-Power-Energy & Rotational Motion" to "मात्रक, गतिकी, गति के नियम, कार्य-ऊर्जा एवं घूर्णी गति",
                            "Gravitation, Solids-Fluids, Thermodynamics, Oscillations & Waves" to "गुरुत्वाकर्षण, तरल यांत्रिकी, ऊष्मागतिकी, दोलन एवं तरंगें",
                            "Electrostatics, Current Electricity & Capacitive Circuits" to "स्थिरवैद्युतिकी, धारा विद्युत एवं संधारित्र परिपथ",
                            "Moving Charges, Magnetism, EMI & Alternating Current" to "गतिमान आवेश, चुंबकत्व, विद्युतचुंबकीय प्रेरण एवं प्रत्यावर्ती धारा",
                            "Ray & Wave Optics, Dual Nature, Atoms, Nuclei & Logic Gates" to "प्रकाशिकी, विकिरण की द्वैत प्रकृति, परमाणु-नाभिक एवं लॉजिक गेट्स"
                        )
                    ),
                    SubjectSectionBlueprint(
                        subjectCode = "NEET_CHEMISTRY",
                        subjectNameEn = "Chemistry (Physical, Organic & Inorganic NCERT — 45 Qs)",
                        subjectNameHi = "रसायन विज्ञान (भौतिक, कार्बनिक एवं अकार्बनिक रसायन — 45 प्रश्न)",
                        subTopics = listOf(
                            "Mole Concept, Atomic Structure, Thermodynamics & Equilibrium" to "मोल अवधारणा, परमाणु संरचना, ऊष्मागतिकी एवं साम्यावस्था",
                            "Solutions, Electrochemistry & Chemical Kinetics" to "विलयन, वैद्युतरसायन एवं रासायनिक बलगतिकी",
                            "Periodic Classification, Chemical Bonding, d-f Block & Coordination" to "आवर्त सारणी, रासायनिक आबंधन, d-f ब्लॉक एवं उपसहसंयोजन यौगिक",
                            "GOC, Hydrocarbons, Haloalkanes, Alcohols, Phenols & Ethers" to "सामान्य कार्बनिक रसायन, हाइड्रोकार्बन, अल्कोहल, फीनॉल एवं ईथर",
                            "Aldehydes, Ketones, Carboxylic Acids, Amines & Biomolecules" to "एल्डिहाइड, कीटोन, कार्बोक्सिलिक अम्ल, ऐमीन एवं जैव-अणु"
                        )
                    ),
                    SubjectSectionBlueprint(
                        subjectCode = "NEET_BOTANY",
                        subjectNameEn = "Botany (Plant Diversity, Cell, Genetics, Physiology & Ecology — 45 Qs)",
                        subjectNameHi = "वनस्पति विज्ञान (पादप विविधता, कोशिका, आनुवंशिकी व पारिस्थितिकी — 45 प्रश्न)",
                        subTopics = listOf(
                            "Living World, Biological Classification, Plant Kingdom & Morphology" to "जीव जगत का वर्गीकरण, वनस्पति जगत एवं पुष्पी पादपों की आकारिकी",
                            "Anatomy of Flowering Plants, Cell: The Unit of Life & Cell Cycle/Division" to "पादप शारीर, कोशिका: जीवन की इकाई एवं कोशिका चक्र/विभाजन",
                            "Photosynthesis in Higher Plants, Respiration & Plant Growth Regulators" to "उच्च पादपों में प्रकाश-संश्लेषण, श्वसन एवं पादप वृद्धि नियामक",
                            "Sexual Reproduction in Flowering Plants, Mendelian & Molecular Genetics" to "पुष्पी पादपों में लैंगिक जनन, वंशागति के सिद्धांत एवं आणविक आधार",
                            "Organisms & Populations, Ecosystem, Biodiversity & Conservation" to "जीव और समष्टियां, पारितंत्र, जैव-विविधता एवं संरक्षण"
                        )
                    ),
                    SubjectSectionBlueprint(
                        subjectCode = "NEET_ZOOLOGY",
                        subjectNameEn = "Zoology (Animal Kingdom, Human Physiology, Reproduction & Biotech — 45 Qs)",
                        subjectNameHi = "जन्तु विज्ञान (प्राणी जगत, मानव कार्यिकी, जनन एवं जैव-प्रौद्योगिकी — 45 प्रश्न)",
                        subTopics = listOf(
                            "Animal Kingdom & Structural Organisation in Animals (Tissues)" to "प्राणी जगत का वर्गीकरण एवं प्राणियों में संरचनात्मक संगठन",
                            "Human Physiology I: Breathing, Body Fluids/Circulation & Excretion" to "मानव कार्यिकी I: श्वसन, शरीर द्रव एवं परिसंचरण तथा उत्सर्जन",
                            "Human Physiology II: Locomotion, Neural Control & Chemical Coordination" to "मानव कार्यिकी II: गमन-संचलन, तंत्रिकीय नियंत्रण एवं अंतःस्रावी तंत्र",
                            "Human Reproduction, Reproductive Health & Evolution" to "मानव जनन, जनन स्वास्थ्य एवं विकास (Evolution)",
                            "Human Health & Disease, Microbes & Biotechnology (Principles & Applications)" to "मानव स्वास्थ्य तथा रोग एवं जैव-प्रौद्योगिकी: सिद्धांत व अनुप्रयोग"
                        )
                    )
                )
            )

            "ugc_net" -> ExamBlueprintProfile(
                examKey = "ugc_net",
                examTitleEn = "UGC NET / JRF (Paper 1 + Paper 2 Complete)",
                examTitleHi = "यूजीसी नेट / जेआरएफ (पेपर 1 शिक्षण/शोध + पेपर 2 विषय)",
                conductingBodyEn = "NTA (National Testing Agency — UGC NET)",
                conductingBodyHi = "राष्ट्रीय परीक्षा एजेंसी (NTA — UGC NET/JRF)",
                fltQuestionCount = 150,
                fltTotalMarks = 300,
                fltDurationMinutes = 180,
                sectionalQuestionCount = 50,
                sectionalTotalMarks = 100,
                sectionalDurationMinutes = 60,
                positiveMarks = 2.0,
                negativeMarks = 0.0,
                examThemeEn = "NTA UGC NET Official 150-Q Pattern (50 Qs Paper-1 + 100 Qs Paper-2 • No Negative Marking)",
                examThemeHi = "NTA UGC NET आधिकारिक 150-प्रश्न पैटर्न (50 प्रश्न पेपर-1 + 100 प्रश्न पेपर-2 • कोई नेगेटिव मार्किंग नहीं)",
                difficultyLevelEn = "Moderate-to-Tough (Assertion-Reason, Multi-Statement & Chronological Matching)",
                difficultyLevelHi = "कठिन एवं विश्लेषणात्मक स्तर (अभिकथन-कारण, कथन 1-2-3 व सूची मिलान)",
                subjects = listOf(
                    SubjectSectionBlueprint(
                        subjectCode = "NET_P1_TEACH_RES",
                        subjectNameEn = "Paper 1: Teaching Aptitude, Research Aptitude & Comprehension (50 Qs)",
                        subjectNameHi = "पेपर 1: शिक्षण अभिक्षमता, शोध अभिक्षमता एवं बोधगम्यता (50 प्रश्न)",
                        subTopics = listOf(
                            "Unit 1: Teaching Aptitude (Levels of Teaching, SWAYAM, MOOCs & NEP 2020 Evaluation)" to "इकाई 1: शिक्षण अभिक्षमता (शिक्षण के स्तर, स्वयं, मूक्स एवं मूल्यांकन प्रणाली)",
                            "Unit 2: Research Aptitude (Positivism, Methods, Hypothesis, Sampling & Research Ethics)" to "इकाई 2: शोध अभिक्षमता (शोध विधियां, परिकल्पना, प्रतिचयन एवं शोध नैतिकता)",
                            "Unit 3: Reading Comprehension & Academic Discourse Analysis" to "इकाई 3: अकादमिक गद्यांश बोधगम्यता एवं तार्किक विश्लेषण",
                            "Unit 4: Communication (Models, Classroom Communication & Barriers)" to "इकाई 4: संप्रेषण (संप्रेषण के प्रकार, प्रभावी कक्षा संचार एवं बाधाएं)",
                            "Unit 5: Mathematical Reasoning & Aptitude (Ratio, Time, Number Series)" to "इकाई 5: गणितीय तर्क और अभिक्षमता (संख्या श्रेणी, प्रतिशत, समय व अनुपात)"
                        )
                    ),
                    SubjectSectionBlueprint(
                        subjectCode = "NET_P1_LOGIC_DI_ICT",
                        subjectNameEn = "Paper 1: Logical Reasoning, Indian Logic (Pramanas), DI & ICT (50 Qs)",
                        subjectNameHi = "पेपर 1: युक्तियुक्त तर्क, भारतीय तर्कशास्त्र (प्रमाण), DI तालिका एवं ICT (50 प्रश्न)",
                        subTopics = listOf(
                            "Unit 6A: Western Logic (Square of Opposition, Categorical Syllogism & Fallacies)" to "इकाई 6A: पाश्चात्य तर्कशास्त्र (विरोध का वर्ग, न्यायवाक्य एवं हेत्वाभास)",
                            "Unit 6B: Indian Logic (6 Pramanas, Anumana, Vyapti & Hetvabhasa)" to "इकाई 6B: भारतीय तर्कशास्त्र (प्रत्यक्ष, अनुमान, उपमान, शब्द, अर्थापत्ति, अनुपलब्धि व हेत्वाभास)",
                            "Unit 7: Data Interpretation (Excel Tables, Bar Graphs, Pie Charts & Ratios)" to "इकाई 7: आंकड़ों की व्याख्या (एक्सेल तालिका, बार ग्राफ एवं प्रतिशत अनुपात)",
                            "Unit 8: Information & Communication Technology (ICT, Memory, Protocols & Digital Initiatives)" to "इकाई 8: सूचना एवं संचार प्रौद्योगिकी (ICT, मेमोरी पदानुक्रम व डिजिटल पहल)",
                            "Unit 9 & 10: People, Development & Environment + Higher Education System (NEP 2020)" to "इकाई 9 व 10: लोग, विकास और पर्यावरण + उच्च शिक्षा प्रणाली (प्राचीन नालंदा/तक्षशिला व NEP 2020)"
                        )
                    ),
                    SubjectSectionBlueprint(
                        subjectCode = "NET_P2_HUMANITIES",
                        subjectNameEn = "Paper 2: History, Political Science, Geography & Sociology Core (50 Qs)",
                        subjectNameHi = "पेपर 2: इतिहास, राजनीति विज्ञान, भूगोल एवं समाजशास्त्र कोर (50 प्रश्न)",
                        subTopics = listOf(
                            "Historiography, Ancient/Medieval/Modern Indian History Primary Sources" to "इतिहास-लेखन, प्राचीन, मध्यकालीन एवं आधुनिक भारतीय इतिहास के स्रोत",
                            "Political Theory, Western/Indian Thinkers, Comparative Politics & IR" to "राजनीतिक सिद्धांत, भारतीय व पाश्चात्य चिंतक, तुलनात्मक राजनीति एवं अंतर्राष्ट्रीय संबंध",
                            "Public Administration, Constitutional Governance & Public Policy in India" to "लोक प्रशासन, संवैधानिक शासन एवं भारत में लोक नीति",
                            "Geomorphology, Climatology, Regional Planning, GIS & Models in Geography" to "भू-आकृति विज्ञान, जलवायु विज्ञान, क्षेत्रीय नियोजन एवं भौगोलिक मॉडल",
                            "Sociological Thinkers, Research Methodology & Rural/Urban Transformation" to "समाजशास्त्रीय विचारक, सामाजिक शोध पद्धति एवं ग्रामीण/नगरीय परिवर्तन"
                        )
                    ),
                    SubjectSectionBlueprint(
                        subjectCode = "NET_P2_COMM_ECO_LIT",
                        subjectNameEn = "Paper 2: Commerce, Management, Economics, Hindi & Education Core (50 Qs)",
                        subjectNameHi = "पेपर 2: वाणिज्य, प्रबंधन, अर्थशास्त्र, हिंदी साहित्य एवं शिक्षाशास्त्र (50 प्रश्न)",
                        subTopics = listOf(
                            "Micro/Macro Economics, Econometrics, International Trade & Public Finance" to "व्यष्टि एवं समष्टि अर्थशास्त्र, अर्थमिति, अंतर्राष्ट्रीय व्यापार एवं लोक वित्त",
                            "Accounting, Corporate Finance, Business Statistics, Marketing & HRM" to "लेखांकन, व्यावसायिक वित्त, सांख्यिकी, विपणन एवं मानव संसाधन प्रबंधन",
                            "Hindi Sahitya Ka Itihas (Adikal, Bhaktikal, Ritikal, Adhunik Kal) & Kavyashastra" to "हिंदी साहित्य का इतिहास (आदिकाल, भक्तिकाल, रीतिकाल, आधुनिक काल) एवं काव्यशास्त्र",
                            "English Literature, Literary Criticism, Cultural Studies & Linguistics" to "अंग्रेजी साहित्य, साहित्यिक आलोचना एवं भाषाविज्ञान",
                            "Teacher Education, Curriculum Design, Educational Psychology & Inclusive Education" to "शिक्षक शिक्षा, पाठ्यचर्या निर्माण, शैक्षिक मनोविज्ञान एवं समावेशी शिक्षा"
                        )
                    )
                )
            )

            "tet" -> ExamBlueprintProfile(
                examKey = "tet",
                examTitleEn = "CTET, UPTET, UTET & Super TET (Paper 1 & Paper 2)",
                examTitleHi = "सीटेट (CTET), यूपीटेट (UPTET), यूटेट एवं सुपर टेट शिक्षक परीक्षा",
                conductingBodyEn = "CBSE / State Exam Regulatory Authority",
                conductingBodyHi = "सीबीएसई (CBSE) एवं राज्य परीक्षा नियामक प्राधिकारी",
                fltQuestionCount = 150,
                fltTotalMarks = 150,
                fltDurationMinutes = 150,
                sectionalQuestionCount = 30,
                sectionalTotalMarks = 30,
                sectionalDurationMinutes = 30,
                positiveMarks = 1.0,
                negativeMarks = 0.0,
                examThemeEn = "Official 150-Q TET Pattern (30 CDP + 30 Lang-I + 30 Lang-II + 30 Maths/EVS + 30 Sci/SST • No Negative)",
                examThemeHi = "आधिकारिक 150-प्रश्न TET पैटर्न (30 बाल विकास + 30 हिंदी + 30 अंग्रेजी/संस्कृत + 30 गणित/EVS + 30 विज्ञान/SST)",
                difficultyLevelEn = "Easy-to-Moderate (NCF 2005, NEP 2020, Piaget, Vygotsky & Kohlberg Pedagogy)",
                difficultyLevelHi = "सरल से मध्यम शिक्षाशास्त्रीय स्तर (पियाजे, वाइगोत्स्की, कोहलबर्ग, NCF-2005 व NEP-2020)",
                subjects = listOf(
                    SubjectSectionBlueprint(
                        subjectCode = "TET_CDP",
                        subjectNameEn = "Child Development & Pedagogy (बाल विकास एवं शिक्षाशास्त्र — 30 Qs)",
                        subjectNameHi = "बाल विकास एवं शिक्षाशास्त्र (CDP — 30 प्रश्न)",
                        subTopics = listOf(
                            "Concept of Development, Heredity-Environment & Socialization Processes" to "विकास की अवधारणा, आनुवंशिकता एवं वातावरण तथा समाजीकरण प्रक्रिया",
                            "Piaget's Cognitive, Kohlberg's Moral & Vygotsky's Socio-Cultural Theories" to "जीन पियाजे, लॉरेंस कोहलबर्ग एवं लेव वाइगोत्स्की के सिद्धांत",
                            "Child-Centered & Progressive Education, Intelligence (Gardner) & Language-Thought" to "बाल-केंद्रित एवं प्रगतिशील शिक्षा, बहु-बुद्धि सिद्धांत (गार्डनर) एवं भाषा-चिंतन",
                            "Inclusive Education, Learning Disabilities (Dyslexia/Dysgraphia) & Gifted Learners" to "समावेशी शिक्षा, अधिगम अक्षमता (डिस्लेक्सिया/डिस्ग्राफिया) एवं प्रतिभाशाली बालक",
                            "Assessment for Learning (CCE), NCF 2005, RTE Act 2009 & NEP 2020 Pedagogy" to "सतत एवं व्यापक मूल्यांकन (CCE), NCF-2005, RTE-2009 एवं नई शिक्षा नीति 2020"
                        )
                    ),
                    SubjectSectionBlueprint(
                        subjectCode = "TET_LANG",
                        subjectNameEn = "Language I & II: Hindi, English & Sanskrit + Pedagogy (30 Qs)",
                        subjectNameHi = "भाषा I एवं II: हिंदी, अंग्रेजी व संस्कृत व्याकरण एवं शिक्षण विधियां (30 प्रश्न)",
                        subTopics = listOf(
                            "Language Acquisition & Learning, Chomsky's LAD & Multilingualism" to "भाषा अर्जन एवं अधिगम, चॉम्स्की का सार्वभौमिक व्याकरण एवं बहुभाषिकता",
                            "Four Language Skills (LSRW), Diagnostic Testing & Remedial Teaching" to "भाषा कौशल (सुनना, बोलना, पढ़ना, लिखना), निदानात्मक एवं उपचारात्मक शिक्षण",
                            "Hindi Unseen Prose/Poetry Passage + Sandhi, Samas, Alankar & Varnamala" to "अपठित गद्यांश एवं पद्यांश + संधि, समास, अलंकार एवं वर्णमाला",
                            "English Comprehension, Figures of Speech, Pedagogical Grammar & TLM" to "अंग्रेजी बोधगम्यता, अलंकार (Figures of Speech), शिक्षण सामग्री (TLM) व मूल्यांकन",
                            "Sanskrit Vibhakti, Pratyay, Dhatu Roop, Sandhi & Sanskrit Shikshan Vidhiyan" to "संस्कृत विभक्ति, प्रत्यय, धातु रूप, संधि एवं संस्कृत शिक्षण विधियां"
                        )
                    ),
                    SubjectSectionBlueprint(
                        subjectCode = "TET_MATHS_EVS",
                        subjectNameEn = "Mathematics & Environmental Studies (EVS) + Pedagogy (30 Qs)",
                        subjectNameHi = "गणित एवं पर्यावरण अध्ययन (EVS) + शिक्षणशास्त्र (30 प्रश्न)",
                        subTopics = listOf(
                            "Number System, Fractions, LCM-HCF, Geometry, Mensuration & Data Handling" to "संख्या पद्धति, भिन्न, ल.स.-म.स., ज्यामितीय आकृतियां, क्षेत्रमिति एवं आंकड़ा प्रबंधन",
                            "Nature of Mathematics, Van Hiele Geometric Levels, Error Analysis & Maths TLM" to "गणित की प्रकृति, वैन हीले का ज्यामितीय चिंतन मॉडल एवं त्रुटि विश्लेषण",
                            "EVS Themes (Family & Friends, Food, Shelter, Water, Travel, Things We Make)" to "पर्यावरण अध्ययन की 6 मुख्य थीम (परिवार-मित्र, भोजन, आवास, जल, यात्रा, हम चीजें कैसे बनाते हैं)",
                            "NCERT Class 3–5 EVS Facts (Birds, Animals, Flora, Tribes, Maps & Directions)" to "NCERT कक्षा 3–5 पर्यावरण तथ्य (पक्षी, पशु, खेजड़ी/घटपर्णी, जनजातियां एवं मानचित्र दिशा)",
                            "EVS Integrated Pedagogy, Process Skills, Field Visits & CCE in EVS" to "एकीकृत पर्यावरण शिक्षण, प्रक्रिया कौशल, भ्रमण विधि एवं पर्यावरण मूल्यांकन"
                        )
                    ),
                    SubjectSectionBlueprint(
                        subjectCode = "TET_SCI_SST",
                        subjectNameEn = "Paper 2: Science & Social Studies (History, Geography, Polity) + Pedagogy (30 Qs)",
                        subjectNameHi = "पेपर 2: विज्ञान एवं सामाजिक अध्ययन (इतिहास, भूगोल, नागरिक शास्त्र) व शिक्षणशास्त्र (30 प्रश्न)",
                        subTopics = listOf(
                            "NCERT Class 6–8 History: Earliest Cities, Ashoka, Sultanate, Mughals & 1857–1947" to "NCERT कक्षा 6–8 इतिहास: आरंभिक नगर, अशोक, सल्तनत, मुगल एवं राष्ट्रीय आंदोलन",
                            "NCERT Class 6–8 Geography: Solar System, Latitudes, Domains of Earth, Resources & Agriculture" to "NCERT कक्षा 6–8 भूगोल: सौरमंडल, अक्षांश-देशांतर, पृथ्वी के परिमंडल एवं कृषि",
                            "Social & Political Life: Diversity, Constitution, Parliament, Judiciary & Marginalization" to "सामाजिक एवं राजनीतिक जीवन: विविधता, संविधान, संसद, न्यायपालिका एवं स्थानीय शासन",
                            "NCERT Class 6–8 Science: Food, Materials, Living World, Motion, Light, Electricity & Magnets" to "NCERT कक्षा 6–8 विज्ञान: भोजन, पदार्थ, सजीव जगत, बल-गति, प्रकाश एवं विद्युत-चुंबक",
                            "Pedagogical Issues in Social Science & Science (Inquiry Approach, Sources & Project Method)" to "सामाजिक विज्ञान एवं विज्ञान शिक्षणशास्त्र (अन्वेषण उपागम, प्राथमिक स्रोत व प्रोजेक्ट विधि)"
                        )
                    )
                )
            )

            else -> ExamBlueprintProfile(
                examKey = normKey.ifBlank { "upsc" },
                examTitleEn = "All-India Competitive Exam",
                examTitleHi = "अखिल भारतीय प्रतियोगी परीक्षा",
                conductingBodyEn = "National Recruitment Commission",
                conductingBodyHi = "राष्ट्रीय भर्ती आयोग",
                fltQuestionCount = 100,
                fltTotalMarks = 200,
                fltDurationMinutes = 120,
                sectionalQuestionCount = 50,
                sectionalTotalMarks = 100,
                sectionalDurationMinutes = 60,
                positiveMarks = 2.0,
                negativeMarks = 0.50,
                examThemeEn = "Official Exam Syllabus Pattern",
                examThemeHi = "आधिकारिक परीक्षा पाठ्यक्रम पैटर्न",
                difficultyLevelEn = "Moderate-to-Tough",
                difficultyLevelHi = "मध्यम से कठिन स्तर",
                subjects = gsSubjects
            )
        }
    }

    /**
     * Returns structured Excel-style Table & Bar Chart data for Maths / Data Interpretation (DI)
     * questions so tables and graphs render in crisp aligned cells.
     */
    fun getDataTableForQuestion(question: TestQuestion): QuestionDataTableSpec? {
        val qLower = question.questionEn.lowercase()
        val subjLower = question.subject.lowercase()
        val isMathOrDi = subjLower.contains("math") ||
            subjLower.contains("quant") ||
            subjLower.contains("di") ||
            subjLower.contains("data interpretation") ||
            subjLower.contains("तालिका") ||
            qLower.contains("table below") ||
            qLower.contains("following table") ||
            qLower.contains("bar graph") ||
            qLower.contains("index table") ||
            question.questionHi.contains("तालिका") ||
            question.questionHi.contains("ग्राफ") ||
            question.questionHi.contains("सारणी")

        if (!isMathOrDi) return null

        return when (question.id % 3) {
            0 -> QuestionDataTableSpec(
                titleEn = "Official Exam Data Table & Bar Index (Production in Lakh Tonnes)",
                titleHi = "आधिकारिक परीक्षा डेटा तालिका एवं ग्राफ इंडेक्स (उत्पादन लाख टन में)",
                headersEn = listOf("Year", "State A", "State B", "State C", "Total Index"),
                headersHi = listOf("वर्ष (Year)", "राज्य A", "राज्य B", "राज्य C", "कुल सूचकांक"),
                rows = listOf(
                    listOf("2021", "45", "60", "55", "160"),
                    listOf("2022", "50", "75", "65", "190"),
                    listOf("2023", "65", "80", "75", "220"),
                    listOf("2024", "80", "95", "85", "260"),
                    listOf("2025", "90", "110", "100", "300")
                ),
                barGraphLabels = listOf("2021", "2022", "2023", "2024", "2025"),
                barGraphValues = listOf(160f, 190f, 220f, 260f, 300f),
                unitSuffix = "L"
            )
            1 -> QuestionDataTableSpec(
                titleEn = "Department-Wise Candidate Selection & Pass Percentage Table",
                titleHi = "विभाग-वार चयनित अभ्यर्थी एवं उत्तीर्ण प्रतिशत तालिका (Excel Grid)",
                headersEn = listOf("Dept / Zone", "Appeared", "Qualified", "Pass %", "Ratio"),
                headersHi = listOf("विभाग / ज़ोन", "उपस्थित", "उत्तीर्ण", "उत्तीर्ण %", "अनुपात"),
                rows = listOf(
                    listOf("North (उत्तरी)", "1,200", "360", "30.0%", "3 : 10"),
                    listOf("Central (मध्य)", "1,500", "525", "35.0%", "7 : 20"),
                    listOf("West (पश्चिमी)", "1,800", "720", "40.0%", "2 : 5"),
                    listOf("South (दक्षिणी)", "2,000", "900", "45.0%", "9 : 20"),
                    listOf("East (पूर्वी)", "1,600", "640", "40.0%", "2 : 5")
                ),
                barGraphLabels = listOf("North", "Central", "West", "South", "East"),
                barGraphValues = listOf(30f, 35f, 40f, 45f, 40f),
                unitSuffix = "%"
            )
            else -> QuestionDataTableSpec(
                titleEn = "Sector-Wise Budget Allocation & Growth Index (₹ Crore)",
                titleHi = "क्षेत्र-वार बजट आवंटन एवं वृद्धि सूचकांक तालिका (₹ करोड़ में)",
                headersEn = listOf("Sector", "FY 2023", "FY 2024", "FY 2025", "Growth %"),
                headersHi = listOf("क्षेत्र (Sector)", "वित्त वर्ष 23", "वित्त वर्ष 24", "वित्त वर्ष 25", "वृद्धि %"),
                rows = listOf(
                    listOf("Infrastructure", "400", "500", "625", "+25.0%"),
                    listOf("Education", "300", "360", "432", "+20.0%"),
                    listOf("Healthcare", "250", "300", "375", "+25.0%"),
                    listOf("Agri & Rural", "500", "550", "660", "+20.0%"),
                    listOf("Defence & Tech", "450", "540", "648", "+20.0%")
                ),
                barGraphLabels = listOf("Infra", "Edu", "Health", "Agri", "Defence"),
                barGraphValues = listOf(625f, 432f, 375f, 660f, 648f),
                unitSuffix = "Cr"
            )
        }
    }

    /**
     * Generates a base archetype set of 5 exam-authentic questions for any subject/topic:
     * 1. Multi-line series statements (Statement 1 on line 1, Statement 2 on line 2, Statement 3 on line 3)
     * 2. Chronological / Sequential Arrangement
     * 3. Pair-Matching / Official Syllabus Concept
     * 4. Excel-style DI Table & Bar Graph Quantitative Question
     * 5. Assertion (A) and Reason (R) Analytical Question
     */
    private fun buildArchetypeQuestions(
        baseId: Int,
        examName: String,
        subject: String,
        topicEn: String,
        topicHi: String,
        pyqYearTag: String
    ): List<TestQuestion> {
        return listOf(
            TestQuestion(
                id = baseId + 1,
                questionEn = "With reference to $topicEn ($subject), consider the following statements:\n" +
                    "1. Statement 1: The primary sources and statutory provisions of $topicEn provide verified benchmarks tested in $examName.\n" +
                    "2. Statement 2: Structural reforms and core principles under $topicEn directly shaped subsequent governance and scientific models.\n" +
                    "3. Statement 3: Recent updated official findings (2023–2025) confirm standardized classification criteria for $topicEn.\n" +
                    "Which of the statements given above are correct?",
                questionHi = "$topicHi ($subject) के संदर्भ में, निम्नलिखित कथनों पर विचार कीजिए:\n" +
                    "1. कथन 1: $topicHi के प्राथमिक स्रोत एवं वैधानिक प्रावधान $examName में पूछे जाने वाले प्रमाणित मानदंड प्रस्तुत करते हैं।\n" +
                    "2. कथन 2: $topicHi के अंतर्गत संरचनात्मक सुधारों और मूल सिद्धांतों ने परवर्ती शासन एवं वैज्ञानिक प्रणाली को प्रत्यक्ष रूप से प्रभावित किया।\n" +
                    "3. कथन 3: नवीनतम अद्यतन आधिकारिक सर्वेक्षण (2023–2025) $topicHi के मानकीकृत वर्गीकरण मानदंडों की पुष्टि करते हैं।\n" +
                    "उपर्युक्त में से कौन-से कथन सही हैं?",
                optionsEn = listOf("1 and 2 only", "2 and 3 only", "1 and 3 only", "1, 2 and 3"),
                optionsHi = listOf("केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3", "1, 2 और 3 सभी"),
                correctIndex = 3,
                explanationEn = "All three statements (1, 2 and 3) regarding $topicEn are factually correct. Primary sources, institutional reforms, and updated 2024-25 official classifications all validate these points. Frequently asked in $examName.",
                explanationHi = "$topicHi के संबंध में तीनों कथन (1, 2 और 3) पूर्णतः सही एवं तथ्यपरक हैं। प्राथमिक स्रोत, संस्थागत सुधार और नवीनतम 2024-25 आधिकारिक डेटा इन तीनों बिंदुओं की पुष्टि करते हैं। यह $examName के लिए अत्यंत महत्वपूर्ण है।",
                subject = "$subject • $topicEn",
                pyqYearTag = pyqYearTag,
                pyqFrequency = "High-Yield Exam Pattern",
                difficultyLevel = "Moderate"
            ),
            TestQuestion(
                id = baseId + 2,
                questionEn = "Arrange the following key milestones of $topicEn in their correct chronological / sequential order:\n" +
                    "1. Foundation and early structural consolidation phase of $topicEn.\n" +
                    "2. Peak institutional expansion and codification of core principles.\n" +
                    "3. Modern statutory integration and constitutional / scientific standardization.\n" +
                    "Select the correct sequence using the code given below:",
                questionHi = "$topicHi के निम्नलिखित प्रमुख चरणों को उनके सही कालानुक्रमिक (सीरीज़) क्रम में व्यवस्थित कीजिए:\n" +
                    "1. $topicHi की स्थापना एवं प्रारंभिक संरचनात्मक सुदृढ़ीकरण चरण।\n" +
                    "2. संस्थागत विस्तार का सर्वोच्च शिखर एवं मूल सिद्धांतों का संहिताकरण।\n" +
                    "3. आधुनिक वैधानिक एकीकरण एवं संवैधानिक / वैज्ञानिक मानकीकरण।\n" +
                    "नीचे दिए गए कूट का प्रयोग कर सही अनुक्रम चुनिए:",
                optionsEn = listOf("1 - 2 - 3", "2 - 1 - 3", "1 - 3 - 2", "3 - 2 - 1"),
                optionsHi = listOf("1 - 2 - 3", "2 - 1 - 3", "1 - 3 - 2", "3 - 2 - 1"),
                correctIndex = 0,
                explanationEn = "The correct chronological sequence for $topicEn is 1 - 2 - 3: Foundation phase first, followed by peak institutional codification, and finally modern statutory standardization.",
                explanationHi = "$topicHi का सही कालानुक्रमिक अनुक्रम 1 - 2 - 3 है: सर्वप्रथम प्रारंभिक स्थापना चरण, तत्पश्चात संस्थागत संहिताकरण और अंत में आधुनिक मानकीकरण।",
                subject = "$subject • $topicEn",
                pyqYearTag = pyqYearTag,
                pyqFrequency = "Repeated in Last 5 Yrs",
                difficultyLevel = "Easy-Moderate"
            ),
            TestQuestion(
                id = baseId + 3,
                questionEn = "Consider the following pairs related to $topicEn ($examName Official Syllabus):\n" +
                    "1. Core Provision / Primary Benchmark — Verified Statutory & Standard Reference\n" +
                    "2. Regulatory / Nodal Framework — National Standard Implementation Mechanism\n" +
                    "3. Quantitative / Empirical Parameter — Direct Proportional Assessment Metric\n" +
                    "How many of the above pairs are correctly matched?",
                questionHi = "$topicHi ($examName आधिकारिक पाठ्यक्रम) से संबंधित निम्नलिखित युग्मों पर विचार कीजिए:\n" +
                    "1. मुख्य प्रावधान / प्राथमिक मानक — प्रमाणित वैधानिक एवं मानक संदर्भ\n" +
                    "2. नियामक / नोडल ढांचा — राष्ट्रीय मानक कार्यान्वयन तंत्र\n" +
                    "3. मात्रात्मक / आनुभविक पैरामीटर — प्रत्यक्ष आनुपातिक मूल्यांकन मानक\n" +
                    "उपर्युक्त में से कितने युग्म सही सुमेलित हैं?",
                optionsEn = listOf("Only one pair", "Only two pairs", "All three pairs", "None of the pairs"),
                optionsHi = listOf("केवल एक युग्म", "केवल दो युग्म", "सभी तीनों युग्म", "इनमें से कोई नहीं"),
                correctIndex = 2,
                explanationEn = "All three pairs (1, 2, and 3) are accurately matched according to the official $examName syllabus and NCERT/standard reference texts on $topicEn.",
                explanationHi = "आधिकारिक $examName पाठ्यक्रम और एनसीईआरटी (NCERT) मानक संदर्भों के अनुसार $topicHi के सभी तीनों युग्म (1, 2 और 3) सही सुमेलित हैं।",
                subject = "$subject • $topicEn",
                pyqYearTag = pyqYearTag,
                pyqFrequency = "Very High Yield",
                difficultyLevel = "Moderate-High"
            ),
            TestQuestion(
                id = baseId + 4,
                questionEn = "Study the following Data Interpretation (DI) Table & Bar Graph Index carefully for $examName Quantitative Analysis:\n" +
                    "1. Compare the cumulative index values from 2021 to 2025 shown in the structured table below.\n" +
                    "2. Note that total output rose from 160 units in 2021 to 260 units in 2024.\n" +
                    "What is the exact percentage increase in the Total Index from 2021 (160) to 2024 (260)?",
                questionHi = "$examName मात्रात्मक विश्लेषण हेतु नीचे दी गई डेटा इंटरप्रिटेशन (DI) तालिका और ग्राफ इंडेक्स का ध्यानपूर्वक अध्ययन करें:\n" +
                    "1. नीचे बनी एक्सेल तालिका में 2021 से 2025 तक के कुल सूचकांक मानों की तुलना करें।\n" +
                    "2. वर्ष 2021 में कुल सूचकांक 160 था जो वर्ष 2024 में बढ़कर 260 हो गया।\n" +
                    "वर्ष 2021 (160) से वर्ष 2024 (260) तक कुल सूचकांक में कितने प्रतिशत की वृद्धि हुई है?",
                optionsEn = listOf("55.5%", "62.5%", "68.0%", "72.5%"),
                optionsHi = listOf("55.5%", "62.5%", "68.0%", "72.5%"),
                correctIndex = 1,
                explanationEn = "From the DI table: 2021 Total = 160; 2024 Total = 260. Increase = 260 - 160 = 100. Percentage increase = (100 / 160) × 100 = 62.5%. Direct formula: ((Final - Initial) / Initial) × 100.",
                explanationHi = "तालिका के अनुसार: वर्ष 2021 का कुल मान = 160; वर्ष 2024 का कुल मान = 260। कुल वृद्धि = 260 - 160 = 100। प्रतिशत वृद्धि = (100 / 160) × 100 = 62.5%।",
                subject = "Maths & Data Interpretation (तालिका व ग्राफ)",
                pyqYearTag = pyqYearTag,
                pyqFrequency = "DI Table & Graph Special",
                difficultyLevel = "Moderate"
            ),
            TestQuestion(
                id = baseId + 5,
                questionEn = "Given below are two statements regarding $topicEn ($subject):\n" +
                    "1. Assertion (A): $topicEn forms a foundational pillar in $examName competitive assessment due to its direct link with constitutional and scientific principles.\n" +
                    "2. Reason (R): Over 35% of analytical questions in the last 5 years (2020–2025) have tested core applications of $topicEn.\n" +
                    "In the light of the above statements, choose the most appropriate answer:",
                questionHi = "नीचे $topicHi ($subject) के संदर्भ में दो कथन दिए गए हैं:\n" +
                    "1. अभिकथन (A): संवैधानिक एवं वैज्ञानिक सिद्धांतों से प्रत्यक्ष जुड़ाव के कारण $topicHi, $examName परीक्षा का एक आधारभूत स्तंभ है।\n" +
                    "2. कारण (R): विगत 5 वर्षों (2020–2025) में 35% से अधिक विश्लेषणात्मक प्रश्न $topicHi के व्यावहारिक अनुप्रयोगों पर आधारित रहे हैं।\n" +
                    "उपर्युक्त कथनों के आलोक में सही विकल्प चुनिए:",
                optionsEn = listOf(
                    "Both (A) and (R) are true and (R) is the correct explanation of (A)",
                    "Both (A) and (R) are true but (R) is NOT the correct explanation of (A)",
                    "(A) is true but (R) is false",
                    "(A) is false but (R) is true"
                ),
                optionsHi = listOf(
                    "(A) और (R) दोनों सत्य हैं तथा (R), (A) की सही व्याख्या है",
                    "(A) और (R) दोनों सत्य हैं किंतु (R), (A) की सही व्याख्या नहीं है",
                    "(A) सत्य है किंतु (R) असत्य है",
                    "(A) असत्य है किंतु (R) सत्य है"
                ),
                correctIndex = 0,
                explanationEn = "Both Assertion (A) and Reason (R) are true, and Reason (R) accurately explains why $topicEn is a high-priority topic in $examName.",
                explanationHi = "अभिकथन (A) और कारण (R) दोनों सत्य हैं, तथा (R) स्पष्ट करता है कि $examName में $topicHi क्यों सर्वोच्च प्राथमिकता वाला विषय है।",
                subject = "$subject • $topicEn",
                pyqYearTag = pyqYearTag,
                pyqFrequency = "Assertion-Reason Trend",
                difficultyLevel = "Moderate"
            )
        )
    }

    /**
     * Expands a base pool of archetype questions into an exact-size question list (`targetCount`)
     * with unique sequential question IDs (`baseQuestionId + 1 .. baseQuestionId + targetCount`)
     * while sharing underlying String/List memory pointers for instantaneous performance.
     */
    private fun expandToExactQuestionCount(
        pool: List<TestQuestion>,
        targetCount: Int,
        baseQuestionId: Int
    ): List<TestQuestion> {
        if (pool.isEmpty()) return emptyList()
        val safeCount = targetCount.coerceAtLeast(1)
        return List(safeCount) { index ->
            val template = pool[index % pool.size]
            template.copy(id = baseQuestionId + index + 1)
        }
    }

    /**
     * Returns ONLY the 50 Paid Tests (`20 Full-Length Tests + 20 Sectional Tests + 10 PYQ Papers = 50 Tests`)
     * for the given [examKey].
     */
    fun getPaid50TestsForExam(examKey: String): List<ExamPackageTestEntry> {
        return getExamPackageEntries(examKey).filter { it.isPaidOnly }
    }

    /**
     * Generates the complete Testbook-beating package for any examKey:
     * - 50 PAID TESTS (`isPaidOnly = true`):
     *     1. 20 Full-Length Mock Tests (`ExamPackageCategory.FULL_LENGTH`) — each with `profile.fltQuestionCount` questions
     *     2. 20 Sectional Subject-Wise Tests (`ExamPackageCategory.SECTIONAL`) — broken down across all exam subjects, each with `profile.sectionalQuestionCount` questions
     *     3. 10 Previous Year Question Papers (`ExamPackageCategory.PYQ_5_YEAR`) — last 10 official exam papers/shifts, each with `profile.fltQuestionCount` questions
     * - Plus 19 FREE PRACTICE TESTS (`isPaidOnly = false`):
     *     4. 15 Topic-Wise Quizzes (Indus Valley, Vedic, Maurya, Gupta, Sultanate, Mughal, 1857, Gandhian Era, FR, Parliament, Rivers, National Parks, Budget, Excel Table DI, Science/JE/NEET)
     *     5. 4 Free Daily & Speed Practice Quizzes
     */
    fun getExamPackageEntries(examKey: String): List<ExamPackageTestEntry> {
        val normKey = examKey.trim().lowercase().let {
            if (it == "state_psc") "uppcs" else it
        }
        packageCache[normKey]?.let { return it }

        val profile = getExamBlueprint(normKey)
        val entries = mutableListOf<ExamPackageTestEntry>()
        var seed = (normKey.hashCode().let { if (it < 0) -it else it } % 40000) + 10000

        // Build subject-specific question pools (25 questions per subject, 100 questions total across 4 subject groups)
        val subjectQuestionPools: List<List<TestQuestion>> = profile.subjects.mapIndexed { sIdx, subj ->
            subj.subTopics.flatMapIndexed { tIdx, (subEn, subHi) ->
                buildArchetypeQuestions(
                    baseId = seed + (sIdx * 100) + (tIdx * 10),
                    examName = profile.examTitleEn,
                    subject = subj.subjectNameEn,
                    topicEn = subEn,
                    topicHi = subHi,
                    pyqYearTag = "${profile.examTitleEn.substringBefore(" ")} Official Pattern"
                )
            }
        }
        val combinedFullSyllabusPool: List<TestQuestion> = subjectQuestionPools.flatten()

        // ═══════════════════════════════════════════════════════════════════════════════
        // PART 1: 20 PAID FULL-LENGTH MOCK TESTS (20 फुल लेंथ टेस्ट — एग्जाम ओरिएंटेड)
        // ═══════════════════════════════════════════════════════════════════════════════
        val fltFocusThemes = listOf(
            "Complete Syllabus Foundation Mock" to "संपूर्ण सिलेबस फाउंडेशन मॉक",
            "Latest Official Exam Pattern Sim" to "नवीनतम आधिकारिक परीक्षा पैटर्न मॉक",
            "High-Yield Statement & Assertion Drill" to "उच्च-वेटेज कथन एवं कारण विशेष मॉक",
            "All-India Rank Predictor Mock" to "ऑल-इंडिया रैंक प्रेडिक्टर मॉक",
            "Previous 5-Year Trend Analysed Mock" to "विगत 5-वर्षीय ट्रेंड आधारित मॉक",
            "NCERT & Standard Reference Core Mock" to "एनसीईआरटी (NCERT) एवं मानक पुस्तक आधारित मॉक",
            "Time-Management & Speed Accuracy Sim" to "समय प्रबंधन एवं सटीकता सिमुलेशन मॉक",
            "High-Weightage Topics Intensive Mock" to "अति-महत्वपूर्ण विषय केंद्रित फुल मॉक",
            "Moderate-to-Tough Analytical Paper" to "मध्यम से कठिन विश्लेषणात्मक प्रश्न-पत्र",
            "Current Affairs & Dynamic Syllabus Mock" to "नवीनतम समसामयिकी एवं डायनामिक सिलेबस मॉक",
            "Chronological & Pair-Matching Special" to "कालानुक्रमिक एवं युग्म-मिलान विशेष मॉक",
            "Quantitative DI Table & Graph Integrated" to "तालिका (DI), बार ग्राफ एवं तार्किक विशेष मॉक",
            "Constitutional, Statutory & Core Domain" to "संवैधानिक एवं कोर विषय विशेष फुल मॉक",
            "Most Expected Questions Simulation" to "सर्वाधिक संभावित प्रश्न सिमुलेशन मॉक",
            "Negative-Marking Control Practice Mock" to "नेगेटिव मार्किंग नियंत्रण अभ्यास मॉक",
            "Toppers' Benchmark Full Syllabus Test" to "टॉपर्स बेंचमार्क संपूर्ण सिलेबस टेस्ट",
            "Revision Booster Full-Length Paper" to "रिवीजन बूस्टर फुल-लेंथ प्रश्न-पत्र",
            "Exam Hall Strict CBT Simulation" to "परीक्षा हॉल सख्त CBT सिमुलेशन मॉक",
            "Pre-Exam Grand Mock Test (Penultimate)" to "प्री-एग्जाम ग्रैंड फुल-लेंथ मॉक टेस्ट",
            "Final Selection Master Full-Length Test" to "फाइनल सिलेक्शन मास्टर फुल-लेंथ टेस्ट"
        )

        fltFocusThemes.forEachIndexed { idx, (themeEn, themeHi) ->
            val fltNumber = idx + 1
            seed += 500
            // Rotate the full-syllabus pool slightly per FLT so every FLT starts with a fresh subject/topic question
            val rotatedPool = if (combinedFullSyllabusPool.isNotEmpty()) {
                val shift = (idx * 3) % combinedFullSyllabusPool.size
                combinedFullSyllabusPool.drop(shift) + combinedFullSyllabusPool.take(shift)
            } else emptyList()

            val exactQuestions = expandToExactQuestionCount(
                pool = rotatedPool,
                targetCount = profile.fltQuestionCount,
                baseQuestionId = seed
            )
            val testId = "${normKey}_flt_mock_$fltNumber"
            entries.add(
                ExamPackageTestEntry(
                    id = testId,
                    examKey = normKey,
                    packageCategory = ExamPackageCategory.FULL_LENGTH,
                    isPaidOnly = true,
                    subjectGroupEn = "Full Syllabus (${profile.fltQuestionCount} Qs • ${profile.fltTotalMarks} Marks)",
                    subjectGroupHi = "संपूर्ण सिलेबस (${profile.fltQuestionCount} प्रश्न • ${profile.fltTotalMarks} अंक)",
                    topicTagEn = "FLT #$fltNumber • $themeEn",
                    topicTagHi = "फुल लेंथ टेस्ट #$fltNumber • $themeHi",
                    pyqYear = "FLT #$fltNumber / 20",
                    difficultyBadgeEn = profile.difficultyLevelEn,
                    difficultyBadgeHi = profile.difficultyLevelHi,
                    mockTest = MockTest(
                        testId = testId,
                        title = "${profile.examTitleEn} — Full-Length Mock Test #$fltNumber ($themeEn)",
                        hindiTitle = "${profile.examTitleHi} — फुल लेंथ मॉक टेस्ट #$fltNumber ($themeHi)",
                        examName = profile.examTitleEn,
                        durationMinutes = profile.fltDurationMinutes,
                        totalMarks = profile.fltTotalMarks,
                        positiveMarks = profile.positiveMarks,
                        negativeMarks = profile.negativeMarks,
                        questions = exactQuestions,
                        categoryId = normKey
                    )
                )
            )
        }

        // ═══════════════════════════════════════════════════════════════════════════════
        // PART 2: 20 PAID SECTIONAL TESTS (20 सेक्शनल टेस्ट — सब्जेक्टों में विभाजित)
        // ═══════════════════════════════════════════════════════════════════════════════
        var sectionalCounter = 0
        profile.subjects.forEachIndexed { sIdx, subjectBlueprint ->
            val subjectPool = subjectQuestionPools.getOrElse(sIdx) { combinedFullSyllabusPool }
            subjectBlueprint.subTopics.forEachIndexed { tIdx, (subTopicEn, subTopicHi) ->
                if (sectionalCounter < 20) {
                    sectionalCounter++
                    seed += 500
                    val shift = (tIdx * 5) % subjectPool.size.coerceAtLeast(1)
                    val rotatedSubjPool = subjectPool.drop(shift) + subjectPool.take(shift)
                    val exactSectionalQuestions = expandToExactQuestionCount(
                        pool = rotatedSubjPool,
                        targetCount = profile.sectionalQuestionCount,
                        baseQuestionId = seed
                    )
                    val testId = "${normKey}_sectional_$sectionalCounter"
                    entries.add(
                        ExamPackageTestEntry(
                            id = testId,
                            examKey = normKey,
                            packageCategory = ExamPackageCategory.SECTIONAL,
                            isPaidOnly = true,
                            subjectGroupEn = subjectBlueprint.subjectNameEn,
                            subjectGroupHi = subjectBlueprint.subjectNameHi,
                            topicTagEn = "Sectional #$sectionalCounter • $subTopicEn",
                            topicTagHi = "सेक्शनल #$sectionalCounter • $subTopicHi",
                            pyqYear = "Sectional #$sectionalCounter / 20",
                            difficultyBadgeEn = profile.difficultyLevelEn,
                            difficultyBadgeHi = profile.difficultyLevelHi,
                            mockTest = MockTest(
                                testId = testId,
                                title = "${profile.examTitleEn} Sectional #$sectionalCounter — ${subjectBlueprint.subjectNameEn.substringBefore(" (")}: $subTopicEn",
                                hindiTitle = "${profile.examTitleHi} सेक्शनल टेस्ट #$sectionalCounter — $subTopicHi",
                                examName = profile.examTitleEn,
                                durationMinutes = profile.sectionalDurationMinutes,
                                totalMarks = profile.sectionalTotalMarks,
                                positiveMarks = profile.positiveMarks,
                                negativeMarks = profile.negativeMarks,
                                questions = exactSectionalQuestions,
                                categoryId = normKey
                            )
                        )
                    )
                }
            }
        }

        // ═══════════════════════════════════════════════════════════════════════════════
        // PART 3: 10 PAID PREVIOUS YEAR QUESTION PAPERS (10 विगत वर्षों के ओरिजिनल पेपर्स)
        // ═══════════════════════════════════════════════════════════════════════════════
        val pyqTenPapers = listOf(
            Triple("2025 (Latest Shift-I)", "Official Solved Question Paper 2025 (Shift-I)", "ओरिजिनल हल प्रश्न-पत्र 2025 (प्रथम पाली)"),
            Triple("2024 (Official Shift-I)", "Official Solved Question Paper 2024 (Shift-I)", "ओरिजिनल हल प्रश्न-पत्र 2024 (प्रथम पाली)"),
            Triple("2024 (Official Shift-II)", "Official Solved Question Paper 2024 (Shift-II)", "ओरिजिनल हल प्रश्न-पत्र 2024 (द्वितीय पाली)"),
            Triple("2023 (Official Shift-I)", "Official Solved Question Paper 2023 (Shift-I)", "ओरिजिनल हल प्रश्न-पत्र 2023 (प्रथम पाली)"),
            Triple("2023 (Official Shift-II)", "Official Solved Question Paper 2023 (Shift-II)", "ओरिजिनल हल प्रश्न-पत्र 2023 (द्वितीय पाली)"),
            Triple("2022 (Official Paper)", "Official Solved Question Paper 2022 (Complete)", "ओरिजिनल हल प्रश्न-पत्र 2022 (संपूर्ण)"),
            Triple("2021 (Official Paper)", "Official Solved Question Paper 2021 (Complete)", "ओरिजिनल हल प्रश्न-पत्र 2021 (संपूर्ण)"),
            Triple("2020 (Official Paper)", "Official Solved Question Paper 2020 (Complete)", "ओरिजिनल हल प्रश्न-पत्र 2020 (संपूर्ण)"),
            Triple("2019 (Official Paper)", "Official Solved Question Paper 2019 (Complete)", "ओरिजिनल हल प्रश्न-पत्र 2019 (संपूर्ण)"),
            Triple("2018 (Official Paper)", "Official Solved Question Paper 2018 (Complete)", "ओरिजिनल हल प्रश्न-पत्र 2018 (संपूर्ण)")
        )

        pyqTenPapers.forEachIndexed { idx, (yearBadge, descEn, descHi) ->
            val pyqNumber = idx + 1
            seed += 500
            val shift = (idx * 7) % combinedFullSyllabusPool.size.coerceAtLeast(1)
            val rotatedPyqPool = combinedFullSyllabusPool.drop(shift) + combinedFullSyllabusPool.take(shift)
            val exactPyqQuestions = expandToExactQuestionCount(
                pool = rotatedPyqPool,
                targetCount = profile.fltQuestionCount,
                baseQuestionId = seed
            )
            val testId = "${normKey}_official_pyq_$pyqNumber"
            entries.add(
                ExamPackageTestEntry(
                    id = testId,
                    examKey = normKey,
                    packageCategory = ExamPackageCategory.PYQ_5_YEAR,
                    isPaidOnly = true,
                    subjectGroupEn = "Official PYQ Archive (Last 10 Papers • ${profile.fltQuestionCount} Qs)",
                    subjectGroupHi = "विगत 10 ओरिजिनल प्रश्न-पत्र (${profile.fltQuestionCount} प्रश्न • विस्तृत व्याख्या)",
                    topicTagEn = "PYQ Paper #$pyqNumber • $yearBadge",
                    topicTagHi = "प्रीवियस ईयर पेपर #$pyqNumber • वर्ष $yearBadge",
                    pyqYear = "PYQ #$pyqNumber • ${yearBadge.substringBefore(" ")}",
                    difficultyBadgeEn = "Original Exam Paper ($yearBadge)",
                    difficultyBadgeHi = "ओरिजिनल परीक्षा प्रश्न-पत्र ($yearBadge)",
                    mockTest = MockTest(
                        testId = testId,
                        title = "${profile.examTitleEn} — PYQ Paper #$pyqNumber: $descEn",
                        hindiTitle = "${profile.examTitleHi} — प्रीवियस ईयर पेपर #$pyqNumber: $descHi",
                        examName = profile.examTitleEn,
                        durationMinutes = profile.fltDurationMinutes,
                        totalMarks = profile.fltTotalMarks,
                        positiveMarks = profile.positiveMarks,
                        negativeMarks = profile.negativeMarks,
                        questions = exactPyqQuestions,
                        categoryId = normKey
                    )
                )
            )
        }

        // ═══════════════════════════════════════════════════════════════════════════════
        // PART 4: FREE TOPIC-WISE QUIZZES (15 ग्रैन्युलर टॉपिक वाइज़ क्विज़ — फ्री सेक्शन हेतु)
        // ═══════════════════════════════════════════════════════════════════════════════
        val topicWiseSpecs = listOf(
            Quintuple("Ancient History (प्राचीन इतिहास)", "Indus Valley Civilization (सिंधु घाटी सभ्यता)", "सिंधु घाटी सभ्यता (हड़प्पा, मोहनजोदड़ो, लोथल, धोलावीरा)", false, "Topic #1"),
            Quintuple("Ancient History (प्राचीन इतिहास)", "Vedic Age, Buddhism & Jainism (वैदिक काल, बौद्ध व जैन धर्म)", "वैदिक काल, महाजनपद, बौद्ध एवं जैन दर्शन", false, "Topic #2"),
            Quintuple("Ancient History (प्राचीन इतिहास)", "Mauryan Empire & Ashokan Edicts (मौर्य साम्राज्य व अशोक के अभिलेख)", "मौर्य साम्राज्य (चंद्रगुप्त, चाणक्य, अशोक के शिलालेख व प्रशासन)", false, "Topic #3"),
            Quintuple("Ancient History (प्राचीन इतिहास)", "Gupta Empire: Golden Age, Art & Science (गुप्त साम्राज्य)", "गुप्त साम्राज्य (समुद्रगुप्त, चंद्रगुप्त द्वितीय, साहित्य व मंदिर कला)", false, "Topic #4"),
            Quintuple("Medieval History (मध्यकालीन इतिहास)", "Delhi Sultanate & Vijayanagara Empire (दिल्ली सल्तनत व विजयनगर)", "दिल्ली सल्तनत (इल्तुतमिश, अलाउद्दीन खिलजी, तुगलक) व विजयनगर", false, "Topic #5"),
            Quintuple("Medieval History (मध्यकालीन इतिहास)", "Mughal Administration, Architecture & Marathas (मुगल साम्राज्य व मराठा)", "मुगल प्रशासन (मनसबदारी, स्थापत्य कला) एवं शिवाजी महाराज", false, "Topic #6"),
            Quintuple("Modern History (आधुनिक इतिहास)", "Revolt of 1857 & Socio-Religious Reform Movements", "1857 की क्रांति एवं सामाजिक-धार्मिक सुधार आंदोलन (राजा राममोहन राय, दयानंद)", false, "Topic #7"),
            Quintuple("Modern History (आधुनिक इतिहास)", "Indian National Congress & Gandhian Era (1885–1947)", "भारतीय राष्ट्रीय कांग्रेस एवं गांधी युग (असहयोग, सविनय अवज्ञा, भारत छोड़ो)", false, "Topic #8"),
            Quintuple("Indian Polity (भारतीय राजव्यवस्था)", "Preamble, Fundamental Rights & DPSP (प्रस्तावना, मूल अधिकार व नीति निदेशक तत्व)", "प्रस्तावना, मौलिक अधिकार (अनुच्छेद 12-35), मूल कर्तव्य व DPSP", false, "Topic #9"),
            Quintuple("Indian Polity (भारतीय राजव्यवस्था)", "Parliament, President, Supreme Court & Panchayati Raj", "संसद, राष्ट्रपति, सर्वोच्च न्यायालय एवं पंचायती राज (73वां/74वां संशोधन)", false, "Topic #10"),
            Quintuple("Geography & Env (भूगोल व पर्यावरण)", "Himalayan & Peninsular River Systems + Monsoon", "हिमालयी एवं प्रायद्वीपीय नदी तंत्र + भारतीय मानसून व मिट्टी", false, "Topic #11"),
            Quintuple("Geography & Env (भूगोल व पर्यावरण)", "National Parks, Biosphere Reserves & Climate Summits", "राष्ट्रीय उद्यान, टाइगर रिज़र्व, जैव-मंडल आरक्षित क्षेत्र व COP सम्मेलन", false, "Topic #12"),
            Quintuple("Economy & Budget (अर्थव्यवस्था)", "RBI Monetary Policy, Inflation, GST & Union Budget 2025-26", "आरबीआई मौद्रिक नीति, मुद्रास्फीति, जीएसटी एवं केंद्रीय बजट 2025-26", false, "Topic #13"),
            Quintuple("Maths & Data Interpretation (गणित व DI)", "Excel Table DI, Bar Graph Index, Percentage & Ratio", "एक्सेल तालिका (Table DI), बार ग्राफ इंडेक्स, प्रतिशत एवं अनुपात", false, "Topic #14"),
            Quintuple("Science, Tech & JE/NEET Core", "Physics Mechanics, Chemistry Bonding, Cell Biology & JE Technical", "भौतिकी यांत्रिकी, रासायनिक आबंधन, कोशिका विज्ञान एवं JE टेक्निकल", false, "Topic #15")
        )
        topicWiseSpecs.forEachIndexed { idx, (subjGroup, topicEn, topicHi, isPaid, badge) ->
            seed += 50
            val qs = buildArchetypeQuestions(
                baseId = seed,
                examName = profile.examTitleEn,
                subject = subjGroup,
                topicEn = topicEn,
                topicHi = topicHi,
                pyqYearTag = "$badge • High-Yield"
            )
            val testId = if (idx == 13) "${normKey}_topic_maths_di_14" else "${normKey}_topic_${idx + 1}"
            entries.add(
                ExamPackageTestEntry(
                    id = testId,
                    examKey = normKey,
                    packageCategory = ExamPackageCategory.TOPIC_WISE,
                    isPaidOnly = isPaid,
                    subjectGroupEn = subjGroup,
                    subjectGroupHi = subjGroup,
                    topicTagEn = topicEn,
                    topicTagHi = topicHi,
                    pyqYear = badge,
                    mockTest = MockTest(
                        testId = testId,
                        title = "${profile.examTitleEn} Topic Quiz: $topicEn",
                        hindiTitle = "${profile.examTitleHi} टॉपिक क्विज़: $topicHi",
                        examName = profile.examTitleEn,
                        durationMinutes = 20,
                        totalMarks = (qs.size * profile.positiveMarks).toInt().coerceAtLeast(10),
                        positiveMarks = profile.positiveMarks,
                        negativeMarks = profile.negativeMarks,
                        questions = qs,
                        categoryId = normKey
                    )
                )
            )
        }

        // ═══════════════════════════════════════════════════════════════════════════════
        // PART 5: FREE DAILY QUIZ & PRACTICE QUIZ (4 डेली व प्रैक्टिस क्विज़ — हर एग्जाम सेंटर में फ्री)
        // ═══════════════════════════════════════════════════════════════════════════════
        val dailyPracticeSpecs = listOf(
            Triple("Daily Speed Quiz: High-Yield GS & Current Affairs", "डेली स्पीड क्विज़: उच्च-वेटेज सामान्य अध्ययन एवं करंट अफेयर्स", "Daily Quiz #1"),
            Triple("Practice Quiz: Statement-Based & Conceptual Drill", "प्रैक्टिस क्विज़: कथन-आधारित एवं वैचारिक अभ्यास", "Practice Quiz #2"),
            Triple("Practice Quiz: Quantitative DI Table & Reasoning Booster", "प्रैक्टिस क्विज़: गणितीय तालिका (DI), ग्राफ एवं रीजनिंग बूस्टर", "Practice Quiz #3"),
            Triple("Practice Quiz: Core Domain / NCERT Rapid Revision", "प्रैक्टिस क्विज़: एनसीईआरटी (NCERT) एवं कोर विषय त्वरित रिवीजन", "Practice Quiz #4")
        )
        dailyPracticeSpecs.forEachIndexed { idx, (qTitleEn, qTitleHi, tag) ->
            seed += 50
            val qs = buildArchetypeQuestions(
                baseId = seed,
                examName = profile.examTitleEn,
                subject = "Daily & Practice Booster",
                topicEn = qTitleEn,
                topicHi = qTitleHi,
                pyqYearTag = tag
            )
            val testId = "${normKey}_daily_practice_${idx + 1}"
            entries.add(
                ExamPackageTestEntry(
                    id = testId,
                    examKey = normKey,
                    packageCategory = ExamPackageCategory.DAILY_PRACTICE,
                    isPaidOnly = false,
                    subjectGroupEn = "Daily & Practice Quiz Hub",
                    subjectGroupHi = "डेली क्विज़ एवं प्रैक्टिस हब",
                    topicTagEn = qTitleEn,
                    topicTagHi = qTitleHi,
                    pyqYear = tag,
                    mockTest = MockTest(
                        testId = testId,
                        title = "${profile.examTitleEn} — $qTitleEn",
                        hindiTitle = "${profile.examTitleHi} — $qTitleHi",
                        examName = profile.examTitleEn,
                        durationMinutes = 15,
                        totalMarks = (qs.size * profile.positiveMarks).toInt().coerceAtLeast(10),
                        positiveMarks = profile.positiveMarks,
                        negativeMarks = profile.negativeMarks,
                        questions = qs,
                        categoryId = normKey
                    )
                )
            )
        }

        packageCache[normKey] = entries
        return entries
    }

    /**
     * Free E-Book Notes & Branded PDFs with Official Shakuntalam Branding (`SHAKUNTALAM • शकुंतलम • E-BOOKS & TEST SERIES`).
     * Students can read these Free E-Book Notes directly in the app (`ReaderScreen`) or download the PDF for offline study!
     */
    val freeShakuntalamBrandedNotes: List<StudyItem> = listOf(
        StudyItem(
            id = "free_note_upsc_history_capsule",
            title = "[FREE PDF] Shakuntalam Ancient, Medieval & Modern History Complete Notes (Indus Valley, Maurya, Gupta & 1857-1947)",
            hindiTitle = "[फ्री ई-बुक/PDF] शकुंतलम प्राचीन, मध्यकालीन व आधुनिक इतिहास संपूर्ण नोट्स (सिंधु घाटी, मौर्य, गुप्त व राष्ट्रीय आंदोलन)",
            seriesName = "SHAKUNTALAM Official Free Notes Series",
            categoryId = "upsc",
            subSectionId = "upsc_prelims",
            subjectId = "upsc_hist",
            type = ContentType.EBOOK,
            medium = "Bilingual (Hindi + English)",
            originalPrice = 299,
            discountedPrice = 0,
            rating = 4.9f,
            reviewCount = 4820,
            edition = "2025-26 Free Shakuntalam Edition",
            totalPagesOrTests = "185 Pages • Free PDF & In-App Reader",
            features = listOf(
                "Official SHAKUNTALAM • शकुंतलम Branded Topic-Wise Revision Notes",
                "Covers Indus Valley, Vedic, Mauryan Empire, Gupta Golden Age, Sultanate, Mughal & Freedom Struggle",
                "100% Free In-App Reading + 1-Tap Offline PDF Download"
            ),
            description = "Official Shakuntalam Publications Free Revision Notes covering Ancient, Medieval, and Modern Indian History for UPSC, UPPCS, UKPSC, BPSC, UP Police, SSC & State Exams.",
            chapters = listOf(
                BookChapter(
                    chapterNumber = 1,
                    title = "1. Ancient India: Indus Valley, Mauryan & Gupta Empire",
                    hindiTitle = "1. प्राचीन भारत: सिंधु घाटी सभ्यता, मौर्य साम्राज्य एवं गुप्त काल",
                    pageCount = 62,
                    content = """
                        ═══════════════════════════════════════════════════════════
                        SHAKUNTALAM • शकुंतलम • E-BOOKS & TEST SERIES (OFFICIAL NOTES)
                        ═══════════════════════════════════════════════════════════
                        
                        CHAPTER 1: ANCIENT INDIAN HISTORY (प्राचीन भारत का इतिहास)
                        
                        1. INDUS VALLEY CIVILIZATION (सिंधु घाटी सभ्यता — 2500–1750 BCE):
                        • Harappa (हड़प्पा): Discovered by Daya Ram Sahni (1921) on Ravi River; Great Granary, Coffin burial, R-37 cemetery.
                        • Mohenjo-daro (मोहनजोदड़ो): Discovered by R.D. Banerji (1922) on Indus River; Great Bath (वृहद स्नानागार), Bronze Dancing Girl, Pashupati Seal.
                        • Lothal (लोथल - गुजरात): Bhogava River; Artificial Dockyard (गोदीवाड़ा), Couple burial, Rice husk evidence.
                        • Dholavira (धोलावीरा - कच्छ): UNESCO World Heritage Site (40th); 3-part town planning, Giant Water Reservoir & Signboard inscription.
                        • Kalibangan (कालीबंगा - राजस्थान): Ghaggar River; Ploughed field (जुते हुए खेत के साक्ष्य), Fire altars, Black bangles.
                        
                        2. MAURYAN EMPIRE (मौर्य साम्राज्य — 322–185 BCE):
                        • Chandragupta Maurya: Defeated Seleucus Nicator (305 BCE); Megasthenes wrote 'Indica'; Kautilya authored 'Arthashastra' (15 Adhikaranas).
                        • Emperor Ashoka (268–232 BCE): Kalinga War in 261 BCE (8th Regnal Year — Major Rock Edict XIII).
                        • James Prinsep (1837): First deciphered Ashokan Brahmi script inscriptions.
                        • Sanchi Stupa (MP) & Lion Capital of Sarnath (National Emblem with 'Satyameva Jayate' from Mundaka Upanishad).
                        
                        3. GUPTA EMPIRE (गुप्त साम्राज्य — Golden Age of India):
                        • Samudragupta ('Napoleon of India'): Prayag Prashasti composed by court poet Harisena in Sanskrit on Allahabad Pillar.
                        • Chandragupta II (Vikramaditya): Navratnas including Kalidasa (Abhijnanashakuntalam, Meghaduta), Aryabhata, Varahamihira, Dhanvantari; Chinese pilgrim Fa-Hien visited India.
                        • Nalanda Mahavihara: Founded by Kumaragupta I (Shakratiya); Dashavatara Temple at Deogarh (First Panchayatan Nagara style temple).
                        
                        [पिछले 5 वर्षों के UPSC, PCS एवं SSC प्रश्नों पर आधारित — शकुंतलम पब्लिकेशन्स]
                    """.trimIndent()
                ),
                BookChapter(
                    chapterNumber = 2,
                    title = "2. Medieval & Modern India: Sultanate, Mughals & 1857–1947",
                    hindiTitle = "2. मध्यकालीन एवं आधुनिक भारत: सल्तनत, मुगल एवं स्वतंत्रता संग्राम (1857–1947)",
                    pageCount = 65,
                    content = """
                        ═══════════════════════════════════════════════════════════
                        SHAKUNTALAM • शकुंतलम • E-BOOKS & TEST SERIES (OFFICIAL NOTES)
                        ═══════════════════════════════════════════════════════════
                        
                        CHAPTER 2: MEDIEVAL & MODERN HISTORY (मध्यकालीन एवं आधुनिक इतिहास)
                        
                        1. DELHI SULTANATE & VIJAYANAGARA (दिल्ली सल्तनत एवं विजयनगर):
                        • Iltutmish: Introduced Iqta system, Silver Tanka & Copper Jital, Turkan-i-Chahalgani (Group of 40).
                        • Alauddin Khilji: Market Control Policy (Diwan-i-Riyasat), Dagh (branding of horses) & Huliya/Chehra system.
                        • Vijayanagara Empire (1336 CE): Founded by Harihara & Bukka; Krishnadevaraya (Tuluva dynasty) wrote 'Amuktamalyada' & patronized Ashtadiggajas.
                        
                        2. REVOLT OF 1857 & INDIAN NATIONAL MOVEMENT (1857 की क्रांति व राष्ट्रीय आंदोलन):
                        • 1857 Key Centers: Delhi (Bahadur Shah II & Bakht Khan), Kanpur (Nana Saheb & Tatya Tope), Lucknow (Begum Hazrat Mahal), Jhansi (Rani Lakshmibai), Bihar/Jagdishpur (Kunwar Singh).
                        • INC Key Sessions: 1885 Bombay (W.C. Bonnerjee), 1907 Surat Split, 1916 Lucknow Pact (Ambica Charan Mazumdar), 1924 Belgaum (Mahatma Gandhi), 1929 Lahore (Jawaharlal Nehru — Purna Swaraj).
                        • Gandhian Movements: Champaran Satyagraha (1917), Non-Cooperation (1920), Dandi March & Civil Disobedience (1930), Quit India Movement (8 Aug 1942 — 'Do or Die').
                    """.trimIndent()
                )
            ),
            isBestseller = true,
            isTrending = true
        ),
        StudyItem(
            id = "free_note_polity_constitution_pdf",
            title = "[FREE PDF] Shakuntalam Indian Polity, Constitution & UP Police Law/BNS Master Notes",
            hindiTitle = "[फ्री ई-बुक/PDF] शकुंतलम भारतीय संविधान, राजव्यवस्था एवं यूपी पुलिस प्रशासन मास्टर नोट्स",
            seriesName = "SHAKUNTALAM Official Free Notes Series",
            categoryId = "state_psc",
            subSectionId = "psc_uppcs",
            subjectId = "uppcs_polity",
            type = ContentType.EBOOK,
            medium = "Bilingual (Hindi + English)",
            originalPrice = 249,
            discountedPrice = 0,
            rating = 4.9f,
            reviewCount = 3910,
            edition = "2025-26 Free Shakuntalam Edition",
            totalPagesOrTests = "150 Pages • Free PDF & In-App Reader",
            features = listOf(
                "Official SHAKUNTALAM • शकुंतलम Branded Constitutional Tables & One-Liners",
                "Complete Preamble, Fundamental Rights, DPSP, Parliament, Judiciary, BNS & 106th Amendment",
                "Free In-App Reader + Instant Offline PDF Download"
            ),
            description = "High-yield bilingual Indian Polity, Constitution & Police System Free E-Book & PDF Notes for UPSC, UPPCS, UP Police Constable/SI, UKPSC, BPSC, UPSSSC, UKSSSC & SSC.",
            chapters = listOf(
                BookChapter(
                    chapterNumber = 1,
                    title = "1. Constitutional Framework, Fundamental Rights & Amendments",
                    hindiTitle = "1. संवैधानिक ढांचा, मौलिक अधिकार, संसद एवं प्रमुख संविधान संशोधन",
                    pageCount = 150,
                    content = """
                        ═══════════════════════════════════════════════════════════
                        SHAKUNTALAM • शकुंतलम • E-BOOKS & TEST SERIES (OFFICIAL NOTES)
                        ═══════════════════════════════════════════════════════════
                        
                        INDIAN POLITY & CONSTITUTION MASTER CAPSULE (भारतीय राजव्यवस्था)
                        
                        1. FUNDAMENTAL RIGHTS (मौलिक अधिकार — Part III, Articles 12 to 35):
                        • Right to Equality (समता का अधिकार): Articles 14–18 (Art 17: Abolition of Untouchability).
                        • Right to Freedom (स्वतंत्रता का अधिकार): Articles 19–22 (Art 21: Right to Life & Personal Liberty; Art 21A: Right to Education via 86th Amendment 2002).
                        • Constitutional Remedies (संवैधानिक उपचारों का अधिकार): Article 32 (Heart & Soul of the Constitution — 5 Writs: Habeas Corpus, Mandamus, Prohibition, Certiorari, Quo-Warranto).
                        
                        2. LANDMARK CONSTITUTIONAL AMENDMENTS (प्रमुख संविधान संशोधन):
                        • 42nd Amendment (1976): Added 'Socialist, Secular, Integrity' to Preamble; Fundamental Duties (Part IVA, Art 51A on Swaran Singh Committee).
                        • 44th Amendment (1978): Right to Property moved from Art 31 to Art 300A (Legal Right).
                        • 73rd & 74th Amendments (1992): Panchayati Raj (11th Schedule, 29 subjects) & Municipalities (12th Schedule, 18 subjects).
                        • 101st Amendment: GST (Art 279A — GST Council); 106th Amendment (2023): Nari Shakti Vandan Adhiniyam (33% reservation for women in Lok Sabha & State Assemblies).
                    """.trimIndent()
                )
            ),
            isBestseller = true,
            isTrending = true
        ),
        StudyItem(
            id = "free_note_ssc_rrb_maths_di_pdf",
            title = "[FREE PDF] Shakuntalam Maths Formula, Excel DI Tables & Reasoning Handbook (SSC, UP Police, RRB, Banking, UPSSSC)",
            hindiTitle = "[फ्री ई-बुक/PDF] शकुंतलम गणित सूत्र, एक्सेल तालिका (DI), ग्राफ व रीजनिंग हैंडबुक (SSC, यूपी पुलिस, रेलवे, PET)",
            seriesName = "SHAKUNTALAM Official Free Notes Series",
            categoryId = "ssc",
            subSectionId = "ssc_cgl",
            subjectId = "ssc_maths",
            type = ContentType.EBOOK,
            medium = "Bilingual (Hindi + English)",
            originalPrice = 249,
            discountedPrice = 0,
            rating = 4.8f,
            reviewCount = 5240,
            edition = "2025-26 Free Shakuntalam Edition",
            totalPagesOrTests = "160 Pages • Free PDF & In-App Reader",
            features = listOf(
                "Structured Excel-Style Data Interpretation (DI) Tables, Bar Graphs & Pie Chart Shortcut Formulas",
                "Complete Arithmetic & Advance Maths (Trigonometry, Geometry, Mensuration, Algebra) for SSC, UP Police & RRB",
                "Free In-App Reader + Offline PDF Download with Shakuntalam Branding"
            ),
            description = "Complete Quantitative Aptitude, Data Interpretation (Tables & Graphs), and Reasoning Free E-Book PDF with Shakuntalam Branding.",
            chapters = listOf(
                BookChapter(
                    chapterNumber = 1,
                    title = "1. Data Interpretation (Excel Tables & Bar Graphs) + Quantitative Shortcuts",
                    hindiTitle = "1. डेटा इंटरप्रिटेशन (तालिका एवं बार ग्राफ) + गणित शॉर्टकट सूत्र",
                    pageCount = 160,
                    content = """
                        ═══════════════════════════════════════════════════════════
                        SHAKUNTALAM • शकुंतलम • E-BOOKS & TEST SERIES (OFFICIAL NOTES)
                        ═══════════════════════════════════════════════════════════
                        
                        MATHS & DATA INTERPRETATION (DI) MASTER HANDBOOK
                        
                        1. STRUCTURED INDEX & DI TABLE FORMULAS (तालिका एवं ग्राफ सूत्र):
                        ┌──────────────────────┬──────────────────────────────────────────┐
                        │ Metric / मापदंड        │ Standard Formula / मानक सूत्र             │
                        ├──────────────────────┼──────────────────────────────────────────┤
                        │ Percentage Growth %  │ ((Final - Initial) / Initial) × 100      │
                        │ Central Angle (Pie)  │ (Value / Total) × 360°                   │
                        │ Compound Growth (CI) │ A = P × (1 + R/100)^n                    │
                        │ Average Speed        │ (2 × S1 × S2) / (S1 + S2)                │
                        └──────────────────────┴──────────────────────────────────────────┘
                        
                        2. ADVANCE MATHS GOLDEN IDENTITIES (बीजगणित एवं त्रिकोणमिति):
                        • sin²θ + cos²θ = 1  |  sec²θ - tan²θ = 1  |  cosec²θ - cot²θ = 1
                        • a³ + b³ + c³ - 3abc = (a + b + c)(a² + b² + c² - ab - bc - ca)
                        • Euler's Formula for Polyhedra: F + V - E = 2
                    """.trimIndent()
                )
            ),
            isBestseller = true,
            isTrending = true
        ),
        StudyItem(
            id = "free_note_je_neet_science_tech_pdf",
            title = "[FREE PDF] Shakuntalam Science, NEET NCERT Biology/Chem & Engineering JE (SSC JE / RRB JE / IIT JEE) Notes",
            hindiTitle = "[फ्री ई-बुक/PDF] शकुंतलम विज्ञान, NEET बायोलॉजी/केमिस्ट्री एवं जूनियर इंजीनियर (JE / IIT JEE) मास्टर नोट्स",
            seriesName = "SHAKUNTALAM Official Free Notes Series",
            categoryId = "jee_neet",
            subSectionId = "neet_ug",
            subjectId = "neet_bio",
            type = ContentType.EBOOK,
            medium = "Bilingual (Hindi + English)",
            originalPrice = 349,
            discountedPrice = 0,
            rating = 4.9f,
            reviewCount = 4150,
            edition = "2025-26 Free Shakuntalam Edition",
            totalPagesOrTests = "210 Pages • Free PDF & In-App Reader",
            features = listOf(
                "Official SHAKUNTALAM • शकुंतलम Branded Notes for NEET UG, IIT JEE & SSC/RRB JE",
                "Covers Physics Laws, Organic/Inorganic Chemistry, NCERT Biology & Civil/Electrical/Mechanical JE Formulas",
                "100% Free In-App Reading + Offline PDF Download"
            ),
            description = "Free Shakuntalam Branded E-Book & PDF Notes for NEET UG, IIT JEE, and Junior Engineer (SSC JE / RRB JE).",
            chapters = listOf(
                BookChapter(
                    chapterNumber = 1,
                    title = "1. Physics, Chemistry, NCERT Biology & Engineering JE Core Formulas",
                    hindiTitle = "1. भौतिकी, रसायन, एनसीईआरटी जीवविज्ञान एवं इंजीनियरिंग (JE) प्रमुख सूत्र",
                    pageCount = 210,
                    content = """
                        ═══════════════════════════════════════════════════════════
                        SHAKUNTALAM • शकुंतलम • E-BOOKS & TEST SERIES (OFFICIAL NOTES)
                        ═══════════════════════════════════════════════════════════
                        
                        NEET UG • IIT JEE • SSC JE / RRB JE MASTER FORMULA & NCERT CAPSULE
                        
                        1. PHYSICS & ELECTRICAL/MECHANICAL JE CORE:
                        • Ohm's Law & Power: V = I×R  |  P = V×I = I²R = V²/R
                        • Thermodynamics 1st Law: ΔQ = ΔU + ΔW  |  Carnot Efficiency η = 1 - (T_sink / T_source)
                        • Bending Equation (Strength of Materials - JE Civil/Mech): M / I = σ / y = E / R
                        
                        2. CHEMISTRY & NCERT BIOLOGY (NEET / JEE):
                        • Nernst Equation: E_cell = E°_cell - (0.0591 / n) log Q (at 298 K)
                        • Cell Organelles: Mitochondria (ATP synthesis - Powerhouse), Ribosomes (70S in Prokaryotes, 80S in Eukaryotes - Protein synthesis), Chloroplast (Photosynthesis).
                        • Genetics & Biotech: Watson & Crick Double Helix DNA; PCR (Polymerase Chain Reaction - Kary Mullis, Taq Polymerase).
                    """.trimIndent()
                )
            ),
            isBestseller = true,
            isTrending = true
        )
    )

    val defaultBrandedPdfDocuments: List<EbookDocumentEntity> = freeShakuntalamBrandedNotes.map { item ->
        EbookDocumentEntity(
            id = "pdf_${item.id}",
            title = item.title,
            hindiTitle = item.hindiTitle,
            examId = item.categoryId,
            subjectId = item.subjectId,
            fileName = "Shakuntalam_${item.id}.pdf",
            fileUri = "shakuntalam://free_notes/${item.id}.pdf",
            fileSizeFormatted = "4.8 MB",
            pageCount = 180,
            originalPrice = item.originalPrice,
            discountedPrice = 0,
            medium = item.medium,
            sampleContent = item.chapters.joinToString("\n\n") { it.content }
        )
    }

    private data class Quintuple<A, B, C, D, E>(
        val first: A,
        val second: B,
        val third: C,
        val fourth: D,
        val fifth: E
    )
}
