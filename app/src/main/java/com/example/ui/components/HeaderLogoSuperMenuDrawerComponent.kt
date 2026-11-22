package com.example.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AdminPanelSettings
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocalOffer
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.LockOpen
import androidx.compose.material.icons.filled.OndemandVideo
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.model.AppLanguage
import com.example.ui.theme.EmeraldSuccess
import com.example.ui.theme.Navy800
import com.example.ui.theme.Navy900
import com.example.ui.theme.SaffronGold
import com.example.viewmodel.AppScreen
import com.example.viewmodel.ShakuntalamUiState
import com.example.viewmodel.ShakuntalamViewModel

/**
 * Data model for Margdarshan (Counseling & Guidance) & Video Lectures.
 * Owner can upload, edit, delete, or change thumbnail/icon colors anytime.
 */
data class MargdarshanVideoLecture(
    val id: String,
    val titleEn: String,
    val titleHi: String,
    val categoryBadgeEn: String,
    val categoryBadgeHi: String,
    val durationText: String,
    val speakerName: String,
    val thumbnailBadgeText: String,
    val thumbnailColorHex: Long,
    val keyGuidancePointsEn: List<String>,
    val keyGuidancePointsHi: List<String>,
    val videoStreamNotesEn: String,
    val videoStreamNotesHi: String
)

/**
 * Data model for Special Offers & Discount Plans editable by the Owner.
 */
data class SpecialOfferItem(
    val id: String,
    val badgeText: String,
    val titleEn: String,
    val titleHi: String,
    val descriptionEn: String,
    val descriptionHi: String,
    val couponCode: String,
    val discountedPriceInr: Int,
    val originalPriceInr: Int,
    val planType: String // "MONTHLY_9", "YEARLY_99", "LIFETIME_399", "FREE_VAULT"
)

/**
 * Reactive Singleton State for the Shakuntalam Header Logo Super Menu Drawer,
 * Contact Information, Margdarshan Video Lectures, Offers, and Strict Owner-Only Lock Gate.
 */
object HeaderLogoSuperMenuState {
    const val AUTHORIZED_OWNER_EMAIL = "thebharat99999@gmail.com"
    const val AUTHORIZED_OWNER_PHONE = "6396817525"
    var authorizedOwnerPin by mutableStateOf("2525")

    var isDrawerOpen by mutableStateOf(false)
    var selectedSection by mutableStateOf("HOME_OVERVIEW")

    // Strict Owner Lock Gate:
    // MUST remain locked (false) for all students. Only unlocks when Owner verifies with
    // thebharat99999@gmail.com or 6396817525 + Owner Master PIN (2525).
    var isOwnerUnlocked by mutableStateOf(false)
    var ownerLockStatusMessage by mutableStateOf("")

    // Editable Contact Information (Defaulted to thebharat99999@gmail.com & 6396817525)
    var contactEmail by mutableStateOf("thebharat99999@gmail.com")
    var contactPhone by mutableStateOf("6396817525")
    var contactWhatsApp by mutableStateOf("6396817525")
    var contactOrganizationEn by mutableStateOf("Shakuntalam EdTech & Publications (All-India Exam Portal)")
    var contactOrganizationHi by mutableStateOf("शकुंतलम एडटेक एवं पब्लिकेशन्स (अखिल भारतीय परीक्षा पोर्टल)")
    var contactSupportHoursEn by mutableStateOf("24×7 Student Counseling & Technical Helpline")
    var contactSupportHoursHi by mutableStateOf("24×7 छात्र मार्गदर्शन एवं तकनीकी सहायता हेल्पलाइन")

    // Editable Subscription & Offer Prices
    var monthlyPassPriceInr by mutableStateOf(9)
    var yearlyPassPriceInr by mutableStateOf(99)
    var lifetimePassPriceInr by mutableStateOf(399)

    // Pre-loaded Margdarshan (Counseling) & Video Lectures
    val margdarshanVideoLectures = mutableStateListOf(
        MargdarshanVideoLecture(
            id = "vid_app_usage_guide",
            titleEn = "1. How to Use Shakuntalam App: Complete Tour (Paid 50-Test Series, Free Quizzes & E-Books)",
            titleHi = "1. शकुंतलम एप्लीकेशन को कैसे यूज़ करें: संपूर्ण मार्गदर्शन (पेड 50-टेस्ट, फ्री क्विज़ और ई-बुक्स)",
            categoryBadgeEn = "APP USAGE GUIDE",
            categoryBadgeHi = "ऐप उपयोग गाइड",
            durationText = "18:45 Mins",
            speakerName = "Chief Academic Counselor • Shakuntalam",
            thumbnailBadgeText = "APP GUIDE",
            thumbnailColorHex = 0xFF1E40AF,
            keyGuidancePointsEn = listOf(
                "How to switch between 1. Paid Test Series (50 Tests per Exam) and 2. Free Test Series + Free PDF Notes.",
                "How to use Dual-Language (English + Hindi) line-by-line statement rendering & Math/DI Charts during live CBT mock tests.",
                "How to download E-Books & Mock Tests in the dedicated E-Books Vault for 100% Offline reading without internet.",
                "How to unlock All-India Super Pass (₹9/Month, ₹99/Year, ₹399/Lifetime) via UPI or Google Pay."
            ),
            keyGuidancePointsHi = listOf(
                "1. पेड टेस्ट सीरीज़ (प्रत्येक परीक्षा में 50 टेस्ट: 20 फुल लेंथ + 20 सेक्शनल + 10 PYQ) और 2. फ्री टेस्ट व नोट्स का उपयोग कैसे करें।",
                "टेस्ट देते समय हिंदी व इंग्लिश दोनों भाषाओं में कथन-आधारित प्रश्न (Statement Questions) और मैथ्स/DI चार्ट कैसे देखें।",
                "ई-बुक्स (E-Books) सेक्शन से PDF नोट्स डाउनलोड करके बिना इंटरनेट (Offline Mode) कैसे पढ़ें।",
                "₹9 मासिक, ₹99 वार्षिक या ₹399 लाइफटाइम पास से सभी 14 परीक्षाओं के 700+ टेस्ट कैसे अनलॉक करें।"
            ),
            videoStreamNotesEn = "Step-by-step live walkthrough of the Shakuntalam App header menu, 14 Exam Categories, CBT Timer, All-India Rank Leaderboard, and Offline E-Book Library.",
            videoStreamNotesHi = "इस वीडियो लेक्चर में शकुंतलम ऐप के सभी फीचर्स—हेडर मेनू, 14 परीक्षाएं, CBT टाइमर, ऑल-इंडिया रैंक और ऑफलाइन ई-बुक लाइब्रेरी को विस्तार से समझाया गया है।"
        ),
        MargdarshanVideoLecture(
            id = "vid_after_12th_science_stream",
            titleEn = "2. After 12th Science (PCM / PCB): Best Courses, Career Streams & Preparation Strategy",
            titleHi = "2. 12th (Science PCM/PCB) के बाद क्या करें? कौन सी स्ट्रीम व कोर्स सबसे बेहतर है और कैसे तैयारी करें",
            categoryBadgeEn = "AFTER 12TH COUNSELING",
            categoryBadgeHi = "12वीं के बाद मार्गदर्शन",
            durationText = "32:10 Mins",
            speakerName = "Er. & Dr. Career Mentorship Panel",
            thumbnailBadgeText = "12th SCIENCE",
            thumbnailColorHex = 0xFF047857,
            keyGuidancePointsEn = listOf(
                "After 12th PCM: IIT JEE (Main + Advanced), B.Tech CS/AI, NDA Defence Officer, B.Sc Honours, or Integrated M.Tech.",
                "After 12th PCB: NEET UG (MBBS/BDS/AYUSH), B.Sc Nursing, Biotechnology, Pharmacy, and Paramedical Sciences.",
                "Should you take a Drop Year for IIT JEE / NEET or prepare alongside graduation?",
                "How to balance NCERT line-by-line mastery with Shakuntalam's 50 Paid Mock Tests & 20 Subject Sectional Tests."
            ),
            keyGuidancePointsHi = listOf(
                "12वीं PCM के बाद: IIT JEE (Main + Advanced), B.Tech (CS/AI), NDA डिफेंस ऑफिसर, B.Sc या इंटीग्रेटेड कोर्स—किसमें सबसे अच्छा भविष्य है?",
                "12वीं PCB के बाद: NEET UG (MBBS/BDS/BAMS), B.Sc नर्सिंग, बायोटेक्नोलॉजी व फार्मेसी में सही कोर्स का चुनाव कैसे करें?",
                "क्या IIT/NEET के लिए ड्रॉप लेना सही है या ग्रेजुएशन के साथ सरकारी परीक्षाओं की तैयारी करें?",
                "NCERT की लाइन-बाय-लाइन तैयारी और शकुंतलम के 50 फुल/सेक्शनल टेस्ट से 99+ परसेंटाइल कैसे लाएं।"
            ),
            videoStreamNotesEn = "Complete career roadmap for 12th Science students comparing Engineering, Medical, Defence, Research, and Civil Services preparation right after school.",
            videoStreamNotesHi = "12वीं साइंस के छात्रों के लिए इंजीनियरिंग, मेडिकल, डिफेंस, रिसर्च और सिविल सेवा का संपूर्ण रोडमैप व सही कोर्स चुनने की काउंसलिंग।"
        ),
        MargdarshanVideoLecture(
            id = "vid_after_12th_arts_commerce_govt",
            titleEn = "3. After 12th Arts, Commerce & Any Stream: Top Courses & Govt Exam Roadmap (UPSC, PCS, SSC, Police)",
            titleHi = "3. 12th (Arts / Commerce / Any Stream) के बाद कौन सा कोर्स करें और सरकारी नौकरी (UPSC, PCS, SSC, UP Police) की तैयारी कैसे करें",
            categoryBadgeEn = "STREAM & CAREER ROADMAP",
            categoryBadgeHi = "करियर एवं स्ट्रीम रोडमैप",
            durationText = "28:30 Mins",
            speakerName = "Civil Services & State Exam Experts",
            thumbnailBadgeText = "12th ARTS/COMM",
            thumbnailColorHex = 0xFFB45309,
            keyGuidancePointsEn = listOf(
                "Best Graduation Courses for UPSC/State PCS aspirants: B.A. (Polity, History, Geography, Economics), B.Com, BBA, or B.A. LLB.",
                "Direct Govt Exams right after 12th: UP Police Constable (60,244+ posts), SSC CHSL, SSC MTS, RRB NTPC Under-Graduate, NDA.",
                "3-Year College Roadmap: Year 1 (NCERT Foundation), Year 2 (Standard Books + Optional Subject), Year 3 (50 Full & Sectional Mock Tests).",
                "How Commerce students can target Banking (IBPS PO/SBI PO), RBI Grade B, CA/CS, and UGC NET Commerce."
            ),
            keyGuidancePointsHi = listOf(
                "12वीं के बाद UPSC / State PCS के लिए सबसे बेहतरीन ग्रेजुएशन कोर्स: B.A. (राजव्यवस्था, इतिहास, भूगोल, अर्थशास्त्र), B.Com, BBA या B.A. LLB।",
                "12वीं पास करते ही सीधे सरकारी नौकरी के अवसर: UP पुलिस कांस्टेबल, SSC CHSL, रेलवे NTPC, UPSSSC PET और डिफेंस।",
                "कॉलेज के 3 वर्षों का टाइम-टेबल: पहले साल NCERT बेसिक्स, दूसरे साल एडवांस विषय और तीसरे साल 50 मॉक टेस्ट सीरीज़।",
                "कॉमर्स व आर्ट्स के छात्र बैंकिंग (IBPS/SBI PO), SSC CGL और UGC NET JRF की तैयारी कैसे शुरू करें।"
            ),
            videoStreamNotesEn = "Dedicated counseling lecture helping 12th pass students choose between B.A., B.Com, BBA, Law, and direct 12th-level Government Job preparations.",
            videoStreamNotesHi = "12वीं के बाद कौन सी डिग्री लें और पहले ही प्रयास में सरकारी नौकरी या सिविल सेवा परीक्षा कैसे क्रैक करें—विस्तृत काउंसलिंग लेक्चर।"
        ),
        MargdarshanVideoLecture(
            id = "vid_subject_selection_counseling",
            titleEn = "4. How to Choose the Right Subject Combination & Optional Subject (UPSC, PCS, UGC NET, CTET)",
            titleHi = "4. कौन सा सब्जेक्ट क्या रखना है? ग्रेजुएशन, UPSC/PCS ऑप्शनल, UGC NET और TET के लिए सही विषय का चुनाव",
            categoryBadgeEn = "SUBJECT COUNSELING",
            categoryBadgeHi = "विषय चयन मार्गदर्शन",
            durationText = "25:15 Mins",
            speakerName = "Prof. Academic Guidance Board",
            thumbnailBadgeText = "SUBJECT CHOICE",
            thumbnailColorHex = 0xFF6D28D9,
            keyGuidancePointsEn = listOf(
                "4 Golden Rules to pick your Subject: Interest, Overlap with General Studies, Availability of Bilingual Notes, and Scoring Trend.",
                "Best Subject Choice for UGC NET Paper-2 (12 Subjects including History, Political Science, Geography, Hindi, Commerce, Computer Science).",
                "CTET / UPTET / UTET Subject Selection: Paper-1 (CDP, EVS, Maths, Languages) vs Paper-2 (Maths & Science vs Social Studies).",
                "How to test your subject strength using Shakuntalam's 20 Subject-Wise Sectional Tests before finalizing your stream."
            ),
            keyGuidancePointsHi = listOf(
                "सही विषय (Subject) चुनने के 4 नियम: आपकी रुचि, सामान्य अध्ययन (GS) में योगदान, हिंदी/इंग्लिश नोट्स की उपलब्धता और स्कोरिंग ट्रेंड।",
                "UGC NET Paper-2 और PG के लिए 12 प्रमुख विषयों (इतिहास, राजनीति विज्ञान, भूगोल, हिंदी, कॉमर्स आदि) में से अपना विषय कैसे चुनें।",
                "CTET / UPTET में भाषा-1, भाषा-2 और Paper-2 (गणित-विज्ञान बनाम सामाजिक अध्ययन) का सही चुनाव कैसे करें।",
                "शकुंतलम के 20 सेक्शनल टेस्ट देकर कैसे पहचानें कि आपका कौन सा सब्जेक्ट सबसे मजबूत है।"
            ),
            videoStreamNotesEn = "Scientific framework to eliminate confusion in choosing graduation subjects, optional papers, and teaching exam specializations.",
            videoStreamNotesHi = "विषय चुनने की उलझन को दूर करने के लिए वैज्ञानिक पद्धति—जानें किस परीक्षा के लिए कौन सा सब्जेक्ट सबसे ज्यादा स्कोरिंग है।"
        ),
        MargdarshanVideoLecture(
            id = "vid_up_police_upsssc_ssc_strategy",
            titleEn = "5. UP Police Constable, UPSSSC, SSC CGL & Railways: 90-Day Sure-Shot Selection Blueprint",
            titleHi = "5. UP पुलिस कांस्टेबल, UPSSSC, SSC CGL व रेलवे: 90 दिनों में पक्का सिलेक्शन पाने की सटीक रणनीति",
            categoryBadgeEn = "EXAM STRATEGY",
            categoryBadgeHi = "सिलेक्शन रणनीति",
            durationText = "29:50 Mins",
            speakerName = "Selected Officers & Toppers Panel",
            thumbnailBadgeText = "UP POLICE & SSC",
            thumbnailColorHex = 0xFFBE123C,
            keyGuidancePointsEn = listOf(
                "UP Police Constable (150 Qs, 300 Marks): How to score 240+ marks by mastering Mental Aptitude, Reasoning (38 Qs), Hindi (37 Qs), and UP GK.",
                "UPSSSC PET & Junior Assistant: Deep-dive into 20-Mark Data Interpretation Tables/Graphs and Uttar Pradesh Special GK.",
                "SSC CGL & RRB NTPC: Speed + Accuracy techniques to solve Quantitative Aptitude & Reasoning within time limit.",
                "How to analyze your mistakes after every Full-Length Mock Test using the Bilingual Explanation & Performance Analytics tab."
            ),
            keyGuidancePointsHi = listOf(
                "UP पुलिस कांस्टेबल (150 प्रश्न, 300 अंक): रीजनिंग (38 प्रश्न), सामान्य हिंदी (37 प्रश्न) और UP GK के दम पर 240+ अंक कैसे लाएं।",
                "UPSSSC PET व मुख्य परीक्षा: ग्राफ एवं तालिका (DI) और उत्तर प्रदेश विशेष सामान्य ज्ञान में 100% स्कोर करने का तरीका।",
                "SSC CGL एवं रेलवे NTPC: कम समय में मैथ्स और रीजनिंग के प्रश्न हल करने की शॉर्ट-ट्रिक और टाइम मैनेजमेंट।",
                "प्रत्येक फुल-लेंथ टेस्ट के बाद अपनी गलतियों का विश्लेषण (Error Analysis) कैसे करें।"
            ),
            videoStreamNotesEn = "Actionable 90-day daily routine and subject-wise weightage analysis for UP Police, UPSSSC, SSC, and Railway aspirants.",
            videoStreamNotesHi = "यूपी पुलिस, UPSSSC, SSC और रेलवे परीक्षाओं में 90 दिन के अंदर मेरिट लिस्ट में नाम लाने की व्यावहारिक कार्ययोजना।"
        ),
        MargdarshanVideoLecture(
            id = "vid_daily_timetable_stress_counseling",
            titleEn = "6. Student Mentorship: Daily Time-Table, Revision Cycle & Overcoming Exam Fear",
            titleHi = "6. छात्र मार्गदर्शन एवं काउंसलिंग: पढ़ाई का आदर्श टाइम-टेबल, रिवीजन तकनीक और तनाव मुक्त तैयारी",
            categoryBadgeEn = "MENTORSHIP & MINDSET",
            categoryBadgeHi = "काउंसलिंग व टाइम-टेबल",
            durationText = "22:00 Mins",
            speakerName = "Shakuntalam Student Welfare Cell",
            thumbnailBadgeText = "COUNSELING",
            thumbnailColorHex = 0xFF0F766E,
            keyGuidancePointsEn = listOf(
                "The 4-3-2 Daily Study Formula: 4 Hours New Concepts + 3 Hours Revision & E-Book Notes + 2 Hours Mock Test & PYQ Analysis.",
                "How to build an unbroken Daily Quiz Streak on Shakuntalam App and retain facts for 6+ months.",
                "How to overcome mock test low-score anxiety and steadily boost your All-India Percentile.",
                "Direct Doubt & Counseling Helpline: Reach out anytime at thebharat99999@gmail.com or 6396817525."
            ),
            keyGuidancePointsHi = listOf(
                "पढ़ाई का 4-3-2 फॉर्मूला: 4 घंटे नया अध्याय + 3 घंटे ई-बुक नोट्स रिवीजन + 2 घंटे मॉक टेस्ट और PYQ विश्लेषण।",
                "पढ़ा हुआ लंबे समय तक याद रखने के लिए साप्ताहिक रिवीजन और डेली क्विज़ स्ट्रीक (Daily Streak) का महत्व।",
                "मॉक टेस्ट में कम नंबर आने के डर को कैसे दूर करें और धीरे-धीरे अपनी ऑल-इंडिया रैंक कैसे सुधारें।",
                "व्यक्तिगत काउंसलिंग के लिए सीधे संपर्क करें: ईमेल thebharat99999@gmail.com या फोन 6396817525।"
            ),
            videoStreamNotesEn = "Holistic student counseling session designed to keep aspirants disciplined, confident, and stress-free throughout their exam journey.",
            videoStreamNotesHi = "छात्रों को अनुशासित, आत्मविश्वासी और तनाव-मुक्त रखने के लिए विशेष मार्गदर्शन सत्र।"
        )
    )

