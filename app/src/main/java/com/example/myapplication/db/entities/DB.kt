package com.example.myapplication.db.entities

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.server.api.entities.FavoriteCategory

@Database(entities = [FavoriteCategory::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun categoryDao(): FavoriteCategoryDao

    companion object {
        var INSTANCE: AppDatabase? = null

        fun getAppDataBase(context: Context): AppDatabase? {
            if (INSTANCE == null){
                synchronized(AppDatabase::class){
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext, AppDatabase::class.java, "food")
                        .build()
                }
            }
            return INSTANCE
        }

        fun destroyDataBase(){
            INSTANCE = null
        }
    }
}