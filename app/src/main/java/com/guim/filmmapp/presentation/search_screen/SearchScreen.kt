package com.guim.filmmapp.presentation.search_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.rounded.HeartBroken
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieapp.data.dto.Movie
import com.example.movieapp.domain.model.SearchResult
import com.guim.filmmapp.R
import com.guim.filmmapp.presentation.search_screen.componets.ListMovies
import com.guim.filmmapp.presentation.search_screen.componets.MovieEmpty
import com.guim.filmmapp.ui.theme.FilmmAppTheme

@Composable
fun SearchScreen() {

    var searchValue by remember { mutableStateOf("") }

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
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(vertical = 8.dp),
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(modifier = Modifier.size(32.dp))
                Image(
                    modifier = Modifier
                        .width(150.dp),
                    painter = painterResource(R.drawable.icon),
                    contentDescription = null
                )
                IconButton(onClick = {}){
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = null
                    )
                }
            }
        }
    ) {paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            Row(
                modifier = Modifier.padding(8.dp)
            ) {
                TextField(
                    modifier = Modifier
                        .fillMaxWidth(.8f)
                        .border(width = 1.dp, color = MaterialTheme.colorScheme.onSecondary, shape = RoundedCornerShape(4.dp)),
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent
                    ),
                    value = searchValue,
                    onValueChange = { searchValue = it },
                    placeholder = {
                        Text(
                            text = "Digite o filme que procura"
                        )
                    }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    modifier = Modifier.height(56.dp).fillMaxWidth(1f),
                    onClick = {},
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            when {
                movies.isEmpty() -> MovieEmpty()
                else -> ListMovies(movies)
            }

        }
    }
}

@Composable
@Preview()
fun ListMoviePreview() {
    FilmmAppTheme {
        SearchScreen()
    }
}