    // Pre-loaded Special Offers & Coupons (Editable by Owner)
    val specialOffers = mutableStateListOf(
        SpecialOfferItem(
            id = "offer_monthly_9",
            badgeText = "TRENDING TRIAL OFFER • 95% OFF",
            titleEn = "Monthly All-Exam Super Pass — Just ₹9 / Month",
            titleHi = "मासिक ऑल-एग्जाम सुपर पास — मात्र ₹9 / महीना",
            descriptionEn = "Unlock all 14 Exam Categories, 700+ Paid Tests (20 Full + 20 Sectional + 10 PYQ per exam) & All E-Books for 30 Days.",
            descriptionHi = "सभी 14 परीक्षाओं के 700+ पेड टेस्ट (प्रत्येक में 50 टेस्ट) और सभी प्रीमियम ई-बुक्स 30 दिनों के लिए अनलॉक करें।",
            couponCode = "SHAKUNTALAM9",
            discountedPriceInr = 9,
            originalPriceInr = 199,
            planType = "MONTHLY_9"
        ),
        SpecialOfferItem(
            id = "offer_yearly_99",
            badgeText = "BESTSELLER STUDENT PASS • 90% OFF",
            titleEn = "Yearly All-Access Super Pass — Just ₹99 / Year (365 Days)",
            titleHi = "वार्षिक ऑल-एक्सेस सुपर पास — मात्र ₹99 / वर्ष (365 दिन)",
            descriptionEn = "Complete 1-Year unlimited access to UPSC, PCS, UGC NET, IIT JEE, NEET, UP Police, UPSSSC, SSC, Banking, Railways & TET.",
            descriptionHi = "पूरे 1 वर्ष (365 दिन) के लिए UPSC, PCS, UGC NET, IIT JEE, NEET, UP पुलिस, UPSSSC, SSC, बैंकिंग व TET के सभी टेस्ट व ई-बुक्स।",
            couponCode = "SUPER99",
            discountedPriceInr = 99,
            originalPriceInr = 999,
            planType = "YEARLY_99"
        ),
        SpecialOfferItem(
            id = "offer_lifetime_399",
            badgeText = "ULTIMATE SELECTION PASS • LIFETIME",
            titleEn = "Lifetime All-India Master Pass — ₹399 One-Time",
            titleHi = "लाइफटाइम ऑल-इंडिया मास्टर पास — ₹399 (एक बार भुगतान, आजीवन वैधता)",
            descriptionEn = "Pay once and get Lifetime validity for all current & future Test Series, E-Books, and Margdarshan Video Lectures till selection.",
            descriptionHi = "एक बार ₹399 का भुगतान करें और सिलेक्शन होने तक आजीवन सभी टेस्ट सीरीज़, ई-बुक्स और मार्गदर्शन वीडियो लेक्चर्स पाएं।",
            couponCode = "LIFETIME399",
            discountedPriceInr = 399,
            originalPriceInr = 2499,
            planType = "LIFETIME_399"
        )
    )

    fun openDrawerToSection(section: String = "HOME_OVERVIEW") {
        selectedSection = section
        isDrawerOpen = true
    }

    /**
     * Strict Owner Verification:
     * Only unlocks when the input email matches `thebharat99999@gmail.com` (or phone `6396817525`)
     * AND the Owner security PIN matches `authorizedOwnerPin` (default `2525`).
     * Any student email/phone or wrong PIN is strictly rejected and kept locked.
     */
    fun verifyAndUnlockOwnerSection(
        identityInput: String,
        pinInput: String,
        isHi: Boolean = false
    ): Boolean {
        val cleanIdentity = identityInput.trim().lowercase()
        val cleanDigits = identityInput.filter { it.isDigit() }
        val cleanPin = pinInput.trim()

        val isAuthorizedOwnerIdentity =
            cleanIdentity == AUTHORIZED_OWNER_EMAIL.lowercase() ||
                cleanDigits == AUTHORIZED_OWNER_PHONE ||
                (cleanDigits.endsWith(AUTHORIZED_OWNER_PHONE) && cleanDigits.length in 10..12)

        val isPinValid = cleanPin == authorizedOwnerPin

        return if (isAuthorizedOwnerIdentity && isPinValid) {
            isOwnerUnlocked = true
            ownerLockStatusMessage = if (isHi) {
                "✓ ओनर सत्यापन सफल ($AUTHORIZED_OWNER_EMAIL / $AUTHORIZED_OWNER_PHONE) — पूर्ण एडिटिंग स्टूडियो अनलॉक!"
            } else {
                "✓ Owner Verified ($AUTHORIZED_OWNER_EMAIL / $AUTHORIZED_OWNER_PHONE) — Full Editing Studio Unlocked!"
            }
            true
        } else {
            isOwnerUnlocked = false
            ownerLockStatusMessage = if (isHi) {
                "🔒 एक्सेस अस्वीकृत! यह सेक्शन स्टूडेंट्स के लिए सख्त लॉक है। केवल अधिकृत ऐप ओनर (thebharat99999@gmail.com / 6396817525 + ओनर पिन) ही इसे खोल सकते हैं।"
            } else {
                "🔒 ACCESS DENIED! This section is strictly locked for students. Only the verified App Owner (thebharat99999@gmail.com / 6396817525 + Owner PIN) can unlock it."
            }
            false
        }
    }

    fun lockOwnerSection() {
        isOwnerUnlocked = false
        ownerLockStatusMessage = ""
    }

    fun updateContactDetails(
        newEmail: String,
        newPhone: String,
        newWhatsApp: String,
        newOrgEn: String,
        newOrgHi: String,
        newHoursEn: String,
        newHoursHi: String
    ) {
        if (newEmail.isNotBlank()) contactEmail = newEmail.trim()
        if (newPhone.isNotBlank()) contactPhone = newPhone.trim()
        if (newWhatsApp.isNotBlank()) contactWhatsApp = newWhatsApp.trim()
        if (newOrgEn.isNotBlank()) contactOrganizationEn = newOrgEn.trim()
        if (newOrgHi.isNotBlank()) contactOrganizationHi = newOrgHi.trim()
        if (newHoursEn.isNotBlank()) contactSupportHoursEn = newHoursEn.trim()
        if (newHoursHi.isNotBlank()) contactSupportHoursHi = newHoursHi.trim()
    }

    fun addOrUpdateVideoLecture(lecture: MargdarshanVideoLecture) {
        val index = margdarshanVideoLectures.indexOfFirst { it.id == lecture.id }
        if (index >= 0) {
            margdarshanVideoLectures[index] = lecture
        } else {
            margdarshanVideoLectures.add(0, lecture)
        }
    }

