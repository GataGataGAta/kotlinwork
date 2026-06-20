package com.example.kotlin_work.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.example.kotlin_work.model.Player

@Composable
fun PlayerDetailRoute(
    playerNumber: Int?,
    detailPlayer: Player?,
    onLoadPlayerDetail: (Int?) -> Unit,
    onBackClick: () -> Unit
) {
    LaunchedEffect(playerNumber) {
        onLoadPlayerDetail(playerNumber)
    }

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