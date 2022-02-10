package com.example.loginapirest.core

import com.example.loginapirest.core.Constants.BASE_URL_RETROFIT
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL_RETROFIT)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}