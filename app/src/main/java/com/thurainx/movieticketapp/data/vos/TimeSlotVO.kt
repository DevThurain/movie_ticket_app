package com.thurainx.movieticketapp.data.vos

import com.google.gson.annotations.SerializedName

data class TimeSlotVO(
    @SerializedName("cinema_day_timeslot_id")
    val cinemaDayTimeSlotId: Int?,

    @SerializedName("start_time")
    val startTime: String?,

    var isSelected: Boolean = false,


    )