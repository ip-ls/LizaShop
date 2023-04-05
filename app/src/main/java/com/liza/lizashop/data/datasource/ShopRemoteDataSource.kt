package com.liza.lizashop.data.datasource

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.liza.lizashop.R
import com.liza.lizashop.domain.entity.ProductCategoryListItem
import com.liza.lizashop.domain.entity.ProductListItem
import com.liza.lizashop.domain.entity.SaleTitleListItem

class ShopRemoteDataSource {
    private val productTechList = listOf<ProductListItem>(
        ProductListItem(
            R.drawable.image_product_1,
            "AILYONS 2.1CH\nMultimedia woofer",
            "$23"
        ),
        ProductListItem(
            R.drawable.image_product_2,
            "CLUBOX 3.1CH HIFI\nMultimedia Sub-woofer",
            "$44"
        ),
        ProductListItem(
            R.drawable.image_product_3,
            "NINUX A22 3.1CH Home\nTheater System Speakers",
            "$47"
        ),
        ProductListItem(
            R.drawable.image_product_1,
            "AILYONS 2.1CH\nMultimedia woofer",
            "$23"
        ),
        ProductListItem(
            R.drawable.image_product_2,
            "CLUBOX 3.1CH HIFI\nMultimedia Sub-woofer",
            "$44"
        ),
        ProductListItem(
            R.drawable.image_product_3,
            "NINUX A22 3.1CH Home\nTheater System Speakers",
            "$47"
        ),
        ProductListItem(
            R.drawable.image_product_1,
            "AILYONS 2.1CH\nMultimedia woofer",
            "$23"
        ),
        ProductListItem(
            R.drawable.image_product_2,
            "CLUBOX 3.1CH HIFI\nMultimedia Sub-woofer",
            "$44"
        ),
        ProductListItem(
            R.drawable.image_product_3,
            "NINUX A22 3.1CH Home\nTheater System Speakers",
            "$47"
        ),
        ProductListItem(
            R.drawable.image_product_1,
            "AILYONS 2.1CH\nMultimedia woofer",
            "$23"
        ),
        ProductListItem(
            R.drawable.image_product_2,
            "CLUBOX 3.1CH HIFI\nMultimedia Sub-woofer",
            "$44"
        ),
        ProductListItem(
            R.drawable.image_product_3,
            "NINUX A22 3.1CH Home\nTheater System Speakers",
            "$47"
        )
    )

    private val categoryList = listOf<ProductCategoryListItem>(
        ProductCategoryListItem(R.drawable.icon_category_shoes, "Обувь"),
        ProductCategoryListItem(R.drawable.icon_category_shirt, "Одежда"),
        ProductCategoryListItem(R.drawable.icon_category_food, "Еда"),
        ProductCategoryListItem(R.drawable.icon_category_glass, "Аксессуары"),
        ProductCategoryListItem(R.drawable.icon_category_lipstick, "Косметика"),
        ProductCategoryListItem(R.drawable.icon_category_phone, "Техника"),
    )

    private val categoryTitlesList = listOf<SaleTitleListItem>(
        SaleTitleListItem(R.drawable.sale_category_furniture, "Мебель для дома"),
        SaleTitleListItem(R.drawable.sale_category_tech, "Техника"),
        SaleTitleListItem(R.drawable.sale_category_man_cloth, "Мужская одежда"),
        SaleTitleListItem(R.drawable.sale_category_kids, "Дети"),
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

    companion object {
        const val CATEGORY_TECH = "tech";
    }
}