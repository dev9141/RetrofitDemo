package com.example.retrofitdemo.mvvm

import android.util.Log
import com.example.retrofitdemo.model.UserModel
import com.example.retrofitdemo.retrofit.APIInterface
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class APIServiceImpl(private val apiInterface: APIInterface): APIRepository {
    override suspend fun getAllUsers(callback: APIResponseCallback<List<UserModel>>) {
        CoroutineScope(Dispatchers.IO).launch {
            withContext(Dispatchers.IO){
                val response = apiInterface.getUserListWithMVVMListAsync()
                val answer = response.await()
                withContext((Dispatchers.Main)){
                    if(answer.isSuccessful){
                        callback.onSuccess(answer.body()!!)
                    }
                    else{
                        callback.onFailure(answer.message())
                    }
                    Log.e("MVVMCode", "Size: ${answer.body()!!}")
                }
            }

        }

    }
}