package com.thurainx.movieticketapp.network.response

import com.google.gson.annotations.SerializedName
import com.thurainx.movieticketapp.data.vos.ActorVO
import com.thurainx.movieticketapp.data.vos.ProfileVO

data class LogoutResponse(
    @SerializedName("code")
    val code: Int?,
    
    @SerializedName("message")
    val message: String?,

)