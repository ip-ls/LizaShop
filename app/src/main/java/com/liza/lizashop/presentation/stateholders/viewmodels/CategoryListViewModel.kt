package com.liza.lizashop.presentation.stateholders.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.liza.lizashop.data.repository.ShopRepositoryImpl
import com.liza.lizashop.domain.entity.ProductCategoryListItem
import com.liza.lizashop.domain.entity.ProductListItem
import com.liza.lizashop.domain.usecase.GetProductCategoriesListUseCase
import com.liza.lizashop.domain.usecase.GetProductsListUseCase

class CategoryListViewModel : ViewModel() {

    private val repositoryImpl = ShopRepositoryImpl()

    private val getProductCategoryListItem = GetProductsListUseCase(repositoryImpl)

    val productsListLd: LiveData<List<ProductListItem>> = getProductCategoryListItem.invoke("tech")

}