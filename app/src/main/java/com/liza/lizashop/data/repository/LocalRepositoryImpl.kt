package com.liza.lizashop.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.liza.lizashop.data.datasource.DBLocalDataSource
import com.liza.lizashop.domain.entity.CartListItem
import com.liza.lizashop.domain.entity.SettingsListItem
import com.liza.lizashop.domain.repository.LocalRepository

class LocalRepositoryImpl(
    context: Context
) : LocalRepository {

    private val dataSource = DBLocalDataSource(context)

    override fun getUserSettingsList(): LiveData<List<SettingsListItem>> {
        return dataSource.getUserSettingsList()
    }

    override fun getCartListUseCase(): List<CartListItem> {
        TODO("Not yet implemented")
    }
}