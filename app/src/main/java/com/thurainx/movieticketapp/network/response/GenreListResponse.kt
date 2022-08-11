package com.thurainx.movieticketapp.network.response

import com.google.gson.annotations.SerializedName
import com.thurainx.movieticketapp.data.vos.GenreVO

data class GenreListResponse(
    @SerializedName("genres")
    val genres: List<GenreVO>?,
)