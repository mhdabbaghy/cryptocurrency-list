package com.mhd.cryptocurrencylist.presentation.coin_list

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.mhd.cryptocurrencylist.common.Result
import com.mhd.cryptocurrencylist.domain.usecase.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(private val getCoinsUseCase: GetCoinsUseCase) :
    ViewModel() {

    val state: LiveData<CoinListState> = liveData {
        emit(CoinListState(isLoading = true))
        when (val result = getCoinsUseCase(Unit)) {
            Result.Loading -> emit(CoinListState(isLoading = true))
            is Result.Error -> emit(CoinListState(error = result.message))
            is Result.Success -> emit(CoinListState(coins = result.data))
        }
    }


}