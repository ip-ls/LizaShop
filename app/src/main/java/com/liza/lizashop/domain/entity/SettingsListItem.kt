package com.liza.lizashop.domain.entity

data class SettingsListItem(
    val imageRes: Int,
    val titleSetting: String,
    val type: Boolean // true - button, false - switcher
)