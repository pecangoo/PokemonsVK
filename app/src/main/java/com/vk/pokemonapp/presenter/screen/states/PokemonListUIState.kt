package com.vk.pokemonapp.presenter.screen.states

import com.vk.pokemonapp.presenter.model.PokemonLPNModel

data class PokemonListUIState (
    var error:Boolean = false,
    var listPokemon: List<PokemonLPNModel> = listOf()
)