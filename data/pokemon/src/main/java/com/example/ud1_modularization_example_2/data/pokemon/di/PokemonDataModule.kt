package com.example.ud1_modularization_example_2.data.pokemon.di

import com.example.ud1_modularization_example_2.data.pokemon.api.PokeApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PokemonDataModule {

    private const val BASE_URL = "https://pokeapi.co/api/v2/"

    @Provides
    @Singleton
    fun providePokeApiService(
        retrofitBuilder: Retrofit.Builder
    ): PokeApiService {
        return retrofitBuilder
            .baseUrl(BASE_URL)
            .build()
            .create(PokeApiService::class.java)
    }
}
