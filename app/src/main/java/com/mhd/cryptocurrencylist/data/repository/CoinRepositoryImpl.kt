package com.mhd.cryptocurrencylist.data.repository

import com.mhd.cryptocurrencylist.data.remote.ApiService
import com.mhd.cryptocurrencylist.data.remote.dto.response.CoinDetailResponse
import com.mhd.cryptocurrencylist.data.remote.dto.response.CoinResponse
import com.mhd.cryptocurrencylist.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: ApiService
) : CoinRepository {

    override suspend fun getCoins(): List<CoinResponse> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailResponse {
        return api.getCoinById(coinId)
    }

}