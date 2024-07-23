package com.example.norrisjokes.ui.theme

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.norrisjokes.api.RetrofitInstance
import com.example.norrisjokes.data.JokeRepository
import com.example.norrisjokes.data.database.JokeDatabase
import com.example.norrisjokes.data.database.JokeEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch


// ViewModel for storing and providing joke data
class JokeViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: JokeRepository

    // Stateflow for list of all jokes
    private val _allJokes = MutableStateFlow<List<JokeEntity>>(emptyList())
    val allJokes: StateFlow<List<JokeEntity>> = _allJokes
  // StateFlow fpr the current joke
    private val _currentJoke = MutableStateFlow("")
    val currentJoke: StateFlow<String> = _currentJoke

    init {
        // initializes the repository and get the all jokes from database
        val jokeDao = JokeDatabase.getDatabase(application).jokeDao()
        repository = JokeRepository(jokeDao, RetrofitInstance.api)
        viewModelScope.launch {
            repository.allJokes.collect {
                _allJokes.value = it
            }
        }
    }

    // Fetches the new joke from api and updates the current joke
    fun fetchJoke() {
        viewModelScope.launch {
            repository.fetchAndStoreJoke()
            val latestJoke = repository.allJokes.first().lastOrNull()
            _currentJoke.value = latestJoke?.value ?: ""
        }
    }
}
