package com.thurainx.movieticketapp.network

import com.thurainx.movieticketapp.data.vos.CheckOutVO
import com.thurainx.movieticketapp.network.response.*
import retrofit2.Call
import retrofit2.http.*

interface TheMovieTicketApi {

    @POST(API_REGISTER_WITH_EMAIL)
    @FormUrlEncoded
    fun registerWithEmail(
        @Field(PARAM_NAME) name: String,
        @Field(PARAM_EMAIL) email: String,
        @Field(PARAM_PHONE) phone: String,
        @Field(PARAM_PASSWORD) password: String,
    ): Call<TokenResponse>

    @POST(API_LOGIN_WITH_EMAIL)
    @FormUrlEncoded
    fun loginWithEmail(
        @Field(PARAM_EMAIL) email: String,
        @Field(PARAM_PASSWORD) password: String,
    ): Call<TokenResponse>

    @GET(API_GET_PROFILE)
    fun getProfile(
        @Header(PARAM_AUTHORIZATION) token: String,
    ): Call<ProfileResponse>

    @GET(API_GET_MOVIE_LIST)
    fun getMovieListByStatus(
        @Query(PARAM_STATUS) status: String,
        @Query(PARAM_TAKE) take: Int = 10,
    ): Call<MovieListResponse>


    @GET(API_GET_MOVIE_DETAIL + "/{movie_id}")
    fun getMovieDetailById(
        @Path("movie_id") movieId: String,
        @Query(PARAM_API_KEY) apiKey: String = MOVIE_API_KEY,
    ): Call<MovieDetailResponse>

    @GET(API_GET_CINEMA_LIST)
    fun getCinemaList(
        @Header(PARAM_AUTHORIZATION) token: String,
        @Query(PARAM_MOVIE_ID) movieId: String,
        @Query(PARAM_DATE) date: String,
    ): Call<CinemaListResponse>

    @GET(API_GET_SEATING_PLAN)
    fun getSeatingPlan(
        @Header(PARAM_AUTHORIZATION) token: String,
        @Query(PARAM_TIME_SLOT_ID) timeSlotId: String,
        @Query(PARAM_BOOKING_DATE) bookingDate: String,
    ): Call<SeatingPlanResponse>

    @GET(API_GET_SNACK_LIST)
    fun getSnackList(
        @Header(PARAM_AUTHORIZATION) token: String,
    ): Call<SnackListResponse>

    @GET(API_GET_PAYMENT_METHOD_LIST)
    fun getPaymentMethodList(
        @Header(PARAM_AUTHORIZATION) token: String,
    ): Call<PaymentMethodListResponse>

    @POST(API_CREATE_CARD)
    @FormUrlEncoded
    fun createCard(
        @Header(PARAM_AUTHORIZATION) token: String,
        @Field(PARAM_CARD_NUMBER) cardNumber: String,
        @Field(PARAM_CARD_HOLDER) cardHolder: String,
        @Field(PARAM_EXPIRATION_DATE) expirationDate: String,
        @Field(PARAM_CVC) cvc: String,
    ): Call<CreateCardResponse>

    @POST(API_CHECK_OUT)
    fun checkout(
        @Header(PARAM_AUTHORIZATION) token: String,
        @Body checkoutString: CheckOutVO,
        ): Call<CheckoutResponse>

    @POST(API_LOG_OUT)
    fun logout(
        @Header(PARAM_AUTHORIZATION) token: String,
    ): Call<LogoutResponse>


}