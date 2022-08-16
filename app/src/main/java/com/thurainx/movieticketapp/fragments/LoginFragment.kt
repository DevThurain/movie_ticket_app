package com.thurainx.movieticketapp.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import com.thurainx.movieticketapp.R
import com.thurainx.movieticketapp.delegates.AuthDelegate
import com.thurainx.movieticketapp.delegates.ConfirmDelegate
import com.thurainx.movieticketapp.utils.validateEmail
import com.thurainx.movieticketapp.utils.validateEmpty
import com.thurainx.movieticketapp.viewpods.AuthButtonViewPod
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.view.*


class LoginFragment : Fragment(),ConfirmDelegate {

    lateinit var mAuthDelegate : AuthDelegate
    private lateinit var mLoginButtonViewPod: AuthButtonViewPod
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mAuthDelegate = context as AuthDelegate
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mLoginButtonViewPod = view.viewPodLoginButton as AuthButtonViewPod
        mLoginButtonViewPod.setupAuthButtonViewPod(this)


    }

    override fun onTapConfirm() {
        val validEmail = edtLoginEmail.validateEmail()
        val validPassword = edtLoginPassword.validateEmpty(errorMessage = context?.getString(R.string.lbl_empty_password) ?: "")
       if(validEmail && validPassword){
           mAuthDelegate.onTapLogin(email = edtLoginEmail.text.toString(), password = edtLoginPassword.text.toString())
       }
    }


}