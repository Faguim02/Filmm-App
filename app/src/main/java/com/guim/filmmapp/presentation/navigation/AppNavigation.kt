package com.guim.filmmapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.guim.filmmapp.presentation.favorites_screen.FavoritesScreen
import com.guim.filmmapp.presentation.movie_screen.MovieScreen
import com.guim.filmmapp.presentation.search_screen.SearchScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.SearchScreen.name) {
        composable(
            route = Screen.SearchScreen.name
        ) {
            SearchScreen()
        }

        composable(
            route = Screen.FavoriteScreen.name
        ) {
            FavoritesScreen()
        }

        composable(
            route = "${Screen.MovieScreen.name}/{title}",
            arguments = listOf(
                navArgument("title"){ type = NavType.StringType }
            )
        ) { navBackStackEntry ->
            navBackStackEntry.arguments?.getString("title").let {title ->
                MovieScreen(title = title!!)
            }
        }
    }
}