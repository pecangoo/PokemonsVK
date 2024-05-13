package com.vk.pokemonapp.presenter.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.vk.pokemonapp.presenter.vm.PokemonListScreenVM



@Composable
fun PokemonListScreen(listScreenVM: PokemonListScreenVM,
                      onClickNav: (String) -> Unit) {

    val uiState by listScreenVM.uiState.collectAsState()

    var isLoading by remember { mutableStateOf(false) }
    LaunchedEffect(true) {
        listScreenVM.updatePokemonList();
    }
    val items = uiState.listPokemon


    LazyVerticalGrid (columns = GridCells.Fixed(3)){
        items(items.size) { index ->

                Pokemon(
                    text = items[index].name,
                    listScreenVM = listScreenVM,
                    index,
                    onClickNav
                )

            // TODO : Добавить circilar?
            if (index == items.size - 1) {
                if (isLoading) {
                    Text(text = "Loading...")
                } else {
                    LaunchedEffect(true) {
                        listScreenVM.updatePokemonList(isNew = false)
                    }
                }
            }
        }
    }
}


@Composable
fun Pokemon(
    text: String,
    listScreenVM: PokemonListScreenVM,
    index: Int,
    onClickNav: (String) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(16.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.size(100.dp)
                .background(color = Color.LightGray,
                    shape = RoundedCornerShape(50.dp)).clickable {
                        onClickNav("pokemon_info/$index")}
        ) {
            AsyncImage(url = listScreenVM.returnImgLink((index+1).toString()))
        }
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = text.uppercase(), fontSize = 12.sp)
    }
}

