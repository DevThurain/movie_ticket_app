package com.thurainx.movieticketapp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.thurainx.movieticketapp.R
import com.thurainx.movieticketapp.adaptors.CinemaListAdapter
import com.thurainx.movieticketapp.adaptors.DateListAdapter
import com.thurainx.movieticketapp.data.models.MovieTicketModelImpl
import com.thurainx.movieticketapp.data.vos.CinemaVO
import com.thurainx.movieticketapp.data.vos.DayVO
import com.thurainx.movieticketapp.data.vos.TimeSlotVO
import com.thurainx.movieticketapp.delegates.DayDelegate
import com.thurainx.movieticketapp.delegates.TimeSlotDelegate
import com.thurainx.movieticketapp.models.Dummy
import com.thurainx.movieticketapp.utils.DateUtils
import com.thurainx.movieticketapp.utils.toApiDateFormat
import kotlinx.android.synthetic.main.activity_choose_cinema.*


class ChooseCinemaActivity : AppCompatActivity(), DayDelegate, TimeSlotDelegate {
    companion object {
        fun getIntent(context: Context, movieId: Int): Intent {
            val intent = Intent(context, ChooseCinemaActivity::class.java)
            intent.putExtra(MOVIE_ID, movieId)
            return intent
        }
    }

    lateinit var mDateListAdapter: DateListAdapter
    lateinit var mCinemaListAdapter: CinemaListAdapter
    val mMovieTicketModel = MovieTicketModelImpl
    var mDayList: List<DayVO> = listOf()
    var mCinemaList: List<CinemaVO> = listOf()
    var mMovieId: Int? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_cinema)

        mDayList = ArrayList(DateUtils().getNextTwoWeekDates())
        mMovieId = intent.getIntExtra(MOVIE_ID, 0)

        setupListeners()
        setupRecyclerView()
        fetchData()


    }

    private fun fetchData() {
        getCinemaListByDate(date = mDayList.first().rawDate?.toApiDateFormat() ?: "")

    }

    private fun getCinemaListByDate(date: String) {
        Toast.makeText(this, date, Toast.LENGTH_SHORT).show()


        mMovieTicketModel.getCinemaList(
            token = mMovieTicketModel.token ?: "",
            movieId = mMovieId.toString(),
            date = date,
            onSuccess = { cinemaList ->
                mCinemaList = cinemaList
                mCinemaList.first().timeslots?.first()?.isSelected = true
                mCinemaListAdapter.setNewData(cinemaList = cinemaList)
            },
            onFail = { errorMessage ->
                Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
            }
        )
    }

    private fun setupRecyclerView() {
        mDayList.first().isSelected = true
        mDateListAdapter = DateListAdapter(dayDelegate = this, context = this, dayList = mDayList)
        rvDateList.adapter = mDateListAdapter

        mCinemaListAdapter = CinemaListAdapter(timeSlotDelegate = this)
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
        var newDayList = DateUtils().getNextTwoWeekDates()

        newDayList.forEachIndexed { index, dayVO ->
            if (dayVO.formatDay == day.formatDay) {
                dayVO.isSelected = true
            }
        }
        mDateListAdapter.updateData(newDayList)
        getCinemaListByDate(date = day.rawDate?.toApiDateFormat() ?: "")
    }

    override fun onTapTimeSlot(timeSlotVO: TimeSlotVO) {

        mCinemaList.forEach {
            it.timeslots?.forEach { timeVO ->
                timeVO.isSelected = timeVO.cinemaDayTimeSlotId == timeSlotVO.cinemaDayTimeSlotId
            }
        }

        mCinemaListAdapter.setNewData(mCinemaList)



    }


}