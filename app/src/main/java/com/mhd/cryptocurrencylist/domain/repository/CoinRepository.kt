package com.mhd.cryptocurrencylist.domain.repository

import com.mhd.cryptocurrencylist.data.remote.dto.response.CoinDetailResponse
import com.mhd.cryptocurrencylist.data.remote.dto.response.CoinResponse

interface CoinRepository {

    suspend fun getCoins(): List<CoinResponse>

    suspend fun getCoinById(coinId: String): CoinDetailResponse

}