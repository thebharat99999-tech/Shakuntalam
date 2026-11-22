package com.example.data.neet

data class RawNeetPyqSeed(
    val qEn: String,
    val qHi: String,
    val optsEn: List<String>, // Index 0 is the canonical correct answer before deterministic option rotation
    val optsHi: List<String>,
    val expEn: String,
    val expHi: String,
    val yearTag: String,
    val subTopic: String,
    val correctIndex: Int = 0
)

/**
 * Authentic Last 5 Years (2020–2025) NTA NEET (UG) NCERT-Based Bilingual PYQ Seeds (Part 1):
 *  1. Physics (भौतिक विज्ञान — Class 11 & 12 NCERT)
 *  2. Physical Chemistry (भौतिक रसायन — Class 11 & 12 NCERT)
 *  3. Organic Chemistry (कार्बनिक रसायन — Class 11 & 12 NCERT)
 */
object NeetPyqSeedsPart1 {

    // ==================== 1. NEET PHYSICS SEEDS ====================
    val neetPhysicsSeeds: List<RawNeetPyqSeed> = listOf(
        RawNeetPyqSeed(
            qEn = "In a screw gauge, if the pitch is 1 mm and there are 100 divisions on the circular scale, what is the least count (LC) of the screw gauge?",
            qHi = "एक स्क्रू गेज (Screw Gauge) में, यदि चूड़ी अंतराल (Pitch) 1 mm है और वृत्तीय पैमाने पर 100 भाग हैं, तो स्क्रू गेज का अल्पतमांक (Least Count) क्या है?",
            optsEn = listOf("0.01 mm", "0.1 mm", "0.001 mm", "0.02 mm"),
            optsHi = listOf("0.01 mm", "0.1 mm", "0.001 mm", "0.02 mm"),
            expEn = "Least Count (LC) = Pitch / Number of circular scale divisions = 1 mm / 100 = 0.01 mm (or 0.001 cm).",
            expHi = "अल्पतमांक (LC) = चूड़ी अंतराल / वृत्तीय पैमाने पर भागों की संख्या = 1 mm / 100 = 0.01 mm।",
            yearTag = "NEET UG 2024 PYQ",
            subTopic = "Units & Measurements (Screw Gauge & Vernier)"
        ),
        RawNeetPyqSeed(
            qEn = "A car travels the first half of a total distance with speed v₁ = 40 km/h and the second half with speed v₂ = 60 km/h. What is the average speed of the car for the entire journey?",
            qHi = "एक कार कुल दूरी का पहला आधा भाग v₁ = 40 km/h की चाल से और दूसरा आधा भाग v₂ = 60 km/h की चाल से तय करती है। पूरी यात्रा के लिए कार की औसत चाल क्या है?",
            optsEn = listOf("48 km/h", "50 km/h", "45 km/h", "52 km/h"),
            optsHi = listOf("48 km/h", "50 km/h", "45 km/h", "52 km/h"),
            expEn = "For equal distances, harmonic mean applies: v_avg = 2 v₁ v₂ / (v₁ + v₂) = (2 × 40 × 60) / (40 + 60) = 4800 / 100 = 48 km/h.",
            expHi = "समान दूरियों के लिए औसत चाल v_avg = 2 v₁ v₂ / (v₁ + v₂) = (2 × 40 × 60) / 100 = 48 km/h।",
            yearTag = "NEET UG 2023 PYQ",
            subTopic = "Motion in a Straight Line"
        ),
        RawNeetPyqSeed(
            qEn = "A body of mass 2 kg is acted upon by a force F = (3t² i + 4 j) N, where t is in seconds. What is the change in momentum of the body from t = 0 s to t = 2 s?",
            qHi = "2 kg द्रव्यमान के एक पिंड पर बल F = (3t² i + 4 j) N कार्यरत है, जहाँ t सेकंड में है। t = 0 s से t = 2 s तक पिंड के संवेग में परिवर्तन क्या होगा?",
            optsEn = listOf("(8 i + 8 j) N·s", "(12 i + 8 j) N·s", "(6 i + 4 j) N·s", "(4 i + 8 j) N·s"),
            optsHi = listOf("(8 i + 8 j) N·s", "(12 i + 8 j) N·s", "(6 i + 4 j) N·s", "(4 i + 8 j) N·s"),
            expEn = "Impulse Δp = ∫ F dt from 0 to 2 = [t³ i + 4t j]₀² = (8 i + 8 j) N·s.",
            expHi = "संवेग में परिवर्तन Δp = ∫₀² (3t² i + 4 j) dt = [t³ i + 4t j]₀² = (8 i + 8 j) N·s।",
            yearTag = "NEET UG 2024 PYQ",
            subTopic = "Laws of Motion & Impulse"
        ),
        RawNeetPyqSeed(
            qEn = "If the kinetic energy of a particle is increased by 300%, then the percentage increase in its linear momentum will be:",
            qHi = "यदि किसी कण की गतिज ऊर्जा 300% बढ़ा दी जाए, तो उसके रेखीय संवेग में कितने प्रतिशत की वृद्धि होगी?",
            optsEn = listOf("100%", "150%", "200%", "300%"),
            optsHi = listOf("100%", "150%", "200%", "300%"),
            expEn = "New KE K' = K + 3K = 4K. Since p = √(2mK), p' / p = √(K' / K) = √4 = 2. Percentage increase = (2 - 1) × 100% = 100%.",
            expHi = "नई गतिज ऊर्जा K' = K + 3K = 4K। चूंकि p ∝ √K, अतः नया संवेग p' = 2p। प्रतिशत वृद्धि = (2p - p)/p × 100 = 100%।",
            yearTag = "NEET UG 2022 PYQ",
            subTopic = "Work, Energy & Power"
        ),
        RawNeetPyqSeed(
            qEn = "The ratio of the radius of gyration of a thin uniform disc about an axis passing through its centre and normal to its plane to the radius of gyration of the disc about its diameter is:",
            qHi = "एक पतली एकसमान चकती (Disc) के केंद्र से गुजरने वाली तथा उसके तल के लंबवत अक्ष के परितः घूर्णन त्रिज्या और उसके व्यास के परितः घूर्णन त्रिज्या का अनुपात क्या है?",
            optsEn = listOf("√2 : 1", "2 : 1", "1 : √2", "4 : 1"),
            optsHi = listOf("√2 : 1", "2 : 1", "1 : √2", "4 : 1"),
            expEn = "I_normal = ½ MR² ⇒ K₁ = R/√2. By perpendicular axis theorem, I_diameter = ¼ MR² ⇒ K₂ = R/2. Ratio K₁ : K₂ = (R/√2) / (R/2) = √2 : 1.",
            expHi = "I_normal = ½ MR² ⇒ K₁ = R/√2। व्यास के परितः I_diameter = ¼ MR² ⇒ K₂ = R/2। अनुपात K₁ : K₂ = √2 : 1।",
            yearTag = "NEET UG 2022 PYQ",
            subTopic = "System of Particles & Rotational Motion"
        ),
        RawNeetPyqSeed(
            qEn = "A body weighs 72 N on the surface of the Earth. What is the gravitational force on it at a height equal to half the radius of the Earth (h = R/2)?",
            qHi = "पृथ्वी की सतह पर एक पिंड का भार 72 N है। पृथ्वी की त्रिज्या के आधे के बराबर ऊँचाई (h = R/2) पर इस पर लगने वाला गुरुत्वाकर्षण बल क्या होगा?",
            optsEn = listOf("32 N", "36 N", "48 N", "24 N"),
            optsHi = listOf("32 N", "36 N", "48 N", "24 N"),
            expEn = "g' = g / (1 + h/R)² = g / (1 + 1/2)² = g / (3/2)² = (4/9) g. Weight W' = (4/9) × 72 N = 32 N.",
            expHi = "g' = g / (1 + h/R)² = (4/9) g। अतः ऊँचाई h = R/2 पर भार W' = (4/9) × 72 = 32 N।",
            yearTag = "NEET UG 2020 PYQ",
            subTopic = "Gravitation"
        ),
        RawNeetPyqSeed(
            qEn = "A Carnot engine operates between a source at 327°C and a sink at 27°C. If it absorbs 600 J of heat per cycle from the source, the work done per cycle is:",
            qHi = "एक कार्नो इंजन 327°C के स्रोत और 27°C के सिंक के बीच कार्य करता है। यदि यह प्रति चक्र स्रोत से 600 J ऊष्मा अवशोषित करता है, तो प्रति चक्र किया गया कार्य है:",
            optsEn = listOf("300 J", "400 J", "200 J", "150 J"),
            optsHi = listOf("300 J", "400 J", "200 J", "150 J"),
            expEn = "T₁ = 327 + 273 = 600 K, T₂ = 27 + 273 = 300 K. Efficiency η = 1 - T₂/T₁ = 1 - 300/600 = 0.5. Work W = η × Q₁ = 0.5 × 600 J = 300 J.",
            expHi = "T₁ = 600 K, T₂ = 300 K। दक्षता η = 1 - 300/600 = 1/2। प्रति चक्र किया गया कार्य W = η × Q₁ = 0.5 × 600 = 300 J।",
            yearTag = "NEET UG 2023 PYQ",
            subTopic = "Thermodynamics & Heat Engines"
        ),
        RawNeetPyqSeed(
            qEn = "An electric dipole with dipole moment 4 × 10⁻⁹ C·m is aligned at 30° with the direction of a uniform electric field of magnitude 5 × 10⁴ N/C. Calculate the magnitude of torque acting on the dipole:",
            qHi = "4 × 10⁻⁹ C·m द्विध्रुव आघूर्ण वाला एक वैद्युत द्विध्रुव 5 × 10⁴ N/C परिमाण के एकसमान विद्युत क्षेत्र की दिशा से 30° पर संरेखित है। द्विध्रुव पर कार्यरत बल आघूर्ण (Torque) का परिमाण है:",
            optsEn = listOf("10⁻⁴ N·m", "2 × 10⁻⁴ N·m", "10⁻⁵ N·m", "5 × 10⁻⁵ N·m"),
            optsHi = listOf("10⁻⁴ N·m", "2 × 10⁻⁴ N·m", "10⁻⁵ N·m", "5 × 10⁻⁵ N·m"),
            expEn = "Torque τ = p E sin θ = (4 × 10⁻⁹) × (5 × 10⁴) × sin 30° = 20 × 10⁻⁵ × (1/2) = 10⁻⁴ N·m.",
            expHi = "बल आघूर्ण τ = p E sin 30° = (4 × 10⁻⁹) × (5 × 10⁴) × 0.5 = 10⁻⁴ N·m।",
            yearTag = "NEET UG 2023 PYQ",
            subTopic = "Electrostatics & Electric Dipole"
        ),
        RawNeetPyqSeed(
            qEn = "Two capacitors of capacitances 3 μF and 6 μF are connected in series across a 12 V battery. What is the potential difference across the 3 μF capacitor?",
            qHi = "3 μF और 6 μF धारिता के दो संधारित्र 12 V की बैटरी के साथ श्रेणीक्रम में जुड़े हैं। 3 μF संधारित्र के सिरों पर विभवांतर क्या है?",
            optsEn = listOf("8 V", "4 V", "6 V", "9 V"),
            optsHi = listOf("8 V", "4 V", "6 V", "9 V"),
            expEn = "C_eq = (3 × 6)/(3 + 6) = 2 μF. Charge Q = C_eq × V = 2 μF × 12 V = 24 μC. Potential across 3 μF is V₁ = Q / C₁ = 24 μC / 3 μF = 8 V.",
            expHi = "तुल्य धारिता C_eq = 2 μF। आवेश Q = 2 × 12 = 24 μC। 3 μF संधारित्र पर विभवांतर V₁ = Q / C₁ = 24 / 3 = 8 V।",
            yearTag = "NEET UG 2024 PYQ",
            subTopic = "Electrostatic Potential & Capacitance"
        ),
        RawNeetPyqSeed(
            qEn = "A wire of resistance R is stretched uniformly so that its length becomes twice its original length (2L). What will be its new electrical resistance?",
            qHi = "प्रतिरोध R के एक तार को एकसमान रूप से खींचा जाता है ताकि इसकी लंबाई मूल लंबाई की दोगुनी (2L) हो जाए। इसका नया विद्युत प्रतिरोध क्या होगा?",
            optsEn = listOf("4 R", "2 R", "8 R", "R / 2"),
            optsHi = listOf("4 R", "2 R", "8 R", "R / 2"),
            expEn = "Volume V = A × L remains constant, so A' = A/2 when L' = 2L. Thus R' = ρ L'/A' = ρ (2L)/(A/2) = 4 (ρL/A) = 4R.",
            expHi = "आयतन नियत रहने पर लंबाई n गुना करने से नया प्रतिरोध R' = n² R = 2² R = 4R हो जाता है।",
            yearTag = "NEET UG 2023 PYQ",
            subTopic = "Current Electricity"
        ),
        RawNeetPyqSeed(
            qEn = "A long straight wire carries a current of 35 A. What is the magnitude of the magnetic field B at a point 20 cm from the wire? (μ₀ = 4π × 10⁻⁷ T·m/A)",
            qHi = "एक लंबे सीधे तार में 35 A की धारा प्रवाहित हो रही है। तार से 20 cm की दूरी पर स्थित बिंदु पर चुंबकीय क्षेत्र B का परिमाण क्या है?",
            optsEn = listOf("3.5 × 10⁻⁵ T", "7.0 × 10⁻⁵ T", "1.75 × 10⁻⁵ T", "3.5 × 10⁻⁴ T"),
            optsHi = listOf("3.5 × 10⁻⁵ T", "7.0 × 10⁻⁵ T", "1.75 × 10⁻⁵ T", "3.5 × 10⁻⁴ T"),
            expEn = "B = (μ₀ I) / (2π r) = (2 × 10⁻⁷ × 35) / 0.20 = 70 × 10⁻⁷ / 0.20 = 3.5 × 10⁻⁵ T.",
            expHi = "चुंबकीय क्षेत्र B = (μ₀ I) / (2π r) = (2 × 10⁻⁷ × 35) / 0.20 = 3.5 × 10⁻⁵ T।",
            yearTag = "NEET UG 2022 PYQ",
            subTopic = "Moving Charges & Magnetism"
        ),
        RawNeetPyqSeed(
            qEn = "In a series LCR circuit at resonance, the phase difference between the alternating current (I) and the applied alternating voltage (V) is:",
            qHi = "अनुनाद (Resonance) की स्थिति में श्रेणी LCR परिपथ में प्रत्यावर्ती धारा (I) और आरोपित प्रत्यावर्ती वोल्टेज (V) के बीच कलांतर (Phase Difference) होता है:",
            optsEn = listOf("0 rad (Zero)", "π / 2 rad", "π / 4 rad", "π rad"),
            optsHi = listOf("0 rad (शून्य)", "π / 2 rad", "π / 4 rad", "π rad"),
            expEn = "At resonance, inductive reactance X_L equals capacitive reactance X_C, so impedance Z = R (purely resistive) and phase angle φ = tan⁻¹((X_L - X_C)/R) = 0.",
            expHi = "अनुनाद पर X_L = X_C होता है, जिससे प्रतिबाधा Z = R (शुद्ध प्रतिरोधक) होती है और धारा व वोल्टेज के बीच कलांतर φ = 0 होता है।",
            yearTag = "NEET UG 2024 PYQ",
            subTopic = "Alternating Current (LCR Resonance)"
        ),
        RawNeetPyqSeed(
            qEn = "A biconvex lens of glass (refractive index n = 1.5) has both radii of curvature equal to 20 cm. What is the focal length and power of the lens in air?",
            qHi = "कांच (अपवर्तनांक n = 1.5) के एक द्वि-उत्तल लेंस की दोनों वक्रता त्रिज्याएं 20 cm के बराबर हैं। वायु में लेंस की फोकस दूरी और क्षमता (Power) क्या है?",
            optsEn = listOf("f = +20 cm, P = +5 D", "f = +10 cm, P = +10 D", "f = +40 cm, P = +2.5 D", "f = -20 cm, P = -5 D"),
            optsHi = listOf("f = +20 cm, P = +5 D", "f = +10 cm, P = +10 D", "f = +40 cm, P = +2.5 D", "f = -20 cm, P = -5 D"),
            expEn = "By Lens Maker's formula: 1/f = (n - 1)(1/R₁ - 1/R₂) = (1.5 - 1)(1/20 - (-1/20)) = 0.5 × (2/20) = 1/20 cm⁻¹ ⇒ f = +20 cm = +0.2 m. Power P = 1/0.2 = +5 D.",
            expHi = "लेंस निर्माता सूत्र से: 1/f = (1.5 - 1)(2/20) = 1/20 ⇒ f = +20 cm (+0.2 m)। लेंस की क्षमता P = 1/f(m) = +5 D।",
            yearTag = "NEET UG 2023 PYQ",
            subTopic = "Ray Optics & Optical Instruments"
        ),
        RawNeetPyqSeed(
            qEn = "In Young's double-slit experiment, if the separation between the slits is halved and the distance between the slits and the screen is doubled, the fringe width (β) becomes:",
            qHi = "यंग के द्वि-झिरी प्रयोग (YDSE) में, यदि झिरियों के बीच की दूरी आधी कर दी जाए और झिरियों तथा पर्दे के बीच की दूरी दोगुनी कर दी जाए, तो फ्रिंज चौड़ाई (β) हो जाती है:",
            optsEn = listOf("4 times the original", "2 times the original", "Half the original", "Unchanged"),
            optsHi = listOf("मूल की 4 गुनी", "मूल की 2 गुनी", "मूल की आधी", "अपरीवर्तित"),
            expEn = "Fringe width β = λD / d. When D' = 2D and d' = d/2, β' = λ(2D) / (d/2) = 4 (λD / d) = 4β.",
            expHi = "फ्रिंज चौड़ाई β = λD / d। जब D' = 2D और d' = d/2, तब नई फ्रिंज चौड़ाई β' = 4β (चार गुनी) हो जाती है।",
            yearTag = "NEET UG 2022 PYQ",
            subTopic = "Wave Optics (YDSE)"
        ),
        RawNeetPyqSeed(
            qEn = "The work function of caesium is 2.14 eV. When light of photon energy 3.00 eV is incident on the metal surface, the maximum kinetic energy of the emitted photoelectrons is:",
            qHi = "सीज़ियम का कार्य फलन (Work Function) 2.14 eV है। जब धातु की सतह पर 3.00 eV फोटॉन ऊर्जा का प्रकाश आपतित होता है, तो उत्सर्जित फोटोइलेक्ट्रॉनों की अधिकतम गतिज ऊर्जा होती है:",
            optsEn = listOf("0.86 eV", "5.14 eV", "2.14 eV", "1.40 eV"),
            optsHi = listOf("0.86 eV", "5.14 eV", "2.14 eV", "1.40 eV"),
            expEn = "By Einstein's photoelectric equation: K_max = hν - φ₀ = 3.00 eV - 2.14 eV = 0.86 eV.",
            expHi = "आइंस्टीन के प्रकाश-विद्युत समीकरण से: K_max = E - φ₀ = 3.00 eV - 2.14 eV = 0.86 eV।",
            yearTag = "NEET UG 2024 PYQ",
            subTopic = "Dual Nature of Radiation & Matter"
        ),
        RawNeetPyqSeed(
            qEn = "According to Bohr's model of the hydrogen atom, the radius of the n-th permitted orbit is proportional to:",
            qHi = "हाइड्रोजन परमाणु के बोर मॉडल के अनुसार, n-वीं अनुमत कक्षा की त्रिज्या किसके समानुपाती होती है?",
            optsEn = listOf("n²", "1 / n²", "n", "1 / n"),
            optsHi = listOf("n²", "1 / n²", "n", "1 / n"),
            expEn = "In Bohr's model for hydrogen (Z = 1), radius r_n = 0.529 × n² Å, so r_n ∝ n².",
            expHi = "बोर के परमाणु मॉडल में n-वीं कक्षा की त्रिज्या r_n = 0.529 × n² / Z Å होती है, अतः r_n ∝ n²।",
            yearTag = "NEET UG 2023 PYQ",
            subTopic = "Atoms & Nuclei"
        ),
        RawNeetPyqSeed(
            qEn = "Which of the following logic gates is known as a 'Universal Gate' because any Boolean function can be implemented using it alone?",
            qHi = "निम्नलिखित में से किस लॉजिक गेट को 'सार्वत्रिक गेट' (Universal Gate) कहा जाता है क्योंकि केवल इसके उपयोग से कोई भी बूलियन फलन प्राप्त किया जा सकता है?",
            optsEn = listOf("NAND gate (and NOR gate)", "AND gate only", "OR gate only", "XOR gate only"),
            optsHi = listOf("NAND गेट (तथा NOR गेट)", "केवल AND गेट", "केवल OR गेट", "केवल XOR गेट"),
            expEn = "NAND and NOR gates are universal logic gates because NOT, AND, and OR operations can all be constructed exclusively from NAND or NOR gates.",
            expHi = "NAND और NOR गेट को सार्वत्रिक (Universal) गेट कहा जाता है क्योंकि इनसे सभी मूल गेट (NOT, AND, OR) बनाए जा सकते हैं।",
            yearTag = "NEET UG 2024 PYQ",
            subTopic = "Semiconductor Electronics & Logic Gates"
        )
    )

