package com.guim.filmmapp.domain.use_case

data class UseCases(
    val getMovieDataUseCase: GetMovieDataUseCase,
    val getSearchDataUseCase: GetSearchDataUseCase,
    val addMovieDataUseCase: AddMovieDataUseCase,
    val removeMovieDataUseCase: RemoveMovieDataUseCase,
    val findOneMovieDataCaseUse: FindOneMovieDataCaseUse,
    val findAllMovieDataCaseUse: FindAllMovieDataCaseUse
)
