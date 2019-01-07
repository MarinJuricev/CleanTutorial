package com.marinj.cleantutorial.core

import com.marinj.cleantutorial.data.model.LocalQuote
import com.marinj.cleantutorial.data.model.RemoteQuote
import com.marinj.cleantutorial.domain.Quote

fun LocalQuote.toQuote(): Quote = Quote(
        author,
        message
)

fun RemoteQuote.toQuote(): Quote = Quote(
        author,
        message
)