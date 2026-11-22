package com.example.data.ugcnet

/**
 * Authentic Last 5 Years (2020–2025) NTA UGC NET Paper 2 (Subject-Specific)
 * Bilingual PYQ Seeds covering all 12 Major UGC NET Subjects:
 *  1. History (इतिहास — Code 006)
 *  2. Political Science (राजनीति विज्ञान — Code 002)
 *  3. Geography (भूगोल — Code 080)
 *  4. Economics (अर्थशास्त्र — Code 001)
 *  5. Hindi Literature (हिंदी साहित्य — Code 020)
 *  6. English Literature (अंग्रेज़ी साहित्य — Code 030)
 *  7. Commerce (वाणिज्य — Code 008)
 *  8. Management (प्रबंधन — Code 017)
 *  9. Sociology (समाजशास्त्र — Code 005)
 * 10. Education (शिक्षाशास्त्र — Code 009)
 * 11. Computer Science & Applications (कंप्यूटर विज्ञान और अनुप्रयोग — Code 087)
 * 12. Law (विधि / कानून — Code 058)
 */
object UgcNetPaper2PyqSeeds {

    // ==================== 1. HISTORY (इतिहास — Code 006) ====================
    val historySeeds: List<RawUgcNetPyqSeed> = listOf(
        RawUgcNetPyqSeed(
            qEn = "Which Indus Valley Civilization site yielded the famous 'Signboard' with ten large Harappan script characters and a sophisticated three-tier water management system?",
            qHi = "सिंधु घाटी सभ्यता के किस स्थल से हड़प्पा लिपि के दस बड़े अक्षरों वाला प्रसिद्ध 'साइनबोर्ड' (Signboard) और त्रि-स्तरीय उन्नत जल प्रबंधन प्रणाली प्राप्त हुई है?",
            optsEn = listOf(
                "Dholavira (Khadir Bet, Rann of Kutch, Gujarat)",
                "Lothal (Bhogava River, Gujarat)",
                "Kalibangan (Ghaggar River, Rajasthan)",
                "Banawali (Fatehabad, Haryana)"
            ),
            optsHi = listOf(
                "धोलावीरा (खादिर बेट, कच्छ का रण, गुजरात)",
                "लोथल (भोगवा नदी, गुजरात)",
                "कालीबंगा (घग्गर नदी, राजस्थान)",
                "बनावली (फतेहाबाद, हरियाणा)"
            ),
            expEn = "Dholavira (excavated by R.S. Bisht) is divided into three parts (Citadel, Middle Town, Lower Town) and yielded the 10-sign Harappan inscription and rock-cut water reservoirs.",
            expHi = "धोलावीरा (आर.एस. बिष्ट द्वारा उत्खनित) तीन भागों (दुर्ग, मध्यम नगर, निचला नगर) में विभाजित है तथा यहाँ से 10 चिह्नों वाला अभिलेख एवं शैलकृत जलाशय मिले हैं।",
            yearTag = "UGC NET History June 2024 PYQ",
            subTopic = "Unit I: Negotiating the Sources & Harappan Civilization"
        ),
        RawUgcNetPyqSeed(
            qEn = "In Chola administration, which inscription provides detailed rules regarding the election and disqualifications of members of the 'Sabha' committees (Variyam)?",
            qHi = "चोल प्रशासन में कौन-सा अभिलेख 'सभा' की समितियों (वारियम) के सदस्यों के निर्वाचन और अयोग्यताओं संबंधी विस्तृत नियमों का विवरण देता है?",
            optsEn = listOf(
                "Uttaramerur Inscription of Parantaka I (919 & 921 CE)",
                "Aihole Inscription of Pulakeshin II",
                "Tanjore Brihadisvara Inscription of Rajaraja I",
                "Tirukkoyilur Inscription of Rajendra I"
            ),
            optsHi = listOf(
                "परान्तक प्रथम का उत्तरमेरूर अभिलेख (919 एवं 921 ई.)",
                "पुलकेशिन द्वितीय का ऐहोल अभिलेख",
                "राजराज प्रथम का तंजौर बृहदीश्वर अभिलेख",
                "राजेंद्र प्रथम का तिरुक्कोयिलूर अभिलेख"
            ),
            expEn = "The Uttaramerur inscriptions from the reign of Chola king Parantaka I describe the Kudavolai (pot-ticket) system for electing village assembly (Sabha) committee (Variyam) members.",
            expHi = "चोल शासक परान्तक प्रथम के उत्तरमेरूर अभिलेख में ग्राम सभा की वारियम समितियों के सदस्यों के चुनाव की 'कुडवोलाई' (पर्ची) प्रणाली और योग्यताओं का वर्णन है।",
            yearTag = "UGC NET History Dec 2023 PYQ",
            subTopic = "Unit III: Emergence of Regional Kingdoms (Chola Local Self-Government)"
        ),
        RawUgcNetPyqSeed(
            qEn = "Which Mughal emperor introduced the 'Du-Aspa Sih-Aspa' (two-horse, three-horse) rank modification within the Mansabdari system without raising the Zat rank?",
            qHi = "किस मुगल सम्राट ने मनसबदारी व्यवस्था के अंतर्गत 'जात' पद बढ़ाए बिना 'दु-अस्पा सिह-अस्पा' (दो-घोड़ा, तीन-घोड़ा) वेतन/सवार नियम लागू किया था?",
            optsEn = listOf(
                "Jahangir",
                "Akbar",
                "Shah Jahan",
                "Aurangzeb"
            ),
            optsHi = listOf(
                "जहाँगीर",
                "अकबर",
                "शाहजहाँ",
                "औरंगजेब"
            ),
            expEn = "Jahangir introduced the Du-Aspa Sih-Aspa system (first granted to Mahabat Khan), allowing a Mansabdar to maintain double or triple cavalry contingents without increasing his Zat rank.",
            expHi = "जहाँगीर ने 'दु-अस्पा सिह-अस्पा' प्रथा (सर्वप्रथम महाबत खाँ को प्रदान) शुरू की, जिससे जात पद बढ़ाए बिना अधिक घुड़सवार रखने की अनुमति मिली।",
            yearTag = "UGC NET History June 2023 PYQ",
            subTopic = "Unit V: Administration & Economy of Mughal Empire"
        ),
        RawUgcNetPyqSeed(
            qEn = "Who authored the famous Subaltern Studies foundational essay 'On Some Aspects of the Historiography of Colonial India' (1982)?",
            qHi = "सबाल्टर्न स्टडीज (Subaltern Studies) के संस्थापक निबंध 'ऑन सम एस्पेक्ट्स ऑफ द हिस्टोरियोग्राफी ऑफ कोलोनियल इंडिया' (1982) के लेखक कौन थे?",
            optsEn = listOf(
                "Ranajit Guha",
                "Dipesh Chakrabarty",
                "Partha Chatterjee",
                "Sumit Sarkar"
            ),
            optsHi = listOf(
                "रणजीत गुहा (Ranajit Guha)",
                "दीपेश चक्रवर्ती",
                "पार्थ चटर्जी",
                "सुमित सरकार"
            ),
            expEn = "Ranajit Guha founded the Subaltern Studies collective in 1982 and critiqued both Colonialist/Cambridge and bourgeois-Nationalist elitist historiography in Volume I.",
            expHi = "रणजीत गुहा ने 1982 में सबाल्टर्न स्टडीज समूह की स्थापना की और औपनिवेशिक तथा अभिजात्य राष्ट्रवादी इतिहास-लेखन की आलोचना प्रस्तुत की।",
            yearTag = "UGC NET History Dec 2022 PYQ",
            subTopic = "Unit X: Historical Method, Research, Methodology & Historiography"
        ),
        RawUgcNetPyqSeed(
            qEn = "Which Land Revenue Settlement introduced by Holt Mackenzie in 1822 in the North-Western Provinces assessed revenue on the village community (Mahal) collectively?",
            qHi = "1822 में उत्तर-पश्चिमी प्रांतों में हॉल्ट मैकेंज़ी (Holt Mackenzie) द्वारा प्रारंभ की गई किस भू-राजस्व व्यवस्था में पूरे ग्राम समुदाय (महाल) पर सामूहिक रूप से लगान निर्धारित किया गया?",
            optsEn = listOf(
                "Mahalwari Settlement (Regulation VII of 1822)",
                "Permanent Settlement (1793, Lord Cornwallis)",
                "Ryotwari Settlement (1820, Munro & Read)",
                "Taluqdari Settlement of Awadh (1856)"
            ),
            optsHi = listOf(
                "महालवाड़ी बंदोबस्त (1822 का रेगुलेशन VII)",
                "स्थायी बंदोबस्त (1793, लॉर्ड कॉर्नवालिस)",
                "रैयतवाड़ी बंदोबस्त (1820, मुनरो और रीड)",
                "अवध का तालुकदारी बंदोबस्त (1856)"
            ),
            expEn = "Holt Mackenzie's Minute of 1819 led to Regulation VII of 1822 establishing the Mahalwari system across North-Western Provinces, later revised by R.M. Bird and James Thomason (1833).",
            expHi = "हॉल्ट मैकेंज़ी के 1819 के स्मरण-पत्र के आधार पर 1822 के रेगुलेशन VII द्वारा महालवाड़ी व्यवस्था लागू हुई, जिसे बाद में आर.एम. बर्ड व जेम्स थॉमसन (1833) ने संशोधित किया।",
            yearTag = "UGC NET History 2021 PYQ",
            subTopic = "Unit VIII: Colonial Economy & Agrarian Settlements"
        ),
        RawUgcNetPyqSeed(
            qEn = "Match the Buddhist Councils with their respective Presidents: First (Rajagriha), Second (Vaishali), Third (Pataliputra), Fourth (Kashmir).",
            qHi = "बौद्ध संगीतियों को उनके अध्यक्षों से सुमेलित कीजिए: प्रथम (राजगृह), द्वितीय (वैशाली), तृतीय (पाटलिपुत्र), चतुर्थ (कश्मीर)।",
            optsEn = listOf(
                "1st: Mahakassapa, 2nd: Sabakami, 3rd: Moggaliputta Tissa, 4th: Vasumitra (Ashvaghosha as Vice-President)",
                "1st: Upali, 2nd: Ananda, 3rd: Vasumitra, 4th: Mahakassapa",
                "1st: Moggaliputta Tissa, 2nd: Mahakassapa, 3rd: Sabakami, 4th: Nagarjuna",
                "1st: Ashvaghosha, 2nd: Vasumitra, 3rd: Upagupta, 4th: Sabakami"
            ),
            optsHi = listOf(
                "प्रथम: महाकश्यप, द्वितीय: सबाकामी, तृतीय: मोग्गलिपुत्त तिस्स, चतुर्थ: वसुमित्र (उपाध्यक्ष: अश्वघोष)",
                "प्रथम: उपालि, द्वितीय: आनंद, तृतीय: वसुमित्र, चतुर्थ: महाकश्यप",
                "प्रथम: मोग्गलिपुत्त तिस्स, द्वितीय: महाकश्यप, तृतीय: सबाकामी, चतुर्थ: नागार्जुन",
                "प्रथम: अश्वघोष, द्वितीय: वसुमित्र, तृतीय: उपगुप्त, चतुर्थ: सबाकामी"
            ),
            expEn = "First Council (483 BCE, Ajatashatru) — Mahakassapa; Second (383 BCE, Kalashoka) — Sabakami; Third (250 BCE, Ashoka) — Moggaliputta Tissa; Fourth (1st C CE, Kanishka) — Vasumitra.",
            expHi = "प्रथम संगीति (अजातशत्रु) — महाकश्यप; द्वितीय (कालाशोक) — सबाकामी; तृतीय (अशोक) — मोग्गलिपुत्त तिस्स; चतुर्थ (कनिष्क, कुंडलवन) — वसुमित्र।",
            yearTag = "UGC NET History 2020 PYQ",
            subTopic = "Unit I: Pastoralism, Food Production & Heterodox Sects"
        )
    )

