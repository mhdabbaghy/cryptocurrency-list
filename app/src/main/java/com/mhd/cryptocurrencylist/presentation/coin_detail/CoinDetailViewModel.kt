package com.mhd.cryptocurrencylist.presentation.coin_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.Constraints
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mhd.cryptocurrencylist.common.Constants
import com.mhd.cryptocurrencylist.common.Result
import com.mhd.cryptocurrencylist.domain.usecase.get_coin.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    getCoinUseCase: GetCoinUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    val state = getCoinUseCase(savedStateHandle.get<String>(Constants.PARAM_COIN_ID)!!)
        .map { result ->
            return@map when (result) {
                Result.Loading -> CoinDetailState(isLoading = true)
                is Result.Success -> CoinDetailState(coin = result.data)
                is Result.Error -> CoinDetailState(error = result.message)
            }
        }
}