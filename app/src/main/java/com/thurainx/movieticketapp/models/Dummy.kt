package com.thurainx.movieticketapp.models

import com.thurainx.movieticketapp.data.*

class Dummy {
    val dummyDateList = listOf<String>("We\n8","Th\n9","Fr\n10","Sa\n11","Su\n12","Mo\n13","Tu\n14","We\n15","Th\n16","Fr\n17")

    val dummyCinemaList = listOf<CinemaData>(
        CinemaData(
            name = "CG : Golden City",
            timeList = listOf<String>("9:30 AM","11:45 AM","3:30 PM","5:00 PM","7:00 PM","9:30 PM")
        ),
        CinemaData(
            name = "CG : West Point",
            timeList = listOf<String>("9:30 AM","11:45 AM","3:30 PM","5:00 PM","7:00 PM","9:30 PM")
        )
    )


    val dummySeatList = listOf<MovieSeatVO>(
        MovieSeatVO(title = "A", type = SEAT_TYPE_TEXT),
        MovieSeatVO(title = "", type = SEAT_TYPE_EMPTY),
        MovieSeatVO(title = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(title = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(title = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(title = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(title = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(title = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(title = "", type = SEAT_TYPE_EMPTY),
        MovieSeatVO(title = "A", type = SEAT_TYPE_TEXT),
        MovieSeatVO(title = "B", type = SEAT_TYPE_TEXT),
        MovieSeatVO(title = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(title = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(title = "", type = SEAT_TYPE_TAKEN),
        MovieSeatVO(title = "", type = SEAT_TYPE_TAKEN),
        MovieSeatVO(title = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(title = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(title = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(title = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(title = "B", type = SEAT_TYPE_TEXT),
        MovieSeatVO(title = "C", type = SEAT_TYPE_TEXT),
        MovieSeatVO(title = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(title = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(title = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(title = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(title = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(title = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(title = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(title = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(title = "C", type = SEAT_TYPE_TEXT),
        MovieSeatVO(title = "D", type = SEAT_TYPE_TEXT),
        MovieSeatVO(title = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(title = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(title = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(title = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(title = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(title = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(title = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(title = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(title = "D", type = SEAT_TYPE_TEXT),
        MovieSeatVO(title = "E", type = SEAT_TYPE_TEXT),
        MovieSeatVO(title = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(title = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(title = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(title = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(title = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(title = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(title = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(title = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(title = "E", type = SEAT_TYPE_TEXT),
        MovieSeatVO(title = "F", type = SEAT_TYPE_TEXT),
        MovieSeatVO(title = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(title = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(title = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(title = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(title = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(title = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(title = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(title = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(title = "F", type = SEAT_TYPE_TEXT),
        MovieSeatVO(title = "G", type = SEAT_TYPE_TEXT),
        MovieSeatVO(title = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(title = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(title = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(title = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(title = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(title = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(title = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(title = "", type = SEAT_TYPE_AVAILABLE),
        MovieSeatVO(title = "G", type = SEAT_TYPE_TEXT),
        )

}