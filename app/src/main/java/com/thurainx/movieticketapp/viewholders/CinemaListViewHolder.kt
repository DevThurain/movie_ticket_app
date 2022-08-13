package com.thurainx.movieticketapp.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.thurainx.movieticketapp.adaptors.TimeSlotListAdapter
import com.thurainx.movieticketapp.data.vos.CinemaVO
import com.thurainx.movieticketapp.delegates.TimeSlotDelegate
import kotlinx.android.synthetic.main.viewholder_cinema.view.*

class CinemaListViewHolder(itemView: View,val timeSlotDelegate: TimeSlotDelegate) : RecyclerView.ViewHolder(itemView) {
    lateinit var mTimeSlotListAdapter : TimeSlotListAdapter

    fun bind(cinema: CinemaVO){
        itemView.tvCinemaName.text = cinema.cinema
        mTimeSlotListAdapter = TimeSlotListAdapter(timeSlotList = cinema.timeslots ?: listOf(),timeSlotDelegate = timeSlotDelegate)
        itemView.rvTimeList.adapter = mTimeSlotListAdapter
    }
}