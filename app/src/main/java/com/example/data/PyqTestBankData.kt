package com.example.data

import com.example.model.MockTest
import com.example.model.TestQuestion

/**
 * Shakuntalam Publications — Official Last 5 Years (2020–2025) PYQ Trend Analysis
 * Bilingual (English + Hindi) Test Series Bank.
 *
 * Each MockTest is tailored to the exact Exam Requirement:
 *  - Official marking scheme (+Positive / -Negative Marks)
 *  - 5-Year Topic Weightage & Question Framing Pattern (Statement-based, Assertion-Reason, TCS Pattern, etc.)
 *  - Bilingual Question (EN + HI), 4 Bilingual Options, Accurate Answer Key,
 *    Detailed Bilingual Explanation, and 5-Year PYQ Trend Insight.
 */
object PyqTestBankData {

    // =========================================================================
    // 1. UPSC CSE PRELIMS (GS PAPER-I) — 2020 TO 2025 PYQ ANALYSIS TEST
    // Pattern: +2.0 Marks / -0.66 Negative | Multi-Statement & Analytical Elimination/Pair Pattern
    // =========================================================================
    val upscPyqTest = MockTest(
        testId = "pyq_upsc_gs1_5yr",
        title = "UPSC CSE Prelims GS-I: Last 5 Years (2020–2025) PYQ Trend Test",
        hindiTitle = "UPSC सिविल सेवा प्रारंभिक (GS-I): विगत 5 वर्षीय (2020–2025) PYQ विश्लेषण टेस्ट",
        examName = "UPSC CSE Prelims (GS Paper-I)",
        durationMinutes = 20,
        totalMarks = 20,
        positiveMarks = 2.0,
        negativeMarks = 0.66,
        categoryId = "upsc",
        pyqAnalysisEn = "UPSC 2020–2025 Trend: 68% questions are multi-statement ('How many of the above statements are correct?'). High focus on Constitutional Doctrines, Monetary Transmission, Biodiversity Acts & Modern History Chronology.",
        pyqAnalysisHi = "UPSC 2020–2025 ट्रेंड: 68% प्रश्न बहु-कथन ('उपर्युक्त में से कितने कथन सही हैं?') पैटर्न पर आधारित हैं। संवैधानिक सिद्धांत, मौद्रिक नीति, जैव-विविधता एवं आधुनिक इतिहास कालक्रम पर विशेष भार।",
        topicWeightage = listOf(
            "Polity & Constitution (22%)",
            "Economy & RBI Policy (21%)",
            "Environment & Ecology (19%)",
            "Modern History & Culture (18%)",
            "Sci-Tech & IR (20%)"
        ),
        questions = listOf(
            TestQuestion(
                id = 101,
                questionEn = "With reference to the 'Basic Structure Doctrine' and Constitutional Amendments in India, consider the following statements:\n1. The 24th Constitutional Amendment Act made it obligatory for the President to give assent to a Constitutional Amendment Bill.\n2. In the Minerva Mills case (1980), the Supreme Court held that judicial review is an essential feature of the Basic Structure.\n3. The Constitution of India explicitly defines the term 'Basic Structure' under Article 368.\nHow many of the statements given above are correct?",
                questionHi = "भारत में 'मूल संरचना सिद्धांत' (Basic Structure Doctrine) और संवैधानिक संशोधनों के संदर्भ में, निम्नलिखित कथनों पर विचार कीजिए:\n1. 24वें संविधान संशोधन अधिनियम ने राष्ट्रपति के लिए संविधान संशोधन विधेयक पर अपनी सहमति देना अनिवार्य कर दिया।\n2. मिनर्वा मिल्स मामले (1980) में, सर्वोच्च न्यायालय ने निर्धारित किया कि 'न्यायिक समीक्षा' मूल संरचना की एक अनिवार्य विशेषता है।\n3. भारत का संविधान अनुच्छेद 368 के अंतर्गत 'मूल संरचना' शब्द को स्पष्ट रूप से परिभाषित करता है।\nउपर्युक्त कथनों में से कितने सही हैं?",
                optionsEn = listOf(
                    "Only one",
                    "Only two",
                    "All three",
                    "None"
                ),
                optionsHi = listOf(
                    "केवल एक",
                    "केवल दो",
                    "सभी तीन",
                    "कोई भी नहीं"
                ),
                correctIndex = 1,
                explanationEn = "Answer: (B) Only two (Statements 1 and 2 are correct).\n• Statement 1 is correct: The 24th Amendment Act (1971) amended Article 368 to make it obligatory for the President to give assent to a Constitutional Amendment Bill.\n• Statement 2 is correct: In Minerva Mills vs. Union of India (1980), SC struck down clauses of the 42nd Amendment and affirmed Judicial Review & balance between Fundamental Rights and DPSP as part of Basic Structure.\n• Statement 3 is incorrect: The Constitution does NOT define 'Basic Structure' anywhere; it is a judicial innovation evolved in Kesavananda Bharati case (1973).",
                explanationHi = "उत्तर: (B) केवल दो (कथन 1 और 2 सही हैं)।\n• कथन 1 सही है: 24वें संविधान संशोधन अधिनियम (1971) ने अनुच्छेद 368 में संशोधन कर राष्ट्रपति के लिए संविधान संशोधन विधेयक पर सहमति देना अनिवार्य कर दिया।\n• कथन 2 सही है: मिनर्वा मिल्स बनाम भारत संघ (1980) में सर्वोच्च न्यायालय ने न्यायिक समीक्षा तथा मूल अधिकारों व नीति निदेशक तत्वों के बीच संतुलन को मूल ढांचे का अंग घोषित किया।\n• कथन 3 गलत है: संविधान में कहीं भी 'मूल संरचना' को परिभाषित नहीं किया गया है; यह केशवानंद भारती वाद (1973) से विकसित एक न्यायिक अवधारणा है।",
                subject = "Indian Polity",
                pyqYearTag = "UPSC CSE PYQ 2020, 2023 Pattern",
                pyqFrequency = "Asked 5x in Last 5 Yrs",
                difficultyLevel = "High (UPSC Pair Pattern)",
                pyqTrendNoteEn = "UPSC 2023–2025 shifted from '1 and 2 only' to 'Only one / Only two / All three' options to eliminate guesswork.",
                pyqTrendNoteHi = "UPSC 2023–2025 में एलिमिनेशन तकनीक को रोकने के लिए 'केवल एक / केवल दो / सभी तीन' विकल्प पैटर्न अपनाया गया है।"
            ),
            TestQuestion(
                id = 102,
                questionEn = "If the Reserve Bank of India (RBI) decides to adopt an 'Expansionary Monetary Policy', which of the following would it NOT do?\n1. Cut and optimize the Statutory Liquidity Ratio (SLR)\n2. Increase the Marginal Standing Facility (MSF) Rate\n3. Cut the Bank Rate and Repo Rate\nSelect the correct answer using the code given below:",
                questionHi = "यदि भारतीय रिज़र्व बैंक (RBI) एक 'विस्तारवादी मौद्रिक नीति' (Expansionary Monetary Policy) अपनाने का निर्णय लेता है, तो वह निम्नलिखित में से क्या नहीं करेगा?\n1. वैधानिक तरलता अनुपात (SLR) में कटौती और अनुकूलन करना\n2. सीमांत स्थायी सुविधा (MSF) दर में वृद्धि करना\n3. बैंक दर और रेपो दर (Repo Rate) में कटौती करना\nनीचे दिए गए कूट का प्रयोग कर सही उत्तर चुनिए:",
                optionsEn = listOf(
                    "1 and 2 only",
                    "2 only",
                    "1 and 3 only",
                    "1, 2 and 3"
                ),
                optionsHi = listOf(
                    "केवल 1 और 2",
                    "केवल 2",
                    "केवल 1 और 3",
                    "1, 2 और 3"
                ),
                correctIndex = 1,
                explanationEn = "Answer: (B) 2 only.\n• Expansionary Monetary Policy aims to increase money supply (liquidity) in the economy.\n• Cutting SLR (1) and cutting Bank Rate/Repo Rate (3) make credit cheaper and increase liquidity.\n• Increasing the MSF Rate (2) makes borrowing costlier for commercial banks, which is a Contractionary (Hawkish) measure, so RBI will NOT do it.",
                explanationHi = "उत्तर: (B) केवल 2।\n• विस्तारवादी मौद्रिक नीति का उद्देश्य अर्थव्यवस्था में मुद्रा आपूर्ति (तरलता) को बढ़ाना होता है।\n• SLR में कटौती (1) और बैंक दर/रेपो दर में कटौती (3) ऋण को सस्ता बनाती है और तरलता बढ़ाती है।\n• सीमांत स्थायी सुविधा (MSF) दर में वृद्धि (2) करने से बैंकों के लिए उधार लेना महंगा हो जाता है, जो संकुचनकारी (Contractionary) कदम है; अतः RBI यह नहीं करेगा।",
                subject = "Indian Economy",
                pyqYearTag = "UPSC CSE PYQ 2020 & 2024 Trend",
                pyqFrequency = "Asked 6x in Last 5 Yrs",
                difficultyLevel = "Moderate-High",
                pyqTrendNoteEn = "Monetary Policy transmission (Repo, Reverse Repo, SDF, MSF, Open Market Operations) appears in every single UPSC Prelims from 2020 to 2024.",
                pyqTrendNoteHi = "मौद्रिक नीति उपकरण (Repo, SDF, MSF, OMO) से 2020 से 2024 के प्रत्येक UPSC प्रीलिम्स में अनिवार्य रूप से प्रश्न पूछे गए हैं।"
            ),
            TestQuestion(
                id = 103,
                questionEn = "In the context of Indian Freedom Struggle, the famous 'Gandhi-Irwin Pact' (Delhi Pact of 1931) included which of the following provisions?\n1. Invitation to Congress to participate in the Second Round Table Conference.\n2. Withdrawal of ordinances promulgated in connection with the Civil Disobedience Movement.\n3. Acceptance of Gandhiji's suggestion for a public inquiry into police excesses.\n4. Release of only those prisoners who were not charged with violence.\nSelect the correct answer using the code given below:",
                questionHi = "भारतीय स्वतंत्रता संग्राम के संदर्भ में, प्रसिद्ध 'गांधी-इरविन समझौते' (1931 का दिल्ली समझौता) में निम्नलिखित में से कौन-से प्रावधान शामिल थे?\n1. दूसरे गोलमेज सम्मेलन में भाग लेने के लिए कांग्रेस को निमंत्रण।\n2. सविनय अवज्ञा आंदोलन के संबंध में जारी किए गए अध्यादेशों को वापस लेना।\n3. पुलिस ज्यादतियों की सार्वजनिक जांच के लिए गांधीजी के सुझाव की स्वीकृति।\n4. केवल उन्हीं कैदियों की रिहाई जिन पर हिंसा का आरोप नहीं था।\nनीचे दिए गए कूट का प्रयोग कर सही उत्तर चुनिए:",
                optionsEn = listOf(
                    "1, 2 and 4 only",
                    "1, 3 and 4 only",
                    "2 and 3 only",
                    "1, 2, 3 and 4"
                ),
                optionsHi = listOf(
                    "केवल 1, 2 और 4",
                    "केवल 1, 3 और 4",
                    "केवल 2 और 3",
                    "1, 2, 3 और 4"
                ),
                correctIndex = 0,
                explanationEn = "Answer: (A) 1, 2 and 4 only.\n• Under the Gandhi-Irwin Pact (March 5, 1931), Lord Irwin agreed to release all political prisoners not convicted of violence (4), withdraw emergency ordinances (2), permit peaceful picketing, and allow coastal salt collection for personal use.\n• Congress agreed to suspend Civil Disobedience and attend the 2nd Round Table Conference (1).\n• Statement 3 is INCORRECT: Viceroy Irwin explicitly turned down Gandhiji's demand for a public inquiry into police excesses and refused to commute the death sentences of Bhagat Singh, Sukhdev, and Rajguru.",
                explanationHi = "उत्तर: (A) केवल 1, 2 और 4।\n• गांधी-इरविन समझौते (5 मार्च, 1931) के तहत वायसराय इरविन ने हिंसा के दोषी न पाए गए सभी राजनीतिक कैदियों को रिहा करने (4), आपातकालीन अध्यादेश वापस लेने (2) और तटीय क्षेत्रों में नमक बनाने की अनुमति दी।\n• कांग्रेस ने सविनय अवज्ञा आंदोलन स्थगित कर द्वितीय गोलमेज सम्मेलन (1) में भाग लेना स्वीकार किया।\n• कथन 3 गलत है: वायसराय इरविन ने पुलिस ज्यादतियों की सार्वजनिक जांच की गांधीजी की मांग को स्पष्ट रूप से अस्वीकार कर दिया था।",
                subject = "Modern History",
                pyqYearTag = "UPSC CSE PYQ 2020 Direct",
                pyqFrequency = "Asked 4x in Last 5 Yrs",
                difficultyLevel = "High",
                pyqTrendNoteEn = "Chronology & clauses of 1919–1942 movements (Non-Cooperation, CDM, Quit India, Cripps, Cabinet Mission) account for 65% of Modern History PYQs.",
                pyqTrendNoteHi = "1919–1942 के आंदोलनों (असहयोग, सविनय अवज्ञा, भारत छोड़ो, क्रिप्स व कैबिनेट मिशन) से आधुनिक इतिहास के 65% प्रश्न आते हैं।"
            ),
            TestQuestion(
                id = 104,
                questionEn = "With reference to 'Wetlands of International Importance' (Ramsar Sites) and the 'Montreux Record', which of the following statements is correct?",
                questionHi = "'अंतर्राष्ट्रीय महत्व की आर्द्रभूमियों' (रामसर स्थलों) और 'मॉन्ट्रेक्स रिकॉर्ड' (Montreux Record) के संदर्भ में, निम्नलिखित में से कौन-सा कथन सही है?",
                optionsEn = listOf(
                    "Montreux Record is a register of wetland sites where changes in ecological character have occurred, are occurring, or are likely to occur due to human interference.",
                    "Chilika Lake and Sambhar Lake are currently the only two Indian wetlands listed in the Montreux Record.",
                    "Once a wetland is placed on the Montreux Record, it automatically loses its Ramsar Site status within 5 years.",
                    "The Ramsar Convention is legally binding under the United Nations Environment Programme (UNEP)."
                ),
                optionsHi = listOf(
                    "मॉन्ट्रेक्स रिकॉर्ड उन आर्द्रभूमि स्थलों का रजिस्टर है जहाँ मानवीय हस्तक्षेप के कारण पारिस्थितिक स्वरूप में परिवर्तन हुआ है, हो रहा है, या होने की संभावना है।",
                    "चिल्का झील और सांभर झील वर्तमान में मॉन्ट्रेक्स रिकॉर्ड में सूचीबद्ध केवल दो भारतीय आर्द्रभूमियाँ हैं।",
                    "एक बार मॉन्ट्रेक्स रिकॉर्ड में शामिल होने पर आर्द्रभूमि 5 वर्षों में स्वतः रामसर स्थल का दर्जा खो देती है।",
                    "रामसर कन्वेंशन संयुक्त राष्ट्र पर्यावरण कार्यक्रम (UNEP) के तहत कानूनी रूप से बाध्यकारी संधि है।"
                ),
                correctIndex = 0,
                explanationEn = "Answer: (A).\n• The Montreux Record is a register of Ramsar wetland sites where changes in ecological character have occurred, are occurring, or are likely to occur as a result of technological developments, pollution, or other human interference.\n• Currently, ONLY TWO Indian wetlands are in the Montreux Record: Keoladeo National Park (Rajasthan) and Loktak Lake (Manipur). Chilika Lake (Odisha) was removed from the Montreux Record in 2002 after successful restoration.",
                explanationHi = "उत्तर: (A)।\n• मॉन्ट्रेक्स रिकॉर्ड रामसर आर्द्रभूमि स्थलों का एक प्रमुख रजिस्टर है जहाँ तकनीकी विकास, प्रदूषण या अन्य मानवीय हस्तक्षेप के परिणामस्वरूप पारिस्थितिक चरित्र में परिवर्तन हुआ है या होने की संभावना है।\n• वर्तमान में भारत के केवल दो स्थल मॉन्ट्रेक्स रिकॉर्ड में हैं: केवलादेव राष्ट्रीय उद्यान (राजस्थान) और लोकटक झील (मणिपुर)। चिल्का झील (ओडिशा) को सफल संरक्षण के बाद 2002 में इससे हटा दिया गया था।",
                subject = "Environment & Ecology",
                pyqYearTag = "UPSC CSE PYQ 2021, 2022, 2024",
                pyqFrequency = "Asked 5x in Last 5 Yrs",
                difficultyLevel = "Moderate",
                pyqTrendNoteEn = "Wetlands, Bio-geochemical cycles, Protected Areas (WPA 1972 Amendment) & COP summits are top-priority Environment topics.",
                pyqTrendNoteHi = "आर्द्रभूमि (Ramsar Sites), वन्यजीव संरक्षण अधिनियम संशोधन एवं जलवायु सम्मेलन पर्यावरण खंड के सर्वोच्च प्राथमिकता वाले विषय हैं।"
            ),
            TestQuestion(
                id = 105,
                questionEn = "Which of the following best describes the primary distinction between 'mRNA Vaccines' and 'Viral Vector Vaccines' frequently seen in Science & Technology PYQs?",
                questionHi = "विज्ञान और प्रौद्योगिकी (Sci & Tech) के विगत वर्षों के प्रश्नों में चर्चित 'mRNA टीकों' और 'वायरल वेक्टर टीकों' के बीच मुख्य अंतर का सबसे सटीक वर्णन निम्नलिखित में से कौन करता है?",
                optionsEn = listOf(
                    "mRNA vaccines deliver genetic instructions enclosed in lipid nanoparticles directly into host cells without using a modified virus, whereas viral vector vaccines use a harmless modified virus to deliver the genetic code.",
                    "mRNA vaccines permanently alter the host nuclear DNA, whereas viral vector vaccines only act in the cytoplasm.",
                    "Viral vector vaccines require ultra-cold storage (-70°C), whereas all mRNA vaccines can be stored at normal room temperature.",
                    "mRNA vaccines use live attenuated pathogens, whereas viral vector vaccines use purified toxoids."
                ),
                optionsHi = listOf(
                    "mRNA टीके किसी संशोधित वायरस का उपयोग किए बिना लिपिड नैनोपार्टिकल्स में लिपटे आनुवंशिक निर्देशों को सीधे कोशिकाओं में पहुंचाते हैं, जबकि वायरल वेक्टर टीके आनुवंशिक कोड पहुंचाने के लिए एक हानिरहित संशोधित वायरस का उपयोग करते हैं।",
                    "mRNA टीके मेजबान के परमाणु DNA को स्थायी रूप से बदल देते हैं, जबकि वायरल वेक्टर टीके केवल कोशिका द्रव्य में कार्य करते हैं।",
                    "वायरल वेक्टर टीकों को अत्यधिक ठंडे तापमान (-70°C) की आवश्यकता होती है, जबकि सभी mRNA टीके सामान्य कमरे के तापमान पर रखे जा सकते हैं।",
                    "mRNA टीके जीवित क्षीण रोगजनकों का उपयोग करते हैं, जबकि वायरल वेक्टर टीके शुद्ध टॉक्सोइड का उपयोग करते हैं।"
                ),
                correctIndex = 0,
                explanationEn = "Answer: (A).\n• mRNA vaccines (e.g., Pfizer-BioNTech, Moderna, Gennova GEMCOVAC) encapsulate messenger RNA in Lipid Nanoparticles (LNPs) so ribosomes in the cytoplasm synthesize the spike protein—they never enter the nucleus or alter human DNA.\n• Viral Vector vaccines (e.g., Covishield / Oxford-AstraZeneca, Sputnik V) use a harmless modified Adenovirus (chimpanzee or human adenovirus) as a carrier ('vector') to deliver the spike protein gene.",
                explanationHi = "उत्तर: (A)।\n• mRNA टीके (जैसे फाइजर, मॉडर्ना, जेनोवा GEMCOVAC) लिपिड नैनोपार्टिकल्स (LNPs) में मैसेंजर RNA पहुंचाते हैं जो कोशिका के राइबोसोम को एंटीजन प्रोटीन बनाने का निर्देश देता है—यह कभी भी कोशिका केंद्रक (Nucleus) में प्रवेश नहीं करता और मानव DNA को नहीं बदलता।\n• वायरल वेक्टर टीके (जैसे कोविशील्ड, स्पुतनिक-V) आनुवंशिक संकेत पहुंचाने के लिए वाहक (Vector) के रूप में एक हानिरहित संशोधित एडेनोवायरस का उपयोग करते हैं।",
                subject = "Science & Technology",
                pyqYearTag = "UPSC CSE PYQ 2021, 2022, 2024",
                pyqFrequency = "Asked 4x in Last 5 Yrs",
                difficultyLevel = "Moderate-High",
                pyqTrendNoteEn = "Biotechnology (CRISPR-Cas9, mRNA, CAR-T Cell Therapy, Mitochondrial Replacement) is the #1 sub-topic in UPSC Science & Tech.",
                pyqTrendNoteHi = "जैव-प्रौद्योगिकी (CRISPR-Cas9, mRNA, CAR-T सेल थेरेपी) UPSC विज्ञान एवं प्रौद्योगिकी का नंबर-1 विषय रहा है।"
            )
        )
    )

