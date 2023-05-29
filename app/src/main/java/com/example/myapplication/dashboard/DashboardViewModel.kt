package com.example.myapplication.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.server.api.FoodClient
import com.example.myapplication.server.api.entities.Categories
import com.example.myapplication.server.api.entities.FavoriteCategory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DashboardViewModel : ViewModel()
{
    private var _categories = MutableLiveData<ArrayList<FavoriteCategory>>()
    var categories: LiveData<ArrayList<FavoriteCategory>>  = _categories

    fun populateList()
    {

        val fC =  FoodClient()

        // тут корутина отрабатывает
        viewModelScope.launch(Dispatchers.Main) {
            val categories: Categories? = fC.getCategories()
            if (categories != null) {
                _categories.value = categories.categories as ArrayList<FavoriteCategory>
            }

        }

    }


}