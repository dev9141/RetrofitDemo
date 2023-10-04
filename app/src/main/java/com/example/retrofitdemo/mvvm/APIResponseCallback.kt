package com.example.retrofitdemo.mvvm

enum class APIStatus{
    SUCCESS,FAILURE
}

data class APIResponse<out T>(val status: APIStatus, val data: T, val message:String)

interface APIResponseCallback<T> {
    fun onSuccess(data: T)
    fun onFailure(message: String)
}