    // =========================================================================
    // 2. STATE PSC (UPPCS / BPSC / RAS / MPPSC) — 2020 TO 2025 PYQ ANALYSIS TEST
    // Pattern: +2.0 Marks / -0.66 Negative | Constitutional Articles, Chronology, Matching Lists & SDG Index
    // =========================================================================
    val statePscPyqTest = MockTest(
        testId = "pyq_state_psc_5yr",
        title = "State PSC (UPPCS / BPSC / RAS): Last 5 Years (2020–2025) PYQ Test",
        hindiTitle = "राज्य पीएससी (UPPCS / BPSC / RAS): विगत 5 वर्षीय (2020–2025) PYQ विश्लेषण टेस्ट",
        examName = "UPPCS / BPSC / RAS Prelims",
        durationMinutes = 15,
        totalMarks = 10,
        positiveMarks = 2.0,
        negativeMarks = 0.66,
        categoryId = "state_psc",
        pyqAnalysisEn = "State PSC 2020–2025 Trend: Heavy emphasis on exact Constitutional Articles & Schedules, Matching List-I with List-II, Sustainable Development Goals (SDG 1–17), Census 2011 & Modern Indian History.",
        pyqAnalysisHi = "राज्य PSC 2020–2025 ट्रेंड: संविधान के सटीक अनुच्छेदों व अनुसूचियों, सूची-I को सूची-II से सुमेलित करने, सतत विकास लक्ष्य (SDG 1–17), जनगणना 2011 एवं आधुनिक इतिहास पर सर्वाधिक बल।",
        topicWeightage = listOf(
            "Polity Articles & Schedules (24%)",
            "History & National Movement (22%)",
            "Geography & Environment (20%)",
            "General Science & SDGs (18%)",
            "Economy & Census/State GK (16%)"
        ),
        questions = listOf(
            TestQuestion(
                id = 201,
                questionEn = "Match List-I (Constitutional Provisions) with List-II (Articles of the Indian Constitution) and select the correct answer:\nList-I:\nA. Organization of Village Panchayats\nB. Uniform Civil Code for Citizens\nC. Separation of Judiciary from Executive\nD. Promotion of International Peace and Security\nList-II:\n1. Article 50\n2. Article 51\n3. Article 40\n4. Article 44",
                questionHi = "सूची-I (संवैधानिक प्रावधान) को सूची-II (भारतीय संविधान के अनुच्छेद) से सुमेलित कीजिए तथा सही उत्तर चुनिए:\nसूची-I:\nA. ग्राम पंचायतों का गठन\nB. नागरिकों के लिए समान नागरिक संहिता (UCC)\nC. कार्यपालिका से न्यायपालिका का पृथक्करण\nD. अंतर्राष्ट्रीय शांति और सुरक्षा की अभिवृद्धि\nसूची-II:\n1. अनुच्छेद 50\n2. अनुच्छेद 51\n3. अनुच्छेद 40\n4. अनुच्छेद 44",
                optionsEn = listOf(
                    "A-3, B-4, C-1, D-2",
                    "A-4, B-3, C-2, D-1",
                    "A-3, B-1, C-4, D-2",
                    "A-2, B-4, C-1, D-3"
                ),
                optionsHi = listOf(
                    "A-3, B-4, C-1, D-2",
                    "A-4, B-3, C-2, D-1",
                    "A-3, B-1, C-4, D-2",
                    "A-2, B-4, C-1, D-3"
                ),
                correctIndex = 0,
                explanationEn = "Answer: (A) A-3, B-4, C-1, D-2.\n• Article 40: Organization of Village Panchayats (Gandhian DPSP).\n• Article 44: Uniform Civil Code (UCC) for the citizens (Implemented by Uttarakhand in 2024).\n• Article 50: Separation of Judiciary from the Executive in public services.\n• Article 51: Promotion of International Peace and Security.",
                explanationHi = "उत्तर: (A) A-3, B-4, C-1, D-2।\n• अनुच्छेद 40: ग्राम पंचायतों का गठन (गांधीवादी नीति निदेशक तत्व)।\n• अनुच्छेद 44: नागरिकों के लिए समान नागरिक संहिता (UCC)।\n• अनुच्छेद 50: लोक सेवाओं में कार्यपालिका से न्यायपालिका का पृथक्करण।\n• अनुच्छेद 51: अंतर्राष्ट्रीय शांति और सुरक्षा की अभिवृद्धि।",
                subject = "Indian Polity (DPSP)",
                pyqYearTag = "UPPCS 2021, 2023 & BPSC 2022 PYQ",
                pyqFrequency = "Asked 7x in Last 5 Yrs",
                difficultyLevel = "Moderate",
                pyqTrendNoteEn = "DPSP Articles (36 to 51) and Fundamental Duties (51A) are asked in List-Matching format in almost every UPPCS & BPSC prelims.",
                pyqTrendNoteHi = "नीति निदेशक तत्व (अनुच्छेद 36–51) और मूल कर्तव्य (51A) से प्रत्येक UPPCS और BPSC परीक्षा में सुमेलन (Matching) प्रश्न पूछा जाता है।"
            ),
            TestQuestion(
                id = 202,
                questionEn = "Under the United Nations 17 Sustainable Development Goals (SDGs 2030), which goal corresponds to 'Climate Action' and 'Clean Water and Sanitation' respectively?",
                questionHi = "संयुक्त राष्ट्र के 17 सतत विकास लक्ष्यों (SDGs 2030) के अंतर्गत, क्रमशः 'जलवायु कार्रवाई' (Climate Action) और 'स्वच्छ जल एवं स्वच्छता' (Clean Water and Sanitation) किस लक्ष्य संख्या से संबंधित हैं?",
                optionsEn = listOf(
                    "SDG-13 and SDG-6",
                    "SDG-14 and SDG-7",
                    "SDG-12 and SDG-5",
                    "SDG-15 and SDG-6"
                ),
                optionsHi = listOf(
                    "SDG-13 और SDG-6",
                    "SDG-14 और SDG-7",
                    "SDG-12 और SDG-5",
                    "SDG-15 और SDG-6"
                ),
                correctIndex = 0,
                explanationEn = "Answer: (A) SDG-13 and SDG-6.\n• SDG-1: No Poverty | SDG-2: Zero Hunger | SDG-3: Good Health | SDG-4: Quality Education | SDG-5: Gender Equality\n• SDG-6: Clean Water and Sanitation\n• SDG-7: Affordable & Clean Energy | SDG-13: Climate Action | SDG-14: Life Below Water | SDG-15: Life on Land.",
                explanationHi = "उत्तर: (A) SDG-13 और SDG-6।\n• SDG-1: गरीबी उन्मूलन | SDG-2: शून्य भुखमरी | SDG-3: उत्तम स्वास्थ्य | SDG-4: गुणवत्तापूर्ण शिक्षा | SDG-5: लैंगिक समानता\n• SDG-6: स्वच्छ जल और स्वच्छता\n• SDG-7: सस्ती और स्वच्छ ऊर्जा | SDG-13: जलवायु कार्रवाई (Climate Action) | SDG-14: जलीय जीवों की सुरक्षा | SDG-15: थलीय जीवों की सुरक्षा।",
                subject = "Environment & Sustainable Dev",
                pyqYearTag = "UPPCS 2020, 2021, 2022, 2023 PYQ",
                pyqFrequency = "Asked 5x in 5 Consecutive Yrs",
                difficultyLevel = "Moderate",
                pyqTrendNoteEn = "UPPCS has asked at least 1–2 questions on exact SDG Numbers (SDG 1 to 17) every single year from 2020 to 2024!",
                pyqTrendNoteHi = "UPPCS ने 2020 से 2024 तक लगातार हर वर्ष SDG संख्या (SDG 1 से 17) पर 1–2 प्रश्न अनिवार्य रूप से पूछे हैं!"
            ),
            TestQuestion(
                id = 203,
                questionEn = "Arrange the following events of the Indian National Movement in their correct chronological order:\nI. Formation of the Swaraj Party\nII. Chauri-Chaura Incident\nIII. Kakori Train Action\nIV. Appointment of the Simon Commission in Britain\nSelect the correct code:",
                questionHi = "भारतीय राष्ट्रीय आंदोलन की निम्नलिखित घटनाओं को उनके सही कालानुक्रमिक क्रम (Chronological Order) में व्यवस्थित कीजिए:\nI. स्वराज पार्टी का गठन\nII. चौरी-चौरा कांड\nIII. काकोरी ट्रेन एक्शन\nIV. ब्रिटेन में साइमन कमीशन की नियुक्ति\nसही कूट चुनिए:",
                optionsEn = listOf(
                    "II - I - III - IV",
                    "I - II - III - IV",
                    "II - III - I - IV",
                    "I - III - II - IV"
                ),
                optionsHi = listOf(
                    "II - I - III - IV",
                    "I - II - III - IV",
                    "II - III - I - IV",
                    "I - III - II - IV"
                ),
                correctIndex = 0,
                explanationEn = "Answer: (A) II - I - III - IV.\n• II. Chauri-Chaura Incident (Gorakhpur): 4 February 1922.\n• I. Formation of Swaraj Party (by C.R. Das & Motilal Nehru): 1 January 1923.\n• III. Kakori Train Action (by HRA revolutionaries): 9 August 1925.\n• IV. Appointment of Simon Commission: November 1927 (Arrived in India on 3 Feb 1928).",
                explanationHi = "उत्तर: (A) II - I - III - IV।\n• II. चौरी-चौरा घटना (गोरखपुर): 4 फरवरी 1922।\n• I. स्वराज पार्टी का गठन (सी.आर. दास एवं मोतीलाल नेहरू द्वारा): 1 जनवरी 1923।\n• III. काकोरी ट्रेन एक्शन (HRA क्रांतिकारियों द्वारा): 9 अगस्त 1925।\n• IV. साइमन कमीशन की नियुक्ति: नवंबर 1927 (भारत आगमन: 3 फरवरी 1928)।",
                subject = "Modern Indian History",
                pyqYearTag = "UPPCS 2022 & BPSC 68th PYQ",
                pyqFrequency = "Asked 6x in Last 5 Yrs",
                difficultyLevel = "Moderate-High",
                pyqTrendNoteEn = "State PSCs love 4-event chronological arrangement questions from 1905 to 1947.",
                pyqTrendNoteHi = "राज्य लोक सेवा आयोगों में 1905 से 1947 के बीच की 4 घटनाओं को कालक्रम में सजाने के प्रश्न सर्वाधिक पूछे जाते हैं।"
            ),
            TestQuestion(
                id = 204,
                questionEn = "Which vitamin deficiency causes 'Pernicious Anaemia' and contains the metal ion 'Cobalt' in its chemical structure?",
                questionHi = "किस विटामिन की कमी से 'पर्निशियस एनीमिया' (घातक रक्ताल्पता) होता है तथा इसकी रासायनिक संरचना में 'कोबाल्ट' (Cobalt) धातु आयन पाया जाता है?",
                optionsEn = listOf(
                    "Vitamin B12 (Cyanocobalamin)",
                    "Vitamin B6 (Pyridoxine)",
                    "Vitamin B9 (Folic Acid)",
                    "Vitamin B1 (Thiamine)"
                ),
                optionsHi = listOf(
                    "विटामिन B12 (साइनोकोबालामिन)",
                    "विटामिन B6 (पाइरिडॉक्सिन)",
                    "विटामिन B9 (फोलिक एसिड)",
                    "विटामिन B1 (थायमिन)"
                ),
                correctIndex = 0,
                explanationEn = "Answer: (A) Vitamin B12 (Cyanocobalamin).\n• Vitamin B12 is chemically called Cyanocobalamin because it contains a Cobalt (Co) ion at the center of its corrin ring.\n• It is essential for RBC maturation and myelin synthesis; its deficiency causes Pernicious Anaemia.",
                explanationHi = "उत्तर: (A) विटामिन B12 (साइनोकोबालामिन)।\n• विटामिन B12 का रासायनिक नाम साइनोकोबालामिन है क्योंकि इसके केंद्र में कोबाल्ट (Co) धातु आयन उपस्थित होता है।\n• यह लाल रक्त कणिकाओं (RBC) के परिपक्वन और तंत्रिका तंत्र के लिए आवश्यक है; इसकी कमी से पर्निशियस एनीमिया होता है।",
                subject = "General Science (Biology)",
                pyqYearTag = "BPSC 67th, UPPCS 2021 & RAS 2023 PYQ",
                pyqFrequency = "Asked 8x in Last 5 Yrs",
                difficultyLevel = "Easy-Moderate",
                pyqTrendNoteEn = "Biology (Vitamins, Hormones, Human Diseases & Plant Nutrition) constitutes 60% of the General Science section in State PSC exams.",
                pyqTrendNoteHi = "जीव विज्ञान (विटामिन, हार्मोन, मानव रोग एवं पादप पोषण) से राज्य PSC के सामान्य विज्ञान खंड में 60% प्रश्न पूछे जाते हैं।"
            )
        )
    )

