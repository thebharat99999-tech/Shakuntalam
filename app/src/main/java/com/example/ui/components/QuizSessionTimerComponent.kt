package com.example.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Alarm
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Speed
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.EmeraldSuccess
import com.example.ui.theme.SaffronGold
import com.example.viewmodel.ShakuntalamUiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive

/**
 * Formats seconds into MM:SS (when under 1 hour) or HH:MM:SS (when 1 hour or more).
 */
fun formatQuizCountdownTime(totalSeconds: Int): String {
    val safe = totalSeconds.coerceAtLeast(0)
    val hours = safe / 3600
    val minutes = (safe % 3600) / 60
    val seconds = safe % 60
    return if (hours > 0) {
        "%02d:%02d:%02d".format(hours, minutes, seconds)
    } else {
        "%02d:%02d".format(minutes, seconds)
    }
}

/**
 * Formats elapsed seconds into human-readable "Xm Ys" string.
 */
fun formatElapsedDuration(totalSeconds: Int): String {
    val safe = totalSeconds.coerceAtLeast(0)
    val hours = safe / 3600
    val minutes = (safe % 3600) / 60
    val seconds = safe % 60
    return when {
        hours > 0 -> "${hours}h ${minutes}m ${seconds}s"
        minutes > 0 -> "${minutes}m ${seconds}s"
        else -> "${seconds}s"
    }
}

/**
 * Real-time 1-second coroutine ticker + visual countdown timer & pacing telemetry bar
 * for the active quiz session.
 * Simulates real CBT exam hall conditions (Strict Exam Mode vs Practice Mode, duration presets,
 * per-question stopwatch, speed/question & live pacing indicator) and automatically triggers
 * auto-submission as soon as remaining time reaches 00:00.
 */
