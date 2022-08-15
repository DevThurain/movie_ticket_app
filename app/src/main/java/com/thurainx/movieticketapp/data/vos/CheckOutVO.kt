package com.thurainx.movieticketapp.data.vos

data class CheckOutVO(
    var cinema_day_timeslot_id: Int = 0,
    var row: String = "",
    var seat_number: String = "",
    var booking_date: String = "",
    var total_price: Int = 0,
    var movie_id: Int = 0,
    var card_id: Int = 0,
    var cinema_id: Int = 0,
    var snacks: List<CheckOutSnackVO> = listOf()
){

}