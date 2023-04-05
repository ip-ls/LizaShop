package com.liza.lizashop.domain.usecase

import androidx.lifecycle.LiveData
import com.liza.lizashop.domain.entity.ProductCategoryListItem
import com.liza.lizashop.domain.repository.ShopRepository

class GetProductCategoriesListUseCase(
    private val repository: ShopRepository
) {

    operator fun invoke(): LiveData<List<ProductCategoryListItem>> {
        return repository.getProductCategoriesList()
    }
}