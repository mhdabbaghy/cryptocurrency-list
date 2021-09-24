package com.mhd.cryptocurrencylist.domain.usecase

import com.mhd.cryptocurrencylist.common.ExceptionMessageFactory
import com.mhd.cryptocurrencylist.common.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

abstract class CoroutineUseCase<in P, R>(private val coroutineDispatcher: CoroutineDispatcher) {

    suspend operator fun invoke(params: P): Result<R> {
        return try {
            withContext(coroutineDispatcher) {
                execute(params).let {
                    Result.Success(it)
                }
            }
        } catch (e: Exception) {
            Result.Error(ExceptionMessageFactory.getMessage(e))
        }
    }

    protected abstract suspend fun execute(params: P): R

}