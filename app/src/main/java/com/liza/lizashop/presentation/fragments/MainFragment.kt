package com.liza.lizashop.presentation.fragments

import android.opengl.Visibility
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.liza.lizashop.R
import com.liza.lizashop.databinding.FragmentMainBinding
import com.liza.lizashop.domain.entity.SaleTitleListItem
import com.liza.lizashop.presentation.stateholders.adapters.SaleRvAdapter
import com.liza.lizashop.presentation.stateholders.viewmodels.MainViewModel

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val viewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bottomNavView = requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavView.visibility = View.VISIBLE
        // Finding the Navigation Controller
        val navController = requireActivity().findNavController(R.id.bottom_fragment_container)

        // Setting Navigation Controller with the BottomNavigationView
        bottomNavView.setupWithNavController(navController)

        viewModel.saleListLd.observe(viewLifecycleOwner, Observer {
            it?.let {
                binding.saleList.adapter = SaleRvAdapter(it)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}