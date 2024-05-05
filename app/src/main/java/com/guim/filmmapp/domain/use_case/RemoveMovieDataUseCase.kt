package com.guim.filmmapp.domain.use_case

import com.guim.filmmapp.data.repository.FilmmRepositoryRoom
import com.guim.filmmapp.domain.model.MovieDB
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoveMovieDataUseCase @Inject constructor(
    private val repositoryRoom: FilmmRepositoryRoom
) {
    suspend operator fun invoke(movieDB: MovieDB) = flow {
        emit(repositoryRoom.removeMovie(movieDB))
    }
}