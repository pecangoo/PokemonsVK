package com.vk.pokemonapp.network.model

import com.google.gson.annotations.SerializedName


data class PokemonResult(
    val name: String,
    val url: String
)


data class PokemonListModel(
    @SerializedName("count")
    val count:Int,
    val next: String?,
    val previous: String?,
    val results: List<PokemonResult>

)
