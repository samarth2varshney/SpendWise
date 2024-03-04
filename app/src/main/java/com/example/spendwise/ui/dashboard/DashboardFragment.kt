package com.example.spendwise.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.ToxicBakery.viewpager.transforms.CubeOutTransformer
import com.ToxicBakery.viewpager.transforms.RotateDownTransformer
import com.ToxicBakery.viewpager.transforms.RotateUpTransformer
import com.example.spendwise.CustomPagerAdapter
import com.example.spendwise.databinding.FragmentDashboardBinding


class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    var pageList: ArrayList<String> = arrayListOf()
    var viewPager: ViewPager? = null
    var pagerAdapter: CustomPagerAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        pageList = ArrayList()

        viewPager = binding.viewpager

        for (i in 0..14) {
            pageList.add("Page : " + (i + 1))
        }

        pagerAdapter = CustomPagerAdapter(requireContext(), pageList)
        viewPager!!.adapter = pagerAdapter

        viewPager!!.setPageTransformer(true, RotateUpTransformer())

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}