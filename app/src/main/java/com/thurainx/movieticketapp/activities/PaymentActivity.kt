package com.thurainx.movieticketapp.activities

import alirezat775.lib.carouselview.Carousel
import alirezat775.lib.carouselview.CarouselView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.thurainx.movieticketapp.R
import com.thurainx.movieticketapp.adaptors.CreditCardCarouselAdapter
import kotlinx.android.synthetic.main.activity_payment.*

class PaymentActivity : AppCompatActivity() {
    lateinit var mAdapter: CreditCardCarouselAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        setupCarousel()
    }

    private fun setupCarousel() {
        mAdapter =  CreditCardCarouselAdapter()
        val carousel = Carousel(this, carouselViewCreditCard, mAdapter)
        carousel.setOrientation(CarouselView.HORIZONTAL, false)
        carousel.scaleView(true)
    }
}