package com.guim.filmmapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.guim.filmmapp.domain.model.MovieDB

@Database(entities = [MovieDB::class], version = 1, exportSchema = true)
abstract class MovieDataBase: RoomDatabase() {
    abstract fun movieDao(): MovieDao
}