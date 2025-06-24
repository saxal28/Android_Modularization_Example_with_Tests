package com.example.ud1_modularization_example_2.data.pokemon

import com.example.ud1_modularization_example_2.data.pokemon.model.PokemonAbility
import com.example.ud1_modularization_example_2.data.pokemon.model.PokemonAbilityInfo
import com.example.ud1_modularization_example_2.data.pokemon.model.PokemonDetail
import com.example.ud1_modularization_example_2.data.pokemon.model.PokemonListItem
import com.example.ud1_modularization_example_2.data.pokemon.model.PokemonListResponse
import com.example.ud1_modularization_example_2.data.pokemon.model.PokemonSprites
import com.example.ud1_modularization_example_2.data.pokemon.model.PokemonStat
import com.example.ud1_modularization_example_2.data.pokemon.model.PokemonStatInfo
import com.example.ud1_modularization_example_2.data.pokemon.model.PokemonType
import com.example.ud1_modularization_example_2.data.pokemon.model.PokemonTypeInfo
import com.google.gson.Gson
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class PokemonModelSerializationTest {

    private lateinit var gson: Gson

    @Before
    fun setup() {
        gson = Gson()
    }

    @Test
    fun `PokemonListResponse should serialize and deserialize correctly`() {
        // Given
        val originalResponse = PokemonListResponse(
            count = 1302,
            next = "https://pokeapi.co/api/v2/pokemon/?offset=20&limit=20",
            previous = null,
            results = listOf(
                PokemonListItem("bulbasaur", "https://pokeapi.co/api/v2/pokemon/1/"),
                PokemonListItem("ivysaur", "https://pokeapi.co/api/v2/pokemon/2/")
            )
        )

        // When
        val json = gson.toJson(originalResponse)
        val deserializedResponse = gson.fromJson(json, PokemonListResponse::class.java)

        // Then
        assertNotNull(deserializedResponse)
        assertEquals(originalResponse.count, deserializedResponse.count)
        assertEquals(originalResponse.next, deserializedResponse.next)
        assertEquals(originalResponse.previous, deserializedResponse.previous)
        assertEquals(originalResponse.results.size, deserializedResponse.results.size)
        assertEquals(originalResponse.results[0].name, deserializedResponse.results[0].name)
        assertEquals(originalResponse.results[0].url, deserializedResponse.results[0].url)
    }

    @Test
    fun `PokemonListItem should serialize and deserialize correctly`() {
        // Given
        val originalItem = PokemonListItem(
            name = "pikachu",
            url = "https://pokeapi.co/api/v2/pokemon/25/"
        )

        // When
        val json = gson.toJson(originalItem)
        val deserializedItem = gson.fromJson(json, PokemonListItem::class.java)

        // Then
        assertNotNull(deserializedItem)
        assertEquals(originalItem.name, deserializedItem.name)
        assertEquals(originalItem.url, deserializedItem.url)
        assertEquals(originalItem.id, deserializedItem.id)
        assertEquals(originalItem.image, deserializedItem.image)
    }

    @Test
    fun `PokemonDetail should serialize and deserialize correctly`() {
        // Given
        val originalDetail = PokemonDetail(
            id = 25,
            name = "pikachu",
            height = 4,
            weight = 60,
            baseExperience = 112,
            sprites = PokemonSprites(
                frontDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png",
                frontShiny = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/25.png",
                backDefault = null,
                backShiny = null
            ),
            types = listOf(
                PokemonType(
                    slot = 1,
                    type = PokemonTypeInfo("electric", "https://pokeapi.co/api/v2/type/13/")
                )
            ),
            stats = listOf(
                PokemonStat(
                    baseStat = 35,
                    effort = 0,
                    stat = PokemonStatInfo("hp", "https://pokeapi.co/api/v2/stat/1/")
                )
            ),
            abilities = listOf(
                PokemonAbility(
                    isHidden = false,
                    slot = 1,
                    ability = PokemonAbilityInfo("static", "https://pokeapi.co/api/v2/ability/9/")
                )
            )
        )

        // When
        val json = gson.toJson(originalDetail)
        val deserializedDetail = gson.fromJson(json, PokemonDetail::class.java)

        // Then
        assertNotNull(deserializedDetail)
        assertEquals(originalDetail.id, deserializedDetail.id)
        assertEquals(originalDetail.name, deserializedDetail.name)
        assertEquals(originalDetail.height, deserializedDetail.height)
        assertEquals(originalDetail.weight, deserializedDetail.weight)
        assertEquals(originalDetail.baseExperience, deserializedDetail.baseExperience)

        // Verify sprites
        assertEquals(originalDetail.sprites.frontDefault, deserializedDetail.sprites.frontDefault)
        assertEquals(originalDetail.sprites.frontShiny, deserializedDetail.sprites.frontShiny)

        // Verify types
        assertEquals(originalDetail.types.size, deserializedDetail.types.size)
        assertEquals(originalDetail.types[0].slot, deserializedDetail.types[0].slot)
        assertEquals(originalDetail.types[0].type.name, deserializedDetail.types[0].type.name)

        // Verify stats
        assertEquals(originalDetail.stats.size, deserializedDetail.stats.size)
        assertEquals(originalDetail.stats[0].baseStat, deserializedDetail.stats[0].baseStat)
        assertEquals(originalDetail.stats[0].stat.name, deserializedDetail.stats[0].stat.name)

        // Verify abilities
        assertEquals(originalDetail.abilities.size, deserializedDetail.abilities.size)
        assertEquals(originalDetail.abilities[0].isHidden, deserializedDetail.abilities[0].isHidden)
        assertEquals(
            originalDetail.abilities[0].ability.name,
            deserializedDetail.abilities[0].ability.name
        )
    }

    @Test
    fun `PokemonListResponse should deserialize from actual API JSON format`() {
        // Given - Sample JSON that matches the actual API response structure
        val apiJson = """
            {
                "count": 1302,
                "next": "https://pokeapi.co/api/v2/pokemon/?offset=20&limit=20",
                "previous": null,
                "results": [
                    {
                        "name": "bulbasaur",
                        "url": "https://pokeapi.co/api/v2/pokemon/1/"
                    },
                    {
                        "name": "ivysaur", 
                        "url": "https://pokeapi.co/api/v2/pokemon/2/"
                    }
                ]
            }
        """.trimIndent()

        // When
        val deserializedResponse = gson.fromJson(apiJson, PokemonListResponse::class.java)

        // Then
        assertNotNull(deserializedResponse)
        assertEquals(1302, deserializedResponse.count)
        assertEquals(
            "https://pokeapi.co/api/v2/pokemon/?offset=20&limit=20",
            deserializedResponse.next
        )
        assertEquals(null, deserializedResponse.previous)
        assertEquals(2, deserializedResponse.results.size)
        assertEquals("bulbasaur", deserializedResponse.results[0].name)
        assertEquals("https://pokeapi.co/api/v2/pokemon/1/", deserializedResponse.results[0].url)
        assertEquals(1, deserializedResponse.results[0].id)
    }

    @Test
    fun `PokemonDetail should handle null base_experience correctly`() {
        // Given - JSON with null base_experience (common in some Pokemon)
        val jsonWithNullBaseExp = """
            {
                "id": 150,
                "name": "mewtwo",
                "height": 20,
                "weight": 1220,
                "base_experience": null,
                "sprites": {
                    "front_default": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/150.png"
                },
                "types": [],
                "stats": [],
                "abilities": []
            }
        """.trimIndent()

        // When
        val deserializedDetail = gson.fromJson(jsonWithNullBaseExp, PokemonDetail::class.java)

        // Then
        assertNotNull(deserializedDetail)
        assertEquals(150, deserializedDetail.id)
        assertEquals("mewtwo", deserializedDetail.name)
        assertEquals(null, deserializedDetail.baseExperience)
    }
}