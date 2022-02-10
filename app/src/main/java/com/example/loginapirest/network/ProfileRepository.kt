package com.example.loginapirest.network

import com.example.loginapirest.model.ResponseProfileData
import com.example.loginapirest.network.retrofit.DataProvider
import com.example.loginapirest.network.retrofit.ProfileServices

class ProfileRepository {
    private val api = ProfileServices()

    suspend fun getProfileData(): ResponseProfileData? {
        val response: ResponseProfileData? = api.getProfileData()
        if (response != null) {
            DataProvider.profile = response
        }
        return response
    }
}