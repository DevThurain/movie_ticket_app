package com.thurainx.movieticketapp.delegates

import com.thurainx.movieticketapp.data.vos.DayVO

interface DayDelegate {
    fun onTapDay(day: DayVO)
}