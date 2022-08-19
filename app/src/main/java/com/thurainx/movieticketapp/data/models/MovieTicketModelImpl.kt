package com.thurainx.movieticketapp.data.models

import android.util.Log
import com.thurainx.movieticketapp.data.MovieSeatVO
import com.thurainx.movieticketapp.data.vos.*
import com.thurainx.movieticketapp.network.dataAgents.MovieTicketDataAgent
import com.thurainx.movieticketapp.network.dataAgents.RetrofitDataAgentImpl
import com.thurainx.movieticketapp.network.response.CheckoutResponse
import com.thurainx.movieticketapp.network.response.TokenResponse

object MovieTicketModelImpl : MovieTicketModel {

    private val mMovieTicketDataAgent: MovieTicketDataAgent = RetrofitDataAgentImpl

    //    var token: String? = null
    private var token: String? = "Bearer 7347|Kz8YzSCzMY7StU7H8gPxkTQ1YDHMpkbeZUtKfg1I"

    override fun registerWithEmail(
        name: String,
        phone: String,
        email: String,
        password: String,
        onSuccess: (ProfileVO) -> Unit,
        onFail: (String) -> Unit
    ) {
        mMovieTicketDataAgent.registerWithEmail(
            name = name,
            phone = phone,
            email = email,
            password = password,
            onSuccess = {
                saveToken(it.token ?: "")
                it.data?.let(onSuccess)
            },
            onFail = onFail
        )

    }

    override fun loginWithEmail(
        email: String,
        password: String,
        onSuccess: (ProfileVO) -> Unit,
        onFail: (String) -> Unit
    ) {
        mMovieTicketDataAgent.loginWithEmail(
            email = email,
            password = password,
            onSuccess = {
                saveToken(it.token ?: "")
                it.data?.let(onSuccess)
            },
            onFail = onFail
        )
    }

    override fun getProfile(
        onSuccess: (ProfileVO) -> Unit,
        onFail: (String) -> Unit
    ) {
        token?.let {
            mMovieTicketDataAgent.getProfile(it, onSuccess, onFail)
        }
    }


    override fun getMovieListByStatus(
        status: String,
        onSuccess: (List<MovieVO>) -> Unit,
        onFail: (String) -> Unit
    ) {
        mMovieTicketDataAgent.getMovieListByStatus(
            status = status,
            onSuccess = onSuccess,
            onFail = onFail
        )
    }

    override fun getMovieDetailById(
        id: String,
        onSuccess: (MovieVO) -> Unit,
        onFail: (String) -> Unit
    ) {
        mMovieTicketDataAgent.getMovieDetailById(id = id, onSuccess = onSuccess, onFail = onFail)
    }

    override fun getCinemaList(
        movieId: String,
        date: String,
        onSuccess: (List<CinemaVO>) -> Unit,
        onFail: (String) -> Unit
    ) {
        token?.let {
            mMovieTicketDataAgent.getCinemaList(
                token = it,
                movieId = movieId,
                date = date,
                onSuccess = onSuccess,
                onFail = onFail
            )
        }

    }

    override fun getSeatingPlan(
        timeSlotId: String,
        bookingDate: String,
        onSuccess: (List<MovieSeatVO>) -> Unit,
        onFail: (String) -> Unit
    ) {
        token?.let {
            mMovieTicketDataAgent.getSeatingPlan(
                token = it,
                timeSlotId = timeSlotId,
                bookingDate = bookingDate,
                onSuccess = { seatList ->
                    val movieSeatList = seatList.flatten()
                    onSuccess(movieSeatList)
                },
                onFail = onFail
            )
        }
    }

    override fun getSnackList(
        onSuccess: (List<SnackVO>) -> Unit,
        onFail: (String) -> Unit
    ) {
        MovieTicketModelImpl.token?.let {
            mMovieTicketDataAgent.getSnackList(it, onSuccess, onFail)
        }
    }

    override fun getPaymentMethodList(
        onSuccess: (List<PaymentMethodVO>) -> Unit,
        onFail: (String) -> Unit
    ) {
        MovieTicketModelImpl.token?.let {
            mMovieTicketDataAgent.getPaymentMethodList(it, onSuccess, onFail)
        }
    }

    override fun createCard(
        cardNumber: String,
        cardHolder: String,
        expirationDate: String,
        cvc: String,
        onSuccess: (List<CardVO>) -> Unit,
        onFail: (String) -> Unit
    ) {
        token?.let {
            mMovieTicketDataAgent.createCard(
                token = it,
                cardNumber = cardNumber,
                cardHolder = cardHolder,
                expirationDate = expirationDate,
                cvc = cvc,
                onSuccess = onSuccess,
                onFail = onFail
            )
        }
    }

    override fun checkout(
        checkoutString: CheckOutVO,
        onSuccess: (ReceiptVO) -> Unit,
        onFail: (String) -> Unit
    ) {
        token?.let {
            mMovieTicketDataAgent.checkOut(
                token = it,
                checkoutString = checkoutString,
                onSuccess = onSuccess,
                onFail = onFail
            )
        }
    }

    override fun logOut(onSuccess: (String) -> Unit, onFail: (String) -> Unit) {
        token?.let {
            mMovieTicketDataAgent.logOut(
                token = it,
                onSuccess = {
                    token = null
                    onSuccess(it)
                },
                onFail = onFail
            )
        }
    }

    private fun saveToken(value: String) {
        token = "Bearer ".plus(value)
    }

    fun deleteToken() {
        token = null
    }


}