package com.example.spendwise.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.spendwise.R
import com.example.spendwise.data.dummyData
import com.example.spendwise.databinding.FragmentHomeBinding
import com.example.spendwise.databinding.FragmentLunchBinding
import com.example.spendwise.restrauntEpoxyController


class Lunch : Fragment() {

    private var _binding: FragmentLunchBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentLunchBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.apply {
            val restrauntController = restrauntEpoxyController(requireContext())
            epoxyRecyclerView6.setController(restrauntController)
            restrauntController.setData(dummyData.restraunts)
        }

        return root
    }
}