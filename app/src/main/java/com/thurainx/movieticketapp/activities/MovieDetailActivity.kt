package com.thurainx.movieticketapp.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.thurainx.movieticketapp.R
import com.thurainx.movieticketapp.adaptors.CastListAdapter
import kotlinx.android.synthetic.main.activity_buy_snack.*
import kotlinx.android.synthetic.main.activity_movie_detail.*
import kotlinx.android.synthetic.main.view_ticket_sheet.*

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
        setUpListeners()
    }

    private fun setUpListeners() {
        btnGetTicket.setOnClickListener {
            val intent = ChooseCinemaActivity.getIntent(this)
            startActivity(intent)
        }
        ivMovieDetailBack.setOnClickListener {
            super.onBackPressed()
        }
    }

    private fun setUpCastRecyclerView() {
        mCastListAdapter = CastListAdapter()
        rvCastList.adapter = mCastListAdapter
    }
}