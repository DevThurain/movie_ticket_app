package com.thurainx.movieticketapp.adaptors

import android.graphics.Color
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.thurainx.movieticketapp.R
import com.thurainx.movieticketapp.delegates.TimeDelegate
import com.thurainx.movieticketapp.models.CinemaData
import com.thurainx.movieticketapp.viewholders.TimeListViewHolder
import kotlinx.android.synthetic.main.viewholder_date.view.*
import kotlinx.android.synthetic.main.viewholder_time.view.*

class TimeListAdapter(private val cinemaData: CinemaData,private val timeDelegate: TimeDelegate) : RecyclerView.Adapter<TimeListViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimeListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_time,parent,false)
        return TimeListViewHolder(view)
    }

    override fun onBindViewHolder(holder: TimeListViewHolder, position: Int) {
        holder.itemView.tvTime.text = cinemaData.timeList[position]

    }

    override fun getItemCount(): Int {
        return cinemaData.timeList.size
    }

}