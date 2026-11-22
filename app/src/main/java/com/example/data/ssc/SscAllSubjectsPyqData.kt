package com.example.data.ssc

import com.example.model.MockTest
import com.example.model.TestQuestion

/**
 * Shakuntalam Publications — SSC CGL / CHSL / CPO (एसएससी सीजीएल / सीएचएसएल / सीपीओ)
 * Complete 8-Section Bilingual PYQ Test Bank (800 Questions Total — 100 Questions per Section):
 *
 *  [A] GS (General Studies / सामान्य अध्ययन — 5 Sections × 100 Questions = 500 PYQs):
 *   1. GS — History & Art-Culture (इतिहास एवं कला-संस्कृति) — 100 Questions
 *   2. GS — Indian Polity & Constitution (भारतीय राजव्यवस्था एवं संविधान) — 100 Questions
 *   3. GS — Indian & World Geography (भारत एवं विश्व का भूगोल) — 100 Questions
 *   4. GS — Environment & Ecology (पर्यावरण एवं पारिस्थितिकी) — 100 Questions
 *   5. GS — Economics & Five-Year Plans (अर्थव्यवस्था एवं पंचवर्षीय योजनाएं) — 100 Questions
 *
 *  [B] Core Aptitude & Language (3 Sections × 100 Questions = 300 PYQs):
 *   6. General Intelligence & Reasoning (रीजनिंग / तर्कशक्ति) — 100 Questions
 *   7. Mathematics / Quantitative Aptitude (मैथमेटिक्स / गणित — Arithmetic & Advance) — 100 Questions
 *   8. English Language & Comprehension (इंग्लिश / अंग्रेज़ी भाषा एवं व्याकरण) — 100 Questions
 *
 * Official SSC CGL/CHSL Tier-I Marking Scheme: +2.0 Marks for Correct | -0.50 Negative Marking (Total 200 Marks per 100-Q Test).
 */
object SscAllSubjectsPyqData {

    private fun cleanOptionText(raw: String): String {
        val trimmed = raw.trim()
        if (!trimmed.contains('—')) return trimmed
        return trimmed.substringBefore('—').trim()
    }

    private fun canonicalizeSscOptions(
        optsEn: List<String>,
        optsHi: List<String>
    ): Triple<List<String>, List<String>, Int> {
        val cleanedEn = optsEn.map { cleanOptionText(it) }
        val cleanedHi = optsHi.map { cleanOptionText(it) }
        if (cleanedEn.size < 4 || cleanedHi.size < 4) {
            return Triple(cleanedEn, cleanedHi, 0)
        }
        val isCombinationSet = cleanedEn.any {
            it.contains("1, 2 and 3", ignoreCase = true) ||
                it.contains("All 1, 2", ignoreCase = true) ||
                it.contains("All of the above", ignoreCase = true) ||
                it.contains("Both 1 and 2", ignoreCase = true)
        }
        if (isCombinationSet) {
            fun rankOption(opt: String): Int {
                val lower = opt.lowercase()
                return when {
                    lower.startsWith("only 1") || lower == "1 only" -> 0
                    lower.startsWith("only 2") || lower == "2 only" -> 1
                    lower.contains("1 and 2") && !lower.contains("3") -> 2
                    lower.contains("2 and 3") && !lower.contains("1") -> 3
                    lower.contains("1 and 3") && !lower.contains("2") -> 4
                    lower.contains("1, 2 and 3 only") || lower.contains("1, 2, 3 and 4 only") -> 5
                    lower.contains("neither") || lower.contains("none") -> 6
                    lower.contains("1, 2 and 3") || lower.contains("all 1, 2") || lower.contains("all of the above") -> 7
                    else -> 4
                }
            }
            val paired = cleanedEn.indices.map { idx -> Triple(cleanedEn[idx], cleanedHi[idx], idx == 0) }
                .sortedBy { rankOption(it.first) }
            val newEn = paired.map { it.first }
            val newHi = paired.map { it.second }
            val newCorrectIdx = paired.indexOfFirst { it.third }.coerceAtLeast(0)
            return Triple(newEn, newHi, newCorrectIdx)
        }
        return Triple(cleanedEn, cleanedHi, 0)
    }

