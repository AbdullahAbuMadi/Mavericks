package com.abumadi.topicssample.api.responses

data class TopicsResponse(
    val Topics: List<Topic> = emptyList()
) {
    data class Topic(

        val ImageLink: String? = null,
        val Name: String? = null,
        val id: Int? = null
    )
}