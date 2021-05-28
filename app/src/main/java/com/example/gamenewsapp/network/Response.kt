package com.example.gamenewsapp.network

import android.util.Log
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

inline fun <R> proceedResponse(requestBlock: () -> Either.Success<R>): Either<BaseError, R> {
    return try {
        requestBlock.invoke()
    } catch (e: Exception) {
        e.printStackTrace()
        Log.e("___", "Proceed Retrofit Exception: " + e.localizedMessage)
        return when (e) {
            is HttpException -> Either.Failure(BaseError.NetworkError(code = e.code()))
            is UnknownHostException,
            is ConnectException,
            is SocketTimeoutException -> Either.Failure(BaseError.NetworkError(message = e.localizedMessage))
            else -> Either.Failure(BaseError.OtherError(TypeError.OTHER))
        }
    }
}