package com.thurainx.movieticketapp.network.dataAgents

import android.util.Log
import com.thurainx.movieticketapp.data.vos.ActorVO
import com.thurainx.movieticketapp.data.vos.GenreVO
import com.thurainx.movieticketapp.data.vos.MovieVO
import com.thurainx.movieticketapp.network.BASED_URL
import com.thurainx.movieticketapp.network.MOVIE_BASED_URL
import com.thurainx.movieticketapp.network.TheMovieTicketApi
import com.thurainx.movieticketapp.network.response.CreditListByMovieResponse
import com.thurainx.movieticketapp.network.response.GenreListResponse
import com.thurainx.movieticketapp.network.response.MovieDetailResponse
import com.thurainx.movieticketapp.network.response.MovieListResponse
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitDataAgentImpl : MovieTicketDataAgent {
    private var mTheMovieTicketApi: TheMovieTicketApi? = null
    private var mTheMovieApi: TheMovieTicketApi? = null

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
    override fun registerWithEmail(name: String, phone: String, email: String, password: String) {
        TODO("Not yet implemented")
    }

    override fun loginWithEmail(email: String, password: String) {
        TODO("Not yet implemented")
    }

    override fun getMovieListByStatus(status: String,onSuccess: (List<MovieVO>) -> Unit, onFail: (String) -> Unit) {
        mTheMovieTicketApi?.getMovieListByStatus(status = status)?.enqueue(
            object : Callback<MovieListResponse> {
                override fun onResponse(
                    call: Call<MovieListResponse>,
                    response: Response<MovieListResponse>
                ) {

                    if(response.isSuccessful){
                        val movieList = response.body()?.data ?: listOf()
                        Log.d("movies",movieList.toString())
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

                    if(response.isSuccessful){
                        val movie = response.body()?.data
                        Log.d("movieDetail",movie.toString())
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



}