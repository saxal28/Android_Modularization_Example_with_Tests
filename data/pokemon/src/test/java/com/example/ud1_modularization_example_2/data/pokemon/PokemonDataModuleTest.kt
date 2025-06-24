package com.example.ud1_modularization_example_2.data.pokemon

import com.example.ud1_modularization_example_2.data.pokemon.api.PokeApiService
import com.example.ud1_modularization_example_2.data.pokemon.di.PokemonDataModule
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import retrofit2.Retrofit

class PokemonDataModuleTest {

    @Test
    fun `providePokeApiService should create service with correct base URL`() {
        // Given
        val mockRetrofit = mockk<Retrofit>()
        val mockRetrofitBuilder = mockk<Retrofit.Builder>()
        val expectedService = mockk<PokeApiService>()

        every { mockRetrofitBuilder.baseUrl("https://pokeapi.co/api/v2/") } returns mockRetrofitBuilder
        every { mockRetrofitBuilder.build() } returns mockRetrofit
        every { mockRetrofit.create(PokeApiService::class.java) } returns expectedService

        // When
        val result = PokemonDataModule.providePokeApiService(mockRetrofitBuilder)

        // Then
        assertNotNull(result)
        assertEquals(expectedService, result)
        verify { mockRetrofitBuilder.baseUrl("https://pokeapi.co/api/v2/") }
        verify { mockRetrofitBuilder.build() }
        verify { mockRetrofit.create(PokeApiService::class.java) }
    }

    @Test
    fun `providePokeApiService should use correct API base URL`() {
        // Given
        val mockRetrofitBuilder = mockk<Retrofit.Builder>(relaxed = true)
        val mockRetrofit = mockk<Retrofit>(relaxed = true)
        val mockService = mockk<PokeApiService>()

        every { mockRetrofitBuilder.baseUrl(any<String>()) } returns mockRetrofitBuilder
        every { mockRetrofitBuilder.build() } returns mockRetrofit
        every { mockRetrofit.create(PokeApiService::class.java) } returns mockService

        // When
        PokemonDataModule.providePokeApiService(mockRetrofitBuilder)

        // Then
        verify { mockRetrofitBuilder.baseUrl("https://pokeapi.co/api/v2/") }
    }

    @Test
    fun `providePokeApiService should build retrofit and create service`() {
        // Given
        val mockRetrofitBuilder = mockk<Retrofit.Builder>(relaxed = true)
        val mockRetrofit = mockk<Retrofit>(relaxed = true)
        val mockService = mockk<PokeApiService>()

        every { mockRetrofitBuilder.baseUrl(any<String>()) } returns mockRetrofitBuilder
        every { mockRetrofitBuilder.build() } returns mockRetrofit
        every { mockRetrofit.create(PokeApiService::class.java) } returns mockService

        // When
        val result = PokemonDataModule.providePokeApiService(mockRetrofitBuilder)

        // Then
        assertEquals(mockService, result)
        verify(exactly = 1) { mockRetrofitBuilder.build() }
        verify(exactly = 1) { mockRetrofit.create(PokeApiService::class.java) }
    }
}