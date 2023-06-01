package com.liza.lizashop.data.db.entities

import android.provider.ContactsContract.CommonDataKinds.Phone
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
    @ColumnInfo(name = "checked") var checked: Boolean,
    @ColumnInfo(name = "phone") var phone: String
)
