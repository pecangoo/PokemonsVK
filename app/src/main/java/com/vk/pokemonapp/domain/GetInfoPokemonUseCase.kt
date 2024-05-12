package com.vk.pokemonapp.domain

import com.vk.pokemonapp.network.repository.PokemonListRepository

class GetInfoPokemonUseCase {

    fun getPokemonInfo(repository: PokemonListRepository, idPokemon:String) {
        repository.getPokemon(idPokemon = idPokemon);
    }
}