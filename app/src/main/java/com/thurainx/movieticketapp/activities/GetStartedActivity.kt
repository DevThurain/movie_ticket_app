package com.thurainx.movieticketapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.thurainx.movieticketapp.R
import kotlinx.android.synthetic.main.activity_get_started.*

class GetStartedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_started)

        setupListeners()
    }

    private fun setupListeners() {
        btnGetStarted.setOnClickListener {
            val intent = WelcomeActivity.getIntent(this)
            startActivity(intent)
        }
    }
}