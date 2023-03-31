package com.liza.lizashop.data.datasource

import com.liza.lizashop.domain.entity.LoginUser
import com.liza.lizashop.domain.entity.RegistrationUser

class AccountsRemoteDataSource {

    fun loginUser(loginUser: LoginUser): Boolean {
        return loginUser.phone == "79007777777" && loginUser.password == "123456"
    }

    fun registrationUser(registrationUser: RegistrationUser): Boolean {
        return true
    }

}