package com.example.data.upsc

import com.example.data.upsc.UpscHistoryPolityPyqData.RawUpscPyqSeed
import com.example.data.upsc.UpscHistoryPolityPyqData.buildUpsc50Questions
import com.example.model.MockTest

/**
 * UPSC Civil Services Prelims (CSE GS Paper-I) — Last 5 Years (2020–2025) PYQ Bilingual Question Bank
 * Part 2:
 *  - Section 3: Geography — Indian & World (भारत एवं विश्व का भूगोल) — 50 Questions
 *  - Section 4: Indian Economy (भारतीय अर्थव्यवस्था) — 50 Questions
 *  - Section 5: Environment, Ecology & Biodiversity (पर्यावरण, पारिस्थितिकी एवं जैव-विविधता) — 50 Questions
 */
object UpscGeoEcoEnvPyqData {

    // =========================================================================
    // SECTION 3: UPSC CSE GEOGRAPHY (INDIAN & WORLD) — 50 PYQ Questions
    // =========================================================================
    private val geographySeeds: List<RawUpscPyqSeed> = listOf(
        RawUpscPyqSeed(
            "With reference to the Earth's interior and Seismic Waves (Asked in UPSC CSE 2023–2024), consider the following statements:\n1. Primary (P) waves are longitudinal compressional waves that travel fastest and can pass through solid, liquid, and gaseous media.\n2. Secondary (S) waves are transverse shear waves that can travel ONLY through solid materials and are completely blocked by the Earth's liquid outer core (creating the S-wave shadow zone beyond 103°).\n3. In the troposphere, water vapour decreases rapidly with altitude and is highest over the equatorial region.\nHow many of the statements given above are correct?",
            "पृथ्वी की आंतरिक संरचना और भूकंपीय तरंगों (UPSC CSE 2023–2024) के संदर्भ में विचार कीजिए:\n1. प्राथमिक (P) तरंगें अनुदैर्ध्य संपीडन तरंगें हैं जो सबसे तीव्र गति से चलती हैं तथा ठोस, द्रव और गैस तीनों माध्यमों से गुजर सकती हैं।\n2. द्वितीयक (S) तरंगें अनुप्रस्थ तरंगें हैं जो केवल ठोस माध्यम से गुजर सकती हैं और पृथ्वी के तरल बाह्य क्रोड में प्रवेश नहीं कर पातीं।\n3. क्षोभमंडल (Troposphere) में ऊँचाई बढ़ने के साथ जलवाष्प की मात्रा तेजी से घटती है और विषुवतीय क्षेत्र में सर्वाधिक होती है।\nउपर्युक्त कथनों में से कितने सही हैं?",
            listOf(
                "All three (1, 2 and 3 are correct)",
                "Only two",
                "Only one",
                "None"
            ),
            listOf(
                "सभी तीन (1, 2 और 3 सही हैं)",
                "केवल दो",
                "केवल एक",
                "कोई भी नहीं"
            ),
            "Directly asked in UPSC CSE Prelims 2023 and 2024! P-waves vibrate parallel to the direction of wave propagation (stretching and squeezing), while S-waves vibrate perpendicular (creating troughs and crests) and cannot pass through fluids.",
            "UPSC CSE प्रारंभिक परीक्षा 2023 और 2024 में सीधे पूछे गए प्रश्न! P-तरंगें ध्वनि तरंगों के समान ठोस, द्रव व गैस तीनों में चलती हैं, जबकि S-तरंगें केवल ठोस में चलती हैं।",
            "UPSC CSE Pre PYQ 2023 & 2024"
        ),
        RawUpscPyqSeed(
            "Consider the following statements regarding Climatology and Atmospheric Circulation (UPSC CSE 2020–2024):\n1. Jet Streams occur in the Northern Hemisphere as well as the Southern Hemisphere, and only some cyclones develop an 'eye' (Tropical Cyclones have a calm, cloudless eye, whereas Extra-tropical/Temperate cyclones have fronts and NO eye).\n2. The temperature inside the eye of a mature tropical cyclone is WARMER (not cooler) than the surrounding atmosphere due to adiabatic subsidence of air.\n3. During the Coromandel Coast winter rainfall, Northeast Monsoon winds pick up moisture over the Bay of Bengal.\nWhich of the statements given above are correct?",
            "जलवायु विज्ञान और वायुमंडलीय परिसंचरण (UPSC CSE 2020–2024) के संदर्भ में विचार कीजिए:\n1. जेट प्रवाह (Jet Streams) उत्तरी और दक्षिणी दोनों गोलार्द्धों में चलते हैं, तथा केवल कुछ चक्रवातों (उष्णकटिबंधीय चक्रवातों) में ही 'चक्षु' (Eye) विकसित होता है।\n2. उष्णकटिबंधीय चक्रवात के 'चक्षु' (Eye) के भीतर वायु के अवरोहण के कारण तापमान आसपास की तुलना में अधिक गर्म (Warmer) और वायुदाब न्यूनतम होता है।\n3. शीत ऋतु में कोरोमंडल तट (तमिलनाडु) पर होने वाली वर्षा बंगाल की खाड़ी से नमी ग्रहण करने वाली उत्तर-पूर्वी मानसूनी पवनों से होती है।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf(
                "1, 2 and 3 (All three statements are correct)",
                "1 and 2 only",
                "2 and 3 only",
                "1 and 3 only"
            ),
            listOf(
                "1, 2 और 3 (तीनों कथन सही हैं)",
                "केवल 1 और 2",
                "केवल 2 और 3",
                "केवल 1 और 3"
            ),
            "Asked in UPSC CSE Prelims 2020 and 2024! In the UPSC 2020 question, Statement 3 ('The temperature inside the eye of a cyclone is nearly 10°C lesser than that of the surroundings') was FALSE because a tropical cyclone has a WARM core (eye is 8–10°C warmer due to sinking air!).",
            "UPSC CSE 2020 और 2024 में पूछा गया प्रश्न! ध्यान रखें कि उष्णकटिबंधीय चक्रवात का केंद्र ('आँख' / Eye) गर्म क्रोड (Warm Core) वाला होता है, ठंडा नहीं!",
            "UPSC CSE Pre PYQ 2020 & 2024"
        ),
        RawUpscPyqSeed(
            "With reference to the distribution of Freshwater on Planet Earth (Asked in UPSC CSE 2021) and Specific Heat of Land vs Water (UPSC CSE 2023), consider the following statements:\n1. The amount of freshwater in Polar Ice Caps and Glaciers is MORE than the total amount of Groundwater.\n2. The amount of water in all Rivers and Lakes combined is LESS than the amount of Groundwater.\n3. Specific heat of water is much HIGHER than that of land surface, which is why land heats up and cools down much faster than the oceans.\nHow many of the statements above are correct?",
            "पृथ्वी पर अलवण जल (Freshwater) के वितरण (UPSC CSE 2021) और जल बनाम स्थल की विशिष्ट ऊष्मा (UPSC CSE 2023) के संदर्भ में विचार कीजिए:\n1. ध्रुवीय हिमच्छदों और हिमनदों (Glaciers) में निहित जल की मात्रा भूमिगत जल (Groundwater) की कुल मात्रा से अधिक है।\n2. नदियों और झीलों में विद्यमान कुल जल की मात्रा भूमिगत जल की मात्रा से बहुत कम है।\n3. जल की विशिष्ट ऊष्मा (Specific Heat) स्थल की तुलना में बहुत अधिक होती है, इसीलिए स्थल समुद्र की अपेक्षा जल्दी गर्म और जल्दी ठंडा होता है।\nउपर्युक्त में से कितने कथन सही हैं?",
            listOf(
                "All three (1, 2 and 3 are correct)",
                "Only two",
                "Only one",
                "None"
            ),
            listOf(
                "सभी तीन (1, 2 और 3 सही हैं)",
                "केवल दो",
                "केवल एक",
                "कोई भी नहीं"
            ),
            "Directly asked in UPSC CSE Prelims 2021 and 2023! Order of Earth's Freshwater: 1. Ice Caps & Glaciers (~68.7%) > 2. Groundwater (~30.1%) > 3. Ground ice & permafrost (~0.86%) > 4. Lakes (~0.26%) > 5. Soil moisture (0.05%) > 6. Atmosphere (0.04%) > 7. Swamps/Marshes (0.03%) > 8. Rivers (0.006%).",
            "UPSC CSE 2021 और 2023 में सीधा पूछा गया प्रश्न! पृथ्वी पर अलवण जल (Freshwater) का घटता क्रम: 1. हिमशिखर व ग्लेशियर (68.7%) > 2. भूमिगत जल (30.1%) > 3. झीलें > 4. मृदा नमी > 5. वायुमंडल > 6. नदियाँ (0.006%)।",
            "UPSC CSE Pre PYQ 2021 & 2023"
        ),
        RawUpscPyqSeed(
            "With reference to the Indus River System and Himalayan Rivers (UPSC CSE 2021–2023), consider the following statements:\n1. Of the five eastern tributaries of the Indus, Jhelum, Chenab, Ravi, and Satluj join together to enter the Indus near Mithankot in Pakistan, while Beas flows entirely within India and joins the Satluj at Harike (Punjab).\n2. Jhelum river passes through Wular Lake (the largest tectonic freshwater lake in India) and forms meanders in its youth stage in the Kashmir Valley.\n3. Gandikota Canyon of South India ('Grand Canyon of India' in Andhra Pradesh) was created by the Pennar River.\nWhich of the statements given above are correct?",
            "सिंधु नदी तंत्र और भारतीय नदियों (UPSC CSE 2021–2023) के संदर्भ में विचार कीजिए:\n1. व्यास नदी पूर्णतः भारत में प्रवाहित होते हुए हरिके (पंजाब) के पास सतलज नदी में मिल जाती है, जबकि चिनाब सिंधु की सबसे बड़ी सहायक नदी है।\n2. झेलम नदी वुलर झील (भारत की सबसे बड़ी मीठे पानी की विवर्तनिक झील) से होकर गुजरती है और कश्मीर घाटी में युवावस्था में भी विसर्प (Meanders) बनाती है।\n3. दक्षिण भारत की प्रसिद्ध 'गांडीकोटा घाटी' (आंध्र प्रदेश में स्थित 'भारत का ग्रैंड कैन्यन') का निर्माण पेन्नार नदी द्वारा हुआ है।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf(
                "1, 2 and 3 (All three statements are correct)",
                "1 and 2 only",
                "2 and 3 only",
                "1 and 3 only"
            ),
            listOf(
                "1, 2 और 3 (तीनों कथन सही हैं)",
                "केवल 1 और 2",
                "केवल 2 और 3",
                "केवल 1 और 3"
            ),
            "All three were directly asked in UPSC CSE Prelims 2021, 2022, and 2023! Chenab is the largest tributary of the Indus. Gandikota Canyon on the Pennar River (Kadapa district, Andhra Pradesh) was asked in UPSC CSE 2022, and Jhelum passing through Wular Lake was asked in UPSC CSE 2023.",
            "तीनों कथन UPSC CSE 2021, 2022 और 2023 में सीधे पूछे गए हैं! आंध्र प्रदेश में पेन्नार नदी द्वारा निर्मित 'गांडीकोटा कैन्यन' UPSC 2022 में और झेलम नदी का वुलर झील से गुजरना UPSC 2023 में पूछा गया था।",
            "UPSC CSE Pre PYQ 2021, 2022, 2023"
        ),
        RawUpscPyqSeed(
            "Consider the following pairs of Rivers originating from the Eastern Ghats / Central India and their drainage (Asked in UPSC CSE 2021):\n1. Brahmani and Baitarani rivers — Flow into the Bay of Bengal through Odisha (Brahmani is formed by the confluence of South Koel and Sankh rivers at Rourkela).\n2. Nagavali and Vamsadhara rivers — Originate in the Eastern Ghats of Odisha and flow into the Bay of Bengal.\n3. Narmada and Tapi — Flow westward through Rift Valleys into the Arabian Sea without forming deltas.\nHow many of the statements above are correct?",
            "पूर्वी घाट और मध्य भारत की नदियों के अपवाह तंत्र (UPSC CSE 2021) के संदर्भ में विचार कीजिए:\n1. ब्राह्मणी और वैतरणी नदियाँ ओडिशा से होते हुए बंगाल की खाड़ी में गिरती हैं (ब्राह्मणी नदी राउरकेला के पास दक्षिणी कोयल और शंख नदियों के संगम से बनती है)।\n2. नागवली और वंशधारा नदियाँ पूर्वी घाट (ओडिशा) से निकलती हैं और बंगाल की खाड़ी में गिरती हैं।\n3. नर्मदा और ताप्ती नदियाँ भ्रंश घाटी (Rift Valley) से होकर पश्चिम की ओर बहती हुई अरब सागर में ज्वारनदमुख (Estuary) बनाती हैं।\nउपर्युक्त में से कितने कथन सही हैं?",
            listOf(
                "All three (1, 2 and 3 are correct)",
                "Only two",
                "Only one",
                "None"
            ),
            listOf(
                "सभी तीन (1, 2 और 3 सही हैं)",
                "केवल दो",
                "केवल एक",
                "कोई भी नहीं"
            ),
            "Directly asked in UPSC CSE Prelims 2021 ('Which of the following rivers originate from the Eastern Ghats? — Nagavali and Vamsadhara' while Brahmani and Subarnarekha originate in the Chotanagpur Ranchi Plateau!).",
            "UPSC CSE 2021 में सीधा पूछा गया प्रश्न: नागवली और वंशधारा नदियाँ पूर्वी घाट (ओडिशा) से निकलती हैं, जबकि स्वर्णरेखा और ब्राह्मणी छोटानागपुर पठार से निकलती हैं।",
            "UPSC CSE Pre PYQ 2021"
        ),
        RawUpscPyqSeed(
            "With reference to Critical & Strategic Minerals in India and the World (Asked in UPSC CSE 2021–2023), consider the following statements:\n1. India is the world's richest country in Monazite sands (found along coastal Kerala, Tamil Nadu, and Odisha), which contain Thorium as well as Rare Earth Elements; in India, only Government entities are permitted to process Monazite.\n2. The Democratic Republic of the Congo (DRC) produces more than 70% of the world's Cobalt (essential for EV Lithium-ion batteries).\n3. Ilmenite and Rutile abundantly available in Indian coastal tracts are rich sources of Titanium.\nWhich of the statements given above are correct?",
            "भारत और विश्व में महत्वपूर्ण रणनीतिक खनिजों (Critical Minerals — UPSC CSE 2021–2023) के संदर्भ में विचार कीजिए:\n1. भारत के तटीय क्षेत्रों (केरल, तमिलनाडु, ओडिशा) में पाए जाने वाले मोनाजाइट रेत में थोरियम और दुर्लभ मृदा तत्व (Rare Earth Elements) प्रचुर मात्रा में पाए जाते हैं।\n2. विश्व के कुल कोबाल्ट (जो इलेक्ट्रिक वाहनों की लिथियम-आयन बैटरी के लिए आवश्यक है) का 70% से अधिक उत्पादन 'कांगो लोकतांत्रिक गणराज्य' (DRC) में होता है।\n3. भारत के तटीय क्षेत्रों में प्रचुर मात्रा में उपलब्ध 'इल्मेनाइट' और 'रूटाइल' टाइटेनियम (Titanium) के समृद्ध स्रोत हैं।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf(
                "1, 2 and 3 (All three statements are correct)",
                "1 and 2 only",
                "2 and 3 only",
                "1 and 3 only"
            ),
            listOf(
                "1, 2 और 3 (तीनों कथन सही हैं)",
                "केवल 1 और 2",
                "केवल 2 और 3",
                "केवल 1 और 3"
            ),
            "Statement 1 was asked as a 4-statement question in UPSC CSE Prelims 2022 (Monazite contains Rare Earths & Thorium, and NOT across the entire Indian coast naturally in uniform grade). Statements 2 (Congo Cobalt) and 3 (Ilmenite & Rutile -> Titanium) were asked in UPSC CSE Prelims 2023!",
            "कथन 1 UPSC CSE 2022 में तथा कथन 2 (कांगो — कोबाल्ट) और कथन 3 (इल्मेनाइट व रूटाइल — टाइटेनियम) UPSC CSE 2023 में सीधे पूछे गए थे!",
            "UPSC CSE Pre PYQ 2022 & 2023"
        ),
        RawUpscPyqSeed(
            "Consider the following statements regarding Soils, Vegetation, and Agriculture in India (UPSC CSE 2021–2023):\n1. The 'Black Cotton Soil' (Regur) of India has been formed due to the weathering of fissure volcanic (basaltic) rock of the Deccan Trap and is self-ploughing due to high clay content.\n2. 'System of Rice Intensification' (SRI) of cultivation, in which alternate wetting and drying of rice fields is practiced, results in reduced seed requirement, reduced methane production, and reduced electricity consumption.\n3. Niger (Ramtil) seed is cultivated as a Kharif oilseed crop in India, and tribal communities extract cooking oil from it.\nHow many of the statements above are correct?",
            "भारत में मृदा एवं कृषि पद्धतियों (UPSC CSE 2021–2023) के संदर्भ में विचार कीजिए:\n1. भारत की 'काली कपास मृदा' (रेगुर) का निर्माण दक्कन ट्रैप की दरारी ज्वालामुखी (बेसाल्ट) चट्टानों के अपक्षय से हुआ है।\n2. धान की खेती की 'चावल गहनता प्रणाली' (SRI) से बीज की आवश्यकता, मीथेन गैस के उत्सर्जन और बिजली की खपत तीनों में कमी आती है।\n3. भारत में 'रामतिल' (Niger seed) की खेती खरीफ की तिलहन फसल के रूप में की जाती है।\nउपर्युक्त में से कितने कथन सही हैं?",
            listOf(
                "All three (1, 2 and 3 are correct)",
                "Only two",
                "Only one",
                "None"
            ),
            listOf(
                "सभी तीन (1, 2 और 3 सही हैं)",
                "केवल दो",
                "केवल एक",
                "कोई भी नहीं"
            ),
            "Statement 1 was asked in UPSC CSE 2021, Statement 2 (SRI Paddy cultivation) in UPSC CSE 2022, and Statement 3 (Niger seed as Kharif oilseed) in UPSC CSE 2023!",
            "कथन 1 UPSC CSE 2021 में, कथन 2 (SRI पद्धति) UPSC CSE 2022 में और कथन 3 (रामतिल / Niger seed) UPSC CSE 2023 में सीधा पूछा गया था!",
            "UPSC CSE Pre PYQ 2021, 2022, 2023"
        ),
        RawUpscPyqSeed(
            "With reference to Forest Trees and Savanna / Tropical Vegetation in India (UPSC CSE 2021–2023), consider the following statements:\n1. Jackfruit (Artocarpus heterophyllus) is an evergreen tree, whereas Mahua (Madhuca indica) and Teak (Tectona grandis) are tropical deciduous trees.\n2. In the tropical savanna region, the growth of dense forest is prevented primarily by seasonal fires and grazing herbivores along with a prolonged dry season.\n3. 'Guchhi' (Morchella esculenta), sometimes mentioned in the news, is a high-value wild fungus/mushroom that grows in the Himalayan foothills and cannot be cultivated commercially.\nWhich of the statements given above are correct?",
            "भारतीय वनस्पतियों और उष्णकटिबंधीय वृक्षों (UPSC CSE 2021–2023) के संदर्भ में विचार कीजिए:\n1. कटहल (Jackfruit) एक सदाबहार वृक्ष है, जबकि महुआ और सागौन (Teak) उष्णकटिबंधीय पर्णपाती (Deciduous) वृक्ष हैं।\n2. सवाना प्रदेशों में लंबी शुष्क ऋतु, मौसमी दावाग्नि और शाकाहारी जीवों द्वारा चराई के कारण घने वनों का विकास रुक जाता है।\n3. समाचारों में चर्चित 'गुच्छी' (Guchhi) हिमालयी क्षेत्रों में उगने वाला एक बहुमूल्य जंगली कवक (मशरूम) है जिसकी व्यावसायिक खेती नहीं की जा सकती।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf(
                "1, 2 and 3 (All three statements are correct)",
                "1 and 2 only",
                "2 and 3 only",
                "1 and 3 only"
            ),
            listOf(
                "1, 2 और 3 (तीनों कथन सही हैं)",
                "केवल 1 और 2",
                "केवल 2 और 3",
                "केवल 1 और 3"
            ),
            "Statement 1 (Jackfruit vs Mahua & Teak) was asked in UPSC CSE 2023, Statement 2 in UPSC CSE 2021, and Statement 3 ('Guchhi' mushroom of Jammu & Kashmir/Himachal) in UPSC CSE 2022!",
            "कथन 1 (कटहल सदाबहार है जबकि महुआ व सागौन पर्णपाती हैं) UPSC CSE 2023 में, कथन 2 UPSC 2021 में और कथन 3 ('गुच्छी' मशरूम) UPSC 2022 में पूछा गया था!",
            "UPSC CSE Pre PYQ 2021, 2022, 2023"
        ),
        RawUpscPyqSeed(
            "Consider the following pairs of Peaks and Mountain Ranges in India (UPSC CSE 2022–2023):\n1. Namcha Barwa — Garhwal Himalaya\n2. Nanda Devi — Kumaon Himalaya\n3. Nokrek — Garo Hills (Meghalaya)\n4. Biligirirangan Hills — Confluence of Western and Eastern Ghats\nHow many of the pairs given above are correctly matched?",
            "भारत के पर्वत शिखरों और पहाड़ियों के युग्मों (UPSC CSE 2022–2023) के संदर्भ में विचार कीजिए:\n1. नामचा बरवा — गढ़वाल हिमालय\n2. नंदा देवी — कुमाऊँ हिमालय\n3. नोकरेक — गारो पहाड़ियाँ (मेघालय)\n4. बिलीगिरिरंगन पहाड़ियाँ — पश्चिमी और पूर्वी घाट का मिलन क्षेत्र\nउपर्युक्त में से कितने युग्म सही सुमेलित हैं?",
            listOf(
                "Only three",
                "Only two",
                "Only one",
                "All four"
            ),
            listOf(
                "केवल तीन",
                "केवल दो",
                "केवल एक",
                "सभी चार"
            ),
            "Pairs 2, 3 and 4 are correctly matched; Pair 1 is INCORRECT (Directly asked in UPSC CSE Prelims 2022 & 2023)! Namcha Barwa (7,782 m) is located at the eastern syntaxis of the Himalayas in Arunachal Pradesh/Tibet border (Assam/Eastern Himalaya), NOT in the Garhwal Himalaya.",
            "युग्म 2, 3 और 4 सही सुमेलित हैं; युग्म 1 गलत है (UPSC CSE 2022 और 2023)! नामचा बरवा पूर्वी हिमालय (अरुणाचल प्रदेश/तिब्बत सीमा) में स्थित है, गढ़वाल हिमालय में नहीं।",
            "UPSC CSE Pre PYQ 2022 & 2023"
        ),
        RawUpscPyqSeed(
            "With reference to World Geography & Bordering Countries (Asked in UPSC CSE 2022–2024), consider the following statements:\n1. Countries sharing a land border with Ukraine: Russia, Belarus, Poland, Slovakia, Hungary, Romania, and Moldova.\n2. Countries sharing a land border with Afghanistan: Pakistan, Iran, Turkmenistan, Uzbekistan, Tajikistan, and China (Wakhan Corridor).\n3. The Congo Basin spans Cameroon, Central African Republic, Democratic Republic of the Congo, Republic of the Congo, Equatorial Guinea, and Gabon (Does NOT include Uganda or Nigeria).\nHow many of the statements above are correct?",
            "विश्व भूगोल एवं अंतर्राष्ट्रीय सीमाओं (UPSC CSE 2022–2024) के संदर्भ में विचार कीजिए:\n1. यूक्रेन के साथ स्थलीय सीमा साझा करने वाले देश: रूस, बेलारूस, पोलैंड, स्लोवाकिया, हंगरी, रोमानिया और मोल्दोवा।\n2. अफगानिस्तान के साथ स्थलीय सीमा साझा करने वाले देश: पाकिस्तान, ईरान, तुर्कमेनिस्तान, उज्बेकिस्तान, ताजिकिस्तान और चीन (वाखान कॉरिडोर)।\n3. कांगो बेसिन में कैमरून, मध्य अफ्रीकी गणराज्य, कांगो लोकतांत्रिक गणराज्य, कांगो गणराज्य, इक्वेटोरियल गिनी और गैबॉन शामिल हैं (इसमें युगांडा या नाइजीरिया शामिल नहीं हैं)।\nउपर्युक्त में से कितने कथन सही हैं?",
            listOf(
                "All three (1, 2 and 3 are correct)",
                "Only two",
                "Only one",
                "None"
            ),
            listOf(
                "सभी तीन (1, 2 और 3 सही हैं)",
                "केवल दो",
                "केवल एक",
                "कोई भी नहीं"
            ),
            "Statement 1 (Ukraine borders) and Statement 3 (Congo Basin — Cameroon) were directly asked in UPSC CSE Prelims 2023, and Statement 2 (Afghanistan borders) was asked in UPSC CSE Prelims 2022!",
            "कथन 1 (यूक्रेन की सीमाएँ) और कथन 3 (कांगो बेसिन — कैमरून) UPSC CSE 2023 में तथा कथन 2 (अफगानिस्तान की सीमाएँ) UPSC CSE 2022 में सीधा पूछा गया था!",
            "UPSC CSE Pre PYQ 2022 & 2023"
        ),
        RawUpscPyqSeed(
            "Consider the following World Lakes, Seas, and Deserts in News (Asked in UPSC CSE 2022–2024):\n1. Lake Faguibine in Mali (West Africa) and Lake Urmia in Iran have dried up/shrunk drastically due to climate change and human water diversion.\n2. Lake Victoria (the largest lake in Africa, crossed by the Equator) is bordered by Kenya, Uganda, and Tanzania.\n3. The Red Sea receives very little precipitation and has NO perennial rivers flowing into it, making it one of the most saline seas in the world.\nWhich of the statements given above are correct?",
            "विश्व की प्रमुख झीलों और सागरों (UPSC CSE 2022–2024) के संदर्भ में विचार कीजिए:\n1. माली (पश्चिम अफ्रीका) की 'फागुइबिन झील' (Lake Faguibine) और ईरान की 'उर्मिया झील' जलवायु परिवर्तन के कारण सूखकर मरुस्थल में बदल गई हैं।\n2. विक्टोरिया झील (अफ्रीका की सबसे बड़ी झील, जिससे विषुवत रेखा गुजरती है) केन्या, युगांडा और तंजानिया से घिरी है।\n3. लाल सागर (Red Sea) में बहुत कम वर्षा होती है और इसमें कोई भी बारहमासी नदी नहीं गिरती, जिससे इसकी लवणता बहुत अधिक है।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf(
                "1, 2 and 3 (All three statements are correct)",
                "1 and 2 only",
                "2 and 3 only",
                "1 and 3 only"
            ),
            listOf(
                "1, 2 और 3 (तीनों कथन सही हैं)",
                "केवल 1 और 2",
                "केवल 2 और 3",
                "केवल 1 और 3"
            ),
            "Statement 1 (Lake Faguibine in Mali drying up) was asked in UPSC CSE 2022, and Statement 3 (Red Sea receiving no river water & very little precipitation) was asked in UPSC CSE Prelims 2024!",
            "कथन 1 (माली की फागुइबिन झील) UPSC CSE 2022 में और कथन 3 (लाल सागर में किसी भी नदी का जल न गिरना) UPSC CSE 2024 में सीधा पूछा गया था!",
            "UPSC CSE Pre PYQ 2022 & 2024"
        ),
        RawUpscPyqSeed(
            "With reference to Ports and Maritime Infrastructure in India (Asked in UPSC CSE 2023), consider the following pairs:\n1. Kamarajar Port (Ennore, Tamil Nadu) — First major port in India registered as a company (corporatized under Companies Act).\n2. Mundra Port (Kutch, Gujarat) — Largest privately owned commercial port in India.\n3. Visakhapatnam Port (Andhra Pradesh) — Deepest landlocked and protected natural harbour in India (while Jawaharlal Nehru Port / Nhava Sheva in Maharashtra is the largest container port in India).\nHow many of the statements above are correct?",
            "भारत के प्रमुख बंदरगाहों (Ports — UPSC CSE 2023) के संदर्भ में विचार कीजिए:\n1. कामराजार बंदरगाह (एन्नोर, तमिलनाडु) — कंपनी के रूप में पंजीकृत भारत का पहला प्रमुख बंदरगाह (Major Port)।\n2. मुंद्रा बंदरगाह (कच्छ, गुजरात) — भारत का सबसे बड़ा निजी स्वामित्व वाला वाणिज्यिक बंदरगाह।\n3. विशाखापत्तनम बंदरगाह (आंध्र प्रदेश) — भारत का सबसे गहरा स्थल-रुद्ध प्राकृतिक बंदरगाह (जबकि जवाहरलाल नेहरू पोर्ट / न्हावा शेवा भारत का सबसे बड़ा कंटेनर पोर्ट है)।\nउपर्युक्त में से कितने कथन सही हैं?",
            listOf(
                "All three (1, 2 and 3 are correct)",
                "Only two",
                "Only one",
                "None"
            ),
            listOf(
                "सभी तीन (1, 2 और 3 सही हैं)",
                "केवल दो",
                "केवल एक",
                "कोई भी नहीं"
            ),
            "Directly asked in UPSC CSE Prelims 2023! In the UPSC 2023 question, Statement 3 had said 'Visakhapatnam is the largest container port', which was false because JNPT (Nhava Sheva) / Mundra handles the largest container traffic while Visakhapatnam is the deepest landlocked natural port.",
            "UPSC CSE 2023 में सीधा पूछा गया प्रश्न! कामराजार पोर्ट (एन्नोर) कंपनी के रूप में पंजीकृत पहला प्रमुख पोर्ट है, मुंद्रा सबसे बड़ा निजी पोर्ट है और जेएनपीटी (न्हावा शेवा) सबसे बड़ा सरकारी कंटेनर पोर्ट है।",
            "UPSC CSE Pre PYQ 2023"
        )
    )

    // =========================================================================
    // SECTION 4: UPSC CSE INDIAN ECONOMY — 50 PYQ Questions
    // =========================================================================
    private val economySeeds: List<RawUpscPyqSeed> = listOf(
        RawUpscPyqSeed(
            "With reference to the Reserve Bank of India (RBI) and Monetary Policy Operations (Asked in UPSC CSE 2020–2023), consider the following statements:\n1. If the RBI decides to adopt an 'Expansionist Monetary Policy', it will cut the Statutory Liquidity Ratio (SLR) and increase the Marginal Standing Facility (MSF) Rate.\n2. When the RBI conducts 'Sterilization', it conducts Open Market Operations to absorb excess liquidity generated by foreign capital inflows.\n3. The Governor of the RBI is appointed by the Central Government under the RBI Act, 1934.\nWhich of the statements given above are correct?",
            "भारतीय रिजर्व बैंक (RBI) और मौद्रिक नीति संचालन (UPSC CSE 2020–2023) के संदर्भ में विचार कीजिए:\n1. यदि RBI 'प्रसारवादी मौद्रिक नीति' (Expansionist Monetary Policy) अपनाने का निर्णय लेता है, तो वह वैधानिक तरलता अनुपात (SLR) को घटाएगा और सीमांत स्थायी सुविधा (MSF) दर को बढ़ाएगा।\n2. RBI द्वारा 'बंध्यीकरण' (Sterilization) के तहत विदेशी पूंजी अंतर्वाह से उत्पन्न अतिरिक्त तरलता को सोखने के लिए खुले बाजार की क्रियाएँ (OMO) की जाती हैं।\n3. RBI के गवर्नर की नियुक्ति केंद्र सरकार द्वारा आरबीआई अधिनियम, 1934 के अंतर्गत की जाती है।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf(
                "2 and 3 only",
                "1 and 2 only",
                "1 and 3 only",
                "1, 2 and 3"
            ),
            listOf(
                "केवल 2 और 3",
                "केवल 1 और 2",
                "केवल 1 और 3",
                "1, 2 और 3"
            ),
            "Statements 2 and 3 are correct; Statement 1 is INCORRECT (Directly asked in UPSC CSE Prelims 2020, 2021 & 2023)! Under an Expansionist Monetary Policy, the RBI REDUCES (cuts) the MSF Rate, Repo Rate, and Bank Rate; increasing the MSF rate is a contractionary measure.",
            "कथन 2 और 3 सही हैं; कथन 1 गलत है (UPSC CSE 2020, 2021 व 2023)! प्रसारवादी मौद्रिक नीति के अंतर्गत RBI सीमांत स्थायी सुविधा (MSF) दर और रेपो दर में कटौती करता है, बढ़ोतरी नहीं।",
            "UPSC CSE Pre PYQ 2020, 2021, 2023"
        ),
        RawUpscPyqSeed(
            "In the context of Indian Economy, consider the following statements regarding Money Multiplier, High Powered Money, and Demand Deposits (UPSC CSE 2020–2021):\n1. 'Money Multiplier' (M3 / M0) in an economy increases with an increase in the banking habit of the population and decreases with an increase in the Cash Reserve Ratio (CRR).\n2. If you withdraw ₹1,00,000 in cash from your Demand Deposit (Savings/Current) Account at your bank, the immediate effect on aggregate money supply (M1/M3) in the economy is to LEAVE IT UNCHANGED (as currency with public increases by ₹1 lakh while demand deposits decrease by ₹1 lakh).\n3. Foreign currency convertible bonds (FCCBs) and Foreign Institutional Investment with certain conditions are included in Foreign Direct Investment (FDI) calculations.\nHow many of the statements above are correct?",
            "भारतीय अर्थव्यवस्था में 'मुद्रा गुणक' (Money Multiplier) और 'माँग जमा' (UPSC CSE 2020–2021) के संदर्भ में विचार कीजिए:\n1. जनसंख्या की बैंकिंग आदतों में वृद्धि होने से अर्थव्यवस्था में 'मुद्रा गुणक' बढ़ता है, जबकि नकद आरक्षित अनुपात (CRR) बढ़ने से मुद्रा गुणक घटता है।\n2. यदि आप अपने बैंक के माँग जमा खाते (बचत/चालू खाते) से ₹1,00,000 नकद निकालते हैं, तो अर्थव्यवस्था में समग्र मुद्रा आपूर्ति (M1/M3) पर तत्काल प्रभाव यह होगा कि वह 'अपरिवर्तित' (Unchanged) रहेगी।\n3. कुछ शर्तों के साथ विदेशी संस्थागत निवेश और विदेशी मुद्रा परिवर्तनीय बॉन्ड (FCCBs) प्रत्यक्ष विदेशी निवेश (FDI) में शामिल हो सकते हैं।\nउपर्युक्त में से कितने कथन सही हैं?",
            listOf(
                "All three (1, 2 and 3 are correct)",
                "Only two",
                "Only one",
                "None"
            ),
            listOf(
                "सभी तीन (1, 2 और 3 सही हैं)",
                "केवल दो",
                "केवल एक",
                "कोई भी नहीं"
            ),
            "Statement 1 was asked in UPSC CSE 2021 (and 2019), and Statement 2 ('withdrawing ₹1,00,000 in cash from your Demand Deposit Account') was asked in UPSC CSE 2020! Because M1 = Currency with Public (CU) + Demand Deposits (DD) + Other Deposits with RBI, shifting ₹1 lakh from DD to CU keeps M1 unchanged immediately.",
            "कथन 1 UPSC CSE 2021 में और कथन 2 (माँग जमा खाते से ₹1,00,000 नकद निकालने पर कुल मुद्रा आपूर्ति का अपरिवर्तित रहना) UPSC CSE 2020 में सीधा पूछा गया था!",
            "UPSC CSE Pre PYQ 2020 & 2021"
        ),
        RawUpscPyqSeed(
            "With reference to Financial Markets: 'Capital Market' vs 'Money Market' and 'Treasury Bills / G-Secs' (Asked in UPSC CSE 2020–2023), consider the following statements:\n1. Treasury Bills (91-day, 182-day, 364-day) and Call Money Market belong to the short-term 'Money Market' (maturity up to 1 year), whereas Government Dated Bonds (G-Secs) and Equities belong to the long-term 'Capital Market'.\n2. Treasury Bills are zero-coupon securities issued at a discount and redeemed at par (face value) by the Central Government only (State Governments CANNOT issue Treasury Bills).\n3. Retail investors can directly open a 'RBI Retail Direct Gilt Account' with the RBI to buy and sell Government Securities in both primary and secondary markets.\nWhich of the statements given above are correct?",
            "वित्तीय बाजार: 'पूंजी बाजार बनाम मुद्रा बाजार' और 'ट्रेजरी बिल / सरकारी प्रतिभूतियों' (UPSC CSE 2020–2023) के संदर्भ में विचार कीजिए:\n1. ट्रेजरी बिल (91, 182, 364 दिन) और कॉल मनी मार्केट अल्पकालिक 'मुद्रा बाजार' (Money Market) के अंग हैं, जबकि सरकारी बॉन्ड और शेयर दीर्घकालिक 'पूंजी बाजार' (Capital Market) के अंग हैं।\n2. ट्रेजरी बिल शून्य-कूपन प्रतिभूतियाँ हैं जो बट्टे (Discount) पर जारी और सममूल्य (Par) पर भुनाई जाती हैं; इन्हें केवल केंद्र सरकार जारी करती है (राज्य सरकारें ट्रेजरी बिल जारी नहीं कर सकतीं)।\n3. खुदरा निवेशक सीधे आरबीआई के साथ 'रिटेल डायरेक्ट गिल्ट खाता' खोलकर सरकारी प्रतिभूतियाँ (G-Secs) खरीद और बेच सकते हैं।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf(
                "1, 2 and 3 (All three statements are correct)",
                "1 and 2 only",
                "2 and 3 only",
                "1 and 3 only"
            ),
            listOf(
                "1, 2 और 3 (तीनों कथन सही हैं)",
                "केवल 1 और 2",
                "केवल 2 और 3",
                "केवल 1 और 3"
            ),
            "Directly asked in UPSC CSE Prelims 2023 (Capital Market vs Money Market instruments) and UPSC CSE 2021 (Retail investors in G-Secs & Treasury Bills)!",
            "UPSC CSE 2023 (पूंजी बाजार बनाम मुद्रा बाजार के साधन) और UPSC CSE 2021 (खुदरा निवेशकों द्वारा सरकारी प्रतिभूतियों में निवेश) में सीधे पूछे गए प्रश्न!",
            "UPSC CSE Pre PYQ 2021 & 2023"
        ),
        RawUpscPyqSeed(
            "With reference to 'Inflation-Indexed Bonds' (IIBs) and 'Infrastructure Investment Trusts' (InvITs) in India (UPSC CSE 2022–2023), consider the following statements:\n1. Government can reduce the coupon rates on its borrowing by way of Inflation-Indexed Bonds (IIBs), and IIBs provide protection to the investors from uncertainty regarding inflation.\n2. Interest received as well as capital gains on IIBs are taxable (they are NOT exempt from tax).\n3. Interest income from deposits in Infrastructure Investment Trusts (InvITs) distributed to their investors is exempted from tax, while the dividend is taxable in the hands of investors; InvITs are recognized as borrowers under the SARFAESI Act, 2002.\nHow many of the statements above are correct?",
            "'मुद्रास्फीति-सूचकांकित बॉन्ड' (IIBs) और 'अवसंरचना निवेश न्यास' (InvITs — UPSC CSE 2022–2023) के संदर्भ में विचार कीजिए:\n1. सरकार IIBs के माध्यम से अपने ऋणग्रहण पर कूपन दरें कम कर सकती है और IIBs निवेशकों को मुद्रास्फीति की अनिश्चितता से सुरक्षा प्रदान करते हैं।\n2. IIBs पर प्राप्त ब्याज और पूंजीगत लाभ कर-योग्य (Taxable) होते हैं (कर-मुक्त नहीं)।\n3. InvITs को सरफेसी अधिनियम (SARFAESI Act, 2002) के तहत उधारकर्ता के रूप में मान्यता दी गई है।\nउपर्युक्त में से कितने कथन सही हैं?",
            listOf(
                "All three (1, 2 and 3 are correct)",
                "Only two",
                "Only one",
                "None"
            ),
            listOf(
                "सभी तीन (1, 2 और 3 सही हैं)",
                "केवल दो",
                "केवल एक",
                "कोई भी नहीं"
            ),
            "Statements 1 and 2 were asked in UPSC CSE Prelims 2022 (Inflation-Indexed Bonds), and Statement 3 (InvITs under SARFAESI Act) was asked in UPSC CSE Prelims 2023!",
            "कथन 1 और 2 UPSC CSE 2022 (मुद्रास्फीति-सूचकांकित बॉन्ड) में और कथन 3 (InvITs) UPSC CSE 2023 में सीधा पूछा गया था!",
            "UPSC CSE Pre PYQ 2022 & 2023"
        ),
        RawUpscPyqSeed(
            "With reference to Nominal Effective Exchange Rate (NEER), Real Effective Exchange Rate (REER), and Currency Devaluation (UPSC CSE 2021–2022), consider the following statements:\n1. An increase in Nominal Effective Exchange Rate (NEER) indicates the appreciation of the rupee against a basket of foreign currencies.\n2. An increase in the Real Effective Exchange Rate (REER) indicates a decrease in trade competitiveness (Indian exports become more expensive relative to foreign goods).\n3. An increasing trend in domestic inflation relative to inflation in other countries is likely to cause an increasing divergence between NEER and REER.\nWhich of the statements given above are correct?",
            "अंकित प्रभावी विनिमय दर (NEER) और वास्तविक प्रभावी विनिमय दर (REER — UPSC CSE 2022) के संदर्भ में विचार कीजिए:\n1. NEER में वृद्धि विदेशी मुद्राओं की टोकरी के मुकाबले रुपये के मूल्यवृद्धि (Appreciation) को दर्शाती है।\n2. REER में वृद्धि व्यापार प्रतिस्पर्धात्मकता में कमी को दर्शाती है (भारतीय निर्यात महँगे हो जाते हैं)।\n3. अन्य देशों की तुलना में घरेलू मुद्रास्फीति में बढ़ने की प्रवृत्ति से NEER और REER के बीच अपसरण (अंतर) बढ़ने की संभावना होती है।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf(
                "1, 2 and 3 (All three statements are correct)",
                "1 and 2 only",
                "2 and 3 only",
                "1 and 3 only"
            ),
            listOf(
                "1, 2 और 3 (तीनों कथन सही हैं)",
                "केवल 1 और 2",
                "केवल 2 और 3",
                "केवल 1 और 3"
            ),
            "Asked word-for-word in UPSC CSE Prelims 2022! REER adjusts NEER for inflation differentials between India and its major trading partners (36-currency / 40-currency basket). If REER > 100, the currency is overvalued and export competitiveness drops.",
            "UPSC CSE 2022 में हूबहू पूछा गया प्रश्न! REER मुद्रास्फीति के अंतर को समायोजित करता है। जब REER बढ़ता है, तो इसका अर्थ है कि भारतीय निर्यात महँगे हो रहे हैं और व्यापार प्रतिस्पर्धात्मकता घट रही है।",
            "UPSC CSE Pre PYQ 2022"
        ),
        RawUpscPyqSeed(
            "With reference to Central Bank Digital Currency (CBDC / Digital Rupee — e₹) (Asked in UPSC CSE 2023), consider the following statements:\n1. It is possible to make payments in a digital currency without using US dollar or SWIFT system.\n2. A digital currency can be distributed with a condition programmed into it such as a time-frame for spending it ('Programmable Money') or specific end-use.\n3. CBDC is a legal tender sovereign liability appearing directly on the Reserve Bank of India's balance sheet and is convertible at par with physical cash.\nHow many of the statements above are correct?",
            "सेंट्रल बैंक डिजिटल करेंसी (CBDC / डिजिटल रुपया — UPSC CSE 2023) के संदर्भ में विचार कीजिए:\n1. अमेरिकी डॉलर या SWIFT प्रणाली का उपयोग किए बिना डिजिटल मुद्रा में सीमा-पार भुगतान करना संभव है।\n2. डिजिटल मुद्रा को इसे खर्च करने की समय-सीमा या विशिष्ट उद्देश्य जैसी प्रोग्राम की गई शर्त ('प्रोग्रामेबल मनी') के साथ वितरित किया जा सकता है।\n3. CBDC भारतीय रिजर्व बैंक की बैलेंस शीट पर सीधे दर्ज होने वाली संप्रभु वैध मुद्रा (Legal Tender) है।\nउपर्युक्त में से कितने कथन सही हैं?",
            listOf(
                "All three (1, 2 and 3 are correct)",
                "Only two",
                "Only one",
                "None"
            ),
            listOf(
                "सभी तीन (1, 2 और 3 सही हैं)",
                "केवल दो",
                "केवल एक",
                "कोई भी नहीं"
            ),
            "Directly asked in UPSC CSE Prelims 2023! CBDC enables direct bilateral cross-border settlement without SWIFT and allows programmability (e.g., targeted subsidy vouchers or time-bound stimulus).",
            "UPSC CSE 2023 में सीधा पूछा गया प्रश्न! डिजिटल रुपया (CBDC) बिना SWIFT के द्विपक्षीय भुगतान और 'प्रोग्रामेबल मनी' की सुविधा प्रदान करता है।",
            "UPSC CSE Pre PYQ 2023"
        ),
        RawUpscPyqSeed(
            "Consider the following statements regarding 'Beta' in stock markets (UPSC CSE 2023) and 'Corporate Bonds / Tri-party Repo' (UPSC CSE 2024):\n1. In the context of finance, the term 'Beta' refers to a numeric value that measures the fluctuations (systematic volatility) of a stock to changes in the overall stock market.\n2. A stock with Beta > 1.0 is more volatile than the market index, while Beta < 1.0 is less volatile.\n3. In India, Corporate Bonds and Government Securities are traded in the secondary market, and 'Convertible Bonds' pay a lower rate of interest because they give the bondholder an option to convert them into equity shares (which acts as a hedge against inflation).\nWhich of the statements given above are correct?",
            "वित्तीय बाजार में 'बीटा' (Beta — UPSC CSE 2023) और 'परिवर्तनीय बॉन्ड' (Convertible Bonds — UPSC CSE 2022/2024) के संदर्भ में विचार कीजिए:\n1. वित्त के संदर्भ में 'बीटा' (Beta) एक संख्यात्मक मान है जो समग्र शेयर बाजार में होने वाले परिवर्तनों के सापेक्ष किसी स्टॉक के उतार-चढ़ाव (Volatility) को मापता है।\n2. जिस शेयर का बीटा 1.0 से अधिक होता है, वह बाजार सूचकांक की तुलना में अधिक अस्थिर होता है।\n3. 'परिवर्तनीय बॉन्ड' (Convertible Bonds) पर अपेक्षाकृत कम ब्याज दर मिलती है क्योंकि इनमें बॉन्डधारक को उन्हें इक्विटी शेयरों में बदलने का विकल्प मिलता है।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf(
                "1, 2 and 3 (All three statements are correct)",
                "1 and 2 only",
                "2 and 3 only",
                "1 and 3 only"
            ),
            listOf(
                "1, 2 और 3 (तीनों कथन सही हैं)",
                "केवल 1 और 2",
                "केवल 2 और 3",
                "केवल 1 और 3"
            ),
            "Statement 1 ('Beta' in finance) was directly asked in UPSC CSE Prelims 2023, and Statement 3 ('Convertible Bonds' paying lower interest & indexing to equity value) was asked in UPSC CSE Prelims 2022!",
            "कथन 1 (वित्त में 'बीटा' का अर्थ) UPSC CSE 2023 में और कथन 3 ('परिवर्तनीय बॉन्ड') UPSC CSE 2022 में सीधा पूछा गया था!",
            "UPSC CSE Pre PYQ 2022, 2023, 2024"
        ),
        RawUpscPyqSeed(
            "With reference to India's External Debt, Foreign Exchange Reserves, and Balance of Payments (UPSC CSE 2020–2023), consider the following statements:\n1. India's official Foreign Exchange Reserves held by RBI consist of four components: Foreign Currency Assets (FCA — largest share), Gold, Special Drawing Rights (SDRs), and Reserve Tranche Position (RTP) in the IMF.\n2. Most of India's external debt is owed by commercial corporate entities (External Commercial Borrowings & NRI deposits), NOT by the Government (sovereign debt is less than 25% of total external debt), and US Dollar-denominated debt accounts for the largest share.\n3. Under the IMF's 'Reserve Tranche', a member country can draw up to its reserve tranche quota without any service fee or economic policy conditionality.\nHow many of the statements above are correct?",
            "भारत के विदेशी मुद्रा भंडार और बाह्य ऋण (UPSC CSE 2020–2023) के संदर्भ में विचार कीजिए:\n1. RBI के पास रखे गए भारत के विदेशी मुद्रा भंडार के 4 घटक हैं: विदेशी मुद्रा परिसंपत्तियाँ (FCA — सर्वाधिक हिस्सा), स्वर्ण, विशेष आहरण अधिकार (SDR) और IMF के पास रिजर्व ट्रेंच पोजीशन (RTP)।\n2. भारत के कुल बाह्य ऋण (External Debt) में सर्वाधिक हिस्सा वाणिज्यिक उधारों (सरकारी ऋण नहीं) का है और अमेरिकी डॉलर मूल्यवर्ग का ऋण सर्वाधिक है।\n3. IMF की 'रिजर्व ट्रेंच' (Reserve Tranche) सुविधा के अंतर्गत सदस्य देश बिना किसी सेवा शुल्क या आर्थिक सुधार शर्त के अपनी कोटा राशि निकाल सकता है।\nउपर्युक्त में से कितने कथन सही हैं?",
            listOf(
                "All three (1, 2 and 3 are correct)",
                "Only two",
                "Only one",
                "None"
            ),
            listOf(
                "सभी तीन (1, 2 और 3 सही हैं)",
                "केवल दो",
                "केवल एक",
                "कोई भी नहीं"
            ),
            "All three were tested in UPSC CSE Prelims 2020, 2021, and 2023! 'Reserve Tranche' in IMF was directly asked in UPSC CSE 2020.",
            "तीनों कथन UPSC CSE 2020, 2021 और 2023 के प्रश्नों पर आधारित हैं! IMF का 'रिजर्व ट्रेंच' UPSC CSE 2020 में सीधा पूछा गया था।",
            "UPSC CSE Pre PYQ 2020, 2021, 2023"
        ),
        RawUpscPyqSeed(
            "With reference to Minimum Support Price (MSP), Public Distribution System, and Chemical Fertilizers in India (UPSC CSE 2020), consider the following statements:\n1. Currently, the retail price of chemical fertilizers like Urea is statutory/subsidized by the Government, and Ammonia (an input for Urea) is produced from natural gas.\n2. Sulphur, which is a raw material for Phosphoric Acid fertilizer, is a by-product of oil refineries.\n3. In the case of all cereals, pulses, and oilseeds, the procurement at Minimum Support Price (MSP) is theoretically open-ended (not capped by a fixed market-above-MSP rule, since MSP is always a floor price).\nWhich of the statements given above are correct?",
            "भारत में रासायनिक उर्वरकों और न्यूनतम समर्थन मूल्य (MSP — UPSC CSE 2020) के संदर्भ में विचार कीजिए:\n1. यूरिया के उत्पादन में प्रयुक्त होने वाली अमोनिया प्राकृतिक गैस (Natural Gas) से तैयार की जाती है।\n2. फॉस्फोरिक अम्ल उर्वरक के लिए कच्चा माल 'सल्फर' (गंधक) तेल रिफाइनरियों का एक उप-उत्पाद (By-product) है।\n3. सरकार द्वारा 22 अधिदेशित फसलों के लिए MSP तथा गन्ने के लिए 'उचित और लाभकारी मूल्य' (FRP) की घोषणा कृषि लागत और मूल्य आयोग (CACP) की सिफारिश पर आर्थिक मामलों की मंत्रिमंडलीय समिति (CCEA) द्वारा की जाती है।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf(
                "1, 2 and 3 (All three statements are correct)",
                "1 and 2 only",
                "2 and 3 only",
                "1 and 3 only"
            ),
            listOf(
                "1, 2 और 3 (तीनों कथन सही हैं)",
                "केवल 1 और 2",
                "केवल 2 और 3",
                "केवल 1 और 3"
            ),
            "Statements 1 and 2 were directly asked in UPSC CSE Prelims 2020 (Chemical Fertilizers question: Ammonia is produced from Natural Gas, and Sulphur is a by-product of oil refineries!).",
            "कथन 1 और 2 UPSC CSE 2020 के रासायनिक उर्वरक प्रश्न में सीधे पूछे गए थे (अमोनिया प्राकृतिक गैस से बनती है और सल्फर तेल रिफाइनरियों का उप-उत्पाद है)।",
            "UPSC CSE Pre PYQ 2020"
        ),
        RawUpscPyqSeed(
            "With reference to the Micro, Small and Medium Enterprises (MSMEs) and 'Small Farmer Large Field' (SFLF) concept (UPSC CSE 2023), consider the following statements:\n1. According to the revised MSME definition (2020), an enterprise with Investment in Plant & Machinery up to ₹50 crore and Annual Turnover up to ₹250 crore is classified as a 'Medium Enterprise' (Micro: ₹1 Cr / ₹5 Cr; Small: ₹10 Cr / ₹50 Cr).\n2. All bank loans to MSMEs qualify under the Priority Sector Lending (PSL) norms of the RBI.\n3. 'Small Farmer Large Field' (SFLF) is a collective action model where many marginal/small farmers in an area organize themselves and synchronize selected agricultural operations to achieve economies of scale.\nHow many of the statements above are correct?",
            "सूक्ष्म, लघु और मध्यम उद्यम (MSME) एवं 'स्मॉल फार्मर लार्ज फील्ड' (UPSC CSE 2023) के संदर्भ में विचार कीजिए:\n1. संशोधित MSME परिभाषा (2020) के अनुसार: सूक्ष्म (Micro) = निवेश ₹1 करोड़ व टर्नओवर ₹5 करोड़ तक; लघु (Small) = निवेश ₹10 करोड़ व टर्नओवर ₹50 करोड़ तक; मध्यम (Medium) = निवेश ₹50 करोड़ व टर्नओवर ₹250 करोड़ तक।\n2. बैंकों द्वारा MSMEs को दिए गए सभी ऋण भारतीय रिजर्व बैंक के 'प्राथमिकता प्राप्त क्षेत्र ऋण' (Priority Sector Lending - PSL) के अंतर्गत आते हैं।\n3. 'स्मॉल फार्मर लार्ज फील्ड' (SFLF) एक सामूहिक कृषि मॉडल है जिसमें क्षेत्र के अनेक सीमांत किसान अपनी कृषि क्रियाओं में समन्वय व सामंजस्य स्थापित कर बड़े पैमाने का लाभ उठाते हैं।\nउपर्युक्त में से कितने कथन सही हैं?",
            listOf(
                "All three (1, 2 and 3 are correct)",
                "Only two",
                "Only one",
                "None"
            ),
            listOf(
                "सभी तीन (1, 2 और 3 सही हैं)",
                "केवल दो",
                "केवल एक",
                "कोई भी नहीं"
            ),
            "All three statements were directly asked in UPSC CSE Prelims 2023! In the UPSC 2023 MSME question, Statement 1 gave ₹15 crore to ₹25 crore for Medium Enterprises (which was false because Medium is up to ₹50 crore investment and ₹250 crore turnover!).",
            "तीनों कथन UPSC CSE 2023 में सीधे पूछे गए हैं! मध्यम उद्यम (Medium Enterprise) की सीमा ₹50 करोड़ निवेश और ₹250 करोड़ वार्षिक टर्नओवर है।",
            "UPSC CSE Pre PYQ 2023"
        )
    )

    // =========================================================================
    // SECTION 5: UPSC CSE ENVIRONMENT, ECOLOGY & BIODIVERSITY — 50 PYQ Questions
    // =========================================================================
    private val environmentSeeds: List<RawUpscPyqSeed> = listOf(
        RawUpscPyqSeed(
            "With reference to Indian Wildlife Behavior and Ecology (Asked in UPSC CSE 2020–2024), consider the following statements:\n1. Indian Elephants: The leader of an elephant group is a female (matriarch); the maximum gestation period can be 22 months; and among all Indian states, Karnataka has the highest elephant population.\n2. Lion-tailed Macaque (Endemic to Western Ghats — Nilgiri/Silent Valley) is primarily a nocturnal and terrestrial carnivore.\n3. Orangutan (found in Borneo & Sumatra) is well known for using sticks/tools to scrape insects from tree holes and making leaf umbrellas.\nHow many of the statements above are correct?",
            "भारतीय एवं वैश्विक वन्यजीवों के व्यवहार व पारिस्थितिकी (UPSC CSE 2020–2024) के संदर्भ में विचार कीजिए:\n1. भारतीय हाथी: हाथियों के झुंड की प्रमुख एक मादा (हथिनी) होती है, अधिकतम गर्भावधि 22 माह होती है और भारत में सर्वाधिक हाथी कर्नाटक में पाए जाते हैं।\n2. सिंह-पुच्छी मकाक (Lion-tailed Macaque — पश्चिमी घाट का स्थानिक) मुख्यतः रात्रिचर (Nocturnal) और स्थलीय मांसाहारी प्राणी है।\n3. ओरंगउटान (बोर्नियो और सुमात्रा में पाया जाने वाला कपि) पेड़ के कोटरों से कीड़े निकालने के लिए छड़ी/औजार का उपयोग करने के लिए प्रसिद्ध है।\nउपर्युक्त में से कितने कथन सही हैं?",
            listOf(
                "Only two",
                "Only one",
                "All three",
                "None"
            ),
            listOf(
                "केवल दो",
                "केवल एक",
                "सभी तीन",
                "कोई भी नहीं"
            ),
            "Statements 1 and 3 are correct; Statement 2 is INCORRECT (Directly asked in UPSC CSE Prelims 2020 & 2023)! The Lion-tailed Macaque is DIURNAL (active during the day, NOT nocturnal) and primarily arboreal (tree-dwelling) and frugivorous, whereas the Malabar Civet and Sambar Deer are nocturnal.",
            "कथन 1 और 3 सही हैं; कथन 2 गलत है (UPSC CSE 2020 और 2023)! सिंह-पुच्छी मकाक (Lion-tailed Macaque) दिवाचर (दिन में सक्रिय, रात्रिचर नहीं) और वृक्षवासी व फलभक्षी प्राइमेट है।",
            "UPSC CSE Pre PYQ 2020 & 2023"
        ),
        RawUpscPyqSeed(
            "Consider the following statements regarding the Wildlife (Protection) Act, 1972 (and 2022 Amendment) and Biodiversity Heritage Sites (Asked in UPSC CSE 2020–2023):\n1. If a particular plant species is placed under Schedule VI (now Schedule III under the 2022 Amendment) of the Wildlife Protection Act, a licence is required to cultivate that plant.\n2. Under Section 37 of the Biological Diversity Act, 2002, State Governments in consultation with local bodies can notify areas of biodiversity importance as 'Biodiversity Heritage Sites' (BHS).\n3. 'Community Reserves' can be declared on private or community land where the Chief Wildlife Warden becomes the governing authority after declaration.\nWhich of the statements given above are correct?",
            "वन्यजीव (संरक्षण) अधिनियम, 1972 और जैव-विविधता अधिनियम, 2002 (UPSC CSE 2020–2023) के संदर्भ में विचार कीजिए:\n1. यदि किसी पादप प्रजाति को वन्यजीव संरक्षण अधिनियम की छठी अनुसूची (2022 संशोधन के बाद तीसरी अनुसूची) में रखा जाता है, तो उस पौधे की खेती करने के लिए लाइसेंस लेना आवश्यक होता है।\n2. जैव-विविधता अधिनियम, 2002 की धारा 37 के तहत राज्य सरकारें स्थानीय निकायों के परामर्श से 'जैव-विविधता विरासत स्थल' (BHS) अधिसूचित कर सकती हैं।\n3. 'कम्युनिटी रिजर्व' (Community Reserve) की घोषणा के बाद मुख्य वन्यजीव प्रतिपालक (Chief Wildlife Warden) उसका शासी प्राधिकारी बन जाता है।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf(
                "1, 2 and 3 (All three statements are correct)",
                "1 and 2 only",
                "2 and 3 only",
                "1 and 3 only"
            ),
            listOf(
                "1, 2 और 3 (तीनों कथन सही हैं)",
                "केवल 1 और 2",
                "केवल 2 और 3",
                "केवल 1 और 3"
            ),
            "Statement 1 was directly asked in UPSC CSE Prelims 2020, and Statement 3 ('Community Reserves' under WPA) was asked in UPSC CSE Prelims 2023! Note that the Wildlife (Protection) Amendment Act, 2022 rationalized the 6 Schedules into 4 Schedules (Schedule I: Highest protection; Schedule II: Lesser protection; Schedule III: Protected Plant species; Schedule IV: CITES appendices species; Vermin schedule was removed).",
            "कथन 1 UPSC CSE 2020 में और कथन 3 (कम्युनिटी रिजर्व) UPSC CSE 2023 में सीधा पूछा गया था! वन्यजीव (संरक्षण) संशोधन अधिनियम, 2022 ने 6 अनुसूचियों को घटाकर 4 अनुसूचियाँ कर दिया है।",
            "UPSC CSE Pre PYQ 2020 & 2023"
        ),
        RawUpscPyqSeed(
            "With reference to Biogeochemical Cycles (Phosphorus, Nitrogen, Sulphur & Carbon) and Detritivores (Asked in UPSC CSE 2021):\n1. Among the Carbon, Nitrogen, Phosphorus, and Sulphur cycles, the 'Phosphorus Cycle' is a sedimentary cycle where the weathering of rocks is the main source of release of nutrient into the ecosystem (it has NO gaseous atmospheric phase).\n2. Earthworms, Millipedes, and Woodlice are 'Detritivores' (organisms that feed on dead organic detritus).\n3. 'Blue Carbon' refers to carbon captured and stored by the world's ocean and coastal ecosystems (Mangroves, Tidal Marshes, and Seagrasses).\nHow many of the statements above are correct?",
            "जैव-भू-रासायनिक चक्रों और अपरदभोजी (Detritivores — UPSC CSE 2021) के संदर्भ में विचार कीजिए:\n1. कार्बन, नाइट्रोजन और फास्फोरस चक्रों में से 'फास्फोरस चक्र' एक अवसादी चक्र है जिसमें चट्टानों का अपक्षय (Weathering of rocks) पोषक तत्व के मुक्त होने का मुख्य स्रोत है।\n2. केंचुए (Earthworms), मिलीपीड (सहस्रपाद) और वुडलाइस 'अपरदभोजी' (Detritivores) हैं।\n3. 'ब्लू कार्बन' (Blue Carbon) महासागरों और तटीय पारिस्थितिकी तंत्रों (मैंग्रोव, लवण कच्छ और समुद्री घास) द्वारा प्रग्रहित कार्बन को कहा जाता है।\nउपर्युक्त में से कितने कथन सही हैं?",
            listOf(
                "All three (1, 2 and 3 are correct)",
                "Only two",
                "Only one",
                "None"
            ),
            listOf(
                "सभी तीन (1, 2 और 3 सही हैं)",
                "केवल दो",
                "केवल एक",
                "कोई भी नहीं"
            ),
            "All three were directly asked in UPSC CSE Prelims 2021! In the UPSC 2021 Detritivores question, Earthworms, Millipedes, and Woodlice are detritivores (whereas Jellyfish is a carnivorous cnidarian and Seahorse is a carnivorous fish).",
            "तीनों प्रश्न UPSC CSE प्रारंभिक परीक्षा 2021 में सीधे पूछे गए थे! फास्फोरस चक्र का मुख्य स्रोत चट्टानों का अपक्षय है, केंचुए/मिलीपीड/वुडलाइस अपरदभोजी हैं और 'ब्लू कार्बन' तटीय व समुद्री पारिस्थितिकी तंत्र द्वारा संग्रहित कार्बन है।",
            "UPSC CSE Pre PYQ 2021"
        ),
        RawUpscPyqSeed(
            "With reference to Wetlands and Ramsar Sites in India (Asked in UPSC CSE 2022–2023), consider the following statements:\n1. 'If rainforests and tropical forests are the lungs of the Earth, then surely wetlands function as its kidneys' — because wetlands absorb heavy metals, excess nutrients, and sediments from runoff.\n2. Match the Ramsar Wetlands with their States (UPSC 2022): Hokera Wetland — Jammu & Kashmir; Renuka Wetland (smallest Ramsar site in India) — Himachal Pradesh; Rudrasagar Lake — Tripura; Sasthamkotta Lake — Kerala.\n3. Marshes are dominated by herbaceous plants (reeds/grasses), whereas Swamps are wetlands dominated by woody trees.\nWhich of the statements given above are correct?",
            "आर्द्रभूमियों (Wetlands) और रामसर स्थलों (UPSC CSE 2022–2023) के संदर्भ में विचार कीजिए:\n1. 'यदि वर्षावन पृथ्वी के फेफड़े हैं, तो निश्चित रूप से आर्द्रभूमियाँ इसके गुर्दों (Kidneys) की तरह कार्य करती हैं' — क्योंकि आर्द्रभूमियाँ जल से भारी धातुओं, तलछट और अतिरिक्त पोषक तत्वों को अवशोषित कर जल को शुद्ध करती हैं।\n2. प्रमुख रामसर स्थल (UPSC 2022): होकेरा आर्द्रभूमि — जम्मू और कश्मीर; रेणुका आर्द्रभूमि (सबसे छोटा रामसर स्थल) — हिमाचल प्रदेश; रुद्रसागर झील — त्रिपुरा; सस्थमकोट्टा झील — केरल।\n3. कच्छ (Marshes) में शाकीय पौधों/घास की प्रधानता होती है, जबकि अनूप (Swamps) में काष्ठीय वृक्षों की प्रधानता होती है।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf(
                "1, 2 and 3 (All three statements are correct)",
                "1 and 2 only",
                "2 and 3 only",
                "1 and 3 only"
            ),
            listOf(
                "1, 2 और 3 (तीनों कथन सही हैं)",
                "केवल 1 और 2",
                "केवल 2 और 3",
                "केवल 1 और 3"
            ),
            "Statements 1 and 2 were directly asked in UPSC CSE Prelims 2022, and Statement 3 (Marshes vs Swamps) was tested in UPSC CSE 2023!",
            "कथन 1 और 2 UPSC CSE 2022 में और कथन 3 (कच्छ बनाम अनूप) UPSC CSE 2023 में सीधा पूछा गया था!",
            "UPSC CSE Pre PYQ 2022 & 2023"
        ),
        RawUpscPyqSeed(
            "Consider the following statements regarding Nitrogen-Fixing Plants, Bio-fertilizers, and Mycorrhizal Fungi (Asked in UPSC CSE 2021–2024):\n1. Alfalfa, Chickpea (Gram), Clover, Pea, and Groundnut are leguminous nitrogen-fixing plants (whereas Amaranth, Purslane, and Spinach are NOT nitrogen-fixing).\n2. Cyanobacteria (Anabaena, Nostoc) and Azospirillum / Rhizobium act as major bio-fertilizers; Anabaena azollae lives symbiotically inside the water fern Azolla used in paddy fields.\n3. Plants with Mycorrhizal symbiotic fungi associations resist drought better, tolerate higher soil pH extremes, and absorb phosphorus more efficiently.\nHow many of the statements above are correct?",
            "नाइट्रोजन-स्थिरीकरण करने वाले पादपों और जैव-उर्वरकों (UPSC CSE 2021–2024) के संदर्भ में विचार कीजिए:\n1. अल्फाल्फा (रिजका), चना (Chickpea), तिपतिया घास (Clover), मटर और मूंगफली नाइट्रोजन-स्थिरीकरण करने वाले फलीदार पौधे हैं (जबकि चौलाई/Amaranth और पालक नाइट्रोजन स्थिरीकरण नहीं करते)।\n2. सायनोबैक्टीरिया (एनाबीना, नॉस्टॉक), एजोस्पिरिलम और राइजोबियम प्रमुख जैव-उर्वरक हैं; 'एजोला' जलीय फर्न का उपयोग धान के खेतों में किया जाता है।\n3. कवक-मूल (Mycorrhizal fungi) सहजीवन पौधों को सूखे का प्रतिरोध करने और फास्फोरस का अवशोषण बढ़ाने में सहायता करता है।\nउपर्युक्त में से कितने कथन सही हैं?",
            listOf(
                "All three (1, 2 and 3 are correct)",
                "Only two",
                "Only one",
                "None"
            ),
            listOf(
                "सभी तीन (1, 2 और 3 सही हैं)",
                "केवल दो",
                "केवल एक",
                "कोई भी नहीं"
            ),
            "Statement 1 (Alfalfa, Chickpea, Clover as Nitrogen-fixing plants) and Statement 3 (Mycorrhizal biotechnology) were directly asked in UPSC CSE Prelims 2022!",
            "कथन 1 (अल्फाल्फा, चना और क्लोवर नाइट्रोजन-स्थिरीकरण करने वाले पौधे हैं) और कथन 3 (माइकोराइजा कवक) UPSC CSE 2022 में सीधे पूछे गए थे!",
            "UPSC CSE Pre PYQ 2022 & 2024"
        ),
        RawUpscPyqSeed(
            "With reference to Air Pollutants, Coal Ash, and WHO Air Quality Guidelines (Asked in UPSC CSE 2020–2023), consider the following statements:\n1. Coal ash contains arsenic, lead, and mercury; and coal-fired power plants release sulphur dioxide (SO2) and oxides of nitrogen (NOx) into the environment.\n2. Indian coal has a HIGH ash content (30–45%) but low sulphur content.\n3. According to the revised WHO Air Quality Guidelines (2021), the 24-hour mean of PM2.5 should not exceed 15 µg/m³ and the annual mean of PM2.5 should not exceed 5 µg/m³; excessive ozone pollution is highest during sunny afternoons.\nWhich of the statements given above are correct?",
            "कोयला राख (Coal Ash) और विश्व स्वास्थ्य संगठन (WHO) के वायु गुणवत्ता दिशानिर्देशों (UPSC CSE 2020–2022) के संदर्भ में विचार कीजिए:\n1. कोयले की राख में आर्सेनिक, सीसा (Lead) और पारा (Mercury) अंतर्विष्ट होते हैं तथा कोयला आधारित ताप बिजलीघर सल्फर डाइऑक्साइड (SO2) और नाइट्रोजन के ऑक्साइड उत्सर्जित करते हैं।\n2. भारतीय कोयले में राख की मात्रा (Ash content) अधिक (30–45%) किंतु सल्फर की मात्रा कम होती है।\n3. WHO के संशोधित वायु गुणवत्ता दिशानिर्देश (2021) के अनुसार PM2.5 का 24 घंटे का औसत 15 µg/m³ से अधिक और वार्षिक औसत 5 µg/m³ से अधिक नहीं होना चाहिए।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf(
                "1, 2 and 3 (All three statements are correct)",
                "1 and 2 only",
                "2 and 3 only",
                "1 and 3 only"
            ),
            listOf(
                "1, 2 और 3 (तीनों कथन सही हैं)",
                "केवल 1 और 2",
                "केवल 2 और 3",
                "केवल 1 और 3"
            ),
            "Statements 1 and 2 were asked verbatim in UPSC CSE Prelims 2020, and Statement 3 (WHO Air Quality Guidelines 2021: 24-hr PM2.5 <= 15 µg/m³ and annual <= 5 µg/m³) was asked in UPSC CSE Prelims 2022!",
            "कथन 1 और 2 UPSC CSE 2020 में और कथन 3 (WHO वायु गुणवत्ता दिशानिर्देश 2021) UPSC CSE 2022 में सीधा पूछा गया था!",
            "UPSC CSE Pre PYQ 2020 & 2022"
        ),
        RawUpscPyqSeed(
            "Consider the following Tiger Reserves, National Parks, and Biosphere Reserves of India (Asked in UPSC CSE 2020–2023):\n1. Desert National Park (Rajasthan): Spread over two districts (Jaisalmer and Barmer) and is the natural habitat of the Critically Endangered 'Great Indian Bustard'.\n2. Among all Tiger Reserves in India, Nagarjunsagar-Srisailam (Andhra Pradesh) has the largest area under 'Critical Tiger Habitat'.\n3. Kuno National Park (Madhya Pradesh — Project Cheetah site), Papikonda National Park (Andhra Pradesh), and Silent Valley National Park (Kerala — Kunti river flows through it).\nHow many of the statements above are correct?",
            "भारत के बाघ अभयारण्यों और राष्ट्रीय उद्यानों (UPSC CSE 2020–2023) के संदर्भ में विचार कीजिए:\n1. डेजर्ट नेशनल पार्क (मरुभूमि राष्ट्रीय उद्यान, राजस्थान) दो जिलों (जैसलमेर और बाड़मेर) में विस्तृत है और यह 'ग्रेट इंडियन बस्टर्ड' (गोडावण) का प्राकृतिक आवास है।\n2. भारत के सभी बाघ अभयारण्यों में 'नागार्जुनसागर-श्रीशैलम' (आंध्र प्रदेश) के अंतर्गत सर्वाधिक 'क्रिटिकल टाइगर हैबिटैट' क्षेत्रफल है।\n3. कूनो राष्ट्रीय उद्यान (म.प्र. — चीता परियोजना), पापीकोंडा राष्ट्रीय उद्यान (आंध्र प्रदेश) और साइलेंट वैली राष्ट्रीय उद्यान (केरल — कुंती नदी)।\nउपर्युक्त में से कितने कथन सही हैं?",
            listOf(
                "All three (1, 2 and 3 are correct)",
                "Only two",
                "Only one",
                "None"
            ),
            listOf(
                "सभी तीन (1, 2 और 3 सही हैं)",
                "केवल दो",
                "केवल एक",
                "कोई भी नहीं"
            ),
            "Statements 1 and 2 were directly asked in UPSC CSE Prelims 2020! Note that in Desert National Park, there ARE human habitations/villages inside the park (which made Statement 2 of the UPSC 2020 question false when it claimed 'no human habitation inside the Park').",
            "कथन 1 और 2 UPSC CSE 2020 में सीधे पूछे गए थे! मरुभूमि राष्ट्रीय उद्यान (जैसलमेर और बाड़मेर) ग्रेट इंडियन बस्टर्ड का प्रमुख आवास है और नागार्जुनसागर-श्रीशैलम भारत का सबसे बड़ा टाइगर रिजर्व है।",
            "UPSC CSE Pre PYQ 2020 & 2023"
        ),
        RawUpscPyqSeed(
            "With reference to 'Miyawaki Method', 'Biochar', 'Biorock Technology', and ' Invasive Species' (Asked in UPSC CSE 2020–2023), consider the following statements:\n1. The 'Miyawaki method' is well known for the creation of dense mini-forests in urban areas using native species.\n2. 'Biorock technology' (mineral accretion using low-voltage electric current in seawater) is used for the restoration of damaged Coral Reefs.\n3. 'Senna spectabilis' is an invasive alien tree species spreading rapidly in the Nilgiri Biosphere Reserve (Mudumalai/Wayanad), threatening native vegetation.\nWhich of the statements given above are correct?",
            "'मियावाकी पद्धति', 'बायोरॉक तकनीक' और 'आक्रामक विदेशी प्रजातियों' (UPSC CSE 2020–2023) के संदर्भ में विचार कीजिए:\n1. 'मियावाकी पद्धति' (Miyawaki Method) शहरी क्षेत्रों में देशी प्रजातियों के सघन लघु वनों (Mini-forests) के सृजन के लिए प्रसिद्ध है।\n2. 'बायोरॉक तकनीक' (Biorock Technology) का उपयोग क्षतिग्रस्त प्रवाल भित्तियों (Coral Reefs) की बहाली और पुनरुद्धार के लिए किया जाता है।\n3. 'सेना स्पेक्टाबिलिस' (Senna spectabilis) नीलगिरि बायोस्फीयर रिजर्व (मुदुमलाई/वायनाड) में तेजी से फैलने वाली एक आक्रामक विदेशी वृक्ष प्रजाति है।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf(
                "1, 2 and 3 (All three statements are correct)",
                "1 and 2 only",
                "2 and 3 only",
                "1 and 3 only"
            ),
            listOf(
                "1, 2 और 3 (तीनों कथन सही हैं)",
                "केवल 1 और 2",
                "केवल 2 और 3",
                "केवल 1 और 3"
            ),
            "Statements 1 and 2 were directly asked in UPSC CSE Prelims 2022, and Statement 3 ('Invasive species group' / Senna spectabilis / Prosopis juliflora / Lantana camara) was tested in UPSC CSE Prelims 2023!",
            "कथन 1 और 2 UPSC CSE 2022 में और कथन 3 (आक्रामक विदेशी प्रजातियाँ — सेना स्पेक्टाबिलिस, लैंटाना कैमारा) UPSC CSE 2023 में सीधा पूछा गया था!",
            "UPSC CSE Pre PYQ 2022 & 2023"
        ),
        RawUpscPyqSeed(
            "Consider the following statements regarding Global Climate Initiatives, Carbon Markets, and PFAS ('Forever Chemicals') (Asked in UPSC CSE 2021–2024):\n1. 'Common Carbon Metric', supported by UNEP, has been developed for assessing the carbon footprint of building operations around the world.\n2. The 'Climate Action Tracker' which monitors the emission reduction pledges of different countries is a database created by a coalition of research organizations.\n3. Perfluoroalkyl and Polyfluoroalkyl Substances (PFAS — 'Forever Chemicals') are widespread in drinking water, food packaging, and non-stick cookware; they do NOT degrade easily in the environment and bioaccumulate in animal tissues.\nHow many of the statements above are correct?",
            "वैश्विक जलवायु पहलों और 'पीएफएएस' (PFAS — 'फॉरएवर केमिकल्स' — UPSC CSE 2021–2024) के संदर्भ में विचार कीजिए:\n1. UNEP द्वारा समर्थित 'कॉमन कार्बन मेट्रिक' को विश्व भर में भवनों के संचालन के कार्बन फुटप्रिंट का आकलन करने के लिए विकसित किया गया है।\n2. विभिन्न देशों की उत्सर्जन कटौती प्रतिज्ञाओं की निगरानी करने वाला 'क्लाइमेट एक्शन ट्रैकर' अनुसंधान संगठनों के गठबंधन द्वारा बनाया गया एक डेटाबेस है।\n3. परफ्लूरोएल्किल और पॉलीफ्लूरोएल्किल पदार्थ (PFAS) पेयजल, खाद्य पैकेजिंग और नॉन-स्टिक बर्तनों में पाए जाते हैं; ये पर्यावरण में आसानी से विघटित नहीं होते और जीवों के ऊतकों में जमा (Bioaccumulate) हो जाते हैं।\nउपर्युक्त में से कितने कथन सही हैं?",
            listOf(
                "All three (1, 2 and 3 are correct)",
                "Only two",
                "Only one",
                "None"
            ),
            listOf(
                "सभी तीन (1, 2 और 3 सही हैं)",
                "केवल दो",
                "केवल एक",
                "कोई भी नहीं"
            ),
            "Statement 1 was asked in UPSC CSE 2021, Statement 2 in UPSC CSE 2022, and Statement 3 (PFAS / Forever Chemicals) was asked in UPSC CSE Prelims 2024!",
            "कथन 1 UPSC CSE 2021 में, कथन 2 UPSC CSE 2022 में और कथन 3 (PFAS — 'फॉरएवर केमिकल्स') UPSC CSE 2024 में सीधा पूछा गया था!",
            "UPSC CSE Pre PYQ 2021, 2022, 2024"
        ),
        RawUpscPyqSeed(
            "With reference to Insect Behaviour, Cicadas, and Honeybees (Asked in UPSC CSE 2023–2024), consider the following statements:\n1. 'Waggle Dance' is performed by Honeybees to communicate the direction and distance to a source of food (nectar/pollen) to other worker bees.\n2. Cicadas, Froghoppers, and Pond Skaters are all Insects (Class Insecta).\n3. Some mushrooms have medicinal properties, some have psychoactive properties, some have insecticidal properties, and some have bioluminescent (glow-in-the-dark, e.g., Roridomyces phyllostachydis in Meghalaya) properties.\nWhich of the statements given above are correct?",
            "कीट व्यवहार (हनीबी, सिकाडा) और मशरूम के गुणों (UPSC CSE 2023–2024) के संदर्भ में विचार कीजिए:\n1. मधुमक्खियों द्वारा अन्य श्रमिक मधुमक्खियों को भोजन (मकरंद/पराग) के स्रोत की दिशा और दूरी बताने के लिए 'वैगल डांस' (Waggle Dance) किया जाता है।\n2. सिकाडा (Cicada), फ्रॉगहॉपर और पॉन्ड स्केटर — ये तीनों 'कीट' (Insects) वर्ग के जीव हैं।\n3. कुछ मशरूमों में औषधीय गुण, कुछ में मनःप्रभावी (Psychoactive) गुण, कुछ में कीटनाशक गुण और कुछ में जीवदीप्ति (Bioluminescent — अंधेरे में चमकने) के गुण होते हैं।\nउपर्युक्त में से कौन-से कथन सही हैं?",
            listOf(
                "1, 2 and 3 (All three statements are correct)",
                "1 and 2 only",
                "2 and 3 only",
                "1 and 3 only"
            ),
            listOf(
                "1, 2 और 3 (तीनों कथन सही हैं)",
                "केवल 1 और 2",
                "केवल 2 और 3",
                "केवल 1 और 3"
            ),
            "Statements 1 and 3 were directly asked in UPSC CSE Prelims 2023 (Karl von Frisch won the Nobel Prize for decoding the Honeybee Waggle Dance!), and Statement 2 (Cicada, Froghopper & Pond Skater as Insects) was asked in UPSC CSE Prelims 2024!",
            "कथन 1 और 3 UPSC CSE 2023 में तथा कथन 2 (सिकाडा, फ्रॉगहॉपर और पॉन्ड स्केटर — कीट) UPSC CSE 2024 में सीधा पूछा गया था!",
            "UPSC CSE Pre PYQ 2023 & 2024"
        )
    )

    val upscGeography50Test: MockTest by lazy {
        val questions = buildUpsc50Questions(
            seeds = geographySeeds,
            subjectLabel = "UPSC CSE Geography (भारत एवं विश्व का भूगोल)",
            baseId = 13000
        )
        MockTest(
            testId = "upsc_sec_geography_50",
            title = "UPSC CSE Free Test 3: Indian & World Geography — 50 PYQ Questions",
            hindiTitle = "UPSC CSE निःशुल्क टेस्ट 3: भारत एवं विश्व का भूगोल — 50 PYQ प्रश्न",
            examName = "UPSC CSE Prelims — Geography (50 Qs)",
            durationMinutes = 60,
            totalMarks = 100,
            positiveMarks = 2.0,
            negativeMarks = 0.66,
            questions = questions,
            categoryId = "upsc",
            pyqAnalysisEn = "UPSC CSE Geography (50 Qs | Last 5 Years 2020–2025 PYQ Analysis): Covers Seismic P & S Waves, Jet Streams & Cyclone Eye thermodynamics, Earth's Freshwater distribution, Indus & Eastern Ghats River Systems, Critical Minerals (Monazite/Cobalt/Titanium), Cropping & Forest Trees (SRI/Jackfruit/Teak) & World Borders/Lakes.",
            pyqAnalysisHi = "UPSC CSE भूगोल (50 प्रश्न | विगत 5 वर्षीय 2020–2025 PYQ विश्लेषण): भूकंपीय P व S तरंगें, जेट स्ट्रीम एवं चक्रवात का 'चक्षु', पृथ्वी पर अलवण जल वितरण, सिंधु व पूर्वी घाट नदी तंत्र, क्रिटिकल मिनरल्स (मोनाजाइट/कोबाल्ट/टाइटेनियम), कृषि एवं विश्व की सीमाएँ व झीलें।",
            topicWeightage = listOf(
                "Physical Geography & Climatology (34%)",
                "Indian Rivers, Minerals & Agriculture (38%)",
                "World Mapping, Borders & Lakes (28%)"
            )
        )
    }

    val upscEconomics50Test: MockTest by lazy {
        val questions = buildUpsc50Questions(
            seeds = economySeeds,
            subjectLabel = "UPSC CSE Indian Economy (भारतीय अर्थव्यवस्था)",
            baseId = 14000
        )
        MockTest(
            testId = "upsc_sec_economics_50",
            title = "UPSC CSE Free Test 4: Indian Economy & Banking — 50 PYQ Questions",
            hindiTitle = "UPSC CSE निःशुल्क टेस्ट 4: भारतीय अर्थव्यवस्था एवं बैंकिंग — 50 PYQ प्रश्न",
            examName = "UPSC CSE Prelims — Economy (50 Qs)",
            durationMinutes = 60,
            totalMarks = 100,
            positiveMarks = 2.0,
            negativeMarks = 0.66,
            questions = questions,
            categoryId = "upsc",
            pyqAnalysisEn = "UPSC CSE Economy (50 Qs | Last 5 Years 2020–2025 PYQ Analysis): Covers RBI Monetary Policy & Sterilization, Money Multiplier & Demand Deposits, Capital Market vs Money Market (G-Secs/T-Bills/IIBs/InvITs/Convertible Bonds/Beta), NEER & REER, Digital Rupee (CBDC), External Debt & MSME/Agriculture MSP.",
            pyqAnalysisHi = "UPSC CSE भारतीय अर्थव्यवस्था (50 प्रश्न | विगत 5 वर्षीय 2020–2025 PYQ विश्लेषण): आरबीआई मौद्रिक नीति व स्टेरिलाइजेशन, मुद्रा गुणक व माँग जमा, पूंजी बाजार बनाम मुद्रा बाजार (G-Secs/T-Bills/IIBs/InvITs/बीटा), NEER व REER, डिजिटल रुपया (CBDC), बाह्य ऋण एवं MSME/MSP।",
            topicWeightage = listOf(
                "Monetary Policy, Banking & CBDC (34%)",
                "Capital & Money Markets (32%)",
                "BoP, Exchange Rate, MSME & Agri (34%)"
            )
        )
    }

    val upscEnvironment50Test: MockTest by lazy {
        val questions = buildUpsc50Questions(
            seeds = environmentSeeds,
            subjectLabel = "UPSC CSE Environment & Ecology (पर्यावरण एवं पारिस्थितिकी)",
            baseId = 15000
        )
        MockTest(
            testId = "upsc_sec_environment_50",
            title = "UPSC CSE Free Test 5: Environment, Ecology & Biodiversity — 50 PYQ Questions",
            hindiTitle = "UPSC CSE निःशुल्क टेस्ट 5: पर्यावरण, पारिस्थितिकी एवं जैव-विविधता — 50 PYQ प्रश्न",
            examName = "UPSC CSE Prelims — Environment (50 Qs)",
            durationMinutes = 60,
            totalMarks = 100,
            positiveMarks = 2.0,
            negativeMarks = 0.66,
            questions = questions,
            categoryId = "upsc",
            pyqAnalysisEn = "UPSC CSE Environment (50 Qs | Last 5 Years 2020–2025 PYQ Analysis): Covers Wildlife Behavior (Elephant/Lion-tailed Macaque/Orangutan/Honeybee/Cicada), Wildlife Protection Act Schedules & Community Reserves, Phosphorus Cycle & Detritivores, Ramsar Wetlands, Nitrogen-Fixing Plants, Coal Ash/WHO Air Quality & Miyawaki/Biorock/PFAS.",
            pyqAnalysisHi = "UPSC CSE पर्यावरण एवं पारिस्थितिकी (50 प्रश्न | विगत 5 वर्षीय 2020–2025 PYQ विश्लेषण): वन्यजीव व्यवहार (हाथी/सिंह-पुच्छी मकाक/ओरंगउटान/मधुमक्खी/सिकाडा), वन्यजीव संरक्षण अधिनियम, फास्फोरस चक्र व अपरदभोजी, रामसर आर्द्रभूमियाँ, नाइट्रोजन-स्थिरीकरण पादप, कोयला राख/WHO वायु गुणवत्ता एवं मियावाकी/बायोरॉक/PFAS।",
            topicWeightage = listOf(
                "Species Ecology, Behavior & Protected Areas (38%)",
                "Environmental Laws, Wetlands & Cycles (32%)",
                "Pollution, Climate Initiatives & Green Tech (30%)"
            )
        )
    }
}
