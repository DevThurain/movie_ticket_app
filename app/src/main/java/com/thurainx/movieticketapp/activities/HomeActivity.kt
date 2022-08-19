package com.thurainx.movieticketapp.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Window
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.ContentInfoCompat
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.thurainx.movieticketapp.R
import com.thurainx.movieticketapp.data.models.MovieTicketModelImpl
import com.thurainx.movieticketapp.data.vos.ProfileVO
import com.thurainx.movieticketapp.delegates.MovieDelegate
import com.thurainx.movieticketapp.network.BASED_URL
import com.thurainx.movieticketapp.network.STATUS_COMING_SOON
import com.thurainx.movieticketapp.network.STATUS_CURRENT
import com.thurainx.movieticketapp.viewpods.MovieListViewPod
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.view_drawer.*

class HomeActivity : AppCompatActivity(), MovieDelegate {
    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, HomeActivity::class.java)
        }
    }

    lateinit var nowShowingMovieViewPod: MovieListViewPod
    lateinit var comingSoonMovieViewPod: MovieListViewPod

    val mMovieTicketModel = MovieTicketModelImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setupStatusBar()
        setupListeners()
        setupViewPods()
        fetchData()

    }


    private fun fetchData() {

        mMovieTicketModel.getMovieListByStatus(
            status = STATUS_CURRENT,
            onSuccess = { movieList ->
                nowShowingMovieViewPod.setData(movieList = movieList)
            },
            onFail = { errorMessage ->
                Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
            }
        )

        mMovieTicketModel.getMovieListByStatus(
            status = STATUS_COMING_SOON,
            onSuccess = { movieList ->
                comingSoonMovieViewPod.setData(movieList = movieList)
            },
            onFail = { errorMessage ->
                Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
            }
        )

        mMovieTicketModel.getProfile(
            onSuccess = { profile ->
                bindProfile(profile)
            },
            onFail = { errorMessage ->
                Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
            }
        )

    }

    private fun bindProfile(profile: ProfileVO) {

        Glide.with(this)
            .load(BASED_URL + profile.profileImage)
            .into(ivProfile)

        Glide.with(this)
            .load(BASED_URL + profile.profileImage)
            .centerCrop()
            .into(ivDrawerProfile)

        tvGreeting.text = "Hi ${profile.name}!"
        tvDrawerName.text = profile.name
        tvDrawerEmail.text = profile.email
    }

    private fun setupViewPods() {
        nowShowingMovieViewPod = vpNowShowing as MovieListViewPod
        nowShowingMovieViewPod.setUpMovieListViewPod(
            title = getString(R.string.lbl_now_showing),
            delegate = this
        )

        comingSoonMovieViewPod = vpComingSoon as MovieListViewPod
        comingSoonMovieViewPod.setUpMovieListViewPod(
            title = getString(R.string.lbl_coming_soon),
            delegate = this
        )
    }

    private fun setupListeners() {
        ivMenu.setOnClickListener {
            mDrawerLayout.openDrawer(Gravity.LEFT)
        }

        llLogOut.setOnClickListener {
            mMovieTicketModel.logOut(
                onSuccess = { message ->
                    val intent = WelcomeActivity.getIntent(this)
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    startActivity(intent)
                },
                onFail = { errorMessage ->
                    Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
                }
            )
        }
    }

    private fun setupStatusBar() {
        mDrawerLayout.setStatusBarBackgroundColor(ContextCompat.getColor(this, R.color.white))
    }

    override fun onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(Gravity.LEFT)) {
            mDrawerLayout.closeDrawer(Gravity.LEFT)
        } else {
            super.onBackPressed()
        }
    }

    override fun onTapMovie(movieId: Int?) {
        val intent = MovieDetailActivity.getIntent(this, movieId)
        startActivity(intent)
    }


}