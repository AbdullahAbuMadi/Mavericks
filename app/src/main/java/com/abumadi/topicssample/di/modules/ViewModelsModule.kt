package com.abumadi.topicssample.di.modules

import com.abumadi.topicssample.others.viewmodelfactory.AssistedViewModelFactory
import com.abumadi.topicssample.others.viewmodelfactory.ViewModelKey
import com.abumadi.topicssample.ui.viewmodels.TopicsListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelsModule() {

    @Binds
    @IntoMap
    @ViewModelKey(TopicsListViewModel::class)
    abstract fun topicsViewModelFactory(factory: TopicsListViewModel.Factory): AssistedViewModelFactory<*, *>

}