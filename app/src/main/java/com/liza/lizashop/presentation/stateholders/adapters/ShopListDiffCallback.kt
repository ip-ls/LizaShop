package com.liza.lizashop.presentation.stateholders.adapters

import androidx.recyclerview.widget.DiffUtil
import com.liza.lizashop.domain.entity.ProductListItem

class ShopListDiffCallback(
    private val oldList: List<ProductListItem>,
    private val newList: List<ProductListItem>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        return oldItem == newItem
    }


}