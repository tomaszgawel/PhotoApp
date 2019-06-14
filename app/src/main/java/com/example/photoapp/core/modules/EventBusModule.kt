package com.example.photoapp.core.modules

import com.google.common.eventbus.EventBus
import dagger.Module
import dagger.Provides

import javax.inject.Singleton

@Module
class EventBusModule {

    @Provides
    @Singleton
    fun provideEventBus(): EventBus {
        return EventBus()
    }
}
