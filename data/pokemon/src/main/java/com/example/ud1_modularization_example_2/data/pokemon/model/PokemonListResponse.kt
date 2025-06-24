package com.example.ud1_modularization_example_2.data.pokemon.model

import com.google.gson.annotations.SerializedName

data class PokemonListResponse(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String?,
    @SerializedName("previous")
    val previous: String?,
    @SerializedName("results")
    val results: List<PokemonListItem>,
)

data class PokemonListItem(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String,
) {
    val id get() = url.trimEnd('/').split("/").lastOrNull()?.toIntOrNull()
    val image
        get() =
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${id}.png"
}