package com.liza.lizashop.domain.repository

import com.liza.lizashop.domain.entity.ProductCategoryListItem
import com.liza.lizashop.domain.entity.ProductListItem

interface ShopRepository {

    fun getProductCategoriesList(): List<ProductCategoryListItem>

    fun getProductsList(category: String): List<ProductListItem>

    fun getSaleTitleListUseCase(): List<ProductListItem>

}