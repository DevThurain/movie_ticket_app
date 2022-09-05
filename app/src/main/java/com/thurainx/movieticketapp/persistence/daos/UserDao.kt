package com.thurainx.movieticketapp.persistence.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.thurainx.movieticketapp.data.vos.MovieVO
import com.thurainx.movieticketapp.data.vos.UserVO

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: UserVO)

    @Query("SELECT * FROM user")
    fun getUser(): UserVO?

    @Query("DELETE FROM user")
    fun deleteUser()

}