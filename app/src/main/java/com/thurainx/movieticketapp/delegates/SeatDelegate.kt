package com.thurainx.movieticketapp.delegates

import android.view.View

interface SeatDelegate {
    fun onTapAddSeat(bg: View)
    fun onTapRemoveSeat(bg: View)
    fun onTapUnAvailableSeat()
}