package com.example.data.iitjee

internal object IitJeePyqSeedsPart2 {

    val jeeAdvPhysicsSeeds = listOf(
        RawIitJeePyqSeed(
            questionEn = "A uniform solid cylinder of mass M and radius R rolls without slipping down an inclined plane of angle theta. What is the ratio of its translational kinetic energy to its rotational kinetic energy about the center of mass? [JEE Advanced PYQ]",
            questionHi = "द्रव्यमान M और त्रिज्या R का एकसमान ठोस बेलन कोण theta के नत समतल पर बिना फिसले लुढ़कता है। इसकी स्थानांतरीय गतिज ऊर्जा और द्रव्यमान केंद्र के परितः घूर्णी गतिज ऊर्जा का अनुपात क्या है? [JEE Advanced PYQ]",
            optionsEn = listOf("1 : 1", "2 : 1", "5 : 2", "3 : 2"),
            optionsHi = listOf("1 : 1", "2 : 1", "5 : 2", "3 : 2"),
            correctIndex = 1,
            explanationEn = "K_trans = (1/2)Mv^2. For a solid cylinder, I = (1/2)MR^2 and pure rolling gives omega = v/R, so K_rot = (1/2)I*omega^2 = (1/4)Mv^2. Ratio K_trans : K_rot = (1/2) : (1/4) = 2 : 1.",
            explanationHi = "K_trans = (1/2)Mv^2। ठोस बेलन के लिए I = (1/2)MR^2 और शुद्ध लोटनी गति में omega = v/R, अतः K_rot = (1/4)Mv^2। अनुपात = 2 : 1।",
            subTopicTag = "Rigid Body Mechanics (Pure Rolling)",
            yearTag = "JEE Advanced 2024 Paper-1"
        ),
        RawIitJeePyqSeed(
            questionEn = "One mole of an ideal monoatomic gas undergoes a thermodynamic process P * V^2 = constant. What is the molar heat capacity (C) of the gas during this polytropic process? [JEE Advanced PYQ]",
            questionHi = "एक आदर्श एकपरमाणुक गैस का एक मोल ऊष्मागतिक प्रक्रम P * V^2 = नियतांक से गुजरता है। इस बहुदैशिक (Polytropic) प्रक्रम के दौरान गैस की मोलर ऊष्मा धारिता (C) क्या है? [JEE Advanced PYQ]",
            optionsEn = listOf("R / 2", "3R / 2", "5R / 2", "R"),
            optionsHi = listOf("R / 2", "3R / 2", "5R / 2", "R"),
            correctIndex = 0,
            explanationEn = "For a polytropic process PV^x = const, molar heat capacity C = C_v + R / (1 - x). For monoatomic gas C_v = 3R/2 and here x = 2. Thus C = 3R/2 + R/(1 - 2) = 3R/2 - R = R/2.",
            explanationHi = "बहुदैशिक प्रक्रम PV^x = नियतांक के लिए C = C_v + R/(1 - x)। एकपरमाणुक गैस के लिए C_v = 3R/2 और x = 2। अतः C = 3R/2 - R = R/2।",
            subTopicTag = "Thermodynamics Polytropic Process",
            yearTag = "JEE Advanced 2023 Paper-2"
        ),
        RawIitJeePyqSeed(
            questionEn = "A non-conducting solid sphere of radius R carries a radially non-uniform volume charge density rho(r) = rho_0 * (r / R) for r <= R. The electric field magnitude at a distance r = R / 2 from the center is: [JEE Advanced PYQ]",
            questionHi = "त्रिज्या R के एक अचालक ठोस गोले में अरीय रूप से असमान आयतन आवेश घनत्व rho(r) = rho_0 * (r / R) (r <= R के लिए) है। केंद्र से r = R / 2 दूरी पर विद्युत क्षेत्र का परिमाण है: [JEE Advanced PYQ]",
            optionsEn = listOf(
                "(rho_0 * R) / (16 * epsilon_0)",
                "(rho_0 * R) / (8 * epsilon_0)",
                "(rho_0 * R) / (4 * epsilon_0)",
                "(rho_0 * R) / (12 * epsilon_0)"
            ),
            optionsHi = listOf(
                "(rho_0 * R) / (16 * epsilon_0)",
                "(rho_0 * R) / (8 * epsilon_0)",
                "(rho_0 * R) / (4 * epsilon_0)",
                "(rho_0 * R) / (12 * epsilon_0)"
            ),
            correctIndex = 0,
            explanationEn = "By Gauss's Law, q_enclosed(r) = Integral_0^r [rho_0*(r'/R) * 4*pi*r'^2 dr'] = (pi * rho_0 * r^4) / R. Since E * 4*pi*r^2 = q_enc / epsilon_0, E(r) = (rho_0 * r^2) / (4 * epsilon_0 * R). At r = R/2, E = (rho_0 * R) / (16 * epsilon_0).",
            explanationHi = "गॉस के नियम से q_enc(r) = (pi * rho_0 * r^4)/R। अतः E(r) = (rho_0 * r^2)/(4 * epsilon_0 * R)। r = R/2 रखने पर E = (rho_0 * R)/(16 * epsilon_0)।",
            subTopicTag = "Electrostatics Gauss Law",
            yearTag = "JEE Advanced 2024 Paper-2"
        ),
        RawIitJeePyqSeed(
            questionEn = "A conducting rod of length L rotates with constant angular velocity omega about one of its ends in a uniform magnetic field B perpendicular to the plane of rotation. If the rod starts from rest in a circuit, the steady state induced EMF between the ends is: [JEE Advanced PYQ]",
            questionHi = "लंबाई L की एक चालक छड़ घूर्णन तल के लंबवत एकसमान चुंबकीय क्षेत्र B में अपने एक सिरे के परितः नियत कोणीय वेग omega से घूमती है। सिरों के बीच प्रेरित विद्युत वाहक बल (EMF) है: [JEE Advanced PYQ]",
            optionsEn = listOf("B * omega * L^2", "(1/2) * B * omega * L^2", "(1/4) * B * omega * L^2", "2 * B * omega * L^2"),
            optionsHi = listOf("B * omega * L^2", "(1/2) * B * omega * L^2", "(1/4) * B * omega * L^2", "2 * B * omega * L^2"),
            correctIndex = 1,
            explanationEn = "Integrating dE = B * v(r) dr = B * (omega * r) dr from r = 0 to r = L gives E = (1/2) * B * omega * L^2.",
            explanationHi = "r = 0 से L तक dE = B*(omega*r)dr का समाकलन करने पर E = (1/2) * B * omega * L^2 प्राप्त होता है।",
            subTopicTag = "Motional EMF & Faraday Law",
            yearTag = "JEE Advanced 2022 Paper-1"
        ),
        RawIitJeePyqSeed(
            questionEn = "In a modified Young's double-slit experiment, a thin transparent mica sheet of thickness t = 3.6 micrometers and refractive index mu = 1.5 is placed in front of one slit. If monochromatic light of wavelength 600 nm is used, how many fringes shift on the screen? [JEE Advanced PYQ]",
            questionHi = "संशोधित यंग के द्वि-झिरी प्रयोग में, एक झिरी के सामने मोटाई t = 3.6 माइक्रोमीटर और अपवर्तनांक mu = 1.5 की पतली पारदर्शी अभ्रक सीट रखी जाती है। यदि 600 nm तरंगदैर्ध्य के प्रकाश का उपयोग किया जाए, तो पर्दे पर कितनी फ्रिंजें विस्थापित होंगी? [JEE Advanced PYQ]",
            optionsEn = listOf("2 fringes", "3 fringes", "4 fringes", "6 fringes"),
            optionsHi = listOf("2 फ्रिंज", "3 फ्रिंज", "4 फ्रिंज", "6 फ्रिंज"),
            correctIndex = 1,
            explanationEn = "Additional optical path difference Delta_x = (mu - 1) * t = (1.5 - 1) * 3.6 um = 1.8 um = 1800 nm. Number of fringes shifted n = Delta_x / lambda = 1800 nm / 600 nm = 3 fringes.",
            explanationHi = "अतिरिक्त प्रकाशीय पथांतर Delta_x = (mu - 1)*t = 0.5 * 3.6 um = 1800 nm। विस्थापित फ्रिंजों की संख्या n = 1800 / 600 = 3 फ्रिंज।",
            subTopicTag = "Wave Optics Interference Shift",
            yearTag = "JEE Advanced 2023 Paper-1"
        ),
        RawIitJeePyqSeed(
            questionEn = "A stationary radioactive nucleus of mass number A = 220 decays by emitting an alpha particle (mass number 4) with kinetic energy E_alpha = 5.4 MeV. What is the total disintegration energy (Q-value) of the alpha decay? [JEE Advanced PYQ]",
            questionHi = "द्रव्यमान संख्या A = 220 का एक स्थिर रेडियोधर्मी नाभिक गतिज ऊर्जा E_alpha = 5.4 MeV के अल्फा कण (द्रव्यमान संख्या 4) का उत्सर्जन करके क्षयित होता है। अल्फा क्षय की कुल विघटन ऊर्जा (Q-मान) क्या है? [JEE Advanced PYQ]",
            optionsEn = listOf("5.40 MeV", "5.50 MeV", "5.80 MeV", "6.10 MeV"),
            optionsHi = listOf("5.40 MeV", "5.50 MeV", "5.80 MeV", "6.10 MeV"),
            correctIndex = 1,
            explanationEn = "By momentum conservation, daughter nucleus mass = 220 - 4 = 216. Since E_alpha = [(A - 4)/A] * Q = (216/220) * Q = (54/55) * Q, we get Q = 5.4 * (55/54) = 5.50 MeV.",
            explanationHi = "संवेग संरक्षण से पुत्री नाभिक का द्रव्यमान = 216। E_alpha = (216/220)*Q => 5.4 = (54/55)*Q => Q = 5.50 MeV।",
            subTopicTag = "Nuclear Physics Q-Value & Recoil",
            yearTag = "JEE Advanced 2021 Paper-2"
        ),
        RawIitJeePyqSeed(
            questionEn = "In an LCR series AC circuit connected to a variable frequency source, resonance occurs at angular frequency omega_0 = 1000 rad/s. If the resistance R = 10 Ohm and inductance L = 0.1 H, what is the Quality Factor (Q-factor) and bandwidth of the circuit? [JEE Advanced PYQ]",
            questionHi = "परिवर्ती आवृत्ति स्रोत से जुड़े एक श्रेणी LCR प्रत्यावर्ती धारा परिपथ में कोणीय आवृत्ति omega_0 = 1000 rad/s पर अनुनाद होता है। यदि प्रतिरोध R = 10 Ohm और प्रेरकत्व L = 0.1 H है, तो परिपथ का विशेषता गुणांक (Q-factor) और बैंडविड्थ क्या है? [JEE Advanced PYQ]",
            optionsEn = listOf(
                "Q = 10, Bandwidth = 100 rad/s",
                "Q = 20, Bandwidth = 50 rad/s",
                "Q = 5, Bandwidth = 200 rad/s",
                "Q = 100, Bandwidth = 10 rad/s"
            ),
            optionsHi = listOf(
                "Q = 10, बैंडविड्थ = 100 rad/s",
                "Q = 20, बैंडविड्थ = 50 rad/s",
                "Q = 5, बैंडविड्थ = 200 rad/s",
                "Q = 100, बैंडविड्थ = 10 rad/s"
            ),
            correctIndex = 0,
            explanationEn = "Q-factor = (omega_0 * L) / R = (1000 * 0.1) / 10 = 10. Bandwidth Delta_omega = R / L = 10 / 0.1 = 100 rad/s.",
            explanationHi = "Q-गुणांक = (omega_0 * L) / R = (1000 * 0.1) / 10 = 10। बैंडविड्थ = R / L = 10 / 0.1 = 100 rad/s।",
            subTopicTag = "Alternating Current Resonance",
            yearTag = "JEE Advanced 2022 Paper-2"
        ),
        RawIitJeePyqSeed(
            questionEn = "A cylindrical vessel filled with water up to height H has a small orifice at depth h below the free water surface. For the horizontal range x of the emerging water jet on the ground to be maximum, the value of h and maximum range x_max are: [JEE Advanced PYQ]",
            questionHi = "ऊंचाई H तक पानी से भरे एक बेलनाकार बर्तन में मुक्त जल सतह से h गहराई पर एक छोटा छिद्र है। जमीन पर निकलने वाली जल धारा की क्षैतिज परास x अधिकतम होने के लिए, h का मान और अधिकतम परास x_max हैं: [JEE Advanced PYQ]",
            optionsEn = listOf(
                "h = H / 2 and x_max = H",
                "h = H / 4 and x_max = H / 2",
                "h = H / 3 and x_max = 2H / 3",
                "h = 2H / 3 and x_max = 2H"
            ),
            optionsHi = listOf(
                "h = H / 2 और x_max = H",
                "h = H / 4 और x_max = H / 2",
                "h = H / 3 और x_max = 2H / 3",
                "h = 2H / 3 और x_max = 2H"
            ),
            correctIndex = 0,
            explanationEn = "By Torricelli's theorem, efflux speed v = sqrt(2gh) and time to fall height (H - h) is t = sqrt(2(H - h)/g). Horizontal range x = v*t = 2*sqrt(h(H - h)), which is maximum when h = H/2, giving x_max = H.",
            explanationHi = "टॉरिसेली प्रमेय से v = sqrt(2gh) तथा गिरने का समय t = sqrt(2(H - h)/g)। परास x = 2*sqrt(h(H - h)), जो h = H/2 पर अधिकतम (x_max = H) होती है।",
            subTopicTag = "Fluid Mechanics Torricelli Efflux",
            yearTag = "JEE Advanced 2020 Paper-1"
        ),
        RawIitJeePyqSeed(
            questionEn = "Two satellites S1 and S2 revolve around a planet in coplanar circular orbits of radii R and 4R respectively in the same sense. If the time period of S1 is T, what is the time interval between two successive closest approaches of S1 and S2? [JEE Advanced PYQ]",
            questionHi = "दो उपग्रह S1 और S2 एक ही दिशा में क्रमशः R और 4R त्रिज्या की समतलीय वृत्ताकार कक्षाओं में एक ग्रह की परिक्रमा करते हैं। यदि S1 का आवर्तकाल T है, तो S1 और S2 के दो क्रमिक निकटतम दृष्टिकोणों के बीच समय अंतराल क्या है? [JEE Advanced PYQ]",
            optionsEn = listOf("(8 / 7) T", "(4 / 3) T", "7 T", "(9 / 8) T"),
            optionsHi = listOf("(8 / 7) T", "(4 / 3) T", "7 T", "(9 / 8) T"),
            correctIndex = 0,
            explanationEn = "By Kepler's third law, T2 / T1 = (4R / R)^(3/2) = 8, so T2 = 8T. Relative angular speed omega_rel = omega_1 - omega_2 = 2*pi/T - 2*pi/(8T) = (7/8)*(2*pi/T). Synodic period T_rel = 2*pi / omega_rel = (8/7)T.",
            explanationHi = "केपलर के तृतीय नियम से T2 = 8T। सापेक्ष कोणीय वेग omega_rel = 2*pi/T - 2*pi/(8T) = (7/8)*(2*pi/T)। अतः समय अंतराल = (8/7)T।",
            subTopicTag = "Gravitation & Orbital Mechanics",
            yearTag = "JEE Advanced 2021 Paper-1"
        ),
        RawIitJeePyqSeed(
            questionEn = "A particle of mass m moves in a central potential U(r) = (1/2) k r^2 in a circular orbit of radius r_0. According to Bohr's quantization condition (angular momentum L = n * h_bar), the allowed orbital radii r_n are proportional to: [JEE Advanced PYQ]",
            questionHi = "द्रव्यमान m का एक कण केंद्रीय विभव U(r) = (1/2) k r^2 में त्रिज्या r_0 की वृत्ताकार कक्षा में गति करता है। बोहर के क्वांटीकरण प्रतिबंध (कोणीय संवेग L = n * h_bar) के अनुसार, अनुमत कक्षीय त्रिज्या r_n किसके समानुपाती है? [JEE Advanced PYQ]",
            optionsEn = listOf("n^(1/2)", "n", "n^2", "n^(1/4)"),
            optionsHi = listOf("n^(1/2)", "n", "n^2", "n^(1/4)"),
            correctIndex = 0,
            explanationEn = "Centripetal force F = -dU/dr = -kr => m*v^2/r = k*r => v = r*sqrt(k/m). Angular momentum L = m*v*r = r^2 * sqrt(m*k) = n*h_bar. Therefore, r_n is proportional to n^(1/2).",
            explanationHi = "अभिकेंद्र बल m*v^2/r = k*r तथा कोणीय संवेग L = m*v*r = r^2*sqrt(mk) = n*h_bar। अतः r_n, n^(1/2) के समानुपाती है।",
            subTopicTag = "Modern Physics Bohr Quantization",
            yearTag = "JEE Advanced 2024 Paper-1"
        )
    )

