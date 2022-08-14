package com.thurainx.movieticketapp.data.models

import com.thurainx.movieticketapp.data.MovieSeatVO
import com.thurainx.movieticketapp.data.vos.*
import com.thurainx.movieticketapp.network.response.TokenResponse

interface MovieTicketModel {

    fun registerWithEmail(
        name: String,
        phone: String,
        email: String,
        password: String,
        onSuccess: (ProfileVO) -> Unit,
        onFail : (String) -> Unit
    )
    fun loginWithEmail(
        email: String,
        password: String,
        onSuccess: (ProfileVO) -> Unit,
        onFail : (String) -> Unit
    )

    fun getProfile(
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
        movieId: String,
        date: String,
        onSuccess : (List<CinemaVO>) -> Unit,
        onFail : (String) -> Unit
    )

    fun getSeatingPlan(
        timeSlotId: String,
        bookingDate: String,
        onSuccess : (List<MovieSeatVO>) -> Unit,
        onFail : (String) -> Unit
    )
}