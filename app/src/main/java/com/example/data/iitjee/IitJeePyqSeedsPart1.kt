package com.example.data.iitjee

data class RawIitJeePyqSeed(
    val qEn: String,
    val qHi: String,
    val optsEn: List<String>, // Index 0 is the canonical correct answer before deterministic option rotation
    val optsHi: List<String>,
    val expEn: String,
    val expHi: String,
    val yearTag: String,
    val subTopic: String,
    val correctIndex: Int = 0
) {
    constructor(
        questionEn: String,
        questionHi: String,
        optionsEn: List<String>,
        optionsHi: List<String>,
        correctIndex: Int = 0,
        explanationEn: String,
        explanationHi: String,
        subTopicTag: String,
        yearTag: String
    ) : this(
        qEn = questionEn,
        qHi = questionHi,
        optsEn = optionsEn,
        optsHi = optionsHi,
        expEn = explanationEn,
        expHi = explanationHi,
        yearTag = yearTag,
        subTopic = subTopicTag,
        correctIndex = correctIndex
    )

    val questionEn: String get() = qEn
    val questionHi: String get() = qHi
    val optionsEn: List<String> get() = optsEn
    val optionsHi: List<String> get() = optsHi
    val explanationEn: String get() = expEn
    val explanationHi: String get() = expHi
    val subTopicTag: String get() = subTopic
}

/**
 * Authentic Last 5 Years (2020–2025) NTA IIT JEE Main Level Bilingual PYQ Seeds.
 * Covers all 5 Syllabus Subject Branches:
 *  1. Physics (Mechanics, Electrodynamics, Optics, Thermodynamics, Modern Physics)
 *  2. Physical Chemistry (Mole Concept, Atomic Structure, Thermodynamics, Equilibrium, Electrochemistry, Kinetics)
 *  3. Organic Chemistry (GOC, Isomerism, Hydrocarbons, Haloalkanes, Carbonyls, Amines, Biomolecules)
 *  4. Inorganic Chemistry (Periodic Table, Chemical Bonding, Coordination Compounds, d & f Block, p-Block)
 *  5. Mathematics (Calculus, Algebra, Coordinate Geometry, Vectors & 3D, Probability & Trigonometry)
 */
object IitJeePyqSeedsPart1 {

