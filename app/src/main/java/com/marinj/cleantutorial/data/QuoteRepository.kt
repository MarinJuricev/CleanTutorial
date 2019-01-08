package com.marinj.cleantutorial.data

import com.marinj.cleantutorial.core.Either
import com.marinj.cleantutorial.core.Failure
import com.marinj.cleantutorial.core.toQuote
import com.marinj.cleantutorial.data.model.RemoteQuote
import com.marinj.cleantutorial.domain.Quote
import com.marinj.cleantutorial.domain.QuoteRepository
import java.lang.Thread.sleep

class Network : QuoteRepository {
    override fun getQuote(): Either<Failure, Quote> {

        val isNetworkAvailable = true

        val quoteToReturn = getQuoteFromFakeNetwork()

        return when (isNetworkAvailable) {
            true -> Either.Right(quoteToReturn)
            false -> Either.Left(Failure.NetworkConnection())
        }
    }

    private fun getQuoteFromFakeNetwork(): Quote {
        val networkQuote = RemoteQuote("important", "Take nothing for granted")

        sleep(500)

        return networkQuote.toQuote()
    }
}
