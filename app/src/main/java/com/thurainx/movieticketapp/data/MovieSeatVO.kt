package com.thurainx.movieticketapp.data

const val SEAT_TYPE_AVAILABLE = "available"
const val SEAT_TYPE_TAKEN = "taken"
const val SEAT_TYPE_EMPTY = "empty"
const val SEAT_TYPE_TEXT = "text"
class MovieSeatVO(val title: String = "",private val type: String = "") {

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