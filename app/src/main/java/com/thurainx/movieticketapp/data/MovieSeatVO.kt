package com.thurainx.movieticketapp.data

import com.google.gson.annotations.SerializedName

const val SEAT_TYPE_AVAILABLE = "available"
const val SEAT_TYPE_TAKEN = "taken"
const val SEAT_TYPE_EMPTY = "space"
const val SEAT_TYPE_TEXT = "text"
data class MovieSeatVO(


    @SerializedName("id")
    val id: Int? = 0,

    @SerializedName("type")
    val type: String?,

    @SerializedName("seat_name")
    val seatName: String? = "",

    @SerializedName("symbol")
    val symbol: String? = "",

    @SerializedName("price")
    val price: Int? = 0,

    var isSelected: Boolean = false



) {

    fun isMovieSeatAvailable() : Boolean{
        return type == SEAT_TYPE_AVAILABLE
    }

    fun isMovieSeatTaken() : Boolean{
        return type == SEAT_TYPE_TAKEN
    }

    fun isMovieSeatEmpty() : Boolean{
        return type == SEAT_TYPE_EMPTY
    }

    fun isMovieSeatText() : Boolean{
        return type == SEAT_TYPE_TEXT
    }

}