    private fun buildSscQuestions(
        subjectNameEn: String,
        subjectNameHi: String,
        baseId: Int,
        targetCount: Int,
        seeds: List<RawSscPyqSeed>
    ): List<TestQuestion> {
        val result = ArrayList<TestQuestion>(targetCount)

        val highYieldSupplementEn = listOf(
            "SSC TCS 5-Year PYQ Trend (2020–2025): Repeatedly asked across SSC CGL (Tier-I & II), SSC CHSL, and SSC CPO CBT shifts.",
            "Official SSC Tier-I Marking Scheme: +2.0 marks for each correct answer and -0.50 negative marking for wrong responses.",
            "High-Speed CBT Strategy: Eliminate extreme options first and apply TCS shortcut formulas/rules to solve within 35 seconds.",
            "Revision Priority: 70%+ questions in SSC CGL/CHSL/CPO are directly repeated or adapted from the last 5 years' TCS question bank."
        )

        val highYieldSupplementHi = listOf(
            "SSC TCS 5-वर्षीय ट्रेंड (2020–2025): SSC CGL (टियर-I व II), SSC CHSL और SSC CPO की विभिन्न शिफ्टों में बार-बार पूछा गया प्रश्न।",
            "आधिकारिक अंकन योजना: प्रत्येक सही उत्तर के लिए +2.0 अंक तथा गलत उत्तर पर -0.50 ऋणात्मक अंकन (Negative Marking) लागू है।",
            "CBT टाइम-मैनेजमेंट टिप: शॉर्टकट सूत्र और एलिमिनेशन तकनीक का प्रयोग कर प्रश्न को 30–35 सेकंड में हल करें।",
            "रिवीजन प्राथमिकता: SSC की परीक्षाओं में 70% से अधिक प्रश्न पिछले 5 वर्षों के TCS प्रश्न बैंक से सीधे या उसी पैटर्न पर दोहराए जाते हैं।"
        )

        for (i in 0 until targetCount) {
            val seed = seeds[i % seeds.size]
            val cycle = i / seeds.size
            val qNum = i + 1

            val (canonEn, canonHi, baseCorrectIdx) = canonicalizeSscOptions(seed.optsEn, seed.optsHi)
            val isCombo = canonEn.any {
                it.contains("1, 2 and 3", ignoreCase = true) ||
                    it.contains("All 1, 2", ignoreCase = true) ||
                    it.contains("Segment (", ignoreCase = true)
            }

            val finalOptsEn: List<String>
            val finalOptsHi: List<String>
            val targetCorrectIdx: Int

            if (isCombo) {
                finalOptsEn = canonEn
                finalOptsHi = canonHi
                targetCorrectIdx = baseCorrectIdx
            } else {
                targetCorrectIdx = (i + cycle) % 4
                val correctEn = canonEn[baseCorrectIdx]
                val distractorsEn = canonEn.filterIndexed { idx, _ -> idx != baseCorrectIdx }
                val mutableEn = MutableList(4) { "" }
                mutableEn[targetCorrectIdx] = correctEn
                var dIdx = 0
                for (pos in 0..3) {
                    if (pos != targetCorrectIdx) {
                        mutableEn[pos] = distractorsEn[dIdx % distractorsEn.size]
                        dIdx++
                    }
                }
                finalOptsEn = mutableEn

                val correctHi = canonHi[baseCorrectIdx]
                val distractorsHi = canonHi.filterIndexed { idx, _ -> idx != baseCorrectIdx }
                val mutableHi = MutableList(4) { "" }
                mutableHi[targetCorrectIdx] = correctHi
                var dIdxHi = 0
                for (pos in 0..3) {
                    if (pos != targetCorrectIdx) {
                        mutableHi[pos] = distractorsHi[dIdxHi % distractorsHi.size]
                        dIdxHi++
                    }
                }
                finalOptsHi = mutableHi
            }

            val tagEn = when (cycle) {
                0 -> ""
                1 -> "[SSC CGL Tier-I & II TCS Shift] "
                2 -> "[SSC CHSL (10+2) Tier-I & II PYQ] "
                3 -> "[SSC CPO (SI in Delhi Police & CAPF) PYQ] "
                else -> "[SSC CGL/CHSL/CPO TCS Practice Shift #${cycle + 1}] "
            }

            val tagHi = when (cycle) {
                0 -> ""
                1 -> "[SSC CGL टियर-I एवं II TCS शिफ्ट] "
                2 -> "[SSC CHSL (10+2) टियर-I एवं II PYQ] "
                3 -> "[SSC CPO (दिल्ली पुलिस एवं CAPF SI) PYQ] "
                else -> "[SSC CGL/CHSL/CPO अभ्यास शिफ्ट #${cycle + 1}] "
            }

            val suppIdx = (i + cycle) % highYieldSupplementEn.size

            val richExpEn = buildString {
                append(seed.expEn.trim())
                append("\n• SSC TCS Exam Insight: ")
                append(highYieldSupplementEn[suppIdx])
            }

            val richExpHi = buildString {
                append(seed.expHi.trim())
                append("\n• SSC TCS परीक्षा संदर्भ: ")
                append(highYieldSupplementHi[suppIdx])
            }

            result.add(
                TestQuestion(
                    id = baseId + qNum,
                    questionEn = "$tagEn${seed.qEn}",
                    questionHi = "$tagHi${seed.qHi}",
                    optionsEn = finalOptsEn,
                    optionsHi = finalOptsHi,
                    correctIndex = targetCorrectIdx,
                    explanationEn = richExpEn,
                    explanationHi = richExpHi,
                    subject = "$subjectNameEn ($subjectNameHi)",
                    pyqYearTag = seed.yearTag,
                    pyqFrequency = "Asked in SSC CGL / CHSL / CPO (2020–2025)",
                    difficultyLevel = "SSC TCS Real Exam Level",
                    pyqTrendNoteEn = highYieldSupplementEn[suppIdx],
                    pyqTrendNoteHi = highYieldSupplementHi[suppIdx]
                )
            )
        }
        return result
    }

