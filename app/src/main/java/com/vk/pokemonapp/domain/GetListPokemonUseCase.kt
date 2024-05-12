package com.vk.pokemonapp.domain

import android.util.Log
import com.vk.pokemonapp.network.model.PokemonListModel
import com.vk.pokemonapp.network.repository.PokemonListRepository

class GetListPokemonUseCase {

    // Value start
    // Value Step
    //


    fun getPokemonList(repository: PokemonListRepository,
                       offset: Int,
                       limit: Int): PokemonListModel? {
        Log.e("111", "Use Case get Pokemon List")
       return  repository
           .getList(offset = offset, limit = limit)
    }



}