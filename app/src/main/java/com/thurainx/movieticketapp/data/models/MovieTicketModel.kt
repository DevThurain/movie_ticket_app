package com.thurainx.movieticketapp.data.models

import com.thurainx.movieticketapp.data.vos.ActorVO
import com.thurainx.movieticketapp.data.vos.GenreVO
import com.thurainx.movieticketapp.data.vos.MovieVO

interface MovieTicketModel {

    fun registerWithEmail(name: String, phone: String, email: String,password: String)
    fun loginWithEmail(email: String, password: String)

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