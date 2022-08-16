package com.thurainx.movieticketapp.adaptors

import alirezat775.lib.carouselview.CarouselAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.thurainx.movieticketapp.R
import com.thurainx.movieticketapp.data.vos.CardVO
import com.thurainx.movieticketapp.utils.formatCard
import kotlinx.android.synthetic.main.view_credit_card.view.*

class CreditCardCarouselAdapter() : CarouselAdapter(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreditCardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_credit_card,parent,false)
        return CreditCardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return getItems().size
    }


    override fun onBindViewHolder(holder: CarouselViewHolder, position: Int) {
        if(getItems().isNotEmpty()){
            val cardVO = getItems()[position] as CardVO
            val viewHolder = holder as CreditCardViewHolder
            viewHolder.bind(cardVO)
        }
    }


    inner class CreditCardViewHolder(itemView: View) : CarouselViewHolder(itemView) {

        fun bind(cardVO: CardVO){
            itemView.tvCreditCardNumber.text = formatCard(cardVO.cardNumber)
            itemView.tvCreditCardHolder.text = cardVO.cardHolder
            itemView.tvCreditCardExpireDate.text = cardVO.expirationDate
        }
    }

}