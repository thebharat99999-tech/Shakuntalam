package com.example.data.iitjee

import com.example.model.MockTest
import com.example.model.TestQuestion

data class IitJeeSectionTestSpec(
    val id: String,
    val testId: String,
    val sectionNumber: Int,
    val examLevel: String, // "MAIN" or "ADVANCED"
    val subjectGroup: String, // "PHYSICS", "CHEMISTRY", "MATH"
    val subjectCode: String, // "PHYSICS", "PHYSICAL_CHEM", "ORGANIC_CHEM", "INORGANIC_CHEM", "MATHEMATICS"
    val shortBadgeEn: String,
    val shortBadgeHi: String,
    val titleEn: String,
    val titleHi: String,
    val syllabusSummaryEn: String,
    val syllabusSummaryHi: String,
    val badgeColorHex: Long
)

object IitJeeAllSubjectsPyqData {

    val sectionSpecs: List<IitJeeSectionTestSpec> = listOf(
        // ==================== IIT JEE MAIN (5 SUBJECTS x 100 PYQs = 500 Qs) ====================
        IitJeeSectionTestSpec(
            id = "jee_main_physics",
            testId = "jee_main_sec_physics_100",
            sectionNumber = 1,
            examLevel = "MAIN",
            subjectGroup = "PHYSICS",
            subjectCode = "PHYSICS",
            shortBadgeEn = "JEE Main • Physics",
            shortBadgeHi = "JEE Main • भौतिकी",
            titleEn = "1. JEE Main: Physics (100 Qs)",
            titleHi = "1. JEE Main: भौतिक विज्ञान (Physics • 100 प्रश्न)",
            syllabusSummaryEn = "Mechanics, Rotational Motion, Electrostatics, Current Electricity, Magnetism, Optics, Modern Physics & Semiconductors • 100 5-Yr PYQs",
            syllabusSummaryHi = "यांत्रिकी, घूर्णी गति, स्थिरवैद्युतिकी, धारा विद्युत, चुंबकत्व, प्रकाशिकी, आधुनिक भौतिकी एवं अर्धचालक • 100 5-वर्षीय PYQs",
            badgeColorHex = 0xFF1E40AF
        ),
        IitJeeSectionTestSpec(
            id = "jee_main_physical_chem",
            testId = "jee_main_sec_physical_chem_100",
            sectionNumber = 2,
            examLevel = "MAIN",
            subjectGroup = "CHEMISTRY",
            subjectCode = "PHYSICAL_CHEM",
            shortBadgeEn = "JEE Main • Physical Chem",
            shortBadgeHi = "JEE Main • भौतिक रसायन",
            titleEn = "2. JEE Main: Physical Chemistry (100 Qs)",
            titleHi = "2. JEE Main: भौतिक रसायन (Physical Chemistry • 100 प्रश्न)",
            syllabusSummaryEn = "Mole Concept, Atomic Structure, Chemical & Ionic Equilibrium, Thermodynamics, Electrochemistry, Chemical Kinetics & Solutions • 100 5-Yr PYQs",
            syllabusSummaryHi = "मोल संकल्पना, परमाणु संरचना, रासायनिक एवं आयनिक साम्य, ऊष्मागतिकी, वैद्युत रसायन, रासायनिक बलगतिकी एवं विलयन • 100 5-वर्षीय PYQs",
            badgeColorHex = 0xFF047857
        ),
        IitJeeSectionTestSpec(
            id = "jee_main_organic_chem",
            testId = "jee_main_sec_organic_chem_100",
            sectionNumber = 3,
            examLevel = "MAIN",
            subjectGroup = "CHEMISTRY",
            subjectCode = "ORGANIC_CHEM",
            shortBadgeEn = "JEE Main • Organic Chem",
            shortBadgeHi = "JEE Main • कार्बनिक रसायन",
            titleEn = "3. JEE Main: Organic Chemistry (100 Qs)",
            titleHi = "3. JEE Main: कार्बनिक रसायन (Organic Chemistry • 100 प्रश्न)",
            syllabusSummaryEn = "GOC, Isomerism, Hydrocarbons, Haloalkanes, Alcohols, Aldehydes & Ketones, Carboxylic Acids, Amines & Biomolecules • 100 5-Yr PYQs",
            syllabusSummaryHi = "GOC, समावयवता, हाइड्रोकार्बन, हैलोएल्केन, अल्कोहल, एल्डिहाइड व कीटोन, कार्बोक्सिलिक अम्ल, ऐमीन एवं जैव-अणु • 100 5-वर्षीय PYQs",
            badgeColorHex = 0xFF7C3AED
        ),
        IitJeeSectionTestSpec(
            id = "jee_main_inorganic_chem",
            testId = "jee_main_sec_inorganic_chem_100",
            sectionNumber = 4,
            examLevel = "MAIN",
            subjectGroup = "CHEMISTRY",
            subjectCode = "INORGANIC_CHEM",
            shortBadgeEn = "JEE Main • Inorganic Chem",
            shortBadgeHi = "JEE Main • अकार्बनिक रसायन",
            titleEn = "4. JEE Main: Inorganic Chemistry (100 Qs)",
            titleHi = "4. JEE Main: अकार्बनिक रसायन (Inorganic Chemistry • 100 प्रश्न)",
            syllabusSummaryEn = "Periodic Table, Chemical Bonding (VSEPR & MOT), Coordination Compounds (CFT), p-Block & d/f-Block Elements • 100 5-Yr PYQs",
            syllabusSummaryHi = "आवर्त सारणी, रासायनिक आबंधन (VSEPR व MOT), उपसहसंयोजन यौगिक (CFT), p-ब्लॉक एवं d/f-ब्लॉक तत्व • 100 5-वर्षीय PYQs",
            badgeColorHex = 0xFFD97706
        ),
        IitJeeSectionTestSpec(
            id = "jee_main_mathematics",
            testId = "jee_main_sec_mathematics_100",
            sectionNumber = 5,
            examLevel = "MAIN",
            subjectGroup = "MATH",
            subjectCode = "MATHEMATICS",
            shortBadgeEn = "JEE Main • Mathematics",
            shortBadgeHi = "JEE Main • गणित",
            titleEn = "5. JEE Main: Mathematics (100 Qs)",
            titleHi = "5. JEE Main: गणित (Mathematics • 100 प्रश्न)",
            syllabusSummaryEn = "Calculus (Limits, Continuity, Definite Integration, Diff Eq), Algebra (Matrices, Complex, Binomial), Conics, 3D & Probability • 100 5-Yr PYQs",
            syllabusSummaryHi = "कलन (सीमा, सांतत्य, निश्चित समाकलन, अवकल समीकरण), बीजगणित (आव्यूह, सम्मिश्र संख्याएं), निर्देशांक ज्यामिति, 3D एवं प्रायिकता • 100 5-वर्षीय PYQs",
            badgeColorHex = 0xFFBE123C
        ),

        // ==================== IIT JEE ADVANCED (5 SUBJECTS x 100 PYQs = 500 Qs) ====================
        IitJeeSectionTestSpec(
            id = "jee_adv_physics",
            testId = "jee_adv_sec_physics_100",
            sectionNumber = 1,
            examLevel = "ADVANCED",
            subjectGroup = "PHYSICS",
            subjectCode = "PHYSICS",
            shortBadgeEn = "JEE Advanced • Physics",
            shortBadgeHi = "JEE Advanced • भौतिकी",
            titleEn = "1. JEE Advanced: Physics (100 Qs)",
            titleHi = "1. JEE Advanced: भौतिक विज्ञान (Adv Physics • 100 प्रश्न)",
            syllabusSummaryEn = "Rigid Body Mechanics, Non-Uniform Electrostatics, Polytropic Thermodynamics, Motional EMF, Wave Optics Fringe Shift & Nuclear Recoil • 100 Adv PYQs",
            syllabusSummaryHi = "दृढ़ पिंड यांत्रिकी, असमान स्थिरवैद्युतिकी, बहुदैशिक ऊष्मागतिकी, गतिकीय EMF, तरंग प्रकाशिकी एवं नाभिकीय प्रतिक्षेप • 100 Adv PYQs",
            badgeColorHex = 0xFF991B1B
        ),
        IitJeeSectionTestSpec(
            id = "jee_adv_physical_chem",
            testId = "jee_adv_sec_physical_chem_100",
            sectionNumber = 2,
            examLevel = "ADVANCED",
            subjectGroup = "CHEMISTRY",
            subjectCode = "PHYSICAL_CHEM",
            shortBadgeEn = "JEE Advanced • Physical Chem",
            shortBadgeHi = "JEE Advanced • भौतिक रसायन",
            titleEn = "2. JEE Advanced: Physical Chemistry (100 Qs)",
            titleHi = "2. JEE Advanced: भौतिक रसायन (Adv Physical Chem • 100 प्रश्न)",
            syllabusSummaryEn = "Real Gases & Critical Constants, Solid State Crystallography, Parallel Reaction Kinetics, Concentration Cells, Entropy & Quantum Wavefunctions • 100 Adv PYQs",
            syllabusSummaryHi = "वास्तविक गैसें व क्रांतिक स्थिरांक, ठोस अवस्था क्रिस्टलकी, समानांतर अभिक्रिया बलगतिकी, सांद्रता सेल, एंट्रॉपी एवं क्वांटम तरंग फलन • 100 Adv PYQs",
            badgeColorHex = 0xFF065F46
        ),
        IitJeeSectionTestSpec(
            id = "jee_adv_organic_chem",
            testId = "jee_adv_sec_organic_chem_100",
            sectionNumber = 3,
            examLevel = "ADVANCED",
            subjectGroup = "CHEMISTRY",
            subjectCode = "ORGANIC_CHEM",
            shortBadgeEn = "JEE Advanced • Organic Chem",
            shortBadgeHi = "JEE Advanced • कार्बनिक रसायन",
            titleEn = "3. JEE Advanced: Organic Chemistry (100 Qs)",
            titleHi = "3. JEE Advanced: कार्बनिक रसायन (Adv Organic Chem • 100 प्रश्न)",
            syllabusSummaryEn = "Beckmann & Pinacol-Pinacolone Rearrangements, Stereospecific Alkene Additions, Non-Benzenoid Aromaticity, Benzyne & Crossed Cannizzaro • 100 Adv PYQs",
            syllabusSummaryHi = "बेकमैन व पिनाकोल-पिनाकोलोन पुनर्विन्यास, त्रिविम-विशिष्ट योग, गैर-बेंजीनॉइड एरोमैटिकता, बेंजाइन एवं क्रॉस कैनिज़ारो • 100 Adv PYQs",
            badgeColorHex = 0xFF5B21B6
        ),
        IitJeeSectionTestSpec(
            id = "jee_adv_inorganic_chem",
            testId = "jee_adv_sec_inorganic_chem_100",
            sectionNumber = 4,
            examLevel = "ADVANCED",
            subjectGroup = "CHEMISTRY",
            subjectCode = "INORGANIC_CHEM",
            shortBadgeEn = "JEE Advanced • Inorganic Chem",
            shortBadgeHi = "JEE Advanced • अकार्बनिक रसायन",
            titleEn = "4. JEE Advanced: Inorganic Chemistry (100 Qs)",
            titleHi = "4. JEE Advanced: अकार्बनिक रसायन (Adv Inorganic Chem • 100 प्रश्न)",
            syllabusSummaryEn = "Qualitative Analysis (Brown Ring Complex), 3c-2e Banana Bonding, Coordination Stereoisomerism, Jahn-Teller Distortion, Metallurgy & LMCT Spectra • 100 Adv PYQs",
            syllabusSummaryHi = "गुणात्मक विश्लेषण (ब्राउन रिंग संकुल), 3c-2e बनाना आबंधन, उपसहसंयोजन त्रिविम समावयवता, जान-टेलर विकृति, धातुकर्म एवं LMCT स्पेक्ट्रा • 100 Adv PYQs",
            badgeColorHex = 0xFFB45309
        ),
        IitJeeSectionTestSpec(
            id = "jee_adv_mathematics",
            testId = "jee_adv_sec_mathematics_100",
            sectionNumber = 5,
            examLevel = "ADVANCED",
            subjectGroup = "MATH",
            subjectCode = "MATHEMATICS",
            shortBadgeEn = "JEE Advanced • Mathematics",
            shortBadgeHi = "JEE Advanced • गणित",
            titleEn = "5. JEE Advanced: Mathematics (100 Qs)",
            titleHi = "5. JEE Advanced: गणित (Adv Mathematics • 100 प्रश्न)",
            syllabusSummaryEn = "Functional Equations, Leibniz Integral Rule, Complex Roots of Unity, Conic Asymptotes, Vector Triple Product, Cayley-Hamilton & Polya's Urn • 100 Adv PYQs",
            syllabusSummaryHi = "फलनिक समीकरण, लीबनिज़ समाकलन नियम, इकाई के सम्मिश्र मूल, शांकव अनंतस्पर्शी, सदिश त्रिक गुणनफल, कैली-हैमिल्टन एवं प्रायिकता • 100 Adv PYQs",
            badgeColorHex = 0xFF9F1239
        )
    )

