package com.guim.filmmapp.domain.repository

import com.example.movieapp.data.dto.MovieDataDto
import com.example.movieapp.data.dto.SearchResultTdo

interface RemoteDataRepository {
    suspend fun getMovieData(title: String): MovieDataDto

    suspend fun getSearchResult(search: String): SearchResultTdo
}