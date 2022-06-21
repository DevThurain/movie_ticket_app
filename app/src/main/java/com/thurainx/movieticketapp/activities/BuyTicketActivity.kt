package com.thurainx.movieticketapp.activities

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.thurainx.movieticketapp.R
import com.thurainx.movieticketapp.adaptors.SeatRowListAdapter
import com.thurainx.movieticketapp.delegates.SeatDelegate
import com.thurainx.movieticketapp.models.Dummy
import kotlinx.android.synthetic.main.activity_main.*

class BuyTicketActivity : AppCompatActivity(), SeatDelegate {
    lateinit var mSeatRowListAdapter: SeatRowListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy_ticket)

        setupSeatRowListRecyclerView()
    }

    private fun setupSeatRowListRecyclerView() {
        mSeatRowListAdapter = SeatRowListAdapter(Dummy().dummySeatList, this, this)
        rvSeatRowList.adapter = mSeatRowListAdapter
    }


    override fun onTapAddSeat(view: View) {
        view.background = ContextCompat.getDrawable(this,R.drawable.background_add_seat)

    }

    override fun onTapRemoveSeat(view: View) {
        view.background = ContextCompat.getDrawable(this,R.drawable.background_untaken_seat)
        Toast.makeText(this,"Remove Seat", Toast.LENGTH_SHORT).show()

    }

    override fun onTapUnAvailableSeat() {
        Toast.makeText(this,"Unavailable Seat", Toast.LENGTH_SHORT).show()
    }


}