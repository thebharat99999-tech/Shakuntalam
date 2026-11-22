package com.example.data.local

import com.example.data.local.entity.ExamEntity
import com.example.data.local.entity.SubTopicEntity
import com.example.data.local.entity.SubjectEntity

object ExamHierarchyPrepopulateData {

    val defaultExams = listOf(
        ExamEntity(
            id = "upsc_cse",
            name = "UPSC Civil Services Examination",
            hindiName = "संघ लोक सेवा आयोग सिविल सेवा परीक्षा",
            categoryGroup = "Civil Services",
            badge = "Flagship",
            iconKey = "AccountBalance",
            totalVacancies = 1056,
            orderIndex = 1
        ),
        ExamEntity(
            id = "state_psc_uppcs",
            name = "UPPCS (Uttar Pradesh PSC)",
            hindiName = "यूपी लोक सेवा आयोग (सम्मिलित राज्य प्रवर अधीनस्थ)",
            categoryGroup = "State PSC",
            badge = "Popular",
            iconKey = "Gavel",
            totalVacancies = 620,
            orderIndex = 2
        ),
        ExamEntity(
            id = "ssc_cgl",
            name = "SSC Combined Graduate Level (CGL)",
            hindiName = "एसएससी कंबाइंड ग्रेजुएट लेवल (सीजीएल)",
            categoryGroup = "Staff Selection",
            badge = "Hot",
            iconKey = "Badge",
            totalVacancies = 17727,
            orderIndex = 3
        ),
        ExamEntity(
            id = "rrb_ntpc",
            name = "Railway NTPC & Group D",
            hindiName = "रेलवे भर्ती बोर्ड (एनटीपीसी व ग्रुप डी)",
            categoryGroup = "Railways",
            badge = "High Demand",
            iconKey = "Train",
            totalVacancies = 11558,
            orderIndex = 4
        ),
        ExamEntity(
            id = "banking_po",
            name = "SBI & IBPS Probationary Officer (PO)",
            hindiName = "बैंकिंग भर्ती परीक्षा (SBI एवं IBPS पीओ)",
            categoryGroup = "Banking",
            badge = "Premium",
            iconKey = "Payments",
            totalVacancies = 4500,
            orderIndex = 5
        ),
        ExamEntity(
            id = "nielit_ccc",
            name = "NIELIT CCC & O-Level Computer Certifications",
            hindiName = "नाइलिट सीसीसी एवं ओ-लेवल कंप्यूटर प्रमाणन",
            categoryGroup = "Computer & IT",
            badge = "Essential",
            iconKey = "LaptopMac",
            totalVacancies = 0,
            orderIndex = 6
        )
    )