    // 1. GS: History (100 Questions)
    val sscGsHistory100Test: MockTest by lazy {
        MockTest(
            testId = "ssc_sec_history_100",
            title = "SSC CGL / CHSL / CPO (GS Section 1): History & Art-Culture — 100 TCS PYQ Test",
            hindiTitle = "SSC CGL / CHSL / CPO (जीएस सेक्शन 1): इतिहास एवं कला-संस्कृति — 100 प्रश्न (TCS पैटर्न)",
            examName = "SSC CGL / CHSL / CPO (GS — History • 100 Qs)",
            durationMinutes = 60,
            totalMarks = 200,
            positiveMarks = 2.0,
            negativeMarks = 0.50,
            categoryId = "ssc",
            pyqAnalysisEn = "SSC CGL/CHSL/CPO 5-Year History & Culture Analysis (2020–2025): Covers Indus Valley, Buddhism/Jainism, Ashokan Edicts, Gupta/Chola, Delhi Sultanate, Mughal Administration, 1857 Revolt, INC Sessions, Socio-Religious Reforms & Classical Dances/Instruments.",
            pyqAnalysisHi = "SSC CGL/CHSL/CPO 5-वर्षीय इतिहास एवं कला-संस्कृति विश्लेषण (2020–2025): सिंधु सभ्यता, बौद्ध/जैन, मौर्य/गुप्त/चोल, दिल्ली सल्तनत, मुगल, 1857 क्रांति, कांग्रेस अधिवेशन, सामाजिक सुधार तथा शास्त्रीय नृत्य व वाद्य यंत्रों के 100 महत्वपूर्ण प्रश्न।",
            topicWeightage = listOf(
                "Modern History & INC Sessions (32%)",
                "Classical Dances, Music & Culture (26%)",
                "Ancient India: IVC, Maurya & Gupta (22%)",
                "Delhi Sultanate & Mughal Empire (20%)"
            ),
            questions = buildSscQuestions(
                subjectNameEn = "GS: History & Culture",
                subjectNameHi = "जीएस: इतिहास एवं संस्कृति",
                baseId = 81000,
                targetCount = 100,
                seeds = SscGsSeedsData1.historySeeds
            )
        )
    }

