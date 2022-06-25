package com.thurainx.movieticketapp.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.thurainx.movieticketapp.activities.HomeActivity
import kotlinx.android.synthetic.main.viewpod_login_button.view.*

class LoginButtonViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {

    override fun onFinishInflate() {
        super.onFinishInflate()
        setupListeners()
    }

    private fun setupListeners() {
        btnConfirm.setOnClickListener {
            val intent = HomeActivity.getIntent(context)
            context.startActivity(intent)
        }
    }

}