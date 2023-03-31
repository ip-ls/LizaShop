package com.liza.lizashop.domain.usecase

import com.liza.lizashop.domain.entity.LoginUser
import com.liza.lizashop.domain.repository.AccountsRepository

class LoginUserUseCase(
    private val repository: AccountsRepository
) {
    operator fun invoke(loginUser: LoginUser): Boolean {
        return repository.loginUser(loginUser)
    }
}