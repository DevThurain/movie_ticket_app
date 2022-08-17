package com.thurainx.movieticketapp.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.gson.Gson
import com.thurainx.movieticketapp.R
import com.thurainx.movieticketapp.adaptors.ComboSetListAdapter
import com.thurainx.movieticketapp.adaptors.PaymentMethodListAdapter
import com.thurainx.movieticketapp.data.EXTRA_CHECKOUT_STRING
import com.thurainx.movieticketapp.data.EXTRA_CINEMA_NAME
import com.thurainx.movieticketapp.data.EXTRA_DATE
import com.thurainx.movieticketapp.data.EXTRA_TIME
import com.thurainx.movieticketapp.data.models.MovieTicketModelImpl
import com.thurainx.movieticketapp.data.vos.CheckOutSnackVO
import com.thurainx.movieticketapp.data.vos.CheckOutVO
import com.thurainx.movieticketapp.data.vos.PaymentMethodVO
import com.thurainx.movieticketapp.data.vos.SnackVO
import com.thurainx.movieticketapp.delegates.PaymentMethodDelegate
import com.thurainx.movieticketapp.delegates.SnackDelegate
import com.thurainx.movieticketapp.viewpods.ComboSetViewpod
import kotlinx.android.synthetic.main.activity_buy_snack.*

class BuySnackActivity : AppCompatActivity(), SnackDelegate, PaymentMethodDelegate {
    companion object{
        fun getIntent(context: Context,checkOutString: String,time: String,date: String,cinemaName: String) : Intent {
            val intent = Intent(context,BuySnackActivity::class.java)
            intent.putExtra(EXTRA_CHECKOUT_STRING, checkOutString)
            intent.putExtra(EXTRA_TIME, time)
            intent.putExtra(EXTRA_DATE, date)
            intent.putExtra(EXTRA_CINEMA_NAME, cinemaName)
            return intent
        }
    }

    lateinit var mComboSetListAdapter: ComboSetListAdapter
    lateinit var mPaymentMethodListAdapter: PaymentMethodListAdapter
    val mMovieTicketModel = MovieTicketModelImpl
    var mSnackList : List<SnackVO> = listOf()
    var mPaymentMethodList : List<PaymentMethodVO> = listOf()
    var mSubTotal: Int = 0
    var totalPrice: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy_snack)

        setupListeners()
        setupRecyclerView()
        fetchData()
        bindData()
    }

    private fun bindData(){
        val checkOutString: String = intent.getStringExtra(EXTRA_CHECKOUT_STRING).toString()
        var checkOut = Gson().fromJson(checkOutString, CheckOutVO::class.java)
        totalPrice = checkOut.total_price
        btnPaySnack.text = "Pay \$${totalPrice + mSubTotal}"
    }

    private fun fetchData() {
        mMovieTicketModel.getSnackList(
            onSuccess = { snackList ->
               mSnackList = snackList
                mComboSetListAdapter.setNewData(snackList)
            },
            onFail = { errorMessage ->
                Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
            }
        )

        mMovieTicketModel.getPaymentMethodList(
            onSuccess = { paymentMethodList ->
                paymentMethodList.first().isChecked = true
//                selectedCardId = paymentMethodList.first().id ?: 0
                mPaymentMethodList = paymentMethodList
                mPaymentMethodListAdapter.setNewData(paymentMethodList)
            },
            onFail = { errorMessage ->
                Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
            }
        )
    }

    private fun setupRecyclerView() {
        mComboSetListAdapter = ComboSetListAdapter(this)
        rvComboSet.adapter = mComboSetListAdapter

        mPaymentMethodListAdapter = PaymentMethodListAdapter(this)
        rvPaymentMethod.adapter = mPaymentMethodListAdapter
    }


    private fun setupListeners() {
        ivBuySnackBack.setOnClickListener {
            super.onBackPressed()
        }

        btnPaySnack.setOnClickListener {
            val checkOutString: String = intent.getStringExtra(EXTRA_CHECKOUT_STRING).toString()
            var checkOut = Gson().fromJson(checkOutString, CheckOutVO::class.java)
            checkOut.total_price = totalPrice + mSubTotal
            checkOut.snacks = mSnackList.filter { it.count > 0 }.map {
                CheckOutSnackVO(id = it.id, quantity = it.count)
            }.toList()
            Log.d("check_out",Gson().toJson(checkOut))

            val time = intent.getStringExtra(EXTRA_TIME)
            val date = intent.getStringExtra(EXTRA_DATE)
            val cinemaName = intent.getStringExtra(EXTRA_CINEMA_NAME)
            val intent = PaymentActivity.getIntent(
                this, checkOutString = Gson().toJson(checkOut),
                time = time.toString(),
                date = date.toString(),
                cinemaName = cinemaName.toString()
            )
            startActivity(intent)
        }
    }

    override fun onTapAddSnack(snackVO: SnackVO) {
        if (snackVO.count < 999){
            mSnackList.forEach {
                if(it.id == snackVO.id){
                    snackVO.count++
                }
            }
        }
        mComboSetListAdapter.setNewData(mSnackList)
        updateSubTotal()

    }

    override fun onTapRemoveSnack(snackVO: SnackVO) {
        if (snackVO.count > 0){
            mSnackList.forEach {
                if(it.id == snackVO.id){
                    snackVO.count--
                }
            }
        }
        mComboSetListAdapter.setNewData(mSnackList)
        updateSubTotal()
    }

    private fun updateSubTotal() {
        if(mSnackList.isNotEmpty()){
            mSubTotal = mSnackList.sumOf { it.count * (it.price ?: 0) }
            tvSubTotal.text = "Sub total : $mSubTotal$"
            btnPaySnack.text = "Pay \$${totalPrice + mSubTotal}"
        }
    }

    override fun onTapPayment(paymentMethodVO: PaymentMethodVO) {
       mPaymentMethodList.forEach {
           it.isChecked = it.id == paymentMethodVO.id
//           if(it.isChecked){
//               selectedCardId = it.id ?: 0
//           }
       }
        mPaymentMethodListAdapter.setNewData(mPaymentMethodList)
    }
}