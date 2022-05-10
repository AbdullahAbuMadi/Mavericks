package com.abumadi.topicssample.data.test

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


//gson:A Java serialization/deserialization library to convert Java Objects into JSON and back
//moshi:A modern JSON library for Kotlin and Java.>> It’s modern, Kotlin friendly, fast, reliable with lots of features.
/*
* 1- add dependencies into your build.gradle file
* 2- Replace all @SerializedName annotations with @Json
* 3- Add @JsonClass(generateAdapter = true) annotation to all data classes >>not in my case ..just if we use @Json("")
* */

/*
*
* //            Glide
//                .with(context)
//                .load(topics.ImageLink)
//                .centerCrop()
//                .into(viewHolder.itemView.topic_imageview)*/