    val defaultSubjects = listOf(
        // UPSC CSE Subjects
        SubjectEntity(
            id = "upsc_history",
            examId = "upsc_cse",
            name = "Modern Indian History & Freedom Struggle",
            hindiName = "आधुनिक भारत का इतिहास एवं स्वतंत्रता संघर्ष",
            stageOrTier = "Prelims & Mains",
            description = "Advent of Europeans, 1857 Revolt, Reform Movements, Congress Phases & Gandhian Mass Movements",
            weightageMarks = 30,
            orderIndex = 1
        ),
        SubjectEntity(
            id = "upsc_polity",
            examId = "upsc_cse",
            name = "Indian Polity, Constitution & Governance",
            hindiName = "भारतीय राजव्यवस्था, संविधान एवं शासन",
            stageOrTier = "Prelims & Mains",
            description = "Preamble, Fundamental Rights, Directive Principles, Parliament, Judiciary & Federal Structure",
            weightageMarks = 35,
            orderIndex = 2
        ),
        SubjectEntity(
            id = "upsc_economy",
            examId = "upsc_cse",
            name = "Indian Economy & Union Budget",
            hindiName = "भारतीय अर्थव्यवस्था एवं केंद्रीय बजट",
            stageOrTier = "Prelims & Mains",
            description = "Macroeconomics, National Income, Monetary Policy, Inflation, Banking, External Sector",
            weightageMarks = 30,
            orderIndex = 3
        ),
        SubjectEntity(
            id = "upsc_csat",
            examId = "upsc_cse",
            name = "CSAT Aptitude & Comprehension (Paper 2)",
            hindiName = "सीसैट अभियोग्यता एवं बोधगम्यता",
            stageOrTier = "Prelims Qualifying",
            description = "Quantitative Aptitude, Logical Reasoning, Analytical Ability, Reading Comprehension",
            weightageMarks = 200,
            orderIndex = 4
        ),

        // UPPCS Subjects
        SubjectEntity(
            id = "uppcs_up_gk",
            examId = "state_psc_uppcs",
            name = "Uttar Pradesh Special General Knowledge",
            hindiName = "उत्तर प्रदेश विशेष सामान्य ज्ञान (पेपर 5 व 6)",
            stageOrTier = "Mains & Prelims",
            description = "History, Geography, Culture, Economy, Expressways, ODOP and Budget of UP",
            weightageMarks = 40,
            orderIndex = 1
        ),

        // SSC CGL Subjects
        SubjectEntity(
            id = "ssc_quant",
            examId = "ssc_cgl",
            name = "Quantitative Aptitude & Advanced Mathematics",
            hindiName = "संख्यात्मक अभियोग्यता एवं एडवांस मैथ्स",
            stageOrTier = "Tier 1 & Tier 2",
            description = "Arithmetic, Geometry, Trigonometry, Algebra, Mensuration, Coordinate Geometry",
            weightageMarks = 50,
            orderIndex = 1
        ),

        // Railway Subjects
        SubjectEntity(
            id = "rrb_science",
            examId = "rrb_ntpc",
            name = "General Science (Physics, Chem, Biology)",
            hindiName = "सामान्य विज्ञान (भौतिकी, रसायन, जीव विज्ञान)",
            stageOrTier = "CBT 1 & CBT 2",
            description = "NCERT Class 6-10 based Science Concepts, Scientific Inventions, Formulas",
            weightageMarks = 30,
            orderIndex = 1
        ),

        // Banking Subjects
        SubjectEntity(
            id = "bank_reasoning",
            examId = "banking_po",
            name = "High-Level Reasoning & Puzzles",
            hindiName = "रीजनिंग पहेलियाँ एवं सिटिंग अरेंजमेंट",
            stageOrTier = "Prelims & Mains",
            description = "Box, Floor, Circular, Parallel Row, Machine Input-Output, Coded Syllogism",
            weightageMarks = 50,
            orderIndex = 1
        ),

        // Computer Subjects
        SubjectEntity(
            id = "ccc_it_tools",
            examId = "nielit_ccc",
            name = "CCC IT Tools & Digital Financial Services",
            hindiName = "सीसीसी कंप्यूटर टूल्स एवं डिजिटल वित्तीय सेवाएं",
            stageOrTier = "Qualifying Exam",
            description = "LibreOffice Writer, Calc, Impress, Internet, Cyber Security & UPI Tools",
            weightageMarks = 100,
            orderIndex = 1
        )
    )

