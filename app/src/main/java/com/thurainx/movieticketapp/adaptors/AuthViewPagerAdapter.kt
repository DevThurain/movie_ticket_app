package com.thurainx.movieticketapp.adaptors

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.thurainx.movieticketapp.fragments.LoginFragment
import com.thurainx.movieticketapp.fragments.SingUpFragment

class AuthViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> LoginFragment()
            else -> SingUpFragment()
        }
    }
}