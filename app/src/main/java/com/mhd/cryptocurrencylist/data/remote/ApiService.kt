package com.mhd.cryptocurrencylist.data.remote

import com.mhd.cryptocurrencylist.data.remote.dto.response.CoinDetailResponse
import com.mhd.cryptocurrencylist.data.remote.dto.response.CoinResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("v1/coins")
    suspend fun getCoins(): List<CoinResponse>

    @GET("v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailResponse


}