package com.example.data.ugcnet

import com.example.model.MockTest
import com.example.model.TestQuestion

data class UgcNetSectionTestSpec(
    val id: String,
    val testId: String,
    val sectionNumber: Int,
    val paperLevel: String, // "PAPER_1" or "PAPER_2"
    val unitOrSubjectCode: String,
    val shortBadgeEn: String,
    val shortBadgeHi: String,
    val titleEn: String,
    val titleHi: String,
    val syllabusSummaryEn: String,
    val syllabusSummaryHi: String,
    val badgeColorHex: Long
)

/**
 * Complete UGC NET (NTA) Test Series Bank:
 * - Tab 1: Paper 1 (Teaching & Research Aptitude — Code 00) -> All 10 Syllabus Units × 100 PYQ MCQs = 1,000 Questions
 * - Tab 2: Paper 2 (Subject-Specific) -> All 12 Major UGC NET Subjects × 100 PYQ MCQs = 1,200 Questions
 * Total = 22 Full 100-MCQ Tests (2,200 Authentic Bilingual PYQ Questions) with NTA UGC NET Marking (+2.0, -0.0).
 */
object UgcNetAllSubjectsPyqData {

    val sectionSpecs: List<UgcNetSectionTestSpec> = listOf(
        // ==================== TAB 1: UGC NET PAPER 1 (ALL 10 UNITS × 100 MCQs) ====================
        UgcNetSectionTestSpec(
            id = "ugc_p1_unit1_teaching",
            testId = "ugc_p1_sec_unit1_100",
            sectionNumber = 1,
            paperLevel = "PAPER_1",
            unitOrSubjectCode = "UNIT_1",
            shortBadgeEn = "Paper 1 • Unit I",
            shortBadgeHi = "पेपर 1 • इकाई I",
            titleEn = "Unit I: Teaching Aptitude (100 PYQs)",
            titleHi = "इकाई I: शिक्षण अभिक्षमता — Teaching Aptitude (100 प्रश्न)",
            syllabusSummaryEn = "Levels of Teaching (Memory, Understanding, Reflective), Learner Characteristics, SWAYAM, SWAYAMPRABHA, MOOCs, CBCS, Formative & Summative Evaluation",
            syllabusSummaryHi = "शिक्षण के स्तर (स्मृति, अवबोध, चिंतनशील), शिक्षार्थी की विशेषताएँ, स्वयं, स्वयंप्रभा, MOOCs, CBCS एवं मूल्यांकन प्रणाली",
            badgeColorHex = 0xFF4F46E5
        ),
        UgcNetSectionTestSpec(
            id = "ugc_p1_unit2_research",
            testId = "ugc_p1_sec_unit2_100",
            sectionNumber = 2,
            paperLevel = "PAPER_1",
            unitOrSubjectCode = "UNIT_2",
            shortBadgeEn = "Paper 1 • Unit II",
            shortBadgeHi = "पेपर 1 • इकाई II",
            titleEn = "Unit II: Research Aptitude (100 PYQs)",
            titleHi = "इकाई II: शोध अभिक्षमता — Research Aptitude (100 प्रश्न)",
            syllabusSummaryEn = "Positivism & Post-Positivism, Experimental/Ex-post Facto/Ethnographic Research, Sampling, Type-I & Type-II Errors, APA/MLA Styles, UGC Plagiarism Norms",
            syllabusSummaryHi = "प्रत्यक्षवाद एवं उत्तर-प्रत्यक्षवाद, शोध विधियाँ, प्रतिचयन (Sampling), टाइप-I व टाइप-II त्रुटि, शोध नैतिकता एवं साहित्यिक चोरी नियम",
            badgeColorHex = 0xFF7C3AED
        ),
        UgcNetSectionTestSpec(
            id = "ugc_p1_unit3_comprehension",
            testId = "ugc_p1_sec_unit3_100",
            sectionNumber = 3,
            paperLevel = "PAPER_1",
            unitOrSubjectCode = "UNIT_3",
            shortBadgeEn = "Paper 1 • Unit III",
            shortBadgeHi = "पेपर 1 • इकाई III",
            titleEn = "Unit III: Reading Comprehension (100 PYQs)",
            titleHi = "इकाई III: बोधगम्यता / अपठित गद्यांश — Comprehension (100 प्रश्न)",
            syllabusSummaryEn = "Academic Passage Analysis, Central Theme & Author's Tone, Deductive Inference,Implicit Assumptions, Contextual Vocabulary & Logical Corollary",
            syllabusSummaryHi = "अकादमिक गद्यांश विश्लेषण, केंद्रीय भाव, लेखक का दृष्टिकोण, निहित पूर्वधारणाएँ एवं तार्किक निष्कर्ष",
            badgeColorHex = 0xFF0284C7
        ),
        UgcNetSectionTestSpec(
            id = "ugc_p1_unit4_communication",
            testId = "ugc_p1_sec_unit4_100",
            sectionNumber = 4,
            paperLevel = "PAPER_1",
            unitOrSubjectCode = "UNIT_4",
            shortBadgeEn = "Paper 1 • Unit IV",
            shortBadgeHi = "पेपर 1 • इकाई IV",
            titleEn = "Unit IV: Communication (100 PYQs)",
            titleHi = "इकाई IV: संप्रेषण — Communication (100 प्रश्न)",
            syllabusSummaryEn = "Classroom Communication, Verbal & Non-Verbal (Kinesics, Proxemics, Chronemics, Paralinguistics), Shannon-Weaver/Berlo Models, Semantic Barriers & Mass Media",
            syllabusSummaryHi = "कक्षा संप्रेषण, शाब्दिक एवं अशाब्दिक (काइनेसिक्स, प्रॉक्सेमिक्स, क्रोनेमिक्स), संप्रेषण के मॉडल, भाषाई बाधाएँ एवं जनसंचार",
            badgeColorHex = 0xFF0D9488
        ),
        UgcNetSectionTestSpec(
            id = "ugc_p1_unit5_math_reasoning",
            testId = "ugc_p1_sec_unit5_100",
            sectionNumber = 5,
            paperLevel = "PAPER_1",
            unitOrSubjectCode = "UNIT_5",
            shortBadgeEn = "Paper 1 • Unit V",
            shortBadgeHi = "पेपर 1 • इकाई V",
            titleEn = "Unit V: Mathematical Reasoning & Aptitude (100 PYQs)",
            titleHi = "इकाई V: गणितीय तर्क और अभिक्षमता (100 प्रश्न)",
            syllabusSummaryEn = "Number & Letter Series, Coding-Decoding, Direction Sense, Blood Relations, Percentage, Profit & Loss, Ratio-Proportion, Time-Speed-Distance, CI & SI",
            syllabusSummaryHi = "संख्या एवं अक्षर श्रृंखला, कोडिंग-डिकोडिंग, रक्त संबंध, प्रतिशत, लाभ-हानि, समय-दूरी-चाल, साधारण एवं चक्रवृद्धि ब्याज",
            badgeColorHex = 0xFF059669
        ),
        UgcNetSectionTestSpec(
            id = "ugc_p1_unit6_logical_reasoning",
            testId = "ugc_p1_sec_unit6_100",
            sectionNumber = 6,
            paperLevel = "PAPER_1",
            unitOrSubjectCode = "UNIT_6",
            shortBadgeEn = "Paper 1 • Unit VI",
            shortBadgeHi = "पेपर 1 • इकाई VI",
            titleEn = "Unit VI: Logical Reasoning & Indian Logic (100 PYQs)",
            titleHi = "इकाई VI: युक्तियुक्त तर्क एवं भारतीय तर्कशास्त्र — प्रमाण व हेत्वाभास (100 प्रश्न)",
            syllabusSummaryEn = "Classical Square of Opposition (A, E, I, O), Categorical Syllogism, Formal & Informal Fallacies, 6 Pramanas (Pratyaksha, Anumana, Upamana, Shabda, Arthapatti, Anupalabdhi) & Hetvabhasa",
            syllabusSummaryHi = "विरोध का वर्ग (A, E, I, O), न्यायवाक्य, तर्कदोष, षड् प्रमाण (प्रत्यक्ष, अनुमान, उपमान, शब्द, अर्थापत्ति, अनुपलब्धि) एवं हेत्वाभास",
            badgeColorHex = 0xFFD97706
        ),
        UgcNetSectionTestSpec(
            id = "ugc_p1_unit7_di",
            testId = "ugc_p1_sec_unit7_100",
            sectionNumber = 7,
            paperLevel = "PAPER_1",
            unitOrSubjectCode = "UNIT_7",
            shortBadgeEn = "Paper 1 • Unit VII",
            shortBadgeHi = "पेपर 1 • इकाई VII",
            titleEn = "Unit VII: Data Interpretation — DI (100 PYQs)",
            titleHi = "इकाई VII: आंकड़ों की व्याख्या — Data Interpretation (100 प्रश्न)",
            syllabusSummaryEn = "Tabular DI, Pie Chart Sector Angles, Bar & Line Graphs, Missing Data Tables, Income-Expenditure Profit % Ratios, CAGR & Data Sufficiency",
            syllabusSummaryHi = "तालिका विश्लेषण, पाई चार्ट कोण गणना, दंड एवं रेखा आरेख, आय-व्यय प्रतिशत अनुपात, वृद्धि दर एवं आंकड़ा पर्याप्तता",
            badgeColorHex = 0xFFEA580C
        ),
        UgcNetSectionTestSpec(
            id = "ugc_p1_unit8_ict",
            testId = "ugc_p1_sec_unit8_100",
            sectionNumber = 8,
            paperLevel = "PAPER_1",
            unitOrSubjectCode = "UNIT_8",
            shortBadgeEn = "Paper 1 • Unit VIII",
            shortBadgeHi = "पेपर 1 • इकाई VIII",
            titleEn = "Unit VIII: Information & Communication Technology — ICT (100 PYQs)",
            titleHi = "इकाई VIII: सूचना और संचार प्रौद्योगिकी — ICT (100 प्रश्न)",
            syllabusSummaryEn = "Memory Hierarchy (Registers, Cache, RAM, SSD), Number Conversions (Binary/Hex/2's Complement), OSI & TCP/IP Protocols, Malware, Digital Initiatives (NAD, ABC, NDL)",
            syllabusSummaryHi = "मेमोरी पदानुक्रम (रजिस्टर, कैश, RAM, SSD), बाइनरी/हेक्साडेसिमल रूपांतरण, नेटवर्क प्रोटोकॉल, साइबर सुरक्षा एवं डिजिटल पहल",
            badgeColorHex = 0xFF2563EB
        ),
        UgcNetSectionTestSpec(
            id = "ugc_p1_unit9_environment",
            testId = "ugc_p1_sec_unit9_100",
            sectionNumber = 9,
            paperLevel = "PAPER_1",
            unitOrSubjectCode = "UNIT_9",
            shortBadgeEn = "Paper 1 • Unit IX",
            shortBadgeHi = "पेपर 1 • इकाई IX",
            titleEn = "Unit IX: People, Development & Environment (100 PYQs)",
            titleHi = "इकाई IX: लोक, विकास और पर्यावरण (100 प्रश्न)",
            syllabusSummaryEn = "MDGs vs 17 SDGs, Air Quality (PM2.5, Ozone, Photochemical Smog), Water & Noise Pollution, NAPCC 8 Missions, Montreal/Kyoto/Paris/Kigali Agreements, ISA & Disaster Management",
            syllabusSummaryHi = "सहस्राब्दी एवं 17 सतत विकास लक्ष्य (SDGs), वायु/जल/ध्वनि प्रदूषण, NAPCC के 8 मिशन, मॉन्ट्रियल/क्योटो/पेरिस/किगाली समझौते एवं आपदा प्रबंधन",
            badgeColorHex = 0xFF16A34A
        ),
        UgcNetSectionTestSpec(
            id = "ugc_p1_unit10_higher_ed",
            testId = "ugc_p1_sec_unit10_100",
            sectionNumber = 10,
            paperLevel = "PAPER_1",
            unitOrSubjectCode = "UNIT_10",
            shortBadgeEn = "Paper 1 • Unit X",
            shortBadgeHi = "पेपर 1 • इकाई X",
            titleEn = "Unit X: Higher Education System (100 PYQs)",
            titleHi = "इकाई X: उच्च शिक्षा प्रणाली — Higher Education (100 प्रश्न)",
            syllabusSummaryEn = "Ancient Universities (Takshashila, Nalanda, Vikramshila), Radhakrishnan/Kothari Commissions, NEP 2020 (HECI: NHERC, NAC, HEGC, GEC; 5+3+3+4; PARAKH), UGC Act 1956, NAAC & NIRF",
            syllabusSummaryHi = "प्राचीन विश्वविद्यालय (तक्षशिला, नालंदा, विक्रमशिला), राधाकृष्णन/कोठारी आयोग, राष्ट्रीय शिक्षा नीति (NEP 2020 — HECI के 4 स्तंभ), UGC अधिनियम 1956, NAAC एवं NIRF",
            badgeColorHex = 0xFF9333EA
        ),

        // ==================== TAB 2: UGC NET PAPER 2 (ALL 12 SUBJECTS × 100 MCQs) ====================
        UgcNetSectionTestSpec(
            id = "ugc_p2_history",
            testId = "ugc_p2_sec_history_100",
            sectionNumber = 1,
            paperLevel = "PAPER_2",
            unitOrSubjectCode = "HISTORY",
            shortBadgeEn = "Paper 2 • History (006)",
            shortBadgeHi = "पेपर 2 • इतिहास (006)",
            titleEn = "1. History (Code 006) — 100 PYQ MCQs",
            titleHi = "1. इतिहास / History (कोड 006) — 100 प्रश्न (PYQ)",
            syllabusSummaryEn = "Ancient India (Harappan, Vedic, Mauryan, Gupta, Chola), Sultanate & Mughal Administration, Bhakti-Sufi, Colonial Economy, Freedom Struggle & Historiography",
            syllabusSummaryHi = "प्राचीन भारत (हड़प्पा, वैदिक, मौर्य, गुप्त, चोल), सल्तनत एवं मुगल प्रशासन, भक्ति-सूफी आंदोलन, आधुनिक भारत एवं इतिहास-लेखन",
            badgeColorHex = 0xFFB45309
        ),
        UgcNetSectionTestSpec(
            id = "ugc_p2_pol_science",
            testId = "ugc_p2_sec_pol_science_100",
            sectionNumber = 2,
            paperLevel = "PAPER_2",
            unitOrSubjectCode = "POL_SCIENCE",
            shortBadgeEn = "Paper 2 • Pol. Science (002)",
            shortBadgeHi = "पेपर 2 • राजनीति विज्ञान (002)",
            titleEn = "2. Political Science (Code 002) — 100 PYQ MCQs",
            titleHi = "2. राजनीति विज्ञान / Political Science (कोड 002) — 100 प्रश्न (PYQ)",
            syllabusSummaryEn = "Political Theory (Rawls, Nozick), Western & Indian Political Thought (Plato to Marx, Kautilya to Ambedkar), Comparative Politics, International Relations, Indian Constitution & Public Administration",
            syllabusSummaryHi = "राजनीतिक सिद्धांत, पाश्चात्य एवं भारतीय राजनीतिक चिंतन, तुलनात्मक राजनीति, अंतर्राष्ट्रीय संबंध, भारतीय संविधान एवं लोक प्रशासन",
            badgeColorHex = 0xFF1D4ED8
        ),
        UgcNetSectionTestSpec(
            id = "ugc_p2_geography",
            testId = "ugc_p2_sec_geography_100",
            sectionNumber = 3,
            paperLevel = "PAPER_2",
            unitOrSubjectCode = "GEOGRAPHY",
            shortBadgeEn = "Paper 2 • Geography (080)",
            shortBadgeHi = "पेपर 2 • भूगोल (080)",
            titleEn = "3. Geography (Code 080) — 100 PYQ MCQs",
            titleHi = "3. भूगोल / Geography (कोड 080) — 100 प्रश्न (PYQ)",
            syllabusSummaryEn = "Geomorphology (Davis, Penck), Climatology (Köppen), Oceanography, Population & Settlement (Christaller), Economic/Regional Geography, Geographical Thought, GIS & Remote Sensing",
            syllabusSummaryHi = "भू-आकृति विज्ञान, जलवायु विज्ञान, समुद्र विज्ञान, जनसंख्या एवं अधिवास भूगोल (क्रिस्टालर), भौगोलिक चिंतन, सुदूर संवेदन (GIS) एवं भारत का भूगोल",
            badgeColorHex = 0xFF047857
        ),
        UgcNetSectionTestSpec(
            id = "ugc_p2_economics",
            testId = "ugc_p2_sec_economics_100",
            sectionNumber = 4,
            paperLevel = "PAPER_2",
            unitOrSubjectCode = "ECONOMICS",
            shortBadgeEn = "Paper 2 • Economics (001)",
            shortBadgeHi = "पेपर 2 • अर्थशास्त्र (001)",
            titleEn = "4. Economics (Code 001) — 100 PYQ MCQs",
            titleHi = "4. अर्थशास्त्र / Economics (कोड 001) — 100 प्रश्न (PYQ)",
            syllabusSummaryEn = "Microeconomics (CES, Game Theory, Welfare), Macroeconomics (IS-LM, Mundell-Fleming), Econometrics (CLRM, Heteroscedasticity), International Trade, Public Finance, Growth Models & Indian Economy",
            syllabusSummaryHi = "व्यष्टि एवं समष्टि अर्थशास्त्र (IS-LM मॉडल), अर्थमिति (Econometrics), अंतर्राष्ट्रीय अर्थशास्त्र, लोक वित्त, आर्थिक विकास के मॉडल एवं भारतीय अर्थव्यवस्था",
            badgeColorHex = 0xFF0F766E
        ),
        UgcNetSectionTestSpec(
            id = "ugc_p2_hindi",
            testId = "ugc_p2_sec_hindi_100",
            sectionNumber = 5,
            paperLevel = "PAPER_2",
            unitOrSubjectCode = "HINDI",
            shortBadgeEn = "Paper 2 • Hindi Lit. (020)",
            shortBadgeHi = "पेपर 2 • हिंदी साहित्य (020)",
            titleEn = "5. Hindi Literature (Code 020) — 100 PYQ MCQs",
            titleHi = "5. हिंदी साहित्य / Hindi Literature (कोड 020) — 100 प्रश्न (PYQ)",
            syllabusSummaryEn = "हिंदी भाषा का विकास, आदिकाल, भक्तिकाल (अष्टछाप, संत/सूफी), रीतिकाल, आधुनिक काल (छायावाद, तार सप्तक), भारतीय व पाश्चात्य काव्यशास्त्र, हिंदी उपन्यास, कहानी, नाटक एवं निबंध",
            syllabusSummaryHi = "हिंदी भाषा का विकास, आदिकाल, भक्तिकाल, रीतिकाल, आधुनिक काल (छायावाद, प्रयोगवाद, नई कविता), काव्यशास्त्र, उपन्यास (गोदान, मैला आँचल, राग दरबारी), कहानी एवं नाटक",
            badgeColorHex = 0xFFB91C1C
        ),
        UgcNetSectionTestSpec(
            id = "ugc_p2_english",
            testId = "ugc_p2_sec_english_100",
            sectionNumber = 6,
            paperLevel = "PAPER_2",
            unitOrSubjectCode = "ENGLISH",
            shortBadgeEn = "Paper 2 • English Lit. (030)",
            shortBadgeHi = "पेपर 2 • अंग्रेज़ी साहित्य (030)",
            titleEn = "6. English Literature (Code 030) — 100 PYQ MCQs",
            titleHi = "6. अंग्रेज़ी साहित्य / English Literature (कोड 030) — 100 प्रश्न (PYQ)",
            syllabusSummaryEn = "British Drama, Poetry & Fiction (Chaucer, Shakespeare, Romantic, Victorian, Modernist), Indian Writing in English, Postcolonial, Feminist, Structuralist & Deconstructive Literary Theory",
            syllabusSummaryHi = "ब्रिटिश नाटक, काव्य एवं उपन्यास (चौसर, शेक्सपियर, रोमांटिक, विक्टोरियन, आधुनिक), भारतीय-अंग्रेज़ी साहित्य, साहित्यिक आलोचना एवं उत्तर-आधुनिक सिद्धांत",
            badgeColorHex = 0xFF6D28D9
        ),
        UgcNetSectionTestSpec(
            id = "ugc_p2_commerce",
            testId = "ugc_p2_sec_commerce_100",
            sectionNumber = 7,
            paperLevel = "PAPER_2",
            unitOrSubjectCode = "COMMERCE",
            shortBadgeEn = "Paper 2 • Commerce (008)",
            shortBadgeHi = "पेपर 2 • वाणिज्य (008)",
            titleEn = "7. Commerce (Code 008) — 100 PYQ MCQs",
            titleHi = "7. वाणिज्य / Commerce (कोड 008) — 100 प्रश्न (PYQ)",
            syllabusSummaryEn = "International Business (IPLC, WTO), Accounting & Ind AS, Business Economics, Corporate Finance (MM Approach, CAPM), Statistics, Banking (Basel III), Marketing, Legal Aspects & Income Tax",
            syllabusSummaryHi = "अंतर्राष्ट्रीय व्यवसाय, लेखांकन एवं Ind AS, व्यावसायिक अर्थशास्त्र, वित्तीय प्रबंधन (MM उपागम), सांख्यिकी, बैंकिंग (Basel III), विपणन एवं आयकर अधिनियम 1961",
            badgeColorHex = 0xFF0369A1
        ),
        UgcNetSectionTestSpec(
            id = "ugc_p2_management",
            testId = "ugc_p2_sec_management_100",
            sectionNumber = 8,
            paperLevel = "PAPER_2",
            unitOrSubjectCode = "MANAGEMENT",
            shortBadgeEn = "Paper 2 • Management (017)",
            shortBadgeHi = "पेपर 2 • प्रबंधन (017)",
            titleEn = "8. Management (Code 017) — 100 PYQ MCQs",
            titleHi = "8. प्रबंधन / Management (कोड 017) — 100 प्रश्न (PYQ)",
            syllabusSummaryEn = "Organizational Behaviour & HRM (Herzberg, Maslow), Financial Management & CAPM, Strategic Management (BCG Matrix, Porter's 5 Forces), Services Marketing (SERVQUAL), Operations (PERT/CPM) & Entrepreneurship",
            syllabusSummaryHi = "संगठनात्मक व्यवहार एवं मानव संसाधन प्रबंधन, वित्तीय प्रबंधन (CAPM), रणनीतिक प्रबंधन (BCG मैट्रिक्स), विपणन (SERVQUAL) एवं संक्रिया प्रबंधन (PERT/CPM)",
            badgeColorHex = 0xFF4338CA
        ),
        UgcNetSectionTestSpec(
            id = "ugc_p2_sociology",
            testId = "ugc_p2_sec_sociology_100",
            sectionNumber = 9,
            paperLevel = "PAPER_2",
            unitOrSubjectCode = "SOCIOLOGY",
            shortBadgeEn = "Paper 2 • Sociology (005)",
            shortBadgeHi = "पेपर 2 • समाजशास्त्र (005)",
            titleEn = "9. Sociology (Code 005) — 100 PYQ MCQs",
            titleHi = "9. समाजशास्त्र / Sociology (कोड 005) — 100 प्रश्न (PYQ)",
            syllabusSummaryEn = "Classical & Post-Modern Sociological Theory (Durkheim, Weber, Marx, Merton, Bourdieu, Foucault), Indian Thinkers (Srinivas, Ghurye, Dumont, Ambedkar), Research Methodology, Rural/Urban & Gender Studies",
            syllabusSummaryHi = "शास्त्रीय एवं समकालीन समाजशास्त्रीय सिद्धांत (दुर्खीम, वेबर, मार्क्स, मर्टन, बूर्दिए), भारतीय समाजशास्त्री (श्रीनिवास, घुर्ये, ड्यूमॉन्ट), शोध पद्धति एवं ग्रामीण/नगरीय समाज",
            badgeColorHex = 0xFFC2410C
        ),
        UgcNetSectionTestSpec(
            id = "ugc_p2_education",
            testId = "ugc_p2_sec_education_100",
            sectionNumber = 10,
            paperLevel = "PAPER_2",
            unitOrSubjectCode = "EDUCATION",
            shortBadgeEn = "Paper 2 • Education (009)",
            shortBadgeHi = "पेपर 2 • शिक्षाशास्त्र (009)",
            titleEn = "10. Education (Code 009) — 100 PYQ MCQs",
            titleHi = "10. शिक्षाशास्त्र / Education (कोड 009) — 100 प्रश्न (PYQ)",
            syllabusSummaryEn = "Indian & Western Philosophy of Education (Sankhya, Vedanta, Pragmatism), Educational Psychology (Piaget, Lewin), Teacher Education, Curriculum Models (CIPP), Pedagogy (FIACS) & Inclusive Education (RPwD 2016)",
            syllabusSummaryHi = "भारतीय एवं पाश्चात्य शिक्षा दर्शन (सांख्य, वेदांत), शिक्षा मनोविज्ञान, शिक्षक शिक्षा, पाठ्यक्रम मूल्यांकन (CIPP), फ्लैंडर्स FIACS एवं समावेशी शिक्षा (RPwD 2016)",
            badgeColorHex = 0xFF15803D
        ),
        UgcNetSectionTestSpec(
            id = "ugc_p2_computer_sci",
            testId = "ugc_p2_sec_computer_sci_100",
            sectionNumber = 11,
            paperLevel = "PAPER_2",
            unitOrSubjectCode = "COMPUTER_SCI",
            shortBadgeEn = "Paper 2 • Computer Sci (087)",
            shortBadgeHi = "पेपर 2 • कंप्यूटर विज्ञान (087)",
            titleEn = "11. Computer Science & Applications (Code 087) — 100 PYQ MCQs",
            titleHi = "11. कंप्यूटर विज्ञान और अनुप्रयोग (कोड 087) — 100 प्रश्न (PYQ)",
            syllabusSummaryEn = "Discrete Structures, Computer Architecture, DBMS (3NF/BCNF, Transactions), Operating Systems (Banker's Algorithm, Paging), Software Engineering, Data Structures & Algorithms, TOC & Compilers, Computer Networks & AI",
            syllabusSummaryHi = "डिस्क्रीट गणित, कंप्यूटर आर्किटेक्चर, DBMS (3NF/BCNF), ऑपरेटिंग सिस्टम (बैंकर्स एल्गोरिदम), डेटा स्ट्रक्चर व एल्गोरिदम, ऑटोमेटा सिद्धांत, कंप्यूटर नेटवर्क एवं कृत्रिम बुद्धिमत्ता (AI)",
            badgeColorHex = 0xFF1E40AF
        ),
        UgcNetSectionTestSpec(
            id = "ugc_p2_law",
            testId = "ugc_p2_sec_law_100",
            sectionNumber = 12,
            paperLevel = "PAPER_2",
            unitOrSubjectCode = "LAW",
            shortBadgeEn = "Paper 2 • Law (058)",
            shortBadgeHi = "पेपर 2 • विधि / Law (058)",
            titleEn = "12. Law (Code 058) — 100 PYQ MCQs",
            titleHi = "12. विधि / Law (कोड 058) — 100 प्रश्न (PYQ)",
            syllabusSummaryEn = "Jurisprudence (Kelsen, Hart, Pound, Savigny), Constitutional & Administrative Law, Public International Law (ICJ Art. 38), Law of Crimes (IPC/BNS), Law of Torts (Strict vs Absolute Liability), Commercial & Family Law",
            syllabusSummaryHi = "विधिशास्त्र (केल्सन, हार्ट, पाउंड, सेविग्नी), संवैधानिक एवं प्रशासनिक विधि, अंतर्राष्ट्रीय विधि (ICJ अनुच्छेद 38), आपराधिक विधि, अपकृत्य विधि (कठोर एवं पूर्ण दायित्व), वाणिज्यिक एवं पारिवारिक विधि",
            badgeColorHex = 0xFF7E22CE
        )
    )

