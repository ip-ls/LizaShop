package com.liza.lizashop.domain.usecase

import androidx.lifecycle.LiveData
import com.liza.lizashop.domain.entity.CartListItem
import com.liza.lizashop.domain.entity.ProductListItem
import com.liza.lizashop.domain.repository.LocalRepository
import com.liza.lizashop.domain.repository.ShopRepository

class AddProductInCartUseCase(
    private val repository: ShopRepository
) {

    suspend operator fun invoke(productListItem: ProductListItem) {
        repository.addProductInCart(productListItem)
    }

}