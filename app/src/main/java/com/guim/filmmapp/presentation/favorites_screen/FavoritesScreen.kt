package com.guim.filmmapp.presentation.favorites_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movieapp.data.dto.Movie
import com.guim.filmmapp.presentation.search_screen.componets.ListMovies
import com.guim.filmmapp.presentation.search_screen.componets.MovieEmpty
import com.guim.filmmapp.presentation.search_screen.componets.TopBarComponent
import com.guim.filmmapp.ui.theme.FilmmAppTheme

@Composable
fun FavoritesScreen() {

    val movies: List<Movie> = listOf(
        Movie("The Shawshank Redemption", "1994", "tt0111161", "movie", "https://www.example.com/poster1.jpg"),
        Movie("The Godfather", "1972", "tt0068646", "movie", "https://www.example.com/poster2.jpg"),
        Movie("The Dark Knight", "2008", "tt0468569", "movie", "https://www.example.com/poster3.jpg"),
        Movie("Pulp Fiction", "1994", "tt0110912", "movie", "https://www.example.com/poster4.jpg"),
        Movie("The Lord of the Rings: The Return of the King", "2003", "tt0167260", "movie", "https://www.example.com/poster5.jpg"),
        Movie("Forrest Gump", "1994", "tt0109830", "movie", "https://www.example.com/poster6.jpg"),
        Movie("Inception", "2010", "tt1375666", "movie", "https://www.example.com/poster7.jpg"),
        Movie("Fight Club", "1999", "tt0137523", "movie", "https://www.example.com/poster8.jpg"),
        Movie("The Matrix", "1999", "tt0133093", "movie", "https://www.example.com/poster9.jpg"),
        Movie("Goodfellas", "1990", "tt0099685", "movie", "https://www.example.com/poster10.jpg")
    )

    Scaffold(
        topBar = { TopBarComponent() }
    ) {paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth()
        ) {
            Text(
                text = "Favoritos",
                style = TextStyle(
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.SemiBold
                ),
                modifier = Modifier
                    .padding(start = 8.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            when {
                movies.isEmpty() -> MovieEmpty()
                else -> ListMovies(movies)
            }

        }
    }
}

@Preview()
@Composable
fun FavoritePreview() {
    FilmmAppTheme {
        FavoritesScreen()
    }
}