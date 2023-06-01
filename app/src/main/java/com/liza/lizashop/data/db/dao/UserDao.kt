package com.liza.lizashop.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.liza.lizashop.data.db.entities.User
import com.liza.lizashop.domain.entity.Roles
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAllUsers(): LiveData<List<User>>

    @Query("SELECT EXISTS(SELECT * FROM user WHERE phone=:phone AND hash_password=:hashPassword)")
    fun checkUserLogin(phone: String, hashPassword: String): LiveData<Boolean>

    @Query("SELECT * FROM user WHERE phone LIKE :phone")
    fun findByPhone(phone: String): LiveData<User>

    @Query("SELECT * FROM user WHERE uid LIKE :uid")
    fun findById(uid: Int): LiveData<User>

    @Insert
    fun register(user: User)

    @Insert
    fun insertAll(vararg users: User)

    @Query("SELECT name FROM user WHERE phone LIKE :phone")
    fun getUserName(phone: String) : LiveData<String>

    @Query("SELECT role FROM user WHERE phone LIKE :phone")
    fun getRole(phone: String) : LiveData<Roles>
}
