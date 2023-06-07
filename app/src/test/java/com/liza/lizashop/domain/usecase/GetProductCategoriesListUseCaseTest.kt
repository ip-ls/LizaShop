package com.liza.lizashop.domain.usecase

import androidx.lifecycle.LiveData
import com.liza.lizashop.data.repository.ShopRepositoryImpl
import com.liza.lizashop.domain.entity.ProductCategoryListItem
import com.liza.lizashop.domain.repository.ShopRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import junit.framework.Assert.assertEquals
import org.junit.Test

class GetProductCategoriesListUseCaseTest {

    private val mockRepository: ShopRepositoryImpl = mockk()

    private val useCase = GetProductCategoriesListUseCase(mockRepository)

    @Test
    fun `invoke calls repository getProductCategoriesList`() {
        val listLiveData: LiveData<List<ProductCategoryListItem>> = mockk()
        every { mockRepository.getProductCategoriesList() } returns listLiveData

        val result = useCase()

        assertEquals(result, listLiveData)
        verify { mockRepository.getProductCategoriesList() }
    }
}