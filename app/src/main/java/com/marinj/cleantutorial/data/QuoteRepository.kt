package com.marinj.cleantutorial.data

import com.marinj.cleantutorial.core.Either
import com.marinj.cleantutorial.core.Failure

interface QuoteRepository{
    fun getQuote(): Either<Failure, String>

    class Network : QuoteRepository {
        override fun getQuote(): Either<Failure, String> {

            val isNetworkAvailable = true

            return when(isNetworkAvailable){
                true -> Either.Right("A random quote")
                false -> Either.Left(Failure.NetworkConnection())
            }
        }
    }
}
