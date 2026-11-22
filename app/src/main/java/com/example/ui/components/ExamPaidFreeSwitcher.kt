package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.LockOpen
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.AllIndiaMasterTestPackageData
import com.example.data.ExamPackageCategory
import com.example.model.MockTest
import com.example.model.StudyItem
import com.example.ui.theme.EmeraldSuccess
import com.example.ui.theme.Navy900
import com.example.ui.theme.SaffronGold

/**
 * Reactive bridge so every ExamPaidTestSeriesPanel and Free Test Hub across all exam sections
 * (UPSC, UPPCS, UKPSC, BPSC, UPSSSC, UKSSSC, SSC, IIT JEE/JE, NEET, UGC NET, TET, Banking, Railways)
 * reflects the live ₹9/Month, ₹99/Year & ₹399/Lifetime All-Access Subscription status and can launch
 * any Full-Length, Sectional, Topic-Wise, 5-Year PYQ, or Daily Practice test directly.
 */
object SubscriptionPassStateBridge {
    var isSubscriptionActive by mutableStateOf(false)
    var activePlanCode by mutableStateOf("NONE")
    var expiryEpochMillis by mutableLongStateOf(0L)
    var remainingDays by mutableIntStateOf(0)
    var onSubscribeMonthly9Callback: (() -> Unit)? = null
    var onSubscribeYearly99Callback: (() -> Unit)? = null
    var onSubscribeLifetime399Callback: (() -> Unit)? = null
    var onInitiateSubscriptionCheckoutCallback: ((planCode: String) -> Unit)? = null
    var onStartAnyMockTestCallback: ((MockTest) -> Unit)? = null
    var onOpenFreeBrandedNoteCallback: ((StudyItem) -> Unit)? = null
    var onDownloadFreeBrandedPdfCallback: ((StudyItem) -> Unit)? = null
}

/**
 * Unified Professional EdTech Dual-Tab Selector & Paid/Free Series Switcher.
 * Directly under each Exam Name, provides:
 *   1. पेड टेस्ट सीरीज़ (Paid Test Series — ₹9/Month, ₹99/Year, ₹399/Lifetime All-Access)
 *   2. फ्री टेस्ट सीरीज़ (Free Test Series — Daily, Practice, Topic-Wise, Subject-Wise & PYQ)
 */
