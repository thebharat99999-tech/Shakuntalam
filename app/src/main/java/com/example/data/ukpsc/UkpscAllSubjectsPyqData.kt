package com.example.data.ukpsc

import com.example.data.ukpsc.UkpscSpecial100PyqData.RawUkpscPyqSeed
import com.example.data.ukpsc.UkpscSpecial100PyqData.UkpscSectionTestMeta
import com.example.data.ukpsc.UkpscSpecial100PyqData.buildUkpscQuestions
import com.example.model.MockTest

/**
 * UKPSC (Uttarakhand Public Service Commission — उत्तराखंड लोक सेवा आयोग)
 * Last 5 Years (2020–2025) Prelims PYQ Subject-Wise Bilingual Question Bank:
 *
 *  - Special Section #1: Uttarakhand Special (उत्तराखंड विशेष — Top 100 Last 5 Years PYQs) — 100 Questions
 *  - Section #2: History of India & National Movement (भारतीय इतिहास एवं राष्ट्रीय आंदोलन) — 50 Questions
 *  - Section #3: Indian Polity & Governance (भारतीय राजव्यवस्था एवं शासन) — 50 Questions
 *  - Section #4: Indian & World Geography (भारत एवं विश्व का भूगोल) — 50 Questions
 *  - Section #5: Indian Economy & Social Development (भारतीय अर्थव्यवस्था एवं सामाजिक विकास) — 50 Questions
 *  - Section #6: Environment, Ecology & Biodiversity (पर्यावरण, पारिस्थितिकी एवं जैव-विविधता) — 50 Questions
 *  - Section #7: General Science, Tech & Computer IT (सामान्य विज्ञान, प्रौद्योगिकी एवं कंप्यूटर) — 50 Questions
 *  - Section #8: Uttarakhand, National & International Current Affairs (समसामयिकी) — 50 Questions
 *
 * Total: 8 Free Attempt Sections = 450 Authentic Bilingual UKPSC PYQ Questions (+1.0 / -0.25 Official Marking)
 */
object UkpscAllSubjectsPyqData {

    // =========================================================================
    // SECTION 2: UKPSC HISTORY OF INDIA & NATIONAL MOVEMENT — 50 PYQ Questions
    // =========================================================================
    private val ukpscHistorySeeds: List<RawUkpscPyqSeed> = listOf(
        RawUkpscPyqSeed(
            "With reference to the Indus Valley Civilization & Vedic Period (Asked in UKPSC Upper PCS 2021, 2024 & RO/ARO 2023), consider the following statements:\n1. Dholavira (Gujarat) is divided into three parts (Citadel, Middle Town, Lower Town) and is famous for its giant rock-cut water reservoirs and 10-sign signboard inscription.\n2. Lothal (on Bhogava river, Gujarat) had an artificial brick dockyard and yielded evidence of double burials and rice husks.\n3. In the Rigveda, the 'Battle of Ten Kings' (Dasarajna War) mentioned in the 7th Mandala was fought on the bank of River Parushni (Ravi), where Bharata King Sudas defeated the confederacy of ten tribes.\nWhich of the statements given above are correct?",
            "सिंधु घाटी सभ्यता और वैदिक काल (UKPSC 2021, 2024 एवं RO/ARO 2023) के संदर्भ में विचार कीजिए:\n1. धोलावीरा (गुजरात) तीन भागों (दुर्ग, मध्यम नगर और निचला नगर) में विभाजित था तथा शैलकृत जलकुंडों और 10 बड़े चिह्नों वाले शिलालेख के लिए प्रसिद्ध है।\n2. लोथल (भोगवा नदी के तट पर, गुजरात) में ईंटों से निर्मित कृत्रिम गोदीबाड़ा (Dockyard) और युगल शवाधान के साक्ष्य मिले हैं।\n3. ऋग्वेद के 7वें मंडल में वर्णित 'दशराज्ञ युद्ध' परुष्णी (रावी) नदी के तट पर लड़ा गया था जिसमें भरत जन के राजा सुदास विजयी हुए।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "Directly asked in UKPSC Upper PCS Prelims 2021, 2024 and RO/ARO 2023! Also remember from UKPSC 2021: Kalibangan yielded ploughed field surface and fire altars; Banawali yielded a terracotta model of a plough; and Gayatri Mantra is in the 3rd Mandala of Rigveda composed by Vishwamitra.",
            "UKPSC प्रवर पीसीएस 2021, 2024 और RO/ARO 2023 में सीधे पूछे गए प्रश्न! साथ ही याद रखें: कालीबंगा से जुते हुए खेत के साक्ष्य, बनावली से पकी मिट्टी के हल की प्रतिकृति और ऋग्वेद के तीसरे मंडल से गायत्री मंत्र प्राप्त होता है।",
            "UKPSC Upper PCS 2021 & 2024 PYQ"
        ),
        RawUkpscPyqSeed(
            "Match the Ancient Indian Rulers & Inscriptions (Asked in UKPSC Prelims 2021 & 2024):\n1. Hathigumpha Inscription (Udayagiri, Odisha) — King Kharavela of Chedi Dynasty\n2. Junagadh (Girnar) Rock Inscription (first chaste Sanskrit inscription) — Shaka Ruler Rudradaman-I\n3. Prayag Prashasti (Allahabad Pillar Inscription composed by Harishena) — Samudragupta (mentions 'Kartripura' state covering Uttarakhand)\n4. Aihole Inscription (composed by Ravikirti) — Chalukya Ruler Pulakeshin-II (mentions defeat of Harshavardhana on Narmada bank)\nWhich of the above pairs are correctly matched?",
            "प्राचीन भारतीय शासकों एवं उनके अभिलेखों (UKPSC 2021 एवं 2024) के संदर्भ में विचार कीजिए:\n1. हाथीगुम्फा अभिलेख (उदयगिरि, ओडिशा) — चेदि वंश के शासक खारवेल\n2. जूनागढ़ (गिरनार) अभिलेख (विशुद्ध संस्कृत का प्रथम लंबा अभिलेख) — शक क्षत्रप रुद्रदामन प्रथम\n3. प्रयाग प्रशस्ति (हरिषेण द्वारा रचित) — समुद्रगुप्त (इसमें उत्तराखंड के 'कर्तृपुर' राज्य का उल्लेख है)\n4. ऐहोल अभिलेख (रविकीर्ति द्वारा रचित) — चालुक्य शासक पुलकेशिन द्वितीय (नर्मदा तट पर हर्षवर्धन की पराजय का उल्लेख)\nउपर्युक्त में से कौन-से युग्म सही सुमेलित हैं?",
            listOf("1, 2, 3 and 4", "1, 2 and 3 only", "2, 3 and 4 only", "1 and 4 only"),
            listOf("1, 2, 3 और 4", "केवल 1, 2 और 3", "केवल 2, 3 और 4", "केवल 1 और 4"),
            "Directly asked in UKPSC Upper PCS Prelims 2021 & 2024! Note that Samudragupta's Prayag Prashasti lists 'Kartripura' (ancient Uttarakhand-Rohilkhand-Himachal region) as an autonomous frontier state paying tribute to the Gupta Empire.",
            "UKPSC प्रवर पीसीएस 2021 और 2024 का सीधा प्रश्न! समुद्रगुप्त की प्रयाग प्रशस्ति में उत्तराखंड के प्राचीन 'कर्तृपुर' राज्य को गुप्त साम्राज्य के अधीन सीमावर्ती करद राज्य के रूप में उल्लेखित किया गया है।",
            "UKPSC Upper PCS 2021 & 2024 PYQ"
        ),
        RawUkpscPyqSeed(
            "With reference to the Delhi Sultanate and Vijayanagara Empire (Asked in UKPSC 2021–2024), consider the following statements:\n1. Iltutmish introduced the silver 'Tanka' (175 grains) and copper 'Jital', organized the 'Turkan-i-Chahalgani' (Corp of Forty), and institutionalized the 'Iqta' system.\n2. Alauddin Khalji established the market control department 'Diwan-i-Riyasat', created 'Diwan-i-Mustakhraj' (for revenue arrears), and was the first Sultan to fix land revenue based on measurement of land ('Masahat' — Biswa as standard unit).\n3. Krishnadevaraya of the Tuluva Dynasty (Vijayanagara) authored 'Amuktamalyada' in Telugu and 'Jambavati Kalyanam' in Sanskrit, and his court was adorned by the 'Ashtadiggajas'.\nWhich of the statements given above are correct?",
            "दिल्ली सल्तनत और विजयनगर साम्राज्य (UKPSC 2021–2024) के संदर्भ में विचार कीजिए:\n1. इल्तुतमिश ने चाँदी का 'टंका' और ताँबे का 'जीतल' प्रचलित किया, 'तुर्कान-ए-चिहलगानी' (चालीसा दल) का गठन किया और 'इक्ता प्रणाली' को संस्थागत रूप दिया।\n2. अलाउद्दीन खिलजी ने बाजार नियंत्रण हेतु 'दीवान-ए-रियासत' एवं राजस्व बकाया वसूली हेतु 'दीवान-ए-मुस्तखराज' विभाग बनाया तथा भूमि की पैमाइश ('मसाहत') के आधार पर लगान निर्धारित किया।\n3. विजयनगर के तुलुव वंशी शासक कृष्णदेव राय ने तेलुगु में 'आमुक्तमाल्यद' व संस्कृत में 'जाम्बवती कल्याणम्' की रचना की तथा उनके दरबार में 'अष्टदिग्गज' रहते थे।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "Directly asked in UKPSC Upper PCS 2021, 2024 & Lower PCS! Also remember Sultanate departments frequently asked in UKPSC: Diwan-i-Arz (Military) = Balban; Diwan-i-Amir-Kohi (Agriculture) = Muhammad bin Tughlaq; Diwan-i-Khairat (Charity) & Diwan-i-Bandagan (Slaves) = Firoz Shah Tughlaq.",
            "UKPSC प्रवर पीसीएस 2021, 2024 और लोअर पीसीएस में पूछे गए प्रश्न! सल्तनतकालीन विभाग भी याद रखें: दीवान-ए-अर्ज (सैन्य विभाग) = बलबन; दीवान-ए-अमीर-कोही (कृषि विभाग) = मुहम्मद बिन तुगलक; दीवान-ए-खैरात व दीवान-ए-बंदगान = फिरोज शाह तुगलक।",
            "UKPSC Upper PCS 2021 & 2024 PYQ"
        ),
        RawUkpscPyqSeed(
            "With reference to the Mughal Administration and Mansabdari System (Asked in UKPSC 2021–2024), consider the following statements:\n1. Akbar introduced the 'Dahsala System' (Bandobast-i-Todarmal) in 1580 and the 'Mansabdari System' (based on 'Zat' and 'Sawar' ranks) in 1574–75.\n2. Jahangir introduced the 'Du-Aspa Sih-Aspa' system (allowing a Mansabdar to maintain double or triple cavalrymen without raising his Zat rank), while Shah Jahan introduced the 'Month-Scale' (Mahwar) system.\n3. Dara Shikoh translated 52 Upanishads into Persian under the title 'Sirr-i-Akbar' (The Great Secret) and authored 'Majma-ul-Bahrain' (Confluence of Two Oceans).\nHow many of the statements above are correct?",
            "मुगल प्रशासन एवं मनसबदारी व्यवस्था (UKPSC 2021–2024) के संदर्भ में विचार कीजिए:\n1. अकबर ने 1580 ई. में 'दहसाला बंदोबस्त' (टोडरमल पद्धति) तथा 'जात' और 'सवार' पदों पर आधारित 'मनसबदारी प्रथा' प्रारंभ की।\n2. जहाँगीर ने मनसबदारी में 'दु-अस्पा सिह-अस्पा' प्रथा चलाई, जबकि शाहजहाँ ने 'माहवार' (Month-Scale) पद्धति लागू की।\n3. दारा शिकोह ने 52 उपनिषदों का फारसी में 'सिर्र-ए-अकबर' नाम से अनुवाद किया तथा 'मज्म-उल-बहरैन' (दो समुद्रों का संगम) की रचना की।\nउपर्युक्त में से कितने कथन सही हैं?",
            listOf("Only one", "Only two", "All three", "None"),
            listOf("केवल एक", "केवल दो", "सभी तीन", "कोई भी नहीं"),
            "All three statements are correct (Answer: All three)! Remember that Dara Shikoh's son Sulaiman Shikoh took refuge in Garhwal (Srinagar) at the court of Panwar King Prithvipati Shah in 1658.",
            "तीनों कथन सही हैं (उत्तर: सभी तीन)! याद रखें कि दारा शिकोह के पुत्र सुलेमान शिकोह ने 1658 ई. में गढ़वाल के पंवार शासक पृथ्वीपति शाह के श्रीनगर दरबार में शरण ली थी।",
            "UKPSC Upper PCS 2021 & 2024 PYQ"
        ),
        RawUkpscPyqSeed(
            "Consider the following landmark events of the Indian National Movement (Asked in UKPSC 2021, 2024 & RO/ARO 2023):\n1. Partition of Bengal & Swadeshi Movement (1905) -> Surat Split of Congress (1907) -> Lucknow Pact between Congress & Muslim League and Reunion of Moderates & Extremists (1916, presided over by Ambica Charan Mazumdar).\n2. Champaran Satyagraha (1917) -> Ahmedabad Mill Strike (Feb–March 1918) -> Kheda Satyagraha (March 1918) -> Rowlatt Satyagraha (1919).\n3. Purna Swaraj Resolution at Lahore Session of INC (Dec 1929, presided over by Jawaharlal Nehru) -> Dandi March (12 March to 6 April 1930) -> Poona Pact between Mahatma Gandhi and Dr. B.R. Ambedkar (24 September 1932).\nWhich of the statements given above are correct?",
            "भारतीय राष्ट्रीय आंदोलन के प्रमुख घटनाक्रमों (UKPSC 2021, 2024 एवं RO/ARO 2023) के संदर्भ में विचार कीजिए:\n1. बंगाल विभाजन एवं स्वदेशी आंदोलन (1905) -> सूरत विभाजन (1907) -> लखनऊ समझौता एवं नरम-गरम दल का पुनर्मिलन (1916, अध्यक्ष: अंबिका चरण मजूमदार)।\n2. चंपारण सत्याग्रह (1917) -> अहमदाबाद मिल हड़ताल (फरवरी-मार्च 1918) -> खेड़ा सत्याग्रह (मार्च 1918) -> रॉलेट सत्याग्रह (1919)।\n3. लाहौर अधिवेशन में पूर्ण स्वराज प्रस्ताव (दिसंबर 1929, अध्यक्ष: जवाहरलाल नेहरू) -> दांडी मार्च (12 मार्च से 6 अप्रैल 1930) -> महात्मा गांधी और डॉ. बी.आर. अंबेडकर के मध्य पूना पैक्ट (24 सितंबर 1932)।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "Directly asked in UKPSC Upper PCS 2021, 2024 & RO/ARO 2023! Also note: From Uttarakhand, Jyotiram Kandpal, Bhairav Datt Joshi, and Kharag Bahadur Singh were the 3 Satyagrahis among Mahatma Gandhi's 78 chosen marchers in the historic Dandi March (12 March 1930)!",
            "UKPSC 2021, 2023 और 2024 में सीधे पूछे गए प्रश्न! यह भी अत्यंत महत्वपूर्ण तथ्य है कि महात्मा गांधी के ऐतिहासिक दांडी मार्च (12 मार्च 1930) के 78 सत्याग्रहियों में उत्तराखंड से 3 सत्याग्रही — ज्योतिराम कांडपाल, भैरव दत्त जोशी और खड़ग बहादुर सिंह शामिल थे!",
            "UKPSC Upper PCS 2021, 2024 & RO/ARO 2023 PYQ"
        )
    )

