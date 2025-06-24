package com.example.ud1_modularization_example_2.feature.pokemon_detail;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0003\u001a\u001e\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0003\u001a\u0016\u0010\u000b\u001a\u00020\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0003\u001a(\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0003\u001a2\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007\u001a*\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019\u001a\"\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001c\u001a\u0010\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0003\u001a\"\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0017H\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b!\u0010\u001c\u001a\u0015\u0010\"\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u0003H\u0002\u00a2\u0006\u0002\u0010#\u0082\u0002\u0007\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006$"}, d2 = {"AttributeItem", "", "value", "", "label", "modifier", "Landroidx/compose/ui/Modifier;", "ErrorScreen", "error", "onBackClick", "Lkotlin/Function0;", "LoadingScreen", "PokemonDetailContent", "pokemon", "Lcom/example/ud1_modularization_example_2/data/pokemon/model/PokemonDetail;", "PokemonDetailScreen", "pokemonId", "", "viewModel", "Lcom/example/ud1_modularization_example_2/feature/pokemon_detail/PokemonDetailViewModel;", "StatBar", "maxValue", "color", "Landroidx/compose/ui/graphics/Color;", "StatBar-mxwnekA", "(IIJ)V", "StatLabel", "StatLabel-4WTKRHQ", "(Ljava/lang/String;J)V", "StatValue", "TypeChip", "typeName", "backgroundColor", "TypeChip-4WTKRHQ", "getPokemonTypeColor", "(Ljava/lang/String;)J", "pokemon_detail_debug"})
public final class PokemonDetailScreenKt {
    
    @androidx.compose.runtime.Composable()
    public static final void PokemonDetailScreen(int pokemonId, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onBackClick, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull()
    com.example.ud1_modularization_example_2.feature.pokemon_detail.PokemonDetailViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void LoadingScreen(kotlin.jvm.functions.Function0<kotlin.Unit> onBackClick) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ErrorScreen(java.lang.String error, kotlin.jvm.functions.Function0<kotlin.Unit> onBackClick) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void PokemonDetailContent(com.example.ud1_modularization_example_2.data.pokemon.model.PokemonDetail pokemon, kotlin.jvm.functions.Function0<kotlin.Unit> onBackClick, androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void AttributeItem(java.lang.String value, java.lang.String label, androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void StatValue(java.lang.String value) {
    }
    
    private static final long getPokemonTypeColor(java.lang.String typeName) {
        return 0L;
    }
}