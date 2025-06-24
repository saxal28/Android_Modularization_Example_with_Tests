package com.example.ud1_modularization_example_2.data.pokemon.model

import com.google.gson.annotations.SerializedName

data class PokemonDetail(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("height")
    val height: Int,
    @SerializedName("weight")
    val weight: Int,
    @SerializedName("base_experience")
    val baseExperience: Int?,
    @SerializedName("sprites")
    val sprites: PokemonSprites,
    @SerializedName("types")
    val types: List<PokemonType>,
    @SerializedName("stats")
    val stats: List<PokemonStat>,
    @SerializedName("abilities")
    val abilities: List<PokemonAbility>,
)

data class PokemonSprites(
    @SerializedName("front_default")
    val frontDefault: String?,
    @SerializedName("front_shiny")
    val frontShiny: String?,
    @SerializedName("back_default")
    val backDefault: String?,
    @SerializedName("back_shiny")
    val backShiny: String?,
)

data class PokemonType(
    @SerializedName("slot")
    val slot: Int,
    @SerializedName("type")
    val type: PokemonTypeInfo,
)

data class PokemonTypeInfo(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String,
)

data class PokemonStat(
    @SerializedName("base_stat")
    val baseStat: Int,
    @SerializedName("effort")
    val effort: Int,
    @SerializedName("stat")
    val stat: PokemonStatInfo,
)

data class PokemonStatInfo(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String,
)

data class PokemonAbility(
    @SerializedName("is_hidden")
    val isHidden: Boolean,
    @SerializedName("slot")
    val slot: Int,
    @SerializedName("ability")
    val ability: PokemonAbilityInfo,
)

data class PokemonAbilityInfo(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String,
)