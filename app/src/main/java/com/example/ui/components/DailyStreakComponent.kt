package com.example.ui.components

import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MilitaryTech
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Stars
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material.icons.filled.WorkspacePremium
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.AmberGold
import com.example.ui.theme.EmeraldLight
import com.example.ui.theme.EmeraldSuccess
import com.example.ui.theme.Navy800
import com.example.ui.theme.Navy900
import com.example.ui.theme.SaffronGold
import com.example.viewmodel.ShakuntalamUiState
import java.time.LocalDate
import java.time.format.TextStyle
import java.time.temporal.ChronoUnit
import java.util.Locale

data class StreakRewardBadge(
    val id: String,
    val titleEn: String,
    val titleHi: String,
    val descriptionEn: String,
    val descriptionHi: String,
    val requiredStreakDays: Int,
    val requiredPoints: Int = 0,
    val bonusPoints: Int,
    val accentColorHex: Long,
    val tierCode: String
)

data class StreakDayStatus(
    val dateIso: String,
    val dayShortEn: String,
    val dayShortHi: String,
    val dayOfMonth: Int,
    val isCompleted: Boolean,
    val isToday: Boolean
)

object DailyStreakEngine {

    val allBadges: List<StreakRewardBadge> = listOf(
        StreakRewardBadge(
            id = "badge_first_spark",
            titleEn = "Ignited Aspirant",
            titleHi = "प्रथम संकल्प",
            descriptionEn = "Attempt your first daily quiz",
            descriptionHi = "अपना पहला दैनिक क्विज़ हल करें",
            requiredStreakDays = 1,
            bonusPoints = 50,
            accentColorHex = 0xFFF59E0B,
            tierCode = "DAY 1"
        ),
        StreakRewardBadge(
            id = "badge_3_day_warrior",
            titleEn = "3-Day Streak Warrior",
            titleHi = "3-दिवसीय योद्धा",
            descriptionEn = "Maintain a 3-day consecutive quiz streak",
            descriptionHi = "लगातार 3 दिन क्विज़ अभ्यास पूरा करें",
            requiredStreakDays = 3,
            bonusPoints = 150,
            accentColorHex = 0xFF10B981,
            tierCode = "3 DAYS"
        ),
        StreakRewardBadge(
            id = "badge_7_day_scholar",
            titleEn = "7-Day Weekly Scholar",
            titleHi = "सप्ताह के विद्वान",
            descriptionEn = "Complete 7 consecutive days of daily quizzes",
            descriptionHi = "लगातार 7 दिन दैनिक क्विज़ हल करें",
            requiredStreakDays = 7,
            bonusPoints = 350,
            accentColorHex = 0xFF3B82F6,
            tierCode = "7 DAYS"
        ),
        StreakRewardBadge(
            id = "badge_14_day_ace",
            titleEn = "14-Day Fortnight Ace",
            titleHi = "14-दिवसीय महारथी",
            descriptionEn = "Achieve a 14-day unbroken PYQ practice streak",
            descriptionHi = "लगातार 14 दिन PYQ टेस्ट अभ्यास करें",
            requiredStreakDays = 14,
            bonusPoints = 700,
            accentColorHex = 0xFF8B5CF6,
            tierCode = "14 DAYS"
        ),
        StreakRewardBadge(
            id = "badge_30_day_legend",
            titleEn = "30-Day Ranker Legend",
            titleHi = "30-दिवसीय टॉपर लीजेंड",
            descriptionEn = "Complete a 30-day unbroken preparation streak",
            descriptionHi = "30 दिनों की अटूट परीक्षा तैयारी स्ट्रीक",
            requiredStreakDays = 30,
            bonusPoints = 1500,
            accentColorHex = 0xFFEC4899,
            tierCode = "30 DAYS"
        ),
        StreakRewardBadge(
            id = "badge_quiz_centurion",
            titleEn = "500 XP Centurion",
            titleHi = "500 XP शताब्दी स्कोरर",
            descriptionEn = "Earn 500+ total quiz & streak reward points",
            descriptionHi = "500+ कुल क्विज़ एवं स्ट्रीक रिवॉर्ड पॉइंट्स अर्जित करें",
            requiredStreakDays = 1,
            requiredPoints = 500,
            bonusPoints = 200,
            accentColorHex = 0xFFEAB308,
            tierCode = "500+ XP"
        )
    )