    // ==================== 2. POLITICAL SCIENCE (राजनीति विज्ञान — Code 002) ====================
    val polScienceSeeds: List<RawUgcNetPyqSeed> = listOf(
        RawUgcNetPyqSeed(
            qEn = "In John Rawls' 'A Theory of Justice' (1971), what is the correct lexical priority order of his principles of justice chosen behind the 'Veil of Ignorance'?",
            qHi = "जॉन रॉल्स की पुस्तक 'ए थ्योरी ऑफ जस्टिस' (1971) में 'अज्ञानता के पर्दे' (Veil of Ignorance) के पीछे चुने गए न्याय के सिद्धांतों का सही प्राथमिकता क्रम (Lexical Order) क्या है?",
            optsEn = listOf(
                "(1) Equal Basic Liberties Principle → (2a) Fair Equality of Opportunity → (2b) Difference Principle",
                "(1) Difference Principle → (2) Fair Equality of Opportunity → (3) Equal Basic Liberties",
                "(1) Utilitarian Greatest Happiness → (2) Libertarian Entitlement → (3) Difference Principle",
                "(1) Fair Equality of Opportunity → (2) Equal Basic Liberties → (3) Difference Principle"
            ),
            optsHi = listOf(
                "(1) समान मूल स्वतंत्रता का सिद्धांत → (2a) अवसर की उचित समानता → (2b) भेद सिद्धांत (Difference Principle)",
                "(1) भेद सिद्धांत → (2) अवसर की उचित समानता → (3) समान मूल स्वतंत्रता",
                "(1) उपयोगितावादी अधिकतम सुख → (2) स्वेच्छातंत्रवादी पात्रता → (3) भेद सिद्धांत",
                "(1) अवसर की उचित समानता → (2) समान मूल स्वतंत्रता → (3) भेद सिद्धांत"
            ),
            expEn = "Rawls places the First Principle (Equal Basic Liberties) lexically prior to the Second Principle, and within the Second Principle, Fair Equality of Opportunity (2a) has lexical priority over the Difference Principle (2b).",
            expHi = "रॉल्स के अनुसार प्रथम सिद्धांत (समान मूल स्वतंत्रता) को द्वितीय सिद्धांत पर प्राथमिकता प्राप्त है, और द्वितीय सिद्धांत में 'अवसर की उचित समानता' को 'भेद सिद्धांत' (Difference Principle) से ऊपर रखा गया है।",
            yearTag = "UGC NET Political Science June 2024 PYQ",
            subTopic = "Unit I: Political Theory (Justice, Equality, Liberty)"
        ),
        RawUgcNetPyqSeed(
            qEn = "Which scholar distinguished between 'Ideological State Apparatuses' (ISAs) and 'Repressive State Apparatuses' (RSAs) and adapted Gramsci's concept of hegemony into Structural Marxism?",
            qHi = "किस विचारक ने 'वैचारिक राज्य उपकरण' (ISAs) और 'दमनकारी राज्य उपकरण' (RSAs) के बीच भेद किया और ग्राम्शी के वर्चस्व सिद्धांत को संरचनात्मक मार्क्सवाद में ढाला?",
            optsEn = listOf(
                "Louis Althusser",
                "Nicos Poulantzas",
                "Ralph Miliband",
                "Herbert Marcuse"
            ),
            optsHi = listOf(
                "लुई अल्थूसर (Louis Althusser)",
                "निकोस पोलांत्ज़ास",
                "राल्फ मिलिबैंड",
                "हर्बर्ट मारक्यूज़"
            ),
            expEn = "Louis Althusser in 'Ideology and Ideological State Apparatuses' (1970) distinguished RSAs (police, army, courts operating primarily by force) from ISAs (schools, media, family, church operating primarily by ideology).",
            expHi = "लुई अल्थूसर ने अपने निबंध (1970) में दमनकारी राज्य उपकरण (पुलिस, सेना) और वैचारिक राज्य उपकरण (स्कूल, परिवार, मीडिया) के बीच अंतर स्पष्ट किया।",
            yearTag = "UGC NET Political Science Dec 2023 PYQ",
            subTopic = "Unit II: Western Political Thought (Gramsci, Marx, Althusser)"
        ),
        RawUgcNetPyqSeed(
            qEn = "In Kautilya's Arthashastra, which of the following correctly lists the Seven Elements (Saptanga Theory) of the State?",
            qHi = "कौटिल्य के 'अर्थशास्त्र' में राज्य के 'सप्तांग सिद्धांत' (सात अंगों) का सही समूह कौन-सा है?",
            optsEn = listOf(
                "Swami (King), Amatya (Minister), Janapada (Territory/People), Durga (Fort), Kosha (Treasury), Danda/Bala (Army), Mitra (Ally)",
                "Raja, Purohita, Senapati, Yuvaraja, Samaharta, Sannidhata, Duta",
                "Sama, Dana, Danda, Bheda, Maya, Upeksha, Indrajala",
                "Dharma, Artha, Kama, Moksha, Neeti, Danda, Nyaya"
            ),
            optsHi = listOf(
                "स्वामी (राजा), अमात्य (मंत्री), जनपद (भूमि/जनसंख्या), दुर्ग (किला), कोष (खजाना), दंड/बल (सेना), मित्र (सहायक)",
                "राजा, पुरोहित, सेनापति, युवराज, समाहर्ता, सन्निधाता, दूत",
                "साम, दाम, दंड, भेद, माया, उपेक्षा, इंद्रजाल",
                "धर्म, अर्थ, काम, मोक्ष, नीति, दंड, न्याय"
            ),
            expEn = "In Book 6 (Mandala Yonih) of the Arthashastra, Kautilya defines the organic Saptanga (seven-limbed) state: Swami, Amatya, Janapada, Durga, Kosha, Danda (Bala), and Mitra.",
            expHi = "कौटिल्य के अर्थशास्त्र के अधिकरण 6 में राज्य के सात अंग (सप्तांग) बताए गए हैं: स्वामी, अमात्य, जनपद, दुर्ग, कोष, दंड (बल) और मित्र।",
            yearTag = "UGC NET Political Science June 2023 PYQ",
            subTopic = "Unit III: Indian Political Thought (Kautilya, Manu, Aggannasutta)"
        ),
        RawUgcNetPyqSeed(
            qEn = "Gabriel Almond and Sidney Verba in 'The Civic Culture' (1963) classified political culture into which three pure types?",
            qHi = "गैब्रियल आमंड और सिडनी वर्बा ने अपनी पुस्तक 'द सिविक कल्चर' (1963) में राजनीतिक संस्कृति को किन तीन शुद्ध प्रकारों में वर्गीकृत किया है?",
            optsEn = listOf(
                "Parochial, Subject, and Participant Political Culture",
                "Traditional, Charismatic, and Legal-Rational Culture",
                "Consociational, Majoritarian, and Praetorian Culture",
                "Polyarchal, Totalitarian, and Authoritarian Culture"
            ),
            optsHi = listOf(
                "संकीर्ण (Parochial), पराधीन/प्रजाभावी (Subject), और सहभागी (Participant) राजनीतिक संस्कृति",
                "पारंपरिक, करिश्माई और विधिक-तार्किक संस्कृति",
                "सहमतिजन्य, बहुमतवादी और प्रीटोरियन संस्कृति",
                "बहुलतंत्रवादी, सर्वाधिकारवादी और सत्तावादी संस्कृति"
            ),
            expEn = "Almond and Verba studied five democracies (US, UK, West Germany, Italy, Mexico) and identified Parochial (low awareness), Subject (output awareness, passive), and Participant (active input & output) orientations; Civic Culture is a balanced mix of all three.",
            expHi = "आमंड और वर्बा ने पाँच देशों का अध्ययन कर संकीर्ण, प्रजाभावी और सहभागी राजनीतिक संस्कृति की पहचान की तथा इनके संतुलित मिश्रण को 'सिविक कल्चर' (नागरिक संस्कृति) कहा।",
            yearTag = "UGC NET Political Science Dec 2022 PYQ",
            subTopic = "Unit IV: Comparative Political Analysis (Political Culture)"
        ),
        RawUgcNetPyqSeed(
            qEn = "Kenneth Waltz in 'Theory of International Politics' (1979) argued that international conflict stems primarily from which level/structure rather than human nature?",
            qHi = "केनेथ वाल्ट्ज़ (Kenneth Waltz) ने अपनी पुस्तक 'थ्योरी ऑफ इंटरनेशनल पॉलिटिक्स' (1979) में तर्क दिया कि अंतर्राष्ट्रीय संघर्ष मानव स्वभाव के बजाय मुख्यतः किस संरचना से उत्पन्न होता है?",
            optsEn = listOf(
                "The anarchic structure of the international system (Structural Realism / Defensive Neorealism)",
                "Flawed human nature and animus dominandi (Classical Realism of Hans Morgenthau)",
                "Absence of global free-trade institutions (Neoliberal Institutionalism)",
                "Intersubjective social norms and identities (Social Constructivism of Alexander Wendt)"
            ),
            optsHi = listOf(
                "अंतर्राष्ट्रीय प्रणाली की अराजक संरचना (संरचनात्मक यथार्थवाद / रक्षात्मक नव-यथार्थवाद)",
                "त्रुटिपूर्ण मानव स्वभाव एवं सत्ता की लालसा (हंस मॉर्गेंथाउ का शास्त्रीय यथार्थवाद)",
                "वैश्विक मुक्त-व्यापार संस्थाओं का अभाव (नव-उदारवादी संस्थावाद)",
                "अंतर-विषयक सामाजिक मानदंड और पहचान (अलेक्जेंडर वेंड्ट का सामाजिक रचनावाद)"
            ),
            expEn = "Kenneth Waltz (Defensive Neorealism) shifted realism from Morgenthau's human-nature level (first image) to the systemic level (third image): international anarchy forces states into self-help and security maximization.",
            expHi = "केनेथ वाल्ट्ज़ (संरचनात्मक/नव-यथार्थवाद) ने संघर्ष का मूल कारण मानव स्वभाव के स्थान पर अंतर्राष्ट्रीय व्यवस्था की अराजक संरचना (Anarchy) और आत्म-सहायता (Self-help) को माना।",
            yearTag = "UGC NET Political Science 2021 PYQ",
            subTopic = "Unit V: International Relations (Realism, Neorealism, Constructivism)"
        ),
        RawUgcNetPyqSeed(
            qEn = "Chester Barnard in 'The Functions of the Executive' (1938) argued that organizational authority is effective only when a communication falls within the subordinate's:",
            qHi = "चेस्टर बर्नार्ड ने अपनी कृति 'द फंक्शन्स ऑफ द एग्जीक्यूटिव' (1938) में प्रतिपादित किया कि संगठनात्मक प्राधिकार तभी प्रभावी होता है जब आदेश अधीनस्थ के किस क्षेत्र के भीतर आता है?",
            optsEn = listOf(
                "Zone of Indifference (Acceptance Theory of Authority)",
                "Zone of Proximal Development",
                "Span of Control (Graicunas Formula)",
                "Hierarchy of Needs (Self-Actualization)"
            ),
            optsHi = listOf(
                "उदासीनता का क्षेत्र / Zone of Indifference (प्राधिकार का स्वीकृति सिद्धांत)",
                "समीपस्थ विकास का क्षेत्र",
                "नियंत्रण का विस्तार (ग्रैकुनास सूत्र)",
                "आवश्यकताओं का पदानुक्रम (आत्म-सिद्धि)"
            ),
            expEn = "Chester Barnard formulated the Acceptance Theory of Authority, stating that orders are unquestioningly obeyed when they fall inside the subordinate's 'Zone of Indifference' (later termed Zone of Acceptance by Herbert Simon).",
            expHi = "चेस्टर बर्नार्ड ने प्राधिकार का स्वीकृति सिद्धांत दिया, जिसके अनुसार अधीनस्थ उन आदेशों को बिना प्रश्न स्वीकार करते हैं जो उनके 'उदासीनता के क्षेत्र' (Zone of Indifference) में आते हैं।",
            yearTag = "UGC NET Political Science 2020 PYQ",
            subTopic = "Unit IX: Public Administration (Barnard, Simon, Weber, Riggs)"
        )
    )

    // ==================== 3. GEOGRAPHY (भूगोल — Code 080) ====================
    val geographySeeds: List<RawUgcNetPyqSeed> = listOf(
        RawUgcNetPyqSeed(
            qEn = "How does Walter Penck's model of Morphological System / Slope Development ('Die Morphologische Analyse', 1924) fundamentally differ from W.M. Davis's Geographical Cycle?",
            qHi = "वाल्टर पेंक का आकृति-विज्ञानी तंत्र / ढाल विकास मॉडल (1924) डब्ल्यू.एम. डेविस के भौगोलिक चक्र से मूल रूप से किस प्रकार भिन्न है?",
            optsEn = listOf(
                "Penck proposed that upliftment and erosion occur simultaneously (rate of uplift vs degradation determines waxing/Aufsteigende, uniform/Gleichformige, or waning/Absteigende development) and slopes retreat parallelly",
                "Penck assumed rapid instantaneous upliftment followed by complete tectonic stability until peneplanation",
                "Penck argued that landform evolution depends solely on climatic variations and glacial cycles",
                "Penck rejected endogenic forces entirely in slope evolution"
            ),
            optsHi = listOf(
                "पेंक के अनुसार उत्थान और अपरदन साथ-साथ चलते हैं (Aufsteigende, Gleichformige, Absteigende अवस्थाएँ) तथा ढाल का समानांतर निवर्तन होता है",
                "पेंक ने माना कि पहले तीव्र उत्थान पूर्ण होता है और उसके बाद ही अपरदन प्रारंभ होता है",
                "पेंक ने माना कि स्थलरूप विकास केवल जलवायु परिवर्तनों पर निर्भर करता है",
                "पेंक ने ढाल विकास में अंतर्जात बलों की भूमिका को पूर्णतः नकार दिया"
            ),
            expEn = "Unlike Davis (who assumed rapid uplift followed by erosion in youth, maturity, old age to form a peneplain), Penck argued that uplift and denudation occur concurrently through Aufsteigende (waxing/convex), Gleichformige (uniform/straight), and Absteigende (waning/concave) phases ending in an Endrumpf.",
            expHi = "डेविस के विपरीत पेंक ने माना कि उत्थान और अपरदन एक साथ कार्य करते हैं तथा विकास की तीन अवस्थाएँ (आउफस्टाइगेंडे, ग्लाइखफॉर्मिगे, अबस्टाइगेंडे) अंततः 'एंडरम्फ' (Endrumpf) का निर्माण करती हैं।",
            yearTag = "UGC NET Geography June 2024 PYQ",
            subTopic = "Unit I: Geomorphology (Davis, Penck, King Slope Models)"
        ),
        RawUgcNetPyqSeed(
            qEn = "In Walter Christaller's Central Place Theory (1933), which K-value represents the 'Administrative Principle' where lower-order centers lie completely inside the market area of the higher-order center?",
            qHi = "वाल्टर क्रिस्टालर के 'केंद्रीय स्थल सिद्धांत' (Central Place Theory, 1933) में कौन-सा K-मान 'प्रशासनिक सिद्धांत' (Administrative Principle) को दर्शाता है?",
            optsEn = listOf(
                "K = 7 (Administrative Principle)",
                "K = 3 (Marketing Principle)",
                "K = 4 (Transport / Traffic Principle)",
                "K = 9 (Industrial Agglomeration Principle)"
            ),
            optsHi = listOf(
                "K = 7 (प्रशासनिक सिद्धांत / Administrative Principle)",
                "K = 3 (विपणन सिद्धांत / Marketing Principle)",
                "K = 4 (परिवहन सिद्धांत / Transport Principle)",
                "K = 9 (औद्योगिक संकुलन सिद्धांत)"
            ),
            expEn = "Christaller defined three hierarchical arrangements of central places in Southern Germany: Marketing Principle (K = 3), Transport/Traffic Principle (K = 4), and Administrative Principle (K = 7, where all 6 satellite settlements + 1 central place = 7).",
            expHi = "क्रिस्टालर ने केंद्रीय स्थल पदानुक्रम के तीन नियम दिए: विपणन सिद्धांत (K = 3), परिवहन सिद्धांत (K = 4) तथा प्रशासनिक सिद्धांत (K = 7)।",
            yearTag = "UGC NET Geography Dec 2023 PYQ",
            subTopic = "Unit V: Population & Settlement Geography (Christaller & Losch)"
        ),
        RawUgcNetPyqSeed(
            qEn = "According to Köppen's Climatic Classification, which climate code represents the 'Monsoon Type with Short Dry Winter Season' found along the Western Coast of India south of Goa?",
            qHi = "कोपेन के जलवायु वर्गीकरण के अनुसार, गोवा के दक्षिण में भारत के पश्चिमी तट (मालाबार तट) पर पाई जाने वाली 'लघु शुष्क शीत ऋतु वाली मानसूनी जलवायु' का संकेत क्या है?",
            optsEn = listOf(
                "Amw",
                "As",
                "Cwg",
                "BShw"
            ),
            optsHi = listOf(
                "Amw (लघु शुष्क शीत ऋतु वाली मानसूनी जलवायु)",
                "As (शुष्क ग्रीष्म ऋतु वाली मानसूनी — कोरोमंडल तट)",
                "Cwg (शुष्क शीत ऋतु वाली मानसूनी — गंगा का मैदान)",
                "BShw (अर्ध-शुष्क स्टेपी जलवायु)"
            ),
            expEn = "In Köppen's classification of India: Amw covers the Konkan/Malabar coast south of Goa; As covers the Coromandel coast (dry summer, winter rain); Cwg covers the Northern Plains; E covers the high Himalayas.",
            expHi = "कोपेन के अनुसार भारत में Amw कोंकण/मालाबार तट, As कोरोमंडल तट (तमिलनाडु), Cwg उत्तर भारत का विशाल मैदान तथा BWhw थार मरुस्थल को दर्शाता है।",
            yearTag = "UGC NET Geography June 2023 PYQ",
            subTopic = "Unit II & IX: Climatology & Geography of India"
        ),
        RawUgcNetPyqSeed(
            qEn = "Who coined the term 'Geopolitik' in 1899 and viewed the State as a living geographical organism in space?",
            qHi = "1899 में सर्वप्रथम 'जियोपॉलिटिक' (Geopolitik / भू-राजनीति) शब्द किसने गढ़ा और राज्य को एक जीवित भौगोलिक जीव के रूप में देखा?",
            optsEn = listOf(
                "Rudolf Kjellén (Swedish political scientist, expanding Friedrich Ratzel's organic state theory)",
                "Halford J. Mackinder (Heartland Theory, 1904)",
                "Nicholas J. Spykman (Rimland Theory, 1944)",
                "Alfred Thayer Mahan (Sea Power Theory)"
            ),
            optsHi = listOf(
                "रुडोल्फ जेलेन (Rudolf Kjellén — रैटज़ेल के जैविक राज्य सिद्धांत का विस्तार)",
                "हैलफोर्ड मैकिंडर (हार्टलैंड सिद्धांत, 1904)",
                "निकोलस स्पाइकमैन (रिमलैंड सिद्धांत, 1944)",
                "अल्फ्रेड थेयर महान (समुद्री शक्ति सिद्धांत)"
            ),
            expEn = "Swedish scholar Rudolf Kjellén coined the term 'Geopolitik' in 1899, building on Friedrich Ratzel's 'Politische Geographie' (1897) and the concept of Lebensraum.",
            expHi = "स्वीडिश विद्वान रुडोल्फ जेलेन ने 1899 में 'जियोपॉलिटिक' शब्द का सर्वप्रथम प्रयोग किया, जो फ्रेडरिक रैटज़ेल के जैविक राज्य सिद्धांत पर आधारित था।",
            yearTag = "UGC NET Geography Dec 2022 PYQ",
            subTopic = "Unit VII & VIII: Political Geography & Geographical Thought"
        ),
        RawUgcNetPyqSeed(
            qEn = "In Remote Sensing, why does healthy green vegetation exhibit a very high reflectance peak in the Near-Infrared (NIR, 0.7–1.3 μm) band compared to visible red light?",
            qHi = "सुदूर संवेदन (Remote Sensing) में स्वस्थ हरी वनस्पति दृश्य लाल प्रकाश की तुलना में निकट-अवरक्त (NIR, 0.7–1.3 μm) बैंड में अत्यधिक परावर्तन (Reflectance) क्यों दर्शाती है?",
            optsEn = listOf(
                "Internal spongy mesophyll cell structure scatters NIR radiation while chlorophyll strongly absorbs blue and red wavelengths",
                "Chlorophyll reflects 90% of red light and absorbs all NIR light",
                "Water content in the leaf middle infrared region causes high NIR reflection",
                "Thermal emission from plant roots peaks at 0.8 μm"
            ),
            optsHi = listOf(
                "पत्ती की आंतरिक स्पंजी मेसोफिल कोशिका संरचना NIR विकिरण को परावर्तित करती है जबकि क्लोरोफिल नीले और लाल प्रकाश को अवशोषित करता है",
                "क्लोरोफिल लाल प्रकाश का 90% परावर्तित करता है और NIR को अवशोषित करता है",
                "पत्ती में जल की मात्रा NIR परावर्तन को बढ़ाती है",
                "पौधों की जड़ों से तापीय उत्सर्जन 0.8 μm पर अधिकतम होता है"
            ),
            expEn = "Healthy vegetation absorbs Blue (0.45 μm) and Red (0.67 μm) for photosynthesis via chlorophyll, while internal spongy mesophyll cells strongly reflect Near-Infrared (NIR, 0.7–1.3 μm). This sharp contrast forms the basis of NDVI = (NIR - Red) / (NIR + Red).",
            expHi = "क्लोरोफिल प्रकाश-संश्लेषण हेतु लाल व नीले प्रकाश को अवशोषित करता है, जबकि स्पंजी मेसोफिल कोशिकाएँ NIR को तीव्रता से परावर्तित करती हैं; इसी से NDVI = (NIR - Red)/(NIR + Red) की गणना होती है।",
            yearTag = "UGC NET Geography 2021 PYQ",
            subTopic = "Unit X: Geographic Techniques (Remote Sensing, GIS & NDVI)"
        )
    )

