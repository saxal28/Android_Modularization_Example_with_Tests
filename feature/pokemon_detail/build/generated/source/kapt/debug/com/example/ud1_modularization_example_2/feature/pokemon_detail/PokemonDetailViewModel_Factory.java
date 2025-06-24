package com.example.ud1_modularization_example_2.feature.pokemon_detail;

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
public final class PokemonDetailViewModel_Factory implements Factory<PokemonDetailViewModel> {
  private final Provider<PokemonRepository> pokemonRepositoryProvider;

  public PokemonDetailViewModel_Factory(Provider<PokemonRepository> pokemonRepositoryProvider) {
    this.pokemonRepositoryProvider = pokemonRepositoryProvider;
  }

  @Override
  public PokemonDetailViewModel get() {
    return newInstance(pokemonRepositoryProvider.get());
  }

  public static PokemonDetailViewModel_Factory create(
      Provider<PokemonRepository> pokemonRepositoryProvider) {
    return new PokemonDetailViewModel_Factory(pokemonRepositoryProvider);
  }

  public static PokemonDetailViewModel newInstance(PokemonRepository pokemonRepository) {
    return new PokemonDetailViewModel(pokemonRepository);
  }
}
