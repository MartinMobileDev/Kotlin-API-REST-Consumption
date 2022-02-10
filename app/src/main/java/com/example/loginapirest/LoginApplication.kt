package com.example.loginapirest

import android.app.Application
import com.example.loginapirest.network.volley.ReqResAPI
class LoginApplication : Application() {
    companion object{
        lateinit var reqResAPI: ReqResAPI
    }

    override fun onCreate() {
        super.onCreate()

        //VOLLEY
        reqResAPI = ReqResAPI.getInstance(this)
    }
}