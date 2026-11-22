package com.example.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

/**
 * Entity to store E-Books and study documents uploaded by the Owner / Publisher.
 * Supports PDF file attachment URIs, page counts, pricing, and category mapping.
 */
@Entity(
    tableName = "ebook_documents",
    indices = [
        Index(value = ["exam_id"]),
        Index(value = ["subject_id"]),
        Index(value = ["uploaded_timestamp"])
    ]
)
data class EbookDocumentEntity(
    @PrimaryKey
    val id: String, // e.g. "doc_upsc_history_pdf"

    val title: String, // English Title

    @ColumnInfo(name = "hindi_title")
    val hindiTitle: String, // Hindi Title

    @ColumnInfo(name = "exam_id")
    val examId: String, // e.g. "upsc_cse"

    @ColumnInfo(name = "subject_id")
    val subjectId: String, // e.g. "upsc_history"

    @ColumnInfo(name = "sub_topic_id", defaultValue = "")
    val subTopicId: String = "",

    @ColumnInfo(name = "file_name")
    val fileName: String, // e.g. "Modern_History_Complete_Notes.pdf"

    @ColumnInfo(name = "file_uri")
    val fileUri: String = "", // File URI / Path from Android SAF File Picker

    @ColumnInfo(name = "file_size_formatted", defaultValue = "4.5 MB")
    val fileSizeFormatted: String = "4.5 MB",

    @ColumnInfo(name = "page_count", defaultValue = "140")
    val pageCount: Int = 140,

    @ColumnInfo(name = "original_price", defaultValue = "399")
    val originalPrice: Int = 399,

    @ColumnInfo(name = "discounted_price", defaultValue = "149")
    val discountedPrice: Int = 149,

    @ColumnInfo(name = "medium", defaultValue = "Bilingual (Hindi + English)")
    val medium: String = "Bilingual (Hindi + English)",

    @ColumnInfo(name = "edition", defaultValue = "2025-26 Edition")
    val edition: String = "2025-26 Edition",

    @ColumnInfo(name = "sample_content", defaultValue = "")
    val sampleContent: String = "",

    @ColumnInfo(name = "uploaded_timestamp")
    val uploadedTimestamp: Long = System.currentTimeMillis()
)
