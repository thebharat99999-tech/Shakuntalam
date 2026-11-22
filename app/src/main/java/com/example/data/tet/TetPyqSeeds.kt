package com.example.data.tet

data class RawTetPyqSeed(
    val qEn: String,
    val qHi: String,
    val optsEn: List<String>,
    val optsHi: List<String>,
    val expEn: String,
    val expHi: String,
    val yearTag: String,
    val subTopic: String,
    val correctIndex: Int = 0
)

object TetPyqSeeds {

    // =========================================================================
    // 1. CDP — Child Development & Pedagogy (बाल विकास एवं शिक्षाशास्त्र)
    // =========================================================================
    val cdpSeeds = listOf(
        RawTetPyqSeed(
            qEn = "According to Jean Piaget's theory of cognitive development, the ability of 'Conservation' and 'Reversibility' develops during which stage?",
            qHi = "जीन पियाजे के संज्ञानात्मक विकास सिद्धांत के अनुसार, 'संरक्षण (Conservation)' और 'प्रतिवर्त्यता (Reversibility)' की क्षमता किस अवस्था में विकसित होती है?",
            optsEn = listOf(
                "Concrete Operational Stage (7 to 11 years)",
                "Sensorimotor Stage (0 to 2 years)",
                "Pre-operational Stage (2 to 7 years)",
                "Formal Operational Stage (11+ years)"
            ),
            optsHi = listOf(
                "मूर्त संक्रियात्मक अवस्था (7 से 11 वर्ष)",
                "संवेदी-पेशीय अवस्था (0 से 2 वर्ष)",
                "पूर्व-संक्रियात्मक अवस्था (2 से 7 वर्ष)",
                "अमूर्त संक्रियात्मक अवस्था (11 वर्ष से अधिक)"
            ),
            expEn = "In Piaget's Concrete Operational Stage (7–11 years), children master conservation, reversibility, seriation, and classification for concrete objects.",
            expHi = "पियाजे की मूर्त संक्रियात्मक अवस्था (7–11 वर्ष) में बच्चे मूर्त वस्तुओं के लिए संरक्षण, प्रतिवर्त्यता, क्रमबद्धता और वर्गीकरण में दक्षता प्राप्त करते हैं।",
            yearTag = "CTET Aug 2023 / Jan 2024 / UPTET 2022",
            subTopic = "Piaget's Cognitive Development"
        ),
        RawTetPyqSeed(
            qEn = "In Lev Vygotsky's socio-cultural theory, what does 'Zone of Proximal Development (ZPD)' refer to?",
            qHi = "लेव वायगोत्स्की के सामाजिक-सांस्कृतिक सिद्धांत में 'समीपस्थ विकास का क्षेत्र (ZPD)' किसे संदर्भित करता है?",
            optsEn = listOf(
                "The gap between what a child can do independently and what they can achieve with guidance from a More Knowledgeable Other (MKO)",
                "The fixed biological limit of intelligence set by heredity",
                "The set of tasks a child has already mastered completely without any help",
                "Tasks that are completely beyond the child's reach even with expert scaffolding"
            ),
            optsHi = listOf(
                "बच्चे द्वारा स्वतंत्र रूप से किए जा सकने वाले कार्य और अधिक जानकार अन्य (MKO) के मार्गदर्शन से किए जा सकने वाले कार्य के बीच का अंतर",
                "आनुवंशिकता द्वारा निर्धारित बुद्धि की निश्चित जैविक सीमा",
                "वे कार्य जिनमें बच्चा बिना किसी सहायता के पहले से ही पूर्णतः निपुण है",
                "वे कार्य जो विशेषज्ञ पाड़ (Scaffolding) के बावजूद बच्चे की पहुँच से पूर्णतः बाहर हैं"
            ),
            expEn = "Vygotsky defined ZPD as the distance between actual developmental level (independent problem solving) and potential development under guidance or peer collaboration.",
            expHi = "वायगोत्स्की ने ZPD को वास्तविक विकास स्तर (स्वतंत्र समस्या समाधान) और मार्गदर्शन या सहकर्मी सहयोग के अंतर्गत संभावित विकास स्तर के बीच के अंतर के रूप में परिभाषित किया है।",
            yearTag = "CTET Jul 2024 / Dec 2022 / UTET 2023",
            subTopic = "Vygotsky's Socio-Cultural Theory"
        ),
        RawTetPyqSeed(
            qEn = "According to Lawrence Kohlberg's stages of Moral Development, a child who obeys rules strictly to 'maintain social order and law' is at which stage?",
            qHi = "लॉरेंस कोहलबर्ग के नैतिक विकास के चरणों के अनुसार, वह बच्चा जो 'सामाजिक व्यवस्था और कानून बनाए रखने' के लिए नियमों का पालन करता है, किस चरण में है?",
            optsEn = listOf(
                "Stage 4: Law and Order Orientation (Conventional Level)",
                "Stage 1: Obedience and Punishment Orientation (Pre-conventional Level)",
                "Stage 2: Instrumental Purpose / Tit-for-Tat Orientation",
                "Stage 6: Universal Ethical Principles (Post-conventional Level)"
            ),
            optsHi = listOf(
                "चरण 4: कानून एवं व्यवस्था अभिविन्यास (पारंपरिक स्तर)",
                "चरण 1: आज्ञापालन एवं दंड अभिविन्यास (पूर्व-पारंपरिक स्तर)",
                "चरण 2: यांत्रिक उद्देश्य / जैसे को तैसा अभिविन्यास",
                "चरण 6: सार्वभौमिक नैतिक सिद्धांत (उत्तर-पारंपरिक स्तर)"
            ),
            expEn = "At Stage 4 (Conventional Morality), moral reasoning centers on upholding laws, authority, and social order as a duty.",
            expHi = "चरण 4 (पारंपरिक नैतिकता) में नैतिक तर्कणा कर्तव्य के रूप में कानूनों, अधिकार और सामाजिक व्यवस्था को बनाए रखने पर केंद्रित होती है।",
            yearTag = "CTET Jan 2024 / Dec 2021",
            subTopic = "Kohlberg's Moral Development"
        ),
        RawTetPyqSeed(
            qEn = "Which theorist proposed the concept of 'Language Acquisition Device (LAD)' and argued that humans have an innate capacity to acquire language?",
            qHi = "किस मनोवैज्ञानिक/भाषाविद् ने 'भाषा अर्जन यंत्र (LAD)' की अवधारणा प्रस्तुत की और तर्क दिया कि मनुष्यों में भाषा अर्जित करने की जन्मजात क्षमता होती है?",
            optsEn = listOf(
                "Noam Chomsky",
                "B.F. Skinner",
                "Jean Piaget",
                "John B. Watson"
            ),
            optsHi = listOf(
                "नोम चॉम्स्की (Noam Chomsky)",
                "बी.एफ. स्किनर (B.F. Skinner)",
                "जीन पियाजे (Jean Piaget)",
                "जॉन बी. वाटसन (John B. Watson)"
            ),
            expEn = "Noam Chomsky's Nativist theory posits an innate Language Acquisition Device (LAD) and Universal Grammar in children.",
            expHi = "नोम चॉम्स्की के जन्मजात सिद्धांत के अनुसार बच्चों में जन्मजात भाषा अर्जन यंत्र (LAD) और सार्वभौमिक व्याकरण (Universal Grammar) होता है।",
            yearTag = "CTET Aug 2023 / UPTET 2021 / UTET 2022",
            subTopic = "Language & Thought"
        ),
        RawTetPyqSeed(
            qEn = "According to Howard Gardner's Theory of Multiple Intelligences, a therapist, counselor, or social leader who excels at understanding others' feelings and motives possesses high:",
            qHi = "हावर्ड गार्डनर के बहु-बुद्धि सिद्धांत के अनुसार, एक परामर्शदाता, चिकित्सक या सामाजिक नेता जो दूसरों की भावनाओं और इरादों को समझने में निपुण है, उसमें कौन-सी बुद्धि उच्च होती है?",
            optsEn = listOf(
                "Interpersonal Intelligence",
                "Intrapersonal Intelligence",
                "Spatial Intelligence",
                "Naturalistic Intelligence"
            ),
            optsHi = listOf(
                "अंतर-वैयक्तिक बुद्धि (Interpersonal Intelligence)",
                "अंतःवैयक्तिक बुद्धि (Intrapersonal Intelligence)",
                "स्थानिक बुद्धि (Spatial Intelligence)",
                "प्रकृतिवादी बुद्धि (Naturalistic Intelligence)"
            ),
            expEn = "Interpersonal intelligence is the capacity to understand intentions, motivations, and desires of other people, whereas Intrapersonal intelligence is understanding oneself.",
            expHi = "अंतर-वैयक्तिक (Interpersonal) बुद्धि अन्य लोगों की भावनाओं, अभिप्रेरणाओं और इच्छाओं को समझने की क्षमता है, जबकि अंतःवैयक्तिक (Intrapersonal) स्वयं को समझने की क्षमता है।",
            yearTag = "CTET Jul 2024 / Jan 2023",
            subTopic = "Gardner's Multiple Intelligences"
        ),
        RawTetPyqSeed(
            qEn = "What is the foundational structural reform in school pedagogical stages recommended by National Education Policy (NEP) 2020?",
            qHi = "राष्ट्रीय शिक्षा नीति (NEP) 2020 द्वारा अनुशंसित स्कूली शैक्षणिक चरणों में आधारभूत संरचनात्मक सुधार क्या है?",
            optsEn = listOf(
                "5 + 3 + 3 + 4 curricular structure (ages 3 to 18 years)",
                "10 + 2 + 3 traditional structure",
                "8 + 4 + 2 structure",
                "4 + 4 + 4 + 3 structure"
            ),
            optsHi = listOf(
                "5 + 3 + 3 + 4 पाठ्यचर्या संरचना (3 से 18 वर्ष की आयु)",
                "10 + 2 + 3 पारंपरिक संरचना",
                "8 + 4 + 2 संरचना",
                "4 + 4 + 4 + 3 संरचना"
            ),
            expEn = "NEP 2020 replaces 10+2 with 5+3+3+4: Foundational (5 yrs: 3 yrs Anganwadi/pre-school + Classes 1-2), Preparatory (3 yrs: Classes 3-5), Middle (3 yrs: Classes 6-8), Secondary (4 yrs: Classes 9-12).",
            expHi = "NEP 2020 ने 10+2 के स्थान पर 5+3+3+4 संरचना लागू की: फाउंडेशनल (5 वर्ष), प्रिपरेटरी (3 वर्ष: कक्षा 3-5), मिडिल (3 वर्ष: कक्षा 6-8) और सेकेंडरी (4 वर्ष: कक्षा 9-12)।",
            yearTag = "CTET Jan 2024 / Aug 2023 / UTET 2023",
            subTopic = "NEP 2020 & NCF"
        ),
        RawTetPyqSeed(
            qEn = "'Dysgraphia' is a specific learning disability primarily associated with difficulty in:",
            qHi = "'डिसग्राफिया (Dysgraphia)' एक विशिष्ट अधिगम अक्षमता है जो मुख्य रूप से किसमें कठिनाई से संबंधित है?",
            optsEn = listOf(
                "Handwriting, fine motor coordination, and coherent written expression",
                "Mathematical calculations and number sense",
                "Fluent oral reading Only",
                "Gross motor running and jumping Only"
            ),
            optsHi = listOf(
                "हस्तलेखन, सूक्ष्म गतिक समन्वय और सुसंगत लिखित अभिव्यक्ति",
                "गणितीय गणना और संख्या बोध",
                "केवल धाराप्रवाह मौखिक पठन",
                "केवल स्थूल गतिक दौड़ना और कूदना"
            ),
            expEn = "Dysgraphia impairs writing ability and fine motor skills; Dyslexia affects reading; Dyscalculia affects mathematical calculations; Dyspraxia affects motor coordination.",
            expHi = "डिसग्राफिया लेखन क्षमता और सूक्ष्म गतिक कौशल को प्रभावित करता है; डिस्लेक्सिया पठन को और डिस्केल्कुलिया गणितीय गणना को प्रभावित करता है।",
            yearTag = "CTET Jul 2024 / UPTET 2022 / UTET 2022",
            subTopic = "Inclusive Education & Learning Disabilities"
        ),
        RawTetPyqSeed(
            qEn = "According to the Right of Children to Free and Compulsory Education (RTE) Act, 2009, what is the minimum number of working hours per week for a teacher including preparation hours?",
            qHi = "निःशुल्क और अनिवार्य बाल शिक्षा का अधिकार (RTE) अधिनियम, 2009 के अनुसार, तैयारी के घंटों सहित एक शिक्षक के लिए प्रति सप्ताह न्यूनतम कार्य घंटे कितने निर्धारित हैं?",
            optsEn = listOf(
                "45 teaching hours per week (including preparation hours)",
                "30 hours per week",
                "60 hours per week",
                "28 hours per week"
            ),
            optsHi = listOf(
                "प्रति सप्ताह 45 शिक्षण घंटे (तैयारी के घंटों सहित)",
                "प्रति सप्ताह 30 घंटे",
                "प्रति सप्ताह 60 घंटे",
                "प्रति सप्ताह 28 घंटे"
            ),
            expEn = "The Schedule to the RTE Act 2009 specifies a minimum of 45 working hours per week for a teacher, including preparation hours, and 200/220 working days for Primary/Upper Primary.",
            expHi = "RTE अधिनियम 2009 की अनुसूची के अनुसार शिक्षक के लिए तैयारी घंटों सहित प्रति सप्ताह न्यूनतम 45 कार्य घंटे और प्राथमिक/उच्च प्राथमिक के लिए क्रमशः 200/220 कार्य दिवस निर्धारित हैं।",
            yearTag = "UPTET 2022 / CTET Dec 2022 / UTET 2023",
            subTopic = "RTE Act 2009"
        ),
        RawTetPyqSeed(
            qEn = "Which principle of child development states that development proceeds from the center of the body outward toward the extremities?",
            qHi = "बाल विकास का कौन-सा सिद्धांत यह बताता है कि विकास शरीर के केंद्र (रीढ़/हृदय) से बाहर की ओर (भुजाओं और उंगलियों की ओर) बढ़ता है?",
            optsEn = listOf(
                "Proximodistal Principle (Near to Far)",
                "Cephalocaudal Principle (Head to Toe)",
                "Principle of Uniform Pattern",
                "Principle of Discontinuous Growth"
            ),
            optsHi = listOf(
                "समीप-दूराभिमुख सिद्धांत (Proximodistal — केंद्र से बाहर की ओर)",
                "शीर्षाभिमुख सिद्धांत (Cephalocaudal — सिर से पैर की ओर)",
                "समान प्रतिमान का सिद्धांत",
                "असतत वृद्धि का सिद्धांत"
            ),
            expEn = "Proximodistal development proceeds from the center/core of the body outward (e.g., shoulder control before finger pincer grasp), while Cephalocaudal proceeds head-to-toe.",
            expHi = "समीप-दूराभिमुख (Proximodistal) विकास शरीर के केंद्र से बाहर की ओर बढ़ता है (जैसे उंगलियों से पहले कंधे और बांह पर नियंत्रण), जबकि शीर्षाभिमुख (Cephalocaudal) सिर से पैर की ओर बढ़ता है।",
            yearTag = "CTET Jan 2024 / Aug 2023",
            subTopic = "Principles of Child Development"
        ),
        RawTetPyqSeed(
            qEn = "In an Inclusive Classroom as envisioned by RPwD Act 2016 and NEP 2020, how should a teacher respond to diverse learners?",
            qHi = "RPwD अधिनियम 2016 और NEP 2020 द्वारा परिकल्पित 'समावेशी कक्षा (Inclusive Classroom)' में एक शिक्षक को विविध शिक्षार्थियों के प्रति कैसी प्रतिक्रिया देनी चाहिए?",
            optsEn = listOf(
                "Adopt Universal Design for Learning (UDL), flexible pedagogy, and differentiated instruction in regular classrooms",
                "Segregate children with special needs into separate permanent sections",
                "Use rigid standardized tests as the sole criterion for promotion",
                "Lower expectations and ignore children from marginalized backgrounds"
            ),
            optsHi = listOf(
                "सामान्य कक्षा में ही अधिगम के सार्वभौमिक डिजाइन (UDL), लचीले शिक्षण शास्त्र और विभेदित अनुदेशन को अपनाना",
                "विशेष आवश्यकता वाले बच्चों को स्थायी रूप से अलग वर्गों में रखना",
                "पदोन्नति के एकमात्र मानदंड के रूप में कठोर मानकीकृत परीक्षणों का उपयोग करना",
                "अपेक्षाएँ कम करना और वंचित पृष्ठभूमि के बच्चों की अनदेखी करना"
            ),
            expEn = "Inclusive education ensures all children learn together in regular schools through barrier-free access, reasonable accommodation, and differentiated pedagogy.",
            expHi = "समावेशी शिक्षा बाधा-मुक्त पहुँच, यथोचित अनुकूलन (Reasonable Accommodation) और लचीले शिक्षण शास्त्र के माध्यम से सभी बच्चों को नियमित विद्यालयों में एक साथ सीखने का अवसर देती है।",
            yearTag = "CTET Jul 2024 / Jan 2024",
            subTopic = "Inclusive Education & RPwD Act 2016"
        )
    )

