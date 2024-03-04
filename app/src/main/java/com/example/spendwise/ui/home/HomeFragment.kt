package com.example.spendwise.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.spendwise.databinding.FragmentHomeBinding
import com.example.spendwise.data.dummyData
import com.example.spendwise.ui.FiltersEpoxyController
import com.example.spendwise.ui.ItemEpoxyController

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.apply {

            val filtersListController = FiltersEpoxyController(requireContext())
            epoxyRecyclerView.setController(filtersListController)
            filtersListController.setData(dummyData.filtersList)

            val subscriptionListController = ItemEpoxyController(requireContext(),true)
            epoxyRecyclerView2.setController(subscriptionListController)
            subscriptionListController.setData(dummyData.subscriptionList)

            val popularMealsListController = ItemEpoxyController(requireContext(),false)
            epoxyRecyclerView3.setController(popularMealsListController)
            popularMealsListController.setData(dummyData.popularMealsList)

            val offersListController = ItemEpoxyController(requireContext(),false)
            epoxyRecyclerView4.setController(offersListController)
            offersListController.setData(dummyData.offersList)

        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}