    fun deleteVideoLecture(lectureId: String) {
        margdarshanVideoLectures.removeAll { it.id == lectureId }
    }

    fun updateSubscriptionPrices(monthlyInr: Int, yearlyInr: Int, lifetimeInr: Int) {
        monthlyPassPriceInr = monthlyInr.coerceAtLeast(1)
        yearlyPassPriceInr = yearlyInr.coerceAtLeast(1)
        lifetimePassPriceInr = lifetimeInr.coerceAtLeast(1)
        // Also update matching offers
        specialOffers.replaceAll { offer ->
            when (offer.planType) {
                "MONTHLY_9" -> offer.copy(
                    discountedPriceInr = monthlyPassPriceInr,
                    titleEn = "Monthly All-Exam Super Pass — Just ₹$monthlyPassPriceInr / Month",
                    titleHi = "मासिक ऑल-एग्जाम सुपर पास — मात्र ₹$monthlyPassPriceInr / महीना"
                )
                "YEARLY_99" -> offer.copy(
                    discountedPriceInr = yearlyPassPriceInr,
                    titleEn = "Yearly All-Access Super Pass — Just ₹$yearlyPassPriceInr / Year (365 Days)",
                    titleHi = "वार्षिक ऑल-एक्सेस सुपर पास — मात्र ₹$yearlyPassPriceInr / वर्ष (365 दिन)"
                )
                "LIFETIME_399" -> offer.copy(
                    discountedPriceInr = lifetimePassPriceInr,
                    titleEn = "Lifetime All-India Master Pass — ₹$lifetimePassPriceInr One-Time",
                    titleHi = "लाइफटाइम ऑल-इंडिया मास्टर पास — ₹$lifetimePassPriceInr (एक बार भुगतान, आजीवन वैधता)"
                )
                else -> offer
            }
        }
    }

    fun addOrUpdateSpecialOffer(offer: SpecialOfferItem) {
        val idx = specialOffers.indexOfFirst { it.id == offer.id }
        if (idx >= 0) {
            specialOffers[idx] = offer
        } else {
            specialOffers.add(0, offer)
        }
    }

    fun deleteSpecialOffer(offerId: String) {
        specialOffers.removeAll { it.id == offerId }
    }
}

private data class SuperMenuSectionTab(
    val id: String,
    val titleEn: String,
    val titleHi: String,
    val subtitleEn: String,
    val subtitleHi: String,
    val icon: ImageVector,
    val badgeText: String? = null,
    val isLockedForStudents: Boolean = false
)

/**
 * Testbook-Style Side Navigation Drawer & Super Menu Modal that opens when clicking
 * the main Shakuntalam Logo/Icon in the Header.
 */
