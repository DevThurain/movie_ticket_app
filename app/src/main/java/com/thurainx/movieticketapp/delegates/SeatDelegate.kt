package com.thurainx.movieticketapp.delegates

import android.view.View
import android.widget.TextView
import com.thurainx.movieticketapp.data.MovieSeatVO

interface SeatDelegate {
    fun onTapSeat(seatVO: MovieSeatVO)
}