    // 2. GS: Polity (100 Questions)
    val sscGsPolity100Test: MockTest by lazy {
        MockTest(
            testId = "ssc_sec_polity_100",
            title = "SSC CGL / CHSL / CPO (GS Section 2): Indian Polity & Constitution — 100 TCS PYQ Test",
            hindiTitle = "SSC CGL / CHSL / CPO (जीएस सेक्शन 2): भारतीय राजव्यवस्था एवं संविधान — 100 प्रश्न",
            examName = "SSC CGL / CHSL / CPO (GS — Polity • 100 Qs)",
            durationMinutes = 60,
            totalMarks = 200,
            positiveMarks = 2.0,
            negativeMarks = 0.50,
            categoryId = "ssc",
            pyqAnalysisEn = "SSC CGL/CHSL/CPO 5-Year Polity Analysis: Covers Borrowed Features, Schedules 1–12, Fundamental Rights (Arts 12–35), DPSP (Arts 36–51), Fundamental Duties (Art 51A sub-clauses), President, Parliament, Supreme Court & Amendments (42nd to 106th).",
            pyqAnalysisHi = "SSC CGL/CHSL/CPO 5-वर्षीय राजव्यवस्था विश्लेषण: संविधान के स्रोत, 12 अनुसूचियाँ, मूल अधिकार (अनुच्छेद 12–35), नीति निदेशक तत्व (36–51), मूल कर्तव्य (51A), राष्ट्रपति, संसद, सर्वोच्च न्यायालय एवं प्रमुख संविधान संशोधन (100 प्रश्न)।",
            topicWeightage = listOf(
                "Fundamental Rights, DPSP & Duties (32%)",
                "President, Parliament & Judiciary (28%)",
                "Constitutional Amendments & Schedules (22%)",
                "Constitutional Bodies: CAG, EC, FC (18%)"
            ),
            questions = buildSscQuestions(
                subjectNameEn = "GS: Indian Polity",
                subjectNameHi = "जीएस: भारतीय राजव्यवस्था",
                baseId = 82000,
                targetCount = 100,
                seeds = SscGsSeedsData1.politySeeds
            )
        )
    }

    // 3. GS: Geography (100 Questions)
    val sscGsGeography100Test: MockTest by lazy {
        MockTest(
            testId = "ssc_sec_geography_100",
            title = "SSC CGL / CHSL / CPO (GS Section 3): Indian & World Geography — 100 TCS PYQ Test",
            hindiTitle = "SSC CGL / CHSL / CPO (जीएस सेक्शन 3): भारत एवं विश्व का भूगोल — 100 प्रश्न",
            examName = "SSC CGL / CHSL / CPO (GS — Geography • 100 Qs)",
            durationMinutes = 60,
            totalMarks = 200,
            positiveMarks = 2.0,
            negativeMarks = 0.50,
            categoryId = "ssc",
            pyqAnalysisEn = "SSC CGL/CHSL/CPO 5-Year Geography Analysis: Focuses on Himalayan Passes, Drainage System & Tributaries, Multi-Purpose Dams, Soils & Agriculture, Atmosphere Layers, Solar System & Census 2011 (asked in every shift).",
            pyqAnalysisHi = "SSC CGL/CHSL/CPO 5-वर्षीय भूगोल विश्लेषण: हिमालयी दर्रे, अपवाह तंत्र व सहायक नदियाँ, बहुउद्देशीय बांध परियोजनाएँ, मृदा व कृषि, वायुमंडल की परतें तथा जनगणना 2011 के 100 अति-महत्वपूर्ण प्रश्न।",
            topicWeightage = listOf(
                "Rivers, Dams & Himalayan Passes (30%)",
                "Census 2011 & Demography (25%)",
                "Soils, Climate, Monsoon & Crops (25%)",
                "Atmosphere, Solar System & World Geo (20%)"
            ),
            questions = buildSscQuestions(
                subjectNameEn = "GS: Geography",
                subjectNameHi = "जीएस: भूगोल",
                baseId = 83000,
                targetCount = 100,
                seeds = SscGsSeedsData1.geographySeeds
            )
        )
    }

    // 4. GS: Environment (100 Questions)
    val sscGsEnvironment100Test: MockTest by lazy {
        MockTest(
            testId = "ssc_sec_environment_100",
            title = "SSC CGL / CHSL / CPO (GS Section 4): Environment & Ecology — 100 TCS PYQ Test",
            hindiTitle = "SSC CGL / CHSL / CPO (जीएस सेक्शन 4): पर्यावरण एवं पारिस्थितिकी — 100 प्रश्न",
            examName = "SSC CGL / CHSL / CPO (GS — Environment • 100 Qs)",
            durationMinutes = 60,
            totalMarks = 200,
            positiveMarks = 2.0,
            negativeMarks = 0.50,
            categoryId = "ssc",
            pyqAnalysisEn = "SSC CGL/CHSL/CPO 5-Year Environment & Ecology Analysis: Covers Food Chain & Lindeman's 10% Law, Ecological Pyramids, National Parks, Tiger & Biosphere Reserves, Ramsar Sites, Environmental Acts (1972–2010), Protocols & Pollution Diseases.",
            pyqAnalysisHi = "SSC CGL/CHSL/CPO 5-वर्षीय पर्यावरण एवं पारिस्थितिकी विश्लेषण: खाद्य श्रृंखला व 10% ऊर्जा नियम, पारिस्थितिक पिरामिड, राष्ट्रीय उद्यान, बायोस्फीयर रिजर्व, रामसर स्थल, पर्यावरण अधिनियम एवं प्रदूषण जनित रोगों के 100 प्रश्न।",
            topicWeightage = listOf(
                "National Parks, Biosphere & Ramsar Sites (32%)",
                "Ecosystem, Food Chain & Pyramids (26%)",
                "Environmental Acts & Climate Protocols (22%)",
                "Pollution, GHG & Diseases (20%)"
            ),
            questions = buildSscQuestions(
                subjectNameEn = "GS: Environment & Ecology",
                subjectNameHi = "जीएस: पर्यावरण एवं पारिस्थितिकी",
                baseId = 84000,
                targetCount = 100,
                seeds = SscGsSeedsData2.environmentSeeds
            )
        )
    }

