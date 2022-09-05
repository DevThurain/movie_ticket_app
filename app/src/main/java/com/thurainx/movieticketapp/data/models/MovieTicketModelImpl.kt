package com.thurainx.movieticketapp.data.models

import android.content.Context
import android.util.Log
import com.thurainx.movieticketapp.data.MovieSeatVO
import com.thurainx.movieticketapp.data.vos.*
import com.thurainx.movieticketapp.network.dataAgents.MovieTicketDataAgent
import com.thurainx.movieticketapp.network.dataAgents.RetrofitDataAgentImpl
import com.thurainx.movieticketapp.persistence.MovieTicketDatabase

object MovieTicketModelImpl : MovieTicketModel {

    var token: String? = null

    /* Data Agent */
    private val mMovieTicketDataAgent: MovieTicketDataAgent = RetrofitDataAgentImpl

    /* Database */
    var mMovieTicketDatabase: MovieTicketDatabase? = null

    fun initDatabase(context: Context) {
        mMovieTicketDatabase = MovieTicketDatabase.getDBInstant(context)
        Log.d("saved_token", "saved token -> $token")
        insertToken()
    }


    override fun registerWithEmail(
        name: String,
        phone: String,
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFail: (String) -> Unit
    ) {
        mMovieTicketDataAgent.registerWithEmail(
            name = name,
            phone = phone,
            email = email,
            password = password,
            onSuccess = { userInfoResponse ->
                userInfoResponse.data?.let { user ->
                    user.token = "Bearer ".plus(userInfoResponse.token)
                    mMovieTicketDatabase?.userDao()?.insertUser(user)
                    insertToken()
                    onSuccess()
                }
            },
            onFail = onFail
        )

    }

    override fun loginWithEmail(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFail: (String) -> Unit
    ) {
        mMovieTicketDataAgent.loginWithEmail(
            email = email,
            password = password,
            onSuccess = { userInfoResponse ->
                userInfoResponse.data?.let { user ->
                    user.token = "Bearer ".plus(userInfoResponse.token)
                    mMovieTicketDatabase?.userDao()?.insertUser(user)
                    insertToken()
                    onSuccess()
                }
            },
            onFail = onFail
        )
    }

    override fun getProfile(
        onSuccess: (UserVO) -> Unit,
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
        Log.d("logout","token -> $token")
        token?.let {
            mMovieTicketDataAgent.logOut(
                token = it,
                onSuccess = { message ->
                    token = null
                    mMovieTicketDatabase?.userDao()?.deleteUser()
                    onSuccess(message)
                },
                onFail = onFail
            )
        }
    }

    fun insertToken(){
        token = mMovieTicketDatabase?.userDao()?.getUser()?.token
    }


}