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

    fun searchPlayers(
        searchText: String,
        isSortByName: Boolean
    ): List<Player> {
        val filteredPlayers = samplePlayers.filter { player ->
            player.name.contains(searchText, ignoreCase = true) ||
                    player.position.contains(searchText, ignoreCase = true) ||
                    player.number.toString().contains(searchText)
        }

        return if (isSortByName) {
            filteredPlayers.sortedBy { player ->
                player.name
            }
        } else {
            filteredPlayers
        }
    }
}