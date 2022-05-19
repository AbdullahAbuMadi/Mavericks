package com.abumadi.topicssample.ui.viewmodels

import com.abumadi.topicssample.api.responses.TopicsResponse
import com.abumadi.topicssample.data.source.TopicsListRepository
import com.abumadi.topicssample.states.TopicsListState
import io.mockk.mockk
import org.junit.Assert.*
import org.junit.Before
import com.airbnb.mvrx.test.MvRxTestRule
import io.mockk.coEvery
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import java.lang.Exception


private val FAKE_TOPIC_ONE = TopicsResponse.Topic(
    imageLink = "http://success/test1.com",
    name = "success/test1",
    1
)

private val FAKE_TOPIC_TWO = TopicsResponse.Topic(
    imageLink = "http://success/test2.com",
    name = "success/test2",
    2
)
private val FAKE_SUCCESS_TOPICS_LIST =
    listOf(FAKE_TOPIC_ONE, FAKE_TOPIC_TWO)

private val FAKE_FAILED_TOPICS_LIST = Exception("fake exception")

@ExperimentalCoroutinesApi
class TopicsListViewModelTest {

    @get:Rule
    val mvrxRule = MvRxTestRule()//this rule will initialize mavericks as test isolated with app


    private lateinit var topicsListRepository: TopicsListRepository
    private lateinit var state: TopicsListState
    private lateinit var topicsListViewModel: TopicsListViewModel


    @Before
    fun setUp() {
        state = TopicsListState()
        topicsListRepository = mockk()
        topicsListViewModel = TopicsListViewModel(state, topicsListRepository)
    }


    //getData() function
    @Test
    fun `getData_if data does not passed yet from repository_invoked data will be null`() =
        runTest {
            topicsListViewModel.getData()
            //without this >> state will return Loading always
            topicsListViewModel.awaitState()
            val currentState = topicsListViewModel.stateFlow.first()
            assertEquals(currentState.topics.invoke(), null)
        }

    @Test
    fun `getData_if Success data passed from repository_invoked data will be equal with passed data`() =
        runTest {
            coEvery { topicsListRepository.getTopicsList() } returns FAKE_SUCCESS_TOPICS_LIST
            topicsListViewModel.getData()
            topicsListViewModel.awaitState()
            val currentState =  topicsListViewModel.stateFlow.first()
            assertEquals(currentState.topics.invoke(), FAKE_SUCCESS_TOPICS_LIST)
        }

    @Test
    fun `getData_if data failed to passed from repository_invoked data will be equal null`() =
        runTest {
            coEvery { topicsListRepository.getTopicsList() } throws FAKE_FAILED_TOPICS_LIST
            topicsListViewModel.getData()
            topicsListViewModel.awaitState()
            val currentState = topicsListViewModel.stateFlow.first()
            assertEquals(currentState.topics.invoke(), null)
        }
}
