package com.example.data.ssc

import com.example.model.MockTest

data class RawSscPyqSeed(
    val qEn: String,
    val qHi: String,
    val optsEn: List<String>,
    val optsHi: List<String>,
    val expEn: String,
    val expHi: String,
    val yearTag: String
)

data class SscSectionTestMeta(
    val id: String,
    val sectionId: String,
    val categoryGroupEn: String,
    val categoryGroupHi: String,
    val titleEn: String,
    val titleHi: String,
    val subtitleEn: String,
    val subtitleHi: String,
    val questionCount: Int,
    val isGsSection: Boolean = true,
    val mockTest: MockTest
)

/**
 * SSC CGL / CHSL / CPO — Last 5 Years (2020–2025) TCS Pattern PYQ Seeds (Part 1: GS History, Polity & Geography).
 */
object SscGsSeedsData1 {

    // =========================================================================
    // 1. GS — HISTORY (इतिहास एवं कला-संस्कृति — 100 QUESTIONS)
    // Covers Indus Valley, Vedic, Buddhism/Jainism, Maurya, Gupta, Chola,
    // Delhi Sultanate, Mughal, 1857 Revolt, INC Sessions, Viceroys & Classical Dances
    // =========================================================================
    val historySeeds = listOf(
        RawSscPyqSeed(
            "Which Indus Valley Civilization site in Gujarat is famous for its 'Three-Part City Division' (Citadel, Middle Town, Lower Town), a giant water reservoir system, and was inscribed as India's 40th UNESCO World Heritage Site?",
            "गुजरात में स्थित सिंधु घाटी सभ्यता का कौन-सा स्थल अपने 'तीन-स्तरीय नगर विभाजन' (दुर्ग, मध्य नगर, निचला नगर), विशाल जल जलाशय प्रणाली के लिए प्रसिद्ध है और भारत के 40वें यूनेस्को विश्व धरोहर स्थल के रूप में सूचीबद्ध है?",
            listOf(
                "Dholavira (Rann of Kutch, Gujarat)",
                "Lothal (Bhogava River, Gujarat)",
                "Kalibangan (Ghaggar River, Rajasthan)",
                "Surkotada (Kutch, Gujarat)"
            ),
            listOf(
                "धोलावीरा (कच्छ का रण, गुजरात)",
                "लोथल (भोगवा नदी, गुजरात)",
                "कालीबंगा (घग्गर नदी, राजस्थान)",
                "सुरकोटदा (कच्छ, गुजरात)"
            ),
            "Dholavira (discovered by J.P. Joshi in 1968 in Kutch district, Gujarat) is the only Harappan city divided into three parts (Citadel, Middle Town, Lower Town). It is renowned for its rock-cut water reservoirs and signboard with 10 large Indus script letters.",
            "धोलावीरा (1968 में जे.पी. जोशी द्वारा खोजा गया, कच्छ, गुजरात) एकमात्र हड़प्पाकालीन नगर है जो तीन भागों (दुर्ग, मध्य नगर और निचला नगर) में विभाजित था। यह अपनी उन्नत जल प्रबंधन प्रणाली और 10 बड़े सिंधु लिपि अक्षरों वाले साइनबोर्ड के लिए प्रसिद्ध है।",
            "SSC CGL Tier-I 2022, 2023 & CHSL 2024 PYQ"
        ),
        RawSscPyqSeed(
            "Match the Four Buddhist Councils with their Royal Patrons and Locations (Frequently asked in SSC CGL, CHSL & CPO TCS shifts):\n1. First Buddhist Council (483 BC) — Rajagriha (Patron: Ajatashatru)\n2. Second Buddhist Council (383 BC) — Vaishali (Patron: Kalashoka)\n3. Third Buddhist Council (250 BC) — Pataliputra (Patron: Emperor Ashoka)\n4. Fourth Buddhist Council (72 AD) — Kundalvana, Kashmir (Patron: Kanishka)\nWhich of the above pairs are correctly matched?",
            "चार बौद्ध संगीतियों का उनके संरक्षक शासकों एवं स्थानों (SSC CGL, CHSL एवं CPO में बार-बार पूछा गया प्रश्न) के साथ मिलान कीजिए:\n1. प्रथम बौद्ध संगीति (483 ई.पू.) — राजगृह (संरक्षक: अजातशत्रु)\n2. द्वितीय बौद्ध संगीति (383 ई.पू.) — वैशाली (संरक्षक: कालाशोक)\n3. तृतीय बौद्ध संगीति (250 ई.पू.) — पाटलिपुत्र (संरक्षक: सम्राट अशोक)\n4. चतुर्थ बौद्ध संगीति (72 ई.) — कुंडलवन, कश्मीर (संरक्षक: कनिष्क)\nउपर्युक्त में से कौन-से युग्म सही सुमेलित हैं?",
            listOf(
                "All 1, 2, 3 and 4",
                "1, 2 and 3 only",
                "1, 3 and 4 only",
                "2 and 4 only"
            ),
            listOf(
                "सभी 1, 2, 3 और 4",
                "केवल 1, 2 और 3",
                "केवल 1, 3 और 4",
                "केवल 2 और 4"
            ),
            "All four Buddhist Councils are correctly matched. Chairs of the 4 Councils: 1st = Mahakassapa; 2nd = Sabakami; 3rd = Moggaliputta Tissa (compiled Abhidhamma Pitaka); 4th = Vasumitra (Vice-Chair: Ashvaghosha; Buddhism split into Hinayana and Mahayana).",
            "चारों बौद्ध संगीतियाँ सही सुमेलित हैं। इनके अध्यक्ष क्रमशः थे: प्रथम = महाकश्यप; द्वितीय = सबाकामी; तृतीय = मोग्गलिपुत्त तिस्स (अभिधम्म पिटक का संकलन); चतुर्थ = वसुमित्र (उपाध्यक्ष: अश्वघोष; बौद्ध धर्म हीनयान और महायान में विभाजित हुआ)।",
            "SSC CGL 2021, 2023 & CPO 2023 PYQ"
        ),
        RawSscPyqSeed(
            "In which Major Rock Edict did Mauryan Emperor Ashoka express deep remorse over the massive bloodshed of the 'Kalinga War' (261 BC) and announce his shift from 'Bherighosha' (war conquest) to 'Dhammaghosha' (conquest by Dharma)?",
            "मौर्य सम्राट अशोक के किस वृहद शिलालेख (Major Rock Edict) में 'कलिंग युद्ध' (261 ई.पू.) के भीषण रक्तपात पर गहरे शोक का वर्णन है तथा 'भेरीघोष' के स्थान पर 'धम्मघोष' अपनाने की घोषणा की गई है?",
            listOf(
                "Major Rock Edict XIII (13th Rock Edict)",
                "Major Rock Edict XII (12th Rock Edict)",
                "Major Rock Edict IV (4th Rock Edict)",
                "Minor Rock Edict I (Maski & Gujarra)"
            ),
            listOf(
                "तेरहवाँ वृहद शिलालेख (Major Rock Edict XIII)",
                "बारहवाँ वृहद शिलालेख (Major Rock Edict XII)",
                "चौथा वृहद शिलालेख (Major Rock Edict IV)",
                "लघु शिलालेख I (मास्की एवं गुर्जरा)"
            ),
            "Major Rock Edict XIII (13th Rock Edict) details the Kalinga War (fought in the 8th year of Ashoka's coronation, 261 BC) and also mentions five contemporary Greek (Yona) kings. James Prinsep deciphered Ashoka's Brahmi inscriptions in 1837.",
            "13वें वृहद शिलालेख (Rock Edict XIII) में अशोक के राज्याभिषेक के 8वें वर्ष (261 ई.पू.) में लड़े गए कलिंग युद्ध के भीषण नरसंहार और अशोक के हृदय परिवर्तन का वर्णन है। 1837 में जेम्स प्रिंसेप ने सर्वप्रथम अशोक के ब्राह्मी शिलालेखों को पढ़ा था।",
            "SSC CGL 2020, 2022, 2024 & CHSL 2023 PYQ"
        ),
        RawSscPyqSeed(
            "Who composed the 'Prayag Prashasti' (Allahabad Pillar Inscription) in chaste Sanskrit (Champu Kavya style) chronicling the military conquests of Gupta Emperor Samudragupta ('Napoleon of India')?",
            "गुप्त सम्राट समुद्रगुप्त ('भारत का नेपोलियन') की सैन्य विजयों का वर्णन करने वाली 'प्रयाग प्रशस्ति' (इलाहाबाद स्तंभ अभिलेख) की रचना संस्कृत की चम्पू शैली में किसने की थी?",
            listOf(
                "Harishena (Court Poet & Mahasandhivigrahika of Samudragupta)",
                "Ravikirti (Court Poet of Pulakeshin II)",
                "Banabhatta (Court Poet of Harshavardhana)",
                "Kalidasa (Navratna of Chandragupta II Vikramaditya)"
            ),
            listOf(
                "हरिषेण (समुद्रगुप्त के दरबारी कवि एवं महासंधिविग्रहिक)",
                "रविकीर्ति (पुलकेशिन द्वितीय के दरबारी कवि)",
                "बाणभट्ट (हर्षवर्धन के दरबारी कवि)",
                "कालिदास (चंद्रगुप्त द्वितीय विक्रमादित्य के नवरत्न)"
            ),
            "Harishena composed the 33-line Prayag Prashasti on the Ashokan pillar at Kaushambi/Prayagraj. Note for SSC TCS: Ravikirti composed the 'Aihole Inscription' of Chalukya king Pulakeshin II (who defeated Harshavardhana on the Narmada bank in 618 AD).",
            "समुद्रगुप्त के दरबारी कवि और संधिविग्रहिक 'हरिषेण' ने प्रयाग प्रशस्ति की रचना की थी। इतिहासकार विन्सेंट स्मिथ ने समुद्रगुप्त को 'भारत का नेपोलियन' कहा। 'ऐहोल अभिलेख' की रचना पुलकेशिन द्वितीय के दरबारी कवि रविकीर्ति ने की थी।",
            "SSC CGL Tier-I & II 2022, 2023, 2024 PYQ"
        ),
        RawSscPyqSeed(
            "Which Chola Emperor built the magnificent 'Brihadisvara Temple' (Rajarajesvaram) at Thanjavur — a masterpiece of Dravidian temple architecture and UNESCO World Heritage Site?",
            "किस चोल सम्राट ने तंजावुर (तंजौर) में द्रविड़ मंदिर वास्तुकला के उत्कृष्ट नमूने और यूनेस्को विश्व धरोहर स्थल 'बृहदेश्वर मंदिर' (राजराजेश्वरम) का निर्माण कराया था?",
            listOf(
                "Rajaraja Chola I (c. 1010 AD)",
                "Rajendra Chola I (Gangaikonda Cholapuram)",
                "Vijayalaya Chola (Founder of Imperial Cholas)",
                "Kulottunga Chola I"
            ),
            listOf(
                "राजराज चोल प्रथम (लगभग 1010 ई.)",
                "राजेंद्र चोल प्रथम (गंगईकोंड चोलपुरम)",
                "विजयालय चोल (चोल साम्राज्य के संस्थापक)",
                "कुलोत्तुंग चोल प्रथम"
            ),
            "Rajaraja Chola I (985–1014 AD) built the Brihadisvara Temple dedicated to Lord Shiva at Thanjavur. His son Rajendra Chola I defeated Mahipala of Bengal, assumed the title 'Gangaikonda Chola', and built a new capital at Gangaikonda Cholapuram.",
            "राजराज चोल प्रथम (985–1014 ई.) ने तंजावुर में भगवान शिव को समर्पित बृहदेश्वर मंदिर का निर्माण कराया था। उनके पुत्र राजेंद्र चोल प्रथम ने बंगाल के शासक महिपाल को पराजित कर 'गंगईकोंड चोल' की उपाधि धारण की और 'गंगईकोंड चोलपुरम' नगर बसाया।",
            "SSC CGL 2022, CHSL 2023 & CPO 2024 PYQ"
        ),
        RawSscPyqSeed(
            "Arrange the Five Dynasties of the Delhi Sultanate (1206–1526 AD) in their exact chronological order and match their founders:\n1. Mamluk / Slave Dynasty (1206–1290) — Qutbuddin Aibak\n2. Khalji Dynasty (1290–1320) — Jalaluddin Firuz Khalji\n3. Tughlaq Dynasty (1320–1414) — Ghiyasuddin Tughlaq\n4. Sayyid Dynasty (1414–1451) — Khizr Khan\n5. Lodi Dynasty (1451–1526) — Bahlul Lodi\nWhich of the statements given above are correct?",
            "दिल्ली सल्तनत के पाँच राजवंशों (1206–1526 ई.) के सही कालक्रम और उनके संस्थापकों का मिलान देखिए:\n1. गुलाम / मामलूक वंश (1206–1290) — कुतुबुद्दीन ऐबक\n2. खिलजी वंश (1290–1320) — जलालुद्दीन फिरोज खिलजी\n3. तुगलक वंश (1320–1414) — गियासुद्दीन तुगलक\n4. सैय्यद वंश (1414–1451) — खिज्र खां\n5. लोदी वंश (1451–1526) — बहलोल लोदी\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf(
                "All 1, 2, 3, 4 and 5",
                "1, 2, 3 and 4 only",
                "1, 3 and 5 only",
                "2, 3 and 5 only"
            ),
            listOf(
                "सभी 1, 2, 3, 4 और 5",
                "केवल 1, 2, 3 और 4",
                "केवल 1, 3 और 5",
                "केवल 2, 3 और 5"
            ),
            "All 5 dynasties and their founders are in exact chronological order. Also asked in SSC: Tughlaq Dynasty ruled for the longest duration (94 years), while Khalji Dynasty ruled for the shortest duration (30 years). Sikandar Lodi founded Agra in 1504.",
            "पाँचों राजवंश और उनके संस्थापक सही कालक्रम में हैं। SSC हेतु विशेष तथ्य: दिल्ली सल्तनत पर सर्वाधिक लंबे समय तक 'तुगलक वंश' (94 वर्ष) ने और सबसे कम समय तक 'खिलजी वंश' (30 वर्ष) ने शासन किया। सिकंदर लोदी ने 1504 ई. में आगरा की स्थापना की थी।",
            "SSC CGL 2021, 2023 & CHSL 2022, 2024 PYQ"
        ),
        RawSscPyqSeed(
            "Which Delhi Sultan introduced the 'Market Control & Price Regulation Policy' (Diwan-i-Riyasat), 'Dagh' (branding of horses), and 'Chehra/Huliya' (descriptive roll of soldiers)?",
            "दिल्ली के किस सुल्तान ने 'बाजार नियंत्रण एवं मूल्य निर्धारण प्रणाली' (दीवान-ए-रियासत), घोड़े दागने की प्रथा ('दाग') तथा सैनिकों का हुलिया लिखने की प्रथा ('चेहरा') शुरू की थी?",
            listOf(
                "Alauddin Khalji (1296–1316 AD)",
                "Iltutmish (Turkan-i-Chahalgani & Iqta System)",
                "Ghiyasuddin Balban (Sijda, Paibos & Blood and Iron Policy)",
                "Muhammad bin Tughlaq (Token Currency & Diwan-i-Kohi)"
            ),
            listOf(
                "अलाउद्दीन खिलजी (1296–1316 ई.)",
                "इल्तुतमिश (तुर्कान-ए-चिहलगानी एवं इक्ता प्रणाली)",
                "गियासुद्दीन बलबन (सिजदा, पाइबोस एवं रक्त और लौह नीति)",
                "मुहम्मद बिन तुगलक (सांकेतिक मुद्रा एवं दीवान-ए-कोही)"
            ),
            "Alauddin Khalji maintained a huge standing army paid in cash, introduced Dagh and Chehra, and established four regulated markets in Delhi under the 'Shahna-i-Mandi' and 'Diwan-i-Riyasat'. He also built the Alai Darwaza and Siri Fort.",
            "अलाउद्दीन खिलजी ने सैनिकों को नकद वेतन देने, घोड़े दागने ('दाग') और हुलिया ('चेहरा') रखने की प्रथा शुरू की तथा मूल्य नियंत्रण हेतु 'शहना-ए-मंडी' और 'दीवान-ए-रियासत' की स्थापना की। उसने अलाई दरवाजा और सीरी के किले का निर्माण भी कराया।",
            "SSC CPO 2022, CGL 2023 & CHSL 2024 PYQ"
        ),
        RawSscPyqSeed(
            "With reference to the Vijayanagara Empire (Founded in 1336 AD by Harihara I and Bukka I on the banks of the Tungabhadra River), which ruler belonged to the 'Tuluva Dynasty', authored 'Amuktamalyada' in Telugu, and had the 'Ashtadiggajas' in his court?",
            "विजयनगर साम्राज्य (1336 ई. में तुंगभद्रा नदी के तट पर हरिहर प्रथम और बुक्का प्रथम द्वारा स्थापित) के किस महान शासक का संबंध 'तुलुव वंश' से था, जिसने तेलुगु में 'आमुक्तमाल्यद' की रचना की और जिसके दरबार में 'अष्टदिग्गज' रहते थे?",
            listOf(
                "Krishnadevaraya (1509–1529 AD)",
                "Deva Raya II (Sangama Dynasty)",
                "Rama Raya (Battle of Talikota 1565)",
                "Narasimha Deva Raya (Saluva Dynasty)"
            ),
            listOf(
                "कृष्णदेवराय (1509–1529 ई.)",
                "देवराय द्वितीय (संगम वंश)",
                "रामराय (तालीकोटा का युद्ध 1565)",
                "नरसिंह देवराय (सालुव वंश)"
            ),
            "Krishnadevaraya (Tuluva Dynasty) was the greatest ruler of Vijayanagara. He authored 'Amuktamalyada' (Telugu) and 'Jambavati Kalyanam' (Sanskrit), built the Hazara Rama and Vitthalswami temples, and was praised by Babur in Baburnama. The 4 Vijayanagara dynasties in order: Sangama -> Saluva -> Tuluva -> Aravidu.",
            "तुलुव वंश के 'कृष्णदेवराय' (1509–1529 ई.) विजयनगर के महानतम शासक थे। उन्होंने तेलुगु में 'आमुक्तमाल्यद' और संस्कृत में 'जाम्बवती कल्याणम' की रचना की तथा उनके दरबार में तेलुगु के आठ महान कवि ('अष्टदिग्गज') रहते थे। विजयनगर के 4 वंशों का क्रम: संगम -> सालुव -> तुलुव -> अराविडु।",
            "SSC CGL 2021, 2022, 2023 & 2024 PYQ"
        ),
        RawSscPyqSeed(
            "Match the decisive Battles of Mughal Emperor Babur and Humayun with their exact years and opponents (High-frequency SSC CGL/CHSL question):\n1. First Battle of Panipat (21 April 1526) — Babur defeated Ibrahim Lodi\n2. Battle of Khanwa (1527) — Babur defeated Rana Sanga of Mewar\n3. Battle of Chausa (1539) & Battle of Kannauj/Bilgram (1540) — Sher Shah Suri defeated Humayun\n4. Second Battle of Panipat (5 November 1556) — Akbar (Bairam Khan) defeated Hemu (Vikramaditya)\nWhich of the above are correctly matched?",
            "मुगल सम्राट बाबर, हुमायूँ और अकबर के निर्णायक युद्धों एवं उनके वर्षों का मिलान कीजिए:\n1. पानीपत का प्रथम युद्ध (21 अप्रैल 1526) — बाबर ने इब्राहिम लोदी को हराया\n2. खानवा का युद्ध (1527) — बाबर ने मेवाड़ के राणा सांगा को हराया\n3. चौसा का युद्ध (1539) एवं कन्नौज/बिलग्राम का युद्ध (1540) — शेरशाह सूरी ने हुमायूँ को हराया\n4. पानीपत का द्वितीय युद्ध (5 नवंबर 1556) — अकबर (बैरम खां) ने हेमू (विक्रमादित्य) को हराया\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf(
                "All 1, 2, 3 and 4",
                "1, 2 and 3 only",
                "1 and 4 only",
                "2, 3 and 4 only"
            ),
            listOf(
                "सभी 1, 2, 3 और 4",
                "केवल 1, 2 और 3",
                "केवल 1 और 4",
                "केवल 2, 3 और 4"
            ),
            "All 4 battle chronologies are 100% accurate. Also remember Babur's 4 wars in sequence: 1526 Panipat (Ibrahim Lodi) -> 1527 Khanwa (Rana Sanga) -> 1528 Chanderi (Medini Rai) -> 1529 Ghaghra (Afghans under Mahmud Lodi).",
            "चारों युद्ध और उनके वर्ष पूर्णतः सही हैं। बाबर के चार प्रमुख युद्धों का क्रम: 1526 पानीपत -> 1527 खानवा -> 1528 चंदेरी (मेदिनी राय) -> 1529 घाघरा का युद्ध (अफगानों के विरुद्ध)।",
            "SSC CGL 2022, CHSL 2023 & CPO 2023 PYQ"
        ),
        RawSscPyqSeed(
            "Who introduced the 'Mansabdari System' (dual ranks of 'Zat' and 'Sawar') in the Mughal military administration and the 'Dahsala (Zabti) Land Revenue System' (1580, designed by Raja Todar Mal)?",
            "मुगल सैन्य प्रशासन में 'मनसबदारी प्रणाली' ('जात' और 'सवार' के दोहरे पद) तथा राजा टोडरमल द्वारा निर्मित 'दहसाला (जब्ती) भू-राजस्व प्रणाली' (1580 ई.) किसने लागू की थी?",
            listOf(
                "Emperor Akbar (1556–1605 AD)",
                "Sher Shah Suri (Rupiya & Grand Trunk Road)",
                "Shah Jahan (Golden Age of Mughal Architecture)",
                "Aurangzeb (Alamgir)"
            ),
            listOf(
                "सम्राट अकबर (1556–1605 ई.)",
                "शेरशाह सूरी (रुपया एवं ग्रैंड ट्रंक रोड)",
                "शाहजहाँ (मुगल स्थापत्य का स्वर्ण काल)",
                "औरंगजेब (आलमगीर)"
            ),
            "Emperor Akbar introduced the Mansabdari system (borrowed from the Mongol system) where 'Zat' indicated personal status/salary and 'Sawar' indicated the number of cavalrymen maintained. Raja Todar Mal, Akbar's finance minister (Diwan-i-Ashraf), implemented the Ain-i-Dahsala land revenue system in 1580.",
            "सम्राट अकबर ने मुगल प्रशासन में 'मनसबदारी प्रथा' लागू की जिसमें 'जात' व्यक्ति के वेतन व पद तथा 'सवार' उसके द्वारा रखे जाने वाले घुड़सवारों की संख्या दर्शाता था। अकबर के वित्त मंत्री राजा टोडरमल ने 1580 ई. में 'आईन-ए-दहसाला' (जब्ती) बंदोबस्त लागू किया।",
            "SSC CGL Tier-I 2021, 2023 & CPO 2024 PYQ"
        ),
        RawSscPyqSeed(
            "Match the Prominent Centers of the Revolt of 1857 with their Indian Leaders (Repeated across 15+ SSC shifts):\n1. Delhi — Bahadur Shah Zafar II & General Bakht Khan\n2. Kanpur — Nana Saheb (Dhondu Pant) & Tantia Tope\n3. Lucknow (Awadh) — Begum Hazrat Mahal\n4. Arrah / Jagdishpur (Bihar) — Babu Kunwar Singh\n5. Jhansi & Gwalior — Rani Lakshmibai\nWhich of the above pairs are correctly matched?",
            "1857 की क्रांति के प्रमुख केंद्रों और उनके भारतीय नेतृत्वकर्ताओं का मिलान देखिए:\n1. दिल्ली — बहादुर शाह जफर द्वितीय एवं जनरल बख्त खां\n2. कानपुर — नाना साहेब (धोंडू पंत) एवं तात्या टोपे\n3. लखनऊ (अवध) — बेगम हजरत महल\n4. आरा / जगदीशपुर (बिहार) — बाबू कुंवर सिंह\n5. झांसी एवं ग्वालियर — रानी लक्ष्मीबाई\nउपर्युक्त में से कौन-से युग्म सही सुमेलित हैं?",
            listOf(
                "All 1, 2, 3, 4 and 5",
                "1, 2, 3 and 5 only",
                "1, 3 and 4 only",
                "2, 4 and 5 only"
            ),
            listOf(
                "सभी 1, 2, 3, 4 और 5",
                "केवल 1, 2, 3 और 5",
                "केवल 1, 3 और 4",
                "केवल 2, 4 और 5"
            ),
            "All five pairs are correctly matched. Also remember: Faizabad = Maulvi Ahmadullah; Bareilly = Khan Bahadur Khan; Allahabad = Liaquat Ali. Lord Canning was the Governor-General of India during the 1857 Revolt and became the First Viceroy under the Government of India Act 1858.",
            "पाँचों युग्म सही सुमेलित हैं। अन्य प्रमुख केंद्र: फैजाबाद = मौलवी अहमदुल्लाह; बरेली = खान बहादुर खां; इलाहाबाद = लियाकत अली। 1857 के विद्रोह के समय भारत के गवर्नर-जनरल लॉर्ड कैनिंग थे, जो 1858 के अधिनियम के तहत भारत के प्रथम वायसराय बने।",
            "SSC CGL 2020, 2022, 2023 & CHSL 2024 PYQ"
        ),
        RawSscPyqSeed(
            "Match the 19th-Century Socio-Religious Reform Organizations with their Founders and Years (SSC TCS Favorite Static History Topic):\n1. Brahmo Samaj (1828, Calcutta) — Raja Ram Mohan Roy\n2. Satyashodhak Samaj (1873, Maharashtra, author of 'Gulamgiri') — Jyotirao Phule\n3. Arya Samaj (1875, Bombay, author of 'Satyarth Prakash') — Swami Dayanand Saraswati\n4. Ramakrishna Mission (1897, Belur Math) — Swami Vivekananda\nWhich of the above are correctly matched?",
            "19वीं सदी के प्रमुख सामाजिक-धार्मिक सुधार संगठनों और उनके संस्थापकों का मिलान देखिए:\n1. ब्रह्म समाज (1828, कलकत्ता) — राजा राममोहन राय\n2. सत्यशोधक समाज (1873, महाराष्ट्र, 'गुलामगिरी' के लेखक) — ज्योतिराव फुले\n3. आर्य समाज (1875, बंबई, 'सत्यार्थ प्रकाश' के लेखक) — स्वामी दयानंद सरस्वती\n4. रामकृष्ण मिशन (1897, बेलूर मठ) — स्वामी विवेकानंद\nउपर्युक्त में से कौन-से सही सुमेलित हैं?",
            listOf(
                "All 1, 2, 3 and 4",
                "1, 2 and 3 only",
                "1, 3 and 4 only",
                "2 and 4 only"
            ),
            listOf(
                "सभी 1, 2, 3 और 4",
                "केवल 1, 2 और 3",
                "केवल 1, 3 और 4",
                "केवल 2 और 4"
            ),
            "All 4 organizations are correctly matched! Also asked in SSC: 'Prarthana Samaj' (1867, Bombay) was founded by Atmaram Pandurang (with M.G. Ranade); 'Servants of India Society' (1905, Pune) was founded by Gopal Krishna Gokhale.",
            "चारों संगठन सही सुमेलित हैं! SSC में पूछे जाने वाले अन्य प्रमुख संगठन: 'प्रार्थना समाज' (1867, बंबई) = आत्माराम पांडुरंग (एम.जी. रानाडे के सहयोग से); 'सर्वेंट्स ऑफ इंडिया सोसाइटी' (1905, पुणे) = गोपाल कृष्ण गोखले।",
            "SSC CGL 2021, 2022, 2023, 2024 (Asked in 20+ Shifts)"
        ),
        RawSscPyqSeed(
            "With reference to landmark Sessions of the Indian National Congress (INC, founded in December 1885 by A.O. Hume), consider the following pairs:\n1. First Session (Bombay, 1885) — Presided over by W.C. Bonnerjee (72 delegates)\n2. Surat Session (1907, Split into Moderates & Extremists) — Presided over by Rash Behari Ghosh\n3. Belgaum Session (1924, ONLY session presided over by Mahatma Gandhi)\n4. Lahore Session (December 1929, 'Purna Swaraj' Resolution) — Presided over by Jawaharlal Nehru\nWhich of the pairs given above are correct?",
            "भारतीय राष्ट्रीय कांग्रेस (INC, दिसंबर 1885 में ए.ओ. ह्यूम द्वारा स्थापित) के ऐतिहासिक अधिवेशनों के संदर्भ में विचार कीजिए:\n1. प्रथम अधिवेशन (बंबई, 1885) — अध्यक्ष: व्योमेश चंद्र बनर्जी (72 प्रतिनिधि)\n2. सूरत अधिवेशन (1907, नरम दल व गरम दल में विभाजन) — अध्यक्ष: रासबिहारी घोष\n3. बेलगाम अधिवेशन (1924, महात्मा गांधी की अध्यक्षता वाला एकमात्र अधिवेशन)\n4. लाहौर अधिवेशन (दिसंबर 1929, 'पूर्ण स्वराज' प्रस्ताव) — अध्यक्ष: जवाहरलाल नेहरू\nउपर्युक्त में से कौन-से युग्म सही हैं?",
            listOf(
                "All 1, 2, 3 and 4",
                "1, 3 and 4 only",
                "1, 2 and 3 only",
                "2, 3 and 4 only"
            ),
            listOf(
                "सभी 1, 2, 3 और 4",
                "केवल 1, 3 और 4",
                "केवल 1, 2 और 3",
                "केवल 2, 3 और 4"
            ),
            "All 4 INC sessions are correctly matched. Also remember: First Muslim President = Badruddin Tyabji (Madras 1887); First English President = George Yule (Allahabad 1888); First Woman President = Annie Besant (Calcutta 1917); First Indian Woman President = Sarojini Naidu (Kanpur 1925); Haripura (1938) & Tripuri (1939) = Subhas Chandra Bose.",
            "चारों कांग्रेस अधिवेशन सही सुमेलित हैं। अन्य प्रमुख अध्यक्ष: प्रथम मुस्लिम अध्यक्ष = बदरुद्दीन तैयबजी (मद्रास 1887); प्रथम अंग्रेज अध्यक्ष = जॉर्ज यूल (इलाहाबाद 1888); प्रथम महिला अध्यक्ष = एनी बेसेंट (कलकत्ता 1917); प्रथम भारतीय महिला अध्यक्ष = सरोजिनी नायडू (कानपुर 1925); हरिपुरा (1938) एवं त्रिपुरी (1939) = सुभाष चंद्र बोस।",
            "SSC CGL 2022, 2023, CHSL 2023 & CPO 2024 PYQ"
        ),
        RawSscPyqSeed(
            "Match the 8 Classical Dance Forms of India (Recognized by Sangeet Natak Akademi) with their States and Legendary Exponents (The #1 most repeated Static GK topic in SSC TCS exams):\n1. Bharatanatyam (Tamil Nadu) — Rukmini Devi Arundale, Yamini Krishnamurthy, Padma Subrahmanyam\n2. Kathak (Uttar Pradesh) — Pt. Birju Maharaj, Lachhu Maharaj, Sitara Devi\n3. Kuchipudi (Andhra Pradesh) — Vempati Chinna Satyam, Radha & Raja Reddy\n4. Odissi (Odisha) — Kelucharan Mohapatra, Sonal Mansingh, Sanjukta Panigrahi\n5. Sattriya (Assam, introduced by Srimanta Sankardev in 15th Century)\nWhich of the above are correctly matched?",
            "भारत के शास्त्रीय नृत्यों (संगीत नाटक अकादमी द्वारा मान्यता प्राप्त) का उनके राज्यों एवं प्रमुख कलाकारों (SSC TCS परीक्षाओं में सर्वाधिक बार पूछा जाने वाला विषय) के साथ मिलान देखिए:\n1. भरतनाट्यम (तमिलनाडु) — रुक्मिणी देवी अरुंडेल, यामिनी कृष्णमूर्ति, पद्मा सुब्रह्मण्यम\n2. कथक (उत्तर प्रदेश) — पं. बिरजू महाराज, लच्छू महाराज, सितारा देवी\n3. कुचिपुड़ी (आंध्र प्रदेश) — वेम्पति चिन्ना सत्यम, राधा और राजा रेड्डी\n4. ओडिसी (ओडिशा) — केलुचरण महापात्र, सोनल मानसिंह, संजुक्ता पाणिग्रही\n5. सत्रिया (असम, 15वीं शताब्दी में श्रीमंत शंकरदेव द्वारा प्रवर्तित)\nउपर्युक्त में से कौन-से सही सुमेलित हैं?",
            listOf(
                "All 1, 2, 3, 4 and 5",
                "1, 2, 3 and 4 only",
                "1, 2 and 5 only",
                "2, 3, 4 and 5 only"
            ),
            listOf(
                "सभी 1, 2, 3, 4 और 5",
                "केवल 1, 2, 3 और 4",
                "केवल 1, 2 और 5",
                "केवल 2, 3, 4 और 5"
            ),
            "All 5 classical dance pairs are 100% accurate! The remaining 3 of the 8 Classical Dances are: 6. Kathakali (Kerala — Kalamandalam Gopi, Mrinalini Sarabhai), 7. Mohiniyattam (Kerala — Kalamandalam Kalyanikutty Amma, Kanak Rele), and 8. Manipuri (Manipur — Guru Bipin Singh, Jhaveri Sisters: Darshana, Nayana, Ranjana, Suvarna).",
            "सभी 5 युग्म पूर्णतः सही हैं! शेष 3 शास्त्रीय नृत्य हैं: 6. कथकली (केरल — कलामंडलम गोपी, मृणालिनी साराभाई), 7. मोहिनीअट्टम (केरल — कलामंडलम कल्याणीकुट्टी अम्मा, कनक रेले), तथा 8. मणिपुरी (मणिपुर — गुरु बिपिन सिंह एवं झावेरी बहनें)।",
            "SSC CGL, CHSL & CPO 2021–2025 (Asked in 40+ Shifts)"
        ),
        RawSscPyqSeed(
            "Match the Indian Classical Musical Instruments with their Legendary Maestros (Asked in almost every SSC CGL/CHSL shift):\n1. Sitar — Pt. Ravi Shankar (Bharat Ratna 1999) & Vilayat Khan\n2. Tabla — Ustad Zakir Hussain, Ustad Alla Rakha & Pt. Kishan Maharaj\n3. Shehnai — Ustad Bismillah Khan (Bharat Ratna 2001, played at Red Fort on 15 Aug 1947)\n4. Flute (Bansuri) — Pt. Hariprasad Chaurasia & Pannalal Ghosh\n5. Santoor — Pt. Shivkumar Sharma & Bhajan Sopori\n6. Sarod — Ustad Amjad Ali Khan & Ali Akbar Khan\nWhich of the above pairs are correct?",
            "भारतीय शास्त्रीय वाद्य यंत्रों और उनके महान वादकों (प्रत्येक SSC CGL/CHSL शिफ्ट में पूछा जाने वाला प्रश्न) का मिलान देखिए:\n1. सितार — पं. रविशंकर (भारत रत्न 1999) एवं विलायत खां\n2. तबला — उस्ताद जाकिर हुसैन, उस्ताद अल्ला रक्खा एवं पं. किशन महाराज\n3. शहनाई — उस्ताद बिस्मिल्लाह खां (भारत रत्न 2001)\n4. बांसुरी — पं. हरिप्रसाद चौरसिया एवं पन्नालाल घोष\n5. संतूर — पं. शिवकुमार शर्मा एवं भजन सोपोरी\n6. सरोद — उस्ताद अमजद अली खां एवं अली अकबर खां\nउपर्युक्त में से कौन-से युग्म सही हैं?",
            listOf(
                "All 1, 2, 3, 4, 5 and 6",
                "1, 2, 3 and 4 only",
                "1, 3, 5 and 6 only",
                "2, 4, 5 and 6 only"
            ),
            listOf(
                "सभी 1, 2, 3, 4, 5 और 6",
                "केवल 1, 2, 3 और 4",
                "केवल 1, 3, 5 और 6",
                "केवल 2, 4, 5 और 6"
            ),
            "All 6 musical instrument pairs are top-priority SSC TCS questions! Also remember: Rudra Veena = Ustad Asad Ali Khan; Sarangi = Pt. Ram Narayan & Ustad Sultan Khan; Violin = L. Subramaniam & M.S. Gopalakrishnan; Mridangam = Palghat Mani Iyer; Ghatam = T.H. Vinayakram.",
            "सभी 6 वाद्य यंत्र युग्म पूर्णतः सही हैं! अन्य महत्वपूर्ण वादक: रुद्र वीणा = उस्ताद असद अली खां; सारंगी = पं. राम नारायण एवं उस्ताद सुल्तान खां; वायलिन = एल. सुब्रमण्यम; घटम = टी.एच. विनायकरम।",
            "SSC CGL Tier-I & II 2022, 2023, 2024 PYQ"
        )
    )

    // =========================================================================
    // 2. GS — POLITY & CONSTITUTION (भारतीय राजव्यवस्था एवं संविधान — 100 QUESTIONS)
    // Covers Sources, Schedules, Articles 1–395, Fundamental Rights, DPSP,
    // Duties, President, Parliament, Supreme Court, Constitutional Bodies & Amendments
    // =========================================================================
    val politySeeds = listOf(
        RawSscPyqSeed(
            "Match the Borrowed Features of the Indian Constitution with their Source Countries (Repeated in 25+ SSC CGL/CHSL/CPO shifts):\n1. UK (British Constitution) — Parliamentary System, Rule of Law, Single Citizenship, Writs & Bicameralism\n2. USA Constitution — Fundamental Rights, Judicial Review, Independence of Judiciary, Impeachment of President & Post of Vice-President\n3. Ireland (Irish Constitution) — Directive Principles of State Policy (DPSP), Nomination of 12 members to Rajya Sabha & Method of Presidential Election\n4. USSR (Russia) — Fundamental Duties (Art 51A) & Ideals of Justice (Social, Economic, Political) in Preamble\nWhich of the above are correctly matched?",
            "भारतीय संविधान के विदेशी स्रोतों और उनसे लिए गए प्रावधानों का मिलान देखिए:\n1. ब्रिटेन (UK) — संसदीय शासन प्रणाली, विधि का शासन, एकल नागरिकता एवं द्विसदनीय व्यवस्था\n2. संयुक्त राज्य अमेरिका (USA) — मूल अधिकार, न्यायिक पुनरावलोकन, राष्ट्रपति पर महाभियोग एवं उपराष्ट्रपति का पद\n3. आयरलैंड — राज्य के नीति निदेशक तत्व (DPSP), राज्यसभा में 12 सदस्यों का मनोनयन एवं राष्ट्रपति की निर्वाचन पद्धति\n4. सोवियत संघ (USSR/रूस) — मूल कर्तव्य (अनुच्छेद 51A) एवं प्रस्तावना में न्याय (सामाजिक, आर्थिक, राजनीतिक) के आदर्श\nउपर्युक्त में से कौन-से सही सुमेलित हैं?",
            listOf(
                "All 1, 2, 3 and 4",
                "1, 2 and 3 only",
                "1, 3 and 4 only",
                "2, 3 and 4 only"
            ),
            listOf(
                "सभी 1, 2, 3 और 4",
                "केवल 1, 2 और 3",
                "केवल 1, 3 और 4",
                "केवल 2, 3 और 4"
            ),
            "All 4 source pairs are 100% accurate. Also remember: Australia = Concurrent List & Joint Sitting of Parliament (Art 108); Canada = Federation with strong Centre & Residuary Powers with Centre; South Africa = Constitutional Amendment (Art 368) & Election of Rajya Sabha members; Germany (Weimar) = Suspension of Fundamental Rights during Emergency; France = Republic & Liberty, Equality, Fraternity.",
            "चारों स्रोत युग्म पूर्णतः सही हैं। अन्य प्रमुख स्रोत: ऑस्ट्रेलिया = समवर्ती सूची एवं संसद की संयुक्त बैठक (अनुच्छेद 108); कनाडा = सशक्त केंद्र के साथ संघ एवं अवशिष्ट शक्तियाँ; दक्षिण अफ्रीका = संविधान संशोधन (अनुच्छेद 368); जर्मनी = आपातकाल के दौरान मूल अधिकारों का निलंबन; फ्रांस = गणतंत्रात्मक व्यवस्था तथा स्वतंत्रता, समता व बंधुता।",
            "SSC CGL 2021, 2022, 2023, 2024 & CPO PYQ"
        ),
        RawSscPyqSeed(
            "Match the Schedules of the Indian Constitution (Mnemonic: 'TEARS OF OLD PM') frequently tested in SSC exams:\n1. 4th Schedule — Allocation of seats in the Rajya Sabha (Council of States)\n2. 7th Schedule — Division of Powers: Union List, State List & Concurrent List (Article 246)\n3. 8th Schedule — 22 Official Languages recognized by the Constitution\n4. 10th Schedule — Anti-Defection Law (Added by 52nd Amendment Act, 1985)\n5. 11th & 12th Schedules — Panchayats (29 Subjects, 73rd Amendment 1992) & Municipalities (18 Subjects, 74th Amendment 1992)\nWhich of the above are correctly matched?",
            "भारतीय संविधान की अनुसूचियों ('TEARS OF OLD PM') का मिलान देखिए:\n1. चौथी अनुसूची — राज्यसभा में सीटों का आवंटन\n2. सातवीं अनुसूची — केंद्र एवं राज्यों के बीच शक्तियों का विभाजन: संघ सूची, राज्य सूची एवं समवर्ती सूची\n3. आठवीं अनुसूची — संविधान द्वारा मान्यता प्राप्त 22 भाषाएँ\n4. दसवीं अनुसूची — दल-बदल विरोधी कानून (52वें संशोधन अधिनियम, 1985 द्वारा जोड़ी गई)\n5. 11वीं एवं 12वीं अनुसूची — पंचायती राज (29 विषय, 73वाँ संशोधन) एवं नगरपालिकाएँ (18 विषय, 74वाँ संशोधन)\nउपर्युक्त में से कौन-से सही सुमेलित हैं?",
            listOf(
                "All 1, 2, 3, 4 and 5",
                "1, 2, 3 and 4 only",
                "2, 3, 4 and 5 only",
                "1, 3 and 5 only"
            ),
            listOf(
                "सभी 1, 2, 3, 4 और 5",
                "केवल 1, 2, 3 और 4",
                "केवल 2, 3, 4 और 5",
                "केवल 1, 3 और 5"
            ),
            "All 5 schedule statements are correct! Also remember: 5th Schedule = Administration of Scheduled Areas & STs; 6th Schedule = Tribal Areas in 4 States: Assam, Meghalaya, Tripura, and Mizoram (Mnemonic: AMTM); 9th Schedule = Added by 1st Amendment Act, 1951 (Land Reforms).",
            "पाँचों अनुसूचियाँ सही सुमेलित हैं! साथ ही याद रखें: छठी अनुसूची में 4 पूर्वोत्तर राज्यों — असम, मेघालय, त्रिपुरा और मिजोरम (AMTM) के जनजातीय क्षेत्रों के प्रशासन का प्रावधान है; नौवीं अनुसूची प्रथम संविधान संशोधन (1951) द्वारा जोड़ी गई थी।",
            "SSC CGL Tier-I 2022, 2023 & CHSL 2024 PYQ"
        ),
        RawSscPyqSeed(
            "With reference to Fundamental Rights (Part III, Articles 12 to 35 — 'Magna Carta of India'), match the following exact Articles asked in SSC TCS shifts:\n1. Article 17 — Abolition of Untouchability\n2. Article 18 — Abolition of Titles (except Military & Academic distinctions)\n3. Article 21A — Right to Free & Compulsory Education for children aged 6 to 14 years (Added by 86th Amendment Act, 2002)\n4. Article 24 — Prohibition of employment of children below 14 years in factories/mines\n5. Article 32 — Right to Constitutional Remedies (5 Writs; called 'Heart and Soul of the Constitution' by Dr. B.R. Ambedkar)\nWhich of the above are correctly matched?",
            "मूल अधिकारों (भाग III, अनुच्छेद 12 से 35 — 'भारत का मैग्ना कार्टा') के प्रमुख अनुच्छेदों का मिलान देखिए:\n1. अनुच्छेद 17 — अस्पृश्यता (छुआछूत) का अंत\n2. अनुच्छेद 18 — उपाधियों का अंत (सैन्य एवं विद्या संबंधी सम्मान को छोड़कर)\n3. अनुच्छेद 21A — 6 से 14 वर्ष के बच्चों के लिए निःशुल्क एवं अनिवार्य शिक्षा का अधिकार (86वाँ संशोधन, 2002)\n4. अनुच्छेद 24 — कारखानों आदि में 14 वर्ष से कम आयु के बच्चों के नियोजन का प्रतिषेध\n5. अनुच्छेद 32 — संवैधानिक उपचारों का अधिकार (डॉ. बी.आर. अम्बेडकर ने इसे 'संविधान की आत्मा और हृदय' कहा)\nउपर्युक्त में से कौन-से सही सुमेलित हैं?",
            listOf(
                "All 1, 2, 3, 4 and 5",
                "1, 2, 3 and 5 only",
                "1, 3, 4 and 5 only",
                "2, 3 and 4 only"
            ),
            listOf(
                "सभी 1, 2, 3, 4 और 5",
                "केवल 1, 2, 3 और 5",
                "केवल 1, 3, 4 और 5",
                "केवल 2, 3 और 4"
            ),
            "All 5 Fundamental Rights articles are 100% accurate. Important note for SSC: Articles 20 and 21 CANNOT be suspended even during a National Emergency (Article 352) as per the 44th Amendment Act, 1978. Fundamental Rights available ONLY to Indian Citizens (not foreigners): Articles 15, 16, 19, 29, and 30.",
            "पाँचों अनुच्छेद पूर्णतः सही हैं। SSC हेतु अत्यंत महत्वपूर्ण तथ्य: 44वें संविधान संशोधन (1978) के अनुसार राष्ट्रीय आपातकाल (अनुच्छेद 352) के दौरान भी अनुच्छेद 20 और 21 को निलंबित नहीं किया जा सकता। केवल भारतीय नागरिकों को प्राप्त मूल अधिकार: अनुच्छेद 15, 16, 19, 29 और 30।",
            "SSC CGL 2021, 2022, 2023, 2024 & CPO PYQ"
        ),
        RawSscPyqSeed(
            "Match the Directive Principles of State Policy (DPSP — Part IV, Articles 36 to 51) frequently asked in SSC CGL, CHSL & CPO:\n1. Article 39A — Equal Justice and Free Legal Aid (Added by 42nd Amendment, 1976)\n2. Article 40 — Organization of Village Panchayats\n3. Article 44 — Uniform Civil Code (UCC) for the citizens\n4. Article 48A — Protection and improvement of Environment and safeguarding of Forests & Wildlife (42nd Amendment)\n5. Article 50 — Separation of Judiciary from the Executive\n6. Article 51 — Promotion of International Peace and Security\nWhich of the above are correctly matched?",
            "राज्य के नीति निदेशक तत्वों (DPSP — भाग IV, अनुच्छेद 36 से 51) के प्रमुख अनुच्छेदों का मिलान देखिए:\n1. अनुच्छेद 39A — समान न्याय और निःशुल्क विधिक सहायता (42वें संशोधन, 1976 द्वारा जोड़ा गया)\n2. अनुच्छेद 40 — ग्राम पंचायतों का संगठन\n3. अनुच्छेद 44 — नागरिकों के लिए एक समान नागरिक संहिता (UCC)\n4. अनुच्छेद 48A — पर्यावरण का संरक्षण तथा वन एवं वन्य जीवों की रक्षा (42वाँ संशोधन)\n5. अनुच्छेद 50 — कार्यपालिका से न्यायपालिका का पृथक्करण\n6. अनुच्छेद 51 — अंतर्राष्ट्रीय शांति और सुरक्षा की अभिवृद्धि\nउपर्युक्त में से कौन-से सही सुमेलित हैं?",
            listOf(
                "All 1, 2, 3, 4, 5 and 6",
                "1, 2, 3 and 5 only",
                "2, 3, 5 and 6 only",
                "1, 4, 5 and 6 only"
            ),
            listOf(
                "सभी 1, 2, 3, 4, 5 और 6",
                "केवल 1, 2, 3 और 5",
                "केवल 2, 3, 5 और 6",
                "केवल 1, 4, 5 और 6"
            ),
            "All 6 DPSP articles are top-frequency SSC TCS questions! Unlike Fundamental Rights (which are justiciable), DPSPs are non-justiciable (Article 37), meaning they cannot be enforced by courts, yet they are fundamental in the governance of the country.",
            "सभी 6 नीति निदेशक अनुच्छेद पूर्णतः सही हैं! मूल अधिकारों (जो वादयोग्य हैं) के विपरीत, नीति निदेशक तत्व गैर-न्यायोचित/अवादयोग्य (अनुच्छेद 37) हैं, किंतु देश के शासन में मूलभूत हैं।",
            "SSC CGL Tier-I & II 2022, 2023, 2024 PYQ"
        ),
        RawSscPyqSeed(
            "With reference to 'Fundamental Duties' (Part IV-A, Article 51A of the Indian Constitution), consider the following statements:\n1. Fundamental Duties were NOT in the original Constitution; 10 Fundamental Duties were added by the '42nd Constitutional Amendment Act, 1976' on the recommendation of the 'Sardar Swaran Singh Committee'.\n2. The 11th Fundamental Duty — Article 51A(k) (duty of parent/guardian to provide educational opportunities to children aged 6–14 years) — was added by the '86th Constitutional Amendment Act, 2002'.\n3. Fundamental Duties apply only to Indian citizens and not to foreigners.\nWhich of the statements given above are correct?",
            "भारतीय संविधान में 'मूल कर्तव्यों' (भाग IV-A, अनुच्छेद 51A) के संदर्भ में निम्नलिखित कथनों पर विचार कीजिए:\n1. मूल कर्तव्य मूल संविधान में नहीं थे; 'सरदार स्वर्ण सिंह समिति' की सिफारिश पर '42वें संविधान संशोधन अधिनियम, 1976' द्वारा 10 मूल कर्तव्य जोड़े गए।\n2. 11वाँ मूल कर्तव्य — अनुच्छेद 51A(k) (6–14 वर्ष के बच्चों को शिक्षा का अवसर प्रदान करना) — '86वें संविधान संशोधन अधिनियम, 2002' द्वारा जोड़ा गया।\n3. मूल कर्तव्य केवल भारतीय नागरिकों पर लागू होते हैं, विदेशियों पर नहीं।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf(
                "1, 2 and 3",
                "1 and 2 only",
                "2 and 3 only",
                "1 and 3 only"
            ),
            listOf(
                "1, 2 और 3",
                "केवल 1 और 2",
                "केवल 2 और 3",
                "केवल 1 और 3"
            ),
            "All three statements are correct! Note that SSC TCS has started asking specific sub-clauses of Article 51A (from 'a' to 'k'), such as 51A(a) Respect National Flag & Anthem, 51A(g) Protect natural environment, 51A(h) Develop scientific temper, and 51A(i) Safeguard public property.",
            "तीनों कथन सही हैं! SSC की हालिया परीक्षाओं में अनुच्छेद 51A के उप-खंडों (a से k) पर भी सीधे प्रश्न पूछे जा रहे हैं, जैसे 51A(a) राष्ट्रध्वज व राष्ट्रगान का आदर, 51A(g) प्राकृतिक पर्यावरण की रक्षा, 51A(h) वैज्ञानिक दृष्टिकोण का विकास, तथा 51A(i) सार्वजनिक संपत्ति को सुरक्षित रखना।",
            "SSC CGL 2022, 2023, CHSL 2023 & CPO 2024 PYQ"
        ),
        RawSscPyqSeed(
            "Match the Constitutional Articles related to the President of India (Part V) frequently tested in SSC exams:\n1. Article 52 — There shall be a President of India\n2. Article 54 — Election of President (Electoral College: Elected MPs of both Houses + Elected MLAs of States & UTs of Delhi/Puducherry)\n3. Article 61 — Procedure for Impeachment of the President (for 'Violation of the Constitution')\n4. Article 72 — Pardoning Power of the President (Pardon, Commutation, Remission, Respite, Reprieve)\n5. Article 123 — Power of President to promulgate Ordinances during recess of Parliament\nWhich of the above are correctly matched?",
            "भारत के राष्ट्रपति (भाग V) से संबंधित प्रमुख संवैधानिक अनुच्छेदों का मिलान देखिए:\n1. अनुच्छेद 52 — भारत का एक राष्ट्रपति होगा\n2. अनुच्छेद 54 — राष्ट्रपति का निर्वाचक मंडल (संसद के दोनों सदनों के निर्वाचित सदस्य + राज्यों व दिल्ली/पुदुचेरी विधानसभाओं के निर्वाचित सदस्य)\n3. अनुच्छेद 61 — राष्ट्रपति पर महाभियोग की प्रक्रिया ('संविधान के अतिक्रमण' के आधार पर)\n4. अनुच्छेद 72 — राष्ट्रपति की क्षमादान की शक्ति (मृत्युदंड को क्षमा करने का एकमात्र अधिकार)\n5. अनुच्छेद 123 — संसद के विश्रांति काल में राष्ट्रपति द्वारा अध्यादेश जारी करने की शक्ति\nउपर्युक्त में से कौन-से सही सुमेलित हैं?",
            listOf(
                "All 1, 2, 3, 4 and 5",
                "1, 2, 3 and 4 only",
                "1, 3, 4 and 5 only",
                "2, 3 and 5 only"
            ),
            listOf(
                "सभी 1, 2, 3, 4 और 5",
                "केवल 1, 2, 3 और 4",
                "केवल 1, 3, 4 और 5",
                "केवल 2, 3 और 5"
            ),
            "All 5 Presidential articles are 100% accurate. Compare for Governor: Governor's Pardoning Power = Article 161 (cannot pardon a death sentence); Governor's Ordinance Power = Article 213.",
            "राष्ट्रपति से संबंधित पाँचों अनुच्छेद पूर्णतः सही हैं। राज्यपाल के लिए तुलनात्मक अनुच्छेद याद रखें: राज्यपाल की क्षमादान शक्ति = अनुच्छेद 161 (मृत्युदंड को पूर्ण क्षमा नहीं कर सकते); राज्यपाल की अध्यादेश शक्ति = अनुच्छेद 213।",
            "SSC CGL 2021, 2022, 2023 & CHSL 2024 PYQ"
        ),
        RawSscPyqSeed(
            "With reference to the Parliament of India (Part V, Articles 79 to 122), consider the following statements:\n1. Under Article 79, the Parliament of India consists of the President, the Council of States (Rajya Sabha — Article 80), and the House of the People (Lok Sabha — Article 81).\n2. Under Article 108, the President summons a 'Joint Sitting' of both Houses (to resolve deadlock on an Ordinary or Financial Bill, NOT on a Money Bill or Constitutional Amendment Bill), and the 'Speaker of the Lok Sabha' presides over the Joint Sitting (Article 118).\n3. 'Article 110' defines a 'Money Bill' (certified solely by the Lok Sabha Speaker; Rajya Sabha can hold it for a maximum of 14 days), while 'Article 112' deals with the 'Annual Financial Statement' (Union Budget).\nWhich of the statements given above are correct?",
            "भारतीय संसद (भाग V, अनुच्छेद 79 से 122) के संदर्भ में निम्नलिखित कथनों पर विचार कीजिए:\n1. अनुच्छेद 79 के अनुसार, भारत की संसद 'राष्ट्रपति, राज्यसभा (अनुच्छेद 80) और लोकसभा (अनुच्छेद 81)' से मिलकर बनती है।\n2. अनुच्छेद 108 के तहत साधारण विधेयक पर गतिरोध दूर करने हेतु दोनों सदनों की 'संयुक्त बैठक' राष्ट्रपति द्वारा बुलाई जाती है, जिसकी अध्यक्षता 'लोकसभा अध्यक्ष (Speaker)' करता है।\n3. 'अनुच्छेद 110' में 'धन विधेयक' (Money Bill — राज्यसभा इसे अधिकतम 14 दिनों तक रोक सकती है) की परिभाषा है, जबकि 'अनुच्छेद 112' में 'वार्षिक वित्तीय विवरण' (बजट) का उल्लेख है।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf(
                "1, 2 and 3",
                "1 and 2 only",
                "2 and 3 only",
                "1 and 3 only"
            ),
            listOf(
                "1, 2 और 3",
                "केवल 1 और 2",
                "केवल 2 और 3",
                "केवल 1 और 3"
            ),
            "All three statements are core SSC Polity facts! Also remember minimum age requirements: President / Vice-President / Governor = 35 years; Rajya Sabha MP / State MLC = 30 years; Lok Sabha MP / State MLA = 25 years; Panchayat / Municipality election = 21 years; Voting age = 18 years (reduced from 21 to 18 by 61st Amendment Act, 1989).",
            "तीनों कथन सही हैं! न्यूनतम आयु सीमा भी याद रखें: राष्ट्रपति / उपराष्ट्रपति / राज्यपाल = 35 वर्ष; राज्यसभा सांसद / विधान परिषद सदस्य = 30 वर्ष; लोकसभा सांसद / विधायक = 25 वर्ष; पंचायत चुनाव = 21 वर्ष; मतदान की आयु = 18 वर्ष (61वें संविधान संशोधन, 1989 द्वारा 21 से घटाकर 18 वर्ष की गई)।",
            "SSC CGL Tier-I & II 2022, 2023 & CPO 2024 PYQ"
        ),
        RawSscPyqSeed(
            "Match the Important Constitutional Bodies of India with their exact Articles (Asked in every SSC CGL/CHSL exam cycle):\n1. Attorney General of India (Highest Law Officer of India) — Article 76\n2. Comptroller and Auditor General of India (CAG — Guardian of Public Purse) — Article 148\n3. Finance Commission (Constituted every 5 years by the President) — Article 280\n4. National Commission for SCs / STs / Backward Classes (NCBC) — Articles 338, 338A & 338B\n5. Election Commission of India — Article 324 (UPSC & State PSC — Article 315)\nWhich of the above pairs are correctly matched?",
            "भारत के प्रमुख संवैधानिक निकायों और उनके अनुच्छेदों का मिलान देखिए:\n1. भारत का महान्यायवादी (Attorney General — सर्वोच्च विधि अधिकारी) — अनुच्छेद 76\n2. भारत का नियंत्रक एवं महालेखापरीक्षक (CAG — लोक धन का संरक्षक) — अनुच्छेद 148\n3. वित्त आयोग (राष्ट्रपति द्वारा प्रत्येक 5 वर्ष पर गठन) — अनुच्छेद 280\n4. राष्ट्रीय अनुसूचित जाति / जनजाति / पिछड़ा वर्ग आयोग — अनुच्छेद 338, 338A एवं 338B\n5. भारत निर्वाचन आयोग — अनुच्छेद 324 (संघ एवं राज्य लोक सेवा आयोग — अनुच्छेद 315)\nउपर्युक्त में से कौन-से युग्म सही सुमेलित हैं?",
            listOf(
                "All 1, 2, 3, 4 and 5",
                "1, 2, 3 and 5 only",
                "1, 3, 4 and 5 only",
                "2, 3 and 5 only"
            ),
            listOf(
                "सभी 1, 2, 3, 4 और 5",
                "केवल 1, 2, 3 और 5",
                "केवल 1, 3, 4 और 5",
                "केवल 2, 3 और 5"
            ),
            "All 5 Constitutional Body articles are 100% accurate. Also note: Advocate General of the State = Article 165; Goods and Services Tax (GST) Council = Article 279A (added by 101st Amendment Act, 2016, chaired by the Union Finance Minister).",
            "पाँचों संवैधानिक निकाय और उनके अनुच्छेद पूर्णतः सही हैं। अन्य प्रमुख अनुच्छेद: राज्य का महाधिवक्ता (Advocate General) = अनुच्छेद 165; वस्तु एवं सेवा कर (GST) परिषद = अनुच्छेद 279A (101वाँ संशोधन, 2016; अध्यक्ष: केंद्रीय वित्त मंत्री)।",
            "SSC CGL 2021, 2022, 2023, 2024 PYQ"
        ),
        RawSscPyqSeed(
            "Match the Landmark Constitutional Amendments (101st to 106th) with their provisions (High-priority SSC CGL/CHSL Current Polity):\n1. 101st Amendment Act (2016) — Introduction of Goods and Services Tax (GST)\n2. 102nd Amendment Act (2018) — Constitutional status to National Commission for Backward Classes (NCBC, Art 338B)\n3. 103rd Amendment Act (2019) — 10% Reservation for Economically Weaker Sections (EWS — Articles 15(6) & 16(6))\n4. 104th Amendment Act (2020) — Extended SC/ST reservation in Lok Sabha/Assemblies for 10 years & ended nomination of 2 Anglo-Indians\n5. 106th Amendment Act (2023 — Nari Shakti Vandan Adhiniyam) — 33% (1/3rd) reservation for women in Lok Sabha, State Assemblies & Delhi Assembly\nWhich of the above are correctly matched?",
            "प्रमुख नवीनतम संविधान संशोधनों (101वाँ से 106वाँ) और उनके प्रावधानों का मिलान देखिए:\n1. 101वाँ संशोधन अधिनियम (2016) — वस्तु एवं सेवा कर (GST) की शुरुआत\n2. 102वाँ संशोधन अधिनियम (2018) — राष्ट्रीय पिछड़ा वर्ग आयोग (NCBC, अनुच्छेद 338B) को संवैधानिक दर्जा\n3. 103वाँ संशोधन अधिनियम (2019) — आर्थिक रूप से कमजोर वर्गों (EWS) के लिए 10% आरक्षण\n4. 104वाँ संशोधन अधिनियम (2020) — लोकसभा/विधानसभाओं में SC/ST आरक्षण 10 वर्ष बढ़ाया तथा आंग्ल-भारतीय (Anglo-Indian) मनोनयन समाप्त किया\n5. 106वाँ संशोधन अधिनियम (2023 — नारी शक्ति वंदन अधिनियम) — लोकसभा व राज्य विधानसभाओं में महिलाओं के लिए 33% आरक्षण\nउपर्युक्त में से कौन-से सही सुमेलित हैं?",
            listOf(
                "All 1, 2, 3, 4 and 5",
                "1, 2, 3 and 4 only",
                "1, 3, 4 and 5 only",
                "2, 3 and 5 only"
            ),
            listOf(
                "सभी 1, 2, 3, 4 और 5",
                "केवल 1, 2, 3 और 4",
                "केवल 1, 3, 4 और 5",
                "केवल 2, 3 और 5"
            ),
            "All 5 recent Constitutional Amendments (101st to 106th) are correctly matched! Note: The 105th Amendment Act (2021) restored the power of State Governments and UTs to identify and notify Socially and Educationally Backward Classes (SEBCs / OBC list).",
            "सभी 5 नवीनतम संविधान संशोधन सही सुमेलित हैं! साथ ही याद रखें: 105वें संविधान संशोधन अधिनियम (2021) द्वारा राज्य सरकारों को अपनी सामाजिक और शैक्षणिक रूप से पिछड़े वर्गों (OBC) की सूची तैयार करने का अधिकार पुनः बहाल किया गया।",
            "SSC CGL 2023, 2024 & CHSL 2024 PYQ"
        ),
        RawSscPyqSeed(
            "With reference to the Supreme Court (Part V, Articles 124 to 147) and High Courts (Part VI, Articles 214 to 231), which Articles empower the Supreme Court as a 'Court of Record' and grant the President power to seek the Supreme Court's 'Advisory Jurisdiction'?",
            "सर्वोच्च न्यायालय (भाग V, अनुच्छेद 124–147) के संदर्भ में, कौन-से अनुच्छेद सर्वोच्च न्यायालय को 'अभिलेख न्यायालय' (Court of Record) घोषित करते हैं तथा राष्ट्रपति को सर्वोच्च न्यायालय से 'परामर्श करने की शक्ति' (Advisory Jurisdiction) प्रदान करते हैं?",
            listOf(
                "Article 129 (Court of Record) and Article 143 (Advisory Jurisdiction of SC)",
                "Article 124 (Establishment of SC) and Article 137 (Review of Judgments)",
                "Article 131 (Original Jurisdiction) and Article 142 (Complete Justice)",
                "Article 215 (HC Court of Record) and Article 226 (HC Writ Jurisdiction)"
            ),
            listOf(
                "अनुच्छेद 129 (अभिलेख न्यायालय) और अनुच्छेद 143 (राष्ट्रपति की सर्वोच्च न्यायालय से परामर्श करने की शक्ति)",
                "अनुच्छेद 124 (सर्वोच्च न्यायालय का गठन) और अनुच्छेद 137 (निर्णयों का पुनर्विलोकन)",
                "अनुच्छेद 131 (आरंभिक अधिकारिता) और अनुच्छेद 142 (पूर्ण न्याय करने की शक्ति)",
                "अनुच्छेद 215 (उच्च न्यायालय अभिलेख न्यायालय) और अनुच्छेद 226 (रिट अधिकारिता)"
            ),
            "Article 129 declares the Supreme Court a 'Court of Record' (High Court is a Court of Record under Article 215), and Article 143 empowers the President to consult the Supreme Court on questions of law or fact of public importance.",
            "अनुच्छेद 129 सर्वोच्च न्यायालय को 'अभिलेख न्यायालय' (Court of Record) घोषित करता है (उच्च न्यायालय अनुच्छेद 215 के तहत अभिलेख न्यायालय है), और अनुच्छेद 143 राष्ट्रपति को सार्वजनिक महत्व के प्रश्नों पर सर्वोच्च न्यायालय से परामर्श लेने की शक्ति देता है।",
            "SSC CGL Tier-I & II 2022, 2023, 2024 PYQ"
        )
    )

    // =========================================================================
    // 3. GS — GEOGRAPHY (भारत एवं विश्व का भूगोल — 100 QUESTIONS)
    // Covers Solar System, Atmosphere, Himalayas & Passes, Rivers, Dams,
    // Lakes, Monsoon, Soils, Minerals, Ports & Census 2011
    // =========================================================================
    val geographySeeds = listOf(
        RawSscPyqSeed(
            "With reference to India's Geographical Frontiers, Latitudes/Longitudes, and Channels (Asked in every SSC cycle), consider the following statements:\n1. The 'Tropic of Cancer' (23°30' N) passes through 8 Indian States: Gujarat, Rajasthan, Madhya Pradesh, Chhattisgarh, Jharkhand, West Bengal, Tripura, and Mizoram.\n2. The 'Indian Standard Time (IST)' meridian (82°30' E, which is 5 hours 30 minutes ahead of GMT) passes through Mirzapur/Naini (UP) and crosses 5 Indian States: Uttar Pradesh, Madhya Pradesh, Chhattisgarh, Odisha, and Andhra Pradesh.\n3. The '10 Degree Channel' separates the Andaman Islands (Little Andaman) from the Nicobar Islands (Car Nicobar), while the '8 Degree Channel' separates Minicoy (Lakshadweep) from the Maldives.\nWhich of the statements given above are correct?",
            "भारत की भौगोलिक स्थिति, कर्क रेखा, मानक समय रेखा और प्रमुख चैनलों के संदर्भ में विचार कीजिए:\n1. 'कर्क रेखा' (23°30' उत्तरी अक्षांश) भारत के 8 राज्यों — गुजरात, राजस्थान, मध्य प्रदेश, छत्तीसगढ़, झारखंड, पश्चिम बंगाल, त्रिपुरा और मिजोरम — से होकर गुजरती है।\n2. 'भारतीय मानक समय रेखा' (82°30' पूर्वी देशांतर, जो GMT से 5 घंटे 30 मिनट आगे है) मिर्जापुर/नैनी (उ.प्र.) से गुजरती है और 5 राज्यों — उत्तर प्रदेश, मध्य प्रदेश, छत्तीसगढ़, ओडिशा और आंध्र प्रदेश — को पार करती है।\n3. '10 डिग्री चैनल' अंडमान द्वीप समूह (लिटिल अंडमान) को निकोबार द्वीप समूह (कार निकोबार) से अलग करता है, जबकि '8 डिग्री चैनल' मिनिकॉय को मालदीव से अलग करता है।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf(
                "1, 2 and 3",
                "1 and 2 only",
                "2 and 3 only",
                "1 and 3 only"
            ),
            listOf(
                "1, 2 और 3",
                "केवल 1 और 2",
                "केवल 2 और 3",
                "केवल 1 और 3"
            ),
            "All three statements are 100% accurate. Also remember: Tropic of Cancer and IST (82.5°E) intersect each other in 'Koriya district of Chhattisgarh'. India shares its longest land border with Bangladesh (4,096.7 km) and shortest with Afghanistan (106 km).",
            "तीनों कथन पूर्णतः सही हैं। साथ ही याद रखें: कर्क रेखा और भारतीय मानक समय रेखा (82.5°E) एक-दूसरे को 'छत्तीसगढ़ के कोरिया जिले' में काटती हैं। भारत की सबसे लंबी स्थलीय सीमा बांग्लादेश (4,096.7 किमी) के साथ और सबसे छोटी अफगानिस्तान (106 किमी) के साथ लगती है।",
            "SSC CGL 2021, 2022, 2023 & CHSL 2024 PYQ"
        ),
        RawSscPyqSeed(
            "Match the Major Himalayan Mountain Passes with their States/UTs (Frequently asked in SSC CGL, CHSL & CPO):\n1. Zoji La, Banihal Pass & Burzil Pass — Jammu & Kashmir / Ladakh\n2. Shipki La (Sutlej River enters India), Rohtang Pass & Baralacha La — Himachal Pradesh\n3. Mana, Niti & Lipulekh Pass (Tri-junction of India, Nepal & China) — Uttarakhand\n4. Nathu La & Jelep La — Sikkim\n5. Bomdi La & Diphu Pass — Arunachal Pradesh\nWhich of the above are correctly matched?",
            "प्रमुख हिमालयी दर्रों और उनके राज्यों/केंद्रशासित प्रदेशों का मिलान देखिए:\n1. जोजिला, बनिहाल एवं बुर्जिल दर्रा — जम्मू-कश्मीर / लद्दाख\n2. शिपकी ला (सतलज नदी का भारत में प्रवेश), रोहतांग एवं बारालाचा ला दर्रा — हिमाचल प्रदेश\n3. माना, नीति एवं लिपुलेख दर्रा (भारत-नेपाल-चीन त्रिकोणीय संगम) — उत्तराखंड\n4. नाथू ला एवं जेलेप ला दर्रा — सिक्किम\n5. बोमडिला एवं दीफू दर्रा — अरुणाचल प्रदेश\nउपर्युक्त में से कौन-से सही सुमेलित हैं?",
            listOf(
                "All 1, 2, 3, 4 and 5",
                "1, 2, 3 and 4 only",
                "2, 3, 4 and 5 only",
                "1, 3 and 5 only"
            ),
            listOf(
                "सभी 1, 2, 3, 4 और 5",
                "केवल 1, 2, 3 और 4",
                "केवल 2, 3, 4 और 5",
                "केवल 1, 3 और 5"
            ),
            "All 5 mountain pass groups are correctly matched! Also remember the 3 passes of the Western Ghats: Thal Ghat (connects Mumbai to Nashik), Bhor Ghat (connects Mumbai to Pune), and Palghat / Palakkad Gap (connects Kerala to Tamil Nadu between Nilgiri and Anaimalai hills).",
            "पाँचों समूह सही सुमेलित हैं! पश्चिमी घाट के 3 प्रमुख दर्रे भी याद रखें: थालघाट (मुंबई को नासिक से जोड़ता है), भोरघाट (मुंबई को पुणे से जोड़ता है), तथा पालघाट (केरल को तमिलनाडु से जोड़ता है — नीलगिरि और अन्नामलाई पहाड़ियों के बीच)।",
            "SSC CGL 2022, 2023 & CPO 2024 PYQ"
        ),
        RawSscPyqSeed(
            "With reference to the Peninsular Rivers of India, which two major rivers flow WESTWARD through 'Rift Valleys' (faults between Vindhya, Satpura, and Ajanta ranges) and form 'Estuaries' (not deltas) before draining into the Arabian Sea?",
            "प्रायद्वीपीय भारत की कौन-सी दो प्रमुख नदियाँ 'भ्रंश घाटी' (Rift Valley) से होकर पश्चिम की ओर बहती हैं और डेल्टा के स्थान पर 'ज्वारनदमुख' (Estuary) बनाती हुई अरब सागर में गिरती हैं?",
            listOf(
                "Narmada (Origin: Amarkantak Plateau) and Tapi / Tapti (Origin: Multai, Betul, MP)",
                "Godavari (Trimbakeshwar) and Krishna (Mahabaleshwar)",
                "Mahanadi (Sihawa) and Kaveri (Talakaveri, Brahmagiri Hills)",
                "Chambal (Janapav Hills) and Betwa"
            ),
            listOf(
                "नर्मदा (उद्गम: अमरकंटक पठार) और तापी / ताप्ती (उद्गम: मुलताई, बैतूल, म.प्र.)",
                "गोदावरी (त्र्यंबकेश्वर) और कृष्णा (महाबलेश्वर)",
                "महानदी (सिहावा) और कावेरी (तालकावेरी, ब्रह्मगिरि पहाड़ियाँ)",
                "चंबल (जानापाव पहाड़ी) और बेतवा"
            ),
            "Narmada (longest west-flowing peninsular river, 1,312 km; forms Dhuandhar Falls at Jabalpur; Sardar Sarovar Dam) and Tapi flow westward through Rift Valleys into the Gulf of Khambhat (Arabian Sea). Remember: The 'Mahi River' is the only river in India that cuts the Tropic of Cancer TWICE.",
            "नर्मदा (प्रायद्वीपीय भारत की सबसे लंबी पश्चिम वाहिनी नदी, 1,312 किमी; जबलपुर में धुआँधार जलप्रपात एवं सरदार सरोवर बांध) और तापी नदी सतपुड़ा व विंध्य के बीच भ्रंश घाटी से बहती हुई खंभात की खाड़ी (अरब सागर) में गिरती हैं। विशेष तथ्य: 'माही नदी' कर्क रेखा को दो बार काटती है।",
            "SSC CGL 2021, 2023 & CHSL 2022, 2024 PYQ"
        ),
        RawSscPyqSeed(
            "Match the Major Multi-Purpose River Valley Projects & Dams of India with their Rivers and States:\n1. Tehri Dam (Highest Dam in India, 260.5 m) — Bhagirathi River, Uttarakhand\n2. Hirakud Dam (Longest Dam in India, 25.8 km) — Mahanadi River, Odisha\n3. Bhakra-Nangal Dam (Highest Straight Gravity Dam) — Sutlej River, Himachal Pradesh / Punjab\n4. Nagarjuna Sagar & Srisailam Dams — Krishna River, Andhra Pradesh / Telangana\n5. Idukki Arch Dam — Periyar River, Kerala (Mettur Dam — Kaveri River, Tamil Nadu)\nWhich of the above are correctly matched?",
            "भारत की प्रमुख बहुउद्देशीय नदी घाटी परियोजनाओं एवं बांधों का उनकी नदियों व राज्यों के साथ मिलान देखिए:\n1. टिहरी बांध (भारत का सबसे ऊँचा बांध, 260.5 मी.) — भागीरथी नदी, उत्तराखंड\n2. हीराकुंड बांध (भारत का सबसे लंबा बांध, 25.8 किमी) — महानदी, ओडिशा\n3. भाखड़ा-नांगल बांध (सबसे ऊँचा गुरुत्वीय बांध) — सतलज नदी, हिमाचल प्रदेश / पंजाब\n4. नागार्जुन सागर एवं श्रीशैलम बांध — कृष्णा नदी, आंध्र प्रदेश / तेलंगाना\n5. इडुक्की आर्च बांध — पेरियार नदी, केरल (मेट्टूर बांध — कावेरी नदी, तमिलनाडु)\nउपर्युक्त में से कौन-से सही सुमेलित हैं?",
            listOf(
                "All 1, 2, 3, 4 and 5",
                "1, 2, 3 and 4 only",
                "1, 3 and 5 only",
                "2, 4 and 5 only"
            ),
            listOf(
                "सभी 1, 2, 3, 4 और 5",
                "केवल 1, 2, 3 और 4",
                "केवल 1, 3 और 5",
                "केवल 2, 4 और 5"
            ),
            "All 5 dam pairs are 100% accurate. Also asked in SSC: Salal, Baglihar, and Dulhasti Hydroelectric Projects are on the 'Chenab River' (J&K); Tulbul and Uri Projects are on the 'Jhelum River'; Nathpa Jhakri is on the 'Sutlej River' (HP).",
            "पाँचों बांध युग्म पूर्णतः सही हैं। SSC में बार-बार पूछे जाने वाले अन्य बांध: सलाल, बगलिहार और दुलहस्ती परियोजनाएँ 'चिनाब नदी' (जम्मू-कश्मीर) पर हैं; तुलबुल और उरी परियोजनाएँ 'झेलम नदी' पर हैं; नाथपा झाकड़ी परियोजना 'सतलज नदी' (हिमाचल प्रदेश) पर है।",
            "SSC CGL Tier-I 2022, 2023 & CPO 2023 PYQ"
        ),
        RawSscPyqSeed(
            "With reference to the Layers of the Earth's Atmosphere (from bottom to top) and their characteristics, consider the following statements:\n1. 'Troposphere' (0–12/18 km) is the lowest and densest layer where ALL weather phenomena (clouds, rain, cyclones) occur.\n2. 'Stratosphere' (up to 50 km) contains the 'Ozone Layer' (O3, measured in Dobson Units) which absorbs harmful UV rays and provides ideal conditions for flying jet aircraft.\n3. 'Mesosphere' (50–80 km) is the coldest layer where meteors burn up upon entering from space, while the 'Ionosphere / Thermosphere' reflects radio waves back to Earth.\nWhich of the statements given above are correct?",
            "पृथ्वी के वायुमंडल की परतों (नीचे से ऊपर के क्रम में) और उनकी विशेषताओं के संदर्भ में विचार कीजिए:\n1. 'क्षोभमंडल' (Troposphere) सबसे निचली परत है जहाँ सभी मौसमी घटनाएँ (बादल, वर्षा, चक्रवात, कोहरा) घटित होती हैं।\n2. 'समतापमंडल' (Stratosphere) में 'ओजोन परत' (O3, डॉब्सन इकाई में मापी जाती है) पाई जाती है जो पराबैंगनी (UV) किरणों को सोखती है और जेट विमानों की उड़ान के लिए आदर्श होती है।\n3. 'मध्यमंडल' (Mesosphere) वायुमंडल की सबसे ठंडी परत है जहाँ अंतरिक्ष से आने वाले उल्कापिंड जलकर नष्ट हो जाते हैं, जबकि 'आयनमंडल' रेडियो तरंगों को पृथ्वी पर परावर्तित करता है।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf(
                "1, 2 and 3",
                "1 and 2 only",
                "2 and 3 only",
                "1 and 3 only"
            ),
            listOf(
                "1, 2 और 3",
                "केवल 1 और 2",
                "केवल 2 और 3",
                "केवल 1 और 3"
            ),
            "All three statements are correct. Composition of dry atmosphere by volume: Nitrogen (N2) = 78.08%, Oxygen (O2) = 20.95%, Argon (Ar) = 0.93% (most abundant noble gas in atmosphere), Carbon Dioxide (CO2) = 0.036–0.04%.",
            "तीनों कथन सही हैं। शुष्क वायुमंडल में गैसों का प्रतिशत: नाइट्रोजन (78.08%), ऑक्सीजन (20.95%), आर्गन (0.93% — वायुमंडल में सर्वाधिक पाई जाने वाली अक्रिय गैस), और कार्बन डाइऑक्साइड (0.036–0.04%)।",
            "SSC CGL 2021, 2023 & CHSL 2024 PYQ"
        ),
        RawSscPyqSeed(
            "According to the Census of India 2011 (15th Census since 1872, 7th after Independence; Commissioner: C. Chandramouli), which of the following demographic facts is/are CORRECT?\n1. India's overall Literacy Rate is 74.04% (Male: 82.14%, Female: 65.46%); Kerala has the highest literacy (94.0%) and Bihar has the lowest (61.80%).\n2. India's Sex Ratio is 943 females per 1000 males (Highest State: Kerala 1084; Lowest State: Haryana 879; Highest UT: Puducherry 1037).\n3. India's Population Density is 382 persons/sq km (Highest State: Bihar at 1,106/sq km; Lowest State: Arunachal Pradesh at 17/sq km).\nWhich of the statements given above are correct?",
            "भारत की जनगणना 2011 (1872 से 15वीं तथा स्वतंत्रता के बाद 7वीं जनगणना — जनगणना आयुक्त: सी. चंद्रमौली) के अनुसार निम्नलिखित में से कौन-से कथन सही हैं?\n1. भारत की कुल साक्षरता दर 74.04% है (पुरुष: 82.14%, महिला: 65.46%); सर्वाधिक साक्षरता केरल (94.0%) और न्यूनतम साक्षरता बिहार (61.80%) में है।\n2. भारत का लिंगानुपात 943 महिलाएँ प्रति 1000 पुरुष है (सर्वाधिक राज्य: केरल 1084; न्यूनतम राज्य: हरियाणा 879)।\n3. भारत का जनसंख्या घनत्व 382 व्यक्ति/वर्ग किमी है (सर्वाधिक घनत्व वाला राज्य: बिहार 1,106 व्यक्ति/वर्ग किमी; न्यूनतम: अरुणाचल प्रदेश 17 व्यक्ति/वर्ग किमी)।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf(
                "1, 2 and 3",
                "1 and 2 only",
                "2 and 3 only",
                "1 and 3 only"
            ),
            listOf(
                "1, 2 और 3",
                "केवल 1 और 2",
                "केवल 2 और 3",
                "केवल 1 और 3"
            ),
            "Census 2011 is asked in 1 to 2 questions in EVERY SINGLE SSC CGL, CHSL, and CPO shift! Also remember: Nagaland was the ONLY state to record a negative decadal population growth rate (-0.58%) during 2001–2011; 1921 is called the 'Year of the Great Divide' in Indian demography.",
            "जनगणना 2011 से SSC CGL, CHSL और CPO की प्रत्येक शिफ्ट में 1 से 2 प्रश्न अनिवार्य रूप से पूछे जाते हैं! साथ ही याद रखें: 2001–2011 के दौरान ऋणात्मक दशकीय जनसंख्या वृद्धि दर (-0.58%) दर्ज करने वाला एकमात्र राज्य 'नागालैंड' था; वर्ष 1921 को भारतीय जनसांख्यिकी में 'महान विभाजक वर्ष' (Year of Great Divide) कहा जाता है।",
            "SSC CGL, CHSL & CPO 2021–2025 (Asked in 50+ Shifts)"
        ),
        RawSscPyqSeed(
            "With reference to Major Soil Types of India (ICAR Classification) and Agricultural Revolutions, consider the following statements:\n1. 'Alluvial Soil' covers the largest area in India (~40%); 'Khadar' is the new fertile alluvium while 'Bangar' is the older alluvium containing calcareous nodules (Kankar).\n2. 'Black Soil' (Regur Soil / Black Cotton Soil), formed from the weathering of Deccan Basalt lava rocks, is rich in iron, lime, and magnesium and exhibits 'self-ploughing' capacity due to high moisture retention.\n3. 'Laterite Soil', formed in areas of high temperature and heavy rainfall due to intense 'Leaching', is ideal for growing Cashew nuts, Tea, and Coffee.\nWhich of the statements given above are correct?",
            "भारत की प्रमुख मृदाओं (ICAR वर्गीकरण) के संदर्भ में निम्नलिखित कथनों पर विचार कीजिए:\n1. 'जलोढ़ मृदा' (Alluvial Soil) भारत के सर्वाधिक क्षेत्रफल (~40%) पर फैली है; नवीन जलोढ़ को 'खादर' और पुरानी जलोढ़ को 'बांगर' कहा जाता है।\n2. 'काली मृदा' (रेगुर मृदा / कपासी मिट्टी) दक्कन के बेसाल्ट लावा चट्टानों के अपक्षय से बनी है और उच्च नमी धारण क्षमता के कारण 'स्वतः जुताई' (Self-ploughing) के गुण के लिए जानी जाती है।\n3. उच्च तापमान और भारी वर्षा वाले क्षेत्रों में तीव्र 'निक्षालन' (Leaching) से निर्मित 'लैटेराइट मृदा' काजू, चाय और कॉफी की खेती के लिए उपयुक्त होती है।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf(
                "1, 2 and 3",
                "1 and 2 only",
                "2 and 3 only",
                "1 and 3 only"
            ),
            listOf(
                "1, 2 और 3",
                "केवल 1 और 2",
                "केवल 2 और 3",
                "केवल 1 और 3"
            ),
            "All three soil statements are 100% accurate. Most Indian soils (Alluvial, Black, Red) are deficient in Nitrogen (N), Phosphorus (P), and Humus (NPK fertilizer ratio recommended for Indian soils is 4:2:1).",
            "तीनों कथन पूर्णतः सही हैं। अधिकांश भारतीय मृदाओं में नाइट्रोजन (N), फॉस्फोरस (P) और ह्यूमस की कमी पाई जाती है (भारतीय कृषि में NPK उर्वरक का आदर्श अनुपात 4:2:1 माना जाता है)।",
            "SSC CGL 2022, 2023 & CHSL 2024 PYQ"
        )
    )
}