    // =========================================================================
    // 3. SSC (CGL / CHSL / MTS / CPO) — 2020 TO 2025 TCS PYQ ANALYSIS TEST
    // Pattern: +2.0 Marks / -0.50 Negative | High-Speed TCS Pattern (GA, Maths, Reasoning, English)
    // =========================================================================
    val sscPyqTest = MockTest(
        testId = "pyq_ssc_cgl_5yr",
        title = "SSC CGL / CHSL Tier-I & II: Last 5 Years (2020–2025) TCS PYQ Test",
        hindiTitle = "SSC CGL / CHSL टियर-I व II: विगत 5 वर्षीय (2020–2025) TCS पैटर्न PYQ टेस्ट",
        examName = "SSC CGL / CHSL / CPO (TCS Pattern)",
        durationMinutes = 15,
        totalMarks = 10,
        positiveMarks = 2.0,
        negativeMarks = 0.50,
        categoryId = "ssc",
        pyqAnalysisEn = "SSC TCS 2020–2025 Trend: +2.0 / -0.50 marking in Tier-I. High repeat rate (70%+) in Classical Dances & Gharana, Constitutional Amendments, Algebraic Identities, Successive Percentage & Coding-Decoding.",
        pyqAnalysisHi = "SSC TCS 2020–2025 ट्रेंड: टियर-I में +2.0 / -0.50 अंकन। शास्त्रीय नृत्य व घराने, संविधान संशोधन, बीजगणितीय सर्वसमिका, क्रमिक प्रतिशत तथा कोडिंग-डिकोडिंग में 70%+ प्रश्नों की पुनरावृत्ति।",
        topicWeightage = listOf(
            "General Awareness & Static GK (25%)",
            "Quantitative Aptitude (25%)",
            "General Intelligence & Reasoning (25%)",
            "English / Bilingual Comprehension (25%)"
        ),
        questions = listOf(
            TestQuestion(
                id = 301,
                questionEn = "If x + (1/x) = 4, then what is the value of x³ + (1/x³)?",
                questionHi = "यदि x + (1/x) = 4 है, तो x³ + (1/x³) का मान क्या होगा?",
                optionsEn = listOf(
                    "52",
                    "64",
                    "48",
                    "60"
                ),
                optionsHi = listOf(
                    "52",
                    "64",
                    "48",
                    "60"
                ),
                correctIndex = 0,
                explanationEn = "Answer: (A) 52.\n• Shortcut TCS Identity: If x + (1/x) = k, then x³ + (1/x³) = k³ - 3k.\n• Here k = 4.\n• Therefore, x³ + (1/x³) = 4³ - 3(4) = 64 - 12 = 52.",
                explanationHi = "उत्तर: (A) 52।\n• शॉर्टकट TCS सूत्र: यदि x + (1/x) = k हो, तो x³ + (1/x³) = k³ - 3k होता है।\n• यहाँ k = 4 दिया गया है।\n• अतः x³ + (1/x³) = 4³ - 3(4) = 64 - 12 = 52।",
                subject = "Quantitative Aptitude (Algebra)",
                pyqYearTag = "SSC CGL 2021, 2022, 2023, 2024 PYQ",
                pyqFrequency = "Asked 18+ Shifts in 5 Yrs",
                difficultyLevel = "Moderate (High Speed)",
                pyqTrendNoteEn = "Algebraic identities [x + 1/x = k => x² + 1/x² = k² - 2 and x³ + 1/x³ = k³ - 3k] appear in almost every SSC CGL/CHSL shift.",
                pyqTrendNoteHi = "बीजगणित सर्वसमिका [x + 1/x = k => x³ + 1/x³ = k³ - 3k] SSC CGL व CHSL की लगभग प्रत्येक शिफ्ट में पूछी जाती है।"
            ),
            TestQuestion(
                id = 302,
                questionEn = "Padma Vibhushan awardee 'Pandit Birju Maharaj', frequently asked in SSC TCS exams, was a legendary exponent of which Indian classical dance form and Gharana?",
                questionHi = "SSC की TCS परीक्षाओं में बार-बार पूछे जाने वाले पद्म विभूषण से सम्मानित 'पंडित बिरजू महाराज' किस भारतीय शास्त्रीय नृत्य और घराने के महान प्रतिपादक थे?",
                optionsEn = listOf(
                    "Kathak (Kalka-Bindadin Gharana of Lucknow)",
                    "Odissi (Bhubaneswar Gharana)",
                    "Bharatanatyam (Tanjore Gharana)",
                    "Kuchipudi (Andhra Gharana)"
                ),
                optionsHi = listOf(
                    "कथक (लखनऊ का कालका-बिंदादीन घराना)",
                    "ओडिसी (भुवनेश्वर घराना)",
                    "भरतनाट्यम (तंजौर घराना)",
                    "कुचिपुड़ी (आंध्र घराना)"
                ),
                correctIndex = 0,
                explanationEn = "Answer: (A) Kathak (Kalka-Bindadin Gharana of Lucknow).\n• Pandit Birju Maharaj (1938–2022) was India's most celebrated Kathak maestro belonging to the Kalka-Bindadin Gharana of Lucknow.\n• He was awarded the Padma Vibhushan in 1986.",
                explanationHi = "उत्तर: (A) कथक (लखनऊ का कालका-बिंदादीन घराना)।\n• पंडित बिरजू महाराज (1938–2022) लखनऊ के कालका-बिंदादीन घराने से संबंधित भारत के महानतम कथक नर्तक थे।\n• उन्हें 1986 में भारत के दूसरे सर्वोच्च नागरिक सम्मान 'पद्म विभूषण' से सम्मानित किया गया था।",
                subject = "Static GK (Art & Culture)",
                pyqYearTag = "SSC CGL 2022, 2023 & CHSL 2024 PYQ",
                pyqFrequency = "Asked 14x in Last 5 Yrs",
                difficultyLevel = "Easy-Moderate",
                pyqTrendNoteEn = "Since 2021, TCS asks 2–3 questions per shift on Classical Dancers, Musical Instruments, and Padma Awardees.",
                pyqTrendNoteHi = "2021 से TCS पैटर्न में प्रत्येक शिफ्ट में शास्त्रीय नर्तक, वाद्ययंत्र एवं पद्म पुरस्कार विजेताओं से 2–3 प्रश्न पूछे जा रहे हैं।"
            ),
            TestQuestion(
                id = 303,
                questionEn = "A shopkeeper marks his goods 25% above the Cost Price (CP) and allows a discount of 10% on the Marked Price (MP). What is his net gain percentage?",
                questionHi = "एक दुकानदार अपनी वस्तुओं पर क्रय मूल्य (CP) से 25% अधिक अंकित मूल्य (MP) निर्धारित करता है और अंकित मूल्य पर 10% की छूट देता है। उसका शुद्ध लाभ प्रतिशत क्या है?",
                optionsEn = listOf(
                    "12.5% Profit",
                    "15% Profit",
                    "10.5% Profit",
                    "14% Profit"
                ),
                optionsHi = listOf(
                    "12.5% लाभ",
                    "15% लाभ",
                    "10.5% लाभ",
                    "14% लाभ"
                ),
                correctIndex = 0,
                explanationEn = "Answer: (A) 12.5% Profit.\n• Net % change formula: [M - D - (M × D)/100]%\n• Here Mark-up (M) = +25%, Discount (D) = 10%.\n• Net Profit % = 25 - 10 - (25 × 10)/100 = 15 - 2.5 = +12.5% Profit.",
                explanationHi = "उत्तर: (A) 12.5% लाभ।\n• क्रमिक प्रतिशत सूत्र: [M - D - (M × D)/100]%\n• यहाँ अंकित वृद्धि (M) = +25%, छूट (D) = 10% है।\n• शुद्ध लाभ % = 25 - 10 - (25 × 10)/100 = 15 - 2.5 = 12.5% लाभ।",
                subject = "Quantitative Aptitude (Profit & Loss)",
                pyqYearTag = "SSC CGL Tier-II 2023 & MTS 2024 PYQ",
                pyqFrequency = "Asked 20+ Shifts in 5 Yrs",
                difficultyLevel = "Easy-Moderate",
                pyqTrendNoteEn = "Profit, Loss & Discount (MP-CP-SP ratio) carries the highest weightage in SSC Arithmetic.",
                pyqTrendNoteHi = "लाभ-हानि एवं बट्टा (MP-CP-SP अनुपात) SSC अंकगणित में सर्वाधिक अंक भार वाला अध्याय है।"
            ),
            TestQuestion(
                id = 304,
                questionEn = "Select the number that can replace the question mark (?) in the following series:\n7, 15, 31, 63, 127, ?",
                questionHi = "निम्नलिखित श्रृंखला में प्रश्नवाचक चिह्न (?) के स्थान पर आने वाली संख्या का चयन कीजिए:\n7, 15, 31, 63, 127, ?",
                optionsEn = listOf(
                    "255",
                    "253",
                    "254",
                    "256"
                ),
                optionsHi = listOf(
                    "255",
                    "253",
                    "254",
                    "256"
                ),
                correctIndex = 0,
                explanationEn = "Answer: (A) 255.\n• Pattern: Each term is (× 2 + 1) or (2^n - 1):\n• 7 × 2 + 1 = 15\n• 15 × 2 + 1 = 31\n• 31 × 2 + 1 = 63\n• 63 × 2 + 1 = 127\n• 127 × 2 + 1 = 255.",
                explanationHi = "उत्तर: (A) 255।\n• पैटर्न: प्रत्येक पद (× 2 + 1) के नियम का पालन करता है:\n• 7 × 2 + 1 = 15\n• 15 × 2 + 1 = 31\n• 31 × 2 + 1 = 63\n• 63 × 2 + 1 = 127\n• 127 × 2 + 1 = 255।",
                subject = "Logical Reasoning",
                pyqYearTag = "SSC CGL 2022 & CHSL 2023 PYQ",
                pyqFrequency = "Asked 12x in Last 5 Yrs",
                difficultyLevel = "Easy",
                pyqTrendNoteEn = "Number Series based on (×2 ± 1) and prime-square differences appear in every SSC Reasoning paper.",
                pyqTrendNoteHi = "(×2 ± 1) और अभाज्य/वर्ग अंतर पर आधारित संख्या श्रृंखला SSC रीजनिंग के प्रत्येक प्रश्नपत्र में पूछी जाती है।"
            ),
            TestQuestion(
                id = 305,
                questionEn = "Which Constitutional Amendment Act added the Fundamental Duty under Article 51A(k) to provide opportunities for education to children aged 6 to 14 years?",
                questionHi = "किस संविधान संशोधन अधिनियम ने 6 से 14 वर्ष की आयु के बच्चों को शिक्षा के अवसर प्रदान करने के लिए अनुच्छेद 51A(k) के तहत 11वां मौलिक कर्तव्य जोड़ा?",
                optionsEn = listOf(
                    "86th Constitutional Amendment Act, 2002",
                    "42nd Constitutional Amendment Act, 1976",
                    "44th Constitutional Amendment Act, 1978",
                    "73rd Constitutional Amendment Act, 1992"
                ),
                optionsHi = listOf(
                    "86वां संविधान संशोधन अधिनियम, 2002",
                    "42वां संविधान संशोधन अधिनियम, 1976",
                    "44वां संविधान संशोधन अधिनियम, 1978",
                    "73वां संविधान संशोधन अधिनियम, 1992"
                ),
                correctIndex = 0,
                explanationEn = "Answer: (A) 86th Constitutional Amendment Act, 2002.\n• The 42nd Amendment (1976) added the original 10 Fundamental Duties on the recommendation of the Swaran Singh Committee.\n• The 86th Amendment (2002) added the 11th Fundamental Duty [Article 51A(k)], inserted Article 21A (Right to Education), and modified Article 45.",
                explanationHi = "उत्तर: (A) 86वां संविधान संशोधन अधिनियम, 2002।\n• 42वें संशोधन (1976) ने स्वर्ण सिंह समिति की सिफारिश पर मूल 10 मौलिक कर्तव्य जोड़े थे।\n• 86वें संविधान संशोधन (2002) ने 11वां मौलिक कर्तव्य [अनुच्छेद 51A(k)] जोड़ा तथा अनुच्छेद 21A (शिक्षा का अधिकार) को मूल अधिकार बनाया।",
                subject = "General Awareness (Polity)",
                pyqYearTag = "SSC CGL 2020, 2022, 2023, 2024 PYQ",
                pyqFrequency = "Asked 16x in Last 5 Yrs",
                difficultyLevel = "Easy-Moderate",
                pyqTrendNoteEn = "42nd, 44th, 73rd, 86th, and 101st–106th Amendments are the most repeated Polity questions in SSC.",
                pyqTrendNoteHi = "42वां, 44वां, 73वां, 86वां तथा 101–106वें संविधान संशोधन SSC राजव्यवस्था में सबसे अधिक बार दोहराए जाने वाले प्रश्न हैं।"
            )
        )
    )

