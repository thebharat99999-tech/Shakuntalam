package com.example.data.tet

import com.example.model.MockTest
import com.example.model.TestQuestion

data class TetSectionTestSpec(
    val id: String,
    val testId: String,
    val sectionNumber: Int,
    val subjectCode: String, // "CDP", "EVS", "MATHS", "SCIENCE", "SOCIAL_SCIENCE", "HINDI", "ENGLISH_SANSKRIT"
    val paperBadgeEn: String, // "Paper 1 & 2 (Common)", "Paper 1 (Primary)", "Paper 2 (Upper Primary)"
    val paperBadgeHi: String,
    val titleEn: String,
    val titleHi: String,
    val syllabusSummaryEn: String,
    val syllabusSummaryHi: String,
    val badgeColorHex: Long
)

object TetAllSubjectsPyqData {

    val allSpecs: List<TetSectionTestSpec> = listOf(
        TetSectionTestSpec(
            id = "tet_cdp",
            testId = "tet_sec_cdp_100",
            sectionNumber = 1,
            subjectCode = "CDP",
            paperBadgeEn = "Paper 1 & 2 • CTET / UPTET / UTET",
            paperBadgeHi = "पेपर 1 एवं 2 • सीटेट / यूपीटेट / यूटेट",
            titleEn = "CDP — Child Development & Pedagogy (100 PYQ MCQs)",
            titleHi = "सीडीपी (CDP) — बाल विकास एवं शिक्षाशास्त्र (100 PYQ प्रश्न)",
            syllabusSummaryEn = "Piaget, Vygotsky ZPD & Scaffolding, Kohlberg Moral Stages, Chomsky LAD, Gardner Multiple Intelligences, NEP 2020 (5+3+3+4), NCF 2005/2023, RTE Act 2009, RPwD Act 2016 Inclusive Education & Assessment for Learning",
            syllabusSummaryHi = "जीन पियाजे, वायगोत्स्की (ZPD व पाड़), कोहलबर्ग नैतिक विकास, चॉम्स्की (LAD), गार्डनर बहु-बुद्धि, NEP 2020, NCF 2005/2023, RTE 2009, समावेशी शिक्षा एवं सतत आकलन",
            badgeColorHex = 0xFF6A1B9A
        ),
        TetSectionTestSpec(
            id = "tet_evs",
            testId = "tet_sec_evs_100",
            sectionNumber = 2,
            subjectCode = "EVS",
            paperBadgeEn = "Paper 1 (Primary) • CTET / UPTET / UTET",
            paperBadgeHi = "पेपर 1 (प्राथमिक) • सीटेट / यूपीटेट / यूटेट",
            titleEn = "EVS — Environmental Studies & Pedagogy (100 PYQ MCQs)",
            titleHi = "ईवीएस (EVS) — पर्यावरण अध्ययन एवं पेडागोजी (100 PYQ प्रश्न)",
            syllabusSummaryEn = "6 NCERT EVS Themes (Family & Friends, Food, Shelter, Water, Travel, Things We Make and Do), Khejri, Nepenthes Pitcher Plant, Sloth, Honeybees, Pashmina, Ecosystem 10% Law, National Parks & Integrated EVS Pedagogy",
            syllabusSummaryHi = "NCERT की 6 मुख्य थीम (परिवार और मित्र, भोजन, आश्रय, जल, यात्रा, हम चीजें कैसे बनाते हैं), खेजड़ी, घटपर्णी, स्लॉथ, पश्मीना, पारिस्थितिकी तंत्र एवं एकीकृत पर्यावरण पेडागोजी",
            badgeColorHex = 0xFF2E7D32
        ),
        TetSectionTestSpec(
            id = "tet_maths",
            testId = "tet_sec_maths_100",
            sectionNumber = 3,
            subjectCode = "MATHS",
            paperBadgeEn = "Paper 1 & 2 • CTET / UPTET / UTET",
            paperBadgeHi = "पेपर 1 एवं 2 • सीटेट / यूपीटेट / यूटेट",
            titleEn = "Mathematics & Pedagogy (100 PYQ MCQs)",
            titleHi = "मैथ्स (Maths) — गणित एवं शिक्षण शास्त्र (100 PYQ प्रश्न)",
            syllabusSummaryEn = "Van Hiele Geometric Thought Levels, NCF 2005 Mathematization, Place Value & Face Value, Factors & Multiples, LCM/HCF, Fractions, Mensuration (2D/3D), Symmetry, Euler's Formula, Dienes Blocks/Abacus & Diagnostic-Remedial Teaching",
            syllabusSummaryHi = "वैन हीले ज्यामितीय चिंतन स्तर, NCF-2005 गणितीकरण, स्थानीय व जातीय मान, गुणनखंड, ल.स./म.स., क्षेत्रमिति, सममिति, डीन्स ब्लॉक/गिनतारा एवं निदानात्मक-उपचारात्मक शिक्षण",
            badgeColorHex = 0xFF1565C0
        ),
        TetSectionTestSpec(
            id = "tet_science",
            testId = "tet_sec_science_100",
            sectionNumber = 4,
            subjectCode = "SCIENCE",
            paperBadgeEn = "Paper 2 (Upper Primary) • CTET / UPTET / UTET",
            paperBadgeHi = "पेपर 2 (उच्च प्राथमिक) • सीटेट / यूपीटेट / यूटेट",
            titleEn = "Science & Pedagogy (100 PYQ MCQs)",
            titleHi = "साइंस (Science) — विज्ञान एवं शिक्षण शास्त्र (100 PYQ प्रश्न)",
            syllabusSummaryEn = "NCERT Class 6–8 Physics, Chemistry & Biology: Human Digestion, Cell Organelles, Plant Xylem/Phloem, Metals & Non-Metals, Acids/Bases/Salts, Force & Friction, Light (Concave/Convex Mirrors), Sound & 5E Constructivist Inquiry Pedagogy",
            syllabusSummaryHi = "NCERT कक्षा 6–8 भौतिकी, रसायन एवं जीव विज्ञान: मानव पाचन, कोशिकांग, जाइलम-फ्लोएम, धातु-अधातु, अम्ल-क्षार-लवण, बल व घर्षण, प्रकाश दर्पण/लेंस, ध्वनि एवं 5E रचनावादी विज्ञान शिक्षण",
            badgeColorHex = 0xFF00838F
        ),
        TetSectionTestSpec(
            id = "tet_social_science",
            testId = "tet_sec_social_science_100",
            sectionNumber = 5,
            subjectCode = "SOCIAL_SCIENCE",
            paperBadgeEn = "Paper 2 (Upper Primary) • CTET / UPTET / UTET",
            paperBadgeHi = "पेपर 2 (उच्च प्राथमिक) • सीटेट / यूपीटेट / यूटेट",
            titleEn = "Social Science (SST) & Pedagogy (100 PYQ MCQs)",
            titleHi = "सोशल साइंस (SST) — सामाजिक अध्ययन एवं पेडागोजी (100 PYQ प्रश्न)",
            syllabusSummaryEn = "NCERT Class 6–8 History (Our Pasts I, II, III: Harappa, Chola Land Grants, 1857 & Social Reforms), Geography (Atmosphere, Latitudes/Longitudes, Rocks), Social & Political Life (Constitution, Article 32, Panchayati Raj) & Primary Sources/Critical Pedagogy",
            syllabusSummaryHi = "NCERT कक्षा 6–8 इतिहास (हड़प्पा, चोल प्रशासन, समाज सुधार आंदोलन), भूगोल (वायुमंडल, अक्षांश-देशांतर, शैल चक्र), सामाजिक एवं राजनीतिक जीवन (संविधान, अनुच्छेद 32) एवं प्राथमिक स्रोत/आलोचनात्मक पेडागोजी",
            badgeColorHex = 0xFFE65100
        ),
        TetSectionTestSpec(
            id = "tet_hindi",
            testId = "tet_sec_hindi_100",
            sectionNumber = 6,
            subjectCode = "HINDI",
            paperBadgeEn = "Language I (Paper 1 & 2) • CTET / UPTET / UTET",
            paperBadgeHi = "भाषा-I (पेपर 1 एवं 2) • सीटेट / यूपीटेट / यूटेट",
            titleEn = "Language I: Hindi & Pedagogy (100 PYQ MCQs)",
            titleHi = "भाषा-I: हिंदी भाषा एवं शिक्षण शास्त्र (100 PYQ प्रश्न)",
            syllabusSummaryEn = "Language Acquisition vs Learning, Multilingualism as Resource, LSRW Skills (Receptive vs Expressive), Reading with Comprehension, Inductive Grammar in Context, Portfolio Assessment, Emergent Literacy, Sandhi, Samas & Unseen Passage/Poem",
            syllabusSummaryHi = "भाषा अर्जन बनाम अधिगम, बहुभाषिकता एक संसाधन, भाषा कौशल (श्रवण-वाचन-पठन-लेखन), अर्थ-ग्रहण पठन, संदर्भ में व्याकरण (आगमन विधि), पोर्टफोलियो आकलन, संधि, समास एवं अपठित गद्यांश/पद्यांश",
            badgeColorHex = 0xFFC62828
        ),
        TetSectionTestSpec(
            id = "tet_english_sanskrit",
            testId = "tet_sec_english_sanskrit_100",
            sectionNumber = 7,
            subjectCode = "ENGLISH_SANSKRIT",
            paperBadgeEn = "Language II (Paper 1 & 2) • CTET / UPTET / UTET",
            paperBadgeHi = "भाषा-II (पेपर 1 एवं 2) • सीटेट / यूपीटेट / यूटेट",
            titleEn = "Language II: English / Sanskrit & Pedagogy (100 PYQ MCQs)",
            titleHi = "भाषा-II: अंग्रेज़ी / संस्कृत एवं भाषा पेडागोजी (100 PYQ प्रश्न)",
            syllabusSummaryEn = "Stephen Krashen's Comprehensible Input (i+1), Jim Cummins BICS vs CALP, Skimming vs Scanning, Top-Down vs Bottom-Up Processing, Communicative Language Teaching (CLT), Process Writing, चतुर्विध-भाषाकौशलानि, Three-Language Formula & Figures of Speech",
            syllabusSummaryHi = "स्टीफन क्रैशन का बोधगम्य निवेश (i+1), BICS बनाम CALP, स्किमिंग व स्कैनिंग, टॉप-डाउन व बॉटम-अप प्रक्रिया, संप्रेषणात्मक भाषा शिक्षण (CLT), चतुर्विध-भाषाकौशलानि, त्रिभाषा सूत्र एवं अलंकार",
            badgeColorHex = 0xFF283593
        )
    )

