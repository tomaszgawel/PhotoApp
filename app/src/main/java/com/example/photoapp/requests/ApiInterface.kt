package com.example.photoapp.requests

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("getPhoto")
    fun getPhoto(): Call<JsonObject>

}