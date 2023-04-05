package com.liza.lizashop.domain.usecase

import androidx.lifecycle.LiveData
import com.liza.lizashop.domain.entity.ProductListItem
import com.liza.lizashop.domain.repository.ShopRepository

class GetProductsListUseCase(
    private val repository: ShopRepository
) {

    operator fun invoke(category: String): LiveData<List<ProductListItem>> {
        return repository.getProductsList(category)
    }
}