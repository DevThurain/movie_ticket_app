package com.thurainx.movieticketapp.adaptors

import android.content.Context
import android.graphics.Color
import android.provider.CalendarContract
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.thurainx.movieticketapp.R
import com.thurainx.movieticketapp.delegates.SeatDelegate
import com.thurainx.movieticketapp.models.SeatData
import com.thurainx.movieticketapp.viewholders.SeatListViewHolder
import kotlinx.android.synthetic.main.view_holder_seat.view.*

class SeatListAdapter(private val delegate: SeatDelegate,private val seatData: SeatData) : RecyclerView.Adapter<SeatListViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeatListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_seat,parent,false)
        return SeatListViewHolder(view, delegate)
    }

    override fun onBindViewHolder(holder: SeatListViewHolder, position: Int) {
        if (seatData.emptyList.contains(position)){
            holder.itemView.llSeat.setBackgroundColor(Color.TRANSPARENT)
        }
        if (seatData.takenList.contains(position)){
            holder.itemView.llSeat.setBackgroundColor(Color.GRAY)
        }

        holder.itemView.llSeat.setOnClickListener {
            if(!seatData.emptyList.contains(position) && !seatData.takenList.contains(position)){
                holder.itemView.llSeat.setBackgroundColor(Color.GREEN)
            }
        }
    }

    override fun getItemCount(): Int {
        return 8
    }

}