package com.example.retrofitdemo.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitdemo.model.UserModel
import com.example.retrofitdemo.mvvm.view_model.UsersViewModel
import com.example.retrofitdemo.retrofit.APIInterface

class ViewModelFactory(val repo: APIRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(UsersViewModel::class.java) -> {
                UsersViewModel(repo) as T
            }
            else -> {
                modelClass as T
            }
        }
    }
}