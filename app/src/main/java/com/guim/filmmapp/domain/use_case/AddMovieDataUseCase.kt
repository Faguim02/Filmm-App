package com.guim.filmmapp.domain.use_case

import com.example.movieapp.domain.model.MovieData
import com.guim.filmmapp.data.repository.FilmmRepositoryRoom
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AddMovieDataUseCase @Inject constructor(
    private val repositoryRoom: FilmmRepositoryRoom
) {
    suspend operator fun invoke(movieData: MovieData) = flow {
        emit(repositoryRoom.addMovie(movieData))
    }
}