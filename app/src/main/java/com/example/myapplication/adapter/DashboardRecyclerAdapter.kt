package com.example.myapplication.adapter

import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteConstraintException
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.myapplication.activity.DescriptionActivity
import com.example.myapplication.databinding.FoodItemLayoutBinding
import com.example.myapplication.db.entities.AppDatabase
import com.example.myapplication.server.api.entities.FavoriteCategory
import com.squareup.picasso.Picasso
import kotlinx.coroutines.*

class DashboardRecyclerAdapter(private val context: Context, private var foodList: ArrayList<FavoriteCategory>)
    : RecyclerView.Adapter<DashboardRecyclerAdapter.DashboardViewHolder>()
{

   fun setCategories(foodList: ArrayList<FavoriteCategory>){
        this.foodList = foodList

       notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder
    {
        val binding = FoodItemLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return DashboardViewHolder(binding)
    }

    override fun getItemCount(): Int
    {
        return foodList.size
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int)
    {
        val foodItem = foodList[position]
        holder.bind(foodItem)


        holder.imageView.setOnClickListener{
            val intent = Intent(context, DescriptionActivity::class.java)
            intent.putExtra("foodItem", foodItem)
            context.startActivity(intent)
        }
    }

    class DashboardViewHolder(foodItemLayoutBinding: FoodItemLayoutBinding)
        : RecyclerView.ViewHolder(foodItemLayoutBinding.root){
        private val binding = foodItemLayoutBinding
         var imageView: ImageView = binding.imageView
         var favorite: CheckBox = binding.favorite

        fun bind(food: FavoriteCategory)
        {
            binding.foodItemNameTV.text = food.strCategory

            Picasso.get().load(food.strCategoryThumb).into(binding.imageView)


           val db = AppDatabase.getAppDataBase(context = binding.root.context)
           val categoryDao = db?.categoryDao()



            CoroutineScope(Dispatchers.IO).launch {
                val checkIfExists = categoryDao?.getOne(food.idCategory)

                favorite.isChecked = checkIfExists != null

            }

            favorite.setOnClickListener() { buttonView ->
                run {

                    val cDB = food


                    CoroutineScope(Dispatchers.IO).launch {

                       val checkIfExists = categoryDao?.getOne(cDB.idCategory)

                        //Log.d("ffffffffffffff", checkIfExists.toString())
                        if (favorite.isChecked && checkIfExists == null){
                            try {
                                categoryDao?.insertAll(cDB)
                            }catch (ex: SQLiteConstraintException){

                            }
                        }
                        else {
                            categoryDao?.delete(cDB)
                        }
                    }

                }
            }

        }
    }
}