package com.marinj.cleantutorial.domain

import com.marinj.cleantutorial.core.Either
import com.marinj.cleantutorial.core.Failure
import com.marinj.cleantutorial.core.None
import com.marinj.cleantutorial.core.UseCase
import com.marinj.cleantutorial.data.QuoteRepository

class GetQuote(private val quoteRepository: QuoteRepository) : UseCase<String, None>() {

    override suspend fun run(params: None): Either<Failure, String> = quoteRepository.getQuote()
}