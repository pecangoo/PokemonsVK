package com.vk.pokemonapp.presenter.screen.states

import com.vk.pokemonapp.presenter.model.PokemonLPNModel

data class PokemonListUIState (
    var listPokemon: List<PokemonLPNModel> = listOf()
)