package com.example.myapplication.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.Food
import com.example.myapplication.adapter.DashboardRecyclerAdapter
import com.example.myapplication.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment()
{
    private var _binding: FragmentDashboardBinding? = null
    private val foodItemsList: ArrayList<Food> = arrayListOf<Food>()

//     This property is only valid between onCreateView and
//     onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setHasOptionsMenu(true)

        populateList()

        // не трогать!!!
        val layoutManager = LinearLayoutManager(activity)

        var  recyclerAdapter = DashboardRecyclerAdapter(requireContext(), foodItemsList)

        var recyclerDashboard: RecyclerView = root.findViewById(R.id.foodItemsRV)
        recyclerDashboard.adapter = recyclerAdapter
        recyclerDashboard.layoutManager = layoutManager
        // не трогать!!!

        return root
    }

    override fun onDestroyView()
    {
        super.onDestroyView()
        _binding = null
    }

    private fun populateList()
    {
        for (i in 1..15)
        {
            val name = "Гречка, блюдо №$i"
            val price = "90.0"
            val food = Food(food_id = "i", food_name = name, food_price = price)
            foodItemsList.add(food)
        }
    }
}