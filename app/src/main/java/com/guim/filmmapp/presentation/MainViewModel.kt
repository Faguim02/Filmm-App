package com.guim.filmmapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.dto.toMovieDate
import com.example.movieapp.data.dto.toSearchResult
import com.example.movieapp.domain.model.MovieData
import com.example.movieapp.domain.model.SearchResult
import com.guim.filmmapp.domain.model.MovieDB
import com.guim.filmmapp.domain.use_case.UseCases
import com.guim.filmmapp.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel(){

    private val _movieDataResponse = MutableStateFlow<Result<MovieData>>(Result.Idle)
    val movieDataResponse = _movieDataResponse.asStateFlow()

    private val _searchResponse = MutableStateFlow<Result<SearchResult>>(Result.Idle)
    val searchResponse = _searchResponse.asStateFlow()

    private val _moviesDataRoomResponse = MutableStateFlow<Flow<List<MovieDB>>>(emptyFlow())
    val moviesDataRoomResponse = _moviesDataRoomResponse.asStateFlow()

    private val _movieDataRoomResponse = MutableStateFlow<Flow<MovieDB>>(emptyFlow())
    val movieDataRoomResponse = _movieDataRoomResponse.asStateFlow()

    fun getMovieData( title: String ) = viewModelScope.launch {
        useCases.getMovieDataUseCase.invoke(title)
            .onStart {
                _movieDataResponse.value = Result.Loading
            }.catch {
                _movieDataResponse.value = Result.Error(it)
            }.collect {
                val result = it.toMovieDate()
                _movieDataResponse.value = Result.Sucess(result)
            }
    }

    fun getSearchResult(search: String) = viewModelScope.launch {
        useCases.getSearchDataUseCase.invoke(search)
            .onStart {
                _searchResponse.value = Result.Loading
            }.catch {
                _searchResponse.value = Result.Error(it)
            }.collect {
                val result = it.toSearchResult()
                _searchResponse.value = Result.Sucess(result)
            }
    }

    fun addMovieData(movieDB: MovieDB) = viewModelScope.launch {
        useCases.addMovieDataUseCase.invoke(movieDB)
    }

    fun removeMovieDataRoom(movieDB: MovieDB) = viewModelScope.launch {
        useCases.removeMovieDataUseCase.invoke(movieDB)
    }

    fun findAllMoviesRoom() = viewModelScope.launch {
        _moviesDataRoomResponse.value = useCases.findAllMovieDataCaseUse.invoke()
    }

    fun findOneMovieRoom(title: String) = viewModelScope.launch {
        _movieDataRoomResponse.value = useCases.findOneMovieDataCaseUse.invoke(title)
    }

}