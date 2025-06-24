package com.example.ud1_modularization_example_2.feature.pokedex;

import com.example.ud1_modularization_example_2.data.pokemon.repository.PokemonRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class PokedexViewModel_Factory implements Factory<PokedexViewModel> {
  private final Provider<PokemonRepository> pokemonRepositoryProvider;

  public PokedexViewModel_Factory(Provider<PokemonRepository> pokemonRepositoryProvider) {
    this.pokemonRepositoryProvider = pokemonRepositoryProvider;
  }

  @Override
  public PokedexViewModel get() {
    return newInstance(pokemonRepositoryProvider.get());
  }

  public static PokedexViewModel_Factory create(
      Provider<PokemonRepository> pokemonRepositoryProvider) {
    return new PokedexViewModel_Factory(pokemonRepositoryProvider);
  }

  public static PokedexViewModel newInstance(PokemonRepository pokemonRepository) {
    return new PokedexViewModel(pokemonRepository);
  }
}
