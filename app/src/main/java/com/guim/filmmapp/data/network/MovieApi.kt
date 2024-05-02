package com.guim.filmmapp.data.network

import com.example.movieapp.data.dto.MovieDataDto
import com.example.movieapp.data.dto.SearchResultTdo
import com.guim.filmmapp.util.Constants
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface MovieApi {

    @GET("/")
    suspend fun getMovieData(
        @Query("apikey") apiKey: String = Constants.API_KEY,
        @QueryMap options: Map<String, String> = mapOf("plot" to "full", "type" to "movie"),
        @Query("t") title: String
    ): MovieDataDto

    @GET("/")
    suspend fun getSearchResult(
        @Query("apikey") apiKey: String = Constants.API_KEY,
        @Query("type") type: String = "movie",
        @Query("s") search: String
    ): SearchResultTdo
}