package com.thurainx.movieticketapp.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.thurainx.movieticketapp.R
import kotlinx.android.synthetic.main.activity_add_card.*

class AddCardActivity : AppCompatActivity() {
    companion object{
        fun getIntent(context: Context) : Intent {
            return Intent(context,AddCardActivity::class.java)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_card)

        setupListeners()
    }

    private fun setupListeners() {
        ivAddCardBack.setOnClickListener {
            super.onBackPressed()
        }

        btnAddCard.setOnClickListener {
            super.onBackPressed()
        }
    }


}