    // ==================== 4. ECONOMICS (अर्थशास्त्र — Code 001) ====================
    val economicsSeeds: List<RawUgcNetPyqSeed> = listOf(
        RawUgcNetPyqSeed(
            qEn = "In the Hicks-Hansen IS-LM model, Fiscal Policy is completely ineffective (100% Crowding Out) when the LM curve is:",
            qHi = "हिक्स-हैंसन के IS-LM मॉडल में राजकोषीय नीति (Fiscal Policy) तब पूर्णतः अप्रभावी (100% क्राउडिंग आउट) होती है जब LM वक्र होता है:",
            optsEn = listOf(
                "Perfectly Vertical (Classical Range — zero interest elasticity of money demand)",
                "Perfectly Horizontal (Keynesian Liquidity Trap — infinite interest elasticity of money demand)",
                "Upward sloping with low interest elasticity of investment",
                "Downward sloping parallel to the IS curve"
            ),
            optsHi = listOf(
                "पूर्णतः ऊर्ध्वाधर / Vertical (क्लासिकल रेंज — मुद्रा की सट्टा मांग की ब्याज लोच शून्य)",
                "पूर्णतः क्षैतिज / Horizontal (कीन्सियन तरलता जाल — मुद्रा मांग की ब्याज लोच अनंत)",
                "धनात्मक ढाल वाला",
                "IS वक्र के समानांतर ऋणात्मक ढाल वाला"
            ),
            expEn = "When the LM curve is vertical (Classical range, interest elasticity of money demand h = 0), an expansionary fiscal shift of the IS curve only raises the interest rate and crowds out private investment completely, leaving equilibrium income Y unchanged.",
            expHi = "जब LM वक्र पूर्णतः ऊर्ध्वाधर (क्लासिकल क्षेत्र) होता है, तब विस्तारवादी राजकोषीय नीति केवल ब्याज दर बढ़ाती है और निजी निवेश का 100% बहिर्गमन (Crowding Out) हो जाता है।",
            yearTag = "UGC NET Economics June 2024 PYQ",
            subTopic = "Unit II: Macroeconomics (IS-LM Model, Fiscal & Monetary Policy)"
        ),
        RawUgcNetPyqSeed(
            qEn = "In Econometrics, the presence of 'Heteroscedasticity' (non-constant error variance across observations) in a Classical Linear Regression Model (CLRM) results in OLS estimators that are:",
            qHi = "अर्थमिति (Econometrics) में क्लासिकल रैखिक प्रतिगमन मॉडल (CLRM) में 'विषमविचालिता' (Heteroscedasticity) की उपस्थिति से साधारण न्यूनतम वर्ग (OLS) आकलक कैसे हो जाते हैं?",
            optsEn = listOf(
                "Still Linear and Unbiased, but no longer Efficient (not minimum variance / not BLUE), making standard t and F tests invalid",
                "Biased and Inconsistent even in large samples",
                "Nonlinear but Minimum Variance (BLUE)",
                "Identically zero with R-squared equal to 1"
            ),
            optsHi = listOf(
                "रैखिक और निष्पक्ष (Unbiased) बने रहते हैं, किंतु दक्ष (Efficient / न्यूनतम प्रसरण / BLUE) नहीं रहते तथा t एवं F परीक्षण अमान्य हो जाते हैं",
                "पक्षपातपूर्ण (Biased) और असंगत (Inconsistent) हो जाते हैं",
                "अरैखिक किंतु न्यूनतम प्रसरण वाले बने रहते हैं",
                "शून्य हो जाते हैं और R² = 1 हो जाता है"
            ),
            expEn = "Under heteroscedasticity (and similarly autocorrelation without lagged dependent variables), OLS estimators remain linear, unbiased, and consistent, but lose minimum variance (no longer BLUE), biasing standard errors and invalidating t and F tests.",
            expHi = "विषमविचालिता (Heteroscedasticity) होने पर OLS आकलक निष्पक्ष (Unbiased) तो रहते हैं परंतु न्यूनतम प्रसरण (Efficient / BLUE) नहीं रहते, जिससे मानक त्रुटियाँ तथा t व F परीक्षण अविश्वसनीय हो जाते हैं।",
            yearTag = "UGC NET Economics Dec 2023 PYQ",
            subTopic = "Unit III: Statistics and Econometrics (CLRM Violations)"
        ),
        RawUgcNetPyqSeed(
            qEn = "According to the Stolper-Samuelson Theorem in International Trade (derived from the Heckscher-Ohlin framework), free trade leads to:",
            qHi = "अंतर्राष्ट्रीय व्यापार में स्टोलपर-सैमुअलसन प्रमेय (Stolper-Samuelson Theorem) के अनुसार मुक्त व्यापार का क्या परिणाम होता है?",
            optsEn = listOf(
                "An increase in the real return (reward) to the abundant factor of production and a fall in the real return to the scarce factor",
                "A fall in the real return to the abundant factor and a rise in the scarce factor",
                "Complete equalization of nominal exchange rates across all trading nations",
                "Deindustrialization caused by natural resource discoveries (Dutch Disease)"
            ),
            optsHi = listOf(
                "प्रचुर उत्पादन कारक (Abundant Factor) के वास्तविक प्रतिफल में वृद्धि और दुर्लभ कारक के वास्तविक प्रतिफल में कमी",
                "प्रचुर कारक के वास्तविक प्रतिफल में कमी और दुर्लभ कारक में वृद्धि",
                "सभी व्यापारिक देशों में नाममात्र विनिमय दरों का पूर्ण समानीकरण",
                "प्राकृतिक संसाधनों की खोज से वि-औद्योगीकरण (डच डिजीज)"
            ),
            expEn = "The Stolper-Samuelson theorem (1941) shows that opening to free trade raises the relative price of the exported good, which increases the real income/reward of the factor used intensively in that export (the abundant factor) and lowers the real income of the scarce factor.",
            expHi = "स्टोलपर-सैमुअलसन प्रमेय (1941) के अनुसार मुक्त व्यापार से प्रचुर संसाधन (जिसका निर्यात वस्तु में सघन उपयोग होता है) की वास्तविक आय बढ़ती है और दुर्लभ संसाधन की वास्तविक आय घटती है।",
            yearTag = "UGC NET Economics June 2023 PYQ",
            subTopic = "Unit V: International Economics (Heckscher-Ohlin & Stolper-Samuelson)"
        ),
        RawUgcNetPyqSeed(
            qEn = "In Robert Solow's Neoclassical Growth Model, when the economy is at its steady-state equilibrium, what is the growth rate of output per worker (y = Y/L) in the absence of technological progress?",
            qHi = "रॉबर्ट सोलो के नव-शास्त्रीय समृद्धि मॉडल (Solow Growth Model) में तकनीकी प्रगति की अनुपस्थिति में स्थिर-अवस्था संतुलन (Steady-State) पर प्रति श्रमिक उत्पादन (y = Y/L) की वृद्धि दर क्या होती है?",
            optsEn = listOf(
                "Zero (output per worker and capital per worker remain constant, while total output Y grows at population growth rate n)",
                "Equal to the savings rate s divided by the depreciation rate δ",
                "Equal to the population growth rate n plus depreciation rate δ",
                "Infinite due to increasing returns to capital"
            ),
            optsHi = listOf(
                "शून्य (प्रति श्रमिक उत्पादन और प्रति श्रमिक पूँजी स्थिर रहते हैं, जबकि कुल उत्पादन Y जनसंख्या वृद्धि दर n से बढ़ता है)",
                "बचत दर s और मूल्यह्रास दर δ के अनुपात के बराबर",
                "जनसंख्या वृद्धि दर n और मूल्यह्रास दर δ के योग के बराबर",
                "पूँजी के बढ़ते प्रतिफल के कारण अनंत"
            ),
            expEn = "In the Solow model without exogenous technical progress, at steady state (s·f(k*) = (n + δ)k*), capital per worker (k*) and output per worker (y*) grow at 0%, while aggregate output (Y) and capital (K) grow at rate n.",
            expHi = "सोलो मॉडल में बिना तकनीकी प्रगति के स्थिर-अवस्था (Steady State) पर प्रति श्रमिक पूँजी (k*) और प्रति श्रमिक आय (y*) की वृद्धि दर शून्य (0%) होती है, जबकि कुल आय (Y) की वृद्धि दर n होती है।",
            yearTag = "UGC NET Economics Dec 2022 PYQ",
            subTopic = "Unit VIII: Growth and Development Economics (Harrod-Domar, Solow)"
        ),
        RawUgcNetPyqSeed(
            qEn = "In Microeconomics, if the elasticity of substitution (σ) of a Constant Elasticity of Substitution (CES) production function approaches 1, the CES function converges to which production function?",
            qHi = "व्यष्टि अर्थशास्त्र में यदि स्थिर प्रतिस्थापन लोच (CES) उत्पादन फलन में प्रतिस्थापन की लोच (σ) का मान 1 की ओर अग्रसर होता है, तो CES फलन किस उत्पादन फलन में परिवर्तित हो जाता है?",
            optsEn = listOf(
                "Cobb-Douglas Production Function (σ = 1)",
                "Leontief Fixed-Proportions Production Function (σ = 0)",
                "Linear Perfect-Substitutes Production Function (σ = ∞)",
                "Translog Utility Function"
            ),
            optsHi = listOf(
                "कॉब-डगलस उत्पादन फलन (σ = 1)",
                "लियोनटिफ स्थिर-अनुपात उत्पादन फलन (σ = 0)",
                "रैखिक पूर्ण-स्थानापन्न उत्पादन फलन (σ = ∞)",
                "ट्रांसलॉग उपयोगिता फलन"
            ),
            expEn = "The Arrow-Chenery-Minhas-Solow CES production function Q = A[αK^(-ρ) + (1-α)L^(-ρ)]^(-1/ρ) has σ = 1/(1+ρ). As ρ → 0 (so σ → 1), it converges to Cobb-Douglas; as ρ → ∞ (σ → 0), Leontief; as ρ → -1 (σ → ∞), Linear.",
            expHi = "CES उत्पादन फलन में σ = 1/(1+ρ) होता है। जब ρ → 0 अर्थात् σ = 1 होता है, तो यह कॉब-डगलस फलन बन जाता है; σ = 0 पर लियोनटिफ तथा σ = ∞ पर रैखिक फलन बनता है।",
            yearTag = "UGC NET Economics 2021 PYQ",
            subTopic = "Unit I: Microeconomics (Theory of Production & Cost)"
        )
    )

