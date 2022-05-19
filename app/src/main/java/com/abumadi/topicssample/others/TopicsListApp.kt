package com.abumadi.topicssample.others

import android.app.Application
import com.abumadi.topicssample.di.component.AppComponent
import com.abumadi.topicssample.di.component.DaggerAppComponent
import com.airbnb.mvrx.mocking.MockableMavericks

class TopicsListApp : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
        MockableMavericks.initialize(this)
    }
}
