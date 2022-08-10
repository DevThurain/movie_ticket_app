package com.thurainx.movieticketapp.delegates

interface AuthDelegate {
    fun onTapRegister(name: String, email: String, phone: String, password: String)
    fun onTapLogin(email: String, password: String)
    fun onTapFacebook()
    fun onTapGoogle()
}