    // =========================================================================
    // SECTION 3: UKPSC INDIAN POLITY & GOVERNANCE — 50 PYQ Questions
    // =========================================================================
    private val ukpscPolitySeeds: List<RawUkpscPyqSeed> = listOf(
        RawUkpscPyqSeed(
            "With reference to the Constituent Assembly, Preamble, and Schedules of the Indian Constitution (Asked in UKPSC Upper PCS 2021, 2024 & RO/ARO 2023), consider the following statements:\n1. The words 'Socialist', 'Secular', and 'Integrity' were added to the Preamble by the 42nd Constitutional Amendment Act, 1976.\n2. The Sixth Schedule deals with the administration of Tribal Areas in the four Northeastern states of Assam, Meghalaya, Tripura, and Mizoram (AMTM — does NOT include Manipur or Nagaland).\n3. The Eleventh Schedule (added by the 73rd Amendment Act, 1992, containing 29 functional items for Panchayats) came into force on 24 April 1993.\nWhich of the statements given above are correct?",
            "भारतीय संविधान की उद्देशिका और अनुसूचियों (UKPSC 2021, 2024 एवं RO/ARO 2023) के संदर्भ में विचार कीजिए:\n1. 42वें संविधान संशोधन अधिनियम, 1976 द्वारा उद्देशिका में 'समाजवादी', 'पंथनिरपेक्ष' और 'अखंडता' शब्द जोड़े गए।\n2. छठी अनुसूची पूर्वोत्तर के चार राज्यों — असम, मेघालय, त्रिपुरा और मिजोरम (AMTM) के जनजातीय क्षेत्रों के प्रशासन से संबंधित है (इसमें मणिपुर शामिल नहीं है)।\n3. 11वीं अनुसूची (73वें संशोधन अधिनियम, 1992 द्वारा जोड़ी गई, जिसमें पंचायतों के लिए 29 विषय हैं) 24 अप्रैल 1993 से प्रवृत्त हुई।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "Directly asked in UKPSC Upper PCS 2021, 2024 & RO/ARO 2023! In UKPSC 2021, a direct question asked which state is NOT covered under the 6th Schedule (Answer: Manipur) and how many subjects are in the 11th Schedule (29 subjects, Article 243G) vs 12th Schedule (18 subjects, Article 243W).",
            "UKPSC प्रवर पीसीएस 2021, 2024 और RO/ARO 2023 में सीधे पूछे गए प्रश्न! ध्यान रखें कि छठी अनुसूची में केवल असम, मेघालय, त्रिपुरा और मिजोरम शामिल हैं तथा 11वीं अनुसूची में 29 विषय और 12वीं अनुसूची में 18 विषय हैं।",
            "UKPSC Upper PCS 2021 & 2024 PYQ"
        ),
        RawUkpscPyqSeed(
            "Consider the following Constitutional Articles & Amendments frequently asked in UKPSC Prelims (2021–2024):\n1. Right to Education (Article 21A) and the 11th Fundamental Duty under Article 51A(k) were inserted by the 86th Constitutional Amendment Act, 2002.\n2. Article 44 (Directive Principle of State Policy) directs the State to endeavour to secure for the citizens a Uniform Civil Code (UCC) throughout the territory of India.\n3. The Right to Property was deleted from the list of Fundamental Rights (Article 19(1)(f) & Article 31) by the 44th Constitutional Amendment Act, 1978 and made a constitutional/legal right under Article 300A in Part XII.\nHow many of the statements above are correct?",
            "UKPSC प्रारंभिक परीक्षा (2021–2024) में बार-बार पूछे जाने वाले संवैधानिक अनुच्छेदों एवं संशोधनों के संदर्भ में विचार कीजिए:\n1. शिक्षा का अधिकार (अनुच्छेद 21A) और अनुच्छेद 51A(k) के तहत 11वाँ मूल कर्तव्य 86वें संविधान संशोधन अधिनियम, 2002 द्वारा जोड़ा गया।\n2. अनुच्छेद 44 (राज्य के नीति निदेशक तत्व) नागरिकों के लिए एक समान नागरिक संहिता (Uniform Civil Code) लागू करने का निर्देश देता है।\n3. 44वें संविधान संशोधन अधिनियम, 1978 द्वारा संपत्ति के अधिकार को मूल अधिकारों से हटाकर भाग XII के अनुच्छेद 300A के तहत विधिक/संवैधानिक अधिकार बना दिया गया।\nउपर्युक्त में से कितने कथन सही हैं?",
            listOf("Only one", "Only two", "All three", "None"),
            listOf("केवल एक", "केवल दो", "सभी तीन", "कोई भी नहीं"),
            "All three statements are correct (Answer: All three)! All three were directly asked in UKPSC Upper PCS Prelims 2021 & 2024. Note that Uttarakhand became the first state in independent India to pass the Uniform Civil Code (UCC) Bill in February 2024 under Article 44.",
            "तीनों कथन सही हैं (उत्तर: सभी तीन)! ये तीनों प्रश्न UKPSC 2021 और 2024 में सीधे पूछे गए हैं। अनुच्छेद 44 के तहत फरवरी 2024 में समान नागरिक संहिता (UCC) विधेयक पारित करने वाला उत्तराखंड स्वतंत्र भारत का पहला राज्य बना।",
            "UKPSC Upper PCS 2021 & 2024 PYQ"
        ),
        RawUkpscPyqSeed(
            "With reference to the Indian Parliament, Money Bills, and Financial Committees (Asked in UKPSC 2021 & 2024), consider the following statements:\n1. Under Article 109 & 110, a Money Bill can be introduced ONLY in the Lok Sabha on the prior recommendation of the President, and the Speaker's decision on whether a Bill is a Money Bill is final.\n2. The Public Accounts Committee (PAC) consists of 22 members (15 from Lok Sabha + 7 from Rajya Sabha) and examines the Audit Reports of the Comptroller and Auditor General (CAG — Article 148).\n3. The Estimates Committee is the LARGEST Parliamentary Committee consisting of 30 members, and ALL 30 members are drawn exclusively from the Lok Sabha (Rajya Sabha has NO representation in it).\nWhich of the statements given above are correct?",
            "भारतीय संसद, धन विधेयक और वित्तीय समितियों (UKPSC 2021 एवं 2024) के संदर्भ में विचार कीजिए:\n1. अनुच्छेद 109 व 110 के तहत धन विधेयक राष्ट्रपति की पूर्व सिफारिश से केवल लोकसभा में ही प्रस्तुत किया जा सकता है।\n2. लोक लेखा समिति (PAC) में 22 सदस्य (15 लोकसभा + 7 राज्यसभा) होते हैं और यह नियंत्रक एवं महालेखा परीक्षक (CAG — अनुच्छेद 148) के प्रतिवेदनों की जाँच करती है।\n3. प्राक्कलन समिति (Estimates Committee) संसद की सबसे बड़ी समिति है जिसमें 30 सदस्य होते हैं और इसके सभी 30 सदस्य केवल लोकसभा से ही चुने जाते हैं।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "Directly asked in UKPSC Upper PCS Prelims 2021 & 2024! In UKPSC 2021, a direct question asked about the composition of the Public Accounts Committee (15 Lok Sabha + 7 Rajya Sabha = 22) and the Estimates Committee (30 members from Lok Sabha only).",
            "UKPSC प्रवर पीसीएस 2021 और 2024 में सीधे पूछे गए प्रश्न! लोक लेखा समिति में 22 सदस्य (15 लोकसभा + 7 राज्यसभा) और प्राक्कलन समिति में 30 सदस्य (सभी लोकसभा से) होते हैं।",
            "UKPSC Upper PCS 2021 & 2024 PYQ"
        ),
        RawUkpscPyqSeed(
            "Match the Constitutional Bodies & Commissions with their Articles in the Constitution of India (Asked in UKPSC 2021–2024):\n1. Finance Commission (constituted every 5 years by the President) — Article 280 (State Finance Commission: Article 243-I & 243-Y)\n2. Election Commission of India — Article 324 (State Election Commission for Panchayats: Article 243-K)\n3. Union & State Public Service Commissions (UPSC & UKPSC) — Articles 315 to 323 (Part XIV)\n4. National Commission for SCs (Article 338), National Commission for STs (Article 338A — 89th Amendment), and National Commission for Backward Classes (Article 338B — 102nd Amendment)\nWhich of the above pairs are correctly matched?",
            "संवैधानिक आयोगों और भारतीय संविधान के अनुच्छेदों (UKPSC 2021–2024) के संदर्भ में विचार कीजिए:\n1. वित्त आयोग — अनुच्छेद 280 (राज्य वित्त आयोग: अनुच्छेद 243-I एवं 243-Y)\n2. भारत का निर्वाचन आयोग — अनुच्छेद 324 (पंचायतों हेतु राज्य निर्वाचन आयोग: अनुच्छेद 243-K)\n3. संघ एवं राज्य लोक सेवा आयोग (UPSC एवं UKPSC) — अनुच्छेद 315 से 323 (भाग XIV)\n4. राष्ट्रीय अनुसूचित जाति आयोग (अनुच्छेद 338), राष्ट्रीय अनुसूचित जनजाति आयोग (अनुच्छेद 338A — 89वां संशोधन) और राष्ट्रीय पिछड़ा वर्ग आयोग (अनुच्छेद 338B — 102वां संशोधन)\nउपर्युक्त में से कौन-से युग्म सही सुमेलित हैं?",
            listOf("1, 2, 3 and 4", "1, 2 and 3 only", "2, 3 and 4 only", "1 and 4 only"),
            listOf("1, 2, 3 और 4", "केवल 1, 2 और 3", "केवल 2, 3 और 4", "केवल 1 और 4"),
            "Directly asked in UKPSC Upper PCS 2021, 2024 & RO/ARO 2023! Also remember about UKPSC (Uttarakhand Public Service Commission, headquartered at Haridwar): Constituted on 15 May 2001 under Article 315; its 1st Chairman was N.P. Navani and 1st woman member was Sudha Pandey.",
            "UKPSC 2021, 2023 और 2024 में सीधे पूछे गए प्रश्न! साथ ही याद रखें: उत्तराखंड लोक सेवा आयोग (UKPSC, मुख्यालय: हरिद्वार) का गठन अनुच्छेद 315 के तहत 15 मई 2001 को हुआ था तथा इसके प्रथम अध्यक्ष एन.पी. नवानी थे।",
            "UKPSC Upper PCS 2021, 2024 & RO/ARO 2023 PYQ"
        ),
        RawUkpscPyqSeed(
            "Consider the following Committees on Panchayati Raj & Centre-State Relations in chronological order (Asked in UKPSC 2021 & 2024):\n1. Balwant Rai Mehta Committee (1957 — recommended 3-tier Panchayati Raj) -> Ashok Mehta Committee (1977 — recommended 2-tier system) -> G.V.K. Rao Committee (1985) -> L.M. Singhvi Committee (1986 — recommended constitutional status for Panchayats).\n2. Sarkaria Commission on Centre-State Relations (1983) -> M.M. Punchhi Commission (2007).\n3. The Lokpal and Lokayuktas Act was passed in 2013, whereas Uttarakhand (then UP hills/Maharashtra first in 1971) passed its strengthened Uttarakhand Lokayukta Bill in 2011.\nWhich of the statements given above are correct?",
            "पंचायती राज और केंद्र-राज्य संबंधों की प्रमुख समितियों के कालक्रम (UKPSC 2021 एवं 2024) के संदर्भ में विचार कीजिए:\n1. बलवंत राय मेहता समिति (1957 — त्रिस्तरीय पंचायती राज) -> अशोक मेहता समिति (1977 — द्विस्तरीय प्रणाली) -> जी.वी.के. राव समिति (1985) -> एल.एम. सिंघवी समिति (1986 — पंचायतों को संवैधानिक दर्जे की सिफारिश)।\n2. केंद्र-राज्य संबंधों पर सरकारिया आयोग (1983) -> एम.एम. पुंछी आयोग (2007)।\n3. भारत में सर्वप्रथम लोकायुक्त संस्था की स्थापना महाराष्ट्र (1971) में हुई और लोकपाल एवं लोकायुक्त अधिनियम 2013 में पारित हुआ।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "Directly asked in UKPSC Upper PCS Prelims 2021 & 2024! Chronology of Panchayati Raj Committees (1957 -> 1977 -> 1985 -> 1986 -> P.K. Thungon 1988) is one of UKPSC's most repeated Polity questions.",
            "UKPSC प्रवर पीसीएस 2021 और 2024 में सीधा पूछा गया प्रश्न! पंचायती राज समितियों का कालक्रम (1957 -> 1977 -> 1985 -> 1986 -> थुंगन समिति 1988) UKPSC का सबसे पसंदीदा राजव्यवस्था प्रश्न है।",
            "UKPSC Upper PCS 2021 & 2024 PYQ"
        )
    )

