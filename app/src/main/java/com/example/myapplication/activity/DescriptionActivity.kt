package com.example.myapplication.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.myapplication.R
import com.example.myapplication.server.api.entities.FavoriteCategory
import com.squareup.picasso.Picasso

class DescriptionActivity : AppCompatActivity()
{
    lateinit var buttonBack : Button

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)

        buttonBack = findViewById(R.id.buttonBack)

        buttonBack.setOnClickListener {
            val intent = Intent(this@DescriptionActivity, MainActivity::class.java)
            startActivity(intent)
        }

        val category = intent.getSerializableExtra("foodItem") as? FavoriteCategory


        val imgFood:ImageView = findViewById(R.id.imgFood)
        val descr:TextView = findViewById(R.id.foodDescription)
        val foodName:TextView = findViewById(R.id.foodName)
        if (category != null) {
            Picasso.get().load(category.strCategoryThumb).into(imgFood)
            descr.text = category.strCategoryDescription
            foodName.text = category.strCategory
        }
    }


}