package com.example.ud1_modularization_example_2.data.pokemon.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\tJ\"\u0010\n\u001a\u00020\u000b2\b\b\u0003\u0010\f\u001a\u00020\u00052\b\b\u0003\u0010\r\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/example/ud1_modularization_example_2/data/pokemon/api/PokeApiService;", "", "getPokemonDetail", "Lcom/example/ud1_modularization_example_2/data/pokemon/model/PokemonDetail;", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "name", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPokemonList", "Lcom/example/ud1_modularization_example_2/data/pokemon/model/PokemonListResponse;", "limit", "offset", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pokemon_release"})
public abstract interface PokeApiService {
    
    @retrofit2.http.GET(value = "pokemon")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPokemonList(@retrofit2.http.Query(value = "limit")
    int limit, @retrofit2.http.Query(value = "offset")
    int offset, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.ud1_modularization_example_2.data.pokemon.model.PokemonListResponse> $completion);
    
    @retrofit2.http.GET(value = "pokemon/{name}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPokemonDetail(@retrofit2.http.Path(value = "name")
    @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.ud1_modularization_example_2.data.pokemon.model.PokemonDetail> $completion);
    
    @retrofit2.http.GET(value = "pokemon/{id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPokemonDetail(@retrofit2.http.Path(value = "id")
    int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.ud1_modularization_example_2.data.pokemon.model.PokemonDetail> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}