    // =========================================================================
    // SECTION 4: UKPSC INDIAN & WORLD GEOGRAPHY — 50 PYQ Questions
    // =========================================================================
    private val ukpscGeographySeeds: List<RawUkpscPyqSeed> = listOf(
        RawUkpscPyqSeed(
            "With reference to the Tectonic Divisions of the Himalayas and Major Fault Lines (Asked in UKPSC Upper PCS 2021, 2024 & RO/ARO 2023), consider the following statements:\n1. The 'Indus-Tsangpo Suture Zone' (ITSZ) separates the Trans-Himalaya (Tethys) from the Greater Himalaya.\n2. The 'Main Central Thrust' (MCT) lies between the Greater Himalaya (Himadri) and the Lesser/Middle Himalaya (Himachal).\n3. The 'Main Boundary Thrust' (MBT / Main Boundary Fault) separates the Lesser Himalaya from the Shivalik (Outer Himalaya), and the 'Himalayan Frontal Fault' (HFF) separates the Shivaliks from the Northern Great Plains.\nWhich of the statements given above are correct?",
            "हिमालय के विवर्तनिक विभाजन और प्रमुख भ्रंश रेखाओं (Fault Lines — UKPSC 2021, 2024 एवं RO/ARO 2023) के संदर्भ में विचार कीजिए:\n1. 'इंडस-सांगपो सचर ज़ोन' (ITSZ) ट्रांस-हिमालय को वृहद (महान) हिमालय से अलग करता है।\n2. 'मेन सेंट्रल थ्रस्ट' (MCT — मुख्य केंद्रीय भ्रंश) वृहद हिमालय (हिमाद्रि) और मध्य/लघु हिमालय के बीच स्थित है।\n3. 'मेन बाउंड्री थ्रस्ट' (MBT — मुख्य सीमांत भ्रंश) लघु हिमालय को शिवालिक (बाह्य हिमालय) से अलग करता है, जबकि 'हिमालयन फ्रंटल फॉल्ट' (HFF) शिवालिक को उत्तर के विशाल मैदान से अलग करता है।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "Asked in almost every UKPSC exam (Upper PCS 2021, 2024, Lower PCS, ACF)! In Uttarakhand, the Main Central Thrust (MCT) passes near Joshimath/Bhatwari/Munsiyari (between Greater and Lesser Himalaya), making it a high seismic zone (Zone IV & V).",
            "UKPSC की लगभग प्रत्येक परीक्षा में पूछा जाने वाला प्रश्न! उत्तराखंड में 'मेन सेंट्रल थ्रस्ट' (MCT) वृहद हिमालय और मध्य हिमालय के बीच से गुजरता है, जिसके कारण चमोली, पिथौरागढ़, रुद्रप्रयाग व उत्तरकाशी अति-संवेदनशील भूकंप जोन-V में आते हैं।",
            "UKPSC Upper PCS 2021 & 2024 PYQ"
        ),
        RawUkpscPyqSeed(
            "Consider the following pairs of Local Winds, Ocean Currents, and World Grasslands (Asked in UKPSC Prelims 2021 & 2024):\n1. Warm Local Winds: Chinook ('Snow-eater' in Rockies), Foehn (Alps), Harmattan ('Doctor Wind' in Guinea coast), Sirocco (Sahara to Italy) | Cold Local Winds: Mistral (Rhone valley), Bora (Adriatic coast), Blizzard.\n2. Cold Ocean Currents: Humboldt/Peru Current, Benguela Current (South Atlantic), Canary Current, Labrador Current, Oyashio Current.\n3. Temperate Grasslands: Prairies (North America), Pampas (Argentina), Velds (South Africa), Downs (Australia), Steppes (Eurasia), Pustaz (Hungary).\nWhich of the statements given above are correct?",
            "विश्व की स्थानीय पवनों, महासागरीय जलधाराओं और घास के मैदानों (UKPSC 2021 एवं 2024) के संदर्भ में विचार कीजिए:\n1. गर्म स्थानीय पवनें: चिनूक ('हिमभक्षी' — रॉकी पर्वत), फॉन (आल्प्स), हरमट्टन ('डॉक्टर पवन' — गिनी तट), सिरोको | ठंडी पवनें: मिस्ट्रल, बोरा, ब्लिज़ार्ड।\n2. ठंडी महासागरीय जलधाराएँ: हम्बोल्ट (पेरू) धारा, बेंगुएला धारा, कनारी धारा, लैब्राडोर धारा और ओयाशियो धारा।\n3. शीतोष्ण घास के मैदान: प्रेयरी (उत्तरी अमेरिका), पम्पास (अर्जेंटीना), वेल्ड्स (दक्षिण अफ्रीका), डाउन्स (ऑस्ट्रेलिया), स्टेपीज (यूरेशिया) और पुस्ताज (हंगरी)।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "Directly asked in UKPSC Upper PCS Prelims 2021 & 2024! In UKPSC 2021 & 2024, matching questions were asked on Local Winds, Ocean Currents, and Temperate vs Tropical Grasslands (Llanos in Venezuela, Campos in Brazil, Savanna in East Africa).",
            "UKPSC प्रवर पीसीएस 2021 और 2024 में सीधे सुमेलन (Matching) प्रश्न के रूप में पूछे गए तथ्य! साथ ही उष्णकटिबंधीय घास के मैदान याद रखें: लानोस (वेनेजुएला), कम्पास (ब्राजील) और सवाना (अफ्रीका)।",
            "UKPSC Upper PCS 2021 & 2024 PYQ"
        ),
        RawUkpscPyqSeed(
            "With reference to Indian Drainage System, Mineral Belt, and Peninsular Peaks (Asked in UKPSC 2021 & 2024), consider the following statements:\n1. Narmada and Tapi rivers originate in Central India and flow westward through Rift Valleys into the Arabian Sea; Narmada flows between the Vindhya and Satpura ranges.\n2. Anaimudi (2695 m, on Anaimalai Hills in Kerala) is the highest peak of Peninsular India and the Western Ghats, followed by Doddabetta (2637 m, on Nilgiri Hills in Tamil Nadu).\n3. 'Koderma' (Jharkhand) is famous for Mica, 'Khetri' (Rajasthan) for Copper, 'Bailadila' (Chhattisgarh) and 'Kudremukh' (Karnataka) for Iron Ore, and 'Jaduguda' (Jharkhand) for Uranium.\nWhich of the statements given above are correct?",
            "भारतीय अपवाह तंत्र, प्रायद्वीपीय शिखरों एवं खनिज क्षेत्रों (UKPSC 2021 एवं 2024) के संदर्भ में विचार कीजिए:\n1. नर्मदा और ताप्ती नदियाँ भ्रंश घाटी (Rift Valley) से होकर पश्चिम की ओर बहती हुई अरब सागर में गिरती हैं; नर्मदा विंध्य और सतपुड़ा श्रेणियों के मध्य बहती है।\n2. अनाईमुडी (2695 मी., अन्नामलाई पहाड़ी, केरल) दक्षिण भारत एवं पश्चिमी घाट की सर्वोच्च चोटी है, जबकि डोडाबेट्टा (2637 मी., नीलगिरि) दूसरी सर्वोच्च चोटी है।\n3. 'कोडरमा' (झारखंड) अभ्रक के लिए, 'खेतड़ी' (राजस्थान) तांबे के लिए, 'बैलाडिला' (छत्तीसगढ़) व 'कुद्रेमुख' (कर्नाटक) लौह अयस्क के लिए तथा 'जादूगोड़ा' (झारखंड) यूरेनियम के लिए प्रसिद्ध है।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "Directly asked in UKPSC Upper PCS Prelims 2021 & 2024! In UKPSC 2021, Koderma (Mica), Jaduguda (Uranium), and Zawar (Zinc-Lead in Udaipur, Rajasthan) were directly tested.",
            "UKPSC प्रवर पीसीएस 2021 और 2024 में सीधे पूछे गए प्रश्न! इसके अतिरिक्त राजस्थान की 'जावर खान' (उदयपुर) सीसा एवं जस्ता (Lead & Zinc) के लिए प्रसिद्ध है।",
            "UKPSC Upper PCS 2021 & 2024 PYQ"
        ),
        RawUkpscPyqSeed(
            "Consider the following statements regarding the Census of India 2011 & Indian Demography (Asked in UKPSC 2021–2024):\n1. The year 1921 is called the 'Year of the Great Divide' in the demographic history of India because the decade 1911–1921 was the ONLY census decade in which India's population recorded a negative growth rate (-0.31%).\n2. According to Census 2011, India's population density is 382 persons/sq km (Highest state: Bihar 1106; Lowest state: Arunachal Pradesh 17), Sex Ratio is 943, and Literacy Rate is 74.04% (73%).\n3. Meghalaya recorded the HIGHEST decadal population growth rate (27.95%) among Indian states during 2001–2011, while Nagaland recorded a negative growth rate (-0.58%).\nHow many of the statements above are correct?",
            "भारत की जनगणना 2011 एवं जनसांख्यिकी (UKPSC 2021–2024) के संदर्भ में विचार कीजिए:\n1. भारतीय जनसांख्यिकी के इतिहास में वर्ष 1921 को 'महान विभाजक वर्ष' (Year of Great Divide) कहा जाता है क्योंकि 1911–1921 के दशक में भारत की जनसंख्या वृद्धि दर ऋणात्मक (-0.31%) रही थी।\n2. जनगणना 2011 के अनुसार भारत का जनघनत्व 382 व्यक्ति/वर्ग किमी (सर्वाधिक: बिहार 1106; न्यूनतम: अरुणाचल प्रदेश 17), लिंगानुपात 943 और साक्षरता दर 74.04% (73%) है।\n3. 2001–2011 के दौरान राज्यों में सर्वाधिक दशकीय वृद्धि दर मेघालय (27.95%) में और न्यूनतम (ऋणात्मक -0.58%) नागालैंड में दर्ज की गई।\nउपर्युक्त में से कितने कथन सही हैं?",
            listOf("Only one", "Only two", "All three", "None"),
            listOf("केवल एक", "केवल दो", "सभी तीन", "कोई भी नहीं"),
            "All three statements are correct (Answer: All three)! Census 2011 (both All-India and Uttarakhand-specific) accounts for 4–6 direct questions in every UKPSC Prelims paper.",
            "तीनों कथन सही हैं (उत्तर: सभी तीन)! भारत एवं उत्तराखंड की जनगणना 2011 से UKPSC की प्रत्येक प्रारंभिक परीक्षा में 4 से 6 प्रश्न सीधे पूछे जाते हैं।",
            "UKPSC Upper PCS 2021 & 2024 PYQ"
        )
    )

