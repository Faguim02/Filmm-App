package com.example.movieapp.data.dto


import com.example.movieapp.domain.model.SearchResult
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchResultTdo(
    @Json(name = "Search")
    val movies: List<Movie>,
    @Json(name = "totalResults")
    val totalResults: String,
    @Json(name = "Response")
    val response: String
)

fun SearchResultTdo.toSearchResult(): SearchResult {
    return SearchResult(movies = movies)
}