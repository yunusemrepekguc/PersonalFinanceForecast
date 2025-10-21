package com.yempe.personalfinanceforecast.core.domain.model

import com.yempe.personalfinanceforecast.core.common.enums.AccountTypeEnum
import com.yempe.personalfinanceforecast.core.common.enums.CurrencyEnum
import java.math.BigDecimal
import java.time.LocalDateTime

data class AccountModel(
    val id: Long = 0,
    val name: String,
    val type: AccountTypeEnum,
    val currency: CurrencyEnum,
    val balance: BigDecimal,
    val icon: String? = null,
    val isActive: Boolean = true,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)
