package com.thurainx.movieticketapp.adaptors

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thurainx.movieticketapp.R
import com.thurainx.movieticketapp.delegates.SeatDelegate
import com.thurainx.movieticketapp.models.SeatData
import com.thurainx.movieticketapp.viewholders.SeatRowListViewHolder
import kotlinx.android.synthetic.main.view_holder_seat_row.view.*

class SeatRowListAdapter(
    private val seatDataList: List<SeatData>,
    private val delegate: SeatDelegate
    ) : RecyclerView.Adapter<SeatRowListViewHolder>(){

    lateinit var seatListAdapter: SeatListAdapter

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeatRowListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_seat_row,parent,false)

        return SeatRowListViewHolder(view)
    }

    override fun onBindViewHolder(holder: SeatRowListViewHolder, position: Int) {
        seatListAdapter = SeatListAdapter(delegate,seatDataList[position])
        holder.itemView.rvSeatList.adapter = seatListAdapter

    }

    override fun getItemCount(): Int {
        return seatDataList.size
    }



}