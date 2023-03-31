package com.liza.lizashop.domain.repository

import com.liza.lizashop.domain.entity.CartListItem
import com.liza.lizashop.domain.entity.SettingsListItem

interface LocalRepository {

    fun getUserSettingsList(): List<SettingsListItem>

    fun getCartListUseCase(): List<CartListItem>

}