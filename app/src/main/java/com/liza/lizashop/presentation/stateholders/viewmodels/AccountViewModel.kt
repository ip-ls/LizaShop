package com.liza.lizashop.presentation.stateholders.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.liza.lizashop.data.repository.LocalRepositoryImpl
import com.liza.lizashop.domain.repository.LocalRepository
import com.liza.lizashop.domain.usecase.GetUserSettingsListUseCase

class AccountViewModel(application: Application, phone: String) : AndroidViewModel(application) {

    private val repository = LocalRepositoryImpl(getApplication())

    private val getUserSettingsUseCase = GetUserSettingsListUseCase(repository)

    val userName = repository.getUserName(phone)

    val settingsListLd = getUserSettingsUseCase.invoke()

}
