package com.abumadi.topicssample.di.component

import com.abumadi.topicssample.di.modules.AppModule
import com.abumadi.topicssample.di.modules.NetworkModule
import com.abumadi.topicssample.di.modules.ViewModelsModule
import com.abumadi.topicssample.others.TopicsListApp
import com.abumadi.topicssample.others.viewmodelfactory.AssistedViewModelFactory
import com.airbnb.mvrx.MavericksViewModel

import dagger.Component

import javax.inject.Singleton


@Singleton
@Component(modules = [NetworkModule::class, AppModule::class, ViewModelsModule::class])
interface AppComponent {
    fun viewModelFactories(): Map<Class<out MavericksViewModel<*>>, AssistedViewModelFactory<*, *>>
}