package com.example.kotlin_work.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.kotlin_work.model.MainUiState
import com.example.kotlin_work.model.Player

class MainViewModel : ViewModel() {
    var uiState by mutableStateOf(MainUiState())
        private set

    fun incrementCount() {
        uiState = uiState.copy(
            count = uiState.count + 1
        )
    }

    fun changeName(newText: String) {
        uiState = uiState.copy(
            inputName = newText
        )
    }

    fun selectPlayer(player: Player) {
        uiState = uiState.copy(
            selectedPlayer = player
        )
    }
}