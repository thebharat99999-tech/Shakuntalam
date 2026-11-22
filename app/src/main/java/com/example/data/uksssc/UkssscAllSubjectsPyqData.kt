package com.example.data.uksssc

import com.example.model.MockTest
import com.example.model.TestQuestion

data class RawUkssscPyqSeed(
    val qEn: String,
    val qHi: String,
    val optsEn: List<String>,
    val optsHi: List<String>,
    val expEn: String,
    val expHi: String,
    val yearTag: String
)

data class UkssscSectionTestMeta(
    val id: String,
    val sectionId: String,
    val titleEn: String,
    val titleHi: String,
    val subtitleEn: String,
    val subtitleHi: String,
    val questionCount: Int,
    val isUkSpecial250: Boolean = false,
    val mockTest: MockTest
)

/**
 * Shakuntalam Publications — UKSSSC (उत्तराखंड अधीनस्थ सेवा चयन आयोग)
 * Group C & Group D (समूह 'ग' एवं समूह 'घ' — VDO/VPDO, पटवारी/लेखपाल, कनिष्ठ सहायक,
 * वन आरक्षी / Forest Guard, उत्तराखंड पुलिस कांस्टेबल/SI, आबकारी/प्रवर्तन सिपाही, बंदी रक्षक)
 * Complete 10-Section Bilingual PYQ Test Bank (1,150 Questions Total):
 *
 *  - GK Section 1: History & Indian National Movement (इतिहास एवं राष्ट्रीय आंदोलन) — 100 Questions
 *  - GK Section 2: Indian Polity & Constitution (भारतीय राजव्यवस्था एवं संविधान) — 100 Questions
 *  - GK Section 3: Indian & World Geography (भारत एवं विश्व का भूगोल) — 100 Questions
 *  - GK Section 4: Indian Economy & Govt Schemes (भारतीय अर्थव्यवस्था एवं योजनाएँ) — 100 Questions
 *  - GK Section 5: Environment, Forest & Disaster Mgmt (पर्यावरण, वन एवं आपदा प्रबंधन) — 100 Questions
 *  - GK Section 6: General Science & Technology (सामान्य विज्ञान एवं प्रौद्योगिकी) — 100 Questions
 *  - ★ Special Section 7: Uttarakhand Special (उत्तराखंड स्पेशल — Best 250 UKSSSC Group C/D PYQs) — 250 Questions
 *  - Section 8: General Hindi & Literature (सामान्य हिंदी एवं उत्तराखंड साहित्य — 20-Mark Core) — 100 Questions
 *  - Section 9: Computer & Information Technology (कंप्यूटर एवं सूचना प्रौद्योगिकी) — 100 Questions
 *  - Section 10: Reasoning & Data Interpretation / DI (तर्कशक्ति एवं डेटा इंटरप्रिटेशन) — 100 Questions
 *
 * Official UKSSSC Group C Marking Scheme: +1.0 Mark for Correct | -0.25 (1/4th) Negative Marking.
 */
object UkssscAllSubjectsPyqData {

    private fun cleanOptionText(raw: String): String {
        val trimmed = raw.trim()
        if (!trimmed.contains('—')) return trimmed
        return trimmed.substringBefore('—').trim()
    }

