package com.thurainx.movieticketapp.activities

import alirezat775.lib.carouselview.Carousel
import alirezat775.lib.carouselview.CarouselListener
import alirezat775.lib.carouselview.CarouselModel
import alirezat775.lib.carouselview.CarouselView
import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.google.gson.Gson
import com.thurainx.movieticketapp.R
import com.thurainx.movieticketapp.adaptors.CreditCardCarouselAdapter
import com.thurainx.movieticketapp.data.*
import com.thurainx.movieticketapp.data.models.MovieTicketModelImpl
import com.thurainx.movieticketapp.data.vos.CardVO
import com.thurainx.movieticketapp.data.vos.CheckOutVO
import kotlinx.android.synthetic.main.activity_payment.*

class PaymentActivity : AppCompatActivity() {
    companion object{
        fun getIntent(context: Context,checkOutString: String,time: String,date: String,cinemaName: String) : Intent {
            val intent = Intent(context,PaymentActivity::class.java)
            intent.putExtra(EXTRA_CHECKOUT_STRING, checkOutString)
            intent.putExtra(EXTRA_TIME, time)
            intent.putExtra(EXTRA_DATE, date)
            intent.putExtra(EXTRA_CINEMA_NAME, cinemaName)
            return intent
        }
    }
    lateinit var mAdapter: CreditCardCarouselAdapter
    lateinit var carousel: Carousel
    val mMovieTicketModel = MovieTicketModelImpl
    var mCardList : List<CardVO> = listOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        setupCarousel()
        setupListeners()
        bindData()
        fetchData()
    }

    private fun fetchData() {
        mMovieTicketModel.getProfile(
            onSuccess = { profile ->
                if(profile.cards?.isNotEmpty() == true){
                    mCardList = profile.cards
                    carousel.addAll(profile.cards.toMutableList())
                    carousel.setCurrentPosition(0)
                }
             },
            onFail = { errorMessage ->
                Toast.makeText(this,errorMessage,Toast.LENGTH_SHORT).show()
            }
        )
    }

    private fun bindData() {
        val checkout = Gson().fromJson(intent.getStringExtra(EXTRA_CHECKOUT_STRING), CheckOutVO::class.java)
        tvPaymentAmount.text = "\$${checkout.total_price}"
    }

    private fun setupListeners() {
        ivPaymentBack.setOnClickListener {
            super.onBackPressed()
        }

        btnPaymentConfirm.setOnClickListener {
            val checkOutString: String = intent.getStringExtra(EXTRA_CHECKOUT_STRING).toString()
            var checkOut = Gson().fromJson(checkOutString, CheckOutVO::class.java)
            checkOut.card_id = mCardList[carousel.getCurrentPosition()].id ?: 0

            val time = intent.getStringExtra(EXTRA_TIME)
            val date = intent.getStringExtra(EXTRA_DATE)
            val cinemaName = intent.getStringExtra(EXTRA_CINEMA_NAME)
            val intent = ReceiptActivity.getIntent(
                this, checkOutString = checkOutString,
                time = time.toString(),
                date = date.toString(),
                cinemaName = cinemaName.toString()
            )

            startActivity(intent)
        }

        tvAddNewCard.setOnClickListener {
            val intent = AddCardActivity.getIntent(this)
            intentLauncher.launch(intent)
        }

    }

    private fun setupCarousel() {
        mAdapter =  CreditCardCarouselAdapter()
        carousel = Carousel(this, carouselViewCreditCard, mAdapter)
        carousel.setOrientation(CarouselView.HORIZONTAL, false)
        carousel.scaleView(true)

        carousel.addCarouselListener(object : CarouselListener {
            override fun onPositionChange(position: Int) {
                Log.d("carousel", "currentPosition : $position")
            }

            override fun onScroll(dx: Int, dy: Int) {

            }
        })

    }

    private val intentLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->

            if (result.resultCode == Activity.RESULT_OK) {
                Log.d("data", result.data?.getStringExtra(EXTRA_CARD_VO) ?: "no data")
                val cardList = Gson().fromJson(result.data?.getStringExtra(EXTRA_CARD_VO), Array<CardVO>::class.java)
                if(cardList.isNotEmpty()){
                    mCardList = cardList.toList()
                    carousel.addAll(cardList.toMutableList())
                    carousel.setCurrentPosition(0)
                }
            }
        }
}