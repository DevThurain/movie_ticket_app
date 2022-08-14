package com.thurainx.movieticketapp.adaptors

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thurainx.movieticketapp.R
import com.thurainx.movieticketapp.data.MovieSeatVO
import com.thurainx.movieticketapp.delegates.SeatDelegate
import com.thurainx.movieticketapp.viewholders.MovieSeatListViewHolder

class MovieSeatListAdapter(val seatDelegate: SeatDelegate) : RecyclerView.Adapter<MovieSeatListViewHolder>(){
    var mMovieSeatList: List<MovieSeatVO> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieSeatListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_seat,parent,false)
        return MovieSeatListViewHolder(view, seatDelegate)
    }

    override fun onBindViewHolder(holder: MovieSeatListViewHolder, position: Int) {
        if(mMovieSeatList.isNotEmpty())
        holder.bind(mMovieSeatList[position])
    }

    override fun getItemCount(): Int {
        return mMovieSeatList.size
    }

    fun setNewData(newSeatList: List<MovieSeatVO>){
        mMovieSeatList = newSeatList
        notifyDataSetChanged()
    }

}