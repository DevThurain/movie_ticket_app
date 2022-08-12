package com.thurainx.movieticketapp.network.response

import com.google.gson.annotations.SerializedName
import com.thurainx.movieticketapp.data.vos.ActorVO
import com.thurainx.movieticketapp.data.vos.ProfileVO

data class TokenResponse(
    @SerializedName("code")
    val code: Int?,
    
    @SerializedName("message")
    val message: String?,
    
    @SerializedName("data")
    val data: ProfileVO?,

    @SerializedName("token")
    val token: String?,
)