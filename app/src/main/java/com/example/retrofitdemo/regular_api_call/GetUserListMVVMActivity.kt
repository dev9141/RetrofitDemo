package com.example.retrofitdemo.regular_api_call

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitdemo.retrofit.APIClient
import com.example.retrofitdemo.retrofit.APIInterface
import com.example.retrofitdemo.R
import com.example.retrofitdemo.model.UserModel
import com.example.retrofitdemo.databinding.ActivityGetUserListMvvmBinding
import com.example.retrofitdemo.mvvm.APIServiceImpl
import com.example.retrofitdemo.mvvm.ViewModelFactory
import com.example.retrofitdemo.mvvm.view_model.UsersViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope
import okhttp3.Dispatcher
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetUserListMVVMActivity : AppCompatActivity() {
    lateinit var binding:ActivityGetUserListMvvmBinding
    lateinit var vm: UsersViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_get_user_list_mvvm)
        vm = ViewModelProvider(this, ViewModelFactory(APIServiceImpl(APIClient.retrofitInstance.create(APIInterface::class.java))))[UsersViewModel::class.java]

        setObserver()

        binding.btnCallApi.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch{
                vm.getUsersList()
            }
        }
        binding.btnCallApiResponse.setOnClickListener {

        }
    }

    private fun setObserver(){
        vm.usersList.observe(this){
            binding.tvResponse.text = "${it.size}"
        }
    }
}