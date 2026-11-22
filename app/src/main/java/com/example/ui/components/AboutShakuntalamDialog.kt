package com.example.ui.components

import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.SupportAgent
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.EmeraldSuccess
import com.example.ui.theme.Navy100
import com.example.ui.theme.Navy900
import com.example.ui.theme.SaffronGold

@Composable
fun AboutShakuntalamDialog(
    language: com.example.model.AppLanguage = com.example.model.AppLanguage.ENGLISH,
    onDismiss: () -> Unit
) {
    val isHi = language == com.example.model.AppLanguage.HINDI
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                ShakuntalamBrandCrestBadge(
                    size = 42.dp,
                    showGlowRing = true
                )
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(
                        text = "SHAKUNTALAM • शकुंतलम",
                        fontSize = 15.5.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Navy900
                    )
                    Text(
                        text = "E-BOOKS & TEST SERIES PLATFORM",
                        fontSize = 10.5.sp,
                        color = SaffronGold,
                        fontWeight = FontWeight.ExtraBold,
                        letterSpacing = 0.5.sp
                    )
                }
            }
        },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                ShakuntalamOfficialLogoShowcaseCard(height = 125.dp)

                Text(
                    text = if (isHi) {
                        "शकुंतलम भारत के सभी प्रतियोगी परीक्षाओं (UPSC, State PSCs, UPSSSC, SSC, Railway, Banking, Teaching, NEET, JEE, CBSE 9th-12th, CCC, AI & ML, UGC NET) के अभ्यर्थियों के लिए समर्पित एक प्रमुख डिजिटल प्रकाशन संस्थान है।"
                    } else {
                        "Shakuntalam is a premier multi-platform digital publishing & CBT Test Series platform dedicated to aspirants of UPSC, State PSCs, SSC, Banking, Railways, Defence, NEET, JEE, CBSE 9th-12th, and UGC NET."
                    },
                    fontSize = 12.5.sp,
                    color = Color(0xFF334155),
                    lineHeight = 18.sp
                )

                Card(
                    shape = RoundedCornerShape(8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFF1F5F9))
                ) {
                    Column(modifier = Modifier.padding(10.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.Verified, contentDescription = null, tint = EmeraldSuccess, modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = if (isHi) "100% नवीनतम पाठ्यक्रम एवं 256-बिट सुरक्षा" else "Updated Syllabus • 256-Bit SHA-256 Security",
                                fontSize = 11.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = Navy900
                            )
                        }
                        Text(
                            text = if (isHi) "• अनुभवी सिविल सेवकों, टॉपर्स एवं विषय विशेषज्ञों द्वारा संकलित।" else "• Curated by civil servants, exam toppers & subject experts.",
                            fontSize = 11.sp,
                            color = Color(0xFF475569)
                        )
                        Text(
                            text = if (isHi) "• प्रत्येक अध्याय में माइंड मैप्स, शॉर्ट ट्रिक्स एवं हल प्रश्न।" else "• DRM-protected high-resolution PDFs with offline reading.",
                            fontSize = 11.sp,
                            color = Color(0xFF475569)
                        )
                        Text(
                            text = if (isHi) "• ऑल इंडिया सीबीटी टेस्ट सीरीज़ तुरंत स्कोरकार्ड के साथ।" else "• Cross-platform compatible across Android, Tablet & Web.",
                            fontSize = 11.sp,
                            color = Color(0xFF475569)
                        )
                    }
                }

                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Email, contentDescription = null, tint = SaffronGold, modifier = Modifier.size(14.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("support@shakuntalambooks.com", fontSize = 11.sp, color = Color(0xFF475569))
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Phone, contentDescription = null, tint = SaffronGold, modifier = Modifier.size(14.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("Helpline / UPI Support: +91 6396817525", fontSize = 11.sp, color = Color(0xFF475569))
                    }
                }
            }
        },
        confirmButton = {
            Button(
                onClick = onDismiss,
                colors = ButtonDefaults.buttonColors(containerColor = Navy900),
                modifier = Modifier.testTag("about_dialog_close")
            ) {
                Text(if (isHi) "बंद करें" else "Close", color = Color.White)
            }
        }
    )
}
