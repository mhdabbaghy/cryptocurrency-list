package com.plcoding.cryptocurrencyappyt.domain.model

import com.mhd.cryptocurrencylist.data.remote.dto.response.TeamMember

data class CoinDetail(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<TeamMember>
)