    // =========================================================================
    // 4. BANKING & INSURANCE (IBPS PO / SBI PO / RBI) — 2020 TO 2025 PYQ TEST
    // Pattern: +1.0 Marks / -0.25 Negative | Banking Awareness, RBI Norms, Quantitative & Reasoning
    // =========================================================================
    val bankingPyqTest = MockTest(
        testId = "pyq_banking_po_5yr",
        title = "Banking & RBI (IBPS PO / SBI PO): Last 5 Years (2020–2025) PYQ Test",
        hindiTitle = "बैंकिंग एवं RBI (IBPS PO / SBI PO): विगत 5 वर्षीय (2020–2025) PYQ विश्लेषण टेस्ट",
        examName = "IBPS PO / SBI PO / RBI Grade B",
        durationMinutes = 15,
        totalMarks = 4,
        positiveMarks = 1.0,
        negativeMarks = 0.25,
        categoryId = "banking",
        pyqAnalysisEn = "Banking 2020–2025 Trend: +1.0 / -0.25 marking. High weightage on RBI Monetary Policy Committee (MPC), Basel-III Capital Adequacy, NPCI Digital Payment Limits (UPI), and Syllogism/Arithmetic.",
        pyqAnalysisHi = "बैंकिंग 2020–2025 ट्रेंड: +1.0 / -0.25 अंकन। RBI मौद्रिक नीति समिति (MPC), बेसल-III मानक, NPCI डिजिटल भुगतान (UPI) सीमा एवं न्याय निगमन/अंकगणित पर उच्च भार।",
        topicWeightage = listOf(
            "Banking & Financial Awareness (30%)",
            "Quantitative & Data Analysis (25%)",
            "Logical Reasoning & Puzzles (25%)",
            "Economy & RBI Circulars (20%)"
        ),
        questions = listOf(
            TestQuestion(
                id = 401,
                questionEn = "With reference to the Monetary Policy Committee (MPC) constituted under Section 45ZB of the RBI Act, 1934, which of the following statements is TRUE?",
                questionHi = "भारतीय रिज़र्व बैंक अधिनियम, 1934 की धारा 45ZB के तहत गठित मौद्रिक नीति समिति (MPC) के संदर्भ में, निम्नलिखित में से कौन-सा कथन सत्य है?",
                optionsEn = listOf(
                    "MPC consists of 6 members (3 from RBI and 3 appointed by Central Govt), and the RBI Governor has a second or casting vote in case of a tie.",
                    "MPC consists of 8 members chaired by the Union Finance Minister.",
                    "The inflation target set for MPC is 2% with a tolerance band of +/- 1%.",
                    "MPC meets only once a year prior to the Union Budget presentation."
                ),
                optionsHi = listOf(
                    "MPC में 6 सदस्य होते हैं (3 RBI से और 3 केंद्र सरकार द्वारा नियुक्त), तथा मत बराबर होने (Tie) की स्थिति में RBI गवर्नर के पास निर्णायक मत (Casting Vote) होता है।",
                    "MPC में केंद्रीय वित्त मंत्री की अध्यक्षता में 8 सदस्य होते हैं।",
                    "MPC के लिए निर्धारित मुद्रास्फीति लक्ष्य +/- 1% के दायरे के साथ 2% है।",
                    "MPC की बैठक केंद्रीय बजट से पहले वर्ष में केवल एक बार होती है।"
                ),
                correctIndex = 0,
                explanationEn = "Answer: (A).\n• Established on the Urjit Patel Committee's recommendation under Section 45ZB of the RBI Act, 1934.\n• Composition: 6 members (RBI Governor as ex-officio Chairperson + 2 RBI officials + 3 external members appointed by Central Govt for 4 years).\n• Inflation target: 4% Consumer Price Index (CPI) with a +/- 2% tolerance band (2% to 6%). Minimum 4 meetings per year.",
                explanationHi = "उत्तर: (A)।\n• उर्जित पटेल समिति की सिफारिश पर RBI अधिनियम, 1934 की धारा 45ZB के तहत MPC का गठन किया गया।\n• संरचना: कुल 6 सदस्य (RBI गवर्नर पदेन अध्यक्ष + 2 RBI अधिकारी + केंद्र सरकार द्वारा नियुक्त 3 बाहरी सदस्य)।\n• मुद्रास्फीति लक्ष्य: 4% उपभोक्ता मूल्य सूचकांक (CPI) जिसमें +/- 2% (अर्थात् 2% से 6%) की सहनशीलता सीमा है। वर्ष में कम से कम 4 बैठकें अनिवार्य हैं।",
                subject = "Banking & RBI Awareness",
                pyqYearTag = "SBI PO 2022, IBPS PO 2023 & RBI Grade-B PYQ",
                pyqFrequency = "Asked 9x in Last 5 Yrs",
                difficultyLevel = "Moderate-High",
                pyqTrendNoteEn = "MPC structure, CPI 4%±2% target, and Section 45ZB are staples in SBI PO Mains & RBI Grade B.",
                pyqTrendNoteHi = "MPC की संरचना, CPI 4%±2% लक्ष्य और धारा 45ZB बैंकिंग मुख्य परीक्षाओं के सबसे महत्वपूर्ण प्रश्न हैं।"
            ),
            TestQuestion(
                id = 402,
                questionEn = "According to the Reserve Bank of India (RBI) and NPCI guidelines, what is the enhanced transaction limit for UPI payments towards Healthcare and Education institutions (per transaction)?",
                questionHi = "भारतीय रिज़र्व बैंक (RBI) और NPCI के दिशानिर्देशों के अनुसार, स्वास्थ्य सेवा (अस्पतालों) और शैक्षणिक संस्थानों के लिए UPI भुगतान की बढ़ी हुई प्रति लेनदेन सीमा क्या है?",
                optionsEn = listOf(
                    "₹5 Lakh per transaction",
                    "₹1 Lakh per transaction",
                    "₹2 Lakh per transaction",
                    "₹10 Lakh per transaction"
                ),
                optionsHi = listOf(
                    "₹5 लाख प्रति लेनदेन",
                    "₹1 लाख प्रति लेनदेन",
                    "₹2 लाख प्रति लेनदेन",
                    "₹10 लाख प्रति लेनदेन"
                ),
                correctIndex = 0,
                explanationEn = "Answer: (A) ₹5 Lakh per transaction.\n• Normal peer-to-peer (P2P) UPI transaction limit is ₹1 Lakh per day.\n• However, RBI enhanced the UPI transaction limit for verified Healthcare (Hospitals), Educational Institutions, and Tax Payments (IPO/RBI Retail Direct) up to ₹5 Lakh per transaction.",
                explanationHi = "उत्तर: (A) ₹5 लाख प्रति लेनदेन।\n• सामान्य पीयर-टू-पीयर (P2P) UPI लेनदेन की सीमा ₹1 लाख प्रतिदिन है।\n• किंतु RBI ने सत्यापित अस्पतालों (स्वास्थ्य सेवा), शैक्षणिक संस्थानों तथा IPO/आरबीआई रिटेल डायरेक्ट के लिए UPI सीमा को बढ़ाकर ₹5 लाख प्रति लेनदेन कर दिया है।",
                subject = "Digital Banking & NPCI",
                pyqYearTag = "IBPS PO 2023 & SBI Clerk Mains 2024 PYQ",
                pyqFrequency = "Asked 7x in Last 5 Yrs",
                difficultyLevel = "Moderate",
                pyqTrendNoteEn = "UPI Lite, UPI 123Pay, e-RUPI, and CBDC limits are tested in every IBPS/SBI GA paper.",
                pyqTrendNoteHi = "UPI Lite, UPI 123Pay और डिजिटल रुपया (CBDC) की सीमाएं प्रत्येक बैंकिंग परीक्षा में पूछी जाती हैं।"
            ),
            TestQuestion(
                id = 403,
                questionEn = "What will be the difference between Compound Interest (compounded annually) and Simple Interest on a sum of ₹8,000 for 2 years at 10% per annum?",
                questionHi = "₹8,000 की धनराशि पर 10% वार्षिक ब्याज दर से 2 वर्षों के चक्रवृद्धि ब्याज (वार्षिक संयोजित) और साधारण ब्याज के बीच कितना अंतर होगा?",
                optionsEn = listOf(
                    "₹80",
                    "₹100",
                    "₹64",
                    "₹160"
                ),
                optionsHi = listOf(
                    "₹80",
                    "₹100",
                    "₹64",
                    "₹160"
                ),
                correctIndex = 0,
                explanationEn = "Answer: (A) ₹80.\n• Direct 2-Year CI - SI Difference Formula: Diff = P × (R / 100)²\n• Diff = 8000 × (10 / 100)² = 8000 × (1 / 100) = ₹80.",
                explanationHi = "उत्तर: (A) ₹80।\n• 2 वर्ष के चक्रवृद्धि ब्याज और साधारण ब्याज के अंतर का सीधा सूत्र: अंतर = P × (R / 100)²\n• अंतर = 8000 × (10 / 100)² = 8000 × (1 / 100) = ₹80।",
                subject = "Quantitative Aptitude (CI & SI)",
                pyqYearTag = "IBPS PO Prelims 2021, 2023 & SBI PO PYQ",
                pyqFrequency = "Asked 11x in Last 5 Yrs",
                difficultyLevel = "Easy-Moderate",
                pyqTrendNoteEn = "2-year and 3-year CI-SI difference questions are guaranteed speed-maths scorers in Banking Prelims.",
                pyqTrendNoteHi = "2 वर्ष और 3 वर्ष के चक्रवृद्धि-साधारण ब्याज अंतर वाले प्रश्न बैंकिंग प्रीलिम्स में निश्चित अंक दिलाने वाले प्रश्न हैं।"
            ),
            TestQuestion(
                id = 404,
                questionEn = "Under 'Basel-III Norms', Scheduled Commercial Banks in India are required by the RBI to maintain a minimum Capital to Risk-Weighted Assets Ratio (CRAR / CAR) of:",
                questionHi = "'बेसल-III मानकों' (Basel-III Norms) के तहत, भारत में अनुसूचित वाणिज्यिक बैंकों को RBI के अनुसार न्यूनतम कितना पूंजी पर्याप्तता अनुपात (CRAR / CAR) बनाए रखना आवश्यक है?",
                optionsEn = listOf(
                    "9% (excluding Capital Conservation Buffer of 2.5%, total 11.5%)",
                    "8% (including Capital Conservation Buffer)",
                    "15% for all commercial banks",
                    "6% for Public Sector Banks"
                ),
                optionsHi = listOf(
                    "9% (2.5% कैपिटल कंजर्वेशन बफर को छोड़कर, कुल 11.5%)",
                    "8% (कैपिटल कंजर्वेशन बफर सहित)",
                    "सभी वाणिज्यिक बैंकों के लिए 15%",
                    "सार्वजनिक क्षेत्र के बैंकों के लिए 6%"
                ),
                correctIndex = 0,
                explanationEn = "Answer: (A) 9% (excluding CCB of 2.5%, making total 11.5%).\n• While global Basel-III prescribes 8% minimum CRAR, the RBI mandates Indian Scheduled Commercial Banks to maintain a stricter minimum CRAR of 9% (plus 2.5% Capital Conservation Buffer = 11.5%).",
                explanationHi = "उत्तर: (A) 9% (2.5% कैपिटल कंजर्वेशन बफर को छोड़कर, कुल 11.5%)।\n• जहाँ वैश्विक बेसल-III मानक 8% न्यूनतम CRAR निर्धारित करता है, वहीं RBI ने भारतीय अनुसूचित वाणिज्यिक बैंकों के लिए 9% न्यूनतम CRAR (तथा 2.5% CCB सहित कुल 11.5%) अनिवार्य किया है।",
                subject = "Banking Regulation (Basel III)",
                pyqYearTag = "SBI PO Mains 2021 & IBPS PO 2023 PYQ",
                pyqFrequency = "Asked 6x in Last 5 Yrs",
                difficultyLevel = "High",
                pyqTrendNoteEn = "Basel-III, PCA (Prompt Corrective Action), and NPA classification (90 days) are core Banking Awareness topics.",
                pyqTrendNoteHi = "बेसल-III मानक, त्वरित सुधारात्मक कार्रवाई (PCA) और NPA वर्गीकरण (90 दिन) बैंकिंग जागरूकता के मूल स्तंभ हैं।"
            )
        )
    )

