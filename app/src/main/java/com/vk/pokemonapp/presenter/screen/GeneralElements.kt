package com.vk.pokemonapp.presenter.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

@Composable
fun AsyncImage(url: String, size:Int = 100) {
    val painter = rememberImagePainter(url)

    Image(
        painter = painter,
        contentDescription = null,
        modifier = Modifier.size(size.dp)
    )
}