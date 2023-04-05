package com.liza.lizashop.domain.usecase

import androidx.lifecycle.LiveData
import com.liza.lizashop.domain.entity.ProductListItem
import com.liza.lizashop.domain.entity.SaleTitleListItem
import com.liza.lizashop.domain.repository.ShopRepository

class GetSaleTitleListUseCase(
    private val repository: ShopRepository
) {

    operator fun invoke(): LiveData<List<SaleTitleListItem>> {
        return repository.getSaleTitleList()
    }
}