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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoStories
import androidx.compose.material.icons.filled.CloudDone
import androidx.compose.material.icons.filled.CloudDownload
import androidx.compose.material.icons.filled.CloudOff
import androidx.compose.material.icons.filled.DeleteOutline
import androidx.compose.material.icons.filled.DownloadDone
import androidx.compose.material.icons.filled.OfflinePin
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.Storage
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.data.local.entity.OfflineEbookCacheEntity
import com.example.data.local.entity.OfflineTestCacheEntity
import com.example.model.ContentType
import com.example.model.MockTest
import com.example.model.StudyItem
import com.example.ui.theme.EmeraldLight
import com.example.ui.theme.EmeraldSuccess
import com.example.ui.theme.Navy800
import com.example.ui.theme.Navy900
import com.example.ui.theme.SaffronGold
import com.example.viewmodel.ShakuntalamUiState

/**
 * Top Room Offline Cache Status & Connectivity Control Card.
 * Displays Room SQLite cache metrics, Offline Mode toggle, and 1-tap bulk offline download.
 */
@Composable
fun OfflineRoomCacheStatusCard(
    uiState: ShakuntalamUiState,
    isHi: Boolean,
    onToggleOfflineMode: (Boolean) -> Unit,
    onDownloadAllCoreOffline: () -> Unit,
    onClearAllCache: () -> Unit,
    modifier: Modifier = Modifier
) {
    val isOffline = uiState.isOfflineModeActive
    val ebookCount = uiState.cachedOfflineEbooks.size
    val testCount = uiState.cachedOfflineTests.size
    val totalSize = uiState.totalOfflineCacheSizeFormatted()

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp)
            .border(
                width = 1.5.dp,
                color = if (isOffline) SaffronGold else EmeraldSuccess.copy(alpha = 0.7f),
                shape = RoundedCornerShape(16.dp)
            )
            .testTag("offline_room_cache_status_card"),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    Box(
                        modifier = Modifier
                            .size(38.dp)
                            .clip(CircleShape)
                            .background(
                                if (isOffline) SaffronGold.copy(alpha = 0.2f) else EmeraldSuccess.copy(alpha = 0.2f)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = if (isOffline) Icons.Default.CloudOff else Icons.Default.OfflinePin,
                            contentDescription = "Offline Room Cache",
                            tint = if (isOffline) SaffronGold else EmeraldSuccess,
                            modifier = Modifier.size(22.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        Text(
                            text = if (isHi)
                                "ROOM DB लोकल ऑफलाइन कैश (OFFLINE ACCESS)"
                            else
                                "ROOM DB LOCAL OFFLINE CACHE VAULT",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = SaffronGold,
                            letterSpacing = 0.5.sp
                        )
                        Text(
                            text = if (isOffline) {
                                if (isHi) "ऑफलाइन मोड सक्रिय (बिना इंटरनेट पढ़ाई)" else "Offline Mode Active (No Internet Needed)"
                            } else {
                                if (isHi) "ऑनलाइन + ऑफलाइन बैकअप तैयार" else "Online • Offline Room Cache Ready"
                            },
                            fontSize = 13.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }

                // Offline Mode Switch
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.testTag("offline_mode_toggle_btn")
                ) {
                    Text(
                        text = if (isHi) "ऑफलाइन" else "Offline",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (isOffline) SaffronGold else Color(0xFFCBD5E1)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Switch(
                        checked = isOffline,
                        onCheckedChange = { onToggleOfflineMode(it) },
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = Navy900,
                            checkedTrackColor = SaffronGold,
                            uncheckedThumbColor = Color.White,
                            uncheckedTrackColor = Color(0xFF334155)
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // 3-Column Room Cache Storage Summary
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFF1E293B))
                    .padding(vertical = 10.dp, horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "$ebookCount",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = SaffronGold,
                        modifier = Modifier.testTag("offline_cached_ebooks_count")
                    )
                    Text(
                        text = if (isHi) "ऑफलाइन ई-बुक्स" else "Cached E-Books",
                        fontSize = 10.sp,
                        color = Color(0xFF94A3B8)
                    )
                }

                Box(
                    modifier = Modifier
                        .width(1.dp)
                        .height(26.dp)
                        .background(Color(0xFF334155))
                )

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "$testCount",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = EmeraldSuccess,
                        modifier = Modifier.testTag("offline_cached_tests_count")
                    )
                    Text(
                        text = if (isHi) "ऑफलाइन टेस्ट" else "Cached Tests",
                        fontSize = 10.sp,
                        color = Color(0xFF94A3B8)
                    )
                }

                Box(
                    modifier = Modifier
                        .width(1.dp)
                        .height(26.dp)
                        .background(Color(0xFF334155))
                )

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = totalSize,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF38BDF8),
                        modifier = Modifier.testTag("offline_cache_size_text")
                    )
                    Text(
                        text = if (isHi) "Room DB स्टोरेज" else "Room DB Storage",
                        fontSize = 10.sp,
                        color = Color(0xFF94A3B8)
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Action Buttons: Download All Core Pack & Clear Cache
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = onDownloadAllCoreOffline,
                    colors = ButtonDefaults.buttonColors(containerColor = EmeraldSuccess),
                    shape = RoundedCornerShape(10.dp),
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp),
                    modifier = Modifier
                        .weight(1f)
                        .height(38.dp)
                        .testTag("download_all_offline_btn")
                ) {
                    Icon(
                        imageVector = Icons.Default.CloudDownload,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = if (isHi)
                            "सभी ई-बुक्स व टेस्ट ऑफलाइन सेव करें"
                        else
                            "Cache Core E-Books & Tests Offline",
                        fontSize = 11.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        maxLines = 1,
                        softWrap = false,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                if (ebookCount > 0 || testCount > 0) {
                    OutlinedButton(
                        onClick = onClearAllCache,
                        shape = RoundedCornerShape(10.dp),
                        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 6.dp),
                        modifier = Modifier
                            .height(38.dp)
                            .testTag("clear_all_offline_cache_btn")
                    ) {
                        Icon(
                            imageVector = Icons.Default.DeleteOutline,
                            contentDescription = "Clear Offline Cache",
                            tint = Color(0xFFFCA5A5),
                            modifier = Modifier.size(15.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = if (isHi) "कैश हटाएं" else "Clear",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFFCA5A5)
                        )
                    }
                }
            }
        }
    }
}

