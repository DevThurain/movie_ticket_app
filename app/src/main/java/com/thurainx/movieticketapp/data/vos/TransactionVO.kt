package com.thurainx.movieticketapp.data.vos

import com.google.gson.annotations.SerializedName

data class TransactionVO(
   @SerializedName("id")
   val id: Int?,

   @SerializedName("booking_no")
   val bookingNo: String?,

   @SerializedName("cinema_timeslot_id")
   val cinemaTimeslotId: Int?,

   @SerializedName("row")
   val row: String?,

   @SerializedName("seat_number")
   val seatNumber: String?,

   @SerializedName("total_seat")
   val totalSeat: Int?,

   @SerializedName("total")
   val total: String?,

   @SerializedName("movie_title")
   val movieTitle: String?,

   @SerializedName("cinema")
   val cinema: String?,

   @SerializedName("username")
   val username: String?,

   @SerializedName("timeslot")
   val timeslot: String?,

   @SerializedName("movie_date")
   val movieDate: String?,

   @SerializedName("snack")
   val snack: List<SnackVO>?,

    )