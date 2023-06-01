package com.liza.lizashop.domain.entity

data class ProductListItem(
    val id: Int,
    val imageRes: Int,
    val productName: String,
    val price: String,
    val category: String
)