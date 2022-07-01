package com.thurainx.movieticketapp.adaptors

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thurainx.movieticketapp.R
import com.thurainx.movieticketapp.data.MovieSeatVO
import com.thurainx.movieticketapp.viewholders.MovieSeatListViewHolder

class MovieSeatListAdapter(private val movieSeatList: List<MovieSeatVO>) : RecyclerView.Adapter<MovieSeatListViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieSeatListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_seat,parent,false)
        return MovieSeatListViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieSeatListViewHolder, position: Int) {
        holder.bind(movieSeatList[position])
    }

    override fun getItemCount(): Int {
        return movieSeatList.size
    }

}