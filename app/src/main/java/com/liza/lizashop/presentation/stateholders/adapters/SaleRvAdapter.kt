package com.liza.lizashop.presentation.stateholders.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.liza.lizashop.databinding.ItemSaleListBinding
import com.liza.lizashop.domain.entity.SaleTitleListItem

class SaleRvAdapter(private val saleList: List<SaleTitleListItem>) :
    RecyclerView.Adapter<SaleRvAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemSaleListBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = ItemSaleListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(itemBinding)
    }

    override fun getItemCount() = saleList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        saleList[position].let {
            with(holder) {
                binding.textHeaderSaleCategory.text = it.categoryTitle
                binding.imageSaleCategory.setImageResource(it.imageRes)
            }
        }
    }
}