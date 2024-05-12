package com.vk.pokemonapp.network.repository

import android.util.Log
import com.vk.pokemonapp.network.model.PokemonInfoModel
import com.vk.pokemonapp.network.model.PokemonListModel
import com.vk.pokemonapp.network.service.NetworkService
import java.io.IOException

class PokemonListRepository {
    val insRetrofit = NetworkService.instance

    fun getList(offset: Int, limit: Int): PokemonListModel? {

        var pokemonListModel:PokemonListModel? = null;
        try {
            val response = insRetrofit.getRetrofit()
                .create(NetworkApi::class.java)
                .getListPokemon(
                    limit = limit,
                    offset = offset
                )

                .execute()
            pokemonListModel =  response.body()
          //  Log.e("111", "Error Response " + response.toString())

        } catch (valf:IOException){
            Log.e("111", "Error Response " + valf.toString())
        }

        return pokemonListModel;
    }

    fun getPokemon(idPokemon:String) :PokemonInfoModel? {

        var pokemonInfoModel: PokemonInfoModel? = null;
        try {
            val response = insRetrofit.getRetrofit()
                .create(NetworkApi::class.java)
                .getPokemon(idPokemon)
                .execute()

            pokemonInfoModel =  response.body()
            Log.e("111", "Error Response " + response.toString())

        } catch (valf:IOException){
            Log.e("111", "Error Response " + valf.toString())
        }
        Log.e("111", pokemonInfoModel.toString())
        return pokemonInfoModel;
    }

}