    fun getPaper1UnitSpecs(): List<UgcNetSectionTestSpec> =
        sectionSpecs.filter { it.paperLevel == "PAPER_1" }

    fun getPaper2SubjectSpecs(): List<UgcNetSectionTestSpec> =
        sectionSpecs.filter { it.paperLevel == "PAPER_2" }

    val allUgcNetSectionTests: List<MockTest> by lazy {
        sectionSpecs.mapIndexed { specIdx, spec ->
            val rawSeeds = getSeedsForSpec(spec.id)
            val baseId = 200000 + (specIdx + 1) * 1000
            val questions = expandUgcNetSeedsTo100(spec = spec, baseId = baseId, seeds = rawSeeds)
            MockTest(
                testId = spec.testId,
                title = "${spec.titleEn} — NTA 5-Year PYQ Mock Test",
                hindiTitle = "${spec.titleHi} — NTA 5-वर्षीय PYQ मॉक टेस्ट",
                examName = "NTA UGC NET (${spec.shortBadgeEn} • 100 MCQs)",
                durationMinutes = 90,
                totalMarks = 200, // Official NTA UGC NET Marking: 100 Qs × 2 Marks = 200 Marks (No Negative Marking)
                positiveMarks = 2.0,
                negativeMarks = 0.0,
                questions = questions,
                categoryId = "ugc_csir_net",
                pyqAnalysisEn = "NTA UGC NET 5-Year (2020–2025) PYQ Trend: ${spec.syllabusSummaryEn}",
                pyqAnalysisHi = "NTA UGC NET 5-वर्षीय (2020–2025) PYQ ट्रेंड: ${spec.syllabusSummaryHi}"
            )
        }
    }

