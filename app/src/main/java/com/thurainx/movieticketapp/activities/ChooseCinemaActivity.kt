package com.thurainx.movieticketapp.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.thurainx.movieticketapp.R
import kotlinx.android.synthetic.main.activity_choose_cinema.*

class ChooseCinemaActivity : AppCompatActivity() {
    companion object{
        fun getIntent(context: Context) : Intent {
            return Intent(context,ChooseCinemaActivity::class.java)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_cinema)

        setupListeners()
    }

    private fun setupListeners() {
        ivChooseCinemaBack.setOnClickListener {
            super.onBackPressed()
        }

        btnChooseCinemaNext.setOnClickListener {
            val intent = BuyTicketActivity.getIntent(this)
            startActivity(intent)
        }
    }
}