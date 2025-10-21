package com.yempe.personalfinanceforecast.database

import com.google.common.truth.Truth.assertThat
import com.yempe.personalfinanceforecast.core.common.enums.AccountTypeEnum
import com.yempe.personalfinanceforecast.core.common.enums.CurrencyEnum
import org.junit.Test

// Unit test
class EnumTest {

    @Test
    fun currencyFromCode_validCode_returnsCorrectCurrency() {

        val result = CurrencyEnum.fromCode("TRY")

        assertThat(result).isEqualTo(CurrencyEnum.TRY)
        assertThat(result.symbol).isEqualTo(CurrencyEnum.TRY.symbol)
        assertThat(result.displayName).isEqualTo(CurrencyEnum.TRY.displayName)
    }

    @Test
    fun currencyFromCode_lowercaseCode_returnCorrectCurrency() {

        val result = CurrencyEnum.fromCode("usd")

        assertThat(result).isEqualTo(CurrencyEnum.USD)
    }

    @Test
    fun currencyFromCode_invalidCode_returnsDefaultTRY() {

        val result = CurrencyEnum.fromCode("INVALID")

        assertThat(result).isEqualTo(CurrencyEnum.TRY)
    }

    @Test
    fun accountTypeFromString_validType_returnsCorrectType() {

        val result = AccountTypeEnum.fromString("BANK")

        assertThat(result).isEqualTo(AccountTypeEnum.BANK_ACCOUNT)
    }

    @Test
    fun accountTypeFromString_lowercaseCode_returnCorrectType() {

        val result = AccountTypeEnum.fromString("credit_card")

        assertThat(result).isEqualTo(AccountTypeEnum.CREDIT_CARD)
    }
}