    val jeeAdvPhysicalChemSeeds = listOf(
        RawIitJeePyqSeed(
            questionEn = "For a non-ideal gas obeying the reduced van der Waals equation of state, what is the critical compressibility factor Z_c = (P_c * V_c) / (R * T_c) for 1 mole of the gas? [JEE Advanced PYQ]",
            questionHi = "वांडरवाल्स अवस्था समीकरण का पालन करने वाली एक अनादर्श गैस के 1 मोल के लिए क्रांतिक संपीड्यता गुणांक Z_c = (P_c * V_c) / (R * T_c) का मान क्या है? [JEE Advanced PYQ]",
            optionsEn = listOf("3 / 8 (0.375)", "8 / 27 (0.296)", "1 / 2 (0.500)", "1.000"),
            optionsHi = listOf("3 / 8 (0.375)", "8 / 27 (0.296)", "1 / 2 (0.500)", "1.000"),
            correctIndex = 0,
            explanationEn = "For a van der Waals gas, V_c = 3b, P_c = a / (27b^2), and T_c = 8a / (27Rb). Substituting these gives Z_c = (P_c * V_c) / (R * T_c) = 3 / 8 = 0.375.",
            explanationHi = "वांडरवाल्स गैस के लिए V_c = 3b, P_c = a/(27b^2), T_c = 8a/(27Rb)। मान रखने पर Z_c = 3/8 = 0.375 प्राप्त होता है।",
            subTopicTag = "Real Gases & Critical Constants",
            yearTag = "JEE Advanced 2023 Paper-1"
        ),
        RawIitJeePyqSeed(
            questionEn = "In an FCC crystal lattice of an element (molar mass M = 108 g/mol, Avogadro constant N_A = 6.0 x 10^23 mol^-1), the edge length of the unit cell is a = 400 pm. What is the theoretical density of the metal? [JEE Advanced PYQ]",
            questionHi = "एक तत्व (मोलर द्रव्यमान M = 108 g/mol, आवोगाद्रो नियतांक N_A = 6.0 x 10^23 mol^-1) के फलक-केंद्रित घनीय (FCC) जालक में एकक कोष्ठिका की कोर लंबाई a = 400 pm है। धातु का सैद्धांतिक घनत्व क्या है? [JEE Advanced PYQ]",
            optionsEn = listOf("11.25 g/cm^3", "8.45 g/cm^3", "10.50 g/cm^3", "5.62 g/cm^3"),
            optionsHi = listOf("11.25 g/cm^3", "8.45 g/cm^3", "10.50 g/cm^3", "5.62 g/cm^3"),
            correctIndex = 0,
            explanationEn = "For FCC, Z = 4. Volume a^3 = (4 x 10^-8 cm)^3 = 64 x 10^-24 cm^3. Density d = (Z * M) / (N_A * a^3) = (4 * 108) / (6.0 x 10^23 * 64 x 10^-24) = 432 / 38.4 = 11.25 g/cm^3.",
            explanationHi = "FCC के लिए Z = 4। a^3 = 64 x 10^-24 cm^3। घनत्व d = (Z*M)/(N_A*a^3) = (4 * 108) / 38.4 = 11.25 g/cm^3।",
            subTopicTag = "Solid State Crystallography",
            yearTag = "JEE Advanced 2024 Paper-1"
        ),
        RawIitJeePyqSeed(
            questionEn = "Consider a parallel first-order reaction where reactant A simultaneously forms B (rate constant k1 = 2.0 x 10^-3 s^-1, activation energy E1 = 60 kJ/mol) and C (rate constant k2 = 4.0 x 10^-3 s^-1, activation energy E2 = 90 kJ/mol). What is the effective activation energy (E_eff) for the disappearance of A? [JEE Advanced PYQ]",
            questionHi = "एक समानांतर प्रथम-कोटि अभिक्रिया पर विचार करें जहाँ अभिकारक A एक साथ B (दर नियतांक k1 = 2.0 x 10^-3 s^-1, सक्रियण ऊर्जा E1 = 60 kJ/mol) और C (k2 = 4.0 x 10^-3 s^-1, E2 = 90 kJ/mol) बनाता है। A के विलोपन के लिए प्रभावी सक्रियण ऊर्जा (E_eff) क्या है? [JEE Advanced PYQ]",
            optionsEn = listOf("80 kJ/mol", "75 kJ/mol", "70 kJ/mol", "85 kJ/mol"),
            optionsHi = listOf("80 kJ/mol", "75 kJ/mol", "70 kJ/mol", "85 kJ/mol"),
            correctIndex = 0,
            explanationEn = "Effective activation energy E_eff = (k1*E1 + k2*E2) / (k1 + k2) = (2 * 60 + 4 * 90) / (2 + 4) = (120 + 360) / 6 = 480 / 6 = 80 kJ/mol.",
            explanationHi = "प्रभावी सक्रियण ऊर्जा E_eff = (k1*E1 + k2*E2)/(k1 + k2) = (2*60 + 4*90)/6 = 480/6 = 80 kJ/mol।",
            subTopicTag = "Parallel Reaction Kinetics",
            yearTag = "JEE Advanced 2022 Paper-2"
        ),
        RawIitJeePyqSeed(
            questionEn = "At 298 K, the solubility product K_sp of AgCl in water is 1.0 x 10^-10. What is the molar solubility of AgCl in an aqueous solution containing 0.01 M NaCl (ignoring activity coefficients)? [JEE Advanced PYQ]",
            questionHi = "298 K पर जल में AgCl का विलेयता गुणनफल K_sp = 1.0 x 10^-10 है। 0.01 M NaCl युक्त जलीय विलयन में AgCl की मोलर विलेयता क्या है? [JEE Advanced PYQ]",
            optionsEn = listOf("1.0 x 10^-8 M", "1.0 x 10^-5 M", "1.0 x 10^-10 M", "1.0 x 10^-6 M"),
            optionsHi = listOf("1.0 x 10^-8 M", "1.0 x 10^-5 M", "1.0 x 10^-10 M", "1.0 x 10^-6 M"),
            correctIndex = 0,
            explanationEn = "Due to common ion Cl- from 0.01 M NaCl, [Cl-] approx 0.01 M = 10^-2 M. Since K_sp = [Ag+][Cl-], solubility s = [Ag+] = K_sp / [Cl-] = 1.0 x 10^-10 / 10^-2 = 1.0 x 10^-8 M.",
            explanationHi = "सम-आयन प्रभाव के कारण [Cl-] = 0.01 M = 10^-2 M। अतः विलेयता s = K_sp / [Cl-] = 1.0 x 10^-10 / 10^-2 = 1.0 x 10^-8 M।",
            subTopicTag = "Ionic Equilibrium & Common Ion Effect",
            yearTag = "JEE Advanced 2023 Paper-2"
        ),
        RawIitJeePyqSeed(
            questionEn = "For a concentration cell Pt | H2 (1 bar) | HCl (pH = 2) || HCl (pH = 4) | H2 (1 bar) | Pt at 298 K, the cell EMF (in Volts, given 2.303 RT/F = 0.059 V) is: [JEE Advanced PYQ]",
            questionHi = "298 K पर सांद्रता सेल Pt | H2 (1 bar) | HCl (pH = 2) || HCl (pH = 4) | H2 (1 bar) | Pt के लिए सेल का विद्युत वाहक बल (EMF) क्या है (दिया है 2.303 RT/F = 0.059 V)? [JEE Advanced PYQ]",
            optionsEn = listOf("-0.118 V", "+0.118 V", "+0.059 V", "0.000 V"),
            optionsHi = listOf("-0.118 V", "+0.118 V", "+0.059 V", "0.000 V"),
            correctIndex = 0,
            explanationEn = "In a hydrogen concentration cell with 1 bar pressure at both electrodes, E_cell = -0.059 * (pH_cathode - pH_anode) = -0.059 * (4 - 2) = -0.118 V.",
            explanationHi = "हाइड्रोजन सांद्रता सेल के लिए E_cell = -0.059 * (pH_cathode - pH_anode) = -0.059 * (4 - 2) = -0.118 V।",
            subTopicTag = "Electrochemistry Concentration Cells",
            yearTag = "JEE Advanced 2021 Paper-1"
        ),
        RawIitJeePyqSeed(
            questionEn = "One mole of an ideal gas expands isothermally and reversibly at 300 K from 2 L to 20 L. What is the entropy change of the system (Delta S_sys) and universe (Delta S_univ)? (Given R = 8.314 J K^-1 mol^-1, ln 10 = 2.303) [JEE Advanced PYQ]",
            questionHi = "एक आदर्श गैस का एक मोल 300 K पर 2 L से 20 L तक समतापीय और उत्क्रमणीय रूप से प्रसारित होता है। निकाय (Delta S_sys) और ब्रह्मांड (Delta S_univ) का एंट्रॉपी परिवर्तन क्या है? [JEE Advanced PYQ]",
            optionsEn = listOf(
                "Delta S_sys = +19.15 J/K, Delta S_univ = 0 J/K",
                "Delta S_sys = +19.15 J/K, Delta S_univ = +19.15 J/K",
                "Delta S_sys = 0 J/K, Delta S_univ = 0 J/K",
                "Delta S_sys = -19.15 J/K, Delta S_univ = +19.15 J/K"
            ),
            optionsHi = listOf(
                "Delta S_sys = +19.15 J/K, Delta S_univ = 0 J/K",
                "Delta S_sys = +19.15 J/K, Delta S_univ = +19.15 J/K",
                "Delta S_sys = 0 J/K, Delta S_univ = 0 J/K",
                "Delta S_sys = -19.15 J/K, Delta S_univ = +19.15 J/K"
            ),
            correctIndex = 0,
            explanationEn = "Delta S_sys = n R ln(V2/V1) = 1 * 8.314 * 2.303 * log10(20/2) = +19.15 J/K. Because the process is reversible, Delta S_surr = -19.15 J/K, so Delta S_univ = 0 J/K.",
            explanationHi = "Delta S_sys = 2.303 * R * log10(10) = +19.15 J/K। चूंकि प्रक्रम उत्क्रमणीय है, अतः Delta S_univ = 0 J/K।",
            subTopicTag = "Second Law of Thermodynamics & Entropy",
            yearTag = "JEE Advanced 2022 Paper-1"
        ),
        RawIitJeePyqSeed(
            questionEn = "In the radial wave function R_nl(r) of the hydrogen atom, how many radial (spherical) nodes and angular (planar/conical) nodes are present in a 4d orbital? [JEE Advanced PYQ]",
            questionHi = "हाइड्रोजन परमाणु के त्रिज्य तरंग फलन R_nl(r) में, एक 4d कक्षक में कितने त्रिज्य (गोलीय) नोड और कोणीय नोड उपस्थित होते हैं? [JEE Advanced PYQ]",
            optionsEn = listOf(
                "1 radial node and 2 angular nodes",
                "2 radial nodes and 1 angular node",
                "2 radial nodes and 2 angular nodes",
                "0 radial nodes and 3 angular nodes"
            ),
            optionsHi = listOf(
                "1 त्रिज्य नोड और 2 कोणीय नोड",
                "2 त्रिज्य नोड और 1 कोणीय नोड",
                "2 त्रिज्य नोड और 2 कोणीय नोड",
                "0 त्रिज्य नोड और 3 कोणीय नोड"
            ),
            correctIndex = 0,
            explanationEn = "For a 4d orbital, n = 4 and l = 2. Radial nodes = n - l - 1 = 4 - 2 - 1 = 1. Angular nodes = l = 2.",
            explanationHi = "4d कक्षक के लिए n = 4 और l = 2। त्रिज्य नोड = n - l - 1 = 4 - 2 - 1 = 1 तथा कोणीय नोड = l = 2।",
            subTopicTag = "Quantum Mechanical Model of Atom",
            yearTag = "JEE Advanced 2020 Paper-2"
        ),
        RawIitJeePyqSeed(
            questionEn = "An aqueous solution containing 1.22 g of benzoic acid (M = 122 g/mol) in 100 g of benzene shows a freezing point depression corresponding to an apparent molar mass of 200 g/mol. What is the degree of dimerization (alpha) of benzoic acid in benzene? [JEE Advanced PYQ]",
            questionHi = "100 ग्राम बेंजीन में 1.22 ग्राम बेंजोइक अम्ल (M = 122 g/mol) युक्त विलयन में हिमांक अवनमन प्रेक्षित मोलर द्रव्यमान 200 g/mol दर्शाता है। बेंजीन में बेंजोइक अम्ल के द्विलकीकरण की मात्रा (alpha) क्या है? [JEE Advanced PYQ]",
            optionsEn = listOf("0.78 (78%)", "0.61 (61%)", "0.85 (85%)", "0.50 (50%)"),
            optionsHi = listOf("0.78 (78%)", "0.61 (61%)", "0.85 (85%)", "0.50 (50%)"),
            correctIndex = 0,
            explanationEn = "Van't Hoff factor i = M_normal / M_observed = 122 / 200 = 0.61. For dimerization (2A <-> A2, n = 2), i = 1 - alpha/2 => 0.61 = 1 - alpha/2 => alpha/2 = 0.39 => alpha = 0.78 (78%).",
            explanationHi = "वान्ट हॉफ गुणांक i = 122 / 200 = 0.61। द्विलकीकरण के लिए i = 1 - alpha/2 => alpha = 2 * (1 - 0.61) = 0.78 (78%)।",
            subTopicTag = "Colligative Properties & Dimerization",
            yearTag = "JEE Advanced 2024 Paper-2"
        )
    )