    fun todayIsoDate(): String = LocalDate.now().toString()

    fun daysBetweenIso(fromDateIso: String, toDateIso: String): Long {
        if (fromDateIso.isBlank() || toDateIso.isBlank()) return -1L
        return runCatching {
            val from = LocalDate.parse(fromDateIso.trim())
            val to = LocalDate.parse(toDateIso.trim())
            ChronoUnit.DAYS.between(from, to)
        }.getOrDefault(-1L)
    }

    /**
     * Evaluates which badges should be unlocked given [streakDays] and [totalPoints].
     * Returns Pair(updatedUnlockedBadgeIds, newlyAwardedBadgeBonusPoints).
     */
    fun evaluateUnlockedBadges(
        streakDays: Int,
        totalPoints: Int,
        existingUnlockedIds: Set<String>
    ): Pair<Set<String>, Int> {
        val updated = existingUnlockedIds.toMutableSet()
        var newlyEarnedBonus = 0
        var runningPoints = totalPoints

        allBadges.forEach { badge ->
            if (!updated.contains(badge.id)) {
                val meetsStreak = streakDays >= badge.requiredStreakDays
                val meetsPoints = runningPoints >= badge.requiredPoints
                if (meetsStreak && meetsPoints) {
                    updated.add(badge.id)
                    newlyEarnedBonus += badge.bonusPoints
                    runningPoints += badge.bonusPoints
                }
            }
        }
        return updated to newlyEarnedBonus
    }

    fun getNextMilestoneBadge(streakDays: Int, unlockedIds: Set<String>): StreakRewardBadge? {
        return allBadges
            .filter { !unlockedIds.contains(it.id) && it.requiredPoints == 0 }
            .minByOrNull { it.requiredStreakDays }
            ?: allBadges.firstOrNull { !unlockedIds.contains(it.id) }
    }

    fun getAspirantRankTitle(points: Int, isHi: Boolean): String {
        return when {
            points >= 2000 -> if (isHi) "अखिल भारतीय रैंकर (All-India Topper)" else "All-India Topper League"
            points >= 1000 -> if (isHi) "मुख्य परीक्षा महारथी (Mains Master)" else "Mains Master Scholar"
            points >= 400 -> if (isHi) "प्रारंभिक योद्धा (Prelims Warrior)" else "Prelims Consistency Warrior"
            points >= 100 -> if (isHi) "नियमित अभ्यर्थी (Active Scholar)" else "Active Rising Aspirant"
            else -> if (isHi) "नव संकल्प अभ्यर्थी (Starter Aspirant)" else "Starter Exam Aspirant"
        }
    }

    fun buildLast7DaysSchedule(
        referenceDateIso: String,
        completedDates: Set<String>
    ): List<StreakDayStatus> {
        val refDate = runCatching { LocalDate.parse(referenceDateIso.trim()) }
            .getOrElse { LocalDate.now() }
        val hindiDays = mapOf(
            1 to "सोम",
            2 to "मंगल",
            3 to "बुध",
            4 to "गुरु",
            5 to "शुक्र",
            6 to "शनि",
            7 to "रवि"
        )
        return (6 downTo 0).map { offset ->
            val date = refDate.minusDays(offset.toLong())
            val iso = date.toString()
            val dow = date.dayOfWeek.value
            val shortEn = date.dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.ENGLISH).take(3)
            val shortHi = hindiDays[dow] ?: shortEn
            StreakDayStatus(
                dateIso = iso,
                dayShortEn = shortEn,
                dayShortHi = shortHi,
                dayOfMonth = date.dayOfMonth,
                isCompleted = completedDates.contains(iso),
                isToday = offset == 0
            )
        }
    }
}

/**
 * Prominent Daily Streak & Rewards Tracking Card displayed on the Main Dashboard.
 * Shows active streak days, XP reward points, 7-day quiz calendar strip,
 * milestone badges progress, and a 1-tap "Start Daily Quiz" button.
 */
