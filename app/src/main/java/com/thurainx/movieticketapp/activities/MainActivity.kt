package com.thurainx.movieticketapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.thurainx.movieticketapp.R
import com.thurainx.movieticketapp.adaptors.SeatListAdapter
import com.thurainx.movieticketapp.adaptors.SeatRowListAdapter
import com.thurainx.movieticketapp.delegates.SeatDelegate
import com.thurainx.movieticketapp.models.Dummy
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_holder_seat_row.*

class MainActivity : AppCompatActivity(), SeatDelegate {
    lateinit var mSeatRowListAdapter: SeatRowListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupSeatRowListRecyclerView()
    }

    private fun setupSeatRowListRecyclerView() {
        mSeatRowListAdapter = SeatRowListAdapter(Dummy().dummySeatList, this)
        rvSeatRowList.adapter = mSeatRowListAdapter
    }

    override fun onTapSeat() {
        Toast.makeText(this,"success",Toast.LENGTH_SHORT).show()
    }


}