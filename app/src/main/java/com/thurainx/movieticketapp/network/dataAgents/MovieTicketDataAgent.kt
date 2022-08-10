package com.thurainx.movieticketapp.network.dataAgents

interface MovieTicketDataAgent {
    fun registerWithEmail(name: String, phone: String, email: String,password: String)
    fun loginWithEmail(email: String, password: String)
}