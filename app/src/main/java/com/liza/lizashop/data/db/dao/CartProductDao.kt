package com.liza.lizashop.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.liza.lizashop.data.db.entities.ShopProduct
import kotlinx.coroutines.flow.Flow

@Dao
interface CartProductDao {
    @Query("SELECT * FROM ShopProduct")
    fun getAllShopProducts(): LiveData<List<ShopProduct>>

    @Query("SELECT * FROM ShopProduct WHERE uid LIKE :uid")
    fun findById(uid: Int): LiveData<ShopProduct>

    @Insert
    fun insertAll(vararg shopProducts: ShopProduct)
}