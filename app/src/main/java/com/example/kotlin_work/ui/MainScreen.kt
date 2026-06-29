package com.example.kotlin_work.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
    players: List<Player>,
    onSearchTextChange: (String) -> Unit,
    onPlayerClick: (Player) -> Unit,
    onToggleSortByName: () -> Unit
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
        }

        item {
            SearchPlayerCard(
                searchText = uiState.searchText,
                resultCount = players.size,
                isSortByName = uiState.isSortByName,
                onSearchTextChange = onSearchTextChange,
                onClearSearchClick = {
                    onSearchTextChange("")
                },
                onToggleSortByName = onToggleSortByName
            )
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
        PlayerListSection(
            players = players,
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
                        number = 10,
                        nameKana = "やまだ たろう"
                    )
                )
            ),
            players = listOf(
                Player(
                    name = "山田　太郎",
                    position = "Forward",
                    number = 10,
                    nameKana = "やまだ たろう"
                )
            ),
            onIncrementCount = {},
            onChangeName = {},
            onSearchTextChange = {},
            onPlayerClick = {},
            onToggleSortByName = {}

        )
    }
}