package com.liza.lizashop.data.datasource

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.liza.lizashop.R
import com.liza.lizashop.data.CartMapper
import com.liza.lizashop.data.db.LizaShopDataBase
import com.liza.lizashop.domain.entity.CartListItem
import com.liza.lizashop.domain.entity.SettingsListItem

class DBLocalDataSource(
    private val context: Context
) {

    private val db = LizaShopDataBase.getDatabase(context)
    private val cartDao = db.cartDao()

    private val userSettings = listOf<SettingsListItem>(
        SettingsListItem(0, context.getString(R.string.my_account), false),
        SettingsListItem(
            R.drawable.icon_location,
            context.getString(R.string.point_of_issue),
            true
        ),
        SettingsListItem(R.drawable.icon_card, context.getString(R.string.top_up_balance), true),
        SettingsListItem(R.drawable.icon_box, context.getString(R.string.orders), true),

        SettingsListItem(0, context.getString(R.string.notification), false),
        SettingsListItem(
            R.drawable.icon_notification,
            context.getString(R.string.push_notification),
            true
        ),

        SettingsListItem(0, context.getString(R.string.logout), false),
        SettingsListItem(R.drawable.icon_logout, context.getString(R.string.logout), true),
    )

    fun getUserSettingsList(): LiveData<List<SettingsListItem>> {
        val mutableLiveData = MutableLiveData<List<SettingsListItem>>()
        mutableLiveData.value = userSettings
        return mutableLiveData
    }

    fun getCartListUseCase(): LiveData<List<CartListItem>> =
        MediatorLiveData<List<CartListItem>>().apply {
            addSource(cartDao.cartList) {
                value = CartMapper.mapDbModelListToEntityList(it)
            }
        }


    fun addProductCountCart(id: Int) {
        db.queryExecutor.execute {
            cartDao.addProductCountCart(id)
        }
    }

    fun subProductCountCart(id: Int) {
        db.queryExecutor.execute {
            cartDao.subProductCountCart(id)
        }
    }

    fun removeProduct(id: Int) {
        db.queryExecutor.execute {
            cartDao.removeProductCart(id)
        }
    }

    fun checkedProductCart(id: Int) {
        db.queryExecutor.execute {
            cartDao.checkedProductCart(id)
        }
    }

    fun checkedAllProductsCart() {
        db.queryExecutor.execute {
            cartDao.checkedTrueAllProductsCart()
        }
    }
}