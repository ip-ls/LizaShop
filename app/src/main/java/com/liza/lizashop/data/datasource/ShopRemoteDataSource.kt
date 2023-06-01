package com.liza.lizashop.data.datasource

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.liza.lizashop.R
import com.liza.lizashop.data.CartMapper
import com.liza.lizashop.data.ProductMapper
import com.liza.lizashop.data.db.LizaShopDataBase
import com.liza.lizashop.data.db.entities.Cart
import com.liza.lizashop.domain.entity.CartListItem
import com.liza.lizashop.domain.entity.ProductCategoryListItem
import com.liza.lizashop.domain.entity.ProductListItem
import com.liza.lizashop.domain.entity.SaleTitleListItem

class ShopRemoteDataSource(
    private val context: Context
) {

    private val db = LizaShopDataBase.getDatabase(context)
    private val cartDao = db.cartDao()
    private val shopProductDao = db.shopProductDao()

    private val categoryList = listOf<ProductCategoryListItem>(
        ProductCategoryListItem(R.drawable.icon_category_glass, "Аксессуары"),
        ProductCategoryListItem(R.drawable.icon_category_phone, "Техника"),
    )

    private val categoryTitlesList = listOf<SaleTitleListItem>(
        SaleTitleListItem(R.drawable.sale_category_tech, "Техника"),
    )

    fun getProductList(category: String): LiveData<List<ProductListItem>> {
        return MediatorLiveData<List<ProductListItem>>().apply {
            addSource(shopProductDao.getAllShopProducts(category)) {
                value = ProductMapper.mapDbModelListToEntityList(it)
            }
        }
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


    fun addProductInCart(productListItem: ProductListItem, phone: String) {
        db.queryExecutor.execute {
            cartDao.insert(
                Cart(
                    productListItem.id,
                    productListItem.imageRes,
                    productListItem.productName,
                    productListItem.price,
                    1,
                    false,
                    phone
                )
            )
        }
    }
}
