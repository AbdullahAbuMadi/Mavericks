package com.abumadi.topicssample.di.component

import com.abumadi.topicssample.di.modules.AppModule
import com.abumadi.topicssample.di.modules.NetworkModule
import com.abumadi.topicssample.others.TopicsListApp

import dagger.Component

import javax.inject.Singleton


@Singleton
@Component(modules = [NetworkModule::class, AppModule::class])
interface AppComponent {
//    fun injectToAllTopicsFragment(allTopicsFragment: AllTopicsFragment?)
    fun injectToAllTopicsListApp(topicsListApp: TopicsListApp?)
}