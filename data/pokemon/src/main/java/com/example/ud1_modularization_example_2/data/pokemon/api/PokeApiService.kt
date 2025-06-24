package com.example.ud1_modularization_example_2.data.pokemon.api

import com.example.ud1_modularization_example_2.data.pokemon.model.PokemonDetail
import com.example.ud1_modularization_example_2.data.pokemon.model.PokemonListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApiService {

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int = 20,
        @Query("offset") offset: Int = 0,
    ): PokemonListResponse

    @GET("pokemon/{name}")
    suspend fun getPokemonDetail(
        @Path("name") name: String,
    ): PokemonDetail

    @GET("pokemon/{id}")
    suspend fun getPokemonDetail(
        @Path("id") id: Int,
    ): PokemonDetail
}