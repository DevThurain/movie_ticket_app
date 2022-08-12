package com.thurainx.movieticketapp.network

import com.thurainx.movieticketapp.data.vos.MovieVO
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
        ) : Call<TokenResponse>

    @POST(API_LOGIN_WITH_EMAIL)
    @FormUrlEncoded
    fun loginWithEmail(
        @Field(PARAM_EMAIL) email: String,
        @Field(PARAM_PASSWORD) password: String,
    ) : Call<TokenResponse>

    @GET(API_GET_MOVIE_LIST)
    fun getMovieListByStatus(
        @Query(PARAM_STATUS) status: String,
        @Query(PARAM_TAKE) take: Int = 10,
    ) : Call<MovieListResponse>


    @GET(API_GET_MOVIE_DETAIL+"/{movie_id}")
    fun getMovieDetailById(
        @Path("movie_id") movieId: String,
        @Query(PARAM_API_KEY) apiKey: String = MOVIE_API_KEY,
    ) : Call<MovieDetailResponse>




}