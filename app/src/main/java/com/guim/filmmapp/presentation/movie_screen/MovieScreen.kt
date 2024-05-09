package com.guim.filmmapp.presentation.movie_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.movieapp.data.dto.Rating
import com.example.movieapp.domain.model.MovieData
import com.guim.filmmapp.ui.theme.FilmmAppTheme

@Composable
fun MovieScreen(movieData: MovieData) {

    var movieFavorited by remember { mutableStateOf(false) }

    val iconFavorited = when(movieFavorited) {
        true -> Icons.Rounded.FavoriteBorder
        else -> Icons.Rounded.Favorite
    }

    val movieGenres = movieData.genre.split(",").map { it.trim() }

    Scaffold {paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
        ) {
            Box(
                contentAlignment = Alignment.BottomEnd
            ) {
                AsyncImage(
                    contentDescription = "null",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .background(Color.Black),
                    model = movieData.poster,
                )
                Text(
                    modifier = Modifier
                        .background(Color.Black, RoundedCornerShape(8.dp))
                        .padding(4.dp),
                    text = movieData.runtime,
                    style = TextStyle(
                        color = Color.White
                    )
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = movieData.title,
                    style = TextStyle(
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                )

                IconButton(
                    onClick = { movieFavorited = !movieFavorited }
                ) {
                    Icon(
                        imageVector = iconFavorited,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }

            Column(
                modifier = Modifier.wrapContentHeight()
            ) {
                LazyVerticalGrid(columns = GridCells.Fixed(4)) {
                    items(movieGenres) { genre ->
                        SuggestionChip(
                            modifier = Modifier.padding(horizontal = 8.dp),
                            colors = SuggestionChipDefaults.suggestionChipColors(
                                containerColor = MaterialTheme.colorScheme.secondary
                            ),
                            onClick = {},
                            label = {
                                Text(
                                    text = genre
                                )
                            }
                        )
                    }
                }
            }

            LazyColumn {
                item {
                    Column(modifier = Modifier.padding(8.dp)) {

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = "Autores: ${movieData.actors}",
                            fontSize = 18.sp
                        )
                        Text(
                            text = "Criado em: ${movieData.year}",
                            fontSize = 18.sp
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = movieData.plot,
                            style = TextStyle(
                                textAlign = TextAlign.Justify,
                                fontSize = 18.sp
                            )
                        )
                    }
                }
            }
        }
    }
}

@Preview()
@Composable
fun MovieScreenPreview() {

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

    FilmmAppTheme {
        MovieScreen(movie)
    }
}