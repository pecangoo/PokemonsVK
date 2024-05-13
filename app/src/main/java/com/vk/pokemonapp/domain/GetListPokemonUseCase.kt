package com.vk.pokemonapp.domain

import android.util.Log
import com.vk.pokemonapp.network.model.PokemonListModel
import com.vk.pokemonapp.network.repository.PokemonListRepository

class GetListPokemonUseCase {


    fun getPokemonList(repository: PokemonListRepository,
                       offset: Int,
                       limit: Int): PokemonListModel? {
       return  repository
           .getList(offset = offset, limit = limit)
    }



}