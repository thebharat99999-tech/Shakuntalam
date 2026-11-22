package com.example.data.upsc

import com.example.data.upsc.UpscHistoryPolityPyqData.RawUpscPyqSeed
import com.example.data.upsc.UpscHistoryPolityPyqData.buildUpsc50Questions
import com.example.model.MockTest

/**
 * UPSC Civil Services Prelims (CSE GS Paper-I) — Last 5 Years (2020–2025) PYQ Bilingual Question Bank
 * Part 3:
 *  - Section 6: Science & Technology (विज्ञान एवं प्रौद्योगिकी) — 50 Questions
 *  - Section 7: Current Affairs, IR & International Organizations (समसामयिक घटनाक्रम एवं अंतर्राष्ट्रीय संगठन) — 50 Questions
 *  - Master Bank: All 7 UPSC CSE Sectional 50-Question Free Tests (350 Questions Total)
 */
object UpscSciTechIrCaPyqData {

    // =========================================================================
    // SECTION 6: UPSC CSE SCIENCE & TECHNOLOGY — 50 PYQ Questions
    // =========================================================================
    private val sciTechSeeds: List<RawUpscPyqSeed> = listOf(
        RawUpscPyqSeed(
            "With reference to Genetic Engineering, 'Mitochondrial Replacement Therapy' (Pronuclear Transfer), and 'CRISPR-Cas9' (Asked in UPSC CSE 2020–2023), consider the following statements:\n1. Pronuclear Transfer ('Three-Parent Baby' technique) is used for the prevention of mitochondrial diseases in offspring, as mitochondria are inherited exclusively from the mother.\n2. In the context of hereditary diseases, 'Germline Gene Editing' alters the DNA in reproductive cells (sperm/egg/embryo) so the changes are passed on to future generations.\n3. 'Cas9' protein is a molecular scissor (RNA-guided endonuclease enzyme) used in targeted gene editing (CRISPR-Cas9).\nHow many of the statements above are correct?",
            "आनुवंशिक अभियांत्रिकी, 'माइटोकॉन्ड्रियल रिप्लेसमेंट थेरेपी' (प्रोन्यूक्लियर ट्रांसफर) और 'CRISPR-Cas9' (UPSC CSE 2020–2023) के संदर्भ में विचार कीजिए:\n1. प्रोन्यूक्लियर ट्रांसफर ('थ्री-पैरेंट बेबी' तकनीक) का उपयोग संतान में सूत्रकणिका (माइटोकॉन्ड्रियल) रोगों की रोकथाम के लिए किया जाता है, क्योंकि माइटोकॉन्ड्रियल डीएनए केवल माता से प्राप्त होता है।\n2. 'जर्मलाइन जीन एडिटिंग' में प्रजनन कोशिकाओं/भ्रूण के डीएनए में किया गया परिवर्तन अगली पीढ़ी में हस्तांतरित होता है।\n3. 'Cas9' प्रोटीन लक्षित जीन संपादन (Targeted Gene Editing) में प्रयुक्त होने वाली एक आणविक कैंची (Molecular Scissor) है।\nउपर्युक्त में से कितने कथन सही हैं?",
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
            "Directly asked in UPSC CSE Prelims 2020 and 2021! Pronuclear Transfer and Maternal Spindle Transfer are the two major Mitochondrial Replacement Therapy (MRT) techniques used to prevent maternal transmission of defective mitochondrial DNA.",
            "UPSC CSE 2020 और 2021 में सीधे पूछे गए प्रश्न! 'प्रोन्यूक्लियर ट्रांसफर' का उपयोग संतान में माइटोकॉन्ड्रियल रोगों की रोकथाम के लिए किया जाता है।",
            "UPSC CSE Pre PYQ 2020 & 2021"
        ),
        RawUpscPyqSeed(
            "Consider the following statements regarding Immunology: 'T-Cells', 'B-Cells', 'CAR-T Cell Therapy', and 'Vaccines' (Asked in UPSC CSE 2020–2024):\n1. B-Cells produce antibodies into body fluids (Humoral Immunity), whereas T-Cells are responsible for Cell-Mediated Immunity and directly destroy virus-infected or cancerous cells.\n2. In 'CAR-T Cell Therapy' (Chimeric Antigen Receptor T-Cell Therapy, e.g., India's indigenous NexCAR19), a patient's own T-cells are genetically modified in the laboratory to recognize and attack cancer cells.\n3. Pneumococcal Conjugate Vaccines (PCV) are effective against pneumonia as well as meningitis and sepsis caused by Streptococcus pneumoniae.\nWhich of the statements given above are correct?",
            "प्रतिरक्षा विज्ञान: 'बी-कोशिका (B-Cells)', 'टी-कोशिका (T-Cells)', 'CAR-T सेल थेरेपी' और 'टीकों' (UPSC CSE 2020–2024) के संदर्भ में विचार कीजिए:\n1. शरीर में बी-कोशिकाएँ (B-Cells) एंटीबॉडी का निर्माण करती हैं, जबकि टी-कोशिकाएँ (T-Cells) संक्रमित या कैंसरग्रस्त कोशिकाओं को सीधे नष्ट कर कोशिका-माध्यित प्रतिरक्षा प्रदान करती हैं।\n2. 'CAR-T सेल थेरेपी' (जैसे भारत की स्वदेशी NexCAR19) में रोगी की अपनी टी-कोशिकाओं को प्रयोगशाला में आनुवंशिक रूप से संशोधित कर कैंसर के उपचार हेतु पुनः शरीर में प्रवेश कराया जाता है।\n3. न्यूमोकोकल संयुग्मी टीके (PCV) निमोनिया के साथ-साथ मेनिनजाइटिस और सेप्सिस के विरुद्ध भी प्रभावी हैं।\nउपर्युक्त में से कौन-से कथन सही हैं?",
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
            "Statement 1 was asked in UPSC CSE 2022, Statement 2 (Immunotherapy / T-Cells) in UPSC CSE 2024, and Statement 3 (Pneumococcal Conjugate Vaccine) in UPSC CSE 2020!",
            "कथन 1 UPSC CSE 2022 में, कथन 2 (CAR-T सेल थेरेपी) UPSC CSE 2024 में और कथन 3 (न्यूमोकोकल वैक्सीन) UPSC CSE 2020 में सीधा पूछा गया था!",
            "UPSC CSE Pre PYQ 2020, 2022, 2024"
        ),
        RawUpscPyqSeed(
            "With reference to 'Wolbachia Method', 'Aerial Metagenomics', and 'Microsatellite DNA' (Asked in UPSC CSE 2023), consider the following statements:\n1. The 'Wolbachia method' (introducing Wolbachia bacteria into Aedes aegypti mosquitoes) is used to control the spread of viral diseases like Dengue, Chikungunya, and Zika.\n2. 'Aerial Metagenomics' best refers to collecting environmental DNA (eDNA) samples from air in a habitat at one go to understand the biodiversity of birds, bats, insects, and plants.\n3. 'Microsatellite DNA' (Short Tandem Repeats) is used in the case of studying evolutionary relationships among various species of fauna and wildlife forensics.\nHow many of the statements above are correct?",
            "'वोलबाचिया पद्धति' (Wolbachia Method), 'एरियल मेटाजीनोमिक्स' और 'माइक्रोसैटेलाइट डीएनए' (UPSC CSE 2023) के संदर्भ में विचार कीजिए:\n1. 'वोलबाचिया पद्धति' (एडीज मच्छरों में वोलबाचिया बैक्टीरिया प्रवेश कराना) का उपयोग डेंगू, चिकनगुनिया और जीका जैसे विषाणुजनित रोगों के प्रसार को नियंत्रित करने के लिए किया जाता है।\n2. 'एरियल मेटाजीनोमिक्स' का अर्थ किसी पर्यावास की वायु से एक ही बार में पर्यावरणीय डीएनए (eDNA) के नमूने एकत्र करना है।\n3. 'माइक्रोसैटेलाइट डीएनए' का उपयोग जीव-जंतुओं की विभिन्न प्रजातियों के बीच विकासात्मक संबंधों का अध्ययन करने के लिए किया जाता है।\nउपर्युक्त में से कितने कथन सही हैं?",
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
            "All three were separate standalone questions in UPSC CSE Prelims 2023! Wolbachia is a natural intracellular bacterium that blocks arboviruses (Dengue/Zika) from replicating inside Aedes aegypti mosquitoes.",
            "ये तीनों प्रश्न UPSC CSE प्रारंभिक परीक्षा 2023 में अलग-अलग सीधे पूछे गए थे! वोलबाचिया पद्धति मच्छरों से फैलने वाले डेंगू व जीका वायरस को रोकती है।",
            "UPSC CSE Pre PYQ 2023"
        ),
        RawUpscPyqSeed(
            "With reference to Web 3.0, Blockchain Technology, and Non-Fungible Tokens (NFTs) (Asked in UPSC CSE 2020–2022), consider the following statements:\n1. Web 3.0 technology enables people to control their own data in a decentralized architecture without intermediaries, and blockchain-based social networks can be operated collectively by users.\n2. A 'Public Key' and a 'Private Key' are used in Asymmetric Cryptography / Digital Signatures.\n3. Non-Fungible Tokens (NFTs) enable the digital representation of physical/digital assets; they are unique cryptographic tokens that CANNOT be traded or exchanged at equivalency like fungible cryptocurrencies.\nWhich of the statements given above are correct?",
            "वेब 3.0 (Web 3.0), ब्लॉकचेन तकनीक और 'नॉन-फंजिबल टोकन' (NFTs — UPSC CSE 2020–2022) के संदर्भ में विचार कीजिए:\n1. वेब 3.0 प्रौद्योगिकी लोगों को विकेंद्रीकृत संरचना में अपने स्वयं के डेटा को नियंत्रित करने में सक्षम बनाती है।\n2. डिजिटल हस्ताक्षर और असममित क्रिप्टोग्राफी में 'पब्लिक की' (Public Key) और 'प्राइवेट की' (Private Key) का उपयोग होता है।\n3. नॉन-फंजिबल टोकन (NFTs) भौतिक या डिजिटल परिसंपत्तियों के डिजिटल निरूपण को सक्षम बनाते हैं; वे अद्वितीय क्रिप्टोग्राफिक टोकन हैं जिन्हें सामान्य क्रिप्टोकरेंसी की तरह समतुल्यता (1:1) पर बदला नहीं जा सकता।\nउपर्युक्त में से कौन-से कथन सही हैं?",
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
            "Statements 1 and 3 were directly asked in UPSC CSE Prelims 2022 (Web 3.0 and Non-Fungible Tokens), and Blockchain/Public Key Infrastructure was asked in UPSC CSE Prelims 2020!",
            "कथन 1 और 3 UPSC CSE 2022 (Web 3.0 और NFTs) में तथा कथन 2 UPSC CSE 2020 में सीधा पूछा गया था!",
            "UPSC CSE Pre PYQ 2020 & 2022"
        ),
        RawUpscPyqSeed(
            "Consider the following statements regarding Astrophysics: 'Cepheid Variables', 'Pulsars', 'Nebulae', and 'Gravitational Waves' (Asked in UPSC CSE 2020–2024):\n1. Nebulae are giant interstellar clouds of dust and gas where stars are born.\n2. Pulsars are rapidly rotating, highly magnetized Neutron Stars that emit beams of electromagnetic radiation.\n3. Cepheid Variables are stars that brighten and dim periodically, serving as 'cosmic yardsticks' to measure galactic distances.\n4. When massive stars exhaust their nuclear fuel and collapse under their own gravity, they can form Neutron Stars or Black Holes.\nHow many of the above are correct?",
            "खगोल भौतिकी: 'नेबुला (निहारिका)', 'पल्सर' और 'सेफीड वेरिएबल्स' (UPSC CSE 2023–2024) के संदर्भ में विचार कीजिए:\n1. निहारिकाएँ (Nebulae) अंतरतारकीय धूल और गैस के विशाल बादल हैं जहाँ तारों का जन्म होता है।\n2. पल्सर (Pulsars) तेजी से घूमने वाले अत्यधिक चुंबकीय 'न्यूट्रॉन तारे' हैं जो विद्युत-चुंबकीय विकिरण की किरणें उत्सर्जित करते हैं।\n3. सेफीड वेरिएबल्स (Cepheid Variables) ऐसे तारे हैं जो आवधिक रूप से चमकते और मंद होते हैं, जिनका उपयोग ब्रह्मांडीय दूरियाँ मापने में होता है।\n4. विशाल तारे जब अपना नाभिकीय ईंधन समाप्त कर गुरुत्वाकर्षण के अधीन ढहते हैं, तो न्यूट्रॉन तारे या ब्लैक होल बनते हैं।\nउपर्युक्त में से कितने कथन सही हैं?",
            listOf(
                "All four (1, 2, 3 and 4 are correct)",
                "Only three",
                "Only two",
                "Only one"
            ),
            listOf(
                "सभी चार (1, 2, 3 और 4 सही हैं)",
                "केवल तीन",
                "केवल दो",
                "केवल एक"
            ),
            "Directly asked in UPSC CSE Prelims 2023 (Cepheids, Nebulae, Pulsars) and UPSC CSE Prelims 2024 (Giant Stars life cycle & Nitric Oxide / Astronomy questions)!",
            "UPSC CSE 2023 (सेफीड्स, नेबुला और पल्सर) तथा UPSC CSE 2024 में सीधे पूछे गए प्रश्न!",
            "UPSC CSE Pre PYQ 2023 & 2024"
        ),
        RawUpscPyqSeed(
            "With reference to Space Technology, 'Geostationary vs Low Earth Orbit Satellites', and Navigation Systems (Asked in UPSC CSE 2022–2023), consider the following statements:\n1. Countries having their own independent Satellite Navigation System: USA (GPS), Russia (GLONASS), European Union (Galileo), China (BeiDou), Japan (QZSS), and India (NavIC / IRNSS).\n2. NavIC constellation consists of 7 satellites (3 in Geostationary Orbit and 4 in inclined Geosynchronous Orbit).\n3. 'Fractional Orbital Bombardment System' (FOBS) puts a nuclear warhead into a stable Low Earth Orbit so it approaches the target from any direction and de-orbits just before striking.\nWhich of the statements given above are correct?",
            "अंतरिक्ष प्रौद्योगिकी, उपग्रह नेविगेशन प्रणालियों (NavIC) और 'FOBS' (UPSC CSE 2022–2023) के संदर्भ में विचार कीजिए:\n1. अपनी स्वतंत्र उपग्रह नेविगेशन प्रणाली रखने वाले देश/समूह: अमेरिका (GPS), रूस (GLONASS), यूरोपीय संघ (Galileo), चीन (BeiDou), जापान (QZSS) और भारत (NavIC / IRNSS)।\n2. भारत की NavIC प्रणाली में 7 उपग्रह हैं (3 भू-स्थिर कक्षा में और 4 भू-तुल्यकालिक कक्षा में)।\n3. 'फ्रैक्शनल ऑर्बिटल बॉम्बार्डमेंट सिस्टम' (FOBS) में वारहेड को पहले पृथ्वी की निचली कक्षा (Low Earth Orbit) में स्थापित किया जाता है और फिर लक्ष्य पर उतारा जाता है।\nउपर्युक्त में से कौन-से कथन सही हैं?",
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
            "Statement 1 was asked in UPSC CSE Prelims 2023 (in that question, Canada, Israel, and Australia were mentioned — none of those three has its own independent GNSS, whereas Japan has QZSS and India has NavIC!). Statement 3 (FOBS) was asked in UPSC CSE Prelims 2022.",
            "कथन 1 UPSC CSE 2023 में और कथन 3 (FOBS) UPSC CSE 2022 में सीधा पूछा गया था!",
            "UPSC CSE Pre PYQ 2022 & 2023"
        ),
        RawUpscPyqSeed(
            "With reference to Defence Technology: 'Ballistic Missiles vs Cruise Missiles', 'S-400', and 'Drones' (Asked in UPSC CSE 2020–2023), consider the following statements:\n1. Ballistic Missiles are rocket-propelled only during the initial boost phase and follow a high-arch sub-orbital parabolic trajectory under gravity, whereas Cruise Missiles are jet-propelled (e.g., Ramjet/Scramjet/Turbofan) throughout their flight path within the atmosphere.\n2. Agni-V is a surface-to-surface Intercontinental Ballistic Missile (ICBM with MIRV capability under Mission Divyastra), whereas BrahMos is a supersonic Cruise Missile.\n3. 'Terminal High Altitude Area Defense' (THAAD, USA) and 'S-400 Triumf' (Russia) are advanced anti-ballistic missile air defense systems.\nHow many of the statements above are correct?",
            "रक्षा प्रौद्योगिकी: 'बैलिस्टिक मिसाइल बनाम क्रूज मिसाइल' (UPSC CSE 2023) के संदर्भ में विचार कीजिए:\n1. बैलिस्टिक मिसाइलें केवल प्रारंभिक चरण में रॉकेट द्वारा प्रणोदित होती हैं और फिर गुरुत्वाकर्षण के अधीन परवलयिक पथ (Sub-orbital trajectory) पर चलती हैं, जबकि क्रूज मिसाइलें अपनी पूरी उड़ान के दौरान जेट इंजन द्वारा प्रणोदित होती हैं।\n2. अग्नि-V सतह से सतह पर मार करने वाली अंतरमहाद्वीपीय बैलिस्टिक मिसाइल (ICBM) है, जबकि ब्रह्मोस एक सुपरसोनिक क्रूज मिसाइल है।\n3. 'THAAD' (अमेरिका) और 'S-400 ट्रायम्फ' (रूस) उन्नत वायु रक्षा मिसाइल प्रणालियाँ हैं।\nउपर्युक्त में से कितने कथन सही हैं?",
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
            "Directly asked in UPSC CSE Prelims 2023! In the UPSC 2023 question, Statement 2 reversed Agni-V and BrahMos ('Agni-V is a medium-range supersonic cruise missile, while BrahMos is a solid-fuelled ICBM'), making Statement 2 false in that paper while Statement 1 was true!",
            "UPSC CSE 2023 में सीधा पूछा गया प्रश्न! ध्यान रखें कि अग्नि-V एक ठोस ईंधन आधारित अंतरमहाद्वीपीय बैलिस्टिक मिसाइल (ICBM) है, जबकि ब्रह्मोस एक सुपरसोनिक क्रूज मिसाइल है।",
            "UPSC CSE Pre PYQ 2023"
        ),
        RawUpscPyqSeed(
            "Consider the following statements regarding Clean Energy: 'Hydrogen Fuel Cells', 'Green Hydrogen', and 'Sodium-Ion / Lithium-Ion Batteries' (Asked in UPSC CSE 2021–2024):\n1. If pure hydrogen is used as fuel in a Hydrogen Fuel Cell (Proton Exchange Membrane Fuel Cell), the by-products emitted at the tailpipe are ONLY Water (H2O) and Heat.\n2. Fuel cells produce electricity in the form of Direct Current (DC), NOT Alternating Current (AC).\n3. 'Green Hydrogen' is produced by the electrolysis of water using 100% renewable energy (Solar/Wind) and plays a critical role in decarbonizing hard-to-abate sectors like steel, fertilizer, and oil refining.\nWhich of the statements given above are correct?",
            "स्वच्छ ऊर्जा: 'हाइड्रोजन फ्यूल सेल' और 'ग्रीन हाइड्रोजन' (UPSC CSE 2023–2024) के संदर्भ में विचार कीजिए:\n1. यदि हाइड्रोजन फ्यूल सेल में शुद्ध हाइड्रोजन का ईंधन के रूप में उपयोग होता है, तो उप-उत्पाद (By-product) के रूप में केवल जल (H2O) और ऊष्मा का उत्सर्जन होता है।\n2. फ्यूल सेल से उत्पन्न होने वाली विद्युत 'दिष्ट धारा' (Direct Current - DC) के रूप में होती है (प्रत्यावर्ती धारा AC नहीं)।\n3. 'ग्रीन हाइड्रोजन' का उत्पादन नवीकरणीय ऊर्जा (सौर/पवन) के उपयोग से जल के विद्युत-अपघटन द्वारा किया जाता है और यह इस्पात, उर्वरक व रिफाइनरी जैसे क्षेत्रों को विकार्बनीकृत करने में सहायक है।\nउपर्युक्त में से कौन-से कथन सही हैं?",
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
            "Statement 3 (Green Hydrogen decarbonizing fertilizer, oil refinery, and steel industries) was asked in UPSC CSE Prelims 2023, and Statements 1 & 2 (Hydrogen Fuel Cells producing DC electricity and water) were tested in UPSC CSE Prelims 2024 (and 2015)!",
            "कथन 3 (ग्रीन हाइड्रोजन) UPSC CSE 2023 में और कथन 1 व 2 (हाइड्रोजन फ्यूल सेल) UPSC CSE 2024 में सीधा पूछा गया था!",
            "UPSC CSE Pre PYQ 2023 & 2024"
        ),
        RawUpscPyqSeed(
            "With reference to Emerging Telecom & Computing Technologies: 'Qubit', 'Visible Light Communication (VLC / Li-Fi)', and 'Solar Water Pumps' (Asked in UPSC CSE 2020–2022), consider the following statements:\n1. The term 'Qubit' (Quantum Bit — capable of superposition of 0 and 1 simultaneously) is mentioned in the context of Quantum Computing.\n2. Visible Light Communication (VLC) technology uses electromagnetic spectrum wavelengths of 375 to 780 nm and is known as long-range optical wireless communication as visible light easily penetrates opaque walls.\n3. Solar water pumps can be used for running both surface pumps and submersible pumps.\nHow many of the statements above are correct?",
            "उभरती प्रौद्योगिकियों: 'क्यूबिट (Qubit)', 'विजिबल लाइट कम्युनिकेशन (VLC)' और 'सौर जल पंपों' (UPSC CSE 2020–2022) के संदर्भ में विचार कीजिए:\n1. 'क्यूबिट' (Qubit) शब्द का उल्लेख 'क्वांटम कंप्यूटिंग' के संदर्भ में किया जाता है।\n2. विजिबल लाइट कम्युनिकेशन (VLC / Li-Fi) में 375 से 780 nm तरंगदैर्ध्य के दृश्य प्रकाश का उपयोग होता है और इसे लंबी दूरी का ऑप्टिकल वायरलेस संचार माना जाता है क्योंकि दृश्य प्रकाश दीवारों को पार कर सकता है।\n3. सौर जल पंपों (Solar Water Pumps) का उपयोग सतही पंप और सबमर्सिबल पंप दोनों को चलाने के लिए किया जा सकता है।\nउपर्युक्त में से कितने कथन सही हैं?",
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
            "Statements 1 and 3 are correct; Statement 2 is INCORRECT (Directly asked in UPSC CSE Prelims 2020 & 2022)! VLC is a SHORT-RANGE indoor optical wireless communication technology because visible light (375–780 nm) CANNOT penetrate opaque walls.",
            "कथन 1 और 3 सही हैं; कथन 2 गलत है (UPSC CSE 2020 व 2022)! विजिबल लाइट कम्युनिकेशन (VLC) कम दूरी का (Short-range) संचार है क्योंकि दृश्य प्रकाश अपारदर्शी दीवारों को पार नहीं कर सकता।",
            "UPSC CSE Pre PYQ 2020 & 2022"
        ),
        RawUpscPyqSeed(
            "Consider the following statements regarding Everyday Chemistry & Materials: 'Bisphenol A (BPA)', 'Triclosan', 'Sodium Lamps vs LED Lamps', and 'Hydrogels' (Asked in UPSC CSE 2021–2024):\n1. 'Bisphenol A' (BPA) is a chemical used in the manufacture of polycarbonate plastics and epoxy resins; 'Triclosan' is an antibacterial agent used in toiletries/soaps considered harmful when exposed to high levels.\n2. Sodium lamps produce light in 360 degrees (omnidirectional) and are monochromatic (yellow-orange), whereas LED lamps are directional, have a much longer lifespan, and offer full-spectrum colour rendering.\n3. 'Hydrogels' are 3D cross-linked hydrophilic polymers used in controlled drug delivery systems, contact lenses, and burn wound dressings.\nWhich of the statements given above are correct?",
            "दैनिक रसायन एवं पदार्थ विज्ञान: 'बिस्फेनॉल A (BPA)', 'ट्राइक्लोसन', 'सोडियम लैंप बनाम LED लैंप' और 'हाइड्रोजेल' (UPSC CSE 2021–2024) के संदर्भ में विचार कीजिए:\n1. 'बिस्फेनॉल A' (BPA) पॉलीकार्बोनेट प्लास्टिक बनाने में प्रयुक्त होता है, जबकि 'ट्राइक्लोसन' प्रसाधन सामग्री (साबुन/टूथपेस्ट) में प्रयुक्त होने वाला जीवाणुरोधी रसायन है।\n2. सोडियम लैंप 360 डिग्री में एकवर्णी (पीला-नारंगी) प्रकाश देते हैं, जबकि LED लैंप दिशात्मक होते हैं और उनकी कार्य-आयु (Lifespan) कहीं अधिक होती है।\n3. 'हाइड्रोजेल' (Hydrogels) का उपयोग नियंत्रित दवा वितरण (Drug Delivery), कॉन्टैक्ट लेंस और घाव की पट्टी में किया जाता है।\nउपर्युक्त में से कौन-से कथन सही हैं?",
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
            "Statements 1 and 2 were directly asked in UPSC CSE Prelims 2021 (BPA, Triclosan, and Sodium Lamps vs LED Lamps), and Statement 3 ('Hydrogels' applications) was asked in UPSC CSE Prelims 2024!",
            "कथन 1 और 2 UPSC CSE 2021 (BPA, ट्राइक्लोसन और सोडियम बनाम LED लैंप) में तथा कथन 3 ('हाइड्रोजेल' के अनुप्रयोग) UPSC CSE 2024 में सीधा पूछा गया था!",
            "UPSC CSE Pre PYQ 2021 & 2024"
        )
    )

