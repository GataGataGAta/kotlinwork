package com.example.kotlin_work.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kotlin_work.data.samplePlayers
import com.example.kotlin_work.ui.MainScreen
import com.example.kotlin_work.ui.PlayerDatailScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppScreen.HOME
    ) {
        composable(route = AppScreen.HOME) {
            MainScreen(
                name = "Android",
                players = samplePlayers,
                onOpenDetailClick = {
                    navController.navigate(AppScreen.PLAYER_DETAIL)
                }
            )
        }

        composable(route = AppScreen.PLAYER_DETAIL) {
            PlayerDatailScreen(
                player = samplePlayers.first(),
                onBackClick = {
                    navController.popBackStack()
                })
        }
    }
}