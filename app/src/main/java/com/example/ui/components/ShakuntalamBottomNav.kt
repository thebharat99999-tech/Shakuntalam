package com.example.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.Category
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Quiz
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.AppLanguage
import com.example.viewmodel.AppScreen

/**
 * Main Screen Bottom Navigation Bar allowing users to seamlessly toggle between
 * Home, Library, Test Series, Exams, and Profile tabs.
 */
@Composable
fun ShakuntalamBottomNav(
    currentScreen: AppScreen,
    cartCount: Int = 0,
    onNavigate: (AppScreen) -> Unit,
    language: AppLanguage = AppLanguage.HINDI,
    modifier: Modifier = Modifier
) {
    val isHi = language == AppLanguage.HINDI
    val itemColors = NavigationBarItemDefaults.colors(
        selectedIconColor = EdTechProColors.DeepRoyalNavy,
        selectedTextColor = EdTechProColors.WarmGold,
        indicatorColor = EdTechProColors.WarmGold,
        unselectedIconColor = Color(0xFF94A3B8),
        unselectedTextColor = Color(0xFFCBD5E1)
    )

    Column(modifier = modifier.fillMaxWidth()) {
        HorizontalDivider(
            thickness = 1.dp,
            color = EdTechProColors.WarmGold.copy(alpha = 0.35f)
        )
        NavigationBar(
            modifier = Modifier
                .fillMaxWidth()
                .testTag("bottom_navigation_bar"),
            windowInsets = WindowInsets.navigationBars,
            containerColor = EdTechProColors.DeepRoyalNavy,
            contentColor = Color.White,
            tonalElevation = 8.dp
        ) {
            // 1. Home Tab
            val isHomeSelected = currentScreen == AppScreen.HOME
            NavigationBarItem(
                selected = isHomeSelected,
                onClick = { onNavigate(AppScreen.HOME) },
                icon = {
                    Icon(
                        imageVector = if (isHomeSelected) Icons.Filled.Home else Icons.Outlined.Home,
                        contentDescription = if (isHi) "होम" else "Home",
                        modifier = Modifier.size(21.dp)
                    )
                },
                label = {
                    Text(
                        text = if (isHi) "होम" else "Home",
                        fontSize = 10.5.sp,
                        fontWeight = if (isHomeSelected) FontWeight.ExtraBold else FontWeight.Medium,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                colors = itemColors,
                modifier = Modifier.testTag("nav_home")
            )

            // 2. Library Tab (Primary Requested Tab)
            val isLibrarySelected = currentScreen == AppScreen.LIBRARY
            NavigationBarItem(
                selected = isLibrarySelected,
                onClick = { onNavigate(AppScreen.LIBRARY) },
                icon = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        ShakuntalamBrandCrestBadge(
                            size = 14.dp,
                            showGlowRing = isLibrarySelected
                        )
                        Spacer(modifier = Modifier.width(3.dp))
                        Icon(
                            imageVector = if (isLibrarySelected) Icons.Filled.Bookmark else Icons.Outlined.BookmarkBorder,
                            contentDescription = if (isHi) "लाइब्रेरी" else "Library",
                            modifier = Modifier.size(19.dp)
                        )
                    }
                },
                label = {
                    Text(
                        text = if (isHi) "लाइब्रेरी" else "Library",
                        fontSize = 10.5.sp,
                        fontWeight = if (isLibrarySelected) FontWeight.ExtraBold else FontWeight.Medium,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                colors = itemColors,
                modifier = Modifier.testTag("nav_library")
            )

            // 3. Test Series Tab (Primary Requested Tab)
            val isTestSeriesSelected = currentScreen == AppScreen.TEST_SERIES
            NavigationBarItem(
                selected = isTestSeriesSelected,
                onClick = { onNavigate(AppScreen.TEST_SERIES) },
                icon = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        ShakuntalamBrandCrestBadge(
                            size = 14.dp,
                            showGlowRing = isTestSeriesSelected
                        )
                        Spacer(modifier = Modifier.width(3.dp))
                        Icon(
                            imageVector = if (isTestSeriesSelected) Icons.Filled.Quiz else Icons.Outlined.Quiz,
                            contentDescription = if (isHi) "टेस्ट सीरीज़" else "Test Series",
                            modifier = Modifier.size(19.dp)
                        )
                    }
                },
                label = {
                    Text(
                        text = if (isHi) "टेस्ट सीरीज़" else "Test Series",
                        fontSize = 10.5.sp,
                        fontWeight = if (isTestSeriesSelected) FontWeight.ExtraBold else FontWeight.Medium,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                colors = itemColors,
                modifier = Modifier.testTag("nav_test_series")
            )

            // 4. Exams Explorer Tab
            val isExplorerSelected = currentScreen == AppScreen.EXPLORER
            NavigationBarItem(
                selected = isExplorerSelected,
                onClick = { onNavigate(AppScreen.EXPLORER) },
                icon = {
                    Icon(
                        imageVector = if (isExplorerSelected) Icons.Filled.Category else Icons.Outlined.Category,
                        contentDescription = if (isHi) "परीक्षाएं" else "Exams",
                        modifier = Modifier.size(20.dp)
                    )
                },
                label = {
                    Text(
                        text = if (isHi) "परीक्षाएं" else "Exams",
                        fontSize = 10.5.sp,
                        fontWeight = if (isExplorerSelected) FontWeight.ExtraBold else FontWeight.Medium,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                colors = itemColors,
                modifier = Modifier.testTag("nav_explorer")
            )

            // 5. Profile Tab (Primary Requested Tab)
            val isProfileSelected = currentScreen == AppScreen.PROFILE
            NavigationBarItem(
                selected = isProfileSelected,
                onClick = { onNavigate(AppScreen.PROFILE) },
                icon = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        ShakuntalamBrandCrestBadge(
                            size = 14.dp,
                            showGlowRing = isProfileSelected
                        )
                        Spacer(modifier = Modifier.width(3.dp))
                        Icon(
                            imageVector = if (isProfileSelected) Icons.Filled.Person else Icons.Outlined.Person,
                            contentDescription = if (isHi) "प्रोफाइल" else "Profile",
                            modifier = Modifier.size(19.dp)
                        )
                    }
                },
                label = {
                    Text(
                        text = if (isHi) "प्रोफाइल" else "Profile",
                        fontSize = 10.5.sp,
                        fontWeight = if (isProfileSelected) FontWeight.ExtraBold else FontWeight.Medium,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                colors = itemColors,
                modifier = Modifier.testTag("nav_profile")
            )
        }
    }
}
