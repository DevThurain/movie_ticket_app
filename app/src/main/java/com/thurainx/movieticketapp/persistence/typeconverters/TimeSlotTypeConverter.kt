package com.thurainx.movieticketapp.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.thurainx.movieticketapp.data.vos.ActorVO
import com.thurainx.movieticketapp.data.vos.TimeSlotVO

class TimeSlotTypeConverter {
    @TypeConverter
    fun toString(timeslotList: List<TimeSlotVO>?): String {
        return Gson().toJson(timeslotList)
    }

    @TypeConverter
    fun toTimeslotList(jsonStr: String) : List<TimeSlotVO>?{
        val type = object : TypeToken<List<TimeSlotVO>?>(){}.type
        return Gson().fromJson(jsonStr, type)
    }
}