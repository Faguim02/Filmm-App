package com.guim.filmmapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.guim.filmmapp.presentation.MainViewModel
import com.guim.filmmapp.presentation.favorites_screen.FavoritesScreen
import com.guim.filmmapp.presentation.movie_screen.MovieScreen
import com.guim.filmmapp.presentation.search_screen.SearchScreen

@Composable
fun AppNavigation(
    mainViewModel: MainViewModel
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.SearchScreen.name) {
        composable(
            route = Screen.SearchScreen.name
        ) {
            SearchScreen(mainViewModel = mainViewModel, onItemClick = {title: String ->  
                navController.navigate(route = "${Screen.MovieScreen}/$title")
            })
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
                MovieScreen(title = title!!, mainViewModel = mainViewModel)
            }
        }
    }
}