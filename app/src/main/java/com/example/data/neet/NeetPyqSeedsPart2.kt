package com.example.data.neet

/**
 * Authentic Last 5 Years (2020–2025) NTA NEET (UG) NCERT-Based Bilingual PYQ Seeds (Part 2):
 *  4. Inorganic Chemistry (अकार्बनिक रसायन — Class 11 & 12 NCERT)
 *  5. Biology: Botany (वनस्पति विज्ञान — Class 11 & 12 NCERT Line-by-Line)
 *  6. Biology: Zoology (जन्तु विज्ञान — Class 11 & 12 NCERT Line-by-Line)
 */
object NeetPyqSeedsPart2 {

    // ==================== 4. NEET INORGANIC CHEMISTRY SEEDS ====================
    val neetInorganicChemSeeds: List<RawNeetPyqSeed> = listOf(
        RawNeetPyqSeed(
            qEn = "Among the second-period elements Li, Be, B, C, N, O, and F, the correct order of first ionization enthalpy (Δ_i H₁) for B, C, N, and O is:",
            qHi = "द्वितीय आवर्त के तत्वों B, C, N तथा O के लिए प्रथम आयनन एन्थैल्पी (Δ_i H₁) का सही क्रम क्या है?",
            optsEn = listOf("B < C < O < N", "B < C < N < O", "C < B < N < O", "B < O < C < N"),
            optsHi = listOf("B < C < O < N", "B < C < N < O", "C < B < N < O", "B < O < C < N"),
            expEn = "Nitrogen (2s² 2p³) has a stable half-filled 2p subshell, so its first ionization enthalpy is higher than that of Oxygen (2s² 2p⁴). Thus the order is B < C < O < N.",
            expHi = "नाइट्रोजन (2s² 2p³) में अर्ध-पूरित स्थायी 2p उपकोश होने के कारण इसकी प्रथम आयनन एन्थैल्पी ऑक्सीजन से अधिक होती है; अतः सही क्रम B < C < O < N है।",
            yearTag = "NEET UG 2024 PYQ",
            subTopic = "Classification of Elements & Periodicity"
        ),
        RawNeetPyqSeed(
            qEn = "According to VSEPR theory, what are the molecular geometry and hybridization of Xenon difluoride (XeF₂) and Sulphur tetrafluoride (SF₄)?",
            qHi = "VSEPR सिद्धांत के अनुसार, ज़ेनॉन डाइफ्लोराइड (XeF₂) और सल्फर टेट्राफ्लोराइड (SF₄) की आणविक ज्यामिति और संकरण क्या हैं?",
            optsEn = listOf("XeF₂: Linear (sp³d, 3 lone pairs) | SF₄: See-saw (sp³d, 1 lone pair)", "XeF₂: Bent (sp³) | SF₄: Tetrahedral (sp³)", "XeF₂: Linear (sp) | SF₄: Square planar (dsp²)", "XeF₂: T-shaped (sp³d) | SF₄: Trigonal pyramidal"),
            optsHi = listOf("XeF₂: रेखीय / Linear (sp³d, 3 एकाकी युग्म) | SF₄: ढेंकुली / See-saw (sp³d, 1 एकाकी युग्म)", "XeF₂: बेंट (sp³) | SF₄: चतुष्फलकीय (sp³)", "XeF₂: रेखीय (sp) | SF₄: वर्ग समतलीय (dsp²)", "XeF₂: T-आकृति | SF₄: त्रिकोणीय पिरामिडी"),
            expEn = "XeF₂ has 2 bond pairs + 3 equatorial lone pairs (sp³d) giving a Linear shape. SF₄ has 4 bond pairs + 1 equatorial lone pair (sp³d) giving a See-saw geometry.",
            expHi = "XeF₂ में 2 आबंध युग्म + 3 एकाकी युग्म (sp³d) के कारण रेखीय आकृति होती है, जबकि SF₄ में 4 आबंध युग्म + 1 एकाकी युग्म (sp³d) के कारण सी-सॉ (See-saw) ज्यामिति होती है।",
            yearTag = "NEET UG 2023 PYQ",
            subTopic = "Chemical Bonding & VSEPR Theory"
        ),
        RawNeetPyqSeed(
            qEn = "According to Molecular Orbital Theory (MOT), which of the following diatomic species is diamagnetic and has a bond order of 3.0?",
            qHi = "आणविक कक्षक सिद्धांत (MOT) के अनुसार, निम्नलिखित में से कौन-सी द्विपरमाणुक स्पीशीज प्रतिचुंबकीय (Diamagnetic) है और जिसकी आबंध कोटि (Bond Order) 3.0 है?",
            optsEn = listOf("NO⁺, CN⁻, CO, and N₂ (14 electrons)", "O₂ (16 electrons)", "O₂⁻ (17 electrons)", "B₂ (10 electrons)"),
            optsHi = listOf("NO⁺, CN⁻, CO तथा N₂ (14 इलेक्ट्रॉन)", "O₂ (16 इलेक्ट्रॉन)", "O₂⁻ (17 इलेक्ट्रॉन)", "B₂ (10 इलेक्ट्रॉन)"),
            expEn = "Isoelectronic 14-electron species (N₂, CO, CN⁻, NO⁺) have 10 bonding and 4 antibonding electrons: Bond Order = (10 - 4)/2 = 3.0 with all electrons paired (diamagnetic).",
            expHi = "14 इलेक्ट्रॉन वाली समइलेक्ट्रॉनी स्पीशीज (N₂, CO, CN⁻, NO⁺) में आबंध कोटि = (10 - 4)/2 = 3.0 होती है तथा सभी इलेक्ट्रॉन युग्मित (प्रतिचुंबकीय) होते हैं।",
            yearTag = "NEET UG 2024 PYQ",
            subTopic = "Molecular Orbital Theory (MOT)"
        ),
        RawNeetPyqSeed(
            qEn = "Which of the following coordination complexes has zero crystal field stabilization energy (CFSE = 0) and a spin-only magnetic moment of 5.92 BM?",
            qHi = "निम्नलिखित में से किस उपसहसंयोजन संकुल में क्रिस्टल क्षेत्र स्थायीकरण ऊर्जा शून्य (CFSE = 0) तथा प्रचक्रण-मात्र चुंबकीय आघूर्ण 5.92 BM होता है?",
            optsEn = listOf("[Fe(H₂O)₆]³⁺ (High-spin d⁵: t₂g³ e_g²)", "[Fe(CN)₆]³⁻ (Low-spin d⁵: t₂g⁵ e_g⁰)", "[Co(NH₃)₆]³⁺ (Low-spin d⁶: t₂g⁶ e_g⁰)", "[Ni(H₂O)₆]²⁺ (d⁸: t₂g⁶ e_g²)"),
            optsHi = listOf("[Fe(H₂O)₆]³⁺ (उच्च-प्रचक्रण d⁵: t₂g³ e_g²)", "[Fe(CN)₆]³⁻ (निम्न-प्रचक्रण d⁵: t₂g⁵ e_g⁰)", "[Co(NH₃)₆]³⁺ (निम्न-प्रचक्रण d⁶: t₂g⁶ e_g⁰)", "[Ni(H₂O)₆]²⁺ (d⁸: t₂g⁶ e_g²)"),
            expEn = "In [Fe(H₂O)₆]³⁺, Fe³⁺ is d⁵ with a weak-field ligand H₂O (t₂g³ e_g²). CFSE = 3(-0.4 Δ_o) + 2(+0.6 Δ_o) = 0, and n = 5 unpaired electrons give μ = √(5 × 7) = √35 = 5.92 BM.",
            expHi = "[Fe(H₂O)₆]³⁺ में दुर्बल क्षेत्र लिगैंड H₂O के साथ Fe³⁺ (d⁵) का विन्यास t₂g³ e_g² होता है। अतः CFSE = 0 तथा n = 5 अयुग्मित इलेक्ट्रॉनों से μ = √35 = 5.92 BM होता है।",
            yearTag = "NEET UG 2024 PYQ",
            subTopic = "Coordination Compounds (CFT & Magnetism)"
        ),
        RawNeetPyqSeed(
            qEn = "What type of structural isomerism is exhibited by the pair of coordination compounds [Co(NH₃)₅(NO₂)]Cl₂ and [Co(NH₃)₅(ONO)]Cl₂?",
            qHi = "उपसहसंयोजन यौगिकों के युग्म [Co(NH₃)₅(NO₂)]Cl₂ और [Co(NH₃)₅(ONO)]Cl₂ द्वारा किस प्रकार की संरचनात्मक समावयवता प्रदर्शित की जाती है?",
            optsEn = listOf("Linkage isomerism (due to ambidentate ligand NO₂⁻ / ONO⁻)", "Ionisation isomerism", "Coordination isomerism", "Hydrate (Solvate) isomerism"),
            optsHi = listOf("बंधनी समावयवता / Linkage Isomerism (उभयदंती लिगैंड NO₂⁻ के कारण)", "आयनन समावयवता", "उपसहसंयोजन समावयवता", "जलयोजन समावयवता"),
            expEn = "NO₂⁻ is an ambidentate ligand that can coordinate through nitrogen (-NO₂, nitro) or oxygen (-ONO, nitrito-O), giving rise to Linkage Isomerism.",
            expHi = "NO₂⁻ एक उभयदंती (Ambidentate) लिगैंड है जो N अथवा O परमाणु के माध्यम से जुड़ सकता है, जिससे बंधनी समावयवता (Linkage Isomerism) उत्पन्न होती है।",
            yearTag = "NEET UG 2023 PYQ",
            subTopic = "Coordination Compounds (Isomerism)"
        ),
        RawNeetPyqSeed(
            qEn = "Zr (Z = 40) and Hf (Z = 72) have almost identical atomic and ionic radii primarily because of:",
            qHi = "ज़िरकोनियम Zr (Z = 40) और हैफनियम Hf (Z = 72) की परमाणु तथा आयनिक त्रिज्याएं लगभग समान होने का मुख्य कारण क्या है?",
            optsEn = listOf("Lanthanoid contraction (poor shielding by 4f electrons)", "Actinoid contraction", "Diagonal relationship", "Inert pair effect"),
            optsHi = listOf("लैंथेनॉइड आकुंचन (4f इलेक्ट्रॉनों का दुर्बल परिरक्षण प्रभाव)", "एक्टिनॉइड आकुंचन", "विकर्ण संबंध", "अक्रिय युग्म प्रभाव"),
            expEn = "Due to the filling of 4f orbitals before 5d elements, the poor shielding of 4f electrons causes Lanthanoid Contraction, making 4d (Zr) and 5d (Hf) atomic radii nearly equal (160 pm vs 159 pm).",
            expHi = "4f इलेक्ट्रॉनों के दुर्बल परिरक्षण प्रभाव से होने वाले लैंथेनॉइड आकुंचन के कारण 4d (Zr) और 5d (Hf) तत्वों की त्रिज्याएं लगभग समान होती हैं।",
            yearTag = "NEET UG 2023 PYQ",
            subTopic = "d- and f-Block Elements (Lanthanoid Contraction)"
        ),
        RawNeetPyqSeed(
            qEn = "Which of the following oxoacids of phosphorus is a monoprotic (monobasic) acid and acts as a strong reducing agent due to two P–H bonds?",
            qHi = "फॉस्फोरस का निम्नलिखित में से कौन-सा ऑक्सोअम्ल एकक्षारकीय (Monobasic) अम्ल है और दो P–H आबंधों के कारण प्रबल अपचायक के रूप में कार्य करता है?",
            optsEn = listOf("Hypophosphorous acid / Phosphinic acid (H₃PO₂)", "Orthophosphorous acid / Phosphonic acid (H₃PO₃)", "Orthophosphoric acid (H₃PO₄)", "Pyrophosphoric acid (H₄P₂O₇)"),
            optsHi = listOf("हाइपोफॉस्फोरस अम्ल / फॉस्फिनिक अम्ल (H₃PO₂)", "ऑर्थोफॉस्फोरस अम्ल (H₃PO₃)", "ऑर्थोफॉस्फोरिक अम्ल (H₃PO₄)", "पायरोफॉस्फोरिक अम्ल (H₄P₂O₇)"),
            expEn = "H₃PO₂ has one P=O bond, one P–OH bond (hence monobasic, basicity = 1), and two P–H bonds (which impart strong reducing character).",
            expHi = "H₃PO₂ (फॉस्फिनिक अम्ल) में एक P–OH समूह (क्षारकता = 1) तथा दो P–H आबंध होते हैं, जो इसे प्रबल अपचायक बनाते हैं।",
            yearTag = "NEET UG 2022 PYQ",
            subTopic = "p-Block Elements (Oxoacids of Phosphorus)"
        ),
        RawNeetPyqSeed(
            qEn = "In Group 13 elements (B, Al, Ga, In, Tl), the +1 oxidation state becomes progressively more stable than the +3 oxidation state down the group (especially in Tl⁺) due to:",
            qHi = "समूह 13 के तत्वों (B, Al, Ga, In, Tl) में वर्ग में नीचे जाने पर +3 की तुलना में +1 ऑक्सीकरण अवस्था के अधिक स्थायी होने (विशेषकर Tl⁺ में) का कारण है:",
            optsEn = listOf("Inert pair effect (reluctance of ns² electrons to participate in bonding)", "Lanthanoid contraction", "High electronegativity of Thallium", "Back bonding"),
            optsHi = listOf("अक्रिय युग्म प्रभाव / Inert Pair Effect (ns² इलेक्ट्रॉनों की आबंधन में अनिच्छा)", "लैंथेनॉइड आकुंचन", "थैलियम की उच्च विद्युतऋणात्मकता", "पश्च आबंधन (Back bonding)"),
            expEn = "In heavier p-block elements like Thallium (Tl), the 6s² electrons experience strong nuclear attraction due to poor shielding by 4f and 5d electrons (Inert Pair Effect), making Tl⁺ more stable than Tl³⁺.",
            expHi = "भारी p-ब्लॉक तत्वों (जैसे Tl) में अक्रिय युग्म प्रभाव (Inert Pair Effect) के कारण 6s² इलेक्ट्रॉन युग्म आबंधन में भाग नहीं लेता, जिससे +1 ऑक्सीकरण अवस्था अधिक स्थायी होती है।",
            yearTag = "NEET UG 2024 PYQ",
            subTopic = "p-Block Elements (Inert Pair Effect)"
        )
    )

