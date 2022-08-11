package com.thurainx.movieticketapp.network.response

import com.google.gson.annotations.SerializedName
import com.thurainx.movieticketapp.data.vos.DateVO
import com.thurainx.movieticketapp.data.vos.MovieVO

data class MovieListResponse(
    @SerializedName("code")
    val code: Int?,

    @SerializedName("message")
    val message: String?,

    @SerializedName("data")
    val data: List<MovieVO>?,
)
