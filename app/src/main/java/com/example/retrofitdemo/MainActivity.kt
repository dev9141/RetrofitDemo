package com.example.retrofitdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.retrofitdemo.databinding.ActivityMainBinding
import com.example.retrofitdemo.regular_api_call.GetUserListActivity
import com.example.retrofitdemo.regular_api_call.GetUserListMVVMActivity

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btnRegularApi.setOnClickListener {
            startActivity(Intent(this, GetUserListActivity::class.java))
        }

        binding.btnMvvmApi.setOnClickListener {
            startActivity(Intent(this, GetUserListMVVMActivity::class.java))
        }
    }
}