package com.example.myapplication.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.myapplication.R
import com.example.myapplication.adapter.DashboardRecyclerAdapter
import com.example.myapplication.databinding.FragmentDashboardBinding
import com.example.myapplication.db.entities.AppDatabase
import com.example.myapplication.server.api.entities.FavoriteCategory

class DashboardFragment : Fragment()
{
    private var _binding: FragmentDashboardBinding? = null
    private var foodItemsList: ArrayList<FavoriteCategory> = arrayListOf()

//     This property is only valid between onCreateView and
//     onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)


        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setHasOptionsMenu(true)


        // не трогать!!!
        val layoutManager = LinearLayoutManager(activity)

        var  recyclerAdapter = DashboardRecyclerAdapter(requireContext(), foodItemsList)

        var recyclerDashboard: RecyclerView = root.findViewById(R.id.foodItemsRV)
        recyclerDashboard.adapter = recyclerAdapter
        recyclerDashboard.layoutManager = layoutManager

        // не трогать!!!

        dashboardViewModel.populateList()

        dashboardViewModel.categories.observe(viewLifecycleOwner){
            recyclerAdapter.setCategories(it)
        }

        return root
    }

    override fun onDestroyView()
    {
        super.onDestroyView()
        _binding = null
    }

}