package com.mhd.cryptocurrencylist.common

import androidx.lifecycle.MutableLiveData
import com.mhd.cryptocurrencylist.common.Result.Success
import kotlinx.coroutines.flow.MutableStateFlow

sealed class Result<out R> {

    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val message: String) : Result<Nothing>()
    object Loading : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[message=$message]"
            Loading -> "Loading"
        }
    }

}

val Result<*>.succeeded
    get() = this is Success && data != null

inline fun <reified T> Result<T>.updateOnSuccess(liveData: MutableLiveData<T>) {
    if (this is Success) {
        liveData.value = data
    }
}

inline fun <reified T> Result<T>.updateOnSuccess(stateFlow: MutableStateFlow<T>) {
    if (this is Success) {
        stateFlow.value = data
    }
}