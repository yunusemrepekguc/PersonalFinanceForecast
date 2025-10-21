package com.yempe.personalfinanceforecast.core.database.di

import android.content.Context
import androidx.room.Room
import com.yempe.personalfinanceforecast.core.database.FinanceDatabase
import com.yempe.personalfinanceforecast.core.database.dao.AccountDao
import com.yempe.personalfinanceforecast.core.database.dao.CategoryDao
import com.yempe.personalfinanceforecast.core.database.migration.DatabaseMigration
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideFinanceDatabase(
        @ApplicationContext context: Context
    ): FinanceDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = FinanceDatabase::class.java,
            name = FinanceDatabase.DATABASE_NAME
        )
            .addMigrations(DatabaseMigration.MIGRATION_1_2)
            .build()
    }

    @Provides
    @Singleton
    fun provideAccountDao(database: FinanceDatabase): AccountDao {
        return database.accountDao()
    }

    @Provides
    @Singleton
    fun provideCategoryDao(database: FinanceDatabase): CategoryDao {
        return database.categoryDao()
    }
}