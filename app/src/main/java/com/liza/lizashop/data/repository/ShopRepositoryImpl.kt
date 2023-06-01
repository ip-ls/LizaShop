package com.liza.lizashop.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.liza.lizashop.data.datasource.ShopRemoteDataSource
import com.liza.lizashop.domain.entity.ProductCategoryListItem
import com.liza.lizashop.domain.entity.ProductListItem
import com.liza.lizashop.domain.entity.Roles
import com.liza.lizashop.domain.entity.SaleTitleListItem
import com.liza.lizashop.domain.repository.ShopRepository

class ShopRepositoryImpl(context: Context) : ShopRepository {

    private val dataSource = ShopRemoteDataSource(context)

    override fun getProductCategoriesList(): LiveData<List<ProductCategoryListItem>> {
        return dataSource.getProductCategoryList()
    }

    override fun getProductsList(category: String): LiveData<List<ProductListItem>> {
        return dataSource.getProductList(category)
    }

    override fun getSaleTitleList(): LiveData<List<SaleTitleListItem>> {
        return dataSource.getSaleTitleList()
    }

    override fun addProductInCart(productListItem: ProductListItem, phone: String) {
        dataSource.addProductInCart(productListItem, phone)
    }

    fun getRole(phone: String) : LiveData<Roles> {
        return dataSource.getRole(phone)
    }

    fun addProduct(productListItem: ProductListItem) {
        dataSource.addProduct(productListItem)
    }
}
