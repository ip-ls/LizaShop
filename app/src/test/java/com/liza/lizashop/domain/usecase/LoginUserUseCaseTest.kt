package com.liza.lizashop.domain.usecase

import androidx.lifecycle.LiveData
import com.liza.lizashop.domain.entity.LoginUser
import com.liza.lizashop.domain.repository.AccountsRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert.assertEquals
import org.junit.Test

class LoginUserUseCaseTest {

    private val mockRepository: AccountsRepository = mockk()

    private val useCase = LoginUserUseCase(mockRepository)

    @Test
    fun `invoke calls repository loginUser`() {
        // Arrange
        val loginUser = LoginUser("1234567890", "password")
        val loginLiveData: LiveData<Boolean> = mockk()
        every { mockRepository.loginUser(loginUser) } returns loginLiveData

        // Act
        val result = useCase(loginUser)

        // Assert
        assertEquals(result, loginLiveData)
        verify { mockRepository.loginUser(loginUser) }
    }
}