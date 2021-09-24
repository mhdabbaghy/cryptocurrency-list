package com.mhd.cryptocurrencylist.common

object ExceptionMessageFactory {

    fun getMessage(e: Exception): String = e.localizedMessage ?: e.message ?: e.stackTraceToString()

}