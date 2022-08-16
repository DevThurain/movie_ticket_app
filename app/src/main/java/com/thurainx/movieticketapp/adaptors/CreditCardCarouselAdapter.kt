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
    var cardList: List<CardVO> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreditCardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_credit_card,parent,false)
        return CreditCardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return cardList.size
    }


    override fun onBindViewHolder(holder: CarouselViewHolder, position: Int) {
        if(cardList.isNotEmpty()){
            val cardVO = cardList[position]
            holder.itemView.tvCreditCardNumber.text = formatCard(cardVO.cardNumber)
            holder.itemView.tvCreditCardHolder.text = cardVO.cardHolder
            holder.itemView.tvCreditCardExpireDate.text = cardVO.expirationDate
        }
    }

    fun setNewData(cardListVO: List<CardVO>){
        cardList = cardListVO
        notifyDataSetChanged()
    }



    inner class CreditCardViewHolder(itemView: View) : CarouselViewHolder(itemView) {

    }

}