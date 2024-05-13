package com.vk.pokemonapp.presenter.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vk.pokemonapp.domain.GetListPokemonUseCase
import com.vk.pokemonapp.network.repository.PokemonListRepository
import com.vk.pokemonapp.presenter.Mappers
import com.vk.pokemonapp.presenter.screen.states.PokemonListUIState
import com.vk.pokemonapp.presenter.utils.LinkMaker
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PokemonListScreenVM(
    val networkUseCase: GetListPokemonUseCase,
    val repository: PokemonListRepository
) : ViewModel() {

    var limit: Int = 50;
    var offset: Int = 0;

    private val _uiState = MutableStateFlow(PokemonListUIState())
    val uiState: StateFlow<PokemonListUIState> = _uiState.asStateFlow()

    fun updatePokemonList(isNew:Boolean = true) {

        if(!isNew) {
            offset = offset + limit
        }
        viewModelScope.launch (Dispatchers.IO)  {
            val data = networkUseCase
                .getPokemonList(
                repository = repository,
                offset = offset, limit = limit
            )
            _uiState.update { currentState ->
                currentState.copy(
                    listPokemon = currentState.listPokemon
                            + Mappers.fromPokemonListModelToListPokemon(data!!)
                )
            }
        }
    }

    fun returnImgLink(id:String) : String {
        return LinkMaker.returnImgLink(id)
    }
}
