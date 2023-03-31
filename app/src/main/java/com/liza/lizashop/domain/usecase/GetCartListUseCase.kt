package com.liza.lizashop.domain.usecase

import com.liza.lizashop.domain.entity.CartListItem
import com.liza.lizashop.domain.repository.LocalRepository

class GetCartListUseCase(
    private val repository: LocalRepository
) {

    operator fun invoke(): List<CartListItem> {
        return repository.getCartListUseCase()
    }
}