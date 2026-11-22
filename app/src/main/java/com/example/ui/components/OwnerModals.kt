package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.CurrencyRupee
import androidx.compose.material.icons.filled.Help
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.Sell
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
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
import com.example.model.TestQuestion
import com.example.ui.theme.EmeraldSuccess
import com.example.ui.theme.Navy800
import com.example.ui.theme.Navy900
import com.example.ui.theme.SaffronGold

/**
 * Dialog for the Owner to edit selling and original price of any E-Book or document.
 */
@Composable
fun EditPriceModal(
    isHi: Boolean,
    itemTitle: String,
    currentOriginalPrice: Int,
    currentDiscountedPrice: Int,
    onDismiss: () -> Unit,
    onSavePrice: (originalPrice: Int, discountedPrice: Int) -> Unit
) {
    var origPriceStr by remember { mutableStateOf(currentOriginalPrice.toString()) }
    var discPriceStr by remember { mutableStateOf(currentDiscountedPrice.toString()) }
    var errorMsg by remember { mutableStateOf<String?>(null) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Sell,
                    contentDescription = null,
                    tint = SaffronGold,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text(
                        text = if (isHi) "ई-बुक की कीमत बदलें (Edit Price)" else "Edit E-Book Price",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Navy900
                    )
                    Text(
                        text = itemTitle,
                        fontSize = 11.sp,
                        color = Color(0xFF64748B),
                        maxLines = 1
                    )
                }
            }
        },
        text = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = if (isHi)
                        "आप अपनी सुविधानुसार कभी भी किसी भी दस्तावेज़ की कीमत घटा या बढ़ा सकते हैं:"
                    else
                        "Adjust the original MRP and discounted selling price instantly:",
                    fontSize = 11.5.sp,
                    color = Color(0xFF475569)
                )

                // Discounted Selling Price
                OutlinedTextField(
                    value = discPriceStr,
                    onValueChange = {
                        discPriceStr = it.filter { ch -> ch.isDigit() }
                        errorMsg = null
                    },
                    label = { Text(if (isHi) "विक्रय मूल्य / सेलिंग प्राइस (₹)" else "Selling Price / Cost (₹)") },
                    leadingIcon = { Icon(Icons.Default.CurrencyRupee, contentDescription = null, tint = EmeraldSuccess, modifier = Modifier.size(16.dp)) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth().testTag("input_edit_discounted_price"),
                    colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = EmeraldSuccess)
                )

                // Original Price (MRP)
                OutlinedTextField(
                    value = origPriceStr,
                    onValueChange = {
                        origPriceStr = it.filter { ch -> ch.isDigit() }
                        errorMsg = null
                    },
                    label = { Text(if (isHi) "मूल एमआरपी / प्रिंट रेट (₹)" else "Original Price / MRP (₹)") },
                    leadingIcon = { Icon(Icons.Default.CurrencyRupee, contentDescription = null, tint = Color(0xFF64748B), modifier = Modifier.size(16.dp)) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth().testTag("input_edit_original_price"),
                    colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = SaffronGold)
                )

                val discountPercent = remember(discPriceStr, origPriceStr) {
                    val orig = origPriceStr.toIntOrNull() ?: 1
                    val disc = discPriceStr.toIntOrNull() ?: 0
                    if (orig > disc && orig > 0) {
                        ((orig - disc) * 100) / orig
                    } else 0
                }

                if (discountPercent > 0) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(6.dp))
                            .background(Color(0xFFECFDF5))
                            .padding(8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = if (isHi) "छात्रों को दिखाई देने वाली छूट: $discountPercent% OFF" else "Student Discount Display: $discountPercent% OFF",
                            fontSize = 11.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = EmeraldSuccess
                        )
                    }
                }

                if (errorMsg != null) {
                    Text(text = errorMsg!!, color = Color(0xFFDC2626), fontSize = 11.sp)
                }
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    val orig = origPriceStr.toIntOrNull()
                    val disc = discPriceStr.toIntOrNull()
                    if (disc == null || disc < 0) {
                        errorMsg = if (isHi) "कृपया मान्य विक्रय मूल्य दर्ज करें" else "Please enter a valid selling price"
                        return@Button
                    }
                    val finalOrig = if (orig == null || orig < disc) disc else orig
                    onSavePrice(finalOrig, disc)
                },
                colors = ButtonDefaults.buttonColors(containerColor = SaffronGold),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.testTag("btn_save_price")
            ) {
                Text(
                    text = if (isHi) "कीमत सहेजें (Save)" else "Save New Price",
                    color = Navy900,
                    fontWeight = FontWeight.Bold
                )
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(if (isHi) "रद्द करें" else "Cancel", color = Color(0xFF64748B))
            }
        }
    )
}

/**
 * Dialog for the Owner to create a new online Mock Test.
 */