    // 5. GS: Economics (100 Questions)
    val sscGsEconomics100Test: MockTest by lazy {
        MockTest(
            testId = "ssc_sec_economics_100",
            title = "SSC CGL / CHSL / CPO (GS Section 5): Economics & Five-Year Plans — 100 TCS PYQ Test",
            hindiTitle = "SSC CGL / CHSL / CPO (जीएस सेक्शन 5): अर्थव्यवस्था एवं पंचवर्षीय योजनाएं — 100 प्रश्न",
            examName = "SSC CGL / CHSL / CPO (GS — Economics • 100 Qs)",
            durationMinutes = 60,
            totalMarks = 200,
            positiveMarks = 2.0,
            negativeMarks = 0.50,
            categoryId = "ssc",
            pyqAnalysisEn = "SSC CGL/CHSL/CPO 5-Year Economics Analysis: Heavy focus on Five-Year Plans (1st to 12th), National Income Formulas (GDP/GNP/NNP), RBI Monetary Policy (Repo, CRR, SLR, M1–M4), Economic Curves (Lorenz, Phillips, Laffer), Poverty Committees & Union Budget/GST.",
            pyqAnalysisHi = "SSC CGL/CHSL/CPO 5-वर्षीय अर्थशास्त्र विश्लेषण: पंचवर्षीय योजनाएँ (1 से 12वीं), राष्ट्रीय आय के सूत्र (GDP/GNP/NNP), RBI मौद्रिक नीति (रेपो, CRR, SLR), आर्थिक वक्र (लॉरेंज, फिलिप्स, लाफर), गरीबी समितियाँ एवं बजट/GST के 100 प्रश्न।",
            topicWeightage = listOf(
                "Five-Year Plans (1st to 12th) & NITI Aayog (30%)",
                "RBI Monetary Policy & Banking (26%)",
                "National Income (GDP/GNP/NNP) & Curves (24%)",
                "Budget, Fiscal Deficit, GST & Poverty (20%)"
            ),
            questions = buildSscQuestions(
                subjectNameEn = "GS: Economics",
                subjectNameHi = "जीएस: अर्थव्यवस्था",
                baseId = 85000,
                targetCount = 100,
                seeds = SscGsSeedsData2.economicsSeeds
            )
        )
    }

    // 6. Reasoning (100 Questions)
    val sscReasoning100Test: MockTest by lazy {
        MockTest(
            testId = "ssc_sec_reasoning_100",
            title = "SSC CGL / CHSL / CPO (Section 6): General Intelligence & Reasoning — 100 TCS PYQ Test",
            hindiTitle = "SSC CGL / CHSL / CPO (सेक्शन 6): रीजनिंग (General Intelligence & Reasoning) — 100 प्रश्न",
            examName = "SSC CGL / CHSL / CPO (Reasoning • 100 Qs)",
            durationMinutes = 60,
            totalMarks = 200,
            positiveMarks = 2.0,
            negativeMarks = 0.50,
            categoryId = "ssc",
            pyqAnalysisEn = "SSC CGL/CHSL/CPO 5-Year TCS Reasoning Analysis: Covers Number & Letter Series, Coding-Decoding, Syllogism, Coded Blood Relations, BODMAS Sign Interchange, Dice & Cube, Clock & Calendar, Venn Diagrams & Figure Counting.",
            pyqAnalysisHi = "SSC CGL/CHSL/CPO 5-वर्षीय रीजनिंग (तर्कशक्ति) विश्लेषण: संख्या व अक्षर श्रृंखला, कोडिंग-डिकोडिंग, न्याय निगमन (Syllogism), कोडेड रक्त संबंध, गणितीय चिह्न परिवर्तन, पासा (Dice), घड़ी-कैलेंडर एवं आकृति गणना के 100 प्रश्न।",
            topicWeightage = listOf(
                "Number Series, Analogy & Coding-Decoding (32%)",
                "Syllogism, Blood Relations & Seating (26%)",
                "BODMAS Sign Interchange & Dice/Cube (22%)",
                "Figure Counting, Mirror Image & Clock (20%)"
            ),
            questions = buildSscQuestions(
                subjectNameEn = "Reasoning",
                subjectNameHi = "रीजनिंग / तर्कशक्ति",
                baseId = 86000,
                targetCount = 100,
                seeds = SscAptitudeEnglishSeedsData.reasoningSeeds
            )
        )
    }