    // ==================== 5. NEET BIOLOGY: BOTANY SEEDS ====================
    val neetBotanySeeds: List<RawNeetPyqSeed> = listOf(
        RawNeetPyqSeed(
            qEn = "Which of the following algae produces 'Carrageen' (a hydrocolloid used commercially), and which algae are rich sources of agar?",
            qHi = "निम्नलिखित में से कौन-सा शैवाल व्यावसायिक रूप से उपयोगी हाइड्रोकोलॉइड 'कैरागीन' (Carrageen) उत्पन्न करता है, और कौन-से शैवाल 'अगार' (Agar) के प्रमुख स्रोत हैं?",
            optsEn = listOf("Carrageen: Red algae (Rhodophyceae) | Agar: Gelidium and Gracilaria", "Carrageen: Brown algae (Phaeophyceae) | Agar: Chlorella and Spirulina", "Carrageen: Green algae (Chlorophyceae) | Agar: Volvox and Ulothrix", "Carrageen: Blue-green algae | Agar: Laminaria and Sargassum"),
            optsHi = listOf("कैरागीन: लाल शैवाल (रोडोफाइसी) | अगार: जिलेडियम एवं ग्रेसिलेरिया", "कैरागीन: भूरे शैवाल (फियोफाइसी) | अगार: क्लोरेला एवं स्पाइरुलिना", "कैरागीन: हरे शैवाल | अगार: वॉलवॉक्स एवं यूलोथ्रिक्स", "कैरागीन: नील-हरित शैवाल | अगार: लैमिनेरिया एवं सारगासम"),
            expEn = "According to NCERT Class 11 Plant Kingdom: Algin is produced by brown algae, Carrageen is produced by red algae, and Agar is obtained from Gelidium and Gracilaria (red algae).",
            expHi = "NCERT पादप जगत के अनुसार: एल्जिन भूरे शैवाल से, कैरागीन लाल शैवाल (Rhodophyceae) से तथा अगार जिलेडियम और ग्रेसिलेरिया से प्राप्त होता है।",
            yearTag = "NEET UG 2022 PYQ",
            subTopic = "Plant Kingdom (Algae & Hydrocolloids)"
        ),
        RawNeetPyqSeed(
            qEn = "When the margins of sepals or petals overlap one another without any particular direction (as seen in Cassia and Gulmohur), the aestivation is called:",
            qHi = "जब बाह्यदल या दल के किनारे बिना किसी विशेष दिशा के एक-दूसरे को अतिव्यापित (Overlap) करते हैं (जैसे कैसिया और गुलमोहर में), तो इस पुष्पदल विन्यास (Aestivation) को क्या कहते हैं?",
            optsEn = listOf("Imbricate aestivation", "Valvate aestivation", "Twisted aestivation", "Vexillary (Papilionaceous) aestivation"),
            optsHi = listOf("कोरछादी (Imbricate) पुष्पदल विन्यास", "कोरस्पर्शी (Valvate) विन्यास", "व्यावर्तित (Twisted) विन्यास", "ध्वजक (Vexillary) विन्यास"),
            expEn = "NCERT Morphology of Flowering Plants: Valvate (Calotropis), Twisted (China rose, Lady's finger, Cotton), Imbricate (Cassia, Gulmohur), Vexillary (Pea, Bean).",
            expHi = "NCERT के अनुसार कैसिया और गुलमोहर में कोरछादी (Imbricate) पुष्पदल विन्यास पाया जाता है, जबकि मटर में ध्वजक (Vexillary) विन्यास होता है।",
            yearTag = "NEET UG 2024 PYQ",
            subTopic = "Morphology of Flowering Plants"
        ),
        RawNeetPyqSeed(
            qEn = "In which stage of Meiosis-I does 'Crossing Over' (recombination between homologous non-sister chromatids) take place, mediated by the enzyme recombinase?",
            qHi = "अर्धसूत्री विभाजन-I (Meiosis-I) की किस अवस्था में रिकॉम्बिनेज एंजाइम की सहायता से समजात गुणसूत्रों के नॉन-सिस्टर क्रोमैटिड्स के बीच 'जीन विनिमय' (Crossing Over) होता है?",
            optsEn = listOf("Pachytene (sub-stage of Prophase-I)", "Zygotene (Synapsis occurs here)", "Diplotene (Dissolution of synaptonemal complex & Chiasmata)", "Diakinesis (Terminalisation of chiasmata)"),
            optsHi = listOf("पैकीटीन / स्थूलपट् (Pachytene — पूर्वावस्था-I)", "ज़ाइगोटीन / युग्मपट् (यहाँ सूत्रयुग्मन होता है)", "डिप्लोटीन / द्विपट्ट (काएज्माटा दिखाई देते हैं)", "डायाकिनेसिस / पारगतिक्रम (काएज्माटा का उपांतीभवन)"),
            expEn = "During Prophase-I of Meiosis: Leptotene (compaction), Zygotene (synapsis/bivalent), Pachytene (recombination nodules & crossing over via recombinase), Diplotene (chiasmata), Diakinesis (terminalisation).",
            expHi = "अर्धसूत्री विभाजन-I की पूर्वावस्था-I के पैकीटीन (Pachytene) चरण में रिकॉम्बिनेज एंजाइम द्वारा जीन विनिमय (Crossing Over) संपन्न होता है।",
            yearTag = "NEET UG 2023 PYQ",
            subTopic = "Cell Cycle & Cell Division (Meiosis-I)"
        ),
        RawNeetPyqSeed(
            qEn = "In C₄ plants (such as Maize, Sorghum, and Sugarcane), the primary CO₂ acceptor in mesophyll cells is ____ and the first stable product is ____:",
            qHi = "C₄ पादपों (जैसे मक्का, ज्वार और गन्ना) में पर्णमध्योतक (Mesophyll) कोशिकाओं में प्राथमिक CO₂ ग्राही ____ है और प्रथम स्थायी उत्पाद ____ है:",
            optsEn = listOf("Phosphoenolpyruvate (PEP — 3C) and Oxaloacetic acid (OAA — 4C)", "RuBP (5C) and 3-PGA (3C)", "PEP (3C) and Malic acid (4C)", "RuBP (5C) and OAA (4C)"),
            optsHi = listOf("फॉस्फोइनॉलपाइरुवेट (PEP — 3C) तथा ऑक्सैलोऐसीटिक अम्ल (OAA — 4C)", "RuBP (5C) तथा 3-PGA (3C)", "PEP (3C) तथा मैलिक अम्ल (4C)", "RuBP (5C) तथा OAA (4C)"),
            expEn = "In C₄ Hatch-Slack pathway, PEP (3-carbon molecule) in mesophyll cells accepts HCO₃⁻ catalyzed by PEPcase (lack of RuBisCO in mesophyll) to form 4-carbon Oxaloacetic acid (OAA).",
            expHi = "C₄ पादपों की पर्णमध्योतक कोशिकाओं में प्राथमिक CO₂ ग्राही 3-कार्बन युक्त PEP होता है, जो PEPcase की उपस्थिति में 4-कार्बन युक्त प्रथम स्थायी उत्पाद OAA बनाता है।",
            yearTag = "NEET UG 2024 PYQ",
            subTopic = "Photosynthesis in Higher Plants (C4 Pathway)"
        ),
        RawNeetPyqSeed(
            qEn = "Which plant hormone (phytohormone) is used to speed up the malting process in the brewing industry and increases the length of sugarcane stems?",
            qHi = "किस पादप हार्मोन का उपयोग शराब उद्योग (Brewing industry) में माल्टिंग प्रक्रिया की गति बढ़ाने तथा गन्ने के तने की लंबाई (और उपज) बढ़ाने के लिए किया जाता है?",
            optsEn = listOf("Gibberellins (GA₃)", "Auxins (IAA / NAA)", "Cytokinins (Zeatin)", "Abscisic acid (ABA)"),
            optsHi = listOf("जिबरेलिन (Gibberellins — GA₃)", "ऑक्सिन (IAA / NAA)", "साइटोकाइनिन (Zeatin)", "एब्सिसिक अम्ल (ABA)"),
            expEn = "NCERT Plant Growth and Development: Spraying sugarcane crop with Gibberellins increases stem length and yield by up to 20 tonnes per acre; GA₃ also speeds up malting in brewing.",
            expHi = "NCERT के अनुसार जिबरेलिन (GA₃) माल्टिंग की प्रक्रिया को तीव्र करता है तथा गन्ने पर छिड़काव करने से तने की लंबाई बढ़कर उपज लगभग 20 टन/एकड़ तक बढ़ जाती है।",
            yearTag = "NEET UG 2023 PYQ",
            subTopic = "Plant Growth & Regulators"
        ),
        RawNeetPyqSeed(
            qEn = "A typical angiosperm mature embryo sac (Polygonum type) at maturity is:",
            qHi = "एक प्रारूपिक आवृतबीजी (Angiosperm) का परिपक्व भ्रूणकोष (Embryo Sac) परिपक्वता पर कैसा होता है?",
            optsEn = listOf("8-nucleate and 7-celled", "7-nucleate and 8-celled", "8-nucleate and 8-celled", "4-nucleate and 4-celled"),
            optsHi = listOf("8-केंद्रकीय और 7-कोशिकीय (8-nucleate and 7-celled)", "7-केंद्रकीय और 8-कोशिकीय", "8-केंद्रकीय और 8-कोशिकीय", "4-केंद्रकीय और 4-कोशिकीय"),
            expEn = "Mature embryo sac has 3 antipodal cells + 2 synergids + 1 egg cell + 1 large central cell containing 2 polar nuclei = 7 cells and 8 nuclei.",
            expHi = "परिपक्व आवृतबीजी भ्रूणकोष में 3 प्रतिव्यासांत कोशिकाएं, 2 सहाय कोशिकाएं, 1 अंड कोशिका तथा 2 ध्रुवीय केंद्रकों वाली 1 केंद्रीय कोशिका होती है — कुल 7 कोशिकाएं और 8 केंद्रक।",
            yearTag = "NEET UG 2022 PYQ",
            subTopic = "Sexual Reproduction in Flowering Plants"
        ),
        RawNeetPyqSeed(
            qEn = "In the Lac Operon of Escherichia coli, what do the structural genes 'z', 'y', and 'a' code for respectively?",
            qHi = "ई. कोलाई (E. coli) के लैक ओपेरॉन (Lac Operon) में संरचनात्मक जीन 'z', 'y' और 'a' क्रमशः किसका कूटलेखन (Code) करते हैं?",
            optsEn = listOf("lac z: β-galactosidase | lac y: Permease | lac a: Transacetylase", "lac z: Permease | lac y: β-galactosidase | lac a: Ligase", "lac z: Transacetylase | lac y: Permease | lac a: Polymerase", "lac z: Repressor | lac y: β-galactosidase | lac a: Permease"),
            optsHi = listOf("lac z: β-गैलेक्टोसिडेज | lac y: पर्मिएज (Permease) | lac a: ट्रांसएसिटिलेज", "lac z: पर्मिएज | lac y: β-गैलेक्टोसिडेज | lac a: लाइगेज", "lac z: ट्रांसएसिटिलेज | lac y: पर्मिएज | lac a: पॉलीमरेज", "lac z: दमनकारी | lac y: β-गैलेक्टोसिडेज | lac a: पर्मिएज"),
            expEn = "François Jacob and Jacque Monod showed in Lac Operon: z codes for β-galactosidase (hydrolyzes lactose to glucose + galactose), y codes for permease, and a codes for transacetylase.",
            expHi = "जैकब और मोनोड के लैक ओपेरॉन मॉडल के अनुसार: जीन z β-गैलेक्टोसिडेज का, जीन y पर्मिएज का तथा जीन a ट्रांसएसिटिलेज का कूटलेखन करता है।",
            yearTag = "NEET UG 2024 PYQ",
            subTopic = "Molecular Basis of Inheritance (Lac Operon)"
        ),
        RawNeetPyqSeed(
            qEn = "Which bioactive molecule produced by the fungus Trichoderma polysporum is used as an immunosuppressive agent in organ-transplant patients, and which agent produced by Monascus purpureus lowers blood cholesterol?",
            qHi = "कवक ट्राइकोडर्मा पॉलीस्पोरम से प्राप्त कौन-सा जैव-सक्रिय अणु अंग-प्रत्यारोपण रोगियों में प्रतिरक्षा-निराकरण कारक (Immunosuppressive agent) के रूप में प्रयुक्त होता है, और मोनास्कस परप्यूरियस से प्राप्त कौन-सा कारक रक्त कोलेस्ट्रॉल कम करता है?",
            optsEn = listOf("Cyclosporin A (Trichoderma polysporum) and Statins (Monascus purpureus)", "Streptokinase (Streptococcus) and Citric acid (Aspergillus niger)", "Statins (Trichoderma) and Cyclosporin A (Monascus)", "Penicillin and Streptokinase"),
            optsHi = listOf("साइक्लोस्पोरिन A (ट्राइकोडर्मा पॉलीस्पोरम) तथा स्टैटिन (मोनास्कस परप्यूरियस)", "स्ट्रेप्टोकाइनेज तथा सिट्रिक अम्ल", "स्टैटिन (ट्राइकोडर्मा) तथा साइक्लोस्पोरिन A (मोनास्कस)", "पेनिसिलिन तथा स्ट्रेप्टोकाइनेज"),
            expEn = "Cyclosporin A (produced by fungus Trichoderma polysporum) is an immunosuppressant for organ transplant patients; Statins (produced by yeast Monascus purpureus) competitively inhibit cholesterol synthesis.",
            expHi = "साइक्लोस्पोरिन A (ट्राइकोडर्मा पॉलीस्पोरम) अंग-प्रत्यारोपण में प्रतिरक्षा-संदमक है, जबकि स्टैटिन (मोनास्कस परप्यूरियस यीस्ट) रक्त कोलेस्ट्रॉल घटाने वाला कारक है।",
            yearTag = "NEET UG 2023 PYQ",
            subTopic = "Microbes in Human Welfare"
        ),
        RawNeetPyqSeed(
            qEn = "In an ecosystem, what percentage of photosynthetically active radiation (PAR) is captured by plants, and what percentage of energy is transferred from one trophic level to the next according to Lindeman's law?",
            qHi = "एक पारितंत्र में पादपों द्वारा प्रकाश-संश्लेषणात्मक सक्रिय विकिरण (PAR) का कितना प्रतिशत प्रग्रहण किया जाता है, और लिंडमान के नियम के अनुसार एक पोषी स्तर से अगले पोषी स्तर में कितनी ऊर्जा स्थानांतरित होती है?",
            optsEn = listOf("2–10% of PAR captured by plants | 10% energy transferred to next trophic level", "50% of PAR captured | 20% energy transferred", "1–2% of total incident solar radiation | 50% energy transferred", "10–20% of PAR captured | 1% energy transferred"),
            optsHi = listOf("पादपों द्वारा 2–10% PAR का प्रग्रहण | अगले पोषी स्तर में 10% ऊर्जा स्थानांतरण", "50% PAR प्रग्रहण | 20% ऊर्जा स्थानांतरण", "1–2% PAR प्रग्रहण | 50% ऊर्जा स्थानांतरण", "10–20% PAR प्रग्रहण | 1% ऊर्जा स्थानांतरण"),
            expEn = "Plants capture only 2–10% of PAR for gross primary productivity, and Lindeman's 10% Law states that only 10% of energy is transferred to each higher trophic level.",
            expHi = "NCERT पारितंत्र के अनुसार पादप केवल 2–10% PAR का प्रग्रहण करते हैं तथा लिंडमान के 10% नियम के अनुसार एक पोषी स्तर से अगले स्तर में केवल 10% ऊर्जा ही स्थानांतरित होती है।",
            yearTag = "NEET UG 2023 PYQ",
            subTopic = "Ecosystem & Energy Flow"
        )
    )

