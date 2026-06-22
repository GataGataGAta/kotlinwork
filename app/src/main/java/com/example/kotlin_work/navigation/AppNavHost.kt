package com.example.kotlin_work.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.kotlin_work.ui.MainRoute
import com.example.kotlin_work.ui.PlayerDetailRoute
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
            MainRoute(
                name = "Android",
                mainViewModel = mainViewModel,
                onPlayerDetailClick = { player ->
                    navController.navigate(AppScreen.playerDetail(player.number))
                }
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
            PlayerDetailRoute(
                playerNumber = playerNumber,
                mainViewModel = mainViewModel,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
