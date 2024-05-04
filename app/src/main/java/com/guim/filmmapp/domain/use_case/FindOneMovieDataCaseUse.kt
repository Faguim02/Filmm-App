package com.guim.filmmapp.domain.use_case

import com.example.movieapp.domain.model.MovieData
import com.guim.filmmapp.data.repository.FilmmRepositoryRoom
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FindOneMovieDataCaseUse @Inject constructor(
    private val repositoryRoom: FilmmRepositoryRoom
) {
    suspend operator fun invoke(title: String): Flow<MovieData> = flow {
        emit(repositoryRoom.findOneMovie(title = title))
    }
}