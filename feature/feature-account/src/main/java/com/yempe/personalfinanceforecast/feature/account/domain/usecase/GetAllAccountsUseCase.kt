package com.yempe.personalfinanceforecast.feature.account.domain.usecase

import com.yempe.personalfinanceforecast.core.common.extensions.safeCall
import com.yempe.personalfinanceforecast.core.domain.repository.AccountRepository
import javax.inject.Inject

class GetAllAccountsUseCase @Inject constructor(
    private val accountRepository: AccountRepository
) {

//    suspend operator fun invoke() = safeCall {
//
//    }
}