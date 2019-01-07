package com.marinj.cleantutorial.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.marinj.cleantutorial.R
import com.marinj.cleantutorial.core.Failure
import kotlinx.android.synthetic.main.activity_main.*

class QuoteActivity : AppCompatActivity() {

    private lateinit var quoteViewModel: QuoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        quoteViewModel = ViewModelProviders.of(this).get(QuoteViewModel::class.java)
        quoteViewModel.randomQuote.observe(this, Observer {
            Toast.makeText(baseContext, "${it.quote} by ${it.author}", Toast.LENGTH_SHORT).show()
        })

        quoteViewModel.failure.observe(this, Observer {
            when (it) {
                is Failure.FeatureFail -> Toast.makeText(baseContext, "Feature Fail", Toast.LENGTH_SHORT).show()
                is Failure.NetworkConnection -> Toast.makeText(baseContext, "No network connection", Toast.LENGTH_SHORT).show()
                is Failure.ServerError -> Toast.makeText(baseContext, "AT sjebo", Toast.LENGTH_SHORT).show()
            }
        })

        setupButtonListener()
    }

    private fun setupButtonListener() {
        btn_click_me.setOnClickListener {
            quoteViewModel.getQuote()
        }
    }
}
