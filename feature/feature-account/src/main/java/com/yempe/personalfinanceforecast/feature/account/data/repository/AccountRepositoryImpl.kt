package com.yempe.personalfinanceforecast.feature.account.data.repository

import com.yempe.personalfinanceforecast.core.common.result.ResultData
import com.yempe.personalfinanceforecast.core.domain.model.AccountModel
import com.yempe.personalfinanceforecast.core.domain.repository.AccountRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class AccountRepositoryImpl : AccountRepository {

    override fun getAllAccounts(): Flow<ResultData<List<AccountModel>>> {
        return flow {
            emit(ResultData.Loading) // todo
        }
    }
}