package com.thurainx.movieticketapp.adaptors

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thurainx.movieticketapp.R
import com.thurainx.movieticketapp.data.vos.TimeSlotVO
import com.thurainx.movieticketapp.delegates.TimeSlotDelegate
import com.thurainx.movieticketapp.models.CinemaData
import com.thurainx.movieticketapp.viewholders.TimeListViewHolder
import kotlinx.android.synthetic.main.viewholder_time.view.*

class TimeSlotListAdapter(val timeSlotList: List<TimeSlotVO>,private val timeSlotDelegate: TimeSlotDelegate) : RecyclerView.Adapter<TimeListViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimeListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_time,parent,false)
        return TimeListViewHolder(view, timeSlotDelegate)
    }

    override fun onBindViewHolder(holder: TimeListViewHolder, position: Int) {
        holder.bind(timeSlot = timeSlotList[position])
    }

    override fun getItemCount(): Int {
        return timeSlotList.size
    }


}