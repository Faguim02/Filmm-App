package com.guim.filmmapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.movieapp.domain.model.MovieData

@Database(entities = [MovieData::class], version = 1, exportSchema = true)
abstract class MovieDataBase: RoomDatabase() {
    abstract fun movieDao(): MovieDao
}