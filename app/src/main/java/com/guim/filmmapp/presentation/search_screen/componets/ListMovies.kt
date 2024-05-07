package com.guim.filmmapp.presentation.search_screen.componets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movieapp.data.dto.Movie
import com.example.movieapp.domain.model.SearchResult
import com.guim.filmmapp.ui.theme.FilmmAppTheme


@Composable
fun ListMovies(searchResult: List<Movie>) {

    LazyColumn {
        items(searchResult) {movie ->
            CardMovie(movie)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }

}

@Composable
fun CardMovie(
    movie: Movie
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        shape = RoundedCornerShape(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondary,
            contentColor = MaterialTheme.colorScheme.onSecondary
        )
    ) {
        Row {

            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Black, RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(
                    modifier = Modifier.padding(top = 8.dp),
                    text = movie.title,
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                )
                Text(
                    text = movie.year
                )
            }
        }
    }
}

@Composable
@Preview()
fun ListMoviePreview() {
    FilmmAppTheme {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(vertical = 8.dp)
        ) { padding ->
            Column(modifier = Modifier.padding(padding)) {
                //ListMovies()
            }
        }

    }
}