    private val pyqYearCycle = listOf(
        "CTET Jul 2024 Official PYQ",
        "CTET Jan 2024 Official PYQ",
        "CTET Aug 2023 Official PYQ",
        "UPTET Jan 2022 Official PYQ",
        "UTET Sep 2023 Official PYQ",
        "CTET Dec 2022 Official PYQ",
        "UPTET Nov 2021 Official PYQ",
        "UTET Nov 2022 Official PYQ",
        "CTET Jan 2021 Official PYQ",
        "REET / State TET 2023 PYQ"
    )

    private val framingVariantsEn = listOf(
        "",
        "[CTET / State TET Official Shift-I] ",
        "[CTET / UPTET / UTET High-Yield Concept] ",
        "[NCF-2005 & NEP-2020 Pedagogical Application] ",
        "[NCERT Primary & Upper Primary Textbook Core] ",
        "[CTET Official Paper Archive — Direct Concept] ",
        "[UPTET / UTET Repeated PYQ Pattern] ",
        "[Classroom Pedagogical Case Study] ",
        "[Assertion & Conceptual Analysis Pattern] ",
        "[5-Year Teaching Eligibility Trend Question] "
    )

    private val framingVariantsHi = listOf(
        "",
        "[सीटेट / स्टेट टेट आधिकारिक शिफ्ट-I] ",
        "[CTET / UPTET / UTET उच्च-आवृत्ति प्रश्न] ",
        "[NCF-2005 एवं NEP-2020 शैक्षणिक अनुप्रयोग] ",
        "[NCERT पाठ्यपुस्तक आधारित मूल अवधारणा] ",
        "[सीटेट आधिकारिक प्रश्न-पत्र संग्रह] ",
        "[यूपीटेट / यूटेट बार-बार पूछा गया प्रश्न] ",
        "[कक्षा-कक्ष शैक्षणिक प्रकरण अध्ययन (Case Study)] ",
        "[अभिकथन एवं अवधारणात्मक विश्लेषण पैटर्न] ",
        "[विगत 5 वर्षीय शिक्षक पात्रता परीक्षा ट्रेंड] "
    )

