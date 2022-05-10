package com.abumadi.topicssample.data.source

import com.abumadi.topicssample.api.remote.ApiService
import com.abumadi.topicssample.api.responses.TopicsResponse
import javax.inject.Inject

class TopicsListRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getTopicsList(): List<TopicsResponse.Topic>? {
        return apiService.getTopicsList().body()?.Topics
    }
}