    // ==================== 5. HINDI LITERATURE (हिंदी साहित्य — Code 020) ====================
    val hindiSeeds: List<RawUgcNetPyqSeed> = listOf(
        RawUgcNetPyqSeed(
            qEn = "आचार्य रामचंद्र शुक्ल ने अपने 'हिंदी साहित्य का इतिहास' (1929) में आदिकाल (संवत् 1050–1375 वि.) को किस नाम से अभिहित किया है?",
            qHi = "आचार्य रामचंद्र शुक्ल ने अपने 'हिंदी साहित्य का इतिहास' (1929) में आदिकाल (संवत् 1050–1375 वि.) को किस नाम से अभिहित किया है?",
            optsEn = listOf(
                "वीरगाथा काल (12 रचनाओं के आधार पर)",
                "चारण काल (जॉर्ज ग्रियर्सन)",
                "सिद्ध-सामंती काल (राहुल सांकृत्यायन)",
                "बीजवपन काल (आचार्य महावीर प्रसाद द्विवेदी)"
            ),
            optsHi = listOf(
                "वीरगाथा काल (12 रचनाओं के आधार पर)",
                "चारण काल (जॉर्ज ग्रियर्सन)",
                "सिद्ध-सामंती काल (राहुल सांकृत्यायन)",
                "बीजवपन काल (आचार्य महावीर प्रसाद द्विवेदी)"
            ),
            expEn = "Acharya Ramchandra Shukla named the early period (Samvat 1050–1375) 'Veergatha Kal' based on 12 texts (4 Apabhramsha and 8 Deshbhasha texts), while Hazari Prasad Dwivedi named it 'Adikal'.",
            expHi = "आचार्य रामचंद्र शुक्ल ने 12 ग्रंथों (विजयपाल रासो, हम्मीर रासो, कीर्तिलता, कीर्तिपताका, खुमान रासो, बीसलदेव रासो, पृथ्वीराज रासो, जयचंद प्रकाश, जयमयंक जस चंद्रिका, परमाल रासो, खुसरो की पहेलियाँ, विद्यापति पदावली) के आधार पर इसे 'वीरगाथा काल' नाम दिया।",
            yearTag = "UGC NET Hindi June 2024 PYQ",
            subTopic = "इकाई II: हिंदी साहित्य का इतिहास (आदिकाल एवं नामकरण)"
        ),
        RawUgcNetPyqSeed(
            qEn = "भरतमुनि के रस-सूत्र ('विभावानुभावव्यभिचारिसंयोगाद्रसनिष्पत्तिः') के व्याख्याकारों और उनके सिद्धांतों का सही कालक्रमानुसार मिलान कौन-सा है?",
            qHi = "भरतमुनि के रस-सूत्र ('विभावानुभावव्यभिचारिसंयोगाद्रसनिष्पत्तिः') के व्याख्याकारों और उनके सिद्धांतों का सही कालक्रमानुसार मिलान कौन-सा है?",
            optsEn = listOf(
                "(1) भट्ट लोल्लट (उत्पत्तिवाद/आरोपवाद) → (2) शंकुक (अनुमितिवाद) → (3) भट्ट नायक (भुक्तिवाद/साधारणीकरण) → (4) अभिनवगुप्त (अभिव्यक्तिवाद)",
                "(1) अभिनवगुप्त → (2) भट्ट नायक → (3) शंकुक → (4) भट्ट लोल्लट",
                "(1) शंकुक → (2) भट्ट लोल्लट → (3) अभिनवगुप्त → (4) भट्ट नायक",
                "(1) भट्ट नायक → (2) भट्ट लोल्लट → (3) शंकुक → (4) अभिनवगुप्त"
            ),
            optsHi = listOf(
                "(1) भट्ट लोल्लट (उत्पत्तिवाद/आरोपवाद) → (2) शंकुक (अनुमितिवाद) → (3) भट्ट नायक (भुक्तिवाद/साधारणीकरण) → (4) अभिनवगुप्त (अभिव्यक्तिवाद)",
                "(1) अभिनवगुप्त → (2) भट्ट नायक → (3) शंकुक → (4) भट्ट लोल्लट",
                "(1) शंकुक → (2) भट्ट लोल्लट → (3) अभिनवगुप्त → (4) भट्ट नायक",
                "(1) भट्ट नायक → (2) भट्ट लोल्लट → (3) शंकुक → (4) अभिनवगुप्त"
            ),
            expEn = "The four classical commentators on Bharata Muni's Rasa Sutra in chronological order are Bhatta Lollata (Utpattivada, Mimamsa), Shankuka (Anumitivada, Nyaya), Bhatta Nayaka (Bhuktivada & Sadharanikarana, Sankhya), and Abhinavagupta (Abhivyaktivada, Shaiva Advaita).",
            expHi = "भरतमुनि के रस-सूत्र के चार प्रसिद्ध व्याख्याकार कालक्रमानुसार हैं: भट्ट लोल्लट (उत्पत्तिवाद), शंकुक (अनुमितिवाद), भट्ट नायक (भुक्तिवाद एवं साधारणीकरण) तथा अभिनवगुप्त (अभिव्यक्तिवाद)।",
            yearTag = "UGC NET Hindi Dec 2023 PYQ",
            subTopic = "इकाई III: साहित्यशास्त्र (भारतीय एवं पाश्चात्य काव्यशास्त्र)"
        ),
        RawUgcNetPyqSeed(
            qEn = "अज्ञेय (सच्चिदानंद हीरानंद वात्स्यायन) द्वारा संपादित 'तार सप्तक' (1943) के सात कवियों का सही समूह कौन-सा है?",
            qHi = "अज्ञेय (सच्चिदानंद हीरानंद वात्स्यायन) द्वारा संपादित 'तार सप्तक' (1943) के सात कवियों का सही समूह कौन-सा है?",
            optsEn = listOf(
                "अज्ञेय, गजानन माधव मुक्तिबोध, नेमिचंद्र जैन, भारतभूषण अग्रवाल, प्रभाकर माचवे, गिरिजाकुमार माथुर, रामविलास शर्मा",
                "शमशेर बहादुर सिंह, भवानीप्रसाद मिश्र, रघुवीर सहाय, धर्मवीर भारती, नरेश मेहता, हरिनारायण व्यास, शकुंतला माथुर",
                "केदारनाथ सिंह, कुँवर नारायण, सर्वेश्वरदयाल सक्सेना, विजयदेव नारायण साही, प्रयाग नारायण त्रिपाठी, कीर्ति चौधरी, मदन वात्स्यायन",
                "जयशंकर प्रसाद, सूर्यकांत त्रिपाठी निराला, सुमित्रानंदन पंत, महादेवी वर्मा, रामधारी सिंह दिनकर, नागार्जुन, केदारनाथ अग्रवाल"
            ),
            optsHi = listOf(
                "अज्ञेय, गजानन माधव मुक्तिबोध, नेमिचंद्र जैन, भारतभूषण अग्रवाल, प्रभाकर माचवे, गिरिजाकुमार माथुर, रामविलास शर्मा",
                "शमशेर बहादुर सिंह, भवानीप्रसाद मिश्र, रघुवीर सहाय, धर्मवीर भारती, नरेश मेहता, हरिनारायण व्यास, शकुंतला माथुर",
                "केदारनाथ सिंह, कुँवर नारायण, सर्वेश्वरदयाल सक्सेना, विजयदेव नारायण साही, प्रयाग नारायण त्रिपाठी, कीर्ति चौधरी, मदन वात्स्यायन",
                "जयशंकर प्रसाद, सूर्यकांत त्रिपाठी निराला, सुमित्रानंदन पंत, महादेवी वर्मा, रामधारी सिंह दिनकर, नागार्जुन, केदारनाथ अग्रवाल"
            ),
            expEn = "Tar Saptak (1943), which inaugurated Prayogvad in Hindi poetry, included 7 poets: Agyeya, Muktibodh, Nemichandra Jain, Bharat Bhushan Agarwal, Prabhakar Machwe, Girija Kumar Mathur, and Ramvilas Sharma.",
            expHi = "'तार सप्तक' (1943) से हिंदी में प्रयोगवाद का प्रारंभ माना जाता है; इसके सात कवि हैं: अज्ञेय, मुक्तिबोध, नेमिचंद्र जैन, भारतभूषण अग्रवाल, प्रभाकर माचवे, गिरिजाकुमार माथुर और रामविलास शर्मा।",
            yearTag = "UGC NET Hindi June 2023 PYQ",
            subTopic = "इकाई II एवं V: आधुनिक काल (प्रयोगवाद एवं तार सप्तक)"
        ),
        RawUgcNetPyqSeed(
            qEn = "UGC NET पाठ्यक्रम में शामिल प्रसिद्ध आंचलिक उपन्यास 'मैला आँचल' (1954, फणीश्वरनाथ रेणु) की कथावस्तु बिहार के किस अंचल और गाँव पर आधारित है?",
            qHi = "UGC NET पाठ्यक्रम में शामिल प्रसिद्ध आंचलिक उपन्यास 'मैला आँचल' (1954, फणीश्वरनाथ रेणु) की कथावस्तु बिहार के किस अंचल और गाँव पर आधारित है?",
            optsEn = listOf(
                "पूर्णिया जिले का मेरीगंज गाँव (डॉ. प्रशांत, कमला, बालदेव, बावनदास)",
                "गोरखपुर जिले का शिवपालगंज गाँव ('राग दरबारी' — श्रीलाल शुक्ल)",
                "बलिया जिले का गंगौली गाँव ('आधा गाँव' — राही मासूम रज़ा)",
                "अवध का बेलारी और सेमरी गाँव ('गोदान' — प्रेमचंद)"
            ),
            optsHi = listOf(
                "पूर्णिया जिले का मेरीगंज गाँव (डॉ. प्रशांत, कमला, बालदेव, बावनदास)",
                "गोरखपुर जिले का शिवपालगंज गाँव ('राग दरबारी' — श्रीलाल शुक्ल)",
                "बलिया जिले का गंगौली गाँव ('आधा गाँव' — राही मासूम रज़ा)",
                "अवध का बेलारी और सेमरी गाँव ('गोदान' — प्रेमचंद)"
            ),
            expEn = "Phanishwarnath Renu's 'Maila Anchal' (1954) is set in Maryganj village of Purnia district in Bihar (featuring Dr. Prashant, Kamla, Baldev, Bavandas). Shivpalganj is the setting of 'Raag Darbari' and Belari/Semari is 'Godaan'.",
            expHi = "फणीश्वरनाथ रेणु का 'मैला आँचल' (1954) पूर्णिया (बिहार) के मेरीगंज गाँव पर केंद्रित हिंदी का प्रथम आंचलिक उपन्यास है। शिवपालगंज 'राग दरबारी' तथा बेलारी 'गोदान' का गाँव है।",
            yearTag = "UGC NET Hindi Dec 2022 PYQ",
            subTopic = "इकाई VI: हिंदी उपन्यास (गोदान, मैला आँचल, राग दरबारी, तमस)"
        ),
        RawUgcNetPyqSeed(
            qEn = "अष्टछाप (1565 ई., गोस्वामी विट्ठलनाथ द्वारा स्थापित) के आठ कवियों में से वल्लभाचार्य के चार शिष्य कौन-से हैं?",
            qHi = "अष्टछाप (1565 ई., गोस्वामी विट्ठलनाथ द्वारा स्थापित) के आठ कवियों में से वल्लभाचार्य के चार शिष्य कौन-से हैं?",
            optsEn = listOf(
                "कुंभनदास, सूरदास, परमानंददास और कृष्णदास",
                "गोविंदस्वामी, छीतस्वामी, चतुर्भुजदास और नंददास",
                "सूरदास, नंददास, मीराबाई और रसखान",
                "कुंभनदास, नंददास, परमानंददास और चतुर्भुजदास"
            ),
            optsHi = listOf(
                "कुंभनदास, सूरदास, परमानंददास और कृष्णदास",
                "गोविंदस्वामी, छीतस्वामी, चतुर्भुजदास और नंददास",
                "सूरदास, नंददास, मीराबाई और रसखान",
                "कुंभनदास, नंददास, परमानंददास और चतुर्भुजदास"
            ),
            expEn = "Goswami Vitthalnath established Ashtachhap in 1565 CE with 4 disciples of his father Vallabhacharya (Kumbhandas, Surdas, Parmananddas, Krishnadas) and 4 of his own disciples (Govindswami, Chhitswami, Chaturbhujdas, Nanddas).",
            expHi = "गोस्वामी विट्ठलनाथ ने 1565 ई. में अष्टछाप की स्थापना की, जिसमें वल्लभाचार्य के 4 शिष्य (कुंभनदास, सूरदास, परमानंददास, कृष्णदास) और विट्ठलनाथ के 4 शिष्य (गोविंदस्वामी, छीतस्वामी, चतुर्भुजदास, नंददास) शामिल थे।",
            yearTag = "UGC NET Hindi 2021 PYQ",
            subTopic = "इकाई II: भक्तिकाल (सगुण कृष्णभक्ति धारा एवं अष्टछाप)"
        )
    )

    // ==================== 6. ENGLISH LITERATURE (अंग्रेज़ी साहित्य — Code 030) ====================
    val englishSeeds: List<RawUgcNetPyqSeed> = listOf(
        RawUgcNetPyqSeed(
            qEn = "In which essay did T.S. Eliot introduce the critical concept of 'Objective Correlative' to explain why Shakespeare's play lacks an adequate external equivalent for its protagonist's emotion?",
            qHi = "टी.एस. इलियट (T.S. Eliot) ने किस आलोचनात्मक निबंध में 'ऑब्जेक्टिव कोरिलेटिव' (Objective Correlative — वस्तुनिष्ठ सह-संबंधक) की अवधारणा प्रस्तुत की थी?",
            optsEn = listOf(
                "Hamlet and His Problems (1919)",
                "Tradition and the Individual Talent (1919)",
                "The Metaphysical Poets (1921)",
                "The Function of Criticism (1923)"
            ),
            optsHi = listOf(
                "हैमलेट एंड हिज़ प्रॉब्लम्स / Hamlet and His Problems (1919)",
                "ट्रेडिशन एंड द इंडिविजुअल टैलेंट (1919)",
                "द मेटाफिजिकल पोएट्स (1921 — Dissociation of Sensibility)",
                "द फंक्शन ऑफ क्रिटिसिज्म (1923)"
            ),
            expEn = "T.S. Eliot popularized 'Objective Correlative' (originally coined by Washington Allston) in 'Hamlet and His Problems' (1919), while 'Dissociation of Sensibility' was introduced in 'The Metaphysical Poets' (1921).",
            expHi = "टी.एस. इलियट ने 'हैमलेट एंड हिज़ प्रॉब्लम्स' (1919) में 'ऑब्जेक्टिव कोरिलेटिव' तथा 'द मेटाफिजिकल पोएट्स' (1921) में 'डिसोसिएशन ऑफ सेंसबिलिटी' की अवधारणा दी।",
            yearTag = "UGC NET English June 2024 PYQ",
            subTopic = "Unit VIII: Literary Criticism (New Criticism & Modernism)"
        ),
        RawUgcNetPyqSeed(
            qEn = "Who coined the term 'Gyno-criticism' in 'Towards a Feminist Poetics' (1979) and outlined the Feminine, Feminist, and Female phases of women's literary history?",
            qHi = "किस आलोचक ने 'टुवर्ड्स ए फेमिनिस्ट पोएटिक्स' (1979) में 'गाइनो-क्रिटिसिज्म' (Gynocriticism) शब्द गढ़ा और महिला लेखन के फेमिनिन, फेमिनिस्ट और फीमेल चरण बताए?",
            optsEn = listOf(
                "Elaine Showalter",
                "Sandra Gilbert and Susan Gubar ('The Madwoman in the Attic')",
                "Judith Butler ('Gender Trouble')",
                "Simone de Beauvoir ('The Second Sex')"
            ),
            optsHi = listOf(
                "इलेन शोवाल्टर (Elaine Showalter)",
                "सैंड्रा गिल्बर्ट और सुसान गुबार ('द मैडवुमन इन द एटिक')",
                "जूडिथ बटलर ('जेंडर ट्रबल')",
                "सिमोन द बोउवार ('द सेकंड सेक्स')"
            ),
            expEn = "Elaine Showalter coined 'Gynocritics' (studying women as writers rather than merely feminist critique of male texts) and divided women's literary tradition into Feminine (1840–1880), Feminist (1880–1920), and Female (1920–present) phases.",
            expHi = "इलेन शोवाल्टर ने महिला लेखिकाओं के स्वतंत्र साहित्यिक इतिहास के अध्ययन हेतु 'गाइनोक्रिटिसिज्म' शब्द दिया तथा इसके तीन चरण (Feminine, Feminist, Female) निर्धारित किए।",
            yearTag = "UGC NET English Dec 2023 PYQ",
            subTopic = "Unit IX: Literary Theory Post World War II (Feminist Criticism)"
        ),
        RawUgcNetPyqSeed(
            qEn = "Which work by Edward Said (1993) introduces the method of 'Contrapuntal Reading' to read canonical Western novels like Jane Austen's 'Mansfield Park' alongside their suppressed imperial histories?",
            qHi = "एडवर्ड सईद (Edward Said) की किस कृति (1993) में जेन ऑस्टेन के 'मैन्सफील्ड पार्क' जैसे पश्चिमी उपन्यासों में छिपे साम्राज्यवादी संदर्भों को पढ़ने के लिए 'कॉन्ट्रापंटल रीडिंग' (Contrapuntal Reading) पद्धति दी गई?",
            optsEn = listOf(
                "Culture and Imperialism (1993)",
                "Orientalism (1978)",
                "The World, the Text, and the Critic (1983)",
                "Covering Islam (1981)"
            ),
            optsHi = listOf(
                "कल्चर एंड इम्पीरियलिज्म / Culture and Imperialism (1993)",
                "ओरिएंटलिज्म / Orientalism (1978)",
                "द वर्ल्ड, द टेक्स्ट, एंड द क्रिटिक (1983)",
                "कवरिंग इस्लाम (1981)"
            ),
            expEn = "In 'Culture and Imperialism' (1993), Edward Said proposed 'Contrapuntal Reading' (borrowed from musical counterpoint) to reveal how Sir Thomas Bertram's estate in 'Mansfield Park' depends on slave plantations in Antigua.",
            expHi = "एडवर्ड सईद ने अपनी पुस्तक 'कल्चर एंड इम्पीरियलिज्म' (1993) में 'कॉन्ट्रापंटल रीडिंग' की अवधारणा प्रस्तुत की, जिसके द्वारा साहित्यिक कृतियों के साम्राज्यवादी अंतर्संबंधों का विश्लेषण किया जाता है।",
            yearTag = "UGC NET English June 2023 PYQ",
            subTopic = "Unit IX: Postcolonial Theory & Criticism"
        ),
        RawUgcNetPyqSeed(
            qEn = "In William Wordsworth and Samuel Taylor Coleridge's 'Lyrical Ballads', which edition first included Wordsworth's famous manifesto 'Preface to the Lyrical Ballads' defining poetry as 'the spontaneous overflow of powerful feelings'?",
            qHi = "विलियम वर्ड्सवर्थ और कॉलरिज के 'लिरिकल बैलेड्स' के किस संस्करण में सर्वप्रथम वर्ड्सवर्थ की प्रसिद्ध भूमिका 'प्रिफेस टू द लिरिकल बैलेड्स' जोड़ी गई थी?",
            optsEn = listOf(
                "Second Edition of 1800 (expanded further in 1802)",
                "First Anonymous Edition of 1798",
                "Fourth Edition of 1815",
                "Posthumous Edition of 1850 (along with 'The Prelude')"
            ),
            optsHi = listOf(
                "1800 ई. का द्वितीय संस्करण (1802 में और विस्तारित)",
                "1798 ई. का प्रथम अनाम संस्करण",
                "1815 ई. का चतुर्थ संस्करण",
                "1850 ई. का मरणोपरांत संस्करण"
            ),
            expEn = "Lyrical Ballads was first published in 1798 (opening with Coleridge's 'Rime of the Ancient Mariner' and closing with Wordsworth's 'Tintern Abbey'), while the famous critical 'Preface' was added in the 1800 second edition.",
            expHi = "'लिरिकल बैलेड्स' का प्रथम प्रकाशन 1798 में हुआ था, किंतु रोमांटिक काव्य-सिद्धांत का घोषणापत्र मानी जाने वाली प्रसिद्ध 'प्रिफेस' (Preface) इसके 1800 के दूसरे संस्करण में जोड़ी गई।",
            yearTag = "UGC NET English Dec 2022 PYQ",
            subTopic = "Unit II & VIII: Romantic Poetry & Criticism"
        ),
        RawUgcNetPyqSeed(
            qEn = "Which Indian English novel by Salman Rushdie (winner of the 1981 Booker Prize and 1993 Booker of Bookers) is narrated by Saleem Sinai, born at the exact stroke of midnight on 15 August 1947?",
            qHi = "सलमान रुश्दी के किस प्रसिद्ध भारतीय-अंग्रेज़ी उपन्यास (1981 बुकर पुरस्कार विजेता) का कथावाचक सलीम सिनाई है, जिसका जन्म 15 अगस्त 1947 की मध्यरात्रि को हुआ था?",
            optsEn = listOf(
                "Midnight's Children (1981)",
                "Shame (1983)",
                "The Moor's Last Sigh (1995)",
                "The Ground Beneath Her Feet (1999)"
            ),
            optsHi = listOf(
                "मिडनाइट्स चिल्ड्रन / Midnight's Children (1981)",
                "शेम / Shame (1983)",
                "द मूर्स लास्ट साई (1995)",
                "द ग्राउंड बिनीथ हर फीट (1999)"
            ),
            expEn = "Salman Rushdie's 'Midnight's Children' (1981) uses magic realism and historiographic metafiction as protagonist Saleem Sinai narrates his life to Padma alongside the history of post-independence India.",
            expHi = "सलमान रुश्दी के उपन्यास 'मिडनाइट्स चिल्ड्रन' (1981) में जादुई यथार्थवाद (Magic Realism) के माध्यम से सलीम सिनाई स्वतंत्र भारत के इतिहास की कथा पद्मा को सुनाता है।",
            yearTag = "UGC NET English 2021 PYQ",
            subTopic = "Unit III & VI: Fiction & English in India"
        )
    )

