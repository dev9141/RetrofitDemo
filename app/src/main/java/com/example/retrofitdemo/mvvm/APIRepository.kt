package com.example.retrofitdemo.mvvm

import com.example.retrofitdemo.model.UserModel

interface APIRepository{
    suspend fun getAllUsers(callback: APIResponseCallback<List<UserModel>>)
}