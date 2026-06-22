package com.example.kotlin_work.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.kotlin_work.viewmodel.MainViewModel

@Composable
fun PlayerDetailRoute(
    playerNumber: Int?,
    mainViewModel: MainViewModel,
    onBackClick: () -> Unit
) {
    val uiState by mainViewModel.uiState.collectAsState()

    LaunchedEffect(playerNumber) {
        mainViewModel.loadPlayerDetail(playerNumber)
    }

    val detailPlayer = uiState.detailPlayer

    if (detailPlayer != null) {
        PlayerDetailScreen(
            player = detailPlayer,
            onBackClick = onBackClick
        )
    } else {
        PlayerNotFoundScreen(
            onBackClick = onBackClick
        )
    }
}