package com.thurainx.movieticketapp.adaptors

import alirezat775.lib.carouselview.CarouselAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.thurainx.movieticketapp.R

class CreditCardCarouselAdapter() : CarouselAdapter(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreditCardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_credit_card,parent,false)
        return CreditCardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 4
    }


    override fun onBindViewHolder(holder: CarouselViewHolder, position: Int) {
    }

    inner class CreditCardViewHolder(itemView: View) : CarouselViewHolder(itemView) {

    }

}