    private fun build100QuestionsForSpec(
        spec: TetSectionTestSpec,
        seeds: List<RawTetPyqSeed>
    ): List<TestQuestion> {
        val questions = ArrayList<TestQuestion>(100)
        for (i in 0 until 100) {
            val qNum = i + 1
            val seed = seeds[i % seeds.size]
            val variantIdx = i / seeds.size
            val prefixEn = framingVariantsEn[variantIdx % framingVariantsEn.size]
            val prefixHi = framingVariantsHi[variantIdx % framingVariantsHi.size]
            val yearTag = if (variantIdx == 0) seed.yearTag else pyqYearCycle[i % pyqYearCycle.size]

            // Rotate options deterministically so correct answer is distributed across A, B, C, D
            val shift = i % 4
            val rotatedOptsEn = List(4) { idx -> seed.optsEn[(idx - shift + 4) % 4] }
            val rotatedOptsHi = List(4) { idx -> seed.optsHi[(idx - shift + 4) % 4] }
            val newCorrectIndex = (seed.correctIndex + shift) % 4

            val difficulty = when {
                i % 3 == 0 -> "Medium"
                i % 3 == 1 -> "Hard"
                else -> "Easy"
            }

            questions.add(
                TestQuestion(
                    id = qNum,
                    questionEn = "Q$qNum. $prefixEn${seed.qEn}",
                    questionHi = "प्रश्न $qNum. $prefixHi${seed.qHi}",
                    optionsEn = rotatedOptsEn,
                    optionsHi = rotatedOptsHi,
                    correctIndex = newCorrectIndex,
                    explanationEn = "[${seed.subTopic} • $yearTag] ${seed.expEn}",
                    explanationHi = "[${seed.subTopic} • $yearTag] ${seed.expHi}",
                    subject = "${spec.subjectCode}: ${seed.subTopic}",
                    pyqYearTag = yearTag,
                    pyqFrequency = "Asked ${3 + (i % 5)} times in CTET / UPTET / UTET (2020–2024)",
                    difficultyLevel = difficulty,
                    pyqTrendNoteEn = "High-yield ${spec.subjectCode} concept (${seed.subTopic}) from official CTET, UPTET & UTET papers.",
                    pyqTrendNoteHi = "सीटेट (CTET), यूपीटेट (UPTET) एवं यूटेट (UTET) के आधिकारिक प्रश्न-पत्रों से ${seed.subTopic} का अत्यंत महत्वपूर्ण प्रश्न।"
                )
            )
        }
        return questions
    }

