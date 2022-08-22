package com.thurainx.movieticketapp.data.vos

import com.google.gson.annotations.SerializedName

data class CheckOutVO(

    @SerializedName("cinema_day_timeslot_id")
    var cinemaDayTimeSlotId: Int = 0,

    @SerializedName("row")
    var row: String = "",

    @SerializedName("seat_number")
    var seatNumber: String = "",

    @SerializedName("booking_date")
    var bookingDate: String = "",

    @SerializedName("total_price")
    var totalPrice: Int = 0,

    @SerializedName("movie_id")
    var movieId: Int = 0,

    @SerializedName("card_id")
    var cardId: Int = 0,

    @SerializedName("cinema_id")
    var cinemaId: Int = 0,

    @SerializedName("snacks")
    var snacks: List<CheckOutSnackVO> = listOf()
){

}