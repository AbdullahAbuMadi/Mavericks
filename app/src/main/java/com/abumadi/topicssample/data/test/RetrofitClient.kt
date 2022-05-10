package com.abumadi.topicssample.data.test

import com.abumadi.topicssample.api.remote.ApiService
import com.abumadi.topicssample.others.Constants
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitClient {

        fun getApiService(): ApiService {

            val retrofit = Retrofit.Builder()
                .baseUrl(Constants.MOCK_API_BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }
