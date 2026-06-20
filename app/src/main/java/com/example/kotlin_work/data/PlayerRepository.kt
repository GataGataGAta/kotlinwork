package com.example.kotlin_work.data

import com.example.kotlin_work.model.Player

class PlayerRepository {
    fun getPlayers(): List<Player> {
        return samplePlayers
    }

    fun findPlayerByNumber(playerNumber: Int?): Player? {
        return samplePlayers.find { player ->
            player.number == playerNumber
        }
    }
}