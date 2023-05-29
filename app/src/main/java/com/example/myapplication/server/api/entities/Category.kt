package com.example.myapplication.server.api.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class Categories(
    val categories: List<FavoriteCategory>,

    ):java.io.Serializable

@Entity
data class  FavoriteCategory(
    @PrimaryKey val  idCategory: Int,
    @ColumnInfo(name = "strCategory") val strCategory: String,
    @ColumnInfo(name = "strCategoryThumb") val strCategoryThumb: String,
    @ColumnInfo(name = "strCategoryDescription") val strCategoryDescription: String,
):java.io.Serializable
