package com.guim.filmmapp.di

import android.content.Context
import androidx.room.Room
import com.guim.filmmapp.data.local.MovieDao
import com.guim.filmmapp.data.local.MovieDataBase
import com.guim.filmmapp.data.network.MovieApi
import com.guim.filmmapp.data.repository.FilmmRepository
import com.guim.filmmapp.data.repository.FilmmRepositoryRoom
import com.guim.filmmapp.domain.repository.RemoteDataRepository
import com.guim.filmmapp.domain.use_case.GetMovieDataUseCase
import com.guim.filmmapp.domain.use_case.GetSearchDataUseCase
import com.guim.filmmapp.domain.use_case.UseCases
import com.guim.filmmapp.util.Constants
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMoshi(): Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    @Provides
    @Singleton
    fun provideMovieApi(moshi: Moshi): MovieApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(MovieApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(api: MovieApi): RemoteDataRepository {
        return FilmmRepository(api)
    }

    @Provides
    @Singleton
    fun provideUseCase(repository: RemoteDataRepository): UseCases {
        return UseCases(
            getMovieDataUseCase = GetMovieDataUseCase(repository),
            getSearchDataUseCase = GetSearchDataUseCase(repository)
        )
    }

    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context: Context): MovieDataBase {
        return Room.databaseBuilder(
            context,
            MovieDataBase::class.java,
            "local_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideMovieDao(db: MovieDataBase): MovieDao = db.movieDao()

    @Provides
    @Singleton
    fun provideRespositoryRoom(dao: MovieDao): FilmmRepositoryRoom = FilmmRepositoryRoom(dao)

}