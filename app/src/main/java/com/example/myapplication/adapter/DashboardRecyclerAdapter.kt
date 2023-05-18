package com.example.myapplication.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.model.Food
import com.example.myapplication.activity.DescriptionActivity
import com.example.myapplication.databinding.FoodItemLayoutBinding

class DashboardRecyclerAdapter(private val context: Context, private val foodList: ArrayList<Food>)
    : RecyclerView.Adapter<DashboardRecyclerAdapter.DashboardViewHolder>()
{
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
            // intent.putExtra("book_id", book.bookId)
            context.startActivity(intent)
        }
    }

    class DashboardViewHolder(foodItemLayoutBinding: FoodItemLayoutBinding)
        : RecyclerView.ViewHolder(foodItemLayoutBinding.root){
        private val binding = foodItemLayoutBinding
         var imageView: ImageView = binding.imageView

        fun bind(food: Food)
        {
            binding.foodItemNameTV.text = food.food_name
            binding.foodItemPriceTV.text = "Rs. ${food.food_price}"
        }
    }
}