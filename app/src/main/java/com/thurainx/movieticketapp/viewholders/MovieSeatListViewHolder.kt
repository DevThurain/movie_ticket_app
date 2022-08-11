package com.thurainx.movieticketapp.viewholders

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.thurainx.movieticketapp.R
import com.thurainx.movieticketapp.data.MovieSeatVO
import kotlinx.android.synthetic.main.view_holder_seat.view.*

class MovieSeatListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(movieSeatVO: MovieSeatVO){
        when{
            movieSeatVO.isMovieSeatAvailable() ->{
                itemView.tvSeatTitle.visibility = View.GONE
                itemView.background = ContextCompat.getDrawable(itemView.context, R.drawable.background_seat_available)
            }

            movieSeatVO.isMovieSeatText() ->{
                itemView.tvSeatTitle.visibility = View.VISIBLE
                itemView.tvSeatTitle.text = movieSeatVO.symbol
                itemView.background = ContextCompat.getDrawable(itemView.context, R.drawable.background_seat_text)
            }

            movieSeatVO.isMovieSeatTaken() ->{
                itemView.tvSeatTitle.visibility = View.GONE
                itemView.background = ContextCompat.getDrawable(itemView.context, R.drawable.background_seat_taken)
            }

            movieSeatVO.isMovieSeatEmpty() ->{
                itemView.tvSeatTitle.visibility = View.GONE
                itemView.background = ContextCompat.getDrawable(itemView.context, R.drawable.background_seat_text)
            }


        }

    }
}