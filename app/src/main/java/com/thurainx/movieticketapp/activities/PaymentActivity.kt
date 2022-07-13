package com.thurainx.movieticketapp.activities

import alirezat775.lib.carouselview.Carousel
import alirezat775.lib.carouselview.CarouselView
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.thurainx.movieticketapp.R
import com.thurainx.movieticketapp.adaptors.CreditCardCarouselAdapter
import kotlinx.android.synthetic.main.activity_payment.*

class PaymentActivity : AppCompatActivity() {
    companion object{
        fun getIntent(context: Context) : Intent {
            return Intent(context,PaymentActivity::class.java)
        }
    }
    lateinit var mAdapter: CreditCardCarouselAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        setupCarousel()
        setupListeners()
    }

    private fun setupListeners() {
        ivPaymentBack.setOnClickListener {
            super.onBackPressed()
        }

        btnPaymentConfirm.setOnClickListener {
            val intent = ReceiptActivity.getIntent(this)
            startActivity(intent)
        }

        tvAddNewCard.setOnClickListener {
            val intent = AddCardActivity.getIntent(this)
            startActivity(intent)
        }

    }

    private fun setupCarousel() {
        mAdapter =  CreditCardCarouselAdapter()
        val carousel = Carousel(this, carouselViewCreditCard, mAdapter)
        carousel.setOrientation(CarouselView.HORIZONTAL, false)
        carousel.scaleView(true)
    }
}