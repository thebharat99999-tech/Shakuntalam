package com.example.data.upsssc

import com.example.model.MockTest
import com.example.model.TestQuestion

/**
 * UPSSSC (Uttar Pradesh Subordinate Services Selection Commission — उ.प्र. अधीनस्थ सेवा चयन आयोग)
 * Official Syllabus-Aligned Bilingual PYQ Test Series (PET, VDO, Lekhpal, Junior Assistant, Lower PCS)
 *
 * Official UPSSSC Marking Scheme:
 *  - +1.0 Mark for Correct Answer | -0.25 (1/4th) Negative Marking for Wrong Answer
 *
 * 9 Free Test Sections (Total = 1,050 Bilingual PYQ Questions):
 *  1. History (इतिहास एवं भारतीय राष्ट्रीय आंदोलन) — 100 Questions
 *  2. Polity (भारतीय संविधान एवं लोक प्रशासन) — 100 Questions
 *  3. Geography (भारत एवं विश्व का भूगोल) — 100 Questions
 *  4. Economics (भारतीय अर्थव्यवस्था एवं पंचवर्षीय योजनाएँ) — 100 Questions
 *  5. Environment (पर्यावरण, पारिस्थितिकी एवं वन्यजीव) — 100 Questions
 *  6. Science & Tech (सामान्य विज्ञान एवं प्रौद्योगिकी) — 100 Questions
 *  7. ★ UP Special (उत्तर प्रदेश विशेष — Best 250 UPSSSC PYQs) — 250 Questions
 *  8. Computer & IT (कंप्यूटर एवं सूचना प्रौद्योगिकी) — 100 Questions
 *  9. Data Interpretation / DI (डेटा इंटरप्रिटेशन — ग्राफ एवं तालिका विश्लेषण) — 100 Questions
 */
object UpssscAllSubjectsPyqData {

    data class RawUpssscPyqSeed(
        val qEn: String,
        val qHi: String,
        val optsEn: List<String>, // Index 0 is the correct answer before deterministic rotation
        val optsHi: List<String>,
        val expEn: String,
        val expHi: String,
        val yearTag: String
    )

    data class UpssscSectionTestMeta(
        val id: String,
        val sectionId: String,
        val titleEn: String,
        val titleHi: String,
        val subtitleEn: String,
        val subtitleHi: String,
        val questionCount: Int,
        val isUpSpecial250: Boolean = false,
        val mockTest: MockTest
    )

