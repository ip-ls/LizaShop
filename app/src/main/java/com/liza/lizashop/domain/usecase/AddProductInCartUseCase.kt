package com.liza.lizashop.domain.usecase

import androidx.lifecycle.LiveData
import com.liza.lizashop.domain.entity.CartListItem
import com.liza.lizashop.domain.entity.ProductListItem
import com.liza.lizashop.domain.repository.LocalRepository
import com.liza.lizashop.domain.repository.ShopRepository

class AddProductInCartUseCase(
    private val repository: ShopRepository
) {

    operator fun invoke(productListItem: ProductListItem, phone: String) {
        repository.addProductInCart(productListItem, phone)
    }

}