    val jeeAdvOrganicChemSeeds = listOf(
        RawIitJeePyqSeed(
            questionEn = "When cyclohexanone is treated with hydrazoic acid (HN3) in the presence of concentrated H2SO4 (Schmidt reaction), or first converted to its oxime and treated with conc. H2SO4 (Beckmann rearrangement), the major cyclic product formed is: [JEE Advanced PYQ]",
            questionHi = "जब साइक्लोहेक्सेनोन की सांद्र H2SO4 की उपस्थिति में हाइड्रेज़ोइक अम्ल (HN3) के साथ क्रिया कराई जाती है (श्मिट अभिक्रिया), या इसके ऑक्सिम का बेकमैन पुनर्विन्यास कराया जाता है, तो बनने वाला मुख्य चक्रीय उत्पाद है: [JEE Advanced PYQ]",
            optionsEn = listOf(
                "epsilon-Caprolactam (7-membered cyclic amide, monomer of Nylon-6)",
                "Cyclohexylamine",
                "Adipic acid",
                "Aniline"
            ),
            optionsHi = listOf(
                "एप्सिलॉन-कैप्रोलैक्टम (7-सदस्यीय चक्रीय एमाइड, नायलॉन-6 का एकलक)",
                "साइक्लोहेक्सिलऐमीन",
                "एडिपिक अम्ल",
                "एनिलीन"
            ),
            correctIndex = 0,
            explanationEn = "Ring expansion of cyclohexanone oxime via Beckmann rearrangement (or Schmidt reaction on cyclohexanone) inserts an -NH- group into the ring, forming the 7-membered lactam epsilon-Caprolactam, which polymerizes to Nylon-6.",
            explanationHi = "साइक्लोहेक्सेनोन ऑक्सिम के बेकमैन पुनर्विन्यास से वलय विस्तार होकर 7-सदस्यीय चक्रीय एमाइड 'एप्सिलॉन-कैप्रोलैक्टम' बनता है, जो नायलॉन-6 का एकलक है।",
            subTopicTag = "Beckmann Rearrangement & Ring Expansion",
            yearTag = "JEE Advanced 2024 Paper-1"
        ),
        RawIitJeePyqSeed(
            questionEn = "In the Pinacol-Pinacolone rearrangement of unsymmetrical 1,1-diphenyl-2,2-dimethylpropane-1,2-diol with dilute H2SO4, which carbocation is initially formed and which group migrates preferentially? [JEE Advanced PYQ]",
            questionHi = "तनु H2SO4 के साथ असममित 1,1-डाइफेनिल-2,2-डाइमेथिलप्रोपेन-1,2-डाइऑल के पिनाकोल-पिनाकोलोन पुनर्विन्यास में, प्रारंभ में कौन सा कार्बधनायन बनता है और कौन सा समूह वरीयता से अभिगमन करता है? [JEE Advanced PYQ]",
            optionsEn = listOf(
                "Carbocation at C-1 (stabilized by two phenyl rings) is formed, and a methyl group migrates from C-2",
                "Carbocation at C-2 is formed, and a phenyl group migrates from C-1",
                "No rearrangement occurs; an epoxide is formed",
                "Elimination yields a conjugated diene exclusively"
            ),
            optionsHi = listOf(
                "C-1 पर कार्बधनायन (दो फेनिल वलयों द्वारा स्थायीकृत) बनता है, और C-2 से एक मेथिल समूह अभिगमन करता है",
                "C-2 पर कार्बधनायन बनता है, और C-1 से फेनिल समूह अभिगमन करता है",
                "कोई पुनर्विन्यास नहीं होता; एपॉक्साइड बनता है",
                "विलोपन से केवल संयुग्मित डाइईन बनती है"
            ),
            correctIndex = 0,
            explanationEn = "The rate-determining step is the formation of the most stable carbocation. Protonation and loss of H2O occurs at C-1 to give the highly resonance-stabilized diphenylmethyl carbocation, followed by 1,2-methyl shift from C-2.",
            explanationHi = "दर-निर्धारक पद सबसे स्थायी कार्बधनायन का निर्माण है। C-1 से जल के निष्कासन से अनुनाद-स्थायीकृत डाइफेनिलमेथिल कार्बधनायन बनता है, जिसके बाद C-2 से मेथिल समूह का 1,2-अभिगमन होता है।",
            subTopicTag = "Pinacol-Pinacolone Rearrangement",
            yearTag = "JEE Advanced 2023 Paper-1"
        ),
        RawIitJeePyqSeed(
            questionEn = "When trans-2-butene is reacted with cold dilute alkaline KMnO4 (Baeyer's reagent) vs. peroxy acid (m-CPBA followed by H3O+), the stereochemical outcomes are respectively: [JEE Advanced PYQ]",
            questionHi = "जब ट्रांस-2-ब्यूटीन की ठंडे तनु क्षारीय KMnO4 (बेयर अभिकर्मक) बनाम परऑक्सी अम्ल (m-CPBA तत्पश्चात H3O+) के साथ अभिक्रिया कराई जाती है, तो त्रिविम रासायनिक उत्पाद क्रमशः होते हैं: [JEE Advanced PYQ]",
            optionsEn = listOf(
                "Racemic (+/-)-butane-2,3-diol (syn-hydroxylation) and meso-butane-2,3-diol (anti-hydroxylation)",
                "Meso-butane-2,3-diol and Racemic (+/-)-butane-2,3-diol",
                "Both reactions give exclusively meso-butane-2,3-diol",
                "Both reactions give exclusively racemic butane-2,3-diol"
            ),
            optionsHi = listOf(
                "रेसेमिक (+/-)-ब्यूटेन-2,3-डाइऑल (syn-हाइड्रॉक्सिलीकरण) और मेसो-ब्यूटेन-2,3-डाइऑल (anti-हाइड्रॉक्सिलीकरण)",
                "मेसो-ब्यूटेन-2,3-डाइऑल और रेसेमिक (+/-)-ब्यूटेन-2,3-डाइऑल",
                "दोनों अभिक्रियाएं केवल मेसो-ब्यूटेन-2,3-डाइऑल देती हैं",
                "दोनों अभिक्रियाएं केवल रेसेमिक ब्यूटेन-2,3-डाइऑल देती हैं"
            ),
            correctIndex = 0,
            explanationEn = "By stereochemical rule (Trans + Syn = Racemic; Trans + Anti = Meso): Cold KMnO4 causes syn-dihydroxylation on trans-2-butene to give racemic (+/-) diol, whereas m-CPBA/H3O+ causes anti-dihydroxylation to give meso-diol.",
            explanationHi = "Trans + Syn = Racemic तथा Trans + Anti = Meso नियम से: ठंडा KMnO4 ट्रांस-2-ब्यूटीन का syn-डाइहाइड्रॉक्सिलीकरण कर रेसेमिक मिश्रण देता है, जबकि m-CPBA/H3O+ anti-डाइहाइड्रॉक्सिलीकरण कर मेसो-डाइऑल देता है।",
            subTopicTag = "Stereospecific Alkene Dihydroxylation",
            yearTag = "JEE Advanced 2022 Paper-2"
        ),
        RawIitJeePyqSeed(
            questionEn = "Which of the following cyclic species is aromatic according to Huckel's (4n + 2) pi-electron rule and possesses a substantial dipole moment? [JEE Advanced PYQ]",
            questionHi = "निम्नलिखित में से कौन सी चक्रीय स्पीशीज हकल के (4n + 2) पाई-इलेक्ट्रॉन नियम के अनुसार एरोमैटिक है और इसमें उच्च द्विध्रुव आघूर्ण (Dipole Moment) पाया जाता है? [JEE Advanced PYQ]",
            optionsEn = listOf(
                "Azulene (bicyclic 10 pi-electron isomer of naphthalene) and Tropone",
                "Cyclooctatetraene (COT)",
                "Cyclopentadienyl cation",
                "Cycloheptatrienyl anion"
            ),
            optionsHi = listOf(
                "एज़ुलीन (नेफ़थलीन का द्विवलयी 10 पाई-इलेक्ट्रॉन समावयवी) और ट्रोपोन",
                "साइक्लोऑक्टाटेट्राईन (COT)",
                "साइक्लोपेंटाडाइएनाइल धनायन",
                "साइक्लोहेप्टाट्राइएनाइल ऋणायन"
            ),
            correctIndex = 0,
            explanationEn = "Azulene consists of a 7-membered ring fused to a 5-membered ring; charge-separated resonance makes the 7-ring tropylium-like (+, 6 pi) and the 5-ring cyclopentadienyl-like (-, 6 pi), giving a 10 pi aromatic system with a dipole moment of ~1.08 D.",
            explanationHi = "एज़ुलीन में 7-सदस्यीय और 5-सदस्यीय वलय जुड़े होते हैं जो आवेश पृथक्करण द्वारा दोनों वलयों में 6 पाई-इलेक्ट्रॉन (कुल 10 पाई एरोमैटिक तंत्र) तथा उच्च द्विध्रुव आघूर्ण उत्पन्न करते हैं।",
            subTopicTag = "Non-Benzenoid Aromaticity",
            yearTag = "JEE Advanced 2023 Paper-2"
        ),
        RawIitJeePyqSeed(
            questionEn = "In the Cannizzaro reaction of a mixture of formaldehyde (HCHO) and benzaldehyde (PhCHO) with concentrated NaOH (Crossed Cannizzaro), which products are formed? [JEE Advanced PYQ]",
            questionHi = "सांद्र NaOH के साथ फॉर्मेल्डिहाइड (HCHO) और बेंजैल्डिहाइड (PhCHO) के मिश्रण की क्रॉस कैनिज़ारो अभिक्रिया में कौन से उत्पाद बनते हैं? [JEE Advanced PYQ]",
            optionsEn = listOf(
                "Sodium formate (HCOONa) and Benzyl alcohol (PhCH2OH)",
                "Methanol (CH3OH) and Sodium benzoate (PhCOONa)",
                "Cinnamaldehyde via aldol condensation",
                "Benzoin via self-condensation"
            ),
            optionsHi = listOf(
                "सोडियम फॉर्मेट (HCOONa) और बेंजिल अल्कोहल (PhCH2OH)",
                "मेथनॉल (CH3OH) और सोडियम बेंजोएट (PhCOONa)",
                "एल्डोल संघनन द्वारा सिनामैल्डिहाइड",
                "स्व-संघनन द्वारा बेंजोइन"
            ),
            correctIndex = 0,
            explanationEn = "Formaldehyde has the most electrophilic and sterically unhindered carbonyl carbon, so OH- attacks HCHO preferentially, oxidizing it to sodium formate (HCOONa) while transferring hydride (H-) to reduce PhCHO to benzyl alcohol (PhCH2OH).",
            explanationHi = "फॉर्मेल्डिहाइड का कार्बोनिल कार्बन अधिक इलेक्ट्रॉनस्नेही और त्रिविम रूप से कम बाधित होता है, इसलिए HCHO ऑक्सीकृत होकर सोडियम फॉर्मेट (HCOONa) बनाता है और PhCHO अपचयित होकर बेंजिल अल्कोहल (PhCH2OH) देता है।",
            subTopicTag = "Crossed Cannizzaro Mechanism",
            yearTag = "JEE Advanced 2021 Paper-2"
        ),
        RawIitJeePyqSeed(
            questionEn = "When D-glucose is treated with excess phenylhydrazine (3 equivalents), it forms the same yellow crystalline osazone as which of the following pairs of monosaccharides? [JEE Advanced PYQ]",
            questionHi = "जब D-ग्लूकोज की आधिक्य फेनिलहाइड्रेज़ीन (3 तुल्यांक) के साथ अभिक्रिया कराई जाती है, तो यह निम्नलिखित में से मोनोसैकेराइड के किस युग्म के समान पीला क्रिस्टलीय ओसाजोन बनाता है? [JEE Advanced PYQ]",
            optionsEn = listOf(
                "D-Mannose (C-2 epimer) and D-Fructose",
                "D-Galactose (C-4 epimer) and D-Ribose",
                "L-Glucose and D-Galactose",
                "Sucrose and Maltose"
            ),
            optionsHi = listOf(
                "D-मैनोज (C-2 एपिमर) और D-फ्रक्टोज",
                "D-गैलेक्टोज (C-4 एपिमर) और D-राइबोज",
                "L-ग्लूकोज और D-गैलेक्टोज",
                "सुक्रोज और माल्टोज"
            ),
            correctIndex = 0,
            explanationEn = "Osazone formation involves C-1 and C-2, destroying the stereocenter at C-2. Since D-glucose, D-mannose, and D-fructose have identical configurations at C-3, C-4, and C-5, all three yield the exact same glucosazone.",
            explanationHi = "ओसाजोन निर्माण में C-1 और C-2 भाग लेते हैं जिससे C-2 का असममित केंद्र समाप्त हो जाता है। चूंकि D-ग्लूकोज, D-मैनोज और D-फ्रक्टोज का C-3, C-4, C-5 विन्यास समान होता है, वे समान ओसाजोन बनाते हैं।",
            subTopicTag = "Carbohydrates Epimers & Osazone",
            yearTag = "JEE Advanced 2024 Paper-2"
        ),
        RawIitJeePyqSeed(
            questionEn = "4-Bromotoluene when treated with sodamide (NaNH2) in liquid ammonia at 196 K yields a mixture of two isomeric toluidines via which reactive intermediate? [JEE Advanced PYQ]",
            questionHi = "196 K पर द्रव अमोनिया में सोडामाइड (NaNH2) के साथ 4-ब्रोमोटोलूईन की अभिक्रिया कराने पर किस क्रियाशील मध्यवर्ती के माध्यम से दो समावयवी टोलूइडीनों का मिश्रण प्राप्त होता है? [JEE Advanced PYQ]",
            optionsEn = listOf(
                "3,4-Dehydrotoluene (Benzyne / Aryne intermediate via elimination-addition)",
                "Aromatic carbocation via SN1 mechanism",
                "Meisenheimer sigma-complex via SNAr addition-elimination",
                "Free radical intermediate"
            ),
            optionsHi = listOf(
                "3,4-डिहाइड्रोटोलूईन (विलोपन-योग क्रियाविधि द्वारा बेंजाइन मध्यवर्ती)",
                "SN1 क्रियाविधि द्वारा एरोमैटिक कार्बधनायन",
                "SNAr योग-विलोपन द्वारा माइसेनहाइमर संकुल",
                "मुक्त मूलक मध्यवर्ती"
            ),
            correctIndex = 0,
            explanationEn = "Unactivated aryl halides without strong electron-withdrawing groups react with super-strong bases like NaNH2/liq. NH3 via the Benzyne (Elimination-Addition) mechanism, giving both meta-toluidine and para-toluidine.",
            explanationHi = "प्रबल इलेक्ट्रॉन-आकर्षी समूह रहित एरिल हैलाइड द्रव NH3 में NaNH2 के साथ बेंजाइन (विलोपन-योग) क्रियाविधि से अभिक्रिया कर मेटा- और पैरा-टोलूइडीन का मिश्रण देते हैं।",
            subTopicTag = "Benzyne Elimination-Addition Mechanism",
            yearTag = "JEE Advanced 2020 Paper-1"
        ),
        RawIitJeePyqSeed(
            questionEn = "In the Perkin condensation, benzaldehyde is heated with acetic anhydride in the presence of sodium acetate at 453 K followed by acidification. The major product is: [JEE Advanced PYQ]",
            questionHi = "पर्किन संघनन में, 453 K पर सोडियम एसीटेट की उपस्थिति में एसिटिक एनहाइड्राइड के साथ बेंजैल्डिहाइड को गर्म करने और तत्पश्चात अम्लीकरण करने पर मुख्य उत्पाद क्या बनता है? [JEE Advanced PYQ]",
            optionsEn = listOf(
                "trans-Cinnamic acid (Ph-CH=CH-COOH)",
                "Benzoic acid",
                "Acetophenone",
                "Salicylic acid"
            ),
            optionsHi = listOf(
                "ट्रांस-सिनामिक अम्ल (Ph-CH=CH-COOH)",
                "बेंजोइक अम्ल",
                "एसीटोफेनोन",
                "सैलिसिलिक अम्ल"
            ),
            correctIndex = 0,
            explanationEn = "Perkin condensation of an aromatic aldehyde (PhCHO) with an aliphatic acid anhydride ((CH3CO)2O) in the presence of the sodium salt of the acid (CH3COONa) yields an alpha,beta-unsaturated carboxylic acid: trans-cinnamic acid.",
            explanationHi = "पर्किन अभिक्रिया में बेंजैल्डिहाइड की एसिटिक एनहाइड्राइड और सोडियम एसीटेट के साथ क्रिया से अल्फा,बीटा-असंतृप्त अम्ल 'ट्रांस-सिनामिक अम्ल' बनता है।",
            subTopicTag = "Perkin Condensation",
            yearTag = "JEE Advanced 2022 Paper-1"
        )
    )

