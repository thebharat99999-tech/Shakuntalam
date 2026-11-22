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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountTree
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Storage
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.ExamCatalogData
import com.example.data.local.entity.ExamWithSubjectsAndSubTopics
import com.example.data.local.entity.SubTopicEntity
import com.example.model.ContentType
import com.example.model.ExamCategory
import com.example.model.ExamSubSection
import com.example.model.ExamSubject
import com.example.ui.components.StudyItemCard
import com.example.ui.theme.AmberGold
import com.example.ui.theme.AmberLight
import com.example.ui.theme.EmeraldLight
import com.example.ui.theme.EmeraldSuccess
import com.example.ui.theme.Navy100
import com.example.ui.theme.Navy800
import com.example.ui.theme.Navy900
import com.example.ui.theme.SaffronGold
import com.example.ui.theme.SaffronLight
import com.example.viewmodel.ShakuntalamUiState
import com.example.viewmodel.ShakuntalamViewModel

@Composable
fun ExplorerScreen(
    uiState: ShakuntalamUiState,
    viewModel: ShakuntalamViewModel,
    modifier: Modifier = Modifier
) {
    val isHi = uiState.selectedLanguage == com.example.model.AppLanguage.HINDI
    val categories = ExamCatalogData.categories
    val currentCategory = uiState.selectedCategory ?: categories.first()
    val subSections = currentCategory.subSections
    val currentSubSection = uiState.selectedSubSection ?: subSections.firstOrNull()
    val subjects = currentSubSection?.subjects ?: emptyList()
    val currentSubject = uiState.selectedSubject ?: subjects.firstOrNull()

    // Explorer Mode: 0 = Store/E-Books, 1 = Tree View, 2 = Live Room DB Hierarchy
    var explorerMode by remember { mutableStateOf(0) }
    var showAddSubTopicDialogForSubjectId by remember { mutableStateOf<String?>(null) }

    // Filter books matching current selection or general category (from dynamic customStudyItems)
    val matchingItems = uiState.customStudyItems.filter { item ->
        val catMatch = item.categoryId == currentCategory.id
        val subMatch = currentSubSection == null || item.subSectionId == currentSubSection.id || item.categoryId == currentCategory.id
        catMatch
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF8FAFC)),
        contentPadding = PaddingValues(bottom = 32.dp)
    ) {
        // Top Header Info
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Navy900)
                    .padding(horizontal = 16.dp, vertical = 14.dp)
            ) {
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = if (isHi) "परीक्षा एवं विषय वर्गीकरण (Exam Hierarchy)" else "Exam & Subject Hierarchy",
                                fontSize = 17.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Text(
                                text = "Exam ➔ Subject ➔ Sub-topic (Room Database)",
                                fontSize = 11.5.sp,
                                color = Color(0xFFCBD5E1)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    // Mode Switcher Chips
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        FilterChip(
                            selected = explorerMode == 0,
                            onClick = { explorerMode = 0 },
                            label = { Text(if (isHi) "ई-बुक्स स्टोर" else "E-Books Store", fontSize = 11.5.sp) },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = SaffronGold,
                                selectedLabelColor = Color.White,
                                containerColor = Color(0x33FFFFFF),
                                labelColor = Color.White
                            )
                        )

                        FilterChip(
                            selected = explorerMode == 2,
                            onClick = { explorerMode = 2 },
                            label = {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(
                                        imageVector = Icons.Default.Storage,
                                        contentDescription = null,
                                        modifier = Modifier.size(14.dp)
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(if (isHi) "Room DB डेटा मॉडल" else "Room DB Model", fontSize = 11.5.sp)
                                }
                            },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = SaffronGold,
                                selectedLabelColor = Color.White,
                                containerColor = Color(0x33FFFFFF),
                                labelColor = Color.White
                            ),
                            modifier = Modifier.testTag("mode_room_db")
                        )

                        FilterChip(
                            selected = explorerMode == 1,
                            onClick = { explorerMode = 1 },
                            label = {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(
                                        imageVector = Icons.Default.AccountTree,
                                        contentDescription = null,
                                        modifier = Modifier.size(14.dp)
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(if (isHi) "संपूर्ण ट्री" else "Full Syllabus Tree", fontSize = 11.5.sp)
                                }
                            },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = SaffronGold,
                                selectedLabelColor = Color.White,
                                containerColor = Color(0x33FFFFFF),
                                labelColor = Color.White
                            )
                        )
                    }
                }
            }
        }

        when (explorerMode) {
            2 -> {
                // Room Database Hierarchy View: Exam -> Subject -> SubTopic
                item {
                    RoomDatabaseHierarchyView(
                        hierarchies = uiState.roomExamHierarchies,
                        isHi = isHi,
                        onAddSubTopicClick = { subjectId ->
                            showAddSubTopicDialogForSubjectId = subjectId
                        },
                        onDeleteSubTopic = { subTopicId ->
                            viewModel.deleteSubTopic(subTopicId)
                        }
                    )
                }
            }
            1 -> {
                // Complete Syllabus Tree View
                item {
                    CompleteExamTreeView(
                        categories = categories,
                        isHi = isHi,
                        onSelectSubject = { cat, sub, subj ->
                            viewModel.selectCategory(cat)
                            viewModel.selectSubSection(sub)
                            viewModel.selectSubject(subj)
                            explorerMode = 0
                        }
                    )
                }
            }
            else -> {
                // Tier 1: Category Scrollable Tab Row (Exam Names always in English)
                item {
                    val selectedCategoryIndex = categories.indexOfFirst { it.id == currentCategory.id }.coerceAtLeast(0)
                    ScrollableTabRow(
                        selectedTabIndex = selectedCategoryIndex,
                        containerColor = Navy800,
                        contentColor = Color.White,
                        edgePadding = 12.dp,
                        indicator = { tabPositions ->
                            if (selectedCategoryIndex < tabPositions.size) {
                                TabRowDefaults.SecondaryIndicator(
                                    Modifier.tabIndicatorOffset(tabPositions[selectedCategoryIndex]),
                                    color = SaffronGold,
                                    height = 3.dp
                                )
                            }
                        }
                    ) {
                        categories.forEachIndexed { index, cat ->
                            Tab(
                                selected = index == selectedCategoryIndex,
                                onClick = { viewModel.selectCategory(cat) },
                                text = {
                                    Text(
                                        text = cat.name,
                                        fontSize = 12.5.sp,
                                        fontWeight = if (index == selectedCategoryIndex) FontWeight.Bold else FontWeight.Medium,
                                        color = if (index == selectedCategoryIndex) SaffronGold else Color(0xFFCBD5E1),
                                        maxLines = 1,
                                        softWrap = false,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                },
                                modifier = Modifier.testTag("tab_cat_${cat.id}")
                            )
                        }
                    }
                }

                // Tier 2: Sub-Sections Bar
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFFF1F5F9))
                            .padding(horizontal = 16.dp, vertical = 12.dp)
                    ) {
                        Text(
                            text = if (isHi) "सब-सेक्शन चुनें (${currentCategory.name}):" else "Select Sub-Section (${currentCategory.name}):",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = Navy900,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            items(subSections) { subSection ->
                                val isSelected = currentSubSection?.id == subSection.id
                                FilterChip(
                                    selected = isSelected,
                                    onClick = { viewModel.selectSubSection(subSection) },
                                    label = {
                                        Text(
                                            text = if (isHi) subSection.hindiName else subSection.name,
                                            fontSize = 12.sp,
                                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                                            maxLines = 1,
                                            softWrap = false,
                                            overflow = TextOverflow.Ellipsis
                                        )
                                    },
                                    leadingIcon = {
                                        if (isSelected) {
                                            Icon(
                                                imageVector = Icons.Default.CheckCircle,
                                                contentDescription = null,
                                                modifier = Modifier.size(16.dp)
                                            )
                                        }
                                    },
                                    colors = FilterChipDefaults.filterChipColors(
                                        selectedContainerColor = Navy900,
                                        selectedLabelColor = Color.White,
                                        selectedLeadingIconColor = SaffronGold,
                                        containerColor = Color.White,
                                        labelColor = Navy900
                                    )
                                )
                            }
                        }
                    }
                }

                // UPSC CSE Top Feature: "Attempt Free Test (अटेम्प्ट फ्री टेस्ट)" -> Opens 7 Subject Sections (50 UPSC PYQ Qs Each)
                item {
                    val isUpscSelected = currentCategory.id == "upsc"
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 10.dp)
                            .border(
                                width = 2.dp,
                                color = SaffronGold,
                                shape = RoundedCornerShape(16.dp)
                            )
                            .testTag("upsc_free_test_top_card"),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
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
                                    Box(
                                        modifier = Modifier
                                            .size(42.dp)
                                            .clip(RoundedCornerShape(10.dp))
                                            .background(SaffronGold),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Quiz,
                                            contentDescription = "UPSC CSE Free Test",
                                            tint = Navy900,
                                            modifier = Modifier.size(24.dp)
                                        )
                                    }
                                    Spacer(modifier = Modifier.width(12.dp))
                                    Column {
                                        Row(verticalAlignment = Alignment.CenterVertically) {
                                            Box(
                                                modifier = Modifier
                                                    .clip(RoundedCornerShape(4.dp))
                                                    .background(EmeraldSuccess)
                                                    .padding(horizontal = 6.dp, vertical = 2.dp)
                                            ) {
                                                Text(
                                                    text = "UPSC CSE FREE TEST • 350 PYQs",
                                                    fontSize = 9.5.sp,
                                                    fontWeight = FontWeight.ExtraBold,
                                                    color = Color.White
                                                )
                                            }
                                            if (!isUpscSelected) {
                                                Spacer(modifier = Modifier.width(6.dp))
                                                Text(
                                                    text = "UPSC IAS Special",
                                                    fontSize = 10.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    color = SaffronGold
                                                )
                                            }
                                        }
                                        Spacer(modifier = Modifier.height(3.dp))
                                        Text(
                                            text = if (isHi)
                                                "UPSC सिविल सेवा प्रारंभिक (GS-I): विगत 5 वर्षीय PYQ टेस्ट सीरीज़"
                                            else
                                                "UPSC Civil Services Prelims (GS-I): Last 5 Years PYQ Test Series",
                                            fontSize = 14.5.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            color = Color.White
                                        )
                                        Text(
                                            text = if (isHi)
                                                "7 विषयवार सेक्शन • प्रत्येक सेक्शन में 50 प्रश्न • द्विभाषी (English + हिंदी) उत्तर एवं व्याख्या सहित"
                                            else
                                                "7 Subject Sections • 50 Questions per Section • Bilingual (EN + HI) with Answer & Explanation",
                                            fontSize = 11.sp,
                                            color = Color(0xFFCBD5E1)
                                        )
                                    }
                                }
                            }

                            Spacer(modifier = Modifier.height(12.dp))

                            val upscMode = uiState.examTestSeriesModeMap["upsc"] ?: "FREE"
                            com.example.ui.components.ExamPaidFreeDualTabs(
                                examKey = "upsc",
                                examLabelEn = "UPSC CSE (IAS/IPS)",
                                examLabelHi = "UPSC सिविल सेवा (IAS/IPS)",
                                selectedMode = upscMode,
                                freeCountBadge = if (isHi) "7 विषय • 350 फ्री PYQs" else "7 Subjects • 350 Free PYQs",
                                paidCountBadge = if (isHi) "40 फुल-लेंथ प्रो मॉक टेस्ट" else "40 Full-Length Pro Mocks",
                                isHi = isHi,
                                onSelectMode = { mode -> viewModel.selectExamTestSeriesMode("upsc", mode) }
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            // Prominent "UPSC — Attempt Free Test (अटेम्प्ट फ्री टेस्ट)" Button
                            Button(
                                onClick = {
                                    if (!isUpscSelected) {
                                        val upscCat = categories.firstOrNull { it.id == "upsc" }
                                        upscCat?.let { viewModel.selectCategory(it) }
                                    }
                                    viewModel.toggleUpscFreeTestSections()
                                },
                                colors = ButtonDefaults.buttonColors(containerColor = SaffronGold),
                                shape = RoundedCornerShape(10.dp),
                                contentPadding = PaddingValues(horizontal = 12.dp, vertical = 0.dp),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(46.dp)
                                    .testTag("upsc_attempt_free_test_btn")
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Quiz,
                                    contentDescription = null,
                                    tint = Navy900,
                                    modifier = Modifier.size(18.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = if (uiState.isUpscFreeTestSectionExpanded) {
                                        if (isHi) "UPSC अटेम्प्ट फ्री टेस्ट — 7 विषय चुनें ▲" else "UPSC Attempt Free Test — Select Subject (7 Sections) ▲"
                                    } else {
                                        if (isHi) "UPSC अटेम्प्ट फ्री टेस्ट (7 UPSC सेक्शन खोलें) ▼" else "UPSC Attempt Free Test (Open 7 UPSC Sections) ▼"
                                    },
                                    fontSize = 12.5.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Navy900,
                                    maxLines = 1,
                                    softWrap = false,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }

                            if (upscMode == "PAID") {
                                val upscPaidItems = uiState.customStudyItems.filter {
                                    it.categoryId == "upsc" && it.discountedPrice > 0
                                }
                                com.example.ui.components.ExamPaidTestSeriesPanel(
                                    examKey = "upsc",
                                    examTitleEn = "UPSC CSE Prelims & Mains",
                                    examTitleHi = "UPSC सिविल सेवा प्रारंभिक एवं मुख्य परीक्षा",
                                    paidItems = upscPaidItems,
                                    purchasedItemIds = uiState.purchasedItemIds,
                                    isHi = isHi,
                                    onBuyOrOpenItem = { viewModel.openItemDetail(it) },
                                    onAddToCart = { viewModel.addToCart(it) },
                                    onStartPaidMockTest = { viewModel.startUpscSectionTest("upsc_history") },
                                    onSwitchToFreeTests = { viewModel.selectExamTestSeriesMode("upsc", "FREE") }
                                )
                            } else if (uiState.isUpscFreeTestSectionExpanded) {
                                val upscSections = com.example.data.upsc.UpscSciTechIrCaPyqData.all7UpscSectionTests
                                Spacer(modifier = Modifier.height(14.dp))
                                Text(
                                    text = if (isHi)
                                        "नीचे दिए गए 7 UPSC CSE सेक्शन में से किसी भी विषय का 50-प्रश्न टेस्ट सीधे अटेम्प्ट करें:"
                                    else
                                        "Select any of the 7 UPSC CSE Subject Sections below to directly attempt its 50-Question PYQ Test:",
                                    fontSize = 11.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = SaffronGold
                                )
                                Spacer(modifier = Modifier.height(10.dp))

                                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                    upscSections.forEachIndexed { idx, section ->
                                        Card(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .clickable { viewModel.startUpscSectionTest(section.sectionId) }
                                                .testTag("upsc_section_card_${section.sectionId}"),
                                            shape = RoundedCornerShape(12.dp),
                                            colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B))
                                        ) {
                                            Row(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .padding(horizontal = 12.dp, vertical = 10.dp),
                                                verticalAlignment = Alignment.CenterVertically,
                                                horizontalArrangement = Arrangement.SpaceBetween
                                            ) {
                                                Row(
                                                    verticalAlignment = Alignment.CenterVertically,
                                                    modifier = Modifier.weight(1f)
                                                ) {
                                                    Box(
                                                        modifier = Modifier
                                                            .size(32.dp)
                                                            .clip(CircleShape)
                                                            .background(SaffronGold),
                                                        contentAlignment = Alignment.Center
                                                    ) {
                                                        Text(
                                                            text = "${idx + 1}",
                                                            fontSize = 12.5.sp,
                                                            fontWeight = FontWeight.ExtraBold,
                                                            color = Navy900
                                                        )
                                                    }
                                                    Spacer(modifier = Modifier.width(10.dp))
                                                    Column {
                                                        Text(
                                                            text = section.titleEn,
                                                            fontSize = 13.sp,
                                                            fontWeight = FontWeight.ExtraBold,
                                                            color = Color.White
                                                        )
                                                        Text(
                                                            text = if (isHi) section.subtitleHi else section.subtitleEn,
                                                            fontSize = 10.5.sp,
                                                            color = Color(0xFF94A3B8)
                                                        )
                                                        Spacer(modifier = Modifier.height(2.dp))
                                                        Text(
                                                            text = "50 UPSC PYQ Questions • +2.0 / -0.66 • Bilingual Answer & Explanation",
                                                            fontSize = 10.sp,
                                                            fontWeight = FontWeight.SemiBold,
                                                            color = EmeraldLight
                                                        )
                                                    }
                                                }

                                                Spacer(modifier = Modifier.width(8.dp))

                                                Button(
                                                    onClick = { viewModel.startUpscSectionTest(section.sectionId) },
                                                    colors = ButtonDefaults.buttonColors(containerColor = EmeraldSuccess),
                                                    shape = RoundedCornerShape(8.dp),
                                                    contentPadding = PaddingValues(horizontal = 10.dp, vertical = 6.dp),
                                                    modifier = Modifier
                                                        .height(34.dp)
                                                        .testTag("start_${section.sectionId}")
                                                ) {
                                                    Text(
                                                        text = if (isHi) "टेस्ट दें (50 Q)" else "Attempt (50 Q)",
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
                        }
                    }
                }

                // UPPCS Top Feature: "Attempt Free Test (अटेम्प्ट फ्री टेस्ट)" -> Opens 7 Subject Sections (50 PYQ Qs Each)
                item {
                    val isUppcsSelected = currentCategory.id == "state_psc" || currentSubSection?.id == "psc_uppcs"
                    val uppcsMode = uiState.examTestSeriesModeMap["uppcs"] ?: "FREE"
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 10.dp)
                            .border(
                                width = 2.dp,
                                color = SaffronGold,
                                shape = RoundedCornerShape(16.dp)
                            )
                            .testTag("uppcs_free_test_top_card"),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(containerColor = Navy900),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
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
                                    Box(
                                        modifier = Modifier
                                            .size(42.dp)
                                            .clip(RoundedCornerShape(10.dp))
                                            .background(SaffronGold),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Quiz,
                                            contentDescription = "UPPCS Free Test",
                                            tint = Navy900,
                                            modifier = Modifier.size(24.dp)
                                        )
                                    }
                                    Spacer(modifier = Modifier.width(12.dp))
                                    Column {
                                        Row(verticalAlignment = Alignment.CenterVertically) {
                                            Box(
                                                modifier = Modifier
                                                    .clip(RoundedCornerShape(4.dp))
                                                    .background(EmeraldSuccess)
                                                    .padding(horizontal = 6.dp, vertical = 2.dp)
                                            ) {
                                                Text(
                                                    text = "100% FREE ATTEMPT • 350 PYQs",
                                                    fontSize = 9.5.sp,
                                                    fontWeight = FontWeight.ExtraBold,
                                                    color = Color.White
                                                )
                                            }
                                            if (!isUppcsSelected) {
                                                Spacer(modifier = Modifier.width(6.dp))
                                                Text(
                                                    text = "UPPCS Special",
                                                    fontSize = 10.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    color = SaffronGold
                                                )
                                            }
                                        }
                                        Spacer(modifier = Modifier.height(3.dp))
                                        Text(
                                            text = if (isHi)
                                                "UPPCS प्रारंभिक परीक्षा: विगत 5 वर्षीय PYQ टेस्ट सीरीज़"
                                            else
                                                "UPPCS Prelims (GS-I): Last 5 Years PYQ Test Series",
                                            fontSize = 14.5.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            color = Color.White
                                        )
                                        Text(
                                            text = if (isHi)
                                                "7 विषयवार सेक्शन • प्रत्येक सेक्शन में 50 प्रश्न • द्विभाषी (English + हिंदी) उत्तर एवं व्याख्या सहित"
                                            else
                                                "7 Subject Sections • 50 Questions per Section • Bilingual (EN + HI) with Answer & Explanation",
                                            fontSize = 11.sp,
                                            color = Color(0xFFCBD5E1)
                                        )
                                    }
                                }
                            }

                            Spacer(modifier = Modifier.height(10.dp))

                            com.example.ui.components.ExamPaidFreeDualTabs(
                                examKey = "uppcs",
                                examLabelEn = "UPPCS (Uttar Pradesh PCS)",
                                examLabelHi = "UPPCS (उत्तर प्रदेश पीसीएस)",
                                selectedMode = uppcsMode,
                                freeCountBadge = if (isHi) "7 विषय • 350 फ्री PYQs" else "7 Subjects • 350 Free PYQs",
                                paidCountBadge = if (isHi) "35 फुल-लेंथ प्रो मॉक टेस्ट" else "35 Full-Length Pro Mocks",
                                isHi = isHi,
                                onSelectMode = { mode -> viewModel.selectExamTestSeriesMode("uppcs", mode) }
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            // Prominent "Attempt Free Test (अटेम्प्ट फ्री टेस्ट)" Button at the top of UPPCS
                            Button(
                                onClick = {
                                    if (!isUppcsSelected) {
                                        val statePscCat = categories.firstOrNull { it.id == "state_psc" }
                                        statePscCat?.let { viewModel.selectCategory(it) }
                                    }
                                    viewModel.toggleUppcsFreeTestSections()
                                },
                                colors = ButtonDefaults.buttonColors(containerColor = SaffronGold),
                                shape = RoundedCornerShape(10.dp),
                                contentPadding = PaddingValues(horizontal = 12.dp, vertical = 0.dp),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(46.dp)
                                    .testTag("uppcs_attempt_free_test_btn")
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Quiz,
                                    contentDescription = null,
                                    tint = Navy900,
                                    modifier = Modifier.size(18.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = if (uiState.isUppcsFreeTestSectionExpanded) {
                                        if (isHi) "UPPCS अटेम्प्ट फ्री टेस्ट — 7 सेक्शन चुनें ▲" else "UPPCS Attempt Free Test — Select Section (7 Subjects) ▲"
                                    } else {
                                        if (isHi) "UPPCS अटेम्प्ट फ्री टेस्ट (7 UPPCS सेक्शन खोलें) ▼" else "UPPCS Attempt Free Test (Open 7 UPPCS Sections) ▼"
                                    },
                                    fontSize = 12.5.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Navy900,
                                    maxLines = 1,
                                    softWrap = false,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }

                            if (uppcsMode == "PAID") {
                                val uppcsPaidItems = uiState.customStudyItems.filter {
                                    it.subSectionId == "psc_uppcs" && it.discountedPrice > 0
                                }
                                com.example.ui.components.ExamPaidTestSeriesPanel(
                                    examKey = "uppcs",
                                    examTitleEn = "UPPCS Upper & RO/ARO",
                                    examTitleHi = "UPPCS प्रवर एवं RO/ARO परीक्षा",
                                    paidItems = uppcsPaidItems,
                                    purchasedItemIds = uiState.purchasedItemIds,
                                    isHi = isHi,
                                    onBuyOrOpenItem = { viewModel.openItemDetail(it) },
                                    onAddToCart = { viewModel.addToCart(it) },
                                    onStartPaidMockTest = { viewModel.startUppcsSectionTest("uppcs_history") },
                                    onSwitchToFreeTests = { viewModel.selectExamTestSeriesMode("uppcs", "FREE") }
                                )
                            } else if (uiState.isUppcsFreeTestSectionExpanded) {
                                val uppcsSections = com.example.data.uppcs.UppcsUpCaEcoPyqData.all7UppcsSectionTests
                                Spacer(modifier = Modifier.height(14.dp))
                                Text(
                                    text = if (isHi)
                                        "नीचे दिए गए 7 UPPCS सेक्शन में से किसी भी विषय का 50-प्रश्न टेस्ट सीधे अटेम्प्ट करें:"
                                    else
                                        "Select any of the 7 UPPCS Subject Sections below to directly attempt its 50-Question PYQ Test:",
                                    fontSize = 11.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = SaffronGold
                                )
                                Spacer(modifier = Modifier.height(10.dp))

                                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                    uppcsSections.forEachIndexed { idx, section ->
                                        Card(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .clickable { viewModel.startUppcsSectionTest(section.sectionId) }
                                                .testTag("uppcs_section_card_${section.sectionId}"),
                                            shape = RoundedCornerShape(12.dp),
                                            colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B))
                                        ) {
                                            Row(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .padding(horizontal = 12.dp, vertical = 10.dp),
                                                verticalAlignment = Alignment.CenterVertically,
                                                horizontalArrangement = Arrangement.SpaceBetween
                                            ) {
                                                Row(
                                                    verticalAlignment = Alignment.CenterVertically,
                                                    modifier = Modifier.weight(1f)
                                                ) {
                                                    Box(
                                                        modifier = Modifier
                                                            .size(32.dp)
                                                            .clip(CircleShape)
                                                            .background(SaffronGold),
                                                        contentAlignment = Alignment.Center
                                                    ) {
                                                        Text(
                                                            text = "${idx + 1}",
                                                            fontSize = 12.5.sp,
                                                            fontWeight = FontWeight.ExtraBold,
                                                            color = Navy900
                                                        )
                                                    }
                                                    Spacer(modifier = Modifier.width(10.dp))
                                                    Column {
                                                        Text(
                                                            text = "${section.titleEn} (${section.titleHi})",
                                                            fontSize = 13.sp,
                                                            fontWeight = FontWeight.ExtraBold,
                                                            color = Color.White
                                                        )
                                                        Text(
                                                            text = if (isHi) section.subtitleHi else section.subtitleEn,
                                                            fontSize = 10.5.sp,
                                                            color = Color(0xFF94A3B8)
                                                        )
                                                        Spacer(modifier = Modifier.height(2.dp))
                                                        Text(
                                                            text = "50 PYQ Questions • 4 Options • Bilingual Answer & Explanation",
                                                            fontSize = 10.sp,
                                                            fontWeight = FontWeight.SemiBold,
                                                            color = EmeraldLight
                                                        )
                                                    }
                                                }

                                                Spacer(modifier = Modifier.width(8.dp))

                                                Button(
                                                    onClick = { viewModel.startUppcsSectionTest(section.sectionId) },
                                                    colors = ButtonDefaults.buttonColors(containerColor = EmeraldSuccess),
                                                    shape = RoundedCornerShape(8.dp),
                                                    contentPadding = PaddingValues(horizontal = 10.dp, vertical = 6.dp),
                                                    modifier = Modifier
                                                        .height(34.dp)
                                                        .testTag("start_uppcs_${section.sectionId}")
                                                ) {
                                                    Text(
                                                        text = if (isHi) "टेस्ट दें (50 Q)" else "Attempt (50 Q)",
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
                        }
                    }
                }

                // UKPSC (Uttarakhand PCS) Top Feature: "Attempt Free Test (अटेम्प्ट फ्री टेस्ट)" -> Opens ★ Uttarakhand Special (100 PYQs) + 7 Subject Sections (50 PYQs Each)
                item {
                    val isUkpscSelected = currentSubSection?.id == "psc_ukpsc" || currentCategory.id == "state_psc"
                    val ukpscMode = uiState.examTestSeriesModeMap["ukpsc"] ?: "FREE"
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 10.dp)
                            .border(
                                width = 2.dp,
                                color = SaffronGold,
                                shape = RoundedCornerShape(16.dp)
                            )
                            .testTag("ukpsc_free_test_top_card"),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFF064E3B)),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
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
                                    Box(
                                        modifier = Modifier
                                            .size(42.dp)
                                            .clip(RoundedCornerShape(10.dp))
                                            .background(SaffronGold),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Quiz,
                                            contentDescription = "UKPSC Free Test",
                                            tint = Navy900,
                                            modifier = Modifier.size(24.dp)
                                        )
                                    }
                                    Spacer(modifier = Modifier.width(12.dp))
                                    Column {
                                        Row(verticalAlignment = Alignment.CenterVertically) {
                                            Box(
                                                modifier = Modifier
                                                    .clip(RoundedCornerShape(4.dp))
                                                    .background(SaffronGold)
                                                    .padding(horizontal = 6.dp, vertical = 2.dp)
                                            ) {
                                                Text(
                                                    text = "UKPSC FREE TEST • 450 PYQs",
                                                    fontSize = 9.5.sp,
                                                    fontWeight = FontWeight.ExtraBold,
                                                    color = Navy900
                                                )
                                            }
                                            Spacer(modifier = Modifier.width(6.dp))
                                            Text(
                                                text = "★ उत्तराखंड विशेष 100 PYQs",
                                                fontSize = 10.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Color(0xFFFDE68A)
                                            )
                                        }
                                        Spacer(modifier = Modifier.height(3.dp))
                                        Text(
                                            text = if (isHi)
                                                "उत्तराखंड पीसीएस (UKPSC Prelims): विगत 5 वर्षीय PYQ टेस्ट सीरीज़"
                                            else
                                                "UKPSC (Uttarakhand PCS Prelims): Last 5 Years PYQ Test Series",
                                            fontSize = 14.5.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            color = Color.White
                                        )
                                        Text(
                                            text = if (isHi)
                                                "★ उत्तराखंड विशेष (टॉप 100 PYQs) + 7 विषयवार सेक्शन (50-50 प्रश्न) • द्विभाषी (EN + हिंदी) उत्तर एवं व्याख्या"
                                            else
                                                "★ Uttarakhand Special (Top 100 PYQs) + 7 Subject Sections (50 Qs Each) • Bilingual (EN + HI) Answer & Explanation",
                                            fontSize = 11.sp,
                                            color = Color(0xFFD1FAE5)
                                        )
                                    }
                                }
                            }

                            Spacer(modifier = Modifier.height(10.dp))

                            com.example.ui.components.ExamPaidFreeDualTabs(
                                examKey = "ukpsc",
                                examLabelEn = "UKPSC (Uttarakhand PCS)",
                                examLabelHi = "UKPSC (उत्तराखंड पीसीएस)",
                                selectedMode = ukpscMode,
                                freeCountBadge = if (isHi) "8 सेक्शन • 450 फ्री PYQs" else "8 Sections • 450 Free PYQs",
                                paidCountBadge = if (isHi) "35 फुल-लेंथ प्रो मॉक टेस्ट" else "35 Full-Length Pro Mocks",
                                isHi = isHi,
                                onSelectMode = { mode -> viewModel.selectExamTestSeriesMode("ukpsc", mode) }
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            // Prominent "UKPSC — Attempt Free Test (अटेम्प्ट फ्री टेस्ट)" Button
                            Button(
                                onClick = {
                                    if (!isUkpscSelected) {
                                        val statePscCat = categories.firstOrNull { it.id == "state_psc" }
                                        statePscCat?.let {
                                            viewModel.selectCategory(it)
                                            val ukpscSub = it.subSections.firstOrNull { sub -> sub.id == "psc_ukpsc" }
                                            ukpscSub?.let { sub -> viewModel.selectSubSection(sub) }
                                        }
                                    } else {
                                        viewModel.toggleUkpscFreeTestSections()
                                    }
                                },
                                colors = ButtonDefaults.buttonColors(containerColor = SaffronGold),
                                shape = RoundedCornerShape(10.dp),
                                contentPadding = PaddingValues(horizontal = 12.dp, vertical = 0.dp),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(46.dp)
                                    .testTag("ukpsc_attempt_free_test_btn")
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Quiz,
                                    contentDescription = null,
                                    tint = Navy900,
                                    modifier = Modifier.size(18.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = if (uiState.isUkpscFreeTestSectionExpanded) {
                                        if (isHi) "UKPSC अटेम्प्ट फ्री टेस्ट — 8 सेक्शन चुनें ▲" else "UKPSC Attempt Free Test — Select Section (8 Sections) ▲"
                                    } else {
                                        if (isHi) "UKPSC अटेम्प्ट फ्री टेस्ट (8 सेक्शन खोलें) ▼" else "UKPSC Attempt Free Test (Open 8 Sections) ▼"
                                    },
                                    fontSize = 12.5.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Navy900,
                                    maxLines = 1,
                                    softWrap = false,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }

                            if (ukpscMode == "PAID") {
                                val ukpscPaidItems = uiState.customStudyItems.filter {
                                    it.subSectionId == "psc_ukpsc" && it.discountedPrice > 0
                                }
                                com.example.ui.components.ExamPaidTestSeriesPanel(
                                    examKey = "ukpsc",
                                    examTitleEn = "UKPSC Upper PCS & RO/ARO",
                                    examTitleHi = "उत्तराखंड पीसीएस (प्रवर एवं RO/ARO)",
                                    paidItems = ukpscPaidItems,
                                    purchasedItemIds = uiState.purchasedItemIds,
                                    isHi = isHi,
                                    onBuyOrOpenItem = { viewModel.openItemDetail(it) },
                                    onAddToCart = { viewModel.addToCart(it) },
                                    onStartPaidMockTest = { viewModel.startUkpscSectionTest("ukpsc_special_100") },
                                    onSwitchToFreeTests = { viewModel.selectExamTestSeriesMode("ukpsc", "FREE") }
                                )
                            } else if (uiState.isUkpscFreeTestSectionExpanded) {
                                val ukpscSections = com.example.data.ukpsc.UkpscAllSubjectsPyqData.all8UkpscSectionTests
                                Spacer(modifier = Modifier.height(14.dp))
                                Text(
                                    text = if (isHi)
                                        "नीचे दिए गए 8 UKPSC सेक्शन में से 'उत्तराखंड विशेष (100 प्रश्न)' या किसी भी विषय का 50-प्रश्न टेस्ट सीधे अटेम्प्ट करें:"
                                    else
                                        "Select 'Uttarakhand Special (Top 100 PYQs)' or any of the 7 Subject Sections below to directly attempt the Free Test:",
                                    fontSize = 11.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFFFDE68A)
                                )
                                Spacer(modifier = Modifier.height(10.dp))

                                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                    ukpscSections.forEachIndexed { idx, section ->
                                        Card(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .border(
                                                    width = if (section.isSpecial100) 2.dp else 1.dp,
                                                    color = if (section.isSpecial100) SaffronGold else Color(0xFF10B981),
                                                    shape = RoundedCornerShape(12.dp)
                                                )
                                                .clickable { viewModel.startUkpscSectionTest(section.sectionId) }
                                                .testTag("ukpsc_section_card_${section.sectionId}"),
                                            shape = RoundedCornerShape(12.dp),
                                            colors = CardDefaults.cardColors(
                                                containerColor = if (section.isSpecial100) Color(0xFF0F172A) else Color(0xFF065F46)
                                            )
                                        ) {
                                            Row(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .padding(horizontal = 12.dp, vertical = 10.dp),
                                                verticalAlignment = Alignment.CenterVertically,
                                                horizontalArrangement = Arrangement.SpaceBetween
                                            ) {
                                                Row(
                                                    verticalAlignment = Alignment.CenterVertically,
                                                    modifier = Modifier.weight(1f)
                                                ) {
                                                    Box(
                                                        modifier = Modifier
                                                            .size(32.dp)
                                                            .clip(CircleShape)
                                                            .background(SaffronGold),
                                                        contentAlignment = Alignment.Center
                                                    ) {
                                                        Text(
                                                            text = if (section.isSpecial100) "★" else "${idx + 1}",
                                                            fontSize = 12.5.sp,
                                                            fontWeight = FontWeight.ExtraBold,
                                                            color = Navy900
                                                        )
                                                    }
                                                    Spacer(modifier = Modifier.width(10.dp))
                                                    Column {
                                                        Text(
                                                            text = if (isHi) section.titleHi else section.titleEn,
                                                            fontSize = 13.sp,
                                                            fontWeight = FontWeight.ExtraBold,
                                                            color = if (section.isSpecial100) Color(0xFFFDE68A) else Color.White
                                                        )
                                                        Text(
                                                            text = if (isHi) section.subtitleHi else section.subtitleEn,
                                                            fontSize = 10.5.sp,
                                                            color = Color(0xFFD1FAE5)
                                                        )
                                                        Spacer(modifier = Modifier.height(2.dp))
                                                        Text(
                                                            text = "${section.questionCount} UKPSC PYQ Questions • +1.0 / -0.25 • Bilingual Answer & Explanation",
                                                            fontSize = 10.sp,
                                                            fontWeight = FontWeight.SemiBold,
                                                            color = SaffronGold
                                                        )
                                                    }
                                                }

                                                Spacer(modifier = Modifier.width(8.dp))

                                                Button(
                                                    onClick = { viewModel.startUkpscSectionTest(section.sectionId) },
                                                    colors = ButtonDefaults.buttonColors(
                                                        containerColor = if (section.isSpecial100) SaffronGold else EmeraldSuccess
                                                    ),
                                                    shape = RoundedCornerShape(8.dp),
                                                    contentPadding = PaddingValues(horizontal = 10.dp, vertical = 6.dp),
                                                    modifier = Modifier
                                                        .height(34.dp)
                                                        .testTag("start_${section.sectionId}")
                                                ) {
                                                    Text(
                                                        text = if (isHi) "टेस्ट दें (${section.questionCount} Q)" else "Attempt (${section.questionCount} Q)",
                                                        fontSize = 11.sp,
                                                        fontWeight = FontWeight.ExtraBold,
                                                        color = if (section.isSpecial100) Navy900 else Color.White
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

                // BPSC (Bihar PCS — 70th/71st CCE) Top Feature: "1. Paid Test Series & 2. Free Test Series" -> Opens 7×100-Question Subject Sections (700 PYQs)
                item {
                    val isBpscSelected = currentSubSection?.id == "psc_bpsc" || currentCategory.id == "state_psc"
                    val bpscMode = uiState.examTestSeriesModeMap["bpsc"] ?: "FREE"
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 10.dp)
                            .border(
                                width = 2.dp,
                                color = SaffronGold,
                                shape = RoundedCornerShape(16.dp)
                            )
                            .testTag("bpsc_free_test_top_card"),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFF431407)),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
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
                                    Box(
                                        modifier = Modifier
                                            .size(42.dp)
                                            .clip(RoundedCornerShape(10.dp))
                                            .background(SaffronGold),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Quiz,
                                            contentDescription = "BPSC Free Test",
                                            tint = Navy900,
                                            modifier = Modifier.size(24.dp)
                                        )
                                    }
                                    Spacer(modifier = Modifier.width(12.dp))
                                    Column {
                                        Row(verticalAlignment = Alignment.CenterVertically) {
                                            Box(
                                                modifier = Modifier
                                                    .clip(RoundedCornerShape(4.dp))
                                                    .background(SaffronGold)
                                                    .padding(horizontal = 6.dp, vertical = 2.dp)
                                            ) {
                                                Text(
                                                    text = "BPSC 7×100 PYQ SERIES • 700 Qs",
                                                    fontSize = 9.5.sp,
                                                    fontWeight = FontWeight.ExtraBold,
                                                    color = Navy900
                                                )
                                            }
                                            Spacer(modifier = Modifier.width(6.dp))
                                            Text(
                                                text = "★ बिहार विशेष + 6 विषय (100-100 Q)",
                                                fontSize = 10.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Color(0xFFFDE68A)
                                            )
                                        }
                                        Spacer(modifier = Modifier.height(3.dp))
                                        Text(
                                            text = if (isHi)
                                                "बिहार पीसीएस (70वीं/71वीं BPSC Prelims): 100-100 प्रश्नों की टेस्ट सीरीज़"
                                            else
                                                "BPSC (Bihar PCS Prelims): 100-100 Questions Subject-Wise Test Series",
                                            fontSize = 14.5.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            color = Color.White
                                        )
                                        Text(
                                            text = if (isHi)
                                                "★ बिहार विशेष (100 Q) • हिस्ट्री (100 Q) • पॉलिटी (100 Q) • ज्योग्राफी (100 Q) • इकोनॉमी (100 Q) • साइंस (100 Q) • करंट अफेयर्स (100 Q)"
                                            else
                                                "★ Bihar Special (100 Q) • History (100 Q) • Polity (100 Q) • Geography (100 Q) • Economy (100 Q) • Science (100 Q) • Current Affairs (100 Q)",
                                            fontSize = 11.sp,
                                            color = Color(0xFFFED7AA)
                                        )
                                    }
                                }
                            }

                            Spacer(modifier = Modifier.height(10.dp))

                            com.example.ui.components.ExamPaidFreeDualTabs(
                                examKey = "bpsc",
                                examLabelEn = "BPSC (Bihar PCS)",
                                examLabelHi = "BPSC (बिहार पीसीएस)",
                                selectedMode = bpscMode,
                                freeCountBadge = if (isHi) "7 सेक्शन × 100 Q = 700 फ्री PYQs" else "7 Sections × 100 Q = 700 Free PYQs",
                                paidCountBadge = if (isHi) "40 फुल-लेंथ प्रो मॉक टेस्ट" else "40 Full-Length Pro Mocks",
                                isHi = isHi,
                                onSelectMode = { mode -> viewModel.selectExamTestSeriesMode("bpsc", mode) }
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            Button(
                                onClick = {
                                    if (!isBpscSelected) {
                                        val statePscCat = categories.firstOrNull { it.id == "state_psc" }
                                        statePscCat?.let {
                                            viewModel.selectCategory(it)
                                            val bpscSub = it.subSections.firstOrNull { sub -> sub.id == "psc_bpsc" }
                                            bpscSub?.let { sub -> viewModel.selectSubSection(sub) }
                                        }
                                    } else {
                                        viewModel.toggleBpscFreeTestSections()
                                    }
                                },
                                colors = ButtonDefaults.buttonColors(containerColor = SaffronGold),
                                shape = RoundedCornerShape(10.dp),
                                contentPadding = PaddingValues(horizontal = 12.dp, vertical = 0.dp),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(46.dp)
                                    .testTag("bpsc_attempt_free_test_btn")
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Quiz,
                                    contentDescription = null,
                                    tint = Navy900,
                                    modifier = Modifier.size(18.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = if (uiState.isBpscFreeTestSectionExpanded) {
                                        if (isHi) "BPSC अटेम्प्ट फ्री टेस्ट — 7 सेक्शन चुनें ▲" else "BPSC Attempt Free Test — Select Section (7×100 Qs) ▲"
                                    } else {
                                        if (isHi) "BPSC अटेम्प्ट फ्री टेस्ट (7×100 Q सेक्शन खोलें) ▼" else "BPSC Attempt Free Test (Open 7×100 Q Sections) ▼"
                                    },
                                    fontSize = 12.5.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Navy900,
                                    maxLines = 1,
                                    softWrap = false,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }

                            if (bpscMode == "PAID") {
                                val bpscPaidItems = uiState.customStudyItems.filter {
                                    it.subSectionId == "psc_bpsc" && it.discountedPrice > 0
                                }
                                com.example.ui.components.ExamPaidTestSeriesPanel(
                                    examKey = "bpsc",
                                    examTitleEn = "70th/71st BPSC Combined Prelims & Mains",
                                    examTitleHi = "70वीं/71वीं बीपीएससी (BPSC) प्रारंभिक एवं मुख्य परीक्षा",
                                    paidItems = bpscPaidItems,
                                    purchasedItemIds = uiState.purchasedItemIds,
                                    isHi = isHi,
                                    onBuyOrOpenItem = { viewModel.openItemDetail(it) },
                                    onAddToCart = { viewModel.addToCart(it) },
                                    onStartPaidMockTest = { viewModel.startBpscSectionTest("bpsc_bihar_special") },
                                    onSwitchToFreeTests = { viewModel.selectExamTestSeriesMode("bpsc", "FREE") }
                                )
                            } else if (uiState.isBpscFreeTestSectionExpanded) {
                                val bpscSections = com.example.data.bpsc.BpscAllSubjects100PyqData.all7BpscSectionTests
                                Spacer(modifier = Modifier.height(14.dp))
                                Text(
                                    text = if (isHi)
                                        "नीचे दिए गए 7 BPSC सेक्शन में से 'बिहार विशेष (100 प्रश्न)' या किसी भी विषय का 100-प्रश्न टेस्ट सीधे अटेम्प्ट करें:"
                                    else
                                        "Select 'Bihar Special (100 PYQs)' or any of the 7 Subject Sections below to directly attempt its 100-Question Test:",
                                    fontSize = 11.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFFFDE68A)
                                )
                                Spacer(modifier = Modifier.height(10.dp))

                                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                    bpscSections.forEachIndexed { idx, section ->
                                        Card(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .border(
                                                    width = if (section.isBiharSpecial) 2.dp else 1.dp,
                                                    color = if (section.isBiharSpecial) SaffronGold else Color(0xFFF97316),
                                                    shape = RoundedCornerShape(12.dp)
                                                )
                                                .clickable { viewModel.startBpscSectionTest(section.sectionId) }
                                                .testTag("bpsc_section_card_${section.sectionId}"),
                                            shape = RoundedCornerShape(12.dp),
                                            colors = CardDefaults.cardColors(
                                                containerColor = if (section.isBiharSpecial) Color(0xFF0F172A) else Color(0xFF7C2D12)
                                            )
                                        ) {
                                            Row(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .padding(horizontal = 12.dp, vertical = 10.dp),
                                                verticalAlignment = Alignment.CenterVertically,
                                                horizontalArrangement = Arrangement.SpaceBetween
                                            ) {
                                                Row(
                                                    verticalAlignment = Alignment.CenterVertically,
                                                    modifier = Modifier.weight(1f)
                                                ) {
                                                    Box(
                                                        modifier = Modifier
                                                            .size(32.dp)
                                                            .clip(CircleShape)
                                                            .background(SaffronGold),
                                                        contentAlignment = Alignment.Center
                                                    ) {
                                                        Text(
                                                            text = if (section.isBiharSpecial) "★" else "${idx + 1}",
                                                            fontSize = 12.5.sp,
                                                            fontWeight = FontWeight.ExtraBold,
                                                            color = Navy900
                                                        )
                                                    }
                                                    Spacer(modifier = Modifier.width(10.dp))
                                                    Column {
                                                        Text(
                                                            text = if (isHi) section.titleHi else section.titleEn,
                                                            fontSize = 13.sp,
                                                            fontWeight = FontWeight.ExtraBold,
                                                            color = if (section.isBiharSpecial) Color(0xFFFDE68A) else Color.White
                                                        )
                                                        Text(
                                                            text = if (isHi) section.subtitleHi else section.subtitleEn,
                                                            fontSize = 10.5.sp,
                                                            color = Color(0xFFFED7AA)
                                                        )
                                                        Spacer(modifier = Modifier.height(2.dp))
                                                        Text(
                                                            text = "100 BPSC PYQ Questions • +1.0 / -0.33 • Classroom Bilingual Explanation",
                                                            fontSize = 10.sp,
                                                            fontWeight = FontWeight.SemiBold,
                                                            color = SaffronGold
                                                        )
                                                    }
                                                }

                                                Spacer(modifier = Modifier.width(8.dp))

                                                Button(
                                                    onClick = { viewModel.startBpscSectionTest(section.sectionId) },
                                                    colors = ButtonDefaults.buttonColors(
                                                        containerColor = if (section.isBiharSpecial) SaffronGold else EmeraldSuccess
                                                    ),
                                                    shape = RoundedCornerShape(8.dp),
                                                    contentPadding = PaddingValues(horizontal = 10.dp, vertical = 6.dp),
                                                    modifier = Modifier
                                                        .height(34.dp)
                                                        .testTag("start_${section.sectionId}")
                                                ) {
                                                    Text(
                                                        text = if (isHi) "टेस्ट दें (100 Q)" else "Attempt (100 Q)",
                                                        fontSize = 11.sp,
                                                        fontWeight = FontWeight.ExtraBold,
                                                        color = if (section.isBiharSpecial) Navy900 else Color.White
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

                // UPSSSC (PET, VDO, Lekhpal, Junior Assistant, Lower PCS) Top Feature: "1. Paid Test Series & 2. Free Test Series" -> Opens 9 Syllabus Sections (1,050 PYQs)
                item {
                    val isUpssscSelected = currentSubSection?.id == "sub_upsssc" || currentCategory.id == "subordinate_selection"
                    val upssscMode = uiState.examTestSeriesModeMap["upsssc"] ?: "FREE"
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 10.dp)
                            .border(
                                width = 2.dp,
                                color = SaffronGold,
                                shape = RoundedCornerShape(16.dp)
                            )
                            .testTag("upsssc_free_test_top_card"),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1B4B)),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
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
                                    Box(
                                        modifier = Modifier
                                            .size(42.dp)
                                            .clip(RoundedCornerShape(10.dp))
                                            .background(SaffronGold),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Quiz,
                                            contentDescription = "UPSSSC Free Test",
                                            tint = Navy900,
                                            modifier = Modifier.size(24.dp)
                                        )
                                    }
                                    Spacer(modifier = Modifier.width(12.dp))
                                    Column {
                                        Row(verticalAlignment = Alignment.CenterVertically) {
                                            Box(
                                                modifier = Modifier
                                                    .clip(RoundedCornerShape(4.dp))
                                                    .background(SaffronGold)
                                                    .padding(horizontal = 6.dp, vertical = 2.dp)
                                            ) {
                                                Text(
                                                    text = "UPSSSC 9 SECTIONS • 1,050 PYQs",
                                                    fontSize = 9.5.sp,
                                                    fontWeight = FontWeight.ExtraBold,
                                                    color = Navy900
                                                )
                                            }
                                            Spacer(modifier = Modifier.width(6.dp))
                                            Text(
                                                text = "★ यूपी स्पेशल 250 Q + कंप्यूटर + DI",
                                                fontSize = 10.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Color(0xFFFDE68A)
                                            )
                                        }
                                        Spacer(modifier = Modifier.height(3.dp))
                                        Text(
                                            text = if (isHi)
                                                "यूपी ट्रिपल एससी (UPSSSC PET, VDO, लेखपाल): सिलेबस अनुसार 9 सेक्शन टेस्ट सीरीज़"
                                            else
                                                "UPSSSC (PET, VDO, Lekhpal, Jr. Asst): 9 Syllabus Sections Test Series",
                                            fontSize = 14.5.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            color = Color.White
                                        )
                                        Text(
                                            text = if (isHi)
                                                "GK (हिस्ट्री, पॉलिटी, ज्योग्राफी, इकोनॉमिक्स, एनवायरनमेंट, साइंस एंड टेक: 100-100 Q) • ★ यूपी स्पेशल (Best 250 Q) • कंप्यूटर (100 Q) • डीआई / DI (100 Q)"
                                            else
                                                "GK (History, Polity, Geography, Economics, Environment, Sci-Tech: 100 Qs Each) • ★ UP Special (Best 250 Qs) • Computer (100 Qs) • DI (100 Qs)",
                                            fontSize = 11.sp,
                                            color = Color(0xFFE0E7FF)
                                        )
                                    }
                                }
                            }

                            Spacer(modifier = Modifier.height(10.dp))

                            com.example.ui.components.ExamPaidFreeDualTabs(
                                examKey = "upsssc",
                                examLabelEn = "UPSSSC (PET / VDO / Lekhpal)",
                                examLabelHi = "UPSSSC (यूपी ट्रिपल एससी)",
                                selectedMode = upssscMode,
                                freeCountBadge = if (isHi) "9 सेक्शन • 1,050 फ्री PYQs" else "9 Sections • 1,050 Free PYQs",
                                paidCountBadge = if (isHi) "45 फुल-लेंथ प्रो मॉक टेस्ट" else "45 Full-Length Pro Mocks",
                                isHi = isHi,
                                onSelectMode = { mode -> viewModel.selectExamTestSeriesMode("upsssc", mode) }
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            Button(
                                onClick = {
                                    if (!isUpssscSelected) {
                                        val subCat = categories.firstOrNull { it.id == "subordinate_selection" }
                                        subCat?.let {
                                            viewModel.selectCategory(it)
                                            val upssscSub = it.subSections.firstOrNull { sub -> sub.id == "sub_upsssc" }
                                            upssscSub?.let { sub -> viewModel.selectSubSection(sub) }
                                        }
                                    } else {
                                        viewModel.toggleUpssscFreeTestSections()
                                    }
                                },
                                colors = ButtonDefaults.buttonColors(containerColor = SaffronGold),
                                shape = RoundedCornerShape(10.dp),
                                contentPadding = PaddingValues(horizontal = 12.dp, vertical = 0.dp),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(46.dp)
                                    .testTag("upsssc_attempt_free_test_btn")
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Quiz,
                                    contentDescription = null,
                                    tint = Navy900,
                                    modifier = Modifier.size(18.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = if (uiState.isUpssscFreeTestSectionExpanded) {
                                        if (isHi) "UPSSSC अटेम्प्ट फ्री टेस्ट — 9 सेक्शन चुनें ▲" else "UPSSSC Attempt Free Test — Select Section (9 Sections) ▲"
                                    } else {
                                        if (isHi) "UPSSSC अटेम्प्ट फ्री टेस्ट (9 सेक्शन खोलें) ▼" else "UPSSSC Attempt Free Test (Open 9 Sections) ▼"
                                    },
                                    fontSize = 12.5.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Navy900,
                                    maxLines = 1,
                                    softWrap = false,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }

                            if (upssscMode == "PAID") {
                                val upssscPaidItems = uiState.customStudyItems.filter {
                                    it.subSectionId == "sub_upsssc" && it.discountedPrice > 0
                                }
                                com.example.ui.components.ExamPaidTestSeriesPanel(
                                    examKey = "upsssc",
                                    examTitleEn = "UPSSSC PET, VDO, Lekhpal & Jr. Assistant",
                                    examTitleHi = "UPSSSC (PET, VDO, लेखपाल, कनिष्ठ सहायक)",
                                    paidItems = upssscPaidItems,
                                    purchasedItemIds = uiState.purchasedItemIds,
                                    isHi = isHi,
                                    onBuyOrOpenItem = { viewModel.openItemDetail(it) },
                                    onAddToCart = { viewModel.addToCart(it) },
                                    onStartPaidMockTest = { viewModel.startUpssscSectionTest("upsssc_up_special_250") },
                                    onSwitchToFreeTests = { viewModel.selectExamTestSeriesMode("upsssc", "FREE") }
                                )
                            } else if (uiState.isUpssscFreeTestSectionExpanded) {
                                val upssscSections = com.example.data.upsssc.UpssscAllSubjectsPyqData.all9UpssscSectionTests
                                Spacer(modifier = Modifier.height(14.dp))
                                Text(
                                    text = if (isHi)
                                        "नीचे दिए गए 9 UPSSSC सेक्शन (6 GK×100 Q, ★ यूपी स्पेशल 250 Q, कंप्यूटर 100 Q, डीआई 100 Q) में से किसी भी सेक्शन का टेस्ट सीधे अटेम्प्ट करें:"
                                    else
                                        "Select any of the 9 UPSSSC Syllabus Sections below (6 GK×100 Q, ★ UP Special 250 Q, Computer 100 Q, DI 100 Q) to directly attempt its Free Test:",
                                    fontSize = 11.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFFFDE68A)
                                )
                                Spacer(modifier = Modifier.height(10.dp))

                                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                    upssscSections.forEachIndexed { idx, section ->
                                        Card(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .border(
                                                    width = if (section.isUpSpecial250) 2.dp else 1.dp,
                                                    color = if (section.isUpSpecial250) SaffronGold else Color(0xFF818CF8),
                                                    shape = RoundedCornerShape(12.dp)
                                                )
                                                .clickable { viewModel.startUpssscSectionTest(section.sectionId) }
                                                .testTag("upsssc_section_card_${section.sectionId}"),
                                            shape = RoundedCornerShape(12.dp),
                                            colors = CardDefaults.cardColors(
                                                containerColor = if (section.isUpSpecial250) Color(0xFF0F172A) else Color(0xFF312E81)
                                            )
                                        ) {
                                            Row(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .padding(horizontal = 12.dp, vertical = 10.dp),
                                                verticalAlignment = Alignment.CenterVertically,
                                                horizontalArrangement = Arrangement.SpaceBetween
                                            ) {
                                                Row(
                                                    verticalAlignment = Alignment.CenterVertically,
                                                    modifier = Modifier.weight(1f)
                                                ) {
                                                    Box(
                                                        modifier = Modifier
                                                            .size(32.dp)
                                                            .clip(CircleShape)
                                                            .background(SaffronGold),
                                                        contentAlignment = Alignment.Center
                                                    ) {
                                                        Text(
                                                            text = if (section.isUpSpecial250) "★" else "${idx + 1}",
                                                            fontSize = 12.5.sp,
                                                            fontWeight = FontWeight.ExtraBold,
                                                            color = Navy900
                                                        )
                                                    }
                                                    Spacer(modifier = Modifier.width(10.dp))
                                                    Column {
                                                        Text(
                                                            text = if (isHi) section.titleHi else section.titleEn,
                                                            fontSize = 13.sp,
                                                            fontWeight = FontWeight.ExtraBold,
                                                            color = if (section.isUpSpecial250) Color(0xFFFDE68A) else Color.White,
                                                            maxLines = 1,
                                                            overflow = TextOverflow.Ellipsis
                                                        )
                                                        Text(
                                                            text = if (isHi) section.subtitleHi else section.subtitleEn,
                                                            fontSize = 10.5.sp,
                                                            color = Color(0xFFE0E7FF),
                                                            maxLines = 1,
                                                            overflow = TextOverflow.Ellipsis
                                                        )
                                                        Spacer(modifier = Modifier.height(2.dp))
                                                        Text(
                                                            text = "${section.questionCount} UPSSSC PYQ Questions • +1.0 / -0.25 • Bilingual Explanation",
                                                            fontSize = 10.sp,
                                                            fontWeight = FontWeight.SemiBold,
                                                            color = SaffronGold,
                                                            maxLines = 1,
                                                            overflow = TextOverflow.Ellipsis
                                                        )
                                                    }
                                                }

                                                Spacer(modifier = Modifier.width(8.dp))

                                                Button(
                                                    onClick = { viewModel.startUpssscSectionTest(section.sectionId) },
                                                    colors = ButtonDefaults.buttonColors(
                                                        containerColor = if (section.isUpSpecial250) SaffronGold else EmeraldSuccess
                                                    ),
                                                    shape = RoundedCornerShape(8.dp),
                                                    contentPadding = PaddingValues(horizontal = 10.dp, vertical = 6.dp),
                                                    modifier = Modifier
                                                        .height(34.dp)
                                                        .testTag("start_${section.sectionId}")
                                                ) {
                                                    Text(
                                                        text = if (isHi) "टेस्ट दें (${section.questionCount} Q)" else "Attempt (${section.questionCount} Q)",
                                                        fontSize = 11.sp,
                                                        fontWeight = FontWeight.ExtraBold,
                                                        color = if (section.isUpSpecial250) Navy900 else Color.White,
                                                        maxLines = 1,
                                                        softWrap = false
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

                // UKSSSC (Uttarakhand Group C & Group D — VDO, Patwari, Kanishth Sahayak, Forest Guard, Police) Top Feature: "1. Paid Test Series & 2. Free Test Series" -> Opens 10 Syllabus Sections (1,150 PYQs)
                item {
                    val isUkssscSelected = currentSubSection?.id == "sub_uksssc" || currentCategory.id == "subordinate_selection"
                    val ukssscMode = uiState.examTestSeriesModeMap["uksssc"] ?: "FREE"
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 10.dp)
                            .border(
                                width = 2.dp,
                                color = SaffronGold,
                                shape = RoundedCornerShape(16.dp)
                            )
                            .testTag("uksssc_free_test_top_card"),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFF134E4A)),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
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
                                    Box(
                                        modifier = Modifier
                                            .size(42.dp)
                                            .clip(RoundedCornerShape(10.dp))
                                            .background(SaffronGold),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Quiz,
                                            contentDescription = "UKSSSC Free Test",
                                            tint = Navy900,
                                            modifier = Modifier.size(24.dp)
                                        )
                                    }
                                    Spacer(modifier = Modifier.width(12.dp))
                                    Column {
                                        Row(verticalAlignment = Alignment.CenterVertically) {
                                            Box(
                                                modifier = Modifier
                                                    .clip(RoundedCornerShape(4.dp))
                                                    .background(SaffronGold)
                                                    .padding(horizontal = 6.dp, vertical = 2.dp)
                                            ) {
                                                Text(
                                                    text = "UKSSSC • 1,150 PYQs",
                                                    fontSize = 9.5.sp,
                                                    fontWeight = FontWeight.ExtraBold,
                                                    color = Navy900,
                                                    maxLines = 1,
                                                    softWrap = false
                                                )
                                            }
                                            Spacer(modifier = Modifier.width(6.dp))
                                            Text(
                                                text = "★ उत्तराखंड स्पेशल 250 Q + 9 विषय",
                                                fontSize = 10.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Color(0xFFFDE68A),
                                                maxLines = 1,
                                                softWrap = false,
                                                overflow = TextOverflow.Ellipsis
                                            )
                                        }
                                        Spacer(modifier = Modifier.height(3.dp))
                                        Text(
                                            text = if (isHi)
                                                "UKSSSC (उत्तराखंड समूह 'ग' एवं 'घ'): 10 सेक्शन टेस्ट सीरीज़"
                                            else
                                                "UKSSSC (Uttarakhand Group C & D): 10 Sections Test Series",
                                            fontSize = 14.5.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            color = Color.White,
                                            maxLines = 1,
                                            overflow = TextOverflow.Ellipsis
                                        )
                                        Text(
                                            text = if (isHi)
                                                "★ उत्तराखंड स्पेशल (250 Q) • GK 6 विषय (100-100 Q) • सामान्य हिंदी (100 Q) • कंप्यूटर (100 Q) • रीजनिंग व DI (100 Q)"
                                            else
                                                "★ Uttarakhand Special (250 Qs) • GK 6 Subjects (100 Qs Each) • Hindi (100 Qs) • Computer (100 Qs) • Reasoning & DI (100 Qs)",
                                            fontSize = 11.sp,
                                            color = Color(0xFFCCFBF1),
                                            maxLines = 2,
                                            overflow = TextOverflow.Ellipsis
                                        )
                                    }
                                }
                            }

                            Spacer(modifier = Modifier.height(10.dp))

                            com.example.ui.components.ExamPaidFreeDualTabs(
                                examKey = "uksssc",
                                examLabelEn = "UKSSSC (Uttarakhand Group C & D)",
                                examLabelHi = "UKSSSC (उत्तराखंड समूह 'ग' एवं 'घ')",
                                selectedMode = ukssscMode,
                                freeCountBadge = if (isHi) "10 सेक्शन • 1,150 फ्री PYQs" else "10 Sections • 1,150 Free PYQs",
                                paidCountBadge = if (isHi) "40 फुल-लेंथ प्रो मॉक टेस्ट" else "40 Full-Length Pro Mocks",
                                isHi = isHi,
                                onSelectMode = { mode -> viewModel.selectExamTestSeriesMode("uksssc", mode) }
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            Button(
                                onClick = {
                                    if (!isUkssscSelected) {
                                        val subCat = categories.firstOrNull { it.id == "subordinate_selection" }
                                        subCat?.let {
                                            viewModel.selectCategory(it)
                                            val ukssscSub = it.subSections.firstOrNull { sub -> sub.id == "sub_uksssc" }
                                            ukssscSub?.let { sub -> viewModel.selectSubSection(sub) }
                                        }
                                    } else {
                                        viewModel.toggleUkssscFreeTestSections()
                                    }
                                },
                                colors = ButtonDefaults.buttonColors(containerColor = SaffronGold),
                                shape = RoundedCornerShape(10.dp),
                                contentPadding = PaddingValues(horizontal = 12.dp, vertical = 0.dp),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(46.dp)
                                    .testTag("uksssc_attempt_free_test_btn")
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Quiz,
                                    contentDescription = null,
                                    tint = Navy900,
                                    modifier = Modifier.size(18.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = if (uiState.isUkssscFreeTestSectionExpanded) {
                                        if (isHi) "UKSSSC अटेम्प्ट फ्री टेस्ट — 10 सेक्शन चुनें ▲" else "UKSSSC Attempt Free Test — Select Section (10 Sections) ▲"
                                    } else {
                                        if (isHi) "UKSSSC अटेम्प्ट फ्री टेस्ट (10 सेक्शन खोलें) ▼" else "UKSSSC Attempt Free Test (Open 10 Sections) ▼"
                                    },
                                    fontSize = 12.5.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Navy900,
                                    maxLines = 1,
                                    softWrap = false,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }

                            if (ukssscMode == "PAID") {
                                val ukssscPaidItems = uiState.customStudyItems.filter {
                                    it.subSectionId == "sub_uksssc" && it.discountedPrice > 0
                                }
                                com.example.ui.components.ExamPaidTestSeriesPanel(
                                    examKey = "uksssc",
                                    examTitleEn = "UKSSSC Group C & D (VDO, Patwari, Kanishth Sahayak, Forest Guard)",
                                    examTitleHi = "UKSSSC समूह 'ग' एवं 'घ' (VDO, पटवारी, कनिष्ठ सहायक, वन आरक्षी)",
                                    paidItems = ukssscPaidItems,
                                    purchasedItemIds = uiState.purchasedItemIds,
                                    isHi = isHi,
                                    onBuyOrOpenItem = { viewModel.openItemDetail(it) },
                                    onAddToCart = { viewModel.addToCart(it) },
                                    onStartPaidMockTest = { viewModel.startUkssscSectionTest("uksssc_uk_special_250") },
                                    onSwitchToFreeTests = { viewModel.selectExamTestSeriesMode("uksssc", "FREE") }
                                )
                            } else if (uiState.isUkssscFreeTestSectionExpanded) {
                                val ukssscSections = com.example.data.uksssc.UkssscAllSubjectsPyqData.all10UkssscSectionTests
                                Spacer(modifier = Modifier.height(14.dp))
                                Text(
                                    text = if (isHi)
                                        "नीचे दिए गए 10 UKSSSC सेक्शन (★ उत्तराखंड स्पेशल 250 Q, 6 GK×100 Q, सामान्य हिंदी 100 Q, कंप्यूटर 100 Q, रीजनिंग/DI 100 Q) में से किसी भी सेक्शन का टेस्ट सीधे अटेम्प्ट करें:"
                                    else
                                        "Select any of the 10 UKSSSC Syllabus Sections below (★ Uttarakhand Special 250 Q, 6 GK×100 Q, Hindi 100 Q, Computer 100 Q, Reasoning/DI 100 Q) to directly attempt its Free Test:",
                                    fontSize = 11.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFFFDE68A)
                                )
                                Spacer(modifier = Modifier.height(10.dp))

                                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                    ukssscSections.forEachIndexed { idx, section ->
                                        Card(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .border(
                                                    width = if (section.isUkSpecial250) 2.dp else 1.dp,
                                                    color = if (section.isUkSpecial250) SaffronGold else Color(0xFF2DD4BF),
                                                    shape = RoundedCornerShape(12.dp)
                                                )
                                                .clickable { viewModel.startUkssscSectionTest(section.sectionId) }
                                                .testTag("uksssc_section_card_${section.sectionId}"),
                                            shape = RoundedCornerShape(12.dp),
                                            colors = CardDefaults.cardColors(
                                                containerColor = if (section.isUkSpecial250) Color(0xFF0F172A) else Color(0xFF115E59)
                                            )
                                        ) {
                                            Row(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .padding(horizontal = 12.dp, vertical = 10.dp),
                                                verticalAlignment = Alignment.CenterVertically,
                                                horizontalArrangement = Arrangement.SpaceBetween
                                            ) {
                                                Row(
                                                    verticalAlignment = Alignment.CenterVertically,
                                                    modifier = Modifier.weight(1f)
                                                ) {
                                                    Box(
                                                        modifier = Modifier
                                                            .size(32.dp)
                                                            .clip(CircleShape)
                                                            .background(SaffronGold),
                                                        contentAlignment = Alignment.Center
                                                    ) {
                                                        Text(
                                                            text = if (section.isUkSpecial250) "★" else "${idx + 1}",
                                                            fontSize = 12.5.sp,
                                                            fontWeight = FontWeight.ExtraBold,
                                                            color = Navy900
                                                        )
                                                    }
                                                    Spacer(modifier = Modifier.width(10.dp))
                                                    Column {
                                                        Text(
                                                            text = if (isHi) section.titleHi else section.titleEn,
                                                            fontSize = 13.sp,
                                                            fontWeight = FontWeight.ExtraBold,
                                                            color = if (section.isUkSpecial250) Color(0xFFFDE68A) else Color.White,
                                                            maxLines = 1,
                                                            overflow = TextOverflow.Ellipsis
                                                        )
                                                        Text(
                                                            text = if (isHi) section.subtitleHi else section.subtitleEn,
                                                            fontSize = 10.5.sp,
                                                            color = Color(0xFFCCFBF1),
                                                            maxLines = 1,
                                                            overflow = TextOverflow.Ellipsis
                                                        )
                                                        Spacer(modifier = Modifier.height(2.dp))
                                                        Text(
                                                            text = "${section.questionCount} UKSSSC PYQ Questions • +1.0 / -0.25 • Bilingual Explanation",
                                                            fontSize = 10.sp,
                                                            fontWeight = FontWeight.SemiBold,
                                                            color = SaffronGold,
                                                            maxLines = 1,
                                                            overflow = TextOverflow.Ellipsis
                                                        )
                                                    }
                                                }

                                                Spacer(modifier = Modifier.width(8.dp))

                                                Button(
                                                    onClick = { viewModel.startUkssscSectionTest(section.sectionId) },
                                                    colors = ButtonDefaults.buttonColors(
                                                        containerColor = if (section.isUkSpecial250) SaffronGold else EmeraldSuccess
                                                    ),
                                                    shape = RoundedCornerShape(8.dp),
                                                    contentPadding = PaddingValues(horizontal = 10.dp, vertical = 6.dp),
                                                    modifier = Modifier
                                                        .height(34.dp)
                                                        .testTag("start_${section.sectionId}")
                                                ) {
                                                    Text(
                                                        text = if (isHi) "टेस्ट दें (${section.questionCount} Q)" else "Attempt (${section.questionCount} Q)",
                                                        fontSize = 11.sp,
                                                        fontWeight = FontWeight.ExtraBold,
                                                        color = if (section.isUkSpecial250) Navy900 else Color.White,
                                                        maxLines = 1,
                                                        softWrap = false
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

                // SSC Exam Section Component (SSC CGL / CHSL / CPO Tabs • Free & Paid Toggles • 8 Sections × 100 PYQs)
                item {
                    val isSscSelected = currentCategory.id == "ssc" || currentSubSection?.id?.startsWith("ssc_") == true
                    com.example.ui.components.SscExamSectionComponent(
                        uiState = uiState,
                        isHi = isHi,
                        cardTestTag = "ssc_free_test_top_card",
                        attemptButtonTestTag = "ssc_attempt_free_test_btn",
                        sectionRowTagPrefix = "ssc_section_card_",
                        showHubButton = false,
                        onSelectExamTab = { tabCode -> viewModel.selectSscExamTab(tabCode) },
                        onSelectTestSeriesMode = { mode -> viewModel.selectExamTestSeriesMode("ssc", mode) },
                        onSelectSubjectFilter = { filter -> viewModel.selectSscSubjectFilter(filter) },
                        onToggleExpandFreeTests = {
                            if (!isSscSelected) {
                                val sscCat = categories.firstOrNull { it.id == "ssc" }
                                sscCat?.let {
                                    viewModel.selectCategory(it)
                                    val sscSub = it.subSections.firstOrNull { sub -> sub.id == "ssc_cgl" }
                                    sscSub?.let { sub -> viewModel.selectSubSection(sub) }
                                }
                            } else {
                                viewModel.toggleSscFreeTestSections()
                            }
                        },
                        onOpenSscHub = { viewModel.openSscSectionAndExpandFreeTests() },
                        onStartSectionTest = { sectionId -> viewModel.startSscSectionTest(sectionId) },
                        onBuyOrOpenPaidItem = { item -> viewModel.openItemDetail(item) },
                        onAddPaidItemToCart = { item -> viewModel.addToCart(item) }
                    )
                }

                // IIT JEE Exam Section Component (Top IIT JEE Icon • Paid vs Free Test Series • 1. IIT JEE Main & 2. IIT JEE Advanced • 5 Subjects × 100 PYQs Each)
                item {
                    val isIitJeeSelected = currentCategory.id == "jee_neet" || currentSubSection?.id?.startsWith("iit_jee") == true
                    com.example.ui.components.IitJeeExamSectionComponent(
                        uiState = uiState,
                        isHi = isHi,
                        cardTestTag = "iit_jee_free_test_top_card",
                        attemptButtonTestTag = "iit_jee_attempt_free_test_btn",
                        sectionRowTagPrefix = "iit_jee_section_card_",
                        showHubButton = false,
                        onSelectLevelTab = { levelTab -> viewModel.selectIitJeeLevelTab(levelTab) },
                        onSelectTestSeriesMode = { mode -> viewModel.selectExamTestSeriesMode("iit_jee", mode) },
                        onSelectSubjectFilter = { filter -> viewModel.selectIitJeeSubjectFilter(filter) },
                        onToggleExpandFreeTests = {
                            if (!isIitJeeSelected) {
                                val jeeCat = categories.firstOrNull { it.id == "jee_neet" }
                                jeeCat?.let {
                                    viewModel.selectCategory(it)
                                    val jeeSub = it.subSections.firstOrNull { sub -> sub.id == "iit_jee" }
                                    jeeSub?.let { sub -> viewModel.selectSubSection(sub) }
                                }
                            } else {
                                viewModel.toggleIitJeeFreeTestSections()
                            }
                        },
                        onOpenIitJeeHub = { viewModel.openIitJeeSectionAndExpandFreeTests() },
                        onStartSectionTest = { sectionId -> viewModel.startIitJeeSectionTest(sectionId) },
                        onBuyOrOpenPaidItem = { item -> viewModel.openItemDetail(item) },
                        onAddPaidItemToCart = { item -> viewModel.addToCart(item) }
                    )
                }

                // NEET (UG) Exam Section Component (Top NEET Icon • Paid vs Free Test Series • 6 Subjects × 100 PYQs Each = 600 Qs)
                item {
                    val isNeetSelected = currentCategory.id == "jee_neet" || currentSubSection?.id == "neet_ug"
                    com.example.ui.components.NeetExamSectionComponent(
                        uiState = uiState,
                        isHi = isHi,
                        cardTestTag = "neet_free_test_top_card",
                        attemptButtonTestTag = "neet_attempt_free_test_btn",
                        sectionRowTagPrefix = "neet_section_card_",
                        showHubButton = false,
                        onSelectTestSeriesMode = { mode -> viewModel.selectExamTestSeriesMode("neet", mode) },
                        onSelectSubjectFilter = { filter -> viewModel.selectNeetSubjectFilter(filter) },
                        onToggleExpandFreeTests = {
                            if (!isNeetSelected) {
                                val jeeCat = categories.firstOrNull { it.id == "jee_neet" }
                                jeeCat?.let {
                                    viewModel.selectCategory(it)
                                    val neetSub = it.subSections.firstOrNull { sub -> sub.id == "neet_ug" }
                                    neetSub?.let { sub -> viewModel.selectSubSection(sub) }
                                }
                            } else {
                                viewModel.toggleNeetFreeTestSections()
                            }
                        },
                        onOpenNeetHub = { viewModel.openNeetSectionAndExpandFreeTests() },
                        onStartSectionTest = { sectionId -> viewModel.startNeetSectionTest(sectionId) },
                        onBuyOrOpenPaidItem = { item -> viewModel.openItemDetail(item) },
                        onAddPaidItemToCart = { item -> viewModel.addToCart(item) }
                    )
                }

                // UGC NET Exam Section Component (Top UGC NET Icon • Paid vs Free Test Series • 1. Paper 1 [10 Units × 100 MCQs] & 2. Paper 2 [12 Subjects × 100 MCQs])
                item {
                    val isUgcNetSelected = currentCategory.id == "ugc_csir_net" || currentSubSection?.id?.startsWith("ugc_net") == true
                    com.example.ui.components.UgcNetExamSectionComponent(
                        uiState = uiState,
                        isHi = isHi,
                        cardTestTag = "ugc_net_free_test_top_card",
                        attemptButtonTestTag = "ugc_net_attempt_free_test_btn",
                        sectionRowTagPrefix = "ugc_net_section_card_",
                        showHubButton = false,
                        onSelectPaperTab = { paperTab -> viewModel.selectUgcNetPaperTab(paperTab) },
                        onSelectTestSeriesMode = { mode -> viewModel.selectExamTestSeriesMode("ugc_net", mode) },
                        onSelectSubjectFilter = { filter -> viewModel.selectUgcNetSubjectFilter(filter) },
                        onToggleExpandFreeTests = {
                            if (!isUgcNetSelected) {
                                val ugcCat = categories.firstOrNull { it.id == "ugc_csir_net" }
                                ugcCat?.let {
                                    viewModel.selectCategory(it)
                                    val ugcSub = it.subSections.firstOrNull { sub -> sub.id == "ugc_net_paper1" }
                                    ugcSub?.let { sub -> viewModel.selectSubSection(sub) }
                                }
                            } else {
                                viewModel.toggleUgcNetFreeTestSections()
                            }
                        },
                        onOpenUgcNetHub = { viewModel.openUgcNetSectionAndExpandFreeTests() },
                        onStartSectionTest = { sectionId -> viewModel.startUgcNetSectionTest(sectionId) },
                        onBuyOrOpenPaidItem = { item -> viewModel.openItemDetail(item) },
                        onAddPaidItemToCart = { item -> viewModel.addToCart(item) }
                    )
                }

                // Teaching Eligibility Test (TET — सीटेट CTET • यूपीटेट UPTET • यूटेट व अन्य) Exam Section Component (7 Subjects × 100 PYQs = 700 Qs)
                item {
                    val isTetSelected = currentCategory.id == "teaching" || currentSubSection?.id?.startsWith("tet_") == true
                    com.example.ui.components.TetExamSectionComponent(
                        uiState = uiState,
                        isHi = isHi,
                        cardTestTag = "tet_free_test_top_card",
                        attemptButtonTestTag = "tet_attempt_free_test_btn",
                        sectionRowTagPrefix = "tet_section_card",
                        showHubButton = false,
                        onSelectExamTab = { examTab -> viewModel.selectTetExamTab(examTab) },
                        onSelectTestSeriesMode = { mode -> viewModel.selectExamTestSeriesMode("tet", mode) },
                        onSelectSubjectFilter = { filter -> viewModel.selectTetSubjectFilter(filter) },
                        onToggleExpandFreeTests = {
                            if (!isTetSelected) {
                                val tetCat = categories.firstOrNull { it.id == "teaching" }
                                tetCat?.let {
                                    viewModel.selectCategory(it)
                                    val tetSub = it.subSections.firstOrNull { sub -> sub.id == "tet_central_state" }
                                    tetSub?.let { sub -> viewModel.selectSubSection(sub) }
                                }
                            } else {
                                viewModel.toggleTetFreeTestSections()
                            }
                        },
                        onOpenTetHub = { viewModel.openTetSectionAndExpandFreeTests() },
                        onStartSectionTest = { sectionId -> viewModel.startTetSectionTest(sectionId) },
                        onBuyOrOpenPaidItem = { item -> viewModel.openItemDetail(item) },
                        onAddPaidItemToCart = { item -> viewModel.addToCart(item) }
                    )
                }

                // Tier 3: Subject Breakdown Chips
                if (subjects.isNotEmpty()) {
                    item {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 10.dp)
                        ) {
                            Text(
                                text = if (isHi) "विषय (Subjects - ${subjects.size}):" else "Subjects Breakdown (${subjects.size}):",
                                fontSize = 12.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = Navy900
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            LazyRow(
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                items(subjects) { subj ->
                                    val isSelected = currentSubject?.id == subj.id
                                    Box(
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(8.dp))
                                            .background(if (isSelected) SaffronGold else Color.White)
                                            .border(1.dp, if (isSelected) SaffronGold else Color(0xFFE2E8F0), RoundedCornerShape(8.dp))
                                            .clickable {
                                                viewModel.selectSubject(subj)
                                                if (subj.id.startsWith("ukpsc_")) {
                                                    viewModel.startUkpscSectionTest(subj.id)
                                                } else if (subj.id.startsWith("bpsc_")) {
                                                    viewModel.startBpscSectionTest(subj.id)
                                                } else if (subj.id.startsWith("upsssc_")) {
                                                    viewModel.startUpssscSectionTest(subj.id)
                                                } else if (subj.id.startsWith("uksssc_")) {
                                                    viewModel.startUkssscSectionTest(subj.id)
                                                } else if (subj.id.startsWith("ssc_")) {
                                                    viewModel.startSscSectionTest(subj.id)
                                                } else if (subj.id.startsWith("jee_")) {
                                                    viewModel.startIitJeeSectionTest(subj.id)
                                                } else if (subj.id.startsWith("neet_")) {
                                                    viewModel.startNeetSectionTest(subj.id)
                                                } else if (subj.id.startsWith("ugc_")) {
                                                    viewModel.startUgcNetSectionTest(subj.id)
                                                } else if (subj.id.startsWith("tet_")) {
                                                    viewModel.startTetSectionTest(subj.id)
                                                }
                                            }
                                            .padding(horizontal = 12.dp, vertical = 7.dp)
                                    ) {
                                        Text(
                                            text = if (isHi) subj.hindiName else subj.name,
                                            fontSize = 11.5.sp,
                                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                                            color = if (isSelected) Color.White else Navy900
                                        )
                                    }
                                }
                            }
                        }
                    }
                }

                // Active Path Banner
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 6.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Navy100)
                            .padding(horizontal = 12.dp, vertical = 8.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Folder,
                                contentDescription = null,
                                tint = Navy900,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            val subSecLabel = if (isHi) (currentSubSection?.hindiName ?: "") else (currentSubSection?.name ?: "")
                            val subjLabel = if (isHi) (currentSubject?.hindiName ?: "") else (currentSubject?.name ?: "")
                            Text(
                                text = "${currentCategory.name} > $subSecLabel > $subjLabel",
                                fontSize = 11.5.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Navy900
                            )
                        }
                    }
                }

                // Available E-books & Test Series in this section
                item {
                    Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
                        Text(
                            text = if (isHi) "उपलब्ध ई-बुक्स एवं टेस्ट सीरीज़ (${matchingItems.size})" else "Available E-Books & Test Series (${matchingItems.size})",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = Navy900
                        )
                    }
                }

                if (matchingItems.isEmpty()) {
                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(32.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = if (isHi) "इस विषय की ई-बुक्स शीघ्र प्रकाशित हो रही हैं।" else "E-Books for this subject are being published soon.",
                                fontSize = 13.sp,
                                color = Color(0xFF64748B)
                            )
                        }
                    }
                } else {
                    items(matchingItems) { item ->
                        StudyItemCard(
                            item = item,
                            isWishlisted = uiState.wishlistIds.contains(item.id),
                            isPurchased = uiState.purchasedItemIds.contains(item.id),
                            isInCart = uiState.cartItems.any { it.studyItem.id == item.id },
                            isHi = isHi,
                            onItemClick = { viewModel.openItemDetail(item) },
                            onReadSample = {
                                if (item.type == ContentType.EBOOK) {
                                    viewModel.openReader(item)
                                } else {
                                    viewModel.startTest()
                                }
                            },
                            onAddToCart = { viewModel.addToCart(item) },
                            onToggleWishlist = { viewModel.toggleWishlist(item.id) },
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp)
                        )
                    }
                }
            }
        }
    }

    // Add SubTopic Dialog
    showAddSubTopicDialogForSubjectId?.let { targetSubjectId ->
        AddSubTopicDialog(
            subjectId = targetSubjectId,
            isHi = isHi,
            onDismiss = { showAddSubTopicDialogForSubjectId = null },
            onConfirm = { name, hindiName, importance, hours ->
                viewModel.addSubTopicToSubject(targetSubjectId, name, hindiName, importance, hours)
                showAddSubTopicDialogForSubjectId = null
            }
        )
    }
}