    // =========================================================================
    // 2. EVS — Environmental Studies & Pedagogy (पर्यावरण अध्ययन एवं पेडागोजी)
    // =========================================================================
    val evsSeeds = listOf(
        RawTetPyqSeed(
            qEn = "According to the NCF-2005 Primary EVS syllabus (Classes III to V), which of the following is one of the 6 Main Themes (and NOT a sub-theme)?",
            qHi = "NCF-2005 के प्राथमिक पर्यावरण अध्ययन (कक्षा 3 से 5) पाठ्यक्रम के अनुसार, निम्नलिखित में से कौन-सा 6 मुख्य थीम (Main Themes) में से एक है (उप-थीम नहीं)?",
            optsEn = listOf(
                "Things We Make and Do",
                "Animals",
                "Plants",
                "Work and Play"
            ),
            optsHi = listOf(
                "हम चीजें कैसे बनाते हैं (Things We Make and Do)",
                "जानवर (Animals)",
                "पौधे (Plants)",
                "काम और खेल (Work and Play)"
            ),
            expEn = "The 6 Main EVS Themes are: (1) Family and Friends, (2) Food, (3) Shelter, (4) Water, (5) Travel, and (6) Things We Make and Do. 'Relationships', 'Work and Play', 'Animals', and 'Plants' are the 4 sub-themes under 'Family and Friends'.",
            expHi = "EVS की 6 मुख्य थीम हैं: (1) परिवार और मित्र, (2) भोजन, (3) आश्रय, (4) जल, (5) यात्रा, और (6) हम चीजें कैसे बनाते हैं। 'जानवर', 'पौधे', 'संबंध' और 'काम और खेल' परिवार और मित्र की उप-थीम हैं।",
            yearTag = "CTET Jul 2024 / Jan 2024 / Aug 2023",
            subTopic = "EVS Themes & Pedagogy"
        ),
        RawTetPyqSeed(
            qEn = "Which of the following statements is TRUE about the 'Khejri' tree described in NCERT EVS ('The Story of Amrita')?",
            qHi = "NCERT पर्यावरण अध्ययन ('अमृता की कहानी') में वर्णित 'खेजड़ी' वृक्ष के संबंध में निम्नलिखित में से कौन-सा कथन सत्य है?",
            optsEn = listOf(
                "It grows mainly in desert areas without much water, its bark is used for medicine, and its beans are cooked as a vegetable",
                "It grows only in waterlogged marshy areas of coastal Kerala",
                "It stores gallons of water in its trunk which people drink using a thin pipe",
                "Its wood is rapidly destroyed by insects within days"
            ),
            optsHi = listOf(
                "यह मुख्य रूप से रेगिस्तानी क्षेत्रों में कम पानी में उगता है, इसकी छाल दवा के काम आती है और इसकी फलियों की सब्जी बनाई जाती है",
                "यह केवल केरल के तटीय दलदली क्षेत्रों में उगता है",
                "इसके तने में गैलन पानी जमा रहता है जिसे लोग पतले पाइप से पीते हैं",
                "इसकी लकड़ी में कुछ ही दिनों में कीड़े लग जाते हैं"
            ),
            expEn = "Khejri tree is found in Khejadli village (Jodhpur, Rajasthan). It needs very little water, its wood is not affected by insects, its bark is medicinal, and its pods (Sangri) are eaten.",
            expHi = "खेजड़ी वृक्ष राजस्थान के जोधपुर (खेजड़ली गाँव) में पाया जाता है। इसे बहुत कम पानी चाहिए, इसकी लकड़ी को कीड़ा नहीं लगता, छाल से दवा बनती है और फलियों की सब्जी बनती है।",
            yearTag = "CTET Aug 2023 / Dec 2022",
            subTopic = "NCERT Plants & Biodiversity"
        ),
        RawTetPyqSeed(
            qEn = "The insectivorous Pitcher Plant (Nepenthes) traps and eats frogs, insects, and even mice to fulfill its requirement of which nutrient, and where is it found in India?",
            qHi = "कीटभक्षी 'घटपर्णी पादप (Nepenthes / Pitcher Plant)' किस पोषक तत्व की कमी को पूरा करने के लिए मेंढकों, कीड़ों और चूहों को फँसाकर खाता है और यह भारत में कहाँ पाया जाता है?",
            optsEn = listOf(
                "Nitrogen deficiency; found in Meghalaya in India (also Indonesia and Australia)",
                "Calcium deficiency; found in Thar Desert of Rajasthan",
                "Iron deficiency; found in Ladakh cold desert",
                "Phosphorus deficiency; found in Rann of Kutch"
            ),
            optsHi = listOf(
                "नाइट्रोजन की कमी; भारत में मेघालय में पाया जाता है (इंडोनेशिया व ऑस्ट्रेलिया में भी)",
                "कैल्शियम की कमी; राजस्थान के थार मरुस्थल में पाया जाता है",
                "लौह तत्व की कमी; लद्दाख के ठंडे रेगिस्तान में पाया जाता है",
                "फॉस्फोरस की कमी; कच्छ के रण में पाया जाता है"
            ),
            expEn = "Nepenthes grows in nitrogen-deficient soil in Meghalaya (India), Australia, and Indonesia. It emits a pleasant smell to attract and trap insects.",
            expHi = "नेपेन्थिस (घटपर्णी) मेघालय (भारत), ऑस्ट्रेलिया और इंडोनेशिया की नाइट्रोजन-न्यून मिट्टी में उगता है। यह विशेष गंध निकालकर कीड़ों को आकर्षित कर फँसाता है।",
            yearTag = "CTET Jan 2024 / Dec 2021 / UPTET 2022",
            subTopic = "NCERT Flora & Fauna"
        ),
        RawTetPyqSeed(
            qEn = "Identify the animal based on NCERT EVS facts: 'It looks like a bear but is not; it sleeps for about 17 hours a day hanging upside down on a tree branch and lives for about 40 years on just 8 trees.'",
            qHi = "NCERT EVS तथ्यों के आधार पर जानवर की पहचान करें: 'यह भालू जैसा दिखता है पर भालू नहीं है; यह दिन में लगभग 17 घंटे पेड़ की शाखा से उल्टा लटककर सोता है और लगभग 40 वर्ष के जीवनकाल में केवल 8 पेड़ों पर ही रहता है।'",
            optsEn = listOf(
                "Sloth",
                "Koala",
                "Chimpanzee",
                "Giant Panda"
            ),
            optsHi = listOf(
                "स्लॉथ (Sloth)",
                "कोआला (Koala)",
                "चिम्पांजी (Chimpanzee)",
                "विशाल पांडा (Giant Panda)"
            ),
            expEn = "Sloth sleeps ~17 hours a day hanging upside down, eats leaves of the same tree it lives on, comes down once a week to relieve itself, and moves across ~8 trees in its 40-year lifespan.",
            expHi = "स्लॉथ दिन में लगभग 17 घंटे पेड़ से उल्टा लटककर सोता है, उसी पेड़ की पत्तियाँ खाता है, सप्ताह में एक बार शौच के लिए नीचे उतरता है और 40 वर्ष के जीवन में लगभग 8 पेड़ों पर घूमता है।",
            yearTag = "CTET Jul 2024 / Aug 2023",
            subTopic = "Animals & Adaptations"
        ),
        RawTetPyqSeed(
            qEn = "In Bihar (especially Muzaffarpur district), which months are considered the best time to start 'Beekeeping (Apiculture)' when honeybees lay their eggs?",
            qHi = "बिहार (विशेषकर मुजफ्फरपुर जिले) में मधुमक्खी पालन शुरू करने का सबसे उपयुक्त समय कौन-से महीने माने जाते हैं जब मधुमक्खियाँ अंडे देती हैं?",
            optsEn = listOf(
                "October to December",
                "April to June",
                "July to September",
                "January to March"
            ),
            optsHi = listOf(
                "अक्टूबर से दिसंबर",
                "अप्रैल से जून",
                "जुलाई से सितंबर",
                "जनवरी से मार्च"
            ),
            expEn = "From NCERT chapter 'Anita and the Honeybees': Honeybees lay eggs from October to December, making it the best period to start beekeeping; Litchi flowers bloom in February.",
            expHi = "NCERT अध्याय 'अनीता की मधुमक्खियाँ' के अनुसार: मधुमक्खियाँ अक्टूबर से दिसंबर के बीच अंडे देती हैं, इसलिए यह मधुमक्खी पालन शुरू करने का सर्वोत्तम समय है; लीची के फूल फरवरी में खिलते हैं।",
            yearTag = "CTET Jan 2024 / Dec 2022",
            subTopic = "Things We Make and Do"
        ),
        RawTetPyqSeed(
            qEn = "Which famous shawl woven by the Changpa tribe of Ladakh from the coat of Changthangi goats takes nearly 250 hours of weaving and gives warmth equal to 6 normal sweaters?",
            qHi = "लद्दाख की चांगपा जनजाति द्वारा चांगथांगी बकरियों के बालों से बुनी जाने वाली कौन-सी प्रसिद्ध शॉल को बुनने में लगभग 250 घंटे लगते हैं और यह 6 सामान्य स्वेटरों के बराबर गर्मी देती है?",
            optsEn = listOf(
                "Pashmina Shawl",
                "Kullu Shawl",
                "Pochampally Ikat",
                "Kalamkari Shawl"
            ),
            optsHi = listOf(
                "पश्मीना शॉल (Pashmina Shawl)",
                "कुल्लू शॉल",
                "पोचमपल्ली इकत",
                "कलमकारी शॉल"
            ),
            expEn = "Changpa nomads rear Pashmina goats at 5,000 meters altitude (-40°C). One Pashmina hair is 6 times thinner than human hair and must be hand-woven (250 hours for a plain shawl).",
            expHi = "चांगपा जनजाति 5,000 मीटर की ऊँचाई (-40°C) पर पश्मीना बकरियाँ पालती है। एक पश्मीना बाल मनुष्य के बाल से 6 गुना पतला होता है और इसे हाथ से बुनने में 250 घंटे लगते हैं।",
            yearTag = "CTET Aug 2023 / Jan 2023",
            subTopic = "Shelter & Travel"
        ),
        RawTetPyqSeed(
            qEn = "In which year was the Wildlife Protection Act enacted in India, and where is Jim Corbett National Park (India's first National Park, formerly Hailey National Park) located?",
            qHi = "भारत में वन्यजीव संरक्षण अधिनियम (Wildlife Protection Act) किस वर्ष लागू किया गया और भारत का प्रथम राष्ट्रीय उद्यान 'जिम कॉर्बेट नेशनल पार्क' (पूर्व नाम हेली नेशनल पार्क) कहाँ स्थित है?",
            optsEn = listOf(
                "1972; Uttarakhand",
                "1986; Uttar Pradesh",
                "1980; Himachal Pradesh",
                "1974; Madhya Pradesh"
            ),
            optsHi = listOf(
                "1972; उत्तराखंड",
                "1986; उत्तर प्रदेश",
                "1980; हिमाचल प्रदेश",
                "1974; मध्य प्रदेश"
            ),
            expEn = "The Wildlife Protection Act was enacted in 1972. Jim Corbett National Park (established in 1936 as Hailey National Park) is in Nainital/Pauri Garhwal, Uttarakhand.",
            expHi = "वन्यजीव संरक्षण अधिनियम 1972 में पारित हुआ। जिम कॉर्बेट राष्ट्रीय उद्यान (1936 में हेली नेशनल पार्क के रूप में स्थापित) उत्तराखंड में स्थित है।",
            yearTag = "UPTET 2022 / UTET 2023 / CTET 2023",
            subTopic = "Environment & Biodiversity Laws"
        ),
        RawTetPyqSeed(
            qEn = "Why are there no separate textbooks for Environmental Studies (EVS) in Classes I and II according to NCF 2005?",
            qHi = "NCF-2005 के अनुसार कक्षा I और II में पर्यावरण अध्ययन (EVS) के लिए अलग से पाठ्यपुस्तकें क्यों नहीं हैं?",
            optsEn = listOf(
                "Because young children view their environment holistically, so environmental concepts are integrated with Language and Mathematics in Classes I and II",
                "Because environmental awareness is considered unimportant before Class III",
                "To reduce the salary burden of primary teachers",
                "Because children in Classes I and II cannot observe nature"
            ),
            optsHi = listOf(
                "क्योंकि छोटे बच्चे अपने परिवेश को समग्र रूप (Holistically) से देखते हैं, इसलिए कक्षा I और II में पर्यावरणीय अवधारणाओं को भाषा और गणित के साथ एकीकृत किया गया है",
                "क्योंकि कक्षा III से पहले पर्यावरण जागरूकता को महत्वहीन माना जाता है",
                "प्राथमिक शिक्षकों के वेतन भार को कम करने के लिए",
                "क्योंकि कक्षा I और II के बच्चे प्रकृति का अवलोकन नहीं कर सकते"
            ),
            expEn = "In Classes I & II, EVS concerns are transacted through Language and Mathematics so that children experience their environment holistically without compartmentalization.",
            expHi = "कक्षा I और II में पर्यावरण संबंधी सरोकारों को भाषा और गणित के माध्यम से पढ़ाया जाता है ताकि बच्चे अपने परिवेश को खंडों में बाँटने के बजाय समग्र रूप से समझ सकें।",
            yearTag = "CTET Jul 2024 / Jan 2024",
            subTopic = "Integrated Nature of EVS"
        ),
        RawTetPyqSeed(
            qEn = "In ecological food chains, according to Raymond Lindeman's 10% Law of Energy Transfer, what happens to energy as it moves from one trophic level to the next?",
            qHi = "पारिस्थितिक खाद्य श्रृंखला में रेमंड लिंडमान के 'ऊर्जा स्थानांतरण के 10% नियम' के अनुसार, एक पोषण स्तर से अगले पोषण स्तर में जाने पर ऊर्जा का क्या होता है?",
            optsEn = listOf(
                "Only about 10% of the energy is transferred to the next trophic level, while 90% is lost as metabolic heat",
                "90% of the energy is stored in the next trophic level",
                "Energy increases 10 times at every higher trophic level",
                "Energy flow in an ecosystem is bidirectional and 100% conserved in biomass"
            ),
            optsHi = listOf(
                "केवल लगभग 10% ऊर्जा ही अगले पोषण स्तर में स्थानांतरित होती है, जबकि 90% चयापचय ऊष्मा के रूप में नष्ट हो जाती है",
                "90% ऊर्जा अगले पोषण स्तर में संचित हो जाती है",
                "प्रत्येक उच्च पोषण स्तर पर ऊर्जा 10 गुना बढ़ जाती है",
                "पारिस्थितिकी तंत्र में ऊर्जा का प्रवाह द्विदिशीय होता है"
            ),
            expEn = "Lindeman's 10% Law (1942) states that only 10% of organic energy is transferred from one trophic level to the next; energy flow in an ecosystem is always unidirectional.",
            expHi = "लिंडमान के 10% नियम (1942) के अनुसार एक पोषण स्तर से अगले स्तर में केवल 10% ऊर्जा ही स्थानांतरित होती है और पारिस्थितिकी तंत्र में ऊर्जा का प्रवाह सदैव एकदिशीय (Unidirectional) होता है।",
            yearTag = "UPTET 2022 / UTET 2023",
            subTopic = "Ecosystem & Ecology"
        ),
        RawTetPyqSeed(
            qEn = "Which pair of diseases is spread by mosquitoes, and who discovered that malaria is transmitted by the female Anopheles mosquito?",
            qHi = "मच्छरों द्वारा फैलने वाले रोगों का सही युग्म कौन-सा है और यह किसने खोजा था कि मलेरिया मादा एनोफिलीज मच्छर द्वारा फैलता है?",
            optsEn = listOf(
                "Malaria, Dengue, Chikungunya; discovered by Sir Ronald Ross (Nobel Prize 1902)",
                "Malaria, Typhoid, Cholera; discovered by Louis Pasteur",
                "Dengue, Tuberculosis, Polio; discovered by Edward Jenner",
                "Chikungunya, Diphtheria, Scurvy; discovered by Alexander Fleming"
            ),
            optsHi = listOf(
                "मलेरिया, डेंगू, चिकनगुनिया; सर रोनाल्ड रॉस द्वारा खोज (नोबेल पुरस्कार 1902)",
                "मलेरिया, टाइफाइड, हैजा; लुई पाश्चर द्वारा खोज",
                "डेंगू, तपेदिक, पोलियो; एडवर्ड जेनर द्वारा खोज",
                "चिकनगुनिया, डिप्थीरिया, स्कर्वी; अलेक्जेंडर फ्लेमिंग द्वारा खोज"
            ),
            expEn = "Malaria, Dengue, and Chikungunya are mosquito-borne. Ronald Ross discovered the malarial parasite (Plasmodium) in the stomach of the female Anopheles mosquito in Secunderabad in 1897.",
            expHi = "मलेरिया, डेंगू और चिकनगुनिया मच्छरों से फैलते हैं। रोनाल्ड रॉस ने 1897 में सिकंदराबाद में मादा एनोफिलीज मच्छर के आमाशय में मलेरिया परजीवी (प्लाज्मोडियम) की खोज की थी।",
            yearTag = "CTET Jan 2024 / Aug 2023",
            subTopic = "Health, Hygiene & Water"
        )
    )