    // =========================================================================
    // 5. RAILWAYS, UPSSSC PET & POLICE (RRB NTPC / GROUP-D / UPSSSC) — 5-YR PYQ
    // Pattern: +1.0 Marks / -0.33 Negative | General Science (NCERT), Static GK & Arithmetic
    // =========================================================================
    val railwayUpssscPyqTest = MockTest(
        testId = "pyq_railway_upsssc_5yr",
        title = "Railways (RRB NTPC / ALP) & UPSSSC PET: Last 5 Years PYQ Test",
        hindiTitle = "रेलवे (RRB NTPC / ALP) एवं UPSSSC PET: विगत 5 वर्षीय PYQ विश्लेषण टेस्ट",
        examName = "RRB NTPC / ALP / UPSSSC PET / Police",
        durationMinutes = 15,
        totalMarks = 4,
        positiveMarks = 1.0,
        negativeMarks = 0.33,
        categoryId = "railway",
        pyqAnalysisEn = "Railways & UPSSSC 2020–2025 Trend: +1.0 / -0.33 (or -0.25 in PET). NCERT Class 9–10 General Science (Physics Numericals, Chemical Formulas, Human Biology) & Static GK account for 55%+ weightage.",
        pyqAnalysisHi = "रेलवे एवं UPSSSC 2020–2025 ट्रेंड: +1.0 / -0.33 (PET में -0.25) अंकन। NCERT कक्षा 9–10 सामान्य विज्ञान (भौतिकी न्यूमेरिकल, रासायनिक सूत्र, जीव विज्ञान) एवं स्टेटिक जीके का 55%+ भार।",
        topicWeightage = listOf(
            "NCERT General Science (35%)",
            "Static GK & Current Affairs (25%)",
            "Elementary Arithmetic & DI (20%)",
            "General Intelligence & Hindi/EN (20%)"
        ),
        questions = listOf(
            TestQuestion(
                id = 501,
                questionEn = "Two resistors of resistance 6 Ω and 3 Ω are connected in parallel across a 12 V battery. What is the equivalent resistance and total current flowing in the circuit?",
                questionHi = "6 Ω और 3 Ω प्रतिरोध के दो प्रतिरोधक 12 V की बैटरी के साथ समानांतर क्रम (Parallel) में जुड़े हैं। परिपथ का तुल्य प्रतिरोध और प्रवाहित कुल विद्युत धारा क्या होगी?",
                optionsEn = listOf(
                    "Equivalent Resistance = 2 Ω, Total Current = 6 A",
                    "Equivalent Resistance = 9 Ω, Total Current = 1.33 A",
                    "Equivalent Resistance = 2 Ω, Total Current = 24 A",
                    "Equivalent Resistance = 4.5 Ω, Total Current = 3 A"
                ),
                optionsHi = listOf(
                    "तुल्य प्रतिरोध = 2 Ω, कुल धारा = 6 A",
                    "तुल्य प्रतिरोध = 9 Ω, कुल धारा = 1.33 A",
                    "तुल्य प्रतिरोध = 2 Ω, कुल धारा = 24 A",
                    "तुल्य प्रतिरोध = 4.5 Ω, कुल धारा = 3 A"
                ),
                correctIndex = 0,
                explanationEn = "Answer: (A) Equivalent Resistance = 2 Ω, Total Current = 6 A.\n• Parallel Resistance formula: R_eq = (R1 × R2) / (R1 + R2) = (6 × 3) / (6 + 3) = 18 / 9 = 2 Ω.\n• By Ohm's Law (I = V / R_eq): I = 12 V / 2 Ω = 6 Ampere (A).",
                explanationHi = "उत्तर: (A) तुल्य प्रतिरोध = 2 Ω, कुल धारा = 6 A।\n• समानांतर प्रतिरोध सूत्र: R_eq = (R1 × R2) / (R1 + R2) = (6 × 3) / (6 + 3) = 18 / 9 = 2 Ω।\n• ओम के नियम से (I = V / R_eq): I = 12 V / 2 Ω = 6 एम्पियर (A)।",
                subject = "General Science (Physics)",
                pyqYearTag = "RRB NTPC CBT-1 & Group-D 2022 PYQ",
                pyqFrequency = "Asked 22+ Shifts in 5 Yrs",
                difficultyLevel = "Moderate",
                pyqTrendNoteEn = "Ohm's Law, Mirror/Lens formula (1/f = 1/v ± 1/u), and Electric Power (P = V×I) are asked in every RRB ALP/NTPC shift.",
                pyqTrendNoteHi = "ओम का नियम, दर्पण/लेंस सूत्र तथा विद्युत शक्ति के न्यूमेरिकल रेलवे ALP व NTPC की प्रत्येक शिफ्ट में पूछे जाते हैं।"
            ),
            TestQuestion(
                id = 502,
                questionEn = "What is the chemical name and chemical formula of 'Baking Soda' vs 'Washing Soda' frequently tested in Railway & UPSSSC exams?",
                questionHi = "रेलवे और UPSSSC परीक्षाओं में बार-बार पूछे जाने वाले 'बेकिंग सोडा' (खाने का सोडा) और 'वॉशिंग सोडा' (धोने का सोडा) का सही रासायनिक नाम एवं सूत्र क्या है?",
                optionsEn = listOf(
                    "Baking Soda: Sodium Hydrogen Carbonate (NaHCO₃) | Washing Soda: Sodium Carbonate Decahydrate (Na₂CO₃·10H₂O)",
                    "Baking Soda: Sodium Carbonate (Na₂CO₃) | Washing Soda: Sodium Bicarbonate (NaHCO₃)",
                    "Baking Soda: Calcium Oxychloride (CaOCl₂) | Washing Soda: Calcium Sulphate Hemihydrate",
                    "Baking Soda: Sodium Hydroxide (NaOH) | Washing Soda: Potassium Nitrate (KNO₃)"
                ),
                optionsHi = listOf(
                    "बेकिंग सोडा: सोडियम हाइड्रोजन कार्बोनेट (NaHCO₃) | वॉशिंग सोडा: सोडियम कार्बोनेट डेकाहाइड्रेट (Na₂CO₃·10H₂O)",
                    "बेकिंग सोडा: सोडियम कार्बोनेट (Na₂CO₃) | वॉशिंग सोडा: सोडियम बाइकार्बोनेट (NaHCO₃)",
                    "बेकिंग सोडा: कैल्शियम ऑक्सीक्लोराइड (CaOCl₂) | वॉशिंग सोडा: कैल्शियम सल्फेट हेमीहाइड्रेट",
                    "बेकिंग सोडा: सोडियम हाइड्रॉक्साइड (NaOH) | वॉशिंग सोडा: पोटेशियम नाइट्रेट (KNO₃)"
                ),
                correctIndex = 0,
                explanationEn = "Answer: (A).\n• Baking Soda: Sodium Bicarbonate / Sodium Hydrogen Carbonate (NaHCO₃).\n• Washing Soda: Sodium Carbonate Decahydrate (Na₂CO₃·10H₂O).\n• Bleaching Powder: Calcium Oxychloride (CaOCl₂).\n• Plaster of Paris (POP): Calcium Sulphate Hemihydrate (CaSO₄·½H₂O).",
                explanationHi = "उत्तर: (A)।\n• बेकिंग सोडा (खाने का सोडा): सोडियम बाइकार्बोनेट / सोडियम हाइड्रोजन कार्बोनेट (NaHCO₃)।\n• वॉशिंग सोडा (धोने का सोडा): सोडियम कार्बोनेट डेकाहाइड्रेट (Na₂CO₃·10H₂O)।\n• विरंजक चूर्ण (Bleaching Powder): कैल्शियम ऑक्सीक्लोराइड (CaOCl₂)।\n• प्लास्टर ऑफ पेरिस (POP): कैल्शियम सल्फेट हेमीहाइड्रेट (CaSO₄·½H₂O)।",
                subject = "General Science (Chemistry)",
                pyqYearTag = "RRB NTPC 2021, UPSSSC PET 2022 & UP Police 2024 PYQ",
                pyqFrequency = "Asked 25+ Shifts in 5 Yrs",
                difficultyLevel = "Easy",
                pyqTrendNoteEn = "NCERT Class 10 Chapter 2 (Acids, Bases and Salts — NaHCO3, CaOCl2, POP) is the single highest-yield Chemistry topic.",
                pyqTrendNoteHi = "NCERT कक्षा 10 अध्याय 2 (अम्ल, क्षारक एवं लवण) रसायन विज्ञान का सर्वाधिक प्रश्न देने वाला अध्याय है।"
            ),
            TestQuestion(
                id = 503,
                questionEn = "Where are the headquarters of the 'North Central Railway' (NCR) and 'North Eastern Railway' (NER) zones located in India?",
                questionHi = "भारत में 'उत्तर मध्य रेलवे' (NCR) और 'पूर्वोत्तर रेलवे' (NER) ज़ोन के मुख्यालय क्रमशः कहाँ स्थित हैं?",
                optionsEn = listOf(
                    "Prayagraj (Allahabad) and Gorakhpur",
                    "New Delhi and Varanasi",
                    "Jaipur and Hajipur",
                    "Jabalpur and Bilaspur"
                ),
                optionsHi = listOf(
                    "प्रयागराज (इलाहाबाद) और गोरखपुर",
                    "नई दिल्ली और वाराणसी",
                    "जयपुर और हाजीपुर",
                    "जबलपुर और बिलासपुर"
                ),
                correctIndex = 0,
                explanationEn = "Answer: (A) Prayagraj and Gorakhpur.\n• North Central Railway (NCR) Headquarters: Prayagraj (Uttar Pradesh).\n• North Eastern Railway (NER) Headquarters: Gorakhpur (Uttar Pradesh).\n• Northern Railway (NR): New Delhi | East Central Railway (ECR): Hajipur.",
                explanationHi = "उत्तर: (A) प्रयागराज और गोरखपुर।\n• उत्तर मध्य रेलवे (NCR) का मुख्यालय: प्रयागराज (उत्तर प्रदेश)।\n• पूर्वोत्तर रेलवे (NER) का मुख्यालय: गोरखपुर (उत्तर प्रदेश)।\n• उत्तर रेलवे (NR): नई दिल्ली | पूर्व मध्य रेलवे (ECR): हाजीपुर।",
                subject = "Static GK (Indian Railways & UP GK)",
                pyqYearTag = "RRB NTPC 2021 & UPSSSC PET 2023 PYQ",
                pyqFrequency = "Asked 10x in Last 5 Yrs",
                difficultyLevel = "Easy",
                pyqTrendNoteEn = "18 Railway Zones & Headquarters and National Waterways are mandatory Static GK topics for RRB & UP exams.",
                pyqTrendNoteHi = "भारतीय रेलवे के 18 ज़ोन व उनके मुख्यालय रेलवे तथा उत्तर प्रदेश की परीक्षाओं के लिए अनिवार्य विषय हैं।"
            ),
            TestQuestion(
                id = 504,
                questionEn = "Which Five-Year Plan in India was based on the 'P.C. Mahalanobis Model' and focused on rapid industrialization and heavy industries (Bhilai, Durgapur, Rourkela Steel Plants)?",
                questionHi = "भारत की कौन-सी पंचवर्षीय योजना 'पी.सी. महालनोबिस मॉडल' पर आधारित थी और इसमें तीव्र औद्योगीकरण एवं भारी उद्योगों (भिलाई, दुर्गापुर, राउरकेला इस्पात संयंत्र) पर बल दिया गया था?",
                optionsEn = listOf(
                    "Second Five-Year Plan (1956–1961)",
                    "First Five-Year Plan (1951–1956)",
                    "Third Five-Year Plan (1961–1966)",
                    "Fifth Five-Year Plan (1974–1978)"
                ),
                optionsHi = listOf(
                    "द्वितीय पंचवर्षीय योजना (1956–1961)",
                    "प्रथम पंचवर्षीय योजना (1951–1956)",
                    "तृतीय पंचवर्षीय योजना (1961–1966)",
                    "पाँचवीं पंचवर्षीय योजना (1974–1978)"
                ),
                correctIndex = 0,
                explanationEn = "Answer: (A) Second Five-Year Plan (1956–1961).\n• 1st Plan (1951–56): Harrod-Domar Model (Focus: Agriculture).\n• 2nd Plan (1956–61): P.C. Mahalanobis Model (Focus: Rapid Industrialization; Bhilai, Durgapur & Rourkela steel plants established).\n• 5th Plan (1974–78): 'Garibi Hatao' (Poverty Alleviation & Self-Reliance).",
                explanationHi = "उत्तर: (A) द्वितीय पंचवर्षीय योजना (1956–1961)।\n• प्रथम योजना (1951–56): हैरोड-डोमर मॉडल (कृषि पर बल)।\n• द्वितीय योजना (1956–61): पी.सी. महालनोबिस मॉडल (तीव्र औद्योगीकरण; भिलाई, दुर्गापुर व राउरकेला इस्पात संयंत्र स्थापित)।\n• पाँचवीं योजना (1974–78): 'गरीबी हटाओ' और आत्मनिर्भरता।",
                subject = "Indian Economy (Five-Year Plans)",
                pyqYearTag = "UPSSSC PET 2021, 2022, 2023 & RRB NTPC PYQ",
                pyqFrequency = "Asked 15x in Last 5 Yrs",
                difficultyLevel = "Easy-Moderate",
                pyqTrendNoteEn = "Five-Year Plans (1951–2017) & Green/White Revolution appear in every single UPSSSC PET and Railway shift.",
                pyqTrendNoteHi = "पंचवर्षीय योजनाएं (1951–2017) और हरित/श्वेत क्रांति UPSSSC PET एवं रेलवे की हर शिफ्ट में पूछी जाती हैं।"
            )
        )
    )

