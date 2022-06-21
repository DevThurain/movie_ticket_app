package com.thurainx.movieticketapp.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.thurainx.movieticketapp.R
import com.thurainx.movieticketapp.adaptors.CastListAdapter
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : AppCompatActivity() {
    companion object{
        fun getIntent(context: Context) : Intent {
            return Intent(context,MovieDetailActivity::class.java)
        }
    }
    lateinit var mCastListAdapter: CastListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        setUpCastRecyclerView()
    }

    private fun setUpCastRecyclerView() {
        mCastListAdapter = CastListAdapter()
        rvCastList.adapter = mCastListAdapter
    }
}