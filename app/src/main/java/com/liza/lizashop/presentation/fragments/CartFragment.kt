package com.liza.lizashop.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.liza.lizashop.databinding.FragmentCartBinding
import com.liza.lizashop.presentation.stateholders.adapters.CartRvAdapter
import com.liza.lizashop.presentation.stateholders.viewmodels.CartViewModel

class CartFragment : Fragment() {


    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding!!

    private val viewModel by lazy {
        ViewModelProvider(this)[CartViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // read
        val sharedPrefRead = requireActivity().getPreferences(Context.MODE_PRIVATE)
        val chooseAll = sharedPrefRead.getBoolean(SHARED_PREF_ALL, false)
        binding.checkBoxChooseAll.isChecked = chooseAll

        binding.checkBoxChooseAll.setOnCheckedChangeListener { compoundButton, b ->
            if (b)
                viewModel.checkedAllProductsCart()

            // write
            val sharedPrefWrite = requireActivity().getPreferences(Context.MODE_PRIVATE)
            val editor = sharedPrefWrite.edit()
            editor.putBoolean(
                SHARED_PREF_ALL,
                b
            )
            editor.apply()
        }

        viewModel.cartListLd.observe(viewLifecycleOwner) {
            Log.d("myLogs", it.toString())
            it?.let {
                val adapter = CartRvAdapter(it)
                adapter.onCartProductCheckedChangeListener = { cartListItem, b ->
                    if (!b) {
                        binding.checkBoxChooseAll.isChecked = false
                        val sharedPrefWrite = requireActivity().getPreferences(Context.MODE_PRIVATE)
                        val editor = sharedPrefWrite.edit()
                        editor.putBoolean(
                            SHARED_PREF_ALL,
                            false
                        )
                        editor.apply()
                    }

                    viewModel.checkedProductCart(cartListItem)
                }
                adapter.onCartAddProductCountCart = {
                    viewModel.addProductCountCart(it)
                }
                adapter.onCartSubProductCountCart = {
                    viewModel.subProductCountCart(it)
                }
                binding.cartList.adapter = adapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        const val SHARED_PREF_ALL = "all"
    }
}