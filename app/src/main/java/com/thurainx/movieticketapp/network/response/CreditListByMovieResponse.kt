package com.thurainx.movieticketapp.network.response

import com.google.gson.annotations.SerializedName
import com.thurainx.movieticketapp.data.vos.ActorVO

data class CreditListByMovieResponse(
    @SerializedName("id")
    val id: Int?,

    @SerializedName("cast")
    val cast: List<ActorVO>?,

    @SerializedName("crew")
    val crew: List<ActorVO>?,
)