    val jeeMainPhysicsSeeds: List<RawIitJeePyqSeed> = listOf(
        RawIitJeePyqSeed(
            qEn = "A projectile is launched from ground level with initial speed u = 40 m/s at an angle θ = 30° with the horizontal (take g = 10 m/s²). What is the maximum height H attained and the horizontal range R of the projectile?",
            qHi = "एक प्रक्षेप्य को धरातल से क्षैतिज के साथ θ = 30° के कोण पर प्रारंभिक वेग u = 40 m/s से प्रक्षेपित किया जाता है (g = 10 m/s² लें)। प्रक्षेप्य द्वारा प्राप्त अधिकतम ऊँचाई H और क्षैतिज परास R क्या हैं?",
            optsEn = listOf(
                "H = 20 m, R = 80√3 m",
                "H = 40 m, R = 160 m",
                "H = 20√3 m, R = 80 m",
                "H = 10 m, R = 40√3 m"
            ),
            optsHi = listOf(
                "H = 20 m, R = 80√3 m",
                "H = 40 m, R = 160 m",
                "H = 20√3 m, R = 80 m",
                "H = 10 m, R = 40√3 m"
            ),
            expEn = "Maximum height H = (u² sin²θ) / (2g) = (1600 × (1/2)²) / 20 = 400 / 20 = 20 m. Horizontal Range R = (u² sin 2θ) / g = (1600 × sin 60°) / 10 = 160 × (√3/2) = 80√3 m.",
            expHi = "अधिकतम ऊँचाई H = (u² sin²θ) / (2g) = (1600 × 1/4) / 20 = 20 m। क्षैतिज परास R = (u² sin 2θ) / g = (1600 × √3/2) / 10 = 80√3 m।",
            yearTag = "JEE Main 2024 Jan Shift-1 PYQ",
            subTopic = "Kinematics & Projectile Motion"
        ),
        RawIitJeePyqSeed(
            qEn = "A solid sphere of mass M and radius R rolls without slipping down an inclined plane of inclination θ. The acceleration of the center of mass of the solid sphere along the incline is:",
            qHi = "द्रव्यमान M और त्रिज्या R का एक ठोस गोला झुकाव कोण θ वाले नत समतल पर बिना फिसले लुढ़कता (pure rolling) है। नत समतल के अनुदिश ठोस गोले के द्रव्यमान केंद्र का त्वरण क्या है?",
            optsEn = listOf(
                "(5/7) g sin θ",
                "(2/3) g sin θ",
                "(1/2) g sin θ",
                "(3/5) g sin θ"
            ),
            optsHi = listOf(
                "(5/7) g sin θ",
                "(2/3) g sin θ",
                "(1/2) g sin θ",
                "(3/5) g sin θ"
            ),
            expEn = "For pure rolling on an incline, a = g sin θ / (1 + I / MR²). For a solid sphere, I = (2/5)MR², so 1 + I/MR² = 1 + 2/5 = 7/5. Hence a = (5/7) g sin θ.",
            expHi = "नत समतल पर शुद्ध लोटनी गति के लिए त्वरण a = g sin θ / (1 + I / MR²) होता है। ठोस गोले के लिए I = (2/5)MR², अतः a = g sin θ / (1 + 2/5) = (5/7) g sin θ।",
            yearTag = "JEE Main 2023 April Shift-2 PYQ",
            subTopic = "Rotational Motion"
        ),
        RawIitJeePyqSeed(
            qEn = "At what height h above the Earth's surface (radius R) does the acceleration due to gravity become 1/9th of its value on the surface of the Earth?",
            qHi = "पृथ्वी की सतह (त्रिज्या R) से किस ऊँचाई h पर गुरुत्वीय त्वरण (g') का मान पृथ्वी की सतह पर इसके मान का 1/9 भाग हो जाता है?",
            optsEn = listOf(
                "h = 2R",
                "h = 3R",
                "h = 8R",
                "h = R/3"
            ),
            optsHi = listOf(
                "h = 2R",
                "h = 3R",
                "h = 8R",
                "h = R/3"
            ),
            expEn = "g(h) = g / (1 + h/R)². Given g(h) = g/9 => (1 + h/R)² = 9 => 1 + h/R = 3 => h = 2R.",
            expHi = "ऊँचाई h पर गुरुत्वीय त्वरण g(h) = g / (1 + h/R)²। प्रश्नानुसार g(h) = g/9 => 1 + h/R = 3 => h = 2R।",
            yearTag = "JEE Main 2024 April Shift-1 PYQ",
            subTopic = "Gravitation"
        ),
        RawIitJeePyqSeed(
            qEn = "One mole of an ideal monoatomic gas undergoes an adiabatic expansion where its temperature drops from 400 K to 250 K. The work done by the gas is (where R is the universal gas constant):",
            qHi = "एक आदर्श एकपरमाणुक (monoatomic) गैस के 1 मोल का रुद्धोष्म प्रसार (adiabatic expansion) होता है जिसमें इसका तापमान 400 K से घटकर 250 K हो जाता है। गैस द्वारा किया गया कार्य क्या है?",
            optsEn = listOf(
                "225 R",
                "150 R",
                "375 R",
                "300 R"
            ),
            optsHi = listOf(
                "225 R",
                "150 R",
                "375 R",
                "300 R"
            ),
            expEn = "For a monoatomic gas, γ = 5/3 and Cv = (3/2)R. Work done in adiabatic process W = -ΔU = nR(T₁ - T₂) / (γ - 1) = (3/2) × 1 × R × (400 - 250) = 1.5 × 150 R = 225 R.",
            expHi = "एकपरमाणुक गैस के लिए γ = 5/3। रुद्धोष्म प्रक्रम में कार्य W = nR(T₁ - T₂) / (γ - 1) = (3/2)R × (400 - 250) = 225 R।",
            yearTag = "JEE Main 2022 July Shift-1 PYQ",
            subTopic = "Thermodynamics & KTG"
        ),
        RawIitJeePyqSeed(
            qEn = "Two parallel plate capacitors of capacitances C and 2C are charged to potential differences V and 2V respectively, and then connected in parallel with positive plates together. The common potential difference across the combination is:",
            qHi = "धारिता C और 2C के दो समांतर प्लेट संधारित्रों को क्रमशः विभवांतर V और 2V तक आवेशित किया जाता है और फिर धन प्लेटों को एक साथ जोड़ते हुए समांतर क्रम में जोड़ा जाता है। संयोजन का उभयनिष्ठ विभवांतर (Common Potential) क्या है?",
            optsEn = listOf(
                "(5/3) V",
                "(3/2) V",
                "(4/3) V",
                "V"
            ),
            optsHi = listOf(
                "(5/3) V",
                "(3/2) V",
                "(4/3) V",
                "V"
            ),
            expEn = "Total charge Q_total = C₁V₁ + C₂V₂ = CV + (2C)(2V) = 5CV. Total capacitance C_total = C + 2C = 3C. Common potential V_common = Q_total / C_total = 5CV / 3C = (5/3) V.",
            expHi = "कुल आवेश Q = CV + 2C(2V) = 5CV तथा कुल धारिता C_eq = C + 2C = 3C। अतः उभयनिष्ठ विभव V_c = 5CV / 3C = (5/3) V।",
            yearTag = "JEE Main 2023 Jan Shift-1 PYQ",
            subTopic = "Electrostatics & Capacitors"
        ),
        RawIitJeePyqSeed(
            qEn = "In a meter bridge experiment, the null point is obtained at a distance of 40 cm from the left end when a resistor R is in the left gap and S = 15 Ω is in the right gap. The value of unknown resistance R is:",
            qHi = "एक मीटर सेतु (Meter Bridge) प्रयोग में, जब बाएँ अंतराल में प्रतिरोध R और दाएँ अंतराल में S = 15 Ω रखा जाता है, तो संतुलन बिंदु बाएँ सिरे से 40 cm की दूरी पर प्राप्त होता है। अज्ञात प्रतिरोध R का मान क्या है?",
            optsEn = listOf(
                "10 Ω",
                "12 Ω",
                "22.5 Ω",
                "9 Ω"
            ),
            optsHi = listOf(
                "10 Ω",
                "12 Ω",
                "22.5 Ω",
                "9 Ω"
            ),
            expEn = "By Wheatstone balance condition for a meter bridge: R / S = l / (100 - l) => R / 15 = 40 / 60 = 2 / 3 => R = 10 Ω.",
            expHi = "मीटर सेतु संतुलन सूत्र R / S = l / (100 - l) के अनुसार: R / 15 = 40 / 60 = 2/3 => R = 10 Ω।",
            yearTag = "JEE Main 2024 Jan Shift-2 PYQ",
            subTopic = "Current Electricity"
        ),
        RawIitJeePyqSeed(
            qEn = "A circular coil of 50 turns and radius 10 cm carries a current of 2 A. The magnetic field at the center of the circular coil is (μ₀ = 4π × 10⁻⁷ T·m/A):",
            qHi = "50 फेरों और 10 cm त्रिज्या वाली एक वृत्ताकार कुंडली में 2 A की धारा प्रवाहित हो रही है। कुंडली के केंद्र पर चुंबकीय क्षेत्र का परिमाण क्या होगा (μ₀ = 4π × 10⁻⁷ T·m/A)?",
            optsEn = listOf(
                "6.28 × 10⁻⁴ T",
                "3.14 × 10⁻⁴ T",
                "1.25 × 10⁻³ T",
                "4.00 × 10⁻⁴ T"
            ),
            optsHi = listOf(
                "6.28 × 10⁻⁴ T",
                "3.14 × 10⁻⁴ T",
                "1.25 × 10⁻³ T",
                "4.00 × 10⁻⁴ T"
            ),
            expEn = "Magnetic field at the center of a coil B = μ₀ N I / (2R) = (4π × 10⁻⁷ × 50 × 2) / (2 × 0.10) = 2π × 10⁻⁴ T = 6.28 × 10⁻⁴ T.",
            expHi = "वृत्ताकार कुंडली के केंद्र पर चुंबकीय क्षेत्र B = μ₀ N I / (2R) = (4π × 10⁻⁷ × 50 × 2) / 0.20 = 2π × 10⁻⁴ T = 6.28 × 10⁻⁴ T।",
            yearTag = "JEE Main 2021 & 2023 PYQ",
            subTopic = "Moving Charges & Magnetism"
        ),
        RawIitJeePyqSeed(
            qEn = "In a series LCR circuit connected to an AC source of 220 V, 50 Hz, the inductive reactance is XL = 80 Ω, capacitive reactance is XC = 50 Ω, and resistance is R = 40 Ω. The impedance Z and power factor cos φ of the circuit are:",
            qHi = "220 V, 50 Hz के प्रत्यावर्ती धारा स्रोत से जुड़े एक श्रेणी LCR परिपथ में प्रेरणिक प्रतिघात XL = 80 Ω, धारितीय प्रतिघात XC = 50 Ω और प्रतिरोध R = 40 Ω है। परिपथ की प्रतिबाधा Z और शक्ति गुणांक (cos φ) क्या हैं?",
            optsEn = listOf(
                "Z = 50 Ω, cos φ = 0.8",
                "Z = 70 Ω, cos φ = 0.6",
                "Z = 50 Ω, cos φ = 0.6",
                "Z = 40 Ω, cos φ = 1.0"
            ),
            optsHi = listOf(
                "Z = 50 Ω, cos φ = 0.8",
                "Z = 70 Ω, cos φ = 0.6",
                "Z = 50 Ω, cos φ = 0.6",
                "Z = 40 Ω, cos φ = 1.0"
            ),
            expEn = "Impedance Z = √[R² + (XL - XC)²] = √[40² + (80 - 50)²] = √(1600 + 900) = 50 Ω. Power factor cos φ = R / Z = 40 / 50 = 0.8.",
            expHi = "प्रतिबाधा Z = √[R² + (XL - XC)²] = √(40² + 30²) = 50 Ω। शक्ति गुणांक cos φ = R / Z = 40 / 50 = 0.8।",
            yearTag = "JEE Main 2024 April Shift-2 PYQ",
            subTopic = "Alternating Current & EMI"
        ),
        RawIitJeePyqSeed(
            qEn = "In Young's Double Slit Experiment (YDSE), the slit separation is d = 1 mm, screen distance is D = 1 m, and monochromatic light of wavelength λ = 500 nm is used. The fringe width β on the screen is:",
            qHi = "यंग के द्वि-झिरी प्रयोग (YDSE) में स्लिटों के बीच की दूरी d = 1 mm, पर्दे की दूरी D = 1 m और प्रयुक्त एकवर्णी प्रकाश की तरंगदैर्घ्य λ = 500 nm है। पर्दे पर फ्रिंज चौड़ाई (β) क्या होगी?",
            optsEn = listOf(
                "0.5 mm",
                "1.0 mm",
                "0.25 mm",
                "2.0 mm"
            ),
            optsHi = listOf(
                "0.5 mm",
                "1.0 mm",
                "0.25 mm",
                "2.0 mm"
            ),
            expEn = "Fringe width β = λD / d = (500 × 10⁻⁹ m × 1 m) / (1 × 10⁻³ m) = 5 × 10⁻⁴ m = 0.5 mm.",
            expHi = "फ्रिंज चौड़ाई β = λD / d = (500 × 10⁻⁹ × 1) / (10⁻³) = 5 × 10⁻⁴ m = 0.5 mm।",
            yearTag = "JEE Main 2023 Jan Shift-2 PYQ",
            subTopic = "Ray & Wave Optics"
        ),
        RawIitJeePyqSeed(
            qEn = "What is the ratio of the de-Broglie wavelengths of an alpha particle (α) and a proton (p) when both are accelerated from rest through the same potential difference V?",
            qHi = "जब एक अल्फा कण (α) और एक प्रोटॉन (p) दोनों को विरामावस्था से समान विभवांतर V द्वारा त्वरित किया जाता है, तो उनकी डी-ब्रोग्ली तरंगदैर्घ्य (λ_α : λ_p) का अनुपात क्या होगा?",
            optsEn = listOf(
                "1 : 2√2",
                "1 : 2",
                "1 : 4",
                "2√2 : 1"
            ),
            optsHi = listOf(
                "1 : 2√2",
                "1 : 2",
                "1 : 4",
                "2√2 : 1"
            ),
            expEn = "de-Broglie wavelength λ = h / √(2mqV). Since m_α = 4 m_p and q_α = 2 q_p, λ_α / λ_p = √[(m_p q_p) / (4 m_p × 2 q_p)] = 1 / √8 = 1 : 2√2.",
            expHi = "डी-ब्रोग्ली तरंगदैर्घ्य λ = h / √(2mqV)। चूँकि m_α = 4 m_p और q_α = 2 q_p, अतः λ_α / λ_p = 1 / √(4 × 2) = 1 / 2√2।",
            yearTag = "JEE Main 2022 & 2024 PYQ",
            subTopic = "Modern Physics & Dual Nature"
        )
    )

