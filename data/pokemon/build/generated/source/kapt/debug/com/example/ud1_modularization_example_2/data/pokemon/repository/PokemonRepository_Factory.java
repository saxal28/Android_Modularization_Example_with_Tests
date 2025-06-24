package com.example.ud1_modularization_example_2.data.pokemon.repository;

import com.example.ud1_modularization_example_2.data.pokemon.api.PokeApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class PokemonRepository_Factory implements Factory<PokemonRepository> {
  private final Provider<PokeApiService> apiServiceProvider;

  public PokemonRepository_Factory(Provider<PokeApiService> apiServiceProvider) {
    this.apiServiceProvider = apiServiceProvider;
  }

  @Override
  public PokemonRepository get() {
    return newInstance(apiServiceProvider.get());
  }

  public static PokemonRepository_Factory create(Provider<PokeApiService> apiServiceProvider) {
    return new PokemonRepository_Factory(apiServiceProvider);
  }

  public static PokemonRepository newInstance(PokeApiService apiService) {
    return new PokemonRepository(apiService);
  }
}
