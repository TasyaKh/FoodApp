package com.example.myapplication.db.entities

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.server.api.entities.FavoriteCategory

@Dao
interface FavoriteCategoryDao {
    @Query("SELECT * FROM favoritecategory")
    fun getAll(): List<FavoriteCategory>

    @Query("SELECT * FROM favoritecategory where idCategory = :idCategory")
    fun getOne(idCategory: Int): FavoriteCategory?

    @Insert
    fun insertAll(vararg category: FavoriteCategory)

    @Delete
    fun delete(category: FavoriteCategory)
}
