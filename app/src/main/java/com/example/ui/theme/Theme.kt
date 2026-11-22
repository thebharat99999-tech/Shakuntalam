package com.example.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF60A5FA),
    onPrimary = Navy900,
    primaryContainer = Navy800,
    onPrimaryContainer = Color(0xFFDBEAFE),
    secondary = SaffronGold,
    onSecondary = Color.Black,
    secondaryContainer = Color(0xFF452205),
    onSecondaryContainer = AmberLight,
    tertiary = EmeraldSuccess,
    background = NavyDarkBg,
    onBackground = TextDarkPrimary,
    surface = NavyDarkSurface,
    onSurface = TextDarkPrimary,
    surfaceVariant = NavyDarkCard,
    onSurfaceVariant = TextDarkSecondary
)

private val LightColorScheme = lightColorScheme(
    primary = Navy800,
    onPrimary = Color.White,
    primaryContainer = Navy50,
    onPrimaryContainer = Navy900,
    secondary = SaffronGold,
    onSecondary = Color.White,
    secondaryContainer = SaffronLight,
    onSecondaryContainer = Color(0xFF7C2D12),
    tertiary = EmeraldSuccess,
    background = BackgroundLight,
    onBackground = TextPrimary,
    surface = SurfaceLight,
    onSurface = TextPrimary,
    surfaceVariant = Color(0xFFF1F5F9),
    onSurfaceVariant = TextSecondary
)

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false, // Use intentional Shakuntalam brand colors
    content: @Composable () -> Unit,
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
