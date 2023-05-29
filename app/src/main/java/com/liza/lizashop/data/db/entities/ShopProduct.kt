package com.liza.lizashop.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ShopProduct (
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "imageRes") val imageRes: Int,
    @ColumnInfo(name = "price") val phone: Int,
    @ColumnInfo(name = "name") val name: String
)