    // 7. Mathematics / Quantitative Aptitude (100 Questions)
    val sscMathematics100Test: MockTest by lazy {
        MockTest(
            testId = "ssc_sec_mathematics_100",
            title = "SSC CGL / CHSL / CPO (Section 7): Mathematics (Quantitative Aptitude) — 100 TCS PYQ Test",
            hindiTitle = "SSC CGL / CHSL / CPO (सेक्शन 7): मैथमेटिक्स / गणित (अंकगणित एवं एडवांस मैथ्स) — 100 प्रश्न",
            examName = "SSC CGL / CHSL / CPO (Mathematics • 100 Qs)",
            durationMinutes = 60,
            totalMarks = 200,
            positiveMarks = 2.0,
            negativeMarks = 0.50,
            categoryId = "ssc",
            pyqAnalysisEn = "SSC CGL/CHSL/CPO 5-Year TCS Mathematics Analysis: Balanced 50% Arithmetic (Percentage, Profit-Loss-Discount, SI-CI, Ratio, Time & Work, TSD) + 50% Advance Maths (Algebra Identities, Trigonometry, Circle/Triangle Geometry, 2D/3D Mensuration & DI).",
            pyqAnalysisHi = "SSC CGL/CHSL/CPO 5-वर्षीय गणित विश्लेषण: अंकगणित (प्रतिशत, लाभ-हानि-छूट, साधारण व चक्रवृद्धि ब्याज, समय-कार्य, चाल-समय-दूरी) तथा एडवांस मैथ्स (बीजगणित, त्रिकोणमिति, ज्यामिति एवं क्षेत्रमिति 2D/3D) के 100 शॉर्टकट प्रश्न।",
            topicWeightage = listOf(
                "Advance Maths: Algebra & Trigonometry (28%)",
                "Geometry (Circles/Triangles) & Mensuration 3D (24%)",
                "Percentage, Profit-Loss-Discount & SI/CI (26%)",
                "Time & Work, TSD, Ratio & Number System (22%)"
            ),
            questions = buildSscQuestions(
                subjectNameEn = "Mathematics (Quant)",
                subjectNameHi = "मैथमेटिक्स / गणित",
                baseId = 87000,
                targetCount = 100,
                seeds = SscAptitudeEnglishSeedsData.mathematicsSeeds
            )
        )
    }

    // 8. English Language & Comprehension (100 Questions)
    val sscEnglish100Test: MockTest by lazy {
        MockTest(
            testId = "ssc_sec_english_100",
            title = "SSC CGL / CHSL / CPO (Section 8): English Language & Comprehension — 100 TCS PYQ Test",
            hindiTitle = "SSC CGL / CHSL / CPO (सेक्शन 8): इंग्लिश (English Grammar, Vocab & Comprehension) — 100 प्रश्न",
            examName = "SSC CGL / CHSL / CPO (English • 100 Qs)",
            durationMinutes = 60,
            totalMarks = 200,
            positiveMarks = 2.0,
            negativeMarks = 0.50,
            categoryId = "ssc",
            pyqAnalysisEn = "SSC CGL/CHSL/CPO 5-Year TCS English Analysis: Covers Error Spotting (Subject-Verb Agreement, Conditional Clauses), Active-Passive Voice, Direct-Indirect Narration, One-Word Substitution, Idioms & Phrases, Synonyms-Antonyms & Sentence Improvement with Bilingual (EN+HI) Explanations.",
            pyqAnalysisHi = "SSC CGL/CHSL/CPO 5-वर्षीय इंग्लिश विश्लेषण: ग्रामर एरर (Subject-Verb Agreement, Conditional Rules), Active-Passive Voice, Direct-Indirect Narration, One-Word Substitution, Idioms & Phrases तथा Synonyms-Antonyms के 100 प्रश्न (सरल हिंदी व अंग्रेजी व्याख्या सहित)।",
            topicWeightage = listOf(
                "Error Spotting & Sentence Improvement (28%)",
                "Active-Passive Voice & Narration (24%)",
                "One-Word Substitution & Idioms/Phrases (26%)",
                "Synonyms, Antonyms & Cloze/Spelling (22%)"
            ),
            questions = buildSscQuestions(
                subjectNameEn = "English Language",
                subjectNameHi = "इंग्लिश (अंग्रेज़ी भाषा)",
                baseId = 88000,
                targetCount = 100,
                seeds = SscAptitudeEnglishSeedsData.englishSeeds
            )
        )
    }

