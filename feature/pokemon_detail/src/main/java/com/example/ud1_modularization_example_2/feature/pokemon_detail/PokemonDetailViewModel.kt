package com.example.ud1_modularization_example_2.feature.pokemon_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ud1_modularization_example_2.data.pokemon.model.PokemonDetail
import com.example.ud1_modularization_example_2.data.pokemon.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class PokemonDetailUiState(
    val isLoading: Boolean = false,
    val pokemon: PokemonDetail? = null,
    val error: String? = null,
)

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val pokemonRepository: PokemonRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(PokemonDetailUiState())
    val uiState: StateFlow<PokemonDetailUiState> = _uiState.asStateFlow()

    fun loadPokemonDetail(pokemonId: Int) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)

            pokemonRepository.getPokemonDetail(pokemonId)
                .onSuccess { pokemon ->
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        pokemon = pokemon,
                        error = null
                    )
                }
                .onFailure { exception ->
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        error = exception.message ?: "Unknown error occurred"
                    )
                }
        }
    }
}