    // =========================================================================
    // 6. NEET UG / JEE MAIN & UGC NET — 2020 TO 2025 NTA PYQ ANALYSIS TEST
    // Pattern: +4.0 Marks / -1.0 Negative | NCERT Line-by-Line Assertion-Reason & Conceptual Numericals
    // =========================================================================
    val neetJeeNetPyqTest = MockTest(
        testId = "pyq_nta_neet_jee_net_5yr",
        title = "NTA (NEET UG / JEE Main / UGC NET): Last 5 Years (2020–2025) PYQ Test",
        hindiTitle = "NTA (NEET UG / JEE Main / UGC NET): विगत 5 वर्षीय (2020–2025) PYQ विश्लेषण टेस्ट",
        examName = "NTA NEET UG / JEE Main / UGC NET",
        durationMinutes = 15,
        totalMarks = 16,
        positiveMarks = 4.0,
        negativeMarks = 1.0,
        categoryId = "neet_jee",
        pyqAnalysisEn = "NTA 2020–2025 Trend: +4.0 / -1.0 marking. Since 2022, NTA heavily emphasizes NCERT Statement-I & Statement-II and Assertion-Reason questions in Biology, Chemistry, Physics, and Research/Teaching Aptitude.",
        pyqAnalysisHi = "NTA 2020–2025 ट्रेंड: +4.0 / -1.0 अंकन। 2022 से NTA ने जीव विज्ञान, रसायन, भौतिकी एवं शिक्षण/शोध अभिक्षमता में NCERT आधारित कथन-I व कथन-II तथा अभिकथन-कारण (Assertion-Reason) प्रश्नों को बढ़ा दिया है।",
        topicWeightage = listOf(
            "NCERT Biology & Genetics (30%)",
            "Chemical Bonding & Organic (25%)",
            "Modern Physics & Electrodynamics (25%)",
            "UGC NET Teaching & Research Aptitude (20%)"
        ),
        questions = listOf(
            TestQuestion(
                id = 601,
                questionEn = "Given below are two statements based on NCERT Molecular Basis of Inheritance:\nStatement I: In prokaryotes like E. coli, DNA is negatively charged and held with some positively charged proteins in a region termed as 'Nucleoid'.\nStatement II: In eukaryotes, DNA is negatively charged and wrapped around positively charged Histone octamer (rich in basic amino acids Lysine and Arginine) to form a 'Nucleosome'.\nIn the light of the above statements, choose the correct answer:",
                questionHi = "नीचे NCERT 'वंशागति के आणविक आधार' पर आधारित दो कथन दिए गए हैं:\nकथन I: ई. कोलाई (E. coli) जैसे प्रोकैरियोट्स में, ऋणावेशित DNA कुछ धनावेशित प्रोटीनों के साथ 'न्यूक्लियॉइड' (Nucleoid) नामक क्षेत्र में बंधा होता है।\nकथन II: यूकैरियोट्स में, ऋणावेशित DNA धनावेशित हिस्टोन अष्टक (जिसमें लाइसिन और आर्जिनिन अमीनो अम्ल की अधिकता होती है) के चारों ओर लिपटकर 'न्यूक्लियोसोम' (Nucleosome) बनाता है।\nउपर्युक्त कथनों के आलोक में सही उत्तर चुनिए:",
                optionsEn = listOf(
                    "Both Statement I and Statement II are correct.",
                    "Both Statement I and Statement II are incorrect.",
                    "Statement I is correct but Statement II is incorrect.",
                    "Statement I is incorrect but Statement II is correct."
                ),
                optionsHi = listOf(
                    "कथन I और कथन II दोनों सही हैं।",
                    "कथन I और कथन II दोनों गलत हैं।",
                    "कथन I सही है किंतु कथन II गलत है।",
                    "कथन I गलत है किंतु कथन II सही है।"
                ),
                correctIndex = 0,
                explanationEn = "Answer: (A) Both Statement I and Statement II are correct.\n• Exact NCERT Class 12 Biology (Chapter 6): DNA is an acidic, negatively charged polymer due to phosphate groups.\n• In prokaryotes, it is held in the 'Nucleoid'. In eukaryotes, it wraps around a positively charged Histone Octamer (rich in Lysine & Arginine) to form a Nucleosome (~200 bp of DNA).",
                explanationHi = "उत्तर: (A) कथन I और कथन II दोनों सही हैं।\n• NCERT कक्षा 12 जीव विज्ञान (अध्याय 6) की सीधी पंक्ति: फॉस्फेट समूहों के कारण DNA ऋणावेशित होता है।\n• प्रोकैरियोट्स में यह 'न्यूक्लियॉइड' में स्थित होता है तथा यूकैरियोट्स में लाइसिन और आर्जिनिन से भरपूर धनावेशित हिस्टोन अष्टक के चारों ओर लिपटकर 'न्यूक्लियोसोम' (~200 क्षार युग्म) बनाता है।",
                subject = "Biology (Genetics & Molecular Bio)",
                pyqYearTag = "NEET UG 2022, 2023 & 2024 Direct PYQ",
                pyqFrequency = "Asked 5x in Last 5 Yrs",
                difficultyLevel = "Moderate-High (NTA Statement Pattern)",
                pyqTrendNoteEn = "Molecular Basis of Inheritance & Biotechnology alone contribute 14–16 questions (56–64 marks) in NEET UG every year.",
                pyqTrendNoteHi = "वंशागति का आणविक आधार और जैव-प्रौद्योगिकी से प्रतिवर्ष NEET UG में 14–16 प्रश्न (56–64 अंक) पूछे जाते हैं।"
            ),
            TestQuestion(
                id = 602,
                questionEn = "According to VSEPR Theory and Molecular Orbital Theory, which of the following pairs of species have the SAME bond order and isoelectronic nature?",
                questionHi = "VSEPR सिद्धांत और आणविक कक्षक सिद्धांत (MOT) के अनुसार, निम्नलिखित में से किस युग्म की प्रजातियों में समान आबंध कोटि (Bond Order = 3.0) है और वे समइलेक्ट्रॉनिक (Isoelectronic) हैं?",
                optionsEn = listOf(
                    "CO, NO⁺ and CN⁻ (All have 14 electrons and Bond Order = 3.0)",
                    "O₂⁻ and N₂ (Bond Order = 2.0)",
                    "B₂ and C₂ (Bond Order = 3.0)",
                    "NO and O₂⁺ (Bond Order = 1.5)"
                ),
                optionsHi = listOf(
                    "CO, NO⁺ और CN⁻ (सभी में 14 इलेक्ट्रॉन और आबंध कोटि = 3.0 है)",
                    "O₂⁻ और N₂ (आबंध कोटि = 2.0)",
                    "B₂ और C₂ (आबंध कोटि = 3.0)",
                    "NO और O₂⁺ (आबंध कोटि = 1.5)"
                ),
                correctIndex = 0,
                explanationEn = "Answer: (A) CO, NO⁺ and CN⁻.\n• Total electrons in CO (6+8 = 14), NO⁺ (7+8-1 = 14), CN⁻ (6+7+1 = 14), and N₂ (7+7 = 14).\n• By Molecular Orbital Theory (MOT), any 14-electron diatomic species has a Bond Order of 3.0 and is diamagnetic.",
                explanationHi = "उत्तर: (A) CO, NO⁺ और CN⁻।\n• कुल इलेक्ट्रॉनों की संख्या: CO (6+8 = 14), NO⁺ (7+8-1 = 14), CN⁻ (6+7+1 = 14) तथा N₂ (7+7 = 14)।\n• आणविक कक्षक सिद्धांत (MOT) के अनुसार, 14 इलेक्ट्रॉन वाली सभी द्विपरमाणुक प्रजातियों की आबंध कोटि (Bond Order) 3.0 होती है और वे प्रतिचुंबकीय (Diamagnetic) होती हैं।",
                subject = "Chemistry (Chemical Bonding)",
                pyqYearTag = "JEE Main 2021, 2023, 2024 & NEET UG PYQ",
                pyqFrequency = "Asked 15+ Shifts in 5 Yrs",
                difficultyLevel = "Moderate",
                pyqTrendNoteEn = "MOT Bond Order of 14-electron species (N2, CO, CN-, NO+) is NTA's #1 favorite question in both JEE Main and NEET UG.",
                pyqTrendNoteHi = "14-इलेक्ट्रॉन प्रजातियों (N2, CO, CN-, NO+) की आबंध कोटि (Bond Order) JEE Main और NEET दोनों में NTA का सबसे पसंदीदा प्रश्न है।"
            ),
            TestQuestion(
                id = 603,
                questionEn = "If the de-Broglie wavelength of a particle of mass 'm' is λ, then its kinetic energy (K) is given by (where h is Planck's constant):",
                questionHi = "यदि 'm' द्रव्यमान के किसी कण की दे-ब्रॉग्ली (de-Broglie) तरंगदैर्ध्य λ है, तो उसकी गतिज ऊर्जा (K) क्या होगी (जहाँ h प्लांक नियतांक है)?",
                optionsEn = listOf(
                    "K = h² / (2 m λ²)",
                    "K = h / (2 m λ)",
                    "K = h² / (2 m² λ²)",
                    "K = 2 m λ² / h²"
                ),
                optionsHi = listOf(
                    "K = h² / (2 m λ²)",
                    "K = h / (2 m λ)",
                    "K = h² / (2 m² λ²)",
                    "K = 2 m λ² / h²"
                ),
                correctIndex = 0,
                explanationEn = "Answer: (A) K = h² / (2 m λ²).\n• de-Broglie wavelength formula: λ = h / p = h / √(2mK).\n• Squaring both sides: λ² = h² / (2mK)  =>  K = h² / (2 m λ²).",
                explanationHi = "उत्तर: (A) K = h² / (2 m λ²)।\n• दे-ब्रॉग्ली तरंगदैर्ध्य सूत्र: λ = h / p = h / √(2mK)।\n• दोनों पक्षों का वर्ग करने पर: λ² = h² / (2mK)  =>  K = h² / (2 m λ²)।",
                subject = "Physics (Dual Nature of Matter)",
                pyqYearTag = "JEE Main 2022, 2024 & NEET UG 2023 PYQ",
                pyqFrequency = "Asked 12x in Last 5 Yrs",
                difficultyLevel = "Moderate",
                pyqTrendNoteEn = "Modern Physics (de-Broglie wavelength, Photoelectric Effect, Bohr Model, Logic Gates) is the highest ROI unit in JEE & NEET Physics.",
                pyqTrendNoteHi = "आधुनिक भौतिकी (दे-ब्रॉग्ली तरंगदैर्ध्य, प्रकाश-विद्युत प्रभाव, बोहर मॉडल, लॉजिक गेट) भौतिकी का सर्वाधिक स्कोरिंग खंड है।"
            ),
            TestQuestion(
                id = 604,
                questionEn = "In UGC NET Paper-I (Research Aptitude), which type of research focuses on immediate classroom or institutional problem-solving through a cyclical process of 'Plan -> Act -> Observe -> Reflect'?",
                questionHi = "UGC NET पेपर-I (शोध अभिक्षमता) में, किस प्रकार का अनुसंधान 'योजना (Plan) -> क्रिया (Act) -> अवलोकन (Observe) -> चिंतन (Reflect)' के चक्रीय क्रम के माध्यम से तात्कालिक कक्षा या संस्थागत समस्या के समाधान पर केंद्रित होता है?",
                optionsEn = listOf(
                    "Action Research (क्रियात्मक शोध)",
                    "Ex-Post Facto Research (कार्य्योत्तर शोध)",
                    "Fundamental / Basic Research (मौलिक शोध)",
                    "Historical Research (ऐतिहासिक शोध)"
                ),
                optionsHi = listOf(
                    "क्रियात्मक शोध (Action Research)",
                    "कार्य्योत्तर शोध (Ex-Post Facto Research)",
                    "मौलिक / मूलभूत शोध (Fundamental Research)",
                    "ऐतिहासिक शोध (Historical Research)"
                ),
                correctIndex = 0,
                explanationEn = "Answer: (A) Action Research.\n• Coined by Kurt Lewin, Action Research is an applied research methodology aimed at immediate local problem-solving (amelioration of practices) following the spiral cycle: Plan -> Act -> Observe -> Reflect.",
                explanationHi = "उत्तर: (A) क्रियात्मक शोध (Action Research)।\n• कर्ट लेविन (Kurt Lewin) द्वारा प्रतिपादित क्रियात्मक शोध का उद्देश्य तात्कालिक स्थानीय या शैक्षिक समस्या का समाधान करना है। इसका प्रसिद्ध चक्र है: योजना (Plan) -> क्रिया (Act) -> अवलोकन (Observe) -> चिंतन (Reflect)।",
                subject = "UGC NET Paper-1 (Research Aptitude)",
                pyqYearTag = "UGC NET 2020, 2021, 2022, 2023, 2024 PYQ",
                pyqFrequency = "Asked in Every UGC NET Cycle",
                difficultyLevel = "Easy-Moderate",
                pyqTrendNoteEn = "Action Research ('Plan-Act-Observe-Reflect') and Experimental vs Ex-Post Facto Research appear in 90% of UGC NET Paper-1 shifts.",
                pyqTrendNoteHi = "क्रियात्मक शोध ('Plan-Act-Observe-Reflect') तथा प्रयोगात्मक बनाम कार्य्योत्तर शोध UGC NET पेपर-1 के 90% प्रश्नपत्रों में पूछे जाते हैं।"
            )
        )
    )

