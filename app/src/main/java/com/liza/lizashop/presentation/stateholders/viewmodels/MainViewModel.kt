package com.liza.lizashop.presentation.stateholders.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.liza.lizashop.data.repository.ShopRepositoryImpl
import com.liza.lizashop.domain.entity.SaleTitleListItem
import com.liza.lizashop.domain.usecase.GetSaleTitleListUseCase

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repositoryImpl = ShopRepositoryImpl(application)

    private val getSaleTitleListUseCase = GetSaleTitleListUseCase(repositoryImpl)

    val saleListLd: LiveData<List<SaleTitleListItem>> = getSaleTitleListUseCase.invoke()

}