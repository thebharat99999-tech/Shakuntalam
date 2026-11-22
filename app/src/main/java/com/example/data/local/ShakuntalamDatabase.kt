package com.example.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.data.ExamCatalogData
import com.example.data.PyqTestBankData
import com.example.data.local.dao.EbookDocumentDao
import com.example.data.local.dao.ExamHierarchyDao
import com.example.data.local.dao.OfflineCacheDao
import com.example.data.local.entity.EbookDocumentEntity
import com.example.data.local.entity.ExamEntity
import com.example.data.local.entity.OfflineEbookCacheEntity
import com.example.data.local.entity.OfflineTestCacheEntity
import com.example.data.local.entity.SubTopicEntity
import com.example.data.local.entity.SubjectEntity
import com.example.model.ContentType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(
    entities = [
        ExamEntity::class,
        SubjectEntity::class,
        SubTopicEntity::class,
        EbookDocumentEntity::class,
        OfflineEbookCacheEntity::class,
        OfflineTestCacheEntity::class
    ],
    version = 3,
    exportSchema = false
)
abstract class ShakuntalamDatabase : RoomDatabase() {

    abstract fun examHierarchyDao(): ExamHierarchyDao
    abstract fun ebookDocumentDao(): EbookDocumentDao
    abstract fun offlineCacheDao(): OfflineCacheDao

    companion object {
        @Volatile
        private var INSTANCE: ShakuntalamDatabase? = null

        fun getDatabase(
            context: Context,
            coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.IO)
        ): ShakuntalamDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ShakuntalamDatabase::class.java,
                    "shakuntalam_exam_hierarchy.db"
                )
                .fallbackToDestructiveMigration(true)
                .build()

                INSTANCE = instance
                instance
            }
        }

        suspend fun populateInitialData(
            hierarchyDao: ExamHierarchyDao,
            documentDao: EbookDocumentDao,
            offlineDao: OfflineCacheDao? = null
        ) {
            hierarchyDao.insertExams(ExamHierarchyPrepopulateData.defaultExams)
            hierarchyDao.insertSubjects(ExamHierarchyPrepopulateData.defaultSubjects)
            hierarchyDao.insertSubTopics(ExamHierarchyPrepopulateData.defaultSubTopics)

            if (offlineDao != null) {
                val firstEbook = ExamCatalogData.studyItems.firstOrNull { it.type == ContentType.EBOOK }
                if (firstEbook != null) {
                    offlineDao.upsertCachedEbook(OfflineEbookCacheEntity.fromStudyItem(firstEbook))
                }
                offlineDao.upsertCachedTest(OfflineTestCacheEntity.fromMockTest(PyqTestBankData.upscPyqTest))
            }

            // Seed initial sample documents
            val sampleDocs = listOf(
                EbookDocumentEntity(
                    id = "doc_upsc_mod_history",
                    title = "Modern Indian History 1757-1947 Master Notes",
                    hindiTitle = "आधुनिक भारत का इतिहास (1757-1947) संपूर्ण हस्तलिखित नोट्स",
                    examId = "upsc_cse",
                    subjectId = "upsc_history",
                    fileName = "Shakuntalam_UPSC_Modern_History_Complete.pdf",
                    fileSizeFormatted = "8.4 MB",
                    pageCount = 280,
                    originalPrice = 599,
                    discountedPrice = 199,
                    medium = "Bilingual (Hindi + English)",
                    sampleContent = "Full comprehensive handwritten notes for UPSC CSE Prelims & Mains with timelines and flowcharts."
                ),
                EbookDocumentEntity(
                    id = "doc_upsc_polity_handbook",
                    title = "Indian Polity & Constitution Simplified Digest",
                    hindiTitle = "भारतीय राजव्यवस्था एवं संविधान सार-संग्रह (अनुच्छेद 1-395)",
                    examId = "upsc_cse",
                    subjectId = "upsc_polity",
                    fileName = "Shakuntalam_Indian_Polity_Articles_Handbook.pdf",
                    fileSizeFormatted = "6.1 MB",
                    pageCount = 310,
                    originalPrice = 650,
                    discountedPrice = 220,
                    medium = "Hindi Medium",
                    sampleContent = "Article by article simplified explanation with landmark Supreme Court judgments."
                ),
                EbookDocumentEntity(
                    id = "doc_uppcs_gk_special",
                    title = "UP Special GK & Budget 2025-26 Comprehensive Guide",
                    hindiTitle = "उत्तर प्रदेश समग्र अध्ययन एवं बजट 2025-26",
                    examId = "state_psc_uppcs",
                    subjectId = "uppcs_up_gk",
                    fileName = "UPPCS_Mains_Paper5_6_Special_GK.pdf",
                    fileSizeFormatted = "5.2 MB",
                    pageCount = 195,
                    originalPrice = 450,
                    discountedPrice = 179,
                    medium = "Hindi Medium",
                    sampleContent = "Exhaustive coverage of UP History, Expressways, ODOP and Budget."
                )
            )
            documentDao.insertDocuments(sampleDocs)
        }
    }
}