    // =========================================================================
    // 3. MATHEMATICS & PEDAGOGY (गणित एवं शिक्षण शास्त्र)
    // =========================================================================
    val mathsSeeds = listOf(
        RawTetPyqSeed(
            qEn = "According to Van Hiele's theory of Geometric Thought, a primary school child who identifies a rectangle because 'it looks like a door' is operating at which level?",
            qHi = "वैन हीले (Van Hiele) के ज्यामितीय चिंतन के सिद्धांत के अनुसार, प्राथमिक विद्यालय का एक बच्चा जो आयत को इसलिए पहचानता है क्योंकि 'यह दरवाजे जैसा दिखता है', किस स्तर पर कार्य कर रहा है?",
            optsEn = listOf(
                "Level 0: Visualization (Recognition based on overall appearance)",
                "Level 1: Analysis (Classification based on properties)",
                "Level 2: Informal Deduction (Relationships between properties)",
                "Level 3: Formal Deduction (Axiomatic proofs)"
            ),
            optsHi = listOf(
                "स्तर 0: चाक्षुषीकरण / दृश्यीकरण (समग्र दिखावट के आधार पर पहचान)",
                "स्तर 1: विश्लेषण (गुणों के आधार पर वर्गीकरण)",
                "स्तर 2: अनौपचारिक निगमन (गुणों के बीच संबंध)",
                "स्तर 3: औपचारिक निगमन (स्वयंसिद्ध प्रमाण)"
            ),
            expEn = "At Van Hiele's Level 0 (Visualization), children recognize geometric shapes holistically by their visual appearance ('square looks like a biscuit, rectangle looks like a door') rather than formal properties.",
            expHi = "वैन हीले के स्तर 0 (चाक्षुषीकरण/Visualization) पर बच्चे ज्यामितीय आकृतियों को उनके औपचारिक गुणों के बजाय उनकी बाहरी दिखावट ('दरवाजे जैसा', 'बिस्कुट जैसा') से पहचानते हैं।",
            yearTag = "CTET Jul 2024 / Jan 2024 / Aug 2023",
            subTopic = "Van Hiele Geometric Levels"
        ),
        RawTetPyqSeed(
            qEn = "According to National Curriculum Framework (NCF) 2005, what is the 'Higher Aim' of teaching Mathematics at the school level?",
            qHi = "राष्ट्रीय पाठ्यचर्या की रूपरेखा (NCF) 2005 के अनुसार, विद्यालयी स्तर पर गणित शिक्षण का 'उच्च उद्देश्य (Higher Aim)' क्या है?",
            optsEn = listOf(
                "Mathematization of the child's thought processes (developing clarity of thought, logical reasoning, and problem-solving attitude)",
                "Memorizing multiplication tables up to 30 and geometric formulas",
                "Developing only computational speed for banking jobs",
                "Preparing every student exclusively for engineering entrance tests"
            ),
            optsHi = listOf(
                "बच्चे की चिंतन प्रक्रियाओं का गणितीकरण करना (तार्किक सोच, अमूर्तन और समस्या-समाधान दृष्टिकोण का विकास)",
                "30 तक पहाड़े और ज्यामितीय सूत्र कंठस्थ कराना",
                "केवल बैंकिंग नौकरियों के लिए गणना की गति विकसित करना",
                "प्रत्येक छात्र को केवल इंजीनियरिंग प्रवेश परीक्षा के लिए तैयार करना"
            ),
            expEn = "NCF 2005 distinguishes between the 'Narrow Aim' (developing numeracy/numbers & operations) and the 'Higher Aim' (mathematization of the child's inner resources and logical thinking).",
            expHi = "NCF 2005 गणित के 'संकीर्ण उद्देश्य' (संख्यात्मक कौशल का विकास) और 'उच्च उद्देश्य' (बच्चे के आंतरिक संसाधनों और चिंतन प्रक्रिया का गणितीकरण) के बीच स्पष्ट अंतर करता है।",
            yearTag = "CTET Jan 2024 / Dec 2022 / UTET 2023",
            subTopic = "NCF 2005 Mathematics Pedagogy"
        ),
        RawTetPyqSeed(
            qEn = "What is the difference between the Place Value and Face Value of the digit '7' in the number 5,74,892?",
            qHi = "संख्या 5,74,892 में अंक '7' के स्थानीय मान (Place Value) और जातीय/अंकित मान (Face Value) का अंतर क्या है?",
            optsEn = listOf(
                "69,993",
                "70,007",
                "6,993",
                "70,000"
            ),
            optsHi = listOf(
                "69,993",
                "70,007",
                "6,993",
                "70,000"
            ),
            expEn = "In 5,74,892, the place value of 7 is 70,000 and the face value of 7 is 7. Their difference = 70,000 - 7 = 69,993.",
            expHi = "संख्या 5,74,892 में 7 का स्थानीय मान 70,000 है और जातीय मान 7 है। अंतर = 70,000 - 7 = 69,993।",
            yearTag = "CTET Aug 2023 / UPTET 2022",
            subTopic = "Number System & Place Value"
        ),
        RawTetPyqSeed(
            qEn = "How many total factors (divisors) does the number 360 have, and what is the sum of all its positive factors?",
            qHi = "संख्या 360 के कुल कितने धनात्मक गुणनखंड (भाजक) हैं और इसके सभी धनात्मक गुणनखंडों का योगफल क्या है?",
            optsEn = listOf(
                "24 factors; Sum of factors = 1170",
                "18 factors; Sum of factors = 960",
                "20 factors; Sum of factors = 1080",
                "12 factors; Sum of factors = 720"
            ),
            optsHi = listOf(
                "24 गुणनखंड; गुणनखंडों का योगफल = 1170",
                "18 गुणनखंड; गुणनखंडों का योगफल = 960",
                "20 गुणनखंड; गुणनखंडों का योगफल = 1080",
                "12 गुणनखंड; गुणनखंडों का योगफल = 720"
            ),
            expEn = "Prime factorization: 360 = 2³ × 3² × 5¹. Number of factors = (3+1)(2+1)(1+1) = 4×3×2 = 24. Sum of factors = (1+2+4+8)(1+3+9)(1+5) = 15 × 13 × 6 = 1170.",
            expHi = "अभाज्य गुणनखंडन: 360 = 2³ × 3² × 5¹। कुल गुणनखंड = (3+1)(2+1)(1+1) = 4×3×2 = 24। गुणनखंडों का योग = (1+2+4+8)(1+3+9)(1+5) = 15 × 13 × 6 = 1170।",
            yearTag = "CTET Jul 2024 / Jan 2024 / UPTET 2021",
            subTopic = "Factors & Multiples"
        ),
        RawTetPyqSeed(
            qEn = "The HCF of two numbers is 12 and their LCM is 180. If one of the numbers is 36, what is the other number?",
            qHi = "दो संख्याओं का महत्तम समापवर्तक (HCF) 12 है और उनका लघुत्तम समापवर्त्य (LCM) 180 है। यदि उनमें से एक संख्या 36 है, तो दूसरी संख्या क्या होगी?",
            optsEn = listOf(
                "60",
                "48",
                "72",
                "45"
            ),
            optsHi = listOf(
                "60",
                "48",
                "72",
                "45"
            ),
            expEn = "Using Product of two numbers = HCF × LCM: 36 × Second Number = 12 × 180 => Second Number = (12 × 180) / 36 = 60.",
            expHi = "दो संख्याओं का गुणनफल = HCF × LCM: 36 × दूसरी संख्या = 12 × 180 => दूसरी संख्या = (12 × 180) / 36 = 60।",
            yearTag = "UPTET 2022 / UTET 2023 / CTET 2023",
            subTopic = "LCM & HCF"
        ),
        RawTetPyqSeed(
            qEn = "A wire in the form of a square of side 22 cm is bent to form a circle. What will be the radius and area of the circle? (Use π = 22/7)",
            qHi = "22 सेमी भुजा वाले एक वर्ग के आकार के तार को मोड़कर एक वृत्त बनाया जाता है। उस वृत्त की त्रिज्या और क्षेत्रफल क्या होगा? (π = 22/7 लें)",
            optsEn = listOf(
                "Radius = 14 cm; Area = 616 sq. cm",
                "Radius = 7 cm; Area = 154 sq. cm",
                "Radius = 21 cm; Area = 1386 sq. cm",
                "Radius = 14 cm; Area = 484 sq. cm"
            ),
            optsHi = listOf(
                "त्रिज्या = 14 सेमी; क्षेत्रफल = 616 वर्ग सेमी",
                "त्रिज्या = 7 सेमी; क्षेत्रफल = 154 वर्ग सेमी",
                "त्रिज्या = 21 सेमी; क्षेत्रफल = 1386 वर्ग सेमी",
                "त्रिज्या = 14 सेमी; क्षेत्रफल = 484 वर्ग सेमी"
            ),
            expEn = "Perimeter of square = 4 × 22 = 88 cm = Circumference of circle (2πr). So 2 × (22/7) × r = 88 => r = 14 cm. Area = πr² = (22/7) × 14 × 14 = 616 cm².",
            expHi = "वर्ग का परिमाप = 4 × 22 = 88 सेमी = वृत्त की परिधि (2πr)। अतः 2 × (22/7) × r = 88 => r = 14 सेमी। वृत्त का क्षेत्रफल = πr² = (22/7) × 14 × 14 = 616 वर्ग सेमी।",
            yearTag = "CTET Jan 2024 / Aug 2023 / UPTET 2022",
            subTopic = "Mensuration (2D & 3D)"
        ),
        RawTetPyqSeed(
            qEn = "Which of the following manipulative teaching-learning materials (TLMs) is MOST effective for introducing the concept of 'Place Value (Tens and Ones)' and 'Regrouping' to primary school children?",
            qHi = "प्राथमिक विद्यालय के बच्चों को 'स्थानीय मान (दहाई और इकाई)' तथा 'पुनर्समूहीकरण (Regrouping)' की अवधारणा सिखाने के लिए निम्नलिखित में से कौन-सी हस्तपरक शिक्षण-अधिगम सामग्री (TLM) सर्वाधिक प्रभावी है?",
            optsEn = listOf(
                "Dienes Blocks (Base-10 blocks) and Abacus (Spike Abacus)",
                "Protractor and Compass",
                "Tangram (7-piece Chinese geometrical puzzle)",
                "Clinometer"
            ),
            optsHi = listOf(
                "डीन्स ब्लॉक (Dienes Base-10 Blocks) और गिनतारा (Abacus)",
                "चाँदा (Protractor) और परकार",
                "टैनग्राम (7 टुकड़ों वाली ज्यामितीय पहेली)",
                "क्लिनोमीटर"
            ),
            expEn = "Dienes Blocks (units, rods of 10, flats of 100, cubes of 1000) and Spike Abacus concretely represent base-10 place value and regrouping. Geo-board and Tangram are used for 2D geometry.",
            expHi = "डीन्स ब्लॉक (इकाई, 10 की छड़, 100 की पट्टी, 1000 का घन) और अबेकस (गिनतारा) स्थानीय मान व पुनर्समूहीकरण को मूर्त रूप से दर्शाते हैं, जबकि जियोबोर्ड और टैनग्राम ज्यामिति के लिए प्रयुक्त होते हैं।",
            yearTag = "CTET Jul 2024 / Jan 2024",
            subTopic = "Manipulatives & TLMs in Maths"
        ),
        RawTetPyqSeed(
            qEn = "How many lines of symmetry and what order of rotational symmetry does a regular hexagon have?",
            qHi = "एक सम षट्भुज (Regular Hexagon) में सममिति रेखाओं (Lines of Symmetry) की संख्या और घूर्णन सममिति की कोटि (Order of Rotational Symmetry) क्रमशः कितनी होती है?",
            optsEn = listOf(
                "6 lines of symmetry and rotational symmetry of order 6",
                "4 lines of symmetry and rotational symmetry of order 4",
                "3 lines of symmetry and rotational symmetry of order 6",
                "6 lines of symmetry and rotational symmetry of order 3"
            ),
            optsHi = listOf(
                "6 सममिति रेखाएँ और कोटि 6 की घूर्णन सममिति",
                "4 सममिति रेखाएँ और कोटि 4 की घूर्णन सममिति",
                "3 सममिति रेखाएँ और कोटि 6 की घूर्णन सममिति",
                "6 सममिति रेखाएँ और कोटि 3 की घूर्णन सममिति"
            ),
            expEn = "Any regular n-sided polygon has n lines of symmetry and rotational symmetry of order n (with angle of rotation = 360°/n). For a regular hexagon (n=6), both are 6.",
            expHi = "किसी भी n-भुजा वाले सम बहुभुज में n सममिति रेखाएँ और कोटि n की घूर्णन सममिति होती है। अतः सम षट्भुज (n=6) में दोनों 6 होते हैं।",
            yearTag = "CTET Aug 2023 / Dec 2022",
            subTopic = "Geometry & Symmetry"
        ),
        RawTetPyqSeed(
            qEn = "When a student writes 'Forty-five' as '405', what is the pedagogical diagnosis and appropriate remedial action?",
            qHi = "जब एक छात्र 'पैंतालीस (Forty-five)' को '405' लिखता है, तो इसका शैक्षणिक निदान और उपयुक्त उपचारात्मक उपाय क्या है?",
            optsEn = listOf(
                "The child has not understood the concept of Place Value and Zero as a placeholder; use concrete bundles of 10 sticks and loose sticks for remediation",
                "The child has severe visual impairment; refer immediately to an ophthalmologist",
                "Punish the child by making them write 45 one hundred times",
                "Skip two-digit numbers and directly teach three-digit multiplication"
            ),
            optsHi = listOf(
                "बच्चे को स्थानीय मान और शून्य के स्थान-धारक (Placeholder) रूप की समझ नहीं है; उपचार हेतु 10-10 तीलियों के बंडल और खुली तीलियों का मूर्त प्रयोग करें",
                "बच्चे को गंभीर दृष्टि दोष है; तुरंत नेत्र रोग विशेषज्ञ के पास भेजें",
                "बच्चे को दंड स्वरूप 100 बार 45 लिखने को कहें",
                "दो अंकों की संख्याएँ छोड़कर सीधे तीन अंकों का गुणा सिखाएँ"
            ),
            expEn = "Writing '405' for forty-five reflects a misconception between spoken additive expansion ('forty and five') and positional place value notation. Grouping activities with bundles of 10 build conceptual clarity.",
            expHi = "'पैंतालीस' को '405' लिखना मौखिक विस्तार और स्थानीय मान संकेतन के बीच भ्रम को दर्शाता है। 10-10 के बंडल और खुली तीलियों से समूहीकरण गतिविधि इसका सर्वोत्तम उपचारात्मक शिक्षण है।",
            yearTag = "CTET Jul 2024 / Jan 2024 / UTET 2023",
            subTopic = "Diagnostic & Remedial Teaching in Maths"
        ),
        RawTetPyqSeed(
            qEn = "According to Euler's Polyhedron Formula for any convex polyhedron with F faces, V vertices, and E edges, which relation always holds true?",
            qHi = "किसी उत्तल बहुफलक (Convex Polyhedron) के फलकों (F), शीर्षों (V) और किनारों (E) के लिए ऑयलर का सूत्र (Euler's Formula) कौन-सा है?",
            optsEn = listOf(
                "F + V - E = 2  (or F + V = E + 2)",
                "F + E - V = 2",
                "V + E - F = 2",
                "F × V = E + 2"
            ),
            optsHi = listOf(
                "F + V - E = 2  (अर्थात् F + V = E + 2)",
                "F + E - V = 2",
                "V + E - F = 2",
                "F × V = E + 2"
            ),
            expEn = "Euler's formula for 3D polyhedra states F + V - E = 2. For example, for a cube: F=6, V=8, E=12 => 6 + 8 - 12 = 2.",
            expHi = "त्रिविमीय बहुफलकों के लिए ऑयलर का सूत्र F + V - E = 2 है। उदाहरण के लिए घन (Cube) में: F=6, V=8, E=12 => 6 + 8 - 12 = 2।",
            yearTag = "CTET Paper-2 Jan 2024 / UPTET 2022",
            subTopic = "3D Shapes & Euler's Formula"
        )
    )

