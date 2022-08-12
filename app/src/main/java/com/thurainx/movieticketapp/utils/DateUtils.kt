package com.thurainx.movieticketapp.utils

import android.util.Log
import com.thurainx.movieticketapp.data.vos.DayVO
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


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