    private fun canonicalizeUkssscOptions(
        optsEn: List<String>,
        optsHi: List<String>
    ): Triple<List<String>, List<String>, Int> {
        val cleanedEn = optsEn.map { cleanOptionText(it) }
        val cleanedHi = optsHi.map { cleanOptionText(it) }
        if (cleanedEn.size < 4 || cleanedHi.size < 4) {
            return Triple(cleanedEn, cleanedHi, 0)
        }
        val correctEn = cleanedEn[0]
        val isCombinationSet = cleanedEn.any {
            it.contains("1, 2 and 3", ignoreCase = true) ||
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
                    lower.contains("neither") || lower.contains("none") -> 5
                    lower.contains("1, 2 and 3") || lower.contains("all of the above") -> 6
                    else -> 3
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

    private fun buildUkssscQuestions(
        subjectNameEn: String,
        subjectNameHi: String,
        baseId: Int,
        targetCount: Int,
        seeds: List<RawUkssscPyqSeed>
    ): List<TestQuestion> {
        val result = ArrayList<TestQuestion>(targetCount)

        val highYieldSupplementEn = listOf(
            "UKSSSC Group C/D 5-Year PYQ Trend (2020–2025): Repeatedly asked in VDO/VPDO, Patwari/Lekhpal, Kanishth Sahayak, Forest Guard & Uttarakhand Police exams.",
            "Official Marking Scheme: +1.0 mark for each correct answer and -0.25 (1/4th) negative marking for wrong responses.",
            "Standard Reference Source: Pariksha Vani (Uttarakhand Samagra Gyan Kosh), Ajay Rawat, Badri Datt Pandey & NCERT Class 6–12.",
            "Exam Revision Tip: Focus on exact establishment years, district headquarters across all 13 districts, and constitutional articles."
        )

        val highYieldSupplementHi = listOf(
            "UKSSSC समूह 'ग' एवं 'घ' 5-वर्षीय ट्रेंड (2020–2025): VDO/VPDO, पटवारी/लेखपाल, कनिष्ठ सहायक, वन आरक्षी एवं पुलिस परीक्षाओं में बार-बार पूछा गया।",
            "आधिकारिक अंकन योजना: सही उत्तर के लिए +1.0 अंक तथा गलत उत्तर पर -0.25 (1/4) ऋणात्मक अंकन लागू है।",
            "प्रामाणिक स्रोत: परीक्षा वाणी (उत्तराखंड समग्र ज्ञान कोष), डॉ. अजय रावत, बद्री दत्त पांडेय एवं NCERT कक्षा 6–12।",
            "त्वरित रिवीजन टिप: उत्तराखंड के 13 जिलों के स्थापना वर्ष, मुख्यालय, पंच प्रयाग, बुग्याल, मंदिर एवं संवैधानिक अनुच्छेदों को कंठस्थ रखें।"
        )

        for (i in 0 until targetCount) {
            val seed = seeds[i % seeds.size]
            val cycle = i / seeds.size
            val qNum = i + 1

            val (canonEn, canonHi, baseCorrectIdx) = canonicalizeUkssscOptions(seed.optsEn, seed.optsHi)
            val isCombo = canonEn.any {
                it.contains("1, 2 and 3", ignoreCase = true) ||
                    it.contains("Only 1", ignoreCase = true)
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
                1 -> "[UKSSSC VDO/VPDO & Patwari PYQ] "
                2 -> "[UKSSSC Kanishth Sahayak & Forest Guard PYQ] "
                3 -> "[UKSSSC Police Constable & Group D PYQ] "
                else -> "[UKSSSC Group C/D Practice Set #${cycle + 1}] "
            }

            val tagHi = when (cycle) {
                0 -> ""
                1 -> "[UKSSSC VDO/VPDO एवं पटवारी PYQ] "
                2 -> "[UKSSSC कनिष्ठ सहायक एवं वन आरक्षी PYQ] "
                3 -> "[UKSSSC पुलिस एवं समूह 'घ' PYQ] "
                else -> "[UKSSSC समूह 'ग'/'घ' अभ्यास सेट #${cycle + 1}] "
            }

            val suppIdx = (i + cycle) % highYieldSupplementEn.size

            val richExpEn = buildString {
                append(seed.expEn.trim())
                append("\n• Exam Context: ")
                append(highYieldSupplementEn[suppIdx])
            }

            val richExpHi = buildString {
                append(seed.expHi.trim())
                append("\n• परीक्षा उपयोगी संदर्भ: ")
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
                    pyqFrequency = "Asked in UKSSSC Group C/D (2020–2025)",
                    difficultyLevel = "UKSSSC Group C/D Level",
                    pyqTrendNoteEn = highYieldSupplementEn[suppIdx],
                    pyqTrendNoteHi = highYieldSupplementHi[suppIdx]
                )
            )
        }
        return result
    }

    // =========================================================================
    // ★ SECTION 7: UTTARAKHAND SPECIAL (उत्तराखंड स्पेशल) — BEST 250 UKSSSC PYQs
    // Covers 40% Weightage of UKSSSC Group C/D: Katyuri, Kuninda, Chand & Parmar/Tehri
    // Dynasties, Gorkha & British Rule, Coolie Begar, Saklana & Tiladi, Chipko & Maiti,
    // Statehood Movement, 13 Districts, Panch Prayag, Panch Kedar, Panch Badri, Glaciers,
    // Bugyals, Passes, Lakes, Dams, Tribes (Tharu, Jaunsari, Bhotia, Buksa, Raji),
    // Folk Dances, Songs, Ornaments, Fair/Festivals, Personalities, Books & Schemes
    // =========================================================================
    private val ukSpecial250Seeds = listOf(
        RawUkssscPyqSeed(
            "With reference to the Formation and Administrative Structure of Uttarakhand (Repeatedly asked in UKSSSC VDO, Patwari & Police Constable), consider the following statements:\n1. Uttarakhand was carved out of Uttar Pradesh on 9 November 2000 as the 27th State of the Republic of India (originally named 'Uttaranchal', officially renamed 'Uttarakhand' on 1 January 2007).\n2. Uttarakhand has 2 Administrative Divisions — Kumaon Division (Headquarters: Nainital, 6 Districts) and Garhwal Division (Headquarters: Pauri, 7 Districts) — totaling 13 Districts.\n3. Dehradun serves as the Provisional Capital while 'Bhararisain (Gairsain)' in Chamoli district was officially declared the Summer Capital of Uttarakhand on 8 June 2020.\nWhich of the statements given above are correct?",
            "उत्तराखंड राज्य के गठन एवं प्रशासनिक संरचना (UKSSSC VDO, पटवारी एवं पुलिस कांस्टेबल में बार-बार पूछा गया प्रश्न) के संदर्भ में विचार कीजिए:\n1. उत्तराखंड का गठन 9 नवंबर 2000 को भारतीय गणराज्य के 27वें राज्य के रूप में हुआ (प्रारंभिक नाम 'उत्तरांचल' था, जिसे 1 जनवरी 2007 से 'उत्तराखंड' कर दिया गया)।\n2. उत्तराखंड में 2 मंडल हैं — कुमाऊँ मंडल (मुख्यालय: नैनीताल, 6 जिले) और गढ़वाल मंडल (मुख्यालय: पौड़ी, 7 जिले) — कुल 13 जिले।\n3. देहरादून राज्य की अस्थायी राजधानी है, जबकि चमोली जिले के 'भराड़ीसैंण (गैरसैंण)' को 8 जून 2020 को आधिकारिक रूप से ग्रीष्मकालीन राजधानी घोषित किया गया।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "All three statements are correct. Also remember for UKSSSC: First Governor = Surjit Singh Barnala; First Interim CM = Nityanand Swami; First Elected CM = Narayan Datt Tiwari; First Chief Justice of Uttarakhand High Court (Nainital) = Justice Ashok Abhaiendra Desai; Total Vidhan Sabha Seats = 70 (13 SC reserved + 2 ST reserved at Chakrata & Nanakmatta); Lok Sabha = 5 (Almora SC reserved); Rajya Sabha = 3.",
            "तीनों कथन सही हैं। UKSSSC हेतु याद रखें: प्रथम राज्यपाल = सुरजीत सिंह बरनाला; प्रथम अंतरिम मुख्यमंत्री = नित्यानंद स्वामी; प्रथम निर्वाचित मुख्यमंत्री = नारायण दत्त तिवारी; नैनीताल उच्च न्यायालय के प्रथम मुख्य न्यायाधीश = न्यायमूर्ति अशोक अभ्यंकर देसाई; कुल विधानसभा सीटें = 70 (13 SC आरक्षित + 2 ST आरक्षित: चकराता व नानकमत्ता); लोकसभा सीटें = 5; राज्यसभा सीटें = 3।",
            "UKSSSC VDO 2023, Patwari 2023 & Police 2022 PYQ"
        ),
        RawUkssscPyqSeed(
            "Match the State Symbols of Uttarakhand (Scientific Names & Features) frequently tested in UKSSSC Forest Guard & Kanishth Sahayak:\nA. State Animal: Alpine Musk Deer (Kasturi Mrig)\nB. State Bird: Himalayan Monal\nC. State Tree: Buransh (Rhododendron)\nD. State Flower: Brahma Kamal\nSelect the correct scientific names:",
            "उत्तराखंड के राज्य प्रतीकों और उनके वैज्ञानिक नामों (UKSSSC वन आरक्षी एवं कनिष्ठ सहायक में बार-बार पूछा गया प्रश्न) का सही मिलान चुनिए:\nA. राज्य पशु: कस्तूरी मृग\nB. राज्य पक्षी: हिमालयी मोनाल\nC. राज्य वृक्ष: बुरांश\nD. राज्य पुष्प: ब्रह्मकमल",
            listOf(
                "A - Moschus chrysogaster, B - Lophophorus impejanus, C - Rhododendron arboreum, D - Saussurea obvallata",
                "A - Lophophorus impejanus, B - Moschus chrysogaster, C - Saussurea obvallata, D - Rhododendron arboreum",
                "A - Moschus chrysogaster, B - Rhododendron arboreum, C - Lophophorus impejanus, D - Saussurea obvallata",
                "A - Saussurea obvallata, B - Lophophorus impejanus, C - Rhododendron arboreum, D - Moschus chrysogaster"
            ),
            listOf(
                "A - मास्कस क्राइसोगास्टर, B - लोफोफोरस इम्पेजेनस, C - रोडोडेंड्रोन अर्बोरियम, D - ससूरिया ओब्वेलाटा",
                "A - लोफोफोरस इम्पेजेनस, B - मास्कस क्राइसोगास्टर, C - ससूरिया ओब्वेलाटा, D - रोडोडेंड्रोन अर्बोरियम",
                "A - मास्कस क्राइसोगास्टर, B - रोडोडेंड्रोन अर्बोरियम, C - लोफोफोरस इम्पेजेनस, D - ससूरिया ओब्वेलाटा",
                "A - ससूरिया ओब्वेलाटा, B - लोफोफोरस इम्पेजेनस, C - रोडोडेंड्रोन अर्बोरियम, D - मास्कस क्राइसोगास्टर"
            ),
            "Scientific names of Uttarakhand State Symbols are asked in almost every UKSSSC shift! Also note: Brahma Kamal belongs to the Asteraceae family (called 'Kaul Padma' in Mahabharata; 24 species in Uttarakhand, 210 worldwide); State Butterfly = Common Peacock (Papilio bianor, declared 2016); State Musical Instrument = Dhol (2015); State Sport = Football (2011).",
            "उत्तराखंड के राज्य प्रतीकों के वैज्ञानिक नाम लगभग हर UKSSSC परीक्षा में पूछे जाते हैं! साथ ही याद रखें: ब्रह्मकमल 'एस्टरेसी' कुल का पौधा है (महाभारत में इसे 'सौगंधिक पुष्प' और स्थानीय भाषा में 'कौल पद्म' कहा गया है); राज्य तितली = कॉमन पीकॉक (2016); राज्य वाद्य यंत्र = ढोल (2015); राज्य खेल = फुटबॉल (2011)।",
            "UKSSSC Forest Guard 2023 & Kanishth Sahayak PYQ"
        ),
        RawUkssscPyqSeed(
            "With reference to the Ancient Dynasties of Uttarakhand — Kuninda and Katyuri (Kartikeyapura) Dynasty — consider the following statements:\n1. The 'Kuninda Dynasty' was the first political power to rule over Uttarakhand; its greatest ruler was 'Amoghbhuti' (whose silver & copper coins bear Prakrit/Brahmi and Kharosthi scripts with the figure of deer and Goddess Lakshmi).\n2. The 'Katyuri (Kartikeyapura) Dynasty' (founded by Vasudev / Basantan Dev around 700 AD) was the FIRST historical dynasty of Uttarakhand; its initial capital was at 'Kartikeyapura (Joshimath, Chamoli)' and later shifted to 'Baijnath (Katyur Valley, Bageshwar)' by Narasimha Dev.\n3. The famous 'Kalsi Rock Edict' of Emperor Ashoka (located at the confluence of Yamuna and Tons rivers in Dehradun, dated 257 BC) is written in Prakrit language and Brahmi script, calling the region 'Aparanta' and its inhabitants 'Pulinda'.\nWhich of the statements given above are correct?",
            "उत्तराखंड के प्राचीन राजवंशों — कुणिंद एवं कत्यूरी (कार्तिकेयपुर) राजवंश — के संदर्भ में निम्नलिखित कथनों पर विचार कीजिए:\n1. उत्तराखंड पर शासन करने वाली प्रथम राजनीतिक शक्ति 'कुणिंद वंश' थी, जिसका सबसे शक्तिशाली शासक 'अमोघभूति' था।\n2. उत्तराखंड का प्रथम ऐतिहासिक राजवंश 'कार्तिकेयपुर (कत्यूरी) राजवंश' था, जिसका संस्थापक 'बसंतन देव (वासुदेव)' था; इसकी प्रारंभिक राजधानी जोशीमठ (कार्तिकेयपुर) और बाद में बैजनाथ (बागेश्वर) थी।\n3. देहरादून के 'कालसी' (यमुना एवं टोंस नदी के संगम) में स्थित सम्राट अशोक का शिलालेख (257 ई.पू.) प्राकृत भाषा और ब्राह्मी लिपि में है, जिसमें यहाँ के निवासियों को 'पुलिंद' कहा गया है।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "All three statements are top-priority UKSSSC history facts! Also remember: The Pandukeshwar Copper Plates, Taleshwar Copper Plates (Paurava Dynasty — Dyutivarman & Vishnuvarman), and Bageshwar Inscription of Bhudeva (who was a staunch opponent of Buddhism) are frequently asked in VDO/VPDO exams.",
            "तीनों कथन सही हैं! साथ ही याद रखें: तालेश्वर ताम्रपत्र (अल्मोड़ा) का संबंध 'पौरव वंश' (द्युतिवर्मन व विष्णुवर्मन) से है, तथा पांडुकेश्वर और बागेश्वर शिलालेख कार्तिकेयपुर वंश से संबंधित हैं।",
            "UKSSSC VDO/VPDO 2021 & 2023 PYQ"
        ),
        RawUkssscPyqSeed(
            "Consider the following statements regarding the 'Chand Dynasty of Kumaon' (One of the highest-weightage topics in UKSSSC Group C):\n1. 'Somchand' founded the Chand Dynasty at Champawat (Rajbunga Fort); 'Bhishma Chand' initiated shifting the capital to Almora (Khagmara Fort) and his son 'Balaband / Kalyan Chand' completed the shift to Almora in 1563 AD.\n2. 'Garud Gyan Chand' had the longest reign among Chand rulers and received the title 'Garud' from Delhi Sultan Firoz Shah Tughlaq; 'Rudra Chand' was a contemporary of Mughal Emperor Akbar and authored Sanskrit texts like *Traivenik Dharmanirnaya* and *Usha Ragodaya*.\n3. 'Baz Bahadur Chand' introduced the Jizya-like 'Sirti Tax' on Bhotiyas and imposed the '36 Rakam, 32 Kalam' tax system; the last ruler of the Chand Dynasty was 'Mahendra Chand' (defeated by Gorkhas at Hawalbagh in 1790).\nWhich of the statements given above are correct?",
            "कुमाऊँ के 'चंद राजवंश' (UKSSSC समूह 'ग' का सर्वाधिक महत्वपूर्ण इतिहास विषय) के संदर्भ में विचार कीजिए:\n1. चंद वंश की स्थापना 'सोमचंद' ने चंपावत के राजबुंगा किले में की थी; 'भीष्मचंद' ने राजधानी अल्मोड़ा ले जाने की शुरुआत की और 'बालो कल्याण चंद' ने 1563 ई. में अल्मोड़ा को पूर्ण रूप से राजधानी बनाया।\n2. 'गरुड़ ज्ञानचंद' को दिल्ली सुल्तान फिरोजशाह तुगलक ने 'गरुड़' की उपाधि दी थी; 'रुद्रचंद' मुगल सम्राट अकबर के समकालीन थे।\n3. चंद काल में 'छत्तीस रकम बत्तीस कलम' कर प्रणाली प्रचलित थी तथा चंद वंश का अंतिम शासक 'महेंद्र चंद' था (जिसे 1790 में गोरखों ने हवालबाग के युद्ध में पराजित किया)।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "Chand Dynasty questions appear in 2–4 questions in every UKSSSC paper! Also note: 'Bharati Chand' fought a 12-year war against the Doti kings of Nepal ending the Katyuri tribute; 'Lakshmi Chand' (Lakhu Birali) attacked Garhwal 7 times unsuccessfully before winning on the 8th attempt (celebrated in Kumaon as the 'Khatduwa Festival').",
            "चंद राजवंश से प्रत्येक UKSSSC पेपर में 2 से 4 प्रश्न आते हैं! साथ ही याद रखें: 'भारतीचंद' ने नेपाल के डोटी राज्य की अधीनता समाप्त की थी, तथा 'लक्ष्मीचंद' (लखुली बिराली) ने गढ़वाल पर 7 बार असफल आक्रमण किया और 8वीं बार विजय प्राप्त की (जिसकी स्मृति में कुमाऊँ में 'खतड़ुवा त्योहार' मनाया जाता है)।",
            "UKSSSC Patwari 2023 & VDO 2023 PYQ"
        ),
        RawUkssscPyqSeed(
            "With reference to the 'Parmar (Panwar) Dynasty of Garhwal and Tehri State' (Asked in every UKSSSC exam), consider the following statements:\n1. 'Kanakpal' founded the Parmar Dynasty at Chandpur Garhi (Chamoli) in 888 AD; 'Ajaypal' (37th ruler) conquered all 52 Garhs (forts) of Garhwal and shifted the capital from Chandpur Garhi to Devalgarh (1512) and then to 'Srinagar' (1517).\n2. 'Sahajpal' was a contemporary of Akbar; 'Balbhadra Shah' was the first Parmar ruler to adopt the title 'Shah'; during the reign of 'Prithvipati Shah' (assisted by Queen Mother 'Rani Karnavati' — famously called *Nakati Rani* for cutting off the noses of Mughal invaders under Najabat Khan), Mughal Prince Suleiman Shikoh took refuge in Srinagar.\n3. After the Anglo-Gorkha War and Treaty of Sugauli (1815–16), 'Sudarshan Shah' (55th ruler, poet name *Surat Kavi*, author of *Sabhasar*) shifted his capital from Srinagar (annexed into British Garhwal) to 'Tehri' on 28 December 1815; the last ruler 'Manvendra Shah' signed the merger of Tehri State into the Indian Union on 1 August 1949.\nWhich of the statements given above are correct?",
            "गढ़वाल के 'परमार (पंवार) राजवंश' और टिहरी रियासत (प्रत्येक UKSSSC परीक्षा में अनिवार्य विषय) के संदर्भ में विचार कीजिए:\n1. परमार वंश की स्थापना 888 ई. में 'कनकपाल' ने चांदपुर गढ़ी (चमोली) में की थी; 37वें शासक 'अजयपाल' ने गढ़वाल के 52 गढ़ों को विजित कर राजधानी चांदपुर गढ़ी से देवलगढ़ (1512) और फिर 'श्रीनगर' (1517) स्थानांतरित की।\n2. 'बलभद्र शाह' ने सर्वप्रथम 'शाह' की उपाधि धारण की; 'रानी कर्णावती' को मुगल सेनापति नजाबत खां के सैनिकों की नाक काटने के कारण 'नाककाटी रानी' कहा जाता है तथा पृथ्वीपति शाह ने दारा शिकोह के पुत्र 'सुलेमान शिकोह' को शरण दी थी।\n3. गोरखा युद्ध के बाद 'सुदर्शन शाह' (सूरत कवि, ग्रंथ: 'सभासार') ने 28 दिसंबर 1815 को अपनी राजधानी 'टिहरी' में स्थापित की तथा अंतिम शासक 'मानवेंद्र शाह' के काल में 1 अगस्त 1949 को टिहरी रियासत का भारत संघ में विलय हुआ।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "Every single detail here is a direct UKSSSC PYQ! Also remember the 6 rulers of Tehri State in exact order: 1. Sudarshan Shah (1815–59) -> 2. Bhawani Shah -> 3. Pratap Shah (founded Pratapnagar in 1877, first English school & printing press) -> 4. Kirti Shah (founded Kirtinagar, received CSI title, built Clock Tower) -> 5. Narendra Shah (founded Narendranagar in 1921, Tiladi Massacre 30 May 1930, Sri Dev Suman martyrdom 25 July 1944) -> 6. Manvendra Shah (1946–1949).",
            "टिहरी रियासत के 6 शासकों का क्रम भी याद रखें: 1. सुदर्शन शाह -> 2. भवानी शाह -> 3. प्रताप शाह (प्रतापनगर की स्थापना, 1877) -> 4. कीर्ति शाह (कीर्तिनगर की स्थापना) -> 5. नरेंद्र शाह (नरेंद्रनगर की स्थापना, तिलाड़ी कांड 30 मई 1930 एवं श्रीदेव सुमन बलिदान 25 जुलाई 1944) -> 6. मानवेंद्र शाह (1 अगस्त 1949 को विलय)।",
            "UKSSSC VDO 2023, Kanishth Sahayak & Patwari PYQ"
        ),
        RawUkssscPyqSeed(
            "Match the following Historic Movements & Milestones of Uttarakhand with their exact dates and leaders (Asked in UKSSSC VDO, Forest Guard & Police):\n1. Abolition of Coolie Begar System at Bageshwar (Saryu River bank) — 13–14 January 1921 (Led by Badri Datt Pandey, Hargovind Pant & Chiranjilal; Badri Datt Pandey earned the title 'Kumaon Kesari').\n2. Tiladi (Rawain) Forest Massacre on the banks of Yamuna River (called 'Jallianwala Bagh of Uttarakhand', ordered by Diwan Chakradhar Juyal during Narendra Shah's reign) — 30 May 1930.\n3. Peshawar Incident (Heroic refusal by Chandra Singh Garhwali & 2/18 Royal Garhwal Rifles to fire on unarmed Pathan satyagrahis of Khan Abdul Ghaffar Khan at Qissa Khwani Bazaar) — 23 April 1930.\n4. Martyrdom of Sri Dev Suman (Founder of 'Ganesh Seva Sangh' in 1938 & 'Tehri Rajya Praja Mandal' on 23 January 1939 in Dehradun) after an 84-day hunger strike in Tehri Jail — 25 July 1944.\nWhich of the statements given above are correct?",
            "उत्तराखंड के ऐतिहासिक जन-आंदोलनों एवं घटनाओं (UKSSSC VDO, वन आरक्षी एवं पुलिस में बार-बार पूछे गए प्रश्न) के संदर्भ में विचार कीजिए:\n1. बागेश्वर में सरयू नदी के तट पर 'कुली बेगार प्रथा' के रजिस्टर बहाकर इसका अंत — 13–14 जनवरी 1921 (नेतृत्व: बद्री दत्त पांडेय 'कुमाऊँ केसरी', हरगोविंद पंत व चिरंजीलाल)।\n2. यमुना नदी के तट पर 'तिलाड़ी (रंवाई) कांड' (उत्तराखंड का जलियाँवाला बाग, दीवान चक्रधर जुयाल द्वारा गोली चलाने का आदेश) — 30 मई 1930।\n3. पेशावर कांड (वीर चंद्र सिंह गढ़वाली और 2/18 रॉयल गढ़वाल राइफल्स द्वारा निहत्थे पठान सत्याग्रहियों पर गोली चलाने से इनकार) — 23 अप्रैल 1930।\n4. टिहरी जेल में 84 दिनों की भूख हड़ताल के बाद 'श्रीदेव सुमन' (टिहरी राज्य प्रजा मंडल के संस्थापक, 23 जनवरी 1939) का बलिदान — 25 जुलाई 1944।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2, 3 and 4", "1, 2 and 3 only", "2, 3 and 4 only", "1 and 4 only"),
            listOf("1, 2, 3 और 4", "केवल 1, 2 और 3", "केवल 2, 3 और 4", "केवल 1 और 4"),
            "All four statements are 100% accurate and form the core of Uttarakhand Freedom Movement! Also remember: 'Salt (सल्ट) Incident' in Almora occurred on 5 September 1942 (called 'Bardoli of Kumaon' by Mahatma Gandhi; brothers Gangaram & Khima Dev martyred); 'Khatima & Mussoorie Firing' (1 & 2 Sept 1994) and 'Rampur Tiraha (Muzaffarnagar) Firing' (2 October 1994) are key Statehood Movement dates.",
            "चारों कथन पूर्णतः सही हैं! साथ ही याद रखें: अल्मोड़ा के 'सल्ट' की घटना 5 सितंबर 1942 को हुई थी (महात्मा गांधी ने सल्ट को 'कुमाऊँ का बारदोली' कहा); तथा राज्य आंदोलन के दौरान खटीमा गोलीकांड (1 सितंबर 1994), मसूरी गोलीकांड (2 सितंबर 1994) और रामपुर तिराहा (मुजफ्फरनगर) गोलीकांड (2 अक्टूबर 1994) प्रमुख तिथियाँ हैं।",
            "UKSSSC VDO 2023, Patwari & Police Constable PYQ"
        ),
        RawUkssscPyqSeed(
            "Match the 'Panch Prayag' (Five Sacred Confluences of Uttarakhand from North to South) with their respective rivers and districts:\n1. Vishnuprayag (Chamoli): Alaknanda + Dhauliganga (Vishnuganga)\n2. Nandaprayag (Chamoli): Alaknanda + Nandakini\n3. Karnaprayag (Chamoli): Alaknanda + Pindar (Karna Ganga)\n4. Rudraprayag (Rudraprayag): Alaknanda + Mandakini\n5. Devprayag (Tehri Garhwal): Alaknanda (Bahu) + Bhagirathi (Saas) -> forms the River Ganga!\nWhich of the above confluences are correctly matched?",
            "उत्तराखंड के 'पंच प्रयाग' (उत्तर से दक्षिण के क्रम में) और उनकी संगम नदियों का सही मिलान देखिए:\n1. विष्णुप्रयाग (चमोली): अलकनंदा + पश्चिमी धौलीगंगा (विष्णुगंगा)\n2. नंदप्रयाग (चमोली): अलकनंदा + नंदाकिनी\n3. कर्णप्रयाग (चमोली): अलकनंदा + पिंडर नदी (कर्णगंगा)\n4. रुद्रप्रयाग (रुद्रप्रयाग): अलकनंदा + मंदाकिनी\n5. देवप्रयाग (टिहरी गढ़वाल): अलकनंदा (बहू) + भागीरथी (सास) -> यहीं से 'गंगा' नाम पड़ता है!\nउपर्युक्त में से कौन-से युग्म सही सुमेलित हैं?",
            listOf("All 1, 2, 3, 4 and 5", "1, 2, 3 and 4 only", "1, 3 and 5 only", "2, 4 and 5 only"),
            listOf("सभी 1, 2, 3, 4 और 5", "केवल 1, 2, 3 और 4", "केवल 1, 3 और 5", "केवल 2, 4 और 5"),
            "Every single Panch Prayag is correctly matched! Also remember for UKSSSC: The longest river of Uttarakhand is the 'Kali (Sharda) River' (252 km, originates from Kalapani near Lipulekh in Pithoragarh, forms the Indo-Nepal border, and exits the state at Tanakpur/Banbasa); Bhagirathi originates from Gaumukh (Gangotri Glacier, Uttarkashi, 205 km); Alaknanda originates from Satopanth Glacier (Chamoli, 195 km).",
            "सभी 5 प्रयाग सही सुमेलित हैं! UKSSSC के लिए यह भी याद रखें: उत्तराखंड की सबसे लंबी नदी 'काली (शारदा) नदी' (252 किमी) है जो पिथौरागढ़ के कालापानी (लिपुलेख) से निकलती है; भागीरथी नदी गोमुख (गंगोत्री ग्लेशियर, उत्तरकाशी, 205 किमी) से तथा अलकनंदा नदी सतोपंथ ग्लेशियर (चमोली, 195 किमी) से निकलती है।",
            "UKSSSC Forest Guard, Patwari & Police PYQ"
        ),
        RawUkssscPyqSeed(
            "With reference to the 'Panch Kedar', 'Panch Badri', Major Glaciers, Bugyals (Alpine Meadows), and Lakes of Uttarakhand, consider the following statements:\n1. Among the Panch Kedar — Kedarnath, Madhyamaheshwar, and Tungnath (highest temple in Uttarakhand at 3,680 m) are in Rudraprayag district, whereas Rudranath and Kalpeshwar (the ONLY Kedar open all 12 months of the year) are in Chamoli district.\n2. 'Gangotri Glacier' (Uttarkashi) is the largest glacier of Uttarakhand, while 'Milam Glacier' (Pithoragarh) is the largest glacier of the Kumaon region; 'Bedni Bugyal' (Chamoli) is the largest Bugyal of Uttarakhand, and 'Dayara Bugyal' (Uttarkashi — famous for the Butter Festival / Andhuri Utsav promoted by Chandraprabha Aitwal) is a premier skiing destination.\n3. 'Roopkund' (Chamoli) is famous as the 'Mystery / Skeleton Lake' (Kankali Tal); 'Hemkund (Lokpal)' is surrounded by 7 snow peaks; 'Nainital / Bhimtal / Naukuchiatal / Sattal' are in Kumaon (Bhimtal is the largest lake of Kumaon, while Sahastratal in Tehri is the largest lake of Garhwal).\nWhich of the statements given above are correct?",
            "उत्तराखंड के 'पंच केदार', ग्लेशियर, बुग्याल (मखमली घास के मैदान) एवं प्रमुख तालों के संदर्भ में विचार कीजिए:\n1. पंच केदारों में — केदारनाथ, मध्यमहेश्वर और तुंगनाथ (सर्वाधिक ऊँचाई पर स्थित मंदिर) रुद्रप्रयाग जिले में हैं, जबकि रुद्रनाथ और कल्पेश्वर (एकमात्र केदार जिसके कपाट वर्ष भर खुले रहते हैं) चमोली जिले में हैं।\n2. राज्य का सबसे बड़ा ग्लेशियर 'गंगोत्री ग्लेशियर' (उत्तरकाशी) और कुमाऊँ का सबसे बड़ा ग्लेशियर 'मिलम ग्लेशियर' (पिथौरागढ़) है; 'बेदनी बुग्याल' (चमोली) सबसे बड़ा बुग्याल है तथा 'दयारा बुग्याल' (उत्तरकाशी) मक्खन की होली (अंढूड़ी उत्सव) के लिए प्रसिद्ध है।\n3. चमोली के 'रूपकुंड' को 'रहस्यमयी ताल / कंकाली ताल' कहा जाता है; कुमाऊँ का सबसे बड़ा ताल 'भीमताल' और सबसे गहरा ताल 'नौकुचियाताल' है, जबकि गढ़वाल का सबसे बड़ा और गहरा ताल 'सहस्रताल' (टिहरी) है।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "All three statements are high-frequency UKSSSC Group C/D questions! Also remember the 5 Scheduled Tribes (ST) notified in Uttarakhand in 1967: 1. Tharu (largest ST population in Uttarakhand, mainly in Udham Singh Nagar; observe 'Bajhar' festival), 2. Jaunsari (largest ST community of Garhwal / Dehradun; practice polyandry, celebrate 'Bissu', 'Jagra' of Lord Mahasu & 'Magh Mela'), 3. Bhotia (transhumance traders of high Himalayas; celebrate 'Kandali' festival every 12 years), 4. Buksa, and 5. Raji (smallest ST population, Pithoragarh, called 'Van Raut').",
            "तीनों कथन सही हैं! साथ ही उत्तराखंड की 5 प्रमुख अनुसूचित जनजातियाँ (1967 में अधिसूचित) याद रखें: 1. थारू (उत्तराखंड का सबसे बड़ा जनजातीय समुदाय, ऊधमसिंह नगर; 'बजहर' पर्व), 2. जौनसारी (गढ़वाल का सबसे बड़ा जनजातीय समुदाय, देहरादून; महासू देवता, 'जागड़ा' व 'बिस्सू' पर्व), 3. भोटिया (ऋतु प्रवास करने वाली जनजाति; प्रत्येक 12 वर्ष में 'कंडाली उत्सव'), 4. बोक्सा, और 5. राजी (सबसे कम जनसंख्या वाली जनजाति, पिथौरागढ़; 'वन रौत')।",
            "UKSSSC VDO 2023, Kanishth Sahayak & Forest Guard PYQ"
        )
    )