    val jeeMainPhysicalChemSeeds: List<RawIitJeePyqSeed> = listOf(
        RawIitJeePyqSeed(
            qEn = "What is the molarity of pure water at 298 K (density of water = 1.0 g/mL, molar mass of H₂O = 18 g/mol)?",
            qHi = "298 K पर शुद्ध जल की मोलरता (Molarity) क्या होती है (जल का घनत्व = 1.0 g/mL, H₂O का मोलर द्रव्यमान = 18 g/mol)?",
            optsEn = listOf(
                "55.55 M",
                "18.00 M",
                "50.00 M",
                "1.00 M"
            ),
            optsHi = listOf(
                "55.55 M",
                "18.00 M",
                "50.00 M",
                "1.00 M"
            ),
            expEn = "Mass of 1 L (1000 mL) of water = 1000 g. Moles of H₂O in 1 L = 1000 / 18 = 55.55 mol. Hence molarity = 55.55 M.",
            expHi = "1 लीटर (1000 mL) शुद्ध जल का द्रव्यमान = 1000 g। मोलों की संख्या = 1000 / 18 = 55.55 मोल। अतः मोलरता = 55.55 M।",
            yearTag = "JEE Main 2023 Jan PYQ",
            subTopic = "Mole Concept & Stoichiometry"
        ),
        RawIitJeePyqSeed(
            qEn = "According to Bohr's model, the radius of the 2nd excited state (n = 3) of He⁺ ion (Z = 2) in terms of the Bohr radius a₀ is:",
            qHi = "बोर मॉडल के अनुसार, बोर त्रिज्या a₀ के पदों में He⁺ आयन (Z = 2) की दूसरी उत्तेजित अवस्था (2nd excited state, n = 3) की त्रिज्या क्या है?",
            optsEn = listOf(
                "(9/2) a₀",
                "(4/3) a₀",
                "3 a₀",
                "(9/4) a₀"
            ),
            optsHi = listOf(
                "(9/2) a₀",
                "(4/3) a₀",
                "3 a₀",
                "(9/4) a₀"
            ),
            expEn = "2nd excited state corresponds to principal quantum number n = 3. For He⁺, atomic number Z = 2. Radius r_n = a₀ (n² / Z) = a₀ (3² / 2) = (9/2) a₀.",
            expHi = "दूसरी उत्तेजित अवस्था के लिए n = 3 तथा He⁺ के लिए Z = 2 होता है। अतः त्रिज्या r = a₀ (n² / Z) = (9/2) a₀।",
            yearTag = "JEE Main 2024 Jan Shift-1 PYQ",
            subTopic = "Atomic Structure"
        ),
        RawIitJeePyqSeed(
            qEn = "For a chemical reaction at 300 K, ΔH° = -30 kJ/mol and ΔS° = -60 J/(K·mol). What is the standard Gibbs free energy change ΔG° for the reaction at 300 K?",
            qHi = "300 K पर एक रासायनिक अभिक्रिया के लिए ΔH° = -30 kJ/mol और ΔS° = -60 J/(K·mol) है। 300 K पर अभिक्रिया के लिए मानक गिब्स मुक्त ऊर्जा परिवर्तन (ΔG°) क्या है?",
            optsEn = listOf(
                "-12 kJ/mol (Spontaneous)",
                "+12 kJ/mol (Non-spontaneous)",
                "-48 kJ/mol (Spontaneous)",
                "0 kJ/mol (Equilibrium)"
            ),
            optsHi = listOf(
                "-12 kJ/mol (स्वतः प्रवर्तित)",
                "+12 kJ/mol (अस्वतः प्रवर्तित)",
                "-48 kJ/mol (स्वतः प्रवर्तित)",
                "0 kJ/mol (साम्यावस्था)"
            ),
            expEn = "ΔG° = ΔH° - TΔS° = -30 kJ/mol - (300 K × (-0.060 kJ/(K·mol))) = -30 + 18 = -12 kJ/mol. Since ΔG° < 0, the reaction is spontaneous.",
            expHi = "ΔG° = ΔH° - TΔS° = -30 - 300 × (-0.060) = -30 + 18 = -12 kJ/mol। चूँकि ΔG° ऋणात्मक है, अभिक्रिया स्वतः प्रवर्तित (spontaneous) है।",
            yearTag = "JEE Main 2023 April PYQ",
            subTopic = "Chemical Thermodynamics"
        ),
        RawIitJeePyqSeed(
            qEn = "What is the pH of an aqueous buffer solution containing 0.1 M CH₃COOH and 0.1 M CH₃COONa at 298 K, given pKa of acetic acid = 4.74?",
            qHi = "298 K पर 0.1 M CH₃COOH और 0.1 M CH₃COONa युक्त जलीय बफर विलयन का pH मान क्या होगा, यदि एसिटिक अम्ल का pKa = 4.74 है?",
            optsEn = listOf(
                "4.74",
                "5.74",
                "3.74",
                "7.00"
            ),
            optsHi = listOf(
                "4.74",
                "5.74",
                "3.74",
                "7.00"
            ),
            expEn = "By Henderson-Hasselbalch equation: pH = pKa + log([Salt]/[Acid]) = 4.74 + log(0.1 / 0.1) = 4.74 + 0 = 4.74.",
            expHi = "हेंडरसन-हैसेलबाल्क समीकरण के अनुसार: pH = pKa + log([लवण]/[अम्ल]) = 4.74 + log(0.1/0.1) = 4.74।",
            yearTag = "JEE Main 2022 June Shift-2 PYQ",
            subTopic = "Ionic Equilibrium"
        ),
        RawIitJeePyqSeed(
            qEn = "A first-order reaction is 50% complete in 20 minutes. How much time will it take for 87.5% completion of the same reaction?",
            qHi = "एक प्रथम कोटि की अभिक्रिया (First-order reaction) 20 मिनट में 50% पूर्ण होती है। इसी अभिक्रिया के 87.5% पूर्ण होने में कितना समय लगेगा?",
            optsEn = listOf(
                "60 minutes",
                "40 minutes",
                "80 minutes",
                "50 minutes"
            ),
            optsHi = listOf(
                "60 मिनट",
                "40 मिनट",
                "80 मिनट",
                "50 मिनट"
            ),
            expEn = "For a first-order reaction, 87.5% completion leaves 12.5% = (1/2)³ of the reactant unreacted, which takes exactly 3 half-lives: t_87.5% = 3 × t_1/2 = 3 × 20 = 60 minutes.",
            expHi = "प्रथम कोटि की अभिक्रिया में 87.5% पूर्ण होने में अर्ध-आयु (t_1/2) का ठीक 3 गुना समय लगता है: t_87.5% = 3 × t_1/2 = 3 × 20 = 60 मिनट।",
            yearTag = "JEE Main 2024 Jan Shift-2 PYQ",
            subTopic = "Chemical Kinetics"
        ),
        RawIitJeePyqSeed(
            qEn = "For the Daniell cell Zn(s) | Zn²⁺(0.01 M) || Cu²⁺(1.0 M) | Cu(s) at 298 K, if E°_cell = 1.10 V, what is the EMF (E_cell) of the cell (use 2.303 RT/F = 0.059 V)?",
            qHi = "298 K पर डेनियल सेल Zn(s) | Zn²⁺(0.01 M) || Cu²⁺(1.0 M) | Cu(s) के लिए यदि E°_cell = 1.10 V है, तो सेल का विद्युत वाहक बल (E_cell) क्या होगा?",
            optsEn = listOf(
                "1.159 V",
                "1.041 V",
                "1.1295 V",
                "1.100 V"
            ),
            optsHi = listOf(
                "1.159 V",
                "1.041 V",
                "1.1295 V",
                "1.100 V"
            ),
            expEn = "By Nernst equation: E_cell = E°_cell - (0.059 / 2) log([Zn²⁺] / [Cu²⁺]) = 1.10 - 0.0295 × log(10⁻² / 1) = 1.10 - 0.0295 × (-2) = 1.159 V.",
            expHi = "नर्नस्ट समीकरण से: E_cell = E°_cell - (0.059 / 2) log([Zn²⁺]/[Cu²⁺]) = 1.10 - 0.0295 × log(10⁻²) = 1.10 + 0.059 = 1.159 V।",
            yearTag = "JEE Main 2023 April Shift-1 PYQ",
            subTopic = "Electrochemistry"
        ),
        RawIitJeePyqSeed(
            qEn = "Which of the following 0.1 M aqueous solutions will exhibit the highest boiling point at 1 atm pressure (assume complete dissociation of electrolytes)?",
            qHi = "1 atm दाब पर निम्नलिखित में से कौन-सा 0.1 M जलीय विलयन उच्चतम क्वथनांक (highest boiling point) प्रदर्शित करेगा (पूर्ण वियोजन मान लें)?",
            optsEn = listOf(
                "0.1 M Al₂(SO₄)₃ (i = 5)",
                "0.1 M BaCl₂ (i = 3)",
                "0.1 M NaCl (i = 2)",
                "0.1 M Urea (i = 1)"
            ),
            optsHi = listOf(
                "0.1 M Al₂(SO₄)₃ (i = 5)",
                "0.1 M BaCl₂ (i = 3)",
                "0.1 M NaCl (i = 2)",
                "0.1 M यूरिया (i = 1)"
            ),
            expEn = "Elevation in boiling point ΔTb = i · Kb · m. Since Al₂(SO₄)₃ dissociates into 2Al³⁺ + 3SO₄²⁻ giving van't Hoff factor i = 5, it has the highest ΔTb and highest boiling point.",
            expHi = "क्वथनांक में उन्नयन ΔTb = i · Kb · m। Al₂(SO₄)₃ के लिए वांट हॉफ गुणांक i = 5 सर्वाधिक है, इसलिए इसका क्वथनांक उच्चतम होगा।",
            yearTag = "JEE Main 2024 April Shift-1 PYQ",
            subTopic = "Solutions & Colligative Properties"
        )
    )

