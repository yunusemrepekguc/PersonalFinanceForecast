package com.yempe.personalfinanceforecast.core.common.enums

enum class CurrencyEnum(
    val code: String,
    val symbol: String,
    val displayName: String
) {
    TRY(code = "TRY", symbol = "₺", displayName = "Turkish Lira"),
    USD(code = "USD", symbol = "$", displayName = "American Dollar"),
    EUR(code = "EUR", "€", displayName = "Euro"),
    GBP(code = "GBP", symbol = "£", displayName = "British Pound");


    companion object {

        fun fromCode(code: String): CurrencyEnum {
            return entries.find { it.code.equals(code, true) } ?: TRY
        }

    }

}