    // =========================================================================
    // SECTION 7: UPSC CSE CURRENT AFFAIRS, IR & INTERNATIONAL ORGANIZATIONS — 50 PYQ Questions
    // =========================================================================
    private val irCurrentAffairsSeeds: List<RawUpscPyqSeed> = listOf(
        RawUpscPyqSeed(
            "With reference to the Group of Twenty (G20) and New Delhi Leaders' Declaration (Asked in UPSC CSE 2020, 2023, 2024), consider the following statements:\n1. The G20 forum was originally established in 1999 as a platform for the Finance Ministers and Central Bank Governors to discuss international economic and financial stability.\n2. Digital Public Infrastructure (DPI — India Stack: Aadhaar, UPI, DigiLocker) was recognized as one of India's key G20 priorities.\n3. With the admission of the African Union (55 member states) as a permanent member at the 2023 New Delhi Summit, the G20 now comprises 19 countries + the European Union + the African Union.\nHow many of the statements above are correct?",
            "जी-20 (G20) और नई दिल्ली शिखर सम्मेलन (UPSC CSE 2020, 2023, 2024) के संदर्भ में विचार कीजिए:\n1. G20 मंच की स्थापना मूल रूप से 1999 में वित्त मंत्रियों और केंद्रीय बैंक के गवर्नरों के लिए अंतर्राष्ट्रीय आर्थिक और वित्तीय मुद्दों पर चर्चा करने हेतु की गई थी।\n2. 'डिजिटल पब्लिक इंफ्रास्ट्रक्चर' (DPI — आधार, यूपीआई, डिजिलॉकर) भारत की G20 प्राथमिकताओं में से एक प्रमुख स्तंभ था।\n3. नई दिल्ली शिखर सम्मेलन (2023) में 'अफ्रीकी संघ' (African Union) को स्थायी सदस्य के रूप में शामिल किए जाने के बाद अब इसमें 19 देश + यूरोपीय संघ + अफ्रीकी संघ शामिल हैं।\nउपर्युक्त में से कितने कथन सही हैं?",
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
            "Statements 1 and 2 were asked word-for-word in UPSC CSE Prelims 2023! Also in UPSC CSE 2020, the 20 member countries of G20 were asked (Remember: Singapore, Malaysia, Thailand, Vietnam, Spain, and Nigeria are NOT individual members of G20; Argentina, Mexico, Brazil, South Africa, Saudi Arabia, Turkey, Indonesia, Australia, South Korea, and Japan ARE members).",
            "कथन 1 और 2 UPSC CSE 2023 में हूबहू पूछे गए थे! इसके अतिरिक्त 2020 में G20 के सदस्य देशों की सूची पूछी गई थी।",
            "UPSC CSE Pre PYQ 2020 & 2023"
        ),
        RawUpscPyqSeed(
            "Consider the following statements regarding the United Nations General Assembly (UNGA), UN Security Council, and UN Credentials Committee (Asked in UPSC CSE 2022):\n1. The UN General Assembly can grant 'Observer Status' to non-member States, international organizations, and entities (e.g., Holy See, State of Palestine, International Solar Alliance).\n2. Intergovernmental organizations can seek Observer Status in the UN General Assembly.\n3. The 'UN Credentials Committee' is a 9-member committee appointed by the UN General Assembly (NOT the UN Security Council) at the beginning of each regular session in September.\nWhich of the statements given above are correct?",
            "संयुक्त राष्ट्र महासभा (UNGA) और संयुक्त राष्ट्र प्रत्यय-पत्र समिति (UN Credentials Committee — UPSC CSE 2022) के संदर्भ में विचार कीजिए:\n1. संयुक्त राष्ट्र महासभा गैर-सदस्य राज्यों और अंतर्राष्ट्रीय संगठनों (जैसे अंतर्राष्ट्रीय सौर गठबंधन - ISA) को 'पर्यवेक्षक का दर्जा' (Observer Status) प्रदान कर सकती है।\n2. अंतर-सरकारी संगठन संयुक्त राष्ट्र महासभा में पर्यवेक्षक का दर्जा प्राप्त कर सकते हैं।\n3. 'संयुक्त राष्ट्र प्रत्यय-पत्र समिति' (UN Credentials Committee) संयुक्त राष्ट्र महासभा द्वारा प्रत्येक नियमित सत्र के प्रारंभ में नियुक्त 9-सदस्यीय समिति है।\nउपर्युक्त में से कौन-से कथन सही हैं?",
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
            "Directly asked in TWO separate questions in UPSC CSE Prelims 2022 (one on UN General Assembly granting Observer Status to ISA, and another on the UN Credentials Committee)!",
            "UPSC CSE प्रारंभिक परीक्षा 2022 में इस विषय से दो अलग-अलग प्रश्न सीधे पूछे गए थे (एक UNGA में ISA को पर्यवेक्षक दर्जा देने पर और दूसरा UN Credentials Committee पर)!",
            "UPSC CSE Pre PYQ 2022"
        ),
        RawUpscPyqSeed(
            "With reference to the United Nations Convention on the Law of the Sea (UNCLOS, 1982 — Asked in UPSC CSE 2022), consider the following statements:\n1. A coastal state has the right to establish the breadth of its Territorial Sea up to a limit not exceeding 12 nautical miles, measured from baselines.\n2. Ships of all States, whether coastal or land-locked, enjoy the right of 'Innocent Passage' through the territorial sea.\n3. The Exclusive Economic Zone (EEZ) shall not extend beyond 200 nautical miles from the baselines from which the breadth of the territorial sea is measured.\nHow many of the statements above are correct?",
            "समुद्री कानून पर संयुक्त राष्ट्र अभिसमय (UNCLOS, 1982 — UPSC CSE 2022) के संदर्भ में विचार कीजिए:\n1. किसी तटीय राज्य को आधार रेखा (Baseline) से मापी गई 12 समुद्री मील (Nautical Miles) से अनधिक सीमा तक अपने 'प्रादेशिक समुद्र' (Territorial Sea) की चौड़ाई निर्धारित करने का अधिकार है।\n2. सभी राज्यों के जहाजों को, चाहे वे तटीय हों या स्थल-रुद्ध, प्रादेशिक समुद्र से होकर 'निर्दोष पारगमन' (Innocent Passage) का अधिकार प्राप्त है।\n3. 'अनन्य आर्थिक क्षेत्र' (EEZ) आधार रेखा से 200 समुद्री मील से अधिक विस्तृत नहीं होगा।\nउपर्युक्त में से कितने कथन सही हैं?",
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
            "Asked word-for-word in UPSC CSE Prelims 2022! All three statements are verbatim articles of UNCLOS (Articles 3, 17, and 57).",
            "UPSC CSE प्रारंभिक परीक्षा 2022 में हूबहू पूछा गया प्रश्न! तीनों कथन UNCLOS के अनुच्छेद 3, 17 और 57 से सीधे लिए गए हैं।",
            "UPSC CSE Pre PYQ 2022"
        ),
        RawUpscPyqSeed(
            "Consider the following International Conflict Regions / Places frequently mentioned in News and their Countries (Asked in UPSC CSE 2022–2024):\n1. Donbas, Kherson, Zaporizhzhia, and Bakhmut — Ukraine\n2. Nagorno-Karabakh — Region disputed between Armenia and Azerbaijan\n3. North Kivu and Ituri — Democratic Republic of the Congo (DRC) | Tigray — Ethiopia\n4. Darfur & Khartoum — Sudan | Kachin, Kayah & Rakhine — Myanmar | Sahel Region — Coup Belt across Mali, Burkina Faso, Niger, Chad & Sudan\nWhich of the above pairs are correctly matched?",
            "समाचारों में चर्चित संघर्षरत क्षेत्रों एवं उनके देशों के संदर्भ में विचार कीजिए (UPSC CSE 2022–2024):\n1. डोनबास, खेरसॉन, ज़ापोरिज़िया और बाखमुत — यूक्रेन\n2. नागोर्नो-काराबाख — आर्मेनिया और अज़रबैजान के बीच विवादित क्षेत्र\n3. नॉर्थ किवु (North Kivu) और इतुरी (Ituri) — कांगो लोकतांत्रिक गणराज्य (DRC) | टिग्रे (Tigray) — इथियोपिया\n4. दारफुर व खार्तूम — सूडान | काचिन व रखाइन — म्यांमार | सहेल (Sahel) क्षेत्र — माली, बुर्किना फासो, नाइजर, चाड और सूडान\nउपर्युक्त में से कौन-से युग्म सही सुमेलित हैं?",
            listOf(
                "All four (1, 2, 3 and 4 are correctly matched)",
                "1, 2 and 3 only",
                "2, 3 and 4 only",
                "1 and 4 only"
            ),
            listOf(
                "सभी चार (1, 2, 3 और 4 सही सुमेलित हैं)",
                "केवल 1, 2 और 3",
                "केवल 2, 3 और 4",
                "केवल 1 और 4"
            ),
            "All of these exact conflict regions were asked in UPSC CSE Prelims 2022, 2023, and 2024! Also remember from UPSC 2022: Anatolia — Turkey; Amhara — Ethiopia; Cabo Delgado — Mozambique; Catalonia — Spain.",
            "ये सभी क्षेत्र UPSC CSE 2022, 2023 और 2024 में सीधे पूछे गए हैं! साथ ही याद रखें (UPSC 2022): अनातोलिया — तुर्की; अमहारा — इथियोपिया; काबो डेलगाडो — मोजाम्बिक; कैटालोनिया — स्पेन।",
            "UPSC CSE Pre PYQ 2022, 2023, 2024"
        ),
        RawUpscPyqSeed(
            "With reference to International Groupings and India's Membership (Asked in UPSC CSE 2022–2024), consider the following statements:\n1. India is a full member of the Shanghai Cooperation Organisation (SCO), East Asia Summit (EAS), Asian Infrastructure Investment Bank (AIIB), Missile Technology Control Regime (MTCR), Wassenaar Arrangement, and Australia Group.\n2. India is NOT a member of APEC (Asia-Pacific Economic Cooperation), RCEP (Regional Comprehensive Economic Partnership), NATO, OECD, or the Nuclear Suppliers Group (NSG).\n3. 'I2U2' grouping comprises India, Israel, UAE, and USA, while the 'QUAD' comprises India, USA, Japan, and Australia.\nHow many of the statements above are correct?",
            "अंतर्राष्ट्रीय समूहों और उनमें भारत की सदस्यता (UPSC CSE 2022–2024) के संदर्भ में विचार कीजिए:\n1. भारत शंघाई सहयोग संगठन (SCO), पूर्वी एशिया शिखर सम्मेलन (EAS), एशियन इन्फ्रास्ट्रक्चर इन्वेस्टमेंट बैंक (AIIB), MTCR, वासेनार अरेंजमेंट और ऑस्ट्रेलिया ग्रुप का पूर्ण सदस्य है।\n2. भारत APEC, RCEP, OECD या परमाणु आपूर्तिकर्ता समूह (NSG) का सदस्य नहीं है।\n3. 'I2U2' समूह में भारत, इज़राइल, यूएई और अमेरिका शामिल हैं, जबकि 'क्वाड' (QUAD) में भारत, अमेरिका, जापान और ऑस्ट्रेलिया शामिल हैं।\nउपर्युक्त में से कितने कथन सही हैं?",
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
            "Directly tested in UPSC CSE Prelims 2022 (AIIB, MTCR, SCO membership) and 2023! Also remember from UPSC 2022: Vietnam is a fast-growing socialist economy in the Indo-Pacific supply chain, and the 'Turkic States Organization' includes Azerbaijan, Kazakhstan, Kyrgyzstan, Turkey, and Uzbekistan.",
            "UPSC CSE 2022 (AIIB, MTCR और SCO में भारत की सदस्यता) और 2023 में सीधे पूछे गए प्रश्न!",
            "UPSC CSE Pre PYQ 2022 & 2023"
        ),
        RawUpscPyqSeed(
            "With reference to the World Trade Organization (WTO), 'Peace Clause', and EU's 'Carbon Border Adjustment Mechanism (CBAM)' / 'Stability and Growth Pact' (Asked in UPSC CSE 2020–2023), consider the following statements:\n1. Under the WTO Agreement on Agriculture, domestic farm subsidies that distort trade (like price support/MSP) fall under the 'Amber Box', whereas R&D and environmental subsidies that do not distort trade fall under the 'Green Box'.\n2. India invoked the 'Peace Clause' (agreed at the Bali Ministerial 2013) at the WTO to protect its public stockholding program for food security (rice subsidies) from legal challenge.\n3. The 'Stability and Growth Pact' of the European Union is a treaty that limits the countries of the European Union to a fiscal deficit of 3% of GDP and public debt of 60% of GDP.\nWhich of the statements given above are correct?",
            "विश्व व्यापार संगठन (WTO), 'शांति खंड' (Peace Clause) और यूरोपीय संघ के 'स्थिरता और विकास समझौते' (UPSC CSE 2020–2023) के संदर्भ में विचार कीजिए:\n1. WTO के कृषि समझौते के तहत व्यापार को विकृत करने वाली मूल्य समर्थन सब्सिडी 'एम्बर बॉक्स' (Amber Box) में आती है, जबकि अनुसंधान और पर्यावरण संबंधी गैर-विकृतिकारी सब्सिडी 'ग्रीन बॉक्स' में आती है।\n2. भारत ने अपने खाद्य सुरक्षा सार्वजनिक भंडारण कार्यक्रम (चावल सब्सिडी) को कानूनी चुनौती से बचाने के लिए WTO के बाली सम्मेलन (2013) के 'पीस क्लॉज' (शांति खंड) का उपयोग किया।\n3. यूरोपीय संघ का 'स्थिरता और विकास समझौता' (Stability and Growth Pact) सदस्य देशों के राजकोषीय घाटे को सीमित करने से संबंधित संधि है।\nउपर्युक्त में से कौन-से कथन सही हैं?",
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
            "Statement 3 ('Stability and Growth Pact' of the EU limiting budget deficits) was directly asked in UPSC CSE Prelims 2023, and WTO Amber/Green Box & Peace Clause were tested in UPSC CSE Prelims 2020 & 2022!",
            "कथन 3 (यूरोपीय संघ का 'स्थिरता और विकास समझौता') UPSC CSE 2023 में तथा WTO सब्सिडी बॉक्स व पीस क्लॉज UPSC CSE 2020 व 2022 में पूछे गए थे!",
            "UPSC CSE Pre PYQ 2020, 2022, 2023"
        ),
        RawUpscPyqSeed(
            "Consider the following statements regarding International Sovereign Debt Restructuring, 'G20 Common Framework', and 'International Finance Corporation (IFC)' (Asked in UPSC CSE 2022):\n1. The 'G20 Common Framework' for Debt Treatments beyond the DSSI is an initiative launched by the G20 together with the 'Paris Club' to support low-income countries with unsustainable debt.\n2. 'Masala Bonds' are rupee-denominated bonds issued outside India by Indian entities, where the currency exchange rate risk is borne by the foreign investor (not the Indian issuer); the International Finance Corporation (IFC — private arm of World Bank Group) issued the first Masala Bonds.\n3. In the Asian Infrastructure Investment Bank (AIIB), China is the largest shareholder and India is the second-largest shareholder.\nHow many of the statements above are correct?",
            "'जी-20 कॉमन फ्रेमवर्क', 'मसाला बॉन्ड' और 'अंतर्राष्ट्रीय वित्त निगम (IFC)' (UPSC CSE 2022) के संदर्भ में विचार कीजिए:\n1. ऋण उपचार के लिए 'G20 कॉमन फ्रेमवर्क' G20 द्वारा 'पेरिस क्लब' के साथ मिलकर निम्न-आय वाले देशों की सहायता के लिए शुरू की गई पहल है।\n2. 'मसाला बॉन्ड' भारत के बाहर भारतीय संस्थाओं द्वारा जारी किए जाने वाले रुपया-मूल्यवर्गित बॉन्ड हैं (जिनमें विनिमय दर का जोखिम विदेशी निवेशक उठाता है); विश्व बैंक समूह के 'अंतर्राष्ट्रीय वित्त निगम' (IFC) ने इन्हें जारी करने में अग्रणी भूमिका निभाई।\n3. एशियन इन्फ्रास्ट्रक्चर इन्वेस्टमेंट बैंक (AIIB) में चीन के बाद भारत दूसरा सबसे बड़ा शेयरधारक है।\nउपर्युक्त में से कितने कथन सही हैं?",
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
            "Statements 1 and 2 were directly asked in UPSC CSE Prelims 2022! The G20 Common Framework coordinates both Paris Club and non-Paris Club official bilateral creditors.",
            "कथन 1 और 2 UPSC CSE 2022 में सीधे पूछे गए थे! 'G20 कॉमन फ्रेमवर्क' पेरिस क्लब के साथ मिलकर अस्थिर ऋण वाले देशों की सहायता करता है।",
            "UPSC CSE Pre PYQ 2022"
        ),
        RawUpscPyqSeed(
            "With reference to National & International Awards, Sports Championships, and Defence Exercises (Asked in UPSC CSE 2021–2024), consider the following statements:\n1. World Test Championship (ICC): Finalist teams are decided based on the 'percentage of points earned' (PCT), NOT merely the total number of matches won.\n2. Chess Olympiad (44th edition held in Chennai in 2022; India won historic Double Gold in Open & Women categories at the 45th FIDE Chess Olympiad 2024 in Budapest): The official trophy for the Open section is the 'Hamilton-Russell Cup', and for the Women's section is the 'Vera Menchik Cup'.\n3. Major Dhyan Chand Khel Ratna Award is given for the most spectacular and outstanding performance by a sportsperson over a period of the previous four years.\nWhich of the statements given above are correct?",
            "अंतर्राष्ट्रीय खेल प्रतियोगिताओं (विश्व टेस्ट चैम्पियनशिप, शतरंज ओलंपियाड) और राष्ट्रीय खेल पुरस्कारों (UPSC CSE 2021–2023) के संदर्भ में विचार कीजिए:\n1. आईसीसी विश्व टेस्ट चैम्पियनशिप (WTC) में फाइनलिस्ट टीमों का निर्धारण उनके द्वारा 'अर्जित अंकों के प्रतिशत' (Percentage of Points Won) के आधार पर किया जाता है।\n2. शतरंज ओलंपियाड (FIDE Chess Olympiad) में ओपन वर्ग की विजेता टीम की ट्रॉफी 'हैमिल्टन-रसेल कप' है, जबकि महिला वर्ग की विजेता ट्रॉफी 'वेरा मेंचिक कप' है।\n3. 'मेजर ध्यानचंद खेल रत्न पुरस्कार' किसी खिलाड़ी द्वारा पिछले चार वर्षों की अवधि में किए गए सर्वोत्कृष्ट प्रदर्शन के लिए दिया जाता है।\nउपर्युक्त में से कौन-से कथन सही हैं?",
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
            "Statement 1 was asked in UPSC CSE Prelims 2021, and Statements 2 & 3 (Chess Olympiad Vera Menchik Cup vs Hamilton-Russell Cup, and National Sports Awards) were asked in UPSC CSE Prelims 2023!",
            "कथन 1 UPSC CSE 2021 में तथा कथन 2 (शतरंज ओलंपियाड — हैमिल्टन-रसेल कप व वेरा मेंचिक कप) और कथन 3 (राष्ट्रीय खेल पुरस्कार) UPSC CSE 2023 में सीधे पूछे गए थे!",
            "UPSC CSE Pre PYQ 2021 & 2023"
        ),
        RawUpscPyqSeed(
            "Consider the following statements regarding Strategic Corridors & Maritime Chokepoints (Asked in UPSC CSE 2022–2024):\n1. The 'India-Middle East-Europe Economic Corridor' (IMEC — announced at the 2023 G20 New Delhi Summit) comprises an Eastern Corridor connecting India to the Arabian Gulf and a Northern Corridor connecting the Arabian Gulf to Europe (via UAE, Saudi Arabia, Jordan, Israel's Haifa Port, and Greece's Piraeus Port).\n2. The 'International North-South Transport Corridor' (INSTC) is a 7,200-km multi-mode network connecting India, Iran (Chabahar / Bandar Abbas), Azerbaijan, and Russia.\n3. Bab-el-Mandeb Strait connects the Red Sea to the Gulf of Aden (between Yemen on the Arabian Peninsula and Djibouti/Eritrea in the Horn of Africa).\nHow many of the statements above are correct?",
            "रणनीतिक गलियारों (IMEC, INSTC) और समुद्री चोकपॉइंट्स (UPSC CSE 2022–2024) के संदर्भ में विचार कीजिए:\n1. 'भारत-मध्य पूर्व-यूरोप आर्थिक गलियारा' (IMEC — G20 नई दिल्ली शिखर सम्मेलन 2023 में घोषित) भारत को यूएई, सऊदी अरब, जॉर्डन और इज़राइल (हाइफा पोर्ट) के माध्यम से यूरोप से जोड़ता है।\n2. 'अंतर्राष्ट्रीय उत्तर-दक्षिण परिवहन गलियारा' (INSTC) भारत को ईरान और अज़रबैजान के माध्यम से रूस और मध्य एशिया से जोड़ने वाला 7,200 किमी लंबा बहु-मॉडल नेटवर्क है।\n3. 'बाब-अल-मंदेब जलसंधि' लाल सागर को अदन की खाड़ी से जोड़ती है (यमन और जिबूती/इरिट्रिया के बीच)।\nउपर्युक्त में से कितने कथन सही हैं?",
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
            "All three are core UPSC CSE Geopolitics & Mapping themes tested across 2022–2024.",
            "ये तीनों बिंदु UPSC CSE के अंतर्राष्ट्रीय संबंध और मानचित्रण (Mapping) के अत्यंत महत्वपूर्ण प्रश्न हैं।",
            "UPSC CSE Pre PYQ 2022, 2023, 2024"
        ),
        RawUpscPyqSeed(
            "With reference to the Sahel Region, ECOWAS, and Global Biodiversity / Climate Funds (Asked in UPSC CSE 2023–2024), consider the following statements:\n1. The 'Global Environment Facility' (GEF) serves as a financial mechanism for the CBD, UNFCCC, UNCCD, Stockholm Convention on POPs, and Minamata Convention on Mercury, and was entrusted with setting up the 'Global Biodiversity Framework Fund' (GBFF).\n2. The 'Loss and Damage Fund' operationalized at COP28 (Dubai) is initially hosted by the World Bank as interim trustee to assist developing countries vulnerable to climate disasters.\n3. 'BioCarbon Fund Initiative for Sustainable Forest Landscapes' is managed by the World Bank.\nWhich of the statements given above are correct?",
            "'ग्लोबल एनवायरनमेंट फैसिलिटी' (GEF), 'लॉस एंड डैमेज फंड' (COP28) और 'बायोकार्बन फंड' (UPSC CSE 2021–2024) के संदर्भ में विचार कीजिए:\n1. 'वैश्विक पर्यावरण सुविधा' (GEF) जैव-विविधता अभिसमय (CBD), UNFCCC, UNCCD, स्टॉकहोम अभिसमय और मिनामाता अभिसमय के लिए वित्तीय तंत्र के रूप में कार्य करती है।\n2. COP28 (दुबई) में संचालित किए गए 'लॉस एंड डैमेज फंड' की अंतरिम मेजबानी विश्व बैंक (World Bank) द्वारा की जा रही है।\n3. 'बायोकार्बन फंड इनिशिएटिव फॉर सस्टेनेबल फॉरेस्ट लैंडस्केप्स' का प्रबंधन विश्व बैंक द्वारा किया जाता है।\nउपर्युक्त में से कौन-से कथन सही हैं?",
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
            "Statement 1 and Statement 3 ('BioCarbon Fund Initiative for Sustainable Forest Landscapes' managed by the World Bank) were directly asked in UPSC CSE Prelims 2021 & 2023!",
            "कथन 1 और कथन 3 (विश्व बैंक द्वारा प्रबंधित 'बायोकार्बन फंड इनिशिएटिव') UPSC CSE 2021 और 2023 में सीधे पूछे गए थे!",
            "UPSC CSE Pre PYQ 2021, 2023, 2024"
        )
    )