    val jeeMainOrganicChemSeeds: List<RawIitJeePyqSeed> = listOf(
        RawIitJeePyqSeed(
            qEn = "Arrange the following carbocations in order of increasing stability: (I) (CH₃)₃C⁺, (II) (CH₃)₂CH⁺, (III) CH₃CH₂⁺, (IV) CH₂=CH-CH₂⁺",
            qHi = "निम्नलिखित कार्बधनायनों (carbocations) को उनके स्थायित्व के बढ़ते क्रम में व्यवस्थित कीजिए: (I) (CH₃)₃C⁺, (II) (CH₃)₂CH⁺, (III) CH₃CH₂⁺, (IV) CH₂=CH-CH₂⁺",
            optsEn = listOf(
                "III < II < IV < I",
                "III < IV < II < I",
                "I < IV < II < III",
                "IV < III < II < I"
            ),
            optsHi = listOf(
                "III < II < IV < I",
                "III < IV < II < I",
                "I < IV < II < III",
                "IV < III < II < I"
            ),
            expEn = "(CH₃)₃C⁺ has 9 α-hydrogens (hyperconjugation) and +I effect making it more stable than resonance-stabilized allyl cation CH₂=CH-CH₂⁺, followed by isopropyl (6 α-H) and ethyl (3 α-H): III < II < IV < I.",
            expHi = "(CH₃)₃C⁺ में 9 α-H (अतिसंयुग्मन) के कारण यह सर्वाधिक स्थायी है, इसके बाद अनुनाद-स्थायी एलिल धनायन (IV), फिर आइसोप्रोपिल (II, 6 α-H) और एथिल (III, 3 α-H): III < II < IV < I।",
            yearTag = "JEE Main 2023 Jan Shift-1 PYQ",
            subTopic = "General Organic Chemistry (GOC)"
        ),
        RawIitJeePyqSeed(
            qEn = "Ozonolysis (O₃ followed by Zn/H₂O) of an alkene 'X' (C₄H₈) gives exclusively 2 moles of ethanal (CH₃CHO). The alkene 'X' is:",
            qHi = "एक एल्कीन 'X' (C₄H₈) के ओजोनोलिसिस (O₃ तत्पश्चात Zn/H₂O) से केवल 2 मोल एथेनैल (CH₃CHO) प्राप्त होते हैं। एल्कीन 'X' क्या है?",
            optsEn = listOf(
                "But-2-ene (CH₃-CH=CH-CH₃)",
                "But-1-ene (CH₃-CH₂-CH=CH₂)",
                "2-Methylpropene ((CH₃)₂C=CH₂)",
                "Cyclobutane"
            ),
            optsHi = listOf(
                "ब्यूट-2-ईन (CH₃-CH=CH-CH₃)",
                "ब्यूट-1-ईन (CH₃-CH₂-CH=CH₂)",
                "2-मेथिलप्रोपीन ((CH₃)₂C=CH₂)",
                "साइक्लोब्यूटेन"
            ),
            expEn = "Reductive ozonolysis cleaves the C=C double bond and replaces it with C=O groups. Symmetrical But-2-ene (CH₃-CH=CH-CH₃) yields 2 moles of CH₃CHO.",
            expHi = "अपचयी ओजोनोलिसिस में C=C द्विबंध टूटकर दोनों सिरों पर =O जुड़ता है। सममित ब्यूट-2-ईन (CH₃-CH=CH-CH₃) से 2 मोल एथेनैल (CH₃CHO) बनते हैं।",
            yearTag = "JEE Main 2024 Jan Shift-2 PYQ",
            subTopic = "Hydrocarbons"
        ),
        RawIitJeePyqSeed(
            qEn = "Which of the following alkyl halides undergoes SN1 reaction at the fastest rate in polar protic solvents?",
            qHi = "ध्रुवीय प्रोटिक विलायकों में निम्नलिखित में से कौन-सा एल्किल हैलाइड सबसे तीव्र गति से SN1 अभिक्रिया देता है?",
            optsEn = listOf(
                "(CH₃)₃C-I (tert-Butyl iodide)",
                "(CH₃)₃C-Cl (tert-Butyl chloride)",
                "(CH₃)₂CH-Cl (Isopropyl chloride)",
                "CH₃-CH₂-Cl (Ethyl chloride)"
            ),
            optsHi = listOf(
                "(CH₃)₃C-I (तृतीयक-ब्यूटिल आयोडाइड)",
                "(CH₃)₃C-Cl (तृतीयक-ब्यूटिल क्लोराइड)",
                "(CH₃)₂CH-Cl (आइसोप्रोपिल क्लोराइड)",
                "CH₃-CH₂-Cl (एथिल क्लोराइड)"
            ),
            expEn = "SN1 rate depends on carbocation stability (3° > 2° > 1°) and leaving group ability (I⁻ > Br⁻ > Cl⁻ > F⁻). Hence tert-butyl iodide reacts fastest.",
            expHi = "SN1 अभिक्रिया की दर कार्बधनायन के स्थायित्व (3° > 2° > 1°) और अवशिष्ट समूह की क्षमता (I⁻ > Br⁻ > Cl⁻) पर निर्भर करती है। अतः (CH₃)₃C-I सबसे तीव्र अभिक्रिया करता है।",
            yearTag = "JEE Main 2022 & 2024 PYQ",
            subTopic = "Haloalkanes & Haloarenes"
        ),
        RawIitJeePyqSeed(
            qEn = "When phenol is treated with chloroform (CHCl₃) and aqueous NaOH at 340 K followed by acidification, the major product formed is:",
            qHi = "जब फीनॉल की 340 K पर क्लोरोफॉर्म (CHCl₃) और जलीय NaOH के साथ अभिक्रिया कराकर अम्लीकरण किया जाता है (रीमर-टीमैन अभिक्रिया), तो मुख्य उत्पाद क्या बनता है?",
            optsEn = listOf(
                "Salicylaldehyde (2-Hydroxybenzaldehyde)",
                "Salicylic acid (2-Hydroxybenzoic acid)",
                "4-Hydroxybenzaldehyde",
                "Benzoic acid"
            ),
            optsHi = listOf(
                "सैलिसिलएल्डिहाइड (2-हाइड्रॉक्सीबेंजल्डिहाइड)",
                "सैलिसिलिक अम्ल (2-हाइड्रॉक्सीबेंजोइक अम्ल)",
                "4-हाइड्रॉक्सीबेंजल्डिहाइड",
                "बेंजोइक अम्ल"
            ),
            expEn = "This is the Reimer-Tiemann reaction, where dichlorocarbene (:CCl₂) acts as the electrophile and attacks the ortho-position of phenoxide ion to give Salicylaldehyde (ortho-isomer) as the major product due to intramolecular H-bonding.",
            expHi = "यह रीमर-टीमैन अभिक्रिया है जिसमें डाइक्लोरोकार्बीन (:CCl₂) इलेक्ट्रॉनस्नेही होता है और अंतरा-अणुक H-आबंधन के कारण ऑर्थो-उत्पाद सैलिसिलएल्डिहाइड मुख्य उत्पाद के रूप में बनता है।",
            yearTag = "JEE Main 2023 April Shift-1 PYQ",
            subTopic = "Alcohols, Phenols & Ethers"
        ),
        RawIitJeePyqSeed(
            qEn = "Which of the following carbonyl compounds gives BOTH a positive Tollens' silver mirror test AND a positive Iodoform (I₂/NaOH) test?",
            qHi = "निम्नलिखित में से कौन-सा कार्बोनिल यौगिक टॉलेन रजत दर्पण परीक्षण और आयोडोफॉर्म (I₂/NaOH) परीक्षण दोनों धनात्मक देता है?",
            optsEn = listOf(
                "Ethanal (Acetaldehyde, CH₃CHO)",
                "Methanal (Formaldehyde, HCHO)",
                "Propanone (Acetone, CH₃COCH₃)",
                "Benzaldehyde (C₆H₅CHO)"
            ),
            optsHi = listOf(
                "एथेनैल (एसिटैल्डिहाइड, CH₃CHO)",
                "मेथेनैल (फॉर्मेल्डिहाइड, HCHO)",
                "प्रोपेनोन (एसीटोन, CH₃COCH₃)",
                "बेंजल्डिहाइड (C₆H₅CHO)"
            ),
            expEn = "Ethanal (CH₃CHO) is an aldehyde so it reduces Tollens' reagent, and it also contains the CH₃-C(=O)-H group making it the ONLY aldehyde that gives a yellow precipitate of CHI₃ in the Iodoform test.",
            expHi = "एथेनैल (CH₃CHO) एकमात्र ऐसा एल्डिहाइड है जिसमें CH₃-C=O समूह होता है, इसलिए यह टॉलेन परीक्षण और आयोडोफॉर्म परीक्षण दोनों धनात्मक देता है।",
            yearTag = "JEE Main 2024 Jan Shift-1 PYQ",
            subTopic = "Aldehydes, Ketones & Carboxylic Acids"
        ),
        RawIitJeePyqSeed(
            qEn = "In aqueous solution at 298 K, the correct decreasing order of basic strength of ethyl-substituted amines is:",
            qHi = "298 K पर जलीय विलयन में एथिल-प्रतिस्थापित एमीनों की क्षारीय प्रबलता का सही घटता क्रम क्या है?",
            optsEn = listOf(
                "(C₂H₅)₂NH > (C₂H₅)₃N > C₂H₅NH₂ > NH₃",
                "(C₂H₅)₃N > (C₂H₅)₂NH > C₂H₅NH₂ > NH₃",
                "(C₂H₅)₂NH > C₂H₅NH₂ > (C₂H₅)₃N > NH₃",
                "C₂H₅NH₂ > (C₂H₅)₂NH > (C₂H₅)₃N > NH₃"
            ),
            optsHi = listOf(
                "(C₂H₅)₂NH > (C₂H₅)₃N > C₂H₅NH₂ > NH₃",
                "(C₂H₅)₃N > (C₂H₅)₂NH > C₂H₅NH₂ > NH₃",
                "(C₂H₅)₂NH > C₂H₅NH₂ > (C₂H₅)₃N > NH₃",
                "C₂H₅NH₂ > (C₂H₅)₂NH > (C₂H₅)₃N > NH₃"
            ),
            expEn = "In aqueous medium, due to combined +I inductive effect, solvation (hydration) effect, and steric hindrance, ethyl amines follow the 2° > 3° > 1° > NH₃ order (whereas methyl amines follow 2° > 1° > 3° > NH₃).",
            expHi = "जलीय माध्यम में +I प्रभाव, जलयोजन ऊर्जा और त्रिविम बाधा के संयुक्त प्रभाव से एथिल एमीन की क्षारीयता का क्रम 2° > 3° > 1° > NH₃ होता है।",
            yearTag = "JEE Main 2023 & 2024 PYQ",
            subTopic = "Amines & Biomolecules"
        )
    )

