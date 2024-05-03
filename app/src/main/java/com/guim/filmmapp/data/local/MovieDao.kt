package com.guim.filmmapp.data.local

import androidx.room.*
import com.example.movieapp.domain.model.MovieData
import kotlinx.coroutines.flow.Flow
//import retrofit2.http.Query

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMovie(movieData: MovieData)

    @Delete
    suspend fun removeMovie(movieData: MovieData)

    @Query("SELECT * FROM MovieData WHERE title = :title")
    suspend fun findOneMovie(title: String): MovieData

    @Query("SELECT * FROM MovieData")
    fun findAllMovies(): Flow<List<MovieData>>

}