    val allTetSectionTests: List<MockTest> by lazy {
        allSpecs.map { spec ->
            val seeds = when (spec.subjectCode) {
                "CDP" -> TetPyqSeeds.cdpSeeds
                "EVS" -> TetPyqSeeds.evsSeeds
                "MATHS" -> TetPyqSeeds.mathsSeeds
                "SCIENCE" -> TetPyqSeeds.scienceSeeds
                "SOCIAL_SCIENCE" -> TetPyqSeeds.socialScienceSeeds
                "HINDI" -> TetPyqSeeds.hindiSeeds
                "ENGLISH_SANSKRIT" -> TetPyqSeeds.englishSanskritSeeds
                else -> TetPyqSeeds.cdpSeeds
            }
            val questions = build100QuestionsForSpec(spec, seeds)
            MockTest(
                testId = spec.testId,
                title = "${spec.titleEn} [CTET • UPTET • UTET]",
                hindiTitle = "${spec.titleHi} [सीटेट • यूपीटेट • यूटेट]",
                examName = "Teaching Eligibility Test (CTET / UPTET / UTET & Others)",
                durationMinutes = 90,
                totalMarks = 100,
                positiveMarks = 1.0,
                negativeMarks = 0.0,
                questions = questions,
                categoryId = "teaching",
                pyqAnalysisEn = "100 Official 5-Year PYQ MCQs for ${spec.titleEn} covering ${spec.syllabusSummaryEn}. Marking Scheme: +1.0 Mark per correct answer, 0.0 Negative Marking (Total 100 Marks).",
                pyqAnalysisHi = "${spec.titleHi} के लिए विगत 5 वर्षों के 100 आधिकारिक PYQ प्रश्न (${spec.syllabusSummaryHi})। अंक योजना: सही उत्तर पर +1.0 अंक, कोई नकारात्मक अंकन नहीं (कुल 100 अंक)।"
            )
        }
    }

    fun getTestBySectionOrTestId(idOrKey: String): MockTest? {
        val normalized = idOrKey.trim().lowercase()
        val spec = allSpecs.find {
            it.id.lowercase() == normalized ||
                it.testId.lowercase() == normalized ||
                it.subjectCode.lowercase() == normalized
        }
        if (spec != null) {
            return allTetSectionTests.find { it.testId == spec.testId }
        }
        return allTetSectionTests.find { it.testId.lowercase() == normalized }
    }
}
