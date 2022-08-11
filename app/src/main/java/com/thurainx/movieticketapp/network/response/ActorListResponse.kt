package com.thurainx.movieticketapp.network.response

import com.google.gson.annotations.SerializedName
import com.thurainx.movieticketapp.data.vos.ActorVO

data class ActorListResponse(
    @SerializedName("results")
    val results: List<ActorVO>?,
)