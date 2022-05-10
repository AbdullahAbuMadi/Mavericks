package com.abumadi.topicssample.api.remote

import com.abumadi.topicssample.api.responses.TopicsResponse
import com.abumadi.topicssample.others.Constants
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET(Constants.MOCK_API_TOPICS)
    suspend fun getTopicsList(): Response<TopicsResponse>
}