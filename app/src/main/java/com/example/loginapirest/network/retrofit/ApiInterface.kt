package com.example.loginapirest.network.retrofit

import com.example.loginapirest.model.ResponseProfileData
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("users/1")
    suspend fun getProfileData(): Response<ResponseProfileData>
}