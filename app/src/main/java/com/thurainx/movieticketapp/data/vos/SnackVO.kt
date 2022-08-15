package com.thurainx.movieticketapp.data.vos

import com.google.gson.annotations.SerializedName

data class SnackVO(
    @SerializedName("id")
    val id: Int?,
    
    @SerializedName("name")
    val name: String?,
    
    @SerializedName("description")
    val description: String?,
    
    @SerializedName("price")
    val price: Int?,
    
    @SerializedName("no_of_sold")
    val noOfSold: Int?,
    
    @SerializedName("is_active")
    val isActive: Int?,
    
    @SerializedName("image")
    val image: String?,

    var count: Int = 0


)