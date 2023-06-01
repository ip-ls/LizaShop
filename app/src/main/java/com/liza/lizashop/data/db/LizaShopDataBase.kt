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
import com.liza.lizashop.domain.entity.ProductListItem
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

        const val CATEGORY_TECH = "tech"
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
                )
                    .addCallback(object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            CoroutineScope(Dispatchers.IO).launch {
                                val productTechList = listOf<ShopProduct>(
                                    ShopProduct(
                                        1,
                                        R.drawable.image_product_1,
                                        "AILYONS 2.1CH\nMultimedia woofer",
                                        "$23",
                                        CATEGORY_TECH
                                    ),
                                    ShopProduct(
                                        2,
                                        R.drawable.image_product_2,
                                        "CLUBOX 3.1CH HIFI\nMultimedia Sub-woofer",
                                        "$44",
                                        CATEGORY_TECH
                                    ),
                                    ShopProduct(
                                        3,
                                        R.drawable.image_product_3,
                                        "NINUX A22 3.1CH Home\nTheater System Speakers",
                                        "$47",
                                        CATEGORY_TECH
                                    ),
                                    ShopProduct(
                                        4,
                                        R.drawable.image_product_1,
                                        "AILYONS 2.1CH\nMultimedia woofer",
                                        "$23",
                                        CATEGORY_TECH
                                    ),
                                    ShopProduct(
                                        5,
                                        R.drawable.image_product_2,
                                        "CLUBOX 3.1CH HIFI\nMultimedia Sub-woofer",
                                        "$44",
                                        CATEGORY_TECH
                                    ),
                                    ShopProduct(
                                        6,
                                        R.drawable.image_product_3,
                                        "NINUX A22 3.1CH Home\nTheater System Speakers",
                                        "$47",
                                        CATEGORY_TECH
                                    ),
                                    ShopProduct(
                                        7,
                                        R.drawable.image_product_1,
                                        "AILYONS 2.1CH\nMultimedia woofer",
                                        "$23",
                                        CATEGORY_TECH
                                    ),
                                    ShopProduct(
                                        8,
                                        R.drawable.image_product_2,
                                        "CLUBOX 3.1CH HIFI\nMultimedia Sub-woofer",
                                        "$44",
                                        CATEGORY_TECH
                                    ),
                                    ShopProduct(
                                        9,
                                        R.drawable.image_product_3,
                                        "NINUX A22 3.1CH Home\nTheater System Speakers",
                                        "$47",
                                        CATEGORY_TECH
                                    ),
                                    ShopProduct(
                                        10,
                                        R.drawable.image_product_1,
                                        "AILYONS 2.1CH\nMultimedia woofer",
                                        "$23",
                                        CATEGORY_TECH
                                    ),
                                    ShopProduct(
                                        11,
                                        R.drawable.image_product_2,
                                        "CLUBOX 3.1CH HIFI\nMultimedia Sub-woofer",
                                        "$44",
                                        CATEGORY_TECH
                                    ),
                                    ShopProduct(
                                        12,
                                        R.drawable.image_product_3,
                                        "NINUX A22 3.1CH Home\nTheater System Speakers",
                                        "$47",
                                        CATEGORY_TECH
                                    ),
                                    ShopProduct(
                                        13,
                                        R.drawable.image_product_4,
                                        "Коврик для мыши",
                                        "$23",
                                        CATEGORY_ACCESSORIES
                                    ),
                                    ShopProduct(
                                        14,
                                        R.drawable.image_product_5,
                                        "Игровой коврик A4TECH Bloody",
                                        "$44",
                                        CATEGORY_ACCESSORIES
                                    ),
                                    ShopProduct(
                                        15,
                                        R.drawable.image_product_6,
                                        "Чехол \"Волк\" на Apple iPhone 13 Pro Max",
                                        "$47",
                                        CATEGORY_ACCESSORIES
                                    ),
                                    ShopProduct(
                                        16,
                                        R.drawable.image_product_7,
                                        "Чехол для наушников Air Pods 1/2, Беззубик",
                                        "$23",
                                        CATEGORY_ACCESSORIES
                                    ),
                                    ShopProduct(
                                        17,
                                        R.drawable.image_product_8,
                                        "Накладка на клавиатуру MacBook 12 (2016) EU",
                                        "$49",
                                        CATEGORY_ACCESSORIES
                                    ),
                                    ShopProduct(
                                        18,
                                        R.drawable.image_product_9,
                                        "Держательдля телефона \"Неоновый котенок\"",
                                        "$24",
                                        CATEGORY_ACCESSORIES
                                    ),
                                )
                                INSTANCE?.shopProductDao()
                                    ?.insertAll(*productTechList.toTypedArray())

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
