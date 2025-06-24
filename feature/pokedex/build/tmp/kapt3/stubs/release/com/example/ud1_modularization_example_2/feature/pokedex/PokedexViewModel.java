package com.example.ud1_modularization_example_2.feature.pokedex;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/example/ud1_modularization_example_2/feature/pokedex/PokedexViewModel;", "Landroidx/lifecycle/ViewModel;", "pokemonRepository", "Lcom/example/ud1_modularization_example_2/data/pokemon/repository/PokemonRepository;", "(Lcom/example/ud1_modularization_example_2/data/pokemon/repository/PokemonRepository;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/ud1_modularization_example_2/feature/pokedex/PokedexUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "loadPokemonList", "", "onSearchQueryChanged", "query", "", "pokedex_release"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class PokedexViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.ud1_modularization_example_2.data.pokemon.repository.PokemonRepository pokemonRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.ud1_modularization_example_2.feature.pokedex.PokedexUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.ud1_modularization_example_2.feature.pokedex.PokedexUiState> uiState = null;
    
    @javax.inject.Inject()
    public PokedexViewModel(@org.jetbrains.annotations.NotNull()
    com.example.ud1_modularization_example_2.data.pokemon.repository.PokemonRepository pokemonRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.ud1_modularization_example_2.feature.pokedex.PokedexUiState> getUiState() {
        return null;
    }
    
    public final void onSearchQueryChanged(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
    }
    
    public final void loadPokemonList() {
    }
}