    // ==================== 2. NEET PHYSICAL CHEMISTRY SEEDS ====================
    val neetPhysicalChemSeeds: List<RawNeetPyqSeed> = listOf(
        RawNeetPyqSeed(
            qEn = "Which of the following contains the maximum number of atoms?",
            qHi = "निम्नलिखित में से किसमें परमाणुओं की संख्या अधिकतम है?",
            optsEn = listOf("1 g of H₂(g) [Molar mass = 2 g/mol]", "1 g of O₂(g) [Molar mass = 32 g/mol]", "1 g of N₂(g) [Molar mass = 28 g/mol]", "1 g of Ag(s) [Atomic mass = 108 u]"),
            optsHi = listOf("1 g H₂(g) [मोलर द्रव्यमान = 2 g/mol]", "1 g O₂(g) [मोलर द्रव्यमान = 32 g/mol]", "1 g N₂(g) [मोलर द्रव्यमान = 28 g/mol]", "1 g Ag(s) [परमाणु द्रव्यमान = 108 u]"),
            expEn = "Number of atoms = (mass / molar mass) × atomicity × N_A. For 1 g H₂: (1/2) × 2 × N_A = 1.0 N_A, which is the highest among all options.",
            expHi = "1 g H₂ में परमाणुओं की संख्या = (1/2) × 2 × N_A = N_A, जो दिए गए सभी विकल्पों में सर्वाधिक है।",
            yearTag = "NEET UG 2024 PYQ",
            subTopic = "Some Basic Concepts of Chemistry (Mole Concept)"
        ),
        RawNeetPyqSeed(
            qEn = "What is the maximum number of orbitals that can be identified with the quantum numbers n = 3, l = 1, and m_l = 0?",
            qHi = "क्वांटम संख्याओं n = 3, l = 1 और m_l = 0 द्वारा पहचाने जा सकने वाले कक्षकों (Orbitals) की अधिकतम संख्या क्या है?",
            optsEn = listOf("1", "3", "2", "6"),
            optsHi = listOf("1", "3", "2", "6"),
            expEn = "A specific set of three quantum numbers (n = 3, l = 1, m_l = 0) uniquely specifies a single orbital (namely 3p_z), which can hold up to 2 electrons.",
            expHi = "तीन क्वांटम संख्याओं (n = 3, l = 1, m_l = 0) का एक विशिष्ट सेट केवल 1 कक्षक (3p_z) को निरूपित करता है।",
            yearTag = "NEET UG 2022 PYQ",
            subTopic = "Structure of Atom (Quantum Numbers)"
        ),
        RawNeetPyqSeed(
            qEn = "For a chemical reaction at 300 K, ΔH = -30 kJ/mol and ΔS = -100 J/(K·mol). At what temperature will the reaction be at equilibrium (ΔG = 0)?",
            qHi = "एक रासायनिक अभिक्रिया के लिए ΔH = -30 kJ/mol और ΔS = -100 J/(K·mol) है। किस तापमान पर अभिक्रिया साम्यावस्था (ΔG = 0) में होगी?",
            optsEn = listOf("300 K", "273 K", "400 K", "350 K"),
            optsHi = listOf("300 K", "273 K", "400 K", "350 K"),
            expEn = "At equilibrium, ΔG = ΔH - TΔS = 0 ⇒ T = ΔH / ΔS = (-30,000 J/mol) / (-100 J/(K·mol)) = 300 K.",
            expHi = "साम्यावस्था पर ΔG = 0 ⇒ T = ΔH / ΔS = (-30,000) / (-100) = 300 K।",
            yearTag = "NEET UG 2023 PYQ",
            subTopic = "Chemical Thermodynamics (Gibbs Free Energy)"
        ),
        RawNeetPyqSeed(
            qEn = "For which of the following gaseous equilibria is K_p equal to K_c (i.e., Δn_g = 0)?",
            qHi = "निम्नलिखित में से किस गैसीय साम्य के लिए K_p का मान K_c के बराबर (अर्थात Δn_g = 0) होता है?",
            optsEn = listOf("H₂(g) + I₂(g) ⇌ 2HI(g)", "N₂(g) + 3H₂(g) ⇌ 2NH₃(g)", "PCl₅(g) ⇌ PCl₃(g) + Cl₂(g)", "2SO₂(g) + O₂(g) ⇌ 2SO₃(g)"),
            optsHi = listOf("H₂(g) + I₂(g) ⇌ 2HI(g)", "N₂(g) + 3H₂(g) ⇌ 2NH₃(g)", "PCl₅(g) ⇌ PCl₃(g) + Cl₂(g)", "2SO₂(g) + O₂(g) ⇌ 2SO₃(g)"),
            expEn = "K_p = K_c (RT)^(Δn_g). For H₂(g) + I₂(g) ⇌ 2HI(g), Δn_g = 2 - (1 + 1) = 0, so K_p = K_c.",
            expHi = "H₂(g) + I₂(g) ⇌ 2HI(g) के लिए गैसीय मोलों में परिवर्तन Δn_g = 2 - 2 = 0 है, अतः K_p = K_c।",
            yearTag = "NEET UG 2024 PYQ",
            subTopic = "Chemical Equilibrium"
        ),
        RawNeetPyqSeed(
            qEn = "If the solubility of AgCl in water at 25°C is s mol/L, and the solubility product of PbCl₂ is 4s'³, what is the solubility product (K_sp) expression for zirconium phosphate Zr₃(PO₄)₄ in terms of its molar solubility S?",
            qHi = "ज़िरकोनियम फॉस्फेट Zr₃(PO₄)₄ के मोलर विलेयता S के पदों में इसके विलेयता गुणनफल (K_sp) का व्यंजक क्या है?",
            optsEn = listOf("6912 S⁷", "108 S⁵", "27 S⁴", "256 S⁷"),
            optsHi = listOf("6912 S⁷", "108 S⁵", "27 S⁴", "256 S⁷"),
            expEn = "Zr₃(PO₄)₄ ⇌ 3 Zr⁴⁺ (3S) + 4 PO₄³⁻ (4S). K_sp = (3S)³ × (4S)⁴ = 27 S³ × 256 S⁴ = 6912 S⁷.",
            expHi = "Zr₃(PO₄)₄ ⇌ 3 Zr⁴⁺ + 4 PO₄³⁻। अतः K_sp = (3S)³ × (4S)⁴ = 27 × 256 × S⁷ = 6912 S⁷।",
            yearTag = "NEET UG 2021 PYQ",
            subTopic = "Ionic Equilibrium (Solubility Product)"
        ),
        RawNeetPyqSeed(
            qEn = "Which of the following 0.1 M aqueous solutions will exhibit the highest boiling point (assuming complete dissociation of electrolytes)?",
            qHi = "निम्नलिखित 0.1 M जलीय विलयनों में से किसका क्वथनांक (Boiling Point) उच्चतम होगा (विद्युत-अपघट्यों का पूर्ण वियोजन मानते हुए)?",
            optsEn = listOf("0.1 M Al₂(SO₄)₃ (i = 5)", "0.1 M BaCl₂ (i = 3)", "0.1 M NaCl (i = 2)", "0.1 M Urea (i = 1)"),
            optsHi = listOf("0.1 M Al₂(SO₄)₃ (i = 5)", "0.1 M BaCl₂ (i = 3)", "0.1 M NaCl (i = 2)", "0.1 M यूरिया (i = 1)"),
            expEn = "Boiling point elevation ΔT_b = i · K_b · m. Al₂(SO₄)₃ dissociates into 2 Al³⁺ + 3 SO₄²⁻ (van't Hoff factor i = 5), giving the largest ΔT_b and highest boiling point.",
            expHi = "क्वथनांक में उन्नयन ΔT_b ∝ वांट हॉफ गुणांक (i)। Al₂(SO₄)₃ के लिए i = 5 सर्वाधिक है, इसलिए इसका क्वथनांक उच्चतम होगा।",
            yearTag = "NEET UG 2023 PYQ",
            subTopic = "Solutions & Colligative Properties"
        ),
        RawNeetPyqSeed(
            qEn = "For the Daniell cell Zn(s) | Zn²⁺(0.01 M) || Cu²⁺(1.0 M) | Cu(s) with E°_cell = 1.10 V at 298 K, the EMF of the cell is approximately:",
            qHi = "डेनियल सेल Zn(s) | Zn²⁺(0.01 M) || Cu²⁺(1.0 M) | Cu(s) (जिसका 298 K पर E°_cell = 1.10 V है) का विद्युत वाहक बल (EMF) लगभग कितना होगा?",
            optsEn = listOf("1.159 V", "1.041 V", "1.100 V", "1.218 V"),
            optsHi = listOf("1.159 V", "1.041 V", "1.100 V", "1.218 V"),
            expEn = "By Nernst equation (n = 2): E_cell = E°_cell - (0.0591/2) log([Zn²⁺]/[Cu²⁺]) = 1.10 - 0.02955 log(10⁻²) = 1.10 + 0.0591 = 1.159 V.",
            expHi = "नर्नस्ट समीकरण (n = 2) से: E_cell = 1.10 - (0.0591/2) log(0.01 / 1.0) = 1.10 + 0.0591 = 1.159 V।",
            yearTag = "NEET UG 2024 PYQ",
            subTopic = "Electrochemistry (Nernst Equation)"
        ),
        RawNeetPyqSeed(
            qEn = "How many Faradays of electricity are required to reduce 1 mole of MnO₄⁻ ions to Mn²⁺ ions in acidic medium?",
            qHi = "अम्लीय माध्यम में 1 मोल MnO₄⁻ आयनों को Mn²⁺ आयनों में अपचयित करने के लिए कितने फैराडे (Faraday) विद्युत की आवश्यकता होती है?",
            optsEn = listOf("5 F", "3 F", "7 F", "2 F"),
            optsHi = listOf("5 F", "3 F", "7 F", "2 F"),
            expEn = "In MnO₄⁻ + 8H⁺ + 5e⁻ → Mn²⁺ + 4H₂O, the oxidation state of Mn changes from +7 to +2 (n = 5 electrons per ion). Thus 5 Faradays are required per mole.",
            expHi = "MnO₄⁻ से Mn²⁺ में Mn की ऑक्सीकरण अवस्था +7 से +2 हो जाती है (5 इलेक्ट्रॉनों का अंतर), अतः प्रति मोल 5 फैराडे आवेश आवश्यक है।",
            yearTag = "NEET UG 2024 PYQ",
            subTopic = "Electrochemistry (Faraday's Laws)"
        ),
        RawNeetPyqSeed(
            qEn = "A first-order reaction is 50% completed in 20 minutes. How much time will it take for 99.9% completion of the same reaction?",
            qHi = "एक प्रथम कोटि की अभिक्रिया 20 मिनट में 50% पूर्ण होती है। इसी अभिक्रिया के 99.9% पूर्ण होने में कितना समय लगेगा?",
            optsEn = listOf("200 minutes", "100 minutes", "150 minutes", "40 minutes"),
            optsHi = listOf("200 मिनट", "100 मिनट", "150 मिनट", "40 मिनट"),
            expEn = "For a first-order reaction, t_(99.9%) ≈ 10 × t_(1/2). Since t_(1/2) = 20 minutes, t_(99.9%) = 10 × 20 = 200 minutes.",
            expHi = "प्रथम कोटि की अभिक्रिया के लिए t_(99.9%) ≈ 10 × t_(1/2) होता है। अतः t_(99.9%) = 10 × 20 = 200 मिनट।",
            yearTag = "NEET UG 2023 PYQ",
            subTopic = "Chemical Kinetics (First-Order Reactions)"
        ),
        RawNeetPyqSeed(
            qEn = "In the Arrhenius equation k = A e^(-E_a / RT), the slope of the straight line obtained by plotting ln k versus 1/T is:",
            qHi = "आरहेनियस समीकरण k = A e^(-E_a / RT) में, ln k तथा 1/T के मध्य खींचे गए सरल रेखा ग्राफ का ढाल (Slope) क्या होता है?",
            optsEn = listOf("-E_a / R", "-E_a / (2.303 R)", "+E_a / R", "ln A"),
            optsHi = listOf("-E_a / R", "-E_a / (2.303 R)", "+E_a / R", "ln A"),
            expEn = "Taking natural log: ln k = ln A - (E_a / R)(1/T). Thus the plot of ln k vs 1/T has a slope equal to -E_a / R.",
            expHi = "ln k = ln A - (E_a / R)(1/T)। अतः ln k बनाम 1/T ग्राफ का ढाल (Slope) = -E_a / R होता है।",
            yearTag = "NEET UG 2024 PYQ",
            subTopic = "Chemical Kinetics (Arrhenius Equation)"
        )
    )

