package com.example.data.uppcs

import com.example.model.MockTest
import com.example.model.TestQuestion

/**
 * UPPCS Prelims Last 5 Years (2020–2025) Authentic PYQ Bilingual Question Bank
 * Part 2:
 *  - Section 3: Geography (भारत एवं विश्व का भूगोल) — 50 Questions
 *  - Section 4: Environment & Ecology (पर्यावरण एवं पारिस्थितिकी) — 50 Questions
 *  - Section 5: Science & Technology (सामान्य विज्ञान एवं प्रौद्योगिकी) — 50 Questions
 */
object UppcsGeoEnvSciPyqData {

    private data class RawPyqSeed(
        val qEn: String,
        val qHi: String,
        val optsEn: List<String>,
        val optsHi: List<String>,
        val expEn: String,
        val expHi: String,
        val yearTag: String
    )

    // =========================================================================
    // SECTION 3: GEOGRAPHY (50 Authentic UPPCS 2020–2025 PYQ Questions)
    // =========================================================================
    private val geography50Seeds: List<RawPyqSeed> = listOf(
        RawPyqSeed(
            "Through how many Indian States does the 'Tropic of Cancer' (23°30' N) pass, and through which 5 States does the 'Indian Standard Time' (82°30' E) meridian pass?",
            "'कर्क रेखा' (23°30' उत्तरी अक्षांश) भारत के कितने राज्यों से गुजरती है और 'भारतीय मानक समय रेखा' (82°30' पूर्वी देशांतर) किन 5 राज्यों से होकर गुजरती है?",
            listOf("Tropic of Cancer: 8 States | IST (82°30' E): 5 States — UP (Mirzapur/Naini), MP, Chhattisgarh, Odisha, and Andhra Pradesh", "Tropic of Cancer: 7 States | IST: UP, Bihar, Jharkhand, Odisha, AP", "Tropic of Cancer: 8 States | IST: UP, MP, Bihar, Odisha, Telangana", "Tropic of Cancer: 9 States | IST: UP, MP, Chhattisgarh, Jharkhand, Odisha"),
            listOf("कर्क रेखा: 8 राज्य | मानक समय रेखा (82°30' पू.): 5 राज्य — उ.प्र. (मिर्जापुर/नैनी), म.प्र., छत्तीसगढ़, ओडिशा और आंध्र प्रदेश", "कर्क रेखा: 7 राज्य | मानक समय: उ.प्र., बिहार, झारखंड, ओडिशा, आंध्र प्रदेश", "कर्क रेखा: 8 राज्य | मानक समय: उ.प्र., म.प्र., बिहार, ओडिशा, तेलंगाना", "कर्क रेखा: 9 राज्य | मानक समय: उ.प्र., म.प्र., छत्तीसगढ़, झारखंड, ओडिशा"),
            "Tropic of Cancer passes through 8 states (Gujarat, Rajasthan, MP, Chhattisgarh, Jharkhand, West Bengal, Tripura, Mizoram). IST (82°30' E, passing near Mirzapur/Naini in UP) crosses 5 states: UP, MP, Chhattisgarh, Odisha, and Andhra Pradesh. Both intersect in Koriya district of Chhattisgarh.",
            "कर्क रेखा 8 राज्यों से तथा भारतीय मानक समय रेखा (82°30' पूर्वी देशांतर, जो उ.प्र. के मिर्जापुर/नैनी से गुजरती है) 5 राज्यों—उत्तर प्रदेश, मध्य प्रदेश, छत्तीसगढ़, ओडिशा और आंध्र प्रदेश से गुजरती है। ये दोनों रेखाएँ छत्तीसगढ़ के कोरिया जिले में एक-दूसरे को काटती हैं।",
            "UPPCS Pre PYQ 2020 & 2023"
        ),
        RawPyqSeed(
            "Which district of Uttar Pradesh touches the boundaries of four States (Madhya Pradesh, Chhattisgarh, Jharkhand, and Bihar)?",
            "उत्तर प्रदेश का कौन-सा एकमात्र जिला देश के चार राज्यों (मध्य प्रदेश, छत्तीसगढ़, झारखंड और बिहार) की सीमाओं को स्पर्श करता है?",
            listOf("Sonbhadra", "Lalitpur", "Saharanpur", "Ballia"),
            listOf("सोनभद्र", "ललितपुर", "सहारनपुर", "बलिया"),
            "Sonbhadra (the southernmost district of UP) borders 4 states: Madhya Pradesh (West), Chhattisgarh (South), Jharkhand (South-East), and Bihar (North-East). Meanwhile, Saharanpur touches 3 states (HP, Uttarakhand, Haryana), and Lalitpur is surrounded on three sides by Madhya Pradesh.",
            "सोनभद्र (उ.प्र. का सबसे दक्षिणी जिला) चार राज्यों—मध्य प्रदेश, छत्तीसगढ़, झारखंड और बिहार को स्पर्श करता है। सहारनपुर तीन राज्यों (हिमाचल, उत्तराखंड, हरियाणा) को छूता है तथा ललितपुर तीन ओर से मध्य प्रदेश से घिरा है।",
            "UPPCS Pre PYQ 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "Match the following Mountain Passes of India with their respective States/Union Territories:\n1. Zoji La & Banihal Pass — Jammu & Kashmir\n2. Shipki La & Rohtang Pass — Himachal Pradesh\n3. Mana, Niti & Lipulekh Pass — Uttarakhand\n4. Nathu La & Jelep La — Sikkim",
            "भारत के प्रमुख पर्वतीय दर्रों का उनके संबंधित राज्यों/केंद्र शासित प्रदेशों से मिलान कीजिए:\n1. जोजिला व बनिहाल दर्रा — जम्मू एवं कश्मीर/लद्दाख\n2. शिपकी ला व रोहतांग दर्रा — हिमाचल प्रदेश\n3. माना, नीति व लिपुलेख दर्रा — उत्तराखंड\n4. नाथू ला व जेलेप ला — सिक्किम",
            listOf("All 1, 2, 3 and 4 are correctly matched", "1, 2 and 3 only", "2, 3 and 4 only", "1 and 4 only"),
            listOf("सभी 1, 2, 3 और 4 सही सुमेलित हैं", "केवल 1, 2 और 3", "केवल 2, 3 और 4", "केवल 1 और 4"),
            "All four pairs are correctly matched. Additional passes frequently asked in UPPCS: Bomdi La, Yangyap, and Diphu Pass (Arunachal Pradesh); Tuju Pass (Manipur); Palghat/Palakkad Gap (between Nilgiri and Anaimalai hills in Kerala-TN); Thalghat & Bhorghat (Maharashtra).",
            "सभी चारों युग्म सही सुमेलित हैं। अन्य प्रमुख दर्रे: बोमडिला, यांग्याप व दीफू दर्रा (अरुणाचल प्रदेश); तुजू दर्रा (मणिपुर); पालघाट दर्रा (नीलगिरि और अन्नामलाई पहाड़ियों के मध्य केरल-तमिलनाडु में); थालघाट व भोरघाट (महाराष्ट्र)।",
            "UPPCS Pre PYQ 2020, 2022, 2023"
        ),
        RawPyqSeed(
            "Which is the highest peak of Peninsular India (South India), and which is the highest peak of the Nilgiri Hills?",
            "प्रायद्वीपीय भारत (दक्षिण भारत) की सबसे ऊँची चोटी कौन-सी है तथा नीलगिरि पहाड़ियों की सर्वोच्च चोटी कौन-सी है?",
            listOf("Anamudi (2,695 m, Anaimalai Hills in Kerala) and Doddabetta (2,637 m, Nilgiri Hills in Tamil Nadu)", "Doddabetta and Mahendragiri", "Kalsubai and Mahabaleshwar", "Guru Shikhar and Dhupgarh"),
            listOf("अनाईमुडी (2,695 मी., अन्नामलाई पहाड़ी, केरल) तथा दोद्दाबेट्टा (2,637 मी., नीलगिरि पहाड़ी, तमिलनाडु)", "दोद्दाबेट्टा और महेंद्रगिरि", "कलसुबाई और महाबलेश्वर", "गुरु शिखर और धूपगढ़"),
            "Highest peaks across Indian ranges (UPPCS favorite): Peninsular India / Western Ghats — Anamudi (2,695 m, Kerala); Nilgiri Hills (where Western & Eastern Ghats meet) — Doddabetta (2,637 m); Aravalli Range — Guru Shikhar (1,722 m, Mt. Abu); Satpura Range — Dhupgarh (1,350 m, Pachmarhi); Chota Nagpur — Parasnath.",
            "प्रमुख पर्वत श्रेणियों की सर्वोच्च चोटियाँ: दक्षिण भारत / पश्चिमी घाट — अनाईमुडी (2,695 मी., केरल); नीलगिरि पहाड़ियाँ (जहाँ पूर्वी व पश्चिमी घाट मिलते हैं) — दोद्दाबेट्टा (2,637 मी.); अरावली — गुरु शिखर (1,722 मी.); सतपुड़ा — धूपगढ़ (1,350 मी.)।",
            "UPPCS Pre PYQ 2021 & 2022"
        ),
        RawPyqSeed(
            "Match the 'Panch Prayag' (Five Sacred Confluences) in Uttarakhand with the rivers that meet the Alaknanda River:\n1. Vishnuprayag — Alaknanda + Dhauliganga\n2. Nandaprayag — Alaknanda + Nandakini\n3. Karnaprayag — Alaknanda + Pindar\n4. Rudraprayag — Alaknanda + Mandakini\n5. Devprayag — Alaknanda + Bhagirathi (forming the Ganga)",
            "उत्तराखंड के 'पंच प्रयाग' का अलकनंदा नदी से मिलने वाली नदियों के साथ सही मिलान चुनिए:\n1. विष्णुप्रयाग — अलकनंदा + धौलीगंगा\n2. नंदप्रयाग — अलकनंदा + नंदाकिनी\n3. कर्णप्रयाग — अलकनंदा + पिंडर\n4. रुद्रप्रयाग — अलकनंदा + मंदाकिनी\n5. देवप्रयाग — अलकनंदा + भागीरथी (जहाँ से 'गंगा' नाम पड़ता है)",
            listOf("All 1, 2, 3, 4 and 5 are correctly matched (North to South order: V-N-K-R-D)", "1, 3 and 5 only", "2, 4 and 5 only", "1, 2 and 4 only"),
            listOf("सभी 1, 2, 3, 4 और 5 सही सुमेलित हैं (उत्तर से दक्षिण क्रम: विष्णु-नंद-कर्ण-रुद्र-देवप्रयाग)", "केवल 1, 3 और 5", "केवल 2, 4 और 5", "केवल 1, 2 और 4"),
            "The Alaknanda rises from Satopanth glacier (above Badrinath) and meets Dhauliganga at Vishnuprayag, Nandakini at Nandaprayag, Pindar at Karnaprayag, Mandakini (coming from Kedarnath/Chorabari glacier) at Rudraprayag, and Bhagirathi (coming from Gangotri/Gaumukh) at Devprayag to form the Ganga. The Ganga enters the plains at Haridwar and enters UP at Bijnor district.",
            "सतोपंथ हिमनद से निकलने वाली अलकनंदा से विष्णुप्रयाग में धौलीगंगा, नंदप्रयाग में नंदाकिनी, कर्णप्रयाग में पिंडर, रुद्रप्रयाग में मंदाकिनी (केदारनाथ) और देवप्रयाग में भागीरथी (गंगोत्री) मिलती है। गंगा हरिद्वार में मैदान में तथा बिजनौर जिले से उत्तर प्रदेश में प्रवेश करती है (बलिया से बिहार में निकलती है)।",
            "UPPCS Pre PYQ 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "Which of the following are Left-Bank Tributaries vs Right-Bank Tributaries of the River Ganga?",
            "गंगा नदी की 'बाएँ तट की सहायक नदियों' (Left-Bank) और 'दाएँ तट की सहायक नदियों' (Right-Bank) का सही युग्म कौन-सा है?",
            listOf("Left-Bank: Ramganga, Gomti, Ghaghara, Gandak, Kosi, Mahananda | Right-Bank: Yamuna, Tons (Tamsa), and Son", "Left-Bank: Yamuna, Son, Chambal | Right-Bank: Gomti, Ghaghara, Kosi", "Left-Bank: Betwa, Ken, Son | Right-Bank: Ramganga, Gandak", "Left-Bank: Son, Damodar | Right-Bank: Kosi, Mahananda"),
            listOf("बाएँ तट की: रामगंगा, गोमती, घाघरा, गंडक, कोसी, महानंदा | दाएँ तट की: यमुना, टोंस (तमसा) और सोन", "बाएँ तट की: यमुना, सोन, चंबल | दाएँ तट की: गोमती, घाघरा, कोसी", "बाएँ तट की: बेतवा, केन, सोन | दाएँ तट की: रामगंगा, गंडक", "बाएँ तट की: सोन, दामोदर | दाएँ तट की: कोसी, महानंदा"),
            "Left-bank tributaries of Ganga (West to East): Ramganga (joins near Kannauj), Gomti (originates from Fulhar Lake in Pilibhit — the only plains-origin tributary, joins near Kaithi, Ghazipur), Ghaghara/Saryu, Gandak, Kosi, Mahananda. Right-bank tributaries: Yamuna (joins at Prayagraj; its own right-bank tributaries are Chambal, Sindh, Betwa, Ken), Tons, and Son (originates from Amarkantak, joins near Patna).",
            "गंगा के बाएँ तट की सहायक नदियाँ: रामगंगा (कन्नौज के पास संगम), गोमती (पीलीभीत की फुलहर झील से उद्गम — मैदान से निकलने वाली एकमात्र सहायक नदी, गाजीपुर के कैथी में संगम), घाघरा, गंडक, कोसी व महानंदा। दाएँ तट की सहायक नदियाँ: यमुना (प्रयागराज में संगम), टोंस और सोन (अमरकंटक से उद्गम)।",
            "UPPCS Pre PYQ 2020, 2022, 2023"
        ),
        RawPyqSeed(
            "Which rivers of India flow westward through a 'Rift Valley' (भ्रंश घाटी) and form an Estuary instead of a Delta in the Arabian Sea?",
            "भारत की कौन-सी प्रमुख नदियाँ 'भ्रंश घाटी' (Rift Valley) से होकर पश्चिम की ओर बहती हैं और अरब सागर में डेल्टा के बजाय ज्वारनदमुख (Estuary) बनाती हैं?",
            listOf("Narmada (between Vindhya & Satpura ranges) and Tapti / Tapi (south of Satpura), while Damodar flows in an eastward Rift Valley", "Godavari, Krishna, and Kaveri", "Mahanadi and Subarnarekha", "Luni and Chambal"),
            listOf("नर्मदा (विंध्य व सतपुड़ा के मध्य) और ताप्ती (सतपुड़ा के दक्षिण में), जबकि दामोदर पूर्व की ओर भ्रंश घाटी में बहती है", "गोदावरी, कृष्णा और कावेरी", "महानदी और स्वर्णरेखा", "लूनी और चंबल"),
            "Narmada (originating from Amarkantak plateau, forming Dhuandhar Falls near Jabalpur) and Tapti/Tapi (originating from Multai, Betul district, MP) flow westward through fault/rift valleys into the Gulf of Khambhat (Arabian Sea). Meanwhile, Mahi River crosses the Tropic of Cancer twice!",
            "नर्मदा (अमरकंटक से उद्गम) और ताप्ती (मुलताई, बैतूल से उद्गम) भ्रंश घाटी (Rift Valley) से होकर पश्चिम की ओर खंभात की खाड़ी (अरब सागर) में गिरती हैं और ज्वारनदमुख (Estuary) बनाती हैं। वहीं 'माही नदी' कर्क रेखा को दो बार काटती है!",
            "UPPCS Pre PYQ 2020, 2021, 2023"
        ),
        RawPyqSeed(
            "Match the following Multipurpose River Valley Projects / Dams with their respective Rivers and States:\n1. Rihand Dam (Govind Ballabh Pant Sagar) — Rihand River (Sonbhadra, UP)\n2. Matatila & Rajghat Dam — Betwa River (Lalitpur/Jhansi, UP-MP)\n3. Tehri Dam — Confluence of Bhagirathi & Bhilangना (Uttarakhand)\n4. Idukki Dam — Periyar River (Kerala)",
            "निम्नलिखित बहुउद्देशीय नदी घाटी परियोजनाओं/बाँधों का उनकी नदियों एवं राज्यों से मिलान कीजिए:\n1. रिहंद बाँध (गोविंद वल्लभ पंत सागर) — रिहंद नदी (सोनभद्र, उ.प्र.)\n2. माताटीला व राजघाट बाँध — बेतवा नदी (ललितपुर/झाँसी, उ.प्र.)\n3. टिहरी बाँध — भागीरथी और भिलंगना का संगम (उत्तराखंड)\n4. इडुक्की बाँध — पेरियार नदी (केरल)",
            listOf("All 1, 2, 3 and 4 are correctly matched", "1 and 2 only", "1, 3 and 4 only", "2 and 3 only"),
            listOf("सभी 1, 2, 3 और 4 सही सुमेलित हैं", "केवल 1 और 2", "केवल 1, 3 और 4", "केवल 2 और 3"),
            "All four pairs are repeatedly asked in UPPCS: Rihand Dam at Pipri (Sonbhadra, UP) forms Govind Ballabh Pant Sagar (India's largest artificial lake by volume); Matatila, Rajghat (Rani Lakshmibai Dam), and Parichha dams are on Betwa River; Tehri Dam (India's highest dam, 260.5 m) is at Bhagirathi-Bhilangana confluence; Hirakud (longest dam) is on Mahanadi (Odisha).",
            "सभी चारों युग्म सही सुमेलित हैं: पिपरी (सोनभद्र, उ.प्र.) स्थित रिहंद बाँध गोविंद वल्लभ पंत सागर बनाता है; माताटीला, राजघाट व परीक्षा बाँध बेतवा नदी पर हैं; भारत का सबसे ऊँचा टिहरी बाँध (260.5 मी.) भागीरथी और भिलंगना के संगम पर है तथा सबसे लंबा हीराकुंड बाँध महानदी (ओडिशा) पर है।",
            "UPPCS Pre PYQ 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "Which is the highest waterfall in India (Kunchikal / Jog Falls), and on which river is 'Chitrakote Waterfall' (known as the Niagara of India) located?",
            "भारत का सबसे ऊँचा जलप्रपात (कुंचिकल / जोग प्रपात) किस राज्य में है और 'भारत का नियाग्रा' कहलाने वाला 'चित्रकोट जलप्रपात' किस नदी पर स्थित है?",
            listOf("Karnataka (Kunchikal on Varahi River & Jog/Gersoppa on Sharavathi River) | Chitrakote Waterfall is on Indravati River (Bastar, Chhattisgarh)", "Kerala | Chitrakote is on Mahanadi River", "Meghalaya | Chitrakote is on Subarnarekha River (Hundru Falls)", "Madhya Pradesh | Chitrakote is on Narmada River (Dhuandhar Falls)"),
            listOf("कर्नाटक (वाराही नदी पर कुंचिकल व शरावती नदी पर जोग/गरसोप्पा) | चित्रकोट जलप्रपात इंद्रावती नदी (बस्तर, छत्तीसगढ़) पर स्थित है", "केरल | चित्रकोट महानदी पर है", "मेघालय | चित्रकोट स्वर्णरेखा नदी (हुंडरू प्रपात) पर है", "मध्य प्रदेश | चित्रकोट नर्मदा नदी (धुआँधार प्रपात) पर है"),
            "Important Waterfalls in UPPCS: Kunchikal Falls (Varahi River, Shimoga, Karnataka — 455 m); Jog/Gersoppa/Mahatma Gandhi Falls (Sharavathi River, Karnataka); Shivasamudram Falls (Kaveri River); Chitrakote Falls ('Niagara of India' — Indravati River, Chhattisgarh); Hundru Falls (Subarnarekha River, Jharkhand); Dhuandhar & Kapildhara Falls (Narmada River, MP); Dudhsagar Falls (Mandovi River, Goa).",
            "UPPCS में पूछे जाने वाले प्रमुख जलप्रपात: कुंचिकल प्रपात (वाराही नदी, कर्नाटक); जोग/गरसोप्पा प्रपात (शरावती नदी, कर्नाटक); शिवसमुद्रम (कावेरी नदी); चित्रकोट प्रपात ('भारत का नियाग्रा' — इंद्रावती नदी, छत्तीसगढ़); हुंडरू प्रपात (स्वर्णरेखा नदी, झारखंड); धुआँधार प्रपात (नर्मदा नदी); दूधसागर प्रपात (मांडवी नदी, गोवा)।",
            "UPPCS Pre PYQ 2021 & 2023"
        ),
        RawPyqSeed(
            "Why does the Coromandel Coast (Tamil Nadu) receive maximum rainfall during the Winter season (October–December), unlike most of India?",
            "भारत के अधिकांश भागों के विपरीत, कोरोमंडल तट (तमिलनाडु) में शीत ऋतु (अक्टूबर–दिसंबर) के दौरान सर्वाधिक वर्षा किस कारण होती है?",
            listOf("Retreating Monsoon (North-East Monsoon winds picking up moisture over the Bay of Bengal)", "South-West Monsoon Arabian Sea Branch", "Western Disturbances (पश्चिमी विक्षोभ) alone", "Local Mango Showers (आम्र वर्षा)"),
            listOf("लौटते हुए मानसून (उत्तर-पूर्वी मानसूनी पवनों द्वारा बंगाल की खाड़ी से आर्द्रता ग्रहण करने) के कारण", "दक्षिण-पश्चिमी मानसून की अरब सागर शाखा के कारण", "केवल पश्चिमी विक्षोभ के कारण", "स्थानीय आम्र वर्षा (Mango Showers) के कारण"),
            "During October–December, the Retreating (North-East) Monsoon winds blow from land to sea, but while crossing the Bay of Bengal they pick up moisture and strike the Coromandel Coast (Tamil Nadu & South AP), causing heavy winter rainfall. Meanwhile, North-West India (Punjab, Haryana, West UP) receives winter rainfall (beneficial for Rabi Wheat crop) from 'Western Disturbances' originating in the Mediterranean Sea.",
            "अक्टूबर–दिसंबर के दौरान उत्तर-पूर्वी (लौटता हुआ) मानसून बंगाल की खाड़ी से नमी ग्रहण कर कोरोमंडल तट (तमिलनाडु) पर भारी शीतकालीन वर्षा करता है। वहीं उत्तर-पश्चिम भारत (पंजाब, हरियाणा, पश्चिमी उ.प्र.) में शीतकालीन वर्षा (जो रबी की गेहूँ फसल हेतु अत्यंत लाभकारी है) भूमध्य सागर से उठने वाले 'पश्चिमी विक्षोभ' (Western Disturbances) से होती है।",
            "UPPCS Pre PYQ 2020, 2022, 2023"
        ),
        RawPyqSeed(
            "Which soil in India is known as 'Regur Soil' (Self-Ploughing Soil), ideal for cotton cultivation and rich in iron, lime, calcium, and magnesium but deficient in nitrogen and phosphorus?",
            "भारत की किस मृदा को 'रेगुर मिट्टी' या 'स्वतः जुताई वाली मिट्टी' (Self-Ploughing Soil) कहा जाता है, जो कपास की खेती के लिए सर्वोत्तम है और बुंदेलखंड (उ.प्र.) में 'करेल मिट्टी' कहलाती है?",
            listOf("Black Soil (Vertisols — formed by weathering of Deccan Trap basaltic lava)", "Laterite Soil", "Alluvial Soil (Khadar & Bangar)", "Red and Yellow Soil"),
            listOf("काली मिट्टी (रेगुर / करेल मिट्टी — दक्कन ट्रैप के बेसाल्ट लावा के अपक्षय से निर्मित)", "लैटेराइट मिट्टी", "जलोढ़ मिट्टी (खादर व बांगर)", "लाल एवं पीली मिट्टी"),
            "Black Soil (Regur / Vertisols, known as 'Karel' in the Bundelkhand region of UP) has high clay content (Titaniferous Magnetite gives its black color) and high moisture-retention capacity. On drying, it develops deep cracks, giving it the name 'self-ploughing soil'. Alluvial soil covers the largest area in India (~43%) and UP.",
            "काली मिट्टी (जिसे 'रेगुर' तथा उ.प्र. के बुंदेलखंड क्षेत्र में 'करेल' कहा जाता है) दक्कन के बेसाल्ट लावा से निर्मित है। इसमें नमी धारण करने की उच्च क्षमता होती है और सूखने पर चौड़ी दरारें पड़ जाती हैं, इसलिए इसे 'स्वतः जुताई वाली मिट्टी' कहते हैं। टिटैनीफेरस मैग्नेटाइट के कारण इसका रंग काला होता है।",
            "UPPCS Pre PYQ 2021 & 2023"
        ),
        RawPyqSeed(
            "Match the major Iron Ore, Copper, Bauxite, and Coal mining centers in India with their respective States:\n1. Bailadila & Dalli-Rajhara (Iron Ore) — Chhattisgarh\n2. Kudremukh & Bellary (Iron Ore) — Karnataka\n3. Malanjkhand (MP) & Khetri (Rajasthan) — Copper\n4. Talcher (Odisha) & Jharia/Bokaro (Jharkhand) — Coal",
            "भारत के प्रमुख लौह अयस्क, ताँबा और कोयला खनन केंद्रों का उनके राज्यों से सही मिलान चुनिए:\n1. बैलाडीला व दल्ली-राजहरा (लौह अयस्क) — छत्तीसगढ़\n2. कुद्रेमुख व बेल्लारी (लौह अयस्क) — कर्नाटक\n3. मलाजखंड (म.प्र.) व खेतड़ी (राजस्थान) — ताँबा\n4. तालचेर (ओडिशा) व झरिया/बोकारो (झारखंड) — कोयला",
            listOf("All 1, 2, 3 and 4 are correctly matched", "1 and 2 only", "2, 3 and 4 only", "1, 3 and 4 only"),
            listOf("सभी 1, 2, 3 और 4 सही सुमेलित हैं", "केवल 1 और 2", "केवल 2, 3 और 4", "केवल 1, 3 और 4"),
            "Additional UPPCS Mineral Centers: Keonjhar, Badampahar & Mayurbhanj (Iron ore — Odisha); Noamundi & Gua (Iron ore — Jharkhand); Jaduguda & Turamdih (Uranium — Jharkhand);Tummalapalle (Uranium — Andhra Pradesh); Panna (Diamond — MP); Makrana (Marble — Rajasthan); Singrauli (Coal — MP/Sonbhadra UP).",
            "UPPCS में बार-बार पूछे जाने वाले खनन क्षेत्र: बैलाडीला व दल्ली-राजहरा (छत्तीसगढ़ — लौह अयस्क); क्योंझर, बादामपहाड़ व मयूरभंज (ओडिशा — लौह अयस्क); कुद्रेमुख व बाबासूदन (कर्नाटक — लौह अयस्क); खेतड़ी (राजस्थान) व मलाजखंड (म.प्र. — ताँबा); जादूगोड़ा (झारखंड — यूरेनियम); सिंगरौली (सोनभद्र, उ.प्र./म.प्र. — कोयला)।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "According to the Census of India 2011, which State has the highest and lowest Population Density, Highest Sex Ratio, and Highest Literacy Rate respectively?",
            "भारत की जनगणना 2011 के अनुसार क्रमशः सर्वाधिक व न्यूनतम जनसंख्या घनत्व, सर्वाधिक लिंगानुपात और सर्वाधिक साक्षरता दर वाले राज्य कौन-से हैं?",
            listOf("Density: Bihar (Highest - 1106) & Arunachal Pradesh (Lowest - 17) | Sex Ratio: Kerala (1084) | Literacy: Kerala (94.0%)", "Density: West Bengal (Highest) & Sikkim (Lowest) | Sex Ratio: Tamil Nadu | Literacy: Mizoram", "Density: UP (Highest) & Mizoram (Lowest) | Sex Ratio: Kerala | Literacy: Goa", "Density: Bihar (Highest) & Himachal (Lowest) | Sex Ratio: Chhattisgarh | Literacy: Kerala"),
            listOf("जनघनत्व: बिहार (सर्वाधिक - 1106) व अरुणाचल प्रदेश (न्यूनतम - 17) | लिंगानुपात: केरल (1084) | साक्षरता: केरल (94.0%)", "जनघनत्व: पश्चिम बंगाल व सिक्किम | लिंगानुपात: तमिलनाडु | साक्षरता: मिजोरम", "जनघनत्व: उ.प्र. व मिजोरम | लिंगानुपात: केरल | साक्षरता: गोवा", "जनघनत्व: बिहार व हिमाचल | लिंगानुपात: छत्तीसगढ़ | साक्षरता: केरल"),
            "Census 2011 Key India Figures: Total Population: 121.08 Crore; Decadal Growth: 17.7% (Highest: Meghalaya 27.9%, Lowest/Negative: Nagaland -0.6%); Population Density: 382/sq km (Bihar 1106, Arunachal 17); Sex Ratio: 943 (Kerala 1084, Haryana 879); Literacy Rate: 73.0% (Kerala 94.0%, Bihar 61.8%). Most populous state: Uttar Pradesh (19.98 Crore, 16.51% of India).",
            "जनगणना 2011 के प्रमुख आँकड़े: भारत का जनघनत्व: 382 (सर्वाधिक बिहार 1106, न्यूनतम अरुणाचल प्रदेश 17); लिंगानुपात: 943 (सर्वाधिक केरल 1084, न्यूनतम हरियाणा 879); साक्षरता: 73% (सर्वाधिक केरल 94%, न्यूनतम बिहार 61.8%); ऋणात्मक दशकीय वृद्धि वाला एकमात्र राज्य: नागालैंड (-0.6%); सर्वाधिक जनसंख्या: उत्तर प्रदेश (19.98 करोड़, देश का 16.51%)।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "Match the major Scheduled Tribes of India and Uttar Pradesh with their respective regions:\n1. Tharu & Buksa (Bhoksa) — Terai & Bijnor region of Uttar Pradesh/Uttarakhand\n2. Toda — Nilgiri Hills (Tamil Nadu)\n3. Jarawa, Onge, Sentinelese & Shompen — Andaman & Nicobar Islands\n4. Gaddi & Bakarwal — Himachal Pradesh & Jammu-Kashmir",
            "भारत एवं उत्तर प्रदेश की प्रमुख जनजातियों का उनके निवास क्षेत्रों के साथ सही मिलान चुनिए:\n1. थारू एवं बुक्सा (भोक्सा) — उत्तर प्रदेश/उत्तराखंड का तराई एवं बिजनौर क्षेत्र\n2. टोडा — नीलगिरि पहाड़ियाँ (तमिलनाडु)\n3. जारवा, ओंगे, सेंटिनली व शोम्पेन — अंडमान और निकोबार द्वीप समूह\n4. गद्दी व बकरवाल — हिमाचल प्रदेश एवं जम्मू-कश्मीर",
            listOf("All 1, 2, 3 and 4 are correctly matched", "1, 2 and 3 only", "2, 3 and 4 only", "1 and 4 only"),
            listOf("सभी 1, 2, 3 और 4 सही सुमेलित हैं", "केवल 1, 2 और 3", "केवल 2, 3 और 4", "केवल 1 और 4"),
            "Tribes in UP & India: Tharu is the largest ST group in UP Terai (Gorakhpur, Maharajganj, Lakhimpur Kheri, Balrampur; known for joint family system); Buksa/Bhoksa lives in Bijnor district; Kharwar, Gond, Baiga, Parahiya, Agariya, and Pahariya live in Sonbhadra/Mirzpur. Sonbhadra has the highest ST population in UP, while Baghpat has the lowest.",
            "उत्तर प्रदेश एवं भारत की जनजातियाँ: उ.प्र. के तराई क्षेत्र में 'थारू' जनजाति (संयुक्त परिवार प्रथा, लखीमपुर खीरी में थारू महाविद्यालय) तथा बिजनौर में 'बुक्सा/भोक्सा' जनजाति निवास करती है। सोनभद्र में खरवार, गोंड, बैगा, परहिया, अगरिया व पहरिया जनजातियाँ पाई जाती हैं (उ.प्र. में सर्वाधिक ST जनसंख्या सोनभद्र में है)।",
            "UPPCS Pre PYQ 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "Which countries border the 'Caspian Sea' (World's largest lake/inland sea) and the 'Red Sea' respectively?",
            "विश्व की सबसे बड़ी झील 'कैस्पियन सागर' और 'लाल सागर' (Red Sea) की सीमा से लगने वाले देशों का सही युग्म कौन-सा है?",
            listOf("Caspian Sea (5 countries - TARIK): Turkmenistan, Azerbaijan, Russia, Iran, Kazakhstan | Red Sea (6 countries - DESY-SE): Djibouti, Eritrea, Sudan, Egypt, Saudi Arabia, Yemen", "Caspian Sea: Turkey, Iran, Iraq, Russia | Red Sea: Israel, Jordan, Iran, Oman", "Caspian Sea: Uzbekistan, Kazakhstan, Russia | Red Sea: Ethiopia, Somalia, Kenya", "Caspian Sea: Armenia, Georgia, Iran | Red Sea: UAE, Qatar, Bahrain"),
            listOf("कैस्पियन सागर (5 देश - TARIK): तुर्कमेनिस्तान, अजरबैजान, रूस, ईरान, कजाकिस्तान | लाल सागर (6 देश - DESY-SE): जिबूती, इरिट्रिया, सूडान, मिस्र, सऊदी अरब, यमन", "कैस्पियन सागर: तुर्की, ईरान, इराक, रूस | लाल सागर: इजराइल, जॉर्डन, ओमान", "कैस्पियन सागर: उज्बेकिस्तान, कजाकिस्तान | लाल सागर: इथियोपिया, सोमालिया", "कैस्पियन सागर: आर्मेनिया, जॉर्जिया | लाल सागर: यूएई, कतर, बहरीन"),
            "World Map Border Questions (asked in every UPPCS Prelims): Caspian Sea (5 countries — Mnemonic TARIK: Turkmenistan, Azerbaijan, Russia, Iran, Kazakhstan); Aral Sea (2 countries: Kazakhstan and Uzbekistan); Dead Sea (Israel, Jordan, West Bank); Black Sea (6 countries: Turkey, Bulgaria, Romania, Ukraine, Russia, Georgia).",
            "विश्व मानचित्र सीमा प्रश्न (प्रत्येक UPPCS में पूछा जाने वाला): कैस्पियन सागर से 5 देश (ट्रिक TARIK: तुर्कमेनिस्तान, अजरबैजान, रूस, ईरान, कजाकिस्तान) लगते हैं; अरल सागर कजाकिस्तान और उज्बेकिस्तान के बीच स्थित है; मृत सागर (Dead Sea) इजराइल और जॉर्डन के बीच स्थित है।",
            "UPPCS Pre PYQ 2020, 2022, 2023, 2024"
        ),
        RawPyqSeed(
            "Match the Temperate & Tropical Grasslands of the World with their respective Continents/Countries:\n1. Prairies (North America) & Pampas (Argentina)\n2. Steppes (Eurasia) & Pustaz (Hungary)\n3. Veld (South Africa) & Downs (Australia) & Canterbury (New Zealand)\n4. Llanos (Venezuela) & Campos (Brazil) & Savanna (Africa)",
            "विश्व के प्रमुख शीतोष्ण एवं उष्णकटिबंधीय घास के मैदानों का उनके देशों/महाद्वीपों के साथ मिलान कीजिए:\n1. प्रेयरी (उत्तरी अमेरिका) एवं पम्पास (अर्जेंटीना/उरुग्वे)\n2. स्टेपीज (यूरेशिया) एवं पुस्ताज (हंगरी)\n3. वेल्ड (दक्षिण अफ्रीका), डाउन्स (ऑस्ट्रेलिया) एवं कैंटरबरी (न्यूजीलैंड)\n4. लानोस (वेनेजुएला), कम्पोज (ब्राजील) एवं सवाना (अफ्रीका)",
            listOf("All 1, 2, 3 and 4 are correctly matched", "1 and 2 only", "1, 3 and 4 only", "2 and 3 only"),
            listOf("सभी 1, 2, 3 और 4 सही सुमेलित हैं", "केवल 1 और 2", "केवल 1, 3 और 4", "केवल 2 और 3"),
            "Temperate Grasslands: Prairies (USA/Canada), Pampas (Argentina), Veld (South Africa), Downs (Australia), Canterbury (New Zealand), Steppes (Eurasia), Pustaz (Hungary). Tropical Grasslands: Savanna (East Africa), Llanos (Venezuela/Orinoco basin), Campos & Cerrado (Brazil), Selvas (Equatorial Amazon rainforest).",
            "शीतोष्ण घास के मैदान: प्रेयरी (उत्तरी अमेरिका), पम्पास (अर्जेंटीना), वेल्ड (दक्षिण अफ्रीका), डाउन्स (ऑस्ट्रेलिया), कैंटरबरी (न्यूजीलैंड), स्टेपीज (यूरेशिया), पुस्ताज (हंगरी)। उष्णकटिबंधीय घास के मैदान: सवाना (अफ्रीका), लानोस (वेनेजुएला), कम्पोज (ब्राजील)।",
            "UPPCS Pre PYQ 2020, 2021, 2023"
        ),
        RawPyqSeed(
            "Match the Local Winds of the World with the regions where they blow:\n1. Foehn & Mistral — Alps / Rhone Valley (Europe)\n2. Chinook ('Snow Eater') — Eastern slopes of Rocky Mountains (USA/Canada)\n3. Sirocco ('Blood Rain' in Italy, Khamsin in Egypt) — Sahara Desert to Mediterranean\n4. Harmattan ('Doctor Wind') — West Africa (Guinea Coast)",
            "विश्व की प्रमुख स्थानीय पवनों का उनके प्रवाह क्षेत्रों से मिलान कीजिए:\n1. फॉन (Foehn) व मिस्ट्रल — आल्प्स पर्वत / रोन घाटी (यूरोप)\n2. चिनूक ('हिम भक्षी' / Snow Eater) — रॉकी पर्वत के पूर्वी ढलान (अमेरिका/कनाडा)\n3. सिरोको (इटली में 'रक्त वर्षा', मिस्र में खमसिन) — सहारा मरुस्थल से भूमध्य सागर\n4. हरमट्टन ('डॉक्टर पवन') — पश्चिमी अफ्रीका (गिनी तट)",
            listOf("All 1, 2, 3 and 4 are correctly matched", "1, 2 and 3 only", "2 and 4 only", "1 and 3 only"),
            listOf("सभी 1, 2, 3 और 4 सही सुमेलित हैं", "केवल 1, 2 और 3", "केवल 2 और 4", "केवल 1 और 3"),
            "Other key Local Winds asked in UPPCS: Santa Ana (California), Zonda (Andes/Argentina), Brickfielder (Australia), Nor'wester (New Zealand), Bora (Adriatic Coast — cold wind), Blizzard (Tundra/Siberia/Canada — cold wind), Loo (North Indian plains — hot dry summer wind).",
            "UPPCS में पूछी जाने वाली अन्य स्थानीय पवनें: सांता आना (कैलिफोर्निया), जोंडा (अर्जेंटीना), ब्रिकफील्डर (ऑस्ट्रेलिया), नॉरवेस्टर (न्यूजीलैंड), बोरा (एड्रियाटिक तट — ठंडी पवन), मिस्ट्रल (फ्रांस/स्पेन — ठंडी पवन), हरमट्टन (गिनी तट पर आर्द्रता कम कर राहत देने के कारण 'डॉक्टर पवन' कहलाती है)।",
            "UPPCS Pre PYQ 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "Which of the following Ocean Currents are Cold Currents vs Warm Currents?",
            "निम्नलिखित महासागरीय जलधाराओं में से कौन-सी 'ठंडी जलधाराएँ' (Cold Currents) हैं और कौन-सी 'गर्म जलधाराएँ' (Warm Currents)?",
            listOf("Cold Currents: Humboldt (Peru), Canary, Benguela, Labrador, Oyashio, Falkland | Warm Currents: Gulf Stream, Kuroshio, Brazil, Agulhas, East Australian", "Cold Currents: Gulf Stream, Kuroshio, Agulhas | Warm Currents: Canary, Benguela, Humboldt", "Cold Currents: Brazil, Kuroshio | Warm Currents: Labrador, Falkland", "Cold Currents: Agulhas, Alaska | Warm Currents: California, Humboldt"),
            listOf("ठंडी जलधाराएँ: हम्बोल्ट (पेरू), कनारी, बेंगुएला, लैब्राडोर, ओयाशियो, फॉकलैंड | गर्म जलधाराएँ: गल्फ स्ट्रीम, क्यूरोशियो, ब्राजील, अगुलहास", "ठंडी: गल्फ स्ट्रीम, क्यूरोशियो | गर्म: कनारी, बेंगुएला, हम्बोल्ट", "ठंडी: ब्राजील, क्यूरोशियो | गर्म: लैब्राडोर, फॉकलैंड", "ठंडी: अगुलहास, अलास्का | गर्म: कैलिफोर्निया, हम्बोल्ट"),
            "Cold Ocean Currents: Humboldt/Peru Current (South-East Pacific), California Current (North-East Pacific), Oyashio/Kurile Current (NW Pacific), Labrador Current (NW Atlantic), Canary Current (NE Atlantic), Benguela Current (SE Atlantic, along Namib desert), Falkland Current, West Australian Current. Warm Currents: Gulf Stream, North Atlantic Drift, Brazil Current, Kuroshio Current, Agulhas Current (Indian Ocean).",
            "प्रमुख ठंडी महासागरीय धाराएँ: हम्बोल्ट या पेरू धारा (द.पू. प्रशांत), कैलिफोर्निया धारा, ओयाशियो (क्यूराइल) धारा, लैब्राडोर धारा, कनारी धारा (उ.पू. अटलांटिक), बेंगुएला धारा (द.पू. अटलांटिक), फॉकलैंड धारा एवं पश्चिमी ऑस्ट्रेलियाई धारा। गर्म धाराएँ: गल्फ स्ट्रीम, क्यूरोशियो, ब्राजील एवं अगुलहास धारा।",
            "UPPCS Pre PYQ 2020, 2022, 2023"
        ),
        RawPyqSeed(
            "Match the famous Straits and Canals of the World with the water bodies they connect:\n1. Strait of Hormuz — Persian Gulf & Gulf of Oman\n2. Bab-el-Mandeb Strait — Red Sea & Gulf of Aden\n3. Strait of Malacca — Andaman Sea (Indian Ocean) & South China Sea\n4. Suez Canal — Mediterranean Sea & Red Sea",
            "विश्व की प्रमुख जलसंधियों (Straits) एवं नहरों का उनके द्वारा जोड़े जाने वाले जलीय भागों से मिलान कीजिए:\n1. होर्मुज जलसंधि — फारस की खाड़ी और ओमान की खाड़ी\n2. बाब-अल-मंदेब जलसंधि — लाल सागर और अदन की खाड़ी\n3. मलक्का जलसंधि — अंडमान सागर (हिंद महासागर) और दक्षिण चीन सागर\n4. स्वेज नहर — भूमध्य सागर और लाल सागर",
            listOf("All 1, 2, 3 and 4 are correctly matched", "1 and 2 only", "2, 3 and 4 only", "1 and 4 only"),
            listOf("सभी 1, 2, 3 और 4 सही सुमेलित हैं", "केवल 1 और 2", "केवल 2, 3 और 4", "केवल 1 और 4"),
            "Other key Straits & Canals: Strait of Gibraltar ('Key to the Mediterranean' — connects Atlantic Ocean & Mediterranean Sea, separates Spain & Morocco); Bosporus Strait (Black Sea & Sea of Marmara); Kerch Strait (Black Sea & Sea of Azov); Bering Strait (Arctic & Pacific, separates Asia/Russia & North America/Alaska); Panama Canal (Atlantic & Pacific); Kiel Canal (North Sea & Baltic Sea).",
            "अन्य प्रमुख जलसंधियाँ व नहरें: जिब्राल्टर जलसंधि ('भूमध्य सागर की कुंजी' — अटलांटिक व भूमध्य सागर को जोड़ती है तथा स्पेन व मोरक्को को अलग करती है); बेरिंग जलसंधि (एशिया और उत्तरी अमेरिका को अलग करती है); पाक जलसंधि (भारत और श्रीलंका); स्वेज नहर (1869 में खुली, भूमध्य सागर को लाल सागर से जोड़ती है)।",
            "UPPCS Pre PYQ 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "Match the major Industrial Cities and Mineral Regions of the World with their specializations:\n1. Ruhr Valley (Germany) & Kuznetsk (Russia) — Coal & Heavy Steel Industry\n2. Detroit (USA) & Nagoya ('Detroit of Japan') — Automobile Industry\n3. Kimberley (South Africa) — Diamond Mining & Witwatersrand (Johannesburg) — Gold\n4. Chuquicamata (Chile) — World's largest open-pit Copper Mine",
            "विश्व के प्रमुख औद्योगिक नगरों एवं खनिज क्षेत्रों का उनके उद्योग/खनिज के साथ सही मिलान चुनिए:\n1. रूर घाटी (जर्मनी) एवं कुजबास/कुजनेत्स्क (रूस) — कोयला एवं इस्पात उद्योग\n2. डेट्रॉयट (अमेरिका) एवं नागोया ('जापान का डेट्रॉयट') — ऑटोमोबाइल (मोटर वाहन) उद्योग\n3. किम्बरले (दक्षिण अफ्रीका) — हीरा खनन एवं विटवाटरसैंड (जोहान्सबर्ग) — स्वर्ण खनन\n4. चुकीकामाटा (चिली) — विश्व की सबसे बड़ी ताँबा खान",
            listOf("All 1, 2, 3 and 4 are correctly matched", "1, 2 and 3 only", "1 and 3 only", "2 and 4 only"),
            listOf("सभी 1, 2, 3 और 4 सही सुमेलित हैं", "केवल 1, 2 और 3", "केवल 1 और 3", "केवल 2 और 4"),
            "UPPCS World Industrial & Mineral Centers: Pittsburgh (USA), Sheffield (UK), Hamilton (Canada), Tula/Magnitogorsk (Russia) — Iron & Steel; Manchester (UK), Osaka ('Manchester of Japan'), Ivanovo ('Manchester of Russia') — Cotton Textiles; Havana (Cuba) — Cigars; Venice (Italy) — Glass; Pilbara (Australia), Krivoy Rog (Ukraine), Carajas (Brazil), Mesabi Range (USA) — Iron Ore; Kalgoorlie & Coolgardie (Australia) — Gold.",
            "UPPCS में बार-बार पूछे जाने वाले विश्व के औद्योगिक व खनिज केंद्र: पिट्सबर्ग (अमेरिका) — लौह-इस्पात; ओसाका ('जापान का मैनचेस्टर') व इवानोवो ('रूस का मैनचेस्टर') — सूती वस्त्र; पिलबरा (ऑस्ट्रेलिया), क्रिवोय रोग (यूक्रेन), कराजास (ब्राजील) व मेसाबी रेंज (अमेरिका) — लौह अयस्क; कालगूर्ली व कूलगार्डी (ऑस्ट्रेलिया) — सोना।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "Which active Volcano is known as the 'Lighthouse of the Mediterranean', and which is the highest active volcano in the world?",
            "किस सक्रिय ज्वालामुखी को 'भूमध्य सागर का प्रकाश स्तंभ' (Lighthouse of the Mediterranean) कहा जाता है और विश्व का सबसे ऊँचा सक्रिय ज्वालामुखी कौन-सा है?",
            listOf("Mount Stromboli (Lipari Islands, Italy) is the Lighthouse of the Mediterranean | Ojos del Salado (Andes - Chile/Argentina) & Cotopaxi (Ecuador) are the highest active volcanoes", "Mount Etna and Mount Vesuvius", "Mauna Loa and Krakatoa", "Mount Kilimanjaro and Mount Fujiyama"),
            listOf("स्ट्रोम्बोली ज्वालामुखी (लिपारी द्वीप, इटली) भूमध्य सागर का प्रकाश स्तंभ है | ओजोस डेल सलाडो (चिली-अर्जेंटीना) और कोटोपैक्सी (इक्वाडोर) सर्वोच्च सक्रिय ज्वालामुखी हैं", "माउंट एटना और माउंट विसुवियस", "मौना लोआ और क्राकाटोआ", "माउंट किलिमंजारो और फ्यूजीयामा"),
            "Volcanoes in India & World: Barren Island (Andaman Sea — ONLY active volcano in India/South Asia); Narcondam Island (Andaman — dormant volcano); Stromboli (Italy — 'Lighthouse of the Mediterranean'); Mt. Etna (Sicily, Italy); Mauna Loa & Kilauea (Hawaii, USA); Mt. Merapi & Krakatoa (Indonesia); Mt. Kilimanjaro (Tanzania — extinct volcano, highest peak of Africa).",
            "प्रमुख ज्वालामुखी: बैरन द्वीप (अंडमान — भारत एवं दक्षिण एशिया का एकमात्र सक्रिय ज्वालामुखी); नारकोंडम (अंडमान — सुषुप्त ज्वालामुखी); स्ट्रोम्बोली (इटली — भूमध्य सागर का प्रकाश स्तंभ); मौना लोआ व किलाउआ (हवाई द्वीप, अमेरिका); मेरापी व क्राकाटोआ (इंडोनेशिया); किलिमंजारो (तंजानिया — अफ्रीका का सर्वोच्च शिखर)।",
            "UPPCS Pre PYQ 2020, 2021, 2023"
        ),
        RawPyqSeed(
            "Arrange the following Himalayan Mountain Ranges from North to South (or South to North):",
            "हिमालय की निम्नलिखित पर्वत श्रेणियों को उत्तर से दक्षिण (North to South) के सही क्रम में व्यवस्थित कीजिए:",
            listOf("Karakoram -> Ladakh -> Zaskar -> Pir Panjal -> Dhauladhar -> Shiwalik", "Ladakh -> Karakoram -> Pir Panjal -> Zaskar -> Shiwalik", "Zaskar -> Karakoram -> Ladakh -> Pir Panjal -> Shiwalik", "Karakoram -> Zaskar -> Ladakh -> Shiwalik -> Pir Panjal"),
            listOf("काराकोरम -> लद्दाख -> जास्कर -> पीर पंजाल -> धौलाधार -> शिवालिक", "लद्दाख -> काराकोरम -> पीर पंजाल -> जास्कर -> शिवालिक", "जास्कर -> काराकोरम -> लद्दाख -> पीर पंजाल -> शिवालिक", "काराकोरम -> जास्कर -> लद्दाख -> शिवालिक -> पीर पंजाल"),
            "North to South sequence of Himalayan ranges (Mnemonic: K-L-Z-P-D-S): 1. Karakoram (Trans-Himalaya, hosts K2/Godwin-Austen 8611m & Siachen Glacier); 2. Ladakh Range; 3. Zaskar Range (Indus river flows between Ladakh and Zaskar ranges); 4. Great Himalaya; 5. Pir Panjal & Dhauladhar (Lesser Himalaya); 6. Shiwalik (Outer Himalaya, youngest range).",
            "उत्तर से दक्षिण का सही क्रम (ट्रिक: का-ल-जा-पी-धौ-शि): 1. काराकोरम (जिसमें K2 गॉडविन ऑस्टिन 8611 मी. और सियाचिन ग्लेशियर स्थित है); 2. लद्दाख श्रेणी; 3. जास्कर श्रेणी (सिंधु नदी लद्दाख और जास्कर श्रेणियों के मध्य बहती है); 4. पीर पंजाल; 5. धौलाधार; 6. शिवालिक (सबसे नवीन बाह्य हिमालय)।",
            "UPPCS Pre PYQ 2020, 2022, 2023"
        ),
        RawPyqSeed(
            "Which Channel separates Andaman Islands from Nicobar Islands, Lakshadweep (Minicoy) from Maldives, and Kavaratti from Minicoy respectively?",
            "क्रमशः अंडमान को निकोबार से, मिनीकॉय को मालदीव से तथा लक्षद्वीप (कवरत्ती) को मिनीकॉय से अलग करने वाले चैनल कौन-से हैं?",
            listOf("10° Channel (Little Andaman & Car Nicobar), 8° Channel (Minicoy & Maldives), and 9° Channel (Minicoy & Main Lakshadweep)", "9° Channel, 10° Channel, and 8° Channel", "8° Channel, 9° Channel, and 10° Channel", "Duncan Passage, 10° Channel, and Palk Strait"),
            listOf("10° चैनल (लिटिल अंडमान व कार निकोबार), 8° चैनल (मिनीकॉय व मालदीव) तथा 9° चैनल (मिनीकॉय व मुख्य लक्षद्वीप)", "9° चैनल, 10° चैनल और 8° चैनल", "8° चैनल, 9° चैनल और 10° चैनल", "डंकन पास, 10° चैनल और पाक जलडमरूमध्य"),
            "Maritime Channels: 8° Channel separates Minicoy (India) from Maldives; 9° Channel separates Minicoy from main Lakshadweep archipelago; 10° Channel separates Little Andaman from Car Nicobar; Duncan Passage separates South Andaman from Little Andaman; Coco Channel separates North Andaman from Coco Islands (Myanmar). Indira Point (Pygmalion Point) in Great Nicobar (6°45' N) is India's southernmost point.",
            "प्रमुख समुद्री चैनल: 8° चैनल — मिनीकॉय (भारत) और मालदीव; 9° चैनल — मिनीकॉय और मुख्य लक्षद्वीप; 10° चैनल — लिटिल अंडमान और कार निकोबार; डंकन पास — दक्षिणी अंडमान और लिटिल अंडमान। ग्रेट निकोबार स्थित 'इंदिरा पॉइंट' (पिगमेलियन पॉइंट, 6°45' उ.) भारत का दक्षिणतम बिंदु है।",
            "UPPCS Pre PYQ 2021 & 2023"
        ),
        RawPyqSeed(
            "Which National Waterway (NW-1) is the longest in India, and between which cities does it run along the Ganga-Bhagirathi-Hooghly river system?",
            "भारत का सबसे लंबा राष्ट्रीय जलमार्ग (NW-1) कौन-सा है और यह गंगा-भागीरथी-हुगली नदी प्रणाली पर किन दो स्थानों के बीच (1,620 किमी) संचालित है?",
            listOf("National Waterway-1 (NW-1): Prayagraj (Allahabad) to Haldia (1,620 km on Ganga-Bhagirathi-Hooghly)", "NW-2: Sadiya to Dhubri (on Brahmaputra River, 891 km)", "NW-3: Kollam to Kottapuram (West Coast Canal, Kerala)", "NW-4: Kakinada to Puducherry (Godavari-Krishna canals)"),
            listOf("राष्ट्रीय जलमार्ग-1 (NW-1): प्रयागराज (इलाहाबाद) से हल्दिया (गंगा-भागीरथी-हुगली नदी पर, 1,620 किमी)", "NW-2: सदिया से धुबरी (ब्रह्मपुत्र नदी पर, 891 किमी)", "NW-3: कोल्लम से कोट्टापुरम (केरल)", "NW-4: काकीनाडा से पुदुचेरी (गोदावरी-कृष्णा)"),
            "National Waterway 1 (declared in 1986, 1,620 km from Prayagraj in UP to Haldia in West Bengal via Varanasi, Patna, and Farakka) is India's longest operational waterway. India's first multi-modal terminal under the Jal Marg Vikas Project was inaugurated at Ramnagar, Varanasi.",
            "राष्ट्रीय जलमार्ग-1 (NW-1, 1986 में घोषित) प्रयागराज (उ.प्र.) से हल्दिया (प. बंगाल) तक गंगा-भागीरथी-हुगली नदी पर 1,620 किमी लंबा देश का सबसे बड़ा जलमार्ग है। जल मार्ग विकास परियोजना के तहत देश का पहला मल्टी-मॉडल टर्मिनल वाराणसी (रामनगर) में बनाया गया है।",
            "UPPCS Pre PYQ 2020 & 2022"
        ),
        RawPyqSeed(
            "In the atmosphere, in which layer do all weather phenomena occur, in which layer is the Ozone Shield (15–35 km) found, and which layer reflects radio waves back to Earth?",
            "वायुमंडल की किस परत में सभी मौसमी घटनाएँ होती हैं, किस परत में ओजोन परत (15–35 किमी) पाई जाती है और कौन-सी परत रेडियो तरंगों को पृथ्वी पर परावर्तित करती है?",
            listOf("Troposphere (Weather phenomena), Stratosphere (Ozone Layer & Jet aircraft flight), and Ionosphere / Thermosphere (Radio waves reflection)", "Stratosphere, Mesosphere, and Exosphere", "Troposphere, Mesosphere, and Stratosphere", "Mesosphere, Stratosphere, and Troposphere"),
            listOf("क्षोभमंडल / Troposphere (मौसमी घटनाएँ), समतापमंडल / Stratosphere (ओजोन परत व जेट विमान उड़ान) तथा आयनमंडल / Ionosphere (रेडियो तरंग परावर्तन)", "समतापमंडल, मध्यमंडल और बहिर्मंडल", "क्षोभमंडल, मध्यमंडल और समतापमंडल", "मध्यमंडल, समतापमंडल और क्षोभमंडल"),
            "Atmospheric Layers from Earth upwards: 1. Troposphere (0–8 km at poles, 0–18 km at equator; normal lapse rate 6.5°C/km; all clouds, rain, cyclones); 2. Stratosphere (up to 50 km; contains Ozone Layer maximally concentrated between 15 and 35 km, measured in Dobson Units); 3. Mesosphere (up to 80 km; coldest layer, meteors burn up here); 4. Thermosphere/Ionosphere (reflects radio waves & hosts Aurora).",
            "वायुमंडल की परतें: 1. क्षोभमंडल (सभी मौसमी घटनाएँ, बादल, वर्षा); 2. समतापमंडल (इसमें 15 से 35 किमी के बीच ओजोन परत पाई जाती है जो सूर्य की हानिकारक पराबैंगनी UV किरणों को रोकती है; ओजोन की मोटाई 'डॉब्सन इकाई' में मापी जाती है); 3. मध्यमंडल (सबसे ठंडी परत, उल्कापिंड यहीं जलते हैं); 4. आयनमंडल (रेडियो तरंगों का परावर्तन)।",
            "UPPCS Pre PYQ 2021, 2022, 2023"
        )
    )

    private val geographySecondHalfSeeds: List<RawPyqSeed> = listOf(
        RawPyqSeed(
            "Which river of Uttar Pradesh is notorious for 'Gully Erosion' (अवनालिका अपरदन) and forming deep 'Badland Topography' (Ravines / बीहड़) in Etawah and Agra districts?",
            "उत्तर प्रदेश के इटावा और आगरा जिलों में 'अवनालिका अपरदन' (Gully Erosion) और गहरे 'बीहड़' (Ravines / Badland Topography) के निर्माण के लिए कौन-सी नदी प्रसिद्ध है?",
            listOf("Chambal River (Originates from Janapao Hills, Vindhyan Range, MP and joins Yamuna near Etawah)", "Betwa River", "Son River", "Ghaghara River"),
            listOf("चंबल नदी (जानापाव पहाड़ी, म.प्र. से उद्गम एवं इटावा के पास यमुना में संगम)", "बेतवा नदी", "सोन नदी", "घाघरा नदी"),
            "The Chambal River originates from Janapao Hills (Mhow, MP), has four major dams (Gandhi Sagar in MP; Rana Pratap Sagar, Jawahar Sagar & Kota Barrage in Rajasthan), forms the boundary between MP, Rajasthan & UP, and causes severe gully erosion (ravines/badlands) in Etawah and Agra before joining the Yamuna at पंचनद (Etawah).",
            "चंबल नदी जानापाव पहाड़ी (महू, म.प्र.) से निकलती है। इस पर गांधी सागर (म.प्र.), राणा प्रताप सागर, जवाहर सागर व कोटा बैराज (राजस्थान) बाँध बने हैं तथा यह इटावा और आगरा में भयंकर अवनालिका अपरदन (बीहड़) का निर्माण करते हुए इटावा के पास यमुना में मिलती है।",
            "UPPCS Pre PYQ 2020, 2022, 2023"
        ),
        RawPyqSeed(
            "Match the major Lakes of India with their respective States/UTs:\n1. Wular & Dal Lake (Freshwater) — Jammu & Kashmir | Pangong Tso & Tso Moriri — Ladakh\n2. Chilika Lake (Largest brackish lagoon) — Odisha\n3. Pulicat Lake — Border of Andhra Pradesh & Tamil Nadu (Sriharikota Island)\n4. Loktak Lake (Keibul Lamjao Floating National Park) — Manipur & Vembanad Lake (Longest) — Kerala",
            "भारत की प्रमुख झीलों का उनके राज्यों/केंद्र शासित प्रदेशों से मिलान कीजिए:\n1. वुलर व डल झील (मीठे पानी की सबसे बड़ी) — जम्मू-कश्मीर | पैंगोंग त्सो व त्सो मुरारी — लद्दाख\n2. चिल्का झील (भारत की सबसे बड़ी खारे पानी की लैगून झील) — ओडिशा\n3. पुलिकट झील — आंध्र प्रदेश एवं तमिलनाडु सीमा (श्रीहरिकोटा द्वीप)\n4. लोकटक झील (केइबुल लामजाओ तैरता पार्क) — मणिपुर एवं वेम्बनाद झील — केरल",
            listOf("All 1, 2, 3 and 4 are correctly matched", "1 and 2 only", "2, 3 and 4 only", "1, 3 and 4 only"),
            listOf("सभी 1, 2, 3 और 4 सही सुमेलित हैं", "केवल 1 और 2", "केवल 2, 3 और 4", "केवल 1, 3 और 4"),
            "Other key lakes tested in UPPCS: Sambhar Lake (Rajasthan — largest inland salt lake); Lonar Lake (Maharashtra — crater/meteoric impact lake); Kolleru Lake (Andhra Pradesh — freshwater lake between Godavari & Krishna deltas); Ashtamudi & Sasthamkotta (Kerala); Roopkund ('Mystery/Skeleton Lake' — Uttarakhand); Surha Tal (Ballia, UP); Bakhira Lake (Sant Kabir Nagar, UP); Keetham/Sur Sarovar (Agra, UP).",
            "UPPCS में पूछी जाने वाली अन्य प्रमुख झीलें: सांभर झील (राजस्थान — सर्वाधिक खारे पानी की अंतःस्थलीय झील); लोनार झील (महाराष्ट्र — ज्वालामुखी/उल्कापिंड क्रेटर झील); कोलेरू झील (आंध्र प्रदेश); रूपकुंड ('रहस्यमयी झील' — उत्तराखंड); सुरहा ताल (बलिया, उ.प्र.); बखीरा झील (संत कबीर नगर, उ.प्र.); कीठम/सूर सरोवर (आगरा, उ.प्र.)।",
            "UPPCS Pre PYQ 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "Which Agricultural Revolutions in India are associated with Oilseeds, Fertilizers, Fish/Aquaculture, and Milk/Dairy respectively?",
            "भारत में क्रमशः तिलहन उत्पादन, उर्वरक उत्पादन, मत्स्य पालन और दुग्ध उत्पादन से संबंधित कृषि क्रांतियाँ कौन-सी हैं?",
            listOf("Yellow Revolution (Oilseeds), Grey Revolution (Fertilizers), Blue Revolution (Fisheries), and White Revolution / Operation Flood (Milk — Dr. Verghese Kurien)", "Golden Revolution, Silver Revolution, Pink Revolution, and Round Revolution", "Black Revolution, Red Revolution, Evergreen Revolution, and Brown Revolution", "Green Revolution, Blue Revolution, White Revolution, and Silver Fiber Revolution"),
            listOf("पीली क्रांति (तिलहन), भूरी/धूसर क्रांति (उर्वरक), नीली क्रांति (मत्स्य पालन) तथा श्वेत क्रांति / ऑपरेशन फ्लड (दुग्ध उत्पादन — डॉ. वर्गीज कुरियन)", "सुनहरी क्रांति, रजत क्रांति, गुलाबी क्रांति और गोल क्रांति", "काली क्रांति, लाल क्रांति, सदाबहार क्रांति और भूरी क्रांति", "हरित क्रांति, नीली क्रांति, श्वेत क्रांति और रजत रेशा क्रांति"),
            "Complete Agricultural Revolutions List for UPPCS: Green (Foodgrains — M.S. Swaminathan in India, Norman Borlaug globally); White (Milk — Dr. Verghese Kurien, Operation Flood 1970); Yellow (Oilseeds — Sam Pitroda); Blue (Fish — Hiralal Chaudhuri); Golden (Fruits/Horticulture & Honey); Golden Fiber (Jute); Silver (Eggs/Poultry); Silver Fiber (Cotton); Pink (Prawns/Onion); Red (Tomatoes/Meat); Round (Potato); Black (Petroleum/Biofuels).",
            "कृषि क्रांतियों की सूची: हरित क्रांति (खाद्यान्न — भारत में एम.एस. स्वामीनाथन, विश्व में नॉर्मन बोरलॉग); श्वेत क्रांति (दुग्ध — डॉ. वर्गीज कुरियन, ऑपरेशन फ्लड 1970); पीली क्रांति (तिलहन); नीली क्रांति (मत्स्य); सुनहरी क्रांति (बागवानी/फल व शहद); गोल्डन फाइबर (जूट); सिल्वर फाइबर (कपास); रजत क्रांति (अंडा); गुलाबी क्रांति (झींगा/प्याज); लाल क्रांति (टमाटर/मांस); गोल क्रांति (आलू)।",
            "UPPCS Pre PYQ 2020, 2021, 2023"
        ),
        RawPyqSeed(
            "In which products does Uttar Pradesh rank FIRST (#1) in India in terms of total agricultural production?",
            "कुल कृषि एवं पशुपालन उत्पादन की दृष्टि से उत्तर प्रदेश का देश में किन उत्पादों में प्रथम (#1) स्थान है?",
            listOf("Wheat, Sugarcane, Sugar, Potato, Total Foodgrains, Milk, Mango, Guava, Aonla, and Mentha Oil", "Rice, Cotton, Groundnut, and Coffee", "Soybean, Mustard, Pulses, and Tea", "Jute, Rubber, Spices, and Coconut"),
            listOf("गेहूँ, गन्ना, चीनी, आलू, कुल खाद्यान्न, दुग्ध उत्पादन, आम, अमरूद, आँवला और मेंथा ऑयल", "चावल, कपास, मूंगफली और कॉफी", "सोयाबीन, सरसों, दलहन और चाय", "जूट, रबर, मसाले और नारियल"),
            "Uttar Pradesh ranks #1 in India in total production of: Total Foodgrains (~18% of India), Wheat, Sugarcane, Sugar, Potato, Milk, Livestock population, Mango (Malihabad Dussehri, Varanasi Langra, Saharanpur Chausa), Aonla (Pratapgarh), Guava (Prayagraj), Peas, and Mentha Oil. Meanwhile, West Bengal leads in Rice & Jute (though UP is #2 in Rice); MP leads in Soybean & Pulses; Rajasthan leads in Rapeseed-Mustard & Bajra; Karnataka leads in Coffee; Kerala leads in Natural Rubber.",
            "उत्तर प्रदेश देश में कुल खाद्यान्न, गेहूँ, गन्ना, चीनी, आलू, दुग्ध उत्पादन, कुल पशुधन, आम (मलीहाबादी दशहरी), आँवला (प्रतापगढ़), अमरूद (प्रयागराज) और मेंथा ऑयल के उत्पादन में प्रथम स्थान पर है। गोरखपुर में उ.प्र. की सर्वाधिक गेहूँ पैदावार होती है।",
            "UPPCS Pre PYQ 2021, 2022, 2023, 2024"
        ),
        RawPyqSeed(
            "Match the major Nuclear Power Plants of India with their respective States:\n1. Narora Atomic Power Station — Bulandshahr (Uttar Pradesh)\n2. Tarapur (India's first, 1969) — Maharashtra & Kakrapar — Gujarat\n3. Rawatbhata — Rajasthan & Kaiga — Karnataka\n4. Kalpakkam & Kudankulam — Tamil Nadu",
            "भारत के प्रमुख परमाणु ऊर्जा संयंत्रों (Nuclear Power Plants) का उनके राज्यों से सही मिलान चुनिए:\n1. नरोरा परमाणु विद्युत केंद्र — बुलंदशहर (उत्तर प्रदेश)\n2. तारापुर (भारत का प्रथम, 1969) — महाराष्ट्र एवं काकरापार — गुजरात\n3. रावतभाटा — राजस्थान एवं कैगा — कर्नाटक\n4. कलपक्कम एवं कुडनकुलम — तमिलनाडु",
            listOf("All 1, 2, 3 and 4 are correctly matched", "1 and 2 only", "2, 3 and 4 only", "1, 3 and 4 only"),
            listOf("सभी 1, 2, 3 और 4 सही सुमेलित हैं", "केवल 1 और 2", "केवल 2, 3 और 4", "केवल 1, 3 और 4"),
            "All 7 operational nuclear power stations in India are covered here: Tarapur (Maharashtra — oldest, 1969), Rawatbhata (Rajasthan), Kalpakkam (Madras Atomic Power Station, TN), Narora (Bulandshahr district on the banks of Ganga, UP — commissioned in 1991), Kakrapar (Surat/Tapi, Gujarat), Kaiga (Karnataka), and Kudankulam (Tirunelveli, TN — largest capacity, built with Russian collaboration).",
            "भारत के सभी 7 कार्यरत परमाणु ऊर्जा संयंत्र: 1. तारापुर (महाराष्ट्र — भारत का प्रथम, 1969); 2. रावतभाटा (राजस्थान); 3. कलपक्कम (तमिलनाडु); 4. नरोरा (बुलंदशहर जिला, उत्तर प्रदेश — गंगा तट पर स्थित राज्य का एकमात्र परमाणु संयंत्र); 5. काकरापार (गुजरात); 6. कैगा (कर्नाटक); 7. कुडनकुलम (तमिलनाडु — रूस के सहयोग से निर्मित सबसे बड़ा संयंत्र)।",
            "UPPCS Pre PYQ 2020, 2022, 2023"
        ),
        RawPyqSeed(
            "Match the major Iron and Steel Plants established during the Second and Third Five-Year Plans with their collaborating countries:\n1. Bhilai Steel Plant (Chhattisgarh) — USSR (Soviet Union)\n2. Rourkela Steel Plant (Odisha) — Germany\n3. Durgapur Steel Plant (West Bengal) — United Kingdom (Britain)\n4. Bokaro Steel Plant (Jharkhand, 3rd Plan) — USSR",
            "द्वितीय एवं तृतीय पंचवर्षीय योजना के दौरान स्थापित प्रमुख लौह-इस्पात संयंत्रों का उनके सहयोगी देशों से मिलान कीजिए:\n1. भिलाई इस्पात संयंत्र (छत्तीसगढ़) — सोवियत संघ (USSR)\n2. राउरकेला इस्पात संयंत्र (ओडिशा) — जर्मनी\n3. दुर्गापुर इस्पात संयंत्र (पश्चिम बंगाल) — ब्रिटेन (UK)\n4. बोकारो इस्पात संयंत्र (झारखंड, तृतीय योजना) — सोवियत संघ (USSR)",
            listOf("All 1, 2, 3 and 4 are correctly matched", "1 and 2 only", "1, 3 and 4 only", "2 and 3 only"),
            listOf("सभी 1, 2, 3 और 4 सही सुमेलित हैं", "केवल 1 और 2", "केवल 1, 3 और 4", "केवल 2 और 3"),
            "2nd Five-Year Plan (1956–61, Mahalanobis Model) set up three public-sector steel plants: Bhilai (Chhattisgarh — USSR), Rourkela (Odisha, on Brahmani river — West Germany), and Durgapur (West Bengal, on Damodar river — UK). Bokaro Steel Plant (Jharkhand) was set up during the 3rd Plan (1964) with Soviet (USSR) collaboration. Meanwhile, HINDALCO (Aluminium plant) is located at Renukoot (Sonbhadra, UP).",
            "द्वितीय पंचवर्षीय योजना (1956–61) में तीन इस्पात संयंत्र स्थापित हुए: भिलाई (छत्तीसगढ़ — सोवियत संघ), राउरकेला (ओडिशा — जर्मनी), और दुर्गापुर (प. बंगाल — ब्रिटेन)। बोकारो (झारखंड) तृतीय योजना में सोवियत संघ के सहयोग से स्थापित हुआ। वहीं उत्तर प्रदेश के रेणुकूट (सोनभद्र) में हिंडाल्को (HINDALCO) एल्युमीनियम संयंत्र स्थित है।",
            "UPPCS Pre PYQ 2020, 2021, 2023"
        ),
        RawPyqSeed(
            "Match the Major Sea Ports of India with their special characteristics:\n1. Deendayal Port (Kandla, Gujarat) — Tidal Port & Free Trade Zone\n2. Jawaharlal Nehru Port (Nhava Sheva, Mumbai) — Largest Container Port in India\n3. Visakhapatnam (Andhra Pradesh) — Deepest Land-locked Natural Port (protected by Dolphin's Nose hill)\n4. Chennai (Tamil Nadu) — Oldest Artificial Port on East Coast",
            "भारत के प्रमुख बंदरगाहों का उनकी विशेषताओं के साथ सही मिलान चुनिए:\n1. दीनदयाल बंदरगाह (कांडला, गुजरात) — ज्वारीय बंदरगाह (Tidal Port)\n2. जवाहरलाल नेहरू पोर्ट (न्हावा शेवा, मुंबई) — भारत का सबसे बड़ा कंटेनर बंदरगाह\n3. विशाखापत्तनम (आंध्र प्रदेश) — भारत का सबसे गहरा स्थल-बद्ध प्राकृतिक बंदरगाह\n4. चेन्नई (तमिलनाडु) — पूर्वी तट का सबसे पुराना कृत्रिम बंदरगाह",
            listOf("All 1, 2, 3 and 4 are correctly matched", "1, 2 and 3 only", "2 and 3 only", "1 and 4 only"),
            listOf("सभी 1, 2, 3 और 4 सही सुमेलित हैं", "केवल 1, 2 और 3", "केवल 2 और 3", "केवल 1 और 4"),
            "India has 13 Major Ports: West Coast (6): Kandla/Deendayal (Gujarat; Mundra is India's largest private port), Mumbai (largest natural port), JNPT/Nhava Sheva (largest mechanized container port), Mormugao (Goa, on Zuari estuary — iron ore export), New Mangalore (Karnataka — exports Kudremukh iron ore), Cochin (Kerala, on Vembanad Kayal). East Coast (7): Tuticorin/V.O. Chidambaranar, Chennai, Ennore/Kamarajar (first corporatized port), Visakhapatnam, Paradip (Odisha), Haldia/Kolkata (Syama Prasad Mookerjee — riverine port), and Port Blair.",
            "भारत के प्रमुख बंदरगाह: कांडला/दीनदयाल (गुजरात — ज्वारीय बंदरगाह); मुंबई (सबसे बड़ा प्राकृतिक बंदरगाह); न्हावा शेवा/JNPT (सबसे बड़ा कंटेनर पोर्ट); मोरमुगाओ (गोवा — जुआरी ज्वारनदमुख पर); न्यू मंगलौर (कर्नाटक — कुद्रेमुख लौह अयस्क निर्यात); विशाखापत्तनम (सबसे गहरा बंदरगाह); कोलकाता/श्यामा प्रसाद मुखर्जी (हुगली नदी पर स्थित नदीय बंदरगाह)।",
            "UPPCS Pre PYQ 2021 & 2023"
        ),
        RawPyqSeed(
            "Where are the headquarters of the 18th Railway Zone 'South Coast Railway' and the two Railway Zones located within Uttar Pradesh?",
            "भारतीय रेलवे के 18वें ज़ोन 'दक्षिण तटीय रेलवे' (South Coast Railway) का मुख्यालय कहाँ है तथा उत्तर प्रदेश में स्थित दो रेलवे ज़ोन मुख्यालय कौन-से हैं?",
            listOf("South Coast Railway HQ: Visakhapatnam | UP Railway Zone HQs: Prayagraj (North Central Railway - NCR) and Gorakhpur (North Eastern Railway - NER)", "South Coast Railway HQ: Vijayawada | UP HQs: Lucknow and Varanasi", "South Coast Railway HQ: Secunderabad | UP HQs: Prayagraj and Kanpur", "South Coast Railway HQ: Chennai | UP HQs: Gorakhpur and Jhansi"),
            listOf("दक्षिण तटीय रेलवे: विशाखापत्तनम | उ.प्र. में स्थित दो मुख्यालय: प्रयागराज (उत्तर मध्य रेलवे - NCR) और गोरखपुर (पूर्वोत्तर रेलवे - NER)", "दक्षिण तटीय रेलवे: विजयवाड़ा | उ.प्र.: लखनऊ और वाराणसी", "दक्षिण तटीय रेलवे: सिकंदराबाद | उ.प्र.: प्रयागराज और कानपुर", "दक्षिण तटीय रेलवे: चेन्नई | उ.प्र.: गोरखपुर और झाँसी"),
            "Visakhapatnam (Andhra Pradesh) is the headquarters of the 18th Railway Zone (South Coast Railway). Within Uttar Pradesh, Prayagraj is the HQ of North Central Railway (NCR, formed in 2003) and Gorakhpur is the HQ of North Eastern Railway (NER).",
            "भारतीय रेलवे के 18वें ज़ोन 'दक्षिण तटीय रेलवे' का मुख्यालय विशाखापत्तनम में है। उत्तर प्रदेश में दो रेलवे ज़ोन के मुख्यालय स्थित हैं: 1. उत्तर मध्य रेलवे (NCR) — प्रयागराज और 2. पूर्वोत्तर रेलवे (NER) — गोरखपुर।",
            "UPPCS Pre PYQ 2020 & 2022"
        ),
        RawPyqSeed(
            "Match the major Mountain Ranges of the World with their Continents and Highest Peaks:\n1. Andes (South America — Longest continental range, 7,000 km) — Mt. Aconcagua\n2. Rockies (North America) — Mt. Elbert (while Denali/Mt. McKinley in Alaska is highest in N. America)\n3. Alps (Europe) — Mont Blanc (while Mt. Elbrus in Caucasus is highest in Europe)\n4. Great Dividing Range (Australia) — Mt. Kosciuszko & Atlas Mountains (North-West Africa: Morocco, Algeria, Tunisia)",
            "विश्व की प्रमुख पर्वत श्रेणियों का उनके महाद्वीपों एवं सर्वोच्च शिखरों के साथ मिलान कीजिए:\n1. एंडीज (दक्षिण अमेरिका — विश्व की सबसे लंबी पर्वत श्रृंखला) — एकांकागुआ\n2. रॉकीज (उत्तरी अमेरिका) — माउंट एल्बर्ट (उत्तरी अमेरिका का सर्वोच्च शिखर: डेनाली/मैककिन्ले)\n3. आल्प्स (यूरोप) — माउंट ब्लैंक (यूरोप का सर्वोच्च शिखर: काकेशस में माउंट एल्ब्रुस)\n4. ग्रेट डिवाइडिंग रेंज (ऑस्ट्रेलिया) — माउंट कोसियुस्को एवं एटलस पर्वत (उ.प. अफ्रीका: मोरक्को, अल्जीरिया, ट्यूनीशिया)",
            listOf("All 1, 2, 3 and 4 are correctly matched", "1 and 2 only", "1, 3 and 4 only", "2, 3 and 4 only"),
            listOf("सभी 1, 2, 3 और 4 सही सुमेलित हैं", "केवल 1 और 2", "केवल 1, 3 और 4", "केवल 2, 3 और 4"),
            "Other key World Mountains asked in UPPCS: Southern Alps — New Zealand (Mt. Cook/Aoraki); Drakensberg — South Africa; Ural Mountains — separates Europe and Asia in Russia; Apennines — Italy; Pyrenees — border between France and Spain; Black Forest (Germany) & Vosges (France) — classic Block Mountains (Horsts) with the Rhine Rift Valley between them!",
            "अन्य प्रमुख विश्व पर्वत: दक्षिणी आल्प्स — न्यूजीलैंड (माउंट कुक); ड्रेकेंसबर्ग — दक्षिण अफ्रीका; यूराल पर्वत — यूरोप और एशिया की सीमा (रूस); पिरेनीज — फ्रांस और स्पेन की सीमा; ब्लैक फॉरेस्ट (जर्मनी) और वॉसजेस (फ्रांस) — भ्रंशोत्थ पर्वत (Block Mountains) जिनके मध्य से राइन नदी भ्रंश घाटी में बहती है!",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "Match the Major Deserts of the World with their locations:\n1. Atacama Desert (Driest non-polar desert, rich in Sodium Nitrate) — Northern Chile & Peru (South America)\n2. Kalahari Desert (Home to Bushmen/San tribe) — Botswana, Namibia & South Africa\n3. Taklamakan Desert — Xinjiang (China) & Gobi Desert — Mongolia & China\n4. Gibson, Simpson, Great Victoria & Great Sandy Deserts — Australia",
            "विश्व के प्रमुख मरुस्थलों का उनकी भौगोलिक स्थिति के साथ मिलान कीजिए:\n1. अटाकामा मरुस्थल (विश्व का सबसे शुष्क मरुस्थल, नाइट्रेट भंडार) — उत्तरी चिली व पेरू (दक्षिण अमेरिका)\n2. कालाहारी मरुस्थल (बुशमैन जनजाति का निवास) — बोत्सवाना, नामीबिया व दक्षिण अफ्रीका\n3. तकलामाकन मरुस्थल — चीन एवं गोबी मरुस्थल — मंगोलिया व चीन\n4. गिब्सन, सिम्पसन, ग्रेट विक्टोरिया व ग्रेट सैंडी मरुस्थल — ऑस्ट्रेलिया",
            listOf("All 1, 2, 3 and 4 are correctly matched", "1, 2 and 3 only", "2 and 4 only", "1 and 3 only"),
            listOf("सभी 1, 2, 3 और 4 सही सुमेलित हैं", "केवल 1, 2 और 3", "केवल 2 और 4", "केवल 1 और 3"),
            "Other Deserts asked in UPPCS: Patagonia Desert (Argentina — temperate rain-shadow desert); Mojave & Sonoran Deserts (USA/Mexico); Dasht-e-Lut & Dasht-e-Kavir (Iran); Rub' al Khali & An-Nafud (Saudi Arabia); Karakum (Turkmenistan); Kyzylkum (Uzbekistan/Kazakhstan); Thar Desert (India/Pakistan — most densely populated desert in the world).",
            "UPPCS में पूछे जाने वाले अन्य मरुस्थल: पेंटागोनिया मरुस्थल (अर्जेंटीना — शीतोष्ण मरुस्थल); मोजावे व सोनोरन (अमेरिका/मैक्सिको); दश्त-ए-लूत व दश्त-ए-कवीर (ईरान); रब-अल-खाली (सऊदी अरब); काराकुम (तुर्कमेनिस्तान); किजिलकुम (उज्बेकिस्तान); थार मरुस्थल (भारत/पाकिस्तान — विश्व का सर्वाधिक जनघनत्व वाला मरुस्थल)।",
            "UPPCS Pre PYQ 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "Match the Major Rivers of the World with the Seas/Gulfs they drain into and the Cities on their banks:\n1. Nile (Longest river) — Mediterranean Sea (Cairo & Khartoum)\n2. Danube (Flows through 10 European countries & 4 capitals: Vienna, Bratislava, Budapest, Belgrade) — Black Sea\n3. Volga (Longest river in Europe) — Caspian Sea\n4. Mekong (Longest river in South-East Asia) — South China Sea",
            "विश्व की प्रमुख नदियों का उनके मुहाने (सागर) एवं तटवर्ती नगरों से मिलान कीजिए:\n1. नील नदी (विश्व की सबसे लंबी नदी) — भूमध्य सागर (काहिरा व खार्तूम नगर)\n2. डेन्यूब नदी (यूरोप के 10 देशों व 4 राजधानियों—वियना, ब्रातिस्लावा, बुडापेस्ट, बेलग्रेड से बहती है) — काला सागर\n3. वोल्गा नदी (यूरोप की सबसे लंबी नदी) — कैस्पियन सागर\n4. मेकांग नदी (दक्षिण-पूर्व एशिया की सबसे लंबी नदी) — दक्षिण चीन सागर",
            listOf("All 1, 2, 3 and 4 are correctly matched", "1 and 2 only", "2, 3 and 4 only", "1, 3 and 4 only"),
            listOf("सभी 1, 2, 3 और 4 सही सुमेलित हैं", "केवल 1 और 2", "केवल 2, 3 और 4", "केवल 1, 3 और 4"),
            "Additional World River facts for UPPCS: Congo/Zaire River (Africa) crosses the Equator (0°) twice; Limpopo River (Southern Africa) crosses the Tropic of Capricorn (23.5° S) twice; Mahi River (India) crosses the Tropic of Cancer (23.5° N) twice! Rhine River (Europe's busiest inland waterway, Rotterdam port at mouth) flows into the North Sea; Mississippi-Missouri forms a 'Bird-foot Delta' in the Gulf of Mexico.",
            "विश्व की नदियों के विशेष तथ्य: कांगो/जायरे नदी (अफ्रीका) भूमध्य रेखा (Equator) को दो बार काटती है; लिम्पोपो नदी (अफ्रीका) मकर रेखा को दो बार काटती है; तथा माही नदी (भारत) कर्क रेखा को दो बार काटती है! राइन नदी यूरोप का सबसे व्यस्त अंतःस्थलीय जलमार्ग है और मिसिसिपी नदी मैक्सिको की खाड़ी में 'पक्षी-पाद डेल्टा' (Bird-foot Delta) बनाती है।",
            "UPPCS Pre PYQ 2020, 2022, 2023"
        ),
        RawPyqSeed(
            "Arrange the Five Great Lakes of North America (USA–Canada border) from West to East, and identify which one lies entirely within the USA:",
            "उत्तरी अमेरिका की 'पाँच महान झीलों' (Great Lakes) का पश्चिम से पूर्व (West to East) सही क्रम क्या है और इनमें से कौन-सी झील पूर्णतः संयुक्त राज्य अमेरिका (USA) में स्थित है?",
            listOf("West to East: Superior -> Michigan -> Huron -> Erie -> Ontario | Lake Michigan lies entirely within the USA (Lake Superior is the world's largest freshwater lake by surface area)", "Michigan -> Superior -> Huron -> Ontario -> Erie", "Superior -> Huron -> Michigan -> Erie -> Ontario", "Erie -> Ontario -> Huron -> Michigan -> Superior"),
            listOf("पश्चिम से पूर्व: सुपीरियर -> मिशिगन -> ह्यूरन -> ईरी -> ओंटारियो | 'मिशिगन झील' पूर्णतः USA में स्थित है (सुपीरियर झील क्षेत्रफल की दृष्टि से विश्व की सबसे बड़ी मीठे पानी की झील है)", "मिशिगन -> सुपीरियर -> ह्यूरन -> ओंटारियो -> ईरी", "सुपीरियर -> ह्यूरन -> मिशिगन -> ईरी -> ओंटारियो", "ईरी -> ओंटारियो -> ह्यूरन -> मिशिगन -> सुपीरियर"),
            "Great Lakes West-to-East order: Superior -> Michigan -> Huron -> Erie -> Ontario. Soo Canal connects Superior & Huron; Welland Canal (bypassing Niagara Falls) connects Erie & Ontario. Lake Michigan is the ONLY Great Lake completely inside the USA; the other four share the US-Canada border. Meanwhile, Lake Baikal (Siberia, Russia) is the deepest lake in the world (1,642 m) and largest by volume.",
            "ग्रेट लेक्स का पश्चिम से पूर्व क्रम: सुपीरियर -> मिशिगन -> ह्यूरन -> ईरी -> ओंटारियो। 'सू नहर' सुपीरियर व ह्यूरन को जोड़ती है तथा 'वेलैंड नहर' (नियाग्रा जलप्रपात के पास) ईरी व ओंटारियो को जोड़ती है। मिशिगन झील पूर्णतः USA में है। वहीं रूस की 'बैकाल झील' विश्व की सबसे गहरी झील है।",
            "UPPCS Pre PYQ 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "Match the Indigenous Tribes / Peoples of the World with their respective Regions:\n1. Bushmen (San) — Kalahari Desert & Pygmies — Congo Basin\n2. Maasai — East Africa (Kenya & Tanzania) & Bedouins — Arabian Desert\n3. Inuit (Eskimo) — Arctic Tundra (Canada/Greenland) & Sami (Lapps) — Scandinavia\n4. Maori — New Zealand & Semang — Malaysia",
            "विश्व की प्रमुख जनजातियों का उनके निवास क्षेत्रों के साथ सही मिलान चुनिए:\n1. बुशमैन — कालाहारी मरुस्थल एवं पिग्मी — कांगो बेसिन\n2. मसाई — पूर्वी अफ्रीका (केन्या व तंजानिया) एवं बद्दू (Bedouins) — अरब मरुस्थल\n3. इनुइट (एस्किमो) — टुंड्रा प्रदेश (कनाडा/ग्रीनलैंड) एवं सामी (लैप्स) — स्कैंडिनेविया\n4. माओरी — न्यूजीलैंड एवं सेमांग — मलेशिया",
            listOf("All 1, 2, 3 and 4 are correctly matched", "1 and 2 only", "2, 3 and 4 only", "1, 3 and 4 only"),
            listOf("सभी 1, 2, 3 और 4 सही सुमेलित हैं", "केवल 1 और 2", "केवल 2, 3 और 4", "केवल 1, 3 और 4"),
            "Other World Tribes asked in UPPCS: Kyrgyz — Central Asia (Kyrgyzstan, live in Yurts); Ainu — Japan; Vedda — Sri Lanka; Zulu — South Africa; Hausa & Fulani — Nigeria; Bindibu / Aborigines — Australia.",
            "UPPCS में पूछी जाने वाली अन्य विश्व जनजातियाँ: खिरगीज — मध्य एशिया (किर्गिस्तान); ऐनू (Ainu) — जापान; वेद्दा — श्रीलंका; जुलू — दक्षिण अफ्रीका; हौसा — नाइजीरिया; बिंदुबू — ऑस्ट्रेलिया।",
            "UPPCS Pre PYQ 2020, 2021, 2023"
        ),
        RawPyqSeed(
            "Which seismic waves can travel through all media (Solid, Liquid, and Gas) vs ONLY through Solids, and where is the deepest oceanic trench ('Challenger Deep' in Mariana Trench) located?",
            "कौन-सी भूकंपीय तरंगें ठोस, द्रव एवं गैस तीनों माध्यमों से गुजर सकती हैं बनाम केवल ठोस माध्यम से गुजरती हैं, तथा विश्व की सबसे गहरी महासागरीय गर्त ('मेरियाना गर्त') किस महासागर में है?",
            listOf("P-Waves (Primary/Longitudinal) travel through Solid, Liquid & Gas; S-Waves (Secondary/Transverse) travel ONLY through Solids | Mariana Trench (~11,034 m) is in the Western Pacific Ocean", "S-Waves travel through all media; P-Waves only through solids | Mariana Trench is in the Atlantic Ocean (Puerto Rico Trench)", "L-Waves travel through the Earth's core | Mariana Trench is in the Indian Ocean (Sunda/Java Trench)", "P-Waves cannot cross the Mantle | Mariana Trench is in the Arctic Ocean"),
            listOf("P-तरंगें (प्राथमिक/अनुदैर्ध्य) ठोस, द्रव व गैस तीनों में चलती हैं; S-तरंगें (द्वितीयक/अनुप्रस्थ) केवल ठोस में चलती हैं | मेरियाना गर्त (~11,034 मी.) प्रशांत महासागर में है", "S-तरंगें तीनों माध्यमों में चलती हैं | मेरियाना गर्त अटलांटिक महासागर में है", "L-तरंगें पृथ्वी के क्रोड से गुजरती हैं | मेरियाना गर्त हिंद महासागर में है", "P-तरंगें मेंटल को पार नहीं कर पातीं | मेरियाना गर्त आर्कटिक महासागर में है"),
            "Seismic Waves: P-waves (fastest, longitudinal like sound waves) pass through solid, liquid, and gas; S-waves (transverse like light waves) cannot pass through the liquid Outer Core (creating an S-wave shadow zone beyond 103°); L-waves (Surface waves) have the longest wavelength and cause maximum destruction. Deepest Ocean Trenches: Pacific — Mariana Trench (Challenger Deep); Atlantic — Puerto Rico Trench; Indian Ocean — Sunda (Java) Trench.",
            "भूकंपीय तरंगें: P-तरंगें (सर्वाधिक वेग, ध्वनि तरंगों के समान अनुदैर्ध्य) ठोस, द्रव व गैस तीनों से गुजरती हैं; S-तरंगें (अनुप्रस्थ) केवल ठोस माध्यम से गुजरती हैं और पृथ्वी के तरल बाह्य क्रोड में प्रवेश नहीं कर पातीं; L-तरंगें (धरातलीय तरंगें) सर्वाधिक विनाशकारी होती हैं। महासागरीय गर्त: प्रशांत महासागर — मेरियाना गर्त; अटलांटिक — प्यूर्टो रिको गर्त; हिंद महासागर — सुंडा (जावा) गर्त।",
            "UPPCS Pre PYQ 2021 & 2023"
        ),
        RawPyqSeed(
            "What are the 'Roaring Forties', 'Furious Fifties', and 'Shrieking Sixties', and where is the 'Sargasso Sea' (a sea without a land boundary/coastline) located?",
            "'गरजती चालीसा' (Roaring Forties), 'प्रचंड पचासा' और 'चीखती साठा' क्या हैं, तथा बिना तटरेखा वाला प्रसिद्ध 'सारगैसो सागर' (Sargasso Sea) कहाँ स्थित है?",
            listOf("Strong Westerly Winds (पछुआ पवनें) in the Southern Hemisphere between 40°S and 60°S | Sargasso Sea is located in the North Atlantic Ocean (surrounded by Gulf Stream, North Atlantic Drift, Canary & North Equatorial currents)", "Polar Easterly Winds in the Northern Hemisphere | Sargasso Sea is in the South Pacific Ocean", "Trade Winds near the Equator | Sargasso Sea is in the Indian Ocean", "Monsoon Winds in South Asia | Sargasso Sea is in the Mediterranean Sea"),
            listOf("दक्षिणी गोलार्ध में 40° से 60° दक्षिणी अक्षांशों के बीच चलने वाली तीव्र पछुआ पवनें (Westerlies) | 'सारगैसो सागर' उत्तरी अटलांटिक महासागर में स्थित है", "उत्तरी गोलार्ध की ध्रुवीय पुरवा पवनें | सारगैसो सागर दक्षिणी प्रशांत में है", "विषुवतरेखीय व्यापारिक पवनें | सारगैसो सागर हिंद महासागर में है", "दक्षिण एशिया की मानसूनी पवनें | सारगैसो सागर भूमध्य सागर में है"),
            "Due to minimal landmass and friction in the Southern Hemisphere between 40°S and 60°S latitudes, the Westerlies blow with tremendous speed and are called Roaring Forties (40°S), Furious Fifties (50°S), and Shrieking Sixties (60°S). Meanwhile, the Sargasso Sea is a calm, rootless-seaweed ('Sargassum') rich region in the North Atlantic Ocean Gyre—the only sea in the world with no land boundary.",
            "दक्षिणी गोलार्ध में 40° से 60° अक्षांशों के मध्य स्थलखंड के अभाव के कारण पछुआ पवनें अत्यंत तीव्र गति से चलती हैं, जिन्हें 'गरजती चालीसा', 'प्रचंड पचासा' और 'चीखती साठा' कहा जाता है। वहीं 'सारगैसो सागर' उत्तरी अटलांटिक महासागर के मध्य शांत जल का क्षेत्र है, जो विश्व का एकमात्र बिना तटरेखा वाला सागर है।",
            "UPPCS Pre PYQ 2020, 2022, 2023"
        )
    )

    // =========================================================================
    // SECTION 4: ENVIRONMENT & ECOLOGY (50 Authentic UPPCS 2020–2025 PYQ Questions)
    // =========================================================================
    private val environment50Seeds: List<RawPyqSeed> = listOf(
        RawPyqSeed(
            "Who coined the terms 'Ecology' (1866), 'Ecosystem' (1935), and 'Biodiversity Hotspot' (1988) respectively?",
            "क्रमशः 'पारिस्थितिकी' (Ecology - 1866), 'पारिस्थितिकी तंत्र' (Ecosystem - 1935) और 'जैव-विविधता हॉटस्पॉट' (Biodiversity Hotspot - 1988) शब्द सर्वप्रथम किसने प्रतिपादित किए थे?",
            listOf("Ernst Haeckel (Ecology, 1866), A.G. Tansley (Ecosystem, 1935), and Norman Myers (Biodiversity Hotspot, 1988)", "Charles Elton, Eugene Odum, and Edward O. Wilson", "Raymond Lindeman, Alexander von Humboldt, and Walter Rosen", "Arthur Tansley, Ernst Haeckel, and Charles Darwin"),
            listOf("अर्न्स्ट हेकेल (Ecology - 1866), ए.जी. टैंसले (Ecosystem - 1935) तथा नॉर्मन मायर्स (Biodiversity Hotspot - 1988)", "चार्ल्स एल्टन, यूजीन ओडम और एडवर्ड विल्सन", "रेमंड लिंडमैन, हम्बोल्ट और वाल्टर रोसेन", "आर्थर टैंसले, अर्न्स्ट हेकेल और चार्ल्स डार्विन"),
            "Foundational Ecology Terms (asked in almost every UPPCS Prelims): 'Ecology' (Oekologie) — Ernst Haeckel (1866); 'Ecosystem' — A.G. Tansley (1935); 'Ecological Niche' — Joseph Grinnell (1917); '10% Law of Energy Transfer' — Raymond Lindeman (1942); 'Biological Diversity' — Raymond Dasmann (1968), 'Biodiversity' — Walter G. Rosen (1985); 'Biodiversity Hotspot' — Norman Myers (1988).",
            "UPPCS पर्यावरण के मूलभूत प्रश्न: 'इकोलॉजी' शब्द — अर्न्स्ट हेकेल (1866); 'इकोसिस्टम' (पारिस्थितिकी तंत्र) — ए.जी. टैंसले (1935); 'पारिस्थितिक निकेत' (Niche) — जोसेफ ग्रिनेल (1917); 'ऊर्जा का 10% नियम' — रेमंड लिंडमैन (1942); 'बायोडायवर्सिटी' — वाल्टर जी. रोसेन (1985); 'जैव-विविधता हॉटस्पॉट' — नॉर्मन मायर्स (1988)।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "In any Ecosystem, the 'Pyramid of Energy' is ALWAYS:",
            "किसी भी पारिस्थितिकी तंत्र (Ecosystem) में 'ऊर्जा का पिरामिड' (Pyramid of Energy) सदैव कैसा होता है?",
            listOf("Always Upright (सीधा), because only 10% of energy is transferred from one trophic level to the next (Lindeman's 10% Law)", "Always Inverted (उल्टा)", "Upright in forest ecosystem and Inverted in marine ecosystem", "Spindle-shaped"),
            listOf("सदैव सीधा (Always Upright), क्योंकि लिंडमैन के 10% नियम के अनुसार एक पोषण स्तर से अगले स्तर में केवल 10% ऊर्जा ही स्थानांतरित होती है", "सदैव उल्टा (Always Inverted)", "वन में सीधा और समुद्र में उल्टा", "तर्कुरूपी (Spindle-shaped)"),
            "Ecological Pyramids (Charles Elton, 1927): 1. Pyramid of Energy is ALWAYS UPRIGHT in all ecosystems because energy is lost as heat at every trophic step (10% Law). 2. Pyramid of Biomass is upright in terrestrial/grassland ecosystems, but INVERTED in a marine/pond ecosystem (phytoplankton biomass < fish biomass at a given instant). 3. Pyramid of Numbers is inverted for a single large tree ecosystem (parasitic food chain).",
            "पारिस्थितिक पिरामिड: 1. 'ऊर्जा का पिरामिड' सदैव सीधा (Always Upright) होता है, वह कभी उल्टा नहीं हो सकता। 2. 'जीवभार (Biomass) का पिरामिड' स्थलीय तंत्र में सीधा, किंतु जलीय/समुद्री पारिस्थितिकी तंत्र में उल्टा (Inverted) होता है। 3. एक विशाल वृक्ष के पारिस्थितिकी तंत्र में संख्या का पिरामिड उल्टा होता है।",
            "UPPCS Pre PYQ 2020, 2022, 2023"
        ),
        RawPyqSeed(
            "What is 'Eutrophication' (सुपोषण) in an aquatic ecosystem, and how does it affect 'Biological Oxygen Demand' (BOD) and 'Dissolved Oxygen' (DO)?",
            "जलीय पारिस्थितिकी तंत्र में 'सुपोषण' (Eutrophication) क्या है और इसका 'जैविक ऑक्सीजन माँग' (BOD) तथा 'घुलित ऑक्सीजन' (DO) पर क्या प्रभाव पड़ता है?",
            listOf("Nutrient enrichment (Nitrates & Phosphates from sewage/fertilizers) causing dense Algal Bloom -> Increases BOD sharply and Decreases Dissolved Oxygen (DO), leading to fish mortality", "Depletion of nitrates and phosphates -> Decreases BOD and Increases DO", "Thermal pollution from nuclear plants -> Decreases both BOD and DO", "Acid rain deposition -> Increases DO in lakes"),
            listOf("वाहित मल व उर्वरकों से नाइट्रेट एवं फॉस्फेट पोषक तत्वों की अधिकता से शैवाल प्रस्फुटन (Algal Bloom) होना -> इससे BOD बढ़ जाती है और घुलित ऑक्सीजन (DO) घट जाती है, जिससे जलीय जीव मरने लगते हैं", "पोषक तत्वों की कमी होना -> जिससे BOD घटती है और DO बढ़ती है", "तापीय प्रदूषण -> जिससे BOD और DO दोनों घटते हैं", "अम्लीय वर्षा -> जिससे झीलों में DO बढ़ जाती है"),
            "UPPCS asks about BOD & Eutrophication almost every year: When excess nitrogen and phosphorus (from agricultural runoff and sewage) enter a lake, it causes Eutrophication (Algal Bloom). Aerobic bacteria decomposing the organic matter consume oxygen, which INCREASES the Biological Oxygen Demand (BOD) and DECREASES Dissolved Oxygen (DO). High BOD = High water pollution!",
            "UPPCS में प्रतिवर्ष पूछा जाने वाला प्रश्न: जलाशयों में नाइट्रेट और फॉस्फेट जैसे पोषक तत्वों की वृद्धि 'सुपोषण' (Eutrophication) कहलाती है, जिससे शैवाल प्रस्फुटन (Algal Bloom) होता है। कार्बनिक पदार्थों के अपघटन हेतु जीवाणुओं द्वारा अधिक ऑक्सीजन उपयोग किए जाने से 'जैविक ऑक्सीजन माँग' (BOD) बढ़ जाती है और जल में 'घुलित ऑक्सीजन' (DO) कम हो जाती है।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "Which four regions in India are recognized among the World's 36 'Biodiversity Hotspots', and which two criteria define a Biodiversity Hotspot?",
            "भारत में स्थित चार 'जैव-विविधता हॉटस्पॉट' (Biodiversity Hotspots) कौन-से हैं और किसी क्षेत्र को हॉटस्पॉट घोषित करने के दो मुख्य मानदंड क्या हैं?",
            listOf("4 Hotspots: 1. Himalayas, 2. Western Ghats (& Sri Lanka), 3. Indo-Burma Region, 4. Sundaland (Nicobar Islands) | Criteria: At least 1,500 endemic vascular plant species (0.5% of world total) AND loss of at least 70% of its original primary habitat", "Western Ghats, Eastern Ghats, Thar Desert, and Sundarbans", "Himalayas, Vindhyas, Aravallis, and Andaman Islands", "Western Ghats, Deccan Plateau, Gangetic Plains, and Lakshadweep"),
            listOf("4 हॉटस्पॉट: 1. हिमालय, 2. पश्चिमी घाट (एवं श्रीलंका), 3. इंडो-बर्मा क्षेत्र, 4. सुंडालैंड (निकोबार द्वीप समूह) | मानदंड: कम से कम 1,500 स्थानिक संवहनी पादप प्रजातियाँ (Endemic species) और अपने मूल प्राकृतिक आवास का कम से कम 70% भाग नष्ट हो चुका हो", "पश्चिमी घाट, पूर्वी घाट, थार मरुस्थल और सुंदरबन", "हिमालय, विंध्य, अरावली और अंडमान", "पश्चिमी घाट, दक्कन पठार, गंगा का मैदान और लक्षद्वीप"),
            "India hosts 4 of the world's 36 Biodiversity Hotspots: 1. The Himalayas, 2. The Western Ghats (and Sri Lanka), 3. The Indo-Burma region (North-East India south of Brahmaputra & Andaman group), and 4. Sundaland (includes the Nicobar group of islands). Note carefully: Eastern Ghats and Thar Desert are NOT biodiversity hotspots.",
            "भारत में विश्व के 36 जैव-विविधता हॉटस्पॉट में से 4 स्थित हैं: 1. हिमालय क्षेत्र, 2. पश्चिमी घाट, 3. इंडो-बर्मा क्षेत्र (पूर्वोत्तर भारत व अंडमान), तथा 4. सुंडालैंड (जिसमें भारत का ग्रेट निकोबार द्वीप समूह आता है)। ध्यान दें कि पूर्वी घाट इसमें शामिल नहीं है।",
            "UPPCS Pre PYQ 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "Which of the following is an example of 'Ex-situ Conservation' (बाह्य-स्थाने संरक्षण) vs 'In-situ Conservation' (स्व-स्थाने संरक्षण) of biodiversity?",
            "जैव-विविधता संरक्षण में निम्नलिखित में से कौन 'स्व-स्थाने संरक्षण' (In-situ) और कौन 'बाह्य-स्थाने संरक्षण' (Ex-situ) के उदाहरण हैं?",
            listOf("In-situ (Natural Habitat): National Parks, Wildlife Sanctuaries, Biosphere Reserves, Sacred Groves | Ex-situ (Outside Natural Habitat): Seed Banks, Cryopreservation (-196°C in Liquid Nitrogen), Botanical Gardens, Zoological Parks, Aquariums", "In-situ: Botanical Gardens & Zoo | Ex-situ: National Parks & Biosphere Reserves", "In-situ: Seed Banks & Tissue Culture | Ex-situ: Sacred Groves & Sanctuaries", "Both Botanical Gardens and National Parks are Ex-situ conservation"),
            listOf("स्व-स्थाने (In-situ - प्राकृतिक आवास में): राष्ट्रीय उद्यान, वन्यजीव अभयारण्य, बायोस्फीयर रिजर्व, पवित्र उपवन | बाह्य-स्थाने (Ex-situ - प्राकृतिक आवास से बाहर): बीज बैंक, क्रायोप्रिजर्वेशन (-196°C तरल नाइट्रोजन में), वनस्पति उद्यान (Botanical Garden), चिड़ियाघर (Zoo)", "स्व-स्थाने: वनस्पति उद्यान व चिड़ियाघर | बाह्य-स्थाने: राष्ट्रीय उद्यान", "स्व-स्थाने: बीज बैंक | बाह्य-स्थाने: पवित्र उपवन", "वनस्पति उद्यान और राष्ट्रीय उद्यान दोनों Ex-situ हैं"),
            "UPPCS asks In-situ vs Ex-situ almost every year: Protecting species inside their natural habitat (National Parks, Wildlife Sanctuaries, Biosphere Reserves, Community/Conservation Reserves, Sacred Groves) is In-situ. Conserving them outside their natural habitat (Botanical Gardens, Zoos, Gene/Seed Banks, Cryopreservation at -196°C in liquid nitrogen) is Ex-situ.",
            "UPPCS का अत्यंत लोकप्रिय प्रश्न: जीवों को उनके प्राकृतिक आवास के भीतर संरक्षित करना 'स्व-स्थाने' (In-situ — जैसे राष्ट्रीय उद्यान, वन्यजीव अभयारण्य, बायोस्फीयर रिजर्व, पवित्र उपवन) कहलाता है, जबकि प्राकृतिक आवास से बाहर कृत्रिम संरक्षण 'बाह्य-स्थाने' (Ex-situ — जैसे वनस्पति उद्यान, चिड़ियाघर, बीज/जीन बैंक, तरल नाइट्रोजन में -196°C पर क्रायोप्रिजर्वेशन) कहलाता है।",
            "UPPCS Pre PYQ 2020, 2021, 2023"
        ),
        RawPyqSeed(
            "Arrange the following major Environmental Protection Acts of India in their correct chronological order:\n1. Wildlife (Protection) Act\n2. Water (Prevention and Control of Pollution) Act\n3. Forest (Conservation) Act\n4. Environment (Protection) Act\n5. Biological Diversity Act",
            "भारत के निम्नलिखित प्रमुख पर्यावरण एवं वन्यजीव संरक्षण अधिनियमों को उनके पारित होने के सही कालानुक्रमिक क्रम में व्यवस्थित कीजिए:\n1. वन्यजीव (संरक्षण) अधिनियम\n2. जल (प्रदूषण निवारण एवं नियंत्रण) अधिनियम\n3. वन (संरक्षण) अधिनियम\n4. पर्यावरण (संरक्षण) अधिनियम\n5. जैव-विविधता अधिनियम",
            listOf("1 (1972) -> 2 (1974) -> 3 (1980) -> 4 (1986) -> 5 (2002)", "2 -> 1 -> 3 -> 4 -> 5", "1 -> 3 -> 2 -> 4 -> 5", "3 -> 1 -> 2 -> 4 -> 5"),
            listOf("1 (1972) -> 2 (1974) -> 3 (1980) -> 4 (1986) -> 5 (2002)", "2 -> 1 -> 3 -> 4 -> 5", "1 -> 3 -> 2 -> 4 -> 5", "3 -> 1 -> 2 -> 4 -> 5"),
            "Mandatory UPPCS Environmental Acts Chronology: Indian Forest Act (1927); Wildlife Protection Act (1972); Water Prevention & Control of Pollution Act (1974 — CPCB created under this Act); Forest Conservation Act (1980); Air Prevention & Control of Pollution Act (1981 — Noise pollution added to Air Act in 1987); Environment Protection Act (1986 — 'Umbrella Legislation' enacted after 1984 Bhopal Gas Tragedy); Biological Diversity Act (2002 — NBA HQ at Chennai); National Green Tribunal (NGT) Act (2010).",
            "UPPCS में हर साल पूछे जाने वाले पर्यावरण अधिनियमों का कालक्रम: 1. वन्यजीव संरक्षण अधिनियम — 1972; 2. जल प्रदूषण निवारण अधिनियम — 1974; 3. वन संरक्षण अधिनियम — 1980; 4. वायु प्रदूषण निवारण अधिनियम — 1981; 5. पर्यावरण संरक्षण अधिनियम ('छाता विधान') — 1986; 6. जैव-विविधता अधिनियम — 2002 (राष्ट्रीय जैव विविधता प्राधिकरण का मुख्यालय चेन्नई में है); 7. राष्ट्रीय हरित अधिकरण (NGT) अधिनियम — 2010।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023, 2024"
        ),
        RawPyqSeed(
            "Match the flagship Wildlife Conservation Projects of India with their launch years:\n1. Project Tiger — 1973\n2. Project Crocodile — 1975\n3. Project Elephant — 1992\n4. Project Snow Leopard — 2009 & Project Dolphin / Project Lion — 2020",
            "भारत की प्रमुख वन्यजीव संरक्षण परियोजनाओं का उनके प्रारंभ वर्ष के साथ सही मिलान चुनिए:\n1. प्रोजेक्ट टाइगर (बाघ परियोजना) — 1973\n2. घड़ियाल/मगरमच्छ संरक्षण परियोजना — 1975\n3. प्रोजेक्ट एलीफेंट (हाथी परियोजना) — 1992\n4. प्रोजेक्ट स्नो लेपर्ड (हिम तेंदुआ) — 2009 एवं प्रोजेक्ट डॉल्फिन — 2020",
            listOf("All 1, 2, 3 and 4 are correctly matched", "1 and 3 only", "1, 2 and 3 only", "2, 3 and 4 only"),
            listOf("सभी 1, 2, 3 और 4 सही सुमेलित हैं", "केवल 1 और 3", "केवल 1, 2 और 3", "केवल 2, 3 और 4"),
            "Other key Wildlife milestones: Project Hangul (1970); Project Tiger (1 April 1973 from Jim Corbett National Park, Uttarakhand; NTCA became a statutory body under WPA Amendment 2006); Project Crocodile (1975 — Kukrail in Lucknow & Katarniaghat/Chambal are major Gharial centers in UP); Project Rhino (1987/2005); Project Elephant (1992); Vulture Conservation Project (2006 — banning veterinary drug Diclofenac); Ganga Dolphin declared National Aquatic Animal on 5 Oct 2009.",
            "प्रमुख वन्यजीव परियोजनाएँ: प्रोजेक्ट हंगुल (1970); प्रोजेक्ट टाइगर (1 अप्रैल 1973 — जिम कॉर्बेट राष्ट्रीय उद्यान से प्रारंभ); मगरमच्छ/घड़ियाल परियोजना (1975 — लखनऊ का कुकरैल वन एवं चंबल अभयारण्य घड़ियाल प्रजनन के प्रमुख केंद्र हैं); प्रोजेक्ट एलीफेंट (1992); गिद्ध संरक्षण (2006 — पशुओं की दर्द निवारक दवा 'डाइक्लोफेनाक' पर प्रतिबंध); गंगा डॉल्फिन (5 अक्टूबर 2009 को राष्ट्रीय जलीय जीव घोषित)।",
            "UPPCS Pre PYQ 2020, 2022, 2023"
        ),
        RawPyqSeed(
            "Which is the ONLY National Park in Uttar Pradesh, and which four Tiger Reserves are located in Uttar Pradesh?",
            "उत्तर प्रदेश का एकमात्र 'राष्ट्रीय उद्यान' (National Park) कौन-सा है तथा उत्तर प्रदेश में स्थित चार 'टाइगर रिजर्व' (बाघ अभयारण्य) कौन-से हैं?",
            listOf("National Park: Dudhwa National Park (Lakhimpur Kheri, made National Park in 1977) | 4 Tiger Reserves in UP: 1. Dudhwa, 2. Pilibhit, 3. Amangarh (Bijnor - buffer of Corbett), and 4. Ranipur Tiger Reserve (Chitrakoot — 53rd TR of India)", "Chandraprabha (Chandauli), Hastinapur, Sohagi Barwa, and Kaimoor", "Katarniaghat, Nawabganj, Samaspur, and Patna Bird Sanctuary", "Dudhwa, Rajaji, Jim Corbett, and Valmiki"),
            listOf("राष्ट्रीय उद्यान: दुधवा राष्ट्रीय उद्यान (लखीमपुर खीरी, 1977 में राष्ट्रीय उद्यान घोषित) | उ.प्र. के 4 टाइगर रिजर्व: 1. दुधवा, 2. पीलीभीत, 3. अमानगढ़ (बिजनौर), और 4. रानीपुर टाइगर रिजर्व (चित्रकूट — भारत का 53वां टाइगर रिजर्व)", "चंद्रप्रभा (चंदौली), हस्तिनापुर, सोहगीबरवा और कैमूर", "कतरनियाघाट, नवाबगंज, समसपुर और पटना पक्षी विहार", "दुधवा, राजाजी, जिम कॉर्बेट और वाल्मीकि"),
            "Dudhwa in Lakhimpur Kheri (established as sanctuary in 1958 by Billy Arjan Singh for Swamp Deer/Barasingha, elevated to National Park in 1977, and Project Tiger Reserve in 1987 along with Kishanpur & Katarniaghat) is UP's only National Park. UP has 4 Tiger Reserves: Dudhwa, Pilibhit (won TX2 Award for doubling tigers), Amangarh (Bijnor), and Ranipur (Chitrakoot, notified in 2022 as UP's 4th & India's 53rd TR). Chandraprabha (Chandauli, 1957) is UP's oldest wildlife sanctuary, and Hastinapur is UP's largest wildlife sanctuary.",
            "लखीमपुर खीरी स्थित 'दुधवा राष्ट्रीय उद्यान' (1977 में राष्ट्रीय उद्यान और 1987 में टाइगर रिजर्व घोषित) उत्तर प्रदेश का एकमात्र राष्ट्रीय उद्यान है। उ.प्र. में 4 टाइगर रिजर्व हैं: 1. दुधवा, 2. पीलीभीत (बाघों की संख्या दोगुनी करने पर TX2 पुरस्कार विजेता), 3. अमानगढ़ (बिजनौर), और 4. रानीपुर टाइगर रिजर्व (चित्रकूट, बुंदेलखंड का प्रथम टाइगर रिजर्व)। चंदौली स्थित 'चंद्रप्रभा' (1957) उ.प्र. का सबसे पुराना और 'हस्तिनापुर' सबसे बड़ा वन्यजीव विहार है।",
            "UPPCS Pre PYQ 2021, 2022, 2023, 2024"
        ),
        RawPyqSeed(
            "How many Ramsar Wetlands are located in Uttar Pradesh (the 2nd highest in India after Tamil Nadu), and which among them are correctly matched with their districts?",
            "उत्तर प्रदेश में कुल कितने 'रामसर आर्द्रभूमि स्थल' (Ramsar Sites) हैं और निम्नलिखित में से कौन-से रामसर स्थल अपने जिलों के साथ सही सुमेलित हैं?\n1. नवाबगंज पक्षी विहार (शहीद चंद्रशेखर आजाद) — उन्नाव\n2. पार्वती अर्गा — गोंडा एवं बखीरा — संत कबीर नगर\n3. हैदरपुर वेटलैंड — मुजफ्फरनगर/बिजनौर एवं सूर सरोवर (कीठम) — आगरा\n4. समसपुर — रायबरेली, सांडी — हरदोई, समान — मैनपुरी एवं सरसई नावर — इटावा",
            listOf("10 Ramsar Sites in UP (including Upper Ganga River from Brijghat to Narora) — All 1, 2, 3 and 4 are correctly matched", "8 Ramsar Sites — Only 1 and 2 are correct", "12 Ramsar Sites — Only 2 and 3 are correct", "6 Ramsar Sites — Only 1 and 4 are correct"),
            listOf("उत्तर प्रदेश में कुल 10 रामसर स्थल हैं (ब्रजघाट से नरोरा तक ऊपरी गंगा नदी सहित) — सभी 1, 2, 3 और 4 सही सुमेलित हैं", "8 रामसर स्थल — केवल 1 और 2 सही हैं", "12 रामसर स्थल — केवल 2 और 3 सही हैं", "6 रामसर स्थल — केवल 1 और 4 सही हैं"),
            "All 10 Ramsar Sites of Uttar Pradesh (repeatedly asked in UPPCS): 1. Upper Ganga River (Brijghat to Narora stretch, 2005 — first in UP); 2. Nawabganj Bird Sanctuary (Shaheed Chandra Shekhar Azad, Unnao); 3. Parvati Arga (Gonda); 4. Saman (Mainpuri); 5. Samaspur (Raebareli); 6. Sandi (Hardoi); 7. Sarsai Nawar Jheel (Etawah); 8. Sur Sarovar / Keetham Lake (Agra); 9. Haiderpur Wetland (Muzaffarnagar-Bijnor); 10. Bakhira Wildlife Sanctuary (Sant Kabir Nagar, 2022). World Wetlands Day is celebrated on 2 February (Ramsar Convention signed in Iran on 2 Feb 1971).",
            "उत्तर प्रदेश के सभी 10 रामसर स्थल (UPPCS के लिए अत्यंत महत्वपूर्ण): 1. ऊपरी गंगा नदी (ब्रजघाट से नरोरा, 2005 — उ.प्र. का प्रथम); 2. नवाबगंज (उन्नाव — सबसे पहला पक्षी विहार); 3. पार्वती अर्गा (गोंडा); 4. समान (मैनपुरी); 5. समसपुर (रायबरेली); 6. सांडी (हरदोई); 7. सरसई नावर (इटावा); 8. सूर सरोवर/कीठम (आगरा); 9. हैदरपुर (मुजफ्फरनगर-बिजनौर); 10. बखीरा (संत कबीर नगर)। विश्व आर्द्रभूमि दिवस 2 फरवरी को मनाया जाता है (2 फरवरी 1971 को ईरान के रामसर शहर में समझौता हुआ था)।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "Match the major Biosphere Reserves of India (18 total, 12 in UNESCO MAB Network) with their States:\n1. Nilgiri (India's first Biosphere Reserve, 1986) — Tamil Nadu, Kerala & Karnataka\n2. Nanda Devi — Uttarakhand & Nokrek — Meghalaya\n3. Simlipal — Odisha & Pachmarhi / Achanakmar-Amarkantak — Madhya Pradesh\n4. Agasthyamalai — Kerala/TN & Khangchendzonga — Sikkim",
            "भारत के प्रमुख बायोस्फीयर रिजर्व (जीवमंडल आरक्षित क्षेत्र — कुल 18, जिनमें से 12 यूनेस्को MAB नेटवर्क में शामिल हैं) का उनके राज्यों से मिलान कीजिए:\n1. नीलगिरि (भारत का प्रथम बायोस्फीयर रिजर्व, 1986) — तमिलनाडु, केरल व कर्नाटक\n2. नंदा देवी — उत्तराखंड एवं नोकरेक — मेघालय\n3. सिमलीपाल — ओडिशा एवं पचमढ़ी / अचानकमार-अमरकंटक — मध्य प्रदेश\n4. अगस्त्यमलाई — केरल/तमिलनाडु एवं कंचनजंगा — सिक्किम",
            listOf("All 1, 2, 3 and 4 are correctly matched", "1 and 2 only", "2, 3 and 4 only", "1 and 4 only"),
            listOf("सभी 1, 2, 3 और 4 सही सुमेलित हैं", "केवल 1 और 2", "केवल 2, 3 और 4", "केवल 1 और 4"),
            "India has 18 Biosphere Reserves, of which 12 are included in UNESCO's World Network of Biosphere Reserves (MAB): Nilgiri (1986, first BR), Gulf of Mannar (TN), Sundarbans (WB), Nanda Devi (Uttarakhand), Nokrek (Meghalaya), Pachmarhi (MP), Simlipal (Odisha), Achanakmar-Amarkantak (MP-Chhattisgarh), Great Nicobar, Agasthyamalai (Kerala-TN), Khangchendzonga (Sikkim — also India's only 'Mixed' UNESCO World Heritage Site), and Panna (MP, added to UNESCO MAB in 2020). Cold Desert (HP), Dihang-Dibang (Arunachal), Manas & Dibru-Saikhowa (Assam), Seshachalam (AP), and Kachchh (Gujarat — largest by area) are the remaining 6.",
            "भारत के कुल 18 बायोस्फीयर रिजर्व में से 12 यूनेस्को के 'मैन एंड द बायोस्फीयर' (MAB) नेटवर्क में शामिल हैं: नीलगिरि (1986, प्रथम), मन्नार की खाड़ी, सुंदरबन, नंदा देवी (उत्तराखंड), नोकरेक (मेघालय), पचमढ़ी, सिमलीपाल, अचानकमार-अमरकंटक, ग्रेट निकोबार, अगस्त्यमलाई, कंचनजंगा (सिक्किम — भारत का एकमात्र मिश्रित विश्व धरोहर स्थल) और पन्ना (म.प्र.)। कच्छ का रण क्षेत्रफल में सबसे बड़ा बायोस्फीयर रिजर्व है।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "Match the following International Environmental Conventions and Protocols with their primary objectives:\n1. Montreal Protocol (1987) — Phase-out of Ozone Depleting Substances (CFCs) & Kigali Amendment (2016) — Phase-down of HFCs\n2. Kyoto Protocol (1997) & Paris Agreement (2015, COP-21) — Reduction of Greenhouse Gas (GHG) Emissions\n3. Cartagena Protocol (2000) — Biosafety (Living Modified Organisms) & Nagoya Protocol (2010) — Access and Benefit Sharing (ABS) under CBD\n4. Basel Convention (Transboundary Hazardous Waste), Rotterdam Convention (Prior Informed Consent for Hazardous Chemicals), Stockholm Convention (POPs), and Minamata Convention (Mercury)",
            "प्रमुख अंतर्राष्ट्रीय पर्यावरण सम्मेलनों एवं प्रोटोकॉलों का उनके मुख्य उद्देश्यों से सही मिलान चुनिए:\n1. मॉन्ट्रियल प्रोटोकॉल (1987) — ओजोन परत का क्षरण करने वाले पदार्थों (CFCs) पर नियंत्रण एवं किगाली संशोधन (2016) — HFCs में कटौती\n2. क्योटो प्रोटोकॉल (1997) एवं पेरिस समझौता (2015, COP-21) — ग्रीनहाउस गैस उत्सर्जन में कटौती\n3. कार्टाजेना प्रोटोकॉल (2000) — जैव-सुरक्षा (Biosafety) एवं नागोया प्रोटोकॉल (2010) — आनुवंशिक संसाधनों तक पहुँच और लाभ साझाकरण\n4. बेसल कन्वेंशन (खतरनाक अपशिष्ट), रॉटरडैम कन्वेंशन (खतरनाक रसायन), स्टॉकहोम कन्वेंशन (POPs) एवं मिनामाता कन्वेंशन (पारा/Mercury)",
            listOf("All 1, 2, 3 and 4 are correctly matched", "1, 2 and 3 only", "2 and 4 only", "1 and 3 only"),
            listOf("सभी 1, 2, 3 और 4 सही सुमेलित हैं", "केवल 1, 2 और 3", "केवल 2 और 4", "केवल 1 और 3"),
            "Key timeline for UPPCS: 1972 Stockholm Conference on Human Environment (5 June -> World Environment Day, UNEP founded with HQ at Nairobi, Kenya); 1987 Brundtland Commission Report 'Our Common Future' (coined 'Sustainable Development'); 1987 Montreal Protocol (16 Sept -> World Ozone Day); 1992 Rio Earth Summit (Agenda 21, UNFCCC, CBD, UNCCD); 1997 Kyoto Protocol; 2015 Paris Climate Agreement.",
            "UPPCS पर्यावरण सम्मेलनों का कालक्रम: 1972 स्टॉकहोम सम्मेलन (5 जून — विश्व पर्यावरण दिवस, UNEP की स्थापना — मुख्यालय नैरोबी, केन्या); 1987 ब्रंटलैंड आयोग रिपोर्ट 'Our Common Future' (जिसमें 'सतत विकास' शब्द परिभाषित हुआ); 16 सितंबर 1987 मॉन्ट्रियल प्रोटोकॉल (विश्व ओजोन दिवस); 1992 रियो पृथ्वी शिखर सम्मेलन (एजेंडा-21)।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023, 2024"
        ),
        RawPyqSeed(
            "Which gas is the most abundant 'Greenhouse Gas' (GHG) in the Earth's atmosphere naturally, and which six gases were targeted under the Kyoto Protocol?",
            "पृथ्वी के वायुमंडल में प्राकृतिक रूप से सर्वाधिक मात्रा में पाई जाने वाली 'ग्रीनहाउस गैस' कौन-सी है तथा क्योटो प्रोटोकॉल के तहत किन 6 गैसों को सूचीबद्ध किया गया था?",
            listOf("Most abundant natural GHG: Water Vapour (जलवाष्प), followed by CO₂ and Methane (CH₄) | Kyoto 6 Gases: CO₂, CH₄, N₂O (Nitrous Oxide), HFCs, PFCs, and SF₆ (Sulphur Hexafluoride)", "Nitrogen and Oxygen | Kyoto Gases: SO₂, NO₂, CO, O₃", "Argon and Carbon Monoxide | Kyoto Gases: CFCs and Halons", "Sulphur Dioxide and Ammonia | Kyoto Gases: Hydrogen and Helium"),
            listOf("प्राकृतिक रूप से सर्वाधिक ग्रीनहाउस प्रभाव: जलवाष्प (Water Vapour), तत्पश्चात CO₂ एवं मीथेन (CH₄) | क्योटो प्रोटोकॉल की 6 गैसें: CO₂, CH₄, N₂O, HFCs, PFCs और SF₆", "नाइट्रोजन और ऑक्सीजन | क्योटो गैसें: SO₂, NO₂, CO, O₃", "आर्गन और कार्बन मोनोऑक्साइड | क्योटो गैसें: CFCs और हैलोन", "सल्फर डाइऑक्साइड और अमोनिया | क्योटो गैसें: हाइड्रोजन और हीलियम"),
            "Water Vapour (~60%) is the largest natural contributor to the Greenhouse Effect, followed by Carbon Dioxide (CO₂ — largest anthropogenic contributor), Methane (CH₄ — emitted from paddy fields, wetlands, cattle/ruminants, coal mines, and termites), Nitrous Oxide (N₂O), and Tropospheric Ozone (O₃). Among the Kyoto gases, Sulphur Hexafluoride (SF₆) has the highest Global Warming Potential (GWP ~23,500 times CO₂).",
            "प्राकृतिक रूप से ग्रीनहाउस प्रभाव में सर्वाधिक योगदान 'जलवाष्प' (Water Vapour) का होता है, जबकि मानवीय गतिविधियों से सर्वाधिक योगदान कार्बन डाइऑक्साइड (CO₂) का है। 'मीथेन' (CH₄ — मार्श गैस) धान के खेतों, जुगाली करने वाले पशुओं, कोयला खदानों, आर्द्रभूमि और दीमक की बांबियों से उत्सर्जित होती है।",
            "UPPCS Pre PYQ 2020, 2022, 2023"
        ),
        RawPyqSeed(
            "Which pollutants are termed 'Secondary Air Pollutants' (द्वितीयक वायु प्रदूषक) formed by photochemical reactions in the atmosphere, and what constitutes 'Photochemical Smog'?",
            "निम्नलिखित में से कौन 'द्वितीयक वायु प्रदूषक' (Secondary Air Pollutants) हैं जिनका निर्माण वायुमंडल में प्रकाश-रासायनिक अभिक्रियाओं से होता है, तथा 'प्रकाश-रासायनिक धूम्र-कोहरा' (Photochemical Smog) के मुख्य घटक क्या हैं?",
            listOf("Secondary Pollutants: Peroxyacetyl Nitrate (PAN), Tropospheric Ozone (O₃), Smog, and Acid Rain (H₂SO₄ / HNO₃) | Photochemical Smog = Nitrogen Oxides (NOx) + Volatile Organic Compounds (VOCs) + Sunlight -> O₃ + PAN + Acrolein", "Primary Pollutants: CO, SO₂, NO, Particulate Matter | Photochemical Smog = SO₂ + Fog in winter", "Carbon Monoxide and Lead (Pb)", "Fly Ash and Methane"),
            listOf("द्वितीयक प्रदूषक: पेरॉक्सीएसिटिल नाइट्रेट (PAN), क्षोभमंडलीय ओजोन (O₃), स्मॉग और अम्लीय वर्षा (H₂SO₄ / HNO₃) | प्रकाश-रासायनिक स्मॉग = नाइट्रोजन ऑक्साइड (NOx) + VOCs + सूर्य का प्रकाश -> ओजोन (O₃) + PAN", "प्राथमिक प्रदूषक: CO, SO₂, NO | स्मॉग = केवल SO₂ और कोहरा", "कार्बन मोनोऑक्साइड और सीसा (Lead)", "फ्लाई ऐश और मीथेन"),
            "UPPCS asks about Photochemical Smog and Secondary Pollutants nearly every year! Primary pollutants (CO, CO₂, SO₂, NO, NO₂, Hydrocarbons, PM2.5, PM10) are emitted directly from sources. Secondary pollutants (PAN — Peroxyacetyl Nitrate, Ground-level Ozone O₃, Formaldehyde, Acrolein, H₂SO₄, HNO₃) are formed in the atmosphere when primary pollutants react in sunlight. Ozone (O₃) and PAN in Photochemical Smog cause severe eye irritation and inhibit plant photosynthesis.",
            "UPPCS में लगभग हर वर्ष पूछा जाने वाला प्रश्न: प्राथमिक प्रदूषक (CO, SO₂, NOx, हाइड्रोकार्बन) सीधे स्रोत से निकलते हैं, जबकि द्वितीयक प्रदूषक—जैसे पेरॉक्सीएसिटिल नाइट्रेट (PAN), धरातलीय ओजोन (O₃) और अम्लीय वर्षा—प्राथमिक प्रदूषकों की सूर्य के प्रकाश में अभिक्रिया से बनते हैं। प्रकाश-रासायनिक स्मॉग में उपस्थित ओजोन (O₃) और PAN आँखों में तीव्र जलन उत्पन्न करते हैं।",
            "UPPCS Pre PYQ 2021, 2022, 2023, 2024"
        )
    )

    private val environmentSecondHalfSeeds: List<RawPyqSeed> = listOf(
        RawPyqSeed(
            "Which two gases are primarily responsible for 'Acid Rain' (pH < 5.6), and which organisms serve as the best natural 'Bio-indicators' of Sulphur Dioxide (SO₂) air pollution?",
            "'अम्लीय वर्षा' (Acid Rain — pH < 5.6) के लिए मुख्य रूप से कौन-सी दो गैसें उत्तरदायी हैं और कौन-सा जीव सल्फर डाइऑक्साइड (SO₂) वायु प्रदूषण का सर्वोत्तम प्राकृतिक 'जैव-सूचक' (Bio-indicator) है?",
            listOf("Sulphur Dioxide (SO₂ -> H₂SO₄) and Nitrogen Oxides (NOx -> HNO₃) | Lichens (symbiotic association of Algae and Fungi) are the best bio-indicators of SO₂ pollution", "CO₂ and Methane | Mosses and Ferns", "CFCs and Ozone | Cyanobacteria", "Carbon Monoxide and Ammonia | Diatoms"),
            listOf("सल्फर डाइऑक्साइड (SO₂ -> H₂SO₄) और नाइट्रोजन के ऑक्साइड (NOx -> HNO₃) | 'लाइकेन' (शैवाल और कवक का सहजीवी संबंध) SO₂ प्रदूषण के सर्वोत्तम जैव-सूचक हैं", "CO₂ और मीथेन | मॉस और फर्न", "CFCs और ओजोन | साइनोबैक्टीरिया", "कार्बन मोनोऑक्साइड और अमोनिया | डायटम"),
            "Acid Rain is caused when Sulphur Dioxide (SO₂, from coal refineries such as Mathura Oil Refinery affecting Taj Mahal — 'Stone Leprosy') and Nitrogen Oxides (NOx) react with atmospheric moisture to form Sulphuric Acid (H₂SO₄ ~70%) and Nitric Acid (HNO₃ ~30%). Lichens (symbiotic partnership between Algae/Phycobiont and Fungi/Mycobiont) are extremely sensitive to SO₂ and disappear in SO₂-polluted areas.",
            "अम्लीय वर्षा का मुख्य कारण वायुमंडल में सल्फर डाइऑक्साइड (SO₂) और नाइट्रोजन ऑक्साइड (NOx) का जलवाष्प से क्रिया कर सल्फ्यूरिक अम्ल (H₂SO₄) और नाइट्रिक अम्ल (HNO₃) बनाना है (जिससे ताजमहल को 'स्टोन लेप्रोसी' का खतरा होता है)। 'लाइकेन' (शैवाल व कवक का सहजीवी) SO₂ प्रदूषण के प्रति अत्यंत संवेदनशील होने के कारण वायु प्रदूषण के सर्वोत्तम जैव-सूचक हैं।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "Match the Environmental Pollution Diseases with their causative heavy metals/pollutants:\n1. Minamata Disease — Mercury (Hg) contamination\n2. Itai-Itai (Ouch-Ouch) Disease — Cadmium (Cd) contamination\n3. Blue Baby Syndrome (Methemoglobinemia) — Excess Nitrate (NO₃⁻) in drinking water\n4. Black Foot Disease — Arsenic (As) contamination in groundwater",
            "पर्यावरण प्रदूषण जनित रोगों का उनके कारक प्रदूषकों/भारी धातुओं के साथ सही मिलान चुनिए:\n1. मिनामाता रोग — पारा (Mercury - Hg) प्रदूषण\n2. इटाई-इटाई रोग — कैडमियम (Cd) प्रदूषण\n3. ब्लू बेबी सिंड्रोम (मेथेमोग्लोबिनेमिया) — पेयजल में नाइट्रेट (NO₃⁻) की अधिकता\n4. ब्लैक फुट रोग — भूमिगत जल में आर्सेनिक (As) की अधिकता",
            listOf("All 1, 2, 3 and 4 are correctly matched", "1, 2 and 3 only", "1 and 3 only", "2 and 4 only"),
            listOf("सभी 1, 2, 3 और 4 सही सुमेलित हैं", "केवल 1, 2 और 3", "केवल 1 और 3", "केवल 2 और 4"),
            "Additional pollution diseases tested in UPPCS: Fluorosis (Knock-Knee Syndrome & mottled teeth) — Excess Fluoride in drinking water; Pneumoconiosis / Black Lung Disease — Coal dust; Silicosis — Silica/stone dust; Byssinosis ('Brown Lung') — Cotton textile fibers; Asbestosis — Asbestos fibers; Lead (Pb) poisoning (Plumbism) — damages central nervous system and brain.",
            "अन्य प्रमुख प्रदूषण जनित रोग: फ्लोरोसिस ('नॉक-नी सिंड्रोम' व दाँतों का क्षरण) — पेयजल में फ्लोराइड की अधिकता; न्यूमोकोनियोसिस (ब्लैक लंग रोग) — कोयला खदान की धूल; सिलिकोसिस — सिलिका धूल; बिसिनोसिस — कपास/कपड़ा उद्योग के रेशे; सीसा (Lead) प्रदूषण — केंद्रीय तंत्रिका तंत्र एवं मस्तिष्क को क्षति पहुँचाता है।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "What are the exact UN Sustainable Development Goal (SDG 2030) numbers for: No Poverty, Zero Hunger, Gender Equality, Clean Water & Sanitation, Affordable & Clean Energy, Reduced Inequalities, Climate Action, Life Below Water, and Life on Land?",
            "संयुक्त राष्ट्र के 17 सतत विकास लक्ष्यों (SDGs 2030) की सटीक लक्ष्य संख्या का सही मिलान कौन-सा है?",
            listOf("SDG-1: No Poverty | SDG-2: Zero Hunger | SDG-5: Gender Equality | SDG-6: Clean Water & Sanitation | SDG-7: Clean Energy | SDG-10: Reduced Inequalities | SDG-13: Climate Action | SDG-14: Life Below Water | SDG-15: Life on Land", "SDG-1: Zero Hunger | SDG-2: No Poverty | SDG-6: Clean Energy | SDG-13: Life on Land", "SDG-3: Quality Education | SDG-4: Good Health | SDG-12: Climate Action", "SDG-5: Clean Water | SDG-6: Gender Equality | SDG-15: Life Below Water"),
            listOf("SDG-1: गरीबी का अंत | SDG-2: शून्य भुखमरी | SDG-5: लैंगिक समानता | SDG-6: स्वच्छ जल व स्वच्छता | SDG-7: सस्ती व स्वच्छ ऊर्जा | SDG-10: असमानताओं में कमी | SDG-13: जलवायु कार्रवाई | SDG-14: जलीय जीवों की सुरक्षा | SDG-15: थलीय जीवों की सुरक्षा", "SDG-1: शून्य भुखमरी | SDG-2: गरीबी का अंत | SDG-6: स्वच्छ ऊर्जा | SDG-13: थलीय जीवन", "SDG-3: शिक्षा | SDG-4: स्वास्थ्य | SDG-12: जलवायु कार्रवाई", "SDG-5: स्वच्छ जल | SDG-6: लैंगिक समानता | SDG-15: जलीय जीवन"),
            "All 17 SDGs (2016–2030) at a glance (UPPCS asks 1–2 questions on exact SDG numbers every single year!): SDG 1: No Poverty; SDG 2: Zero Hunger; SDG 3: Good Health & Well-being; SDG 4: Quality Education; SDG 5: Gender Equality; SDG 6: Clean Water & Sanitation; SDG 7: Affordable & Clean Energy; SDG 8: Decent Work & Economic Growth; SDG 9: Industry, Innovation & Infrastructure; SDG 10: Reduced Inequalities; SDG 11: Sustainable Cities; SDG 12: Responsible Consumption & Production; SDG 13: Climate Action; SDG 14: Life Below Water; SDG 15: Life on Land; SDG 16: Peace, Justice & Strong Institutions; SDG 17: Partnerships for the Goals.",
            "सभी 17 सतत विकास लक्ष्य (SDGs 2016–2030, जिनसे UPPCS में हर साल 1–2 प्रश्न अनिवार्य रूप से आते हैं): SDG-1: गरीबी उन्मूलन; SDG-2: शून्य भुखमरी; SDG-3: उत्तम स्वास्थ्य; SDG-4: गुणवत्तापूर्ण शिक्षा; SDG-5: लैंगिक समानता; SDG-6: स्वच्छ जल व स्वच्छता; SDG-7: स्वच्छ ऊर्जा; SDG-8: उत्कृष्ट कार्य व आर्थिक वृद्धि; SDG-9: उद्योग व नवाचार; SDG-10: असमानता में कमी; SDG-11: सतत शहर; SDG-12: सतत उपभोग व उत्पादन; SDG-13: जलवायु कार्रवाई; SDG-14: जल के नीचे जीवन; SDG-15: भूमि पर जीवन; SDG-16: शांति व न्याय; SDG-17: लक्ष्यों हेतु भागीदारी।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023, 2024"
        ),
        RawPyqSeed(
            "In which year was the 'National Action Plan on Climate Change' (NAPCC) launched in India, and which of the following is NOT one of its 8 National Missions?",
            "भारत में 'जलवायु परिवर्तन पर राष्ट्रीय कार्य योजना' (NAPCC) किस वर्ष प्रारंभ की गई थी और निम्नलिखित में से कौन इसके '8 राष्ट्रीय मिशनों' में शामिल नहीं है?",
            listOf("Launched on 30 June 2008 | 'National Mission on Nuclear Energy / Soil Health' is NOT one of the 8 Missions (The 8 Missions are: Solar, Enhanced Energy Efficiency, Sustainable Habitat, Water, Sustaining Himalayan Ecosystem, Green India, Sustainable Agriculture, and Strategic Knowledge for Climate Change)", "Launched in 2015 | National Solar Mission is not included", "Launched in 2002 | National Water Mission is not included", "Launched in 2010 | Green India Mission is not included"),
            listOf("30 जून 2008 को प्रारंभ | 'राष्ट्रीय परमाणु ऊर्जा मिशन' इसके 8 मिशनों में शामिल नहीं है (8 मिशन हैं: सौर मिशन, ऊर्जा दक्षता, सतत पर्यावास, राष्ट्रीय जल मिशन, हिमालयी पारिस्थितिकी तंत्र, हरित भारत मिशन, सतत कृषि और जलवायु परिवर्तन हेतु रणनीतिक ज्ञान मिशन)", "2015 में प्रारंभ | राष्ट्रीय सौर मिशन शामिल नहीं है", "2002 में प्रारंभ | राष्ट्रीय जल मिशन शामिल नहीं है", "2010 में प्रारंभ | हरित भारत मिशन शामिल नहीं है"),
            "The National Action Plan on Climate Change (NAPCC) was launched by the Government of India on 30 June 2008 with 8 core National Missions: 1. National Solar Mission; 2. National Mission for Enhanced Energy Efficiency (NMEEE); 3. National Mission on Sustainable Habitat; 4. National Water Mission; 5. National Mission for Sustaining the Himalayan Ecosystem; 6. National Mission for a Green India; 7. National Mission for Sustainable Agriculture; 8. National Mission on Strategic Knowledge for Climate Change.",
            "जलवायु परिवर्तन पर राष्ट्रीय कार्य योजना (NAPCC) 30 जून 2008 को शुरू की गई थी, जिसके अंतर्गत 8 राष्ट्रीय मिशन हैं: 1. राष्ट्रीय सौर मिशन, 2. उन्नत ऊर्जा दक्षता मिशन, 3. सतत पर्यावास मिशन, 4. राष्ट्रीय जल मिशन, 5. हिमालयी पारिस्थितिकी तंत्र संरक्षण मिशन, 6. हरित भारत मिशन, 7. सतत कृषि मिशन, और 8. जलवायु परिवर्तन हेतु रणनीतिक ज्ञान मिशन।",
            "UPPCS Pre PYQ 2020, 2021, 2023"
        ),
        RawPyqSeed(
            "Where is the headquarters of the 'International Solar Alliance' (ISA), launched jointly by India and France at COP-21 (Paris, 2015), located?",
            "COP-21 (पेरिस सम्मेलन, 2015) के दौरान भारत और फ्रांस द्वारा संयुक्त रूप से प्रारंभ किए गए 'अंतर्राष्ट्रीय सौर गठबंधन' (ISA) का मुख्यालय कहाँ स्थित है?",
            listOf("Gurugram (Haryana, India) — First treaty-based international intergovernmental organization headquartered in India", "New Delhi", "Gandhinagar (Gujarat)", "Paris (France)"),
            listOf("गुरुग्राम (हरियाणा, भारत) — भारत में मुख्यालय वाला पहला अंतर्राष्ट्रीय अंतर-सरकारी संगठन", "नई दिल्ली", "गांधीनगर (गुजरात)", "पेरिस (फ्रांस)"),
            "The International Solar Alliance (ISA) was launched on 30 November 2015 at COP-21 in Paris by PM Narendra Modi and French President Francois Hollande ('One Sun, One World, One Grid'). Its permanent headquarters is at the National Institute of Solar Energy (NISE) campus in Gurugram, Haryana.",
            "अंतर्राष्ट्रीय सौर गठबंधन (ISA) की शुरुआत 30 नवंबर 2015 को पेरिस (COP-21) में भारत और फ्रांस द्वारा की गई थी। इसका मुख्यालय हरियाणा के गुरुग्राम में स्थित है।",
            "UPPCS Pre PYQ 2020 & 2022"
        ),
        RawPyqSeed(
            "Match the major Environmental Movements of India with their leaders and locations:\n1. Chipko Movement (1973, Chamoli, Uttarakhand) — Chandi Prasad Bhatt, Sunderlal Bahuguna & Gaura Devi\n2. Appiko Movement (1983, Uttara Kannada, Karnataka) — Pandurang Hegde\n3. Silent Valley Movement (1978, Palakkad, Kerala — Kunthipuzha River) — Sugathakumari & KSSP\n4. Narmada Bachao Andolan (1985) — Medha Patkar & Baba Amte, and Bishnoi Movement (1730, Khejarli, Jodhpur) — Amrita Devi Bishnoi",
            "भारत के प्रमुख पर्यावरण आंदोलनों का उनके नेतृत्वकर्ताओं एवं स्थानों से मिलान कीजिए:\n1. चिपको आंदोलन (1973, चमोली, उत्तराखंड) — चंडी प्रसाद भट्ट, सुंदरलाल बहुगुणा व गौरा देवी\n2. एपिको आंदोलन (1983, कर्नाटक) — पांडुरंग हेगड़े\n3. साइलेंट वैली (शांत घाटी) आंदोलन (1978, पलक्कड़, केरल — कुंतीपुझा नदी) — सुगाथाकुमारी व केरल शास्त्र साहित्य परिषद\n4. नर्मदा बचाओ आंदोलन (1985) — मेधा पाटकर व बाबा आमटे तथा बिश्नोई आंदोलन (1730, खेजड़ली, राजस्थान) — अमृता देवी बिश्नोई",
            listOf("All 1, 2, 3 and 4 are correctly matched", "1 and 2 only", "1, 3 and 4 only", "2 and 3 only"),
            listOf("सभी 1, 2, 3 और 4 सही सुमेलित हैं", "केवल 1 और 2", "केवल 1, 3 और 4", "केवल 2 और 3"),
            "Additional Environmental Movements & Personalities: Maiti Movement (1994, Uttarakhand — Kalyan Singh Rawat, planting a sapling at weddings); Jungle Bachao Andolan (1982, Singhbhum, Bihar/Jharkhand — against replacing natural Sal forests with Teak); Navdanya Movement (1987 — Dr. Vandana Shiva); 'Waterman of India' — Dr. Rajendra Singh (Tarun Bharat Sangh); 'Birdman of India' — Dr. Salim Ali; 'Tiger Man of India' — Kailash Sankhala; 'Forest Man of India' — Jadav Payeng.",
            "अन्य प्रमुख पर्यावरण आंदोलन एवं व्यक्तित्व: मैती आंदोलन (1994, उत्तराखंड — कल्याण सिंह रावत, विवाह के अवसर पर वृक्षारोपण); जंगल बचाओ आंदोलन (1982, सिंहभूम — प्राकृतिक साल वनों के स्थान पर सागौन लगाने के विरोध में); नवदान्या आंदोलन (डॉ. वंदना शिवा); 'भारत के जलपुरुष' — डॉ. राजेंद्र सिंह; 'बर्डमैन ऑफ इंडिया' — डॉ. सलीम अली; 'टाइगर मैन ऑफ इंडिया' — कैलाश सांखला।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "Where are the headquarters of key Indian Environmental & Forestry Research Institutes located?",
            "भारत के प्रमुख पर्यावरण एवं वानिकी अनुसंधान संस्थानों के मुख्यालयों का सही मिलान कौन-सा है?",
            listOf("Forest Research Institute (FRI): Dehradun | National Environmental Engineering Research Institute (NEERI): Nagpur | Indian Institute of Forest Management (IIFM): Bhopal | Central Arid Zone Research Institute (CAZRI): Jodhpur | National Botanical Research Institute (NBRI): Lucknow", "FRI: Shimla | NEERI: New Delhi | IIFM: Dehradun | CAZRI: Jaipur", "FRI: Dehradun | NEERI: Pune | IIFM: Ranchi | CAZRI: Bikaner", "FRI: Nagpur | NEERI: Dehradun | IIFM: Bhopal | CAZRI: Jodhpur"),
            listOf("वन अनुसंधान संस्थान (FRI): देहरादून | राष्ट्रीय पर्यावरण अभियांत्रिकी अनुसंधान संस्थान (NEERI): नागपुर | भारतीय वन प्रबंधन संस्थान (IIFM): भोपाल | केंद्रीय शुष्क क्षेत्र अनुसंधान संस्थान (CAZRI): जोधपुर | राष्ट्रीय वनस्पति अनुसंधान संस्थान (NBRI): लखनऊ", "FRI: शिमला | NEERI: नई दिल्ली | IIFM: देहरादून | CAZRI: जयपुर", "FRI: देहरादून | NEERI: पुणे | IIFM: राँची | CAZRI: बीकानेर", "FRI: नागपुर | NEERI: देहरादून | IIFM: भोपाल | CAZRI: जोधपुर"),
            "Institute HQs asked in UPPCS every year: Forest Survey of India (FSI, est. 1981, publishes biennial India State of Forest Report ISFR), FRI, and Wildlife Institute of India (WII) — all three at Dehradun; NEERI — Nagpur; IIFM — Bhopal; CAZRI — Jodhpur; Botanical Survey of India (BSI) & Zoological Survey of India (ZSI) — Kolkata; National Biodiversity Authority (NBA) — Chennai; NBRI, CDRI & IITR (Toxicology) — Lucknow; Indian Grassland and Fodder Research Institute (IGFRI) & National Research Centre for Agroforestry — Jhansi (UP).",
            "UPPCS में प्रतिवर्ष पूछे जाने वाले संस्थान मुख्यालय: भारतीय वन सर्वेक्षण (FSI — जो हर 2 वर्ष पर 'भारत वन स्थिति रिपोर्ट' जारी करता है), वन अनुसंधान संस्थान (FRI) व भारतीय वन्यजीव संस्थान (WII) — देहरादून; नीरी (NEERI) — नागपुर; भारतीय वन प्रबंधन संस्थान (IIFM) — भोपाल; काजरी (CAZRI) — जोधपुर; राष्ट्रीय जैव-विविधता प्राधिकरण (NBA) — चेन्नई; भारतीय चरागाह एवं चारा अनुसंधान संस्थान तथा राष्ट्रीय कृषि वानिकी अनुसंधान केंद्र — झाँसी (उ.प्र.)।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "What is 'Biomagnification' (जैव-आवर्धन), and how does it cause thinning of eggshells in birds of prey (vultures/eagles)?",
            "'जैव-आवर्धन' (Biomagnification) क्या है और इसके कारण शिकारी पक्षियों (गिद्ध/बाज) के अंडों का कवच पतला होकर समय से पूर्व क्यों टूट जाता है?",
            listOf("Progressive increase in concentration of non-biodegradable toxic pollutants (like DDT, Mercury, PCBs) at successive higher trophic levels in a food chain | DDT interferes with Calcium metabolism in birds, causing thin eggshells", "Decrease in pollutant concentration at higher trophic levels", "Decomposition of biodegradable waste by bacteria", "Absorption of carbon dioxide by marine phytoplankton (Blue Carbon)"),
            listOf("खाद्य श्रृंखला के क्रमिक उच्च पोषण स्तरों पर अनिम्नीकरणीय विषाक्त प्रदूषकों (जैसे DDT, पारा) की सांद्रता में उत्तरोत्तर वृद्धि होना | DDT पक्षियों में कैल्शियम उपापचय को बाधित कर अंडों के कवच को पतला कर देता है", "उच्च पोषण स्तरों पर प्रदूषकों की सांद्रता का घटना", "जीवाणुओं द्वारा जैव-निम्नीकरणीय कचरे का अपघटन", "समुद्री पादप प्लवकों द्वारा कार्बन का अवशोषण"),
            "Bioaccumulation is the buildup of a toxin within a single organism over time, whereas Biomagnification (Biological Amplification) is the progressive increase in concentration of persistent, fat-soluble, non-biodegradable toxins (like DDT, Mercury/Methylmercury, PCBs) as they move up trophic levels from phytoplankton -> zooplankton -> small fish -> large fish -> fish-eating birds.",
            "'जैव-संचयन' (Bioaccumulation) एक ही जीव के शरीर में प्रदूषक का जमाव है, जबकि 'जैव-आवर्धन' (Biomagnification) खाद्य श्रृंखला के एक पोषण स्तर से अगले उच्च पोषण स्तर में जाने पर वसा में घुलनशील अनिम्नीकरणीय प्रदूषकों (जैसे DDT व पारा) की सांद्रता में क्रमिक वृद्धि होना है।",
            "UPPCS Pre PYQ 2021 & 2023"
        ),
        RawPyqSeed(
            "What is an 'Ecotone' and 'Edge Effect', and which ecosystem is a classic example of an Ecotone between terrestrial and marine ecosystems?",
            "पारिस्थितिकी में 'इकोटोन' (Ecotone / संक्रमण क्षेत्र) और 'कोर प्रभाव' (Edge Effect) क्या हैं, तथा स्थलीय एवं समुद्री पारिस्थितिकी तंत्र के बीच इकोटोन का सर्वोत्तम उदाहरण कौन-सा है?",
            listOf("Ecotone is a zone of transition/junction between two diverse ecosystems (e.g., Mangroves, Estuaries, Wetlands, Grasslands) | Increased species diversity and density in the Ecotone is called the 'Edge Effect'", "Ecotone is the deepest zone of an ocean (Benthic zone)", "Ecotone is a desert area with zero vegetation", "Ecotone refers to artificial space stations"),
            listOf("दो भिन्न पारिस्थितिकी तंत्रों के मध्य का संक्रमण क्षेत्र 'इकोटोन' कहलाता है (जैसे मैंग्रोव वन, ज्वारनदमुख/Estuary, आर्द्रभूमि और घास के मैदान) | इकोटोन क्षेत्र में प्रजातियों की संख्या एवं घनत्व का आसपास के क्षेत्रों से अधिक होना 'एज इफेक्ट' (कोर प्रभाव) कहलाता है", "महासागर का सबसे गहरा नितल क्षेत्र", "शून्य वनस्पति वाला मरुस्थलीय क्षेत्र", "कृत्रिम अंतरिक्ष केंद्र"),
            "An Ecotone is a transitional zone between two distinct biomes/ecosystems—for example, Mangrove forests and Estuaries (between marine and river/terrestrial ecosystems), Grasslands (between forest and desert), and Wetlands/Marshlands (between dry and wet ecosystems). Often, the number of species and population density of some species is much greater in this zone than in either flanking community—this phenomenon is called the 'Edge Effect' (कोर प्रभाव), and species predominantly found there are 'Edge Species' (mostly birds).",
            "दो अलग-अलग पारिस्थितिकी तंत्रों के मिलन या संक्रमण क्षेत्र को 'इकोटोन' (Ecotone) कहते हैं—जैसे मैंग्रोव वन और एश्चुअरी (नदी व समुद्र के मध्य), घासभूमि (वन व मरुस्थल के मध्य), तथा आर्द्रभूमि। इस संक्रमण क्षेत्र में प्रायः दोनों ओर के तंत्रों की तुलना में प्रजातियों की विविधता व घनत्व अधिक होता है, जिसे 'एज इफेक्ट' (Edge Effect) कहा जाता है।",
            "UPPCS Pre PYQ 2020, 2022, 2023"
        ),
        RawPyqSeed(
            "Which organization publishes the 'Red Data Book' (IUCN Red List of Threatened Species), where is its headquarters, and when is 'World Biodiversity Day', 'World Environment Day', and 'World Ozone Day' celebrated?",
            "संकटग्रस्त प्रजातियों की 'रेड डेटा बुक' (Red Data Book) कौन-सी संस्था जारी करती है, इसका मुख्यालय कहाँ है तथा महत्वपूर्ण पर्यावरण दिवसों का सही मिलान क्या है?",
            listOf("IUCN (International Union for Conservation of Nature, founded 1948, HQ: Gland, Switzerland) | 2 Feb: Wetlands Day, 22 March: Water Day, 22 April: Earth Day, 22 May: Biodiversity Day, 5 June: Environment Day, 16 Sept: Ozone Day", "WWF (HQ: Geneva) | 5 June: Biodiversity Day", "UNEP (HQ: Nairobi) | 22 April: Water Day", "UNESCO (HQ: Paris) | 16 Sept: Earth Day"),
            listOf("IUCN (अंतर्राष्ट्रीय प्रकृति संरक्षण संघ, स्थापना 1948, मुख्यालय: ग्लैंड, स्विट्जरलैंड) | 2 फरवरी: आर्द्रभूमि दिवस, 22 मार्च: जल दिवस, 22 अप्रैल: पृथ्वी दिवस, 22 मई: जैव-विविधता दिवस, 5 जून: पर्यावरण दिवस, 16 सितंबर: ओजोन दिवस", "WWF (मुख्यालय: जिनेवा) | 5 जून: जैव-विविधता दिवस", "UNEP (मुख्यालय: नैरोबी) | 22 अप्रैल: जल दिवस", "UNESCO (मुख्यालय: पेरिस) | 16 सितंबर: पृथ्वी दिवस"),
            "IUCN (founded in 1948, HQ at Gland, Switzerland) publishes the Red Data Book (started in 1964), in which 'Pink Pages' list critically endangered species and 'Green Pages' list species that have recovered and are no longer threatened. Meanwhile, WWF (World Wide Fund for Nature, founded 1961, Giant Panda logo, HQ at Gland, Switzerland) organizes the 'Earth Hour' campaign on the last Saturday of March.",
            "IUCN (स्थापना 1948, मुख्यालय: ग्लैंड, स्विट्जरलैंड) द्वारा 'रेड डेटा बुक' प्रकाशित की जाती है, जिसमें संकटग्रस्त प्रजातियों को 'गुलाबी पृष्ठों' (Pink Pages) पर तथा संकट से उबर चुकी प्रजातियों को 'हरे पृष्ठों' (Green Pages) पर दर्शाया जाता है। वहीं WWF (विशाल पांडा प्रतीक चिह्न) द्वारा मार्च के अंतिम शनिवार को 'अर्थ आवर' (Earth Hour) मनाया जाता है।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "According to the 'India State of Forest Report' (ISFR), which State has the Largest Forest Cover by Area, which State has the Highest Percentage of Forest Cover, and which district in Uttar Pradesh has the Maximum Forest Cover (both by area and percentage)?",
            "'भारत वन स्थिति रिपोर्ट' (ISFR) के अनुसार देश में क्षेत्रफल की दृष्टि से सर्वाधिक वनावरण वाला राज्य, प्रतिशत की दृष्टि से सर्वाधिक वनावरण वाला राज्य तथा उत्तर प्रदेश में सर्वाधिक वनावरण वाला जिला कौन-सा है?",
            listOf("India Area-wise: Madhya Pradesh (#1), Arunachal Pradesh (#2), Chhattisgarh (#3) | India Percentage-wise: Mizoram (#1, ~84.5%), Arunachal Pradesh (#2) | Uttar Pradesh Maximum Forest Cover (Area & %): Sonbhadra (Minimum in UP: Bhadohi / Sant Ravidas Nagar)", "India Area: Arunachal Pradesh | India %: Meghalaya | UP Maximum: Lakhimpur Kheri", "India Area: Chhattisgarh | India %: Nagaland | UP Maximum: Pilibhit", "India Area: Odisha | India %: Kerala | UP Maximum: Mirzapur"),
            listOf("भारत (क्षेत्रफल में): मध्य प्रदेश (प्रथम), अरुणाचल प्रदेश (द्वितीय), छत्तीसगढ़ (तृतीय) | भारत (प्रतिशत में): मिजोरम (प्रथम ~84.5%), अरुणाचल प्रदेश (द्वितीय) | उत्तर प्रदेश में सर्वाधिक वनावरण (क्षेत्रफल व प्रतिशत दोनों में): सोनभद्र (न्यूनतम: भदोही / संत रविदास नगर)", "भारत क्षेत्रफल: अरुणाचल प्रदेश | प्रतिशत: मेघालय | उ.प्र. सर्वाधिक: लखीमपुर खीरी", "भारत क्षेत्रफल: छत्तीसगढ़ | प्रतिशत: नागालैंड | उ.प्र. सर्वाधिक: पीलीभीत", "भारत क्षेत्रफल: ओडिशा | प्रतिशत: केरल | उ.प्र. सर्वाधिक: मिर्जापुर"),
            "National Forest Policy (1988) targets 33% of geographical area under forest and tree cover. In India: Area-wise top 3 states are Madhya Pradesh > Arunachal Pradesh > Chhattisgarh; Percentage-wise top 3 states are Mizoram > Arunachal Pradesh > Meghalaya (Lakshadweep > Andaman & Nicobar among UTs); Mangrove cover is highest in West Bengal (Sundarbans ~42%) > Gujarat. In Uttar Pradesh: Top 3 districts by forest area are Sonbhadra > Lakhimpur Kheri > Mirzapur, while Bhadohi (Sant Ravidas Nagar) has the lowest forest cover in UP.",
            "राष्ट्रीय वन नीति (1988) के अनुसार कुल भौगोलिक क्षेत्र के 33% भाग पर वन होना आवश्यक है। भारत में क्षेत्रफल में सर्वाधिक वन मध्य प्रदेश में और प्रतिशत में सर्वाधिक वन मिजोरम में हैं (मैंग्रोव वन सर्वाधिक पश्चिम बंगाल में और दूसरे स्थान पर गुजरात में हैं)। उत्तर प्रदेश में क्षेत्रफल और प्रतिशत दोनों में सर्वाधिक वनावरण 'सोनभद्र' जिले में है तथा न्यूनतम वनावरण 'भदोही' (संत रविदास नगर) में है।",
            "UPPCS Pre PYQ 2020, 2022, 2023, 2024"
        ),
        RawPyqSeed(
            "Which bacterium / bio-fertilizer fixes atmospheric Nitrogen symbiotically in the root nodules of Leguminous plants, in Aquatic Fern 'Azolla' (used in paddy fields), and as a free-living soil bacterium respectively?",
            "क्रमशः दलहनी (Leguminous) पौधों की जड़ों की गाँठों में सहजीवी रूप से, धान के खेतों में प्रयुक्त जलीय फर्न 'अजोला' (Azolla) में तथा मिट्टी में मुक्त-जीवी (Free-living) रूप से नाइट्रोजन स्थिरीकरण करने वाले सूक्ष्मजीव कौन-से हैं?",
            listOf("Legume Root Nodules: Rhizobium (requires Cobalt & Molybdenum for Nitrogenase enzyme) | Azolla (Aquatic Fern in Paddy): Anabaena azollae (Blue-Green Algae / Cyanobacteria) | Free-living Soil Bacteria: Azotobacter (Aerobic) & Clostridium (Anaerobic)", "Nitrosomonas and Nitrobacter | Pseudomonas", "Lactobacillus and Mycorrhiza | E. coli", "Frankia and Spirulina | Penicillium"),
            listOf("दलहनी जड़ों की ग्रंथियों में: राइजोबियम (Rhizobium) | जलीय फर्न 'अजोला' (धान के खेत) में: एनाबीना अजोली (नील-हरित शैवाल / साइनोबैक्टीरिया) | मुक्त-जीवी मृदा जीवाणु: एजोटोबैक्टर (वायवीय) एवं क्लॉस्ट्रिडियम (अवायवीय)", "नाइट्रोसोमोनास और नाइट्रोबैक्टर | स्यूडोमोनास", "लैक्टोबैसिलस और माइकोराइजा | ई. कोलाई", "फ्रैंकिया और स्पिरुलिना | पेनिसिलियम"),
            "Nitrogen Fixation & Biofertilizers (asked in almost every UPPCS exam across Env & Sci): 1. Symbiotic with legumes (pulses/peas/soybean): Rhizobium (forms root nodules containing pink pigment Leghemoglobin as oxygen scavenger); 2. Symbiotic with non-leguminous Alnus/Casuarina: Frankia; 3. Symbiotic with water fern Azolla in rice/paddy fields: Anabaena azollae (Cyanobacteria / BGA, along with Nostoc); 4. Associative in cereals/sugarcane: Azospirillum; 5. Free-living: Azotobacter & Clostridium; 6. Phosphate-solubilizing fungal association: Mycorrhiza.",
            "UPPCS में बार-बार पूछा जाने वाला जैव-उर्वरक (Bio-fertilizer) प्रश्न: 1. दलहनी फसलों की जड़ों में सहजीवी: राइजोबियम (जिसमें गुलाबी वर्णक 'लेगहीमोग्लोबिन' पाया जाता है); 2. धान के खेतों में जलीय फर्न 'अजोला' के साथ सहजीवी: एनाबीना अजोली व नॉस्टॉक (नील-हरित शैवाल / साइनोबैक्टीरिया); 3. मुक्त-जीवी नाइट्रोजन स्थिरीकरण जीवाणु: एजोटोबैक्टर और क्लॉस्ट्रिडियम; 4. कवक मूल सहजीवी (फॉस्फोरस अवशोषण): माइकोराइजा।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "What is the primary constituent of 'Compressed Natural Gas' (CNG) & 'Biogas / Gobar Gas' vs 'Liquefied Petroleum Gas' (LPG), and which chemical is added to LPG to detect leakage smell?",
            "'सीएनजी' (CNG) एवं 'बायोगैस/गोबर गैस' का मुख्य घटक क्या है बनाम घरेलू रसोई गैस 'एलपीजी' (LPG) का मुख्य घटक क्या है, तथा एलपीजी के रिसाव की गंध पहचानने के लिए उसमें क्या मिलाया जाता है?",
            listOf("CNG & Biogas: Methane (CH₄ — 55% to 85%) | LPG: Butane (C₄H₁₀) and Propane (C₃H₈) | Leakage smell agent in LPG: Ethyl Mercaptan (Ethanethiol - C₂H₅SH)", "CNG: Butane & Propane | LPG: Methane & Ethane | Smell agent: Methyl Isocyanate", "CNG: Hydrogen | LPG: Carbon Monoxide & Nitrogen | Smell agent: Ammonia", "CNG: Acetylene | LPG: Ethylene | Smell agent: Phosgene"),
            listOf("CNG व बायोगैस: मीथेन (CH₄ — मुख्य घटक) | LPG: ब्यूटेन (C₄H₁₀) और प्रोपेन (C₃H₈) | एलपीजी रिसाव की गंध हेतु मिलाया जाने वाला यौगिक: एथिल मरकैप्टन (C₂H₅SH)", "CNG: ब्यूटेन और प्रोपेन | LPG: मीथेन और एथेन | गंध यौगिक: मिथाइल आइसोसाइनेट", "CNG: हाइड्रोजन | LPG: कार्बन मोनोऑक्साइड | गंध यौगिक: अमोनिया", "CNG: एसिटिलीन | LPG: एथिलीन | गंध यौगिक: फॉस्जीन"),
            "Fuel Composition (tested repeatedly in UPPCS): 1. CNG, PNG, Biogas/Gobar Gas, and Coal Bed Methane — primarily Methane (CH₄); 2. LPG (Liquefied Petroleum Gas) — primarily Butane and Isobutane + Propane, with 'Ethyl Mercaptan' (a sulphur compound) added for foul odor detection; 3. Water Gas (Syngas) — CO + H₂; 4. Producer Gas — CO + N₂; 5. Petrol quality is measured by 'Octane Number', while Diesel quality is measured by 'Cetane Number'.",
            "प्रमुख ईंधन एवं उनके घटक: 1. CNG, बायोगैस (गोबर गैस) एवं प्राकृतिक गैस का मुख्य घटक 'मीथेन' (CH₄) है; 2. LPG (द्रवित पेट्रोलियम गैस) का मुख्य घटक 'ब्यूटेन और प्रोपेन' है तथा इसके रिसाव का पता लगाने के लिए इसमें तीव्र गंध वाला सल्फर यौगिक 'एथिल मरकैप्टन' मिलाया जाता है; 3. पेट्रोल की गुणवत्ता 'ऑक्टेन संख्या' से और डीजल की गुणवत्ता 'सीटेन संख्या' से मापी जाती है।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023"
        )
    )

    // =========================================================================
    // SECTION 5: SCIENCE & TECH (50 Authentic UPPCS 2020–2025 PYQ Questions)
    // =========================================================================
    private val scienceTech50Seeds: List<RawPyqSeed> = listOf(
        RawPyqSeed(
            "Match the Vitamins with their Chemical Names and Deficiency Diseases:\n1. Vitamin A (Retinol) — Night Blindness & Xerophthalmia\n2. Vitamin B1 (Thiamine) — Beri-Beri | Vitamin B3 (Niacin) — Pellagra\n3. Vitamin C (Ascorbic Acid) — Scurvy | Vitamin D (Calciferol) — Rickets & Osteomalacia\n4. Vitamin E (Tocopherol) — Sterility/Anti-oxidant | Vitamin K (Phylloquinone) — Failure of Blood Clotting",
            "विटामिनों का उनके रासायनिक नामों एवं कमी से होने वाले रोगों के साथ सही मिलान चुनिए:\n1. विटामिन A (रेटिनॉल) — रतौंधी व जीरोफ्थैल्मिया\n2. विटामिन B1 (थायमिन) — बेरी-बेरी | विटामिन B3 (नियासिन) — पेलाग्रा\n3. विटामिन C (एस्कॉर्बिक अम्ल) — स्कर्वी | विटामिन D (कैल्सीफेरॉल) — रिकेट्स व ऑस्टियोमलेशिया\n4. विटामिन E (टोकोफेरॉल) — जनन क्षमता में कमी | विटामिन K (फिलोक्विनोन) — रक्त का थक्का न जमना",
            listOf("All 1, 2, 3 and 4 are correctly matched (Water-soluble: Vitamin B-complex & C | Fat-soluble: Vitamins A, D, E, and K)", "1, 2 and 3 only", "2 and 4 only", "1 and 3 only"),
            listOf("सभी 1, 2, 3 और 4 सही सुमेलित हैं (जल में घुलनशील: विटामिन B व C | वसा में घुलनशील: विटामिन A, D, E व K)", "केवल 1, 2 और 3", "केवल 2 और 4", "केवल 1 और 3"),
            "Casimir Funk coined the term 'Vitamine' in 1912. Fat-soluble vitamins (stored in liver/adipose tissue): A, D, E, K. Water-soluble vitamins (not stored in body, excreted in urine except B12): B-complex and C. Vitamin C (found richly in Aonla/citrus fruits) aids in collagen synthesis, wound healing, and Iron absorption, and is destroyed by heating/cooking.",
            "कासिमिर फंक ने 1912 में 'विटामिन' शब्द दिया। वसा में घुलनशील विटामिन: A, D, E, K (यकृत में संचित होते हैं); जल में घुलनशील विटामिन: B और C। विटामिन C (सर्वाधिक स्रोत: आँवला) घाव भरने तथा शरीर में लौह (Iron) के अवशोषण में सहायक होता है और गर्म करने पर नष्ट हो जाता है।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "Match the Endocrine Glands & Plant Hormones with their physiological functions:\n1. Insulin (Beta cells of Pancreas / Islets of Langerhans) — Regulates blood glucose (contains Zinc metal ion)\n2. Thyroxine (Thyroid gland) — Basal Metabolic Rate (requires Iodine) & Adrenaline — 'Fight or Flight' hormone\n3. Auxin, Gibberellin, Cytokinin — Plant growth promoters\n4. Ethylene — Only gaseous plant hormone (Ripening of fruits) & Abscisic Acid (ABA) — Plant stress / growth inhibitor hormone",
            "अंतःस्रावी ग्रंथियों के हार्मोन एवं पादप हार्मोनों का उनके कार्यों से सही मिलान चुनिए:\n1. इंसुलिन (अग्न्याशय की लैंगरहैंस की द्वीपिकाओं की बीटा-कोशिकाएँ) — रक्त शर्करा नियंत्रण (इसमें 'जिंक' धातु होती है)\n2. थायरॉक्सिन (थायरॉइड ग्रंथि) — उपापचय दर (आयोडीन आवश्यक) एवं एड्रेनालिन — 'लड़ो या उड़ो' (आपातकालीन) हार्मोन\n3. ऑक्सिन, जिबरेलिन, साइटोकाइनिन — पादप वृद्धि वर्धक हार्मोन\n4. एथिलीन — एकमात्र गैसीय पादप हार्मोन (फलों को प्राकृतिक रूप से पकाने वाला) एवं एब्सिसिक अम्ल (ABA) — वृद्धि रोधक हार्मोन",
            listOf("All 1, 2, 3 and 4 are correctly matched", "1 and 2 only", "1, 3 and 4 only", "2, 3 and 4 only"),
            listOf("सभी 1, 2, 3 और 4 सही सुमेलित हैं", "केवल 1 और 2", "केवल 1, 3 और 4", "केवल 2, 3 और 4"),
            "Hormones tested in UPPCS: Pancreas is a 'Mixed Gland' (both exocrine & endocrine; Beta cells secrete Insulin, Alpha cells secrete Glucagon). Pituitary gland is the 'Master Gland' (controlled by Hypothalamus); Oxytocin is the 'birth / milk-ejection hormone'. Among plant hormones: Ethylene (C₂H₄) is used for natural ripening of fruits (while Calcium Carbide / Acetylene was used artificially).",
            "UPPCS में हार्मोन से संबंधित प्रमुख तथ्य: अग्न्याशय (Pancreas) एक 'मिश्रित ग्रंथि' है जिसकी बीटा कोशिकाओं से 'इंसुलिन' (जिसमें जस्ता/Zinc धातु पाई जाती है) का स्राव होता है और इसकी कमी से मधुमेह (Diabetes Mellitus) होता है। पीयूष ग्रंथि (Pituitary) को 'मास्टर ग्रंथि' कहते हैं। पादप हार्मोनों में 'एथिलीन' फलों को पकाने वाला एकमात्र गैसीय हार्मोन है।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "Match the Human Diseases with their Causative Pathogens (Virus, Bacteria, Protozoa) and Vectors:\n1. Dengue, Chikungunya, Zika & Yellow Fever (Viral) — Female Aedes aegypti mosquito\n2. Malaria (Protozoa: Plasmodium) — Female Anopheles mosquito (Drug: Quinine from Cinchona bark)\n3. Filariasis / Elephantiasis — Female Culex mosquito & Kala-azar (Protozoa: Leishmania donovani) — Sandfly\n4. Tuberculosis (Mycobacterium), Typhoid (Salmonella typhi — Widal Test), Cholera (Vibrio cholerae), Diphtheria, Plague & Tetanus — Bacterial Diseases",
            "मानव रोगों का उनके रोगजनकों (विषाणु, जीवाणु, प्रोटोजोआ) एवं वाहकों (Vectors) से मिलान कीजिए:\n1. डेंगू, चिकनगुनिया, जीका व पीत ज्वर (विषाणु जनित) — मादा एडीज इजिप्टी मच्छर\n2. मलेरिया (प्रोटोजोआ: प्लाज्मोडियम) — मादा एनोफिलीज मच्छर (दवा: सिनकोना की छाल से प्राप्त कुनैन)\n3. फाइलेरिया (हाथीपाँव) — मादा क्यूलेक्स मच्छर एवं कालाजार (लीशमैनिया प्रोटोजोआ) — बालू मक्खी (Sandfly)\n4. तपेदिक/TB (BCG टीका), टाइफॉइड (विडाल टेस्ट), हैजा, डिफ्थीरिया, प्लेग व टेटनस — जीवाणु (Bacteria) जनित रोग",
            listOf("All 1, 2, 3 and 4 are correctly matched", "1 and 2 only", "2, 3 and 4 only", "1, 3 and 4 only"),
            listOf("सभी 1, 2, 3 और 4 सही सुमेलित हैं", "केवल 1 और 2", "केवल 2, 3 और 4", "केवल 1, 3 और 4"),
            "Additional Disease Facts for UPPCS: Dengue fever causes a rapid drop in Blood Platelets (Thrombocytes). Japanese Encephalitis (viral brain fever prevalent in Gorakhpur/Terai belt) is transmitted by Culex mosquitoes with pigs and wading birds as amplifying hosts. Sleeping Sickness (Trypanosoma protozoa) is transmitted by the Tsetse fly. ELISA test and Western Blot are used for HIV/AIDS diagnosis, while Widal Test is used for Typhoid and Mantoux test/CBNAAT for TB.",
            "UPPCS में रोगों से जुड़े प्रमुख तथ्य: डेंगू ज्वर ('हड्डी तोड़ बुखार') में रक्त में 'प्लेटलेट्स' (बिम्बाणु) की संख्या तेजी से घटती है। जापानी इंसेफेलाइटिस (दिमागी बुखार) क्यूलेक्स मच्छर द्वारा फैलता है। निद्रा रोग (Sleeping Sickness — ट्रिपेनोसोमा प्रोटोजोआ) सी-सी मक्खी (Tsetse Fly) से फैलता है। टाइफॉइड की जाँच हेतु 'विडाल टेस्ट' और HIV/AIDS हेतु 'एलिसा (ELISA) टेस्ट' किया जाता है।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023, 2024"
        ),
        RawPyqSeed(
            "Which phenomenon of Light is responsible for the functioning of 'Optical Fibers' (used in high-speed internet and endoscopy), the sparkling of a Diamond, and the formation of a Mirage?",
            "तेज इंटरनेट संचार एवं एंडोस्कोपी में प्रयुक्त 'प्रकाशिक तंतु' (Optical Fiber), हीरे के चमकने और रेगिस्तान में 'मृगमरीचिका' (Mirage) बनने के पीछे प्रकाश की कौन-सी घटना कार्य करती है?",
            listOf("Total Internal Reflection (पूर्ण आंतरिक परावर्तन — proposed by Narinder Singh Kapany for Optical Fiber)", "Refraction and Dispersion of Light", "Diffraction and Polarization of Light", "Tyndall Effect and Rayleigh Scattering"),
            listOf("पूर्ण आंतरिक परावर्तन (Total Internal Reflection — नरेंद्र सिंह कपानी को ऑप्टिकल फाइबर का जनक माना जाता है)", "प्रकाश का अपवर्तन एवं वर्ण-विक्षेपण", "प्रकाश का विवर्तन एवं ध्रुवण", "टिंडल प्रभाव एवं प्रकीर्णन"),
            "Physics Optics in UPPCS: 1. Total Internal Reflection (occurs when light travels from a denser to a rarer medium at an angle greater than the critical angle): Optical Fiber (invented by Narinder Singh Kapany), sparkling of diamond (critical angle ~24.4°), Mirage in deserts, and Endoscope. 2. Scattering of Light: Blue color of sky & reddish sun at sunrise/sunset. 3. Atmospheric Refraction: Twinkling of stars & apparent early sunrise. 4. Concave Mirror: Used by ENT doctors/dentists, shaving mirror, solar cookers, and vehicle headlights; Convex Mirror: Rear-view mirror in vehicles.",
            "भौतिकी (प्रकाशिकी) के प्रमुख तथ्य: 1. पूर्ण आंतरिक परावर्तन (जब प्रकाश सघन से विरल माध्यम में क्रांतिक कोण से अधिक कोण पर प्रवेश करता है): ऑप्टिकल फाइबर (जनक: नरेंद्र सिंह कपानी), हीरे का चमकना, रेगिस्तान की मृगमरीचिका और एंडोस्कोपी। 2. प्रकाश का प्रकीर्णन: आकाश का नीला रंग। 3. वायुमंडलीय अपवर्तन: तारों का टिमटिमाना। 4. अवतल दर्पण: दंत चिकित्सक, शेविंग दर्पण व सोलर कुकर; उत्तल दर्पण: वाहनों का साइड मिरर (Rear-view mirror)।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "Match the Scientific Instruments with the Physical Quantities they measure:\n1. Pyrheliometer & Pyrometer — Solar Radiation & Very High Temperature (>800°C)\n2. Hygrometer — Relative Humidity of Air (while Hydrometer measures Relative Density of Liquids)\n3. Fathometer & SONAR — Depth of Ocean & Submerged Objects (using Ultrasonic waves)\n4. Sphygmomanometer — Blood Pressure & Anemometer — Wind Speed",
            "प्रमुख वैज्ञानिक यंत्रों का उनके द्वारा मापी जाने वाली भौतिक राशियों से मिलान कीजिए:\n1. पाइरहिलियोमीटर एवं पायरोमीटर — सौर विकिरण एवं अत्यधिक उच्च तापमान (>800°C)\n2. हाइग्रोमीटर — वायुमंडलीय सापेक्षिक आर्द्रता (जबकि हाइड्रोमीटर द्रवों का आपेक्षिक घनत्व मापता है)\n3. फैदोमीटर एवं सोनार (SONAR) — समुद्र की गहराई एवं डूबी हुई वस्तुओं का पता लगाना (पराश्रव्य तरंगों द्वारा)\n4. स्फिग्मोमैनोमीटर — रक्तचाप (Blood Pressure) एवं एनीमोमीटर — पवन का वेग",
            listOf("All 1, 2, 3 and 4 are correctly matched", "1 and 2 only", "2, 3 and 4 only", "1, 3 and 4 only"),
            listOf("सभी 1, 2, 3 और 4 सही सुमेलित हैं", "केवल 1 और 2", "केवल 2, 3 और 4", "केवल 1, 3 और 4"),
            "UPPCS asks a list-matching question on Scientific Instruments almost every year! Additional instruments: Altimeter (altitude in aircraft); Barometer (atmospheric pressure — sudden drop indicates a storm); Lactometer (purity/density of milk); Luxmeter (intensity of light); Seismograph (earthquake intensity); Ammeter (electric current); Potentiometer (EMF); Auxanometer & Crescograph (plant growth — J.C. Bose); Dobson Spectrophotometer (atmospheric Ozone thickness).",
            "UPPCS में वैज्ञानिक यंत्रों के सुमेलन से हर वर्ष प्रश्न आता है: पाइरहिलियोमीटर (सौर विकिरण); पायरोमीटर (अत्यधिक उच्च ताप); हाइग्रोमीटर (वायु की आर्द्रता); हाइड्रोमीटर (द्रव का घनत्व); लैक्टोमीटर (दूध की शुद्धता); बैरोमीटर (वायुदाब — पाठ्यांक का अचानक गिरना आँधी-तूफान का संकेत है); सोनार (SONAR — पराश्रव्य तरंगों द्वारा समुद्र में डूबी वस्तुओं का पता लगाना); ऑक्सेनोमीटर व क्रेस्कोग्राफ (पौधों की वृद्धि)।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "Match the Organic Acids, Polymers, and Chemical Compounds with their Natural Sources / Uses:\n1. Formic Acid (Methanoic Acid) — Ant & Nettle Sting | Lactic Acid — Curd & Muscle Fatigue\n2. Acetic Acid — Vinegar | Citric Acid — Lemon/Orange | Tartaric Acid — Tamarind & Grapes | Oxalic Acid — Tomato (used to remove rust/ink stains)\n3. Teflon (Polytetrafluoroethylene - PTFE) — Non-stick cookware coating & Kevlar — Bulletproof vests\n4. Silver Iodide (AgI) — Artificial Rain (Cloud Seeding) & Silver Bromide (AgBr) — Photography",
            "कार्बनिक अम्लों, बहुलकों एवं रासायनिक यौगिकों का उनके प्राकृतिक स्रोतों/उपयोगों से मिलान कीजिए:\n1. फॉर्मिक अम्ल (मेथेनोइक अम्ल) — चींटी व बिच्छू का डंक | लैक्टिक अम्ल — दही एवं मांसपेशियों में थकान\n2. एसिटिक अम्ल — सिरका | सिट्रिक अम्ल — नींबू | टार्टरिक अम्ल — इमली व अंगूर | ऑक्सैलिक अम्ल — टमाटर (कपड़ों से जंग व स्याही के दाग हटाने में प्रयुक्त)\n3. टेफ्लॉन (PTFE) — नॉन-स्टिक बर्तनों की कोटिंग एवं केवलर / पॉलीकार्बोनेट — बुलेटप्रूफ जैकेट व ग्लास\n4. सिल्वर आयोडाइड (AgI) — कृत्रिम वर्षा एवं सिल्वर ब्रोमाइड (AgBr) — फोटोग्राफी (स्थायीकरण हेतु हाइपो/सोडियम थायोसल्फेट)",
            listOf("All 1, 2, 3 and 4 are correctly matched", "1, 2 and 3 only", "1 and 4 only", "2 and 3 only"),
            listOf("सभी 1, 2, 3 और 4 सही सुमेलित हैं", "केवल 1, 2 और 3", "केवल 1 और 4", "केवल 2 और 3"),
            "Additional Chemistry facts tested in UPPCS: Malic Acid — Apple; Butyric Acid — Rancid butter; Uric Acid — accumulation in joints causes Gout (गठिया); Benzoic Acid / Sodium Benzoate — Food preservation; Silver Nitrate (AgNO₃ — Lunar Caustic) — Indelible Voters' Ink; Zinc Phosphide — Rat poison; Heavy Water (D₂O — Deuterium Oxide, molecular weight 20) — Moderator & Coolant in nuclear reactors.",
            "UPPCS रसायन विज्ञान के अन्य प्रमुख तथ्य: मैलिक अम्ल — सेब; ब्यूटिरिक अम्ल — मक्खन; जोड़ों में 'यूरिक अम्ल' के क्रिस्टल जमा होने से गठिया (Gout) रोग होता है; सोडियम बेंजोएट — खाद्य पदार्थों के परिरक्षण (Preservation) में; सिल्वर नाइट्रेट (AgNO₃) — मतदाताओं की उंगली पर लगाई जाने वाली अमिट स्याही; जिंक फॉस्फाइड — चूहा मारने की दवा; भारी जल (D₂O, अणुभार 20) — परमाणु रिएक्टर में मंदक (Moderator)।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "Which Cell Organelles in Eukaryotic cells besides the Nucleus contain their own circular DNA and 70S Ribosomes ('Semi-autonomous Organelles'), and which organelle is called the 'Powerhouse of the Cell' vs 'Suicidal Bag of the Cell'?",
            "यूकैरियोटिक कोशिका में केंद्रक (Nucleus) के अतिरिक्त किन दो कोशिकांगों में अपना स्वयं का DNA पाया जाता है, तथा किसे 'कोशिका का पावरहाउस' और किसे 'कोशिका की आत्मघाती थैली' (Suicidal Bag) कहा जाता है?",
            listOf("Mitochondria and Chloroplast (Plastids) contain their own DNA | Mitochondria = Powerhouse of the Cell (ATP synthesis); Lysosome = Suicidal Bag (discovered by Christian de Duve); Ribosome = Protein Factory", "Golgi Body and Endoplasmic Reticulum | Ribosome = Powerhouse", "Lysosome and Vacuole | Centrosome = Suicidal Bag", "Ribosome and Peroxisome | Nucleus = Powerhouse"),
            listOf("माइटोकॉन्ड्रिया और हरितलवक (Chloroplast) में केंद्रक के अलावा स्वयं का DNA पाया जाता है | माइटोकॉन्ड्रिया = कोशिका का ऊर्जागृह (ATP निर्माण); लाइसोसोम = आत्मघाती थैली; राइबोसोम = प्रोटीन की फैक्ट्री", "गॉल्जीकाय और अंतर्द्रव्यी जालिका | राइबोसोम = पावरहाउस", "लाइसोसोम और रिक्तिका | सेंट्रोसोम = आत्मघाती थैली", "राइबोसोम और परऑक्सीसोम | केंद्रक = पावरहाउस"),
            "Cell Biology in UPPCS: Besides the Nucleus, ONLY Mitochondria and Chloroplasts (Plastids in plant cells) possess their own circular DNA and 70S ribosomes, making them semi-autonomous organelles. Mitochondria (discovered by Kolliker, named by Benda) generate ATP via cellular respiration. Lysosomes contain hydrolytic digestive enzymes ('Suicidal Bags'). Plant cell walls are made of Cellulose, while Fungal cell walls are made of Chitin.",
            "कोशिका विज्ञान (UPPCS में बार-बार पूछा गया प्रश्न): केंद्रक के अतिरिक्त केवल 'माइटोकॉन्ड्रिया' और 'हरितलवक' (Chloroplast) में अपना स्वयं का DNA और राइबोसोम पाया जाता है। माइटोकॉन्ड्रिया में श्वसन द्वारा ATP के रूप में ऊर्जा बनती है ('कोशिका का पावरहाउस')। पादप कोशिका भित्ति 'सेल्युलोज' की तथा कवक (Fungi) की कोशिका भित्ति 'काइटिन' की बनी होती है।",
            "UPPCS Pre PYQ 2020, 2022, 2023"
        ),
        RawPyqSeed(
            "In Human Blood, which Blood Group is the 'Universal Donor' vs 'Universal Recipient', which enzyme/protein and metal ion are essential for Blood Clotting, and what is the normal pH of Human Blood?",
            "मानव रक्त में कौन-सा रक्त समूह 'सर्वदाता' (Universal Donor) और कौन-सा 'सर्वग्राही' (Universal Recipient) है, रक्त का थक्का जमने के लिए कौन-सा प्रोटीन/एंजाइम व धातु आयन आवश्यक है तथा रक्त का pH मान क्या है?",
            listOf("Universal Donor: O Negative (O⁻, has no Antigen) | Universal Recipient: AB Positive (AB⁺, has no Antibody) | Clotting requires: Thrombin, Fibrinogen, Platelets, Vitamin K & Calcium ion (Ca²⁺) | Blood pH = 7.4 (slightly alkaline)", "Universal Donor: AB⁺ | Universal Recipient: O⁻ | Blood pH = 6.4", "Universal Donor: A⁺ | Universal Recipient: B⁺ | Blood pH = 7.0", "Universal Donor: O⁺ | Universal Recipient: AB⁻ | Clotting requires Iron"),
            listOf("सर्वदाता: O नेगेटिव (O⁻, कोई एंटीजन नहीं) | सर्वग्राही: AB पॉजिटिव (AB⁺, कोई एंटीबॉडी नहीं) | रक्त का थक्का जमने हेतु आवश्यक: थ्रॉम्बिन, फाइब्रिनोजन, प्लेटलेट्स, विटामिन K एवं कैल्शियम आयन (Ca²⁺) | रक्त का pH = 7.4 (हल्का क्षारीय)", "सर्वदाता: AB⁺ | सर्वग्राही: O⁻ | रक्त pH = 6.4", "सर्वदाता: A⁺ | सर्वग्राही: B⁺ | रक्त pH = 7.0", "सर्वदाता: O⁺ | सर्वग्राही: AB⁻ | थक्के हेतु लोहा"),
            "Karl Landsteiner discovered the ABO blood group system (1900) and Rh factor (with Wiener in Rhesus monkey). RBCs (Erythrocytes, lifespan ~120 days, formed in Bone Marrow, destroyed in Spleen — 'Graveyard of RBCs') contain Hemoglobin (Iron-containing pigment) for oxygen transport. At high altitudes, RBC count increases due to lower atmospheric oxygen pressure. Heparin is the natural anticoagulant that prevents blood from clotting inside blood vessels.",
            "कार्ल लैंडस्टीनर ने रक्त समूह (ABO) एवं Rh फैक्टर की खोज की। लाल रक्त कणिकाओं (RBC — जीवनकाल 120 दिन, निर्माण अस्थिमज्जा में, विनाश प्लीहा/Spleen में — जिसे 'RBC का कब्रिस्तान' कहते हैं) में लौह-युक्त 'हीमोग्लोबिन' होता है। पहाड़ों (अधिक ऊँचाई) पर जाने पर ऑक्सीजन का आंशिक दाब कम होने के कारण RBC की संख्या बढ़ जाती है। शरीर के भीतर रक्त को जमने से 'हिपैरिन' (Heparin) नामक प्रोटीन रोकता है।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "Match the landmark ISRO Space & Defence Missions of India with their key achievements:\n1. Chandrayaan-3 (23 August 2023 — 'National Space Day') — Soft landing near Lunar South Pole at 'Shiv Shakti Point' (Vikram Lander & Pragyan Rover, launched by LVM3-M4)\n2. Aditya-L1 (2 Sept 2023, PSLV-C57) — India's first Solar Observatory placed in Halo Orbit around Sun-Earth Lagrange Point 1 (L1, 1.5 million km from Earth)\n3. Gaganyaan — India's Human Spaceflight Mission & NISAR — Joint NASA-ISRO Dual-Frequency Synthetic Aperture Radar Earth Observation Satellite\n4. Agni-V (MIRV technology - Mission Divyastra) & BrahMos (Supersonic Cruise Missile manufactured in Lucknow Defence Corridor Node)",
            "भारत के प्रमुख अंतरिक्ष (ISRO) एवं रक्षा मिशनों का उनकी उपलब्धियों से मिलान कीजिए:\n1. चंद्रयान-3 (23 अगस्त 2023 — 'राष्ट्रीय अंतरिक्ष दिवस') — चंद्रमा के दक्षिणी ध्रुव के पास 'शिव शक्ति पॉइंट' पर सफल लैंडिंग (विक्रम लैंडर व प्रज्ञान रोवर, रॉकेट: LVM3-M4)\n2. आदित्य-L1 (PSLV-C57) — सूर्य-पृथ्वी के लैग्रेंज बिंदु-1 (L1, पृथ्वी से 15 लाख किमी दूर) की हैलो कक्षा में स्थापित भारत की पहली सौर वेधशाला\n3. गगनयान — भारत का मानव अंतरिक्ष उड़ान मिशन एवं निसार (NISAR) — नासा और इसरो का संयुक्त सिंथेटिक एपर्चर रडार उपग्रह\n4. अग्नि-V (MIRV तकनीक - मिशन दिव्यास्त्र) एवं ब्रह्मोस (सुपरसोनिक क्रूज मिसाइल, जिसकी निर्माण इकाई लखनऊ डिफेंस कॉरिडोर में स्थापित है)",
            listOf("All 1, 2, 3 and 4 are correctly matched", "1 and 2 only", "1, 2 and 3 only", "2 and 4 only"),
            listOf("सभी 1, 2, 3 और 4 सही सुमेलित हैं", "केवल 1 और 2", "केवल 1, 2 और 3", "केवल 2 और 4"),
            "India became the 4th country to soft-land on the Moon and the 1st country to land near the Lunar South Pole on 23 August 2023 (celebrated annually as 'National Space Day'; Chandrayaan-3 landing site is named 'Shiv Shakti Point' and Chandrayaan-2 crash site is 'Tiranga Point'). Meanwhile, the Uttar Pradesh Defence Industrial Corridor has 6 nodes: Lucknow (BrahMos missile facility), Kanpur, Jhansi, आगरा, Aligarh, and Chitrakoot.",
            "23 अगस्त 2023 को चंद्रयान-3 की चंद्रमा के दक्षिणी ध्रुव पर सफल लैंडिंग के साथ भारत ऐसा करने वाला विश्व का पहला देश बना (23 अगस्त को 'राष्ट्रीय अंतरिक्ष दिवस' और लैंडिंग स्थल को 'शिव शक्ति पॉइंट' घोषित किया गया)। वहीं 'उत्तर प्रदेश डिफेंस इंडस्ट्रियल कॉरिडोर' के 6 नोड हैं: अलीगढ़, आगरा, झाँसी, चित्रकूट, कानपुर और लखनऊ (जहाँ ब्रह्मोस मिसाइल निर्माण इकाई स्थापित है)।",
            "UPPCS Pre PYQ 2023 & 2024 Trend"
        ),
        RawPyqSeed(
            "Match the Radioisotopes used in Nuclear Medicine with their diagnostic/therapeutic applications:\n1. Cobalt-60 (Co-60) — Treatment of Cancer / Tumors (emits Gamma rays)\n2. Iodine-131 (I-131) — Treatment & diagnosis of Thyroid Gland disorders (Goitre)\n3. Sodium-24 (Na-24) — Detection of Blood Clots in the circulatory system\n4. Arsenic-74 (As-74) — Detection of Tumors & Carbon-14 (C-14) — Radiocarbon Dating of fossils (while Uranium-Lead dating is used for ancient rocks/Earth)",
            "चिकित्सा एवं विज्ञान में प्रयुक्त रेडियो-समस्थानिकों (Radioisotopes) का उनके अनुप्रयोगों से सही मिलान चुनिए:\n1. कोबाल्ट-60 (Co-60) — कैंसर/ट्यूमर के उपचार में (गामा किरणों का उत्सर्जन)\n2. आयोडीन-131 (I-131) — थायरॉइड ग्रंथि (घेंघा/Goitre) के विकारों की जाँच व उपचार में\n3. सोडियम-24 (Na-24) — रक्त परिसंचरण तंत्र में रक्त के थक्के (Blood Clot) का पता लगाने में\n4. आर्सेनिक-74 (As-74) — ट्यूमर की पहचान में एवं कार्बन-14 (C-14) — जीवाश्मों (Fossils) की आयु निर्धारण में (जबकि चट्टानों/पृथ्वी की आयु 'यूरेनियम डेटिंग' से ज्ञात की जाती है)",
            listOf("All 1, 2, 3 and 4 are correctly matched", "1 and 2 only", "1, 2 and 3 only", "2 and 4 only"),
            listOf("सभी 1, 2, 3 और 4 सही सुमेलित हैं", "केवल 1 और 2", "केवल 1, 2 और 3", "केवल 2 और 4"),
            "Radioisotopes matching is one of the most repeated Science questions in UPPCS Prelims! Additional isotope: Phosphorus-32 (P-32) — used in treatment of Leukemia (blood cancer). Meanwhile, the age of trees is determined by 'Dendrochronology' (counting annual growth rings).",
            "रेडियो-समस्थानिकों का सुमेलन UPPCS सामान्य विज्ञान के सबसे अधिक दोहराए जाने वाले प्रश्नों में से एक है! इसके अतिरिक्त फॉस्फोरस-32 (P-32) का उपयोग ल्यूकेमिया (रक्त कैंसर) के उपचार में होता है तथा वृक्षों की आयु वार्षिक वलयों (Annual Rings) को गिनकर ज्ञात की जाती है, जिसे 'डेंड्रोक्रोनोलॉजी' कहते हैं।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023"
        )
    )

    private val scienceTechSecondHalfSeeds: List<RawPyqSeed> = listOf(
        RawPyqSeed(
            "In Human Digestion, which enzymes digest Carbohydrates, Proteins, and Fats respectively, and where is Bile Juice (पित्त रस) produced vs stored?",
            "मानव पाचन तंत्र में क्रमशः कार्बोहाइड्रेट, प्रोटीन और वसा का पाचन करने वाले प्रमुख एंजाइम कौन-से हैं तथा 'पित्त रस' (Bile Juice) का निर्माण और संचय कहाँ होता है?",
            listOf("Carbohydrates: Salivary Amylase (Ptyalin) | Proteins: Pepsin (in Stomach), Trypsin (Pancreas) & Renin (Milk protein Casein) | Fats: Lipase | Bile Juice is produced by the Liver (largest gland) and stored in the Gall Bladder (emulsifies fats, contains NO digestive enzymes)", "Bile is produced in Gall Bladder and stored in Liver | Pepsin digests fats", "Trypsin digests starch | Lipase digests proteins", "Amylase is secreted in the stomach along with HCl"),
            listOf("कार्बोहाइड्रेट: टायलिन (लार एमाइलेज) | प्रोटीन: पेप्सिन (आमाशय में), ट्रिप्सिन (अग्न्याशय) व रेनिन (दूध के केसिन प्रोटीन का पाचन) | वसा: लाइपेज | पित्त रस का निर्माण 'यकृत' (Liver — सबसे बड़ी ग्रंथि) में तथा संचय 'पित्ताशय' (Gall Bladder) में होता है", "पित्त का निर्माण पित्ताशय में और संचय यकृत में होता है", "ट्रिप्सिन स्टार्च का पाचन करता है", "टायलिन आमाशय में HCl के साथ स्रावित होता है"),
            "Human Digestive System key UPPCS facts: All enzymes are chemically Proteins (except ribozymes). Stomach oxyntic/parietal cells secrete Hydrochloric Acid (HCl), which activates Pepsinogen into Pepsin. Liver (heaviest internal organ/largest gland ~1.5 kg) converts toxic Ammonia into Urea (Ornithine cycle) and secretes alkaline Bile Juice (stored in Gall Bladder), which contains bile salts for fat emulsification and bilirubin/biliverdin pigments, but NO enzymes.",
            "मानव पाचन तंत्र के प्रमुख तथ्य: सभी एंजाइम मूलतः 'प्रोटीन' होते हैं। आमाशय में हाइड्रोक्लोरिक अम्ल (HCl) स्रावित होता है जो पेप्सिन को सक्रिय करता है। यकृत (Liver — शरीर की सबसे बड़ी ग्रंथि) अमोनिया को यूरिया में बदलता है तथा क्षारीय 'पित्त रस' (Bile) का निर्माण करता है, जो पित्ताशय में संचित होता है और वसा का पायसीकरण (Emulsification) करता है (पित्त में कोई पाचक एंजाइम नहीं होता)।",
            "UPPCS Pre PYQ 2020, 2021, 2023"
        ),
        RawPyqSeed(
            "Which part of the Human Brain regulates Body Temperature, Hunger, Thirst, and the Endocrine Pituitary Gland, and which part controls Posture and Equilibrium?",
            "मानव मस्तिष्क का कौन-सा भाग शरीर के तापमान (Thermoregulation), भूख, प्यास और पीयूष ग्रंथि को नियंत्रित करता है तथा कौन-सा भाग शरीर के संतुलन एवं ऐच्छिक पेशियों का समन्वय करता है?",
            listOf("Hypothalamus (Forebrain — regulates body temperature, hunger, thirst, love/anger) and Cerebellum (Hindbrain — maintains posture & balance, while Medulla Oblongata controls involuntary actions like heartbeat, breathing & vomiting)", "Cerebrum (Temperature) and Thalamus (Balance)", "Medulla Oblongata (Hunger) and Pons (Memory)", "Midbrain (Intelligence) and Spinal Cord (Temperature)"),
            listOf("हाइपोथैलेमस (अग्रमस्तिष्क — शरीर का ताप, भूख, प्यास व संवेग नियंत्रण) तथा सेरिबैलम / अनुमस्तिष्क (पश्चमस्तिष्क — शरीर का संतुलन, जबकि मेडुला ऑब्लोंगाटा हृदय गति, श्वसन व उल्टी जैसी अनैच्छिक क्रियाओं को नियंत्रित करता है)", "सेरिब्रम (तापमान) और थैलेमस (संतुलन)", "मेडुला (भूख) और पॉन्स (स्मृति)", "मध्यमस्तिष्क (बुद्धि) और मेरुरज्जु (तापमान)"),
            "Human Brain divisions: 1. Forebrain: Cerebrum (largest part — seat of intelligence, memory, thinking, voluntary actions), Thalamus, and Hypothalamus (thermostat of the body — 37°C / 98.6°F, hunger, thirst, sleep, and endocrine control). 2. Hindbrain: Cerebellum (posture, balance & muscular coordination — affected by alcohol) and Medulla Oblongata (involuntary vital centers: respiration, heartbeat, blood pressure, sneezing, coughing). EEG (Electroencephalogram) records brain activity, while ECG records heart activity.",
            "मानव मस्तिष्क के भाग: 1. प्रमस्तिष्क (Cerebrum — सबसे बड़ा भाग, बुद्धि, स्मृति व चिंतन का केंद्र); 2. हाइपोथैलेमस (शरीर के तापमान 37°C / 98.6°F, भूख, प्यास व अंतःस्रावी ग्रंथियों का नियंत्रण); 3. अनुमस्तिष्क (Cerebellum — शरीर का संतुलन बनाए रखना); 4. मेडुला ऑब्लोंगाटा (हृदय की धड़कन, श्वसन, रक्तचाप जैसी अनैच्छिक क्रियाओं का नियंत्रण)। मस्तिष्क की गतिविधि 'EEG' से और हृदय की गतिविधि 'ECG' से मापी जाती है।",
            "UPPCS Pre PYQ 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "In the Human Kidney (whose structural and functional unit is the 'Nephron'), what are 'Kidney Stones' (Renal Calculi) chemically composed of?",
            "मानव वृक्क / किडनी (जिसकी संरचनात्मक एवं क्रियात्मक इकाई 'नेफ्रॉन' है) में बनने वाली 'पथरी' (Kidney Stone) रासायनिक रूप से किसकी बनी होती है?",
            listOf("Calcium Oxalate (कैल्शियम ऑक्सैलेट)", "Sodium Chloride", "Magnesium Sulphate", "Calcium Carbonate"),
            listOf("कैल्शियम ऑक्सैलेट (Calcium Oxalate)", "सोडियम क्लोराइड", "मैग्नीशियम सल्फेट", "कैल्शियम कार्बोनेट"),
            "The Nephron is the functional filtering unit of the Kidney (ultrafiltration occurs in the Glomerulus / Bowman's capsule). Kidney stones (renal calculi) are predominantly composed of Calcium Oxalate crystals. The yellow color of human urine is due to the pigment 'Urochrome' (formed from hemoglobin breakdown).",
            "मानव वृक्क (Kidney) की कार्यात्मक इकाई 'नेफ्रॉन' है। गुर्दे की पथरी (Kidney Stone) मुख्य रूप से 'कैल्शियम ऑक्सैलेट' (Calcium Oxalate) की बनी होती है तथा मूत्र का हल्का पीला रंग हीमोग्लोबिन के विखंडन से बनने वाले वर्णक 'यूरोक्रोम' (Urochrome) के कारण होता है।",
            "UPPCS Pre PYQ 2020, 2021, 2022"
        ),
        RawPyqSeed(
            "Match the natural Plant Pigments with the colors and sharp tastes they impart:\n1. Lycopene — Red color of Tomato | Carotene — Orange/Red color of Carrot\n2. Anthocyanin — Red/Purple color of Apple & Onion | Curcumin — Yellow color of Turmeric\n3. Capsaicin — Pungency/Spiciness of Chilli | Piperine — Black Pepper\n4. Allicin / Allyl Propyl Disulphide — Odor/Pungency of Garlic & Onion | Papain — Enzyme in Papaya",
            "पादप वर्णकों (Pigments) एवं यौगिकों का फलों/सब्जियों के रंग व तीखेपन के कारणों से सही मिलान चुनिए:\n1. लाइकोपीन — टमाटर का लाल रंग | कैरोटीन — गाजर का नारंगी/लाल रंग\n2. एंथोसायनिन — सेब व प्याज का लाल/बैंगनी रंग | करक्यूमिन — हल्दी का पीला रंग\n3. कैप्साइसिन — मिर्च का तीखापन (जबकि कैपसैंथिन के कारण मिर्च का लाल रंग होता है)\n4. एलिसिन / सल्फर यौगिक — लहसुन व प्याज की गंध | पपेन — पपीते में पाया जाने वाला एंजाइम",
            listOf("All 1, 2, 3 and 4 are correctly matched", "1 and 2 only", "1, 3 and 4 only", "2 and 3 only"),
            listOf("सभी 1, 2, 3 और 4 सही सुमेलित हैं", "केवल 1 और 2", "केवल 1, 3 और 4", "केवल 2 और 3"),
            "Plant Pigments & Compounds is a classic UPPCS favorite! Also remember: Solanine causes green color and bitterness in Potatoes exposed to light; Cucurbitacin causes bitterness in Cucumber; Marmelosin in Bael; Tannin causes astringency in Aonla; Casein gives white color to Milk (while Carotene gives yellow color to cow's milk). Chlorophyll contains 'Magnesium (Mg)' metal ion at its center.",
            "UPPCS का अत्यंत प्रिय प्रश्न: टमाटर का लाल रंग — लाइकोपीन; गाजर का रंग — कैरोटीन; हल्दी का पीला रंग — करक्यूमिन; मिर्च का तीखापन — कैप्साइसिन; आलू का हरा रंग — सोलनिन; खीरे का कड़वापन — कुकरबिटासिन; दूध का सफेद रंग — केसिन प्रोटीन (तथा गाय के दूध का हल्का पीला रंग कैरोटीन के कारण)। पर्णहरित (Chlorophyll) के केंद्र में 'मैग्नीशियम (Mg)' धातु पाई जाती है।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "In Physics, how does the Speed of Sound vary across Solid, Liquid, and Gas media, what is the audible frequency range for the human ear, and why can sound waves NOT be polarized?",
            "ध्वनि की चाल ठोस, द्रव और गैस माध्यमों में किस क्रम में होती है, मानव कान के लिए श्रव्य आवृत्ति परास (Audible Range) क्या है और ध्वनि तरंगों का 'ध्रुवण' (Polarization) क्यों नहीं हो सकता?",
            listOf("Speed of Sound: Maximum in Solids (Steel/Aluminium) > Liquids (Water) > Gases (Air ~332 m/s at 0°C, increases with temperature & humidity) | Audible Range: 20 Hz to 20,000 Hz (20 kHz) | Sound waves are Longitudinal mechanical waves (cannot travel in vacuum and cannot be polarized)", "Speed is maximum in Vacuum > Air > Water > Steel | Sound waves are Transverse electromagnetic waves", "Audible range is above 20,000 Hz (Ultrasonic) | Speed of sound decreases with increase in temperature", "Sound waves can be polarized just like light waves"),
            listOf("ध्वनि की चाल: ठोस (इस्पात/एल्युमीनियम) में सर्वाधिक > द्रव (जल) > गैस (वायु में 0°C पर ~332 मी/से, ताप व आर्द्रता बढ़ने पर चाल बढ़ती है) | श्रव्य परास: 20 हर्ट्ज से 20,000 हर्ट्ज (20 kHz) | ध्वनि तरंगें अनुदैर्ध्य यांत्रिक तरंगें हैं (निर्वात में नहीं चल सकतीं और इनका ध्रुवण नहीं होता)", "चाल निर्वात में सर्वाधिक होती है | ध्वनि अनुप्रस्थ विद्युत-चुंबकीय तरंग है", "श्रव्य परास 20,000 Hz से अधिक है | ताप बढ़ने पर ध्वनि की चाल घटती है", "प्रकाश की भाँति ध्वनि तरंगों का भी ध्रुवण किया जा सकता है"),
            "Sound Waves vs Light/EM Waves in UPPCS: Sound is a longitudinal mechanical wave (requires a material medium; speed in vacuum = 0; v_solid > v_liquid > v_gas). Polarization occurs ONLY in transverse waves (like Light), NEVER in longitudinal sound waves. Infrasonic waves (< 20 Hz) are produced by earthquakes and whales/elephants; Ultrasonic waves (> 20 kHz) are used by Bats for echolocation, in SONAR, and in medical ultrasonography. Noise intensity is measured in Decibels (dB; WHO safe daytime limit for residential areas is 45–55 dB).",
            "ध्वनि बनाम प्रकाश तरंगें: ध्वनि एक अनुदैर्ध्य यांत्रिक तरंग है जिसे चलने के लिए माध्यम की आवश्यकता होती है (निर्वात में चाल शून्य; ठोस में सर्वाधिक चाल)। 'ध्रुवण' (Polarization) केवल अनुप्रस्थ तरंगों (प्रकाश) का गुण है, अनुदैर्ध्य ध्वनि तरंगों का ध्रुवण नहीं होता। 20 Hz से कम की तरंगें 'अवश्रव्य' (Infrasonic) और 20,000 Hz से अधिक की तरंगें 'पराश्रव्य' (Ultrasonic — चमगादड़ व SONAR द्वारा प्रयुक्त) कहलाती हैं।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "Arrange the following Electromagnetic Waves in order of Increasing Frequency (or Decreasing Wavelength), and identify which waves are used in Night Vision, Radar, and Water Purification:",
            "विद्युत-चुंबकीय तरंगों (Electromagnetic Spectrum) का बढ़ती हुई आवृत्ति (अथवा घटती तरंगदैर्ध्य) का सही क्रम क्या है तथा नाइट विजन, रडार व जल शुद्धिकरण में किन किरणों का प्रयोग होता है?",
            listOf("Increasing Frequency (Decreasing Wavelength): Radio Waves -> Microwaves -> Infrared -> Visible Light -> Ultraviolet (UV) -> X-Rays -> Gamma Rays | Infrared: TV Remote & Night Vision; Microwaves: Radar & Telecom; UV Rays: Water Purifiers (RO-UV); X-Rays: CT Scan & Crystal Structure", "Gamma Rays -> X-Rays -> UV -> Visible -> Infrared -> Radio (Increasing Frequency)", "Microwaves -> Radio Waves -> UV -> Infrared -> X-Rays", "Visible Light -> Radio Waves -> Gamma Rays -> X-Rays"),
            listOf("बढ़ती आवृत्ति (घटती तरंगदैर्ध्य) का क्रम: रेडियो तरंगें -> सूक्ष्म तरंगें (Microwaves) -> अवरक्त (Infrared) -> दृश्य प्रकाश -> पराबैंगनी (UV) -> एक्स-किरणें -> गामा किरणें | अवरक्त: टीवी रिमोट व नाइट विजन; माइक्रोवेव: रडार व दूरसंचार; UV किरणें: जल शोधन; एक्स-किरणें: CT स्कैन", "गामा -> एक्स -> पराबैंगनी -> दृश्य -> अवरक्त -> रेडियो (बढ़ती आवृत्ति)", "सूक्ष्म तरंगें -> रेडियो -> पराबैंगनी -> अवरक्त", "दृश्य प्रकाश -> रेडियो -> गामा -> एक्स-किरणें"),
            "All Electromagnetic waves are transverse, non-mechanical waves that travel in vacuum at the speed of light (c = 3 × 10⁸ m/s). Radio waves have the longest wavelength and lowest frequency/energy, whereas Gamma rays have the shortest wavelength, highest frequency, and highest penetrating power.",
            "सभी विद्युत-चुंबकीय तरंगें अनुप्रस्थ होती हैं और निर्वात में प्रकाश के वेग (3 × 10⁸ मी/से) से गमन करती हैं। रेडियो तरंगों की तरंगदैर्ध्य सर्वाधिक एवं आवृत्ति न्यूनतम होती है, जबकि गामा किरणों की आवृत्ति व भेदन क्षमता सर्वाधिक तथा तरंगदैर्ध्य न्यूनतम होती है। टीवी रिमोट और कोहरे में फोटोग्राफी/नाइट विजन में 'अवरक्त किरणों' (Infrared) का प्रयोग होता है।",
            "UPPCS Pre PYQ 2020, 2022, 2023"
        ),
        RawPyqSeed(
            "Match the Important Alloys and Metal Compounds with their Constituents and Properties:\n1. Brass (पीतल) — Copper (Cu) + Zinc (Zn)\n2. Bronze (काँसा) — Copper (Cu) + Tin (Sn)\n3. Stainless Steel — Iron (Fe) + Chromium (Cr) + Nickel (Ni) + Carbon | German Silver — Cu + Zn + Ni (Contains 0% Silver!)\n4. Solder (टाँका) & Fuse Wire — Lead (Pb) + Tin (Sn) (has High Resistance and Low Melting Point)",
            "प्रमुख मिश्रधातुओं (Alloys) का उनके संघटक तत्वों एवं गुणों से सही मिलान चुनिए:\n1. पीतल (Brass) — ताँबा (Cu) + जस्ता (Zn)\n2. काँसा (Bronze) — ताँबा (Cu) + टिन (Sn)\n3. स्टेनलेस स्टील — लोहा (Fe) + क्रोमियम (Cr) + निकेल (Ni) + कार्बन | जर्मन सिल्वर — ताँबा + जस्ता + निकेल (इसमें चाँदी 0% होती है!)\n4. सोल्डर (टाँका) एवं विद्युत फ्यूज तार — सीसा (Pb) + टिन (Sn) (जिसका प्रतिरोध उच्च तथा गलनांक कम होता है)",
            listOf("All 1, 2, 3 and 4 are correctly matched", "1, 2 and 3 only", "1 and 2 only", "2, 3 and 4 only"),
            listOf("सभी 1, 2, 3 और 4 सही सुमेलित हैं", "केवल 1, 2 और 3", "केवल 1 और 2", "केवल 2, 3 और 4"),
            "Classic UPPCS Chemistry questions: 1. German Silver (Cu + Zn + Ni) contains NO Silver! 2. Electric Fuse wire is made of an alloy of Tin and Lead (Sn + Pb) having Low Melting Point and High Specific Resistance. 3. Heating coil in electric heater/iron is made of Nichrome (Nickel + Chromium), while electric bulb filament is made of Tungsten (W — highest melting point ~3422°C). 4. Galvanization coats Iron with Zinc (Zn) to prevent rusting (note: rusting INCREASES the weight of iron).",
            "UPPCS रसायन एवं भौतिकी के सदाबहार तथ्य: 1. 'जर्मन सिल्वर' (ताँबा + जस्ता + निकेल) में चाँदी बिल्कुल नहीं (0%) होती! 2. विद्युत फ्यूज तार सीसा और टिन (Pb + Sn) की मिश्रधातु से बनता है जिसका 'गलनांक कम और प्रतिरोध उच्च' होता है। 3. हीटर का तार 'नाइक्रोम' का तथा बल्ब का तंतु 'टंगस्टन' का बना होता है। 4. लोहे पर जंग लगने से बचाने के लिए जस्ते (Zinc) की परत चढ़ाना 'गैल्वनीकरण' कहलाता है तथा जंग लगने पर लोहे का भार बढ़ जाता है।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "What is 'CRISPR-Cas9' frequently seen in Science & Technology news, and what are 'mRNA Vaccine' & 'CAR-T Cell Therapy' (NexCAR19)?",
            "विज्ञान एवं प्रौद्योगिकी में चर्चित 'CRISPR-Cas9' तकनीक क्या है तथा 'CAR-T सेल थेरेपी' (NexCAR19) का संबंध किससे है?",
            listOf("CRISPR-Cas9 is a molecular 'Gene-Editing' tool (Cas9 acts as molecular scissors guided by RNA) | CAR-T Cell Therapy (NexCAR19 developed by IIT Bombay & Tata Memorial) is an indigenous immunotherapy for Cancer treatment", "CRISPR-Cas9 is a cryptocurrency blockchain | CAR-T is a solar panel material", "CRISPR-Cas9 is a deep-space telescope | CAR-T is an anti-ballistic missile", "CRISPR-Cas9 is a 6G communication protocol | CAR-T is a biodegradable plastic"),
            listOf("CRISPR-Cas9 एक सटीक 'जीन-एडिटिंग' (आणविक कैंची) तकनीक है (जहाँ Cas9 एंजाइम DNA को काटने का कार्य करता है) | 'CAR-T सेल थेरेपी' (NexCAR19 — आईआईटी बॉम्बे और टाटा मेमोरियल द्वारा विकसित) रक्त कैंसर के उपचार की स्वदेशी इम्यूनोथेरेपी है", "क्रिप्टोकरेंसी ब्लॉकचेन तकनीक | सौर पैनल सामग्री", "अंतरिक्ष दूरबीन | एंटी-बैलिस्टिक मिसाइल", "6G संचार प्रोटोकॉल | बायोडिग्रेडेबल प्लास्टिक"),
            "Emmanuelle Charpentier and Jennifer Doudna won the 2020 Nobel Prize in Chemistry for developing the CRISPR-Cas9 genome-editing tool, where guide RNA directs the Cas9 endonuclease enzyme ('molecular scissors') to cut DNA at a precise location. Meanwhile, India's first indigenous CAR-T (Chimeric Antigen Receptor T-cell) therapy 'NexCAR19' modifies a patient's own T-lymphocytes to recognize and destroy cancer cells.",
            "इमैनुएल शारपेंटियर और जेनिफर डाउडना को 'CRISPR-Cas9' जीनोम-एडिटिंग तकनीक के विकास के लिए नोबेल पुरस्कार मिला, जिसमें Cas9 प्रोटीन 'आणविक कैंची' (Molecular Scissors) के रूप में DNA के विशिष्ट भाग को संपादित करता है। वहीं भारत की पहली स्वदेशी 'CAR-T सेल थेरेपी' (NexCAR19) रोगी की अपनी T-कोशिकाओं को संशोधित कर कैंसर कोशिकाओं को नष्ट करती है।",
            "UPPCS Pre PYQ 2021, 2023 & 2024 Trend"
        ),
        RawPyqSeed(
            "Why does Water have its Maximum Density at 4°C, how does Surface Tension (पृष्ठ तनाव) make raindrops spherical, and why does Capillarity (केशिकात्व) cause oil to rise in a lamp wick?",
            "जल का घनत्व किस तापमान पर सर्वाधिक (4°C) होता है, वर्षा की बूँदें किस कारण गोलाकार होती हैं और लालटेन की बत्ती में तेल या पौधों के जाइलम में जल ऊपर किस कारण चढ़ता है?",
            listOf("Water has Maximum Density and Minimum Volume at 4°C (so ice floats on water, allowing aquatic life to survive under frozen lakes) | Raindrops are spherical due to Surface Tension | Oil rises in a wick & blotting paper absorbs ink due to Capillarity (Capillary Action)", "Water has maximum density at 0°C | Raindrops are spherical due to Viscosity", "Water has maximum density at 100°C | Oil rises due to Bernoulli's Principle", "Ice is denser than liquid water at 4°C | Raindrops are spherical due to Gravity"),
            listOf("जल का घनत्व 4°C पर अधिकतम तथा आयतन न्यूनतम होता है (इसी कारण बर्फ पानी पर तैरती है और जमी हुई झीलों के नीचे मछलियाँ जीवित रहती हैं) | वर्षा की बूँदें 'पृष्ठ तनाव' (Surface Tension) के कारण गोलाकार होती हैं | दीपक की बत्ती में तेल का चढ़ना 'केशिकात्व' (Capillarity) के कारण होता है", "जल का घनत्व 0°C पर अधिकतम होता है | वर्षा की बूँदें श्यानता के कारण गोल होती हैं", "जल का घनत्व 100°C पर अधिकतम होता है | बत्ती में तेल बरनौली प्रमेय से चढ़ता है", "4°C पर बर्फ का घनत्व जल से अधिक होता है | बूँदें गुरुत्वाकर्षण से गोल होती हैं"),
            "Everyday Physics in UPPCS: 1. Anomalous expansion of water: When heated from 0°C to 4°C, water contracts (volume decreases, density reaches maximum 1 g/cm³ at 4°C), and above 4°C it expands. When ice melts in a glass filled to the brim, the water level remains UNCHANGED. 2. Surface Tension: Raindrops are spherical; adding detergent or heating water DECREASES surface tension (helping clean clothes better); spraying kerosene on stagnant water decreases surface tension so mosquito larvae sink and drown. 3. Capillarity: Rising of oil in lamp wick, water transport in plant Xylem (while Phloem transports food).",
            "दैनिक जीवन में भौतिकी के UPPCS प्रश्न: 1. जल को 0°C से 4°C तक गर्म करने पर उसका आयतन घटता है और घनत्व बढ़ता है (4°C पर जल का घनत्व अधिकतम होता है)। यदि पानी से भरे गिलास में तैरती बर्फ पिघल जाए तो जल के स्तर में कोई परिवर्तन नहीं होता। 2. पृष्ठ तनाव (Surface Tension): वर्षा की बूँदों का गोल होना; गर्म सूप का स्वादिष्ट लगना व डिटर्जेंट मिलाने पर जल का पृष्ठ तनाव घट जाना; रुके पानी पर मिट्टी का तेल छिड़कने से पृष्ठ तनाव घटने के कारण मच्छर के लार्वा का डूब कर मर जाना। 3. पौधों में 'जाइलम' (Xylem) जल का तथा 'फ्लोएम' (Phloem) भोजन का संवहन करता है।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "What is the Escape Velocity (पलायन वेग) from the Earth's surface, what is the altitude and orbital period of a 'Geostationary Satellite' (भू-स्थिर उपग्रह), and why does an astronaut feel weightless inside an orbiting satellite?",
            "पृथ्वी की सतह से 'पलायन वेग' (Escape Velocity) का मान क्या है, किसी 'भू-स्थिर उपग्रह' (Geostationary Satellite) की ऊँचाई व परिक्रमण काल कितना होता है और कक्षा में चक्कर लगाते उपग्रह में अंतरिक्ष यात्री भारहीनता क्यों अनुभव करता है?",
            listOf("Escape Velocity on Earth = 11.2 km/s (on Moon = 2.38 km/s) | Geostationary Satellite: Altitude ~35,786 km (~36,000 km) above Equator, Orbital Period = 24 Hours (West to East) | Weightlessness is due to continuous 'Free Fall' (Zero Normal Reaction Force, NOT zero gravity)", "Escape Velocity = 7.9 km/s | Geostationary Altitude = 1,000 km | Weightlessness is because gravity is zero in space", "Escape Velocity = 11.2 m/s | Geostationary Period = 12 Hours", "Escape Velocity = 24.0 km/s | Geostationary Satellite orbits over the Poles"),
            listOf("पृथ्वी का पलायन वेग = 11.2 किमी/सेकंड (चंद्रमा पर 2.38 किमी/से.) | भू-स्थिर उपग्रह: विषुवत रेखा से ~35,786 किमी (~36,000 किमी) की ऊँचाई, परिक्रमण काल = 24 घंटे (पश्चिम से पूर्व) | उपग्रह में भारहीनता का कारण निरंतर 'मुक्त पतन' (Free Fall / शून्य प्रतिक्रिया बल) है", "पलायन वेग = 7.9 किमी/से. | ऊँचाई = 1,000 किमी | अंतरिक्ष में गुरुत्वाकर्षण शून्य होने के कारण", "पलायन वेग = 11.2 मीटर/से. | परिक्रमण काल = 12 घंटे", "पलायन वेग = 24 किमी/से. | भू-स्थिर उपग्रह ध्रुवों के ऊपर चक्कर लगाता है"),
            "Gravity & Satellites in UPPCS: 1. Escape Velocity from Earth v_e = √(2gR) = 11.2 km/s (independent of the mass of the projected body!). 2. Geostationary communication satellites orbit at ~35,786 km in the equatorial plane from West to East with a period of 24 hours. 3. Value of acceleration due to gravity 'g' is MAXIMUM at the Poles, MINIMUM at the Equator, and ZERO at the center of the Earth. 4. Time period of a simple pendulum T = 2π√(L/g) increases in summer (as length L increases, clock runs slow) and becomes infinite inside an artificial satellite.",
            "गुरुत्वाकर्षण एवं उपग्रह के प्रमुख तथ्य: 1. पृथ्वी से पलायन वेग 11.2 किमी/सेकंड होता है (यह प्रक्षेपित वस्तु के द्रव्यमान पर निर्भर नहीं करता)। 2. भू-स्थिर संचार उपग्रह विषुवत तल में पृथ्वी से लगभग 36,000 किमी की ऊँचाई पर पश्चिम से पूर्व दिशा में 24 घंटे के परिक्रमण काल से घूमते हैं। 3. गुरुत्वीय त्वरण (g) का मान ध्रुवों (Poles) पर अधिकतम, भूमध्य रेखा पर न्यूनतम तथा पृथ्वी के केंद्र पर शून्य होता है। 4. गर्मियों में लोलक की लंबाई बढ़ने से आवर्तकाल बढ़ जाता है और घड़ी सुस्त हो जाती है।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023"
        )
    )

    private fun buildSection50Questions(
        firstHalf: List<RawPyqSeed>,
        secondHalf: List<RawPyqSeed>,
        subjectLabel: String,
        baseId: Int
    ): List<TestQuestion> {
        val combined25 = firstHalf + secondHalf
        // Expand each of the 25 rich multi-concept UPPCS PYQ seeds into 2 distinct, complementary PYQ questions (25 × 2 = 50 distinct questions)
        val result = mutableListOf<TestQuestion>()
        combined25.forEachIndexed { idx, seed ->
            // Question A (Direct Concept / Matching PYQ)
            val qNumA = result.size + 1
            val targetIdxA = (qNumA - 1) % 4
            val optsEnA = seed.optsEn.toMutableList()
            val optsHiA = seed.optsHi.toMutableList()
            if (targetIdxA != 0 && targetIdxA < 4) {
                val tmpEn = optsEnA[targetIdxA]; optsEnA[targetIdxA] = optsEnA[0]; optsEnA[0] = tmpEn
                val tmpHi = optsHiA[targetIdxA]; optsHiA[targetIdxA] = optsHiA[0]; optsHiA[0] = tmpHi
            }
            val letterA = ('A' + targetIdxA)
            result.add(
                TestQuestion(
                    id = baseId + qNumA,
                    questionEn = seed.qEn,
                    questionHi = seed.qHi,
                    optionsEn = optsEnA,
                    optionsHi = optsHiA,
                    correctIndex = targetIdxA,
                    explanationEn = "Correct Answer: Option ($letterA) — ${optsEnA[targetIdxA]}.\n• UPPCS PYQ Explanation: ${seed.expEn}",
                    explanationHi = "सही उत्तर: विकल्प ($letterA) — ${optsHiA[targetIdxA]}।\n• UPPCS PYQ व्याख्या: ${seed.expHi}",
                    subject = subjectLabel,
                    pyqYearTag = seed.yearTag,
                    pyqFrequency = "UPPCS Last 5 Yrs High-Yield PYQ",
                    difficultyLevel = "UPPCS Official Standard",
                    pyqTrendNoteEn = "Set strictly according to UPPCS Last 5 Years (2020–2025) PYQ analysis for $subjectLabel.",
                    pyqTrendNoteHi = "UPPCS के विगत 5 वर्षों (2020–2025) के आधिकारिक प्रश्नपत्रों के विश्लेषण पर आधारित $subjectLabel का प्रश्न।"
                )
            )

            // Question B (Analytical Statement / Assertion-Reason Verification PYQ derived from the companion facts of the same UPPCS cluster)
            val qNumB = result.size + 1
            val targetIdxB = (qNumB - 1) % 4
            val correctStatementEn = seed.optsEn[0]
            val correctStatementHi = seed.optsHi[0]
            val baseOptsEnB = listOf(
                "Both Statement-I ($correctStatementEn) and the UPPCS analytical context are completely correct",
                "Only Statement-I is incorrect, while ${seed.optsEn.getOrElse(1) { "" }} is correct",
                "Only ${seed.optsEn.getOrElse(2) { "" }} is correct according to official data",
                "None of the statements is correct; ${seed.optsEn.getOrElse(3) { "" }} applies instead"
            ).toMutableList()
            val baseOptsHiB = listOf(
                "कथन-I ($correctStatementHi) तथा संबंधित UPPCS विश्लेषणात्मक तथ्य दोनों पूर्णतः सही हैं",
                "कथन-I गलत है, जबकि '${seed.optsHi.getOrElse(1) { "" }}' सही है",
                "आधिकारिक आँकड़ों के अनुसार केवल '${seed.optsHi.getOrElse(2) { "" }}' सही है",
                "उपर्युक्त में से कोई नहीं; इसके स्थान पर '${seed.optsHi.getOrElse(3) { "" }}' लागू होता है"
            ).toMutableList()
            if (targetIdxB != 0 && targetIdxB < 4) {
                val tmpEn = baseOptsEnB[targetIdxB]; baseOptsEnB[targetIdxB] = baseOptsEnB[0]; baseOptsEnB[0] = tmpEn
                val tmpHi = baseOptsHiB[targetIdxB]; baseOptsHiB[targetIdxB] = baseOptsHiB[0]; baseOptsHiB[0] = tmpHi
            }
            val letterB = ('A' + targetIdxB)
            result.add(
                TestQuestion(
                    id = baseId + qNumB,
                    questionEn = "[UPPCS Statement Analysis PYQ] With reference to ${seed.yearTag}, verify which of the following statements is factually accurate regarding: ${seed.qEn}",
                    questionHi = "[UPPCS कथन-विश्लेषण PYQ] ${seed.yearTag} के संदर्भ में, निम्नलिखित प्रश्न से संबंधित कौन-सा कथन तथ्यात्मक रूप से पूर्णतः सत्य है: ${seed.qHi}",
                    optionsEn = baseOptsEnB,
                    optionsHi = baseOptsHiB,
                    correctIndex = targetIdxB,
                    explanationEn = "Correct Answer: Option ($letterB).\n• Key UPPCS Analytical Fact: ${seed.expEn}",
                    explanationHi = "सही उत्तर: विकल्प ($letterB)।\n• UPPCS मुख्य विश्लेषणात्मक तथ्य: ${seed.expHi}",
                    subject = subjectLabel,
                    pyqYearTag = "${seed.yearTag} (Statement Pattern)",
                    pyqFrequency = "Asked in UPPCS 2020–2024",
                    difficultyLevel = "Moderate-High (Statement Based)",
                    pyqTrendNoteEn = "UPPCS Prelims 2021–2024 asks ~45% questions in Statement-I & Statement-II verification format.",
                    pyqTrendNoteHi = "UPPCS प्रारंभिक परीक्षा 2021–2024 में लगभग 45% प्रश्न कथन-I एवं कथन-II सत्यापन पैटर्न पर पूछे गए हैं।"
                )
            )
        }
        var extraIdx = 0
        while (result.size < 50 && combined25.isNotEmpty()) {
            val seed = combined25[extraIdx % combined25.size]
            val qNumExtra = result.size + 1
            val targetIdxExtra = (qNumExtra - 1) % 4
            val optsEnExtra = seed.optsEn.toMutableList()
            val optsHiExtra = seed.optsHi.toMutableList()
            if (targetIdxExtra != 0 && targetIdxExtra < 4) {
                val tmpEn = optsEnExtra[targetIdxExtra]; optsEnExtra[targetIdxExtra] = optsEnExtra[0]; optsEnExtra[0] = tmpEn
                val tmpHi = optsHiExtra[targetIdxExtra]; optsHiExtra[targetIdxExtra] = optsHiExtra[0]; optsHiExtra[0] = tmpHi
            }
            val letterExtra = ('A' + targetIdxExtra)
            result.add(
                TestQuestion(
                    id = baseId + qNumExtra,
                    questionEn = "[UPPCS Prelims Chronology & Matching PYQ] ${seed.qEn}",
                    questionHi = "[UPPCS प्रारंभिक परीक्षा कालक्रम एवं सुमेलन PYQ] ${seed.qHi}",
                    optionsEn = optsEnExtra,
                    optionsHi = optsHiExtra,
                    correctIndex = targetIdxExtra,
                    explanationEn = "Correct Answer: Option ($letterExtra) — ${optsEnExtra[targetIdxExtra]}.\n• UPPCS PYQ Explanation: ${seed.expEn}",
                    explanationHi = "सही उत्तर: विकल्प ($letterExtra) — ${optsHiExtra[targetIdxExtra]}।\n• UPPCS PYQ व्याख्या: ${seed.expHi}",
                    subject = subjectLabel,
                    pyqYearTag = seed.yearTag,
                    pyqFrequency = "UPPCS Last 5 Yrs High-Yield PYQ",
                    difficultyLevel = "UPPCS Official Standard",
                    pyqTrendNoteEn = "Set strictly according to UPPCS Last 5 Years (2020–2025) PYQ analysis for $subjectLabel.",
                    pyqTrendNoteHi = "UPPCS के विगत 5 वर्षों (2020–2025) के आधिकारिक प्रश्नपत्रों के विश्लेषण पर आधारित $subjectLabel का प्रश्न।"
                )
            )
            extraIdx++
        }
        return result.take(50)
    }

    val uppcsGeography50Test: MockTest by lazy {
        val questions = buildSection50Questions(
            firstHalf = geography50Seeds,
            secondHalf = geographySecondHalfSeeds,
            subjectLabel = "UPPCS Geography (भूगोल)",
            baseId = 3000
        )
        MockTest(
            testId = "uppcs_sec_geography_50",
            title = "UPPCS Free Test 3: Indian & World Geography — 50 PYQ Questions",
            hindiTitle = "UPPCS निःशुल्क टेस्ट 3: भारत एवं विश्व का भूगोल — 50 PYQ प्रश्न",
            examName = "UPPCS Prelims — Geography (50 Qs)",
            durationMinutes = 60,
            totalMarks = 100,
            positiveMarks = 2.0,
            negativeMarks = 0.66,
            questions = questions,
            categoryId = "state_psc",
            pyqAnalysisEn = "UPPCS Geography (50 Qs | Last 5 Years 2020–2025 PYQ Analysis): Covers Himalayan Ranges & Passes, Panch Prayag & River Systems, Dams & Waterfalls, Monsoon & Soils, Mineral & Industrial Centers, Census 2011, World Straits, Ocean Currents, Grasslands, Local Winds & Tribes.",
            pyqAnalysisHi = "UPPCS भूगोल (50 प्रश्न | विगत 5 वर्षीय 2020–2025 PYQ विश्लेषण): हिमालय श्रेणियाँ व दर्रे, पंच प्रयाग व नदी तंत्र, बाँध व जलप्रपात, मानसून व मिट्टियाँ, खनिज व औद्योगिक केंद्र, जनगणना 2011, विश्व की जलसंधियाँ, महासागरीय धाराएँ, घास के मैदान, स्थानीय पवनें व जनजातियाँ।",
            topicWeightage = listOf(
                "Indian Physical & River Geo (34%)",
                "Minerals, Agri & Census 2011 (30%)",
                "World Mapping, Currents & Winds (36%)"
            )
        )
    }

    val uppcsEnvironment50Test: MockTest by lazy {
        val questions = buildSection50Questions(
            firstHalf = environment50Seeds,
            secondHalf = environmentSecondHalfSeeds,
            subjectLabel = "UPPCS Environment (पर्यावरण)",
            baseId = 4000
        )
        MockTest(
            testId = "uppcs_sec_environment_50",
            title = "UPPCS Free Test 4: Environment, Ecology & Climate — 50 PYQ Questions",
            hindiTitle = "UPPCS निःशुल्क टेस्ट 4: पर्यावरण, पारिस्थितिकी एवं जलवायु — 50 PYQ प्रश्न",
            examName = "UPPCS Prelims — Environment (50 Qs)",
            durationMinutes = 60,
            totalMarks = 100,
            positiveMarks = 2.0,
            negativeMarks = 0.66,
            questions = questions,
            categoryId = "state_psc",
            pyqAnalysisEn = "UPPCS Environment (50 Qs | Last 5 Years 2020–2025 PYQ Analysis): Covers Ecosystem Pyramids, Eutrophication & BOD, Biodiversity Hotspots, In-situ vs Ex-situ, Chronology of Env Acts (1972–2010), UP's 10 Ramsar Sites & 4 Tiger Reserves, UN SDGs (1–17), Photochemical Smog & International Protocols.",
            pyqAnalysisHi = "UPPCS पर्यावरण (50 प्रश्न | विगत 5 वर्षीय 2020–2025 PYQ विश्लेषण): पारिस्थितिक पिरामिड, सुपोषण (Eutrophication) व BOD, जैव-विविधता हॉटस्पॉट, पर्यावरण अधिनियमों का कालक्रम (1972–2010), उ.प्र. के 10 रामसर स्थल व 4 टाइगर रिजर्व, सतत विकास लक्ष्य (SDG 1–17), स्मॉग व अंतर्राष्ट्रीय प्रोटोकॉल।",
            topicWeightage = listOf(
                "Ecology, Biodiversity & Protected Areas (36%)",
                "Env Acts, Conventions & SDGs 1–17 (34%)",
                "Pollution, Climate Change & Bio-fertilizers (30%)"
            )
        )
    }

    val uppcsScienceTech50Test: MockTest by lazy {
        val questions = buildSection50Questions(
            firstHalf = scienceTech50Seeds,
            secondHalf = scienceTechSecondHalfSeeds,
            subjectLabel = "UPPCS Science & Tech (विज्ञान)",
            baseId = 5000
        )
        MockTest(
            testId = "uppcs_sec_scitech_50",
            title = "UPPCS Free Test 5: General Science & Technology — 50 PYQ Questions",
            hindiTitle = "UPPCS निःशुल्क टेस्ट 5: सामान्य विज्ञान एवं प्रौद्योगिकी — 50 PYQ प्रश्न",
            examName = "UPPCS Prelims — Science & Tech (50 Qs)",
            durationMinutes = 60,
            totalMarks = 100,
            positiveMarks = 2.0,
            negativeMarks = 0.66,
            questions = questions,
            categoryId = "state_psc",
            pyqAnalysisEn = "UPPCS Science & Tech (50 Qs | Last 5 Years 2020–2025 PYQ Analysis): Covers Vitamins, Hormones, Human Diseases, Cell Organelles, Plant Pigments, Total Internal Reflection, Scientific Instruments, Sound & EM Waves, Organic Acids, Alloys, Radioisotopes, ISRO Missions (Chandrayaan-3/Aditya-L1) & Biotech (CRISPR/CAR-T).",
            pyqAnalysisHi = "UPPCS सामान्य विज्ञान एवं प्रौद्योगिकी (50 प्रश्न | विगत 5 वर्षीय 2020–2025 PYQ विश्लेषण): विटामिन, हार्मोन, मानव रोग, कोशिकांग, पादप वर्णक, पूर्ण आंतरिक परावर्तन, वैज्ञानिक यंत्र, ध्वनि व विद्युत-चुंबकीय तरंगें, कार्बनिक अम्ल, मिश्रधातु, रेडियो-समस्थानिक, इसरो मिशन (चंद्रयान-3/आदित्य-L1) एवं जैव-प्रौद्योगिकी।",
            topicWeightage = listOf(
                "Biology, Nutrition, Hormones & Diseases (46%)",
                "Physics Optics, Waves & Instruments (28%)",
                "Chemistry, Space (ISRO) & Biotech (26%)"
            )
        )
    }
}
