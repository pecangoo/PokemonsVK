package com.vk.pokemonapp.presenter


import com.vk.pokemonapp.network.model.PokemonListModel
import com.vk.pokemonapp.presenter.model.PokemonLPNModel

object Mappers {
    fun fromPokemonListModelToListPokemon(listModel: PokemonListModel)
            : List<PokemonLPNModel> {
        var listPokemon: MutableList<PokemonLPNModel> = mutableListOf();

        listModel.results.all { item ->
            listPokemon.add(
                PokemonLPNModel(
                    link = item.url,
                    picture = "",
                    name = item.name
                )
            )
        }
        return listPokemon;
    }

//    fun fromPokemonInfoModelToPokemonInfo()  {
//
//    }

}