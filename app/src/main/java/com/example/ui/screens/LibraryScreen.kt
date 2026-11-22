package com.example.ui.screens

import androidx.compose.foundation.background
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
import androidx.compose.material.icons.filled.AutoStories
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Quiz
import com.example.model.AppLanguage
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.ExamCatalogData
import com.example.model.ContentType
import com.example.ui.theme.AmberGold
import com.example.ui.theme.EmeraldLight
import com.example.ui.theme.EmeraldSuccess
import com.example.ui.theme.Navy100
import com.example.ui.theme.Navy800
import com.example.ui.theme.Navy900
import com.example.ui.theme.SaffronGold
import com.example.viewmodel.AppScreen
import com.example.viewmodel.ShakuntalamUiState
import com.example.viewmodel.ShakuntalamViewModel

@Composable
fun LibraryScreen(
    uiState: ShakuntalamUiState,
    viewModel: ShakuntalamViewModel,
    modifier: Modifier = Modifier
) {
    val isHi = uiState.selectedLanguage == AppLanguage.HINDI
    var selectedTabIndex by remember { mutableStateOf(0) }
    val tabs = if (isHi) {
        listOf("मेरी पुस्तकें", "ऑफलाइन वॉल्ट", "पीडीएफ कॉर्नर", "टेस्ट सीरीज़", "बुकमार्क")
    } else {
        listOf("My E-Books", "Offline Vault", "PDFs & Notes", "Test Series", "Bookmarks")
    }

    // Purchased items
    val purchasedBooks = uiState.customStudyItems.filter {
        uiState.purchasedItemIds.contains(it.id) && it.type == ContentType.EBOOK
    }

    val purchasedTests = uiState.customStudyItems.filter {
        uiState.purchasedItemIds.contains(it.id) && it.type == ContentType.TEST_SERIES
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = Navy900,
                shadowElevation = 4.dp
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .statusBarsPadding()
                        .padding(horizontal = 16.dp, vertical = 12.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Bookmark,
                            contentDescription = null,
                            tint = SaffronGold,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Column {
                            Text(
                                text = if (isHi) "मेरी लाइब्रेरी एवं ऑफलाइन वॉल्ट" else "My Library & Offline Room Cache",
                                fontSize = 17.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Text(
                                text = if (isHi) "ई-बुक्स, टेस्ट सीरीज़ एवं Room DB ऑफलाइन डाउनलोड" else "Purchased E-Books, PDF notes, tests & Room offline cache",
                                fontSize = 11.5.sp,
                                color = Color(0xFFCBD5E1)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    TabRow(
                        selectedTabIndex = selectedTabIndex,
                        containerColor = Navy800,
                        contentColor = Color.White,
                        indicator = { tabPositions ->
                            if (selectedTabIndex < tabPositions.size) {
                                TabRowDefaults.SecondaryIndicator(
                                    modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                                    color = SaffronGold,
                                    height = 3.dp
                                )
                            }
                        }
                    ) {
                        tabs.forEachIndexed { index, title ->
                            Tab(
                                selected = selectedTabIndex == index,
                                onClick = { selectedTabIndex = index },
                                text = {
                                    Text(
                                        text = title,
                                        fontSize = 11.sp,
                                        fontWeight = if (selectedTabIndex == index) FontWeight.Bold else FontWeight.Normal,
                                        color = if (selectedTabIndex == index) SaffronGold else Color(0xFFCBD5E1),
                                        maxLines = 1
                                    )
                                },
                                modifier = Modifier.testTag("library_tab_$index")
                            )
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
                .padding(innerPadding)
                .padding(horizontal = 16.dp, vertical = 14.dp),
            contentPadding = PaddingValues(bottom = 24.dp)
        ) {
            // Room Local Offline Cache Status & Connectivity Control Card at top of Library
            item {
                com.example.ui.components.OfflineRoomCacheStatusCard(
                    uiState = uiState,
                    isHi = isHi,
                    onToggleOfflineMode = { viewModel.toggleOfflineMode(it) },
                    onDownloadAllCoreOffline = { viewModel.cacheAllCoreMaterialsForOffline() },
                    onClearAllCache = { viewModel.clearAllOfflineCache() }
                )
            }

            when (selectedTabIndex) {
                0 -> {
                    // Dedicated E-Books & Downloaded Vault Section at the top of My E-Books tab
                    item {
                        com.example.ui.components.DedicatedEbooksAndDownloadedVaultSection(
                            uiState = uiState,
                            isHi = isHi,
                            onReadEbook = { ebookItem -> viewModel.openReader(ebookItem, 0) },
                            onDownloadEbookOffline = { ebookItem -> viewModel.cacheStudyItemForOffline(ebookItem) },
                            onOpenFullEbookLibraryTab = { selectedTabIndex = 1 },
                            modifier = Modifier.padding(horizontal = 0.dp)
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                    }

                    // Books Tab
                    if (purchasedBooks.isEmpty()) {
                        item {
                            EmptyLibraryState(
                                message = if (isHi) "आपके पास अभी कोई अधिरहित ई-बुक नहीं है।" else "You don't have any purchased E-Books yet.",
                                buttonLabel = if (isHi) "कैटलॉग देखें" else "Browse Catalog",
                                onBrowse = { viewModel.navigateTo(AppScreen.EXPLORER) }
                            )
                        }
                    } else {
                        items(purchasedBooks) { book ->
                            val isOfflineCached = uiState.isEbookCachedOffline(book.id)
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 6.dp),
                                shape = RoundedCornerShape(14.dp),
                                colors = CardDefaults.cardColors(containerColor = Color.White),
                                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                            ) {
                                Column(modifier = Modifier.padding(14.dp)) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .clip(RoundedCornerShape(6.dp))
                                                .background(EmeraldLight)
                                                .padding(horizontal = 8.dp, vertical = 3.dp)
                                        ) {
                                            Text(
                                                text = if (isOfflineCached) {
                                                    if (isHi) "✓ ऑफलाइन कैश तैयार (Room DB)" else "✓ Offline Cached (Room DB)"
                                                } else {
                                                    if (isHi) "✓ सक्रिय ई-बुक (Active)" else "✓ Active E-Book (DRM Verified)"
                                                },
                                                fontSize = 10.5.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = EmeraldSuccess
                                            )
                                        }

                                        Text(
                                            text = book.edition,
                                            fontSize = 11.sp,
                                            color = Color(0xFF64748B)
                                        )
                                    }

                                    Spacer(modifier = Modifier.height(8.dp))

                                    Text(
                                        text = if (isHi) book.hindiTitle else book.title,
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Navy900
                                    )
                                    Text(
                                        text = if (isHi) book.title else book.hindiTitle,
                                        fontSize = 12.sp,
                                        color = Color(0xFF64748B),
                                        modifier = Modifier.padding(top = 2.dp)
                                    )

                                    Spacer(modifier = Modifier.height(12.dp))

                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                                    ) {
                                        Button(
                                            onClick = { viewModel.openReader(book) },
                                            modifier = Modifier
                                                .weight(1f)
                                                .height(40.dp)
                                                .testTag("lib_read_${book.id}"),
                                            colors = ButtonDefaults.buttonColors(containerColor = SaffronGold),
                                            shape = RoundedCornerShape(8.dp)
                                        ) {
                                            Icon(
                                                imageVector = Icons.Default.AutoStories,
                                                contentDescription = null,
                                                tint = Color.White,
                                                modifier = Modifier.size(16.dp)
                                            )
                                            Spacer(modifier = Modifier.width(6.dp))
                                            Text(if (isHi) "पढ़ें" else "Read", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color.White)
                                        }

                                        Button(
                                            onClick = {
                                                viewModel.cacheStudyItemForOffline(book)
                                            },
                                            modifier = Modifier
                                                .weight(1f)
                                                .height(40.dp)
                                                .testTag("lib_dl_${book.id}"),
                                            colors = ButtonDefaults.buttonColors(
                                                containerColor = if (isOfflineCached) EmeraldSuccess else Navy900
                                            ),
                                            shape = RoundedCornerShape(8.dp)
                                        ) {
                                            Icon(
                                                imageVector = if (isOfflineCached) Icons.Default.CheckCircle else Icons.Default.Download,
                                                contentDescription = null,
                                                tint = Color.White,
                                                modifier = Modifier.size(16.dp)
                                            )
                                            Spacer(modifier = Modifier.width(6.dp))
                                            Text(
                                                text = if (isOfflineCached) {
                                                    if (isHi) "ऑफलाइन सेव है" else "Offline Ready"
                                                } else {
                                                    if (isHi) "ऑफलाइन सेव" else "Save Offline"
                                                },
                                                fontSize = 11.5.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Color.White
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                1 -> {
                    // Offline Vault Tab (Room Database Cached E-Books & Test Materials)
                    item {
                        com.example.ui.components.OfflineVaultContentList(
                            uiState = uiState,
                            isHi = isHi,
                            onOpenOfflineEbook = { viewModel.openOfflineCachedEbook(it) },
                            onRemoveOfflineEbook = { viewModel.removeOfflineCachedEbook(it) },
                            onStartOfflineTest = { viewModel.startOfflineCachedTest(it) },
                            onRemoveOfflineTest = { viewModel.removeOfflineCachedTest(it) },
                            onCacheStudyItem = { viewModel.cacheStudyItemForOffline(it) },
                            onCacheMockTest = { viewModel.cacheMockTestForOffline(it) }
                        )
                    }
                }

                2 -> {
                    // PDF Corner & Official Notes Tab
                    item {
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 12.dp),
                            shape = RoundedCornerShape(12.dp),
                            colors = CardDefaults.cardColors(containerColor = Color(0xFFFEF2F2))
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(6.dp))
                                        .background(Color(0xFFDC2626))
                                        .padding(horizontal = 8.dp, vertical = 4.dp)
                                ) {
                                    Text("PDF", fontSize = 11.sp, fontWeight = FontWeight.ExtraBold, color = Color.White)
                                }
                                Spacer(modifier = Modifier.width(10.dp))
                                Column {
                                    Text(
                                        text = if (isHi) "शकुंतलम आधिकारिक ई-बुक व पीडीएफ कॉर्नर" else "Official E-Book & PDF Corner",
                                        fontSize = 13.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFF991B1B)
                                    )
                                    Text(
                                        text = if (isHi) "सभी ई-बुक्स बिना किसी बाधा के ऐप में खुलती हैं एवं ऑफलाइन डाउनलोड की जा सकती हैं।" else "All PDFs open smoothly in-app and can be downloaded for offline study.",
                                        fontSize = 11.sp,
                                        color = Color(0xFF7F1D1D)
                                    )
                                }
                            }
                        }
                    }

                    if (uiState.uploadedDocuments.isEmpty()) {
                        item {
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 6.dp),
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
                                                text = "PDF • All Exams",
                                                fontSize = 10.5.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = EmeraldSuccess
                                            )
                                        }
                                        Text(
                                            text = if (isHi) "निःशुल्क" else "FREE",
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            color = EmeraldSuccess
                                        )
                                    }

                                    Spacer(modifier = Modifier.height(8.dp))

                                    Text(
                                        text = if (isHi) "UPSC प्रारंभिक एवं मुख्य परीक्षा सामान्य अध्ययन नोट्स" else "UPSC Prelims & Mains General Studies Complete Notes",
                                        fontSize = 14.5.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Navy900
                                    )
                                    Text(
                                        text = "History, Polity, Geography, Economy • 280 Pages • 24.5 MB",
                                        fontSize = 11.5.sp,
                                        color = Color(0xFF64748B),
                                        modifier = Modifier.padding(top = 2.dp)
                                    )

                                    Spacer(modifier = Modifier.height(12.dp))

                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                                    ) {
                                        Button(
                                            onClick = {
                                                val firstBook = uiState.customStudyItems.firstOrNull { it.type == ContentType.EBOOK }
                                                if (firstBook != null) viewModel.openReader(firstBook)
                                            },
                                            modifier = Modifier
                                                .weight(1f)
                                                .height(38.dp),
                                            colors = ButtonDefaults.buttonColors(containerColor = Navy900),
                                            shape = RoundedCornerShape(8.dp)
                                        ) {
                                            Text(if (isHi) "पीडीएफ पढ़ें" else "Read PDF", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color.White)
                                        }

                                        Button(
                                            onClick = { viewModel.downloadPdf("UPSC General Studies Notes", "upsc_gs_complete_notes.pdf") },
                                            modifier = Modifier
                                                .weight(1f)
                                                .height(38.dp),
                                            colors = ButtonDefaults.buttonColors(containerColor = SaffronGold),
                                            shape = RoundedCornerShape(8.dp)
                                        ) {
                                            Icon(Icons.Default.Download, contentDescription = null, tint = Color.White, modifier = Modifier.size(14.dp))
                                            Spacer(modifier = Modifier.width(4.dp))
                                            Text(if (isHi) "डाउनलोड" else "Download", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color.White)
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        items(uiState.uploadedDocuments) { doc ->
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 6.dp),
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
                                                .background(Color(0xFFFEE2E2))
                                                .padding(horizontal = 8.dp, vertical = 3.dp)
                                        ) {
                                            Text(
                                                text = "PDF • ${doc.examId.uppercase()}",
                                                fontSize = 10.5.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Color(0xFFB91C1C)
                                            )
                                        }

                                        Text(
                                            text = if (doc.discountedPrice == 0) (if (isHi) "निःशुल्क" else "FREE") else "₹${doc.discountedPrice}",
                                            fontSize = 13.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            color = if (doc.discountedPrice == 0) EmeraldSuccess else Navy900
                                        )
                                    }

                                    Spacer(modifier = Modifier.height(8.dp))

                                    Text(
                                        text = if (isHi) doc.hindiTitle else doc.title,
                                        fontSize = 14.5.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Navy900
                                    )
                                    Text(
                                        text = "${doc.subjectId.replace('_', ' ').uppercase()} • ${doc.pageCount} ${if (isHi) "पृष्ठ" else "Pages"} • ${doc.fileSizeFormatted}",
                                        fontSize = 11.5.sp,
                                        color = Color(0xFF64748B),
                                        modifier = Modifier.padding(top = 2.dp)
                                    )

                                    Spacer(modifier = Modifier.height(12.dp))

                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                                    ) {
                                        Button(
                                            onClick = { viewModel.openPdfForReading(doc) },
                                            modifier = Modifier
                                                .weight(1f)
                                                .height(38.dp),
                                            colors = ButtonDefaults.buttonColors(containerColor = Navy900),
                                            shape = RoundedCornerShape(8.dp)
                                        ) {
                                            Text(if (isHi) "पीडीएफ पढ़ें" else "Read PDF", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color.White)
                                        }

                                        Button(
                                            onClick = { viewModel.downloadPdf(doc.title, doc.fileName) },
                                            modifier = Modifier
                                                .weight(1f)
                                                .height(38.dp),
                                            colors = ButtonDefaults.buttonColors(containerColor = SaffronGold),
                                            shape = RoundedCornerShape(8.dp)
                                        ) {
                                            Icon(Icons.Default.Download, contentDescription = null, tint = Color.White, modifier = Modifier.size(14.dp))
                                            Spacer(modifier = Modifier.width(4.dp))
                                            Text(if (isHi) "डाउनलोड" else "Download", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color.White)
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                3 -> {
                    // Test Series Tab (Sample test + any custom tests created by owner)
                    item {
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 6.dp),
                            shape = RoundedCornerShape(14.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                        ) {
                            Column(modifier = Modifier.padding(14.dp)) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(6.dp))
                                            .background(Navy100)
                                            .padding(horizontal = 8.dp, vertical = 3.dp)
                                    ) {
                                        Text(
                                            text = if (isHi) "अखिल भारतीय ओपन टेस्ट" else "All India Open Mock Test",
                                            fontSize = 10.5.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Navy900
                                        )
                                    }
                                    Text(
                                        text = "${ExamCatalogData.sampleMockTest.questions.size} ${if (isHi) "प्रश्न" else "Questions"} • ${ExamCatalogData.sampleMockTest.totalMarks} ${if (isHi) "अंक" else "Marks"}",
                                        fontSize = 11.sp,
                                        color = Color(0xFF64748B)
                                    )
                                }

                                Spacer(modifier = Modifier.height(8.dp))

                                Text(
                                    text = if (isHi) ExamCatalogData.sampleMockTest.hindiTitle else ExamCatalogData.sampleMockTest.title,
                                    fontSize = 14.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Navy900
                                )
                                Text(
                                    text = ExamCatalogData.sampleMockTest.title,
                                    fontSize = 11.5.sp,
                                    color = Color(0xFF64748B),
                                    modifier = Modifier.padding(top = 2.dp)
                                )

                                Spacer(modifier = Modifier.height(12.dp))

                                Button(
                                    onClick = { viewModel.startTest() },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(40.dp)
                                        .testTag("lib_start_mock_test"),
                                    colors = ButtonDefaults.buttonColors(containerColor = EmeraldSuccess),
                                    shape = RoundedCornerShape(8.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Quiz,
                                        contentDescription = null,
                                        tint = Color.White,
                                        modifier = Modifier.size(16.dp)
                                    )
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text(if (isHi) "मॉक टेस्ट शुरू करें (Start Test)" else "Start Online Exam", fontSize = 12.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
                                }
                            }
                        }
                    }

                    // Exam-Specific Last 5 Years PYQ & Owner-created tests
                    if (uiState.customTests.isNotEmpty()) {
                        item {
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = if (isHi) "परीक्षावार विगत 5 वर्षीय (2020–2025) PYQ द्विभाषी टेस्ट सीरीज़:" else "Exam-Wise Last 5 Years (2020–2025) PYQ Bilingual Test Series:",
                                fontSize = 13.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = Navy900
                            )
                        }

                        items(uiState.customTests) { test ->
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 4.dp),
                                shape = RoundedCornerShape(12.dp),
                                colors = CardDefaults.cardColors(containerColor = Color.White),
                                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                            ) {
                                Column(modifier = Modifier.padding(12.dp)) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text(
                                            text = if (isHi) test.hindiTitle else test.title,
                                            fontSize = 13.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Navy900,
                                            modifier = Modifier.weight(1f)
                                        )
                                        Spacer(modifier = Modifier.width(6.dp))
                                        Text(
                                            text = "+${test.positiveMarks} / -${test.negativeMarks}",
                                            fontSize = 10.5.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = EmeraldSuccess
                                        )
                                    }

                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = if (isHi) test.pyqAnalysisHi else test.pyqAnalysisEn,
                                        fontSize = 11.sp,
                                        color = Color(0xFF475569),
                                        lineHeight = 15.sp
                                    )

                                    Spacer(modifier = Modifier.height(8.dp))

                                    val isTestOfflineCached = uiState.isTestCachedOffline(test.testId)
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                                    ) {
                                        Button(
                                            onClick = { viewModel.startTest(test) },
                                            modifier = Modifier
                                                .weight(1f)
                                                .height(36.dp),
                                            colors = ButtonDefaults.buttonColors(containerColor = Navy900),
                                            shape = RoundedCornerShape(8.dp)
                                        ) {
                                            Text(
                                                text = if (isHi) "पेपर शुरू करें (${test.questions.size} Qs)" else "Start PYQ Test (${test.questions.size} Qs)",
                                                fontSize = 11.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Color.White,
                                                maxLines = 1
                                            )
                                        }

                                        Button(
                                            onClick = { viewModel.cacheMockTestForOffline(test) },
                                            modifier = Modifier
                                                .height(36.dp)
                                                .testTag("lib_cache_test_${test.testId}"),
                                            colors = ButtonDefaults.buttonColors(
                                                containerColor = if (isTestOfflineCached) EmeraldSuccess else SaffronGold
                                            ),
                                            shape = RoundedCornerShape(8.dp),
                                            contentPadding = PaddingValues(horizontal = 10.dp)
                                        ) {
                                            Icon(
                                                imageVector = if (isTestOfflineCached) Icons.Default.CheckCircle else Icons.Default.Download,
                                                contentDescription = null,
                                                tint = Color.White,
                                                modifier = Modifier.size(14.dp)
                                            )
                                            Spacer(modifier = Modifier.width(4.dp))
                                            Text(
                                                text = if (isTestOfflineCached) {
                                                    if (isHi) "ऑफलाइन" else "Cached"
                                                } else {
                                                    if (isHi) "ऑफलाइन सेव" else "Save Offline"
                                                },
                                                fontSize = 11.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Color.White,
                                                maxLines = 1
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }

                    // Past Attempts
                    if (uiState.testAttemptsHistory.isNotEmpty()) {
                        item {
                            Spacer(modifier = Modifier.height(12.dp))
                            Text(
                                text = if (isHi) "गत टेस्ट प्रयास (Previous Attempts):" else "Test History & Performance:",
                                fontSize = 13.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = Navy900
                            )
                        }

                        items(uiState.testAttemptsHistory) { attempt ->
                            val rankInfo = com.example.ui.components.TestAnalyticsEngine.calculateStudentRank(
                                score = attempt.score,
                                totalMarks = attempt.totalMarks,
                                correctCount = attempt.correctCount,
                                wrongCount = attempt.wrongCount,
                                timeSpentSeconds = attempt.timeSpentSeconds,
                                totalDurationSeconds = 3600
                            )
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 4.dp),
                                shape = RoundedCornerShape(10.dp),
                                colors = CardDefaults.cardColors(containerColor = Color.White)
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(12.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Column(modifier = Modifier.weight(1f)) {
                                        Text(
                                            text = attempt.testTitle,
                                            fontSize = 12.5.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Navy900,
                                            maxLines = 1
                                        )
                                        Text(
                                            text = if (isHi)
                                                "सही: ${attempt.correctCount} • गलत: ${attempt.wrongCount} • छोड़े: ${attempt.unattemptedCount} • समय: ${com.example.ui.components.formatElapsedDuration(attempt.timeSpentSeconds)}"
                                            else
                                                "Correct: ${attempt.correctCount} • Wrong: ${attempt.wrongCount} • Skipped: ${attempt.unattemptedCount} • Time: ${com.example.ui.components.formatElapsedDuration(attempt.timeSpentSeconds)}",
                                            fontSize = 11.sp,
                                            color = Color(0xFF64748B)
                                        )
                                        Text(
                                            text = "AIR #${rankInfo.allIndiaRank} (${rankInfo.percentile}%ile) • ${if (isHi) rankInfo.rankTierTitleHi else rankInfo.rankTierTitleEn}",
                                            fontSize = 10.5.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = EmeraldSuccess
                                        )
                                    }

                                    Spacer(modifier = Modifier.width(8.dp))

                                    Column(horizontalAlignment = Alignment.End) {
                                        Text(
                                            text = "%.2f / %d".format(attempt.score, attempt.totalMarks),
                                            fontSize = 14.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            color = SaffronGold
                                        )
                                        Text(
                                            text = "AIR #${rankInfo.allIndiaRank}",
                                            fontSize = 11.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            color = Navy900
                                        )
                                    }
                                }
                            }
                        }
                    }
                }

                4 -> {
                    // Bookmarks Tab
                    if (uiState.bookmarkedChapters.isEmpty()) {
                        item {
                            EmptyLibraryState(
                                message = if (isHi) "अभी कोई अध्याय बुकमार्क नहीं किया गया है। ई-बुक पढ़ते समय बुकमार्क आइकन पर टैप करें।" else "No chapters bookmarked yet. Tap the bookmark icon while reading an e-book.",
                                onBrowse = { viewModel.navigateTo(AppScreen.HOME) }
                            )
                        }
                    } else {
                        items(uiState.bookmarkedChapters.toList()) { key ->
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 4.dp),
                                shape = RoundedCornerShape(10.dp),
                                colors = CardDefaults.cardColors(containerColor = Color.White)
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(12.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Icon(
                                            imageVector = Icons.Default.Bookmark,
                                            contentDescription = null,
                                            tint = SaffronGold,
                                            modifier = Modifier.size(20.dp)
                                        )
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Text(
                                            text = if (isHi) "सेव किया गया अध्याय ($key)" else "Saved Chapter ($key)",
                                            fontSize = 12.5.sp,
                                            fontWeight = FontWeight.SemiBold,
                                            color = Navy900
                                        )
                                    }

                                    Button(
                                        onClick = {
                                            val firstBook = uiState.customStudyItems.firstOrNull { it.type == ContentType.EBOOK }
                                            if (firstBook != null) viewModel.openReader(firstBook)
                                        },
                                        colors = ButtonDefaults.buttonColors(containerColor = Navy900),
                                        shape = RoundedCornerShape(6.dp),
                                        modifier = Modifier.height(32.dp)
                                    ) {
                                        Text(if (isHi) "खोलें" else "Open", fontSize = 11.sp, color = Color.White)
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

@Composable
fun EmptyLibraryState(
    message: String,
    buttonLabel: String = "Browse Catalog",
    onBrowse: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
                    .background(Navy100),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.MenuBook,
                    contentDescription = null,
                    tint = Navy900,
                    modifier = Modifier.size(32.dp)
                )
            }
            Spacer(modifier = Modifier.height(14.dp))
            Text(
                text = message,
                fontSize = 13.sp,
                color = Color(0xFF64748B),
                lineHeight = 18.sp,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = onBrowse,
                colors = ButtonDefaults.buttonColors(containerColor = SaffronGold),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(buttonLabel, fontSize = 12.sp, color = Color.White)
            }
        }
    }
}
