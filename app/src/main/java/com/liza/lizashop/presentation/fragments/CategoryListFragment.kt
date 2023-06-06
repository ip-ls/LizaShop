package com.liza.lizashop.presentation.fragments

import android.app.AlertDialog
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.liza.lizashop.R
import com.liza.lizashop.data.db.LizaShopDataBase
import com.liza.lizashop.databinding.FragmentCategoryListBinding
import com.liza.lizashop.domain.entity.ProductListItem
import com.liza.lizashop.domain.entity.Roles
import com.liza.lizashop.presentation.fragments.LoginFragment.Companion
import com.liza.lizashop.presentation.stateholders.adapters.ProductRvAdapter
import com.liza.lizashop.presentation.stateholders.viewmodels.CategoriesListViewModelFactory
import com.liza.lizashop.presentation.stateholders.viewmodels.CategoryListViewModel

class CategoryListFragment : Fragment() {

    private var _binding: FragmentCategoryListBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<CategoryListFragmentArgs>()

    private lateinit var adapter: ProductRvAdapter

    private val phone by lazy {
        val sharedPrefRead: SharedPreferences =
            requireActivity().getPreferences(AppCompatActivity.MODE_PRIVATE)
        sharedPrefRead.getString(Companion.SHARED_PREF_LOGIN_ED, "")
    }

    private val viewModelFactory by lazy {
        CategoriesListViewModelFactory(
            requireActivity().application,
            args.CATEGORYNAME,
            phone ?: ""
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

        viewModel.roleLD.observe(viewLifecycleOwner) {
            it.let {
                if (it == Roles.ADMIN) {
                    binding.floatingActionButtonAdd.visibility = View.VISIBLE
                    binding.floatingActionButtonAdd.setOnClickListener {
                        val builder = AlertDialog.Builder(requireContext())
                        val layout = LinearLayout(requireContext())

                        layout.orientation = LinearLayout.VERTICAL

                        val productEt = EditText(requireContext())
                        productEt.hint = "Название продукта"
                        layout.addView(productEt)

                        val productPriceEt = EditText(requireContext())
                        productPriceEt.hint = "Цена"
                        layout.addView(productPriceEt)

                        val spinner = Spinner(requireContext())
                        val spinnerItems = arrayOf("Минералы", "Аксессуары")
                        val adapterSpinner = ArrayAdapter(
                            requireContext(),
                            android.R.layout.simple_spinner_dropdown_item, spinnerItems
                        )
                        spinner.adapter = adapterSpinner
                        layout.addView(spinner)


                        builder.setView(layout)

                        builder.setPositiveButton("OK") { dialog, _ ->
                            val productName = productEt.text.toString()
                            val productPrice = productPriceEt.text.toString()
                            val spinnerOptionPosition = spinner.selectedItemPosition
                            if (spinnerOptionPosition == 0) {
                                viewModel.addProduct(
                                    ProductListItem(
                                        1,
                                        R.drawable.image_product_2,
                                        productName,
                                        productPrice,
                                        LizaShopDataBase.CATEGORY_MINERALS
                                    )
                                )
                            } else if (spinnerOptionPosition == 1) {
                                viewModel.addProduct(
                                    ProductListItem(
                                        1,
                                        R.drawable.image_product_7,
                                        productName,
                                        productPrice,
                                        LizaShopDataBase.CATEGORY_ACCESSORIES
                                    )
                                )
                            }
                        }
                        builder.setNegativeButton("Cancel", null)

                        val dialog = builder.create()
                        dialog.show()
                    }
                } else {
                    binding.floatingActionButtonAdd.visibility = View.GONE
                }
            }
        }

        if (args.CATEGORYNAME == LizaShopDataBase.CATEGORY_MINERALS)
            binding.textTitle.text = "Минералы"
        if (args.CATEGORYNAME == LizaShopDataBase.CATEGORY_ACCESSORIES)
            binding.textTitle.text = "Аксессуары"

        viewModel.productsListLd.observe(viewLifecycleOwner, Observer {
            adapter.productsList = it
        })
        adapter = ProductRvAdapter()
        adapter.onProductListClickListener = {
            val sharedPrefRead: SharedPreferences =
                requireActivity().getPreferences(AppCompatActivity.MODE_PRIVATE)
            val phone = sharedPrefRead.getString(LoginFragment.SHARED_PREF_LOGIN_ED, "")

            viewModel.addProductInCart(it, phone ?: "")
        }
        binding.productsList.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
