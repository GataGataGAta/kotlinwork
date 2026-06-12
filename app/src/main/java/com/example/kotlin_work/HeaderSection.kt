package com.example.kotlin_work

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HeaderSection(
    name: String,
    uiState: MainUiState,
    onIncrementCount: () -> Unit,
    onChangeName: (String) -> Unit
) {
    Text(text = "Hello $name!")
    Text(text = "Androidアプリ開発を始めました")

    uiState.selectedPlayer?.let { player ->
        Spacer(modifier = Modifier.height(8.dp))
        SelectedPlayerCard(player = player)
    }

    Spacer(modifier = Modifier.height(16.dp))

    CounterCard(
        count = uiState.count,
        onClick = onIncrementCount
    )

    Spacer(modifier = Modifier.height(16.dp))

    NameInputCard(
        inputName = uiState.inputName,
        onNameChange = onChangeName
    )

    Spacer(modifier = Modifier.height(16.dp))

    Text(text = "Player List")

    Spacer(modifier = Modifier.height(8.dp))
}