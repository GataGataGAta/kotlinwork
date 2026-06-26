package com.example.kotlin_work.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.kotlin_work.model.Player
import com.example.kotlin_work.viewmodel.MainViewModel


@Composable
fun MainRoute(
    name: String,
    mainViewModel: MainViewModel,
    onPlayerDetailClick: (Player) -> Unit
) {
    val uiState by mainViewModel.uiState.collectAsState()

    val filteredPlayers = uiState.players.filter { player ->
        player.name.contains(uiState.searchText, ignoreCase = true) ||
                player.position.contains(uiState.searchText, ignoreCase = true) ||
                player.number.toString().contains(uiState.searchText)
    }

    val displeyedPlayers = if (uiState.isSortByName) {
        filteredPlayers.sortedBy { player ->
            player.name
        }
    } else {
        filteredPlayers
    }

    MainScreen(
        name = name,
        uiState = uiState,
        players = displeyedPlayers,
        onIncrementCount = mainViewModel::incrementCount,
        onChangeName = mainViewModel::changeName,
        onSearchTextChange = mainViewModel::changeSearchText,
        onPlayerClick = { player ->
            mainViewModel.selectPlayer(player)
            onPlayerDetailClick(player)
        },
        onToggleSortByName = mainViewModel::toggleSortByName,
    )
}