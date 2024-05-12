package com.vk.pokemonapp.presenter.screen.states

import com.vk.pokemonapp.network.model.PokemonInfoModel

data class PokemonInfoUIState(
    var loading: Boolean = false,
    var pokemonInfoModel: PokemonInfoModel? = null
)