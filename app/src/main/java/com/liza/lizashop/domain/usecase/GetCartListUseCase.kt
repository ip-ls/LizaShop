package com.liza.lizashop.domain.usecase

import androidx.lifecycle.LiveData
import com.liza.lizashop.domain.entity.CartListItem
import com.liza.lizashop.domain.repository.LocalRepository

class GetCartListUseCase(
    private val repository: LocalRepository
) {

    operator fun invoke(): LiveData<List<CartListItem>> {
        return repository.getCartListUseCase()
    }
}