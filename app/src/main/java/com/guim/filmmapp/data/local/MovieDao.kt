package com.guim.filmmapp.data.local

import androidx.room.*
import com.guim.filmmapp.domain.model.MovieDB

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMovie(movieDB: MovieDB)

    @Delete
    suspend fun removeMovie(movieDB: MovieDB)

    @Query("SELECT * FROM MovieDB WHERE title = :title")
    suspend fun findOneMovie(title: String): MovieDB

    @Query("SELECT * FROM MovieDB")
    suspend fun findAllMovies(): List<MovieDB>

}