    val jeeMainInorganicChemSeeds: List<RawIitJeePyqSeed> = listOf(
        RawIitJeePyqSeed(
            qEn = "According to VSEPR theory, what are the hybridization of central atom and molecular geometry of XeF₄ and SF₄ respectively?",
            qHi = "VSEPR सिद्धांत के अनुसार, XeF₄ और SF₄ में केंद्रीय परमाणु का संकरण और अणु की ज्यामिति क्रमशः क्या हैं?",
            optsEn = listOf(
                "XeF₄: sp³d² (Square Planar) and SF₄: sp³d (See-Saw)",
                "XeF₄: sp³ (Tetrahedral) and SF₄: sp³d² (Square Planar)",
                "XeF₄: sp³d² (Octahedral) and SF₄: sp³d (Trigonal Bipyramidal)",
                "XeF₄: dsp² (Square Planar) and SF₄: sp³ (Tetrahedral)"
            ),
            optsHi = listOf(
                "XeF₄: sp³d² (वर्ग समतलीय) और SF₄: sp³d (सी-सॉ / ढेंकी)",
                "XeF₄: sp³ (चतुष्फलकीय) और SF₄: sp³d² (वर्ग समतलीय)",
                "XeF₄: sp³d² (अष्टफलकीय) और SF₄: sp³d (त्रिकोणीय द्विपिरैमिडी)",
                "XeF₄: dsp² (वर्ग समतलीय) और SF₄: sp³ (चतुष्फलकीय)"
            ),
            expEn = "XeF₄ has 4 bond pairs + 2 lone pairs = 6 steric number (sp³d², Square Planar). SF₄ has 4 bond pairs + 1 lone pair = 5 steric number (sp³d, See-Saw shape).",
            expHi = "XeF₄ में 4 बंध युग्म + 2 एकाकी युग्म (sp³d², वर्ग समतलीय) होते हैं। SF₄ में 4 बंध युग्म + 1 एकाकी युग्म (sp³d, सी-सॉ ज्यामिति) होते हैं।",
            yearTag = "JEE Main 2024 Jan Shift-1 PYQ",
            subTopic = "Chemical Bonding & Molecular Structure"
        ),
        RawIitJeePyqSeed(
            qEn = "According to Molecular Orbital Theory (MOT), the bond order and magnetic nature of the peroxide ion (O₂²⁻) and superoxide ion (O₂⁻) are respectively:",
            qHi = "आणविक कक्षक सिद्धांत (MOT) के अनुसार, पेरॉक्साइड आयन (O₂²⁻) और सुपरऑक्साइड आयन (O₂⁻) की आबंध कोटि (Bond Order) और चुंबकीय प्रकृति क्रमशः क्या हैं?",
            optsEn = listOf(
                "O₂²⁻: Bond Order 1.0 (Diamagnetic); O₂⁻: Bond Order 1.5 (Paramagnetic)",
                "O₂²⁻: Bond Order 1.5 (Paramagnetic); O₂⁻: Bond Order 1.0 (Diamagnetic)",
                "O₂²⁻: Bond Order 2.0 (Paramagnetic); O₂⁻: Bond Order 1.5 (Paramagnetic)",
                "O₂²⁻: Bond Order 1.0 (Paramagnetic); O₂⁻: Bond Order 2.0 (Diamagnetic)"
            ),
            optsHi = listOf(
                "O₂²⁻: आबंध कोटि 1.0 (प्रतिचुंबकीय); O₂⁻: आबंध कोटि 1.5 (अनुचुंबकीय)",
                "O₂²⁻: आबंध कोटि 1.5 (अनुचुंबकीय); O₂⁻: आबंध कोटि 1.0 (प्रतिचुंबकीय)",
                "O₂²⁻: आबंध कोटि 2.0 (अनुचुंबकीय); O₂⁻: आबंध कोटि 1.5 (अनुचुंबकीय)",
                "O₂²⁻: आबंध कोटि 1.0 (अनुचुंबकीय); O₂⁻: आबंध कोटि 2.0 (प्रतिचुंबकीय)"
            ),
            expEn = "O₂²⁻ (18 electrons) has no unpaired electrons in π*2p orbitals, giving Bond Order = (10 - 8)/2 = 1.0 (Diamagnetic). O₂⁻ (17 electrons) has 1 unpaired electron, giving Bond Order = (10 - 7)/2 = 1.5 (Paramagnetic).",
            expHi = "O₂²⁻ (18 इलेक्ट्रॉन) में सभी इलेक्ट्रॉन युग्मित हैं, आबंध कोटि = 1.0 (प्रतिचुंबकीय)। O₂⁻ (17 इलेक्ट्रॉन) में 1 अयुग्मित इलेक्ट्रॉन है, आबंध कोटि = 1.5 (अनुचुंबकीय)।",
            yearTag = "JEE Main 2023 April Shift-2 PYQ",
            subTopic = "Molecular Orbital Theory"
        ),
        RawIitJeePyqSeed(
            qEn = "What is the spin-only magnetic moment (in Bohr Magnetons, BM) of the complex ion [Fe(H₂O)₆]²⁺ and [Ni(CN)₄]²⁻ respectively (Atomic numbers: Fe = 26, Ni = 28)?",
            qHi = "संकुल आयन [Fe(H₂O)₆]²⁺ और [Ni(CN)₄]²⁻ का प्रचक्रण-मात्र चुंबकीय आघूर्ण (BM में) क्रमशः क्या है (Fe = 26, Ni = 28)?",
            optsEn = listOf(
                "4.90 BM and 0 BM",
                "0 BM and 2.83 BM",
                "5.92 BM and 0 BM",
                "4.90 BM and 2.83 BM"
            ),
            optsHi = listOf(
                "4.90 BM और 0 BM",
                "0 BM और 2.83 BM",
                "5.92 BM और 0 BM",
                "4.90 BM और 2.83 BM"
            ),
            expEn = "In [Fe(H₂O)₆]²⁺, Fe²⁺ is 3d⁶ with weak-field ligand H₂O, having n = 4 unpaired electrons => μ = √(4(4+2)) = √24 = 4.90 BM. In [Ni(CN)₄]²⁻, Ni²⁺ is 3d⁸ with strong-field CN⁻ (dsp² square planar), n = 0 => μ = 0 BM.",
            expHi = "[Fe(H₂O)₆]²⁺ में दुर्बल क्षेत्र लिगैंड H₂O के कारण Fe²⁺ (3d⁶) में 4 अयुग्मित इलेक्ट्रॉन होते हैं (μ = √24 = 4.90 BM)। [Ni(CN)₄]²⁻ में प्रबल लिगैंड CN⁻ के कारण सभी इलेक्ट्रॉन युग्मित होते हैं (μ = 0 BM)।",
            yearTag = "JEE Main 2024 Jan Shift-2 PYQ",
            subTopic = "Coordination Compounds"
        ),
        RawIitJeePyqSeed(
            qEn = "Which of the following is the correct order of first ionization enthalpy (IE₁) for the 2nd period elements Li, Be, B, C, N, O?",
            qHi = "द्वितीय आवर्त के तत्वों Li, Be, B, C, N, O की प्रथम आयनन एन्थैल्पी (IE₁) का सही बढ़ता क्रम कौन-सा है?",
            optsEn = listOf(
                "Li < B < Be < C < O < N",
                "Li < Be < B < C < N < O",
                "Li < B < C < Be < N < O",
                "B < Li < Be < C < O < N"
            ),
            optsHi = listOf(
                "Li < B < Be < C < O < N",
                "Li < Be < B < C < N < O",
                "Li < B < C < Be < N < O",
                "B < Li < Be < C < O < N"
            ),
            expEn = "Be (2s²) has higher IE₁ than B (2s²2p¹) due to fully-filled 2s subshell penetration, and N (2s²2p³) has higher IE₁ than O (2s²2p⁴) due to stable half-filled 2p³ configuration: Li < B < Be < C < O < N.",
            expHi = "पूर्ण पूरित 2s² के कारण Be की आयनन ऊर्जा B से अधिक होती है तथा अर्ध-पूरित 2p³ विन्यास के कारण N की आयनन ऊर्जा O से अधिक होती है: Li < B < Be < C < O < N।",
            yearTag = "JEE Main 2023 & 2024 PYQ",
            subTopic = "Periodic Table & Periodicity"
        ),
        RawIitJeePyqSeed(
            qEn = "Which of the following lanthanoid ions is diamagnetic in nature and acts as a strong reducing agent in aqueous solution?",
            qHi = "निम्नलिखित में से कौन-सा लैंथेनॉइड आयन प्रतिचुंबकीय है अथवा जलीय विलयन में कौन-सा द्विसंयोजी आयन (4f⁷) स्थायी अर्ध-पूरित विन्यास रखता है?",
            optsEn = listOf(
                "Lu³⁺ (4f¹⁴, Diamagnetic) and Eu²⁺ (4f⁷, Strong Reducing Agent)",
                "Ce⁴⁺ (4f¹, Paramagnetic) and Gd³⁺ (4f⁸)",
                "Yb²⁺ (4f¹³, Paramagnetic) and Tb⁴⁺ (4f⁹)",
                "Sm³⁺ (4f⁰, Diamagnetic) and Pr³⁺ (4f⁷)"
            ),
            optsHi = listOf(
                "Lu³⁺ (4f¹⁴, प्रतिचुंबकीय) और Eu²⁺ (4f⁷, प्रबल अपचायक)",
                "Ce⁴⁺ (4f¹, अनुचुंबकीय) और Gd³⁺ (4f⁸)",
                "Yb²⁺ (4f¹³, अनुचुंबकीय) और Tb⁴⁺ (4f⁹)",
                "Sm³⁺ (4f⁰, प्रतिचुंबकीय) और Pr³⁺ (4f⁷)"
            ),
            expEn = "Lu³⁺ has completely filled 4f¹⁴ configuration (0 unpaired electrons, diamagnetic). Eu²⁺ (atomic number 63) has 4f⁷ configuration and readily oxidizes to common +3 state, acting as a strong reducing agent.",
            expHi = "Lu³⁺ का विन्यास 4f¹⁴ (पूर्ण पूरित, प्रतिचुंबकीय) होता है, तथा Eu²⁺ (4f⁷) +3 अवस्था में जाने की प्रवृत्ति के कारण एक प्रबल अपचायक है।",
            yearTag = "JEE Main 2024 April Shift-1 PYQ",
            subTopic = "d and f Block Elements"
        )
    )

