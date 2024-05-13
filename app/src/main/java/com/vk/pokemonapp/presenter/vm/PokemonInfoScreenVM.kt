package com.vk.pokemonapp.presenter.vm

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vk.pokemonapp.domain.GetInfoPokemonUseCase
import com.vk.pokemonapp.network.repository.PokemonListRepository
import com.vk.pokemonapp.presenter.screen.states.PokemonInfoUIState
import com.vk.pokemonapp.presenter.screen.states.PokemonListUIState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PokemonInfoScreenVM(
    val getInfoPokemonUseCase: GetInfoPokemonUseCase,
    val repository: PokemonListRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(PokemonInfoUIState())
    val uiState: StateFlow<PokemonInfoUIState> = _uiState.asStateFlow()

    fun getInfoPokemon(id:String) {

        viewModelScope.launch (Dispatchers.IO)  {

            uiState.value.loading = true;
            val data = getInfoPokemonUseCase.getPokemonInfo(repository = repository,
                idPokemon = id)

            _uiState.update {
                 currentState ->
                    currentState.copy(
                        pokemonInfoModel = data,
                        loading = false
                    )
            }


        }
    }
}