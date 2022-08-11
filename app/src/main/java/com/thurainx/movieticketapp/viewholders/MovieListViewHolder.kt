package com.thurainx.movieticketapp.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.thurainx.movieticketapp.data.vos.GenreVO
import com.thurainx.movieticketapp.data.vos.MovieVO
import com.thurainx.movieticketapp.delegates.MovieDelegate
import com.thurainx.movieticketapp.network.IMAGE_BASED_URL
import kotlinx.android.synthetic.main.view_holder_movie.view.*

class MovieListViewHolder(itemView: View, mDelegate: MovieDelegate) : RecyclerView.ViewHolder(itemView) {
    var mMovieVO : MovieVO? = null

    init {
        itemView.setOnClickListener{
            mMovieVO?.let {
                mDelegate.onTapMovie(it.id)
            }
        }
    }

    fun bindData(movie: MovieVO){
        mMovieVO = movie
        itemView.tvMovieName.text = movie.originalTitle
        itemView.tvGenreAndDuration.text = movie.genres?.take(2)?.joinToString(separator = "/")
        Glide.with(itemView.context)
            .load(IMAGE_BASED_URL.plus(movie.posterPath))
            .into(itemView.ivMovieCover)

    }
}