    val jeeAdvInorganicChemSeeds = listOf(
        RawIitJeePyqSeed(
            questionEn = "In the Brown Ring Test for nitrate (NO3-) ions, freshly prepared FeSO4 solution and concentrated H2SO4 form a brown complex [Fe(H2O)5(NO)]SO4. What is the oxidation state of iron (Fe) and the spin-only magnetic moment of this complex? [JEE Advanced PYQ]",
            questionHi = "नाइट्रेट (NO3-) आयनों के 'ब्राउन रिंग परीक्षण' में ताज़ा बने FeSO4 और सांद्र H2SO4 से भूरा संकुल [Fe(H2O)5(NO)]SO4 बनता है। इस संकुल में आयरन (Fe) की ऑक्सीकरण अवस्था और केवल-प्रचक्रण चुंबकीय आघूर्ण क्या है? [JEE Advanced PYQ]",
            optionsEn = listOf(
                "Fe is in +1 oxidation state (d7 high-spin, 3 unpaired electrons) and mu = 3.87 BM",
                "Fe is in +2 oxidation state and mu = 4.90 BM",
                "Fe is in +3 oxidation state and mu = 5.92 BM",
                "Fe is in 0 oxidation state and diamagnetic"
            ),
            optionsHi = listOf(
                "Fe +1 ऑक्सीकरण अवस्था में है (3 अयुग्मित इलेक्ट्रॉन) और mu = 3.87 BM",
                "Fe +2 ऑक्सीकरण अवस्था में है और mu = 4.90 BM",
                "Fe +3 ऑक्सीकरण अवस्था में है और mu = 5.92 BM",
                "Fe 0 ऑक्सीकरण अवस्था में है और प्रतिचुंबकीय है"
            ),
            correctIndex = 0,
            explanationEn = "In [Fe(H2O)5(NO)]^2+, NO transfers an electron to Fe(II) and coordinates as nitrosonium (NO+), making iron Fe(+1) with 3d7 configuration having 3 unpaired electrons (S = 3/2) and magnetic moment sqrt(3(3+2)) = sqrt(15) = 3.87 BM.",
            explanationHi = "[Fe(H2O)5(NO)]^2+ में NO+ लिगैंड के रूप में जुड़ता है जिससे आयरन की ऑक्सीकरण अवस्था +1 होती है तथा इसमें 3 अयुग्मित इलेक्ट्रॉन होने के कारण चुंबकीय आघूर्ण sqrt(15) = 3.87 BM होता है।",
            subTopicTag = "Qualitative Analysis & Coordination Chemistry",
            yearTag = "JEE Advanced 2023 Paper-1"
        ),
        RawIitJeePyqSeed(
            questionEn = "In diborane (B2H6), what is the hybridization of each Boron atom and the nature of the bridging B-H-B bonds? [JEE Advanced PYQ]",
            questionHi = "डाइबोरेन (B2H6) में प्रत्येक बोरॉन परमाणु का संकरण और सेतु (Bridging) B-H-B आबंधों की प्रकृति क्या है? [JEE Advanced PYQ]",
            optionsEn = listOf(
                "sp3 hybridization; two 3-center-2-electron (3c-2e) banana bonds out of the plane of four terminal B-H bonds",
                "sp2 hybridization; all six B-H bonds are coplanar 2c-2e bonds",
                "sp3d hybridization; two 3-center-4-electron (3c-4e) bonds",
                "sp hybridization; linear molecule with ionic hydrogen bridges"
            ),
            optionsHi = listOf(
                "sp3 संकरण; चार टर्मिनल B-H आबंधों के तल के बाहर दो 3-केंद्र-2-इलेक्ट्रॉन (3c-2e) बनाना आबंध",
                "sp2 संकरण; सभी छह B-H आबंध समतलीय 2c-2e आबंध हैं",
                "sp3d संकरण; दो 3-केंद्र-4-इलेक्ट्रॉन (3c-4e) आबंध",
                "sp संकरण; आयनिक हाइड्रोजन सेतुओं वाला रैखिक अणु"
            ),
            correctIndex = 0,
            explanationEn = "In B2H6, each Boron is sp3 hybridized. Four terminal B-H bonds are regular 2c-2e covalent bonds lying in one plane, while two bridging B-H-B bonds are electron-deficient 3-center-2-electron (3c-2e) banana bonds perpendicular to that plane.",
            explanationHi = "डाइबोरेन (B2H6) में प्रत्येक बोरॉन sp3 संकरित होता है। चार टर्मिनल B-H आबंध एक ही तल में (2c-2e) होते हैं जबकि दो सेतु B-H-B आबंध 3-केंद्र-2-इलेक्ट्रॉन (3c-2e) बनाना आबंध होते हैं।",
            subTopicTag = "p-Block Electron Deficient Hydrides",
            yearTag = "JEE Advanced 2022 Paper-2"
        ),
        RawIitJeePyqSeed(
            questionEn = "Which of the following octahedral complexes can exhibit both geometrical (cis-trans / fac-mer) isomerism and optical isomerism? [JEE Advanced PYQ]",
            questionHi = "निम्नलिखित में से कौन सा अष्टफलकीय संकुल ज्यामितीय समावयवता और प्रकाशिक समावयवता दोनों प्रदर्शित कर सकता है? [JEE Advanced PYQ]",
            optionsEn = listOf(
                "[Co(en)2Cl2]+ (where en = ethane-1,2-diamine)",
                "[Co(NH3)4Cl2]+",
                "[Co(NH3)5Cl]2+",
                "[Cr(H2O)6]3+"
            ),
            optionsHi = listOf(
                "[Co(en)2Cl2]+ (जहाँ en = एथेन-1,2-डाइऐमीन)",
                "[Co(NH3)4Cl2]+",
                "[Co(NH3)5Cl]2+",
                "[Cr(H2O)6]3+"
            ),
            correctIndex = 0,
            explanationEn = "[Co(en)2Cl2]+ of type [M(AA)2b2] exists in cis and trans geometrical isomers. The cis-[Co(en)2Cl2]+ isomer lacks a plane of symmetry (POS) and center of symmetry (COS), so it is optically active and exists as d and l enantiomers (total 3 stereoisomers).",
            explanationHi = "[Co(en)2Cl2]+ ([M(AA)2b2] प्रकार) सिस और ट्रांस ज्यामितीय समावयवी बनाता है। इसका cis-समावयवी असममित होने के कारण प्रकाशिक रूप से सक्रिय (d और l प्रतिबिंब रूप) होता है।",
            subTopicTag = "Stereoisomerism in Coordination Compounds",
            yearTag = "JEE Advanced 2024 Paper-1"
        ),
        RawIitJeePyqSeed(
            questionEn = "During the extraction of silver and gold by the MacArthur-Forrest cyanide process, the native metal is leached with dilute NaCN in the presence of air (O2) followed by displacement with Zinc. The anionic coordination complex of Silver formed during leaching is: [JEE Advanced PYQ]",
            questionHi = "मैकआर्थर-फॉरेस्ट साइनाइड विधि द्वारा चांदी और सोने के निष्कर्षण के दौरान, धातु को वायु (O2) की उपस्थिति में तनु NaCN के साथ निक्षालित किया जाता है। निक्षालन के दौरान बनने वाला सिल्वर का ऋणायनिक संकुल है: [JEE Advanced PYQ]",
            optionsEn = listOf(
                "[Ag(CN)2]- (Linear complex)",
                "[Ag(CN)4]3- (Tetrahedral complex)",
                "[Ag(CN)6]5- (Octahedral complex)",
                "AgCN insoluble precipitate"
            ),
            optionsHi = listOf(
                "[Ag(CN)2]- (रैखिक संकुल)",
                "[Ag(CN)4]3- (चतुष्फलकीय संकुल)",
                "[Ag(CN)6]5- (अष्टफलकीय संकुल)",
                "AgCN अघुलनशील अवक्षेप"
            ),
            correctIndex = 0,
            explanationEn = "4Ag + 8CN- + O2 + 2H2O -> 4[Ag(CN)2]- + 4OH-. Silver forms the soluble linear dicyanoargentate(I) complex [Ag(CN)2]-, from which Ag is precipitated by adding Zn dust (forming [Zn(CN)4]2-).",
            explanationHi = "वायु की उपस्थिति में Ag, NaCN के साथ क्रिया कर घुलनशील रैखिक संकुल [Ag(CN)2]- बनाता है, जिससे बाद में जिंक (Zn) मिलाकर Ag को विस्थापित किया जाता है।",
            subTopicTag = "Metallurgy Hydrometallurgy & Cyanide Process",
            yearTag = "JEE Advanced 2021 Paper-2"
        ),
        RawIitJeePyqSeed(
            questionEn = "Why does the boiling point of HF (293 K) exceed the boiling points of HCl (188 K), HBr (206 K), and HI (238 K), whereas HF is the weakest acid among the hydrogen halides in dilute aqueous solution? [JEE Advanced PYQ]",
            questionHi = "HF का क्वथनांक (293 K) HCl, HBr और HI के क्वथनांकों से अधिक क्यों होता है, जबकि तनु जलीय विलयन में हाइड्रोजन हैलाइडों में HF सबसे दुर्बल अम्ल है? [JEE Advanced PYQ]",
            optionsEn = listOf(
                "Strong intermolecular hydrogen bonding in HF increases its boiling point, while high H-F bond dissociation enthalpy makes it the weakest acid in water",
                "HF has the highest molecular mass among hydrogen halides",
                "F- ion has the lowest hydration enthalpy among halide ions",
                "HF is completely covalent with zero dipole moment"
            ),
            optionsHi = listOf(
                "HF में प्रबल अंतर-आणविक हाइड्रोजन आबंधन इसका क्वथनांक बढ़ाता है, जबकि उच्च H-F आबंध वियोजन एंथैल्पी इसे जल में सबसे दुर्बल अम्ल बनाती है",
                "हाइड्रोजन हैलाइडों में HF का अणुभार सर्वाधिक है",
                "हैलाइड आयनों में F- की जलयोजन एंथैल्पी सबसे कम है",
                "HF शून्य द्विध्रुव आघूर्ण वाला पूर्णतः सहसंयोजक यौगिक है"
            ),
            correctIndex = 0,
            explanationEn = "Extensive zig-zag intermolecular H-bonding (---H-F---H-F---) gives HF an abnormally high boiling point. In water, the very high bond dissociation energy of H-F (574 kJ/mol vs 295 kJ/mol for H-I) prevents complete ionization, making HF a weak acid.",
            explanationHi = "प्रबल अंतर-आणविक हाइड्रोजन आबंधन के कारण HF का क्वथनांक उच्च होता है, तथा उच्च H-F आबंध वियोजन ऊर्जा के कारण जलीय विलयन में यह सबसे दुर्बल अम्ल होता है।",
            subTopicTag = "p-Block Anomalous Behavior of Fluorine",
            yearTag = "JEE Advanced 2023 Paper-2"
        ),
        RawIitJeePyqSeed(
            questionEn = "According to the Jahn-Teller theorem, which high-spin octahedral d-electron configuration in a transition metal complex exhibits the most pronounced tetragonal distortion (unequal axial and equatorial bond lengths)? [JEE Advanced PYQ]",
            questionHi = "जान-टेलर (Jahn-Teller) प्रमेय के अनुसार, संक्रमण धातु संकुल में कौन सा उच्च-प्रचक्रण अष्टफलकीय d-इलेक्ट्रॉन विन्यास सबसे अधिक चतुष्कोणीय विकृति (Tetragonal distortion) प्रदर्शित करता है? [JEE Advanced PYQ]",
            optionsEn = listOf(
                "d9 (e.g., [Cu(H2O)6]2+) and high-spin d4 (e.g., [Cr(H2O)6]2+) with unsymmetrical e_g^3 or e_g^1 occupancy",
                "d3 (t2g^3 e_g^0, e.g., [Cr(H2O)6]3+)",
                "High-spin d5 (t2g^3 e_g^2, e.g., [Mn(H2O)6]2+)",
                "d8 (t2g^6 e_g^2, e.g., [Ni(H2O)6]2+)"
            ),
            optionsHi = listOf(
                "d9 (जैसे [Cu(H2O)6]2+) और उच्च-प्रचक्रण d4 (जैसे [Cr(H2O)6]2+) जिनमें e_g कक्षक असममित रूप से भरे होते हैं",
                "d3 (t2g^3 e_g^0)",
                "उच्च-प्रचक्रण d5 (t2g^3 e_g^2)",
                "d8 (t2g^6 e_g^2)"
            ),
            correctIndex = 0,
            explanationEn = "Strong Jahn-Teller distortion occurs when the sigma-antibonding e_g orbitals (d_z2 and d_x2-y2) are unsymmetrically occupied, i.e., e_g^1 (high-spin d4, low-spin d7) or e_g^3 (d9, like Cu2+ complexes).",
            explanationHi = "जब e_g कक्षक असममित रूप से भरे होते हैं (जैसे e_g^1 या e_g^3, उदाहरणार्थ Cu2+ d9 संकुल), तब प्रबल जान-टेलर चतुष्कोणीय विकृति होती है।",
            subTopicTag = "Jahn-Teller Distortion in CFT",
            yearTag = "JEE Advanced 2024 Paper-2"
        ),
        RawIitJeePyqSeed(
            questionEn = "Disproportionation of white phosphorus (P4) when heated with concentrated aqueous NaOH in an inert atmosphere yields phosphine gas (PH3) and sodium hypophosphite (NaH2PO2). What are the oxidation states of P in P4, PH3, and NaH2PO2 respectively? [JEE Advanced PYQ]",
            questionHi = "अक्रिय वातावरण में सांद्र जलीय NaOH के साथ श्वेत फॉस्फोरस (P4) को गर्म करने पर असमानुपातन द्वारा फॉस्फीन गैस (PH3) और सोडियम हाइपोफॉस्फाइट (NaH2PO2) बनते हैं। P4, PH3 और NaH2PO2 में P की ऑक्सीकरण अवस्थाएं क्रमशः क्या हैं? [JEE Advanced PYQ]",
            optionsEn = listOf("0, -3, and +1", "0, -3, and +3", "0, -3, and +5", "+1, -3, and +5"),
            optionsHi = listOf("0, -3, और +1", "0, -3, और +3", "0, -3, और +5", "+1, -3, और +5"),
            correctIndex = 0,
            explanationEn = "Reaction: P4 + 3NaOH + 3H2O -> PH3 + 3NaH2PO2. Elemental P4 has oxidation state 0; in PH3 it is -3; in H2PO2- (hypophosphite), +1 + 2(+1) + x + 2(-2) = 0 => x = +1.",
            explanationHi = "अभिक्रिया: P4 + 3NaOH + 3H2O -> PH3 + 3NaH2PO2। P4 में ऑक्सीकरण अवस्था 0, PH3 में -3 तथा NaH2PO2 में +1 होती है।",
            subTopicTag = "p-Block Disproportionation of Phosphorus",
            yearTag = "JEE Advanced 2020 Paper-2"
        ),
        RawIitJeePyqSeed(
            questionEn = "The intense purple color of potassium permanganate (KMnO4, where Mn is in +7 oxidation state with 3d0 configuration) is due to: [JEE Advanced PYQ]",
            questionHi = "पोटैशियम परमैंगनेट (KMnO4, जहाँ Mn +7 ऑक्सीकरण अवस्था और 3d0 विन्यास में है) का गहरा बैंगनी रंग किसके कारण होता है? [JEE Advanced PYQ]",
            optionsEn = listOf(
                "Ligand-to-Metal Charge Transfer (LMCT) transition from O(2p) to empty Mn(3d) orbitals",
                "d-d electronic transition within Mn(VII)",
                "Metal-to-Ligand Charge Transfer (MLCT) transition",
                "f-f electronic transition"
            ),
            optionsHi = listOf(
                "O(2p) से रिक्त Mn(3d) कक्षकों में लिगैंड-से-धातु आवेश स्थानांतरण (LMCT) संक्रमण",
                "Mn(VII) के भीतर d-d इलेक्ट्रॉनिक संक्रमण",
                "धातु-से-लिगैंड आवेश स्थानांतरण (MLCT) संक्रमण",
                "f-f इलेक्ट्रॉनिक संक्रमण"
            ),
            correctIndex = 0,
            explanationEn = "In MnO4-, Mn(VII) has a 3d0 configuration (no d electrons, so d-d transitions are impossible). The intense purple color arises from an allowed Ligand-to-Metal Charge Transfer (LMCT) from oxide O^2- (2p) to empty Mn(VII) (3d) orbitals.",
            explanationHi = "MnO4- में Mn(VII) का विन्यास 3d0 होने के कारण d-d संक्रमण संभव नहीं है। इसका गहरा बैंगनी रंग O^2- से रिक्त Mn(3d) कक्षकों में लिगैंड-से-धातु आवेश स्थानांतरण (LMCT) के कारण होता है।",
            subTopicTag = "d-Block Charge Transfer Spectra",
            yearTag = "JEE Advanced 2022 Paper-1"
        )
    )

