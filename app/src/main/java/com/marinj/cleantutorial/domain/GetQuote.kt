package com.marinj.cleantutorial.domain

import com.marinj.cleantutorial.core.Either
import com.marinj.cleantutorial.core.Failure
import com.marinj.cleantutorial.core.None
import com.marinj.cleantutorial.core.UseCase

class GetQuote(private val quoteRepository: QuoteRepository) : UseCase<Quote, None>() {

    override suspend fun run(params: None): Either<Failure, Quote> = quoteRepository.getQuote()
}