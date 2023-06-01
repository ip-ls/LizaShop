package com.liza.lizashop.presentation.fragments

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.liza.lizashop.data.db.LizaShopDataBase
import com.liza.lizashop.databinding.FragmentCategoryListBinding
import com.liza.lizashop.databinding.FragmentGreetingBinding
import com.liza.lizashop.presentation.fragments.LoginFragment.Companion
import com.liza.lizashop.presentation.stateholders.adapters.CategoriesRvAdapter
import com.liza.lizashop.presentation.stateholders.adapters.ProductRvAdapter
import com.liza.lizashop.presentation.stateholders.viewmodels.CategoriesListViewModelFactory
import com.liza.lizashop.presentation.stateholders.viewmodels.CategoryListViewModel
import com.liza.lizashop.presentation.stateholders.viewmodels.LoginViewModel

class CategoryListFragment : Fragment() {

    private var _binding: FragmentCategoryListBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<CategoryListFragmentArgs>()

    private val viewModelFactory by lazy {
        CategoriesListViewModelFactory(
            requireActivity().application,
            args.CATEGORYNAME
        )
    }

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[CategoryListViewModel::class.java]
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

        if (args.CATEGORYNAME == LizaShopDataBase.CATEGORY_TECH)
            binding.textTitle.text = "Техника"
        if (args.CATEGORYNAME == LizaShopDataBase.CATEGORY_ACCESSORIES)
            binding.textTitle.text ="Аксессуары"

        viewModel.productsListLd.observe(viewLifecycleOwner, Observer {
            it?.let {
                val adapter = ProductRvAdapter(it)
                adapter.onProductListClickListener = {

                    val sharedPrefRead: SharedPreferences =
                        requireActivity().getPreferences(AppCompatActivity.MODE_PRIVATE)
                    val phone = sharedPrefRead.getString(LoginFragment.SHARED_PREF_LOGIN_ED, "")

                    viewModel.addProductInCart(it, phone ?: "")
                }
                binding.productsList.adapter = adapter
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
