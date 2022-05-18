package com.abumadi.topicssample.ui.viewmodels

import android.util.Log
import android.widget.Toast
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.abumadi.topicssample.api.responses.TopicsResponse
import com.abumadi.topicssample.data.source.TopicsListRepository
import com.abumadi.topicssample.states.TopicsListState
import com.abumadi.topicssample.ui.view.TopicsItem
import io.mockk.mockk
import org.junit.Assert.*
import org.junit.Before
import com.airbnb.mvrx.*
import com.airbnb.mvrx.Async.Companion.getMetadata
import com.airbnb.mvrx.test.MvRxTestRule
import io.mockk.InternalPlatformDsl.toStr
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.impl.annotations.SpyK
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import retrofit2.Response
import java.lang.Exception


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
private val FAKE_SUCCESS_TOPICS_LIST =
    listOf(FAKE_TOPIC_ONE, FAKE_TOPIC_TWO)

//todo if we put co every in test function it is not working
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
        coEvery { topicsListRepository.getTopicsList() } returns FAKE_SUCCESS_TOPICS_LIST
        topicsListViewModel = TopicsListViewModel(state, topicsListRepository)
    }

    //data
    @ExperimentalCoroutinesApi
    @Test
    fun getData_ensureThatTheFakeSuccessTopicsListDataIsInvoked() = runTest {
        //TODO: you should call topicsListViewModel.getData() and test both success and failure cases
        val currentState = topicsListViewModel.stateFlow.first()
        assertEquals(currentState.topics.invoke(), FAKE_SUCCESS_TOPICS_LIST)
    }

    //state
    @ExperimentalCoroutinesApi
    @Test
    fun getData_ensureThatTheFakeSuccessTopicsListStateIsExecuted() = runTest {
        val currentState = topicsListViewModel.stateFlow.first()
            assertEquals(currentState.topics, Success(FAKE_SUCCESS_TOPICS_LIST))
    }
}
