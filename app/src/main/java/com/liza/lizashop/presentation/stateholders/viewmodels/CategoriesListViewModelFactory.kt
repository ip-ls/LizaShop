package com.liza.lizashop.presentation.stateholders.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CategoriesListViewModelFactory(
    private val application: Application,
    private val category: String
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CategoryListViewModel::class.java)) {
            return CategoryListViewModel(application, category) as T
        }
        throw RuntimeException("Unknown view model class $modelClass")
    }
}