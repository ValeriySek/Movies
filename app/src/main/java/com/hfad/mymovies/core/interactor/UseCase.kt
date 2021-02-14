package com.hfad.mymovies.core.interactor

import com.hfad.mymovies.core.exception.Failure
import com.hfad.mymovies.core.functional.Either
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

abstract class UseCase<out Type, in Params> where Type : Any{

    abstract suspend fun run(params: Params) : Either<Failure, Type>

    fun execute(onResult: (Either<Failure, Type>) -> Unit, params: Params) {
        val job = GlobalScope.async { run(params) }
        GlobalScope.launch(Dispatchers.Main) { onResult.invoke(job.await()) }
    }

    class None
}