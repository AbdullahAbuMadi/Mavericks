package com.abumadi.topicssample.ui.viewmodels

import com.abumadi.topicssample.data.source.TopicsListRepository
import com.abumadi.topicssample.others.viewmodelfactory.AssistedViewModelFactory
import com.abumadi.topicssample.others.viewmodelfactory.daggerMavericksViewModelFactory
import com.abumadi.topicssample.states.TopicsListState
import com.airbnb.mvrx.*
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

class TopicsListViewModel @AssistedInject constructor(
    @Assisted initialState: TopicsListState,
    private val repository: TopicsListRepository
) : MavericksViewModel<TopicsListState>(initialState) {

    fun getData() = withState {
            suspend {
                repository.getTopicsList()
            }.execute(
                retainValue = TopicsListState::topics
            ) { copy(topics = it) }
    }

    @AssistedFactory
    interface Factory : AssistedViewModelFactory<TopicsListViewModel, TopicsListState> {
        override fun create(state: TopicsListState): TopicsListViewModel
    }

    companion object :
        MavericksViewModelFactory<TopicsListViewModel, TopicsListState> by daggerMavericksViewModelFactory()
}
