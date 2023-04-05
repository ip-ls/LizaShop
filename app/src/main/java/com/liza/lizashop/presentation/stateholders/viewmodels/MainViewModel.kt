package com.liza.lizashop.presentation.stateholders.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.liza.lizashop.data.repository.ShopRepositoryImpl
import com.liza.lizashop.domain.entity.SaleTitleListItem
import com.liza.lizashop.domain.usecase.GetSaleTitleListUseCase

class MainViewModel : ViewModel() {

    private val repositoryImpl = ShopRepositoryImpl()

    private val getSaleTitleListUseCase = GetSaleTitleListUseCase(repositoryImpl)

    val saleListLd: LiveData<List<SaleTitleListItem>> = getSaleTitleListUseCase.invoke()

}