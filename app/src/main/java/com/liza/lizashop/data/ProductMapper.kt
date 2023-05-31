package com.liza.lizashop.data

import com.liza.lizashop.data.db.entities.Cart
import com.liza.lizashop.data.db.entities.ShopProduct
import com.liza.lizashop.domain.entity.CartListItem
import com.liza.lizashop.domain.entity.ProductListItem

object ProductMapper {

    fun mapDbModelListToEntityList(productList: List<ShopProduct>) : List<ProductListItem> {
        val list = mutableListOf<ProductListItem>()
        for (el in productList) {
            list.add(mapDbModelToEntity(el))
        }
        return list
    }

    private fun mapDbModelToEntity(el: ShopProduct): ProductListItem {
        return ProductListItem(
            id = el.uid,
            imageRes = el.imageRes,
            productName = el.productName,
            price = el.price
        )
    }


}