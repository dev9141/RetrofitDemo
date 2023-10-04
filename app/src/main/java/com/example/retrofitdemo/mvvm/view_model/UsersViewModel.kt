package com.example.retrofitdemo.mvvm.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitdemo.model.UserModel
import com.example.retrofitdemo.mvvm.APIRepository
import com.example.retrofitdemo.mvvm.APIResponseCallback

class UsersViewModel(private val repo: APIRepository): ViewModel() {
    val usersList = MutableLiveData<List<UserModel>>()
    val errorMessage = MutableLiveData<String>()

    suspend fun getUsersList(){
        repo.getAllUsers(object : APIResponseCallback<List<UserModel>>{
            override fun onSuccess(data: List<UserModel>) {
                usersList.value = data
            }

            override fun onFailure(message: String) {
                errorMessage.value = message
            }

        })
        /*call.enqueue(object : Callback<List<UserModel>>{
            override fun onResponse(
                call: Call<List<UserModel>>,
                response: Response<List<UserModel>>
            ) {
                usersList.value = response.body()
            }

            override fun onFailure(call: Call<List<UserModel>>, t: Throwable) {
                errorMessage.value = t.message
            }

        })*/
    }
}