@Composable
fun ShakuntalamHeaderLogoSuperMenuModal(
    uiState: ShakuntalamUiState,
    viewModel: ShakuntalamViewModel,
    onDismiss: () -> Unit
) {
    val isHi = uiState.selectedLanguage == AppLanguage.HINDI
    val selectedSection = HeaderLogoSuperMenuState.selectedSection
    var activeVideoLectureForPlayer by remember { mutableStateOf<MargdarshanVideoLecture?>(null) }
    var showAddOrEditVideoModal by remember { mutableStateOf(false) }
    var lectureBeingEdited by remember { mutableStateOf<MargdarshanVideoLecture?>(null) }

    val menuSections = remember(HeaderLogoSuperMenuState.isOwnerUnlocked) {
        listOf(
            SuperMenuSectionTab(
                id = "HOME_OVERVIEW",
                titleEn = "Home & All Sections",
                titleHi = "होम एवं सभी सेक्शन",
                subtitleEn = "Quick jump across the entire application",
                subtitleHi = "पूरे एप्लीकेशन के सभी सेक्शंस एक जगह",
                icon = Icons.Default.Home,
                badgeText = "SUPER MENU"
            ),
            SuperMenuSectionTab(
                id = "TEST_SERIES",
                titleEn = "Test Series (Paid 50 & Free)",
                titleHi = "टेस्ट सीरीज़ (पेड 50 व फ्री)",
                subtitleEn = "20 Full + 20 Sectional + 10 PYQ in all 14 Exams",
                subtitleHi = "सभी 14 परीक्षाओं में 50-50 परीक्षा-स्तरीय टेस्ट",
                icon = Icons.Default.Quiz,
                badgeText = "700+ TESTS"
            ),
            SuperMenuSectionTab(
                id = "EBOOKS_VAULT",
                titleEn = "E-Books & Offline PDFs",
                titleHi = "ई-बुक्स एवं डाउनलोड्स",
                subtitleEn = "Dedicated E-Books & Downloaded Vault",
                subtitleHi = "ई-बुक्स और ऑफलाइन PDF नोट्स सेक्शन",
                icon = Icons.AutoMirrored.Filled.MenuBook,
                badgeText = "PDF VAULT"
            ),
            SuperMenuSectionTab(
                id = "SUBSCRIPTION",
                titleEn = "Subscription Plans",
                titleHi = "सब्सक्रिप्शन प्लान्स",
                subtitleEn = "₹${HeaderLogoSuperMenuState.monthlyPassPriceInr}/Mo • ₹${HeaderLogoSuperMenuState.yearlyPassPriceInr}/Yr • ₹${HeaderLogoSuperMenuState.lifetimePassPriceInr}/Life",
                subtitleHi = "₹${HeaderLogoSuperMenuState.monthlyPassPriceInr}/माह • ₹${HeaderLogoSuperMenuState.yearlyPassPriceInr}/वर्ष • ₹${HeaderLogoSuperMenuState.lifetimePassPriceInr}/आजीवन",
                icon = Icons.Default.AccountBalanceWallet,
                badgeText = "₹${HeaderLogoSuperMenuState.monthlyPassPriceInr} PASS"
            ),
            SuperMenuSectionTab(
                id = "MARGDARSHAN_VIDEOS",
                titleEn = "Margdarshan & Video Lectures",
                titleHi = "मार्गदर्शन एवं वीडियो लेक्चर",
                subtitleEn = "App Usage, After 12th Stream/Course & Subject Guidance",
                subtitleHi = "ऐप उपयोग, 12th के बाद कोर्स/स्ट्रीम एवं विषय काउंसलिंग",
                icon = Icons.Default.OndemandVideo,
                badgeText = "${HeaderLogoSuperMenuState.margdarshanVideoLectures.size} VIDEOS"
            ),
            SuperMenuSectionTab(
                id = "OFFERS",
                titleEn = "Special Offers & Coupons",
                titleHi = "ऑफर्स एवं डिस्काउंट",
                subtitleEn = "Active scholarships, coupons & combo passes",
                subtitleHi = "छात्रवृत्ति ऑफर्स, कूपन कोड और कॉम्बो पास",
                icon = Icons.Default.LocalOffer,
                badgeText = "95% OFF"
            ),
            SuperMenuSectionTab(
                id = "CONTACT_INFO",
                titleEn = "Contact Information",
                titleHi = "कांटेक्ट इनफॉरमेशन (संपर्क)",
                subtitleEn = "${HeaderLogoSuperMenuState.contactEmail} • ${HeaderLogoSuperMenuState.contactPhone}",
                subtitleHi = "${HeaderLogoSuperMenuState.contactEmail} • ${HeaderLogoSuperMenuState.contactPhone}",
                icon = Icons.Default.Call
            ),
            SuperMenuSectionTab(
                id = "ABOUT_SECTION",
                titleEn = "About Shakuntalam",
                titleHi = "अबाउट सेक्शन (हमारे बारे में)",
                subtitleEn = "Mission, Pedagogy, Exam Coverage & Authenticity",
                subtitleHi = "शकुंतलम का उद्देश्य, परीक्षा कवरेज एवं विशेषताएं",
                icon = Icons.Default.Info
            ),
            SuperMenuSectionTab(
                id = "OWNER_SECTION",
                titleEn = "Owner Section (Admin Studio)",
                titleHi = "ओनर सेक्शन (एडमिन स्टूडियो)",
                subtitleEn = if (HeaderLogoSuperMenuState.isOwnerUnlocked) {
                    "Unlocked for Owner • Edit/Upload/Delete Anything"
                } else {
                    "🔒 Strictly Locked for Students • Owner Access Only"
                },
                subtitleHi = if (HeaderLogoSuperMenuState.isOwnerUnlocked) {
                    "ओनर के लिए अनलॉक • टेस्ट, ई-बुक, कीमत व वीडियो एडिट करें"
                } else {
                    "🔒 स्टूडेंट्स के लिए लॉक है • केवल ऐप ओनर के लिए"
                },
                icon = if (HeaderLogoSuperMenuState.isOwnerUnlocked) Icons.Default.LockOpen else Icons.Default.Lock,
                badgeText = if (HeaderLogoSuperMenuState.isOwnerUnlocked) "UNLOCKED" else "LOCKED 🔒",
                isLockedForStudents = !HeaderLogoSuperMenuState.isOwnerUnlocked
            )
        )
    }

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .testTag("header_logo_super_menu_modal"),
            color = Color(0xFFF8FAFC)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                // Top Brand Header inside the Super Menu
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = Navy900,
                    shadowElevation = 6.dp
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .statusBarsPadding()
                            .padding(horizontal = 14.dp, vertical = 12.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Box(
                                    modifier = Modifier
                                        .size(42.dp)
                                        .clip(RoundedCornerShape(10.dp))
                                        .background(SaffronGold),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "श",
                                        fontSize = 23.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = Navy900
                                    )
                                }
                                Spacer(modifier = Modifier.width(10.dp))
                                Column {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Text(
                                            text = if (isHi) "शकुंतलम सुपर नेविगेशन हब" else "SHAKUNTALAM SUPER MENU",
                                            fontSize = 14.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            color = Color.White
                                        )
                                        Spacer(modifier = Modifier.width(6.dp))
                                        Box(
                                            modifier = Modifier
                                                .clip(RoundedCornerShape(4.dp))
                                                .background(SaffronGold)
                                                .padding(horizontal = 6.dp, vertical = 2.dp)
                                        ) {
                                            Text(
                                                text = "ALL-IN-ONE",
                                                fontSize = 9.sp,
                                                fontWeight = FontWeight.ExtraBold,
                                                color = Navy900
                                            )
                                        }
                                    }
                                    Text(
                                        text = if (isHi) {
                                            "टेस्ट सीरीज़ • सब्सक्रिप्शन • मार्गदर्शन वीडियो • ऑफर्स • संपर्क • ओनर सेक्शन"
                                        } else {
                                            "Test Series • Subscription • Margdarshan Videos • Offers • Contact • Owner Studio"
                                        },
                                        fontSize = 10.5.sp,
                                        color = Color(0xFFCBD5E1),
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }
                            }

                            IconButton(
                                onClick = onDismiss,
                                modifier = Modifier
                                    .size(36.dp)
                                    .clip(CircleShape)
                                    .background(Navy800)
                                    .testTag("close_super_menu_btn")
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Close,
                                    contentDescription = "Close Menu",
                                    tint = Color.White,
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        // Horizontal Scrollable Section Pills (Testbook-style fast section switcher)
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .horizontalScroll(rememberScrollState()),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            menuSections.forEach { tab ->
                                val isSelected = selectedSection == tab.id
                                val pillBg = when {
                                    isSelected -> SaffronGold
                                    tab.id == "OWNER_SECTION" -> Color(0xFF334155)
                                    else -> Navy800
                                }
                                val pillText = if (isSelected) Navy900 else Color.White
                                Row(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(20.dp))
                                        .background(pillBg)
                                        .border(
                                            width = 1.dp,
                                            color = if (isSelected) Color.White else Color(0xFF475569),
                                            shape = RoundedCornerShape(20.dp)
                                        )
                                        .clickable {
                                            HeaderLogoSuperMenuState.selectedSection = tab.id
                                        }
                                        .padding(horizontal = 12.dp, vertical = 7.dp)
                                        .testTag("super_menu_tab_${tab.id.lowercase()}"),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        imageVector = tab.icon,
                                        contentDescription = null,
                                        tint = if (isSelected) Navy900 else SaffronGold,
                                        modifier = Modifier.size(15.dp)
                                    )
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text(
                                        text = if (isHi) tab.titleHi else tab.titleEn,
                                        fontSize = 11.5.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = pillText
                                    )
                                }
                            }
                        }
                    }
                }

                // Main Content Body for the Selected Drawer Section
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 14.dp, vertical = 12.dp),
                    contentPadding = PaddingValues(bottom = 36.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    // SECTION 1: HOME & ALL SECTIONS DIRECTORY (Testbook-style Side Drawer Grid)
                    if (selectedSection == "HOME_OVERVIEW") {
                        item {
                            Card(
                                modifier = Modifier.fillMaxWidth(),
                                shape = RoundedCornerShape(14.dp),
                                colors = CardDefaults.cardColors(containerColor = Navy900)
                            ) {
                                Column(modifier = Modifier.padding(14.dp)) {
                                    Text(
                                        text = if (isHi) {
                                            "शकुंतलम मेन लोगो मेनू — किसी भी सेक्शन पर सीधे जाएं"
                                        } else {
                                            "Shakuntalam Brand Logo Drawer — Jump to Any Section"
                                        },
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = SaffronGold
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = if (isHi) {
                                            "हेडर में मुख्य शकुंतलम आइकन पर क्लिक करने पर आप यहाँ से टेस्ट सीरीज़, सब्सक्रिप्शन, ऑफर्स, मार्गदर्शन वीडियो लेक्चर, संपर्क जानकारी, अबाउट और ओनर सेक्शन खोल सकते हैं।"
                                        } else {
                                            "Access Test Series, Subscriptions, Offers, Margdarshan Video Lectures, Contact Information, About, and the Owner Section directly from here."
                                        },
                                        fontSize = 11.5.sp,
                                        color = Color(0xFFE2E8F0),
                                        lineHeight = 16.sp
                                    )
                                }
                            }
                        }

                        items(menuSections.filter { it.id != "HOME_OVERVIEW" }) { section ->
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        HeaderLogoSuperMenuState.selectedSection = section.id
                                    }
                                    .testTag("drawer_card_${section.id.lowercase()}"),
                                shape = RoundedCornerShape(12.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = if (section.id == "OWNER_SECTION") Color(0xFFFEF2F2) else Color.White
                                ),
                                border = androidx.compose.foundation.BorderStroke(
                                    1.dp,
                                    if (section.id == "OWNER_SECTION") Color(0xFFFCA5A5) else Color(0xFFE2E8F0)
                                )
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(14.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Row(
                                        modifier = Modifier.weight(1f),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .size(42.dp)
                                                .clip(RoundedCornerShape(10.dp))
                                                .background(
                                                    if (section.id == "OWNER_SECTION") Color(0xFF991B1B) else Navy900
                                                ),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Icon(
                                                imageVector = section.icon,
                                                contentDescription = null,
                                                tint = SaffronGold,
                                                modifier = Modifier.size(22.dp)
                                            )
                                        }
                                        Spacer(modifier = Modifier.width(12.dp))
                                        Column {
                                            Row(verticalAlignment = Alignment.CenterVertically) {
                                                Text(
                                                    text = if (isHi) section.titleHi else section.titleEn,
                                                    fontSize = 13.5.sp,
                                                    fontWeight = FontWeight.ExtraBold,
                                                    color = Navy900
                                                )
                                                section.badgeText?.let { badge ->
                                                    Spacer(modifier = Modifier.width(6.dp))
                                                    Box(
                                                        modifier = Modifier
                                                            .clip(RoundedCornerShape(4.dp))
                                                            .background(
                                                                if (section.isLockedForStudents) Color(0xFFDC2626) else SaffronGold
                                                            )
                                                            .padding(horizontal = 6.dp, vertical = 2.dp)
                                                    ) {
                                                        Text(
                                                            text = badge,
                                                            fontSize = 9.sp,
                                                            fontWeight = FontWeight.ExtraBold,
                                                            color = if (section.isLockedForStudents) Color.White else Navy900
                                                        )
                                                    }
                                                }
                                            }
                                            Spacer(modifier = Modifier.height(2.dp))
                                            Text(
                                                text = if (isHi) section.subtitleHi else section.subtitleEn,
                                                fontSize = 11.5.sp,
                                                color = Color(0xFF475569)
                                            )
                                        }
                                    }

                                    Text(
                                        text = if (isHi) "खोलें →" else "Open →",
                                        fontSize = 11.5.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = if (section.id == "OWNER_SECTION") Color(0xFF991B1B) else Navy900
                                    )
                                }
                            }
                        }

                        // Quick Go-To Home Screen Button
                        item {
                            Button(
                                onClick = {
                                    onDismiss()
                                    viewModel.navigateTo(AppScreen.HOME)
                                },
                                modifier = Modifier.fillMaxWidth().height(46.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = Navy900),
                                shape = RoundedCornerShape(10.dp)
                            ) {
                                Icon(Icons.Default.Home, contentDescription = null, tint = SaffronGold)
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = if (isHi) "मुख्य होम डैशबोर्ड पर जाएं" else "Go to Main Home Dashboard",
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            }
                        }
                    }

                    // SECTION 2: TEST SERIES (Paid 50-Test Packages & Free Quizzes across 14 Exams)
                    if (selectedSection == "TEST_SERIES") {
                        item {
                            Card(
                                modifier = Modifier.fillMaxWidth(),
                                shape = RoundedCornerShape(14.dp),
                                colors = CardDefaults.cardColors(containerColor = Navy900)
                            ) {
                                Column(modifier = Modifier.padding(14.dp)) {
                                    Text(
                                        text = if (isHi) {
                                            "ऑल-इंडिया टेस्ट सीरीज़ हब (प्रत्येक परीक्षा में 50 पेड टेस्ट + फ्री सेक्शन)"
                                        } else {
                                            "All-India Test Series Hub (50 Paid Tests + Free Quizzes in Every Exam)"
                                        },
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = SaffronGold
                                    )
                                    Spacer(modifier = Modifier.height(6.dp))
                                    Text(
                                        text = if (isHi) {
                                            "• 20 फुल लेंथ टेस्ट (Full-Length Exam-Oriented Tests)\n• 20 सेक्शनल टेस्ट (Subject-Wise Sectional Tests)\n• 10 पिछले वर्षों के पेपर (Last Previous Year Papers)\n• परीक्षाएं: UPSC, UPPCS, UKPSC, BPSC, UP पुलिस कांस्टेबल, UPSSSC, UKSSSC, UGC NET, IIT JEE, NEET, SSC, बैंकिंग, रेलवे एवं CTET/TET।"
                                        } else {
                                            "• 20 Full-Length Exam-Oriented Mock Tests\n• 20 Subject-Wise Sectional Tests\n• 10 Last Previous Year Question Papers (PYQs)\n• Exams Covered: UPSC, UPPCS, UKPSC, BPSC, UP Police Constable, UPSSSC, UKSSSC, UGC NET, IIT JEE, NEET, SSC, Banking, Railways & CTET/TET."
                                        },
                                        fontSize = 11.5.sp,
                                        color = Color.White,
                                        lineHeight = 17.sp
                                    )
                                    Spacer(modifier = Modifier.height(10.dp))
                                    Button(
                                        onClick = {
                                            onDismiss()
                                            viewModel.navigateTo(AppScreen.TEST_SERIES)
                                        },
                                        colors = ButtonDefaults.buttonColors(containerColor = SaffronGold),
                                        shape = RoundedCornerShape(8.dp),
                                        modifier = Modifier.fillMaxWidth().testTag("super_menu_open_test_series_btn")
                                    ) {
                                        Icon(Icons.Default.Quiz, contentDescription = null, tint = Navy900)
                                        Spacer(modifier = Modifier.width(6.dp))
                                        Text(
                                            text = if (isHi) "संपूर्ण टेस्ट सीरीज़ पोर्टल खोलें (700+ टेस्ट)" else "Open Complete Test Series Portal (700+ Tests)",
                                            fontWeight = FontWeight.ExtraBold,
                                            color = Navy900
                                        )
                                    }
                                }
                            }
                        }

                        // Quick Exam Jump Cards
                        val examQuickList = listOf(
                            Triple("upsc", "UPSC Civil Services (IAS/IPS)", "50 Paid Tests (100 Qs) + Free NCERT Quizzes"),
                            Triple("up_police", "UP Police Constable & SI (यूपी पुलिस)", "50 Paid Tests (150 Qs, 300 Marks) + Free Quizzes"),
                            Triple("uppcs", "UPPCS Upper Subordinate", "50 Paid Tests (150 Qs) + UP Special GK"),
                            Triple("upsssc", "UPSSSC PET, Lekhpal & Junior Assistant", "50 Paid Tests (100 Qs) + DI & UP GK"),
                            Triple("ugc_net", "UGC NET / JRF Paper-1 & Paper-2", "50 Paid Tests (50/100 Qs) + 10 Units & 12 Subjects"),
                            Triple("ssc", "SSC CGL, CHSL, CPO & MTS", "50 Paid Tests (100 Qs) + Speed Quizzes"),
                            Triple("iit_jee", "IIT JEE (Main + Advanced)", "50 Paid Tests (75/54 Qs) + Physics, Chem, Maths"),
                            Triple("neet", "NEET UG Medical (Physics, Chem, Biology)", "50 Paid Tests (180 Qs, 720 Marks)"),
                            Triple("tet", "CTET, UPTET & State TET", "50 Paid Tests (150 Qs) + CDP, EVS, Pedagogy"),
                            Triple("banking", "IBPS PO, SBI PO & RBI Grade B", "50 Paid Tests (100 Qs) + Puzzle & DI Charts"),
                            Triple("railways", "RRB NTPC, Group D & ALP", "50 Paid Tests (100 Qs) + Science & GA")
                        )

                        items(examQuickList) { (examKey, examTitle, examDesc) ->
                            Card(
                                modifier = Modifier.fillMaxWidth(),
                                shape = RoundedCornerShape(10.dp),
                                colors = CardDefaults.cardColors(containerColor = Color.White),
                                border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFFE2E8F0))
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth().padding(12.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Column(modifier = Modifier.weight(1f)) {
                                        Text(
                                            text = examTitle,
                                            fontSize = 13.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Navy900
                                        )
                                        Text(
                                            text = examDesc,
                                            fontSize = 11.sp,
                                            color = Color(0xFF475569)
                                        )
                                    }
                                    Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                                        OutlinedButton(
                                            onClick = {
                                                viewModel.selectExamTestSeriesMode(examKey, "FREE")
                                                onDismiss()
                                                viewModel.navigateTo(AppScreen.TEST_SERIES)
                                            },
                                            modifier = Modifier.height(32.dp),
                                            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 0.dp)
                                        ) {
                                            Text(if (isHi) "फ्री टेस्ट" else "Free", fontSize = 10.5.sp, fontWeight = FontWeight.Bold)
                                        }
                                        Button(
                                            onClick = {
                                                viewModel.selectExamTestSeriesMode(examKey, "PAID")
                                                onDismiss()
                                                viewModel.navigateTo(AppScreen.TEST_SERIES)
                                            },
                                            colors = ButtonDefaults.buttonColors(containerColor = Navy900),
                                            modifier = Modifier.height(32.dp),
                                            contentPadding = PaddingValues(horizontal = 10.dp, vertical = 0.dp)
                                        ) {
                                            Text(if (isHi) "50 पेड टेस्ट" else "50 Paid", fontSize = 10.5.sp, fontWeight = FontWeight.Bold, color = SaffronGold)
                                        }
                                    }
                                }
                            }
                        }
                    }

                    // SECTION 3: E-BOOKS & DOWNLOADED VAULT
                    if (selectedSection == "EBOOKS_VAULT") {
                        item {
                            DedicatedEbooksAndDownloadedVaultSection(
                                uiState = uiState,
                                isHi = isHi,
                                onReadEbook = { item ->
                                    onDismiss()
                                    viewModel.openReader(item)
                                },
                                onDownloadEbookOffline = { item ->
                                    viewModel.cacheStudyItemForOffline(item)
                                },
                                onOpenFullEbookLibraryTab = {
                                    onDismiss()
                                    viewModel.navigateTo(AppScreen.LIBRARY)
                                }
                            )
                        }
                    }

                    // SECTION 4: SUBSCRIPTION PLANS (₹9 Monthly, ₹99 Yearly, ₹399 Lifetime)
                    if (selectedSection == "SUBSCRIPTION") {
                        item {
                            Card(
                                modifier = Modifier.fillMaxWidth(),
                                shape = RoundedCornerShape(14.dp),
                                colors = CardDefaults.cardColors(containerColor = Navy900)
                            ) {
                                Column(modifier = Modifier.padding(16.dp)) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text(
                                            text = if (isHi) "शकुंतलम ऑल-एक्सेस सब्सक्रिप्शन पास" else "SHAKUNTALAM ALL-ACCESS SUBSCRIPTION",
                                            fontSize = 14.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            color = SaffronGold
                                        )
                                        Box(
                                            modifier = Modifier
                                                .clip(RoundedCornerShape(6.dp))
                                                .background(
                                                    if (uiState.isAllAccessSubscriptionValid()) EmeraldSuccess else SaffronGold
                                                )
                                                .padding(horizontal = 8.dp, vertical = 3.dp)
                                        ) {
                                            Text(
                                                text = if (uiState.isAllAccessSubscriptionValid()) {
                                                    if (isHi) "सक्रिय (ACTIVE)" else "ACTIVE PASS"
                                                } else {
                                                    if (isHi) "चुनें (UNLOCK)" else "CHOOSE PLAN"
                                                },
                                                fontSize = 9.5.sp,
                                                fontWeight = FontWeight.ExtraBold,
                                                color = if (uiState.isAllAccessSubscriptionValid()) Color.White else Navy900
                                            )
                                        }
                                    }
                                    Spacer(modifier = Modifier.height(6.dp))
                                    Text(
                                        text = if (isHi) {
                                            "एक ही सब्सक्रिप्शन से सभी 14 परीक्षाओं के 700+ पेड टेस्ट (20 फुल लेंथ + 20 सेक्शनल + 10 PYQ), सभी ई-बुक्स और मार्गदर्शन वीडियो लेक्चर्स अनलॉक करें।"
                                        } else {
                                            "One Subscription unlocks all 14 Exam Categories, 700+ Paid Mock Tests (20 Full + 20 Sectional + 10 PYQ per exam), all E-Books, and Margdarshan Video Lectures."
                                        },
                                        fontSize = 11.5.sp,
                                        color = Color(0xFFE2E8F0)
                                    )
                                }
                            }
                        }

                        // Plan 1: Monthly ₹9
                        item {
                            SubscriptionPlanCardItem(
                                badge = "MONTHLY TRIAL PASS",
                                title = if (isHi) "1-महीना सुपर पास (30 दिन)" else "1-Month Super Pass (30 Days)",
                                priceInr = HeaderLogoSuperMenuState.monthlyPassPriceInr,
                                mrpInr = 199,
                                features = if (isHi) {
                                    listOf(
                                        "30 दिनों के लिए सभी 14 परीक्षाओं के 50-50 पेड टेस्ट अनलॉक",
                                        "सभी शकुंतलम ई-बुक्स और PDF नोट्स ऑफलाइन डाउनलोड",
                                        "ऑल-इंडिया रैंक, पर्सेंटाइल और विस्तृत द्विभाषी समाधान"
                                    )
                                } else {
                                    listOf(
                                        "Unlocks all 50 Paid Tests across 14 Exams for 30 Days",
                                        "Full access to all E-Books & Offline PDF Reader",
                                        "All-India Rank, Percentile & Bilingual Explanations"
                                    )
                                },
                                buttonLabel = if (isHi) "₹${HeaderLogoSuperMenuState.monthlyPassPriceInr}/माह में अनलॉक करें" else "Subscribe Monthly @ ₹${HeaderLogoSuperMenuState.monthlyPassPriceInr}",
                                testTag = "super_menu_sub_monthly_btn",
                                onSelect = {
                                    viewModel.openPaymentGateway(
                                        amount = HeaderLogoSuperMenuState.monthlyPassPriceInr,
                                        title = "Shakuntalam 1-Month All-Access Pass (30 Days)"
                                    )
                                    onDismiss()
                                }
                            )
                        }

                        // Plan 2: Yearly ₹99
                        item {
                            SubscriptionPlanCardItem(
                                badge = "MOST POPULAR • 365 DAYS",
                                title = if (isHi) "1-वर्ष ऑल-एक्सेस पास (365 दिन)" else "1-Year All-Access Pass (365 Days)",
                                priceInr = HeaderLogoSuperMenuState.yearlyPassPriceInr,
                                mrpInr = 999,
                                features = if (isHi) {
                                    listOf(
                                        "पूरे 365 दिनों के लिए सभी 700+ पेड टेस्ट और ई-बुक्स अनलॉक",
                                        "UPSC, PCS, UP पुलिस, UPSSSC, UGC NET, SSC, IIT, NEET, TET सब शामिल",
                                        "सभी मार्गदर्शन एवं काउंसलिंग वीडियो लेक्चर्स की असीमित एक्सेस"
                                    )
                                } else {
                                    listOf(
                                        "365 Days unlimited access to 700+ Paid Tests & All E-Books",
                                        "Covers UPSC, PCS, UP Police, UPSSSC, UGC NET, SSC, IIT, NEET, TET",
                                        "Includes all Margdarshan Counseling Video Lectures"
                                    )
                                },
                                buttonLabel = if (isHi) "₹${HeaderLogoSuperMenuState.yearlyPassPriceInr}/वर्ष में अनलॉक करें" else "Subscribe Yearly @ ₹${HeaderLogoSuperMenuState.yearlyPassPriceInr}",
                                testTag = "super_menu_sub_yearly_btn",
                                isHighlighted = true,
                                onSelect = {
                                    viewModel.openPaymentGateway(
                                        amount = HeaderLogoSuperMenuState.yearlyPassPriceInr,
                                        title = "Shakuntalam 1-Year All-Access Pass (365 Days)"
                                    )
                                    onDismiss()
                                }
                            )
                        }

                        // Plan 3: Lifetime ₹399
                        item {
                            SubscriptionPlanCardItem(
                                badge = "LIFETIME VALIDITY • TILL SELECTION",
                                title = if (isHi) "लाइफटाइम मास्टर पास (आजीवन वैधता)" else "Lifetime Master Pass (Valid Till Selection)",
                                priceInr = HeaderLogoSuperMenuState.lifetimePassPriceInr,
                                mrpInr = 2499,
                                features = if (isHi) {
                                    listOf(
                                        "एक बार भुगतान करें — सिलेक्शन होने तक आजीवन सभी टेस्ट व ई-बुक्स पाएं",
                                        "भविष्य में जुड़ने वाले सभी नए टेस्ट और नई ई-बुक्स बिल्कुल मुफ्त",
                                        "व्यक्तिगत मार्गदर्शन और करियर काउंसलिंग प्राथमिकता"
                                    )
                                } else {
                                    listOf(
                                        "One-time payment — Lifetime access until your final selection",
                                        "All future Test Series, PYQ updates & E-Books included free",
                                        "Priority 1-on-1 Career & Subject Selection Counseling"
                                    )
                                },
                                buttonLabel = if (isHi) "₹${HeaderLogoSuperMenuState.lifetimePassPriceInr} में लाइफटाइम पास लें" else "Unlock Lifetime Pass @ ₹${HeaderLogoSuperMenuState.lifetimePassPriceInr}",
                                testTag = "super_menu_sub_lifetime_btn",
                                onSelect = {
                                    viewModel.openPaymentGateway(
                                        amount = HeaderLogoSuperMenuState.lifetimePassPriceInr,
                                        title = "Shakuntalam Lifetime All-Access Master Pass"
                                    )
                                    onDismiss()
                                }
                            )
                        }
                    }

                    // SECTION 5: MARGDARSHAN & VIDEO LECTURES (Counseling, App Usage, After 12th Stream & Subject Guidance)
                    if (selectedSection == "MARGDARSHAN_VIDEOS") {
                        item {
                            Card(
                                modifier = Modifier.fillMaxWidth(),
                                shape = RoundedCornerShape(14.dp),
                                colors = CardDefaults.cardColors(containerColor = Navy900)
                            ) {
                                Column(modifier = Modifier.padding(15.dp)) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Row(verticalAlignment = Alignment.CenterVertically) {
                                            Icon(
                                                imageVector = Icons.Default.OndemandVideo,
                                                contentDescription = null,
                                                tint = SaffronGold,
                                                modifier = Modifier.size(22.dp)
                                            )
                                            Spacer(modifier = Modifier.width(8.dp))
                                            Text(
                                                text = if (isHi) "मार्गदर्शन एवं वीडियो लेक्चर (काउंसलिंग हब)" else "MARGDARSHAN & VIDEO LECTURES HUB",
                                                fontSize = 14.sp,
                                                fontWeight = FontWeight.ExtraBold,
                                                color = SaffronGold
                                            )
                                        }

                                        if (HeaderLogoSuperMenuState.isOwnerUnlocked) {
                                            Button(
                                                onClick = {
                                                    lectureBeingEdited = null
                                                    showAddOrEditVideoModal = true
                                                },
                                                colors = ButtonDefaults.buttonColors(containerColor = SaffronGold),
                                                shape = RoundedCornerShape(8.dp),
                                                modifier = Modifier.height(32.dp).testTag("owner_add_video_lecture_btn"),
                                                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 0.dp)
                                            ) {
                                                Icon(Icons.Default.Add, contentDescription = null, tint = Navy900, modifier = Modifier.size(14.dp))
                                                Spacer(modifier = Modifier.width(4.dp))
                                                Text(
                                                    text = if (isHi) "+ वीडियो जोड़ें" else "+ Add Video",
                                                    fontSize = 10.5.sp,
                                                    fontWeight = FontWeight.ExtraBold,
                                                    color = Navy900
                                                )
                                            }
                                        }
                                    }

                                    Spacer(modifier = Modifier.height(6.dp))
                                    Text(
                                        text = if (isHi) {
                                            "• एप्लीकेशन को कैसे यूज़ करना है (How to Use App)\n• कौन सा सब्जेक्ट क्या रखना है (Subject Selection Counseling)\n• 12th के बाद स्टूडेंट्स के लिए कौन सी स्ट्रीम और कौन सा कोर्स करना ज्यादा अच्छा है\n• किस स्ट्रीम की कैसे तैयारी करनी है — संपूर्ण मार्गदर्शन लेक्चर्स।"
                                        } else {
                                            "• How to use the application effectively\n• Which subject combination or optional to choose\n• Best stream & course options after 12th (Science, Arts, Commerce)\n• Step-by-step preparation strategy for every stream."
                                        },
                                        fontSize = 11.5.sp,
                                        color = Color(0xFFE2E8F0),
                                        lineHeight = 17.sp
                                    )
                                }
                            }
                        }

                        items(HeaderLogoSuperMenuState.margdarshanVideoLectures) { lecture ->
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .testTag("margdarshan_video_card_${lecture.id}"),
                                shape = RoundedCornerShape(14.dp),
                                colors = CardDefaults.cardColors(containerColor = Color.White),
                                border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFFE2E8F0)),
                                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                            ) {
                                Column(modifier = Modifier.padding(14.dp)) {
                                    // Video Thumbnail Banner with Dynamic Badge & Play Icon
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(110.dp)
                                            .clip(RoundedCornerShape(10.dp))
                                            .background(
                                                Brush.horizontalGradient(
                                                    colors = listOf(
                                                        Color(lecture.thumbnailColorHex),
                                                        Navy900
                                                    )
                                                )
                                            )
                                            .clickable { activeVideoLectureForPlayer = lecture }
                                            .padding(12.dp)
                                    ) {
                                        Column(
                                            modifier = Modifier.fillMaxSize(),
                                            verticalArrangement = Arrangement.SpaceBetween
                                        ) {
                                            Row(
                                                modifier = Modifier.fillMaxWidth(),
                                                horizontalArrangement = Arrangement.SpaceBetween,
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Box(
                                                    modifier = Modifier
                                                        .clip(RoundedCornerShape(5.dp))
                                                        .background(SaffronGold)
                                                        .padding(horizontal = 8.dp, vertical = 3.dp)
                                                ) {
                                                    Text(
                                                        text = if (isHi) lecture.categoryBadgeHi else lecture.categoryBadgeEn,
                                                        fontSize = 9.5.sp,
                                                        fontWeight = FontWeight.ExtraBold,
                                                        color = Navy900
                                                    )
                                                }
                                                Box(
                                                    modifier = Modifier
                                                        .clip(RoundedCornerShape(5.dp))
                                                        .background(Color.Black.copy(alpha = 0.45f))
                                                        .padding(horizontal = 8.dp, vertical = 3.dp)
                                                ) {
                                                    Text(
                                                        text = "${lecture.thumbnailBadgeText} • ${lecture.durationText}",
                                                        fontSize = 9.5.sp,
                                                        fontWeight = FontWeight.Bold,
                                                        color = Color.White
                                                    )
                                                }
                                            }

                                            Row(
                                                modifier = Modifier.fillMaxWidth(),
                                                verticalAlignment = Alignment.CenterVertically,
                                                horizontalArrangement = Arrangement.SpaceBetween
                                            ) {
                                                Text(
                                                    text = lecture.speakerName,
                                                    fontSize = 11.sp,
                                                    fontWeight = FontWeight.SemiBold,
                                                    color = Color(0xFFE2E8F0)
                                                )
                                                Box(
                                                    modifier = Modifier
                                                        .size(38.dp)
                                                        .clip(CircleShape)
                                                        .background(SaffronGold),
                                                    contentAlignment = Alignment.Center
                                                ) {
                                                    Icon(
                                                        imageVector = Icons.Default.PlayArrow,
                                                        contentDescription = "Play Video Lecture",
                                                        tint = Navy900,
                                                        modifier = Modifier.size(24.dp)
                                                    )
                                                }
                                            }
                                        }
                                    }

                                    Spacer(modifier = Modifier.height(10.dp))

                                    Text(
                                        text = if (isHi) lecture.titleHi else lecture.titleEn,
                                        fontSize = 13.5.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = Navy900
                                    )

                                    Spacer(modifier = Modifier.height(8.dp))

                                    val points = if (isHi) lecture.keyGuidancePointsHi else lecture.keyGuidancePointsEn
                                    points.forEach { point ->
                                        Row(
                                            modifier = Modifier.padding(vertical = 2.dp),
                                            verticalAlignment = Alignment.Top
                                        ) {
                                            Text("• ", fontSize = 11.5.sp, fontWeight = FontWeight.ExtraBold, color = EmeraldSuccess)
                                            Text(
                                                text = point,
                                                fontSize = 11.5.sp,
                                                color = Color(0xFF334155),
                                                lineHeight = 16.sp
                                            )
                                        }
                                    }

                                    Spacer(modifier = Modifier.height(10.dp))

                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Button(
                                            onClick = { activeVideoLectureForPlayer = lecture },
                                            colors = ButtonDefaults.buttonColors(containerColor = Navy900),
                                            shape = RoundedCornerShape(8.dp),
                                            modifier = Modifier.weight(1f).height(38.dp).testTag("watch_lecture_btn_${lecture.id}")
                                        ) {
                                            Icon(Icons.Default.PlayArrow, contentDescription = null, tint = SaffronGold, modifier = Modifier.size(16.dp))
                                            Spacer(modifier = Modifier.width(6.dp))
                                            Text(
                                                text = if (isHi) "लेक्चर व मार्गदर्शन देखें" else "Watch Video & Guidance Notes",
                                                fontSize = 11.5.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Color.White
                                            )
                                        }

                                        // If Owner is unlocked, show Edit & Delete controls right on the lecture card
                                        if (HeaderLogoSuperMenuState.isOwnerUnlocked) {
                                            Spacer(modifier = Modifier.width(8.dp))
                                            IconButton(
                                                onClick = {
                                                    lectureBeingEdited = lecture
                                                    showAddOrEditVideoModal = true
                                                },
                                                modifier = Modifier.size(36.dp).testTag("edit_lecture_btn_${lecture.id}")
                                            ) {
                                                Icon(Icons.Default.Edit, contentDescription = "Edit Lecture", tint = Navy900)
                                            }
                                            IconButton(
                                                onClick = {
                                                    HeaderLogoSuperMenuState.deleteVideoLecture(lecture.id)
                                                },
                                                modifier = Modifier.size(36.dp).testTag("delete_lecture_btn_${lecture.id}")
                                            ) {
                                                Icon(Icons.Default.Delete, contentDescription = "Delete Lecture", tint = Color(0xFFDC2626))
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    // SECTION 6: OFFERS & COUPONS
                    if (selectedSection == "OFFERS") {
                        item {
                            Card(
                                modifier = Modifier.fillMaxWidth(),
                                shape = RoundedCornerShape(14.dp),
                                colors = CardDefaults.cardColors(containerColor = Navy900)
                            ) {
                                Column(modifier = Modifier.padding(15.dp)) {
                                    Text(
                                        text = if (isHi) "विशेष छात्र ऑफर्स एवं स्कॉलरशिप कूपन" else "SPECIAL STUDENT OFFERS & COUPONS",
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = SaffronGold
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = if (isHi) {
                                            "शकुंतलम पर सभी प्रतियोगी छात्रों के लिए किफायती दरों पर टेस्ट सीरीज़ और ई-बुक्स उपलब्ध हैं।"
                                        } else {
                                            "Affordable All-India Test Series and E-Book scholarship offers for every competitive exam aspirant."
                                        },
                                        fontSize = 11.5.sp,
                                        color = Color(0xFFE2E8F0)
                                    )
                                }
                            }
                        }

                        items(HeaderLogoSuperMenuState.specialOffers) { offer ->
                            Card(
                                modifier = Modifier.fillMaxWidth().testTag("offer_card_${offer.id}"),
                                shape = RoundedCornerShape(12.dp),
                                colors = CardDefaults.cardColors(containerColor = Color.White),
                                border = androidx.compose.foundation.BorderStroke(1.5.dp, SaffronGold)
                            ) {
                                Column(modifier = Modifier.padding(14.dp)) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .clip(RoundedCornerShape(5.dp))
                                                .background(Color(0xFFFEF3C7))
                                                .padding(horizontal = 8.dp, vertical = 3.dp)
                                        ) {
                                            Text(
                                                text = offer.badgeText,
                                                fontSize = 9.5.sp,
                                                fontWeight = FontWeight.ExtraBold,
                                                color = Color(0xFFB45309)
                                            )
                                        }
                                        Text(
                                            text = "CODE: ${offer.couponCode}",
                                            fontSize = 11.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            color = EmeraldSuccess
                                        )
                                    }
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Text(
                                        text = if (isHi) offer.titleHi else offer.titleEn,
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = Navy900
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = if (isHi) offer.descriptionHi else offer.descriptionEn,
                                        fontSize = 11.5.sp,
                                        color = Color(0xFF475569)
                                    )
                                    Spacer(modifier = Modifier.height(10.dp))
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Row(verticalAlignment = Alignment.CenterVertically) {
                                            Text(
                                                text = "₹${offer.discountedPriceInr}",
                                                fontSize = 18.sp,
                                                fontWeight = FontWeight.ExtraBold,
                                                color = EmeraldSuccess
                                            )
                                            Spacer(modifier = Modifier.width(8.dp))
                                            Text(
                                                text = "MRP ₹${offer.originalPriceInr}",
                                                fontSize = 11.5.sp,
                                                color = Color(0xFF94A3B8)
                                            )
                                        }
                                        Button(
                                            onClick = {
                                                viewModel.openPaymentGateway(
                                                    amount = offer.discountedPriceInr,
                                                    title = if (isHi) offer.titleHi else offer.titleEn
                                                )
                                                onDismiss()
                                            },
                                            colors = ButtonDefaults.buttonColors(containerColor = Navy900),
                                            shape = RoundedCornerShape(8.dp)
                                        ) {
                                            Text(
                                                text = if (isHi) "ऑफर का लाभ लें" else "Claim Offer",
                                                fontSize = 11.5.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = SaffronGold
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }

                    // SECTION 7: CONTACT INFORMATION (thebharat99999@gmail.com & 6396817525)
                    if (selectedSection == "CONTACT_INFO") {
                        item {
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .testTag("contact_info_section_card"),
                                shape = RoundedCornerShape(14.dp),
                                colors = CardDefaults.cardColors(containerColor = Color.White),
                                border = androidx.compose.foundation.BorderStroke(1.5.dp, Navy900)
                            ) {
                                Column(modifier = Modifier.padding(16.dp)) {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Box(
                                            modifier = Modifier
                                                .size(44.dp)
                                                .clip(RoundedCornerShape(10.dp))
                                                .background(Navy900),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Icon(
                                                imageVector = Icons.Default.Call,
                                                contentDescription = null,
                                                tint = SaffronGold,
                                                modifier = Modifier.size(24.dp)
                                            )
                                        }
                                        Spacer(modifier = Modifier.width(12.dp))
                                        Column {
                                            Text(
                                                text = if (isHi) "आधिकारिक संपर्क जानकारी (Contact Information)" else "Official Contact Information",
                                                fontSize = 15.sp,
                                                fontWeight = FontWeight.ExtraBold,
                                                color = Navy900
                                            )
                                            Text(
                                                text = if (isHi) HeaderLogoSuperMenuState.contactOrganizationHi else HeaderLogoSuperMenuState.contactOrganizationEn,
                                                fontSize = 11.5.sp,
                                                color = Color(0xFF475569)
                                            )
                                        }
                                    }

                                    Spacer(modifier = Modifier.height(14.dp))

                                    // Official Email ID Box: thebharat99999@gmail.com
                                    Card(
                                        modifier = Modifier.fillMaxWidth().testTag("contact_email_box"),
                                        shape = RoundedCornerShape(10.dp),
                                        colors = CardDefaults.cardColors(containerColor = Color(0xFFF1F5F9))
                                    ) {
                                        Row(
                                            modifier = Modifier.fillMaxWidth().padding(12.dp),
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Icon(
                                                imageVector = Icons.Default.Email,
                                                contentDescription = null,
                                                tint = Navy900,
                                                modifier = Modifier.size(22.dp)
                                            )
                                            Spacer(modifier = Modifier.width(10.dp))
                                            Column {
                                                Text(
                                                    text = if (isHi) "आधिकारिक ईमेल आईडी (Official Email ID)" else "Official Email ID",
                                                    fontSize = 11.sp,
                                                    color = Color(0xFF64748B),
                                                    fontWeight = FontWeight.SemiBold
                                                )
                                                Text(
                                                    text = HeaderLogoSuperMenuState.contactEmail,
                                                    fontSize = 14.5.sp,
                                                    fontWeight = FontWeight.ExtraBold,
                                                    color = Navy900
                                                )
                                            }
                                        }
                                    }

                                    Spacer(modifier = Modifier.height(10.dp))

                                    // Official Phone & WhatsApp Number Box: 6396817525
                                    Card(
                                        modifier = Modifier.fillMaxWidth().testTag("contact_phone_box"),
                                        shape = RoundedCornerShape(10.dp),
                                        colors = CardDefaults.cardColors(containerColor = Color(0xFFF0FDF4))
                                    ) {
                                        Row(
                                            modifier = Modifier.fillMaxWidth().padding(12.dp),
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Icon(
                                                imageVector = Icons.Default.Call,
                                                contentDescription = null,
                                                tint = EmeraldSuccess,
                                                modifier = Modifier.size(22.dp)
                                            )
                                            Spacer(modifier = Modifier.width(10.dp))
                                            Column {
                                                Text(
                                                    text = if (isHi) "हेल्पलाइन फोन एवं व्हाट्सएप नंबर (Phone & WhatsApp)" else "Helpline Phone & WhatsApp Number",
                                                    fontSize = 11.sp,
                                                    color = Color(0xFF166534),
                                                    fontWeight = FontWeight.SemiBold
                                                )
                                                Text(
                                                    text = HeaderLogoSuperMenuState.contactPhone,
                                                    fontSize = 15.sp,
                                                    fontWeight = FontWeight.ExtraBold,
                                                    color = Color(0xFF14532D)
                                                )
                                            }
                                        }
                                    }

                                    Spacer(modifier = Modifier.height(10.dp))

                                    Text(
                                        text = if (isHi) {
                                            "सहायता समय: ${HeaderLogoSuperMenuState.contactSupportHoursHi}\nटेस्ट सीरीज़, ई-बुक डाउनलोड, सब्सक्रिप्शन या करियर काउंसलिंग (मार्गदर्शन) से जुड़े किसी भी प्रश्न के लिए हमें ईमेल (${HeaderLogoSuperMenuState.contactEmail}) या फोन (${HeaderLogoSuperMenuState.contactPhone}) पर संपर्क करें।"
                                        } else {
                                            "Support Hours: ${HeaderLogoSuperMenuState.contactSupportHoursEn}\nFor any queries regarding Test Series, E-Book downloads, Subscriptions, or Career Counseling (Margdarshan), reach out directly at ${HeaderLogoSuperMenuState.contactEmail} or call/WhatsApp ${HeaderLogoSuperMenuState.contactPhone}."
                                        },
                                        fontSize = 11.5.sp,
                                        color = Color(0xFF334155),
                                        lineHeight = 16.sp
                                    )
                                }
                            }
                        }
                    }

                    // SECTION 8: ABOUT SECTION
                    if (selectedSection == "ABOUT_SECTION") {
                        item {
                            Card(
                                modifier = Modifier.fillMaxWidth().testTag("about_section_card"),
                                shape = RoundedCornerShape(14.dp),
                                colors = CardDefaults.cardColors(containerColor = Color.White),
                                border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFFE2E8F0))
                            ) {
                                Column(modifier = Modifier.padding(16.dp)) {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Box(
                                            modifier = Modifier
                                                .size(42.dp)
                                                .clip(RoundedCornerShape(10.dp))
                                                .background(Navy900),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text("श", fontSize = 22.sp, fontWeight = FontWeight.ExtraBold, color = SaffronGold)
                                        }
                                        Spacer(modifier = Modifier.width(12.dp))
                                        Column {
                                            Text(
                                                text = if (isHi) "शकुंतलम (Shakuntalam EdTech) के बारे में" else "About Shakuntalam EdTech & Publications",
                                                fontSize = 15.sp,
                                                fontWeight = FontWeight.ExtraBold,
                                                color = Navy900
                                            )
                                            Text(
                                                text = if (isHi) "भारत का आधुनिक द्विभाषी ई-बुक्स एवं टेस्ट सीरीज़ प्लेटफॉर्म" else "India's Premier Bilingual E-Books & Exam Test Series Ecosystem",
                                                fontSize = 11.5.sp,
                                                color = Color(0xFF475569)
                                            )
                                        }
                                    }

                                    Spacer(modifier = Modifier.height(12.dp))

                                    Text(
                                        text = if (isHi) {
                                            "1. परीक्षा-उन्मुख पेड टेस्ट सीरीज़ (50 टेस्ट प्रति परीक्षा): प्रत्येक परीक्षा (UPSC, UPPCS, UKPSC, BPSC, UP पुलिस कांस्टेबल, UPSSSC, UKSSSC, UGC NET, IIT JEE, NEET, SSC, बैंकिंग, रेलवे व TET) में 20 फुल-लेंथ टेस्ट + 20 विषयवार सेक्शनल टेस्ट + 10 पिछले वर्षों के पेपर (PYQ) आधिकारिक प्रश्न संख्या और कठिनाई स्तर के अनुसार उपलब्ध हैं।\n\n" +
                                                "2. समर्पित ई-बुक्स एवं ऑफलाइन वॉल्ट: सभी अध्ययन सामग्री और ब्रांडेड नोट्स हिंदी और अंग्रेजी दोनों माध्यमों में इन-ऐप रीडर और ऑफलाइन एक्सेस के साथ उपलब्ध हैं।\n\n" +
                                                "3. मार्गदर्शन एवं काउंसलिंग वीडियो लेक्चर्स: 12वीं के बाद सही स्ट्रीम/कोर्स चुनने, विषय चयन और परीक्षा रणनीति के लिए विशेषज्ञ मार्गदर्शन।\n\n" +
                                                "4. संपर्क सूत्र: ${HeaderLogoSuperMenuState.contactEmail} | ${HeaderLogoSuperMenuState.contactPhone}"
                                        } else {
                                            "1. Exam-Oriented Paid Test Series (50 Tests per Exam): Every exam category (UPSC, UPPCS, UKPSC, BPSC, UP Police Constable, UPSSSC, UKSSSC, UGC NET, IIT JEE, NEET, SSC, Banking, Railways & TET) features 20 Full-Length Tests + 20 Subject-Wise Sectional Tests + 10 Previous Year Papers matching official question counts and difficulty.\n\n" +
                                                "2. Dedicated E-Books & Offline Vault: Bilingual study modules and PDF notes with built-in dark/sepia reader and offline caching.\n\n" +
                                                "3. Margdarshan Video Lectures: Expert counseling on how to use the app, which subject to choose, and best streams/courses after 12th.\n\n" +
                                                "4. Official Contact: ${HeaderLogoSuperMenuState.contactEmail} | ${HeaderLogoSuperMenuState.contactPhone}"
                                        },
                                        fontSize = 12.sp,
                                        color = Color(0xFF334155),
                                        lineHeight = 18.sp
                                    )
                                }
                            }
                        }
                    }

                    // SECTION 9: OWNER SECTION (Strictly Locked for Students • Unlocked Only for Verified Owner)
                    if (selectedSection == "OWNER_SECTION") {
                        item {
                            StrictOwnerLockAndFullEditorSection(
                                uiState = uiState,
                                viewModel = viewModel,
                                isHi = isHi,
                                onOpenFullOwnerPortalScreen = {
                                    onDismiss()
                                    viewModel.openOwnerPortal()
                                },
                                onOpenVideoUploadModal = {
                                    lectureBeingEdited = null
                                    showAddOrEditVideoModal = true
                                }
                            )
                        }
                    }
                }
            }
        }
    }

    // Modal: Interactive Video Lecture Player & Counseling Notes Viewer
    activeVideoLectureForPlayer?.let { lecture ->
        MargdarshanVideoPlayerDialog(
            lecture = lecture,
            isHi = isHi,
            onDismiss = { activeVideoLectureForPlayer = null }
        )
    }

    // Modal: Owner Add / Edit Video Lecture & Thumbnail Studio
    if (showAddOrEditVideoModal) {
        OwnerAddOrEditVideoLectureModal(
            existingLecture = lectureBeingEdited,
            isHi = isHi,
            onDismiss = {
                showAddOrEditVideoModal = false
                lectureBeingEdited = null
            },
            onSaveLecture = { savedLecture ->
                HeaderLogoSuperMenuState.addOrUpdateVideoLecture(savedLecture)
                showAddOrEditVideoModal = false
                lectureBeingEdited = null
            }
        )
    }
}

