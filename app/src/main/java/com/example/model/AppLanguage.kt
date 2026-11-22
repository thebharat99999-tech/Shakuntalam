package com.example.model

enum class AppLanguage(val code: String, val displayName: String, val nativeName: String) {
    HINDI("hi", "Hindi", "हिंदी"),
    ENGLISH("en", "English", "English")
}

data class PaymentGatewayInfo(
    val merchantName: String = "SHAKUNTALAM PUBLISHERS PVT LTD",
    val orderId: String = "SHAK_ORD_${System.currentTimeMillis() % 1000000}",
    val totalAmount: Int,
    val itemsSummary: String,
    val customerName: String = "",
    val customerEmail: String = "",
    val customerPhone: String = "",
    val selectedMethod: PaymentMethodType = PaymentMethodType.UPI,
    val isProcessing: Boolean = false,
    val isSuccess: Boolean = false,
    val transactionRef: String = ""
)

enum class PaymentMethodType(val labelEn: String, val labelHi: String) {
    UPI("Instant UPI (GPay / PhonePe / Paytm / QR)", "त्वरित यूपीआई (GPay, PhonePe, Paytm, QR)"),
    CARD("Debit / Credit Card (RuPay, Visa, Master)", "डेबिट / क्रेडिट कार्ड (RuPay, Visa, Master)"),
    NET_BANKING("Net Banking (SBI, HDFC, ICICI, Axis)", "नेट बैंकिंग (SBI, HDFC, ICICI, Axis)"),
    WALLET("Wallets (Paytm / Mobikwik / Amazon Pay)", "वॉलेट्स (Paytm, Mobikwik, Amazon Pay)")
}

data class PaymentReceipt(
    val transactionId: String,
    val orderId: String,
    val amountPaid: Int,
    val paymentMode: String,
    val timestampFormatted: String,
    val itemsPurchased: List<String>
)
