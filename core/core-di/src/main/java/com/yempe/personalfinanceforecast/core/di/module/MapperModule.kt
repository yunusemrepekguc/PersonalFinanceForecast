package com.yempe.personalfinanceforecast.core.di.module

import com.yempe.personalfinanceforecast.core.common.mapper.CommonDataMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {

    @Provides
    @Singleton
    fun provideCommonMapper(): CommonDataMapper = CommonDataMapper()
}