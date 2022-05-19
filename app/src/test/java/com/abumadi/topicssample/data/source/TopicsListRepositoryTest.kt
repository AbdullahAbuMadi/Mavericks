package com.abumadi.topicssample.data.source

import com.abumadi.topicssample.api.remote.ApiService
import com.abumadi.topicssample.api.responses.TopicsResponse
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertNotEquals
import kotlin.test.assertFails
import org.junit.Before
import org.junit.Test

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
private val FAKE_SUCCESS_TOPICS_LIST: TopicsResponse =
    TopicsResponse(
        listOf(FAKE_TOPIC_ONE, FAKE_TOPIC_TWO)
    )

private val FAKE_FAILED_TOPICS_LIST = Exception("fake failed exception")

class TopicsListRepositoryTest {

    lateinit var apiService: ApiService
    lateinit var topicsListRepository: TopicsListRepository

    @Before
    fun setUp() {
        apiService = mockk()
        topicsListRepository = TopicsListRepository(apiService)
    }

    //test cases
    //getTopicsList
    //if TopicsList successfully passed _topic list passed and getTopicsList will be equal
    @Test
    fun getTopicsList_ifTopicListSuccessfullyPassed_topicListPassedAndGetTopicsListWillBeEqual() =
        runBlocking {
            coEvery { apiService.getTopicsList() } returns FAKE_SUCCESS_TOPICS_LIST
            val result = topicsListRepository.getTopicsList()
            assertEquals(result, FAKE_SUCCESS_TOPICS_LIST.Topics)
        }

    //if TopicsList passed failed _topic list passed and getTopicsList will not be equal
    @Test
    fun getTopicsList_ifTopicListPassedFailed_topicListPassedAndGetTopicsListWillNotBeEqual() =
        runBlocking {
            coEvery { apiService.getTopicsList() } throws FAKE_FAILED_TOPICS_LIST
            val result = assertFails { topicsListRepository.getTopicsList() }
            assertEquals(result, FAKE_FAILED_TOPICS_LIST)
        }
}





















