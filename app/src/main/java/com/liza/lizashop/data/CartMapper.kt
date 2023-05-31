package com.liza.lizashop.data


import com.liza.lizashop.data.db.entities.Cart
import com.liza.lizashop.domain.entity.CartListItem

object CartMapper {

    fun mapDbModelListToEntityList(cartList: List<Cart>) : List<CartListItem> {
        val list = mutableListOf<CartListItem>()
        for (el in cartList) {
            list.add(mapDbModelToEntity(el))
        }
        return list
    }

    fun mapEntityToDbModel(cartListItem: CartListItem): Cart {
        return Cart(
            id = cartListItem.id,
            imageRes = cartListItem.imageRes,
            productName = cartListItem.productName,
            price = cartListItem.price,
            productCount = cartListItem.productCount,
            checked = cartListItem.checked
        )
    }

    fun mapDbModelToEntity(cart: Cart): CartListItem {
        return CartListItem(
            id = cart.id,
            imageRes = cart.imageRes,
            productName = cart.productName,
            price = cart.price,
            productCount = cart.productCount,
            checked = cart.checked
        )
    }

}