package com.yempe.personalfinanceforecast.core.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.yempe.personalfinanceforecast.core.database.entity.CategoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {

    //Insert
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(category: CategoryEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategories(categories: List<CategoryEntity>): List<Long>

    //READ
    @Query("SELECT * FROM category WHERE is_active = 1 ORDER BY category_name ASC")
    fun getAllActiveCategories(): Flow<List<CategoryEntity>>

    @Query("SELECT * FROM category WHERE category_id = :categoryId")
    fun getCategoryById(categoryId: String): Flow<CategoryEntity?>

    @Query("SELECT * FROM category WHERE category_type = :type")
    fun getCategoryByType(type: String): Flow<CategoryEntity>

    @Query("SELECT * FROM category WHERE is_active = 1")
    fun getAllActiveCategoriesOneShot(): List<CategoryEntity>

    //UPDATE
    @Update
    suspend fun updateCategory(category: CategoryEntity)

    @Query("UPDATE category SET is_active = 0, updated_at =:updateTime WHERE category_id = :categoryId")
    suspend fun softDeleteCategory(categoryId: Long, updateTime: Long = System.currentTimeMillis())

    @Delete
    suspend fun deleteCategory(category: CategoryEntity)

    @Query("DELETE from category WHERE category_id = :categoryId")
    suspend fun deleteCategoryById(categoryId: Long)

    @Query("DELETE from category")
    suspend fun deleteAllCategories()
}