    // Core lightweight 5-Year PYQ Tests for instant UI startup
    val coreQuickPyqTests: List<MockTest> by lazy {
        listOf(
            upscPyqTest,
            statePscPyqTest,
            sscPyqTest,
            bankingPyqTest,
            railwayUpssscPyqTest,
            neetJeeNetPyqTest
        )
    }

    // All 7 UPSC CSE Subject-Wise 50-Question Free PYQ Tests (350 Questions Total)
    val upscSubject50Tests: List<MockTest> by lazy {
        com.example.data.upsc.UpscSciTechIrCaPyqData.all7UpscSectionTests.map { it.mockTest }
    }

    // All 7 UPPCS Subject-Wise 50-Question Free PYQ Tests (350 Questions Total)
    val uppcsSubject50Tests: List<MockTest> by lazy {
        com.example.data.uppcs.UppcsUpCaEcoPyqData.all7UppcsSectionTests.map { it.mockTest }
    }

    // All 8 UKPSC (Uttarakhand PCS) Section Tests: 100-Q Uttarakhand Special + 7×50-Q Subject Tests (450 Questions Total)
    val ukpscSubjectTests: List<MockTest> by lazy {
        com.example.data.ukpsc.UkpscAllSubjectsPyqData.all8UkpscSectionTests.map { it.mockTest }
    }

    // All 7 BPSC (Bihar PCS) Section Tests: 7×100-Q Subject Tests (700 Questions Total)
    val bpscSubject100Tests: List<MockTest> by lazy {
        com.example.data.bpsc.BpscAllSubjects100PyqData.all7BpscSectionTests.map { it.mockTest }
    }

    // All 9 UPSSSC Section Tests: 6 GK×100-Q + UP Special 250-Q + Computer 100-Q + DI 100-Q (1,050 Questions Total)
    val upssscSubjectTests: List<MockTest> by lazy {
        com.example.data.upsssc.UpssscAllSubjectsPyqData.all9UpssscSectionTests.map { it.mockTest }
    }

    // All 10 UKSSSC (Uttarakhand Group C/D) Section Tests: 6 GK×100-Q + Uttarakhand Special 250-Q + Hindi 100-Q + Computer 100-Q + Reasoning/DI 100-Q (1,150 Questions Total)
    val ukssscSubjectTests: List<MockTest> by lazy {
        com.example.data.uksssc.UkssscAllSubjectsPyqData.all10UkssscSectionTests.map { it.mockTest }
    }

    // All 8 SSC CGL / CHSL / CPO Section Tests: 5 GS×100-Q (History, Polity, Geography, Environment, Economics) + Reasoning 100-Q + Mathematics 100-Q + English 100-Q (800 Questions Total)
    val sscSubject100Tests: List<MockTest> by lazy {
        com.example.data.ssc.SscAllSubjectsPyqData.all8SscSectionTests.map { it.mockTest }
    }

    // All 10 IIT JEE (Main & Advanced) Section Tests: 5 JEE Main×100-Q + 5 JEE Advanced×100-Q (1,000 Questions Total)
    val iitJeeSubject100Tests: List<MockTest> by lazy {
        com.example.data.iitjee.IitJeeAllSubjectsPyqData.allIitJeeSectionTests
    }

    // All 6 NEET (UG) Section Tests: Physics 100-Q + Physical Chem 100-Q + Organic Chem 100-Q + Inorganic Chem 100-Q + Botany 100-Q + Zoology 100-Q (600 Questions Total)
    val neetSubject100Tests: List<MockTest> by lazy {
        com.example.data.neet.NeetAllSubjectsPyqData.allNeetSectionTests
    }

    // All 22 UGC NET (Paper 1 & Paper 2) Section Tests: 10 Paper-1 Units×100-Q (1,000 Qs) + 12 Paper-2 Subjects×100-Q (1,200 Qs) = 2,200 Questions Total
    val ugcNetSubject100Tests: List<MockTest> by lazy {
        com.example.data.ugcnet.UgcNetAllSubjectsPyqData.allUgcNetSectionTests
    }

    // All 7 TET (CTET / UPTET / UTET & Others) Section Tests: 7 Subjects×100-Q = 700 Questions Total
    val tetSubject100Tests: List<MockTest> by lazy {
        com.example.data.tet.TetAllSubjectsPyqData.allTetSectionTests
    }

    // All Exam-Specific 5-Year PYQ Tests + 7 UPSC + 7 UPPCS + 8 UKPSC + 7 BPSC + 9 UPSSSC + 10 UKSSSC + 8 SSC + 10 IIT JEE + 6 NEET + 22 UGC NET + 7 TET Tests
    val allPyqTests: List<MockTest> by lazy {
        upscSubject50Tests + uppcsSubject50Tests + ukpscSubjectTests + bpscSubject100Tests + upssscSubjectTests + ukssscSubjectTests + sscSubject100Tests + iitJeeSubject100Tests + neetSubject100Tests + ugcNetSubject100Tests + tetSubject100Tests + coreQuickPyqTests
    }

