package com.thurainx.movieticketapp.adaptors

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thurainx.movieticketapp.R
import com.thurainx.movieticketapp.data.vos.PaymentMethodVO
import com.thurainx.movieticketapp.data.vos.SnackVO
import com.thurainx.movieticketapp.delegates.PaymentMethodDelegate
import com.thurainx.movieticketapp.viewholders.PaymentMethodListViewHolder

class PaymentMethodListAdapter(val paymentMethodDelegate: PaymentMethodDelegate) : RecyclerView.Adapter<PaymentMethodListViewHolder>(){
    var mPaymentMethodList: List<PaymentMethodVO> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentMethodListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_payment_method,parent,false)
        return PaymentMethodListViewHolder(view, paymentMethodDelegate)
    }

    override fun onBindViewHolder(holder: PaymentMethodListViewHolder, position: Int) {
        if(mPaymentMethodList.isNotEmpty()){
            holder.bind(mPaymentMethodList[position])

        }
    }

    override fun getItemCount(): Int {
        return mPaymentMethodList.size
    }

    fun setNewData(paymentMethodList: List<PaymentMethodVO>) {
        mPaymentMethodList = paymentMethodList
        notifyDataSetChanged()
    }

}