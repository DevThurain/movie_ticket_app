package com.thurainx.movieticketapp.data.models

import com.thurainx.movieticketapp.data.MovieSeatVO
import com.thurainx.movieticketapp.data.vos.*

interface MovieTicketModel {

    fun registerWithEmail(
        name: String,
        phone: String,
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFail : (String) -> Unit
    )
    fun loginWithEmail(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFail : (String) -> Unit
    )

    fun getCards(
        onSuccess : (List<CardVO>) -> Unit,
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

    fun getSnackList(
        onSuccess : (List<SnackVO>) -> Unit,
        onFail : (String) -> Unit
    )

    fun getPaymentMethodList(
        onSuccess : (List<PaymentMethodVO>) -> Unit,
        onFail : (String) -> Unit
    )

    fun createCard(
        cardNumber: String,
        cardHolder: String,
        expirationDate: String,
        cvc: String,
        onSuccess : (List<CardVO>) -> Unit,
        onFail : (String) -> Unit
    )

    fun checkout(
        checkoutString: CheckOutVO,
        onSuccess : (ReceiptVO) -> Unit,
        onFail : (String) -> Unit
    )

    fun logOut(
        onSuccess : (String) -> Unit,
        onFail : (String) -> Unit
    )
}