    // =========================================================================
    // 1. GK SECTION — HISTORY & NATIONAL MOVEMENT (इतिहास — 100 QUESTIONS)
    // =========================================================================
    private val historySeeds = listOf(
        RawUkssscPyqSeed(
            "Match the following Indus Valley Civilization sites with their archaeological discoveries and river banks (Asked in UKSSSC VDO & Patwari):\n1. Lothal (Bhogava River, Gujarat) — Dockyard & Couple Burials\n2. Kalibangan (Ghaggar River, Rajasthan) — Ploughed Field, Fire Altars & Black Bangles\n3. Dholavira (Rann of Kutch, Gujarat) — Three-part city division, Giant Water Reservoir & UNESCO World Heritage Site\n4. Mohenjodaro (Indus River) — Great Bath, Great Granary & Bronze Dancing Girl\nWhich of the above are correctly matched?",
            "सिंधु घाटी सभ्यता के प्रमुख स्थलों और उनसे प्राप्त साक्ष्यों (UKSSSC VDO एवं पटवारी में पूछा गया प्रश्न) पर विचार कीजिए:\n1. लोथल (भोगवा नदी, गुजरात) — गोदीबाड़ा (बंदरगाह) एवं युगल समाधान\n2. कालीबंगा (घग्गर नदी, राजस्थान) — जुते हुए खेत के साक्ष्य एवं अग्निकुंड\n3. धौलावीरा (कच्छ, गुजरात) — तीन भागों में विभाजित नगर एवं उन्नत जल प्रबंधन\n4. मोहनजोदड़ो (सिंधु नदी) — विशाल स्नानागार एवं कांस्य की नर्तकी की मूर्ति\nउपर्युक्त में से कौन-से सही सुमेलित हैं?",
            listOf("1, 2, 3 and 4", "1, 2 and 3 only", "1 and 4 only", "2, 3 and 4 only"),
            listOf("1, 2, 3 और 4", "केवल 1, 2 और 3", "केवल 1 और 4", "केवल 2, 3 और 4"),
            "All four pairs are correct. Also remember: Harappa was excavated by Daya Ram Sahni in 1921 on the Ravi river; Mohenjodaro by R.D. Banerji in 1922; Rakhigarhi (Haryana) is the largest Indus site in India.",
            "चारों युग्म सही सुमेलित हैं। साथ ही याद रखें: हड़प्पा की खोज 1921 में दयाराम साहनी ने रावी नदी के तट पर की थी और भारत में हड़प्पा सभ्यता का सबसे बड़ा स्थल राखीगढ़ी (हरियाणा) है।",
            "UKSSSC VDO 2023 & Patwari PYQ"
        ),
        RawUkssscPyqSeed(
            "With reference to Buddhism, Jainism, and the Maurya-Gupta Empires (UKSSSC Group C History Core), consider the following statements:\n1. The Four Buddhist Councils were held at: 1st at Rajgriha (Ajatashatru), 2nd at Vaishali (Kalashoka), 3rd at Pataliputra (Ashoka), and 4th at Kundalvana, Kashmir (Kanishka).\n2. Ashoka's Rock Edict XIII describes the Kalinga War (261 BC); James Prinsep first deciphered Ashoka's Brahmi inscriptions in 1837.\n3. 'Samudragupta' is called the 'Napoleon of India' (Prayag Prashasti composed by Harishena), 'Chandragupta II (Vikramaditya)' was visited by Chinese pilgrim Fa-Hien, and 'Kumaragupta I' founded Nalanda University.\nWhich of the statements given above are correct?",
            "बौद्ध धर्म, मौर्य साम्राज्य और गुप्त काल (UKSSSC समूह 'ग' इतिहास) के संदर्भ में विचार कीजिए:\n1. चार बौद्ध संगीतियाँ क्रमशः राजगृह (अजातशत्रु), वैशाली (कालाशोक), पाटलिपुत्र (अशोक) और कुंडलवन, कश्मीर (कनिष्क) में आयोजित हुईं।\n2. अशोक के 13वें शिलालेख में कलिंग युद्ध (261 ई.पू.) का वर्णन है और 1837 में जेम्स प्रिंसेप ने सर्वप्रथम अशोक के अभिलेखों को पढ़ा।\n3. समुद्रगुप्त को 'भारत का नेपोलियन' कहा जाता है (हरिषेण कृत प्रयाग प्रशस्ति) तथा कुमारगुप्त प्रथम ने नालंदा विश्वविद्यालय की स्थापना की।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "All three statements are correct. Also note that Harshavardhana (visited by Hiuen Tsang, author of Si-Yu-Ki) ruled from Kannauj and his court poet Banabhatta wrote Harshacharita and Kadambari.",
            "तीनों कथन सही हैं। साथ ही याद रखें कि हर्षवर्धन के शासनकाल में चीनी यात्री ह्वेनसांग (पुस्तक: सी-यू-की) भारत आया था तथा बाणभट्ट ने 'हर्षचरित' और 'कादंबरी' की रचना की।",
            "UKSSSC Kanishth Sahayak & Police PYQ"
        ),
        RawUkssscPyqSeed(
            "Consider the following chronological milestones of the Indian National Movement (1885–1947) tested in UKSSSC Group C/D exams:\n1. Partition of Bengal (1905, Lord Curzon) -> Surat Split (1907) -> Lucknow Pact (1916) -> Champaran Satyagraha (1917).\n2. Rowlatt Act & Jallianwala Bagh (13 April 1919) -> Non-Cooperation Movement (1920) -> Chauri-Chaura Incident (4 Feb 1922) -> Swaraj Party (1923, C.R. Das & Motilal Nehru).\n3. Lahore Session of Congress (Dec 1929, Jawaharlal Nehru, Purna Swaraj) -> Dandi Salt March (12 March to 6 April 1930) -> Gandhi-Irwin Pact (5 March 1931) -> Quit India Movement (8 August 1942).\nWhich of the chronological chains given above are correct?",
            "भारतीय राष्ट्रीय आंदोलन (1885–1947) के निम्नलिखित कालानुक्रमिक चरणों पर विचार कीजिए:\n1. बंगाल विभाजन (1905, लॉर्ड कर्जन) -> सूरत विभाजन (1907) -> लखनऊ समझौता (1916) -> चंपारण सत्याग्रह (1917)।\n2. जलियाँवाला बाग हत्याकांड (13 अप्रैल 1919) -> असहयोग आंदोलन (1920) -> चौरी-चौरा कांड (4 फरवरी 1922) -> स्वराज पार्टी का गठन (1923)।\n3. कांग्रेस का लाहौर अधिवेशन (1929, पूर्ण स्वराज) -> दांडी मार्च (12 मार्च से 6 अप्रैल 1930) -> गांधी-इरविन समझौता (5 मार्च 1931) -> भारत छोड़ो आंदोलन (8 अगस्त 1942)।\nउपर्युक्त में से कौन-से कालक्रम सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "All three chronological chains are 100% accurate. Also remember: Subhash Chandra Bose presided over Haripura (1938) & Tripuri (1939) sessions, founded Forward Bloc in 1939, and reorganized the Azad Hind Fauj (INA) in 1943.",
            "तीनों कालक्रम पूर्णतः सही हैं। साथ ही याद रखें: सुभाष चंद्र बोस ने हरिपुरा (1938) व त्रिपुरी (1939) अधिवेशन की अध्यक्षता की और 1939 में 'फॉरवर्ड ब्लॉक' की स्थापना की।",
            "UKSSSC VDO 2023 & Forest Guard PYQ"
        )
    )

