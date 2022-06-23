package com.thurainx.movieticketapp.delegates

import android.view.View
import android.widget.TextView

interface SeatDelegate {
    fun onTapAddSeat(layout: View, textView: TextView, number: String)
    fun onTapRemoveSeat(layout: View, textView: TextView)
    fun onTapUnAvailableSeat()
}