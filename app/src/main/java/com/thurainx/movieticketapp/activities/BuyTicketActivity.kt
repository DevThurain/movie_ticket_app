package com.thurainx.movieticketapp.activities

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.thurainx.movieticketapp.R
import com.thurainx.movieticketapp.adaptors.SeatRowListAdapter
import com.thurainx.movieticketapp.delegates.SeatDelegate
import com.thurainx.movieticketapp.models.Dummy
import kotlinx.android.synthetic.main.activity_buy_ticket.*
import kotlinx.android.synthetic.main.activity_main.rvSeatRowList

class BuyTicketActivity : AppCompatActivity(), SeatDelegate {
    lateinit var mSeatRowListAdapter: SeatRowListAdapter

    companion object{
        fun getIntent(context: Context) : Intent {
            return Intent(context,BuyTicketActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy_ticket)

        setupSeatRowListRecyclerView()
        setupListeners()
    }

    private fun setupListeners(){
        ivBuyTicketBack.setOnClickListener {
            super.onBackPressed()
        }

        btnBuyTicket.setOnClickListener {
            val intent = BuySnackActivity.getIntent(this)
            startActivity(intent)
        }
    }

    private fun setupSeatRowListRecyclerView() {
        mSeatRowListAdapter = SeatRowListAdapter(Dummy().dummySeatList, this, this)
        rvSeatRowList.adapter = mSeatRowListAdapter
    }


    override fun onTapAddSeat(layout: View, textView: TextView, number: String) {
        layout.background = ContextCompat.getDrawable(this,R.drawable.background_add_seat)
        textView.text = number

    }

    override fun onTapRemoveSeat(view: View, textView: TextView) {
        view.background = ContextCompat.getDrawable(this,R.drawable.background_untaken_seat)
        textView.text = ""
        Toast.makeText(this,"Remove Seat", Toast.LENGTH_SHORT).show()

    }

    override fun onTapUnAvailableSeat() {
        Toast.makeText(this,"Unavailable Seat", Toast.LENGTH_SHORT).show()
    }


}