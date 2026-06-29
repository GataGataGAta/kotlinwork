package com.example.kotlin_work.viewmodel

import androidx.lifecycle.ViewModel
import com.example.kotlin_work.data.PlayerRepository
import com.example.kotlin_work.model.MainUiState
import com.example.kotlin_work.model.Player
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class MainViewModel : ViewModel() {
    private val playerRepository = PlayerRepository()
    private val initialPlayers = playerRepository.getPlayers()

    private val _uiState = MutableStateFlow(
        MainUiState(
            players = playerRepository.getPlayers(),
            displayedPlayers = initialPlayers
        )
    )

    val uiState = _uiState.asStateFlow()
    fun incrementCount() {
        _uiState.update { currentState ->
            currentState.copy(
                count = currentState.count + 1
            )
        }
    }

    fun changeName(newText: String) {
        _uiState.update { currentState ->
            currentState.copy(
                inputName = newText
            )
        }
    }

    fun changeSearchText(newText: String) {
        _uiState.update { currentState ->
            currentState.copy(
                searchText = newText,
                displayedPlayers = updateDisplayedPlayers(
                    searchText = newText,
                    isSortByName = currentState.isSortByName
                )
            )
        }
    }

    fun selectPlayer(player: Player) {
        _uiState.update { currentState ->
            currentState.copy(
                selectedPlayer = player
            )
        }
    }

    fun loadPlayerDetail(playerNumber: Int?) {
        _uiState.update { currentState ->
            currentState.copy(
                isDetailLoading = true,
                detailPlayer = null
            )
        }
        val player = playerRepository.findPlayerByNumber(playerNumber)
        _uiState.update { currentState ->
            currentState.copy(
                detailPlayer = player,
                isDetailLoading = false
            )

        }
    }

    fun toggleSortByName() {
        _uiState.update { currentState ->
            val newSortState = !currentState.isSortByName
            currentState.copy(
                isSortByName = newSortState,
                displayedPlayers = updateDisplayedPlayers(
                    searchText = currentState.searchText,
                    isSortByName = newSortState
                )
            )
        }
    }

    private fun updateDisplayedPlayers(
        searchText: String,
        isSortByName: Boolean
    ): List<Player> {
        return playerRepository.searchPlayers(
            searchText = searchText,
            isSortByName = isSortByName
        )
    }
}