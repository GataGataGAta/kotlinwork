package com.example.kotlin_work

import android.os.Bundle
import android.util.Log
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
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

data class Player(
    val name: String,
    val position: String,
    val number: Int
)

val samplePlayers = listOf(
    Player(name = "山田 太郎", position = "Forward", number = 10),
    Player(name = "佐藤 健", position = "Midfielder", number = 8),
    Player(name = "鈴木 一郎", position = "Defender", number = 4)
)

@Composable
fun MainScreen(
    name: String,
    players: List<Player>
) {
    var count by rememberSaveable { mutableIntStateOf(0) }
    var inputName by rememberSaveable { mutableStateOf("") }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        item {
            Text(text = "Hello $name!")
            Text(text = "Androidアプリ開発を始めました")

            Spacer(modifier = Modifier.height(16.dp))

            CounterCard(
                count = count,
                onClick = {
                    Log.d("MainScreen", "before = $count")
                    count++
                    Log.d("MainScreen", "after = $count")
                }
            )
            Spacer(modifier = Modifier.height(16.dp))

            NameInputCard(
                inputName = inputName,
                onNameChange = { newText ->
                    Log.d("MainScreen", "inputName = $newText")
                    inputName = newText
                })
            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Player List")

            Spacer(modifier = Modifier.height(8.dp))
        }

        items(players) { player ->
            PlayerCard(player = player)

            Spacer(modifier = Modifier.height(8.dp))
        }

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
fun PlayerCard(player: Player) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Player Info")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Name: ${player.name}")
            Text(text = "Position: ${player.position}")
            Text(text = "Number: ${player.number}")
        }

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