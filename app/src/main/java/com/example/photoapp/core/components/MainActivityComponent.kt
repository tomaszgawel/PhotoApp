package com.example.photoapp.core.components

import com.example.photoapp.MainActivity
import com.example.photoapp.core.modules.EventBusModule
import com.example.photoapp.core.modules.RetrofitModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [EventBusModule::class, RetrofitModule::class])
interface MainActivityComponent {
    fun inject(activity: MainActivity)
}