    // =========================================================================
    // 4. SCIENCE & PEDAGOGY (विज्ञान एवं शिक्षण शास्त्र — Paper 2)
    // =========================================================================
    val scienceSeeds = listOf(
        RawTetPyqSeed(
            qEn = "In the human digestive system, where is 'Bile juice' produced, where is it stored, and what is its primary role in digestion?",
            qHi = "मानव पाचन तंत्र में 'पित्त रस (Bile Juice)' का निर्माण कहाँ होता है, यह कहाँ संग्रहीत होता है और पाचन में इसकी मुख्य भूमिका क्या है?",
            optsEn = listOf(
                "Produced in Liver, stored in Gall Bladder; it lacks enzymes but emulsifies fats into tiny droplets and makes the medium alkaline",
                "Produced in Pancreas, stored in Liver; it digests proteins into amino acids",
                "Produced in Stomach, stored in Duodenum; it digests starch into maltose",
                "Produced in Gall Bladder, stored in Spleen; it absorbs water"
            ),
            optsHi = listOf(
                "यकृत (Liver) में निर्मित, पित्ताशय (Gall Bladder) में संग्रहीत; इसमें कोई एंजाइम नहीं होता किंतु यह वसा का पायसीकरण (Emulsification) करता है और माध्यम को क्षारीय बनाता है",
                "अग्न्याशय में निर्मित, यकृत में संग्रहीत; यह प्रोटीन को अमीनो अम्ल में पचाता है",
                "आमाशय में निर्मित, ग्रहणी में संग्रहीत; यह मंड को माल्टोज में बदलता है",
                "पित्ताशय में निर्मित, प्लीहा में संग्रहीत; यह जल का अवशोषण करता है"
            ),
            expEn = "The liver (largest gland in the human body) secretes bile juice which is stored in the gall bladder. Although bile contains no digestive enzymes, its bile salts emulsify large fat globules.",
            expHi = "यकृत (मानव शरीर की सबसे बड़ी ग्रंथि) पित्त रस स्रावित करता है जो पित्ताशय में जमा होता है। पित्त में कोई पाचक एंजाइम नहीं होता, पर इसके पित्त लवण वसा की बड़ी गोलिकाओं का पायसीकरण करते हैं।",
            yearTag = "CTET Paper-2 Jul 2024 / Jan 2024",
            subTopic = "Human Physiology & Nutrition"
        ),
        RawTetPyqSeed(
            qEn = "Which non-metal is a liquid at room temperature, and which metal can be easily cut with a knife and is stored immersed in kerosene oil?",
            qHi = "कौन-सी अधातु कमरे के तापमान पर द्रव अवस्था में पाई जाती है, और कौन-सी धातु चाकू से आसानी से काटी जा सकती है तथा मिट्टी के तेल (Kerosene) में डुबोकर रखी जाती है?",
            optsEn = listOf(
                "Non-metal: Bromine (Br); Metal: Sodium (Na) / Potassium (K)",
                "Non-metal: Mercury (Hg); Metal: Iron (Fe)",
                "Non-metal: Iodine (I); Metal: Copper (Cu)",
                "Non-metal: Chlorine (Cl); Metal: Aluminium (Al)"
            ),
            optsHi = listOf(
                "अधातु: ब्रोमीन (Br); धातु: सोडियम (Na) / पोटैशियम (K)",
                "अधातु: पारा (Hg); धातु: लोहा (Fe)",
                "अधातु: आयोडीन (I); धातु: ताँबा (Cu)",
                "अधातु: क्लोरीन (Cl); धातु: एल्युमिनियम (Al)"
            ),
            expEn = "Bromine is the only non-metal that is liquid at room temperature (Mercury is a liquid metal). Sodium and Potassium are soft, highly reactive alkali metals stored under kerosene to prevent reaction with air/moisture.",
            expHi = "ब्रोमीन एकमात्र अधातु है जो कमरे के ताप पर द्रव है (पारा द्रव धातु है)। सोडियम और पोटैशियम अत्यंत क्रियाशील व मुलायम धातुएँ हैं जिन्हें हवा और नमी से बचाने के लिए केरोसिन में रखा जाता है।",
            yearTag = "CTET Paper-2 Aug 2023 / UPTET Paper-2 2022",
            subTopic = "Metals & Non-Metals"
        ),
        RawTetPyqSeed(
            qEn = "When an ant bites, which acid does it inject into the skin, and which common household substance can be rubbed to neutralize its effect?",
            qHi = "चींटी के डंक मारने पर वह त्वचा में कौन-सा अम्ल छोड़ती है, और इसके प्रभाव को उदासीन (Neutralize) करने के लिए कौन-सा सामान्य घरेलू पदार्थ रगड़ा जा सकता है?",
            optsEn = listOf(
                "Formic acid (Methanoic acid); neutralized by Moist Baking Soda (Sodium Hydrogen Carbonate) or Calamine solution (Zinc Carbonate)",
                "Hydrochloric acid; neutralized by Lemon juice",
                "Acetic acid; neutralized by Vinegar",
                "Lactic acid; neutralized by Curd"
            ),
            optsHi = listOf(
                "फॉर्मिक अम्ल (मेथेनोइक अम्ल); नमीयुक्त बेकिंग सोडा (सोडियम हाइड्रोजन कार्बोनेट) या कैलामाइन विलयन (जिंक कार्बोनेट) द्वारा उदासीन किया जाता है",
                "हाइड्रोक्लोरिक अम्ल; नींबू के रस द्वारा उदासीन",
                "एसिटिक अम्ल; सिरके द्वारा उदासीन",
                "लैक्टिक अम्ल; दही द्वारा उदासीन"
            ),
            expEn = "Ant sting injects Formic (Methanoic) acid (HCOOH). Applying a mild base like baking soda (NaHCO₃) or calamine lotion (ZnCO₃) neutralizes the acid and relieves pain.",
            expHi = "चींटी के डंक में फॉर्मिक (मेथेनोइक) अम्ल होता है। इस पर बेकिंग सोडा (NaHCO₃) या कैलामाइन विलयन (ZnCO₃) जैसा मृदु क्षार लगाने से उदासीनीकरण अभिक्रिया होती है और जलन शांत होती है।",
            yearTag = "CTET Paper-2 Jan 2024 / Dec 2022",
            subTopic = "Acids, Bases & Salts"
        ),
        RawTetPyqSeed(
            qEn = "Which spherical mirror is used by dentists to see enlarged images of teeth and as reflectors in vehicle headlights, and which mirror is used as a rear-view mirror in vehicles?",
            qHi = "दंत चिकित्सकों द्वारा दाँतों का बड़ा प्रतिबिंब देखने और वाहनों की हेडलाइट में परावर्तक के रूप में किस दर्पण का उपयोग होता है, तथा वाहनों में 'पश्च-दृश्य (Rear-view) दर्पण' के रूप में किसका उपयोग होता है?",
            optsEn = listOf(
                "Dentist & Headlight: Concave Mirror; Vehicle Rear-view Mirror: Convex Mirror",
                "Dentist & Headlight: Convex Mirror; Vehicle Rear-view Mirror: Concave Mirror",
                "Both use Plane Mirrors only",
                "Both use Cylindrical Lenses only"
            ),
            optsHi = listOf(
                "दंत चिकित्सक व हेडलाइट: अवतल दर्पण (Concave Mirror); वाहन पश्च-दृश्य दर्पण: उत्तल दर्पण (Convex Mirror)",
                "दंत चिकित्सक व हेडलाइट: उत्तल दर्पण; वाहन पश्च-दृश्य दर्पण: अवतल दर्पण",
                "दोनों में केवल समतल दर्पण का उपयोग होता है",
                "दोनों में केवल बेलनाकार लेंस का उपयोग होता है"
            ),
            expEn = "Concave mirror forms a virtual, erect, and magnified image when the object is placed within its focus (useful for dentists). Convex mirror always forms a diminished, erect image providing a wider field of view for rear-view mirrors.",
            expHi = "अवतल दर्पण फोकस के भीतर रखी वस्तु का आभासी, सीधा और आवर्धित प्रतिबिंब बनाता है (दंत चिकित्सक हेतु उपयोगी)। उत्तल दर्पण सदैव छोटा व सीधा प्रतिबिंब बनाता है जिससे पीछे का विस्तृत क्षेत्र दिखाई देता है।",
            yearTag = "CTET Paper-2 Jul 2024 / Aug 2023 / UTET 2023",
            subTopic = "Light: Reflection & Refraction"
        ),
        RawTetPyqSeed(
            qEn = "Arrange the three types of friction — Static friction, Sliding friction, and Rolling friction — in DECREASING order of their magnitude:",
            qHi = "घर्षण के तीन प्रकारों — स्थैतिक घर्षण (Static), सर्पी घर्षण (Sliding) और लोटनिक घर्षण (Rolling) — को उनके परिमाण के घटते क्रम (अधिकतम से न्यूनतम) में व्यवस्थित कीजिए:",
            optsEn = listOf(
                "Static Friction > Sliding Friction > Rolling Friction",
                "Rolling Friction > Sliding Friction > Static Friction",
                "Sliding Friction > Static Friction > Rolling Friction",
                "Static Friction > Rolling Friction > Sliding Friction"
            ),
            optsHi = listOf(
                "स्थैतिक घर्षण > सर्पी घर्षण > लोटनिक घर्षण",
                "लोटनिक घर्षण > सर्पी घर्षण > स्थैतिक घर्षण",
                "सर्पी घर्षण > स्थैतिक घर्षण > लोटनिक घर्षण",
                "स्थैतिक घर्षण > लोटनिक घर्षण > सर्पी घर्षण"
            ),
            expEn = "Interlocking of irregularities is maximum at rest (Static friction), slightly less when already sliding (Sliding friction), and minimum when rolling (Rolling friction—why ball bearings and wheels are used).",
            expHi = "विरामावस्था में अनियमितताओं का अंतःबंधन सर्वाधिक होता है (स्थैतिक घर्षण), फिसलते समय उससे कम (सर्पी घर्षण) और लुढ़कते समय न्यूनतम (लोटनिक घर्षण) होता है।",
            yearTag = "CTET Paper-2 Jan 2024 / Dec 2022",
            subTopic = "Force, Pressure & Friction"
        ),
        RawTetPyqSeed(
            qEn = "Which cell organelle is known as the 'Powerhouse of the Cell' because it synthesizes ATP, and which two eukaryotic organelles possess their own circular DNA and 70S ribosomes?",
            qHi = "किस कोशिकांग को ATP संश्लेषण के कारण 'कोशिका का ऊर्जा गृह (Powerhouse of the Cell)' कहा जाता है, और किन दो यूकैरियोटिक कोशिकांगों के पास अपना स्वयं का वृत्ताकार DNA तथा 70S राइबोसोम होता है?",
            optsEn = listOf(
                "Mitochondria; Mitochondria and Plastids (Chloroplasts) are semi-autonomous with their own DNA",
                "Golgi Apparatus; Ribosome and Centrosome",
                "Lysosome; Endoplasmic Reticulum and Vacuole",
                "Nucleolus; Peroxisome and Lysosome"
            ),
            optsHi = listOf(
                "माइटोकॉन्ड्रिया; माइटोकॉन्ड्रिया और लवक (क्लोरोप्लास्ट) अर्ध-स्वायत्त हैं जिनमें अपना स्वयं का DNA होता है",
                "गॉल्जीकाय; राइबोसोम और तारककाय",
                "लाइसोसोम; अंतर्द्रव्यी जालिका और रसधानी",
                "केंद्रिका; पेरॉक्सिसोम और लाइसोसोम"
            ),
            expEn = "Mitochondria produce cellular energy (ATP) via aerobic respiration. Both Mitochondria and Chloroplasts (Plastids) have their own DNA and ribosomes, making them semi-autonomous organelles (Lysosome is the 'suicidal bag').",
            expHi = "माइटोकॉन्ड्रिया वायवीय श्वसन द्वारा ATP ऊर्जा का निर्माण करता है। माइटोकॉन्ड्रिया और क्लोरोप्लास्ट (हरितलवक) दोनों में अपना DNA और राइबोसोम होता है, अतः इन्हें अर्ध-स्वायत्त कोशिकांग कहते हैं।",
            yearTag = "CTET Paper-2 Jul 2024 / UPTET Paper-2 2022",
            subTopic = "Cell Structure & Function"
        ),
        RawTetPyqSeed(
            qEn = "In the 5E Instructional Model of Constructivist Science Teaching (by Rodger Bybee), what is the correct sequential order of the five phases?",
            qHi = "रचनावादी विज्ञान शिक्षण के '5E अनुदेशनात्मक मॉडल' (रॉजर बायबी द्वारा प्रतिपादित) में पाँच चरणों का सही अनुक्रम क्या है?",
            optsEn = listOf(
                "Engage -> Explore -> Explain -> Elaborate -> Evaluate",
                "Explain -> Engage -> Explore -> Evaluate -> Elaborate",
                "Explore -> Explain -> Engage -> Elaborate -> Evaluate",
                "Evaluate -> Engage -> Explore -> Explain -> Elaborate"
            ),
            optsHi = listOf(
                "संलग्न करना (Engage) -> अन्वेषण (Explore) -> व्याख्या (Explain) -> विस्तार (Elaborate) -> मूल्यांकन (Evaluate)",
                "व्याख्या -> संलग्न करना -> अन्वेषण -> मूल्यांकन -> विस्तार",
                "अन्वेषण -> व्याख्या -> संलग्न करना -> विस्तार -> मूल्यांकन",
                "मूल्यांकन -> संलग्न करना -> अन्वेषण -> व्याख्या -> विस्तार"
            ),
            expEn = "The 5E constructivist model progresses through: (1) Engage (spark curiosity/prior knowledge), (2) Explore (hands-on investigation), (3) Explain (concept articulation), (4) Elaborate (apply to new situations), (5) Evaluate.",
            expHi = "5E रचनावादी मॉडल के पाँच क्रमिक चरण हैं: (1) Engage (रुचि व पूर्व ज्ञान जागृत करना), (2) Explore (खोज व प्रयोग करना), (3) Explain (अवधारणा स्पष्ट करना), (4) Elaborate (नवीन परिस्थितियों में अनुप्रयोग), (5) Evaluate (मूल्यांकन)।",
            yearTag = "CTET Paper-2 Jan 2024 / Aug 2023",
            subTopic = "Science Pedagogy & Inquiry Model"
        ),
        RawTetPyqSeed(
            qEn = "In plants, which vascular tissue transports water and dissolved minerals unidirectionally from roots to leaves, and which tissue translocates food bidirectionally?",
            qHi = "पादपों में कौन-सा संवहन ऊतक जड़ों से पत्तियों तक जल और खनिज लवणों का एकदिशीय परिवहन करता है, और कौन-सा ऊतक भोजन का द्विदिशीय स्थानांतरण करता है?",
            optsEn = listOf(
                "Water & Minerals: Xylem; Prepared Food (Sucrose): Phloem",
                "Water & Minerals: Phloem; Prepared Food: Xylem",
                "Water & Minerals: Cambium; Prepared Food: Epidermis",
                "Water & Minerals: Stomata; Prepared Food: Cuticle"
            ),
            optsHi = listOf(
                "जल एवं खनिज: जाइलम (Xylem); निर्मित भोजन (सुक्रोज): फ्लोएम (Phloem)",
                "जल एवं खनिज: फ्लोएम; निर्मित भोजन: जाइलम",
                "जल एवं खनिज: कैम्बियम; निर्मित भोजन: एपिडर्मिस",
                "जल एवं खनिज: रंध्र; निर्मित भोजन: क्यूटिकल"
            ),
            expEn = "Xylem transports water and minerals upward from roots to shoots driven by transpiration pull. Phloem translocates photosynthesized food (sucrose) from leaves to all plant parts.",
            expHi = "जाइलम (दारु) वाष्पोत्सर्जन खिंचाव की सहायता से जड़ों से पत्तियों तक जल व खनिज पहुँचाता है, जबकि फ्लोएम (पोषवाह) पत्तियों में बने भोजन को पौधे के सभी भागों में पहुँचाता है।",
            yearTag = "CTET Paper-2 Dec 2022 / UTET Paper-2 2023",
            subTopic = "Plant Physiology"
        ),
        RawTetPyqSeed(
            qEn = "The pitch of a sound wave depends on which physical property, while its loudness depends on which property?",
            qHi = "ध्वनि तरंग का 'तारत्व (Pitch)' उसके किस भौतिक गुण पर निर्भर करता है, जबकि उसकी 'प्रबलता (Loudness)' किस गुण पर निर्भर करती है?",
            optsEn = listOf(
                "Pitch depends on Frequency (Hz); Loudness is proportional to the square of Amplitude (A²)",
                "Pitch depends on Amplitude; Loudness depends on Wavelength",
                "Pitch depends on Speed of sound; Loudness depends on Frequency",
                "Both Pitch and Loudness depend only on Temperature"
            ),
            optsHi = listOf(
                "तारत्व आवृत्ति (Frequency - Hz) पर निर्भर करता है; प्रबलता आयाम के वर्ग (Amplitude²) के समानुपाती होती है",
                "तारत्व आयाम पर निर्भर करता है; प्रबलता तरंगदैर्ध्य पर निर्भर करती है",
                "तारत्व ध्वनि की चाल पर निर्भर करता है; प्रबलता आवृत्ति पर",
                "तारत्व और प्रबलता दोनों केवल तापमान पर निर्भर करते हैं"
            ),
            expEn = "Higher frequency produces higher pitch (shrill voice like a bird or whistle). Larger amplitude produces louder sound (Loudness ∝ Amplitude², measured in decibels dB).",
            expHi = "उच्च आवृत्ति से उच्च तारत्व (तीखी/पतली आवाज) उत्पन्न होती है। अधिक आयाम से ध्वनि अधिक प्रबल होती है (प्रबलता ∝ आयाम², जिसे डेसिबल dB में मापा जाता है)।",
            yearTag = "CTET Paper-2 Jul 2024 / Jan 2024",
            subTopic = "Sound & Waves"
        ),
        RawTetPyqSeed(
            qEn = "Which statement best illustrates the tentative yet reliable nature of scientific knowledge in Science Pedagogy?",
            qHi = "विज्ञान शिक्षण शास्त्र में निम्नलिखित में से कौन-सा कथन वैज्ञानिक ज्ञान की 'अनंतिम किंतु विश्वसनीय (Tentative yet Reliable)' प्रकृति को सर्वोत्तम रूप से स्पष्ट करता है?",
            optsEn = listOf(
                "Scientific theories are well-substantiated by empirical evidence, but they remain open to revision when new evidence or observations emerge",
                "Scientific laws are absolute, eternal dogmas that can never be questioned",
                "Scientific hypotheses automatically become laws after 50 years",
                "Science relies purely on personal opinions rather than observation"
            ),
            optsHi = listOf(
                "वैज्ञानिक सिद्धांत आनुभविक साक्ष्यों द्वारा सुपुष्ट होते हैं, किंतु नए साक्ष्य या प्रेक्षण मिलने पर उनमें संशोधन की संभावना सदैव बनी रहती है",
                "वैज्ञानिक नियम पूर्णतः शाश्वत और अपरिवर्तनीय रूढ़ियाँ हैं जिन पर कभी प्रश्न नहीं उठाया जा सकता",
                "वैज्ञानिक परिकल्पनाएँ 50 वर्षों के बाद स्वतः ही नियम बन जाती हैं",
                "विज्ञान प्रेक्षण के बजाय केवल व्यक्तिगत राय पर आधारित होता है"
            ),
            expEn = "According to NCF 2005, science is a dynamic, empirical body of knowledge where theories are robust explanations grounded in evidence yet open to falsification and refinement.",
            expHi = "NCF-2005 के अनुसार विज्ञान एक गतिशील एवं आनुभविक ज्ञान प्रणाली है जहाँ सिद्धांत ठोस प्रमाणों पर आधारित होते हैं, परंतु नए वैज्ञानिक साक्ष्यों के आलोक में परिष्कार के लिए सदैव खुले रहते हैं।",
            yearTag = "CTET Paper-2 Jan 2024 / Aug 2023",
            subTopic = "Nature of Science & Pedagogy"
        )
    )

