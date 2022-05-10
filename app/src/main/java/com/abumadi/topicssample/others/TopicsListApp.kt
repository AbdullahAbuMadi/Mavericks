package com.abumadi.topicssample.others

import android.app.Application
import com.abumadi.topicssample.api.remote.ApiService
import com.abumadi.topicssample.data.source.TopicsListRepository
import com.abumadi.topicssample.data.test.RetrofitClient
import com.airbnb.mvrx.Mavericks

class TopicsListApp : Application() {

    companion object {
        val apiService: ApiService by lazy {
            RetrofitClient.getApiService()
        }
    }

    val topicsListRepository by lazy {
        TopicsListRepository(apiService)
    }

    override fun onCreate() {
        Mavericks.initialize(this)
        super.onCreate()
    }
}
