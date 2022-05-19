package com.abumadi.topicssample.di.modules

import com.abumadi.topicssample.api.remote.ApiService
import com.abumadi.topicssample.data.source.TopicsListRepository
import com.abumadi.topicssample.others.TopicsListApp
import com.abumadi.topicssample.others.viewmodelfactory.DaggerMavericksViewModelFactory
import com.abumadi.topicssample.others.viewmodelfactory.ViewModelKey
import com.abumadi.topicssample.states.TopicsListState
import com.abumadi.topicssample.ui.viewmodels.TopicsListViewModel
import com.squareup.moshi.Moshi
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
 class AppModule {

    @Singleton
    @Provides
    fun provideTopicsListRepository(
        apiService: ApiService
    ) = TopicsListRepository(apiService)
}