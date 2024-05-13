package com.vk.pokemonapp.presenter


import com.vk.pokemonapp.network.model.PokemonListModel
import com.vk.pokemonapp.network.model.StatResponse
import com.vk.pokemonapp.presenter.model.PokemonLPNModel
import com.vk.pokemonapp.presenter.model.StatSimpleModel


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

    fun fromPokemonInfoModelToMapStat(listStat: List<StatResponse>):
            MutableList<StatSimpleModel>  {

        var resList:MutableList<StatSimpleModel> =  mutableListOf();

       // var resMap:MutableMap<String, String> = mutableMapOf();
//        listStat.all { item ->
//            resList.add(StatSimpleModel(name = item.stat.name,
//                base = item.baseStat))
//        }


        listStat.all { item ->
            resList.add(StatSimpleModel(name = item.stat.name,
                base = item.baseStat))
        }
        return resList;
    }

}