    // ==================== 7. COMMERCE (वाणिज्य — Code 008) ====================
    val commerceSeeds: List<RawUgcNetPyqSeed> = listOf(
        RawUgcNetPyqSeed(
            qEn = "According to Franco Modigliani and Merton Miller's Proposition I (1958, without corporate taxes), a firm's total market value and overall Weighted Average Cost of Capital (WACC / Ko):",
            qHi = "मोदिग्लियानी और मिलर (MM उपागम, 1958 — निगम करों की अनुपस्थिति में) के प्रथम प्रस्थापना (Proposition I) के अनुसार फर्म का कुल बाजार मूल्य और समग्र पूँजी लागत (WACC / Ko):",
            optsEn = listOf(
                "Are completely independent of its capital structure (debt-equity ratio) due to home-made leverage and arbitrage",
                "Are maximized at 100% debt financing due to lower cost of debt",
                "Exhibit a U-shaped curve at an optimal traditional debt-equity ratio",
                "Increase linearly only when dividend payout ratio is 100%"
            ),
            optsHi = listOf(
                "पूँजी संरचना (ऋण-समता अनुपात) से पूर्णतः स्वतंत्र होते हैं क्योंकि निवेशक 'होम-मेड लीवरेज' और अंतरपणन (Arbitrage) का प्रयोग करते हैं",
                "100% ऋण वित्तपोषण पर अधिकतम होते हैं",
                "इष्टतम ऋण-समता अनुपात पर U-आकार का वक्र बनाते हैं",
                "केवल 100% लाभांश भुगतान अनुपात पर ही बढ़ते हैं"
            ),
            expEn = "Under MM Proposition I without taxes (1958), capital structure is irrelevant: V_L = V_U, and WACC (Ko) remains constant because any increase in cheaper debt is exactly offset by a higher cost of equity (Ke) due to financial risk.",
            expHi = "बिना करों के मोदिग्लियानी-मिलर (1958) सिद्धांत के अनुसार उत्तोलित फर्म का मूल्य (V_L) और अनुत्तोलित फर्म का मूल्य (V_U) समान होता है तथा WACC (Ko) स्थिर रहता है।",
            yearTag = "UGC NET Commerce June 2024 PYQ",
            subTopic = "Unit IV: Business Finance (Capital Structure Theories)"
        ),
        RawUgcNetPyqSeed(
            qEn = "Under Ind AS 7 (and AS 3) 'Statement of Cash Flows', for a non-financial manufacturing enterprise, 'Dividend Paid' to shareholders is classified under which activity?",
            qHi = "भारतीय लेखा मानक Ind AS 7 (तथा AS 3) 'रोकड़ प्रवाह विवरण' के अनुसार एक गैर-वित्तीय विनिर्माण कंपनी द्वारा अंशधारियों को 'भुगतान किया गया लाभांश' (Dividend Paid) किस गतिविधि के अंतर्गत वर्गीकृत किया जाता है?",
            optsEn = listOf(
                "Cash Flow from Financing Activities",
                "Cash Flow from Operating Activities",
                "Cash Flow from Investing Activities",
                "Extraordinary Non-Cash Reserve Item"
            ),
            optsHi = listOf(
                "वित्तीय गतिविधियों से रोकड़ प्रवाह (Financing Activities)",
                "परिचालन गतिविधियों से रोकड़ प्रवाह (Operating Activities)",
                "निवेश गतिविधियों से रोकड़ प्रवाह (Investing Activities)",
                "असाधारण गैर-रोकड़ मद"
            ),
            expEn = "For both financial and non-financial enterprises, Dividend Paid is always a Financing Activity because it represents the cost of obtaining financial resources (equity capital), whereas Dividend Received is Investing for non-financial firms and Operating for financial firms.",
            expHi = "लाभांश का भुगतान (Dividend Paid) सदैव वित्तीय गतिविधि (Financing Activity) होता है, जबकि गैर-वित्तीय संस्था के लिए प्राप्त लाभांश (Dividend Received) निवेश गतिविधि (Investing Activity) होता है।",
            yearTag = "UGC NET Commerce Dec 2023 PYQ",
            subTopic = "Unit II: Accounting and Auditing (Cash Flow Statement)"
        ),
        RawUgcNetPyqSeed(
            qEn = "Under the Basel III Capital Accord implemented by the Reserve Bank of India (RBI), what is the minimum required Common Equity Tier 1 (CET1) ratio and total Capital to Risk-Weighted Assets Ratio (CRAR) excluding Capital Conservation Buffer?",
            qHi = "भारतीय रिज़र्व बैंक (RBI) द्वारा लागू बेसल-III (Basel III) मानकों के अनुसार (पूंजी संरक्षण बफर को छोड़कर) न्यूनतम कॉमन इक्विटी टियर-1 (CET1) और कुल पूंजी पर्याप्तता अनुपात (CRAR) कितना है?",
            optsEn = listOf(
                "Minimum CET1 of 5.5% and Minimum Total CRAR of 9.0% (plus 2.5% Capital Conservation Buffer = 11.5% in India)",
                "Minimum CET1 of 2.0% and Minimum Total CRAR of 6.0%",
                "Minimum CET1 of 8.0% and Minimum Total CRAR of 15.0%",
                "Minimum CET1 of 4.0% and Minimum Total CRAR of 8.0% without any buffer"
            ),
            optsHi = listOf(
                "न्यूनतम CET1 5.5% और कुल न्यूनतम CRAR 9.0% (2.5% पूंजी संरक्षण बफर सहित भारत में 11.5%)",
                "न्यूनतम CET1 2.0% और कुल CRAR 6.0%",
                "न्यूनतम CET1 8.0% और कुल CRAR 15.0%",
                "न्यूनतम CET1 4.0% और कुल CRAR 8.0%"
            ),
            expEn = "While international Basel III norms prescribe 4.5% CET1 and 8% CRAR (+ 2.5% CCB = 10.5%), the RBI prescribes stricter norms for Indian scheduled commercial banks: 5.5% CET1, 7% Tier-1, and 9% total CRAR (+ 2.5% CCB = 11.5%).",
            expHi = "अंतर्राष्ट्रीय बेसल-III मानक 8% CRAR निर्धारित करते हैं, किंतु RBI ने भारतीय वाणिज्यिक बैंकों के लिए न्यूनतम CET1 5.5% और कुल CRAR 9.0% (2.5% CCB बफर सहित 11.5%) निर्धारित किया है।",
            yearTag = "UGC NET Commerce June 2023 PYQ",
            subTopic = "Unit VII: Banking and Financial Institutions (Basel Norms & NPA)"
        ),
        RawUgcNetPyqSeed(
            qEn = "Under the Income Tax Act, 1961, which Section governs the deduction in respect of contribution to the National Pension System (NPS) up to an additional ₹50,000 over and above the ₹1,50,000 limit of Section 80CCE?",
            qHi = "आयकर अधिनियम, 1961 की कौन-सी धारा राष्ट्रीय पेंशन प्रणाली (NPS) में अंशदान के लिए धारा 80CCE की ₹1,50,000 की सीमा के अतिरिक्त ₹50,000 तक की अतिरिक्त कटौती प्रदान करती है?",
            optsEn = listOf(
                "Section 80CCD(1B)",
                "Section 80D",
                "Section 80TTA",
                "Section 80EE"
            ),
            optsHi = listOf(
                "धारा 80CCD(1B)",
                "धारा 80D (स्वास्थ्य बीमा प्रीमियम)",
                "धारा 80TTA (बचत खाता ब्याज)",
                "धारा 80EE (आवास ऋण ब्याज)"
            ),
            expEn = "Section 80CCD(1B) of the Income Tax Act, 1961 allows an exclusive additional deduction of up to ₹50,000 for individual contributions to the National Pension System (NPS), over and above the ₹1,50,000 aggregate cap under Section 80CCE.",
            expHi = "आयकर अधिनियम, 1961 की धारा 80CCD(1B) के अंतर्गत राष्ट्रीय पेंशन प्रणाली (NPS) में अंशदान पर ₹1,50,000 की सामान्य सीमा के अतिरिक्त ₹50,000 की विशेष कटौती मिलती है।",
            yearTag = "UGC NET Commerce Dec 2022 PYQ",
            subTopic = "Unit X: Income-tax and Corporate Tax Planning"
        ),
        RawUgcNetPyqSeed(
            qEn = "In International Business, Raymond Vernon's 'International Product Life Cycle' (IPLC) theory (1966) explains how a new technology-intensive product progresses through which sequence of stages?",
            qHi = "अंतर्राष्ट्रीय व्यवसाय में रेमंड वर्नन के 'अंतर्राष्ट्रीय उत्पाद जीवन चक्र' (IPLC, 1966) सिद्धांत के अनुसार एक नया तकनीकी उत्पाद किन चरणों के क्रम से गुजरता है?",
            optsEn = listOf(
                "(1) New Product Stage (innovating country produces & consumes) → (2) Maturing Product Stage (exports & FDI to developed peers) → (3) Standardized Product Stage (production shifts to developing countries, innovating country becomes net importer)",
                "(1) Standardized Stage → (2) Maturing Stage → (3) New Product Innovation Stage",
                "(1) Absolute Advantage → (2) Comparative Advantage → (3) Mercantilist Surplus",
                "(1) Ethnocentric → (2) Polycentric → (3) Regiocentric → (4) Geocentric"
            ),
            optsHi = listOf(
                "(1) नवीन उत्पाद चरण → (2) परिपक्व उत्पाद चरण → (3) मानकीकृत उत्पाद चरण (उत्पादन विकासशील देशों में स्थानांतरित होता है और आविष्कारक देश शुद्ध आयातक बन जाता है)",
                "(1) मानकीकृत चरण → (2) परिपक्व चरण → (3) नवीन उत्पाद चरण",
                "(1) निरपेक्ष लाभ → (2) तुलनात्मक लाभ → (3) वणिकवादी अधिशेष",
                "(1) एथ्नोसेंट्रिक → (2) पॉलीसेंट्रिक → (3) रीजियोसेंट्रिक → (4) जियोसेंट्रिक"
            ),
            expEn = "Raymond Vernon's IPLC (1966) traces how an innovating high-income nation (e.g., USA) initially exports a new product, then moves production abroad as it matures, and eventually imports the standardized product from lower-cost developing nations.",
            expHi = "रेमंड वर्नन (1966) के IPLC सिद्धांत में उत्पाद तीन चरणों (नवीन उत्पाद, परिपक्व उत्पाद, मानकीकृत उत्पाद) से गुजरता है और अंत में आविष्कारक देश स्वयं उसका आयातक बन जाता है।",
            yearTag = "UGC NET Commerce 2021 PYQ",
            subTopic = "Unit I: Business Environment and International Business"
        )
    )

