package com.example.loginapirest.network.retrofit

import com.example.loginapirest.core.RetrofitHelper
import com.example.loginapirest.model.ResponseProfileData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProfileServices {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getProfileData(): ResponseProfileData? {
        return withContext(Dispatchers.IO){
            val response = retrofit.create(ApiInterface::class.java).getProfileData()
            response.body()
        }
    }
}