package com.example.norrisjokes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.norrisjokes.ui.theme.JokeScreen
import com.example.norrisjokes.ui.theme.JokeViewModel
import com.example.norrisjokes.ui.theme.JokeViewModelFactory
import com.example.norrisjokes.ui.theme.NorrisJokesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NorrisJokesTheme {
                // A surface container using the 'background' color from the theme
                val viewModel: JokeViewModel = viewModel(
                    factory = JokeViewModelFactory(application)
                )
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    JokeScreen(viewModel = viewModel)
                }
            }
        }
    }
}
