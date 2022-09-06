package com.thurainx.movieticketapp.persistence.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.thurainx.movieticketapp.data.vos.CinemaVO
import com.thurainx.movieticketapp.data.vos.MovieVO

@Dao
interface CinemaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCinemaList(cinemaList: List<CinemaVO>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSingleCinema(cinema: CinemaVO)

    @Query("SELECT * FROM cinemas")
    fun getAllCinemas(): List<CinemaVO>

    @Query("DELETE FROM cinemas WHERE date = :date")
    fun deleteCinemaListByDate(date: String)

    @Query("SELECT * FROM cinemas WHERE date = :date")
    fun getCinemaListByDate(date: String) : List<CinemaVO>?

}