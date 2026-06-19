package com.example.kotlin_work.data

import com.example.kotlin_work.model.Player

val samplePlayers = listOf(
    Player(name = "山田 太郎", position = "Forward", number = 10),
    Player(name = "佐藤 健", position = "Midfielder", number = 8),
    Player(name = "鈴木 一郎", position = "Defender", number = 4)
)

fun findPlayerByNumber(playerNumber: Int?): Player? {
    return samplePlayers.find { player ->
        player.number == playerNumber
    }
}