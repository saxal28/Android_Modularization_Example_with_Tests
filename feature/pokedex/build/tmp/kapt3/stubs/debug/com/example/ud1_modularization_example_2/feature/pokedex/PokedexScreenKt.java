package com.example.ud1_modularization_example_2.feature.pokedex;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a2\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007\u001aP\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007\u001a\b\u0010\u0010\u001a\u00020\u0001H\u0007\u001a.\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007\u001a\b\u0010\u0014\u001a\u00020\u0001H\u0007\u00a8\u0006\u0015"}, d2 = {"PokedexScreen", "", "modifier", "Landroidx/compose/ui/Modifier;", "viewModel", "Lcom/example/ud1_modularization_example_2/feature/pokedex/PokedexViewModel;", "onPokemonClick", "Lkotlin/Function1;", "", "PokedexScreenContent", "uiState", "Lcom/example/ud1_modularization_example_2/feature/pokedex/PokedexUiState;", "onSearchQueryChanged", "", "onRetry", "Lkotlin/Function0;", "PokedexScreenPreview", "PokemonCard", "pokemon", "Lcom/example/ud1_modularization_example_2/data/pokemon/model/PokemonListItem;", "PokemonCardPreview", "pokedex_debug"})
public final class PokedexScreenKt {
    
    @androidx.compose.runtime.Composable()
    public static final void PokedexScreen(@org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull()
    com.example.ud1_modularization_example_2.feature.pokedex.PokedexViewModel viewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onPokemonClick) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void PokedexScreenContent(@org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull()
    com.example.ud1_modularization_example_2.feature.pokedex.PokedexUiState uiState, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onSearchQueryChanged, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onRetry, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onPokemonClick) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void PokemonCard(@org.jetbrains.annotations.NotNull()
    com.example.ud1_modularization_example_2.data.pokemon.model.PokemonListItem pokemon, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onPokemonClick) {
    }
    
    @androidx.compose.ui.tooling.preview.Preview(showBackground = true)
    @androidx.compose.runtime.Composable()
    public static final void PokedexScreenPreview() {
    }
    
    @androidx.compose.ui.tooling.preview.Preview(showBackground = true)
    @androidx.compose.runtime.Composable()
    public static final void PokemonCardPreview() {
    }
}