package com.example.kotlin_work.ui


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kotlin_work.model.Player

@Composable
fun PlayerDatailScreen(
    player: Player,
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text(text = "Player Detail")

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Name: ${player.name}")
        Text(text = "Position: ${player.position}")
        Text(text = "Number: ${player.number}")

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onBackClick
        ) {
            Text(text = "Back")
        }
    }
}