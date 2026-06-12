package com.example.kotlin_work

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kotlin_work.ui.theme.KotlinworkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinworkTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(
                        name = "Android",
                        players = samplePlayers
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(
    name: String,
    players: List<Player>,
    mainViewModel: MainViewModel = viewModel()
) {
    val uiState = mainViewModel.uiState

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
    ) {
        item {
            HeaderSection(
                name = name,
                uiState = uiState,
                onIncrementCount = mainViewModel::incrementCount,
                onChangeName = mainViewModel::changeName
            )
        }

        PlayerListSection(
            players = players,
            selectedPlayer = uiState.selectedPlayer,
            onPlayerClick = mainViewModel::selectPlayer
        )
    }
}


@Composable
fun CounterCard(
    count: Int,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Text(text = "Count: $count")
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = onClick
            ) {
                Text(text = "Click")
            }

        }
    }

}

@Composable
fun NameInputCard(
    inputName: String,
    onNameChange: (String) -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            OutlinedTextField(
                value = inputName,
                onValueChange = onNameChange,
                label = {
                    Text(text = "input your name")
                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "your name is $inputName")
        }
    }
}


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
//@Composable
//fun PlayerList(
//    players: List<Player>,
//    modifier: Modifier = Modifier
//) {
//    LazyColumn(
//        modifier = modifier
//    ) {
//        items(players) { player ->
//            PlayerCard(player = player)
//
//            Spacer(modifier = Modifier.height(8.dp))
//        }
//    }
//}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    KotlinworkTheme {
        MainScreen(
            name = "Android",
            players = samplePlayers
        )
    }
}