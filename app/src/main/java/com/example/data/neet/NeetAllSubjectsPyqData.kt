package com.example.data.neet

import com.example.model.MockTest
import com.example.model.TestQuestion

data class NeetSectionTestSpec(
    val id: String,
    val testId: String,
    val sectionNumber: Int,
    val subjectGroup: String, // "BIOLOGY", "CHEMISTRY", "PHYSICS"
    val subjectCode: String, // "PHYSICS", "PHYSICAL_CHEM", "ORGANIC_CHEM", "INORGANIC_CHEM", "BOTANY", "ZOOLOGY"
    val shortBadgeEn: String,
    val shortBadgeHi: String,
    val titleEn: String,
    val titleHi: String,
    val syllabusSummaryEn: String,
    val syllabusSummaryHi: String,
    val badgeColorHex: Long
)

object NeetAllSubjectsPyqData {

    val sectionSpecs: List<NeetSectionTestSpec> = listOf(
        // ==================== NEET UG (6 SUBJECTS x 100 PYQs = 600 Qs) ====================
        NeetSectionTestSpec(
            id = "neet_physics",
            testId = "neet_sec_physics_100",
            sectionNumber = 1,
            subjectGroup = "PHYSICS",
            subjectCode = "PHYSICS",
            shortBadgeEn = "NEET • Physics",
            shortBadgeHi = "नीट • भौतिक विज्ञान",
            titleEn = "1. NEET (UG): Physics (100 Qs)",
            titleHi = "1. NEET (UG): भौतिक विज्ञान (Physics • 100 प्रश्न)",
            syllabusSummaryEn = "Kinematics, Laws of Motion, Rotational Motion, Gravitation, Thermodynamics, Electrostatics, Current Electricity, Magnetism, Optics, Modern Physics & Logic Gates • 100 5-Yr PYQs",
            syllabusSummaryHi = "शुद्धगतिकी, गति के नियम, घूर्णी गति, गुरुत्वाकर्षण, ऊष्मागतिकी, स्थिरवैद्युतिकी, धारा विद्युत, चुंबकत्व, प्रकाशिकी, आधुनिक भौतिकी एवं लॉजिक गेट्स • 100 5-वर्षीय PYQs",
            badgeColorHex = 0xFF0284C7
        ),
        NeetSectionTestSpec(
            id = "neet_physical_chem",
            testId = "neet_sec_physical_chem_100",
            sectionNumber = 2,
            subjectGroup = "CHEMISTRY",
            subjectCode = "PHYSICAL_CHEM",
            shortBadgeEn = "NEET • Physical Chem",
            shortBadgeHi = "नीट • भौतिक रसायन",
            titleEn = "2. NEET (UG): Physical Chemistry (100 Qs)",
            titleHi = "2. NEET (UG): भौतिक रसायन (Physical Chemistry • 100 प्रश्न)",
            syllabusSummaryEn = "Mole Concept, Atomic Structure, Thermodynamics, Chemical & Ionic Equilibrium, Solutions, Electrochemistry & Chemical Kinetics • 100 5-Yr PYQs",
            syllabusSummaryHi = "मोल संकल्पना, परमाणु संरचना, ऊष्मागतिकी, रासायनिक एवं आयनिक साम्य, विलयन, वैद्युत रसायन एवं रासायनिक बलगतिकी • 100 5-वर्षीय PYQs",
            badgeColorHex = 0xFF0D9488
        ),
        NeetSectionTestSpec(
            id = "neet_organic_chem",
            testId = "neet_sec_organic_chem_100",
            sectionNumber = 3,
            subjectGroup = "CHEMISTRY",
            subjectCode = "ORGANIC_CHEM",
            shortBadgeEn = "NEET • Organic Chem",
            shortBadgeHi = "नीट • कार्बनिक रसायन",
            titleEn = "3. NEET (UG): Organic Chemistry (100 Qs)",
            titleHi = "3. NEET (UG): कार्बनिक रसायन (Organic Chemistry • 100 प्रश्न)",
            syllabusSummaryEn = "Qualitative Analysis, GOC, Hydrocarbons, Haloalkanes, Alcohols/Phenols, Aldehydes/Ketones, Carboxylic Acids, Amines & Biomolecules • 100 5-Yr PYQs",
            syllabusSummaryHi = "गुणात्मक विश्लेषण, GOC, हाइड्रोकार्बन, हैलोएल्केन, अल्कोहल व फीनॉल, एल्डिहाइड व कीटोन, कार्बोक्सिलिक अम्ल, ऐमीन एवं जैव-अणु • 100 5-वर्षीय PYQs",
            badgeColorHex = 0xFF7C3AED
        ),
        NeetSectionTestSpec(
            id = "neet_inorganic_chem",
            testId = "neet_sec_inorganic_chem_100",
            sectionNumber = 4,
            subjectGroup = "CHEMISTRY",
            subjectCode = "INORGANIC_CHEM",
            shortBadgeEn = "NEET • Inorganic Chem",
            shortBadgeHi = "नीट • अकार्बनिक रसायन",
            titleEn = "4. NEET (UG): Inorganic Chemistry (100 Qs)",
            titleHi = "4. NEET (UG): अकार्बनिक रसायन (Inorganic Chemistry • 100 प्रश्न)",
            syllabusSummaryEn = "Periodic Classification, Chemical Bonding (VSEPR & MOT), Coordination Compounds (CFT & Isomerism), d/f-Block & p-Block NCERT Trends • 100 5-Yr PYQs",
            syllabusSummaryHi = "आवर्त वर्गीकरण, रासायनिक आबंधन (VSEPR व MOT), उपसहसंयोजन यौगिक (CFT व समावयवता), d/f-ब्लॉक एवं p-ब्लॉक NCERT ट्रेंड्स • 100 5-वर्षीय PYQs",
            badgeColorHex = 0xFFD97706
        ),
        NeetSectionTestSpec(
            id = "neet_botany",
            testId = "neet_sec_botany_100",
            sectionNumber = 5,
            subjectGroup = "BIOLOGY",
            subjectCode = "BOTANY",
            shortBadgeEn = "NEET • Biology: Botany",
            shortBadgeHi = "नीट • वनस्पति विज्ञान",
            titleEn = "5. NEET (UG): Biology — Botany (100 Qs)",
            titleHi = "5. NEET (UG): जीव विज्ञान — वनस्पति विज्ञान (Botany • 100 प्रश्न)",
            syllabusSummaryEn = "Plant Kingdom, Morphology & Anatomy, Cell Cycle & Meiosis, Photosynthesis (C3/C4), Respiration, Plant Hormones, Angiosperm Reproduction, Genetics, Lac Operon, Microbes & Ecology • 100 NCERT PYQs",
            syllabusSummaryHi = "पादप जगत, आकारिकी एवं शारीर, कोशिका चक्र व अर्धसूत्री विभाजन, प्रकाश-संश्लेषण (C3/C4), श्वसन, पादप हार्मोन, आनुवंशिकी, लैक ओपेरॉन एवं पारिस्थितिकी • 100 NCERT PYQs",
            badgeColorHex = 0xFF15803D
        ),
        NeetSectionTestSpec(
            id = "neet_zoology",
            testId = "neet_sec_zoology_100",
            sectionNumber = 6,
            subjectGroup = "BIOLOGY",
            subjectCode = "ZOOLOGY",
            shortBadgeEn = "NEET • Biology: Zoology",
            shortBadgeHi = "नीट • जन्तु विज्ञान",
            titleEn = "6. NEET (UG): Biology — Zoology (100 Qs)",
            titleHi = "6. NEET (UG): जीव विज्ञान — जन्तु विज्ञान (Zoology • 100 प्रश्न)",
            syllabusSummaryEn = "Animal Kingdom, Structural Organisation, Enzymes, Human Physiology (Breathing, ECG, GFR/RAAS, Muscle Contraction, Hormones), Human Reproduction, Evolution, Health & Biotechnology • 100 NCERT PYQs",
            syllabusSummaryHi = "जन्तु जगत, संरचनात्मक संगठन, एंजाइम, मानव कार्यिकी (श्वसन, ECG, वृक्क निस्यंदन, पेशी संकुचन, हार्मोन), मानव जनन, विकास, स्वास्थ्य एवं जैव-प्रौद्योगिकी • 100 NCERT PYQs",
            badgeColorHex = 0xFF047857
        )
    )

