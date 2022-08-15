package com.thurainx.movieticketapp.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.thurainx.movieticketapp.data.vos.PaymentMethodVO
import com.thurainx.movieticketapp.delegates.PaymentMethodDelegate
import kotlinx.android.synthetic.main.viewholder_payment_method.view.*

class PaymentMethodListViewHolder(itemView: View, delegate: PaymentMethodDelegate) : RecyclerView.ViewHolder(itemView) {

    var mPaymentMethod : PaymentMethodVO? = null

    init {
         itemView.setOnClickListener {
             mPaymentMethod?.let {
                 delegate.onTapPayment(it)
             }
         }
    }

    fun bind(paymentMethodVO: PaymentMethodVO) {
        mPaymentMethod = paymentMethodVO

        itemView.tvPaymentMethod.text = paymentMethodVO.name
        itemView.tvPaymentMethodDetail.text = paymentMethodVO.description

        if(paymentMethodVO.isChecked){
            itemView.ivPaymentMethodSelected.visibility = View.VISIBLE
        }else{
            itemView.ivPaymentMethodSelected.visibility = View.GONE
        }

    }


}