    // ==================== 8. MANAGEMENT (प्रबंधन — Code 017) ====================
    val managementSeeds: List<RawUgcNetPyqSeed> = listOf(
        RawUgcNetPyqSeed(
            qEn = "According to Frederick Herzberg's Two-Factor (Motivation-Hygiene) Theory, which of the following is classified as a true intrinsic 'Motivator' rather than a 'Hygiene/Maintenance' factor?",
            qHi = "फ्रेडरिक हर्ज़बर्ग के द्वि-कारक (अभिप्रेरणा-आरोग्य) सिद्धांत के अनुसार निम्नलिखित में से किसे 'आरोग्य कारक' (Hygiene Factor) के बजाय वास्तविक आंतरिक 'अभिप्रेरक' (Motivator) माना जाता है?",
            optsEn = listOf(
                "Achievement, Recognition, and Responsibility in the work itself",
                "Company policy and administration",
                "Working conditions and job security",
                "Base salary and interpersonal relations with supervisors"
            ),
            optsHi = listOf(
                "उपलब्धि (Achievement), मान्यता (Recognition) और कार्य में उत्तरदायित्व (Responsibility)",
                "कंपनी की नीति और प्रशासन",
                "कार्य की दशाएँ और नौकरी की सुरक्षा",
                "मूल वेतन और पर्यवेक्षकों के साथ पारस्परिक संबंध"
            ),
            expEn = "Herzberg's Hygiene factors (salary, working conditions, company policy, job security) only prevent job dissatisfaction when present, whereas true Motivators (achievement, recognition, growth, responsibility, work itself) create job satisfaction.",
            expHi = "हर्ज़बर्ग के अनुसार वेतन, कार्य दशाएँ और कंपनी नीति 'हाइजीन कारक' हैं जो केवल असंतोष रोकते हैं, जबकि उपलब्धि, मान्यता और उत्तरदायित्व वास्तविक 'अभिप्रेरक' (Motivators) हैं।",
            yearTag = "UGC NET Management June 2024 PYQ",
            subTopic = "Unit II: Organizational Behaviour & HRM"
        ),
        RawUgcNetPyqSeed(
            qEn = "In Strategic Management, inside the Boston Consulting Group (BCG) Growth-Share Matrix, business units with a High Relative Market Share in a Low-Growth Industry that generate surplus cash to fund other units are called:",
            qHi = "रणनीतिक प्रबंधन में बोस्टन कंसल्टिंग ग्रुप (BCG) मैट्रिक्स के अंतर्गत कम बाज़ार वृद्धि दर वाले उद्योग में उच्च सापेक्ष बाज़ार हिस्सेदारी वाली व्यावसायिक इकाइयाँ जो अतिरिक्त नकदी उत्पन्न करती हैं, क्या कहलाती हैं?",
            optsEn = listOf(
                "Cash Cows (High Market Share, Low Market Growth)",
                "Stars (High Market Share, High Market Growth)",
                "Question Marks / Problem Children (Low Market Share, High Market Growth)",
                "Dogs (Low Market Share, Low Market Growth)"
            ),
            optsHi = listOf(
                "कैश काउ / Cash Cows (उच्च बाज़ार हिस्सेदारी, निम्न बाज़ार वृद्धि दर)",
                "स्टार्स / Stars (उच्च बाज़ार हिस्सेदारी, उच्च बाज़ार वृद्धि दर)",
                "क्वेश्चन मार्क्स / Question Marks (निम्न बाज़ार हिस्सेदारी, उच्च बाज़ार वृद्धि दर)",
                "डॉग्स / Dogs (निम्न बाज़ार हिस्सेदारी, निम्न बाज़ार वृद्धि दर)"
            ),
            expEn = "In Bruce Henderson's BCG Matrix: Stars (High Share, High Growth), Cash Cows (High Share, Low Growth — milked for cash), Question Marks (Low Share, High Growth), and Dogs (Low Share, Low Growth).",
            expHi = "BCG मैट्रिक्स में चार चतुर्थांश होते हैं: स्टार्स (उच्च अंश, उच्च वृद्धि), कैश काउ (उच्च अंश, निम्न वृद्धि), क्वेश्चन मार्क्स (निम्न अंश, उच्च वृद्धि) और डॉग्स (निम्न अंश, निम्न वृद्धि)।",
            yearTag = "UGC NET Management Dec 2023 PYQ",
            subTopic = "Unit VI: Strategic Management (BCG, GE-McKinsey, Ansoff, Porter)"
        ),
        RawUgcNetPyqSeed(
            qEn = "Under the Capital Asset Pricing Model (CAPM) developed by Sharpe, Lintner, and Mossin, what is the expected return E(Ri) of a security with Risk-Free Rate Rf = 6%, Expected Market Return E(Rm) = 14%, and Beta (β) = 1.25?",
            qHi = "पूँजी परिसंपत्ति मूल्य निर्धारण मॉडल (CAPM) के अनुसार यदि जोखिम-मुक्त दर Rf = 6%, अपेक्षित बाज़ार प्रतिफल E(Rm) = 14% और बीटा (β) = 1.25 हो, तो प्रतिभूति का अपेक्षित प्रतिफल E(Ri) क्या होगा?",
            optsEn = listOf(
                "16.0% [E(Ri) = 6% + 1.25 × (14% - 6%) = 16%]",
                "17.5% [E(Ri) = 1.25 × 14%]",
                "14.0% [Equal to market return]",
                "10.0% [6% + 0.5 × 8%]"
            ),
            optsHi = listOf(
                "16.0% [E(Ri) = Rf + β(Rm - Rf) = 6% + 1.25 × (14% - 6%) = 16%]",
                "17.5% [1.25 × 14%]",
                "14.0% [बाज़ार प्रतिफल के बराबर]",
                "10.0% [6% + 0.5 × 8%]"
            ),
            expEn = "By the Security Market Line (SML) equation of CAPM: E(Ri) = Rf + β[E(Rm) - Rf] = 6% + 1.25 × (14% - 6%) = 6% + 1.25 × 8% = 6% + 10% = 16.0%.",
            expHi = "CAPM के सूत्र E(Ri) = Rf + β(Rm - Rf) के अनुसार: 6% + 1.25 × (14% - 6%) = 6% + 10% = 16.0%।",
            yearTag = "UGC NET Management June 2023 PYQ",
            subTopic = "Unit IV & V: Financial Management & Portfolio Management"
        ),
        RawUgcNetPyqSeed(
            qEn = "In Service Quality Management, Parasuraman, Zeithaml, and Berry's SERVQUAL model measures perceived service quality across which five core dimensions (RATER)?",
            qHi = "सेवा गुणवत्ता प्रबंधन में परशुरामन, ज़ीथामल और बेरी का 'SERVQUAL' मॉडल किन पाँच मुख्य आयामों (RATER) पर सेवा गुणवत्ता का मापन करता है?",
            optsEn = listOf(
                "Reliability, Assurance, Tangibles, Empathy, and Responsiveness",
                "Revenue, Advertising, Targeting, Positioning, and Retention",
                "Recency, Frequency, Monetary Value, Loyalty, and Advocacy",
                "Product, Price, Place, Promotion, and Packaging"
            ),
            optsHi = listOf(
                "विश्वसनीयता (Reliability), आश्वासन (Assurance), मूर्तता (Tangibles), समानुभूति (Empathy) और तत्परता (Responsiveness)",
                "राजस्व, विज्ञापन, लक्ष्यीकरण, पोजिशनिंग और प्रतिधारण",
                "नवीनता, आवृत्ति, मौद्रिक मूल्य, निष्ठा और समर्थन",
                "उत्पाद, मूल्य, स्थान, संवर्धन और पैकेजिंग"
            ),
            expEn = "The SERVQUAL instrument (1988) distilled service quality into five dimensions remembered by the acronym RATER: Reliability, Assurance, Tangibles, Empathy, and Responsiveness.",
            expHi = "SERVQUAL मॉडल (1988) में सेवा गुणवत्ता के पाँच आयाम (RATER) हैं: Reliability (विश्वसनीयता), Assurance (आश्वासन), Tangibles (मूर्त तत्व), Empathy (समानुभूति) और Responsiveness (तत्परता)।",
            yearTag = "UGC NET Management Dec 2022 PYQ",
            subTopic = "Unit VII & VIII: Consumer Behaviour & Services Marketing"
        ),
        RawUgcNetPyqSeed(
            qEn = "In Project Management (PERT — Program Evaluation and Review Technique), how is the Expected Activity Time (te) calculated from Optimistic (to), Most Likely (tm), and Pessimistic (tp) time estimates?",
            qHi = "परियोजना प्रबंधन (PERT) में आशावादी समय (to), सर्वाधिक संभावित समय (tm) और निराशावादी समय (tp) से अपेक्षित गतिविधि समय (te) की गणना किस सूत्र से की जाती है?",
            optsEn = listOf(
                "te = (to + 4·tm + tp) / 6 (with variance σ² = [(tp - to) / 6]²)",
                "te = (to + tm + tp) / 3",
                "te = (2·to + 2·tm + 2·tp) / 6",
                "te = (tp - to) / 6"
            ),
            optsHi = listOf(
                "te = (to + 4·tm + tp) / 6 (तथा प्रसरण σ² = [(tp - to) / 6]²)",
                "te = (to + tm + tp) / 3",
                "te = (2·to + 2·tm + 2·tp) / 6",
                "te = (tp - to) / 6"
            ),
            expEn = "PERT uses a Beta distribution where the weighted expected completion time is te = (to + 4tm + tp) / 6 and the standard deviation is σ = (tp - to) / 6.",
            expHi = "PERT में बीटा बंटन के आधार पर अपेक्षित समय te = (to + 4tm + tp)/6 तथा मानक विचलन σ = (tp - to)/6 होता है।",
            yearTag = "UGC NET Management 2021 PYQ",
            subTopic = "Unit VIII: Statistics & Operations Management (PERT/CPM)"
        )
    )

    // ==================== 9. SOCIOLOGY (समाजशास्त्र — Code 005) ====================
    val sociologySeeds: List<RawUgcNetPyqSeed> = listOf(
        RawUgcNetPyqSeed(
            qEn = "In Émile Durkheim's 'The Division of Labour in Society' (1893), the transition from 'Mechanical Solidarity' to 'Organic Solidarity' is accompanied by a shift in law from:",
            qHi = "एमिल दुर्खीम की कृति 'द डिवीजन ऑफ लेबर इन सोसाइटी' (1893) के अनुसार 'यांत्रिक एकता' (Mechanical Solidarity) से 'सावयवी एकता' (Organic Solidarity) में संक्रमण के साथ कानून के स्वरूप में क्या परिवर्तन होता है?",
            optsEn = listOf(
                "Repressive (Penal) Law to Restitutive (Cooperative) Law",
                "Restitutive Law to Repressive Law",
                "Charismatic Authority to Traditional Authority",
                "Class-in-itself to Class-for-itself"
            ),
            optsHi = listOf(
                "दमनकारी (दंडात्मक) कानून से क्षतिपूर्तिकारी (प्रत्यर्पणकारी) कानून की ओर",
                "क्षतिपूर्तिकारी कानून से दमनकारी कानून की ओर",
                "करिश्माई सत्ता से पारंपरिक सत्ता की ओर",
                "स्वयं-में-वर्ग से स्वयं-के-लिए-वर्ग की ओर"
            ),
            expEn = "Durkheim used legal codes as the visible index of social solidarity: pre-modern societies with Mechanical Solidarity (based on likeness and strong collective conscience) rely on Repressive Law, whereas modern differentiated societies with Organic Solidarity (based on functional interdependence) rely on Restitutive Law.",
            expHi = "दुर्खीम के अनुसार यांत्रिक एकता वाले समाजों में 'दमनकारी कानून' (Repressive Law) तथा श्रम-विभाजन पर आधारित सावयवी एकता वाले आधुनिक समाजों में 'क्षतिपूर्तिकारी कानून' (Restitutive Law) प्रमुख होता है।",
            yearTag = "UGC NET Sociology June 2024 PYQ",
            subTopic = "Unit I: Sociological Theory (Classical Traditions — Durkheim, Weber, Marx)"
        ),
        RawUgcNetPyqSeed(
            qEn = "M.N. Srinivas first introduced the concept of 'Sanskritization' in his study of which community, and which village did he study for his concept of 'Dominant Caste'?",
            qHi = "एम.एन. श्रीनिवास ने सर्वप्रथम किस समुदाय के अध्ययन में 'संस्कृतिकरण' (Sanskritization) की अवधारणा दी और 'प्रभु जाति' (Dominant Caste) के लिए किस गाँव का अध्ययन किया?",
            optsEn = listOf(
                "Coorgs of South India ('Religion and Society among the Coorgs', 1952) and Rampura village in Mysore ('The Remembered Village')",
                "Trobriand Islanders and Kishangarhi village (McKim Marriott)",
                "Toda tribe of Nilgiris and Shamirpet village (S.C. Dube)",
                "Bhils of Rajasthan and Sripuram village in Tanjore (André Béteille)"
            ),
            optsHi = listOf(
                "दक्षिण भारत के कुर्ग ('रिलीजन एंड सोसाइटी अमंग द कुर्ग्स', 1952) तथा मैसूर का रामपुरा गाँव ('द रिमेम्बर्ड विलेज')",
                "ट्रोब्रियांड द्वीपसमूह तथा किशनगढ़ी गाँव (मैककिम मैरियट)",
                "नीलगिरि की टोडा जनजाति तथा शमीरपेट गाँव (एस.सी. दुबे)",
                "राजस्थान के भील तथा तंजौर का श्रीपुरम गाँव (आंद्रे बेतेई)"
            ),
            expEn = "M.N. Srinivas coined 'Sanskritization' in 'Religion and Society among the Coorgs of South India' (1952) and developed the concept of 'Dominant Caste' from his intensive fieldwork in Rampura (Kodagahalli) village in Mysore.",
            expHi = "एम.एन. श्रीनिवास ने 1952 में दक्षिण भारत के कुर्गों के अध्ययन में 'संस्कृतिकरण' तथा मैसूर के रामपुरा गाँव के क्षेत्रीय कार्य के आधार पर 'प्रभु जाति' (Dominant Caste) की अवधारणा प्रस्तुत की।",
            yearTag = "UGC NET Sociology Dec 2023 PYQ",
            subTopic = "Unit I: Indian Sociological Conceptualizations (Srinivas, Ghurye, Dumont)"
        ),
        RawUgcNetPyqSeed(
            qEn = "In Robert K. Merton's Strain Theory of Deviance ('Social Structure and Anomie', 1938), which mode of individual adaptation accepts culturally prescribed goals (e.g., wealth) but rejects institutionalized legitimate means?",
            qHi = "रॉबर्ट के. मर्टन के विचलन के तनाव सिद्धांत ('सोशल स्ट्रक्चर एंड एनोमी', 1938) में अनुकूलन का कौन-सा प्रकार सांस्कृतिक लक्ष्यों को तो स्वीकार करता है किंतु संस्थागत वैध साधनों को अस्वीकार कर देता है?",
            optsEn = listOf(
                "Innovation (+ Goals, - Institutionalized Means)",
                "Ritualism (- Goals, + Institutionalized Means)",
                "Retreatism (- Goals, - Institutionalized Means)",
                "Rebellion (± Replacement of both Goals and Means)"
            ),
            optsHi = listOf(
                "नवाचार / Innovation (+ सांस्कृतिक लक्ष्य, - संस्थागत साधन)",
                "कर्मकांडवाद / Ritualism (- लक्ष्य, + साधन)",
                "पलायनवाद / Retreatism (- लक्ष्य, - साधन)",
                "विद्रोह / Rebellion (पुराने लक्ष्य व साधनों को हटाकर नए स्थापित करना)"
            ),
            expEn = "Merton identified five adaptations to structural strain: Conformity (+,+), Innovation (+,- e.g., white-collar or organized crime), Ritualism (-,+ e.g., bureaucratic rule-following without ambition), Retreatism (-,-), and Rebellion (±,±).",
            expHi = "मर्टन ने अनुकूलन के पाँच प्रकार बताए: अनुरूपता (+,+), नवाचार (+,- लक्ष्य स्वीकार किंतु अवैध साधन), कर्मकांडवाद (-,+), पलायनवाद (-,-) तथा विद्रोह (±,±)।",
            yearTag = "UGC NET Sociology June 2023 PYQ",
            subTopic = "Unit I: Structural-Functionalism (Parsons & Merton)"
        ),
        RawUgcNetPyqSeed(
            qEn = "Pierre Bourdieu in 'Distinction: A Social Critique of the Judgement of Taste' (1979) and 'The Forms of Capital' (1986) classified Cultural Capital into which three states?",
            qHi = "पियरे बूर्दिए (Pierre Bourdieu) ने 'द फॉर्म्स ऑफ कैपिटल' (1986) में सांस्कृतिक पूँजी (Cultural Capital) को किन तीन अवस्थाओं में वर्गीकृत किया है?",
            optsEn = listOf(
                "Embodied state (dispositions/habitus), Objectified state (cultural goods/books/art), and Institutionalized state (academic credentials/degrees)",
                "Economic, Political, and Military states",
                "Traditional, Charismatic, and Bureaucratic states",
                "Theological, Metaphysical, and Positivist states (Auguste Comte)"
            ),
            optsHi = listOf(
                "देहगत अवस्था (Embodied), वस्तुनिष्ठ अवस्था (Objectified — पुस्तकें/कलाकृतियाँ) और संस्थागत अवस्था (Institutionalized — शैक्षिक उपाधियाँ)",
                "आर्थिक, राजनीतिक और सैन्य अवस्थाएँ",
                "पारंपरिक, करिश्माई और नौकरशाही अवस्थाएँ",
                "धार्मिक, तात्विक और प्रत्यक्षवादी अवस्थाएँ (अगस्त कॉम्टे)"
            ),
            expEn = "Pierre Bourdieu analyzed how social reproduction occurs through Economic, Social, Symbolic, and Cultural Capital—with Cultural Capital existing in Embodied, Objectified, and Institutionalized states alongside Habitus and Field.",
            expHi = "पियरे बूर्दिए ने सांस्कृतिक पूँजी (Cultural Capital) के तीन रूप बताए हैं: देहगत (Embodied), वस्तुनिष्ठ (Objectified) और संस्थागत (Institutionalized)।",
            yearTag = "UGC NET Sociology Dec 2022 PYQ",
            subTopic = "Unit I: Post-Structuralism & Contemporary Sociological Theory"
        ),
        RawUgcNetPyqSeed(
            qEn = "Louis Dumont's classic structuralist work 'Homo Hierarchicus' (1966) argues that the Indian caste system is ideologically structured around the fundamental binary opposition between:",
            qHi = "लुई ड्यूमॉन्ट (Louis Dumont) की प्रसिद्ध संरचनावादी पुस्तक 'होमो हायरार्किकस' (1966) के अनुसार भारतीय जाति व्यवस्था वैचारिक रूप से किस मूलभूत द्विआधारी विरोध पर आधारित है?",
            optsEn = listOf(
                "The Pure and the Impure (Purity and Pollution, where ritual status encompasses secular politico-economic power)",
                "Bourgeoisie and Proletariat (pure economic class struggle)",
                "Little Tradition and Great Tradition (Robert Redfield)",
                "Universalization and Parochialization (McKim Marriott)"
            ),
            optsHi = listOf(
                "शुद्ध और अशुद्ध (पवित्रता और प्रदूषण — जहाँ अनुष्ठानिक प्रस्थिति लौकिक राजनीतिक-आर्थिक शक्ति से ऊपर होती है)",
                "बुर्जुआ और सर्वहारा (आर्थिक वर्ग संघर्ष)",
                "लघु परंपरा और वृहद परंपरा (रॉबर्ट रेडफील्ड)",
                "सार्वभौमीकरण और संकीर्णताकरण (मैककिम मैरियट)"
            ),
            expEn = "Louis Dumont in 'Homo Hierarchicus' applied Claude Lévi-Strauss's structuralism to argue that Indian society is holistic and hierarchical, organized around the ideological opposition of Pure vs. Impure.",
            expHi = "लुई ड्यूमॉन्ट ने 'होमो हायरार्किकस' (1966) में तर्क दिया कि भारतीय जाति व्यवस्था 'शुद्ध और अशुद्ध' (Pure and Impure) के वैचारिक द्विआधारी विरोध और पदानुक्रम पर आधारित है।",
            yearTag = "UGC NET Sociology 2021 PYQ",
            subTopic = "Unit I & III: Indian Society & Caste System"
        )
    )

