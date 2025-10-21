package com.yempe.personalfinanceforecast.core.common.result

sealed class ResultData<out T> {

    data class Success<T>(val data: T) : ResultData<T>()

    data class Error(val exception: Exception) : ResultData<Nothing>()

    data object Loading : ResultData<Nothing>()
}