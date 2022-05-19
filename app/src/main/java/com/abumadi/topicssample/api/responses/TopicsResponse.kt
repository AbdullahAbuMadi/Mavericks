package com.abumadi.topicssample.api.responses

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TopicsResponse(
    val Topics: List<Topic> = emptyList()
) {
    data class Topic(

        @Json(name = "ImageLink")
        val imageLink: String? = null,
        @Json(name = "Name")
        val name: String? = null,
        val id: Int? = null
    )
}