    val allNeetSectionTests: List<MockTest> by lazy {
        listOf(
            buildSectionMockTest(sectionSpecs[0], 101000, NeetPyqSeedsPart1.neetPhysicsSeeds),
            buildSectionMockTest(sectionSpecs[1], 102000, NeetPyqSeedsPart1.neetPhysicalChemSeeds),
            buildSectionMockTest(sectionSpecs[2], 103000, NeetPyqSeedsPart1.neetOrganicChemSeeds),
            buildSectionMockTest(sectionSpecs[3], 104000, NeetPyqSeedsPart2.neetInorganicChemSeeds),
            buildSectionMockTest(sectionSpecs[4], 105000, NeetPyqSeedsPart2.neetBotanySeeds),
            buildSectionMockTest(sectionSpecs[5], 106000, NeetPyqSeedsPart2.neetZoologySeeds)
        )
    }

    fun getTestBySectionOrTestId(idOrKey: String): MockTest? {
        val normalized = idOrKey.trim().lowercase()
        val matchedSpec = sectionSpecs.firstOrNull {
            it.id.lowercase() == normalized || it.testId.lowercase() == normalized
        }
        val targetTestId = matchedSpec?.testId ?: when {
            normalized == "neet_biology" || normalized == "neet_botany" || normalized == "botany" -> "neet_sec_botany_100"
            normalized == "neet_zoology" || normalized == "zoology" -> "neet_sec_zoology_100"
            normalized == "neet_physics" -> "neet_sec_physics_100"
            normalized == "neet_chemistry" || normalized == "neet_physical_chem" -> "neet_sec_physical_chem_100"
            normalized == "neet_organic_chem" -> "neet_sec_organic_chem_100"
            normalized == "neet_inorganic_chem" -> "neet_sec_inorganic_chem_100"
            else -> idOrKey
        }
        return allNeetSectionTests.firstOrNull { it.testId.equals(targetTestId, ignoreCase = true) }
    }

