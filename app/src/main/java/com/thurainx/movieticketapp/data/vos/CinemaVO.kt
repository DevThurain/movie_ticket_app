package com.thurainx.movieticketapp.data.vos

import androidx.room.*
import com.google.gson.annotations.SerializedName
import com.thurainx.movieticketapp.persistence.typeconverters.TimeSlotTypeConverter

@Entity(tableName = "cinemas")
@TypeConverters(
    TimeSlotTypeConverter::class
)
data class CinemaVO(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "date")
    @SerializedName("date")
    var date: String,

    @ColumnInfo(name = "cinema_id")
    @SerializedName("cinema_id")
    val cinemaId: Int?,

    @ColumnInfo(name = "cinema")
    @SerializedName("cinema")
    val cinema: String?,

    @ColumnInfo(name = "timeslots")
    @SerializedName("timeslots")
    val timeslots: List<TimeSlotVO>?,
    )