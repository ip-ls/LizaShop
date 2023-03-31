package com.liza.lizashop.data.repository

import com.liza.lizashop.data.datasource.ShopRemoteDataSource
import com.liza.lizashop.domain.entity.ProductCategoryListItem
import com.liza.lizashop.domain.entity.ProductListItem
import com.liza.lizashop.domain.repository.ShopRepository

class ShopRepositoryImpl : ShopRepository {

    private val dataSource = ShopRemoteDataSource()

    override fun getProductCategoriesList(): List<ProductCategoryListItem> {
        return dataSource.getProductCategoryList()
    }

    override fun getProductsList(category: String): List<ProductListItem> {
        return dataSource.getProductList(category)
    }

    override fun getSaleTitleList(): List<ProductListItem> {
        return dataSource.getSaleTitleList()
    }
}