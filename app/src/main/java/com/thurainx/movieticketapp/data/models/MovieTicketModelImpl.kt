package com.thurainx.movieticketapp.data.models

import com.thurainx.movieticketapp.data.vos.ActorVO
import com.thurainx.movieticketapp.data.vos.GenreVO
import com.thurainx.movieticketapp.data.vos.MovieVO
import com.thurainx.movieticketapp.network.dataAgents.MovieTicketDataAgent
import com.thurainx.movieticketapp.network.dataAgents.RetrofitDataAgentImpl

object MovieTicketModelImpl : MovieTicketModel {

    private val mMovieTicketDataAgent : MovieTicketDataAgent = RetrofitDataAgentImpl
    override fun registerWithEmail(name: String, phone: String, email: String, password: String) {
        TODO("Not yet implemented")
    }

    override fun loginWithEmail(email: String, password: String) {
        TODO("Not yet implemented")
    }

    override fun getMovieListByStatus(
        status: String,
        onSuccess: (List<MovieVO>) -> Unit,
        onFail: (String) -> Unit
    ) {
        mMovieTicketDataAgent.getMovieListByStatus(status = status,onSuccess= onSuccess, onFail= onFail)
    }

    override fun getMovieDetailById(
        id: String,
        onSuccess: (MovieVO) -> Unit,
        onFail: (String) -> Unit
    ) {
        mMovieTicketDataAgent.getMovieDetailById(id = id,onSuccess= onSuccess, onFail= onFail)
    }



}