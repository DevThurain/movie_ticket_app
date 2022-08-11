package com.thurainx.movieticketapp.network

import com.thurainx.movieticketapp.data.vos.MovieVO
import com.thurainx.movieticketapp.network.response.CreditListByMovieResponse
import com.thurainx.movieticketapp.network.response.GenreListResponse
import com.thurainx.movieticketapp.network.response.MovieDetailResponse
import com.thurainx.movieticketapp.network.response.MovieListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface TheMovieTicketApi {

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