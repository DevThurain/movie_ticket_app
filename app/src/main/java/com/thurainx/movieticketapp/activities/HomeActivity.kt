package com.thurainx.movieticketapp.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import androidx.core.content.ContextCompat
import com.thurainx.movieticketapp.R
import com.thurainx.movieticketapp.delegates.MovieDelegate
import com.thurainx.movieticketapp.viewpods.MovieListViewPod
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), MovieDelegate {
    companion object{
        fun getIntent(context: Context) : Intent {
            return Intent(context,HomeActivity::class.java)
        }
    }

    lateinit var nowShowingMovieViewPod: MovieListViewPod
    lateinit var comingSoonMovieViewPod: MovieListViewPod


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setupStatusBar()
        setupListeners()
        setupViewPods()


    }

    private fun setupViewPods(){
        nowShowingMovieViewPod = vpNowShowing as MovieListViewPod
        nowShowingMovieViewPod.setUpMovieListViewPod(title = "Now Showing", delegate = this)

        comingSoonMovieViewPod = vpComingSoon as MovieListViewPod
        comingSoonMovieViewPod.setUpMovieListViewPod(title = "Coming Soon", delegate = this)
    }

    private fun setupListeners() {
        ivMenu.setOnClickListener {
            mDrawerLayout.openDrawer(Gravity.LEFT)
        }
    }

    private fun setupStatusBar() {
        mDrawerLayout.setStatusBarBackgroundColor(ContextCompat.getColor(this,R.color.white))
    }

    override fun onBackPressed() {
        if(mDrawerLayout.isDrawerOpen(Gravity.LEFT)){
            mDrawerLayout.closeDrawer(Gravity.LEFT)
        }else{
            super.onBackPressed()
        }
    }

    override fun onTapMovie() {
        val intent = MovieDetailActivity.getIntent(this)
        startActivity(intent)
    }
}