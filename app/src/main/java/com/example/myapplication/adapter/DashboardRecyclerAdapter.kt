package com.example.myapplication.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.model.Food
import com.example.myapplication.R
import com.example.myapplication.activity.DescriptionActivity
import com.example.myapplication.databinding.FoodItemLayoutBinding

class DashboardRecyclerAdapter(private val context: Context, private val foodList: ArrayList<Food>)
    : RecyclerView.Adapter<DashboardRecyclerAdapter.DashboardViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        val binding = FoodItemLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return DashboardViewHolder(binding)
    }

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder
//    {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.food_item_layout, parent, false)
//        return DashboardViewHolder(view)
//    }

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
            //intent.putExtra("book_id", book.bookId)
            context.startActivity(intent)
        }
    }

//    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int)
//    {
//        val food = foodList[position]
//        holder.foodItemName.text = food.name
//        holder.foodItemPrice.text = food.price
//
//        /////////Picasso.get().load(food.bookImage).error(R.drawable.default_book_cover).into(holder.imgBookImage)
//
//        holder.clcontent.setOnClickListener{
//            val intent = Intent(context, DescriptionActivity::class.java)
//            /////////intent.putExtra("book_id", food.bookId)
//            context.startActivity(intent)
//        }
//    }

    class DashboardViewHolder(foodItemLayoutBinding: FoodItemLayoutBinding)
        : RecyclerView.ViewHolder(foodItemLayoutBinding.root){
        private val binding = foodItemLayoutBinding
         var imageView: ImageView = binding.imageView

        fun bind(food: Food){
            binding.foodItemNameTV.text = food.name
            binding.foodItemPriceTV.text = "Rs. ${food.price}"
        }
    }

//    class DashboardViewHolder(view: View): RecyclerView.ViewHolder(view)
//    {
//        val foodItemName: TextView = view.findViewById(R.id.foodItemNameTV)
//        val foodItemPrice: TextView = view.findViewById(R.id.foodItemPriceTV)
//
//        //val clcontent: LinearLayout = view.findViewById(R.id.clcontent)
//
//        val clcontent: ConstraintLayout = view.findViewById(R.id.clcontent)
//
//    }
}