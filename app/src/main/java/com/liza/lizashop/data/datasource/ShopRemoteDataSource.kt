package com.liza.lizashop.data.datasource

import android.content.Context
import com.liza.lizashop.R
import com.liza.lizashop.domain.entity.ProductCategoryListItem
import com.liza.lizashop.domain.entity.ProductListItem
import com.liza.lizashop.domain.entity.SettingsListItem

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

    fun getProductList(category: String): List<ProductListItem> {
        if (category == CATEGORY_TECH)
            return productTechList
        TODO()
    }

    fun getProductCategoryList(): List<ProductCategoryListItem> {
        return categoryList
    }

    fun getSaleTitleList(): List<ProductListItem> {
        return productTechList
    }

    companion object {
        const val CATEGORY_TECH = "tech";
    }
}