@Composable
private fun SubscriptionPlanCardItem(
    badge: String,
    title: String,
    priceInr: Int,
    mrpInr: Int,
    features: List<String>,
    buttonLabel: String,
    testTag: String,
    isHighlighted: Boolean = false,
    onSelect: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isHighlighted) Color(0xFFFFFBEB) else Color.White
        ),
        border = androidx.compose.foundation.BorderStroke(
            width = if (isHighlighted) 2.dp else 1.dp,
            color = if (isHighlighted) SaffronGold else Color(0xFFE2E8F0)
        )
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(5.dp))
                        .background(if (isHighlighted) SaffronGold else Navy900)
                        .padding(horizontal = 8.dp, vertical = 3.dp)
                ) {
                    Text(
                        text = badge,
                        fontSize = 9.5.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = if (isHighlighted) Navy900 else SaffronGold
                    )
                }

                Row(verticalAlignment = Alignment.Bottom) {
                    Text(
                        text = "₹$priceInr",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = EmeraldSuccess
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "₹$mrpInr",
                        fontSize = 11.5.sp,
                        color = Color(0xFF94A3B8)
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = title,
                fontSize = 14.5.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Navy900
            )

            Spacer(modifier = Modifier.height(6.dp))

            features.forEach { feat ->
                Row(
                    modifier = Modifier.padding(vertical = 2.dp),
                    verticalAlignment = Alignment.Top
                ) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = null,
                        tint = EmeraldSuccess,
                        modifier = Modifier.size(15.dp).padding(top = 2.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = feat,
                        fontSize = 11.5.sp,
                        color = Color(0xFF334155)
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = onSelect,
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isHighlighted) SaffronGold else Navy900
                ),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.fillMaxWidth().height(40.dp).testTag(testTag)
            ) {
                Text(
                    text = buttonLabel,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = if (isHighlighted) Navy900 else Color.White
                )
            }
        }
    }
}