    val jeeAdvMathematicsSeeds = listOf(
        RawIitJeePyqSeed(
            questionEn = "If the function f: R -> R satisfies the functional equation f(x + y) = f(x) + f(y) + 2xy for all x, y in R, and f'(0) = 3, then the value of f(4) is: [JEE Advanced PYQ]",
            questionHi = "यदि फलन f: R -> R सभी x, y in R के लिए फलनिक समीकरण f(x + y) = f(x) + f(y) + 2xy को संतुष्ट करता है, और f'(0) = 3 है, तो f(4) का मान है: [JEE Advanced PYQ]",
            optionsEn = listOf("28", "24", "16", "32"),
            optionsHi = listOf("28", "24", "16", "32"),
            correctIndex = 0,
            explanationEn = "Putting x = y = 0 gives f(0) = 0. Now f'(x) = lim_(h->0) [f(x + h) - f(x)] / h = lim_(h->0) [f(h) + 2xh] / h = f'(0) + 2x = 3 + 2x. Integrating with f(0) = 0 gives f(x) = x^2 + 3x. Thus f(4) = 16 + 12 = 28.",
            explanationHi = "x = y = 0 रखने पर f(0) = 0। अवकलन की परिभाषा से f'(x) = f'(0) + 2x = 3 + 2x। समाकलन करने पर f(x) = x^2 + 3x। अतः f(4) = 16 + 12 = 28।",
            subTopicTag = "Differential Calculus Functional Equations",
            yearTag = "JEE Advanced 2024 Paper-1"
        ),
        RawIitJeePyqSeed(
            questionEn = "Using Leibniz integral rule, find the value of the limit: lim_(x -> 0) [ (Integral from 0 to x^2 of sin(sqrt(t)) dt) / x^3 ]. [JEE Advanced PYQ]",
            questionHi = "लीबनिज़ समाकलन नियम का उपयोग करते हुए सीमा का मान ज्ञात करें: lim_(x -> 0) [ (0 से x^2 तक sin(sqrt(t)) dt का समाकलन) / x^3 ]। [JEE Advanced PYQ]",
            optionsEn = listOf("2 / 3", "1 / 3", "1", "0"),
            optionsHi = listOf("2 / 3", "1 / 3", "1", "0"),
            correctIndex = 0,
            explanationEn = "It is a 0/0 form. Applying L'Hopital's rule and Leibniz rule to differentiate the numerator with respect to x: d/dx [Integral_0^(x^2) sin(sqrt(t)) dt] = sin(x) * (2x). Dividing by d/dx(x^3) = 3x^2 gives lim_(x->0) [2x sin(x) / (3x^2)] = 2/3.",
            explanationHi = "0/0 रूप में एल-हॉस्पिटल और लीबनिज़ नियम लगाने पर: अंश का अवकलन = sin(x)*(2x) और हर का अवकलन = 3x^2। अतः सीमा = lim_(x->0) [2 sin(x) / (3x)] = 2/3।",
            subTopicTag = "Definite Integration Leibniz Rule",
            yearTag = "JEE Advanced 2023 Paper-1"
        ),
        RawIitJeePyqSeed(
            questionEn = "If omega (where omega != 1) is a complex cube root of unity, then what is the sum of the series S = 1 + 2*omega + 3*omega^2 + ... + 3n*omega^(3n - 1)? [JEE Advanced PYQ]",
            questionHi = "यदि omega (जहाँ omega != 1) इकाई का एक सम्मिश्र घनमूल है, तो श्रेणी S = 1 + 2*omega + 3*omega^2 + ... + 3n*omega^(3n - 1) का योग क्या है? [JEE Advanced PYQ]",
            optionsEn = listOf(
                "3n / (omega - 1)",
                "0",
                "3n * (omega - 1)",
                "n / (1 - omega)"
            ),
            optionsHi = listOf(
                "3n / (omega - 1)",
                "0",
                "3n * (omega - 1)",
                "n / (1 - omega)"
            ),
            correctIndex = 0,
            explanationEn = "For this arithmetico-geometric series, S - omega*S = (1 + omega + omega^2 + ... + omega^(3n-1)) - 3n*omega^(3n). Since omega^3 = 1 and 1 + omega + omega^2 = 0, the sum of 3n powers is 0, and omega^(3n) = 1. Thus (1 - omega)S = -3n => S = 3n / (omega - 1).",
            explanationHi = "S - omega*S = (1 + omega + ... + omega^(3n-1)) - 3n*omega^(3n) = 0 - 3n। अतः S = -3n / (1 - omega) = 3n / (omega - 1)।",
            subTopicTag = "Complex Numbers Roots of Unity",
            yearTag = "JEE Advanced 2022 Paper-2"
        ),
        RawIitJeePyqSeed(
            questionEn = "What is the area of the triangle formed by the tangent at any point P(a*sec(theta), b*tan(theta)) on the hyperbola x^2/a^2 - y^2/b^2 = 1 and its two asymptotes x/a - y/b = 0 and x/a + y/b = 0? [JEE Advanced PYQ]",
            questionHi = "अतिपरवलय x^2/a^2 - y^2/b^2 = 1 के किसी भी बिंदु P पर खींची गई स्पर्श रेखा और इसकी दो अनंतस्पर्शियों (Asymptotes) x/a - y/b = 0 तथा x/a + y/b = 0 द्वारा निर्मित त्रिभुज का क्षेत्रफल क्या है? [JEE Advanced PYQ]",
            optionsEn = listOf(
                "a * b (constant, independent of point P)",
                "2 * a * b",
                "(1 / 2) * a * b",
                "pi * a * b"
            ),
            optionsHi = listOf(
                "a * b (अचर, बिंदु P से स्वतंत्र)",
                "2 * a * b",
                "(1 / 2) * a * b",
                "pi * a * b"
            ),
            correctIndex = 0,
            explanationEn = "The tangent to the hyperbola x^2/a^2 - y^2/b^2 = 1 at any point is bisected at the point of contact by the two asymptotes, and the triangle enclosed by the tangent and the two asymptotes has a constant area equal to a * b.",
            explanationHi = "अतिपरवलय x^2/a^2 - y^2/b^2 = 1 की किसी भी स्पर्श रेखा और उसकी दोनों अनंतस्पर्शियों द्वारा घेरे गए त्रिभुज का क्षेत्रफल सदैव अचर तथा a * b के बराबर होता है।",
            subTopicTag = "Conic Sections Hyperbola Asymptotes",
            yearTag = "JEE Advanced 2024 Paper-2"
        ),
        RawIitJeePyqSeed(
            questionEn = "Let a, b, c be three non-coplanar unit vectors equally inclined to one another at an angle of 60 degrees (pi/3). What is the scalar triple product |[a b c]| (volume of the parallelopiped formed by a, b, c)? [JEE Advanced PYQ]",
            questionHi = "मान लीजिए a, b, c तीन असमतलीय मात्रक सदिश हैं जो एक-दूसरे से 60 डिग्री (pi/3) के कोण पर समान रूप से झुके हैं। अदिश त्रिक गुणनफल |[a b c]| (सदिशों द्वारा बने समांतर षट्फलक का आयतन) क्या है? [JEE Advanced PYQ]",
            optionsEn = listOf("1 / sqrt(2)", "1 / 2", "sqrt(3) / 2", "1 / 4"),
            optionsHi = listOf("1 / sqrt(2)", "1 / 2", "sqrt(3) / 2", "1 / 4"),
            correctIndex = 0,
            explanationEn = "[a b c]^2 = det([[a.a, a.b, a.c], [b.a, b.b, b.c], [c.a, c.b, c.c]]) = det([[1, 1/2, 1/2], [1/2, 1, 1/2], [1/2, 1/2, 1]]) = 1(3/4) - (1/2)(1/4) + (1/2)(-1/4) = 1/2. Thus |[a b c]| = 1 / sqrt(2).",
            explanationHi = "[a b c]^2 = det([[1, 1/2, 1/2], [1/2, 1, 1/2], [1/2, 1/2, 1]]) = 1/2। अतः |[a b c]| = 1 / sqrt(2)।",
            subTopicTag = "Vector Triple Product & 3D Geometry",
            yearTag = "JEE Advanced 2023 Paper-2"
        ),
        RawIitJeePyqSeed(
            questionEn = "Let A be a 2x2 real matrix with trace(A) = 5 and det(A) = 6. Using the Cayley-Hamilton theorem, what is the sum of the eigenvalues of the matrix A^3? [JEE Advanced PYQ]",
            questionHi = "मान लीजिए A एक 2x2 वास्तविक आव्यूह है जिसका अनुरेख trace(A) = 5 और सारणिक det(A) = 6 है। आव्यूह A^3 के आइगेनमानों का योग (trace(A^3)) क्या है? [JEE Advanced PYQ]",
            optionsEn = listOf("35", "125", "19", "27"),
            optionsHi = listOf("35", "125", "19", "27"),
            correctIndex = 0,
            explanationEn = "Characteristic equation of A is lambda^2 - 5*lambda + 6 = 0 => (lambda - 2)(lambda - 3) = 0, so eigenvalues of A are 2 and 3. The eigenvalues of A^3 are 2^3 = 8 and 3^3 = 27. Their sum is 8 + 27 = 35.",
            explanationHi = "अभिलाक्षणिक समीकरण lambda^2 - 5*lambda + 6 = 0 से A के आइगेनमान 2 और 3 हैं। अतः A^3 के आइगेनमान 2^3 = 8 और 3^3 = 27 होंगे जिनका योग 8 + 27 = 35 है।",
            subTopicTag = "Matrices Cayley-Hamilton & Eigenvalues",
            yearTag = "JEE Advanced 2021 Paper-1"
        ),
        RawIitJeePyqSeed(
            questionEn = "An urn contains 5 red and 5 black balls. A ball is drawn at random, its color is noted, and it is returned to the urn along with 2 additional balls of the same color. If another ball is now drawn at random, what is the probability that the second ball is red? [JEE Advanced PYQ]",
            questionHi = "एक कलश में 5 लाल और 5 काली गेंदें हैं। यादृच्छिक रूप से एक गेंद निकाली जाती है, उसका रंग नोट किया जाता है, और उसे उसी रंग की 2 अतिरिक्त गेंदों के साथ कलश में वापस रख दिया जाता है। अब दूसरी गेंद निकालने पर उसके लाल होने की प्रायिकता क्या है? [JEE Advanced PYQ]",
            optionsEn = listOf("1 / 2", "7 / 12", "5 / 12", "2 / 3"),
            optionsHi = listOf("1 / 2", "7 / 12", "5 / 12", "2 / 3"),
            correctIndex = 0,
            explanationEn = "By Law of Total Probability (Polya's Urn symmetry): P(R2) = P(R1)*P(R2|R1) + P(B1)*P(R2|B1) = (5/10)*(7/12) + (5/10)*(5/12) = (1/2) * (12/12) = 1/2.",
            explanationHi = "संपूर्ण प्रायिकता प्रमेय (पोल्या कलश सममिति) से: P(R2) = (5/10)*(7/12) + (5/10)*(5/12) = 1/2।",
            subTopicTag = "Probability Polya Urn & Bayes Theorem",
            yearTag = "JEE Advanced 2023 Paper-1"
        ),
        RawIitJeePyqSeed(
            questionEn = "If y(x) is the solution of the exact differential equation (2xy + y^2) dx + (x^2 + 2xy) dy = 0 with y(1) = 1, then the value of y(2) satisfies: [JEE Advanced PYQ]",
            questionHi = "यदि y(x) यथार्थ अवकल समीकरण (2xy + y^2) dx + (x^2 + 2xy) dy = 0 का हल है जहाँ y(1) = 1 है, तो x = 2 पर y का संबंध संतुष्ट करता है: [JEE Advanced PYQ]",
            optionsEn = listOf(
                "2 * y^2 + 4 * y = 2 (i.e., y^2 + 2y = 1, so y = sqrt(2) - 1)",
                "y = 2",
                "y = 1 / 2",
                "y = sqrt(3)"
            ),
            optionsHi = listOf(
                "2 * y^2 + 4 * y = 2 (अर्थात् y^2 + 2y = 1, अतः y = sqrt(2) - 1)",
                "y = 2",
                "y = 1 / 2",
                "y = sqrt(3)"
            ),
            correctIndex = 0,
            explanationEn = "Note that d(x^2*y + x*y^2) = (2xy + y^2)dx + (x^2 + 2xy)dy = 0. Integrating gives x^2*y + x*y^2 = C. Using y(1) = 1 gives C = 1 + 1 = 2. At x = 2: 4y + 2y^2 = 2 => y^2 + 2y - 1 = 0 => y = sqrt(2) - 1.",
            explanationHi = "d(x^2*y + x*y^2) = 0 का समाकलन करने पर x^2*y + x*y^2 = C। y(1)=1 से C = 2। x = 2 रखने पर 4y + 2y^2 = 2 => y = sqrt(2) - 1।",
            subTopicTag = "Exact Differential Equations",
            yearTag = "JEE Advanced 2022 Paper-1"
        )
    )
}
