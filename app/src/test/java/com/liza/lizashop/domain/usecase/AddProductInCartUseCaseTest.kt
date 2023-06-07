package com.liza.lizashop.domain.usecase

import com.liza.lizashop.domain.entity.ProductListItem
import com.liza.lizashop.domain.repository.ShopRepository
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

class AddProductInCartUseCaseTest {

    private val mockRepository: ShopRepository = mockk()

    private val useCase = AddProductInCartUseCase(mockRepository)

    @Test
    fun `invoke calls repository addProductInCart`() {
        // Arrange
        val productListItem = ProductListItem(1, 101, "Product", "100", "Category")
        val phone = "1234567890"
        every { mockRepository.addProductInCart(productListItem, phone) } just Runs

        // Act
        useCase(productListItem, phone)

        // Assert
        verify { mockRepository.addProductInCart(productListItem, phone) }
    }
}