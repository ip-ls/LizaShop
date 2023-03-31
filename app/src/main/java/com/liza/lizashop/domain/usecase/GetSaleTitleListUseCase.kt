package com.liza.lizashop.domain.usecase

import com.liza.lizashop.domain.entity.ProductListItem
import com.liza.lizashop.domain.repository.ShopRepository

class GetSaleTitleListUseCase(
    private val repository: ShopRepository
) {

    operator fun invoke(): List<ProductListItem> {
        return repository.getSaleTitleListUseCase()
    }
}