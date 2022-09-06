package com.thurainx.movieticketapp.persistence.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.thurainx.movieticketapp.data.vos.MovieVO
import com.thurainx.movieticketapp.data.vos.SnackVO

@Dao
interface SnackDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSnackList(snackList: List<SnackVO>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSingleSnack(snack: SnackVO)

    @Query("SELECT * FROM snacks")
    fun getAllSnacks(): List<SnackVO>

    @Query("DELETE FROM snacks")
    fun deleteAllSnacks()

}