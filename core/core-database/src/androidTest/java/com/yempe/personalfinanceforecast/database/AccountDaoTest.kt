package com.yempe.personalfinanceforecast.database

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.yempe.personalfinanceforecast.core.common.enums.AccountTypeEnum
import com.yempe.personalfinanceforecast.core.common.enums.CurrencyEnum
import com.yempe.personalfinanceforecast.core.database.FinanceDatabase
import com.yempe.personalfinanceforecast.core.database.dao.AccountDao
import com.yempe.personalfinanceforecast.core.database.entity.AccountEntity
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AccountDaoTest {

    private lateinit var database: FinanceDatabase
    private lateinit var accountDao: AccountDao

    @Before
    fun setupDatabase() {
        val context = ApplicationProvider.getApplicationContext<Context>()

        database = Room.inMemoryDatabaseBuilder(
            context,
            FinanceDatabase::class.java
        )
            .allowMainThreadQueries() // main t
            .build()

        accountDao = database.accountDao()
    }

    @After
    fun closeDatabase() {
        database.close()
    }

    @Test
    fun insertAccount_returnsId() = runTest { // coroutine test scope

        val account = AccountEntity(
            accountName = "Savings",
            accountType = AccountTypeEnum.SAVINGS,
            balance = 500.0,
            mainCurrency = CurrencyEnum.EUR
        )

        val id = accountDao.insertAccount(account = account)

        assertThat(id).isGreaterThan(0)
    }

    @Test
    fun insertAccount_returnsCorrectAccount() = runTest {

        val account = AccountEntity(
            accountName = "Savings 2",
            accountType = AccountTypeEnum.SAVINGS,
            balance = 2000.0,
            mainCurrency = CurrencyEnum.TRY
        )

        val id = accountDao.insertAccount(account)
        val retrievedAcc = accountDao.getAccountById(id).first()

        //JUnit
        assertEquals("Savings 2", retrievedAcc.accountName)

        //Google Truth
        assertThat(retrievedAcc.balance).isEqualTo(2000.0)
    }
}