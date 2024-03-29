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
import android.view.View
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
    companion object {
        fun getIntent(
            context: Context,
            checkOutString: String,
            time: String,
            date: String,
            cinemaName: String
        ): Intent {
            val intent = Intent(context, PaymentActivity::class.java)
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
    var mCardList: List<CardVO> = listOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        setupCarousel()
        setupListeners()
        bindData()
        fetchData()
    }

    private fun fetchData() {
        mMovieTicketModel.getCards(
            onSuccess = { cards ->
                if (cards?.isNotEmpty()) {
                    mCardList = cards
                    carousel.addAll(cards.reversed().toMutableList())
                    carousel.setCurrentPosition(0)
                    carouselViewCreditCard.visibility = View.VISIBLE
                }else{
                    carouselViewCreditCard.visibility = View.GONE
                }
            },
            onFail = { errorMessage ->
                Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
            }
        )
    }

    private fun bindData() {
        val checkout =
            Gson().fromJson(intent.getStringExtra(EXTRA_CHECKOUT_STRING), CheckOutVO::class.java)
        tvPaymentAmount.text = "\$${checkout.totalPrice}"
    }

    private fun setupListeners() {
        ivPaymentBack.setOnClickListener {
            super.onBackPressed()
        }

        btnPaymentConfirm.setOnClickListener {
            val checkOutString: String = intent.getStringExtra(EXTRA_CHECKOUT_STRING).toString()
            var checkOut = Gson().fromJson(checkOutString, CheckOutVO::class.java)
            checkOut.cardId = mCardList[carousel.getCurrentPosition()].id ?: 0
            Log.d("check_out", checkOut.cardId.toString())

            makeCheckOut(checkOutVO = checkOut)

        }

        tvAddNewCard.setOnClickListener {
            val intent = AddCardActivity.getIntent(this)
            intentLauncher.launch(intent)
        }

    }

    private fun makeCheckOut(checkOutVO: CheckOutVO){
        Log.d("checkout",Gson().toJson(checkOutVO))
        mMovieTicketModel.checkout(
            checkoutString = checkOutVO,
            onSuccess = { receipt ->
                Toast.makeText(this, receipt.bookingNo, Toast.LENGTH_SHORT).show()
                val time = intent.getStringExtra(EXTRA_TIME)
                val date = intent.getStringExtra(EXTRA_DATE)
                val cinemaName = intent.getStringExtra(EXTRA_CINEMA_NAME)
                val intent = ReceiptActivity.getIntent(
                    this,
                    checkOutString = Gson().toJson(checkOutVO, CheckOutVO::class.java),
                    time = time.toString(),
                    date = date.toString(),
                    cinemaName = cinemaName.toString(),
                    receiptId = receipt.bookingNo.toString()
                )
                startActivity(intent)

            },
            onFail = { errorMessage ->
                Toast.makeText(this,errorMessage, Toast.LENGTH_SHORT).show()
            }
        )
    }

    private fun setupCarousel() {
        mAdapter = CreditCardCarouselAdapter()
        carousel = Carousel(this, carouselViewCreditCard, mAdapter)
        carousel.setOrientation(CarouselView.HORIZONTAL, false)
        carousel.scaleView(true)


    }

    private val intentLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                Log.d("data", result.data?.getStringExtra(EXTRA_CARD_VO) ?: "no data")
                fetchData()
            }
        }
}
