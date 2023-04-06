package com.liza.lizashop.data.datasource

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.liza.lizashop.R
import com.liza.lizashop.domain.entity.SettingsListItem

class DBLocalDataSource(
    context: Context
) {

    private val userSettings = listOf<SettingsListItem>(
        SettingsListItem(0, context.getString(R.string.my_account), false),
        SettingsListItem(R.drawable.icon_location, context.getString(R.string.point_of_issue), true),
        SettingsListItem(R.drawable.icon_card, context.getString(R.string.top_up_balance), true),
        SettingsListItem(R.drawable.icon_box, context.getString(R.string.orders), true),

        SettingsListItem(0, context.getString(R.string.notification), false),
        SettingsListItem(R.drawable.icon_notification, context.getString(R.string.push_notification), true),
        SettingsListItem(R.drawable.icon_notification, context.getString(R.string.promotions_and_offers), true),

        SettingsListItem(0, context.getString(R.string.logout), false),
        SettingsListItem(R.drawable.icon_support, context.getString(R.string.support), true),
        SettingsListItem(R.drawable.icon_logout, context.getString(R.string.logout), true),
    )

    fun getUserSettingsList(): LiveData<List<SettingsListItem>> {
        val mutableLiveData = MutableLiveData<List<SettingsListItem>>()
        mutableLiveData.value = userSettings
        return mutableLiveData
    }

}