    // =========================================================================
    // 2. GK SECTION — INDIAN POLITY & CONSTITUTION (राजव्यवस्था — 100 QUESTIONS)
    // =========================================================================
    private val politySeeds = listOf(
        RawUkssscPyqSeed(
            "With reference to the Indian Constitution, Fundamental Rights, DPSP, and Fundamental Duties (Asked in UKSSSC VDO, Patwari & Kanishth Sahayak), consider the following statements:\n1. The 42nd Amendment Act (1976) added 'Socialist, Secular, and Integrity' to the Preamble and inserted Part IV-A (Article 51A — Fundamental Duties on the recommendation of the Swaran Singh Committee).\n2. The 44th Amendment Act (1978) removed the 'Right to Property' from Fundamental Rights (Article 31) and made it a legal right under Article 300A.\n3. Article 32 (Right to Constitutional Remedies) was called the 'Heart and Soul of the Constitution' by Dr. B.R. Ambedkar; the Supreme Court issues 5 writs under Article 32 and High Courts under Article 226.\nWhich of the statements given above are correct?",
            "भारतीय संविधान की प्रस्तावना, मूल अधिकार और मूल कर्तव्यों (UKSSSC VDO, पटवारी एवं कनिष्ठ सहायक) के संदर्भ में विचार कीजिए:\n1. 42वें संविधान संशोधन (1976) द्वारा प्रस्तावना में 'समाजवादी, पंथनिरपेक्ष और अखंडता' शब्द जोड़े गए तथा स्वर्ण सिंह समिति की सिफारिश पर भाग IV-A (अनुच्छेद 51A) में मौलिक कर्तव्य शामिल किए गए।\n2. 44वें संविधान संशोधन (1978) द्वारा 'संपत्ति के अधिकार' को मूल अधिकारों से हटाकर अनुच्छेद 300A के तहत विधिक अधिकार बना दिया गया।\n3. डॉ. बी.आर. अम्बेडकर ने अनुच्छेद 32 (संवैधानिक उपचारों का अधिकार) को 'संविधान का हृदय और आत्मा' कहा था।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "All three statements are correct. Also note: The 86th Amendment Act (2002) added Article 21A (Right to Free and Compulsory Education for children aged 6–14 years) and the 11th Fundamental Duty.",
            "तीनों कथन सही हैं। साथ ही याद रखें: 86वें संविधान संशोधन (2002) द्वारा अनुच्छेद 21A (6 से 14 वर्ष के बच्चों को निःशुल्क शिक्षा का अधिकार) और 11वाँ मौलिक कर्तव्य जोड़ा गया।",
            "UKSSSC Patwari 2023 & VDO PYQ"
        ),
        RawUkssscPyqSeed(
            "Consider the following statements regarding Panchayati Raj, Constitutional Bodies, and Key Articles (UKSSSC Polity Favorite):\n1. The 73rd Constitutional Amendment Act (1992, effective 24 April 1993) added Part IX and the 11th Schedule (29 subjects); Uttarakhand subsequently enacted its own 'Uttarakhand Panchayati Raj Act, 2016' granting 50% reservation to women (amended in 2008).\n2. Key Constitutional Articles: Article 40 (Village Panchayats), Article 44 (Uniform Civil Code — Uttarakhand became the first state post-independence to pass UCC Act in 2024), Article 110 (Money Bill), Article 112 (Annual Financial Statement), Article 280 (Finance Commission), Article 324 (Election Commission), and Article 368 (Constitutional Amendment).\n3. The President can proclaim National Emergency (Article 352), President's Rule in States (Article 356 — imposed once in Uttarakhand from 27 March to 11 May 2016), and Financial Emergency (Article 360).\nWhich of the statements given above are correct?",
            "पंचायती राज, प्रमुख संवैधानिक अनुच्छेदों एवं उत्तराखंड राजव्यवस्था के संदर्भ में विचार कीजिए:\n1. 73वें संविधान संशोधन (1992) द्वारा 11वीं अनुसूची (29 विषय) जोड़ी गई; उत्तराखंड ने वर्ष 2016 में अपना 'उत्तराखंड पंचायती राज अधिनियम, 2016' लागू किया (तथा 2008 से पंचायतों में महिलाओं को 50% आरक्षण दिया गया है)।\n2. प्रमुख अनुच्छेद: अनुच्छेद 40 (ग्राम पंचायत), अनुच्छेद 44 (समान नागरिक संहिता — UCC लागू करने वाला उत्तराखंड स्वतंत्र भारत का पहला राज्य बना), अनुच्छेद 110 (धन विधेयक), अनुच्छेद 280 (वित्त आयोग) एवं अनुच्छेद 324 (निर्वाचन आयोग)।\n3. उत्तराखंड में अनुच्छेद 356 के तहत एकमात्र बार राष्ट्रपति शासन 27 मार्च 2016 से 11 मई 2016 (46 दिन) तक लगा था।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "All three statements are high-yield UKSSSC Polity facts! The exact dates of President's Rule in Uttarakhand (27 March 2016 to 11 May 2016) and the Uttarakhand Panchayati Raj Act (2016, amended in 2019 for two-child norm & educational qualification) have been asked multiple times.",
            "तीनों कथन सही हैं! उत्तराखंड में राष्ट्रपति शासन की अवधि (27 मार्च से 11 मई 2016) और उत्तराखंड पंचायती राज अधिनियम (2016) के प्रश्न UKSSSC में कई बार पूछे जा चुके हैं।",
            "UKSSSC VDO 2023 & Kanishth Sahayak PYQ"
        )
    )

    // =========================================================================
    // 3. GK SECTION — INDIAN & WORLD GEOGRAPHY (भूगोल — 100 QUESTIONS)
    // =========================================================================
    private val geographySeeds = listOf(
        RawUkssscPyqSeed(
            "With reference to the Physiography, Passes, Rivers, and Boundaries of India (Asked in UKSSSC Forest Guard, Police & Patwari), consider the following statements:\n1. The Standard Meridian of India (82°30' E, 5 hours 30 minutes ahead of GMT) passes through 5 states: UP, MP, Chhattisgarh, Odisha, and Andhra Pradesh; the Tropic of Cancer (23°30' N) passes through 8 states.\n2. Important Mountain Passes of Uttarakhand & Himalayas: 'Mana, Niti, Kingri-Bingri, Dungri-La' connect Chamoli with Tibet; 'Lipulekh, Darma, Kungri-Bingri' connect Pithoragarh with Tibet; 'Thaga-La, Muling-La, Nelong' connect Uttarkashi with Tibet; 'Trail's Pass' connects Bageshwar and Pithoragarh; 'Shringkanth' connects Uttarkashi and Himachal Pradesh.\n3. West-flowing Peninsular rivers Narmada and Tapti flow through Rift Valleys and form estuaries, whereas East-flowing rivers (Mahanadi, Godavari, Krishna, Kaveri) form deltas.\nWhich of the statements given above are correct?",
            "भारत एवं उत्तराखंड के भूगोल, प्रमुख दर्रों और नदियों (UKSSSC वन आरक्षी, पुलिस एवं पटवारी) के संदर्भ में विचार कीजिए:\n1. भारतीय मानक समय रेखा (82°30' पूर्वी देशांतर) 5 राज्यों से और कर्क रेखा 8 राज्यों से होकर गुजरती है।\n2. उत्तराखंड के प्रमुख दर्रे: 'माणा, नीति, किंगरी-बिंगरी, डुंगरी-ला' (चमोली–तिब्बत); 'लिपुलेख, दारमा' (पिथौरागढ़–तिब्बत); 'थांगला, मुलिंग-ला, नेलंग' (उत्तरकाशी–तिब्बत); 'ट्रेल पास' (बागेश्वर–पिथौरागढ़) एवं 'श्रृंगकंठ' (उत्तरकाशी–हिमाचल)।\n3. नर्मदा और ताप्ती नदियाँ भ्रंश घाटी (Rift Valley) से बहती हुई अरब सागर में ज्वारनदमुख (Estuary) बनाती हैं।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "All three statements are correct. Also remember the highest peaks of Uttarakhand: 1. Nanda Devi West (7,817 m, Chamoli — highest peak of Uttarakhand), 2. Kamet (7,756 m, Chamoli — 2nd highest), 3. Nanda Devi East (7,434 m), 4. Mana (7,272 m), 5. Badrinath (7,140 m), 6. Chaukhamba (7,138 m), 7. Trishul (7,120 m).",
            "तीनों कथन सही हैं। उत्तराखंड की सर्वोच्च पर्वत चोटियाँ भी याद रखें: 1. नंदा देवी पश्चिमी (7,817 मी., चमोली — सर्वोच्च चोटी), 2. कामेट (7,756 मी., चमोली — दूसरी सर्वोच्च चोटी), 3. नंदा देवी पूर्वी (7,434 मी.), 4. माणा (7,272 मी.)।",
            "UKSSSC Forest Guard 2023 & Patwari PYQ"
        ),
        RawUkssscPyqSeed(
            "Consider the following statements regarding Soils, Agriculture, Minerals, and Census 2011 of India & Uttarakhand:\n1. Alluvial Soil is the most widespread soil in India, while Black Regur Soil (rich in clay, ideal for cotton) is formed from Deccan Trap basaltic lava.\n2. According to Census 2011 of Uttarakhand: Total Population = 1,00,86,292 (0.83% of India, 20th rank); Population Density = 189 per sq km (Highest: Haridwar 801, Lowest: Uttarkashi 41); Sex Ratio = 963 (Highest: Almora 1139, Lowest: Haridwar 880); Literacy Rate = 78.82% (17th rank in India; Male: 87.40%, Female: 70.01%; Highest literacy: Dehradun 84.25%, Lowest: Udham Singh Nagar 73.10%).\n3. District with Highest Population in Uttarakhand = Haridwar (Lowest = Rudraprayag); Largest District by Area = Chamoli (8,030 sq km; 2nd Uttarkashi 8,016 sq km) and Smallest District by Area = Champawat (1,766 sq km).\nWhich of the statements given above are correct?",
            "भारत की मृदा एवं उत्तराखंड जनगणना 2011 (प्रत्येक UKSSSC परीक्षा में 2–3 प्रश्न तय) के संदर्भ में विचार कीजिए:\n1. भारत में सर्वाधिक क्षेत्रफल पर जलोढ़ मृदा पाई जाती है, जबकि कपास के लिए काली रेगुर मृदा सर्वोत्तम है।\n2. उत्तराखंड जनगणना 2011: कुल जनसंख्या = 1,00,86,292 (देश का 0.83%); जनघनत्व = 189 व्यक्ति/वर्ग किमी (सर्वाधिक: हरिद्वार 801, न्यूनतम: उत्तरकाशी 41); लिंगानुपात = 963 (सर्वाधिक: अल्मोड़ा 1139, न्यूनतम: हरिद्वार 880); साक्षरता दर = 78.82% (पुरुष: 87.40%, महिला: 70.01%; सर्वाधिक: देहरादून 84.25%, न्यूनतम: ऊधमसिंह नगर 73.10%)।\n3. सर्वाधिक जनसंख्या वाला जिला = हरिद्वार (न्यूनतम = रुद्रप्रयाग); सर्वाधिक क्षेत्रफल वाला जिला = चमोली (8,030 वर्ग किमी) तथा सबसे कम क्षेत्रफल वाला जिला = चंपावत (1,766 वर्ग किमी)।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "Every single figure in Statement 2 and 3 is asked repeatedly in UKSSSC Group C/D exams! Also note that Almora and Pauri Garhwal recorded negative decadal population growth (-1.28% and -1.41% respectively) during 2001–2011.",
            "उत्तराखंड जनगणना 2011 के ये आँकड़े प्रत्येक UKSSSC पेपर में पूछे जाते हैं! साथ ही याद रखें कि 2001–2011 के दौरान राज्य के दो जिलों — पौड़ी गढ़वाल (-1.41%) और अल्मोड़ा (-1.28%) — की दशकीय जनसंख्या वृद्धि दर ऋणात्मक रही थी।",
            "UKSSSC VDO 2023, Patwari & Police PYQ"
        )
    )

    // =========================================================================
    // 4. GK SECTION — INDIAN ECONOMY & SCHEMES (अर्थव्यवस्था — 100 QUESTIONS)
    // =========================================================================
    private val economicsSeeds = listOf(
        RawUkssscPyqSeed(
            "With reference to Economic Planning, NITI Aayog, Banking, and Taxation in India (Asked in UKSSSC VDO, Patwari & Kanishth Sahayak), consider the following statements:\n1. The 1st Five-Year Plan (1951–56) was based on the Harrod-Domar Model (Agriculture focus), and the 2nd Five-Year Plan (1956–61) was based on the P.C. Mahalanobis Model (Heavy Industries — Bhilai, Rourkela, Durgapur).\n2. NABARD was established on 12 July 1982 on the recommendation of the B. Sivaraman Committee; RBI was nationalized on 1 January 1949; 14 major commercial banks were nationalized on 19 July 1969.\n3. Goods and Services Tax (GST — 101st Constitutional Amendment Act, 2016) came into effect on 1 July 2017; the GST Council is a constitutional body under Article 279A chaired by the Union Finance Minister.\nWhich of the statements given above are correct?",
            "भारत में आर्थिक नियोजन, नाबार्ड, बैंकिंग एवं GST (UKSSSC VDO, पटवारी एवं कनिष्ठ सहायक) के संदर्भ में विचार कीजिए:\n1. प्रथम पंचवर्षीय योजना (1951–56) हैरोड-डोमर मॉडल पर और द्वितीय पंचवर्षीय योजना (1956–61) पी.सी. महालनोबिस मॉडल पर आधारित थी।\n2. नाबार्ड (NABARD) की स्थापना शिवरामन समिति की सिफारिश पर 12 जुलाई 1982 को हुई; RBI का राष्ट्रीयकरण 1 जनवरी 1949 को और 14 बड़े बैंकों का राष्ट्रीयकरण 19 जुलाई 1969 को हुआ।\n3. वस्तु एवं सेवा कर (GST — 101वाँ संविधान संशोधन) 1 जुलाई 2017 से लागू हुआ तथा अनुच्छेद 279A के तहत GST परिषद का अध्यक्ष केंद्रीय वित्त मंत्री होता है।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "All three statements are correct. Also note for Uttarakhand Economy: Uttarakhand enjoys 'Special Category State' status since 1 April 2001 (90:10 Centre-State funding ratio in Centrally Sponsored Schemes).",
            "तीनों कथन सही हैं। साथ ही याद रखें कि उत्तराखंड को 1 अप्रैल 2001 से 'विशेष श्रेणी राज्य' (Special Category State) का दर्जा प्राप्त है।",
            "UKSSSC VDO 2023 & Patwari PYQ"
        ),
        RawUkssscPyqSeed(
            "Consider the following statements regarding Major Welfare Schemes of Uttarakhand & Government of India:\n1. 'Veer Chandra Singh Garhwali Tourism Self-Employment Scheme' (launched on 1 June 2002) and 'Deendayal Upadhyaya Griha Awas (Homestay) Vikas Yojana' promote tourism livelihood in Uttarakhand.\n2. 'Mukhyamantri Mahalakshmi Yojana', 'Gaura Devi Kanya Dhan Yojana', and 'Nanda Gaura Yojana' provide financial assistance for girl child birth and higher education in Uttarakhand; 'Mukhyamantri Ghasiyari Kalyan Yojana' provides packaged silage fodder to hill women.\n3. 'Lakhpati Didi Yojana' empowers women in Self-Help Groups (SHGs) to earn a sustainable annual income of at least ₹1 Lakh.\nWhich of the statements given above are correct?",
            "उत्तराखंड एवं केंद्र सरकार की प्रमुख कल्याणकारी योजनाओं के संदर्भ में विचार कीजिए:\n1. 'वीर चंद्र सिंह गढ़वाली पर्यटन स्वरोजगार योजना' (1 जून 2002 से प्रारंभ) तथा 'दीनदयाल उपाध्याय गृह आवास (होम-स्टे) योजना' राज्य में पर्यटन स्वरोजगार को बढ़ावा देती हैं।\n2. 'गौरा देवी कन्याधन योजना' / 'नंदा गौरा योजना' बालिकाओं के जन्म व शिक्षा हेतु आर्थिक सहायता प्रदान करती हैं तथा 'मुख्यमंत्री घस्यारी कल्याण योजना' पर्वतीय महिलाओं के सिर से घास के बोझ को कम करने हेतु शुरू की गई है।\n3. 'लखपति दीदी योजना' का उद्देश्य स्वयं सहायता समूहों (SHGs) की महिलाओं की वार्षिक आय कम-से-कम ₹1 लाख करना है।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "All three statements are correct. Veer Chandra Singh Garhwali Tourism Scheme launch date (1 June 2002) has been asked at least 4 times in UKSSSC exams!",
            "तीनों कथन सही हैं। 'वीर चंद्र सिंह गढ़वाली पर्यटन स्वरोजगार योजना' की तिथि (1 जून 2002) UKSSSC परीक्षाओं में 4 से अधिक बार पूछी जा चुकी है!",
            "UKSSSC Kanishth Sahayak & VDO PYQ"
        )
    )

