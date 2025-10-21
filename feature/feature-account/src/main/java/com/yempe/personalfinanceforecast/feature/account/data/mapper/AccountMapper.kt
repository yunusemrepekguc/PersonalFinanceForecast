package com.yempe.personalfinanceforecast.feature.account.data.mapper

import com.yempe.personalfinanceforecast.core.common.mapper.CommonDataMapper
import com.yempe.personalfinanceforecast.core.database.entity.AccountEntity
import com.yempe.personalfinanceforecast.core.domain.model.AccountModel
import java.math.BigDecimal
import javax.inject.Inject

class AccountMapper @Inject constructor(
    private val commonDataMapper: CommonDataMapper
) {

    fun entityToDomain(entity: AccountEntity): AccountModel {
        return AccountModel(
            id = entity.accountId,
            name = entity.accountName,
            type = entity.accountType,
            currency = entity.mainCurrency,
            balance = BigDecimal(entity.balance),
            icon = entity.icon,
            isActive = entity.isActive,
            createdAt = commonDataMapper.longToLocalDateTime(timestamp = entity.createdAt),
            updatedAt = commonDataMapper.longToLocalDateTime(timestamp = entity.updatedAt)
        )
    }

    fun entityListToDomainList(entityList: List<AccountEntity>): List<AccountModel> {
        return entityList.map(transform = ::entityToDomain)
    }

    fun domainToEntity(domain: AccountModel): AccountEntity {
        return AccountEntity(
            accountId = domain.id,
            accountName = domain.name,
            accountType = domain.type,
            mainCurrency = domain.currency,
            balance = domain.balance.toDouble(),
            icon = domain.icon,
            isActive = domain.isActive,
            createdAt = commonDataMapper.localDateTimeToLong(domain.createdAt),
            updatedAt = commonDataMapper.localDateTimeToLong(domain.updatedAt)
        )
    }

    fun domainListToEntityList(domainList: List<AccountModel>): List<AccountEntity> {
        return domainList.map(transform = ::domainToEntity)
    }
}