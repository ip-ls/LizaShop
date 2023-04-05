package com.liza.lizashop.data.repository

import androidx.lifecycle.LiveData
import com.liza.lizashop.data.datasource.ShopRemoteDataSource
import com.liza.lizashop.domain.entity.ProductCategoryListItem
import com.liza.lizashop.domain.entity.ProductListItem
import com.liza.lizashop.domain.entity.SaleTitleListItem
import com.liza.lizashop.domain.repository.ShopRepository

class ShopRepositoryImpl : ShopRepository {

    private val dataSource = ShopRemoteDataSource()

    override fun getProductCategoriesList(): LiveData<List<ProductCategoryListItem>> {
        return dataSource.getProductCategoryList()
    }

    override fun getProductsList(category: String): LiveData<List<ProductListItem>> {
        return dataSource.getProductList(category)
    }

    override fun getSaleTitleList(): LiveData<List<SaleTitleListItem>> {
        return dataSource.getSaleTitleList()
    }
}