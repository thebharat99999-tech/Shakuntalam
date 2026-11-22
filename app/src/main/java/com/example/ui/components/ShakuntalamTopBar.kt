package com.example.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AdminPanelSettings
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.model.AppLanguage
import com.example.ui.theme.AmberGold
import com.example.ui.theme.Navy900
import com.example.ui.theme.SaffronGold
import com.example.viewmodel.AppScreen

@Composable
fun ShakuntalamTopBar(
    cartCount: Int,
    language: AppLanguage,
    isLoggedIn: Boolean = false,
    userName: String? = null,
    userAvatarLetter: String? = null,
    onNavigate: (AppScreen) -> Unit,
    onOpenSearch: () -> Unit,
    onToggleLanguage: () -> Unit,
    onOpenOwnerPortal: () -> Unit,
    onOpenAbout: () -> Unit,
    onOpenAuth: () -> Unit = {},
    onOpenProfile: () -> Unit = {},
    onOpenDownloads: () -> Unit = {}
) {
    val isHi = language == AppLanguage.HINDI

    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Navy900,
        tonalElevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .padding(horizontal = 12.dp, vertical = 10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Official Shakuntalam Winged-'S' & Book Crest Logo — Tapping opens the Testbook-Style Super Menu Drawer
                Box(
                    modifier = Modifier
                        .clickable {
                            HeaderLogoSuperMenuState.openDrawerToSection("HOME_OVERVIEW")
                        }
                        .testTag("top_bar_brand_logo")
                ) {
                    ShakuntalamBrandCrestBadge(
                        size = 40.dp,
                        showGlowRing = true
                    )
                }

                Spacer(modifier = Modifier.width(9.dp))

                // Brand Title & Tagline — Clicking also opens the Super Menu Drawer with all sections
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .clickable {
                            HeaderLogoSuperMenuState.openDrawerToSection("HOME_OVERVIEW")
                        }
                        .testTag("top_bar_brand_title_menu_trigger")
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "SHAKUNTALAM",
                            color = Color.White,
                            fontSize = 14.5.sp,
                            fontWeight = FontWeight.ExtraBold,
                            letterSpacing = 0.8.sp,
                            maxLines = 1,
                            softWrap = false
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "• शकुंतलम ▾",
                            color = Color(0xFFFDE68A),
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            maxLines = 1,
                            softWrap = false
                        )
                    }
                    Text(
                        text = if (isHi) "मेनू खोलें: टेस्ट • सब्सक्रिप्शन • मार्गदर्शन • संपर्क" else "TAP FOR MENU: TESTS • PASS • MARGDARSHAN • CONTACT",
                        color = SaffronGold,
                        fontSize = 9.sp,
                        fontWeight = FontWeight.ExtraBold,
                        letterSpacing = 0.4.sp,
                        maxLines = 1,
                        softWrap = false
                    )
                }

                Spacer(modifier = Modifier.width(6.dp))

                // Bilingual Language Switcher Button (EN / HI)
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0x33FFFFFF))
                        .border(1.dp, Color(0x44FFFFFF), RoundedCornerShape(8.dp))
                        .clickable(onClick = onToggleLanguage)
                        .padding(horizontal = 7.dp, vertical = 5.dp)
                        .testTag("top_language_toggle"),
                    contentAlignment = Alignment.Center
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Translate,
                            contentDescription = "Language",
                            tint = SaffronGold,
                            modifier = Modifier.size(12.dp)
                        )
                        Spacer(modifier = Modifier.width(3.dp))
                        Text(
                            text = if (isHi) "EN" else "हिंदी",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            maxLines = 1,
                            softWrap = false
                        )
                    }
                }

                Spacer(modifier = Modifier.width(4.dp))

                // User Profile / Login Pill Button
                if (isLoggedIn) {
                    Box(
                        modifier = Modifier
                            .size(30.dp)
                            .clip(CircleShape)
                            .background(SaffronGold)
                            .clickable(onClick = onOpenProfile)
                            .testTag("top_user_profile_avatar_btn"),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = userAvatarLetter ?: "B",
                            fontWeight = FontWeight.Bold,
                            color = Navy900,
                            fontSize = 12.sp
                        )
                    }
                } else {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(SaffronGold)
                            .clickable(onClick = onOpenAuth)
                            .padding(horizontal = 7.dp, vertical = 5.dp)
                            .testTag("top_login_btn"),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.AccountCircle,
                                contentDescription = "Login",
                                tint = Navy900,
                                modifier = Modifier.size(12.dp)
                            )
                            Spacer(modifier = Modifier.width(3.dp))
                            Text(
                                text = if (isHi) "लॉगिन" else "Login",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Navy900,
                                maxLines = 1,
                                softWrap = false
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.width(2.dp))

                // Owner / Publisher Portal Icon
                IconButton(
                    onClick = onOpenOwnerPortal,
                    modifier = Modifier
                        .size(32.dp)
                        .testTag("top_owner_portal_btn")
                ) {
                    Icon(
                        imageVector = Icons.Default.AdminPanelSettings,
                        contentDescription = "Owner PDF Portal",
                        tint = Color.White,
                        modifier = Modifier.size(19.dp)
                    )
                }

                // Cart Badge Button
                IconButton(
                    onClick = { onNavigate(AppScreen.CART) },
                    modifier = Modifier
                        .size(32.dp)
                        .testTag("top_cart_button")
                ) {
                    BadgedBox(
                        badge = {
                            if (cartCount > 0) {
                                Badge(
                                    containerColor = SaffronGold,
                                    contentColor = Color.White
                                ) {
                                    Text(
                                        text = cartCount.toString(),
                                        fontSize = 9.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.ShoppingCart,
                            contentDescription = "Shopping Cart",
                            tint = Color.White,
                            modifier = Modifier.size(19.dp)
                        )
                    }
                }

                // Download / Share Portal Icon
                IconButton(
                    onClick = onOpenDownloads,
                    modifier = Modifier
                        .size(30.dp)
                        .testTag("top_downloads_btn")
                ) {
                    Icon(
                        imageVector = Icons.Default.Download,
                        contentDescription = "Website & App Downloads",
                        tint = SaffronGold,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
        }
    }
}
