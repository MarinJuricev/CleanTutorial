package com.marinj.cleantutorial.data

import com.marinj.cleantutorial.core.Either
import com.marinj.cleantutorial.core.Failure
import com.marinj.cleantutorial.domain.Quote
import com.marinj.cleantutorial.domain.QuoteRepository

class Network : QuoteRepository {
    override fun getQuote(): Either<Failure, Quote> {

        val isNetworkAvailable = true

        return when (isNetworkAvailable) {
            true -> Either.Right(Quote("Nobody important", "Take nothing for granted"))
            false -> Either.Left(Failure.NetworkConnection())
        }
    }
}
