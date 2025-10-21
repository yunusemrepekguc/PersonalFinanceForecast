package com.yempe.personalfinanceforecast.core.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("category")
data class CategoryEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("category_id")
    val categoryId: Long = 0,

    @ColumnInfo("category_name")
    val categoryName: String,

    @ColumnInfo("category_type")
    val categoryType: String,

    @ColumnInfo("category_icon")
    val categoryIcon: String? = null,

    @ColumnInfo("is_active")
    val isActive: Boolean = true,

    @ColumnInfo("created_at")
    val createdAt: Long = System.currentTimeMillis(),

    @ColumnInfo("updated_at")
    val updatedAt: Long = System.currentTimeMillis()
)