package com.thurainx.movieticketapp.network

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



}