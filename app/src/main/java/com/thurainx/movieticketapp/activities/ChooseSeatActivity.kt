package com.thurainx.movieticketapp.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.thurainx.movieticketapp.R
import com.thurainx.movieticketapp.adaptors.MovieSeatListAdapter
import com.thurainx.movieticketapp.data.*
import com.thurainx.movieticketapp.data.models.MovieTicketModelImpl
import com.thurainx.movieticketapp.data.vos.DayVO
import com.thurainx.movieticketapp.delegates.SeatDelegate
import com.thurainx.movieticketapp.models.Dummy
import com.thurainx.movieticketapp.utils.toCinemaDisplayDateFormat
import kotlinx.android.synthetic.main.activity_choose_seat.*

class ChooseSeatActivity : AppCompatActivity(), SeatDelegate{
    companion object{
        fun getIntent(context: Context,movieName: String,rawDate: String,time: String,cinemaName: String) : Intent {
            val intent = Intent(context,ChooseSeatActivity::class.java)
            intent.putExtra(EXTRA_MOVIE_NAME,movieName)
            intent.putExtra(EXTRA_CINEMA_NAME, cinemaName)
            intent.putExtra(EXTRA_DATE, rawDate)
            intent.putExtra(EXTRA_TIME, time)

            return intent
        }
    }
    lateinit var mMovieSeatListAdapter: MovieSeatListAdapter
    val mMovieTicketModel = MovieTicketModelImpl
    var allSeatList : List<MovieSeatVO> = emptyList()
    var selectedSeatList : MutableList<MovieSeatVO> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_seat)

        bindData()
        setupListeners()
        setupRecyclerView()
        fetchData()
    }

    private fun bindData(){
        tvChooseSeatMovieName.text = intent.getStringExtra(EXTRA_MOVIE_NAME)
        tvCinemaName.text = intent.getStringExtra(EXTRA_CINEMA_NAME)
        val time = intent.getStringExtra(EXTRA_TIME)
        tvChooseSeatDate.text = intent.getStringExtra(EXTRA_DATE)?.toCinemaDisplayDateFormat().plus(" $time")

    }

    private fun fetchData() {
        mMovieTicketModel.getSeatingPlan(
            timeSlotId = "1",
            bookingDate = "2021-6-28",
            onSuccess = { movieSeatList ->
                allSeatList = movieSeatList
                mMovieSeatListAdapter.setNewData(movieSeatList)
            },
            onFail = { errorMessage ->
                Toast.makeText(this,errorMessage, Toast.LENGTH_SHORT).show()
            }
        )
    }

    private fun setupRecyclerView() {
        val layoutManager = GridLayoutManager(this,14)
        mMovieSeatListAdapter = MovieSeatListAdapter(this)
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

    override fun onTapSeat(seatVO: MovieSeatVO) {
        allSeatList.forEach {
            if(it.id == seatVO.id && it.symbol == seatVO.symbol && it.isMovieSeatAvailable()){
                it.isSelected = !it.isSelected
                if(it.isSelected){
                    selectedSeatList.add(it)
                }else{
                    selectedSeatList.remove(it)
                }
                updateSeatData()
            }
        }


    }

    fun updateSeatData(){
        mMovieSeatListAdapter.setNewData(allSeatList)
        tvSeats.text = selectedSeatList.map { it -> it.symbol.plus("-"+it.id) }.toList().joinToString(separator = ", ")
        tvTicketCount.text = selectedSeatList.size.toString()
        val totalSeatPrice = selectedSeatList.sumOf { it.price ?: 0 }
        btnBuyTicket.text = "Buy Tickets for \$$totalSeatPrice"
    }
}