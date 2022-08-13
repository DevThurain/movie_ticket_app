package com.thurainx.movieticketapp.data.vos

import java.util.*

data class DayVO(
    val rawDate: String?,
    val formatDay: String?,
    val day: String?,
    var isSelected: Boolean = false

)