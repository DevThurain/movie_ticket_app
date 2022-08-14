package com.thurainx.movieticketapp.data.vos

import com.google.gson.annotations.SerializedName
import com.thurainx.movieticketapp.data.MovieSeatVO

data class SeatingPlanVO(
    @SerializedName("id")
    val id: Int?,
    
    @SerializedName("taken")
    val taken: Int?,

    @SerializedName("available")
    val available: Int?,

    @SerializedName("income")
    val income: Int?,

    @SerializedName("cinema_name")
    val cinemaName: String?,

    @SerializedName("movie_name")
    val movieName: String?,

    @SerializedName("movie_date")
    val movieDate: String?,

    @SerializedName("seats")
    val seats: List<List<MovieSeatVO>>?,
    )