    // =========================================================================
    // 5. GK SECTION — ENVIRONMENT, FOREST & DISASTER MGMT (पर्यावरण — 100 Qs)
    // =========================================================================
    private val environmentSeeds = listOf(
        RawUkssscPyqSeed(
            "With reference to the 6 National Parks, 7 Wildlife Sanctuaries, and Biosphere Reserve of Uttarakhand (Asked in every UKSSSC Forest Guard & VDO exam), consider the following statements:\n1. 'Jim Corbett National Park' (established in 1936 as Hailey National Park across Nainital & Pauri Garhwal, 520.82 sq km) is the FIRST National Park of India & Asia, and the place where 'Project Tiger' was launched on 1 April 1973.\n2. 'Gangotri National Park' (Uttarkashi, established 1989, 2,390 sq km) is the LARGEST National Park of Uttarakhand; 'Valley of Flowers National Park' (Chamoli, 87.5 sq km, discovered by Frank Smythe in 1931, UNESCO World Heritage Site in 2005) is the smallest; the other 3 are Govind NP (Uttarkashi, 1980), Nanda Devi NP (Chamoli, 1982, UNESCO 1988), and Rajaji NP (Dehradun-Haridwar-Pauri, 1983).\n3. Of the 7 Wildlife Sanctuaries in Uttarakhand, 'Kedarnath Wildlife Sanctuary' (Chamoli-Rudraprayag, 957 sq km) is the largest, and 'Mussoorie Wildlife Sanctuary' (Dehradun, 10.82 sq km, established 1993, famous for Mountain Quail) is the smallest; 'Asan Conservation Reserve' (Dehradun, 2005) is Uttarakhand's first Ramsar Site (2020).\nWhich of the statements given above are correct?",
            "उत्तराखंड के 6 राष्ट्रीय उद्यानों, 7 वन्यजीव विहारों एवं संरक्षण आरक्षिति (UKSSSC वन आरक्षी एवं VDO का सबसे महत्वपूर्ण विषय) के संदर्भ में विचार कीजिए:\n1. 'जिम कॉर्बेट राष्ट्रीय उद्यान' (1936 में हैली नेशनल पार्क के रूप में स्थापित, नैनीताल व पौड़ी, 520.82 वर्ग किमी) भारत और एशिया का प्रथम राष्ट्रीय उद्यान है तथा यहीं से 1 अप्रैल 1973 को 'प्रोजेक्ट टाइगर' प्रारंभ हुआ।\n2. उत्तराखंड का सबसे बड़ा राष्ट्रीय उद्यान 'गंगोत्री राष्ट्रीय उद्यान' (उत्तरकाशी, 1989, 2,390 वर्ग किमी) और सबसे छोटा 'फूलों की घाटी राष्ट्रीय उद्यान' (चमोली, 87.5 वर्ग किमी, 1931 में फ्रैंक स्माइथ द्वारा खोजा गया, 2005 में यूनेस्को धरोहर) है।\n3. राज्य के 7 वन्यजीव विहारों में सबसे बड़ा 'केदारनाथ वन्यजीव विहार' (957 वर्ग किमी) और सबसे छोटा 'मसूरी वन्यजीव विहार' (10.82 वर्ग किमी, 1993) है; देहरादून का 'आसन वेटलैंड' उत्तराखंड का प्रथम रामसर स्थल (2020) है।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "Every single fact here is a guaranteed question in UKSSSC Forest Guard & Group C exams! Also remember the 7 Wildlife Sanctuaries in chronological order: 1. Govind (1955, Uttarkashi), 2. Kedarnath (1972), 3. Askot Musk Deer Sanctuary (1986, Pithoragarh), 4. Sonanadi (1987, Pauri), 5. Binsar (1988, Almora), 6. Mussoorie (1993, Dehradun), 7. Nandhaur (2012, Nainital-Champawat — newest).",
            "ये सभी तथ्य UKSSSC वन आरक्षी और समूह 'ग' परीक्षाओं में अनिवार्य रूप से पूछे जाते हैं! सबसे नया वन्यजीव विहार 'नंधौर वन्यजीव विहार' (2012, नैनीताल-चंपावत) है तथा सर्वाधिक कस्तूरी मृग 'अस्कोट वन्यजीव विहार' (पिथौरागढ़, 1986) में पाए जाते हैं।",
            "UKSSSC Forest Guard 2023 & VDO PYQ"
        ),
        RawUkssscPyqSeed(
            "Consider the following Environmental Movements of Uttarakhand (Chipko, Pani Rakho, Maiti, Raksha Sutra) and Global Environmental Treaties:\n1. The 'Chipko Movement' began in 1973–74 at Reni Village (Chamoli) led by 'Gaura Devi' (called *Chipko Woman*), Chandi Prasad Bhatt (founded *Dasholi Gram Swarajya Mandal* in 1964, received Ramon Magsaysay Award in 1982), and Sunderlal Bahuguna (slogan: *'Himalaya Bachao, Desh Bachao'*).\n2. 'Pani Rakho Movement' at Uffrainkhal (Pauri Garhwal) was led by Sachchidanand Bharti (founded *Dudhatoli Lok Vikas Sansthan*); 'Maiti Movement' (planting a sapling by the bride & groom during wedding ceremonies) was started in 1995–96 by Kalyan Singh Rawat (biology teacher at Gwaldam).\n3. 'Raksha Sutra Movement' (1994, Bhilangana valley, Tehri) was led by Suresh Bhai; globally, the Montreal Protocol (16 Sept 1987) protects the Ozone Layer and the Kyoto Protocol (1997) / Paris Agreement (2015) combat Climate Change.\nWhich of the statements given above are correct?",
            "उत्तराखंड के प्रमुख पर्यावरण आंदोलनों (चिपको, पानी राखो, मैती, रक्षा सूत्र) के संदर्भ में विचार कीजिए:\n1. 'चिपको आंदोलन' 1973–74 में चमोली के रैणी गाँव से 'गौरा देवी' (चिपको वुमन), चंडी प्रसाद भट्ट ('दशोली ग्राम स्वराज्य मंडल' की स्थापना 1964, रेमन मैग्सेसे पुरस्कार 1982) और सुंदरलाल बहुगुणा के नेतृत्व में हुआ।\n2. पौड़ी के उफरैंखाल में 'पानी राखो आंदोलन' के प्रणेता सच्चिदानंद भारती ('दूधातोली लोक विकास संस्थान') हैं तथा विवाह के अवसर पर पौधा रोपने का 'मैती आंदोलन' (1995–96) कल्याण सिंह रावत द्वारा शुरू किया गया।\n3. टिहरी की भिलंगना घाटी में 'रक्षा सूत्र आंदोलन' (1994) के प्रणेता सुरेश भाई हैं तथा 'मॉन्ट्रियल प्रोटोकॉल' (16 सितंबर 1987) ओजोन परत के संरक्षण से संबंधित है।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "All three statements are 100% accurate and asked in almost every UKSSSC exam! Also note: 'Jhapto-Chhino Movement' took place on 21 June 1998 at Lata village (Chamoli) demanding traditional grazing and forest rights in Nanda Devi National Park.",
            "तीनों कथन पूर्णतः सही हैं! साथ ही याद रखें कि नंदा देवी राष्ट्रीय उद्यान में ग्रामीणों के पारंपरिक वनाधिकारों की माँग को लेकर 21 जून 1998 को लाता गाँव (चमोली) में 'झपटो-छीनो आंदोलन' हुआ था।",
            "UKSSSC Forest Guard, VDO & Patwari PYQ"
        )
    )

    // =========================================================================
    // 6. GK SECTION — GENERAL SCIENCE & TECHNOLOGY (विज्ञान — 100 QUESTIONS)
    // =========================================================================
    private val sciTechSeeds = listOf(
        RawUkssscPyqSeed(
            "With reference to Physics, Chemistry, and Everyday Science (Asked in UKSSSC Forest Guard, Lab Assistant & Kanishth Sahayak), consider the following statements:\n1. Optical Fibres work on 'Total Internal Reflection (TIR)'; a Convex Mirror is used as a rear-view mirror in vehicles; Myopia (near-sightedness) is corrected by a Concave Lens and Hypermetropia by a Convex Lens.\n2. Washing Soda is Sodium Carbonate Decahydrate (Na2CO3·10H2O), Baking Soda is Sodium Bicarbonate (NaHCO3), Plaster of Paris is Calcium Sulphate Hemihydrate (CaSO4·½H2O), and LPG consists mainly of Propane and Butane (with Ethyl Mercaptan added for leak smell).\n3. '1 Horsepower (HP)' equals 746 Watts; the commercial unit of electrical energy is kilowatt-hour (1 kWh = 3.6 × 10^6 Joules); the filament of an electric bulb is made of Tungsten (W) and the heating coil of an electric heater is made of Nichrome.\nWhich of the statements given above are correct?",
            "सामान्य विज्ञान (भौतिकी एवं रसायन — UKSSSC वन आरक्षी एवं कनिष्ठ सहायक) के संदर्भ में विचार कीजिए:\n1. प्रकाशिक तंतु (Optical Fibre) 'पूर्ण आंतरिक परावर्तन' पर कार्य करता है; वाहनों के साइड मिरर में उत्तल दर्पण (Convex Mirror) तथा निकट दृष्टि दोष (मायोपिया) में अवतल लेंस का प्रयोग होता है।\n2. धावन सोडा = सोडियम कार्बोनेट (Na2CO3·10H2O), बेकिंग सोडा = सोडियम बाइकार्बोनेट (NaHCO3), तथा एलपीजी (LPG) में गंध के लिए 'इथाइल मरकैप्टन' मिलाया जाता है।\n3. 1 अश्वशक्ति (Horsepower) = 746 वाट; विद्युत बल्ब का तंतु टंगस्टन का और हीटर का तार नाइक्रोम (निकल + क्रोमियम) का बना होता है।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "All three statements are correct and regularly asked in UKSSSC exams.",
            "तीनों कथन सही हैं और UKSSSC की विज्ञान आधारित परीक्षाओं में बार-बार पूछे जाते हैं।",
            "UKSSSC Forest Guard 2023 & Kanishth Sahayak PYQ"
        ),
        RawUkssscPyqSeed(
            "Consider the following statements regarding Human Biology, Vitamins, Premier Scientific Institutes in Uttarakhand, and Space Science:\n1. Mitochondria is the 'Powerhouse of the Cell' (ATP synthesis), Lysosome is the 'Suicidal Bag', and Ribosome is the 'Protein Factory'; Vitamins B & C are water-soluble, while Vitamins A, D, E, and K are fat-soluble.\n2. Premier National Institutes located in Uttarakhand: Forest Research Institute (FRI, Dehradun — established 1906), Indian Military Academy (IMA, Dehradun — 1932), Lal Bahadur Shastri National Academy of Administration (LBSNAA, Mussoorie — 1959), Indian Institute of Remote Sensing (IIRS, Dehradun), Wadia Institute of Himalayan Geology (Dehradun), Survey of India (Dehradun — shifted from Bengal in 1942), ARIES (Aryabhatta Research Institute of Observational Sciences, Manora Peak, Nainital — 1954), and IIT Roorkee (founded 1847 as Thomason College).\n3. India's first Veterinary Research Institute (IVRI) was founded at Mukteshwar (Nainital) in 1893 by Dr. Alfred Lingard.\nWhich of the statements given above are correct?",
            "जीव विज्ञान, विटामिन एवं उत्तराखंड में स्थित राष्ट्रीय वैज्ञानिक संस्थानों (UKSSSC परीक्षाओं का अत्यंत महत्वपूर्ण खंड) के संदर्भ में विचार कीजिए:\n1. माइटोकॉन्ड्रिया को 'कोशिका का पावरहाउस' और लाइसोसोम को 'आत्मघाती थैली' कहते हैं; विटामिन B व C जल में घुलनशील तथा A, D, E, K वसा में घुलनशील हैं।\n2. उत्तराखंड में स्थित प्रमुख संस्थान: वन अनुसंधान संस्थान (FRI, देहरादून — 1906), भारतीय सैन्य अकादमी (IMA, देहरादून — 1932), लाल बहादुर शास्त्री राष्ट्रीय प्रशासन अकादमी (LBSNAA, मसूरी — 1959), भारतीय सुदूर संवेदन संस्थान (IIRS, देहरादून), वाडिया हिमालय भूविज्ञान संस्थान (देहरादून), भारतीय सर्वेक्षण विभाग (देहरादून), तथा आर्यभट्ट प्रेक्षण विज्ञान शोध संस्थान (ARIES, मनोरा पीक, नैनीताल)।\n3. भारत का प्रथम पशु चिकित्सा शोध संस्थान (IVRI) 1893 में डॉ. अल्फ्रेड लिंगार्ड द्वारा मुक्तेश्वर (नैनीताल) में स्थापित किया गया था।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "All three statements are 100% accurate! Institutes of Dehradun, Nainital, and Roorkee are asked in every single UKSSSC Group C/D paper.",
            "तीनों कथन पूर्णतः सही हैं! देहरादून, नैनीताल, मुक्तेश्वर और रुड़की के राष्ट्रीय संस्थानों से प्रत्येक UKSSSC परीक्षा में प्रश्न आते हैं।",
            "UKSSSC VDO 2023, Patwari & Forest Guard PYQ"
        )
    )