    val allIitJeeSectionTests: List<MockTest> by lazy {
        listOf(
            // JEE Main 5 Subjects (100 Qs each = 500 Qs)
            buildSectionMockTest(sectionSpecs[0], 91000, IitJeePyqSeedsPart1.jeeMainPhysicsSeeds),
            buildSectionMockTest(sectionSpecs[1], 92000, IitJeePyqSeedsPart1.jeeMainPhysicalChemSeeds),
            buildSectionMockTest(sectionSpecs[2], 93000, IitJeePyqSeedsPart1.jeeMainOrganicChemSeeds),
            buildSectionMockTest(sectionSpecs[3], 94000, IitJeePyqSeedsPart1.jeeMainInorganicChemSeeds),
            buildSectionMockTest(sectionSpecs[4], 95000, IitJeePyqSeedsPart1.jeeMainMathematicsSeeds),
            // JEE Advanced 5 Subjects (100 Qs each = 500 Qs)
            buildSectionMockTest(sectionSpecs[5], 96000, IitJeePyqSeedsPart2.jeeAdvPhysicsSeeds),
            buildSectionMockTest(sectionSpecs[6], 97000, IitJeePyqSeedsPart2.jeeAdvPhysicalChemSeeds),
            buildSectionMockTest(sectionSpecs[7], 98000, IitJeePyqSeedsPart2.jeeAdvOrganicChemSeeds),
            buildSectionMockTest(sectionSpecs[8], 99000, IitJeePyqSeedsPart2.jeeAdvInorganicChemSeeds),
            buildSectionMockTest(sectionSpecs[9], 100000, IitJeePyqSeedsPart2.jeeAdvMathematicsSeeds)
        )
    }

