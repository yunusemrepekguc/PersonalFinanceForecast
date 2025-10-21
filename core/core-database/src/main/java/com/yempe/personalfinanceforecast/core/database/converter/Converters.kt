package com.yempe.personalfinanceforecast.core.database.converter

import androidx.room.TypeConverters
import com.yempe.personalfinanceforecast.core.common.enums.AccountTypeEnum
import com.yempe.personalfinanceforecast.core.common.enums.CurrencyEnum

class Converters {

    @TypeConverters
    fun currencyEnumFromCurrencyCode(code: String): CurrencyEnum {
        return CurrencyEnum.fromCode(code)
    }

    @TypeConverters
    fun currencyEnumToCurrencyCode(currencyEnum: CurrencyEnum): String {
        return currencyEnum.code
    }

    @TypeConverters
    fun accountTypeEnumFromAccountTypeName(typeName: String): AccountTypeEnum {
        return AccountTypeEnum.fromString(typeName)
    }

    @TypeConverters
    fun accountTypeEnumToAccountTypeName(typeEnum: AccountTypeEnum): String {
        return typeEnum.name
    }
}