/**
 * Complete Offline Vault view displaying Room-cached E-Books, Room-cached Test Series,
 * and quick 1-tap offline download cards for any un-cached materials.
 */
@Composable
fun OfflineVaultContentList(
    uiState: ShakuntalamUiState,
    isHi: Boolean,
    onOpenOfflineEbook: (OfflineEbookCacheEntity) -> Unit,
    onRemoveOfflineEbook: (String) -> Unit,
    onStartOfflineTest: (OfflineTestCacheEntity) -> Unit,
    onRemoveOfflineTest: (String) -> Unit,
    onCacheStudyItem: (StudyItem) -> Unit,
    onCacheMockTest: (MockTest) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // 1. Downloaded E-Books in Room Local Cache
        Text(
            text = if (isHi)
                "1. ऑफलाइन उपलब्ध ई-बुक्स (Downloaded E-Books in Room DB: ${uiState.cachedOfflineEbooks.size})"
            else
                "1. Downloaded E-Books for Offline Reading (${uiState.cachedOfflineEbooks.size})",
            fontSize = 13.5.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Navy900
        )

        if (uiState.cachedOfflineEbooks.isEmpty()) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Text(
                    text = if (isHi)
                        "अभी कोई ई-बुक ऑफलाइन कैश में नहीं है। नीचे दिए गए 'Save Offline' बटन पर टैप करें।"
                    else
                        "No E-Books cached offline yet. Tap 'Save Offline' on any book or use the bulk cache button above.",
                    fontSize = 12.sp,
                    color = Color(0xFF64748B),
                    modifier = Modifier.padding(14.dp)
                )
            }
        } else {
            uiState.cachedOfflineEbooks.forEach { cachedBook ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("offline_cached_ebook_${cachedBook.itemId}"),
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(6.dp))
                                    .background(EmeraldLight)
                                    .padding(horizontal = 8.dp, vertical = 3.dp)
                            ) {
                                Text(
                                    text = if (isHi) "✓ ऑफलाइन उपलब्ध (Room DB)" else "✓ Offline Ready • Room Cached",
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = EmeraldSuccess
                                )
                            }
                            Text(
                                text = "${cachedBook.cacheSizeKb} KB • ${cachedBook.medium}",
                                fontSize = 10.5.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color(0xFF64748B)
                            )
                        }

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = if (isHi) cachedBook.hindiTitle else cachedBook.title,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Navy900
                        )
                        Text(
                            text = "${cachedBook.seriesName} • ${cachedBook.totalPagesOrTests}",
                            fontSize = 11.5.sp,
                            color = Color(0xFF475569)
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Button(
                                onClick = { onOpenOfflineEbook(cachedBook) },
                                colors = ButtonDefaults.buttonColors(containerColor = Navy900),
                                shape = RoundedCornerShape(8.dp),
                                modifier = Modifier
                                    .weight(1f)
                                    .height(38.dp)
                                    .testTag("read_offline_ebook_${cachedBook.itemId}")
                            ) {
                                Icon(
                                    imageVector = Icons.Default.AutoStories,
                                    contentDescription = null,
                                    tint = SaffronGold,
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = if (isHi) "ऑफलाइन पढ़ें (Read Offline)" else "Read Offline (No Internet)",
                                    fontSize = 11.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,
                                    maxLines = 1,
                                    softWrap = false
                                )
                            }

                            OutlinedButton(
                                onClick = { onRemoveOfflineEbook(cachedBook.itemId) },
                                shape = RoundedCornerShape(8.dp),
                                contentPadding = PaddingValues(horizontal = 10.dp),
                                modifier = Modifier
                                    .height(38.dp)
                                    .testTag("remove_offline_ebook_${cachedBook.itemId}")
                            ) {
                                Icon(
                                    imageVector = Icons.Default.DeleteOutline,
                                    contentDescription = "Remove Offline Ebook",
                                    tint = Color(0xFFDC2626),
                                    modifier = Modifier.size(16.dp)
                                )
                            }
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(4.dp))

        // 2. Downloaded Test Series in Room Local Cache
        Text(
            text = if (isHi)
                "2. ऑफलाइन उपलब्ध टेस्ट सीरीज़ (Downloaded Tests in Room DB: ${uiState.cachedOfflineTests.size})"
            else
                "2. Downloaded Test Materials for Offline Practice (${uiState.cachedOfflineTests.size})",
            fontSize = 13.5.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Navy900
        )

        if (uiState.cachedOfflineTests.isEmpty()) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Text(
                    text = if (isHi)
                        "अभी कोई टेस्ट ऑफलाइन कैश में नहीं है। नीचे किसी भी टेस्ट को ऑफलाइन सेव करें।"
                    else
                        "No test series cached offline yet. Save any mock test below for offline practice.",
                    fontSize = 12.sp,
                    color = Color(0xFF64748B),
                    modifier = Modifier.padding(14.dp)
                )
            }
        } else {
            uiState.cachedOfflineTests.forEach { cachedTest ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("offline_cached_test_${cachedTest.testId}"),
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(6.dp))
                                    .background(Color(0xFFFEF3C7))
                                    .padding(horizontal = 8.dp, vertical = 3.dp)
                            ) {
                                Text(
                                    text = "✓ Offline CBT Ready • ${cachedTest.questionCount} PYQs",
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color(0xFFB45309)
                                )
                            }
                            Text(
                                text = "${cachedTest.cacheSizeKb} KB • ${cachedTest.durationMinutes} Mins",
                                fontSize = 10.5.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color(0xFF64748B)
                            )
                        }

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = if (isHi) cachedTest.hindiTitle else cachedTest.title,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Navy900
                        )
                        Text(
                            text = "${cachedTest.examName} • ${cachedTest.totalMarks} Marks (+${cachedTest.positiveMarks} / -${cachedTest.negativeMarks})",
                            fontSize = 11.5.sp,
                            color = Color(0xFF475569)
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Button(
                                onClick = { onStartOfflineTest(cachedTest) },
                                colors = ButtonDefaults.buttonColors(containerColor = EmeraldSuccess),
                                shape = RoundedCornerShape(8.dp),
                                modifier = Modifier
                                    .weight(1f)
                                    .height(38.dp)
                                    .testTag("start_offline_test_${cachedTest.testId}")
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Quiz,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = if (isHi) "ऑफलाइन टेस्ट शुरू करें" else "Start Offline Test",
                                    fontSize = 11.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,
                                    maxLines = 1,
                                    softWrap = false
                                )
                            }

                            OutlinedButton(
                                onClick = { onRemoveOfflineTest(cachedTest.testId) },
                                shape = RoundedCornerShape(8.dp),
                                contentPadding = PaddingValues(horizontal = 10.dp),
                                modifier = Modifier
                                    .height(38.dp)
                                    .testTag("remove_offline_test_${cachedTest.testId}")
                            ) {
                                Icon(
                                    imageVector = Icons.Default.DeleteOutline,
                                    contentDescription = "Remove Offline Test",
                                    tint = Color(0xFFDC2626),
                                    modifier = Modifier.size(16.dp)
                                )
                            }
                        }
                    }
                }
            }
        }

        // 3. Quick Download Section for Uncached E-Books & Mock Tests
        val uncachedEbooks = uiState.customStudyItems.filter {
            it.type == ContentType.EBOOK && !uiState.isEbookCachedOffline(it.id)
        }.take(4)
        val uncachedTests = uiState.customTests.filter {
            !uiState.isTestCachedOffline(it.testId)
        }.take(4)

        if (uncachedEbooks.isNotEmpty() || uncachedTests.isNotEmpty()) {
            Spacer(modifier = Modifier.height(4.dp))
            HorizontalDivider(color = Color(0xFFE2E8F0))
            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = if (isHi)
                    "3. ऑफलाइन डाउनलोड हेतु उपलब्ध सामग्री (Tap to Cache in Room DB)"
                else
                    "3. Available to Download for Offline Access",
                fontSize = 13.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Navy800
            )

            uncachedEbooks.forEach { book ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.White)
                        .border(1.dp, Color(0xFFE2E8F0), RoundedCornerShape(10.dp))
                        .padding(horizontal = 12.dp, vertical = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = if (isHi) book.hindiTitle else book.title,
                            fontSize = 12.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = Navy900,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = "E-Book • ${book.totalPagesOrTests} • ${book.medium}",
                            fontSize = 10.5.sp,
                            color = Color(0xFF64748B)
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = { onCacheStudyItem(book) },
                        colors = ButtonDefaults.buttonColors(containerColor = SaffronGold),
                        shape = RoundedCornerShape(8.dp),
                        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp),
                        modifier = Modifier
                            .height(34.dp)
                            .testTag("cache_ebook_btn_${book.id}")
                    ) {
                        Icon(
                            imageVector = Icons.Default.CloudDownload,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(14.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = if (isHi) "सेव करें" else "Save Offline",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }

            uncachedTests.forEach { test ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.White)
                        .border(1.dp, Color(0xFFE2E8F0), RoundedCornerShape(10.dp))
                        .padding(horizontal = 12.dp, vertical = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = if (isHi) test.hindiTitle else test.title,
                            fontSize = 12.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = Navy900,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = "Test Series • ${test.questions.size} PYQs • ${test.durationMinutes} Mins",
                            fontSize = 10.5.sp,
                            color = Color(0xFF64748B)
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = { onCacheMockTest(test) },
                        colors = ButtonDefaults.buttonColors(containerColor = Navy900),
                        shape = RoundedCornerShape(8.dp),
                        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp),
                        modifier = Modifier
                            .height(34.dp)
                            .testTag("cache_test_btn_${test.testId}")
                    ) {
                        Icon(
                            imageVector = Icons.Default.CloudDownload,
                            contentDescription = null,
                            tint = SaffronGold,
                            modifier = Modifier.size(14.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = if (isHi) "सेव करें" else "Save Offline",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}
