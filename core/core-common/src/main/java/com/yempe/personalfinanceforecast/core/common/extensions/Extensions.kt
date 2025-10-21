package com.yempe.personalfinanceforecast.core.common.extensions

import com.yempe.personalfinanceforecast.core.common.result.ResultData

suspend fun <T> safeCall(block: suspend () -> T): ResultData<T> {
    return try {
        ResultData.Success(block())
    } catch (e: Exception) {
        ResultData.Error(e)
    }
}