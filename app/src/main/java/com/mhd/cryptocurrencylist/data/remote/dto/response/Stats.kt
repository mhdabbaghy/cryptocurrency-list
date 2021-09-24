package com.mhd.cryptocurrencylist.data.remote.dto.response


import com.google.gson.annotations.SerializedName

data class Stats(
    val contributors: Int,
    val followers: Int,
    val stars: Int,
    val subscribers: Int
)