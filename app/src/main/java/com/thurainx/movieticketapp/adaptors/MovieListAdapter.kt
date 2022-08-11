package com.thurainx.movieticketapp.adaptors

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thurainx.movieticketapp.R
import com.thurainx.movieticketapp.data.vos.GenreVO
import com.thurainx.movieticketapp.data.vos.MovieVO
import com.thurainx.movieticketapp.delegates.MovieDelegate
import com.thurainx.movieticketapp.viewholders.MovieListViewHolder

class MovieListAdapter(private val delegate: MovieDelegate) : RecyclerView.Adapter<MovieListViewHolder>(){
    var mMovieList : List<MovieVO> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_movie,parent,false)
        return MovieListViewHolder(view,delegate)
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        holder.bindData(mMovieList[position])
    }

    override fun getItemCount(): Int {
        return mMovieList.size
    }

    fun setNewData(movieList: List<MovieVO>){
        mMovieList = movieList
        notifyDataSetChanged()
    }

}