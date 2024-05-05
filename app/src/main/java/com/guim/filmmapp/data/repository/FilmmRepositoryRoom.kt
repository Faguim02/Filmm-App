package com.guim.filmmapp.data.repository

import com.example.movieapp.domain.model.MovieData
import com.guim.filmmapp.data.local.MovieDao
import com.guim.filmmapp.domain.model.MovieDB
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FilmmRepositoryRoom @Inject constructor(
    private val dao: MovieDao
) {

    suspend fun addMovie(movieDB: MovieDB) = dao.addMovie(movieDB)

    suspend fun removeMovie(movieDB: MovieDB) = dao.removeMovie(movieDB)

    suspend fun findOneMovie(title: String): MovieDB = dao.findOneMovie(title)

    suspend fun findAllMovies(): List<MovieDB> = dao.findAllMovies()

}