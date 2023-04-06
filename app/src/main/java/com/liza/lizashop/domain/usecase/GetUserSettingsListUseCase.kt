package com.liza.lizashop.domain.usecase

import androidx.lifecycle.LiveData
import com.liza.lizashop.domain.entity.SettingsListItem
import com.liza.lizashop.domain.repository.LocalRepository

class GetUserSettingsListUseCase(
    private val repository: LocalRepository
) {

    operator fun invoke(): LiveData<List<SettingsListItem>> {
        return repository.getUserSettingsList()
    }
}