    // ==================== 10. EDUCATION (शिक्षाशास्त्र — Code 009) ====================
    val educationSeeds: List<RawUgcNetPyqSeed> = listOf(
        RawUgcNetPyqSeed(
            qEn = "In Sankhya Philosophy (propounded by Maharshi Kapila), out of the 25 Tattvas, which category is 'Both Prakriti and Vikriti' (both Evolvent/Cause and Evolute/Effect)?",
            qHi = "सांख्य दर्शन (महर्षि कपिल द्वारा प्रतिपादित) के 25 तत्वों में से कौन-से तत्व 'प्रकृति-विकृति उभयरूप' (जो कारण भी हैं और कार्य भी) की श्रेणी में आते हैं?",
            optsEn = listOf(
                "7 Tattvas: Mahat (Buddhi), Ahankara (Ego), and the 5 Tanmatras (Subtle Elements: Shabda, Sparsha, Rupa, Rasa, Gandha)",
                "16 Tattvas: Manas, 5 Jnanendriyas, 5 Karmendriyas, and 5 Mahabhutas (Only Vikriti)",
                "Mula Prakriti alone (Only Prakriti / Uncaused Cause)",
                "Purusha (Neither Prakriti nor Vikriti — Pure Consciousness)"
            ),
            optsHi = listOf(
                "7 तत्व: महत (बुद्धि), अहंकार और 5 तन्मात्राएँ (शब्द, स्पर्श, रूप, रस, गंध)",
                "16 तत्व: मन, 5 ज्ञानेंद्रियाँ, 5 कर्मेंद्रियाँ और 5 महाभूत (केवल विकृति)",
                "मूल प्रकृति (केवल प्रकृति — अकारण कारण)",
                "पुरुष (न प्रकृति और न ही विकृति — शुद्ध चेतना)"
            ),
            expEn = "In Sankhya Karika (Ishvarakrishna): Mula Prakriti (1) is only Prakriti; Mahat, Ahankara, and 5 Tanmatras (7) are both Prakriti and Vikriti; Manas, 10 Indriyas, and 5 Mahabhutas (16) are only Vikriti; Purusha (1) is neither Prakriti nor Vikriti (Total = 25).",
            expHi = "सांख्य कारिका के अनुसार: मूल प्रकृति (1) केवल प्रकृति है; महत, अहंकार व 5 तन्मात्राएँ (7) प्रकृति-विकृति दोनों हैं; मन, 10 इंद्रियाँ व 5 महाभूत (16) केवल विकृति हैं; तथा पुरुष (1) न प्रकृति है न विकृति (कुल 25 तत्व)।",
            yearTag = "UGC NET Education June 2024 PYQ",
            subTopic = "Unit I: Educational Studies (Indian Schools of Philosophy: Sankhya, Yoga, Vedanta)"
        ),
        RawUgcNetPyqSeed(
            qEn = "In Daniel Stufflebeam's CIPP Model of Curriculum Evaluation, what do the four letters C-I-P-P stand for?",
            qHi = "डेनियल स्टफलबीम (Daniel Stufflebeam) के पाठ्यक्रम मूल्यांकन के 'CIPP' मॉडल में चारों अक्षरों C-I-P-P का पूर्ण रूप क्या है?",
            optsEn = listOf(
                "Context Evaluation, Input Evaluation, Process Evaluation, and Product Evaluation",
                "Curriculum, Instruction, Pedagogy, and Performance",
                "Cognitive, Interpersonal, Psychomotor, and Practical",
                "Continuous, Integrated, Participatory, and Predictive"
            ),
            optsHi = listOf(
                "संदर्भ मूल्यांकन (Context), आगत मूल्यांकन (Input), प्रक्रिया मूल्यांकन (Process) और उत्पाद मूल्यांकन (Product)",
                "पाठ्यक्रम, अनुदेशन, शिक्षाशास्त्र और निष्पादन",
                "संज्ञानात्मक, पारस्परिक, मनोगत्यात्मक और व्यावहारिक",
                "सतत, एकीकृत, सहभागी और भविष्यसूचक"
            ),
            expEn = "Daniel Stufflebeam's decision-oriented CIPP Evaluation Model evaluates a curriculum across four stages: Context (What needs to be done?), Input (How should it be done?), Process (Is it being done?), and Product (Did it succeed?).",
            expHi = "डेनियल स्टफलबीम के निर्णय-उन्मुख CIPP मॉडल के चार घटक हैं: Context (संदर्भ), Input (इनपुट/संसाधन), Process (प्रक्रिया) और Product (उत्पाद/परिणाम)।",
            yearTag = "UGC NET Education Dec 2023 PYQ",
            subTopic = "Unit V: Curriculum Studies (Tyler, Taba, Wheeler, Stufflebeam CIPP)"
        ),
        RawUgcNetPyqSeed(
            qEn = "According to Ned Flanders' Interaction Analysis Category System (FIACS, 10-category matrix), which categories represent 'Indirect Teacher Talk' (encouraging student freedom)?",
            qHi = "नेड फ्लैंडर्स की अंतःक्रिया विश्लेषण श्रेणी प्रणाली (FIACS — 10 श्रेणियों) में कौन-सी श्रेणियाँ 'अप्रत्यक्ष शिक्षक वार्ता' (Indirect Teacher Talk) को दर्शाती हैं?",
            optsEn = listOf(
                "Categories 1 to 4: (1) Accepts Feelings, (2) Praises or Encourages, (3) Accepts or Uses Ideas of Pupils, (4) Asks Questions",
                "Categories 5 to 7: (5) Lecturing, (6) Giving Directions, (7) Criticizing or Justifying Authority (Direct Teacher Talk)",
                "Categories 8 and 9: Pupil Talk — Response and Initiation",
                "Category 10: Silence or Confusion"
            ),
            optsHi = listOf(
                "श्रेणी 1 से 4: (1) भावनाओं की स्वीकृति, (2) प्रशंसा या प्रोत्साहन, (3) छात्रों के विचारों का उपयोग, (4) प्रश्न पूछना",
                "श्रेणी 5 से 7: (5) व्याख्यान देना, (6) निर्देश देना, (7) आलोचना या अधिकार जताना (प्रत्यक्ष शिक्षक वार्ता)",
                "श्रेणी 8 और 9: छात्र वार्ता — अनुक्रिया और पहल",
                "श्रेणी 10: मौन या भ्रम"
            ),
            expEn = "In Flanders' 10-category FIACS: Categories 1–4 are Teacher Indirect Influence, Categories 5–7 are Teacher Direct Influence, Categories 8–9 are Student Talk, and Category 10 is Silence/Confusion.",
            expHi = "फ्लैंडर्स के FIACS में श्रेणी 1–4 अप्रत्यक्ष शिक्षक प्रभाव, श्रेणी 5–7 प्रत्यक्ष शिक्षक प्रभाव, श्रेणी 8–9 छात्र वार्ता तथा श्रेणी 10 मौन या भ्रम को दर्शाती है।",
            yearTag = "UGC NET Education June 2023 PYQ",
            subTopic = "Unit VII: Pedagogy, Andragogy and Assessment (FIACS & Galloway)"
        ),
        RawUgcNetPyqSeed(
            qEn = "Under the Rights of Persons with Disabilities (RPwD) Act, 2016 (replacing the PwD Act, 1995), the number of recognized benchmark disabilities was expanded from 7 to how many categories, and what is the reservation in government higher educational institutions?",
            qHi = "दिव्यांगजन अधिकार अधिनियम (RPwD Act), 2016 के अंतर्गत मान्यता प्राप्त दिव्यांगताओं की संख्या 7 से बढ़ाकर कितनी कर दी गई है तथा सरकारी उच्च शिक्षण संस्थानों में आरक्षण कितना है?",
            optsEn = listOf(
                "21 recognized disabilities and at least 5% reservation in Higher Educational Institutions (4% in government jobs)",
                "14 recognized disabilities and 3% reservation",
                "10 recognized disabilities and 2% reservation",
                "28 recognized disabilities and 10% reservation"
            ),
            optsHi = listOf(
                "21 मान्यता प्राप्त दिव्यांगताएँ तथा उच्च शिक्षण संस्थानों में कम से कम 5% आरक्षण (सरकारी नौकरियों में 4%)",
                "14 दिव्यांगताएँ तथा 3% आरक्षण",
                "10 दिव्यांगताएँ तथा 2% आरक्षण",
                "28 दिव्यांगताएँ तथा 10% आरक्षण"
            ),
            expEn = "The RPwD Act, 2016 increased recognized disabilities from 7 to 21 (adding Acid Attack Victims, Thalassemia, Hemophilia, Sickle Cell Disease, Specific Learning Disabilities, Autism Spectrum Disorder, Parkinson's, etc.) and mandated 5% reservation in higher education and 4% in government jobs.",
            expHi = "RPwD अधिनियम, 2016 ने दिव्यांगताओं की श्रेणियाँ 7 से बढ़ाकर 21 कर दीं तथा उच्च शिक्षण संस्थानों में प्रवेश हेतु 5% और सरकारी नौकरियों में 4% आरक्षण अनिवार्य किया।",
            yearTag = "UGC NET Education Dec 2022 PYQ",
            subTopic = "Unit X: Inclusive Education (RPwD Act 2016, UNCRPD, UDL)"
        ),
        RawUgcNetPyqSeed(
            qEn = "In Kurt Lewin's Field Theory of Learning and Change Management, what are the three sequential stages of planned organizational/behavioural change?",
            qHi = "कर्ट लेविन (Kurt Lewin) के क्षेत्र सिद्धांत (Field Theory) और परिवर्तन प्रबंधन मॉडल में नियोजित व्यवहारगत/संगठनात्मक परिवर्तन के तीन क्रमिक चरण कौन-से हैं?",
            optsEn = listOf(
                "Unfreezing → Changing (Moving) → Refreezing",
                "Forming → Storming → Norming → Performing (Bruce Tuckman)",
                "Encoding → Storage → Retrieval",
                "Assimilation → Accommodation → Equilibration (Jean Piaget)"
            ),
            optsHi = listOf(
                "अनफ्रीजिंग (Unfreezing) → चेंजिंग / मूविंग (Changing) → रिफ्रीजिंग (Refreezing)",
                "फॉर्मिंग → स्टॉर्मिंग → नॉर्मिंग → परफॉर्मिंग (ब्रूस टकमैन)",
                "एनकोडिंग → स्टोरेज → रिट्रीवल",
                "आत्मसात्करण → समायोजन → संतुलन (जीन पियाजे)"
            ),
            expEn = "Kurt Lewin proposed both topological Field Theory (B = f(P, E), life space, vectors, valence) and the 3-step Change Model: Unfreezing existing equilibrium, Moving/Changing to a new level, and Refreezing to stabilize the new norm.",
            expHi = "कर्ट लेविन ने क्षेत्र सिद्धांत B = f(P, E) के साथ-साथ परिवर्तन का त्रि-चरणीय मॉडल प्रस्तुत किया: अनफ्रीजिंग (जड़ता तोड़ना), चेंजिंग (परिवर्तन लागू करना) और रिफ्रीजिंग (नए व्यवहार को स्थायी बनाना)।",
            yearTag = "UGC NET Education 2021 PYQ",
            subTopic = "Unit III & IX: Learner & Educational Management (Lewin, Piaget, Vygotsky)"
        )
    )

    // ==================== 11. COMPUTER SCIENCE & APPLICATIONS (कंप्यूटर विज्ञान — Code 087) ====================
    val computerSciSeeds: List<RawUgcNetPyqSeed> = listOf(
        RawUgcNetPyqSeed(
            qEn = "In Database Management Systems (DBMS), a relation R is in Boyce-Codd Normal Form (BCNF) if and only if for every non-trivial functional dependency X → Y:",
            qHi = "डेटाबेस प्रबंधन प्रणाली (DBMS) में कोई रिलेशन R बॉयस-कॉड नॉर्मल फॉर्म (BCNF) में तभी होता है जब प्रत्येक गैर-तुच्छ कार्यात्मक निर्भरता (Functional Dependency) X → Y के लिए:",
            optsEn = listOf(
                "X is a Superkey of relation R",
                "Y is a prime attribute (part of some candidate key) even if X is not a superkey (3NF)",
                "There is no partial dependency on a candidate key (2NF)",
                "All attributes are atomic and single-valued (1NF)"
            ),
            optsHi = listOf(
                "X रिलेशन R की एक सुपरकी (Superkey) हो",
                "Y एक प्राइम एट्रिब्यूट हो भले ही X सुपरकी न हो (यह 3NF की शर्त है)",
                "कैंडिडेट की पर कोई आंशिक निर्भरता न हो (2NF)",
                "सभी एट्रिब्यूट परमाणु (Atomic) हों (1NF)"
            ),
            expEn = "In 3NF, for every non-trivial X → Y, either X is a superkey OR Y is a prime attribute. BCNF is stricter: for every non-trivial X → Y, X MUST be a superkey. While 3NF is always dependency-preserving and lossless, BCNF guarantees lossless join but may not always preserve all dependencies.",
            expHi = "BCNF (3.5NF) में प्रत्येक गैर-तुच्छ कार्यात्मक निर्भरता X → Y के लिए बाईं ओर का निर्धारक (X) अनिवार्य रूप से सुपरकी (Superkey) होना चाहिए।",
            yearTag = "UGC NET Computer Science June 2024 PYQ",
            subTopic = "Unit IV: Database Management Systems (Normalization: 1NF, 2NF, 3NF, BCNF)"
        ),
        RawUgcNetPyqSeed(
            qEn = "In Operating Systems, under Edsger Dijkstra's Banker's Algorithm for Deadlock Avoidance with 5 processes and 3 resource types (A, B, C), what is the time complexity of the Safety Algorithm for n processes and m resource types?",
            qHi = "ऑपरेटिंग सिस्टम में डेडलॉक से बचाव (Deadlock Avoidance) हेतु डाइकस्ट्रा के बैंकर्स एल्गोरिदम में n प्रोसेस और m रिसोर्स प्रकारों के लिए 'सेफ्टी एल्गोरिदम' की समय जटिलता (Time Complexity) क्या होती है?",
            optsEn = listOf(
                "O(m · n²)",
                "O(n log n)",
                "O(2^n)",
                "O(m + n)"
            ),
            optsHi = listOf(
                "O(m · n²)",
                "O(n log n)",
                "O(2^n)",
                "O(m + n)"
            ),
            expEn = "In the Banker's Safety Algorithm, finding an unfinished process whose Need[i] <= Work (vector comparison of length m) can take up to n passes over n processes, resulting in O(m · n²) operations.",
            expHi = "बैंकर्स सेफ्टी एल्गोरिदम में प्रत्येक पास में n प्रोसेसों के लिए m लंबाई के Need <= Work वेक्टर की तुलना की जाती है, जिससे कुल समय जटिलता O(m · n²) होती है।",
            yearTag = "UGC NET Computer Science Dec 2023 PYQ",
            subTopic = "Unit V: System Software and Operating System (Deadlocks & Scheduling)"
        ),
        RawUgcNetPyqSeed(
            qEn = "In Theory of Computation (Chomsky Hierarchy), which of the following closure properties is FALSE for Context-Free Languages (CFLs)?",
            qHi = "कम्प्यूटेशन के सिद्धांत (चॉम्स्की पदानुक्रम) में संदर्भ-मुक्त भाषाओं (Context-Free Languages — CFLs) के संबंध में कौन-सा संवरक गुण (Closure Property) असत्य है?",
            optsEn = listOf(
                "CFLs are closed under Intersection and Complementation (FALSE — CFLs are NOT closed under Intersection or Complementation)",
                "CFLs are closed under Union, Concatenation, and Kleene Closure (Star)",
                "CFLs are closed under Intersection with a Regular Language",
                "Every Regular Language is also a Context-Free Language"
            ),
            optsHi = listOf(
                "CFL सर्वनिष्ठ (Intersection) और पूरक (Complementation) के अंतर्गत संवृत (Closed) होते हैं (असत्य — CFL इनमें संवृत नहीं हैं)",
                "CFL संघ (Union), संयोजन (Concatenation) और क्लीन क्लोजर (*) के अंतर्गत संवृत होते हैं",
                "CFL किसी रेगुलर भाषा के साथ सर्वनिष्ठ (Intersection with Regular Language) के अंतर्गत संवृत होते हैं",
                "प्रत्येक रेगुलर भाषा एक संदर्भ-मुक्त भाषा (CFL) भी होती है"
            ),
            expEn = "Context-Free Languages (recognized by Nondeterministic Pushdown Automata) are closed under Union, Concatenation, Kleene Star, Reversal, Homomorphism, and Intersection with Regular Languages, but are NOT closed under general Intersection, Complementation, or Set Difference.",
            expHi = "संदर्भ-मुक्त भाषाएँ (CFL) यूनियन, कॉनकैटेनेशन और क्लीन स्टार के अंतर्गत संवृत (Closed) होती हैं, किंतु इंटरसेक्शन (Intersection) और कॉम्प्लीमेंटेशन (Complementation) के अंतर्गत संवृत नहीं होतीं।",
            yearTag = "UGC NET Computer Science June 2023 PYQ",
            subTopic = "Unit VIII: Theory of Computation and Compilers (Automata & Chomsky Hierarchy)"
        ),
        RawUgcNetPyqSeed(
            qEn = "By the Master Theorem for divide-and-conquer recurrences, what is the asymptotic time complexity of T(n) = 2T(n/2) + n·log(n)?",
            qHi = "मास्टर प्रमेय (Extended Master Theorem) के अनुसार पुनरावृत्ति संबंध T(n) = 2T(n/2) + n·log(n) की अनंतस्पर्शी समय जटिलता (Time Complexity) क्या है?",
            optsEn = listOf(
                "Θ(n · log² n)",
                "Θ(n · log n)",
                "Θ(n²)",
                "Θ(n)"
            ),
            optsHi = listOf(
                "Θ(n · log² n)",
                "Θ(n · log n)",
                "Θ(n²)",
                "Θ(n)"
            ),
            expEn = "Here a = 2, b = 2, so n^(log_b a) = n^(log_2 2) = n^1. Since f(n) = n·log^k(n) with k = 1, by Case 2 of the Extended Master Theorem, T(n) = Θ(n^(log_b a) · log^(k+1) n) = Θ(n · log² n).",
            expHi = "यहाँ a = 2, b = 2 अतः n^(log_2 2) = n और f(n) = n·log¹(n) है। विस्तारित मास्टर प्रमेय के केस-2 के अनुसार T(n) = Θ(n · log^(1+1) n) = Θ(n · log² n) होगा।",
            yearTag = "UGC NET Computer Science Dec 2022 PYQ",
            subTopic = "Unit VII: Data Structures and Algorithms (Recurrence Relations & Complexity)"
        ),
        RawUgcNetPyqSeed(
            qEn = "In Computer Networks (IPv4 Subnetting), an organization is granted a Class C block 192.168.10.0/24 and needs to create 6 subnets. If it uses a /27 subnet mask (255.255.255.224), how many usable host IP addresses are available per subnet?",
            qHi = "कंप्यूटर नेटवर्क (IPv4 सबनेटिंग) में यदि किसी संस्था को /27 सबनेट मास्क (255.255.255.224) दिया जाता है, तो प्रत्येक सबनेट में कितने उपयोग योग्य (Usable) होस्ट IP पते उपलब्ध होंगे?",
            optsEn = listOf(
                "30 usable hosts per subnet (2^(32-27) - 2 = 32 - 2 = 30)",
                "62 usable hosts per subnet (2^6 - 2)",
                "14 usable hosts per subnet (2^4 - 2)",
                "32 usable hosts per subnet"
            ),
            optsHi = listOf(
                "प्रत्येक सबनेट में 30 उपयोग योग्य होस्ट (2^(32-27) - 2 = 32 - 2 = 30)",
                "62 उपयोग योग्य होस्ट (2^6 - 2)",
                "14 उपयोग योग्य होस्ट (2^4 - 2)",
                "32 उपयोग योग्य होस्ट"
            ),
            expEn = "With a /27 prefix, 32 - 27 = 5 host bits remain. Total addresses per subnet = 2^5 = 32. Subtracting 2 (1 network address + 1 directed broadcast address) leaves 30 usable host IP addresses per subnet.",
            expHi = "/27 सबनेट मास्क में होस्ट बिट्स की संख्या 32 - 27 = 5 होती है। अतः प्रति सबनेट उपयोग योग्य होस्ट = 2^5 - 2 = 32 - 2 = 30 (नेटवर्क और ब्रॉडकास्ट पते को घटाकर)।",
            yearTag = "UGC NET Computer Science 2021 PYQ",
            subTopic = "Unit IX: Data Communication and Computer Networks (IPv4/IPv6 & OSI)"
        )
    )

