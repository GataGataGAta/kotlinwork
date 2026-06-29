package com.example.kotlin_work.model

data class MainUiState(
    val count: Int = 0,
    val inputName: String = "",
    val selectedPlayer: Player? = null,
    val players: List<Player> = emptyList(),
    val displayedPlayers: List<Player> = emptyList(),
    val detailPlayer: Player? = null,
    val isDetailLoading: Boolean = false,
    val searchText: String = "",
    val isSortByName: Boolean = false
)