    val upscScienceTech50Test: MockTest by lazy {
        val questions = buildUpsc50Questions(
            seeds = sciTechSeeds,
            subjectLabel = "UPSC CSE Science & Technology (विज्ञान एवं प्रौद्योगिकी)",
            baseId = 16000
        )
        MockTest(
            testId = "upsc_sec_scitech_50",
            title = "UPSC CSE Free Test 6: Science & Technology — 50 PYQ Questions",
            hindiTitle = "UPSC CSE निःशुल्क टेस्ट 6: विज्ञान एवं प्रौद्योगिकी — 50 PYQ प्रश्न",
            examName = "UPSC CSE Prelims — Science & Tech (50 Qs)",
            durationMinutes = 60,
            totalMarks = 100,
            positiveMarks = 2.0,
            negativeMarks = 0.66,
            questions = questions,
            categoryId = "upsc",
            pyqAnalysisEn = "UPSC CSE Science & Technology (50 Qs | Last 5 Years 2020–2025 PYQ Analysis): Covers Pronuclear Transfer & CRISPR-Cas9, B-Cells vs T-Cells & CAR-T Cell Therapy, Wolbachia Method & Aerial Metagenomics, Web 3.0 / Blockchain / NFTs / Qubit / VLC, Cepheids / Pulsars / Nebulae, GNSS (NavIC), Ballistic vs Cruise Missiles & Hydrogen Fuel Cells.",
            pyqAnalysisHi = "UPSC CSE विज्ञान एवं प्रौद्योगिकी (50 प्रश्न | विगत 5 वर्षीय 2020–2025 PYQ विश्लेषण): प्रोन्यूक्लियर ट्रांसफर व CRISPR-Cas9, बी-कोशिका बनाम टी-कोशिका व CAR-T सेल थेरेपी, वोलबाचिया पद्धति व एरियल मेटाजीनोमिक्स, Web 3.0 / NFTs / क्यूबिट / VLC, पल्सर / नेबुला, NavIC, बैलिस्टिक बनाम क्रूज मिसाइल एवं हाइड्रोजन फ्यूल सेल।",
            topicWeightage = listOf(
                "Biotechnology, Genetics & Immunology (36%)",
                "Space, Astronomy & Defence Tech (34%)",
                "IT, Quantum, Clean Energy & Materials (30%)"
            )
        )
    }

