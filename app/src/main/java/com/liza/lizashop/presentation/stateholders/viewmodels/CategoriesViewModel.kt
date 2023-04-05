package com.liza.lizashop.presentation.stateholders.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.liza.lizashop.data.repository.ShopRepositoryImpl
import com.liza.lizashop.domain.entity.ProductCategoryListItem
import com.liza.lizashop.domain.entity.SaleTitleListItem
import com.liza.lizashop.domain.usecase.GetProductCategoriesListUseCase
import com.liza.lizashop.domain.usecase.GetSaleTitleListUseCase

class CategoriesViewModel : ViewModel() {

    private val repositoryImpl = ShopRepositoryImpl()

    private val getCategoriesListUseCase = GetProductCategoriesListUseCase(repositoryImpl)

    val categoriesListLd: LiveData<List<ProductCategoryListItem>> = getCategoriesListUseCase.invoke()

}