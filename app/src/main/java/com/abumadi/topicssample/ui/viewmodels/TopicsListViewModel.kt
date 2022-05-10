package com.abumadi.topicssample.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.abumadi.topicssample.api.responses.TopicsResponse
import com.abumadi.topicssample.data.source.TopicsListRepository
import com.abumadi.topicssample.others.TopicsListApp
import com.abumadi.topicssample.states.TopicsListState
import com.airbnb.mvrx.*
import kotlinx.coroutines.launch

class TopicsListViewModel constructor(
    initialState: TopicsListState,
    private val repository: TopicsListRepository
) : MavericksViewModel<TopicsListState>(initialState) {
//TODO multibinding

    private val _topicsList = MutableLiveData<List<TopicsResponse.Topic>>()
    val topicsList: LiveData<List<TopicsResponse.Topic>>
        get() = _topicsList

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            _topicsList.value = repository.getTopicsList()
        }
        repository.getTopicsListState().execute {
            copy(topics = it)
        }
    }

//    init {
//        setState {
//            copy(topics = Loading())//changed state to loading
//        }
//    }
//
//    fun showRecyclerView() {
//        setState {
//            copy(topics = Success(listOf()))
//        }
//    }

    //        companion object : MavericksViewModelFactory<TopicsListViewModel, TopicsListState> {
//        override fun create(
//            viewModelContext: ViewModelContext,
//            state: TopicsListState
//        ): TopicsListViewModel {
//            val fragment =
//                (viewModelContext as FragmentViewModelContext).fragment<AllTopicsFragment>()
//            return fragment.viewModelFactory.create(viewModelContext,state)
//        }
//    }
//}
    companion object : MavericksViewModelFactory<TopicsListViewModel, TopicsListState> {
        override fun create(
            viewModelContext: ViewModelContext,
            state: TopicsListState
        ): TopicsListViewModel {
            //registration in app class
            val topicListRepository = viewModelContext.app<TopicsListApp>().topicsListRepository
            return TopicsListViewModel(state, topicListRepository)
        }
    }
}
