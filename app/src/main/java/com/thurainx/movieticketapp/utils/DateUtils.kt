package com.thurainx.movieticketapp.utils

import com.thurainx.movieticketapp.data.vos.DayVO
import java.text.SimpleDateFormat
import java.util.*


class DateUtils {
    fun getNextTwoWeekDates(): List<DayVO> {
        var dayList: ArrayList<DayVO> = arrayListOf()
        val formatter = SimpleDateFormat("EEE\ndd")
        val dayFormatter = SimpleDateFormat("dd")
        val calendar = Calendar.getInstance()

        dayList.add(
            DayVO(
                rawDate = calendar.time.toString(),
                formatDay = formatter.format(calendar.time),
                day = dayFormatter.format(calendar.time)
            )
        )
        for (i in 0..12) {
            calendar.add(Calendar.DAY_OF_YEAR, 1)
            dayList.add(
                DayVO(
                    rawDate = calendar.time.toString(),
                    formatDay = formatter.format(calendar.time),
                    day = dayFormatter.format(calendar.time)
                )
            )

        }

        return dayList.toList()
    }

}

fun String.toApiDateFormat() : String{
    val formatter = SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy",Locale.ENGLISH)

    val parsedDate: Date = formatter.parse(this)
    val print = SimpleDateFormat("yyyy-MM-dd")

    return print.format(parsedDate)

}

fun String.toCinemaDisplayDateFormat() : String{
    val formatter = SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy",Locale.ENGLISH)

    val parsedDate: Date = formatter.parse(this)
    val print = SimpleDateFormat("E, dd MMMM yyyy")

    return print.format(parsedDate)

}

fun formatCard(cardNumber: String?): String? {
    if (cardNumber == null) return null
    val delimiter = ' '
    return cardNumber.replace(".{4}(?!$)".toRegex(), "$0$delimiter")
}
