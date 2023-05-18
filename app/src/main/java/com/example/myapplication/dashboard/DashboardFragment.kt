package com.example.myapplication.dashboard

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.Food
import com.example.myapplication.adapter.DashboardRecyclerAdapter
import com.example.myapplication.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment()
{
    //lateinit var recyclerDashboard: RecyclerView
    /// не использовать его lateinit var layoutManager: RecyclerView.LayoutManager
    //lateinit var recyclerAdapter: DashboardRecyclerAdapter

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
        val dashboardViewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        setHasOptionsMenu(true)

        ///////////////recyclerDashboard = view.findViewById(R.id.foodItemsRV)

//        val textView: TextView = binding.foodItemsRV
//        dashboardViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }

        populateList()

        //setUpAdapter()

//        ниче не тогать!!!
        val layoutManager = LinearLayoutManager(activity)

        var  recyclerAdapter = DashboardRecyclerAdapter(requireContext(), foodItemsList)

        var recyclerDashboard: RecyclerView = root.findViewById(R.id.foodItemsRV)
        recyclerDashboard.adapter = recyclerAdapter
        recyclerDashboard.layoutManager = layoutManager
//        ниче не тогать!!!

        return root
        //return view
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
            val food = Food(book_id = "i", name = name, price = price)
            foodItemsList.add(food)
        }
    }
}