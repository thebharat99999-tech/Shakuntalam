package com.example.ui.screens

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AdminPanelSettings
import androidx.compose.material.icons.filled.AttachFile
import androidx.compose.material.icons.filled.AutoStories
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.CloudUpload
import androidx.compose.material.icons.filled.CurrencyRupee
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.PictureAsPdf
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Publish
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.Sell
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.ExamCatalogData
import com.example.data.local.entity.EbookDocumentEntity
import com.example.model.AppLanguage
import com.example.model.MockTest
import com.example.model.StudyItem
import com.example.model.TestQuestion
import com.example.ui.components.AddQuestionModal
import com.example.ui.components.CreateTestModal
import com.example.ui.components.EditPriceModal
import com.example.ui.theme.AmberGold
import com.example.ui.theme.AmberLight
import com.example.ui.theme.EmeraldLight
import com.example.ui.theme.EmeraldSuccess
import com.example.ui.theme.Navy100
import com.example.ui.theme.Navy800
import com.example.ui.theme.Navy900
import com.example.ui.theme.SaffronGold
import com.example.viewmodel.AppScreen
import com.example.viewmodel.ShakuntalamUiState
import com.example.viewmodel.ShakuntalamViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OwnerAdminPortalScreen(
    uiState: ShakuntalamUiState,
    viewModel: ShakuntalamViewModel,
    modifier: Modifier = Modifier
) {
    val isHi = uiState.selectedLanguage == AppLanguage.HINDI
    val documents = uiState.uploadedDocuments
    val customTests = uiState.customTests

    var selectedPortalTab by remember { mutableStateOf(0) } // 0: PDF E-Books & Prices, 1: Online Tests & Questions
    var showUploadDialog by remember { mutableStateOf(false) }
    var documentToDelete by remember { mutableStateOf<EbookDocumentEntity?>(null) }

    // Price editing state
    var docForPriceEdit by remember { mutableStateOf<EbookDocumentEntity?>(null) }
    var itemForPriceEdit by remember { mutableStateOf<StudyItem?>(null) }

    // Online Test creation & editing state
    var showCreateTestModal by remember { mutableStateOf(false) }
    var testForAddingQuestion by remember { mutableStateOf<MockTest?>(null) }
    var testForEditingMetadata by remember { mutableStateOf<MockTest?>(null) }
    var questionBeingEdited by remember { mutableStateOf<Pair<String, TestQuestion>?>(null) }
    var bookForFullEdit by remember { mutableStateOf<StudyItem?>(null) }

    // STRICT OWNER-ONLY LOCK GUARD:
    // If any student navigates here without verifying as Owner (thebharat99999@gmail.com / 6396817525 + PIN 2525),
    // show the strict Owner Lock Screen and prevent access to admin controls.
    if (!com.example.ui.components.HeaderLogoSuperMenuState.isOwnerUnlocked) {
        Scaffold(
            modifier = modifier.fillMaxSize(),
            topBar = {
                Surface(modifier = Modifier.fillMaxWidth(), color = Navy900) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .statusBarsPadding()
                            .padding(horizontal = 14.dp, vertical = 10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = { viewModel.navigateBack() }) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color.White)
                        }
                        Text(
                            text = if (isHi) "🔒 ओनर सेक्शन (स्टूडेंट्स के लिए लॉक)" else "🔒 OWNER SECTION (LOCKED FOR STUDENTS)",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = SaffronGold
                        )
                    }
                }
            }
        ) { lockPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFF8FAFC))
                    .padding(lockPadding)
                    .padding(16.dp)
            ) {
                com.example.ui.components.StrictOwnerLockAndFullEditorSection(
                    uiState = uiState,
                    viewModel = viewModel,
                    isHi = isHi,
                    onOpenFullOwnerPortalScreen = {},
                    onOpenVideoUploadModal = {}
                )
            }
        }
        return
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
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 14.dp, vertical = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            IconButton(onClick = { viewModel.navigateBack() }) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = "Back",
                                    tint = Color.White
                                )
                            }
                            Column {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(
                                        imageVector = Icons.Default.AdminPanelSettings,
                                        contentDescription = null,
                                        tint = SaffronGold,
                                        modifier = Modifier.size(16.dp)
                                    )
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text(
                                        text = if (isHi) "शकुंतलम प्रकाशक नियंत्रण" else "SHAKUNTALAM OWNER CONTROL",
                                        fontSize = 11.5.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = SaffronGold,
                                        letterSpacing = 0.5.sp
                                    )
                                }
                                Text(
                                    text = if (isHi) "PDF प्रबंधन, लाइव कीमत एवं ऑनलाइन टेस्ट" else "PDFs, Live Cost & Online Test Creator",
                                    fontSize = 13.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            }
                        }

                        // Action button depending on selected tab
                        if (selectedPortalTab == 0) {
                            Button(
                                onClick = { showUploadDialog = true },
                                colors = ButtonDefaults.buttonColors(containerColor = SaffronGold),
                                shape = RoundedCornerShape(8.dp),
                                modifier = Modifier.height(36.dp).testTag("owner_upload_button")
                            ) {
                                Icon(Icons.Default.CloudUpload, contentDescription = null, tint = Navy900, modifier = Modifier.size(16.dp))
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = if (isHi) "+ नया PDF" else "+ Upload PDF",
                                    fontSize = 11.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Navy900
                                )
                            }
                        } else {
                            Button(
                                onClick = { showCreateTestModal = true },
                                colors = ButtonDefaults.buttonColors(containerColor = SaffronGold),
                                shape = RoundedCornerShape(8.dp),
                                modifier = Modifier.height(36.dp).testTag("owner_create_test_button")
                            ) {
                                Icon(Icons.Default.Add, contentDescription = null, tint = Navy900, modifier = Modifier.size(16.dp))
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = if (isHi) "+ नया टेस्ट" else "+ Create Test",
                                    fontSize = 11.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Navy900
                                )
                            }
                        }
                    }

                    // Portal Navigation Tabs
                    TabRow(
                        selectedTabIndex = selectedPortalTab,
                        containerColor = Navy800,
                        indicator = { tabPositions ->
                            TabRowDefaults.SecondaryIndicator(
                                Modifier.tabIndicatorOffset(tabPositions[selectedPortalTab]),
                                color = SaffronGold,
                                height = 3.dp
                            )
                        }
                    ) {
                        Tab(
                            selected = selectedPortalTab == 0,
                            onClick = { selectedPortalTab = 0 },
                            modifier = Modifier.testTag("tab_owner_pdfs"),
                            text = {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(
                                        imageVector = Icons.Default.PictureAsPdf,
                                        contentDescription = null,
                                        tint = if (selectedPortalTab == 0) SaffronGold else Color(0xFF94A3B8),
                                        modifier = Modifier.size(15.dp)
                                    )
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text(
                                        text = if (isHi) "PDF ई-बुक्स एवं कीमतें" else "PDF E-Books & Pricing",
                                        fontSize = 12.sp,
                                        fontWeight = if (selectedPortalTab == 0) FontWeight.Bold else FontWeight.Medium,
                                        color = if (selectedPortalTab == 0) Color.White else Color(0xFF94A3B8)
                                    )
                                }
                            }
                        )

                        Tab(
                            selected = selectedPortalTab == 1,
                            onClick = { selectedPortalTab = 1 },
                            modifier = Modifier.testTag("tab_owner_tests"),
                            text = {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(
                                        imageVector = Icons.Default.Quiz,
                                        contentDescription = null,
                                        tint = if (selectedPortalTab == 1) SaffronGold else Color(0xFF94A3B8),
                                        modifier = Modifier.size(15.dp)
                                    )
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text(
                                        text = if (isHi) "ऑनलाइन टेस्ट व प्रश्न" else "Online Tests & Qs",
                                        fontSize = 11.5.sp,
                                        fontWeight = if (selectedPortalTab == 1) FontWeight.Bold else FontWeight.Medium,
                                        color = if (selectedPortalTab == 1) Color.White else Color(0xFF94A3B8)
                                    )
                                }
                            }
                        )

                        Tab(
                            selected = selectedPortalTab == 2,
                            onClick = { selectedPortalTab = 2 },
                            modifier = Modifier.testTag("tab_owner_live_api_sync"),
                            text = {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(
                                        imageVector = Icons.Default.Publish,
                                        contentDescription = null,
                                        tint = if (selectedPortalTab == 2) SaffronGold else Color(0xFF94A3B8),
                                        modifier = Modifier.size(15.dp)
                                    )
                                    Spacer(modifier = Modifier.width(5.dp))
                                    Text(
                                        text = if (isHi) "Live API व AI सिंक" else "Live API & Sync",
                                        fontSize = 11.5.sp,
                                        fontWeight = if (selectedPortalTab == 2) FontWeight.Bold else FontWeight.Medium,
                                        color = if (selectedPortalTab == 2) Color.White else Color(0xFF94A3B8)
                                    )
                                }
                            }
                        )
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
                .padding(horizontal = 16.dp, vertical = 12.dp),
            contentPadding = PaddingValues(bottom = 32.dp)
        ) {
            // Always-accessible 2030 Live Cloud Sync API Key & AI Studio Remote Publisher Panel
            if (selectedPortalTab == 2) {
                item {
                    com.example.ui.components.LiveCloudApiAndAiStudioSyncPanel(
                        uiState = uiState,
                        isHi = isHi,
                        onPushLiveOtaTestSeries = { otaTest ->
                            viewModel.startTest(otaTest)
                        }
                    )
                }
            }

            // TAB 0: PDF Documents & Pricing Management
            if (selectedPortalTab == 0) {
                // Live Cloud Sync API Key Quick Banner at top of Owner Portal Tab 0
                item {
                    com.example.ui.components.LiveCloudApiAndAiStudioSyncPanel(
                        uiState = uiState,
                        isHi = isHi,
                        onPushLiveOtaTestSeries = { otaTest ->
                            viewModel.startTest(otaTest)
                        }
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                }

                // Overview metrics card
                item {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(14.dp),
                        colors = CardDefaults.cardColors(containerColor = Navy800)
                    ) {
                        Column(modifier = Modifier.padding(14.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = if (isHi) "प्रकाशक डैशबोर्ड (Publisher Overview)" else "Publisher Pricing & Document Metrics",
                                    fontSize = 12.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = SaffronGold
                                )
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(4.dp))
                                        .background(EmeraldLight)
                                        .padding(horizontal = 6.dp, vertical = 2.dp)
                                ) {
                                    Text("✓ Live Access", fontSize = 9.sp, fontWeight = FontWeight.Bold, color = EmeraldSuccess)
                                }
                            }

                            Spacer(modifier = Modifier.height(10.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceAround
                            ) {
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Text("${documents.size}", fontSize = 20.sp, fontWeight = FontWeight.ExtraBold, color = Color.White)
                                    Text(if (isHi) "सक्रिय PDF दस्तावेज़" else "Active PDF Docs", fontSize = 10.5.sp, color = Color(0xFFCBD5E1))
                                }
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Text("${uiState.customStudyItems.size}", fontSize = 20.sp, fontWeight = FontWeight.ExtraBold, color = SaffronGold)
                                    Text(if (isHi) "कैटलॉग पुस्तकें" else "Catalog E-Books", fontSize = 10.5.sp, color = Color(0xFFCBD5E1))
                                }
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Text("₹0-999", fontSize = 20.sp, fontWeight = FontWeight.ExtraBold, color = Color(0xFF38BDF8))
                                    Text(if (isHi) "कस्टम मूल्य रेंज" else "Editable Prices", fontSize = 10.5.sp, color = Color(0xFFCBD5E1))
                                }
                            }
                        }
                    }
                }

                // Owner UPI, Mobile Number & Bank Details Direct Link Card
                item {
                    Spacer(modifier = Modifier.height(12.dp))
                    var upiInput by remember(uiState.ownerUpiId) { mutableStateOf(uiState.ownerUpiId) }
                    var mobileInput by remember(uiState.ownerUpiMobile) { mutableStateOf(uiState.ownerUpiMobile) }
                    var merchantInput by remember(uiState.ownerMerchantName) { mutableStateOf(uiState.ownerMerchantName) }
                    var bankNameInput by remember(uiState.ownerBankName) { mutableStateOf(uiState.ownerBankName) }
                    var accountNoInput by remember(uiState.ownerAccountNumber) { mutableStateOf(uiState.ownerAccountNumber) }
                    var ifscInput by remember(uiState.ownerIfscCode) { mutableStateOf(uiState.ownerIfscCode) }
                    var showBankFields by remember { mutableStateOf(true) }

                    Card(
                        modifier = Modifier.fillMaxWidth().testTag("owner_upi_config_card"),
                        shape = RoundedCornerShape(14.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                        border = androidx.compose.foundation.BorderStroke(1.dp, SaffronGold.copy(alpha = 0.5f))
                    ) {
                        Column(modifier = Modifier.padding(14.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(1f)) {
                                    Icon(
                                        imageVector = Icons.Default.CurrencyRupee,
                                        contentDescription = null,
                                        tint = SaffronGold,
                                        modifier = Modifier.size(20.dp)
                                    )
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Column {
                                        Text(
                                            text = if (isHi) "आपकी UPI ID, मोबाइल नंबर एवं बैंक खाता विवरण" else "Linked UPI ID, Mobile Number & Bank Details",
                                            fontSize = 13.5.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Navy900
                                        )
                                        Text(
                                            text = if (isHi) "वर्तमान सक्रिय UPI: ${uiState.ownerUpiId} • मोबाइल: ${uiState.ownerUpiMobile}" else "Active UPI: ${uiState.ownerUpiId} • Mobile: ${uiState.ownerUpiMobile}",
                                            fontSize = 11.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = EmeraldSuccess
                                        )
                                    }
                                }
                            }

                            Spacer(modifier = Modifier.height(10.dp))

                            // Row 1: UPI ID & UPI Linked Mobile Number
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                OutlinedTextField(
                                    value = upiInput,
                                    onValueChange = { upiInput = it },
                                    label = { Text(if (isHi) "आपकी UPI ID" else "Your UPI ID", fontSize = 11.sp) },
                                    placeholder = { Text("6396817525@jio", fontSize = 11.sp) },
                                    singleLine = true,
                                    modifier = Modifier.weight(1.1f).testTag("owner_upi_input"),
                                    shape = RoundedCornerShape(8.dp)
                                )

                                OutlinedTextField(
                                    value = mobileInput,
                                    onValueChange = { mobileInput = it.filter { ch -> ch.isDigit() }.take(10) },
                                    label = { Text(if (isHi) "UPI मोबाइल नंबर" else "UPI Mobile No.", fontSize = 11.sp) },
                                    placeholder = { Text("6396817525", fontSize = 11.sp) },
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                                    singleLine = true,
                                    modifier = Modifier.weight(1f).testTag("owner_upi_mobile_input"),
                                    shape = RoundedCornerShape(8.dp)
                                )
                            }

                            Spacer(modifier = Modifier.height(8.dp))

                            // Row 2: Merchant Name & Bank Name
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                OutlinedTextField(
                                    value = merchantInput,
                                    onValueChange = { merchantInput = it },
                                    label = { Text(if (isHi) "प्राप्तकर्ता / व्यवसाय नाम" else "Receiver / Business Name", fontSize = 11.sp) },
                                    singleLine = true,
                                    modifier = Modifier.weight(1f).testTag("owner_merchant_input"),
                                    shape = RoundedCornerShape(8.dp)
                                )

                                OutlinedTextField(
                                    value = bankNameInput,
                                    onValueChange = { bankNameInput = it },
                                    label = { Text(if (isHi) "बैंक का नाम (Bank Name)" else "Bank Name", fontSize = 11.sp) },
                                    placeholder = { Text("Jio Payments Bank / SBI", fontSize = 11.sp) },
                                    singleLine = true,
                                    modifier = Modifier.weight(1f).testTag("owner_bank_name_input"),
                                    shape = RoundedCornerShape(8.dp)
                                )
                            }

                            Spacer(modifier = Modifier.height(8.dp))

                            // Toggle / Section for Bank Account Number & IFSC Code
                            AnimatedVisibility(visible = showBankFields) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    OutlinedTextField(
                                        value = accountNoInput,
                                        onValueChange = { accountNoInput = it.filter { ch -> ch.isDigit() } },
                                        label = { Text(if (isHi) "बैंक खाता संख्या (Account No.)" else "Bank Account No. (Optional)", fontSize = 10.5.sp) },
                                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                        singleLine = true,
                                        modifier = Modifier.weight(1.1f).testTag("owner_account_no_input"),
                                        shape = RoundedCornerShape(8.dp)
                                    )

                                    OutlinedTextField(
                                        value = ifscInput,
                                        onValueChange = { ifscInput = it.uppercase() },
                                        label = { Text(if (isHi) "IFSC कोड (IFSC Code)" else "IFSC Code (Optional)", fontSize = 10.5.sp) },
                                        placeholder = { Text("JIOP0000001", fontSize = 11.sp) },
                                        singleLine = true,
                                        modifier = Modifier.weight(0.9f).testTag("owner_ifsc_input"),
                                        shape = RoundedCornerShape(8.dp)
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(10.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Button(
                                    onClick = {
                                        viewModel.updateOwnerUpiDetails(
                                            newUpiId = upiInput,
                                            newMerchantName = merchantInput,
                                            newUpiMobile = mobileInput,
                                            newBankName = bankNameInput,
                                            newAccountNumber = accountNoInput,
                                            newIfscCode = ifscInput
                                        )
                                    },
                                    colors = ButtonDefaults.buttonColors(containerColor = EmeraldSuccess),
                                    shape = RoundedCornerShape(8.dp),
                                    modifier = Modifier.weight(1f).height(40.dp).testTag("owner_save_upi_btn")
                                ) {
                                    Icon(Icons.Default.CheckCircle, contentDescription = null, tint = Color.White, modifier = Modifier.size(15.dp))
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text(
                                        text = if (isHi) "UPI व बैंक विवरण सेव करें" else "Save UPI & Bank Details",
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White
                                    )
                                }

                                OutlinedButton(
                                    onClick = {
                                        viewModel.updateOwnerUpiDetails(
                                            newUpiId = upiInput,
                                            newMerchantName = merchantInput,
                                            newUpiMobile = mobileInput,
                                            newBankName = bankNameInput,
                                            newAccountNumber = accountNoInput,
                                            newIfscCode = ifscInput
                                        )
                                        viewModel.openPaymentGateway(149, "Test Payment to $upiInput")
                                    },
                                    shape = RoundedCornerShape(8.dp),
                                    modifier = Modifier.height(40.dp).testTag("owner_test_gateway_btn")
                                ) {
                                    Text(
                                        text = if (isHi) "गेटवे टेस्ट करें" else "Test Gateway",
                                        fontSize = 11.5.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Navy900
                                    )
                                }
                            }
                        }
                    }
                }

                // Cyber Security, Anti-Hacker & Multi-Platform Compatibility Shield Card
                item {
                    Spacer(modifier = Modifier.height(12.dp))
                    var newPinInput by remember { mutableStateOf("") }
                    var unlockPinInput by remember { mutableStateOf("") }

                    Card(
                        modifier = Modifier.fillMaxWidth().testTag("owner_security_shield_card"),
                        shape = RoundedCornerShape(14.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFF0FDF4)),
                        border = androidx.compose.foundation.BorderStroke(1.5.dp, EmeraldSuccess)
                    ) {
                        Column(modifier = Modifier.padding(14.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Box(
                                        modifier = Modifier
                                            .size(34.dp)
                                            .clip(CircleShape)
                                            .background(EmeraldSuccess),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.AdminPanelSettings,
                                            contentDescription = null,
                                            tint = Color.White,
                                            modifier = Modifier.size(18.dp)
                                        )
                                    }
                                    Spacer(modifier = Modifier.width(10.dp))
                                    Column {
                                        Text(
                                            text = if (isHi) "साइबर सुरक्षा एवं एंटी-हैकर शील्ड (SHA-256)" else "Cyber Security & Anti-Hacker Shield (SHA-256)",
                                            fontSize = 13.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            color = Navy900
                                        )
                                        Text(
                                            text = if (isHi) "DRM स्क्रीन सुरक्षा • SQLi/XSS फ़ायरवॉल • क्रॉस-प्लेटफ़ॉर्म रेडी" else "DRM Screen Shield • SQLi/XSS Firewall • Cross-Platform Ready",
                                            fontSize = 10.5.sp,
                                            color = Color(0xFF166534),
                                            fontWeight = FontWeight.SemiBold
                                        )
                                    }
                                }

                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(6.dp))
                                        .background(Navy900)
                                        .padding(horizontal = 8.dp, vertical = 4.dp)
                                ) {
                                    Text(
                                        text = if (uiState.isAntiPiracyEnabled) "PROTECTED" else "STANDARD",
                                        fontSize = 9.5.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = SaffronGold
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(10.dp))

                            // Security Toggles Row
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                OutlinedButton(
                                    onClick = { viewModel.toggleAntiPiracy() },
                                    shape = RoundedCornerShape(8.dp),
                                    modifier = Modifier.weight(1f).testTag("toggle_anti_piracy_btn")
                                ) {
                                    Text(
                                        text = if (uiState.isAntiPiracyEnabled) {
                                            if (isHi) "✓ DRM स्क्रीन लॉक: चालू" else "✓ DRM Screen Shield: ON"
                                        } else {
                                            if (isHi) "DRM स्क्रीन लॉक: बंद" else "DRM Screen Shield: OFF"
                                        },
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = if (uiState.isAntiPiracyEnabled) EmeraldSuccess else Color(0xFF64748B)
                                    )
                                }

                                OutlinedButton(
                                    onClick = { viewModel.toggleAdminPinLock() },
                                    shape = RoundedCornerShape(8.dp),
                                    modifier = Modifier.weight(1f).testTag("toggle_admin_pin_btn")
                                ) {
                                    Text(
                                        text = if (uiState.isAdminPinLockEnabled) {
                                            if (isHi) "✓ एडमिन पिन लॉक: चालू" else "✓ Admin PIN Gate: ON"
                                        } else {
                                            if (isHi) "एडमिन पिन लॉक: बंद" else "Admin PIN Gate: OFF"
                                        },
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = if (uiState.isAdminPinLockEnabled) Navy900 else Color(0xFF64748B)
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(8.dp))

                            // Custom Owner PIN updater
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                OutlinedTextField(
                                    value = newPinInput,
                                    onValueChange = { newPinInput = it.filter { ch -> ch.isDigit() }.take(6) },
                                    label = { Text(if (isHi) "नया 4-6 अंकों का सुरक्षा पिन सेट करें" else "Set New 4-6 Digit Owner Security PIN", fontSize = 11.sp) },
                                    placeholder = { Text("Default: 2525", fontSize = 11.sp) },
                                    singleLine = true,
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                                    modifier = Modifier.weight(1f),
                                    colors = OutlinedTextFieldDefaults.colors(
                                        focusedBorderColor = EmeraldSuccess,
                                        focusedContainerColor = Color.White,
                                        unfocusedContainerColor = Color.White
                                    )
                                )
                                Button(
                                    onClick = {
                                        viewModel.updateAdminPin(newPinInput)
                                        newPinInput = ""
                                    },
                                    colors = ButtonDefaults.buttonColors(containerColor = Navy900),
                                    shape = RoundedCornerShape(8.dp),
                                    modifier = Modifier.height(44.dp)
                                ) {
                                    Text(
                                        text = if (isHi) "पिन अपडेट करें" else "Save PIN",
                                        fontSize = 11.5.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(8.dp))

                            // Live Security Telemetry Log
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(Color.White)
                                    .padding(10.dp),
                                verticalArrangement = Arrangement.spacedBy(3.dp)
                            ) {
                                Text(
                                    text = if (isHi) "लाइव सुरक्षा ऑडिट लॉग:" else "Live Security & Compatibility Telemetry:",
                                    fontSize = 10.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Navy900
                                )
                                uiState.securityAuditLogs.take(4).forEach { logEntry ->
                                    Text(
                                        text = "• $logEntry",
                                        fontSize = 10.sp,
                                        color = Color(0xFF166534),
                                        fontWeight = FontWeight.Medium
                                    )
                                }
                            }
                        }
                    }

                    // If Admin PIN Gate is enabled and session is locked, show PIN Verification Modal
                    if (uiState.isAdminPinLockEnabled && !uiState.isAdminSessionUnlocked) {
                        AlertDialog(
                            onDismissRequest = { viewModel.navigateBack() },
                            title = {
                                Text(
                                    text = if (isHi) "ओनर सुरक्षा पिन सत्यापन" else "Owner Security PIN Verification",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Navy900
                                )
                            },
                            text = {
                                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                    Text(
                                        text = if (isHi) "प्रकाशक नियंत्रण पैनल को अनलॉक करने के लिए अपना सुरक्षा पिन दर्ज करें (डिफ़ॉल्ट: 2525):" else "Enter your Owner Security PIN to unlock Admin Controls (Default PIN: 2525):",
                                        fontSize = 12.sp,
                                        color = Color(0xFF475569)
                                    )
                                    OutlinedTextField(
                                        value = unlockPinInput,
                                        onValueChange = { unlockPinInput = it.filter { ch -> ch.isDigit() }.take(6) },
                                        label = { Text("Security PIN") },
                                        singleLine = true,
                                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                                        modifier = Modifier.fillMaxWidth()
                                    )
                                }
                            },
                            confirmButton = {
                                Button(
                                    onClick = { viewModel.verifyAdminPin(unlockPinInput) },
                                    colors = ButtonDefaults.buttonColors(containerColor = EmeraldSuccess)
                                ) {
                                    Text(if (isHi) "अनलॉक करें" else "Unlock Portal", color = Color.White, fontWeight = FontWeight.Bold)
                                }
                            },
                            dismissButton = {
                                TextButton(onClick = { viewModel.navigateBack() }) {
                                    Text(if (isHi) "वापस जाएं" else "Exit")
                                }
                            }
                        )
                    }
                }

                // Header for uploaded PDFs
                item {
                    Spacer(modifier = Modifier.height(14.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = if (isHi) "1. अपलोड किए गए PDF दस्तावेज़ (${documents.size}):" else "1. Uploaded PDF Study Materials (${documents.size}):",
                            fontSize = 13.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = Navy900
                        )
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                }

                if (documents.isEmpty()) {
                    item {
                        Card(
                            modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Column(
                                modifier = Modifier.fillMaxWidth().padding(24.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Icon(Icons.Default.PictureAsPdf, contentDescription = null, tint = Color(0xFF94A3B8), modifier = Modifier.size(40.dp))
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = if (isHi) "कोई PDF दस्तावेज़ अभी अपलोड नहीं है" else "No PDF Documents Uploaded Yet",
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Navy900
                                )
                                Text(
                                    text = if (isHi) "ऊपर '+ नया PDF' बटन दबाकर आसानी से कोई भी PDF फाइल जोड़ें।" else "Tap '+ Upload PDF' above to upload study notes or e-books.",
                                    fontSize = 11.sp,
                                    color = Color(0xFF64748B)
                                )
                            }
                        }
                    }
                } else {
                    items(documents) { doc ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp)
                                .testTag("doc_item_${doc.id}"),
                            shape = RoundedCornerShape(12.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
                        ) {
                            Column(modifier = Modifier.padding(12.dp)) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(40.dp)
                                            .clip(RoundedCornerShape(8.dp))
                                            .background(Color(0xFFFFE4E6)),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Icon(Icons.Default.PictureAsPdf, contentDescription = null, tint = Color(0xFFE11D48), modifier = Modifier.size(22.dp))
                                    }

                                    Spacer(modifier = Modifier.width(10.dp))

                                    Column(modifier = Modifier.weight(1f)) {
                                        Text(
                                            text = if (isHi) doc.hindiTitle else doc.title,
                                            fontSize = 13.5.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Navy900,
                                            maxLines = 1
                                        )
                                        Text(
                                            text = "${doc.fileName} • ${doc.fileSizeFormatted} • ${doc.pageCount} ${if (isHi) "पेज" else "Pages"}",
                                            fontSize = 11.sp,
                                            color = Color(0xFF64748B)
                                        )
                                    }
                                }

                                Spacer(modifier = Modifier.height(10.dp))

                                // Price & Action Row
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    // Current Price tags
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Text(
                                            text = "₹${doc.discountedPrice}",
                                            fontSize = 14.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            color = EmeraldSuccess
                                        )
                                        Spacer(modifier = Modifier.width(6.dp))
                                        Text(
                                            text = "₹${doc.originalPrice}",
                                            fontSize = 11.sp,
                                            color = Color(0xFF94A3B8),
                                            style = androidx.compose.ui.text.TextStyle(textDecoration = androidx.compose.ui.text.style.TextDecoration.LineThrough)
                                        )
                                        Spacer(modifier = Modifier.width(6.dp))
                                        Box(
                                            modifier = Modifier
                                                .clip(RoundedCornerShape(4.dp))
                                                .background(Color(0xFFFEF3C7))
                                                .padding(horizontal = 5.dp, vertical = 2.dp)
                                        ) {
                                            Text(
                                                text = "${((doc.originalPrice - doc.discountedPrice) * 100) / doc.originalPrice.coerceAtLeast(1)}% OFF",
                                                fontSize = 9.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Color(0xFFB45309)
                                            )
                                        }
                                    }

                                    // Action Buttons: Edit Cost, Open, Delete
                                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                                        // Edit Price Button
                                        OutlinedButton(
                                            onClick = { docForPriceEdit = doc },
                                            modifier = Modifier.height(32.dp).testTag("edit_price_btn_${doc.id}"),
                                            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 0.dp),
                                            shape = RoundedCornerShape(6.dp),
                                            border = androidx.compose.foundation.BorderStroke(1.dp, SaffronGold)
                                        ) {
                                            Icon(Icons.Default.Sell, contentDescription = null, tint = SaffronGold, modifier = Modifier.size(13.dp))
                                            Spacer(modifier = Modifier.width(4.dp))
                                            Text(
                                                text = if (isHi) "कीमत बदलें" else "Edit Cost",
                                                fontSize = 11.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Navy900
                                            )
                                        }

                                        // Read Online Button
                                        IconButton(
                                            onClick = { viewModel.openPdfForReading(doc) },
                                            modifier = Modifier.size(32.dp).testTag("read_doc_btn_${doc.id}")
                                        ) {
                                            Icon(Icons.Default.Visibility, contentDescription = "View PDF", tint = Navy900, modifier = Modifier.size(18.dp))
                                        }

                                        // Delete Button
                                        IconButton(
                                            onClick = { documentToDelete = doc },
                                            modifier = Modifier.size(32.dp).testTag("delete_doc_btn_${doc.id}")
                                        ) {
                                            Icon(Icons.Default.Delete, contentDescription = "Delete PDF", tint = Color(0xFFEF4444), modifier = Modifier.size(18.dp))
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                // Section 2: Catalog Books Price Editing
                item {
                    Spacer(modifier = Modifier.height(18.dp))
                    Text(
                        text = if (isHi) "2. वेबसाइट की सभी ई-बुक्स की कीमतें बदलें (Catalog Price Control):" else "2. Catalog E-Books Live Price Control:",
                        fontSize = 13.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = Navy900
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                }

                items(uiState.customStudyItems) { book ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 3.dp),
                        shape = RoundedCornerShape(10.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFFE2E8F0))
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth().padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = if (isHi) book.hindiTitle else book.title,
                                    fontSize = 12.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Navy900,
                                    maxLines = 1
                                )
                                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                                    Text("₹${book.discountedPrice}", fontSize = 13.sp, fontWeight = FontWeight.Bold, color = EmeraldSuccess)
                                    Text("MRP: ₹${book.originalPrice}", fontSize = 10.5.sp, color = Color(0xFF64748B))
                                    Text("• ${book.seriesName}", fontSize = 10.sp, color = Color(0xFF475569), maxLines = 1)
                                }
                            }

                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                                Button(
                                    onClick = { bookForFullEdit = book },
                                    colors = ButtonDefaults.buttonColors(containerColor = Navy900),
                                    shape = RoundedCornerShape(6.dp),
                                    modifier = Modifier.height(30.dp).testTag("edit_full_ebook_btn_${book.id}"),
                                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 0.dp)
                                ) {
                                    Icon(Icons.Default.Edit, contentDescription = null, tint = SaffronGold, modifier = Modifier.size(12.dp))
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(
                                        text = if (isHi) "एडिट / कीमत" else "Edit / Price",
                                        fontSize = 10.5.sp,
                                        color = Color.White,
                                        fontWeight = FontWeight.Bold
                                    )
                                }

                                IconButton(
                                    onClick = { viewModel.deleteStudyItemFromCatalog(book.id) },
                                    modifier = Modifier.size(30.dp).testTag("delete_ebook_btn_${book.id}")
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Delete,
                                        contentDescription = "Delete E-Book",
                                        tint = Color(0xFFEF4444),
                                        modifier = Modifier.size(16.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // TAB 1: Online Mock Tests & Questions Creator
            if (selectedPortalTab == 1) {
                // Header overview
                item {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(14.dp),
                        colors = CardDefaults.cardColors(containerColor = Navy800)
                    ) {
                        Column(modifier = Modifier.padding(14.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = if (isHi) "ऑनलाइन टेस्ट एवं प्रश्न निर्माण केंद्र" else "CBT Exam & Question Creator",
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = SaffronGold
                                )
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(4.dp))
                                        .background(EmeraldLight)
                                        .padding(horizontal = 6.dp, vertical = 2.dp)
                                ) {
                                    Text("Candidate Ready", fontSize = 9.sp, fontWeight = FontWeight.Bold, color = EmeraldSuccess)
                                }
                            }
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = if (isHi)
                                    "यहाँ आप नए मॉक टेस्ट बना सकते हैं, किसी भी टेस्ट या प्रश्न/विकल्प/समाधान की गलती सुधार (Edit) सकते हैं या हटा (Delete) सकते हैं।"
                                else
                                    "Create custom mock tests, fix or edit any question/option/explanation mistake, or delete tests & questions anytime.",
                                fontSize = 11.5.sp,
                                color = Color(0xFFCBD5E1),
                                lineHeight = 16.sp
                            )
                        }
                    }
                }

                item {
                    Spacer(modifier = Modifier.height(14.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = if (isHi) "सक्रिय ऑनलाइन टेस्ट सीरीज़ (${customTests.size}):" else "Active Online Mock Tests (${customTests.size}):",
                            fontSize = 13.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = Navy900
                        )

                        Button(
                            onClick = { showCreateTestModal = true },
                            colors = ButtonDefaults.buttonColors(containerColor = SaffronGold),
                            shape = RoundedCornerShape(6.dp),
                            modifier = Modifier.height(32.dp)
                        ) {
                            Icon(Icons.Default.Add, contentDescription = null, tint = Navy900, modifier = Modifier.size(14.dp))
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = if (isHi) "+ नया टेस्ट" else "+ New Test",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Navy900
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }

                // Tests List
                items(customTests) { test ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 5.dp)
                            .testTag("owner_test_${test.testId}"),
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
                    ) {
                        Column(modifier = Modifier.padding(14.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(
                                        text = if (isHi) test.hindiTitle else test.title,
                                        fontSize = 13.5.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Navy900
                                    )
                                    Text(
                                        text = "${test.examName} • ${test.durationMinutes} ${if (isHi) "मिनट" else "Mins"} • ${test.questions.size} ${if (isHi) "प्रश्न" else "Questions"}",
                                        fontSize = 11.sp,
                                        color = Color(0xFF64748B)
                                    )
                                    Text(
                                        text = "Marking: +${test.positiveMarks} / -${test.negativeMarks} Marks",
                                        fontSize = 10.5.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        color = EmeraldSuccess
                                    )
                                }

                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    IconButton(
                                        onClick = { testForEditingMetadata = test },
                                        modifier = Modifier.size(32.dp).testTag("btn_edit_test_meta_${test.testId}")
                                    ) {
                                        Icon(Icons.Default.Edit, contentDescription = "Edit Test Details", tint = Navy900, modifier = Modifier.size(18.dp))
                                    }
                                    IconButton(
                                        onClick = { viewModel.deleteMockTestFromCatalog(test.testId) },
                                        modifier = Modifier.size(32.dp).testTag("btn_delete_test_${test.testId}")
                                    ) {
                                        Icon(Icons.Default.Delete, contentDescription = "Delete Test", tint = Color(0xFFEF4444), modifier = Modifier.size(18.dp))
                                    }
                                }
                            }

                            Spacer(modifier = Modifier.height(10.dp))

                            // Test Action Buttons
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                // Add Question & Solution Button
                                Button(
                                    onClick = { testForAddingQuestion = test },
                                    modifier = Modifier.weight(1f).height(36.dp).testTag("btn_add_q_${test.testId}"),
                                    colors = ButtonDefaults.buttonColors(containerColor = Navy900),
                                    shape = RoundedCornerShape(6.dp)
                                ) {
                                    Icon(Icons.Default.Add, contentDescription = null, tint = SaffronGold, modifier = Modifier.size(14.dp))
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(
                                        text = if (isHi) "+ प्रश्न व समाधान जोड़ें" else "+ Add Question & Solution",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White
                                    )
                                }

                                // Take Test Preview Button
                                Button(
                                    onClick = {
                                        viewModel.startTest(test)
                                        viewModel.navigateTo(AppScreen.TEST_SERIES)
                                    },
                                    modifier = Modifier.height(36.dp).testTag("btn_preview_test_${test.testId}"),
                                    colors = ButtonDefaults.buttonColors(containerColor = SaffronGold),
                                    shape = RoundedCornerShape(6.dp)
                                ) {
                                    Icon(Icons.Default.PlayArrow, contentDescription = null, tint = Navy900, modifier = Modifier.size(16.dp))
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(
                                        text = if (isHi) "ऑनलाइन टेस्ट दें" else "Take Online Test",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Navy900
                                    )
                                }
                            }

                            // Show interactive question list with Edit (Fix Mistake) & Delete buttons
                            if (test.questions.isNotEmpty()) {
                                Spacer(modifier = Modifier.height(10.dp))
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(8.dp))
                                        .background(Color(0xFFF1F5F9))
                                        .padding(8.dp)
                                ) {
                                    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                                        Text(
                                            text = if (isHi) "शामिल प्रश्न — किसी भी गलती को सुधारने के लिए 'Edit' दबाएं (${test.questions.size}):" else "Questions Included — Tap 'Edit' to fix any mistake (${test.questions.size}):",
                                            fontSize = 10.5.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Navy900
                                        )
                                        test.questions.take(5).forEachIndexed { idx, q ->
                                            Row(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .clip(RoundedCornerShape(6.dp))
                                                    .background(Color.White)
                                                    .padding(horizontal = 8.dp, vertical = 6.dp),
                                                verticalAlignment = Alignment.CenterVertically,
                                                horizontalArrangement = Arrangement.SpaceBetween
                                            ) {
                                                Text(
                                                    text = "Q${idx + 1}. ${if (isHi) q.questionHi else q.questionEn}",
                                                    fontSize = 10.5.sp,
                                                    color = Color(0xFF334155),
                                                    maxLines = 1,
                                                    modifier = Modifier.weight(1f)
                                                )
                                                Row(verticalAlignment = Alignment.CenterVertically) {
                                                    TextButton(
                                                        onClick = { questionBeingEdited = test.testId to q },
                                                        contentPadding = PaddingValues(horizontal = 6.dp, vertical = 0.dp),
                                                        modifier = Modifier.height(26.dp).testTag("btn_edit_q_${test.testId}_${q.id}")
                                                    ) {
                                                        Text(
                                                            text = if (isHi) "सुधारें (Edit)" else "Fix / Edit",
                                                            fontSize = 10.sp,
                                                            fontWeight = FontWeight.ExtraBold,
                                                            color = Navy900
                                                        )
                                                    }
                                                    IconButton(
                                                        onClick = { viewModel.deleteQuestionFromMockTest(test.testId, q.id) },
                                                        modifier = Modifier.size(24.dp).testTag("btn_del_q_${test.testId}_${q.id}")
                                                    ) {
                                                        Icon(Icons.Default.Delete, contentDescription = "Delete Q", tint = Color(0xFFEF4444), modifier = Modifier.size(14.dp))
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

    // Modal: Full E-Book Details, Thumbnail Badge & Price Editor
    bookForFullEdit?.let { targetBook ->
        var editTitleEn by remember(targetBook) { mutableStateOf(targetBook.title) }
        var editTitleHi by remember(targetBook) { mutableStateOf(targetBook.hindiTitle) }
        var editBadge by remember(targetBook) { mutableStateOf(targetBook.seriesName) }
        var editOrigPrice by remember(targetBook) { mutableStateOf(targetBook.originalPrice.toString()) }
        var editDiscPrice by remember(targetBook) { mutableStateOf(targetBook.discountedPrice.toString()) }

        AlertDialog(
            onDismissRequest = { bookForFullEdit = null },
            title = {
                Text(
                    text = if (isHi) "ई-बुक विवरण, थंबनेल बैज व कीमत एडिट करें" else "Edit E-Book Title, Thumbnail Badge & Price",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Navy900
                )
            },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    OutlinedTextField(
                        value = editTitleEn,
                        onValueChange = { editTitleEn = it },
                        label = { Text("E-Book Title (English)") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    OutlinedTextField(
                        value = editTitleHi,
                        onValueChange = { editTitleHi = it },
                        label = { Text("ई-बुक का नाम (हिंदी)") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    OutlinedTextField(
                        value = editBadge,
                        onValueChange = { editBadge = it },
                        label = { Text("Thumbnail Series / Badge Text") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        OutlinedTextField(
                            value = editDiscPrice,
                            onValueChange = { editDiscPrice = it.filter { ch -> ch.isDigit() } },
                            label = { Text("Sale Price (₹)") },
                            modifier = Modifier.weight(1f)
                        )
                        OutlinedTextField(
                            value = editOrigPrice,
                            onValueChange = { editOrigPrice = it.filter { ch -> ch.isDigit() } },
                            label = { Text("MRP (₹)") },
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        viewModel.updateStudyItemFullDetails(
                            itemId = targetBook.id,
                            newTitleEn = editTitleEn,
                            newTitleHi = editTitleHi,
                            newAuthorOrBadge = editBadge,
                            newOriginalPrice = editOrigPrice.toIntOrNull() ?: targetBook.originalPrice,
                            newDiscountedPrice = editDiscPrice.toIntOrNull() ?: targetBook.discountedPrice
                        )
                        bookForFullEdit = null
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = SaffronGold)
                ) {
                    Text(if (isHi) "सेव करें" else "Save Changes", color = Navy900, fontWeight = FontWeight.Bold)
                }
            },
            dismissButton = {
                TextButton(onClick = { bookForFullEdit = null }) {
                    Text(if (isHi) "रद्द करें" else "Cancel")
                }
            }
        )
    }

    // Modal: Edit Test Series Metadata
    testForEditingMetadata?.let { targetTest ->
        var editTitleEn by remember(targetTest) { mutableStateOf(targetTest.title) }
        var editTitleHi by remember(targetTest) { mutableStateOf(targetTest.hindiTitle) }
        var editExamName by remember(targetTest) { mutableStateOf(targetTest.examName) }
        var editDuration by remember(targetTest) { mutableStateOf(targetTest.durationMinutes.toString()) }
        var editTotalMarks by remember(targetTest) { mutableStateOf(targetTest.totalMarks.toString()) }

        AlertDialog(
            onDismissRequest = { testForEditingMetadata = null },
            title = {
                Text(
                    text = if (isHi) "टेस्ट सीरीज़ विवरण सुधारें (Edit Test Series)" else "Edit Test Series Details",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Navy900
                )
            },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    OutlinedTextField(
                        value = editTitleEn,
                        onValueChange = { editTitleEn = it },
                        label = { Text("Test Title (English)") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    OutlinedTextField(
                        value = editTitleHi,
                        onValueChange = { editTitleHi = it },
                        label = { Text("टेस्ट का नाम (हिंदी)") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    OutlinedTextField(
                        value = editExamName,
                        onValueChange = { editExamName = it },
                        label = { Text("Exam Category Badge") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        OutlinedTextField(
                            value = editDuration,
                            onValueChange = { editDuration = it.filter { ch -> ch.isDigit() } },
                            label = { Text("Duration (Mins)") },
                            modifier = Modifier.weight(1f)
                        )
                        OutlinedTextField(
                            value = editTotalMarks,
                            onValueChange = { editTotalMarks = it.filter { ch -> ch.isDigit() } },
                            label = { Text("Total Marks") },
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        viewModel.updateMockTestMetadata(
                            testId = targetTest.testId,
                            newTitleEn = editTitleEn,
                            newTitleHi = editTitleHi,
                            newExamName = editExamName,
                            newDurationMinutes = editDuration.toIntOrNull() ?: targetTest.durationMinutes,
                            newTotalMarks = editTotalMarks.toIntOrNull() ?: targetTest.totalMarks,
                            newPositiveMarks = targetTest.positiveMarks,
                            newNegativeMarks = targetTest.negativeMarks
                        )
                        testForEditingMetadata = null
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = SaffronGold)
                ) {
                    Text(if (isHi) "अपडेट करें" else "Update Test", color = Navy900, fontWeight = FontWeight.Bold)
                }
            },
            dismissButton = {
                TextButton(onClick = { testForEditingMetadata = null }) {
                    Text(if (isHi) "रद्द करें" else "Cancel")
                }
            }
        )
    }

    // Modal: Edit / Fix Mistake in Existing Question, Options, Correct Answer & Explanation
    questionBeingEdited?.let { (testId, q) ->
        var qEn by remember(q) { mutableStateOf(q.questionEn) }
        var qHi by remember(q) { mutableStateOf(q.questionHi) }
        var opt1En by remember(q) { mutableStateOf(q.optionsEn.getOrElse(0) { "" }) }
        var opt2En by remember(q) { mutableStateOf(q.optionsEn.getOrElse(1) { "" }) }
        var opt3En by remember(q) { mutableStateOf(q.optionsEn.getOrElse(2) { "" }) }
        var opt4En by remember(q) { mutableStateOf(q.optionsEn.getOrElse(3) { "" }) }
        var correctIdxStr by remember(q) { mutableStateOf((q.correctIndex + 1).toString()) }
        var expEn by remember(q) { mutableStateOf(q.explanationEn) }
        var expHi by remember(q) { mutableStateOf(q.explanationHi) }

        AlertDialog(
            onDismissRequest = { questionBeingEdited = null },
            title = {
                Text(
                    text = if (isHi) "प्रश्न, विकल्प व समाधान में गलती सुधारें (Q#${q.id})" else "Fix / Edit Question, Options & Explanation (Q#${q.id})",
                    fontSize = 14.5.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Navy900
                )
            },
            text = {
                LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    item {
                        OutlinedTextField(
                            value = qEn,
                            onValueChange = { qEn = it },
                            label = { Text("Question Text (English)") },
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                    item {
                        OutlinedTextField(
                            value = qHi,
                            onValueChange = { qHi = it },
                            label = { Text("प्रश्न (हिंदी)") },
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                    item {
                        OutlinedTextField(
                            value = opt1En,
                            onValueChange = { opt1En = it },
                            label = { Text("Option 1") },
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                    item {
                        OutlinedTextField(
                            value = opt2En,
                            onValueChange = { opt2En = it },
                            label = { Text("Option 2") },
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                    item {
                        OutlinedTextField(
                            value = opt3En,
                            onValueChange = { opt3En = it },
                            label = { Text("Option 3") },
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                    item {
                        OutlinedTextField(
                            value = opt4En,
                            onValueChange = { opt4En = it },
                            label = { Text("Option 4") },
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                    item {
                        OutlinedTextField(
                            value = correctIdxStr,
                            onValueChange = { correctIdxStr = it.filter { ch -> ch in '1'..'4' }.take(1) },
                            label = { Text("Correct Option (1-4)") },
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                    item {
                        OutlinedTextField(
                            value = expEn,
                            onValueChange = { expEn = it },
                            label = { Text("Detailed Solution (English)") },
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                    item {
                        OutlinedTextField(
                            value = expHi,
                            onValueChange = { expHi = it },
                            label = { Text("विस्तृत व्याख्या (हिंदी)") },
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        val updatedOptionsEn = listOf(opt1En, opt2En, opt3En, opt4En)
                        val updatedOptionsHi = q.optionsHi.mapIndexed { i, oldHi ->
                            if (oldHi == q.optionsEn.getOrNull(i)) updatedOptionsEn[i] else oldHi
                        }
                        val validCorrectIndex = ((correctIdxStr.toIntOrNull() ?: 1) - 1).coerceIn(0, 3)
                        viewModel.updateQuestionInMockTest(
                            testId = testId,
                            updatedQuestion = q.copy(
                                questionEn = qEn.ifBlank { q.questionEn },
                                questionHi = qHi.ifBlank { q.questionHi },
                                optionsEn = updatedOptionsEn,
                                optionsHi = updatedOptionsHi,
                                correctIndex = validCorrectIndex,
                                explanationEn = expEn.ifBlank { q.explanationEn },
                                explanationHi = expHi.ifBlank { q.explanationHi }
                            )
                        )
                        questionBeingEdited = null
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = SaffronGold)
                ) {
                    Text(if (isHi) "सुधार सेव करें" else "Save Fix", color = Navy900, fontWeight = FontWeight.Bold)
                }
            },
            dismissButton = {
                TextButton(onClick = { questionBeingEdited = null }) {
                    Text(if (isHi) "रद्द करें" else "Cancel")
                }
            }
        )
    }

    // Modal: Upload PDF E-Book
    if (showUploadDialog) {
        UploadPdfModal(
            isHi = isHi,
            onDismiss = { showUploadDialog = false },
            onConfirmUpload = { title, hindiTitle, examId, subjectId, fileName, uriStr, origPrice, discPrice, pageCount, medium ->
                viewModel.uploadPdfDocument(
                    title = title,
                    hindiTitle = hindiTitle,
                    examId = examId,
                    subjectId = subjectId,
                    fileName = fileName,
                    fileUri = uriStr,
                    originalPrice = origPrice,
                    discountedPrice = discPrice,
                    pageCount = pageCount,
                    medium = medium
                )
                showUploadDialog = false
            }
        )
    }

    // Modal: Edit Document Price
    docForPriceEdit?.let { doc ->
        EditPriceModal(
            isHi = isHi,
            itemTitle = if (isHi) doc.hindiTitle else doc.title,
            currentOriginalPrice = doc.originalPrice,
            currentDiscountedPrice = doc.discountedPrice,
            onDismiss = { docForPriceEdit = null },
            onSavePrice = { newOrig, newDisc ->
                viewModel.updateDocumentPrice(doc.id, newOrig, newDisc)
                docForPriceEdit = null
            }
        )
    }

    // Modal: Edit Catalog Book Price
    itemForPriceEdit?.let { book ->
        EditPriceModal(
            isHi = isHi,
            itemTitle = if (isHi) book.hindiTitle else book.title,
            currentOriginalPrice = book.originalPrice,
            currentDiscountedPrice = book.discountedPrice,
            onDismiss = { itemForPriceEdit = null },
            onSavePrice = { newOrig, newDisc ->
                viewModel.updateStudyItemPrice(book.id, newOrig, newDisc)
                itemForPriceEdit = null
            }
        )
    }

    // Modal: Create Online Mock Test
    if (showCreateTestModal) {
        CreateTestModal(
            isHi = isHi,
            onDismiss = { showCreateTestModal = false },
            onConfirmCreate = { title, hindiTitle, examName, duration, marks, pos, neg ->
                viewModel.createOnlineMockTest(
                    title = title,
                    hindiTitle = hindiTitle,
                    examName = examName,
                    durationMinutes = duration,
                    totalMarks = marks,
                    positiveMarks = pos,
                    negativeMarks = neg
                )
                showCreateTestModal = false
            }
        )
    }

    // Modal: Add Question & Solution
    testForAddingQuestion?.let { targetTest ->
        AddQuestionModal(
            isHi = isHi,
            testTitle = if (isHi) targetTest.hindiTitle else targetTest.title,
            onDismiss = { testForAddingQuestion = null },
            onConfirmAdd = { question ->
                viewModel.addQuestionToMockTest(targetTest.testId, question)
                testForAddingQuestion = null
            }
        )
    }

    // Modal: Delete Document Confirmation
    documentToDelete?.let { targetDoc ->
        AlertDialog(
            onDismissRequest = { documentToDelete = null },
            title = {
                Text(
                    text = if (isHi) "दस्तावेज़ हटाएं?" else "Delete Document?",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            },
            text = {
                Text(
                    text = if (isHi)
                        "क्या आप वाकई '${targetDoc.hindiTitle}' को हटाना चाहते हैं? यह प्रक्रिया वापस नहीं ली जा सकती।"
                    else
                        "Are you sure you want to delete '${targetDoc.title}'? This action cannot be undone.",
                    fontSize = 13.sp,
                    color = Color(0xFF475569)
                )
            },
            confirmButton = {
                Button(
                    onClick = {
                        viewModel.deletePdfDocument(targetDoc.id)
                        documentToDelete = null
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEF4444))
                ) {
                    Text(if (isHi) "हाँ, हटाएं (Delete)" else "Yes, Delete", color = Color.White)
                }
            },
            dismissButton = {
                TextButton(onClick = { documentToDelete = null }) {
                    Text(if (isHi) "रद्द करें" else "Cancel")
                }
            }
        )
    }
}

/**
 * Upload PDF Modal with Zero-permission SAF File Picker.
 */
@Composable
fun UploadPdfModal(
    isHi: Boolean,
    onDismiss: () -> Unit,
    onConfirmUpload: (
        title: String,
        hindiTitle: String,
        examId: String,
        subjectId: String,
        fileName: String,
        uriString: String,
        originalPrice: Int,
        discountedPrice: Int,
        pageCount: Int,
        medium: String
    ) -> Unit
) {
    var title by remember { mutableStateOf("") }
    var hindiTitle by remember { mutableStateOf("") }
    var fileName by remember { mutableStateOf("UPSC_Complete_Study_Module.pdf") }
    var uriString by remember { mutableStateOf("") }
    var pageCountStr by remember { mutableStateOf("150") }
    var originalPriceStr by remember { mutableStateOf("499") }
    var discountedPriceStr by remember { mutableStateOf("179") }
    var medium by remember { mutableStateOf("Bilingual (Hindi + English)") }
    var selectedExamId by remember { mutableStateOf("upsc_cse") }

    // Android SAF PDF File Picker (Zero-permission compliant)
    val pdfPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {
            uriString = it.toString()
            fileName = it.lastPathSegment?.substringAfterLast('/') ?: "Selected_Document.pdf"
            if (title.isBlank()) {
                title = fileName.removeSuffix(".pdf").replace('_', ' ')
            }
            if (hindiTitle.isBlank()) {
                hindiTitle = title
            }
        }
    }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.CloudUpload,
                    contentDescription = null,
                    tint = SaffronGold,
                    modifier = Modifier.size(22.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = if (isHi) "नया PDF / ई-बुक अपलोड करें" else "Upload New PDF / E-Book",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Navy900
                )
            }
        },
        text = {
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                // PDF File Selection Button
                item {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { pdfPickerLauncher.launch("application/pdf") },
                        shape = RoundedCornerShape(10.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFF1F5F9)),
                        border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFFCBD5E1))
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(36.dp)
                                    .clip(CircleShape)
                                    .background(Navy900),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(Icons.Default.AttachFile, contentDescription = null, tint = SaffronGold, modifier = Modifier.size(18.dp))
                            }
                            Spacer(modifier = Modifier.width(10.dp))
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = if (uriString.isBlank())
                                        (if (isHi) "डिवाइस से PDF फ़ाइल चुनें" else "Choose PDF File from Device")
                                    else
                                        fileName,
                                    fontSize = 12.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (uriString.isBlank()) Navy900 else EmeraldSuccess
                                )
                                Text(
                                    text = if (uriString.isBlank())
                                        (if (isHi) "टैप करके अपने फ़ोन / पीसी से PDF लोड करें" else "Tap to browse local storage")
                                    else
                                        "✓ PDF File Selected",
                                    fontSize = 10.5.sp,
                                    color = Color(0xFF64748B)
                                )
                            }
                        }
                    }
                }

                // English Title
                item {
                    OutlinedTextField(
                        value = title,
                        onValueChange = { title = it },
                        label = { Text("E-Book Title (English)") },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true
                    )
                }

                // Hindi Title
                item {
                    OutlinedTextField(
                        value = hindiTitle,
                        onValueChange = { hindiTitle = it },
                        label = { Text("ई-बुक का शीर्षक (हिंदी)") },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true
                    )
                }

                // Pricing Row
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        OutlinedTextField(
                            value = discountedPriceStr,
                            onValueChange = { discountedPriceStr = it.filter { ch -> ch.isDigit() } },
                            label = { Text(if (isHi) "विक्रय मूल्य (₹)" else "Cost / Price (₹)") },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            modifier = Modifier.weight(1f)
                        )
                        OutlinedTextField(
                            value = originalPriceStr,
                            onValueChange = { originalPriceStr = it.filter { ch -> ch.isDigit() } },
                            label = { Text(if (isHi) "मूल MRP (₹)" else "MRP (₹)") },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            modifier = Modifier.weight(1f)
                        )
                    }
                }

                // Page Count
                item {
                    OutlinedTextField(
                        value = pageCountStr,
                        onValueChange = { pageCountStr = it.filter { ch -> ch.isDigit() } },
                        label = { Text(if (isHi) "कुल पृष्ठ (Page Count)" else "Total Pages") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    val finalTitle = title.ifBlank { "Modern Study E-Book" }
                    val finalHindi = hindiTitle.ifBlank { "आधुनिक अध्ययन ई-बुक" }
                    val orig = originalPriceStr.toIntOrNull() ?: 399
                    val disc = discountedPriceStr.toIntOrNull() ?: 149
                    val pages = pageCountStr.toIntOrNull() ?: 120
                    onConfirmUpload(
                        finalTitle,
                        finalHindi,
                        selectedExamId,
                        "general_subject",
                        fileName,
                        uriString,
                        orig,
                        disc,
                        pages,
                        medium
                    )
                },
                colors = ButtonDefaults.buttonColors(containerColor = SaffronGold)
            ) {
                Text(
                    text = if (isHi) "प्रकाशित करें (Publish)" else "Publish Document",
                    color = Navy900,
                    fontWeight = FontWeight.Bold
                )
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(if (isHi) "रद्द करें" else "Cancel")
            }
        }
    )
}
