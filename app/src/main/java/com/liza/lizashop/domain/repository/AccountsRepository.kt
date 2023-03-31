package com.liza.lizashop.domain.repository

import com.liza.lizashop.domain.entity.LoginUser
import com.liza.lizashop.domain.entity.RegistrationUser

interface AccountsRepository {

    fun loginUser(loginUser: LoginUser): Boolean

    fun registrationUser(registrationUser: RegistrationUser): Boolean

}