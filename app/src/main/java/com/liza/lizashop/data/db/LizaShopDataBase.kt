package com.liza.lizashop.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.liza.lizashop.R
import com.liza.lizashop.data.db.dao.CartDao
import com.liza.lizashop.data.db.dao.ShopProductDao
import com.liza.lizashop.data.db.dao.UserDao
import com.liza.lizashop.data.db.entities.ShopProduct
import com.liza.lizashop.data.db.entities.User
import com.liza.lizashop.data.db.entities.Cart
import com.liza.lizashop.domain.entity.Roles
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Database(
    entities = [User::class, ShopProduct::class, Cart::class],
    version = 1,
    exportSchema = false
)
abstract class LizaShopDataBase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun shopProductDao(): ShopProductDao
    abstract fun cartDao(): CartDao

    companion object {

        const val CATEGORY_MINERALS = "minerals"
        const val CATEGORY_ACCESSORIES = "accessories"

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
                ).addCallback(object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            CoroutineScope(Dispatchers.IO).launch {
                                val productTechList = listOf<ShopProduct>(
                                    ShopProduct(
                                        1,
                                        R.drawable.image_product_1,
                                        "Галтовка розовый кварц",
                                        "399₽",
                                        CATEGORY_MINERALS
                                    ),
                                    ShopProduct(
                                        2,
                                        R.drawable.image_product_2,
                                        "Галтовка содалит",
                                        "569₽",
                                        CATEGORY_MINERALS
                                    ),
                                    ShopProduct(
                                        3,
                                        R.drawable.image_product_3,
                                        "Обсидиан чёрный галтовка",
                                        "399₽",
                                        CATEGORY_MINERALS
                                    ),
                                    ShopProduct(
                                        4,
                                        R.drawable.image_product_10,
                                        "Малахит (имитация) галтовка",
                                        "399₽",
                                        CATEGORY_MINERALS
                                    ),
                                    ShopProduct(
                                        5,
                                        R.drawable.image_product_11,
                                        "Опалит галтовка",
                                        "459₽",
                                        CATEGORY_MINERALS
                                    ),
                                    ShopProduct(
                                        6,
                                        R.drawable.image_product_12,
                                        "Галтовка говлит",
                                        "399₽",
                                        CATEGORY_MINERALS
                                    ),
                                    ShopProduct(
                                        7,
                                        R.drawable.image_product_13,
                                        "Яшма \"Киви\" галтовка",
                                        "399₽",
                                        CATEGORY_MINERALS
                                    ),
                                    ShopProduct(
                                        8,
                                        R.drawable.image_product_14,
                                        "Галтовка агат",
                                        "499₽",
                                        CATEGORY_MINERALS
                                    ),
                                    ShopProduct(
                                        9,
                                        R.drawable.image_product_15,
                                        "Галтовка лазурит",
                                        "652₽",
                                        CATEGORY_MINERALS
                                    ),
                                    ShopProduct(
                                        10,
                                        R.drawable.image_product_16,
                                        "Вулканический камень галтовка",
                                        "702₽",
                                        CATEGORY_MINERALS
                                    ),
                                    ShopProduct(
                                        11,
                                        R.drawable.image_product_17,
                                        "Яшма далматиновая галтовка",
                                        "540₽",
                                        CATEGORY_MINERALS
                                    ),
                                    ShopProduct(
                                        12,
                                        R.drawable.image_product_18,
                                        "Галтовка унакит",
                                        "540₽",
                                        CATEGORY_MINERALS
                                    ),
                                    ShopProduct(
                                        13,
                                        R.drawable.image_product_4,
                                        "Маятник из черного обсидиана",
                                        "275₽",
                                        CATEGORY_ACCESSORIES
                                    ),
                                    ShopProduct(
                                        14,
                                        R.drawable.image_product_5,
                                        "Браслет из розового кварца",
                                        "554₽",
                                        CATEGORY_ACCESSORIES
                                    ),
                                    ShopProduct(
                                        15,
                                        R.drawable.image_product_6,
                                        "Серьги из минерала Янтарь",
                                        "1197₽",
                                        CATEGORY_ACCESSORIES
                                    ),
                                    ShopProduct(
                                        16,
                                        R.drawable.image_product_7,
                                        "Колье с имитацией\nосколка минерала",
                                        "538₽",
                                        CATEGORY_ACCESSORIES
                                    ),
                                    ShopProduct(
                                        17,
                                        R.drawable.image_product_8,
                                        "Браслет с горным хрусталем",
                                        "1637₽",
                                        CATEGORY_ACCESSORIES
                                    ),
                                    ShopProduct(
                                        18,
                                        R.drawable.image_product_9,
                                        "Браслет из аквамарина",
                                        "290₽",
                                        CATEGORY_ACCESSORIES
                                    ),
                                )
                                INSTANCE?.shopProductDao()
                                    ?.insertAll(*productTechList.toTypedArray())

                                INSTANCE?.userDao()
                                    ?.insertAll(User(
                                        1,
                                        "0000000000",
                                        "Admin",
                                        "Admin",
                                        0,
                                        "123",
                                        Roles.ADMIN
                                    ))
                            }
                        }
                    })
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}
