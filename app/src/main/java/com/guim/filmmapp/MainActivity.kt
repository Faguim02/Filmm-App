package com.guim.filmmapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.movieapp.data.dto.Rating
import com.example.movieapp.domain.model.MovieData
import com.guim.filmmapp.presentation.movie_screen.MovieScreen
import com.guim.filmmapp.presentation.search_screen.SearchScreen
import com.guim.filmmapp.ui.theme.FilmmAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FilmmAppTheme {

                val movie = MovieData(
                    title = "The Shawshank",
                    year = "1994",
                    rated = "R",
                    released = "10 Jun 1994",
                    runtime = "142 min",
                    genre = "Drama, Romance, amor, yat, ausi, a",
                    director = "Frank Darabont",
                    writer = "Stephen King (short story \"Rita Hayworth and Shawshank Redemption\"), Frank Darabont (screenplay)",
                    actors = "Tim Robbins, Morgan Freeman, Bob Gunton, William Sadler",
                    plot = "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.",
                    language = "English",
                    country = "USA",
                    awards = "Nominated for 7 Oscars. Another 21 wins & 35 nominations.",
                    poster = "https://www.imdb.com/title/tt0111161/mediaviewer/rm3166845184/",
                    ratings = listOf(
                        Rating(source = "Internet Movie Database", value = "9.3/10"),
                        Rating(source = "Rotten Tomatoes", value = "91%"),
                        Rating(source = "Metacritic", value = "80/100")
                    ),
                    imdbRating = "9.3",
                    boxOffice = "$28,341,469",
                    production = "Columbia Pictures"
                )
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    MovieScreen(movie)
                }
            }
        }
    }
}