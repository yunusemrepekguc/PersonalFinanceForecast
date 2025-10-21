package com.yempe.personalfinanceforecast.core.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.yempe.personalfinanceforecast.core.database.entity.AccountEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AccountDao {

    //CREATE
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAccount(account: AccountEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAccounts(accounts: List<AccountEntity>): List<Long>

    //READ
    @Query("SELECT * FROM accounts WHERE is_active = 1 ORDER BY created_at DESC")
    fun getAllActiveAccounts(): Flow<List<AccountEntity>>

    @Query("SELECT * FROM accounts WHERE account_id = :accountId")
    fun getAccountById(accountId: Long): Flow<AccountEntity>

    @Query("SELECT * FROM accounts WHERE account_type = :type AND is_active = 1")
    fun getAccountsByType(type: String): Flow<List<AccountEntity>>

    @Query("SELECT balance FROM accounts WHERE account_id = :accountId AND is_active = 1")
    fun getAccountBalance(accountId: String): Double

    @Query("SELECT * FROM accounts WHERE is_active = 1")
    fun getAllAccountsOneShot(): List<AccountEntity>

    //UPDATE
    @Update
    fun updateAccount(account: AccountEntity)

    @Query("UPDATE accounts SET balance = :newBalance, updated_at = :updateTime  WHERE account_id = :accountId")
    fun updateBalance(
        accountId: Long,
        newBalance: Double,
        updateTime: Long = System.currentTimeMillis()
    )

    @Query("UPDATE accounts SET is_active = 0, updated_at = :updateTime WHERE account_id = :accountId")
    fun softDeleteAccount(
        accountId: Long,
        updateTime: Long = System.currentTimeMillis()
    )

    @Delete
    fun deleteAccount(account: AccountEntity)

    @Query("DELETE FROM accounts WHERE account_id = :accountId")
    fun deleteByAccountId(accountId: String)

    @Query("DELETE FROM accounts")
    fun deleteAllAccount()
}