package com.vk.pokemonapp.presenter


import android.util.Log
import com.vk.pokemonapp.network.model.PokemonListModel

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

}