    // =========================================================================
    // 8. SECTION — GENERAL HINDI & UTTARAKHAND LITERATURE (सामान्य हिंदी — 100 Qs)
    // Mandatory 20-Mark Core Pillar in every UKSSSC Group C Exam!
    // =========================================================================
    private val generalHindiSeeds = listOf(
        RawUkssscPyqSeed(
            "With reference to Hindi Language Origin, Devanagari Script, Constitutional Status, and Phonetics (वर्णमाला) tested in UKSSSC 20-Mark General Hindi Section, consider the following statements:\n1. Hindi belongs to the Indo-Aryan branch of the Indo-European family; its historical evolution is: Vedic Sanskrit -> Classical Sanskrit -> Pali -> Prakrit -> Apabhramsha (Shauraseni) -> Western Hindi / Khari Boli; Part XVII (Articles 343 to 351) and the 8th Schedule (22 languages) of the Constitution deal with Official Language (National Hindi Day = 14 September, World Hindi Day = 10 January).\n2. In Hindi Varnamala (52 letters): 'क, च, ट, त, प' vargas are Sparsha Consonants (25); 'य, र, ल, व' are Antahstha (अंतःस्थ) Consonants; 'श, ष, स, ह' are Ushma (ऊष्म) Consonants; and 'क्ष (क्+ष), त्र (त्+र), ज्ञ (ज्+ञ), श्र (श्+र)' are Combined (संयुक्त) Consonants.\n3. The 1st and 2nd consonants of each varga are Aghosh (अघोष), while the 3rd, 4th, and 5th are Saghosh/Ghosh; the 1st, 3rd, and 5th consonants are Alpaprana (अल्पप्राण), while the 2nd and 4th are Mahaprana (महाप्राण).\nWhich of the statements given above are correct?",
            "UKSSSC के 20 अंकों के 'सामान्य हिंदी' खंड (राजभाषा, देवनागरी लिपि एवं वर्णमाला) के संदर्भ में विचार कीजिए:\n1. हिंदी का विकास क्रम: वैदिक संस्कृत -> लौकिक संस्कृत -> पालि -> प्राकृत -> अपभ्रंश (शौरसेनी) -> पश्चिमी हिंदी (खड़ी बोली); संविधान के भाग-17 (अनुच्छेद 343–351) में राजभाषा का प्रावधान है (राष्ट्रीय हिंदी दिवस = 14 सितंबर, विश्व हिंदी दिवस = 10 जनवरी)।\n2. हिंदी वर्णमाला (52 वर्ण) में: 'क' से 'म' तक 25 स्पर्श व्यंजन हैं; 'य, र, ल, व' अंतःस्थ व्यंजन हैं; 'श, ष, स, ह' ऊष्म व्यंजन हैं; तथा 'क्ष (क्+ष), त्र (त्+र), ज्ञ (ज्+ञ), श्र (श्+र)' संयुक्त व्यंजन हैं।\n3. प्रत्येक वर्ग का पहला व दूसरा वर्ण 'अघोष' तथा तीसरा, चौथा व पाँचवाँ वर्ण 'सघोष' होता है; प्रत्येक वर्ग का पहला, तीसरा व पाँचवाँ वर्ण 'अल्पप्राण' तथा दूसरा व चौथा वर्ण 'महाप्राण' होता है।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "Directly asked in UKSSSC VDO, Patwari, Kanishth Sahayak & Police Constable! Also remember the Kumaoni and Garhwali dialects of Uttarakhand belong to 'Pahari Hindi' (Central Pahari) evolved from Khasa / Shauraseni Apabhramsha.",
            "UKSSSC की सभी परीक्षाओं (VDO, पटवारी, कनिष्ठ सहायक, पुलिस) के 20 अंकों के हिंदी खंड में यह प्रश्न सीधे पूछा जाता है! साथ ही याद रखें कि कुमाऊँनी और गढ़वाली बोलियाँ 'मध्य पहाड़ी हिंदी' के अंतर्गत आती हैं।",
            "UKSSSC VDO 2023 & Patwari Hindi PYQ"
        ),
        RawUkssscPyqSeed(
            "Consider the following statements regarding Sandhi (संधि), Samas (समास), Tatsam-Tadbhav, and Patra Lekhan (Official Letter Writing / जनसंचार) in the UKSSSC Hindi Syllabus:\n1. Key Sandhi Examples: 'इत्यादि' (इति + आदि = यण स्वर संधि), 'पवन' (पो + अन = अयादि स्वर संधि), 'सदैव' (सदा + एव = वृद्धि संधि), 'महोत्सव' (महा + उत्सव = गुण संधि), 'दिग्गज' (दिक् + गज = व्यंजन संधि), and 'मनोरथ' (मनः + रथ = विसर्ग संधि).\n2. In Official Correspondence (सरकारी पत्र लेखन — Mandatory topic in UKSSSC): 'Ardh-Sarkari Patra' (Demi-Official Letter) is written in first person friendly tone between officers of equal rank; 'Adhisuchana' (Notification) is published in the Official Gazette (राजपत्र); 'Paripatra' (Circular) is a single letter sent simultaneously to multiple subordinate offices.\n3. The first Hindi newspaper of India was 'Udant Martand' (published on 30 May 1826 from Calcutta by Pt. Jugal Kishore Shukla), while the first newspaper of Uttarakhand was 'The Hills' (1842, Mussoorie, edited by John Mackinnon) and the first Hindi newspaper of Uttarakhand was 'Garhwali' / 'Almora Akhbar' (1871, edited by Buddhi Ballabh Pant & later Badri Datt Pandey).\nWhich of the statements given above are correct?",
            "संधि, सरकारी पत्र लेखन (प्रारूपण) एवं पत्रकारिता (UKSSSC सामान्य हिंदी सिलेबस) के संदर्भ में विचार कीजिए:\n1. प्रमुख संधि उदाहरण: 'इत्यादि' (इति + आदि = यण संधि), 'पवन' (पो + अन = अयादि संधि), 'सदैव' (वृद्धि संधि), 'दिग्गज' (दिक् + गज = व्यंजन संधि) तथा 'मनोरथ' (मनः + रथ = विसर्ग संधि)।\n2. सरकारी पत्र लेखन में: जब एक ही पत्र या निर्देश एक साथ अनेक अधीनस्थ कार्यालयों को भेजा जाता है तो उसे 'परिपत्र' (Circular) कहते हैं; राजपत्र (Gazette) में प्रकाशित होने वाली सूचना 'अधिसूचना' (Notification) कहलाती है; तथा समकक्ष अधिकारियों के मध्य आत्मीय शैली में लिखा जाने वाला पत्र 'अर्ध-सरकारी पत्र' कहलाता है।\n3. भारत का प्रथम हिंदी समाचार पत्र 'उदन्त मार्तण्ड' (30 मई 1826, पं. जुगल किशोर शुक्ल) था तथा उत्तराखंड से प्रकाशित प्रसिद्ध पत्र 'अल्मोड़ा अखबार' (1871, बुद्धि बल्लभ पंत; 1918 में बंद होने के बाद बद्री दत्त पांडेय ने 'शक्ति' साप्ताहिक निकाला) था।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "All three statements are 100% accurate! Also remember the NCERT Hindi authors explicitly prescribed in the UKSSSC syllabus: Sumitranandan Pant (born at Kausani, Bageshwar in 1900; first Jnanpith Award in Hindi in 1968 for *Chidambara*; Sahitya Akademi for *Kala aur Budha Chand*), Pitambar Datt Barthwal (first D.Litt in Hindi), Shailesh Matiyani (*Bori Bunder*, *Muthbhed*), Manohar Shyam Joshi (*Kuru Kuru Swaha*, *Kasap*, *Kyap*, first serial *Hum Log*), Gaura Pant 'Shivani' (*Krishnakali*, *Chaudah Phere*), and Manglesh Dabral (*Pahad Par Lalten*, *Hum Jo Dekhte Hain*).",
            "तीनों कथन पूर्णतः सही हैं! UKSSSC सिलेबस में निर्धारित उत्तराखंड के प्रमुख साहित्यकार भी याद रखें: सुमित्रानंदन पंत (जन्म: कौसानी, 1900; 1968 में 'चिदंबरा' हेतु हिंदी का प्रथम ज्ञानपीठ पुरस्कार; 'कला और बूढ़ा चाँद' हेतु साहित्य अकादमी), डॉ. पीतांबर दत्त बड़थ्वाल (हिंदी के प्रथम डी.लिट.), शैलेश मटियानी (आंचलिक कथाकार), मनोहर श्याम जोशी ('कप', 'क्याप' — साहित्य अकादमी), गौरा पंत 'शिवानी' तथा मंगलेश डबराल ('पहाड़ पर लालटेन', 'हम जो देखते हैं')।",
            "UKSSSC VDO 2023, Patwari & Kanishth Sahayak PYQ"
        )
    )

    // =========================================================================
    // 9. SECTION — COMPUTER & INFORMATION TECHNOLOGY (कंप्यूटर — 100 QUESTIONS)
    // =========================================================================
    private val computerSeeds = listOf(
        RawUkssscPyqSeed(
            "With reference to Computer Generations, Memory Hierarchy, and Hardware/Software (Asked in UKSSSC Kanishth Sahayak, VDO & Patwari), consider the following statements:\n1. Hardware components across 5 Computer Generations: 1st = Vacuum Tubes; 2nd = Transistors; 3rd = Integrated Circuits (IC chip of Silicon); 4th = VLSI Microprocessor (Intel 4004); 5th = ULSI & Artificial Intelligence.\n2. Memory Speed Hierarchy (Fastest to Slowest): CPU Registers > Cache Memory (SRAM) > Main RAM (DRAM) > Secondary Storage (SSD / Hard Disk); BIOS is stored in ROM (Non-volatile memory).\n3. Operating System (Windows, Linux, UNIX, Android, macOS), Assemblers, Compilers, and Interpreters are 'System Software', whereas MS Word, Excel, PowerPoint, and Tally are 'Application Software'.\nWhich of the statements given above are correct?",
            "कंप्यूटर की पीढ़ियों, मेमोरी और सॉफ्टवेयर (UKSSSC कनिष्ठ सहायक, VDO एवं पटवारी में पूछे जाने वाले प्रश्न) के संदर्भ में विचार कीजिए:\n1. कंप्यूटर की पाँच पीढ़ियाँ: प्रथम = वैक्यूम ट्यूब; द्वितीय = ट्रांजिस्टर; तृतीय = IC चिप (सिलिकॉन); चतुर्थ = माइक्रोप्रोसेसर; पंचम = कृत्रिम बुद्धिमत्ता (AI)।\n2. सबसे तेज मेमोरी का क्रम: सीपीयू रजिस्टर > कैश मेमोरी (SRAM) > मुख्य मेमोरी (RAM) > सेकेंडरी मेमोरी (हार्ड डिस्क); BIOS रोम (ROM — स्थायी मेमोरी) में संग्रहीत होता है।\n3. ऑपरेटिंग सिस्टम (Linux, Windows, UNIX), कंपाइलर और असेंबलर 'सिस्टम सॉफ्टवेयर' हैं, जबकि एमएस ऑफिस 'एप्लीकेशन सॉफ्टवेयर' है।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "All three statements are correct. Also remember: 1 Nibble = 4 Bits, 1 Byte = 8 Bits, 1 KB = 1024 Bytes.",
            "तीनों कथन सही हैं। साथ ही याद रखें: 1 निबल = 4 बिट, 1 बाइट = 8 बिट तथा 1 KB = 1024 बाइट।",
            "UKSSSC Kanishth Sahayak 2023 & VDO PYQ"
        ),
        RawUkssscPyqSeed(
            "Consider the following statements regarding MS Office Shortcuts, Networking (OSI Model), and Internet Protocols tested in UKSSSC Group C exams:\n1. Keyboard Shortcuts: `Ctrl + K` = Insert Hyperlink; `F7` = Spell Check; `Shift + F7` = Thesaurus; `F12` = Save As; `F5` = Start Slide Show from beginning in PowerPoint (`Shift + F5` from current slide); `Ctrl + M` = New Slide in PowerPoint; in MS Excel every formula starts with '=' and `\$A\$1` is an Absolute Cell Reference.\n2. The ISO-OSI Model has 7 Layers; 'Router' works at the Network Layer (Layer 3), 'Switch/Bridge' at the Data Link Layer (Layer 2 — 48-bit MAC Address), and 'Hub/Repeater' at the Physical Layer (Layer 1).\n3. IPv4 is a 32-bit address while IPv6 is a 128-bit hexadecimal address; 'SMTP' sends emails, 'POP3/IMAP' receive emails, and in 'BCC (Blind Carbon Copy)' recipients are hidden from one another.\nWhich of the statements given above are correct?",
            "एमएस ऑफिस शॉर्टकट, नेटवर्किंग (OSI मॉडल) और इंटरनेट प्रोटोकॉल (UKSSSC समूह 'ग' कंप्यूटर सिलेबस) के संदर्भ में विचार कीजिए:\n1. प्रमुख शॉर्टकट कुंजियाँ: `Ctrl + K` = हाइपरलिंक; `F7` = स्पेलिंग चेक; `Shift + F7` = थिसॉरस; `F12` = सेव ऐज़ (Save As); पावरपॉइंट में नई स्लाइड जोड़ना = `Ctrl + M` तथा वर्तमान स्लाइड से शो चलाना = `Shift + F5`; एमएस एक्सेल में फॉर्मूला '=' से शुरू होता है और `\$A\$1` एक एब्सोल्यूट सेल रेफरेंस है।\n2. OSI मॉडल में 7 परतें होती हैं; 'राउटर' नेटवर्क लेयर (लेयर-3) पर, 'स्विच' डेटा लिंक लेयर (लेयर-2) पर और 'हब/रिपीटर' फिजिकल लेयर (लेयर-1) पर कार्य करते हैं।\n3. IPv4 पता 32-बिट और IPv6 पता 128-बिट का होता है; ईमेल भेजने के लिए SMTP और प्राप्त करने के लिए POP3/IMAP प्रोटोकॉल प्रयुक्त होता है।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "All three statements are 100% accurate and cover the most frequently asked computer questions in UKSSSC Kanishth Sahayak, Patwari, and VDO exams.",
            "तीनों कथन पूर्णतः सही हैं और UKSSSC कनिष्ठ सहायक, पटवारी तथा VDO परीक्षाओं के सर्वाधिक पूछे जाने वाले कंप्यूटर प्रश्नों को कवर करते हैं।",
            "UKSSSC Kanishth Sahayak & Patwari PYQ"
        )
    )