    val upscIrCurrentAffairs50Test: MockTest by lazy {
        val questions = buildUpsc50Questions(
            seeds = irCurrentAffairsSeeds,
            subjectLabel = "UPSC CSE Current Affairs & IR (समसामयिक घटनाक्रम एवं अंतर्राष्ट्रीय संबंध)",
            baseId = 17000
        )
        MockTest(
            testId = "upsc_sec_ir_ca_50",
            title = "UPSC CSE Free Test 7: Current Affairs, IR & Organizations — 50 PYQ Questions",
            hindiTitle = "UPSC CSE निःशुल्क टेस्ट 7: समसामयिक घटनाक्रम एवं अंतर्राष्ट्रीय संगठन — 50 PYQ प्रश्न",
            examName = "UPSC CSE Prelims — Current Affairs & IR (50 Qs)",
            durationMinutes = 60,
            totalMarks = 100,
            positiveMarks = 2.0,
            negativeMarks = 0.66,
            questions = questions,
            categoryId = "upsc",
            pyqAnalysisEn = "UPSC CSE Current Affairs & International Relations (50 Qs | Last 5 Years 2020–2025 PYQ Analysis): Covers G20 & Digital Public Infrastructure, UNGA Observer Status & UN Credentials Committee, UNCLOS (12 nm Territorial Sea / 200 nm EEZ), Global Conflict Zones in News, SCO/AIIB/I2U2/QUAD, WTO Peace Clause, G20 Common Framework & IMEC/INSTC.",
            pyqAnalysisHi = "UPSC CSE समसामयिक घटनाक्रम एवं अंतर्राष्ट्रीय संगठन (50 प्रश्न | विगत 5 वर्षीय 2020–2025 PYQ विश्लेषण): G20 व डिजिटल पब्लिक इंफ्रास्ट्रक्चर, संयुक्त राष्ट्र महासभा व UNCLOS (12 समुद्री मील / 200 समुद्री मील EEZ), चर्चित वैश्विक संघर्ष क्षेत्र, SCO/AIIB/I2U2/QUAD, WTO पीस क्लॉज, मसाला बॉन्ड एवं IMEC/INSTC गलियारे।",
            topicWeightage = listOf(
                "International Organizations: UN, WTO, G20 & IMF (38%)",
                "World Conflict Zones & Geopolitical Corridors (34%)",
                "Global Funds, Summits & Sports Awards (28%)"
            )
        )
    }

