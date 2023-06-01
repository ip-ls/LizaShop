package com.liza.lizashop.presentation.stateholders.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CartViewModelFactory(
    private val application: Application,
    private val phone: String
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CartViewModel::class.java)) {
            return CartViewModel(application, phone) as T
        }
        throw RuntimeException("Unknown view model class $modelClass")
    }
}
