package com.thurainx.movieticketapp.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.thurainx.movieticketapp.data.vos.MovieVO
import com.thurainx.movieticketapp.data.vos.UserVO
import com.thurainx.movieticketapp.persistence.daos.MovieDao
import com.thurainx.movieticketapp.persistence.daos.UserDao

@Database(entities = [MovieVO::class, UserVO::class], version = 1, exportSchema = false)
abstract class MovieTicketDatabase : RoomDatabase() {
    companion object{
        const val DB_NAME = "THE_MOVIE_TICKET_DATABASE"
        var dbInstant : MovieTicketDatabase? = null

        fun getDBInstant(context: Context) : MovieTicketDatabase?{
            when(dbInstant){
                null -> {
                    dbInstant = Room.databaseBuilder(context, MovieTicketDatabase::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return dbInstant
        }
    }

    abstract fun movieDao() : MovieDao
    abstract fun userDao(): UserDao
}