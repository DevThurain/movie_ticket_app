package com.thurainx.movieticketapp.data.models

import com.thurainx.movieticketapp.data.vos.ActorVO
import com.thurainx.movieticketapp.data.vos.GenreVO
import com.thurainx.movieticketapp.data.vos.MovieVO
import com.thurainx.movieticketapp.data.vos.ProfileVO
import com.thurainx.movieticketapp.network.response.TokenResponse

interface MovieTicketModel {

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
}