package com.thurainx.movieticketapp.persistence.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.thurainx.movieticketapp.data.vos.CardVO

@Dao
interface CardDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCardList(CardList: List<CardVO>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSingleCard(Card: CardVO)

    @Query("SELECT * FROM cards")
    fun getAllCards(): List<CardVO>

    @Query("DELETE FROM cards")
    fun deleteAllCards()

}