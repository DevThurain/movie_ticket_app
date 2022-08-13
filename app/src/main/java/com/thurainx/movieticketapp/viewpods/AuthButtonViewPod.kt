package com.thurainx.movieticketapp.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.thurainx.movieticketapp.activities.HomeActivity
import com.thurainx.movieticketapp.delegates.AuthDelegate
import com.thurainx.movieticketapp.delegates.ConfirmDelegate
import kotlinx.android.synthetic.main.viewpod_login_button.view.*

class AuthButtonViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {

    lateinit var mConfirmDelegate: ConfirmDelegate

    override fun onFinishInflate() {
        super.onFinishInflate()
    }

    fun setupAuthButtonViewPod(delegate: ConfirmDelegate){
        mConfirmDelegate = delegate
        setupListeners()
    }

    private fun setupListeners() {
        btnConfirm.setOnClickListener {
            mConfirmDelegate.onTapConfirm()
        }
    }





}