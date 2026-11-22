package com.example.data

import com.example.model.BookChapter
import com.example.model.ContentType
import com.example.model.ExamCategory
import com.example.model.ExamSubSection
import com.example.model.ExamSubject
import com.example.model.MockTest
import com.example.model.StudyItem
import com.example.model.TestQuestion

object ExamCatalogData {

    val categories: List<ExamCategory> = listOf(
        ExamCategory(
            id = "upsc",
            name = "UPSC Civil Services & Defence",
            hindiName = "यूपीएससी सिविल सेवा एवं रक्षा",
            iconKey = "AccountBalance",
            badge = "Flagship",
            subSections = listOf(
                ExamSubSection(
                    id = "upsc_prelims",
                    name = "UPSC CSE Prelims",
                    hindiName = "यूपीएससी सीएसई प्रारंभिक परीक्षा",
                    subjects = listOf(
                        ExamSubject("upsc_pre_history", "History (Ancient, Medieval, Modern & Culture)", "इतिहास (प्राचीन, मध्यकालीन, आधुनिक एवं कला-संस्कृति)"),
                        ExamSubject("upsc_pre_polity", "Indian Polity & Governance", "भारतीय राजव्यवस्था एवं शासन"),
                        ExamSubject("upsc_pre_economy", "Indian Economy & Budget", "भारतीय अर्थव्यवस्था एवं बजट"),
                        ExamSubject("upsc_pre_geography", "Geography (India & World)", "भूगोल (भारत एवं विश्व)"),
                        ExamSubject("upsc_pre_env", "Environment, Ecology & Climate", "पर्यावरण, पारिस्थितिकी एवं जैव विविधता"),
                        ExamSubject("upsc_pre_scitech", "General Science & Tech", "सामान्य विज्ञान एवं प्रौद्योगिकी"),
                        ExamSubject("upsc_pre_ca", "Current Affairs & Annual Surveys", "समसामयिकी एवं वार्षिक आर्थिक समीक्षा"),
                        ExamSubject("upsc_pre_csat", "CSAT (Maths, Reasoning & Comprehension)", "सीसैट (गणित, तर्कशक्ति एवं बोधगम्यता)")
                    )
                ),
                ExamSubSection(
                    id = "upsc_mains",
                    name = "UPSC CSE Mains",
                    hindiName = "यूपीएससी सीएसई मुख्य परीक्षा",
                    subjects = listOf(
                        ExamSubject("upsc_main_gs1", "GS Paper 1 (Heritage, History, Geo & Society)", "जीएस पेपर 1 (विरासत, इतिहास, भूगोल, समाज)"),
                        ExamSubject("upsc_main_gs2", "GS Paper 2 (Governance, Constitution, Polity, IR)", "जीएस पेपर 2 (शासन, संविधान, राजव्यवस्था, आईआर)"),
                        ExamSubject("upsc_main_gs3", "GS Paper 3 (Tech, Eco, Bio-diversity, Security)", "जीएस पेपर 3 (प्रौद्योगिकी, अर्थव्यवस्था, सुरक्षा)"),
                        ExamSubject("upsc_main_gs4", "GS Paper 4 (Ethics, Integrity & Aptitude)", "जीएस पेपर 4 (नीतिशास्त्र, सत्यनिष्ठा एवं अभिवृत्ति)"),
                        ExamSubject("upsc_main_essay", "Essay & Analytical Writing", "निबंध एवं विश्लेषणात्मक लेखन"),
                        ExamSubject("upsc_main_optionals", "Popular Optionals (PSIR, History, Geo, Hindi Lit)", "वैकल्पिक विषय")
                    )
                ),
                ExamSubSection(
                    id = "upsc_defence",
                    name = "UPSC NDA / CDS / CAPF",
                    hindiName = "एनडीए / सीडीएस / सीएपीएफ",
                    subjects = listOf(
                        ExamSubject("upsc_def_nda", "NDA (Maths + General Ability Test)", "एनडीए (गणित + सामान्य योग्यता)"),
                        ExamSubject("upsc_def_cds", "CDS (Elementary Maths, English, GK)", "सीडीएस (गणित, अंग्रेजी, सामान्य ज्ञान)"),
                        ExamSubject("upsc_def_capf", "CAPF AC (Paper 1 & Paper 2 Essay/Comprehension)", "सीएपीएफ सहायक कमांडेंट")
                    )
                )
            )
        ),
        ExamCategory(
            id = "state_psc",
            name = "State PSCs (UPPCS, UKPSC, BPSC, RPSC)",
            hindiName = "राज्य लोक सेवा आयोग (UP, UK, Bihar, Raj, MP)",
            iconKey = "Gavel",
            badge = "Popular",
            subSections = listOf(
                ExamSubSection(
                    id = "psc_uppcs",
                    name = "UPPCS (Uttar Pradesh PSC)",
                    hindiName = "यूपीपीसीएस (उत्तर प्रदेश)",
                    subjects = listOf(
                        ExamSubject("uppcs_pre_gs", "Prelims GS Paper 1 & CSAT 2", "प्रारंभिक जीएस पेपर 1 एवं 2"),
                        ExamSubject("uppcs_up_gk", "UP Special GK & Budget (Paper 5 & 6)", "उत्तर प्रदेश विशेष सामान्य ज्ञान एवं बजट"),
                        ExamSubject("uppcs_mains", "UPPCS Mains Complete Series", "यूपीपीसीएस मुख्य परीक्षा संपूर्ण श्रृंखला")
                    )
                ),
                ExamSubSection(
                    id = "psc_ukpsc",
                    name = "UKPSC (Uttarakhand PSC)",
                    hindiName = "यूकेपीएससी (उत्तराखंड पीसीएस)",
                    subjects = listOf(
                        ExamSubject("ukpsc_special_100", "★ Uttarakhand Special (Top 100 Last 5 Yrs PYQs)", "★ उत्तराखंड विशेष (टॉप 100 विगत 5 वर्षीय PYQs)"),
                        ExamSubject("ukpsc_history", "History of India & National Movement (50 PYQs)", "भारतीय इतिहास एवं राष्ट्रीय आंदोलन (50 PYQs)"),
                        ExamSubject("ukpsc_polity", "Indian Polity & Governance (50 PYQs)", "भारतीय राजव्यवस्था एवं शासन (50 PYQs)"),
                        ExamSubject("ukpsc_geography", "Indian & World Geography (50 PYQs)", "भारत एवं विश्व का भूगोल (50 PYQs)"),
                        ExamSubject("ukpsc_economics", "Indian Economy & Social Dev (50 PYQs)", "भारतीय अर्थव्यवस्था एवं सामाजिक विकास (50 PYQs)"),
                        ExamSubject("ukpsc_environment", "Environment, Ecology & Biodiversity (50 PYQs)", "पर्यावरण, पारिस्थितिकी एवं जैव-विविधता (50 PYQs)"),
                        ExamSubject("ukpsc_scitech", "General Science, Tech & Computer IT (50 PYQs)", "सामान्य विज्ञान, प्रौद्योगिकी एवं कंप्यूटर (50 PYQs)"),
                        ExamSubject("ukpsc_current_affairs", "Uttarakhand & National Current Affairs (50 PYQs)", "उत्तराखंड एवं राष्ट्रीय समसामयिकी (50 PYQs)")
                    )
                ),
                ExamSubSection(
                    id = "psc_bpsc",
                    name = "BPSC (Bihar PSC)",
                    hindiName = "बीपीएससी (बिहार पीसीएस)",
                    subjects = listOf(
                        ExamSubject("bpsc_bihar_special", "★ Bihar Special (100 Last 5 Yrs PYQs)", "★ बिहार विशेष (टॉप 100 विगत 5 वर्षीय PYQs)"),
                        ExamSubject("bpsc_history", "History of India & National Movement (100 PYQs)", "भारतीय इतिहास एवं राष्ट्रीय आंदोलन (100 PYQs)"),
                        ExamSubject("bpsc_polity", "Indian Polity & Constitution (100 PYQs)", "भारतीय राजव्यवस्था एवं संविधान (100 PYQs)"),
                        ExamSubject("bpsc_geography", "Indian, World & Bihar Geography (100 PYQs)", "भारत, विश्व एवं बिहार का भूगोल (100 PYQs)"),
                        ExamSubject("bpsc_economics", "Indian Economy & Bihar Budget/Survey (100 PYQs)", "भारतीय अर्थव्यवस्था एवं बिहार बजट (100 PYQs)"),
                        ExamSubject("bpsc_science", "General Science — Physics, Chem, Bio (100 PYQs)", "सामान्य विज्ञान — भौतिकी, रसायन, जीव विज्ञान (100 PYQs)"),
                        ExamSubject("bpsc_current_affairs", "Bihar, National & Int'l Current Affairs (100 PYQs)", "बिहार, राष्ट्रीय एवं अंतर्राष्ट्रीय समसामयिकी (100 PYQs)")
                    )
                ),
                ExamSubSection(
                    id = "psc_rpsc",
                    name = "RPSC (Rajasthan RAS)",
                    hindiName = "आरपीएससी (राजस्थान आरएएस)",
                    subjects = listOf(
                        ExamSubject("rpsc_ras_pre", "RAS Prelims GS & General Science", "आरएएस प्री जीएस एवं सामान्य विज्ञान"),
                        ExamSubject("rpsc_raj_gk", "Rajasthan Art, Culture, History & Geography", "राजस्थान कला, संस्कृति, इतिहास एवं भूगोल")
                    )
                ),
                ExamSubSection(
                    id = "psc_others",
                    name = "MPPSC / JPSC / CGPSC / MPSC",
                    hindiName = "एमपीपीएससी / जेपीएससी / सीजीपीएससी",
                    subjects = listOf(
                        ExamSubject("mppsc_gs", "MPPSC Prelims GS & MP Special GK", "एमपीपीएससी प्री जीएस एवं एमपी विशेष"),
                        ExamSubject("jpsc_gs", "JPSC Prelims & Jharkhand Special GK", "जेपीएससी प्री एवं झारखंड विशेष"),
                        ExamSubject("cgpsc_gs", "CGPSC Prelims & Chhattisgarh GK", "सीजीपीएससी प्री एवं छत्तीसगढ़ विशेष")
                    )
                )
            )
        ),
        ExamCategory(
            id = "subordinate_selection",
            name = "State Subordinate (UPSSSC, UKSSSC)",
            hindiName = "राज्य अधीनस्थ सेवा चयन (UPSSSC, UKSSSC)",
            iconKey = "Assignment",
            badge = "High Demand",
            subSections = listOf(
                ExamSubSection(
                    id = "sub_upsssc",
                    name = "UPSSSC (PET, VDO, Lekhpal)",
                    hindiName = "UPSSSC (PET, VDO, लेखपाल)",
                    subjects = listOf(
                        ExamSubject("upsssc_history", "History & National Movement (100 Qs)", "इतिहास एवं राष्ट्रीय आंदोलन (100 Qs)"),
                        ExamSubject("upsssc_polity", "Indian Polity & Constitution (100 Qs)", "भारतीय संविधान एवं राजव्यवस्था (100 Qs)"),
                        ExamSubject("upsssc_geography", "Indian & World Geography (100 Qs)", "भारत एवं विश्व का भूगोल (100 Qs)"),
                        ExamSubject("upsssc_economics", "Indian Economy & Schemes (100 Qs)", "भारतीय अर्थव्यवस्था एवं योजनाएँ (100 Qs)"),
                        ExamSubject("upsssc_environment", "Environment & Ecology (100 Qs)", "पर्यावरण एवं पारिस्थितिकी (100 Qs)"),
                        ExamSubject("upsssc_scitech", "General Science & Tech (100 Qs)", "सामान्य विज्ञान एवं प्रौद्योगिकी (100 Qs)"),
                        ExamSubject("upsssc_up_special_250", "★ UP Special (Best 250 PYQs)", "★ यूपी स्पेशल (सर्वश्रेष्ठ 250 प्रश्न)"),
                        ExamSubject("upsssc_computer", "Computer & IT (100 Qs)", "कंप्यूटर एवं सूचना प्रौद्योगिकी (100 Qs)"),
                        ExamSubject("upsssc_di", "Data Interpretation / DI (100 Qs)", "डेटा इंटरप्रिटेशन — ग्राफ एवं तालिका (100 Qs)")
                    )
                ),
                ExamSubSection(
                    id = "sub_uksssc",
                    name = "UKSSSC (Uttarakhand Group C & D)",
                    hindiName = "UKSSSC (उत्तराखंड समूह 'ग' एवं 'घ')",
                    subjects = listOf(
                        ExamSubject("uksssc_history", "History & National Movement (100 Qs)", "इतिहास एवं राष्ट्रीय आंदोलन (100 Qs)"),
                        ExamSubject("uksssc_polity", "Indian Polity & Constitution (100 Qs)", "भारतीय राजव्यवस्था एवं संविधान (100 Qs)"),
                        ExamSubject("uksssc_geography", "Indian & World Geography (100 Qs)", "भारत एवं विश्व का भूगोल (100 Qs)"),
                        ExamSubject("uksssc_economics", "Indian Economy & Schemes (100 Qs)", "भारतीय अर्थव्यवस्था एवं योजनाएँ (100 Qs)"),
                        ExamSubject("uksssc_environment", "Environment, Forest & Ecology (100 Qs)", "पर्यावरण, वन एवं आपदा प्रबंधन (100 Qs)"),
                        ExamSubject("uksssc_scitech", "General Science & Tech (100 Qs)", "सामान्य विज्ञान एवं प्रौद्योगिकी (100 Qs)"),
                        ExamSubject("uksssc_uk_special_250", "★ Uttarakhand Special (Best 250 PYQs)", "★ उत्तराखंड स्पेशल (सर्वश्रेष्ठ 250 प्रश्न)"),
                        ExamSubject("uksssc_hindi", "General Hindi & Literature (100 Qs)", "सामान्य हिंदी व्याकरण एवं साहित्य (100 Qs)"),
                        ExamSubject("uksssc_computer", "Computer & IT (100 Qs)", "कंप्यूटर एवं सूचना प्रौद्योगिकी (100 Qs)"),
                        ExamSubject("uksssc_reasoning_di", "Reasoning & Data Interpretation (100 Qs)", "तर्कशक्ति एवं डेटा इंटरप्रिटेशन (100 Qs)")
                    )
                ),
                ExamSubSection(
                    id = "sub_others",
                    name = "RSSB (Rajasthan) / BSSC (Bihar)",
                    hindiName = "आरएसएसबी (राजस्थान) / बीएसएससी (बिहार)",
                    subjects = listOf(
                        ExamSubject("rssb_cet", "Rajasthan CET (10+2 & Graduation) & Patwari", "राजस्थान सीईटी एवं पटवारी"),
                        ExamSubject("bssc_inter", "BSSC Inter Level & CGL Graduate Exam", "बीएसएससी इंटर स्तरीय एवं स्नातक")
                    )
                )
            )
        ),
        ExamCategory(
            id = "ssc",
            name = "SSC CGL / CHSL / CPO",
            hindiName = "SSC CGL / CHSL / CPO (एसएससी सीजीएल / सीएचएसएल / सीपीओ)",
            iconKey = "Badge",
            badge = "Hot",
            subSections = listOf(
                ExamSubSection(
                    id = "ssc_cgl",
                    name = "SSC CGL / CHSL / CPO (Tier-I & II)",
                    hindiName = "SSC CGL / CHSL / CPO (टियर-I एवं II — 800 PYQs)",
                    subjects = listOf(
                        ExamSubject("ssc_gs_history", "GS: History & Culture (100 PYQs)", "जीएस: इतिहास एवं संस्कृति (100 प्रश्न)"),
                        ExamSubject("ssc_gs_polity", "GS: Polity & Constitution (100 PYQs)", "जीएस: राजव्यवस्था एवं संविधान (100 प्रश्न)"),
                        ExamSubject("ssc_gs_geography", "GS: Geography (100 PYQs)", "जीएस: भारत एवं विश्व का भूगोल (100 प्रश्न)"),
                        ExamSubject("ssc_gs_environment", "GS: Environment & Ecology (100 PYQs)", "जीएस: पर्यावरण एवं पारिस्थितिकी (100 प्रश्न)"),
                        ExamSubject("ssc_gs_economics", "GS: Economics & 5-Yr Plans (100 PYQs)", "जीएस: अर्थव्यवस्था एवं पंचवर्षीय योजनाएं (100 प्रश्न)"),
                        ExamSubject("ssc_reasoning", "General Intelligence & Reasoning (100 PYQs)", "रीजनिंग / तर्कशक्ति (100 प्रश्न)"),
                        ExamSubject("ssc_mathematics", "Mathematics / Quant Aptitude (100 PYQs)", "मैथमेटिक्स / गणित (100 प्रश्न)"),
                        ExamSubject("ssc_english", "English Language & Comprehension (100 PYQs)", "इंग्लिश / अंग्रेज़ी भाषा एवं व्याकरण (100 प्रश्न)")
                    )
                ),
                ExamSubSection(
                    id = "ssc_chsl_mts",
                    name = "SSC CHSL & MTS & GD Constable",
                    hindiName = "एसएससी सीएचएसएल, एमटीएस एवं जीडी कांस्टेबल",
                    subjects = listOf(
                        ExamSubject("ssc_chsl_complete", "SSC CHSL Tier 1 & 2 Complete Guide", "एसएससी सीएचएसएल संपूर्ण गाइड"),
                        ExamSubject("ssc_mts_guide", "SSC MTS & Havaldar All-in-One", "एसएससी एमटीएस एवं हवलदार"),
                        ExamSubject("ssc_gd_constable", "SSC GD Constable (Math, Reasoning, Hindi/Eng, GK)", "एसएससी जीडी कांस्टेबल")
                    )
                ),
                ExamSubSection(
                    id = "ssc_cpo_steno",
                    name = "SSC CPO SI & Stenographer",
                    hindiName = "एसएससी सीपीओ एसआई एवं स्टेनोग्राफर",
                    subjects = listOf(
                        ExamSubject("ssc_cpo_si", "Delhi Police & CAPF Sub-Inspector (Paper 1 & 2)", "दिल्ली पुलिस एवं सीएपीएफ एसआई"),
                        ExamSubject("ssc_steno", "SSC Stenographer Grade C & D", "एसएससी स्टेनोग्राफर ग्रेड सी एवं डी")
                    )
                )
            )
        ),
        ExamCategory(
            id = "railway",
            name = "Railways (RRB NTPC, Group D, ALP)",
            hindiName = "रेलवे भर्ती बोर्ड (आरआरबी)",
            iconKey = "Train",
            subSections = listOf(
                ExamSubSection(
                    id = "rrb_ntpc",
                    name = "RRB NTPC (Non-Technical Popular Categories)",
                    hindiName = "आरआरबी एनटीपीसी (सीबीटी 1 व 2)",
                    subjects = listOf(
                        ExamSubject("rrb_ntpc_math", "Railway Mathematics (Arithmetic & Advance)", "रेलवे अंकगणित एवं एडवांस"),
                        ExamSubject("rrb_ntpc_reasoning", "Railway General Intelligence & Reasoning", "रेलवे तर्कशक्ति"),
                        ExamSubject("rrb_ntpc_ga", "Railway General Awareness & Science", "रेलवे सामान्य अध्ययन एवं विज्ञान")
                    )
                ),
                ExamSubSection(
                    id = "rrb_group_d_alp",
                    name = "RRB Group D, ALP & RPF",
                    hindiName = "आरआरबी ग्रुप डी, एएलपी एवं आरपीएफ",
                    subjects = listOf(
                        ExamSubject("rrb_group_d", "RRB Group D General Science & Math Kit", "आरआरबी ग्रुप डी सामान्य विज्ञान व गणित"),
                        ExamSubject("rrb_alp", "RRB Assistant Loco Pilot (ALP) CBT 1 & 2", "असिस्टेंट लोको पायलट (ALP)"),
                        ExamSubject("rrb_rpf", "RPF Sub-Inspector & Constable Exam", "आरपीएफ सब-इंस्पेक्टर एवं कांस्टेबल")
                    )
                )
            )
        ),
        ExamCategory(
            id = "banking",
            name = "Banking & Insurance (IBPS, SBI, RBI)",
            hindiName = "बैंकिंग एवं बीमा परीक्षाएं (SBI, IBPS, RBI)",
            iconKey = "Payments",
            subSections = listOf(
                ExamSubSection(
                    id = "bank_po_clerk",
                    name = "SBI & IBPS PO / Clerk",
                    hindiName = "एसबीआई एवं आईबीपीएस पीओ / क्लर्क",
                    subjects = listOf(
                        ExamSubject("bank_quant", "Data Interpretation & Quantitative Aptitude", "डेटा इंटरप्रिटेशन एवं क्वांट"),
                        ExamSubject("bank_reasoning", "Puzzles & High-Level Reasoning", "पहेलियाँ एवं उच्च स्तरीय रीजनिंग"),
                        ExamSubject("bank_english", "Banking English Language & Vocab", "बैंकिंग इंग्लिश एवं वोकैब"),
                        ExamSubject("bank_awareness", "Banking Awareness, Financial GK & Current Affairs", "बैंकिंग जागरूकता एवं वित्तीय जीके")
                    )
                ),
                ExamSubSection(
                    id = "bank_rbi_lic",
                    name = "RBI Grade B & Assistant & LIC AAO",
                    hindiName = "आरबीआई ग्रेड बी एवं एलआईसी एएओ",
                    subjects = listOf(
                        ExamSubject("rbi_grade_b", "RBI Grade B (ESI & Finance & Management)", "आरबीआई ग्रेड बी (ईएसआई एवं वित्त प्रबंधन)"),
                        ExamSubject("lic_aao", "LIC AAO / ADO Insurance & Financial Market Awareness", "एलआईसी एएओ वित्तीय बाजार जागरूकता")
                    )
                )
            )
        ),
        ExamCategory(
            id = "jee_neet",
            name = "IIT JEE (Main & Advanced) & NEET",
            hindiName = "IIT JEE (मेन एवं एडवांस्ड) एवं नीट",
            iconKey = "Biotech",
            badge = "IIT JEE",
            subSections = listOf(
                ExamSubSection(
                    id = "iit_jee",
                    name = "1. IIT JEE Main (5 Subjects × 100 PYQs)",
                    hindiName = "1. आईआईटी जेईई मेन (5 विषय × 100 प्रश्न)",
                    subjects = listOf(
                        ExamSubject("jee_main_physics", "JEE Main Section 1: Physics (100 Last 5-Yr PYQs)", "JEE Main खंड 1: भौतिक विज्ञान (100 प्रश्न)"),
                        ExamSubject("jee_main_physical_chem", "JEE Main Section 2: Physical Chemistry (100 Last 5-Yr PYQs)", "JEE Main खंड 2: भौतिक रसायन (100 प्रश्न)"),
                        ExamSubject("jee_main_organic_chem", "JEE Main Section 3: Organic Chemistry (100 Last 5-Yr PYQs)", "JEE Main खंड 3: कार्बनिक रसायन (100 प्रश्न)"),
                        ExamSubject("jee_main_inorganic_chem", "JEE Main Section 4: Inorganic Chemistry (100 Last 5-Yr PYQs)", "JEE Main खंड 4: अकार्बनिक रसायन (100 प्रश्न)"),
                        ExamSubject("jee_main_mathematics", "JEE Main Section 5: Mathematics (100 Last 5-Yr PYQs)", "JEE Main खंड 5: गणित (100 प्रश्न)")
                    )
                ),
                ExamSubSection(
                    id = "iit_jee_advanced",
                    name = "2. IIT JEE Advanced (5 Subjects × 100 PYQs)",
                    hindiName = "2. आईआईटी जेईई एडवांस्ड (5 विषय × 100 प्रश्न)",
                    subjects = listOf(
                        ExamSubject("jee_adv_physics", "JEE Advanced Section 1: Physics (100 Last 5-Yr PYQs)", "JEE Advanced खंड 1: भौतिक विज्ञान (100 प्रश्न)"),
                        ExamSubject("jee_adv_physical_chem", "JEE Advanced Section 2: Physical Chemistry (100 Last 5-Yr PYQs)", "JEE Advanced खंड 2: भौतिक रसायन (100 प्रश्न)"),
                        ExamSubject("jee_adv_organic_chem", "JEE Advanced Section 3: Organic Chemistry (100 Last 5-Yr PYQs)", "JEE Advanced खंड 3: कार्बनिक रसायन (100 प्रश्न)"),
                        ExamSubject("jee_adv_inorganic_chem", "JEE Advanced Section 4: Inorganic Chemistry (100 Last 5-Yr PYQs)", "JEE Advanced खंड 4: अकार्बनिक रसायन (100 प्रश्न)"),
                        ExamSubject("jee_adv_mathematics", "JEE Advanced Section 5: Mathematics (100 Last 5-Yr PYQs)", "JEE Advanced खंड 5: गणित (100 प्रश्न)")
                    )
                ),
                ExamSubSection(
                    id = "neet_ug",
                    name = "3. NEET UG (6 Subjects × 100 PYQs)",
                    hindiName = "3. नीट यूजी मेडिकल (6 विषय × 100 प्रश्न)",
                    subjects = listOf(
                        ExamSubject("neet_physics", "NEET Section 1: Physics (100 Last 5-Yr PYQs)", "NEET खंड 1: भौतिक विज्ञान (100 प्रश्न)"),
                        ExamSubject("neet_physical_chem", "NEET Section 2: Physical Chemistry (100 Last 5-Yr PYQs)", "NEET खंड 2: भौतिक रसायन (100 प्रश्न)"),
                        ExamSubject("neet_organic_chem", "NEET Section 3: Organic Chemistry (100 Last 5-Yr PYQs)", "NEET खंड 3: कार्बनिक रसायन (100 प्रश्न)"),
                        ExamSubject("neet_inorganic_chem", "NEET Section 4: Inorganic Chemistry (100 Last 5-Yr PYQs)", "NEET खंड 4: अकार्बनिक रसायन (100 प्रश्न)"),
                        ExamSubject("neet_botany", "NEET Section 5: Biology — Botany (100 Last 5-Yr PYQs)", "NEET खंड 5: जीव विज्ञान — वनस्पति विज्ञान (100 प्रश्न)"),
                        ExamSubject("neet_zoology", "NEET Section 6: Biology — Zoology (100 Last 5-Yr PYQs)", "NEET खंड 6: जीव विज्ञान — जन्तु विज्ञान (100 प्रश्न)")
                    )
                )
            )
        ),
        ExamCategory(
            id = "cbse_school",
            name = "CBSE & State Boards (9th to 12th)",
            hindiName = "सीबीएसई एवं स्टेट बोर्ड (कक्षा 9वीं से 12वीं)",
            iconKey = "School",
            subSections = listOf(
                ExamSubSection(
                    id = "cbse_10th_9th",
                    name = "Class 9th & 10th Board Foundation",
                    hindiName = "कक्षा 9वीं एवं 10वीं बोर्ड फाउंडेशन",
                    subjects = listOf(
                        ExamSubject("cbse_10_science", "Class 10th Science NCERT + Exemplar Master", "कक्षा 10वीं विज्ञान संपूर्ण हल"),
                        ExamSubject("cbse_10_maths", "Class 10th Mathematics Formula & Solved Papers", "कक्षा 10वीं गणित फॉर्मूला व हल प्रश्न"),
                        ExamSubject("cbse_10_sst", "Class 10th Social Science (History, Pol, Geo, Eco)", "कक्षा 10वीं सामाजिक विज्ञान")
                    )
                ),
                ExamSubSection(
                    id = "cbse_11th_12th",
                    name = "Class 11th & 12th Boards",
                    hindiName = "कक्षा 11वीं एवं 12वीं बोर्ड परीक्षा",
                    subjects = listOf(
                        ExamSubject("cbse_12_pcm", "Class 12th Physics, Chemistry, Maths Revision Notes", "कक्षा 12वीं पीसीएम क्विक रिवीजन"),
                        ExamSubject("cbse_12_bio", "Class 12th Biology Diagram & Theory Master", "कक्षा 12वीं जीव विज्ञान"),
                        ExamSubject("cbse_12_arts", "Class 12th Humanities (History, Pol Science, Geography)", "कक्षा 12वीं कला संकाय")
                    )
                )
            )
        ),
        ExamCategory(
            id = "teaching",
            name = "Teaching Eligibility Test (CTET, UPTET, UTET & Others)",
            hindiName = "शिक्षक पात्रता परीक्षा (सीटेट • यूपीटेट • यूटेट व अन्य)",
            iconKey = "Psychology",
            subSections = listOf(
                ExamSubSection(
                    id = "tet_central_state",
                    name = "CTET, UPTET, UTET & Other State TETs (7 Subjects × 100 PYQs)",
                    hindiName = "सीटेट (CTET) • यूपीटेट (UPTET) • यूटेट व अन्य (100-100 प्रश्न)",
                    subjects = listOf(
                        ExamSubject("tet_cdp", "1. CDP — Child Development & Pedagogy (100 PYQs)", "1. सीडीपी — बाल विकास एवं शिक्षाशास्त्र (100 प्रश्न)"),
                        ExamSubject("tet_evs", "2. EVS — Environmental Studies & Pedagogy (100 PYQs)", "2. ईवीएस — पर्यावरण अध्ययन एवं पेडागोजी (100 प्रश्न)"),
                        ExamSubject("tet_maths", "3. Mathematics & Pedagogy (100 PYQs)", "3. मैथ्स — गणित एवं शिक्षण शास्त्र (100 प्रश्न)"),
                        ExamSubject("tet_science", "4. Science & Pedagogy — Paper 2 (100 PYQs)", "4. साइंस — विज्ञान एवं शिक्षण शास्त्र (100 प्रश्न)"),
                        ExamSubject("tet_social_science", "5. Social Science (SST) & Pedagogy — Paper 2 (100 PYQs)", "5. सोशल साइंस — सामाजिक अध्ययन एवं पेडागोजी (100 प्रश्न)"),
                        ExamSubject("tet_hindi", "6. Language I: Hindi & Pedagogy (100 PYQs)", "6. भाषा-I: हिंदी भाषा एवं शिक्षण शास्त्र (100 प्रश्न)"),
                        ExamSubject("tet_english_sanskrit", "7. Language II: English / Sanskrit & Pedagogy (100 PYQs)", "7. भाषा-II: अंग्रेज़ी / संस्कृत एवं पेडागोजी (100 प्रश्न)")
                    )
                ),
                ExamSubSection(
                    id = "teaching_kvs_dsssb",
                    name = "Super TET, KVS, NVS & DSSSB",
                    hindiName = "सुपर टीईटी, केवीएस, एनवीएस, डीएसएसएसबी",
                    subjects = listOf(
                        ExamSubject("super_tet_complete", "UP Super TET 14 Subjects Master Guide", "यूपी सुपर टीईटी 14 विषय मास्टर गाइड"),
                        ExamSubject("kvs_prt_tgt", "KVS / NVS PRT & TGT General Paper & Pedagogy", "केवीएस / एनवीएस पीआरटी एवं टीजीटी")
                    )
                )
            )
        ),
        ExamCategory(
            id = "computer_cert",
            name = "Computer Certifications (CCC, O Level)",
            hindiName = "कंप्यूटर प्रमाणन (CCC, O Level, DCA)",
            iconKey = "LaptopMac",
            badge = "Skill",
            subSections = listOf(
                ExamSubSection(
                    id = "nielit_cert",
                    name = "NIELIT CCC & O Level",
                    hindiName = "नाइलिट सीसीसी एवं ओ लेवल",
                    subjects = listOf(
                        ExamSubject("ccc_master", "CCC (Course on Computer Concepts) Full Syllabus & 2000 MCQs", "सीसीसी संपूर्ण पाठ्यक्रम एवं 2000 एमसीक्यू"),
                        ExamSubject("o_level_m1", "O Level M1-R5 Information Technology Tools", "ओ लेवल M1-R5 सूचना प्रौद्योगिकी टूल्स"),
                        ExamSubject("o_level_m2", "O Level M2-R5 Web Designing & Publishing (HTML/CSS/JS)", "ओ लेवल M2-R5 वेब डिजाइनिंग"),
                        ExamSubject("o_level_m3", "O Level M3-R5 Programming with Python", "ओ लेवल M3-R5 पायथन प्रोग्रामिंग"),
                        ExamSubject("o_level_m4", "O Level M4-R5 Internet of Things (IoT)", "ओ लेवल M4-R5 इंटरनेट ऑफ थिंग्स")
                    )
                )
            )
        ),
        ExamCategory(
            id = "ai_ml",
            name = "AI & Machine Learning (Modern Tech)",
            hindiName = "एआई एवं मशीन लर्निंग (आधुनिक तकनीक)",
            iconKey = "SmartToy",
            badge = "Trending",
            subSections = listOf(
                ExamSubSection(
                    id = "ai_foundations",
                    name = "Artificial Intelligence & Data Science",
                    hindiName = "कृत्रिम बुद्धिमत्ता एवं डेटा साइंस",
                    subjects = listOf(
                        ExamSubject("ai_handbook", "Artificial Intelligence & Machine Learning Handbook", "एआई एवं मशीन लर्निंग हैंडबुक"),
                        ExamSubject("python_data_sci", "Python for Data Science, Pandas & Scikit-Learn", "डेटा साइंस हेतु पायथन प्रोग्रामिंग"),
                        ExamSubject("deep_learning_nlp", "Deep Learning, Neural Networks & Generative AI", "डीप लर्निंग एवं जेनरेटिव एआई")
                    )
                )
            )
        ),
        ExamCategory(
            id = "ugc_csir_net",
            name = "UGC NET (Paper 1 & Paper 2) & CSIR NET",
            hindiName = "यूजीसी नेट (पेपर 1 एवं पेपर 2) व सीएसआईआर नेट",
            iconKey = "WorkspacePremium",
            subSections = listOf(
                ExamSubSection(
                    id = "ugc_net_paper1",
                    name = "1. UGC NET Paper 1 (All 10 Units × 100 PYQ MCQs)",
                    hindiName = "1. यूजीसी नेट पेपर 1 (सभी 10 यूनिट्स × 100 प्रश्न)",
                    subjects = listOf(
                        ExamSubject("ugc_p1_unit1_teaching", "Unit I: Teaching Aptitude (100 PYQs)", "इकाई I: शिक्षण अभिक्षमता (100 प्रश्न)"),
                        ExamSubject("ugc_p1_unit2_research", "Unit II: Research Aptitude (100 PYQs)", "इकाई II: शोध अभिक्षमता (100 प्रश्न)"),
                        ExamSubject("ugc_p1_unit3_comprehension", "Unit III: Reading Comprehension (100 PYQs)", "इकाई III: बोधगम्यता / गद्यांश (100 प्रश्न)"),
                        ExamSubject("ugc_p1_unit4_communication", "Unit IV: Communication (100 PYQs)", "इकाई IV: संप्रेषण (100 प्रश्न)"),
                        ExamSubject("ugc_p1_unit5_math_reasoning", "Unit V: Mathematical Reasoning & Aptitude (100 PYQs)", "इकाई V: गणितीय तर्क और अभिक्षमता (100 प्रश्न)"),
                        ExamSubject("ugc_p1_unit6_logical_reasoning", "Unit VI: Logical Reasoning & Indian Logic (100 PYQs)", "इकाई VI: युक्तियुक्त तर्क एवं भारतीय तर्कशास्त्र (100 प्रश्न)"),
                        ExamSubject("ugc_p1_unit7_di", "Unit VII: Data Interpretation — DI (100 PYQs)", "इकाई VII: आंकड़ों की व्याख्या — DI (100 प्रश्न)"),
                        ExamSubject("ugc_p1_unit8_ict", "Unit VIII: Information & Communication Tech — ICT (100 PYQs)", "इकाई VIII: सूचना और संचार प्रौद्योगिकी — ICT (100 प्रश्न)"),
                        ExamSubject("ugc_p1_unit9_environment", "Unit IX: People, Development & Environment (100 PYQs)", "इकाई IX: लोक, विकास और पर्यावरण (100 प्रश्न)"),
                        ExamSubject("ugc_p1_unit10_higher_ed", "Unit X: Higher Education System (100 PYQs)", "इकाई X: उच्च शिक्षा प्रणाली (100 प्रश्न)")
                    )
                ),
                ExamSubSection(
                    id = "ugc_net_paper2",
                    name = "2. UGC NET Paper 2 (All 12 Subjects × 100 PYQ MCQs)",
                    hindiName = "2. यूजीसी नेट पेपर 2 (सभी 12 विषय × 100 प्रश्न)",
                    subjects = listOf(
                        ExamSubject("ugc_p2_history", "1. History (Code 006) — 100 PYQs", "1. इतिहास (कोड 006) — 100 प्रश्न"),
                        ExamSubject("ugc_p2_pol_science", "2. Political Science (Code 002) — 100 PYQs", "2. राजनीति विज्ञान (कोड 002) — 100 प्रश्न"),
                        ExamSubject("ugc_p2_geography", "3. Geography (Code 080) — 100 PYQs", "3. भूगोल (कोड 080) — 100 प्रश्न"),
                        ExamSubject("ugc_p2_economics", "4. Economics (Code 001) — 100 PYQs", "4. अर्थशास्त्र (कोड 001) — 100 प्रश्न"),
                        ExamSubject("ugc_p2_hindi", "5. Hindi Literature (Code 020) — 100 PYQs", "5. हिंदी साहित्य (कोड 020) — 100 प्रश्न"),
                        ExamSubject("ugc_p2_english", "6. English Literature (Code 030) — 100 PYQs", "6. अंग्रेज़ी साहित्य (कोड 030) — 100 प्रश्न"),
                        ExamSubject("ugc_p2_commerce", "7. Commerce (Code 008) — 100 PYQs", "7. वाणिज्य (कोड 008) — 100 प्रश्न"),
                        ExamSubject("ugc_p2_management", "8. Management (Code 017) — 100 PYQs", "8. प्रबंधन (कोड 017) — 100 प्रश्न"),
                        ExamSubject("ugc_p2_sociology", "9. Sociology (Code 005) — 100 PYQs", "9. समाजशास्त्र (कोड 005) — 100 प्रश्न"),
                        ExamSubject("ugc_p2_education", "10. Education (Code 009) — 100 PYQs", "10. शिक्षाशास्त्र (कोड 009) — 100 प्रश्न"),
                        ExamSubject("ugc_p2_computer_sci", "11. Computer Science & Applications (Code 087) — 100 PYQs", "11. कंप्यूटर विज्ञान और अनुप्रयोग (कोड 087) — 100 प्रश्न"),
                        ExamSubject("ugc_p2_law", "12. Law (Code 058) — 100 PYQs", "12. विधि / Law (कोड 058) — 100 प्रश्न")
                    )
                ),
                ExamSubSection(
                    id = "csir_net",
                    name = "CSIR NET (Life / Chemical / Physical Sciences)",
                    hindiName = "सीएसआईआर नेट (विज्ञान संकाय)",
                    subjects = listOf(
                        ExamSubject("csir_life_sci", "CSIR NET Life Sciences Master Theory & PYQs", "सीएसआईआर नेट लाइफ साइंसेज"),
                        ExamSubject("csir_chem_sci", "CSIR NET Chemical Sciences Core Theory", "सीएसआईआर नेट केमिकल साइंसेज")
                    )
                )
            )
        )
    )