/**
 * Interactive Video Lecture Player & Counseling Guidance Viewer Modal.
 */
@Composable
fun MargdarshanVideoPlayerDialog(
    lecture: MargdarshanVideoLecture,
    isHi: Boolean,
    onDismiss: () -> Unit
) {
    var isPlaying by remember { mutableStateOf(true) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.OndemandVideo,
                        contentDescription = null,
                        tint = SaffronGold,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = if (isHi) lecture.categoryBadgeHi else lecture.categoryBadgeEn,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = EmeraldSuccess
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = if (isHi) lecture.titleHi else lecture.titleEn,
                    fontSize = 14.5.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Navy900
                )
            }
        },
        text = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                // Simulated HD Video Player Canvas
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(155.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(Color(lecture.thumbnailColorHex), Navy900)
                            )
                        )
                        .clickable { isPlaying = !isPlaying }
                        .padding(14.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Box(
                            modifier = Modifier
                                .size(48.dp)
                                .clip(CircleShape)
                                .background(SaffronGold),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.PlayArrow,
                                contentDescription = null,
                                tint = Navy900,
                                modifier = Modifier.size(28.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = if (isPlaying) {
                                if (isHi) "▶ लाइव मार्गदर्शन वीडियो चल रहा है (${lecture.durationText})" else "▶ Playing HD Counseling Lecture (${lecture.durationText})"
                            } else {
                                if (isHi) "⏸ वीडियो पॉज़ है — चलाने के लिए टैप करें" else "⏸ Paused — Tap to Resume Video"
                            },
                            fontSize = 11.5.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White
                        )
                        Text(
                            text = lecture.speakerName,
                            fontSize = 10.5.sp,
                            color = SaffronGold
                        )
                    }
                }

                Text(
                    text = if (isHi) lecture.videoStreamNotesHi else lecture.videoStreamNotesEn,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Navy900
                )

                val points = if (isHi) lecture.keyGuidancePointsHi else lecture.keyGuidancePointsEn
                points.forEach { pt ->
                    Text(
                        text = "✓ $pt",
                        fontSize = 11.5.sp,
                        color = Color(0xFF334155),
                        lineHeight = 16.sp
                    )
                }
            }
        },
        confirmButton = {
            Button(
                onClick = onDismiss,
                colors = ButtonDefaults.buttonColors(containerColor = Navy900)
            ) {
                Text(if (isHi) "बंद करें" else "Done", color = Color.White, fontWeight = FontWeight.Bold)
            }
        }
    )
}

