package com.example.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.data.local.entity.ExamEntity
import com.example.data.local.entity.ExamWithSubjects
import com.example.data.local.entity.ExamWithSubjectsAndSubTopics
import com.example.data.local.entity.SubTopicEntity
import com.example.data.local.entity.SubjectEntity
import com.example.data.local.entity.SubjectWithSubTopics
import kotlinx.coroutines.flow.Flow

@Dao
interface ExamHierarchyDao {

    // ==========================================
    // EXAM QUERIES & INSERTS
    // ==========================================

    @Query("SELECT * FROM exams ORDER BY order_index ASC, name ASC")
    fun getAllExamsFlow(): Flow<List<ExamEntity>>

    @Query("SELECT * FROM exams WHERE category_group = :group ORDER BY order_index ASC")
    fun getExamsByCategoryGroupFlow(group: String): Flow<List<ExamEntity>>

    @Query("SELECT * FROM exams WHERE id = :examId LIMIT 1")
    fun getExamByIdFlow(examId: String): Flow<ExamEntity?>

    @Query("SELECT COUNT(*) FROM exams")
    suspend fun getExamCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExam(exam: ExamEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExams(exams: List<ExamEntity>)

    @Update
    suspend fun updateExam(exam: ExamEntity)

    @Query("DELETE FROM exams WHERE id = :examId")
    suspend fun deleteExamById(examId: String)

    // ==========================================
    // SUBJECT QUERIES & INSERTS
    // ==========================================

    @Query("SELECT * FROM subjects WHERE exam_id = :examId ORDER BY order_index ASC")
    fun getSubjectsForExamFlow(examId: String): Flow<List<SubjectEntity>>

    @Query("SELECT * FROM subjects WHERE exam_id = :examId AND stage_or_tier = :stage ORDER BY order_index ASC")
    fun getSubjectsByStageFlow(examId: String, stage: String): Flow<List<SubjectEntity>>

    @Query("SELECT * FROM subjects WHERE id = :subjectId LIMIT 1")
    fun getSubjectByIdFlow(subjectId: String): Flow<SubjectEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubject(subject: SubjectEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubjects(subjects: List<SubjectEntity>)

    @Query("DELETE FROM subjects WHERE id = :subjectId")
    suspend fun deleteSubjectById(subjectId: String)

    // ==========================================
    // SUB-TOPIC QUERIES & INSERTS
    // ==========================================

    @Query("SELECT * FROM sub_topics WHERE subject_id = :subjectId ORDER BY order_index ASC")
    fun getSubTopicsForSubjectFlow(subjectId: String): Flow<List<SubTopicEntity>>

    @Query("SELECT * FROM sub_topics WHERE id = :subTopicId LIMIT 1")
    fun getSubTopicByIdFlow(subTopicId: String): Flow<SubTopicEntity?>

    @Query("SELECT * FROM sub_topics WHERE name LIKE '%' || :query || '%' OR hindi_name LIKE '%' || :query || '%'")
    fun searchSubTopicsFlow(query: String): Flow<List<SubTopicEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubTopic(subTopic: SubTopicEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubTopics(subTopics: List<SubTopicEntity>)

    @Query("DELETE FROM sub_topics WHERE id = :subTopicId")
    suspend fun deleteSubTopicById(subTopicId: String)

    // ==========================================
    // RELATIONAL TRANSACTIONS (Hierarchy joins)
    // ==========================================

    /**
     * Get a single Subject along with its ordered Sub-topics (Level 2 -> Level 3)
     */
    @Transaction
    @Query("SELECT * FROM subjects WHERE id = :subjectId")
    fun getSubjectWithSubTopicsFlow(subjectId: String): Flow<SubjectWithSubTopics?>

    /**
     * Get an Exam with all its Subjects (Level 1 -> Level 2)
     */
    @Transaction
    @Query("SELECT * FROM exams WHERE id = :examId")
    fun getExamWithSubjectsFlow(examId: String): Flow<ExamWithSubjects?>

    /**
     * Get Complete 3-Tier Hierarchy for a specific Exam:
     * Exam -> All Subjects -> All SubTopics
     */
    @Transaction
    @Query("SELECT * FROM exams WHERE id = :examId")
    fun getExamHierarchyFlow(examId: String): Flow<ExamWithSubjectsAndSubTopics?>

    /**
     * Get Complete 3-Tier Hierarchy for ALL Exams
     */
    @Transaction
    @Query("SELECT * FROM exams ORDER BY order_index ASC")
    fun getAllExamHierarchiesFlow(): Flow<List<ExamWithSubjectsAndSubTopics>>
}
