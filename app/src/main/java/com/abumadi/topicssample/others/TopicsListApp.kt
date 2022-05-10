package com.abumadi.topicssample.others

import android.app.Application
import com.abumadi.topicssample.api.remote.ApiService
import com.abumadi.topicssample.data.source.TopicsListRepository
import com.abumadi.topicssample.di.component.DaggerAppComponent
import com.airbnb.mvrx.Mavericks
import javax.inject.Inject

class TopicsListApp : Application() {

    @Inject
    lateinit var apiService: ApiService

    val topicsListRepository by lazy {
        TopicsListRepository(apiService)
    }

    override fun onCreate() {
        super.onCreate()
        Mavericks.initialize(this)
        val component = DaggerAppComponent.builder()
            .build()
        component.injectToAllTopicsListApp(this)
    }
}
