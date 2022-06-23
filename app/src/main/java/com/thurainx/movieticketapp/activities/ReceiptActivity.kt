package com.thurainx.movieticketapp.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.thurainx.movieticketapp.R

class ReceiptActivity : AppCompatActivity() {
    companion object{
        fun getIntent(context: Context) : Intent {
            return Intent(context,ReceiptActivity::class.java)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receipt)
    }
}