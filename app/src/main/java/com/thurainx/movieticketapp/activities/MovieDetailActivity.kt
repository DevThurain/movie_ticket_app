package com.thurainx.movieticketapp.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.snackbar.Snackbar
import com.thurainx.movieticketapp.R
import com.thurainx.movieticketapp.adaptors.CastListAdapter
import com.thurainx.movieticketapp.data.EXTRA_MOVIE_ID
import com.thurainx.movieticketapp.data.models.MovieTicketModelImpl
import com.thurainx.movieticketapp.data.vos.MovieVO
import com.thurainx.movieticketapp.network.IMAGE_BASED_URL
import kotlinx.android.synthetic.main.activity_buy_snack.*
import kotlinx.android.synthetic.main.activity_movie_detail.*
import kotlinx.android.synthetic.main.view_holder_cast.view.*
import kotlinx.android.synthetic.main.view_holder_movie.*
import kotlin.time.Duration

class MovieDetailActivity : AppCompatActivity() {
    companion object {
        fun getIntent(context: Context, movieId: Int?): Intent {
            val intent = Intent(context, MovieDetailActivity::class.java)
            intent.putExtra(EXTRA_MOVIE_ID, movieId)
            return intent
        }
    }

    lateinit var mCastListAdapter: CastListAdapter
    val mMovieTicketModel = MovieTicketModelImpl
    var mMovieId: Int = 0
    var movieName: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        setUpCastRecyclerView()
        setUpListeners()

        mMovieId = intent.getIntExtra(EXTRA_MOVIE_ID, 0)
        fetchData(mMovieId)
    }

    private fun fetchData(movieId: Int) {
        mMovieTicketModel.getMovieDetailById(
            id = movieId.toString(),
            onSuccess = { movie ->
                bindData(movie)
            },
            onFail = { errorMessage ->
                Snackbar.make(window.decorView,errorMessage, Snackbar.LENGTH_SHORT).show()
            }
        )

    }

    private fun bindData(movie: MovieVO) {
        movieName = movie.originalTitle.toString()
        toolBarLayoutMovieDetail.title = movie.originalTitle
        Glide.with(this)
            .load(IMAGE_BASED_URL.plus(movie.posterPath))
            .centerCrop()
            .into(ivMovieDetailCover)

        tvMovieDetailName.text = movie.originalTitle
        mCastListAdapter.setNewData(actorList = movie.casts ?: listOf())

        tvMovieDetailDuration.text = movie.runtime.toString()
        rbMovieDetail.rating = movie.getVotingBasedOnFiveStars()
        movie.genres?.forEach { genre ->
            chipGroupMovieDetail.addChip(this, genre)
        }
        tvPlot.text = movie.overview

    }

    private fun setUpListeners() {

        btnGetTicket.setOnClickListener {
            val intent = ChooseCinemaActivity.getIntent(
                context = this,
                movieId = mMovieId,
                movieName = movieName
            )
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

    fun ChipGroup.addChip(context: Context, label: String) {
        Chip(context).apply {
            id = View.generateViewId()
            text = label
            isClickable = true
            isCheckable = false
            isCheckedIconVisible = false
            isFocusable = true
            addView(this)
        }
    }
}