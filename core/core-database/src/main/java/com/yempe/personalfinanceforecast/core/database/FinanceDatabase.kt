package com.yempe.personalfinanceforecast.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.yempe.personalfinanceforecast.core.database.converter.Converters
import com.yempe.personalfinanceforecast.core.database.dao.AccountDao
import com.yempe.personalfinanceforecast.core.database.dao.CategoryDao
import com.yempe.personalfinanceforecast.core.database.entity.AccountEntity
import com.yempe.personalfinanceforecast.core.database.entity.CategoryEntity

@Database(
    entities = [
        AccountEntity::class,
        CategoryEntity::class
    ],
    version = 1,
    exportSchema = true
)
@TypeConverters(
    Converters::class
)
abstract class FinanceDatabase : RoomDatabase() {

    abstract fun accountDao(): AccountDao

    abstract fun categoryDao(): CategoryDao

    companion object {
        const val DATABASE_NAME = "finance_database"
    }
}