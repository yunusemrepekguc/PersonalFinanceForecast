package com.yempe.personalfinanceforecast.core.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.yempe.personalfinanceforecast.core.common.enums.AccountTypeEnum
import com.yempe.personalfinanceforecast.core.common.enums.CurrencyEnum

@Entity(tableName = "accounts")
data class AccountEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "account_id")
    val accountId: Long = 0,

    @ColumnInfo(name = "account_name")
    val accountName: String,

    @ColumnInfo(name = "account_type")
    val accountType: AccountTypeEnum,

    @ColumnInfo(name = "balance")
    val balance: Double,

    @ColumnInfo(name = "main_currency")
    val mainCurrency: CurrencyEnum = CurrencyEnum.TRY,

    @ColumnInfo(name = "icon")
    val icon: String? = null,

    @ColumnInfo(name = "is_active")
    val isActive: Boolean = true,

    @ColumnInfo(name = "created_at")
    val createdAt: Long = System.currentTimeMillis(),

    @ColumnInfo(name = "updated_at")
    val updatedAt: Long = System.currentTimeMillis()
)