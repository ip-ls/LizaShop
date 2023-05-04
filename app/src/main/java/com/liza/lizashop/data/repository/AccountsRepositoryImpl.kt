package com.liza.lizashop.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.liza.lizashop.data.datasource.AccountsRemoteDataSource
import com.liza.lizashop.data.db.LizaShopDataBase
import com.liza.lizashop.domain.entity.LoginUser
import com.liza.lizashop.domain.entity.RegistrationUser
import com.liza.lizashop.domain.repository.AccountsRepository

class AccountsRepositoryImpl(context: Context) : AccountsRepository {

    private val database by lazy { LizaShopDataBase.getDatabase(context) }
    private val dataSource = AccountsRemoteDataSource(database.userDao(), context)

    override fun loginUser(loginUser: LoginUser): LiveData<Boolean> {
        return dataSource.loginUser(loginUser)
    }

    override fun registrationUser(registrationUser: RegistrationUser): Boolean {
        dataSource.registrationUser(registrationUser)
        return true
    }
}