package com.thurainx.movieticketapp.models

class Dummy {
    val dummySeatList = listOf<SeatData>(
        SeatData(
            name = "A",
            emptyList = listOf(0,7),
            takenList = listOf()
        ),
        SeatData(
            name = "B",
            emptyList = listOf(),
            takenList = listOf(2,3)
        ),
        SeatData(
            name = "C",
            emptyList = listOf(),
            takenList = listOf()
        ),
        SeatData(
            name = "D",
            emptyList = listOf(),
            takenList = listOf()
        ),
        SeatData(
            name = "E",
            emptyList = listOf(),
            takenList = listOf()
        ),
        SeatData(
            name = "F",
            emptyList = listOf(),
            takenList = listOf()
        ),
        SeatData(
            name = "G",
            emptyList = listOf(),
            takenList = listOf()
        )
    )

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

}