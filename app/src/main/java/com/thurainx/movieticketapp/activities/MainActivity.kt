package com.thurainx.movieticketapp.activities

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.thurainx.movieticketapp.R
import com.thurainx.movieticketapp.adaptors.SeatListAdapter
import com.thurainx.movieticketapp.adaptors.SeatRowListAdapter
import com.thurainx.movieticketapp.delegates.SeatDelegate
import com.thurainx.movieticketapp.models.Dummy
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_holder_seat_row.*

class MainActivity : AppCompatActivity() {
    lateinit var mSeatRowListAdapter: SeatRowListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // setupSeatRowListRecyclerView()
    }

//    private fun setupSeatRowListRecyclerView() {
//        mSeatRowListAdapter = SeatRowListAdapter(Dummy().dummySeatList, this,this)
//        rvSeatRowList.adapter = mSeatRowListAdapter
//    }


//    override fun onTapAddSeat(view: View) {
//        view.setBackgroundColor(Color.BLUE)
//
//    }
//
//    override fun onTapRemoveSeat(view: View) {
//        view.setBackgroundColor(Color.RED)
//        Toast.makeText(this,"Remove Seat",Toast.LENGTH_SHORT).show()
//
//    }
//
//    override fun onTapUnAvailableSeat() {
//        Toast.makeText(this,"Unavailable Seat",Toast.LENGTH_SHORT).show()
//    }


}