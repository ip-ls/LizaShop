package com.liza.lizashop.presentation.stateholders.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.liza.lizashop.data.repository.ShopRepositoryImpl
import com.liza.lizashop.domain.entity.ProductCategoryListItem
import com.liza.lizashop.domain.entity.ProductListItem
import com.liza.lizashop.domain.usecase.AddProductInCartUseCase
import com.liza.lizashop.domain.usecase.GetProductCategoriesListUseCase
import com.liza.lizashop.domain.usecase.GetProductsListUseCase
import kotlinx.coroutines.launch

class CategoryListViewModel(application: Application, category: String) :
    AndroidViewModel(application) {

    private val repositoryImpl = ShopRepositoryImpl(application)

    private val getProductCategoryListItem = GetProductsListUseCase(repositoryImpl)
    private val addProductInCartUseCase = AddProductInCartUseCase(repositoryImpl)

    val productsListLd: LiveData<List<ProductListItem>> = getProductCategoryListItem.invoke(category)

    fun addProductInCart(productListItem: ProductListItem) = viewModelScope.launch {
        addProductInCartUseCase(productListItem)
    }

}