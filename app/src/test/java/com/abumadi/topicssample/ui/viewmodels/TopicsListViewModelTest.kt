package com.abumadi.topicssample.ui.viewmodels

import com.abumadi.topicssample.api.responses.TopicsResponse
import com.abumadi.topicssample.data.source.TopicsListRepository
import com.abumadi.topicssample.states.TopicsListState
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import org.junit.Assert.*
import org.junit.Before
import com.airbnb.mvrx.*
import io.mockk.coEvery
import io.mockk.every
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import retrofit2.Response


private val FAKE_TOPIC_ONE = TopicsResponse.Topic(
    ImageLink = "http://success/test1.com",
    Name = "success/test1",
    1
)

private val FAKE_TOPIC_TWO = TopicsResponse.Topic(
    ImageLink = "http://success/test2.com",
    Name = "success/test2",
    2
)
private val FAKE_SUCCESS_TOPICS_LIST: List<TopicsResponse.Topic> =
    listOf(FAKE_TOPIC_ONE, FAKE_TOPIC_TWO)


private val FAKE_FAILED_TOPICS_LIST: List<TopicsResponse.Topic> =
    listOf()

@RunWith(RobolectricTestRunner::class)
class TopicsListViewModelTest(initialState: TopicsListState) :
    MavericksViewModel<TopicsListState>(initialState) {


    private lateinit var topicsListRepository: TopicsListRepository
    private lateinit var state: TopicsListState
    private lateinit var topicsListViewModel: TopicsListViewModel


    @Before
    fun setUp() {
        state = mockk()
        topicsListRepository = mockk()
        topicsListViewModel = TopicsListViewModel(state, topicsListRepository)

//        suspend {
//            topicsListRepository.getTopicsList()
//        }.execute(
//            Dispatchers.IO,
//            retainValue = TopicsListState::topics
//        ) { copy(topics = it) }
    }

    @Test
    fun test() = runBlocking {
        coEvery { topicsListRepository.getTopicsList() } returns FAKE_SUCCESS_TOPICS_LIST
        val states = setState {
            copy(topics = Success(FAKE_SUCCESS_TOPICS_LIST))
        }

        val result = state.topics
        assertEquals(result, states)


    }
}