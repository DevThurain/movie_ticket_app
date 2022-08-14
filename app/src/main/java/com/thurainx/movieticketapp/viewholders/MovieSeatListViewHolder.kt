package com.thurainx.movieticketapp.viewholders

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.thurainx.movieticketapp.R
import com.thurainx.movieticketapp.data.MovieSeatVO
import com.thurainx.movieticketapp.delegates.SeatDelegate
import kotlinx.android.synthetic.main.view_holder_seat.view.*

class MovieSeatListViewHolder(itemView: View,delegate: SeatDelegate) : RecyclerView.ViewHolder(itemView) {
    var mMovieSeatVo : MovieSeatVO? = null
    init {
        itemView.setOnClickListener {
            mMovieSeatVo?.let {
                delegate.onTapSeat(it)
            }
        }
    }
    fun bind(movieSeatVO: MovieSeatVO){
        mMovieSeatVo = movieSeatVO
        when{
            movieSeatVO.isMovieSeatAvailable() ->{
                itemView.tvSeatTitle.visibility = View.GONE
                itemView.background = ContextCompat.getDrawable(itemView.context, R.drawable.background_seat_available)
                if(movieSeatVO.isSelected){
                    itemView.tvSeatTitle.visibility = View.VISIBLE
                    itemView.tvSeatTitle.text = movieSeatVO.id.toString()
                    itemView.tvSeatTitle.setTextColor(ContextCompat.getColor(itemView.context,R.color.white))
                    itemView.background = ContextCompat.getDrawable(itemView.context, R.drawable.background_seat_add)
                }
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