package com.yempe.personalfinanceforecast.core.domain.repository

import com.yempe.personalfinanceforecast.core.common.result.ResultData
import com.yempe.personalfinanceforecast.core.domain.model.AccountModel
import kotlinx.coroutines.flow.Flow

interface AccountRepository {

    fun getAllAccounts(): Flow<ResultData<List<AccountModel>>>

}