    // Sample E-Books & Test Series
    val studyItems: List<StudyItem> = listOf(
        // UPSC Books
        StudyItem(
            id = "upsc_mod_history",
            title = "Modern Indian History & Freedom Struggle (1757 - 1947)",
            hindiTitle = "आधुनिक भारत का इतिहास एवं स्वतंत्रता संघर्ष (1757 - 1947)",
            seriesName = "Shakuntalam UPSC CSE Master Series",
            categoryId = "upsc",
            subSectionId = "upsc_prelims",
            subjectId = "upsc_pre_history",
            type = ContentType.EBOOK,
            medium = "Bilingual (Hindi + English)",
            originalPrice = 599,
            discountedPrice = 199,
            rating = 4.9f,
            reviewCount = 2840,
            edition = "2025-26 Updated Edition",
            totalPagesOrTests = "460 Pages",
            isBestseller = true,
            isTrending = true,
            hasSample = true,
            accentColorHex = 0xFF8B2500L,
            description = "Complete exhaustive coverage of Modern Indian History for UPSC CSE Prelims & Mains. Includes Chronological Flowcharts, Mind Maps, 15 Years Prelims Solved MCQs with analytical explanations, and Mains Model Answers.",
            features = listOf(
                "Chronological Timeline from Advent of Europeans to Indian Independence 1947",
                "Revolt of 1857: Causes, Leaders, Centers, and British Administrative Impact",
                "Socio-Religious Reform Movements with Comparative Tables",
                "Indian National Congress Phases (Moderate, Extremist, Gandhian Era)",
                "Detailed coverage of Tribal, Peasant, and Civil Uprisings",
                "350+ Chapter-wise Practice MCQs based on latest UPSC trend"
            ),
            chapters = listOf(
                BookChapter(
                    chapterNumber = 1,
                    title = "Advent of Europeans & British Expansion in India",
                    hindiTitle = "यूरोपीय कंपनियों का आगमन एवं ब्रिटिश साम्राज्य का विस्तार",
                    pageCount = 38,
                    content = """
# Chapter 1: Advent of Europeans & British Expansion

## 1. Sequence of European Arrival
1. **Portuguese (1498)**: Vasco da Gama reached Calicut (Kozhikode) in May 1498; received by King Zamorin.
   - Francisco de Almeida (1505-1509): Initiated the 'Blue Water Policy' (Cartaz system).
   - Afonso de Albuquerque (1509-1515): Real founder of Portuguese power; captured Goa from the Sultan of Bijapur in 1510.
2. **Dutch (1605)**: First factory established at Masulipatnam (1605). Dutch trade was primarily focused on spices and textiles.
3. **English (1608)**: Captain William Hawkins arrived at Jahangir's court in 1608. First permanent factory established at Surat in 1613.
4. **Danes (1620)**: Founded factory at Tranquebar (Tamil Nadu) in 1620.
5. **French (1668)**: First factory established at Surat by François Caron in 1668. Dupleix was their most ambitious Governor.

## 2. Decisive Battles of British Supremacy
- **Battle of Plassey (23 June 1757)**: Robert Clive defeated Nawab Siraj-ud-Daulah of Bengal with the betrayal of Mir Jafar, Rai Durlabh, and Jagat Seth. Laid the territorial foundation of British rule in India.
- **Battle of Buxar (22 October 1764)**: Hector Munro defeated the combined confederacy of Mir Qasim (Nawab of Bengal), Shuja-ud-Daulah (Nawab of Awadh), and Mughal Emperor Shah Alam II.
- **Treaty of Allahabad (1765)**: Clive secured the *Diwani Rights* (revenue collection) of Bengal, Bihar, and Orissa for the East India Company, instituting the infamous Dual System of Government (1765-1772).

## 3. Key Administrative Expansion Doctrines
- **Subsidiary Alliance (Introduced by Lord Wellesley, 1798)**:
  - First state to sign: Nizam of Hyderabad (1798), followed by Mysore (1799), Tanjore (1799), Awadh (1801), and Peshwa (1802).
  - Indian states surrendered external foreign affairs, accepted a British Resident, and maintained British troops.
- **Doctrine of Lapse (Lord Dalhousie, 1848-1856)**:
  - Disallowed adopted heirs from inheriting sovereign royal titles or territories.
  - States annexed: Satara (1848), Jaitpur & Sambalpur (1849), Baghat (1850), Udaipur (1852), Jhansi (1853), Nagpur (1854). Awadh was annexed in 1856 on the pretext of 'misgovernance'.
                    """.trimIndent()
                ),
                BookChapter(
                    chapterNumber = 2,
                    title = "The Great Revolt of 1857: Nature, Causes & Impact",
                    hindiTitle = "1857 का महान विद्रोह: स्वरूप, कारण एवं परिणाम",
                    pageCount = 42,
                    content = """
# Chapter 2: The Great Revolt of 1857

## 1. Underlying Causes
- **Political Causes**: Aggressive annexations under the Doctrine of Lapse (Satara, Jhansi, Nagpur) and the unceremonious annexation of Awadh in 1856 hurt the sentiments of the Sepoys, 75,000 of whom hailed from Awadh ('Nursery of the Bengal Army').
- **Economic Causes**: Ruin of traditional handicrafts by British manufactured imports, high land revenue settlements (Ryotwari, Mahalwari, Zamindari), and dispossession of Inam estates under the Inam Commission (1852).
- **Socio-Religious Causes**: Lex Loci Act (1850) protecting inheritance upon religious conversion; religious disabilities; suspicion regarding Christian missionaries and social reforms like the Sati Abolition Act (1829) and Widow Remarriage Act (1856).
- **Immediate Spark**: Introduction of the Enfield rifle requiring biting off paper cartridges greased with beef and pig fat. On March 29, 1857, Mangal Pandey of the 34th Bengal Native Infantry at Barrackpore mutinied and struck British officers.

## 2. Prominent Centers & Heroes of the 1857 Revolt
- **Delhi**: Nominal leader Bahadur Shah Zafar II; real military command led by General Bakht Khan. (British commander: John Nicholson, Hudson).
- **Kanpur**: Nana Saheb (Dhondu Pant), ably assisted by Tantia Tope and Azimullah Khan. (British commander: Colin Campbell).
- **Lucknow**: Begum Hazrat Mahal on behalf of her minor son Birjis Qadir.
- **Jhansi**: Rani Lakshmibai (Manikarnika), joined forces with Tantia Tope at Gwalior. Sir Hugh Rose remarked: "Here lay the woman who was the only man among the rebels."
- **Arrah / Jagdishpur (Bihar)**: 80-year-old landlord Kunwar Singh and his brother Amar Singh.
- **Faizabad**: Maulvi Ahmadullah Shah ('Lighthouse of Rebellion').
- **Bareilly**: Khan Bahadur Khan.

## 3. Administrative Aftermath & Transformation
- **Government of India Act 1858 (Act for the Better Government of India)**:
  - Abolished the rule of the East India Company; sovereignty transferred directly to the British Crown.
  - Governor-General designated as 'Viceroy of India' (Lord Canning became the first Viceroy).
  - Abolished Board of Control and Court of Directors; established office of Secretary of State for India assisted by a 15-member Council of India.
- **Queen Victoria's Proclamation (1 November 1858)**: Pledged non-interference in religious affairs and declared an end to territorial expansion.
- **Army Reorganization (Peel Commission 1859)**: Reduced Indian troop ratio; artillery and high command kept strictly in European hands.
                    """.trimIndent()
                ),
                BookChapter(
                    chapterNumber = 3,
                    title = "Socio-Religious Reform Movements of 19th Century",
                    hindiTitle = "19वीं सदी के सामाजिक एवं धार्मिक सुधार आंदोलन",
                    pageCount = 36,
                    content = """
# Chapter 3: Socio-Religious Reform Movements

## 1. Raja Ram Mohan Roy & Brahmo Samaj
- Hailed as the **'Father of Modern Indian Renaissance'**.
- Authored *Tuhfat-ul-Muwahhidin* (A Gift to Monotheists) in 1803; established **Atmiya Sabha (1814)** in Calcutta.
- Founded **Brahmo Sabha (1828)**, later renamed **Brahmo Samaj**.
- Key campaign: Abolition of Sati (Regulation XVII of 1829 enacted by Lord William Bentinck).
- Promoted modern Western education; co-founded Hindu College (1817) with David Hare and Vedanta College (1825).
- Journals: *Sambad Kaumudi* (Bengali), *Mirat-ul-Akhbar* (Persian).

## 2. Young Bengal Movement (Henry Louis Vivian Derozio)
- Influenced by the French Revolution; encouraged free thinking, liberty, and rational enquiry.

## 3. Ishwar Chandra Vidyasagar
- Principal of Sanskrit College; fierce champion of widow remarriage, leading to the **Hindu Widows' Remarriage Act (Act XV of 1856)** drafted by Dalhousie and passed under Canning.

## 4. Arya Samaj (Swami Dayanand Saraswati - 1875)
- Original name: Mool Shankar. Founded at Bombay (1875), later headquartered at Lahore (1877).
- Slogan: **"Go Back to the Vedas"** (*Vedo ki or lauto*).
- Landmark treatise: **Satyarth Prakash**.
- Initiated the Shuddhi Movement; promoted DAV (Dayanand Anglo-Vedic) institutions.

## 5. Ramakrishna Mission (Swami Vivekananda - 1897)
- Disciple of Ramakrishna Paramahamsa.
- Historical address at the **World Parliament of Religions at Chicago (1893)**.
- Established Belur Math (1897); preached Practical Vedanta and selfless social service (*Jiva is Shiva*).

## 6. Jyotirao Phule & Satyashodhak Samaj (1873)
- Champion of anti-caste struggle and women's education in Maharashtra.
- Founded India's first school for girls at Bhidewada, Pune (1848) with his wife Savitribai Phule.
- Authored **Gulamgiri** (Slavery, 1873), dedicated to the American abolitionist movement.
                    """.trimIndent()
                )
            )
        ),

        // UPSC Polity
        StudyItem(
            id = "upsc_polity_constitution",
            title = "Indian Polity & Constitutional Governance Master Guide",
            hindiTitle = "भारतीय राजव्यवस्था एवं संविधान संपूर्ण अध्ययन",
            seriesName = "Shakuntalam UPSC CSE Master Series",
            categoryId = "upsc",
            subSectionId = "upsc_prelims",
            subjectId = "upsc_pre_polity",
            type = ContentType.EBOOK,
            medium = "Hindi Medium",
            originalPrice = 650,
            discountedPrice = 220,
            rating = 4.95f,
            reviewCount = 3410,
            edition = "2025-26 (106th Amendment Included)",
            totalPagesOrTests = "540 Pages",
            isBestseller = true,
            isTrending = true,
            hasSample = true,
            accentColorHex = 0xFF0D254CL,
            description = "The definitive Indian Polity guide tailored for civil service aspirants. Covers Articles 1 to 395, All Schedules, Landmark Supreme Court Judgments (Kesavananda Bharati to Digital Personal Data), Constitutional & Non-Constitutional Bodies, Panchayati Raj, and Comparative Constitutionalism.",
            features = listOf(
                "Article-by-Article simplified explanation with latest amendments (101st to 106th)",
                "Preamble, Fundamental Rights (Articles 12-35), DPSP, and Fundamental Duties",
                "Union & State Executive: President, Governor, Prime Minister, Council of Ministers",
                "Judiciary: Supreme Court collegium system, NJAC debate, Public Interest Litigation (PIL)",
                "Federal Structure: Centre-State Legislative, Administrative, and Financial relations",
                "500+ UPSC standard practice MCQs with detailed constitutional reasoning"
            ),
            chapters = listOf(
                BookChapter(
                    chapterNumber = 1,
                    title = "Historical Background & Making of the Indian Constitution",
                    hindiTitle = "संविधान का ऐतिहासिक आधार एवं संविधान सभा",
                    pageCount = 45,
                    content = """
# Chapter 1: Making of the Constitution

## 1. Key Pre-Independence Acts
- **Regulating Act 1773**: Designated Governor of Bengal as 'Governor-General of Bengal' (Lord Warren Hastings); established Supreme Court at Calcutta (1774) with Sir Elijah Impey as Chief Justice.
- **Pitt's India Act 1784**: Established Board of Control for political affairs while Court of Directors handled commercial affairs (Double Government).
- **Charter Act 1833**: Governor-General of Bengal became **Governor-General of India** (Lord William Bentinck); completely abolished Company's commercial monopoly, including tea and China trade.
- **Charter Act 1853**: Separated legislative and executive functions of the Governor-General's Council; introduced open competition for civil services.
- **Indian Councils Act 1909 (Morley-Minto Reforms)**: Introduced communal electorate for Muslims (Lord Minto known as 'Father of Communal Electorate').
- **Government of India Act 1919 (Montagu-Chelmsford Reforms)**: Introduced **Dyarchy** in the provinces (transferred and reserved subjects); introduced bicameralism at the Centre.
- **Government of India Act 1935**: Provided for an All-India Federation; abolished Dyarchy in provinces and introduced Provincial Autonomy; established Federal Court (1937) and Reserve Bank of India.

## 2. The Constituent Assembly
- Idea first proposed by **M.N. Roy in 1934**; officially adopted by INC in 1935.
- Constituted in **November 1946** under the scheme formulated by the **Cabinet Mission Plan**.
- Total strength: 389 members (296 from British India and 93 from Princely States).
- First meeting held on **December 9, 1946**. Dr. Sachchidananda Sinha elected temporary President.
- On **December 11, 1946**, **Dr. Rajendra Prasad** was elected permanent President and H.C. Mukherjee Vice-President; Sir B.N. Rau appointed Constitutional Advisor.
- **Objectives Resolution**: Moved by Pt. Jawaharlal Nehru on December 13, 1946; unanimously adopted on January 22, 1947 (became the precursor to the Preamble).

## 3. Drafting Committee
- Appointed on August 29, 1947, headed by **Dr. B.R. Ambedkar** (Father of the Indian Constitution).
- Members: N. Gopalaswami Ayyangar, Alladi Krishnaswamy Iyer, Dr. K.M. Munshi, Syed Mohammad Saadulla, N. Madhava Rau (replaced B.L. Mitter), T.T. Krishnamachari (replaced D.P. Khaitan).
- The Constitution was adopted on **November 26, 1949** (celebrated as National Constitution Day) and came into full legal effect on **January 26, 1950** (Republic Day).
                    """.trimIndent()
                ),
                BookChapter(
                    chapterNumber = 2,
                    title = "The Preamble & Fundamental Rights (Articles 12 to 35)",
                    hindiTitle = "प्रस्तावना एवं मूल अधिकार (अनुच्छेद 12 से 35)",
                    pageCount = 52,
                    content = """
# Chapter 2: Preamble & Fundamental Rights

## 1. Preamble Analysis
- Declares India to be a **Sovereign, Socialist, Secular, Democratic, Republic**.
- Keywords added by the **42nd Constitutional Amendment Act, 1976**: *Socialist, Secular, and Integrity*.
- Guarantees:
  - **Justice**: Social, Economic, and Political (borrowed from Russian Revolution 1917).
  - **Liberty**: of thought, expression, belief, faith, and worship (borrowed from French Revolution).
  - **Equality**: of status and of opportunity.
  - **Fraternity**: assuring the dignity of the individual and unity and integrity of the Nation.
- **Berubari Union Case (1960)**: Supreme Court opined Preamble is NOT part of the Constitution.
- **Kesavananda Bharati Case (1973)**: Overruled Berubari; held Preamble **IS an integral part of the Constitution** and can be amended under Article 368 without altering the 'Basic Structure'.

## 2. Fundamental Rights (Part III, Articles 12 to 35) - 'Magna Carta of India'
- **Right to Equality (Articles 14 - 18)**:
  - Art. 14: Equality before law (British concept) & Equal protection of laws (American concept).
  - Art. 15: Prohibition of discrimination on grounds only of religion, race, caste, sex, or place of birth.
  - Art. 16: Equality of opportunity in public employment.
  - Art. 17: Abolition of Untouchability.
  - Art. 18: Abolition of titles (except military and academic).
- **Right to Freedom (Articles 19 - 22)**:
  - Art. 19: Guarantees six basic freedoms (speech, assembly, association, movement, residence, profession).
  - Art. 20: Protection in respect of conviction for offences (no ex-post facto law, no double jeopardy, no self-incrimination).
  - Art. 21: Protection of life and personal liberty. Expanded through Maneka Gandhi case (1978) to include right to clean environment, privacy (Puttaswamy case 2017), livelihood, and dignity.
  - Art. 21A: Right to Free and Compulsory Education (6-14 years) added by 86th Amendment Act, 2002.
  - Art. 22: Protection against arrest and detention.
- **Right against Exploitation (Articles 23 - 24)**:
  - Art. 23: Prohibition of human trafficking and forced labour (*begar*).
  - Art. 24: Prohibition of employment of children below 14 years in hazardous industries.
- **Right to Freedom of Religion (Articles 25 - 28)**.
- **Cultural & Educational Rights (Articles 29 - 30)** for minorities.
- **Right to Constitutional Remedies (Article 32)**:
  - Dr. B.R. Ambedkar called Article 32 the **"Heart and Soul of the Constitution"**.
  - Empowers Supreme Court (Art. 32) and High Courts (Art. 226) to issue Writs:
    1. *Habeas Corpus* ("To have the body of") - against unlawful detention.
    2. *Mandamus* ("We command") - directs public official to perform statutory duty.
    3. *Prohibition* - higher court stops inferior court from exceeding jurisdiction.
    4. *Certiorari* - quashes order of inferior court/tribunal.
    5. *Quo-Warranto* ("By what authority") - challenges usurper of public office.
                    """.trimIndent()
                )
            )
        ),

        // UPSC All-India Test Series
        StudyItem(
            id = "upsc_pre_test_series",
            title = "UPSC CSE Prelims All-India Mock Test Series 2025",
            hindiTitle = "यूपीएससी सीएसई प्रारंभिक परीक्षा अखिल भारतीय टेस्ट सीरीज़ 2025",
            seriesName = "Shakuntalam National Test Series",
            categoryId = "upsc",
            subSectionId = "upsc_prelims",
            subjectId = "upsc_pre_history",
            type = ContentType.TEST_SERIES,
            medium = "Bilingual (Hindi + English)",
            originalPrice = 999,
            discountedPrice = 299,
            rating = 4.88f,
            reviewCount = 5120,
            edition = "2025 Full-Length Test Pack",
            totalPagesOrTests = "25 Full Length + 15 Sectional Tests",
            isBestseller = true,
            isTrending = true,
            hasSample = true,
            accentColorHex = 0xFF059669L,
            description = "Simulate real UPSC exam conditions with 40 Tests strictly curated in accordance with recent UPSC pattern (Statement-based, Pair-matching, and Analytical assertion-reasoning). Includes detailed Hindi & English bilingual solutions and All-India Rank analytics.",
            features = listOf(
                "25 Full Length Mock Tests (100 Questions each, 200 Marks)",
                "15 Subject Sectional Tests (History, Polity, Economy, Geo, Env, Sci & Tech)",
                "Strict adherence to UPSC marking scheme (+2.0 correct, -0.66 negative)",
                "Bilingual Questions with in-depth pedagogical explanations",
                "Instant Performance Analytics: Subject-wise weakness breakdown"
            )
        ),

        // State PSC - UPPCS Master
        StudyItem(
            id = "uppcs_complete_kit",
            title = "UPPCS Prelims & UP Special GK Complete E-Book",
            hindiTitle = "यूपीपीसीएस प्रारंभिक परीक्षा एवं उत्तर प्रदेश समग्र अध्ययन",
            seriesName = "Shakuntalam State PSC Series",
            categoryId = "state_psc",
            subSectionId = "psc_uppcs",
            subjectId = "uppcs_up_gk",
            type = ContentType.EBOOK,
            medium = "Hindi Medium",
            originalPrice = 499,
            discountedPrice = 179,
            rating = 4.92f,
            reviewCount = 1890,
            edition = "2025-26 Edition",
            totalPagesOrTests = "390 Pages",
            isBestseller = true,
            isTrending = false,
            hasSample = true,
            accentColorHex = 0xFF1E3A8AL,
            description = "Exhaustive UP General Knowledge matching newly introduced Paper 5 and 6 syllabus. Covers UP History, Geography, Agro-climatic zones, Minerals, UP Budget 2025-26, One District One Product (ODOP), Major Schemes, and 1000+ UP-specific MCQs.",
            features = listOf(
                "Complete UP History from Ancient Mahajanapadas to 1857 and Freedom Movement",
                "Physiography, Rivers (Ganga, Yamuna, Sarayu, Betwa, Ken), Soils and Forests of UP",
                "UP Census 2011 analysis and Demographic indicators",
                "Industrial Corridors, Expressways (Purvanchal, Bundelkhand, Ganga Expressway)",
                "UP Budget 2024-25 and New Industrial Policy Highlights",
                "10 Years UPPCS Solved PYQs with topic-wise distribution"
            ),
            chapters = listOf(
                BookChapter(
                    chapterNumber = 1,
                    title = "Uttar Pradesh: Historical & Cultural Evolution",
                    hindiTitle = "उत्तर प्रदेश: ऐतिहासिक एवं सांस्कृतिक विकास",
                    pageCount = 34,
                    content = """
# Chapter 1: Uttar Pradesh Historical Panorama

## 1. Ancient Period & The 16 Mahajanapadas
Out of 16 Mahajanapadas mentioned in the Buddhist text *Anguttara Nikaya*, **8 Mahajanapadas were located in modern Uttar Pradesh**:
1. **Kashi**: Capital Varanasi (on the confluence of Varuna and Asi rivers).
2. **Kosala**: Capital Shravasti / Ayodhya (King Prasenjit; prominent center of Lord Buddha's discourses).
3. **Vatsa**: Capital Kaushambi (King Udayana).
4. **Malla**: Capitals Kushinagar (place of Buddha's *Mahaparinirvana*) and Pawa (place of Lord Mahavira's *Nirvana*).
5. **Chedi**: Capital Shuktimati (located in Bundelkhand region; King Shishupala).
6. **Kuru**: Capital Hastinapur / Indraprastha (Western UP & Delhi region).
7. **Panchala**: Divided into Northern Panchala (Capital Ahichchhatra, Bareilly) and Southern Panchala (Capital Kampilya, Farrukhabad).
8. **Surasena**: Capital Mathura (ruled by Yadava dynasty; Lord Krishna).

## 2. Medieval Centers in Uttar Pradesh
- **Jaunpur**: Founded by Firoz Shah Tughlaq in memory of Muhammad bin Tughlaq (Jauna Khan). Under the Sharqi Dynasty, Jaunpur blossomed into an eminent center of art and literature, earning the title **'Shiraz-e-Hind'** (*Shiraz of India*). Famous monuments: Atala Masjid, Jhanjhari Masjid.
- **Agra**: Founded in **1504 by Sultan Sikandar Lodi**; made Mughal capital by Babur and Akbar.
- **Fatehpur Sikri**: Built by Akbar (1571); features Buland Darwaza (commemorating Gujarat victory 1572), Panch Mahal, Tomb of Sheikh Salim Chishti.

## 3. Revolt of 1857 in Uttar Pradesh
- Uttar Pradesh was the primary epicenter of the 1857 Revolution.
- May 10, 1857: The Sepoys at **Meerut Cantonment** initiated the revolt and marched to Delhi.
- Prominent heroes: Begum Hazrat Mahal (Lucknow), Nana Saheb & Tatya Tope (Kanpur), Rani Lakshmibai (Jhansi), Maulvi Liaquat Ali (Allahabad), Kadam Singh (Meerut), Devi Singh (Mathura).
                    """.trimIndent()
                )
            )
        ),

        // State PSC - UKPSC (Uttarakhand PCS) Special Test Series & Uttarakhand Special Top 100 PYQs
        StudyItem(
            id = "ukpsc_complete_pyq_series",
            title = "UKPSC Prelims (GS-I) & Uttarakhand Special (Top 100 PYQs) Free Test Series",
            hindiTitle = "उत्तराखंड पीसीएस (UKPSC) प्रारंभिक परीक्षा एवं उत्तराखंड विशेष (टॉप 100 PYQs) फ्री टेस्ट सीरीज़",
            seriesName = "Shakuntalam UKPSC Free PYQ Series",
            categoryId = "state_psc",
            subSectionId = "psc_ukpsc",
            subjectId = "ukpsc_special_100",
            type = ContentType.TEST_SERIES,
            medium = "Bilingual (Hindi + English)",
            originalPrice = 699,
            discountedPrice = 0,
            rating = 4.96f,
            reviewCount = 3180,
            edition = "2025-26 Last 5 Years PYQ Edition",
            totalPagesOrTests = "8 Free Tests • 450 Questions (100 UK Special + 7×50 Subject Qs)",
            isBestseller = true,
            isTrending = true,
            hasSample = true,
            accentColorHex = 0xFF065F46L,
            description = "Classroom-curated Bilingual UKPSC Prelims GS Paper-I Free Test Series based on Last 5 Years PYQ Analysis (2020–2025). Includes the 'Uttarakhand Special (उत्तराखंड विशेष)' 100-Question Practice Set + 7 Subject-wise 50-Question Free Tests.",
            features = listOf(
                "★ Special Section: Uttarakhand Special (उत्तराखंड विशेष) — Top 100 Last 5 Years PYQ Practice Set",
                "7 Subject Sections × 50 PYQ Questions each (History, Polity, Geography, Economics, Environment, Science & Computer, Current Affairs)",
                "Official UKPSC Prelims Marking Scheme (+1.0 Mark for Correct, -0.25 Negative Marking)",
                "Bilingual (English + हिंदी) Questions, Options, Instant Answer & Classroom Faculty Notes"
            )
        ),

        StudyItem(
            id = "ukpsc_paid_prelims_mains_series",
            title = "UKPSC Upper PCS (Prelims GS-I, CSAT & Mains) Pro Test Series — 35 Full-Length Tests",
            hindiTitle = "उत्तराखंड पीसीएस (प्रारंभिक जीएस-I, सीसैट एवं मुख्य परीक्षा) प्रो पेड टेस्ट सीरीज़ (35 फुल-लेंथ टेस्ट)",
            seriesName = "Shakuntalam UKPSC Pro Series",
            categoryId = "state_psc",
            subSectionId = "psc_ukpsc",
            subjectId = "ukpsc_special_100",
            type = ContentType.TEST_SERIES,
            medium = "Bilingual (Hindi + English)",
            originalPrice = 1299,
            discountedPrice = 349,
            rating = 4.95f,
            reviewCount = 1940,
            edition = "2025-26 Haridwar Commission Pattern",
            totalPagesOrTests = "35 Full-Length Tests (20 Prelims GS + 8 CSAT + 7 Uttarakhand Special)",
            isBestseller = true,
            isTrending = true,
            hasSample = true,
            accentColorHex = 0xFF047857L,
            description = "Complete Full-Length Paid Test Series for UKPSC Upper PCS, Lower PCS & RO/ARO with All-Uttarakhand Rank, OMR time-pressure simulation, Uttarakhand Economic Survey & Budget special mock tests, and printed-style booklet explanations.",
            features = listOf(
                "20 Full-Length GS Paper-I Mock Tests (150 Questions each, strictly 33%+ Uttarakhand Special weightage)",
                "8 Full-Length CSAT (Paper-II) Qualifying Mock Tests + 7 Uttarakhand Budget & Survey Sectional Tests",
                "Detailed Classroom Model Explanations with All-State Percentile & Weak-Zone Tracker",
                "Instant 50% Student Scholarship Discount with Coupon Code SHAKUNTALAM50"
            )
        ),

        // State PSC - BPSC (Bihar PCS — 70th/71st CCE) Free 7×100 PYQ Series & Paid Full-Length Pro Series
        StudyItem(
            id = "bpsc_complete_700_free_pyq_series",
            title = "70th/71st BPSC Prelims Free Test Series — 7 Sections × 100 PYQs (700 Questions)",
            hindiTitle = "70वीं/71वीं बीपीएससी (BPSC) प्रारंभिक फ्री टेस्ट सीरीज़ — 7 सेक्शन × 100 प्रश्न (700 PYQ प्रश्न)",
            seriesName = "Shakuntalam BPSC Free PYQ Series",
            categoryId = "state_psc",
            subSectionId = "psc_bpsc",
            subjectId = "bpsc_bihar_special",
            type = ContentType.TEST_SERIES,
            medium = "Bilingual (Hindi + English)",
            originalPrice = 899,
            discountedPrice = 0,
            rating = 4.98f,
            reviewCount = 5420,
            edition = "2025-26 Reformed 4-Option Pattern (+1.0 / -0.33)",
            totalPagesOrTests = "7 Free Sections × 100 Questions = 700 Bilingual PYQs",
            isBestseller = true,
            isTrending = true,
            hasSample = true,
            accentColorHex = 0xFF9A3412L,
            description = "Comprehensive Subject-Wise 100-100 Question Free Test Series for BPSC Combined Competitive Prelims Exam (66th to 70th BPSC PYQ Analysis). Includes ★ Bihar Special (100 Qs), History (100 Qs), Polity (100 Qs), Geography (100 Qs), Economy & Bihar Survey (100 Qs), General Science (100 Qs), and Current Affairs (100 Qs).",
            features = listOf(
                "★ Section 1: Bihar Special (बिहार विशेष — History, Rivers, Minerals, Census & Culture) — 100 PYQ Questions",
                "Sections 2 to 7: History (100 Q), Polity (100 Q), Geography (100 Q), Economy & Bihar Budget (100 Q), General Science (100 Q) & Current Affairs (100 Q)",
                "Updated BPSC Official Marking Scheme: +1.0 Mark for Correct, -0.33 (1/3rd) Negative Marking",
                "Clear, Human-Crafted Classroom Explanations in Simple Hindi & English"
            )
        ),

        StudyItem(
            id = "bpsc_paid_prelims_pro_test_series",
            title = "70th/71st BPSC Combined Prelims & Mains Pro Paid Test Series — 40 Full-Length Tests",
            hindiTitle = "70वीं/71वीं बीपीएससी (BPSC) प्रारंभिक एवं मुख्य परीक्षा प्रो पेड टेस्ट सीरीज़ (40 फुल-लेंथ टेस्ट)",
            seriesName = "Shakuntalam BPSC Pro Test Series",
            categoryId = "state_psc",
            subSectionId = "psc_bpsc",
            subjectId = "bpsc_bihar_special",
            type = ContentType.TEST_SERIES,
            medium = "Bilingual (Hindi + English)",
            originalPrice = 1499,
            discountedPrice = 399,
            rating = 4.97f,
            reviewCount = 3890,
            edition = "2025-26 Patna Commission New Pattern",
            totalPagesOrTests = "40 Full-Length Tests (25 Prelims 150-Q Mocks + 15 Sectional & Bihar Survey Mocks)",
            isBestseller = true,
            isTrending = true,
            hasSample = true,
            accentColorHex = 0xFFB45309L,
            description = "Designed by senior Patna & Delhi Civil Services mentors on the latest 69th/70th BPSC analytical multi-statement pattern. Includes 25 Full-Length 150-Question Simulators, Bihar Economic Survey & Budget Special Tests, NCERT Class 6–12 Science Tests, and All-Bihar Rank Analytics.",
            features = listOf(
                "25 Full-Length 150-Question BPSC Prelims Mock Tests with Real Exam 1/3rd Negative Marking",
                "10 Dedicated Bihar Special, Bihar Caste Survey & Bihar Economic Survey/Budget Tests",
                "5 NCERT Science (Physics, Chemistry, Biology) High-Yield Sectional Tests",
                "Subject-wise Classroom Notes & Instant 50% Off with Coupon SHAKUNTALAM50"
            )
        ),

        // State Subordinate - UPSSSC (PET, VDO, Lekhpal, Junior Assistant, Lower PCS) Free 9-Section (1,050 Qs) & Paid Pro Series
        StudyItem(
            id = "upsssc_complete_1050_free_pyq_series",
            title = "UPSSSC (PET, VDO, Lekhpal, Jr. Assistant) Free Test Series — 9 Sections • 1,050 PYQs",
            hindiTitle = "यूपी ट्रिपल एससी (UPSSSC) संपूर्ण फ्री टेस्ट सीरीज़ — 9 सेक्शन • 1,050 प्रश्न (यूपी स्पेशल 250 प्रश्न सहित)",
            seriesName = "Shakuntalam UPSSSC Free PYQ Series",
            categoryId = "subordinate_selection",
            subSectionId = "sub_upsssc",
            subjectId = "upsssc_up_special_250",
            type = ContentType.TEST_SERIES,
            medium = "Bilingual (Hindi + English)",
            originalPrice = 799,
            discountedPrice = 0,
            rating = 4.99f,
            reviewCount = 6840,
            edition = "2025-26 Official UPSSSC Syllabus (+1.0 / -0.25)",
            totalPagesOrTests = "9 Free Sections • 1,050 Questions (6 GK×100 + UP Special 250 + Computer 100 + DI 100)",
            isBestseller = true,
            isTrending = true,
            hasSample = true,
            accentColorHex = 0xFF7C2D12L,
            description = "Strictly aligned with official UPSSSC (PET, VDO, Lekhpal, Junior Assistant, Lower PCS) syllabus and Last 5 Years PYQ Analysis. Includes 6 GK Sections of 100 Questions each (History, Polity, Geography, Economics, Environment, Science & Tech), ★ Best 250 UP Special Questions, Computer & IT (100 Qs), and Data Interpretation — Graph & Table Analysis (100 Qs).",
            features = listOf(
                "GK 6 Sections (100-100 Questions each): History (100 Q), Polity (100 Q), Geography (100 Q), Economics (100 Q), Environment (100 Q), Science & Tech (100 Q)",
                "★ Special Section: UP Special (यूपी स्पेशल) — Best 250 UPSSSC Previous Year & High-Yield Questions",
                "Dedicated Technical & Analytical Sections: Computer & IT (100 Qs) + Data Interpretation / DI Graph & Table (100 Qs)",
                "Official UPSSSC Marking (+1.0 / -0.25) with Bilingual Questions & Instant Step-by-Step Classroom Solutions"
            )
        ),

        StudyItem(
            id = "upsssc_paid_pro_master_test_series",
            title = "UPSSSC PET, VDO, Lekhpal & Junior Assistant Pro Paid Test Series — 45 Full-Length Mocks",
            hindiTitle = "यूपी ट्रिपल एससी (UPSSSC PET, VDO, लेखपाल, कनिष्ठ सहायक) प्रो पेड टेस्ट सीरीज़ (45 फुल-लेंथ टेस्ट)",
            seriesName = "Shakuntalam UPSSSC Pro Series",
            categoryId = "subordinate_selection",
            subSectionId = "sub_upsssc",
            subjectId = "upsssc_up_special_250",
            type = ContentType.TEST_SERIES,
            medium = "Bilingual (Hindi + English)",
            originalPrice = 999,
            discountedPrice = 299,
            rating = 4.97f,
            reviewCount = 4920,
            edition = "2025-26 Lucknow Commission New Pattern",
            totalPagesOrTests = "45 Full-Length Tests (20 PET 100-Q Mocks + 10 VDO + 10 Lekhpal/Jr. Asst + 5 DI/UP Special)",
            isBestseller = true,
            isTrending = true,
            hasSample = true,
            accentColorHex = 0xFF9A3412L,
            description = "Complete All-UP Rank Test Series for UPSSSC PET, Gram Panchayat Adhikari (VDO), Rajasva Lekhpal, Junior Assistant & Auditor exams. Features 20 Full-Length PET Simulators (with 20-mark Graph & Table DI), UP Gramya Vikas & UP Budget Special Mocks, and NIELIT-level Computer Tests.",
            features = listOf(
                "20 Full-Length UPSSSC PET 100-Question Mock Tests with 99+ Percentile Target Analytics",
                "15 Exam-Specific Full Mocks for VDO, Rajasva Lekhpal (Gramya Vikas) & Junior Assistant",
                "10 High-Scoring Sectional Mocks for Graph/Table DI (20 Marks), UP Special & Computer New Pattern",
                "Bilingual Solutions + Instant 50% Student Discount with Coupon Code SHAKUNTALAM50"
            )
        ),

        // State Subordinate - UKSSSC (Uttarakhand Group C & Group D) Free 10-Section (1,150 Qs) & Paid Pro Series
        StudyItem(
            id = "uksssc_complete_1150_free_pyq_series",
            title = "UKSSSC (Uttarakhand Group C & D — VDO, Patwari, Kanishth Sahayak, Forest Guard) Free Test Series — 10 Sections • 1,150 PYQs",
            hindiTitle = "UKSSSC (उत्तराखंड समूह 'ग' एवं 'घ') संपूर्ण फ्री टेस्ट सीरीज़ — 10 सेक्शन • 1,150 प्रश्न (उत्तराखंड स्पेशल 250 प्रश्न सहित)",
            seriesName = "Shakuntalam UKSSSC Free PYQ Series",
            categoryId = "subordinate_selection",
            subSectionId = "sub_uksssc",
            subjectId = "uksssc_uk_special_250",
            type = ContentType.TEST_SERIES,
            medium = "Bilingual (Hindi + English)",
            originalPrice = 799,
            discountedPrice = 0,
            rating = 4.99f,
            reviewCount = 5890,
            edition = "2025-26 Official Dehradun Commission Syllabus (+1.0 / -0.25)",
            totalPagesOrTests = "10 Free Sections • 1,150 Questions (6 GK×100 + UK Special 250 + Hindi 100 + Computer 100 + Reasoning/DI 100)",
            isBestseller = true,
            isTrending = true,
            hasSample = true,
            accentColorHex = 0xFF065F46L,
            description = "Strictly aligned with official UKSSSC (Group C & Group D — VDO/VPDO, Patwari/Lekhpal, Kanishth Sahayak, Forest Guard, Uttarakhand Police Constable/SI) syllabus and Last 5 Years PYQ Analysis (2020–2025). Includes 6 GK Sections of 100 Questions each, ★ Best 250 Uttarakhand Special Questions (40% exam weightage), General Hindi (100 Qs), Computer & IT (100 Qs), and Reasoning & Data Interpretation (100 Qs).",
            features = listOf(
                "GK 6 Sections (100-100 Questions each): History (100 Q), Polity (100 Q), Geography (100 Q), Economics (100 Q), Environment & Forest (100 Q), Science & Tech (100 Q)",
                "★ Special Section: Uttarakhand Special (उत्तराखंड स्पेशल) — Best 250 Last 5 Years UKSSSC Group C/D Questions",
                "Core Scoring Sections: General Hindi & Literature (100 Qs) + Computer & IT (100 Qs) + Reasoning & DI (100 Qs)",
                "Official UKSSSC Marking (+1.0 / -0.25) with Bilingual Questions & Instant Step-by-Step Classroom Solutions"
            )
        ),

        StudyItem(
            id = "uksssc_paid_pro_master_test_series",
            title = "UKSSSC Group C & Group D (VDO, Patwari, Kanishth Sahayak, Forest Guard, Police) Pro Paid Test Series — 40 Full-Length Mocks",
            hindiTitle = "UKSSSC (उत्तराखंड समूह 'ग' एवं 'घ' — VDO, पटवारी, कनिष्ठ सहायक, वन आरक्षी, पुलिस) प्रो पेड टेस्ट सीरीज़ (40 फुल-लेंथ टेस्ट)",
            seriesName = "Shakuntalam UKSSSC Pro Series",
            categoryId = "subordinate_selection",
            subSectionId = "sub_uksssc",
            subjectId = "uksssc_uk_special_250",
            type = ContentType.TEST_SERIES,
            medium = "Bilingual (Hindi + English)",
            originalPrice = 899,
            discountedPrice = 279,
            rating = 4.98f,
            reviewCount = 4120,
            edition = "2025-26 Dehradun Commission Pattern (40 UK + 20 Hindi + 40 GS)",
            totalPagesOrTests = "40 Full-Length Tests (20 Graduate Level VDO/Patwari + 10 Inter Level Kanishth Sahayak/Forest Guard + 10 Police/Group D)",
            isBestseller = true,
            isTrending = true,
            hasSample = true,
            accentColorHex = 0xFF047857L,
            description = "Complete All-Uttarakhand Rank Test Series for UKSSSC Graduate & Intermediate Group C and Group D recruitments. Strictly follows the 100-mark official distribution: 40 Marks Uttarakhand GK + 20 Marks General Hindi + 40 Marks GS, Computer & Reasoning.",
            features = listOf(
                "20 Full-Length Graduate Level (VDO/VPDO, Patwari/Lekhpal) 100-Question Simulators",
                "10 Full-Length Inter Level (Kanishth Sahayak, Forest Guard, Police Constable) + 10 Group D & Sectional Mocks",
                "Pariksha Vani, Ajay Rawat & Badri Datt Pandey Line-by-Line Explanations",
                "Bilingual Solutions + Instant 50% Student Discount with Coupon Code SHAKUNTALAM50"
            )
        ),

        // SSC CGL Master Guide
        StudyItem(
            id = "ssc_cgl_master_guide",
            title = "SSC CGL (Tier 1 & 2) Complete Formula & Strategy E-Book",
            hindiTitle = "एसएससी सीजीएल (टियर 1 व 2) संपूर्ण गाइड एवं शॉर्टकट ट्रिक्स",
            seriesName = "Shakuntalam SSC Master Series",
            categoryId = "ssc",
            subSectionId = "ssc_cgl",
            subjectId = "ssc_cgl_quant",
            type = ContentType.EBOOK,
            medium = "Bilingual (Hindi + English)",
            originalPrice = 450,
            discountedPrice = 169,
            rating = 4.85f,
            reviewCount = 4210,
            edition = "2025-26 Edition",
            totalPagesOrTests = "480 Pages",
            isBestseller = true,
            isTrending = true,
            hasSample = true,
            accentColorHex = 0xFFD97706L,
            description = "Covers all 4 subjects for SSC CGL Tier 1 and Tier 2: Quantitative Aptitude (with Vedic Math short-tricks), Reasoning Ability, English Vocabulary & Grammar Rules, Static GK & Science, plus Computer Proficiency Module.",
            features = listOf(
                "1500+ Advanced Maths & Arithmetic Formula Sheet with Step-by-Step Solved Examples",
                "100 Golden Rules of English Grammar with Error Spotting Questions",
                "Static GK Capsule: National Parks, Folk Dances, Temples, Books & Authors",
                "Computer Awareness & Keyboard Shortcuts for Tier-2 Qualifying Module",
                "Previous 5 Years SSC CGL (2020-2024) TCS Pattern Solved Questions"
            )
        ),

        // SSC CGL / CHSL / CPO — Free 8-Section (800 TCS PYQs) & Paid Pro Test Series
        StudyItem(
            id = "ssc_complete_800_free_pyq_series",
            title = "SSC CGL / CHSL / CPO Free Test Series — 8 Sections × 100 TCS PYQs (800 Questions)",
            hindiTitle = "SSC CGL / CHSL / CPO संपूर्ण फ्री टेस्ट सीरीज़ — 8 सेक्शन × 100 प्रश्न (800 TCS PYQ प्रश्न)",
            seriesName = "Shakuntalam SSC Free TCS PYQ Series",
            categoryId = "ssc",
            subSectionId = "ssc_cgl",
            subjectId = "ssc_gs_history",
            type = ContentType.TEST_SERIES,
            medium = "Bilingual (Hindi + English)",
            originalPrice = 799,
            discountedPrice = 0,
            rating = 4.99f,
            reviewCount = 7420,
            edition = "2025-26 Official TCS CBT Pattern (+2.0 / -0.50)",
            totalPagesOrTests = "8 Free Sections × 100 Questions = 800 Bilingual TCS PYQs",
            isBestseller = true,
            isTrending = true,
            hasSample = true,
            accentColorHex = 0xFF1E3A8AL,
            description = "Complete Subject-Wise 100-100 Question Free Test Series for SSC CGL (Tier-I & II), SSC CHSL, and SSC CPO based on Last 5 Years TCS PYQ Analysis (2020–2025). Includes 5 GS Sections × 100 Questions (History, Polity, Geography, Environment, Economics) + Reasoning (100 Qs) + Mathematics (100 Qs) + English Language (100 Qs).",
            features = listOf(
                "GS 5 Sections (100-100 Questions each): History (100 Q), Polity (100 Q), Geography (100 Q), Environment (100 Q), Economics (100 Q)",
                "Core Aptitude & Language (100-100 Questions each): Reasoning (100 Q) + Mathematics / Quant (100 Q) + English Language (100 Q)",
                "Official SSC Tier-I Marking Scheme: +2.0 Marks for Correct, -0.50 Negative Marking",
                "Bilingual (English + हिंदी) Questions, Options & Bullet-Point TCS Shortcut Explanations"
            )
        ),

        // SSC CGL Test Series (Paid Pro Series)
        StudyItem(
            id = "ssc_cgl_mock_pack",
            title = "SSC CGL / CHSL / CPO Tier-I & Tier-II Pro Paid Test Series — 50 Full-Length TCS Mocks",
            hindiTitle = "SSC CGL / CHSL / CPO (टियर-I एवं टियर-II) प्रो पेड टेस्ट सीरीज़ (50 फुल-लेंथ TCS मॉक टेस्ट)",
            seriesName = "Shakuntalam SSC Speed Test Series",
            categoryId = "ssc",
            subSectionId = "ssc_cgl",
            subjectId = "ssc_mathematics",
            type = ContentType.TEST_SERIES,
            medium = "Bilingual (Hindi + English)",
            originalPrice = 899,
            discountedPrice = 249,
            rating = 4.96f,
            reviewCount = 5890,
            edition = "2025-26 Latest TCS CBT Pattern",
            totalPagesOrTests = "50 Full Mocks (25 CGL Tier-I/II + 15 CHSL + 10 CPO SI)",
            isBestseller = true,
            isTrending = true,
            hasSample = true,
            accentColorHex = 0xFF0D254CL,
            description = "50 Full-Length Mock Tests mirroring the exact SSC CGL, CHSL & CPO TCS CBT pattern (+2.0 for correct, -0.50 negative in Tier-I; +3.0 / -1.0 in Tier-II). Includes All-India Rank, Percentile Predictor, Computer Qualifying Module, and Shortcut Solution Keys.",
            features = listOf(
                "25 Full-Length SSC CGL Tier-I (100 Qs, 60 Mins) & Tier-II (Session-I & II with Computer Module) Simulators",
                "15 Full-Length SSC CHSL (10+2) Tier-I & II Mock Tests + 10 SSC CPO SI (Paper-I & English 200-Q Paper-II) Mocks",
                "Topic-wise TCS Speed Drills for Advance Maths, Reasoning Puzzles, Static GK & English Cloze/Comprehension",
                "Instant 50% Student Discount with Coupon Code SHAKUNTALAM50"
            )
        ),

        // Railway NTPC Book
        StudyItem(
            id = "rrb_ntpc_complete",
            title = "RRB NTPC & Group D General Science & Math Capsule",
            hindiTitle = "रेलवे एनटीपीसी एवं ग्रुप डी सामान्य विज्ञान व गणित कैप्सूल",
            seriesName = "Shakuntalam Railway Series",
            categoryId = "railway",
            subSectionId = "rrb_ntpc",
            subjectId = "rrb_ntpc_ga",
            type = ContentType.EBOOK,
            medium = "Hindi Medium",
            originalPrice = 399,
            discountedPrice = 149,
            rating = 4.82f,
            reviewCount = 2100,
            edition = "2025 Edition",
            totalPagesOrTests = "350 Pages",
            isBestseller = false,
            isTrending = true,
            hasSample = true,
            accentColorHex = 0xFF13366DL,
            description = "Specialized for Railway exams. Extensive coverage of Physics, Chemistry, Biology, Environmental Science, Railway Budget facts, Indian Railways history, and quick arithmetic methods.",
            features = listOf(
                "3000+ One-Liner General Science Questions from NCERT Class 6-10",
                "Physics Numerical Problems solved with short formulas",
                "Complete History & Network of Indian Railways, Zones & Headquarters",
                "15 Practice Sets with OMR Sheet format"
            )
        ),

        // Banking PO / Clerk
        StudyItem(
            id = "bank_po_reasoning_quant",
            title = "Banking Reasoning Puzzles & Data Interpretation Pro",
            hindiTitle = "बैंकिंग रीजनिंग पहेलियाँ एवं डेटा इंटरप्रिटेशन प्रो",
            seriesName = "Shakuntalam Banking Series",
            categoryId = "banking",
            subSectionId = "bank_po_clerk",
            subjectId = "bank_quant",
            type = ContentType.EBOOK,
            medium = "English Medium",
            originalPrice = 550,
            discountedPrice = 189,
            rating = 4.91f,
            reviewCount = 1750,
            edition = "2025-26 Edition",
            totalPagesOrTests = "420 Pages",
            isBestseller = true,
            isTrending = false,
            hasSample = true,
            accentColorHex = 0xFF0F766EL,
            description = "Master high-level Floor-Flat, Circular, Box, and Parallel Row Puzzles for SBI PO & IBPS PO Mains. Includes Radar, Caselet, and Missing DI with step-by-step cognitive approaches.",
            features = listOf(
                "500+ Advanced Level Reasoning Puzzles categorized by difficulty",
                "150+ Caselet and Tabular Data Interpretation sets",
                "Approximation, Quadratic Equations, and Number Series speed tricks",
                "Monthly Banking & Financial Awareness Digest"
            )
        ),

        // IIT JEE Main & Advanced Paid Test Series + E-Book
        StudyItem(
            id = "iit_jee_main_adv_paid_test_series",
            title = "IIT JEE (Main + Advanced) 45 Full-Length CBT Paid Test Series (5-Yr PYQ Pattern)",
            hindiTitle = "आईआईटी जेईई (मेन + एडवांस्ड) 45 फुल-लेंथ पेड टेस्ट सीरीज़ (5-वर्षीय PYQ पैटर्न)",
            seriesName = "Shakuntalam JEE Pro Test Series",
            categoryId = "jee_neet",
            subSectionId = "iit_jee",
            subjectId = "jee_main_physics",
            type = ContentType.TEST_SERIES,
            medium = "Bilingual (Hindi + English)",
            originalPrice = 999,
            discountedPrice = 299,
            rating = 4.98f,
            reviewCount = 3420,
            edition = "2025-26 NTA & IIT Pattern",
            totalPagesOrTests = "45 Full Mocks + 1000 PYQs",
            isBestseller = true,
            isTrending = true,
            hasSample = true,
            accentColorHex = 0xFF1D4ED8L,
            description = "Complete Paid Test Series for IIT JEE Main & IIT JEE Advanced covering Physics, Physical Chemistry, Organic Chemistry, Inorganic Chemistry, and Mathematics based on the last 5 years (2020-2025) PYQ trends.",
            features = listOf(
                "25 JEE Main Full-Length NTA CBT Mocks + 20 JEE Advanced Paper-1 & Paper-2 Mocks",
                "Subject-wise 100-Question Banks in Physics, Physical/Organic/Inorganic Chem & Maths",
                "All India Percentile Predictor, Subject Accuracy & Time-Taken Analytics",
                "Detailed step-by-step Bilingual (English + Hindi) solutions"
            )
        ),

        // IIT JEE Mathematics
        StudyItem(
            id = "jee_maths_calculus",
            title = "IIT JEE Mathematics: Calculus & Coordinate Geometry",
            hindiTitle = "आईआईटी जेईई गणित: कैलकुलस एवं निर्देशांक ज्यामिति",
            seriesName = "Shakuntalam JEE Master Series",
            categoryId = "jee_neet",
            subSectionId = "iit_jee",
            subjectId = "jee_main_mathematics",
            type = ContentType.EBOOK,
            medium = "English Medium",
            originalPrice = 699,
            discountedPrice = 249,
            rating = 4.96f,
            reviewCount = 1430,
            edition = "2025 JEE Advanced",
            totalPagesOrTests = "510 Pages",
            isBestseller = true,
            isTrending = true,
            hasSample = true,
            accentColorHex = 0xFF4338CAL,
            description = "Rigorous, concept-first approach to Limits, Continuity, Differentiability, Definite Integrals, Differential Equations, Conic Sections, and Vectors & 3D Geometry. Includes Single-Choice, Multi-Correct, Matrix Match, and Integer Type questions.",
            features = listOf(
                "Fundamental proofs, graphical intuition, and shortcut derivations",
                "Tiered problem sets: JEE Main Level -> JEE Advanced Level -> Olympiad Level",
                "Detailed step-by-step solutions for every problem",
                "20 Years (2005-2024) IIT JEE Archive with Video Solution QR Codes"
            )
        ),

        // NEET Biology
        StudyItem(
            id = "neet_bio_ncert_extract",
            title = "NEET Biology 360/360: NCERT Line-by-Line Guide",
            hindiTitle = "नीट जीव विज्ञान 360/360: एनसीईआरटी लाइन-बाय-लाइन गाइड",
            seriesName = "Shakuntalam NEET Series",
            categoryId = "jee_neet",
            subSectionId = "neet_ug",
            subjectId = "neet_biology",
            type = ContentType.EBOOK,
            medium = "Bilingual (Hindi + English)",
            originalPrice = 650,
            discountedPrice = 219,
            rating = 4.97f,
            reviewCount = 4850,
            edition = "2025-26 Edition",
            totalPagesOrTests = "580 Pages",
            isBestseller = true,
            isTrending = true,
            hasSample = true,
            accentColorHex = 0xFF059669L,
            description = "Every line of Class 11th & 12th NCERT transformed into Fill-in-the-blanks, Statement-Reason assertions, and Diagram labeling drills. Guaranteed to maximize your score towards 360/360 in NEET UG Biology.",
            features = listOf(
                "Covers both Botany & Zoology strictly mapped to latest NTA NEET syllabus",
                "4500+ NCERT Line-based MCQs with chapter summaries",
                "High-Yield Diagram atlas with labels and functions",
                "Scientist contributions, years, and historical discoveries compiled in one place"
            )
        ),

        // CBSE Class 10th
        StudyItem(
            id = "cbse_10_all_in_one",
            title = "CBSE Class 10th Science & Maths Board Master Guide",
            hindiTitle = "सीबीएसई कक्षा 10वीं विज्ञान एवं गणित बोर्ड मास्टर गाइड",
            seriesName = "Shakuntalam School Board Series",
            categoryId = "cbse_school",
            subSectionId = "cbse_10th_9th",
            subjectId = "cbse_10_science",
            type = ContentType.EBOOK,
            medium = "Bilingual (Hindi + English)",
            originalPrice = 420,
            discountedPrice = 149,
            rating = 4.87f,
            reviewCount = 1290,
            edition = "2025 Board Exam Edition",
            totalPagesOrTests = "380 Pages",
            isBestseller = false,
            isTrending = true,
            hasSample = true,
            accentColorHex = 0xFF2563EBL,
            description = "Comprehensive board revision companion for Class 10th students. Features NCERT Textbook and Exemplar solutions, Case-Study Based Questions, Competency-Focused Questions, and 10 Sample Papers with Marking Scheme.",
            features = listOf(
                "Chapter-at-a-glance Mind Maps and Flowcharts",
                "NCERT Line-by-Line solutions for Science & Mathematics",
                "Assertion & Reason + Case-based problem bank",
                "Previous 10 Years Board Papers with Topper Answer Sheets"
            )
        ),

        // Teaching - CTET
        StudyItem(
            id = "ctet_pedagogy_master",
            title = "CTET & UPTET Child Development & Pedagogy (CDP) Master",
            hindiTitle = "सीटेट एवं यूपीटीईटी बाल विकास एवं शिक्षाशास्त्र (CDP) संपूर्ण हल",
            seriesName = "Shakuntalam Shikshak Series",
            categoryId = "teaching",
            subSectionId = "tet_central_state",
            subjectId = "tet_cdp",
            type = ContentType.EBOOK,
            medium = "Hindi Medium",
            originalPrice = 400,
            discountedPrice = 139,
            rating = 4.89f,
            reviewCount = 2380,
            edition = "2025 Edition",
            totalPagesOrTests = "320 Pages",
            isBestseller = true,
            isTrending = false,
            hasSample = true,
            accentColorHex = 0xFF7C3AEDL,
            description = "Complete cognitive and pedagogical theories of Piaget, Vygotsky, Kohlberg, Chomsky, and Gardner simplified in Hindi with daily classroom examples. Perfect for scoring 30/30 in CDP Paper 1 & 2.",
            features = listOf(
                "Piaget Cognitive Stages, Vygotsky ZPD & Scaffolding, Kohlberg Moral Dilemmas",
                "National Education Policy (NEP 2020) and NCF 2005/2023 Key Principles",
                "Inclusive Education, Gifted & Differently-abled Children pedagogies",
                "1200+ Solved CTET/UPTET CDP Questions from 2011 to 2024"
            )
        ),

        // Computer Certifications - CCC
        StudyItem(
            id = "ccc_computer_master",
            title = "NIELIT CCC (Course on Computer Concepts) 2000+ MCQs",
            hindiTitle = "नाइलिट सीसीसी कंप्यूटर संपूर्ण कोर्स एवं 2000+ वस्तुनिष्ठ प्रश्न",
            seriesName = "Shakuntalam Tech Series",
            categoryId = "computer_cert",
            subSectionId = "nielit_cert",
            subjectId = "ccc_master",
            type = ContentType.EBOOK,
            medium = "Hindi Medium",
            originalPrice = 350,
            discountedPrice = 99,
            rating = 4.93f,
            reviewCount = 6120,
            edition = "2025 Latest Syllabus",
            totalPagesOrTests = "280 Pages",
            isBestseller = true,
            isTrending = true,
            hasSample = true,
            accentColorHex = 0xFF0284C7L,
            description = "Guaranteed Grade S in NIELIT CCC exam. Covers LibreOffice (Writer, Calc, Impress), Windows/Linux commands, Internet & Web Protocols, Digital Financial Tools (UPI, AEPS, USSD), Cyber Security, and FutureSkills.",
            features = listOf(
                "LibreOffice Writer, Calc & Impress complete shortcut keys and menu tables",
                "Internet, WWW, Email, Social Networking, and e-Governance services",
                "Digital Payment methods: BHIM, UPI, RTGS, NEFT, IMPS, QR Codes",
                "10 Complete Model Test Papers (100 Questions each) with Answer Keys"
            )
        ),

        // AI & Machine Learning
        StudyItem(
            id = "ai_ml_handbook",
            title = "Artificial Intelligence & Machine Learning Practical Handbook",
            hindiTitle = "आर्टिफिशियल इंटेलिजेंस एवं मशीन लर्निंग प्रायोगिक हैंडबुक",
            seriesName = "Shakuntalam Emerging Tech Series",
            categoryId = "ai_ml",
            subSectionId = "ai_foundations",
            subjectId = "ai_handbook",
            type = ContentType.EBOOK,
            medium = "English Medium",
            originalPrice = 750,
            discountedPrice = 299,
            rating = 4.94f,
            reviewCount = 980,
            edition = "2025 Edition",
            totalPagesOrTests = "420 Pages",
            isBestseller = false,
            isTrending = true,
            hasSample = true,
            accentColorHex = 0xFF4F46E5L,
            description = "From linear regression to Transformers and Large Language Models. Hands-on coding examples in Python with NumPy, Pandas, Scikit-Learn, PyTorch, and Hugging Face. Written specifically for students and competitive tech exams.",
            features = listOf(
                "Supervised & Unsupervised Learning algorithms with intuitive math derivations",
                "Neural Network architectures: Perceptrons, CNNs, RNNs, and Attention Mechanism",
                "Prompt Engineering best practices for Gemini & Generative AI applications",
                "End-to-End Capstone Projects with downloadable GitHub code"
            )
        ),

        // UGC NET Paper 1
        StudyItem(
            id = "ugc_net_paper1",
            title = "UGC NET Paper 1: Teaching & Research Aptitude Master Guide",
            hindiTitle = "यूजीसी नेट पेपर 1: शिक्षण एवं शोध अभियोग्यता संपूर्ण अध्ययन",
            seriesName = "Shakuntalam UGC Master Series",
            categoryId = "ugc_csir_net",
            subSectionId = "ugc_net",
            subjectId = "ugc_paper_1",
            type = ContentType.EBOOK,
            medium = "Hindi Medium",
            originalPrice = 480,
            discountedPrice = 179,
            rating = 4.88f,
            reviewCount = 1620,
            edition = "2025 NTA Pattern",
            totalPagesOrTests = "410 Pages",
            isBestseller = false,
            isTrending = true,
            hasSample = true,
            accentColorHex = 0xFF9333EAL,
            description = "Exhaustive coverage of all 10 units for UGC NET General Paper: Teaching Aptitude, Research Aptitude, Reading Comprehension, Communication, Mathematical Reasoning, Logical Reasoning, Data Interpretation, ICT, People & Environment, and Higher Education System.",
            features = listOf(
                "Unit-wise detailed concept notes and comparative matrices",
                "Formal & Informal Fallacies, Indian Logic (*Pramanas* and *Hetvabhasa*)",
                "SDGs (Sustainable Development Goals) & MDGs environmental treaties",
                "Previous 10 Sessions Solved Papers with rationales"
            )
        ),

        // NEET (UG) Paid Test Series
        StudyItem(
            id = "neet_ug_paid_test_series",
            title = "NEET (UG) NCERT Line-by-Line & 5-Year PYQ Pro Test Series (40 Full Mocks)",
            hindiTitle = "NEET (UG) NCERT लाइन-बाय-लाइन एवं 5-वर्षीय PYQ प्रो टेस्ट सीरीज़ (40 मॉक टेस्ट)",
            seriesName = "Shakuntalam NEET Medical Master Series",
            categoryId = "jee_neet",
            subSectionId = "neet_ug",
            subjectId = "neet_botany",
            type = ContentType.TEST_SERIES,
            medium = "Bilingual (Hindi + English)",
            originalPrice = 799,
            discountedPrice = 299,
            rating = 4.95f,
            reviewCount = 4120,
            edition = "2025 NTA NEET Pattern",
            totalPagesOrTests = "40 Full Mocks + 600 Subject PYQs",
            isBestseller = true,
            isTrending = true,
            hasSample = true,
            accentColorHex = 0xFF047857L,
            description = "Complete NTA NEET (UG) Medical Entrance Test Series featuring 40 full-length 720-mark tests and 6 subject-wise 100-question NCERT PYQ banks (Physics, Physical Chemistry, Organic Chemistry, Inorganic Chemistry, Botany, and Zoology).",
            features = listOf(
                "6 Subject-wise 100-Question NCERT 5-Year PYQ Banks (600 Bilingual Questions)",
                "40 Full-Length 720-Mark NTA NEET (UG) Pattern Mock Tests (+4 / -1 Marking)",
                "Detailed NCERT Class 11 & 12 page-referenced explanations in Hindi & English",
                "All-India NEET Rank Predictor & Subject-wise Accuracy Analytics"
            )
        ),

        // UGC NET (Paper 1 & Paper 2) Paid Test Series
        StudyItem(
            id = "ugc_net_paid_test_series",
            title = "UGC NET / JRF Paper 1 (10 Units) & Paper 2 (All 12 Subjects) Complete PYQ Pro Test Series",
            hindiTitle = "UGC NET / JRF पेपर 1 (10 यूनिट्स) एवं पेपर 2 (सभी 12 विषय) संपूर्ण PYQ प्रो टेस्ट सीरीज़",
            seriesName = "Shakuntalam UGC NET JRF Master Series",
            categoryId = "ugc_csir_net",
            subSectionId = "ugc_net_paper1",
            subjectId = "ugc_p1_unit1_teaching",
            type = ContentType.TEST_SERIES,
            medium = "Bilingual (Hindi + English)",
            originalPrice = 899,
            discountedPrice = 299,
            rating = 4.96f,
            reviewCount = 3480,
            edition = "2025 NTA UGC NET Pattern",
            totalPagesOrTests = "22 Full Tests (2,200 PYQ MCQs)",
            isBestseller = true,
            isTrending = true,
            hasSample = true,
            accentColorHex = 0xFF4338CAL,
            description = "Comprehensive NTA UGC NET / JRF Test Series covering all 10 Syllabus Units of Paper 1 (1,000 PYQ MCQs) and all 12 Major Subjects of Paper 2 (1,200 PYQ MCQs) with detailed bilingual rationales.",
            features = listOf(
                "Paper 1: All 10 Units × 100 PYQ MCQs = 1,000 Bilingual Questions",
                "Paper 2: All 12 Subjects (History, Pol Sci, Geography, Economics, Hindi, English, Commerce, Management, Sociology, Education, Computer Science, Law) × 100 PYQ MCQs = 1,200 Questions",
                "Official NTA Marking Scheme (+2.0 Marks, 0 Negative Marking)",
                "Detailed Unit-wise & Subject-wise JRF Cut-off & Percentile Analytics"
            )
        ),

        // Teaching Eligibility Test (CTET, UPTET, UTET & Others) Paid Test Series
        StudyItem(
            id = "tet_paid_test_series",
            title = "CTET, UPTET & UTET (Paper 1 & Paper 2) Complete PYQ Pro Test Series",
            hindiTitle = "सीटेट (CTET), यूपीटेट (UPTET) व यूटेट (UTET) पेपर 1 एवं 2 संपूर्ण PYQ प्रो टेस्ट सीरीज़",
            seriesName = "Shakuntalam Teaching Eligibility Master Series",
            categoryId = "teaching",
            subSectionId = "tet_central_state",
            subjectId = "tet_cdp",
            type = ContentType.TEST_SERIES,
            medium = "Bilingual (Hindi + English)",
            originalPrice = 699,
            discountedPrice = 249,
            rating = 4.97f,
            reviewCount = 4620,
            edition = "2025 CBSE CTET & State TET Pattern",
            totalPagesOrTests = "30 Full Mocks + 700 Subject PYQs",
            isBestseller = true,
            isTrending = true,
            hasSample = true,
            accentColorHex = 0xFF00695CL,
            description = "Complete Teaching Eligibility Test Series for सीटेट (CTET), यूपीटेट (UPTET), यूटेट व अन्य (UTET, REET, HTET, MPTET) covering Paper 1 (Primary) & Paper 2 (Upper Primary/Junior) with 7 Subject-wise 100-MCQ PYQ Banks (CDP, EVS, Maths, Science, Social Science, Hindi, English/Sanskrit).",
            features = listOf(
                "7 Core Subjects × 100 PYQ MCQs = 700 Bilingual Questions (CDP, EVS, Maths, Science, Social Science, Hindi, English/Sanskrit)",
                "30 Full-Length 150-Mark Paper 1 & Paper 2 Mock Tests for CTET, UPTET & UTET",
                "Official TET Marking Scheme (+1.0 Mark per correct answer, 0.0 Negative Marking)",
                "NCF-2005, NEP-2020 & NCERT Class 3–8 Chapter-Referenced Bilingual Solutions"
            )
        )
    )

