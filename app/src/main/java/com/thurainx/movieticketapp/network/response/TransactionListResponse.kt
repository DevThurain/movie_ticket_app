package com.thurainx.movieticketapp.network.response

import com.google.gson.annotations.SerializedName
import com.thurainx.movieticketapp.data.vos.DateVO
import com.thurainx.movieticketapp.data.vos.MovieVO
import com.thurainx.movieticketapp.data.vos.SnackVO
import com.thurainx.movieticketapp.data.vos.TransactionVO

data class TransactionListResponse(
    @SerializedName("code")
    val code: Int?,

    @SerializedName("message")
    val message: String?,

    @SerializedName("data")
    val data: List<TransactionVO>?,
)
