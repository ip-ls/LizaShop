package com.liza.lizashop.data.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.liza.lizashop.data.db.entities.Cart;

import java.util.List;

@Dao
public interface CartDao {
    @Query("SELECT * FROM cart")
    LiveData<List<Cart>> getCartList();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Cart cart);

    @Query("SELECT * FROM cart WHERE :id LIKE id")
    LiveData<Cart> getItem(int id);

    @Query("UPDATE cart SET productCount = productCount + 1 WHERE :id=id")
    void addProductCountCart(int id);

    @Query("UPDATE cart SET productCount = productCount - 1 WHERE :id=id")
    void subProductCountCart(int id);

    @Query("DELETE FROM cart WHERE :id = id")
    void removeProductCart(int id);

    @Query("UPDATE cart SET checked = NOT checked WHERE :id = id")
    void checkedProductCart(int id);

    @Query("UPDATE cart SET checked = 1")
    void checkedTrueAllProductsCart();
}