@Composable
fun CreateTestModal(
    isHi: Boolean,
    onDismiss: () -> Unit,
    onConfirmCreate: (
        title: String,
        hindiTitle: String,
        examName: String,
        durationMinutes: Int,
        totalMarks: Int,
        positiveMarks: Double,
        negativeMarks: Double
    ) -> Unit
) {
    var title by remember { mutableStateOf("UPSC Prelims Full Mock Test 2026") }
    var hindiTitle by remember { mutableStateOf("यूपीएससी प्रारंभिक परीक्षा संपूर्ण मॉक टेस्ट 2026") }
    var examName by remember { mutableStateOf("UPSC Civil Services") }
    var durationStr by remember { mutableStateOf("30") }
    var marksStr by remember { mutableStateOf("50") }
    var posMarksStr by remember { mutableStateOf("2.0") }
    var negMarksStr by remember { mutableStateOf("0.66") }
    var errorMsg by remember { mutableStateOf<String?>(null) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Quiz, contentDescription = null, tint = SaffronGold, modifier = Modifier.size(22.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = if (isHi) "नया ऑनलाइन टेस्ट बनाएं" else "Create New Online Test",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Navy900
                )
            }
        },
        text = {
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item {
                    OutlinedTextField(
                        value = title,
                        onValueChange = { title = it },
                        label = { Text("Test Title (English)") },
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                item {
                    OutlinedTextField(
                        value = hindiTitle,
                        onValueChange = { hindiTitle = it },
                        label = { Text("टेस्ट शीर्षक (हिंदी)") },
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                item {
                    OutlinedTextField(
                        value = examName,
                        onValueChange = { examName = it },
                        label = { Text(if (isHi) "परीक्षा वर्ग (Exam Category)" else "Exam Name") },
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        OutlinedTextField(
                            value = durationStr,
                            onValueChange = { durationStr = it },
                            label = { Text(if (isHi) "अवधि (मिनट)" else "Duration (Mins)") },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            modifier = Modifier.weight(1f)
                        )
                        OutlinedTextField(
                            value = marksStr,
                            onValueChange = { marksStr = it },
                            label = { Text(if (isHi) "कुल अंक" else "Total Marks") },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            modifier = Modifier.weight(1f)
                        )
                    }
                }

                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        OutlinedTextField(
                            value = posMarksStr,
                            onValueChange = { posMarksStr = it },
                            label = { Text(if (isHi) "सही अंक (+)" else "+ Marks") },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                            modifier = Modifier.weight(1f)
                        )
                        OutlinedTextField(
                            value = negMarksStr,
                            onValueChange = { negMarksStr = it },
                            label = { Text(if (isHi) "नेगेटिव अंक (-)" else "- Marks") },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                            modifier = Modifier.weight(1f)
                        )
                    }
                }

                if (errorMsg != null) {
                    item {
                        Text(text = errorMsg!!, color = Color(0xFFDC2626), fontSize = 11.sp)
                    }
                }
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    if (title.isBlank() || hindiTitle.isBlank()) {
                        errorMsg = "Please enter both English and Hindi titles."
                        return@Button
                    }
                    val duration = durationStr.toIntOrNull() ?: 30
                    val marks = marksStr.toIntOrNull() ?: 50
                    val pos = posMarksStr.toDoubleOrNull() ?: 2.0
                    val neg = negMarksStr.toDoubleOrNull() ?: 0.5
                    onConfirmCreate(title, hindiTitle, examName, duration, marks, pos, neg)
                },
                colors = ButtonDefaults.buttonColors(containerColor = SaffronGold)
            ) {
                Text(if (isHi) "टेस्ट प्रकाशित करें (Publish)" else "Publish Test", color = Navy900, fontWeight = FontWeight.Bold)
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(if (isHi) "रद्द करें" else "Cancel")
            }
        }
    )
}

/**
 * Dialog for the Owner to add a Question and detailed Solution to an Online Test.
 */
