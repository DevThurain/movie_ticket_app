package com.thurainx.movieticketapp.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.thurainx.movieticketapp.adaptors.MovieListAdapter
import kotlinx.android.synthetic.main.viewpod_movie_list.view.*

class MovieListViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : RelativeLayout(context, attrs) {

    lateinit var mMovieListAdapter: MovieListAdapter

    override fun onFinishInflate() {
        super.onFinishInflate()
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        mMovieListAdapter = MovieListAdapter()
        rvMovieList.adapter = mMovieListAdapter
    }
}