package com.guim.filmmapp.domain.use_case

import com.example.movieapp.domain.model.MovieData
import com.guim.filmmapp.data.repository.FilmmRepositoryRoom
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FindAllMovieDataCaseUse @Inject constructor(
    private val repositoryRoom: FilmmRepositoryRoom
) {
    suspend operator fun invoke(): Flow<List<MovieData>> = flow {
        emit(repositoryRoom.findAllMovies())
    }
}