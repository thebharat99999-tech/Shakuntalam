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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Discount
import androidx.compose.material.icons.filled.LocalOffer
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.QrCode2
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.CartItem
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
fun CartScreen(
    uiState: ShakuntalamUiState,
    viewModel: ShakuntalamViewModel,
    modifier: Modifier = Modifier
) {
    val isHi = uiState.selectedLanguage == com.example.model.AppLanguage.HINDI
    var couponInput by remember { mutableStateOf("") }
    var selectedPaymentMode by remember { mutableStateOf("UPI") }

    val cartItems = uiState.cartItems
    val subTotal = cartItems.sumOf { it.studyItem.discountedPrice }
    val mrpTotal = cartItems.sumOf { it.studyItem.originalPrice }
    val discountPercent = uiState.couponDiscountPercent
    val couponSavings = (subTotal * discountPercent) / 100
    val finalAmount = (subTotal - couponSavings).coerceAtLeast(0)

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = Navy900,
                shadowElevation = 4.dp
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .statusBarsPadding()
                        .padding(horizontal = 16.dp, vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = null,
                        tint = SaffronGold,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        Text(
                            text = if (isHi) "शॉपिंग कार्ट (Shopping Cart)" else "Shopping Cart",
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Text(
                            text = if (isHi) "${cartItems.size} वस्तुएं चयनित" else "${cartItems.size} Items Selected",
                            fontSize = 11.5.sp,
                            color = Color(0xFFCBD5E1)
                        )
                    }
                }
            }
        },
        bottomBar = {
            if (cartItems.isNotEmpty()) {
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
                            Text(
                                text = if (isHi) "कुल देय राशि (Total Payable):" else "Total Payable Amount:",
                                fontSize = 11.sp,
                                color = Color(0xFF64748B)
                            )
                            Row(verticalAlignment = Alignment.Bottom) {
                                Text(
                                    text = "₹$finalAmount",
                                    fontSize = 22.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Navy900
                                )
                                if (couponSavings > 0) {
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text(
                                        text = if (isHi) "(बचत: ₹$couponSavings)" else "(Saved: ₹$couponSavings)",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = EmeraldSuccess
                                    )
                                }
                            }
                        }

                        Button(
                            onClick = {
                                val summary = cartItems.joinToString { it.studyItem.title }
                                viewModel.openPaymentGateway(finalAmount, summary)
                            },
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = EmeraldSuccess),
                            modifier = Modifier
                                .height(44.dp)
                                .testTag("checkout_button")
                        ) {
                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = if (isHi) "सुरक्षित भुगतान करें" else "Proceed to Secure Pay",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }
    ) { innerPadding ->
        if (cartItems.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFF8FAFC))
                    .padding(innerPadding)
                    .padding(32.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Box(
                        modifier = Modifier
                            .size(72.dp)
                            .clip(CircleShape)
                            .background(Navy100),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.ShoppingBag,
                            contentDescription = null,
                            tint = Navy900,
                            modifier = Modifier.size(36.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = if (isHi) "आपकी कार्ट खाली है" else "Your Cart is Empty",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Navy900
                    )
                    Text(
                        text = if (isHi) "शकुंतलम ई-बुक श्रृंखला से अपनी मनपसंद पुस्तकें व टेस्ट सीरीज़ जोड़ें।" else "Explore Shakuntalam E-Books & Test Series to add study materials to your cart.",
                        fontSize = 12.5.sp,
                        color = Color(0xFF64748B),
                        modifier = Modifier.padding(top = 4.dp, bottom = 20.dp)
                    )
                    Button(
                        onClick = { viewModel.navigateTo(AppScreen.EXPLORER) },
                        colors = ButtonDefaults.buttonColors(containerColor = SaffronGold),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text(
                            text = if (isHi) "ई-बुक्स ब्राउज़ करें" else "Browse E-Books & Tests",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFF8FAFC))
                .padding(innerPadding)
                .padding(horizontal = 16.dp, vertical = 12.dp),
                contentPadding = PaddingValues(bottom = 20.dp)
            ) {
                // Cart Items List
                items(cartItems) { cartItem ->
                    val item = cartItem.studyItem
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 5.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
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
                                    text = item.seriesName,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = SaffronGold
                                )
                                Text(
                                    text = if (isHi) item.hindiTitle else item.title,
                                    fontSize = 13.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Navy900,
                                    maxLines = 1
                                )
                                Text(
                                    text = "${item.medium} • ${item.totalPagesOrTests}",
                                    fontSize = 11.sp,
                                    color = Color(0xFF64748B)
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Row(verticalAlignment = Alignment.Bottom) {
                                    Text(
                                        text = "₹${item.discountedPrice}",
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = Navy900
                                    )
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text(
                                        text = "₹${item.originalPrice}",
                                        fontSize = 11.5.sp,
                                        textDecoration = TextDecoration.LineThrough,
                                        color = Color(0xFF94A3B8)
                                    )
                                }
                            }

                            IconButton(
                                onClick = { viewModel.removeFromCart(item.id) },
                                modifier = Modifier.testTag("remove_cart_${item.id}")
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Delete,
                                    contentDescription = "Remove",
                                    tint = Color(0xFFEF4444)
                                )
                            }
                        }
                    }
                }

                // Coupon Code Section
                item {
                    Spacer(modifier = Modifier.height(14.dp))
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White)
                    ) {
                        Column(modifier = Modifier.padding(14.dp)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.LocalOffer,
                                    contentDescription = null,
                                    tint = SaffronGold,
                                    modifier = Modifier.size(18.dp)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = if (isHi) "कूपन कोड लागू करें (Apply Coupon):" else "Apply Promo / Coupon Code:",
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Navy900
                                )
                            }

                            Spacer(modifier = Modifier.height(10.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                OutlinedTextField(
                                    value = couponInput,
                                    onValueChange = { couponInput = it },
                                    modifier = Modifier.weight(1f),
                                    placeholder = { Text(if (isHi) "जैसे: SHAKUNTALAM50" else "e.g. SHAKUNTALAM50", fontSize = 12.sp) },
                                    singleLine = true,
                                    shape = RoundedCornerShape(8.dp),
                                    colors = OutlinedTextFieldDefaults.colors(
                                        focusedBorderColor = SaffronGold
                                    )
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Button(
                                    onClick = {
                                        viewModel.applyCoupon(couponInput)
                                    },
                                    colors = ButtonDefaults.buttonColors(containerColor = Navy900),
                                    shape = RoundedCornerShape(8.dp)
                                ) {
                                    Text(if (isHi) "लागू करें" else "Apply", fontSize = 12.sp, color = Color.White)
                                }
                            }

                            // Active Coupon Info
                            if (uiState.appliedCoupon != null) {
                                Spacer(modifier = Modifier.height(8.dp))
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(6.dp))
                                        .background(EmeraldLight)
                                        .padding(8.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Icon(
                                            imageVector = Icons.Default.CheckCircle,
                                            contentDescription = null,
                                            tint = EmeraldSuccess,
                                            modifier = Modifier.size(16.dp)
                                        )
                                        Spacer(modifier = Modifier.width(6.dp))
                                        Text(
                                            text = if (isHi) "${uiState.appliedCoupon} लागू (${uiState.couponDiscountPercent}% छूट)" else "${uiState.appliedCoupon} Applied (${uiState.couponDiscountPercent}% OFF)",
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = EmeraldSuccess
                                        )
                                    }
                                    Text(
                                        text = if (isHi) "हटाएं" else "Remove",
                                        fontSize = 11.5.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFFDC2626),
                                        modifier = Modifier.clickable { viewModel.clearCoupon() }
                                    )
                                }
                            }
                        }
                    }
                }

                // Payment Mode Selector
                item {
                    Spacer(modifier = Modifier.height(14.dp))
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White)
                    ) {
                        Column(modifier = Modifier.padding(14.dp)) {
                            Text(
                                text = if (isHi) "भुगतान विधि चुनें (Payment Method):" else "Select Payment Method:",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = Navy900
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            // UPI
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable { selectedPaymentMode = "UPI" }
                                    .padding(vertical = 4.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                RadioButton(
                                    selected = selectedPaymentMode == "UPI",
                                    onClick = { selectedPaymentMode = "UPI" },
                                    colors = RadioButtonDefaults.colors(selectedColor = SaffronGold)
                                )
                                Icon(Icons.Default.QrCode2, contentDescription = null, tint = Navy900)
                                Spacer(modifier = Modifier.width(8.dp))
                                Column {
                                    Text("UPI (Google Pay, PhonePe, Paytm, BHIM)", fontSize = 12.5.sp, fontWeight = FontWeight.SemiBold, color = Navy900)
                                    Text(
                                        text = if (isHi) "त्वरित एक्टिवेशन • लिंक्ड: ${uiState.ownerUpiId}" else "Instant Activation • Linked: ${uiState.ownerUpiId}",
                                        fontSize = 10.5.sp,
                                        color = EmeraldSuccess
                                    )
                                }
                            }

                            // Cards
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable { selectedPaymentMode = "CARD" }
                                    .padding(vertical = 4.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                RadioButton(
                                    selected = selectedPaymentMode == "CARD",
                                    onClick = { selectedPaymentMode = "CARD" },
                                    colors = RadioButtonDefaults.colors(selectedColor = SaffronGold)
                                )
                                Icon(Icons.Default.CreditCard, contentDescription = null, tint = Navy900)
                                Spacer(modifier = Modifier.width(8.dp))
                                Column {
                                    Text(if (isHi) "डेबिट / क्रेडिट कार्ड (RuPay, Visa, Master)" else "Debit / Credit Card (RuPay, Visa, Master)", fontSize = 12.5.sp, fontWeight = FontWeight.SemiBold, color = Navy900)
                                    Text(if (isHi) "सुरक्षित 256-बिट SSL एन्क्रिप्टेड" else "Secure 256-bit SSL Encrypted", fontSize = 10.5.sp, color = Color(0xFF64748B))
                                }
                            }

                            // Net Banking
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable { selectedPaymentMode = "NETBANK" }
                                    .padding(vertical = 4.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                RadioButton(
                                    selected = selectedPaymentMode == "NETBANK",
                                    onClick = { selectedPaymentMode = "NETBANK" },
                                    colors = RadioButtonDefaults.colors(selectedColor = SaffronGold)
                                )
                                Icon(Icons.Default.AccountBalance, contentDescription = null, tint = Navy900)
                                Spacer(modifier = Modifier.width(8.dp))
                                Column {
                                    Text(if (isHi) "नेट बैंकिंग (SBI, HDFC, ICICI, PNB)" else "Net Banking (SBI, HDFC, ICICI, PNB)", fontSize = 12.5.sp, fontWeight = FontWeight.SemiBold, color = Navy900)
                                    Text(if (isHi) "सभी प्रमुख भारतीय बैंक समर्थित" else "All Major Indian Banks Supported", fontSize = 10.5.sp, color = Color(0xFF64748B))
                                }
                            }
                        }
                    }
                }

                // Price Breakdown Bill Card
                item {
                    Spacer(modifier = Modifier.height(14.dp))
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White)
                    ) {
                        Column(modifier = Modifier.padding(14.dp)) {
                            Text(
                                text = if (isHi) "बिल विवरण (Price Breakdown):" else "Price Breakdown:",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = Navy900
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(if (isHi) "मूल एमआरपी (Total MRP)" else "Total MRP", fontSize = 12.sp, color = Color(0xFF64748B))
                                Text("₹$mrpTotal", fontSize = 12.sp, color = Color(0xFF64748B), textDecoration = TextDecoration.LineThrough)
                            }

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 4.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(if (isHi) "ई-बुक डिस्काउंट छूट" else "E-Book Discount", fontSize = 12.sp, color = EmeraldSuccess)
                                Text("-₹${mrpTotal - subTotal}", fontSize = 12.sp, color = EmeraldSuccess, fontWeight = FontWeight.Bold)
                            }

                            if (couponSavings > 0) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 4.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(if (isHi) "कूपन छूट (${uiState.appliedCoupon})" else "Coupon Discount (${uiState.appliedCoupon})", fontSize = 12.sp, color = SaffronGold)
                                    Text("-₹$couponSavings", fontSize = 12.sp, color = SaffronGold, fontWeight = FontWeight.Bold)
                                }
                            }

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 4.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(if (isHi) "जीएसटी कर (GST Taxes)" else "GST Taxes", fontSize = 12.sp, color = Color(0xFF64748B))
                                Text(if (isHi) "₹0 (शामिल)" else "₹0 (Included)", fontSize = 12.sp, color = Color(0xFF64748B))
                            }

                            Divider(modifier = Modifier.padding(vertical = 10.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(if (isHi) "अंतिम कुल देय राशि:" else "Final Payable Amount:", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Navy900)
                                Text("₹$finalAmount", fontSize = 18.sp, fontWeight = FontWeight.ExtraBold, color = Navy900)
                            }
                        }
                    }
                }
            }
        }
    }
}
