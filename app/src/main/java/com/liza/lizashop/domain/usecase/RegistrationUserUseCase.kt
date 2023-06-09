package com.liza.lizashop.domain.usecase

import com.liza.lizashop.domain.entity.RegistrationUser
import com.liza.lizashop.domain.entity.Roles
import com.liza.lizashop.domain.repository.AccountsRepository

class RegistrationUserUseCase(
    private val repository: AccountsRepository
) {

    operator fun invoke(registrationUser: RegistrationUser, role: Roles): Boolean {
        return repository.registrationUser(registrationUser, role)
    }
}