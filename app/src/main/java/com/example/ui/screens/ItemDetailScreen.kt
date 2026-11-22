package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AutoStories
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.ContentType
import com.example.ui.theme.AmberGold
import com.example.ui.theme.AmberLight
import com.example.ui.theme.EmeraldLight
import com.example.ui.theme.EmeraldSuccess
import com.example.ui.theme.Navy100
import com.example.ui.theme.Navy800
import com.example.ui.theme.Navy900
import com.example.ui.theme.SaffronGold
import com.example.ui.theme.SaffronLight
import com.example.viewmodel.AppScreen
import com.example.viewmodel.ShakuntalamUiState
import com.example.viewmodel.ShakuntalamViewModel

@Composable
fun ItemDetailScreen(
    uiState: ShakuntalamUiState,
    viewModel: ShakuntalamViewModel,
    modifier: Modifier = Modifier
) {
    val isHi = uiState.selectedLanguage == com.example.model.AppLanguage.HINDI
    val item = uiState.selectedItem ?: return
    val isWishlisted = uiState.wishlistIds.contains(item.id)
    val isPurchased = uiState.purchasedItemIds.contains(item.id)
    val isInCart = uiState.cartItems.any { it.studyItem.id == item.id }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            // Sticky Purchase Bottom Bar
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = Color.White,
                shadowElevation = 8.dp
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Row(
                            verticalAlignment = Alignment.Bottom,
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Text(
                                text = "₹${item.discountedPrice}",
                                fontSize = 22.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Navy900
                            )
                            Text(
                                text = "₹${item.originalPrice}",
                                fontSize = 13.sp,
                                textDecoration = TextDecoration.LineThrough,
                                color = Color(0xFF94A3B8)
                            )
                        }
                        Text(
                            text = if (isHi) "GST शामिल • असीमित एक्सेस" else "GST Included • Lifetime Access",
                            fontSize = 10.5.sp,
                            color = EmeraldSuccess,
                            fontWeight = FontWeight.SemiBold
                        )
                    }

                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        if (!isPurchased) {
                            OutlinedButton(
                                onClick = {
                                    if (isInCart) {
                                        viewModel.navigateTo(AppScreen.CART)
                                    } else {
                                        viewModel.addToCart(item)
                                    }
                                },
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier
                                    .height(44.dp)
                                    .testTag("detail_add_cart")
                            ) {
                                Icon(
                                    imageVector = if (isInCart) Icons.Default.Check else Icons.Default.ShoppingBag,
                                    contentDescription = null,
                                    modifier = Modifier.size(16.dp),
                                    tint = if (isInCart) EmeraldSuccess else Navy900
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = if (isInCart) (if (isHi) "कार्ट देखें" else "View Cart") else (if (isHi) "कार्ट में डालें" else "Add to Cart"),
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (isInCart) EmeraldSuccess else Navy900
                                )
                            }

                            Button(
                                onClick = {
                                    viewModel.addToCart(item)
                                    viewModel.navigateTo(AppScreen.CART)
                                },
                                shape = RoundedCornerShape(10.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = SaffronGold),
                                modifier = Modifier
                                    .height(44.dp)
                                    .testTag("detail_buy_now")
                            ) {
                                Text(
                                    text = if (isHi) "अभी खरीदें" else "Buy Now",
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            }
                        } else {
                            Button(
                                onClick = {
                                    if (item.type == ContentType.EBOOK) {
                                        viewModel.openReader(item)
                                    } else {
                                        viewModel.startTest()
                                    }
                                },
                                shape = RoundedCornerShape(10.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = SaffronGold),
                                modifier = Modifier
                                    .height(44.dp)
                                    .testTag("detail_read_purchased")
                            ) {
                                Icon(
                                    imageVector = Icons.Default.AutoStories,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(18.dp)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = if (item.type == ContentType.EBOOK) (if (isHi) "अभी पढ़ें" else "Read Now") else (if (isHi) "टेस्ट दें" else "Start Test"),
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF8FAFC))
                .padding(innerPadding),
            contentPadding = PaddingValues(bottom = 24.dp)
        ) {
            // Top Bar
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .statusBarsPadding()
                        .padding(horizontal = 12.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(
                        onClick = { viewModel.navigateBack() },
                        modifier = Modifier.testTag("detail_back_button")
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Navy900
                        )
                    }

                    Row {
                        IconButton(onClick = { viewModel.toggleWishlist(item.id) }) {
                            Icon(
                                imageVector = if (isWishlisted) Icons.Default.Bookmark else Icons.Default.BookmarkBorder,
                                contentDescription = "Wishlist",
                                tint = if (isWishlisted) SaffronGold else Color(0xFF64748B)
                            )
                        }
                    }
                }
            }

            // Book Header / Visual Representation
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(
                            Brush.verticalGradient(
                                listOf(Navy900, Navy800)
                            )
                        )
                        .padding(20.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        // 3D-effect Book Spine Card
                        Box(
                            modifier = Modifier
                                .width(120.dp)
                                .height(165.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(
                                    Brush.verticalGradient(
                                        listOf(Color(item.accentColorHex), Navy900)
                                    )
                                )
                                .border(1.5.dp, Color(0x44FFFFFF), RoundedCornerShape(10.dp))
                                .padding(12.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier.fillMaxSize()
                            ) {
                                Text(
                                    text = "SHAKUNTALAM",
                                    color = AmberGold,
                                    fontSize = 9.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    letterSpacing = 1.sp
                                )
                                Icon(
                                    imageVector = if (item.type == ContentType.EBOOK) Icons.Default.AutoStories else Icons.Default.Quiz,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(42.dp)
                                )
                                Text(
                                    text = item.edition,
                                    color = Color(0xFFCBD5E1),
                                    fontSize = 8.5.sp,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(14.dp))

                        Text(
                            text = item.seriesName,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = SaffronGold
                        )
                        Text(
                            text = if (isHi) item.hindiTitle else item.title,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            lineHeight = 24.sp
                        )
                        Text(
                            text = if (isHi) item.title else item.hindiTitle,
                            fontSize = 13.sp,
                            color = Color(0xFFCBD5E1),
                            modifier = Modifier.padding(top = 4.dp)
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        // Chips Row
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(6.dp))
                                    .background(Color(0x33FFFFFF))
                                    .padding(horizontal = 8.dp, vertical = 4.dp)
                            ) {
                                Text(
                                    text = item.medium,
                                    fontSize = 11.sp,
                                    color = Color.White
                                )
                            }

                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(6.dp))
                                    .background(Color(0x33FFFFFF))
                                    .padding(horizontal = 8.dp, vertical = 4.dp)
                            ) {
                                Text(
                                    text = item.totalPagesOrTests,
                                    fontSize = 11.sp,
                                    color = Color.White
                                )
                            }

                            Row(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(6.dp))
                                    .background(AmberLight)
                                    .padding(horizontal = 8.dp, vertical = 4.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Star,
                                    contentDescription = null,
                                    tint = AmberGold,
                                    modifier = Modifier.size(13.dp)
                                )
                                Spacer(modifier = Modifier.width(3.dp))
                                Text(
                                    text = "${item.rating} (${item.reviewCount})",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF92400E)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(14.dp))

                        // Quick Sample Read / Demo Test Action
                        Button(
                            onClick = {
                                if (item.type == ContentType.EBOOK) {
                                    viewModel.openReader(item)
                                } else {
                                    viewModel.startTest()
                                }
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = SaffronGold),
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier.fillMaxWidth().testTag("detail_preview_sample")
                        ) {
                            Icon(
                                imageVector = Icons.Default.MenuBook,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = if (item.type == ContentType.EBOOK) {
                                    if (isHi) "मुफ्त सैंपल पढ़ें (Read Free Sample)" else "Read Free Sample Chapter"
                                } else {
                                    if (isHi) "फ्री डेमो टेस्ट शुरू करें" else "Attempt Free Demo Mock Test"
                                },
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        // Room DB Offline Cache Action Button
                        val isCachedOffline = if (item.type == ContentType.EBOOK) {
                            uiState.isEbookCachedOffline(item.id)
                        } else {
                            uiState.cachedOfflineTests.any { it.categoryId.equals(item.categoryId, ignoreCase = true) }
                        }

                        OutlinedButton(
                            onClick = {
                                if (item.type == ContentType.EBOOK) {
                                    viewModel.cacheStudyItemForOffline(item)
                                } else {
                                    val matchingTest = uiState.customTests.firstOrNull {
                                        it.categoryId.equals(item.categoryId, ignoreCase = true)
                                    } ?: com.example.data.ExamCatalogData.sampleMockTest
                                    viewModel.cacheMockTestForOffline(matchingTest)
                                }
                            },
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .testTag("detail_save_offline_btn")
                        ) {
                            Icon(
                                imageVector = if (isCachedOffline) Icons.Default.CheckCircle else Icons.Default.Check,
                                contentDescription = null,
                                tint = if (isCachedOffline) EmeraldSuccess else AmberGold,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = if (isCachedOffline) {
                                    if (isHi) "✓ Room DB में ऑफलाइन सेव है (Offline Ready)" else "✓ Saved in Room DB for Offline Access"
                                } else {
                                    if (isHi) "ऑफलाइन पढ़ने हेतु डाउनलोड करें (Room DB)" else "Download for Offline Access (Room Cache)"
                                },
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (isCachedOffline) EmeraldSuccess else Color.White
                            )
                        }
                    }
                }
            }

            // Description
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 12.dp),
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = if (isHi) "विवरण एवं पाठ्यक्रम कवरेज (Overview)" else "Overview & Syllabus Coverage",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = Navy900
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = item.description,
                            fontSize = 13.sp,
                            color = Color(0xFF334155),
                            lineHeight = 20.sp
                        )
                    }
                }
            }

            // Key Highlights / Features
            if (item.features.isNotEmpty()) {
                item {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 4.dp),
                        shape = RoundedCornerShape(14.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(
                                text = if (isHi) "मुख्य विशेषताएं (Key Highlights)" else "Key Highlights & Features",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                color = Navy900
                            )
                            Spacer(modifier = Modifier.height(10.dp))

                            item.features.forEach { feature ->
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 4.dp),
                                    verticalAlignment = Alignment.Top
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.CheckCircle,
                                        contentDescription = null,
                                        tint = EmeraldSuccess,
                                        modifier = Modifier.size(18.dp)
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(
                                        text = feature,
                                        fontSize = 12.5.sp,
                                        color = Color(0xFF1E293B)
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // Table of Contents / Chapters (If E-book)
            if (item.chapters.isNotEmpty()) {
                item {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 10.dp),
                        shape = RoundedCornerShape(14.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = if (isHi) "विषय सूची (Table of Contents)" else "Table of Contents",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Navy900
                                )
                                Text(
                                    text = if (isHi) "${item.chapters.size} अध्याय" else "${item.chapters.size} Chapters",
                                    fontSize = 12.sp,
                                    color = SaffronGold,
                                    fontWeight = FontWeight.Bold
                                )
                            }

                            Spacer(modifier = Modifier.height(10.dp))

                            item.chapters.forEachIndexed { index, chapter ->
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(8.dp))
                                        .background(if (index == 0) Color(0xFFF0FDF4) else Color(0xFFF8FAFC))
                                        .padding(10.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.weight(1f)
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .size(24.dp)
                                                .clip(CircleShape)
                                                .background(if (index == 0) EmeraldSuccess else Navy100),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text(
                                                text = "${chapter.chapterNumber}",
                                                fontSize = 11.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = if (index == 0) Color.White else Navy900
                                            )
                                        }

                                        Spacer(modifier = Modifier.width(10.dp))

                                        Column {
                                            Text(
                                                text = if (isHi) chapter.hindiTitle else chapter.title,
                                                fontSize = 12.5.sp,
                                                fontWeight = FontWeight.SemiBold,
                                                color = Navy900
                                            )
                                            Text(
                                                text = if (isHi) chapter.title else chapter.hindiTitle,
                                                fontSize = 10.5.sp,
                                                color = Color(0xFF64748B)
                                            )
                                        }
                                    }

                                    if (index == 0) {
                                        Box(
                                            modifier = Modifier
                                                .clip(RoundedCornerShape(4.dp))
                                                .background(EmeraldLight)
                                                .padding(horizontal = 6.dp, vertical = 2.dp)
                                        ) {
                                            Text(
                                                text = if (isHi) "मुफ्त सैंपल" else "Free Sample",
                                                fontSize = 9.5.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = EmeraldSuccess
                                            )
                                        }
                                    } else {
                                        Text(
                                            text = if (isHi) "${chapter.pageCount} पृष्ठ" else "${chapter.pageCount} Pages",
                                            fontSize = 11.sp,
                                            color = Color(0xFF94A3B8)
                                        )
                                    }
                                }
                                Spacer(modifier = Modifier.height(6.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}
