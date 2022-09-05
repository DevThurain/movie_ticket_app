package com.thurainx.movieticketapp

import android.app.Application
import com.thurainx.movieticketapp.data.models.MovieTicketModelImpl

class TheMovieTicketApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        MovieTicketModelImpl.initDatabase(applicationContext)
    }
}