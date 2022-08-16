package com.thurainx.movieticketapp.activities

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.thurainx.movieticketapp.R
import com.thurainx.movieticketapp.data.EXTRA_CARD_VO
import com.thurainx.movieticketapp.data.models.MovieTicketModelImpl
import com.thurainx.movieticketapp.utils.validateEmpty
import kotlinx.android.synthetic.main.activity_add_card.*

class AddCardActivity : AppCompatActivity() {
    companion object{
        fun getIntent(context: Context) : Intent {
            return Intent(context,AddCardActivity::class.java)
        }
    }
    val mMovieTicketModel = MovieTicketModelImpl
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
            val validateCardNumber = edtCardNumber.validateEmpty("require card number")
            val validateCardHolder = edtCardHolder.validateEmpty("require card holder")
            val validateExpirationDate = edtExpirationDate.validateEmpty("require expiration Date")
            val validateCVC = edtCVC.validateEmpty("require cvc")

            if(validateCardNumber && validateCardHolder && validateExpirationDate && validateCVC){
                mMovieTicketModel.createCard(
                    cardNumber = edtCardNumber.text.toString(),
                    cardHolder = edtCardHolder.text.toString(),
                    expirationDate = edtExpirationDate.text.toString(),
                    cvc = edtCVC.text.toString(),
                    onSuccess = { cardVO ->
                        val data = Intent()
                        data.putExtra(EXTRA_CARD_VO, Gson().toJson(cardVO))
                        setResult(Activity.RESULT_OK, data)
                        Toast.makeText(this,"Card Added Successfully",Toast.LENGTH_SHORT).show()
                        finish()
                    },
                    onFail = { errorMessage ->
                        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
                    }
                )
            }
        }
    }


}