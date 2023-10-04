package com.example.retrofitdemo.regular_api_call

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.retrofitdemo.R
import com.example.retrofitdemo.databinding.ActivityGetUserListBinding
import com.example.retrofitdemo.model.UserModel
import com.example.retrofitdemo.retrofit.APIClient
import com.example.retrofitdemo.retrofit.APIInterface
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetUserListActivity : AppCompatActivity() {
    lateinit var binding:ActivityGetUserListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_get_user_list)

        binding.btnCallApi.setOnClickListener {

            val call: Call<List<UserModel>> = APIClient.retrofitInstance.create(APIInterface::class.java).getUserListWithList()
            call.enqueue(object : Callback<List<UserModel>>{

                override fun onResponse(
                    call: Call<List<UserModel>>,
                    response: Response<List<UserModel>>
                ) {
                    if(response.isSuccessful) {
                        val responseString = response.body()!!
                        binding.tvResponse.text = responseString.size.toString()
                    }
                }

                override fun onFailure(call: Call<List<UserModel>>, t: Throwable) {
                }

            })
        }
        binding.btnCallApiResponse.setOnClickListener {
            val callWithResponse: Call<ResponseBody> = APIClient.retrofitInstance.create(APIInterface::class.java).getUserListWithResponse()
                callWithResponse.enqueue(object : Callback<ResponseBody>{
                    override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                        Log.e("RetrofitResponse", "RetrofitResponse: ${response.isSuccessful}")
                        if(response.isSuccessful) {
                            val responseString:String = response.body()!!.string()
                            binding.tvResponseJSON.text = responseString
                        }
                    }

                    override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    }

                })
            }
    }
}