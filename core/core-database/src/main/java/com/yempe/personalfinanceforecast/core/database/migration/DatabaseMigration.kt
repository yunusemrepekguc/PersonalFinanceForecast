package com.yempe.personalfinanceforecast.core.database.migration

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

object DatabaseMigration {

    val MIGRATION_1_2 = object : Migration(1, 2) {
        override fun migrate(db: SupportSQLiteDatabase) {
            db.execSQL(
                """
                    ALTER TABLE accounts
                    ADD COLUMN description TEXT DEFAULT null
                """.trimIndent()
            )
        }
    }
}