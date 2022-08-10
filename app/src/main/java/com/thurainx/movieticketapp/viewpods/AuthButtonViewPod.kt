package com.thurainx.movieticketapp.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.thurainx.movieticketapp.activities.HomeActivity
import com.thurainx.movieticketapp.delegates.AuthDelegate
import kotlinx.android.synthetic.main.viewpod_login_button.view.*

class AuthButtonViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {

    lateinit var mAuthDelegate: AuthDelegate
    var name: String = ""
    var phone: String = ""
    var email: String = ""
    var password: String = ""

    override fun onFinishInflate() {
        super.onFinishInflate()
    }

    fun setDelegate(delegate: AuthDelegate){
        mAuthDelegate = delegate
    }

    fun setupRegister() {
        btnConfirm.setOnClickListener {
            mAuthDelegate.onTapRegister(name = name, phone = phone, email = email, password = password)
        }
    }

    fun setupLogin(){
        btnConfirm.setOnClickListener {
            mAuthDelegate.onTapLogin(email = email, password = password)
        }
    }

}