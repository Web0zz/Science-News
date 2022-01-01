package com.web0zz.science_news.domain.usecase

import com.github.michaelbull.result.Result
import com.web0zz.science_news.di.MainDispatcher
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

// Learn more about this implementation
//
// https://github.com/android10/Android-CleanArchitecture-Kotlin
// https://adambennett.dev/2020/05/the-result-monad/
abstract class UseCase<out Type, out Failure, in Params> @Inject constructor(
    @MainDispatcher private val mainDispatcher: CoroutineDispatcher
) where Type : Any {

    abstract suspend fun run(params: Params): Flow<Result<Type, Failure>>

    @DelicateCoroutinesApi
    operator fun invoke(
        params: Params,
        scope: CoroutineScope = GlobalScope,
        onResult: (Flow<Result<Type, Failure>>) -> Unit = {}
    ) {
        scope.launch(mainDispatcher) {
            val deferred = async(Dispatchers.IO) {
                run(params)
            }
            onResult(deferred.await())
        }
    }

    class None
}