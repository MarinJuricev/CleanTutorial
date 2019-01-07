package com.marinj.cleantutorial.domain

import com.marinj.cleantutorial.core.Either
import com.marinj.cleantutorial.core.Failure

interface QuoteRepository{
    fun getQuote(): Either<Failure, Quote>
}