package com.abumadi.topicssample.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.abumadi.topicssample.api.responses.TopicsResponse
import com.abumadi.topicssample.data.source.TopicsListRepository
import com.abumadi.topicssample.others.TopicsListApp
import com.abumadi.topicssample.states.TopicsListState
import com.airbnb.mvrx.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TopicsListViewModel constructor(
    initialState: TopicsListState,
    private val repository: TopicsListRepository
) : MavericksViewModel<TopicsListState>(initialState) {

    init {
        getData()
    }

    private fun getData() = withState {
        suspend {
            repository.getTopicsList()
        }.execute(
            Dispatchers.IO,
            retainValue = TopicsListState::topics
        ) { copy(topics = it) }
    }

    companion object : MavericksViewModelFactory<TopicsListViewModel, TopicsListState> {
        override fun create(
            viewModelContext: ViewModelContext,
            state: TopicsListState
        ): TopicsListViewModel {
            //registration in app class >>initiation should be should in app  class
            val topicListRepository = viewModelContext.app<TopicsListApp>().topicsListRepository
            return TopicsListViewModel(state, topicListRepository)
        }
    }
}
