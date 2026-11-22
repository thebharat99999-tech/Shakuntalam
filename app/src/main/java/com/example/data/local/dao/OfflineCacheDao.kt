package com.example.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.local.entity.OfflineEbookCacheEntity
import com.example.data.local.entity.OfflineTestCacheEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface OfflineCacheDao {

    // ==========================================
    // Offline Cached E-Books
    // ==========================================

    @Query("SELECT * FROM offline_cached_ebooks ORDER BY cachedAtTimestamp DESC")
    fun getAllCachedEbooksFlow(): Flow<List<OfflineEbookCacheEntity>>

    @Query("SELECT * FROM offline_cached_ebooks WHERE itemId = :itemId LIMIT 1")
    suspend fun getCachedEbookById(itemId: String): OfflineEbookCacheEntity?

    @Query("SELECT COUNT(*) FROM offline_cached_ebooks")
    suspend fun getCachedEbookCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertCachedEbook(ebook: OfflineEbookCacheEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertCachedEbooks(ebooks: List<OfflineEbookCacheEntity>)

    @Query("DELETE FROM offline_cached_ebooks WHERE itemId = :itemId")
    suspend fun deleteCachedEbookById(itemId: String)

    @Query("DELETE FROM offline_cached_ebooks")
    suspend fun clearAllCachedEbooks()

    // ==========================================
    // Offline Cached Mock Tests / Test Series
    // ==========================================

    @Query("SELECT * FROM offline_cached_tests ORDER BY cachedAtTimestamp DESC")
    fun getAllCachedTestsFlow(): Flow<List<OfflineTestCacheEntity>>

    @Query("SELECT * FROM offline_cached_tests WHERE testId = :testId LIMIT 1")
    suspend fun getCachedTestById(testId: String): OfflineTestCacheEntity?

    @Query("SELECT COUNT(*) FROM offline_cached_tests")
    suspend fun getCachedTestCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertCachedTest(test: OfflineTestCacheEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertCachedTests(tests: List<OfflineTestCacheEntity>)

    @Query("DELETE FROM offline_cached_tests WHERE testId = :testId")
    suspend fun deleteCachedTestById(testId: String)

    @Query("DELETE FROM offline_cached_tests")
    suspend fun clearAllCachedTests()
}
