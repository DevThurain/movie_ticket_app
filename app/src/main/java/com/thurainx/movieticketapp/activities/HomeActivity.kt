package com.thurainx.movieticketapp.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import androidx.core.content.ContextCompat
import com.thurainx.movieticketapp.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    companion object{
        fun getIntent(context: Context) : Intent {
            return Intent(context,HomeActivity::class.java)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        mDrawerLayout.setStatusBarBackgroundColor(ContextCompat.getColor(this,R.color.white))

        ivMenu.setOnClickListener {
            mDrawerLayout.openDrawer(Gravity.LEFT)
        }
    }
}