@Composable
fun AddQuestionModal(
    isHi: Boolean,
    testTitle: String,
    onDismiss: () -> Unit,
    onConfirmAdd: (TestQuestion) -> Unit
) {
    var qEn by remember { mutableStateOf("") }
    var qHi by remember { mutableStateOf("") }
    var opt1En by remember { mutableStateOf("") }
    var opt2En by remember { mutableStateOf("") }
    var opt3En by remember { mutableStateOf("") }
    var opt4En by remember { mutableStateOf("") }
    var opt1Hi by remember { mutableStateOf("") }
    var opt2Hi by remember { mutableStateOf("") }
    var opt3Hi by remember { mutableStateOf("") }
    var opt4Hi by remember { mutableStateOf("") }
    var correctIndex by remember { mutableStateOf(0) }
    var solEn by remember { mutableStateOf("") }
    var solHi by remember { mutableStateOf("") }
    var subject by remember { mutableStateOf("General Studies") }
    var errorMsg by remember { mutableStateOf<String?>(null) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Lightbulb, contentDescription = null, tint = SaffronGold, modifier = Modifier.size(20.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text(
                        text = if (isHi) "प्रश्न व समाधान जोड़ें (Add Question)" else "Add Question & Solution",
                        fontSize = 15.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = Navy900
                    )
                    Text(text = testTitle, fontSize = 11.sp, color = Color(0xFF64748B), maxLines = 1)
                }
            }
        },
        text = {
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item {
                    OutlinedTextField(
                        value = qEn,
                        onValueChange = { qEn = it },
                        label = { Text("Question (English)") },
                        modifier = Modifier.fillMaxWidth(),
                        minLines = 2
                    )
                }

                item {
                    OutlinedTextField(
                        value = qHi,
                        onValueChange = { qHi = it },
                        label = { Text("प्रश्न (हिंदी)") },
                        modifier = Modifier.fillMaxWidth(),
                        minLines = 2
                    )
                }

                item {
                    Text(
                        text = if (isHi) "4 विकल्प एवं सही उत्तर चुनें:" else "4 Options (Select radio for correct answer):",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Navy900
                    )
                }

                // Option 1
                item {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = correctIndex == 0,
                            onClick = { correctIndex = 0 },
                            colors = RadioButtonDefaults.colors(selectedColor = EmeraldSuccess)
                        )
                        OutlinedTextField(
                            value = opt1En,
                            onValueChange = { opt1En = it },
                            label = { Text("Option 1 (English / Hindi)") },
                            modifier = Modifier.weight(1f)
                        )
                    }
                }

                // Option 2
                item {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = correctIndex == 1,
                            onClick = { correctIndex = 1 },
                            colors = RadioButtonDefaults.colors(selectedColor = EmeraldSuccess)
                        )
                        OutlinedTextField(
                            value = opt2En,
                            onValueChange = { opt2En = it },
                            label = { Text("Option 2 (English / Hindi)") },
                            modifier = Modifier.weight(1f)
                        )
                    }
                }

                // Option 3
                item {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = correctIndex == 2,
                            onClick = { correctIndex = 2 },
                            colors = RadioButtonDefaults.colors(selectedColor = EmeraldSuccess)
                        )
                        OutlinedTextField(
                            value = opt3En,
                            onValueChange = { opt3En = it },
                            label = { Text("Option 3 (English / Hindi)") },
                            modifier = Modifier.weight(1f)
                        )
                    }
                }

                // Option 4
                item {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = correctIndex == 3,
                            onClick = { correctIndex = 3 },
                            colors = RadioButtonDefaults.colors(selectedColor = EmeraldSuccess)
                        )
                        OutlinedTextField(
                            value = opt4En,
                            onValueChange = { opt4En = it },
                            label = { Text("Option 4 (English / Hindi)") },
                            modifier = Modifier.weight(1f)
                        )
                    }
                }

                // Solution / Explanation
                item {
                    OutlinedTextField(
                        value = solEn,
                        onValueChange = { solEn = it },
                        label = { Text(if (isHi) "समाधान / व्याख्या (Solution English)" else "Explanation / Solution (English)") },
                        modifier = Modifier.fillMaxWidth(),
                        minLines = 2
                    )
                }

                item {
                    OutlinedTextField(
                        value = solHi,
                        onValueChange = { solHi = it },
                        label = { Text(if (isHi) "विस्तृत समाधान (हिंदी व्याख्या)" else "Explanation / Solution (Hindi)") },
                        modifier = Modifier.fillMaxWidth(),
                        minLines = 2
                    )
                }

                if (errorMsg != null) {
                    item {
                        Text(text = errorMsg!!, color = Color(0xFFDC2626), fontSize = 11.sp)
                    }
                }
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    if (qEn.isBlank() && qHi.isBlank()) {
                        errorMsg = "Please enter question text."
                        return@Button
                    }
                    if (opt1En.isBlank() || opt2En.isBlank()) {
                        errorMsg = "Please enter at least options 1 and 2."
                        return@Button
                    }
                    val finalOpt3 = opt3En.ifBlank { "None of the above" }
                    val finalOpt4 = opt4En.ifBlank { "All of the above" }
                    val newQ = TestQuestion(
                        id = System.currentTimeMillis().toInt(),
                        questionEn = qEn.ifBlank { qHi },
                        questionHi = qHi.ifBlank { qEn },
                        optionsEn = listOf(opt1En, opt2En, finalOpt3, finalOpt4),
                        optionsHi = listOf(opt1Hi.ifBlank { opt1En }, opt2Hi.ifBlank { opt2En }, finalOpt3, finalOpt4),
                        correctIndex = correctIndex,
                        explanationEn = solEn.ifBlank { "Correct option is Option ${correctIndex + 1}." },
                        explanationHi = solHi.ifBlank { "सही उत्तर विकल्प ${correctIndex + 1} है।" },
                        subject = subject
                    )
                    onConfirmAdd(newQ)
                },
                colors = ButtonDefaults.buttonColors(containerColor = SaffronGold)
            ) {
                Text(if (isHi) "प्रश्न जोड़ें (Save)" else "Save Question", color = Navy900, fontWeight = FontWeight.Bold)
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(if (isHi) "रद्द करें" else "Cancel")
            }
        }
    )
}
