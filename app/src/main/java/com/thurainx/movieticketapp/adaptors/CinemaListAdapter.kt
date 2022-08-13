package com.thurainx.movieticketapp.adaptors

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thurainx.movieticketapp.R
import com.thurainx.movieticketapp.data.vos.CinemaVO
import com.thurainx.movieticketapp.delegates.TimeSlotDelegate
import com.thurainx.movieticketapp.models.CinemaData
import com.thurainx.movieticketapp.viewholders.CinemaListViewHolder

class CinemaListAdapter(val timeSlotDelegate: TimeSlotDelegate) : RecyclerView.Adapter<CinemaListViewHolder>(){
    var mCinemaList: List<CinemaVO> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CinemaListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_cinema,parent,false)
        return CinemaListViewHolder(view, timeSlotDelegate)
    }

    override fun onBindViewHolder(holder: CinemaListViewHolder, position: Int) {
        holder.bind(cinema = mCinemaList[position])
    }

    override fun getItemCount(): Int {
        return mCinemaList.size
    }

    fun setNewData(cinemaList: List<CinemaVO>){
        mCinemaList = cinemaList
        notifyDataSetChanged()
    }


}