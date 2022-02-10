package com.example.loginapirest.model

import com.google.gson.annotations.SerializedName


data class ResponseProfileData(

    @SerializedName("data") var data: Data? = Data(),
    @SerializedName("support") var support: Support? = Support()

)