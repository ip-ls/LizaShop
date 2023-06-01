package com.liza.lizashop.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ShopProduct (
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo(name = "imageRes") val imageRes: Int,
    @ColumnInfo(name = "price") val productName: String,
    @ColumnInfo(name = "name") val price: String,
    @ColumnInfo(name = "category") val category: String
)
