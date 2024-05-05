package com.guim.filmmapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.movieapp.data.dto.Rating

@Entity
data class MovieDB (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val year: String,
    val rated: String,
    val released: String,
    val runtime: String,
    val genre: String,
    val director: String,
    val writer: String,
    val actors: String,
    val plot: String,
    val language: String,
    val country: String,
    val awards: String,
    val poster: String,

    val imdbRating: String,
    val boxOffice: String,
    val production: String,
)