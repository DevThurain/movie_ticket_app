package com.thurainx.movieticketapp.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.thurainx.movieticketapp.data.models.MovieTicketModelImpl

class CheckAuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mMovieTicketModel = MovieTicketModelImpl

        if(mMovieTicketModel.token.isNullOrEmpty()){
            val intent = GetStartedActivity.getIntent(this)
            startActivity(intent)
        }else{
            val intent = HomeActivity.getIntent(this)
            startActivity(intent)
        }
        finish()
    }
}