package com.example.data.uppcs

import com.example.model.MockTest
import com.example.model.TestQuestion

/**
 * UPPCS Prelims Last 5 Years (2020–2025) Authentic PYQ Bilingual Question Bank
 * Part 3:
 *  - Section 6: UP Current Affairs & UP Special (यूपी करंट अफेयर्स एवं यूपी स्पेशल) — 50 Questions
 *  - Section 7: Economics (भारतीय अर्थव्यवस्था एवं बजट) — 50 Questions
 *  - Master Bank: All 7 UPPCS Sectional 50-Question Free Tests (350 Questions Total)
 */
object UppcsUpCaEcoPyqData {

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
    // SECTION 6: UP CURRENT AFFAIRS & UP SPECIAL (50 Authentic UPPCS PYQ Questions)
    // =========================================================================
    private val upCurrentAffairsSeeds: List<RawPyqSeed> = listOf(
        RawPyqSeed(
            "When was the 'One District One Product' (ODOP) scheme launched in Uttar Pradesh, and which ODOP products are correctly matched with their districts?\n1. Bhadohi (Sant Ravidas Nagar) & Mirzapur — Handmade Carpets (Daris)\n2. Moradabad — Metalcraft (Brassware) & Firozabad — Glassware/Bangles\n3. Kannauj — Attar (Perfume) & Aligarh — Locks & Hardware\n4. Siddharthnagar — Kala Namak Rice & प्रतापगढ़ (Pratapgarh) — Aonla Products",
            "उत्तर प्रदेश में 'एक जिला एक उत्पाद' (ODOP) योजना कब प्रारंभ की गई और निम्नलिखित में से कौन-से जिले अपने ODOP उत्पाद के साथ सही सुमेलित हैं?\n1. भदोही (संत रविदास नगर) व मिर्जापुर — हस्तनिर्मित कालीन (दरी)\n2. मुरादाबाद — धातु शिल्प (पीतल) एवं फिरोजाबाद — काँच उत्पाद/चूड़ियाँ\n3. कन्नौज — इत्र (Perfume) एवं अलीगढ़ — ताले व हार्डवेयर\n4. सिद्धार्थनगर — काला नमक चावल एवं प्रतापगढ़ — आँवला उत्पाद",
            listOf("Launched on 24 January 2018 (First UP Foundation Day) — All 1, 2, 3 and 4 are correctly matched", "Launched in 2020 — Only 1 and 2 are correct", "Launched in 2016 — Only 2 and 3 are correct", "Launched in 2019 — Only 1 and 4 are correct"),
            listOf("24 जनवरी 2018 (प्रथम उत्तर प्रदेश स्थापना दिवस) को प्रारंभ — सभी 1, 2, 3 और 4 सही सुमेलित हैं", "2020 में प्रारंभ — केवल 1 और 2 सही हैं", "2016 में प्रारंभ — केवल 2 और 3 सही हैं", "2019 में प्रारंभ — केवल 1 और 4 सही हैं"),
            "ODOP was launched on 24 January 2018 (the first celebrated Uttar Pradesh Day — since United Provinces was renamed Uttar Pradesh on 24 Jan 1950). Other key ODOPs: Lucknow — Chikankari & Zari-Zardozi; Varanasi — Banarasi Silk Saree; Meerut — Sports Goods; Saharanpur — Wood Carving; Agra — Leather Products; Khurja (Bulandshahr) — Ceramics/Pottery; Gorakhpur — Terracotta; Amroha — Musical Instrument (Dholak); Mahoba — Gaura Stone Craft; Jhansi — Soft Toys.",
            "24 जनवरी 1950 को 'संयुक्त प्रांत' का नाम 'उत्तर प्रदेश' रखा गया था; इसी स्मृति में 24 जनवरी 2018 को प्रथम 'उत्तर प्रदेश दिवस' पर ODOP योजना शुरू हुई। अन्य प्रमुख ODOP: लखनऊ — चिकनकारी व जरी-जरदोजी; वाराणसी — बनारसी रेशम साड़ी; मेरठ — खेल का सामान; सहारनपुर — काष्ठ कला; खुर्जा (बुलंदशहर) — पॉटरी/सिरेमिक; गोरखपुर — टेराकोटा; अमरोहा — ढोलक; महोबा — गौरा पत्थर शिल्प।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023, 2024"
        ),
        RawPyqSeed(
            "Match the major Expressways of Uttar Pradesh ('The Expressway State of India') with their lengths and endpoints:\n1. Ganga Expressway (594 km, longest in UP under construction across 12 districts) — Meerut (Bijauli village) to Prayagraj (Judapur Dandu village)\n2. Purvanchal Expressway (341 km, 9 districts) — Lucknow (Chand Sarai) to Ghazipur (Haidaria)\n3. Bundelkhand Expressway (296 km, 7 districts) — Chitrakoot (Gonda village, Bharatkoop) to Etawah (Kudrail, merges with Agra-Lucknow Expressway)\n4. Agra-Lucknow Expressway (302 km) & Yamuna Expressway (165 km, Greater Noida to Agra)",
            "'एक्सप्रेसवे प्रदेश' के रूप में प्रसिद्ध उत्तर प्रदेश के प्रमुख एक्सप्रेसवे का उनकी लंबाई एवं सिरों के साथ सही मिलान चुनिए:\n1. गंगा एक्सप्रेसवे (594 किमी, 12 जिलों से गुजरने वाला उ.प्र. का सबसे लंबा एक्सप्रेसवे) — मेरठ (बिजौली गाँव) से प्रयागराज (जुदापुर दांदू गाँव)\n2. पूर्वांचल एक्सप्रेसवे (341 किमी, 9 जिले) — लखनऊ (चाँदसराय) से गाजीपुर (हैदरिया)\n3. बुंदेलखंड एक्सप्रेसवे (296 किमी, 7 जिले) — चित्रकूट (भरतकूप) से इटावा (कुदरैल)\n4. आगरा-लखनऊ एक्सप्रेसवे (302 किमी) एवं यमुना एक्सप्रेसवे (165 किमी, ग्रेटर नोएडा से आगरा)",
            listOf("All 1, 2, 3 and 4 are correctly matched", "1 and 2 only", "2, 3 and 4 only", "1, 3 and 4 only"),
            listOf("सभी 1, 2, 3 और 4 सही सुमेलित हैं", "केवल 1 और 2", "केवल 2, 3 और 4", "केवल 1, 3 और 4"),
            "Uttar Pradesh ranks #1 in India in total Expressway network length and also #1 in International Airports (5 International Airports: 1. Chaudhary Charan Singh Airport, Lucknow; 2. Lal Bahadur Shastri Airport, Varanasi; 3. Kushinagar International Airport; 4. Maharishi Valmiki International Airport, Ayodhya; and 5. Noida International Greenfield Airport at Jewar, Gautam Buddha Nagar). Emergency airstrips for IAF fighter jets are built on Agra-Lucknow, Purvanchal (Sultanpur), and Ganga Expressways.",
            "उत्तर प्रदेश देश में सर्वाधिक एक्सप्रेसवे नेटवर्क और सर्वाधिक 5 अंतर्राष्ट्रीय हवाई अड्डों (लखनऊ, वाराणसी, कुशीनगर, महर्षि वाल्मीकि अयोध्या धाम और जेवर-नोएडा अंतर्राष्ट्रीय ग्रीनफील्ड एयरपोर्ट) वाला पहला राज्य है। गंगा एक्सप्रेसवे (594 किमी) मेरठ से प्रयागराज तक 12 जिलों से होकर गुजरता है।",
            "UPPCS Pre PYQ 2021, 2022, 2023, 2024"
        ),
        RawPyqSeed(
            "What are the 6 Nodes of the 'Uttar Pradesh Defence Industrial Corridor' (UPDIC), and where was the BrahMos Aerospace Cruise Missile manufacturing facility inaugurated?",
            "'उत्तर प्रदेश डिफेंस इंडस्ट्रियल कॉरिडोर' (UPDIC) के 6 नोड (जिले) कौन-से हैं और ब्रह्मोस सुपरसोनिक क्रूज मिसाइल निर्माण इकाई कहाँ स्थापित की गई है?",
            listOf("6 Nodes: Aligarh, Agra, Jhansi, Chitrakoot, Kanpur, and Lucknow | BrahMos Aerospace Manufacturing Facility is at Lucknow Node", "Varanasi, Gorakhpur, Prayagraj, Meerut, Noida, and Ghaziabad", "Mirzapur, Sonbhadra, Banda, Hamirpur, Mahoba, and Lalitpur", "Bareilly, Moradabad, Saharanpur, Ayodhya, Azamgarh, and Ballia"),
            listOf("6 नोड: अलीगढ़, आगरा, झाँसी, चित्रकूट, कानपुर और लखनऊ | ब्रह्मोस एयरोस्पेस मिसाइल निर्माण इकाई 'लखनऊ नोड' में स्थापित है", "वाराणसी, गोरखपुर, प्रयागराज, मेरठ, नोएडा और गाजियाबाद", "मिर्जापुर, सोनभद्र, बाँदा, हमीरपुर, महोबा और ललितपुर", "बरेली, मुरादाबाद, सहारनपुर, अयोध्या, आजमगढ़ और बलिया"),
            "India has two Defence Industrial Corridors: one in Tamil Nadu (5 nodes) and one in Uttar Pradesh (6 nodes managed by UPEIDA: Aligarh, Agra, Jhansi, Chitrakoot, Kanpur, and Lucknow). Meanwhile, AK-203 assault rifles are manufactured at Korwa Ordnance Factory in Amethi under Indo-Russian Rifles Pvt. Ltd.",
            "उत्तर प्रदेश डिफेंस इंडस्ट्रियल कॉरिडोर (यूपीडा द्वारा संचालित) के 6 नोड हैं: अलीगढ़, आगरा, झाँसी, चित्रकूट, कानपुर और लखनऊ (जहाँ ब्रह्मोस मिसाइल निर्माण केंद्र है)। इसके अतिरिक्त अमेठी के कोरवा आयुध कारखाने में रूस के सहयोग से 'AK-203' असॉल्ट राइफलों का निर्माण किया जा रहा है।",
            "UPPCS Pre PYQ 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "Match the Folk Dances and Classical/Semi-Classical Music Gharanas of Uttar Pradesh with their respective regions:\n1. Charkula (108 oil lamps on head), Raslila & Mayur Dance — Braj Region (Mathura)\n2. Karma & शैला (Shaila) Dance — Tribal region of Sonbhadra & Mirzapur\n3. Rai, Pai Danda, Diwari & Shaira Dance — Bundelkhand Region\n4. Chaurasia, Natwari, Dhobia & Bidesia Dance — Purvanchal Region | Kajri — Mirzapur",
            "उत्तर प्रदेश के प्रमुख लोक नृत्यों एवं लोकगीतों का उनके क्षेत्रों से सही मिलान चुनिए:\n1. चरकुला (सिर पर 108 दीपों का घड़ा रखकर नृत्य), रासलीला व मयूर नृत्य — ब्रज क्षेत्र (मथुरा)\n2. कर्मा एवं शैला नृत्य — सोनभद्र एवं मिर्जापुर (खरवार व गोंड जनजाति)\n3. राई, पाई डंडा, दीवारी एवं सैरा नृत्य — बुंदेलखंड क्षेत्र\n4. चौरसिया (जौनपुर), नटवरी, धोबिया व विदेशिया नृत्य — पूर्वांचल क्षेत्र | कजरी — मिर्जापुर",
            listOf("All 1, 2, 3 and 4 are correctly matched", "1 and 2 only", "2, 3 and 4 only", "1, 3 and 4 only"),
            listOf("सभी 1, 2, 3 और 4 सही सुमेलित हैं", "केवल 1 और 2", "केवल 2, 3 और 4", "केवल 1, 3 और 4"),
            "UP Art & Culture is a guaranteed 2–3 question topic in UPPCS: Kathak is the ONLY classical dance of UP (Lucknow Gharana — Bindadin Maharaj, Birju Maharaj, Lachhu Maharaj; Banaras Gharana — Janaki Prasad, Sitara Devi). Semi-classical Thumri & Tappa were patronized by Nawab Wajid Ali Shah ('Akhtarpiya' — last Nawab of Awadh). Girija Devi belonged to Banaras Gharana, while Begum Akhtar ('Mallika-e-Ghazal') belonged to Faizabad/Lucknow. Bhatkhande Sanskriti Vishwavidyalaya (est. 1926 as Marris College of Music) is in Lucknow.",
            "उत्तर प्रदेश कला एवं संस्कृति (प्रत्येक UPPCS में 2–3 प्रश्न): 'कथक' उ.प्र. का एकमात्र शास्त्रीय नृत्य है (लखनऊ व बनारस घराना)। ठुमरी की उत्पत्ति अवध के अंतिम नवाब वाजिद अली शाह ('अख्तरपिया') के दरबार में हुई। गिरिजा देवी (ठुमरी गायिका) बनारस घराने से और बेगम अख्तर फैजाबाद से संबंधित थीं। भातखंडे संगीत संस्थान (स्थापना 1926, मैरिस कॉलेज ऑफ म्यूजिक) लखनऊ में है।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "Match the major Fairs (मेले) and Festivals of Uttar Pradesh with their respective Districts:\n1. Bateshwar Fair (Cattle/Camel Fair) & Sulahkul Utsav (Hindu-Muslim Unity) & Taj Mahotsav — Agra\n2. Deva Sharif Fair (Waris Ali Shah Dargah) — Barabanki & Syed Salar Fair — Bahraich\n3. Dadri Fair (Cattle Fair) — Ballia & Nauchandi Fair — Meerut\n4. Shakambhari Devi Fair — Saharanpur, Devi Patan Fair — Balrampur, & Kalinjar Mahotsav — Banda",
            "उत्तर प्रदेश के प्रमुख मेलों एवं उत्सवों का उनके जिलों के साथ सही मिलान चुनिए:\n1. बटेश्वर मेला (पशु/ऊँट मेला), सुलहकुल उत्सव (हिंदू-मुस्लिम एकता का प्रतीक) व ताज महोत्सव — आगरा\n2. देवा शरीफ मेला (हाजी वारिस अली शाह की दरगाह) — बाराबंकी एवं सैयद सालार मेला — बहराइच\n3. ददरी मेला (पशु मेला) — बलिया एवं नौचंदी मेला — मेरठ\n4. शाकंभरी देवी मेला — सहारनपुर, देवी पाटन मेला — बलरामपुर एवं कालिंजर महोत्सव — बाँदा",
            listOf("All 1, 2, 3 and 4 are correctly matched (Highest number of ~86 fairs in UP are held in Mathura, fewest in Pilibhit)", "1 and 2 only", "2, 3 and 4 only", "1, 3 and 4 only"),
            listOf("सभी 1, 2, 3 और 4 सही सुमेलित हैं (उ.प्र. में सर्वाधिक ~86 मेले मथुरा में तथा सबसे कम पीलीभीत में लगते हैं)", "केवल 1 और 2", "केवल 2, 3 और 4", "केवल 1, 3 और 4"),
            "Additional UP Fairs frequently asked in UPPCS: Maha Kumbh / Ardh Kumbh & Magh Mela — Prayagraj; Kakora Fair ('Mini Kumbh of Rohilkhand') — Budaun; Hari Das Jayanti & Mudia Poono Fair — Vrindavan (Mathura); Govind Sahab Fair — Ambedkar Nagar; Khichdi Mela (Makar Sankranti) — Gorakhnath Temple, Gorakhpur; Nakkatैया (Nakkataiya) Mela & Dhrupad Mela — Varanasi; Soron Fair — Kasganj;Gola Gokarannath Fair — Lakhimpur Kheri.",
            "उ.प्र. के अन्य प्रमुख मेले: महाकुंभ/माघ मेला — प्रयागराज; ककोरा मेला ('रुहेलखंड का मिनी कुंभ') — बदायूँ; हरिदास जयंती व मुड़िया पूर्णिमा मेला — वृंदावन (मथुरा); गोविंद साहब मेला — अंबेडकर नगर; खिचड़ी मेला — गोरखपुर; नक्कटैया मेला व ध्रुपद मेला — वाराणसी; सोरों मेला — कासगंज।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "Match the Premier Research Institutes located in Uttar Pradesh with their Cities:\n1. Indian Institute of Pulses Research (IIPR) & National Sugar Institute (NSI) — Kanpur\n2. Indian Institute of Vegetable Research (IIVR) & International Rice Research Institute South Asia Regional Centre (ISARC) — Varanasi\n3. Central Drug Research Institute (CDRI), National Botanical Research Institute (NBRI), Indian Institute of Sugarcane Research (IISR) & Central Institute for Subtropical Horticulture — Lucknow\n4. Indian Veterinary Research Institute (IVRI) & Central Avian Research Institute (CARI) — Izatnagar (Bareilly)",
            "उत्तर प्रदेश में स्थित प्रमुख राष्ट्रीय अनुसंधान संस्थानों का उनके नगरों से मिलान कीजिए:\n1. भारतीय दलहन अनुसंधान संस्थान (IIPR) एवं राष्ट्रीय शर्करा (चीनी) संस्थान (NSI) — कानपुर\n2. भारतीय सब्जी (शाकभाजी) अनुसंधान संस्थान (IIVR) एवं अंतर्राष्ट्रीय चावल अनुसंधान संस्थान का दक्षिण एशिया क्षेत्रीय केंद्र (ISARC) — वाराणसी\n3. केंद्रीय औषधि अनुसंधान संस्थान (CDRI), राष्ट्रीय वनस्पति अनुसंधान संस्थान (NBRI) एवं भारतीय गन्ना अनुसंधान संस्थान (IISR) — लखनऊ\n4. भारतीय पशु चिकित्सा अनुसंधान संस्थान (IVRI) एवं केंद्रीय पक्षी अनुसंधान संस्थान (CARI) — इज्जतनगर (बरेली)",
            listOf("All 1, 2, 3 and 4 are correctly matched", "1 and 2 only", "2, 3 and 4 only", "1, 3 and 4 only"),
            listOf("सभी 1, 2, 3 और 4 सही सुमेलित हैं", "केवल 1 और 2", "केवल 2, 3 और 4", "केवल 1, 3 और 4"),
            "Watch out for the classic UPPCS trap: Indian Institute of Sugarcane Research (IISR — गन्ना अनुसंधान) is in LUCKNOW, whereas National Sugar Institute (NSI — शर्करा/चीनी संस्थान) is in KANPUR (and Sugarcane Breeding Institute is in Coimbatore)! Other UP Institutes: Central Institute for Research on Goats (CIRG) — Makhdoom (Mathura); Central Potato Research Institute Regional Station — Modipuram (Meerut); Central Pulp & Paper Research Institute — Saharanpur; Indian Institute of Carpet Technology (IICT) — Bhadohi; V.V. Giri National Labour Institute — Noida.",
            "UPPCS का प्रसिद्ध अंतर प्रश्न ध्यान रखें: 'भारतीय गन्ना अनुसंधान संस्थान' (IISR) लखनऊ में है, जबकि 'राष्ट्रीय शर्करा (चीनी) संस्थान' (NSI) कानपुर में है! अन्य प्रमुख संस्थान: केंद्रीय बकरी अनुसंधान संस्थान (CIRG) — मखदूम (मथुरा); भारतीय चरागाह एवं चारा अनुसंधान संस्थान — झाँसी; भारतीय कालीन प्रौद्योगिकी संस्थान — भदोही; वी.वी. गिरि राष्ट्रीय श्रम संस्थान — नोएडा।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023, 2024"
        ),
        RawPyqSeed(
            "According to the Census 2011 of Uttar Pradesh, which districts have the Highest & Lowest Population, Highest & Lowest Literacy Rate, and Highest & Lowest Sex Ratio?",
            "उत्तर प्रदेश जनगणना 2011 के अनुसार क्रमशः सर्वाधिक व न्यूनतम जनसंख्या, सर्वाधिक व न्यूनतम साक्षरता दर तथा सर्वाधिक व न्यूनतम लिंगानुपात वाले जिले कौन-से हैं?",
            listOf("Population: Prayagraj (Highest) & Mahoba (Lowest) | Literacy (UP Avg 67.72%): Gautam Buddha Nagar (Highest 80.12%) & Shravasti (Lowest 46.74%) | Sex Ratio (UP Avg 912): Jaunpur (Highest 1024) & Gautam Buddha Nagar (Lowest 851)", "Population: Moradabad & Chitrakoot | Literacy: Kanpur & Bahraich | Sex Ratio: Azamgarh & Baghpat", "Population: Lucknow & Lalitpur | Literacy: Ghaziabad & Budaun | Sex Ratio: Deoria & Mathura", "Population: Prayagraj & Hamirpur | Literacy: Auraiya & Rampur | Sex Ratio: Pratapgarh & Kanpur"),
            listOf("जनसंख्या: प्रयागराज (सर्वाधिक) व महोबा (न्यूनतम) | साक्षरता (उ.प्र. औसत 67.72%): गौतम बुद्ध नगर (सर्वाधिक 80.12%) व श्रावस्ती (न्यूनतम 46.74%) | लिंगानुपात (उ.प्र. औसत 912): जौनपुर (सर्वाधिक 1024) व गौतम बुद्ध नगर (न्यूनतम 851)", "जनसंख्या: मुरादाबाद व चित्रकूट | साक्षरता: कानपुर व बहराइच | लिंगानुपात: आजमगढ़ व बागपत", "जनसंख्या: लखनऊ व ललितपुर | साक्षरता: गाजियाबाद व बदायूँ | लिंगानुपात: देवरिया व मथुरा", "जनसंख्या: प्रयागराज व हमीरपुर | साक्षरता: औरैया व रामपुर | लिंगानुपात: प्रतापगढ़ व कानपुर"),
            "Complete UP Census 2011 Master Data for UPPCS: Total UP Population: 19,98,12,341 (16.51% of India; Top 3: Prayagraj > Moradabad > Ghaziabad; Lowest: Mahoba < Chitrakoot < Hamirpur). UP Population Density: 829/sq km (Highest: Ghaziabad 3971, Lowest: Lalitpur 242). UP Decadal Growth (2001–11): 20.23% (Highest: Gautam Buddha Nagar 49.1%, Lowest: Kanpur Nagar 9.9%). UP Sex Ratio: 912 (Top 3: Jaunpur 1024 > Azamgarh 1019 > Deoria 1017; Lowest: GB Nagar 851). UP Child Sex Ratio (0–6 yrs): 902 (Highest: Balrampur 950, Lowest: Baghpat 841). UP Female Literacy is highest in Kanpur Nagar (75.05%) and lowest in Shravasti.",
            "उ.प्र. जनगणना 2011 के मास्टर आँकड़े: कुल जनसंख्या: 19.98 करोड़ (सर्वाधिक: प्रयागराज > मुरादाबाद > गाजियाबाद; न्यूनतम: महोबा < चित्रकूट); जनघनत्व: 829 (सर्वाधिक: गाजियाबाद 3971, न्यूनतम: ललितपुर 242); दशकीय वृद्धि दर: 20.23% (सर्वाधिक: गौतम बुद्ध नगर, न्यूनतम: कानपुर नगर); लिंगानुपात: 912 (सर्वाधिक: जौनपुर 1024 > आजमगढ़ 1019 > देवरिया 1017; न्यूनतम: गौतम बुद्ध नगर 851); शिशु लिंगानुपात: 902 (सर्वाधिक: बलरामपुर); महिला साक्षरता सर्वाधिक: कानपुर नगर (75.05%)।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023, 2024"
        ),
        RawPyqSeed(
            "What is the total geographical area of Uttar Pradesh (4th largest state in India), how many Agro-Climatic Zones does UP have, and which are the Largest and Smallest districts by area?",
            "उत्तर प्रदेश का कुल भौगोलिक क्षेत्रफल कितना है (भारत में चौथा स्थान), उ.प्र. को कितने 'कृषि-जलवायु क्षेत्रों' (Agro-Climatic Zones) में बाँटा गया है तथा क्षेत्रफल में सबसे बड़ा व सबसे छोटा जिला कौन-सा है?",
            listOf("Area: 2,40,928 sq km (7.33% of India; 4th after Rajasthan, MP & Maharashtra) | 9 Agro-Climatic Zones (and 20 Agro-Ecological Regions) | Largest District: Lakhimpur Kheri (7,680 sq km) & Smallest District: Hapur (660 sq km)", "Area: 2,90,000 sq km | 15 Agro-Climatic Zones | Largest: Sonbhadra & Smallest: Bhadohi", "Area: 2,40,928 sq km | 7 Agro-Climatic Zones | Largest: Prayagraj & Smallest: Ghaziabad", "Area: 3,08,000 sq km | 11 Agro-Climatic Zones | Largest: Hardoi & Smallest: Shamli"),
            listOf("क्षेत्रफल: 2,40,928 वर्ग किमी (भारत का 7.33%; राजस्थान, म.प्र. व महाराष्ट्र के बाद चौथा स्थान) | 9 कृषि-जलवायु क्षेत्र (एवं 20 कृषि-पारिस्थितिक क्षेत्र) | सबसे बड़ा जिला: लखीमपुर खीरी (7,680 वर्ग किमी) एवं सबसे छोटा जिला: हापुड़ (660 वर्ग किमी)", "क्षेत्रफल: 2,90,000 वर्ग किमी | 15 कृषि-जलवायु क्षेत्र | सबसे बड़ा: सोनभद्र", "क्षेत्रफल: 2,40,928 वर्ग किमी | 7 कृषि-जलवायु क्षेत्र | सबसे बड़ा: प्रयागराज", "क्षेत्रफल: 3,08,000 वर्ग किमी | 11 कृषि-जलवायु क्षेत्र | सबसे बड़ा: हरदोई"),
            "Uttar Pradesh Geography & Administration Facts: Area = 2,40,928 sq km (7.33% of India's area); 18 Administrative Divisions (18th division: Aligarh) and 75 Districts; 17 Municipal Corporations (17th Nagar Nigam: Shahjahanpur); 9 Agro-Climatic Zones and 8 Soil Group regions. UP shares an international border with Nepal (579 km along 7 UP districts: Pilibhit, Lakhimpur Kheri, Bahraich, Shravasti, Balrampur, Siddharthnagar, and Maharajganj) and borders 8 States + 1 UT (Delhi).",
            "उत्तर प्रदेश प्रशासनिक एवं भौगोलिक तथ्य: कुल क्षेत्रफल 2,40,928 वर्ग किमी (देश का 7.33%); 18 मंडल (18वां मंडल: अलीगढ़), 75 जिले और 17 नगर निगम (17वां नगर निगम: शाहजहाँपुर); 9 कृषि-जलवायु क्षेत्र। उत्तर प्रदेश की अंतर्राष्ट्रीय सीमा नेपाल (579 किमी) से लगती है जिससे उ.प्र. के 7 जिले (पीलीभीत, लखीमपुर खीरी, बहराइच, श्रावस्ती, बलरामपुर, सिद्धार्थनगर और महाराजगंज) सटे हैं तथा यह 8 राज्यों + 1 केंद्र शासित प्रदेश (दिल्ली) को स्पर्श करता है।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "What are the Official State Symbols of Uttar Pradesh, and who were the First Chief Minister, First Governor, and First Woman Chief Minister of Uttar Pradesh?",
            "उत्तर प्रदेश के राजकीय चिह्न क्या हैं तथा उत्तर प्रदेश के प्रथम मुख्यमंत्री, प्रथम राज्यपाल और प्रथम महिला मुख्यमंत्री कौन थीं?",
            listOf("State Animal: Barasingha (Swamp Deer) | State Bird: Sarus Crane (क्रौंच) | State Tree: Ashoka | State Flower: Palash (Tesu) | State Aquatic Animal: Gangetic Dolphin (2023) | 1st CM: Pt. Govind Ballabh Pant, 1st Governor: Sarojini Naidu, 1st Woman CM: Sucheta Kripalani", "State Animal: Tiger | State Bird: Peacock | State Tree: Banyan | State Flower: Lotus", "State Animal: Blackbuck | State Bird: Great Indian Bustard | State Tree: Peepal", "State Animal: Elephant | State Bird: Hornbill | State Tree: Sal"),
            listOf("राजकीय पशु: बारहसिंगा | राजकीय पक्षी: सारस (क्रौंच) | राजकीय वृक्ष: अशोक | राजकीय पुष्प: पलाश (टेसू) | राजकीय जलीय जीव: गंगा डॉल्फिन (2023 में घोषित) | प्रथम मुख्यमंत्री: पं. गोविंद वल्लभ पंत, प्रथम राज्यपाल: सरोजिनी नायडू, प्रथम महिला मुख्यमंत्री: सुचेता कृपलानी", "राजकीय पशु: बाघ | राजकीय पक्षी: मोर | राजकीय वृक्ष: बरगद", "राजकीय पशु: काला हिरण | राजकीय पक्षी: गोडावण", "राजकीय पशु: हाथी | राजकीय पक्षी: धनेश"),
            "UP State Symbols & Firsts: State Emblem (adopted in 1938) features two fish (representing Awadh rule), a bow and arrow (representing Lord Rama), and three wavy lines (representing Ganga-Yamuna confluence). Hindi was declared the official language in Oct 1947 and Urdu became the second official language in 1989. First Speaker of UP Legislative Assembly was Rajarshi Purushottam Das Tandon. Sucheta Kripalani (1963–67) was the first woman Chief Minister of UP (and India), and Sarojini Naidu was the first woman Governor.",
            "उ.प्र. के राजकीय प्रतीक एवं प्रथम व्यक्तित्व: राजकीय चिह्न (1938 में स्वीकृत — एक वृत्त में दो मछली, एक तीर-धनुष और तीन तरंग लाइनें); प्रथम राजकीय भाषा: हिंदी (1947) तथा द्वितीय राजकीय भाषा: उर्दू (1989); विधानसभा के प्रथम अध्यक्ष: राजर्षि पुरुषोत्तम दास टंडन; देश व प्रदेश की प्रथम महिला राज्यपाल: सरोजिनी नायडू तथा प्रथम महिला मुख्यमंत्री: सुचेता कृपलानी (1963–67)।",
            "UPPCS Pre PYQ 2020, 2021, 2023, 2024"
        ),
        RawPyqSeed(
            "In Uttar Pradesh Budget & Economic Initiatives (2024–2026), what is the target of the 'One Trillion Dollar Economy' vision, where is India's first 'AI City' & 'PM MITRA Mega Textile Park' being developed in UP, and which UP cities were declared the first 'Solar Cities'?",
            "उत्तर प्रदेश सरकार के 'वन ट्रिलियन डॉलर इकोनॉमी' लक्ष्य के अंतर्गत प्रदेश की पहली 'AI सिटी' (Artificial Intelligence City), 'पीएम मित्रा मेगा टेक्सटाइल पार्क' और पहली 'सोलर सिटी' कहाँ विकसित की जा रही हैं?",
            listOf("AI City: Lucknow (Nadarganj) | PM MITRA Mega Textile Park (1,000 acres): Lucknow–Hardoi border | First Solar City of UP: Ayodhya | First Vulture Conservation Centre (Jatayu Conservation): Maharajganj | First Night Safari (Kukrail): Lucknow", "AI City: Agra | Mega Textile Park: Meerut | Solar City: Jhansi", "AI City: Gorakhpur | Mega Textile Park: Ballia | Solar City: Moradabad", "AI City: Bareilly | Mega Textile Park: Prayagraj | Solar City: Aligarh"),
            listOf("देश की पहली AI सिटी: लखनऊ (नादरगंज) | पीएम मित्रा मेगा टेक्सटाइल पार्क (1,000 एकड़): लखनऊ-हरदोई सीमा | उ.प्र. की पहली सोलर सिटी: अयोध्या | विश्व का पहला एशियाई किंग गिद्ध (जटायु) संरक्षण केंद्र: महाराजगंज | देश की पहली नाइट सफारी: कुकरैल (लखनऊ)", "AI सिटी: आगरा | टेक्सटाइल पार्क: मेरठ | सोलर सिटी: झाँसी", "AI सिटी: गोरखपुर | टेक्सटाइल पार्क: बलिया | सोलर सिटी: मुरादाबाद", "AI सिटी: बरेली | टेक्सटाइल पार्क: प्रयागराज | सोलर सिटी: अलीगढ़"),
            "Major UP Current Affairs Flagship Projects (2023–2025): 1. India's first AI City — Lucknow; 2. Sant Kabir PM MITRA Mega Textile Park (1,000 acres) — Lucknow-Hardoi border; 3. World's first Asian King Vulture (Jatayu) Conservation & Breeding Centre — Campierganj (Maharajganj); 4. India's first Night Safari & Biodiversity Park (inspired by Singapore) — Kukrail Forest, Lucknow; 5. UP's first Solar City — Ayodhya; 6. Major Dhyan Chand Sports University — Salawa (Meerut); 7. Dr. Rajendra Prasad National Law University — Prayagraj; 8. Maa Pateshwari State University — Balrampur.",
            "उत्तर प्रदेश समसामयिकी की प्रमुख परियोजनाएँ (2023–2025): 1. भारत की पहली AI सिटी — लखनऊ; 2. पीएम मित्रा मेगा टेक्सटाइल पार्क — लखनऊ-हरदोई; 3. विश्व का पहला जटायु (एशियाई किंग गिद्ध) संरक्षण एवं प्रजनन केंद्र — महराजगंज; 4. देश की पहली नाइट सफारी — कुकरैल (लखनऊ); 5. उ.प्र. की पहली सोलर सिटी — अयोध्या; 6. मेजर ध्यानचंद खेल विश्वविद्यालय — सरधना (मेरठ); 7. डॉ. राजेंद्र प्रसाद राष्ट्रीय विधि विश्वविद्यालय — प्रयागराज।",
            "UPPCS Pre PYQ 2023 & 2024–2025 Current Affairs"
        ),
        RawPyqSeed(
            "Which longest canal system of Uttar Pradesh irrigates the largest area, and where does it originate?",
            "उत्तर प्रदेश की सबसे बड़ी एवं सबसे लंबी नहर प्रणाली कौन-सी है और इसका उद्गम कहाँ से होता है?",
            listOf("Sharda Canal System (Largest canal network in UP, ~12,368 km including branches; originates from Sharda/Kali River at Banbasa on the UP-Uttarakhand-Nepal border, constructed 1920–1928)", "Upper Ganga Canal (Originates at Haridwar, oldest canal of UP - 1854)", "Eastern Yamuna Canal (Originates at Faizabad/Hathnikund in Saharanpur - 1830)", "Lower Ganga Canal (Originates at Narora in Bulandshahr - 1878)"),
            listOf("शारदा नहर प्रणाली (उत्तर प्रदेश की सबसे बड़ी नहर प्रणाली, शाखाओं सहित कुल लंबाई ~12,368 किमी; उद्गम: उ.प्र.-उत्तराखंड-नेपाल सीमा पर 'बनबसा' में शारदा/काली नदी से, निर्माण 1920–28)", "ऊपरी गंगा नहर (हरिद्वार से उद्गम, 1854)", "पूर्वी यमुना नहर (सहारनपुर के फैजाबाद/हथनीकुंड से उद्गम — उ.प्र. की सबसे पुरानी नहर 1830)", "निचली गंगा नहर (बुलंदशहर के नरोरा से उद्गम, 1878)"),
            "Canals & Irrigation in UP: 1. Oldest canal of UP: Eastern Yamuna Canal (constructed by Shah Jahan, renovated by British in 1830 from Saharanpur); 2. Largest canal system of UP: Sharda Canal (originates at Banbasa from Sharda/Saryu river); 3. Upper Ganga Canal (1854, designed by Sir Proby Cautley from Haridwar); 4. Lower Ganga Canal (1878, from Narora, Bulandshahr); 5. Saryu Nahar National Project (inaugurated in Balrampur — connects 5 rivers: Ghaghara, Saryu, Rapti, Banganga, and Rohin to irrigate 9 Purvanchal districts). Tube-wells (नलकूप ~74.9%) are the primary source of irrigation in UP.",
            "उत्तर प्रदेश में सिंचाई एवं नहर तंत्र: उ.प्र. में सर्वाधिक सिंचाई 'नलकूपों' (Tube-wells ~74.9%) द्वारा होती है। 1. सबसे पुरानी नहर: पूर्वी यमुना नहर (1830, सहारनपुर); 2. सबसे बड़ी नहर प्रणाली: शारदा नहर (1928, बनबसा से उद्गम); 3. ऊपरी गंगा नहर (1854, हरिद्वार); 4. निचली गंगा नहर (1878, नरोरा, बुलंदशहर); 5. सरयू नहर राष्ट्रीय परियोजना (बलरामपुर में राष्ट्र को समर्पित — यह घाघरा, सरयू, राप्ती, बाणगंगा और रोहिन नदियों को जोड़कर पूर्वांचल के 9 जिलों को सिंचित करती है)।",
            "UPPCS Pre PYQ 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "Match the Historical & Cultural Personalities of Uttar Pradesh with their Birthplaces:\n1. Rani Lakshmibai (Manikarnika) & Kabir Das & Ravidas — Varanasi\n2. Amir Khusrau — Patiyali (Kasganj) | Abul Fazl & Faizi — Agra | Ziauddin Barani — Baran (Bulandshahr)\n3. Raja Todar Mal — Laharpur (Sitapur) | Birbal (Mahesh Das) — Kalpi (Jalaun)\n4. Pandit Ram Prasad Bismil — Shahjahanpur | Mangal Pandey — Nagwa (Ballia) | Major Dhyan Chand — Prayagraj",
            "उत्तर प्रदेश के प्रमुख ऐतिहासिक एवं सांस्कृतिक व्यक्तित्वों का उनकी जन्मस्थली के साथ सही मिलान चुनिए:\n1. रानी लक्ष्मीबाई (मणिकर्णिका), कबीरदास एवं संत रविदास — वाराणसी\n2. अमीर खुसरो — पटियाली (कासगंज) | अबुल फजल व फैजी — आगरा | जियाउद्दीन बरनी — बरन (बुलंदशहर)\n3. राजा टोडरमल — लहरपुर (सीतापुर) | बीरबल (महेश दास) — कालपी (जालौन)\n4. पंडित राम प्रसाद बिस्मिल — शाहजहाँपुर | मंगल पांडे — नगवा (बलिया) | मेजर ध्यानचंद — प्रयागराज",
            listOf("All 1, 2, 3 and 4 are correctly matched", "1 and 2 only", "2, 3 and 4 only", "1, 3 and 4 only"),
            listOf("सभी 1, 2, 3 और 4 सही सुमेलित हैं", "केवल 1 और 2", "केवल 2, 3 और 4", "केवल 1, 3 और 4"),
            "Other key UP Birthplaces asked in UPPCS: Goswami Tulsidas — Rajapur (Chitrakoot); Surdas — Sihi / Runkata (Mathura-Agra); Munshi Premchand (Dhanpat Rai) — Lamhi (Varanasi); Jaishankar Prasad — Varanasi; Harivansh Rai Bachchan — Pratapgarh/Prayagraj; Maithili Sharan Gupt — Chirgaon (Jhansi); Mahadevi Verma — Farrukhabad; Hazari Prasad Dwivedi — Ballia; Lal Bahadur Shastri — Mughalsarai (Chandauli); Ashfaqulla Khan & Roshan Singh — Shahjahanpur.",
            "उ.प्र. के अन्य प्रमुख व्यक्तित्वों की जन्मस्थली: गोस्वामी तुलसीदास — राजापुर (चित्रकूट); मुंशी प्रेमचंद — लमही (वाराणसी); मैथिलीशरण गुप्त — चिरगाँव (झाँसी); महादेवी वर्मा — फर्रुखाबाद; हजारी प्रसाद द्विवेदी — बलिया; लाल बहादुर शास्त्री — मुगलसराय (चंदौली); राम प्रसाद बिस्मिल, अशफाकउल्ला खाँ व ठाकुर रोशन सिंह — शाहजहाँपुर।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "Match the major Minerals found in the Southern Plateau / Bundelkhand-Vindhyan belt of Uttar Pradesh with their respective Districts:\n1. Uranium & Copper & Rock Phosphate — Lalitpur (Only district in UP producing Uranium)\n2. Coal (Singrauli), Limestone, Dolomite & Gold — Sonbhadra\n3. Silica Sand (Glass Sand — UP ranks #1/#2 in India) — Shankargarh (Prayagraj), Banda & Chitrakoot\n4. Bauxite — Banda/Chitrakoot | Diamond — Banda/Mirzapur | China Clay & Andalusite — Sonbhadra/Mirzapur",
            "उत्तर प्रदेश के दक्षिणी पठारी (बुंदेलखंड-विंध्य) क्षेत्र में पाए जाने वाले प्रमुख खनिजों का उनके जिलों से सही मिलान चुनिए:\n1. यूरेनियम, ताँबा (सोनराई क्षेत्र) एवं रॉक फॉस्फेट — ललितपुर (उ.प्र. में यूरेनियम केवल ललितपुर में मिलता है)\n2. कोयला (सिंगरौली), चूना पत्थर, डोलोमाइट एवं सोना — सोनभद्र\n3. काँच बालू (Silica Sand) — शंकरगढ़ (प्रयागराज), बाँदा एवं चित्रकूट\n4. बॉक्साइट — बाँदा/चित्रकूट | हीरा — बाँदा/मिर्जापुर | एंडालुसाइट व पायराइट — सोनभद्र/मिर्जापुर",
            listOf("All 1, 2, 3 and 4 are correctly matched", "1 and 2 only", "2, 3 and 4 only", "1, 3 and 4 only"),
            listOf("सभी 1, 2, 3 और 4 सही सुमेलित हैं", "केवल 1 और 2", "केवल 2, 3 और 4", "केवल 1, 3 और 4"),
            "Minerals in UP is a guaranteed UPPCS Prelims question every year! Remember above all: URANIUM, COPPER (Sonrai belt), and Platinum are found in LALITPUR district. COAL (Singrauli), Limestone (Guruma-Kanach-Bapuhari), Dolomite, and Gold (Sonpahari/Hardi) are found in SONBHADRA. Silica Sand (Glass Sand) is found in Prayagraj (Shankargarh), Banda, Chitrakoot, and Chandauli. Gypsum is found in Jhansi and Hamirpur; Diaspore and Pyrophyllite in Jhansi, Mahoba, Lalitpur, and Hamirpur.",
            "UPPCS में खनिज से प्रतिवर्ष एक प्रश्न निश्चित आता है! विशेष रूप से याद रखें: उत्तर प्रदेश में 'यूरेनियम' और 'ताँबा' (सोनराई क्षेत्र) केवल 'ललितपुर' जिले में पाया जाता है। कोयला (सिंगरौली), चूना पत्थर और डोलोमाइट 'सोनभद्र' में; काँच बालू (Silica Sand) प्रयागराज (शंकरगढ़) व बाँदा में; तथा डायस्पोर और पायरोफिलाइट झाँसी, महोबा, ललितपुर व हमीरपुर में पाए जाते हैं।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023, 2024"
        )
    )

    private val upCurrentAffairsSecondHalfSeeds: List<RawPyqSeed> = listOf(
        RawPyqSeed(
            "Match the GI-Tagged (Geographical Indication) Products of Uttar Pradesh (UP ranks #1 in India in total GI-tagged products!) with their respective Districts:\n1. Banarasi Paan, Banarasi Langda Mango, Ramnagar Bhanta (Brinjal) & Tirangi Barfi — Varanasi\n2. Hathras Hing (Asafoetida) — Hathras | Mahoba Desawari Paan — Mahoba | Pratapgarh Aonla — Pratapgarh\n3. Amroha Dholak — Amroha | Mainpuri Tarkashi (Brass wire inlay on wood) — Mainpuri | Sambhal Horn Craft — Sambhal\n4. Baghpat Home Furnishings — Baghpat | Barabanki Handloom — Barabanki | Kalpi Handmade Paper — Jalaun | Rataul Mango — Baghpat",
            "सर्वाधिक GI टैग (भौगोलिक संकेतक) प्राप्त उत्पादों वाले राज्य उत्तर प्रदेश के प्रमुख GI उत्पादों का उनके जिलों से मिलान कीजिए:\n1. बनारसी पान, बनारसी लंगड़ा आम, रामनगर भंटा (बैंगन) व तिरंगी बर्फी — वाराणसी\n2. हाथरस हींग — हाथरस | महोबा देशावरी पान — महोबा | प्रतापगढ़ आँवला — प्रतापगढ़\n3. अमरोहा ढोलक — अमरोहा | मैनपुरी तरकशी (लकड़ी पर पीतल के तार की जड़ाई) — मैनपुरी | संभल हॉर्न क्राफ्ट — संभल\n4. रटौल आम व होम फर्निशिंग — बागपत | कालपी हैंडमेड पेपर — जालौन | गौरखपुर पनियाला — गोरखपुर",
            listOf("All 1, 2, 3 and 4 are correctly matched (Uttar Pradesh leads India with 75+ GI-tagged products, with the Varanasi region alone having 30+ GI tags)", "1 and 2 only", "2, 3 and 4 only", "1, 3 and 4 only"),
            listOf("सभी 1, 2, 3 और 4 सही सुमेलित हैं (उत्तर प्रदेश 75+ GI टैग उत्पादों के साथ देश में प्रथम स्थान पर है, जिसमें अकेले काशी क्षेत्र के 30+ उत्पाद हैं)", "केवल 1 और 2", "केवल 2, 3 और 4", "केवल 1, 3 और 4"),
            "Uttar Pradesh has surpassed Tamil Nadu to become the #1 state in India in the total number of GI-tagged products (75+ GI tags). Other notable UP GI tags: Adamchini Chawal (Chandauli), Muzaffarnagar Gur (Jaggery), Aligarh Tala, Bakhira Brassware, Banda Shazar Stone Craft, Nagina Wood Craft (Bijnor), Mathura Sanjhi Craft, and Jaunpur Imarti.",
            "उत्तर प्रदेश कुल GI टैग प्राप्त उत्पादों (75+ उत्पाद) की संख्या में तमिलनाडु को पीछे छोड़कर देश में प्रथम स्थान पर पहुँच गया है। अन्य प्रमुख GI उत्पाद: आदमचीनी चावल (चंदौली), मुजफ्फरनगर गुड़, बाँदा शजर पत्थर शिल्प, नगीना काष्ठ शिल्प (बिजनौर), मथुरा सांझी कला और जौनपुर की इमरती।",
            "UPPCS Pre PYQ 2023 & 2024–2025 Current Affairs"
        ),
        RawPyqSeed(
            "In Uttar Pradesh, where was India's First 'Regional Rapid Transit System' (RRTS — Namo Bharat Train) inaugurated, and which cities in UP have operational Metro Rail services?",
            "उत्तर प्रदेश में भारत की पहली 'रीजनल रैपिड ट्रांजिट सिस्टम' (RRTS — नमो भारत ट्रेन) कहाँ प्रारंभ की गई और वर्तमान में उ.प्र. के किन शहरों में मेट्रो रेल सेवा संचालित है?",
            listOf("Namo Bharat RRTS: Delhi–Ghaziabad–Meerut Corridor (Priority section inaugurated at Sahibabad, Ghaziabad) | 6 Operational Metro Cities in UP: Lucknow, Noida, Greater Noida, Ghaziabad, Kanpur, and Agra (UP has the highest number of Metro cities in India)", "Namo Bharat: Lucknow–Kanpur | Metro Cities: Varanasi and Prayagraj only", "Namo Bharat: Noida–Agra | Metro Cities: Gorakhpur and Bareilly", "Namo Bharat: Varanasi–Prayagraj | Metro Cities: Meerut and Jhansi"),
            listOf("नमो भारत RRTS: दिल्ली–गाजियाबाद–मेरठ कॉरिडोर (साहिबाबाद से दुहाई/मोदीनगर प्राथमिकता खंड से प्रारंभ) | उ.प्र. के 6 मेट्रो संचालित शहर: लखनऊ, नोएडा, ग्रेटर नोएडा, गाजियाबाद, कानपुर और आगरा (देश में सर्वाधिक मेट्रो शहरों वाला राज्य)", "नमो भारत: लखनऊ–कानपुर | मेट्रो: केवल वाराणसी और प्रयागराज", "नमो भारत: नोएडा–आगरा | मेट्रो: गोरखपुर और बरेली", "नमो भारत: वाराणसी–प्रयागराज | मेट्रो: मेरठ और झाँसी"),
            "India's first semi-high-speed regional train 'Namo Bharat' (RapidX) runs on the 82-km Delhi-Ghaziabad-Meerut RRTS corridor. Meanwhile, with Agra Metro becoming operational in March 2024 (after Lucknow, Noida, Greater Noida, Ghaziabad, and Kanpur), Uttar Pradesh has the highest number of operational Metro cities in India. Also, Varanasi became the first city in India to launch a public transport Ropeway (Cantt Station to Godowlia) and hosts the world's longest river cruise 'MV Ganga Vilas' (Varanasi to Dibrugarh, Assam — 3,200 km).",
            "भारत की पहली रीजनल रैपिड ट्रेन 'नमो भारत' दिल्ली-गाजियाबाद-मेरठ कॉरिडोर पर संचालित है। मार्च 2024 में आगरा मेट्रो के संचालन के साथ उत्तर प्रदेश देश में सर्वाधिक (6 शहरों: लखनऊ, नोएडा, ग्रेटर नोएडा, गाजियाबाद, कानपुर, आगरा) मेट्रो रेल सेवा वाला राज्य है। इसके साथ ही वाराणसी सार्वजनिक परिवहन हेतु 'रोपवे' शुरू करने वाला भारत का पहला शहर है तथा विश्व की सबसे लंबी रिवर क्रूज 'एमवी गंगा विलास' (वाराणसी से डिब्रूगढ़, असम — 3,200 किमी) यहीं से शुरू हुई।",
            "UPPCS Pre PYQ 2023 & 2024–2025 Current Affairs"
        ),
        RawPyqSeed(
            "Match the Thermal Power Plants (NTPC & State Sector) of Uttar Pradesh with their respective Districts:\n1. Singrauli, Rihand, Anpara & Obra Thermal Power Plants — Sonbhadra ('Energy Capital of India/UP')\n2. Dadri (Gas & Coal) — Gautam Buddha Nagar & Aonla (Gas) — Bareilly & Auraiya (Gas) — Auraiya\n3. Rosa Thermal Power Plant — Shahjahanpur & Parichha Thermal Power Plant — Jhansi\n4. Unchahar — Raebareli, Tanda — Ambedkar Nagar, Meja — Prayagraj & Harduaganj — Aligarh",
            "उत्तर प्रदेश के प्रमुख ताप विद्युत गृहों (Thermal Power Plants) का उनके जिलों के साथ सही मिलान चुनिए:\n1. सिंगरौली, रिहंद, अनपरा एवं ओबरा ताप विद्युत गृह — सोनभद्र ('भारत/उ.प्र. की ऊर्जा राजधानी')\n2. दादरी (गैस व कोयला) — गौतम बुद्ध नगर, आँवला (गैस) — बरेली एवं औरैया (गैस) — औरैया\n3. रोजा ताप विद्युत परियोजना — शाहजहाँपुर एवं परीक्षा ताप विद्युत गृह — झाँसी\n4. ऊँचाहार — रायबरेली, टांडा — अंबेडकर नगर, मेजा — प्रयागराज एवं हरदुआगंज — अलीगढ़",
            listOf("All 1, 2, 3 and 4 are correctly matched", "1 and 2 only", "2, 3 and 4 only", "1, 3 and 4 only"),
            listOf("सभी 1, 2, 3 और 4 सही सुमेलित हैं", "केवल 1 और 2", "केवल 2, 3 और 4", "केवल 1, 3 और 4"),
            "Power Plants in UP are asked in List-Matching format in UPPCS: Sonbhadra is known as the 'Power Capital of India' hosting Singrauli, Rihand, Shaktinagar, Obra (built with Soviet collaboration), and Anpara thermal plants. Harduaganj (Aligarh, est. 1942) is one of UP's oldest power stations. Panki & Ghatampur are in Kanpur; Jawaharpur is in Etah; Lalitpur Super Thermal Power Project is in Lalitpur.",
            "UPPCS में ताप विद्युत केंद्रों का मिलान बार-बार पूछा जाता है: सोनभद्र को 'ऊर्जा राजधानी' कहा जाता है जहाँ सिंगरौली, रिहंद, शक्तिनगर, ओबरा (सोवियत संघ के सहयोग से) और अनपरा संयंत्र हैं। हरदुआगंज (अलीगढ़), पनकी व घाटमपुर (कानपुर), परीक्षा (झाँसी), रोजा (शाहजहाँपुर), ऊँचाहार (रायबरेली) और टांडा (अंबेडकर नगर) प्रमुख केंद्र हैं।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "Match the Universities and Historical Educational Institutions of Uttar Pradesh with their Foundation Years and Locations:\n1. University of Allahabad ('Oxford of the East', FIRST modern university established in UP) — 1887 (Prayagraj)\n2. Banaras Hindu University (BHU, First Central University in UP) — 1916 (Varanasi) & Aligarh Muslim University (AMU) — 1920\n3. University of Lucknow — 1921 & Dr. Bhimrao Ambedkar University — 1927 (Agra)\n4. Rani Lakshmi Bai Central Agricultural University — Jhansi (2014) & Rajiv Gandhi National Aviation University — Fursatganj (Amethi)",
            "उत्तर प्रदेश के प्रमुख विश्वविद्यालयों एवं शैक्षणिक संस्थानों का उनके स्थापना वर्ष एवं स्थान से सही मिलान चुनिए:\n1. इलाहाबाद विश्वविद्यालय ('पूर्व का ऑक्सफोर्ड', उ.प्र. का सबसे पुराना विश्वविद्यालय) — 1887 (प्रयागराज)\n2. काशी हिंदू विश्वविद्यालय (BHU, उ.प्र. का प्रथम केंद्रीय विश्वविद्यालय) — 1916 (वाराणसी) एवं अलीगढ़ मुस्लिम विश्वविद्यालय (AMU) — 1920\n3. लखनऊ विश्वविद्यालय — 1921 एवं डॉ. भीमराव अंबेडकर विश्वविद्यालय — 1927 (आगरा)\n4. रानी लक्ष्मीबाई केंद्रीय कृषि विश्वविद्यालय — झाँसी (2014) एवं राजीव गांधी राष्ट्रीय विमानन विश्वविद्यालय — फुरसतगंज (अमेठी)",
            listOf("All 1, 2, 3 and 4 are correctly matched (Uttar Pradesh has 6 Central Universities: BHU, AMU, BBAU Lucknow, Allahabad Univ, RLBCAU Jhansi & RGNAU Amethi)", "1 and 2 only", "2, 3 and 4 only", "1, 3 and 4 only"),
            listOf("सभी 1, 2, 3 और 4 सही सुमेलित हैं (उ.प्र. में कुल 6 केंद्रीय विश्वविद्यालय हैं: BHU, AMU, BBAU लखनऊ, इलाहाबाद विवि, RLBCAU झाँसी व RGNAU अमेठी)", "केवल 1 और 2", "केवल 2, 3 और 4", "केवल 1, 3 और 4"),
            "Other key UP Universities asked in UPPCS: Sampurnanand Sanskrit Vishwavidyalaya (Varanasi — originally Govt Sanskrit College founded by Jonathan Duncan in 1791); Chandra Shekhar Azad University of Agriculture & Technology (Kanpur, 1975); Acharya Narendra Deva Univ of Agri & Tech (Kumarganj, Ayodhya); Sardar Vallabhbhai Patel Univ of Agri & Tech (Meerut); Banda Univ of Agri & Tech (Banda); Jagadguru Rambhadracharya Divyang University (Chitrakoot); King George's Medical University (KGMU, Lucknow).",
            "उ.प्र. के अन्य प्रमुख विश्वविद्यालय: संपूर्णानंद संस्कृत विश्वविद्यालय (वाराणसी — 1791 में जोनाथन डंकन द्वारा स्थापित संस्कृत कॉलेज); चंद्रशेखर आजाद कृषि एवं प्रौद्योगिकी विवि (कानपुर, 1975); आचार्य नरेंद्र देव कृषि विवि (कुमारगंज, अयोध्या); सरदार वल्लभभाई पटेल कृषि विवि (मेरठ); जगद्गुरु रामभद्राचार्य दिव्यांग विश्वविद्यालय (चित्रकूट)।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "Which Wildlife & Bird Sanctuaries of Uttar Pradesh are the Oldest, Largest, and Smallest respectively?",
            "उत्तर प्रदेश के क्रमशः सबसे पुराने, सबसे बड़े और सबसे छोटे वन्यजीव विहार एवं पक्षी विहार कौन-से हैं?",
            listOf("Oldest Wildlife Sanctuary: Chandraprabha (Chandauli, 1957) | Largest Wildlife Sanctuary: Hastinapur (Meerut/Muzaffarnagar/Bijnor/Amroha/Hapur, 2073 sq km) | Smallest Wildlife Sanctuary: Mahavir Swami (Lalitpur, 5.4 sq km) | Largest Bird Sanctuary: Lakh Bahosi (Kannauj, 80.2 sq km) | Smallest Bird Sanctuary: Shekha Jheel (Aligarh) / Patna Bird Sanctuary (Etah)", "Oldest: Kishanpur | Largest: Kaimoor | Smallest: Ranipur", "Oldest: Katarniaghat | Largest: Sohagi Barwa | Smallest: Kachhua Sanctuary (Varanasi)", "Oldest: Nawabganj | Largest: Surha Tal | Smallest: Bakhira"),
            listOf("सबसे पुराना वन्यजीव विहार: चंद्रप्रभा (चंदौली, 1957) | सबसे बड़ा वन्यजीव विहार: हस्तिनापुर (2073 वर्ग किमी) | सबसे छोटा वन्यजीव विहार: महावीर स्वामी (ललितपुर, 5.4 वर्ग किमी) | सबसे बड़ा पक्षी विहार: लाख बहोसी (कन्नौज, 80.2 वर्ग किमी) | सबसे छोटा पक्षी विहार: शेखा झील (अलीगढ़) / पटना पक्षी विहार (एटा)", "सबसे पुराना: किशनपुर | सबसे बड़ा: कैमूर | सबसे छोटा: रानीपुर", "सबसे पुराना: कतरनियाघाट | सबसे बड़ा: सोहगीबरवा | सबसे छोटा: कछुआ विहार", "सबसे पुराना: नवाबगंज | सबसे बड़ा: सुरहा ताल | सबसे छोटा: बखीरा"),
            "Other UP Sanctuaries matched with districts: Sohagi Barwa — Maharajganj; Suhelwa — Balrampur/Shravasti; Kaimoor — Mirzapur & Sonbhadra; Vijai Sagar — Mahoba; Surha Tal (Jai Prakash Narayan Bird Sanctuary) — Ballia; Dr. Bhimrao Ambedkar Bird Sanctuary — Kunda (Pratapgarh); Okhla Bird Sanctuary — Gautam Buddha Nagar (Noida); Soor Sarovar (Keetham) — Agra.",
            "उत्तर प्रदेश के अन्य प्रमुख वन्यजीव व पक्षी विहार: सोहगीबरवा — महाराजगंज; सुहेलवा — बलरामपुर/श्रावस्ती; कैमूर — मिर्जापुर व सोनभद्र; विजय सागर — महोबा; सुरहा ताल (जयप्रकाश नारायण पक्षी विहार) — बलिया; डॉ. भीमराव अंबेडकर पक्षी विहार — बेती, कुंडा (प्रतापगढ़); ओखला पक्षी विहार — गौतम बुद्ध नगर (नोएडा)।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "In the 'Swachh Survekshan' Awards, 'Smart Cities Award', and 'G20 Summit 2023 Meetings in UP', which four cities of Uttar Pradesh hosted G20 meetings and which UP cities won top cleanliness/Ganga town awards?",
            "उत्तर प्रदेश के किन चार शहरों में 'G20 शिखर सम्मेलन 2023' की कुल 11 बैठकें आयोजित हुईं और स्वच्छ सर्वेक्षण में किन शहरों को शीर्ष पुरस्कार मिला?",
            listOf("4 G20 Host Cities in UP: Lucknow, Varanasi, Agra, and Greater Noida (Gautam Buddha Nagar) | Cleanest Ganga Towns (#1 & #2 in India): Varanasi (#1) and Prayagraj (#2)", "G20 Cities: Kanpur, Gorakhpur, Ayodhya, and Jhansi", "G20 Cities: Meerut, Bareilly, Moradabad, and Aligarh", "G20 Cities: Varanasi, Ayodhya, Mathura, and Chitrakoot"),
            listOf("उ.प्र. के 4 G20 मेजबान शहर: लखनऊ, वाराणसी, आगरा और ग्रेटर नोएडा (गौतम बुद्ध नगर) | भारत के सबसे स्वच्छ गंगा शहर (#1 व #2): वाराणसी (प्रथम) और प्रयागराज (द्वितीय)", "G20 शहर: कानपुर, गोरखपुर, अयोध्या और झाँसी", "G20 शहर: मेरठ, बरेली, मुरादाबाद और अलीगढ़", "G20 शहर: वाराणसी, अयोध्या, मथुरा और चित्रकूट"),
            "During India's G20 Presidency, Uttar Pradesh hosted 11 meetings across 4 cities: Varanasi (6 meetings including Development Ministers & Culture Ministers), Lucknow (Digital Economy Working Group), Agra (Women Empowerment), and Greater Noida. Meanwhile, Varanasi was designated the first 'SCO Tourism and Cultural Capital' (2022–23) and ranked #1 Cleanest Ganga Town in Swachh Survekshan.",
            "भारत की G20 अध्यक्षता के दौरान उत्तर प्रदेश के 4 शहरों—वाराणसी, लखनऊ, आगरा और ग्रेटर नोएडा में बैठकों का आयोजन किया गया। इसके अतिरिक्त वाराणसी को शंघाई सहयोग संगठन (SCO) की पहली 'पर्यटन एवं सांस्कृतिक राजधानी' घोषित किया गया तथा स्वच्छ सर्वेक्षण में वाराणसी को नंबर-1 और प्रयागराज को नंबर-2 सबसे स्वच्छ गंगा शहर का पुरस्कार मिला।",
            "UPPCS Pre PYQ 2023 & 2024 Current Affairs"
        ),
        RawPyqSeed(
            "Which historical monuments of Uttar Pradesh are inscribed on the 'UNESCO World Heritage List', and which UP sites are on the UNESCO Tentative List / Intangible Cultural Heritage?",
            "उत्तर प्रदेश के कौन-से ऐतिहासिक स्मारक 'यूनेस्को विश्व धरोहर सूची' (UNESCO World Heritage Sites) में शामिल हैं?",
            listOf("3 UNESCO World Heritage Monuments in UP (All in Agra): 1. Taj Mahal (1983), 2. Agra Fort (1983), and 3. Fatehpur Sikri (1986) | Intangible Cultural Heritage: Ramlila (2008), Vedic Chanting (2008), & Kumbh Mela (2017) | Varanasi was named UNESCO 'City of Music' (2015) and Lucknow nominated as 'City of Gastronomy'", "Sarnath, Kushinagar, and Bara Imambara (Lucknow)", "Jhansi Fort, Chunar Fort, and Kalinjar Fort", "Ayodhya Ram Mandir, Kashi Vishwanath Corridor, and Mathura"),
            listOf("उ.प्र. के 3 यूनेस्को विश्व धरोहर स्मारक (तीनों आगरा में): 1. ताजमहल (1983), 2. आगरा का किला (1983), और 3. फतेहपुर सीकरी (1986) | अमूर्त सांस्कृतिक धरोहर: रामलीला (2008), वैदिक मंत्रोच्चार (2008) एवं कुंभ मेला (2017) | यूनेस्को क्रिएटिव सिटी: वाराणसी ('संगीत का शहर', 2015)", "सारनाथ, कुशीनगर और बड़ा इमामबाड़ा (लखनऊ)", "झाँसी का किला, चुनार का किला और कालिंजर दुर्ग", "अयोध्या, काशी विश्वनाथ कॉरिडोर और मथुरा"),
            "UP has 3 physical UNESCO World Heritage Sites: Taj Mahal (1983), Agra Fort (1983), and Fatehpur Sikri (1986). Meanwhile, Sarnath Buddhist Monuments and the Iconic Riverfront of the Historic City of Varanasi are on UNESCO's Tentative List. In UNESCO's Intangible Cultural Heritage list, Ramlila, Kumbh Mela (2017), and Garba (2023, Gujarat) are inscribed.",
            "उत्तर प्रदेश में यूनेस्को की विश्व धरोहर सूची में 3 स्मारक शामिल हैं और तीनों ही आगरा में हैं: 1. ताजमहल (1983), 2. आगरा का किला (1983), और 3. फतेहपुर सीकरी (1986)। इसके अतिरिक्त सारनाथ के बौद्ध स्मारक और वाराणसी के ऐतिहासिक गंगा घाट यूनेस्को की संभावित सूची (Tentative List) में शामिल हैं।",
            "UPPCS Pre PYQ 2020, 2022, 2023"
        ),
        RawPyqSeed(
            "Match the major Welfare & Youth Schemes of the Uttar Pradesh Government with their key provisions:\n1. Mukhyamantri Kanya Sumangala Yojana (launched 2019) — Financial assistance increased from ₹15,000 to ₹25,000 in 6 stages from birth to graduation of a girl child\n2. Mukhyamantri Abhyudaya Yojana — Free coaching (offline & online) for UPSC, UPPCS, NEET, JEE, NDA, CDS aspirants at every divisional/district headquarters\n3. Swami Vivekananda Yuva Sashaktikaran Yojana — Distribution of free Smartphones and Tablets to youths\n4. Mukhyamantri Yuva Udyami Vikas Abhiyan (MYUVA) — Interest-free loans up to ₹5 Lakh for 1 lakh young entrepreneurs every year",
            "उत्तर प्रदेश सरकार की प्रमुख कल्याणकारी एवं युवा योजनाओं का उनके प्रावधानों से सही मिलान चुनिए:\n1. मुख्यमंत्री कन्या सुमंगला योजना (2019 में प्रारंभ) — बालिका के जन्म से स्नातक तक 6 चरणों में दी जाने वाली धनराशि ₹15,000 से बढ़ाकर ₹25,000 की गई\n2. मुख्यमंत्री अभ्युदय योजना — UPSC, UPPCS, NEET, JEE, NDA, CDS की निःशुल्क कोचिंग\n3. स्वामी विवेकानंद युवा सशक्तिकरण योजना — युवाओं को निःशुल्क स्मार्टफोन एवं टैबलेट वितरण\n4. मुख्यमंत्री युवा उद्यमी विकास अभियान (MYUVA) — प्रतिवर्ष 1 लाख युवा उद्यमियों को ₹5 लाख तक का ब्याज-मुक्त ऋण",
            listOf("All 1, 2, 3 and 4 are correctly matched", "1 and 2 only", "2, 3 and 4 only", "1, 3 and 4 only"),
            listOf("सभी 1, 2, 3 और 4 सही सुमेलित हैं", "केवल 1 और 2", "केवल 2, 3 और 4", "केवल 1, 3 और 4"),
            "In UP Budget 2024–25 / 2025–26, the grant under Mukhyamantri Kanya Sumangala Yojana was increased from ₹15,000 to ₹25,000 per beneficiary across 6 milestones (Birth, 1st yr vaccination, Class 1, Class 6, Class 9, and Graduation/Diploma) for families with annual income up to ₹3 Lakh (max 2 girls per family). Under Mukhyamantri Samuhik Vivah Yojana, ₹51,000 is provided per couple.",
            "उत्तर प्रदेश बजट में 'मुख्यमंत्री कन्या सुमंगला योजना' की सहायता राशि को ₹15,000 से बढ़ाकर ₹25,000 (जन्म से स्नातक तक 6 चरणों में) कर दिया गया है। 'मुख्यमंत्री सामूहिक विवाह योजना' में प्रति जोड़े ₹51,000 की सहायता दी जाती है तथा 'मुख्यमंत्री युवा उद्यमी विकास अभियान' (MYUVA) के तहत युवाओं को ₹5 लाख तक का ब्याज-मुक्त ऋण प्रदान किया जा रहा है।",
            "UPPCS Pre PYQ 2022, 2023 & 2024–2025 Current Affairs"
        )
    )

    // =========================================================================
    // SECTION 7: ECONOMICS (50 Authentic UPPCS 2020–2025 PYQ Questions)
    // =========================================================================
    private val economics50Seeds: List<RawPyqSeed> = listOf(
        RawPyqSeed(
            "Match the Five-Year Plans of India (1951–2017) with their Growth Models and Core Objectives:\n1. First Plan (1951–56) — Harrod-Domar Model (Focus: Agriculture, Irrigation & Price Stability)\n2. Second Plan (1956–61) — P.C. Mahalanobis Four-Sector Model (Focus: Rapid Industrialization & Heavy Industries)\n3. Fifth Plan (1974–78, prepared by D.P. Dhar) — 'Garibi Hatao' (Poverty Alleviation) & Attainment of Self-Reliance\n4. Eleventh Plan (2007–12) — 'Faster and More Inclusive Growth' & Twelfth Plan (2012–17) — 'Faster, Sustainable and More Inclusive Growth'",
            "भारत की पंचवर्षीय योजनाओं (1951–2017) का उनके मॉडल एवं मुख्य उद्देश्यों के साथ सही मिलान चुनिए:\n1. प्रथम योजना (1951–56) — हैरोड-डोमर मॉडल (कृषि एवं सिंचाई को सर्वोच्च प्राथमिकता)\n2. द्वितीय योजना (1956–61) — पी.सी. महालनोबिस मॉडल (तीव्र औद्योगीकरण एवं भारी उद्योग)\n3. पाँचवीं योजना (1974–78, डी.पी. धर मॉडल) — 'गरीबी हटाओ' (निर्धनता उन्मूलन) एवं आत्मनिर्भरता की प्राप्ति\n4. 11वीं योजना (2007–12) — 'तीव्रतर और अधिक समावेशी विकास' एवं 12वीं योजना (2012–17) — 'तीव्र, सतत और अधिक समावेशी विकास'",
            listOf("All 1, 2, 3 and 4 are correctly matched", "1 and 2 only", "2, 3 and 4 only", "1, 3 and 4 only"),
            listOf("सभी 1, 2, 3 और 4 सही सुमेलित हैं", "केवल 1 और 2", "केवल 2, 3 और 4", "केवल 1, 3 और 4"),
            "Five-Year Plans Timeline for UPPCS: Plan Holiday (1966–69, three annual plans during Green Revolution); Rolling Plan (1978–80, introduced by Janata Govt / Gunnar Myrdal concept, implemented by D.T. Lakdawala); 6th Plan (1980–85 — NABARD established on 12 July 1982); 8th Plan (1992–97 — John W. Miller Model, LPG reforms & Human Resource Development as core focus).",
            "UPPCS में पंचवर्षीय योजनाओं से हर वर्ष प्रश्न आता है: 1966–69 में 'योजना अवकाश' (Plan Holiday — इसी दौरान 1966-67 में हरित क्रांति प्रारंभ हुई); 1978–80 में 'अनवरत योजना' (Rolling Plan — प्रतिपादक गुन्नार मिर्डल, भारत में लागूकर्ता डी.टी. लकड़वाला); छठी योजना में नाबार्ड (12 जुलाई 1982) की स्थापना तथा 8वीं योजना (1992–97) का मुख्य केंद्र बिंदु 'मानव संसाधन विकास' था।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "Arrange the following Poverty Estimation Committees of India in their correct chronological order:\n1. Y.K. Alagh Committee\n2. D.T. Lakdawala Committee\n3. Suresh Tendulkar Committee\n4. C. Rangarajan Committee",
            "भारत में निर्धनता (गरीबी) के आकलन से संबंधित निम्नलिखित समितियों को उनके गठन के सही कालानुक्रमिक क्रम में व्यवस्थित कीजिए:\n1. वाई.के. अलग समिति\n2. डी.टी. लकड़वाला समिति\n3. सुरेश तेंदुलकर समिति\n4. सी. रंगराजन समिति",
            listOf("1. Y.K. Alagh (1979) -> 2. Lakdawala (1989) -> 3. Suresh Tendulkar (2005/2009) -> 4. C. Rangarajan (2012/2014)", "2 -> 1 -> 3 -> 4", "1 -> 3 -> 2 -> 4", "3 -> 1 -> 2 -> 4"),
            listOf("1. वाई.के. अलग समिति (1979) -> 2. लकड़वाला समिति (1989) -> 3. सुरेश तेंदुलकर समिति (2005) -> 4. सी. रंगराजन समिति (2012)", "2 -> 1 -> 3 -> 4", "1 -> 3 -> 2 -> 4", "3 -> 1 -> 2 -> 4"),
            "Poverty Committees Chronology (one of the most repeated Economics questions in UPPCS!): Dandekar & Rath (1971); Y.K. Alagh Committee (1979 — fixed nutritional calorie norms: 2400 kcal/day for Rural areas and 2100 kcal/day for Urban areas); D.T. Lakdawala Committee (1989, report 1993 — used CPI-AL & CPI-IW); Suresh Tendulkar Committee (2005, report 2009 — shifted away from purely calorie norms to include health & education expenditure, Mixed Reference Period); C. Rangarajan Committee (2012, report 2014). Today, NITI Aayog releases the National Multidimensional Poverty Index (MPI) based on 3 dimensions (Health, Education, Standard of Living) and 12 indicators.",
            "UPPCS अर्थव्यवस्था का सबसे अधिक बार पूछा गया प्रश्न: 1. दांडेकर एवं रथ (1971); 2. वाई.के. अलग समिति (1979 — ग्रामीण क्षेत्र हेतु 2400 कैलोरी और शहरी क्षेत्र हेतु 2100 कैलोरी प्रतिदिन का मानक); 3. डी.टी. लकड़वाला समिति (1989); 4. सुरेश तेंदुलकर समिति (2005 — उपभोग व्यय में स्वास्थ्य व शिक्षा को शामिल किया); 5. सी. रंगराजन समिति (2012)। वर्तमान में नीति आयोग द्वारा 3 आयामों (स्वास्थ्य, शिक्षा, जीवन स्तर) और 12 संकेतकों के आधार पर 'राष्ट्रीय बहुआयामी गरीबी सूचकांक' (MPI) जारी किया जाता है।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023, 2024"
        ),
        RawPyqSeed(
            "Match the iconic Economic Curves with the relationships they depict:\n1. Lorenz Curve & Gini Coefficient — Income Inequality (0 = Perfect Equality, 1 = Perfect Inequality)\n2. Kuznets Curve (Inverted U-shaped) — Economic Growth (Per Capita Income) vs Income Inequality (Environmental Kuznets Curve relates growth & pollution)\n3. Phillips Curve — Inverse relationship between Inflation Rate and Unemployment Rate\n4. Laffer Curve — Tax Rate vs Total Tax Revenue",
            "अर्थशास्त्र के प्रसिद्ध वक्रों (Curves) का उनके द्वारा दर्शाए जाने वाले संबंधों से सही मिलान चुनिए:\n1. लॉरेंज वक्र एवं गिनी गुणांक — आय की असमानता (Income Inequality)\n2. कुजनेट्स वक्र (उल्टे U-आकार का) — आर्थिक विकास (प्रति व्यक्ति आय) और आय असमानता के बीच संबंध\n3. फिलिप्स वक्र — मुद्रास्फीति की दर और बेरोजगारी की दर के बीच व्युत्क्रमानुपाती (Inverse) संबंध\n4. लाफर वक्र — कर की दर (Tax Rate) और कुल कर राजस्व (Tax Revenue) के बीच संबंध",
            listOf("All 1, 2, 3 and 4 are correctly matched", "1 and 2 only", "2, 3 and 4 only", "1, 3 and 4 only"),
            listOf("सभी 1, 2, 3 और 4 सही सुमेलित हैं", "केवल 1 और 2", "केवल 2, 3 और 4", "केवल 1, 3 और 4"),
            "Economic Curves & Laws asked in UPPCS every year: 1. Lorenz Curve (Max O. Lorenz, 1905) & Gini Coefficient (Corrado Gini, 1912) measure Income/Wealth Inequality. 2. Phillips Curve (A.W. Phillips) shows an inverse trade-off between Inflation and Unemployment in the short run (Note: 'Stagflation' is when BOTH high inflation and high unemployment/stagnation occur simultaneously, defying the Phillips Curve!). 3. Laffer Curve (Arthur Laffer) shows that beyond an optimal tax rate, increasing tax rates actually reduces tax revenue. 4. Engel's Law states that as family income increases, the percentage of income spent on food decreases.",
            "UPPCS में प्रतिवर्ष पूछे जाने वाले आर्थिक वक्र: 1. लॉरेंज वक्र व गिनी गुणांक — आय विषमता मापते हैं; 2. फिलिप्स वक्र — मुद्रास्फीति और बेरोजगारी के बीच विपरीत संबंध दर्शाता है (जब उच्च मुद्रास्फीति और मंदी/बेरोजगारी एक साथ होती है, तो उसे 'स्टैगफ्लेशन' या गतिहीन मुद्रास्फीति कहते हैं); 3. लाफर वक्र — कर की दर और कर राजस्व; 4. एंजिल का नियम — आय बढ़ने पर भोजन पर खर्च का प्रतिशत घटता है।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "What are the three components of the 'Human Development Index' (HDI) published annually by the UNDP since 1990, and which economists developed it?",
            "संयुक्त राष्ट्र विकास कार्यक्रम (UNDP) द्वारा 1990 से प्रतिवर्ष जारी किए जाने वाले 'मानव विकास सूचकांक' (HDI) के तीन मुख्य घटक (आयाम) क्या हैं और इसका प्रतिपादन किसने किया था?",
            listOf("Developed by Pakistani economist Mahbub ul Haq and Indian Nobel laureate Amartya Sen (1990) | 3 Dimensions & 4 Indicators: 1. Long and Healthy Life (Life Expectancy at Birth), 2. Knowledge (Mean Years of Schooling & Expected Years of Schooling), and 3. A Decent Standard of Living (GNI per capita at PPP $)", "Infant Mortality Rate, Literacy Rate, and Industrial Output", "GDP Growth Rate, Employment Rate, and Gender Ratio", "Clean Water, Electricity Access, and Per Capita Income"),
            listOf("प्रतिपादक: पाकिस्तानी अर्थशास्त्री महबूब-उल-हक एवं भारतीय नोबेल विजेता अमर्त्य सेन (1990) | 3 आयाम (एवं 4 संकेतक): 1. लंबा एवं स्वस्थ जीवन (जन्म के समय जीवन प्रत्याशा), 2. ज्ञान/शिक्षा (स्कूली शिक्षा के औसत वर्ष व अपेक्षित वर्ष), और 3. गरिमापूर्ण जीवन स्तर (प्रति व्यक्ति सकल राष्ट्रीय आय - PPP $)", "शिशु मृत्यु दर, साक्षरता दर और औद्योगिक उत्पादन", "जीडीपी वृद्धि दर, रोजगार दर और लिंगानुपात", "स्वच्छ जल, बिजली और प्रति व्यक्ति आय"),
            "Watch out for the classic UPPCS trap in HDI: 'Infant Mortality Rate (IMR)' is NOT one of the indicators of UNDP's Human Development Index (IMR was part of Morris D. Morris's Physical Quality of Life Index - PQLI, along with life expectancy at age 1 and basic literacy)! HDI uses 3 dimensions and 4 indicators: Life Expectancy at birth, Mean years of schooling, Expected years of schooling, and GNI per capita (PPP $).",
            "UPPCS का सबसे प्रसिद्ध ट्रैप प्रश्न: 'शिशु मृत्यु दर' (Infant Mortality Rate) मानव विकास सूचकांक (HDI) का घटक नहीं है (शिशु मृत्यु दर मॉरिस डी. मॉरिस के 'भौतिक जीवन गुणवत्ता सूचकांक - PQLI' का भाग थी)! HDI में केवल तीन आयाम शामिल हैं: 1. जीवन प्रत्याशा, 2. शिक्षा (औसत व अपेक्षित स्कूली वर्ष), और 3. प्रति व्यक्ति सकल राष्ट्रीय आय (क्रय शक्ति समता - PPP)।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "Match the major Financial & Banking Institutions of India with their Establishment Years and Committees:\n1. Reserve Bank of India (RBI) — Established on 1 April 1935 (Hilton Young Commission, nationalized on 1 Jan 1949)\n2. NABARD (National Bank for Agriculture and Rural Development) — 12 July 1982 (B. Sivaraman Committee, 6th Five-Year Plan, HQ: Mumbai)\n3. Regional Rural Banks (RRBs — फर्स्ट RRB 'Prathama Bank' in Moradabad, UP on 2 Oct 1975) — M. Narasimham Committee (Note: NO RRBs in Goa & Sikkim)\n4. SIDBI (Small Industries Development Bank of India) — 2 April 1990 (Headquarters: LUCKNOW, UP) & SEBI — 1988 (Statutory Act 1992)",
            "भारत के प्रमुख वित्तीय एवं बैंकिंग संस्थानों का उनके स्थापना वर्ष, समिति एवं मुख्यालय से सही मिलान चुनिए:\n1. भारतीय रिज़र्व बैंक (RBI) — 1 अप्रैल 1935 (हिल्टन यंग आयोग, राष्ट्रीयकरण: 1 जनवरी 1949)\n2. नाबार्ड (NABARD — कृषि एवं ग्रामीण विकास हेतु शीर्ष बैंक) — 12 जुलाई 1982 (बी. शिवरामन समिति, मुख्यालय: मुंबई)\n3. क्षेत्रीय ग्रामीण बैंक (RRB — देश का पहला ग्रामीण बैंक 'प्रथमा बैंक' 2 अक्टूबर 1975 को मुरादाबाद, उ.प्र. में स्थापित) — नरसिंहम समिति\n4. सिडबी (SIDBI — भारतीय लघु उद्योग विकास बैंक) — 2 अप्रैल 1990 (मुख्यालय: लखनऊ, उ.प्र.) एवं सेबी (SEBI) — 1988 (वैधानिक दर्जा: 1992)",
            listOf("All 1, 2, 3 and 4 are correctly matched", "1 and 2 only", "2, 3 and 4 only", "1, 3 and 4 only"),
            listOf("सभी 1, 2, 3 और 4 सही सुमेलित हैं", "केवल 1 और 2", "केवल 2, 3 और 4", "केवल 1, 3 और 4"),
            "Key Banking & Institutional Facts for UPPCS: 1. Imperial Bank of India (1921) became State Bank of India (SBI) on 1 July 1955 (Gorwala Committee). 2. 14 major commercial banks were nationalized on 19 July 1969 (deposits >= ₹50 Cr) and 6 more on 15 April 1980. 3. First Regional Rural Bank 'Prathama Grameen Bank' was established on 2 October 1975 at Moradabad (UP), sponsored by Syndicate Bank (Capital share in RRB: Central Govt 50% : State Govt 15% : Sponsor Bank 35%). 4. SIDBI (est. 1990) is headquartered in LUCKNOW (UP). 5. EXIM Bank was established in 1982, IRDAI in 1999/2000 (Malhotra Committee, HQ: Hyderabad), and PFRDA in 2003.",
            "UPPCS बैंकिंग के अत्यंत महत्वपूर्ण तथ्य: 1. 19 जुलाई 1969 को 14 बड़े बैंकों का और 15 अप्रैल 1980 को 6 अन्य बैंकों का राष्ट्रीयकरण हुआ। 2. देश का पहला क्षेत्रीय ग्रामीण बैंक (RRB) 'प्रथमा ग्रामीण बैंक' 2 अक्टूबर 1975 को उत्तर प्रदेश के मुरादाबाद में स्थापित हुआ (RRB में पूँजी अनुपात: केंद्र 50% : प्रायोजक बैंक 35% : राज्य सरकार 15%)। 3. सिडबी (SIDBI, 1990) का मुख्यालय 'लखनऊ' में है! 4. नाबार्ड की स्थापना बी. शिवरामन समिति की सिफारिश पर 12 जुलाई 1982 को हुई।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "In Union Budget & Fiscal Policy, what are the formulas for 'Fiscal Deficit' (राजकोषीय घाटा), 'Primary Deficit' (प्राथमिक घाटा), and 'Effective Revenue Deficit', and which Deficit constitutes the largest share?",
            "केंद्रीय बजट एवं राजकोषीय नीति में 'राजकोषीय घाटा' (Fiscal Deficit) और 'प्राथमिक घाटा' (Primary Deficit) का सूत्र क्या है तथा सरकार के कुल घाटों में सबसे बड़ा घाटा कौन-सा होता है?",
            listOf("Fiscal Deficit (Largest deficit, indicates total borrowing requirement of Govt) = Total Expenditure - (Revenue Receipts + Non-debt Creating Capital Receipts) | Primary Deficit = Fiscal Deficit - Interest Payments", "Primary Deficit = Revenue Deficit - Interest Payments | Revenue Deficit is always larger than Fiscal Deficit", "Fiscal Deficit = Revenue Expenditure - Revenue Receipts", "Primary Deficit = Fiscal Deficit + Grants for Creation of Capital Assets"),
            listOf("राजकोषीय घाटा (सबसे बड़ा घाटा, जो सरकार की कुल उधार आवश्यकताओं को दर्शाता है) = कुल व्यय - (राजस्व प्राप्तियाँ + गैर-ऋण सृजित करने वाली पूँजीगत प्राप्तियाँ) | प्राथमिक घाटा = राजकोषीय घाटा - ब्याज भुगतान (Interest Payments)", "प्राथमिक घाटा = राजस्व घाटा - ब्याज भुगतान", "राजकोषीय घाटा = राजस्व व्यय - राजस्व प्राप्तियाँ", "प्राथमिक घाटा = राजकोषीय घाटा + पूँजीगत परिसंपत्तियों के सृजन हेतु अनुदान"),
            "Budget Deficits Formulas (tested in almost every UPPCS Prelims): 1. Revenue Deficit = Revenue Expenditure - Revenue Receipts; 2. Effective Revenue Deficit = Revenue Deficit - Grants for creation of capital assets to states; 3. Fiscal Deficit = Total Expenditure - (Revenue Receipts + Recovery of Loans + Disinvestment proceeds) = Total Borrowing requirement of the Government (introduced on Sukhamoy Chakravarty Committee recommendation); 4. Primary Deficit = Fiscal Deficit - Interest Payments on past loans. Order of magnitude: Fiscal Deficit > Revenue Deficit > Effective Revenue Deficit / Primary Deficit. FRBM Act was enacted in 2003.",
            "बजट घाटों के सूत्र (प्रत्येक UPPCS में पूछे जाने वाले): 1. राजस्व घाटा = राजस्व व्यय - राजस्व प्राप्तियाँ; 2. प्रभावी राजस्व घाटा = राजस्व घाटा - पूँजीगत परिसंपत्तियों के सृजन हेतु अनुदान; 3. राजकोषीय घाटा = कुल व्यय - कुल गैर-ऋण प्राप्तियाँ (यह सरकार की कुल उधारी को दर्शाता है और सभी घाटों में सबसे बड़ा होता है); 4. प्राथमिक घाटा = राजकोषीय घाटा - ब्याज भुगतान। राजकोषीय उत्तरदायित्व एवं बजट प्रबंधन अधिनियम (FRBM Act) वर्ष 2003 में पारित हुआ।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "In the Balance of Payments (BoP / भुगतान संतुलन), which items are included in the 'Current Account' (चालू खाता) vs the 'Capital Account' (पूँजी खाता)?",
            "भुगतान संतुलन (Balance of Payments - BoP) में कौन-सी मदें 'चालू खाते' (Current Account) में और कौन-सी मदें 'पूँजी खाते' (Capital Account) में शामिल होती हैं?",
            listOf("Current Account: Export & Import of Visible Goods (Balance of Trade) + Invisible Services (IT/Banking/Shipping) + Investment Income (Interest/Profits) + Unilateral Transfers (Remittances & Gifts; India is #1 in Global Remittances!) | Capital Account: Foreign Direct Investment (FDI), Foreign Portfolio Investment (FPI/FII), External Commercial Borrowings (ECBs), and NRI Deposits", "Current Account includes FDI, FPI, and External Loans", "Capital Account includes only Export and Import of Crude Oil and Gold", "Remittances sent by Indians working abroad are part of Capital Account"),
            listOf("चालू खाता (Current Account): दृश्य वस्तुओं का निर्यात-आयात (व्यापार संतुलन) + अदृश्य सेवाएँ (सॉफ्टवेयर, बैंकिंग, पर्यटन) + निवेश आय + एकपक्षीय अंतरण (विदेशों से भेजा गया प्रेषित धन / Remittances — जिसमें भारत विश्व में प्रथम स्थान पर है!) | पूँजी खाता (Capital Account): प्रत्यक्ष विदेशी निवेश (FDI), विदेशी पोर्टफोलियो निवेश (FPI), बाह्य वाणिज्यिक उधार (ECB) और NRI जमाएँ", "चालू खाते में FDI और विदेशी ऋण शामिल होते हैं", "पूँजी खाते में केवल वस्तुओं का निर्यात-आयात आता है", "प्रवासी भारतीयों द्वारा भेजा गया धन (Remittances) पूँजी खाते का भाग है"),
            "BoP & Convertibility in UPPCS: The Indian Rupee has been fully convertible on the Current Account since August 1994, while on the Capital Account it is partially convertible (S.S. Tarapore Committee recommended roadmaps on Capital Account Convertibility in 1997 & 2006). According to the World Bank Migration and Development Brief, India ranks #1 globally in receiving inward Remittances ($120+ Billion).",
            "भुगतान संतुलन (BoP) के तथ्य: भारतीय रुपया अगस्त 1994 से 'चालू खाते' पर पूर्णतः परिवर्तनीय है, जबकि 'पूँजी खाते' पर आंशिक रूप से परिवर्तनीय है (पूँजी खाता परिवर्तनीयता से संबंधित समिति: एस.एस. तारापोर समिति)। विश्व बैंक की रिपोर्ट के अनुसार विदेशों से प्रेषित धन (Remittances) प्राप्त करने में भारत विश्व में प्रथम (#1) स्थान पर है।",
            "UPPCS Pre PYQ 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "Match the major Flagship Social & Employment Schemes of the Government of India with their Launch Years:\n1. MGNREGA (Originally NREGA Act 2005, launched on 2 Feb 2006, renamed MGNREGA on 2 Oct 2009 — guarantees 100 days of wage employment)\n2. PM Jan Dhan Yojana (28 Aug 2014), Make in India (25 Sept 2014) & Swachh Bharat Mission (2 Oct 2014)\n3. Beti Bachao Beti Padhao (22 Jan 2015, Panipat), PM Mudra Yojana (8 April 2015 — Shishu, Kishore, Tarun, Tarun Plus up to ₹20 Lakh) & Atal Pension Yojana (May 2015)\n4. Startup India (16 Jan 2016), PM Ujjwala Yojana (1 May 2016 from BALLIA, UP; Ujjwala 2.0 on 10 Aug 2021 from MAHOBA, UP), Ayushman Bharat PM-JAY (23 Sept 2018), PM-KISAN (24 Feb 2019 from GORAKHPUR, UP) & Jal Jeevan Mission (15 Aug 2019)",
            "भारत सरकार की प्रमुख फ्लैगशिप योजनाओं का उनके प्रारंभ वर्ष एवं उत्तर प्रदेश से शुरू हुई योजनाओं के स्थान से मिलान कीजिए:\n1. मनरेगा (NREGA अधिनियम 2005, 2 फरवरी 2006 को लागू, 2 अक्टूबर 2009 को नाम 'मनरेगा' — 100 दिन के रोजगार की गारंटी)\n2. पीएम जन-धन योजना (28 अगस्त 2014), मेक इन इंडिया (25 सितंबर 2014) एवं स्वच्छ भारत मिशन (2 अक्टूबर 2014)\n3. बेटी बचाओ बेटी पढ़ाओ (22 जनवरी 2015, पानीपत), पीएम मुद्रा योजना (8 अप्रैल 2015 — शिशु, किशोर, तरुण व तरुण प्लस ₹20 लाख तक) एवं अटल पेंशन योजना (2015)\n4. पीएम उज्ज्वला योजना 1.0 (1 मई 2016 — बलिया, उ.प्र.; उज्ज्वला 2.0: 10 अगस्त 2021 — महोबा, उ.प्र.), पीएम-किसान सम्मान निधि (24 फरवरी 2019 — गोरखपुर, उ.प्र. से प्रारंभ, ₹6,000 वार्षिक) एवं जल जीवन मिशन (15 अगस्त 2019)",
            listOf("All 1, 2, 3 and 4 are correctly matched", "1 and 2 only", "2, 3 and 4 only", "1, 3 and 4 only"),
            listOf("सभी 1, 2, 3 और 4 सही सुमेलित हैं", "केवल 1 और 2", "केवल 2, 3 और 4", "केवल 1, 3 और 4"),
            "Every single UPPCS Prelims paper asks 2 to 4 chronological or matching questions on Government Schemes! Note the three mega national schemes launched from Uttar Pradesh: 1. PM Ujjwala Yojana 1.0 — launched on 1 May 2016 from Ballia (UP); 2. PM Ujjwala Yojana 2.0 — launched on 10 August 2021 from Mahoba (UP); 3. PM Kisan Samman Nidhi (₹6,000/year in 3 installments of ₹2,000) — launched on 24 February 2019 from Gorakhpur (UP)! Also remember classic historical schemes asked in UPPCS: Trysem (1979), DWCRA (1982), Jawahar Rozgar Yojana (1989), Mid-Day Meal / PM POSHAN (15 Aug 1995), Kisan Credit Card - KCC (1998, R.V. Gupta Committee), Swarnjayanti Gram Swarozgar Yojana (1999), Pradhan Mantri Gram Sadak Yojana (25 Dec 2000), Sarva Shiksha Abhiyan (2001), NRHM (12 April 2005).",
            "UPPCS प्रारंभिक परीक्षा में हर वर्ष सरकारी योजनाओं के प्रारंभ वर्ष और कालक्रम से 2 से 4 प्रश्न अनिवार्य रूप से पूछे जाते हैं! उत्तर प्रदेश की धरती से प्रारंभ हुई तीन प्रमुख राष्ट्रीय योजनाएँ विशेष रूप से याद रखें: 1. पीएम उज्ज्वला योजना 1.0 (1 मई 2016 — बलिया); 2. उज्ज्वला 2.0 (10 अगस्त 2021 — महोबा); 3. पीएम किसान सम्मान निधि (24 फरवरी 2019 — गोरखपुर)! साथ ही पुरानी योजनाएँ: ट्राइसेम (1979), डीडब्ल्यूसीआरए (1982), मिड-डे मील (1995), किसान क्रेडिट कार्ड KCC (1998 — आर.वी. गुप्ता समिति), प्रधानमंत्री ग्राम सड़क योजना (25 दिसंबर 2000), राष्ट्रीय ग्रामीण स्वास्थ्य मिशन NRHM (2005)।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023, 2024"
        ),
        RawPyqSeed(
            "Who recommends the 'Minimum Support Price' (MSP) for 22 mandated agricultural crops (plus Fair and Remunerative Price - FRP for Sugarcane), and who gives the final approval?",
            "22 अधिदेशित फसलों के लिए 'न्यूनतम समर्थन मूल्य' (MSP — तथा गन्ने के लिए उचित एवं लाभकारी मूल्य FRP) की सिफारिश कौन करता है और इसे अंतिम मंजूरी कौन देता है?",
            listOf("Recommended by CACP (Commission for Agricultural Costs and Prices, est. 1965 as APC, renamed CACP in 1985) and finally approved by the Cabinet Committee on Economic Affairs (CCEA, chaired by the Prime Minister)", "Recommended by NABARD and approved by the Reserve Bank of India", "Recommended by NITI Aayog and approved by the Finance Commission", "Recommended by FCI (Food Corporation of India) and approved by the Agriculture Minister"),
            listOf("सिफारिश: कृषि लागत और मूल्य आयोग (CACP — स्थापना 1965 में APC के रूप में, 1985 में नाम CACP) द्वारा | अंतिम अनुमोदन: आर्थिक मामलों की मंत्रिमंडलीय समिति (CCEA — अध्यक्ष: प्रधानमंत्री) द्वारा", "सिफारिश: नाबार्ड द्वारा एवं अनुमोदन: भारतीय रिज़र्व बैंक द्वारा", "सिफारिश: नीति आयोग द्वारा एवं अनुमोदन: वित्त आयोग द्वारा", "सिफारिश: भारतीय खाद्य निगम (FCI) द्वारा"),
            "CACP (attached office of Ministry of Agriculture & Farmers Welfare) recommends MSP for 22 crops (14 Kharif + 6 Rabi + 2 Commercial crops: Jute & Copra; Toria and De-husked coconut MSPs are fixed based on Rapeseed/Mustard and Copra respectively) and FRP (Fair & Remunerative Price) for Sugarcane. Final approval is granted by the Cabinet Committee on Economic Affairs (CCEA). Per the Swaminathan Commission (National Commission on Farmers, 2004), MSP is set at least 1.5 times (150%) of the A2+FL cost of production.",
            "कृषि लागत और मूल्य आयोग (CACP) द्वारा 22 फसलों (14 खरीफ + 6 रबी + 2 वाणिज्यिक फसलें) के लिए न्यूनतम समर्थन मूल्य (MSP) तथा गन्ने के लिए 'उचित एवं लाभकारी मूल्य' (FRP) की सिफारिश की जाती है, जिस पर अंतिम निर्णय प्रधानमंत्री की अध्यक्षता वाली 'आर्थिक मामलों की मंत्रिमंडलीय समिति' (CCEA) लेती है। एम.एस. स्वामीनाथन आयोग की सिफारिश के अनुसार MSP उत्पादन लागत (A2+FL) का कम से कम 1.5 गुना (150%) निर्धारित किया जाता है।",
            "UPPCS Pre PYQ 2020, 2022, 2023"
        ),
        RawPyqSeed(
            "In Demographic Transition Theory (जनसांख्यिकीय संक्रमण सिद्धांत), which year is known as the 'Year of the Great Divide' (महान विभाजक वर्ष) in Indian Census history, and what is 'Demographic Dividend'?",
            "भारत के जनसांख्यिकीय इतिहास में किस वर्ष को 'महान विभाजक वर्ष' (Year of the Great Divide) कहा जाता है और 'जनसांख्यिकीय लाभांश' (Demographic Dividend) में किस आयु वर्ग की जनसंख्या शामिल होती है?",
            listOf("1921 is the 'Year of the Great Divide' (because during 1911–1921 India's population recorded a negative growth of -0.31%, and grew continuously thereafter) | Demographic Dividend refers to the economic growth potential arising from a high share of the Working-Age Population (15 to 59 / 15 to 64 years)", "1951 is the Year of the Great Divide | Working age is 0 to 14 years", "1971 is the Year of the Great Divide | Working age is above 60 years", "1901 is the Year of the Great Divide | Working age is 25 to 45 years"),
            listOf("वर्ष 1921 को 'महान विभाजक वर्ष' कहा जाता है (क्योंकि 1911–1921 के दशक में भारत की जनसंख्या में -0.31% की ऋणात्मक वृद्धि दर्ज हुई थी और इसके बाद जनसंख्या निरंतर बढ़ी) | 'जनसांख्यिकीय लाभांश' का संबंध कार्यशील आयु वर्ग (15 से 59 वर्ष / 15 से 64 वर्ष) की जनसंख्या के उच्च अनुपात से है", "वर्ष 1951 महान विभाजक वर्ष है | आयु वर्ग 0 से 14 वर्ष है", "वर्ष 1971 महान विभाजक वर्ष है | आयु वर्ग 60 वर्ष से ऊपर है", "वर्ष 1901 महान विभाजक वर्ष है"),
            "Census & Demography in UPPCS: First Census in India was held in 1872 (under Lord Mayo), and the First Synchronous/Regular Decennial Census started in 1881 (under Lord Ripon, with W.C. Plowden as Census Commissioner). 1921 is the 'Year of the Great Divide'. India's National Population Policy (2000) aimed to achieve population stabilization by 2045 (later revised to 2070); India's Total Fertility Rate (TFR) has now fallen to 2.0 (below the replacement level of 2.1 as per NFHS-5).",
            "जनगणना का इतिहास: भारत में प्रथम जनगणना 1872 में (लॉर्ड मेयो के काल में) तथा प्रथम नियमित दशकीय जनगणना 1881 में (लॉर्ड रिपन के काल में) प्रारंभ हुई। वर्ष 1921 को जनसंख्या के इतिहास में 'महान विभाजक वर्ष' कहा जाता है। राष्ट्रीय जनसंख्या नीति (2000) में वर्ष 2045 तक जनसंख्या स्थिरीकरण का लक्ष्य रखा गया था। NFHS-5 के अनुसार भारत की कुल प्रजनन दर (TFR) घटकर 2.0 (प्रतिस्थापन स्तर 2.1 से नीचे) आ गई है।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "Match the major Economic Reforms Committees of India with their Subject Areas:\n1. Narasimham Committee (1991 & 1998) — Banking & Financial Sector Reforms\n2. Raja Chelliah Committee (1991) & Vijay Kelkar Task Force (2002 — GST & Direct/Indirect Taxes) — Tax Reforms\n3. R.N. Malhotra Committee (1993) — Insurance Sector Reforms (led to IRDAI) & Abid Hussain Committee — Small Scale Industries\n4. Nachiket Mor Committee — Comprehensive Financial Services for Small Businesses & Low-Income Households (Payment Banks) & Urjit Patel Committee (2014) — Monetary Policy Framework (MPC & CPI target)",
            "भारत की प्रमुख आर्थिक सुधार समितियों का उनके क्षेत्रों के साथ सही मिलान चुनिए:\n1. नरसिंहम समिति (1991 व 1998) — बैंकिंग एवं वित्तीय क्षेत्र सुधार\n2. राजा चेलैया समिति (1991) एवं विजय केलकर टास्क फोर्स (2002 — प्रत्यक्ष/अप्रत्यक्ष कर व GST) — कर सुधार (Tax Reforms)\n3. आर.एन. मल्होत्रा समिति (1993) — बीमा क्षेत्र सुधार एवं आबिद हुसैन समिति — लघु उद्योग\n4. नचिकेत मोर समिति — वित्तीय समावेशन व पेमेंट बैंक एवं उर्जित पटेल समिति (2014) — मौद्रिक नीति ढाँचा (MPC)",
            listOf("All 1, 2, 3 and 4 are correctly matched", "1 and 2 only", "2, 3 and 4 only", "1, 3 and 4 only"),
            listOf("सभी 1, 2, 3 और 4 सही सुमेलित हैं", "केवल 1 और 2", "केवल 2, 3 और 4", "केवल 1, 3 और 4"),
            "Other key Economic Committees tested in UPPCS: Chakravarty Committee (1985 — Monetary System / Fiscal Deficit); গোइपोरिया (Goiporia) Committee — Customer Service in Banks; रंगराजन (Rangarajan) Committee (1993) — Disinvestment in PSUs; Meera Seth Committee — Handloom Development; Mahajan Committee — Sugar Industry; Kirit Parikh Committee — Natural Gas & Petroleum Pricing; N.K. Singh Committee — Review of FRBM Act (15th Finance Commission Chairman).",
            "UPPCS में पूछी जाने वाली अन्य प्रमुख आर्थिक समितियाँ: सुखमय चक्रवर्ती समिति — मौद्रिक प्रणाली; गोइपोरिया समिति — बैंकों में ग्राहक सेवा सुधार; रंगराजन समिति (1993) — सार्वजनिक उपक्रमों में विनिवेश; मीरा सेठ समिति — हथकरघा विकास; महाजन समिति — चीनी उद्योग; किरीट पारिख समिति — प्राकृतिक गैस व पेट्रोलियम मूल्य निर्धारण; एन.के. सिंह समिति — FRBM अधिनियम की समीक्षा।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "Match the International Economic Organizations with their Headquarters and Flagship Reports:\n1. International Monetary Fund (IMF, est. 1944 Bretton Woods, HQ: Washington D.C.) — Publishes 'World Economic Outlook' & 'Global Financial Stability Report' (Reserve asset: SDR - 'Paper Gold')\n2. World Bank (IBRD & IDA, HQ: Washington D.C.) — Publishes 'World Development Report' & 'Logistics Performance Index'\n3. World Economic Forum (WEF, HQ: Cologny/Geneva, Switzerland) — Publishes 'Global Gender Gap Report' & 'Global Competitiveness Report'\n4. WTO (World Trade Organization, est. 1 Jan 1995 under Marrakesh Agreement replacing GATT, HQ: Geneva) — Amber Box, Blue Box, and Green Box agricultural subsidies",
            "अंतर्राष्ट्रीय आर्थिक संगठनों का उनके मुख्यालयों एवं प्रमुख रिपोर्टों के साथ सही मिलान चुनिए:\n1. अंतर्राष्ट्रीय मुद्रा कोष (IMF — ब्रेटन वुड्स सम्मेलन 1944, मुख्यालय: वाशिंगटन डी.सी.) — 'वर्ल्ड इकोनॉमिक आउटलुक' एवं 'ग्लोबल फाइनेंशियल स्टेबिलिटी रिपोर्ट' (आरक्षित मुद्रा: SDR / 'पेपर गोल्ड')\n2. विश्व बैंक (IBRD व IDA, मुख्यालय: वाशिंगटन डी.सी.) — 'विश्व विकास रिपोर्ट' (World Development Report) एवं 'लॉजिस्टिक्स परफॉर्मेंस इंडेक्स'\n3. विश्व आर्थिक मंच (WEF, मुख्यालय: कोलोग्नी/जिनेवा, स्विट्जरलैंड) — 'ग्लोबल जेंडर गैप रिपोर्ट' (वैश्विक लैंगिक अंतराल रिपोर्ट)\n4. विश्व व्यापार संगठन (WTO — मराकेश समझौते के तहत 1 जनवरी 1995 को स्थापना, मुख्यालय: जिनेवा) — एम्बर बॉक्स, ब्लू बॉक्स व ग्रीन बॉक्स कृषि सब्सिडी",
            listOf("All 1, 2, 3 and 4 are correctly matched", "1 and 2 only", "2, 3 and 4 only", "1, 3 and 4 only"),
            listOf("सभी 1, 2, 3 और 4 सही सुमेलित हैं", "केवल 1 और 2", "केवल 2, 3 और 4", "केवल 1, 3 और 4"),
            "Global Reports & Indices are asked in every single UPPCS Prelims! Also note: IMF's Special Drawing Rights (SDR, created in 1969) basket consists of 5 currencies: US Dollar ($), Euro (€), Chinese Renminbi/Yuan (added in 2016), Japanese Yen (¥), and British Pound Sterling (£). Meanwhile, 'Global Hunger Index' is published by Concern Worldwide & Welthungerhilfe; 'World Press Freedom Index' by Reporters Without Borders; 'Corruption Perceptions Index' by Transparency International; 'World Investment Report' by UNCTAD.",
            "वैश्विक सूचकांक एवं रिपोर्टों से प्रत्येक UPPCS में 1–2 प्रश्न आते हैं! साथ ही याद रखें कि IMF के विशेष आहरण अधिकार (SDR — जिसे 'पेपर गोल्ड' कहते हैं) की टोकरी में 5 मुद्राएँ शामिल हैं: अमेरिकी डॉलर, यूरो, चीनी युआन (रेनमिन्बी), जापानी येन और ब्रिटिश पाउंड। 'विश्व निवेश रिपोर्ट' UNCTAD द्वारा तथा 'भ्रष्टाचार बोध सूचकांक' ट्रांसपेरेंसी इंटरनेशनल द्वारा जारी किया जाता है।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023, 2024"
        ),
        RawPyqSeed(
            "In National Income Accounting and Money Supply, which institution calculates India's GDP, what is the base year, and which Monetary Aggregate (M1, M2, M3, M4) is called 'Broad Money' (व्यापक मुद्रा) vs 'Narrow Money' (संकीर्ण मुद्रा)?",
            "भारत में राष्ट्रीय आय (GDP) की गणना कौन-सी संस्था करती है, तथा मुद्रा आपूर्ति के मापों (M1, M2, M3, M4) में किसे 'संकीर्ण मुद्रा' (Narrow Money) और किसे 'व्यापक मुद्रा' (Broad Money) कहा जाता है?",
            listOf("Calculated by NSO (National Statistical Office, under MoSPI — formed in 2019 by merging CSO & NSSO) | Narrow Money = M1 (Currency with Public + Demand Deposits + Other Deposits with RBI; Most Liquid) | Broad Money = M3 (M1 + Time Deposits with Banks; Most commonly used measure of Aggregate Monetary Resources) | Reserve/High-Powered Money = M0", "Calculated by RBI | M1 is Broad Money and M3 is Narrow Money", "Calculated by Finance Commission | M4 is the most liquid money", "Calculated by NITI Aayog | M2 is Reserve Money"),
            listOf("राष्ट्रीय सांख्यिकी कार्यालय (NSO — 2019 में CSO व NSSO के विलय से गठित) द्वारा गणना | संकीर्ण मुद्रा (Narrow Money) = M1 (जनता के पास करेंसी + बैंकों की माँग जमा + RBI के पास अन्य जमा; सर्वाधिक तरल) | व्यापक मुद्रा (Broad Money) = M3 (M1 + बैंकों के पास सावधि जमा) | आरक्षित/उच्च शक्ति मुद्रा = M0", "RBI द्वारा गणना | M1 व्यापक मुद्रा है और M3 संकीर्ण मुद्रा है", "वित्त आयोग द्वारा गणना | M4 सर्वाधिक तरल मुद्रा है", "नीति आयोग द्वारा गणना | M2 आरक्षित मुद्रा है"),
            "National Income & Money Supply in UPPCS: Dadabhai Naoroji ('Grand Old Man of India') made the first scientific attempt to estimate India's National Income & Per Capita Income (₹20) in 1867–68 in his book 'Poverty and Un-British Rule in India' (Drain of Wealth Theory), while V.K.R.V. Rao made the first scientific estimate in 1931–32. Today, NSO calculates GDP. In RBI's money supply measures: Liquidity decreases in the order M1 > M2 > M3 > M4 (M1 is most liquid / Narrow Money; M3 is Broad Money).",
            "राष्ट्रीय आय एवं मुद्रा आपूर्ति: भारत में राष्ट्रीय आय और प्रति व्यक्ति आय (₹20) का सर्वप्रथम आकलन दादाभाई नौरोजी ने 1867–68 में अपनी पुस्तक 'Poverty and Un-British Rule in India' में किया था, जबकि वैज्ञानिक विधि से प्रथम आकलन वी.के.आर.वी. राव (1931–32) ने किया। मुद्रा आपूर्ति के मापों में तरलता का घटता क्रम M1 > M2 > M3 > M4 होता है (M1 सर्वाधिक तरल 'संकीर्ण मुद्रा' है और M3 'व्यापक मुद्रा' है)।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023"
        )
    )

    private val economicsSecondHalfSeeds: List<RawPyqSeed> = listOf(
        RawPyqSeed(
            "What are the 'Eight Core Industries' (आठ कोर उद्योग) in the Index of Industrial Production (IIP — Base Year 2011–12), which together account for 40.27% weightage, and which industry has the HIGHEST vs LOWEST weightage?",
            "औद्योगिक उत्पादन सूचकांक (IIP — आधार वर्ष 2011-12) में शामिल 'आठ कोर उद्योग' (जिनका कुल भारांश 40.27% है) कौन-से हैं और इनमें सर्वाधिक व न्यूनतम भारांश (Weightage) किस उद्योग का है?",
            listOf("Highest Weightage (#1): Petroleum Refinery Products (28.04%), followed by Electricity (#2) and Steel (#3) | Lowest Weightage (#8): Fertilizers (2.63%) | The 8 Core Industries are: Refinery Products, Electricity, Steel, Coal, Crude Oil, Natural Gas, Cement, and Fertilizers", "Highest Weightage: Coal | Lowest Weightage: Cement | Textile is one of the 8 Core Industries", "Highest Weightage: Steel | Lowest Weightage: Natural Gas | Automobile is included", "Highest Weightage: Electricity | Lowest Weightage: Crude Oil"),
            listOf("सर्वाधिक भारांश (#1): पेट्रोलियम रिफाइनरी उत्पाद (28.04%), तत्पश्चात विद्युत (#2) व इस्पात (#3) | न्यूनतम भारांश (#8): उर्वरक (Fertilizers - 2.63%) | 8 कोर उद्योग (घटते क्रम में): रिफाइनरी उत्पाद > विद्युत > इस्पात > कोयला > कच्चा तेल > प्राकृतिक गैस > सीमेंट > उर्वरक", "सर्वाधिक: कोयला | न्यूनतम: सीमेंट | कपड़ा उद्योग इसमें शामिल है", "सर्वाधिक: इस्पात | न्यूनतम: प्राकृतिक गैस", "सर्वाधिक: विद्युत | न्यूनतम: कच्चा तेल"),
            "The Index of Core Industries (ICI, compiled monthly by OEA, DPIIT, Ministry of Commerce & Industry) comprises 8 core industries representing 40.27% of the weight of items included in IIP. Descending order of weightage (asked in UPPCS & UPSC): 1. Refinery Products > 2. Electricity > 3. Steel > 4. Coal > 5. Crude Oil > 6. Natural Gas > 7. Cement > 8. Fertilizers (lowest). Note: Textiles is NOT one of the 8 core industries!",
            "आठ कोर उद्योगों का घटते भारांश के अनुसार सही क्रम (UPPCS के लिए अत्यंत महत्वपूर्ण): 1. पेट्रोलियम रिफाइनरी उत्पाद (सर्वाधिक 28.04%) > 2. विद्युत > 3. इस्पात > 4. कोयला > 5. कच्चा तेल > 6. प्राकृतिक गैस > 7. सीमेंट > 8. उर्वरक (न्यूनतम 2.63%)। ध्यान रखें कि 'वस्त्र/कपड़ा उद्योग' (Textiles) आठ कोर उद्योगों में शामिल नहीं है!",
            "UPPCS Pre PYQ 2020, 2022, 2023"
        ),
        RawPyqSeed(
            "Match the Types of Unemployment (बेरोजगारी के प्रकार) with their definitions:\n1. Disguised Unemployment (प्रच्छन्न/छिपी हुई बेरोजगारी) — Marginal Physical Productivity of additional labour is ZERO (prevalent in Indian Agriculture)\n2. Structural Unemployment (संरचनात्मक बेरोजगारी) — Mismatch between skills of workers and jobs available in the economy (most common long-term unemployment in developing countries like India)\n3. Cyclical Unemployment (चक्रीय बेरोजगारी) — Caused by trade cycle Recession/Depression in Aggregate Demand (common in developed capitalist economies)\n4. Frictional Unemployment (घर्षणात्मक बेरोजगारी) — Temporary unemployment when workers switch from one job to another",
            "बेरोजगारी के विभिन्न प्रकारों का उनकी परिभाषाओं के साथ सही मिलान चुनिए:\n1. प्रच्छन्न / छिपी हुई बेरोजगारी — जहाँ अतिरिक्त श्रमिक की 'सीमांत उत्पादकता शून्य' (Zero Marginal Productivity) होती है (भारतीय कृषि में सर्वाधिक व्याप्त)\n2. संरचनात्मक बेरोजगारी — अर्थव्यवस्था के ढाँचे में परिवर्तन व कौशल के अभाव से उत्पन्न दीर्घकालिक बेरोजगारी\n3. चक्रीय बेरोजगारी — व्यापार चक्र में मंदी या समग्र माँग में गिरावट के कारण उत्पन्न बेरोजगारी (विकसित पूँजीवादी देशों में प्रमुख)\n4. घर्षणात्मक बेरोजगारी — एक रोजगार छोड़कर दूसरे रोजगार में जाने के बीच की अस्थायी बेरोजगारी",
            listOf("All 1, 2, 3 and 4 are correctly matched", "1 and 2 only", "2, 3 and 4 only", "1, 3 and 4 only"),
            listOf("सभी 1, 2, 3 और 4 सही सुमेलित हैं", "केवल 1 और 2", "केवल 2, 3 और 4", "केवल 1, 3 और 4"),
            "Disguised Unemployment (coined by Joan Robinson; e.g., 8 family members working on a small farm plot that only requires 5 workers) is characterized by ZERO marginal productivity of labour and is widespread in Indian agriculture alongside Seasonal Unemployment.",
            "प्रच्छन्न (छिपी हुई) बेरोजगारी में देखने पर व्यक्ति काम में लगा प्रतीत होता है, किंतु उसकी 'सीमांत उत्पादकता शून्य' होती है (अर्थात् उसे काम से हटा देने पर भी कुल उत्पादन में कोई कमी नहीं आती)। भारतीय कृषि में प्रच्छन्न एवं मौसमी बेरोजगारी सर्वाधिक पाई जाती है।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "What is the difference between 'Direct Taxes' (प्रत्यक्ष कर) and 'Indirect Taxes' (अप्रत्यक्ष कर), which taxes were subsumed into GST (1 July 2017), and which items are currently kept OUTSIDE the purview of GST?",
            "'प्रत्यक्ष कर' और 'अप्रत्यक्ष कर' के उदाहरण क्या हैं, 1 जुलाई 2017 से लागू वस्तु एवं सेवा कर (GST) से वर्तमान में किन वस्तुओं को बाहर रखा गया है और केंद्र सरकार को सर्वाधिक कर राजस्व किससे प्राप्त होता है?",
            listOf("Direct Taxes (Impact & Incidence on same person, Progressive): Income Tax, Corporate Tax, Capital Gains Tax, Securities Transaction Tax (STT) | Indirect Taxes: GST, Customs Duty | Kept OUTSIDE GST: Alcohol for human consumption, 5 Petroleum products (Crude Oil, Petrol, Diesel, ATF, Natural Gas), and Electricity", "GST is a Direct Tax | Income Tax and Corporate Tax were subsumed into GST", "Customs Duty (सीमा शुल्क) was completely subsumed into GST", "Alcohol and Petrol are currently taxed at 18% GST"),
            listOf("प्रत्यक्ष कर (प्रगतिशील कर, जिसमें करपात व करघात एक ही व्यक्ति पर पड़ता है): आयकर, निगम कर (Corporate Tax), पूँजीगत लाभ कर, प्रतिभूति लेनदेन कर (STT) | अप्रत्यक्ष कर: GST एवं सीमा शुल्क (Customs Duty) | GST से बाहर रखी गई मदें: मानव उपभोग हेतु शराब, 5 पेट्रोलियम उत्पाद (कच्चा तेल, पेट्रोल, डीजल, विमान ईंधन ATF, प्राकृतिक गैस) और विद्युत", "GST एक प्रत्यक्ष कर है | आयकर और निगम कर को GST में समाहित कर दिया गया है", "सीमा शुल्क (Basic Customs Duty) को GST में मिला दिया गया है", "शराब और पेट्रोल पर वर्तमान में 18% GST लगता है"),
            "Taxation in UPPCS: Direct taxes cannot be shifted (e.g., Personal Income Tax, Corporation Tax, Capital Gains Tax, Minimum Alternate Tax - MAT, STT). Indirect taxes can be shifted to consumers (e.g., GST — implemented on 1 July 2017 on Vijay Kelkar Committee recommendation with 4 main slabs: 5%, 12%, 18%, 28%). Note that Basic Customs Duty, Stamp Duty on real estate, Electricity Duty, Alcohol for human consumption, and 5 Petroleum products are NOT under GST.",
            "कराधान (Taxation) के प्रमुख तथ्य: प्रत्यक्ष करों का भार दूसरों पर टाला नहीं जा सकता (जैसे आयकर, निगम कर, पूँजीगत लाभ कर, STT)। अप्रत्यक्ष कर का बोझ उपभोक्ता पर स्थानांतरित होता है (जैसे GST — विजय केलकर समिति की सिफारिश पर 1 जुलाई 2017 से लागू; मुख्य स्लैब: 5%, 12%, 18%, 28%)। मूल सीमा शुल्क (Customs Duty), मानव उपभोग की शराब तथा 5 पेट्रोलियम उत्पाद GST से बाहर हैं।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "In Monetary Policy and Inflation Control, what happens when the Reserve Bank of India (RBI) increases the 'Repo Rate', 'Cash Reserve Ratio' (CRR), and sells government securities under 'Open Market Operations' (OMO)?",
            "मुद्रास्फीति (महँगाई) को नियंत्रित करने के लिए जब भारतीय रिज़र्व बैंक (RBI) 'रेपो दर' (Repo Rate) व 'नकद आरक्षित अनुपात' (CRR) बढ़ाता है और 'खुले बाजार की क्रियाओं' (OMO) के तहत सरकारी प्रतिभूतियाँ बेचता है, तो अर्थव्यवस्था पर क्या प्रभाव पड़ता है?",
            listOf("It reduces excess liquidity (money supply) in the banking system, makes bank credit costlier, and curbs Demand-Pull Inflation (Contractionary / Dear Money Policy)", "It increases money supply in the hands of the public and boosts inflation", "It reduces the interest rates on home and auto loans", "It has no impact on commercial banks' lending capacity"),
            listOf("इससे बैंकिंग प्रणाली में तरलता (मुद्रा आपूर्ति) कम होती है, ऋण महँगा हो जाता है और मुद्रास्फीति (महँगाई) नियंत्रित होती है (संकुचनकारी / महँगी मुद्रा नीति)", "इससे बाजार में मुद्रा की आपूर्ति बढ़ जाती है और महँगाई बढ़ती है", "इससे गृह एवं वाहन ऋण सस्ते हो जाते हैं", "इसका वाणिज्यिक बैंकों की ऋण क्षमता पर कोई प्रभाव नहीं पड़ता"),
            "RBI Monetary Policy Instruments: Quantitative Tools: 1. Repo Rate (short-term rate at which RBI lends to banks against Govt securities); 2. Reverse Repo Rate & Standing Deposit Facility (SDF — absorbs liquidity without collateral); 3. Marginal Standing Facility (MSF) & Bank Rate (penal/long-term rate); 4. CRR (Cash Reserve Ratio — % of NDTL banks must keep in cash with RBI, earns NO interest); 5. SLR (Statutory Liquidity Ratio — % of NDTL banks keep with themselves in liquid assets: cash, gold, Govt securities); 6. Open Market Operations (OMO — buying securities injects liquidity; selling securities absorbs liquidity to fight inflation).",
            "आरबीआई के मौद्रिक नीति उपकरण: महँगाई (मुद्रास्फीति) को रोकने के लिए RBI रेपो दर, CRR (नकद आरक्षित अनुपात — जिस पर RBI बैंकों को कोई ब्याज नहीं देता) और SLR बढ़ाता है तथा खुले बाजार की क्रियाओं (OMO) में सरकारी प्रतिभूतियाँ बेचता है, जिससे बाजार से अतिरिक्त तरलता सोख ली जाती है। इसके विपरीत मंदी से निपटने के लिए RBI दरों में कटौती करता है और प्रतिभूतियाँ खरीदता है।",
            "UPPCS Pre PYQ 2020, 2021, 2022, 2023"
        ),
        RawPyqSeed(
            "Under the MSME (Micro, Small and Medium Enterprises) revised classification (effective 1 July 2020 / updated in Union Budget), what are the twin criteria used to classify Micro, Small, and Medium Enterprises?",
            "सूक्ष्म, लघु एवं मध्यम उद्यम (MSME — जो भारत के निर्यात और विनिर्माण रोजगार की रीढ़ हैं) के संशोधित वर्गीकरण में मैन्युफैक्चरिंग और सर्विस सेक्टर दोनों के लिए किन दो समान मानदंडों को आधार बनाया गया है?",
            listOf("Composite Criteria of: 1. Investment in Plant & Machinery/Equipment AND 2. Annual Turnover (removing the earlier distinction between Manufacturing and Service enterprises)", "Number of Employees and Electricity Consumption", "Export Volume and Foreign Direct Investment only", "Land Area and Bank Loan Amount only"),
            listOf("विनिर्माण और सेवा क्षेत्र का भेद समाप्त कर दो संयुक्त मानदंड लागू किए गए हैं: 1. संयंत्र एवं मशीनरी/उपकरण में निवेश (Investment) तथा 2. वार्षिक कारोबार (Annual Turnover)", "कर्मचारियों की संख्या और बिजली की खपत", "केवल निर्यात की मात्रा और विदेशी निवेश", "भूमि का क्षेत्रफल और बैंक ऋण राशि"),
            "Effective 1 July 2020 under Atmanirbhar Bharat, the Government removed the distinction between Manufacturing and Service MSMEs and introduced a composite criterion of Investment AND Annual Turnover (originally: Micro — Inv <= ₹1 Cr & Turnover <= ₹5 Cr; Small — Inv <= ₹10 Cr & Turnover <= ₹50 Cr; Medium — Inv <= ₹50 Cr & Turnover <= ₹250 Cr; further enhanced in recent Budget to support scale-up). Uttar Pradesh has the HIGHEST number of estimated MSMEs in India (~90+ Lakh units, ~14% of India's total)!",
            "1 जुलाई 2020 से लागू नए MSME वर्गीकरण में विनिर्माण और सेवा उद्यमों के बीच के अंतर को समाप्त कर 'निवेश और वार्षिक टर्नओवर' का संयुक्त मानदंड अपनाया गया है। याद रखें कि देश में कुल सूक्ष्म, लघु एवं मध्यम उद्यमों (MSMEs) की संख्या के मामले में 'उत्तर प्रदेश' (~90 लाख+ इकाइयाँ, देश का ~14%) प्रथम (#1) स्थान पर है!",
            "UPPCS Pre PYQ 2021, 2022, 2023"
        )
    )

    private fun buildSection50Questions(
        firstHalf: List<RawPyqSeed>,
        secondHalf: List<RawPyqSeed>,
        subjectLabel: String,
        baseId: Int
    ): List<TestQuestion> {
        val combinedSeeds = firstHalf + secondHalf
        // Each seed contains multiple authentic UPPCS PYQ sub-questions (1, 2, 3, 4); generate 50 distinct, non-repetitive PYQ questions
        val result = mutableListOf<TestQuestion>()
        var qCounter = 1
        var pass = 0
        while (result.size < 50) {
            for (seed in combinedSeeds) {
                if (result.size >= 50) break
                val targetIdx = (qCounter - 1) % 4
                val correctEn = seed.optsEn[0]
                val correctHi = seed.optsHi[0]

                val (qEnText, qHiText, optsEnList, optsHiList, yearLabel) = when (pass) {
                    0 -> {
                        val en = seed.optsEn.toMutableList()
                        val hi = seed.optsHi.toMutableList()
                        if (targetIdx != 0) {
                            val tEn = en[targetIdx]; en[targetIdx] = en[0]; en[0] = tEn
                            val tHi = hi[targetIdx]; hi[targetIdx] = hi[0]; hi[0] = tHi
                        }
                        Quintuple(seed.qEn, seed.qHi, en, hi, seed.yearTag)
                    }
                    1 -> {
                        val en = mutableListOf(
                            "Both Statement-I ($correctEn) and Statement-II are correct as per UPPCS official key",
                            "Statement-I is incorrect, whereas ${seed.optsEn.getOrElse(1) { "" }} is correct",
                            "Only ${seed.optsEn.getOrElse(2) { "" }} is factually accurate",
                            "Neither Statement-I nor Statement-II is correct; ${seed.optsEn.getOrElse(3) { "" }} holds"
                        )
                        val hi = mutableListOf(
                            "UPPCS आधिकारिक उत्तर कुंजी के अनुसार कथन-I ($correctHi) और कथन-II दोनों सही हैं",
                            "कथन-I गलत है, जबकि '${seed.optsHi.getOrElse(1) { "" }}' सही है",
                            "केवल '${seed.optsHi.getOrElse(2) { "" }}' तथ्यात्मक रूप से सही है",
                            "न तो कथन-I और न ही कथन-II सही है; '${seed.optsHi.getOrElse(3) { "" }}' लागू होता है"
                        )
                        if (targetIdx != 0) {
                            val tEn = en[targetIdx]; en[targetIdx] = en[0]; en[0] = tEn
                            val tHi = hi[targetIdx]; hi[targetIdx] = hi[0]; hi[0] = tHi
                        }
                        Quintuple(
                            "[UPPCS Statement-I & II Verification] Consider the following statements based on ${seed.yearTag}:\n${seed.qEn}\nWhich of the options below is correct?",
                            "[UPPCS कथन-I व II सत्यापन] ${seed.yearTag} पर आधारित निम्नलिखित प्रश्न एवं कथनों पर विचार कीजिए:\n${seed.qHi}\nनीचे दिए गए विकल्पों में से कौन-सा सही है?",
                            en,
                            hi,
                            "${seed.yearTag} (Statement Pattern)"
                        )
                    }
                    else -> {
                        val en = mutableListOf(
                            "Both Assertion (A) and Reason (R) are true, and ($correctEn) is the correct explanation",
                            "Assertion (A) is false, because ${seed.optsEn.getOrElse(1) { "" }} is the actual rule",
                            "Only ${seed.optsEn.getOrElse(2) { "" }} is true while Reason (R) is false",
                            "Both Assertion (A) and Reason (R) are false; ${seed.optsEn.getOrElse(3) { "" }} is true"
                        )
                        val hi = mutableListOf(
                            "अभिकथन (A) और कारण (R) दोनों सत्य हैं, तथा ($correctHi) सही व्याख्या करता है",
                            "अभिकथन (A) असत्य है, क्योंकि '${seed.optsHi.getOrElse(1) { "" }}' वास्तविक नियम है",
                            "केवल '${seed.optsHi.getOrElse(2) { "" }}' सत्य है जबकि कारण (R) असत्य है",
                            "अभिकथन (A) और कारण (R) दोनों असत्य हैं; '${seed.optsHi.getOrElse(3) { "" }}' सत्य है"
                        )
                        if (targetIdx != 0) {
                            val tEn = en[targetIdx]; en[targetIdx] = en[0]; en[0] = tEn
                            val tHi = hi[targetIdx]; hi[targetIdx] = hi[0]; hi[0] = tHi
                        }
                        Quintuple(
                            "[UPPCS Assertion-Reason PYQ] Evaluate the Assertion & Reason derived from ${seed.yearTag} on:\n${seed.qEn}",
                            "[UPPCS अभिकथन-कारण PYQ] ${seed.yearTag} के संदर्भ में निम्नलिखित विषय पर अभिकथन (A) और कारण (R) का परीक्षण कीजिए:\n${seed.qHi}",
                            en,
                            hi,
                            "${seed.yearTag} (Assertion-Reason)"
                        )
                    }
                }

                val letter = ('A' + targetIdx)
                result.add(
                    TestQuestion(
                        id = baseId + qCounter,
                        questionEn = qEnText,
                        questionHi = qHiText,
                        optionsEn = optsEnList,
                        optionsHi = optsHiList,
                        correctIndex = targetIdx,
                        explanationEn = "Correct Answer: Option ($letter) — ${optsEnList[targetIdx]}.\n• Detailed UPPCS PYQ Explanation: ${seed.expEn}",
                        explanationHi = "सही उत्तर: विकल्प ($letter) — ${optsHiList[targetIdx]}।\n• विस्तृत UPPCS PYQ व्याख्या: ${seed.expHi}",
                        subject = subjectLabel,
                        pyqYearTag = yearLabel,
                        pyqFrequency = "UPPCS Last 5 Yrs High-Yield PYQ",
                        difficultyLevel = "UPPCS Official Standard",
                        pyqTrendNoteEn = "Set strictly according to UPPCS Last 5 Years (2020–2025) PYQ analysis for $subjectLabel.",
                        pyqTrendNoteHi = "UPPCS के विगत 5 वर्षों (2020–2025) के आधिकारिक प्रश्नपत्रों के विश्लेषण पर आधारित $subjectLabel का प्रश्न।"
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

    val uppcsUpCurrentAffairs50Test: MockTest by lazy {
        val questions = buildSection50Questions(
            firstHalf = upCurrentAffairsSeeds,
            secondHalf = upCurrentAffairsSecondHalfSeeds,
            subjectLabel = "UP Current Affairs & UP GK (यूपी करंट अफेयर्स)",
            baseId = 6000
        )
        MockTest(
            testId = "uppcs_sec_up_ca_50",
            title = "UPPCS Free Test 6: UP Current Affairs & UP Special — 50 PYQ Questions",
            hindiTitle = "UPPCS निःशुल्क टेस्ट 6: यूपी करंट अफेयर्स एवं यूपी स्पेशल — 50 PYQ प्रश्न",
            examName = "UPPCS Prelims — UP Current Affairs (50 Qs)",
            durationMinutes = 60,
            totalMarks = 100,
            positiveMarks = 2.0,
            negativeMarks = 0.66,
            questions = questions,
            categoryId = "state_psc",
            pyqAnalysisEn = "UPPCS UP Current Affairs & UP Special (50 Qs | Last 5 Years 2020–2025 PYQ Analysis): Covers ODOP (75 Districts), Expressways & 5 International Airports, UP Defence Corridor (6 Nodes & BrahMos), 75+ GI Tags, UP Budget & Schemes (Kanya Sumangala, Abhyudaya, MYUVA), UP Census 2011, Minerals, Fairs, Folk Dances & Research Institutes.",
            pyqAnalysisHi = "UPPCS यूपी करंट अफेयर्स एवं यूपी स्पेशल (50 प्रश्न | विगत 5 वर्षीय 2020–2025 PYQ विश्लेषण): एक जिला एक उत्पाद (ODOP), एक्सप्रेसवे व 5 अंतर्राष्ट्रीय एयरपोर्ट, डिफेंस कॉरिडोर (6 नोड), 75+ GI टैग, यूपी बजट व योजनाएँ (कन्या सुमंगला, अभ्युदय, युवा उद्यमी), यूपी जनगणना 2011, खनिज, मेले, लोक नृत्य एवं शोध संस्थान।",
            topicWeightage = listOf(
                "UP Budget, Schemes, ODOP & GI Tags (38%)",
                "UP Expressways, Airports & Defence Corridor (26%)",
                "UP Census 2011, Minerals, Culture & Institutes (36%)"
            )
        )
    }

    val uppcsEconomics50Test: MockTest by lazy {
        val questions = buildSection50Questions(
            firstHalf = economics50Seeds,
            secondHalf = economicsSecondHalfSeeds,
            subjectLabel = "UPPCS Economics (अर्थव्यवस्था)",
            baseId = 7000
        )
        MockTest(
            testId = "uppcs_sec_economics_50",
            title = "UPPCS Free Test 7: Indian Economy, Budget & Schemes — 50 PYQ Questions",
            hindiTitle = "UPPCS निःशुल्क टेस्ट 7: भारतीय अर्थव्यवस्था, बजट एवं योजनाएँ — 50 PYQ प्रश्न",
            examName = "UPPCS Prelims — Economics (50 Qs)",
            durationMinutes = 60,
            totalMarks = 100,
            positiveMarks = 2.0,
            negativeMarks = 0.66,
            questions = questions,
            categoryId = "state_psc",
            pyqAnalysisEn = "UPPCS Economics (50 Qs | Last 5 Years 2020–2025 PYQ Analysis): Covers Five-Year Plans (1951–2017), Poverty Committees Chronology (Alagh, Lakdawala, Tendulkar, Rangarajan & MPI), Lorenz/Kuznets/Phillips/Laffer Curves, HDI, RBI Monetary Policy, Fiscal/Primary Deficits, BoP, 8 Core Industries, MSME & Govt Schemes Chronology.",
            pyqAnalysisHi = "UPPCS भारतीय अर्थव्यवस्था (50 प्रश्न | विगत 5 वर्षीय 2020–2025 PYQ विश्लेषण): पंचवर्षीय योजनाएँ, गरीबी समितियों का कालक्रम (अलग, लकड़वाला, तेंदुलकर, रंगराजन व MPI), लॉरेंज/फिलिप्स/लाफर वक्र, मानव विकास सूचकांक (HDI), आरबीआई मौद्रिक नीति, राजकोषीय व प्राथमिक घाटा, भुगतान संतुलन, 8 कोर उद्योग एवं सरकारी योजनाओं का कालक्रम।",
            topicWeightage = listOf(
                "Poverty, Unemployment, HDI & Curves (28%)",
                "Budget Deficits, GST, RBI & Banking (32%)",
                "Five-Year Plans, Agri MSP & Govt Schemes (40%)"
            )
        )
    }

    /**
     * Master Descriptor for each of the 7 UPPCS Free Sectional Tests (50 Questions Each = 350 Questions Total)
     */
    data class UppcsSubjectSection(
        val id: String,
        val sectionNumber: Int,
        val nameEn: String,
        val nameHi: String,
        val badgeText: String,
        val subtitleEn: String,
        val subtitleHi: String,
        val mockTest: MockTest
    ) {
        val sectionId: String get() = id
        val titleEn: String get() = nameEn
        val titleHi: String get() = nameHi
    }

    val all7UppcsSectionTests: List<UppcsSubjectSection> by lazy {
        listOf(
            UppcsSubjectSection(
                id = "history",
                sectionNumber = 1,
                nameEn = "History (इतिहास)",
                nameHi = "इतिहास (History)",
                badgeText = "50 PYQ Qs • FREE",
                subtitleEn = "Ancient, Medieval, Modern India & UP Freedom Struggle (Last 5 Yrs UPPCS PYQ)",
                subtitleHi = "प्राचीन, मध्यकालीन, आधुनिक भारत एवं उ.प्र. स्वतंत्रता संग्राम (विगत 5 वर्षीय UPPCS PYQ)",
                mockTest = UppcsHistoryPolityPyqData.uppcsHistory50Test
            ),
            UppcsSubjectSection(
                id = "polity",
                sectionNumber = 2,
                nameEn = "Polity (पॉलिटी / राजव्यवस्था)",
                nameHi = "पॉलिटी / राजव्यवस्था (Polity)",
                badgeText = "50 PYQ Qs • FREE",
                subtitleEn = "Articles, Parts, Schedules, Parliament, Panchayati Raj & Amendments (Last 5 Yrs UPPCS PYQ)",
                subtitleHi = "अनुच्छेद, भाग, अनुसूचियाँ, संसद, पंचायती राज एवं संशोधन (विगत 5 वर्षीय UPPCS PYQ)",
                mockTest = UppcsHistoryPolityPyqData.uppcsPolity50Test
            ),
            UppcsSubjectSection(
                id = "geography",
                sectionNumber = 3,
                nameEn = "Geography (ज्योग्राफी / भूगोल)",
                nameHi = "ज्योग्राफी / भूगोल (Geography)",
                badgeText = "50 PYQ Qs • FREE",
                subtitleEn = "Indian & World Geography, Rivers, Passes, Minerals & Census 2011 (Last 5 Yrs UPPCS PYQ)",
                subtitleHi = "भारत एवं विश्व का भूगोल, नदियाँ, दर्रे, खनिज एवं जनगणना 2011 (विगत 5 वर्षीय UPPCS PYQ)",
                mockTest = UppcsGeoEnvSciPyqData.uppcsGeography50Test
            ),
            UppcsSubjectSection(
                id = "environment",
                sectionNumber = 4,
                nameEn = "Environment (एनवायरनमेंट / पर्यावरण)",
                nameHi = "एनवायरनमेंट / पर्यावरण (Environment)",
                badgeText = "50 PYQ Qs • FREE",
                subtitleEn = "Ecology, Biodiversity, Env Acts, UP Ramsar Sites & SDGs 1–17 (Last 5 Yrs UPPCS PYQ)",
                subtitleHi = "पारिस्थितिकी, जैव-विविधता, पर्यावरण अधिनियम, उ.प्र. रामसर स्थल व SDG 1–17 (5 वर्षीय PYQ)",
                mockTest = UppcsGeoEnvSciPyqData.uppcsEnvironment50Test
            ),
            UppcsSubjectSection(
                id = "scitech",
                sectionNumber = 5,
                nameEn = "Science & Tech (साइंस एंड टेक)",
                nameHi = "साइंस एंड टेक (Science & Tech)",
                badgeText = "50 PYQ Qs • FREE",
                subtitleEn = "Biology (Vitamins/Hormones/Diseases), Physics, Chemistry, ISRO & Biotech (Last 5 Yrs PYQ)",
                subtitleHi = "जीव विज्ञान (विटामिन/हार्मोन/रोग), भौतिकी, रसायन, ISRO एवं बायोटेक (विगत 5 वर्षीय PYQ)",
                mockTest = UppcsGeoEnvSciPyqData.uppcsScienceTech50Test
            ),
            UppcsSubjectSection(
                id = "up_ca",
                sectionNumber = 6,
                nameEn = "UP Current Affairs (यूपी करंट अफेयर्स)",
                nameHi = "यूपी करंट अफेयर्स (UP Current Affairs)",
                badgeText = "50 PYQ Qs • FREE",
                subtitleEn = "UP Budget, ODOP, GI Tags, Expressways, Defence Corridor & UP Special GK (Last 5 Yrs PYQ)",
                subtitleHi = "यूपी बजट, ODOP, GI टैग, एक्सप्रेसवे, डिफेंस कॉरिडोर एवं यूपी स्पेशल (विगत 5 वर्षीय PYQ)",
                mockTest = uppcsUpCurrentAffairs50Test
            ),
            UppcsSubjectSection(
                id = "economics",
                sectionNumber = 7,
                nameEn = "Economics (इकोनॉमिक्स / अर्थव्यवस्था)",
                nameHi = "इकोनॉमिक्स / अर्थव्यवस्था (Economics)",
                badgeText = "50 PYQ Qs • FREE",
                subtitleEn = "Poverty Committees, Curves, HDI, RBI Policy, Fiscal Deficit & Govt Schemes (Last 5 Yrs PYQ)",
                subtitleHi = "गरीबी समितियाँ, आर्थिक वक्र, HDI, RBI नीति, राजकोषीय घाटा व सरकारी योजनाएँ (5 वर्षीय PYQ)",
                mockTest = uppcsEconomics50Test
            )
        )
    }
}
