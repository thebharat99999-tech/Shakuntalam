package com.example.ui.components

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Shop
import androidx.compose.material.icons.filled.Web
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.AppLanguage
import com.example.ui.theme.EmeraldSuccess
import com.example.ui.theme.Navy800
import com.example.ui.theme.Navy900
import com.example.ui.theme.SaffronGold

@Composable
fun DownloadAndUploadModal(
    isOpen: Boolean,
    language: AppLanguage,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    if (!isOpen) return

    val context = LocalContext.current
    val isHi = language == AppLanguage.HINDI
    var copiedPublic by remember { mutableStateOf(false) }

    val publicUrl = "https://ais-pre-vas55hsj73jwmdyfhkr6bm-322363834967.asia-southeast1.run.app"
    val devUrl = "https://ais-dev-vas55hsj73jwmdyfhkr6bm-322363834967.asia-southeast1.run.app"

    fun copyToClipboard(text: String, label: String) {
        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText(label, text)
        clipboard.setPrimaryClip(clip)
        copiedPublic = true
        Toast.makeText(context, if (isHi) "लिंक कॉपी हो गया!" else "Link copied to clipboard!", Toast.LENGTH_SHORT).show()
    }

    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {},
        modifier = modifier.testTag("download_upload_modal_dialog"),
        shape = RoundedCornerShape(20.dp),
        containerColor = Color.White,
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(36.dp)
                            .clip(CircleShape)
                            .background(Navy900),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Public,
                            contentDescription = null,
                            tint = SaffronGold,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        Text(
                            text = if (isHi) "वेबसाइट एवं ऐप डाउनलोड सेंटर" else "Live Website & App Downloads",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Navy900
                        )
                        Text(
                            text = if (isHi) "गूगल पर अपलोड व शेयर करने हेतु" else "Ready links for Google & Web",
                            fontSize = 11.sp,
                            color = Color(0xFF64748B)
                        )
                    }
                }

                IconButton(onClick = onDismiss, modifier = Modifier.size(32.dp)) {
                    Icon(Icons.Default.Close, contentDescription = "Close", tint = Color(0xFF64748B))
                }
            }
        },
        text = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
            ) {
                // Section 1: Live Public Website Link
                Text(
                    text = if (isHi) "1. लाइव वेबसाइट लिंक (Public Web URL)" else "1. Live Web Application Link",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = Navy900
                )
                Spacer(modifier = Modifier.height(6.dp))

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFF1F5F9)),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Column(modifier = Modifier.padding(10.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.Web, contentDescription = null, tint = Color(0xFF2563EB), modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = if (isHi) "पब्लिक शेयर लिंक:" else "Public Shareable Link:",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Navy900
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(6.dp))
                                .background(Color.White)
                                .border(1.dp, Color(0xFFCBD5E1), RoundedCornerShape(6.dp))
                                .padding(8.dp)
                        ) {
                            Text(
                                text = publicUrl,
                                fontSize = 11.sp,
                                color = Color(0xFF1E293B),
                                fontWeight = FontWeight.Medium
                            )
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        Button(
                            onClick = { copyToClipboard(publicUrl, "Shakuntalam Public URL") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(38.dp)
                                .testTag("btn_copy_public_url"),
                            colors = ButtonDefaults.buttonColors(containerColor = if (copiedPublic) EmeraldSuccess else Navy900),
                            shape = RoundedCornerShape(6.dp)
                        ) {
                            Icon(
                                imageVector = if (copiedPublic) Icons.Default.Check else Icons.Default.ContentCopy,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(14.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = if (copiedPublic)
                                    (if (isHi) "कॉपी हो गया! (Copied)" else "Copied!")
                                else
                                    (if (isHi) "वेबसाइट लिंक कॉपी करें (Copy Link)" else "Copy Website Link"),
                                fontSize = 11.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Testbook Partner / Reference Link Card
                val testbookPartnerUrl = "https://link.testbook.com/SkJ0aQI06zb?tbreferrer=SWTKLD"
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("testbook_reference_link_card"),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF081C38)),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Column(modifier = Modifier.padding(10.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            ShakuntalamBrandCrestBadge(size = 20.dp, showGlowRing = true)
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = if (isHi)
                                    "टेस्टबुक रेफरल एवं टेस्ट सीरीज़ लिंक (Code: SWTKLD)"
                                else
                                    "Testbook Pass & Referral Link (Code: SWTKLD)",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = SaffronGold
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = testbookPartnerUrl,
                            fontSize = 10.5.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Medium
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Button(
                            onClick = { copyToClipboard(testbookPartnerUrl, "Testbook Referral Link") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(34.dp)
                                .testTag("btn_copy_testbook_url"),
                            colors = ButtonDefaults.buttonColors(containerColor = SaffronGold),
                            shape = RoundedCornerShape(6.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.ContentCopy,
                                contentDescription = null,
                                tint = Navy900,
                                modifier = Modifier.size(13.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = if (isHi) "टेस्टबुक लिंक कॉपी करें (Code: SWTKLD)" else "Copy Testbook Link (Code: SWTKLD)",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Navy900
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))

                // Section 2: Instructions for Google (Play Store & Web)
                Text(
                    text = if (isHi) "2. इसे गूगल (Google) पर कैसे अपलोड करें?" else "2. How to Upload on Google",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = Navy900
                )
                Spacer(modifier = Modifier.height(6.dp))

                // Step 1: AI Studio Settings Download
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFBEB)),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Column(modifier = Modifier.padding(10.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .size(20.dp)
                                    .clip(CircleShape)
                                    .background(SaffronGold),
                                contentAlignment = Alignment.Center
                            ) {
                                Text("1", color = Navy900, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = if (isHi) "AI Studio सेटिंग्स से APK / AAB डाउनलोड करें" else "Download APK / AAB from AI Studio Settings",
                                fontSize = 11.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = Navy900
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = if (isHi)
                                "AI Studio के ऊपरी दाएं कोने में Settings (⚙️) आइकन पर क्लिक करें।\n• 'Download APK' चुनकर सीधे फ़ोन में इंस्टॉल करें।\n• 'Generate AAB' चुनकर Google Play Store फ़ाइल पाएं।"
                            else
                                "Click the Settings (⚙️) menu in the top-right corner of AI Studio.\n• Select 'Download APK' for direct phone install.\n• Select 'Generate AAB' for Google Play Store upload.",
                            fontSize = 10.5.sp,
                            color = Color(0xFF451A03),
                            lineHeight = 15.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Step 2: Google Play Console
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFF0FDF4)),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Column(modifier = Modifier.padding(10.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .size(20.dp)
                                    .clip(CircleShape)
                                    .background(EmeraldSuccess),
                                contentAlignment = Alignment.Center
                            ) {
                                Text("2", color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = if (isHi) "Google Play Console पर पब्लिश करें" else "Upload to Google Play Console",
                                fontSize = 11.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = Navy900
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = if (isHi)
                                "1. play.google.com/console खोलें।\n2. 'Create App' -> नाम 'Shakuntalam' रखें।\n3. डाउनलोड की गई .AAB फ़ाइल को Production / Testing ट्रैक में अपलोड करें।"
                            else
                                "1. Open play.google.com/console.\n2. Create App named 'Shakuntalam'.\n3. Upload the downloaded .AAB file in Production / Internal Testing track.",
                            fontSize = 10.5.sp,
                            color = Color(0xFF064E3B),
                            lineHeight = 15.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Step 3: Google Drive & Web Hosting
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFF8FAFC)),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Column(modifier = Modifier.padding(10.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .size(20.dp)
                                    .clip(CircleShape)
                                    .background(Color(0xFF64748B)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text("3", color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = if (isHi) "गूगल ड्राइव या वेब डोमेन पर होस्टिंग" else "Google Drive or Custom Domain",
                                fontSize = 11.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = Navy900
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = if (isHi)
                                "वेबसाइट को किसी भी कस्टम डोमेन (जैसे shakuntalam.in) या Firebase / Cloud Run पर होस्ट करने के लिए AI Studio से 'Export as ZIP' या 'Push to GitHub' का उपयोग करें।"
                            else
                                "Use 'Export as ZIP' or 'Push to GitHub' from AI Studio to deploy this web platform to Firebase Hosting, Cloud Run, or your custom domain (e.g. shakuntalam.in).",
                            fontSize = 10.5.sp,
                            color = Color(0xFF334155),
                            lineHeight = 15.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))

                Button(
                    onClick = onDismiss,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(42.dp)
                        .testTag("btn_close_download_modal"),
                    colors = ButtonDefaults.buttonColors(containerColor = SaffronGold),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = if (isHi) "ठीक है, समझ गया (Got It)" else "Done",
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                        color = Navy900
                    )
                }
            }
        }
    )
}
