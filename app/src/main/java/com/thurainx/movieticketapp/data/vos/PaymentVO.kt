package com.thurainx.movieticketapp.data.vos

import com.google.gson.annotations.SerializedName

data class PaymentVO(
    @SerializedName("id")
    val id: Int?,

    @SerializedName("name")
    val name: String?,

    @SerializedName("description")
    val description: String?,

    @SerializedName("is_active")
    val isActive: Int?,


)