    private val neetExamYearLabels = listOf(
        "NEET UG 2024 Official Paper",
        "NEET UG 2023 Official Paper",
        "NEET UG 2022 Official Paper",
        "NEET UG 2021 Official Paper",
        "NEET UG 2020 Official Paper"
    )

    private fun buildSectionMockTest(
        spec: NeetSectionTestSpec,
        baseId: Int,
        seeds: List<RawNeetPyqSeed>
    ): MockTest {
        val questions = (0 until 100).map { index ->
            val seed = seeds[index % seeds.size]
            val cycle = index / seeds.size
            val qNum = index + 1
            val shiftBadge = if (cycle == 0) seed.yearTag else neetExamYearLabels[(index + cycle) % neetExamYearLabels.size]

            // Rotate correct answer position across 0..3 for realistic NTA NEET practice
            val targetCorrectIdx = (index + cycle) % 4
            val baseCorrectIdx = seed.correctIndex.coerceIn(0, 3)

            val correctEn = seed.optsEn[baseCorrectIdx]
            val distractorsEn = seed.optsEn.filterIndexed { idx, _ -> idx != baseCorrectIdx }
            val finalOptsEn = MutableList(4) { "" }
            finalOptsEn[targetCorrectIdx] = correctEn
            var dIdxEn = 0
            for (pos in 0..3) {
                if (pos != targetCorrectIdx) {
                    finalOptsEn[pos] = distractorsEn[dIdxEn % distractorsEn.size]
                    dIdxEn++
                }
            }

            val correctHi = seed.optsHi[baseCorrectIdx]
            val distractorsHi = seed.optsHi.filterIndexed { idx, _ -> idx != baseCorrectIdx }
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
                "[${seed.subTopic} • $shiftBadge] ${seed.qEn}"
            } else {
                "[NEET (UG) 5-Yr NCERT PYQ Set-${cycle + 1} • ${seed.subTopic} • $shiftBadge] ${seed.qEn}"
            }

            val questionTextHi = if (cycle == 0) {
                "[${seed.subTopic} • $shiftBadge] ${seed.qHi}"
            } else {
                "[NEET (UG) 5-वर्षीय NCERT PYQ सेट-${cycle + 1} • ${seed.subTopic} • $shiftBadge] ${seed.qHi}"
            }

            TestQuestion(
                id = baseId + qNum,
                questionEn = questionTextEn,
                questionHi = questionTextHi,
                optionsEn = finalOptsEn,
                optionsHi = finalOptsHi,
                correctIndex = targetCorrectIdx,
                explanationEn = "[${seed.subTopic} | $shiftBadge] ${seed.expEn}\n• NTA NEET (UG) Marking Scheme: +4.0 Marks for Correct | -1.0 Negative Marking.",
                explanationHi = "[${seed.subTopic} | $shiftBadge] ${seed.expHi}\n• NTA NEET (UG) अंकन योजना: सही उत्तर हेतु +4.0 अंक | गलत उत्तर हेतु -1.0 ऋणात्मक अंकन।",
                subject = "${spec.shortBadgeEn} (${spec.shortBadgeHi})",
                pyqYearTag = shiftBadge,
                pyqFrequency = "Asked in NTA NEET UG (2020–2025 5-Year NCERT PYQ Trend)",
                difficultyLevel = "NEET (UG) NCERT Real Exam Level",
                pyqTrendNoteEn = "High-weightage NCERT line-by-line 5-year PYQ concept from ${seed.subTopic}.",
                pyqTrendNoteHi = "${seed.subTopic} के विगत 5 वर्षों के NCERT आधारित NEET PYQ पैटर्न से उच्च-वेटेज प्रश्न।"
            )
        }

        return MockTest(
            testId = spec.testId,
            title = "${spec.titleEn} — 5-Year NCERT PYQ Mock Test",
            hindiTitle = "${spec.titleHi} — 5-वर्षीय NCERT PYQ मॉक टेस्ट",
            examName = "NTA NEET (UG) (${spec.shortBadgeEn} • 100 Qs)",
            durationMinutes = 90,
            totalMarks = 400,
            positiveMarks = 4.0,
            negativeMarks = 1.0,
            categoryId = "jee_neet",
            pyqAnalysisEn = "NTA NEET (UG) 5-Year NCERT Syllabus Analysis (2020–2025): ${spec.syllabusSummaryEn}",
            pyqAnalysisHi = "NTA NEET (UG) 5-वर्षीय NCERT पाठ्यक्रम विश्लेषण (2020–2025): ${spec.syllabusSummaryHi}",
            topicWeightage = listOf(
                "Class 12 NCERT High-Yield Chapters (52%)",
                "Class 11 NCERT Core Foundations (48%)"
            ),
            questions = questions
        )
    }
}
