package com.marinj.cleantutorial.presentation

import androidx.lifecycle.MutableLiveData
import com.marinj.cleantutorial.core.BaseViewModel
import com.marinj.cleantutorial.core.None
import com.marinj.cleantutorial.data.QuoteRepository
import com.marinj.cleantutorial.domain.GetQuote

class QuoteViewModel : BaseViewModel() {

    val getQuote = GetQuote(QuoteRepository.Network())
    val randomQuote: MutableLiveData<String> = MutableLiveData()

    fun getQuote() = getQuote(None()){it.either(::handleFailure, ::handleQuote)}

    private fun handleQuote(quote: String){
        randomQuote.value = quote
    }
}