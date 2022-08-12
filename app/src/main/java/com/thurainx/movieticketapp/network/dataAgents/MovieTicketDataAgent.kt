package com.thurainx.movieticketapp.network.dataAgents

import com.thurainx.movieticketapp.data.vos.ActorVO
import com.thurainx.movieticketapp.data.vos.GenreVO
import com.thurainx.movieticketapp.data.vos.MovieVO
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