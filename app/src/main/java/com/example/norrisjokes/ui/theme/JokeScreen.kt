package com.example.norrisjokes.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


// Displays the main screen for jokes
@Composable
fun JokeScreen(viewModel: JokeViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    val currentJoke by viewModel.currentJoke.collectAsState()
    val allJokes by viewModel.allJokes.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(text = "Current Joke", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = currentJoke, style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { viewModel.fetchJoke() }) {
            Text(text = "Get Joke")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "All Jokes", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn {
            items(allJokes) {
                it.value?.let { it1 -> Text(text = it1, style = MaterialTheme.typography.bodyLarge) }
                Spacer(modifier = Modifier.height(8.dp))
            }

        }
    }
}

// preview of JokeScreen

@Preview(showBackground = true)
@Composable
fun JokeScreenPreview() {
    JokeScreen()
}
