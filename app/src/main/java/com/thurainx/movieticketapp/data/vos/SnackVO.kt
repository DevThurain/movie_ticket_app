package com.thurainx.movieticketapp.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "snacks")
data class SnackVO(
    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    val id: Int?,

    @ColumnInfo(name = "name")
    @SerializedName("name")
    val name: String?,

    @ColumnInfo(name = "description")
    @SerializedName("description")
    val description: String?,

    @ColumnInfo(name = "price")
    @SerializedName("price")
    val price: Int?,

    @ColumnInfo(name = "no_of_sold")
    @SerializedName("no_of_sold")
    val noOfSold: Int?,

    @ColumnInfo(name = "is_active")
    @SerializedName("is_active")
    val isActive: Int?,

    @ColumnInfo(name = "image")
    @SerializedName("image")
    val image: String?,

    @ColumnInfo(name = "count")
    @SerializedName("count")
    var count: Int = 0


)