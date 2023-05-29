package com.example.myapplication.server.api

import com.example.myapplication.server.api.entities.Categories
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Service {
    @GET("categories.php")
    suspend fun getCategories(): Categories
}