    // ==================== 6. NEET BIOLOGY: ZOOLOGY SEEDS ====================
    val neetZoologySeeds: List<RawNeetPyqSeed> = listOf(
        RawNeetPyqSeed(
            qEn = "Which of the following is the unique diagnostic feature of Phylum Chordata possessed by all chordates at some stage of their life cycle?",
            qHi = "निम्नलिखित में से कौन-सा संघ रज्जुकी (Phylum Chordata) का विशिष्ट निदानात्मक लक्षण है जो सभी कॉर्डेट्स के जीवन चक्र की किसी न किसी अवस्था में अनिवार्य रूप से पाया जाता है?",
            optsEn = listOf("Presence of Notochord, dorsal hollow nerve cord, and paired pharyngeal gill slits", "Presence of vertebral column in all chordates without exception", "Ventral solid double nerve cord and open circulatory system", "Water vascular system and radial symmetry"),
            optsHi = listOf("पृष्ठरज्जु (Notochord), पृष्ठीय खोखली तंत्रिका रज्जु और युग्मित ग्रसनी क्लोम छिद्रों की उपस्थिति", "बिना किसी अपवाद के सभी कॉर्डेट्स में कशेरुक दंड की उपस्थिति", "अधर ठोस दोहरी तंत्रिका रज्जु और खुला परिसंचरण तंत्र", "जल संवहन तंत्र और अरीय सममिति"),
            expEn = "All chordates possess three fundamental characters: (1) Notochord, (2) Dorsal hollow CNS/nerve cord, and (3) Paired pharyngeal gill slits, plus a post-anal tail.",
            expHi = "NCERT जन्तु जगत के अनुसार सभी रज्जुकियों (Chordates) में तीन मूलभूत लक्षण होते हैं: पृष्ठरज्जु (Notochord), पृष्ठीय खोखली तंत्रिका रज्जु तथा युग्मित ग्रसनी क्लोम छिद्र।",
            yearTag = "NEET UG 2024 PYQ",
            subTopic = "Animal Kingdom (Phylum Chordata)"
        ),
        RawNeetPyqSeed(
            qEn = "In competitive inhibition of an enzyme-catalyzed reaction (such as inhibition of succinic dehydrogenase by malonate), how are V_max and K_m affected?",
            qHi = "किसी एंजाइम-उत्प्रेरित अभिक्रिया के प्रतिस्पर्धी संदमन (Competitive Inhibition — जैसे मैलोनेट द्वारा सक्सिनिक डिहाइड्रोजिनेज का संदमन) में V_max और K_m पर क्या प्रभाव पड़ता है?",
            optsEn = listOf("K_m increases (apparent affinity decreases) while V_max remains unchanged", "Both K_m and V_max decrease", "K_m remains unchanged while V_max decreases", "K_m decreases while V_max increases"),
            optsHi = listOf("K_m बढ़ जाता है (आभासी बंधुता घटती है) जबकि V_max अपरिवर्तित रहता है", "K_m और V_max दोनों घट जाते हैं", "K_m अपरिवर्तित रहता है जबकि V_max घट जाता है", "K_m घट जाता है जबकि V_max बढ़ जाता है"),
            expEn = "A competitive inhibitor competes with the substrate for the active site. Increasing substrate concentration can overcome inhibition so V_max stays constant, while apparent K_m increases.",
            expHi = "प्रतिस्पर्धी संदमन में संदमक सक्रिय स्थल के लिए क्रियाधार से प्रतिस्पर्धा करता है, जिससे आभासी K_m बढ़ जाता है परंतु उच्च क्रियाधार सांद्रता पर V_max अपरिवर्तित रहता है।",
            yearTag = "NEET UG 2023 PYQ",
            subTopic = "Biomolecules & Enzyme Kinetics"
        ),
        RawNeetPyqSeed(
            qEn = "Which of the following conditions favours the dissociation of oxyhaemoglobin (shifting the Oxygen Dissociation Curve to the right) in metabolically active tissues?",
            qHi = "उपापचयी रूप से सक्रिय ऊतकों में ऑक्सीहीमोग्लोबिन के वियोजन (ऑक्सीजन वियोजन वक्र के दाईं ओर विस्थापन) के लिए निम्नलिखित में से कौन-सी स्थिति अनुकूल होती है?",
            optsEn = listOf("Low pO₂, high pCO₂, high H⁺ concentration (low pH), and high temperature", "High pO₂, low pCO₂, low H⁺ concentration (high pH), and low temperature", "High pO₂ and high pH", "Low pCO₂ and low temperature"),
            optsHi = listOf("निम्न pO₂, उच्च pCO₂, उच्च H⁺ सांद्रता (निम्न pH) तथा उच्च तापमान", "उच्च pO₂, निम्न pCO₂, निम्न H⁺ सांद्रता तथा निम्न तापमान", "उच्च pO₂ तथा उच्च pH", "निम्न pCO₂ तथा निम्न तापमान"),
            expEn = "In active tissues (Bohr effect), low pO₂, high pCO₂, high H⁺ (acidic pH), 2,3-BPG, and higher temperature shift the oxygen-haemoglobin dissociation curve to the right, releasing O₂ to tissues.",
            expHi = "सक्रिय ऊतकों में निम्न pO₂, उच्च pCO₂, उच्च H⁺ सांद्रता और उच्च तापमान ऑक्सीहीमोग्लोबिन के वियोजन को बढ़ावा देते हैं, जबकि कूपिकाओं (Alveoli) में विपरीत स्थितियां इसके निर्माण में सहायक हैं।",
            yearTag = "NEET UG 2024 PYQ",
            subTopic = "Breathing & Exchange of Gases"
        ),
        RawNeetPyqSeed(
            qEn = "In a standard Electrocardiogram (ECG), what do the P-wave, QRS complex, and T-wave represent respectively?",
            qHi = "एक मानक इलेक्ट्रोकार्डियोग्राम (ECG) में P-तरंग, QRS सम्मिश्र (Complex) और T-तरंग क्रमशः किसे प्रदर्शित करते हैं?",
            optsEn = listOf("P-wave: Depolarisation of atria | QRS complex: Depolarisation of ventricles | T-wave: Repolarisation of ventricles", "P-wave: Repolarisation of atria | QRS complex: Repolarisation of ventricles | T-wave: Depolarisation of atria", "P-wave: Ventricular contraction | QRS: Atrial relaxation | T-wave: Atrial systole", "P-wave: Closure of semilunar valves | QRS: Diastole | T-wave: Systole"),
            optsHi = listOf("P-तरंग: अलिंदों का विध्रुवण | QRS सम्मिश्र: निलयों का विध्रुवण | T-तरंग: निलयों का पुनःध्रुवण", "P-तरंग: अलिंदों का पुनःध्रुवण | QRS: निलयों का पुनःध्रुवण | T-तरंग: अलिंदों का विध्रुवण", "P-तरंग: निलय प्रकुंचन | QRS: अलिंद शिथिलन | T-तरंग: अलिंद प्रकुंचन", "P-तरंग: कपाट बंद होना | QRS: अनुशिथिलन | T-तरंग: प्रकुंचन"),
            expEn = "NCERT Body Fluids and Circulation: P-wave represents electrical excitation (depolarisation) of atria; QRS complex represents depolarisation of ventricles (initiating ventricular systole); T-wave represents ventricular repolarisation.",
            expHi = "NCERT के अनुसार: P-तरंग अलिंदों के विध्रुवण (संकुचन) को, QRS सम्मिश्र निलयों के विध्रुवण को तथा T-तरंग निलयों के पुनःध्रुवण (सामान्य अवस्था में लौटने) को दर्शाती है।",
            yearTag = "NEET UG 2023 PYQ",
            subTopic = "Body Fluids & Circulation (ECG)"
        ),
        RawNeetPyqSeed(
            qEn = "When Glomerular Filtration Rate (GFR) falls, the Juxtaglomerular (JG) cells of the kidney are activated to release ____, which converts angiotensinogen in blood to Angiotensin-I:",
            qHi = "जब गुच्छीय निस्यंदन दर (GFR) में गिरावट आती है, तो वृक्क की गुच्छीय आसन्न (JG) कोशिकाएं सक्रिय होकर ____ मुक्त करती हैं, जो रक्त में एंजियोटेंसिनोजन को एंजियोटेंसिन-I में बदलता है:",
            optsEn = listOf("Renin (RAAS mechanism)", "Rennin (proteolytic enzyme in infant gastric juice)", "Atrial Natriuretic Factor (ANF)", "Antidiuretic Hormone (ADH) directly from JG cells"),
            optsHi = listOf("रेनिन / Renin (RAAS क्रियाविधि)", "रेनिन / Rennin (शिशुओं के जठर रस का एंजाइम)", "अलिंद नेट्रियूरेटिक कारक (ANF)", "JG कोशिकाओं से सीधे ADH"),
            expEn = "A fall in GFR activates JG cells to release Renin, initiating the Renin-Angiotensin-Aldosterone System (RAAS). Angiotensin-II acts as a powerful vasoconstrictor and stimulates aldosterone release to restore GFR.",
            expHi = "GFR घटने पर JG कोशिकाएं 'Renin' हार्मोन स्रावित करती हैं जो एंजियोटेंसिनोजन को एंजियोटेंसिन-I और फिर एंजियोटेंसिन-II में बदलकर रक्तदाब और GFR को पुनः सामान्य करता है।",
            yearTag = "NEET UG 2024 PYQ",
            subTopic = "Excretory Products & Their Elimination"
        ),
        RawNeetPyqSeed(
            qEn = "During skeletal muscle contraction according to the Sliding Filament Theory, which of the following changes occurs in a sarcomere?",
            qHi = "सर्पी तंतु सिद्धांत (Sliding Filament Theory) के अनुसार कंकाल पेशी संकुचन के दौरान सार्कोमियर (Sarcomere) में निम्नलिखित में से कौन-सा परिवर्तन होता है?",
            optsEn = listOf("I-band and H-zone shorten (reduce in length), while the A-band retains its original length", "A-band shortens while I-band remains unchanged", "Both A-band and I-band shorten equally", "Z-lines move further apart from each other"),
            optsHi = listOf("I-पट्टी (I-band) और H-क्षेत्र छोटे हो जाते हैं, जबकि A-पट्टी (A-band) की लंबाई अपरिवर्तित रहती है", "A-पट्टी छोटी हो जाती है जबकि I-पट्टी अपरिवर्तित रहती है", "A-पट्टी और I-पट्टी दोनों समान रूप से छोटी होती हैं", "Z-रेखाएं एक-दूसरे से दूर चली जाती हैं"),
            expEn = "During muscle contraction, thin (actin) filaments slide over thick (myosin) filaments pulling Z-lines closer: the sarcomere, I-band, and H-zone shorten, whereas the A-band length remains constant.",
            expHi = "पेशी संकुचन के समय एक्टिन तंतु मायोसिन तंतुओं पर सरकते हैं जिससे Z-रेखाएं पास आती हैं, I-पट्टी व H-क्षेत्र घटते हैं परंतु A-पट्टी की लंबाई स्थिर रहती है।",
            yearTag = "NEET UG 2023 PYQ",
            subTopic = "Locomotion & Movement (Sliding Filament)"
        ),
        RawNeetPyqSeed(
            qEn = "Surge of which hormone around the 14th day of the human menstrual cycle induces rupture of the Graafian follicle and ovulation?",
            qHi = "मानव आर्तव चक्र (Menstrual Cycle) के 14वें दिन के आसपास किस हार्मोन का तीव्र स्राव (Surge) ग्राफियन पुटक के फटने और अंडोत्सर्ग (Ovulation) को प्रेरित करता है?",
            optsEn = listOf("Luteinizing Hormone (LH Surge)", "Progesterone", "Prolactin", "Oxytocin"),
            optsHi = listOf("ल्यूटिनाइजिंग हार्मोन (LH Surge)", "प्रोजेस्टेरोन", "प्रोलैक्टिन", "ऑक्सीटोसिन"),
            expEn = "Both LH and FSH attain a peak level in the middle of the cycle (about 14th day). Rapid secretion of LH (LH surge) induces rupture of the Graafian follicle and release of the ovum (ovulation).",
            expHi = "आर्तव चक्र के मध्य (14वें दिन) में LH के तीव्र स्राव (LH Surge) के कारण ग्राफियन पुटक फटता है और अंडोत्सर्ग (Ovulation) होता है।",
            yearTag = "NEET UG 2024 PYQ",
            subTopic = "Human Reproduction (Menstrual Cycle)"
        ),
        RawNeetPyqSeed(
            qEn = "In a population in Hardy-Weinberg equilibrium (p² + 2pq + q² = 1), if the frequency of the recessive allele (q) is 0.4, what is the frequency of heterozygous individuals (2pq)?",
            qHi = "हार्डी-वेनबर्ग साम्यावस्था (p² + 2pq + q² = 1) में स्थित एक समष्टि में, यदि अप्रभावी अलील की आवृत्ति (q) = 0.4 है, तो विषमयुग्मजी (Heterozygous) व्यक्तियों की आवृत्ति (2pq) क्या होगी?",
            optsEn = listOf("0.48 (or 48%)", "0.36 (or 36%)", "0.16 (or 16%)", "0.24 (or 24%)"),
            optsHi = listOf("0.48 (अर्थात 48%)", "0.36 (अर्थात 36%)", "0.16 (अर्थात 16%)", "0.24 (अर्थात 24%)"),
            expEn = "Since p + q = 1 and q = 0.4, dominant allele frequency p = 1 - 0.4 = 0.6. Frequency of heterozygotes = 2pq = 2 × 0.6 × 0.4 = 0.48 (48%).",
            expHi = "चूंकि p + q = 1 और q = 0.4, अतः p = 0.6। विषमयुग्मजी आवृत्ति 2pq = 2 × 0.6 × 0.4 = 0.48 (48%) होगी।",
            yearTag = "NEET UG 2023 PYQ",
            subTopic = "Evolution (Hardy-Weinberg Principle)"
        ),
        RawNeetPyqSeed(
            qEn = "In recombinant DNA technology, after separating DNA fragments by agarose gel electrophoresis and staining with Ethidium Bromide (EtBr), the DNA bands are visualized as:",
            qHi = "पुनर्योगज DNA तकनीक में, एगारोज जेल वैद्युतकणसंचलन द्वारा DNA खंडों को पृथक करने और एथिडियम ब्रोमाइड (EtBr) से अभिरंजित करने के बाद, DNA पट्टियां किस प्रकार दिखाई देती हैं?",
            optsEn = listOf("Bright orange coloured bands under UV radiation", "Blue bands under visible white light", "Green bands under infrared light", "Red bands without staining under daylight"),
            optsHi = listOf("पराबैंगनी (UV) प्रकाश में चमकीली नारंगी रंग की पट्टियां (Bright orange bands)", "दृश्य श्वेत प्रकाश में नीली पट्टियां", "अवरक्त प्रकाश में हरी पट्टियां", "सामान्य प्रकाश में लाल पट्टियां"),
            expEn = "NCERT Biotechnology Principles and Processes:Separated DNA fragments can be visualized only after staining the DNA with Ethidium Bromide followed by exposure to UV radiation, appearing as bright orange bands.",
            expHi = "NCERT जैव प्रौद्योगिकी के अनुसार: एथिडियम ब्रोमाइड (EtBr) से अभिरंजित DNA को पराबैंगनी (UV) विकिरण में देखने पर चमकीली नारंगी पट्टियां दिखाई देती हैं।",
            yearTag = "NEET UG 2024 PYQ",
            subTopic = "Biotechnology: Principles & Processes"
        ),
        RawNeetPyqSeed(
            qEn = "In Bt cotton, which specific cry genes code for the crystal protein toxin that controls cotton bollworms vs corn borer respectively?",
            qHi = "Bt कपास में, कौन-से विशिष्ट cry जीन क्रमशः कपास के मुकुल कृमि (Cotton Bollworms) और मक्का छेदक (Corn Borer) को नियंत्रित करने वाले क्रिस्टल प्रोटीन विष का कूटलेखन करते हैं?",
            optsEn = listOf("cryIAc and cryIIAb control Cotton Bollworms | cryIAb controls Corn Borer", "cryIAb controls Cotton Bollworms | cryIAc controls Corn Borer", "pBR322 controls Bollworms | rop controls Corn Borer", "meloidogyne incognita controls Bollworms"),
            optsHi = listOf("cryIAc एवं cryIIAb कपास के मुकुल कृमि (Bollworms) को तथा cryIAb मक्का छेदक (Corn Borer) को नियंत्रित करते हैं", "cryIAb कपास के मुकुल कृमि को तथा cryIAc मक्का छेदक को नियंत्रित करता है", "pBR322 मुकुल कृमि को तथा rop मक्का छेदक को नियंत्रित करता है", "मेलोइडोगाइन इनकोग्निटा मुकुल कृमि को नियंत्रित करता है"),
            expEn = "NCERT Biotechnology and its Applications: Proteins encoded by the genes cryIAc and cryIIAb control the cotton bollworms, whereas that of cryIAb controls corn borer.",
            expHi = "NCERT के अनुसार: जीन cryIAc और cryIIAb द्वारा कूटबद्ध प्रोटीन कपास के मुकुल कृमि (Cotton Bollworms) को नियंत्रित करते हैं, जबकि cryIAb मक्का छेदक (Corn Borer) को नियंत्रित करता है।",
            yearTag = "NEET UG 2023 PYQ",
            subTopic = "Biotechnology & Its Applications (Bt Cotton)"
        )
    )
}
