package com.example.ud1_modularization_example_2.feature.pokedex

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ud1_modularization_example_2.data.pokemon.model.PokemonListItem
import com.example.ud1_modularization_example_2.data.pokemon.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokedexViewModel @Inject constructor(
    private val pokemonRepository: PokemonRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(PokedexUiState())
    val uiState: StateFlow<PokedexUiState> = _uiState.asStateFlow()

    init {
        loadPokemonList()
    }

    fun onSearchQueryChanged(query: String) {
        _uiState.value = _uiState.value.copy(searchQuery = query)
    }
    
    fun loadPokemonList() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)

            pokemonRepository.getPokemonList(limit = 20, offset = 0)
                .onSuccess { pokemonListResponse ->
                    _uiState.value = _uiState.value.copy(
                        pokemonList = pokemonListResponse.results,
                        isLoading = false
                    )
                }
                .onFailure {
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        error = "Failed to load pokemon list"
                    )
                }
        }
    }
}

data class PokedexUiState(
    val pokemonList: List<PokemonListItem> = emptyList(),
    val searchQuery: String = "",
    val isLoading: Boolean = false,
    val error: String? = null,
)
