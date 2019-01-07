package com.marinj.cleantutorial.core

import kotlinx.coroutines.*

/**
 * Abstract class for a Use Case (Interactor in terms of Clean Architecture).
 * This abstraction represents an execution unit for different use cases (this means than any use
 * case in the application should implement this contract).
 *
 * By convention each [UseCase] implementation will execute its job in a background thread
 * (kotlin coroutine) and will post the result in the UI thread.
 */
abstract class UseCase<out Type, in Params> where Type : Any {

    private val job = Job()
    private val useCaseScope = CoroutineScope(Dispatchers.Main + job)

    abstract suspend fun run(params: Params): Either<Failure, Type>

    operator fun invoke(params: Params, onResult: (Either<Failure, Type>) -> Unit = {}) {
        useCaseScope.launch {
            val job = async(Dispatchers.Default) { run(params) }
            onResult(job.await())
        }
    }

    fun cancel() {
        job.cancel()
    }
}

class None