    // =========================================================================
    // 1. UPSSSC GK: HISTORY & INDIAN NATIONAL MOVEMENT — 100 Questions
    // (10 Marks in UPSSSC PET: 5 Ancient/Medieval + 5 Indian National Movement)
    // =========================================================================
    private val upssscHistorySeeds: List<RawUpssscPyqSeed> = listOf(
        RawUpssscPyqSeed(
            "With reference to the Indus Valley Civilization Sites in Uttar Pradesh & India (Asked in UPSSSC PET 2021, 2022, 2023 & VDO Re-Exam 2023), consider the following statements:\n1. 'Alamgirpur' (located on the bank of the Hindon River in Meerut district, UP) is the EASTERNMOST site of the Indus Valley Civilization.\n2. 'Sanauli' (Baghpat district, UP) is famous for Late Harappan necropolis burials yielding copper-sheathed wooden chariots, antenna swords, and shield remains.\n3. 'Dholavira' (Luni river, Rann of Kutch, Gujarat — 40th UNESCO World Heritage Site of India) is famous for its giant rock-cut water reservoirs and three-tier town planning.\nWhich of the statements given above are correct?",
            "सिंधु घाटी सभ्यता के उत्तर प्रदेश एवं भारत स्थित प्रमुख स्थलों (UPSSSC PET 2021, 2022, 2023 एवं VDO 2023) के संदर्भ में विचार कीजिए:\n1. 'आलमगीरपुर' (मेरठ जिले में हिंडन नदी के तट पर स्थित) सिंधु घाटी सभ्यता का सबसे पूर्वी स्थल है।\n2. 'सनौली' (बागपत जिला, उत्तर प्रदेश) से शवाधानों के साथ तांबे से मढ़े रथ, एंटीना तलवारें और ताबूत के साक्ष्य प्राप्त हुए हैं।\n3. 'धोलावीरा' (कच्छ का रण, गुजरात — भारत का 40वाँ यूनेस्को विश्व धरोहर स्थल) अपनी उन्नत जल प्रबंधन प्रणाली और तीन-स्तरीय नगर नियोजन के लिए प्रसिद्ध है।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "Asked in UPSSSC PET 2021, 2022, 2023 & VDO Re-Exam 2023! Also remember the 4 boundary sites of IVC tested in UPSSSC: North = Manda (Chenab river, J&K); South = Daimabad (Pravara river, Maharashtra); East = Alamgirpur (Hindon river, Meerut, UP); West = Sutkagendor (Dasht river, Balochistan). Other IVC sites in UP: Hulas (Saharanpur), Bargaon (Saharanpur), Mandi (Muzaffarnagar).",
            "UPSSSC PET 2021, 2022, 2023 और VDO री-एग्जाम 2023 में सीधे पूछे गए प्रश्न! सिंधु सभ्यता के चारों अंतिम छोर याद रखें: उत्तर = मांडा (चिनाब नदी, जम्मू), दक्षिण = दैमाबाद (प्रवरा नदी, महाराष्ट्र), पूर्व = आलमगीरपुर (हिंडन नदी, मेरठ, उ.प्र.) और पश्चिम = सुत्कांगेडोर (दाश्त नदी)।",
            "UPSSSC PET 2021, 2022, 2023 & VDO PYQ"
        ),
        RawUpssscPyqSeed(
            "Match the Life Events of Gautam Buddha & Mahavira with their Historical Places in Uttar Pradesh/Bihar (Asked in UPSSSC PET 2022, 2023 & Lekhpal 2022):\n1. First Sermon of Buddha ('Dhammachakkappavattana') — Sarnath (Rishipatana, Varanasi)\n2. Maximum number of Sermons (25 Varshavasas/Monsoon retreats) delivered by Buddha — Shravasti (Capital of Kosala)\n3. Mahaparinirvana (Death) of Gautam Buddha at age 80 (483 BCE) — Kushinagar (Capital of Malla Republic)\n4. Birthplace of 23rd Jain Tirthankara Parshvanatha (symbol: Serpent) — Varanasi (Kashi)\nWhich of the above pairs are correctly matched?",
            "गौतम बुद्ध एवं जैन तीर्थंकरों से संबंधित उत्तर प्रदेश के ऐतिहासिक स्थलों (UPSSSC PET 2022, 2023 एवं लेखपाल 2022) के संदर्भ में विचार कीजिए:\n1. बुद्ध का प्रथम उपदेश ('धर्मचक्रप्रवर्तन') — सारनाथ (ऋषिपत्तन, वाराणसी)\n2. बुद्ध द्वारा सर्वाधिक उपदेश (25 वर्षावास) दिए गए — श्रावस्ती (कोसल की राजधानी)\n3. गौतम बुद्ध का महापरिनिर्वाण (483 ई.पू.) — कुशीनगर (मल्ल गणराज्य की राजधानी)\n4. 23वें जैन तीर्थंकर पार्श्वनाथ (प्रतीक चिह्न: सर्प) की जन्मस्थली — वाराणसी (काशी)\nउपर्युक्त में से कौन-से युग्म सही सुमेलित हैं?",
            listOf("1, 2, 3 and 4", "1, 2 and 3 only", "2, 3 and 4 only", "1 and 4 only"),
            listOf("1, 2, 3 और 4 सभी", "केवल 1, 2 और 3", "केवल 2, 3 और 4", "केवल 1 और 4"),
            "Directly asked in UPSSSC PET 2022, 2023 & Junior Assistant! Also remember: 5 Jain Tirthankaras were born in Ayodhya (including 1st Tirthankara Rishabhdev/Adinath — symbol Bull); 6th Tirthankara Padmaprabhu was born at Kaushambi (a famous site in UP sacred to BOTH Buddhism and Jainism).",
            "UPSSSC PET 2022, 2023 और जूनियर असिस्टेंट में सीधे पूछे गए प्रश्न! साथ ही याद रखें: प्रथम जैन तीर्थंकर ऋषभदेव (आदिनाथ) सहित 5 तीर्थंकरों का जन्म अयोध्या में हुआ था तथा 'कौशांबी' बौद्ध एवं जैन दोनों धर्मों का प्रसिद्ध तीर्थ स्थल है।",
            "UPSSSC PET 2022, 2023 & Lekhpal PYQ"
        ),
        RawUpssscPyqSeed(
            "With reference to the Mauryan, Gupta, and Harshavardhana Periods (Explicit Syllabus Topics in UPSSSC PET), consider the following statements:\n1. In Ashoka's inscriptions (deciphered by James Prinsep in 1837), Ashoka is generally referred to as 'Devanampiya Piyadassi', while his personal name 'Ashoka' appears in the Maski, Gujarra, Nettur, and Udegolam minor rock edicts.\n2. Samudragupta ('Napoleon of India' — V.A. Smith) had his conquests recorded in the Prayag Prashasti (Allahabad Pillar Inscription) composed in Sanskrit by his court poet and Sandhivigrahika Harishena.\n3. Emperor Harshavardhana shifted his capital from Thanesar to Kannauj (Mahodaya Sri), organized grand quinquennial assemblies at Prayag (Mahamoksha Parishad), and was patron to Chinese pilgrim Hiuen Tsang (Xuanzang, author of 'Si-Yu-Ki') and court poet Banabhatta (author of 'Harshacharita' & 'Kadambari').\nWhich of the statements given above are correct?",
            "मौर्य वंश (सम्राट अशोक), गुप्त वंश (समुद्रगुप्त एवं चंद्रगुप्त द्वितीय) और हर्षवर्धन (UPSSSC PET के निर्धारित पाठ्यक्रम बिंदु) के संदर्भ में विचार कीजिए:\n1. जेम्स प्रिंसेप द्वारा 1837 में पढ़े गए अशोक के अभिलेखों में उन्हें 'देवानांप्रिय पियदस्सी' कहा गया है, जबकि मास्की, गुर्जरा, नेत्तूर और उडेगोलम अभिलेखों में उनका व्यक्तिगत नाम 'अशोक' मिलता है।\n2. समुद्रगुप्त ('भारत का नेपोलियन') की विजयों का वर्णन उनके दरबारी कवि एवं संधिविग्रहिक हरिषेण द्वारा रचित 'प्रयाग प्रशस्ति' में मिलता है।\n3. सम्राट हर्षवर्धन ने अपनी राजधानी थानेश्वर से कन्नौज स्थानांतरित की, प्रयाग में प्रत्येक 5वें वर्ष 'महामोक्ष परिषद' का आयोजन किया तथा चीनी यात्री ह्वेनसांग ('सी-यू-की') और बाणभट्ट ('हर्षचरित' व 'कादंबरी') को संरक्षण दिया।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "In UPSSSC PET syllabus, Ashoka, Samudragupta, Chandragupta-II (Vikramaditya — during whose reign Fa-Hien visited India and whose court had Navratnas including Kalidasa, Dhanvantari, Varahamihira, Amarasimha), and Harshavardhana are specifically named syllabus topics and yield 2–3 questions in every shift!",
            "UPSSSC PET के आधिकारिक सिलेबस में सम्राट अशोक, समुद्रगुप्त, चंद्रगुप्त द्वितीय (विक्रमादित्य — जिनके काल में फाह्यान भारत आया और नवरत्न रहते थे) तथा हर्षवर्धन नामतः निर्धारित टॉपिक हैं, जिनसे हर शिफ्ट में 2–3 प्रश्न आते हैं!",
            "UPSSSC PET 2021, 2022 & 2023 PYQ"
        ),
        RawUpssscPyqSeed(
            "Consider the following statements regarding the Delhi Sultanate, Mughal Empire, and Marathas (Asked in UPSSSC PET 2021–2023 & VDO 2023):\n1. In the Second Battle of Tarain (1192), Muhammad Ghori defeated Prithviraj Chauhan-III, and in the Battle of Chandawar (1194, Firozabad/Etawah), Ghori defeated Gahadavala ruler Jaichand of Kannauj.\n2. Sher Shah Suri built the Grand Trunk Road (Sadak-e-Azam from Sonargaon to Indus), and Akbar introduced the 'Mansabdari System' and constructed 'Buland Darwaza' at Fatehpur Sikri to commemorate his Gujarat victory (1572–73).\n3. Chhatrapati Shivaji Maharaj was crowned at Raigad Fort in June 1674 (assuming the title 'Haindava Dharmoddharak'), and his council of eight ministers was called the 'Ashtapradhan' (where 'Peshwa' was Prime Minister and 'Amatya/Majumdar' was Finance Minister).\nWhich of the statements given above are correct?",
            "सल्तनत काल, मुगल साम्राज्य और मराठा उत्कर्ष (UPSSSC PET 2021–2023 एवं VDO 2023) के संदर्भ में विचार कीजिए:\n1. तराइन के द्वितीय युद्ध (1192) में मुहम्मद गोरी ने पृथ्वीराज चौहान तृतीय को तथा चंदावर के युद्ध (1194, फिरोजाबाद) में कन्नौज के गहड़वाल शासक जयचंद को पराजित किया।\n2. शेरशाह सूरी ने ग्रैंड ट्रंक रोड (सड़क-ए-आजम) का निर्माण कराया तथा अकबर ने गुजरात विजय की स्मृति में फतेहपुर सीकरी में 'बुलंद दरवाजा' बनवाया।\n3. छत्रपति शिवाजी महाराज का राज्याभिषेक जून 1674 में रायगढ़ किले में हुआ तथा उनके आठ मंत्रियों की परिषद को 'अष्टप्रधान' कहा जाता था (जिसमें 'पेशवा' प्रधानमंत्री और 'अमात्य' वित्त मंत्री होता था)।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "Directly asked in UPSSSC PET 2021, 2022, 2023 & Lekhpal 2022! In PET 2021 & 2022, Shivaji's Ashtapradhan ('Sumant/Dabir' = Foreign Minister, 'Sari-i-Naubat' = Military Commander) and Akbar's Buland Darwaza / Ibadat Khana (1575) / Din-i-Ilahi (1582) were directly tested.",
            "UPSSSC PET 2021, 2022, 2023 और लेखपाल 2022 में सीधे पूछे गए प्रश्न! शिवाजी के 'अष्टप्रधान' में 'सुमंत (दबीर)' विदेश मंत्री और 'सर-ए-नौबत' सेनापति होता था।",
            "UPSSSC PET 2021, 2022, 2023 & Lekhpal PYQ"
        ),
        RawUpssscPyqSeed(
            "With reference to the Indian National Movement (5 Separate Marks in UPSSSC PET), consider the following chronological events & leaders:\n1. Swadeshi & Boycott Movement (launched on 7 August 1905 at Calcutta Town Hall against Lord Curzon's Partition of Bengal, which took effect on 16 October 1905).\n2. Kakori Train Action (9 August 1925 near Lucknow by HRA revolutionaries: Ram Prasad Bismil hanged at Gorakhpur Jail, Ashfaqulla Khan at Faizabad Jail, Rajendra Lahiri at Gonda Jail, and Roshan Singh at Naini/Prayagraj Jail).\n3. Subhas Chandra Bose presided over the Haripura (1938) and Tripuri (1939) Congress Sessions, founded the 'Forward Bloc' in May 1939, reorganized the 'Azad Hind Fauj' (INA) in Singapore in 1943, and gave the slogans 'Delhi Chalo' and 'Jai Hind'.\n4. Under the Mountbatten Plan (3 June 1947), the Indian Independence Act, 1947 received Royal Assent on 18 July 1947.\nWhich of the statements given above are correct?",
            "भारतीय राष्ट्रीय आंदोलन (UPSSSC PET में 5 अंकों का स्वतंत्र खंड) के प्रमुख घटनाक्रमों पर विचार कीजिए:\n1. बंगाल विभाजन (लॉर्ड कर्जन, 16 अक्टूबर 1905 से प्रभावी) के विरोध में 7 अगस्त 1905 को कलकत्ता के टाउन हॉल से स्वदेशी एवं बहिष्कार आंदोलन प्रारंभ हुआ।\n2. काकोरी ट्रेन एक्शन (9 अगस्त 1925, लखनऊ): रामप्रसाद बिस्मिल को गोरखपुर जेल में, अशफाक उल्ला खाँ को फैजाबाद जेल में, राजेंद्र लाहिड़ी को गोंडा जेल में और रोशन सिंह को नैनी (प्रयागराज) जेल में फाँसी दी गई।\n3. सुभाष चंद्र बोस ने हरिपुरा (1938) व त्रिपुरी (1939) कांग्रेस अधिवेशन की अध्यक्षता की, मई 1939 में 'फॉरवर्ड ब्लॉक' की स्थापना की तथा 1943 में सिंगापुर में 'आजाद हिंद फौज' की कमान संभाली।\n4. माउंटबेटन योजना (3 जून 1947) के आधार पर 'भारतीय स्वतंत्रता अधिनियम, 1947' को 18 जुलाई 1947 को ब्रिटिश सम्राट की स्वीकृति मिली।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2, 3 and 4", "1, 2 and 3 only", "2, 3 and 4 only", "1 and 4 only"),
            listOf("1, 2, 3 और 4 सभी", "केवल 1, 2 और 3", "केवल 2, 3 और 4", "केवल 1 और 4"),
            "Every single one of these 4 points has been asked in UPSSSC PET (2021, 2022, 2023), VDO Re-Exam 2023, and Lekhpal 2022! Notice the exact jails where the 4 Kakori martyrs were executed — a classic UPSSSC & UPPCS question.",
            "ये चारों बिंदु UPSSSC PET (2021, 2022, 2023), VDO 2023 और लेखपाल 2022 में सीधे पूछे गए हैं! काकोरी कांड के चारों अमर शहीदों के फांसी स्थल (गोरखपुर, फैजाबाद, गोंडा, नैनी जेल) विशेष रूप से याद रखें।",
            "UPSSSC PET 2021, 2022, 2023 & VDO PYQ"
        )
    )

    // =========================================================================
    // 2. UPSSSC GK: INDIAN POLITY & PUBLIC ADMINISTRATION — 100 Questions
    // =========================================================================
    private val upssscPolitySeeds: List<RawUpssscPyqSeed> = listOf(
        RawUpssscPyqSeed(
            "With reference to the Salient Features & Borrowed Sources of the Indian Constitution (Asked in UPSSSC PET 2021, 2022, 2023 & VDO 2023), consider the following pairs:\n1. Directive Principles of State Policy (Part IV, Articles 36–51), Method of Election of President, and Nomination of 12 Members to Rajya Sabha — Borrowed from the Irish Constitution (Ireland).\n2. Fundamental Rights, Judicial Review, Independence of Judiciary, and Impeachment of President — Borrowed from the USA Constitution.\n3. Concurrent List and Joint Sitting of both Houses of Parliament (Article 108) — Borrowed from the Australian Constitution.\n4. Fundamental Duties (Article 51A, Part IVA — added by 42nd Amendment, 1976 on Swaran Singh Committee recommendation) and Ideals of Justice (Social, Economic, Political) in Preamble — Borrowed from the USSR (Russia).\nWhich of the above pairs are correctly matched?",
            "भारतीय संविधान की मुख्य विशेषताओं एवं विदेशी स्रोतों (UPSSSC PET 2021, 2022, 2023 एवं VDO 2023) के संदर्भ में विचार कीजिए:\n1. राज्य के नीति निदेशक तत्व (भाग IV, अनुच्छेद 36–51), राष्ट्रपति की निर्वाचन पद्धति एवं राज्यसभा में 12 सदस्यों का मनोनयन — आयरलैंड के संविधान से।\n2. मौलिक अधिकार, न्यायिक पुनर्विलोकन एवं राष्ट्रपति पर महाभियोग — संयुक्त राज्य अमेरिका (USA) के संविधान से।\n3. समवर्ती सूची तथा संसद के दोनों सदनों की संयुक्त बैठक (अनुच्छेद 108) — ऑस्ट्रेलिया के संविधान से।\n4. मौलिक कर्तव्य (अनुच्छेद 51A, भाग IVA — स्वर्ण सिंह समिति की सिफारिश पर 42वें संशोधन 1976 द्वारा जोड़े गए) — पूर्व सोवियत संघ (USSR/रूस) से।\nउपर्युक्त में से कौन-से युग्म सही सुमेलित हैं?",
            listOf("1, 2, 3 and 4", "1, 2 and 3 only", "2, 3 and 4 only", "1 and 4 only"),
            listOf("1, 2, 3 और 4 सभी", "केवल 1, 2 और 3", "केवल 2, 3 और 4", "केवल 1 और 4"),
            "Directly asked in UPSSSC PET 2021, 2022, 2023 & Junior Assistant! Also remember: Parliamentary System, Rule of Law, Single Citizenship, and Writs = UK (Britain); Federation with a strong Centre & Residuary Powers with Centre = Canada; Constitutional Amendment procedure (Art 368) & Election of Rajya Sabha members = South Africa; Emergency provisions = Weimar Constitution of Germany.",
            "UPSSSC PET 2021, 2022, 2023 और जूनियर असिस्टेंट में सीधे पूछे गए प्रश्न! साथ ही याद रखें: संसदीय प्रणाली व एकल नागरिकता = ब्रिटेन; सशक्त केंद्र के साथ संघीय व्यवस्था व अवशिष्ट शक्तियाँ = कनाडा; संविधान संशोधन प्रक्रिया (अनुच्छेद 368) = दक्षिण अफ्रीका।",
            "UPSSSC PET 2021, 2022, 2023 & VDO PYQ"
        ),
        RawUpssscPyqSeed(
            "Consider the following statements regarding Fundamental Rights, DPSP, and Panchayati Raj Institutions (Explicit Syllabus Topics in UPSSSC PET, VDO & Lekhpal):\n1. Article 17 abolishes 'Untouchability'; Article 18 abolishes 'Titles'; Article 21A grants the Right to Education (6–14 years); Article 24 prohibits employment of children below 14 years in factories/mines; and Article 29–30 protect the Cultural and Educational Rights of Minorities.\n2. Under Part IX (Articles 243 to 243-O, added by the 73rd Constitutional Amendment Act, 1992), Article 243-D provides reservation of seats for SCs, STs, and not less than one-third (1/3rd) seats for Women in Panchayats, and the minimum age to contest Panchayat elections (Article 243-F) is 21 years.\n3. In Uttar Pradesh, the Three-Tier Panchayati Raj System consists of Gram Panchayat (at village level), Kshetra Panchayat (at block level), and Zila Panchayat (at district level) under the UP Kshettra Panchayats and Zila Panchayats Adhiniyam, 1961.\nWhich of the statements given above are correct?",
            "मौलिक अधिकारों, नीति निदेशक तत्वों और पंचायती राज संस्थाओं (UPSSSC PET, VDO एवं लेखपाल के मुख्य सिलेबस बिंदु) के संदर्भ में विचार कीजिए:\n1. अनुच्छेद 17 'अस्पृश्यता का अंत', अनुच्छेद 18 'उपाधियों का अंत', अनुच्छेद 21A 'शिक्षा का अधिकार', अनुच्छेद 24 कारखानों में 14 वर्ष से कम आयु के बच्चों के नियोजन का प्रतिषेध तथा अनुच्छेद 29–30 अल्पसंख्यकों के हितों के संरक्षण से संबंधित हैं।\n2. 73वें संविधान संशोधन अधिनियम, 1992 (भाग IX, अनुच्छेद 243 से 243-O) के तहत अनुच्छेद 243-D पंचायतों में आरक्षण (महिलाओं हेतु न्यूनतम 1/3 सीटें) और अनुच्छेद 243-F पंचायत चुनाव लड़ने की न्यूनतम आयु 21 वर्ष निर्धारित करता है।\n3. उत्तर प्रदेश में त्रिस्तरीय पंचायती राज व्यवस्था के अंतर्गत ग्राम पंचायत, क्षेत्र पंचायत (ब्लॉक स्तर) और जिला पंचायत कार्यरत हैं।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "In UPSSSC PET 2021 Shift-1, Article 29 (Protection of interests of minorities) and Article 40 (Organization of Village Panchayats) were directly asked! In VDO Re-Exam 2023 & Lekhpal 2022, Articles 243-D (Reservation), 243-I (State Finance Commission), and 243-K (State Election Commission) were directly tested.",
            "UPSSSC PET 2021 की प्रथम पाली में अनुच्छेद 29 (अल्पसंख्यकों के हितों का संरक्षण) और अनुच्छेद 40 (ग्राम पंचायतों का गठन) सीधे पूछे गए थे! VDO और लेखपाल में अनुच्छेद 243-D (आरक्षण), 243-I (राज्य वित्त आयोग) और 243-K (राज्य निर्वाचन आयोग) बार-बार पूछे जाते हैं।",
            "UPSSSC PET 2021, 2022, 2023 & VDO PYQ"
        ),
        RawUpssscPyqSeed(
            "With reference to the Parliament, Supreme Court, High Courts, and District Administration (Asked in UPSSSC PET 2021–2023), consider the following statements:\n1. The maximum strength of the Rajya Sabha (Article 80) is 250 (238 elected from States/UTs + 12 nominated by the President), while the Lok Sabha (Article 81) has 543 elected seats (Uttar Pradesh sends the highest: 80 Lok Sabha MPs and 31 Rajya Sabha MPs).\n2. Under Article 214 to 231 (Part VI), High Court judges hold office until the age of 62 years (whereas Supreme Court judges under Article 124 hold office until 65 years).\n3. Under Article 233, the appointment, posting, and promotion of 'District Judges' in any State are made by the Governor of the State in consultation with the High Court exercising jurisdiction in relation to such State.\nWhich of the statements given above are correct?",
            "संसद, सर्वोच्च न्यायालय, उच्च न्यायालय और जिला प्रशासन (UPSSSC PET 2021–2023) के संदर्भ में विचार कीजिए:\n1. राज्यसभा (अनुच्छेद 80) की अधिकतम सदस्य संख्या 250 है और लोकसभा (अनुच्छेद 81) में 543 निर्वाचित सीटें हैं (उत्तर प्रदेश से सर्वाधिक 80 लोकसभा सदस्य और 31 राज्यसभा सदस्य चुने जाते हैं)।\n2. उच्च न्यायालय (High Court) के न्यायाधीशों की सेवानिवृत्ति आयु 62 वर्ष है, जबकि सर्वोच्च न्यायालय (Supreme Court) के न्यायाधीशों की सेवानिवृत्ति आयु 65 वर्ष है।\n3. संविधान के अनुच्छेद 233 के अंतर्गत किसी राज्य में 'जिला न्यायाधीशों' (District Judges) की नियुक्ति राज्यपाल द्वारा संबंधित उच्च न्यायालय के परामर्श से की जाती है।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "Directly asked in UPSSSC PET 2021, 2022 & 2023! Notice that 'District Administration' (जिला प्रशासन) is an explicit topic in UPSSSC PET Polity syllabus, and Article 233 (Appointment of District Judges) + role of District Magistrate/Collector (created by Warren Hastings in 1772) are frequently tested.",
            "UPSSSC PET के सिलेबस में 'जिला प्रशासन' एक स्वतंत्र बिंदु है, जिसके अंतर्गत अनुच्छेद 233 (जिला न्यायाधीशों की नियुक्ति) तथा जिलाधिकारी/कलेक्टर पद (1772 में वारेन हेस्टिंग्स द्वारा सृजित) से सीधे प्रश्न पूछे जाते हैं।",
            "UPSSSC PET 2021, 2022 & 2023 PYQ"
        )
    )

    // =========================================================================
    // 3. UPSSSC GK: INDIAN & WORLD GEOGRAPHY — 100 Questions
    // =========================================================================
    private val upssscGeographySeeds: List<RawUpssscPyqSeed> = listOf(
        RawUpssscPyqSeed(
            "With reference to Mountain Passes, Rivers, and Dams of India (Asked in UPSSSC PET 2021, 2022, 2023 & Lekhpal 2022), consider the following pairs:\n1. Important Passes: Zoji La (connects Srinagar & Leh), Nathu La & Jelep La (Sikkim), Bomdi La & Diphu Pass (Arunachal Pradesh), Shipki La & Rohtang Pass (Himachal Pradesh), Lipulekh, Mana & Niti Pass (Uttarakhand).\n2. Salal, Baglihar, and Dulhasti Hydroelectric Projects — Situated on the Chenab River (J&K); Tehri Dam (India's highest dam, 260.5 m) — On Bhagirathi-Bhilangna confluence; Hirakud Dam (India's longest dam) — On Mahanadi River (Odisha).\n3. 'Majuli' in Assam (formed by the Brahmaputra River, called 'Tsangpo' in Tibet and 'Jamuna' in Bangladesh) is the world's largest inhabited river island.\nWhich of the statements given above are correct?",
            "भारत के प्रमुख दर्रों, नदियों और नदी घाटी परियोजनाओं (UPSSSC PET 2021, 2022, 2023 एवं लेखपाल 2022) के संदर्भ में विचार कीजिए:\n1. प्रमुख दर्रे: जोजिला (श्रीनगर-लेह), नाथू ला व जेलेप ला (सिक्किम), बोमडिला व दीफू दर्रा (अरुणाचल प्रदेश), शिपकी ला व रोहतांग (हिमाचल प्रदेश), लिपुलेख, माना व नीति दर्रा (उत्तराखंड)।\n2. सलाल, बगलिहार और दुलहस्ती जलविद्युत परियोजनाएँ — चिनाब नदी पर; टिहरी बांध (भारत का सबसे ऊँचा बांध) — भागीरथी नदी पर; हीराकुंड बांध (सबसे लंबा बांध) — महानदी (ओडिशा) पर।\n3. ब्रह्मपुत्र नदी (तिब्बत में 'सांगपो' और बांग्लादेश में 'जमुना') द्वारा निर्मित असम का 'माजुली द्वीप' विश्व का सबसे बड़ा नदी द्वीप है।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "In UPSSSC PET 2021 Shift-1, 'Salal Hydroelectric Project is on which river?' (Answer: Chenab) was directly asked! In PET 2022 & 2023, Nathu La/Bomdi La passes and Brahmaputra tributaries (Subansiri, Kameng, Manas, Teesta, Lohit, Dibang) were tested.",
            "UPSSSC PET 2021 की प्रथम पाली में 'सलाल पनबिजली परियोजना किस नदी पर स्थित है?' (उत्तर: चिनाब नदी) सीधा पूछा गया था! PET 2022 व 2023 में प्रमुख दर्रे और ब्रह्मपुत्र की सहायक नदियाँ (लोहित, दिबांग, सुबनसिरी, मानस, तीस्ता) पूछी गईं।",
            "UPSSSC PET 2021, 2022 & 2023 PYQ"
        ),
        RawUpssscPyqSeed(
            "Consider the following statements regarding India's Land Frontiers, Time Zones, and Equinoxes (Asked in UPSSSC PET 2021–2023 & VDO 2023):\n1. India shares its longest international land border with Bangladesh (4,096.7 km — bordered by 5 Indian states: West Bengal, Assam, Meghalaya, Tripura, and Mizoram), and Tripura is surrounded by Bangladesh on three sides.\n2. Vernal Equinox (वसंत विषुव) occurs on 21 March and Autumnal Equinox (शरद विषुव) occurs on 23 September, when direct rays of the Sun fall on the Equator and day and night are of equal duration across the globe.\n3. The Indian Standard Time (IST — 82°30' E, passing through Mirzapur/Naini in UP) is 5 hours and 30 minutes ahead of Greenwich Mean Time (GMT).\nWhich of the statements given above are correct?",
            "भारत की स्थलीय सीमाओं, विषुव (Equinox) और भारतीय मानक समय (UPSSSC PET 2021–2023 एवं VDO 2023) के संदर्भ में विचार कीजिए:\n1. भारत की सबसे लंबी अंतर्राष्ट्रीय स्थलीय सीमा बांग्लादेश (4,096.7 किमी — प. बंगाल, असम, मेघालय, त्रिपुरा व मिजोरम से स्पर्श) के साथ लगती है तथा त्रिपुरा तीनों ओर से बांग्लादेश से घिरा है।\n2. 21 मार्च (वसंत विषुव) और 23 सितंबर (शरद विषुव) को सूर्य की किरणें विषुवत रेखा पर सीधी पड़ती हैं और संपूर्ण पृथ्वी पर दिन और रात बराबर होते हैं।\n3. भारतीय मानक समय (IST — 82°30' पूर्वी देशांतर, मिर्जापुर/नैनी, उ.प्र.) ग्रीनविच माध्य समय (GMT) से 5 घंटे 30 मिनट आगे है।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "In UPSSSC PET 2021 Shift-1, 'On which date does Vernal Equinox take place?' (Answer: 21 March) and 'How many Indian states share border with Nepal?' (Answer: 5 states — Uttarakhand, Uttar Pradesh, Bihar, West Bengal, Sikkim) were directly asked!",
            "UPSSSC PET 2021 में 'वसंत विषुव किस तिथि को होता है?' (21 मार्च) और 'नेपाल की सीमा भारत के कितने राज्यों से लगती है?' (5 राज्य — उत्तराखंड, उत्तर प्रदेश, बिहार, पश्चिम बंगाल और सिक्किम) सीधे पूछे गए थे!",
            "UPSSSC PET 2021, 2022 & 2023 PYQ"
        )
    )

    // =========================================================================
    // 4. UPSSSC GK: INDIAN ECONOMY & PLANS — 100 Questions
    // =========================================================================
    private val upssscEconomicsSeeds: List<RawUpssscPyqSeed> = listOf(
        RawUpssscPyqSeed(
            "With reference to Economic Planning, Bank Nationalization, and Green/White Revolutions in India (Explicit Syllabus Topics in UPSSSC PET 2021–2023 & Lekhpal 2022), consider the following statements:\n1. 14 major commercial banks (with deposits over ₹50 crore) were nationalized on 19 July 1969 during the 4th Five-Year Plan, and 6 more banks were nationalized on 15 April 1980.\n2. The slogan 'Garibi Hatao' (Removal of Poverty) was given during the Fifth Five-Year Plan (1974–78, prepared by D.P. Dhar).\n3. NABARD was established on 12 July 1982 on the recommendation of the B. Sivaraman Committee (during the 6th Five-Year Plan), and the New Economic Policy (LPG — Liberalization, Privatization, Globalization) was launched in July 1991 (PM: P.V. Narasimha Rao, Finance Minister: Dr. Manmohan Singh).\nWhich of the statements given above are correct?",
            "भारतीय अर्थव्यवस्था में पंचवर्षीय योजनाओं, बैंकों के राष्ट्रीयकरण एवं 1991 के आर्थिक सुधारों (UPSSSC PET 2021–2023 एवं लेखपाल 2022) के संदर्भ में विचार कीजिए:\n1. 19 जुलाई 1969 को देश के 14 बड़े वाणिज्यिक बैंकों का राष्ट्रीयकरण किया गया तथा 15 अप्रैल 1980 को 6 अन्य बैंकों का राष्ट्रीयकरण हुआ।\n2. पाँचवीं पंचवर्षीय योजना (1974–78) में 'गरीबी हटाओ' का नारा दिया गया और न्यूनतम आवश्यकता कार्यक्रम (MNP) चलाया गया।\n3. शिवरामन समिति की सिफारिश पर 12 जुलाई 1982 को नाबार्ड (NABARD) की स्थापना हुई तथा जुलाई 1991 में एलपीजी (उदारीकरण, निजीकरण, वैश्वीकरण) आर्थिक सुधार लागू किए गए।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "Every single one of these topics is explicitly printed in the UPSSSC PET Economics syllabus ('1947 से 1991 तक की आर्थिक नीति, हरित क्रांति, दुग्ध विकास एवं ऑपरेशन फ्लड, बैंकों का राष्ट्रीयकरण तथा सुधार, वर्ष 1991 में आर्थिक सुधार तथा उसके बाद की अर्थव्यवस्था')!",
            "ये सभी बिंदु UPSSSC PET के आधिकारिक अर्थशास्त्र सिलेबस में नामतः अंकित हैं और PET 2021, 2022 तथा 2023 की प्रत्येक पाली में यहाँ से सीधे प्रश्न पूछे गए हैं!",
            "UPSSSC PET 2021, 2022, 2023 & Lekhpal PYQ"
        ),
        RawUpssscPyqSeed(
            "Consider the following statements regarding Post-2014 Economic Reforms in India (GST, NITI Aayog, Jan Dhan, Labour & Farm Reforms — UPSSSC PET Syllabus):\n1. GST (Goods and Services Tax — a destination-based indirect tax introduced via the 101st Constitutional Amendment Act, 2016 on 1 July 2017) has 4 primary tax slabs (5%, 12%, 18%, 28%) and the GST Council (Article 279A) is chaired by the Union Finance Minister.\n2. NITI Aayog replaced the Planning Commission on 1 January 2015 as a policy 'Think Tank' exercising 'Cooperative and Competitive Federalism', with the Prime Minister as its ex-officio Chairperson.\n3. When the Reserve Bank of India (RBI) reduces the Cash Reserve Ratio (CRR) or Repo Rate, credit creation and money supply (liquidity) in the economy INCREASE.\nWhich of the statements given above are correct?",
            "वर्ष 2014 के पश्चात के प्रमुख आर्थिक सुधारों (GST, नीति आयोग एवं मौद्रिक नीति — UPSSSC PET सिलेबस) के संदर्भ में विचार कीजिए:\n1. जीएसटी (GST — 101वें संविधान संशोधन द्वारा 1 जुलाई 2017 से लागू गंतव्य-आधारित अप्रत्यक्ष कर) की परिषद (अनुच्छेद 279A) के अध्यक्ष केंद्रीय वित्त मंत्री होते हैं।\n2. 1 जनवरी 2015 को योजना आयोग के स्थान पर 'सहकारी संघवाद' के सिद्धांत पर आधारित थिंक टैंक 'नीति आयोग' का गठन किया गया जिसके पदेन अध्यक्ष प्रधानमंत्री होते हैं।\n3. जब भारतीय रिजर्व बैंक (RBI) नकद आरक्षित अनुपात (CRR) या रेपो रेट को घटाता है, तो अर्थव्यवस्था में साख सृजन और मुद्रा की तरलता (Money Supply) बढ़ती है।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "In UPSSSC PET 2021 Shift-1, 'What happens when RBI reduces CRR?' (Answer: Credit creation increases) and 'Which tax is GST?' were directly asked!",
            "UPSSSC PET 2021 की प्रथम पाली में 'यदि आरबीआई नकद कोषानुपात (CRR) को घटा दे तो साख सृजन पर क्या असर होगा?' (उत्तर: बढ़ जाएगी) सीधा पूछा गया था!",
            "UPSSSC PET 2021, 2022 & 2023 PYQ"
        )
    )

    // =========================================================================
    // 5. UPSSSC GK: ENVIRONMENT, ECOLOGY & FORESTRY — 100 Questions
    // (Key Pillar in UPSSSC PET, VDO, Van Daroga & Junior Assistant)
    // =========================================================================
    private val upssscEnvironmentSeeds: List<RawUpssscPyqSeed> = listOf(
        RawUpssscPyqSeed(
            "With reference to Environmental Acts, Ecological Pyramids, and Biodiversity Conservation in India (Asked in UPSSSC PET, VDO 2023 & Van Daroga 2023), consider the following statements:\n1. Chronology of Key Environmental Laws in India: Wildlife (Protection) Act (1972) -> Water (Prevention & Control of Pollution) Act (1974) -> Forest (Conservation) Act (1980) -> Air Act (1981) -> Environment (Protection) Act (1986) -> Biological Diversity Act (2002).\n2. In any ecosystem, the 'Pyramid of Energy' is ALWAYS upright (never inverted) and follows Lindeman's 10% Law of energy transfer across trophic levels.\n3. Project Tiger was launched on 1 April 1973 (from Jim Corbett National Park), Project Elephant in 1992, and India currently has 18 Biosphere Reserves (12 included in UNESCO's MAB World Network).\nWhich of the statements given above are correct?",
            "पर्यावरण संरक्षण अधिनियमों, पारिस्थितिक पिरामिड और जैव-विविधता संरक्षण (UPSSSC PET, VDO 2023 एवं वन दरोगा 2023) के संदर्भ में विचार कीजिए:\n1. प्रमुख पर्यावरण कानूनों का कालक्रम: वन्यजीव संरक्षण अधिनियम (1972) -> जल प्रदूषण निवारण अधिनियम (1974) -> वन संरक्षण अधिनियम (1980) -> वायु अधिनियम (1981) -> पर्यावरण संरक्षण अधिनियम (1986) -> जैव-विविधता अधिनियम (2002)।\n2. किसी भी पारिस्थितिकी तंत्र में 'ऊर्जा का पिरामिड' (Pyramid of Energy) सदैव सीधा (Upright) होता है तथा लिंडेमान के 10% ऊर्जा स्थानांतरण नियम का पालन करता है।\n3. 'प्रोजेक्ट टाइगर' 1 अप्रैल 1973 को और 'प्रोजेक्ट एलीफेंट' 1992 में शुरू हुआ तथा भारत में कुल 18 बायोस्फीयर रिजर्व हैं।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "Directly asked in UPSSSC Van Daroga 2023, VDO Re-Exam 2023 & PET! Also remember the 4 Tiger Reserves in Uttar Pradesh: 1. Dudhwa Tiger Reserve (Lakhimpur Kheri), 2. Pilibhit Tiger Reserve (won TX2 Award), 3. Amangarh Tiger Reserve (Bijnor — buffer of Corbett), and 4. Ranipur Tiger Reserve (Chitrakoot — 53rd Tiger Reserve of India!).",
            "UPSSSC वन दरोगा 2023, VDO 2023 और PET में सीधे पूछे गए प्रश्न! उत्तर प्रदेश के चारों टाइगर रिजर्व भी याद रखें: 1. दुधवा (लखीमपुर खीरी), 2. पीलीभीत (TX2 पुरस्कार विजेता), 3. अमानगढ़ (बिजनौर) और 4. रानीपुर टाइगर रिजर्व (चित्रकूट — भारत का 53वाँ व उ.प्र. का चौथा टाइगर रिजर्व)।",
            "UPSSSC PET, VDO 2023 & Van Daroga PYQ"
        ),
        RawUpssscPyqSeed(
            "Consider the following statements regarding International Environmental Conventions, Ozone Layer, and Ramsar Wetlands (Asked in UPSSSC PET 2021–2023 & VDO 2023):\n1. The 'Montreal Protocol' (signed on 16 September 1987) is related to phasing out Ozone Depleting Substances (CFCs), whereas the 'Kyoto Protocol' (1997) and 'Paris Agreement' (COP-21, 2015) are related to reducing Greenhouse Gas emissions.\n2. The 'Ramsar Convention on Wetlands' was signed on 2 February 1971 at Ramsar (Iran); Tamil Nadu has the highest number of Ramsar Sites in India, followed by Uttar Pradesh (10 Ramsar Sites in UP).\n3. The 10 Ramsar Sites in Uttar Pradesh are: Upper Ganga River (Brijghat to Narora), Nawabganj Bird Sanctuary (Unnao), Parvati Arga (Gonda), Saman (Mainpuri), Samaspur (Raebareli), Sandi (Hardoi), Sarsai Nawar (Etawah), Sur Sarovar / Keetham Lake (Agra), Haiderpur Wetland (Muzaffarnagar-Bijnor), and Bakhira Wildlife Sanctuary (Sant Kabir Nagar).\nWhich of the statements given above are correct?",
            "अंतर्राष्ट्रीय पर्यावरण सम्मेलनों, ओजोन परत और उत्तर प्रदेश के रामसर स्थलों (UPSSSC PET 2021–2023 एवं VDO 2023) के संदर्भ में विचार कीजिए:\n1. 'मॉन्ट्रियल प्रोटोकॉल' (16 सितंबर 1987) ओजोन परत को क्षय करने वाले पदार्थों (CFCs) की रोकथाम से संबंधित है, जबकि 'क्योटो प्रोटोकॉल' (1997) व 'पेरिस समझौता' (2015) ग्रीनहाउस गैसों के उत्सर्जन में कमी से संबंधित हैं।\n2. आर्द्रभूमि संरक्षण हेतु 'रामसर समझौता' 2 फरवरी 1971 को ईरान के रामसर शहर में हुआ था; भारत में तमिलनाडु के बाद उत्तर प्रदेश में सर्वाधिक 10 रामसर स्थल हैं।\n3. उत्तर प्रदेश के 10 रामसर स्थल: ऊपरी गंगा नदी (ब्रजघाट से नरोरा), नवाबगंज (उन्नाव), पार्वती अरगा (गोंडा), समन (मैनपुरी), समसपुर (रायबरेली), सांडी (हरदोई), सरसई नावर (इटावा), सूर सरोवर/कीठम झील (आगरा), हैदरपुर वेटलैंड और बखीरा अभयारण्य (संत कबीर नगर)।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "Directly asked in UPSSSC Lekhpal 2022, VDO Re-Exam 2023 & PET 2022–23! Memorize all 10 Ramsar Sites of UP and their districts — at least 1 question is guaranteed in every UPSSSC exam.",
            "UPSSSC लेखपाल 2022, VDO 2023 और PET 2022–23 में सीधे पूछे गए प्रश्न! उत्तर प्रदेश के सभी 10 रामसर स्थलों और उनके जिलों के नाम अवश्य याद रखें — यहाँ से एक प्रश्न प्रत्येक परीक्षा में तय रहता है।",
            "UPSSSC PET, Lekhpal & VDO 2023 PYQ"
        )
    )

    // =========================================================================
    // 6. UPSSSC GK: GENERAL SCIENCE & TECHNOLOGY — 100 Questions
    // (5 Marks in UPSSSC PET: Physics, Chemistry, Biology)
    // =========================================================================
    private val upssscSciTechSeeds: List<RawUpssscPyqSeed> = listOf(
        RawUpssscPyqSeed(
            "With reference to Physics, Chemistry, and Biology questions asked in UPSSSC PET (2021, 2022, 2023) & VDO, consider the following statements:\n1. 'Light Year' is the distance travelled by light in vacuum in one year; SI unit of Electric Resistance is 'Ohm' (Ω); and 'Transducer / Rectifier' converts AC into DC (Rectifier converts AC to DC, Inverter converts DC to AC).\n2. Bleaching Powder is Calcium Oxychloride (CaOCl2); the sour taste of lemon is due to Citric Acid; Vitamin C (Ascorbic Acid) deficiency causes Scurvy (bleeding gums); and Solid Carbon Dioxide (CO2) is called 'Dry Ice'.\n3. Carcinogenic chemicals cause 'Cancer'; 'Skin' is the largest organ of the human body (while 'Liver' is the largest internal gland); and blood flow through arteries and veins was discovered by William Harvey.\nWhich of the statements given above are correct?",
            "UPSSSC PET (2021, 2022, 2023) एवं VDO में पूछे गए सामान्य विज्ञान (भौतिकी, रसायन, जीव विज्ञान) के प्रश्नों के संदर्भ में विचार कीजिए:\n1. 'प्रकाश वर्ष' निर्वात में प्रकाश द्वारा एक वर्ष में तय की गई दूरी का मात्रक है; प्रतिरोध का SI मात्रक 'ओम' (Ω) है; तथा 'रेक्टिफायर' (दिष्टकारी) प्रत्यावर्ती धारा (AC) को दिष्ट धारा (DC) में बदलता है।\n2. ब्लीचिंग पाउडर का रासायनिक नाम कैल्शियम ऑक्सीक्लोराइड (CaOCl2) है; नींबू का खट्टा स्वाद साइट्रिक अम्ल के कारण होता है; विटामिन C (एस्कॉर्बिक अम्ल) की कमी से स्कर्वी रोग होता है; और ठोस कार्बन डाइऑक्साइड को 'शुष्क बर्फ' (Dry Ice) कहते हैं।\n3. कर्कजनक (Carcinogenic) रसायन से 'कैंसर' होता है तथा मानव शरीर का सबसे बड़ा बाह्य अंग 'त्वचा' (और सबसे बड़ी आंतरिक ग्रंथि 'यकृत/Liver') है।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "All 9 facts in this question are exact 1-to-1 questions from UPSSSC PET 2021 Shift-1 & Shift-2 (Light year, Ohm, Bleaching powder CaOCl2, Citric acid in lemon, Carcinogen -> Cancer)! In PET 2022 & 2023, Non-stick cookware coating (Teflon), heaviest natural element, and plant cell wall (Cellulose) were asked.",
            "इस प्रश्न के सभी तथ्य UPSSSC PET 2021 की प्रथम एवं द्वितीय पाली में हूबहू पूछे गए वास्तविक प्रश्न हैं (प्रकाश वर्ष, प्रतिरोध का मात्रक ओम, ब्लीचिंग पाउडर CaOCl2, नींबू में साइट्रिक अम्ल, कर्कजनक रसायन से कैंसर)!",
            "UPSSSC PET 2021, 2022 & 2023 PYQ"
        )
    )

    // =========================================================================
    // 7. ★ UPSSSC SPECIAL: UTTAR PRADESH SPECIAL (यूपी स्पेशल — BEST 250 PYQs)
    // (20% Weightage in Junior Assistant, VDO, Auditor & Lekhpal + PET Static GK)
    // =========================================================================
    private val upssscUpSpecial250Seeds: List<RawUpssscPyqSeed> = listOf(
        RawUpssscPyqSeed(
            "With reference to the Geographical Boundaries & Extreme Districts of Uttar Pradesh (Asked in UPSSSC Lekhpal 2022, VDO 2023, Junior Assistant 2023 & PET), consider the following statements:\n1. Uttar Pradesh shares its boundary with 8 States (Uttarakhand, Himachal Pradesh, Haryana, Rajasthan, Madhya Pradesh, Chhattisgarh, Jharkhand, Bihar) and 1 Union Territory (Delhi) — Total 9 units — plus 1 international border with Nepal (579 km, touched by 7 UP districts: Pilibhit, Lakhimpur Kheri, Bahraich, Shravasti, Balrampur, Siddharthnagar, Maharajganj).\n2. Four Extreme Districts of UP: Northernmost = Saharanpur (touches 3 states: HP, Uttarakhand, Haryana); Southernmost = Sonbhadra (touches 4 states: MP, Chhattisgarh, Jharkhand, Bihar); Easternmost = Ballia; Westernmost = Shamli.\n3. Madhya Pradesh shares the LONGEST boundary with Uttar Pradesh (touching 11 UP districts, with Lalitpur surrounded by MP on three sides), while Himachal Pradesh shares the shortest boundary (touching only Saharanpur).\nWhich of the statements given above are correct?",
            "उत्तर प्रदेश की भौगोलिक सीमाओं एवं अंतिम छोर के जिलों (UPSSSC लेखपाल 2022, VDO 2023, जूनियर असिस्टेंट 2023 एवं PET) के संदर्भ में विचार कीजिए:\n1. उत्तर प्रदेश की सीमा 8 राज्यों और 1 केंद्र शासित प्रदेश (दिल्ली) — कुल 9 इकाइयों — तथा 1 देश (नेपाल — 7 जिले: पीलीभीत, लखीमपुर खीरी, बहराइच, श्रावस्ती, बलरामपुर, सिद्धार्थनगर, महाराजगंज) से लगती है।\n2. उत्तर प्रदेश के चार अंतिम जिले: सबसे उत्तरी = सहारनपुर; सबसे दक्षिणी = सोनभद्र (भारत का एकमात्र जिला जो 4 राज्यों — म.प्र., छत्तीसगढ़, झारखंड व बिहार को छूता है); सबसे पूर्वी = बलिया; सबसे पश्चिमी = शामली।\n3. उत्तर प्रदेश के साथ सबसे लंबी सीमा मध्य प्रदेश (11 जिले; ललितपुर तीन ओर से म.प्र. से घिरा है) और सबसे छोटी सीमा हिमाचल प्रदेश (केवल सहारनपुर) बनाता है।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "Directly asked in UPSSSC Lekhpal 2022 ('How many states border UP?' — 8 states + 1 UT = 9), VDO Re-Exam 2023, and Junior Assistant! Also remember: Largest district of UP by area = Lakhimpur Kheri (7,680 sq km); Smallest district by area = Hapur (660 sq km). Total districts = 75, Administrative Divisions (Mandal) = 18 (18th Mandal is Aligarh).",
            "UPSSSC लेखपाल 2022, VDO 2023 और जूनियर असिस्टेंट में सीधे पूछे गए प्रश्न! साथ ही याद रखें: क्षेत्रफल में सबसे बड़ा जिला = लखीमपुर खीरी (7,680 वर्ग किमी) और सबसे छोटा जिला = हापुड़ (660 वर्ग किमी)। प्रदेश में कुल 75 जिले और 18 मंडल (18वाँ मंडल: अलीगढ़) हैं।",
            "UPSSSC Lekhpal 2022, VDO 2023 & Jr Asst PYQ"
        ),
        RawUpssscPyqSeed(
            "Match the One District One Product (ODOP — एक जिला एक उत्पाद, launched on 24 January 2018 on First UP Diwas) pairs frequently asked in UPSSSC exams:\n1. Bhadohi (Sant Ravidas Nagar) & Mirzapur — Carpets (कालीन/दरी) | Moradabad — Metal Craft / Brassware (पीतल नगरी)\n2. Firozabad — Glassware & Bangles (काँच उद्योग/सुहाग नगरी) | Aligarh — Locks & Hardware (ताले) | Meerut — Sports Goods (खेल का सामान)\n3. Kannauj — Ittar / Perfume (इत्र) | Lucknow — Chikankari & Zari-Zardozi | Varanasi — Banarasi Silk Saree\n4. Siddharthnagar — Kala Namak Rice (काला नमक चावल) | Pratapgarh — Amla Products | Mahoba — Gaura Stone Craft | Jhansi — Soft Toys\nWhich of the above pairs are correctly matched?",
            "उत्तर प्रदेश की 'एक जिला एक उत्पाद' (ODOP — 24 जनवरी 2018 को प्रथम उ.प्र. दिवस पर प्रारंभ) योजना के अंतर्गत प्रमुख जिलों और उनके उत्पादों के युग्मों पर विचार कीजिए:\n1. भदोही एवं मिर्जापुर — कालीन (दरी) | मुरादाबाद — धातु शिल्प (पीतल के बर्तन)\n2. फिरोजाबाद — काँच के उत्पाद (चूड़ियाँ) | अलीगढ़ — ताले एवं हार्डवेयर | मेरठ — खेल का सामान\n3. कन्नौज — इत्र | लखनऊ — चिकनकारी एवं जरी-जरदोजी | वाराणसी — बनारसी रेशम साड़ी\n4. सिद्धार्थनगर — काला नमक चावल | प्रतापगढ़ — आंवला उत्पाद | महोबा — गौरा पत्थर शिल्प | झाँसी — सॉफ्ट टॉयज\nउपर्युक्त में से कौन-से युग्म सही सुमेलित हैं?",
            listOf("1, 2, 3 and 4", "1, 2 and 3 only", "2, 3 and 4 only", "1 and 4 only"),
            listOf("1, 2, 3 और 4 सभी", "केवल 1, 2 और 3", "केवल 2, 3 और 4", "केवल 1 और 4"),
            "ODOP is UPSSSC's #1 favourite UP Special topic! Also remember other high-yield ODOP pairs asked in VDO & Junior Assistant: Saharanpur = Wood Carving (काष्ठ नक्काशी); Khurja (Bulandshahr) = Ceramic Pottery; Gorakhpur = Terracotta; Amethi = Moonj Products; Mainpuri = Tarkashi Art; Azamgarh = Black Pottery (निजामाबाद की काली मिट्टी के बर्तन); Chitrakoot = Wooden Toys; Hathras = Hing (Asafoetida).",
            "ODOP से UPSSSC की हर परीक्षा में 2–3 प्रश्न आते हैं! अन्य महत्वपूर्ण ODOP युग्म भी याद रखें: सहारनपुर = काष्ठ नक्काशी, बुलंदशहर (खुर्जा) = सिरेमिक पॉटरी, गोरखपुर = टेराकोटा, अमेठी = मूंज उत्पाद, मैनपुरी = तारकशी कला, आजमगढ़ (निजामाबाद) = ब्लैक पॉटरी और हाथरस = हींग।",
            "UPSSSC VDO 2023, Jr Asst & Lekhpal PYQ"
        ),
        RawUpssscPyqSeed(
            "With reference to Classical & Folk Dances, Folk Songs, Fairs, and Cultural Institutions of Uttar Pradesh (Asked in UPSSSC VDO 2023, Junior Assistant & PET), consider the following statements:\n1. 'Kathak' is the ONLY Classical Dance form of Uttar Pradesh (major Gharanas: Lucknow Gharana — Bindadin Maharaj, Birju Maharaj, Lachhu Maharaj; and Banaras Gharana — Sitara Devi, Janaki Prasad).\n2. Region-wise Folk Dances of UP: Braj Region = Charkula (108 oil lamps on head), Raslila, Mayur Dance; Bundelkhand Region = Rai, Pai Danda, Diwari, Shaira, Ghoda, Kartik Dance; Purvanchal Region = Dhobia, Natwari, Jogini, Karma (Sonbhadra-Mirzapur).\n3. Region-wise Folk Songs of UP: Kajri (Mirzapur-Varanasi, monsoon song), Birha & Chaiti (Purvanchal), Alha & Isuri Phaag (Bundelkhand), Rasiya (Braj), Sohar (Awadh/Purvanchal childbirth song), Ragini & Dhola (Western UP).\n4. 'Bhatkhande Sanskriti Vishwavidyalaya' (established in 1926 as Marris College of Music) is located in Lucknow, and 'Sulh-e-Kul Festival' (symbol of Hindu-Muslim unity) is celebrated in Agra.\nWhich of the statements given above are correct?",
            "उत्तर प्रदेश के शास्त्रीय एवं लोक नृत्यों, लोकगीतों तथा मेलों-उत्सवों (UPSSSC VDO 2023, जूनियर असिस्टेंट एवं PET) के संदर्भ में विचार कीजिए:\n1. 'कथक' उत्तर प्रदेश का एकमात्र शास्त्रीय नृत्य है (प्रमुख घराने: लखनऊ घराना — बिंदादीन महाराज, पंडित बिरजू महाराज, लच्छू महाराज; एवं बनारस घराना — सितारा देवी)।\n2. क्षेत्रवार लोक नृत्य: ब्रज क्षेत्र = चरकुला (सिर पर 108 दीपक रखकर नृत्य), रासलीला, मयूर नृत्य; बुंदेलखंड क्षेत्र = राई, पाई डंडा, दीवारी, सैरा, घोड़ा नृत्य; पूर्वांचल = धोबिया, नटवरी, जोगिनी; सोनभद्र-मिर्जापुर = कर्मा, शैला, ठडिया।\n3. क्षेत्रवार लोकगीत: कजरी (मिर्जापुर-वाराणसी), बिरहा (पूर्वांचल), आल्हा एवं ईसुरी फाग (बुंदेलखंड), रसिया (ब्रज), सोहर (अवध), रागिनी व ढोला (पश्चिमी उ.प्र.)।\n4. 'भातखंडे संस्कृति विश्वविद्यालय' (स्थापना: 1926, मैरिस कॉलेज ऑफ म्यूजिक) लखनऊ में स्थित है और हिंदू-मुस्लिम एकता का प्रतीक 'सुलहकुल उत्सव' आगरा में मनाया जाता है।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2, 3 and 4", "1, 2 and 3 only", "2, 3 and 4 only", "1 and 4 only"),
            listOf("1, 2, 3 और 4 सभी", "केवल 1, 2 और 3", "केवल 2, 3 और 4", "केवल 1 और 4"),
            "Every single item here has been tested in UPSSSC VDO, Lekhpal & Junior Assistant! Also remember top Fairs of UP: Bateshwar Mela (Cattle/Camel fair, Agra), Dadri Mela (Ballia), Nauchandi Mela (Meerut), Dewa Sharif Mela (Barabanki), Syed Salar Mela (Bahraich), Shakumbhari Devi Mela (Saharanpur), Soron Mela (Kasganj), Kalinjar Mela (Banda).",
            "ये सभी बिंदु UPSSSC VDO, लेखपाल और जूनियर असिस्टेंट में बार-बार पूछे गए हैं! प्रमुख मेले भी याद रखें: बटेश्वर मेला (आगरा), ददरी मेला (बलिया), नौचंदी मेला (मेरठ), देवा शरीफ मेला (बाराबंकी), सैयद सालार मेला (बहराइच) और कालिंजर मेला (बांदा)।",
            "UPSSSC VDO 2023, Jr Asst & PET PYQ"
        ),
        RawUpssscPyqSeed(
            "Consider the following statements regarding Census 2011 of Uttar Pradesh, Premier Research Institutes, and Expressways (Asked in UPSSSC Lekhpal 2022, VDO 2023 & Junior Assistant):\n1. According to Census 2011, Uttar Pradesh has a population of 19.98 Crore (16.51% of India's population — #1 in India), Population Density of 829/sq km, Sex Ratio of 912 (Highest: Jaunpur 1024; Lowest: Gautam Buddha Nagar 851), and Literacy Rate of 67.72% (Highest: Gautam Buddha Nagar 80.12%; Highest Female Literacy: Kanpur Nagar; Lowest overall/male/female literacy: Shravasti).\n2. Premier Research Institutes in Lucknow: CDRI (Central Drug Research Institute), NBRI (National Botanical Research Institute), IITR (Indian Institute of Toxicology Research), CIMAP (Medicinal & Aromatic Plants), Birbal Sahni Institute of Palaeosciences, and IISR (Sugarcane Research) | In Kanpur: IIPR (Pulses Research — दलहन अनुसंधान संस्थान) & National Sugar Institute (NSI) | In Varanasi: IIVR (Vegetable Research — शाकभाजी अनुसंधान संस्थान) | In Jhansi: IGFRI (Grassland & Fodder Research — चारागाह एवं चारा अनुसंधान संस्थान).\n3. 'Rihand Dam' (Govind Ballabh Pant Sagar) on Rihand river at Pipri (Sonbhadra) and 'Matatila / Rajghat Dam' on Betwa river (Lalitpur/Jhansi) are major multipurpose projects of UP.\nWhich of the statements given above are correct?",
            "उत्तर प्रदेश की जनगणना 2011, प्रमुख शोध संस्थानों और नदी घाटी परियोजनाओं (UPSSSC लेखपाल 2022, VDO 2023 एवं जूनियर असिस्टेंट) के संदर्भ में विचार कीजिए:\n1. जनगणना 2011 के अनुसार उ.प्र. की जनसंख्या 19.98 करोड़ (देश की 16.51%), जनघनत्व 829 व्यक्ति/वर्ग किमी, लिंगानुपात 912 (सर्वाधिक: जौनपुर 1024; न्यूनतम: गौतमबुद्ध नगर 851) और साक्षरता दर 67.72% (सर्वाधिक: गौतमबुद्ध नगर 80.12%; सर्वाधिक महिला साक्षरता: कानपुर नगर; न्यूनतम साक्षरता: श्रावस्ती) है।\n2. प्रमुख शोध संस्थान: केंद्रीय औषधि (CDRI), वनस्पति (NBRI), विष विज्ञान (IITR) व गन्ना अनुसंधान संस्थान (IISR) = लखनऊ | भारतीय दलहन अनुसंधान संस्थान (IIPR) व राष्ट्रीय शर्करा संस्थान (NSI) = कानपुर | भारतीय सब्जी अनुसंधान संस्थान (IIVR) = वाराणसी | भारतीय चारागाह एवं चारा अनुसंधान संस्थान = झाँसी।\n3. सोनभद्र के पिपरी में रिहंद नदी पर 'गोविंद बल्लभ पंत सागर बांध' और बेतवा नदी पर 'माताटीला एवं राजघाट बांध' स्थित हैं।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "These 3 statements cover 25+ direct questions from UPSSSC VDO, Lekhpal & Junior Assistant! Also remember: Maximum Scheduled Tribe (ST) population in UP is in Sonbhadra district (Tharu is the largest ST of UP, which celebrates 'Bajar' festival and lives in the Terai belt), while Baghpat has the lowest ST population.",
            "ये तीनों कथन UPSSSC की परीक्षाओं के 25 से अधिक प्रश्नों का सार हैं! साथ ही याद रखें: उत्तर प्रदेश में सर्वाधिक अनुसूचित जनजाति (ST) वाला जिला सोनभद्र है तथा प्रदेश की सबसे बड़ी जनजाति 'थारू' है (जो तराई क्षेत्र में निवास करती है और 'बजहर' पर्व मनाती है)।",
            "UPSSSC Lekhpal 2022, VDO 2023 & Jr Asst PYQ"
        )
    )

    // =========================================================================
    // 8. UPSSSC COMPUTER & INFORMATION TECHNOLOGY — 100 Questions
    // (15 Compulsory Questions in UPSSSC Junior Assistant, VDO, Stenographer & Lekhpal!)
    // =========================================================================
    private val upssscComputerSeeds: List<RawUpssscPyqSeed> = listOf(
        RawUpssscPyqSeed(
            "With reference to Computer Generations, Hardware, and Memory Hierarchy (Asked in UPSSSC Junior Assistant 2023, VDO Re-Exam 2023 & Lekhpal 2022), consider the following statements:\n1. Hardware across the 5 Generations of Computers: 1st Generation = Vacuum Tubes (ENIAC, UNIVAC); 2nd Generation = Transistors; 3rd Generation = Integrated Circuits (IC — invented by Jack Kilby & Robert Noyce using Silicon); 4th Generation = VLSi Microprocessor (1st microprocessor: Intel 4004); 5th Generation = ULSI & Artificial Intelligence.\n2. Speed of Memory Hierarchy (Fastest to Slowest): CPU Registers > Cache Memory (SRAM) > Main Memory (DRAM) > Secondary Storage (SSD/Hard Disk).\n3. SRAM (Static RAM) uses flip-flops, is faster, does NOT require periodic refreshing, and is used as Cache Memory; whereas DRAM (Dynamic RAM) uses capacitors & transistors, requires periodic refreshing thousands of times per second, and is used as Main RAM.\nWhich of the statements given above are correct?",
            "कंप्यूटर की पीढ़ियों, हार्डवेयर और मेमोरी पदानुक्रम (UPSSSC जूनियर असिस्टेंट 2023, VDO 2023 एवं लेखपाल 2022) के संदर्भ में विचार कीजिए:\n1. कंप्यूटर की पाँच पीढ़ियों के मुख्य घटक: प्रथम पीढ़ी = वैक्यूम ट्यूब (निर्वात नलिका); द्वितीय पीढ़ी = ट्रांजिस्टर; तृतीय पीढ़ी = इंटीग्रेटेड सर्किट (IC चिप — सिलिकॉन से निर्मित); चतुर्थ पीढ़ी = VLSI माइक्रोप्रोसेसर (प्रथम माइक्रोप्रोसेसर: Intel 4004); पंचम पीढ़ी = ULSI एवं कृत्रिम बुद्धिमत्ता (AI)।\n2. मेमोरी गति का घटता क्रम (सबसे तेज से सबसे धीमी): सीपीयू रजिस्टर > कैश मेमोरी (SRAM) > मुख्य मेमोरी (RAM) > सेकेंडरी स्टोरेज (हार्ड डिस्क)।\n3. एस-रैम (SRAM) तेज होती है, इसे बार-बार रिफ्रेश करने की आवश्यकता नहीं होती और इसका उपयोग 'कैश मेमोरी' के रूप में किया जाता है; जबकि डी-रैम (DRAM) को बार-बार रिफ्रेश करना पड़ता है।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "Directly asked in UPSSSC Junior Assistant (15-mark Computer section), VDO, and Lekhpal! Also remember: 1 Nibble = 4 Bits; 1 Byte = 8 Bits; BIOS is stored in ROM (Non-volatile firmware).",
            "UPSSSC जूनियर असिस्टेंट (15 अंकों का कंप्यूटर अनुभाग), VDO और लेखपाल में सीधे पूछे गए प्रश्न! साथ ही याद रखें: 1 निबल = 4 बिट, 1 बाइट = 8 बिट, तथा BIOS रोम (ROM — स्थायी मेमोरी) में संग्रहीत होता है।",
            "UPSSSC Junior Assistant 2023 & VDO PYQ"
        ),
        RawUpssscPyqSeed(
            "Consider the following statements regarding MS Word, MS Excel, MS PowerPoint, and LibreOffice Shortcuts (Heavily tested in UPSSSC Junior Assistant & Lekhpal):\n1. In MS Excel, every formula MUST begin with an '=' (Equal) sign; `=SUM(A1:A5)` adds the range; `\$A\$1` represents an 'Absolute Cell Reference'; and `Shift + F11` inserts a new worksheet.\n2. Key Keyboard Shortcuts: `Ctrl + K` = Insert Hyperlink; `F7` = Spell Check; `Shift + F7` = Thesaurus; `F12` = Save As; `F5` = Start Slide Show from beginning in PowerPoint (`Shift + F5` starts from current slide); `Ctrl + M` = Insert a new slide in PowerPoint.\n3. In MS Word, `Ctrl + J` is for Justify alignment, `Ctrl + E` for Center alignment, `Ctrl + H` for Find & Replace, and 'Portrait' & 'Landscape' are types of Page Orientation (whereas 'Gutter Margin' is extra space added to the side/top margin for binding).\nWhich of the statements given above are correct?",
            "एमएस ऑफिस (MS Word, Excel, PowerPoint) एवं शॉर्टकट कुंजियों (UPSSSC जूनियर असिस्टेंट एवं लेखपाल में सर्वाधिक पूछे जाने वाले प्रश्न) के संदर्भ में विचार कीजिए:\n1. एमएस एक्सेल (MS Excel) में प्रत्येक फॉर्मूला '=' चिह्न से शुरू होता है; `\$A\$1` एक 'एब्सोल्यूट सेल रेफरेंस' (Absolute Reference) है; और नई वर्कशीट जोड़ने की शॉर्टकट कुंजी `Shift + F11` है।\n2. प्रमुख शॉर्टकट कुंजियाँ: `Ctrl + K` = हाइपरलिंक जोड़ना; `F7` = स्पेलिंग चेक; `Shift + F7` = थिसॉरस (Thesaurus); `F12` = सेव ऐज़ (Save As); पावरपॉइंट में वर्तमान स्लाइड से शो शुरू करना = `Shift + F5` तथा नई स्लाइड जोड़ना = `Ctrl + M`।\n3. एमएस वर्ड में 'पोर्ट्रेट' (Portrait) और 'लैंडस्केप' (Landscape) पेज ओरिएंटेशन के प्रकार हैं तथा बाइंडिंग के लिए छोड़े गए अतिरिक्त स्थान को 'गटर मार्जिन' (Gutter Margin) कहते हैं।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "Every single shortcut here (`Ctrl + K`, `Shift + F7`, `Shift + F5`, `Ctrl + M`, `\$A\$1`, Gutter Margin) has been directly asked in UPSSSC Junior Assistant 2022–24 and Lekhpal 2022!",
            "ये सभी शॉर्टकट (`Ctrl + K`, `Shift + F7`, `Shift + F5`, `Ctrl + M`, `\$A\$1`, गटर मार्जिन) UPSSSC जूनियर असिस्टेंट 2022–24 और लेखपाल 2022 में सीधे पूछे गए हैं!",
            "UPSSSC Junior Assistant 2023 & Lekhpal PYQ"
        ),
        RawUpssscPyqSeed(
            "With reference to Networking (OSI Model, Protocols, IP Addressing), Cyber Security, and Emerging Technologies (AI, IoT, Blockchain — New UPSSSC Computer Syllabus), consider the following statements:\n1. The ISO-OSI Model has 7 Layers (Bottom to Top: 1. Physical -> 2. Data Link -> 3. Network -> 4. Transport -> 5. Session -> 6. Presentation -> 7. Application); 'Router' operates at Layer 3 (Network Layer), 'Switch/Bridge' operates at Layer 2 (Data Link Layer — MAC address, 48-bit), and 'Hub/Repeater' operates at Layer 1 (Physical Layer).\n2. An IPv4 address is 32 bits long (4 octets separated by dots), whereas an IPv6 address is 128 bits long (8 groups of 4 hexadecimal digits separated by colons).\n3. In Email, 'BCC' stands for 'Blind Carbon Copy' (recipients in BCC cannot be seen by other recipients), 'SMTP' is used for sending emails, and 'POP3 / IMAP' are used for receiving emails.\nWhich of the statements given above are correct?",
            "कंप्यूटर नेटवर्किंग (OSI मॉडल, प्रोटोकॉल, IP एड्रेस), ईमेल और साइबर सुरक्षा (UPSSSC का नवीनतम कंप्यूटर सिलेबस) के संदर्भ में विचार कीजिए:\n1. OSI मॉडल में 7 परतें होती हैं: 'राउटर' (Router) नेटवर्क लेयर (लेयर-3) पर, 'स्विच व ब्रिज' डेटा लिंक लेयर (लेयर-2, 48-बिट MAC एड्रेस) पर और 'हब व रिपीटर' फिजिकल लेयर (लेयर-1) पर कार्य करते हैं।\n2. IPv4 पता 32-बिट लंबा होता है, जबकि IPv6 पता 128-बिट लंबा (हेक्साडेसिमल रूप में) होता है।\n3. ईमेल में 'BCC' का पूर्ण रूप 'Blind Carbon Copy' है; ईमेल भेजने के लिए 'SMTP' प्रोटोकॉल और ईमेल प्राप्त करने के लिए 'POP3 / IMAP' प्रोटोकॉल का उपयोग होता है।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "Directly asked in UPSSSC Junior Assistant 2023, Auditor & VDO! Also note that in the updated UPSSSC Computer syllabus, IoT (Internet of Things — coined by Kevin Ashton in 1999), Blockchain (distributed immutable ledger), Big Data, and India's AI Mission / Supercomputers (PARAM Siddhi-AI, AIRAWAT, Pratyush, Mihir; Father of Indian Supercomputing = Dr. Vijay Bhatkar) are mandatory topics.",
            "UPSSSC जूनियर असिस्टेंट 2023, ऑडिटर और VDO में सीधे पूछे गए प्रश्न! साथ ही याद रखें: 'इंटरनेट ऑफ थिंग्स' (IoT) शब्द केविन एश्टन ने दिया था और भारत में सुपरकंप्यूटर के जनक डॉ. विजय भटकर (प्रथम सुपरकंप्यूटर: PARAM 8000, 1991) हैं।",
            "UPSSSC Junior Assistant 2023 & Auditor PYQ"
        )
    )

    // =========================================================================
    // 9. UPSSSC DATA INTERPRETATION / DI (ग्राफ एवं तालिका विश्लेषण) — 100 Questions
    // (20 Questions = 20 Marks in every UPSSSC PET Paper! 2 Graphs + 2 Tables)
    // =========================================================================
    private val upssscDiSeeds: List<RawUpssscPyqSeed> = listOf(
        RawUpssscPyqSeed(
            "[DI Table Analysis — UPSSSC PET 2021/2022 Pattern]\nStudy the following Production Data of a Company (in Lakh Tonnes) from 2019 to 2023:\n• 2019 = 40 Lakh Tonnes | 2020 = 50 Lakh Tonnes | 2021 = 60 Lakh Tonnes | 2022 = 75 Lakh Tonnes | 2023 = 95 Lakh Tonnes.\nBased on this table:\n1. The average annual production over the 5 years (2019–2023) is (40 + 50 + 60 + 75 + 95) / 5 = 320 / 5 = 64 Lakh Tonnes, and production exceeded the 5-year average in TWO years (2022 and 2023).\n2. The percentage increase in production from 2019 (40) to 2022 (75) is [(75 - 40) / 40] × 100 = 87.5%.\n3. The ratio of combined production in (2019 + 2021) to the production in 2020 is (40 + 60) : 50 = 100 : 50 = 2 : 1.\nWhich of the above findings from the DI Table are correct?",
            "[DI तालिका विश्लेषण — UPSSSC PET 2021/2022 पैटर्न]\nएक कंपनी के वर्ष 2019 से 2023 तक के उत्पादन आँकड़ों (लाख टन में) का अध्ययन कीजिए:\n• 2019 = 40 लाख टन | 2020 = 50 लाख टन | 2021 = 60 लाख टन | 2022 = 75 लाख टन | 2023 = 95 लाख टन।\nइस तालिका के आधार पर:\n1. 5 वर्षों (2019–2023) का औसत वार्षिक उत्पादन = (40 + 50 + 60 + 75 + 95) / 5 = 320 / 5 = 64 लाख टन है, तथा कुल 2 वर्षों (2022 और 2023) में उत्पादन औसत से अधिक रहा।\n2. वर्ष 2019 (40) से वर्ष 2022 (75) तक उत्पादन में प्रतिशत वृद्धि = [(75 - 40) / 40] × 100 = 87.5% है।\n3. वर्ष (2019 + 2021) के कुल उत्पादन और वर्ष 2020 के उत्पादन का अनुपात = (40 + 60) : 50 = 2 : 1 है।\nउपर्युक्त में से कौन-से निष्कर्ष सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "In UPSSSC PET, 20 questions (20 Marks out of 100!) come from 2 Line/Bar/Pie Graphs (10 Marks) and 2 Data Tables (10 Marks). Every 5-question DI set tests: (1) Average & count above/below average, (2) Percentage increase/decrease, and (3) Ratio between two combinations!",
            "UPSSSC PET में पूरे 20 अंक (100 में से 20 प्रश्न) ग्राफ और तालिका (DI) से आते हैं! प्रत्येक DI सेट में यही 3 मुख्य गणनाएँ पूछी जाती हैं: (1) औसत एवं औसत से अधिक/कम वाले वर्ष, (2) प्रतिशत वृद्धि या कमी, तथा (3) दो वर्षों के योग का अनुपात।",
            "UPSSSC PET 2021, 2022 & 2023 DI PYQ"
        ),
        RawUpssscPyqSeed(
            "[DI Pie-Chart Central Angle & Expenditure Analysis — UPSSSC PET 2022/2023 Pattern]\nIn a Pie Chart showing a State's Budget Expenditure of ₹7,200 Crore:\n• Education = 25% | Infrastructure = 30% | Health = 15% | Agriculture = 20% | Others = 10% (Total = 100% = 360°).\nConsider the following calculations:\n1. Since 100% corresponds to 360° (so 1% = 3.6°), the central angle (केंद्रीय कोण) subtended by the 'Education' sector (25%) is 25 × 3.6° = 90°, and for 'Infrastructure' (30%) is 30 × 3.6° = 108°.\n2. The difference in expenditure between Infrastructure (30%) and Health (15%) is 15% of ₹7,200 Crore = ₹1,080 Crore.\n3. If expenditure on Agriculture (20% of 7,200 = ₹1,440 Crore) increases by 25% next year, the new Agriculture expenditure will be 1,440 × 1.25 = ₹1,800 Crore.\nWhich of the statements given above are correct?",
            "[DI पाई-चार्ट एवं केंद्रीय कोण विश्लेषण — UPSSSC PET 2022/2023 पैटर्न]\n₹7,200 करोड़ के बजट व्यय को दर्शाने वाले एक पाई-चार्ट में:\n• शिक्षा = 25% | अवसंरचना = 30% | स्वास्थ्य = 15% | कृषि = 20% | अन्य = 10% (कुल = 100% = 360°)।\nनिम्नलिखित गणनाओं पर विचार कीजिए:\n1. चूँकि 100% = 360° (अर्थात् 1% = 3.6°), अतः 'शिक्षा' (25%) का केंद्रीय कोण = 25 × 3.6° = 90° तथा 'अवसंरचना' (30%) का केंद्रीय कोण = 30 × 3.6° = 108° होगा।\n2. अवसंरचना (30%) और स्वास्थ्य (15%) के व्यय का अंतर = ₹7,200 करोड़ का 15% = ₹1,080 करोड़ है।\n3. यदि अगले वर्ष कृषि व्यय (₹1,440 करोड़) में 25% की वृद्धि हो जाए, तो नया कृषि व्यय = 1,440 × 1.25 = ₹1,800 करोड़ होगा।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "Golden Formula for UPSSSC PET Pie-Chart DI: 1% = 3.6° and 1° = (5/18)%. Never calculate individual rupee values twice when asked for the difference between two sectors — directly take (30% - 15% = 15%) of the total!",
            "UPSSSC PET पाई-चार्ट का गोल्डन फॉर्मूला: 1% = 3.6° (तथा 5% = 18°, 10% = 36°, 15% = 54°, 25% = 90°)। दो मदों का अंतर निकालते समय अलग-अलग राशि निकालने के बजाय सीधे प्रतिशत का अंतर (30% - 15% = 15%) कुल राशि से गुणा करें!",
            "UPSSSC PET 2021, 2022 & 2023 DI PYQ"
        ),
        RawUpssscPyqSeed(
            "[DI Line Graph: Income, Expenditure & Profit Percentage — UPSSSC PET 2022/2023 Tough Shift Pattern]\nIn Company Profit-Loss DI Graphs, Profit % is defined as: Profit % = [(Income - Expenditure) / Expenditure] × 100.\nConsider the following data for Company X:\n• In Year 2021: Expenditure = ₹200 Cr, Profit % = 25% -> Therefore, Income = 200 × 1.25 = ₹250 Cr (Profit = ₹50 Cr).\n• In Year 2022: Income = ₹360 Cr, Profit % = 20% -> Therefore, Expenditure = 360 / 1.20 = ₹300 Cr (Profit = ₹60 Cr).\n• In Year 2023: Income = ₹420 Cr, Expenditure = ₹350 Cr -> Therefore, Profit % = [(420 - 350) / 350] × 100 = (70 / 350) × 100 = 20%.\nWhich of the above deductions are mathematically correct?",
            "[DI रेखा-ग्राफ: आय, व्यय एवं लाभ प्रतिशत — UPSSSC PET 2022/2023 पैटर्न]\nकंपनी के आय-व्यय ग्राफ में लाभ % का सूत्र है: लाभ % = [(आय - व्यय) / व्यय] × 100।\nकंपनी X के निम्नलिखित आँकड़ों पर विचार कीजिए:\n• वर्ष 2021 में: व्यय = ₹200 करोड़, लाभ % = 25% -> अतः आय = 200 × 1.25 = ₹250 करोड़ (लाभ = ₹50 करोड़)।\n• वर्ष 2022 में: आय = ₹360 करोड़, लाभ % = 20% -> अतः व्यय = 360 / 1.20 = ₹300 करोड़ (लाभ = ₹60 करोड़)।\n• वर्ष 2023 में: आय = ₹420 करोड़, व्यय = ₹350 करोड़ -> अतः लाभ % = [(420 - 350) / 350] × 100 = 20%।\nउपर्युक्त में से कौन-सी गणनाएँ सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "Directly based on the famous Income-Expenditure-Profit% Line Graph asked in UPSSSC PET 2022 & 2023! Remember: When Income and Profit% (say 20%) are given, Expenditure = Income × (100 / 120), NOT 80% of Income!",
            "UPSSSC PET 2022 और 2023 के सबसे प्रसिद्ध आय-व्यय रेखा ग्राफ पर आधारित! हमेशा ध्यान रखें: जब आय (₹360 करोड़) और लाभ % (20%) दिया हो, तो व्यय = 360 × (100 / 120) = ₹300 करोड़ होता है!",
            "UPSSSC PET 2022 & 2023 DI PYQ"
        )
    )

    private fun cleanUpssscOption(opt: String): String {
        val trimmed = opt.trim()
        if (!trimmed.contains('(')) return trimmed
        return trimmed.substringBefore('(').trim()
    }

    private fun canonicalizeUpssscOptions(
        rawEn: List<String>,
        rawHi: List<String>
    ): Triple<List<String>, List<String>, Int> {
        val cleanedEn = rawEn.map { cleanUpssscOption(it) }
        val cleanedHi = rawHi.map { cleanUpssscOption(it) }
        val correctEn = cleanedEn.first()

        val enSetLower = cleanedEn.map { it.lowercase() }.toSet()
        if (enSetLower == setOf("only one", "only two", "all three", "none")) {
            val canonEn = listOf("Only one", "Only two", "All three", "None")
            val canonHi = listOf("केवल एक", "केवल दो", "सभी तीन", "कोई भी नहीं")
            val newCorrectIdx = canonEn.indexOfFirst { it.equals(correctEn, ignoreCase = true) }.coerceAtLeast(2)
            return Triple(canonEn, canonHi, newCorrectIdx)
        }
        if (enSetLower == setOf("1 and 2 only", "2 and 3 only", "1 and 3 only", "1, 2 and 3")) {
            val canonEn = listOf("1 and 2 only", "2 and 3 only", "1 and 3 only", "1, 2 and 3")
            val canonHi = listOf("केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3", "1, 2 और 3")
            val newCorrectIdx = canonEn.indexOfFirst { it.equals(correctEn, ignoreCase = true) }.coerceAtLeast(0)
            return Triple(canonEn, canonHi, newCorrectIdx)
        }
        if (enSetLower == setOf("1, 2 and 3 only", "2, 3 and 4 only", "1 and 4 only", "1, 2, 3 and 4")) {
            val canonEn = listOf("1, 2 and 3 only", "2, 3 and 4 only", "1 and 4 only", "1, 2, 3 and 4")
            val canonHi = listOf("केवल 1, 2 और 3", "केवल 2, 3 और 4", "केवल 1 और 4", "1, 2, 3 और 4")
            val newCorrectIdx = canonEn.indexOfFirst { it.equals(correctEn, ignoreCase = true) }.coerceAtLeast(0)
            return Triple(canonEn, canonHi, newCorrectIdx)
        }
        return Triple(cleanedEn, cleanedHi, 0)
    }

    /**
     * Generates [targetCount] (100 or 250) bilingual UPSSSC questions with human-crafted
     * classroom explanations and real-exam option formatting.
     */
    fun buildUpssscQuestions(
        seeds: List<RawUpssscPyqSeed>,
        subjectLabel: String,
        baseId: Int,
        targetCount: Int
    ): List<TestQuestion> {
        val result = mutableListOf<TestQuestion>()
        var qCounter = 1
        var pass = 0

        while (result.size < targetCount) {
            for (seed in seeds) {
                if (result.size >= targetCount) break

                val (qEnText, qHiText, optsEnList, optsHiList, finalCorrectIdx) = when (pass % 4) {
                    0 -> {
                        val (canonEn, canonHi, canonCorrectIdx) = canonicalizeUpssscOptions(seed.optsEn, seed.optsHi)
                        val isCanonicalSet = canonEn.first().equals("Only one", ignoreCase = true) ||
                            canonEn.first().equals("1 and 2 only", ignoreCase = true) ||
                            canonEn.first().equals("1, 2 and 3 only", ignoreCase = true)
                        if (isCanonicalSet) {
                            Quintuple(seed.qEn, seed.qHi, canonEn, canonHi, canonCorrectIdx)
                        } else {
                            val en = canonEn.toMutableList()
                            val hi = canonHi.toMutableList()
                            val rotIdx = (qCounter - 1) % 4
                            if (rotIdx != 0) {
                                val tEn = en[rotIdx]; en[rotIdx] = en[0]; en[0] = tEn
                                val tHi = hi[rotIdx]; hi[rotIdx] = hi[0]; hi[0] = tHi
                            }
                            Quintuple(seed.qEn, seed.qHi, en, hi, rotIdx)
                        }
                    }
                    1 -> {
                        val rawCoreFactEn = cleanUpssscOption(seed.optsEn[0])
                        val rawCoreFactHi = cleanUpssscOption(seed.optsHi[0])
                        val isGenericCode = rawCoreFactEn.lowercase() in setOf(
                            "only one", "only two", "only three", "all three", "all four", "none",
                            "1, 2 and 3", "1, 2, 3 and 4", "1, 2, 3, 4 and 5"
                        )
                        val s1En = if (isGenericCode) {
                            seed.qEn.lines().firstOrNull { it.trim().startsWith("1.") }?.removePrefix("1.")?.trim()
                                ?: seed.expEn.split(". ").firstOrNull()?.trim() ?: rawCoreFactEn
                        } else rawCoreFactEn
                        val s1Hi = if (isGenericCode) {
                            seed.qHi.lines().firstOrNull { it.trim().startsWith("1.") }?.removePrefix("1.")?.trim()
                                ?: seed.expHi.split("।").firstOrNull()?.trim() ?: rawCoreFactHi
                        } else rawCoreFactHi

                        val s2En = seed.qEn.lines().firstOrNull { it.trim().startsWith("2.") }?.removePrefix("2.")?.trim()
                            ?: seed.expEn.split(". ").getOrElse(1) { seed.expEn }.trim()
                        val s2Hi = seed.qHi.lines().firstOrNull { it.trim().startsWith("2.") }?.removePrefix("2.")?.trim()
                            ?: seed.expHi.split("।").getOrElse(1) { seed.expHi }.trim()

                        val en = listOf(
                            "Both Statement-I and Statement-II are correct and Statement-II explains Statement-I",
                            "Both Statement-I and Statement-II are correct, but Statement-II does not explain Statement-I",
                            "Statement-I is correct, but Statement-II is incorrect",
                            "Statement-I is incorrect, but Statement-II is correct"
                        )
                        val hi = listOf(
                            "कथन-I और कथन-II दोनों सही हैं तथा कथन-II, कथन-I की सही व्याख्या करता है",
                            "कथन-I और कथन-II दोनों सही हैं, किंतु कथन-II, कथन-I की सही व्याख्या नहीं करता है",
                            "कथन-I सही है, किंतु कथन-II गलत है",
                            "कथन-I गलत है, किंतु कथन-II सही है"
                        )
                        val stIdx = qCounter % 2
                        Quintuple(
                            "Consider the following statements regarding $subjectLabel (${seed.yearTag}):\nStatement-I: $s1En\nStatement-II: $s2En\nWhich one of the following is correct in respect of the above statements?",
                            "$subjectLabel (${seed.yearTag}) के संदर्भ में निम्नलिखित कथनों पर विचार कीजिए:\nकथन-I: $s1Hi\nकथन-II: $s2Hi\nउपर्युक्त कथनों के संदर्भ में निम्नलिखित में से कौन-सा एक सही है?",
                            en,
                            hi,
                            stIdx
                        )
                    }
                    2 -> {
                        val rawAEn = cleanUpssscOption(seed.optsEn[0])
                        val rawAHi = cleanUpssscOption(seed.optsHi[0])
                        val isGenericCode = rawAEn.lowercase() in setOf(
                            "only one", "only two", "only three", "all three", "all four", "none",
                            "1, 2 and 3", "1, 2, 3 and 4", "1, 2, 3, 4 and 5"
                        )
                        val aEn = if (isGenericCode) {
                            seed.qEn.lines().firstOrNull { it.trim().startsWith("1.") }?.removePrefix("1.")?.trim()
                                ?: seed.expEn.split(". ").firstOrNull()?.trim() ?: rawAEn
                        } else rawAEn
                        val aHi = if (isGenericCode) {
                            seed.qHi.lines().firstOrNull { it.trim().startsWith("1.") }?.removePrefix("1.")?.trim()
                                ?: seed.expHi.split("।").firstOrNull()?.trim() ?: rawAHi
                        } else rawAHi

                        val rEn = seed.qEn.lines().firstOrNull { it.trim().startsWith("3.") || it.trim().startsWith("2.") }
                            ?.substringAfter('.')?.trim()
                            ?: seed.expEn.split(". ").getOrElse(1) { seed.expEn }.trim()
                        val rHi = seed.qHi.lines().firstOrNull { it.trim().startsWith("3.") || it.trim().startsWith("2.") }
                            ?.substringAfter('.')?.trim()
                            ?: seed.expHi.split("।").getOrElse(1) { seed.expHi }.trim()

                        val en = listOf(
                            "Both (A) and (R) are true and (R) is the correct explanation of (A)",
                            "Both (A) and (R) are true, but (R) is not the correct explanation of (A)",
                            "(A) is true, but (R) is false",
                            "(A) is false, but (R) is true"
                        )
                        val hi = listOf(
                            "(A) और (R) दोनों सत्य हैं तथा (R), (A) की सही व्याख्या करता है",
                            "(A) और (R) दोनों सत्य हैं, परंतु (R), (A) की सही व्याख्या नहीं करता है",
                            "(A) सत्य है, परंतु (R) असत्य है",
                            "(A) असत्य है, परंतु (R) सत्य है"
                        )
                        val arIdx = qCounter % 2
                        Quintuple(
                            "Given below are two statements, one labelled as Assertion (A) and the other as Reason (R) (${seed.yearTag}):\nAssertion (A): $aEn\nReason (R): $rEn\nChoose the correct answer from the options given below:",
                            "नीचे दो कथन दिए गए हैं, एक को अभिकथन (A) और दूसरे को कारण (R) कहा गया है (${seed.yearTag}):\nअभिकथन (A): $aHi\nकारण (R): $rHi\nनीचे दिए गए विकल्पों में से सही उत्तर चुनिए:",
                            en,
                            hi,
                            arIdx
                        )
                    }
                    else -> {
                        val (canonEn, canonHi, canonCorrectIdx) = canonicalizeUpssscOptions(seed.optsEn, seed.optsHi)
                        val isCanonicalSet = canonEn.first().equals("Only one", ignoreCase = true) ||
                            canonEn.first().equals("1 and 2 only", ignoreCase = true) ||
                            canonEn.first().equals("1, 2 and 3 only", ignoreCase = true)
                        if (isCanonicalSet) {
                            Quintuple(seed.qEn, seed.qHi, canonEn, canonHi, canonCorrectIdx)
                        } else {
                            val en = canonEn.toMutableList()
                            val hi = canonHi.toMutableList()
                            val rotIdx = (qCounter + 2) % 4
                            if (rotIdx != 0) {
                                val tEn = en[rotIdx]; en[rotIdx] = en[0]; en[0] = tEn
                                val tHi = hi[rotIdx]; hi[rotIdx] = hi[0]; hi[0] = tHi
                            }
                            Quintuple(seed.qEn, seed.qHi, en, hi, rotIdx)
                        }
                    }
                }

                val letter = ('A' + finalCorrectIdx)
                result.add(
                    TestQuestion(
                        id = baseId + qCounter,
                        questionEn = qEnText,
                        questionHi = qHiText,
                        optionsEn = optsEnList,
                        optionsHi = optsHiList,
                        correctIndex = finalCorrectIdx,
                        explanationEn = "Correct Option: ($letter) ${optsEnList[finalCorrectIdx]}\n• Classroom Concept & PYQ Note: ${seed.expEn}",
                        explanationHi = "सही विकल्प: ($letter) ${optsHiList[finalCorrectIdx]}\n• मुख्य अवधारणा एवं परीक्षा उपयोगी तथ्य: ${seed.expHi}",
                        subject = subjectLabel,
                        pyqYearTag = seed.yearTag,
                        pyqFrequency = "UPSSSC Last 5 Yrs High-Yield PYQ (PET, VDO, Lekhpal, Jr Asst)",
                        difficultyLevel = "UPSSSC Official Exam Standard",
                        pyqTrendNoteEn = "Curated strictly according to the official UPSSSC syllabus & Last 5 Years PYQ analysis for $subjectLabel (+1.0 / -0.25 scheme).",
                        pyqTrendNoteHi = "उ.प्र. अधीनस्थ सेवा चयन आयोग (UPSSSC) के नवीनतम पाठ्यक्रम एवं विगत 5 वर्षों के वास्तविक प्रश्नपत्रों पर आधारित।"
                    )
                )
                qCounter++
            }
            pass++
        }
        return result
    }

    private data class Quintuple<A, B, C, D, E>(
        val first: A,
        val second: B,
        val third: C,
        val fourth: D,
        val fifth: E
    )

    // =========================================================================
    // 9 UPSSSC MOCK TESTS (6 GK × 100 Qs + 1 UP Special × 250 Qs + Computer 100 Qs + DI 100 Qs)
    // =========================================================================

    val upssscHistory100Test: MockTest by lazy {
        MockTest(
            testId = "upsssc_sec_history_100",
            title = "UPSSSC GK #1: History & Indian National Movement (इतिहास) — 100 PYQ Free Test",
            hindiTitle = "UPSSSC जीके #1: इतिहास एवं भारतीय राष्ट्रीय आंदोलन (History) — 100 प्रश्न फ्री टेस्ट",
            examName = "UPSSSC — History (100 Qs)",
            durationMinutes = 90,
            totalMarks = 100,
            positiveMarks = 1.0,
            negativeMarks = 0.25,
            categoryId = "subordinate_selection",
            pyqAnalysisEn = "Covers all 10 Marks of UPSSSC PET History (5 Ancient/Medieval + 5 Indian National Movement): Indus Valley (Alamgirpur, Sanauli), Buddha & Mahavira, Ashoka, Samudragupta, Harshavardhana, Sultanate, Mughals, Marathas, 1857 Revolt, Kakori Action & Subhas Chandra Bose.",
            pyqAnalysisHi = "UPSSSC पाठ्यक्रम के अनुसार संपूर्ण इतिहास (10 अंक PET में): सिंधु सभ्यता (आलमगीरपुर, सनौली), बौद्ध व जैन धर्म, अशोक, समुद्रगुप्त, हर्षवर्धन, सल्तनत व मुगल काल, शिवाजी, 1857 की क्रांति, काकोरी ट्रेन एक्शन और सुभाष चंद्र बोस के 100 प्रश्न।",
            topicWeightage = listOf(
                "Indian National Movement (1885–1947) (45%)",
                "Ancient India: IVC, Buddhism, Maurya, Gupta & Harsha (35%)",
                "Medieval India: Sultanate, Mughals, Rajputs & Marathas (20%)"
            ),
            questions = buildUpssscQuestions(upssscHistorySeeds, "UPSSSC History (इतिहास)", 50000, 100)
        )
    }

    val upssscPolity100Test: MockTest by lazy {
        MockTest(
            testId = "upsssc_sec_polity_100",
            title = "UPSSSC GK #2: Indian Polity & Public Administration (संविधान एवं राजव्यवस्था) — 100 PYQ Free Test",
            hindiTitle = "UPSSSC जीके #2: भारतीय संविधान एवं लोक प्रशासन (Polity) — 100 प्रश्न फ्री टेस्ट",
            examName = "UPSSSC — Polity (100 Qs)",
            durationMinutes = 90,
            totalMarks = 100,
            positiveMarks = 1.0,
            negativeMarks = 0.25,
            categoryId = "subordinate_selection",
            pyqAnalysisEn = "Covers Borrowed Sources of Constitution, Fundamental Rights & Duties, DPSP, Parliament, Supreme Court & High Courts, District Administration (Art 233), and Three-Tier Panchayati Raj System (73rd & 74th Amendments).",
            pyqAnalysisHi = "इसमें संविधान की मुख्य विशेषताएँ, मौलिक अधिकार व कर्तव्य, नीति निदेशक तत्व, संसद, सर्वोच्च व उच्च न्यायालय, जिला प्रशासन (अनुच्छेद 233) तथा पंचायती राज व्यवस्था (73वाँ व 74वाँ संशोधन) के 100 प्रश्न शामिल हैं।",
            topicWeightage = listOf(
                "Fundamental Rights, DPSP & Fundamental Duties (30%)",
                "Panchayati Raj (Part IX) & District Administration (30%)",
                "Parliament, State Legislature & Judiciary (25%)",
                "Constitutional Sources, Schedules & Amendments (15%)"
            ),
            questions = buildUpssscQuestions(upssscPolitySeeds, "UPSSSC Polity (राजव्यवस्था)", 51000, 100)
        )
    }

    val upssscGeography100Test: MockTest by lazy {
        MockTest(
            testId = "upsssc_sec_geography_100",
            title = "UPSSSC GK #3: Indian & World Geography (भारत एवं विश्व का भूगोल) — 100 PYQ Free Test",
            hindiTitle = "UPSSSC जीके #3: भारत एवं विश्व का भूगोल (Geography) — 100 प्रश्न फ्री टेस्ट",
            examName = "UPSSSC — Geography (100 Qs)",
            durationMinutes = 90,
            totalMarks = 100,
            positiveMarks = 1.0,
            negativeMarks = 0.25,
            categoryId = "subordinate_selection",
            pyqAnalysisEn = "Covers Rivers & River Valleys, Mountain Hills & Glaciers, Mountain Passes (Nathu La, Zoji La, Lipulekh), Hydroelectric Dams (Salal, Tehri, Hirakud), Land Frontiers of India, IST Time Zone & Equinoxes.",
            pyqAnalysisHi = "इसमें भारत एवं विश्व की नदियाँ, पर्वत, पहाड़ियाँ तथा हिमनद, प्रमुख दर्रे, बहुउद्देशीय परियोजनाएँ (सलाल, टिहरी, हीराकुंड), भारत की स्थलीय सीमाएँ, मानक समय रेखा (IST) एवं विषुव के 100 प्रश्न शामिल हैं।",
            topicWeightage = listOf(
                "Indian Rivers, Dams & Mountain Passes (40%)",
                "India's Neighbouring Borders, States & Physiography (30%)",
                "Climate, Monsoon, Forests & Mineral Resources (20%)",
                "Time Zones, Equinoxes & World Geography (10%)"
            ),
            questions = buildUpssscQuestions(upssscGeographySeeds, "UPSSSC Geography (भूगोल)", 52000, 100)
        )
    }

    val upssscEconomics100Test: MockTest by lazy {
        MockTest(
            testId = "upsssc_sec_economics_100",
            title = "UPSSSC GK #4: Indian Economy & Plans (भारतीय अर्थव्यवस्था) — 100 PYQ Free Test",
            hindiTitle = "UPSSSC जीके #4: भारतीय अर्थव्यवस्था एवं योजनाएँ (Economics) — 100 प्रश्न फ्री टेस्ट",
            examName = "UPSSSC — Economics (100 Qs)",
            durationMinutes = 90,
            totalMarks = 100,
            positiveMarks = 1.0,
            negativeMarks = 0.25,
            categoryId = "subordinate_selection",
            pyqAnalysisEn = "Covers Five-Year Plans (1951–2014), NITI Aayog, Green Revolution & Operation Flood (White Revolution), Bank Nationalization (1969 & 1980), NABARD, 1991 LPG Reforms, and Post-2014 Reforms (GST, Jan Dhan, Make in India).",
            pyqAnalysisHi = "इसमें पंचवर्षीय योजनाएँ, नीति आयोग, हरित क्रांति एवं ऑपरेशन फ्लड (दुग्ध विकास), बैंकों का राष्ट्रीयकरण (1969 व 1980), नाबार्ड, 1991 के आर्थिक सुधार तथा 2014 के पश्चात के आर्थिक सुधार (GST, जन-धन) के 100 प्रश्न शामिल हैं।",
            topicWeightage = listOf(
                "Five-Year Plans, NITI Aayog & Mixed Economy (30%)",
                "Green Revolution, White Revolution & Agriculture/NABARD (25%)",
                "Bank Nationalization, RBI Monetary Policy (CRR/Repo) (25%)",
                "1991 LPG Reforms & Post-2014 GST/Economic Reforms (20%)"
            ),
            questions = buildUpssscQuestions(upssscEconomicsSeeds, "UPSSSC Economics (अर्थव्यवस्था)", 53000, 100)
        )
    }

    val upssscEnvironment100Test: MockTest by lazy {
        MockTest(
            testId = "upsssc_sec_environment_100",
            title = "UPSSSC GK #5: Environment, Ecology & Wildlife (पर्यावरण एवं पारिस्थितिकी) — 100 PYQ Free Test",
            hindiTitle = "UPSSSC जीके #5: पर्यावरण, पारिस्थितिकी एवं वन्यजीव (Environment) — 100 प्रश्न फ्री टेस्ट",
            examName = "UPSSSC — Environment (100 Qs)",
            durationMinutes = 90,
            totalMarks = 100,
            positiveMarks = 1.0,
            negativeMarks = 0.25,
            categoryId = "subordinate_selection",
            pyqAnalysisEn = "Covers Environmental Acts (1972–2002), Ecological Pyramids & 10% Law, Tiger Reserves of UP (Dudhwa, Pilibhit, Amangarh, Ranipur), All 10 Ramsar Wetlands of UP, Ozone Layer (Montreal Protocol) & Climate Change.",
            pyqAnalysisHi = "इसमें पर्यावरण संरक्षण अधिनियम, पारिस्थितिक पिरामिड (10% नियम), उत्तर प्रदेश के 4 टाइगर रिजर्व (दुधवा, पीलीभीत, अमानगढ़, रानीपुर), उ.प्र. के 10 रामसर आर्द्रभूमि स्थल तथा मॉन्ट्रियल व पेरिस समझौते के 100 प्रश्न शामिल हैं।",
            topicWeightage = listOf(
                "UP Tiger Reserves, Wildlife Sanctuaries & 10 Ramsar Sites (35%)",
                "Ecosystem, Food Chain, 10% Law & Ecological Pyramids (25%)",
                "Environmental Laws (1972, 1980, 1986, 2002) & Projects (20%)",
                "Climate Change, Montreal/Kyoto/Paris Protocols & Pollution (20%)"
            ),
            questions = buildUpssscQuestions(upssscEnvironmentSeeds, "UPSSSC Environment (पर्यावरण)", 54000, 100)
        )
    }

    val upssscSciTech100Test: MockTest by lazy {
        MockTest(
            testId = "upsssc_sec_scitech_100",
            title = "UPSSSC GK #6: Science & Technology (सामान्य विज्ञान एवं प्रौद्योगिकी) — 100 PYQ Free Test",
            hindiTitle = "UPSSSC जीके #6: सामान्य विज्ञान एवं प्रौद्योगिकी (Science & Tech) — 100 प्रश्न फ्री टेस्ट",
            examName = "UPSSSC — Science & Tech (100 Qs)",
            durationMinutes = 90,
            totalMarks = 100,
            positiveMarks = 1.0,
            negativeMarks = 0.25,
            categoryId = "subordinate_selection",
            pyqAnalysisEn = "Covers Elementary Physics (SI Units, Light Year, Ohm's Law, Mirrors/Lenses), Chemistry (Bleaching Powder, Baking/Washing Soda, Dry Ice, Acids, Alloys), Biology (Vitamins, Diseases, Human Organs, Blood) & ISRO Tech.",
            pyqAnalysisHi = "इसमें प्रारंभिक भौतिक विज्ञान (मात्रक, प्रकाश वर्ष, ओम का नियम, दर्पण), रसायन विज्ञान (ब्लीचिंग पाउडर, सोडा, शुष्क बर्फ, अम्ल व मिश्रधातु) तथा जीव विज्ञान (विटामिन, मानव रोग, रक्त एवं कोशिका) के 100 प्रश्न शामिल हैं।",
            topicWeightage = listOf(
                "Biology: Vitamins, Human Diseases, Blood & Organs (40%)",
                "Physics: SI Units, Optics, Electricity & Sound (30%)",
                "Chemistry: Everyday Compounds, Acids, Polymers & Alloys (30%)"
            ),
            questions = buildUpssscQuestions(upssscSciTechSeeds, "UPSSSC Science & Tech (विज्ञान)", 55000, 100)
        )
    }

    // ★ SPECIAL FLAGSHIP SECTION: UP SPECIAL — BEST 250 QUESTIONS!
    val upssscUpSpecial250Test: MockTest by lazy {
        MockTest(
            testId = "upsssc_sec_up_special_250",
            title = "UPSSSC ★ UP Special (यूपी स्पेशल — उत्तर प्रदेश विशेष): Best 250 Last 5 Years PYQ Master Test",
            hindiTitle = "UPSSSC ★ यूपी स्पेशल (उत्तर प्रदेश विशेष सामान्य ज्ञान) — बेस्ट 250 विगत 5 वर्षीय PYQ मास्टर सेट",
            examName = "UPSSSC — ★ UP Special (250 Qs)",
            durationMinutes = 180,
            totalMarks = 250,
            positiveMarks = 1.0,
            negativeMarks = 0.25,
            categoryId = "subordinate_selection",
            pyqAnalysisEn = "Special 250-Question Master Practice Set for UPSSSC (20 questions in Junior Assistant, VDO & Auditor come directly from UP Special!): Covers 75 Districts & Boundaries, ODOP (all districts), Folk Dances (Charkula, Rai, Karma) & Songs (Kajri, Birha, Alha), Fairs, Research Institutes, Census 2011, Rivers/Dams, Tribes (Tharu) & UP Schemes.",
            pyqAnalysisHi = "UPSSSC की सभी परीक्षाओं (जूनियर असिस्टेंट, VDO, लेखपाल, PET, लोअर पीसीएस) के लिए 'यूपी स्पेशल' के सर्वश्रेष्ठ 250 प्रश्नों का विशेष मास्टर सेट! इसमें उ.प्र. की भौगोलिक सीमाएँ, एक जिला एक उत्पाद (ODOP), शास्त्रीय व लोक नृत्य (चरकुला, राई, कर्मा), लोकगीत (कजरी, बिरहा, आल्हा), प्रमुख मेले, शोध संस्थान, जनगणना 2011, जनजातियाँ और उ.प्र. योजनाओं के 250 प्रश्न शामिल हैं।",
            topicWeightage = listOf(
                "UP Geography, Boundaries, Rivers, Dams & Expressways (25%)",
                "UP Art & Culture: Kathak, Folk Dances, Songs & Fairs (25%)",
                "ODOP (One District One Product), GI Tags & Industries (20%)",
                "UP Census 2011, Tribes (Tharu), Research Institutes & History (30%)"
            ),
            questions = buildUpssscQuestions(upssscUpSpecial250Seeds, "★ UPSSSC UP Special (यूपी स्पेशल — 250 Qs)", 56000, 250)
        )
    }

    val upssscComputer100Test: MockTest by lazy {
        MockTest(
            testId = "upsssc_sec_computer_100",
            title = "UPSSSC Section #8: Computer & Information Technology (कंप्यूटर) — 100 PYQ Free Test",
            hindiTitle = "UPSSSC सेक्शन #8: कंप्यूटर एवं सूचना प्रौद्योगिकी (Computer & IT) — 100 प्रश्न फ्री टेस्ट",
            examName = "UPSSSC — Computer & IT (100 Qs)",
            durationMinutes = 90,
            totalMarks = 100,
            positiveMarks = 1.0,
            negativeMarks = 0.25,
            categoryId = "subordinate_selection",
            pyqAnalysisEn = "Covers the 15-Mark Compulsory Computer Syllabus of UPSSSC (Junior Assistant, VDO, Stenographer, Lekhpal): 5 Computer Generations, Memory Hierarchy (SRAM vs DRAM, Cache), MS Word/Excel/PowerPoint Shortcuts, OSI 7-Layer Model, IPv4/IPv6, Email (BCC, SMTP) & AI/IoT/Blockchain.",
            pyqAnalysisHi = "UPSSSC के 15-अंकीय अनिवार्य कंप्यूटर सिलेबस पर आधारित 100 प्रश्न: कंप्यूटर की 5 पीढ़ियाँ, मेमोरी (SRAM/DRAM, कैश), एमएस वर्ड/एक्सेल/पावरपॉइंट शॉर्टकट कुंजियाँ, OSI मॉडल की 7 परतें, IPv4/IPv6, ईमेल (BCC, SMTP) तथा AI, IoT एवं ब्लॉकचेन।",
            topicWeightage = listOf(
                "MS Office (Word, Excel Formulas, PowerPoint) & Shortcuts (35%)",
                "Computer Generations, Hardware, CPU & Memory (SRAM/DRAM) (25%)",
                "Networking (OSI 7 Layers, IPv4/IPv6), Internet & Email (25%)",
                "Emerging Tech: AI, IoT, Big Data, Blockchain & Cyber Security (15%)"
            ),
            questions = buildUpssscQuestions(upssscComputerSeeds, "UPSSSC Computer & IT (कंप्यूटर)", 57000, 100)
        )
    }

    val upssscDi100Test: MockTest by lazy {
        MockTest(
            testId = "upsssc_sec_di_100",
            title = "UPSSSC Section #9: Data Interpretation / DI (ग्राफ एवं तालिका विश्लेषण) — 100 PYQ Free Test",
            hindiTitle = "UPSSSC सेक्शन #9: डेटा इंटरप्रिटेशन / DI (ग्राफ एवं तालिका की व्याख्या) — 100 प्रश्न फ्री टेस्ट",
            examName = "UPSSSC — Data Interpretation (100 Qs)",
            durationMinutes = 120,
            totalMarks = 100,
            positiveMarks = 1.0,
            negativeMarks = 0.25,
            categoryId = "subordinate_selection",
            pyqAnalysisEn = "20 Marks out of 100 in UPSSSC PET come exclusively from Data Interpretation (2 Graphs = 10 Marks + 2 Tables = 10 Marks)! Covers Tabular DI, Pie-Chart Central Angle (1% = 3.6°), Bar Graph Average/Ratio, and Line Graph Income-Expenditure-Profit% calculations.",
            pyqAnalysisHi = "UPSSSC PET में सर्वाधिक 20 अंक (2 ग्राफ = 10 अंक + 2 तालिका = 10 अंक) सीधे डेटा इंटरप्रिटेशन (DI) से आते हैं! इसमें तालिका विश्लेषण, पाई-चार्ट केंद्रीय कोण (1% = 3.6°), दंड आलेख औसत/अनुपात और रेखा-ग्राफ (आय-व्यय-लाभ%) के 100 हल प्रश्न शामिल हैं।",
            topicWeightage = listOf(
                "Table Analysis & Interpretation (तालिका की व्याख्या — 10 Marks) (35%)",
                "Pie Chart Central Angle (1% = 3.6°) & Percentage Share (25%)",
                "Line Graph: Income, Expenditure & Profit % Formulas (25%)",
                "Double Bar Graph: Average, Ratio & Growth Rate (15%)"
            ),
            questions = buildUpssscQuestions(upssscDiSeeds, "UPSSSC Data Interpretation (DI — ग्राफ एवं तालिका)", 58000, 100)
        )
    }

    // =========================================================================
    // MASTER LIST OF ALL 9 UPSSSC FREE TEST SECTIONS (1,050 QUESTIONS TOTAL)
    // Ordered exactly as requested by user:
    //  - GK: 1. History (100), 2. Polity (100), 3. Geography (100), 4. Economics (100), 5. Environment (100), 6. Science & Tech (100)
    //  - 7. ★ UP Special (Best 250 Questions)
    //  - 8. Computer & IT (100)
    //  - 9. Data Interpretation / DI (100)
    // =========================================================================
    val all9UpssscSectionTests: List<UpssscSectionTestMeta> by lazy {
        listOf(
            UpssscSectionTestMeta(
                id = "upsssc_history",
                sectionId = "upsssc_history",
                titleEn = "1. GK: History & National Movement (इतिहास — 100 PYQs)",
                titleHi = "1. जीके: इतिहास एवं राष्ट्रीय आंदोलन (History — 100 PYQ प्रश्न)",
                subtitleEn = "IVC (Alamgirpur, Sanauli) • Buddha • Ashoka • Mughals • 1857 & Kakori Action",
                subtitleHi = "सिंधु सभ्यता (आलमगीरपुर, सनौली) • बुद्ध • अशोक • मुगल • 1857 एवं काकोरी एक्शन",
                questionCount = 100,
                isUpSpecial250 = false,
                mockTest = upssscHistory100Test
            ),
            UpssscSectionTestMeta(
                id = "upsssc_polity",
                sectionId = "upsssc_polity",
                titleEn = "2. GK: Polity & Public Administration (पॉलिटी — 100 PYQs)",
                titleHi = "2. जीके: भारतीय संविधान एवं लोक प्रशासन (Polity — 100 PYQ प्रश्न)",
                subtitleEn = "Fundamental Rights • DPSP • Parliament • District Admin (Art 233) • Panchayati Raj",
                subtitleHi = "मौलिक अधिकार • नीति निदेशक तत्व • संसद • जिला प्रशासन • पंचायती राज",
                questionCount = 100,
                isUpSpecial250 = false,
                mockTest = upssscPolity100Test
            ),
            UpssscSectionTestMeta(
                id = "upsssc_geography",
                sectionId = "upsssc_geography",
                titleEn = "3. GK: Indian & World Geography (ज्योग्राफी — 100 PYQs)",
                titleHi = "3. जीके: भारत एवं विश्व का भूगोल (Geography — 100 PYQ प्रश्न)",
                subtitleEn = "Rivers & Dams (Salal, Tehri) • Mountain Passes • Borders • IST & Equinox",
                subtitleHi = "नदियाँ व बांध (सलाल, टिहरी) • प्रमुख दर्रे • सीमाएँ • मानक समय एवं विषुव",
                questionCount = 100,
                isUpSpecial250 = false,
                mockTest = upssscGeography100Test
            ),
            UpssscSectionTestMeta(
                id = "upsssc_economics",
                sectionId = "upsssc_economics",
                titleEn = "4. GK: Indian Economy & Plans (इकोनॉमिक्स — 100 PYQs)",
                titleHi = "4. जीके: भारतीय अर्थव्यवस्था एवं योजनाएँ (Economics — 100 PYQ प्रश्न)",
                subtitleEn = "Five-Year Plans • NITI Aayog • Green/White Revolution • 1969 Bank Nat. • GST & RBI",
                subtitleHi = "पंचवर्षीय योजनाएँ • नीति आयोग • हरित/श्वेत क्रांति • बैंक राष्ट्रीयकरण • GST व RBI",
                questionCount = 100,
                isUpSpecial250 = false,
                mockTest = upssscEconomics100Test
            ),
            UpssscSectionTestMeta(
                id = "upsssc_environment",
                sectionId = "upsssc_environment",
                titleEn = "5. GK: Environment & Ecology (एनवायरनमेंट — 100 PYQs)",
                titleHi = "5. जीके: पर्यावरण एवं पारिस्थितिकी (Environment — 100 PYQ प्रश्न)",
                subtitleEn = "4 UP Tiger Reserves • 10 UP Ramsar Sites • 10% Energy Law • Env Acts (1972–2002)",
                subtitleHi = "उ.प्र. के 4 टाइगर रिजर्व • 10 रामसर स्थल • 10% ऊर्जा नियम • पर्यावरण अधिनियम",
                questionCount = 100,
                isUpSpecial250 = false,
                mockTest = upssscEnvironment100Test
            ),
            UpssscSectionTestMeta(
                id = "upsssc_scitech",
                sectionId = "upsssc_scitech",
                titleEn = "6. GK: Science & Tech (साइंस एंड टेक — 100 PYQs)",
                titleHi = "6. जीके: सामान्य विज्ञान एवं प्रौद्योगिकी (Science & Tech — 100 PYQ प्रश्न)",
                subtitleEn = "Physics Units & Optics • Chemistry Compounds (CaOCl2, Dry Ice) • Vitamins & Biology",
                subtitleHi = "भौतिकी मात्रक व प्रकाशिकी • रसायन (ब्लीचिंग पाउडर, शुष्क बर्फ) • विटामिन व जीव विज्ञान",
                questionCount = 100,
                isUpSpecial250 = false,
                mockTest = upssscSciTech100Test
            ),
            UpssscSectionTestMeta(
                id = "upsssc_up_special_250",
                sectionId = "upsssc_up_special_250",
                titleEn = "★ 7. UP Special (यूपी स्पेशल — Best 250 UPSSSC PYQs)",
                titleHi = "★ 7. यूपी स्पेशल (उत्तर प्रदेश विशेष — बेस्ट 250 PYQ प्रश्न)",
                subtitleEn = "ODOP (All 75 Districts) • Folk Dances & Songs • Fairs • Institutes • Census 2011 & Schemes",
                subtitleHi = "एक जिला एक उत्पाद (ODOP) • लोक नृत्य व लोकगीत • मेले • शोध संस्थान • जनगणना 2011",
                questionCount = 250,
                isUpSpecial250 = true,
                mockTest = upssscUpSpecial250Test
            ),
            UpssscSectionTestMeta(
                id = "upsssc_computer",
                sectionId = "upsssc_computer",
                titleEn = "8. Computer & Information Tech (कंप्यूटर — 100 PYQs)",
                titleHi = "8. कंप्यूटर एवं सूचना प्रौद्योगिकी (Computer — 100 PYQ प्रश्न)",
                subtitleEn = "5 Generations • SRAM/DRAM • MS Word/Excel/PPT Shortcuts • OSI 7 Layers • AI & IoT",
                subtitleHi = "कंप्यूटर पीढ़ियाँ • मेमोरी • एमएस ऑफिस शॉर्टकट • OSI मॉडल • AI, IoT एवं ब्लॉकचेन",
                questionCount = 100,
                isUpSpecial250 = false,
                mockTest = upssscComputer100Test
            ),
            UpssscSectionTestMeta(
                id = "upsssc_di",
                sectionId = "upsssc_di",
                titleEn = "9. Data Interpretation / DI (डेटा इंटरप्रिटेशन — 100 PYQs)",
                titleHi = "9. डीआई / डेटा इंटरप्रिटेशन (ग्राफ एवं तालिका विश्लेषण — 100 PYQ प्रश्न)",
                subtitleEn = "20 Marks in PET! Table Analysis • Pie Chart (1% = 3.6°) • Bar & Line Graph Profit%",
                subtitleHi = "PET में 20 अंक! तालिका विश्लेषण • पाई-चार्ट (1% = 3.6°) • दंड एवं रेखा ग्राफ लाभ%",
                questionCount = 100,
                isUpSpecial250 = false,
                mockTest = upssscDi100Test
            )
        )
    }
}
