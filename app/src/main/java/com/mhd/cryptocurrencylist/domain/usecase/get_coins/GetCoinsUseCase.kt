package com.mhd.cryptocurrencylist.domain.usecase.get_coins

import com.mhd.cryptocurrencylist.data.remote.dto.response.toCoin
import com.mhd.cryptocurrencylist.di.IoDispatcher
import com.mhd.cryptocurrencylist.domain.repository.CoinRepository
import com.mhd.cryptocurrencylist.domain.usecase.CoroutineUseCase
import com.plcoding.cryptocurrencyappyt.domain.model.Coin
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository,
    @IoDispatcher coroutineDispatcher: CoroutineDispatcher
) : CoroutineUseCase<Unit, List<Coin>>(coroutineDispatcher) {

    override suspend fun execute(params: Unit): List<Coin> {
        return repository.getCoins().map { it.toCoin() }
    }
}