package com.thurainx.movieticketapp.delegates

import com.thurainx.movieticketapp.data.vos.PaymentMethodVO

interface PaymentMethodDelegate {
    fun onTapPayment(paymentMethodVO: PaymentMethodVO)
}