    // =========================================================================
    // 5. SOCIAL SCIENCE / SST & PEDAGOGY (सामाजिक अध्ययन एवं पेडागोजी — Paper 2)
    // =========================================================================
    val socialScienceSeeds = listOf(
        RawTetPyqSeed(
            qEn = "Match the Indus Valley Civilization (Harappan) sites with their distinctive archaeological findings according to NCERT 'Our Pasts - I':",
            qHi = "NCERT 'हमारे अतीत - I' के अनुसार सिंधु घाटी सभ्यता (हड़प्पा) के स्थलों का उनके विशिष्ट पुरातात्विक साक्ष्यों से सही मिलान कौन-सा है?",
            optsEn = listOf(
                "Lothal (Gujarat) -> Dockyard & Bead factory; Kalibangan (Rajasthan) -> Ploughed field & Fire altars; Dholavira (Rann of Kutch) -> Three-part city division & Water reservoirs; Mohenjodaro -> Great Bath",
                "Lothal -> Great Bath; Mohenjodaro -> Dockyard; Dholavira -> Ashokan Pillar",
                "Kalibangan -> Iron furnace; Harappa -> Cave paintings",
                "Dholavira -> Stupa of Sanchi; Lothal -> Rock-cut Kailasa temple"
            ),
            optsHi = listOf(
                "लोथल (गुजरात) -> गोदीवाड़ा (Dockyard) व मनका कारखाना; कालीबंगा (राजस्थान) -> जुते हुए खेत व अग्निकुंड; धोलावीरा (कच्छ) -> तीन भागों में विभाजित नगर व जल कुंड; मोहनजोदड़ो -> विशाल स्नानागार",
                "लोथल -> विशाल स्नानागार; मोहनजोदड़ो -> गोदीवाड़ा; धोलावीरा -> अशोक स्तंभ",
                "कालीबंगा -> लोहे की भट्टी; हड़प्पा -> गुफा चित्र",
                "धोलावीरा -> साँची स्तूप; लोथल -> कैलाश मंदिर"
            ),
            expEn = "In NCERT Class 6 History: Lothal on the Bhogava river (Sabarmati tributary) had a tidal dockyard; Kalibangan had ploughed fields and fire altars; Dholavira was divided into three parts (unlike two elsewhere).",
            expHi = "NCERT कक्षा 6 इतिहास के अनुसार: भोगवा नदी के तट पर स्थित लोथल में बंदरगाह (गोदीवाड़ा) मिला; कालीबंगा में जुते हुए खेत व अग्निकुंड मिले; तथा धोलावीरा अन्य नगरों के विपरीत दो के बजाय तीन भागों में विभाजित था।",
            yearTag = "CTET Paper-2 Jul 2024 / Jan 2024 / Aug 2023",
            subTopic = "Ancient History (NCERT Our Pasts-I)"
        ),
        RawTetPyqSeed(
            qEn = "Which of the following pairs of 'Social Reformers and Organizations/Books' of 19th-century India is CORRECTLY matched (NCERT 'Our Pasts - III')?",
            qHi = "19वीं शताब्दी के भारत के 'समाज सुधारकों और उनके संगठनों/पुस्तकों' का निम्नलिखित में से कौन-सा युग्म सही सुमेलित है (NCERT 'हमारे अतीत - III')?",
            optsEn = listOf(
                "Jyotirao Phule -> Satyashodhak Samaj (1873) & 'Gulamgiri'; Pandita Ramabai -> Mukti Mission; Tarabai Shinde -> 'Stripurushtulna'; Periyar E.V. Ramasamy -> Self-Respect Movement",
                "Raja Rammohun Roy -> Arya Samaj; Swami Dayanand Saraswati -> Brahmo Samaj",
                "Ishwar Chandra Vidyasagar -> Aligarh Movement; Sir Syed Ahmed Khan -> Prarthana Samaj",
                "Swami Vivekananda -> Satnami Movement; Ghasidas -> Ramakrishna Mission"
            ),
            optsHi = listOf(
                "ज्योतिराव फुले -> सत्यशोधक समाज (1873) व 'गुलामगिरी'; पंडिता रमाबाई -> मुक्ति मिशन; ताराबाई शिंदे -> 'स्त्री-पुरुष तुलना'; पेरियार ई.वी. रामासामी -> स्वाभिमान आंदोलन",
                "राजा राममोहन राय -> आर्य समाज; स्वामी दयानंद सरस्वती -> ब्रह्म समाज",
                "ईश्वर चंद्र विद्यासागर -> अलीगढ़ आंदोलन; सर सैयद अहमद खान -> प्रार्थना समाज",
                "स्वामी विवेकानंद -> सतनामी आंदोलन; घासीदास -> रामकृष्ण मिशन"
            ),
            expEn = "Jyotirao Phule founded Satyashodhak Samaj and wrote 'Gulamgiri' (1873, dedicated to American abolitionists). Tarabai Shinde wrote 'Stripurushtulna', and Pandita Ramabai founded Mukti Mission in Khedgaon (Pune).",
            expHi = "ज्योतिराव फुले ने सत्यशोधक समाज की स्थापना की और 1873 में 'गुलामगिरी' लिखी। ताराबाई शिंदे ने 'स्त्री-पुरुष तुलना' पुस्तक लिखी और पंडिता रमाबाई ने पुणे (खेडगाँव) में मुक्ति मिशन स्थापित किया।",
            yearTag = "CTET Paper-2 Jul 2024 / Jan 2024",
            subTopic = "Modern History & Social Reform"
        ),
        RawTetPyqSeed(
            qEn = "In which layer of the Earth's atmosphere do all weather phenomena occur, in which layer is the Ozone layer located (ideal for flying jet aeroplanes), and in which layer do meteorites burn up?",
            qHi = "पृथ्वी के वायुमंडल की किस परत में सभी मौसमी घटनाएँ होती हैं, किस परत में ओजोन परत स्थित है (जो जेट विमान उड़ाने के लिए आदर्श है), और किस परत में उल्कापिंड जलकर नष्ट होते हैं?",
            optsEn = listOf(
                "Weather: Troposphere; Ozone & Jet Planes: Stratosphere; Burning of Meteorites: Mesosphere",
                "Weather: Stratosphere; Ozone: Mesosphere; Meteorites: Thermosphere",
                "Weather: Mesosphere; Ozone: Troposphere; Meteorites: Exosphere",
                "Weather: Thermosphere; Ozone: Exosphere; Meteorites: Stratosphere"
            ),
            optsHi = listOf(
                "मौसमी घटनाएँ: क्षोभमंडल (Troposphere); ओजोन परत व जेट विमान: समतापमंडल (Stratosphere); उल्कापिंडों का जलना: मध्यमंडल (Mesosphere)",
                "मौसमी घटनाएँ: समतापमंडल; ओजोन: मध्यमंडल; उल्कापिंड: तापमंडल",
                "मौसमी घटनाएँ: मध्यमंडल; ओजोन: क्षोभमंडल; उल्कापिंड: बहिर्मंडल",
                "मौसमी घटनाएँ: तापमंडल; ओजोन: बहिर्मंडल; उल्कापिंड: समतापमंडल"
            ),
            expEn = "From NCERT Class 7 Geography ('Air'): Troposphere (0–13 km) hosts clouds/rain; Stratosphere (13–50 km) is cloud-free and contains the Ozone layer; Mesosphere (50–80 km) burns up incoming meteors; Ionosphere/Thermosphere helps radio transmission.",
            expHi = "NCERT कक्षा 7 भूगोल ('वायु') के अनुसार: क्षोभमंडल में वर्षा व बादल बनते हैं; समतापमंडल बादलों से मुक्त होता है व इसमें ओजोन परत होती है; मध्यमंडल में अंतरिक्ष से आने वाले उल्कापिंड जल जाते हैं।",
            yearTag = "CTET Paper-2 Aug 2023 / Dec 2022 / UPTET 2022",
            subTopic = "Geography: Atmosphere & Earth"
        ),
        RawTetPyqSeed(
            qEn = "Under the Chola administration (inscriptions from Uttaramerur, Tamil Nadu, NCERT 'Our Pasts - II'), what did the terms 'Vellanvagai', 'Brahmadeya', and 'Shalabhoga' denote?",
            qHi = "चोल प्रशासन (उत्तममेरूर अभिलेख, तमिलनाडु — NCERT 'हमारे अतीत - II') के अंतर्गत 'वेल्लनवगाई', 'ब्रह्मदेय' और 'शालाभोग' शब्द किसका उल्लेख करते थे?",
            optsEn = listOf(
                "Categories of land: Vellanvagai (land of non-Brahmana peasant proprietors), Brahmadeya (land gifted to Brahmanas), Shalabhoga (land for maintenance of a school)",
                "Names of sea ports on the Coromandel coast",
                "Ranks of cavalry commanders in the Chola army",
                "Types of gold coins minted by Rajaraja I"
            ),
            optsHi = listOf(
                "भूमि की श्रेणियाँ: वेल्लनवगाई (गैर-ब्राह्मण किसान स्वामी की भूमि), ब्रह्मदेय (ब्राह्मणों को उपहार में दी गई भूमि), शालाभोग (विद्यालय के रखरखाव के लिए भूमि)",
                "कोरोमंडल तट के समुद्री बंदरगाहों के नाम",
                "चोल सेना में घुड़सवार सेनापतियों के पद",
                "राजराज प्रथम द्वारा ढाले गए स्वर्ण सिक्कों के प्रकार"
            ),
            expEn = "Chola inscriptions mention five land categories: Vellanvagai (non-Brahmana peasants), Brahmadeya (gifted to Brahmanas), Shalabhoga (for schools), Devadana/Tirunamattukkani (gifted to temples), and Pallichchhandam (donated to Jaina institutions).",
            expHi = "चोल अभिलेखों में भूमि की 5 श्रेणियों का उल्लेख है: वेल्लनवगाई (गैर-ब्राह्मण किसान भूमि), ब्रह्मदेय (ब्राह्मणों को दान), शालाभोग (विद्यालय हेतु), देवदान (मंदिरों को दान) और पल्लिचंदम (जैन संस्थाओं को दान)।",
            yearTag = "CTET Paper-2 Jan 2024 / Jul 2024",
            subTopic = "Medieval History (NCERT Our Pasts-II)"
        ),
        RawTetPyqSeed(
            qEn = "Which Fundamental Right in the Indian Constitution did Dr. B.R. Ambedkar describe as the 'Heart and Soul of the Constitution', and under which Article does it fall?",
            qHi = "भारतीय संविधान के किस मौलिक अधिकार को डॉ. बी.आर. अंबेडकर ने 'संविधान का हृदय और आत्मा' कहा था, और यह किस अनुच्छेद के अंतर्गत आता है?",
            optsEn = listOf(
                "Right to Constitutional Remedies (Article 32)",
                "Right to Equality (Article 14 to 18)",
                "Right to Freedom of Religion (Article 25 to 28)",
                "Cultural and Educational Rights (Article 29 to 30)"
            ),
            optsHi = listOf(
                "संवैधानिक उपचारों का अधिकार (अनुच्छेद 32)",
                "समानता का अधिकार (अनुच्छेद 14 से 18)",
                "धार्मिक स्वतंत्रता का अधिकार (अनुच्छेद 25 से 28)",
                "संस्कृति और शिक्षा संबंधी अधिकार (अनुच्छेद 29 से 30)"
            ),
            expEn = "Dr. B.R. Ambedkar called Article 32 (Right to Constitutional Remedies) the heart and soul of the Constitution because it empowers citizens to move the Supreme Court directly for enforcement of Fundamental Rights.",
            expHi = "डॉ. बी.आर. अंबेडकर ने अनुच्छेद 32 (संवैधानिक उपचारों का अधिकार) को संविधान की आत्मा और हृदय कहा क्योंकि यह नागरिकों को अपने मौलिक अधिकारों के प्रवर्तन के लिए सीधे सर्वोच्च न्यायालय जाने का अधिकार देता है।",
            yearTag = "CTET Paper-2 Aug 2023 / UPTET 2022 / UTET 2023",
            subTopic = "Social & Political Life (Civics)"
        ),
        RawTetPyqSeed(
            qEn = "In Social Science Pedagogy, if a teacher takes students to a local historical monument and asks them to examine old coins, inscriptions, and manuscripts, these materials are classified as:",
            qHi = "सामाजिक विज्ञान शिक्षण शास्त्र में, यदि एक शिक्षक छात्रों को स्थानीय ऐतिहासिक स्मारक पर ले जाता है और उन्हें पुराने सिक्कों, शिलालेखों और पांडुलिपियों का परीक्षण करने को कहता है, तो ये सामग्रियाँ किस रूप में वर्गीकृत की जाती हैं?",
            optsEn = listOf(
                "Primary Sources (original artifacts/records created during the historical period under study)",
                "Secondary Sources (commentaries written centuries later)",
                "Fictional Literature",
                "Tertiary Encyclopedic Summaries"
            ),
            optsHi = listOf(
                "प्राथमिक स्रोत (Primary Sources — अध्ययन के ऐतिहासिक काल के दौरान निर्मित मूल पुरावशेष/अभिलेख)",
                "द्वितीयक स्रोत (Secondary Sources — सदियों बाद लिखी गई समीक्षाएँ)",
                "काल्पनिक साहित्य",
                "तृतीयक विश्वकोशीय सारांश"
            ),
            expEn = "Coins, inscriptions, monuments, eyewitness accounts, diaries, and original manuscripts from the period are Primary Sources; modern textbooks, review articles, and biographies written later are Secondary Sources.",
            expHi = "उस काल के सिक्के, अभिलेख, स्मारक, प्रत्यक्षदर्शी विवरण और मूल पांडुलिपियाँ 'प्राथमिक स्रोत' हैं, जबकि बाद में उन पर आधारित पाठ्यपुस्तकें या समीक्षात्मक पुस्तकें 'द्वितीयक स्रोत' हैं।",
            yearTag = "CTET Paper-2 Jul 2024 / Jan 2024",
            subTopic = "Primary vs Secondary Sources in SST"
        ),
        RawTetPyqSeed(
            qEn = "Why did the NCF-2005 recommend changing the title of the Upper Primary Civics textbook from 'Civics' to 'Social and Political Life'?",
            qHi = "NCF-2005 ने उच्च प्राथमिक स्तर की नागरिक शास्त्र की पाठ्यपुस्तक का नाम 'नागरिक शास्त्र (Civics)' से बदलकर 'सामाजिक एवं राजनीतिक जीवन (Social and Political Life)' रखने की अनुशंसा क्यों की?",
            optsEn = listOf(
                "'Civics' emerged in the colonial era focusing on passive obedience/loyalty to the Raj, whereas 'Social and Political Life' fosters critical thinking, democratic participation, equality, and lived social realities",
                "Because the word 'Civics' was difficult for Class 6 students to spell",
                "To eliminate the study of the Indian Constitution from schools",
                "To replace political science entirely with ancient mythology"
            ),
            optsHi = listOf(
                "'नागरिक शास्त्र' औपनिवेशिक काल में ब्रिटिश राज के प्रति आज्ञाकारिता विकसित करने के लिए उभरा था, जबकि 'सामाजिक एवं राजनीतिक जीवन' आलोचनात्मक चिंतन, लोकतांत्रिक भागीदारी, समानता और वास्तविक सामाजिक अनुभवों पर बल देता है",
                "क्योंकि कक्षा 6 के छात्रों के लिए 'सिविक्स' शब्द की वर्तनी कठिन थी",
                "विद्यालयों से भारतीय संविधान के अध्ययन को समाप्त करने के लिए",
                "राजनीति विज्ञान को पूर्णतः प्राचीन कथाओं से बदलने के लिए"
            ),
            expEn = "NCF 2005 Position Paper on Social Sciences noted that 'Civics' had colonial origins emphasizing citizen obedience, whereas 'Social and Political Life' engages learners critically with democratic institutions, diversity, and social justice.",
            expHi = "NCF-2005 के अनुसार 'नागरिक शास्त्र' की पृष्ठभूमि औपनिवेशिक आज्ञापालन से जुड़ी थी, जबकि 'सामाजिक एवं राजनीतिक जीवन' लोकतांत्रिक संस्थाओं, विविधता, न्याय और आलोचनात्मक समझ को केंद्र में रखता है।",
            yearTag = "CTET Paper-2 Jan 2024 / Aug 2023",
            subTopic = "Pedagogy of Social Science"
        ),
        RawTetPyqSeed(
            qEn = "When it is 12:00 Noon at Greenwich (0° Prime Meridian), what will be the Indian Standard Time (IST) along the 82°30' East Meridian (Mirzapur, UP)?",
            qHi = "जब ग्रीनविच (0° प्रधान याम्योत्तर) पर दोपहर के 12:00 बजे हों, तब 82°30' पूर्वी देशांतर (मिर्जापुर, उ.प्र.) पर आधारित भारतीय मानक समय (IST) क्या होगा?",
            optsEn = listOf(
                "5:30 PM (5 hours 30 minutes ahead of GMT)",
                "6:30 AM (5 hours 30 minutes behind GMT)",
                "4:00 PM",
                "12:00 Midnight"
            ),
            optsHi = listOf(
                "शाम के 5:30 बजे (GMT से 5 घंटे 30 मिनट आगे)",
                "सुबह के 6:30 बजे (GMT से 5 घंटे 30 मिनट पीछे)",
                "शाम के 4:00 बजे",
                "मध्यरात्रि 12:00 बजे"
            ),
            expEn = "Earth rotates 360° in 24 hours => 1° in 4 minutes (15° in 1 hour). Since India is at 82.5° East: 82.5 × 4 = 330 minutes = 5 hours 30 minutes ahead of GMT. So 12:00 Noon + 5:30 = 5:30 PM.",
            expHi = "पृथ्वी 24 घंटे में 360° घूमती है, अर्थात् 1° देशांतर = 4 मिनट (15° = 1 घंटा)। भारत 82.5° पूर्व में है, अतः 82.5 × 4 = 330 मिनट = 5 घंटे 30 मिनट GMT से आगे। अतः शाम के 5:30 बजेंगे।",
            yearTag = "CTET Paper-2 Dec 2022 / UPTET 2022 / UTET 2023",
            subTopic = "Globe: Latitudes & Longitudes"
        ),
        RawTetPyqSeed(
            qEn = "Which of the following is an example of 'Intrusive Igneous Rock', 'Extrusive Igneous Rock', and 'Metamorphic Rock' respectively?",
            qHi = "निम्नलिखित में से कौन-सा क्रमशः 'अंतर्भेदी आग्नेय शैल (Intrusive Igneous)', 'बहिर्भेदी आग्नेय शैल (Extrusive Igneous)' और 'कायांतरित शैल (Metamorphic)' का सही उदाहरण है?",
            optsEn = listOf(
                "Intrusive Igneous: Granite; Extrusive Igneous: Basalt (Deccan Trap); Metamorphic: Marble (from Limestone) & Slate (from Clay)",
                "Intrusive Igneous: Sandstone; Extrusive Igneous: Coal; Metamorphic: Basalt",
                "Intrusive Igneous: Marble; Extrusive Igneous: Granite; Metamorphic: Chalk",
                "Intrusive Igneous: Limestone; Extrusive Igneous: Slate; Metamorphic: Shale"
            ),
            optsHi = listOf(
                "अंतर्भेदी आग्नेय: ग्रेनाइट; बहिर्भेदी आग्नेय: बेसाल्ट (दक्कन ट्रैप); कायांतरित शैल: संगमरमर (चूना पत्थर से) व स्लेट (चिकनी मिट्टी से)",
                "अंतर्भेदी आग्नेय: बलुआ पत्थर; बहिर्भेदी आग्नेय: कोयला; कायांतरित: बेसाल्ट",
                "अंतर्भेदी आग्नेय: संगमरमर; बहिर्भेदी आग्नेय: ग्रेनाइट; कायांतरित: चॉक",
                "अंतर्भेदी आग्नेय: चूना पत्थर; बहिर्भेदी आग्नेय: स्लेट; कायांतरित: शेल"
            ),
            expEn = "Magma cooling slowly deep inside Earth forms large-grained Intrusive Igneous rock (Granite). Lava cooling rapidly on the surface forms fine-grained Extrusive Igneous rock (Basalt). Heat and pressure turn Limestone into Marble and Clay into Slate.",
            expHi = "पृथ्वी के अंदर मैग्मा के धीरे-धीरे ठंडा होने से ग्रेनाइट (अंतर्भेदी आग्नेय) बनता है; सतह पर लावा के तेजी से ठंडा होने से बेसाल्ट (बहिर्भेदी आग्नेय) बनता है; तथा ताप व दाब से चूना पत्थर संगमरमर (कायांतरित) में बदल जाता है।",
            yearTag = "CTET Paper-2 Jul 2024 / Jan 2024",
            subTopic = "Inside Our Earth: Rocks & Minerals"
        ),
        RawTetPyqSeed(
            qEn = "In a Social Science classroom, how should a teacher handle a discussion on 'Gender Roles' when a student says 'Only women should do household chores and cooking'?",
            qHi = "सामाजिक विज्ञान की कक्षा में जब एक छात्र कहता है कि 'घर का काम और खाना पकाना केवल महिलाओं को ही करना चाहिए', तब शिक्षक को 'जेंडर भूमिकाओं' पर चर्चा का संचालन कैसे करना चाहिए?",
            optsEn = listOf(
                "Use counter-examples from real life (such as male chefs, women pilots/scientists) and facilitate critical discussion to challenge gender stereotyping and highlight the unpaid value of care work",
                "Agree with the student because it reflects traditional customs",
                "Scold the student and immediately close the topic without discussion",
                "Tell girls and boys to sit in separate rooms permanently"
            ),
            optsHi = listOf(
                "वास्तविक जीवन के प्रति-उदाहरणों (जैसे पुरुष शेफ, महिला पायलट/वैज्ञानिक) का उपयोग करते हुए आलोचनात्मक चर्चा कराना ताकि जेंडर रूढ़िबद्धता को चुनौती दी जा सके और घरेलू श्रम के महत्व को समझा जा सके",
                "छात्र की बात से सहमत होना क्योंकि यह पारंपरिक रीति-रिवाजों को दर्शाता है",
                "छात्र को डाँटना और बिना किसी चर्चा के तुरंत विषय बंद कर देना",
                "लड़कों और लड़कियों को स्थायी रूप से अलग कमरों में बैठने का आदेश देना"
            ),
            expEn = "Critical pedagogy in Social Science requires questioning stereotypes through dialogue, lived examples, and NCERT case studies (like 'Growing up as Boys and Girls' in Samoa and MP).",
            expHi = "सामाजिक विज्ञान के आलोचनात्मक शिक्षण शास्त्र में संवाद, वास्तविक उदाहरणों और NCERT केस स्टडी ('लड़के और लड़कियों के रूप में बड़ा होना') के माध्यम से जेंडर रूढ़िवादिता पर तार्किक प्रश्न उठाना आवश्यक है।",
            yearTag = "CTET Paper-2 Jul 2024 / Aug 2023",
            subTopic = "Critical Pedagogy & Gender Equality"
        )
    )

