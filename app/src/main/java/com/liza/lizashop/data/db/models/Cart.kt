package com.liza.lizashop.data.db.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Cart(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "imageRes") val imageRes: Int,
    @ColumnInfo(name = "productName") val productName: String,
    @ColumnInfo(name = "price") val price: String,
    @ColumnInfo(name = "productCount") var productCount: Int,
    @ColumnInfo(name = "checked") var checked: Boolean
)