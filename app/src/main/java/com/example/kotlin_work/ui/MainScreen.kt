package com.example.kotlin_work.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlin_work.model.MainUiState
import com.example.kotlin_work.model.Player
import com.example.kotlin_work.ui.theme.KotlinworkTheme

@Composable
fun MainScreen(
    name: String,
    uiState: MainUiState,
    onIncrementCount: () -> Unit,
    onChangeName: (String) -> Unit,
    onPlayerClick: (Player) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        item {
            HeaderSection(
                name = name,
                uiState = uiState,
                onIncrementCount = onIncrementCount,
                onChangeName = onChangeName
            )

//            Spacer(modifier = Modifier.height(16.dp))
//
//            Button(
//                onClick = onOpenDetailClick
//            ) {
//                Text(text = "Go to Detail")
//            }
//
//            Spacer(modifier = Modifier.height(16.dp))
        }

        PlayerListSection(
            players = uiState.players,
            selectedPlayer = uiState.selectedPlayer,
            onPlayerClick = onPlayerClick
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    KotlinworkTheme {
        MainScreen(
            name = "Android",
            uiState = MainUiState(
                players = listOf(
                    Player(
                        name = "山田　太郎",
                        position = "Forward",
                        number = 10
                    )
                )
            ),
            onIncrementCount = {},
            onChangeName = {},
            onPlayerClick = {}

        )
    }
}