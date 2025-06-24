package com.example.ud1_modularization_example_2.data.pokemon

import com.example.ud1_modularization_example_2.data.pokemon.model.PokemonListItem
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class PokemonListItemTest {

    @Test
    fun `id should extract correct value from valid url`() {
        // Given
        val pokemonItem = PokemonListItem(
            name = "pikachu",
            url = "https://pokeapi.co/api/v2/pokemon/25/"
        )

        // When
        val id = pokemonItem.id

        // Then
        assertEquals(25, id)
    }

    @Test
    fun `id should extract correct value from url without trailing slash`() {
        // Given
        val pokemonItem = PokemonListItem(
            name = "bulbasaur",
            url = "https://pokeapi.co/api/v2/pokemon/1"
        )

        // When
        val id = pokemonItem.id

        // Then
        assertEquals(1, id)
    }

    @Test
    fun `id should return null for invalid url format`() {
        // Given
        val pokemonItem = PokemonListItem(
            name = "invalid",
            url = "https://pokeapi.co/api/v2/pokemon/"
        )

        // When
        val id = pokemonItem.id

        // Then
        assertNull(id)
    }

    @Test
    fun `id should return null for non-numeric id in url`() {
        // Given
        val pokemonItem = PokemonListItem(
            name = "invalid",
            url = "https://pokeapi.co/api/v2/pokemon/abc/"
        )

        // When
        val id = pokemonItem.id

        // Then
        assertNull(id)
    }

    @Test
    fun `image should return correct url for valid id`() {
        // Given
        val pokemonItem = PokemonListItem(
            name = "charizard",
            url = "https://pokeapi.co/api/v2/pokemon/6/"
        )

        // When
        val imageUrl = pokemonItem.image

        // Then
        val expectedUrl =
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/6.png"
        assertEquals(expectedUrl, imageUrl)
    }

    @Test
    fun `image should return url with null for invalid id`() {
        // Given
        val pokemonItem = PokemonListItem(
            name = "invalid",
            url = "https://pokeapi.co/api/v2/pokemon/"
        )

        // When
        val imageUrl = pokemonItem.image

        // Then
        val expectedUrl =
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/null.png"
        assertEquals(expectedUrl, imageUrl)
    }

    @Test
    fun `data class properties should be accessible`() {
        // Given
        val name = "squirtle"
        val url = "https://pokeapi.co/api/v2/pokemon/7/"
        val pokemonItem = PokemonListItem(name = name, url = url)

        // Then
        assertEquals(name, pokemonItem.name)
        assertEquals(url, pokemonItem.url)
    }
}