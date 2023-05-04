package com.liza.lizashop.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.liza.lizashop.data.db.dao.CartProductDao
import com.liza.lizashop.data.db.dao.ShopProductDao
import com.liza.lizashop.data.db.dao.UserDao
import com.liza.lizashop.data.db.entities.CartProduct
import com.liza.lizashop.data.db.entities.ShopProduct
import com.liza.lizashop.data.db.entities.User


@Database(entities = [User::class, ShopProduct::class, CartProduct::class], version = 1, exportSchema = false)
abstract class LizaShopDataBase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun shopProductDao(): ShopProductDao
    abstract fun cartProduct(): CartProductDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: LizaShopDataBase? = null

        fun getDatabase(context: Context): LizaShopDataBase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LizaShopDataBase::class.java,
                    "liza_shop_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}