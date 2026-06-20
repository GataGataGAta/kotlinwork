package com.example.kotlin_work.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.kotlin_work.ui.MainScreen
import com.example.kotlin_work.ui.PlayerDetailScreen
import com.example.kotlin_work.ui.PlayerNotFoundScreen
import com.example.kotlin_work.viewmodel.MainViewModel


@Composable
fun AppNavHost(
    mainViewModel: MainViewModel = viewModel()
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppScreen.HOME,

        ) {
        composable(route = AppScreen.HOME) {
            MainScreen(
                name = "Android",
                onPlayerDetailClick = { player ->
                    navController.navigate(AppScreen.playerDetail(player.number))
                },
                mainViewModel = mainViewModel
            )
        }

        composable(
            route = AppScreen.PLAYER_DETAIL,
            arguments = listOf(
                navArgument(AppScreen.PLAYER_NUMBER_ARG) {
                    type = NavType.IntType
                }
            )) { backStackEntry ->
            val playerNumber = backStackEntry.arguments?.getInt(
                AppScreen.PLAYER_NUMBER_ARG
            )

            val player = mainViewModel.findPlayerByNumber(playerNumber)

            if (player != null) {
                PlayerDetailScreen(
                    player = player,
                    onBackClick = {
                        navController.popBackStack()
                    })
            } else {
                PlayerNotFoundScreen(
                    onBackClick = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}