    /**
     * Returns the best-matching 5-Year PYQ MockTest for any given exam categoryId, sectionId, or examName.
     */
    fun getPyqTestForCategory(categoryOrExamId: String?): MockTest {
        val key = categoryOrExamId?.lowercase()?.trim() ?: return com.example.data.upsc.UpscHistoryPolityPyqData.upscHistory50Test
        // Check if it matches a specific UPSC 50-question subject test
        com.example.data.upsc.UpscSciTechIrCaPyqData.all7UpscSectionTests.firstOrNull {
            it.sectionId.equals(key, ignoreCase = true) ||
                it.mockTest.testId.equals(key, ignoreCase = true)
        }?.let { return it.mockTest }

        // Check if it matches a specific UPPCS 50-question subject test
        com.example.data.uppcs.UppcsUpCaEcoPyqData.all7UppcsSectionTests.firstOrNull {
            it.sectionId.equals(key, ignoreCase = true) ||
                it.mockTest.testId.equals(key, ignoreCase = true)
        }?.let { return it.mockTest }

        // Check if it matches a specific UKPSC (Uttarakhand PCS) 100-Q or 50-Q section test
        com.example.data.ukpsc.UkpscAllSubjectsPyqData.all8UkpscSectionTests.firstOrNull {
            it.sectionId.equals(key, ignoreCase = true) ||
                it.mockTest.testId.equals(key, ignoreCase = true)
        }?.let { return it.mockTest }

        // Check if it matches a specific BPSC (Bihar PCS) 100-Q section test
        com.example.data.bpsc.BpscAllSubjects100PyqData.all7BpscSectionTests.firstOrNull {
            it.sectionId.equals(key, ignoreCase = true) ||
                it.mockTest.testId.equals(key, ignoreCase = true)
        }?.let { return it.mockTest }

        // Check if it matches a specific UPSSSC 100-Q or 250-Q section test
        com.example.data.upsssc.UpssscAllSubjectsPyqData.all9UpssscSectionTests.firstOrNull {
            it.sectionId.equals(key, ignoreCase = true) ||
                it.id.equals(key, ignoreCase = true) ||
                it.mockTest.testId.equals(key, ignoreCase = true)
        }?.let { return it.mockTest }

        // Check if it matches a specific UKSSSC (Uttarakhand Group C/D) 100-Q or 250-Q section test
        com.example.data.uksssc.UkssscAllSubjectsPyqData.all10UkssscSectionTests.firstOrNull {
            it.sectionId.equals(key, ignoreCase = true) ||
                it.id.equals(key, ignoreCase = true) ||
                it.mockTest.testId.equals(key, ignoreCase = true)
        }?.let { return it.mockTest }

        // Check if it matches a specific SSC CGL / CHSL / CPO 100-Q section test
        com.example.data.ssc.SscAllSubjectsPyqData.all8SscSectionTests.firstOrNull {
            it.sectionId.equals(key, ignoreCase = true) ||
                it.id.equals(key, ignoreCase = true) ||
                it.mockTest.testId.equals(key, ignoreCase = true)
        }?.let { return it.mockTest }

        // Check if it matches a specific IIT JEE Main or IIT JEE Advanced 100-Q section test
        com.example.data.iitjee.IitJeeAllSubjectsPyqData.getTestBySectionOrTestId(key)?.let { return it }

        // Check if it matches a specific NEET (UG) 100-Q section test
        com.example.data.neet.NeetAllSubjectsPyqData.getTestBySectionOrTestId(key)?.let { return it }

        // Check if it matches a specific UGC NET Paper 1 (10 Units) or Paper 2 (12 Subjects) 100-Q section test
        com.example.data.ugcnet.UgcNetAllSubjectsPyqData.getTestBySectionOrTestId(key)?.let { return it }

        // Check if it matches a specific TET (CTET / UPTET / UTET) 100-Q section test
        com.example.data.tet.TetAllSubjectsPyqData.getTestBySectionOrTestId(key)?.let { return it }

        return when {
            key == "tet" || key == "teaching" || key == "ctet" || key == "uptet" || key == "utet" || key.startsWith("tet_") ->
                com.example.data.tet.TetAllSubjectsPyqData.allTetSectionTests[0]
            key == "ugc_net" || key == "ugc_csir_net" || key.startsWith("ugc_") ->
                com.example.data.ugcnet.UgcNetAllSubjectsPyqData.allUgcNetSectionTests[0]
            key == "neet" || key == "neet_ug" || key.startsWith("neet_") ->
                com.example.data.neet.NeetAllSubjectsPyqData.allNeetSectionTests[4] // Botany 100-Q or Physics
            key == "iit_jee_advanced" || key == "jee_advanced" ->
                com.example.data.iitjee.IitJeeAllSubjectsPyqData.allIitJeeSectionTests[5]
            key == "iit_jee" || key == "jee_main" || key == "jee_neet" || key.startsWith("jee_") ->
                com.example.data.iitjee.IitJeeAllSubjectsPyqData.allIitJeeSectionTests[0]
            key.contains("ssc_gs_history") || key.contains("ssc_history") || key.contains("ssc_sec_history") ->
                com.example.data.ssc.SscAllSubjectsPyqData.sscGsHistory100Test
            key.contains("ssc_gs_polity") || key.contains("ssc_polity") || key.contains("ssc_sec_polity") ->
                com.example.data.ssc.SscAllSubjectsPyqData.sscGsPolity100Test
            key.contains("ssc_gs_geography") || key.contains("ssc_geography") || key.contains("ssc_sec_geography") ->
                com.example.data.ssc.SscAllSubjectsPyqData.sscGsGeography100Test
            key.contains("ssc_gs_environment") || key.contains("ssc_environment") || key.contains("ssc_sec_environment") ->
                com.example.data.ssc.SscAllSubjectsPyqData.sscGsEnvironment100Test
            key.contains("ssc_gs_economics") || key.contains("ssc_economics") || key.contains("ssc_economy") || key.contains("ssc_sec_economics") ->
                com.example.data.ssc.SscAllSubjectsPyqData.sscGsEconomics100Test
            key.contains("ssc_reasoning") || key.contains("ssc_sec_reasoning") || key.contains("ssc_cgl_reasoning") ->
                com.example.data.ssc.SscAllSubjectsPyqData.sscReasoning100Test
            key.contains("ssc_mathematics") || key.contains("ssc_maths") || key.contains("ssc_quant") || key.contains("ssc_cgl_quant") || key.contains("ssc_sec_mathematics") ->
                com.example.data.ssc.SscAllSubjectsPyqData.sscMathematics100Test
            key.contains("ssc_english") || key.contains("ssc_cgl_english") || key.contains("ssc_sec_english") ->
                com.example.data.ssc.SscAllSubjectsPyqData.sscEnglish100Test
            key == "pyq_ssc_cgl_5yr" -> sscPyqTest
            key.contains("ssc") || key.contains("cgl") || key.contains("chsl") || key.contains("cpo") ->
                com.example.data.ssc.SscAllSubjectsPyqData.sscGsHistory100Test
            key.contains("uksssc_uk_special") || key.contains("uksssc_special") || key.contains("sub_uksssc") || key == "uksssc" ->
                com.example.data.uksssc.UkssscAllSubjectsPyqData.ukssscUttarakhandSpecial250Test
            key.contains("uksssc_history") -> com.example.data.uksssc.UkssscAllSubjectsPyqData.ukssscHistory100Test
            key.contains("uksssc_polity") -> com.example.data.uksssc.UkssscAllSubjectsPyqData.ukssscPolity100Test
            key.contains("uksssc_geography") -> com.example.data.uksssc.UkssscAllSubjectsPyqData.ukssscGeography100Test
            key.contains("uksssc_economics") || key.contains("uksssc_economy") -> com.example.data.uksssc.UkssscAllSubjectsPyqData.ukssscEconomics100Test
            key.contains("uksssc_environment") -> com.example.data.uksssc.UkssscAllSubjectsPyqData.ukssscEnvironment100Test
            key.contains("uksssc_scitech") || key.contains("uksssc_science") -> com.example.data.uksssc.UkssscAllSubjectsPyqData.ukssscSciTech100Test
            key.contains("uksssc_hindi") -> com.example.data.uksssc.UkssscAllSubjectsPyqData.ukssscGeneralHindi100Test
            key.contains("uksssc_computer") -> com.example.data.uksssc.UkssscAllSubjectsPyqData.ukssscComputer100Test
            key.contains("uksssc_reasoning") || key.contains("uksssc_di") -> com.example.data.uksssc.UkssscAllSubjectsPyqData.ukssscReasoningDi100Test
            key.contains("uksssc") ->
                com.example.data.uksssc.UkssscAllSubjectsPyqData.ukssscUttarakhandSpecial250Test
            key.contains("upsssc_up_special") || key.contains("up_special_250") || key.contains("sub_upsssc") || key == "upsssc" ->
                com.example.data.upsssc.UpssscAllSubjectsPyqData.upssscUpSpecial250Test
            key.contains("upsssc_history") -> com.example.data.upsssc.UpssscAllSubjectsPyqData.upssscHistory100Test
            key.contains("upsssc_polity") -> com.example.data.upsssc.UpssscAllSubjectsPyqData.upssscPolity100Test
            key.contains("upsssc_geography") -> com.example.data.upsssc.UpssscAllSubjectsPyqData.upssscGeography100Test
            key.contains("upsssc_economics") || key.contains("upsssc_economy") -> com.example.data.upsssc.UpssscAllSubjectsPyqData.upssscEconomics100Test
            key.contains("upsssc_environment") -> com.example.data.upsssc.UpssscAllSubjectsPyqData.upssscEnvironment100Test
            key.contains("upsssc_scitech") || key.contains("upsssc_science") -> com.example.data.upsssc.UpssscAllSubjectsPyqData.upssscSciTech100Test
            key.contains("upsssc_computer") -> com.example.data.upsssc.UpssscAllSubjectsPyqData.upssscComputer100Test
            key.contains("upsssc_di") || key.contains("data_interpretation") -> com.example.data.upsssc.UpssscAllSubjectsPyqData.upssscDi100Test
            key.contains("upsssc") || key.contains("lekhpal") || key.contains("vdo") || key == "subordinate_selection" ->
                com.example.data.upsssc.UpssscAllSubjectsPyqData.upssscUpSpecial250Test
            key.contains("bpsc_bihar_special") || key.contains("bihar_special") || key.contains("psc_bpsc") || key == "bpsc" ->
                com.example.data.bpsc.BpscAllSubjects100PyqData.bpscBiharSpecial100Test
            key.contains("bpsc_history") -> com.example.data.bpsc.BpscAllSubjects100PyqData.bpscHistory100Test
            key.contains("bpsc_polity") -> com.example.data.bpsc.BpscAllSubjects100PyqData.bpscPolity100Test
            key.contains("bpsc_geography") -> com.example.data.bpsc.BpscAllSubjects100PyqData.bpscGeography100Test
            key.contains("bpsc_economics") || key.contains("bpsc_economy") -> com.example.data.bpsc.BpscAllSubjects100PyqData.bpscEconomics100Test
            key.contains("bpsc_science") || key.contains("bpsc_scitech") -> com.example.data.bpsc.BpscAllSubjects100PyqData.bpscScience100Test
            key.contains("bpsc_ca") || key.contains("bpsc_current") -> com.example.data.bpsc.BpscAllSubjects100PyqData.bpscCurrentAffairs100Test
            key.contains("bpsc") || key.contains("bihar") ->
                com.example.data.bpsc.BpscAllSubjects100PyqData.bpscBiharSpecial100Test
            key.contains("ukpsc_special") || key.contains("uttarakhand_special") || key.contains("psc_ukpsc") || key == "ukpsc" ->
                com.example.data.ukpsc.UkpscSpecial100PyqData.ukpscUttarakhandSpecial100Test
            key.contains("ukpsc_history") -> com.example.data.ukpsc.UkpscAllSubjectsPyqData.ukpscHistory50Test
            key.contains("ukpsc_polity") -> com.example.data.ukpsc.UkpscAllSubjectsPyqData.ukpscPolity50Test
            key.contains("ukpsc_geography") -> com.example.data.ukpsc.UkpscAllSubjectsPyqData.ukpscGeography50Test
            key.contains("ukpsc_economics") -> com.example.data.ukpsc.UkpscAllSubjectsPyqData.ukpscEconomics50Test
            key.contains("ukpsc_environment") -> com.example.data.ukpsc.UkpscAllSubjectsPyqData.ukpscEnvironment50Test
            key.contains("ukpsc_scitech") || key.contains("ukpsc_science") || key.contains("ukpsc_computer") ->
                com.example.data.ukpsc.UkpscAllSubjectsPyqData.ukpscSciTech50Test
            key.contains("ukpsc_ca") || key.contains("ukpsc_current") ->
                com.example.data.ukpsc.UkpscAllSubjectsPyqData.ukpscCurrentAffairs50Test
            key.contains("upsc_history") -> com.example.data.upsc.UpscHistoryPolityPyqData.upscHistory50Test
            key.contains("upsc_polity") -> com.example.data.upsc.UpscHistoryPolityPyqData.upscPolity50Test
            key.contains("upsc_geography") -> com.example.data.upsc.UpscGeoEcoEnvPyqData.upscGeography50Test
            key.contains("upsc_economics") -> com.example.data.upsc.UpscGeoEcoEnvPyqData.upscEconomics50Test
            key.contains("upsc_environment") -> com.example.data.upsc.UpscGeoEcoEnvPyqData.upscEnvironment50Test
            key.contains("upsc_scitech") || key.contains("upsc_science") -> com.example.data.upsc.UpscSciTechIrCaPyqData.upscScienceTech50Test
            key.contains("upsc_ir") || key.contains("upsc_ca") -> com.example.data.upsc.UpscSciTechIrCaPyqData.upscIrCurrentAffairs50Test
            key.contains("uppcs_history") -> com.example.data.uppcs.UppcsHistoryPolityPyqData.uppcsHistory50Test
            key.contains("uppcs_polity") -> com.example.data.uppcs.UppcsHistoryPolityPyqData.uppcsPolity50Test
            key.contains("uppcs_geography") -> com.example.data.uppcs.UppcsGeoEnvSciPyqData.uppcsGeography50Test
            key.contains("uppcs_environment") -> com.example.data.uppcs.UppcsGeoEnvSciPyqData.uppcsEnvironment50Test
            key.contains("uppcs_science") -> com.example.data.uppcs.UppcsGeoEnvSciPyqData.uppcsScienceTech50Test
            key.contains("uppcs_up_ca") -> com.example.data.uppcs.UppcsUpCaEcoPyqData.uppcsUpCurrentAffairs50Test
            key.contains("uppcs_economics") -> com.example.data.uppcs.UppcsUpCaEcoPyqData.uppcsEconomics50Test
            key.contains("ukpsc") || key.contains("uttarakhand") ->
                com.example.data.ukpsc.UkpscSpecial100PyqData.ukpscUttarakhandSpecial100Test
            key.contains("state") || key.contains("pcs") || key.contains("psc") || key.contains("uppcs") -> com.example.data.uppcs.UppcsHistoryPolityPyqData.uppcsHistory50Test
            key.contains("upsc") || key.contains("ias") || key.contains("capf") || key.contains("nda") -> com.example.data.upsc.UpscHistoryPolityPyqData.upscHistory50Test
            key.contains("bank") || key.contains("ibps") || key.contains("sbi") || key.contains("rbi") -> bankingPyqTest
            key.contains("rail") || key.contains("rrb") || key.contains("ntpc") || key.contains("pet") || key.contains("police") -> railwayUpssscPyqTest
            key.contains("neet") || key.contains("jee") || key.contains("ugc") || key.contains("net") || key.contains("teach") || key.contains("med") || key.contains("eng") -> neetJeeNetPyqTest
            else -> com.example.data.upsc.UpscHistoryPolityPyqData.upscHistory50Test
        }
    }
}