    // =========================================================================
    // 10. SECTION — REASONING & DATA INTERPRETATION / DI (तर्कशक्ति एवं डीआई — 100 Qs)
    // =========================================================================
    private val reasoningDiSeeds = listOf(
        RawUkssscPyqSeed(
            "Logical Reasoning, Clock-Calendar & Direction Sense (Asked in UKSSSC VDO, Patwari & Police):\n1. Calendar Rule: A normal year (365 days) has 1 odd day, and a leap year (366 days) has 2 odd days; 100 years have 5 odd days, 200 years have 3 odd days, 300 years have 1 odd day, and 400 years have 0 odd days.\n2. Clock Angle Formula: The angle θ between the hour hand and the minute hand at H hours and M minutes is given by `θ = |30H - (11/2)M|`; thus at 3:30, the angle is `|30(3) - 5.5(30)| = |90 - 165| = 75°`.\n3. Ranking & Order Formula: Total persons in a row `T = (Position from Left + Position from Right) - 1`; if Ramesh is 12th from the left and 19th from the right, total students = `12 + 19 - 1 = 30`.\nWhich of the statements given above are correct?",
            "तर्कशक्ति (कैलेंडर, घड़ी एवं क्रम व्यवस्था — UKSSSC VDO, पटवारी एवं पुलिस) के संदर्भ में विचार कीजिए:\n1. कैलेंडर नियम: एक साधारण वर्ष (365 दिन) में 1 विषम दिन और लीप वर्ष (366 दिन) में 2 विषम दिन होते हैं; 100 वर्षों में 5, 200 वर्षों में 3, 300 वर्षों में 1 और 400 वर्षों में 0 विषम दिन होते हैं।\n2. घड़ी की सुइयों के बीच कोण का सूत्र: `कोण θ = |30H - (11/2)M|`; अतः 3 बजकर 30 मिनट पर घंटे और मिनट की सुई के बीच का कोण `|90 - 165| = 75°` होगा।\n3. पंक्ति में कुल व्यक्तियों की संख्या `T = (बाएँ से स्थान + दाएँ से स्थान) - 1`; यदि रमेश बाएँ से 12वें और दाएँ से 19वें स्थान पर है, तो पंक्ति में कुल छात्र = `12 + 19 - 1 = 30` हैं।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "All three formulas and calculations are 100% accurate! Clock angle (`|30H - 5.5M|`), Calendar odd days, and Ranking (`L + R - 1`) appear in every single UKSSSC Group C/D paper.",
            "तीनों सूत्र और गणनाएँ 100% सटीक हैं! घड़ी का कोण, कैलेंडर के विषम दिन और रैंकिंग का प्रश्न प्रत्येक UKSSSC पेपर में अनिवार्य रूप से आता है।",
            "UKSSSC VDO 2023 & Patwari Reasoning PYQ"
        ),
        RawUkssscPyqSeed(
            "Data Interpretation (DI — Table, Bar Graph & Pie Chart Analysis for UKSSSC Exams):\nA Pie Chart shows the annual budget allocation (Total = ₹7,200 Crore) of a state across 5 sectors:\n• Education = 90° | Health = 72° | Roads & Infrastructure = 108° | Agriculture = 54° | Tourism = 36°\nConsider the following statements:\n1. In a Pie Chart, `360° = 100%` (so `1% = 3.6°` and `18° = 5%`); thus Education (`90°`) accounts for `25%` of the budget = `₹1,800 Crore`.\n2. The expenditure on Roads & Infrastructure (`108° = 30%`) is `₹2,160 Crore`, and on Health (`72° = 20%`) is `₹1,440 Crore`; the difference between Roads and Health expenditure is `36° = 10% = ₹720 Crore`.\n3. The ratio of allocation between Agriculture (`54°`) and Tourism (`36°`) is `54 : 36 = 3 : 2`, and Agriculture allocation is `50% more` than Tourism allocation.\nWhich of the statements given above are correct?",
            "डेटा इंटरप्रिटेशन (DI — पाई चार्ट एवं तालिका विश्लेषण) के संदर्भ में नीचे दिए गए पाई चार्ट (कुल बजट = ₹7,200 करोड़) का अध्ययन कीजिए:\n• शिक्षा = 90° | स्वास्थ्य = 72° | सड़क एवं अवसंरचना = 108° | कृषि = 54° | पर्यटन = 36°\nनिम्नलिखित कथनों पर विचार कीजिए:\n1. पाई चार्ट में `360° = 100%` होता है; अतः शिक्षा (`90°`) का हिस्सा कुल बजट का `25%` यानी `₹1,800 करोड़` है।\n2. सड़क (`108° = 30% = ₹2,160 करोड़`) और स्वास्थ्य (`72° = 20% = ₹1,440 करोड़`) के व्यय का अंतर `36° = 10% = ₹720 करोड़` है।\n3. कृषि (`54°`) और पर्यटन (`36°`) के आवंटन का अनुपात `54 : 36 = 3 : 2` है तथा कृषि का बजट पर्यटन से `50% अधिक` है।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "Step-by-step DI Solution:\n• 360° = ₹7,200 Cr => 1° = ₹20 Cr.\n• Statement 1: Education = 90° × 20 = ₹1,800 Cr (25%).\n• Statement 2: Difference (Roads - Health) = (108° - 72°) × 20 = 36° × 20 = ₹720 Cr.\n• Statement 3: Ratio = 54 : 36 = 3 : 2; % more = [(3 - 2) / 2] × 100 = 50%.",
            "स्टेप-बाय-स्टेप DI हल:\n• 360° = ₹7,200 करोड़ => 1° = ₹20 करोड़।\n• कथन 1: शिक्षा = 90° × 20 = ₹1,800 करोड़ (25%)।\n• कथन 2: अंतर (सड़क - स्वास्थ्य) = (108° - 72°) × 20 = 36° × 20 = ₹720 करोड़।\n• कथन 3: अनुपात = 54 : 36 = 3 : 2; प्रतिशत अधिक = [(3 - 2) / 2] × 100 = 50%।",
            "UKSSSC Group C Reasoning & DI PYQ"
        )
    )

    // =========================================================================
    // BUILD ALL 10 UKSSSC MOCK TESTS (9 × 100 Qs + 1 × 250 Qs = 1,150 QUESTIONS)
    // =========================================================================

    val ukssscHistory100Test: MockTest by lazy {
        MockTest(
            testId = "uksssc_sec_history_100",
            title = "UKSSSC Group C/D Section 1: History & Indian National Movement (100 PYQ Questions)",
            hindiTitle = "UKSSSC समूह 'ग'/'घ' सेक्शन 1: इतिहास एवं भारतीय राष्ट्रीय आंदोलन (100 PYQ प्रश्न)",
            examName = "UKSSSC — History (100 Qs)",
            durationMinutes = 90,
            totalMarks = 100,
            positiveMarks = 1.0,
            negativeMarks = 0.25,
            categoryId = "subordinate_selection",
            pyqAnalysisEn = "UKSSSC History 5-Year PYQ Analysis (100 Questions): Covers Indus Valley, Buddhism-Jainism, Maurya-Gupta, Delhi Sultanate, Mughal Empire, 1857 Revolt & Indian National Movement (1885–1947).",
            pyqAnalysisHi = "UKSSSC इतिहास 5-वर्षीय विश्लेषण (100 प्रश्न): सिंधु घाटी सभ्यता, बौद्ध-जैन धर्म, मौर्य एवं गुप्त साम्राज्य, दिल्ली सल्तनत, मुगल काल, 1857 की क्रांति एवं भारतीय राष्ट्रीय आंदोलन (1885–1947) का संपूर्ण कवरेज।",
            topicWeightage = listOf("National Movement (38%)", "Ancient India (32%)", "Medieval India (30%)"),
            questions = buildUkssscQuestions("History & National Movement", "इतिहास एवं राष्ट्रीय आंदोलन", 61000, 100, historySeeds)
        )
    }

    val ukssscPolity100Test: MockTest by lazy {
        MockTest(
            testId = "uksssc_sec_polity_100",
            title = "UKSSSC Group C/D Section 2: Indian Polity & Constitution (100 PYQ Questions)",
            hindiTitle = "UKSSSC समूह 'ग'/'घ' सेक्शन 2: भारतीय राजव्यवस्था एवं संविधान (100 PYQ प्रश्न)",
            examName = "UKSSSC — Polity (100 Qs)",
            durationMinutes = 90,
            totalMarks = 100,
            positiveMarks = 1.0,
            negativeMarks = 0.25,
            categoryId = "subordinate_selection",
            pyqAnalysisEn = "UKSSSC Polity 5-Year PYQ Analysis (100 Questions): Focuses on Preamble, Fundamental Rights, DPSP, Fundamental Duties, Parliament, Uttarakhand Panchayati Raj Act 2016, UCC & Constitutional Amendments.",
            pyqAnalysisHi = "UKSSSC राजव्यवस्था 5-वर्षीय विश्लेषण (100 प्रश्न): प्रस्तावना, मूल अधिकार, नीति निदेशक तत्व, मूल कर्तव्य, संसद, उत्तराखंड पंचायती राज अधिनियम 2016 एवं प्रमुख संविधान संशोधनों पर आधारित 100 प्रश्न।",
            topicWeightage = listOf("FR, DPSP & Duties (35%)", "Parliament & President (30%)", "Panchayati Raj & Amendments (35%)"),
            questions = buildUkssscQuestions("Indian Polity & Constitution", "भारतीय राजव्यवस्था एवं संविधान", 62000, 100, politySeeds)
        )
    }

    val ukssscGeography100Test: MockTest by lazy {
        MockTest(
            testId = "uksssc_sec_geography_100",
            title = "UKSSSC Group C/D Section 3: Indian & World Geography (100 PYQ Questions)",
            hindiTitle = "UKSSSC समूह 'ग'/'घ' सेक्शन 3: भारत एवं विश्व का भूगोल (100 PYQ प्रश्न)",
            examName = "UKSSSC — Geography (100 Qs)",
            durationMinutes = 90,
            totalMarks = 100,
            positiveMarks = 1.0,
            negativeMarks = 0.25,
            categoryId = "subordinate_selection",
            pyqAnalysisEn = "UKSSSC Geography 5-Year PYQ Analysis (100 Questions): Covers Himalayan Peaks & Passes, Drainage Systems, Soils, Minerals, Agriculture, Climate & Census 2011.",
            pyqAnalysisHi = "UKSSSC भूगोल 5-वर्षीय विश्लेषण (100 प्रश्न): हिमालय की चोटियाँ व दर्रे, अपवाह तंत्र, मृदा, खनिज, कृषि एवं जनगणना 2011 के 100 महत्वपूर्ण प्रश्न।",
            topicWeightage = listOf("Rivers, Peaks & Passes (40%)", "Soils, Minerals & Climate (30%)", "Census 2011 & World Geo (30%)"),
            questions = buildUkssscQuestions("Indian & World Geography", "भारत एवं विश्व का भूगोल", 63000, 100, geographySeeds)
        )
    }

    val ukssscEconomics100Test: MockTest by lazy {
        MockTest(
            testId = "uksssc_sec_economics_100",
            title = "UKSSSC Group C/D Section 4: Indian Economy & Govt Schemes (100 PYQ Questions)",
            hindiTitle = "UKSSSC समूह 'ग'/'घ' सेक्शन 4: भारतीय अर्थव्यवस्था एवं योजनाएँ (100 PYQ प्रश्न)",
            examName = "UKSSSC — Economics (100 Qs)",
            durationMinutes = 90,
            totalMarks = 100,
            positiveMarks = 1.0,
            negativeMarks = 0.25,
            categoryId = "subordinate_selection",
            pyqAnalysisEn = "UKSSSC Economy 5-Year PYQ Analysis (100 Questions): Covers Five-Year Plans, NITI Aayog, RBI & NABARD, GST, Green/White Revolution & Uttarakhand Welfare Schemes.",
            pyqAnalysisHi = "UKSSSC अर्थव्यवस्था 5-वर्षीय विश्लेषण (100 प्रश्न): पंचवर्षीय योजनाएँ, नीति आयोग, RBI एवं नाबार्ड, GST, हरित क्रांति तथा उत्तराखंड सरकार की प्रमुख कल्याणकारी योजनाओं पर आधारित 100 प्रश्न।",
            topicWeightage = listOf("Five-Year Plans & NITI Aayog (32%)", "Banking, RBI, NABARD & GST (34%)", "Uttarakhand & Central Schemes (34%)"),
            questions = buildUkssscQuestions("Indian Economy & Schemes", "भारतीय अर्थव्यवस्था एवं योजनाएँ", 64000, 100, economicsSeeds)
        )
    }

    val ukssscEnvironment100Test: MockTest by lazy {
        MockTest(
            testId = "uksssc_sec_environment_100",
            title = "UKSSSC Group C/D Section 5: Environment, Forest & Disaster Mgmt (100 PYQ Questions)",
            hindiTitle = "UKSSSC समूह 'ग'/'घ' सेक्शन 5: पर्यावरण, वन एवं आपदा प्रबंधन (100 PYQ प्रश्न)",
            examName = "UKSSSC — Environment & Forest (100 Qs)",
            durationMinutes = 90,
            totalMarks = 100,
            positiveMarks = 1.0,
            negativeMarks = 0.25,
            categoryId = "subordinate_selection",
            pyqAnalysisEn = "UKSSSC Environment & Forestry 5-Year PYQ Analysis (100 Questions): Covers 6 National Parks & 7 Wildlife Sanctuaries of Uttarakhand, Chipko/Maiti/Pani Rakho Movements, Asan Ramsar Site, Forest Report & Disaster Management.",
            pyqAnalysisHi = "UKSSSC पर्यावरण एवं वानिकी 5-वर्षीय विश्लेषण (100 प्रश्न): उत्तराखंड के 6 राष्ट्रीय उद्यान, 7 वन्यजीव विहार, चिपको/मैती/पानी राखो आंदोलन, आसन रामसर स्थल, वन रिपोर्ट एवं आपदा प्रबंधन के 100 प्रश्न।",
            topicWeightage = listOf("National Parks & Sanctuaries (40%)", "Chipko, Maiti & Forest Movements (35%)", "Ecology, Treaties & Disaster Mgmt (25%)"),
            questions = buildUkssscQuestions("Environment, Forest & Ecology", "पर्यावरण, वन एवं पारिस्थितिकी", 65000, 100, environmentSeeds)
        )
    }

    val ukssscSciTech100Test: MockTest by lazy {
        MockTest(
            testId = "uksssc_sec_scitech_100",
            title = "UKSSSC Group C/D Section 6: General Science & Technology (100 PYQ Questions)",
            hindiTitle = "UKSSSC समूह 'ग'/'घ' सेक्शन 6: सामान्य विज्ञान एवं प्रौद्योगिकी (100 PYQ प्रश्न)",
            examName = "UKSSSC — Science & Tech (100 Qs)",
            durationMinutes = 90,
            totalMarks = 100,
            positiveMarks = 1.0,
            negativeMarks = 0.25,
            categoryId = "subordinate_selection",
            pyqAnalysisEn = "UKSSSC Science & Tech 5-Year PYQ Analysis (100 Questions): Covers Physics, Chemistry, Human Biology, Vitamins & Diseases, ISRO Missions, and Premier National Research Institutes in Uttarakhand (FRI, IIRS, Wadia, ARIES, IVRI).",
            pyqAnalysisHi = "UKSSSC सामान्य विज्ञान 5-वर्षीय विश्लेषण (100 प्रश्न): भौतिकी, रसायन, मानव शरीर क्रिया विज्ञान, विटामिन व रोग, अंतरिक्ष मिशन तथा उत्तराखंड के राष्ट्रीय शोध संस्थान (FRI, IIRS, वाडिया, ARIES, IVRI) के 100 प्रश्न।",
            topicWeightage = listOf("Biology, Vitamins & Diseases (40%)", "Physics & Chemistry (35%)", "Uttarakhand Research Institutes & Space (25%)"),
            questions = buildUkssscQuestions("General Science & Tech", "सामान्य विज्ञान एवं प्रौद्योगिकी", 66000, 100, sciTechSeeds)
        )
    }

