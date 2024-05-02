package com.guim.filmmapp.domain.use_case

import com.example.movieapp.data.dto.SearchResultTdo
import com.guim.filmmapp.domain.repository.RemoteDataRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetSearchDataUseCase @Inject constructor(
    private val repository: RemoteDataRepository
) {
    suspend operator fun invoke(search: String): Flow<SearchResultTdo> = flow {
        emit(repository.getSearchResult(search = search))
    }
}