package com.guim.filmmapp.data.repository

import com.example.movieapp.data.dto.MovieDataDto
import com.example.movieapp.data.dto.SearchResultTdo
import com.guim.filmmapp.data.network.MovieApi
import com.guim.filmmapp.domain.repository.RemoteDataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FilmmRepository @Inject constructor(
    private val api: MovieApi
): RemoteDataRepository {

    override
    suspend fun getMovieData(title: String): MovieDataDto {
        return withContext(Dispatchers.Default) {
            api.getMovieData(title = title)
        }
    }

    override
    suspend fun getSearchResult(search: String): SearchResultTdo {
        return withContext(Dispatchers.Default) {
            api.getSearchResult(search = search)
        }
    }

}