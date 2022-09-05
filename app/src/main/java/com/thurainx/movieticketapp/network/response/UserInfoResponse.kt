package com.thurainx.movieticketapp.network.response

import com.google.gson.annotations.SerializedName
import com.thurainx.movieticketapp.data.vos.UserVO

data class UserInfoResponse(
    @SerializedName("code")
    val code: Int?,

    @SerializedName("message")
    val message: String?,

    @SerializedName("data")
    val data: UserVO?,

    @SerializedName("token")
    val token: String?,
)