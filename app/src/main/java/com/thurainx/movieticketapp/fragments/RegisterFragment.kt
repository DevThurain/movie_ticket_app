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
import com.thurainx.movieticketapp.utils.validateEmail
import com.thurainx.movieticketapp.utils.validateEmpty
import com.thurainx.movieticketapp.utils.validatePhone
import com.thurainx.movieticketapp.viewpods.AuthButtonViewPod
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.view.*
import kotlinx.android.synthetic.main.fragment_register.*
import kotlinx.android.synthetic.main.fragment_register.view.*

class RegisterFragment : Fragment() {

    lateinit var mAuthDelegate : AuthDelegate
    private lateinit var mRegisterButtonViewPod: AuthButtonViewPod
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
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mRegisterButtonViewPod = view.viewPodRegisterButton as AuthButtonViewPod
        mRegisterButtonViewPod.setDelegate(mAuthDelegate)
        mRegisterButtonViewPod.setupRegister()

        edtRegisterName.doOnTextChanged { text, start, before, count ->
            mRegisterButtonViewPod.name = text.toString()
            edtRegisterName.validateEmpty(text = text.toString(), message = "name cannot be empty")
        }
        edtRegisterPhone.doOnTextChanged { text, start, before, count ->
            mRegisterButtonViewPod.phone = text.toString()
            edtRegisterPhone.validatePhone(text = text.toString())
        }
        edtRegisterEmail.doOnTextChanged { text, start, before, count ->
            mRegisterButtonViewPod.email = text.toString()
            edtRegisterEmail.validateEmail(text = text.toString())

        }
        edtRegisterPassword.doOnTextChanged { text, start, before, count ->
            mRegisterButtonViewPod.password = text.toString()
            edtRegisterPassword.validateEmpty(text = text.toString(), message = "password cannot be empty")

        }


    }

}