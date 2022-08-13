package com.thurainx.movieticketapp.delegates

import android.widget.FrameLayout
import android.widget.TextView
import com.thurainx.movieticketapp.data.vos.TimeSlotVO
import com.thurainx.movieticketapp.models.CinemaData

interface TimeSlotDelegate {
    fun onTapTimeSlot(timeSlotVO: TimeSlotVO)
}