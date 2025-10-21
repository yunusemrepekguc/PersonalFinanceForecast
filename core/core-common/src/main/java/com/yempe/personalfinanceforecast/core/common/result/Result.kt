package com.yempe.personalfinanceforecast.core.common.result

sealed class Result<out T> {

    data class Success<T>(val data: T) : Result<T>()

    data class Error(val exception: Exception) : Result<Nothing>()

    data object Loading : Result<Nothing>()
}