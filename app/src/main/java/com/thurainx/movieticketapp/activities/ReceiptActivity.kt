package com.thurainx.movieticketapp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import com.journeyapps.barcodescanner.BarcodeEncoder
import com.thurainx.movieticketapp.R
import com.thurainx.movieticketapp.data.EXTRA_CHECKOUT_STRING
import com.thurainx.movieticketapp.data.EXTRA_CINEMA_NAME
import com.thurainx.movieticketapp.data.EXTRA_DATE
import com.thurainx.movieticketapp.data.EXTRA_TIME
import com.thurainx.movieticketapp.data.models.MovieTicketModelImpl
import com.thurainx.movieticketapp.data.vos.CheckOutVO
import com.thurainx.movieticketapp.network.IMAGE_BASED_URL
import com.thurainx.movieticketapp.utils.toApiDateFormat
import com.thurainx.movieticketapp.utils.toReceiptDateFormat
import kotlinx.android.synthetic.main.activity_receipt.*


class ReceiptActivity : AppCompatActivity() {
    companion object{
        fun getIntent(context: Context,checkOutString: String,time: String,date: String,cinemaName: String) : Intent {
            val intent = Intent(context,ReceiptActivity::class.java)
            intent.putExtra(EXTRA_CHECKOUT_STRING, checkOutString)
            intent.putExtra(EXTRA_TIME, time)
            intent.putExtra(EXTRA_DATE, date)
            intent.putExtra(EXTRA_CINEMA_NAME, cinemaName)
            return intent
        }
    }
    val mMovieTicketModel = MovieTicketModelImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receipt)

        val checkOutString = intent.getStringExtra(EXTRA_CHECKOUT_STRING).toString()
        Log.d("check_out",checkOutString)
        val checkOut = Gson().fromJson(checkOutString, CheckOutVO::class.java)

        setupListeners()
        fetchData(checkOutVO = checkOut)
        bindData(checkOutVO = checkOut)
    }

    private fun bindData(checkOutVO: CheckOutVO) {
        tvShowTime.text = intent.getStringExtra(EXTRA_TIME).plus( "- ${intent.getStringExtra(EXTRA_DATE)?.toReceiptDateFormat()}")
        tvRow.text = checkOutVO.row
        tvSeat.text = checkOutVO.seat_number
        tvPrice.text = "\$ ${checkOutVO.total_price}"
    }

    private fun fetchData(checkOutVO: CheckOutVO) {


        mMovieTicketModel.checkout(
            checkoutString = checkOutVO,
            onSuccess = { receipt ->
                Toast.makeText(this, receipt.bookingNo, Toast.LENGTH_SHORT).show()
                showBarCode(receipt.bookingNo.toString())

            },
            onFail = { errorMessage ->
                Toast.makeText(this,errorMessage, Toast.LENGTH_SHORT).show()
            }
        )

        mMovieTicketModel.getMovieDetailById(
            id = checkOutVO.movie_id.toString(),
            onSuccess = { movieDetail ->
                tvReceiptMoiveName.text = movieDetail.originalTitle

                tvReceiptMoiveDuration.text = movieDetail.runtime.toString().plus(" min")

                Glide.with(this)
                    .load(IMAGE_BASED_URL+movieDetail.posterPath)
                    .into(ivReceiptCover)
            },
            onFail = { errorMessage ->
                Toast.makeText(this,errorMessage, Toast.LENGTH_SHORT).show()
            }
        )
    }

    private fun showBarCode(text : String) {
        val multiFormatWriter = MultiFormatWriter()
        try {
            val bitMatrix = multiFormatWriter.encode(text, BarcodeFormat.CODE_128, 500, 100)
            val barcodeEncoder = BarcodeEncoder()
            val bitmap = barcodeEncoder.createBitmap(bitMatrix)
            ivReceiptQr.setImageBitmap(bitmap)
        } catch (e: WriterException) {
            e.printStackTrace()
        }
    }

    private fun setupListeners() {
        ivReceiptClose.setOnClickListener {
            val intent = HomeActivity.getIntent(this)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }
    }
}