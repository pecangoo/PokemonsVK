package com.vk.pokemonapp.presenter.vm.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vk.pokemonapp.domain.GetListPokemonUseCase
import com.vk.pokemonapp.domain.GetInfoPokemonUseCase
import com.vk.pokemonapp.network.repository.PokemonListRepository
import com.vk.pokemonapp.presenter.vm.PokemonListScreenVM

class PokemonListScreenVMFactory(private val getListPokemonUseCase: GetListPokemonUseCase,
                                 private  val repository: PokemonListRepository)
    : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return  PokemonListScreenVM(networkUseCase = getListPokemonUseCase,
                repository = repository) as T;
    }
}