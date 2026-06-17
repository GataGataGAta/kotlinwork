package com.example.kotlin_work.navigation

object AppScreen {
    const val HOME = "home"
    const val PLAYER_DETAIL_ROUTE = "player_detail"

    const val PLAYER_NUMBER_ARG = "playerNumber"

    const val PLAYER_DETAIL = "$PLAYER_DETAIL_ROUTE/{$PLAYER_NUMBER_ARG}"

    fun playerDetail(playerNumber: Int): String {
        return "$PLAYER_DETAIL_ROUTE/$playerNumber"
    }

}