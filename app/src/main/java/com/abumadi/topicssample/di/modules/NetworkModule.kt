package com.abumadi.topicssample.di.modules

import com.abumadi.topicssample.api.remote.ApiService
import com.abumadi.topicssample.data.source.TopicsListRepository
import com.abumadi.topicssample.others.Constants
import dagger.Module
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import javax.inject.Singleton
import dagger.Provides
import retrofit2.converter.moshi.MoshiConverterFactory


@Module
 class NetworkModule() {

    @Provides
    @Singleton
    fun getApiService(): ApiService {

        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.MOCK_API_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        return retrofit.create(ApiService::class.java)
    }
}