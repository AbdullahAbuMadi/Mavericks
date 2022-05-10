package com.abumadi.topicssample.data.source

import com.abumadi.topicssample.api.remote.ApiService
import com.abumadi.topicssample.api.responses.TopicsResponse
import com.abumadi.topicssample.states.TopicModel
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TopicsListRepository constructor(private val apiService: ApiService) {

    suspend fun getTopicsList(): List<TopicsResponse.Topic>? {
        return apiService.getTopicsList().body()?.Topics
    }
}
