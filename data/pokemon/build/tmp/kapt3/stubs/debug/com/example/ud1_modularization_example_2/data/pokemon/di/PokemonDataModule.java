package com.example.ud1_modularization_example_2.data.pokemon.di;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/example/ud1_modularization_example_2/data/pokemon/di/PokemonDataModule;", "", "()V", "BASE_URL", "", "providePokeApiService", "Lcom/example/ud1_modularization_example_2/data/pokemon/api/PokeApiService;", "retrofitBuilder", "Lretrofit2/Retrofit$Builder;", "pokemon_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class PokemonDataModule {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String BASE_URL = "https://pokeapi.co/api/v2/";
    @org.jetbrains.annotations.NotNull()
    public static final com.example.ud1_modularization_example_2.data.pokemon.di.PokemonDataModule INSTANCE = null;
    
    private PokemonDataModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.example.ud1_modularization_example_2.data.pokemon.api.PokeApiService providePokeApiService(@org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit.Builder retrofitBuilder) {
        return null;
    }
}