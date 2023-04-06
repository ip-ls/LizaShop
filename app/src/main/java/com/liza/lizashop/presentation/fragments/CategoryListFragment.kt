package com.liza.lizashop.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.liza.lizashop.databinding.FragmentCategoryListBinding
import com.liza.lizashop.databinding.FragmentGreetingBinding
import com.liza.lizashop.presentation.stateholders.adapters.CategoriesRvAdapter
import com.liza.lizashop.presentation.stateholders.adapters.ProductRvAdapter
import com.liza.lizashop.presentation.stateholders.viewmodels.CategoryListViewModel
import com.liza.lizashop.presentation.stateholders.viewmodels.LoginViewModel

class CategoryListFragment : Fragment() {

    private var _binding: FragmentCategoryListBinding? = null
    private val binding get() = _binding!!

    private val viewModel by lazy {
        ViewModelProvider(this)[CategoryListViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCategoryListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.productsListLd.observe(viewLifecycleOwner, Observer {
            it?.let {
                binding.productsList.adapter = ProductRvAdapter(it)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}