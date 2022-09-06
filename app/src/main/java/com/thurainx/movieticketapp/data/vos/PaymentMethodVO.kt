package com.thurainx.movieticketapp.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "payment_methods")
data class PaymentMethodVO(
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

    @ColumnInfo(name = "is_active")
    @SerializedName("is_active")
    val isActive: Int?,

    @ColumnInfo(name = "is_checked")
    @SerializedName("is_checked")
    var isChecked: Boolean = false


)