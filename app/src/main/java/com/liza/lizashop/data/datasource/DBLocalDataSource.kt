package com.liza.lizashop.data.datasource

import android.content.Context
import com.liza.lizashop.R
import com.liza.lizashop.domain.entity.SettingsListItem

class DBLocalDataSource(
    context: Context
) {

    private val userSettings = listOf<SettingsListItem>(
        SettingsListItem(R.drawable.icon_location, context.getString(R.string.point_of_issue), true),
        SettingsListItem(R.drawable.icon_card, context.getString(R.string.top_up_balance), true),
        SettingsListItem(R.drawable.icon_box, context.getString(R.string.orders), true),

        SettingsListItem(R.drawable.icon_notification, context.getString(R.string.push_notification), false),
        SettingsListItem(R.drawable.icon_notification, context.getString(R.string.promotions_and_offers), false),

        SettingsListItem(R.drawable.icon_support, context.getString(R.string.support), true),
        SettingsListItem(R.drawable.icon_logout, context.getString(R.string.logout), true),
    )

    fun getUserSettingsList(): List<SettingsListItem> {
        return userSettings
    }

}