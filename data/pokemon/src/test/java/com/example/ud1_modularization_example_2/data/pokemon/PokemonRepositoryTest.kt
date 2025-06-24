package com.example.ud1_modularization_example_2.data.pokemon

import com.example.ud1_modularization_example_2.data.pokemon.api.PokeApiService
import com.example.ud1_modularization_example_2.data.pokemon.model.PokemonDetail
import com.example.ud1_modularization_example_2.data.pokemon.model.PokemonListItem
import com.example.ud1_modularization_example_2.data.pokemon.model.PokemonListResponse
import com.example.ud1_modularization_example_2.data.pokemon.model.PokemonSprites
import com.example.ud1_modularization_example_2.data.pokemon.repository.PokemonRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import java.io.IOException

class PokemonRepositoryTest {

    private lateinit var apiService: PokeApiService
    private lateinit var repository: PokemonRepository

    @Before
    fun setup() {
        apiService = mockk()
        repository = PokemonRepository(apiService)
    }

    @Test
    fun `getPokemonList should return success when api call succeeds`() = runTest {
        // Given
        val expectedResponse = PokemonListResponse(
            count = 1302,
            next = "https://pokeapi.co/api/v2/pokemon/?offset=20&limit=20",
            previous = null,
            results = listOf(
                PokemonListItem("bulbasaur", "https://pokeapi.co/api/v2/pokemon/1/"),
                PokemonListItem("ivysaur", "https://pokeapi.co/api/v2/pokemon/2/")
            )
        )
        coEvery { apiService.getPokemonList(20, 0) } returns expectedResponse

        // When
        val result = repository.getPokemonList(20, 0)

        // Then
        assertTrue(result.isSuccess)
        assertEquals(expectedResponse, result.getOrNull())
        coVerify { apiService.getPokemonList(20, 0) }
    }

    @Test
    fun `getPokemonList should return failure when api call throws exception`() = runTest {
        // Given
        val exception = IOException("Network error")
        coEvery { apiService.getPokemonList(20, 0) } throws exception

        // When
        val result = repository.getPokemonList(20, 0)

        // Then
        assertTrue(result.isFailure)
        assertEquals(exception, result.exceptionOrNull())
        coVerify { apiService.getPokemonList(20, 0) }
    }

    @Test
    fun `getPokemonList should use default parameters when none provided`() = runTest {
        // Given
        val expectedResponse = PokemonListResponse(
            count = 1302,
            next = null,
            previous = null,
            results = emptyList()
        )
        coEvery { apiService.getPokemonList(20, 0) } returns expectedResponse

        // When
        val result = repository.getPokemonList()

        // Then
        assertTrue(result.isSuccess)
        coVerify { apiService.getPokemonList(20, 0) }
    }

    @Test
    fun `getPokemonDetail by name should return success when api call succeeds`() = runTest {
        // Given
        val pokemonName = "pikachu"
        val expectedDetail = PokemonDetail(
            id = 25,
            name = "pikachu",
            height = 4,
            weight = 60,
            baseExperience = 112,
            sprites = PokemonSprites(
                frontDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png",
                frontShiny = null,
                backDefault = null,
                backShiny = null
            ),
            types = emptyList(),
            stats = emptyList(),
            abilities = emptyList()
        )
        coEvery { apiService.getPokemonDetail(pokemonName) } returns expectedDetail

        // When
        val result = repository.getPokemonDetail(pokemonName)

        // Then
        assertTrue(result.isSuccess)
        assertEquals(expectedDetail, result.getOrNull())
        coVerify { apiService.getPokemonDetail(pokemonName) }
    }

    @Test
    fun `getPokemonDetail by name should return failure when api call throws exception`() =
        runTest {
            // Given
            val pokemonName = "nonexistent"
            val exception = IOException("Pokemon not found")
            coEvery { apiService.getPokemonDetail(pokemonName) } throws exception

            // When
            val result = repository.getPokemonDetail(pokemonName)

            // Then
            assertTrue(result.isFailure)
            assertEquals(exception, result.exceptionOrNull())
            coVerify { apiService.getPokemonDetail(pokemonName) }
        }

    @Test
    fun `getPokemonDetail by id should return success when api call succeeds`() = runTest {
        // Given
        val pokemonId = 25
        val expectedDetail = PokemonDetail(
            id = 25,
            name = "pikachu",
            height = 4,
            weight = 60,
            baseExperience = 112,
            sprites = PokemonSprites(
                frontDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png",
                frontShiny = null,
                backDefault = null,
                backShiny = null
            ),
            types = emptyList(),
            stats = emptyList(),
            abilities = emptyList()
        )
        coEvery { apiService.getPokemonDetail(pokemonId) } returns expectedDetail

        // When
        val result = repository.getPokemonDetail(pokemonId)

        // Then
        assertTrue(result.isSuccess)
        assertEquals(expectedDetail, result.getOrNull())
        coVerify { apiService.getPokemonDetail(pokemonId) }
    }

    @Test
    fun `getPokemonDetail by id should return failure when api call throws exception`() = runTest {
        // Given
        val pokemonId = -1
        val exception = IOException("Invalid Pokemon ID")
        coEvery { apiService.getPokemonDetail(pokemonId) } throws exception

        // When
        val result = repository.getPokemonDetail(pokemonId)

        // Then
        assertTrue(result.isFailure)
        assertEquals(exception, result.exceptionOrNull())
        coVerify { apiService.getPokemonDetail(pokemonId) }
    }
}