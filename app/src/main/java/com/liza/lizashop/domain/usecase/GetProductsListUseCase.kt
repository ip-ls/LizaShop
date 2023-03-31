package com.liza.lizashop.domain.usecase

import com.liza.lizashop.domain.entity.ProductListItem
import com.liza.lizashop.domain.repository.ShopRepository

class GetProductsListUseCase(
    private val repository: ShopRepository
) {

    operator fun invoke(category: String): List<ProductListItem> {
        return repository.getProductsList(category)
    }
}