package com.thurainx.movieticketapp.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.thurainx.movieticketapp.R
import kotlinx.android.synthetic.main.activity_get_started.*

class
GetStartedActivity : AppCompatActivity() {
    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, GetStartedActivity::class.java)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_started)

        setupListeners()
    }

    private fun setupListeners() {
        btnGetStarted.setOnClickListener {
            val intent = WelcomeActivity.getIntent(this)
//            finish()
            startActivity(intent)
        }
    }
}