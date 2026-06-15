package com.example.kotlin_work.viewmodel

import androidx.lifecycle.ViewModel
import com.example.kotlin_work.model.MainUiState
import com.example.kotlin_work.model.Player
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class MainViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(MainUiState())
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

    fun selectPlayer(player: Player) {
        _uiState.update { currentState ->
            currentState.copy(
                selectedPlayer = player
            )
        }
    }
}