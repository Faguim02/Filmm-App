package com.guim.filmmapp.presentation.search_screen.componets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.guim.filmmapp.R
import com.guim.filmmapp.ui.theme.FilmmAppTheme

@Composable
fun MovieEmpty() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .size(250.dp),
            painter = painterResource(R.drawable.ilustration_empty),
            contentDescription = null
        )
    }
}

@Preview()
@Composable
fun MovieEmptyPreview() {
    FilmmAppTheme {
        MovieEmpty()
    }
}