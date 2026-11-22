package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Brightness4
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.FormatSize
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.BookChapter
import com.example.ui.theme.AmberGold
import com.example.ui.theme.Navy800
import com.example.ui.theme.Navy900
import com.example.ui.theme.SaffronGold
import com.example.viewmodel.ReaderTheme
import com.example.viewmodel.ShakuntalamUiState
import com.example.viewmodel.ShakuntalamViewModel

@Composable
fun ReaderScreen(
    uiState: ShakuntalamUiState,
    viewModel: ShakuntalamViewModel,
    modifier: Modifier = Modifier
) {
    val isHi = uiState.selectedLanguage == com.example.model.AppLanguage.HINDI
    val uploadedDoc = uiState.currentDocForReading
    val item = uiState.activeReadingItem ?: uiState.selectedItem

    // Support both catalog study items and owner-uploaded PDF documents
    val bookTitle = uploadedDoc?.title ?: item?.title ?: "Shakuntalam Study Guide"
    val bookHindiTitle = uploadedDoc?.hindiTitle ?: item?.hindiTitle ?: "शकुंतलम संपूर्ण अध्ययन गाइड"
    val docFileName = uploadedDoc?.fileName ?: "${item?.id ?: "document"}.pdf"

    val chapters: List<BookChapter> = if (uploadedDoc != null) {
        listOf(
            BookChapter(
                chapterNumber = 1,
                title = uploadedDoc.title,
                hindiTitle = uploadedDoc.hindiTitle,
                pageCount = uploadedDoc.pageCount,
                content = """
# ${uploadedDoc.title}
## ${uploadedDoc.hindiTitle}

**Shakuntalam Publisher Certified Document • ${uploadedDoc.edition}**
- **File Name:** ${uploadedDoc.fileName}
- **Medium:** ${uploadedDoc.medium}
- **Total Pages:** ${uploadedDoc.pageCount} Pages
- **File Size:** ${uploadedDoc.fileSizeFormatted}

---

### Study Summary & Key Highlights:

1. **Complete Syllabus Coverage**: This document presents the comprehensive syllabus of the exam in a structured, point-wise format.
2. **High-Yield Revision Facts**: Important facts, timelines, constitutional articles, and definitions frequently asked in competitive exams.
3. **Practice Model Questions**: Includes chapter-wise objective and analytical questions.
4. **Offline Download Available**: Tap the 'Download PDF' icon in the top bar to save this PDF directly to your device.

*(Full High-Resolution PDF pages are cached and available for continuous offline reading.)*
                """.trimIndent()
            )
        )
    } else {
        item?.chapters?.ifEmpty {
            listOf(
                BookChapter(
                    chapterNumber = 1,
                    title = "Study Notes & Key Concept Capsule",
                    hindiTitle = "अध्ययन नोट्स एवं महत्वपूर्ण अवधारणाएं",
                    pageCount = 25,
                    content = """
# ${item.title}
## ${item.hindiTitle}

**Shakuntalam E-Book Series 2025-26**

### Key High-Yield Concepts:
1. **Exam-Focused Approach**: Prepared according to the latest syllabus and past 10 years' solved papers.
2. **Core Topic Summary**: Compilation of all high-yield facts, tables, and flowcharts.
3. **Practice Questions**: Important objective PYQs included at the end of every chapter.
4. **Editorial Note**: Certified study material by Shakuntalam Editorial Board.
                    """.trimIndent()
                )
            )
        } ?: listOf(
            BookChapter(
                chapterNumber = 1,
                title = "Overview",
                hindiTitle = "सिंहावलोकन",
                pageCount = 20,
                content = "# Shakuntalam Study Material"
            )
        )
    }

    val currentChapterIndex = uiState.currentChapterIndex.coerceIn(0, chapters.size - 1)
    val chapter = chapters[currentChapterIndex]
    val bookmarkKey = "${uploadedDoc?.id ?: item?.id ?: "doc"}_$currentChapterIndex"
    val isBookmarked = uiState.bookmarkedChapters.contains(bookmarkKey)

    // Reader styling based on theme
    val (bgColor, textColor, cardBg) = when (uiState.readerTheme) {
        ReaderTheme.LIGHT -> Triple(Color(0xFFFFFFFF), Color(0xFF1E293B), Color(0xFFF8FAFC))
        ReaderTheme.SEPIA -> Triple(Color(0xFFFBF0D9), Color(0xFF452B14), Color(0xFFF4E5C7))
        ReaderTheme.DARK -> Triple(Color(0xFF0F172A), Color(0xFFF1F5F9), Color(0xFF1E293B))
    }

    var showChapterMenu by remember { mutableStateOf(false) }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = if (uiState.readerTheme == ReaderTheme.DARK) Color(0xFF090D16) else Navy900,
                shadowElevation = 4.dp
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .statusBarsPadding()
                        .padding(horizontal = 8.dp, vertical = 6.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        IconButton(
                            onClick = { viewModel.navigateBack() },
                            modifier = Modifier.testTag("reader_back_button")
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back",
                                tint = Color.White
                            )
                        }

                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .clickable { showChapterMenu = true },
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = if (isHi) "अध्याय ${chapter.chapterNumber}/${chapters.size}" else "Chapter ${chapter.chapterNumber}/${chapters.size}",
                                fontSize = 11.sp,
                                color = SaffronGold,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = if (isHi) chapter.hindiTitle else chapter.title,
                                fontSize = 13.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                maxLines = 1
                            )
                        }

                        // Theme switcher
                        IconButton(onClick = {
                            val nextTheme = when (uiState.readerTheme) {
                                ReaderTheme.LIGHT -> ReaderTheme.SEPIA
                                ReaderTheme.SEPIA -> ReaderTheme.DARK
                                ReaderTheme.DARK -> ReaderTheme.LIGHT
                            }
                            viewModel.setReaderTheme(nextTheme)
                        }) {
                            Icon(
                                imageVector = Icons.Default.Brightness4,
                                contentDescription = "Theme",
                                tint = Color.White
                            )
                        }

                        // Download PDF Button
                        IconButton(onClick = { viewModel.downloadPdf(bookTitle, docFileName) }) {
                            Icon(
                                imageVector = Icons.Default.Download,
                                contentDescription = "Download PDF",
                                tint = SaffronGold
                            )
                        }

                        // Bookmark button
                        IconButton(onClick = { viewModel.toggleBookmark(uploadedDoc?.id ?: item?.id ?: "doc", currentChapterIndex) }) {
                            Icon(
                                imageVector = if (isBookmarked) Icons.Default.Bookmark else Icons.Default.BookmarkBorder,
                                contentDescription = "Bookmark",
                                tint = if (isBookmarked) SaffronGold else Color.White
                            )
                        }
                    }

                    // Reading progress
                    LinearProgressIndicator(
                        progress = { (currentChapterIndex + 1).toFloat() / chapters.size },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(3.dp),
                        color = SaffronGold,
                        trackColor = Color(0x33FFFFFF)
                    )
                }
            }
        },
        bottomBar = {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = if (uiState.readerTheme == ReaderTheme.DARK) Color(0xFF090D16) else cardBg,
                shadowElevation = 8.dp
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Font Size Controls (A- / A+)
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        OutlinedButton(
                            onClick = { viewModel.setReaderFontSize(uiState.readerFontSizeSp - 2) },
                            shape = CircleShape,
                            modifier = Modifier.size(34.dp),
                            contentPadding = PaddingValues(0.dp)
                        ) {
                            Text("A-", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = textColor)
                        }
                        Text(
                            text = "${uiState.readerFontSizeSp}sp",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = textColor
                        )
                        OutlinedButton(
                            onClick = { viewModel.setReaderFontSize(uiState.readerFontSizeSp + 2) },
                            shape = CircleShape,
                            modifier = Modifier.size(34.dp),
                            contentPadding = PaddingValues(0.dp)
                        ) {
                            Text("A+", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = textColor)
                        }
                    }

                    // Prev / Next Chapter Buttons
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        Button(
                            onClick = {
                                if (currentChapterIndex > 0) {
                                    viewModel.setChapter(currentChapterIndex - 1)
                                }
                            },
                            enabled = currentChapterIndex > 0,
                            colors = ButtonDefaults.buttonColors(containerColor = Navy800),
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier.height(36.dp)
                        ) {
                            Icon(Icons.Default.ChevronLeft, contentDescription = null, tint = Color.White)
                            Text(if (isHi) "पिछला" else "Prev", fontSize = 11.sp)
                        }

                        Button(
                            onClick = {
                                if (currentChapterIndex < chapters.size - 1) {
                                    viewModel.setChapter(currentChapterIndex + 1)
                                }
                            },
                            enabled = currentChapterIndex < chapters.size - 1,
                            colors = ButtonDefaults.buttonColors(containerColor = SaffronGold),
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier.height(36.dp)
                        ) {
                            Text(if (isHi) "अगला" else "Next", fontSize = 11.sp, color = Color.White)
                            Icon(Icons.Default.ChevronRight, contentDescription = null, tint = Color.White)
                        }
                    }
                }
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(bgColor)
                .padding(innerPadding)
                .padding(horizontal = 20.dp, vertical = 16.dp),
            contentPadding = PaddingValues(bottom = 20.dp)
        ) {
            // Chapter Header Badge + DRM Anti-Piracy Watermark
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(6.dp))
                            .background(SaffronGold)
                            .padding(horizontal = 10.dp, vertical = 4.dp)
                    ) {
                        Text(
                            text = "SHAKUNTALAM E-BOOK • CHAPTER ${chapter.chapterNumber}",
                            color = Color.White,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.ExtraBold,
                            letterSpacing = 1.sp
                        )
                    }

                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(6.dp))
                            .background(Color(0xFF065F46))
                            .padding(horizontal = 8.dp, vertical = 3.dp)
                    ) {
                        Text(
                            text = if (uiState.isAntiPiracyEnabled) "🔒 DRM • SHA-256" else "SHA-256 VERIFIED",
                            color = Color.White,
                            fontSize = 9.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = if (isHi) chapter.hindiTitle else chapter.title,
                    fontSize = (uiState.readerFontSizeSp + 6).sp,
                    fontWeight = FontWeight.Bold,
                    color = textColor,
                    lineHeight = (uiState.readerFontSizeSp + 12).sp
                )
                Text(
                    text = if (isHi) chapter.title else chapter.hindiTitle,
                    fontSize = (uiState.readerFontSizeSp - 1).sp,
                    fontWeight = FontWeight.Medium,
                    color = textColor.copy(alpha = 0.7f),
                    modifier = Modifier.padding(top = 2.dp, bottom = 16.dp)
                )

                // Divider line
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(2.dp)
                        .background(SaffronGold.copy(alpha = 0.5f))
                )

                Spacer(modifier = Modifier.height(16.dp))
            }

            // Chapter Text Content
            item {
                Text(
                    text = chapter.content,
                    fontSize = uiState.readerFontSizeSp.sp,
                    color = textColor,
                    lineHeight = (uiState.readerFontSizeSp + 8).sp,
                    fontWeight = FontWeight.Normal
                )
            }

            // Bottom chapter completion note
            item {
                Spacer(modifier = Modifier.height(24.dp))
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = cardBg)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = if (isHi) "अध्याय ${chapter.chapterNumber} समाप्त" else "End of Chapter ${chapter.chapterNumber}",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = SaffronGold
                        )
                        Text(
                            text = if (isHi) "शकुंतलम ई-बुक श्रृंखला • 2025-26 संपादन" else "Shakuntalam E-Book Series • 2025-26 Edition",
                            fontSize = 11.sp,
                            color = textColor.copy(alpha = 0.6f),
                            modifier = Modifier.padding(top = 2.dp)
                        )
                    }
                }
            }
        }
    }
}
