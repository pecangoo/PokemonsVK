package com.vk.pokemonapp.presenter.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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

   // if (!uiState.loading) {
        Log.e("111", "qwer");
        PokemonCard(uiState.pokemonInfoModel)
    //}

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
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(16.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(100.dp)
                .background(
                    color = Color.LightGray,
                    shape = RoundedCornerShape(50.dp)
                )

        ) {
            AsyncImage(url = LinkMaker.returnImgLink((model?.id!! + 1).toString()))
        }
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = model?.name!!.uppercase(), fontSize = 12.sp)
    }
}
