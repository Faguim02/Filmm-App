package com.guim.filmmapp.util

sealed interface Result<out T> {
    data object Idle: Result<Nothing>
    data object Loading: Result<Nothing>

    data class Sucess<out T> (val data: T): Result<T>
    data class Error(val erro: Throwable) : Result<Nothing>
}