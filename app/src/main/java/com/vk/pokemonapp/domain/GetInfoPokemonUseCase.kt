package com.vk.pokemonapp.domain

import com.vk.pokemonapp.network.model.PokemonInfoModel
import com.vk.pokemonapp.network.model.PokemonListModel
import com.vk.pokemonapp.network.repository.PokemonListRepository

class GetInfoPokemonUseCase {

    fun getPokemonInfo(repository: PokemonListRepository, idPokemon:String): PokemonInfoModel? {
        return repository.getPokemon(idPokemon = idPokemon);
    }
}