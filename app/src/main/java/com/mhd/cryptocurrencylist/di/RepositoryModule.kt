package com.mhd.cryptocurrencylist.di

import com.mhd.cryptocurrencylist.data.repository.CoinRepositoryImpl
import com.mhd.cryptocurrencylist.domain.repository.CoinRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideCoinRepository(coinRepositoryImpl: CoinRepositoryImpl): CoinRepository
}