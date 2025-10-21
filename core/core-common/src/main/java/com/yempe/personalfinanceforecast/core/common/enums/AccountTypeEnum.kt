package com.yempe.personalfinanceforecast.core.common.enums

enum class AccountTypeEnum {

    CASH,
    BANK_ACCOUNT,
    CREDIT_CARD,
    INVESTMENT,
    SAVINGS,
    OTHER;

    companion object {

        fun fromString(type: String): AccountTypeEnum {
            return entries.find { it.name.equals(type, true) } ?: BANK_ACCOUNT
        }
    }
}