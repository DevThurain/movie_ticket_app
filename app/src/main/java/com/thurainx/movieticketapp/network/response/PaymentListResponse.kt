package com.thurainx.movieticketapp.network.response

import com.google.gson.annotations.SerializedName
import com.thurainx.movieticketapp.data.vos.DateVO
import com.thurainx.movieticketapp.data.vos.MovieVO
import com.thurainx.movieticketapp.data.vos.PaymentVO
import com.thurainx.movieticketapp.data.vos.SnackVO

data class PaymentListResponse(
    @SerializedName("code")
    val code: Int?,

    @SerializedName("message")
    val message: String?,

    @SerializedName("data")
    val data: List<PaymentVO>?,
)