    // ==================== 3. NEET ORGANIC CHEMISTRY SEEDS ====================
    val neetOrganicChemSeeds: List<RawNeetPyqSeed> = listOf(
        RawNeetPyqSeed(
            qEn = "In Lassaigne's test for nitrogen in an organic compound, the Prussian blue colour is due to the formation of:",
            qHi = "किसी कार्बनिक यौगिक में नाइट्रोजन के परीक्षण हेतु लैसेन परीक्षण (Lassaigne's Test) में प्रशियन ब्लू (Prussian Blue) रंग किसके बनने के कारण होता है?",
            optsEn = listOf("Fe₄[Fe(CN)₆]₃", "Na₄[Fe(CN)₆]", "Fe₂[Fe(CN)₆]", "Na₂[Fe(CN)₅NO]"),
            optsHi = listOf("Fe₄[Fe(CN)₆]₃", "Na₄[Fe(CN)₆]", "Fe₂[Fe(CN)₆]", "Na₂[Fe(CN)₅NO]"),
            expEn = "Iron(III) hexacyanoferrate(II), Fe₄[Fe(CN)₆]₃ (Ferriferrocyanide), gives the characteristic Prussian blue colour in Lassaigne's test for nitrogen.",
            expHi = "लैसेन परीक्षण में फेरिफेरोसायनाइड Fe₄[Fe(CN)₆]₃ के निर्माण के कारण गहरा नीला (Prussian Blue) रंग प्राप्त होता है।",
            yearTag = "NEET UG 2023 PYQ",
            subTopic = "Purification & Qualitative Analysis (NCERT)"
        ),
        RawNeetPyqSeed(
            qEn = "Which of the following carbocations is the most stable due to resonance and hyperconjugation?",
            qHi = "अनुनाद एवं अतिसंयुग्मन (Hyperconjugation) के कारण निम्नलिखित में से कौन-सा कार्बधनायन (Carbocation) सर्वाधिक स्थायी है?",
            optsEn = listOf("(C₆H₅)₃C⁺ (Triphenylmethyl carbocation)", "(CH₃)₃C⁺ (tert-Butyl carbocation)", "C₆H₅CH₂⁺ (Benzyl carbocation)", "CH₂=CH-CH₂⁺ (Allyl carbocation)"),
            optsHi = listOf("(C₆H₅)₃C⁺ (ट्राइफेनिलमेथिल कार्बधनायन)", "(CH₃)₃C⁺ (तृतीयक-ब्यूटिल कार्बधनायन)", "C₆H₅CH₂⁺ (बेंजिल कार्बधनायन)", "CH₂=CH-CH₂⁺ (एलिल कार्बधनायन)"),
            expEn = "The triphenylmethyl carbocation (C₆H₅)₃C⁺ has extensive π-electron delocalization over three benzene rings (10 resonance structures), making it the most stable.",
            expHi = "ट्राइफेनिलमेथिल कार्बधनायन (C₆H₅)₃C⁺ में तीन बेंजीन वलयों के साथ व्यापक अनुनाद स्थायीकरण होता है, जिससे यह सर्वाधिक स्थायी है।",
            yearTag = "NEET UG 2024 PYQ",
            subTopic = "General Organic Chemistry (GOC)"
        ),
        RawNeetPyqSeed(
            qEn = "Reaction of propene (CH₃-CH=CH₂) with HBr in the presence of organic peroxide (R-O-O-R) yields predominantly:",
            qHi = "कार्बनिक पेरॉक्साइड (R-O-O-R) की उपस्थिति में प्रोपीन (CH₃-CH=CH₂) की HBr के साथ अभिक्रिया से मुख्य उत्पाद क्या बनता है?",
            optsEn = listOf("1-Bromopropane (Anti-Markovnikov Kharasch effect)", "2-Bromopropane", "1,2-Dibromopropane", "2-Propanol"),
            optsHi = listOf("1-ब्रोमोप्रोपेन (एंटी-मार्कोवनिकोव खराश प्रभाव)", "2-ब्रोमोप्रोपेन", "1,2-डाइब्रोमोप्रोपेन", "2-प्रोपेनॉल"),
            expEn = "In the presence of peroxide, HBr adds to unsymmetrical alkenes via a free-radical mechanism (Anti-Markovnikov addition / Kharasch effect), forming 1-bromopropane.",
            expHi = "पेरॉक्साइड की उपस्थिति में HBr प्रोपीन के साथ मुक्त-मूलक क्रियाविधि (एंटी-मार्कोवनिकोव नियम) द्वारा जुड़कर मुख्य उत्पाद 1-ब्रोमोप्रोपेन बनाता है।",
            yearTag = "NEET UG 2023 PYQ",
            subTopic = "Hydrocarbons (Alkenes)"
        ),
        RawNeetPyqSeed(
            qEn = "Which of the following alkyl halides undergoes S_N1 (unimolecular nucleophilic substitution) reaction at the fastest rate?",
            qHi = "निम्नलिखित में से कौन-सा एल्किल हैलाइड सबसे तीव्र गति से S_N1 (एकअणुक नाभिकरागी प्रतिस्थापन) अभिक्रिया देता है?",
            optsEn = listOf("(CH₃)₃C-I (tert-Butyl iodide)", "(CH₃)₃C-Cl (tert-Butyl chloride)", "(CH₃)₂CH-Cl (Isopropyl chloride)", "CH₃CH₂-Cl (Ethyl chloride)"),
            optsHi = listOf("(CH₃)₃C-I (तृतीयक-ब्यूटिल आयोडाइड)", "(CH₃)₃C-Cl (तृतीयक-ब्यूटिल क्लोराइड)", "(CH₃)₂CH-Cl (आइसोप्रोपिल क्लोराइड)", "CH₃CH₂-Cl (एथिल क्लोराइड)"),
            expEn = "S_N1 reactivity depends on carbocation stability (3° > 2° > 1°) and leaving group ability (I⁻ > Br⁻ > Cl⁻ > F⁻). Hence (CH₃)₃C-I reacts the fastest.",
            expHi = "S_N1 अभिक्रिया की दर 3° कार्बधनायन के स्थायित्व और उत्तम निष्कासी समूह (I⁻ > Br⁻ > Cl⁻) पर निर्भर करती है, अतः (CH₃)₃C-I सबसे तीव्र अभिक्रिया करता है।",
            yearTag = "NEET UG 2024 PYQ",
            subTopic = "Haloalkanes & Haloarenes (SN1 & SN2)"
        ),
        RawNeetPyqSeed(
            qEn = "When phenol is treated with chloroform (CHCl₃) and aqueous NaOH followed by acidification, the major product formed is:",
            qHi = "जब फीनॉल की अभिक्रिया क्लोरोफॉर्म (CHCl₃) और जलीय NaOH के साथ कराने के पश्चात अम्लीकरण किया जाता है, तो बनने वाला मुख्य उत्पाद है:",
            optsEn = listOf("Salicylaldehyde (2-Hydroxybenzaldehyde — Reimer-Tiemann Reaction)", "Salicylic acid", "Benzoic acid", "Picric acid"),
            optsHi = listOf("सैलिसिलएल्डिहाइड (2-हाइड्रॉक्सीबेंजएल्डिहाइड — रीमर-टीमैन अभिक्रिया)", "सैलिसिलिक अम्ल", "बेंजोइक अम्ल", "पिक्रिक अम्ल"),
            expEn = "This is the Reimer-Tiemann reaction, which proceeds via dichlorocarbene (:CCl₂) electrophile attack at the ortho position of phenoxide ion to give salicylaldehyde.",
            expHi = "यह रीमर-टीमैन अभिक्रिया है जिसमें डाइक्लोरोकार्बीन (:CCl₂) इलेक्ट्रॉनरागी के आक्रमण से मुख्य उत्पाद सैलिसिलएल्डिहाइड बनता है।",
            yearTag = "NEET UG 2022 PYQ",
            subTopic = "Alcohols, Phenols & Ethers"
        ),
        RawNeetPyqSeed(
            qEn = "Lucas reagent (conc. HCl + anhydrous ZnCl₂) produces immediate turbidity at room temperature with:",
            qHi = "ल्यूकास अभिकर्मक (सांद्र HCl + निर्जल ZnCl₂) कमरे के तापमान पर किसके साथ तुरंत धुंधलापन (Turbidity) उत्पन्न करता है?",
            optsEn = listOf("Tertiary alcohol (e.g., 2-Methylpropan-2-ol)", "Primary alcohol (e.g., Butan-1-ol)", "Secondary alcohol (e.g., Butan-2-ol)", "Methanol"),
            optsHi = listOf("तृतीयक अल्कोहल (जैसे 2-मेथिलप्रोपेन-2-ऑल)", "प्राथमिक अल्कोहल (जैसे ब्यूटेन-1-ऑल)", "द्वितीयक अल्कोहल (जैसे ब्यूटेन-2-ऑल)", "मेथेनॉल"),
            expEn = "Tertiary (3°) alcohols form stable 3° carbocations immediately with Lucas reagent, giving instant white turbidity of the insoluble alkyl chloride.",
            expHi = "तृतीयक (3°) अल्कोहल स्थायी 3° कार्बधनायन बनाने के कारण ल्यूकास अभिकर्मक के साथ कमरे के ताप पर तुरंत धुंधलापन देते हैं।",
            yearTag = "NEET UG 2024 PYQ",
            subTopic = "Alcohols, Phenols & Ethers (Lucas Test)"
        ),
        RawNeetPyqSeed(
            qEn = "Which of the following carbonyl compounds undergoes the Cannizzaro reaction when heated with concentrated NaOH?",
            qHi = "निम्नलिखित में से कौन-सा कार्बोनिल यौगिक सांद्र NaOH के साथ गर्म करने पर कैनिज़ारो (Cannizzaro) अभिक्रिया देता है?",
            optsEn = listOf("Benzaldehyde (C₆H₅CHO) & Formaldehyde (HCHO)", "Acetaldehyde (CH₃CHO)", "Acetone (CH₃COCH₃)", "Propanal (CH₃CH₂CHO)"),
            optsHi = listOf("बेंजएल्डिहाइड (C₆H₅CHO) एवं फॉर्मेल्डिहाइड (HCHO)", "ऐसीटैल्डिहाइड (CH₃CHO)", "ऐसीटोन (CH₃COCH₃)", "प्रोपेनल (CH₃CH₂CHO)"),
            expEn = "Aldehydes lacking an α-hydrogen atom (such as HCHO, C₆H₅CHO, and (CH₃)₃C-CHO) undergo disproportionation (Cannizzaro reaction) in concentrated alkali.",
            expHi = "जिन एल्डिहाइडों में α-हाइड्रोजन परमाणु अनुपस्थित होता है (जैसे बेंजएल्डिहाइड और फॉर्मेल्डिहाइड), वे सांद्र क्षार के साथ कैनिज़ारो अभिक्रिया देते हैं।",
            yearTag = "NEET UG 2023 PYQ",
            subTopic = "Aldehydes, Ketones & Carboxylic Acids"
        ),
        RawNeetPyqSeed(
            qEn = "Which reagent converts a primary amide (R-CONH₂) into a primary amine with one fewer carbon atom (R-NH₂)?",
            qHi = "कौन-सा अभिकर्मक प्राथमिक एमाइड (R-CONH₂) को एक कम कार्बन परमाणु वाले प्राथमिक ऐमीन (R-NH₂) में परिवर्तित करता है?",
            optsEn = listOf("Br₂ + aqueous/ethanolic NaOH (Hoffmann Bromamide Degradation)", "LiAlH₄ in dry ether", "NaBH₄ in ethanol", "P₂O₅ with heat"),
            optsHi = listOf("Br₂ + NaOH/KOH (हॉफमान ब्रोमामाइड निम्नीकरण अभिक्रिया)", "शुष्क ईथर में LiAlH₄", "एथेनॉल में NaBH₄", "P₂O₅ के साथ गर्म करना"),
            expEn = "Hoffmann bromamide degradation (R-CONH₂ + Br₂ + 4NaOH → R-NH₂ + Na₂CO₃ + 2NaBr + 2H₂O) yields a primary amine with one carbon less than the parent amide.",
            expHi = "हॉफमान ब्रोमामाइड निम्नीकरण अभिक्रिया में एमाइड की Br₂ और NaOH से क्रिया द्वारा एक कम कार्बन वाला प्राथमिक ऐमीन प्राप्त होता है।",
            yearTag = "NEET UG 2024 PYQ",
            subTopic = "Amines (Hoffmann Bromamide Reaction)"
        ),
        RawNeetPyqSeed(
            qEn = "When a primary aliphatic or aromatic amine is warmed with chloroform (CHCl₃) and ethanolic KOH, an offensive-smelling compound formed is:",
            qHi = "जब किसी प्राथमिक ऐलिफैटिक या ऐरोमैटिक ऐमीन को क्लोरोफॉर्म (CHCl₃) और एल्कोहॉलिक KOH के साथ गर्म किया जाता है, तो तीव्र दुर्गंधयुक्त कौन-सा यौगिक बनता है?",
            optsEn = listOf("Alkyl / Aryl Isocyanide (R-NC — Carbylamine Test)", "Alkyl Cyanide (R-CN)", "Nitroalkane (R-NO₂)", "Diazonium salt"),
            optsHi = listOf("एल्किल / एरिल आइसोसायनाइड (R-NC — कार्बिलऐमीन परीक्षण)", "एल्किल सायनाइड (R-CN)", "नाइट्रोएल्केन (R-NO₂)", "डाइएज़ोनियम लवण"),
            expEn = "Primary amines exclusively give the Carbylamine reaction (R-NH₂ + CHCl₃ + 3KOH → R-NC + 3KCl + 3H₂O), producing foul-smelling isocyanides (carbylamines).",
            expHi = "केवल प्राथमिक ऐमीन ही क्लोरोफॉर्म और KOH के साथ कार्बिलऐमीन अभिक्रिया देकर दुर्गंधयुक्त आइसोसायनाइड (R-NC) बनाते हैं।",
            yearTag = "NEET UG 2022 PYQ",
            subTopic = "Amines (Carbylamine Test)"
        ),
        RawNeetPyqSeed(
            qEn = "Which of the following nitrogenous bases is NOT present in DNA, being replaced by Thymine?",
            qHi = "निम्नलिखित में से कौन-सा नाइट्रोजनी क्षारक DNA में उपस्थित नहीं होता है (जिसके स्थान पर थाइमीन होता है)?",
            optsEn = listOf("Uracil (present in RNA)", "Adenine", "Guanine", "Cytosine"),
            optsHi = listOf("यूरेसिल (Uracil — जो RNA में होता है)", "एडेनिन (Adenine)", "ग्वानिन (Guanine)", "साइटोसिन (Cytosine)"),
            expEn = "DNA contains Adenine (A), Guanine (G), Cytosine (C), and Thymine (T), whereas RNA contains Uracil (U) instead of Thymine.",
            expHi = "DNA में एडेनिन, ग्वानिन, साइटोसिन और थाइमीन पाए जाते हैं, जबकि यूरेसिल (Uracil) केवल RNA में पाया जाता है।",
            yearTag = "NEET UG 2023 PYQ",
            subTopic = "Biomolecules & Nucleic Acids"
        )
    )
}
