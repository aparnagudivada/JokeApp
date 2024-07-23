package com.example.norrisjokes.api

import com.example.norrisjokes.data.Joke
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

// An interface for the Joke API Service for getting random joke
interface JokeApiService {
    // HTTP method for GET
    @GET("jokes/random")
    suspend fun getRandomJoke(): Joke
}

object RetrofitInstance {
    //Creating retrofit instance with the base url and using GsonConverterFactory to parse the response data
    val api: JokeApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.chucknorris.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(JokeApiService::class.java)
    }
}