@Composable
fun QuizRealTimeCountdownBar(
    uiState: ShakuntalamUiState,
    isHi: Boolean,
    onTickSecond: () -> Unit,
    onTogglePauseResume: () -> Unit,
    onToggleStrictExamMode: () -> Unit = {},
    onSelectCustomDurationMinutes: (Int) -> Unit = {},
    onResetTimer: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    val remainingSeconds = uiState.testTimeRemainingSeconds.coerceAtLeast(0)
    val totalSeconds = uiState.testTotalDurationSeconds.coerceAtLeast(1)
    val isPaused = uiState.isTestTimerPaused
    val isSubmitted = uiState.isTestSubmitted
    val isStrictCbtMode = uiState.isStrictExamSimulationMode

    // Real-time 1-second countdown effect tied to active test session
    LaunchedEffect(
        uiState.activeTest.testId,
        isSubmitted,
        isPaused,
        uiState.isTestTimerRunning
    ) {
        if (!isSubmitted && !isPaused && uiState.isTestTimerRunning) {
            if (uiState.testTimeRemainingSeconds <= 0) {
                onTickSecond()
            } else {
                while (isActive && !uiState.isTestSubmitted && !uiState.isTestTimerPaused && uiState.isTestTimerRunning) {
                    delay(1000L)
                    onTickSecond()
                }
            }
        }
    }

    val urgency = uiState.timerUrgencyLevel()
    val isCritical = urgency == "CRITICAL"
    val isWarning = urgency == "WARNING"

    val accentColor by animateColorAsState(
        targetValue = when {
            isPaused -> Color(0xFF38BDF8)
            isCritical -> Color(0xFFEF4444)
            isWarning -> Color(0xFFF59E0B)
            else -> EmeraldSuccess
        },
        animationSpec = tween(durationMillis = 300),
        label = "quizTimerAccentColor"
    )

    val containerBgColor by animateColorAsState(
        targetValue = when {
            isCritical -> Color(0xFF450A0A)
            isWarning -> Color(0xFF422006)
            else -> Color(0xFF0F172A)
        },
        animationSpec = tween(durationMillis = 300),
        label = "quizTimerBgColor"
    )

    val remainingFraction by animateFloatAsState(
        targetValue = uiState.timerRemainingFraction(),
        animationSpec = tween(durationMillis = 350, easing = FastOutSlowInEasing),
        label = "quizTimerFraction"
    )

    val formattedTime = uiState.formattedRemainingTime()
    val elapsedSeconds = uiState.elapsedTestTimeSeconds()
    val currentQuestionSeconds = uiState.currentQuestionTimeSpentSeconds()
    val targetPerQSeconds = uiState.targetSecondsPerQuestion()
    val avgSecsPerAnswered = uiState.averageSecondsPerAnsweredQuestion()
    val pacingStatus = uiState.examPacingStatus()
    val totalConfiguredMinutes = (totalSeconds / 60).coerceAtLeast(1)

    val pacingColor = when (pacingStatus) {
        "AHEAD_OF_PACE" -> EmeraldSuccess
        "ON_TRACK" -> Color(0xFF38BDF8)
        else -> Color(0xFFF59E0B)
    }
    val pacingLabel = when (pacingStatus) {
        "AHEAD_OF_PACE" -> if (isHi) "तेज़ गति (Fast Pace)" else "Ahead of Pace"
        "ON_TRACK" -> if (isHi) "सही गति (On Track)" else "On Track"
        else -> if (isHi) "धीमी गति (Speed Up)" else "Behind Pace"
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(containerBgColor)
            .border(
                width = if (isCritical || isWarning) 1.5.dp else 1.dp,
                color = if (isCritical || isWarning) accentColor else Color(0xFF334155),
                shape = RoundedCornerShape(10.dp)
            )
            .padding(horizontal = 10.dp, vertical = 7.dp)
            .testTag("quiz_countdown_timer_card")
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Left: Live Timer Icon + Label + Status Pill
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
            ) {
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .clip(CircleShape)
                        .background(accentColor.copy(alpha = 0.2f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = when {
                            isCritical -> Icons.Default.Warning
                            isWarning -> Icons.Default.Alarm
                            else -> Icons.Default.Timer
                        },
                        contentDescription = "Quiz Countdown Timer",
                        tint = accentColor,
                        modifier = Modifier.size(14.dp)
                    )
                }

                Spacer(modifier = Modifier.width(7.dp))

                Column {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = if (isHi) "शेष समय (Time Left)" else "Remaining Time",
                            fontSize = 10.5.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White,
                            maxLines = 1,
                            softWrap = false
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(4.dp))
                                .background(accentColor.copy(alpha = 0.22f))
                                .padding(horizontal = 5.dp, vertical = 1.dp)
                                .testTag("quiz_timer_status_badge")
                        ) {
                            Text(
                                text = when {
                                    isPaused -> if (isHi) "रुका हुआ (PAUSED)" else "PAUSED"
                                    isCritical -> if (isHi) "अंतिम 1 मिनट • ऑटो-सबमिट" else "FINAL 1 MIN • AUTO-SUBMIT"
                                    isWarning -> if (isHi) "अंतिम 5 मिनट शेष" else "LOW TIME (< 5 MIN)"
                                    isStrictCbtMode -> if (isHi) "सख्त CBT परीक्षा मोड" else "STRICT CBT EXAM MODE"
                                    else -> if (isHi) "लाइव टाइमर • ऑटो-सबमिट" else "LIVE • AUTO-SUBMIT AT 00:00"
                                },
                                fontSize = 8.5.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = accentColor,
                                maxLines = 1,
                                softWrap = false
                            )
                        }
                    }

                    Text(
                        text = if (isHi)
                            "बीता समय: ${formatElapsedDuration(elapsedSeconds)} • कुल: $totalConfiguredMinutes मिनट"
                        else
                            "Elapsed: ${formatElapsedDuration(elapsedSeconds)} • Total: $totalConfiguredMinutes Mins",
                        fontSize = 9.5.sp,
                        color = Color(0xFF94A3B8),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            // Right: Digital Countdown Readout + Pause/Resume + Reset Actions
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(7.dp))
                        .background(Color(0xFF020617))
                        .border(1.dp, accentColor.copy(alpha = 0.75f), RoundedCornerShape(7.dp))
                        .padding(horizontal = 9.dp, vertical = 4.dp)
                        .testTag("quiz_remaining_time_badge"),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = formattedTime,
                        fontSize = 13.5.sp,
                        fontWeight = FontWeight.ExtraBold,
                        fontFamily = FontFamily.Monospace,
                        color = if (isCritical) Color(0xFFFCA5A5) else if (isWarning) Color(0xFFFDE68A) else Color(0xFF6EE7B7),
                        maxLines = 1,
                        softWrap = false,
                        modifier = Modifier.testTag("quiz_timer_display_text")
                    )
                }

                Box(
                    modifier = Modifier
                        .size(28.dp)
                        .clip(RoundedCornerShape(7.dp))
                        .background(if (isStrictCbtMode) Color(0xFF334155) else Color(0xFF1E293B))
                        .border(1.dp, Color(0xFF475569), RoundedCornerShape(7.dp))
                        .clickable { onTogglePauseResume() }
                        .testTag("quiz_timer_pause_resume_btn"),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = when {
                            isStrictCbtMode -> Icons.Default.Lock
                            isPaused -> Icons.Default.PlayArrow
                            else -> Icons.Default.Pause
                        },
                        contentDescription = if (isPaused) "Resume Timer" else "Pause Timer",
                        tint = if (isPaused || isStrictCbtMode) SaffronGold else Color.White,
                        modifier = Modifier.size(14.dp)
                    )
                }

                if (!isStrictCbtMode) {
                    Box(
                        modifier = Modifier
                            .size(28.dp)
                            .clip(RoundedCornerShape(7.dp))
                            .background(Color(0xFF1E293B))
                            .border(1.dp, Color(0xFF475569), RoundedCornerShape(7.dp))
                            .clickable { onResetTimer() }
                            .testTag("quiz_timer_reset_btn"),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Refresh,
                            contentDescription = "Reset Exam Timer",
                            tint = Color(0xFFCBD5E1),
                            modifier = Modifier.size(14.dp)
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(5.dp))

        // Linear Time Remaining Progress Bar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(5.dp)
                .clip(RoundedCornerShape(3.dp))
                .background(Color(0xFF1E293B))
                .testTag("quiz_timer_progress_bar")
        ) {
            if (remainingFraction > 0f) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(remainingFraction.coerceIn(0f, 1f))
                        .height(5.dp)
                        .clip(RoundedCornerShape(3.dp))
                        .background(accentColor)
                )
            }
        }

        Spacer(modifier = Modifier.height(6.dp))

        // Live Performance & Pacing Telemetry Strip (Current Q Stopwatch + Avg Speed + Exam Pacing + CBT Mode Toggle)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(5.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
            ) {
                // Active Question Time Spent vs Target
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(5.dp))
                        .background(Color(0xFF1E293B))
                        .padding(horizontal = 6.dp, vertical = 2.dp)
                        .testTag("quiz_current_question_time_badge")
                ) {
                    Text(
                        text = if (isHi)
                            "इस प्रश्न पर: ${currentQuestionSeconds}s / लक्ष्य ${targetPerQSeconds}s"
                        else
                            "Q Time: ${currentQuestionSeconds}s / ${targetPerQSeconds}s",
                        fontSize = 9.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = if (currentQuestionSeconds > targetPerQSeconds) Color(0xFFFDE68A) else Color(0xFFE2E8F0),
                        maxLines = 1,
                        softWrap = false
                    )
                }

                // Average Speed per Answered Question
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(5.dp))
                        .background(Color(0xFF1E293B))
                        .padding(horizontal = 6.dp, vertical = 2.dp)
                        .testTag("quiz_avg_speed_badge")
                ) {
                    Text(
                        text = if (isHi) "औसत: ${avgSecsPerAnswered}s/प्र." else "Avg: ${avgSecsPerAnswered}s/Q",
                        fontSize = 9.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFFCBD5E1),
                        maxLines = 1,
                        softWrap = false
                    )
                }

                // Live Exam Pacing Status Pill
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(5.dp))
                        .background(pacingColor.copy(alpha = 0.18f))
                        .border(0.8.dp, pacingColor.copy(alpha = 0.6f), RoundedCornerShape(5.dp))
                        .padding(horizontal = 6.dp, vertical = 2.dp)
                        .testTag("quiz_pacing_status_badge")
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Speed,
                            contentDescription = null,
                            tint = pacingColor,
                            modifier = Modifier.size(10.dp)
                        )
                        Spacer(modifier = Modifier.width(3.dp))
                        Text(
                            text = pacingLabel,
                            fontSize = 8.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = pacingColor,
                            maxLines = 1,
                            softWrap = false
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.width(4.dp))

            // Strict CBT Mode vs Practice Mode Toggle Pill
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(5.dp))
                    .background(if (isStrictCbtMode) SaffronGold.copy(alpha = 0.22f) else Color(0xFF1E293B))
                    .border(
                        width = 0.8.dp,
                        color = if (isStrictCbtMode) SaffronGold else Color(0xFF475569),
                        shape = RoundedCornerShape(5.dp)
                    )
                    .clickable { onToggleStrictExamMode() }
                    .padding(horizontal = 6.dp, vertical = 2.dp)
                    .testTag("quiz_strict_cbt_mode_toggle")
            ) {
                Text(
                    text = if (isStrictCbtMode) {
                        if (isHi) "CBT मोड: लॉक" else "Strict CBT"
                    } else {
                        if (isHi) "अभ्यास मोड" else "Practice"
                    },
                    fontSize = 8.5.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = if (isStrictCbtMode) SaffronGold else Color(0xFF94A3B8),
                    maxLines = 1,
                    softWrap = false
                )
            }
        }

        // Practice Mode Exam Duration Presets (15m, 30m, 60m, 120m, 180m)
        if (!isStrictCbtMode) {
            Spacer(modifier = Modifier.height(5.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = if (isHi) "समय-सीमा (Exam Timer Preset):" else "Exam Duration Preset:",
                    fontSize = 8.5.sp,
                    color = Color(0xFF94A3B8),
                    fontWeight = FontWeight.Medium
                )
                Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    listOf(15, 30, 60, 120, 180).forEach { mins ->
                        val isSelected = totalConfiguredMinutes == mins
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(4.dp))
                                .background(if (isSelected) SaffronGold else Color(0xFF1E293B))
                                .clickable { onSelectCustomDurationMinutes(mins) }
                                .padding(horizontal = 6.dp, vertical = 1.5.dp)
                                .testTag("quiz_duration_preset_${mins}m")
                        ) {
                            Text(
                                text = "${mins}m",
                                fontSize = 8.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (isSelected) Color(0xFF0F172A) else Color(0xFFCBD5E1)
                            )
                        }
                    }
                }
            }
        }
    }
}

