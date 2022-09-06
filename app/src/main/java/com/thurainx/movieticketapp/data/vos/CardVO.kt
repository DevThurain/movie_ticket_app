package com.thurainx.movieticketapp.data.vos

import alirezat775.lib.carouselview.CarouselModel
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "cards")
data class CardVO(
    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    val id: Int?,

    @ColumnInfo(name = "card_holder")
    @SerializedName("card_holder")
    val cardHolder: String?,

    @ColumnInfo(name = "card_number")
    @SerializedName("card_number")
    val cardNumber: String?,

    @ColumnInfo(name = "card_type")
    @SerializedName("card_type")
    val cardType: String?,      

    @ColumnInfo(name = "image")
    @SerializedName("image")
    val image: String?, 

    @ColumnInfo(name = "amount")
    @SerializedName("amount")
    val amount: String?,

    @ColumnInfo(name = "expiration_date")
    @SerializedName("expiration_date")
    val expirationDate: String = "",
    ): CarouselModel()