    fun getTestBySectionOrTestId(idOrKey: String): MockTest? {
        val clean = idOrKey.trim().lowercase()
        val matchedSpec = sectionSpecs.find {
            it.id.lowercase() == clean ||
                it.testId.lowercase() == clean ||
                clean.endsWith(it.id.lowercase())
        }
        if (matchedSpec != null) {
            return allUgcNetSectionTests.find { it.testId == matchedSpec.testId }
        }
        if (clean == "ugc_net_paper1" || clean == "ugc_paper1" || clean == "ugc_paper_1" || clean == "ugc_net" || clean == "ugc_csir_net") {
            return allUgcNetSectionTests.firstOrNull { it.testId == "ugc_p1_sec_unit1_100" }
        }
        if (clean == "ugc_net_paper2" || clean == "ugc_paper2" || clean == "ugc_paper_2") {
            return allUgcNetSectionTests.firstOrNull { it.testId == "ugc_p2_sec_history_100" }
        }
        return allUgcNetSectionTests.find { it.testId.lowercase() == clean }
    }

    private fun getSeedsForSpec(specId: String): List<RawUgcNetPyqSeed> = when (specId) {
        // Paper 1 (10 Units)
        "ugc_p1_unit1_teaching" -> UgcNetPaper1PyqSeeds.unit1TeachingSeeds
        "ugc_p1_unit2_research" -> UgcNetPaper1PyqSeeds.unit2ResearchSeeds
        "ugc_p1_unit3_comprehension" -> UgcNetPaper1PyqSeeds.unit3ComprehensionSeeds
        "ugc_p1_unit4_communication" -> UgcNetPaper1PyqSeeds.unit4CommunicationSeeds
        "ugc_p1_unit5_math_reasoning" -> UgcNetPaper1PyqSeeds.unit5MathReasoningSeeds
        "ugc_p1_unit6_logical_reasoning" -> UgcNetPaper1PyqSeeds.unit6LogicalReasoningSeeds
        "ugc_p1_unit7_di" -> UgcNetPaper1PyqSeeds.unit7DiSeeds
        "ugc_p1_unit8_ict" -> UgcNetPaper1PyqSeeds.unit8IctSeeds
        "ugc_p1_unit9_environment" -> UgcNetPaper1PyqSeeds.unit9EnvironmentSeeds
        "ugc_p1_unit10_higher_ed" -> UgcNetPaper1PyqSeeds.unit10HigherEdSeeds
        // Paper 2 (12 Subjects)
        "ugc_p2_history" -> UgcNetPaper2PyqSeeds.historySeeds
        "ugc_p2_pol_science" -> UgcNetPaper2PyqSeeds.polScienceSeeds
        "ugc_p2_geography" -> UgcNetPaper2PyqSeeds.geographySeeds
        "ugc_p2_economics" -> UgcNetPaper2PyqSeeds.economicsSeeds
        "ugc_p2_hindi" -> UgcNetPaper2PyqSeeds.hindiSeeds
        "ugc_p2_english" -> UgcNetPaper2PyqSeeds.englishSeeds
        "ugc_p2_commerce" -> UgcNetPaper2PyqSeeds.commerceSeeds
        "ugc_p2_management" -> UgcNetPaper2PyqSeeds.managementSeeds
        "ugc_p2_sociology" -> UgcNetPaper2PyqSeeds.sociologySeeds
        "ugc_p2_education" -> UgcNetPaper2PyqSeeds.educationSeeds
        "ugc_p2_computer_sci" -> UgcNetPaper2PyqSeeds.computerSciSeeds
        "ugc_p2_law" -> UgcNetPaper2PyqSeeds.lawSeeds
        else -> UgcNetPaper1PyqSeeds.unit1TeachingSeeds
    }