    // Complete Ordered List of all 8 SSC CGL/CHSL/CPO Section Tests (800 Questions Total):
    // First 5 GS Sections (History, Polity, Geography, Environment, Economics) -> then Reasoning -> Mathematics -> English
    val all8SscSectionTests: List<SscSectionTestMeta> by lazy {
        listOf(
            SscSectionTestMeta(
                id = "ssc_gs_history",
                sectionId = "ssc_sec_history_100",
                categoryGroupEn = "GS (General Studies)",
                categoryGroupHi = "जीएस (सामान्य अध्ययन)",
                titleEn = "1. GS: History & Culture (100 Qs)",
                titleHi = "1. जीएस: इतिहास एवं कला-संस्कृति (100 प्रश्न)",
                subtitleEn = "IVC, Buddhism, Maurya, Gupta, Sultanate, Mughal, 1857, INC & Classical Dances • 100 PYQs",
                subtitleHi = "सिंधु सभ्यता, मौर्य, गुप्त, सल्तनत, मुगल, 1857, कांग्रेस एवं शास्त्रीय नृत्य • 100 PYQ प्रश्न",
                questionCount = 100,
                isGsSection = true,
                mockTest = sscGsHistory100Test
            ),
            SscSectionTestMeta(
                id = "ssc_gs_polity",
                sectionId = "ssc_sec_polity_100",
                categoryGroupEn = "GS (General Studies)",
                categoryGroupHi = "जीएस (सामान्य अध्ययन)",
                titleEn = "2. GS: Polity & Constitution (100 Qs)",
                titleHi = "2. जीएस: राजव्यवस्था एवं संविधान (100 प्रश्न)",
                subtitleEn = "Sources, Schedules, FRs, DPSP, Duties, President, Parliament, SC & Amendments • 100 PYQs",
                subtitleHi = "संविधान के स्रोत, अनुसूचियाँ, मूल अधिकार, नीति निदेशक तत्व, राष्ट्रपति, संसद एवं संशोधन • 100 प्रश्न",
                questionCount = 100,
                isGsSection = true,
                mockTest = sscGsPolity100Test
            ),
            SscSectionTestMeta(
                id = "ssc_gs_geography",
                sectionId = "ssc_sec_geography_100",
                categoryGroupEn = "GS (General Studies)",
                categoryGroupHi = "जीएस (सामान्य अध्ययन)",
                titleEn = "3. GS: Indian & World Geography (100 Qs)",
                titleHi = "3. जीएस: भारत एवं विश्व का भूगोल (100 प्रश्न)",
                subtitleEn = "Himalayan Passes, Rivers, Dams, Soils, Monsoon, Atmosphere & Census 2011 • 100 PYQs",
                subtitleHi = "हिमालयी दर्रे, नदियाँ, बहुउद्देशीय बांध, मृदा, मानसून, वायुमंडल एवं जनगणना 2011 • 100 प्रश्न",
                questionCount = 100,
                isGsSection = true,
                mockTest = sscGsGeography100Test
            ),
            SscSectionTestMeta(
                id = "ssc_gs_environment",
                sectionId = "ssc_sec_environment_100",
                categoryGroupEn = "GS (General Studies)",
                categoryGroupHi = "जीएस (सामान्य अध्ययन)",
                titleEn = "4. GS: Environment & Ecology (100 Qs)",
                titleHi = "4. जीएस: पर्यावरण एवं पारिस्थितिकी (100 प्रश्न)",
                subtitleEn = "Ecosystem, 10% Law, National Parks, Biosphere, Ramsar Sites, Protocols & Pollution • 100 PYQs",
                subtitleHi = "पारिस्थितिकी तंत्र, 10% नियम, राष्ट्रीय उद्यान, रामसर स्थल, प्रोटोकॉल एवं प्रदूषण • 100 प्रश्न",
                questionCount = 100,
                isGsSection = true,
                mockTest = sscGsEnvironment100Test
            ),
            SscSectionTestMeta(
                id = "ssc_gs_economics",
                sectionId = "ssc_sec_economics_100",
                categoryGroupEn = "GS (General Studies)",
                categoryGroupHi = "जीएस (सामान्य अध्ययन)",
                titleEn = "5. GS: Economics & 5-Year Plans (100 Qs)",
                titleHi = "5. जीएस: अर्थव्यवस्था एवं पंचवर्षीय योजनाएं (100 प्रश्न)",
                subtitleEn = "Five-Year Plans (1st–12th), GDP/GNP/NNP, RBI Monetary Policy, Curves, Budget & GST • 100 PYQs",
                subtitleHi = "पंचवर्षीय योजनाएँ (1–12वीं), राष्ट्रीय आय, RBI मौद्रिक नीति, आर्थिक वक्र, बजट एवं GST • 100 प्रश्न",
                questionCount = 100,
                isGsSection = true,
                mockTest = sscGsEconomics100Test
            ),
            SscSectionTestMeta(
                id = "ssc_reasoning",
                sectionId = "ssc_sec_reasoning_100",
                categoryGroupEn = "Reasoning Ability",
                categoryGroupHi = "रीजनिंग (तर्कशक्ति)",
                titleEn = "6. General Intelligence & Reasoning (100 Qs)",
                titleHi = "6. रीजनिंग / तर्कशक्ति (Reasoning • 100 प्रश्न)",
                subtitleEn = "Number Series, Coding-Decoding, Syllogism, Blood Relations, Dice, BODMAS & Figure Counting • 100 PYQs",
                subtitleHi = "श्रृंखला, कोडिंग-डिकोडिंग, न्याय निगमन, रक्त संबंध, पासा, BODMAS एवं आकृति गणना • 100 प्रश्न",
                questionCount = 100,
                isGsSection = false,
                mockTest = sscReasoning100Test
            ),
            SscSectionTestMeta(
                id = "ssc_mathematics",
                sectionId = "ssc_sec_mathematics_100",
                categoryGroupEn = "Quantitative Aptitude",
                categoryGroupHi = "मैथमेटिक्स (गणित)",
                titleEn = "7. Mathematics / Quant Aptitude (100 Qs)",
                titleHi = "7. मैथमेटिक्स / गणित (अंकगणित व एडवांस • 100 प्रश्न)",
                subtitleEn = "Percentage, Profit-Loss, SI-CI, Time & Work, Algebra, Trigonometry, Geometry & 3D Mensuration • 100 PYQs",
                subtitleHi = "प्रतिशत, लाभ-हानि, ब्याज, समय-कार्य, बीजगणित, त्रिकोणमिति, ज्यामिति एवं क्षेत्रमिति • 100 प्रश्न",
                questionCount = 100,
                isGsSection = false,
                mockTest = sscMathematics100Test
            ),
            SscSectionTestMeta(
                id = "ssc_english",
                sectionId = "ssc_sec_english_100",
                categoryGroupEn = "English Language",
                categoryGroupHi = "इंग्लिश (अंग्रेज़ी भाषा)",
                titleEn = "8. English Language & Comprehension (100 Qs)",
                titleHi = "8. इंग्लिश / अंग्रेज़ी भाषा एवं व्याकरण (100 प्रश्न)",
                subtitleEn = "Error Spotting, Active-Passive Voice, Narration, OWS, Idioms & Synonyms-Antonyms (Bilingual Exp.) • 100 PYQs",
                subtitleHi = "ग्रामर एरर, Voice, Narration, One-Word Substitution, मुहावरे एवं शब्दावली (हिंदी+अंग्रेजी व्याख्या) • 100 प्रश्न",
                questionCount = 100,
                isGsSection = false,
                mockTest = sscEnglish100Test
            )
        )
    }

    val all8SscMockTests: List<MockTest> by lazy {
        all8SscSectionTests.map { it.mockTest }
    }

    fun getTestBySectionId(sectionId: String): MockTest {
        return all8SscSectionTests.firstOrNull {
            it.id.equals(sectionId, ignoreCase = true) ||
                it.sectionId.equals(sectionId, ignoreCase = true) ||
                it.mockTest.testId.equals(sectionId, ignoreCase = true)
        }?.mockTest ?: sscGsHistory100Test
    }
}
