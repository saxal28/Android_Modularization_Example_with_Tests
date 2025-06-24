package com.example.ud1_modularization_example_2.data.pokemon;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\f\u0010\u0007\u001a\u00060\bj\u0002`\tH\u0007J\f\u0010\n\u001a\u00060\bj\u0002`\tH\u0007J\f\u0010\u000b\u001a\u00060\bj\u0002`\tH\u0007J\f\u0010\f\u001a\u00060\bj\u0002`\tH\u0007J\f\u0010\r\u001a\u00060\bj\u0002`\tH\u0007J\f\u0010\u000e\u001a\u00060\bj\u0002`\tH\u0007J\f\u0010\u000f\u001a\u00060\bj\u0002`\tH\u0007J\b\u0010\u0010\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/example/ud1_modularization_example_2/data/pokemon/PokemonRepositoryTest;", "", "()V", "apiService", "Lcom/example/ud1_modularization_example_2/data/pokemon/api/PokeApiService;", "repository", "Lcom/example/ud1_modularization_example_2/data/pokemon/repository/PokemonRepository;", "getPokemonDetail by id should return failure when api call throws exception", "", "Lkotlinx/coroutines/test/TestResult;", "getPokemonDetail by id should return success when api call succeeds", "getPokemonDetail by name should return failure when api call throws exception", "getPokemonDetail by name should return success when api call succeeds", "getPokemonList should return failure when api call throws exception", "getPokemonList should return success when api call succeeds", "getPokemonList should use default parameters when none provided", "setup", "pokemon_debugUnitTest"})
public final class PokemonRepositoryTest {
    private com.example.ud1_modularization_example_2.data.pokemon.api.PokeApiService apiService;
    private com.example.ud1_modularization_example_2.data.pokemon.repository.PokemonRepository repository;
    
    public PokemonRepositoryTest() {
        super();
    }
    
    @org.junit.Before()
    public final void setup() {
    }
}