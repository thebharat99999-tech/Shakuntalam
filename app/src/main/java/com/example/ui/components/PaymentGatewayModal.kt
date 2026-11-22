package com.example.ui.components

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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Smartphone
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material.icons.filled.Wallet
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.AppLanguage
import com.example.model.PaymentMethodType
import com.example.ui.theme.AmberGold
import com.example.ui.theme.EmeraldLight
import com.example.ui.theme.EmeraldSuccess
import com.example.ui.theme.Navy100
import com.example.ui.theme.Navy800
import com.example.ui.theme.Navy900
import com.example.ui.theme.SaffronGold
import kotlinx.coroutines.delay

@Composable
fun PaymentGatewayModal(
    amount: Int,
    itemsTitle: String,
    language: AppLanguage,
    ownerUpiId: String = "6396817525@jio",
    ownerUpiMobile: String = "6396817525",
    ownerMerchantName: String = "Shakuntalam Publications",
    ownerBankName: String = "Jio Payments Bank / UPI Linked Bank",
    ownerAccountNumber: String = "",
    ownerIfscCode: String = "",
    onDismiss: () -> Unit,
    onPaymentSuccess: (receiptNumber: String) -> Unit
) {
    val context = LocalContext.current
    val isHi = language == AppLanguage.HINDI
    val orderId = remember { "SHAK_ORD_${System.currentTimeMillis() % 1000000}" }

    var selectedTab by remember { mutableStateOf(0) }
    val tabTitles = listOf(
        if (isHi) "UPI (गूगल पे/फोनपे)" else "UPI (GPay/PhonePe)",
        if (isHi) "कार्ड (डेबिट/क्रेडिट)" else "Cards (Debit/Credit)",
        if (isHi) "नेट बैंकिंग" else "Net Banking",
        if (isHi) "वॉलेट्स" else "Wallets"
    )

    // Form inputs
    var upiId by remember { mutableStateOf("student@okhdfcbank") }
    var cardNumber by remember { mutableStateOf("4532 •••• •••• 8912") }
    var cardExpiry by remember { mutableStateOf("09/28") }
    var cardCvv by remember { mutableStateOf("•••") }
    var cardHolder by remember { mutableStateOf("Aspirant Name") }
    var selectedBank by remember { mutableStateOf("State Bank of India") }
    var customerPhone by remember { mutableStateOf("9876543210") }

    // Processing & Success State
    var paymentState by remember { mutableStateOf("IDLE") } // "IDLE", "PROCESSING", "SUCCESS"
    var transactionRef by remember { mutableStateOf("") }

    LaunchedEffect(paymentState) {
        if (paymentState == "PROCESSING") {
            delay(1600) // Simulate secure 256-bit banking handshake
            val txnId = "SHAK_TXN_${System.currentTimeMillis() % 10000000}"
            transactionRef = txnId
            paymentState = "SUCCESS"
        }
    }

    AlertDialog(
        onDismissRequest = {
            if (paymentState != "PROCESSING") onDismiss()
        },
        confirmButton = {},
        dismissButton = {},
        modifier = Modifier.fillMaxWidth().testTag("payment_gateway_dialog"),
        text = {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                ) {
                    // Gateway Header
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Navy900)
                            .padding(14.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(
                                        imageVector = Icons.Default.Security,
                                        contentDescription = null,
                                        tint = SaffronGold,
                                        modifier = Modifier.size(16.dp)
                                    )
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text(
                                        text = "SHAKUNTALAM GATEWAY",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = SaffronGold,
                                        letterSpacing = 0.5.sp
                                    )
                                }
                                Text(
                                    text = if (isHi) "सुरक्षित 256-बिट SSL भुगतान" else "256-Bit SSL Encrypted Checkout",
                                    fontSize = 10.sp,
                                    color = Color(0xFFCBD5E1)
                                )
                            }

                            if (paymentState != "PROCESSING") {
                                IconButton(
                                    onClick = onDismiss,
                                    modifier = Modifier.size(28.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Close,
                                        contentDescription = "Close",
                                        tint = Color.White
                                    )
                                }
                            }
                        }
                    }

                    // Order Summary Strip
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFFF1F5F9))
                            .padding(horizontal = 14.dp, vertical = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(
                                text = "ऑर्डर आईडी: $orderId",
                                fontSize = 10.5.sp,
                                color = Color(0xFF64748B),
                                fontWeight = FontWeight.Medium
                            )
                            Text(
                                text = itemsTitle,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = Navy900,
                                maxLines = 1
                            )
                        }

                        Column(horizontalAlignment = Alignment.End) {
                            Text(
                                text = "₹$amount",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = EmeraldSuccess
                            )
                            Text(
                                text = if (isHi) "कर सहित" else "Incl. Taxes",
                                fontSize = 9.5.sp,
                                color = Color(0xFF64748B)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    when (paymentState) {
                        "PROCESSING" -> {
                            // Payment Processing View
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 36.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    CircularProgressIndicator(
                                        color = SaffronGold,
                                        strokeWidth = 3.dp,
                                        modifier = Modifier.size(48.dp)
                                    )
                                    Spacer(modifier = Modifier.height(16.dp))
                                    Text(
                                        text = if (isHi) "बैंक गेटवे से प्रमाणीकरण हो रहा है..." else "Authorizing with Bank Gateway...",
                                        fontSize = 13.5.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Navy900
                                    )
                                    Text(
                                        text = if (isHi) "कृपया बैक या रिफ्रेश न करें।" else "Please do not press back or refresh.",
                                        fontSize = 11.sp,
                                        color = Color(0xFF64748B),
                                        modifier = Modifier.padding(top = 4.dp)
                                    )
                                }
                            }
                        }

                        "SUCCESS" -> {
                            // Success Receipt View
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(60.dp)
                                        .clip(CircleShape)
                                        .background(EmeraldLight),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.CheckCircle,
                                        contentDescription = "Success",
                                        tint = EmeraldSuccess,
                                        modifier = Modifier.size(36.dp)
                                    )
                                }

                                Spacer(modifier = Modifier.height(12.dp))

                                Text(
                                    text = if (isHi) "भुगतान सफल रहा!" else "Payment Successful!",
                                    fontSize = 17.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = EmeraldSuccess
                                )

                                Text(
                                    text = if (isHi) "₹$amount का भुगतान प्राप्त हुआ।" else "₹$amount successfully received.",
                                    fontSize = 12.sp,
                                    color = Color(0xFF475569)
                                )

                                Spacer(modifier = Modifier.height(14.dp))

                                Card(
                                    modifier = Modifier.fillMaxWidth(),
                                    colors = CardDefaults.cardColors(containerColor = Color(0xFFF8FAFC)),
                                    shape = RoundedCornerShape(10.dp),
                                    border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFFE2E8F0))
                                ) {
                                    Column(modifier = Modifier.padding(12.dp)) {
                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.SpaceBetween
                                        ) {
                                            Text(text = "रेफरेंस आईडी (Txn ID):", fontSize = 11.sp, color = Color(0xFF64748B))
                                            Text(text = transactionRef, fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Navy900)
                                        }
                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(top = 4.dp),
                                            horizontalArrangement = Arrangement.SpaceBetween
                                        ) {
                                            Text(text = "ऑर्डर आईडी:", fontSize = 11.sp, color = Color(0xFF64748B))
                                            Text(text = orderId, fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Navy900)
                                        }
                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(top = 4.dp),
                                            horizontalArrangement = Arrangement.SpaceBetween
                                        ) {
                                            Text(text = "स्थिति:", fontSize = 11.sp, color = Color(0xFF64748B))
                                            Text(text = "सफल (Instant Active)", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = EmeraldSuccess)
                                        }
                                    }
                                }

                                Spacer(modifier = Modifier.height(16.dp))

                                Button(
                                    onClick = { onPaymentSuccess(transactionRef) },
                                    colors = ButtonDefaults.buttonColors(containerColor = EmeraldSuccess),
                                    shape = RoundedCornerShape(10.dp),
                                    modifier = Modifier.fillMaxWidth().height(42.dp).testTag("gateway_done_btn")
                                ) {
                                    Text(
                                        text = if (isHi) "लाइब्रेरी में जाएं और अभी पढ़ें" else "Go to Library & Read Now",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 13.sp,
                                        color = Color.White
                                    )
                                }
                            }
                        }

                        else -> {
                            // Payment Input & Method Selection
                            Column(modifier = Modifier.padding(horizontal = 14.dp)) {
                                // Method Tabs
                                ScrollableTabRow(
                                    selectedTabIndex = selectedTab,
                                    containerColor = Color.White,
                                    contentColor = Navy900,
                                    edgePadding = 0.dp,
                                    indicator = { tabPositions ->
                                        if (selectedTab < tabPositions.size) {
                                            TabRowDefaults.SecondaryIndicator(
                                                modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTab]),
                                                color = SaffronGold,
                                                height = 2.5.dp
                                            )
                                        }
                                    }
                                ) {
                                    tabTitles.forEachIndexed { idx, title ->
                                        Tab(
                                            selected = selectedTab == idx,
                                            onClick = { selectedTab = idx },
                                            text = {
                                                Text(
                                                    text = title,
                                                    fontSize = 11.sp,
                                                    fontWeight = if (selectedTab == idx) FontWeight.Bold else FontWeight.Normal,
                                                    color = if (selectedTab == idx) Navy900 else Color(0xFF64748B)
                                                )
                                            }
                                        )
                                    }
                                }

                                Spacer(modifier = Modifier.height(14.dp))

                                when (selectedTab) {
                                    0 -> {
                                        // UPI Option with Owner's Linked UPI ID & Deep Link
                                        Column {
                                            // Linked Owner Receiver Badge
                                            Row(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .clip(RoundedCornerShape(8.dp))
                                                    .background(EmeraldLight)
                                                    .border(1.dp, EmeraldSuccess.copy(alpha = 0.4f), RoundedCornerShape(8.dp))
                                                    .padding(horizontal = 10.dp, vertical = 8.dp),
                                                verticalAlignment = Alignment.CenterVertically,
                                                horizontalArrangement = Arrangement.SpaceBetween
                                            ) {
                                                Column(modifier = Modifier.weight(1f)) {
                                                    Text(
                                                        text = if (isHi) "भुगतान प्राप्तकर्ता (Verified Receiver):" else "Verified Receiver (UPI & Mobile):",
                                                        fontSize = 10.sp,
                                                        color = Color(0xFF065F46)
                                                    )
                                                    Text(
                                                        text = "UPI: $ownerUpiId • Mob: $ownerUpiMobile",
                                                        fontSize = 11.5.sp,
                                                        fontWeight = FontWeight.ExtraBold,
                                                        color = EmeraldSuccess
                                                    )
                                                    Text(
                                                        text = "$ownerMerchantName (${ownerBankName})" +
                                                                if (ownerAccountNumber.isNotBlank()) " • A/c: $ownerAccountNumber (${ownerIfscCode})" else "",
                                                        fontSize = 10.sp,
                                                        color = Color(0xFF047857)
                                                    )
                                                }
                                                Icon(
                                                    imageVector = Icons.Default.Verified,
                                                    contentDescription = "Verified UPI",
                                                    tint = EmeraldSuccess,
                                                    modifier = Modifier.size(18.dp)
                                                )
                                            }

                                            Spacer(modifier = Modifier.height(10.dp))

                                            Text(
                                                text = if (isHi) "सीधे UPI ऐप खोलें (1-Click UPI Intent):" else "Pay Directly via UPI App (0% Fee):",
                                                fontSize = 11.5.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Navy900
                                            )

                                            Spacer(modifier = Modifier.height(8.dp))

                                            // Fast UPI App Chips with Real Android UPI Deep Link
                                            Row(
                                                horizontalArrangement = Arrangement.spacedBy(6.dp),
                                                modifier = Modifier.fillMaxWidth()
                                            ) {
                                                listOf("Google Pay", "PhonePe", "Paytm", "BHIM").forEach { appName ->
                                                    Box(
                                                        modifier = Modifier
                                                            .weight(1f)
                                                            .clip(RoundedCornerShape(8.dp))
                                                            .background(Color(0xFFF1F5F9))
                                                            .border(1.dp, Color(0xFFCBD5E1), RoundedCornerShape(8.dp))
                                                            .clickable {
                                                                upiId = "student@${appName.lowercase().take(4)}"
                                                                try {
                                                                    val upiUri = Uri.parse(
                                                                        "upi://pay?pa=${Uri.encode(ownerUpiId)}" +
                                                                                "&pn=${Uri.encode(ownerMerchantName)}" +
                                                                                "&am=$amount" +
                                                                                "&cu=INR" +
                                                                                "&tn=${Uri.encode("Shakuntalam: $itemsTitle")}"
                                                                    )
                                                                    val intent = Intent(Intent.ACTION_VIEW, upiUri)
                                                                    context.startActivity(intent)
                                                                } catch (_: Exception) {
                                                                    Toast.makeText(
                                                                        context,
                                                                        if (isHi) "$appName चयनित — भुगतान बटन दबाएं" else "$appName selected for $ownerUpiId",
                                                                        Toast.LENGTH_SHORT
                                                                    ).show()
                                                                }
                                                            }
                                                            .padding(vertical = 8.dp),
                                                        contentAlignment = Alignment.Center
                                                    ) {
                                                        Text(text = appName, fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Navy900)
                                                    }
                                                }
                                            }

                                            Spacer(modifier = Modifier.height(10.dp))

                                            OutlinedTextField(
                                                value = upiId,
                                                onValueChange = { upiId = it },
                                                label = { Text(if (isHi) "आपकी UPI ID (VPA)" else "Your UPI ID (VPA)", fontSize = 11.sp) },
                                                placeholder = { Text("example@okhdfcbank", fontSize = 11.sp) },
                                                singleLine = true,
                                                shape = RoundedCornerShape(8.dp),
                                                modifier = Modifier.fillMaxWidth(),
                                                colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = SaffronGold)
                                            )
                                        }
                                    }

                                    1 -> {
                                        // Card Option
                                        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                            OutlinedTextField(
                                                value = cardNumber,
                                                onValueChange = { cardNumber = it },
                                                label = { Text("Card Number", fontSize = 11.sp) },
                                                singleLine = true,
                                                shape = RoundedCornerShape(8.dp),
                                                modifier = Modifier.fillMaxWidth()
                                            )
                                            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                                OutlinedTextField(
                                                    value = cardExpiry,
                                                    onValueChange = { cardExpiry = it },
                                                    label = { Text("MM/YY", fontSize = 11.sp) },
                                                    modifier = Modifier.weight(1f),
                                                    shape = RoundedCornerShape(8.dp)
                                                )
                                                OutlinedTextField(
                                                    value = cardCvv,
                                                    onValueChange = { cardCvv = it },
                                                    label = { Text("CVV", fontSize = 11.sp) },
                                                    modifier = Modifier.weight(1f),
                                                    shape = RoundedCornerShape(8.dp)
                                                )
                                            }
                                        }
                                    }

                                    2 -> {
                                        // Net Banking Option
                                        Column {
                                            Text(
                                                text = if (isHi) "लोकप्रिय बैंक चुनें:" else "Select Popular Bank:",
                                                fontSize = 11.5.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Navy900
                                            )
                                            Spacer(modifier = Modifier.height(6.dp))
                                            listOf("State Bank of India", "HDFC Bank", "ICICI Bank", "Punjab National Bank").forEach { bank ->
                                                Row(
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .clickable { selectedBank = bank }
                                                        .padding(vertical = 4.dp),
                                                    verticalAlignment = Alignment.CenterVertically
                                                ) {
                                                    RadioButton(
                                                        selected = selectedBank == bank,
                                                        onClick = { selectedBank = bank },
                                                        colors = RadioButtonDefaults.colors(selectedColor = SaffronGold)
                                                    )
                                                    Text(text = bank, fontSize = 12.sp, color = Navy900)
                                                }
                                            }
                                        }
                                    }

                                    3 -> {
                                        // Wallets
                                        Column {
                                            Text(
                                                text = if (isHi) "सक्रिय वॉलेट चुनें:" else "Choose Active Wallet:",
                                                fontSize = 11.5.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Navy900
                                            )
                                            Spacer(modifier = Modifier.height(6.dp))
                                            listOf("Paytm Wallet", "Amazon Pay", "Mobikwik").forEach { wallet ->
                                                Row(
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .padding(vertical = 4.dp),
                                                    verticalAlignment = Alignment.CenterVertically
                                                ) {
                                                    Icon(Icons.Default.Wallet, contentDescription = null, tint = SaffronGold, modifier = Modifier.size(18.dp))
                                                    Spacer(modifier = Modifier.width(8.dp))
                                                    Text(text = wallet, fontSize = 12.sp, color = Navy900)
                                                }
                                            }
                                        }
                                    }
                                }

                                Spacer(modifier = Modifier.height(16.dp))

                                // Pay Button
                                Button(
                                    onClick = { paymentState = "PROCESSING" },
                                    colors = ButtonDefaults.buttonColors(containerColor = EmeraldSuccess),
                                    shape = RoundedCornerShape(10.dp),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(44.dp)
                                        .testTag("gateway_pay_button")
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Lock,
                                        contentDescription = null,
                                        tint = Color.White,
                                        modifier = Modifier.size(16.dp)
                                    )
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text(
                                        text = if (isHi) "₹$amount का सुरक्षित भुगतान करें" else "Pay Securely ₹$amount",
                                        fontSize = 13.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White
                                    )
                                }

                                Spacer(modifier = Modifier.height(6.dp))

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(Icons.Default.Verified, contentDescription = null, tint = EmeraldSuccess, modifier = Modifier.size(12.dp))
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(
                                        text = "100% RBI & PCI-DSS Compliant Gateway",
                                        fontSize = 9.5.sp,
                                        color = Color(0xFF64748B)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    )
}
