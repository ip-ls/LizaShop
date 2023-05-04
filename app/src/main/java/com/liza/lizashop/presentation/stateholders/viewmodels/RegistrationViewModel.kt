package com.liza.lizashop.presentation.stateholders.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.liza.lizashop.data.repository.AccountsRepositoryImpl
import com.liza.lizashop.domain.entity.RegistrationUser
import com.liza.lizashop.domain.usecase.RegistrationUserUseCase

class RegistrationViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = AccountsRepositoryImpl(application)

    private val registrationUseCase = RegistrationUserUseCase(repository)

    fun register(registrationUser: RegistrationUser) {
        registrationUseCase.invoke(registrationUser)
    }
}
