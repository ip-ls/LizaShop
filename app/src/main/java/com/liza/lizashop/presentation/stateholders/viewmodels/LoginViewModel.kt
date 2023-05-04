package com.liza.lizashop.presentation.stateholders.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.liza.lizashop.data.repository.AccountsRepositoryImpl
import com.liza.lizashop.domain.entity.LoginUser
import com.liza.lizashop.domain.usecase.LoginUserUseCase
import kotlinx.coroutines.launch

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = AccountsRepositoryImpl(application)

    private val loginUserUseCase = LoginUserUseCase(repository)

    /**
     * Danger moment with lateinit var
     */
    lateinit var checkLogin: LiveData<Boolean>


    fun checkValid(loginUser: LoginUser) {
        checkLogin = loginUserUseCase(loginUser)
    }
}