@Composable
fun DailyStreakDashboardBanner(
    uiState: ShakuntalamUiState,
    isHi: Boolean,
    onStartDailyStreakQuiz: () -> Unit,
    modifier: Modifier = Modifier
) {
    var showBadgesDrawer by remember { mutableStateOf(false) }

    val streakDays = uiState.dailyStreakDays
    val longestStreak = uiState.longestStreakDays
    val points = uiState.rewardPoints
    val unlockedIds = uiState.unlockedStreakBadgeIds
    val todayCompleted = uiState.isTodayStreakCompleted

    val refDateIso = uiState.lastQuizAttemptDateIso.ifBlank { DailyStreakEngine.todayIsoDate() }
    val weekDays = remember(refDateIso, uiState.completedStreakDatesIso) {
        DailyStreakEngine.buildLast7DaysSchedule(
            referenceDateIso = DailyStreakEngine.todayIsoDate(),
            completedDates = uiState.completedStreakDatesIso
        )
    }

    val nextBadge = DailyStreakEngine.getNextMilestoneBadge(streakDays, unlockedIds)
    val rankTitle = DailyStreakEngine.getAspirantRankTitle(points, isHi)

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp)
            .border(
                width = 1.5.dp,
                color = if (todayCompleted) EmeraldSuccess.copy(alpha = 0.75f) else SaffronGold.copy(alpha = 0.85f),
                shape = RoundedCornerShape(20.dp)
            )
            .testTag("dashboard_daily_streak_banner"),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.verticalGradient(
                        listOf(Color(0xFF0F172A), Color(0xFF1E293B))
                    )
                )
                .padding(16.dp)
        ) {
            // Top Header: Streak Count Flame + XP Points + Today Status Pill
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    // Glowing Flame Badge
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .clip(CircleShape)
                            .background(
                                Brush.radialGradient(
                                    listOf(
                                        Color(0xFFF59E0B),
                                        Color(0xFFEA580C).copy(alpha = 0.25f)
                                    )
                                )
                            )
                            .border(1.5.dp, AmberGold, CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.LocalFireDepartment,
                            contentDescription = "Daily Streak Flame",
                            tint = Color.White,
                            modifier = Modifier.size(28.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    Column {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Text(
                                text = if (isHi)
                                    "$streakDays दिन की स्ट्रीक"
                                else
                                    "$streakDays Day Streak",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.White,
                                modifier = Modifier.testTag("dashboard_streak_count_text")
                            )

                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(6.dp))
                                    .background(
                                        if (todayCompleted) EmeraldSuccess.copy(alpha = 0.22f) else SaffronGold.copy(alpha = 0.22f)
                                    )
                                    .padding(horizontal = 7.dp, vertical = 2.dp)
                            ) {
                                Text(
                                    text = if (todayCompleted) {
                                        if (isHi) "✓ आज पूर्ण" else "✓ ACTIVE TODAY"
                                    } else {
                                        if (isHi) "⚡ आज बाकी" else "⚡ QUIZ PENDING"
                                    },
                                    fontSize = 9.5.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = if (todayCompleted) Color(0xFF34D399) else AmberGold
                                )
                            }
                        }

                        Text(
                            text = "$rankTitle • ${if (isHi) "सर्वश्रेष्ठ: $longestStreak दिन" else "Best: ${longestStreak}d"}",
                            fontSize = 11.sp,
                            color = Color(0xFFCBD5E1),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }

                // Reward Points & Badges Pill
                Column(
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color(0xFF090D16))
                        .border(1.dp, Color(0xFF334155), RoundedCornerShape(12.dp))
                        .clickable { showBadgesDrawer = !showBadgesDrawer }
                        .padding(horizontal = 10.dp, vertical = 6.dp)
                        .testTag("dashboard_streak_points_pill")
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Stars,
                            contentDescription = "Reward Points",
                            tint = AmberGold,
                            modifier = Modifier.size(15.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "$points XP",
                            fontSize = 13.5.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = AmberGold,
                            modifier = Modifier.testTag("dashboard_reward_points_text")
                        )
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.MilitaryTech,
                            contentDescription = null,
                            tint = Color(0xFF38BDF8),
                            modifier = Modifier.size(13.dp)
                        )
                        Spacer(modifier = Modifier.width(2.dp))
                        Text(
                            text = if (isHi)
                                "${unlockedIds.size}/${DailyStreakEngine.allBadges.size} बैज"
                            else
                                "${unlockedIds.size}/${DailyStreakEngine.allBadges.size} Badges",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF38BDF8)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // 7-Day Weekly Quiz Activity Strip
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFF090D16).copy(alpha = 0.65f))
                    .padding(horizontal = 10.dp, vertical = 10.dp)
                    .testTag("dashboard_weekly_streak_strip"),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                weekDays.forEach { day ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = if (isHi) day.dayShortHi else day.dayShortEn,
                            fontSize = 10.sp,
                            fontWeight = if (day.isToday) FontWeight.ExtraBold else FontWeight.Medium,
                            color = if (day.isToday) AmberGold else Color(0xFF94A3B8)
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Box(
                            modifier = Modifier
                                .size(30.dp)
                                .clip(CircleShape)
                                .background(
                                    when {
                                        day.isCompleted -> EmeraldSuccess
                                        day.isToday -> SaffronGold.copy(alpha = 0.25f)
                                        else -> Color(0xFF1E293B)
                                    }
                                )
                                .border(
                                    width = if (day.isToday) 1.5.dp else 1.dp,
                                    color = when {
                                        day.isCompleted -> Color(0xFF34D399)
                                        day.isToday -> AmberGold
                                        else -> Color(0xFF334155)
                                    },
                                    shape = CircleShape
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            if (day.isCompleted) {
                                Icon(
                                    imageVector = Icons.Default.Check,
                                    contentDescription = "Quiz Completed",
                                    tint = Color.White,
                                    modifier = Modifier.size(16.dp)
                                )
                            } else {
                                Text(
                                    text = "${day.dayOfMonth}",
                                    fontSize = 10.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (day.isToday) AmberGold else Color(0xFF64748B)
                                )
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Next Milestone Progress + Action Row
            if (nextBadge != null) {
                val targetDays = nextBadge.requiredStreakDays.coerceAtLeast(1)
                val progressFraction = (streakDays.toFloat() / targetDays.toFloat()).coerceIn(0f, 1f)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = if (isHi)
                            "अगला बैज: ${nextBadge.titleHi} (+${nextBadge.bonusPoints} XP)"
                        else
                            "Next Badge: ${nextBadge.titleEn} (+${nextBadge.bonusPoints} XP)",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFFE2E8F0)
                    )
                    Text(
                        text = "$streakDays / $targetDays ${if (isHi) "दिन" else "Days"}",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = AmberGold
                    )
                }
                Spacer(modifier = Modifier.height(5.dp))
                LinearProgressIndicator(
                    progress = { progressFraction },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(6.dp)
                        .clip(RoundedCornerShape(3.dp)),
                    color = SaffronGold,
                    trackColor = Color(0xFF334155)
                )
                Spacer(modifier = Modifier.height(12.dp))
            }

            // Bottom Action Row: Start Daily Quiz CTA + View Badges Toggle
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = onStartDailyStreakQuiz,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (todayCompleted) EmeraldSuccess else SaffronGold
                    ),
                    shape = RoundedCornerShape(10.dp),
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp),
                    modifier = Modifier
                        .weight(1f)
                        .height(40.dp)
                        .testTag("start_daily_streak_quiz_btn")
                ) {
                    Icon(
                        imageVector = if (todayCompleted) Icons.Default.Bolt else Icons.Default.PlayArrow,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(17.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = if (todayCompleted) {
                            if (isHi) "अतिरिक्त क्विज़ हल करें (+XP बोनस)" else "Practice Extra Quiz (+Bonus XP)"
                        } else {
                            if (isHi) "आज का डेली क्विज़ शुरू करें (+50 XP)" else "Attempt Daily Quiz (+50 XP)"
                        },
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Box(
                    modifier = Modifier
                        .height(40.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color(0xFF1E293B))
                        .border(1.dp, Color(0xFF475569), RoundedCornerShape(10.dp))
                        .clickable { showBadgesDrawer = !showBadgesDrawer }
                        .padding(horizontal = 10.dp)
                        .testTag("toggle_streak_badges_btn"),
                    contentAlignment = Alignment.Center
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.EmojiEvents,
                            contentDescription = "Badges",
                            tint = AmberGold,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = if (isHi) "बैज" else "Badges",
                            fontSize = 11.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Icon(
                            imageVector = if (showBadgesDrawer) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                            contentDescription = null,
                            tint = Color(0xFFCBD5E1),
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }

            // Expandable Milestone Badges & Rewards Drawer
            AnimatedVisibility(visible = showBadgesDrawer) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp)
                        .testTag("streak_badges_showcase_section")
                ) {
                    HorizontalDivider(color = Color(0xFF334155))
                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = if (isHi)
                                "दैनिक क्विज़ स्ट्रीक बैज एवं पुरस्कार (Streak Rewards)"
                            else
                                "Daily Streak Badges & XP Milestones",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = AmberGold
                        )
                        Text(
                            text = if (isHi)
                                "${unlockedIds.size} अनलॉक"
                            else
                                "${unlockedIds.size} Unlocked",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF34D399)
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        contentPadding = PaddingValues(vertical = 2.dp)
                    ) {
                        items(DailyStreakEngine.allBadges) { badge ->
                            val isUnlocked = unlockedIds.contains(badge.id)
                            val accent = Color(badge.accentColorHex)

                            Card(
                                modifier = Modifier
                                    .width(155.dp)
                                    .border(
                                        width = if (isUnlocked) 1.5.dp else 1.dp,
                                        color = if (isUnlocked) accent else Color(0xFF334155),
                                        shape = RoundedCornerShape(12.dp)
                                    )
                                    .testTag("streak_badge_card_${badge.id}"),
                                shape = RoundedCornerShape(12.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = if (isUnlocked) Color(0xFF1E293B) else Color(0xFF090D16)
                                )
                            ) {
                                Column(
                                    modifier = Modifier.padding(10.dp)
                                ) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .size(28.dp)
                                                .clip(CircleShape)
                                                .background(
                                                    if (isUnlocked) accent.copy(alpha = 0.22f) else Color(0xFF1E293B)
                                                ),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Icon(
                                                imageVector = if (isUnlocked) Icons.Default.WorkspacePremium else Icons.Default.Lock,
                                                contentDescription = null,
                                                tint = if (isUnlocked) accent else Color(0xFF64748B),
                                                modifier = Modifier.size(16.dp)
                                            )
                                        }

                                        Box(
                                            modifier = Modifier
                                                .clip(RoundedCornerShape(4.dp))
                                                .background(
                                                    if (isUnlocked) EmeraldSuccess.copy(alpha = 0.2f) else Color(0xFF1E293B)
                                                )
                                                .padding(horizontal = 6.dp, vertical = 2.dp)
                                        ) {
                                            Text(
                                                text = if (isUnlocked) "✓ +${badge.bonusPoints} XP" else "+${badge.bonusPoints} XP",
                                                fontSize = 9.5.sp,
                                                fontWeight = FontWeight.ExtraBold,
                                                color = if (isUnlocked) Color(0xFF34D399) else Color(0xFF94A3B8)
                                            )
                                        }
                                    }

                                    Spacer(modifier = Modifier.height(6.dp))

                                    Text(
                                        text = if (isHi) badge.titleHi else badge.titleEn,
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = if (isUnlocked) Color.White else Color(0xFF94A3B8),
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )

                                    Text(
                                        text = if (isHi) badge.descriptionHi else badge.descriptionEn,
                                        fontSize = 10.sp,
                                        color = Color(0xFF64748B),
                                        maxLines = 2,
                                        lineHeight = 13.sp,
                                        overflow = TextOverflow.Ellipsis,
                                        modifier = Modifier.padding(top = 2.dp)
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
