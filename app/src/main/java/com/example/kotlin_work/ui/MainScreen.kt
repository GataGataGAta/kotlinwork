package com.example.kotlin_work.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kotlin_work.data.samplePlayers
import com.example.kotlin_work.model.Player
import com.example.kotlin_work.ui.theme.KotlinworkTheme
import com.example.kotlin_work.viewmodel.MainViewModel

@Composable
fun MainScreen(
    name: String,
    players: List<Player>,
    onOpenDetailClick: () -> Unit,
    mainViewModel: MainViewModel = viewModel()
) {
    val uiState by mainViewModel.uiState.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        item {
            HeaderSection(
                name = name,
                uiState = uiState,
                onIncrementCount = mainViewModel::incrementCount,
                onChangeName = mainViewModel::changeName
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = onOpenDetailClick
            ) {
                Text(text = "Go to Detail")
            }

            Spacer(modifier = Modifier.height(16.dp))
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
            players = samplePlayers,
            onOpenDetailClick = {},
            mainViewModel = MainViewModel()
        )
    }
}