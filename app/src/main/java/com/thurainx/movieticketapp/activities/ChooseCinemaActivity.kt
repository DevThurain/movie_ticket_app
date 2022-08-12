package com.thurainx.movieticketapp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.thurainx.movieticketapp.R
import com.thurainx.movieticketapp.adaptors.CinemaListAdapter
import com.thurainx.movieticketapp.adaptors.DateListAdapter
import com.thurainx.movieticketapp.data.vos.DayVO
import com.thurainx.movieticketapp.delegates.DateDelegate
import com.thurainx.movieticketapp.delegates.DayDelegate
import com.thurainx.movieticketapp.delegates.TimeDelegate
import com.thurainx.movieticketapp.models.CinemaData
import com.thurainx.movieticketapp.models.Dummy
import com.thurainx.movieticketapp.utils.DateUtils
import kotlinx.android.synthetic.main.activity_choose_cinema.*


class ChooseCinemaActivity : AppCompatActivity(), DayDelegate, TimeDelegate {
    companion object{
        fun getIntent(context: Context) : Intent {
            return Intent(context,ChooseCinemaActivity::class.java)
        }
    }
    lateinit var mDateListAdapter: DateListAdapter
    lateinit var mCinemaListAdapter: CinemaListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_cinema)

        setupListeners()
        setupRecyclerView()

    }

    private fun setupRecyclerView() {
        mDateListAdapter = DateListAdapter(dayDelegate = this, context = this)
        rvDateList.adapter = mDateListAdapter

        mCinemaListAdapter = CinemaListAdapter(cinemaDataList = Dummy().dummyCinemaList, timeDelegate = this)
        rvCinemaList.adapter = mCinemaListAdapter

    }

    private fun setupListeners() {
        ivChooseCinemaBack.setOnClickListener {
            super.onBackPressed()
        }

        btnChooseCinemaNext.setOnClickListener {
            val intent = ChooseSeatActivity.getIntent(this)
            startActivity(intent)
        }
    }

    override fun onTapDay(day: DayVO) {
        var dayList = ArrayList(DateUtils().getNextTwoWeekDates())
        var mIndex = 0


        dayList.forEachIndexed { index, dayVO ->
            if(dayVO.formatDay == day.formatDay){
                mIndex = index

            }
        }
        mDateListAdapter.updateData(mIndex)

    }


    override fun onTapTime() {
        TODO("Not yet implemented")
    }


}