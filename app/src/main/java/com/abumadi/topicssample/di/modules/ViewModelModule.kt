package com.abumadi.topicssample.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import com.abumadi.topicssample.states.TopicsListState
import com.abumadi.topicssample.ui.viewmodels.TopicsListViewModel
import com.airbnb.mvrx.MavericksViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

//
//@Module//provide all view models with one factory
//abstract class ViewModelModule() {
//
//    @Binds
//    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
//
//    @Binds
//    @IntoMap
//    @ViewModelKey(TopicsListViewModel::class)//key
//    internal abstract fun topicsListViewModel(viewModel: TopicsListViewModel): ViewModelFactory

//}