/**
 * View displaying the live Room SQLite database relational model:
 * ExamEntity -> SubjectEntity -> SubTopicEntity
 */
@Composable
fun RoomDatabaseHierarchyView(
    hierarchies: List<ExamWithSubjectsAndSubTopics>,
    isHi: Boolean = false,
    onAddSubTopicClick: (String) -> Unit,
    onDeleteSubTopic: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(
                            text = if (isHi) "Room SQLite रिलेशनल डेटा मॉडल" else "Room SQLite Relational Data Model",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = Navy900
                        )
                        Text(
                            text = if (isHi) "3-स्तरीय रिलेशनल हायरार्की: Exam ➔ Subject ➔ Sub-topic" else "3-Tier Relational Hierarchy: Exam ➔ Subject ➔ Sub-topic",
                            fontSize = 11.sp,
                            color = Color(0xFF64748B)
                        )
                    }

                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(6.dp))
                            .background(EmeraldLight)
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    ) {
                        Text(
                            text = "✓ Live Room Flow",
                            fontSize = 10.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = EmeraldSuccess
                        )
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))

                if (hierarchies.isEmpty()) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = if (isHi) "डेटाबेस लोड हो रहा है..." else "Loading database...",
                            fontSize = 12.sp,
                            color = Color(0xFF64748B)
                        )
                    }
                } else {
                    hierarchies.forEach { examHierarchy ->
                        var isExamExpanded by remember { mutableStateOf(examHierarchy.exam.id == "upsc_cse") }

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 5.dp),
                            shape = RoundedCornerShape(12.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = if (isExamExpanded) Color(0xFFF8FAFC) else Color.White
                            ),
                            border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFFE2E8F0))
                        ) {
                            Column(modifier = Modifier.padding(12.dp)) {
                                // Level 1: Exam Header
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clickable { isExamExpanded = !isExamExpanded },
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Column(modifier = Modifier.weight(1f)) {
                                        Row(verticalAlignment = Alignment.CenterVertically) {
                                            Box(
                                                modifier = Modifier
                                                    .clip(RoundedCornerShape(4.dp))
                                                    .background(Navy100)
                                                    .padding(horizontal = 6.dp, vertical = 2.dp)
                                            ) {
                                                Text(
                                                    text = "Level 1: Exam",
                                                    fontSize = 9.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    color = Navy900
                                                )
                                            }
                                            Spacer(modifier = Modifier.width(6.dp))
                                            Text(
                                                text = examHierarchy.exam.categoryGroup,
                                                fontSize = 10.sp,
                                                color = SaffronGold,
                                                fontWeight = FontWeight.Bold
                                            )
                                        }

                                        Text(
                                            text = examHierarchy.exam.name,
                                            fontSize = 13.5.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Navy900,
                                            modifier = Modifier.padding(top = 2.dp)
                                        )
                                        Text(
                                            text = if (isHi) "${examHierarchy.exam.hindiName} • ${examHierarchy.subjectsWithSubTopics.size} विषय" else "${examHierarchy.subjectsWithSubTopics.size} Subjects",
                                            fontSize = 10.5.sp,
                                            color = Color(0xFF64748B)
                                        )
                                    }

                                    Icon(
                                        imageVector = if (isExamExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                                        contentDescription = null,
                                        tint = SaffronGold
                                    )
                                }

                                // Level 2: Subjects
                                if (isExamExpanded) {
                                    Spacer(modifier = Modifier.height(10.dp))

                                    examHierarchy.subjectsWithSubTopics.forEach { subjectWithSubTopics ->
                                        val subject = subjectWithSubTopics.subject
                                        val subTopics = subjectWithSubTopics.subTopics
                                        var isSubjectExpanded by remember { mutableStateOf(true) }

                                        Card(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(start = 10.dp, top = 6.dp, bottom = 4.dp),
                                            shape = RoundedCornerShape(10.dp),
                                            colors = CardDefaults.cardColors(containerColor = Color.White),
                                            border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFFE2E8F0))
                                        ) {
                                            Column(modifier = Modifier.padding(10.dp)) {
                                                Row(
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .clickable { isSubjectExpanded = !isSubjectExpanded },
                                                    verticalAlignment = Alignment.CenterVertically,
                                                    horizontalArrangement = Arrangement.SpaceBetween
                                                ) {
                                                    Column(modifier = Modifier.weight(1f)) {
                                                        Row(verticalAlignment = Alignment.CenterVertically) {
                                                            Box(
                                                                modifier = Modifier
                                                                    .clip(RoundedCornerShape(4.dp))
                                                                    .background(AmberLight)
                                                                    .padding(horizontal = 5.dp, vertical = 2.dp)
                                                            ) {
                                                                Text(
                                                                    text = "Level 2: Subject (${subject.stageOrTier})",
                                                                    fontSize = 9.sp,
                                                                    fontWeight = FontWeight.Bold,
                                                                    color = Color(0xFF92400E)
                                                                )
                                                            }
                                                        }
                                                        Text(
                                                            text = if (isHi) subject.hindiName else subject.name,
                                                            fontSize = 12.5.sp,
                                                            fontWeight = FontWeight.Bold,
                                                            color = Navy900,
                                                            modifier = Modifier.padding(top = 2.dp)
                                                        )
                                                        Text(
                                                            text = if (isHi) "${subject.name} • ${subTopics.size} सब-टॉपिक्स" else "${subTopics.size} Sub-topics",
                                                            fontSize = 10.sp,
                                                            color = Color(0xFF64748B)
                                                        )
                                                    }

                                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                                        IconButton(
                                                            onClick = { onAddSubTopicClick(subject.id) },
                                                            modifier = Modifier.size(28.dp)
                                                        ) {
                                                            Icon(
                                                                imageVector = Icons.Default.Add,
                                                                contentDescription = "Add subtopic",
                                                                tint = EmeraldSuccess,
                                                                modifier = Modifier.size(18.dp)
                                                            )
                                                        }

                                                        Icon(
                                                            imageVector = if (isSubjectExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                                                            contentDescription = null,
                                                            tint = Color(0xFF94A3B8),
                                                            modifier = Modifier.size(18.dp)
                                                        )
                                                    }
                                                }

                                                // Level 3: Sub-topics
                                                if (isSubjectExpanded) {
                                                    Spacer(modifier = Modifier.height(8.dp))

                                                    if (subTopics.isEmpty()) {
                                                        Text(
                                                            text = if (isHi) "कोई सब-टॉपिक नहीं है। (+) पर क्लिक करके जोड़ें।" else "No sub-topics yet. Tap (+) to add.",
                                                            fontSize = 10.5.sp,
                                                            color = Color(0xFF94A3B8),
                                                            modifier = Modifier.padding(start = 12.dp)
                                                        )
                                                    } else {
                                                        subTopics.forEachIndexed { subIndex, subTopic ->
                                                            Row(
                                                                modifier = Modifier
                                                                    .fillMaxWidth()
                                                                    .padding(start = 12.dp, top = 3.dp, bottom = 3.dp)
                                                                    .clip(RoundedCornerShape(6.dp))
                                                                    .background(Color(0xFFF1F5F9))
                                                                    .padding(horizontal = 8.dp, vertical = 6.dp),
                                                                verticalAlignment = Alignment.CenterVertically,
                                                                horizontalArrangement = Arrangement.SpaceBetween
                                                            ) {
                                                                Column(modifier = Modifier.weight(1f)) {
                                                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                                                        Text(
                                                                            text = "${subIndex + 1}. ${if (isHi) subTopic.hindiName else subTopic.name}",
                                                                            fontSize = 11.5.sp,
                                                                            fontWeight = FontWeight.SemiBold,
                                                                            color = Navy900
                                                                        )
                                                                    }
                                                                    Text(
                                                                        text = if (isHi) "${subTopic.name} • PYQ: ${subTopic.pyqCount} • ${subTopic.estimatedHours} घंटे" else "PYQ: ${subTopic.pyqCount} • ${subTopic.estimatedHours} hrs",
                                                                        fontSize = 9.5.sp,
                                                                        color = Color(0xFF64748B)
                                                                    )
                                                                }

                                                                Row(verticalAlignment = Alignment.CenterVertically) {
                                                                    Box(
                                                                        modifier = Modifier
                                                                            .clip(RoundedCornerShape(4.dp))
                                                                            .background(
                                                                                if (subTopic.importanceLevel == "High Yield") Color(0xFFDCFCE7) else Color(0xFFFEF3C7)
                                                                            )
                                                                            .padding(horizontal = 5.dp, vertical = 2.dp)
                                                                    ) {
                                                                        Text(
                                                                            text = subTopic.importanceLevel,
                                                                            fontSize = 8.5.sp,
                                                                            fontWeight = FontWeight.Bold,
                                                                            color = if (subTopic.importanceLevel == "High Yield") EmeraldSuccess else Color(0xFFB45309)
                                                                        )
                                                                    }

                                                                    IconButton(
                                                                        onClick = { onDeleteSubTopic(subTopic.id) },
                                                                        modifier = Modifier.size(24.dp)
                                                                    ) {
                                                                        Icon(
                                                                            imageVector = Icons.Default.Delete,
                                                                            contentDescription = "Delete",
                                                                            tint = Color(0xFFEF4444),
                                                                            modifier = Modifier.size(14.dp)
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
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun AddSubTopicDialog(
    subjectId: String,
    isHi: Boolean = false,
    onDismiss: () -> Unit,
    onConfirm: (name: String, hindiName: String, importance: String, hours: Double) -> Unit
) {
    var name by remember { mutableStateOf("") }
    var hindiName by remember { mutableStateOf("") }
    var importance by remember { mutableStateOf("High Yield") }
    var hours by remember { mutableStateOf("3.0") }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                text = if (isHi) "नया सब-टॉपिक जोड़ें (Room DB)" else "Add New Sub-topic (Room DB)",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
        },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(
                    text = if (isHi) "विषय आईडी: $subjectId" else "Subject ID: $subjectId",
                    fontSize = 11.sp,
                    color = Color(0xFF64748B)
                )

                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Sub-topic Title (English)") },
                    placeholder = { Text("e.g. Preamble & Fundamental Rights") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = hindiName,
                    onValueChange = { hindiName = it },
                    label = { Text(if (isHi) "सब-टॉपिक का नाम (हिंदी)" else "Sub-topic Name (Hindi - Optional)") },
                    placeholder = { Text("जैसे: प्रस्तावना एवं मूल अधिकार") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = hours,
                    onValueChange = { hours = it },
                    label = { Text(if (isHi) "अपेक्षित अध्ययन समय (घंटे)" else "Estimated Study Hours") },
                    placeholder = { Text("3.0") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    if (name.isNotBlank()) {
                        val parsedHours = hours.toDoubleOrNull() ?: 3.0
                        onConfirm(name, hindiName.ifBlank { name }, importance, parsedHours)
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Navy900)
            ) {
                Text(if (isHi) "डेटाबेस में सुरक्षित करें" else "Save to Database")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(if (isHi) "रद्द करें" else "Cancel")
            }
        }
    )
}

@Composable
fun CompleteExamTreeView(
    categories: List<ExamCategory>,
    isHi: Boolean = false,
    onSelectSubject: (ExamCategory, ExamSubSection, ExamSubject) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = if (isHi) "भारत की सभी प्रतियोगी परीक्षाओं का संपूर्ण पाठ्यक्रम ट्री" else "Complete Syllabus Tree for All Competitive Exams",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = Navy900
                )
                Text(
                    text = if (isHi) "किसी भी विषय पर टैप करके उसकी ई-बुक्स व टेस्ट सीरीज़ तुरंत खोलें:" else "Tap on any subject to open its E-Books & Test Series:",
                    fontSize = 11.5.sp,
                    color = Color(0xFF64748B),
                    modifier = Modifier.padding(bottom = 12.dp)
                )

                categories.forEach { category ->
                    var isExpanded by remember { mutableStateOf(category.id == "upsc") }

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        shape = RoundedCornerShape(10.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = if (isExpanded) Color(0xFFF8FAFC) else Color.White
                        ),
                        border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFFE2E8F0))
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable { isExpanded = !isExpanded },
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(28.dp)
                                            .clip(RoundedCornerShape(6.dp))
                                            .background(Navy100),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Icon(
                                            imageVector = getCategoryIcon(category.iconKey),
                                            contentDescription = null,
                                            tint = Navy900,
                                            modifier = Modifier.size(16.dp)
                                        )
                                    }
                                    Spacer(modifier = Modifier.width(10.dp))
                                    Column {
                                        Text(
                                            text = category.name,
                                            fontSize = 13.5.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Navy900
                                        )
                                        if (isHi) {
                                            Text(
                                                text = category.hindiName,
                                                fontSize = 10.5.sp,
                                                color = Color(0xFF64748B)
                                            )
                                        }
                                    }
                                }

                                Icon(
                                    imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                                    contentDescription = null,
                                    tint = SaffronGold
                                )
                            }

                            if (isExpanded) {
                                Spacer(modifier = Modifier.height(10.dp))

                                category.subSections.forEach { subSection ->
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(start = 14.dp, top = 6.dp, bottom = 4.dp)
                                    ) {
                                        Text(
                                            text = if (isHi) "• ${subSection.hindiName} (${subSection.name})" else "• ${subSection.name}",
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color(0xFF0369A1)
                                        )

                                        Spacer(modifier = Modifier.height(4.dp))

                                        subSection.subjects.forEach { subj ->
                                            Row(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .clickable { onSelectSubject(category, subSection, subj) }
                                                    .padding(start = 12.dp, top = 3.dp, bottom = 3.dp),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Icon(
                                                    imageVector = Icons.Default.ChevronRight,
                                                    contentDescription = null,
                                                    tint = SaffronGold,
                                                    modifier = Modifier.size(14.dp)
                                                )
                                                Spacer(modifier = Modifier.width(4.dp))
                                                Text(
                                                    text = if (isHi) subj.hindiName else subj.name,
                                                    fontSize = 11.5.sp,
                                                    color = Color(0xFF334155),
                                                    fontWeight = FontWeight.Medium
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
    }
}