    // ==================== 12. LAW (विधि / कानून — Code 058) ====================
    val lawSeeds: List<RawUgcNetPyqSeed> = listOf(
        RawUgcNetPyqSeed(
            qEn = "In Jurisprudence, match the following Legal Positivist & Sociological Jurists with their foundational concepts: (A) Hans Kelsen, (B) H.L.A. Hart, (C) Roscoe Pound, (D) Friedrich Carl von Savigny.",
            qHi = "विधिशास्त्र (Jurisprudence) में निम्नलिखित विधिवेत्ताओं को उनकी मूलभूत अवधारणाओं से सुमेलित कीजिए: (A) हंस केल्सन, (B) एच.एल.ए. हार्ट, (C) रॉस्को पाउंड, (D) सेविग्नी।",
            optsEn = listOf(
                "Kelsen: Pure Theory of Law & Grundnorm; Hart: Union of Primary & Secondary Rules (Rule of Recognition); Pound: Social Engineering; Savigny: Volksgeist (Spirit of the People)",
                "Kelsen: Social Engineering; Hart: Volksgeist; Pound: Grundnorm; Savigny: Command of the Sovereign",
                "Kelsen: Living Law; Hart: Utilitarianism; Pound: Pure Theory; Savigny: Social Solidarity",
                "Kelsen: Natural Law; Hart: Historical School; Pound: Analytical Positivism; Savigny: Realist School"
            ),
            optsHi = listOf(
                "केल्सन: विधि का विशुद्ध सिद्धांत एवं मूल मानक (Grundnorm); हार्ट: प्राथमिक व द्वितीयक नियमों का संघ; पाउंड: सामाजिक अभियांत्रिकी (Social Engineering); सेविग्नी: लोकचेतना (Volksgeist)",
                "केल्सन: सामाजिक अभियांत्रिकी; हार्ट: लोकचेतना; पाउंड: मूल मानक; सेविग्नी: संप्रभु का समादेश",
                "केल्सन: जीवंत विधि; हार्ट: उपयोगितावाद; पाउंड: विशुद्ध सिद्धांत; सेविग्नी: सामाजिक संहति",
                "केल्सन: प्राकृतिक विधि; हार्ट: ऐतिहासिक संप्रदाय; पाउंड: विश्लेषणात्मक प्रत्यक्षवाद; सेविग्नी: यथार्थवादी संप्रदाय"
            ),
            expEn = "Hans Kelsen propounded the Pure Theory of Law and Grundnorm; H.L.A. Hart ('The Concept of Law') defined law as the union of Primary and Secondary rules; Roscoe Pound (Sociological School) gave Social Engineering; Savigny (Historical School) gave Volksgeist.",
            expHi = "हंस केल्सन ने मूल मानक (Grundnorm), एच.एल.ए. हार्ट ने प्राथमिक व द्वितीयक नियमों का सिद्धांत, रॉस्को पाउंड ने सामाजिक अभियांत्रिकी (Social Engineering) तथा सेविग्नी ने लोकचेतना (Volksgeist) का सिद्धांत दिया।",
            yearTag = "UGC NET Law June 2024 PYQ",
            subTopic = "Unit I: Jurisprudence (Analytical, Historical, Sociological & Realist Schools)"
        ),
        RawUgcNetPyqSeed(
            qEn = "Which landmark 9-Judge Bench judgment of the Supreme Court of India (2017) unanimously declared the 'Right to Privacy' as an intrinsic part of the Right to Life and Personal Liberty under Article 21 and overruled M.P. Sharma (1954) and Kharak Singh (1962)?",
            qHi = "भारत के सर्वोच्च न्यायालय की 9-न्यायाधीशों की संविधान पीठ के किस ऐतिहासिक निर्णय (2017) ने सर्वसम्मति से 'निजता के अधिकार' (Right to Privacy) को अनुच्छेद 21 के अंतर्गत मौलिक अधिकार घोषित किया?",
            optsEn = listOf(
                "Justice K.S. Puttaswamy (Retd.) v. Union of India (2017)",
                "Navtej Singh Johar v. Union of India (2018 — Section 377)",
                "Joseph Shine v. Union of India (2018 — Section 497 Adultery)",
                "Shreya Singhal v. Union of India (2015 — Section 66A IT Act)"
            ),
            optsHi = listOf(
                "जस्टिस के.एस. पुट्टास्वामी (सेवानिवृत्त) बनाम भारत संघ (2017)",
                "नवतेज सिंह जौहर बनाम भारत संघ (2018 — धारा 377)",
                "जोसेफ शाइन बनाम भारत संघ (2018 — व्यभिचार धारा 497)",
                "श्रेया सिंघल बनाम भारत संघ (2015 — आईटी अधिनियम की धारा 66A)"
            ),
            expEn = "In Justice K.S. Puttaswamy v. Union of India (2017) 10 SCC 1, a 9-Judge Bench held that privacy is a constitutionally protected fundamental right under Article 21 and Part III, overruling M.P. Sharma and Kharak Singh.",
            expHi = "जस्टिस के.एस. पुट्टास्वामी बनाम भारत संघ (2017) में 9-न्यायाधीशों की पीठ ने एम.पी. शर्मा (1954) और खड़क सिंह (1962) के निर्णयों को पलटते हुए निजता के अधिकार को अनुच्छेद 21 का अभिन्न अंग माना।",
            yearTag = "UGC NET Law Dec 2023 PYQ",
            subTopic = "Unit II: Constitutional and Administrative Law (Fundamental Rights)"
        ),
        RawUgcNetPyqSeed(
            qEn = "Under Article 38(1) of the Statute of the International Court of Justice (ICJ), which of the following are the four primary and subsidiary sources of Public International Law?",
            qHi = "अंतर्राष्ट्रीय न्यायालय (ICJ) की संविधि के अनुच्छेद 38(1) के अंतर्गत सार्वजनिक अंतर्राष्ट्रीय विधि (Public International Law) के चार स्रोत कौन-से हैं?",
            optsEn = listOf(
                "(a) International Conventions/Treaties, (b) International Custom (Opinio Juris + State Practice), (c) General Principles of Law recognized by civilized nations, (d) Judicial decisions and teachings of most highly qualified publicists",
                "(a) UN General Assembly Resolutions only, (b) US Supreme Court rulings, (c) Bilateral MoUs, (d) NGO Charters",
                "(a) Municipal Law, (b) Canon Law, (c) Roman Civil Law, (d) Maritime Insurance",
                "(a) WTO Dispute Panels, (b) IMF Quotas, (c) World Bank Guidelines, (d) NATO Treaties"
            ),
            optsHi = listOf(
                "(a) अंतर्राष्ट्रीय अभिसमय/संधियाँ, (b) अंतर्राष्ट्रीय प्रथा (Opinio Juris), (c) सभ्य राष्ट्रों द्वारा मान्यता प्राप्त विधि के सामान्य सिद्धांत, (d) न्यायिक निर्णय एवं श्रेष्ठ विधिवेत्ताओं की कृतियाँ",
                "(a) केवल संयुक्त राष्ट्र महासभा के प्रस्ताव, (b) अमेरिकी सर्वोच्च न्यायालय के निर्णय, (c) द्विपक्षीय समझौते, (d) एनजीओ चार्टर",
                "(a) राष्ट्रीय विधि, (b) चर्च विधि, (c) रोमन सिविल विधि, (d) समुद्री बीमा",
                "(a) WTO पैनल, (b) IMF कोटा, (c) विश्व बैंक दिशानिर्देश, (d) नाटो संधियाँ"
            ),
            expEn = "Article 38(1) of the ICJ Statute is universally recognized as the authoritative enumeration of the sources of International Law: (a) Treaties/Conventions, (b) Customary International Law, (c) General Principles of Law, and (d) Judicial decisions & juristic writings as subsidiary means.",
            expHi = "अंतर्राष्ट्रीय न्यायालय (ICJ) की संविधि का अनुच्छेद 38(1) अंतर्राष्ट्रीय विधि के चार प्रामाणिक स्रोतों को सूचीबद्ध करता है: संधियाँ, अंतर्राष्ट्रीय प्रथा, विधि के सामान्य सिद्धांत, तथा सहायक स्रोत के रूप में न्यायिक निर्णय एवं विधिवेत्ताओं के लेख।",
            yearTag = "UGC NET Law June 2023 PYQ",
            subTopic = "Unit III: Public International Law and IHL"
        ),
        RawUgcNetPyqSeed(
            qEn = "In the Law of Torts, the House of Lords in Rylands v. Fletcher (1868) laid down the rule of 'Strict Liability' (with 5 exceptions), whereas the Supreme Court of India in M.C. Mehta v. Union of India (Oleum Gas Leak Case, 1987) evolved which stricter doctrine without exceptions?",
            qHi = "अपकृत्य विधि (Law of Torts) में 'राइलैंड्स बनाम फ्लेचर' (1868) में 'कठोर दायित्व' (Strict Liability) का नियम प्रतिपादित हुआ, जबकि भारतीय सर्वोच्च न्यायालय ने 'एम.सी. मेहता बनाम भारत संघ' (ओलियम गैस रिसाव वाद, 1987) में बिना किसी अपवाद के कौन-सा सिद्धांत विकसित किया?",
            optsEn = listOf(
                "Doctrine of Absolute Liability (propounded by Chief Justice P.N. Bhagwati for hazardous/inherently dangerous industries)",
                "Doctrine of Contributory Negligence",
                "Doctrine of Volenti Non Fit Injuria",
                "Doctrine of Sovereign Immunity"
            ),
            optsHi = listOf(
                "पूर्ण दायित्व का सिद्धांत / Doctrine of Absolute Liability (मुख्य न्यायाधीश पी.एन. भगवती द्वारा खतरनाक उद्योगों हेतु प्रतिपादित — बिना किसी अपवाद के)",
                "अंशदायी उपेक्षा का सिद्धांत",
                "स्वेच्छा से उठाई गई क्षति (Volenti Non Fit Injuria)",
                "संप्रभु उन्मुक्ति का सिद्धांत"
            ),
            expEn = "In M.C. Mehta v. Union of India (AIR 1987 SC 1086, Oleum Gas Leak case), CJI P.N. Bhagwati held that an enterprise engaged in a hazardous or inherently dangerous activity owes an 'Absolute and Non-delegable Duty' and is subject to Absolute Liability without any of the Rylands v. Fletcher exceptions (like Act of God or third-party act).",
            expHi = "एम.सी. मेहता बनाम भारत संघ (ओलियम गैस रिसाव वाद, 1987) में मुख्य न्यायाधीश पी.एन. भगवती ने 'पूर्ण दायित्व का सिद्धांत' (Absolute Liability) प्रतिपादित किया, जिसमें राइलैंड्स बनाम फ्लेचर के पांचों अपवाद लागू नहीं होते।",
            yearTag = "UGC NET Law Dec 2022 PYQ",
            subTopic = "Unit V & VII: Law of Torts & Environmental Law"
        ),
        RawUgcNetPyqSeed(
            qEn = "In Criminal Law, the classic House of Lords judgment in McNaughten's Case (1843) is the foundational authority on which general defence (incorporated in Section 84 of IPC / Section 22 of BNS)?",
            qHi = "आपराधिक विधि (Law of Crimes) में 'मैकनॉटन वाद' (McNaughten's Case, 1843) का प्रसिद्ध निर्णय किस सामान्य अपवाद (IPC की धारा 84 / BNS की धारा 22) का आधारभूत सिद्धांत है?",
            optsEn = listOf(
                "Defence of Insanity / Unsoundness of Mind (Legal Insanity at the time of committing the act)",
                "Defence of Grave and Sudden Provocation",
                "Right of Private Defence of Body and Property",
                "Mistake of Fact in good faith (Ignorantia facti excusat)"
            ),
            optsHi = listOf(
                "चित्त-विकृति / पागलपन का बचाव (Insanity / Unsoundness of Mind — कृत्य करते समय विधिक पागलपन)",
                "गंभीर और अचानक प्रकोपन का बचाव",
                "शरीर और संपत्ति की प्राइवेट प्रतिरक्षा का अधिकार",
                "सद्भावपूर्वक तथ्य की भूल"
            ),
            expEn = "Daniel McNaughten's Case (1843) established the legal test of insanity (unsoundness of mind rendering the accused incapable of knowing the nature of the act or that it is wrong/contrary to law), codified under Section 84 of the Indian Penal Code (now Section 22 of the Bharatiya Nyaya Sanhita, 2023).",
            expHi = "डैनियल मैकनॉटन वाद (1843) ने 'विधिक पागलपन' (Legal Insanity) का सिद्धांत स्थापित किया, जिसे भारतीय दंड संहिता की धारा 84 (तथा भारतीय न्याय संहिता, 2023 की धारा 22) में समाहित किया गया है।",
            yearTag = "UGC NET Law 2021 PYQ",
            subTopic = "Unit IV: Law of Crimes (General Exceptions & Mens Rea)"
        )
    )
}
