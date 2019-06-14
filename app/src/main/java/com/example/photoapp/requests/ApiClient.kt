package com.example.photoapp.requests

import com.example.photoapp.utils.Urls
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiClient {

    private lateinit var retrofit: Retrofit

    val client: Retrofit
        get() {
            retrofit = Retrofit.Builder()
                .baseUrl(Urls.baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit
        }

}
