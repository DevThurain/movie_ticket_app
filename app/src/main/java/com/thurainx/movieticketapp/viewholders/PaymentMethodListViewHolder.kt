package com.thurainx.movieticketapp.viewholders

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.thurainx.movieticketapp.R
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
            itemView.tvPaymentMethod.setTextColor(itemView.context.getColor(R.color.color_primary))
            itemView.tvPaymentMethodDetail.setTextColor(itemView.context.getColor(R.color.color_primary))
            itemView.ivPaymentMethod.setColorFilter(ContextCompat.getColor(itemView.context, R.color.color_primary), android.graphics.PorterDuff.Mode.SRC_IN);
        }else{
            itemView.tvPaymentMethod.setTextColor(itemView.context.getColor(R.color.black))
            itemView.tvPaymentMethodDetail.setTextColor(itemView.context.getColor(R.color.color_grey))
            itemView.ivPaymentMethod.setColorFilter(ContextCompat.getColor(itemView.context, R.color.color_grey), android.graphics.PorterDuff.Mode.SRC_IN);
        }

    }


}