/**
 * Banner displayed on the Test Scorecard when a test session was automatically submitted
 * due to the countdown timer reaching 00:00.
 */
@Composable
fun AutoSubmitTimeoutBanner(
    isHi: Boolean,
    totalDurationMinutes: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFFFEF2F2))
            .border(1.5.dp, Color(0xFFEF4444), RoundedCornerShape(12.dp))
            .padding(horizontal = 14.dp, vertical = 10.dp)
            .testTag("quiz_auto_submit_banner"),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(32.dp)
                .clip(CircleShape)
                .background(Color(0xFFFEE2E2)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Alarm,
                contentDescription = "Time Expired Auto Submitted",
                tint = Color(0xFFDC2626),
                modifier = Modifier.size(18.dp)
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = if (isHi)
                    "समय समाप्त! टेस्ट स्वतः सबमिट किया गया (Auto-Submitted on Time Expiry)"
                else
                    "Time Expired (00:00) — Test Automatically Submitted",
                fontSize = 12.5.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFF991B1B)
            )
            Text(
                text = if (isHi)
                    "निर्धारित $totalDurationMinutes मिनट की समय-सीमा पूरी होने पर आपके सभी चिह्नित उत्तर सुरक्षित रूप से सबमिट कर दिए गए हैं।"
                else
                    "Your marked responses were automatically saved and evaluated when the $totalDurationMinutes-minute test timer expired.",
                fontSize = 11.sp,
                color = Color(0xFF7F1D1D),
                lineHeight = 15.sp
            )
        }
    }
}