@Composable
fun ExamPaidFreeDualTabs(
    examKey: String,
    examLabelEn: String,
    examLabelHi: String,
    selectedMode: String, // "PAID" or "FREE"
    freeCountBadge: String,
    paidCountBadge: String,
    isHi: Boolean,
    onSelectMode: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val isPaidSelected = selectedMode.equals("PAID", ignoreCase = true)
    val isFreeSelected = !isPaidSelected

    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            ShakuntalamBrandCrestBadge(size = 15.dp, showGlowRing = false)
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = if (isHi)
                    "$examLabelHi — टेस्ट सीरीज़ मोड चुनें (फुल पैकेज):"
                else
                    "$examLabelEn — Select Test Series Mode (Full Package):",
                fontSize = 11.5.sp,
                fontWeight = FontWeight.Bold,
                color = EdTechProColors.ChampagneGold,
                maxLines = 1,
                softWrap = false,
                overflow = TextOverflow.Ellipsis
            )
        }
        Spacer(modifier = Modifier.height(6.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .background(EdTechProColors.DeepRoyalNavy)
                .border(1.dp, EdTechProColors.UnselectedDarkTabBorder, RoundedCornerShape(12.dp))
                .padding(4.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Option 1: 1. पेड टेस्ट सीरीज़ (Paid Test Series — ₹9/Mo, ₹99/Yr, ₹399/Life)
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(52.dp)
                    .clip(RoundedCornerShape(9.dp))
                    .background(
                        if (isPaidSelected) {
                            Brush.horizontalGradient(
                                listOf(EdTechProColors.RoyalIndigo, Color(0xFF1D4ED8))
                            )
                        } else {
                            Brush.horizontalGradient(
                                listOf(EdTechProColors.UnselectedDarkTabBg, EdTechProColors.UnselectedDarkTabBg)
                            )
                        }
                    )
                    .border(
                        width = if (isPaidSelected) 1.5.dp else 1.dp,
                        color = if (isPaidSelected) EdTechProColors.WarmGold else EdTechProColors.UnselectedDarkTabBorder,
                        shape = RoundedCornerShape(9.dp)
                    )
                    .clickable { onSelectMode("PAID") }
                    .padding(horizontal = 8.dp, vertical = 5.dp)
                    .testTag("${examKey}_paid_test_series_tab"),
                contentAlignment = Alignment.CenterStart
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ShakuntalamBrandCrestBadge(
                        size = 20.dp,
                        showGlowRing = isPaidSelected
                    )
                    Spacer(modifier = Modifier.width(7.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = if (isHi) "1. पेड टेस्ट सीरीज़ (₹9/माह)" else "1. Paid Series (₹9/Mo)",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = if (isPaidSelected) EdTechProColors.ChampagneGold else Color.White,
                            maxLines = 1,
                            softWrap = false,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = paidCountBadge,
                            fontSize = 9.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = if (isPaidSelected) Color.White else Color(0xFF94A3B8),
                            maxLines = 1,
                            softWrap = false,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }

            // Option 2: 2. फ्री टेस्ट सीरीज़ (Free Test Series)
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(52.dp)
                    .clip(RoundedCornerShape(9.dp))
                    .background(
                        if (isFreeSelected) {
                            Brush.horizontalGradient(
                                listOf(EdTechProColors.RoyalIndigo, Color(0xFF0369A1))
                            )
                        } else {
                            Brush.horizontalGradient(
                                listOf(EdTechProColors.UnselectedDarkTabBg, EdTechProColors.UnselectedDarkTabBg)
                            )
                        }
                    )
                    .border(
                        width = if (isFreeSelected) 1.5.dp else 1.dp,
                        color = if (isFreeSelected) EdTechProColors.ElectricCyan else EdTechProColors.UnselectedDarkTabBorder,
                        shape = RoundedCornerShape(9.dp)
                    )
                    .clickable { onSelectMode("FREE") }
                    .padding(horizontal = 8.dp, vertical = 5.dp)
                    .testTag("${examKey}_free_test_series_tab"),
                contentAlignment = Alignment.CenterStart
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ShakuntalamBrandCrestBadge(
                        size = 20.dp,
                        showGlowRing = isFreeSelected
                    )
                    Spacer(modifier = Modifier.width(7.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = if (isHi) "2. फ्री टेस्ट सीरीज़" else "2. Free Test Series",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = if (isFreeSelected) Color(0xFF67E8F9) else Color.White,
                            maxLines = 1,
                            softWrap = false,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = freeCountBadge,
                            fontSize = 9.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = if (isFreeSelected) Color.White else Color(0xFF94A3B8),
                            maxLines = 1,
                            softWrap = false,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }
        }
    }
}

/**
 * Displays the complete Paid Test Series Full Package for an exam when the user selects
 * "1. पेड टेस्ट सीरीज़ (Paid Test Series)".
 * Includes:
 * - 3-Tier Subscription Pass Gate (₹9/Month, ₹99/Year, ₹399/Lifetime) — Paid tests unlock ONLY after payment deduction!
 * - 5-Tab Exam Package Selector:
 *     1. Full-Length Tests (फुल लेंथ टेस्ट)
 *     2. Sectional / Subject Tests (सेक्शनल टेस्ट)
 *     3. Topic-Wise Quizzes (टॉपिक वाइज़ क्विज़ — Indus Valley, Maurya, Gupta, Sultanate, Mughal, 1857, Polity, Geography, Maths DI Tables, JE/NEET)
 *     4. Last 5 Years Official PYQ Papers Tab (2020–2025 ओरिजिनल PYQ पेपर्स विथ एक्सप्लेनेशन)
 *     5. Daily & Practice Quizzes (डेली व प्रैक्टिस क्विज़)
 */
@Composable
fun ExamPaidTestSeriesPanel(
    examKey: String,
    examTitleEn: String,
    examTitleHi: String,
    paidItems: List<StudyItem>,
    purchasedItemIds: Set<String>,
    isHi: Boolean,
    onBuyOrOpenItem: (StudyItem) -> Unit,
    onAddToCart: (StudyItem) -> Unit,
    onStartPaidMockTest: () -> Unit,
    onSwitchToFreeTests: () -> Unit
) {
    val isSubscriptionActive = SubscriptionPassStateBridge.isSubscriptionActive
    val activePlanCode = SubscriptionPassStateBridge.activePlanCode
    val remainingDays = SubscriptionPassStateBridge.remainingDays

    var selectedPackageTab by remember(examKey) { mutableStateOf(ExamPackageCategory.FULL_LENGTH) }
    var selectedSectionalSubject by remember(examKey) { mutableStateOf("ALL") }
    val blueprint = remember(examKey) {
        AllIndiaMasterTestPackageData.getExamBlueprint(examKey)
    }
    val allPackageEntries = remember(examKey) {
        AllIndiaMasterTestPackageData.getExamPackageEntries(examKey)
    }
    val paid50Count = remember(allPackageEntries) {
        allPackageEntries.count { it.isPaidOnly }
    }
    val filteredEntries = remember(allPackageEntries, selectedPackageTab, selectedSectionalSubject) {
        val byTab = allPackageEntries.filter { it.packageCategory == selectedPackageTab }
        if (selectedPackageTab == ExamPackageCategory.SECTIONAL && selectedSectionalSubject != "ALL") {
            byTab.filter { it.subjectGroupEn == selectedSectionalSubject }
        } else {
            byTab
        }
    }

    val triggerPaymentForPlan: (String) -> Unit = { planCode ->
        val checkoutCb = SubscriptionPassStateBridge.onInitiateSubscriptionCheckoutCallback
        if (checkoutCb != null) {
            checkoutCb(planCode)
        } else {
            when (planCode) {
                "LIFETIME_399" -> SubscriptionPassStateBridge.onSubscribeLifetime399Callback?.invoke()
                "YEARLY_99" -> SubscriptionPassStateBridge.onSubscribeYearly99Callback?.invoke()
                else -> SubscriptionPassStateBridge.onSubscribeMonthly9Callback?.invoke()
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        // 1. All-Access Subscription Gate Header (₹9/Month, ₹99/Year & ₹399/Lifetime)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .background(EdTechProColors.DeepRoyalNavy)
                .border(
                    width = 1.5.dp,
                    color = if (isSubscriptionActive) EmeraldSuccess else EdTechProColors.WarmGold,
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(12.dp)
                .testTag("${examKey}_paid_subscription_pass_box")
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    ShakuntalamBrandCrestBadge(size = 24.dp, showGlowRing = true)
                    Spacer(modifier = Modifier.width(8.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = if (isHi)
                                "$examTitleHi — फुल पैकेज पेड टेस्ट सीरीज़ (₹9/माह • ₹99/वर्ष • ₹399 आजीवन)"
                            else
                                "$examTitleEn — Full Package Paid Series (₹9/Mo • ₹99/Yr • ₹399 Life)",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = EdTechProColors.ChampagneGold,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = if (isSubscriptionActive) {
                                val planName = when (activePlanCode) {
                                    "LIFETIME_399" -> "₹399 Lifetime"
                                    "YEARLY_99" -> "₹99/Year"
                                    else -> "₹9/Month"
                                }
                                if (isHi)
                                    "✓ आपका $planName पास सक्रिय है ($remainingDays दिन शेष) • सभी फुल-लेंथ, सेक्शनल, टॉपिक व 5-वर्षीय PYQ अनलॉक!"
                                else
                                    "✓ Your $planName Pass is ACTIVE ($remainingDays days left) • All FLT, Sectional, Topic & PYQ Tests Unlocked!"
                            } else {
                                if (isHi)
                                    "🔒 पेड सेक्शन लॉक है: ₹9 (1 माह), ₹99 (1 वर्ष) या ₹399 (लाइफटाइम) का भुगतान कटने पर सभी टेस्ट तुरंत खुल जाएंगे!"
                                else
                                    "🔒 Paid Section Locked: Complete ₹9/Mo, ₹99/Yr or ₹399 Lifetime payment deduction to unlock all tests!"
                            },
                            fontSize = 10.5.sp,
                            color = if (isSubscriptionActive) Color(0xFF6EE7B7) else Color(0xFFE2E8F0),
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }

            if (!isSubscriptionActive) {
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Button(
                        onClick = { triggerPaymentForPlan("MONTHLY_9") },
                        colors = ButtonDefaults.buttonColors(containerColor = EdTechProColors.RoyalIndigo),
                        shape = RoundedCornerShape(8.dp),
                        contentPadding = PaddingValues(horizontal = 6.dp, vertical = 6.dp),
                        modifier = Modifier
                            .weight(1f)
                            .height(38.dp)
                            .border(1.dp, EdTechProColors.ElectricCyan, RoundedCornerShape(8.dp))
                            .testTag("${examKey}_subscribe_9_monthly_btn")
                    ) {
                        Text(
                            text = if (isHi) "₹9 / 1 माह" else "₹9 / Month",
                            fontSize = 10.5.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White,
                            maxLines = 1
                        )
                    }

                    Button(
                        onClick = { triggerPaymentForPlan("YEARLY_99") },
                        colors = ButtonDefaults.buttonColors(containerColor = EdTechProColors.WarmGold),
                        shape = RoundedCornerShape(8.dp),
                        contentPadding = PaddingValues(horizontal = 6.dp, vertical = 6.dp),
                        modifier = Modifier
                            .weight(1f)
                            .height(38.dp)
                            .testTag("${examKey}_subscribe_99_yearly_btn")
                    ) {
                        Text(
                            text = if (isHi) "₹99 / 1 साल ★" else "₹99 / Year ★",
                            fontSize = 10.5.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Navy900,
                            maxLines = 1
                        )
                    }

                    Button(
                        onClick = { triggerPaymentForPlan("LIFETIME_399") },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6D28D9)),
                        shape = RoundedCornerShape(8.dp),
                        contentPadding = PaddingValues(horizontal = 6.dp, vertical = 6.dp),
                        modifier = Modifier
                            .weight(1f)
                            .height(38.dp)
                            .border(1.dp, Color(0xFFD8B4FE), RoundedCornerShape(8.dp))
                            .testTag("${examKey}_subscribe_399_lifetime_btn")
                    ) {
                        Text(
                            text = if (isHi) "₹399 आजीवन" else "₹399 Life",
                            fontSize = 10.5.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White,
                            maxLines = 1
                        )
                    }
                }
            }
        }

        // 1B. Official 50 Paid Tests Blueprint Banner (20 FLT + 20 Sectional + 10 PYQ • Exam Question Count & Difficulty Theme)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xFF0F172A))
                .border(1.dp, EdTechProColors.ElectricCyan.copy(alpha = 0.55f), RoundedCornerShape(10.dp))
                .padding(horizontal = 12.dp, vertical = 9.dp)
                .testTag("${examKey}_50_paid_tests_blueprint_banner")
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = if (isHi)
                        "★ कुल $paid50Count पेड टेस्ट: 20 फुल लेंथ (${blueprint.fltQuestionCount} Q) + 20 सेक्शनल (${blueprint.sectionalQuestionCount} Q) + 10 PYQ (${blueprint.fltQuestionCount} Q)"
                    else
                        "★ Total $paid50Count Paid Tests: 20 FLT (${blueprint.fltQuestionCount} Qs) + 20 Sectional (${blueprint.sectionalQuestionCount} Qs) + 10 PYQ (${blueprint.fltQuestionCount} Qs)",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFF67E8F9),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Spacer(modifier = Modifier.height(3.dp))
            Text(
                text = if (isHi)
                    "थीम: ${blueprint.examThemeHi} • स्तर: ${blueprint.difficultyLevelHi}"
                else
                    "Theme: ${blueprint.examThemeEn} • Level: ${blueprint.difficultyLevelEn}",
                fontSize = 9.8.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFFFDE68A),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }

        // 2. 5-Category Testbook-Style Full Package Selector Tabs:
        //    [Full-Length Tests (20)] [Sectional Tests (20)] [Previous Year Papers (10)] [Topic-Wise Quizzes (15)] [Daily & Practice (4)]
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .testTag("${examKey}_package_category_tabs")
        ) {
            items(ExamPackageCategory.entries) { category ->
                val countForCat = allPackageEntries.count { it.packageCategory == category }
                val isSelected = selectedPackageTab == category
                ProfessionalTestSeriesTabChip(
                    label = if (isHi) category.labelHi else category.labelEn,
                    isSelected = isSelected,
                    onClick = { selectedPackageTab = category },
                    isDarkSurface = true,
                    badgeCountText = "$countForCat",
                    modifier = Modifier.testTag("${examKey}_pkg_tab_${category.code.lowercase()}")
                )
            }
        }

        // 2B. Subject Breakdown Filter Chips when viewing the 20 Sectional Tests
        if (selectedPackageTab == ExamPackageCategory.SECTIONAL) {
            val sectionalEntries = remember(allPackageEntries) {
                allPackageEntries.filter { it.packageCategory == ExamPackageCategory.SECTIONAL }
            }
            val subjectGroups = remember(sectionalEntries) {
                sectionalEntries.map { it.subjectGroupEn to it.subjectGroupHi }.distinctBy { it.first }
            }
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("${examKey}_sectional_subject_filter_row")
            ) {
                item {
                    ProfessionalTestSeriesTabChip(
                        label = if (isHi) "सभी विषय (20 सेक्शनल)" else "All Subjects (20 Sectional)",
                        isSelected = selectedSectionalSubject == "ALL",
                        onClick = { selectedSectionalSubject = "ALL" },
                        isDarkSurface = true,
                        badgeCountText = "${sectionalEntries.size}",
                        logoSize = 13.dp,
                        fontSize = 10.5.sp
                    )
                }
                items(subjectGroups) { (subjEn, subjHi) ->
                    val subjCount = sectionalEntries.count { it.subjectGroupEn == subjEn }
                    ProfessionalTestSeriesTabChip(
                        label = if (isHi) subjHi.substringBefore(" (") else subjEn.substringBefore(" ("),
                        isSelected = selectedSectionalSubject == subjEn,
                        onClick = { selectedSectionalSubject = subjEn },
                        isDarkSurface = true,
                        badgeCountText = "$subjCount",
                        logoSize = 13.dp,
                        fontSize = 10.5.sp
                    )
                }
            }
        }

        // 3. Render the Full Package Test Cards for the Selected Tab (FLT, Sectional, Topic-Wise, 5-Yr PYQ, or Daily Quiz)
        filteredEntries.forEach { entry ->
            val isUnlocked = isSubscriptionActive || !entry.isPaidOnly
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 1.2.dp,
                        color = if (isUnlocked) EmeraldSuccess.copy(alpha = 0.85f) else EdTechProColors.WarmGold.copy(alpha = 0.75f),
                        shape = RoundedCornerShape(12.dp)
                    )
                    .clickable {
                        if (isUnlocked) {
                            val startCb = SubscriptionPassStateBridge.onStartAnyMockTestCallback
                            if (startCb != null) startCb(entry.mockTest) else onStartPaidMockTest()
                        } else {
                            triggerPaymentForPlan("MONTHLY_9")
                        }
                    }
                    .testTag("package_test_card_${entry.id}"),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = EdTechProColors.ElevatedNavy)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.weight(1f)
                        ) {
                            ShakuntalamBrandCrestBadge(size = 18.dp, showGlowRing = isUnlocked)
                            Spacer(modifier = Modifier.width(6.dp))
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(4.dp))
                                    .background(
                                        when (entry.packageCategory) {
                                            ExamPackageCategory.PYQ_5_YEAR -> Color(0xFFB45309)
                                            ExamPackageCategory.TOPIC_WISE -> Color(0xFF0369A1)
                                            ExamPackageCategory.SECTIONAL -> EdTechProColors.RoyalIndigo
                                            ExamPackageCategory.DAILY_PRACTICE -> EmeraldSuccess
                                            ExamPackageCategory.FULL_LENGTH -> Color(0xFF6D28D9)
                                        }
                                    )
                                    .padding(horizontal = 6.dp, vertical = 2.dp)
                            ) {
                                Text(
                                    text = if (isHi) entry.packageCategory.shortBadgeHi else entry.packageCategory.shortBadgeEn,
                                    fontSize = 9.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color.White
                                )
                            }
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = entry.pyqYear,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                color = EdTechProColors.ChampagneGold,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }

                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(5.dp))
                                .background(
                                    if (isUnlocked) EmeraldSuccess.copy(alpha = 0.22f)
                                    else EdTechProColors.WarmGold.copy(alpha = 0.2f)
                                )
                                .padding(horizontal = 7.dp, vertical = 2.5.dp)
                        ) {
                            Text(
                                text = if (isUnlocked) {
                                    if (isHi) "✓ अनलॉक" else "✓ UNLOCKED"
                                } else {
                                    if (isHi) "🔒 पेड पास" else "🔒 PAID PASS"
                                },
                                fontSize = 9.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = if (isUnlocked) Color(0xFF6EE7B7) else EdTechProColors.ChampagneGold
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = if (isHi) entry.mockTest.hindiTitle else entry.mockTest.title,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White,
                        lineHeight = 18.sp,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )

                    Spacer(modifier = Modifier.height(3.dp))

                    Text(
                        text = (if (isHi) entry.topicTagHi else entry.topicTagEn) +
                            " • ${entry.mockTest.questions.size} Qs • ${entry.mockTest.durationMinutes} Mins • +${entry.mockTest.positiveMarks}/-${entry.mockTest.negativeMarks}",
                        fontSize = 10.5.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF93C5FD),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = if (isHi)
                                "द्विभाषी (EN+HI) • कथन-आधारित + 5-वर्षीय PYQ व्याख्या"
                            else
                                "Bilingual (EN+HI) • Line-by-Line Statements + 5-Yr PYQ Solution",
                            fontSize = 9.5.sp,
                            color = Color(0xFFCBD5E1),
                            modifier = Modifier.weight(1f),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Button(
                            onClick = {
                                if (isUnlocked) {
                                    val startCb = SubscriptionPassStateBridge.onStartAnyMockTestCallback
                                    if (startCb != null) startCb(entry.mockTest) else onStartPaidMockTest()
                                } else {
                                    triggerPaymentForPlan("MONTHLY_9")
                                }
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (isUnlocked) EmeraldSuccess else SaffronGold
                            ),
                            shape = RoundedCornerShape(8.dp),
                            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp),
                            modifier = Modifier
                                .height(32.dp)
                                .testTag("start_pkg_test_btn_${entry.id}")
                        ) {
                            Icon(
                                imageVector = if (isUnlocked) Icons.Default.PlayArrow else Icons.Default.Lock,
                                contentDescription = null,
                                tint = if (isUnlocked) Color.White else Navy900,
                                modifier = Modifier.size(13.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = if (isUnlocked) {
                                    if (isHi) "Start Test (टेस्ट दें)" else "Start Test"
                                } else {
                                    if (isHi) "₹9 से अनलॉक करें" else "Pay ₹9 to Unlock"
                                },
                                fontSize = 10.5.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = if (isUnlocked) Color.White else Navy900,
                                maxLines = 1
                            )
                        }
                    }
                }
            }
        }

        // 4. Legacy Curated Paid Series Bundle Cards
        paidItems.forEach { item ->
            val isUnlocked = isSubscriptionActive || purchasedItemIds.contains(item.id)
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 1.5.dp,
                        color = if (isUnlocked) EmeraldSuccess else EdTechProColors.WarmGold,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .clickable {
                        if (isUnlocked) {
                            onStartPaidMockTest()
                        } else {
                            triggerPaymentForPlan("MONTHLY_9")
                        }
                    }
                    .testTag("paid_series_card_${item.id}"),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = EdTechProColors.DeepRoyalNavy)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.weight(1f)
                        ) {
                            ShakuntalamBrandCrestBadge(size = 18.dp, showGlowRing = isUnlocked)
                            Spacer(modifier = Modifier.width(6.dp))
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(4.dp))
                                    .background(if (isUnlocked) EmeraldSuccess else EdTechProColors.WarmGold)
                                    .padding(horizontal = 6.dp, vertical = 2.dp)
                            ) {
                                Text(
                                    text = if (isUnlocked) {
                                        if (isHi) "✓ अनलॉक (ALL-ACCESS)" else "✓ UNLOCKED"
                                    } else {
                                        "₹9/MO • ₹99/YR • ₹399 LIFE"
                                    },
                                    fontSize = 9.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = if (isUnlocked) Color.White else Navy900,
                                    maxLines = 1,
                                    softWrap = false
                                )
                            }
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = item.edition,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color(0xFF93C5FD),
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = null,
                                tint = SaffronGold,
                                modifier = Modifier.size(13.dp)
                            )
                            Spacer(modifier = Modifier.width(3.dp))
                            Text(
                                text = "${item.rating} (${item.reviewCount})",
                                fontSize = 10.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                maxLines = 1,
                                softWrap = false
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = if (isHi) item.hindiTitle else item.title,
                        fontSize = 13.5.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        lineHeight = 18.5.sp
                    )

                    Spacer(modifier = Modifier.height(3.dp))

                    Text(
                        text = item.totalPagesOrTests + " • " + item.medium,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = SaffronGold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            if (isUnlocked) {
                                Text(
                                    text = if (isHi)
                                        "सब्सक्रिप्शन सक्रिय ($remainingDays दिन शेष)"
                                    else
                                        "Pass Active ($remainingDays Days Left)",
                                    fontSize = 11.5.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = EmeraldSuccess,
                                    maxLines = 1,
                                    softWrap = false
                                )
                            } else {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text(
                                        text = "₹9/Mo",
                                        fontSize = 14.5.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = SaffronGold,
                                        maxLines = 1,
                                        softWrap = false
                                    )
                                    Spacer(modifier = Modifier.width(5.dp))
                                    Text(
                                        text = "• ₹99/Yr • ₹399 Life",
                                        fontSize = 11.5.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFF67E8F9),
                                        maxLines = 1,
                                        softWrap = false
                                    )
                                    Spacer(modifier = Modifier.width(5.dp))
                                    Text(
                                        text = "₹${item.originalPrice}",
                                        fontSize = 10.sp,
                                        color = Color(0xFF94A3B8),
                                        textDecoration = TextDecoration.LineThrough,
                                        maxLines = 1,
                                        softWrap = false
                                    )
                                }
                            }
                        }

                        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                            if (!isUnlocked) {
                                OutlinedButton(
                                    onClick = { triggerPaymentForPlan("YEARLY_99") },
                                    shape = RoundedCornerShape(8.dp),
                                    contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp),
                                    modifier = Modifier.height(34.dp)
                                ) {
                                    Text(
                                        text = if (isHi) "₹99/वर्ष" else "₹99/Yr",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = SaffronGold,
                                        maxLines = 1,
                                        softWrap = false
                                    )
                                }
                            }

                            Button(
                                onClick = {
                                    if (isUnlocked) {
                                        onStartPaidMockTest()
                                    } else {
                                        triggerPaymentForPlan("MONTHLY_9")
                                    }
                                },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = if (isUnlocked) EmeraldSuccess else SaffronGold
                                ),
                                shape = RoundedCornerShape(8.dp),
                                contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp),
                                modifier = Modifier
                                    .height(34.dp)
                                    .widthIn(min = 100.dp)
                            ) {
                                Icon(
                                    imageVector = if (isUnlocked) Icons.Default.PlayArrow else Icons.Default.LockOpen,
                                    contentDescription = null,
                                    tint = if (isUnlocked) Color.White else Navy900,
                                    modifier = Modifier.size(13.dp)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = if (isUnlocked) {
                                        if (isHi) "टेस्ट दें" else "Start Test"
                                    } else {
                                        if (isHi) "₹9/माह अनलॉक" else "Unlock ₹9/Mo"
                                    },
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = if (isUnlocked) Color.White else Navy900,
                                    maxLines = 1,
                                    softWrap = false
                                )
                            }
                        }
                    }
                }
            }
        }

        // Quick helper bar to switch to Free Subject-Wise & Topic-Wise PYQ Tests
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(EdTechProColors.ElevatedNavy)
                .border(1.dp, EdTechProColors.ElectricCyan.copy(alpha = 0.5f), RoundedCornerShape(8.dp))
                .clickable { onSwitchToFreeTests() }
                .padding(horizontal = 12.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = if (isHi)
                    "निःशुल्क डेली क्विज़, टॉपिक क्विज़ व फ्री PYQ हेतु '2. फ्री टेस्ट सीरीज़' खोलें ➔"
                else
                    "Switch to '2. Free Test Series' for Free Daily, Topic & PYQ Quizzes ➔",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF67E8F9),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

