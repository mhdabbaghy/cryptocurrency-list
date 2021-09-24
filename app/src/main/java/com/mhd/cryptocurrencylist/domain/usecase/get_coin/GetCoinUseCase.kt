package com.mhd.cryptocurrencylist.domain.usecase.get_coin

import com.mhd.cryptocurrencylist.common.Result
import com.mhd.cryptocurrencylist.data.remote.dto.response.toCoinDetail
import com.mhd.cryptocurrencylist.di.IoDispatcher
import com.mhd.cryptocurrencylist.domain.repository.CoinRepository
import com.mhd.cryptocurrencylist.domain.usecase.CoroutineUseCase
import com.mhd.cryptocurrencylist.domain.usecase.FlowUseCase
import com.plcoding.cryptocurrencyappyt.domain.model.CoinDetail
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository,
    @IoDispatcher coroutineDispatcher: CoroutineDispatcher
) : FlowUseCase<String, CoinDetail>(coroutineDispatcher) {

    override fun execute(parameters: String): Flow<Result<CoinDetail>> = flow {
        emit(Result.Loading)
        val coinDetail = repository.getCoinById(parameters).toCoinDetail()
        emit(Result.Success(coinDetail))
    }


}