package com.example.myapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.myapplication.R
import com.example.myapplication.adapter.DashboardRecyclerAdapter
import com.example.myapplication.db.entities.AppDatabase
import com.example.myapplication.server.api.entities.FavoriteCategory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavoriteFoodActivity : AppCompatActivity()
{
    lateinit var buttonBack : Button
    private var foodItemsList: MutableLiveData<ArrayList<FavoriteCategory>> = MutableLiveData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_dashboard)

//        buttonBack = findViewById(R.id.buttonBack)
//
//        buttonBack.setOnClickListener {
//            val intent = Intent(this@FavoriteFoodActivity, MainActivity::class.java)
//            startActivity(intent)
//        }

        val layoutManager = LinearLayoutManager(this)

        val recyclerAdapter = DashboardRecyclerAdapter(this, ArrayList())

        val recyclerDashboard: RecyclerView = findViewById(R.id.foodItemsRV)
        recyclerDashboard.adapter = recyclerAdapter
        recyclerDashboard.layoutManager = layoutManager

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "food"
        ).build()

        val cDao = db.categoryDao()

        foodItemsList.observe(this){
                recyclerAdapter.setCategories(it)
        }

        CoroutineScope(Dispatchers.IO).launch {

        val category: List<FavoriteCategory> = cDao.getAll()
        foodItemsList.postValue( category  as ArrayList<FavoriteCategory>)

        }


    }
}