    /**
     * Master Descriptor for each of the 7 UPSC CSE Prelims Free Sectional Tests (50 Questions Each = 350 Questions Total)
     */
    data class UpscSubjectSection(
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

    val all7UpscSectionTests: List<UpscSubjectSection> by lazy {
        listOf(
            UpscSubjectSection(
                id = "upsc_history",
                sectionNumber = 1,
                nameEn = "History & Art & Culture (इतिहास एवं संस्कृति)",
                nameHi = "इतिहास एवं कला-संस्कृति (History & Culture)",
                badgeText = "50 UPSC PYQ Qs • FREE",
                subtitleEn = "IVC, Buddhism/Jainism, Ashoka, Sangam, Temple Art & Modern India (Last 5 Yrs UPSC CSE PYQ)",
                subtitleHi = "हड़प्पा, बौद्ध/जैन दर्शन, अशोक, संगम, मंदिर कला एवं आधुनिक भारत (विगत 5 वर्षीय UPSC PYQ)",
                mockTest = UpscHistoryPolityPyqData.upscHistory50Test
            ),
            UpscSubjectSection(
                id = "upsc_polity",
                sectionNumber = 2,
                nameEn = "Polity & Governance (राजव्यवस्था एवं संविधान)",
                nameHi = "भारतीय राजव्यवस्था एवं संविधान (Polity)",
                badgeText = "50 UPSC PYQ Qs • FREE",
                subtitleEn = "Constitutionalism, FRs/Writs, DPSP, Parliament Bills, 5th/6th Schedule & Judiciary (5-Yr UPSC PYQ)",
                subtitleHi = "संवैधानिकता, मूल अधिकार/रिट, संसद विधेयक, 5वीं/6ठी अनुसूची एवं न्यायपालिका (5 वर्षीय UPSC PYQ)",
                mockTest = UpscHistoryPolityPyqData.upscPolity50Test
            ),
            UpscSubjectSection(
                id = "upsc_geography",
                sectionNumber = 3,
                nameEn = "Geography — India & World (भारत एवं विश्व भूगोल)",
                nameHi = "भारत एवं विश्व का भूगोल (Geography)",
                badgeText = "50 UPSC PYQ Qs • FREE",
                subtitleEn = "Climatology, Seismic Waves, Indian Rivers, Critical Minerals, Crops & World Mapping (5-Yr UPSC PYQ)",
                subtitleHi = "जलवायु विज्ञान, भूकंपीय तरंगें, भारतीय नदियाँ, क्रिटिकल मिनरल्स, कृषि एवं विश्व मानचित्रण (5 वर्षीय PYQ)",
                mockTest = UpscGeoEcoEnvPyqData.upscGeography50Test
            ),
            UpscSubjectSection(
                id = "upsc_economics",
                sectionNumber = 4,
                nameEn = "Indian Economy (भारतीय अर्थव्यवस्था)",
                nameHi = "भारतीय अर्थव्यवस्था (Indian Economy)",
                badgeText = "50 UPSC PYQ Qs • FREE",
                subtitleEn = "RBI Monetary Policy, Money Multiplier, G-Secs/T-Bills/IIBs/InvITs, NEER/REER, CBDC & BoP (5-Yr PYQ)",
                subtitleHi = "RBI मौद्रिक नीति, मुद्रा गुणक, G-Secs/T-Bills/IIBs/InvITs, NEER/REER, डिजिटल रुपया व BoP (5 वर्षीय PYQ)",
                mockTest = UpscGeoEcoEnvPyqData.upscEconomics50Test
            ),
            UpscSubjectSection(
                id = "upsc_environment",
                sectionNumber = 5,
                nameEn = "Environment & Biodiversity (पर्यावरण एवं जैव-विविधता)",
                nameHi = "पर्यावरण एवं जैव-विविधता (Environment)",
                badgeText = "50 UPSC PYQ Qs • FREE",
                subtitleEn = "Species Behavior, WPA 2022, Ramsar Wetlands, Biogeochemical Cycles, Bio-fertilizers & COP (5-Yr PYQ)",
                subtitleHi = "वन्यजीव व्यवहार, वन्यजीव अधिनियम, रामसर आर्द्रभूमियाँ, जैव-भू-रासायनिक चक्र एवं COP (5 वर्षीय PYQ)",
                mockTest = UpscGeoEcoEnvPyqData.upscEnvironment50Test
            ),
            UpscSubjectSection(
                id = "upsc_scitech",
                sectionNumber = 6,
                nameEn = "Science & Technology (विज्ञान एवं प्रौद्योगिकी)",
                nameHi = "विज्ञान एवं प्रौद्योगिकी (Science & Tech)",
                badgeText = "50 UPSC PYQ Qs • FREE",
                subtitleEn = "CRISPR/MRT, CAR-T Cells, Wolbachia, Web 3.0/NFTs/Qubit, Pulsars, NavIC & Missiles (5-Yr UPSC PYQ)",
                subtitleHi = "CRISPR/प्रोन्यूक्लियर ट्रांसफर, CAR-T सेल, वोलबाचिया, Web 3.0/क्यूबिट, पल्सर, NavIC व मिसाइलें (5 वर्षीय PYQ)",
                mockTest = upscScienceTech50Test
            ),
            UpscSubjectSection(
                id = "upsc_ir_ca",
                sectionNumber = 7,
                nameEn = "Current Affairs & IR (समसामयिक घटनाक्रम एवं IR)",
                nameHi = "समसामयिक घटनाक्रम एवं अंतर्राष्ट्रीय संगठन (Current Affairs & IR)",
                badgeText = "50 UPSC PYQ Qs • FREE",
                subtitleEn = "G20, UNGA/UNCLOS, WTO Peace Clause, Global Conflict Zones, I2U2/QUAD/SCO & IMEC (5-Yr UPSC PYQ)",
                subtitleHi = "G20, UNGA/UNCLOS, WTO पीस क्लॉज, वैश्विक संघर्ष क्षेत्र, I2U2/QUAD/SCO एवं IMEC गलियारा (5 वर्षीय PYQ)",
                mockTest = upscIrCurrentAffairs50Test
            )
        )
    }
}
