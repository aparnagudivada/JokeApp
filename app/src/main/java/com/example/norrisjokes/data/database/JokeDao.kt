package com.example.norrisjokes.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
//DAO for accessing the data stored in the database
@Dao
interface JokeDao {
    // Gives all the jokes from the jokes table
    @Query("SELECT * FROM jokes")
    fun getAllJokes(): Flow<List<JokeEntity>>

    // Insert the joke into the jokes table
    // if the joke is already exists then it replaces the existing joke
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertJoke(joke: JokeEntity)
}
