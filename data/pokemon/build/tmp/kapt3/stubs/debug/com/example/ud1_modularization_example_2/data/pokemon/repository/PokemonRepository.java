package com.example.ud1_modularization_example_2.data.pokemon.repository;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\n\u0010\u000bJ$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\f\u001a\u00020\rH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\n\u0010\u000eJ0\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00062\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\tH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u0015"}, d2 = {"Lcom/example/ud1_modularization_example_2/data/pokemon/repository/PokemonRepository;", "", "apiService", "Lcom/example/ud1_modularization_example_2/data/pokemon/api/PokeApiService;", "(Lcom/example/ud1_modularization_example_2/data/pokemon/api/PokeApiService;)V", "getPokemonDetail", "Lkotlin/Result;", "Lcom/example/ud1_modularization_example_2/data/pokemon/model/PokemonDetail;", "id", "", "getPokemonDetail-gIAlu-s", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "name", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPokemonList", "Lcom/example/ud1_modularization_example_2/data/pokemon/model/PokemonListResponse;", "limit", "offset", "getPokemonList-0E7RQCE", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pokemon_debug"})
public final class PokemonRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.example.ud1_modularization_example_2.data.pokemon.api.PokeApiService apiService = null;
    
    @javax.inject.Inject()
    public PokemonRepository(@org.jetbrains.annotations.NotNull()
    com.example.ud1_modularization_example_2.data.pokemon.api.PokeApiService apiService) {
        super();
    }
}