package com.thurainx.movieticketapp.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.thurainx.movieticketapp.delegates.MovieDelegate

class MovieListViewHolder(itemView: View, delegate: MovieDelegate) : RecyclerView.ViewHolder(itemView) {
    init {
        itemView.setOnClickListener {
            delegate.onTapMovie()
        }
    }
}