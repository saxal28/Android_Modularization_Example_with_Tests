package com.example.ud1_modularization_example_2.data.pokemon.di;

import com.example.ud1_modularization_example_2.data.pokemon.api.PokeApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

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
public final class PokemonDataModule_ProvidePokeApiServiceFactory implements Factory<PokeApiService> {
  private final Provider<Retrofit.Builder> retrofitBuilderProvider;

  public PokemonDataModule_ProvidePokeApiServiceFactory(
      Provider<Retrofit.Builder> retrofitBuilderProvider) {
    this.retrofitBuilderProvider = retrofitBuilderProvider;
  }

  @Override
  public PokeApiService get() {
    return providePokeApiService(retrofitBuilderProvider.get());
  }

  public static PokemonDataModule_ProvidePokeApiServiceFactory create(
      Provider<Retrofit.Builder> retrofitBuilderProvider) {
    return new PokemonDataModule_ProvidePokeApiServiceFactory(retrofitBuilderProvider);
  }

  public static PokeApiService providePokeApiService(Retrofit.Builder retrofitBuilder) {
    return Preconditions.checkNotNullFromProvides(PokemonDataModule.INSTANCE.providePokeApiService(retrofitBuilder));
  }
}