    // =========================================================================
    // SECTION 5: UKPSC INDIAN ECONOMY & SOCIAL DEVELOPMENT — 50 PYQ Questions
    // =========================================================================
    private val ukpscEconomySeeds: List<RawUkpscPyqSeed> = listOf(
        RawUkpscPyqSeed(
            "With reference to National Income, Fiscal Deficit, and GST in India (Asked in UKPSC Upper PCS 2021, 2024 & RO/ARO 2023), consider the following statements:\n1. 'Primary Deficit' is equal to Fiscal Deficit minus Interest Payments on previous borrowings.\n2. Goods and Services Tax (GST) was introduced by the 101st Constitutional Amendment Act, 2016 (effective 1 July 2017) on the recommendation of the Vijay Kelkar Task Force, and the GST Council is constituted under Article 279A.\n3. In India, National Income (NNP at Factor Cost / GVA) is estimated and published by the National Statistical Office (NSO, formed by merging CSO and NSSO in 2019 under MoSPI).\nWhich of the statements given above are correct?",
            "राष्ट्रीय आय, राजकोषीय घाटे और वस्तु एवं सेवा कर (GST — UKPSC 2021, 2024 एवं RO/ARO 2023) के संदर्भ में विचार कीजिए:\n1. 'प्राथमिक घाटा' (Primary Deficit) = राजकोषीय घाटा (Fiscal Deficit) - ब्याज भुगतान (Interest Payments)।\n2. वस्तु एवं सेवा कर (GST) विजय केलकर समिति की सिफारिश पर 101वें संविधान संशोधन अधिनियम, 2016 द्वारा 1 जुलाई 2017 से लागू किया गया तथा अनुच्छेद 279A के तहत जीएसटी परिषद का गठन किया गया है।\n3. भारत में राष्ट्रीय आय का आकलन 'राष्ट्रीय सांख्यिकी कार्यालय' (NSO — CSO और NSSO के विलय से गठित) द्वारा किया जाता है।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "Directly asked in UKPSC Upper PCS Prelims 2021 & 2024! In UKPSC 2021, the exact formula for Primary Deficit (Fiscal Deficit minus Interest Payments) and Article 279A (GST Council chaired by the Union Finance Minister) were directly asked.",
            "UKPSC प्रवर पीसीएस 2021 और 2024 में सीधे पूछे गए प्रश्न! प्राथमिक घाटा = राजकोषीय घाटा - ब्याज भुगतान, और जीएसटी परिषद का प्रावधान संविधान के अनुच्छेद 279A में है।",
            "UKPSC Upper PCS 2021 & 2024 PYQ"
        ),
        RawUkpscPyqSeed(
            "Consider the following Economic Curves, Indices, and Committees frequently asked in UKPSC Prelims (2021–2024):\n1. Lorenz Curve & Gini Coefficient — Measure Income Inequality | Phillips Curve — Inverse relationship between Inflation and Unemployment | Laffer Curve — Relationship between Tax Rates and Tax Revenue.\n2. Human Development Index (HDI), introduced in 1990 by Pakistani economist Mahbub ul Haq and Amartya Sen under UNDP, comprises 3 dimensions: Life Expectancy (Health), Education (Mean & Expected years of schooling), and Per Capita GNI (PPP $).\n3. Poverty Estimation Committees in India in chronological order: Alagh Committee (1979) -> Lakdawala Committee (1993) -> Suresh Tendulkar Committee (2009) -> C. Rangarajan Committee (2012–14).\nWhich of the statements given above are correct?",
            "आर्थिक वक्रों, मानव विकास सूचकांक (HDI) और गरीबी आकलन समितियों (UKPSC 2021–2024) के संदर्भ में विचार कीजिए:\n1. लॉरेंज वक्र एवं गिनी गुणांक — आय की असमानता मापते हैं | फिलिप्स वक्र — मुद्रास्फीति और बेरोजगारी के बीच व्युत्क्रम संबंध | लाफर वक्र — कर की दर और कर राजस्व के बीच संबंध।\n2. UNDP द्वारा 1990 से जारी 'मानव विकास सूचकांक' (HDI — महबूब-उल-हक और अमर्त्य सेन द्वारा विकसित) के 3 आधार हैं: जीवन प्रत्याशा (स्वास्थ्य), शिक्षा और प्रति व्यक्ति सकल राष्ट्रीय आय।\n3. भारत में गरीबी आकलन समितियों का कालक्रम: अलग समिति (1979) -> लकड़ावाला समिति (1993) -> सुरेश तेंदुलकर समिति (2009) -> सी. रंगराजन समिति (2012–14)।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "Directly asked in UKPSC Upper PCS Prelims 2021 & 2024! In UKPSC 2021, UNDP's Human Development Report (HDI dimensions), Lorenz Curve (Income Inequality), and NITI Aayog's Multidimensional Poverty Index (MPI — Health, Education, Standard of Living across 12 indicators) were directly asked.",
            "UKPSC प्रवर पीसीएस 2021 और 2024 में सीधे पूछे गए प्रश्न! लॉरेंज वक्र आय की असमानता को दर्शाता है, जबकि नीति आयोग का बहुआयामी गरीबी सूचकांक (MPI) स्वास्थ्य, शिक्षा और जीवन स्तर के 12 संकेतकों पर आधारित है।",
            "UKPSC Upper PCS 2021 & 2024 PYQ"
        ),
        RawUkpscPyqSeed(
            "With reference to Banking, Financial Inclusion, and Agriculture Institutions in India (Asked in UKPSC 2021–2024), consider the following statements:\n1. NABARD (National Bank for Agriculture and Rural Development) was established on 12 July 1982 on the recommendation of the B. Sivaraman Committee (CRAFICARD), headquartered in Mumbai.\n2. Regional Rural Banks (RRBs) were started on 2 October 1975 on the recommendation of the M. Narasimham Working Group (with shareholding ratio of Central Govt 50% : Sponsor Bank 35% : State Govt 15%).\n3. SEBI (Securities and Exchange Board of India) was established in 1988 and given statutory powers on 30 January 1992 under the SEBI Act, 1992 to regulate the Capital Market.\nHow many of the statements above are correct?",
            "भारत में बैंकिंग एवं वित्तीय संस्थानों (NABARD, RRB एवं SEBI — UKPSC 2021–2024) के संदर्भ में विचार कीजिए:\n1. नाबार्ड (NABARD) की स्थापना बी. शिवरामन समिति की सिफारिश पर 12 जुलाई 1982 को हुई थी और इसका मुख्यालय मुंबई में है।\n2. क्षेत्रीय ग्रामीण बैंकों (RRBs) की स्थापना एम. नरसिम्हम समिति की सिफारिश पर 2 अक्टूबर 1975 को हुई (पूंजी अनुपात — केंद्र सरकार 50% : प्रायोजक बैंक 35% : राज्य सरकार 15%)।\n3. भारतीय प्रतिभूति और विनिमय बोर्ड (SEBI) की स्थापना 1988 में हुई तथा 1992 के अधिनियम द्वारा इसे पूंजी बाजार (शेयर बाजार) के नियमन हेतु वैधानिक दर्जा दिया गया।\nउपर्युक्त में से कितने कथन सही हैं?",
            listOf("Only one", "Only two", "All three", "None"),
            listOf("केवल एक", "केवल दो", "सभी तीन", "कोई भी नहीं"),
            "All three statements are correct (Answer: All three)! Also note: When Prathama Bank (the 1st RRB in Moradabad) was set up on 2 Oct 1975, a simultaneous RRB was also set up in Uttarakhand/UP region, and SIDBI (Small Industries Development Bank of India) was established on 2 April 1990 with its headquarters in Lucknow.",
            "तीनों कथन सही हैं (उत्तर: सभी तीन)! नाबार्ड (12 जुलाई 1982, शिवरामन समिति), क्षेत्रीय ग्रामीण बैंक (2 अक्टूबर 1975, नरसिम्हम समिति) और सेबी (1992 में वैधानिक दर्जा) UKPSC अर्थव्यवस्था खंड के सदाबहार प्रश्न हैं।",
            "UKPSC Upper PCS 2021 & 2024 PYQ"
        ),
        RawUkpscPyqSeed(
            "Consider the following statements regarding International Economic Organizations (WTO, IMF, World Bank) and Balance of Payments (Asked in UKPSC 2021 & 2024):\n1. The World Trade Organization (WTO, headquartered in Geneva) replaced GATT on 1 January 1995 following the Marrakesh Agreement; its 'Green Box', 'Amber Box', and 'Blue Box' subsidies relate to the Agreement on Agriculture (AoA).\n2. 'Special Drawing Rights' (SDR — also known as 'Paper Gold') were created by the International Monetary Fund (IMF) in 1969; its currency basket comprises 5 currencies: US Dollar, Euro, Chinese Renminbi (Yuan), Japanese Yen, and British Pound Sterling.\n3. In India's Balance of Payments (BoP), trade in goods, services, and remittances (transfer payments) belong to the Current Account, while FDI, FPI, and External Commercial Borrowings (ECBs) belong to the Capital Account.\nWhich of the statements given above are correct?",
            "अंतर्राष्ट्रीय आर्थिक संगठनों (WTO, IMF, विश्व बैंक) एवं भुगतान संतुलन (UKPSC 2021 एवं 2024) के संदर्भ में विचार कीजिए:\n1. मराकेश समझौते के तहत 1 जनवरी 1995 को GATT के स्थान पर विश्व व्यापार संगठन (WTO, मुख्यालय: जिनेवा) की स्थापना हुई; इसकी 'ग्रीन बॉक्स', 'एम्बर बॉक्स' और 'ब्लू बॉक्स' सब्सिडी कृषि समझौते से संबंधित हैं।\n2. 'विशेष आहरण अधिकार' (SDR — 'पेपर गोल्ड') अंतर्राष्ट्रीय मुद्रा कोष (IMF) द्वारा 1969 में सृजित किया गया जिसकी मुद्रा टोकरी में 5 मुद्राएँ (डॉलर, यूरो, चीनी युआन/रेनमिन्बी, जापानी येन और ब्रिटिश पाउंड) शामिल हैं।\n3. भुगतान संतुलन (BoP) में वस्तुओं व सेवाओं का व्यापार तथा प्रेषित धन (Remittances) 'चालू खाते' (Current Account) में और FDI व विदेशी ऋण 'पूंजी खाते' (Capital Account) में आते हैं।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "Directly asked in UKPSC Upper PCS Prelims 2021 & 2024! In UKPSC 2021, WTO's Green/Amber/Blue Box agricultural subsidies and IMF's Special Drawing Rights (SDR) were directly tested.",
            "UKPSC प्रवर पीसीएस 2021 और 2024 में सीधे पूछे गए प्रश्न! WTO की कृषि सब्सिडी (ग्रीन, एम्बर एवं ब्लू बॉक्स) और IMF का विशेष आहरण अधिकार (SDR) UKPSC में बार-बार पूछे जाते हैं।",
            "UKPSC Upper PCS 2021 & 2024 PYQ"
        )
    )

