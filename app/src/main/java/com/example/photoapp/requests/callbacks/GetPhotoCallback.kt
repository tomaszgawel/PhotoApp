package com.example.photoapp.requests.callbacks

import android.util.Log
import com.example.photoapp.requests.models.PhotoModel
import com.google.common.eventbus.EventBus
import com.google.gson.Gson
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetPhotoCallback (var eventBus: EventBus) : Callback<JsonObject>  {

    override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
        eventBus.post(Gson().fromJson(response.body(), PhotoModel::class.java))
        Log.d("GetPhotosSuccess", response.body()!!.asJsonObject.toString())
    }

    override fun onFailure(call: Call<JsonObject>, t: Throwable) {
        Log.d("GetPhotosFail", t.localizedMessage)
    }
}