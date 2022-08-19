package com.thurainx.movieticketapp.network.dataAgents

import android.util.Log
import com.thurainx.movieticketapp.data.MovieSeatVO
import com.thurainx.movieticketapp.data.vos.*
import com.thurainx.movieticketapp.network.BASED_URL
import com.thurainx.movieticketapp.network.MOVIE_BASED_URL
import com.thurainx.movieticketapp.network.TheMovieTicketApi
import com.thurainx.movieticketapp.network.response.*
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitDataAgentImpl : MovieTicketDataAgent {
    private var mTheMovieTicketApi: TheMovieTicketApi? = null

    init {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()

        val retrofitClient = Retrofit.Builder()
            .baseUrl(BASED_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        mTheMovieTicketApi = retrofitClient.create(TheMovieTicketApi::class.java)


    }

    override fun registerWithEmail(
        name: String,
        phone: String,
        email: String,
        password: String,
        onSuccess: (TokenResponse) -> Unit,
        onFail: (String) -> Unit
    ) {
        mTheMovieTicketApi?.registerWithEmail(
            name = name,
            email = email,
            phone = phone,
            password = password
        )?.enqueue(
            object : Callback<TokenResponse> {
                override fun onResponse(
                    call: Call<TokenResponse>,
                    response: Response<TokenResponse>
                ) {

                    if (response.isSuccessful) {
                        if (response.body()?.code == 201) {
                            Log.d("api_register", response.toString())
                            response.body()?.let(onSuccess)
                        } else {
                            onFail(response.body()?.message ?: "unknown error")
                        }

                    }

                }

                override fun onFailure(call: Call<TokenResponse>, t: Throwable) {
                    t.printStackTrace()
                    onFail(t.message ?: "unknown error")
                }

            }
        )
    }

    override fun loginWithEmail(
        email: String,
        password: String,
        onSuccess: (TokenResponse) -> Unit,
        onFail: (String) -> Unit
    ) {
        mTheMovieTicketApi?.loginWithEmail(email = email, password = password)?.enqueue(
            object : Callback<TokenResponse> {
                override fun onResponse(
                    call: Call<TokenResponse>,
                    response: Response<TokenResponse>
                ) {

                    if (response.isSuccessful) {
                        if (response.body()?.code == 200) {
                            Log.d("api_login", response.toString())
                            response.body()?.let(onSuccess)
                        } else {
                            onFail(response.body()?.message ?: "unknown error")
                        }

                    }

                }

                override fun onFailure(call: Call<TokenResponse>, t: Throwable) {
                    t.printStackTrace()
                    onFail(t.message ?: "unknown error")
                }

            }
        )
    }

    override fun getProfile(
        token: String,
        onSuccess: (ProfileVO) -> Unit,
        onFail: (String) -> Unit
    ) {
        mTheMovieTicketApi?.getProfile(token = token)?.enqueue(
            object : Callback<ProfileResponse> {
                override fun onResponse(
                    call: Call<ProfileResponse>,
                    response: Response<ProfileResponse>
                ) {

                    if (response.isSuccessful) {
                        if (response.body()?.code == 200) {
                            Log.d("api_profile", response.toString())
                            val responseBody = response.body()
                            responseBody?.data?.let(onSuccess)
                        } else {
                            Log.d("api_profile", "status code error")
                            onFail(response.body()?.message ?: "unknown error")
                        }

                    }

                }

                override fun onFailure(call: Call<ProfileResponse>, t: Throwable) {
                    t.printStackTrace()
                    Log.d("api_profile", t.message.toString())
                    onFail(t.message ?: "unknown error")
                }

            }
        )
    }

    override fun getMovieListByStatus(
        status: String,
        onSuccess: (List<MovieVO>) -> Unit,
        onFail: (String) -> Unit
    ) {
        mTheMovieTicketApi?.getMovieListByStatus(status = status)?.enqueue(
            object : Callback<MovieListResponse> {
                override fun onResponse(
                    call: Call<MovieListResponse>,
                    response: Response<MovieListResponse>
                ) {

                    if (response.isSuccessful) {
                        val movieList = response.body()?.data ?: listOf()
                        Log.d("api_movie_list", movieList.toString())
                        onSuccess(movieList)
                    }

                }

                override fun onFailure(call: Call<MovieListResponse>, t: Throwable) {
                    t.printStackTrace()
                    onFail(t.message ?: "unknown error")
                }

            }
        )
    }


    override fun getMovieDetailById(
        id: String,
        onSuccess: (MovieVO) -> Unit,
        onFail: (String) -> Unit
    ) {
        mTheMovieTicketApi?.getMovieDetailById(movieId = id)?.enqueue(
            object : Callback<MovieDetailResponse> {
                override fun onResponse(
                    call: Call<MovieDetailResponse>,
                    response: Response<MovieDetailResponse>
                ) {

                    if (response.isSuccessful) {
                        val movie = response.body()?.data
                        Log.d("api_movie_detail", movie.toString())
                        movie?.let(onSuccess)
                    }


                }

                override fun onFailure(call: Call<MovieDetailResponse>, t: Throwable) {
                    t.printStackTrace()
                    onFail(t.message ?: "unknown error")
                }

            }

        )

    }

    override fun getCinemaList(
        token: String,
        movieId: String,
        date: String,
        onSuccess: (List<CinemaVO>) -> Unit,
        onFail: (String) -> Unit
    ) {
        mTheMovieTicketApi?.getCinemaList(
            token = token,
            movieId = movieId,
            date = date
        )?.enqueue(
            object : Callback<CinemaListResponse> {
                override fun onResponse(
                    call: Call<CinemaListResponse>,
                    response: Response<CinemaListResponse>
                ) {

                    if (response.isSuccessful) {
                        if (response.body()?.code == 200) {
                            Log.d("api_cinema_list", response.toString())
                            val responseBody = response.body()
                            responseBody?.data?.let(onSuccess)
                        }
                    }

                }

                override fun onFailure(call: Call<CinemaListResponse>, t: Throwable) {
                    t.printStackTrace()
                    onFail(t.message ?: "unknown error")
                }

            }
        )
    }

    override fun getSeatingPlan(
        token: String,
        timeSlotId: String,
        bookingDate: String,
        onSuccess: (List<List<MovieSeatVO>>) -> Unit,
        onFail: (String) -> Unit
    ) {
        mTheMovieTicketApi?.getSeatingPlan(
            token = token,
            timeSlotId = timeSlotId,
            bookingDate = bookingDate
        )?.enqueue(
            object : Callback<SeatingPlanResponse> {
                override fun onResponse(
                    call: Call<SeatingPlanResponse>,
                    response: Response<SeatingPlanResponse>
                ) {

                    if (response.isSuccessful) {
                        if (response.body()?.code == 200) {
                            Log.d("api_seating_plan", response.toString())
                            val responseBody = response.body()
                            responseBody?.data?.let(onSuccess)
                        }
                    }

                }

                override fun onFailure(call: Call<SeatingPlanResponse>, t: Throwable) {
                    t.printStackTrace()
                    onFail(t.message ?: "unknown error")
                }

            }
        )
    }

    override fun createCard(
        token: String,
        cardNumber: String,
        cardHolder: String,
        expirationDate: String,
        cvc: String,
        onSuccess: (List<CardVO>) -> Unit,
        onFail: (String) -> Unit
    ) {
        mTheMovieTicketApi?.createCard(
            token = token,
            cardNumber = cardNumber,
            cardHolder = cardHolder,
            expirationDate = expirationDate,
            cvc = cvc
        )?.enqueue(
            object : Callback<CreateCardResponse> {
                override fun onResponse(
                    call: Call<CreateCardResponse>,
                    response: Response<CreateCardResponse>
                ) {

                    if (response.isSuccessful) {
                        if (response.body()?.code == 200) {
                            Log.d("api_create_card", response.toString())
                            val responseBody = response.body()
                            responseBody?.data?.let(onSuccess)
                        }
                    }

                }

                override fun onFailure(call: Call<CreateCardResponse>, t: Throwable) {
                    t.printStackTrace()
                    onFail(t.message ?: "unknown error")
                }

            }
        )    }

    override fun checkOut(
        token: String,
        checkoutString: CheckOutVO,
        onSuccess: (ReceiptVO) -> Unit,
        onFail: (String) -> Unit
    ) {
        mTheMovieTicketApi?.checkout(
            token = token,
            checkoutString = checkoutString
        )?.enqueue(
            object : Callback<CheckoutResponse> {
                override fun onResponse(
                    call: Call<CheckoutResponse>,
                    response: Response<CheckoutResponse>
                ) {

                    if (response.isSuccessful) {
                        if (response.body()?.code == 200) {
                            Log.d("api_checkout", response.body().toString())
                            val responseBody = response.body()
                            responseBody?.data?.let(onSuccess)
                        }else{
                            onFail(response.body()?.message.toString())
                            Log.d("api_checkout", response.body().toString())
                        }
                    }

                    Log.d("api_checkout",response.toString())

                }

                override fun onFailure(call: Call<CheckoutResponse>, t: Throwable) {
                    t.printStackTrace()
                    onFail(t.message ?: "unknown error")
                }

            }
        )
    }

    override fun logOut(token: String, onSuccess: (String) -> Unit, onFail: (String) -> Unit) {
        mTheMovieTicketApi?.logout(
            token = token,
        )?.enqueue(
            object : Callback<LogoutResponse> {
                override fun onResponse(
                    call: Call<LogoutResponse>,
                    response: Response<LogoutResponse>
                ) {

                    if (response.isSuccessful) {
                        if (response.body()?.code == 200) {
                            Log.d("api_logout", response.body().toString())
                            val responseBody = response.body()
                            responseBody?.message?.let(onSuccess)
                        }else{
                            onFail(response.body()?.message.toString())
                            Log.d("api_logout", response.body().toString())
                        }
                    }


                }

                override fun onFailure(call: Call<LogoutResponse>, t: Throwable) {
                    t.printStackTrace()
                    onFail(t.message ?: "unknown error")
                }

            }
        )
    }

    override fun getSnackList(token: String, onSuccess: (List<SnackVO>) -> Unit, onFail: (String) -> Unit) {
        mTheMovieTicketApi?.getSnackList(
            token = token,
        )?.enqueue(
            object : Callback<SnackListResponse> {
                override fun onResponse(
                    call: Call<SnackListResponse>,
                    response: Response<SnackListResponse>
                ) {

                    if (response.isSuccessful) {
                        if (response.body()?.code == 200) {
                            Log.d("api_snack_list", response.toString())
                            val responseBody = response.body()
                            responseBody?.data?.let(onSuccess)
                        }
                    }

                }

                override fun onFailure(call: Call<SnackListResponse>, t: Throwable) {
                    t.printStackTrace()
                    onFail(t.message ?: "unknown error")
                }

            }
        )
    }

    override fun getPaymentMethodList(
        token: String,
        onSuccess: (List<PaymentMethodVO>) -> Unit,
        onFail: (String) -> Unit
    ) {
        mTheMovieTicketApi?.getPaymentMethodList(
            token = token,

        )?.enqueue(
            object : Callback<PaymentMethodListResponse> {
                override fun onResponse(
                    call: Call<PaymentMethodListResponse>,
                    response: Response<PaymentMethodListResponse>
                ) {

                    if (response.isSuccessful) {
                        if (response.body()?.code == 200) {
                            Log.d("api_payment_method_list", response.toString())
                            val responseBody = response.body()
                            responseBody?.data?.let(onSuccess)
                        }
                    }

                }

                override fun onFailure(call: Call<PaymentMethodListResponse>, t: Throwable) {
                    t.printStackTrace()
                    onFail(t.message ?: "unknown error")
                }

            }
        )
    }


}