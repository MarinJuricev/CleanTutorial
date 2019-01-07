package com.marinj.cleantutorial.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.marinj.cleantutorial.R
import kotlinx.android.synthetic.main.activity_main.*

class QuoteActivity : AppCompatActivity() {

    private lateinit var quoteViewModel: QuoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        quoteViewModel = ViewModelProviders.of(this).get(QuoteViewModel::class.java)
        quoteViewModel.randomQuote.observe(this, Observer{
            Toast.makeText(baseContext, "${it.quote} by ${it.author}", Toast.LENGTH_SHORT).show()
        })

        setupButtonListener()
    }

    private fun setupButtonListener() {
        btn_click_me.setOnClickListener {
            quoteViewModel.getQuote()
        }
    }
}
