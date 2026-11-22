package com.example.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.local.entity.EbookDocumentEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface EbookDocumentDao {

    @Query("SELECT * FROM ebook_documents ORDER BY uploaded_timestamp DESC")
    fun getAllDocumentsFlow(): Flow<List<EbookDocumentEntity>>

    @Query("SELECT * FROM ebook_documents WHERE exam_id = :examId ORDER BY uploaded_timestamp DESC")
    fun getDocumentsByExamFlow(examId: String): Flow<List<EbookDocumentEntity>>

    @Query("SELECT * FROM ebook_documents WHERE subject_id = :subjectId ORDER BY uploaded_timestamp DESC")
    fun getDocumentsBySubjectFlow(subjectId: String): Flow<List<EbookDocumentEntity>>

    @Query("SELECT * FROM ebook_documents WHERE id = :docId LIMIT 1")
    fun getDocumentByIdFlow(docId: String): Flow<EbookDocumentEntity?>

    @Query("SELECT COUNT(*) FROM ebook_documents")
    suspend fun getDocumentCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDocument(document: EbookDocumentEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDocuments(documents: List<EbookDocumentEntity>)

    @Query("UPDATE ebook_documents SET original_price = :originalPrice, discounted_price = :discountedPrice WHERE id = :docId")
    suspend fun updateDocumentPrices(docId: String, originalPrice: Int, discountedPrice: Int)

    @Query("DELETE FROM ebook_documents WHERE id = :docId")
    suspend fun deleteDocumentById(docId: String)
}
