package com.thurainx.movieticketapp.persistence.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.thurainx.movieticketapp.data.vos.MovieVO
import com.thurainx.movieticketapp.data.vos.PaymentMethodVO
import com.thurainx.movieticketapp.data.vos.SnackVO

@Dao
interface PaymentMethodDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPaymentMethodList(paymentMethodList: List<PaymentMethodVO>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSinglePaymentMethod(paymentMethod: PaymentMethodVO)

    @Query("SELECT * FROM payment_methods")
    fun getAllPaymentMethods(): List<PaymentMethodVO>

    @Query("DELETE FROM payment_methods")
    fun deleteAllPaymentMethods()

}