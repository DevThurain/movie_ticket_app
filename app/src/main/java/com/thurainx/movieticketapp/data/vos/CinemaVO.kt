package com.thurainx.movieticketapp.data.vos

import com.google.gson.annotations.SerializedName

data class CinemaVO(
    @SerializedName("date")
    val date: String?,

    @SerializedName("cinema_id")
    val cinemaId: Int?,

    @SerializedName("cinema")
    val cinema: String?,

    @SerializedName("timeslots")
    val timeslots: List<TimeSlotVO>?,
    )