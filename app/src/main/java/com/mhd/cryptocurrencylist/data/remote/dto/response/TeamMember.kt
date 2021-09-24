package com.mhd.cryptocurrencylist.data.remote.dto.response


import com.google.gson.annotations.SerializedName

data class TeamMember(
    val id: String,
    val name: String,
    val position: String
)