/**
 * Owner Modal to Upload a New Margdarshan Video Lecture or Edit an Existing Video Lecture & Thumbnail.
 */
@Composable
fun OwnerAddOrEditVideoLectureModal(
    existingLecture: MargdarshanVideoLecture?,
    isHi: Boolean,
    onDismiss: () -> Unit,
    onSaveLecture: (MargdarshanVideoLecture) -> Unit
) {
    var titleEn by remember { mutableStateOf(existingLecture?.titleEn ?: "") }
    var titleHi by remember { mutableStateOf(existingLecture?.titleHi ?: "") }
    var categoryEn by remember { mutableStateOf(existingLecture?.categoryBadgeEn ?: "MARGDARSHAN COUNSELING") }
    var categoryHi by remember { mutableStateOf(existingLecture?.categoryBadgeHi ?: "मार्गदर्शन काउंसलिंग") }
    var durationText by remember { mutableStateOf(existingLecture?.durationText ?: "25:00 Mins") }
    var speakerName by remember { mutableStateOf(existingLecture?.speakerName ?: "Shakuntalam Chief Mentor") }
    var thumbnailBadge by remember { mutableStateOf(existingLecture?.thumbnailBadgeText ?: "NEW LECTURE") }
    var selectedColorHex by remember { mutableStateOf(existingLecture?.thumbnailColorHex ?: 0xFF1E40AF) }
    var pointsTextEn by remember {
        mutableStateOf(
            existingLecture?.keyGuidancePointsEn?.joinToString("\n")
                ?: "How to select the best stream & course after 12th\nSubject-wise preparation strategy & time-table"
        )
    }
    var pointsTextHi by remember {
        mutableStateOf(
            existingLecture?.keyGuidancePointsHi?.joinToString("\n")
                ?: "12वीं के बाद सही स्ट्रीम और कोर्स का चुनाव कैसे करें\nविषयवार तैयारी की सटीक रणनीति और टाइम-टेबल"
        )
    }
    var notesEn by remember {
        mutableStateOf(existingLecture?.videoStreamNotesEn ?: "Complete counseling and career guidance video lecture.")
    }
    var notesHi by remember {
        mutableStateOf(existingLecture?.videoStreamNotesHi ?: "संपूर्ण करियर काउंसलिंग एवं मार्गदर्शन वीडियो लेक्चर।")
    }

    val colorChoices = listOf(
        0xFF1E40AF to "Royal Blue",
        0xFF047857 to "Emerald Green",
        0xFFB45309 to "Amber Gold",
        0xFF6D28D9 to "Deep Purple",
        0xFFBE123C to "Crimson Red",
        0xFF0F766E to "Teal Ocean"
    )

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                text = if (existingLecture == null) {
                    if (isHi) "+ नया मार्गदर्शन वीडियो लेक्चर अपलोड करें" else "+ Upload New Margdarshan Video Lecture"
                } else {
                    if (isHi) "वीडियो लेक्चर व थंबनेल एडिट करें" else "Edit Video Lecture & Thumbnail"
                },
                fontSize = 15.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Navy900
            )
        },
        text = {
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item {
                    OutlinedTextField(
                        value = titleEn,
                        onValueChange = { titleEn = it },
                        label = { Text("Lecture Title (English)") },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                item {
                    OutlinedTextField(
                        value = titleHi,
                        onValueChange = { titleHi = it },
                        label = { Text("लेक्चर का शीर्षक (हिंदी)") },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                item {
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        OutlinedTextField(
                            value = thumbnailBadge,
                            onValueChange = { thumbnailBadge = it },
                            label = { Text("Thumbnail Badge") },
                            modifier = Modifier.weight(1f),
                            singleLine = true
                        )
                        OutlinedTextField(
                            value = durationText,
                            onValueChange = { durationText = it },
                            label = { Text("Duration") },
                            modifier = Modifier.weight(1f),
                            singleLine = true
                        )
                    }
                }
                item {
                    Text(
                        text = if (isHi) "थंबनेल रंग थीम चुनें (Thumbnail Theme):" else "Select Thumbnail Color Theme:",
                        fontSize = 11.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = Navy900
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth().horizontalScroll(rememberScrollState()),
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        colorChoices.forEach { (hex, label) ->
                            val isSelected = selectedColorHex == hex
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(6.dp))
                                    .background(Color(hex))
                                    .border(
                                        width = if (isSelected) 2.dp else 0.dp,
                                        color = SaffronGold,
                                        shape = RoundedCornerShape(6.dp)
                                    )
                                    .clickable { selectedColorHex = hex }
                                    .padding(horizontal = 10.dp, vertical = 6.dp)
                            ) {
                                Text(
                                    text = if (isSelected) "✓ $label" else label,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
                item {
                    OutlinedTextField(
                        value = pointsTextHi,
                        onValueChange = { pointsTextHi = it },
                        label = { Text("मुख्य मार्गदर्शन बिंदु (हिंदी - प्रति लाइन 1 बिंदु)") },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                item {
                    OutlinedTextField(
                        value = pointsTextEn,
                        onValueChange = { pointsTextEn = it },
                        label = { Text("Key Guidance Points (English - 1 per line)") },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    val finalEn = titleEn.ifBlank { "Career & Subject Selection Guidance Lecture" }
                    val finalHi = titleHi.ifBlank { finalEn }
                    val newLecture = MargdarshanVideoLecture(
                        id = existingLecture?.id ?: "vid_custom_${System.currentTimeMillis()}",
                        titleEn = finalEn,
                        titleHi = finalHi,
                        categoryBadgeEn = categoryEn.ifBlank { "MARGDARSHAN" },
                        categoryBadgeHi = categoryHi.ifBlank { "मार्गदर्शन" },
                        durationText = durationText.ifBlank { "20:00 Mins" },
                        speakerName = speakerName.ifBlank { "Shakuntalam Counselor" },
                        thumbnailBadgeText = thumbnailBadge.ifBlank { "COUNSELING" },
                        thumbnailColorHex = selectedColorHex,
                        keyGuidancePointsEn = pointsTextEn.lines().map { it.trim() }.filter { it.isNotBlank() },
                        keyGuidancePointsHi = pointsTextHi.lines().map { it.trim() }.filter { it.isNotBlank() },
                        videoStreamNotesEn = notesEn,
                        videoStreamNotesHi = notesHi
                    )
                    onSaveLecture(newLecture)
                },
                colors = ButtonDefaults.buttonColors(containerColor = SaffronGold)
            ) {
                Text(
                    text = if (isHi) "सेव व पब्लिश करें" else "Save & Publish Lecture",
                    color = Navy900,
                    fontWeight = FontWeight.ExtraBold
                )
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(if (isHi) "रद्द करें" else "Cancel")
            }
        }
    )
}

/**
 * STRICT OWNER-ONLY LOCK GATE & FULL APP EDITING STUDIO
 *
 * Rule enforced:
 * - If any student clicks on the Owner Section, it shows a STRICT LOCK SCREEN (`🔒 स्टूडेंट्स के लिए लॉक है`).
 * - Even if a student enters their own email or phone number, access is strictly rejected.
 * - Only when the App Owner enters `thebharat99999@gmail.com` or `6396817525` + Owner Master PIN (`2525`)
 *   does the Owner Section unlock.
 * - Once unlocked, the Owner can edit Test Series, fix any mistake in any Question/Option/Explanation,
 *   upload/edit/delete E-Books, edit Prices/Subscriptions, upload/edit/delete Margdarshan Video Lectures,
 *   change thumbnails/badges, and update Contact Information.
 */
@Composable
fun StrictOwnerLockAndFullEditorSection(
    uiState: ShakuntalamUiState,
    viewModel: ShakuntalamViewModel,
    isHi: Boolean,
    onOpenFullOwnerPortalScreen: () -> Unit,
    onOpenVideoUploadModal: () -> Unit
) {
    var ownerIdentityInput by remember { mutableStateOf("") }
    var ownerPinInput by remember { mutableStateOf("") }

    // Editable Contact Info state when Owner is unlocked
    var editEmail by remember(HeaderLogoSuperMenuState.contactEmail) {
        mutableStateOf(HeaderLogoSuperMenuState.contactEmail)
    }
    var editPhone by remember(HeaderLogoSuperMenuState.contactPhone) {
        mutableStateOf(HeaderLogoSuperMenuState.contactPhone)
    }
    var editMonthlyPrice by remember(HeaderLogoSuperMenuState.monthlyPassPriceInr) {
        mutableStateOf(HeaderLogoSuperMenuState.monthlyPassPriceInr.toString())
    }
    var editYearlyPrice by remember(HeaderLogoSuperMenuState.yearlyPassPriceInr) {
        mutableStateOf(HeaderLogoSuperMenuState.yearlyPassPriceInr.toString())
    }
    var editLifetimePrice by remember(HeaderLogoSuperMenuState.lifetimePassPriceInr) {
        mutableStateOf(HeaderLogoSuperMenuState.lifetimePassPriceInr.toString())
    }

    if (!HeaderLogoSuperMenuState.isOwnerUnlocked) {
        // STRICT LOCK SCREEN FOR STUDENTS
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .testTag("strict_owner_lock_gate_card"),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            border = androidx.compose.foundation.BorderStroke(2.dp, Color(0xFFDC2626))
        ) {
            Column(
                modifier = Modifier.padding(18.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .size(56.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFFEE2E2)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Locked for Students",
                        tint = Color(0xFFDC2626),
                        modifier = Modifier.size(30.dp)
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(Color(0xFFDC2626))
                        .padding(horizontal = 10.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = if (isHi) "🔒 स्टूडेंट्स के लिए सख्त लॉक (OWNER ONLY)" else "🔒 STRICTLY LOCKED FOR STUDENTS (OWNER ONLY)",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = if (isHi) {
                        "ओनर सेक्शन (Owner Admin Studio)"
                    } else {
                        "Owner Section (Master Admin Studio)"
                    },
                    fontSize = 16.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Navy900
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = if (isHi) {
                        "यह सेक्शन किसी भी स्टूडेंट के क्लिक करने पर कभी नहीं खुलेगा। यह केवल शकुंतलम ऐप के ओनर के लिए आरक्षित है ताकि ओनर टेस्ट सीरीज़, ई-बुक्स, प्राइस, वीडियो लेक्चर्स, थंबनेल या किसी भी गलती को एडिट/अपलोड/डिलीट कर सकें।"
                    } else {
                        "This section never opens for students. It is strictly reserved for the App Owner to edit, upload, or delete Test Series, Questions, E-Books, Prices, Video Lectures, and Thumbnails."
                    },
                    fontSize = 11.5.sp,
                    color = Color(0xFF475569),
                    lineHeight = 16.sp
                )

                Spacer(modifier = Modifier.height(14.dp))

                OutlinedTextField(
                    value = ownerIdentityInput,
                    onValueChange = { ownerIdentityInput = it },
                    label = {
                        Text(
                            if (isHi) "ओनर ईमेल या फोन नंबर दर्ज करें" else "Enter Owner Email or Phone Number",
                            fontSize = 12.sp
                        )
                    },
                    placeholder = { Text("Authorized Owner Email / Phone", fontSize = 11.5.sp) },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth().testTag("owner_lock_identity_input")
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = ownerPinInput,
                    onValueChange = { ownerPinInput = it.filter { ch -> ch.isDigit() }.take(6) },
                    label = {
                        Text(
                            if (isHi) "ओनर मास्टर सुरक्षा पिन (Owner Security PIN)" else "Owner Master Security PIN",
                            fontSize = 12.sp
                        )
                    },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                    modifier = Modifier.fillMaxWidth().testTag("owner_lock_pin_input")
                )

                if (HeaderLogoSuperMenuState.ownerLockStatusMessage.isNotBlank()) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = HeaderLogoSuperMenuState.ownerLockStatusMessage,
                        fontSize = 11.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFDC2626),
                        modifier = Modifier.testTag("owner_lock_error_text")
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                Button(
                    onClick = {
                        HeaderLogoSuperMenuState.verifyAndUnlockOwnerSection(
                            identityInput = ownerIdentityInput,
                            pinInput = ownerPinInput,
                            isHi = isHi
                        )
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Navy900),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.fillMaxWidth().height(44.dp).testTag("owner_unlock_verify_btn")
                ) {
                    Icon(Icons.Default.Security, contentDescription = null, tint = SaffronGold, modifier = Modifier.size(18.dp))
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = if (isHi) "ओनर सत्यापन कर अनलॉक करें" else "Verify Owner & Unlock Studio",
                        fontSize = 12.5.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White
                    )
                }
            }
        }
    } else {
        // UNLOCKED OWNER MASTER STUDIO
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Card(
                modifier = Modifier.fillMaxWidth().testTag("unlocked_owner_studio_card"),
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(containerColor = Navy900)
            ) {
                Column(modifier = Modifier.padding(15.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Verified,
                                contentDescription = null,
                                tint = SaffronGold,
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = if (isHi) "ओनर मास्टर कंट्रोल स्टूडियो (अनलॉक)" else "OWNER MASTER STUDIO (UNLOCKED)",
                                fontSize = 13.5.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = SaffronGold
                            )
                        }

                        OutlinedButton(
                            onClick = { HeaderLogoSuperMenuState.lockOwnerSection() },
                            modifier = Modifier.height(30.dp).testTag("owner_relock_btn"),
                            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 0.dp)
                        ) {
                            Icon(Icons.Default.Lock, contentDescription = null, tint = SaffronGold, modifier = Modifier.size(13.dp))
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = if (isHi) "लॉक करें" else "Lock Studio",
                                fontSize = 10.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = if (isHi) {
                            "स्वागत है (${HeaderLogoSuperMenuState.AUTHORIZED_OWNER_EMAIL} / ${HeaderLogoSuperMenuState.AUTHORIZED_OWNER_PHONE})! यहाँ से आप कोई भी टेस्ट सीरीज़, प्रश्न/उत्तर की गलती, ई-बुक, प्राइस सेक्शन, मार्गदर्शन वीडियो लेक्चर, थंबनेल या संपर्क जानकारी कभी भी एडिट, अपलोड या डिलीट कर सकते हैं।"
                        } else {
                            "Welcome Owner (${HeaderLogoSuperMenuState.AUTHORIZED_OWNER_EMAIL} / ${HeaderLogoSuperMenuState.AUTHORIZED_OWNER_PHONE})! Edit, upload, or delete any Test Series, Question mistake, E-Book, Price, Video Lecture, Thumbnail, or Contact Info below."
                        },
                        fontSize = 11.5.sp,
                        color = Color(0xFFE2E8F0)
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Button(
                        onClick = onOpenFullOwnerPortalScreen,
                        colors = ButtonDefaults.buttonColors(containerColor = SaffronGold),
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.fillMaxWidth().height(42.dp).testTag("open_full_owner_admin_screen_btn")
                    ) {
                        Icon(Icons.Default.AdminPanelSettings, contentDescription = null, tint = Navy900)
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = if (isHi) {
                                "संपूर्ण टेस्ट सीरीज़, प्रश्न सुधार एवं ई-बुक एडिटर खोलें →"
                            } else {
                                "Open Full Test Series, Question Mistake Fixer & E-Book Studio →"
                            },
                            fontSize = 12.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Navy900
                        )
                    }
                }
            }

            // Quick Edit 1: Subscription & Offer Price Editor
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFFE2E8F0))
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Text(
                        text = if (isHi) "1. सब्सक्रिप्शन एवं ऑफर प्राइस सेक्शन एडिट करें:" else "1. Edit Subscription & Offer Prices (₹):",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Navy900
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        OutlinedTextField(
                            value = editMonthlyPrice,
                            onValueChange = { editMonthlyPrice = it.filter { ch -> ch.isDigit() } },
                            label = { Text(if (isHi) "मासिक (₹)" else "Monthly (₹)", fontSize = 10.5.sp) },
                            singleLine = true,
                            modifier = Modifier.weight(1f).testTag("owner_edit_monthly_price_input")
                        )
                        OutlinedTextField(
                            value = editYearlyPrice,
                            onValueChange = { editYearlyPrice = it.filter { ch -> ch.isDigit() } },
                            label = { Text(if (isHi) "वार्षिक (₹)" else "Yearly (₹)", fontSize = 10.5.sp) },
                            singleLine = true,
                            modifier = Modifier.weight(1f).testTag("owner_edit_yearly_price_input")
                        )
                        OutlinedTextField(
                            value = editLifetimePrice,
                            onValueChange = { editLifetimePrice = it.filter { ch -> ch.isDigit() } },
                            label = { Text(if (isHi) "लाइफटाइम (₹)" else "Lifetime (₹)", fontSize = 10.5.sp) },
                            singleLine = true,
                            modifier = Modifier.weight(1f).testTag("owner_edit_lifetime_price_input")
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(
                        onClick = {
                            HeaderLogoSuperMenuState.updateSubscriptionPrices(
                                monthlyInr = editMonthlyPrice.toIntOrNull() ?: 9,
                                yearlyInr = editYearlyPrice.toIntOrNull() ?: 99,
                                lifetimeInr = editLifetimePrice.toIntOrNull() ?: 399
                            )
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = EmeraldSuccess),
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.fillMaxWidth().testTag("owner_save_subscription_prices_btn")
                    ) {
                        Text(
                            text = if (isHi) "सब्सक्रिप्शन कीमतें अपडेट करें" else "Update Live Subscription Prices",
                            fontSize = 11.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }

            // Quick Edit 2: Margdarshan & Video Lectures Studio
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFFE2E8F0))
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Text(
                        text = if (isHi) {
                            "2. मार्गदर्शन एवं वीडियो लेक्चर्स अपलोड/एडिट/डिलीट करें (${HeaderLogoSuperMenuState.margdarshanVideoLectures.size}):"
                        } else {
                            "2. Upload, Edit or Delete Margdarshan Video Lectures (${HeaderLogoSuperMenuState.margdarshanVideoLectures.size}):"
                        },
                        fontSize = 13.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Navy900
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Button(
                        onClick = onOpenVideoUploadModal,
                        colors = ButtonDefaults.buttonColors(containerColor = Navy900),
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(Icons.Default.OndemandVideo, contentDescription = null, tint = SaffronGold, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = if (isHi) "+ नया मार्गदर्शन/काउंसलिंग वीडियो लेक्चर अपलोड करें" else "+ Upload New Margdarshan Video Lecture",
                            fontSize = 11.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }

            // Quick Edit 3: Contact Information Editor
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFFE2E8F0))
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Text(
                        text = if (isHi) "3. कांटेक्ट इनफॉरमेशन (ईमेल एवं फोन नंबर) एडिट करें:" else "3. Edit Official Contact Information:",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Navy900
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        value = editEmail,
                        onValueChange = { editEmail = it },
                        label = { Text("Official Contact Email ID") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth().testTag("owner_edit_contact_email_input")
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        value = editPhone,
                        onValueChange = { editPhone = it },
                        label = { Text("Official Helpline Phone / WhatsApp") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth().testTag("owner_edit_contact_phone_input")
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(
                        onClick = {
                            HeaderLogoSuperMenuState.updateContactDetails(
                                newEmail = editEmail,
                                newPhone = editPhone,
                                newWhatsApp = editPhone,
                                newOrgEn = HeaderLogoSuperMenuState.contactOrganizationEn,
                                newOrgHi = HeaderLogoSuperMenuState.contactOrganizationHi,
                                newHoursEn = HeaderLogoSuperMenuState.contactSupportHoursEn,
                                newHoursHi = HeaderLogoSuperMenuState.contactSupportHoursHi
                            )
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Navy900),
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.fillMaxWidth().testTag("owner_save_contact_info_btn")
                    ) {
                        Text(
                            text = if (isHi) "संपर्क जानकारी सेव करें" else "Save Contact Information",
                            fontSize = 11.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = SaffronGold
                        )
                    }
                }
            }
        }
    }
}