    // Interactive Mock Test for UPSC / General Competition
    val sampleMockTest = MockTest(
        testId = "upsc_mock_test_01",
        title = "UPSC CSE Prelims General Studies (Paper-I) All India Open Mock",
        hindiTitle = "यूपीएससी सीएसई प्रारंभिक सामान्य अध्ययन (पेपर-1) ओपन मॉक टेस्ट",
        examName = "UPSC Civil Services Examination",
        durationMinutes = 20, // 20 mins for interactive demo test
        totalMarks = 20,
        positiveMarks = 2.0,
        negativeMarks = 0.66,
        questions = listOf(
            TestQuestion(
                id = 1,
                questionEn = "Consider the following statements regarding the Revolt of 1857:\n1. The revolt began at Meerut on May 10, 1857.\n2. General Bakht Khan led the military forces in Delhi on behalf of Bahadur Shah Zafar.\n3. The revolt was completely suppressed by the British within three months.\nWhich of the statements given above is/are correct?",
                questionHi = "1857 के विद्रोह के संदर्भ में निम्नलिखित कथनों पर विचार कीजिए:\n1. यह विद्रोह 10 मई 1857 को मेरठ से प्रारंभ हुआ।\n2. जनरल बख्त खान ने बहादुर शाह ज़फ़र की ओर से दिल्ली में सैन्य कमान संभाली।\n3. यह विद्रोह अंग्रेजों द्वारा तीन महीने के भीतर पूरी तरह दबा दिया गया था।\nउपर्युक्त कथनों में से कौन-सा/से सही है/हैं?",
                optionsEn = listOf("1 and 2 only", "2 and 3 only", "1 only", "1, 2 and 3"),
                optionsHi = listOf("केवल 1 और 2", "केवल 2 और 3", "केवल 1", "1, 2 और 3"),
                correctIndex = 0,
                explanationEn = "Statements 1 and 2 are correct. The rebellion was triggered at Meerut on May 10, 1857. In Delhi, real military authority lay with a court of soldiers headed by General Bakht Khan. Statement 3 is incorrect as the revolt continued fiercely into late 1858 and early 1859 across northern and central India.",
                explanationHi = "कथन 1 और 2 सही हैं। 10 मई 1857 को मेरठ के सिपाहियों ने बगावत का बिगुल फूंका। दिल्ली में वास्तविक सैन्य नेतृत्व जनरल बख्त खान के हाथों में था। कथन 3 गलत है क्योंकि विद्रोह को दबाने में अंग्रेजों को एक वर्ष से अधिक का समय लगा।",
                subject = "Modern Indian History"
            ),
            TestQuestion(
                id = 2,
                questionEn = "With reference to the Preamble to the Constitution of India, which of the following terms was NOT added by the 42nd Constitutional Amendment Act, 1976?",
                questionHi = "भारतीय संविधान की प्रस्तावना के संदर्भ में, 42वें संविधान संशोधन अधिनियम, 1976 द्वारा निम्नलिखित में से कौन-सा शब्द नहीं जोड़ा गया था?",
                optionsEn = listOf("Socialist", "Secular", "Integrity", "Republic"),
                optionsHi = listOf("समाजवादी (Socialist)", "पंथनिरपेक्ष (Secular)", "अखंडता (Integrity)", "गणराज्य (Republic)"),
                correctIndex = 3,
                explanationEn = "'Republic' was already part of the original 1950 Constitution. The 42nd Amendment Act of 1976 added three specific words to the Preamble: 'Socialist', 'Secular', and 'Integrity'.",
                explanationHi = "'गणराज्य' (Republic) मूल संविधान (1950) का ही हिस्सा था। 42वें संशोधन द्वारा केवल 'समाजवादी', 'पंथनिरपेक्ष' और 'अखंडता' शब्दों को शामिल किया गया था।",
                subject = "Indian Polity"
            ),
            TestQuestion(
                id = 3,
                questionEn = "Which of the following Article of the Indian Constitution is termed as the 'Heart and Soul of the Constitution' by Dr. B. R. Ambedkar?",
                questionHi = "डॉ. बी. आर. अम्बेडकर ने भारतीय संविधान के किस अनुच्छेद को 'संविधान का हृदय और आत्मा' कहा था?",
                optionsEn = listOf("Article 14", "Article 19", "Article 21", "Article 32"),
                optionsHi = listOf("अनुच्छेद 14", "अनुच्छेद 19", "अनुच्छेद 21", "अनुच्छेद 32"),
                correctIndex = 3,
                explanationEn = "Dr. B.R. Ambedkar termed Article 32 (Right to Constitutional Remedies) as the 'Heart and Soul of the Constitution' because it empowers citizens to directly approach the Supreme Court for enforcement of fundamental rights through writs.",
                explanationHi = "डॉ. अम्बेडकर ने अनुच्छेद 32 (संवैधानिक उपचारों का अधिकार) को 'संविधान का हृदय और आत्मा' कहा, क्योंकि यह मौलिक अधिकारों के उल्लंघन पर सीधे उच्चतम न्यायालय द्वारा रिट जारी कराने की गारंटी देता है।",
                subject = "Indian Polity"
            ),
            TestQuestion(
                id = 4,
                questionEn = "Which of the following states was the first to accept the Subsidiary Alliance system introduced by Lord Wellesley?",
                questionHi = "लॉर्ड वेलेजली द्वारा शुरू की गई सहायक संधि (Subsidiary Alliance) को स्वीकार करने वाला पहला राज्य कौन-सा था?",
                optionsEn = listOf("Hyderabad", "Mysore", "Awadh", "Marathas"),
                optionsHi = listOf("हैदराबाद", "मैसूर", "अवध", "मराठा"),
                correctIndex = 0,
                explanationEn = "The Nizam of Hyderabad was the first Indian ruler to accept the Subsidiary Alliance in 1798. Mysore accepted it in 1799 after the Fourth Anglo-Mysore War, followed by Tanjore (1799) and Awadh (1801).",
                explanationHi = "1798 ई. में हैदराबाद के निजाम ने सबसे पहले वेलेजली की सहायक संधि को स्वीकार किया था। इसके बाद मैसूर (1799), तंजौर (1799) और अवध (1801) ने इसे स्वीकार किया।",
                subject = "Modern Indian History"
            ),
            TestQuestion(
                id = 5,
                questionEn = "Which of the following Ancient Mahajanapadas was NOT situated in the geographical territory of modern-day Uttar Pradesh?",
                questionHi = "निम्नलिखित में से कौन-सा प्राचीन महाजनपद वर्तमान उत्तर प्रदेश के भौगोलिक क्षेत्र में स्थित नहीं था?",
                optionsEn = listOf("Vatsa", "Kosala", "Magadha", "Surasena"),
                optionsHi = listOf("वत्स", "कोसल", "मगध", "शूरसेन"),
                correctIndex = 2,
                explanationEn = "Magadha was located in modern-day Bihar (around Patna and Gaya, capital Rajgriha/Pataliputra). Vatsa (Kaushambi), Kosala (Ayodhya/Shravasti), and Surasena (Mathura) were all located in modern Uttar Pradesh.",
                explanationHi = "मगध महाजनपद आधुनिक बिहार (पटना व गया क्षेत्र) में स्थित था। जबकि वत्स (कौशाम्बी), कोसल (अयोध्या) तथा शूरसेन (मथुरा) उत्तर प्रदेश में स्थित थे।",
                subject = "UP Special & Ancient History"
            ),
            TestQuestion(
                id = 6,
                questionEn = "Under NIELIT CCC syllabus, which of the following is the default spreadsheet application in LibreOffice?",
                questionHi = "नाइलिट सीसीसी पाठ्यक्रम के अंतर्गत, लिब्रेऑफिस में डिफॉल्ट स्प्रेडशीट एप्लिकेशन कौन-सा है?",
                optionsEn = listOf("LibreOffice Writer", "LibreOffice Calc", "LibreOffice Impress", "LibreOffice Base"),
                optionsHi = listOf("लिब्रेऑफिस राइटर", "लिब्रेऑफिस कैल्क (Calc)", "लिब्रेऑफिस इम्प्रेस", "लिब्रेऑफिस बेस"),
                correctIndex = 1,
                explanationEn = "LibreOffice Calc is the free and open-source spreadsheet component. Writer is the word processor, Impress is for presentations, and Base is the database manager.",
                explanationHi = "लिब्रेऑफिस कैल्क (Calc) स्प्रेडशीट सॉफ्टवेयर है। राइटर वर्ड प्रोसेसिंग के लिए तथा इम्प्रेस प्रेजेंटेशन के लिए उपयोग किया जाता है।",
                subject = "Computer Awareness (CCC)"
            ),
            TestQuestion(
                id = 7,
                questionEn = "In Quantitative Aptitude for SSC/Banking, if the selling price of 16 articles is equal to the cost price of 20 articles, what is the profit percentage?",
                questionHi = "एसएससी/बैंकिंग गणित: यदि 16 वस्तुओं का विक्रय मूल्य 20 वस्तुओं के क्रय मूल्य के बराबर है, तो लाभ प्रतिशत क्या होगा?",
                optionsEn = listOf("20%", "25%", "15%", "30%"),
                optionsHi = listOf("20%", "25%", "15%", "30%"),
                correctIndex = 1,
                explanationEn = "16 * SP = 20 * CP => SP / CP = 20 / 16 = 5 / 4. Profit = SP - CP = 5 - 4 = 1. Profit Percentage = (Profit / CP) * 100 = (1 / 4) * 100 = 25%.",
                explanationHi = "16 * SP = 20 * CP => SP / CP = 5 / 4. लाभ = 5 - 4 = 1. लाभ % = (1 / 4) * 100 = 25%.",
                subject = "Quantitative Aptitude"
            ),
            TestQuestion(
                id = 8,
                questionEn = "According to Jean Piaget's theory of cognitive development, the stage where a child begins to develop logical thinking about concrete objects and conservation is:",
                questionHi = "जीन पियाजे के संज्ञानात्मक विकास सिद्धांत के अनुसार, वह अवस्था जिसमें बच्चा मूर्त वस्तुओं के बारे में तार्किक चिंतन एवं संरक्षण (Conservation) प्रारंभ करता है, कहलाती है:",
                optionsEn = listOf("Sensorimotor Stage", "Pre-operational Stage", "Concrete Operational Stage", "Formal Operational Stage"),
                optionsHi = listOf("संवेदी-गामक अवस्था", "पूर्व-संक्रियात्मक अवस्था", "मूर्त संक्रियात्मक अवस्था (7 से 11 वर्ष)", "औपचारिक संक्रियात्मक अवस्था"),
                correctIndex = 2,
                explanationEn = "The Concrete Operational Stage (roughly 7 to 11 years) is characterized by the emergence of logical thought regarding concrete events, classification, and the understanding of conservation (quantity remains identical despite changes in shape).",
                explanationHi = "मूर्त संक्रियात्मक अवस्था (7-11 वर्ष) में बच्चा संरक्षण (Conservation), प्रतिवर्तीयता (Reversibility) तथा मूर्त वस्तुओं पर तार्किक चिंतन करना प्रारंभ कर देता है।",
                subject = "Child Development & Pedagogy (CTET)"
            ),
            TestQuestion(
                id = 9,
                questionEn = "Which of the following cellular organelles is known as the 'Powerhouse of the Cell' due to ATP generation through aerobic respiration?",
                questionHi = "वायवीय श्वसन के माध्यम से एटीपी (ATP) उत्पादन के कारण किस कोशिकांग को 'कोशिका का ऊर्जाघर' (Powerhouse of the Cell) कहा जाता है?",
                optionsEn = listOf("Ribosome", "Golgi Apparatus", "Mitochondria", "Lysosome"),
                optionsHi = listOf("राइबोसोम", "गॉल्जी काय", "माइटोकॉन्ड्रिया", "लाइसोसोम"),
                correctIndex = 2,
                explanationEn = "Mitochondria are the sites of cellular respiration and oxidative phosphorylation, converting ADP to ATP, hence called the powerhouses of the eukaryotic cell.",
                explanationHi = "माइटोकॉन्ड्रिया में कोशिकीय श्वसन व क्रेब्स चक्र के द्वारा एटीपी (ATP) के रूप में ऊर्जा मुक्त होती है, इसलिए इसे कोशिका का पावरहाउस कहते हैं।",
                subject = "General Science & NEET Biology"
            ),
            TestQuestion(
                id = 10,
                questionEn = "In Machine Learning and Artificial Intelligence, 'Supervised Learning' differs from 'Unsupervised Learning' primarily because:",
                questionHi = "मशीन लर्निंग एवं एआई में, 'सुपरवाइज्ड लर्निंग' (Supervised Learning) मुख्य रूप से 'अनसुपरवाइज्ड लर्निंग' से किस आधार पर भिन्न है?",
                optionsEn = listOf(
                    "Supervised learning requires labeled training datasets with ground truth",
                    "Supervised learning does not use algorithms",
                    "Supervised learning only works on images",
                    "Unsupervised learning requires manual human feedback on every iteration"
                ),
                optionsHi = listOf(
                    "सुपरवाइज्ड लर्निंग में सही उत्तर (Ground Truth) युक्त लेबल्ड डेटा की आवश्यकता होती है",
                    "सुपरवाइज्ड लर्निंग एल्गोरिदम का उपयोग नहीं करती",
                    "सुपरवाइज्ड लर्निंग केवल छवियों पर काम करती है",
                    "अनसुपरवाइज्ड लर्निंग में हर चरण पर मानव प्रतिक्रिया जरूरी होती है"
                ),
                correctIndex = 0,
                explanationEn = "Supervised learning algorithms are trained on input-output pairs where data has ground truth labels (e.g., classification and regression). Unsupervised learning identifies hidden patterns or clustering in unlabeled datasets.",
                explanationHi = "सुपरवाइज्ड लर्निंग में मॉडल को इनपुट के साथ-साथ सही आउटपुट (लेबल्ड डेटा) दिया जाता है, जिससे वह पैटर्न सीखता है; जबकि अनसुपरवाइज्ड लर्निंग में डेटा अनलेबल्ड होता है।",
                subject = "AI & Machine Learning"
            )
        )
    )
}
