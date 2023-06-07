package com.liza.lizashop.domain.entity

data class CartListItem(
    val id: Int,
    val imageRes: Int,
    val productName: String,
    val price: String,
    var productCount: Int,
    var checked: Boolean,
    var phone: String
)
