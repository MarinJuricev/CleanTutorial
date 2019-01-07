package com.marinj.cleantutorial.presentation

import androidx.lifecycle.MutableLiveData
import com.marinj.cleantutorial.core.BaseViewModel
import com.marinj.cleantutorial.core.None
import com.marinj.cleantutorial.data.Network
import com.marinj.cleantutorial.domain.GetQuote
import com.marinj.cleantutorial.domain.Quote

class QuoteViewModel : BaseViewModel() {

    val getQuote = GetQuote(Network())
    val randomQuote: MutableLiveData<Quote> = MutableLiveData()

    fun getQuote() = getQuote(None()) { it.either(::handleFailure, ::handleQuote) }

    private fun handleQuote(quote: Quote) {
        randomQuote.value = quote
    }
}