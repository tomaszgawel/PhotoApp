package com.example.photoapp.core.modules

import com.example.photoapp.requests.ApiClient
import com.example.photoapp.requests.ApiInterface
import com.google.common.eventbus.EventBus
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RetrofitModule{
    @Provides
    @Singleton
    fun provideRetrofitService(): ApiInterface {
        return ApiClient().client.create(ApiInterface::class.java)
    }
}