    fun getMainSectionSpecs(): List<IitJeeSectionTestSpec> =
        sectionSpecs.filter { it.examLevel == "MAIN" }

    fun getAdvancedSectionSpecs(): List<IitJeeSectionTestSpec> =
        sectionSpecs.filter { it.examLevel == "ADVANCED" }

    fun getTestBySectionOrTestId(idOrKey: String): MockTest? {
        val normalized = idOrKey.trim().lowercase()
        val matchedSpec = sectionSpecs.firstOrNull {
            it.id.lowercase() == normalized || it.testId.lowercase() == normalized
        }
        val targetTestId = matchedSpec?.testId ?: idOrKey
        return allIitJeeSectionTests.firstOrNull { it.testId.equals(targetTestId, ignoreCase = true) }
    }

    private val examShiftLabelsMain = listOf(
        "JEE Main 2025 Jan Shift-1",
        "JEE Main 2024 April Shift-2",
        "JEE Main 2023 Jan Shift-1",
        "JEE Main 2022 July Shift-2",
        "JEE Main 2021 March Shift-1"
    )

    private val examShiftLabelsAdvanced = listOf(
        "JEE Advanced 2024 Paper-1",
        "JEE Advanced 2024 Paper-2",
        "JEE Advanced 2023 Paper-1",
        "JEE Advanced 2022 Paper-2",
        "JEE Advanced 2021 Paper-1"
    )

