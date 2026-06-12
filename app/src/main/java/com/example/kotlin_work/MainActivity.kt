package com.example.kotlin_work

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kotlin_work.ui.theme.KotlinworkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinworkTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(
                        name = "Android",
                        players = samplePlayers
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(
    name: String,
    players: List<Player>,
    mainViewModel: MainViewModel = viewModel()
) {
    val uiState = mainViewModel.uiState

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
    ) {
        item {
            HeaderSection(
                name = name,
                uiState = uiState,
                onIncrementCount = mainViewModel::incrementCount,
                onChangeName = mainViewModel::changeName
            )
        }

        PlayerListSection(
            players = players,
            selectedPlayer = uiState.selectedPlayer,
            onPlayerClick = mainViewModel::selectPlayer
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    KotlinworkTheme {
        MainScreen(
            name = "Android",
            players = samplePlayers
        )
    }
}