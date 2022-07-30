package com.thurainx.movieticketapp.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.thurainx.movieticketapp.R
import com.thurainx.movieticketapp.adaptors.MovieSeatListAdapter
import com.thurainx.movieticketapp.models.Dummy
import kotlinx.android.synthetic.main.activity_choose_seat.*

class ChooseSeatActivity : AppCompatActivity() {
    companion object{
        fun getIntent(context: Context) : Intent {
            return Intent(context,ChooseSeatActivity::class.java)
        }
    }
    lateinit var mMovieSeatListAdapter: MovieSeatListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_seat)

        setupListeners()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val layoutManager = GridLayoutManager(this,10)
        mMovieSeatListAdapter = MovieSeatListAdapter(Dummy().dummySeatList)
        rvChooseSeat.adapter = mMovieSeatListAdapter
        rvChooseSeat.layoutManager = layoutManager
    }

    private fun setupListeners() {
        ivChooseSeatBack.setOnClickListener {
            super.onBackPressed()
        }
        btnBuyTicket.setOnClickListener {
            val intent = BuySnackActivity.getIntent(this)
            startActivity(intent)
        }
    }
}