package com.liza.lizashop.domain.repository

import androidx.lifecycle.LiveData
import com.liza.lizashop.domain.entity.CartListItem
import com.liza.lizashop.domain.entity.SettingsListItem

interface LocalRepository {

    fun getUserSettingsList(): LiveData<List<SettingsListItem>>

    fun getCartListUseCase(): List<CartListItem>

}