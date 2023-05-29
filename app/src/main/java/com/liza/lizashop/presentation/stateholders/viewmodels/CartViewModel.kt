package com.liza.lizashop.presentation.stateholders.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.liza.lizashop.data.db.models.Cart
import com.liza.lizashop.data.repository.LocalRepositoryImpl
import com.liza.lizashop.domain.entity.CartListItem
import com.liza.lizashop.domain.usecase.GetCartListUseCase
import com.liza.lizashop.domain.usecase.GetUserSettingsListUseCase
import kotlinx.coroutines.launch

class CartViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = LocalRepositoryImpl(getApplication())

    private val getCartListUseCase = GetCartListUseCase(repository)

    val cartListLd = getCartListUseCase.invoke()

    fun addProductCountCart(cart: CartListItem) {
        repository.addProductCountCart(cart.id)
    }

    fun subProductCountCart(cart: CartListItem) {
        repository.subProductCountCart(cart.id, cart.productCount)
    }

    fun checkedProductCart(cart: CartListItem) {
        repository.checkedProductCart(cart.id)
    }

    fun checkedAllProductsCart() {
        repository.checkedAllProductsCart()
    }

}