    // =========================================================================
    // 6. LANGUAGE I: HINDI & PEDAGOGY (भाषा-I: हिंदी भाषा एवं शिक्षण शास्त्र)
    // =========================================================================
    val hindiSeeds = listOf(
        RawTetPyqSeed(
            qEn = "What is the fundamental difference between 'Language Acquisition (भाषा अर्जन)' and 'Language Learning (भाषा अधिगम)' in Hindi Language Pedagogy?",
            qHi = "हिंदी भाषा शिक्षण शास्त्र में 'भाषा अर्जन (Language Acquisition)' और 'भाषा अधिगम (Language Learning)' के बीच मूलभूत अंतर क्या है?",
            optsEn = listOf(
                "Language Acquisition is a natural, subconscious process in a rich home/social environment (like mother tongue), whereas Language Learning is a conscious, formal, rule-governed effort",
                "Language Acquisition requires formal grammar textbooks and exams, whereas Language Learning happens automatically at birth",
                "Language Acquisition happens only in foreign countries",
                "There is no difference between acquisition and learning"
            ),
            optsHi = listOf(
                "भाषा अर्जन सहज, स्वाभाविक एवं अवचेतन प्रक्रिया है जो समृद्ध परिवेश में होती है (जैसे मातृभाषा), जबकि भाषा अधिगम सचेतन, औपचारिक एवं नियमबद्ध प्रयास है",
                "भाषा अर्जन के लिए व्याकरण की पुस्तकों और परीक्षाओं की आवश्यकता होती है, जबकि अधिगम स्वतः होता है",
                "भाषा अर्जन केवल विदेशी भाषाओं में होता है",
                "भाषा अर्जन और भाषा अधिगम में कोई अंतर नहीं है"
            ),
            expEn = "Language acquisition (अर्जन) occurs naturally and effortlessly through social interaction in one's native environment, while language learning (अधिगम) involves deliberate instruction, rules, and formal schooling.",
            expHi = "भाषा अर्जन सामाजिक अंतःक्रिया व सहज परिवेश के माध्यम से स्वाभाविक रूप से होता है, जबकि भाषा अधिगम में विद्यालयी औपचारिकता, शिक्षक, पाठ्यपुस्तक और व्याकरणिक नियमों का सचेत प्रयास शामिल होता है।",
            yearTag = "CTET Jul 2024 / Jan 2024 / Aug 2023",
            subTopic = "भाषा अर्जन एवं अधिगम"
        ),
        RawTetPyqSeed(
            qEn = "How should 'Multilingualism (बहुभाषिकता)' in an Indian language classroom be viewed by a primary teacher according to NCF 2005 and NEP 2020?",
            qHi = "NCF-2005 और NEP-2020 के अनुसार एक भारतीय भाषा कक्षा में 'बहुभाषिकता (Multilingualism)' को शिक्षक द्वारा किस रूप में देखा जाना चाहिए?",
            optsEn = listOf(
                "As a valuable asset, pedagogical resource, and classroom strategy that enriches cognitive flexibility and respects every child's home language",
                "As a severe obstacle and hindrance in teaching standard Hindi",
                "As a reason to fine students who speak their mother tongue in school",
                "As a problem that requires segregating children by dialect"
            ),
            optsHi = listOf(
                "एक मूल्यवान संसाधन, शैक्षणिक पूँजी और कक्षा-रणनीति के रूप में जो संज्ञानात्मक लचीलेपन को बढ़ाती है तथा प्रत्येक बच्चे की घर की भाषा को सम्मान देती है",
                "मानक हिंदी सिखाने के मार्ग में एक गंभीर बाधा और रुकावट के रूप में",
                "विद्यालय में मातृभाषा बोलने वाले छात्रों को दंडित करने के कारण के रूप में",
                "एक समस्या के रूप में जिसके लिए बच्चों को बोली के आधार पर अलग करना पड़े"
            ),
            expEn = "Multilingualism is constitutive of Indian identity and must be used as a classroom resource (संसाधन) where children's home languages bridge into target language proficiency.",
            expHi = "बहुभाषिकता भारतीय अस्मिता का अभिन्न अंग है और इसे कक्षा में एक 'संसाधन (Resource)' के रूप में प्रयुक्त किया जाना चाहिए ताकि बच्चों की मातृभाषा नई भाषा सीखने का सेतु बन सके।",
            yearTag = "CTET Jul 2024 / Jan 2024 / UTET 2023",
            subTopic = "बहुभाषिकता एवं मातृभाषा"
        ),
        RawTetPyqSeed(
            qEn = "Which of the four basic language skills — Listening (श्रवण), Speaking (वाचन), Reading (पठन), and Writing (लेखन) — are 'Receptive Skills (ग्रहणात्मक कौशल)' and which are 'Productive/Expressive Skills (अभिव्यक्तात्मक कौशल)'?",
            qHi = "भाषा के चार आधारभूत कौशलों — श्रवण (सुनना), वाचन (बोलना), पठन (पढ़ना) और लेखन (लिखना) — में से कौन-से 'ग्रहणात्मक कौशल' हैं और कौन-से 'अभिव्यक्तात्मक/उत्पादक कौशल' हैं?",
            optsEn = listOf(
                "Receptive Skills: Listening & Reading (श्रवण एवं पठन); Productive/Expressive Skills: Speaking & Writing (वाचन एवं लेखन)",
                "Receptive Skills: Speaking & Writing; Productive Skills: Listening & Reading",
                "Receptive Skills: Listening & Speaking; Productive Skills: Reading & Writing",
                "Receptive Skills: Reading & Writing; Productive Skills: Listening & Speaking"
            ),
            optsHi = listOf(
                "ग्रहणात्मक कौशल (अर्थ ग्रहण): सुनना एवं पढ़ना (श्रवण एवं पठन); अभिव्यक्तात्मक कौशल (भाव प्रकटन): बोलना एवं लिखना (वाचन एवं लेखन)",
                "ग्रहणात्मक कौशल: बोलना एवं लिखना; अभिव्यक्तात्मक कौशल: सुनना एवं पढ़ना",
                "ग्रहणात्मक कौशल: सुनना एवं बोलना; अभिव्यक्तात्मक कौशल: पढ़ना एवं लिखना",
                "ग्रहणात्मक कौशल: पढ़ना एवं लिखना; अभिव्यक्तात्मक कौशल: सुनना एवं बोलना"
            ),
            expEn = "Through Listening and Reading we receive and comprehend meaning (ग्रहणात्मक कौशल); through Speaking and Writing we express our thoughts and feelings (अभिव्यक्तात्मक कौशल). All four LSRW skills are integrated.",
            expHi = "सुनकर और पढ़कर हम विचारों व अर्थ को ग्रहण करते हैं (ग्रहणात्मक कौशल), जबकि बोलकर और लिखकर हम अपने विचारों को प्रकट करते हैं (अभिव्यक्तात्मक कौशल)। ये चारों कौशल अंतःसंबंधित हैं।",
            yearTag = "CTET Aug 2023 / Dec 2022 / UPTET 2022",
            subTopic = "भाषा कौशल (LSRW)"
        ),
        RawTetPyqSeed(
            qEn = "In Hindi Pedagogy, what is the MOST important criterion for assessing 'Reading Skill (पठन कौशल)'?",
            qHi = "हिंदी शिक्षण शास्त्र में 'पठन कौशल (Reading Skill)' के आकलन के लिए सर्वाधिक महत्वपूर्ण घटक क्या है?",
            optsEn = listOf(
                "Reading with comprehension / meaning-making (अर्थ ग्रहण करते हुए पढ़ना)",
                "Reading at maximum speed without pausing at punctuation marks",
                "Recognizing individual letters of the alphabet in isolation",
                "Memorizing the poem without understanding a single word"
            ),
            optsHi = listOf(
                "अर्थ ग्रहण करते हुए पढ़ना (संदर्भ के अनुसार समझ के साथ पठन)",
                "विराम चिह्नों पर रुके बिना अधिकतम गति से पढ़ना",
                "वर्णमाला के अलग-अलग अक्षरों की केवल पहचान करना",
                "बिना अर्थ समझे पूरी कविता रट लेना"
            ),
            expEn = "Reading is not mere mechanical decoding of script (ध्वनि-प्रतीक मिलान); the essence of reading (पठन) is meaning-making and comprehension (अर्थ-ग्रहण एवं समझ).",
            expHi = "पढ़ना केवल अक्षरों या लिपि चिह्नों का यांत्रिक उच्चारण मात्र नहीं है; पठन का मूल तत्व 'अर्थ ग्रहण करना (Meaning-making)' और संदर्भ की समझ विकसित करना है।",
            yearTag = "CTET Jul 2024 / Jan 2024",
            subTopic = "पठन कौशल एवं अर्थ-ग्रहण"
        ),
        RawTetPyqSeed(
            qEn = "Which method of teaching Grammar (व्याकरण शिक्षण) presents several examples from familiar contexts first and then guides students to discover the grammatical rule themselves?",
            qHi = "व्याकरण शिक्षण की कौन-सी विधि में पहले परिचित संदर्भों से अनेक उदाहरण प्रस्तुत किए जाते हैं और फिर छात्रों को स्वयं विश्लेषण करके व्याकरणिक नियम निकालने के लिए प्रेरित किया जाता है?",
            optsEn = listOf(
                "Inductive Method (आगमन विधि — उदाहरण से नियम की ओर)",
                "Deductive Method (निगमन विधि — नियम से उदाहरण की ओर)",
                "Rote Memorization Method (सूत्र कंठस्थीकरण विधि)",
                "Dictation Method (श्रुतलेख विधि)"
            ),
            optsHi = listOf(
                "आगमन विधि (Inductive Method — उदाहरण से नियम की ओर, ज्ञात से अज्ञात की ओर)",
                "निगमन विधि (Deductive Method — नियम से उदाहरण की ओर)",
                "सूत्र कंठस्थीकरण विधि",
                "श्रुतलेख विधि"
            ),
            expEn = "The Inductive Method (आगमन विधि) moves from Specific Examples to General Rules, Concrete to Abstract, and Known to Unknown, making it psychological and child-centric for grammar teaching in context (संदर्भ में व्याकरण).",
            expHi = "आगमन विधि 'उदाहरण से नियम की ओर', 'मूर्त से अमूर्त की ओर' और 'ज्ञात से अज्ञात की ओर' चलती है। संदर्भ में व्याकरण सिखाने के लिए यह सर्वाधिक मनोवैज्ञानिक एवं बाल-केंद्रित विधि है।",
            yearTag = "CTET Aug 2023 / UPTET 2022 / UTET 2023",
            subTopic = "व्याकरण शिक्षण की विधियाँ"
        ),
        RawTetPyqSeed(
            qEn = "Identify the correct Sandhi-Vichchhed (संधि-विच्छेद) and Sandhi type of the Hindi word 'उज्ज्वल (Ujjwal)' and 'महोत्सव (Mahotsav)':",
            qHi = "हिंदी शब्द 'उज्ज्वल' तथा 'महोत्सव' का सही संधि-विच्छेद और संधि का प्रकार पहचानिए:",
            optsEn = listOf(
                "उज्ज्वल = उत् + ज्वल (व्यंजन संधि); महोत्सव = महा + उत्सव (गुण स्वर संधि)",
                "उज्ज्वल = उज + ज्वल (दीर्घ संधि); महोत्सव = महो + उत्सव (वृद्धि संधि)",
                "उज्ज्वल = उत + जल (विसर्ग संधि); महोत्सव = मह + उत्सव (यण संधि)",
                "उज्ज्वल = उच्च + ज्वल (अयादि संधि); महोत्सव = मही + उत्सव (दीर्घ संधि)"
            ),
            optsHi = listOf(
                "उज्ज्वल = उत् + ज्वल (व्यंजन संधि); महोत्सव = महा + उत्सव (गुण स्वर संधि)",
                "उज्ज्वल = उज + ज्वल (दीर्घ संधि); महोत्सव = महो + उत्सव (वृद्धि संधि)",
                "उज्ज्वल = उत + जल (विसर्ग संधि); महोत्सव = मह + उत्सव (यण संधि)",
                "उज्ज्वल = उच्च + ज्वल (अयादि संधि); महोत्सव = मही + उत्सव (दीर्घ संधि)"
            ),
            expEn = "In 'उत् + ज्वल = उज्ज्वल', 'त्' before 'ज' changes to 'ज्' (Vyanjan Sandhi; note both 'ज' are half: उज्ज्वल). In 'महा + उत्सव = महोत्सव', आ + उ = ओ (Gun Swar Sandhi).",
            expHi = "'उत् + ज्वल = उज्ज्वल' में 'त्' के बाद 'ज' आने पर 'त्' का 'ज्' हो जाता है (व्यंजन संधि; शुद्ध वर्तनी में दोनों 'ज्' आधे होते हैं)। 'महा + उत्सव = महोत्सव' में आ + उ = ओ (गुण स्वर संधि) है।",
            yearTag = "UPTET 2022 / UTET 2023 / CTET Jan 2024",
            subTopic = "हिंदी व्याकरण: संधि एवं वर्तनी"
        ),
        RawTetPyqSeed(
            qEn = "Identify the Samas (समास) in the Hindi words 'पीतांबर (एक विशेष अर्थ: श्रीकृष्ण/विष्णु)', 'यथाशक्ति', and 'चौराहा':",
            qHi = "हिंदी शब्दों 'पीतांबर (विशेष अर्थ: विष्णु/श्रीकृष्ण)', 'यथाशक्ति' और 'चौराहा' में प्रयुक्त समास का सही क्रम पहचानिए:",
            optsEn = listOf(
                "पीतांबर -> बहुव्रीहि समास; यथाशक्ति -> अव्ययीभाव समास; चौराहा -> द्विगु समास",
                "पीतांबर -> द्वंद्व समास; यथाशक्ति -> तत्पुरुष समास; चौराहा -> कर्मधारय समास",
                "पीतांबर -> अव्ययीभाव समास; यथाशक्ति -> द्विगु समास; चौराहा -> बहुव्रीहि समास",
                "तीनों में केवल तत्पुरुष समास है"
            ),
            optsHi = listOf(
                "पीतांबर (पीत हैं अंबर जिसके अर्थात् विष्णु) -> बहुव्रीहि समास; यथाशक्ति (शक्ति के अनुसार) -> अव्ययीभाव समास; चौराहा (चार राहों का समाहार) -> द्विगु समास",
                "पीतांबर -> द्वंद्व समास; यथाशक्ति -> तत्पुरुष समास; चौराहा -> कर्मधारय समास",
                "पीतांबर -> अव्ययीभाव समास; यथाशक्ति -> द्विगु समास; चौराहा -> बहुव्रीहि समास",
                "तीनों में केवल तत्पुरुष समास है"
            ),
            expEn = "Bahuvrihi Samas points to a third special meaning (पीतांबर = विष्णु); Avyayibhav Samas has an indeclinable prefix (यथा + शक्ति); Dvigu Samas has a numerical first term indicating a group (चौराहा = 4 राहों का समूह).",
            expHi = "बहुव्रीहि समास में अन्य पद प्रधान होता है (पीतांबर = विष्णु); अव्ययीभाव समास में प्रथम पद अव्यय होता है (यथाशक्ति); तथा द्विगु समास में पूर्वपद संख्यावाची विशेषण होता है (चौराहा)।",
            yearTag = "UPTET 2022 / UTET 2023 / CTET Aug 2023",
            subTopic = "हिंदी व्याकरण: समास एवं शब्द-रचना"
        ),
        RawTetPyqSeed(
            qEn = "What is the role of 'Portfolio Assessment (पोर्टफोलियो आकलन)' in a primary language classroom?",
            qHi = "प्राथमिक स्तर की भाषा कक्षा में 'पोर्टफोलियो आकलन (Portfolio Assessment)' की क्या भूमिका है?",
            optsEn = listOf(
                "It provides a systematic, longitudinal collection of a child's authentic work, drawings, drafts, and progress over time for holistic assessment",
                "It is a one-day annual board examination report card",
                "It records only the attendance and fee receipts of the student",
                "It lists only the grammatical mistakes made by the child to rank them"
            ),
            optsHi = listOf(
                "यह समय के साथ बच्चे के मौलिक कार्यों, चित्रों, लेखन प्रारूपों और क्रमिक प्रगति का व्यवस्थित संकलन प्रस्तुत करता है जिससे समग्र एवं सतत आकलन संभव होता है",
                "यह एक-दिवसीय वार्षिक बोर्ड परीक्षा का अंकपत्र है",
                "इसमें केवल छात्र की उपस्थिति और शुल्क रसीदों का रिकॉर्ड रखा जाता है",
                "इसमें बच्चों को रैंक देने के लिए केवल उनकी व्याकरणिक त्रुटियों की सूची होती है"
            ),
            expEn = "A Portfolio is a purposeful collection of a learner's work over time showing effort, growth, self-reflection, and developmental milestones across language skills.",
            expHi = "पोर्टफोलियो एक निश्चित समयावधि में शिक्षार्थी द्वारा किए गए विविध भाषाई कार्यों का सोद्देश्य संकलन है जो उसके प्रयास, क्रमिक विकास और उपलब्धियों को दर्शाता है।",
            yearTag = "CTET Jul 2024 / Jan 2024",
            subTopic = "सतत एवं व्यापक आकलन (पोर्टफोलियो)"
        ),
        RawTetPyqSeed(
            qEn = "What is meant by 'Emergent Literacy (उभरती साक्षरता / प्रारंभिक साक्षरता)' in early childhood language development?",
            qHi = "प्रारंभिक बाल्यावस्था के भाषा विकास में 'उभरती साक्षरता (Emergent Literacy)' से क्या तात्पर्य है?",
            optsEn = listOf(
                "Children's early interactions with print, scribbling, pretend reading of storybooks, and drawing before formal reading/writing instruction begins",
                "Passing a college-level literature examination",
                "Learning calligraphy after Class 8",
                "Memorizing a dictionary before entering Class 1"
            ),
            optsHi = listOf(
                "औपचारिक पठन-लेखन शिक्षण शुरू होने से पहले ही बच्चों द्वारा प्रिंट सामग्री से जुड़ाव, आड़ी-तिरछी रेखाएँ खींचना (कीरम-काँटे/Scribbling), चित्रों से कहानी का अनुमान लगाना और पुस्तक उलटना-पलटना",
                "महाविद्यालय स्तर की साहित्य परीक्षा उत्तीर्ण करना",
                "कक्षा 8 के बाद सुलेख सीखना",
                "कक्षा 1 में प्रवेश से पूर्व शब्दकोश कंठस्थ करना"
            ),
            expEn = "Emergent literacy encompasses scribbling, drawing, print awareness, and pretend reading that children naturally engage in before conventional literacy.",
            expHi = "उभरती साक्षरता (Emergent Literacy) के अंतर्गत बच्चों द्वारा औपचारिक लेखन से पूर्व कागज पर आड़ी-तिरछी लकीरें खींचना (Scribbling), चित्र बनाना और परिवेशीय प्रिंट से अर्थ जोड़ना शामिल है, जिसे लेखन प्रक्रिया का प्रथम चरण माना जाता है।",
            yearTag = "CTET Jul 2024 / Jan 2024",
            subTopic = "प्रारंभिक साक्षरता एवं लेखन प्रक्रिया"
        ),
        RawTetPyqSeed(
            qEn = "Which type of questions after reading a story or unseen passage (अपठित गद्यांश) best promote 'Critical and Divergent Thinking (समालोचनात्मक एवं अपसारी चिंतन)' among children?",
            qHi = "किसी कहानी या अपठित गद्यांश को पढ़ने के बाद किस प्रकार के प्रश्न बच्चों में 'समालोचनात्मक एवं अपसारी चिंतन (Critical & Divergent Thinking)' को सर्वाधिक प्रोत्साहित करते हैं?",
            optsEn = listOf(
                "Open-ended questions such as: 'If you were in the protagonist's place, what decision would you have taken and why?'",
                "Closed factual questions with a single one-word answer from line 2 of the passage",
                "Yes/No or True/False questions only",
                "Asking students to copy the first paragraph neatly in their notebooks"
            ),
            optsHi = listOf(
                "मुक्त-अंत (Open-ended) वाले प्रश्न, जैसे: 'यदि आप कहानी के मुख्य पात्र के स्थान पर होते, तो क्या निर्णय लेते और क्यों?'",
                "गद्यांश की दूसरी पंक्ति से एक शब्द का सीधा तथ्यात्मक प्रश्न पूछना",
                "केवल हाँ/नहीं या सत्य/असत्य वाले प्रश्न पूछना",
                "छात्रों से पहले अनुच्छेद को कॉपी में सुंदर अक्षरों में नकल करने को कहना"
            ),
            expEn = "Open-ended, imaginative, and perspective-taking questions invite multiple valid interpretations, personal connection, and critical reasoning rather than rote recall.",
            expHi = "मुक्त-अंत (Open-ended) और कल्पनाशील प्रश्न बच्चों को रटने के बजाय अपने अनुभव जोड़ने, विविध दृष्टिकोणों से सोचने और मौलिक अभिव्यक्ति करने का अवसर देते हैं।",
            yearTag = "CTET Jul 2024 / Aug 2023",
            subTopic = "गद्यांश बोध एवं अपसारी चिंतन"
        )
    )

