package com.mhd.cryptocurrencylist.data.remote.dto.response


import com.google.gson.annotations.SerializedName
import com.plcoding.cryptocurrencyappyt.domain.model.Coin

data class CoinResponse(
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

fun CoinResponse.toCoin(): Coin {
    return Coin(
        id = id,
        isActive = isActive,
        name = name,
        rank = rank,
        symbol = symbol
    )
}