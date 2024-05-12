package com.vk.pokemonapp.network.model

import android.icu.text.ListFormatter.Width
import com.google.gson.annotations.SerializedName


data class StatResponse(
    @SerializedName("base_stat")
    val baseStat: Int,
    val effort: Int,
    val stat: Stat
)

data class CryResponse(
    val latest: String,
    val legacy: String
)


data class Stat(
    val name: String,
    val url: String
)
data class PokemonInfoModel(
    val stats:List<StatResponse>,
    val cryResponse: CryResponse,
    val id: Int,
    val height:String,
    val width:String,
    val name:String
)
