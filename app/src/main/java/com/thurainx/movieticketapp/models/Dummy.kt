package com.thurainx.movieticketapp.models

import com.thurainx.movieticketapp.data.*

class Dummy {
    val dummyDateList = listOf<String>("We\n8","Th\n9","Fr\n10","Sa\n11","Su\n12","Mo\n13","Tu\n14","We\n15","Th\n16","Fr\n17")

    val dummyCinemaList = listOf<CinemaData>(
        CinemaData(
            name = "CG : Golden City",
            timeList = listOf<String>("9:30 AM","11:45 AM","3:30 PM","5:00 PM","7:00 PM")
        ),
        CinemaData(
            name = "CG : West Point",
            timeList = listOf<String>("9:30 AM","11:45 AM","3:30 PM","5:00 PM","7:00 PM","9:30 PM")
        )
    )


    val dummySeatList = listOf<MovieSeatVO>(
        MovieSeatVO(symbol = "A", type = SEAT_TYPE_TEXT),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_EMPTY),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_EMPTY),
        MovieSeatVO(symbol = "A", type = SEAT_TYPE_TEXT),
        MovieSeatVO(symbol = "B", type = SEAT_TYPE_TEXT),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_TAKEN),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_TAKEN),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(symbol = "B", type = SEAT_TYPE_TEXT),
        MovieSeatVO(symbol = "C", type = SEAT_TYPE_TEXT),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(symbol = "C", type = SEAT_TYPE_TEXT),
        MovieSeatVO(symbol = "D", type = SEAT_TYPE_TEXT),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(symbol = "D", type = SEAT_TYPE_TEXT),
        MovieSeatVO(symbol = "E", type = SEAT_TYPE_TEXT),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(symbol = "E", type = SEAT_TYPE_TEXT),
        MovieSeatVO(symbol = "F", type = SEAT_TYPE_TEXT),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(symbol = "F", type = SEAT_TYPE_TEXT),
        MovieSeatVO(symbol = "G", type = SEAT_TYPE_TEXT),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(symbol = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(symbol = "G", type = SEAT_TYPE_TEXT),
        )

}