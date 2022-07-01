package com.thurainx.movieticketapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.thurainx.movieticketapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
//    lateinit var mSeatRowListAdapter: SeatRowListAdapter

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