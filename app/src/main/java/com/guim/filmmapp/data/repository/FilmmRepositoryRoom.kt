package com.guim.filmmapp.data.repository

import com.example.movieapp.domain.model.MovieData
import com.guim.filmmapp.data.local.MovieDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FilmmRepositoryRoom @Inject constructor(
    private val dao: MovieDao
) {

    suspend fun addMovie(movieData: MovieData) = dao.addMovie(movieData)

    suspend fun removeMovie(movieData: MovieData) = dao.removeMovie(movieData)

    suspend fun findOneMovie(title: String): MovieData = dao.findOneMovie(title)

    suspend fun findAllMovies(): List<MovieData> = dao.findAllMovies()

}