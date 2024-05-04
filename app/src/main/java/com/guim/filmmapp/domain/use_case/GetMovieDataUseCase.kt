package com.guim.filmmapp.domain.use_case

import com.example.movieapp.data.dto.MovieDataDto
import com.guim.filmmapp.domain.repository.RemoteDataRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMovieDataUseCase @Inject constructor(
    private val repository: RemoteDataRepository
) {
    suspend operator fun invoke(title: String): Flow<MovieDataDto> = flow {
        emit(repository.getMovieData(title = title))
    }
}