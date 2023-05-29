package com.liza.lizashop.presentation.stateholders.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.liza.lizashop.databinding.ItemCartBinding
import com.liza.lizashop.domain.entity.CartListItem
import com.liza.lizashop.domain.entity.ProductListItem

class CartRvAdapter(private val cartList: List<CartListItem>) :
    RecyclerView.Adapter<CartRvAdapter.ViewHolder>() {

    var onCartProductCheckedChangeListener: ((CartListItem, Boolean) -> Unit)? = null
    var onCartAddProductCountCart: ((CartListItem) -> Unit)? = null
    var onCartSubProductCountCart: ((CartListItem) -> Unit)? = null

    inner class ViewHolder(val binding: ItemCartBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = ItemCartBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(itemBinding)
    }

    override fun getItemCount() = cartList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = cartList[position]
        with(holder) {
            binding.textProductName.text = item.productName
            binding.imageProduct.setImageResource(item.imageRes)
            binding.textProductCount.text = item.productCount.toString()
            binding.textPrice.text = item.price
            binding.checkbox.isChecked = item.checked

            binding.textPlus.setOnClickListener {
                onCartAddProductCountCart?.invoke(item)
            }
            binding.textMinus.setOnClickListener {
                onCartSubProductCountCart?.invoke(item)
            }
            binding.textPlus.setOnClickListener {
                onCartAddProductCountCart?.invoke(item)
            }

            binding.checkbox.setOnCheckedChangeListener { compoundButton, b ->
                onCartProductCheckedChangeListener?.invoke(item, b)
            }
        }

    }


}