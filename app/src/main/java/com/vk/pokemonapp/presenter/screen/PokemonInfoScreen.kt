package com.vk.pokemonapp.presenter.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vk.pokemonapp.network.model.PokemonInfoModel
import com.vk.pokemonapp.presenter.Mappers
import com.vk.pokemonapp.presenter.utils.LinkMaker
import com.vk.pokemonapp.presenter.vm.PokemonInfoScreenVM
import okhttp3.internal.wait

@Composable
fun PokemonInfoScreen(
    infoScreenVM: PokemonInfoScreenVM,
    id: String?,
) {
    val uiState by infoScreenVM.uiState.collectAsState()

    if (id != null) {
        uiState.loading = true;
        LaunchedEffect(true) {
            infoScreenVM.getInfoPokemon(id)
        }
    } else {

    }

    PokemonCard(uiState.pokemonInfoModel)
}

@Composable
fun PokemonCard(
    model: PokemonInfoModel?,
) {
    if (model == null) {
        Log.e("!11", "Model NULL")

        return
    } else {
        Log.e("!11", "Model not NULL")
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.padding(16.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(300.dp)
                .background(
                    color = Color.Unspecified,
                    shape = RoundedCornerShape(150.dp)
                )

        ) {
            AsyncImage(
                url = LinkMaker.returnImgLink((model?.id!! + 1).toString()),
                size = 300
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = model?.name!!.uppercase(), fontSize = 30.sp)
        PropertyList(model = model)
    }
}


@Composable
fun PropertyList(model: PokemonInfoModel?) {
    if (model == null) return
    val listStat = Mappers.fromPokemonInfoModelToMapStat(model.stats);

        Column() {
            listStat.forEach { item ->
                Row(horizontalArrangement = Arrangement.SpaceAround) {
                    Text(text = "${item.name.uppercase()}: ")
                    Text(text = "${item.base}")
                }


            }
        }


}
