package com.thurainx.movieticketapp.adaptors

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thurainx.movieticketapp.R
import com.thurainx.movieticketapp.viewholders.MovieListViewHolder

class MovieListAdapter() : RecyclerView.Adapter<MovieListViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_movie,parent,false)
        return MovieListViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 5
    }

}