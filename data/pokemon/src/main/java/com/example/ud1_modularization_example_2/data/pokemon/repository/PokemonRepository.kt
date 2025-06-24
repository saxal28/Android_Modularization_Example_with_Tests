package com.example.ud1_modularization_example_2.data.pokemon.repository

import com.example.ud1_modularization_example_2.data.pokemon.api.PokeApiService
import com.example.ud1_modularization_example_2.data.pokemon.model.PokemonDetail
import com.example.ud1_modularization_example_2.data.pokemon.model.PokemonListResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonRepository @Inject constructor(
    private val apiService: PokeApiService,
) {

    suspend fun getPokemonList(limit: Int = 20, offset: Int = 0): Result<PokemonListResponse> {
        return try {
            val response = apiService.getPokemonList(limit, offset)
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getPokemonDetail(name: String): Result<PokemonDetail> {
        return try {
            val response = apiService.getPokemonDetail(name)
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getPokemonDetail(id: Int): Result<PokemonDetail> {
        return try {
            val response = apiService.getPokemonDetail(id)
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
