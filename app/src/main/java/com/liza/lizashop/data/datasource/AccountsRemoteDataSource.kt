package com.liza.lizashop.data.datasource

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import com.liza.lizashop.data.db.LizaShopDataBase
import com.liza.lizashop.data.db.dao.UserDao
import com.liza.lizashop.data.db.entities.User
import com.liza.lizashop.domain.entity.LoginUser
import com.liza.lizashop.domain.entity.RegistrationUser
import com.liza.lizashop.domain.entity.Roles
import kotlin.Boolean

class AccountsRemoteDataSource(private val userDao: UserDao, private val context: Context) {

    fun loginUser(loginUser: LoginUser): LiveData<Boolean> {
        return userDao.checkUserLogin(loginUser.phone, loginUser.password)
    }

    fun registrationUser(registrationUser: RegistrationUser, role: Roles) {
        Log.d("AccountsRemoteDataSource", registrationUser.toString())
        val db = LizaShopDataBase.getDatabase(context)
        val userDao = db.userDao()
        db.queryExecutor.execute {
            userDao.register(User(
                phone = registrationUser.phone,
                name = registrationUser.name,
                surname = registrationUser.name,
                hashPassword = registrationUser.password,
                role = role
            ))
        }
    }
}