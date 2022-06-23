package com.thurainx.movieticketapp.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.thurainx.movieticketapp.R
import com.thurainx.movieticketapp.viewpods.ComboSetViewpod
import kotlinx.android.synthetic.main.activity_buy_snack.*

class BuySnackActivity : AppCompatActivity() {
    companion object{
        fun getIntent(context: Context) : Intent {
            return Intent(context,BuySnackActivity::class.java)
        }
    }
    lateinit var comboSetLViewpod: ComboSetViewpod
    lateinit var comboSet2Viewpod: ComboSetViewpod


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy_snack)

        setupListeners()
        setupViewpods()
    }

    private fun setupViewpods() {
        comboSetLViewpod = vpComboSetL as ComboSetViewpod
        comboSetLViewpod.setTitleAndDetail(
            title = "Combo Set L",
            detail = "Combo Set M 32oz. Coke (x1)\nand large popcorn (x1)"
        )

        comboSet2Viewpod = vpComboSet2 as ComboSetViewpod
        comboSet2Viewpod.setTitleAndDetail(
            title = "Combo Set 2",
            detail = "Combo Set 2 32oz. Coke (x2)\nand large popcorn (x1)"
        )
    }

    private fun setupListeners() {
        ivBuySnackBack.setOnClickListener {
            super.onBackPressed()
        }

        btnPaySnack.setOnClickListener {
            val intent = PaymentActivity.getIntent(this)
            startActivity(intent)
        }
    }
}