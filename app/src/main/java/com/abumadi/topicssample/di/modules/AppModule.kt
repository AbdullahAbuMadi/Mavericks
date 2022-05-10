package com.abumadi.topicssample.di.modules

import com.abumadi.topicssample.api.remote.ApiService
import com.abumadi.topicssample.data.source.TopicsListRepository
import com.abumadi.topicssample.others.TopicsListApp
import com.abumadi.topicssample.states.TopicsListState
import com.abumadi.topicssample.ui.viewmodels.TopicsListViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val apiService: ApiService) {

    @Singleton
    @Provides
    fun provideTopicsListRepository(
        apiService: ApiService
    ) = TopicsListRepository(apiService)

    @Provides
    @Singleton
    fun providesApiService(): ApiService = apiService


//    @Singleton
//    @Provides
//    fun provideTopicsListViewModel(
//        repository: TopicsListRepository,
//        initialState: TopicsListState
//
//    ) = TopicsListViewModel(repository,initialState)

}