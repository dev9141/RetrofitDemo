package com.example.retrofitdemo.retrofit

import com.example.retrofitdemo.model.UserModel
import kotlinx.coroutines.Deferred
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface APIInterface {
    @GET("users")
    fun getUserListWithResponse(): Call<ResponseBody>
    @GET("users")
    fun getUserListWithList(): Call<List<UserModel>>
    @GET("users")
    fun getUserListWithMVVMListAsync(): Deferred<Response<List<UserModel>>>
}