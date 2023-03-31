package com.liza.lizashop.data.repository

import com.liza.lizashop.data.datasource.AccountsRemoteDataSource
import com.liza.lizashop.domain.entity.LoginUser
import com.liza.lizashop.domain.entity.RegistrationUser
import com.liza.lizashop.domain.repository.AccountsRepository

class AccountsRepositoryImpl : AccountsRepository {

    private val dataSource = AccountsRemoteDataSource()

    override fun loginUser(loginUser: LoginUser): Boolean {
        return dataSource.loginUser(loginUser)
    }

    override fun registrationUser(registrationUser: RegistrationUser): Boolean {
        return dataSource.registrationUser(registrationUser)
    }
}