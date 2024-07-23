package com.example.norrisjokes.data

import android.util.Log
import com.example.norrisjokes.api.JokeApiService
import com.example.norrisjokes.data.database.JokeDao
import com.example.norrisjokes.data.database.JokeEntity
import kotlinx.coroutines.flow.Flow


// It provides methods for fetching jokes from remote api and store in the local room DB
class JokeRepository(private val jokeDao: JokeDao, private val apiService: JokeApiService) {

    // Flow that provides list of all jokes in the local DB and updates when the data changes
    val allJokes: Flow<List<JokeEntity>> = jokeDao.getAllJokes()

    suspend fun fetchAndStoreJoke() {
       // Fetch random joke from the API
        val joke = apiService.getRandomJoke()
        Log.d("Joke is", joke.value)

        // Insert the fetched joke into the local database
        jokeDao.insertJoke(JokeEntity(joke.id, joke.value))
    }
}