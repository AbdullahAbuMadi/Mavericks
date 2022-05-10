package com.abumadi.topicssample.api.responses

data class TopicsResponse(
    val Topics: List<Topic>
) {
    data class Topic(
        val ImageLink: String,
        val Name: String,
        val id: Int
    )
}