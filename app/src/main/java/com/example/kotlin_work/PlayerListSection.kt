package com.example.kotlin_work

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

fun LazyListScope.PlayerListSection(
    players: List<Player>,
    selectedPlayer: Player?,
    onPlayerClick: (Player) -> Unit
) {
    items(players) { player ->
        PlayerCard(
            player = player,
            isSelected = player == selectedPlayer,
            onClick = {
                onPlayerClick(player)
            }
        )

        Spacer(modifier = Modifier.height(8.dp))
    }
}