package com.liza.lizashop.presentation.stateholders.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.liza.lizashop.databinding.ItemCategoriesListBinding
import com.liza.lizashop.domain.entity.ProductCategoryListItem

class CategoriesRvAdapter(private val productCategoryList: List<ProductCategoryListItem>) :
    RecyclerView.Adapter<CategoriesRvAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemCategoriesListBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = ItemCategoriesListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(itemBinding)
    }

    override fun getItemCount() = productCategoryList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = productCategoryList[position]
        with(holder) {
            binding.textHeaderCategory.text = item.categoryName
            binding.imageCategory.setImageResource(item.imageRes)
        }
    }
}