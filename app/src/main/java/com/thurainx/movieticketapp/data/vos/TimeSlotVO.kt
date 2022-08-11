package com.thurainx.movieticketapp.data.vos

import com.google.gson.annotations.SerializedName

data class TimeSlotVO(
    @SerializedName("cinema_timeslot_id")
    val cinemaTimeSlotId: Int?,

    @SerializedName("movie_time")
    val movieTime: String?,


    )