package com.guim.filmmapp.presentation.search_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.guim.filmmapp.presentation.MainViewModel
import com.guim.filmmapp.presentation.search_screen.componets.ListMovies
import com.guim.filmmapp.presentation.search_screen.componets.MovieEmpty
import com.guim.filmmapp.presentation.search_screen.componets.TopBarComponent
import com.guim.filmmapp.ui.theme.FilmmAppTheme
import com.guim.filmmapp.util.Result

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    onItemClick: (title: String) -> Unit,
    mainViewModel: MainViewModel
) {

    var searchValue by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current
    var searchResponse = mainViewModel.searchResponse.collectAsState().value

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(vertical = 8.dp),
        topBar = {
            TopBarComponent()
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
                    },
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.Words,
                        imeAction = ImeAction.Search
                    ),
                    keyboardActions = KeyboardActions(
                        onSearch = {
                            if (searchValue.isNotBlank()) {
                                mainViewModel.getSearchResult(search = searchValue)
                                keyboardController?.hide()
                            }
                        }
                    )
                )
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    modifier = Modifier.height(56.dp).fillMaxWidth(1f),
                    onClick = {
                        if (searchValue.isNotBlank()) {
                            mainViewModel.getSearchResult(search = searchValue)
                            keyboardController?.hide()
                        }
                    },
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            when(searchResponse) {
                is Result.Idle -> MovieEmpty()
                is Result.Loading -> MovieEmpty()
                is Result.Error -> Text("Erro")
                is Result.Sucess -> {
                    val searchResult = searchResponse.data
                    ListMovies(
                        onItemClick = onItemClick,
                        searchResult = searchResult
                    )
                }
            }

        }
    }
}

//@Composable
//@Preview()
//fun ListMoviePreview() {
//    FilmmAppTheme {
//
//    }
//}