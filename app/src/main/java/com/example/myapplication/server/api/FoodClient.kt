package com.example.myapplication.server.api

import com.example.myapplication.server.api.entities.Categories
import retrofit2.HttpException


class FoodClient(
    clientConfig: ClientConfig = ClientConfig()
) : FoodApi {

    private val service = FoodApiServiceImpl(clientConfig)

    override suspend fun getCategories(): Categories? {
        var categories:Categories? = null

        try {
            categories = service.getCategories()
        } catch (_: HttpException) {

        }
        return categories
    }

}
