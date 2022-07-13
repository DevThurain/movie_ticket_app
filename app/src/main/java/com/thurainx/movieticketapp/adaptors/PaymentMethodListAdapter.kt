package com.thurainx.movieticketapp.adaptors

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thurainx.movieticketapp.R
import com.thurainx.movieticketapp.viewholders.PaymentMethodListViewHolder

class PaymentMethodListAdapter() : RecyclerView.Adapter<PaymentMethodListViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentMethodListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_payment_method,parent,false)
        return PaymentMethodListViewHolder(view)
    }

    override fun onBindViewHolder(holder: PaymentMethodListViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 3
    }

}