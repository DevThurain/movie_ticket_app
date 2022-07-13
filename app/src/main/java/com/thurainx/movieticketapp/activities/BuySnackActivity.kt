package com.thurainx.movieticketapp.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.thurainx.movieticketapp.R
import com.thurainx.movieticketapp.adaptors.ComboSetListAdapter
import com.thurainx.movieticketapp.adaptors.PaymentMethodListAdapter
import com.thurainx.movieticketapp.viewpods.ComboSetViewpod
import kotlinx.android.synthetic.main.activity_buy_snack.*

class BuySnackActivity : AppCompatActivity() {
    companion object{
        fun getIntent(context: Context) : Intent {
            return Intent(context,BuySnackActivity::class.java)
        }
    }

    lateinit var mComboSetListAdapter: ComboSetListAdapter
    lateinit var mPaymentMethodListAdapter: PaymentMethodListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy_snack)

        setupListeners()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        mComboSetListAdapter = ComboSetListAdapter()
        rvComboSet.adapter = mComboSetListAdapter

        mPaymentMethodListAdapter = PaymentMethodListAdapter()
        rvPaymentMethod.adapter = mPaymentMethodListAdapter
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