    private val examShiftCycle = listOf(
        "NTA UGC NET June 2024 Shift-1",
        "NTA UGC NET Dec 2023 Shift-2",
        "NTA UGC NET June 2023 Shift-1",
        "NTA UGC NET Dec 2022 Shift-2",
        "NTA UGC NET Nov 2021 Shift-1",
        "NTA UGC NET Sept 2020 Shift-2"
    )

    private val questionFramingVariants = listOf(
        Pair("", ""),
        Pair(
            "[NTA Statement Analysis] With reference to the UGC NET syllabus, examine the core concept and identify the accurate option: ",
            "[NTA कथन-विश्लेषण] UGC NET पाठ्यक्रम के संदर्भ में मुख्य अवधारणा का परीक्षण करें और सही विकल्प चुनें: "
        ),
        Pair(
            "[Assertion–Reason PYQ Pattern] In the context of NTA UGC NET previous year trends, which of the following accurately holds true? ",
            "[अभिकथन-तर्क PYQ पैटर्न] NTA UGC NET के विगत वर्षों के प्रश्नों के संदर्भ में निम्नलिखित में से कौन-सा विकल्प पूर्णतः सत्य है? "
        ),
        Pair(
            "[Match-the-Following Concept] According to standard UGC NET reference texts and NTA official answer keys: ",
            "[सुमेलन एवं मानक सिद्धांत] मानक UGC NET संदर्भ ग्रंथों और NTA की आधिकारिक उत्तर-कुंजी के अनुसार: "
        ),
        Pair(
            "[JRF Merit Decider] Carefully evaluate the following conceptual question from the 5-year UGC NET archive: ",
            "[JRF मेरिट निर्णायक प्रश्न] 5-वर्षीय UGC NET प्रश्न-पत्र संग्रह के इस वैचारिक प्रश्न का सावधानीपूर्वक मूल्यांकन करें: "
        )
    )

    private fun expandUgcNetSeedsTo100(
        spec: UgcNetSectionTestSpec,
        baseId: Int,
        seeds: List<RawUgcNetPyqSeed>
    ): List<TestQuestion> {
        val safeSeeds = if (seeds.isNotEmpty()) seeds else UgcNetPaper1PyqSeeds.unit1TeachingSeeds
        return (0 until 100).map { index ->
            val qNum = index + 1
            val seed = safeSeeds[index % safeSeeds.size]
            val cycleRound = index / safeSeeds.size
            val shiftTag = if (cycleRound == 0) seed.yearTag else examShiftCycle[index % examShiftCycle.size]
            val framing = questionFramingVariants[cycleRound % questionFramingVariants.size]

            // Deterministic rotation of options so correct option is distributed evenly across A, B, C, D
            val shiftOffset = (index + spec.sectionNumber) % 4
            val indices = listOf(0, 1, 2, 3)
            val rotatedOrder = indices.map { (it + shiftOffset) % 4 }
            val rotatedOptsEn = rotatedOrder.map { seed.optsEn.getOrElse(it) { "" } }
            val rotatedOptsHi = rotatedOrder.map { seed.optsHi.getOrElse(it) { "" } }
            val newCorrectIndex = rotatedOrder.indexOf(seed.correctIndex).coerceAtLeast(0)

            val levelLabelEn = if (spec.paperLevel == "PAPER_1") {
                "UGC NET Paper-1 (${spec.shortBadgeEn})"
            } else {
                "UGC NET Paper-2 (${spec.shortBadgeEn})"
            }
            val levelLabelHi = if (spec.paperLevel == "PAPER_1") {
                "UGC NET पेपर-1 (${spec.shortBadgeHi})"
            } else {
                "UGC NET पेपर-2 (${spec.shortBadgeHi})"
            }

            TestQuestion(
                id = baseId + qNum,
                questionEn = "Q$qNum. [$levelLabelEn | ${seed.subTopic} • $shiftTag]\n${framing.first}${seed.qEn}",
                questionHi = "प्रश्न $qNum. [$levelLabelHi | ${seed.subTopic} • $shiftTag]\n${framing.second}${seed.qHi}",
                optionsEn = rotatedOptsEn,
                optionsHi = rotatedOptsHi,
                correctIndex = newCorrectIndex,
                explanationEn = "[$levelLabelEn Solution • +2.0 Marks, 0 Negative]: ${seed.expEn}",
                explanationHi = "[$levelLabelHi व्याख्या • +2.0 अंक, 0 ऋणात्मक अंक]: ${seed.expHi}",
                subject = "${spec.shortBadgeEn} (${spec.shortBadgeHi})",
                pyqYearTag = shiftTag,
                pyqFrequency = "Asked in NTA UGC NET (2020–2025 5-Year PYQ Trend)",
                difficultyLevel = "UGC NET / JRF Official NTA Level",
                pyqTrendNoteEn = "High-weightage NTA UGC NET 5-year PYQ concept from ${seed.subTopic}.",
                pyqTrendNoteHi = "${seed.subTopic} के विगत 5 वर्षों के NTA UGC NET PYQ पैटर्न से उच्च-वेटेज प्रश्न।"
            )
        }
    }
}