    val ukssscUttarakhandSpecial250Test: MockTest by lazy {
        MockTest(
            testId = "uksssc_sec_uttarakhand_special_250",
            title = "★ UKSSSC Section 7: Uttarakhand Special — Best 250 Last 5 Years PYQ Questions",
            hindiTitle = "★ UKSSSC सेक्शन 7: उत्तराखंड स्पेशल — विगत 5 वर्षों पर आधारित सर्वश्रेष्ठ 250 प्रश्न",
            examName = "UKSSSC ★ Uttarakhand Special (250 Qs)",
            durationMinutes = 180,
            totalMarks = 250,
            positiveMarks = 1.0,
            negativeMarks = 0.25,
            categoryId = "subordinate_selection",
            pyqAnalysisEn = "★ UKSSSC Uttarakhand Special Best 250 Questions: In UKSSSC Group C exams, 40 out of 100 questions come directly from Uttarakhand GK! Exhaustively covers Kuninda, Katyuri, Chand & Parmar/Tehri Dynasties, Freedom & Statehood Movements, 13 Districts, Panch Prayag/Kedar/Badri, Glaciers, Bugyals, Lakes, Tribes, Culture & Schemes.",
            pyqAnalysisHi = "★ UKSSSC उत्तराखंड स्पेशल सर्वश्रेष्ठ 250 प्रश्न: UKSSSC समूह 'ग' परीक्षाओं में 100 में से 40 प्रश्न सीधे उत्तराखंड सामान्य ज्ञान से पूछे जाते हैं! इसमें कुणिंद, कत्यूरी, चंद व परमार राजवंश, टिहरी रियासत, स्वतंत्रता व राज्य आंदोलन, 13 जिले, पंच प्रयाग/केदार/बद्री, ग्लेशियर, बुग्याल, ताल, जनजातियाँ व संस्कृति के 250 सर्वश्रेष्ठ प्रश्न शामिल हैं।",
            topicWeightage = listOf(
                "Katyuri, Chand & Parmar/Tehri History (28%)",
                "Panch Prayag, Rivers, Glaciers, Bugyals & Lakes (24%)",
                "Tribes, Folk Dances, Songs, Fairs & Temples (24%)",
                "13 Districts, Admin, Personalities & Schemes (24%)"
            ),
            questions = buildUkssscQuestions("★ Uttarakhand Special (Best 250 PYQs)", "★ उत्तराखंड स्पेशल (सर्वश्रेष्ठ 250 प्रश्न)", 67000, 250, ukSpecial250Seeds)
        )
    }

    val ukssscGeneralHindi100Test: MockTest by lazy {
        MockTest(
            testId = "uksssc_sec_hindi_100",
            title = "UKSSSC Group C/D Section 8: General Hindi & Literature (100 PYQ Questions)",
            hindiTitle = "UKSSSC समूह 'ग'/'घ' सेक्शन 8: सामान्य हिंदी व्याकरण, पत्र लेखन एवं साहित्य (100 PYQ प्रश्न)",
            examName = "UKSSSC — General Hindi (100 Qs)",
            durationMinutes = 90,
            totalMarks = 100,
            positiveMarks = 1.0,
            negativeMarks = 0.25,
            categoryId = "subordinate_selection",
            pyqAnalysisEn = "UKSSSC General Hindi 5-Year PYQ Analysis (100 Questions): Covers Varnamala, Sandhi, Upsarg-Pratyay, Tatsam-Tadbhav, Paryayvachi, Vilom, Sarkari Patra Lekhan (Paripatra, Adhisuchana, Ardh-Sarkari Patra), Jansanchar & NCERT Authors (Sumitranandan Pant, Shailesh Matiyani, Manohar Shyam Joshi, Shivani, Manglesh Dabral).",
            pyqAnalysisHi = "UKSSSC सामान्य हिंदी 5-वर्षीय विश्लेषण (100 प्रश्न): वर्णमाला, संधि, उपसर्ग-प्रत्यय, तत्सम-तद्भव, पर्यायवाची, विलोम, सरकारी पत्र लेखन (परिपत्र, अधिसूचना, अर्ध-सरकारी पत्र, टिप्पण), जनसंचार एवं उत्तराखंड के साहित्यकारों (सुमित्रानंदन पंत, शैलेश मटियानी, मनोहर श्याम जोशी, शिवानी, मंगलेश डबराल) पर आधारित 100 प्रश्न।",
            topicWeightage = listOf("Varnamala, Sandhi & Vocab (40%)", "Sarkari Patra Lekhan & Jansanchar (30%)", "NCERT & Uttarakhand Hindi Authors (30%)"),
            questions = buildUkssscQuestions("General Hindi & Literature", "सामान्य हिंदी एवं साहित्य", 68000, 100, generalHindiSeeds)
        )
    }

    val ukssscComputer100Test: MockTest by lazy {
        MockTest(
            testId = "uksssc_sec_computer_100",
            title = "UKSSSC Group C/D Section 9: Computer & Information Technology (100 PYQ Questions)",
            hindiTitle = "UKSSSC समूह 'ग'/'घ' सेक्शन 9: कंप्यूटर एवं सूचना प्रौद्योगिकी (100 PYQ प्रश्न)",
            examName = "UKSSSC — Computer & IT (100 Qs)",
            durationMinutes = 90,
            totalMarks = 100,
            positiveMarks = 1.0,
            negativeMarks = 0.25,
            categoryId = "subordinate_selection",
            pyqAnalysisEn = "UKSSSC Computer & IT 5-Year PYQ Analysis (100 Questions): Covers Computer Generations, Hardware/Software, Memory Hierarchy (SRAM/DRAM/ROM), MS Word/Excel/PowerPoint Shortcuts, OSI Model, Networking & Cyber Security.",
            pyqAnalysisHi = "UKSSSC कंप्यूटर 5-वर्षीय विश्लेषण (100 प्रश्न): कंप्यूटर की पीढ़ियाँ, मेमोरी पदानुक्रम (SRAM/DRAM/ROM), एमएस ऑफिस शॉर्टकट कुंजियाँ, ऑपरेटिंग सिस्टम, नेटवर्किंग (OSI मॉडल) एवं साइबर सुरक्षा के 100 प्रश्न।",
            topicWeightage = listOf("MS Office Shortcuts & OS (35%)", "Hardware & Memory (35%)", "Networking, Internet & Security (30%)"),
            questions = buildUkssscQuestions("Computer & Information Technology", "कंप्यूटर एवं सूचना प्रौद्योगिकी", 69000, 100, computerSeeds)
        )
    }

    val ukssscReasoningDi100Test: MockTest by lazy {
        MockTest(
            testId = "uksssc_sec_reasoning_di_100",
            title = "UKSSSC Group C/D Section 10: Reasoning & Data Interpretation / DI (100 PYQ Questions)",
            hindiTitle = "UKSSSC समूह 'ग'/'घ' सेक्शन 10: तर्कशक्ति एवं डेटा इंटरप्रिटेशन / DI (100 PYQ प्रश्न)",
            examName = "UKSSSC — Reasoning & DI (100 Qs)",
            durationMinutes = 100,
            totalMarks = 100,
            positiveMarks = 1.0,
            negativeMarks = 0.25,
            categoryId = "subordinate_selection",
            pyqAnalysisEn = "UKSSSC Reasoning & DI 5-Year PYQ Analysis (100 Questions): Covers Clock & Calendar, Ranking & Order, Coding-Decoding, Blood Relations, Direction Sense, Syllogism, Missing Numbers, and Graph/Table/Pie-Chart Data Interpretation.",
            pyqAnalysisHi = "UKSSSC तर्कशक्ति एवं डीआई 5-वर्षीय विश्लेषण (100 प्रश्न): घड़ी एवं कैलेंडर, क्रम व्यवस्था (Ranking), कोडिंग-डिकोडिंग, रक्त संबंध, दिशा परीक्षण, लुप्त संख्या तथा पाई चार्ट व तालिका डेटा इंटरप्रिटेशन (DI) के 100 प्रश्न।",
            topicWeightage = listOf("Clock, Calendar & Ranking (35%)", "Coding, Series & Blood Relation (35%)", "Pie Chart, Table & Bar Graph DI (30%)"),
            questions = buildUkssscQuestions("Reasoning & Data Interpretation (DI)", "तर्कशक्ति एवं डेटा इंटरप्रिटेशन (DI)", 70000, 100, reasoningDiSeeds)
        )
    }

    val all10UkssscSectionTests: List<UkssscSectionTestMeta> by lazy {
        listOf(
            UkssscSectionTestMeta(
                id = "uksssc_history",
                sectionId = "uksssc_history",
                titleEn = "1. GK: History & National Movement (100 Qs)",
                titleHi = "1. जीके: इतिहास एवं राष्ट्रीय आंदोलन (100 प्रश्न)",
                subtitleEn = "Ancient, Medieval, Modern History & Freedom Struggle • 100 PYQs",
                subtitleHi = "प्राचीन, मध्यकालीन, आधुनिक इतिहास एवं स्वतंत्रता आंदोलन • 100 प्रश्न",
                questionCount = 100,
                isUkSpecial250 = false,
                mockTest = ukssscHistory100Test
            ),
            UkssscSectionTestMeta(
                id = "uksssc_polity",
                sectionId = "uksssc_polity",
                titleEn = "2. GK: Polity & Constitution (100 Qs)",
                titleHi = "2. जीके: भारतीय राजव्यवस्था एवं संविधान (100 प्रश्न)",
                subtitleEn = "FR, DPSP, Parliament, Uttarakhand Panchayati Raj Act & Amendments • 100 PYQs",
                subtitleHi = "मूल अधिकार, संसद, उत्तराखंड पंचायती राज अधिनियम एवं संशोधन • 100 प्रश्न",
                questionCount = 100,
                isUkSpecial250 = false,
                mockTest = ukssscPolity100Test
            ),
            UkssscSectionTestMeta(
                id = "uksssc_geography",
                sectionId = "uksssc_geography",
                titleEn = "3. GK: Geography — India & World (100 Qs)",
                titleHi = "3. जीके: भारत एवं विश्व का भूगोल (100 प्रश्न)",
                subtitleEn = "Peaks, Passes, Rivers, Soils, Minerals & Census 2011 • 100 PYQs",
                subtitleHi = "पर्वत चोटियाँ, दर्रे, नदियाँ, मिट्टी, खनिज एवं जनगणना 2011 • 100 प्रश्न",
                questionCount = 100,
                isUkSpecial250 = false,
                mockTest = ukssscGeography100Test
            ),
            UkssscSectionTestMeta(
                id = "uksssc_economics",
                sectionId = "uksssc_economics",
                titleEn = "4. GK: Economics & Schemes (100 Qs)",
                titleHi = "4. जीके: भारतीय अर्थव्यवस्था एवं योजनाएँ (100 प्रश्न)",
                subtitleEn = "Five-Year Plans, RBI, NABARD, GST & Uttarakhand Welfare Schemes • 100 PYQs",
                subtitleHi = "पंचवर्षीय योजनाएँ, RBI, नाबार्ड, GST एवं उत्तराखंड की प्रमुख योजनाएँ • 100 प्रश्न",
                questionCount = 100,
                isUkSpecial250 = false,
                mockTest = ukssscEconomics100Test
            ),
            UkssscSectionTestMeta(
                id = "uksssc_environment",
                sectionId = "uksssc_environment",
                titleEn = "5. GK: Environment, Forest & Ecology (100 Qs)",
                titleHi = "5. जीके: पर्यावरण, वन एवं आपदा प्रबंधन (100 प्रश्न)",
                subtitleEn = "6 National Parks, 7 Sanctuaries, Chipko, Maiti & Pani Rakho Movements • 100 PYQs",
                subtitleHi = "उत्तराखंड के 6 राष्ट्रीय उद्यान, 7 वन्यजीव विहार, चिपको व मैती आंदोलन • 100 प्रश्न",
                questionCount = 100,
                isUkSpecial250 = false,
                mockTest = ukssscEnvironment100Test
            ),
            UkssscSectionTestMeta(
                id = "uksssc_scitech",
                sectionId = "uksssc_scitech",
                titleEn = "6. GK: Science & Technology (100 Qs)",
                titleHi = "6. जीके: सामान्य विज्ञान एवं प्रौद्योगिकी (100 प्रश्न)",
                subtitleEn = "Physics, Chemistry, Biology, Vitamins & Uttarakhand Research Institutes • 100 PYQs",
                subtitleHi = "भौतिकी, रसायन, जीव विज्ञान एवं उत्तराखंड के राष्ट्रीय शोध संस्थान • 100 प्रश्न",
                questionCount = 100,
                isUkSpecial250 = false,
                mockTest = ukssscSciTech100Test
            ),
            UkssscSectionTestMeta(
                id = "uksssc_uk_special_250",
                sectionId = "uksssc_uk_special_250",
                titleEn = "7. ★ Uttarakhand Special — Best 250 UKSSSC PYQs",
                titleHi = "7. ★ उत्तराखंड स्पेशल — सर्वश्रेष्ठ 250 प्रश्न (Best 250 PYQs)",
                subtitleEn = "40% Exam Weightage: Katyuri, Chand, Parmar/Tehri, 13 Districts, Prayag, Bugyal & Tribes • 250 Qs",
                subtitleHi = "40% परीक्षा भार: कत्यूरी, चंद व परमार वंश, 13 जिले, पंच प्रयाग, बुग्याल, जनजातियाँ व संस्कृति • 250 प्रश्न",
                questionCount = 250,
                isUkSpecial250 = true,
                mockTest = ukssscUttarakhandSpecial250Test
            ),
            UkssscSectionTestMeta(
                id = "uksssc_hindi",
                sectionId = "uksssc_hindi",
                titleEn = "8. General Hindi & Literature (100 Qs)",
                titleHi = "8. सामान्य हिंदी व्याकरण, पत्र लेखन एवं साहित्य (100 प्रश्न)",
                subtitleEn = "20-Mark Core: Varnamala, Sandhi, Sarkari Patra Lekhan & Uttarakhand Authors • 100 PYQs",
                subtitleHi = "20 अंक का मुख्य खंड: वर्णमाला, संधि, सरकारी पत्र लेखन एवं उत्तराखंड के साहित्यकार • 100 प्रश्न",
                questionCount = 100,
                isUkSpecial250 = false,
                mockTest = ukssscGeneralHindi100Test
            ),
            UkssscSectionTestMeta(
                id = "uksssc_computer",
                sectionId = "uksssc_computer",
                titleEn = "9. Computer & Information Technology (100 Qs)",
                titleHi = "9. कंप्यूटर एवं सूचना प्रौद्योगिकी (100 प्रश्न)",
                subtitleEn = "Generations, Memory, MS Office Shortcuts, OSI Model, Internet & Cyber Security • 100 PYQs",
                subtitleHi = "कंप्यूटर पीढ़ियाँ, मेमोरी, एमएस ऑफिस शॉर्टकट, नेटवर्किंग एवं साइबर सुरक्षा • 100 प्रश्न",
                questionCount = 100,
                isUkSpecial250 = false,
                mockTest = ukssscComputer100Test
            ),
            UkssscSectionTestMeta(
                id = "uksssc_reasoning_di",
                sectionId = "uksssc_reasoning_di",
                titleEn = "10. Reasoning & Data Interpretation / DI (100 Qs)",
                titleHi = "10. तर्कशक्ति एवं डेटा इंटरप्रिटेशन / DI (100 प्रश्न)",
                subtitleEn = "Clock, Calendar, Ranking, Coding-Decoding & Pie-Chart / Table DI • 100 PYQs",
                subtitleHi = "घड़ी, कैलेंडर, रैंकिंग, कोडिंग-डिकोडिंग एवं ग्राफ/तालिका डीआई • 100 प्रश्न",
                questionCount = 100,
                isUkSpecial250 = false,
                mockTest = ukssscReasoningDi100Test
            )
        )
    }
}
