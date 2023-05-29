package com.liza.lizashop.domain.repository

import androidx.lifecycle.LiveData
import com.liza.lizashop.domain.entity.ProductCategoryListItem
import com.liza.lizashop.domain.entity.ProductListItem
import com.liza.lizashop.domain.entity.SaleTitleListItem

interface ShopRepository {

    fun getProductCategoriesList(): LiveData<List<ProductCategoryListItem>>

    fun getProductsList(category: String): LiveData<List<ProductListItem>>

    fun getSaleTitleList(): LiveData<List<SaleTitleListItem>>

    fun addProductInCart(productListItem: ProductListItem)
}