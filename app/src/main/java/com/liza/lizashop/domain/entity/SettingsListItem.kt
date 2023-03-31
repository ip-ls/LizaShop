package com.liza.lizashop.domain.entity

data class SettingsListItem(
    val imageRes: String,
    val titleSetting: String,
    val type: Boolean // true - button, false - switcher
)