/**
 * Testbook-Beating Free Quiz & PYQ Hub + Free Shakuntalam Branded E-Book / PDF Notes Section
 * Displayed on the Home Dashboard so students can practice Free Daily Quizzes, Practice Quizzes,
 * Topic-Wise Quizzes (Indus Valley, Maurya, Gupta, Polity, DI Tables, JE, NEET), 5-Year PYQ Papers,
 * and download/read Free Shakuntalam Branded Notes PDFs for EVERY Indian exam!
 */
@Composable
fun AllIndiaTestbookSuperHubAndFreeNotesSection(
    selectedExamKey: String,
    isHi: Boolean,
    onSelectExamKey: (String) -> Unit,
    onStartMockTest: (MockTest) -> Unit,
    onReadFreeNoteInApp: (StudyItem) -> Unit,
    onDownloadFreePdfNote: (StudyItem) -> Unit,
    modifier: Modifier = Modifier
) {
    val examChips = listOf(
        "upsc" to "UPSC CSE",
        "up_police" to "UP Police Constable & SI",
        "uppcs" to "State PCS / UPPCS",
        "ukpsc" to "UKPSC",
        "bpsc" to "BPSC",
        "upsssc" to "UPSSSC PET/VDO",
        "uksssc" to "UKSSSC",
        "ssc" to "SSC CGL / CPO / CHSL",
        "railways" to "RRB & Engineering JE",
        "banking" to "Banking PO / Clerk",
        "iit_jee" to "IIT JEE & Technical JE",
        "neet" to "NEET UG Medical",
        "ugc_net" to "UGC NET / JRF",
        "tet" to "CTET / UPTET / TET"
    )
    val activeExam = selectedExamKey.lowercase().takeIf { key -> examChips.any { it.first == key } } ?: "upsc"
    var selectedCategoryTab by remember { mutableStateOf(ExamPackageCategory.FULL_LENGTH) }
    var selectedSubjectFilter by remember(activeExam, selectedCategoryTab) { mutableStateOf("ALL") }
    var showAllEntries by remember(activeExam, selectedCategoryTab) { mutableStateOf(false) }

    val blueprint = remember(activeExam) {
        AllIndiaMasterTestPackageData.getExamBlueprint(activeExam)
    }
    val allEntriesForExam = remember(activeExam) {
        AllIndiaMasterTestPackageData.getExamPackageEntries(activeExam)
    }
    val categoryEntries = remember(allEntriesForExam, selectedCategoryTab) {
        allEntriesForExam.filter { it.packageCategory == selectedCategoryTab }
    }
    val subjectGroups = remember(categoryEntries) {
        categoryEntries.map { it.subjectGroupEn to it.subjectGroupHi }.distinctBy { it.first }
    }
    val filteredEntries = remember(categoryEntries, selectedSubjectFilter) {
        if (selectedSubjectFilter == "ALL") {
            categoryEntries
        } else {
            categoryEntries.filter { it.subjectGroupEn == selectedSubjectFilter }
        }
    }
    val visibleEntries = remember(filteredEntries, showAllEntries) {
        if (showAllEntries) filteredEntries else filteredEntries.take(8)
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Part A: All-India Exam Center (50 Paid Tests: 20 FLT + 20 Sectional + 10 PYQ, plus Free Topic-Wise & Daily Quizzes)
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.5.dp, EdTechProColors.ElectricCyan, RoundedCornerShape(16.dp))
                .testTag("all_india_testbook_super_hub_card"),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = EdTechProColors.DeepRoyalNavy),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ShakuntalamBrandCrestBadge(size = 26.dp, showGlowRing = true)
                    Spacer(modifier = Modifier.width(8.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = if (isHi)
                                "ऑल-इंडिया सुपर टेस्ट सीरीज़ हब (50 पेड टेस्ट + फ्री टॉपिक/डेली क्विज़)"
                            else
                                "ALL-INDIA MASTER TEST SERIES HUB (50 PAID + FREE TOPIC & DAILY QUIZZES)",
                            fontSize = 12.5.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = EdTechProColors.WarmGold
                        )
                        Text(
                            text = if (isHi)
                                "UPSC • UP पुलिस • PCS • UPSSSC • UKSSSC • RRB • SSC CGL/CPO • Banking • JE • NEET • UGC NET"
                            else
                                "UPSC • UP Police • State PCS • UPSSSC • UKSSSC • RRB • SSC CGL/CPO • Banking • JE • NEET • UGC NET",
                            fontSize = 10.sp,
                            color = Color(0xFF67E8F9)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                // 14-Exam Selector Strip (including UP Police Constable & SI)
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(examChips) { (key, label) ->
                        ProfessionalTestSeriesTabChip(
                            label = label,
                            isSelected = activeExam == key,
                            onClick = { onSelectExamKey(key) },
                            isDarkSurface = true,
                            modifier = Modifier.testTag("super_hub_exam_chip_$key")
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Exam Blueprint Summary Strip (20 FLT + 20 Sectional + 10 PYQ = 50 Paid Tests + Free Topic/Daily)
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color(0xFF0F172A))
                        .border(1.dp, EdTechProColors.WarmGold.copy(alpha = 0.5f), RoundedCornerShape(10.dp))
                        .padding(horizontal = 10.dp, vertical = 7.dp)
                ) {
                    Text(
                        text = if (isHi)
                            "${blueprint.examTitleHi}: 50 पेड टेस्ट (20 FLT × ${blueprint.fltQuestionCount}Q + 20 सेक्शनल × ${blueprint.sectionalQuestionCount}Q + 10 PYQ × ${blueprint.fltQuestionCount}Q) + फ्री टॉपिक क्विज़"
                        else
                            "${blueprint.examTitleEn}: 50 Paid Tests (20 FLT × ${blueprint.fltQuestionCount}Q + 20 Sectional × ${blueprint.sectionalQuestionCount}Q + 10 PYQ × ${blueprint.fltQuestionCount}Q) + Free Quizzes",
                        fontSize = 10.5.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = EdTechProColors.ChampagneGold,
                        lineHeight = 15.sp
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = if (isHi)
                            "मार्किंग: +${blueprint.positiveMarks} / -${blueprint.negativeMarks} • स्तर: ${blueprint.difficultyLevelHi}"
                        else
                            "Marking: +${blueprint.positiveMarks} / -${blueprint.negativeMarks} • Level: ${blueprint.difficultyLevelEn}",
                        fontSize = 9.5.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF67E8F9)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                // 5 Quiz Type Tabs: Full-Length (20), Sectional (20), Previous Year (10), Topic-Wise (15), Daily & Practice (4)
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(ExamPackageCategory.entries) { cat ->
                        val count = allEntriesForExam.count { it.packageCategory == cat }
                        ProfessionalTestSeriesTabChip(
                            label = if (isHi) cat.labelHi else cat.labelEn,
                            isSelected = selectedCategoryTab == cat,
                            onClick = { selectedCategoryTab = cat },
                            isDarkSurface = true,
                            badgeCountText = "$count",
                            modifier = Modifier.testTag("super_hub_cat_tab_${cat.code.lowercase()}")
                        )
                    }
                }

                // Subject Breakdown Filter Row for Sectional & Topic-Wise Quizzes
                if (subjectGroups.size > 1) {
                    Spacer(modifier = Modifier.height(8.dp))
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        item {
                            ProfessionalTestSeriesTabChip(
                                label = if (isHi) "सभी विषय (${categoryEntries.size})" else "All Subjects (${categoryEntries.size})",
                                isSelected = selectedSubjectFilter == "ALL",
                                onClick = { selectedSubjectFilter = "ALL" },
                                isDarkSurface = true,
                                logoSize = 13.dp,
                                fontSize = 10.sp
                            )
                        }
                        items(subjectGroups) { (subjEn, subjHi) ->
                            val cnt = categoryEntries.count { it.subjectGroupEn == subjEn }
                            ProfessionalTestSeriesTabChip(
                                label = (if (isHi) subjHi.substringBefore(" (") else subjEn.substringBefore(" (")) + " ($cnt)",
                                isSelected = selectedSubjectFilter == subjEn,
                                onClick = { selectedSubjectFilter = subjEn },
                                isDarkSurface = true,
                                logoSize = 13.dp,
                                fontSize = 10.sp
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    visibleEntries.forEach { entry ->
                        val isUnlocked = !entry.isPaidOnly || SubscriptionPassStateBridge.isSubscriptionActive
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp))
                                .background(EdTechProColors.ElevatedNavy)
                                .border(
                                    1.dp,
                                    if (isUnlocked) EmeraldSuccess.copy(alpha = 0.6f) else EdTechProColors.WarmGold.copy(alpha = 0.6f),
                                    RoundedCornerShape(10.dp)
                                )
                                .clickable {
                                    if (isUnlocked) {
                                        onStartMockTest(entry.mockTest)
                                    } else {
                                        SubscriptionPassStateBridge.onInitiateSubscriptionCheckoutCallback?.invoke("MONTHLY_9")
                                    }
                                }
                                .padding(horizontal = 10.dp, vertical = 8.dp)
                                .testTag("super_hub_test_row_${entry.id}"),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Box(
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(4.dp))
                                            .background(if (entry.isPaidOnly && !isUnlocked) EdTechProColors.WarmGold else EmeraldSuccess)
                                            .padding(horizontal = 5.dp, vertical = 1.5.dp)
                                    ) {
                                        Text(
                                            text = if (!entry.isPaidOnly) "FREE QUIZ" else if (isUnlocked) "UNLOCKED" else "PAID ₹9 PASS",
                                            fontSize = 8.5.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            color = if (entry.isPaidOnly && !isUnlocked) Navy900 else Color.White
                                        )
                                    }
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text(
                                        text = if (isHi) entry.subjectGroupHi else entry.subjectGroupEn,
                                        fontSize = 9.5.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = EdTechProColors.ChampagneGold,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }
                                Spacer(modifier = Modifier.height(2.dp))
                                Text(
                                    text = if (isHi) entry.mockTest.hindiTitle else entry.mockTest.title,
                                    fontSize = 11.5.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color.White,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                                Text(
                                    text = "${if (isHi) entry.topicTagHi else entry.topicTagEn} • ${entry.mockTest.questions.size} Qs • ${entry.mockTest.durationMinutes} Mins • +${entry.mockTest.positiveMarks}/-${entry.mockTest.negativeMarks}",
                                    fontSize = 9.5.sp,
                                    color = Color(0xFF93C5FD),
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }

                            Spacer(modifier = Modifier.width(8.dp))

                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(if (isUnlocked) EmeraldSuccess else EdTechProColors.WarmGold)
                                    .padding(horizontal = 10.dp, vertical = 6.dp)
                            ) {
                                Text(
                                    text = if (isUnlocked) {
                                        if (isHi) "Start ▶" else "Start ▶"
                                    } else {
                                        if (isHi) "🔒 ₹9" else "🔒 ₹9"
                                    },
                                    fontSize = 10.5.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = if (isUnlocked) Color.White else Navy900
                                )
                            }
                        }
                    }
                }

                // Expand / Collapse all tests in this category (e.g., all 20 FLT or all 20 Sectional)
                if (filteredEntries.size > 8) {
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedButton(
                        onClick = { showAllEntries = !showAllEntries },
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(36.dp)
                            .testTag("super_hub_toggle_all_tests_btn")
                    ) {
                        Text(
                            text = if (showAllEntries) {
                                if (isHi) "कम दिखाएं (Show Less) ▲" else "Show Compact (Top 8) ▲"
                            } else {
                                if (isHi) "सभी ${filteredEntries.size} टेस्ट देखें (Show All ${filteredEntries.size} Tests) ▼" else "Show All ${filteredEntries.size} Tests in Category ▼"
                            },
                            fontSize = 11.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = EdTechProColors.ChampagneGold
                        )
                    }
                }
            }
        }

        // Part B: Free Notes & E-Book PDF Vault with Official Shakuntalam Branding
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.5.dp, EdTechProColors.WarmGold, RoundedCornerShape(16.dp))
                .testTag("shakuntalam_free_notes_pdf_vault_card"),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = EdTechProColors.DeepRoyalNavy),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ShakuntalamBrandCrestBadge(size = 26.dp, showGlowRing = true)
                    Spacer(modifier = Modifier.width(8.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = if (isHi)
                                "शकुंतलम फ्री नोट्स पीडीएफ एवं ई-बुक सेक्शन (100% Free Notes)"
                            else
                                "SHAKUNTALAM FREE E-BOOK NOTES & PDF DOWNLOAD VAULT",
                            fontSize = 12.5.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = EdTechProColors.ChampagneGold
                        )
                        Text(
                            text = if (isHi)
                                "शकुंतलम ब्रांडिंग के साथ सीधे ऐप में पढ़ें या फ्री PDF डाउनलोड करें"
                            else
                                "Read directly inside the app or download Free Shakuntalam Branded PDFs",
                            fontSize = 10.sp,
                            color = Color(0xFF6EE7B7)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    AllIndiaMasterTestPackageData.freeShakuntalamBrandedNotes.forEach { freeNote ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .border(1.dp, EdTechProColors.SlateBorder, RoundedCornerShape(10.dp))
                                .testTag("free_branded_note_${freeNote.id}"),
                            shape = RoundedCornerShape(10.dp),
                            colors = CardDefaults.cardColors(containerColor = EdTechProColors.ElevatedNavy)
                        ) {
                            Column(modifier = Modifier.padding(10.dp)) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        ShakuntalamBrandCrestBadge(size = 16.dp, showGlowRing = false)
                                        Spacer(modifier = Modifier.width(5.dp))
                                        Text(
                                            text = "SHAKUNTALAM OFFICIAL FREE PDF",
                                            fontSize = 9.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            color = EdTechProColors.WarmGold
                                        )
                                    }
                                    Box(
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(4.dp))
                                            .background(EmeraldSuccess)
                                            .padding(horizontal = 6.dp, vertical = 1.5.dp)
                                    ) {
                                        Text(
                                            text = "100% FREE",
                                            fontSize = 8.5.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            color = Color.White
                                        )
                                    }
                                }

                                Spacer(modifier = Modifier.height(4.dp))

                                Text(
                                    text = if (isHi) freeNote.hindiTitle else freeNote.title,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,
                                    lineHeight = 16.5.sp
                                )

                                Spacer(modifier = Modifier.height(6.dp))

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    Button(
                                        onClick = { onReadFreeNoteInApp(freeNote) },
                                        colors = ButtonDefaults.buttonColors(containerColor = EdTechProColors.RoyalIndigo),
                                        shape = RoundedCornerShape(8.dp),
                                        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp),
                                        modifier = Modifier
                                            .weight(1f)
                                            .height(34.dp)
                                            .border(1.dp, EdTechProColors.ElectricCyan, RoundedCornerShape(8.dp))
                                            .testTag("read_free_note_btn_${freeNote.id}")
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Book,
                                            contentDescription = null,
                                            tint = Color.White,
                                            modifier = Modifier.size(13.dp)
                                        )
                                        Spacer(modifier = Modifier.width(5.dp))
                                        Text(
                                            text = if (isHi) "ऐप में पढ़ें (Read E-Book)" else "Read In-App Free",
                                            fontSize = 10.5.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            color = Color.White,
                                            maxLines = 1
                                        )
                                    }

                                    Button(
                                        onClick = { onDownloadFreePdfNote(freeNote) },
                                        colors = ButtonDefaults.buttonColors(containerColor = EmeraldSuccess),
                                        shape = RoundedCornerShape(8.dp),
                                        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp),
                                        modifier = Modifier
                                            .weight(1f)
                                            .height(34.dp)
                                            .testTag("download_free_pdf_btn_${freeNote.id}")
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Download,
                                            contentDescription = null,
                                            tint = Color.White,
                                            modifier = Modifier.size(13.dp)
                                        )
                                        Spacer(modifier = Modifier.width(5.dp))
                                        Text(
                                            text = if (isHi) "फ्री PDF डाउनलोड" else "Download Free PDF",
                                            fontSize = 10.5.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            color = Color.White,
                                            maxLines = 1
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
