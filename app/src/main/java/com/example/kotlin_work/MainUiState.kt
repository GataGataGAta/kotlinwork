package com.example.kotlin_work

data class MainUiState(
    val count: Int = 0,
    val inputName: String = "",
    val selectedPlayer: Player? = null
)