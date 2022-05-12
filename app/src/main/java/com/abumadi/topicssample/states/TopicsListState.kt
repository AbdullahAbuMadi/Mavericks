package com.abumadi.topicssample.states

import com.abumadi.topicssample.api.responses.TopicsResponse
import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.Uninitialized

data class TopicsListState(
    val topics: Async<List<TopicsResponse.Topic>?> = Uninitialized
) : MavericksState