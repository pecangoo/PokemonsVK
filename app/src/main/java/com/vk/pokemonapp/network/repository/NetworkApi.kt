package com.vk.pokemonapp.network.repository

import com.vk.pokemonapp.network.model.PokemonInfoModel
import com.vk.pokemonapp.network.model.PokemonListModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface  NetworkApi {

    @GET("pokemon")
    fun getListPokemon(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Call<PokemonListModel>



    @GET("pokemon/{pokemonId}")
    fun getPokemon(
        @Path("pokemonId") pokemonId: String
    ): Call<PokemonInfoModel>
}