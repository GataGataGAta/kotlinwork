package com.example.kotlin_work.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kotlin_work.model.Player

fun LazyListScope.PlayerListSection(
    players: List<Player>,
    selectedPlayer: Player?,
    onPlayerClick: (Player) -> Unit
) {
    if (players.isEmpty()) {
        item {
            Text(text = "No Player Found")
            Spacer(modifier = Modifier.height(8.dp))
        }
    } else {
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
}