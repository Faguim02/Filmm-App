package com.guim.filmmapp.presentation.movie_screen

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import com.guim.filmmapp.presentation.MainViewModel
import com.guim.filmmapp.ui.theme.FilmmAppTheme
import com.guim.filmmapp.util.Result

@Composable
fun MovieScreen(title: String, mainViewModel: MainViewModel) {

    LaunchedEffect(
        key1 = true,
        block = {
            mainViewModel.getMovieData(title = title)
        }
    )

    val movieDataResponse = mainViewModel.movieDataResponse.collectAsState().value

    Scaffold {paddingValues ->

        AnimatedContent(
            targetState = movieDataResponse,
            label = "animated_content",
            modifier = Modifier.fillMaxWidth().padding(paddingValues),
            transitionSpec = {
                fadeIn(
                    animationSpec = tween(300, easing = LinearEasing)
                ) togetherWith fadeOut(
                    animationSpec = tween(300, easing = LinearEasing)
                )
            }
        ) {response ->
            when(response) {
                is Result.Sucess -> {
                    val movieData = response.data
                    MovieData(movieData)
                }
                is Result.Loading -> {
                    Text("Carregando")
                }
                is Result.Error -> {
                    Text("Erro")
                }
                else -> Unit
            }
        }


    }
}

@Composable
fun MovieData(movieData: MovieData) {

    val movieGenres = movieData.genre.split(",")

    var movieFavorited by remember { mutableStateOf(false) }

    val iconFavorited = when(movieFavorited) {
        true -> Icons.Rounded.FavoriteBorder
        else -> Icons.Rounded.Favorite
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
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

@Preview()
@Composable
fun MovieScreenPreview() {

}