    val defaultSubTopics = listOf(
        // Modern History Sub-topics
        SubTopicEntity(
            id = "hist_sub_1",
            subjectId = "upsc_history",
            name = "Advent of Europeans (Portuguese, Dutch, English, French)",
            hindiName = "यूरोपीय कंपनियों का आगमन एवं कर्नाटक युद्ध",
            importanceLevel = "Must Read",
            estimatedHours = 3.5,
            pyqCount = 18,
            summary = "Blue water policy, Battle of Plassey 1757, Battle of Buxar 1764, Treaty of Allahabad",
            orderIndex = 1
        ),
        SubTopicEntity(
            id = "hist_sub_2",
            subjectId = "upsc_history",
            name = "The Great Revolt of 1857: Causes, Centers & Leaders",
            hindiName = "1857 का महान विद्रोह: कारण, प्रमुख केंद्र एवं नायक",
            importanceLevel = "High Yield",
            estimatedHours = 4.0,
            pyqCount = 28,
            summary = "Doctrine of lapse, Enfield rifle cartridges, Meerut, Delhi, Jhansi, Kanpur, Peel Commission",
            orderIndex = 2
        ),
        SubTopicEntity(
            id = "hist_sub_3",
            subjectId = "upsc_history",
            name = "Socio-Religious Reform Movements of 19th Century",
            hindiName = "19वीं सदी के सामाजिक एवं धार्मिक सुधार आंदोलन",
            importanceLevel = "High Yield",
            estimatedHours = 5.0,
            pyqCount = 32,
            summary = "Raja Ram Mohan Roy, Brahmo Samaj, Ishwar Chandra Vidyasagar, Arya Samaj, Satyashodhak Samaj",
            orderIndex = 3
        ),
        SubTopicEntity(
            id = "hist_sub_4",
            subjectId = "upsc_history",
            name = "Gandhian Era & Mass Satyagraha (1915 - 1947)",
            hindiName = "गांधीवादी युग एवं प्रमुख जन आंदोलन (1915-1947)",
            importanceLevel = "High Yield",
            estimatedHours = 6.0,
            pyqCount = 45,
            summary = "Champaran, Kheda, Non-Cooperation, Civil Disobedience (Dandi March), Quit India 1942",
            orderIndex = 4
        ),

        // Polity Sub-topics
        SubTopicEntity(
            id = "polity_sub_1",
            subjectId = "upsc_polity",
            name = "Historical Evolution & Constituent Assembly Making",
            hindiName = "संविधान सभा का गठन एवं ऐतिहासिक पृष्ठभूमि",
            importanceLevel = "Core Foundation",
            estimatedHours = 4.0,
            pyqCount = 22,
            summary = "Acts of 1773 to 1935, Objectives Resolution, Drafting Committee, Enactment on 26 Nov 1949",
            orderIndex = 1
        ),
        SubTopicEntity(
            id = "polity_sub_2",
            subjectId = "upsc_polity",
            name = "Preamble: Sovereign, Socialist, Secular, Democratic, Republic",
            hindiName = "प्रस्तावना: दार्शनिक आधार एवं मूल संरचना",
            importanceLevel = "High Yield",
            estimatedHours = 2.5,
            pyqCount = 19,
            summary = "Kesavananda Bharati Case (1973), 42nd Amendment 1976 additions, Justice, Liberty, Equality",
            orderIndex = 2
        ),
        SubTopicEntity(
            id = "polity_sub_3",
            subjectId = "upsc_polity",
            name = "Fundamental Rights (Articles 12-35) & Writs Jurisdiction",
            hindiName = "मूल अधिकार (अनुच्छेद 12 से 35) एवं संवैधानिक उपचार",
            importanceLevel = "High Yield",
            estimatedHours = 6.5,
            pyqCount = 52,
            summary = "Articles 14, 19, 21, 21A, Article 32 Writs: Habeas Corpus, Mandamus, Quo-Warranto, Certiorari",
            orderIndex = 3
        ),
        SubTopicEntity(
            id = "polity_sub_4",
            subjectId = "upsc_polity",
            name = "Directive Principles (DPSP) & Fundamental Duties (Art 51A)",
            hindiName = "राज्य के नीति निदेशक तत्व (DPSP) एवं मूल कर्तव्य",
            importanceLevel = "Must Read",
            estimatedHours = 3.5,
            pyqCount = 26,
            summary = "Socialist, Gandhian & Liberal principles, Swaran Singh Committee, 86th Amendment",
            orderIndex = 4
        ),

        // CSAT Sub-topics
        SubTopicEntity(
            id = "csat_sub_1",
            subjectId = "upsc_csat",
            name = "Number Systems, Divisibility Rules & Remainder Theorem",
            hindiName = "संख्या पद्धति, विभाज्यता नियम एवं शेषफल प्रमेय",
            importanceLevel = "High Yield",
            estimatedHours = 4.5,
            pyqCount = 34,
            summary = "Unit digits, Prime factorisation, LCM & HCF, Recurring decimals, Power cycles",
            orderIndex = 1
        ),
        SubTopicEntity(
            id = "csat_sub_2",
            subjectId = "upsc_csat",
            name = "Reading Comprehension & Critical Inference",
            hindiName = "बोधगम्यता एवं तार्किक निष्कर्ष",
            importanceLevel = "High Yield",
            estimatedHours = 5.0,
            pyqCount = 38,
            summary = "Crux identification, Assumptions, Implications, Objective decision making",
            orderIndex = 2
        ),

        // UPPCS Sub-topics
        SubTopicEntity(
            id = "uppcs_sub_1",
            subjectId = "uppcs_up_gk",
            name = "8 Ancient Mahajanapadas of Uttar Pradesh & Buddhist Heritage",
            hindiName = "उत्तर प्रदेश के 8 महाजनपद एवं बौद्ध धरोहर",
            importanceLevel = "High Yield",
            estimatedHours = 3.0,
            pyqCount = 20,
            summary = "Kashi, Kosala, Vatsa, Malla, Chedi, Kuru, Panchala, Surasena; Sarnath, Kushinagar, Shravasti",
            orderIndex = 1
        ),
        SubTopicEntity(
            id = "uppcs_sub_2",
            subjectId = "uppcs_up_gk",
            name = "UP Drainage System, Expressways & ODOP Schemes",
            hindiName = "उत्तर प्रदेश की नदियां, प्रमुख एक्सप्रेसवे एवं ODOP योजना",
            importanceLevel = "High Yield",
            estimatedHours = 4.0,
            pyqCount = 25,
            summary = "Ganga, Yamuna, Sarayu; Purvanchal, Bundelkhand, Ganga Expressway; One District One Product",
            orderIndex = 2
        ),

        // SSC CGL Sub-topics
        SubTopicEntity(
            id = "ssc_sub_1",
            subjectId = "ssc_quant",
            name = "Geometry: Triangles, Circles, Tangents & Centers",
            hindiName = "ज्यामिति: त्रिभुज, वृत्त, स्पर्श रेखाएं एवं केंद्र",
            importanceLevel = "High Yield",
            estimatedHours = 5.5,
            pyqCount = 42,
            summary = "Incenter, Circumcenter, Centroid, Orthocenter, Cyclic Quadrilaterals, Chords & Secants",
            orderIndex = 1
        ),
        SubTopicEntity(
            id = "ssc_sub_2",
            subjectId = "ssc_quant",
            name = "Trigonometric Ratios, Identities & Heights-Distances",
            hindiName = "त्रिकोणमितीय सर्वसमिकाएं एवं ऊंचाई-दूरी",
            importanceLevel = "Must Read",
            estimatedHours = 4.0,
            pyqCount = 30,
            summary = "Standard angles, Complementary angles, Maxima-Minima of trigonometric functions",
            orderIndex = 2
        ),

        // CCC Sub-topics
        SubTopicEntity(
            id = "ccc_sub_1",
            subjectId = "ccc_it_tools",
            name = "LibreOffice Suite (Writer, Calc & Impress Shortcuts)",
            hindiName = "लिब्रेऑफिस (राइटर, कैल्क एवं इम्प्रेस शॉर्टकट)",
            importanceLevel = "High Yield",
            estimatedHours = 3.5,
            pyqCount = 45,
            summary = "File extensions (.odt, .ods, .odp), keyboard shortcuts, formulas, transitions",
            orderIndex = 1
        ),
        SubTopicEntity(
            id = "ccc_sub_2",
            subjectId = "ccc_it_tools",
            name = "Digital Financial Services (UPI, AEPS, USSD, RTGS/NEFT)",
            hindiName = "डिजिटल वित्तीय सेवाएं एवं साइबर सुरक्षा",
            importanceLevel = "Must Read",
            estimatedHours = 2.5,
            pyqCount = 30,
            summary = "BHIM UPI, *99# USSD, Micro-ATMs, OTP, Two-factor authentication, phishing prevention",
            orderIndex = 2
        )
    )
}