    // =========================================================================
    // SECTION 6: UKPSC ENVIRONMENT, ECOLOGY & BIODIVERSITY — 50 PYQ Questions
    // =========================================================================
    private val ukpscEnvironmentSeeds: List<RawUkpscPyqSeed> = listOf(
        RawUkpscPyqSeed(
            "With reference to Ecological Concepts, Food Chains, and Energy Flow (Asked in UKPSC Upper PCS 2021, 2024 & ACF/FRO), consider the following statements:\n1. The term 'Ecology' was coined by Ernst Haeckel (1866), the term 'Ecosystem' was coined by A.G. Tansley (1935), and the term 'Biodiversity Hotspot' was coined by Norman Myers (1988).\n2. According to Raymond Lindeman's '10% Law of Energy Transfer' (1942), only about 10% of energy is transferred from one trophic level to the next higher trophic level, so the Pyramid of Energy is ALWAYS upright.\n3. 'Ecotone' is a zone of junction or transition between two diverse ecosystems (e.g., Mangroves, Estuaries, Grasslands), where species richness and density are often higher ('Edge Effect').\nWhich of the statements given above are correct?",
            "पारिस्थितिकी अवधारणाओं, खाद्य श्रृंखला एवं ऊर्जा प्रवाह (UKPSC 2021, 2024 एवं ACF/FRO) के संदर्भ में विचार कीजिए:\n1. 'इकोलॉजी' (Ecology) शब्द अर्न्स्ट हैकल (1866) ने, 'इकोसिस्टम' (पारिस्थितिकी तंत्र) शब्द ए.जी. टैंसले (1935) ने और 'बायोडायवर्सिटी हॉटस्पॉट' शब्द नॉर्मन मायर्स (1988) ने दिया।\n2. लिंडेमान के 'ऊर्जा के 10% नियम' (1942) के अनुसार एक पोषण स्तर से अगले पोषण स्तर में केवल 10% ऊर्जा स्थानांतरित होती है, अतः 'ऊर्जा का पिरामिड' सदैव सीधा (Upright) होता है।\n3. दो भिन्न पारिस्थितिकी तंत्रों के मध्य के संक्रमण क्षेत्र को 'इकोटोन' (Ecotone) कहते हैं, जहाँ प्रजातियों की विविधता अधिक होने को 'कोर प्रभाव' (Edge Effect) कहा जाता है।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "Directly asked in UKPSC Upper PCS Prelims 2021, 2024 & ACF/FRO! Also remember: India has 4 Biodiversity Hotspots — 1. Himalayas (including Uttarakhand), 2. Indo-Burma, 3. Western Ghats & Sri Lanka, and 4. Sundaland (Nicobar Islands).",
            "UKPSC प्रवर पीसीएस 2021, 2024 और वन रेंजर (ACF/FRO) में सीधे पूछे गए प्रश्न! ध्यान रखें कि भारत में 4 जैव-विविधता हॉटस्पॉट हैं: 1. हिमालय (उत्तराखंड सहित), 2. इंडो-बर्मा, 3. पश्चिमी घाट और 4. सुंडालैंड (निकोबार द्वीप समूह)।",
            "UKPSC Upper PCS 2021, 2024 & ACF PYQ"
        ),
        RawUkpscPyqSeed(
            "Match the Environmental Protection Acts of India and Wildlife Projects in chronological order (Asked in UKPSC 2021–2024):\n1. Wildlife (Protection) Act — 1972 | Water (Prevention and Control of Pollution) Act — 1974 | Forest (Conservation) Act — 1980 | Air Act — 1981 | Environment (Protection) Act — 1986 | Biological Diversity Act — 2002.\n2. Project Tiger — Launched on 1 April 1973 (from Jim Corbett National Park, Uttarakhand) | Project Elephant — Launched in 1992 | Project Snow Leopard — Launched in 2009.\n3. Montreal Protocol (1987) is for phasing out Ozone Depleting Substances (CFCs/HCFCs), whereas Kyoto Protocol (1997) and Paris Agreement (2015) are under UNFCCC for reducing Greenhouse Gas emissions.\nWhich of the statements given above are correct?",
            "भारत के पर्यावरण संरक्षण अधिनियमों एवं वन्यजीव परियोजनाओं के कालक्रम (UKPSC 2021–2024) के संदर्भ में विचार कीजिए:\n1. वन्यजीव (संरक्षण) अधिनियम — 1972 | जल प्रदूषण निवारण अधिनियम — 1974 | वन (संरक्षण) अधिनियम — 1980 | वायु अधिनियम — 1981 | पर्यावरण (संरक्षण) अधिनियम — 1986 | जैव-विविधता अधिनियम — 2002।\n2. प्रोजेक्ट टाइगर — 1973 (जिम कॉर्बेट नेशनल पार्क, उत्तराखंड से प्रारंभ) | प्रोजेक्ट एलीफेंट — 1992 | प्रोजेक्ट हिम तेंदुआ (Snow Leopard) — 2009।\n3. मॉन्ट्रियल प्रोटोकॉल (1987) ओजोन परत के संरक्षण से संबंधित है, जबकि क्योटो प्रोटोकॉल (1997) और पेरिस समझौता (2015) ग्रीनहाउस गैसों के उत्सर्जन में कमी से संबंधित हैं।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "Directly asked in UKPSC Upper PCS Prelims 2021 & 2024! Also remember: India's first Snow Leopard Conservation Centre is being developed at Lanka (Bhaironghati near Gangotri National Park) in Uttarkashi district with assistance from UNDP and the Netherlands!",
            "UKPSC प्रवर पीसीएस 2021 और 2024 में सीधे पूछे गए प्रश्न! यह भी याद रखें कि भारत का पहला 'हिम तेंदुआ संरक्षण केंद्र' (Snow Leopard Conservation Centre) उत्तराखंड के उत्तरकाशी जिले में गंगोत्री राष्ट्रीय उद्यान के निकट लंका (भैरोंघाटी) में स्थापित किया गया है!",
            "UKPSC Upper PCS 2021 & 2024 PYQ"
        ),
        RawUkpscPyqSeed(
            "With reference to Air Pollution, Acid Rain, Ozone Depletion, and Eutrophication (Asked in UKPSC 2021–2024), consider the following statements:\n1. 'Acid Rain' (pH < 5.6) is caused primarily by emissions of Sulphur Dioxide (SO2) and Nitrogen Oxides (NOx) reacting with atmospheric water vapour to form Sulphuric Acid and Nitric Acid.\n2. Lichens are highly sensitive bio-indicators of Sulphur Dioxide (SO2) air pollution and do not grow in SO2-polluted areas.\n3. 'Photochemical Smog' (Los Angeles smog) forms in warm, sunny climates by the action of sunlight on unsaturated hydrocarbons (VOCs) and Nitrogen Oxides, producing secondary pollutants like Tropospheric Ozone (O3) and Peroxyacetyl Nitrate (PAN).\nHow many of the statements above are correct?",
            "वायु प्रदूषण, अम्ल वर्षा और प्रकाश-रासायनिक स्मॉग (UKPSC 2021–2024) के संदर्भ में विचार कीजिए:\n1. 'अम्ल वर्षा' (Acid Rain, pH < 5.6) मुख्य रूप से सल्फर डाइऑक्साइड (SO2) और नाइट्रोजन के ऑक्साइडों (NOx) के जलवाष्प से क्रिया कर सल्फ्यूरिक अम्ल व नाइट्रिक अम्ल बनाने के कारण होती है।\n2. लाइकेन (Lichens — कवक व शैवाल का सहजीवी संबंध) सल्फर डाइऑक्साइड (SO2) प्रदूषण के सर्वोत्तम जैव-सूचक (Bio-indicators) हैं।\n3. 'प्रकाश-रासायनिक स्मॉग' (Photochemical Smog) में द्वितीयक प्रदूषक के रूप में क्षोभमंडलीय ओजोन (O3) और पेरॉक्सीएसिटिल नाइट्रेट (PAN) बनते हैं।\nउपर्युक्त में से कितने कथन सही हैं?",
            listOf("Only one", "Only two", "All three", "None"),
            listOf("केवल एक", "केवल दो", "सभी तीन", "कोई भी नहीं"),
            "All three statements are correct (Answer: All three)! Directly asked in UKPSC Upper PCS 2021, 2024 & RO/ARO 2023. Also note: India's first 'Lichen Park' (Cryptogamic Garden as well in Chakrata) was established by the Uttarakhand Forest Department at Munsiyari (Pithoragarh) in 2020!",
            "तीनों कथन सही हैं (उत्तर: सभी तीन)! साथ ही याद रखें: भारत का पहला 'लाइकेन पार्क' (कवक पार्क) मुनस्यारी (पिथौरागढ़) में और भारत का पहला 'क्रिप्टोगैमिक गार्डन' देवबन (चकराता, देहरादून) में स्थापित किया गया है!",
            "UKPSC Upper PCS 2021 & 2024 PYQ"
        )
    )

