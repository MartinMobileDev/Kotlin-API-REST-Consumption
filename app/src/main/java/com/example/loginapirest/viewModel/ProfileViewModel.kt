package com.example.loginapirest.viewModel

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loginapirest.domain.GetProfileDataUseCase
import com.example.loginapirest.model.ResponseProfileData
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {
    val responseProfileData = MutableLiveData<ResponseProfileData>()

    var getProfileDataUseCase = GetProfileDataUseCase()

    @SuppressLint("NullSafeMutableLiveData")
    fun onCreate() {
        viewModelScope.launch {
            val result = getProfileDataUseCase()
            if (result != null) {
                responseProfileData.postValue(result)
            }
        }
    }
}