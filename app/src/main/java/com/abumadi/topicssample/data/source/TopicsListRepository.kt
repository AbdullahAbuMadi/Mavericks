package com.abumadi.topicssample.data.source

import com.abumadi.topicssample.api.remote.ApiService
import com.abumadi.topicssample.api.responses.TopicsResponse
import com.abumadi.topicssample.states.TopicModel
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TopicsListRepository constructor(private val apiService: ApiService) {
    //    TODO suspend function instead of flow
    fun getTopicsListState() = flow {
        emit(apiService.getTopicsList().body()!!.Topics)
    }

    suspend fun getTopicsList(): List<TopicsResponse.Topic> {
        return apiService.getTopicsList().body()!!.Topics
    }
}
//    companion object {
//        private val topics = ArrayList<TopicModel>()
//        fun getTopicList(): ArrayList<TopicModel>{
//            topics.addAll(
//                listOf(
//                    TopicModel(
//                        1,
//                        "Java",
//                        "https://i.imgur.com/oceYgAd.png"
//                    ),
//                    TopicModel(
//                        2,
//                        "Kotlin",
//                        "https://i.imgur.com/iekR0JT.png"
//                    ),
//                    TopicModel(
//                        3,
//                        "Sql D.B Language",
//                        "https://i.imgur.com/Ws6QPGz.png"
//                    ),
//                    TopicModel(
//                        4,
//                        "Data Structure",
//                        "https://i.imgur.com/EMSLUWQ.png"
//                    ),
//                    TopicModel(
//                        5,
//                        "Java 8",
//                        "https://i.imgur.com/lwn55wb.jpg"
//                    ),
//                    TopicModel(
//                        6,
//                        "Agile Methodology",
//                        "https://i.imgur.com/uh1qQjm.png"
//                    ),
//                    TopicModel(
//                        7,
//                        "Git Session",
//                        "https://i.imgur.com/Q5TzCBG.png"
//                    ),
//                    TopicModel(
//                        8,
//                        "Java Design Pattern",
//                        "https://i.imgur.com/i6CZ4AW.png"
//                    ),
//                    TopicModel(
//                        9,
//                        "Airbnb MavRx",
//                        "https://i.imgur.com/mIjBywy.png"
//                    ),
//                    TopicModel(
//                        10,
//                        "Android",
//                        "https://i.imgur.com/DxNiQ0m.png"
//                    )
//                )
//            )
//            return topics
//        }
//    }

//}