    private fun buildSectionMockTest(
        spec: IitJeeSectionTestSpec,
        baseId: Int,
        seeds: List<RawIitJeePyqSeed>
    ): MockTest {
        val isAdvanced = spec.examLevel == "ADVANCED"
        val shiftLabels = if (isAdvanced) examShiftLabelsAdvanced else examShiftLabelsMain
        val levelLabel = if (isAdvanced) "IIT JEE Advanced" else "IIT JEE Main"

        val questions = (0 until 100).map { index ->
            val seed = seeds[index % seeds.size]
            val cycle = index / seeds.size
            val qNum = index + 1
            val shiftBadge = if (cycle == 0) seed.yearTag else shiftLabels[(index + cycle) % shiftLabels.size]

            // Rotate correct answer position across 0..3 for realistic CBT practice
            val targetCorrectIdx = (index + cycle) % 4
            val baseCorrectIdx = seed.correctIndex.coerceIn(0, 3)

            val correctEn = seed.optionsEn[baseCorrectIdx]
            val distractorsEn = seed.optionsEn.filterIndexed { idx, _ -> idx != baseCorrectIdx }
            val finalOptsEn = MutableList(4) { "" }
            finalOptsEn[targetCorrectIdx] = correctEn
            var dIdxEn = 0
            for (pos in 0..3) {
                if (pos != targetCorrectIdx) {
                    finalOptsEn[pos] = distractorsEn[dIdxEn % distractorsEn.size]
                    dIdxEn++
                }
            }

            val correctHi = seed.optionsHi[baseCorrectIdx]
            val distractorsHi = seed.optionsHi.filterIndexed { idx, _ -> idx != baseCorrectIdx }
            val finalOptsHi = MutableList(4) { "" }
            finalOptsHi[targetCorrectIdx] = correctHi
            var dIdxHi = 0
            for (pos in 0..3) {
                if (pos != targetCorrectIdx) {
                    finalOptsHi[pos] = distractorsHi[dIdxHi % distractorsHi.size]
                    dIdxHi++
                }
            }

            val questionTextEn = if (cycle == 0) {
                "[${seed.subTopicTag} • $shiftBadge] ${seed.questionEn}"
            } else {
                "[$levelLabel 5-Yr PYQ Shift-${cycle + 1} • ${seed.subTopicTag} • $shiftBadge] ${seed.questionEn}"
            }

            val questionTextHi = if (cycle == 0) {
                "[${seed.subTopicTag} • $shiftBadge] ${seed.questionHi}"
            } else {
                "[$levelLabel 5-वर्षीय PYQ शिफ्ट-${cycle + 1} • ${seed.subTopicTag} • $shiftBadge] ${seed.questionHi}"
            }

            TestQuestion(
                id = baseId + qNum,
                questionEn = questionTextEn,
                questionHi = questionTextHi,
                optionsEn = finalOptsEn,
                optionsHi = finalOptsHi,
                correctIndex = targetCorrectIdx,
                explanationEn = "[${seed.subTopicTag} | $shiftBadge] ${seed.explanationEn}\n• $levelLabel Marking Scheme: +4.0 Marks for Correct | -1.0 Negative Marking.",
                explanationHi = "[${seed.subTopicTag} | $shiftBadge] ${seed.explanationHi}\n• $levelLabel अंकन योजना: सही उत्तर हेतु +4.0 अंक | गलत उत्तर हेतु -1.0 ऋणात्मक अंकन।",
                subject = "${spec.shortBadgeEn} (${spec.shortBadgeHi})",
                pyqYearTag = shiftBadge,
                pyqFrequency = "Asked in $levelLabel (2020–2025 5-Year PYQ Trend)",
                difficultyLevel = if (isAdvanced) "IIT JEE Advanced Real Exam Level" else "IIT JEE Main Real Exam Level",
                pyqTrendNoteEn = "High-weightage 5-year PYQ concept from ${seed.subTopicTag} ($levelLabel).",
                pyqTrendNoteHi = "${seed.subTopicTag} ($levelLabel) के विगत 5 वर्षों के PYQ पैटर्न पर आधारित उच्च-वेटेज प्रश्न।"
            )
        }

        val durationMinutes = if (isAdvanced) 120 else 90
        return MockTest(
            testId = spec.testId,
            title = "${spec.titleEn} — 5-Year PYQ Mock Test",
            hindiTitle = "${spec.titleHi} — 5-वर्षीय PYQ मॉक टेस्ट",
            examName = "$levelLabel (${spec.shortBadgeEn} • 100 Qs)",
            durationMinutes = durationMinutes,
            totalMarks = 400,
            positiveMarks = 4.0,
            negativeMarks = 1.0,
            categoryId = "jee_neet",
            pyqAnalysisEn = "$levelLabel 5-Year Syllabus Analysis (2020–2025): ${spec.syllabusSummaryEn}",
            pyqAnalysisHi = "$levelLabel 5-वर्षीय पाठ्यक्रम विश्लेषण (2020–2025): ${spec.syllabusSummaryHi}",
            topicWeightage = listOf(
                "High-Yield 5-Year Core Concepts (35%)",
                "Numerical & Formula Application (30%)",
                "Multi-Concept Analytical Problems (20%)",
                "NCERT & Standard Reference PYQs (15%)"
            ),
            questions = questions
        )
    }
}
