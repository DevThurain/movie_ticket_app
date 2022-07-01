package com.thurainx.movieticketapp.adaptors

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thurainx.movieticketapp.R
import com.thurainx.movieticketapp.delegates.TimeDelegate
import com.thurainx.movieticketapp.models.CinemaData
import com.thurainx.movieticketapp.viewholders.CinemaListViewHolder
import kotlinx.android.synthetic.main.viewholder_cinema.view.*

class CinemaListAdapter(val cinemaDataList: List<CinemaData>,val timeDelegate: TimeDelegate) : RecyclerView.Adapter<CinemaListViewHolder>(){
    lateinit var mTimeListAdapter : TimeListAdapter
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CinemaListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_cinema,parent,false)
        return CinemaListViewHolder(view)
    }

    override fun onBindViewHolder(holder: CinemaListViewHolder, position: Int) {
        holder.itemView.tvCinemaName.text = cinemaDataList[position].name
        mTimeListAdapter = TimeListAdapter(cinemaData = cinemaDataList[position], timeDelegate = timeDelegate)
        holder.itemView.rvTimeList.adapter = mTimeListAdapter
//        val spanCount = 3 // 3 columns
//        val spacing = 45 // 50px
//        val includeEdge = true
//        holder.itemView.rvTimeList.addItemDecoration(GridSpacingItemDecoration(spanCount, spacing, includeEdge))


    }

    override fun getItemCount(): Int {
        return cinemaDataList.size
    }



}