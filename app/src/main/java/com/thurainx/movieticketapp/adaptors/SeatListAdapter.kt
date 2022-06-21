package com.thurainx.movieticketapp.adaptors

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.thurainx.movieticketapp.R
import com.thurainx.movieticketapp.delegates.SeatDelegate
import com.thurainx.movieticketapp.models.SeatData
import com.thurainx.movieticketapp.viewholders.SeatListViewHolder
import kotlinx.android.synthetic.main.view_holder_seat.view.*

class SeatListAdapter(private val delegate: SeatDelegate,private val seatData: SeatData,private val context: Context) : RecyclerView.Adapter<SeatListViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeatListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_seat,parent,false)
        return SeatListViewHolder(view)
    }

    override fun onBindViewHolder(holder: SeatListViewHolder, position: Int) {
        if (seatData.emptyList.contains(position)){
            holder.itemView.llSeat.background = ContextCompat.getDrawable(context,R.drawable.background_transparent_seat)
        }
        if (seatData.takenList.contains(position)){
            holder.itemView.llSeat.background = ContextCompat.getDrawable(context,R.drawable.background_taken_seat)

        }

        holder.itemView.llSeat.setOnClickListener {
            if((it.background ).constantState  == ContextCompat.getDrawable(context,R.drawable.background_add_seat)?.constantState){
                holder.itemView.tvSeatNumber.text = ""
                delegate.onTapRemoveSeat(holder.itemView.llSeat)
            }else if(!seatData.emptyList.contains(position) && !seatData.takenList.contains(position)){
                holder.itemView.tvSeatNumber.text = (position.plus(1)).toString()
                delegate.onTapAddSeat(holder.itemView.llSeat)
            } else if (seatData.takenList.contains(position)){
                delegate.onTapUnAvailableSeat()
            }

        }

    }

    override fun getItemCount(): Int {
        return 8
    }

}