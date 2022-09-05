package com.thurainx.movieticketapp.network.dataAgents

import com.thurainx.movieticketapp.data.MovieSeatVO
import com.thurainx.movieticketapp.data.vos.*
import com.thurainx.movieticketapp.network.response.UserInfoResponse

interface MovieTicketDataAgent {
    fun registerWithEmail(
        name: String,
        phone: String,
        email: String,
        password: String,
        onSuccess : (UserInfoResponse) -> Unit,
        onFail : (String) -> Unit
    )
    fun loginWithEmail(
        email: String,
        password: String,
        onSuccess : (UserInfoResponse) -> Unit,
        onFail : (String) -> Unit
    )

    fun getProfile(
        token: String,
        onSuccess : (UserVO) -> Unit,
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

    fun createCard(
        token: String,
        cardNumber: String,
        cardHolder: String,
        expirationDate: String,
        cvc: String,
        onSuccess : (List<CardVO>) -> Unit,
        onFail : (String) -> Unit
    )

    fun checkOut(
        token: String,
        checkoutString: CheckOutVO,
        onSuccess : (ReceiptVO) -> Unit,
        onFail : (String) -> Unit
    )

    fun logOut(
        token: String,
        onSuccess : (String) -> Unit,
        onFail : (String) -> Unit
    )



}