package com.liza.lizashop.presentation.stateholders.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.liza.lizashop.databinding.ItemProductListBinding
import com.liza.lizashop.domain.entity.ProductListItem

class ProductRvAdapter(private val productsList: List<ProductListItem>) :
    RecyclerView.Adapter<ProductRvAdapter.ViewHolder>() {

    var onProductListClickListener: ((ProductListItem) -> Unit)? = null

    inner class ViewHolder(val binding: ItemProductListBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = ItemProductListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(itemBinding)
    }

    override fun getItemCount() = productsList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = productsList[position]
        with(holder) {
            binding.imageProduct.setImageResource(item.imageRes)
            binding.textProductName.text = item.productName
            binding.textPrice.text = item.price
            itemView.setOnClickListener {
                onProductListClickListener?.invoke(item)
            }
        }
    }
}