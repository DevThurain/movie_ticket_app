package com.thurainx.movieticketapp.network.dataAgents

import android.util.Log
import com.thurainx.movieticketapp.data.vos.ActorVO
import com.thurainx.movieticketapp.data.vos.GenreVO
import com.thurainx.movieticketapp.data.vos.MovieVO
import com.thurainx.movieticketapp.data.vos.ProfileVO
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
    override fun registerWithEmail(name: String, phone: String, email: String, password: String,onSuccess: (TokenResponse) -> Unit, onFail: (String) -> Unit) {
        mTheMovieTicketApi?.registerWithEmail(name = name, email = email, phone = phone, password = password)?.enqueue(
            object : Callback<TokenResponse> {
                override fun onResponse(
                    call: Call<TokenResponse>,
                    response: Response<TokenResponse>
                ) {

                    if(response.isSuccessful){
                        if(response.body()?.code == 201){
                            Log.d("api_register",response.toString())
                            response.body()?.let(onSuccess)
                        }else{
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

                    if(response.isSuccessful){
                        if(response.body()?.code == 200){
                            Log.d("api_login",response.toString())
                            response.body()?.let(onSuccess)
                        }else{
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

                    if(response.isSuccessful){
                        if(response.body()?.code == 200){
                            Log.d("api_profile",response.toString())
                            val responseBody = response.body()
                            responseBody?.data?.let(onSuccess)
                        }else{
                            Log.d("api_profile","status code error")
                            onFail(response.body()?.message ?: "unknown error")
                        }

                    }else{
                        Log.d("api_profile",response.body().toString())

                    }

                }

                override fun onFailure(call: Call<ProfileResponse>, t: Throwable) {
                    t.printStackTrace()
                    Log.d("api_profile",t.message.toString())
                    onFail(t.message ?: "unknown error")
                }

            }
        )      }

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