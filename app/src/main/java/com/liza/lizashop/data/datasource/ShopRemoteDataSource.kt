package com.liza.lizashop.data.datasource

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.liza.lizashop.R
import com.liza.lizashop.data.db.LizaShopDataBase
import com.liza.lizashop.data.db.models.Cart
import com.liza.lizashop.domain.entity.ProductCategoryListItem
import com.liza.lizashop.domain.entity.ProductListItem
import com.liza.lizashop.domain.entity.SaleTitleListItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ShopRemoteDataSource(
    private val context: Context
) {

    private val db = LizaShopDataBase.getDatabase(context)
    private val cartDao = db.cartDao()

    private val productTechList = listOf<ProductListItem>(
        ProductListItem(
            1,
            R.drawable.image_product_1,
            "AILYONS 2.1CH\nMultimedia woofer",
            "$23"
        ),
        ProductListItem(
            2,
            R.drawable.image_product_2,
            "CLUBOX 3.1CH HIFI\nMultimedia Sub-woofer",
            "$44"
        ),
        ProductListItem(
            3,
            R.drawable.image_product_3,
            "NINUX A22 3.1CH Home\nTheater System Speakers",
            "$47"
        ),
        ProductListItem(
            4,
            R.drawable.image_product_1,
            "AILYONS 2.1CH\nMultimedia woofer",
            "$23"
        ),
        ProductListItem(
            5,
            R.drawable.image_product_2,
            "CLUBOX 3.1CH HIFI\nMultimedia Sub-woofer",
            "$44"
        ),
        ProductListItem(
            6,
            R.drawable.image_product_3,
            "NINUX A22 3.1CH Home\nTheater System Speakers",
            "$47"
        ),
        ProductListItem(
            7,
            R.drawable.image_product_1,
            "AILYONS 2.1CH\nMultimedia woofer",
            "$23"
        ),
        ProductListItem(
            8,
            R.drawable.image_product_2,
            "CLUBOX 3.1CH HIFI\nMultimedia Sub-woofer",
            "$44"
        ),
        ProductListItem(
            9,
            R.drawable.image_product_3,
            "NINUX A22 3.1CH Home\nTheater System Speakers",
            "$47"
        ),
        ProductListItem(
            10,
            R.drawable.image_product_1,
            "AILYONS 2.1CH\nMultimedia woofer",
            "$23"
        ),
        ProductListItem(
            11,
            R.drawable.image_product_2,
            "CLUBOX 3.1CH HIFI\nMultimedia Sub-woofer",
            "$44"
        ),
        ProductListItem(
            12,
            R.drawable.image_product_3,
            "NINUX A22 3.1CH Home\nTheater System Speakers",
            "$47"
        )
    )

    private val categoryList = listOf<ProductCategoryListItem>(
        ProductCategoryListItem(R.drawable.icon_category_glass, "Аксессуары"),
        ProductCategoryListItem(R.drawable.icon_category_phone, "Техника"),
    )

    private val categoryTitlesList = listOf<SaleTitleListItem>(
        SaleTitleListItem(R.drawable.sale_category_tech, "Техника"),
    )

    fun getProductList(category: String): LiveData<List<ProductListItem>> {
        if (category == CATEGORY_TECH) {
            val mutableLiveData = MutableLiveData<List<ProductListItem>>()
            mutableLiveData.value = productTechList
            return mutableLiveData
        }
        TODO()
    }

    fun getProductCategoryList(): LiveData<List<ProductCategoryListItem>> {
        val mutableLiveData = MutableLiveData<List<ProductCategoryListItem>>()
        mutableLiveData.value = categoryList
        return mutableLiveData
    }

    fun getSaleTitleList(): LiveData<List<SaleTitleListItem>> {
        val mutableLiveData = MutableLiveData<List<SaleTitleListItem>>()
        mutableLiveData.value = categoryTitlesList
        return mutableLiveData
    }


    fun addProductInCart(productListItem: ProductListItem) {
        db.queryExecutor.execute {
            cartDao.insert(
                Cart(
                    productListItem.id,
                    productListItem.imageRes,
                    productListItem.productName,
                    productListItem.price,
                    1,
                    false
                )
            )
        }
    }


    companion object {
        const val CATEGORY_TECH = "tech";
    }
}