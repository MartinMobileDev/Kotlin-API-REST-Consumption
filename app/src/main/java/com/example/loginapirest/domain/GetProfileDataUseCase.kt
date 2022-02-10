package com.example.loginapirest.domain

import com.example.loginapirest.model.ResponseProfileData
import com.example.loginapirest.network.ProfileRepository

class GetProfileDataUseCase {
    private val repository = ProfileRepository()

    suspend operator fun invoke(): ResponseProfileData? = repository.getProfileData()
}