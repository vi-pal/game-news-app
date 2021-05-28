package com.example.gamenewsapp.network

sealed class BaseError(message: String? = null) : Exception(message) {
    class NetworkError(val code: Int? = null, message: String? = null) : BaseError()
    class ServerError(val code: Int, message: String? = null) : BaseError(message)
    class OtherError(val e: TypeError) : BaseError(message = e.name)
}

enum class TypeError {
    API_IS_NULL,
    OTHER
}