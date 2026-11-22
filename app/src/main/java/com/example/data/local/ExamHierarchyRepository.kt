package com.example.data.local

import com.example.data.local.dao.EbookDocumentDao
import com.example.data.local.dao.ExamHierarchyDao
import com.example.data.local.dao.OfflineCacheDao
import com.example.data.local.entity.EbookDocumentEntity
import com.example.data.local.entity.ExamEntity
import com.example.data.local.entity.ExamWithSubjects
import com.example.data.local.entity.ExamWithSubjectsAndSubTopics
import com.example.data.local.entity.OfflineEbookCacheEntity
import com.example.data.local.entity.OfflineTestCacheEntity
import com.example.data.local.entity.SubTopicEntity
import com.example.data.local.entity.SubjectEntity
import com.example.data.local.entity.SubjectWithSubTopics
import com.example.model.MockTest
import com.example.model.StudyItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

/**
 * Repository pattern implementation for Shakuntalam Exam Hierarchy, E-Book Documents,
 * and Room Local Offline Cache for E-Books and Test Materials.
 * Abstracts Room database queries and provides reactive Flow streams to ViewModels.
 */
class ExamHierarchyRepository(
    private val dao: ExamHierarchyDao,
    private val documentDao: EbookDocumentDao,
    private val offlineCacheDao: OfflineCacheDao? = null
) {

    // ==========================================
    // Reactive Flow Streams (Exams)
    // ==========================================

    val allExams: Flow<List<ExamEntity>> = dao.getAllExamsFlow()

    val allExamHierarchies: Flow<List<ExamWithSubjectsAndSubTopics>> = dao.getAllExamHierarchiesFlow()

    fun getExamsByGroup(group: String): Flow<List<ExamEntity>> = dao.getExamsByCategoryGroupFlow(group)

    fun getExamById(examId: String): Flow<ExamEntity?> = dao.getExamByIdFlow(examId)

    // ==========================================
    // Reactive Flow Streams (Subjects & Sub-topics)
    // ==========================================

    fun getSubjectsForExam(examId: String): Flow<List<SubjectEntity>> = dao.getSubjectsForExamFlow(examId)

    fun getSubjectsByStage(examId: String, stage: String): Flow<List<SubjectEntity>> =
        dao.getSubjectsByStageFlow(examId, stage)

    fun getSubjectById(subjectId: String): Flow<SubjectEntity?> = dao.getSubjectByIdFlow(subjectId)

    fun getSubTopicsForSubject(subjectId: String): Flow<List<SubTopicEntity>> =
        dao.getSubTopicsForSubjectFlow(subjectId)

    fun searchSubTopics(query: String): Flow<List<SubTopicEntity>> = dao.searchSubTopicsFlow(query)

    // ==========================================
    // Relational Hierarchy Streams
    // ==========================================

    fun getSubjectWithSubTopics(subjectId: String): Flow<SubjectWithSubTopics?> =
        dao.getSubjectWithSubTopicsFlow(subjectId)

    fun getExamWithSubjects(examId: String): Flow<ExamWithSubjects?> =
        dao.getExamWithSubjectsFlow(examId)

    fun getExamHierarchy(examId: String): Flow<ExamWithSubjectsAndSubTopics?> =
        dao.getExamHierarchyFlow(examId)

    // ==========================================
    // Documents / PDF E-Books (Owner Management)
    // ==========================================

    val allDocuments: Flow<List<EbookDocumentEntity>> = documentDao.getAllDocumentsFlow()

    fun getDocumentsByExam(examId: String): Flow<List<EbookDocumentEntity>> =
        documentDao.getDocumentsByExamFlow(examId)

    fun getDocumentById(docId: String): Flow<EbookDocumentEntity?> =
        documentDao.getDocumentByIdFlow(docId)

    suspend fun insertDocument(document: EbookDocumentEntity) =
        documentDao.insertDocument(document)

    suspend fun updateDocumentPrices(docId: String, originalPrice: Int, discountedPrice: Int) =
        documentDao.updateDocumentPrices(docId, originalPrice, discountedPrice)

    suspend fun deleteDocument(docId: String) =
        documentDao.deleteDocumentById(docId)

    // ==========================================
    // Offline Cached E-Books & Test Series (Room Local Cache)
    // ==========================================

    val allCachedEbooks: Flow<List<OfflineEbookCacheEntity>> =
        offlineCacheDao?.getAllCachedEbooksFlow() ?: emptyFlow()

    val allCachedTests: Flow<List<OfflineTestCacheEntity>> =
        offlineCacheDao?.getAllCachedTestsFlow() ?: emptyFlow()

    suspend fun cacheEbookForOffline(item: StudyItem): OfflineEbookCacheEntity {
        val entity = OfflineEbookCacheEntity.fromStudyItem(item)
        offlineCacheDao?.upsertCachedEbook(entity)
        return entity
    }

    suspend fun cacheMockTestForOffline(test: MockTest): OfflineTestCacheEntity {
        val entity = OfflineTestCacheEntity.fromMockTest(test)
        offlineCacheDao?.upsertCachedTest(entity)
        return entity
    }

    suspend fun getCachedEbookById(itemId: String): OfflineEbookCacheEntity? =
        offlineCacheDao?.getCachedEbookById(itemId)

    suspend fun getCachedTestById(testId: String): OfflineTestCacheEntity? =
        offlineCacheDao?.getCachedTestById(testId)

    suspend fun removeCachedEbook(itemId: String) {
        offlineCacheDao?.deleteCachedEbookById(itemId)
    }

    suspend fun removeCachedTest(testId: String) {
        offlineCacheDao?.deleteCachedTestById(testId)
    }

    suspend fun clearAllOfflineCache() {
        offlineCacheDao?.clearAllCachedEbooks()
        offlineCacheDao?.clearAllCachedTests()
    }

    // ==========================================
    // Mutations (Suspend functions)
    // ==========================================

    suspend fun insertExam(exam: ExamEntity) = dao.insertExam(exam)

    suspend fun insertSubject(subject: SubjectEntity) = dao.insertSubject(subject)

    suspend fun insertSubTopic(subTopic: SubTopicEntity) = dao.insertSubTopic(subTopic)

    suspend fun deleteExam(examId: String) = dao.deleteExamById(examId)

    suspend fun deleteSubject(subjectId: String) = dao.deleteSubjectById(subjectId)

    suspend fun deleteSubTopic(subTopicId: String) = dao.deleteSubTopicById(subTopicId)

    /**
     * Ensures default hierarchical data, sample documents, and initial offline cache exist.
     */
    suspend fun checkAndSeedInitialData() {
        if (dao.getExamCount() == 0) {
            ShakuntalamDatabase.populateInitialData(dao, documentDao, offlineCacheDao)
        } else if (offlineCacheDao != null && offlineCacheDao.getCachedEbookCount() == 0 && offlineCacheDao.getCachedTestCount() == 0) {
            val firstEbook = com.example.data.ExamCatalogData.studyItems.firstOrNull { it.type == com.example.model.ContentType.EBOOK }
            if (firstEbook != null) {
                offlineCacheDao.upsertCachedEbook(OfflineEbookCacheEntity.fromStudyItem(firstEbook))
            }
            offlineCacheDao.upsertCachedTest(OfflineTestCacheEntity.fromMockTest(com.example.data.PyqTestBankData.upscPyqTest))
        }
    }
}
