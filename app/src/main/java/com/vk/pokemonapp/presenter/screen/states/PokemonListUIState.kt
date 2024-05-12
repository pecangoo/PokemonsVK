package com.vk.pokemonapp.presenter.screen.states

import com.vk.pokemonapp.presenter.PokemonLPNModel

data class PokemonListUIState (
    var loading:Boolean = false,
    var error:Boolean = false,
    var listPokemon: List<PokemonLPNModel> = listOf()
)