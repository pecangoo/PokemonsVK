package com.vk.pokemonapp.presenter.vm.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vk.pokemonapp.domain.GetInfoPokemonUseCase
import com.vk.pokemonapp.domain.GetListPokemonUseCase
import com.vk.pokemonapp.network.repository.PokemonListRepository
import com.vk.pokemonapp.presenter.vm.PokemonInfoScreenVM
import com.vk.pokemonapp.presenter.vm.PokemonListScreenVM

class PokemonInfoScreenVMFactory(private val getInfoPokemonUseCase: GetInfoPokemonUseCase,
                                 private  val repository: PokemonListRepository
) : ViewModelProvider.Factory  {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return  PokemonInfoScreenVM(getInfoPokemonUseCase = getInfoPokemonUseCase,
            repository = repository) as T;

    }
}