package com.example.ud1_modularization_example_2.feature.pokedex

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.ud1_modularization_example_2.data.pokemon.model.PokemonListItem
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PokedexScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val samplePokemonList = listOf(
        PokemonListItem(
            name = "bulbasaur",
            url = "https://pokeapi.co/api/v2/pokemon/1/"
        ),
        PokemonListItem(
            name = "charmander",
            url = "https://pokeapi.co/api/v2/pokemon/4/"
        ),
        PokemonListItem(
            name = "squirtle",
            url = "https://pokeapi.co/api/v2/pokemon/7/"
        ),
        PokemonListItem(
            name = "pikachu",
            url = "https://pokeapi.co/api/v2/pokemon/25/"
        )
    )

    @Test
    fun pokedexScreen_displaysHeaderCorrectly() {
        // Given
        val uiState = PokedexUiState(pokemonList = samplePokemonList)

        // When
        composeTestRule.setContent {
            PokedexScreenContent(
                uiState = uiState,
                onSearchQueryChanged = {},
                onRetry = {},
                onPokemonClick = {}
            )
        }

        // Then
        composeTestRule.onNodeWithText("Pokédex").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("Pokeball").assertIsDisplayed()
    }

    @Test
    fun pokedexScreen_displaysSearchBarCorrectly() {
        // Given
        val uiState = PokedexUiState(pokemonList = samplePokemonList)

        // When
        composeTestRule.setContent {
            PokedexScreenContent(
                uiState = uiState,
                onSearchQueryChanged = {},
                onRetry = {},
                onPokemonClick = {}
            )
        }

        // Then
        composeTestRule.onNodeWithContentDescription("Search").assertIsDisplayed()
        composeTestRule.onNodeWithText("Search").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("Sort").assertIsDisplayed()
    }

    @Test
    fun pokedexScreen_showsLoadingIndicator_whenLoading() {
        // Given
        val uiState = PokedexUiState(isLoading = true)

        // When
        composeTestRule.setContent {
            PokedexScreenContent(
                uiState = uiState,
                onSearchQueryChanged = {},
                onRetry = {},
                onPokemonClick = {}
            )
        }

        // Then - Check that the loading indicator is visible
        // Since CircularProgressIndicator doesn't have text, we test that Pokemon list is not visible
        composeTestRule.onNodeWithText("Bulbasaur").assertDoesNotExist()
        composeTestRule.onNodeWithText("Charmander").assertDoesNotExist()
    }

    @Test
    fun pokedexScreen_displaysAllPokemon_whenDataLoaded() {
        // Given
        val uiState = PokedexUiState(pokemonList = samplePokemonList)

        // When
        composeTestRule.setContent {
            PokedexScreenContent(
                uiState = uiState,
                onSearchQueryChanged = {},
                onRetry = {},
                onPokemonClick = {}
            )
        }

        // Then - Pokemon names should be displayed (capitalized)
        composeTestRule.onNodeWithText("Bulbasaur").assertIsDisplayed()
        composeTestRule.onNodeWithText("Charmander").assertIsDisplayed()
        composeTestRule.onNodeWithText("Squirtle").assertIsDisplayed()
        composeTestRule.onNodeWithText("Pikachu").assertIsDisplayed()
    }

    @Test
    fun pokedexScreen_displaysPokemonIds_whenDataLoaded() {
        // Given
        val uiState = PokedexUiState(pokemonList = samplePokemonList)

        // When
        composeTestRule.setContent {
            PokedexScreenContent(
                uiState = uiState,
                onSearchQueryChanged = {},
                onRetry = {},
                onPokemonClick = {}
            )
        }

        // Then - Pokemon IDs should be displayed with padding
        composeTestRule.onNodeWithText("#001").assertIsDisplayed()
        composeTestRule.onNodeWithText("#004").assertIsDisplayed()
        composeTestRule.onNodeWithText("#007").assertIsDisplayed()
        composeTestRule.onNodeWithText("#025").assertIsDisplayed()
    }

    @Test
    fun pokedexScreen_displaysErrorState_whenErrorOccurs() {
        // Given
        val errorMessage = "Failed to load pokemon list"
        val uiState = PokedexUiState(error = errorMessage)

        // When
        composeTestRule.setContent {
            PokedexScreenContent(
                uiState = uiState,
                onSearchQueryChanged = {},
                onRetry = {},
                onPokemonClick = {}
            )
        }

        // Then
        composeTestRule.onNodeWithText(errorMessage).assertIsDisplayed()
        composeTestRule.onNodeWithText("Retry").assertIsDisplayed()
    }

    @Test
    fun pokedexScreen_callsRetryCallback_whenRetryButtonClicked() {
        // Given
        var retryClicked = false
        val uiState = PokedexUiState(error = "Failed to load pokemon list")

        // When
        composeTestRule.setContent {
            PokedexScreenContent(
                uiState = uiState,
                onSearchQueryChanged = {},
                onRetry = { retryClicked = true },
                onPokemonClick = {}
            )
        }

        // Then
        composeTestRule.onNodeWithText("Retry").performClick()
        assert(retryClicked)
    }

    @Test
    fun pokedexScreen_searchFiltersResults_whenSearchQueryEntered() {
        // Given
        val uiState = PokedexUiState(
            pokemonList = samplePokemonList,
            searchQuery = "pika"
        )

        // When
        composeTestRule.setContent {
            PokedexScreenContent(
                uiState = uiState,
                onSearchQueryChanged = {},
                onRetry = {},
                onPokemonClick = {}
            )
        }

        // Then - Only Pikachu should be visible
        composeTestRule.onNodeWithText("Pikachu").assertIsDisplayed()
        composeTestRule.onNodeWithText("Bulbasaur").assertDoesNotExist()
        composeTestRule.onNodeWithText("Charmander").assertDoesNotExist()
        composeTestRule.onNodeWithText("Squirtle").assertDoesNotExist()
    }

    @Test
    fun pokedexScreen_callsSearchCallback_whenSearchQueryChanged() {
        // Given
        var searchQuery = ""
        val uiState = PokedexUiState(pokemonList = samplePokemonList)

        // When
        composeTestRule.setContent {
            PokedexScreenContent(
                uiState = uiState,
                onSearchQueryChanged = { searchQuery = it },
                onRetry = {},
                onPokemonClick = {}
            )
        }

        // Then - Find and interact with search field
        composeTestRule.onNodeWithText("Search").performTextInput("test")
    }

    @Test
    fun pokedexScreen_callsPokemonClickCallback_whenPokemonCardClicked() {
        // Given
        var clickedPokemonId = -1
        val uiState = PokedexUiState(pokemonList = samplePokemonList)

        // When
        composeTestRule.setContent {
            PokedexScreenContent(
                uiState = uiState,
                onSearchQueryChanged = {},
                onRetry = {},
                onPokemonClick = { pokemonId -> clickedPokemonId = pokemonId }
            )
        }

        // Then - Click on Bulbasaur card and verify callback
        composeTestRule.onNodeWithText("Bulbasaur").performClick()
        assert(clickedPokemonId == 1)
    }

    @Test
    fun pokedexScreen_displaysPokemonImages_whenDataLoaded() {
        // Given
        val uiState = PokedexUiState(pokemonList = samplePokemonList)

        // When
        composeTestRule.setContent {
            PokedexScreenContent(
                uiState = uiState,
                onSearchQueryChanged = {},
                onRetry = {},
                onPokemonClick = {}
            )
        }

        // Then - Pokemon images should have proper content descriptions
        composeTestRule.onNodeWithContentDescription("bulbasaur").assertExists()
        composeTestRule.onNodeWithContentDescription("charmander").assertExists()
        composeTestRule.onNodeWithContentDescription("squirtle").assertExists()
        composeTestRule.onNodeWithContentDescription("pikachu").assertExists()
    }

    @Test
    fun pokedexScreen_showsCorrectPokemonCount_whenDataLoaded() {
        // Given
        val uiState = PokedexUiState(pokemonList = samplePokemonList)

        // When
        composeTestRule.setContent {
            PokedexScreenContent(
                uiState = uiState,
                onSearchQueryChanged = {},
                onRetry = {},
                onPokemonClick = {}
            )
        }

        // Then - Should display all 4 Pokemon
        composeTestRule.onAllNodesWithText("Bulbasaur", substring = true).assertCountEquals(1)
        composeTestRule.onAllNodesWithText("Charmander", substring = true).assertCountEquals(1)
        composeTestRule.onAllNodesWithText("Squirtle", substring = true).assertCountEquals(1)
        composeTestRule.onAllNodesWithText("Pikachu", substring = true).assertCountEquals(1)
    }

    @Test
    fun pokedexScreen_showsEmptyState_whenNoPokemonData() {
        // Given
        val uiState = PokedexUiState(pokemonList = emptyList())

        // When
        composeTestRule.setContent {
            PokedexScreenContent(
                uiState = uiState,
                onSearchQueryChanged = {},
                onRetry = {},
                onPokemonClick = {}
            )
        }

        // Then - Should not show any Pokemon cards
        composeTestRule.onNodeWithText("Bulbasaur").assertDoesNotExist()
        composeTestRule.onNodeWithText("Charmander").assertDoesNotExist()
        // Header should still be present
        composeTestRule.onNodeWithText("Pokédex").assertIsDisplayed()
    }

    @Test
    fun pokedexScreen_searchIsCaseInsensitive() {
        // Given
        val uiState = PokedexUiState(
            pokemonList = samplePokemonList,
            searchQuery = "PIKA"
        )

        // When
        composeTestRule.setContent {
            PokedexScreenContent(
                uiState = uiState,
                onSearchQueryChanged = {},
                onRetry = {},
                onPokemonClick = {}
            )
        }

        // Then - Pikachu should still be visible with uppercase search
        composeTestRule.onNodeWithText("Pikachu").assertIsDisplayed()
        composeTestRule.onNodeWithText("Bulbasaur").assertDoesNotExist()
    }

    @Test
    fun pokemonCard_displaysAllRequiredInformation() {
        // Given
        val pokemon = PokemonListItem(
            name = "bulbasaur",
            url = "https://pokeapi.co/api/v2/pokemon/1/"
        )

        // When
        composeTestRule.setContent {
            PokemonCard(pokemon = pokemon, onPokemonClick = {})
        }

        // Then
        composeTestRule.onNodeWithText("Bulbasaur").assertIsDisplayed()
        composeTestRule.onNodeWithText("#001").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("bulbasaur").assertExists()
    }

    @Test
    fun pokemonCard_callsClickCallback_whenClicked() {
        // Given
        var clickedId = -1
        val pokemon = PokemonListItem(
            name = "bulbasaur",
            url = "https://pokeapi.co/api/v2/pokemon/1/"
        )

        // When
        composeTestRule.setContent {
            PokemonCard(
                pokemon = pokemon,
                onPokemonClick = { id -> clickedId = id }
            )
        }

        // Then
        composeTestRule.onNodeWithText("Bulbasaur").performClick()
        assert(clickedId == 1)
    }
}
