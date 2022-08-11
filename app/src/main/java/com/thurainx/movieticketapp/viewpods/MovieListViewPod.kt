package com.thurainx.movieticketapp.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.thurainx.movieticketapp.adaptors.MovieListAdapter
import com.thurainx.movieticketapp.data.vos.GenreVO
import com.thurainx.movieticketapp.data.vos.MovieVO
import com.thurainx.movieticketapp.delegates.MovieDelegate
import kotlinx.android.synthetic.main.viewpod_movie_list.view.*

class MovieListViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : RelativeLayout(context, attrs) {

    lateinit var mMovieListAdapter: MovieListAdapter
    lateinit var movieDelegate: MovieDelegate

    override fun onFinishInflate() {
        super.onFinishInflate()
    }

    fun setUpMovieListViewPod(title:String, delegate: MovieDelegate){
        tvTitle.text = title
        movieDelegate = delegate
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        mMovieListAdapter = MovieListAdapter(movieDelegate)
        rvMovieList.adapter = mMovieListAdapter
    }

    fun setData(movieList: List<MovieVO>){
        mMovieListAdapter.setNewData(movieList = movieList)
    }
}