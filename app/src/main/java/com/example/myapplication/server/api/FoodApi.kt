package com.example.myapplication.server.api

import com.example.myapplication.server.api.entities.Categories


interface FoodApi {
    suspend fun getCategories():Categories?
}
