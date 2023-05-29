package com.example.myapplication.server.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal class FoodApiServiceImpl(
    private val config: ClientConfig
) : Service by Retrofit.Builder()

    .baseUrl(config.rootUrl)
    .addConverterFactory(GsonConverterFactory.create())
    .client(OkHttpClient.Builder().(config.okHttpConfig)().build())
    .build()
    .create(Service::class.java)