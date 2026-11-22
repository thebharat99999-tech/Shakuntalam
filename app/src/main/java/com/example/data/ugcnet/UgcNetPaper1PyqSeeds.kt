package com.example.data.ugcnet

data class RawUgcNetPyqSeed(
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
 * Authentic Last 5 Years (2020–2025) NTA UGC NET Paper 1 (Teaching & Research Aptitude)
 * Bilingual PYQ Seeds covering all 10 Syllabus Units:
 *  Unit I   : Teaching Aptitude (शिक्षण अभिक्षमता)
 *  Unit II  : Research Aptitude (शोध अभिक्षमता)
 *  Unit III : Comprehension (बोधगम्यता / गद्यांश)
 *  Unit IV  : Communication (संप्रेषण)
 *  Unit V   : Mathematical Reasoning and Aptitude (गणितीय तर्क और अभिक्षमता)
 *  Unit VI  : Logical Reasoning & Indian Logic — Pramanas (युक्तियुक्त तर्क एवं भारतीय तर्कशास्त्र)
 *  Unit VII : Data Interpretation (आंकड़ों की व्याख्या — DI)
 *  Unit VIII: Information and Communication Technology — ICT (सूचना और संचार प्रौद्योगिकी)
 *  Unit IX  : People, Development and Environment (लोक, विकास और पर्यावरण)
 *  Unit X   : Higher Education System (उच्च शिक्षा प्रणाली)
 */
object UgcNetPaper1PyqSeeds {

    // ==================== UNIT 1: TEACHING APTITUDE ====================
    val unit1TeachingSeeds: List<RawUgcNetPyqSeed> = listOf(
        RawUgcNetPyqSeed(
            qEn = "Which level of teaching focuses on 'seeing of relationship and tool use of a fact' and was propounded by H.C. Morrison?",
            qHi = "शिक्षण का कौन-सा स्तर 'तथ्यों के बीच संबंध देखने और उनके अनुप्रयोग' पर केंद्रित है तथा जिसका प्रतिपादन एच.सी. मॉरिसन (H.C. Morrison) द्वारा किया गया था?",
            optsEn = listOf(
                "Understanding Level of Teaching (Morrison)",
                "Memory Level of Teaching (Herbart)",
                "Reflective Level of Teaching (Hunt)",
                "Autonomous Development Level (Bigge)"
            ),
            optsHi = listOf(
                "अवबोध स्तर का शिक्षण / Understanding Level (मॉरिसन)",
                "स्मृति स्तर का शिक्षण / Memory Level (हरबर्ट)",
                "चिंतनशील स्तर का शिक्षण / Reflective Level (हंट)",
                "स्वायत्त विकास स्तर (बिग्गे)"
            ),
            expEn = "Memory Level was propounded by Herbart (rote recall), Understanding Level by H.C. Morrison (comprehension & relationship between facts and generalizations), and Reflective Level by Hunt (problem-solving & critical thinking).",
            expHi = "स्मृति स्तर (हरबर्ट), अवबोध स्तर (एच.सी. मॉरिसन — तथ्यों व सिद्धांतों के मध्य संबंध समझना) तथा चिंतनशील स्तर (हंट — समस्या समाधान) शिक्षण के तीन मुख्य स्तर हैं।",
            yearTag = "UGC NET Paper-1 June 2024 PYQ",
            subTopic = "Unit I: Levels of Teaching (Memory, Understanding, Reflective)"
        ),
        RawUgcNetPyqSeed(
            qEn = "Under the SWAYAM platform, which of the following accurately represents the 'Four Quadrants' of MOOCs course design?",
            qHi = "स्वयं (SWAYAM) प्लेटफॉर्म के अंतर्गत MOOCs पाठ्यक्रम डिज़ाइन के 'चार चतुर्थांश' (Four Quadrants) कौन-से हैं?",
            optsEn = listOf(
                "(1) Video Lecture, (2) Specially prepared reading material/e-Text, (3) Self-assessment tests/quizzes, (4) Online discussion forum",
                "(1) Classroom lecture, (2) Printed postal books, (3) Annual written exam, (4) Viva-voce",
                "(1) Radio broadcast, (2) TV telecast, (3) Lab manual, (4) Internship",
                "(1) Podcast, (2) Blog, (3) Wiki, (4) Seminar"
            ),
            optsHi = listOf(
                "(1) वीडियो व्याख्यान, (2) विशेष पठन सामग्री/ई-टेक्स्ट, (3) स्व-मूल्यांकन प्रश्नोत्तरी, (4) ऑनलाइन चर्चा मंच (Discussion Forum)",
                "(1) कक्षा व्याख्यान, (2) डाक पुस्तकें, (3) वार्षिक लिखित परीक्षा, (4) मौखिक परीक्षा",
                "(1) रेडियो प्रसारण, (2) टीवी प्रसारण, (3) प्रयोगशाला मैनुअल, (4) इंटर्नशिप",
                "(1) पॉडकास्ट, (2) ब्लॉग, (3) विकी, (4) सेमिनार"
            ),
            expEn = "SWAYAM courses are hosted in 4 quadrants: Quadrant-I (e-Tutorial Video Lecture), Quadrant-II (e-Content reading material), Quadrant-III (Assessment/Quizzes), and Quadrant-IV (Discussion Forum for doubt clearing).",
            expHi = "SWAYAM के चार चतुर्थांश हैं: (1) वीडियो व्याख्यान, (2) ई-कंटेंट पठन सामग्री, (3) स्व-मूल्यांकन परीक्षण तथा (4) शंका समाधान हेतु ऑनलाइन चर्चा मंच।",
            yearTag = "UGC NET Paper-1 Dec 2023 PYQ",
            subTopic = "Unit I: SWAYAM,SWAYAMPRABHA & MOOCs"
        ),
        RawUgcNetPyqSeed(
            qEn = "Which type of evaluation is conducted during the instructional process to monitor learning progress and provide continuous feedback to both teacher and learner?",
            qHi = "अनुदेशनात्मक प्रक्रिया के दौरान अधिगम की प्रगति की निगरानी करने तथा शिक्षक और शिक्षार्थी दोनों को निरंतर प्रतिपुष्टि (Feedback) प्रदान करने के लिए किस प्रकार का मूल्यांकन किया जाता है?",
            optsEn = listOf(
                "Formative Evaluation (रचनात्मक मूल्यांकन)",
                "Summative Evaluation (योगात्मक मूल्यांकन)",
                "Placement Evaluation (स्थानन मूल्यांकन)",
                "Norm-Referenced Certification"
            ),
            optsHi = listOf(
                "रचनात्मक / निर्माणात्मक मूल्यांकन (Formative Evaluation)",
                "योगात्मक / संकल्पनात्मक मूल्यांकन (Summative Evaluation)",
                "स्थानन मूल्यांकन (Placement Evaluation)",
                "मानक-संदर्भित प्रमाणीकरण"
            ),
            expEn = "Formative evaluation ('Assessment for Learning') occurs during teaching-learning through quizzes, unit tests, and observations to improve instruction, whereas Summative evaluation occurs at the end of a course for grading.",
            expHi = "रचनात्मक मूल्यांकन (Formative Evaluation) शिक्षण प्रक्रिया के दौरान निरंतर फीडबैक एवं सुधार के लिए किया जाता है, जबकि योगात्मक मूल्यांकन सत्र के अंत में ग्रेड देने हेतु होता है।",
            yearTag = "UGC NET Paper-1 June 2023 PYQ",
            subTopic = "Unit I: Evaluation Systems (Formative, Summative, CBCS)"
        ),
        RawUgcNetPyqSeed(
            qEn = "According to Benjamin Bloom's revised cognitive taxonomy (Anderson & Krathwohl, 2001), what is the correct hierarchical order from lowest to highest cognitive process?",
            qHi = "बेंजामिन ब्लूम की संशोधित संज्ञानात्मक वर्गिकी (एंडरसन एवं क्रथवोहल, 2001) के अनुसार निम्नतम से उच्चतम संज्ञानात्मक प्रक्रिया का सही पदानुक्रम क्या है?",
            optsEn = listOf(
                "Remembering → Understanding → Applying → Analyzing → Evaluating → Creating",
                "Knowledge → Comprehension → Application → Analysis → Synthesis → Evaluation",
                "Understanding → Remembering → Applying → Evaluating → Analyzing → Creating",
                "Remembering → Applying → Understanding → Analyzing → Creating → Evaluating"
            ),
            optsHi = listOf(
                "स्मरण करना (Remembering) → समझना → अनुप्रयोग करना → विश्लेषण करना → मूल्यांकन करना → सृजन करना (Creating)",
                "ज्ञान → बोध → अनुप्रयोग → विश्लेषण → संश्लेषण → मूल्यांकन",
                "समझना → स्मरण करना → अनुप्रयोग → मूल्यांकन → विश्लेषण → सृजन",
                "स्मरण → अनुप्रयोग → समझना → विश्लेषण → सृजन → मूल्यांकन"
            ),
            expEn = "In the 2001 revised Bloom's Taxonomy, nouns were changed to action verbs and 'Creating' was placed at the apex above 'Evaluating': Remember → Understand → Apply → Analyze → Evaluate → Create.",
            expHi = "2001 की संशोधित ब्लूम टैक्सोनॉमी में क्रिया रूपों का प्रयोग किया गया और 'सृजन करना' (Creating) को सर्वोच्च स्तर पर रखा गया।",
            yearTag = "UGC NET Paper-1 Dec 2022 PYQ",
            subTopic = "Unit I: Bloom's Taxonomy & Teaching Objectives"
        ),
        RawUgcNetPyqSeed(
            qEn = "Lev Vygotsky's concept of 'Zone of Proximal Development' (ZPD) refers to:",
            qHi = "लेव वायगोत्स्की की 'समीपस्थ विकास का क्षेत्र' (Zone of Proximal Development — ZPD) अवधारणा किससे संबंधित है?",
            optsEn = listOf(
                "The gap between what a learner can do independently and what they can achieve with guidance/scaffolding from a More Knowledgeable Other (MKO)",
                "Fixed biological maturation stages independent of social interaction",
                "Classical conditioning through stimulus-response pairing",
                "Rote memorization capacity of a learner in a formal test"
            ),
            optsHi = listOf(
                "शिक्षार्थी द्वारा स्वतंत्र रूप से किए जा सकने वाले कार्य और किसी अधिक जानकार व्यक्ति (MKO) के मार्गदर्शन (Scaffolding) से किए जा सकने वाले कार्य के बीच का अंतर",
                "सामाजिक अंतःक्रिया से स्वतंत्र निश्चित जैविक परिपक्वता अवस्थाएं",
                "उद्दीपन-अनुक्रिया युग्मन द्वारा शास्त्रीय अनुबंधन",
                "औपचारिक परीक्षा में रटने की क्षमता"
            ),
            expEn = "Vygotsky's socio-cultural theory defines ZPD as the distance between actual developmental level (independent problem solving) and potential development through scaffolding by teachers/peers.",
            expHi = "वायगोत्स्की के सामाजिक-सांस्कृतिक सिद्धांत के अनुसार ZPD स्वतंत्र समस्या समाधान और मार्गदर्शन (Scaffolding) द्वारा संभावित विकास के बीच का क्षेत्र है।",
            yearTag = "UGC NET Paper-1 June 2024 PYQ",
            subTopic = "Unit I: Learner Characteristics & Constructivism"
        )
    )

    // ==================== UNIT 2: RESEARCH APTITUDE ====================
    val unit2ResearchSeeds: List<RawUgcNetPyqSeed> = listOf(
        RawUgcNetPyqSeed(
            qEn = "When a researcher rejects a true Null Hypothesis (H₀), what type of statistical error is committed, and what denotes its probability?",
            qHi = "जब कोई शोधकर्ता एक सत्य शून्य परिकल्पना (Null Hypothesis — H₀) को अस्वीकार कर देता है, तो किस प्रकार की सांख्यिकीय त्रुटि होती है और इसकी प्रायिकता को किससे दर्शाया जाता है?",
            optsEn = listOf(
                "Type-I Error (Alpha α — Level of Significance)",
                "Type-II Error (Beta β)",
                "Standard Error of Mean",
                "Sampling Frame Bias"
            ),
            optsHi = listOf(
                "टाइप-I त्रुटि (Type-I Error — अल्फा α / सार्थकता स्तर)",
                "टाइप-II त्रुटि (Type-II Error — बीटा β)",
                "माध्य की मानक त्रुटि",
                "प्रतिचयन ढांचा पूर्वाग्रह"
            ),
            expEn = "Rejecting a true Null Hypothesis (H₀) is a Type-I Error (false positive), whose probability is α (level of significance). Accepting a false H₀ is a Type-II Error (β).",
            expHi = "सत्य शून्य परिकल्पना (H₀) को अस्वीकार करना टाइप-I त्रुटि (α) कहलाता है, जबकि असत्य शून्य परिकल्पना को स्वीकार करना टाइप-II त्रुटि (β) कहलाता है।",
            yearTag = "UGC NET Paper-1 June 2024 PYQ",
            subTopic = "Unit II: Hypothesis Testing (Type-I & Type-II Errors)"
        ),
        RawUgcNetPyqSeed(
            qEn = "Which type of research is cyclical in nature (Plan → Act → Observe → Reflect) and is conducted by practitioners/teachers to solve an immediate local classroom problem?",
            qHi = "कौन-सा शोध प्रकृति में चक्रीय (योजना → क्रिया → अवलोकन → चिंतन / Plan → Act → Observe → Reflect) होता है और किसी तात्कालिक स्थानीय समस्या के समाधान हेतु शिक्षकों/अभ्यासकर्ताओं द्वारा किया जाता है?",
            optsEn = listOf(
                "Action Research (क्रियात्मक शोध — Kurt Lewin)",
                "Ex-post Facto Research (कार्य्योत्तर शोध)",
                "Fundamental / Pure Research (मौलिक शोध)",
                "Historical Research (ऐतिहासिक शोध)"
            ),
            optsHi = listOf(
                "क्रियात्मक शोध (Action Research — कर्ट लेविन)",
                "कार्य्योत्तर शोध (Ex-post Facto Research)",
                "मौलिक / विशुद्ध शोध (Fundamental Research)",
                "ऐतिहासिक शोध (Historical Research)"
            ),
            expEn = "Action Research (coined by Kurt Lewin and applied to education by Stephen Corey) follows the spiral cycle Plan → Act → Observe → Reflect for immediate local improvement.",
            expHi = "क्रियात्मक शोध (Action Research) तात्कालिक समस्या समाधान पर केंद्रित होता है और इसका चक्र 'योजना → क्रिया → अवलोकन → चिंतन' (Plan → Act → Observe → Reflect) होता है।",
            yearTag = "UGC NET Paper-1 Dec 2023 PYQ",
            subTopic = "Unit II: Methods of Research (Action & Ex-post Facto)"
        ),
        RawUgcNetPyqSeed(
            qEn = "Which of the following is a NON-PROBABILITY sampling technique where existing study subjects recruit future subjects from among their acquaintances?",
            qHi = "निम्नलिखित में से कौन-सी एक गैर-संभाव्यता प्रतिचयन (Non-Probability Sampling) तकनीक है जिसमें मौजूदा उत्तरदाता अपने परिचितों में से आगे के उत्तरदाताओं को जोड़ते हैं?",
            optsEn = listOf(
                "Snowball Sampling (स्नोबॉल / चेन-रेफरल प्रतिचयन)",
                "Stratified Random Sampling (स्तरित यादृच्छिक प्रतिचयन)",
                "Systematic Sampling (व्यवस्थित प्रतिचयन)",
                "Cluster Sampling (गुच्छ प्रतिचयन)"
            ),
            optsHi = listOf(
                "स्नोबॉल प्रतिचयन (Snowball / Chain-Referral Sampling)",
                "स्तरित यादृच्छिक प्रतिचयन (Stratified Random Sampling)",
                "व्यवस्थित प्रतिचयन (Systematic Sampling)",
                "गुच्छ प्रतिचयन (Cluster Sampling)"
            ),
            expEn = "Snowball sampling (chain-referral sampling) is a non-probability sampling method used for hard-to-reach populations. Stratified, Systematic, and Cluster are probability sampling methods.",
            expHi = "स्नोबॉल प्रतिचयन, कोटा प्रतिचयन, उद्देश्यपूर्ण (Purposive) और सुविधाजनक प्रतिचयन गैर-संभाव्यता (Non-probability) प्रतिचयन की विधियां हैं।",
            yearTag = "UGC NET Paper-1 June 2023 PYQ",
            subTopic = "Unit II: Probability vs Non-Probability Sampling"
        ),
        RawUgcNetPyqSeed(
            qEn = "According to UGC (Promotion of Academic Integrity and Prevention of Plagiarism in Higher Educational Institutions) Regulations 2018, up to what percentage of similarity is categorized as 'Level 0' (attracting no penalty)?",
            qHi = "यूजीसी (उच्च शिक्षण संस्थानों में अकादमिक सत्यनिष्ठा एवं साहित्यिक चोरी की रोकथाम) विनियम 2018 के अनुसार, कितने प्रतिशत तक की समानता (Similarity) को 'स्तर 0' (Level 0 — कोई दंड नहीं) में रखा गया है?",
            optsEn = listOf(
                "Up to 10% similarity (Level 0 — Minor similarities, no penalty)",
                "10% to 40% similarity (Level 1)",
                "40% to 60% similarity (Level 2)",
                "Above 60% similarity (Level 3)"
            ),
            optsHi = listOf(
                "10% तक समानता (Level 0 — कोई दंड नहीं)",
                "10% से 40% तक समानता (Level 1)",
                "40% से 60% तक समानता (Level 2)",
                "60% से अधिक समानता (Level 3)"
            ),
            expEn = "UGC Plagiarism Regulations 2018: Level 0 (up to 10% — no penalty), Level 1 (10% to 40% — submit revised script within 6 months), Level 2 (40% to 60% — debarred for 1 year), Level 3 (>60% — registration cancelled).",
            expHi = "UGC साहित्यिक चोरी विनियम 2018 के अनुसार: Level 0 (10% तक समानता — कोई दंड नहीं), Level 1 (10%–40%), Level 2 (40%–60%) तथा Level 3 (60% से अधिक — पंजीकरण रद्द)।",
            yearTag = "UGC NET Paper-1 Dec 2023 PYQ",
            subTopic = "Unit II: Research Ethics & UGC Plagiarism Regulations"
        ),
        RawUgcNetPyqSeed(
            qEn = "Which paradigm of research believes that social reality is objective, external to the researcher, and measurable through empirical quantitative methods?",
            qHi = "शोध का कौन-सा प्रतिमान (Paradigm) मानता है कि सामाजिक यथार्थ वस्तुनिष्ठ है, शोधकर्ता से बाह्य है और आनुभविक मात्रात्मक विधियों द्वारा मापने योग्य है?",
            optsEn = listOf(
                "Positivism (प्रत्यक्षवाद — Auguste Comte)",
                "Interpretivism / Constructivism (व्याख्यावाद / रचनावाद)",
                "Critical Theory",
                "Phenomenology"
            ),
            optsHi = listOf(
                "प्रत्यक्षवाद (Positivism — ऑगस्ट कॉम्टे)",
                "व्याख्यावाद / रचनावाद (Interpretivism)",
                "आलोचनात्मक सिद्धांत",
                "प्रघटनाशास्त्र (Phenomenology)"
            ),
            expEn = "Positivism emphasizes objective, empirical observation, scientific verification, and quantitative measurement, whereas Post-positivism acknowledges probabilistic knowledge and human fallibility.",
            expHi = "प्रत्यक्षवाद (Positivism) वैज्ञानिक अनुभवजन्य अवलोकन, वस्तुनिष्ठता और मात्रात्मक मापन पर बल देता है, जबकि उत्तर-प्रत्यक्षवाद संभाव्यता को स्वीकार करता है।",
            yearTag = "UGC NET Paper-1 June 2024 PYQ",
            subTopic = "Unit II: Positivism & Post-Positivistic Approach"
        )
    )

    // ==================== UNIT 3: COMPREHENSION ====================
    val unit3ComprehensionSeeds: List<RawUgcNetPyqSeed> = listOf(
        RawUgcNetPyqSeed(
            qEn = "Read the academic passage excerpt:\n'Sustainable development is not merely an environmental doctrine; it is an intergenerational social contract that balances economic vitality, ecological resilience, and social equity without compromising the resource endowment of future citizens.'\nWhat is the central thesis of the author in this passage?",
            qHi = "अकादमिक गद्यांश के अंश को पढ़ें:\n'सतत विकास केवल एक पर्यावरणीय सिद्धांत नहीं है; यह एक अंतर-पीढ़ीगत सामाजिक अनुबंध है जो भावी नागरिकों की संसाधन संपदा से समझौता किए बिना आर्थिक जीवंतता, पारिस्थितिक लचीलापन और सामाजिक समता में संतुलन स्थापित करता है।'\nइस गद्यांश में लेखक का केंद्रीय विचार (Central Thesis) क्या है?",
            optsEn = listOf(
                "Sustainable development integrates economic, ecological, and social dimensions as an ethical duty toward future generations",
                "Economic growth must be completely halted to preserve forests",
                "Sustainable development is solely concerned with pollution control laws",
                "Future generations will not require natural resources due to automation"
            ),
            optsHi = listOf(
                "सतत विकास भावी पीढ़ियों के प्रति नैतिक दायित्व के रूप में आर्थिक, पारिस्थितिक और सामाजिक आयामों को एकीकृत करता है",
                "वनों को बचाने के लिए आर्थिक विकास को पूरी तरह रोक देना चाहिए",
                "सतत विकास का संबंध केवल प्रदूषण नियंत्रण कानूनों से है",
                "स्वचालन के कारण भावी पीढ़ियों को प्राकृतिक संसाधनों की आवश्यकता नहीं होगी"
            ),
            expEn = "The passage explicitly defines sustainable development as an 'intergenerational social contract' balancing three pillars: economic vitality, ecological resilience, and social equity.",
            expHi = "गद्यांश में स्पष्ट रूप से सतत विकास को आर्थिक, पारिस्थितिक और सामाजिक समता के तीन स्तंभों को संतुलित करने वाले 'अंतर-पीढ़ीगत सामाजिक अनुबंध' के रूप में परिभाषित किया गया है।",
            yearTag = "UGC NET Paper-1 June 2024 PYQ",
            subTopic = "Unit III: Reading Comprehension — Central Idea & Inference"
        ),
        RawUgcNetPyqSeed(
            qEn = "Passage Excerpt:\n'While digital algorithms democratize access to vast repositories of information, they simultaneously create echo chambers by curating content that reinforces pre-existing cognitive biases rather than challenging them.'\nWhich of the following can be validly inferred from the passage?",
            qHi = "गद्यांश अंश:\n'जहाँ डिजिटल एल्गोरिदम सूचना के विशाल भंडार तक पहुँच का लोकतंत्रीकरण करते हैं, वहीं वे पूर्व-विद्यमान संज्ञानात्मक पूर्वाग्रहों को चुनौती देने के बजाय उन्हें पुष्ट करने वाली सामग्री परोसकर प्रतिध्वनि कक्ष (Echo Chambers) भी निर्मित करते हैं।'\nगद्यांश से निम्नलिखित में से कौन-सा वैध निष्कर्ष निकाला जा सकता है?",
            optsEn = listOf(
                "Algorithmic curation has a dual impact: expanding information access while narrowing intellectual diversity through confirmation bias",
                "Digital algorithms eliminate all human cognitive biases automatically",
                "Information repositories are inaccessible to the general public",
                "Echo chambers encourage open-minded debate across opposing viewpoints"
            ),
            optsHi = listOf(
                "एल्गोरिदमिक चयन का दोहरा प्रभाव है: यह सूचना पहुँच को बढ़ाता है किंतु पुष्टिकरण पूर्वाग्रह द्वारा बौद्धिक विविधता को संकुचित भी करता है",
                "डिजिटल एल्गोरिदम सभी मानवीय पूर्वाग्रहों को स्वतः समाप्त कर देते हैं",
                "सूचना भंडार आम जनता की पहुँच से बाहर हैं",
                "प्रतिध्वनि कक्ष विरोधी दृष्टिकोणों के बीच खुली बहस को प्रोत्साहित करते हैं"
            ),
            expEn = "The author contrasts the positive aspect ('democratize access') with the negative consequence ('create echo chambers... reinforces pre-existing cognitive biases').",
            expHi = "लेखक ने डिजिटल एल्गोरिदम के सकारात्मक पक्ष (सूचना की सुलभता) और नकारात्मक प्रभाव (इको चैंबर एवं पूर्वाग्रहों की पुष्टि) दोनों का विश्लेषण किया है।",
            yearTag = "UGC NET Paper-1 Dec 2023 PYQ",
            subTopic = "Unit III: Analytical Reading Comprehension & Tone Analysis"
        ),
        RawUgcNetPyqSeed(
            qEn = "Passage Excerpt:\n'Epistemic humility in scientific inquiry demands that every theory be treated as provisional—open to falsification when confronted with anomalous empirical evidence, as Karl Popper famously argued.'\nAccording to the passage, what characterizes genuine scientific inquiry?",
            qHi = "गद्यांश अंश:\n'वैज्ञानिक अन्वेषण में ज्ञानमीमांसीय विनम्रता की मांग है कि प्रत्येक सिद्धांत को अनंतिम (Provisional) माना जाए—जो विपरीत आनुभविक साक्ष्य मिलने पर मिथ्याकरण (Falsification) के लिए खुला हो, जैसा कि कार्ल पॉपर ने तर्क दिया था।'\nगद्यांश के अनुसार वास्तविक वैज्ञानिक अन्वेषण की विशेषता क्या है?",
            optsEn = listOf(
                "Openness to revision and falsification in light of new empirical evidence",
                "Dogmatic adherence to established theories regardless of contrary data",
                "Rejection of all empirical observation in favour of pure speculation",
                "Treating scientific theories as absolute, unchangeable dogmas"
            ),
            optsHi = listOf(
                "नए आनुभविक साक्ष्यों के आलोक में संशोधन और मिथ्याकरण (Falsification) के प्रति खुलापन",
                "विपरीत आंकड़ों के बावजूद स्थापित सिद्धांतों से कट्टरतापूर्वक चिपके रहना",
                "कोरी कल्पना के पक्ष में सभी आनुभविक अवलोकनों को अस्वीकार करना",
                "वैज्ञानिक सिद्धांतों को अपरिवर्तनीय और अंतिम सत्य मानना"
            ),
            expEn = "The passage highlights 'epistemic humility' and Karl Popper's criterion of falsifiability—scientific theories are provisional and subject to testing against empirical data.",
            expHi = "गद्यांश के अनुसार वैज्ञानिक सिद्धांत अंतिम या जड़ नहीं होते, बल्कि नए आनुभविक साक्ष्यों के आधार पर परीक्षण एवं संशोधन के लिए सदैव खुले रहते हैं।",
            yearTag = "UGC NET Paper-1 June 2023 PYQ",
            subTopic = "Unit III: Scientific & Philosophical Passage Comprehension"
        ),
        RawUgcNetPyqSeed(
            qEn = "Passage Excerpt:\n'Multidisciplinary higher education, as envisioned in NEP 2020, dismantles rigid silos between humanities, sciences, and vocational streams, fostering holistic problem-solvers capable of navigating complex 21st-century challenges.'\nThe phrase 'dismantles rigid silos' in the passage most nearly means:",
            qHi = "गद्यांश अंश:\n'NEP 2020 में परिकल्पित बहु-विषयक उच्च शिक्षा मानविकी, विज्ञान और व्यावसायिक धाराओं के बीच की कठोर दीवारों (Rigid Silos) को समाप्त करती है, जिससे समग्र समस्या-समाधानकर्ता तैयार होते हैं।'\nगद्यांश में प्रयुक्त वाक्यांश 'कठोर दीवारों को समाप्त करती है' (dismantles rigid silos) का निकटतम अर्थ क्या है?",
            optsEn = listOf(
                "Removes artificial isolation and strict boundaries between academic disciplines",
                "Builds physical grain storage towers inside university campuses",
                "Restricts students from choosing elective subjects outside their major",
                "Eliminates science and vocational laboratories from colleges"
            ),
            optsHi = listOf(
                "विभिन्न अकादमिक विषयों के बीच के कृत्रिम अलगाव और कठोर सीमाओं को हटाना",
                "विश्वविद्यालय परिसरों में अनाज भंडारण टावर बनाना",
                "छात्रों को अपने मुख्य विषय के बाहर वैकल्पिक विषय चुनने से रोकना",
                "कॉलेजों से विज्ञान और व्यावसायिक प्रयोगशालाओं को समाप्त करना"
            ),
            expEn = "In academic discourse, 'silos' metaphorically refers to isolated compartments or strict separation between departments/streams; dismantling them means integrating disciplines.",
            expHi = "यहाँ 'Rigid Silos' का लाक्षणिक अर्थ विभिन्न संकायों (कला, विज्ञान, वाणिज्य) के बीच के कठोर अलगाव से है, जिसे बहु-विषयक शिक्षा समाप्त करती है।",
            yearTag = "UGC NET Paper-1 Dec 2022 PYQ",
            subTopic = "Unit III: Contextual Vocabulary & Metaphorical Meaning"
        )
    )

    // ==================== UNIT 4: COMMUNICATION ====================
    val unit4CommunicationSeeds: List<RawUgcNetPyqSeed> = listOf(
        RawUgcNetPyqSeed(
            qEn = "In communication studies, what do 'Proxemics', 'Kinesics', and 'Chronemics' refer to respectively?",
            qHi = "संप्रेषण अध्ययन में 'प्रॉक्सेमिक्स' (Proxemics), 'काइनेसिक्स' (Kinesics) और 'क्रोनेमिक्स' (Chronemics) क्रमशः किससे संबंधित हैं?",
            optsEn = listOf(
                "Proxemics: Use of space/distance | Kinesics: Body language/facial expressions | Chronemics: Use of time",
                "Proxemics: Voice pitch | Kinesics: Touch (Haptics) | Chronemics: Eye contact (Oculesics)",
                "Proxemics: Time management | Kinesics: Spatial distance | Chronemics: Gestures",
                "Proxemics: Written symbols | Kinesics: Mass media | Chronemics: Grapevine"
            ),
            optsHi = listOf(
                "प्रॉक्सेमिक्स: स्थान/दूरी का उपयोग | काइनेसिक्स: शारीरिक भाषा/हाव-भाव | क्रोनेमिक्स: समय का उपयोग",
                "प्रॉक्सेमिक्स: स्वर का उतार-चढ़ाव | काइनेसिक्स: स्पर्श | क्रोनेमिक्स: नेत्र संपर्क",
                "प्रॉक्सेमिक्स: समय प्रबंधन | काइनेसिक्स: स्थानिक दूरी | क्रोनेमिक्स: मुद्राएं",
                "प्रॉक्सेमिक्स: लिखित प्रतीक | काइनेसिक्स: जनसंचार | क्रोनेमिक्स: अंगूरीलता"
            ),
            expEn = "Non-verbal communication codes: Proxemics (personal space/physical distance — Edward T. Hall), Kinesics (body movements, postures, gestures), Chronemics (perception and use of time), Haptics (touch), Paralanguage/Vocalics (tone, pitch).",
            expHi = "अशाब्दिक संप्रेषण में प्रॉक्सेमिक्स (स्थान/दूरी), काइनेसिक्स (शारीरिक हाव-भाव), क्रोनेमिक्स (समय का महत्व) तथा हैप्टिक्स (स्पर्श) प्रमुख हैं।",
            yearTag = "UGC NET Paper-1 June 2024 PYQ",
            subTopic = "Unit IV: Non-Verbal Communication Codes"
        ),
        RawUgcNetPyqSeed(
            qEn = "Which model of communication introduced the concept of 'Semantic Noise' / 'Mechanical Noise' and consists of Information Source, Transmitter, Channel, Receiver, and Destination?",
            qHi = "संप्रेषण के किस मॉडल ने 'शोर' (Noise) की अवधारणा प्रस्तुत की और जिसमें सूचना स्रोत, ट्रांसमीटर, चैनल, रिसीवर तथा गंतव्य शामिल हैं?",
            optsEn = listOf(
                "Shannon and Weaver's Mathematical Model (1949)",
                "Aristotle's Linear Rhetoric Model",
                "Berlo's SMCR Model (1960)",
                "Barnlund's Transactional Model"
            ),
            optsHi = listOf(
                "शैनन और वीवर का गणितीय मॉडल (Shannon & Weaver Model, 1949)",
                "अरस्तू का रेखीय मॉडल",
                "बर्लो का SMCR मॉडल (1960)",
                "बार्नलंड का संव्यवहार मॉडल"
            ),
            expEn = "Claude Shannon and Warren Weaver (1949) formulated the Mathematical Theory of Communication (Mother of all models), highlighting Channel Noise affecting signal transmission.",
            expHi = "शैनन और वीवर (1949) के मॉडल को 'सभी मॉडलों की जननी' कहा जाता है, जिसने संप्रेषण प्रक्रिया में 'शोर' (Noise) और एंट्रॉपी की भूमिका स्पष्ट की।",
            yearTag = "UGC NET Paper-1 Dec 2023 PYQ",
            subTopic = "Unit IV: Models of Communication"
        ),
        RawUgcNetPyqSeed(
            qEn = "When a person communicates with oneself (internal monologue, self-reflection, daydreaming), it is termed as ____; whereas informal rumor-based organizational communication is called ____:",
            qHi = "जब कोई व्यक्ति स्वयं से संवाद करता है (आंतरिक चिंतन, आत्म-मंथन), तो उसे ____ कहा जाता है; जबकि संगठन में अनौपचारिक संचार नेटवर्क को ____ कहा जाता है:",
            optsEn = listOf(
                "Intrapersonal Communication and Grapevine Communication",
                "Interpersonal Communication and Downward Communication",
                "Group Communication and Vertical Communication",
                "Mass Communication and Horizontal Communication"
            ),
            optsHi = listOf(
                "अंतःवैयक्तिक संप्रेषण (Intrapersonal) तथा अंगूरीलता संप्रेषण (Grapevine)",
                "अंतर-वैयक्तिक संप्रेषण (Interpersonal) तथा अधोमुखी संप्रेषण",
                "समूह संप्रेषण तथा ऊर्ध्वाधर संप्रेषण",
                "जनसंचार तथा क्षैतिज संप्रेषण"
            ),
            expEn = "Intrapersonal communication takes place within a single individual's mind, Interpersonal is between two or more people, and Grapevine (coined by Keith Davis) is informal organizational communication.",
            expHi = "स्वयं के भीतर होने वाला चिंतन अंतःवैयक्तिक (Intrapersonal) संप्रेषण कहलाता है, जबकि अनौपचारिक संगठनात्मक संचार को अंगूरीलता (Grapevine) कहते हैं।",
            yearTag = "UGC NET Paper-1 June 2023 PYQ",
            subTopic = "Unit IV: Types & Barriers of Communication"
        )
    )

    // ==================== UNIT 5: MATHEMATICAL REASONING & APTITUDE ====================
    val unit5MathReasoningSeeds: List<RawUgcNetPyqSeed> = listOf(
        RawUgcNetPyqSeed(
            qEn = "Find the next term in the number series: 2, 6, 12, 20, 30, 42, ?",
            qHi = "संख्या श्रृंखला में अगला पद ज्ञात कीजिए: 2, 6, 12, 20, 30, 42, ?",
            optsEn = listOf("56", "54", "52", "60"),
            optsHi = listOf("56", "54", "52", "60"),
            expEn = "The terms follow n(n + 1): 1×2 = 2, 2×3 = 6, 3×4 = 12, 4×5 = 20, 5×6 = 30, 6×7 = 42, 7×8 = 56 (differences are +4, +6, +8, +10, +12, +14).",
            expHi = "श्रृंखला के पदों का अंतर +4, +6, +8, +10, +12, +14 है (अथवा n(n+1) पैटर्न: 7 × 8 = 56)। अतः अगला पद 42 + 14 = 56 है।",
            yearTag = "UGC NET Paper-1 June 2024 PYQ",
            subTopic = "Unit V: Number Series & Letter Series"
        ),
        RawUgcNetPyqSeed(
            qEn = "If the difference between Compound Interest (compounded annually) and Simple Interest on a certain sum at 10% per annum for 2 years is ₹ 65, what is the principal sum?",
            qHi = "यदि किसी धनराशि पर 10% वार्षिक दर से 2 वर्ष के चक्रवृद्धि ब्याज (वार्षिक संयोजित) और साधारण ब्याज का अंतर ₹ 65 है, तो मूलधन क्या है?",
            optsEn = listOf("₹ 6,500", "₹ 6,000", "₹ 5,500", "₹ 13,000"),
            optsHi = listOf("₹ 6,500", "₹ 6,000", "₹ 5,500", "₹ 13,000"),
            expEn = "For 2 years, CI - SI = P (R / 100)². Thus 65 = P × (10 / 100)² = P / 100 ⇒ P = ₹ 6,500.",
            expHi = "2 वर्ष के लिए CI - SI = P(R/100)²। अतः 65 = P × (10/100)² = P/100 ⇒ मूलधन P = ₹ 6,500।",
            yearTag = "UGC NET Paper-1 Dec 2023 PYQ",
            subTopic = "Unit V: Simple & Compound Interest"
        ),
        RawUgcNetPyqSeed(
            qEn = "In a certain code language, if 'TEACHER' is coded as 'VGCEJGT', how will 'STUDENT' be coded in that same language?",
            qHi = "एक निश्चित कूट भाषा में यदि 'TEACHER' को 'VGCEJGT' लिखा जाता है, तो उसी कूट भाषा में 'STUDENT' को कैसे लिखा जाएगा?",
            optsEn = listOf("UVWFGPV", "UVWFGPW", "TUVEFou", "UWVFGPV"),
            optsHi = listOf("UVWFGPV", "UVWFGPW", "TUVEFou", "UWVFGPV"),
            expEn = "Each letter is shifted forward by +2 positions in the English alphabet: S(+2)=U, T(+2)=V, U(+2)=W, D(+2)=F, E(+2)=G, N(+2)=P, T(+2)=V → UVWFGPV.",
            expHi = "प्रत्येक अक्षर में +2 की वृद्धि की गई है: S→U, T→V, U→W, D→F, E→G, N→P, T→V ⇒ UVWFGPV।",
            yearTag = "UGC NET Paper-1 June 2023 PYQ",
            subTopic = "Unit V: Coding-Decoding & Blood Relations"
        )
    )

    // ==================== UNIT 6: LOGICAL REASONING & INDIAN LOGIC ====================
    val unit6LogicalReasoningSeeds: List<RawUgcNetPyqSeed> = listOf(
        RawUgcNetPyqSeed(
            qEn = "In Classical Indian Logic (Nyaya Philosophy), the fallacy of 'Savyabhichara' (Irregular Middle Term), as in 'All bipeds are rational; swans are bipeds; therefore swans are rational', is a subtype of:",
            qHi = "भारतीय न्याय दर्शन (Indian Logic) में 'सव्यभिचार' (अनैकान्तिक हेतु), किस प्रकार के हेत्वाभास (Fallacy of Middle Term / Hetvabhasa) का भेद है?",
            optsEn = listOf(
                "Hetvabhasa — Fallacy of the Irregular/Erratic Middle Term (Savyabhichara / Anaikantika)",
                "Upamana (Comparison)",
                "Anupalabdhi (Non-apprehension)",
                "Arthapatti (Postulation)"
            ),
            optsHi = listOf(
                "हेत्वाभास — अनैकान्तिक / सव्यभिचार हेत्वाभास (Irregular Middle Term)",
                "उपमान प्रमाण",
                "अनुपलब्धि प्रमाण",
                "अर्थापत्ति प्रमाण"
            ),
            expEn = "Nyaya recognizes five Hetvabhasas (fallacies of Hetu/middle term): Savyabhichara (irregular middle), Viruddha (contradictory), Satpratipaksha (inferentially contradicted), Asiddha (unproved), and Badhita (sublated).",
            expHi = "न्याय दर्शन में पाँच हेत्वाभास माने गए हैं: सव्यभिचार (अनैकान्तिक), विरुद्ध, सत्प्रतिपक्ष, असिद्ध और बाधित।",
            yearTag = "UGC NET Paper-1 June 2024 PYQ",
            subTopic = "Unit VI: Indian Logic — Pramanas & Hetvabhasa"
        ),
        RawUgcNetPyqSeed(
            qEn = "'Fat Devadatta does not eat during the day; therefore, he must be eating at night.' According to Advaita Vedanta and Mimamsa philosophy, which Pramana (means of valid knowledge) is used here?",
            qHi = "'मोटा देवदत्त दिन में भोजन नहीं करता है; अतः वह निश्चित ही रात में भोजन करता होगा।' अद्वैत वेदांत और मीमांसा दर्शन के अनुसार यहाँ कौन-सा प्रमाण प्रयुक्त हुआ है?",
            optsEn = listOf(
                "Arthapatti (Postulation / Presumption)",
                "Upamana (Comparison / Analogy)",
                "Anupalabdhi (Non-cognition)",
                "Pratyaksha (Perception)"
            ),
            optsHi = listOf(
                "अर्थापत्ति प्रमाण (Postulation / Presumption)",
                "उपमान प्रमाण (Comparison)",
                "अनुपलब्धि प्रमाण (Non-apprehension)",
                "प्रत्यक्ष प्रमाण (Perception)"
            ),
            expEn = "Arthapatti is the postulation or presumption of an unperceived fact (eating at night) to resolve an apparent contradiction between two known facts (Devadatta is fat, yet he fasts during the day).",
            expHi = "दो दृष्ट तथ्यों (देवदत्त का मोटा होना और दिन में न खाना) के विरोध का समाधान करने के लिए अदृष्ट तथ्य (रात में खाना) की कल्पना करना 'अर्थापत्ति' प्रमाण कहलाता है।",
            yearTag = "UGC NET Paper-1 Dec 2023 PYQ",
            subTopic = "Unit VI: Six Pramanas (Pratyaksha, Anumana, Upamana, Shabda, Arthapatti, Anupalabdhi)"
        ),
        RawUgcNetPyqSeed(
            qEn = "In the Classical Square of Opposition, if the Universal Affirmative proposition 'All S are P' (A) is given as TRUE, what can be immediately inferred about 'Some S are not P' (O) and 'No S are P' (E)?",
            qHi = "विरोध के शास्त्रीय वर्ग (Classical Square of Opposition) में, यदि सर्वव्यापी सकारात्मक तर्कवाक्य 'सभी S, P हैं' (A) सत्य (TRUE) है, तो 'कुछ S, P नहीं हैं' (O) और 'कोई S, P नहीं है' (E) के बारे में क्या निष्कर्ष निकलेगा?",
            optsEn = listOf(
                "Both O (Contradictory) and E (Contrary) are definitely FALSE, while I (Subaltern) is TRUE",
                "Both O and E are TRUE",
                "O is FALSE while E is Undetermined",
                "E is FALSE while O is TRUE"
            ),
            optsHi = listOf(
                "O (व्याघाती) और E (विपरीत) दोनों निश्चित रूप से असत्य (FALSE) हैं, जबकि I (उपाश्रित) सत्य (TRUE) है",
                "O और E दोनों सत्य हैं",
                "O असत्य है जबकि E अनिर्धारित है",
                "E असत्य है जबकि O सत्य है"
            ),
            expEn = "When 'A' (All S are P) is True: its Contradictory 'O' (Some S are not P) is False, its Contrary 'E' (No S are P) is False, and its Subaltern 'I' (Some S are P) is True.",
            expHi = "जब 'A' सत्य होता है, तो उसका व्याघाती (Contradictory) 'O' तथा विपरीत (Contrary) 'E' दोनों असत्य होते हैं, और उपाश्रित (Subaltern) 'I' सत्य होता है।",
            yearTag = "UGC NET Paper-1 June 2024 PYQ",
            subTopic = "Unit VI: Classical Square of Opposition"
        )
    )

    // ==================== UNIT 7: DATA INTERPRETATION ====================
    val unit7DiSeeds: List<RawUgcNetPyqSeed> = listOf(
        RawUgcNetPyqSeed(
            qEn = "A university has 4,000 students enrolled across 5 faculties: Arts (25%), Science (30%), Commerce (20%), Law (15%), and Education (10%). If 60% of the Science students and 40% of the Commerce students are female, what is the total number of female students in Science and Commerce combined?",
            qHi = "एक विश्वविद्यालय के 5 संकायों में कुल 4,000 छात्र नामांकित हैं: कला (25%), विज्ञान (30%), वाणिज्य (20%), विधि (15%) और शिक्षा (10%)। यदि विज्ञान के 60% छात्र और वाणिज्य के 40% छात्र छात्राएं (Female) हैं, तो विज्ञान और वाणिज्य में मिलाकर कुल कितनी छात्राएं हैं?",
            optsEn = listOf("1,040", "960", "1,120", "1,200"),
            optsHi = listOf("1,040", "960", "1,120", "1,200"),
            expEn = "Science students = 30% of 4,000 = 1,200; females in Science = 60% of 1,200 = 720. Commerce students = 20% of 4,000 = 800; females in Commerce = 40% of 800 = 320. Total = 720 + 320 = 1,040.",
            expHi = "विज्ञान छात्र = 4,000 का 30% = 1,200; विज्ञान में छात्राएं = 1,200 का 60% = 720। वाणिज्य छात्र = 800; वाणिज्य में छात्राएं = 800 का 40% = 320। कुल छात्राएं = 720 + 320 = 1,040।",
            yearTag = "UGC NET Paper-1 June 2024 PYQ",
            subTopic = "Unit VII: Percentage & Tabular Data Interpretation"
        ),
        RawUgcNetPyqSeed(
            qEn = "In a company's annual expenditure pie-chart (total expenditure = ₹ 720 Lakh), the central angle for Research & Development (R&D) is 54° and for Infrastructure is 90°. How much more (in ₹ Lakh) was spent on Infrastructure than on R&D?",
            qHi = "एक कंपनी के वार्षिक व्यय पाई-चार्ट (कुल व्यय = ₹ 720 लाख) में अनुसंधान एवं विकास (R&D) का केंद्रीय कोण 54° है और अवसंरचना (Infrastructure) का केंद्रीय कोण 90° है। R&D की तुलना में अवसंरचना पर कितने लाख रुपये अधिक खर्च किए गए?",
            optsEn = listOf("₹ 72 Lakh", "₹ 64 Lakh", "₹ 80 Lakh", "₹ 54 Lakh"),
            optsHi = listOf("₹ 72 लाख", "₹ 64 लाख", "₹ 80 लाख", "₹ 54 लाख"),
            expEn = "Difference in central angle = 90° - 54° = 36°. Since 360° corresponds to ₹ 720 Lakh (₹ 2 Lakh per degree), 36° = 36 × 2 = ₹ 72 Lakh.",
            expHi = "केंद्रीय कोणों का अंतर = 90° - 54° = 36°। चूंकि 360° = ₹ 720 लाख (अर्थात 1° = ₹ 2 लाख), अतः 36° = 36 × 2 = ₹ 72 लाख।",
            yearTag = "UGC NET Paper-1 Dec 2023 PYQ",
            subTopic = "Unit VII: Pie-Chart & Ratio Data Interpretation"
        ),
        RawUgcNetPyqSeed(
            qEn = "The production of laptops by a factory increased from 2,500 units in 2022 to 3,200 units in 2023, and then to 4,000 units in 2024. What is the average annual percentage growth rate over these two years?",
            qHi = "एक कारखाने द्वारा लैपटॉप का उत्पादन 2022 में 2,500 इकाई से बढ़कर 2023 में 3,200 इकाई और 2024 में 4,000 इकाई हो गया। इन दो वर्षों में औसत वार्षिक प्रतिशत वृद्धि दर क्या है?",
            optsEn = listOf("26.5%", "28.0%", "25.0%", "30.0%"),
            optsHi = listOf("26.5%", "28.0%", "25.0%", "30.0%"),
            expEn = "Growth in 2023 = ((3200 - 2500)/2500) × 100 = 28%. Growth in 2024 = ((4000 - 3200)/3200) × 100 = 25%. Average percentage growth = (28% + 25%) / 2 = 26.5%.",
            expHi = "2023 में वृद्धि = (700/2500)×100 = 28%। 2024 में वृद्धि = (800/3200)×100 = 25%। औसत वार्षिक वृद्धि दर = (28 + 25)/2 = 26.5%।",
            yearTag = "UGC NET Paper-1 June 2023 PYQ",
            subTopic = "Unit VII: Line-Graph & Growth Rate Analysis"
        )
    )

    // ==================== UNIT 8: INFORMATION & COMMUNICATION TECHNOLOGY (ICT) ====================
    val unit8IctSeeds: List<RawUgcNetPyqSeed> = listOf(
        RawUgcNetPyqSeed(
            qEn = "Arrange the following computer memory types in ascending order of their access speed (from slowest to fastest):",
            qHi = "निम्नलिखित कंप्यूटर मेमोरी प्रकारों को उनकी एक्सेस गति के आरोही क्रम (सबसे धीमी से सबसे तेज़) में व्यवस्थित कीजिए:",
            optsEn = listOf(
                "Hard Disk Drive (HDD) < Main Memory (RAM) < Cache Memory (L1/L2) < CPU Registers",
                "CPU Registers < Cache Memory < RAM < Hard Disk Drive",
                "Cache Memory < RAM < Hard Disk Drive < CPU Registers",
                "RAM < Hard Disk Drive < Cache Memory < CPU Registers"
            ),
            optsHi = listOf(
                "हार्ड डिस्क (HDD) < मुख्य मेमोरी (RAM) < कैश मेमोरी (Cache) < सीपीयू रजिस्टर (CPU Registers)",
                "सीपीयू रजिस्टर < कैश मेमोरी < RAM < हार्ड डिस्क",
                "कैश मेमोरी < RAM < हार्ड डिस्क < सीपीयू रजिस्टर",
                "RAM < हार्ड डिस्क < कैश मेमोरी < सीपीयू रजिस्टर"
            ),
            expEn = "Memory Hierarchy by speed (slowest to fastest): Magnetic Tape < HDD/SSD (Secondary) < Main Memory (DRAM) < Cache Memory (SRAM) < CPU Registers (fastest).",
            expHi = "मेमोरी पदानुक्रम में हार्ड डिस्क की गति सबसे कम और सीपीयू रजिस्टर (CPU Registers) की गति सबसे तेज़ होती है: HDD < RAM < Cache < CPU Registers।",
            yearTag = "UGC NET Paper-1 June 2024 PYQ",
            subTopic = "Unit VIII: Computer Memory Hierarchy (RAM, ROM, Cache, Registers)"
        ),
        RawUgcNetPyqSeed(
            qEn = "What is the binary equivalent of the decimal number (45)₁₀?",
            qHi = "दशमलव संख्या (45)₁₀ का द्विआधारी (Binary) समतुल्य क्या है?",
            optsEn = listOf("(101101)₂", "(110101)₂", "(101011)₂", "(111001)₂"),
            optsHi = listOf("(101101)₂", "(110101)₂", "(101011)₂", "(111001)₂"),
            expEn = "45 = 32 + 8 + 4 + 1 = 1×2⁵ + 0×2⁴ + 1×2³ + 1×2² + 0×2¹ + 1×2⁰ = (101101)₂.",
            expHi = "45 = 32 + 8 + 4 + 1 = (101101)₂।",
            yearTag = "UGC NET Paper-1 Dec 2023 PYQ",
            subTopic = "Unit VIII: Number Systems & Binary Conversion"
        ),
        RawUgcNetPyqSeed(
            qEn = "Which national digital initiative of the Government of India is an autonomous organization under the Ministry of Education (established in 1991 at Ahmedabad) that maintains 'Shodhganga' (a digital repository of Indian electronic theses and dissertations)?",
            qHi = "भारत सरकार के शिक्षा मंत्रालय के अधीन कौन-सा स्वायत्त केंद्र (अहमदाबाद) भारतीय इलेक्ट्रॉनिक शोध-प्रबंधों के डिजिटल कोष 'शोधगंगा' (Shodhganga) और 'शोधसिंधु' का संचालन करता है?",
            optsEn = listOf(
                "INFLIBNET Centre (Information and Library Network, Gandhinagar/Ahmedabad)",
                "NIC (National Informatics Centre)",
                "CDAC (Centre for Development of Advanced Computing)",
                "NPTEL (IIT Madras)"
            ),
            optsHi = listOf(
                "इनफ्लिबनेट केंद्र (INFLIBNET — Information and Library Network, गांधीनगर/अहमदाबाद)",
                "एनआईसी (NIC)",
                "सी-डैक (C-DAC)",
                "एनपीटीईएल (NPTEL)"
            ),
            expEn = "INFLIBNET (Information and Library Network Centre, Gandhinagar) maintains Shodhganga (theses repository), Shodhgangotri (synopses), e-ShodhSindhu (journals consortium), and VIDWAN (expert database).",
            expHi = "INFLIBNET केंद्र द्वारा शोधगंगा (पीएचडी थीसिस कोष), शोधगंगोत्री (सिनॉप्सिस), ई-शोधसिंधु और विद्वान (VIDWAN) पोर्टल संचालित किए जाते हैं।",
            yearTag = "UGC NET Paper-1 June 2024 PYQ",
            subTopic = "Unit VIII: Digital Initiatives in Higher Education"
        )
    )

    // ==================== UNIT 9: PEOPLE, DEVELOPMENT & ENVIRONMENT ====================
    val unit9EnvironmentSeeds: List<RawUgcNetPyqSeed> = listOf(
        RawUgcNetPyqSeed(
            qEn = "Match the International Environmental Agreements with their primary objective:\n1. Montreal Protocol (1987) — Depletion of Ozone Layer\n2. Kyoto Protocol (1997) — legally binding Greenhouse Gas reduction\n3. Kigali Amendment (2016) — Phase-down of Hydrofluorocarbons (HFCs)\n4. Nagoya Protocol (2010) — Access and Benefit Sharing of Genetic Resources\nWhich of the above pairs are correctly matched?",
            qHi = "अंतर्राष्ट्रीय पर्यावरण समझौतों का उनके मुख्य उद्देश्य से मिलान कीजिए:\n1. मॉन्ट्रियल प्रोटोकॉल (1987) — ओजोन परत का क्षरण\n2. क्योटो प्रोटोकॉल (1997) — ग्रीनहाउस गैस उत्सर्जन में कटौती\n3. किगाली संशोधन (2016) — हाइड्रोफ्लोरोकार्बन (HFCs) को चरणबद्ध रूप से घटाना\n4. नागोया प्रोटोकॉल (2010) — आनुवंशिक संसाधनों तक पहुँच और लाभ साझाकरण\nउपर्युक्त में से कौन-से युग्म सही सुमेलित हैं?",
            optsEn = listOf(
                "All four (1, 2, 3, and 4) are correctly matched",
                "1, 2, and 3 only",
                "1 and 2 only",
                "2, 3, and 4 only"
            ),
            optsHi = listOf(
                "चारों (1, 2, 3 और 4) सही सुमेलित हैं",
                "केवल 1, 2 और 3",
                "केवल 1 और 2",
                "केवल 2, 3 और 4"
            ),
            expEn = "All 4 are landmark environmental treaties frequently asked in UGC NET Paper-1: Montreal Protocol (1987, ODS), Kyoto Protocol (1997, GHG), Nagoya Protocol (2010, CBD ABS), and Kigali Amendment (2016, HFCs).",
            expHi = "मॉन्ट्रियल प्रोटोकॉल (ओजोन क्षयकारी पदार्थ), क्योटो प्रोटोकॉल (ग्रीनहाउस गैसें), किगाली संशोधन (HFCs) और नागोया प्रोटोकॉल (जैव-विविधता लाभ साझाकरण) चारों सही हैं।",
            yearTag = "UGC NET Paper-1 June 2024 PYQ",
            subTopic = "Unit IX: International Conventions & Protocols"
        ),
        RawUgcNetPyqSeed(
            qEn = "How many Sustainable Development Goals (SDGs) and associated targets were adopted by the United Nations in 2015 under 'Agenda 2030'?",
            qHi = "संयुक्त राष्ट्र द्वारा 2015 में 'एजेंडा 2030' के अंतर्गत कितने सतत विकास लक्ष्य (SDGs) और उनसे संबंधित कितने टारगेट (Targets) अपनाए गए थे?",
            optsEn = listOf(
                "17 Goals and 169 Targets (2015–2030)",
                "8 Goals and 18 Targets (Millennium Development Goals)",
                "15 Goals and 150 Targets",
                "20 Goals and 200 Targets"
            ),
            optsHi = listOf(
                "17 लक्ष्य (Goals) और 169 टारगेट (Targets) [2015–2030]",
                "8 लक्ष्य और 18 टारगेट (सहस्राब्दी विकास लक्ष्य — MDGs)",
                "15 लक्ष्य और 150 टारगेट",
                "20 लक्ष्य और 200 टारगेट"
            ),
            expEn = "The UN 2030 Agenda for Sustainable Development comprises 17 SDGs and 169 targets (succeeding the 8 MDGs of 2000–2015). Goal 4 is Quality Education and Goal 13 is Climate Action.",
            expHi = "संयुक्त राष्ट्र के एजेंडा 2030 में 17 सतत विकास लक्ष्य (SDGs) और 169 टारगेट शामिल हैं (जबकि MDGs में 8 लक्ष्य थे)।",
            yearTag = "UGC NET Paper-1 Dec 2023 PYQ",
            subTopic = "Unit IX: MDGs & SDGs (Agenda 2030)"
        ),
        RawUgcNetPyqSeed(
            qEn = "Tropospheric (ground-level) Ozone (O₃) and Peroxyacetyl Nitrate (PAN) formed by the action of sunlight on nitrogen oxides (NOₓ) and volatile organic compounds (VOCs) are examples of:",
            qHi = "नाइट्रोजन के ऑक्साइडों (NOₓ) और वाष्पशील कार्बनिक यौगिकों (VOCs) पर सूर्य के प्रकाश की क्रिया से बनने वाला क्षोभमंडलीय ओजोन (O₃) और पेरॉक्सीऐसीटिल नाइट्रेट (PAN) किसके उदाहरण हैं?",
            optsEn = listOf(
                "Secondary Air Pollutants (found in Photochemical / Los Angeles Smog)",
                "Primary Air Pollutants",
                "Biodegradable Water Pollutants",
                "Stratospheric Ozone Shield"
            ),
            optsHi = listOf(
                "द्वितीयक वायु प्रदूषक (Secondary Air Pollutants — प्रकाश-रासायनिक स्मॉग)",
                "प्राथमिक वायु प्रदूषक (Primary Pollutants)",
                "जैव-निम्नीकरणीय जल प्रदूषक",
                "समतापमंडलीय ओजोन कवच"
            ),
            expEn = "Primary pollutants (CO, SO₂, NO, PM) are emitted directly from sources; Secondary pollutants (O₃, PAN, H₂SO₄, HNO₃) are formed in the atmosphere through chemical/photochemical reactions.",
            expHi = "क्षोभमंडलीय ओजोन (O₃) और PAN सीधे किसी स्रोत से उत्सर्जित नहीं होते बल्कि वायुमंडल में रासायनिक अभिक्रिया से बनते हैं, अतः ये द्वितीयक प्रदूषक (Secondary Pollutants) हैं।",
            yearTag = "UGC NET Paper-1 June 2023 PYQ",
            subTopic = "Unit IX: Environmental Pollution & Photochemical Smog"
        )
    )

    // ==================== UNIT 10: HIGHER EDUCATION SYSTEM ====================
    val unit10HigherEdSeeds: List<RawUgcNetPyqSeed> = listOf(
        RawUgcNetPyqSeed(
            qEn = "Which ancient Indian seat of higher learning in Bihar was founded by Pala King Dharmapala in the 8th century CE and was renowned as a major centre of Vajrayana Buddhism?",
            qHi = "बिहार में स्थित प्राचीन भारत के किस उच्च शिक्षा केंद्र की स्थापना 8वीं शताब्दी ईस्वी में पाल शासक धर्मपाल ने की थी, जो वज्रयान बौद्ध धर्म के प्रमुख केंद्र के रूप में विख्यात था?",
            optsEn = listOf(
                "Vikramashila University (विक्रमशिला विश्वविद्यालय — Bhagalpur, Bihar)",
                "Takshashila University (तक्षशिला विश्वविद्यालय)",
                "Vallabhi University (वल्लभी विश्वविद्यालय — Gujarat)",
                "Kanchipuram Ghatika"
            ),
            optsHi = listOf(
                "विक्रमशिला विश्वविद्यालय (भागलपुर, बिहार — पाल राजा धर्मपाल द्वारा स्थापित)",
                "तक्षशिला विश्वविद्यालय",
                "वल्लभी विश्वविद्यालय (गुजरात — हीनयान बौद्ध केंद्र)",
                "कांचीपुरम घटिका"
            ),
            expEn = "Vikramashila University was established by Pala Emperor Dharmapala (late 8th century CE) in Bhagalpur, Bihar; Nalanda was founded by Kumaragupta I (5th century CE); Odantapuri by Gopala.",
            expHi = "विक्रमशिला विश्वविद्यालय की स्थापना पाल वंश के शासक धर्मपाल ने की थी, जबकि नालंदा विश्वविद्यालय की स्थापना कुमारगुप्त प्रथम ने की थी।",
            yearTag = "UGC NET Paper-1 June 2024 PYQ",
            subTopic = "Unit X: Institutions of Higher Learning in Ancient India"
        ),
        RawUgcNetPyqSeed(
            qEn = "Under the National Education Policy (NEP) 2020, what is the proposed single umbrella body for higher education in India (excluding medical and legal education), and what are its four independent verticals?",
            qHi = "राष्ट्रीय शिक्षा नीति (NEP) 2020 के अंतर्गत, चिकित्सा और विधिक शिक्षा को छोड़कर उच्च शिक्षा के लिए प्रस्तावित एकल निकाय कौन-सा है और उसके चार स्वतंत्र वर्टिकल (Verticals) कौन-से हैं?",
            optsEn = listOf(
                "HECI (Higher Education Commission of India) with 4 verticals: NHERC (Regulation), NAC (Accreditation), HEGC (Funding/Grants), and GEC (Academic Standard Setting)",
                "AICTE with 2 verticals: UGC and NAAC",
                "NCERT with 4 regional institutes",
                "NITI Aayog Higher Education Wing"
            ),
            optsHi = listOf(
                "भारतीय उच्च शिक्षा आयोग (HECI) जिसके 4 वर्टिकल हैं: NHERC (विनियमन), NAC (प्रत्यायन), HEGC (अनुदान) तथा GEC (मानक निर्धारण)",
                "AICTE (जिसके 2 भाग हैं: UGC और NAAC)",
                "NCERT (4 क्षेत्रीय संस्थान)",
                "नीति आयोग उच्च शिक्षा प्रकोष्ठ"
            ),
            expEn = "NEP 2020 proposes setting up the Higher Education Commission of India (HECI) with 4 independent verticals: NHERC (National Higher Education Regulatory Council), NAC (National Accreditation Council), HEGC (Higher Education Grants Council), and GEC (General Education Council).",
            expHi = "NEP 2020 के तहत HECI के चार स्वतंत्र स्तंभ प्रस्तावित हैं: NHERC (विनियमन), NAC (प्रत्यायन), HEGC (वित्तपोषण/अनुदान) और GEC (शैक्षणिक मानक)।",
            yearTag = "UGC NET Paper-1 Dec 2023 PYQ",
            subTopic = "Unit X: NEP 2020 & Higher Education Governance"
        ),
        RawUgcNetPyqSeed(
            qEn = "Which education commission in post-independence India (1964–1966) submitted its report titled 'Education and National Development' and recommended spending 6% of GDP on education?",
            qHi = "स्वतंत्रोत्तर भारत में किस शिक्षा आयोग (1964–1966) ने 'शिक्षा एवं राष्ट्रीय विकास' (Education and National Development) शीर्षक से अपनी रिपोर्ट प्रस्तुत की और शिक्षा पर सकल घरेलू उत्पाद (GDP) का 6% खर्च करने की सिफारिश की?",
            optsEn = listOf(
                "Kothari Commission (National Education Commission, 1964–66 — Dr. D.S. Kothari)",
                "Radhakrishnan Commission (University Education Commission, 1948–49)",
                "Mudaliar Commission (Secondary Education Commission, 1952–53)",
                "Yashpal Committee (2009)"
            ),
            optsHi = listOf(
                "कोठारी आयोग (राष्ट्रीय शिक्षा आयोग, 1964–66 — डॉ. डी.एस. कोठारी)",
                "राधाकृष्णन आयोग (विश्वविद्यालय शिक्षा आयोग, 1948–49)",
                "मुदलियार आयोग (माध्यमिक शिक्षा आयोग, 1952–53)",
                "यशपाल समिति (2009)"
            ),
            expEn = "The Kothari Commission (1964–66) began its report with 'The destiny of India is now being shaped in her classrooms' and recommended the 10+2+3 structure, Common School System, and 6% of GDP allocation to education.",
            expHi = "डॉ. डी.एस. कोठारी की अध्यक्षता वाले कोठारी आयोग (1964–66) ने 10+2+3 संरचना, समान स्कूल प्रणाली और शिक्षा पर GDP का 6% व्यय करने की अनुशंसा की थी।",
            yearTag = "UGC NET Paper-1 June 2023 PYQ",
            subTopic = "Unit X: Evolution of Higher Learning Post-Independence"
        )
    )
}
