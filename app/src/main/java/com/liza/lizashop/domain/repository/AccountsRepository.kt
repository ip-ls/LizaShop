package com.liza.lizashop.domain.repository

import androidx.lifecycle.LiveData
import com.liza.lizashop.domain.entity.LoginUser
import com.liza.lizashop.domain.entity.RegistrationUser

interface AccountsRepository {

    fun loginUser(loginUser: LoginUser): LiveData<Boolean>

    fun registrationUser(registrationUser: RegistrationUser): Boolean

}