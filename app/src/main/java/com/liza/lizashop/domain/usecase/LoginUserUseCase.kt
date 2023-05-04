package com.liza.lizashop.domain.usecase

import androidx.lifecycle.LiveData
import com.liza.lizashop.domain.entity.LoginUser
import com.liza.lizashop.domain.repository.AccountsRepository

class LoginUserUseCase(
    private val repository: AccountsRepository
) {
    operator fun invoke(loginUser: LoginUser): LiveData<Boolean> {
        return repository.loginUser(loginUser)
    }
}