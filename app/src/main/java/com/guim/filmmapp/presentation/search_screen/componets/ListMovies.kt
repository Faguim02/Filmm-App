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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.movieapp.data.dto.Movie
import com.example.movieapp.domain.model.SearchResult
import com.guim.filmmapp.ui.theme.FilmmAppTheme


@Composable
fun ListMovies(searchResult: SearchResult, onItemClick: (title: String) -> Unit) {

    LazyColumn {
        items(searchResult.movies) {movie ->
            CardMovie(movie, onItemClick = onItemClick)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardMovie(
    movie: Movie,
    onItemClick: (title: String) -> Unit
) {
    Card(
        onClick = { onItemClick(movie.title) },
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

            AsyncImage(
                contentDescription = "null",
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Black, RoundedCornerShape(4.dp)),
                model = movie.poster,
                contentScale = ContentScale.Crop
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

//@Composable
//@Preview()
//fun ListMoviePreview() {
//    FilmmAppTheme {
//        Scaffold(
//            modifier = Modifier
//                .fillMaxSize()
//                .background(MaterialTheme.colorScheme.background)
//                .padding(vertical = 8.dp)
//        ) { padding ->
//            Column(modifier = Modifier.padding(padding)) {
//                ListMovies()
//            }
//        }
//
//    }
//}