    // =========================================================================
    // 7. LANGUAGE II: ENGLISH / SANSKRIT & PEDAGOGY (भाषा-II: अंग्रेज़ी / संस्कृत एवं पेडागोजी)
    // =========================================================================
    val englishSanskritSeeds = listOf(
        RawTetPyqSeed(
            qEn = "According to Stephen Krashen's 'Comprehensible Input Hypothesis (i + 1)' in Second Language Acquisition, how do learners acquire a second language most effectively?",
            qHi = "स्टीफन क्रैशन (Stephen Krashen) की 'बोधगम्य निवेश परिकल्पना (Comprehensible Input Hypothesis: i + 1)' के अनुसार शिक्षार्थी द्वितीय भाषा को सर्वाधिक प्रभावी ढंग से कैसे अर्जित करते हैं?",
            optsEn = listOf(
                "When they are exposed to meaningful language input ('i + 1') that is slightly beyond their current level of competence ('i') in a low-anxiety environment",
                "When they memorize 500 isolated vocabulary words every week without context",
                "When they are constantly interrupted and corrected for every minor pronunciation error",
                "When the Affective Filter (anxiety and fear) is kept at the maximum level"
            ),
            optsHi = listOf(
                "जब उन्हें भय-मुक्त वातावरण में अपने वर्तमान भाषाई स्तर ('i') से थोड़ा उच्च स्तर का अर्थपूर्ण और बोधगम्य भाषाई निवेश ('i + 1') प्राप्त होता है",
                "जब वे बिना संदर्भ के प्रति सप्ताह 500 शब्द रटते हैं",
                "जब उन्हें प्रत्येक छोटी उच्चारण त्रुटि पर तुरंत टोका और दंडित किया जाता है",
                "जब भावात्मक अवरोध (Affective Filter — चिंता व भय) अधिकतम स्तर पर रखा जाता है"
            ),
            expEn = "Krashen's Monitor Model consists of 5 hypotheses: Acquisition-Learning, Monitor, Natural Order, Input ('i+1' comprehensible input), and Affective Filter (low anxiety facilitates acquisition).",
            expHi = "क्रैशन के अनुसार जब शिक्षार्थियों को कम चिंता (Low Affective Filter) वाले माहौल में वर्तमान स्तर 'i' से थोड़ा ऊपर 'i+1' स्तर का बोधगम्य निवेश (Comprehensible Input) मिलता है, तो भाषा अर्जन सहज होता है।",
            yearTag = "CTET Jul 2024 / Jan 2024 / Aug 2023",
            subTopic = "Stephen Krashen's SLA Theory"
        ),
        RawTetPyqSeed(
            qEn = "Jim Cummins distinguished between two types of language proficiency: 'BICS' and 'CALP'. What do BICS and CALP stand for?",
            qHi = "जिम कमिंस (Jim Cummins) ने भाषा प्रवीणता के दो प्रकारों 'BICS' और 'CALP' के बीच अंतर स्पष्ट किया। BICS और CALP का पूर्ण रूप क्या है?",
            optsEn = listOf(
                "BICS: Basic Interpersonal Communicative Skills (everyday social conversation); CALP: Cognitive Academic Language Proficiency (abstract academic/textbook discourse)",
                "BICS: Bilingual Indian Curriculum System; CALP: Classroom Assessment & Lesson Plan",
                "BICS: Basic Intensive Phonics System; CALP: Communicative Audio Learning Program",
                "BICS: Beginner International Course Syllabus; CALP: Central Academic Literacy Policy"
            ),
            optsHi = listOf(
                "BICS: Basic Interpersonal Communicative Skills (दैनिक सामाजिक बातचीत की भाषा); CALP: Cognitive Academic Language Proficiency (अमूर्त शैक्षणिक एवं विषयगत भाषा प्रवीणता)",
                "BICS: Bilingual Indian Curriculum System; CALP: Classroom Assessment & Lesson Plan",
                "BICS: Basic Intensive Phonics System; CALP: Communicative Audio Learning Program",
                "BICS: Beginner International Course Syllabus; CALP: Central Academic Literacy Policy"
            ),
            expEn = "BICS refers to context-embedded everyday conversational fluency (playground/social talk), while CALP refers to context-reduced, cognitively demanding academic language needed for subjects like Science and SST.",
            expHi = "BICS दैनिक जीवन व खेल के मैदान की संदर्भ-युक्त बातचीत का कौशल है, जबकि CALP कक्षा के विषयों (विज्ञान, सामाजिक विज्ञान आदि) में प्रयुक्त होने वाली अमूर्त एवं संज्ञानात्मक शैक्षणिक भाषा प्रवीणता है।",
            yearTag = "CTET Jul 2024 / Jan 2024 / Dec 2022",
            subTopic = "BICS vs CALP (Jim Cummins)"
        ),
        RawTetPyqSeed(
            qEn = "In Reading Pedagogy, reading a text quickly to get its 'general gist or overall central idea' is called ______, whereas looking quickly through a text to locate a 'specific piece of information' (like a date or train number) is called ______.",
            qHi = "पठन शिक्षण शास्त्र में किसी पाठ का 'सामान्य सार या केंद्रीय भाव (Gist)' जानने के लिए तेजी से पढ़ना ______ कहलाता है, जबकि किसी 'विशिष्ट सूचना' (जैसे कोई तिथि या ट्रेन नंबर) को खोजने के लिए पढ़ना ______ कहलाता है।",
            optsEn = listOf(
                "Skimming (for general gist); Scanning (for specific detail/fact)",
                "Scanning (for general gist); Skimming (for specific detail)",
                "Intensive Reading; Loud Reading",
                "Bottom-up decoding; Proofreading"
            ),
            optsHi = listOf(
                "स्किमिंग / Skimming (सामान्य सार हेतु सरसरी दृष्टि डालना); स्कैनिंग / Scanning (विशिष्ट तथ्य/सूचना खोजना)",
                "स्कैनिंग (सामान्य सार हेतु); स्किमिंग (विशिष्ट तथ्य हेतु)",
                "गहन पठन (Intensive Reading); सस्वर पठन (Loud Reading)",
                "बॉबम-अप डिकोडिंग; प्रूफरीडिंग"
            ),
            expEn = "Skimming is reading rapidly to grasp the main idea/overview (e.g., glancing through newspaper headlines). Scanning is searching rapidly for a specific keyword, date, or number.",
            expHi = "Skimming (विहंगावलोकन) पाठ का मुख्य विचार या केंद्रीय सार जानने के लिए तेजी से पढ़ना है, जबकि Scanning (बारीकी से खोजना) किसी विशेष शब्द, नाम या संख्या को ढूँढने के लिए पठन करना है।",
            yearTag = "CTET Jul 2024 / Jan 2024 / UPTET 2022",
            subTopic = "Reading Sub-skills: Skimming & Scanning"
        ),
        RawTetPyqSeed(
            qEn = "What is the primary distinction between 'Top-Down Processing' and 'Bottom-Up Processing' in listening and reading comprehension?",
            qHi = "श्रवण और पठन बोध में 'टॉप-डाउन प्रक्रिया (Top-Down Processing)' और 'बॉटम-अप प्रक्रिया (Bottom-Up Processing)' के बीच मुख्य अंतर क्या है?",
            optsEn = listOf(
                "Top-Down uses the learner's prior knowledge, context, and schema to predict overall meaning; Bottom-Up decodes individual sounds/letters -> words -> phrases -> sentences",
                "Top-Down starts from individual phonemes and letters; Bottom-Up starts from background schema",
                "Top-Down is used only by teachers; Bottom-Up is used only by beginners",
                "Both mean reading from the bottom of the page to the top"
            ),
            optsHi = listOf(
                "Top-Down में शिक्षार्थी अपने पूर्व ज्ञान, संदर्भ और स्कीमा के आधार पर समग्र अर्थ का अनुमान लगाता है; Bottom-Up में ध्वनियों/अक्षरों -> शब्दों -> वाक्यांशों -> वाक्यों के क्रम में अर्थ बनाया जाता है",
                "Top-Down व्यक्तिगत ध्वनियों और अक्षरों से शुरू होता है; Bottom-Up पूर्व ज्ञान से",
                "Top-Down केवल शिक्षकों द्वारा प्रयुक्त होता है; Bottom-Up केवल बच्चों द्वारा",
                "दोनों का अर्थ पृष्ठ को नीचे से ऊपर की ओर पढ़ना है"
            ),
            expEn = "Top-down processing is schema-driven and holistic (context/background knowledge -> meaning), whereas Bottom-up processing is data-driven (phonemes/graphemes -> morphemes -> words -> clauses -> meaning).",
            expHi = "Top-Down प्रक्रिया पूर्व-ज्ञान एवं संदर्भ से समग्र अर्थ की ओर चलती है, जबकि Bottom-Up प्रक्रिया सबसे छोटी इकाइयों (ध्वनि/वर्ण -> शब्द -> वाक्य -> अर्थ) को जोड़ते हुए आगे बढ़ती है।",
            yearTag = "CTET Jan 2024 / Aug 2023",
            subTopic = "Top-Down vs Bottom-Up Approach"
        ),
        RawTetPyqSeed(
            qEn = "Which approach to language teaching emphasizes 'Communicative Competence' (Dell Hymes)—using language appropriately in real-life social contexts rather than merely mastering isolated grammatical structures?",
            qHi = "भाषा शिक्षण का कौन-सा उपागम केवल अलग-थलग व्याकरणिक संरचनाओं को रटने के बजाय वास्तविक जीवन के सामाजिक संदर्भों में भाषा के सार्थक प्रयोग अर्थात् 'संप्रेषणात्मक दक्षता (Communicative Competence - Dell Hymes)' पर बल देता है?",
            optsEn = listOf(
                "Communicative Language Teaching (CLT)",
                "Grammar-Translation Method (GTM)",
                "Audio-Lingual Drill Method",
                "Structural-Situational Drill Only"
            ),
            optsHi = listOf(
                "संप्रेषणात्मक भाषा शिक्षण (Communicative Language Teaching - CLT)",
                "व्याकरण-अनुवाद विधि (Grammar-Translation Method)",
                "श्रव्य-भाषिक ड्रिल विधि (Audio-Lingual Method)",
                "केवल संरचनात्मक रटंत अभ्यास"
            ),
            expEn = "Communicative Language Teaching (CLT) focuses on functional, authentic communication, fluency alongside accuracy, role-plays, and task-based interaction.",
            expHi = "संप्रेषणात्मक भाषा शिक्षण (CLT) वास्तविक परिस्थितियों में अर्थपूर्ण संवाद, कार्य-आधारित अंतःक्रिया और भाषा के व्यावहारिक प्रयोग पर केंद्रित है।",
            yearTag = "CTET Jul 2024 / Jan 2024 / UTET 2023",
            subTopic = "Communicative Language Teaching (CLT)"
        ),
        RawTetPyqSeed(
            qEn = "In Process Writing Pedagogy (लेखन का प्रक्रिया उपागम), what is the correct sequence of stages a learner goes through while composing a piece of writing?",
            qHi = "लेखन के 'प्रक्रिया उपागम (Process Approach to Writing)' में एक शिक्षार्थी किसी रचना को लिखते समय किन क्रमिक चरणों से गुजरता है?",
            optsEn = listOf(
                "Brainstorming (Generating Ideas) -> Outlining -> Drafting -> Revising / Reviewing -> Editing / Proofreading -> Final Publishing",
                "Final Publishing -> Editing -> Brainstorming -> Drafting",
                "Dictation -> Copying from blackboard -> Memorizing",
                "Proofreading -> Brainstorming -> Grading"
            ),
            optsHi = listOf(
                "मानस मंथन (Brainstorming) -> रूपरेखा बनाना (Outlining) -> प्रारूपण (Drafting) -> पुनरीक्षण (Revising) -> संपादन/त्रुटि सुधार (Editing) -> अंतिम प्रकाशन",
                "अंतिम प्रकाशन -> संपादन -> मानस मंथन -> प्रारूपण",
                "श्रुतलेख -> श्यामपट्ट से नकल करना -> कंठस्थ करना",
                "प्रूफरीडिंग -> मानस मंथन -> अंक देना"
            ),
            expEn = "Unlike the Product Approach (which focuses only on the final model text), the Process Approach treats writing as recursive stages: Brainstorming -> Outlining -> Rough Draft -> Peer/Self Revision -> Editing -> Final Draft.",
            expHi = "उत्पाद उपागम (Product Approach) के विपरीत प्रक्रिया उपागम (Process Approach) लेखन को एक रचनात्मक प्रक्रिया मानता है: विचार मंथन -> रूपरेखा -> प्रथम प्रारूप -> पुनरीक्षण -> संपादन -> अंतिम लेखन।",
            yearTag = "CTET Jul 2024 / Jan 2024",
            subTopic = "Process Approach to Writing"
        ),
        RawTetPyqSeed(
            qEn = "In Sanskrit & Language Pedagogy (संस्कृत शिक्षण शास्त्र), what are the four core language skills known as in correct sequential order?",
            qHi = "संस्कृत भाषा शिक्षण शास्त्र में भाषा के चार प्रमुख कौशलों (चतुर्विध-भाषाकौशलानि) का स्वाभाविक मनोवैज्ञानिक क्रम क्या है?",
            optsEn = listOf(
                "श्रवणम् (Listening) -> भाषणम्/वदनम् (Speaking) -> पठनम् (Reading) -> लेखनम् (Writing) [श्रवण-भाषण-पठन-लेखनकौशलानि]",
                "लेखनम् -> पठनम् -> भाषणम् -> श्रवणम्",
                "पठनम् -> लेखनम् -> श्रवणम् -> भाषणम्",
                "भाषणम् -> लेखनम् -> श्रवणम् -> पठनम्"
            ),
            optsHi = listOf(
                "श्रवणम् (सुनना) -> भाषणम्/वदनम् (बोलना) -> पठनम् (पढ़ना) -> लेखनम् (लिखना) [श्रवण-भाषण-पठन-लेखनकौशलानि]",
                "लेखनम् -> पठनम् -> भाषणम् -> श्रवणम्",
                "पठनम् -> लेखनम् -> श्रवणम् -> भाषणम्",
                "भाषणम् -> लेखनम् -> श्रवणम् -> पठनम्"
            ),
            expEn = "In Sanskrit pedagogy, the four skills (चतुर्विध-भाषाकौशलानि) are: श्रवणकौशलम् (Listening), भाषणकौशलम् (Speaking), पठनकौशलम् (Reading), and लेखनकौशलम् (Writing). श्रवणम् and पठनम् are ग्रहणात्मकम् (receptive); भाषणम् and लेखनम् are अभिव्यक्तात्मकम् (expressive).",
            expHi = "संस्कृत शिक्षण में चतुर्विध भाषा कौशल हैं: श्रवणम्, भाषणम्, पठनम् और लेखनम्। इनमें श्रवणम् व पठनम् 'ग्रहणात्मक कौशल' हैं तथा भाषणम् व लेखनम् 'अभिव्यक्तात्मक कौशल' हैं।",
            yearTag = "CTET / UPTET / UTET Sanskrit & Language II 2022–2024",
            subTopic = "संस्कृत एवं द्वितीय भाषा कौशल"
        ),
        RawTetPyqSeed(
            qEn = "Under the 'Three-Language Formula (त्रिभाषा सूत्र)' as reaffirmed by NEP 2020, what is recommended regarding the medium of instruction at least until Grade 5 (and preferably Grade 8)?",
            qHi = "NEP-2020 द्वारा पुनः पुष्ट 'त्रिभाषा सूत्र (Three-Language Formula)' के अंतर्गत कम से कम कक्षा 5 तक (और अधिमानतः कक्षा 8 तक) शिक्षा का माध्यम क्या रखने की अनुशंसा की गई है?",
            optsEn = listOf(
                "Home language / Mother tongue / Local or Regional language, with greater flexibility where no language is imposed on any State",
                "Exclusively foreign languages from Preschool onwards",
                "Removing all regional Indian languages from primary schools",
                "Teaching only through Latin and Greek"
            ),
            optsHi = listOf(
                "घर की भाषा / मातृभाषा / स्थानीय या क्षेत्रीय भाषा, तथा पूर्ण लचीलापन जिसमें किसी भी राज्य पर कोई भाषा थोपी नहीं जाएगी",
                "पूर्व-प्राथमिक स्तर से ही केवल विदेशी भाषा का माध्यम",
                "प्राथमिक विद्यालयों से सभी भारतीय क्षेत्रीय भाषाओं को हटाना",
                "केवल लैटिन और ग्रीक के माध्यम से शिक्षण"
            ),
            expEn = "NEP 2020 emphasizes Mother Tongue / Home Language as the medium of instruction at least till Grade 5 (preferably Grade 8) and mandates that at least two of the three languages in the Three-Language Formula be native to India.",
            expHi = "NEP 2020 कम से कम कक्षा 5 (अधिमानतः कक्षा 8) तक मातृभाषा/घर की भाषा को शिक्षण माध्यम बनाने पर बल देती है और त्रिभाषा सूत्र में तीन में से कम से कम दो भाषाएँ भारतीय भाषाएँ होने का प्रावधान करती है।",
            yearTag = "CTET Jul 2024 / Jan 2024 / UTET 2023",
            subTopic = "Three-Language Formula & NEP 2020"
        ),
        RawTetPyqSeed(
            qEn = "Identify the Figure of Speech in the poetic lines: (i) 'The camel is the ship of the desert' and (ii) 'The wind whispered secrets through the trees':",
            qHi = "काव्य पंक्तियों में प्रयुक्त अलंकार (Figure of Speech) की पहचान कीजिए: (i) 'The camel is the ship of the desert' और (ii) 'The wind whispered secrets through the trees':",
            optsEn = listOf(
                "(i) Metaphor (direct implied comparison without 'like/as'); (ii) Personification (giving human traits to non-human wind)",
                "(i) Simile; (ii) Hyperbole",
                "(i) Oxymoron; (ii) Onomatopoeia",
                "(i) Alliteration; (ii) Apostrophe"
            ),
            optsHi = listOf(
                "(i) Metaphor / रूपक अलंकार (बिना 'like/as' के सीधा आरोप); (ii) Personification / मानवीकरण अलंकार (हवा पर मानवीय क्रिया का आरोप)",
                "(i) Simile / उपमा; (ii) Hyperbole / अतिशयोक्ति",
                "(i) Oxymoron / विरोधाभास; (ii) Onomatopoeia / ध्वन्यर्थव्यंजना",
                "(i) Alliteration / अनुप्रास; (ii) Apostrophe / संबोधन"
            ),
            expEn = "'The camel is the ship of the desert' directly equates two unlike things without 'like' or 'as' (Metaphor). 'The wind whispered' attributes the human action of whispering to wind (Personification).",
            expHi = "'The camel is the ship of the desert' में बिना 'like/as' के ऊँट को रेगिस्तान का जहाज कहा गया है (Metaphor/रूपक)। 'The wind whispered' में हवा को फुसफुसाते हुए मानवीय रूप दिया गया है (Personification/मानवीकरण)।",
            yearTag = "CTET Jul 2024 / UPTET 2022 / UTET 2023",
            subTopic = "Poetry Comprehension & Figures of Speech"
        ),
        RawTetPyqSeed(
            qEn = "How are 'Learners' Errors (शिक्षार्थियों की त्रुटियाँ)' viewed in a Constructivist Language Classroom?",
            qHi = "एक रचनावादी (Constructivist) भाषा कक्षा में 'शिक्षार्थियों की त्रुटियों (Learners' Errors)' को किस रूप में देखा जाता है?",
            optsEn = listOf(
                "As natural milestones in the learning process that provide valuable diagnostic insight into how the child is thinking and constructing rules",
                "As a sign of complete failure and low intelligence of the student",
                "As wicked behavior that must be punished immediately with corporal punishment",
                "As something the teacher should completely ignore and never analyze"
            ),
            optsHi = listOf(
                "सीखने की प्रक्रिया के स्वाभाविक पड़ाव (अधिगम के संकेतक) के रूप में, जो यह समझने में मदद करते हैं कि बच्चा किस प्रकार सोच रहा है और नियमों का निर्माण कर रहा है",
                "छात्र की पूर्ण असफलता और कम बुद्धि के प्रमाण के रूप में",
                "एक अपराध के रूप में जिसके लिए तुरंत कठोर दंड दिया जाना चाहिए",
                "शिक्षक की असफलता के रूप में जिसे छिपाया जाना चाहिए"
            ),
            expEn = "Errors are windows into the learner's developing interlanguage and cognitive process; they are a natural part of learning and serve as diagnostic feedback for the teacher.",
            expHi = "रचनावादी शिक्षण शास्त्र में बच्चों की त्रुटियाँ सीखने की प्रक्रिया का स्वाभाविक हिस्सा और 'अधिगम का संकेतक' होती हैं, जो शिक्षक को बच्चे की चिंतन प्रक्रिया समझने की अंतर्दृष्टि देती हैं।",
            yearTag = "CTET Jul 2024 / Jan 2024 / Aug 2023",
            subTopic = "Role of Errors in Language Learning"
        )
    )
}
