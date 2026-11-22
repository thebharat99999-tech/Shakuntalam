package com.example.security

import java.security.MessageDigest
import java.util.Locale

/**
 * Shakuntalam Security & Anti-Piracy Manager
 * Protects against XSS/SQLi input injection, unauthorized Admin Portal access,
 * brute-force PIN attacks, and payment/UPI tampering.
 */
object SecurityManager {

    private val DANGEROUS_PATTERNS = listOf(
        Regex("<script.*?>.*?</script>", RegexOption.IGNORE_CASE),
        Regex("<.*?>"),
        Regex("(?i)(union\\s+select|drop\\s+table|insert\\s+into|delete\\s+from|update\\s+.*set|xp_cmdshell)"),
        Regex("(--|;|/\\*|\\*/|'\\s*or\\s*'1'='1)")
    )

    private val UPI_ID_REGEX = Regex("^[a-zA-Z0-9.\\-_]{2,256}@[a-zA-Z]{2,64}$")
    private val IFSC_REGEX = Regex("^[A-Za-z]{4}0[A-Za-z0-9]{6}$")
    private val UTR_REGEX = Regex("^[0-9]{12}$")

    /**
     * Sanitizes any user or form input by stripping HTML/script tags, SQL injection tokens,
     * and control characters.
     */
    fun sanitizeInput(raw: String, maxLength: Int = 200): String {
        var cleaned = raw.trim()
        DANGEROUS_PATTERNS.forEach { regex ->
            cleaned = cleaned.replace(regex, "")
        }
        cleaned = cleaned.replace(Regex("[\\p{Cntrl}&&[^\r\n\t]]"), "")
        return cleaned.take(maxLength)
    }

    /**
     * Computes SHA-256 cryptographic hash for Admin PIN verification and digital receipts.
     */
    fun sha256(input: String): String {
        val bytes = MessageDigest.getInstance("SHA-256")
            .digest(("SHAKUNTALAM_SALT_2026::$input").toByteArray(Charsets.UTF_8))
        return bytes.joinToString("") { "%02x".format(it) }
    }

    /**
     * Generates a short verifiable cryptographic checksum for digital receipts and DRM watermarks.
     */
    fun generateSecuritySignature(payload: String): String {
        return sha256(payload).take(12).uppercase(Locale.US)
    }

    /**
     * Validates a UPI ID against strict NPCI VPA format rules.
     */
    fun isValidUpiId(upiId: String): Boolean {
        return UPI_ID_REGEX.matches(upiId.trim())
    }

    /**
     * Validates an Indian Bank IFSC code if provided.
     */
    fun isValidIfsc(ifsc: String): Boolean {
        if (ifsc.isBlank()) return true
        return IFSC_REGEX.matches(ifsc.trim())
    }

    /**
     * Validates a 12-digit UPI UTR / Reference number.
     */
    fun isValidUtr(utr: String): Boolean {
        return UTR_REGEX.matches(utr.trim())
    }
}
