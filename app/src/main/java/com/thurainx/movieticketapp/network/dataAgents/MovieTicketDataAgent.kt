package com.thurainx.movieticketapp.network.dataAgents

import com.thurainx.movieticketapp.data.MovieSeatVO
import com.thurainx.movieticketapp.data.vos.*
import com.thurainx.movieticketapp.network.response.ProfileResponse
import com.thurainx.movieticketapp.network.response.TokenResponse
import java.sql.ClientInfoStatus

interface MovieTicketDataAgent {
    fun registerWithEmail(
        name: String,
        phone: String,
        email: String,
        password: String,
        onSuccess : (TokenResponse) -> Unit,
        onFail : (String) -> Unit
    )
    fun loginWithEmail(
        email: String,
        password: String,
        onSuccess : (TokenResponse) -> Unit,
        onFail : (String) -> Unit
    )

    fun getProfile(
        token: String,
        onSuccess : (ProfileVO) -> Unit,
        onFail : (String) -> Unit
    )

    fun getMovieListByStatus(
        status: String,
        onSuccess : (List<MovieVO>) -> Unit,
        onFail : (String) -> Unit
    )

    fun getMovieDetailById(
        id: String,
        onSuccess : (MovieVO) -> Unit,
        onFail : (String) -> Unit
    )

    fun getCinemaList(
        token: String,
        movieId: String,
        date: String,
        onSuccess : (List<CinemaVO>) -> Unit,
        onFail : (String) -> Unit
    )

    fun getSeatingPlan(
        token: String,
        timeSlotId: String,
        bookingDate: String,
        onSuccess : (List<List<MovieSeatVO>>) -> Unit,
        onFail : (String) -> Unit
    )

    fun getSnackList(
        token: String,
        onSuccess : (List<SnackVO>) -> Unit,
        onFail : (String) -> Unit
    )

    fun getPaymentMethodList(
        token: String,
        onSuccess : (List<PaymentMethodVO>) -> Unit,
        onFail : (String) -> Unit
    )



}