    val jeeMainMathematicsSeeds: List<RawIitJeePyqSeed> = listOf(
        RawIitJeePyqSeed(
            qEn = "The value of the definite integral I = ∫₀^(π/2) [√(sin x) / (√(sin x) + √(cos x))] dx is:",
            qHi = "निश्चित समाकलन I = ∫₀^(π/2) [√(sin x) / (√(sin x) + √(cos x))] dx का मान क्या है?",
            optsEn = listOf(
                "π / 4",
                "π / 2",
                "π / 8",
                "1"
            ),
            optsHi = listOf(
                "π / 4",
                "π / 2",
                "π / 8",
                "1"
            ),
            expEn = "Using King's property ∫₀ᵃ f(x)dx = ∫₀ᵃ f(a - x)dx with a = π/2: I = ∫₀^(π/2) [√(cos x) / (√(cos x) + √(sin x))] dx. Adding both equations gives 2I = ∫₀^(π/2) 1 dx = π/2 => I = π/4.",
            expHi = "प्रगुण ∫₀ᵃ f(x)dx = ∫₀ᵃ f(a - x)dx लगाने पर और दोनों समीकरणों को जोड़ने पर 2I = ∫₀^(π/2) 1 dx = π/2 प्राप्त होता है, अतः I = π/4।",
            yearTag = "JEE Main 2023 & 2024 PYQ",
            subTopic = "Integral Calculus"
        ),
        RawIitJeePyqSeed(
            qEn = "Evaluate the limit: lim_(x → 0) [(1 - cos 2x) / x²]:",
            qHi = "सीमा का मान ज्ञात कीजिए: lim_(x → 0) [(1 - cos 2x) / x²]:",
            optsEn = listOf(
                "2",
                "1",
                "4",
                "1/2"
            ),
            optsHi = listOf(
                "2",
                "1",
                "4",
                "1/2"
            ),
            expEn = "Since 1 - cos 2x = 2 sin²x, the limit becomes lim_(x → 0) [2 (sin x / x)²] = 2 × 1² = 2.",
            expHi = "चूँकि 1 - cos 2x = 2 sin²x होता है, अतः lim_(x → 0) [2 (sin x / x)²] = 2 × 1 = 2।",
            yearTag = "JEE Main 2022 & 2024 PYQ",
            subTopic = "Limits, Continuity & Differentiability"
        ),
        RawIitJeePyqSeed(
            qEn = "What is the term independent of x in the binomial expansion of (2x² - 1/x)¹²?",
            qHi = "द्विपद प्रसार (2x² - 1/x)¹² में x से स्वतंत्र पद (term independent of x) क्या है?",
            optsEn = listOf(
                "7920",
                "495",
                "-7920",
                "3960"
            ),
            optsHi = listOf(
                "7920",
                "495",
                "-7920",
                "3960"
            ),
            expEn = "General term T_(r+1) = ¹²C_r (2x²)^(12-r) (-1/x)^r = ¹²C_r 2^(12-r) (-1)^r x^(24 - 3r). For term independent of x, 24 - 3r = 0 => r = 8. Value = ¹²C₈ × 2⁴ × (-1)⁸ = 495 × 16 = 7920.",
            expHi = "व्यापक पद T_(r+1) में x की घात 24 - 3r = 0 रखने पर r = 8 मिलता है। अतः x से स्वतंत्र पद = ¹²C₈ × 2⁴ × (-1)⁸ = 495 × 16 = 7920।",
            yearTag = "JEE Main 2024 Jan Shift-1 PYQ",
            subTopic = "Binomial Theorem & Algebra"
        ),
        RawIitJeePyqSeed(
            qEn = "If A is a 3 × 3 non-singular matrix such that |A| = 5, then the determinant of |adj(A)| is equal to:",
            qHi = "यदि A एक 3 × 3 व्युत्क्रमणीय आव्यूह (non-singular matrix) है जिसके लिए सारणिक |A| = 5 है, तो |adj(A)| का मान क्या होगा?",
            optsEn = listOf(
                "25",
                "125",
                "5",
                "15"
            ),
            optsHi = listOf(
                "25",
                "125",
                "5",
                "15"
            ),
            expEn = "For an n × n matrix A, |adj(A)| = |A|^(n - 1). Here n = 3 and |A| = 5, so |adj(A)| = 5^(3 - 1) = 5² = 25.",
            expHi = "n कोटि के वर्ग आव्यूह के लिए |adj(A)| = |A|^(n-1) होता है। यहाँ n = 3 और |A| = 5 है, अतः |adj(A)| = 5² = 25।",
            yearTag = "JEE Main 2023 April Shift-1 PYQ",
            subTopic = "Matrices & Determinants"
        ),
        RawIitJeePyqSeed(
            qEn = "The area of the region bounded by the parabola y² = 4x and the straight line y = 2x in the first quadrant is:",
            qHi = "प्रथम चतुर्थांश में परवलय y² = 4x और सरल रेखा y = 2x द्वारा परिबद्ध क्षेत्र का क्षेत्रफल क्या है?",
            optsEn = listOf(
                "1/3 sq. units",
                "2/3 sq. units",
                "4/3 sq. units",
                "1/6 sq. units"
            ),
            optsHi = listOf(
                "1/3 वर्ग इकाई",
                "2/3 वर्ग इकाई",
                "4/3 वर्ग इकाई",
                "1/6 वर्ग इकाई"
            ),
            expEn = "Intersection points: (2x)² = 4x => 4x² - 4x = 0 => x = 0, 1. Area = ∫₀¹ (2√x - 2x) dx = [(4/3)x^(3/2) - x²]₀¹ = 4/3 - 1 = 1/3 sq. units (or by shortcut formula 8a² / (3m³) = 8(1)² / (3×8) = 1/3).",
            expHi = "प्रतिच्छेदन बिंदु x = 0 और x = 1 हैं। क्षेत्रफल = ∫₀¹ (2√x - 2x) dx = 4/3 - 1 = 1/3 वर्ग इकाई (शॉर्टकट सूत्र 8a² / 3m³ = 8 / 24 = 1/3)।",
            yearTag = "JEE Main 2024 April Shift-2 PYQ",
            subTopic = "Area Under Curves & Conics"
        ),
        RawIitJeePyqSeed(
            qEn = "If vectors a = 2i - j + 2k and b = i + 2j - 2k are given, then the scalar projection of vector a on vector b is:",
            qHi = "यदि सदिश a = 2i - j + 2k और b = i + 2j - 2k दिए गए हैं, तो सदिश b पर सदिश a का अदिश प्रक्षेप (scalar projection) क्या है?",
            optsEn = listOf(
                "-4 / 3",
                "4 / 3",
                "-2 / 3",
                "0"
            ),
            optsHi = listOf(
                "-4 / 3",
                "4 / 3",
                "-2 / 3",
                "0"
            ),
            expEn = "Dot product a · b = (2)(1) + (-1)(2) + (2)(-2) = 2 - 2 - 4 = -4. Magnitude |b| = √(1² + 2² + (-2)²) = 3. Scalar projection = (a · b) / |b| = -4 / 3.",
            expHi = "अदिश गुणनफल a · b = 2 - 2 - 4 = -4 तथा |b| = √(1 + 4 + 4) = 3। अतः प्रक्षेप = (a · b)/|b| = -4/3।",
            yearTag = "JEE Main 2023 Jan Shift-2 PYQ",
            subTopic = "Vectors & 3D Geometry"
        )
    )
}
