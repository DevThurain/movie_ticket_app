package com.thurainx.movieticketapp.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.thurainx.movieticketapp.R
import com.thurainx.movieticketapp.adaptors.AuthViewPagerAdapter
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {
    companion object{
        fun getIntent(context: Context) : Intent{
            return Intent(context,WelcomeActivity::class.java)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        setUpAuthTabLayout()
        setUpAuthViewPager()
        setUpListeners()
    }

    private fun setUpListeners() {
        btnConfirm.setOnClickListener {
            val intent = HomeActivity.getIntent(this)
            startActivity(intent)
        }
    }

    private fun setUpAuthTabLayout() {
        tabLayoutAuth.addOnTabSelectedListener(
            object : TabLayout.OnTabSelectedListener{
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    viewPagerAuth.currentItem = tab!!.position
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {}

                override fun onTabReselected(tab: TabLayout.Tab?) {}

            }
        )
    }

    private fun setUpAuthViewPager() {
        val adapter = AuthViewPagerAdapter(this)
        viewPagerAuth.adapter = adapter

        viewPagerAuth.registerOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    tabLayoutAuth.getTabAt(position)?.select()
                }
            }
        )
    }
}