package com.yempe.personalfinanceforecast.feature.account.di

import com.yempe.personalfinanceforecast.feature.account.data.repository.AccountRepositoryImpl
import com.yempe.personalfinanceforecast.feature.account.domain.repository.AccountRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface AccountModule {

    @Binds
    @Singleton
    fun bindAccountRepository(
        accountRepositoryImpl: AccountRepositoryImpl
    ): AccountRepository
}