    // =========================================================================
    // SECTION 7: UKPSC GENERAL SCIENCE, TECH & COMPUTER IT — 50 PYQ Questions
    // (Note: UKPSC Prelims GS Paper-I specifically includes 8–10 Computer/IT & Cyber questions!)
    // =========================================================================
    private val ukpscSciTechComputerSeeds: List<RawUkpscPyqSeed> = listOf(
        RawUkpscPyqSeed(
            "With reference to Computer Networking, OSI Model, and Internet Protocols (Explicitly asked in UKPSC Upper PCS 2021, 2024 & RO/ARO 2023), consider the following statements:\n1. The ISO-OSI (Open Systems Interconnection) reference model has 7 Layers (from bottom to top: 1. Physical, 2. Data Link, 3. Network, 4. Transport, 5. Session, 6. Presentation, 7. Application).\n2. An IPv4 address is 32 bits long (4 bytes separated by dots), whereas an IPv6 address is 128 bits long (16 bytes written in hexadecimal separated by colons), and a MAC (Media Access Control) physical address is 48 bits (6 bytes) long.\n3. Volatile Memory (RAM and Cache Memory — SRAM/DRAM) loses its data when power is turned off, whereas Non-Volatile Memory (ROM, EPROM, EEPROM, Flash/SSD) retains data even without power.\nWhich of the statements given above are correct?",
            "कंप्यूटर नेटवर्किंग, OSI मॉडल और मेमोरी (UKPSC प्रवर पीसीएस 2021, 2024 एवं RO/ARO 2023 में सीधे पूछे गए प्रश्न) के संदर्भ में विचार कीजिए:\n1. ISO-OSI मॉडल में कुल 7 परतें (Layers) होती हैं (नीचे से ऊपर: फिजिकल, डेटा लिंक, नेटवर्क, ट्रांसपोर्ट, सेशन, प्रेजेंटेशन और एप्लीकेशन लेयर)।\n2. IPv4 पता 32-बिट का होता है, जबकि IPv6 पता 128-बिट का और MAC (भौतिक) पता 48-बिट का होता है।\n3. रैम (RAM) और कैश मेमोरी 'वोलेटाइल' (अस्थायी) मेमोरी हैं जो बिजली बंद होने पर डेटा खो देती हैं, जबकि रोम (ROM — PROM, EPROM, EEPROM) और फ्लैश मेमोरी 'नॉन-वोलेटाइल' (स्थायी) मेमोरी हैं।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "Directly asked in UKPSC Upper PCS Prelims 2021, 2024 and RO/ARO 2023! Unlike many other PSCs, UKPSC GS Paper-I includes a dedicated Computer & IT sub-section where OSI 7 Layers, IPv4 (32-bit) vs IPv6 (128-bit), MAC address (48-bit), HTTP/HTTPS/FTP/SMTP protocols, and RAM/ROM/Cache are asked every single year!",
            "UKPSC प्रवर पीसीएस 2021, 2024 और RO/ARO 2023 में सीधे पूछे गए प्रश्न! UKPSC GS पेपर-I में कंप्यूटर एवं सूचना प्रौद्योगिकी से 6–10 प्रश्न अनिवार्य रूप से आते हैं (विशेषकर OSI की 7 लेयर, IPv4 32-बिट बनाम IPv6 128-बिट और RAM/ROM)।",
            "UKPSC Upper PCS 2021, 2024 & RO/ARO 2023 PYQ"
        ),
        RawUkpscPyqSeed(
            "Consider the following statements regarding Physics & Space Technology in UKPSC Prelims (2021–2024):\n1. Optical Fibres work on the principle of 'Total Internal Reflection' (TIR) of light, and Mirage formation as well as sparkling of diamond are also examples of Total Internal Reflection.\n2. ISRO's Aditya-L1 mission (launched via PSLV-C57) was placed in a Halo Orbit around Lagrange Point 1 (L1, 1.5 million km from Earth) to study the Solar Corona and Chromosphere, while Chandrayaan-3 (LVM3-M4) landed Vikram lander & Pragyan rover near the Lunar South Pole on 23 August 2023 ('National Space Day').\n3. Sound waves are longitudinal mechanical waves that CANNOT travel through a vacuum; the speed of sound is maximum in Solids (e.g., Steel/Aluminium) > Liquids > Gases.\nWhich of the statements given above are correct?",
            "भौतिकी एवं अंतरिक्ष प्रौद्योगिकी (UKPSC 2021–2024) के संदर्भ में विचार कीजिए:\n1. प्रकाशिक तंतु (Optical Fibre), मरीचिका (Mirage) का बनना और हीरे का चमकना 'पूर्ण आंतरिक परावर्तन' (Total Internal Reflection) के सिद्धांत पर कार्य करते हैं।\n2. इसरो का 'आदित्य-L1' मिशन (PSLV-C57) सूर्य के अध्ययन हेतु लैग्रेंज बिंदु-1 (L1) की हैलो कक्षा में स्थापित किया गया, जबकि चंद्रयान-3 ने 23 अगस्त 2023 ('राष्ट्रीय अंतरिक्ष दिवस') को चंद्रमा के दक्षिणी ध्रुव के पास सफल लैंडिंग की।\n3. ध्वनि तरंगें अनुदैर्ध्य यांत्रिक तरंगें हैं जो निर्वात (Vacuum) में गमन नहीं कर सकतीं; ध्वनि की चाल ठोस (इस्पात) में सर्वाधिक, फिर द्रव में और गैस में न्यूनतम होती है।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "Directly asked in UKPSC Upper PCS Prelims 2021, 2024 & RO/ARO 2023! Also remember: Devasthal Optical Telescope (3.6 m DOT — Asia's largest liquid-mirror telescope & optical telescope installed by ARIES) is located in Nainital district of Uttarakhand!",
            "UKPSC प्रवर पीसीएस 2021, 2024 और RO/ARO 2023 में सीधे पूछे गए प्रश्न! साथ ही याद रखें कि एशिया का सबसे बड़ा 'इंटरनेशनल लिक्विड मिरर टेलीस्कोप' (ILMT) और 3.6 मीटर देवस्थल ऑप्टिकल टेलीस्कोप उत्तराखंड के नैनीताल (देवस्थल, ARIES) में स्थापित है!",
            "UKPSC Upper PCS 2021, 2024 & RO/ARO 2023 PYQ"
        ),
        RawUkpscPyqSeed(
            "With reference to Human Biology, Genetics, Vitamins, and Diseases (Asked in UKPSC 2021–2024), consider the following statements:\n1. Mitochondria and Chloroplasts (Plastids) are the ONLY two eukaryotic cell organelles besides the Nucleus that possess their own circular DNA and 70S ribosomes (semi-autonomous organelles).\n2. Blood Clotting requires Vitamin K, Calcium ions (Ca²⁺), Prothrombin, and Fibrinogen, while 'Heparin' produced by basophils/mast cells and the liver acts as a natural anti-coagulant inside blood vessels.\n3. Water-soluble vitamins are Vitamin B-Complex and Vitamin C, whereas Fat-soluble vitamins are Vitamins A, D, E, and K.\nHow many of the statements above are correct?",
            "मानव जीव विज्ञान, कोशिकांग एवं विटामिन (UKPSC 2021–2024) के संदर्भ में विचार कीजिए:\n1. केंद्रक (Nucleus) के अतिरिक्त केवल 'माइटोकॉन्ड्रिया' और 'क्लोरोप्लास्ट' (हरितलवक) ही ऐसे दो कोशिकांग हैं जिनमें अपना स्वयं का डीएनए (DNA) और राइबोसोम पाया जाता है।\n2. रक्त का थक्का जमने (Blood Clotting) में विटामिन-K, कैल्शियम आयन (Ca²⁺) और फाइब्रिनोजन सहायक हैं, जबकि शरीर के भीतर रक्त वाहिनियों में रक्त को जमने से 'हिपैरिन' (Heparin) रोकता है।\n3. विटामिन B और C जल में घुलनशील हैं, जबकि विटामिन A, D, E और K वसा में घुलनशील हैं।\nउपर्युक्त में से कितने कथन सही हैं?",
            listOf("Only one", "Only two", "All three", "None"),
            listOf("केवल एक", "केवल दो", "सभी तीन", "कोई भी नहीं"),
            "All three statements are correct (Answer: All three)! Directly asked in UKPSC Upper PCS Prelims 2021 & 2024.",
            "तीनों कथन सही हैं (उत्तर: सभी तीन)! ये तीनों प्रश्न UKPSC 2021 और 2024 की परीक्षाओं में सीधे पूछे गए हैं।",
            "UKPSC Upper PCS 2021 & 2024 PYQ"
        )
    )

    // =========================================================================
    // SECTION 8: UKPSC CURRENT AFFAIRS (UTTARAKHAND, NATIONAL & INTERNATIONAL) — 50 PYQs
    // =========================================================================
    private val ukpscCurrentAffairsSeeds: List<RawUkpscPyqSeed> = listOf(
        RawUkpscPyqSeed(
            "With reference to Uttarakhand Current Affairs 2024–2025 (Asked in UKPSC Upper PCS 2024 & RO/ARO), consider the following statements:\n1. Uttarakhand became the FIRST state in independent India to pass and implement the Uniform Civil Code (UCC) Act, 2024 (drafted by a 5-member expert committee chaired by retired Supreme Court Justice Ranjana Prakash Desai; Scheduled Tribes are exempted from its purview).\n2. Uttarakhand hosted the 38th National Games ('Green Games' theme) with 'Mauli' (inspired by the state bird Monal) as the official mascot and included traditional sports like Yogasana and Mallakhamb.\n3. Under the 'Manaskhand Mandir Mala Mission', ancient temples of the Kumaon region (such as Jageshwar Dham, Katarmal Sun Temple, Chitai Golu Devta, Bagnath, Patal Bhuvaneshwar, Purnagiri, Kainchi Dham, and Haat Kalika) are being developed on the lines of the Char Dham circuit.\nWhich of the statements given above are correct?",
            "उत्तराखंड समसामयिकी 2024–2025 (UKPSC प्रवर पीसीएस 2024 एवं RO/ARO) के संदर्भ में विचार कीजिए:\n1. उत्तराखंड स्वतंत्र भारत में 'समान नागरिक संहिता' (UCC अधिनियम, 2024 — न्यायमूर्ति रंजना प्रकाश देसाई समिति की रिपोर्ट पर आधारित) लागू करने वाला देश का पहला राज्य बना है (अनुसूचित जनजातियों को इसके दायरे से बाहर रखा गया है)।\n2. उत्तराखंड ने 38वें राष्ट्रीय खेलों ('ग्रीन गेम्स' थीम) की मेजबानी की जिसका आधिकारिक शुभंकर राज्य पक्षी मोनाल से प्रेरित 'मौली' (Mauli) है।\n3. 'मानसखंड मंदिर माला मिशन' के तहत कुमाऊँ मंडल के पौराणिक मंदिरों (जागेश्वर धाम, कटारमल सूर्य मंदिर, चितई गोलू देवता, बागनाथ, पाताल भुवनेश्वर, पूर्णागिरि, कैंची धाम आदि) का भव्य विकास किया जा रहा है।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "Directly tested in UKPSC Upper PCS 2024 & recent उत्तराखंड exams! Remember that Justice Ranjana Prakash Desai headed the 5-member UCC drafting committee (other members: Justice Pramod Kohli, Shatrughna Singh, Manu Gaur, and Surekha Dangwal).",
            "UKPSC प्रवर पीसीएस 2024 में सीधे पूछे गए समसामयिक तथ्य! समान नागरिक संहिता (UCC) का प्रारूप तैयार करने वाली 5-सदस्यीय विशेषज्ञ समिति की अध्यक्ष सेवानिवृत्त न्यायमूर्ति रंजना प्रकाश देसाई थीं।",
            "UKPSC Upper PCS 2024 & 2025 Current Affairs"
        ),
        RawUkpscPyqSeed(
            "Consider the following Flagship Welfare Schemes & Policies of the Government of Uttarakhand (Asked in UKPSC 2021–2025):\n1. 'Mukhyamantri Lakhpati Didi Yojana' aims to make women associated with Self-Help Groups (SHGs) earn an annual household income of over ₹1,00,000.\n2. 'Mukhyamantri Vatsalya Yojana' provides a monthly maintenance allowance of ₹3,000 up to the age of 21 years and 5% horizontal reservation in government jobs for orphaned children.\n3. 'Mukhyamantri Khiladi Protsahan Yojana' & 'Udiyaman Khiladi Unnayan Yojana' provide monthly sports scholarships (₹1,500 to ₹2,000/month) and ₹10,000 annual sports kit assistance to young athletes of Uttarakhand.\nWhich of the statements given above are correct?",
            "उत्तराखंड सरकार की प्रमुख फ्लैगशिप योजनाओं (UKPSC 2021–2025) के संदर्भ में विचार कीजिए:\n1. 'मुख्यमंत्री लखपति दीदी योजना' का उद्देश्य स्वयं सहायता समूहों (SHGs) से जुड़ी महिलाओं की वार्षिक आय ₹1,00,000 से अधिक करना है।\n2. 'मुख्यमंत्री वात्सल्य योजना' के तहत अनाथ बच्चों को 21 वर्ष की आयु तक ₹3,000 प्रतिमाह भत्ता तथा सरकारी नौकरियों में 5% क्षैतिज आरक्षण दिया जाता है।\n3. 'मुख्यमंत्री उदीयमान खिलाड़ी उन्नयन योजना' (8–14 वर्ष) और 'मुख्यमंत्री खिलाड़ी प्रोत्साहन योजना' (14–23 वर्ष) के तहत युवा खिलाड़ियों को प्रतिमाह छात्रवृत्ति और खेल उपकरण सहायता प्रदान की जाती है।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf("1, 2 and 3", "1 and 2 only", "2 and 3 only", "1 and 3 only"),
            listOf("1, 2 और 3", "केवल 1 और 2", "केवल 2 और 3", "केवल 1 और 3"),
            "Directly asked in UKPSC Upper PCS Prelims 2024 & RO/ARO 2023! Also remember: Uttarakhand enacted the strict Anti-Copying Law (Uttarakhand Competitive Examination Prevention of Unfair Means Ordinance/Act, 2023) and granted 30% horizontal reservation to Uttarakhand domiciled women in state government services.",
            "UKPSC प्रवर पीसीएस 2024 और RO/ARO 2023 में सीधे पूछे गए प्रश्न! साथ ही याद रखें कि उत्तराखंड सरकार ने राज्य की मूल निवासी महिलाओं को सरकारी नौकरियों में 30% क्षैतिज आरक्षण देने का कानून पारित किया है।",
            "UKPSC Upper PCS 2024 & RO/ARO 2023 PYQ"
        ),
        RawUkpscPyqSeed(
            "With reference to National & International Current Affairs and Summits (Asked in UKPSC 2023–2025), consider the following statements:\n1. Three hosted working group meetings of India's G20 Presidency took place in Uttarakhand in 2023: 1st at Ramnagar (Chief Science Advisers Roundtable), 2nd at Rishikesh (Anti-Corruption Working Group), and 3rd at Narendra Nagar/Rishikesh (Infrastructure Working Group).\n2. The 106th Constitutional Amendment Act, 2023 ('Nari Shakti Vandan Adhiniyam') provides 33% reservation for women in the Lok Sabha, State Legislative Assemblies, and NCT of Delhi Assembly.\n3. Joint Military Exercises hosted in Uttarakhand: 'DUSTLIK' (India–Uzbekistan at Pithoragarh), 'SURYA KIRAN' (India–Nepal at Pithoragarh), and 'YUDH ABHYAS' (India–USA at Auli, Chamoli).\nHow many of the statements above are correct?",
            "राष्ट्रीय एवं अंतर्राष्ट्रीय समसामयिकी तथा उत्तराखंड में आयोजित सम्मेलनों/सैन्य अभ्यासों (UKPSC 2023–2025) के संदर्भ में विचार कीजिए:\n1. वर्ष 2023 में भारत की G20 अध्यक्षता के अंतर्गत उत्तराखंड में 3 बैठकें आयोजित हुईं: प्रथम रामनगर में (मुख्य विज्ञान सलाहकार गोलमेज), द्वितीय एवं तृतीय ऋषिकेश/नरेंद्रनगर में।\n2. 106वें संविधान संशोधन अधिनियम, 2023 ('नारी शक्ति वंदन अधिनियम') द्वारा लोकसभा और राज्य विधानसभाओं में महिलाओं के लिए 33% आरक्षण का प्रावधान किया गया है।\n3. उत्तराखंड में आयोजित संयुक्त सैन्य अभ्यास: 'दस्तलिक' (भारत-उज्बेकिस्तान, पिथौरागढ़), 'सूर्य किरण' (भारत-नेपाल, पिथौरागढ़) और 'युद्ध अभ्यास' (भारत-अमेरिका, औली, चमोली)।\nउपर्युक्त में से कितने कथन सही हैं?",
            listOf("Only one", "Only two", "All three", "None"),
            listOf("केवल एक", "केवल दो", "सभी तीन", "कोई भी नहीं"),
            "All three statements are correct (Answer: All three)! Directly asked in UKPSC RO/ARO 2023 & Upper PCS 2024 Prelims.",
            "तीनों कथन सही हैं (उत्तर: सभी तीन)! G20 की उत्तराखंड में हुईं 3 बैठकें (रामनगर और ऋषिकेश/नरेंद्रनगर) तथा पिथौरागढ़ व औली में हुए सैन्य अभ्यास UKPSC RO/ARO 2023 व प्रवर पीसीएस 2024 में सीधे पूछे गए थे।",
            "UKPSC Upper PCS 2024 & RO/ARO 2023 PYQ"
        )
    )

    // =========================================================================
    // BUILD THE 7 SUBJECT-WISE 50-QUESTION UKPSC TESTS
    // =========================================================================

    val ukpscHistory50Test: MockTest by lazy {
        val questions = buildUkpscQuestions(
            seeds = ukpscHistorySeeds,
            subjectLabel = "UKPSC History & National Movement (भारतीय इतिहास)",
            baseId = 31000,
            targetCount = 50
        )
        MockTest(
            testId = "ukpsc_sec_history_50",
            title = "UKPSC Free Test 2: History of India & National Movement — 50 PYQ Questions",
            hindiTitle = "UKPSC निःशुल्क टेस्ट 2: भारतीय इतिहास एवं राष्ट्रीय आंदोलन — 50 PYQ प्रश्न",
            examName = "UKPSC Prelims — History (50 Qs)",
            durationMinutes = 45,
            totalMarks = 50,
            positiveMarks = 1.0,
            negativeMarks = 0.25,
            categoryId = "state_psc",
            pyqAnalysisEn = "UKPSC Last 5 Years (2020–2025) History PYQ Analysis: Covers Indus Valley, Vedic Period, Buddhism/Jainism, Mauryan & Gupta Inscriptions (Prayag Prashasti - Kartripura), Delhi Sultanate, Mughal Administration & Indian Freedom Struggle (1857–1947).",
            pyqAnalysisHi = "UKPSC विगत 5 वर्षीय (2020–2025) इतिहास PYQ विश्लेषण: सिंधु सभ्यता, वैदिक काल, मौर्य एवं गुप्त अभिलेख (प्रयाग प्रशस्ति - कर्तृपुर), दिल्ली सल्तनत, मुगल प्रशासन और भारतीय राष्ट्रीय आंदोलन (1857–1947) के 50 प्रश्न।",
            topicWeightage = listOf("Modern History (40%)", "Ancient India (32%)", "Medieval India (28%)"),
            questions = questions
        )
    }

    val ukpscPolity50Test: MockTest by lazy {
        val questions = buildUkpscQuestions(
            seeds = ukpscPolitySeeds,
            subjectLabel = "UKPSC Indian Polity & Governance (भारतीय राजव्यवस्था)",
            baseId = 32000,
            targetCount = 50
        )
        MockTest(
            testId = "ukpsc_sec_polity_50",
            title = "UKPSC Free Test 3: Indian Polity & Governance — 50 PYQ Questions",
            hindiTitle = "UKPSC निःशुल्क टेस्ट 3: भारतीय राजव्यवस्था एवं शासन — 50 PYQ प्रश्न",
            examName = "UKPSC Prelims — Polity (50 Qs)",
            durationMinutes = 45,
            totalMarks = 50,
            positiveMarks = 1.0,
            negativeMarks = 0.25,
            categoryId = "state_psc",
            pyqAnalysisEn = "UKPSC Last 5 Years (2020–2025) Polity PYQ Analysis: High weightage on Preamble, Schedules (6th, 11th, 12th), Fundamental Rights & DPSP (Art 44 UCC), Parliamentary Committees (PAC, Estimates), Constitutional Bodies & Panchayati Raj Committees.",
            pyqAnalysisHi = "UKPSC विगत 5 वर्षीय (2020–2025) राजव्यवस्था PYQ विश्लेषण: उद्देशिका, अनुसूचियाँ (6वीं, 11वीं, 12वीं), मूल अधिकार एवं नीति निदेशक तत्व (अनुच्छेद 44 UCC), संसदीय समितियाँ, संवैधानिक आयोग और पंचायती राज पर आधारित 50 प्रश्न।",
            topicWeightage = listOf("FR, DPSP & Schedules (30%)", "Parliament & Executive (28%)", "Panchayati Raj & Commissions (24%)", "Amendments & Judiciary (18%)"),
            questions = questions
        )
    }

    val ukpscGeography50Test: MockTest by lazy {
        val questions = buildUkpscQuestions(
            seeds = ukpscGeographySeeds,
            subjectLabel = "UKPSC Indian & World Geography (भारत एवं विश्व का भूगोल)",
            baseId = 33000,
            targetCount = 50
        )
        MockTest(
            testId = "ukpsc_sec_geography_50",
            title = "UKPSC Free Test 4: Indian & World Geography — 50 PYQ Questions",
            hindiTitle = "UKPSC निःशुल्क टेस्ट 4: भारत एवं विश्व का भूगोल — 50 PYQ प्रश्न",
            examName = "UKPSC Prelims — Geography (50 Qs)",
            durationMinutes = 45,
            totalMarks = 50,
            positiveMarks = 1.0,
            negativeMarks = 0.25,
            categoryId = "state_psc",
            pyqAnalysisEn = "UKPSC Last 5 Years (2020–2025) Geography PYQ Analysis: Focuses on Himalayan Tectonic Faults (ITSZ, MCT, MBT, HFF), Indian Drainage & Peninsular Peaks, Mineral Belts, World Local Winds, Ocean Currents, Grasslands & Census 2011.",
            pyqAnalysisHi = "UKPSC विगत 5 वर्षीय (2020–2025) भूगोल PYQ विश्लेषण: हिमालय के भ्रंश (MCT, MBT, HFF), अपवाह तंत्र, खनिज क्षेत्र, स्थानीय पवनें, महासागरीय जलधाराएँ, घास के मैदान एवं जनगणना 2011 पर आधारित 50 प्रश्न।",
            topicWeightage = listOf("Indian Physical & River Geo (36%)", "World Physical & Climate (28%)", "Minerals & Agriculture (20%)", "Census 2011 Demography (16%)"),
            questions = questions
        )
    }

    val ukpscEconomics50Test: MockTest by lazy {
        val questions = buildUkpscQuestions(
            seeds = ukpscEconomySeeds,
            subjectLabel = "UKPSC Indian Economy (भारतीय अर्थव्यवस्था)",
            baseId = 34000,
            targetCount = 50
        )
        MockTest(
            testId = "ukpsc_sec_economics_50",
            title = "UKPSC Free Test 5: Indian Economy & Social Development — 50 PYQ Questions",
            hindiTitle = "UKPSC निःशुल्क टेस्ट 5: भारतीय अर्थव्यवस्था एवं सामाजिक विकास — 50 PYQ प्रश्न",
            examName = "UKPSC Prelims — Economics (50 Qs)",
            durationMinutes = 45,
            totalMarks = 50,
            positiveMarks = 1.0,
            negativeMarks = 0.25,
            categoryId = "state_psc",
            pyqAnalysisEn = "UKPSC Last 5 Years (2020–2025) Economy PYQ Analysis: Covers National Income, Fiscal/Primary Deficit, GST (Art 279A), Lorenz/Phillips/Laffer Curves, HDI & MPI, NABARD/RRB/SEBI, WTO Subsidies, IMF SDR & Balance of Payments.",
            pyqAnalysisHi = "UKPSC विगत 5 वर्षीय (2020–2025) अर्थव्यवस्था PYQ विश्लेषण: राष्ट्रीय आय, राजकोषीय व प्राथमिक घाटा, GST (अनुच्छेद 279A), लॉरेंज वक्र, मानव विकास सूचकांक (HDI), नाबार्ड/RRB/सेबी, WTO सब्सिडी और भुगतान संतुलन के 50 प्रश्न।",
            topicWeightage = listOf("Fiscal Policy, GST & Budget (30%)", "Money, Banking & NABARD (26%)", "Poverty, HDI & Social Dev (24%)", "WTO, IMF & External Sector (20%)"),
            questions = questions
        )
    }

    val ukpscEnvironment50Test: MockTest by lazy {
        val questions = buildUkpscQuestions(
            seeds = ukpscEnvironmentSeeds,
            subjectLabel = "UKPSC Environment & Ecology (पर्यावरण एवं पारिस्थितिकी)",
            baseId = 35000,
            targetCount = 50
        )
        MockTest(
            testId = "ukpsc_sec_environment_50",
            title = "UKPSC Free Test 6: Environment, Ecology & Biodiversity — 50 PYQ Questions",
            hindiTitle = "UKPSC निःशुल्क टेस्ट 6: पर्यावरण, पारिस्थितिकी एवं जैव-विविधता — 50 PYQ प्रश्न",
            examName = "UKPSC Prelims — Environment (50 Qs)",
            durationMinutes = 45,
            totalMarks = 50,
            positiveMarks = 1.0,
            negativeMarks = 0.25,
            categoryId = "state_psc",
            pyqAnalysisEn = "UKPSC Last 5 Years (2020–2025) Environment PYQ Analysis: Covers Ecosystem & 10% Energy Law, Ecotone, Biodiversity Hotspots, Environmental Acts (1972–2002), Project Tiger/Elephant/Snow Leopard, Lichen Park, Acid Rain & Climate Agreements.",
            pyqAnalysisHi = "UKPSC विगत 5 वर्षीय (2020–2025) पर्यावरण PYQ विश्लेषण: पारिस्थितिकी तंत्र एवं 10% ऊर्जा नियम, जैव-विविधता हॉटस्पॉट, पर्यावरण अधिनियम (1972–2002), प्रोजेक्ट टाइगर/हिम तेंदुआ, लाइकेन पार्क, अम्ल वर्षा और जलवायु समझौतों के 50 प्रश्न।",
            topicWeightage = listOf("Ecosystem & Trophic Flow (28%)", "Biodiversity & Wildlife Acts (30%)", "Climate Change & Protocols (22%)", "Pollution & Bio-indicators (20%)"),
            questions = questions
        )
    }

    val ukpscSciTech50Test: MockTest by lazy {
        val questions = buildUkpscQuestions(
            seeds = ukpscSciTechComputerSeeds,
            subjectLabel = "UKPSC Science, Tech & Computer IT (विज्ञान एवं कंप्यूटर)",
            baseId = 36000,
            targetCount = 50
        )
        MockTest(
            testId = "ukpsc_sec_scitech_50",
            title = "UKPSC Free Test 7: General Science, Tech & Computer IT — 50 PYQ Questions",
            hindiTitle = "UKPSC निःशुल्क टेस्ट 7: सामान्य विज्ञान, प्रौद्योगिकी एवं कंप्यूटर — 50 PYQ प्रश्न",
            examName = "UKPSC Prelims — Science & Computer (50 Qs)",
            durationMinutes = 45,
            totalMarks = 50,
            positiveMarks = 1.0,
            negativeMarks = 0.25,
            categoryId = "state_psc",
            pyqAnalysisEn = "UKPSC Last 5 Years (2020–2025) Science & Computer PYQ Analysis: Uniquely includes 8–10 Computer & IT questions (OSI 7 Layers, IPv4/IPv6, MAC, RAM/ROM) alongside Biology (Cell, Vitamins, Diseases), Physics (TIR, Sound), ISRO & ARIES Devasthal Telescope.",
            pyqAnalysisHi = "UKPSC विगत 5 वर्षीय (2020–2025) विज्ञान एवं कंप्यूटर PYQ विश्लेषण: इसमें जीव विज्ञान, भौतिकी, रसायन और अंतरिक्ष (इसरो व देवस्थल टेलीस्कोप) के साथ-साथ UKPSC के विशेष 'कंप्यूटर एवं सूचना प्रौद्योगिकी' (OSI मॉडल, IPv4/IPv6, मेमोरी) के 50 प्रश्न शामिल हैं।",
            topicWeightage = listOf("Computer, Networking & IT (30%)", "Biology, Vitamins & Genetics (30%)", "Physics & Everyday Chemistry (22%)", "Space, Defence & Biotech (18%)"),
            questions = questions
        )
    }

    val ukpscCurrentAffairs50Test: MockTest by lazy {
        val questions = buildUkpscQuestions(
            seeds = ukpscCurrentAffairsSeeds,
            subjectLabel = "UKPSC Uttarakhand & National Current Affairs (समसामयिकी)",
            baseId = 37000,
            targetCount = 50
        )
        MockTest(
            testId = "ukpsc_sec_ca_50",
            title = "UKPSC Free Test 8: Uttarakhand, National & International Current Affairs — 50 PYQ Questions",
            hindiTitle = "UKPSC निःशुल्क टेस्ट 8: उत्तराखंड, राष्ट्रीय एवं अंतर्राष्ट्रीय समसामयिकी — 50 PYQ प्रश्न",
            examName = "UKPSC Prelims — Current Affairs (50 Qs)",
            durationMinutes = 45,
            totalMarks = 50,
            positiveMarks = 1.0,
            negativeMarks = 0.25,
            categoryId = "state_psc",
            pyqAnalysisEn = "UKPSC Last 5 Years (2020–2025) Current Affairs Analysis: Covers Uttarakhand UCC Act 2024, 38th National Games ('Mauli' mascot), Manaskhand Mandir Mala, Lakhpati Didi & Vatsalya Schemes, Uttarakhand Budget/Economic Survey, G20 Meetings in Uttarakhand & Military Exercises.",
            pyqAnalysisHi = "UKPSC विगत 5 वर्षीय (2020–2025) समसामयिकी विश्लेषण: उत्तराखंड समान नागरिक संहिता (UCC 2024), 38वें राष्ट्रीय खेल (शुभंकर 'मौली'), मानसखंड मंदिर माला मिशन, उत्तराखंड बजट व आर्थिक सर्वेक्षण, प्रमुख योजनाएँ और सैन्य अभ्यास के 50 प्रश्न।",
            topicWeightage = listOf("Uttarakhand Schemes, UCC & Budget (42%)", "National Current Affairs & Awards (32%)", "International Summits & Exercises (26%)"),
            questions = questions
        )
    }

    /**
     * Master List of all 8 UKPSC Prelims Free Attempt Section Tests (450 Questions Total):
     *  - #1 Flagship Special Section: Uttarakhand Special (उत्तराखंड विशेष — Top 100 Last 5 Years PYQs)
     *  - #2 to #8: 7 Subject-Wise 50-Question Free Tests
     */
    val all8UkpscSectionTests: List<UkpscSectionTestMeta> by lazy {
        listOf(
            UkpscSectionTestMeta(
                id = "ukpsc_special_100",
                sectionId = "ukpsc_special_100",
                titleEn = "★ Uttarakhand Special (उत्तराखंड विशेष — Top 100 PYQs)",
                titleHi = "★ उत्तराखंड विशेष (Uttarakhand Special — टॉप 100 विगत 5 वर्षीय PYQs)",
                subtitleEn = "100 Questions • All Last 5 Years UKPSC Prelims PYQs: Kuninda-Katyuri-Chand-Panwar, Panch Prayag, Glaciers, Tribes, Culture, National Parks, Chipko/Maiti, Census & GEP/GI Tags",
                subtitleHi = "100 प्रश्न • विगत 5 वर्षों के संपूर्ण उत्तराखंड पीसीएस PYQ: कुणिंद-कत्यूरी-चंद-पंवार वंश, पंच प्रयाग, ग्लेशियर, दर्रे, जनजातियाँ, लोक-संस्कृति, राष्ट्रीय उद्यान, चिपको-मैती आंदोलन, जनगणना एवं GEP/GI टैग",
                questionCount = 100,
                isSpecial100 = true,
                mockTest = UkpscSpecial100PyqData.ukpscUttarakhandSpecial100Test
            ),
            UkpscSectionTestMeta(
                id = "ukpsc_history",
                sectionId = "ukpsc_history",
                titleEn = "History (इतिहास — 50 PYQs)",
                titleHi = "इतिहास (History — 50 PYQs)",
                subtitleEn = "50 Questions • Ancient, Medieval, Modern Indian History & Freedom Struggle (Last 5 Yrs UKPSC PYQ)",
                subtitleHi = "50 प्रश्न • प्राचीन, मध्यकालीन, आधुनिक भारतीय इतिहास एवं स्वतंत्रता आंदोलन (UKPSC 5 वर्षीय PYQ)",
                questionCount = 50,
                mockTest = ukpscHistory50Test
            ),
            UkpscSectionTestMeta(
                id = "ukpsc_polity",
                sectionId = "ukpsc_polity",
                titleEn = "Polity (राजव्यवस्था — 50 PYQs)",
                titleHi = "राजव्यवस्था (Polity — 50 PYQs)",
                subtitleEn = "50 Questions • Indian Constitution, Articles, Schedules, Parliament, Judiciary & Panchayati Raj (Last 5 Yrs UKPSC PYQ)",
                subtitleHi = "50 प्रश्न • भारतीय संविधान, अनुच्छेद, अनुसूचियाँ, संसद, न्यायपालिका एवं पंचायती राज (UKPSC 5 वर्षीय PYQ)",
                questionCount = 50,
                mockTest = ukpscPolity50Test
            ),
            UkpscSectionTestMeta(
                id = "ukpsc_geography",
                sectionId = "ukpsc_geography",
                titleEn = "Geography (भूगोल — 50 PYQs)",
                titleHi = "भूगोल (Geography — 50 PYQs)",
                subtitleEn = "50 Questions • Himalayan Faults, Indian Rivers, Minerals, World Geography & Census 2011 (Last 5 Yrs UKPSC PYQ)",
                subtitleHi = "50 प्रश्न • हिमालय भ्रंश, भारतीय नदियाँ, खनिज, विश्व भूगोल एवं जनगणना 2011 (UKPSC 5 वर्षीय PYQ)",
                questionCount = 50,
                mockTest = ukpscGeography50Test
            ),
            UkpscSectionTestMeta(
                id = "ukpsc_economics",
                sectionId = "ukpsc_economics",
                titleEn = "Economics (अर्थव्यवस्था — 50 PYQs)",
                titleHi = "अर्थव्यवस्था (Economics — 50 PYQs)",
                subtitleEn = "50 Questions • National Income, Fiscal Policy, GST, HDI, NABARD, WTO & Social Development (Last 5 Yrs UKPSC PYQ)",
                subtitleHi = "50 प्रश्न • राष्ट्रीय आय, राजकोषीय नीति, GST, मानव विकास सूचकांक, नाबार्ड एवं WTO (UKPSC 5 वर्षीय PYQ)",
                questionCount = 50,
                mockTest = ukpscEconomics50Test
            ),
            UkpscSectionTestMeta(
                id = "ukpsc_environment",
                sectionId = "ukpsc_environment",
                titleEn = "Environment (पर्यावरण — 50 PYQs)",
                titleHi = "पर्यावरण एवं पारिस्थितिकी (Environment — 50 PYQs)",
                subtitleEn = "50 Questions • Ecology, Biodiversity Hotspots, Wildlife Acts, Climate Change & Bio-indicators (Last 5 Yrs UKPSC PYQ)",
                subtitleHi = "50 प्रश्न • पारिस्थितिकी तंत्र, जैव-विविधता हॉटस्पॉट, वन्यजीव अधिनियम एवं जलवायु परिवर्तन (UKPSC 5 वर्षीय PYQ)",
                questionCount = 50,
                mockTest = ukpscEnvironment50Test
            ),
            UkpscSectionTestMeta(
                id = "ukpsc_scitech",
                sectionId = "ukpsc_scitech",
                titleEn = "Science, Tech & Computer (विज्ञान एवं कंप्यूटर — 50 PYQs)",
                titleHi = "विज्ञान, प्रौद्योगिकी एवं कंप्यूटर (Sci & Computer — 50 PYQs)",
                subtitleEn = "50 Questions • General Science, ISRO Space Missions & UKPSC Special Computer/IT Networking (Last 5 Yrs UKPSC PYQ)",
                subtitleHi = "50 प्रश्न • सामान्य विज्ञान, अंतरिक्ष प्रौद्योगिकी एवं UKPSC विशेष कंप्यूटर/नेटवर्किंग (UKPSC 5 वर्षीय PYQ)",
                questionCount = 50,
                mockTest = ukpscSciTech50Test
            ),
            UkpscSectionTestMeta(
                id = "ukpsc_current_affairs",
                sectionId = "ukpsc_current_affairs",
                titleEn = "Current Affairs (उत्तराखंड एवं राष्ट्रीय समसामयिकी — 50 PYQs)",
                titleHi = "उत्तराखंड एवं राष्ट्रीय समसामयिकी (Current Affairs — 50 PYQs)",
                subtitleEn = "50 Questions • Uttarakhand UCC 2024, 38th National Games, Manaskhand, UK Budget/Schemes & National/IR Current Affairs",
                subtitleHi = "50 प्रश्न • उत्तराखंड UCC 2024, 38वें राष्ट्रीय खेल, मानसखंड, उत्तराखंड बजट व योजनाएँ तथा राष्ट्रीय/अंतर्राष्ट्रीय समसामयिकी",
                questionCount = 50,
                mockTest = ukpscCurrentAffairs50Test
            )
        )
    }
}
